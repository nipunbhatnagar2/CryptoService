# CryptoService

Java Cryptography - Keys

A cryptosystem is an implementation of cryptographic techniques and their accompanying infrastructure to provide information security services.

The various components of a basic cryptosystem are Plaintext, Encryption Algorithm, Ciphertext, Decryption Algorithm, Encryption Key and, Decryption Key.

# Symmetric Key Encryption
- Same keys are used for encrypting and decrypting the information.
- Symmetric crypto systems are also sometimes referred to as secret key crypto systems.
- Examples - DES(Digital Encryption Standard), Triple-DES (3DES), IDEA, BLOWFISH.

# Asymmetric Key Encryption
- Different keys are used for encrypting and decrypting the information.
- Though the keys are different, they are mathematically related and hence, retrieving the plaintext by decrypting cipher text is feasible.


Code uses AES algo
128-bit key
16-bit ivKey

Encrypt -
http://localhost:8080/crypto/encrypt/{input}
Decrypt - 
http://localhost:8080/crypto/decrypt/{input}
