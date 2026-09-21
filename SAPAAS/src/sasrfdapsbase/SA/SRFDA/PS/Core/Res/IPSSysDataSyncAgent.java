/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPI;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIBase;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysDataSyncAgent;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u7cfb\u7edf\u6570\u636e\u540c\u6b65\u4ee3\u7406\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysDataSyncAgent")
public interface IPSSysDataSyncAgent
extends IPSSystemObject,
IPSSysSFPubObject,
IPSSubSysServiceAPIBase {
    public static final String AGENTTYPE_ACTIVEMQ = "ACTIVEMQ";
    public static final String SYNCDIR_IN = "IN";
    public static final String SYNCDIR_OUT = "OUT";
    public static final String AGENTPARAM_RAWDATA = "RAWDATA";

    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysDataSyncAgent var3) throws Exception;

    public String getAgentType();

    public String getSyncDir();

    @Override
    public String getCodeName();

    public IPSSystemModule getPSSystemModule();

    public String getAgentTag();

    public String getAgentTag2();

    public String getTopic();

    public String getGroupId();

    public IPSSubSysServiceAPI getPSSubSysServiceAPI() throws Exception;

    public Properties getAgentParams();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSSFXCodeObject getRender();

    public boolean isRawDataMode();
}

