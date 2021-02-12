package clases;

import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import org.apache.commons.codec.binary.Base64;

public class EncriptarPassword {
//Comentarios Stefany<3
    private String password;
    public String encriptacion;
    public String desencriptacion;
    private String secretKey = "";

    public EncriptarPassword(String password) {
        this.password = password;
        this.encriptacion = "";
        this.desencriptacion = "";
        this.secretKey = "$omosUn1v3r51d4d3xp3r1m3n741P01173cn1c44n70n10J053d35ucr30Nu3130Gu4r3n4$";
    }

    public String encode() {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] llavepasword = md5.digest(secretKey.getBytes("utf-8"));
            byte[] llaveByte = Arrays.copyOf(llavepasword, 24);

            SecretKey key = new SecretKeySpec(llaveByte, "DESede");
            Cipher cifrado = Cipher.getInstance("DESede");

            cifrado.init(Cipher.ENCRYPT_MODE, key);
            byte[] textoBytes = password.getBytes();
            byte[] buf = cifrado.doFinal(textoBytes);

            byte[] base64Bytes = Base64.encodeBase64(buf);
            encriptacion = new String(base64Bytes);

        } catch (Exception e) {
            System.err.println("Error " + e);
            JOptionPane.showMessageDialog(null, "Error");
        }
        return encriptacion;
    }

    public String decode() {

        try {
            byte[] message = Base64.decodeBase64(password.getBytes("utf-8"));
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digestPassword = md5.digest(secretKey.getBytes("utf-8"));
            byte[] llaveByte = Arrays.copyOf(digestPassword, 24);

            SecretKey key = new SecretKeySpec(llaveByte, "DESede");
            Cipher descifrado = Cipher.getInstance("DESede");

            descifrado.init(Cipher.DECRYPT_MODE, key);
            byte[] texto = descifrado.doFinal(message);
            desencriptacion = new String(texto, "UTF-8");
        } catch (Exception e) {
            System.err.println("Error " + e);
            JOptionPane.showMessageDialog(null, "Error");
        }
        return desencriptacion;
    }
}
