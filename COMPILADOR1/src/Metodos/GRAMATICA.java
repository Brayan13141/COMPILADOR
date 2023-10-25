/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metodos;

import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author Brayan
 */
public class GRAMATICA {

//--------------------------------------------DEPURAR CODIGO--------------------------------------------
    public String depurarCodigo(String Codigo) {
        String codigo = Codigo;
        String corte1 = "", a = "";
        ArrayList<Integer> espacios = new ArrayList<Integer>();
//SE HACE UN RECORRIDO PARA CADA CARACTER EN LA CADENA codigo (for)
        for (int i = 0; i < codigo.length(); i++) {
//SR CREA UN CORTE PARA GUARDAR EL CARACTER
            corte1 = codigo.substring(i, i + 1);
            if (!corte1.equals("")) {
//SI ENCUENTRA UN SALTO DE LINEA AÑADE LA POSICION A UN ARRAYLIST PARA DESPUES AGREGAR LOS SALTOS DE LINEA Y SE PUEDA LEER MEJOR
                if (corte1.equals("\n")) {
                    espacios.add(i);
//SI ENCUENTRA UNA DIAGONAL Y EL SIGUIENTE CARACTER ES UN ASTERISCO SIGNIFICA QUE COMIENZA UN COMENTARIO
                } else if (corte1.equals("/") && codigo.substring(i + 1, i + 2).equals("*")) {
                    int h = i + 2;
                    String corte2 = "";
//SE RECORRE TODO EL COMENTARIO CON UN FOR INFINITO HASTA ENCONTRAR EL CIERRE DE OTRO COMENTARIO
                    for (;;) {
                        corte2 = codigo.substring(h, h + 1);
                        if (corte2.equals("*") && codigo.substring(h + 1, h + 2).equals("/")) {
//CUANDO SE ENCUENTRA CON EL FINAL DEL COMENTARIO LA VARIABLE i QUE LLEVA EL CONTROL DE EN CUAL CARACTER VAMOS
//SE IGUALA A LO QUE VALE h QUE ES LA VARIABLE QUE CONTROLA EN QUE CARACTER VAMOS DEL COMENTARIO Y MUTUAMENTE
//CON LA SUMA DE h & i TENEMOS EL TOTAL DEL CARACTER EN EL QUE NOS ENCONTRAMOS DE TODO EL CODIGO
                            i = h + 1;
                            break;
                        }
                        h++;
                    }
//COMENTARIOS DE LINEA, HACE EXACTAMENTE LO ANTERIOR PERO SE DETIENE CUANDO ENCUENTRA UN SALTO DE LINEA LO QUE SIGNIFICA QUE EL 
//COMENTARIO DE LINEA TERMINO
                } else if (corte1.equals("/") && codigo.substring(i + 1, i + 2).equals("*")) {

                }//LA FUNCION DE ESTE CODIGO ES IGNORAR LOS SALTOS DE LINEA Y COMENTARIOS MEDIANTE FILTROS 
                else {
//SI LOS CARACTERES ANALIZADOS NO CONCUERDAN CON NINGUN if SE AGREGARAN A UNA NUEVA VARIABLE QUE ES LA QUE
//LLEVA EL CODIGO DEPURADO(corte1) ES DECIR SI NO ES COMENTARIO O SALTO DE LINEA LO AGREGA AL CODIGO 
                    a += corte1;
                }

            }
        }
        return a;
    }
//--------------------------------------------AGREGAR ESPACIOS--------------------------------------------

    public String Agregarespacios(ArrayList A, String B) {
        int a = 0;
        String nuevo = "";
        int b = 0;
        for (int i = 0; i < A.size(); i++) {
            a = (int) A.get(i);
            for (int h = 0; h <= a; h++) {
                nuevo += B.charAt(h);
                b = h - 1;
            }
            nuevo += "\n";
            b++;
            for (; b < B.length(); b++) {
                nuevo += B.charAt(b);
            }
        }
        return nuevo;
    }
//--------------------------------------------DIVIDIR CODIGO--------------------------------------------

    /**
     *
     * @param input
     * @return
     */
    public ArrayList<String> DIVIDIRCODIGO(String input) {
        // Dividir la cadena en palabras usando el espacio como separador
        ArrayList words = new ArrayList<String>();
        String Arr[] = input.split(" ");
        for (String a : Arr) {
            if (a != null) {
                words.add(a);
            }
        }
        return words;
    }
}
