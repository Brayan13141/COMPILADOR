/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OBJETOS_TABLA;

/**
 *
 * @author Guillermo Mata
 */
public class OBJETO_T {
    String Linea;
    String Lexema;
    String TOKEN;

    public OBJETO_T(String Linea, String Lexema, String TOKEN) {
        this.Linea = Linea;
        this.Lexema = Lexema;
        this.TOKEN = TOKEN;
    }

    public String getLinea() {
        return Linea;
    }

    public void setLinea(String Linea) {
        this.Linea = Linea;
    }


    public String getLexema() {
        return Lexema;
    }

    public void setLexema(String Lexema) {
        this.Lexema = Lexema;
    }

    public String getTOKEN() {
        return TOKEN;
    }

    public void setTOKEN(String TOKEN) {
        this.TOKEN = TOKEN;
    }
    
}
