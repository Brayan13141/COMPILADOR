/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GRAMATICA;

import Metodos.TOKENS;
import OBJETOS_TABLA.OBJETO_T;
import java.util.ArrayList;

/**
 *
 * @author LMC Alumno
 */
public class GRAMATICA {
//
    public void VALIDAR_PCK(ArrayList<OBJETO_T> listaTokens) {
        int count = 0;
        TOKENS A = new TOKENS();//CREAMOS EL OBJETO DE TOKENS Y OBTENEMOS LOS TOKENS
        String[][] TOK = A.getTOKENS(); // CREAMOS EL ARREGLO Y LO INICIALIZAMOS CON LOS TOKENS
        ArrayList<OBJETO_T> LISTAT2 = new ArrayList<>();
        for (OBJETO_T Cadena : listaTokens) {
            LISTAT2.add(Cadena);
            count++;
            if (count == 3) {
                break;
            }
        }
        if (LISTAT2.get(0).getTOKEN() == "PCK") {
            if (LISTAT2.get(1).getTOKEN() == "IDU") {
                if (LISTAT2.get(2).getTOKEN() == "FI") {
                   for(int i=0;i<3;i++){
                         listaTokens.remove(0);
                   }
                   if(listaTokens.get(3).getLexema().matches("class"))
                   {
                      VALIDARCLASS(listaTokens); 
                   }
                   else if(listaTokens.get(3).getLexema().matches("import"))
                   {
                       VALIDARIMPORTS(listaTokens);
                   }
                   else{
                    
                   }
                }
            }
        }
    }
    
    public void VALIDARCLASS(ArrayList<OBJETO_T> listaTokens)
    {
        
    }
     public void VALIDARIMPORTS(ArrayList<OBJETO_T> listaTokens)
    {
        
    }
}
