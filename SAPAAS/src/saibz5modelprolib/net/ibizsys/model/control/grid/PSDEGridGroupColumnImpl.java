/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.control.grid.IPSDEGridColumn
 *  net.ibizsys.model.control.grid.IPSDEGridDataItem
 *  net.ibizsys.model.control.grid.IPSDEGridGroupColumn
 */
package net.ibizsys.model.control.grid;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.control.grid.IPSDEGridColumn;
import net.ibizsys.model.control.grid.IPSDEGridColumnRuntime;
import net.ibizsys.model.control.grid.IPSDEGridDataItem;
import net.ibizsys.model.control.grid.IPSDEGridGroupColumn;
import net.ibizsys.model.control.grid.PSDEGridColumnImpl;
import net.ibizsys.model.entity.PSDEGridColumn;

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
                IPSDEGridColumn iPSDEGridColumn = this.getPSModelStorageContext().createPSDEGridColumn(this.getPSDEGrid(), this, psDEGridColumn);
                this.psDEGridColumnList.add(iPSDEGridColumn);
            }
        }
    }

    @Override
    protected void onFillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        for (IPSDEGridColumn iPSDEGridColumn : this.psDEGridColumnList) {
            ((IPSDEGridColumnRuntime)iPSDEGridColumn).fillRelatedPSAppViews(relatedAppViewList);
        }
    }

    @Override
    public Iterator<IPSDEGridDataItem> getPSDEGridDataItems() {
        return null;
    }

    @PSModelRTMeta(description="\u6210\u5458\u5217\u96c6\u5408")
    public Iterator<IPSDEGridColumn> getPSDEGridColumns() {
        if (this.psDEGridColumnList.size() == 0) {
            return null;
        }
        return this.psDEGridColumnList.iterator();
    }
}

