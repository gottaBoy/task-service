/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Res.IPSSysDataSyncAgent;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPI;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysDataSyncAgent;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Properties;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysDataSyncAgentImpl
extends PSSystemObjectImpl
implements IPSSysDataSyncAgent {
    private static final Log log = LogFactory.getLog(PSSysDataSyncAgentImpl.class);
    protected PSSysDataSyncAgent psSysDataSyncAgent = null;
    private String strAgentType = null;
    private String strSyncDir = null;
    private IPSSystemModule iPSSystemModule = null;
    private Properties agentParams = null;
    private String strServicePath = null;
    private String strServiceParam = null;
    private String strServiceParam2 = null;
    private String strAuthMode = "NONE";
    private String strAuthClientId = null;
    private String strAuthClientSecret = null;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSSFXCodeObject iPSSFXCodeObject = null;
    private boolean bRawDataMode = false;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysDataSyncAgent psSysDataSyncAgent) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysDataSyncAgent = psSysDataSyncAgent;
            this.setId(this.psSysDataSyncAgent.getPSSYSDATASYNCAGENTID());
            this.setName(this.psSysDataSyncAgent.getPSSYSDATASYNCAGENTNAME());
            this.setPSObjectData(this.psSysDataSyncAgent);
            this.strAgentType = this.psSysDataSyncAgent.getAGENTTYPE();
            this.strSyncDir = this.psSysDataSyncAgent.getSYNCDIR();
            if (!StringHelper.isNullOrEmpty((String)this.psSysDataSyncAgent.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysDataSyncAgent.getPSMODULEID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysDataSyncAgent.getAGENTPARAMS())) {
                this.agentParams = PropertiesHelper.load((String)this.psSysDataSyncAgent.getAGENTPARAMS());
            }
            this.bRawDataMode = !psSysDataSyncAgent.isRAWDATAMODENull() ? psSysDataSyncAgent.getRAWDATAMODE() : PropertiesHelper.getProperty((Properties)this.getAgentParams(), (String)"RAWDATA", (boolean)this.bRawDataMode);
            this.strAuthMode = this.psSysDataSyncAgent.getAUTHMODE();
            this.strAuthClientId = this.psSysDataSyncAgent.getAUTHCLIENTID();
            this.strAuthClientSecret = this.psSysDataSyncAgent.getAUTHCLIENTSECRET();
            this.strServicePath = this.psSysDataSyncAgent.getSERVICEPATH();
            this.strServiceParam = this.psSysDataSyncAgent.getSERVICEPARAM();
            this.strServiceParam2 = this.psSysDataSyncAgent.getSERVICEPARAM2();
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        String strPSSysSFPluginId = this.psSysDataSyncAgent.getPSSYSSFPLUGINID();
        if (!StringHelper.isNullOrEmpty((String)strPSSysSFPluginId)) {
            this.iPSSysSFPlugin = this.getPSSystem().getPSSysSFPlugin(strPSSysSFPluginId);
        }
        if (this.getPSSysSFPlugin() != null) {
            String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSSystem().getPSSFId());
            IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
            if (iPSSysSFPluginTempl != null) {
                this.iPSSFXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
            }
        }
        super.onInit();
    }

    @Override
    public String getModelType() {
        return "PSSYSDATASYNCAGENT";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7406\u7c7b\u578b", codelist="DataSyncAgentType", group="\u57fa\u672c", order=125)
    public String getAgentType() {
        return this.strAgentType;
    }

    @Override
    @PSModelRTMeta(description="\u540c\u6b65\u65b9\u5411", codelist="DataSyncDir", group="\u57fa\u672c", order=124)
    public String getSyncDir() {
        return this.strSyncDir;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psSysDataSyncAgent.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", dumpref=true, dynamodelmode=4)
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7406\u6807\u8bb0")
    public String getAgentTag() {
        return this.psSysDataSyncAgent.getAGENTTAG();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7406\u6807\u8bb02")
    public String getAgentTag2() {
        return this.psSysDataSyncAgent.getAGENTTAG2();
    }

    @Override
    public ObjectNode toModel(String strType) {
        return super.toModel(strType);
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u670d\u52a1\u53d1\u5e03\u5bf9\u8c61", hideempty=true)
    public IPSSysSFPub getPSSysSFPub() {
        if (this.getPSSystemModule() != null) {
            return this.getPSSystemModule().getPSSysSFPub();
        }
        return this.getPSSystem().getDefaultPSSysSFPub();
    }

    @Override
    @PSModelRTMeta(description="\u5916\u90e8\u670d\u52a1\u63a5\u53e3", hideempty2=true, dumpref=true)
    public IPSSubSysServiceAPI getPSSubSysServiceAPI() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psSysDataSyncAgent.getPSSUBSYSSERVICEAPIID())) {
            return null;
        }
        return this.getPSSystem().getPSSubSysServiceAPI(this.psSysDataSyncAgent.getPSSUBSYSSERVICEAPIID());
    }

    @Override
    @PSModelRTMeta(description="\u540c\u6b65\u4ee3\u7406\u52a8\u6001\u53c2\u6570", hideempty=true)
    public Properties getAgentParams() {
        return this.agentParams;
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u8def\u5f84")
    public String getServicePath() {
        return this.strServicePath;
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u53c2\u6570")
    public String getServiceParam() {
        return this.strServiceParam;
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u53c2\u65702")
    public String getServiceParam2() {
        return this.strServiceParam2;
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u6a21\u5f0f", codelist="APIAuthMode")
    public String getAuthMode() {
        return this.strAuthMode;
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1token\u8def\u5f84")
    public String getAuthAccessTokenUrl() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u5ba2\u6237\u7aef\u6807\u8bc6")
    public String getAuthClientId() {
        return this.strAuthClientId;
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u5ba2\u6237\u7aef\u5bc6\u7801")
    public String getAuthClientSecret() {
        return this.strAuthClientSecret;
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u53c2\u6570", fields={"AUTHPARAM"})
    public String getAuthParam() {
        return this.psSysDataSyncAgent.getAUTHPARAM();
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u53c2\u65702", fields={"AUTHPARAM2"})
    public String getAuthParam2() {
        return this.psSysDataSyncAgent.getAUTHPARAM2();
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u8d85\u65f6\u65f6\u957f", ignoredumpvalues="-1")
    public int getAuthTimeout() {
        return -1;
    }

    @Override
    @PSModelRTMeta(description="\u6d88\u606f\u4e3b\u9898")
    public String getTopic() {
        return this.psSysDataSyncAgent.getTOPIC();
    }

    @Override
    @PSModelRTMeta(description="\u6d88\u8d39\u7ec4\u6807\u8bc6")
    public String getGroupId() {
        return this.psSysDataSyncAgent.getGROUPID();
    }

    @Override
    @PSModelRTMeta(description="\u76f4\u63a5\u6570\u636e\u6a21\u5f0f", ignoredumpvalues="false")
    public boolean isRawDataMode() {
        return this.bRawDataMode;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u7ed8\u5236\u5668", hideempty=true)
    public IPSSFXCodeObject getRender() {
        return this.iPSSFXCodeObject;
    }
}

