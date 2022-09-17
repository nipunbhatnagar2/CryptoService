package com.practice.cryptoService.util;

import com.practice.cryptoService.config.AuthenticationConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.util.AbstractUriTemplateHandler;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

@Slf4j
@Component
public class DecryptionService {

    @Autowired
    AuthenticationConfiguration authenticationConfiguration;

    public SecretKeySpec setKey() {
        String myKey = authenticationConfiguration.getKey();

        MessageDigest sha = null;
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

    public String decrypt(String input) throws Exception {
        Cipher cipher;
        byte[] plainText = null;
        try {
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, setKey(), generateIv());
            plainText = cipher.doFinal(Base64.getDecoder().decode(input));
        } catch (Exception e) {
            log.info("Exception occurred : " + e);
        }
        return new String(plainText, StandardCharsets.UTF_8);
    }
}
