package com.alfaCentauri;

import java.util.*;

public class Ejecutable {
    /**
     * Ejemplo de Map con un buscador por etiqueta y recursividad.
     * @param args Type array string.
     */
    public static void main (String []args) {
        System.out.println("Ejemplo de Map con un buscador por etiqueta y recursividad.");
        String nameTag = "detalles,cantidad";
        Map inputMap = new HashMap();
        Map encabezado = new HashMap();
        encabezado.put("codigo","001");
        encabezado.put("name","Pedro");
        encabezado.put("lastName","Perez");
        List detalles = new ArrayList<>();
        int cantidad = 5;
        for (int i = 0; i < 4; i++) {
            Map element = new HashMap();
            element.put("cantidad", cantidad++);
            String date = String.valueOf(new Date());
            element.put("fecha", date);
            detalles.add(element);
        }
        inputMap.put("encabezado",encabezado);
        inputMap.put("detalles",detalles);
        String result = getValueFromTag(nameTag, inputMap, 0);
        if ( result.equals("") )
            System.out.println( "OK" );
        else
            System.err.println( "Fail" );
    }

    /**
     * @param nameTag Type String.
     * @param input Type map.
     * @return Return a string value or empty.
     **/
    public static String getValueFromTag(String nameTag, Map input, int nivel) {
        String result="";
        String[] arrString = nameTag.split(",");
        Map auxForSearch = input;
        int tottalArray = arrString.length;
        for (int i=0; i < tottalArray; i ++) {
            String tag = arrString[i];
            //Debug
            System.out.println("Buscando la etiqueta: " + tag);
            if ( auxForSearch.containsKey(tag) && ( auxForSearch.get(tag) instanceof String ) ) {
                result = (String) auxForSearch.get(tag);
            }
            else if ( auxForSearch.containsKey(tag) && (auxForSearch.get(tag) instanceof Map) )
                auxForSearch = (Map) auxForSearch.get(tag);
            else if (  auxForSearch.containsKey(tag) && (auxForSearch.get(tag) instanceof ArrayList) ) {
                List listForSearch = (ArrayList) auxForSearch.get(tag);
                for (Object element : listForSearch) {
                    Map mapElement = (Map) element;
                    //Debug
                    System.out.println("El nivel de la recursividad es: " + nivel++);
                    System.out.println("Buscando: " + tag + " en el map: " + mapElement);
                    if( i+1 < tottalArray ) {
                        String tagToFind = arrString[i + 1];
                        result = getValueFromTag(tagToFind, mapElement, nivel);
                    }
                    else {
                        break;
                    }
                }
            }
        }
        //Debug
        System.out.println("El resultado es: " + result);
        return result;
    }
}
