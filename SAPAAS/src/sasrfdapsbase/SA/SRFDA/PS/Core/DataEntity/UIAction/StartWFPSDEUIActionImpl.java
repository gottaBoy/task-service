/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.UIAction;

import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.App.View.IPSAppDEWFActionView;
import SA.SRFDA.PS.Core.App.View.IPSAppDEWFView;
import SA.SRFDA.PS.Core.App.View.IPSAppDEXDataView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.WF.IPSAppWFUIAction;
import SA.SRFDA.PS.Core.App.WF.IPSAppWFUIActionGroup;
import SA.SRFDA.PS.Core.App.WF.IPSAppWFVer;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDETBUIActionItem;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDETBUIActionItemRuntime;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction;
import SA.SRFDA.PS.Core.DataEntity.UIAction.WFPSDEUIActionImpl;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.View.IPSUIActionGroup;
import SA.SRFDA.PS.Core.View.IPSUIActionRuntime;
import SA.SRFDA.PS.Core.WF.IPSWFLink;
import SA.SRFDA.PS.Core.WF.IPSWFProcess;
import SA.SRFDA.PS.Core.WF.IPSWFVersion;
import SA.SRFDA.PS.Core.WF.UIAction.IPSWFUIAction;
import SA.SRFDA.PS.Core.WF.UIAction.IPSWFUIActionGroup;
import java.util.Iterator;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;

