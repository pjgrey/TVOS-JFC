/**
 * 
 */
package ca.tvos.applet;

import java.net.URL;

/**
 * 
 */
public interface AppletContext0 {

	/**
	 * Creates an audio clip.
	 * 
	 * @param url an absolute URL giving the location of the audio clip
	 * @return the audio clip at the specified URL
	 */
	public default AudioClip getAudioClip(URL url) { throw new UnsupportedOperationException(); }

	
}
