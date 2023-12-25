package com.alfaCentauri;

import java.util.*;

public class Ejecutable5 {
    /**
     * Ejemplo de Map con un arreglo sin nombre.
     * @param args Type array string.
     */
    public static void main (String []args) {
        System.out.println("Ejemplo de Map con un arreglo sin nombre.");
        Map mapa = new HashMap();
        mapa.put("numeroBarras","");
        mapa.put("codigo", "12345678");
        System.out.println("Map " + mapa);
        /**/
        List list = new ArrayList();
        Map element = new HashMap();
        String numeroBarras = (String) mapa.get("numeroBarras");
        String codigo = (String) mapa.get("codigo");
        /* debug */
        System.out.println( "numeroBarras:  " + numeroBarras );
        System.out.println( "codigo:  " + codigo );
        /**/
        element.put("numeroBarras", numeroBarras);
        element.put("codigo", codigo);
        list.add( element );
        mapa.remove("numeroBarras");
        mapa.remove("codigo");
        mapa.put("",list);
        Object[] pruebas = list.toArray();
        /* debug */
        System.out.println( "Map despues " + mapa );
    }
}