@PSModelPFIgnoreMeta
public class StartWFPSDEUIActionImpl
extends WFPSDEUIActionImpl
implements IPSAppWFUIAction {
    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (this.getPSWFVersion() != null || this.getPSWorkflow() != null) {
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
        if (obj != null && this.getPSWFVersion() == null && obj instanceof IPSDETBUIActionItem && (iPSAppView = (iPSDETBUIActionItem = (IPSDETBUIActionItem)obj).getPSAppView()) instanceof IPSAppDEWFView && (iPSAppDEWFView = (IPSAppDEWFView)iPSAppView).getPSDEWF() != null) {
            if (!iPSAppDEWFView.getPSApplication().isWFAppMode() && iPSAppDEWFView.getPSDEWF().isUseWFProxyApp() && iPSAppDEWFView.getPSWorkflow().getWFProxyMode() == 3) {
                IPSDEUIAction iPSDEUIAction;
                if (!iPSAppDEWFView.isMobileView()) {
                    iPSDEUIAction = null;
                    if (iPSAppDEWFView.getPSAppDataEntity() != null && (iPSDEUIAction = iPSAppDEWFView.getPSAppDataEntity().getPSAppDEUIAction("WFSTARTWIZARD", true, this)) != null) {
                        iPSAppView.registerPSUIAction(iPSDEUIAction);
                        if (obj instanceof IPSDETBUIActionItemRuntime) {
                            ((IPSDETBUIActionItemRuntime)obj).setPSUIAction(iPSDEUIAction);
                        }
                        return false;
                    }
                    iPSDEUIAction = iPSAppDEWFView.getPSDEWF().getPSDataEntity().getPSDEUIAction("WFSTARTWIZARD", true);
                    if (iPSDEUIAction != null) {
                        iPSAppView.registerPSUIAction(iPSDEUIAction);
                        if (obj instanceof IPSDETBUIActionItemRuntime) {
                            ((IPSDETBUIActionItemRuntime)obj).setPSUIAction(iPSDEUIAction);
                        }
                        return false;
                    }
                } else {
                    iPSDEUIAction = null;
                    if (iPSAppDEWFView.getPSAppDataEntity() != null && (iPSDEUIAction = iPSAppDEWFView.getPSAppDataEntity().getPSAppDEUIAction("MOBWFSTARTWIZARD", true, this)) != null) {
                        iPSAppView.registerPSUIAction(iPSDEUIAction);
                        if (obj instanceof IPSDETBUIActionItemRuntime) {
                            ((IPSDETBUIActionItemRuntime)obj).setPSUIAction(iPSDEUIAction);
                        }
                        return false;
                    }
                    iPSDEUIAction = iPSAppDEWFView.getPSDEWF().getPSDataEntity().getPSDEUIAction("MOBWFSTARTWIZARD", true);
                    if (iPSDEUIAction != null) {
                        iPSAppView.registerPSUIAction(iPSDEUIAction);
                        if (obj instanceof IPSDETBUIActionItemRuntime) {
                            ((IPSDETBUIActionItemRuntime)obj).setPSUIAction(iPSDEUIAction);
                        }
                        return false;
                    }
                }
            }
            if (!iPSAppDEWFView.getPSApplication().isWFAppMode() && iPSAppDEWFView.getPSWorkflow().isUseWFProxyApp()) {
                IPSWFUIAction iPSWFUIAction;
                String strPSDEUIActionId;
                if (!iPSAppDEWFView.isMobileView()) {
                    IPSWFUIAction iPSWFUIAction2;
                    strPSDEUIActionId = KeyValueHelper.genUniqueId((String)iPSAppDEWFView.getPSWorkflow().getId(), (String)"WFSTARTWIZARD");
                    if (iPSAppDEWFView.getPSAppWF() != null && (iPSWFUIAction2 = iPSAppDEWFView.getPSAppWF().getPSAppWFUIAction(strPSDEUIActionId, true)) != null) {
                        iPSAppView.registerPSUIAction(iPSWFUIAction2);
                        return false;
                    }
                    iPSWFUIAction2 = iPSAppDEWFView.getPSWorkflow().getPSWFUIAction(strPSDEUIActionId, true);
                    if (iPSWFUIAction2 != null) {
                        iPSAppView.registerPSUIAction(iPSWFUIAction2);
                    }
                    return false;
                }
                strPSDEUIActionId = KeyValueHelper.genUniqueId((String)iPSAppDEWFView.getPSWorkflow().getId(), (String)"MOBWFSTARTWIZARD");
                if (iPSAppDEWFView.getPSAppWF() != null && (iPSWFUIAction = iPSAppDEWFView.getPSAppWF().getPSAppWFUIAction(strPSDEUIActionId, true)) != null) {
                    iPSAppView.registerPSUIAction(iPSWFUIAction);
                    return false;
                }
                iPSWFUIAction = iPSAppDEWFView.getPSWorkflow().getPSWFUIAction(strPSDEUIActionId, true);
                if (iPSWFUIAction != null) {
                    iPSAppView.registerPSUIAction(iPSWFUIAction);
                }
                return false;
            }
            IPSWFVersion lastPSWFVersion = iPSAppDEWFView.getPSWorkflow().getLastPSWFVersion();
            if (lastPSWFVersion == null) {
                return false;
            }
            IPSWFProcess iPSWFProcess = lastPSWFVersion.getStartPSWFProcess();
            if (iPSWFProcess == null) {
                return false;
            }
            IPSAppWFVer iPSAppWFVer = iPSAppDEWFView.getPSApplication().getPSAppWFVer(lastPSWFVersion.getId(), true);
            if (iPSAppWFVer != null) {
                if (!iPSAppDEWFView.isMobileView()) {
                    String strPSDEUIActionId = KeyValueHelper.genUniqueId((String)iPSAppDEWFView.getPSWorkflow().getId(), (String)lastPSWFVersion.getId(), (String)"WFSTARTWIZARD");
                    IPSAppWFUIAction iPSWFUIAction = iPSAppWFVer.getPSAppWFUIAction(strPSDEUIActionId, true);
                    IPSAppWFUIActionGroup iPSWFUIActionGroup = iPSAppWFVer.getPSAppWFUIActionGroup(iPSWFProcess.getId(), true);
                    if (iPSWFUIAction != null) {
                        Iterator<IPSWFUIAction> psWFUIActions;
                        iPSAppView.registerPSUIAction(iPSWFUIAction);
                        if (iPSWFUIActionGroup != null && iPSAppDEWFView.getPSPFStyle().getPFEngineVer() >= 20 && (psWFUIActions = iPSWFUIActionGroup.getPSWFUIActions()) != null) {
                            while (psWFUIActions.hasNext()) {
                                IPSWFUIAction startPSWFUIAction = psWFUIActions.next();
                                if (StringHelper.compare((String)startPSWFUIAction.getPSSysDEUIActionId(null), (String)"EDITVIEW_SAVEANDSTARTWFACTION", (boolean)true) != 0 || !(startPSWFUIAction instanceof IPSUIActionRuntime)) continue;
                                ((IPSUIActionRuntime)((Object)startPSWFUIAction)).setNextPSUIAction(iPSWFUIAction);
                            }
                        }
                    }
                    return iPSWFUIActionGroup != null;
                }
                String strPSDEUIActionId = KeyValueHelper.genUniqueId((String)iPSAppDEWFView.getPSWorkflow().getId(), (String)lastPSWFVersion.getId(), (String)"MOBWFSTARTWIZARD");
                IPSAppWFUIAction iPSWFUIAction = iPSAppWFVer.getPSAppWFUIAction(strPSDEUIActionId, true);
                IPSAppWFUIActionGroup iPSWFUIActionGroup = iPSAppWFVer.getPSAppWFUIActionGroup(KeyValueHelper.genUniqueId((String)"MOB", (String)iPSWFProcess.getId()), true);
                if (iPSWFUIAction != null) {
                    Iterator<IPSWFUIAction> psWFUIActions;
                    iPSAppView.registerPSUIAction(iPSWFUIAction);
                    if (iPSWFUIActionGroup != null && iPSAppDEWFView.getPSPFStyle().getPFEngineVer() >= 20 && (psWFUIActions = iPSWFUIActionGroup.getPSWFUIActions()) != null) {
                        while (psWFUIActions.hasNext()) {
                            IPSWFUIAction startPSWFUIAction = psWFUIActions.next();
                            if (StringHelper.compare((String)startPSWFUIAction.getPSSysDEUIActionId(null), (String)"EDITVIEW_SAVEANDSTARTWFACTION", (boolean)true) != 0 || !(startPSWFUIAction instanceof IPSUIActionRuntime)) continue;
                            ((IPSUIActionRuntime)((Object)startPSWFUIAction)).setNextPSUIAction(iPSWFUIAction);
                        }
                    }
                }
                return iPSWFUIActionGroup != null;
            }
            if (!iPSAppDEWFView.isMobileView()) {
                String strPSDEUIActionId = KeyValueHelper.genUniqueId((String)iPSAppDEWFView.getPSWorkflow().getId(), (String)lastPSWFVersion.getId(), (String)"WFSTARTWIZARD");
                IPSWFUIAction iPSWFUIAction = lastPSWFVersion.getPSWFUIAction(strPSDEUIActionId, true);
                IPSWFUIActionGroup iPSWFUIActionGroup = lastPSWFVersion.getPSWFUIActionGroup(iPSWFProcess.getId(), true);
                if (iPSWFUIAction != null) {
                    Iterator<IPSWFUIAction> psWFUIActions;
                    iPSAppView.registerPSUIAction(iPSWFUIAction);
                    if (iPSWFUIActionGroup != null && iPSAppDEWFView.getPSPFStyle().getPFEngineVer() >= 20 && (psWFUIActions = iPSWFUIActionGroup.getPSWFUIActions()) != null) {
                        while (psWFUIActions.hasNext()) {
                            IPSWFUIAction startPSWFUIAction = psWFUIActions.next();
                            if (StringHelper.compare((String)startPSWFUIAction.getPSSysDEUIActionId(null), (String)"EDITVIEW_SAVEANDSTARTWFACTION", (boolean)true) != 0 || !(startPSWFUIAction instanceof IPSUIActionRuntime)) continue;
                            ((IPSUIActionRuntime)((Object)startPSWFUIAction)).setNextPSUIAction(iPSWFUIAction);
                        }
                    }
                }
                return iPSWFUIActionGroup != null;
            }
            String strPSDEUIActionId = KeyValueHelper.genUniqueId((String)iPSAppDEWFView.getPSWorkflow().getId(), (String)lastPSWFVersion.getId(), (String)"MOBWFSTARTWIZARD");
            IPSWFUIAction iPSWFUIAction = lastPSWFVersion.getPSWFUIAction(strPSDEUIActionId, true);
            IPSWFUIActionGroup iPSWFUIActionGroup = lastPSWFVersion.getPSWFUIActionGroup(KeyValueHelper.genUniqueId((String)"MOB", (String)iPSWFProcess.getId()), true);
            if (iPSWFUIAction != null) {
                Iterator<IPSWFUIAction> psWFUIActions;
                iPSAppView.registerPSUIAction(iPSWFUIAction);
                if (iPSWFUIActionGroup != null && iPSAppDEWFView.getPSPFStyle().getPFEngineVer() >= 20 && (psWFUIActions = iPSWFUIActionGroup.getPSWFUIActions()) != null) {
                    while (psWFUIActions.hasNext()) {
                        IPSWFUIAction startPSWFUIAction = psWFUIActions.next();
                        if (StringHelper.compare((String)startPSWFUIAction.getPSSysDEUIActionId(null), (String)"EDITVIEW_SAVEANDSTARTWFACTION", (boolean)true) != 0 || !(startPSWFUIAction instanceof IPSUIActionRuntime)) continue;
                        ((IPSUIActionRuntime)((Object)startPSWFUIAction)).setNextPSUIAction(iPSWFUIAction);
                    }
                }
            }
            return iPSWFUIActionGroup != null;
        }
        return super.isUIActionGroup(obj);
    }

    @Override
    public IPSUIActionGroup getPSUIActionGroup(Object obj) throws Exception {
        IPSAppDEWFView iPSAppDEWFView;
        IPSDETBUIActionItem iPSDETBUIActionItem;
        IPSAppView iPSAppView;
        if (obj != null && this.getPSWFVersion() == null && obj instanceof IPSDETBUIActionItem && (iPSAppView = (iPSDETBUIActionItem = (IPSDETBUIActionItem)obj).getPSAppView()) instanceof IPSAppDEWFView && (iPSAppDEWFView = (IPSAppDEWFView)iPSAppView).getPSDEWF() != null) {
            if (!iPSAppDEWFView.getPSApplication().isWFAppMode() && iPSAppDEWFView.getPSDEWF().isUseWFProxyApp()) {
                return null;
            }
            IPSWFVersion lastPSWFVersion = iPSAppDEWFView.getPSWorkflow().getLastPSWFVersion();
            if (lastPSWFVersion == null) {
                return null;
            }
            IPSWFProcess iPSWFProcess = lastPSWFVersion.getStartPSWFProcess();
            if (iPSWFProcess == null) {
                return null;
            }
            IPSAppWFVer iPSAppWFVer = iPSAppDEWFView.getPSApplication().getPSAppWFVer(lastPSWFVersion.getId(), true);
            if (iPSAppWFVer != null) {
                if (!iPSAppDEWFView.isMobileView()) {
                    return iPSAppWFVer.getPSAppWFUIActionGroup(iPSWFProcess.getId());
                }
                return iPSAppWFVer.getPSAppWFUIActionGroup(KeyValueHelper.genUniqueId((String)"MOB", (String)iPSWFProcess.getId()));
            }
            if (!iPSAppDEWFView.isMobileView()) {
                return lastPSWFVersion.getPSWFUIActionGroup(iPSWFProcess.getId());
            }
            return lastPSWFVersion.getPSWFUIActionGroup(KeyValueHelper.genUniqueId((String)"MOB", (String)iPSWFProcess.getId()));
        }
        return super.getPSUIActionGroup(obj);
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

