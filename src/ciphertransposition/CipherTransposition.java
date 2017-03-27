package ciphertransposition;

import java.util.Scanner;

public class CipherTransposition {

    public static void main(String[] args) {
        Transposition t = new Transposition();
        Scanner s = new Scanner(System.in);
        System.out.print("Enter Encryption Key: ");
        Transposition.Key = s.next();

        System.out.print("Enter Plain text: ");
        Transposition.PlainText = s.next();

        System.out.println("Encrypted Message is: " + t.encryption());
        System.out.println("Decrypted Message is: " + t.decryption(t.encryption()));
    }

}
