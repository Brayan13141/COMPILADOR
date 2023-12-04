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
public class ERROR {
    String Linea;
    String TIPO;
    String Error;
    String Descripcion;

    public ERROR(String Linea, String TIPO,String Error, String Descripcion) {
        this.Linea = Linea;
        this.Error=Error;
        this.TIPO = TIPO;
        this.Descripcion = Descripcion;
    }

    public String getLinea() {
        return Linea;
    }

    public void setLinea(String Linea) {
        this.Linea = Linea;
    }

    public String getError() {
        return Error;
    }

    public void setError(String Error) {
        this.Error = Error;
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
