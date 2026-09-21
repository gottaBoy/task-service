/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.app.view.IPSAppViewRef
 *  net.ibizsys.model.control.form.IPSDEFormDRUIPart
 *  net.ibizsys.model.control.form.IPSDEFormItem
 *  net.ibizsys.model.control.form.IPSDEFormItemUpdate
 *  net.ibizsys.model.dataentity.dr.IPSDEDRItem
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.control.form;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.app.IPSApplicationRuntime;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSAppViewRef;
import net.ibizsys.model.app.view.IPSAppViewRuntime;
import net.ibizsys.model.app.view.PSAppViewRefImpl;
import net.ibizsys.model.control.form.IPSDEFormDRUIPart;
import net.ibizsys.model.control.form.IPSDEFormItem;
import net.ibizsys.model.control.form.IPSDEFormItemUpdate;
import net.ibizsys.model.control.form.PSDEFormDetailImpl;
import net.ibizsys.model.dataentity.dr.IPSDEDRItem;
import net.ibizsys.model.entity.PSAppViewRef;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;

public class PSDEFormDRUIPartImpl
extends PSDEFormDetailImpl
implements IPSDEFormDRUIPart {
    private IPSDEDRItem iPSDEDRItem = null;
    private IPSAppView iPSAppView = null;
    private String strEmbedViewId = null;
    private String strRefreshItems = null;
    private int nRefreshAction = 3;

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.psDEFormDetail.getRESETITEMNAME())) {
            this.strRefreshItems = this.psDEFormDetail.getRESETITEMNAME();
        }
        if (!this.psDEFormDetail.isBUILDINACTIONNull()) {
            this.nRefreshAction = 0;
            int nIgnoreRefreshAction = this.psDEFormDetail.getBUILDINACTION();
            if ((nIgnoreRefreshAction & 1) == 0) {
                this.nRefreshAction |= 1;
            }
            if ((nIgnoreRefreshAction & 2) == 0) {
                this.nRefreshAction |= 2;
            }
        } else {
            this.nRefreshAction = 3;
        }
        super.onInit();
        this.iPSDEDRItem = this.getPSDEForm().getPSDataEntity().getPSDEDRItem(this.psDEFormDetail.getPSDEDRITEMID());
        if (!StringHelper.isNullOrEmpty((String)this.iPSDEDRItem.getPSDEViewId())) {
            try {
                String strPSAppViewId = KeyValueHelper.genUniqueId((String)this.getPSDEForm().getPSAppView().getPSApplication().getId(), (String)this.iPSDEDRItem.getPSDEViewId());
                this.iPSAppView = ((IPSApplicationRuntime)this.getPSDEForm().getPSAppView().getPSApplication()).getPSAppView(strPSAppViewId, this.iPSDEDRItem.getPSDEViewId(), this.getPSDEForm().getPSAppView());
                this.strEmbedViewId = ((IPSAppViewRuntime)this.getPSDEForm().getPSAppView()).generateViewUniId();
                ((IPSAppViewRuntime)this.iPSAppView).markViewUsage(4, this);
            }
            catch (Exception ex) {
                throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u5173\u7cfb\u754c\u9762\u9879[%1$s]\u5e94\u7528\u89c6\u56fe\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)this.iPSDEDRItem.getName(), (Object)ex.getMessage()), ex);
            }
        }
    }

    @Override
    public void fillPSDEFormItems(ArrayList<IPSDEFormItem> psDEFormItemList) {
    }

    public IPSDEDRItem getPSDEDRItem() {
        return this.iPSDEDRItem;
    }

    public IPSAppView getPSAppView() {
        return this.iPSAppView;
    }

    public String getEmbedViewId() {
        return this.strEmbedViewId;
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        super.fillRelatedPSAppViews(relatedAppViewList);
        if (this.iPSAppView != null) {
            relatedAppViewList.add(this.iPSAppView);
        }
    }

    @Override
    public void fillPSDEFormDRUIParts(ArrayList<IPSDEFormDRUIPart> psDEFormDRUIPartList) {
        psDEFormDRUIPartList.add(this);
    }

    @Override
    public void fillEmbeddedPSAppViewRefs(String strContainerId, ArrayList<IPSAppViewRef> embeddedPSAppViewRefList) throws Exception {
        super.fillEmbeddedPSAppViewRefs(strContainerId, embeddedPSAppViewRefList);
        if (StringHelper.isNullOrEmpty((String)this.getEmbedViewId())) {
            return;
        }
        IPSAppView refPSAppView = this.getPSAppView();
        PSAppViewRefImpl psAppViewRefImpl = new PSAppViewRefImpl();
        PSAppViewRef psAppViewRef = new PSAppViewRef();
        psAppViewRefImpl.init(this.getPSModelStorageContext(), this.getPSAppView(), psAppViewRef);
        psAppViewRefImpl.setRefPSAppView(refPSAppView);
        String strFullViewId = "";
        strFullViewId = StringHelper.isNullOrEmpty((String)strContainerId) ? this.getEmbedViewId() : StringHelper.format((String)"%1$s_%2$s", (Object)strContainerId, (Object)this.getEmbedViewId());
        psAppViewRefImpl.setEmbedId(strFullViewId);
        embeddedPSAppViewRefList.add(psAppViewRefImpl);
        Iterator childPSAppViewRefs = refPSAppView.getEmbeddedPSAppViewRefs(strFullViewId);
        if (childPSAppViewRefs != null) {
            while (childPSAppViewRefs.hasNext()) {
                embeddedPSAppViewRefList.add((IPSAppViewRef)childPSAppViewRefs.next());
            }
        }
    }

    @PSModelRTMeta(description="\u754c\u9762\u5237\u65b0\u89e6\u53d1\u8868\u5355\u9879")
    public String getRefreshItems() {
        return this.strRefreshItems;
    }

    public String getPSDEFIUpdateId() {
        return this.psDEFormDetail.getPSDEFIUPDATEID();
    }

    public IPSDEFormItemUpdate getPSDEFormItemUpdate() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.getPSDEFIUpdateId())) {
            return null;
        }
        return this.getPSDEForm().getPSDEFormItemUpdate(this.getPSDEFIUpdateId());
    }

    public int getRefreshActions() {
        return this.nRefreshAction;
    }

    public boolean isEnableRefreshAction(int nAction) {
        return (this.getRefreshActions() & nAction) == nAction;
    }

    @PSModelRTMeta(description="\u754c\u9762\u53c2\u6570\u9879\u540d\u79f0")
    public String getParamItem() {
        String strValueItemName = this.psDEFormDetail.getVALUEITEMNAME();
        if (StringHelper.isNullOrEmpty((String)strValueItemName)) {
            return null;
        }
        return strValueItemName;
    }

    @PSModelRTMeta(description="\u9700\u8981\u8fdb\u884c\u4fdd\u5b58")
    public boolean isNeedSave() {
        if (this.psDEFormDetail.isWBDEFMODENull()) {
            return false;
        }
        return this.psDEFormDetail.getWBDEFMODE() == 1;
    }
}

