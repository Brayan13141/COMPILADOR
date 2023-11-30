/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package METODOS_GRAMATICA;

import OBJETOS_TABLA.ERROR;
import OBJETOS_TABLA.OBJETO_T;
import java.util.ArrayList;

/**
 *
 * @author LMC Alumno
 */
public class PARAMETROS {
    //PARAM::=TY ID | CO TY ID ;

    public ArrayList<ERROR> errores = new ArrayList<>();
    TYPE T = new TYPE();

    public ArrayList<ERROR> VALIDARPARAMETROS(ArrayList<OBJETO_T> listaTokens) {
        if (T.VALIDARTY(listaTokens).isEmpty()) {
            if (listaTokens.get(0).getTOKEN() == "ID") {
                listaTokens.remove(0);
                if (listaTokens.get(0).getTOKEN() == "CO") {
                    listaTokens.remove(0);
                    VALIDARPARAMETROS(listaTokens);
                }else{
                    return errores;
                }
            } else {
                ERROR NUEVOITEM = new ERROR(listaTokens.get(0).getLinea(), "SINTACTICO", listaTokens.get(0).getLexema(), "SE ESPERABA UN ID");
                errores.add(NUEVOITEM);
                return errores;
            }
        } else {
            ERROR NUEVOITEM = new ERROR(listaTokens.get(0).getLinea(), "SINTACTICO", listaTokens.get(0).getLexema(), "SE ESPERABA UN ID||TD||STR");
            errores.add(NUEVOITEM);
            return errores;
        }
        return errores;

    }
}
