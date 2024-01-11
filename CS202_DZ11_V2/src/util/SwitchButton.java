package util;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class SwitchButton extends Button {
	private int text_index = 0;
	private final String[] texts;
	
	SwitchButton(String[] texts, final EventHandler<ActionEvent> handler) {
		this.texts = texts;

		System.out.println("Updated text");
		this.setOnAction(e -> {
			this.updateText();
			handler.handle(e);
		});
	}
	
	private void updateText() {
		this.text_index = (this.text_index + 1) % this.texts.length;
		this.setText(this.texts[this.text_index]);
	}
}
