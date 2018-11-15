package miso.component.pref;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;

public class VirtualKey extends JFXButton {
	private boolean clicked = false;

	public VirtualKey() {
		
	}

	public boolean isClicked() {
		return clicked;
	}

	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}
	
}
