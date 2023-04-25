import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class DecompilarLevel1Crackmes {
    public static void main(String[] args) throws Exception {
        String encryptedText = "5UJiFctbmgbDoLXmpL12mkno8HT4Lv8dlat8FxR2GOc=";
        String keyHex = "8d127684cbc37c17616d806cf50473cc";
        
        // Convertir la clave de formato hexadecimal a formato de bytes
        byte[] keyBytes = hexStringToByteArray(keyHex);
        
        // Descifrar el texto encriptado
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        String decryptedText = new String(decryptedBytes);
        
        System.out.println("Texto desencriptado: " + decryptedText);
    }
    
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
}
