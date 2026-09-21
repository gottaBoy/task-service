/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.UAC.Ctrl;

import SA.SRFDA.UAC.Ctrl.Data.UACAuthInt;
import SA.SRFDA.UAC.Ctrl.Data.UACDataSource;
import SA.SRFDA.UAC.Ctrl.Data.UACLDAPSource;
import SA.SRFDA.UAC.Ctrl.Data.UACRadiusSource;
import SA.SRFDA.UAC.Ctrl.Data.UACSecuAudit;
import SA.SRFDA.UAC.Ctrl.Data.UACServer;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.Vector;

public interface IUACDataCtrl {
    public CallResult Init(ISRFDAGlobalHelper var1);

    public CallResult GetUACServer(String var1, UACServer var2);

    public CallResult GetUACServerAuthInts(String var1, Vector<UACAuthInt> var2);

    public CallResult GetUACDataSource(String var1, UACDataSource var2);

    public CallResult GetUACLDAPSource(String var1, UACLDAPSource var2);

    public CallResult GetUACRadiusSource(String var1, UACRadiusSource var2);

    public CallResult AddUACSecuAudit(UACSecuAudit var1);
}

