/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.GlobalHelperEx
 */
package SA.SRFDA.KPI.Ctrl;

import SA.SRFDA.Web.Utility.GlobalHelperEx;

public interface ISRFKPIContext {
    public Integer IntV(String var1);

    public String StrV(String var1);

    public Double DoubleV(String var1);

    public String UD1();

    public String UD2();

    public String UD3();

    public String UD4();

    public int BATSN();

    public GlobalHelperEx getContextHelper();
}

