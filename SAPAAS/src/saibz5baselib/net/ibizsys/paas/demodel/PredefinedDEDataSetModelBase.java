/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import java.util.ArrayList;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.impl.SimpleDataSetImpl;
import net.ibizsys.paas.db.impl.SimpleDataTableImpl;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

public abstract class PredefinedDEDataSetModelBase
extends DEDataSetModelBase {
    private ArrayList<IDataRow> dataRowList = new ArrayList();
    private Boolean bPrepareDataRowList = false;
    private Object objPrepareDataRowList = new Object();

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public boolean isCustomDS() {
        return true;
    }

    protected void onFillDataRowList(ArrayList<IDataRow> dataRowList) throws Exception {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public DBFetchResult fetchDEDataSet(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dbFetchResult = new DBFetchResult();
        SimpleDataSetImpl simpleDataSetImpl = new SimpleDataSetImpl();
        SimpleDataTableImpl simpleDataTableImpl = new SimpleDataTableImpl(simpleDataSetImpl);
        Object object = this.objPrepareDataRowList;
        synchronized (object) {
            if (!this.bPrepareDataRowList.booleanValue()) {
                this.onFillDataRowList(this.dataRowList);
                this.bPrepareDataRowList = true;
            }
        }
        for (IDataRow iDataRow : this.dataRowList) {
            if (!this.testAddDataRow(iDEDataSetFetchContext, iDataRow)) continue;
            simpleDataTableImpl.addCachedRow(iDataRow);
        }
        simpleDataSetImpl.addDataTable(simpleDataTableImpl);
        dbFetchResult.setDataSet(simpleDataSetImpl);
        return dbFetchResult;
    }

    protected boolean testAddDataRow(IDEDataSetFetchContext iDEDataSetFetchContext, IDataRow iDataRow) throws Exception {
        return true;
    }
}

