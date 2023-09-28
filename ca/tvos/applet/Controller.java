/**
 * 
 */
package ca.tvos.applet;

import java.util.ArrayList;
import java.util.List;



/**
 * 
 */
public class Controller implements AutoCloseable {
	
	/**
		 * 
		 */
	private class Adapter implements AppletModel {
		private Controller controller;
		public Adapter(Controller c) {
			controller = c;
		}
		@Override
		public void destroy() {
			controller.close();
		}
		@Override
		public void start() {
			controller.startApps();
		}
		@Override
		public void stop() {
			controller.stopApps();
		}
	}

	private final List<AppletModel> app_list = new ArrayList<>();
	private boolean is_initialized = false;
	private boolean is_active = false;
	
	public Controller(AppletModel... apps) {
		for( AppletModel app : apps)
			app_list.add(app);
	}
	
	public void addExecutable(AppletModel app) {
		if( is_initialized ) throw new IllegalStateException();		
		if( ! app_list.contains(app))
			app_list.add(app);
	}

	public void addExecutable(Controller controller) {
		addExecutable( new Adapter(controller) );		
	}
	
	public void startApps() {
		if( ! is_initialized ) {
			is_initialized = true;
			for( AppletModel app : app_list)
				app.init();	
		}
		if( ! is_active ) {
		is_active = true;
			for( AppletModel app : app_list)
				app.start();
		}
	}
	
	public void stopApps() {
		if( is_active ) {
			is_active = false;
			int index = app_list.size();
			while( --index >= 0 )
				app_list.get(index).stop();
			}
	}

	@Override
	public void close() {
		if( is_initialized ) {
			stopApps();
			int index = app_list.size();
			while( --index >= 0 ) 
				app_list.get(index).destroy();
		}
		app_list.clear();
	}

	/** 
	 * Return true if applets managed by this Controller are active, false otherwise.
	 */
	public boolean isActive() {
		return is_active;
	}

}
