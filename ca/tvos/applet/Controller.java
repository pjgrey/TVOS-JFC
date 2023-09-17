/**
 *
 */
package ca.tvos.applet;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages the life cycle of one or more <code>AppletAWT</code>,
 * <code>AppletJFC</code> or other <code>Managed</code> objects.
 *
 * @author Peter J. Grey
 *
 */
public final class Controller implements AutoCloseable {

	/**
	 * Adapter to allow a <code>Controller</code> to be placed under the management
	 * of another<code>Controller</code>.
	 * 
	 * @author Peter J. Grey
	 *
	 */
	private static class ControllerAdapter implements Managed {

		private final Controller c;

		public ControllerAdapter(Controller other) {
			c = other;
		}

		@Override
		public void start() {
			c.startApps();
		}

		@Override
		public void stop() {
			c.stopApps();
		}

		@Override
		public void destroy() {
			c.close();
		}

	}

	private final List<Managed> app_list = new ArrayList<>();
	private boolean initialized = false;
	private boolean is_running = false;

	/**
	 * Create a <code>Controller</code> and add the <code>Managed</code> objects, if
	 * any, in the order provided.
	 */
	public Controller(Managed... apps) {
//		addExecutable( new GlobalExecution()); //debugging
//		addExecutable( new ControllerTrace()); //debugging
		for (Managed app : apps) {
			addExecutable(app);
		}
	}

	/**
	 * Create a <code>Controller</code> and add the <code>Managed</code> elements in
	 * the order the occur in the <code>List</code>. If the <code>List</code>
	 * contains duplicates, the duplicated element is only added once.
	 */
	public Controller(List<Managed> list) {
//		addExecutable( new GlobalExecution()); //debugging
//		addExecutable( new ControllerTrace()); //debugging
		for (Managed app : list) {
			addExecutable(app);
		}
	}

	/**
	 * Add the <code>Managed</code> object at the end of the internal list of
	 * <code>Managed</code> objects. If <code>app</code> was previously added the
	 * order is unchanged.
	 * 
	 * @throws IllegalStateException if <code>startApps</code> has been called.
	 */
	public void addExecutable(Managed app) {
		if (initialized)
			throw new IllegalStateException();
		if (!app_list.contains(app))
			app_list.add(app);
	}

	/**
	 * Add the <code>Controller</code> at the end of the internal list of
	 * <code>Managed</code> objects.  <code>startApps</code> and <code>stopApps</code> for dependant
	 * will be called with <code>start</code> and <code>stop</code> for the <code>Managed</code> apps.
	 * 
	 * @throws IllegalStateException if <code>startApps</code> has been called.
	 */
	public void addExecutable(Controller dependant) {
		addExecutable(new ControllerAdapter(dependant));
	}

	/**
	 * <code>start</code> the <code>Managed</code> objects controlled by this
	 * <code>Controller</code>. The first invocation will call <code>init</code> for
	 * each object before calling <code>start</code>. <code>init</code> and
	 * <code>start</code> are invoked in the order that <code>Managed</code> objects
	 * were added.
	 */
	public void startApps() {
		if (!initialized) {
			initialized = true;
			for (Managed am : app_list) {
				am.init();
			}
		}
		is_running = true;
		for (Managed am : app_list) {
			am.start();
		}
	}

	/**
	 * <code>stop</code> the <code>Managed</code> objects controlled by this
	 * <code>Controller</code>. If The first invocation will call <code>init</code>
	 * for each object before calling <code>start</code>.
	 * 
	 * @throws IllegalStateException if <code>startApps</code> has not been called.
	 */
	public void stopApps() {
		if (!initialized)
			throw new IllegalStateException();
		is_running = false;
		int i = app_list.size();
		while (--i >= 0) {
			Managed app = app_list.get(i);
			app.stop();
		}
	}

	/**
	 * Call <code>destroy</code> for each <code>Managed</code> object. No action if
	 * <code>startApps</code> has not been called. <code>close</code> may be safely
	 * called more than once.
	 */
	@Override
	public void close() {
		if (initialized) {
			int i = app_list.size();
			while (--i >= 0) {
				Managed app = app_list.get(i);
				app.destroy();
			}
		}
		app_list.clear();
	}

	/**
	 * Indicates whether the <code>Managed</code> objects managed by the
	 * <code>Controller</code> are currently in a <code>start</code>ed state.
	 */
	public boolean isActive() {
		return is_running;
	}

}
