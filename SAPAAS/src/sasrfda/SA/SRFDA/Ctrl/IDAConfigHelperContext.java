/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IDAConfigHelperContext {
    public String getLanguage();

    public String getPageModel();

    public ISRFDAGlobalHelper getDAGlobalHelper();

    public String GetLocalization(IDEHelper var1, String var2, String var3);

    public String GetLocalization(IDEHelper var1, String var2, String var3, String var4);
}

