/**
 * 
 */
package ca.tvos.jfc;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Panel;
import java.awt.TextField;

/**
 * 
 */
public class StatusFrameAWT extends Frame implements StatusPresenter {

	private static final long serialVersionUID = 8116141782908980045L;

	public StatusFrameAWT() throws HeadlessException {
		super();
		setupStatusBar();
	}

	public StatusFrameAWT(GraphicsConfiguration gc) {
		super(gc);
		setupStatusBar();
	}
	public StatusFrameAWT(String title, GraphicsConfiguration gc) {
		super(title, gc);
		setupStatusBar();
	}
	public StatusFrameAWT(String title) throws HeadlessException {
		super(title);
		setupStatusBar();
	}

	private final Panel topContent = new Panel();
	private final Container localContent = new Panel();
	private final TextField statusBar = new TextField("test text");

	private void setupStatusBar() {
		topContent.setLayout(new BorderLayout());
		topContent.add(localContent, BorderLayout.CENTER);
		topContent.add(statusBar, BorderLayout.SOUTH);
//		localContent.setPreferredSize( new Dimension(500, 300) );		
		super.add(topContent); //must use super
	}

	@Override
	public Component add(Component comp) {
		return localContent.add(comp);
	}

	@Override
	public Component add(String name, Component comp) {
		return localContent.add(name, comp);
	}

	@Override
	public Component add(Component comp, int index) {
		return localContent.add(comp, index);
	}

	@Override
	public void add(Component comp, Object constraints) {
		localContent.add(comp, constraints);
	}

	@Override
	public void add(Component comp, Object constraints, int index) {
		localContent.add(comp, constraints, index);
	}

	@Override
	public void showStatus(String status) {
		statusBar.setText(status);
	}

	
}
