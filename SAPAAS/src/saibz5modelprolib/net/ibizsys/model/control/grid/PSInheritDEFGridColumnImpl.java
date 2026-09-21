/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.control.grid.IPSDEFGridColumn
 *  net.ibizsys.model.control.grid.IPSDEGridEditItem
 *  net.ibizsys.model.dataentity.field.IPSInheritDEField
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.control.grid;

import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.control.grid.IPSDEFGridColumn;
import net.ibizsys.model.control.grid.IPSDEFGridColumnRuntime;
import net.ibizsys.model.control.grid.IPSDEGridEditItem;
import net.ibizsys.model.control.grid.PSLinkDEFGridColumnImpl;
import net.ibizsys.model.dataentity.field.IPSInheritDEField;
import net.ibizsys.paas.util.StringHelper;

public class PSInheritDEFGridColumnImpl
extends PSLinkDEFGridColumnImpl {
    protected IPSInheritDEField iPSInheritDEField = null;
    protected IPSDEFGridColumn inheritPSDEFGridColumn = null;

    @Override
    protected void onInit() throws Exception {
        this.iPSInheritDEField = (IPSInheritDEField)this.getPSDEField();
        if (this.iPSInheritDEField == null) {
            throw new Exception(StringHelper.format((String)"\u7ee7\u627f\u5c5e\u6027[%1$s]\u65e0\u6548", (Object)this.getPSDEField().getName()));
        }
        this.inheritPSDEFGridColumn = this.iPSInheritDEField.getRealInheritPSDEField().getPSDEFUIMode("DEFAULT").getPSDEFGridColumn();
        super.onInit();
    }

    @Override
    public String getRefPSDEId() {
        String strRefPSDEId = super.getRefPSDEId();
        if (StringHelper.isNullOrEmpty((String)strRefPSDEId)) {
            return this.inheritPSDEFGridColumn.getRefPSDEId();
        }
        return strRefPSDEId;
    }

    @Override
    public String getRefPSDEACModeId() {
        String strRefPSDEACModeId = super.getRefPSDEACModeId();
        if (StringHelper.isNullOrEmpty((String)strRefPSDEACModeId)) {
            return this.inheritPSDEFGridColumn.getRefPSDEACModeId();
        }
        return strRefPSDEACModeId;
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u7c7b\u578b", order=292)
    public String getEditorType() {
        String strEditorType = super.getEditorType();
        if (StringHelper.isNullOrEmpty((String)strEditorType)) {
            return this.inheritPSDEFGridColumn.getEditorType();
        }
        return strEditorType;
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u6837\u5f0f")
    public String getEditorStyle() {
        String strEditorStyle = super.getEditorStyle();
        if (StringHelper.isNullOrEmpty((String)strEditorStyle)) {
            return this.inheritPSDEFGridColumn.getEditorStyle();
        }
        return strEditorStyle;
    }

    @Override
    public String getItemHandlerType(IPSDEGridEditItem iPSDEGridEditItem) {
        String strItemHandlerType = super.getItemHandlerType(iPSDEGridEditItem);
        if (StringHelper.isNullOrEmpty((String)strItemHandlerType)) {
            return this.inheritPSDEFGridColumn.getItemHandlerType(iPSDEGridEditItem);
        }
        return strItemHandlerType;
    }

    @Override
    public ObjectNode getItemParam(IPSDEGridEditItem iPSDEGridEditItem) throws Exception {
        ObjectNode itemParam = super.getItemParam(iPSDEGridEditItem);
        if (itemParam == null) {
            return ((IPSDEFGridColumnRuntime)this.inheritPSDEFGridColumn).getItemParam(iPSDEGridEditItem);
        }
        return itemParam;
    }

    @Override
    public String getValueItemName(IPSDEGridEditItem iPSDEGridEditItem) {
        String strValueItemName = super.getValueItemName(iPSDEGridEditItem);
        if (StringHelper.isNullOrEmpty((String)strValueItemName)) {
            return ((IPSDEFGridColumnRuntime)this.inheritPSDEFGridColumn).getValueItemName(iPSDEGridEditItem);
        }
        return strValueItemName;
    }

    @Override
    public String getRefPickupPSDEViewId() {
        String strRefPickupPSDEViewId = super.getRefPickupPSDEViewId();
        if (StringHelper.isNullOrEmpty((String)strRefPickupPSDEViewId)) {
            return this.inheritPSDEFGridColumn.getRefPickupPSDEViewId();
        }
        return strRefPickupPSDEViewId;
    }

    @Override
    public String getRefPickupPSDEViewName() {
        String strRefPickupPSDEViewName = super.getRefPickupPSDEViewName();
        if (StringHelper.isNullOrEmpty((String)strRefPickupPSDEViewName)) {
            return this.inheritPSDEFGridColumn.getRefPickupPSDEViewName();
        }
        return strRefPickupPSDEViewName;
    }

    @Override
    public String getRefMPickupPSDEViewId() {
        String strRefMPickupPSDEViewId = super.getRefMPickupPSDEViewId();
        if (StringHelper.isNullOrEmpty((String)strRefMPickupPSDEViewId)) {
            return this.inheritPSDEFGridColumn.getRefMPickupPSDEViewId();
        }
        return strRefMPickupPSDEViewId;
    }

    @Override
    public String getRefMPickupPSDEViewName() {
        String strRefMPickupPSDEViewName = super.getRefMPickupPSDEViewName();
        if (StringHelper.isNullOrEmpty((String)strRefMPickupPSDEViewName)) {
            return this.inheritPSDEFGridColumn.getRefMPickupPSDEViewName();
        }
        return strRefMPickupPSDEViewName;
    }

    @Override
    public String getRefLinkPSDEViewId() {
        String strRefLinkPSDEViewId = super.getRefLinkPSDEViewId();
        if (StringHelper.isNullOrEmpty((String)strRefLinkPSDEViewId)) {
            return this.inheritPSDEFGridColumn.getRefLinkPSDEViewId();
        }
        return strRefLinkPSDEViewId;
    }

    @Override
    public String getRefLinkPSDEViewName() {
        String strRefLinkPSDEViewName = super.getRefLinkPSDEViewName();
        if (StringHelper.isNullOrEmpty((String)strRefLinkPSDEViewName)) {
            return this.inheritPSDEFGridColumn.getRefLinkPSDEViewName();
        }
        return strRefLinkPSDEViewName;
    }

    @Override
    public String getRefPSDEDataSetId() {
        String strRefPSDEDataSetId = super.getRefPSDEDataSetId();
        if (StringHelper.isNullOrEmpty((String)strRefPSDEDataSetId)) {
            return this.inheritPSDEFGridColumn.getRefPSDEDataSetId();
        }
        return strRefPSDEDataSetId;
    }
}

