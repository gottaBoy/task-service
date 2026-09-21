/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.App.View.IPSAppViewUIAction;
import SA.SRFDA.PS.Core.App.View.PSAppViewLogicImpl;
import SA.SRFDA.PS.Core.App.View.PSAppViewUIActionProxy;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormButton;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormButtonList;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail;
import SA.SRFDA.PS.Core.Control.Form.IPSFormDetailType;
import SA.SRFDA.PS.Core.Control.Form.PSDEFormDetailImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Core.View.IPSUIActionGroup;
import SA.SRFDA.PS.Core.View.IPSUIActionGroupDetail;
import SA.SRFDA.PS.Data.PSAppViewLogic;
import SA.SRFDA.PS.Data.PSDEFormDetail;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PSDEFormButtonListImpl
extends PSDEFormDetailImpl
implements IPSDEFormButtonList {
    private IPSUIActionGroup iPSUIActionGroup = null;
    private String strGroupExtractMode = "ITEM";
    private String strButtonListType = "UIACTIONGROUP";
    protected List<IPSDEFormButton> psDEFormButtonList = new ArrayList<IPSDEFormButton>();

    @Override
    protected void onInit() throws Exception {
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
        } else {
            this.onPreparePSDEFormButtons();
            if (this.psDEFormButtonList.size() == 0) {
                throw new Exception("\u672a\u6307\u5b9a\u754c\u9762\u884c\u4e3a\u7ec4");
            }
            this.strButtonListType = "BUTTONS";
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getUPDATEDVT())) {
            this.strGroupExtractMode = this.psDEFormDetail.getUPDATEDVT();
        }
        super.onInit();
    }

    @Override
    public String getModelType() {
        return "PSDEFORMDETAIL_BUTTONLIST";
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u7ec4\u5bf9\u8c61", child=true, fields={"PSDEUAGROUPID"})
    public IPSUIActionGroup getPSUIActionGroup() {
        return this.iPSUIActionGroup;
    }

    protected void registerPSAppViewLogic(IPSAppViewUIAction iPSAppViewUIAction, IPSUIActionGroupDetail iPSUIActionGroupDetail) throws Exception {
        String strCtrlName = this.getPSDEForm().getName();
        String strLogicTag = StringHelper.Format((String)"%1$s_%2$s_%3$s_click", (Object)strCtrlName, (Object)this.getName(), (Object)iPSUIActionGroupDetail.getName()).toLowerCase();
        PSAppViewLogic psAppViewLogic = new PSAppViewLogic();
        psAppViewLogic.setPSAPPVIEWLOGICID(strLogicTag);
        psAppViewLogic.setPSAPPVIEWLOGICNAME(strLogicTag);
        psAppViewLogic.setDSTLOGICTYPE("APPVIEWUIACTION");
        psAppViewLogic.setPSAPPVIEWLOGICTYPE("CUSTOM");
        PSAppViewLogicImpl psAppDEViewLogicImpl = new PSAppViewLogicImpl();
        psAppDEViewLogicImpl.init(this.getDAGlobalHelper(), (Object)this.getPSDEForm(), psAppViewLogic, iPSAppViewUIAction);
        this.getPSDEForm().registerPSAppViewLogic(psAppDEViewLogicImpl);
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u7ec4\u5c55\u5f00\u6a21\u5f0f", codelist="UGExtractMode", fields={"UPDATEDVT"})
    public String getActionGroupExtractMode() {
        return this.strGroupExtractMode;
    }

    protected void onPreparePSDEFormButtons() throws Exception {
        this.psDEFormButtonList.clear();
        ArrayList<PSDEFormDetail> psDEFormDetailList = this.psDEFormDetail.getChildPSDEFormDetails(false);
        if (psDEFormDetailList == null) {
            return;
        }
        for (PSDEFormDetail psDEFormDetail : psDEFormDetailList) {
            if (!"BUTTON".equals(psDEFormDetail.getDETAILTYPE())) continue;
            IPSFormDetailType iPSFormDetailType = this.getPSModelStorage().getPSFormDetailType(psDEFormDetail.getDETAILTYPE());
            IPSDEFormDetail iPSDEFormDetail = iPSFormDetailType.createPSDEFormDetail(psDEFormDetail);
            iPSDEFormDetail.init(this.getDAGlobalHelper(), this.iPSDEForm, this, psDEFormDetail);
            this.psDEFormButtonList.add((IPSDEFormButton)iPSDEFormDetail);
        }
    }

    @Override
    public void fillPSDEFormDetails(ArrayList<IPSDEFormDetail> psDEFormDetailList) {
        for (IPSDEFormDetail iPSDEFormDetail : this.psDEFormButtonList) {
            iPSDEFormDetail.fillPSDEFormDetails(psDEFormDetailList);
        }
        super.fillPSDEFormDetails(psDEFormDetailList);
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        super.fillRelatedPSAppViews(relatedAppViewList);
        for (IPSDEFormDetail iPSDEFormDetail : this.psDEFormButtonList) {
            iPSDEFormDetail.fillRelatedPSAppViews(relatedAppViewList);
        }
    }

    @Override
    public void fillEmbeddedPSAppViewRefs(String strContainerId, ArrayList<IPSAppViewRef> embeddedPSAppViewRefList) throws Exception {
        super.fillEmbeddedPSAppViewRefs(strContainerId, embeddedPSAppViewRefList);
        for (IPSDEFormDetail iPSDEFormDetail : this.psDEFormButtonList) {
            iPSDEFormDetail.fillEmbeddedPSAppViewRefs(strContainerId, embeddedPSAppViewRefList);
        }
    }

    @Override
    @PSModelRTMeta(description="\u6309\u94ae\u5217\u8868\u7c7b\u578b", codelist="FormButtonListType", ignoredumpvalues="UIACTIONGROUP", fields={"CONTENTTYPE"})
    public String getButtonListType() {
        return this.strButtonListType;
    }

    @Override
    @PSModelRTMeta(description="\u8868\u5355\u6309\u94ae\u96c6\u5408", child=true)
    public Iterator<IPSDEFormButton> getPSDEFormButtons() {
        if (this.psDEFormButtonList.size() == 0) {
            return null;
        }
        return this.psDEFormButtonList.iterator();
    }
}

