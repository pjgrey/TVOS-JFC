/**
 * 
 */
package ca.tvos.applet;

import java.net.URL;
import java.util.Locale;

/**
 * 
 */
public interface AppletNA {

	/**
	 * Gets the URL of the document in which this applet is embedded.
	 * 
	 * @return the URL of the document that contains this applet
	 * @see getCodeBase()
	 * 
	 */
	public default URL getDocumentBase() { throw new UnsupportedOperationException(); }

	/**
	 * Gets the locale of the applet. It allows the applet to maintain its own locale separated from the locale of the browser or appletviewer.
	 * 
	 * @return the locale of the applet; if no locale has been set, the default locale is returned
	 * @see Component.setLocale(java.util.Locale)
	 */
	public default Locale getLocale() { throw new UnsupportedOperationException(); }	

	/**
	 * Sets this applet's stub. This is done automatically by the system.
	 * 
	 * If there is a security manager, its checkPermission method is called with the
	 * AWTPermission("setAppletStub") permission if a stub has already been set.
	 * 
	 * @param stub the new stub
	 * 
	 * @throws SecurityException if the caller cannot set the stub
	 * 
	 */
	public default void setStub(AppletStub stub) { throw new UnsupportedOperationException(); }	


	/**
	 * Requests that the browser or applet viewer show the Web page indicated by the url argument. The browser or applet viewer determines which window or frame to display the Web page. This method may be ignored by applet contexts that are not browsers.
	 * 
	 * @param url an absolute URL giving the location of the document
	 */
	public default void showDocument(URL url) { throw new UnsupportedOperationException(); }

	/**
	 * Requests that the browser or applet viewer show the Web page indicated by the url argument. The target argument indicates in which HTML frame the document is to be displayed. The target argument is interpreted as follows:
	 * ...
	 * An applet viewer or browser is free to ignore showDocument.
	 * 
	 * @param url an absolute URL giving the location of the document
	 * @param target a String indicating where to display the page
	 */
	public default void showDocument(URL url, String target) { throw new UnsupportedOperationException(); }


	
}
