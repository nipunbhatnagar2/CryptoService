package com.practice.cryptoService.controller;

import com.practice.cryptoService.util.DecryptionService;
import com.practice.cryptoService.util.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/crypto")
public class CryptoController {

    @Autowired
    EncryptionService encryptionService;

    @Autowired
    DecryptionService decryptionService;

    @GetMapping(value = "/encrypt/{input}")
    public String encrypt(@PathVariable(name = "input", required = true) String input) throws Exception {
        return encryptionService.encrypt(input);
    }

    @GetMapping(value = "/decrypt/{input}")
    public String decrypt(@PathVariable(name = "input", required = true) String input) throws Exception {
        return decryptionService.decrypt(input);
    }

    @GetMapping(value = "/health")
    public String health(){
        return "UP";
    }
}
