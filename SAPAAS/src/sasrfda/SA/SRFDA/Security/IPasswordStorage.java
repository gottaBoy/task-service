/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Security;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPasswordStorage {
    public void Init(ISRFDAGlobalHelper var1) throws Exception;

    public void Storage(IDEDataCtrl var1, String var2, Object var3, String var4, String var5, boolean var6) throws Exception;

    public String Revert(String var1, Object var2, String var3) throws Exception;

    public boolean Check(String var1, Object var2, String var3, String var4) throws Exception;
}

