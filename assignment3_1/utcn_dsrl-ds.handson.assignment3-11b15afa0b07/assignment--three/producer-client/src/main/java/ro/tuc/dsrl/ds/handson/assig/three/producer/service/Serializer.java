package ro.tuc.dsrl.ds.handson.assig.three.producer.service;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import ro.tuc.dsrl.ds.handson.assig.three.producer.model.DVD;

public class Serializer {
	
	public String serializeDVD(DVD dvd) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(dvd);
		return jsonInString;
	}
}
