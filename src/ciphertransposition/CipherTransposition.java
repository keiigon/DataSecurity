package ciphertransposition;

public class CipherTransposition {
    
   

    public static void main(String[] args) {
        Transposition t = new Transposition();
       System.out.println("Encrypted Message is: "
                + t.doEncryption("Sanfoundry"));
        System.out.println("Decrypted Message is: "
                + t.doDecryption(t.doEncryption("Sanfoundry")));
    }
    
}
