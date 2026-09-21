/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Tree;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewUIAction;
import SA.SRFDA.PS.Core.App.View.PSAppViewLogicImpl;
import SA.SRFDA.PS.Core.App.View.PSAppViewUIActionProxy;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeUAColumn;
import SA.SRFDA.PS.Core.Control.Tree.PSDETreeColumnImpl;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIActionGroup;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Core.View.IPSUIActionGroupDetail;
import SA.SRFDA.PS.Data.PSAppViewLogic;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;

public class PSDETreeUAColumnImpl
extends PSDETreeColumnImpl
implements IPSDETreeUAColumn {
    private IPSDEUIActionGroup iPSDEUIActionGroup = null;

    @Override
    protected void onInit() throws Exception {
        if (StringHelper.IsNullOrEmpty((String)this.getAlign())) {
            this.setAlign("RIGHT");
        }
        this.setEnableSort(false);
        if (!StringHelper.IsNullOrEmpty((String)this.psDETreeColumn.getPSDEUAGROUPID())) {
            Iterator psUIActionGroupDetails;
            if (this.iPSDEUIActionGroup == null && this.getPSDETree().getPSAppDataEntity() != null) {
                this.iPSDEUIActionGroup = this.getPSDETree().getPSAppDataEntity().getPSAppDEUIActionGroup(this.psDETreeColumn.getPSDEUAGROUPID(), true, this);
            }
            if (this.iPSDEUIActionGroup == null) {
                this.iPSDEUIActionGroup = this.getPSDETree().getPSDataEntity().getPSDEUIActionGroup(this.psDETreeColumn.getPSDEUAGROUPID());
            }
            if ((psUIActionGroupDetails = this.iPSDEUIActionGroup.getPSUIActionGroupDetails()) != null) {
                while (psUIActionGroupDetails.hasNext()) {
                    IPSUIActionGroupDetail iPSUIActionGroupDetail = (IPSUIActionGroupDetail)psUIActionGroupDetails.next();
                    IPSUIAction iPSUIAction = iPSUIActionGroupDetail.getPSUIAction();
                    if (iPSUIAction == null) continue;
                    if (this.isPrepareTemplV2logic()) {
                        PSAppViewUIActionProxy iPSAppViewUIAction = new PSAppViewUIActionProxy(this, iPSUIAction, this.getPSDETree());
                        this.getPSDETree().registerPSAppViewUIAction(iPSAppViewUIAction);
                        this.registerPSAppViewLogic(iPSAppViewUIAction, iPSUIActionGroupDetail);
                        continue;
                    }
                    this.getPSDETree().getPSAppView().registerPSUIAction(iPSUIAction);
                }
            }
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u7ec4", child=true, fields={"PSDEUAGROUPID"})
    public IPSDEUIActionGroup getPSDEUIActionGroup() {
        return this.iPSDEUIActionGroup;
    }

    @Override
    protected void onFillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        if (this.getPSDEUIActionGroup() == null) {
            return;
        }
        Iterator<IPSDEUIAction> psDEUIActions = this.getPSDEUIActionGroup().getPSDEUIActions();
        if (psDEUIActions != null) {
            while (psDEUIActions.hasNext()) {
                IPSDEUIAction iPSDEUIAction = psDEUIActions.next();
                IPSAppView refPSAppView = iPSDEUIAction.getFrontPSAppView(this);
                if (refPSAppView == null) continue;
                relatedAppViewList.add(refPSAppView);
            }
        }
    }

    @Override
    public String getDataItemName() {
        return "srfkey";
    }

    protected boolean isPrepareTemplV2logic() {
        return this.getPSDETree().getPSAppView().getPSPFStyle().getPFEngineVer() >= 20;
    }

    protected void registerPSAppViewLogic(IPSAppViewUIAction iPSAppViewUIAction, IPSUIActionGroupDetail iPSUIActionGroupDetail) throws Exception {
        String strCtrlName = this.getPSDETree().getName();
        String strLogicTag = StringHelper.Format((String)"%1$s_%2$s_%3$s_click", (Object)strCtrlName, (Object)this.getName(), (Object)iPSUIActionGroupDetail.getName()).toLowerCase();
        PSAppViewLogic psAppViewLogic = new PSAppViewLogic();
        psAppViewLogic.setPSAPPVIEWLOGICID(strLogicTag);
        psAppViewLogic.setPSAPPVIEWLOGICNAME(strLogicTag);
        psAppViewLogic.setDSTLOGICTYPE("APPVIEWUIACTION");
        psAppViewLogic.setPSAPPVIEWLOGICTYPE("CUSTOM");
        PSAppViewLogicImpl psAppDEViewLogicImpl = new PSAppViewLogicImpl();
        psAppDEViewLogicImpl.init(this.getDAGlobalHelper(), (Object)this.getPSDETree(), psAppViewLogic, iPSAppViewUIAction);
        this.getPSDETree().registerPSAppViewLogic(psAppDEViewLogicImpl);
    }
}

