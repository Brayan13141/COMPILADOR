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
 * @author Guillermo Mata
 */
public class DECLARACION {

    public ArrayList<ERROR> errores = new ArrayList<ERROR>();
    EXPRECION EXPRECION = new EXPRECION();

    public ArrayList<ERROR> VALIDARDECLARACION(ArrayList<OBJETO_T> listaTokens) {
        int count = 0;
        TOKENS A = new TOKENS();//CREAMOS EL OBJETO DE TOKENS Y OBTENEMOS LOS TOKENS
        String[][] TOK = A.getTOKENS(); // CREAMOS EL ARREGLO Y LO INICIALIZAMOS CON LOS TOKENS
        ArrayList<OBJETO_T> LISTAT2 = new ArrayList<>();
        try {
            for (OBJETO_T Cadena : listaTokens) {
                LISTAT2.add(Cadena);
                count++;
                if (count == 5) {
                    break;
                }
            }
//-------------------------OPCION1----------------------------------
            if (LISTAT2.get(0).getTOKEN() == "TD") {
                if (LISTAT2.get(1).getTOKEN() == "IDU") {
                    if (LISTAT2.get(2).getTOKEN() == "FI") {
                        return errores;
                    }
//-------------------------OPCION2----------------------------------
                    if (LISTAT2.get(2).getTOKEN() == "ODA") {
                        for (int i = 0; i < 3; i++) {
                            listaTokens.remove(0);
                        }
                        DECLARACIONVALOR DECLARACIONVALOR = new DECLARACIONVALOR();
                        //LLAMA A "VAL" VALIDA QUE SEA UN TIPO DE DATO
                        if (DECLARACIONVALOR.VALIDAR_VALOR(listaTokens.get(0)) && listaTokens.get(1).getTOKEN() == "FI") {
                            listaTokens.remove(0);
                            if (listaTokens.get(0).getTOKEN() == "FI") {
                                listaTokens.remove(0);
                                return errores;
                            } else {
                                ERROR NUEVOITEM = new ERROR(listaTokens.get(0).getLinea(), "SINTACTICO", listaTokens.get(0).getLexema(), "SE ESPERABA UN FI");
                                errores.add(NUEVOITEM);
                                return errores;
                            }
//---------------------------ERROR-TD----------------------------------------------------------------------------------
                        } else if (EXPRECION.EXPRECIONVAL(listaTokens).size() == 0) {
                            if (listaTokens.get(0).getTOKEN() == "FI") {
                                    listaTokens.remove(0);
                                
                                return errores;
                            } else {
                                ERROR NUEVOITEM = new ERROR(LISTAT2.get(4).getLinea(), "SINTACTICO", LISTAT2.get(4).getLexema(), "SE ESPERABA UN FI");
                                errores.add(NUEVOITEM);
                                return errores;
                            }
                        } else {
                            //-----------ERRORES DE VALOR---------------FALTA
                            for (ERROR E : EXPRECION.EXPRECIONVAL(listaTokens)) {
                                errores.add(E);
                                 return errores;
                            }
                           
                        }
//---------------------------ERROR-ODA--------------------------------------------------------------------------------
                    } else {
                        ERROR NUEVOITEM = new ERROR(LISTAT2.get(2).getLinea(), "SINTACTICO", LISTAT2.get(2).getLexema(), "SE ESPERABA UN ODA");
                        errores.add(NUEVOITEM);
                        return errores;
                    }

//---------------------------ERROR-IDU--------------------------------------------------------------------------------
                } else {
                    ERROR NUEVOITEM = new ERROR(LISTAT2.get(1).getLinea(), "SINTACTICO", LISTAT2.get(1).getLexema(), "SE ESPERABA UN IDU");
                    errores.add(NUEVOITEM);
                    return errores;
                }
//---------------------------ERROR-TD-------------------------------------------------------------------------------------
            } else {
                ERROR NUEVOITEM = new ERROR(LISTAT2.get(0).getLinea(), "SINTACTICO", LISTAT2.get(0).getLexema(), "SE ESPERABA UN TIPO DE DATO");
                errores.add(NUEVOITEM);
                return errores;
            }

        } catch (Exception e) {
        }

        return errores;
    }

}
