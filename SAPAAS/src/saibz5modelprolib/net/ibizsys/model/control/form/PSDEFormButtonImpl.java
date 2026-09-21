/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.control.form.IPSDEFormButton
 *  net.ibizsys.model.control.form.IPSDEFormItem
 *  net.ibizsys.model.control.form.IPSDEFormItemUpdate
 *  net.ibizsys.model.dataentity.uiaction.IPSDEUIAction
 *  net.ibizsys.model.view.IPSUIAction
 *  net.ibizsys.model.wf.uiaction.IPSWFUIAction
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.control.form;

import java.util.ArrayList;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.app.IPSApplicationRuntime;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSAppViewRuntime;
import net.ibizsys.model.control.form.IPSDEFormButton;
import net.ibizsys.model.control.form.IPSDEFormItem;
import net.ibizsys.model.control.form.IPSDEFormItemUpdate;
import net.ibizsys.model.control.form.PSDEFormDetailImpl;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIAction;
import net.ibizsys.model.view.IPSUIAction;
import net.ibizsys.model.wf.uiaction.IPSWFUIAction;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;

public class PSDEFormButtonImpl
extends PSDEFormDetailImpl
implements IPSDEFormButton {
    private String strButtonActionType = "";
    private String strPSDEUIActonId = "";
    private IPSDEUIAction iPSDEUIAction = null;
    private IPSDEFormItemUpdate iPSDEFormItemUpdate = null;
    private String strPSDEFIUpdateId = "";
    private IPSWFUIAction iPSWFUIAction = null;
    private String strTooltip = null;

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.psDEFormDetail.getBTNACTIONTYPE())) {
            this.strButtonActionType = this.psDEFormDetail.getBTNACTIONTYPE();
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDEFormDetail.getPSDEUIACTIONID())) {
            this.strPSDEUIActonId = this.psDEFormDetail.getPSDEUIACTIONID();
            this.iPSDEUIAction = this.getPSDEForm().getPSDataEntity().getPSDEUIAction(this.strPSDEUIActonId);
            if (this.iPSDEUIAction instanceof IPSWFUIAction) {
                this.iPSWFUIAction = (IPSWFUIAction)this.iPSDEUIAction;
            }
            ((IPSAppViewRuntime)this.getPSDEForm().getPSAppView()).registerPSUIAction((IPSUIAction)this.iPSDEUIAction);
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDEFormDetail.getPSDEFIUPDATEID())) {
            this.strPSDEFIUpdateId = this.psDEFormDetail.getPSDEFIUPDATEID();
            this.iPSDEFormItemUpdate = this.getPSDEForm().getPSDEFormItemUpdate(this.strPSDEFIUpdateId);
        }
        super.onInit();
    }

    @Override
    protected void onCheckModel() throws Exception {
        if (StringHelper.compare((String)this.getActionType(), (String)"UIACTION", (boolean)true) == 0) {
            if (this.getPSUIAction() == null) {
                throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u6309\u94ae\u8c03\u7528\u7684\u754c\u9762\u884c\u4e3a"));
            }
        } else if (StringHelper.compare((String)this.getActionType(), (String)"FIUPDATE", (boolean)true) == 0 && this.getPSDEFormItemUpdate() == null) {
            throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u6309\u94ae\u8c03\u7528\u7684\u8868\u5355\u9879\u66f4\u65b0"));
        }
        super.onCheckModel();
    }

    @Override
    public void fillPSDEFormItems(ArrayList<IPSDEFormItem> psDEFormItemList) {
    }

    @PSModelRTMeta(description="\u6309\u94ae\u884c\u4e3a\u7c7b\u578b", codelist="FormButtonActionType")
    public String getActionType() {
        return this.strButtonActionType;
    }

    @PSModelRTMeta(description="\u8c03\u7528\u754c\u9762\u884c\u4e3a", hideempty=true)
    public IPSUIAction getPSUIAction() {
        return this.iPSDEUIAction;
    }

    public String getPSUIActionId() {
        return this.strPSDEUIActonId;
    }

    public String getPSDEFIUpdateId() {
        return this.strPSDEFIUpdateId;
    }

    @PSModelRTMeta(description="\u8c03\u7528\u8868\u5355\u9879\u66f4\u65b0", hideempty=true)
    public IPSDEFormItemUpdate getPSDEFormItemUpdate() {
        return this.iPSDEFormItemUpdate;
    }

    public IPSDEUIAction getPSDEUIAction() {
        return this.iPSDEUIAction;
    }

    public IPSWFUIAction getPSWFUIAction() {
        return this.iPSWFUIAction;
    }

    @PSModelRTMeta(description="\u64cd\u4f5c\u63d0\u793a\u4fe1\u606f")
    public String getTooltip() {
        if (StringHelper.isNullOrEmpty((String)this.strTooltip)) {
            return this.getCaption();
        }
        return this.strTooltip;
    }

    public IPSAppView getParamPickupPSAppView() throws Exception {
        String strPickupPSDEViewId = this.psDEFormDetail.getPICKUPPSDEVIEWID();
        if (!StringHelper.isNullOrEmpty((String)strPickupPSDEViewId)) {
            String strPSAppViewId = KeyValueHelper.genUniqueId((String)this.getPSDEForm().getPSAppView().getPSApplication().getId(), (String)strPickupPSDEViewId);
            return ((IPSApplicationRuntime)this.getPSDEForm().getPSAppView().getPSApplication()).getPSAppView(strPSAppViewId, strPickupPSDEViewId, this.getPSDEForm().getPSAppView());
        }
        return null;
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        super.fillRelatedPSAppViews(relatedAppViewList);
        IPSAppView iPSAppView = this.getParamPickupPSAppView();
        if (iPSAppView != null) {
            relatedAppViewList.add(iPSAppView);
        }
    }

    @Override
    protected String onGetCaption() {
        if (this.getPSUIAction() != null) {
            return this.getPSUIAction().getCaption();
        }
        return super.onGetCaption();
    }
}

