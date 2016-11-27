package org.commons.serialize;

import java.io.IOException;


import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;


public class SerializeUtils {
	
	private static final ObjectMapper MAPPER;
	
	static{
		MAPPER = new ObjectMapper();
	}
	
	public String serialize(Object obj) throws JsonGenerationException, JsonMappingException, IOException {
		
		String jsonInString = MAPPER.writeValueAsString(obj);
		return jsonInString;
	}
	
	public  <T> T deserialize (String str,Class<T> tClass) throws JsonParseException, JsonMappingException, IOException{
		return MAPPER.readValue(str,tClass);
	}
}

