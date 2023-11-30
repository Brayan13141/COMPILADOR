/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package METODO_CODIGO;

import METODOS_GRAMATICA.PCK_CLASS;
import TOKENS.TOKENS;
import OBJETOS_TABLA.ERROR;
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
    public ArrayList<ERROR> errores = new ArrayList<ERROR>();
   

    public ArrayList<ERROR> getErrores() {
        return errores;
    }

    public void AgregarE(ERROR E) {
        errores.add(E);
    }

    public void setErrores(ArrayList<ERROR> errores) {
        this.errores = errores;
    }

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

                //---------------------------------------------------------------------------------------------------------------
                String salto = i + 2 <= codigo.length() ? codigo.substring(i + 1, i + 2) : "";//REVISAR
                int TamañoCodigo = codigo.length();
                if (corte1.equals("\n") && !"\n".equals(salto)) {
                    a += "°";
                    int Control = espacios.size() != 0 ? espacios.get(espacios.size() - 1) : 0;
                    if (contadorSalto >= Control + 2)//REVISAR EL RANGO DE LOS SALTOS(NO JUNTOS)
                    {
                        espacios.add(contadorSalto);
                    }
                } else if (corte1.equals("\n") && "\n".equals(salto)) {
                    // a += "°";
                    i += 1;
                    //---------------------------------------------------------------------------------------------------------------
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
                            i = h;
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

    //--------------------------------------------DIVIDIR SALTOS DE LINEA--------------------------------------------
    public String Agregar(ArrayList A, String B) {
        int Control = 0;
        String nuevo = "";
        int Contro2 = 0;

        for (Object a : A) {
            int d = (int) a;
            for (int i = Control; i < d; i++) {
                if (i < B.length()) {
                    if (B.substring(i, i + 1) == "°") {
                        i += 1;
                    } else {
                        String c = B.substring(i, i + 1);
                        if (!"".equals(c) && !"°".equals(c)) {
                            nuevo += B.charAt(i);
                        }

                    }
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
        eliminarVacios(Arregloreturn);
        return Arregloreturn;
    }

    public void eliminarVacios(ArrayList<String> Arregloreturn) {
        int contador = 0;
        ArrayList<Integer> vacios = new ArrayList();
        for (String Blanco : Arregloreturn) {
            if (Blanco.equals("")) {
                vacios.add(contador);
            } else {
                contador++;
            }
        }
        for (int b : vacios) {
            Arregloreturn.remove(b);
        }

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
                        for (String Ob : seguir(Cadena.substring((h + 1), Cadena.length()), 1)) {
                            ControlRETURN.add(Ob);
                        }
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
    String depurado_F;

    public ArrayList<OBJETO_T> CLASIFICAR(ArrayList<String> a) {
        TOKENS A = new TOKENS();//CREAMOS EL OBJETO DE TOKENS Y OBTENEMOS LOS TOKENS
        String[][] TOK = A.getTOKENS(); // CREAMOS EL ARREGLO Y LO INICIALIZAMOS CON LOS TOKENS
        ArrayList<OBJETO_T> LISTAT = new ArrayList<>();
        int linea = 0;
        for (String Cadena : a) {
            int limite = TOK.length;
            int inicio = 0;
            for (String[] TOKEN : TOK) {
                if (Cadena.matches("°")) {
                    linea++;
                    break;
                } else if (Cadena.matches(TOKEN[0])) {
                    OBJETO_T NUEVOITEM = new OBJETO_T(String.valueOf(linea), Cadena, TOKEN[1]);
                    LISTAT.add(NUEVOITEM);
                    break;
                } else if (inicio == limite - 1 && !Cadena.equals("\"")) {
                    ERROR NUEVOITEM = new ERROR(String.valueOf(linea), "LEXICO", Cadena, "NO SE RECONOCE");
                    errores.add(NUEVOITEM);
                    OBJETO_T NUEVOITEM1 = new OBJETO_T(String.valueOf(linea), Cadena, "ND");
                    LISTAT.add(NUEVOITEM1);
                } else {
                    inicio++;
                }
            }

        }
        return LISTAT;
    }

}
