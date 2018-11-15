package miso.hook;

import java.util.Vector;

import com.jfoenix.controls.JFXButton;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.effect.Shadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import lc.kra.system.keyboard.event.GlobalKeyEvent;
import miso.actions.keyboard.TransFormat;
import miso.component.pref.VirtualKey;
import miso.resource.InputVirtualKeys;
import miso.utility.Scope;
import miso.views.HotKeySettingView;

public class MISOKeyHook extends KeyHook {

	@Override
	public void keyPressedAction(GlobalKeyEvent event) {
		if (Scope.getInstace().getPrefInfo().isKeySet()) {

			Vector<Integer> hot = Scope.getInstace().getPrefInfo().getHotkey();
			Vector<Integer> set = Scope.getInstace().getPrefInfo().getSetKey();
			Vector<Boolean> setBool = Scope.getInstace().getPrefInfo().getSetkeyBool();

			if (set.size() == 0) {
				set.add(event.getVirtualKeyCode());
				setBool.add(false);
			}
			if (set.size() < 3) {
				for (int i = 0; i < set.size(); i++) {
					if (!set.get(i).equals(event.getVirtualKeyCode())) {
						set.add(event.getVirtualKeyCode());
						setBool.add(false);
						break;
					}
				}
			}
			return;
		}

		if(Scope.getInstace().getPrefInfo().isOcrSet()) {
			
			
		}
		Vector<Integer> hotkey = Scope.getInstace().getPrefInfo().getHotkey();
		Vector<Boolean> hotbool = Scope.getInstace().getPrefInfo().getHotkeybool();
		switch (hotkey.size()) {
		case 1:
			if (event.getVirtualKeyCode() == hotkey.get(0)) {
				hotbool.set(0, true);
			}
			break;
		case 2:
			if (event.getVirtualKeyCode() == hotkey.get(0)) {
				hotbool.set(0, true);
			} else {
				hotbool.set(1, true);
			}
			break;
		case 3:
			if (event.getVirtualKeyCode() == hotkey.get(0)) {
				hotbool.set(0, true);
			} else if (event.getVirtualKeyCode() == hotkey.get(1)) {
				hotbool.set(1, true);
			} else {
				hotbool.set(2, true);
			}
			break;
		}

		// TODO OCR
		if (Scope.getInstace().getPrefInfo().getOcrKey() == event.getVirtualKeyCode()
				&& !Scope.getInstace().isOcrFlag()) {
			ocrHookAction();
			Scope.getInstace().setOcrFlag(true);
		}
	}

	@Override
	public void keyReleasedAction(GlobalKeyEvent event) {
		if (Scope.getInstace().getPrefInfo().isKeySet()) {
			Vector<Integer> hot = Scope.getInstace().getPrefInfo().getHotkey();
			Vector<Integer> set = Scope.getInstace().getPrefInfo().getSetKey();
			Vector<Boolean> hotBool = Scope.getInstace().getPrefInfo().getHotkeybool();
			Vector<Boolean> setBool = Scope.getInstace().getPrefInfo().getSetkeyBool();

			switch (Scope.getInstace().getPrefInfo().getSetKey().size()) {
			case 1:
				if (set.get(0).equals(event.getVirtualKeyCode())) {
					setBool.set(0, true);
				}
				break;
			case 2:
				if (set.get(0).equals(event.getVirtualKeyCode())) {
					setBool.set(0, true);
				}
				if (set.get(1).equals(event.getVirtualKeyCode())) {
					setBool.set(1, true);
				}
				break;
			case 3:
				if (set.get(0).equals(event.getVirtualKeyCode())) {
					setBool.set(0, true);
				}
				if (set.get(1).equals(event.getVirtualKeyCode())) {
					setBool.set(1, true);
				}
				if (set.get(2).equals(event.getVirtualKeyCode())) {
					setBool.set(2, true);
				}
				break;
			}

			String data = "";
			HotKeySettingView settingView = Scope.getInstace().getHotKeySettingView();
			AnchorPane hotAncPane = (AnchorPane) settingView.getBorder().getCenter();
			Pane hotPane = (Pane) hotAncPane.getChildren().get(0);
			

			ObservableList<Node> hotNodeList = hotPane.getChildren();
		
			Text hotkey = (Text) hotNodeList.get(0);
			
			for (int i = 0; i < set.size(); i++) {
				data += TransFormat.getInstance().getVirtualChar(set.get(i));
				if (i < set.size() - 1) {
					data += "+";
				}
			}

			hotkey.setText(data);
			
			hot.clear();
			hotBool.clear();
			
			for (int i = 0; i < set.size(); i++) {
				hot.add(set.get(i));
				hotBool.add(false);
			}
			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					Scope.getInstace().getKeyboardStage().hide();
				}
			});
			Platform.setImplicitExit(false);
			set.clear();
			setBool.clear();
			Scope.getInstace().getPrefInfo().setKeySet(false);
		}
		
		
		if(Scope.getInstace().getPrefInfo().isOcrSet()) {
			HotKeySettingView settingView = Scope.getInstace().getHotKeySettingView();
			AnchorPane hotAncPane = (AnchorPane) settingView.getBorder().getCenter();
			Pane ocrPane = (Pane) hotAncPane.getChildren().get(2);
			ObservableList<Node> ocrNodeList = ocrPane.getChildren();
			Text ocrkey = (Text) ocrNodeList.get(0);
			
			ocrkey.setText(TransFormat.getInstance().getVirtualChar(event.getVirtualKeyCode()));
			
			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					Scope.getInstace().getKeyboardStage().hide();
				}
			});
			Platform.setImplicitExit(false);
			Scope.getInstace().getPrefInfo().setOcrSet(false);
		}
		Vector<Integer> hotkey = Scope.getInstace().getPrefInfo().getHotkey();
		Vector<Boolean> hotbool = Scope.getInstace().getPrefInfo().getHotkeybool();

		switch (hotkey.size()) {
		case 1:
			if (event.getVirtualKeyCode() == hotkey.get(0)) {
				hookAction();
				hotbool.set(0, false);
			}

			break;
		case 2:
			if (event.getVirtualKeyCode() == hotkey.get(1) && hotbool.get(0).equals(true)) {
				hookAction();
				hotbool.set(0, false);
				hotbool.set(1, false);
			}

			break;
		case 3:
			if (event.getVirtualKeyCode() == hotkey.get(2) && hotbool.get(0).equals(true)
					&& hotbool.get(1).equals(true)) {
				hookAction();
				hotbool.set(0, false);
				hotbool.set(1, false);
				hotbool.set(2, false);
			}

			break;
		}

		Scope.getInstace().setOcrFlag(false);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				if (Scope.getInstace().getOcrStage() != null)
					Scope.getInstace().getOcrStage().hide();
			}
		});

	}
}