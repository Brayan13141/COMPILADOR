package analizadores;
import java_cup.runtime.Symbol; 

%% 
%class LexicoCup
%type java_cup.runtime.Symbol
%line 
%char 
%cup 
%full   
L=[a-zA-Z_]+
BLANCOS=[ \r\t]+
CADENA=""".*"""
CHAR="'".*"'"
D=[0-9]+
DD=[0-9]+("."[  |0-9]+)?
%init{ 
    /*SE CREA UN METODO QUE RECIBE EL TIPO DE LO QUE ESTAMOS ANALIZANDO Y EL OBJETO O CADENA QUE SE INGRESO*/
    private Symbol symbol(int type,Object value){
    return new Symbol(type,yyline,yycolum,yyvalue);
    }
   /*SE CREA OTRO METODO PARA REGRESAR CON LA CADENA AUN NO ANALIZADA*/
    private Symbol symbol(int type){
    return new Symbol(type,yyline,yycolum);
    }
   /*INICIA EL CONTADOR DE LA LINEA EN 1*/
    yyline = 1; 
    yychar = 1; 
%init}  
%%

/* Espacios en blanco */
{BLANCOS} {/*Ignore*/} 

/* Comentarios */
( "//"(.)* ) {/*Ignore*/}

/* Comillas */
( "\"" ) {return new Symbol(sym.Comillas, yychar, yyline, yytext());}

/* Tipos de datos */
( byte | int | char | long | float | double| boolean | short ) {return new Symbol(sym.TD, yychar, yyline, yytext());}

/*MODIFICADOR ACCESO*/
/*(public | protected | private | abstract) {return new Symbol(sym.MA, yychar, yyline, yytext());}*/

/* Tipo de dato String */
( String ) {return new Symbol(sym.STR, yychar, yyline, yytext());}

/* Palabra reservada main */
( main ) {return new Symbol(sym.MAIN, yychar, yyline, yytext());}

/* Palabra reservada If */
( if ) {return new Symbol(sym.PRIF, yychar, yyline, yytext());}

/*CLASS*/
( class ) {return new Symbol(sym.CL, yychar, yyline, yytext());}

/*VOID*/
( void ) {return new Symbol(sym.TM, yychar, yyline, yytext());}

/*TRY*/
( try ) {return new Symbol(sym.ISE, yychar, yyline, yytext());}

/*IMPORT*/
( import ) {return new Symbol(sym.IMP, yychar, yyline, yytext());}

/*CATCH*/
( catch ) {return new Symbol(sym.CE, yychar, yyline, yytext());}

/*break*/
( break ) {return new Symbol(sym.BR, yychar, yyline, yytext());}

/*ASSERT*/
( assert ) {return new Symbol(sym.ASR, yychar, yyline, yytext());}

/*CASE*/
( case ) {return new Symbol(sym.CS, yychar, yyline, yytext());}

/* Palabra reservada Else */
( else ) {return new Symbol(sym.PRE, yychar, yyline, yytext());}


/*SWITCH*/
( switch ) {return new Symbol(sym.PRSW, yychar, yyline, yytext());}

/*THROWS*/
( throws ) {return new Symbol(sym.TH, yychar, yyline, yytext());}

/*SYNCHRONIZED*/
( synchronized ) {return new Symbol(sym.SY, yychar, yyline, yytext());}

/*PACKAGE*/
( package ) {return new Symbol(sym.PCK, yychar, yyline, yytext());}

/*RETURN*/
( return ) {return new Symbol(sym.RTN, yychar, yyline, yytext());}

/*SUPER*/
( super ) {return new Symbol(sym.SPR, yychar, yyline, yytext());}

/*INSTANCEOF*/
( instanceof ) {return new Symbol(sym.INOF, yychar, yyline, yytext());}

/*FINALLY*/
( finally ) {return new Symbol(sym.FIN, yychar, yyline, yytext());}

/*NEW*/
( new ) {return new Symbol(sym.NW, yychar, yyline, yytext());}

/*THIS*/
( this ) {return new Symbol(sym.RF, yychar, yyline, yytext());}

/*FOR*/
( for ) {return new Symbol(sym.PRF, yychar, yyline, yytext());}

/*IMPLEMENTS*/
( implements ) {return new Symbol(sym.IMPL, yychar, yyline, yytext());}

/*FINAL*/
( final ) {return new Symbol(sym.TDD, yychar, yyline, yytext());}

