/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.app.view.IPSAppDEView
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.app.view.IPSAppViewRef
 *  net.ibizsys.model.control.IPSAjaxControlParam
 *  net.ibizsys.model.control.IPSControlContainer
 *  net.ibizsys.model.control.IPSControlParam
 *  net.ibizsys.model.control.counter.IPSSysCounter
 *  net.ibizsys.model.control.counter.IPSSysCounterRef
 *  net.ibizsys.model.control.drctrl.IPSDEDRCtrl
 *  net.ibizsys.model.control.drctrl.IPSDEDRCtrlItem
 *  net.ibizsys.model.control.drctrl.IPSDEDRCtrlParam
 *  net.ibizsys.model.dataentity.dr.IPSDEDRDetail
 *  net.ibizsys.model.dataentity.dr.IPSDEDataRelation
 *  net.ibizsys.paas.control.drctrl.DRCtrlRootItem
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.control.drctrl;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.app.IPSApplicationRuntime;
import net.ibizsys.model.app.view.IPSAppDEView;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSAppViewRef;
import net.ibizsys.model.app.view.IPSAppViewRuntime;
import net.ibizsys.model.app.view.PSAppViewRefImpl;
import net.ibizsys.model.control.IPSAjaxControlParam;
import net.ibizsys.model.control.IPSControlContainer;
import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.control.PSAjaxControlContainerImpl;
import net.ibizsys.model.control.counter.IPSSysCounter;
import net.ibizsys.model.control.counter.IPSSysCounterRef;
import net.ibizsys.model.control.drctrl.IPSDEDRCtrl;
import net.ibizsys.model.control.drctrl.IPSDEDRCtrlItem;
import net.ibizsys.model.control.drctrl.IPSDEDRCtrlParam;
import net.ibizsys.model.dataentity.dr.IPSDEDRDetail;
import net.ibizsys.model.dataentity.dr.IPSDEDataRelation;
import net.ibizsys.model.entity.PSAppViewRef;
import net.ibizsys.paas.control.drctrl.DRCtrlRootItem;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;

