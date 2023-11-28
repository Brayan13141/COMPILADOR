/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package METODOS_GRAMATICA;

import GRAMATICA.GRAMATICA;
import GRAMATICA.TOKENS;
import OBJETOS_TABLA.ERROR;
import OBJETOS_TABLA.OBJETO_T;
import java.util.ArrayList;

/**
 *
 * @author LMC Alumno
 */
public class DECLARACIONVALOR {

    public ArrayList<ERROR> errores = new ArrayList<ERROR>();

    public boolean VALIDAR_VALOR(OBJETO_T listaTokens) {
        int count = 0;
        TOKENS A = new TOKENS();//CREAMOS EL OBJETO DE TOKENS Y OBTENEMOS LOS TOKENS
        String[][] TOK = A.getTOKENS(); // CREAMOS EL ARREGLO Y LO INICIALIZAMOS CON LOS TOKENS
        ArrayList<OBJETO_T> LISTAT2 = new ArrayList<>();

        if ("VTE".equals(listaTokens.getTOKEN())
                || "VTD".equals(listaTokens.getTOKEN())
                || "VTS".equals(listaTokens.getTOKEN())
                || "VTB".equals(listaTokens.getTOKEN())
                || "IDU".equals(listaTokens.getTOKEN())
                || "VTC".equals(listaTokens.getTOKEN())) {
            return true;
        } else {
           
            return false;
        }

    }

}
