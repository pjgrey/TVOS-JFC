/**
 * 
 */
package ca.tvos.applet;

/**
 * <code>AppletModel</code> describes the life cycle operations of an applet which are
 * controlled by a hosting platform. An applet is a small program that is
 * intended not to be run on its own, but rather to be embedded inside another
 * application.
 * 
 * Managed can also be used for general-purpose life cycle management.
 * 
 * @author peter
 *
 */
public interface AppletModel {

	/**
	 * Called by the hosting platform to inform this applet that it has been loaded
	 * into the system. It is always called before the first time that the start
	 * method is called.
	 * 
	 * The default implementation of this method does nothing.
	 * 
	 * Behaviour is identical to java.applet.Applet.init
	 */
	public default void init() {
		/* no action */ }

	/**
	 * Called by the hosting platform to inform this applet that it should start its
	 * execution. It is called after the init method and each time the applet is
	 * activated.
	 * 
	 * The default implementation of this method does nothing.
	 * 
	 * Behaviour is identical to java.applet.Applet.start
	 */

	public default void start() {
		/* no action */ }

	/**
	 * Called by the hosting platform to inform this applet that it should stop its
	 * execution. It is called when the applet is deactivated, and also just before
	 * the applet is to be destroyed.
	 * 
	 * The default implementation of this method does nothing.
	 * 
	 * Behaviour is identical to java.applet.Applet.stop
	 */

	public default void stop() {
		/* no action */ }

	/**
	 * Called by the hosting platform to inform this applet that it is being
	 * reclaimed and that it should destroy any resources that it has allocated. The
	 * stop method will always be called before destroy.
	 * 
	 * The default implementation of this method does nothing.
	 * 
	 * Behaviour is identical to java.applet.Applet.destroy
	 */
	public default void destroy() {
		/* no action */ }

}
