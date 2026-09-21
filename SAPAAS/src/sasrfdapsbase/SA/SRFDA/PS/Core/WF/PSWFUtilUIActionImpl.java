/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.WF.IPSSysWFSetting;
import SA.SRFDA.PS.Core.WF.IPSWFUtilUIAction;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;
import SA.SRFDA.PS.Data.PSWFUtilUIAction;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSWFUtilUIActionImpl
extends PSObjectImpl
implements IPSWFUtilUIAction {
    private static final Log log = LogFactory.getLog(PSWFUtilUIActionImpl.class);
    protected PSWFUtilUIAction psWFUtilUIAction;
    private IPSSysWFSetting iPSSysWFSetting = null;
    private IPSWorkflow iPSWorkflow = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysWFSetting iPSSysWFSetting, PSWFUtilUIAction psWFUtilUIAction) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSysWFSetting(iPSSysWFSetting);
            this.psWFUtilUIAction = psWFUtilUIAction;
            this.setId(this.psWFUtilUIAction.getPSWFUTILUIACTIONID());
            this.setName(this.psWFUtilUIAction.getPSWFUTILUIACTIONNAME());
            this.setPSObjectData(this.psWFUtilUIAction);
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

    protected void setPSSysWFSetting(IPSSysWFSetting iPSSysWFSetting) {
        this.iPSSysWFSetting = iPSSysWFSetting;
    }

    public IPSSysWFSetting getPSSysWFSetting() {
        return this.iPSSysWFSetting;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysWFSetting().getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSWFUTILUIACTION";
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSysWFSetting().getPSSystem());
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u7c7b\u578b", codelist="WFUtilUIActionType", fields={"UTILTYPE"})
    public String getUtilType() {
        return this.psWFUtilUIAction.getUTILTYPE();
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41\u6807\u8bc6")
    public String getPSWorkflowId() {
        return this.psWFUtilUIAction.getPSWORKFLOWID();
    }

    @Override
    public String getPSWFVersionId() {
        return this.psWFUtilUIAction.getPSWFVERSIONID();
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u6807\u8bc6")
    public String getPSDEUIActionId() {
        return this.psWFUtilUIAction.getPSDEUIACTIONID();
    }

    @Override
    public IPSWorkflow getPSWorkflow() throws Exception {
        if (this.iPSWorkflow != null) {
            return this.iPSWorkflow;
        }
        if (!StringHelper.isNullOrEmpty((String)this.getPSWorkflowId())) {
            this.iPSWorkflow = this.getPSSysWFSetting().getPSSystem().getPSWorkflow(this.getPSWorkflowId());
        }
        return this.iPSWorkflow;
    }

    @Override
    public String getCodeName() {
        return this.getUtilType();
    }
}

