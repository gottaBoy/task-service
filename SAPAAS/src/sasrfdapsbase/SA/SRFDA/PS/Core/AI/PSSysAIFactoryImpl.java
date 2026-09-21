/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.AI;

import SA.SRFDA.PS.Core.AI.IPSAIChatAgent;
import SA.SRFDA.PS.Core.AI.IPSAIPipelineAgent;
import SA.SRFDA.PS.Core.AI.IPSAIWorkerAgent;
import SA.SRFDA.PS.Core.AI.IPSSysAIChatAgent;
import SA.SRFDA.PS.Core.AI.IPSSysAIFactory;
import SA.SRFDA.PS.Core.AI.IPSSysAIPipelineAgent;
import SA.SRFDA.PS.Core.AI.IPSSysAIWorkerAgent;
import SA.SRFDA.PS.Core.AI.PSSysAIChatAgentImpl;
import SA.SRFDA.PS.Core.AI.PSSysAIPipelineAgentImpl;
import SA.SRFDA.PS.Core.AI.PSSysAIWorkerAgentImpl;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Res.IPSSysResource;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysAIChatAgent;
import SA.SRFDA.PS.Data.PSSysAIFactory;
import SA.SRFDA.PS.Data.PSSysAIPipelineAgent;
import SA.SRFDA.PS.Data.PSSysAIWorkerAgent;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysAIFactoryImpl
extends PSSystemObjectImpl
implements IPSSysAIFactory {
    private static final Log log = LogFactory.getLog(PSSysAIFactoryImpl.class);
    protected PSSysAIFactory psSysAIFactory = null;
    private ArrayList<IPSSysAIChatAgent> psSysAIChatAgentList = new ArrayList();
    private Map<String, IPSSysAIChatAgent> psSysAIChatAgentMap = new LinkedHashMap<String, IPSSysAIChatAgent>();
    private ArrayList<IPSSysAIWorkerAgent> psSysAIWorkerAgentList = new ArrayList();
    private Map<String, IPSSysAIWorkerAgent> psSysAIWorkerAgentMap = new LinkedHashMap<String, IPSSysAIWorkerAgent>();
    private ArrayList<IPSSysAIPipelineAgent> psSysAIPipelineAgentList = new ArrayList();
    private Map<String, IPSSysAIPipelineAgent> psSysAIPipelineAgentMap = new LinkedHashMap<String, IPSSysAIPipelineAgent>();
    private String strCodeName = "";
    private IPSSystemModule iPSSystemModule = null;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSSFXCodeObject iPSSFXCodeObject = null;
    private IPSSysResource iPSSysResource = null;
    private Properties aiFactoryParams = null;
    private String strServicePath = null;
    private String strAuthMode = "NONE";
    private String strAuthClientId = null;
    private String strAuthClientSecret = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysAIFactory psSysAIFactory) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysAIFactory = psSysAIFactory;
            this.setId(this.psSysAIFactory.getPSSYSAIFACTORYID());
            this.setName(this.psSysAIFactory.getPSSYSAIFACTORYNAME());
            this.setPSObjectData(this.psSysAIFactory);
            this.strCodeName = this.psSysAIFactory.getCODENAME();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysAIFactory.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysAIFactory.getPSMODULEID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysAIFactory.getPSSYSRESOURCEID())) {
                this.iPSSysResource = this.getPSSystem().getPSSysResource(this.psSysAIFactory.getPSSYSRESOURCEID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysAIFactory.getAIFACTORYPARAMS())) {
                this.aiFactoryParams = PropertiesHelper.load((String)this.psSysAIFactory.getAIFACTORYPARAMS());
            }
            this.strAuthMode = this.psSysAIFactory.getAUTHMODE();
            this.strAuthClientId = this.psSysAIFactory.getAUTHCLIENTID();
            this.strAuthClientSecret = this.psSysAIFactory.getAUTHCLIENTSECRET();
            this.strServicePath = this.psSysAIFactory.getSERVICEPATH();
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
        String strPSSysSFPluginId = this.psSysAIFactory.getPSSYSSFPLUGINID();
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strPSSysSFPluginId)) {
            this.iPSSysSFPlugin = this.getPSSystem().getPSSysSFPlugin(strPSSysSFPluginId);
        }
        if (this.getPSSysSFPlugin() != null) {
            String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSSystem().getPSSFId());
            IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
            if (iPSSysSFPluginTempl != null) {
                this.iPSSFXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
            }
        }
        this.onPreparePSSysAIWorkerAgents();
        this.onPreparePSSysAIChatAgents();
        this.onPreparePSSysAIPipelineAgents();
        super.onInit();
    }

    protected void onPreparePSSysAIWorkerAgents() throws Exception {
        this.psSysAIWorkerAgentList.clear();
        Vector<PSSysAIWorkerAgent> psSysAIWorkerAgentList = new Vector<PSSysAIWorkerAgent>();
        CallResult callResult = this.getPSModelHelper().getPSSysAIWorkerAgents(this.getId(), psSysAIWorkerAgentList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2AI\u5de5\u4f5c\u8005\u4ee3\u7406\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysAIWorkerAgent psSysAIWorkerAgent : psSysAIWorkerAgentList) {
            PSSysAIWorkerAgentImpl iPSSysAIWorkerAgent = new PSSysAIWorkerAgentImpl();
            iPSSysAIWorkerAgent.init(this.getDAGlobalHelper(), this, psSysAIWorkerAgent);
            this.psSysAIWorkerAgentList.add(iPSSysAIWorkerAgent);
            this.psSysAIWorkerAgentMap.put(iPSSysAIWorkerAgent.getId(), iPSSysAIWorkerAgent);
        }
    }

    protected void onPreparePSSysAIChatAgents() throws Exception {
        this.psSysAIChatAgentList.clear();
        Vector<PSSysAIChatAgent> psSysAIChatAgentList = new Vector<PSSysAIChatAgent>();
        CallResult callResult = this.getPSModelHelper().getPSSysAIChatAgents(this.getId(), psSysAIChatAgentList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2AI\u4ea4\u8c08\u4ee3\u7406\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysAIChatAgent psSysAIChatAgent : psSysAIChatAgentList) {
            PSSysAIChatAgentImpl iPSSysAIChatAgent = new PSSysAIChatAgentImpl();
            iPSSysAIChatAgent.init(this.getDAGlobalHelper(), this, psSysAIChatAgent);
            this.psSysAIChatAgentList.add(iPSSysAIChatAgent);
            this.psSysAIChatAgentMap.put(iPSSysAIChatAgent.getId(), iPSSysAIChatAgent);
        }
    }

    protected void onPreparePSSysAIPipelineAgents() throws Exception {
        this.psSysAIPipelineAgentList.clear();
        Vector<PSSysAIPipelineAgent> psSysAIPipelineAgentList = new Vector<PSSysAIPipelineAgent>();
        CallResult callResult = this.getPSModelHelper().getPSSysAIPipelineAgents(this.getId(), psSysAIPipelineAgentList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2AI\u751f\u4ea7\u7ebf\u4ee3\u7406\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysAIPipelineAgent psSysAIPipelineAgent : psSysAIPipelineAgentList) {
            PSSysAIPipelineAgentImpl iPSSysAIPipelineAgent = new PSSysAIPipelineAgentImpl();
            iPSSysAIPipelineAgent.init(this.getDAGlobalHelper(), this, psSysAIPipelineAgent);
            this.psSysAIPipelineAgentList.add(iPSSysAIPipelineAgent);
            this.psSysAIPipelineAgentMap.put(iPSSysAIPipelineAgent.getId(), iPSSysAIPipelineAgent);
        }
    }

    @Override
    public String getModelType() {
        return "PSSYSAIFACTORY";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", dumpref=true, dynamodelmode=4)
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
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
    @PSModelRTMeta(description="AI\u5de5\u5382\u7c7b\u578b", codelist="AIFactoryType")
    public String getAIFactoryType() {
        return this.psSysAIFactory.getAIFACTORYTYPE();
    }

    @Override
    @PSModelRTMeta(description="AI\u5de5\u4f5c\u8005\u96c6\u5408", child=true)
    public Iterator<? extends IPSSysAIWorkerAgent> getAllPSSysAIWorkerAgents() {
        if (this.psSysAIWorkerAgentList == null || this.psSysAIWorkerAgentList.size() == 0) {
            return null;
        }
        return this.psSysAIWorkerAgentList.iterator();
    }

    @Override
    public Iterator<? extends IPSAIWorkerAgent> getAllPSAIWorkerAgents() {
        return this.getAllPSSysAIWorkerAgents();
    }

    @Override
    public IPSAIWorkerAgent getPSAIWorkerAgent(String strPSAIWorkerAgentId) throws Exception {
        return this.getPSSysAIWorkerAgent(strPSAIWorkerAgentId);
    }

    @Override
    public IPSAIWorkerAgent getPSAIWorkerAgent(String strPSAIWorkerAgentId, boolean bTryMode) throws Exception {
        return this.getPSSysAIWorkerAgent(strPSAIWorkerAgentId, bTryMode);
    }

    @Override
    public IPSSysAIWorkerAgent getPSSysAIWorkerAgent(String strPSSysAIWorkerAgentId) throws Exception {
        return this.getPSSysAIWorkerAgent(strPSSysAIWorkerAgentId, false);
    }

    @Override
    public IPSSysAIWorkerAgent getPSSysAIWorkerAgent(String strPSSysAIWorkerAgentId, boolean bTryMode) throws Exception {
        IPSSysAIWorkerAgent iPSSysAIWorkerAgent = null;
        if (this.psSysAIWorkerAgentMap != null) {
            iPSSysAIWorkerAgent = this.psSysAIWorkerAgentMap.get(strPSSysAIWorkerAgentId);
        }
        if (iPSSysAIWorkerAgent != null || bTryMode) {
            return iPSSysAIWorkerAgent;
        }
        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9aAI\u5de5\u4f5c\u8005\u4ee3\u7406[%1$s]", (Object)strPSSysAIWorkerAgentId));
    }

    @Override
    @PSModelRTMeta(description="AI\u4ea4\u8c08\u4ee3\u7406\u96c6\u5408", child=true)
    public Iterator<? extends IPSSysAIChatAgent> getAllPSSysAIChatAgents() {
        if (this.psSysAIChatAgentList == null || this.psSysAIChatAgentList.size() == 0) {
            return null;
        }
        return this.psSysAIChatAgentList.iterator();
    }

    @Override
    public Iterator<? extends IPSAIChatAgent> getAllPSAIChatAgents() {
        return this.getAllPSSysAIChatAgents();
    }

    @Override
    public IPSAIChatAgent getPSAIChatAgent(String strPSAIChatAgentId) throws Exception {
        return this.getPSSysAIChatAgent(strPSAIChatAgentId);
    }

    @Override
    public IPSAIChatAgent getPSAIChatAgent(String strPSAIChatAgentId, boolean bTryMode) throws Exception {
        return this.getPSSysAIChatAgent(strPSAIChatAgentId, bTryMode);
    }

    @Override
    public IPSSysAIChatAgent getPSSysAIChatAgent(String strPSSysAIChatAgentId) throws Exception {
        return this.getPSSysAIChatAgent(strPSSysAIChatAgentId, false);
    }

    @Override
    public IPSSysAIChatAgent getPSSysAIChatAgent(String strPSSysAIChatAgentId, boolean bTryMode) throws Exception {
        IPSSysAIChatAgent iPSSysAIChatAgent = null;
        if (this.psSysAIChatAgentMap != null) {
            iPSSysAIChatAgent = this.psSysAIChatAgentMap.get(strPSSysAIChatAgentId);
        }
        if (iPSSysAIChatAgent != null || bTryMode) {
            return iPSSysAIChatAgent;
        }
        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9aAI\u4ea4\u8c08\u4ee3\u7406[%1$s]", (Object)strPSSysAIChatAgentId));
    }

    @Override
    @PSModelRTMeta(description="AI\u751f\u4ea7\u7ebf\u4ee3\u7406\u96c6\u5408", child=true)
    public Iterator<? extends IPSSysAIPipelineAgent> getAllPSSysAIPipelineAgents() {
        if (this.psSysAIPipelineAgentList == null || this.psSysAIPipelineAgentList.size() == 0) {
            return null;
        }
        return this.psSysAIPipelineAgentList.iterator();
    }

    @Override
    public Iterator<? extends IPSAIPipelineAgent> getAllPSAIPipelineAgents() {
        return this.getAllPSSysAIPipelineAgents();
    }

    @Override
    public IPSAIPipelineAgent getPSAIPipelineAgent(String strPSAIPipelineAgentId) throws Exception {
        return this.getPSSysAIPipelineAgent(strPSAIPipelineAgentId);
    }

    @Override
    public IPSAIPipelineAgent getPSAIPipelineAgent(String strPSAIPipelineAgentId, boolean bTryMode) throws Exception {
        return this.getPSSysAIPipelineAgent(strPSAIPipelineAgentId, bTryMode);
    }

    @Override
    public IPSSysAIPipelineAgent getPSSysAIPipelineAgent(String strPSSysAIPipelineAgentId) throws Exception {
        return this.getPSSysAIPipelineAgent(strPSSysAIPipelineAgentId, false);
    }

    @Override
    public IPSSysAIPipelineAgent getPSSysAIPipelineAgent(String strPSSysAIPipelineAgentId, boolean bTryMode) throws Exception {
        IPSSysAIPipelineAgent iPSSysAIPipelineAgent = null;
        if (this.psSysAIPipelineAgentMap != null) {
            iPSSysAIPipelineAgent = this.psSysAIPipelineAgentMap.get(strPSSysAIPipelineAgentId);
        }
        if (iPSSysAIPipelineAgent != null || bTryMode) {
            return iPSSysAIPipelineAgent;
        }
        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9aAI\u751f\u4ea7\u7ebf\u4ee3\u7406[%1$s]", (Object)strPSSysAIPipelineAgentId));
    }

    @Override
    @PSModelRTMeta(description="\u4f53\u7cfb\u6807\u8bb0", hideempty2=true)
    public String getAIFactoryTag() {
        return this.psSysAIFactory.getAIFACTORYTAG();
    }

    @Override
    @PSModelRTMeta(description="\u4f53\u7cfb\u6807\u8bb02", hideempty2=true)
    public String getAIFactoryTag2() {
        return this.psSysAIFactory.getAIFACTORYTAG2();
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

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u8def\u5f84", fields={"SERVICEPATH"})
    public String getServicePath() {
        return this.strServicePath;
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u53c2\u6570", fields={"SERVICEPARAM"})
    public String getServiceParam() {
        return this.psSysAIFactory.getSERVICEPARAM();
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u53c2\u65702", fields={"SERVICEPARAM2"})
    public String getServiceParam2() {
        return this.psSysAIFactory.getSERVICEPARAM2();
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u6a21\u5f0f", codelist="APIAuthMode", fields={"AUTHMODE"})
    public String getAuthMode() {
        return this.strAuthMode;
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u5ba2\u6237\u7aef\u6807\u8bc6", fields={"AUTHCLIENTID"})
    public String getAuthClientId() {
        return this.strAuthClientId;
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u5ba2\u6237\u7aef\u5bc6\u7801", fields={"AUTHCLIENTSECRET"})
    public String getAuthClientSecret() {
        return this.strAuthClientSecret;
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u53c2\u6570", fields={"AUTHPARAM"})
    public String getAuthParam() {
        return this.psSysAIFactory.getAUTHPARAM();
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u53c2\u65702", fields={"AUTHPARAM2"})
    public String getAuthParam2() {
        return this.psSysAIFactory.getAUTHPARAM2();
    }

    @Override
    public String getAuthAccessTokenUrl() {
        return null;
    }

    @Override
    public int getAuthTimeout() {
        return 0;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u8d44\u6e90\u5bf9\u8c61", dumpref=true, fields={"PSSYSRESOURCEID"})
    public IPSSysResource getPSSysResource() {
        return this.iPSSysResource;
    }

    @Override
    @PSModelRTMeta(description="AI\u5de5\u5382\u52a8\u6001\u53c2\u6570", ignorepf=true, fields={"AIFACTORYPARAMS"})
    public Properties getAIFactoryParams() {
        return this.aiFactoryParams;
    }

    @Override
    @PSModelRTMeta(description="AI\u5e73\u53f0\u7c7b\u578b", fields={"AIPLATFORMTYPE"})
    public String getAIPlatformType() {
        return this.psSysAIFactory.getAIPLATFORMTYPE();
    }
}

