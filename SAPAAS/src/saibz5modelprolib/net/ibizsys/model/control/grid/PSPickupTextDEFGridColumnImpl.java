/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.control.grid.IPSDEGridEditItem
 *  net.ibizsys.model.dataentity.field.IPSPickupTextDEField
 *  net.ibizsys.model.der.IPSDER1N
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.control.grid;

import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.model.control.grid.IPSDEGridEditItem;
import net.ibizsys.model.control.grid.PSPickupDataDEFGridColumnImpl;
import net.ibizsys.model.dataentity.field.IPSPickupTextDEField;
import net.ibizsys.model.der.IPSDER1N;
import net.ibizsys.model.der.IPSDER1NRuntime;
import net.ibizsys.paas.util.StringHelper;

public class PSPickupTextDEFGridColumnImpl
extends PSPickupDataDEFGridColumnImpl {
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
        if (!this.psDEFUIMode.isPICKUPTEXTOPTSNull()) {
            this.nPickupTextOpts = this.psDEFUIMode.getPICKUPTEXTOPTS();
        }
        this.iPSPickupTextDEField = (IPSPickupTextDEField)this.getPSDEField();
        if (this.iPSPickupTextDEField == null) {
            throw new Exception(StringHelper.format((String)"\u5916\u952e\u6587\u672c\u5c5e\u6027[%1$s]\u65e0\u6548", (Object)this.getPSDEField().getName()));
        }
        super.onInit();
        IPSDER1N iPSDER1N = (IPSDER1N)this.iPSPickupDEField.getPSDER();
        this.strRefPickupPSDEViewId = super.getRefPickupPSDEViewId();
        this.strRefPickupPSDEViewName = super.getRefPickupPSDEViewName();
        this.strRefMPickupPSDEViewId = super.getRefMPickupPSDEViewId();
        this.strRefMPickupPSDEViewName = super.getRefMPickupPSDEViewName();
        this.strRefLinkPSDEViewId = super.getRefLinkPSDEViewId();
        this.strRefLinkPSDEViewName = super.getRefLinkPSDEViewName();
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
    public String getValueItemName(IPSDEGridEditItem iPSDEGridEditItem) {
        String strValueItemName = super.getValueItemName(iPSDEGridEditItem);
        if (StringHelper.isNullOrEmpty((String)strValueItemName) && iPSDEGridEditItem.getPSEditorType() != null && (StringHelper.compare((String)iPSDEGridEditItem.getPSEditorType().getStandardPSEditorType(), (String)"PICKER", (boolean)true) == 0 || StringHelper.compare((String)iPSDEGridEditItem.getPSEditorType().getStandardPSEditorType(), (String)"PICKER", (boolean)true) == 0)) {
            return this.iPSPickupDEField.getName().toLowerCase();
        }
        return strValueItemName;
    }

    @Override
    public String getRefPSDEDataSetId() {
        return this.strRefPSDEDataSetId;
    }

    @Override
    public String getRefPSDEACModeId() {
        return this.strRefPSDEACModeId;
    }

    @Override
    public String getRefPickupPSDEViewId() {
        return this.strRefPickupPSDEViewId;
    }

    @Override
    public String getRefPickupPSDEViewName() {
        return this.strRefPickupPSDEViewName;
    }

    @Override
    public String getRefMPickupPSDEViewId() {
        return this.strRefMPickupPSDEViewId;
    }

    @Override
    public String getRefMPickupPSDEViewName() {
        return this.strRefMPickupPSDEViewName;
    }

    @Override
    public String getRefLinkPSDEViewId() {
        return this.strRefLinkPSDEViewId;
    }

    @Override
    public String getRefLinkPSDEViewName() {
        return this.strRefLinkPSDEViewName;
    }

    @Override
    public String getItemHandlerType(IPSDEGridEditItem iPSDEGridEditItem) {
        if (iPSDEGridEditItem.getPSEditorType() != null && (StringHelper.compare((String)iPSDEGridEditItem.getPSEditorType().getStandardPSEditorType(), (String)"PICKER", (boolean)true) == 0 || StringHelper.compare((String)iPSDEGridEditItem.getPSEditorType().getStandardPSEditorType(), (String)"MOBPICKER", (boolean)true) == 0)) {
            return "PickupText";
        }
        return super.getItemHandlerType(iPSDEGridEditItem);
    }

    @Override
    public ObjectNode getItemParam(IPSDEGridEditItem iPSDEGridEditItem) throws Exception {
        ObjectNode itemParam = super.getItemParam(iPSDEGridEditItem);
        if (iPSDEGridEditItem.getPSEditorType() != null && (StringHelper.compare((String)iPSDEGridEditItem.getPSEditorType().getStandardPSEditorType(), (String)"PICKER", (boolean)true) == 0 || StringHelper.compare((String)iPSDEGridEditItem.getPSEditorType().getStandardPSEditorType(), (String)"MOBPICKER", (boolean)true) == 0)) {
            IPSDER1N iPSDER1N = (IPSDER1N)this.iPSPickupDEField.getPSDER();
        }
        return itemParam;
    }
}

