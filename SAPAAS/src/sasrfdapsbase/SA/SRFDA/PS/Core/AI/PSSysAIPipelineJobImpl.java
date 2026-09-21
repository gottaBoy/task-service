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

import SA.SRFDA.PS.Core.AI.IPSSysAIPipelineAgent;
import SA.SRFDA.PS.Core.AI.IPSSysAIPipelineJob;
import SA.SRFDA.PS.Core.AI.PSSysAIPipelineObjectImpl;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSSysAIPipelineJob;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysAIPipelineJobImpl
extends PSSysAIPipelineObjectImpl
implements IPSSysAIPipelineJob {
    private static final Log log = LogFactory.getLog(PSSysAIPipelineJobImpl.class);
    protected PSSysAIPipelineJob psSysAIPipelineJob = null;
    private IPSCodeList stepPSCodeList = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysAIPipelineAgent iPSSysAIPipelineAgent, PSSysAIPipelineJob psSysAIPipelineJob) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSysAIPipelineAgent(iPSSysAIPipelineAgent);
            this.psSysAIPipelineJob = psSysAIPipelineJob;
            this.setId(this.psSysAIPipelineJob.getPSSYSAIPIPELINEJOBID());
            this.setName(this.psSysAIPipelineJob.getPSSYSAIPIPELINEJOBNAME());
            this.setPSObjectData(this.psSysAIPipelineJob);
            if (!StringHelper.isNullOrEmpty((String)this.psSysAIPipelineJob.getSTEPPSCODELISTID())) {
                this.stepPSCodeList = this.getPSSysAIPipelineAgent().getPSSysAIFactory().getPSSystem().getPSCodeList(this.psSysAIPipelineJob.getSTEPPSCODELISTID());
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
        return "PSSYSAIPIPELINEJOB";
    }

    @Override
    @PSModelRTMeta(description="\u6b65\u9aa4\u4ee3\u7801\u8868\u5bf9\u8c61", hideempty=true, dumpref=true, fields={"STEPPSCODELISTID"})
    public IPSCodeList getStepPSCodeList() {
        return this.stepPSCodeList;
    }
}

