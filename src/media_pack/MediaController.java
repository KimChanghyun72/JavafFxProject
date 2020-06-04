package media_pack;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class MediaController implements Initializable {
	@FXML ImageView imageView;
	@FXML MediaView mediaView;
	@FXML Button btnPlay, btnStop, btnPause;
	@FXML Label labelTime;
	@FXML ProgressBar progressBar;
	@FXML ProgressIndicator progressIndicator;
	@FXML Slider sliderVolume;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Media media = new Media(getClass().getResource("/medias/video.m4v").toString());
		//toString없으면 url유형으로 인식하는구나.
		MediaPlayer player = new MediaPlayer(media);
		mediaView.setMediaPlayer(player);
		
		player.setOnReady(new Runnable() {//준비가 되었을 때 처리해야 할 내용.

			@Override
			public void run() {
				
				btnPlay.setDisable(false);//준비일때 시작버튼은 사용가능
				btnStop.setDisable(true);//스탑, 퍼즈 버튼은 사용 불가능.
				btnPause.setDisable(true);
			}
			
		});
		
		player.setOnPlaying(new Runnable() {//플레이상태

			@Override
			public void run() {
				btnPlay.setDisable(true);
				btnStop.setDisable(false);
				btnPause.setDisable(false);
				
				player.currentTimeProperty().addListener(new ChangeListener<Duration>() {

					@Override
					public void changed(ObservableValue<? extends Duration> observable, Duration oldVal, Duration newVal) {
						double progress = player.getCurrentTime().toMinutes();
						player.getTotalDuration().toSeconds();
						progressBar.setProgress(progress);
						progressIndicator.setProgress(progress);
					}
					
				});
			}
			
		});
		
		player.setOnPaused(new Runnable() {//중지상태

			@Override
			public void run() {
				btnPlay.setDisable(false);
				btnStop.setDisable(false);
				btnPause.setDisable(true);
			}
			
		});
		
		player.setOnEndOfMedia(new Runnable() {//다들었을때

			@Override
			public void run() {
				player.stop();
				
				btnPlay.setDisable(false);
				btnStop.setDisable(true);
				btnPause.setDisable(true);
			}
			
		});
		
		player.setOnStopped(new Runnable() {//스탑눌렀을때

			@Override
			public void run() {
				btnPlay.setDisable(false);
				btnStop.setDisable(true);
				btnPause.setDisable(true);
			
			}
			
		});
		
		btnPlay.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				player.play();
			}
			
		});
		btnStop.setOnAction((e)-> player.stop());
		btnPause.setOnAction((e)-> player.pause());
		
	
	}//end of initialize()

}//end of class
