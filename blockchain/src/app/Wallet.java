package app;

import java.security.*;
import java.security.spec.ECGenParameterSpec;
import java.security.NoSuchProviderException;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidAlgorithmParameterException;


public class Wallet
{
    public PrivateKey privateKey;
    public PublicKey publicKey;

    public Wallet() 
    {
        this.generateKeyPair();
    }

    public void generateKeyPair()
    {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            
			keyGen.initialize(256, random);
            KeyPair keyPair = keyGen.generateKeyPair();
            this.privateKey = keyPair.getPrivate();
            this.publicKey = keyPair.getPublic();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}