/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.IPSEditorType
 *  net.ibizsys.model.control.grid.IPSDEGridColumn
 *  net.ibizsys.model.control.grid.IPSDEGridEditItem
 *  net.ibizsys.model.control.grid.IPSDEGridGroupColumn
 *  net.ibizsys.model.pub.IPSGenerateCodeResult
 *  net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher
 *  net.ibizsys.model.pub.PSGenerateCodeResultImpl
 *  net.ibizsys.model.res.IPSSysEditorStyleRuntime
 *  net.ibizsys.model.res.IPSSysPFPlugin
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.pub.vue2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.IPSEditorType;
import net.ibizsys.model.control.grid.IPSDEGridColumn;
import net.ibizsys.model.control.grid.IPSDEGridEditItem;
import net.ibizsys.model.control.grid.IPSDEGridGroupColumn;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher;
import net.ibizsys.model.pub.PSGenerateCodeResultImpl;
import net.ibizsys.model.pub.vue2.PSVue2CtrlPartCodePublisherImpl;
import net.ibizsys.model.res.IPSSysEditorStyleRuntime;
import net.ibizsys.model.res.IPSSysPFPlugin;
import net.ibizsys.paas.util.StringHelper;

public class PSVue2DEGridColVCPublisherImpl
extends PSVue2CtrlPartCodePublisherImpl {
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
            IPSSysPFPlugin iPSSysPFPlugin = null;
            IPSEditorType iPSEditorType = this.getPSModelStorageContext().getPSEditorType(iPSDEGridEditItem.getEditorType());
            if (iPSDEGridEditItem.getPSSysEditorStyle() != null) {
                iPSSysPFPlugin = ((IPSSysEditorStyleRuntime)iPSDEGridEditItem.getPSSysEditorStyle()).getPSSysPFPlugin();
            }
            if (iPSSysPFPlugin != null) {
                String strCode;
                String strCodeName = "";
                if (StringHelper.compare((String)this.getPSPFPubCode().getName(), (String)"PART", (boolean)true) == 0) {
                    strCodeName = "CODE";
                } else if (StringHelper.compare((String)this.getPSPFPubCode().getName(), (String)"CONTROLLER", (boolean)true) == 0) {
                    strCodeName = "CODE2";
                }
                if (!StringHelper.isNullOrEmpty((String)strCodeName) && !StringHelper.isNullOrEmpty((String)(strCode = iPSSysPFPlugin.getCode(strCodeName, this.iPSPF.getId(), this.iPSPFStyle.getId(), (Object)this.iPSAppView, (Object)this.iPSControl, (Object)iPSDEGridEditItem)))) {
                    PSGenerateCodeResultImpl psGenerateCodeResult = new PSGenerateCodeResultImpl();
                    psGenerateCodeResult.setObject((Object)iPSDEGridEditItem);
                    psGenerateCodeResult.setCode(strCode);
                    params.put("editor", psGenerateCodeResult);
                    return;
                }
            }
        } else if (this.iPSDEGridColumn instanceof IPSDEGridGroupColumn) {
            IPSDEGridGroupColumn iPSDEGridGroupColumn = (IPSDEGridGroupColumn)this.iPSDEGridColumn;
            IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail("COLUMN").getPSPFCtrlPartCodePublisher();
            ArrayList<IPSGenerateCodeResult> gridColumnList = new ArrayList<IPSGenerateCodeResult>();
            Iterator psDEGridColumns = iPSDEGridGroupColumn.getPSDEGridColumns();
            while (psDEGridColumns.hasNext()) {
                IPSDEGridColumn iPSDEGridColumn = (IPSDEGridColumn)psDEGridColumns.next();
                IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode((IPSControl)iPSDEGridGroupColumn.getPSDEGrid(), (Object)iPSDEGridColumn);
                gridColumnList.add(iPSGenerateCodeResult);
            }
            params.put("columns", gridColumnList);
        }
    }
}

