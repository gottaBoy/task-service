/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Grid;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewUIAction;
import SA.SRFDA.PS.Core.App.View.PSAppViewLogicImpl;
import SA.SRFDA.PS.Core.App.View.PSAppViewUIActionProxy;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridDataItem;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridUAColumn;
import SA.SRFDA.PS.Core.Control.Grid.PSDEGridColumnImpl;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIActionGroup;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Core.View.IPSUIActionGroupDetail;
import SA.SRFDA.PS.Data.PSAppViewLogic;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;

public class PSDEGridUAColumnImpl
extends PSDEGridColumnImpl
implements IPSDEGridUAColumn {
    private IPSDEUIActionGroup iPSDEUIActionGroup = null;
    private ArrayList<IPSDEGridDataItem> psDEGridDataItemList = new ArrayList();

    @Override
    protected void onInit() throws Exception {
        if (StringHelper.IsNullOrEmpty((String)this.getAlign())) {
            this.setAlign("RIGHT");
        }
        this.setEnableSort(false);
        if (!StringHelper.IsNullOrEmpty((String)this.psDEGridColumn.getPSDEUAGROUPID())) {
            Iterator psUIActionGroupDetails;
            if (this.iPSDEUIActionGroup == null && this.getPSDEGrid().getPSAppDataEntity() != null) {
                this.iPSDEUIActionGroup = this.getPSDEGrid().getPSAppDataEntity().getPSAppDEUIActionGroup(this.psDEGridColumn.getPSDEUAGROUPID(), true, this.getOwnedPSControl());
            }
            if (this.iPSDEUIActionGroup == null) {
                this.iPSDEUIActionGroup = this.getPSDEGrid().getPSDataEntity().getPSDEUIActionGroup(this.psDEGridColumn.getPSDEUAGROUPID());
            }
            if ((psUIActionGroupDetails = this.iPSDEUIActionGroup.getPSUIActionGroupDetails()) != null) {
                while (psUIActionGroupDetails.hasNext()) {
                    IPSUIActionGroupDetail iPSUIActionGroupDetail = (IPSUIActionGroupDetail)psUIActionGroupDetails.next();
                    IPSUIAction iPSUIAction = iPSUIActionGroupDetail.getPSUIAction();
                    if (iPSUIAction == null) continue;
                    if (this.getPSDEGrid().isPrepareTemplV2logic()) {
                        PSAppViewUIActionProxy iPSAppViewUIAction = new PSAppViewUIActionProxy(this, iPSUIAction, this.getPSDEGrid());
                        this.getPSDEGrid().registerPSAppViewUIAction(iPSAppViewUIAction);
                        this.registerPSAppViewLogic(iPSAppViewUIAction, iPSUIActionGroupDetail);
                        continue;
                    }
                    this.getPSDEGrid().getPSAppView().registerPSUIAction(iPSUIAction);
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
        Iterator<IPSDEUIAction> psDEUIActions;
        if (this.getPSDEUIActionGroup() != null && (psDEUIActions = this.getPSDEUIActionGroup().getPSDEUIActions()) != null) {
            while (psDEUIActions.hasNext()) {
                IPSDEUIAction iPSDEUIAction = psDEUIActions.next();
                if (iPSDEUIAction.getFrontPSAppView(this) == null) continue;
                relatedAppViewList.add(iPSDEUIAction.getFrontPSAppView(this));
            }
        }
        super.onFillRelatedPSAppViews(relatedAppViewList);
    }

    @Override
    public Iterator<IPSDEGridDataItem> getPSDEGridDataItems() {
        if (this.psDEGridDataItemList.size() == 0) {
            return null;
        }
        return this.psDEGridDataItemList.iterator();
    }

    @Override
    public String getDataItemName() {
        return "srfkey";
    }

    protected void registerPSAppViewLogic(IPSAppViewUIAction iPSAppViewUIAction, IPSUIActionGroupDetail iPSUIActionGroupDetail) throws Exception {
        String strCtrlName = this.getPSDEGrid().getName();
        String strLogicTag = StringHelper.Format((String)"%1$s_%2$s_%3$s_click", (Object)strCtrlName, (Object)this.getName(), (Object)iPSUIActionGroupDetail.getName()).toLowerCase();
        PSAppViewLogic psAppViewLogic = new PSAppViewLogic();
        psAppViewLogic.setPSAPPVIEWLOGICID(strLogicTag);
        psAppViewLogic.setPSAPPVIEWLOGICNAME(strLogicTag);
        psAppViewLogic.setDSTLOGICTYPE("APPVIEWUIACTION");
        psAppViewLogic.setPSAPPVIEWLOGICTYPE("CUSTOM");
        PSAppViewLogicImpl psAppDEViewLogicImpl = new PSAppViewLogicImpl();
        psAppDEViewLogicImpl.init(this.getDAGlobalHelper(), (Object)this.getPSDEGrid(), psAppViewLogic, iPSAppViewUIAction);
        this.getPSDEGrid().registerPSAppViewLogic(psAppDEViewLogicImpl);
    }
}

