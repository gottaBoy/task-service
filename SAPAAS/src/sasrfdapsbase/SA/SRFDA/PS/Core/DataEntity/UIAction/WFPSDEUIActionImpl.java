/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.UIAction;

import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.WF.IPSAppWF;
import SA.SRFDA.PS.Core.App.WF.IPSAppWFUIAction;
import SA.SRFDA.PS.Core.App.WF.IPSAppWFVer;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDETBUIActionItem;
import SA.SRFDA.PS.Core.DataEntity.UIAction.PSDEUIActionImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.WF.IPSWFLink;
import SA.SRFDA.PS.Core.WF.IPSWFProcess;
import SA.SRFDA.PS.Core.WF.IPSWFVersion;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;
import SA.SRFDA.PS.Data.PSDEUIAction;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;

public class WFPSDEUIActionImpl
extends PSDEUIActionImpl
implements IPSAppWFUIAction {
    private IPSAppWF iPSAppWF = null;
    private IPSAppWFVer iPSAppWFVer = null;
    private IPSWorkflow iPSWorkflow = null;
    private IPSWFVersion iPSWFVersion = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppWF iPSAppWF, IPSAppWFVer iPSAppWFVer, PSDEUIAction psDEUIAction) throws Exception {
        this.iPSAppWF = iPSAppWF;
        this.iPSAppWFVer = iPSAppWFVer;
        if (this.getPSAppWFVer() != null) {
            this.init(iDAGlobalHelper, this.getPSAppWF().getPSWorkflow(), this.getPSAppWFVer().getPSWFVersion(), psDEUIAction);
        } else {
            this.init(iDAGlobalHelper, this.getPSAppWF().getPSWorkflow(), null, psDEUIAction);
        }
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSWorkflow iPSWorkflow, IPSWFVersion iPSWFVersion, PSDEUIAction psDEUIAction) throws Exception {
        this.iPSWFVersion = iPSWFVersion;
        this.iPSWorkflow = iPSWorkflow;
        if (this.iPSWorkflow == null && this.iPSWFVersion != null) {
            this.iPSWorkflow = iPSWFVersion.getPSWorkflow();
        }
        this.init(iDAGlobalHelper, this.iPSWorkflow.getPSSystem(), null, psDEUIAction);
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (this.getPSDataEntity() != null && !this.getPSDataEntity().hasPSDEWF()) {
            this.setValid(false);
        }
    }

    @Override
    public boolean isValid(Object obj) throws Exception {
        IPSDETBUIActionItem iPSDETBUIActionItem;
        IPSAppView iPSAppView;
        if (obj != null && obj instanceof IPSDETBUIActionItem && (iPSAppView = (iPSDETBUIActionItem = (IPSDETBUIActionItem)obj).getPSAppView()) instanceof IPSAppDEView) {
            return ((IPSAppDEView)iPSAppView).isEnableWF();
        }
        return super.isValid(obj);
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u5de5\u4f5c\u6d41", hideempty=true)
    public IPSWorkflow getPSWorkflow() {
        return this.iPSWorkflow;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u5de5\u4f5c\u6d41\u7248\u672c", hideempty=true)
    public IPSWFVersion getPSWFVersion() {
        return this.iPSWFVersion;
    }

    @Override
    public IPSWFProcess getPSWFProcess() {
        return null;
    }

    @Override
    public IPSWFLink getPSWFLink() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5de5\u4f5c\u6d41", hideempty=true)
    public IPSAppWF getPSAppWF() {
        return this.iPSAppWF;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5de5\u4f5c\u6d41\u7248\u672c", hideempty=true)
    public IPSAppWFVer getPSAppWFVer() {
        return this.iPSAppWFVer;
    }

    @Override
    public String getModelType() {
        if (this.getPSAppWFVer() != null) {
            return "PSAPPWFVERUIACTION";
        }
        if (this.getPSAppWF() != null) {
            return "PSAPPWFUIACTION";
        }
        return super.getModelType();
    }

    @Override
    public String getModelId() {
        if (this.getPSAppWFVer() != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSAppWFVer().getModelId(), (Object)super.getModelId());
        }
        if (this.getPSAppWF() != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSAppWF().getModelId(), (Object)super.getModelId());
        }
        return super.getModelId();
    }
}

