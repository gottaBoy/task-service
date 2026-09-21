/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFFormItem;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Control.Form.PSLinkDEFFormItemImpl;
import SA.SRFDA.PS.Core.DEField.IPSDEFUIMode;
import SA.SRFDA.PS.Core.DEField.IPSInheritDEField;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFramework.Utility.StringHelper;
import net.sf.json.JSONObject;

public class PSInheritDEFFormItemImpl
extends PSLinkDEFFormItemImpl {
    protected IPSInheritDEField iPSInheritDEField = null;
    protected IPSDEFFormItem inheritPSDEFFormItem = null;

    @Override
    protected void onInit() throws Exception {
        this.iPSInheritDEField = (IPSInheritDEField)this.getPSDEField();
        if (this.iPSInheritDEField == null) {
            throw new Exception(StringHelper.Format((String)"\u7ee7\u627f\u5c5e\u6027[%1$s]\u65e0\u6548", (Object)this.getPSDEField().getFullName()));
        }
        IPSDEFUIMode iPSDEFUIMode = null;
        if (StringHelper.Compare((String)this.getUIMode(), (String)"CUSTOM", (boolean)false) != 0) {
            iPSDEFUIMode = this.iPSInheritDEField.getRealInheritPSDEField().getPSDEFUIMode(this.getUIMode(), true);
        }
        if (iPSDEFUIMode != null) {
            this.inheritPSDEFFormItem = iPSDEFUIMode.getPSDEFFormItem();
        }
        if (this.inheritPSDEFFormItem == null) {
            this.inheritPSDEFFormItem = this.iPSInheritDEField.getRealInheritPSDEField().getPSDEFUIMode("DEFAULT").getPSDEFFormItem();
        }
        super.onInit();
    }

    @Override
    public String getRefPSDEId() {
        String strRefPSDEId = super.getRefPSDEId();
        if (StringHelper.IsNullOrEmpty((String)strRefPSDEId)) {
            return this.inheritPSDEFFormItem.getRefPSDEId();
        }
        return strRefPSDEId;
    }

    @Override
    public String getRefPSDEACModeId() {
        String strRefPSDEACModeId = super.getRefPSDEACModeId();
        if (StringHelper.IsNullOrEmpty((String)strRefPSDEACModeId)) {
            return this.inheritPSDEFFormItem.getRefPSDEACModeId();
        }
        return strRefPSDEACModeId;
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u7c7b\u578b", order=292)
    public String getEditorType() {
        String strEditorType = super.getEditorType();
        if (StringHelper.IsNullOrEmpty((String)strEditorType)) {
            return this.inheritPSDEFFormItem.getEditorType();
        }
        return strEditorType;
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u6837\u5f0f", order=293)
    public String getEditorStyle() {
        String strEditorStyle = super.getEditorStyle();
        if (StringHelper.IsNullOrEmpty((String)strEditorStyle)) {
            return this.inheritPSDEFFormItem.getEditorStyle();
        }
        return strEditorStyle;
    }

    @Override
    public String getItemHandlerType(IPSDEFormItem iPSDEFormItem) {
        String strItemHandlerType = super.getItemHandlerType(iPSDEFormItem);
        if (StringHelper.IsNullOrEmpty((String)strItemHandlerType)) {
            return this.inheritPSDEFFormItem.getItemHandlerType(iPSDEFormItem);
        }
        return strItemHandlerType;
    }

    @Override
    public JSONObject getItemParam(IPSDEFormItem iPSDEFormItem) throws Exception {
        JSONObject itemParam = super.getItemParam(iPSDEFormItem);
        if (itemParam == null) {
            return this.inheritPSDEFFormItem.getItemParam(iPSDEFormItem);
        }
        return itemParam;
    }

    @Override
    public String getValueItemName(IPSDEFormItem iPSDEFormItem) {
        String strValueItemName = super.getValueItemName(iPSDEFormItem);
        if (StringHelper.IsNullOrEmpty((String)strValueItemName)) {
            return this.inheritPSDEFFormItem.getValueItemName(iPSDEFormItem);
        }
        return strValueItemName;
    }

    @Override
    public String getRefPickupPSDEViewId() {
        String strRefPickupPSDEViewId = super.getRefPickupPSDEViewId();
        if (StringHelper.IsNullOrEmpty((String)strRefPickupPSDEViewId)) {
            return this.inheritPSDEFFormItem.getRefPickupPSDEViewId();
        }
        return strRefPickupPSDEViewId;
    }

    @Override
    public String getRefPickupPSDEViewName() {
        String strRefPickupPSDEViewName = super.getRefPickupPSDEViewName();
        if (StringHelper.IsNullOrEmpty((String)strRefPickupPSDEViewName)) {
            return this.inheritPSDEFFormItem.getRefPickupPSDEViewName();
        }
        return strRefPickupPSDEViewName;
    }

    @Override
    public String getRefMPickupPSDEViewId() {
        String strRefMPickupPSDEViewId = super.getRefMPickupPSDEViewId();
        if (StringHelper.IsNullOrEmpty((String)strRefMPickupPSDEViewId)) {
            return this.inheritPSDEFFormItem.getRefMPickupPSDEViewId();
        }
        return strRefMPickupPSDEViewId;
    }

    @Override
    public String getRefMPickupPSDEViewName() {
        String strRefMPickupPSDEViewName = super.getRefMPickupPSDEViewName();
        if (StringHelper.IsNullOrEmpty((String)strRefMPickupPSDEViewName)) {
            return this.inheritPSDEFFormItem.getRefMPickupPSDEViewName();
        }
        return strRefMPickupPSDEViewName;
    }

    @Override
    public String getRefLinkPSDEViewId() {
        String strRefLinkPSDEViewId = super.getRefLinkPSDEViewId();
        if (StringHelper.IsNullOrEmpty((String)strRefLinkPSDEViewId)) {
            return this.inheritPSDEFFormItem.getRefLinkPSDEViewId();
        }
        return strRefLinkPSDEViewId;
    }

    @Override
    public String getRefLinkPSDEViewName() {
        String strRefLinkPSDEViewName = super.getRefLinkPSDEViewName();
        if (StringHelper.IsNullOrEmpty((String)strRefLinkPSDEViewName)) {
            return this.inheritPSDEFFormItem.getRefLinkPSDEViewName();
        }
        return strRefLinkPSDEViewName;
    }

    @Override
    public String getRefPSDEDataSetId() {
        String strRefPSDEDataSetId = super.getRefPSDEDataSetId();
        if (StringHelper.IsNullOrEmpty((String)strRefPSDEDataSetId)) {
            return this.inheritPSDEFFormItem.getRefPSDEDataSetId();
        }
        return strRefPSDEDataSetId;
    }

    @Override
    public String getRefLinkPSDEViewId(IPSApplication iPSApplication) throws Exception {
        String strRefLinkPSDEViewId = super.getRefLinkPSDEViewId(iPSApplication);
        if (!StringHelper.IsNullOrEmpty((String)strRefLinkPSDEViewId)) {
            return strRefLinkPSDEViewId;
        }
        return this.inheritPSDEFFormItem.getRefLinkPSDEViewId(iPSApplication);
    }

    @Override
    public String getRefMPickupPSDEViewId(IPSApplication iPSApplication) throws Exception {
        String strRefMPickupPSDEViewId = super.getRefMPickupPSDEViewId(iPSApplication);
        if (!StringHelper.IsNullOrEmpty((String)strRefMPickupPSDEViewId)) {
            return strRefMPickupPSDEViewId;
        }
        return this.inheritPSDEFFormItem.getRefMPickupPSDEViewId(iPSApplication);
    }

    @Override
    public String getRefPickupPSDEViewId(IPSApplication iPSApplication) throws Exception {
        String strRefPickupPSDEViewId = super.getRefPickupPSDEViewId(iPSApplication);
        if (!StringHelper.IsNullOrEmpty((String)strRefPickupPSDEViewId)) {
            return strRefPickupPSDEViewId;
        }
        return this.inheritPSDEFFormItem.getRefPickupPSDEViewId(iPSApplication);
    }
}

