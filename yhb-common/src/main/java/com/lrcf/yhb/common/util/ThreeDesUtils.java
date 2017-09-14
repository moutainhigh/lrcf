package com.lrcf.yhb.common.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


/**
 * 3DES
 * CBC模式           环迅加密方式             
 *
 * @author levis
 * @version 1.0 13-6-5
 */
public class ThreeDesUtils {

    /**
     * encrypt3DES
     * 加密
     * @param encryptString
     * @param encryptKey
     * @param iv
     * @return
     */
    public static String encrypt3DES(String encryptString, String encryptKey,String iv)  {
        try{
            IvParameterSpec zeroIv = new IvParameterSpec(iv.getBytes("UTF-8"));
            SecretKeySpec key = new SecretKeySpec(encryptKey.getBytes("UTF-8"), "DESede");
            Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key, zeroIv);
            byte[] encryptedData = cipher.doFinal(encryptString.getBytes("UTF-8"));
            return Base64.encode(encryptedData);
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    /**
     * decrypt3DES
     *解密
     * @param decryptString
     * @param decryptKey
     * @param iv
     * @return
     */
    public static String decrypt3DES(String decryptString, String decryptKey,String iv) {
        try{
            byte[] byteMi = Base64.decodeByte(decryptString,"UTF-8");
            IvParameterSpec zeroIv = new IvParameterSpec(iv.getBytes("UTF-8"));
            SecretKeySpec key = new SecretKeySpec(decryptKey.getBytes("UTF-8"), "DESede");
            Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key, zeroIv);
            byte decryptedData[] = cipher.doFinal(byteMi);
            return new String(decryptedData,"UTF-8");
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

}
