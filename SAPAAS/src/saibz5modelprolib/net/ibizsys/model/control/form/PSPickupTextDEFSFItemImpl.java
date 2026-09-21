/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.control.form.IPSDEFormItem
 *  net.ibizsys.model.dataentity.field.IPSPickupTextDEField
 *  net.ibizsys.model.der.IPSDER1N
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.control.form;

import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.model.control.form.IPSDEFormItem;
import net.ibizsys.model.control.form.PSPickupDataDEFSFItemImpl;
import net.ibizsys.model.dataentity.field.IPSPickupTextDEField;
import net.ibizsys.model.der.IPSDER1N;
import net.ibizsys.model.der.IPSDER1NRuntime;
import net.ibizsys.paas.util.StringHelper;

public class PSPickupTextDEFSFItemImpl
extends PSPickupDataDEFSFItemImpl {
    protected IPSPickupTextDEField iPSPickupTextDEField = null;
    private String strRefPickupPSDEViewId = "";
    private String strRefPickupPSDEViewName = "";
    private String strRefMPickupPSDEViewId = "";
    private String strRefMPickupPSDEViewName = "";
    private String strRefLinkPSDEViewId = "";
    private String strRefLinkPSDEViewName = "";
    private String strRefPSDEDataSetId = "";
    private String strRefPSDEACModeId = "";
    private int nPickupTextOpts = 0;

    @Override
    protected void onInit() throws Exception {
        this.iPSPickupTextDEField = (IPSPickupTextDEField)this.getPSDEField();
        if (this.iPSPickupTextDEField == null) {
            throw new Exception(StringHelper.format((String)"\u5916\u952e\u6587\u672c\u5c5e\u6027[%1$s]\u65e0\u6548", (Object)this.getPSDEField().getName()));
        }
        super.onInit();
        IPSDER1N iPSDER1N = (IPSDER1N)this.iPSPickupDEField.getPSDER();
        this.strRefPickupPSDEViewId = super.getRefPickupPSDEViewId();
        this.strRefPickupPSDEViewName = super.getRefPickupPSDEViewName();
        StringHelper.isNullOrEmpty((String)super.getRefPickupPSDEViewId());
        this.strRefMPickupPSDEViewId = super.getRefMPickupPSDEViewId();
        this.strRefMPickupPSDEViewName = super.getRefMPickupPSDEViewName();
        StringHelper.isNullOrEmpty((String)super.getRefPickupPSDEViewId());
        this.strRefLinkPSDEViewId = super.getRefLinkPSDEViewId();
        this.strRefLinkPSDEViewName = super.getRefLinkPSDEViewName();
        StringHelper.isNullOrEmpty((String)super.getRefLinkPSDEViewId());
        this.strRefPSDEDataSetId = super.getRefPSDEDataSetId();
        if (StringHelper.isNullOrEmpty((String)super.getRefPSDEDataSetId())) {
            this.strRefPSDEDataSetId = ((IPSDER1NRuntime)iPSDER1N).getRefPSDEDataSetId();
        }
        this.strRefPSDEACModeId = super.getRefPSDEACModeId();
        if (StringHelper.isNullOrEmpty((String)super.getRefPSDEACModeId())) {
            this.strRefPSDEACModeId = ((IPSDER1NRuntime)iPSDER1N).getRefPSDEACModeId();
        }
    }

    @Override
    protected String getDefaultEditorType() throws Exception {
        if (StringHelper.compare((String)this.getPSDBValueOP().getId(), (String)"EQ", (boolean)true) == 0 || StringHelper.compare((String)this.getPSDBValueOP().getId(), (String)"NOTEQ", (boolean)true) == 0) {
            return super.getDefaultEditorType();
        }
        return "TEXTBOX";
    }

    @Override
    public String getValueItemName(IPSDEFormItem iPSDEFormItem) {
        if (iPSDEFormItem.getPSEditorType() != null && (StringHelper.compare((String)iPSDEFormItem.getPSEditorType().getStandardPSEditorType(), (String)"PICKER", (boolean)true) == 0 || StringHelper.compare((String)iPSDEFormItem.getPSEditorType().getStandardPSEditorType(), (String)"MOBPICKER", (boolean)true) == 0)) {
            return StringHelper.format((String)"N_%1$s_%2$s", (Object)this.iPSPickupDEField.getName(), (Object)this.getPSDBValueOP().getId()).toLowerCase();
        }
        return "";
    }

    @Override
    public String getRefPSDEDataSetId() {
        if (!StringHelper.isNullOrEmpty((String)super.getRefPSDEDataSetId())) {
            return super.getRefPSDEDataSetId();
        }
        return this.strRefPSDEDataSetId;
    }

    @Override
    public String getRefPSDEACModeId() {
        if (!StringHelper.isNullOrEmpty((String)super.getRefPSDEACModeId())) {
            return super.getRefPSDEACModeId();
        }
        return this.strRefPSDEACModeId;
    }

    @Override
    public String getRefPickupPSDEViewId() {
        if (!StringHelper.isNullOrEmpty((String)super.getRefPickupPSDEViewId())) {
            return super.getRefPickupPSDEViewId();
        }
        return this.strRefPickupPSDEViewId;
    }

    @Override
    public String getRefPickupPSDEViewName() {
        if (!StringHelper.isNullOrEmpty((String)super.getRefPickupPSDEViewName())) {
            return super.getRefPickupPSDEViewName();
        }
        return this.strRefPickupPSDEViewName;
    }

    @Override
    public String getRefMPickupPSDEViewId() {
        if (!StringHelper.isNullOrEmpty((String)super.getRefMPickupPSDEViewId())) {
            return super.getRefMPickupPSDEViewId();
        }
        return this.strRefMPickupPSDEViewId;
    }

    @Override
    public String getRefMPickupPSDEViewName() {
        if (!StringHelper.isNullOrEmpty((String)super.getRefMPickupPSDEViewName())) {
            return super.getRefMPickupPSDEViewName();
        }
        return this.strRefMPickupPSDEViewName;
    }

    @Override
    public String getRefLinkPSDEViewId() {
        if (!StringHelper.isNullOrEmpty((String)super.getRefLinkPSDEViewId())) {
            return super.getRefLinkPSDEViewId();
        }
        return this.strRefLinkPSDEViewId;
    }

    @Override
    public String getRefLinkPSDEViewName() {
        if (!StringHelper.isNullOrEmpty((String)super.getRefLinkPSDEViewName())) {
            return super.getRefLinkPSDEViewName();
        }
        return this.strRefLinkPSDEViewName;
    }

    @Override
    public String getItemHandlerType(IPSDEFormItem iPSDEFormItem) {
        if (iPSDEFormItem.getPSEditorType() != null && (StringHelper.compare((String)iPSDEFormItem.getPSEditorType().getStandardPSEditorType(), (String)"PICKER", (boolean)true) == 0 || StringHelper.compare((String)iPSDEFormItem.getPSEditorType().getStandardPSEditorType(), (String)"MOBPICKER", (boolean)true) == 0)) {
            return "PickupText";
        }
        return super.getItemHandlerType(iPSDEFormItem);
    }

    @Override
    public ObjectNode getItemParam(IPSDEFormItem iPSDEFormItem) throws Exception {
        ObjectNode itemParam = super.getItemParam(iPSDEFormItem);
        if (iPSDEFormItem.getPSEditorType() != null && StringHelper.compare((String)iPSDEFormItem.getPSEditorType().getStandardPSEditorType(), (String)"PICKER", (boolean)true) != 0) {
            StringHelper.compare((String)iPSDEFormItem.getPSEditorType().getStandardPSEditorType(), (String)"MOBPICKER", (boolean)true);
        }
        return itemParam;
    }
}

