package clases;

public class Validador {

    //Declaración de variables
    private String verificarpalabra; //Almacena la cadena de caracteres que contiene las letras.
    private String verificaremail; //Almacena el "@".
    private String nombre; //Almacena el "nombre" enviado desde las vistas "Registro".
    private String email; //Almacena el "email" enviado desde las vistas "Registro".
    private String verificarnumeros; //Almacena la cadena de caracteres que contiene los numeros.
    private String caracter[]; //Almacena cada uno de los caracter de la cadena de caracteres de las letras.
    private String caracternumeros[];//Almacena cada uno de los caracter de la cadena de caracteres de los números.
    private int posiciones; //Almacena la longitud de la cadena de caracteres que contiene las letras.
    private int acceso; //Sirve como bandera para saber si se paso la comprobación.
    private int acceso2; //Sirve como bandera para saber si se paso la comprobación.
    private int erroracceso2; //Sirve como bandera para saber si ocurrio un error en la comprobación.
    private int posicionesnumeros; //Almacena la longitud de la cadena de caracteres que contiene los numeros.
    private int validarpar; //Almacena el resto de acceso.
    private int validarpar2; //Almacena el resto de acceso2.
    public boolean verificado; //Indica si se ha completado exitosamente o no todas las comprobaciones.

    public Validador(String palabra) {

        //Inicializando variables
        this.verificarpalabra = "ÁÉÍÓÚáéíóúabcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        this.nombre = palabra;
        this.posiciones = verificarpalabra.length();
        this.caracter = new String[posiciones];
        this.acceso = 0;
        this.verificado = false;

        this.acceso2 = 0;
        this.erroracceso2 = 0;
        this.verificaremail = "@";
        this.email = palabra;
        this.validarpar = 0;
        this.validarpar2 = 0;

        this.verificarnumeros = "0123456789";
        this.posicionesnumeros = verificarnumeros.length();
        this.caracternumeros = new String[posicionesnumeros];
    }

    //Metodo para validar el nombre
    public void ValidarNombre() {

        /**
         * Rellenar el vector unidemensional "caracter[]" para que tenga cada
         * una de las letras que se encuentran en la variable String
         * "verificarpalabra" con un bucle for
         */
        for (int i = 0; i < posiciones; i++) {
            caracter[i] = verificarpalabra.substring(i, i + 1);
        }

        /**
         * Se inicia con un bucle for con el cual se va a verificar cada
         * caracter de la cadena de caracteres que se envian a través de las
         * vistas "Registrar" almacenado en la variable "nombre".
         */
        for (int i = 0; i < nombre.length(); i++) {

            /**
             * Se realiza un bucle for para recorrer el vector
             * "caracternumeros[]" y verificar que ese caracter pertenezca al
             * grupo de caracteres almacenados en el vector y de ser correcto
             * esta comprobación, ".equals", se incrementa la variable de acceso
             * "acceso" en 1.
             */
            for (int j = 0; j < posiciones; j++) {
                if (nombre.substring(i, i + 1).equals(caracter[j])) {
                    acceso++;
                }
            }
        }

        /**
         * Se comprueba que la variable acceso haya aumentado tantas veces como
         * caracteres tiene la variable "nombre" para saber que cada uno si
         * pertenece al grupo de caracteres en el vector "caracter[]" y se envia
         * la variable verificado a las vistas "Registro".
         */
        if (acceso == nombre.length()) {
            verificado = true;
        } else {
            verificado = false;
        }
    }

