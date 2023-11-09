/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metodos;

import OBJETOS_TABLA.OBJETO_T;
import java.awt.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Brayan
 */
public class PROC_CODIGO {

    public ArrayList<Integer> espacios = new ArrayList<Integer>();

//--------------------------------------------OBTENER ESPACIOS--------------------------------------------
    public ArrayList<Integer> getEspacios() {
        return espacios;
    }
//--------------------------------------------DEPURAR CODIGO--------------------------------------------

    public String depurarCodigo(String Codigo) {
        String codigo = Codigo;
        int contadorSalto = 0;
        String corte1 = "", a = "";
//SE HACE UN RECORRIDO PARA CADA CARACTER EN LA CADENA codigo (for)
        for (int i = 0; i < codigo.length(); i++) {
//SR CREA UN CORTE PARA GUARDAR EL CARACTER
            corte1 = codigo.substring(i, i + 1);
            if (!corte1.equals("")) {
//SI ENCUENTRA UN SALTO DE LINEA AÑADE LA POSICION A UN ARRAYLIST PARA DESPUES AGREGAR LOS SALTOS DE LINEA Y SE PUEDA LEER MEJOR
                if (corte1.equals("\n")) {
                    a += " ";
                    espacios.add(contadorSalto);
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
                } else if (corte1.equals("/") && codigo.substring(i + 1, i + 2).equals("/")) {
                    int h = i + 2;
                    String corte2 = "";
                    for (;;) {
                        corte2 = codigo.substring(h, h + 1);
                        if (corte2.equals("\n")) {//SI ENCUENTRA UN SALTO DE LINEA SE DETIENE POR QUE ACABO EL COMENTARIO
                            i = h + 1;
                            break;
                        }
                        h++;
                    }
                }//LA FUNCION DE ESTE CODIGO ES IGNORAR LOS SALTOS DE LINEA Y COMENTARIOS MEDIANTE FILTROS 
                else {
//SI LOS CARACTERES ANALIZADOS NO CONCUERDAN CON NINGUN if SE AGREGARAN A UNA NUEVA VARIABLE QUE ES LA QUE
//LLEVA EL CODIGO DEPURADO(corte1) ES DECIR SI NO ES COMENTARIO O SALTO DE LINEA LO AGREGA AL CODIGO 
                    a += corte1;
                }

            }
            contadorSalto++;
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
            nuevo += " ";
            b++;
            for (; b < B.length(); b++) {
                nuevo += B.charAt(b);
            }
        }
        return nuevo;
    }
//--------------------------------------------DIVIDIR SALTOS DE LINEA--------------------------------------------

    public String Agregar(ArrayList A, String B) {
        int Control = 0;
        String nuevo = "";
        int Contro2 = 0;

        for (Object a : A) {
            int d = (int) a;
            for (int i = Control; i < d; i++) {
                if (i < B.length()) {
                    nuevo += B.charAt(i);
                } else {
                    break;
                }
                Control = i + 1;
            }
            nuevo += "\n";
        }

        return nuevo;
    }

//--------------------------------------------DIVIDIR CODIGO--------------------------------------------
    public String[] DIVIDIRCODIGO(String codigo) {
        String[] corte1;
        corte1 = codigo.split(" ");
        return corte1;
    }
//-------------------------------------------VALIDAR PACKAGE--------------------------------------------
//int a = 12;

