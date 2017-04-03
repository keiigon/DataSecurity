package ciphertransposition;

public class Transposition {
    public static String Key;
    public static String PlainText;

    public static String encryption()
    {
        String plainText = PlainText;
        int keyLength = Key.length();
        char keyArray[] = Key.toCharArray();
        int row = plainText.length() / keyLength;
        int extraChar = plainText.length() % keyLength;
        int extraRow = (extraChar == 0) ? 0 : 1;
        int totalRows = row + extraRow;
        int totalElements = totalRows * keyLength;
        char plainTextMat[][] = new char[totalRows][keyLength];
        char cipherArray[] = new char[totalElements];
        int coltemp = -1;
        
        row = 0;
        for (int i = 0; i < totalElements; i++)
        {
            coltemp++;
            if (i < plainText.length())
            {
                if (coltemp == keyLength)
                {
                    row++;
                    coltemp = 0;
                }
                plainTextMat[row][coltemp] = plainText.charAt(i);
            }
            else
            { 
                plainTextMat[row][coltemp] = '#';
            }
        }
        int len = -1, k;
        for (int i = 1; i <= keyLength; i++)
        {
            for (k = 0; k < keyLength; k++)
            {
                if (i == Character.getNumericValue(keyArray[k]))
                {
                    break;
                }
            }
            for (int j = 0; j <= row; j++)
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
        
        int keyLength = Key.length();
        char keyArray[] = Key.toCharArray();
        char cipherArray[] = s.toCharArray();
        int row = s.length() / keyLength;
        int totalElements = row * keyLength;
        char plainTextMat[][] = new char[row][keyLength];
        int tempcnt = -1; 
        int k;
        
        for (int i = 1; i <= keyLength; i++)
        {
            for (k = 0; k < keyLength; k++)
            {
                if (i == Character.getNumericValue(keyArray[k]))
                {
                    break;
                }
            }
            for (int j = 0; j < row; j++)
            {
                tempcnt++;
                plainTextMat[j][k] = cipherArray[tempcnt];
            }
        }

        char plainTextArray[] = new char[totalElements];
        k = 0;
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < keyLength; j++)
            {
                if (plainTextMat[i][j] != '#')
                {
                    plainTextArray[k++] = plainTextMat[i][j];
                }
            }
        }
        
        String originalText = new String(plainTextArray);
        return (originalText);
    }
    
    
}
