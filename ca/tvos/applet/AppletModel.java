package ca.tvos.applet;

/**
 * <code>AppletModel</code> describes the life cycle operations of an applet
 * which are controlled by a hosting platform. An applet is a small program that
 * is intended not to be run on its own, but rather to be embedded inside
 * another application.
 * 
 * The life cycle is managed by a Controller object, and all <code>AppletModel</code>
 * objects managed by the same Controller are synchronized, with operations invoked
 * in a well-defined sequence.
 * 
 * <code>AppletModel</code> can also be used for general-purpose life cycle
 * management.
 * 
 * @author Peter J. Grey
 * 
 */
public interface AppletModel {
	/**
	 * Called by the hosting environment to inform this applet that it has been
	 * loaded into the system. It is always called before the first time that the
	 * start method is called.
	 * 
	 * A class implementing AppletModel should override this method if it has initialization to
	 * perform. For example, an applet with threads would use the init method to
	 * create the threads and the destroy method to kill them.
	 * 
	 * The default implementation of this method provided by the AppletModel interface does nothing.
	 * 
	 * Behavour is identical to java.applet.Applet.
	 * 
	 */
	public default void init() { /* no action */ }
	
	/**
	 * Called by the hosting environment to inform this applet that it is being
	 * reclaimed and that it should destroy any resources that it has allocated. The
	 * stop method will always be called before destroy.
	 * 
	 * A class implementing AppletModel should override this method if it has any operation that
	 * it wants to perform before it is destroyed. For example, an applet with
	 * threads would use the init method to create the threads and the destroy
	 * method to kill them.
	 * 
	 * The default implementation of this method provided by the AppletModel interface does nothing.
	 * 
	 * Behavour is identical to java.applet.Applet.
	 */
	public default void destroy() { /* no action */ }
	
	
	
	
	/**
	 * Called by the hosting environment to inform this applet that it should
	 * start its execution. It is called after the init method and each time the
	 * applet is revisited in a Web page.
	 * 
	 * A class implementing AppletModel should override this method if it has any operation that
	 * it wants to perform each time the window containing it becomes activated. 
	 * For example, an applet with animation might want to use the start method to
	 * resume animation, and the stop method to suspend the animation.
	 * 
	 * Note: some methods, such as getLocationOnScreen, can only provide meaningful
	 * results if the applet is showing. Because isShowing returns false when the
	 * applet's start is first called, methods requiring isShowing to return true
	 * should be called from a ComponentListener.
	 * 
	 * The default implementation of this method provided by the AppletModel interface does nothing.
	 * 
	 * Behavour is identical to java.applet.Applet.
	 * 
	 * 
	 * */
	public default void start() { /* no action */ }
	
	/**
	 * Called by the hosting environment to inform this applet that it should
	 * stop its execution. It is called when the window that contains this applet
	 * becomes inactive, and also just before the applet is to be
	 * destroyed.
	 * 
	 * A class implementing AppletModel should override this method if it has any operation that
	 * it wants to perform each time the window containing it becomes deactivated. 
	 * For example, an applet with animation might want to use the start
	 * method to resume animation, and the stop method to suspend the animation.
	 * 
	  * The default implementation of this method provided by the AppletModel interface does nothing.
	 * 
	 * Behavour is identical to java.applet.Applet.
	 * 
	 */
	public default void stop() { /* no action */ }

}
