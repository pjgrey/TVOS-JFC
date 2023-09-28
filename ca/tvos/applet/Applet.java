/**
 */
package ca.tvos.applet;

import java.awt.Dimension;
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
	 * Returns information about this applet. An applet should override this method
	 * to return a String containing information about the author, version, and
	 * copyright of the applet.
	 * 
	 * The implementation of this method provided by the Applet class returns null.
	 * 
	 * @return a string containing information about the author, version, and
	 *         copyright of the applet
	 */
	public default String getAppletInfo() {
		return null;
	}

	/**
	 * Gets the base URL. This is the URL of the directory which contains this
	 * applet.
	 * 
	 * @return the base URL of the directory which contains this applet
	 * @see getDocumentBase()
	 */
	public default URL getCodeBase() {
		try {
			return Path.of(".").toUri().toURL();
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// extension
	/**
	 * Gets the base Path. This is the Path of the directory which contains this
	 * applet.
	 * 
	 * @return the base Path of the directory which contains this applet
	 * @see getDocumentBase()
	 */
	public default Path getCodeBasePath() {
		return Path.of(".");
	}

	// extension
	/**
	 * Returns an Image object that can then be painted on the screen using the
	 * given <code>Path</code>.
	 *
	 * Not part of the original java.applet.Applet.
	 *
	 * @param path
	 * @return the image at the specified Path
	 */
	public default Image getImage(Path path) {
		return Toolkit.getDefaultToolkit().createImage(path.toString());
	}

	// extension
	/**
	 * Returns an Image object that can then be painted on the screen using the
	 * given <code>Path</code> and relative file name.
	 *
	 */
	public default Image getImage(Path path, String name) {
		return getImage(path.resolve(name));
	}

	/**
	 * Returns an Image object that can then be painted on the screen. The url that
	 * is passed as an argument must specify an absolute URL.
	 * 
	 * This method always returns immediately, whether or not the image exists. When
	 * this applet attempts to draw the image on the screen, the data will be
	 * loaded. The graphics primitives that draw the image will incrementally paint
	 * on the screen.
	 * 
	 * 
	 * @param url an absolute URL giving the location of the image
	 * @return the image at the specified URL
	 * @see Image
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
	 * 
	 * @param url  an absolute URL giving the base location of the image
	 * @param name the location of the image, relative to the url argument
	 * @return the image at the specified URL
	 * @see Image
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
	 * Returns the value of the named parameter. In java.applet.Applet, parameters
	 * are provided in the HTML tag; in this implementation they should be set
	 * explicitly before the applet is activated.
	 * 
	 * The name argument is case insensitive.
	 * 
	 * @param name a parameter name
	 * @return the value of the named parameter, or null if not set
	 */
	public default String getParameter(String name) {
		return getStub().params.get(name.toUpperCase());
	}

	/**
	 * Returns information about the parameters that are understood by this applet.
	 * An applet should override this method to return an array of strings
	 * describing these parameters.
	 * 
	 * Each element of the array should be a set of three strings containing the
	 * name, the type, and a description.
	 * 
	 * The implementation of this method provided by the Applet class returns null.
	 * 
	 * @return an array describing the parameters this applet looks for
	 */
	public default String[][] getParameterInfo() {
		return null;
	}

	// extension
	/**
	 * Returns the applet stub. This method is intended for internal use by the
	 * library. AppletStub does not have members with public visibility.
	 */
	public AppletStub getStub();

	/**
	 * Determines if this applet is active. An applet is marked active just before
	 * its start method is called. It becomes inactive just before its stop method
	 * is called.
	 * 
	 * @return true if the applet is active; false otherwise
	 * @see start()
	 * @see stop()
	 * 
	 */
	public default boolean isActive() {
		return getStub().controller.isActive();
	}

	/**
	 * Indicates if this container is a validate root.
	 * 
	 * Applet objects are the validate roots, and, therefore, they override this
	 * method to return true.
	 * 
	 * @return true
	 * @see Container.isValidateRoot()
	 */
	public default boolean isValidateRoot() {
		return true;
	}

	// extension
	/**
	 * Set a parameter that will be available to the <code>Applet</code>. Parameter
	 * <code>name</code> is case insensitive.
	 */
	public default void setParameter(String name, String value) {
		getStub().params.put(name.toUpperCase(), value);
	}

	// extension
	/**
	 * Set multiple parameters that will be available to the <code>Applet</code>, in
	 * a sequence of name/value pairs. Parameter <code>name</code> is case
	 * insensitive. If an odd number of arguments is provided, the last parameter
	 * value will be the empty string.
	 * 
	 * Not part of original java.applet.Applet.
	 */
	public default void setParameters(String... param) {
		int i = 0;
		while (i < param.length) {
			String name = param[i];
			++i;
			if (i < param.length) {
				String value = param[i];
				++i;
				setParameter(name, value);
			} else
				setParameter(name, StringUtil.EMPTY_STRING);
		}
	}

	/**
	 * Requests that the argument string be displayed in the "status window". Many
	 * browsers and applet viewers provide such a window, where the application can
	 * inform users of its current state.
	 * 
	 * @param msg a string to display in the status window
	 */
	public default void showStatus(String msg) {
		getAppletContext().showStatus(msg);
	}	
	
	
	/* # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # */
	/* # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # */
	/* # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # */





	
	/* # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # */
	
	
	
	
	
	

	


	/* extensions */


	
/*
============================================================================================================================
 * */
	

	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */



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
	 * Set the Applet context.  
	 * @param context
	 * 
	 * @throws IllegalStateException if context has already been set.
	 */
	public void setAppletContext(AppletContext context);
	



/* * ********************************************************* */
	


	


	

	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	



	
	
	
	
	
/* 
 * *******************************************************
 * */
	
	

	

	


	/* extensions */

	
	
	
	

	

	




	
	





	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	


	

	
	

	
}
