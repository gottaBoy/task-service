/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.AI;

import SA.SRFDA.PS.Core.AI.IPSAIPipelineJob;
import SA.SRFDA.PS.Core.AI.IPSAIPipelineWorker;
import SA.SRFDA.PS.Core.AI.IPSSysAIFactory;
import SA.SRFDA.PS.Core.AI.IPSSysAIPipelineAgent;
import SA.SRFDA.PS.Core.AI.IPSSysAIPipelineJob;
import SA.SRFDA.PS.Core.AI.IPSSysAIPipelineWorker;
import SA.SRFDA.PS.Core.AI.PSSysAIFactoryObjectImpl;
import SA.SRFDA.PS.Core.AI.PSSysAIPipelineJobImpl;
import SA.SRFDA.PS.Core.AI.PSSysAIPipelineWorkerImpl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Data.PSSysAIPipelineAgent;
import SA.SRFDA.PS.Data.PSSysAIPipelineJob;
import SA.SRFDA.PS.Data.PSSysAIPipelineWorker;
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

public class PSSysAIPipelineAgentImpl
extends PSSysAIFactoryObjectImpl
implements IPSSysAIPipelineAgent {
    private static final Log log = LogFactory.getLog(PSSysAIPipelineAgentImpl.class);
    protected PSSysAIPipelineAgent psSysAIPipelineAgent = null;
    private ArrayList<IPSSysAIPipelineJob> psSysAIPipelineJobList = new ArrayList();
    private Map<String, IPSSysAIPipelineJob> psSysAIPipelineJobMap = new LinkedHashMap<String, IPSSysAIPipelineJob>();
    private ArrayList<IPSSysAIPipelineWorker> psSysAIPipelineWorkerList = new ArrayList();
    private Map<String, IPSSysAIPipelineWorker> psSysAIPipelineWorkerMap = new LinkedHashMap<String, IPSSysAIPipelineWorker>();
    private IPSDataEntity iPSDataEntity = null;
    private Properties agentParams = null;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSSFXCodeObject iPSSFXCodeObject = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysAIFactory iPSSysAIFactory, PSSysAIPipelineAgent psSysAIPipelineAgent) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSysAIFactory(iPSSysAIFactory);
            this.psSysAIPipelineAgent = psSysAIPipelineAgent;
            this.setId(this.psSysAIPipelineAgent.getPSSYSAIPIPELINEAGENTID());
            this.setName(this.psSysAIPipelineAgent.getPSSYSAIPIPELINEAGENTNAME());
            this.setPSObjectData(this.psSysAIPipelineAgent);
            if (this.getPSDataEntity() == null && !StringHelper.isNullOrEmpty((String)this.psSysAIPipelineAgent.getPSDEID())) {
                this.iPSDataEntity = this.getPSSysAIFactory().getPSSystem().getPSDataEntity2(this.psSysAIPipelineAgent.getPSDEID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysAIPipelineAgent.getAIPIPELINEAGENTPARAMS())) {
                this.agentParams = PropertiesHelper.load((String)this.psSysAIPipelineAgent.getAIPIPELINEAGENTPARAMS());
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
        String strPSSysSFPluginId = this.psSysAIPipelineAgent.getPSSYSSFPLUGINID();
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
        this.onPreparePSSysAIPipelineJobs();
        this.onPreparePSSysAIPipelineWorkers();
        super.onInit();
    }

    protected void onPreparePSSysAIPipelineJobs() throws Exception {
        this.psSysAIPipelineJobList.clear();
        Vector<PSSysAIPipelineJob> psSysAIPipelineJobList = new Vector<PSSysAIPipelineJob>();
        CallResult callResult = this.getPSModelHelper().getPSSysAIPipelineJobs(this.getId(), psSysAIPipelineJobList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2AI\u751f\u4ea7\u7ebf\u4f5c\u4e1a\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysAIPipelineJob psSysAIPipelineJob : psSysAIPipelineJobList) {
            PSSysAIPipelineJobImpl iPSSysAIPipelineJob = new PSSysAIPipelineJobImpl();
            iPSSysAIPipelineJob.init(this.getDAGlobalHelper(), this, psSysAIPipelineJob);
            this.psSysAIPipelineJobList.add(iPSSysAIPipelineJob);
            this.psSysAIPipelineJobMap.put(iPSSysAIPipelineJob.getId(), iPSSysAIPipelineJob);
        }
    }

    protected void onPreparePSSysAIPipelineWorkers() throws Exception {
        this.psSysAIPipelineWorkerList.clear();
        Vector<PSSysAIPipelineWorker> psSysAIPipelineWorkerList = new Vector<PSSysAIPipelineWorker>();
        CallResult callResult = this.getPSModelHelper().getPSSysAIPipelineWorkers(this.getId(), psSysAIPipelineWorkerList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2AI\u751f\u4ea7\u7ebf\u5de5\u4f5c\u8005\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysAIPipelineWorker psSysAIPipelineWorker : psSysAIPipelineWorkerList) {
            PSSysAIPipelineWorkerImpl iPSSysAIPipelineWorker = new PSSysAIPipelineWorkerImpl();
            iPSSysAIPipelineWorker.init(this.getDAGlobalHelper(), this, psSysAIPipelineWorker);
            this.psSysAIPipelineWorkerList.add(iPSSysAIPipelineWorker);
            this.psSysAIPipelineWorkerMap.put(iPSSysAIPipelineWorker.getId(), iPSSysAIPipelineWorker);
        }
    }

    @Override
    public String getModelType() {
        return "PSSYSAIPIPELINEAGENT";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6", fields={"CODENAME"})
    public String getCodeName() {
        return this.psSysAIPipelineAgent.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="AI\u751f\u4ea7\u7ebf\u4f5c\u4e1a\u96c6\u5408", child=true)
    public Iterator<? extends IPSSysAIPipelineJob> getAllPSSysAIPipelineJobs() throws Exception {
        if (this.psSysAIPipelineJobList == null || this.psSysAIPipelineJobList.size() == 0) {
            return null;
        }
        return this.psSysAIPipelineJobList.iterator();
    }

    @Override
    public IPSSysAIPipelineJob getPSSysAIPipelineJob(String strPSSysAIPipelineJobId) throws Exception {
        return this.getPSSysAIPipelineJob(strPSSysAIPipelineJobId, false);
    }

    @Override
    public IPSAIPipelineJob getPSAIPipelineJob(String strPSAIPipelineJobId, boolean bTryMode) throws Exception {
        return this.getPSSysAIPipelineJob(strPSAIPipelineJobId, bTryMode);
    }

    @Override
    public IPSSysAIPipelineJob getPSSysAIPipelineJob(String strPSSysAIPipelineJobId, boolean bTryMode) throws Exception {
        IPSSysAIPipelineJob iPSSysAIPipelineJob = null;
        if (this.psSysAIPipelineJobMap != null) {
            iPSSysAIPipelineJob = this.psSysAIPipelineJobMap.get(strPSSysAIPipelineJobId);
        }
        if (iPSSysAIPipelineJob != null || bTryMode) {
            return iPSSysAIPipelineJob;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9aAI\u751f\u4ea7\u7ebf\u4f5c\u4e1a[%1$s]", (Object)strPSSysAIPipelineJobId));
    }

    @Override
    public Iterator<? extends IPSAIPipelineJob> getAllPSAIPipelineJobs() throws Exception {
        return this.getAllPSSysAIPipelineJobs();
    }

    @Override
    public IPSAIPipelineJob getPSAIPipelineJob(String strPSAIPipelineJobId) throws Exception {
        return this.getPSSysAIPipelineJob(strPSAIPipelineJobId);
    }

    @Override
    @PSModelRTMeta(description="\u7acb\u65b9\u4f53\u6307\u6807\u96c6\u5408", child=true)
    public Iterator<? extends IPSSysAIPipelineWorker> getAllPSSysAIPipelineWorkers() throws Exception {
        if (this.psSysAIPipelineWorkerList == null || this.psSysAIPipelineWorkerList.size() == 0) {
            return null;
        }
        return this.psSysAIPipelineWorkerList.iterator();
    }

    @Override
    public IPSSysAIPipelineWorker getPSSysAIPipelineWorker(String strPSSysAIPipelineWorkerId) throws Exception {
        return this.getPSSysAIPipelineWorker(strPSSysAIPipelineWorkerId, false);
    }

    @Override
    public IPSAIPipelineWorker getPSAIPipelineWorker(String strPSAIPipelineWorkerId, boolean bTryMode) throws Exception {
        return this.getPSSysAIPipelineWorker(strPSAIPipelineWorkerId, bTryMode);
    }

    @Override
    public IPSSysAIPipelineWorker getPSSysAIPipelineWorker(String strPSSysAIPipelineWorkerId, boolean bTryMode) throws Exception {
        IPSSysAIPipelineWorker iPSSysAIPipelineWorker = null;
        if (this.psSysAIPipelineWorkerMap != null) {
            iPSSysAIPipelineWorker = this.psSysAIPipelineWorkerMap.get(strPSSysAIPipelineWorkerId);
        }
        if (iPSSysAIPipelineWorker != null || bTryMode) {
            return iPSSysAIPipelineWorker;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7acb\u65b9\u4f53\u6307\u6807[%1$s]", (Object)strPSSysAIPipelineWorkerId));
    }

    @Override
    public Iterator<? extends IPSAIPipelineWorker> getAllPSAIPipelineWorkers() throws Exception {
        return this.getAllPSSysAIPipelineWorkers();
    }

    @Override
    public IPSAIPipelineWorker getPSAIPipelineWorker(String strPSAIPipelineWorkerId) throws Exception {
        return this.getPSSysAIPipelineWorker(strPSAIPipelineWorkerId);
    }

    @Override
    @PSModelRTMeta(description="AI\u751f\u4ea7\u7ebf\u6807\u8bb0", fields={"AIPIPELINEAGENTTAG"})
    public String getAgentTag() {
        return this.psSysAIPipelineAgent.getAIPIPELINEAGENTTAG();
    }

    @Override
    @PSModelRTMeta(description="AI\u751f\u4ea7\u7ebf\u6807\u8bb02", fields={"AIPIPELINEAGENTTAG2"})
    public String getAgentTag2() {
        return this.psSysAIPipelineAgent.getAIPIPELINEAGENTTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7406\u52a8\u6001\u53c2\u6570", ignorepf=true, fields={"AIPIPELINEAGENTPARAMS"})
    public Properties getAgentParams() {
        return this.agentParams;
    }

    @Override
    @PSModelRTMeta(description="AI\u5de5\u4f5c\u8005\u7c7b\u578b", codelist="AIPipelineAgentType", fields={"AIPIPELINEAGENTTYPE"})
    public String getAgentType() {
        return this.psSysAIPipelineAgent.getAIPIPELINEAGENTTYPE();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5bf9\u8c61", hideempty=true, ignorepf=true, dumpref=true, fields={"PSDEID"})
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="AI\u5e73\u53f0\u7c7b\u578b", fields={"AIPLATFORMTYPE"})
    public String getAIPlatformType() {
        return this.psSysAIPipelineAgent.getAIPLATFORMTYPE();
    }
}

