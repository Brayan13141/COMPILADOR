/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package METODOS_GRAMATICA;

import TOKENS.TOKENS;
import METODOS_GRAMATICA.VARIOS;
import METODO_CODIGO.PROC_CODIGO;
import OBJETOS_TABLA.ERROR;
import OBJETOS_TABLA.OBJETO_T;
import java.util.ArrayList;

/**
 *
 * @author LMC Alumno
 */
public class PCK_CLASS {

    public ArrayList<ERROR> errores = new ArrayList<ERROR>();

    public ArrayList<ERROR> VALIDAR_PCK(ArrayList<OBJETO_T> listaTokens) {
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
                    if (listaTokens.get(0).getLexema().matches("class") || listaTokens.get(0).getLexema().matches("public")) {
                        for (ERROR E : VALIDARCLASS(listaTokens)) {
                            errores.add(E);
                            return errores;
                        }
                       
                    } else if (listaTokens.get(0).getLexema().matches("import")) {
                        //VALIDARIMPORT(listaTokens);
                    } else {
                        ERROR NUEVOITEM = new ERROR(LISTAT2.get(0).getLinea(), "SINTACTICO", LISTAT2.get(2).getLexema(), "SE ESPERABA \n (pulic|class|import|");
                        errores.add(NUEVOITEM);
                        return errores;
                    }
                } else {
                    ERROR NUEVOITEM = new ERROR(LISTAT2.get(2).getLinea(), "SINTACTICO", LISTAT2.get(2).getLexema(), "SE ESPERABA \n (;)");
                    errores.add(NUEVOITEM);
                    return errores;
                }
            } else {
                ERROR NUEVOITEM = new ERROR(LISTAT2.get(1).getLinea(), "SINTACTICO", LISTAT2.get(1).getLexema(), "SE ESPERABA UN IDU");
                errores.add(NUEVOITEM);
                return errores;
            }
        } else {
            ERROR NUEVOITEM = new ERROR(LISTAT2.get(0).getLinea(), "SINTACTICO", LISTAT2.get(0).getLexema(), "SE ESPERABA LA PALABRA RESERVADA\n (package)");
            errores.add(NUEVOITEM);
            return errores;
        }
        return errores;
    }
    public ArrayList<ERROR> VALIDARCLASS(ArrayList<OBJETO_T> listaTokens) {
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
        try {
            if (LISTAT2.get(0).getTOKEN() == "MA") {
                if (LISTAT2.get(1).getTOKEN() == "CL") {
                    if (LISTAT2.get(2).getTOKEN() == "IDU") {
                        if (LISTAT2.get(3).getTOKEN() == "LLA") {
                            for (int i = 0; i < 4; i++) {
                                listaTokens.remove(0);
                            }
                            VARIOS VARIOS = new VARIOS();
                            if (VARIOS.VALIDARVARIOS(listaTokens).size() == 0) {//SI NO HAY ERRORES AVANZA
                                if (listaTokens.get(0).getTOKEN() == "LLC") {
                                    return errores;
                                } else {
                                    ERROR NUEVOITEM = new ERROR(LISTAT2.get(5).getLinea(), "SINTACTICO", LISTAT2.get(5).getLexema(), "SE ESPERABA \n LLC");
                                    errores.add(NUEVOITEM);
                                    return errores;
                                }

                            } else {
                                for (ERROR E : VARIOS.VALIDARVARIOS(listaTokens)) {
                                    errores.add(E);
                                }
                                //-------------------------------------------------FALTA VALIDAR--------------------------------------------------
                            }
                        } else {
                            ERROR NUEVOITEM = new ERROR(LISTAT2.get(3).getLinea(), "SINTACTICO", LISTAT2.get(3).getLexema(), "SE ESPERABA \n LLA");
                            errores.add(NUEVOITEM);
                            return errores;
                        }
                    } else {
                        ERROR NUEVOITEM = new ERROR(LISTAT2.get(2).getLinea(), "SINTACTICO", LISTAT2.get(2).getLexema(), "SE ESPERABA \n IDU");
                        errores.add(NUEVOITEM);
                        return errores;
                    }
                } else {
                    ERROR NUEVOITEM = new ERROR(LISTAT2.get(1).getLinea(), "SINTACTICO", LISTAT2.get(1).getLexema(), "SE ESPERABA \n CL");
                    errores.add(NUEVOITEM);
                    return errores;
                }
            } else if (LISTAT2.get(0).getTOKEN() == "CL") {
                if (LISTAT2.get(1).getTOKEN() == "IDU") {
                    if (LISTAT2.get(2).getTOKEN() == "LLA") {
                        if (LISTAT2.get(3).getTOKEN() == "CONTENT") {
                            if (LISTAT2.get(4).getTOKEN() == "LLC") {

                                for (int i = 0; i < 4; i++) {
                                    listaTokens.remove(0);
                                }
                            } else {
                                ERROR NUEVOITEM = new ERROR(LISTAT2.get(0).getLinea(), "SINTACTICO", LISTAT2.get(2).getLexema(), "SE ESPERABA \n LLC");
                                errores.add(NUEVOITEM);
                                return errores;
                            }
                        }
                    } else {
                        ERROR NUEVOITEM = new ERROR(LISTAT2.get(2).getLinea(), "SINTACTICO", LISTAT2.get(2).getLexema(), "SE ESPERABA \n LLA");
                        errores.add(NUEVOITEM);
                        return errores;
                    }
                } else {
                    ERROR NUEVOITEM = new ERROR(LISTAT2.get(1).getLinea(), "SINTACTICO", LISTAT2.get(1).getLexema(), "SE ESPERABA \n IDU");
                    errores.add(NUEVOITEM);
                    return errores;
                }
            } else {
                ERROR NUEVOITEM = new ERROR(LISTAT2.get(0).getLinea(), "SINTACTICO", LISTAT2.get(0).getLexema(), "SE ESPERABA \n MA|CL");
                errores.add(NUEVOITEM);
                return errores;
            }
        } catch (Exception e) {
            return errores;
        }

        return errores;

    }

}
