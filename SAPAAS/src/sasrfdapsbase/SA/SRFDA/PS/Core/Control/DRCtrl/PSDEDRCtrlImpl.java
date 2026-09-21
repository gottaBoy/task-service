/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.control.drctrl.DRCtrlRootItem
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.Control.DRCtrl;

import SA.SRFDA.PS.Core.App.Control.IPSAppCounter;
import SA.SRFDA.PS.Core.App.Control.IPSAppCounterRef;
import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.App.View.PSAppViewRefImpl;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounterRef;
import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRCtrl;
import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRCtrlItem;
import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRCtrlParam;
import SA.SRFDA.PS.Core.Control.IPSAjaxControlParam;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.IPSControlParamRuntime;
import SA.SRFDA.PS.Core.Control.PSAjaxControlContainerImpl;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRDetail;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDataRelation;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Data.PSAppViewRef;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.control.drctrl.DRCtrlRootItem;
import net.sf.json.JSONObject;

public class PSDEDRCtrlImpl
extends PSAjaxControlContainerImpl
implements IPSDEDRCtrl {
    protected IPSDEDataRelation iPSDEDataRelation = null;
    protected IPSDEDRCtrlParam iPSDEDRCtrlParam = null;
    protected ArrayList<IPSDEDRCtrlItem> psDEDRCtrlItemList = new ArrayList();
    protected DRCtrlRootItem drCtrlRootItem = new DRCtrlRootItem();
    private IPSSysCounterRef iPSSysCounterRef = null;
    private IPSAppCounter iPSSysCounter = null;
    private IPSAppView formPSAppView = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSControlContainer(iPSControlContainer);
        this.iPSDEDRCtrlParam = (IPSDEDRCtrlParam)iPSControlParam;
        if (StringHelper.IsNullOrEmpty((String)this.iPSDEDRCtrlParam.getPSDEDRId())) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u6570\u636e\u5173\u7cfb\u754c\u9762\u7ec4");
        }
        IPSAppDEView iPSAppDEView = (IPSAppDEView)iPSControlContainer.getPSAppView();
        this.iPSDEDataRelation = iPSAppDEView.getPSDataEntity().getPSDEDataRelation(this.iPSDEDRCtrlParam.getPSDEDRId());
        if (StringHelper.IsNullOrEmpty((String)iPSControlParam.getPSDEUILogicGroupId()) && !StringHelper.IsNullOrEmpty((String)this.iPSDEDataRelation.getPSDEUILogicGroupId())) {
            ((IPSControlParamRuntime)((Object)iPSControlParam)).setPSDEUILogicGroupId(this.iPSDEDataRelation.getPSDEUILogicGroupId());
        }
        this.setId(this.iPSDEDataRelation.getId());
        this.setName(strName);
        super.init(iDAGlobalHelper, iPSControlContainer, strName, iPSControlParam);
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (this.getEditItemCapPSLanguageRes() != null) {
            this.getPSAppView().getPSApplication().getPSLanguageRes(this.getEditItemCapPSLanguageRes().getId());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.iPSDEDataRelation.getFormPSDEViewBaseId())) {
            this.formPSAppView = this.getPSAppView().getPSApplication().getPSAppViewByDEViewId(this.iPSDEDataRelation.getFormPSDEViewBaseId(), false);
        }
        this.setPSSysCounterRef(this.preparePSSysCounterRef());
        this.fillDRCtrlItems();
    }

    protected void fillDRCtrlItems() throws Exception {
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    @Override
    protected String onGetCodeName() {
        return this.getPSApplication().getViewCodeName(null, this.iPSDEDataRelation.getCodeName(), null);
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        super.fillRelatedPSAppViews(relatedAppViewList);
        if (this.getFormPSAppView() != null && StringHelper.Compare((String)this.getFormPSAppView().getId(), (String)this.getPSAppView().getId(), (boolean)false) != 0) {
            relatedAppViewList.add(this.getFormPSAppView());
        }
        Iterator<IPSDEDRDetail> psDEDRDetails = this.iPSDEDataRelation.getPSDEDRDetails();
        while (psDEDRDetails.hasNext()) {
            IPSDEDRDetail iPSDEDRDetail = psDEDRDetails.next();
            if (StringHelper.IsNullOrEmpty((String)iPSDEDRDetail.getPSDEViewId())) continue;
            String strPSAppViewId = Helper.GenUniqueId((String)this.getPSAppView().getPSApplication().getId(), (String)iPSDEDRDetail.getPSDEViewId());
            relatedAppViewList.add(this.getPSAppView().getPSApplication().getPSAppView(strPSAppViewId, iPSDEDRDetail.getPSDEViewId(), this.getPSAppView()));
        }
    }

    @Override
    public void fillEmbeddedPSAppViewRefs(String strContainerId, ArrayList<IPSAppViewRef> embeddedPSAppViewRefList) throws Exception {
        super.fillEmbeddedPSAppViewRefs(strContainerId, embeddedPSAppViewRefList);
        if (this.getFormPSAppView() != null && StringHelper.Compare((String)this.getFormPSAppView().getId(), (String)this.getPSAppView().getId(), (boolean)false) != 0) {
            PSAppViewRefImpl psAppViewRefImpl = new PSAppViewRefImpl();
            PSAppViewRef psAppViewRef = new PSAppViewRef();
            psAppViewRefImpl.init(this.getDAGlobalHelper(), this.getPSAppView(), psAppViewRef);
            psAppViewRefImpl.setRefPSAppView(this.getFormPSAppView());
            String strFullViewId = "";
            String strViewId = "form";
            strFullViewId = StringHelper.IsNullOrEmpty((String)strContainerId) ? strViewId : StringHelper.Format((String)"%1$s_%2$s", (Object)strContainerId, (Object)strViewId);
            psAppViewRefImpl.setEmbedId(strFullViewId);
            embeddedPSAppViewRefList.add(psAppViewRefImpl);
        }
        for (IPSDEDRCtrlItem iPSDEDRCtrlItem : this.psDEDRCtrlItemList) {
            if (StringHelper.IsNullOrEmpty((String)iPSDEDRCtrlItem.getEmbedViewId())) continue;
            IPSAppView refPSAppView = iPSDEDRCtrlItem.getPSAppView();
            PSAppViewRefImpl psAppViewRefImpl = new PSAppViewRefImpl();
            PSAppViewRef psAppViewRef = new PSAppViewRef();
            psAppViewRefImpl.init(this.getDAGlobalHelper(), this.getPSAppView(), psAppViewRef);
            psAppViewRefImpl.setRefPSAppView(refPSAppView);
            String strFullViewId = "";
            strFullViewId = StringHelper.IsNullOrEmpty((String)strContainerId) ? iPSDEDRCtrlItem.getEmbedViewId() : StringHelper.Format((String)"%1$s_%2$s", (Object)strContainerId, (Object)iPSDEDRCtrlItem.getEmbedViewId());
            psAppViewRefImpl.setEmbedId(strFullViewId);
            embeddedPSAppViewRefList.add(psAppViewRefImpl);
            Iterator<IPSAppViewRef> childPSAppViewRefs = refPSAppView.getEmbeddedPSAppViewRefs(strFullViewId);
            if (childPSAppViewRefs == null) continue;
            while (childPSAppViewRefs.hasNext()) {
                embeddedPSAppViewRefList.add(childPSAppViewRefs.next());
            }
        }
    }

    @Override
    public IPSAjaxControlParam getPSAjaxControlParam() {
        return this.iPSDEDRCtrlParam;
    }

    @Override
    public String getModelScope() {
        return "DE";
    }

    @Override
    @PSModelRTMeta(description="\u5173\u7cfb\u9879\u96c6\u5408", child=true)
    public Iterator<IPSDEDRCtrlItem> getPSDEDRCtrlItems() {
        return this.psDEDRCtrlItemList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5173\u7cfb\u9879\u6570\u91cf", dump=false)
    public int getPSDEDRCtrlItemCount() {
        return this.psDEDRCtrlItemList.size();
    }

    @Override
    public DRCtrlRootItem getRootItem() {
        return this.drCtrlRootItem;
    }

    @Override
    public boolean isIncludeMajor() {
        return !this.isHideEditItem();
    }

    protected IPSSysCounterRef preparePSSysCounterRef() throws Exception {
        String strPSSysCounterId = this.iPSDEDRCtrlParam.getPSSysCounterId();
        if (StringHelper.IsNullOrEmpty((String)strPSSysCounterId)) {
            strPSSysCounterId = this.iPSDEDataRelation.getPSSysCounterId();
        }
        if (!StringHelper.IsNullOrEmpty((String)strPSSysCounterId)) {
            this.iPSSysCounter = this.getPSAppView().getPSApplication().getPSAppCounter(strPSSysCounterId, false);
        }
        if (this.iPSSysCounter != null) {
            JSONObject refModeObj = new JSONObject();
            if (this.getPSDataEntity() != null) {
                refModeObj.put("srfdeid", (Object)this.getPSDataEntity().getName());
            }
            if (this.isPrepareDefaultPSAppViewLogics()) {
                return this.registerPSAppCounter(this.iPSSysCounter, refModeObj);
            }
            return this.getPSAppView().registerPSSysCounter(this.iPSSysCounter, refModeObj);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u8ba1\u6570\u5668\u5f15\u7528", hideempty=true)
    public IPSSysCounterRef getPSSysCounterRef() {
        return this.iPSSysCounterRef;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u8ba1\u6570\u5668\u5f15\u7528", hideempty=true, dumpref=true)
    public IPSAppCounterRef getPSAppCounterRef() {
        if (this.getPSSysCounterRef() != null && this.getPSSysCounterRef() instanceof IPSAppCounterRef) {
            return (IPSAppCounterRef)this.getPSSysCounterRef();
        }
        return null;
    }

    protected void setPSSysCounterRef(IPSSysCounterRef iPSSysCounterRef) {
        this.iPSSysCounterRef = iPSSysCounterRef;
    }

    @Override
    @PSModelRTMeta(description="\u8868\u5355\u89c6\u56fe\u5bf9\u8c61", dumpref=true, model="PSDEDataRelation", fields={"FORMPSDEVIEWBASEID"})
    public IPSAppView getFormPSAppView() {
        return this.formPSAppView;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5173\u7cfb\u754c\u9762\u7ec4")
    public IPSDEDataRelation getPSDEDataRelation() {
        return this.iPSDEDataRelation;
    }

    @Override
    @PSModelRTMeta(description="\u9690\u85cf\u7f16\u8f91\u9879", ignoredumpvalues="false", model="PSDEDataRelation", fields={"HIDEEDITITEM"})
    public boolean isHideEditItem() {
        return this.getPSDEDataRelation().isHideEditItem();
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u9879\u6807\u9898", model="PSDEDataRelation", fields={"FORMCAPTION"})
    public String getEditItemCaption() {
        return this.getPSDEDataRelation().getFormCaption();
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u9879\u6807\u9898\u8bed\u8a00\u8d44\u6e90", model="PSDEDataRelation", fields={"FORMCAPPSLANRESID"})
    public IPSLanguageRes getEditItemCapPSLanguageRes() {
        return this.getPSDEDataRelation().getFormCapPSLanguageRes();
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u9879\u56fe\u6807", model="PSDEDataRelation", fields={"FORMPSSYSIMAGEID"})
    public IPSSysImage getEditItemPSSysImage() {
        return this.getPSDEDataRelation().getFormPSSysImage();
    }

    @Override
    protected boolean isExportModelAlways() {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u5bf9\u8c61\u5f15\u7528", child=false)
    public Iterator<IPSAppViewRef> getPSAppViewRefs() {
        return super.getPSAppViewRefs();
    }

    @Override
    @PSModelRTMeta(description="\u5168\u5c40\u552f\u4e00\u6807\u8bb0")
    public String getUniqueTag() {
        if (this.getPSAppView() != null && !StringHelper.IsNullOrEmpty((String)this.getName())) {
            return String.format("%1$s__%2$s", this.getPSAppView().getCodeName(), this.getName());
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u5173\u7cfb\u6807\u8bb0", fields={"DRTAG"})
    public String getDataRelationTag() {
        if (this.getPSDEDataRelation() != null) {
            return this.getPSDEDataRelation().getCodeName();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u81ea\u5b9a\u4e49\u5173\u7cfb\u9879", ignoredumpvalues="false")
    public boolean isEnableCustomized() {
        if (this.getPSDEDataRelation() != null) {
            return this.getPSDEDataRelation().isEnableCustomized();
        }
        return false;
    }
}

