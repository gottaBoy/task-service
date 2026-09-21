/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Control.Grid.IPSDEGridColumn
 *  SA.SRFDA.PS.Core.Control.Grid.IPSDEGridEditItem
 *  SA.SRFDA.PS.Core.Control.IPSControl
 *  SA.SRFDA.PS.Core.Control.IPSEditorType
 *  SA.SRFDA.PS.Core.PF.IPSPFEditorTempl
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFDA.PS.Core.Pub.IPSPFEditorCodePublisher
 *  SA.SRFDA.PS.Core.Pub.IPSPublisherContext
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridColumn;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridEditItem;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSEditorType;
import SA.SRFDA.PS.Core.PF.IPSPFEditorTempl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFEditorCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.PSExtJS5CtrlPartCodePublisherImpl;
import java.util.HashMap;

public class PSExtJS5DEGridColVCPublisherImpl
extends PSExtJS5CtrlPartCodePublisherImpl {
    protected IPSDEGridColumn iPSDEGridColumn = null;

    public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSControl iPSControl, Object object) throws Exception {
        this.iPSDEGridColumn = (IPSDEGridColumn)object;
        return super.generateCode(iPSPublisherContext, iPSControl, object);
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        if (this.iPSDEGridColumn.isEnableRowEdit()) {
            IPSDEGridEditItem iPSDEGridEditItem = this.iPSDEGridColumn.getPSDEGridEditItem();
            IPSEditorType iPSEditorType = this.getPSModelStorage().getPSEditorType(iPSDEGridEditItem.getEditorType());
            IPSPFEditorTempl iPSPFEditorTempl = this.iPSApplication.getPSPFEditorTempl(iPSEditorType, "GRIDCOLUMN", this.getPSPFPubCode(), iPSDEGridEditItem.getEditorStyle());
            IPSPFEditorCodePublisher psPFEditorCodePublisher = iPSPFEditorTempl.getPSPFEditorCodePublisher();
            IPSGenerateCodeResult iPSGenerateCodeResult = psPFEditorCodePublisher.generateCode(this.iPSPublisherContext, this.iPSControl, (Object)iPSDEGridEditItem);
            params.put("editor", iPSGenerateCodeResult);
            psPFEditorCodePublisher.close();
        }
    }

    protected void onClose() {
        this.iPSDEGridColumn = null;
        super.onClose();
    }
}

