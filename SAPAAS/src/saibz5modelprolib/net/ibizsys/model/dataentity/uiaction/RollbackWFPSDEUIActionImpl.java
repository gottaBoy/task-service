/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppDEWFActionView
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.control.toolbar.IPSDETBUIActionItem
 *  net.ibizsys.model.wf.IPSWFInteractiveProcess
 *  net.ibizsys.model.wf.IPSWFProcess
 *  net.ibizsys.model.wf.IPSWFVersion
 *  net.ibizsys.model.wf.IPSWorkflow
 *  net.ibizsys.model.wf.uiaction.IPSWFUIAction
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.dataentity.uiaction;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.app.view.IPSAppDEWFActionView;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.control.toolbar.IPSDETBUIActionItem;
import net.ibizsys.model.dataentity.uiaction.WFPSDEUIActionImpl;
import net.ibizsys.model.entity.PSDEUIAction;
import net.ibizsys.model.wf.IPSWFInteractiveProcess;
import net.ibizsys.model.wf.IPSWFProcess;
import net.ibizsys.model.wf.IPSWFVersion;
import net.ibizsys.model.wf.IPSWorkflow;
import net.ibizsys.model.wf.uiaction.IPSWFUIAction;
import net.ibizsys.model.wf.uiaction.IPSWFUIActionRuntime;
import net.ibizsys.paas.util.StringHelper;

public class RollbackWFPSDEUIActionImpl
extends WFPSDEUIActionImpl
implements IPSWFUIAction,
IPSWFUIActionRuntime {
    private IPSWFVersion iPSWFVersion = null;

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
                if (StringHelper.isNullOrEmpty((String)strWFStepValue)) {
                    return false;
                }
                IPSWFProcess iPSWFProcess = iPSAppDEWFIAView.getPSWFVersion().getPSWFProcessByWFStepValue(strWFStepValue, true);
                return iPSWFProcess != null && iPSWFProcess instanceof IPSWFInteractiveProcess;
            }
            return false;
        }
        return super.isValid(obj);
    }

    public IPSWorkflow getPSWorkflow() {
        if (this.iPSWFVersion == null) {
            return null;
        }
        return this.iPSWFVersion.getPSWorkflow();
    }

    @Override
    public void init(IPSModelStorageContext iIPSModelStorageContext, IPSWFVersion iPSWFVersion, PSDEUIAction psDEUIAction) throws Exception {
        this.iPSWFVersion = iPSWFVersion;
        this.init(iIPSModelStorageContext, iPSWFVersion.getPSWorkflow().getPSSystem(), null, psDEUIAction);
    }

    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41\u7248\u672c\u5bf9\u8c61")
    public IPSWFVersion getPSWFVersion() {
        return this.iPSWFVersion;
    }
}

