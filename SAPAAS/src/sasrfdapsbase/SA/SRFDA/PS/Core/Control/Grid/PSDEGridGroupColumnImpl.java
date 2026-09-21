/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Grid;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridColumn;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridColumnType;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridDataItem;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridGroupColumn;
import SA.SRFDA.PS.Core.Control.Grid.PSDEGridColumnImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSDEGridColumn;
import java.util.ArrayList;
import java.util.Iterator;

public class PSDEGridGroupColumnImpl
extends PSDEGridColumnImpl
implements IPSDEGridGroupColumn {
    private ArrayList<IPSDEGridColumn> psDEGridColumnList = new ArrayList();

    @Override
    protected void onInit() throws Exception {
        this.setEnableSort(false);
        super.onInit();
        this.onPreparePSDEGridColumns();
    }

    protected void onPreparePSDEGridColumns() throws Exception {
        this.psDEGridColumnList.clear();
        ArrayList<PSDEGridColumn> psDEGridColumnList = this.psDEGridColumn.getChildPSDEGridColumns(false);
        if (psDEGridColumnList != null) {
            for (PSDEGridColumn psDEGridColumn : psDEGridColumnList) {
                IPSDEGridColumnType iPSDEGridColumnType = this.getPSModelStorage().getPSDEGridColumnType(psDEGridColumn.getGRIDCOLTYPE());
                IPSDEGridColumn iPSDEGridColumn = iPSDEGridColumnType.createPSDEGridColumn(psDEGridColumn);
                iPSDEGridColumn.init(this.getDAGlobalHelper(), this.getPSDEGrid(), this, psDEGridColumn);
                this.psDEGridColumnList.add(iPSDEGridColumn);
            }
        }
    }

    @Override
    protected void onFillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        for (IPSDEGridColumn iPSDEGridColumn : this.psDEGridColumnList) {
            iPSDEGridColumn.fillRelatedPSAppViews(relatedAppViewList);
        }
    }

    @Override
    public Iterator<IPSDEGridDataItem> getPSDEGridDataItems() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6210\u5458\u5217\u96c6\u5408", child=true, doctype="simple")
    public Iterator<IPSDEGridColumn> getPSDEGridColumns() {
        if (this.psDEGridColumnList.size() == 0) {
            return null;
        }
        return this.psDEGridColumnList.iterator();
    }
}

