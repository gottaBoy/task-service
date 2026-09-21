/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Control.Grid.IPSDEGridColumn
 *  SA.SRFDA.PS.Core.Control.Grid.IPSDEGridEditItem
 *  SA.SRFDA.PS.Core.Control.Grid.IPSDEGridGroupColumn
 *  SA.SRFDA.PS.Core.Control.IPSControl
 *  SA.SRFDA.PS.Core.Control.IPSEditorType
 *  SA.SRFDA.PS.Core.PF.IPSPFEditorTempl
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher
 *  SA.SRFDA.PS.Core.Pub.IPSPFEditorCodePublisher
 *  SA.SRFDA.PS.Core.Pub.IPSPublisherContext
 *  SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl
 *  SA.SRFDA.PS.Core.Res.IPSSysPFPlugin
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Pub.Vue;

import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridColumn;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridEditItem;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridGroupColumn;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSEditorType;
import SA.SRFDA.PS.Core.PF.IPSPFEditorTempl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPFEditorCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import SA.SRFDA.PS.Core.Pub.Vue.PSVueCtrlPartCodePublisherImpl;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;

public class PSVueDEGridColVCPublisherImpl
extends PSVueCtrlPartCodePublisherImpl {
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
            IPSSysPFPlugin iPSSysPFPlugin = null;
            IPSEditorType iPSEditorType = this.getPSModelStorage().getPSEditorType(iPSDEGridEditItem.getEditorType());
            if (iPSDEGridEditItem.getPSSysEditorStyle() != null) {
                iPSSysPFPlugin = iPSDEGridEditItem.getPSSysEditorStyle().getPSSysPFPlugin();
            }
            if (iPSSysPFPlugin != null) {
                String strCode;
                String strCodeName = "";
                if (StringHelper.compare((String)this.getPSPFPubCode().getName(), (String)"HTML", (boolean)true) == 0) {
                    strCodeName = "CODE";
                } else if (StringHelper.compare((String)this.getPSPFPubCode().getName(), (String)"SERVICE_TS", (boolean)true) == 0) {
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
            IPSPFEditorTempl iPSPFEditorTempl = this.iPSApplication.getPSPFEditorTempl(iPSEditorType, "GRIDCOLUMN", this.getPSPFPubCode(), iPSDEGridEditItem.getEditorStyle());
            IPSPFEditorCodePublisher psPFEditorCodePublisher = iPSPFEditorTempl.getPSPFEditorCodePublisher();
            IPSGenerateCodeResult iPSGenerateCodeResult = psPFEditorCodePublisher.generateCode(this.iPSPublisherContext, this.iPSControl, (Object)iPSDEGridEditItem);
            params.put("editor", iPSGenerateCodeResult);
            psPFEditorCodePublisher.close();
        } else if (this.iPSDEGridColumn instanceof IPSDEGridGroupColumn) {
            IPSDEGridGroupColumn iPSDEGridGroupColumn = (IPSDEGridGroupColumn)this.iPSDEGridColumn;
            IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail("COLUMN").getPSPFCtrlPartCodePublisher();
            ArrayList<IPSGenerateCodeResult> gridColumnList = new ArrayList<IPSGenerateCodeResult>();
            Iterator psDEGridColumns = iPSDEGridGroupColumn.getPSDEGridColumns();
            while (psDEGridColumns.hasNext()) {
                IPSDEGridColumn iPSDEGridColumn = (IPSDEGridColumn)psDEGridColumns.next();
                IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this.iPSPublisherContext, (IPSControl)iPSDEGridGroupColumn.getPSDEGrid(), (Object)iPSDEGridColumn);
                gridColumnList.add(iPSGenerateCodeResult);
            }
            iPSPFCtrlPartCodePublisher.close();
            params.put("columns", gridColumnList);
        }
    }

    protected void onClose() {
        this.iPSDEGridColumn = null;
        super.onClose();
    }
}

