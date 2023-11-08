/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metodos;

/**
 *
 * @author ptino
 */
public class TOKENS {

    String ID = "[A-Za-z]+[A-Za-z0-9]*";
    String cadena = "(\")[A-Za-z0-9]*(\")$";//caracteresspeciales
    String Num= "-?[0-9]+";//faltan numeros
    String NumDecimal= "-?\\d*\\.?\\d+$";//
    String CaracterCS="^(')[A-Za-z0-9\\.]*(')";
//    String ComentarioBloque="/\\*(.|[\\r\\n])*?\\*/";
//    String ComentarioLinea="//.*$";
    String CualquierString="\"[A-Za-z0-9\\w\\a]*\"";
    String[][] TOKEN = {
        {"package", "PCK"},
        {";", "FI"},
        {" ", "VTS"},
        {"int", "TD"},
        {"boolean", "TD"},
        {"double", "TD"},
        {"float", "TD"},
        {"long", "TD"},
        {"short", "TD"},
        {"char", "TD"},
        {"=", "ODA"},
        {";", "FI"},
        {"\\{", "LLA"},
        {"\\}", "LLC"},
        {"\\(", "PA"},
        {"\\)", "PC"},
        {"\\[", "COA"},
        {"\\]", "COC"},
        {"\\/", "OPA"},
        {"\\*", "OPA"},
        {"\\+", "OPA"},
        {"\\-", "OPA"},
        {"\\%", "OPA"},
        {"\\:", "DOP"},
        {"\\?", "OPT"},
        {"\\|", "OPL"},
        {"\\&", "OPL"},
        {"\\!", "OPL"},
        {"\\<", "OPR"},
        {"\\>", "OPR"},
        {"\\==", "OPR"},
        {"\\.", "CA"},
        {"public", "MA"},
        {"main", "PMAIN"},
        {"protected", "MA"},
        {"private", "MA"},
        {"abstract", "MA"},
        {"class", "CL"},
        {"void", "TM"},
        {"try", "ISE"},
        {"import", "IMP"},
        {"catch", "CE"},
        {"break", "BR"},
        {"case", "CS"},
        {"if", "PRIF"},
        {"else", "PRE"},
        {"switch", "PRSW"},
        {"while", "PRW"},
        {"false", "VTB"},
        {"true", "VTB"},
        {"throws", "TH"},
        {"return", "RTN"},
        {"new", "NW"},
        {"this", "RF"},
        {"for", "PRF"},
        {Num, "VTE"},
        {NumDecimal, "VTD-F"},
        {CaracterCS, "VTC"},
        {"\\,", "CO"},
        {"\\--", "DEC"},
        {"\\++", "INC"},
//        {ComentarioBloque, "CBL"},
//        {ComentarioBloque, "CBL"},
        {"null", "_NU"},
        {"static", "ST"},
        {"String", "ST"},
        {"do", "PRDO"},
        {"extends", "EXTS"},
        {"new", "NW"},
        {"this", "RF"},
        {"for", "PRF"},
        {"implements", "IMPL"},
        {CualquierString, "VTS"},
         {ID, "IDU"}
    };

    public String[][] getTOKENS() {
        return TOKEN;
    }

}
