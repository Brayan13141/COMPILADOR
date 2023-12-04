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
    DECLARACION DECLARACION = new DECLARACION();
    DECLARACIONVALOR DEC = new DECLARACIONVALOR();
//MA TYPE ID PA PARAMS PC LLA CUERPO REE LLC;

    public ArrayList<ERROR> VALIDARMETODO(ArrayList<OBJETO_T> listaTokens) {
        if (listaTokens.get(0).getTOKEN() == "MA") {
            listaTokens.remove(0);
            int bandera = listaTokens.get(0).getTOKEN() == "TM" ? 1 : 0;
            if (T.VALIDARTYPE(listaTokens).isEmpty()) {
                if (listaTokens.get(0).getTOKEN() == "IDU") {
                    listaTokens.remove(0);
                    if (listaTokens.get(0).getTOKEN() == "PA") {
                        listaTokens.remove(0);
                        boolean parametrosvacios = false;
                        if (listaTokens.get(0).getTOKEN() == "PC") {
                            parametrosvacios = true;
                        }
                        if (P.VALIDARPARAMETROS(listaTokens).isEmpty() || parametrosvacios) {
                            if (listaTokens.get(0).getTOKEN() == "PC") {
                                listaTokens.remove(0);
                                if (listaTokens.get(0).getTOKEN() == "LLA") {
                                    listaTokens.remove(0);
//--------------------------------------------CICLO-------------------------------------------------------------------------------------------------
                                    while (listaTokens.size() > 1 && (listaTokens.get(0).getTOKEN() == "TD" || listaTokens.get(0).getTOKEN() == "IDU")) {
//-------------VALIDAR DECLARACION--------------------------------------------------------------------------------                                       
                                        if (listaTokens.get(0).getTOKEN() == "TD") {
                                            if (DECLARACION.VALIDARDECLARACION(listaTokens).isEmpty()) {

                                            } else {
                                                for (ERROR E : DECLARACION.VALIDARDECLARACION(listaTokens)) {
                                                    errores.add(E);
                                                    return errores;
                                                }
                                                break;
                                            }
//---------VALIDAR ASIGNACION---------------------------------------------------------------------------------------------------------------------
                                        } else if (listaTokens.get(0).getTOKEN() == "IDU") {
                                            if (VALIDARASIGNACION(listaTokens).isEmpty()) {

                                            }
                                        } else {
                                            for (ERROR E : VALIDARASIGNACION(listaTokens)) {
                                                errores.add(E);
                                            }
                                            break;
                                        }

                                    }
//---------VALIDAR RETURN---------------------------------------------------------------------------------------------------------------------
                                    if (bandera == 0) {
                                        if (listaTokens.get(0).getTOKEN() == "RTN") {
                                            listaTokens.remove(0);
                                            if (DEC.VALIDAR_VALOR(listaTokens.get(0))) {
                                                listaTokens.remove(0);
                                                if (listaTokens.get(0).getTOKEN() == "FI") {
                                                    listaTokens.remove(0);
                                                    if (listaTokens.get(0).getTOKEN() == "LLC") {
                                                        listaTokens.remove(0);
                                                    } else {
                                                        ERROR NUEVOITEM = new ERROR(listaTokens.get(0).getLinea(), "SINTACTICO", listaTokens.get(0).getLexema(), "SE ESPERABA UN LLC");
                                                        errores.add(NUEVOITEM);
                                                        return errores;
                                                    }
                                                } else {
                                                    ERROR NUEVOITEM = new ERROR(listaTokens.get(0).getLinea(), "SINTACTICO", listaTokens.get(0).getLexema(), "SE ESPERABA UN FI");
                                                    errores.add(NUEVOITEM);
                                                    return errores;
                                                }
                                            } else {
                                                for (ERROR E : T.VALIDARTYPE(listaTokens)) {
                                                    errores.add(E);
                                                    return errores;
                                                }
                                            }
                                        }
                                    } else if (listaTokens.get(0).getTOKEN() == "LLC") {
                                        listaTokens.remove(0);
                                        return errores;
                                    } else {
                                        ERROR NUEVOITEM = new ERROR(listaTokens.get(0).getLinea(), "SINTACTICO", listaTokens.get(0).getLexema(), "SE ESPERABA UN LLC");
                                        errores.add(NUEVOITEM);
                                    }

                                } else {
                                    ERROR NUEVOITEM = new ERROR(listaTokens.get(0).getLinea(), "SINTACTICO", listaTokens.get(0).getLexema(), "SE ESPERABA UN LLA");
                                    errores.add(NUEVOITEM);
                                }

                            } else {
                                ERROR NUEVOITEM = new ERROR(listaTokens.get(0).getLinea(), "SINTACTICO", listaTokens.get(0).getLexema(), "SE ESPERABA UN PC");
                                errores.add(NUEVOITEM);
                            }
                        } else {
                            ERROR NUEVOITEM = new ERROR(listaTokens.get(0).getLinea(), "SINTACTICO", listaTokens.get(0).getLexema(), "SE ESPERABA UN VAL");
                            errores.add(NUEVOITEM);
                        }
                    }
                } else {
                    ERROR NUEVOITEM = new ERROR(listaTokens.get(0).getLinea(), "SINTACTICO", listaTokens.get(0).getLexema(), "SE ESPERABA UN IDU");
                    errores.add(NUEVOITEM);
                }

            } else {
                for (ERROR E : T.VALIDARTYPE(listaTokens)) {
                    errores.add(E);
                    return errores;
                }
            }
        } else {
            ERROR NUEVOITEM = new ERROR(listaTokens.get(0).getLinea(), "SINTACTICO", listaTokens.get(0).getLexema(), "SE ESPERABA UN MA");
            errores.add(NUEVOITEM);
        }
        return errores;
    }
