/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Security;

import SA.SRFDA.Ctrl.Data.RCALDetail;
import SA.SRFDA.Ctrl.IDAObjectHelper;
import SA.SRFDA.Security.IRCAccListHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IRCALDetailHelper
extends IDAObjectHelper {
    public void Init(ISRFDAGlobalHelper var1, IRCAccListHelper var2, RCALDetail var3) throws Exception;

    public boolean TestRemoteCall(String var1, String var2, String var3, String var4) throws Exception;

    public String getDEId();
}

