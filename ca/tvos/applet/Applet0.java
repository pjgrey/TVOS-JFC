/**
 * 
 */
package ca.tvos.applet;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;

/**
 * @author Peter J. Grey
 * @version 0.1
 */
public interface Applet0 {

	/** 
	 * Gets the applet's stub.  For internal use by library. */
	public AppletStub getStub();

	/**
	 * Determines this applet's context, which allows the applet to query and affect
	 * the environment in which it runs. This environment of an applet represents
	 * the document that contains the applet.
	 */
	public AppletContext getAppletContext();

	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

//	/** Gets the URL of the document in which this applet is embedded. */
//	public default URL getDocumentBase() {
//		return null;
//	}

	/**
	 * Gets the base URL. This is the URL of the directory which contains this
	 * applet.
	 */
	public default URL getCodeBase() {
		try {
			return Path.of(".").toUri().toURL();
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}
	}

//	/** Requests that this applet be resized. */
//	public default void resize(int width, int height) {
//	}
//
//	/** Requests that this applet be resized. */
//	public default void resize(Dimension d) {
//	}

//	/** Get an audio clip from the given URL. */
//	public static AudioClip newAudioClip(URL url) {
//		return null;
//	}

}
