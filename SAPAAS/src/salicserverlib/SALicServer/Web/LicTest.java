/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.Base64
 */
package SALicServer.Web;

import SA.SRFramework.Utility.Base64;

public class LicTest {
    public static void main(String[] args) {
        String strRet = new String(Base64.decode((String)"H4sIAAAAAAAAAPPxd3b08fAPDtHzAbFc/H0dPf1qDI3M9QyA0LDG0NxIz9BCz1DP0Ny4xsLA0qBGP9jRJzM5OLWoLLVIPyczOTG5JDM/DwCnjuDsSAAAAA=="));
        System.out.print(strRet);
    }
}

