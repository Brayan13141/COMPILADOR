/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package compilador1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class main{
    public static void main(String[] args) throws Exception {

        String ruta1 = "F:/COMPILADOR-master (1)/COMPILADOR-master/COMPILADOR1/src/analizadores/Lexico.flex";
        String ruta2 = "F:/COMPILADOR-master (1)/COMPILADOR-master/COMPILADOR1/src/analizadores/LexicoCup.flex";
        String[] rutaS = {"-parser", "Sintactico", "F:/COMPILADOR-master (1)/COMPILADOR-master/COMPILADOR1/src/analizadores/Sintactico.cup"};
        generar(ruta1, ruta2, rutaS);
    }
    public static void generar(String ruta1, String ruta2, String[] rutaS) throws IOException, Exception{
        File archivo;
        archivo = new File(ruta1);
        JFlex.Main.generate(archivo);
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);
        java_cup.Main.main(rutaS);
        
        Path rutaSym = Paths.get("/COMPILADOR-master (1)/COMPILADOR-master/COMPILADOR1/sym.java");
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get("F:/COMPILADOR-master (1)/COMPILADOR-master/COMPILADOR1/sym.java"), 
                Paths.get("F:/COMPILADOR-master (1)/COMPILADOR-master/COMPILADOR1/src/an alizadores/Sintactico.java")
        );
        Path rutaSin = Paths.get("F:/COMPILADOR/COMPILADOR/COMPILADOR/COMPILADOR1/src/analizadores/Sintactico.java");
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get("F:/COMPILADOR-master (1)/COMPILADOR-master/COMPILADOR1/sym.java"), 
                Paths.get("F:/COMPILADOR-master (1)/COMPILADOR-master/COMPILADOR1/src/analizadores/Sintactico.java")
        );
    }
}