/**
 * 
 */
package ca.tvos.applet;

/**
 * @author Peter J. Grey
 * @version 0.2
 */
public class AppletAWT extends java.awt.Panel implements Applet {

	private static final long serialVersionUID = -6634736519193085383L;

	private final AppletStub stub = new AppletStub();
	/*package*/ AppletContext context = null;

	public AppletAWT() {
		setFocusable(true);
//		setParameter("name", "applet 0");
	}
	
	@Override
	public final AppletStub getStub() {
		return stub;
	}

	@Override
	public final AppletContext getAppletContext() {
		return context;
	}

	@Override
	public void setAppletContext(AppletContext context) {
		if( this.context != null) throw new IllegalStateException();
		this.context = context;		
	}

}
