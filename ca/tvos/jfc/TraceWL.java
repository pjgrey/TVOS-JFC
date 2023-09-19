/**
 * 
 */
package ca.tvos.jfc;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * 
 */
public class TraceWL extends EventTrace implements WindowListener {
	
	@Override
	public void windowOpened(WindowEvent e) {
		trace("opened");		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		trace("closing");
	}

	@Override
	public void windowClosed(WindowEvent e) {
		trace("closed");
	}

	@Override
	public void windowIconified(WindowEvent e) {
		trace("iconified");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		trace("deiconified");
	}

	@Override
	public void windowActivated(WindowEvent e) {
		trace("activated");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		trace("deactivated");
	}

}
