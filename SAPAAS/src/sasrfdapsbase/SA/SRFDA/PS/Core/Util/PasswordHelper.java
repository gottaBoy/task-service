/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.Helper
 */
package SA.SRFDA.PS.Core.Util;

import SA.SRFramework.Utility.Helper;
import java.util.Random;

public class PasswordHelper {
    private static Random random = new Random();

    public static String generate() {
        return PasswordHelper.generate(8);
    }

    public static String generate(int nLength) {
        String strSource = Helper.GenMD5Ex((String)Helper.GenGuid()).substring(0, nLength);
        String strPassword = "";
        int i = 0;
        while (i < nLength) {
            int nPos = random.nextInt(100) % 15;
            strPassword = nPos == 0 ? String.valueOf(strPassword) + "@" : (nPos == 3 ? String.valueOf(strPassword) + "!" : (nPos == 4 ? String.valueOf(strPassword) + "^" : (nPos % 2 == 0 ? String.valueOf(strPassword) + strSource.substring(i, i + 1).toUpperCase() : String.valueOf(strPassword) + strSource.substring(i, i + 1))));
            ++i;
        }
        return strPassword;
    }
}

