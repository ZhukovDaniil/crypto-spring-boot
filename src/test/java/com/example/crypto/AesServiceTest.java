package com.example.crypto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.example.crypto.common.AesKey;
import com.example.crypto.common.AesService;

public class AesServiceTest {

    @Test
    public void testAesEncryption() {
        AesService service = new AesService();
        AesKey key = service.generateSecretKey();
        String original = "Hello Java";
        String encrypted = service.encrypt(key, original);
        String decrypted = service.decrypt(key, encrypted);
        assertEquals(original, decrypted);
    }
}