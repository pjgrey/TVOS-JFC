/**
 */
package ca.tvos.applet;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;

import ca.tvos.util.StringUtil;

/**
 * @author Peter J. Grey
 * @version 0.1
 * 
 */
public interface Applet extends AppletModel, Applet0 {

	public static final String PARAMETER_TAG_HEIGHT = "HEIGHT";
	public static final String PARAMETER_TAG_WIDTH = "WIDTH";
	public static final String PARAMETER_TAG_APPLET_NAME = "NAME";

	/**
	 * Determines if this applet is active. An applet is marked active just before
	 * its start method is called. It becomes inactive just before its stop method
	 * is called.
	 */
	public default boolean isActive() {
		return getStub().controller.isActive();
	}

	/**
	 * Indicates if this container is a validate root. Applet objects are the
	 * validate roots, and, therefore, they override this method to return true.
	 */
	public default boolean isValidateRoot() {
		return true;
	}

	/** Returns the value of the named parameter in the HTML tag. */
	public default String getParameter(String name) {
		return getStub().params.get(name.toUpperCase());
	}

	/** Requests that the argument string be displayed in the "status window". */
	public default void showStatus(String msg) {
		getAppletContext().displayStatus(msg);
	}

	/**
	 * Returns an Image object that can then be painted on the screen. The url that
	 * is passed as an argument must specify an absolute URL.
	 * 
	 * This method always returns immediately, whether or not the image exists. When
	 * this applet attempts to draw the image on the screen, the data will be
	 * loaded. The graphics primitives that draw the image will incrementally paint
	 * on the screen.
	 */
	public default Image getImage(URL url) {
		return getAppletContext().getImage(url);
	}

	/**
	 * Returns an Image object that can then be painted on the screen. The url
	 * argument must specify an absolute URL. The name argument is a specifier that
	 * is relative to the url argument.
	 * 
	 * This method always returns immediately, whether or not the image exists. When
	 * this applet attempts to draw the image on the screen, the data will be
	 * loaded. The graphics primitives that draw the image will incrementally paint
	 * on the screen.
	 */
	public default Image getImage(URL url, String name) {
		try {
			return getImage(new URL(url, name));
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * Returns information about this applet. An applet should override this method
	 * to return a String containing information about the author, version, and
	 * copyright of the applet.
	 * 
	 * 
	 * The implementation of this method provided by the Applet class returns null.
	 * 
	 * @return
	 */
	public default String getAppletInfo() {
		return null;
	}

	/**
	 * Returns information about the parameters that are understood by this applet.
	 * An applet should override this method to return an array of strings
	 * describing these parameters.
	 * 
	 * 
	 * Each element of the array should be a set of three strings containing the
	 * name, the type, and a description.
	 * 
	 * The implementation of this method provided by the Applet class returns null.
	 * 
	 * 
	 * 
	 * @return
	 */
	public default String[][] getParameterInfo()

	{
		return null;
	}

	/**
	 * Returns the AudioClip object specified by the URL and name arguments.
	 * 
	 * This method always returns immediately, whether or not the audio clip exists.
	 * When this applet attempts to play the audio clip, the data will be loaded.
	 * 
	 * 
	 * 
	 * @param url
	 * @param name
	 * @return
	 */
	public default AudioClip getAudioClip(URL url, String name) {
		try {
			return getAppletContext().getAudioClip(new URL(url, name));
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Plays the audio clip at the specified absolute URL. Nothing happens if the
	 * audio clip cannot be found.
	 */
	public default void play(URL url) {
		AudioClip clip = getAudioClip(url, StringUtil.EMPTY_STRING);
		if (clip == null)
			return;
		clip.play();
	}

	/**
	 * Plays the audio clip given the URL and a specifier that is relative to it.
	 * Nothing happens if the audio clip cannot be found.
	 */
	public default void play(URL url, String name) {
		AudioClip clip = getAudioClip(url, name);
		if (clip == null)
			return;
		clip.play();
	}

	/**
	 * Returns the AudioClip object specified by the URL argument.
	 * 
	 * This method always returns immediately, whether or not the audio clip exists.
	 * When this applet attempts to play the audio clip, the data will be loaded.
	 * 
	 */
	public default AudioClip getAudioClip(URL url) {
		return getAppletContext().getAudioClip(url);
	}

	/* extensions */

	/**
	 * Returns an Image object that can then be painted on the screen using the
	 * given <code>Path</code>.
	 * 
	 * @param path
	 * @return
	 */
	public default Image getImage(Path path) {
		return Toolkit.getDefaultToolkit().createImage(path.toString());
	}

	/**
	 * Returns an Image object that can then be painted on the screen using the
	 * given <code>Path</code> and relative file name.
	 *
	 */
	public default Image getImage(Path path, String name) {
		return getImage(path.resolve(name));
	}

	/**
	 * Set a parameter that will be available to the <code>Applet</code>. Parameter
	 * <code>name</code> is case insensitive.
	 */
	public default void setParameter(String name, String value) {
		getStub().params.put(name.toUpperCase(), value);
	}

}
