/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Security;

import SA.SRFDA.Ctrl.Data.RCAccList;
import SA.SRFDA.Ctrl.IDAObjectHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IRCAccListHelper
extends IDAObjectHelper {
    public void Init(ISRFDAGlobalHelper var1, RCAccList var2) throws Exception;

    public boolean TestRemoteCall(String var1, String var2, String var3, String var4, String var5, String var6) throws Exception;

    public boolean isValid();
}

