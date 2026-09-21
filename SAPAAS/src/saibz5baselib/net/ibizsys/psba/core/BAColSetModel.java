/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psba.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psba.core.BATableObjectModelBase;
import net.ibizsys.psba.core.IBAColSetModel;
import net.ibizsys.psba.core.IBAColumn;
import net.ibizsys.psba.core.IBATable;

public class BAColSetModel
extends BATableObjectModelBase
implements IBAColSetModel {
    private ArrayList<IBAColumn> baColumnList = new ArrayList();
    private HashMap<String, IBAColumn> baColumnMap = new HashMap();

    public void init(IBATable iBATable) throws Exception {
        this.setBATable(iBATable);
        this.onInit();
    }

    @Override
    public void registerBAColumn(IBAColumn iBAColumn) throws Exception {
        this.baColumnList.add(iBAColumn);
        this.baColumnMap.put(iBAColumn.getId(), iBAColumn);
        this.baColumnMap.put(iBAColumn.getName(), iBAColumn);
    }

    @Override
    public IBAColumn getBAColumn(String strBAColumnName) throws Exception {
        IBAColumn iBAColumn = this.baColumnMap.get(strBAColumnName);
        if (iBAColumn == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u5927\u6570\u636e\u8868\u5217[%1$s]", strBAColumnName));
        }
        return iBAColumn;
    }

    @Override
    public Iterator<IBAColumn> getBAColumns() {
        if (this.baColumnList == null || this.baColumnList.size() == 0) {
            return null;
        }
        return this.baColumnList.iterator();
    }
}

