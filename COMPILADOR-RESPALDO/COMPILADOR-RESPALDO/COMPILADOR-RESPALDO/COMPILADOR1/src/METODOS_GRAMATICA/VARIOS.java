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
public class VARIOS {

    public ArrayList<ERROR> errores = new ArrayList<ERROR>();

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
        DECLARACION DECLARACION = new DECLARACION();
        while (listaTokens.size() > 1)//LOS ERRORES VERIFICAMOS CUANTOS SON Y EL QUE GENERE MENOS ES POR LA OPCION QUE ESTABA BIEN
        {
            //DECLARACIONES == int a= 12; etc.. 
            if (listaTokens.get(0).getTOKEN() == "TD") {
                if (DECLARACION.VALIDARDECLARACION(listaTokens).isEmpty() && listaTokens.size() > 1) {
                    errores = VALIDARVARIOS(listaTokens);
                    return errores;
                } else {
                    for (ERROR E : DECLARACION.VALIDARDECLARACION(listaTokens)) {
                        errores.add(E);
                        return errores;
                    }
                    break;
                }

            }
            else if(listaTokens.get(0).getTOKEN() == "TD")
            {
                
            }

        }
//        for (ERROR E : DECLARACION.VALIDARDECLARACION(listaTokens)) {
//            errores.add(E);
//        }

        return errores;
    }
}