    public ArrayList<String> DIVIDIRFINAL(String[] Codigo) {
        ArrayList<String> Arregloreturn = new ArrayList();
        try {
            for (String Cadena : Codigo) {
                if (Cadena.matches("[A-Za-z0-9]+")) {//SI ES UNA CADENA/PALABRA LO AGREGA
                    Arregloreturn.add(Cadena);
                } else {
                    for (String agregar : seguir(Cadena, 0)) {
                        Arregloreturn.add(agregar);
                    }
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return Arregloreturn;
        }
        int contador = 0;
        for (String Blanco : Arregloreturn) {
            if (Blanco.equals("")) {
                Arregloreturn.remove(contador);
                break;
            } else {
                contador++;
            }
        }
        return Arregloreturn;
    }

    @SuppressWarnings("empty-statement")
    public ArrayList<String> seguir(String Cadena, int bandera) {
        ArrayList<String> ControlRETURN = new ArrayList<>();
        int BanR = bandera;
        String Comillas = Cadena.length() > 2
                ? Cadena.substring(0, 1) : "";
        if (Comillas.matches("\"") && Cadena.length() > 1 || Comillas.matches("\'") && Cadena.length() > 1)//FALTA VALIDAR LAS COMILLAS 
        {
            for (int h = 1; h < Cadena.length(); h++) {
                String BuskComilla = Cadena.substring(h, h + 1) != ""
                        ? Cadena.substring(h, h + 1) : "";
                if (BuskComilla.matches("\"") || BuskComilla.matches("\'")) {
                    String STR = BuskComilla.matches("\"")
                            ? "\"" + Cadena.substring(1, h) + "\""
                            : "\'" + Cadena.substring(1, h) + "\'";
                    ControlRETURN.add(STR);
                    if (h + 1 < Cadena.length()) {
                        String C = Cadena.substring(h + 1, Cadena.length());
                        ControlRETURN.add(C);
                        return ControlRETURN;
                    }
                }
            }
        } else {
            for (int i = 0; i < Cadena.length(); i++) {//CICLO PRINCIPAL
                String corte = Cadena.substring(i, i + 1) != "" ? Cadena.substring(i, i + 1) : "";
                if (!corte.matches("[A-Za-z0-9]+") && corte != "") {//BUSCA EL CARACTER ESPECIAL
                    if (Cadena.length() > 1) {//SI SOLO ES UN CARACTER LO AGREGA DIRECTAMENTE                      
                        String Cadena2 = Cadena.substring(0, i) != "" ? Cadena.substring(0, i) : "";//SI NO REALIZA UN CORTE DESDE 0 
                        String Caracter = Cadena.substring(i, i + 1) != "" ? Cadena.substring(i, i + 1) : "";//HASTA I PARA GENERAR LAS NUEVAS CADENAS
                        ControlRETURN.add(Cadena2);
                        ControlRETURN.add(Caracter);
                        if (i + 1 < Cadena.length()) {//SI AUN HAY MAS TEXTO LLAMA A UNA FUNCION RECURSIVA
                            //FALTA AGREGAR QUE SIGA MIENTRAS AUN 
                            //TENGA TEXTO
                            BanR = 1;
                            ArrayList<String> ControlRETURN2 = seguir(Cadena.substring(i + 1, Cadena.length()), BanR);

                            for (String Add1 : ControlRETURN2) {
                                ControlRETURN.add(Add1);
                            }
                            break;
                        }

                    } else {//SI EL TAMAÑO NO ES MAYOR A 1 ES UN SOLO CARACTER Y SE AGREGA AL 
                        //ARREGLO
                        ControlRETURN.add(Cadena);
                    }
                } else {//SI TODOS LOS CARACTERES DE LA CADENA SON LETRAS AGREGA LA CADENA
                    if (i == Cadena.length() - 1 && BanR == 1) {
                        ControlRETURN.add(Cadena);
                        break;//YA SIGUE AGREGANDO
                    }
                }
            }
        }
        return ControlRETURN;
    }

    public ArrayList<OBJETO_T> CLASIFICAR(ArrayList<String> a) {
        TOKENS A = new TOKENS();//CREAMOS EL OBJETO DE TOKENS Y OBTENEMOS LOS TOKENS
        String[][] TOK = A.getTOKENS(); // CREAMOS EL ARREGLO Y LO INICIALIZAMOS CON LOS TOKENS
        ArrayList<OBJETO_T> LISTAT = new ArrayList<>();
        for (String Cadena : a) {
            int limite = TOK.length;
            int inicio = 0;
            for (String[] TOKEN : TOK) {
                if (Cadena.matches(TOKEN[0])) {
                    OBJETO_T NUEVOITEM = new OBJETO_T(Cadena, TOKEN[1]);
                    LISTAT.add(NUEVOITEM);
                    break;
                } else if (inicio == limite - 1) {
                    OBJETO_T NUEVOITEM = new OBJETO_T(Cadena, "INDEFINIDO");
                    LISTAT.add(NUEVOITEM);
                } else {
                    inicio++;
                }
            }

        }
        return LISTAT;
    }

}
