package clases;

/**
 * Uso de expresiones regulares: cuando se crea una “expresión regular” estamos
 * definiendo un patrón de búsqueda para localizar cadenas de caracteres.
 */
import java.util.regex.Matcher; //Libreria que se utiliza para un patrón de búsqueda para nuestra cadena de caracteres
import java.util.regex.Pattern; //Libreia que se utiliza para pasar la cadena en dónde deseamos realizar la búsqueda de nuestra expresión.

public class ValidadorConPatron {

    private String nombre; //Variable que almacena el nombre enviado a través de las vistas "Registro"
    private String email; //Variable que almacena el email enviado a través de las vistas "Registro"
    private String cedula; //Variable que almacena la cedula enviada a través de las vistas "Registro"
    private String expediente; //Variable que almacena el expediente enviado a través de las vistas "Registro"
    private Matcher comprobarpalabra; //Variable que almacena la comprobación de la palabra
    private Matcher comprobaremail; //Variable que almacena la comprobación del email
    private Matcher comprobarcedula; //Variable que almacena la comprobación de la cedula
    private Matcher comprobarexpediente; //Variable que almacena la comprobación del expediente
    private Pattern patronpalabra; //Variable que almacena el patrón de la palabra
    private Pattern patronemail; //Variable que almacena el patrón del email
    private Pattern patroncedula; //Variable que almacena el patrón de la cedula
    private Pattern patronexpediente; //Variable que almacena el patrón del expediente
    public boolean verificado; //Variable que almacena si la comprobación se hizo o no correctamente