    //Metodo para validar el email
    public void ValidarEmail() {

        /**
         * Rellenar el vector unidemensional "caracter[]" para que tenga cada
         * una de las letras que se encuentran en la variable String
         * "verificarpalabra" con un bucle for
         */
        for (int i = 0; i < posiciones; i++) {
            caracter[i] = verificarpalabra.substring(i, i + 1);
        }

        /**
         * Rellenar el vector unidemensional "caracternumeros[]" para que tenga
         * cada uno de los numeros que se encuentran en la variable String
         * "verificarnumeros" con un bucle for.
         */
        for (int i = 0; i < posicionesnumeros; i++) {
            caracternumeros[i] = verificarnumeros.substring(i, i + 1);
        }

        /**
         * Se inicia con un bucle for con el cual se va a verificar cada
         * caracter de la cadena de caracteres que se envian a través de las
         * vistas "Registrar" almacenado en la variable "email".
         */
        for (int i = 0; i < email.length(); i++) {

            /**
             * Se comprueba que el caracter que se haya encontrado sea un "@"
             * que está almacenado en la variable String "verificaremail" y se
             * comprueba que el tamaño de la cadena de caracteres "email" sea
             * mayor que 1 para saber que tiene más de 1 caracter.
             */
            if (email.substring(i, i + 1).equals(verificaremail) && email.length() > 1) {

                /**
                 * Se realiza un bucle for para recorrer, ".substring", la
                 * cadena de caracteres que se encuentran antes del caracter "@"
                 * y verificar que ese caracter pertenezca al grupo de
                 * caracteres almacenados en el vector "caracter[]" también
                 * recorrido por otro bucle for para analizar cada uno de los
                 * casos y de ser correcto esta comprobación, ".equals", se
                 * incrementa la variable de acceso "acceso" en 1.
                 */
                for (int j = 0; j < i + 1; j++) {
                    for (int k = 0; k < posiciones; k++) {
                        if (email.substring(0, j).equals(caracter[k])) {
                            acceso++;
                        }
                    }
                }

                /**
                 * Se realiza un bucle for para recorrer, ".substring", la
                 * cadena de caracteres (numeros) que se encuentran antes del
                 * caracter "@" y verificar que ese caracter pertenezca al grupo
                 * de caracteres almacenados en el vector "caracternumeros[]"
                 * también recorrido por otro bucle for para analizar cada uno
                 * de los casos y de ser correcto esta comprobación, ".equals",
                 * se incrementa la variable de acceso "acceso" en 1.
                 */
                for (int j = 0; j < i + 1; j++) {
                    for (int k = 0; k < posicionesnumeros; k++) {
                        if (email.substring(0, j).equals(caracternumeros[k])) {
                            acceso++;
                        }
                    }
                }

                /**
                 * Se recorre, ".substring", la cadena de caracteres que se
                 * encuentran después del caracter "@" y verificar que ese
                 * caracter pertenezca al grupo de caracteres almacenados en el
                 * vector "caracter[]" recorrido por un bucle for para analizar
                 * cada uno de los casos y de ser correcto esta comprobación,
                 * ".equals", se incrementa la variable de acceso "acceso" en 1.
                 */
                for (int j = i; j < email.length(); j++) {
                    for (int m = 0; m < posiciones; m++) {
                        if (email.substring(j, email.length()).equals(caracter[m])) {
                            acceso++;
                        }
                    }
                }

            } //Se añade la condición que de encontrar un espacio en la cadena de caracteres se disminiya la variable "acceso" en 1.
            else if (email.substring(i, i + 1).equals(" ")) {
                acceso--;
            }
        }

        /**
         * La variable "validarpar" tiene el valor del resto perteneciente al
         * dividir el valor total de la variable "acceso" entre 2 para conocer
         * si es un numero par o no, debido a que si se cumplen todas las
         * condiciones satisfactoriamente debería tener un número par.
         */
        validarpar = acceso % 2;

        /**
         * Se inicia con un bucle for con el cual se va a verificar cada
         * caracter de la cadena de caracteres que se envian a través de las
         * vistas "Registrar" almacenada en la variable "email".
         */
        for (int i = 0; i < email.length(); i++) {

            /**
             * Se comprueba que el caracter que se haya encontrado sea un "." y
             * se comprueba que el tamaño de la cadena de caracteres "email" sea
             * mayor que 1 para saber que tiene más de 1 caracter.
             */
            if (email.substring(i, i + 1).equals(".") && email.length() > 1) {

                /**
                 * Se realiza un bucle for para recorrer, ".substring", la
                 * cadena de caracteres que se encuentran antes del caracter "."
                 * y se verifica que ese caracter pertenezca al grupo de
                 * caracteres almacenados en el vector "caracter[]" también
                 * recorrido por otro bucle for para analizar cada uno de los
                 * casos y de ser correcto esta comprobación, ".equals", se
                 * incrementa la variable de acceso "acceso2" en 1.
                 */
                for (int j = 0; j < i + 1; j++) {
                    for (int k = 0; k < posiciones; k++) {
                        if (email.substring(0, j).equals(caracter[k])) {
                            acceso2++;
                        }
                    }
                }

                /**
                 * Se recorre, ".substring", la cadena de caracteres que se
                 * encuentran después del caracter "." y se verifica que ese
                 * caracter pertenezca al grupo de caracteres almacenados en el
                 * vector "caracter[]" recorrido por un bucle for para analizar
                 * cada uno de los casos y de ser correcto esta comprobación,
                 * ".equals", se incrementa la variable de acceso "acceso2" en
                 * 1.
                 */
                for (int j = i; j < email.length(); j++) {
                    for (int m = 0; m < posiciones; m++) {
                        if (email.substring(j, email.length()).equals(caracter[m])) {
                            acceso2++;
                        }
                    }
                }

                /**
                 * Se comprueba que después del caracter "." no se encuentre un
                 * "@" debido a que estaría erroneo la sintaxis del email y para
                 * esto de decrementa la variable de "acceso2" en 1 al igual que
                 * incrementa la variable "erroracceso2" en 1.
                 */
                if (email.substring(i + 1, i + 2).equals("@")) {
                    acceso2--;
                    erroracceso2++;
                }
            }
        }

        /**
         * Se inicia con un bucle for con el cual se va a verificar cada
         * caracter de la cadena de caracteres que se envian a través de las
         * vistas "Registrar" almacenada en la variable "email".
         */
        for (int i = 0; i < email.length(); i++) {

            /**
             * Se realiza un bucle for para recorrer el vector
             * "caracternumeros[]" para saber si el caracter de "email" es un
             * valor que esta almacenado y se comprueba si la cadena de
             * caracteres es mayor que 1, al igual que la variable "acceso" sea
             * igual o mayor que 2, la variable "acceso2" sea un número impar y
             * la variable "erroracceso2" sea igual a 0. Esto nos servira para
             * escribir numeros al principio de la cadena de caracteres.
             */
            for (int j = 0; j < posicionesnumeros; j++) {
                if (email.substring(i, i + 1).equals(caracternumeros[j]) && email.length() > 1) {
                    if (acceso >= 2 && acceso2 % 2 != 0 && erroracceso2 == 0) {
                        acceso2++;
                    }
                }
            }
        }

        /**
         * La variable "validarpar2" tiene el valor del resto perteneciente al
         * dividir el valor total de la variable "acceso2" entre 2 para conocer
         * si es un numero par o no, debido a que si se cumplen todas las
         * condiciones satisfactoriamente debería tener un número par.
         */
        validarpar2 = acceso2 % 2;

        /**
         * Por último se comprueba todas las condiciones necesarias para que la
         * variable "verificado", que sera enviada a las vistas "Registro", sea
         * verdadera. Las cuales son que las variables "validarpar" y
         * "validarpar2" deben ser pares y las variables "acceso" y "acceso2"
         * deben tener un valor distinto a 0.
         */
        if (validarpar == 0 && validarpar2 == 0 && acceso != 0 && acceso2 != 0) {
            verificado = true;
        } else {
            verificado = false;
        }
    }
}
