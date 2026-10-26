package com.example.crypto.server;

import com.example.crypto.common.AesKey;
import com.example.crypto.common.RsaKeys;
import com.example.crypto.common.RsaService;

import java.util.HashMap;
import java.util.Map;

public class KeyStorage {
    private static final Map<Integer, RsaKeys> rsaStore = new HashMap<>();
    private static final Map<String, AesKey> sessionStore = new HashMap<>();

    static {
        RsaService rsaService = new RsaService();
        for (int i = 1; i <= 10; i++) {
            rsaStore.put(i, rsaService.generateCryptoKeys());
        }
    }

    public static RsaKeys getRsa(int id) { return rsaStore.get(id); }
    public static int addRsa(RsaKeys keys) {
        int newId = rsaStore.size() + 1;
        rsaStore.put(newId, keys);
        return newId;
    }

    public static void saveSession(String sessionId, AesKey key) { sessionStore.put(sessionId, key); }
    public static AesKey getSession(String sessionId) { return sessionStore.get(sessionId); }
}