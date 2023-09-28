/**
 * 
 */
package ca.tvos.applet;

import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

/**
 * 
 */
public class ControllerIFL extends InternalFrameAdapter {
	
	private final Controller controller;

	public ControllerIFL(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void internalFrameClosed(InternalFrameEvent e) {
		controller.close();
	}

	@Override
	public void internalFrameActivated(InternalFrameEvent e) {
		controller.startApps();
	}

	@Override
	public void internalFrameDeactivated(InternalFrameEvent e) {
		controller.stopApps();
	}

}
