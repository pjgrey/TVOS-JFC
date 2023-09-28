/**
 * 
 */
package ca.tvos.applet;

import java.awt.Dimension;

import ca.tvos.util.ObjectUtil;

/**
 * 
 */
/* package */ class /* static */ AppletUtil {
	
	/* package */ static final int DEFAULT_APPLET_WIDTH = 800;
	/* package */ static final int DEFAULT_APPLET_HEIGHT = 600;

	/* package */ static final int DEFAULT_APPLET_WIDTH_REDUCED = 500;
	/* package */ static final int DEFAULT_APPLET_HEIGHT_REDUCED = 350;

	/**
	 * @param applet
	 * @param name
	 * @return
	 */
	/* package */ static String getAppletName(Applet applet, String name) {
		if (name != null)
			return name;
		String derived = applet.getParameter(Applet.PARAMETER_TAG_APPLET_NAME);
		if (derived == null)
			derived = ObjectUtil.objectLabel(applet);
		return derived;
	}
	
	/** 
	 * 
	 * @param app
	 * @param name
	 * @param defaultValue
	 * @return
	 */
	/* package */ static int getParameterInt(Applet app, String name, int defaultValue) {
		String p = app.getParameter(name);
		if (p == null)
			return defaultValue;
		try {
			return Integer.parseInt(p);
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}

	/**
	 * 
	 * @param applet
	 * @param size
	 * @return
	 */
	/* package */  static Dimension getAppletSize(Applet applet, Dimension size) {
		if( size != null && size.width != 0 && size.height != 0 ) {
			return size;
		}
		int width = getParameterInt(applet, Applet.PARAMETER_TAG_WIDTH, 0);
		int height = getParameterInt(applet, Applet.PARAMETER_TAG_HEIGHT, 0);
		if( width == 0 || height == 0 )
			return new Dimension(DEFAULT_APPLET_WIDTH_REDUCED, DEFAULT_APPLET_HEIGHT_REDUCED);
		else
			return new Dimension(width, height);
	}
	
	private static void setup0(Applet app, AppletContext context, Controller controller) {
		//context
		context.app_set.add(app);
		//Controller
		controller.addExecutable(app);
		app.getStub().controller = controller;
	}
	
	/*package*/ static void setupApplet(AppletAWT app, AppletContext context, Controller controller) {
		app.setAppletContext(context);
		setup0(app, context, controller);
	}
	
	/*package*/ static void setupApplet(AppletJFC app, AppletContext context, Controller controller) {
		app.setAppletContext(context);
		setup0(app, context, controller);
	}
	
	//do not instantiate; static members only
	private AppletUtil() {
	}

}
