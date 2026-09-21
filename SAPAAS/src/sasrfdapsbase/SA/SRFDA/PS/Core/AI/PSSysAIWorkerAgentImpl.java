/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.AI;

import SA.SRFDA.PS.Core.AI.IPSSysAIFactory;
import SA.SRFDA.PS.Core.AI.IPSSysAIWorkerAgent;
import SA.SRFDA.PS.Core.AI.PSSysAIFactoryObjectImpl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Data.PSSysAIWorkerAgent;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysAIWorkerAgentImpl
extends PSSysAIFactoryObjectImpl
implements IPSSysAIWorkerAgent {
    private static final Log log = LogFactory.getLog(PSSysAIWorkerAgentImpl.class);
    protected PSSysAIWorkerAgent psSysAIWorkerAgent = null;
    private Properties agentParams = null;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSSFXCodeObject iPSSFXCodeObject = null;
    private IPSDataEntity iPSDataEntity = null;
    private IPSDELogic iPSDELogic = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysAIFactory iPSSysAIFactory, PSSysAIWorkerAgent psSysAIWorkerAgent) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSysAIFactory(iPSSysAIFactory);
            this.psSysAIWorkerAgent = psSysAIWorkerAgent;
            this.setId(this.psSysAIWorkerAgent.getPSSYSAIWORKERAGENTID());
            this.setName(this.psSysAIWorkerAgent.getPSSYSAIWORKERAGENTNAME());
            this.setPSObjectData(this.psSysAIWorkerAgent);
            if (this.getPSDataEntity() == null && !StringHelper.isNullOrEmpty((String)this.psSysAIWorkerAgent.getPSDEID())) {
                this.iPSDataEntity = this.getPSSysAIFactory().getPSSystem().getPSDataEntity2(this.psSysAIWorkerAgent.getPSDEID());
            }
            if (StringHelper.compare((String)this.getAgentType(), (String)"DE", (boolean)true) == 0) {
                if (StringHelper.isNullOrEmpty((String)this.psSysAIWorkerAgent.getPSDELOGICID())) {
                    throw new Exception("\u672a\u6307\u5b9a\u5b9e\u4f53\u903b\u8f91");
                }
                if (this.getPSDataEntity() == null) {
                    throw new Exception("\u672a\u6307\u5b9a\u5b9e\u4f53");
                }
                this.iPSDELogic = this.getPSDataEntity().getPSDELogic(this.psSysAIWorkerAgent.getPSDELOGICID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysAIWorkerAgent.getAIWORKERAGENTPARAMS())) {
                this.agentParams = PropertiesHelper.load((String)this.psSysAIWorkerAgent.getAIWORKERAGENTPARAMS());
            }
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
        String strPSSysSFPluginId = this.psSysAIWorkerAgent.getPSSYSSFPLUGINID();
        if (!StringHelper.isNullOrEmpty((String)strPSSysSFPluginId)) {
            this.iPSSysSFPlugin = this.getPSSysAIFactory().getPSSystem().getPSSysSFPlugin(strPSSysSFPluginId);
        }
        if (this.getPSSysSFPlugin() != null) {
            String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSSysAIFactory().getPSSystem().getPSSFId());
            IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSysAIFactory().getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
            if (iPSSysSFPluginTempl != null) {
                this.iPSSFXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
            }
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="AI\u5de5\u4f5c\u8005\u7c7b\u578b", codelist="AIWorkerAgentType", fields={"AIWORKERAGENTTYPE"})
    public String getAgentType() {
        return this.psSysAIWorkerAgent.getAIWORKERAGENTTYPE();
    }

    @Override
    public String getModelType() {
        return "PSSYSAIWORKERAGENT";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psSysAIWorkerAgent.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="AI\u5de5\u4f5c\u8005\u6807\u8bb0", fields={"AIWORKERAGENTTAG"})
    public String getAgentTag() {
        return this.psSysAIWorkerAgent.getAIWORKERAGENTTAG();
    }

    @Override
    @PSModelRTMeta(description="AI\u5de5\u4f5c\u8005\u6807\u8bb02", fields={"AIWORKERAGENTTAG2"})
    public String getAgentTag2() {
        return this.psSysAIWorkerAgent.getAIWORKERAGENTTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7406\u52a8\u6001\u53c2\u6570", ignorepf=true, fields={"AIWORKERAGENTPARAMS"})
    public Properties getAgentParams() {
        return this.agentParams;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5bf9\u8c61", hideempty=true, ignorepf=true, dumpref=true, fields={"PSDEID"})
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u903b\u8f91", hideempty=true, ignorepf=true, dumpref=true, from="IPSDataEntity", fields={"PSDELOGICID"})
    public IPSDELogic getPSDELogic() {
        return this.iPSDELogic;
    }

    @Override
    @PSModelRTMeta(description="AI\u5e73\u53f0\u7c7b\u578b", fields={"AIPLATFORMTYPE"})
    public String getAIPlatformType() {
        return this.psSysAIWorkerAgent.getAIPLATFORMTYPE();
    }
}

