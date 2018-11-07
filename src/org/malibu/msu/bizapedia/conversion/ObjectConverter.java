package org.malibu.msu.bizapedia.conversion;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.datatype.XMLGregorianCalendar;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class ObjectConverter {
	
	private static final Object lock = new Object();
	private static final ObjectMapper objectMapper = new ObjectMapper();
	private static final DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	static {
		SimpleModule module = new SimpleModule();
		// mapper for XMLGregorianCalendar to convert to a human readable date string
		module.addSerializer(XMLGregorianCalendar.class, new JsonSerializer<XMLGregorianCalendar>() {
			public void serialize(XMLGregorianCalendar value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
				synchronized (lock) {
					gen.writeString(df.format(value.toGregorianCalendar().getTime()));
				}
			}
		});
		objectMapper.registerModule(module);
	}
	
	/**
	 * Converts all attributes of the supplied object to a {@code LinkedHashMap} class
	 * (preserving the order of attributes), and excluding the attributes supplied in the
	 * {@code attributesToExclude} parameter
	 * 
	 * @param obj object to convert to a {@code Map}
	 * @param attributesToExclude attributes to exclude in the resulting {@code Map}
	 * @return map of attributes
	 */
	public static Map<String, String> convertObjectToMap(Object obj, String... attributesToExclude) {
		// convert to map
		@SuppressWarnings("unchecked")
		Map<String, Object> objAttributes = objectMapper.convertValue(obj, LinkedHashMap.class);
		// remove unneeded attributes
		if(attributesToExclude != null) {
			for (String fieldToExclude : attributesToExclude) {
				objAttributes.remove(fieldToExclude);
			}
		}
		// convert first letter of all keys to uppercase
		Map<String, String> pascalCaseResult = new LinkedHashMap<>(objAttributes.size());
		objAttributes.forEach((key, value) -> pascalCaseResult.put(toPascalCase(key), asString(value)));
		return pascalCaseResult;
	}
	
	/**
	 * Converts a string to PascalCase
	 * <br>
	 * <code>Ex: thisText -> ThisText</code>
	 * 
	 * @param text
	 * @return
	 */
	private static String toPascalCase(String text) {
		StringBuffer buffer = new StringBuffer(text.length());
		if(text.length() > 0) {
			buffer.append(Character.toUpperCase(text.charAt(0)));
		}
		if(text.length() > 1) {
			buffer.append(text.substring(1, text.length()));
		}
		return buffer.toString();
	}
	
	/**
	 * Null-safely converts the supplied object to a string by calling toString if not null, 
	 * and returns an empty string otherwise
	 * 
	 * @param obj object to convert to a string
	 * @return string representation of supplied object
	 */
	private static String asString(Object obj) {
		return obj == null ? "" : obj.toString();
	}
	
}
