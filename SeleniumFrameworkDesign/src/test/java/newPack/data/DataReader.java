package newPack.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {


	public List<HashMap<Object,Object[]>> getJsonDataToMap() throws IOException
	{
	String jsonContent =	FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\newPack\\data\\productList.json"),StandardCharsets.UTF_8);
	ObjectMapper objectMapper = new ObjectMapper();

	List<HashMap<Object,Object[]>> data = objectMapper.readValue(jsonContent, new TypeReference<List<HashMap<Object,Object[]>>>(){});
	return data;
	}

}
