/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Web.Default;

public class DefaultPageHelper {
    private static String strEditViewPage = "../srfpage/editview.jsp?";
    private static String strGridViewPage = "../srfpage/gridview.jsp?";
    private static String strPickupViewPage = "../srfpage/pickupview.jsp?";

    public static String GetEditViewPage() {
        return strEditViewPage;
    }

    public static void SetEditViewPage(String strPath) {
        strEditViewPage = strPath;
    }

    public static String GetGridViewPage() {
        return strGridViewPage;
    }

    public static void SetGridViewPage(String strPath) {
        strGridViewPage = strPath;
    }

    public static String GetPickupViewPage() {
        return strPickupViewPage;
    }

    public static void SetPickupViewPage(String strPath) {
        strPickupViewPage = strPath;
    }
}

