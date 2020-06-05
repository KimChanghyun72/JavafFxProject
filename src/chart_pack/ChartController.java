package chart_pack;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;

public class ChartController implements Initializable {
	
	@FXML PieChart pieChart;
	@FXML BarChart<String, Integer> barChart;
	//없어도 에러나지는 않지만 string, integer값을 쓰는 차트이기 때문에 제네릭을 붙여주면 좋다.
	@FXML AreaChart<String, Integer> areaChart;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		pieChart.setData(FXCollections.observableArrayList(
				new PieChart.Data("AWT", 20.0),
				new PieChart.Data("Swing", 40.0),
				new PieChart.Data("SWT", 25.0),
				new PieChart.Data("JavaFX", 55.0)//전체 대비 퍼센티지 넣는 기능 없음?
				));
		XYChart.Series<String, Integer> series1 = new Series<>();
		series1.setData(FXCollections.observableArrayList(
				new XYChart.Data("2015", 70),
				new XYChart.Data("2016", 40),
				new XYChart.Data("2017", 50),
				new XYChart.Data("2018", 30)
				));
		series1.setName("Cat1");
		//ObservableList<Series<String,Integer>>
		//barChart.setData(ObservableList<Series<String, Integer>>);
		//barChart.setData(FXCollections.observableArrayList(series1));
		
		XYChart.Series<String, Integer> series2 = new Series<>();
		series2.setData(FXCollections.observableArrayList(
				new XYChart.Data("2015", 30),
				new XYChart.Data("2016", 50),
				new XYChart.Data("2017", 10),
				new XYChart.Data("2018", 60)
				));
		series2.setName("Cat2");
		
		barChart.setData(FXCollections.observableArrayList(series1, series2));
		
		XYChart.Series<String, Integer> series3 = new Series<>();
		series3.setData(FXCollections.observableArrayList(
				new XYChart.Data("2015", 30),
				new XYChart.Data("2016", 50),
				new XYChart.Data("2017", 10),
				new XYChart.Data("2018", 60)
				));
		series3.setName("Cat3");
		
		areaChart.setData(FXCollections.observableArrayList(series3));
	}

}
