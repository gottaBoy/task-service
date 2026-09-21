/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEDataQuery
 *  net.ibizsys.paas.core.IDEDataQueryCode
 *  net.ibizsys.paas.core.IDEDataQueryCodeCond
 *  net.ibizsys.paas.core.IDEDataQueryCodeExp
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.core.IDEField
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.IDBDialect
 *  net.ibizsys.paas.db.SqlParamList
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.util.freemarker.SqlCodeHelper
 *  net.ibizsys.paas.web.IWebContext
 */
package SA.SRFDA.PS.Core.JIT.DEModel;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQueryCode;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQueryCodeCond;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQueryCodeExp;
import SA.SRFDA.PS.Core.JIT.DEModel.PSJITDEDataQueryCodeCondModel;
import SA.SRFDA.PS.Core.JIT.DEModel.PSJITDEDataQueryCodeExpModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.core.IDEDataQuery;
import net.ibizsys.paas.core.IDEDataQueryCode;
import net.ibizsys.paas.core.IDEDataQueryCodeCond;
import net.ibizsys.paas.core.IDEDataQueryCodeExp;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.IDBDialect;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.freemarker.SqlCodeHelper;
import net.ibizsys.paas.web.IWebContext;

public class PSJITDEDataQueryCodeModel
implements IDEDataQueryCode {
    private IPSDEDataQueryCode deDataQueryCode = null;
    private IDEDataQuery iDEDataQuery = null;
    private HashMap<String, IDEDataQueryCodeExp> fieldExpMap = new HashMap();
    private ArrayList<IDEDataQueryCodeCond> deDataQueryCodeCondList = new ArrayList();
    private HashMap<String, SqlCodeHelper> sqlCodeHelperMap = new HashMap();
    private IDataEntityModel iDEModel = null;

    public PSJITDEDataQueryCodeModel(IDEDataQuery iDEDataQuery, IPSDEDataQueryCode deDataQueryCode) throws Exception {
        this.iDEDataQuery = iDEDataQuery;
        this.deDataQueryCode = deDataQueryCode;
        if (this.iDEDataQuery.getDataEntity() != null && this.iDEDataQuery.getDataEntity() instanceof IDataEntityModel) {
            this.iDEModel = (IDataEntityModel)this.iDEDataQuery.getDataEntity();
        }
        this.prepareDEDataQueryCodeExps();
        this.prepareDEDataQueryCodeConds();
    }

    protected void prepareDEDataQueryCodeExps() throws Exception {
        Iterator<IPSDEDataQueryCodeExp> psDEDataQueryCodeExps = this.deDataQueryCode.getPSDEDataQueryCodeExps();
        while (psDEDataQueryCodeExps.hasNext()) {
            PSJITDEDataQueryCodeExpModel deDataQueryCodeExpModel = new PSJITDEDataQueryCodeExpModel(psDEDataQueryCodeExps.next());
            this.fieldExpMap.put(deDataQueryCodeExpModel.getName().toUpperCase(), deDataQueryCodeExpModel);
        }
    }

    protected void prepareDEDataQueryCodeConds() throws Exception {
        Iterator<IPSDEDataQueryCodeCond> psDEDataQueryCodeConds = this.deDataQueryCode.getPSDEDataQueryCodeConds();
        while (psDEDataQueryCodeConds.hasNext()) {
            PSJITDEDataQueryCodeCondModel deDataQueryCodeCondModel = new PSJITDEDataQueryCodeCondModel(psDEDataQueryCodeConds.next());
            this.deDataQueryCodeCondList.add(deDataQueryCodeCondModel);
        }
    }

    public IDEDataQuery getDEDataQuery() {
        return this.iDEDataQuery;
    }

    public String getId() {
        return null;
    }

    public String getName() {
        return null;
    }

    public String getDBType() {
        return this.deDataQueryCode.getDBType();
    }

    public String getQueryCode() {
        return this.deDataQueryCode.getQueryCode();
    }

    public String getQueryCodeTemp() {
        return this.deDataQueryCode.getQueryCodeTemp();
    }

    public String getDeclareCode() {
        return this.deDataQueryCode.getDeclareCode();
    }

    public void fillDeclareParams(IWebContext webContext, IDataObject iDataObject, SqlParamList sqlParamList) throws Exception {
    }

    public void fillQueryParams(IWebContext webContext, IDataObject iDataObject, SqlParamList sqlParamList) throws Exception {
    }

    public String getConditionSQL(IDEDataSetFetchContext iDEDataSetFetchContext, IDEDataQueryCodeCond iDEDataQueryCond, IDBDialect iDBDialect, SqlParamList list) throws Exception {
        if (StringHelper.compare((String)iDEDataQueryCond.getCondType(), (String)"GROUP", (boolean)true) == 0) {
            ArrayList<String> condList = new ArrayList<String>();
            Iterator childDEDataQueryConds = iDEDataQueryCond.getChildDEDataQueryConds();
            if (childDEDataQueryConds != null) {
                while (childDEDataQueryConds.hasNext()) {
                    IDEDataQueryCodeCond childDEDataQueryCond = (IDEDataQueryCodeCond)childDEDataQueryConds.next();
                    String strCond = this.getConditionSQL(iDEDataSetFetchContext, childDEDataQueryCond, iDBDialect, list);
                    if (StringHelper.isNullOrEmpty((String)strCond)) continue;
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
                    sb.append(" %1$s ", (Object)iDEDataQueryCond.getCondOp());
                }
                sb.append("( %1$s )", (Object)strCond);
            }
            if (iDEDataQueryCond.isNotMode()) {
                return StringHelper.format((String)" NOT( %1$s )", (Object)sb.toString());
            }
            return sb.toString();
        }
        if (StringHelper.compare((String)iDEDataQueryCond.getCondType(), (String)"DEFIELD", (boolean)true) == 0) {
            String strDEFieldExp = iDEDataQueryCond.getDEFieldExp();
            int nStdDataType = iDEDataQueryCond.getStdDataType();
            if (StringHelper.isNullOrEmpty((String)strDEFieldExp)) {
                strDEFieldExp = this.getDEFieldExp(iDEDataQueryCond.getDEFName(), false);
            }
            if (nStdDataType == 0) {
                IDEField iDEField = this.iDEDataQuery.getDataEntity().getDEField(iDEDataQueryCond.getDEFName(), false);
                nStdDataType = iDEField.getStdDataType();
            }
            if (this.getDEModel() != null) {
                return this.getDEModel().getDEFieldConditionSql(iDBDialect, iDEDataQueryCond.getDEFName(), strDEFieldExp, nStdDataType, iDEDataQueryCond.getCondOp(), iDEDataQueryCond.getCondValue());
            }
            return iDBDialect.getConditionSQL(strDEFieldExp, nStdDataType, iDEDataQueryCond.getCondOp(), iDEDataQueryCond.getCondValue(), false, null);
        }
        if (StringHelper.compare((String)iDEDataQueryCond.getCondType(), (String)"CUSTOM", (boolean)true) == 0) {
            SqlCodeHelper sqlCodeHelper = this.sqlCodeHelperMap.get(iDEDataQueryCond.getCustomCond());
            if (sqlCodeHelper == null) {
                sqlCodeHelper = new SqlCodeHelper();
                sqlCodeHelper.init((IDEDataQueryCode)this, iDEDataQueryCond.getCustomCond());
                this.sqlCodeHelperMap.put(iDEDataQueryCond.getCustomCond(), sqlCodeHelper);
            }
            return sqlCodeHelper.generateCode(list, iDEDataSetFetchContext.getSessionFactory());
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u6761\u4ef6\u7c7b\u578b[%1$s]", (Object)iDEDataQueryCond.getCondType()));
    }

    public String getDEFieldExp(String strName, boolean bTry) throws Exception {
        IDEDataQueryCodeExp iDEDataQueryCodeExp = this.fieldExpMap.get(strName = strName.toUpperCase());
        if (iDEDataQueryCodeExp == null) {
            IDEField iDEField = this.getDEDataQuery().getDataEntity().getDEField(strName, true);
            if (iDEField != null) {
                if (StringHelper.compare((String)iDEField.getDataType(), (String)"INHERIT", (boolean)true) == 0) {
                    return StringHelper.format((String)"t11.%1$s", (Object)iDEField.getName());
                }
                return StringHelper.format((String)"t1.%1$s", (Object)iDEField.getName());
            }
            if (!bTry) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027\u8868\u8fbe\u5f0f[%1$s]", (Object)strName));
            }
        }
        return iDEDataQueryCodeExp.getExpression();
    }

    public Iterator<IDEDataQueryCodeCond> getDEDataQueryCodeConds() {
        return this.deDataQueryCodeCondList.iterator();
    }

    public String getExtJoinSQL(IDEDataSetFetchContext iDEDataSetFetchContext, String strCode, IDBDialect iDBDialect, SqlParamList list) throws Exception {
        SqlCodeHelper sqlCodeHelper = this.sqlCodeHelperMap.get(strCode);
        if (sqlCodeHelper == null) {
            sqlCodeHelper = new SqlCodeHelper();
            sqlCodeHelper.init((IDEDataQueryCode)this, strCode);
            this.sqlCodeHelperMap.put(strCode, sqlCodeHelper);
        }
        return sqlCodeHelper.generateCode(list, iDEDataSetFetchContext.getSessionFactory());
    }

    public String getQueryCode(IDEDataSetFetchContext iDEDataSetFetchContext, IDBDialect iDBDialect, SqlParamList list) throws Exception {
        String strCode = this.getQueryCode();
        SqlCodeHelper sqlCodeHelper = this.sqlCodeHelperMap.get(strCode);
        if (sqlCodeHelper == null) {
            sqlCodeHelper = new SqlCodeHelper();
            sqlCodeHelper.init((IDEDataQueryCode)this, strCode);
            this.sqlCodeHelperMap.put(strCode, sqlCodeHelper);
        }
        return sqlCodeHelper.generateCode(list, iDEDataSetFetchContext.getSessionFactory());
    }

    public String getQueryCodeTemp(IDEDataSetFetchContext iDEDataSetFetchContext, IDBDialect iDBDialect, SqlParamList list) throws Exception {
        String strCode = this.getQueryCodeTemp();
        SqlCodeHelper sqlCodeHelper = this.sqlCodeHelperMap.get(strCode);
        if (sqlCodeHelper == null) {
            sqlCodeHelper = new SqlCodeHelper();
            sqlCodeHelper.init((IDEDataQueryCode)this, strCode);
            this.sqlCodeHelperMap.put(strCode, sqlCodeHelper);
        }
        return sqlCodeHelper.generateCode(list, iDEDataSetFetchContext.getSessionFactory());
    }

    public String getDeclareCode(IDEDataSetFetchContext iDEDataSetFetchContext, IDBDialect iDBDialect, SqlParamList list) throws Exception {
        String strCode = this.getDeclareCode();
        SqlCodeHelper sqlCodeHelper = this.sqlCodeHelperMap.get(strCode);
        if (sqlCodeHelper == null) {
            sqlCodeHelper = new SqlCodeHelper();
            sqlCodeHelper.init((IDEDataQueryCode)this, strCode);
            this.sqlCodeHelperMap.put(strCode, sqlCodeHelper);
        }
        return sqlCodeHelper.generateCode(list, iDEDataSetFetchContext.getSessionFactory());
    }

    protected IDataEntityModel getDEModel() {
        return this.iDEModel;
    }

    public Iterator<IDEDataQueryCodeExp> getDEDataQueryCodeExps() {
        return null;
    }
}

