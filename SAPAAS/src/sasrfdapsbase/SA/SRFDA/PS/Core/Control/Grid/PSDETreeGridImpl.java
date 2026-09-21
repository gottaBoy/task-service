/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Grid;

import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridColumn;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridColumnType;
import SA.SRFDA.PS.Core.Control.Grid.IPSDETreeGrid;
import SA.SRFDA.PS.Core.Control.Grid.PSDEGridImpl;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Data.PSDEGridColumn;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;

@PSModelImplementMeta(implement="IPSControl", typevalues={"TREEGRID"})
public class PSDETreeGridImpl
extends PSDEGridImpl
implements IPSDETreeGrid {
    protected IPSDEField treePPSDEField = null;

    @Override
    protected void onInit() throws Exception {
        String strTreePPSDEFName = this.psDEGrid.getTREEPPSDEFNAME();
        if (StringHelper.IsNullOrEmpty((String)strTreePPSDEFName)) {
            strTreePPSDEFName = "P" + this.getPSDataEntity().getKeyPSDEField().getName();
        }
        this.treePPSDEField = this.getPSDataEntity().getPSDEField(strTreePPSDEFName);
        super.onInit();
    }

    @Override
    public IPSDEField getTreePPSDEF() {
        return this.treePPSDEField;
    }

    @Override
    protected String onGetControlType() {
        return "TREEGRID";
    }

    @Override
    protected void onPreparePSDEGridColumns() throws Exception {
        this.psDEGridColumnList.clear();
        this.gridColumnList.clear();
        Vector<PSDEGridColumn> psDEGridColumnList = new Vector<PSDEGridColumn>();
        CallResult callResult = this.getPSModelHelper().getPSDEGridColumns(this.getId(), psDEGridColumnList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u8868\u683c\u5217\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        if (psDEGridColumnList.size() > 0) {
            psDEGridColumnList.get(0).setGRIDCOLTYPE("DEFTREEGRIDCOLUMN");
            psDEGridColumnList.get(0).setHIDEDEFAULT(3);
        }
        for (PSDEGridColumn psDEGridColumn : psDEGridColumnList) {
            IPSDEGridColumnType iPSDEGridColumnType = this.getPSModelStorage().getPSDEGridColumnType(psDEGridColumn.getGRIDCOLTYPE());
            IPSDEGridColumn iPSDEGridColumn = iPSDEGridColumnType.createPSDEGridColumn(psDEGridColumn);
            iPSDEGridColumn.init(this.getDAGlobalHelper(), this, null, psDEGridColumn);
            this.psDEGridColumnList.add(iPSDEGridColumn);
        }
        this.gridColumnList.addAll(this.psDEGridColumnList);
    }
}

