package fxml;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class AppMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(10));
		hbox.setSpacing(10);
		
		TextField textField = new TextField();
		textField.setPrefWidth(200);
		
		Button button = new Button();
		button.setText("확인");
		button.setOnAction(event->Platform.exit());
		
		ObservableList list = hbox.getChildren();
		list.add(textField);
		list.add(button);
		//위아래는 같은 내용. box의 세부내용은 observableList 형식으로 구성되어있음을 알 수 있다.
//		hbox.getChildren().add(textField);
//		hbox.getChildren().add(button);
		
		Scene scene = new Scene(hbox);
		
		primaryStage.setTitle("AppMain");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