//ASIG::= ID ODA VAL FI |ID CA EXPC FI
    DECLARACIONVALOR DE = new DECLARACIONVALOR();
    EXPRECION EX = new EXPRECION();

    public ArrayList<ERROR> VALIDARASIGNACION(ArrayList<OBJETO_T> listaTokens) {
        if (listaTokens.get(0).getTOKEN() == "IDU") {
            listaTokens.remove(0);
            if (listaTokens.get(0).getTOKEN() == "OPA" && listaTokens.get(1).getTOKEN() == "ODA") {
                listaTokens.remove(0);
            }
            if (listaTokens.get(0).getTOKEN() == "ODA") {
                listaTokens.remove(0);
                if (DE.VALIDAR_VALOR(listaTokens.get(0)) && listaTokens.get(1).getTOKEN() == "FI") {
                    listaTokens.remove(0);
                    listaTokens.remove(0);
                } else if (DE.VALIDAR_VALOR(listaTokens.get(0)) && (listaTokens.get(1).getTOKEN() == "PA" || listaTokens.get(1).getTOKEN() == "OPA")) {
                    if (EX.EXPRECIONVAL(listaTokens).isEmpty()) {
                        if (listaTokens.get(1).getTOKEN() == "FI") {
                            listaTokens.remove(0);
                            return errores;
                        } else {
                            ERROR NUEVOITEM = new ERROR(listaTokens.get(0).getLinea(), "SINTACTICO", listaTokens.get(0).getLexema(), "SE ESPERABA UN FI");
                            errores.add(NUEVOITEM);
                        }
                    } else {
                        for (ERROR E : EX.EXPRECIONVAL(listaTokens)) {
                            errores.add(E);
                            return errores;
                        }
                    }
                } else {
                    if (DE.VALIDAR_VALOR(listaTokens.get(0)) && listaTokens.get(1).getTOKEN() != "FI") {
                        listaTokens.remove(0);
                        ERROR NUEVOITEM = new ERROR(listaTokens.get(0).getLinea(), "SINTACTICO", listaTokens.get(0).getLexema(), "SE ESPERABA UN FI");
                        errores.add(NUEVOITEM);
                        return errores;
                    } else if (DE.VALIDAR_VALOR(listaTokens.get(0))) {
                        listaTokens.remove(0);
                    } else {
                        ERROR NUEVOITEM = new ERROR(listaTokens.get(0).getLinea(), "SINTACTICO", listaTokens.get(0).getLexema(), "SE ESPERABA UN VAL");
                        errores.add(NUEVOITEM);
                    }
                }
            } else {
                ERROR NUEVOITEM = new ERROR(listaTokens.get(0).getLinea(), "SINTACTICO", listaTokens.get(0).getLexema(), "SE ESPERABA UN ODA||OPA");
                errores.add(NUEVOITEM);
            }
        } else {
            ERROR NUEVOITEM = new ERROR(listaTokens.get(0).getLinea(), "SINTACTICO", listaTokens.get(0).getLexema(), "SE ESPERABA UN IDU");
            errores.add(NUEVOITEM);
        }
        return errores;
    }

}
