/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.WF;

import SA.SRFDA.PS.Core.App.PSApplicationObjectImpl;
import SA.SRFDA.PS.Core.App.View.IPSAppUIAction;
import SA.SRFDA.PS.Core.App.WF.IPSAppWF;
import SA.SRFDA.PS.Core.App.WF.IPSAppWFUtilUIAction;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.WF.IPSWFUtilUIAction;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSAppWFUtilUIActionImpl
extends PSApplicationObjectImpl
implements IPSAppWFUtilUIAction {
    private static final Log log = LogFactory.getLog(PSAppWFUtilUIActionImpl.class);
    private IPSWFUtilUIAction iPSWFUtilUIAction = null;
    private IPSAppUIAction iPSAppUIAction = null;
    private IPSAppWF iPSAppWF = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppWF iPSAppWF, IPSWFUtilUIAction iPSWFUtilUIAction) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSAppWF = iPSAppWF;
            this.setPSApplication(this.iPSAppWF.getPSApplication());
            this.iPSWFUtilUIAction = iPSWFUtilUIAction;
            this.setId(iPSWFUtilUIAction.getId());
            this.setName(iPSWFUtilUIAction.getName());
            if (!StringHelper.isNullOrEmpty((String)this.getPSDEUIActionId())) {
                this.iPSAppUIAction = this.iPSApplication.getPSAppDEUIAction(this.getPSDEUIActionId(), true);
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
    protected IPSModelObject getProxyPSModelObject() {
        return this.getPSWFUtilUIAction();
    }

    public IPSWFUtilUIAction getPSWFUtilUIAction() {
        return this.iPSWFUtilUIAction;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u7c7b\u578b", codelist="WFUtilUIActionType")
    public String getUtilType() {
        return this.getPSWFUtilUIAction().getUtilType();
    }

    @Override
    public String getPSWorkflowId() {
        return this.getPSWFUtilUIAction().getPSWorkflowId();
    }

    @Override
    public String getPSWFVersionId() {
        return this.getPSWFUtilUIAction().getPSWFVersionId();
    }

    @Override
    public String getPSDEUIActionId() {
        return this.getPSWFUtilUIAction().getPSDEUIActionId();
    }

    @Override
    public IPSWorkflow getPSWorkflow() throws Exception {
        return this.getPSWFUtilUIAction().getPSWorkflow();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u754c\u9762\u884c\u4e3a", child=true)
    public IPSAppUIAction getPSAppUIAction() {
        return this.iPSAppUIAction;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5de5\u4f5c\u6d41")
    public IPSAppWF getPSAppWF() {
        return this.iPSAppWF;
    }

    @Override
    public String getModelType() {
        return "PSAPPWFUTILUIACTION";
    }

    @Override
    public String getModelId() {
        if (this.iPSAppWF != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.iPSAppWF.getModelId(), (Object)this.getUtilType());
        }
        return super.getModelId();
    }

    @Override
    public String getCodeName() {
        return this.getPSWFUtilUIAction().getCodeName();
    }

    @Override
    public String getDynaModelFilePath() {
        return null;
    }
}

