/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppDEWFActionView
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.control.toolbar.IPSDETBUIActionItem
 *  net.ibizsys.model.view.IPSUIActionGroup
 *  net.ibizsys.model.wf.IPSWFInteractiveProcess
 *  net.ibizsys.model.wf.IPSWFProcess
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.dataentity.uiaction;

import net.ibizsys.model.app.view.IPSAppDEWFActionView;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.control.toolbar.IPSDETBUIActionItem;
import net.ibizsys.model.dataentity.uiaction.WFPSDEUIActionImpl;
import net.ibizsys.model.view.IPSUIActionGroup;
import net.ibizsys.model.wf.IPSWFInteractiveProcess;
import net.ibizsys.model.wf.IPSWFProcess;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;

public class WFIAActionPSDEUIActionImpl
extends WFPSDEUIActionImpl {
    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (this.getPSDataEntity() != null && !this.getPSDataEntity().hasPSDEWF()) {
            this.setValid(false);
        }
    }

    @Override
    public boolean isUIActionGroup(Object obj) throws Exception {
        return true;
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

    @Override
    public IPSUIActionGroup getPSUIActionGroup(Object obj) throws Exception {
        IPSDETBUIActionItem iPSDETBUIActionItem;
        IPSAppView iPSAppView;
        if (obj != null && obj instanceof IPSDETBUIActionItem && (iPSAppView = (iPSDETBUIActionItem = (IPSDETBUIActionItem)obj).getPSAppView()) instanceof IPSAppDEWFActionView) {
            IPSAppDEWFActionView iPSAppDEWFIAView = (IPSAppDEWFActionView)iPSAppView;
            String strWFStepValue = iPSAppDEWFIAView.getWFStepValue();
            IPSWFProcess iPSWFProcess = iPSAppDEWFIAView.getPSWFVersion().getPSWFProcessByWFStepValue(strWFStepValue, true);
            if (iPSWFProcess != null) {
                if (!iPSAppDEWFIAView.isMobileView()) {
                    return iPSAppDEWFIAView.getPSWFVersion().getPSWFUIActionGroup(iPSWFProcess.getId());
                }
                return iPSAppDEWFIAView.getPSWFVersion().getPSWFUIActionGroup(KeyValueHelper.genUniqueId((String)"MOB", (String)iPSWFProcess.getId()));
            }
        }
        return super.getPSUIActionGroup(obj);
    }
}

