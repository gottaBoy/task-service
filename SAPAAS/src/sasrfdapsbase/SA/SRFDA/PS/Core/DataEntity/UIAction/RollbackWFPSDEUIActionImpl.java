/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.UIAction;

import SA.SRFDA.PS.Core.App.View.IPSAppDEWFActionView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDETBUIActionItem;
import SA.SRFDA.PS.Core.DataEntity.UIAction.WFPSDEUIActionImpl;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.WF.IPSWFInteractiveProcess;
import SA.SRFDA.PS.Core.WF.IPSWFLink;
import SA.SRFDA.PS.Core.WF.IPSWFProcess;
import SA.SRFDA.PS.Core.WF.IPSWFVersion;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;
import SA.SRFDA.PS.Core.WF.UIAction.IPSWFUIAction;
import SA.SRFDA.PS.Data.PSDEUIAction;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;

@PSModelPFIgnoreMeta
public class RollbackWFPSDEUIActionImpl
extends WFPSDEUIActionImpl
implements IPSWFUIAction {
    private IPSWFVersion iPSWFVersion = null;
    private IPSWorkflow iPSWorkflow = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (this.iPSWFVersion != null) {
            this.setValid(true);
        }
    }

    @Override
    public boolean isValid(Object obj) throws Exception {
        if (obj != null && obj instanceof IPSDETBUIActionItem) {
            IPSDETBUIActionItem iPSDETBUIActionItem = (IPSDETBUIActionItem)obj;
            IPSAppView iPSAppView = iPSDETBUIActionItem.getPSAppView();
            if (iPSAppView instanceof IPSAppDEWFActionView) {
                IPSAppDEWFActionView iPSAppDEWFIAView = (IPSAppDEWFActionView)iPSAppView;
                String strWFStepValue = iPSAppDEWFIAView.getWFStepValue();
                if (StringHelper.IsNullOrEmpty((String)strWFStepValue)) {
                    return false;
                }
                IPSWFProcess iPSWFProcess = iPSAppDEWFIAView.getPSWFVersion().getPSWFProcessByWFStepValue(strWFStepValue, true);
                return iPSWFProcess != null && iPSWFProcess instanceof IPSWFInteractiveProcess;
            }
            return false;
        }
        return super.isValid(obj);
    }

    @Override
    public IPSWorkflow getPSWorkflow() {
        if (this.iPSWorkflow != null) {
            return this.iPSWorkflow;
        }
        if (this.iPSWFVersion == null) {
            return null;
        }
        return this.iPSWFVersion.getPSWorkflow();
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSWorkflow iPSWorkflow, IPSWFVersion iPSWFVersion, PSDEUIAction psDEUIAction) throws Exception {
        this.iPSWFVersion = iPSWFVersion;
        this.iPSWorkflow = iPSWorkflow;
        this.init(iDAGlobalHelper, iPSWFVersion.getPSWorkflow().getPSSystem(), null, psDEUIAction);
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41\u7248\u672c\u5bf9\u8c61")
    public IPSWFVersion getPSWFVersion() {
        return this.iPSWFVersion;
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u5904\u7406\u5bf9\u8c61")
    public IPSWFProcess getPSWFProcess() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u8fde\u63a5\u5bf9\u8c61")
    public IPSWFLink getPSWFLink() {
        return null;
    }
}

