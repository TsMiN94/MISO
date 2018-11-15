package miso.component.pref;

import com.jfoenix.controls.JFXButton;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyEvent;
import miso.utility.Scope;
import miso.views.KeyboardView;

public class TextDragButton extends JFXButton {

	public TextDragButton() {

		addEventHandler(ActionEvent.ACTION, e -> {
			Scope.getInstace().getPrefInfo().setKeySet(true);

			Platform.runLater(new Runnable() {
				
				@Override
				public void run() {
					Scope.getInstace().getKeyboardStage().show();
					
				}
			});
		});
	}

}
