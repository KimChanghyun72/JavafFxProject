package view_pack;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
//tableview에는 제목과 종료일자만 노출.
import javafx.util.Callback;
public class BoardController implements Initializable {
	Connection conn;
	
	@FXML TableView<Board> tableView;
	@FXML TextField txtTitle;
	@FXML ComboBox comboPublic;
	@FXML TextField dateExit;
	@FXML TextArea txtContent;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection(url, "hr","hr");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ObservableList<Board> boardList = getBoardList();//FXCollections.observableArrayList();
		//boardList.add(new Board("test", "1234", "공개", "2020/05/05","내용"));
		//title
		TableColumn<Board, String> tcTitle = new TableColumn<Board, String>();//여기부터 해석 필요해.
		tcTitle.setCellValueFactory(new Callback<CellDataFeatures<Board, String>, ObservableValue<String>>(){
			//첫번째는 인풋, 두번째는 리턴 타입
			@Override
			public ObservableValue<String> call(CellDataFeatures<Board, String> param) {
				return param.getValue().titleProperty();
			}
			
		});
		tcTitle.setText("제목");
		
		//exitDate
		TableColumn<Board, String> tcExitDate = new TableColumn<>();
		tcExitDate.setCellValueFactory(new PropertyValueFactory<Board, String>("exitDate"));
		tcExitDate.setText("종료일자");
		
		tableView.getColumns().add(tcTitle);
		tableView.getColumns().add(tcExitDate);
		
		
		tableView.setItems(boardList);
		
		tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Board>() {

			@Override
			public void changed(ObservableValue<? extends Board> observable, Board oldVal, Board newVal) {
				txtTitle.setText(newVal.getTitle());
				comboPublic.setValue(newVal.getPublicity());//setCellFactory(new PropertyValueFactory(newVal.getPublicity()));
				dateExit.setText(newVal.getExitDate());
				txtContent.setText(newVal.getContent());
				
				//이전, 다음버튼 추가해서 다음 버튼 누르면 다음값, 이전누르면 이전값.
				//제목 넣으면 제목기준으로 같은 제목의 내용을 수정 버튼(수정누르면 수정가능? 수정한뒤 수정버튼 누르면 수정 적용?) 추가해서 출력된 내용을 내가 입력해서 수정하는 것.
			}
			
		});
		}
		
		
		//TableColumn<Board, ?> tcTitle = tableView.getColumns()
		//Bindings.bindBidirectional(tableView.accessibleTextProperty(), txtTitle.textProperty());
		
	public ObservableList<Board> getBoardList(){
		ObservableList<Board> list = FXCollections.observableArrayList();
		String sql = "select title, publicity, exit_date, content from board";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();//resultset은 무슨 기능이지?
			while(rs.next()) {
				Board board = new Board(rs.getString("title"),null, rs.getString("publicity"), rs.getString("exit_date"), rs.getString("content"));
			list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}//end of getBoardList();
	}//end of class
	

