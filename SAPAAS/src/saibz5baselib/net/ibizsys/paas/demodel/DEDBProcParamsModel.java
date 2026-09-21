/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.core.DBProcParam;
import net.ibizsys.paas.core.DBProcParams;
import net.ibizsys.paas.db.IProcParam;
import net.ibizsys.paas.demodel.DEDBProcParamModel;

public class DEDBProcParamsModel {
    protected DBProcParams dbProcParams = null;
    protected ArrayList<IProcParam> procParamList = new ArrayList();

    public void init(DBProcParams dbProcParams) {
        this.dbProcParams = dbProcParams;
        DBProcParam[] dBProcParamArray = this.dbProcParams.value();
        int n = dBProcParamArray.length;
        int n2 = 0;
        while (n2 < n) {
            DBProcParam dbProcParam = dBProcParamArray[n2];
            IProcParam iProcParam = this.createProcParam(dbProcParam);
            this.procParamList.add(iProcParam);
            ++n2;
        }
    }

    protected IProcParam createProcParam(DBProcParam dbProcParam) {
        DEDBProcParamModel dbDBProcParamModel = new DEDBProcParamModel();
        dbDBProcParamModel.init(dbProcParam);
        return dbDBProcParamModel;
    }

    public String getDBType() {
        return this.dbProcParams.dbtype();
    }

    public Iterator<IProcParam> getProcParams() {
        return this.procParamList.iterator();
    }
}

