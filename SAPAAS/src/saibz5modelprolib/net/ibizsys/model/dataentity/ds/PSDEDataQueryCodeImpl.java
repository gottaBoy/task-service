/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.ds.IPSDEDataQuery
 *  net.ibizsys.model.dataentity.ds.IPSDEDataQueryCode
 *  net.ibizsys.model.dataentity.ds.IPSDEDataQueryCodeCond
 *  net.ibizsys.model.dataentity.ds.IPSDEDataQueryCodeExp
 *  net.ibizsys.paas.core.IDEDataQuery
 *  net.ibizsys.paas.core.IDEDataQueryCodeCond
 *  net.ibizsys.paas.core.IDEDataQueryCodeExp
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.IDBDialect
 *  net.ibizsys.paas.db.SqlParamList
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 */
package net.ibizsys.model.dataentity.ds;

import java.util.Iterator;
import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.dataentity.ds.IPSDEDataQuery;
import net.ibizsys.model.dataentity.ds.IPSDEDataQueryCode;
import net.ibizsys.model.dataentity.ds.IPSDEDataQueryCodeCond;
import net.ibizsys.model.dataentity.ds.IPSDEDataQueryCodeExp;
import net.ibizsys.model.dataentity.ds.IPSDEDataQueryCodeRuntime;
import net.ibizsys.model.dataentity.ds.PSDEDataQueryCodeCondGlobalModel;
import net.ibizsys.model.dataentity.ds.PSDEDataQueryCodeExpGlobalModel;
import net.ibizsys.model.entity.PSDEDataQueryCode;
import net.ibizsys.paas.core.IDEDataQuery;
import net.ibizsys.paas.core.IDEDataQueryCodeCond;
import net.ibizsys.paas.core.IDEDataQueryCodeExp;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.IDBDialect;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;

public class PSDEDataQueryCodeImpl
extends PSObjectImpl
implements IPSDEDataQueryCode,
IPSDEDataQueryCodeRuntime {
    protected IPSDEDataQuery iPSDEDataQuery;
    protected String strQueryCode;
    protected String strQueryCodeTemp;
    private String strDBType = "";
    protected PSDEDataQueryCodeExpGlobalModel psDEDataQueryCodeExpGlobalModel = new PSDEDataQueryCodeExpGlobalModel();
    protected PSDEDataQueryCodeCondGlobalModel psDEDataQueryCodeCondGlobalModel = new PSDEDataQueryCodeCondGlobalModel();

    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDEDataQuery iPSDEDataQuery, PSDEDataQueryCode psDEDataQueryCode) throws Exception {
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.iPSDEDataQuery = iPSDEDataQuery;
        this.setId(psDEDataQueryCode.getPSDEDQCODEID());
        this.setName(psDEDataQueryCode.getPSDEDQCODENAME());
        this.setPSObjectData(psDEDataQueryCode, false);
        this.strQueryCode = psDEDataQueryCode.getUSERQUERYCODE();
        if (StringHelper.isNullOrEmpty((String)this.strQueryCode)) {
            this.strQueryCode = psDEDataQueryCode.getQUERYCODE();
        }
        this.strQueryCodeTemp = psDEDataQueryCode.getUSERQUERYCODE2();
        if (StringHelper.isNullOrEmpty((String)this.strQueryCodeTemp)) {
            this.strQueryCodeTemp = psDEDataQueryCode.getQUERYCODETEMP();
        }
        this.strDBType = psDEDataQueryCode.getDBTYPE();
        this.psDEDataQueryCodeExpGlobalModel.init(iPSModelStorageContext, this);
        this.psDEDataQueryCodeCondGlobalModel.init(iPSModelStorageContext, this);
        this.onInit();
    }

    public String getDBType() {
        return this.strDBType;
    }

    public String getQueryCode() {
        return this.strQueryCode;
    }

    public String getQueryCodeTemp() {
        return this.strQueryCodeTemp;
    }

    public Iterator<IPSDEDataQueryCodeExp> getPSDEDataQueryCodeExps() throws Exception {
        return this.psDEDataQueryCodeExpGlobalModel.getAllModelHelpers();
    }

    public Iterator<IDEDataQueryCodeCond> getDEDataQueryCodeConds() {
        return null;
    }

    public IPSDEDataQuery getPSDEDataQuery() {
        return this.iPSDEDataQuery;
    }

    public String getDeclareCode() {
        return "";
    }

    public void fillDeclareParams(IWebContext webContext, IDataObject iDataObject, SqlParamList sqlParamList) throws Exception {
    }

    public void fillQueryParams(IWebContext webContext, IDataObject iDataObject, SqlParamList sqlParamList) throws Exception {
    }

    public String getConditionSQL(IDEDataSetFetchContext iDEDataSetFetchContext, IDEDataQueryCodeCond iDEDataQueryCond, IDBDialect iDBDialect, SqlParamList list) throws Exception {
        return null;
    }

    public Iterator<IPSDEDataQueryCodeCond> getPSDEDataQueryCodeConds() throws Exception {
        return this.psDEDataQueryCodeCondGlobalModel.getAllModelHelpers();
    }

    @Override
    public void loadAll() throws Exception {
        this.getPSDEDataQueryCodeConds();
        this.getPSDEDataQueryCodeExps();
    }

    @Override
    public String getPSSysModelInstId() {
        return ((IPSModelObjectRuntime)this.iPSDEDataQuery).getPSSysModelInstId();
    }

    public String getDEFieldExp(String strName, boolean bTry) throws Exception {
        return null;
    }

    public String getExtJoinSQL(IDEDataSetFetchContext iDEDataSetFetchContext, String strCode, IDBDialect iDBDialect, SqlParamList list) throws Exception {
        return strCode;
    }

    public IDEDataQuery getDEDataQuery() {
        return this.getPSDEDataQuery();
    }

    public String getQueryCode(IDEDataSetFetchContext iDEDataSetFetchContext, IDBDialect iDBDialect, SqlParamList list) throws Exception {
        return null;
    }

    public String getQueryCodeTemp(IDEDataSetFetchContext iDEDataSetFetchContext, IDBDialect iDBDialect, SqlParamList list) throws Exception {
        return null;
    }

    public String getDeclareCode(IDEDataSetFetchContext iDEDataSetFetchContext, IDBDialect iDBDialect, SqlParamList list) throws Exception {
        return null;
    }

    public Iterator<IDEDataQueryCodeExp> getDEDataQueryCodeExps() {
        return null;
    }
}

