/**
 * 
 */
package ca.tvos.jfc;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import ca.tvos.util.ExitGuard;

/**
 * 
 */
public class AutoExitWL extends WindowAdapter {
	
	private ExitGuard g;  

	@Override
	public void windowOpened(WindowEvent e) {
		g = new ExitGuard();
	}

	@Override
	public void windowClosed(WindowEvent e) {
		g.close();
	}

}