/*STRINGS*/
( CADENA ) {return new Symbol(sym.VTS, yychar, yyline, yytext());}

/*COMA*/
( "," ) {return new Symbol(sym.CO, yychar, yyline, yytext());}

/*CHAR*/
( char ) {return new Symbol(sym.VTC, yychar, yyline, yytext());}

/*DEFAULT*/
( default ) {return new Symbol(sym.DF, yychar, yyline, yytext());}

/*NULL*/
( null ) {return new Symbol(sym.NU, yychar, yyline, yytext());}

/*STATIC*/
( static ) {return new Symbol(sym.ST, yychar, yyline, yytext());}

/*STRING*/
( String ) {return new Symbol(sym.STR, yychar, yyline, yytext());}

/*DO*/
( do ) {return new Symbol(sym.PRDO, yychar, yyline, yytext());}

/*CHAR*/
( CHAR ) {return new Symbol(sym.VTC, yychar, yyline, yytext());}

/* Palabra reservada While */
( while ) {return new Symbol(sym.PRW, yychar, yyline, yytext());}

/* Palabra reservada For */
( for ) {return new Symbol(sym.For, yychar, yyline, yytext());}

/* Operador Igual */
( "=" ) {return new Symbol(sym.ODA, yychar, yyline, yytext());}

/* Operador Suma */
( "+" ) {return new Symbol(sym.OPA, yychar, yyline, yytext());}

/* Operador Resta */
( "-" ) {return new Symbol(sym.OPA, yychar, yyline, yytext());}

( ":" ) {return new Symbol(sym.DOP, yychar, yyline, yytext());}

/* Operador Multiplicacion */
( "*" ) {return new Symbol(sym.OPA, yychar, yyline, yytext());}

/* Operador Division */
( "/" ) {return new Symbol(sym.OPA, yychar, yyline, yytext());}

/* Operadores logicos */
( "&&" | "||" | "!" ) {return new Symbol(sym.OPL, yychar, yyline, yytext());}

/*Operadores Relacionales */
( ">" | "<" | "==" | "!=" | ">=" | "<=" | "<<" | ">>" ) {return new Symbol(sym.OPR, yychar, yyline, yytext());}

/* Operadores Atribucion */
( "+=" | "-="  | "*=" | "/=" | "%=" | "=" ) {return new Symbol(sym.Op_atribucion, yychar, yyline, yytext());}

/* Operadores Incremento y decremento */
( "++" ) {return new Symbol(sym.INC, yychar, yyline, yytext());}

( "--" ) {return new Symbol(sym.DEC, yychar, yyline, yytext());}

/*Operadores Booleanos*/
( true | false ) {return new Symbol(sym.VTB, yychar, yyline, yytext());}

/* Parentesis de apertura */
( "(" ) {return new Symbol(sym.PA, yychar, yyline, yytext());}

/* Parentesis de cierre */
( ")" ) {return new Symbol(sym.PC, yychar, yyline, yytext());}

/* Llave de apertura */
( "{" ) {return new Symbol(sym.LLA, yychar, yyline, yytext());}

/* Llave de cierre */
( "}" ) {return new Symbol(sym.LLC, yychar, yyline, yytext());}

/* Corchete de apertura */
( "[" ) {return new Symbol(sym.COA, yychar, yyline, yytext());}

/* Corchete de cierre */
( "]" ) {return new Symbol(sym.COC, yychar, yyline, yytext());}


( "." ) {return new Symbol(sym.CA, yychar, yyline, yytext());}

/* Punto y coma */
( ";" ) {return new Symbol(sym.FI, yychar, yyline, yytext());}

( "?" ) {return new Symbol(sym.OPT, yychar, yyline, yytext());}

/* Identificador */
{L}({L}|{D})* {return new Symbol(sym.IDU, yychar, yyline, yytext());}

/* Numero */
/*("(-"{D}+")")|{D}+ {return new Symbol(sym.Numero, yychar, yyline, yytext());}*/
"-"?{D}+ {return new Symbol(sym.Numero, yychar, yyline, yytext());}

/* Error de analisis */
 . {return new Symbol(sym.ERROR, yychar, yyline, yytext());}

{BLANCOS} {} 
{D} {return new Symbol(sym.VTE,yyline,yychar, yytext());} 
{DD} {return new Symbol(sym.VTD,yyline,yychar, yytext());} 

. {
    System.out.println("Este es un error lexico: "+yytext()+
    ", en la linea: "+yyline+", en la columna: "+yychar);
}
