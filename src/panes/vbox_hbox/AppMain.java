package panes.vbox_hbox;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Root.fxml"));
		Scene scene = new Scene(root);
		//ImageView imageview = new ImageView(); 
		primaryStage.setTitle("VBox HBox 예제");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}//ui 구현
	public static void main(String[] args) {
		launch(args);
		
	}//end of main

}//end of class