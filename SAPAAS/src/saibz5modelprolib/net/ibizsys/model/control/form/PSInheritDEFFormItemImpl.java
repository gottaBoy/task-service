/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.control.form.IPSDEFFormItem
 *  net.ibizsys.model.control.form.IPSDEFormItem
 *  net.ibizsys.model.dataentity.field.IPSInheritDEField
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.control.form;

import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.control.form.IPSDEFFormItem;
import net.ibizsys.model.control.form.IPSDEFormItem;
import net.ibizsys.model.control.form.PSLinkDEFFormItemImpl;
import net.ibizsys.model.dataentity.field.IPSInheritDEField;
import net.ibizsys.paas.util.StringHelper;

public class PSInheritDEFFormItemImpl
extends PSLinkDEFFormItemImpl {
    protected IPSInheritDEField iPSInheritDEField = null;
    protected IPSDEFFormItem inheritPSDEFFormItem = null;

    @Override
    protected void onInit() throws Exception {
        this.iPSInheritDEField = (IPSInheritDEField)this.getPSDEField();
        if (this.iPSInheritDEField == null) {
            throw new Exception(StringHelper.format((String)"\u7ee7\u627f\u5c5e\u6027[%1$s]\u65e0\u6548", (Object)this.getPSDEField().getName()));
        }
        this.inheritPSDEFFormItem = this.iPSInheritDEField.getRealInheritPSDEField().getPSDEFUIMode("DEFAULT").getPSDEFFormItem();
        super.onInit();
    }

    @Override
    public String getRefPSDEId() {
        String strRefPSDEId = super.getRefPSDEId();
        if (StringHelper.isNullOrEmpty((String)strRefPSDEId)) {
            return this.inheritPSDEFFormItem.getRefPSDEId();
        }
        return strRefPSDEId;
    }

    @Override
    public String getRefPSDEACModeId() {
        String strRefPSDEACModeId = super.getRefPSDEACModeId();
        if (StringHelper.isNullOrEmpty((String)strRefPSDEACModeId)) {
            return this.inheritPSDEFFormItem.getRefPSDEACModeId();
        }
        return strRefPSDEACModeId;
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u7c7b\u578b", order=292)
    public String getEditorType() {
        String strEditorType = super.getEditorType();
        if (StringHelper.isNullOrEmpty((String)strEditorType)) {
            return this.inheritPSDEFFormItem.getEditorType();
        }
        return strEditorType;
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u6837\u5f0f", order=293)
    public String getEditorStyle() {
        String strEditorStyle = super.getEditorStyle();
        if (StringHelper.isNullOrEmpty((String)strEditorStyle)) {
            return this.inheritPSDEFFormItem.getEditorStyle();
        }
        return strEditorStyle;
    }

    @Override
    public String getItemHandlerType(IPSDEFormItem iPSDEFormItem) {
        String strItemHandlerType = super.getItemHandlerType(iPSDEFormItem);
        if (StringHelper.isNullOrEmpty((String)strItemHandlerType)) {
            return this.inheritPSDEFFormItem.getItemHandlerType(iPSDEFormItem);
        }
        return strItemHandlerType;
    }

    @Override
    public ObjectNode getItemParam(IPSDEFormItem iPSDEFormItem) throws Exception {
        ObjectNode itemParam = super.getItemParam(iPSDEFormItem);
        if (itemParam == null) {
            return this.inheritPSDEFFormItem.getItemParam(iPSDEFormItem);
        }
        return itemParam;
    }

    @Override
    public String getValueItemName(IPSDEFormItem iPSDEFormItem) {
        String strValueItemName = super.getValueItemName(iPSDEFormItem);
        if (StringHelper.isNullOrEmpty((String)strValueItemName)) {
            return this.inheritPSDEFFormItem.getValueItemName(iPSDEFormItem);
        }
        return strValueItemName;
    }

    @Override
    public String getRefPickupPSDEViewId() {
        String strRefPickupPSDEViewId = super.getRefPickupPSDEViewId();
        if (StringHelper.isNullOrEmpty((String)strRefPickupPSDEViewId)) {
            return this.inheritPSDEFFormItem.getRefPickupPSDEViewId();
        }
        return strRefPickupPSDEViewId;
    }

    @Override
    public String getRefPickupPSDEViewName() {
        String strRefPickupPSDEViewName = super.getRefPickupPSDEViewName();
        if (StringHelper.isNullOrEmpty((String)strRefPickupPSDEViewName)) {
            return this.inheritPSDEFFormItem.getRefPickupPSDEViewName();
        }
        return strRefPickupPSDEViewName;
    }

    @Override
    public String getRefMPickupPSDEViewId() {
        String strRefMPickupPSDEViewId = super.getRefMPickupPSDEViewId();
        if (StringHelper.isNullOrEmpty((String)strRefMPickupPSDEViewId)) {
            return this.inheritPSDEFFormItem.getRefMPickupPSDEViewId();
        }
        return strRefMPickupPSDEViewId;
    }

    @Override
    public String getRefMPickupPSDEViewName() {
        String strRefMPickupPSDEViewName = super.getRefMPickupPSDEViewName();
        if (StringHelper.isNullOrEmpty((String)strRefMPickupPSDEViewName)) {
            return this.inheritPSDEFFormItem.getRefMPickupPSDEViewName();
        }
        return strRefMPickupPSDEViewName;
    }

    @Override
    public String getRefLinkPSDEViewId() {
        String strRefLinkPSDEViewId = super.getRefLinkPSDEViewId();
        if (StringHelper.isNullOrEmpty((String)strRefLinkPSDEViewId)) {
            return this.inheritPSDEFFormItem.getRefLinkPSDEViewId();
        }
        return strRefLinkPSDEViewId;
    }

    @Override
    public String getRefLinkPSDEViewName() {
        String strRefLinkPSDEViewName = super.getRefLinkPSDEViewName();
        if (StringHelper.isNullOrEmpty((String)strRefLinkPSDEViewName)) {
            return this.inheritPSDEFFormItem.getRefLinkPSDEViewName();
        }
        return strRefLinkPSDEViewName;
    }

    @Override
    public String getRefPSDEDataSetId() {
        String strRefPSDEDataSetId = super.getRefPSDEDataSetId();
        if (StringHelper.isNullOrEmpty((String)strRefPSDEDataSetId)) {
            return this.inheritPSDEFFormItem.getRefPSDEDataSetId();
        }
        return strRefPSDEDataSetId;
    }
}

