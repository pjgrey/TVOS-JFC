/**
 * 
 */
package ca.tvos.applet;

import ca.tvos.util.ExitGuard;

/**
 * 
 */
public class AutoExitAM implements AppletModel {

	private ExitGuard g;
	
	@Override
	public synchronized void init() {
		g = new ExitGuard();
	}

	@Override
	public synchronized void destroy() {
		g.close();
	}

}
