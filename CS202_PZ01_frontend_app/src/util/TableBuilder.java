package util;

import java.util.Collection;

import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableBuilder<T> {
	private TableView<T> tableView;
	private String placeholder = "No Rows";
	
	public TableBuilder() {
		this.tableView = new TableView<>();
	}
	
	public TableBuilder(String placeholder) {
		this();
		this.placeholder = placeholder;
		this.tableView.setPlaceholder(new Label(this.placeholder));
	}
	
	public <E> TableBuilder<T> addColumn(String name, String value) {
		TableColumn<T, E> column = new TableColumn<>(name);
		column.setCellValueFactory(new PropertyValueFactory<>(value));
		this.tableView.getColumns().add(column);
		return this;
	}
	
	public TableBuilder<T> setSingleSelect() {
		this.tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		return this;
	}
	
	public TableBuilder<T> setMultipleSelect() {
		this.tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		return this;
	}
	
	public TableBuilder<T> add(T obj) {
		this.tableView.getItems().add(obj);
		return this;
	}
	
	public TableBuilder<T> addAll(Collection<? extends T> c) {
		this.tableView.getItems().addAll(c);
		return this;
	}
	
	public TableBuilder<T> addAll(T[] c) {
		for(T item : c) this.tableView.getItems().add(item);
		return this;
	}
	
	public TableView<T> build() {
		return tableView;
	}
}
