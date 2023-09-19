package ca.tvos.applet;

public interface AudioClip {

	/** 
	 * Starts playing this audio clip in a loop.
	 */
	public void loop();
	
	/**
	 * Starts playing this audio clip.
	 */
	public void play();
	
	/**
	 * Stops playing this audio clip.
	 */
	public void stop();

}