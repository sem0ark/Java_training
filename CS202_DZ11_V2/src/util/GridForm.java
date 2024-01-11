package util;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class GridForm extends GridPane {
	private TextField[] inputs;
	private boolean required_fields;
	
	public void addForm(String[] labels, String btn_text, EventHandler<ActionEvent> e) {
		this.inputs = new TextField[labels.length];
		
		for(int i=0; i<labels.length; i++)
			this.inputs[i] = Factory.addLabeledTextInput(this, labels[i], i, "0.0", null);
		
		Button btn = new Button(btn_text);
		btn.setOnAction(e);
		
		this.addRow(labels.length, btn);
	}
	
	public TextField getInput(int i) {
		assert i >= 0 && i < this.inputs.length : "Have only same number of inputs as labels";
		return this.inputs[i];
	}
	
	public void setRequired(boolean r) {
		this.required_fields = r;
	}
	
	public String[] getValues() {
		String[] v = new String[this.inputs.length];
		
		for(int i=0; i<this.inputs.length; i++) {
			v[i] = this.inputs[i].getText().strip();
			assert !this.required_fields || v[i] != "" : "Can't allow empty fields";
		}
		
		return v;
	}
}
