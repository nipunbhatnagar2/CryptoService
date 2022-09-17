package com.practice.cryptoService.controller;

import com.practice.cryptoService.config.AuthenticationConfiguration;

public class Test {
    public static void main(String[] args) throws Exception {
        try {
            AuthenticationConfiguration authenticationConfiguration = new AuthenticationConfiguration();
            System.out.println("Encrypted : " + authenticationConfiguration.getKey());

            System.out.println("Decrypted : " + authenticationConfiguration.getIvKey());
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
