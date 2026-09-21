/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDRUIPart;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormTabPage;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormTabPanel;
import SA.SRFDA.PS.Core.Control.Form.IPSFormDetailType;
import SA.SRFDA.PS.Core.Control.Form.PSDEFormDetailImpl;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRDetail;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDataRelation;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSDEFormDetail;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;

public class PSDEFormTabPanelImpl
extends PSDEFormDetailImpl
implements IPSDEFormTabPanel {
    protected ArrayList<IPSDEFormTabPage> psDEFormTabPageList = new ArrayList();
    private int nInsertPos = -1;
    private IPSDEDataRelation iPSDEDataRelation = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.onPreparePSDEFormTabPages();
    }

    protected void onPreparePSDEFormTabPages() throws Exception {
        this.psDEFormTabPageList.clear();
        ArrayList<PSDEFormDetail> psDEFormDetailList = this.psDEFormDetail.getChildPSDEFormDetails(false);
        if (!StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getPSDEDRID())) {
            this.iPSDEDataRelation = this.getPSDEForm().getPSDataEntity().getPSDEDataRelation(this.psDEFormDetail.getPSDEDRID());
            if (!this.psDEFormDetail.isINSERTPOSNull()) {
                this.nInsertPos = this.psDEFormDetail.getINSERTPOS();
                if (this.nInsertPos < 0) {
                    this.nInsertPos = -1;
                }
            }
            ArrayList<PSDEFormDetail> psDEFormDetailList2 = new ArrayList<PSDEFormDetail>();
            Iterator<IPSDEDRDetail> psDEDRDetails = this.iPSDEDataRelation.getPSDEDRDetails();
            if (psDEDRDetails != null) {
                while (psDEDRDetails.hasNext()) {
                    IPSDEDRDetail iPSDEDRDetail = psDEDRDetails.next();
                    if (StringHelper.IsNullOrEmpty((String)iPSDEDRDetail.getPSDEDRItemId())) continue;
                    PSDEFormDetail tabPagePSDEFormDetail = new PSDEFormDetail();
                    tabPagePSDEFormDetail.setPSDEDRITEMNAME(iPSDEDRDetail.getName());
                    tabPagePSDEFormDetail.setCAPTION(iPSDEDRDetail.getCaption());
                    String strName = String.format("%1$s_%2$s", this.getName(), iPSDEDRDetail.getName());
                    tabPagePSDEFormDetail.setPSDEFORMDETAILNAME(strName);
                    if (iPSDEDRDetail.getCapPSLanguageRes() != null) {
                        tabPagePSDEFormDetail.setCAPPSLANRESID(iPSDEDRDetail.getCapPSLanguageRes().getId());
                    }
                    tabPagePSDEFormDetail.setDETAILTYPE("TABPAGE");
                    if (!StringHelper.IsNullOrEmpty((String)iPSDEDRDetail.getCounterId())) {
                        tabPagePSDEFormDetail.setCOUNTERID(iPSDEDRDetail.getCounterId());
                        tabPagePSDEFormDetail.setCOUNTERMODE(iPSDEDRDetail.getCounterMode());
                        if (!StringHelper.IsNullOrEmpty((String)this.iPSDEDataRelation.getPSSysCounterId())) {
                            tabPagePSDEFormDetail.setPSSYSCOUNTERID(this.iPSDEDataRelation.getPSSysCounterId());
                        }
                    }
                    PSDEFormDetail druipartPSDEFormDetail = new PSDEFormDetail();
                    strName = String.format("%1$s_%2$s_druipart", this.getName(), iPSDEDRDetail.getName());
                    druipartPSDEFormDetail.setPSDEFORMDETAILNAME(strName);
                    druipartPSDEFormDetail.setDETAILTYPE("DRUIPART");
                    druipartPSDEFormDetail.setPSDEDRITEMID(iPSDEDRDetail.getPSDEDRItemId());
                    if (!StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getRESETITEMNAME())) {
                        druipartPSDEFormDetail.setRESETITEMNAME(this.psDEFormDetail.getRESETITEMNAME());
                    }
                    if (!this.psDEFormDetail.isMASKMODENull()) {
                        druipartPSDEFormDetail.setMASKMODE(this.psDEFormDetail.getMASKMODE());
                    }
                    if (!StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getMASKINFO())) {
                        druipartPSDEFormDetail.setMASKINFO(this.psDEFormDetail.getMASKINFO());
                    }
                    if (!StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getMASKPSLANRESID())) {
                        druipartPSDEFormDetail.setMASKPSLANRESID(this.psDEFormDetail.getMASKPSLANRESID());
                    }
                    if (!this.psDEFormDetail.isBUILDINACTIONNull()) {
                        druipartPSDEFormDetail.setBUILDINACTION(this.psDEFormDetail.getBUILDINACTION());
                    }
                    tabPagePSDEFormDetail.getChildPSDEFormDetails(true).add(druipartPSDEFormDetail);
                    psDEFormDetailList2.add(tabPagePSDEFormDetail);
                }
            }
            if (psDEFormDetailList2.size() > 0) {
                if (psDEFormDetailList == null) {
                    psDEFormDetailList = psDEFormDetailList2;
                } else {
                    if (this.nInsertPos >= psDEFormDetailList.size()) {
                        this.nInsertPos = -1;
                    }
                    if (this.nInsertPos == -1) {
                        psDEFormDetailList.addAll(psDEFormDetailList2);
                    } else {
                        psDEFormDetailList.addAll(this.nInsertPos, psDEFormDetailList2);
                    }
                }
            }
        }
        if (psDEFormDetailList == null) {
            return;
        }
        for (PSDEFormDetail psDEFormDetail : psDEFormDetailList) {
            IPSFormDetailType iPSFormDetailType = this.getPSModelStorage().getPSFormDetailType(psDEFormDetail.getDETAILTYPE());
            IPSDEFormDetail iPSDEFormDetail = iPSFormDetailType.createPSDEFormDetail(psDEFormDetail);
            iPSDEFormDetail.init(this.getDAGlobalHelper(), this.iPSDEForm, this, psDEFormDetail);
            this.psDEFormTabPageList.add((IPSDEFormTabPage)iPSDEFormDetail);
        }
    }

    @Override
    @PSModelRTMeta(description="\u5206\u9875\u96c6\u5408", child=true)
    public Iterator<IPSDEFormTabPage> getPSDEFormTabPages() {
        return this.psDEFormTabPageList.iterator();
    }

    @Override
    public boolean isShowCaption() {
        return false;
    }

    @Override
    public void fillPSDEFormItems(ArrayList<IPSDEFormItem> psDEFormItemList) {
        for (IPSDEFormTabPage iPSDEFormTabPage : this.psDEFormTabPageList) {
            iPSDEFormTabPage.fillPSDEFormItems(psDEFormItemList);
        }
    }

    @Override
    public void fillPSDEFormDetails(ArrayList<IPSDEFormDetail> psDEFormDetailList) {
        for (IPSDEFormTabPage iPSDEFormTabPage : this.psDEFormTabPageList) {
            iPSDEFormTabPage.fillPSDEFormDetails(psDEFormDetailList);
        }
        super.fillPSDEFormDetails(psDEFormDetailList);
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        super.fillRelatedPSAppViews(relatedAppViewList);
        for (IPSDEFormDetail iPSDEFormDetail : this.psDEFormTabPageList) {
            iPSDEFormDetail.fillRelatedPSAppViews(relatedAppViewList);
        }
    }

    @Override
    public void fillEmbeddedPSAppViewRefs(String strContainerId, ArrayList<IPSAppViewRef> embeddedPSAppViewRefList) throws Exception {
        super.fillEmbeddedPSAppViewRefs(strContainerId, embeddedPSAppViewRefList);
        for (IPSDEFormDetail iPSDEFormDetail : this.psDEFormTabPageList) {
            iPSDEFormDetail.fillEmbeddedPSAppViewRefs(strContainerId, embeddedPSAppViewRefList);
        }
    }

    @Override
    public void fillPSDEFormDRUIParts(ArrayList<IPSDEFormDRUIPart> psDEFormDRUIPartList) {
        super.fillPSDEFormDRUIParts(psDEFormDRUIPartList);
        for (IPSDEFormDetail iPSDEFormDetail : this.psDEFormTabPageList) {
            iPSDEFormDetail.fillPSDEFormDRUIParts(psDEFormDRUIPartList);
        }
    }

    @Override
    protected void onLayout() throws Exception {
        super.onLayout();
        for (IPSDEFormDetail iPSDEFormDetail : this.psDEFormTabPageList) {
            iPSDEFormDetail.layout();
        }
    }

    @Override
    public String getModelType() {
        return "PSDEFORMDETAIL_TABPANEL";
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u5173\u7cfb\u6807\u8bb0", fields={"DRTAG"}, ignorert=3)
    public String getDataRelationTag() {
        if (this.getPSDEDataRelation() != null) {
            return this.getPSDEDataRelation().getCodeName();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u5173\u7cfb\u7ec4", fields={"PSDEDRID"})
    public IPSDEDataRelation getPSDEDataRelation() {
        return this.iPSDEDataRelation;
    }

    @Override
    @PSModelRTMeta(description="\u63d2\u5165\u4f4d\u7f6e", ignoredumpvalues="-1", fields={"INSERTPOS"}, ignorert=3)
    public int getInsertPos() {
        return this.nInsertPos;
    }
}

