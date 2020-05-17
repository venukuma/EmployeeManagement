package in.java.venu.employee.management.json.validator;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.java.venu.employee.management.entity.Address;
import in.java.venu.employee.management.entity.Employee;

public class JsonValidator {
	
	 public static void main(String[] args) throws IOException {
	        System.out.println(getJsonSchema(Employee.class));
	    }
		
	 public static String getJsonSchema(Class clazz) throws IOException {
         Field[] fields = clazz.getDeclaredFields();
         List<Map<String,String>> map=new ArrayList<Map<String,String>>();
         for (Field field : fields) {
             HashMap<String, String> objMap=new  HashMap<String, String>();
             objMap.put("name", field.getName());
             objMap.put("type", field.getType().getSimpleName());
             objMap.put("format", "");
             map.add(objMap);
         }
         ObjectMapper mapper = new ObjectMapper();
         String json = mapper.writeValueAsString(map);

       return json;
    }

}