    public ValidadorConPatron(String palabra) {

        //Inicializando variables
        this.nombre = palabra;
        this.email = palabra;
        this.cedula = palabra;
        this.expediente = palabra;

        //NOMBRE
        /**
         * [_A-Za-zÁÉÍÓÚáéíóúñÑ]+ = La cadena de caracteres debe contar con las
         * letras A hasta la Z "A-Za-z"(minusculas o mayusculas) o también
         * letras con acentos y la letra ñ "ÁÉÍÓÚáéíóúñÑ" repetidos 1 o más
         * veces "+" y seguido de un espacio "\\s" junto a otras letas desde la
         * A hasta la Z "A-Za-z"(minusculas o mayusculas) o también letras con
         * acentos y la letra ñ "ÁÉÍÓÚáéíóúñÑ" repetidos 1 o más veces "+"
         */
        this.patronpalabra = Pattern.compile("[A-Za-zÁÉÍÓÚáéíóúñÑ]+(\\s[A-Za-zÁÉÍÓÚáéíóúñÑ]+)+");

        /**
         * Este metodo sirve para almacenar en la variable "comprobarpalabra" si
         * los caracteres enviados a través de las vistas "Registros"
         * almacenados en la variable "nombre" coinciden "matcher" con los
         * elementos descritos en la variable Pattern "patronpalabra".
         */
        this.comprobarpalabra = patronpalabra.matcher(nombre);

        //EMAIL
        /**
         * ^[_A-Za-z0-9-+]+ = Al empezar la cadena de caracteres "^" debe contar
         * con las letras A hasta la Z "A-Za-z"(minusculas o mayusculas) o
         * también numeros desde el 0 hasta el 9 "0-9" igual que _, - y +
         * repetidos 1 o más veces "+"
         *
         * (\\.[_A-Za-z0-9-]+)* = Luego del caracter . "\\. (Significa que un
         * metacaracter debe ser interpretado literalmente)" debe estar seguido
         * por cualquier caracter de la A a la Z (minusculas o mayusculas)
         * también números del 0 al 9 al igual que _ y - repetidos 1 o más veces
         * "+" y todo esto puede estar repetido 0 o más veces "*"
         *
         * @[A-Za-z0-9-]+ = Seguido forzosamente por un "@" y luego por
         * cualquier caracter, letra o numero, de la A a la Z (minusculas o
         * mayusculas) o del 0 al 9 repetido 1 o más veces
         *
         * (\\.[A-Za-z0-9]+)* = Después de un punto "." le debe seguir una letra
         * de la A a la Z o numeros del 0 al 9 repetidos 0 o más veces "*" (esto
         * es para los correos cuyo dominio termine en: com.ve o com.edu)
         *
         * (\\.[A-Za-z]{2,})$ = Forzosamente la cadena de caracteres debe
         * terminar "$" con . "\\." seguido de un caracter de la A a la Z y el
         * caracter debe estar repetido mínimo 2 veces a más veces "{2,}"
         */
        this.patronemail = Pattern.compile("^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        /**
         * Este metodo sirve para almacenar en la variable "comprobaremail" si
         * los caracteres enviados a través de las vistas "Registros"
         * almacenados en la variable "email" coinciden "matcher" con los
         * elementos descritos en la variable Pattern "patronemail".
         */
        this.comprobaremail = patronemail.matcher(email);

        //CÉDULA
        /**
         * ^([V]+|[E]+) = Al empezar la cadena de caracteres "^" debe contar con
         * las letras V O E (Venezolano o Extranjero) "[V]+|[E]"(mayusculas)
         *
         * -[0-9]{8,}$ = Forzosamente la cadena de caracteres debe terminar "$"
         * con - "-" seguido de numeros del 0 al 9 "[0-9]" y la cadena de
         * caracteres debe contener mínimo 8 numeros "{8,}"
         */
        this.patroncedula = Pattern.compile("^([V]+|[E]+)-[0-9]{8,}$");

        /**
         * Este metodo sirve para almacenar en la variable "comprobarnumero" si
         * los caracteres enviados a través de las vistas "Registros"
         * almacenados en la variable "numero" coinciden "matcher" con los
         * elementos descritos en la variable Pattern "patronnumero".
         */
        this.comprobarcedula = patroncedula.matcher(cedula);

        //EXPEDIENTE
        /**
         * [0-9]{9,}$ = Forzosamente la cadena de caracteres debe contener
         * numeros del 0 al 9 "[0-9]" y la cadena de caracteres debe contener
         * mínimo 9 numeros "{9,}"
         */
        this.patronexpediente = Pattern.compile("[0-9]{9,}");

        /**
         * Este metodo sirve para almacenar en la variable "comprobarexpediente"
         * si los caracteres enviados a través de las vistas "Registros"
         * almacenados en la variable "expediente" coinciden "matcher" con los
         * elementos descritos en la variable Pattern "patronexpediente".
         */
        this.comprobarexpediente = patronexpediente.matcher(expediente);
    }

    //Método para validar el nombre
    public void ValidarNombre() {

        /**
         * Se comprueba que los caracteres de la variable "nombre" coincidan con
         * los del "patronpalabra" y de ser correcto se cambia el estado de la
         * variable "verificado" a verdadero que será enviado de vuelta a las
         * vistas "Registro".
         */
        if (comprobarpalabra.find()) {
            verificado = true;
        } else {
            verificado = false;
        }
    }

    //Método para validar el email
    public void ValidarEmail() {

        /**
         * Se comprueba que los caracteres de la variable "email" coincidan con
         * los del "patronemail" y de ser correcto se cambia el estado de la
         * variable "verificado" a verdadero que será enviado de vuelta a las
         * vistas "Registro".
         */
        if (comprobaremail.find()) {
            verificado = true;
        } else {
            verificado = false;
        }
    }

    //Método para validar la cedula
    public void ValidarCedula() {

        /**
         * Se comprueba que los caracteres de la variable "cedula" coincidan con
         * los del "patroncedula" y de ser correcto se cambia el estado de la
         * variable "verificado" a verdadero que será enviado de vuelta a las
         * vistas "Registro".
         */
        if (comprobarcedula.find()) {
            verificado = true;
        } else {
            verificado = false;
        }
    }

    //Metodo para validar el expediente
    public void ValidarExpediente() {

        /**
         * Se comprueba que los caracteres de la variable "expediente" coincidan
         * con los del "patronexpediente" y de ser correcto se cambia el estado
         * de la variable "verificado" a verdadero que será enviado de vuelta a
         * las vistas "Registro".
         */
        if (comprobarexpediente.find()) {
            verificado = true;
        } else {
            verificado = false;
        }
    }
}
