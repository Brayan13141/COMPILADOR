/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package METODOS_GRAMATICA;

import GRAMATICA.TOKENS;
import OBJETOS_TABLA.ERROR;
import OBJETOS_TABLA.OBJETO_T;
import java.util.ArrayList;

/**
 *
 * @author CC25
 */
public class EXPRECION {

    public ArrayList<ERROR> errores = new ArrayList<ERROR>();
//EXPC ::= VAL OPA VAL| VAL OPA EXPC| PA VAL OPA VAL PC| PA VAL OPA EXPC PC

    public ArrayList<ERROR> EXPRECIONVAL(ArrayList<OBJETO_T> listaTokens) {
        DECLARACIONVALOR DECLARACION = new DECLARACIONVALOR();
        if (DECLARACION.VALIDAR_VALOR(listaTokens.get(0)) || listaTokens.get(0).getTOKEN() == "PA") {
            if (listaTokens.get(0).getTOKEN() == "PA") {
                listaTokens.remove(0);
                errores = EXPRECIONVAL(listaTokens);
                return errores;
            } else if (DECLARACION.VALIDAR_VALOR(listaTokens.get(0))) {
                listaTokens.remove(0);
            }

            if (listaTokens.get(0).getTOKEN() == "OPA") {
                listaTokens.remove(0);
                if (DECLARACION.VALIDAR_VALOR(listaTokens.get(0)) || listaTokens.get(0).getTOKEN() == "PA") {
                    errores = EXPRECIONVAL(listaTokens);
                    return errores;
                } else {
                    ERROR NUEVOITEM = new ERROR(listaTokens.get(0).getLinea(), "SINTACTICO", listaTokens.get(0).getLexema(), "SE ESPERABA UN TD || PA");
                    errores.add(NUEVOITEM);
                    return errores;
                }
            } else if (listaTokens.get(0).getTOKEN() == "PC" && listaTokens.get(1).getTOKEN() == "FI") {
                listaTokens.remove(0);
                return errores;
            } else if (listaTokens.get(0).getTOKEN() == "PC" && listaTokens.get(1).getTOKEN() == "OPA") {
                listaTokens.remove(0);
                listaTokens.remove(0);
                errores = EXPRECIONVAL(listaTokens);
                return errores;
            } else if ((listaTokens.get(0).getTOKEN() == "PC" && listaTokens.get(1).getTOKEN() == "PC") || listaTokens.get(0).getTOKEN() == "PC") {
                while (listaTokens.get(0).getTOKEN() == "PC") {
                    listaTokens.remove(0);
                }
                if (listaTokens.get(0).getTOKEN() == "OPA") {
                    listaTokens.remove(0);
                    errores = EXPRECIONVAL(listaTokens);
                    return errores;
                } else {
                    return errores;
                }

            }else {
                    ERROR NUEVOITEM = new ERROR(listaTokens.get(0).getLinea(), "SINTACTICO", listaTokens.get(0).getLexema(), "SE ESPERABA UN OPA || PC");
                    errores.add(NUEVOITEM);
                    return errores;
                }

        }
        ERROR NUEVOITEM = new ERROR(listaTokens.get(0).getLinea(), "SINTACTICO", listaTokens.get(0).getLexema(), "SE ESPERABA UN TD || PA");
        errores.add(NUEVOITEM);
        return errores;

    }

    public ArrayList<ERROR> VALIDAREXPRECION(ArrayList<OBJETO_T> listaTokens) {
        int count = 0;
        TOKENS A = new TOKENS();//CREAMOS EL OBJETO DE TOKENS Y OBTENEMOS LOS TOKENS
        String[][] TOK = A.getTOKENS(); // CREAMOS EL ARREGLO Y LO INICIALIZAMOS CON LOS TOKENS
        ArrayList<OBJETO_T> LISTAT2 = new ArrayList<>();
        for (OBJETO_T Cadena : listaTokens) {
            LISTAT2.add(Cadena);
            count++;
            if (count == 5) {
                break;
            }
        }
        DECLARACIONVALOR DECLARACION = new DECLARACIONVALOR();
        //LLAMA A "VAL" VALIDA QUE SEA UN TIPO DE DATO
        if (DECLARACION.VALIDAR_VALOR(listaTokens.get(0))) {//VAL
            if (LISTAT2.get(1).getTOKEN() == "OPA") {
                listaTokens.remove(0);
                listaTokens.remove(0);
                if (DECLARACION.VALIDAR_VALOR(listaTokens.get(0)) && listaTokens.get(1).getTOKEN() == "FI") {
                    listaTokens.remove(0);
                    return errores;
                } else if (DECLARACION.VALIDAR_VALOR(listaTokens.get(0)) && listaTokens.get(1).getTOKEN() == "OPA") {
                    listaTokens.remove(0);
                    listaTokens.remove(0);
                    errores = VALIDAREXPRECION(listaTokens);
                    return errores;
                }
            }
        }
        if (listaTokens.get(0).getTOKEN() == "PA") {
            listaTokens.remove(0);
            if (DECLARACION.VALIDAR_VALOR(listaTokens.get(0))) {
                listaTokens.remove(0);
                if (listaTokens.get(0).getTOKEN() == "OPA") {
                    listaTokens.remove(0);
                    if (DECLARACION.VALIDAR_VALOR(listaTokens.get(0)) && listaTokens.get(1).getTOKEN() == "PC") {
                        listaTokens.remove(0);
                        listaTokens.remove(0);
                        return errores;
                    } else if (DECLARACION.VALIDAR_VALOR(listaTokens.get(0)) || listaTokens.get(0).getTOKEN() == "PA") {
                        if (DECLARACION.VALIDAR_VALOR(listaTokens.get(0))) {
                            while (DECLARACION.VALIDAR_VALOR(listaTokens.get(0)) || listaTokens.get(0).getTOKEN() == "OPA") {
                                listaTokens.remove(0);
                            }
                        } else {
                            errores = VALIDAREXPRECION(listaTokens);
                            listaTokens.remove(0);
                        }
                        listaTokens.remove(0);
                        return errores;

                    }
                }

            }
        }
        return errores;
    }
}
