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
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeDataItem;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeUAColumn;
import SA.SRFDA.PS.Core.Control.Tree.PSDETreeNodeColumnImpl;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIActionGroup;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Core.View.IPSUIActionGroupDetail;
import SA.SRFDA.PS.Data.PSAppViewLogic;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;

public class PSDETreeNodeUAColumnImpl
extends PSDETreeNodeColumnImpl
implements IPSDETreeNodeUAColumn {
    private IPSDEUIActionGroup iPSDEUIActionGroup = null;
    private ArrayList<IPSDETreeNodeDataItem> psDETreeNodeDataItemList = new ArrayList();

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.psDETreeNodeColumn.getPSDEUAGROUPID())) {
            Iterator psUIActionGroupDetails;
            if (this.getPSDETreeNode().getPSDataEntity() == null) {
                throw new Exception("\u6811\u8282\u70b9\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u5bf9\u8c61");
            }
            if (this.iPSDEUIActionGroup == null && this.getPSDETreeNode().getPSAppDataEntity() != null) {
                this.iPSDEUIActionGroup = this.getPSDETreeNode().getPSAppDataEntity().getPSAppDEUIActionGroup(this.psDETreeNodeColumn.getPSDEUAGROUPID(), true, this);
            }
            if (this.iPSDEUIActionGroup == null) {
                this.iPSDEUIActionGroup = this.getPSDETreeNode().getPSDataEntity().getPSDEUIActionGroup(this.psDETreeNodeColumn.getPSDEUAGROUPID());
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
    public Iterator<IPSDETreeNodeDataItem> getPSDETreeNodeDataItems() {
        if (this.psDETreeNodeDataItemList.size() == 0) {
            return null;
        }
        return this.psDETreeNodeDataItemList.iterator();
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
        String strLogicTag = StringHelper.Format((String)"%1$s_%2$s_%3$s_%3$s_click", (Object)strCtrlName, (Object)this.getPSDETreeNode().getNodeType(), (Object)this.getName(), (Object)iPSUIActionGroupDetail.getName()).toLowerCase();
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

