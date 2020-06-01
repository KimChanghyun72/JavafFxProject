package fxml;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class AppMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(10));
		hbox.setSpacing(10);
		hbox.setPrefSize(700, 300);

		TextField textField = new TextField();
		textField.setPrefWidth(200);
		textField.setPrefHeight(100);

		Button button = new Button();
		button.setText("확인");
		button.setPrefSize(100, 100);
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				textField.setText("확인을 눌렀습니다.");
			}
		});

		Button button1 = new Button();
		button1.setText("취소");
		button1.setPrefSize(100, 100);
		button1.setOnAction(new EventHandler<ActionEvent>() {//이 구문의 이해가 완전히 안 됐어.
			@Override
			public void handle(ActionEvent event) {
				textField.setText(null);				
			}	 		
		});
		//button1.setOnAction(event -> Platform.exit());

		ObservableList list = hbox.getChildren();
		list.add(textField);
		list.add(button);
		list.add(button1);
		//위아래는 같은 내용. box의 세부내용은 observableList 형식으로 구성되어있음을 알 수 있다.
		//		hbox.getChildren().add(textField);
		//		hbox.getChildren().add(button);

		Scene scene = new Scene(hbox);

		primaryStage.setTitle("AppMain");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				System.out.println(event);
				
			}
			
		});
	}

	public static void main(String[] args) {
		launch(args);
	}

}
