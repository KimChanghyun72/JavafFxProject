package com.yedam.test;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



public class BookController implements Initializable {
	@FXML Button btnAdd, btnChart;
	@FXML TableView<Book> tableView, tableView2;
	
	ObservableList<Book> bookList;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		bookList = FXCollections.observableArrayList();
		
		btnAdd.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				buttonAddAction(event);
			}
			
		});
		
		btnChart.setOnAction(new EventHandler<ActionEvent>(){ 

		@Override
		public void handle(ActionEvent event) {
			buttonChartAction(event);
		}
		});
		
		
		
		TableColumn<Book, ?> tcCode = tableView.getColumns().get(0);
		tcCode.setCellValueFactory(new PropertyValueFactory("bookCode"));
		TableColumn<Book, ?> tcName = tableView.getColumns().get(1);
		tcName.setCellValueFactory(new PropertyValueFactory("bookName"));
		TableColumn<Book, ?> tcWriter = tableView.getColumns().get(2);
		tcWriter.setCellValueFactory(new PropertyValueFactory("bookWriter"));
		TableColumn<Book, ?> tcPrice = tableView.getColumns().get(3);
		tcPrice.setCellValueFactory(new PropertyValueFactory("bookPrice"));
		TableColumn<Book, ?> tcCount = tableView.getColumns().get(4);
		tcCount.setCellValueFactory(new PropertyValueFactory("sellCount"));
		
		tableView.setItems(bookList);
		
		tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
		
		public void handle(MouseEvent event) {
			if (event.getClickCount() == 2) {//더블클릭.
				Stage chartStage = new Stage(StageStyle.UTILITY);
				chartStage.initModality(Modality.WINDOW_MODAL);//modal타입 윈도우가 실행되려면 주인 윈도우 필요.
				//chartStage.initOwner(primaryStage);
				chartStage.initOwner(tableView.getScene().getWindow());
				
			
					try {
						Parent parent = FXMLLoader.load(getClass().getResource("UpdateBook.fxml"));
						tableView2 = (TableView<Book>) parent.lookup("#tableView");
						
						TableColumn<Book, ?> tcName = tableView2.getColumns().get(0);
						tcName.setCellValueFactory(new PropertyValueFactory("bookName"));
						TableColumn<Book, ?> tcWriter = tableView2.getColumns().get(1);
						tcWriter.setCellValueFactory(new PropertyValueFactory("bookWriter"));
						TableColumn<Book, ?> tcPrice = tableView2.getColumns().get(2);
						tcPrice.setCellValueFactory(new PropertyValueFactory("bookPrice"));
						TableColumn<Book, ?> tcCount = tableView2.getColumns().get(3);
						tcCount.setCellValueFactory(new PropertyValueFactory("sellCount"));
						
						tableView2.setItems(bookList);
						
						tableView2.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Book>() {

							@Override
							public void changed(ObservableValue<? extends Book> arg0, Book oldVal, Book newVal) {
								
								tcName.setText(newVal.getBookName());
								//tcCount.setText(newVal.getSellCount());
							}
							
						});
						
						Scene scene = new Scene(parent);
						chartStage.setScene(scene);
						chartStage.show();
						chartStage.setResizable(false);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
			
			} else {
				return;
			}
		}
	});
		
	
	}//end of Initialize
	

	public void buttonAddAction(ActionEvent ae) {
		Stage addStage = new Stage(StageStyle.UTILITY);
		addStage.initModality(Modality.WINDOW_MODAL);
		addStage.initOwner(btnAdd.getScene().getWindow());
		
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("AddBook.fxml"));
			Scene scene = new Scene(parent);
			addStage.setScene(scene);
			addStage.setResizable(false);
			addStage.show();
			
			Button btnFormAdd = (Button)parent.lookup("#btnFormAdd");
			btnFormAdd.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					TextField txtCode = (TextField)parent.lookup("#txtCode");
					TextField txtName = (TextField)parent.lookup("#txtName");
					TextField txtWriter = (TextField)parent.lookup("#txtWriter");
					TextField txtPrice = (TextField)parent.lookup("#txtPrice");
					TextField txtCount = (TextField)parent.lookup("#txtCount");
					Book book = new Book(txtCode.getText(), 
							txtName.getText(),
							txtWriter.getText(),
							Integer.parseInt(txtPrice.getText()),
							Integer.parseInt(txtCount.getText())
						);
					bookList.add(book);
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
		
			XYChart.Series<String, Integer> seriesPrice
				=new XYChart.Series<String, Integer>();
			ObservableList<XYChart.Data<String, Integer>> datasPrice = FXCollections.observableArrayList();
			for(int i=0; i<bookList.size(); i++) {
				datasPrice.add(new XYChart.Data(bookList.get(i).getBookName(), bookList.get(i).getBookPrice()));
			}
			seriesPrice.setData(datasPrice);
			
			XYChart.Series<String, Integer> seriesCount
			=new XYChart.Series<String, Integer>();
			ObservableList<XYChart.Data<String, Integer>> datasCount = FXCollections.observableArrayList();
			for(int i=0; i<bookList.size(); i++) {
				datasPrice.add(new XYChart.Data(bookList.get(i).getBookName(), bookList.get(i).getSellCount()));
			}
			seriesCount.setData(datasCount);

			
			barChart.setData(FXCollections.observableArrayList(seriesPrice, seriesCount));
		
	
			Scene scene = new Scene(parent);
			chartStage.setScene(scene);
			chartStage.show();
			chartStage.setResizable(true);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}//end of class


//문제4 리스트 더블클릭 시 수정화면을 보여주시고 변경된 정보를 저장하는 기능을 작성하세요.
//-수정화면정보 : 도서명, 저자, 금액, 판매량, 수정버튼, 닫기버튼
//updatebook.fxml
