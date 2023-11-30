/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package METODOS_GRAMATICA;

import OBJETOS_TABLA.ERROR;
import OBJETOS_TABLA.OBJETO_T;
import java.util.ArrayList;
import METODOS_GRAMATICA.TYPE;

/**
 *
 * @author CC25
 */
//METODO::= MA TYPE ID PA PARAMS PC LLA CUERPO REE LLC;
public class METODO {

    public ArrayList<ERROR> errores = new ArrayList<>();
    TYPE T = new TYPE();
    PARAMETROS P = new PARAMETROS();

    public ArrayList<ERROR> VALIDARMETODO(ArrayList<OBJETO_T> listaTokens) {
        if (listaTokens.get(0).getTOKEN() == "MA") {
            listaTokens.remove(0);
            if (T.VALIDARTYPE(listaTokens).isEmpty()) {
                listaTokens.remove(0);
                if (listaTokens.get(0).getTOKEN() == "ID") {
                    listaTokens.remove(0);
                    if (listaTokens.get(0).getTOKEN() == "PA") {
                        listaTokens.remove(0);
                        if (P.VALIDARPARAMETROS(listaTokens).isEmpty()) {
                            if (listaTokens.get(0).getTOKEN() == "PC") {
                                listaTokens.remove(0);
                                if (listaTokens.get(0).getTOKEN() == "LLA") {
                                    listaTokens.remove(0);
                                }
                            }
                        } else {
                            for (ERROR E : P.VALIDARPARAMETROS(listaTokens)) {
                                errores.add(E);
                                return errores;
                            }
                        }
                    }
                }

            } else {
                for (ERROR E : T.VALIDARTYPE(listaTokens)) {
                    errores.add(E);
                    return errores;
                }
            }
        }
        return errores;
    }

}
