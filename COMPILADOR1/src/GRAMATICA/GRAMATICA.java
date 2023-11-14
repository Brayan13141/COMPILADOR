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
                    for (int i = 0; i < 3; i++) {
                        listaTokens.remove(0);
                    }
                    if (listaTokens.get(3).getLexema().matches("class")) {
                        VALIDARCLASS(listaTokens);
                    } else if (listaTokens.get(3).getLexema().matches("import")) {
                        VALIDARIMPORT(listaTokens);
                    } else {
                        
                    }
                }
            }
        }
    }
    
    public void VALIDARIMPORT(ArrayList<OBJETO_T> listaTokens) {
        int count = 0;
        TOKENS A = new TOKENS();//C%REAMOS EL OBJETO DE TOKENS Y OBTENEMOS LOS TOKENS
        String[][] TOK = A.getTOKENS(); // CREAMOS EL ARREGLO Y LO INICIALIZAMOS CON LOS TOKENS
        ArrayList<OBJETO_T> LISTAT2 = new ArrayList<>();
        for (OBJETO_T Cadena : listaTokens) {
            LISTAT2.add(Cadena);
            count++;
            if (count == 4) {
                break;
            }
        }
        if (LISTAT2.get(0).getTOKEN() == "IMP") {
            if (LISTAT2.get(1).getTOKEN() == "ID") {
                if (LISTAT2.get(2).getTOKEN() == "CA") {
                    if (LISTAT2.get(3).getTOKEN() == "FI") {
                        for (int i = 0; i < 4; i++) {
                            listaTokens.remove(0);
                        }
                        if (listaTokens.get(4).getLexema().matches("com")) {
                            VALIDARCOM(listaTokens);
                        } else if (listaTokens.get(4).getLexema().matches("d_glob")) {
                            
                        }
                    }
                }
            }
        }
    }
    
    public void VALIDARCLASS(ArrayList<OBJETO_T> listaTokens) {
        int count = 0;
        TOKENS A = new TOKENS();//CREAMOS EL OBJETO DE TOKENS Y OBTENEMOS LOS TOKENS
        String[][] TOK = A.getTOKENS(); // CREAMOS EL ARREGLO Y LO INICIALIZAMOS CON LOS TOKENS
        ArrayList<OBJETO_T> LISTAT2 = new ArrayList<>();
        for (OBJETO_T Cadena : listaTokens) {
            LISTAT2.add(Cadena);
            count++;
            if (count == 6) {
                break;
            }
        }
        if (LISTAT2.get(0).getTOKEN() == "MA") {
            if (LISTAT2.get(1).getTOKEN() == "CL") {
                if (LISTAT2.get(2).getTOKEN() == "ID") {
                    if (LISTAT2.get(3).getTOKEN() == "LLA") {
                        if (LISTAT2.get(4).getTOKEN() == "CONTENT") {
                            if (LISTAT2.get(5).getTOKEN() == "LLC") {
                                
                            }
                            
                        }
                        for (int i = 0; i < 6; i++) {
                            listaTokens.remove(0);
                        }
                        if (listaTokens.get(6).getLexema().matches("com")) {
                            VALIDARCOM(listaTokens);
                        } else if (listaTokens.get(6).getLexema().matches("d_glob")) {
                            VALIDAR_D_GLOB(listaTokens);
                        }
                    }
                }
            }
        }
        
    }
    
    public void VALIDAR_D_GLOB(ArrayList<OBJETO_T> listaTokens) {
        int count = 0;
        TOKENS A = new TOKENS();
        String[][] TOK = A.getTOKENS(); // CREAMOS EL ARREGLO Y LO INICIALIZAMOS CON LOS TOKENS
        ArrayList<OBJETO_T> LISTAT2 = new ArrayList<>();
        for (OBJETO_T Cadena : listaTokens) {
            LISTAT2.add(Cadena);
            count++;
            if (count == 4) {
                break;
            }
            if (LISTAT2.get(0).getTOKEN() == "MA") {
                if (LISTAT2.get(1).getTOKEN() == "TD") {
                    if (LISTAT2.get(2).getTOKEN() == "ID") {
                        if (LISTAT2.get(3).getTOKEN() == "FI"|| LISTAT2.get(3).getTOKEN()=="ODA"
                                || LISTAT2.get(4).getTOKEN()=="ODA") {
                        }
                        for (int i = 0; i < 4; i++) {
                            listaTokens.remove(0);
                        }
                        if (listaTokens.get(4).getLexema().matches("main")) {
                            VALIDAR_MAIN(listaTokens);
                        } else if (listaTokens.get(4).getLexema().matches("dec")) {
                            VALIDAR_DEC(listaTokens);
                        }
                        
                    }
                    
                }
            }
            
        }
    }
    
    public void VALIDARCOM(ArrayList<OBJETO_T> listaTokens) {
        int count = 0;
        TOKENS A = new TOKENS();//CREAMOS EL OBJETO DE TOKENS Y OBTENEMOS LOS TOKENS
        String[][] TOK = A.getTOKENS(); // CREAMOS EL ARREGLO Y LO INICIALIZAMOS CON LOS TOKENS
        ArrayList<OBJETO_T> LISTAT2 = new ArrayList<>();
        for (OBJETO_T Cadena : listaTokens) {
            LISTAT2.add(Cadena);
            count++;
            if (count == 1) {
                break;
            }
        }
        if (LISTAT2.get(0).getTOKEN() == "CBL") {
            //if (LISTAT2.get(0).getTOKEN()=="CBL" || (LISTAT2.get(0).getTOKEN()=="CLN")) {   question ¿? -M
        }
        for (int i = 0; i < 1; i++) {
            listaTokens.remove(0);
        }
        if (listaTokens.get(1).getLexema().matches("main")) {
            VALIDAR_MAIN(listaTokens);
        } else if (listaTokens.get(1).getLexema().matches("dec")) {
            VALIDAR_DEC(listaTokens);
        }
    }
    
    public void VALIDAR_MAIN(ArrayList<OBJETO_T> listaTokens) {
        int count = 0;
        TOKENS A = new TOKENS();//CREAMOS EL OBJETO DE TOKENS Y OBTENEMOS LOS TOKENS
        String[][] TOK = A.getTOKENS(); // CREAMOS EL ARREGLO Y LO INICIALIZAMOS CON LOS TOKENS
        ArrayList<OBJETO_T> LISTAT2 = new ArrayList<>();
        for (OBJETO_T Cadena : listaTokens) {
            LISTAT2.add(Cadena);
            count++;
            if (count == 12) {
                break;
            }
            if (LISTAT2.get(0).getTOKEN() == "MA") {
                if (LISTAT2.get(1).getTOKEN() == "ST") {
                    if (LISTAT2.get(2).getTOKEN() == "TM") {
                        if (LISTAT2.get(3).getTOKEN() == "PMAIN") {
                            if (LISTAT2.get(4).getTOKEN() == "PA") {
                                if (LISTAT2.get(5).getTOKEN() == "STR") {
                                    if (LISTAT2.get(6).getTOKEN() == "COA") {
                                        if (LISTAT2.get(7).getTOKEN() == "COC") {
                                            if (LISTAT2.get(8).getTOKEN() == "ID") {
                                                if (LISTAT2.get(9).getTOKEN() == "PC") {
                                                    if (LISTAT2.get(10).getTOKEN() == "LLA") {
                                                        if (LISTAT2.get(11).getTOKEN() == "CUERPO") { //AQUI NO SE QUE PEDO SI LO LLEVA O NEL PERO SE LO PUSE. -M 
                                                            if (LISTAT2.get(12).getTOKEN() == "LLCS") {
                                                            }
                                                            for (int i = 0; i < 13; i++) {
                                                                listaTokens.remove(13);
                                                            }
                                                            if (listaTokens.get(13).getLexema().matches("asig")) {
                                                                VALIDAR_ASIG(listaTokens);
                                                                                                                                
                                                            }else if (listaTokens.get(13).getLexema().matches("dec")) {
                                                                    VALIDAR_DEC(listaTokens);
                                                                }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    

    public void VALIDAR_DEC(ArrayList<OBJETO_T> listaTokens) {
        int count = 0;
        TOKENS A = new TOKENS();
        String[][] TOK = A.getTOKENS(); // CREAMOS EL ARREGLO Y LO INICIALIZAMOS CON LOS TOKENS
        ArrayList<OBJETO_T> LISTAT2 = new ArrayList<>();
        for (OBJETO_T Cadena : listaTokens) {
            LISTAT2.add(Cadena);
            count++;
            if (count == 3) {
                break;
            }
            if (LISTAT2.get(0).getTOKEN() == "TD") {
                if (LISTAT2.get(1).getTOKEN() == "ID") {
                    if (LISTAT2.get(3).getTOKEN() == "FI") {
                    }
                    for (int i = 0; i < 3; i++) {
                        listaTokens.remove(0);
                    }
                    if (listaTokens.get(3).getLexema().matches("asig")) {
                        VALIDAR_ASIG(listaTokens);
                    }
                    else if (listaTokens.get(3).getLexema().matches("val")) {
                        VALIDAR_VAL(listaTokens);
                    }
                }
            }
        }
    }
    
    public void VALIDAR_ASIG(ArrayList<OBJETO_T> listaTokens) {
        int count = 0;
        TOKENS A = new TOKENS();
        String[][] TOK = A.getTOKENS();
        ArrayList<OBJETO_T> LISTAT2 = new ArrayList<>();
        for (OBJETO_T Cadena : listaTokens) {
            LISTAT2.add(Cadena);
            count++;
            if (count == 4) {
                break;
            }
            if (LISTAT2.get(0).getTOKEN() == "ID") {
                if (LISTAT2.get(1).getTOKEN() == "ODA") {
                    if (LISTAT2.get(2).getTOKEN() == "VAL") {
                        if (LISTAT2.get(3).getTOKEN() == "FI") {
                        }
                        for (int i = 0; i < 4; i++) {
                        }
                            listaTokens.remove(0);
                            
                        if (listaTokens.get(4).getLexema().matches("val")) {
                        VALIDARCLASS(listaTokens);
                        
                    }else if (listaTokens.get(4).getLexema().matches("expc")) {
                            
                        }
                            
                        
                    }
                }
            }
            
        }
    }

    public void VALIDAR_VAL(ArrayList<OBJETO_T> listaTokens) {
        int count = 0;
        TOKENS A = new TOKENS();
        String[][] TOK = A.getTOKENS();
        ArrayList<OBJETO_T> LISTAT2 = new ArrayList<>();
        for (OBJETO_T Cadena : listaTokens) {
            LISTAT2.add(Cadena);
            count++;
            if (count == 1) {
                break;
            }
            if (LISTAT2.get(0).getTOKEN() == ("VTS") || LISTAT2.get(0).getTOKEN() == ("VTB")
                    || LISTAT2.get(0).getTOKEN() == ("ID")
                    || LISTAT2.get(0).getTOKEN() == ("VTF")
                    || LISTAT2.get(0).getTOKEN() == ("VTC")) {
                
                for (int i = 0; i < 1; i++) {
                    listaTokens.remove(1);
                }
                if (listaTokens.get(1).getTOKEN() == "") {
                }
                
            
        
    }
    
        }
        
    }
}
