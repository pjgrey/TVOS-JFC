/**
 * 
 */
package ca.tvos.applet;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import ca.tvos.base.SysIO;

/**
 * 
 */
public final class AppletContext {

	private List<Applet> app_list = new ArrayList<>();
	private Map<String, InputStream> is_map = null;
//	private List<AudioClipImpl> clip_list = new ArrayList<>();

//	private int applet_id = 0;	
	
//	private void initAudio(Controller c) {
//		c.addExecutable( new AppletModel() {
//			@Override
//			public void destroy() {
//				disposeAudio();
//			}});	}

//	/* package */ private final Controller controller;

	/* package */ void displayStatus(String msg) {
		SysIO.println(msg);
	}

	public void add(Applet app) {
//		++applet_id;
		app_list.add(app);
	}

	/**
	 * Finds and returns the applet in the document represented by this applet
	 * context with the given name. The name can be set in the HTML tag by setting
	 * the name attribute.
	 */
	public Applet getApplet(String name) {
		for (Applet app : app_list) {
			if (name.equals(app.getParameter(Applet.PARAMETER_TAG_APPLET_NAME)))
				return app;
		}
		return null;
	}

	/**
	 * Finds all the applets in the document represented by this applet context.
	 */
	Iterator<Applet> getApplets() {
		return app_list.iterator();
	}

	/**
	 * 
	 * Returns the stream to which specified key is associated within this applet
	 * context.
	 */
	public InputStream getStream(String key) {
		if (is_map == null) {
			return null;
		} else
			return is_map.get(key);
	}

	/**
	 * Finds all the keys of the streams in this applet context.
	 */
	Iterator<String> getStreamKeys() {
		if (is_map == null) {
			return Collections.emptyIterator();
		} else
			return is_map.keySet().iterator();

	}

	/**
	 * Associates the specified stream with the specified key in this applet
	 * context.
	 * 
	 * @param key
	 * @param stream
	 */
	void setStream(String key, InputStream stream) {
		if (is_map == null) {
			is_map = new HashMap<>();
		}
		is_map.put(key, stream);
	}

	/**
	 * Returns an Image object that can then be painted on the screen.
	 */
	Image getImage(URL url) {
		return Toolkit.getDefaultToolkit().createImage(url);
	}

	/** Creates an audio clip. */
	public AudioClip getAudioClip(URL url) {
//		AudioClipImpl auclip = new AudioClipImpl(url);
//		clip_list.add(auclip);
		throw new UnsupportedOperationException();
	}

//	private void disposeAudio() {
//		for (AudioClipImpl c : clip_list)
//			try {
//				c.close();
//			} catch (Exception e) {
////			e.printStackTrace();
//			}
//	}

}
