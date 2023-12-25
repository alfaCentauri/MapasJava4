package com.alfaCentauri;

import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class Ejecutable7 {

    public static void main(String[] args) {
        // Assume we have a JSON string:
        String jsonString = "{\"name\":\"John\",\"age\":30,\"city\":\"New York\", \"profesion\":{\"titulo\":\"Profesor\",\"Antiguedad\":2}}";

        // Convert JSON to Map
        Map<String, Object> map = convertJsonToMap(jsonString);

        // Print the resulting Map
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static Map<String, Object> convertJsonToMap(String jsonString) {
        JSONObject jsonObject = new JSONObject(jsonString);
        Map<String, Object> map = new HashMap<>();

        for (String key : jsonObject.keySet()) {
            Object value = jsonObject.get(key);
            map.put(key, value);
        }

        return map;
    }
}
