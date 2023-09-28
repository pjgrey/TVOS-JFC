/**
 * 
 */
package ca.tvos.applet;

import java.awt.Dimension;
import java.net.URL;

/**
 * @author Peter J. Grey
 * @version 0.1
 */
public interface Applet0 {
	
	/**
	 * Determines this applet's context, which allows the applet to query and affect
	 * the environment in which it runs.
	 * 
	 * This environment of an applet represents the hosting platform that contains the
	 * applet.
	 * 
	 * @return the applet's context
	 */
	public AppletContext getAppletContext();
	
//	/**
//	 * Assigns context to an applet.
//	 * 
//	 * This is an extension to java.applet.Applet
//	 * 
//	 * @throws IllegalStateException if a context has been previously set
//	 */
//	public void setAppletContext(AppletContext context);
	

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */	

	
	/**
	 * Returns the AudioClip object specified by the URL and name arguments.
	 * 
	 * This method always returns immediately, whether or not the audio clip exists.
	 * When this applet attempts to play the audio clip, the data will be loaded.
	 * 
	 * @param url  an absolute URL giving the base location of the audio clip
	 * @param name the location of the audio clip, relative to the url argument
	 * @return the audio clip at the specified URL
	 * @see AudioClip
	 */
	public default AudioClip getAudioClip(URL url, String name) { throw new UnsupportedOperationException(); }
//	public default AudioClip getAudioClip(URL url, String name) {
//		try {
//			return getAppletContext().getAudioClip(new URL(url, name));
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//			return null;
//		}
//	}

	

	
	/**
	 * Plays the audio clip at the specified absolute URL. Nothing happens if the audio clip cannot be found.
	 * @param url an absolute URL giving the location of the audio clip
	 */
	public default void play(URL url) { throw new UnsupportedOperationException(); }
//	public default void play(URL url) {
//		AudioClip clip = getAppletContext().getAudioClip(url);
//		if (clip == null)
//			return;
//		clip.play();
//	}

	

	/* # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # */

	
	
	

	/**
	 * Requests that this applet be resized.
	 * 
	 * @param width the new requested width for the applet
	 * @param height the new requested height for the applet
	 */
	public default void resize(int width,
			 int height) { throw new UnsupportedOperationException(); }

	/**
	 * Requests that this applet be resized.
	 * 
	 * @param d an object giving the new width and height
	 */
	public default void resize(Dimension d) { throw new UnsupportedOperationException(); }
	
	/**
	 * Plays the audio clip given the URL and a specifier that is relative to it. Nothing happens if the audio clip cannot be found.
	 * 
	 * @param url an absolute URL giving the base location of the audio clip
	 * @param name the location of the audio clip, relative to the url argument
	 */
	public default void play(URL url, String name) { throw new UnsupportedOperationException(); }
//	public default void play(URL url, String name) {
//		AudioClip clip = getAudioClip(url, name);
//		if (clip == null)
//			return;
//		clip.play();
//	}
	
	/**
	 * Get an audio clip from the given URL.
	 * 
	 * @param url points to the audio clip
	 * @return the audio clip at the specified URL
	 */
	public default /*static*/ AudioClip newAudioClip(URL url) { throw new UnsupportedOperationException(); }

	/**
	 * Gets the URL of the document in which this applet is embedded.
	 * 
	 * @return the URL of the document that contains this applet
	 * @see getCodeBase()
	 * 
	 */
	public default URL getDocumentBase() { throw new UnsupportedOperationException(); }

//	/* * = = = = = use superclass = = = = = 
//	 * Gets the AccessibleContext associated with this Applet. For applets, the
//	 * AccessibleContext takes the form of an AccessibleApplet. A new
//	 * AccessibleApplet instance is created if necessary.
//	 * 
//	 * 
//	 * @return an AccessibleApplet that serves as the AccessibleContext of this
//	 *         Applet
//	 */
//	public default AccessibleContext getAccessibleContext() { throw new UnsupportedOperationException(); }

	/**
	 * Returns the AudioClip object specified by the URL argument.
	 * 
	 * This method always returns immediately, whether or not the audio clip exists.
	 * When this applet attempts to play the audio clip, the data will be loaded.
	 * 
	 * 
	 * @param url an absolute URL giving the location of the audio clip
	 * @return the audio clip at the specified URL
	 * @see AudioClip
	 */
	public default AudioClip getAudioClip(URL url) { throw new UnsupportedOperationException(); }

}
