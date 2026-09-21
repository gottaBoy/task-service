/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSWFWorkTime;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5de5\u4f5c\u6d41\u5de5\u4f5c\u65f6\u95f4\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSWFWorkTime")
public interface IPSWFWorkTime
extends IPSSystemObject,
IPSSysSFPubObject {
    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSWFWorkTime var3) throws Exception;

    @Override
    public String getCodeName();

    public String getLogicName();

    public String getUserData();

    public String getUserData2();

    public String getWFWorkTimeSN();

    public IPSSystemModule getPSSystemModule();
}

