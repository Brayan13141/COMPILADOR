/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package METODOS_GRAMATICA;

import OBJETOS_TABLA.ERROR;
import OBJETOS_TABLA.OBJETO_T;
import java.util.ArrayList;

/**
 *
 * @author CC25
 */
public class TYPE {

    public ArrayList<ERROR> errores = new ArrayList<ERROR>();

    public ArrayList<ERROR> VALIDARTYPE(ArrayList<OBJETO_T> listaTokens) {
        if (listaTokens.get(0).getTOKEN() == "TM" || VALIDARTY(listaTokens).isEmpty()) {
            listaTokens.remove(0);
            return errores;
        } else {
            ERROR NUEVOITEM = new ERROR(listaTokens.get(0).getLinea(), "SINTACTICO", listaTokens.get(0).getLexema(), "SE ESPERABA UN ID||TD||STR||TM");
            errores.add(NUEVOITEM);
            return errores;
        }
    }

    DECLARACIONVALOR DECLARACIONVALOR = new DECLARACIONVALOR();
    public ArrayList<ERROR> VALIDARTY(ArrayList<OBJETO_T> listaTokens) {
        if (listaTokens.get(0).getTOKEN() == "ID" || listaTokens.get(0).getTOKEN() == "TD" || listaTokens.get(0).getTOKEN() == "STR") {
            listaTokens.remove(0);
            return errores;
        } else {
            ERROR NUEVOITEM = new ERROR(listaTokens.get(0).getLinea(), "SINTACTICO", listaTokens.get(0).getLexema(), "SE ESPERABA UN ID||TD||STR||TM");
            errores.add(NUEVOITEM);
            return errores;
        }
    }

}
