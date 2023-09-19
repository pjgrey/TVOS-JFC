package ca.tvos.applet;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ControllerWL extends WindowAdapter {

	private final Controller controller;
	public ControllerWL(Controller c) {
		controller = c;
	}
	
	@Override
	public void windowClosed(WindowEvent e) {
		controller.close();
	}

	@Override
	public void windowActivated(WindowEvent e) {
		controller.startApps();
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		controller.stopApps();
	}

}
