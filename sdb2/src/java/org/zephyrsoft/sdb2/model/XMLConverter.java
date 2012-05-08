package org.zephyrsoft.sdb2.model;

import java.io.InputStream;
import java.io.OutputStream;
import com.thoughtworks.xstream.XStream;

/**
 * Converts the {@link MainModel} to and from XML.
 * 
 * @author Mathis Dirksen-Thedens
 */
public class XMLConverter {
	
	public static String fromModelToXML(MainModel model) {
		XStream xstream = initXStream();
		return xstream.toXML(model);
	}
	
	public static void fromModelToXML(MainModel model, OutputStream outputStream) {
		XStream xstream = initXStream();
		xstream.toXML(model, outputStream);
	}
	
	public static MainModel fromXMLToModel(String xmlString) {
		XStream xstream = initXStream();
		MainModel model = (MainModel) xstream.fromXML(xmlString);
		model.initIfNecessary();
		return model;
	}
	
	public static MainModel fromXMLToModel(InputStream xmlInputStream) {
		XStream xstream = initXStream();
		MainModel model = (MainModel) xstream.fromXML(xmlInputStream);
		model.initIfNecessary();
		return model;
	}
	
	private static XStream initXStream() {
		XStream xstream = new XStream();
		// aliases and omitted fields are defined via annotations
		xstream.processAnnotations(MainModel.class);
		xstream.processAnnotations(Song.class);
		return xstream;
	}
	
}