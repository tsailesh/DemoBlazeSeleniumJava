/**
 * @auther sailesh
 *
 */
package demoblazeAutomation.utilities;

/**
 * 
 */

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.FileUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {

	public static List<HashMap<String, String>> getJSONdataToMap(String filePath) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonContent;
		List<HashMap<String, String>> data = null;
		try {
			// Reads the contents of a file into a String.
			jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
			// String to Hashmap - jackson DataBind
			data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
			});
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;

	}

}
