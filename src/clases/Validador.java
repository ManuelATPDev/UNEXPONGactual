package clases;

public class Validador {

    private String verificarpalabra, verificaremail, nombre, email, verificarnumeros;
    private String caracter[], caracternumeros[];
    private int posiciones, acceso, acceso2, erroracceso2, posicionesnumeros, validarpar, validarpar2;
    public boolean verificado;

    public Validador(String palabra) {
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

    public void ValidarNombre() {
        for (int i = 0; i < posiciones; i++) {
            caracter[i] = verificarpalabra.substring(i, i + 1);
        }
        for (int i = 0; i < nombre.length(); i++) {
            for (int j = 0; j < posiciones; j++) {
                if (nombre.substring(i, i + 1).equals(caracter[j])) {
                    acceso++;
                }
            }
        }
        if (acceso == nombre.length()) {
            verificado = true;
        } else {
            verificado = false;
        }
    }

    public void ValidarEmail() {
        
        /**Rellenar el vector unidemensional "caracter[]" para que tenga cada una de las letras que se encuentran
         * en la variable String "verificarpalabra" con un bucle for
         */
        
        for (int i = 0; i < posiciones; i++) {
            caracter[i] = verificarpalabra.substring(i, i + 1);
        }
        
        /**Rellenar el vector unidemensional "caracternumeros[]" para que tenga cada uno de los numeros que se encuentran
         * en la variable String "verificarnumeros" con un bucle for
         */
        
        for (int i = 0; i < posicionesnumeros; i++) {
            caracternumeros[i] = verificarnumeros.substring(i, i + 1);
        }
        
        /**Se inicia con un bucle for con el cual se va a verificar cada caracter de la cadena de caracteres que se envian
         * a través de las vistas "Registrar"
         * 
         */

        for (int i = 0; i < email.length(); i++) {
            
            /**Se comprueba que el caracter que se haya encontrado sea un "@" que está
             * almacenado en la variable String "verificaremail" y se comprueba que el tamaño
             * de la cadena de caracteres "email" sea mayor que 1 para saber que tiene más de 1 caracter
             */
            if (email.substring(i, i + 1).equals(verificaremail) && email.length() > 1) {

                for (int j = 0; j < i + 1; j++) {
                    for (int k = 0; k < posiciones; k++) {
                        if (nombre.substring(0, j).equals(caracter[k])) {
                            acceso++;
                        }
                    }
                }

                for (int j = 0; j < i + 1; j++) {
                    for (int k = 0; k < posicionesnumeros; k++) {
                        if (nombre.substring(0, j).equals(caracternumeros[k])) {
                            acceso++;
                        }
                    }
                }

                for (int l = i; l < email.length(); l++) {
                    for (int m = 0; m < posiciones; m++) {
                        if (nombre.substring(l, email.length()).equals(caracter[m])) {
                            acceso++;
                        }
                    }
                }

            } else if (email.substring(i, i + 1).equals(" ")) {
                acceso--;
            }
        }
        validarpar = acceso % 2;

        for (int i = 0; i < email.length(); i++) {
            if (email.substring(i, i + 1).equals(".") && email.length() > 1) {

                for (int j = 0; j < i + 1; j++) {
                    for (int k = 0; k < posiciones; k++) {
                        if (nombre.substring(0, j).equals(caracter[k])) {
                            acceso2++;
                        }
                    }
                }

                for (int l = i; l < email.length(); l++) {
                    for (int m = 0; m < posiciones; m++) {
                        if (nombre.substring(l, email.length()).equals(caracter[m])) {
                            acceso2++;
                        }
                    }
                }

                if (nombre.substring(i + 1, i + 2).equals("@")) {
                    acceso2--;
                    erroracceso2++;
                }
            }
            System.out.println(acceso);
        }

        for (int i = 0; i < email.length(); i++) {
            for (int j = 0; j < posicionesnumeros; j++) {
                if (email.substring(i, i + 1).equals(caracternumeros[j]) && email.length() > 1) {
                    if(acceso >= 2 && acceso2%2 != 0 && erroracceso2 == 0){
                        acceso2++;
                    }
                }
            }
        }
        System.out.println(acceso2);
        validarpar2 = acceso2 % 2;

        if (validarpar == 0 && validarpar2 == 0 && acceso != 0 && acceso2 != 0) {
            verificado = true;
        } else {
            verificado = false;
        }
    }

    /**
     * public void ValidarEmail() {
     *
     * for (int i = 0; i < verificarpalabra.length(); i++) { caracter[i] =
     * verificarpalabra.substring(i, i + 1); }
     *
     * for (int i = 0; i < email.length(); i++) { for (int j = 0; j <
     * posiciones; j++) { if (email.substring(i, i + 1).equals(caracter[j])) {
     * acceso++; } } } if (acceso == email.length()) { verificado = true; } else
     * { verificado = false; } }
     */
}
