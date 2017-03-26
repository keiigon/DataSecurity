package ciphertransposition;

public class CipherTransposition {
    
   

    public static void main(String[] args) {
        Transposition t = new Transposition("42153");
        
       System.out.println("Encrypted Message is: " + t.doEncryption("tarekisworkingnowfors"));
       //System.out.println("Decrypted Message is: " + t.doDecryption(t.doEncryption("Sanfoundry")));
    }
    
}
