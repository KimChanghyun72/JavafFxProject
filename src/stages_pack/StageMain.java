package stages_pack;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//Root.fxml
//AddForm.fxml
//ScoreChart.fxml
//StageController.java
public class StageMain extends Application {

	@Override
	public void start(Stage stage) throws Exception {//stage=MainBuilder
		Parent root = FXMLLoader.load(getClass().getResource("Root.fxml"));//정적 컨테이너에 loader호출
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		//FXMLLoader loader = new FXMLLoader();//클래스 인스턴스를 만들어서 loader호출
		//Parent root = loader.load(getClass().getResource("Root.fxml"));
		
		//Controller 에 stage값을 넘겨준다.
		//StageController cont = loader.getController();//fxml의 컨트롤러 호출
		//cont.setPrimaryStage(stage);
		
//		Scene scene = new Scene(root);
//				stage.setScene(scene);
//				stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
