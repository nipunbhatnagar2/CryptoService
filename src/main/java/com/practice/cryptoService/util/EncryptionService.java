package com.practice.cryptoService.util;

import com.practice.cryptoService.config.AuthenticationConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

@Slf4j
@Component
public class EncryptionService {

    @Autowired
    AuthenticationConfiguration authenticationConfiguration;

    public SecretKeySpec generateKey() {
        String myKey = authenticationConfiguration.getKey();

        MessageDigest sha;
        byte[] key;
        SecretKeySpec secretKey = null;

        try {
            key = myKey.getBytes(StandardCharsets.UTF_8);
            sha = MessageDigest.getInstance("SHA-512");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        } catch (Exception e) {
            log.info("Exception occurred : " + e);
        }
        return secretKey;
    }

    public IvParameterSpec generateIv() {
        String string = "0000000011111111";
        byte[] bytes = string.getBytes();
        return new IvParameterSpec(bytes);
    }

    public String encrypt(String input) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, generateKey(), generateIv());
        byte[] cipherText = cipher.doFinal(input.getBytes());
        return Base64.getEncoder().encodeToString(cipherText);
    }
}
