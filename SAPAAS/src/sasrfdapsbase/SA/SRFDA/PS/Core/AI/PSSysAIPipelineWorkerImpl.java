/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.AI;

import SA.SRFDA.PS.Core.AI.IPSAIWorkerAgent;
import SA.SRFDA.PS.Core.AI.IPSSysAIPipelineAgent;
import SA.SRFDA.PS.Core.AI.IPSSysAIPipelineWorker;
import SA.SRFDA.PS.Core.AI.IPSSysAIWorkerAgent;
import SA.SRFDA.PS.Core.AI.PSSysAIPipelineObjectImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSSysAIPipelineWorker;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysAIPipelineWorkerImpl
extends PSSysAIPipelineObjectImpl
implements IPSSysAIPipelineWorker {
    private static final Log log = LogFactory.getLog(PSSysAIPipelineWorkerImpl.class);
    protected PSSysAIPipelineWorker psSysAIPipelineWorker = null;
    private IPSSysAIWorkerAgent iPSSysAIWorkerAgent = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysAIPipelineAgent iPSSysAIPipelineAgent, PSSysAIPipelineWorker psSysAIPipelineWorker) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSysAIPipelineAgent(iPSSysAIPipelineAgent);
            this.psSysAIPipelineWorker = psSysAIPipelineWorker;
            this.setId(this.psSysAIPipelineWorker.getPSSYSAIPIPELINEWORKERID());
            this.setName(this.psSysAIPipelineWorker.getPSSYSAIPIPELINEWORKERNAME());
            this.setPSObjectData(this.psSysAIPipelineWorker);
            if (this.getPSSysAIWorkerAgent() == null && !StringHelper.isNullOrEmpty((String)this.psSysAIPipelineWorker.getPSSYSAIWORKERAGENTID())) {
                this.iPSSysAIWorkerAgent = this.getPSSysAIFactory().getPSSysAIWorkerAgent(this.psSysAIPipelineWorker.getPSSYSAIWORKERAGENTID());
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
        super.onInit();
    }

    @Override
    public String getModelType() {
        return "PSSYSAIPIPELINEWORKER";
    }

    @Override
    public IPSAIWorkerAgent getPSAIWorkerAgent() {
        return this.getPSSysAIWorkerAgent();
    }

    @Override
    @PSModelRTMeta(description="AI\u5de5\u4f5c\u8005\u4ee3\u7406", hideempty=true, dumpref=true, from="IPSSysAIFactory", fields={"PSSYSAIWORKERAGENTID"})
    public IPSSysAIWorkerAgent getPSSysAIWorkerAgent() {
        return this.iPSSysAIWorkerAgent;
    }
}

