/**
 * 
 */
package ca.tvos.applet;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.JRootPane;
import javax.swing.RootPaneContainer;

/**
 * 
 */
public class AppletJFC extends JComponent
								implements
								RootPaneContainer,
								Applet {

	private static final long serialVersionUID = 8335454063300623798L;
	
	private AppletContext context;
	private final AppletStub stub = new AppletStub(); 
	private JRootPane rp;
	

	@Override
	public void setAppletContext(AppletContext context) {
		if( this.context != null) throw new IllegalStateException();
		this.context = context;		
	}

	@Override
	public AppletContext getAppletContext() {
		return context;
	}

	@Override
	public AppletStub getStub() {
		return stub;
	}
	
	public AppletJFC(){
//		setOpaque(true);
		setFocusable(true);
	}

	@Override
	public JRootPane getRootPane() {
		return rp.getRootPane();
	}

	@Override
	public void setContentPane(Container contentPane) {
		rp.setContentPane(contentPane);
	}

	@Override
	public Container getContentPane() {
		return rp.getContentPane();
	}

	@Override
	public void setLayeredPane(JLayeredPane layeredPane) {
		rp.setLayeredPane(layeredPane);		
	}

	@Override
	public JLayeredPane getLayeredPane() {
		return rp.getLayeredPane();
	}

	@Override
	public void setGlassPane(Component glassPane) {
		rp.setGlassPane(glassPane);		
	}

	@Override
	public Component getGlassPane() {
		return rp.getGlassPane();
	}

}
