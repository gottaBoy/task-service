/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Security;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysUserDR;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelInterfaceMeta(title="\u7cfb\u7edf\u7528\u6237\u81ea\u5b9a\u4e49\u6570\u636e\u8303\u56f4\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysUserDR")
public interface IPSSysUserDR
extends IPSSystemObject,
IPSSysSFPubObject {
    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysUserDR var3) throws Exception;

    public String getCustomMode();

    public IPSSystemModule getPSSystemModule();
}

