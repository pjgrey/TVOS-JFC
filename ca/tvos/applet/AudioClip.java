/**
 * 
 */
package ca.tvos.applet;

/**
 * The AudioClip interface is a simple abstraction for playing a sound clip.
 * Multiple AudioClip items can be playing at the same time, and the resulting
 * sound is mixed together to produce a composite.
 * 
 */
public interface AudioClip {

	/**
	 * Starts playing this audio clip. Each time this method is called, the clip is
	 * restarted from the beginning.
	 */
	public default void play() { throw new UnsupportedOperationException(); } 

	/**
	 * Starts playing this audio clip in a loop. 
	 */
	public default void loop() { throw new UnsupportedOperationException(); } 

	/**
	 * Stops playing this audio clip.
	 */
	public default void stop() { throw new UnsupportedOperationException(); } 

}
