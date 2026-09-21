/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.IDEDataQuery;
import net.ibizsys.paas.core.IDEDataQueryCode;
import net.ibizsys.paas.core.IDEDataQueryCodeCond;
import net.ibizsys.paas.core.IDEDataQueryCodeExp;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.IDBDialect;
import net.ibizsys.paas.db.IDBFunction;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.demodel.DEDataQueryCodeCondModel;
import net.ibizsys.paas.demodel.DEDataQueryCodeExpModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.freemarker.SqlCodeHelper;
import net.ibizsys.paas.web.IWebContext;

public class DEDataQueryCodeModel
implements IDEDataQueryCode {
    private DEDataQueryCode deDataQueryCode = null;
    private IDEDataQuery iDEDataQuery = null;
    private HashMap<String, IDEDataQueryCodeExp> fieldExpMap = new HashMap();
    private ArrayList<IDEDataQueryCodeCond> deDataQueryCodeCondList = new ArrayList();
    private HashMap<String, SqlCodeHelper> sqlCodeHelperMap = new HashMap();
    private IDataEntityModel iDEModel = null;

    public DEDataQueryCodeModel(IDEDataQuery iDEDataQuery, DEDataQueryCode deDataQueryCode) {
        this.iDEDataQuery = iDEDataQuery;
        this.deDataQueryCode = deDataQueryCode;
        if (this.iDEDataQuery.getDataEntity() != null && this.iDEDataQuery.getDataEntity() instanceof IDataEntityModel) {
            this.iDEModel = (IDataEntityModel)this.iDEDataQuery.getDataEntity();
        }
        this.prepareDEDataQueryCodeExps();
        this.prepareDEDataQueryCodeConds();
    }

    protected void prepareDEDataQueryCodeExps() {
        DEDataQueryCodeExp[] dEDataQueryCodeExpArray = this.deDataQueryCode.fieldexps();
        int n = dEDataQueryCodeExpArray.length;
        int n2 = 0;
        while (n2 < n) {
            DEDataQueryCodeExp fieldExp = dEDataQueryCodeExpArray[n2];
            DEDataQueryCodeExpModel deDataQueryCodeExpModel = new DEDataQueryCodeExpModel(fieldExp);
            this.fieldExpMap.put(deDataQueryCodeExpModel.getName().toUpperCase(), deDataQueryCodeExpModel);
            ++n2;
        }
    }

    protected void prepareDEDataQueryCodeConds() {
        DEDataQueryCodeCond[] dEDataQueryCodeCondArray = this.deDataQueryCode.conds();
        int n = dEDataQueryCodeCondArray.length;
        int n2 = 0;
        while (n2 < n) {
            DEDataQueryCodeCond fieldCond = dEDataQueryCodeCondArray[n2];
            DEDataQueryCodeCondModel deDataQueryCodeCondModel = new DEDataQueryCodeCondModel(fieldCond);
            this.deDataQueryCodeCondList.add(deDataQueryCodeCondModel);
            ++n2;
        }
    }

    @Override
    public IDEDataQuery getDEDataQuery() {
        return this.iDEDataQuery;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDBType() {
        return this.deDataQueryCode.dbtype();
    }

    @Override
    public String getQueryCode() {
        return this.deDataQueryCode.querycode();
    }

    @Override
    public String getQueryCodeTemp() {
        return this.deDataQueryCode.querycodetemp();
    }

    @Override
    public String getDeclareCode() {
        return this.deDataQueryCode.declarecode();
    }

    @Override
    public void fillDeclareParams(IWebContext webContext, IDataObject iDataObject, SqlParamList sqlParamList) throws Exception {
    }

    @Override
    public void fillQueryParams(IWebContext webContext, IDataObject iDataObject, SqlParamList sqlParamList) throws Exception {
    }

    @Override
    public String getConditionSQL(IDEDataSetFetchContext iDEDataSetFetchContext, IDEDataQueryCodeCond iDEDataQueryCond, IDBDialect iDBDialect, SqlParamList list) throws Exception {
        if (StringHelper.compare(iDEDataQueryCond.getCondType(), "GROUP", true) == 0) {
            ArrayList<String> condList = new ArrayList<String>();
            Iterator<IDEDataQueryCodeCond> childDEDataQueryConds = iDEDataQueryCond.getChildDEDataQueryConds();
            if (childDEDataQueryConds != null) {
                while (childDEDataQueryConds.hasNext()) {
                    IDEDataQueryCodeCond childDEDataQueryCond = childDEDataQueryConds.next();
                    String strCond = this.getConditionSQL(iDEDataSetFetchContext, childDEDataQueryCond, iDBDialect, list);
                    if (StringHelper.isNullOrEmpty(strCond)) continue;
                    condList.add(strCond);
                }
            }
            if (condList.size() == 0) {
                return null;
            }
            StringBuilderEx sb = new StringBuilderEx();
            boolean bFirst = true;
            for (String strCond : condList) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    sb.append(" %1$s ", iDEDataQueryCond.getCondOp());
                }
                sb.append("( %1$s )", strCond);
            }
            if (iDEDataQueryCond.isNotMode()) {
                return StringHelper.format(" NOT( %1$s )", sb.toString());
            }
            return sb.toString();
        }
        if (StringHelper.compare(iDEDataQueryCond.getCondType(), "DEFIELD", true) == 0) {
            String strDEFieldExp = iDEDataQueryCond.getDEFieldExp();
            int nStdDataType = iDEDataQueryCond.getStdDataType();
            if (StringHelper.isNullOrEmpty(strDEFieldExp)) {
                strDEFieldExp = this.getDEFieldExp(iDEDataQueryCond.getDEFName(), false);
            }
            if (StringHelper.isNullOrEmpty(iDEDataQueryCond.getValueFunc())) {
                if (nStdDataType == 0) {
                    IDEField iDEField = this.iDEDataQuery.getDataEntity().getDEField(iDEDataQueryCond.getDEFName(), false);
                    nStdDataType = iDEField.getStdDataType();
                }
            } else {
                IDBFunction iDBFunction = null;
                iDBFunction = this.getDEModel() != null ? this.getDEModel().getSystemModel().getDBFunction(iDBDialect, iDEDataQueryCond.getValueFunc()) : iDBDialect.getDBFunction(iDEDataQueryCond.getValueFunc());
                nStdDataType = iDBFunction.getOutputDataType();
                strDEFieldExp = iDBFunction.getFuncSQL(false, new String[]{strDEFieldExp});
            }
            if (this.getDEModel() != null) {
                return this.getDEModel().getDEFieldConditionSql(iDBDialect, iDEDataQueryCond.getDEFName(), strDEFieldExp, nStdDataType, iDEDataQueryCond.getCondOp(), iDEDataQueryCond.getCondValue());
            }
            return iDBDialect.getConditionSQL(strDEFieldExp, nStdDataType, iDEDataQueryCond.getCondOp(), iDEDataQueryCond.getCondValue(), false, null);
        }
        if (StringHelper.compare(iDEDataQueryCond.getCondType(), "CUSTOM", true) == 0) {
            SqlCodeHelper sqlCodeHelper = this.sqlCodeHelperMap.get(iDEDataQueryCond.getCustomCond());
            if (sqlCodeHelper == null) {
                sqlCodeHelper = new SqlCodeHelper();
                sqlCodeHelper.init(this, iDEDataQueryCond.getCustomCond());
                this.sqlCodeHelperMap.put(iDEDataQueryCond.getCustomCond(), sqlCodeHelper);
            }
            return sqlCodeHelper.generateCode(list, iDEDataSetFetchContext.getSessionFactory());
        }
        throw new Exception(StringHelper.format("\u65e0\u6cd5\u8bc6\u522b\u7684\u6761\u4ef6\u7c7b\u578b[%1$s]", iDEDataQueryCond.getCondType()));
    }

    @Override
    public String getDEFieldExp(String strName, boolean bTry) throws Exception {
        IDEDataQueryCodeExp iDEDataQueryCodeExp = this.fieldExpMap.get(strName = strName.toUpperCase());
        if (iDEDataQueryCodeExp == null) {
            IDEField iDEField = this.getDEDataQuery().getDataEntity().getDEField(strName, true);
            if (iDEField != null) {
                if (StringHelper.compare(iDEField.getDataType(), "INHERIT", true) == 0) {
                    return StringHelper.format("t11.%1$s", iDEField.getName());
                }
                return StringHelper.format("t1.%1$s", iDEField.getName());
            }
            if (!bTry) {
                throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027\u8868\u8fbe\u5f0f[%1$s]", strName));
            }
            return null;
        }
        return iDEDataQueryCodeExp.getExpression();
    }

    @Override
    public Iterator<IDEDataQueryCodeExp> getDEDataQueryCodeExps() {
        return this.fieldExpMap.values().iterator();
    }

    @Override
    public Iterator<IDEDataQueryCodeCond> getDEDataQueryCodeConds() {
        return this.deDataQueryCodeCondList.iterator();
    }

    @Override
    public String getExtJoinSQL(IDEDataSetFetchContext iDEDataSetFetchContext, String strCode, IDBDialect iDBDialect, SqlParamList list) throws Exception {
        SqlCodeHelper sqlCodeHelper = this.sqlCodeHelperMap.get(strCode);
        if (sqlCodeHelper == null) {
            sqlCodeHelper = new SqlCodeHelper();
            sqlCodeHelper.init(this, strCode);
            this.sqlCodeHelperMap.put(strCode, sqlCodeHelper);
        }
        return sqlCodeHelper.generateCode(list, iDEDataSetFetchContext.getSessionFactory());
    }

    @Override
    public String getQueryCode(IDEDataSetFetchContext iDEDataSetFetchContext, IDBDialect iDBDialect, SqlParamList list) throws Exception {
        String strCode = this.getQueryCode();
        SqlCodeHelper sqlCodeHelper = this.sqlCodeHelperMap.get(strCode);
        if (sqlCodeHelper == null) {
            sqlCodeHelper = new SqlCodeHelper();
            sqlCodeHelper.init(this, strCode);
            this.sqlCodeHelperMap.put(strCode, sqlCodeHelper);
        }
        return sqlCodeHelper.generateCode(list, iDEDataSetFetchContext.getSessionFactory());
    }

    @Override
    public String getQueryCodeTemp(IDEDataSetFetchContext iDEDataSetFetchContext, IDBDialect iDBDialect, SqlParamList list) throws Exception {
        String strCode = this.getQueryCodeTemp();
        SqlCodeHelper sqlCodeHelper = this.sqlCodeHelperMap.get(strCode);
        if (sqlCodeHelper == null) {
            sqlCodeHelper = new SqlCodeHelper();
            sqlCodeHelper.init(this, strCode);
            this.sqlCodeHelperMap.put(strCode, sqlCodeHelper);
        }
        return sqlCodeHelper.generateCode(list, iDEDataSetFetchContext.getSessionFactory());
    }

    @Override
    public String getDeclareCode(IDEDataSetFetchContext iDEDataSetFetchContext, IDBDialect iDBDialect, SqlParamList list) throws Exception {
        String strCode = this.getDeclareCode();
        SqlCodeHelper sqlCodeHelper = this.sqlCodeHelperMap.get(strCode);
        if (sqlCodeHelper == null) {
            sqlCodeHelper = new SqlCodeHelper();
            sqlCodeHelper.init(this, strCode);
            this.sqlCodeHelperMap.put(strCode, sqlCodeHelper);
        }
        return sqlCodeHelper.generateCode(list, iDEDataSetFetchContext.getSessionFactory());
    }

    protected IDataEntityModel getDEModel() {
        return this.iDEModel;
    }
}

