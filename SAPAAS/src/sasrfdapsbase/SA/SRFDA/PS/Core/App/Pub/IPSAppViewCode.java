/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.App.Pub;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.IPSApplicationObject;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Core.Pub.IPSSysPFUserCode;
import SA.SRFDA.PS.Data.PSAppViewCode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSAppViewCode
extends IPSApplicationObject,
IPSSysPFUserCode {
    public void init(ISRFDAGlobalHelper var1, IPSApplication var2, PSAppViewCode var3) throws Exception;

    public IPSPFPubCode getPSPFPubCode();
}

