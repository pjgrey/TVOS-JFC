/**
 * 
 */
package ca.tvos.jfc;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 
 */
public class AutoCloseWL extends WindowAdapter {

	@Override
	public void windowClosing(WindowEvent e) {
		e.getWindow().dispose();
	}

}
