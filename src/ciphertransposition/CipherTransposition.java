package ciphertransposition;

import java.util.Scanner;

public class CipherTransposition {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter Encryption Key: ");
        Transposition.Key = s.next();

        System.out.print("Enter Plain text: ");
        Transposition.PlainText = s.next();

        System.out.println("Encrypted Message is: " + Transposition.encryption());
        System.out.println("Decrypted Message is: " + Transposition.decryption(Transposition.encryption()));
    }

}
