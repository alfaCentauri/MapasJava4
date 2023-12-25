package com.alfaCentauri;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.*;

public class Ejecutable6 {

    public static void main(String []args){
        System.out.println("Prueba de transformación de map a json");
        Map<String, Object> data = new HashMap<>();
        data.put("CS", "Post1");
        data.put("Linux", "Post1");
        data.put("Kotlin", "Post1");
        String result = given_HashMapData_whenUsingGson_thenConvertToJson(data);
        System.out.println("Resultado #1 " + result);
        Map result2 = given_JsonData_whenUsingGson_thenConvertToHashMap(data);
        System.out.println("Resultado #2 " + result2);
        result = "{\"CS\":\"Post1\",\"Linux\":\"Post1\",\"Kotlin\":\"Post1\",\"CPlusPlus\":\"Post1\"}";
        result2 = given_JsonData_whenUsingGson_thenConvertToHashMap2(result);
        System.out.println("Resultado #3 " + result2);
        System.out.println("OK");
    }

    public static String given_HashMapData_whenUsingGson_thenConvertToJson(Map<String, Object> data) {
        Gson gson = new Gson();
        Type typeObject = new TypeToken<HashMap>() {}.getType();
        String gsonData = gson.toJson(data, typeObject);
//        Assertions.assertEquals(gsonData, originalJsonData);
        return gsonData;
    }

    public static Map<String, Object> given_JsonData_whenUsingGson_thenConvertToHashMap( Map<String, Object> data ) {
        Gson gson = new Gson();
        Type typeObject = new TypeToken<HashMap>() {}.getType();
        String gsonData = gson.toJson(data, typeObject);
        Map<String, Object> mapObj = new Gson().fromJson(
                gsonData, new TypeToken<HashMap<String, Object>>() {}.getType()
        );
        return mapObj;
    }

    public static Map<String, Object> given_JsonData_whenUsingGson_thenConvertToHashMap2( String gsonData ) {
        Map<String, Object> mapObj = new Gson().fromJson(
                gsonData, new TypeToken<HashMap<String, Object>>() {}.getType()
        );
        return mapObj;
    }
}
