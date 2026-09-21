/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.IDAModelStorage;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IDAConfigPublisherContext {
    public String getLanguage();

    public String getPageModel();

    public ISRFDAGlobalHelper getDAGlobalHelper();

    public String GetLocalization(IDEHelper var1, String var2, String var3);

    public String GetLocalization(IDEHelper var1, String var2, String var3, String var4);

    public IDAModelStorage getDAModelStorage();
}

