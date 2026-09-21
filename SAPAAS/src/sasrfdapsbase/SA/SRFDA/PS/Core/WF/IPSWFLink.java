/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.pswf.core.IWFLinkModel
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.WF.IPSWFLinkGroupCond;
import SA.SRFDA.PS.Core.WF.IPSWFProcess;
import SA.SRFDA.PS.Core.WF.IPSWFVersion;
import SA.SRFDA.PS.Data.PSWFLink;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.pswf.core.IWFLinkModel;

@PSModelInterfaceMeta(title="\u5de5\u4f5c\u6d41\u5904\u7406\u8fde\u63a5\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typefield="wFLinkType", implement="PSWFLinkImpl", model="PSWFLink")
public interface IPSWFLink
extends IPSModelObject,
IWFLinkModel {
    public static final String WFLINKTYPE_IAACTION = "IAACTION";
    public static final String WFLINKTYPE_ROUTE = "ROUTE";
    public static final String WFLINKTYPE_TIMEOUT = "TIMEOUT";
    public static final String WFLINKTYPE_WFRETURN = "WFRETURN";

    public void init(ISRFDAGlobalHelper var1, IPSWFVersion var2, IPSWFProcess var3, PSWFLink var4) throws Exception;

    public IPSWFLinkGroupCond getPSWFLinkGroupCond();

    public IPSWFProcess getToPSWFProcess() throws Exception;

    public IPSWFProcess getFromPSWFProcess() throws Exception;

    public IPSWFVersion getPSWFVersion();

    public String getWFLinkType();

    public String getLogicName();

    public String getMemoField();

    public IPSLanguageRes getLNPSLanguageRes();

    public boolean isEnableCustomCond();

    public String getCustomCond();
}

