package in.java.venu.employee.management.json.validator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.tomcat.util.json.ParseException;
import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class JsonSchemaValidator {

	private static List<String> listOfViolations;

	public static List<String> validateJson(Object object) throws Exception {

		boolean isSchemaValidaor = false;

		try {
			File file = new File(
					"E:\\STS_Worspaces\\MyLearning\\EmployeeManagement\\src\\main\\resources\\trade-schema.json");
			// FileReader reader = new FileReader("classpath:trade-schema.json");
			JSONTokener tockener = new JSONTokener(new FileInputStream(file));
			JSONObject jsonObject = new JSONObject(tockener);
			Schema schema = SchemaLoader.load(jsonObject);
			schema.validate(new JSONObject(getJsonObj(object)));
			isSchemaValidaor = true;
		} catch (ValidationException e) {
			listOfViolations = e.getCausingExceptions().stream().map(ValidationException::getMessage)
					.collect(Collectors.toList());
		}

		return listOfViolations;
	}


	private static String getJsonObj(Object object) throws JsonProcessingException, ParseException {

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String obj = ow.writeValueAsString(object);
		return obj;

	}

}
