/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import java.util.Iterator;
import net.ibizsys.paas.db.IDBDialect;
import net.ibizsys.paas.db.IProcParam;
import net.ibizsys.paas.db.ProcParamList;
import net.ibizsys.paas.db.SqlParam;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.demodel.DEDBProcModelBase;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.demodel.ISqlCommandModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.web.IWebContext;

public class SqlCommandModel
implements ISqlCommandModel {
    protected String strSql = "";
    protected ProcParamList procParamList = new ProcParamList();
    protected IDBDialect iDBDialect = null;
    protected IDataEntityModel iDataEntityModel = null;

    @Override
    public String getSql() {
        return this.strSql;
    }

    @Override
    public Iterator<IProcParam> getProcParams() {
        return this.procParamList.iterator();
    }

    @Override
    public void fillSqlParams(IEntity iEntity, IWebContext iWebContext, SqlParamList sqlParamList) throws Exception {
        Iterator<IProcParam> procParams = this.getProcParams();
        while (procParams.hasNext()) {
            IProcParam procParam = procParams.next();
            SqlParam callParam = this.getProcSqlParam(procParam, iEntity, iWebContext);
            if (callParam == null) {
                callParam = new SqlParam();
            }
            sqlParamList.add(callParam);
        }
    }

    protected SqlParam getProcSqlParam(IProcParam procParam, IEntity iEntity, IWebContext iWebContext) throws Exception {
        return DEDBProcModelBase.getProcSqlParam(procParam, iEntity, iWebContext, this.getDataEntityModel());
    }

    public void setSql(String strSql) {
        this.strSql = strSql;
    }

    public void setProcParamList(ProcParamList procParamList) {
        this.procParamList = procParamList;
    }

    public IDBDialect getDBDialect() {
        return this.iDBDialect;
    }

    public void setDBDialect(IDBDialect iDBDialect) {
        this.iDBDialect = iDBDialect;
    }

    public IDataEntityModel getDataEntityModel() {
        return this.iDataEntityModel;
    }

    public void setDataEntityModel(IDataEntityModel iDataEntityModel) {
        this.iDataEntityModel = iDataEntityModel;
    }
}

