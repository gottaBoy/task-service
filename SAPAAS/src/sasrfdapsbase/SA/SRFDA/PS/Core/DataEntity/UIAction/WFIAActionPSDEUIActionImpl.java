/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 */
package SA.SRFDA.PS.Core.DataEntity.UIAction;

import SA.SRFDA.PS.Core.App.View.IPSAppDEWFActionView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDETBUIActionItem;
import SA.SRFDA.PS.Core.DataEntity.UIAction.WFPSDEUIActionImpl;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.View.IPSUIActionGroup;
import SA.SRFDA.PS.Core.WF.IPSWFInteractiveProcess;
import SA.SRFDA.PS.Core.WF.IPSWFProcess;
import SA.SRFramework.Utility.StringHelper;
import net.ibizsys.paas.util.KeyValueHelper;

@PSModelPFIgnoreMeta
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
    public IPSUIActionGroup getPSUIActionGroup(Object obj) throws Exception {
        IPSDETBUIActionItem iPSDETBUIActionItem;
        IPSAppView iPSAppView;
        if (obj != null && obj instanceof IPSDETBUIActionItem && (iPSAppView = (iPSDETBUIActionItem = (IPSDETBUIActionItem)obj).getPSAppView()) instanceof IPSAppDEWFActionView) {
            IPSAppDEWFActionView iPSAppDEWFIAView = (IPSAppDEWFActionView)iPSAppView;
            String strWFStepValue = iPSAppDEWFIAView.getWFStepValue();
            IPSWFProcess iPSWFProcess = iPSAppDEWFIAView.getPSWFVersion().getPSWFProcessByWFStepValue(strWFStepValue, true);
            if (iPSWFProcess != null) {
                if (!iPSAppDEWFIAView.isMobileView()) {
                    if (iPSAppDEWFIAView.getPSAppWFVer() != null) {
                        return iPSAppDEWFIAView.getPSAppWFVer().getPSAppWFUIActionGroup(iPSWFProcess.getId());
                    }
                    return iPSAppDEWFIAView.getPSWFVersion().getPSWFUIActionGroup(iPSWFProcess.getId());
                }
                if (iPSAppDEWFIAView.getPSAppWFVer() != null) {
                    return iPSAppDEWFIAView.getPSAppWFVer().getPSAppWFUIActionGroup(KeyValueHelper.genUniqueId((String)"MOB", (String)iPSWFProcess.getId()));
                }
                return iPSAppDEWFIAView.getPSWFVersion().getPSWFUIActionGroup(KeyValueHelper.genUniqueId((String)"MOB", (String)iPSWFProcess.getId()));
            }
        }
        return super.getPSUIActionGroup(obj);
    }
}

