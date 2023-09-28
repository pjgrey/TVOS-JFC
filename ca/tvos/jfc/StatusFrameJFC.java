/**
 * 
 */
package ca.tvos.jfc;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ca.tvos.applet.Controller;
import ca.tvos.applet.ControllerWL;
import ca.tvos.applet.AutoExitAM;

/**
 * 
 */
public class StatusFrameJFC extends JFrame implements StatusPresenter {

	public static void main(String[] arg) { // testing only
		AutoExitAM exit_on_close = new AutoExitAM();
		Controller cntrl = new Controller(exit_on_close);
		StatusFrameJFC frame = new StatusFrameJFC();
		frame.addWindowListener(new AutoCloseWL());
		frame.addWindowListener(new ControllerWL(cntrl));

//		frame.addWindowListener(new WindowStatusWL(frame, frame));

		frame.pack();
		frame.setVisible(true);

		frame.statusBar.setText("Generic test message");

	}

	private final JPanel topContent = new JPanel();
	private Container localContent = new JPanel();
	private final JTextField statusBar = new JTextField("Test text");

	private void setupStatusBar() {
		topContent.setLayout(new BorderLayout());
		topContent.add(localContent, BorderLayout.CENTER);
		topContent.add(statusBar, BorderLayout.SOUTH);
		super.setContentPane(topContent); // must use main widget setContentPane
		localContent.setPreferredSize( new Dimension(500, 300) );

	}

	public StatusFrameJFC() throws HeadlessException {
		super();
		setupStatusBar();
	}

	public StatusFrameJFC(GraphicsConfiguration gc) {
		super(gc);
		setupStatusBar();
	}

	public StatusFrameJFC(String title, GraphicsConfiguration gc) {
		super(title, gc);
		setupStatusBar();
	}

	public StatusFrameJFC(String title) throws HeadlessException {
		super(title);
		setupStatusBar();
	}

	private static final long serialVersionUID = -7118379612871250090L;

	public void showStatus(String status) {
		synchronized (statusBar) {
			statusBar.setText(status);
		}
	}

	/*
	 * == = = == = = == = = == = = == = = == = = == = = == = = == = = == = = == = =
	 * == = = == = = == = = ==
	 */

	@Override
	public Container getContentPane() {
		return localContent;
	}

	@Override
	public void setContentPane(Container newContent) {
		localContent = newContent;
		topContent.add(localContent, BorderLayout.CENTER);
	}

}
