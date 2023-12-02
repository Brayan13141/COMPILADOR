/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package METODOS_GRAMATICA;

import TOKENS.TOKENS;
import OBJETOS_TABLA.ERROR;
import OBJETOS_TABLA.OBJETO_T;
import java.util.ArrayList;

/**
 *
 * @author CC25
 */
public class VARIOS {

    public ArrayList<ERROR> errores = new ArrayList<ERROR>();
    METODO M = new METODO();
    DECLARACION DECLARACION = new DECLARACION();
    TYPE T = new TYPE();

    public ArrayList<ERROR> VALIDARVARIOS(ArrayList<OBJETO_T> listaTokens) {
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

        while (listaTokens.size() > 1 && (listaTokens.get(0).getTOKEN() == "TD" || (listaTokens.get(0).getTOKEN() == "MA")))//LOS ERRORES VERIFICAMOS CUANTOS SON Y EL QUE GENERE MENOS ES POR LA OPCION QUE ESTABA BIEN
        {
            //DECLARACIONES == int a= 12; etc.. 
            if (listaTokens.get(0).getTOKEN() == "TD" || (listaTokens.get(0).getTOKEN() == "MA" && listaTokens.get(1).getTOKEN() == "TD" && listaTokens.get(3).getTOKEN() != "PA")
                    || (listaTokens.get(0).getTOKEN() == "MA" && listaTokens.get(1).getTOKEN() == "ST" && listaTokens.get(2).getTOKEN() == "TD" && listaTokens.get(4).getTOKEN() != "PA")) {
                if (DECLARACION.VALIDARDECLARACION(listaTokens).isEmpty() && listaTokens.size() > 1) {
                   errores = VALIDARVARIOS(listaTokens);
                    return errores;
                } else {
                    for (ERROR E : DECLARACION.VALIDARDECLARACION(listaTokens)) {
                        errores.add(E);
                        while (listaTokens.size() > 1) {
                            listaTokens.remove(0);
                        }
                        return errores;
                    }
                    break;
                }

            } else if (listaTokens.get(0).getTOKEN() == "MA") {
                if (M.VALIDARMETODO(listaTokens).isEmpty()) {
                    errores = VALIDARVARIOS(listaTokens);
                    return errores;
                }
            } else {
                for (ERROR E : M.VALIDARMETODO(listaTokens)) {
                    errores.add(E);
                    while (listaTokens.size() > 1) {
                        listaTokens.remove(0);
                    }
                    return errores;
                }
            }
        }
 
        return errores;
    }
}
