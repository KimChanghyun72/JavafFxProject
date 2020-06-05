package stages_pack;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StageController implements Initializable {
	@FXML TableView<Student> tableView;
	@FXML Button btnAdd, btnChart;
	
	ObservableList<Student> scores;
	
//	Stage primaryStage;
//	void setPrimaryStage(Stage primaryStage) {
//		this.primaryStage = primaryStage;
//	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//btnAdd.setOnAction(e->buttonAddAction(e));//람다식
		
		scores = FXCollections.observableArrayList();
		
		btnAdd.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				buttonAddAction(arg0);
			}
			
		});
		
		
		
		btnChart.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				buttonChartAction(arg0);
			}
			
		});
		
		
		
		
		TableColumn<Student, ?> tcName = tableView.getColumns().get(0);
		tcName.setCellValueFactory(new PropertyValueFactory("name"));//이 두개 기능 찾아보기.
		TableColumn<Student, ?> tcKorean = tableView.getColumns().get(1);
		tcKorean.setCellValueFactory(new PropertyValueFactory("korean"));//이 두개 기능 찾아보기.
		TableColumn<Student, ?> tcMath = tableView.getColumns().get(2);
		tcMath.setCellValueFactory(new PropertyValueFactory("math"));//이 두개 기능 찾아보기.
		TableColumn<Student, ?> tcEnglish = tableView.getColumns().get(3);
		tcEnglish.setCellValueFactory(new PropertyValueFactory("english"));//이 두개 기능 찾아보기.
		
		
		tableView.setItems(scores);
	}
	
	public void buttonAddAction(ActionEvent ae) {
		Stage addStage = new Stage(StageStyle.UTILITY);
		addStage.initModality(Modality.WINDOW_MODAL);//이건 뭐지?여기서 열거형이라는 단어가 나왔는데 이건 뭐지?
		addStage.initOwner(btnAdd.getScene().getWindow());//이것도 기능 찾아봐.
		
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("AddForm.fxml"));
			Scene scene = new Scene(parent);
			addStage.setScene(scene);
			addStage.setResizable(false);
			addStage.show();
			
			Button btnFormAdd = (Button)parent.lookup("#btnFormAdd");
			btnFormAdd.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					TextField txtName = (TextField)parent.lookup("#txtName");//부모 클래스가 자식 클래스로 바뀌려면 캐스팅이 필요
					TextField txtKorean = (TextField)parent.lookup("#txtKorean");
					TextField txtMath = (TextField)parent.lookup("#txtMath");
					TextField txtEnglish = (TextField)parent.lookup("#txtEnglish");
					Student student = new Student(txtName.getText(), 
							Integer.parseInt(txtKorean.getText()),
							Integer.parseInt(txtMath.getText()),
							Integer.parseInt(txtEnglish.getText())
						);
					scores.add(student);
					addStage.close();
				}
				
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void buttonChartAction(ActionEvent ae) {
		Stage chartStage = new Stage(StageStyle.UTILITY);
		chartStage.initModality(Modality.WINDOW_MODAL);//modal타입 윈도우가 실행되려면 주인 윈도우 필요.
		//chartStage.initOwner(primaryStage);
		chartStage.initOwner(btnChart.getScene().getWindow());
		
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("ScoreChart.fxml"));
			BarChart barChart = (BarChart) parent.lookup("#barChart");//lookup?
		
			XYChart.Series<String, Integer> seriesKorean
				=new XYChart.Series<String, Integer>();
			ObservableList<XYChart.Data<String, Integer>> datasKorean = FXCollections.observableArrayList();
			for(int i=0; i<scores.size(); i++) {
				datasKorean.add(new XYChart.Data(scores.get(i).getname(), scores.get(i).getKorean()));
				//datasKorean.add(scores.get(i).getname(), scores.get(i).getKorean());
				//"이름", 국어점수
			}
			seriesKorean.setData(datasKorean);
			//seriesKorean.setData(XYChart.Data<String, Integer>());
			//barChart.setData(FXCollections.observableArrayList(seriesKorean));
			//barChart.setData(seriesKorean);->오류상황
			//->자료 담을 datasKorean, 이걸 xychart 객체인 seriesKorean에 담고, 담은 걸 barChart에 어레이리스트형으로 셋 해줬다?
			//series에 담을 datacollection datas생성, datas에 자료를 담아 이걸 series에 담음. series를 barchart에 담음.
			
			XYChart.Series<String, Integer> seriesMath
			=new XYChart.Series<String, Integer>();
		ObservableList<XYChart.Data<String, Integer>> datasMath = FXCollections.observableArrayList();
		for(int i=0; i<scores.size(); i++) {
			datasMath.add(new XYChart.Data(scores.get(i).getname(), scores.get(i).getMath()));
			
		}
		seriesMath.setData(datasMath);
		//barChart.setData(FXCollections.observableArrayList(seriesMath));
		
		XYChart.Series<String, Integer> seriesEnglish
		=new XYChart.Series<String, Integer>();
	ObservableList<XYChart.Data<String, Integer>> datasEnglish = FXCollections.observableArrayList();
	for(int i=0; i<scores.size(); i++) {
		datasEnglish.add(new XYChart.Data(scores.get(i).getname(), scores.get(i).getEnglish()));
		
	}
	seriesEnglish.setData(datasEnglish);
	barChart.setData(FXCollections.observableArrayList(seriesKorean, seriesMath, seriesEnglish));
		
	
			Scene scene = new Scene(parent);
			chartStage.setScene(scene);
			chartStage.show();
			chartStage.setResizable(false);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
