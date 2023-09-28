/**
 * 
 */
package ca.tvos.applet;

import java.awt.Window;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JInternalFrame;

/**
 * When an applet is first created, an applet stub is attached to it using the
 * applet's setStub method. This stub serves as the interface between the applet
 * and the hosting environment in which the applet is running.
 * 
 * This implement of AppletStub is intended for internal use by the library and
 * does not have members with public visibility.
 */
public class AppletStub {

	/*package*/ AppletStub() {} 
	
	/*package*/ final Map<String, String> params = new HashMap<>();
	/*package*/ Controller controller;
	
	/* = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = */
	/* in progress */
	/*package*/ Window primaryWidgetW;
	/*package*/ JInternalFrame primaryWidgetIF;
	
	/*package*/ void packPrimary() {
		if( primaryWidgetIF != null )
			primaryWidgetIF.pack();
		else if( primaryWidgetW != null )
			primaryWidgetW.pack();
		else
			throw new IllegalStateException();
	}
	
}
