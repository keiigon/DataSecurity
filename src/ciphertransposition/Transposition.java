package ciphertransposition;

public class Transposition {
    public static String Key;
    public static String PlainText;

    public static String encryption()
    {
        int i, j;
        String plainText = PlainText;
        
        char keyArray[] = Key.toCharArray();
        int row = plainText.length() / Key.length();
        int extrabit = plainText.length() % Key.length();
        int exrow = (extrabit == 0) ? 0 : 1;
        int coltemp = -1;
        int totallen = (row + exrow) * Key.length();
        char plainTextMat[][] = new char[(row + exrow)][(Key.length())];
        char cipherArray[] = new char[totallen];

        row = 0;
        for (i = 0; i < totallen; i++)
        {
            coltemp++;
            if (i < plainText.length())
            {
                if (coltemp == (Key.length()))
                {
                    row++;
                    coltemp = 0;
                }
                plainTextMat[row][coltemp] = plainText.charAt(i);
            }
            else
            { 
                plainTextMat[row][coltemp] = '*';
            }
        }
        int len = -1, k;
        for (i = 1; i <= Key.length(); i++)
        {
            for (k = 0; k < Key.length(); k++)
            {
                if (i == Character.getNumericValue(keyArray[k]))
                {
                    break;
                }
            }
            for (j = 0; j <= row; j++)
            {
                len++;
                cipherArray[len] = plainTextMat[j][k];
            }
        }
        String cipherText = new String(cipherArray);
        return cipherText;
    }
 
    public static String decryption(String s)
    {
        int i, j, k;
        char keyArray[] = Key.toCharArray();
        char cipherArray[] = s.toCharArray();

        int row = s.length() / Key.length();
        char plainTextMat[][] = new char[row][(Key.length())];
        int tempcnt = -1; 
        for (i = 1; i <= Key.length(); i++)
        {
            for (k = 0; k < Key.length(); k++)
            {
                if (i == Character.getNumericValue(keyArray[k]))
                {
                    break;
                }
            }
            for (j = 0; j < row; j++)
            {
                tempcnt++;
                plainTextMat[j][k] = cipherArray[tempcnt];
            }
        }

        char plainTextArray[] = new char[row * Key.length()];
        k = 0;
        for (i = 0; i < row; i++)
        {
            for (j = 0; j < Key.length(); j++)
            {
                if (plainTextMat[i][j] != '*')
                {
                    plainTextArray[k++] = plainTextMat[i][j];
                }
            }
        }
        
        String originalText = new String(plainTextArray);
        return (originalText);
    }
    
    
}
