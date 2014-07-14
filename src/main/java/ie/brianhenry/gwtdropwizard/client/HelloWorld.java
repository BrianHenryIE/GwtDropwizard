package ie.brianhenry.gwtdropwizard.client;

import com.google.gwt.core.client.JavaScriptObject;

public class HelloWorld extends JavaScriptObject {

	protected HelloWorld() {}
	
	public final native String getId() /*-{
		return this.id;
	}-*/;

	public final native String getContent() /*-{
		return this.content;
	}-*/;
}
