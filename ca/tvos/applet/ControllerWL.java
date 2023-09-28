/**
 * 
 */
package ca.tvos.applet;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * WindowListener to manage a Controller with the activation, deactivation, and closing of a java.awt.Window.
 * 
 */
public class ControllerWL extends WindowAdapter {
	
	private final Controller target;
	
	public ControllerWL(Controller operand) {
		target = operand;
	}

	/** Destroy applets on Window close. */
	@Override
	public void windowClosed(WindowEvent e) {
//		SysIO.println("window close event");
		target.close();
	}

	/** Start applets on Window activation. */
	@Override
	public void windowActivated(WindowEvent e) {
		target.startApps();
	}

	/** Stop applets on Window activation. */
	@Override
	public void windowDeactivated(WindowEvent e) {
		target.stopApps();
	}

}
