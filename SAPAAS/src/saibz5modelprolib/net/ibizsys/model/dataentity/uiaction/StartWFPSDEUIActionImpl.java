/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppDEView
 *  net.ibizsys.model.app.view.IPSAppDEWFActionView
 *  net.ibizsys.model.app.view.IPSAppDEWFView
 *  net.ibizsys.model.app.view.IPSAppDEXDataView
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.control.toolbar.IPSDETBUIActionItem
 *  net.ibizsys.model.view.IPSUIAction
 *  net.ibizsys.model.view.IPSUIActionGroup
 *  net.ibizsys.model.wf.IPSWFProcess
 *  net.ibizsys.model.wf.IPSWFVersion
 *  net.ibizsys.model.wf.IPSWorkflow
 *  net.ibizsys.model.wf.uiaction.IPSWFUIAction
 *  net.ibizsys.paas.util.KeyValueHelper
 */
package net.ibizsys.model.dataentity.uiaction;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.app.view.IPSAppDEView;
import net.ibizsys.model.app.view.IPSAppDEWFActionView;
import net.ibizsys.model.app.view.IPSAppDEWFView;
import net.ibizsys.model.app.view.IPSAppDEXDataView;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSAppViewRuntime;
import net.ibizsys.model.control.toolbar.IPSDETBUIActionItem;
import net.ibizsys.model.dataentity.uiaction.WFPSDEUIActionImpl;
import net.ibizsys.model.entity.PSDEUIAction;
import net.ibizsys.model.view.IPSUIAction;
import net.ibizsys.model.view.IPSUIActionGroup;
import net.ibizsys.model.wf.IPSWFProcess;
import net.ibizsys.model.wf.IPSWFVersion;
import net.ibizsys.model.wf.IPSWorkflow;
import net.ibizsys.model.wf.uiaction.IPSWFUIAction;
import net.ibizsys.model.wf.uiaction.IPSWFUIActionRuntime;
import net.ibizsys.paas.util.KeyValueHelper;

public class StartWFPSDEUIActionImpl
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
            if (iPSAppView instanceof IPSAppDEXDataView) {
                return ((IPSAppDEXDataView)iPSAppView).isEnableStartWF();
            }
            if (iPSAppView instanceof IPSAppDEView && ((IPSAppDEView)iPSAppView).isEnableWF() && iPSAppView instanceof IPSAppDEWFActionView) {
                return !((IPSAppDEWFActionView)iPSAppView).isWFIAMode();
            }
        }
        return super.isValid(obj);
    }

    @Override
    public boolean isUIActionGroup(Object obj) throws Exception {
        IPSAppDEWFView iPSAppDEWFView;
        IPSDETBUIActionItem iPSDETBUIActionItem;
        IPSAppView iPSAppView;
        if (obj != null && this.iPSWFVersion == null && obj instanceof IPSDETBUIActionItem && (iPSAppView = (iPSDETBUIActionItem = (IPSDETBUIActionItem)obj).getPSAppView()) instanceof IPSAppDEWFView && (iPSAppDEWFView = (IPSAppDEWFView)iPSAppView).getPSDEWF() != null) {
            IPSWFVersion lastPSWFVersion = iPSAppDEWFView.getPSWorkflow().getLastPSWFVersion();
            if (lastPSWFVersion == null) {
                return false;
            }
            IPSWFProcess iPSWFProcess = lastPSWFVersion.getStartPSWFProcess();
            if (!iPSAppDEWFView.isMobileView()) {
                String strPSDEUIActionId = KeyValueHelper.genUniqueId((String)iPSAppDEWFView.getPSWorkflow().getId(), (String)lastPSWFVersion.getId(), (String)"WFSTARTWIZARD");
                IPSWFUIAction iPSWFUIAction = lastPSWFVersion.getPSWFUIAction(strPSDEUIActionId, true);
                if (iPSWFUIAction != null) {
                    ((IPSAppViewRuntime)iPSAppView).registerPSUIAction((IPSUIAction)iPSWFUIAction);
                }
                return lastPSWFVersion.getPSWFUIActionGroup(iPSWFProcess.getId(), true) != null;
            }
            String strPSDEUIActionId = KeyValueHelper.genUniqueId((String)iPSAppDEWFView.getPSWorkflow().getId(), (String)lastPSWFVersion.getId(), (String)"MOBWFSTARTWIZARD");
            IPSWFUIAction iPSWFUIAction = lastPSWFVersion.getPSWFUIAction(strPSDEUIActionId, true);
            if (iPSWFUIAction != null) {
                ((IPSAppViewRuntime)iPSAppView).registerPSUIAction((IPSUIAction)iPSWFUIAction);
            }
            return lastPSWFVersion.getPSWFUIActionGroup(KeyValueHelper.genUniqueId((String)"MOB", (String)iPSWFProcess.getId()), true) != null;
        }
        return super.isUIActionGroup(obj);
    }

    @Override
    public IPSUIActionGroup getPSUIActionGroup(Object obj) throws Exception {
        IPSAppDEWFView iPSAppDEWFView;
        IPSDETBUIActionItem iPSDETBUIActionItem;
        IPSAppView iPSAppView;
        if (obj != null && this.iPSWFVersion == null && obj instanceof IPSDETBUIActionItem && (iPSAppView = (iPSDETBUIActionItem = (IPSDETBUIActionItem)obj).getPSAppView()) instanceof IPSAppDEWFView && (iPSAppDEWFView = (IPSAppDEWFView)iPSAppView).getPSDEWF() != null) {
            IPSWFVersion lastPSWFVersion = iPSAppDEWFView.getPSWorkflow().getLastPSWFVersion();
            if (lastPSWFVersion == null) {
                return null;
            }
            IPSWFProcess iPSWFProcess = lastPSWFVersion.getStartPSWFProcess();
            if (!iPSAppDEWFView.isMobileView()) {
                return lastPSWFVersion.getPSWFUIActionGroup(iPSWFProcess.getId());
            }
            return lastPSWFVersion.getPSWFUIActionGroup(KeyValueHelper.genUniqueId((String)"MOB", (String)iPSWFProcess.getId()));
        }
        return super.getPSUIActionGroup(obj);
    }

    public IPSWorkflow getPSWorkflow() {
        if (this.iPSWFVersion == null) {
            return null;
        }
        return this.iPSWFVersion.getPSWorkflow();
    }

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSWFVersion iPSWFVersion, PSDEUIAction psDEUIAction) throws Exception {
        this.iPSWFVersion = iPSWFVersion;
        this.init(iPSModelStorageContext, iPSWFVersion.getPSWorkflow().getPSSystem(), null, psDEUIAction);
    }

    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41\u7248\u672c\u5bf9\u8c61")
    public IPSWFVersion getPSWFVersion() {
        return this.iPSWFVersion;
    }
}

