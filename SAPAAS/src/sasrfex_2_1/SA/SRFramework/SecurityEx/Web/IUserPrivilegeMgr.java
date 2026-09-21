/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.SecurityEx.Web;

import SA.SRFramework.WebEx.ISRFExWebContext;
import SA.SRFramework.WebEx.SRFExHttpServletContext;
import SA.SRFramework.WebEx.SRFExWebContext;

public interface IUserPrivilegeMgr {
    public void Reset(SRFExWebContext var1);

    public void Reset();

    public boolean Test(SRFExWebContext var1, String var2);

    public int TestColumn(ISRFExWebContext var1, String var2);

    public void LogTest(SRFExWebContext var1, Object var2, String var3);

    public boolean Test(SRFExHttpServletContext var1, String var2);
}