public abstract class PSDEDRCtrlImpl
extends PSAjaxControlContainerImpl
implements IPSDEDRCtrl {
    protected IPSDEDataRelation iPSDEDataRelation = null;
    protected IPSDEDRCtrlParam iPSDEDRCtrlParam = null;
    protected ArrayList<IPSDEDRCtrlItem> psDEDRCtrlItemList = new ArrayList();
    protected DRCtrlRootItem drCtrlRootItem = new DRCtrlRootItem();
    private IPSSysCounterRef iPSSysCounterRef = null;
    private IPSSysCounter iPSSysCounter = null;
    private IPSAppView formPSAppView = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setPSControlContainer(iPSControlContainer);
        this.iPSDEDRCtrlParam = (IPSDEDRCtrlParam)iPSControlParam;
        IPSAppDEView iPSAppDEView = (IPSAppDEView)iPSControlContainer.getPSAppView();
        this.iPSDEDataRelation = iPSAppDEView.getPSDataEntity().getPSDEDataRelation(this.iPSDEDRCtrlParam.getPSDEDRId());
        this.setId(this.iPSDEDataRelation.getId());
        this.setName(strName);
        super.init(iPSModelStorageContext, iPSControlContainer, strName, iPSControlParam);
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (!StringHelper.isNullOrEmpty((String)this.iPSDEDataRelation.getFormPSDEViewBaseId())) {
            this.formPSAppView = ((IPSApplicationRuntime)this.getPSAppView().getPSApplication()).getPSAppViewByDEViewId(this.iPSDEDataRelation.getFormPSDEViewBaseId(), false);
        }
        this.setPSSysCounterRef(this.preparePSSysCounterRef());
        this.fillDRCtrlItems();
    }

    protected void fillDRCtrlItems() throws Exception {
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        super.fillRelatedPSAppViews(relatedAppViewList);
        if (this.getFormPSAppView() != null && StringHelper.compare((String)this.getFormPSAppView().getId(), (String)this.getPSAppView().getId(), (boolean)false) != 0) {
            relatedAppViewList.add(this.getFormPSAppView());
        }
        Iterator psDEDRDetails = this.iPSDEDataRelation.getPSDEDRDetails();
        while (psDEDRDetails.hasNext()) {
            IPSDEDRDetail iPSDEDRDetail = (IPSDEDRDetail)psDEDRDetails.next();
            if (StringHelper.isNullOrEmpty((String)iPSDEDRDetail.getPSDEViewId())) continue;
            String strPSAppViewId = KeyValueHelper.genUniqueId((String)this.getPSAppView().getPSApplication().getId(), (String)iPSDEDRDetail.getPSDEViewId());
            relatedAppViewList.add(((IPSApplicationRuntime)this.getPSAppView().getPSApplication()).getPSAppView(strPSAppViewId, iPSDEDRDetail.getPSDEViewId(), this.getPSAppView()));
        }
    }

    @Override
    public void fillEmbeddedPSAppViewRefs(String strContainerId, ArrayList<IPSAppViewRef> embeddedPSAppViewRefList) throws Exception {
        super.fillEmbeddedPSAppViewRefs(strContainerId, embeddedPSAppViewRefList);
        if (this.getFormPSAppView() != null && StringHelper.compare((String)this.getFormPSAppView().getId(), (String)this.getPSAppView().getId(), (boolean)false) != 0) {
            PSAppViewRefImpl psAppViewRefImpl = new PSAppViewRefImpl();
            PSAppViewRef psAppViewRef = new PSAppViewRef();
            psAppViewRefImpl.init(this.getPSModelStorageContext(), this.getPSAppView(), psAppViewRef);
            psAppViewRefImpl.setRefPSAppView(this.getFormPSAppView());
            String strFullViewId = "";
            String strViewId = "form";
            strFullViewId = StringHelper.isNullOrEmpty((String)strContainerId) ? strViewId : StringHelper.format((String)"%1$s_%2$s", (Object)strContainerId, (Object)strViewId);
            psAppViewRefImpl.setEmbedId(strFullViewId);
            embeddedPSAppViewRefList.add(psAppViewRefImpl);
        }
        for (IPSDEDRCtrlItem iPSDEDRCtrlItem : this.psDEDRCtrlItemList) {
            if (StringHelper.isNullOrEmpty((String)iPSDEDRCtrlItem.getEmbedViewId())) continue;
            IPSAppView refPSAppView = iPSDEDRCtrlItem.getPSAppView();
            PSAppViewRefImpl psAppViewRefImpl = new PSAppViewRefImpl();
            PSAppViewRef psAppViewRef = new PSAppViewRef();
            psAppViewRefImpl.init(this.getPSModelStorageContext(), this.getPSAppView(), psAppViewRef);
            psAppViewRefImpl.setRefPSAppView(refPSAppView);
            String strFullViewId = "";
            strFullViewId = StringHelper.isNullOrEmpty((String)strContainerId) ? iPSDEDRCtrlItem.getEmbedViewId() : StringHelper.format((String)"%1$s_%2$s", (Object)strContainerId, (Object)iPSDEDRCtrlItem.getEmbedViewId());
            psAppViewRefImpl.setEmbedId(strFullViewId);
            embeddedPSAppViewRefList.add(psAppViewRefImpl);
            Iterator childPSAppViewRefs = refPSAppView.getEmbeddedPSAppViewRefs(strFullViewId);
            if (childPSAppViewRefs == null) continue;
            while (childPSAppViewRefs.hasNext()) {
                embeddedPSAppViewRefList.add((IPSAppViewRef)childPSAppViewRefs.next());
            }
        }
    }

    @Override
    public IPSAjaxControlParam getPSAjaxControlParam() {
        return this.iPSDEDRCtrlParam;
    }

    @PSModelRTMeta(description="\u5173\u7cfb\u9879\u96c6\u5408")
    public Iterator<IPSDEDRCtrlItem> getPSDEDRCtrlItems() {
        return this.psDEDRCtrlItemList.iterator();
    }

    public int getPSDEDRCtrlItemCount() {
        return this.psDEDRCtrlItemList.size();
    }

    public DRCtrlRootItem getRootItem() {
        return this.drCtrlRootItem;
    }

    public boolean isIncludeMajor() {
        return !this.isHideEditItem();
    }

    protected IPSSysCounterRef preparePSSysCounterRef() throws Exception {
        String strPSSysCounterId = this.iPSDEDRCtrlParam.getPSSysCounterId();
        if (StringHelper.isNullOrEmpty((String)strPSSysCounterId)) {
            strPSSysCounterId = this.iPSDEDataRelation.getPSSysCounterId();
        }
        if (!StringHelper.isNullOrEmpty((String)strPSSysCounterId)) {
            this.iPSSysCounter = this.getPSAppView().getPSApplication().getPSSystem().getPSSysCounter(strPSSysCounterId, false);
        }
        if (this.iPSSysCounter != null) {
            ObjectNode refModeObj = JsonNodeHelper.createObjectNode();
            if (this.getPSDataEntity() != null) {
                refModeObj.put("srfdeid", this.getPSDataEntity().getName());
            }
            return ((IPSAppViewRuntime)this.getPSAppView()).registerPSSysCounter(this.iPSSysCounter, refModeObj);
        }
        return null;
    }

    @PSModelRTMeta(description="\u7cfb\u7edf\u8ba1\u6570\u5668\u5f15\u7528")
    public IPSSysCounterRef getPSSysCounterRef() {
        return this.iPSSysCounterRef;
    }

    protected void setPSSysCounterRef(IPSSysCounterRef iPSSysCounterRef) {
        this.iPSSysCounterRef = iPSSysCounterRef;
    }

    @PSModelRTMeta(description="\u8868\u5355\u89c6\u56fe\u5bf9\u8c61")
    public IPSAppView getFormPSAppView() {
        return this.formPSAppView;
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u5173\u7cfb\u754c\u9762\u7ec4")
    public IPSDEDataRelation getPSDEDataRelation() {
        return this.iPSDEDataRelation;
    }

    @PSModelRTMeta(description="\u662f\u5426\u9690\u85cf\u7f16\u8f91\u9879")
    public boolean isHideEditItem() {
        return this.getPSDEDataRelation().isHideEditItem();
    }
}

