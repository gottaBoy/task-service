/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.App.View.PSAppViewUIActionProxy;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormGroupPanel;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Control.Form.PSDEFormBaseGroupPanelImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Core.View.IPSUIActionGroup;
import SA.SRFDA.PS.Core.View.IPSUIActionGroupDetail;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PSDEFormGroupPanelImpl
extends PSDEFormBaseGroupPanelImpl
implements IPSDEFormGroupPanel {
    private int nMoreActions = 0;
    private IPSUIActionGroup iPSUIActionGroup = null;
    private String strGroupExtractMode = "ITEM";
    private List<IPSDEFormItem> anchorablePSDEFormItemList = null;

    @Override
    protected void onInit() throws Exception {
        if (!this.psDEFormDetail.isBUILDINACTIONNull()) {
            this.nMoreActions = this.psDEFormDetail.getBUILDINACTION();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getPSDEUAGROUPID())) {
            Iterator<IPSUIActionGroupDetail> psUIActionGroupDetails;
            if (this.iPSUIActionGroup == null) {
                if (this.getPSDEForm().getPSAppDataEntity() != null) {
                    this.iPSUIActionGroup = this.getPSDEForm().getPSAppDataEntity().getPSAppDEUIActionGroup(this.psDEFormDetail.getPSDEUAGROUPID(), true, this.getOwnedPSControl());
                }
                if (this.iPSUIActionGroup == null) {
                    this.iPSUIActionGroup = this.getPSDEForm().getPSDataEntity().getPSDEUIActionGroup(this.psDEFormDetail.getPSDEUAGROUPID());
                }
            }
            if ((psUIActionGroupDetails = this.iPSUIActionGroup.getPSUIActionGroupDetails()) != null) {
                while (psUIActionGroupDetails.hasNext()) {
                    IPSUIActionGroupDetail iPSUIActionGroupDetail = psUIActionGroupDetails.next();
                    IPSUIAction iPSUIAction = iPSUIActionGroupDetail.getPSUIAction();
                    if (iPSUIAction == null) continue;
                    if (this.isPrepareTemplV2logic()) {
                        PSAppViewUIActionProxy iPSAppViewUIAction = new PSAppViewUIActionProxy(this, iPSUIAction, this.getPSDEForm());
                        this.getPSDEForm().registerPSAppViewUIAction(iPSAppViewUIAction);
                        this.registerPSAppViewLogic(iPSAppViewUIAction, iPSUIActionGroupDetail);
                        continue;
                    }
                    this.getPSDEForm().getPSAppView().registerPSUIAction(iPSUIAction);
                }
            }
            if (!StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getUPDATEDVT())) {
                this.strGroupExtractMode = this.psDEFormDetail.getUPDATEDVT();
            }
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5efa\u64cd\u4f5c", ignoredumpvalues="0", fields={"BUILDINACTION"})
    public int getBuildInActions() {
        return this.nMoreActions;
    }

    @Override
    public boolean isEnableBuildInAction(int nAction) {
        return (this.getBuildInActions() & nAction) == nAction;
    }

    @Override
    public String getModelType() {
        return "PSDEFORMDETAIL_GROUPPANEL";
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u7ec4\u5bf9\u8c61", child=true, fields={"PSDEUAGROUPID"})
    public IPSUIActionGroup getPSUIActionGroup() {
        return this.iPSUIActionGroup;
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u7ec4\u5c55\u5f00\u6a21\u5f0f", codelist="UGExtractMode", fields={"UPDATEDVT"})
    public String getActionGroupExtractMode() {
        if (this.getPSUIActionGroup() == null) {
            return null;
        }
        return this.strGroupExtractMode;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u680f\u5173\u95ed\u6a21\u5f0f", codelist="FormTitleBarCloseMode", ignoredumpvalues="0", fields={"TITLEBARCLOSEMODE"})
    public int getTitleBarCloseMode() {
        return super.getTitleBarCloseMode();
    }

    @Override
    @PSModelRTMeta(description="\u63d0\u4f9b\u951a\u70b9\u8868\u5355\u9879\u96c6\u5408")
    public Iterator<IPSDEFormItem> getAnchorablePSDEFormItems() {
        if (this.anchorablePSDEFormItemList == null) {
            ArrayList<IPSDEFormItem> anchorablePSDEFormItemList = new ArrayList<IPSDEFormItem>();
            Iterator<IPSDEFormDetail> psDEFormDetails = this.getPSDEFormDetails();
            if (psDEFormDetails != null) {
                while (psDEFormDetails.hasNext()) {
                    Iterator<IPSDEFormItem> items;
                    IPSDEFormGroupPanel iPSDEFormGroupPanel;
                    IPSDEFormDetail iPSDEFormDetail = psDEFormDetails.next();
                    if (iPSDEFormDetail instanceof IPSDEFormItem) {
                        IPSDEFormItem iPSDEFormItem = (IPSDEFormItem)iPSDEFormDetail;
                        if (!iPSDEFormItem.isEnableAnchor()) continue;
                        anchorablePSDEFormItemList.add(iPSDEFormItem);
                        continue;
                    }
                    if (!(iPSDEFormDetail instanceof IPSDEFormGroupPanel) || (iPSDEFormGroupPanel = (IPSDEFormGroupPanel)iPSDEFormDetail).isShowCaption() || (items = iPSDEFormGroupPanel.getAnchorablePSDEFormItems()) == null) continue;
                    while (items.hasNext()) {
                        anchorablePSDEFormItemList.add(items.next());
                    }
                }
            }
            if (this.anchorablePSDEFormItemList == null) {
                this.anchorablePSDEFormItemList = anchorablePSDEFormItemList;
            }
        }
        if (this.anchorablePSDEFormItemList == null || this.anchorablePSDEFormItemList.size() == 0) {
            return null;
        }
        return this.anchorablePSDEFormItemList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u4fe1\u606f\u9762\u677f\u6a21\u5f0f", fields={"ENABLECOND"})
    public boolean isInfoGroupMode() {
        return super.isInfoGroupMode();
    }
}

