package media_pack;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//MediaControl.fxml
//MediaController.java
public class MediaMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("MediaControl.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("너무어렵다 자고십파");
	}
	public static void main(String[] args) {
		launch(args);
	}
	
}
