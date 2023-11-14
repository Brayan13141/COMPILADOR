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
public class ERRORES {
    int Linea;
    String TIPO;
    String Descripcion;

    public ERRORES(int Linea, String TIPO, String Descripcion) {
        this.Linea = Linea;
        this.TIPO = TIPO;
        this.Descripcion = Descripcion;
    }

    public int getLinea() {
        return Linea;
    }

    public void setLinea(int Linea) {
        this.Linea = Linea;
    }

    public String getTIPO() {
        return TIPO;
    }

    public void setTIPO(String TIPO) {
        this.TIPO = TIPO;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    
}
