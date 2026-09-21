/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.IPSEditorType
 *  net.ibizsys.model.control.grid.IPSDEGridColumn
 *  net.ibizsys.model.control.grid.IPSDEGridEditItem
 *  net.ibizsys.model.pub.IPSGenerateCodeResult
 */
package net.ibizsys.model.pub;

import java.util.HashMap;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.IPSEditorType;
import net.ibizsys.model.control.grid.IPSDEGridColumn;
import net.ibizsys.model.control.grid.IPSDEGridEditItem;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.PSExtJS5CtrlPartCodePublisherImpl;

public class PSExtJS5DEGridColVCPublisherImpl
extends PSExtJS5CtrlPartCodePublisherImpl {
    protected IPSDEGridColumn iPSDEGridColumn = null;

    public IPSGenerateCodeResult generateCode(IPSControl iPSControl, Object object) throws Exception {
        this.iPSDEGridColumn = (IPSDEGridColumn)object;
        return super.generateCode(iPSControl, object);
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        if (this.iPSDEGridColumn.isEnableRowEdit()) {
            IPSDEGridEditItem iPSDEGridEditItem = this.iPSDEGridColumn.getPSDEGridEditItem();
            IPSEditorType iPSEditorType = this.getPSModelStorageContext().getPSEditorType(iPSDEGridEditItem.getEditorType());
        }
    }
}

