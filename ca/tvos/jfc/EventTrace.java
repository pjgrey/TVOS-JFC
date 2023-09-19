/**
 * 
 */
package ca.tvos.jfc;

import ca.tvos.base.SysIO;
import ca.tvos.util.StringUtil;

/**
 * 
 */
public class EventTrace {

	private String context = null;
	
	protected final void trace(String msg) {
		if( context == null)
			context = StringUtil.objectLabel(this) + " : ";
		SysIO.println(context + msg);
	}
	
}
