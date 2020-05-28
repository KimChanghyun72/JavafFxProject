package fxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AppRoot extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Root.fxml"));//getClass()->현재 진행되는 런타임 클래스
		//HBox root = FXMLLoader.load(getClass().getResource("../control/Root.fxml"));->다른 클래스에 fxml파일이 있을때는 절대경로 적어주기
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("FXML sample");
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}//end of main

}//end of class
