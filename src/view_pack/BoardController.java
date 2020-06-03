package view_pack;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class BoardController implements Initializable {
	@FXML TableView<Board> tableView;
	@FXML TextField txtTitle;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		tableView.setItems(FXCollections.observableArrayList(
				
				new Board("제목1"),
				new Board("제목2"),
				new Board("제목3")
				));
		TableColumn<Board, ?> tcTitle = tableView.getColumns()
		//Bindings.bindBidirectional(tableView.accessibleTextProperty(), txtTitle.textProperty());
		
	}
	
}
