package miso.hook;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.SystemColor;
import java.awt.event.KeyEvent;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

import javafx.application.Platform;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import lc.kra.system.mouse.event.GlobalMouseEvent;
import miso.actions.SearchModule;
import miso.utility.Scope;

public class MISOMouseHook extends MouseHook {
	public MISOMouseHook() {
	}

	@Override
	public void mousePressedAction(GlobalMouseEvent event) {
	//	System.out.println("mouse press");
		if (event.getButton() == 16) {
			hookAction();
		}

	//	System.out.println(hi.toString());
	//	System.out.println("end");
	}

	@Override
	public void mouseReleasedAction(GlobalMouseEvent event) {

		
	}

	@Override
	public void mouseMovedAction(GlobalMouseEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseWheelAction(GlobalMouseEvent event) {
		// TODO Auto-generated method stub

	}

}
