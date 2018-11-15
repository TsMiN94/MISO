package miso.component.pref;

import com.jfoenix.controls.JFXButton;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import miso.utility.Scope;

public class ScanButton extends JFXButton{
	public ScanButton() {
		addEventHandler(ActionEvent.ACTION, e -> {
			Scope.getInstace().getPrefInfo().setOcrSet(true);

			Platform.runLater(new Runnable() {
				
				@Override
				public void run() {
					Scope.getInstace().getKeyboardStage().show();
				}
			});
		});
	}
}
