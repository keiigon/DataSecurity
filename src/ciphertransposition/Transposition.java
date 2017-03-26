package ciphertransposition;

public class Transposition {
    public static String selectedKey;
    public static char   sortedKey[];
    public static int    sortedKeyPos[];
    
    public Transposition(String myKey)
    {
        selectedKey = myKey;
    }
    
    // to encrypt the targeted string
    public static String doEncryption(String plainText)
    {
        int i, j;
        
        char orginalKey[] = selectedKey.toCharArray();
        int row = plainText.length() / selectedKey.length();
        int extrabit = plainText.length() % selectedKey.length();
        int exrow = (extrabit == 0) ? 0 : 1;
        int coltemp = -1;
        int totallen = (row + exrow) * selectedKey.length();
        char pmat[][] = new char[(row + exrow)][(selectedKey.length())];
        char encry[] = new char[totallen];

        row = 0;
        for (i = 0; i < totallen; i++)
        {
            coltemp++;
            if (i < plainText.length())
            {
                if (coltemp == (selectedKey.length()))
                {
                    row++;
                    coltemp = 0;
                }
                pmat[row][coltemp] = plainText.charAt(i);
            }
            else
            { // do the padding ...
                pmat[row][coltemp] = '*';
            }
        }
        int len = -1, k;
        for (i = 1; i <= selectedKey.length(); i++)
        {
            for (k = 0; k < selectedKey.length(); k++)
            {
                if (i == Character.getNumericValue(orginalKey[k]))
                {
                    break;
                }
            }
            for (j = 0; j <= row; j++)
            {
                len++;
                encry[len] = pmat[j][k];
            }
        }
        String p1 = new String(encry);
        return (new String(p1));
    }
 
    // to decrypt the targeted string
    public static String doDecryption(String s)
    {
        int min, i, j, k;
        char key[] = selectedKey.toCharArray();
        char encry[] = s.toCharArray();
        char temp;
        // Now generating plain message
        int row = s.length() / selectedKey.length();
        char pmat[][] = new char[row][(selectedKey.length())];
        int tempcnt = -1;
        for (i = 1; i <= selectedKey.length(); i++)
        {
            for (k = 0; k < selectedKey.length(); k++)
            {
                if (i == Character.getNumericValue(key[k]))
                {
                    break;
                }
            }
            for (j = 0; j < row; j++)
            {
                tempcnt++;
                pmat[j][k] = encry[tempcnt];
            }
        }
        // store matrix character in to a single string
        char p1[] = new char[row * selectedKey.length()];
        k = 0;
        for (i = 0; i < row; i++)
        {
            for (j = 0; j < selectedKey.length(); j++)
            {
                if (pmat[i][j] != '*')
                {
                    p1[k++] = pmat[i][j];
                }
            }
        }
        p1[k++] = '\0';
        return (new String(p1));
    }
    
    
}
