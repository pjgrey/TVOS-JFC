package ca.tvos.jfc;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class TraceCompL extends EventTrace implements ComponentListener {

	@Override
	public void componentResized(ComponentEvent e) {
		trace("resized");
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		trace("moved");
	}

	@Override
	public void componentShown(ComponentEvent e) {
		trace("shown");
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		trace("hidden");
	}

}
