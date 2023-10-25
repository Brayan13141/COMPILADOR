package analizadores;
import static analizadores.Tokens.*;

%% 
%class Lexico 
%type Tokens

%init{ 
    yyline = 1; 
    yychar = 1; 
%init} 


L=[a-zA-Z_]+
CADENA=""".*"""
CHAR="'".*"'"
BLANCOS=[ \r\t]+
D=[0-9]+
DD=[0-9]+("."[|0-9]+)?
%%


/* Espacios en blanco */
 {BLANCOS} {/*Ignore*/} 

/* Comentarios */
( "//"(.)* ) {/*Ignore*/}


/*( "\n" ) {return Linea;}*/

/* Comillas */
( "\"" ) {lexeme=yytext(); return Comillas;}

/* Tipos de datos */
( byte | int | char | long | float | double | short ) {lexeme=yytext(); return TD;}

/* Palabra reservada String */
( String ) {lexeme=yytext(); return STR;}

/* Palabra reservada main */
( main ) {lexeme=yytext(); return MAIN;}

/* Palabra reservada If */
( if ) {lexeme=yytext(); return PRIF;}

/* Palabra reservada Else */
( else ) {lexeme=yytext(); return PRE;}

/* Switch */ 
( switch ) {lexeme = yytext(); return PRSW;}

/* CLASS */ 
( class ) {lexeme = yytext(); return CL;}

/* CHAR */ 
( CHAR ) {lexeme = yytext(); return CHAR;}

/* Palabra reservada Do */
( do ) {lexeme=yytext(); return PRDO;}

/* Palabra reservada While */
( while ) {lexeme=yytext(); return PRW;}

/* break */ 
( break ) {lexeme = yytext(); return BR;}

/* Assert */ 
( assert ) {lexeme = yytext(); return ASR;}

/* CASE */ 
( case ) {lexeme = yytext(); return CS;}

/* Palabra reservada For */
( for ) {lexeme=yytext(); return PRF;}

/* Palabra reservada synchronized */
( synchronized ) {lexeme=yytext(); return SY;}

/* COMENTARIO DE LINEA */
( "//" ) {lexeme=yytext(); return CLN;}

/* Palabra reservada DEFAULT */
( deafult ) {lexeme=yytext(); return DF;}

/* Palabra reservada NULL */
( null ) {lexeme=yytext(); return NU;}

/* Palabra reservada static */
( static ) {lexeme=yytext(); return ST;}

/* Palabra reservada super */
( super ) {lexeme=yytext(); return SPR;}

/* Palabra reservada return */
( return ) {lexeme=yytext(); return RTN;}

/* Palabra reservada INOF */
( instanceof ) {lexeme=yytext(); return INOF;}

/* Palabra reservada EXTS */
( extends ) {lexeme=yytext(); return EXTS;}

/* Palabra reservada FIN */
( finally ) {lexeme=yytext(); return FIN;}

/* Palabra reservada new */
( new ) {lexeme=yytext(); return NW;}

/* Palabra reservada this */
( this ) {lexeme=yytext(); return RF;}

/* Operador Igual */
( "=" ) {lexeme=yytext(); return ODA;}

/* IMPORT */ 
( import ) {lexeme = yytext(); return IMP;}

/* IMPLEMENTS */ 
( implements ) {lexeme = yytext(); return IMPL;}

/* final */ 
( final ) {lexeme = yytext(); return TDD;}

/* Cualquier string(incluye las comillas doble y el contenido) QUESTION */ 
( CADENA  ) {lexeme = yytext(); return VTS;}

/* Numeros Enteros */ 
( int ) {lexeme = yytext(); return VTE;}

/* COMA*/ 
( , ) {lexeme = yytext(); return CO;}

/* Cualquier carater encerrado entre comillas simples */ 
('') {lexeme = yytext(); return VTC;}

/* Operador Suma */
( "+" ) {lexeme=yytext(); return OPA;}

/* package */
( package ) {lexeme=yytext(); return PCK;}

/* Modificador de Acceso */ 
( public | protected | private | abstract  ) {lexeme = yytext(); return MA;}

/* Operador Resta */
( "-" ) {lexeme=yytext(); return OPA;}

/* Operador Multiplicacion */
( "*" ) {lexeme=yytext(); return OPA;}

/* Operador Division */
( "/" ) {lexeme=yytext(); return OPA;}

/* Dos Puntos */
( ":" ) {lexeme=yytext(); return DOP;}

/* Cierre De Pregunta */
( "?" ) {lexeme=yytext(); return OPT;}

/* Operadores logicos */
( "&&" | "||" | "!" ) {lexeme=yytext(); return OPL;}

/*Operadores Relacionales */
( ">" | "<" | "==" | "!=" | ">=" | "<=" | "<<" | ">>" ) {lexeme = yytext(); return OPR;}

/* Operadores Atribucion */
( "+=" | "-="  | "*=" | "/=" | "%=" ) {lexeme = yytext(); return ODA;}
 
/* Operador Incremento */ 
( "++" ) {lexeme = yytext(); return INC;}
/* Punto */ 
( "." ) {lexeme = yytext(); return CA;}

/* Catch */ 
( catch ) {lexeme = yytext(); return CE;}



/* Operadores Decremento */ 
( "--" ) {lexeme = yytext(); return DEC;}

/*Operadores Booleanos*/
(true | false)      {lexeme = yytext(); return VTB;}

/* throws */ 
( throws ) {lexeme = yytext(); return TH;}

/* Parentesis de apertura */
( "(" ) {lexeme=yytext(); return PA;}

/* Parentesis de cierre */
( ")" ) {lexeme=yytext(); return PC;}

/* Llave de apertura */
( "{" ) {lexeme=yytext(); return LLA;}

/* Llave de cierre */
( "}" ) {lexeme=yytext(); return LLC;}

/* Corchete de apertura */
( "[" ) {lexeme = yytext(); return COA;}

/* Corchete de cierre */
( "]" ) {lexeme = yytext(); return COC;}


/* VOID */ 
( void ) {lexeme = yytext(); return TM;}

/* try */ 
( try ) {lexeme = yytext(); return ISE;}



/* Punto y coma */
( ";" ) {lexeme=yytext(); return FI;}

/* Identificador */
{L}({L}|{D})* {lexeme=yytext(); return IDU;}

/* Numero */
"-"?{D}+ {return new Symbol(sym.Numero, yychar, yyline, yytext());}

/* Error de analisis */
 . {return ERROR;}

{BLANCOS} {} 
{D} {return new Symbol(sym.VTE,yyline,yychar, yytext());} 
{DD} {return new Symbol(sym.VTD,yyline,yychar, yytext());} 

. {
    System.out.println("Este es un error lexico: "+yytext()+
    ", en la linea: "+yyline+", en la columna: "+yychar);
}
