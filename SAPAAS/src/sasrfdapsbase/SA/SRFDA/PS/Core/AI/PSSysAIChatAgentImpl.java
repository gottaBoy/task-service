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

import SA.SRFDA.PS.Core.AI.IPSSysAIChatAgent;
import SA.SRFDA.PS.Core.AI.IPSSysAIFactory;
import SA.SRFDA.PS.Core.AI.PSSysAIFactoryObjectImpl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Data.PSSysAIChatAgent;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysAIChatAgentImpl
extends PSSysAIFactoryObjectImpl
implements IPSSysAIChatAgent {
    private static final Log log = LogFactory.getLog(PSSysAIChatAgentImpl.class);
    protected PSSysAIChatAgent psSysAIChatAgent = null;
    private Properties agentParams = null;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSSFXCodeObject iPSSFXCodeObject = null;
    private IPSDataEntity iPSDataEntity = null;
    private IPSDELogic iPSDELogic = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysAIFactory iPSSysAIFactory, PSSysAIChatAgent psSysAIChatAgent) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSysAIFactory(iPSSysAIFactory);
            this.psSysAIChatAgent = psSysAIChatAgent;
            this.setId(this.psSysAIChatAgent.getPSSYSAICHATAGENTID());
            this.setName(this.psSysAIChatAgent.getPSSYSAICHATAGENTNAME());
            this.setPSObjectData(this.psSysAIChatAgent);
            if (this.getPSDataEntity() == null && !StringHelper.isNullOrEmpty((String)this.psSysAIChatAgent.getPSDEID())) {
                this.iPSDataEntity = this.getPSSysAIFactory().getPSSystem().getPSDataEntity2(this.psSysAIChatAgent.getPSDEID());
            }
            if (StringHelper.compare((String)this.getAgentType(), (String)"DE", (boolean)true) == 0) {
                if (StringHelper.isNullOrEmpty((String)this.psSysAIChatAgent.getPSDELOGICID())) {
                    throw new Exception("\u672a\u6307\u5b9a\u5b9e\u4f53\u903b\u8f91");
                }
                if (this.getPSDataEntity() == null) {
                    throw new Exception("\u672a\u6307\u5b9a\u5b9e\u4f53");
                }
                this.iPSDELogic = this.getPSDataEntity().getPSDELogic(this.psSysAIChatAgent.getPSDELOGICID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysAIChatAgent.getAICHATAGENTPARAMS())) {
                this.agentParams = PropertiesHelper.load((String)this.psSysAIChatAgent.getAICHATAGENTPARAMS());
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
        String strPSSysSFPluginId = this.psSysAIChatAgent.getPSSYSSFPLUGINID();
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
    @PSModelRTMeta(description="AI\u4ea4\u8c08\u7c7b\u578b", codelist="AIChatAgentType", fields={"AICHATAGENTTYPE"})
    public String getAgentType() {
        return this.psSysAIChatAgent.getAICHATAGENTTYPE();
    }

    @Override
    public String getModelType() {
        return "PSSYSAICHATAGENT";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psSysAIChatAgent.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="AI\u4ea4\u8c08\u6807\u8bb0", fields={"AICHATAGENTTAG"})
    public String getAgentTag() {
        return this.psSysAIChatAgent.getAICHATAGENTTAG();
    }

    @Override
    @PSModelRTMeta(description="AI\u4ea4\u8c08\u6807\u8bb02", fields={"AICHATAGENTTAG2"})
    public String getAgentTag2() {
        return this.psSysAIChatAgent.getAICHATAGENTTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7406\u52a8\u6001\u53c2\u6570", ignorepf=true, fields={"AICHATAGENTPARAMS"})
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
        return this.psSysAIChatAgent.getAIPLATFORMTYPE();
    }
}

