package util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

public class SimplePieChart extends PieChart {
	public SimplePieChart(String[] names, double[] values, String title) {
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
		
		for(int i=0; i<names.length; i++)
			pieChartData.add(new PieChart.Data(names[i], values[i]));
		
		this.setData(pieChartData);

        this.setTitle(title);
	}
	
	public PieChart.Data getDataValue(int i) {
		return this.getData().get(i);
	}
	
	public void setName(int i, String newName) {
		this.getData().get(i).setName(newName);
	}
	
	public void setValue(int i, double newValue) {
		this.getData().get(i).setPieValue(newValue);
	}
}
