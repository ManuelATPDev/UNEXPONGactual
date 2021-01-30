package clases;

//Uso de expresiones regulares

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidadorConPatron {
    
    private Matcher comprobarpalabra, comprobaremail;
    private Pattern patronpalabra, patronemail;
    public boolean verificado;

    public ValidadorConPatron(String palabra) {
        this.patronpalabra = Pattern.compile("[A-Za-zÁÉÍÓÚáéíóúñÑ]");
        this.comprobarpalabra = patronpalabra.matcher(palabra);
        
        this.patronemail = Pattern.compile("^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        
        /**
         * ^[_A-Za-z0-9-+]+ = Al empezar la cadena de caracteres "^" debe contar con las letras A hasta la Z "A-Za-z"(minusculas o mayusculas)
         * o también numeros desde el 0 hasta el 9 "0-9" igual que _ y - y debe encontrar más caracteres seguidos a este "\\+" repetidos 1 o más veces "+"
         * 
         * (\\.[_A-Za-z0-9-]+)* = Luego del caracter . "\\. (Significa que un metacaracter debe ser interpretado literalmente)" debe estar seguido por cualquier caracter de la A a la Z (minusculas o mayusculas)
         * también números del 0 al 9 al igual que _ y -  repetidos 1 o más veces "+" y todo esto puede estar repetido 0 o más veces "*"
         * 
         * @[A-Za-z0-9-]+ = Seguido forzosamente por un "@" y luego por cualquier caracter, letra o numero, de la A a la Z (minusculas o mayusculas) o del 0 al 9 
         * repetido 1 o más veces
         * 
         * (\\.[A-Za-z0-9]+)* = Después de un punto . le debe seguir una letra de la A a la Z o numeros del 0 al 9 repetidos 0 o más veces "*"
         * (esto es para los correos cuyo dominio termine en: com.ve o com.edu)
         * 
         * (\\.[A-Za-z]{2,})$ = Forzosamente debe la cadena de caracteres debe terminar "$" con . "\\." seguido de un caracter de la A a la Z y el caracter debe
         * estar repetido mínimo 2 veces a más veces "{2,}"
         */
        
        this.comprobaremail = patronemail.matcher(palabra);
    }

    public void ValidarNombre() {
        if (comprobarpalabra.find()) {
            verificado = true;
        } else {
            verificado = false;
        }
    }

    public void ValidarEmail() {
        if (comprobaremail.find()) {
            verificado = true;
        } else {
            verificado = false;
        }
    }
        
}
