/**
 * 
 */
package ca.tvos.applet;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import ca.tvos.jfc.StatusPresenter;
import ca.tvos.util.ObjectUtil;


/**
 * 
 */
public class AppletContext implements AppletContext0 {
	
	/* package */ final Set<Applet> app_set = new TreeSet<>( ObjectUtil.neutralComparator() );
	/* package */ Map<String, InputStream> stream_map = null; //create on demand 
	private final StatusPresenter status_line;
	
	/* package */ AppletContext(StatusPresenter statusLine){
		status_line = statusLine;
	}

	/**
	 * Requests that the argument string be displayed in the "status window". Many browsers and applet viewers provide such a window, where the application can inform users of its current state.
	 * 
	 * @param status a string to display in the status window
	 */
	public void showStatus(String status) { 
		status_line.showStatus(status); 
		}
		
	/**
	 * Finds and returns the applet in the document represented by this applet
	 * context with the given name. The name can be set in the HTML tag by setting
	 * the name attribute.
	 * 
	 * @param name an applet name
	 * @return the applet with the given name, or null if not found
	 */
	public Applet getApplet(String name) {
			for(Applet app : app_set )
				if( name.equals(app.getParameter(Applet.PARAMETER_TAG_APPLET_NAME)))
					return app;
			return null;
		}
	
	/**
	 * Associates the specified stream with the specified key in this applet
	 * context. If the applet context previously contained a mapping for this key,
	 * the old value is replaced.
	 * 
	 * For security reasons, mapping of streams and keys exists for each codebase.
	 * In other words, applet from one codebase cannot access the streams created by
	 * an applet from a different codebase
	 * 
	 * 
	 * @param key    key with which the specified value is to be associated
	 * @param stream stream to be associated with the specified key. If this
	 *               parameter is null, the specified key is removed in this applet
	 *               context.
	 * 
	 * @throws IOException if the stream size exceeds a certain size limit. Size
	 *                     limit is decided by the implementor of this interface.
	 * 
	 */
	public void setStream(String key, InputStream stream) /*throws IOException*/ {
		if( stream_map == null)
			stream_map = new HashMap<>();
		stream_map.put(key, stream);
		}

	/**
	 * Returns the stream to which specified key is associated within this applet
	 * context. Returns null if the applet context contains no stream for this key.
	 * 
	 * For security reasons, mapping of streams and keys exists for each codebase.
	 * In other words, applet from one codebase cannot access the streams created by
	 * an applet from a different codebase.
	 * 
	 * 
	 * @param key key whose associated stream is to be returned
	 * @return the stream to which this applet context maps the key
	 * 
	 */
	public InputStream getStream(String key) {
		if( stream_map == null)
			return null;
		else
			return stream_map.get(key);
		}
	
	/**
	 * Finds all the keys of the streams in this applet context.
	 * 
	 * For security reasons, mapping of streams and keys exists for each codebase.
	 * In other words, applet from one codebase cannot access the streams created by
	 * an applet from a different codebase.
	 * 
	 * @return an Iterator of all the names of the streams in this applet context
	 */
	public Iterator<String> getStreamKeys() {
		if( stream_map == null)
			return Collections.emptyIterator();
		else
			return stream_map.keySet().iterator();
		}

	/**
	 * Finds all the applets in the document represented by this applet context.
	 * 
	 * Note this method returns an Iterator instead of the Enumeration of the 
	 * original java.applet.AppletContext.
	 * 
	 * @return an Iterator of all applets in the document represented by this applet context
	 */
	public Iterator<Applet> getApplets() { 
		return app_set.iterator();
		}

	/**
	 * Returns an Image object that can then be painted on the screen. The url
	 * argument that is passed as an argument must specify an absolute URL.
	 * 
	 * This method always returns immediately, whether or not the image exists. When
	 * the applet attempts to draw the image on the screen, the data will be loaded.
	 * The graphics primitives that draw the image will incrementally paint on the
	 * screen.
	 * 
	 * 
	 * @param url an absolute URL giving the location of the image
	 * @return the image at the specified URL
	 * @see Image
	 */
	public Image getImage(URL url) {
		return Toolkit.getDefaultToolkit().createImage(url); 
	}

	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	
	
}
