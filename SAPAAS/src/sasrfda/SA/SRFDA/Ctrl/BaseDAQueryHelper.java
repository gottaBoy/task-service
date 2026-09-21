/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.Data.DataTypeParse
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DataEntity;
import SA.SRFDA.Ctrl.IDAQueryHelper;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Model.DGModelBaseLogicConfig;
import SA.SRFDA.Model.DGModelGroupLogicConfig;
import SA.SRFDA.Model.DGModelJoinQueryConfig;
import SA.SRFDA.Model.DGModelMainQueryConfig;
import SA.SRFDA.Model.DGModelSingleLogicConfig;
import SA.SRFDA.Model.SearchItemConfig;
import SA.SRFDA.Web.Utility.GlobalHelperEx;
import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class BaseDAQueryHelper
implements IDAQueryHelper {
    protected IDEHelper iDEHelper = null;
    protected GlobalHelperEx contextHelperEx = null;
    protected String strCurUserId = "";
    protected int nStartPos = -1;
    protected int nPageSize = -1;
    protected String strMajorOrder = "";
    protected String strMinorOrder = "";
    protected String strMajorDirection = "";
    protected String strMinorDirection = "";
    protected int nDBObjectId = 10;
    protected DGModelMainQueryConfig mainQueryConfig = null;
    protected ArrayList<String> mainConditions = new ArrayList();
    private static final Log log = LogFactory.getLog(BaseDAQueryHelper.class);
    protected ArrayList<String> joinQueries = new ArrayList();

    @Override
    public void Init(IDEHelper iDEHelper, GlobalHelperEx contextHelperEx) {
        this.iDEHelper = iDEHelper;
        this.contextHelperEx = contextHelperEx;
        if (this.iDEHelper.getDataEntity().isLOGICVALID()) {
            this.mainConditions.add(this.GetValidSQL());
        }
    }

    protected IDEHelper getDEHelper() {
        return this.iDEHelper;
    }

    @Override
    public void SetCurUserId(String strUserId) {
        this.strCurUserId = strUserId;
    }

    @Override
    public boolean SetMainQuery(DGModelMainQueryConfig mainQueryConfig) {
        this.mainQueryConfig = mainQueryConfig;
        StringBuilderEx sql = new StringBuilderEx();
        return true;
    }

    protected CallResult GetGroupCondition(IDEHelper iDEHelper, StringBuilderEx script, String strAlias, DGModelGroupLogicConfig dgModelGroupLogicConfig) {
        CallResult callResult = new CallResult();
        callResult.setRetCode(0);
        if (dgModelGroupLogicConfig.getLogicsConfig() == null) {
            return callResult;
        }
        if (dgModelGroupLogicConfig.getLogicsConfig().size() == 0) {
            return callResult;
        }
        if (dgModelGroupLogicConfig.isNot()) {
            script.Append("NOT");
        }
        script.Append("(");
        boolean bFirst = true;
        Iterator iterator = dgModelGroupLogicConfig.getLogicsConfig().iterator();
        while (iterator.hasNext()) {
            DGModelBaseLogicConfig dgModelBaseLogicConfig = (DGModelBaseLogicConfig)((Object)iterator.next());
            if (bFirst) {
                bFirst = false;
            } else if (StringHelper.Compare((String)dgModelGroupLogicConfig.getCondition(), (String)"AND", (boolean)true) == 0) {
                script.Append(" AND ");
            } else {
                script.Append(" OR ");
            }
            if (dgModelBaseLogicConfig instanceof DGModelGroupLogicConfig && (callResult = this.GetGroupCondition(iDEHelper, script, strAlias, (DGModelGroupLogicConfig)dgModelBaseLogicConfig)).getRetCode() != 0) {
                return callResult;
            }
            if (!(dgModelBaseLogicConfig instanceof DGModelSingleLogicConfig) || (callResult = this.GetSingleCondition(iDEHelper, script, strAlias, (DGModelSingleLogicConfig)dgModelBaseLogicConfig)).getRetCode() == 0) continue;
            return callResult;
        }
        script.Append(")");
        return callResult;
    }

    protected CallResult GetSingleCondition(IDEHelper iDEHelper, StringBuilderEx script, String strAlias, DGModelSingleLogicConfig dgModelSingleLogicConfig) {
        CallResult callResult = new CallResult();
        callResult.setRetCode(0);
        if (iDEHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u8f85\u52a9\u5bf9\u8c61");
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        IDEFHelper iDEFHelper = iDEHelper.GetDEFHelper(dgModelSingleLogicConfig.getDEField());
        if (iDEFHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)dgModelSingleLogicConfig.getDEField()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        return this.GetSingleConditionSQL(iDEHelper, strAlias, iDEFHelper, dgModelSingleLogicConfig.getFunc(), dgModelSingleLogicConfig.getCondition(), dgModelSingleLogicConfig.getValue());
    }

    public boolean AddCondition(IDEFHelper iDEFHelper, SearchItemConfig searchItemConfig, String strValue) {
        return this.AddCondition(iDEFHelper, searchItemConfig.getFunc(), searchItemConfig.getAction(), strValue);
    }

    public boolean AddCondition(IDEFHelper iDEFHelper, String strFunc, String strCondition, String strValue) {
        return this.AddCondition(this.getDEHelper(), iDEFHelper, strFunc, strCondition, strValue);
    }

    protected boolean AddCondition(IDEHelper iDEHelper, IDEFHelper iDEFHelper, String strFunc, String strCondition, String strValue) {
        if (iDEHelper == null) {
            log.error((Object)StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u8f85\u52a9\u5bf9\u8c61"));
            return false;
        }
        if (StringHelper.IsNullOrEmpty((String)strFunc)) {
            String strDataType = iDEFHelper.GetStdDataType();
            if (StringHelper.IsNullOrEmpty((String)strDataType)) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]\u7684\u6570\u636e\u7c7b\u578b", (Object)iDEFHelper.GetFullName()));
                return false;
            }
            String strSQL = this.GetConditionSQL("m1." + iDEFHelper.GetDTColumn().GetColumnName(), strDataType, strCondition, strValue);
            if (StringHelper.IsNullOrEmpty((String)strSQL)) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6761\u4ef6\u8bed\u53e5"));
                return false;
            }
            this.mainConditions.add(strSQL);
            return true;
        }
        return false;
    }

    protected CallResult GetSingleConditionSQL(IDEHelper iDEHelper, String strAlias, IDEFHelper iDEFHelper, String strFunc, String strCondition, String strValue) {
        CallResult callResult = new CallResult();
        if (iDEHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u8f85\u52a9\u5bf9\u8c61"));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        if (StringHelper.IsNullOrEmpty((String)strFunc)) {
            String strDataType = iDEFHelper.GetStdDataType();
            if (StringHelper.IsNullOrEmpty((String)strDataType)) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]\u7684\u6570\u636e\u7c7b\u578b", (Object)iDEFHelper.GetFullName()));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            String strFieldName = "";
            strFieldName = StringHelper.IsNullOrEmpty((String)strAlias) ? iDEFHelper.GetDTColumn().GetColumnName() : StringHelper.Format((String)"%1$s.%2$s", (Object)strAlias, (Object)iDEFHelper.GetDTColumn().GetColumnName());
            String strSQL = this.GetConditionSQL(strFieldName, strDataType, strCondition, strValue);
            if (StringHelper.IsNullOrEmpty((String)strSQL)) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6761\u4ef6\u8bed\u53e5"));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            callResult.setUserObject((Object)strSQL);
            callResult.setRetCode(0);
            return callResult;
        }
        callResult.setRetCode(1);
        return callResult;
    }

    @Override
    public void AddJoinQuery(DGModelJoinQueryConfig joinQueryConfig) {
        this.InternalAddJoinQuery(this.iDEHelper.getDataEntity(), "m1", joinQueryConfig);
    }

    @Override
    public void AddJoinQuery(String strDBObject, String strRawCondition) {
    }

    protected void InternalAddJoinQuery(DataEntity mainDataEntity, String strDBObjectId, DGModelJoinQueryConfig joinQueryConfig) {
    }

    @Override
    public String GetTotalRowSQL() {
        StringBuilderEx sql = new StringBuilderEx();
        sql.Append(this.GetCountSQL());
        sql.Append("\r\n");
        for (String strJoinQuery : this.joinQueries) {
            sql.Append("%1$s \r\n", (Object)strJoinQuery);
        }
        if (this.mainConditions.size() > 0) {
            sql.Append(" WHERE ");
            boolean bFirstKey = true;
            for (String strCondition : this.mainConditions) {
                if (bFirstKey) {
                    bFirstKey = false;
                } else {
                    sql.Append(" AND ");
                }
                sql.Append(" (%1$s) ", (Object)strCondition);
            }
        }
        sql.Append(";\r\n");
        return sql.toString();
    }

    @Override
    public String GetQuerySQL() {
        StringBuilderEx sql = new StringBuilderEx();
        sql.Append(this.GetQueryStartSQL());
        sql.Append("\r\n");
        for (String strJoinQuery : this.joinQueries) {
            sql.Append("%1$s \r\n", (Object)strJoinQuery);
        }
        if (this.mainConditions.size() > 0) {
            sql.Append(" WHERE ");
            boolean bFirstKey = true;
            for (String strCondition : this.mainConditions) {
                if (bFirstKey) {
                    bFirstKey = false;
                } else {
                    sql.Append(" AND ");
                }
                sql.Append(" (%1$s) ", (Object)strCondition);
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)this.strMajorOrder)) {
            sql.Append(" ORDER BY m1.%1$s %2$s ", (Object)this.strMajorOrder, (Object)this.strMajorDirection);
            if (!StringHelper.IsNullOrEmpty((String)this.strMinorOrder)) {
                sql.Append(",m1.%1$s %2$s ", (Object)this.strMinorOrder, (Object)this.strMinorDirection);
            }
        }
        sql.Append(this.GetQueryEndSQL());
        sql.Append(";\r\n");
        return sql.toString();
    }

    @Override
    public void SetOrderInfo(String strMajor, String strMajorDirection, String strMinor, String strMinorDirection) {
        this.strMajorOrder = strMajor;
        this.strMinorOrder = strMinor;
        this.strMajorDirection = strMajorDirection;
        this.strMinorDirection = strMinorDirection;
    }

    @Override
    public void SetPageInfo(int startPos, int endPos) {
        this.nStartPos = startPos;
        this.nPageSize = endPos;
    }

    protected String GetValidSQL() {
        return "(m1.enable = 1)";
    }

    protected String GetConditionSQL(String strFieldName, String strDataType, String strCondition, String strValue) {
        if (StringHelper.Compare((String)strCondition, (String)"ISNULL", (boolean)true) == 0) {
            return StringHelper.Format((String)"%1$s IS NULL", (Object)strFieldName);
        }
        if (StringHelper.Compare((String)strCondition, (String)"ISNOTNULL", (boolean)true) == 0) {
            return StringHelper.Format((String)"%1$s IS NOT NULL", (Object)strFieldName);
        }
        int nDataType = DataTypeHelper.FromString((String)strDataType);
        if (DataTypeHelper.IsStringType((int)nDataType)) {
            return this.GetStringConditionSQL(strFieldName, nDataType, strCondition, strValue);
        }
        if (DataTypeHelper.IsIntType((int)nDataType)) {
            return this.GetIntConditionSQL(strFieldName, nDataType, strCondition, strValue);
        }
        if (DataTypeHelper.IsDoubleType((int)nDataType)) {
            return this.GetDoubleConditionSQL(strFieldName, nDataType, strCondition, strValue);
        }
        if (DataTypeHelper.IsDateTimeType((int)nDataType)) {
            return this.GetDateTimeConditionSQL(strFieldName, nDataType, strCondition, strValue);
        }
        return "";
    }

    protected String GetStringConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue) {
        if (StringHelper.Compare((String)strCondition, (String)"=", (boolean)true) == 0) {
            strValue = strValue.replace("'", "''");
            return StringHelper.Format((String)"%1$s = '%2$s'", (Object)strFieldName, (Object)strValue);
        }
        if (StringHelper.Compare((String)strCondition, (String)"<>", (boolean)true) == 0) {
            strValue = strValue.replace("'", "''");
            return StringHelper.Format((String)"%1$s <> '%2$s'", (Object)strFieldName, (Object)strValue);
        }
        if (StringHelper.Compare((String)strCondition, (String)"LIKE", (boolean)true) == 0) {
            strValue = strValue.replace("'", "''");
            strValue = "%" + strValue + "%";
            return StringHelper.Format((String)"%1$s LIKE '%2$s'", (Object)strFieldName, (Object)strValue);
        }
        if (StringHelper.Compare((String)strCondition, (String)"LEFTLIKE", (boolean)true) == 0) {
            strValue = strValue.replace("'", "''");
            strValue = String.valueOf(strValue) + "%";
            return StringHelper.Format((String)"%1$s LIKE '%2$s'", (Object)strFieldName, (Object)strValue);
        }
        if (StringHelper.Compare((String)strCondition, (String)"RIGHTLIKE", (boolean)true) == 0) {
            strValue = strValue.replace("'", "''");
            strValue = "%" + strValue;
            return StringHelper.Format((String)"%1$s LIKE '%2$s'", (Object)strFieldName, (Object)strValue);
        }
        return "";
    }

    protected String GetIntConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue) {
        Object objValue = DataTypeParse.TestBigInt((String)strValue);
        if (objValue == null) {
            log.error((Object)StringHelper.Format((String)"\u503c[%1$s]\u975e\u6574\u6570\u503c", (Object)strValue));
            return "";
        }
        if (StringHelper.Compare((String)strCondition, (String)"=", (boolean)true) == 0) {
            return StringHelper.Format((String)"%1$s = %2$s", (Object)strFieldName, (Object)strValue);
        }
        if (StringHelper.Compare((String)strCondition, (String)"<>", (boolean)true) == 0) {
            return StringHelper.Format((String)"%1$s <> %2$s", (Object)strFieldName, (Object)strValue);
        }
        if (StringHelper.Compare((String)strCondition, (String)">", (boolean)true) == 0) {
            return StringHelper.Format((String)"%1$s > %2$s", (Object)strFieldName, (Object)strValue);
        }
        if (StringHelper.Compare((String)strCondition, (String)">=", (boolean)true) == 0) {
            return StringHelper.Format((String)"%1$s >= %2$s", (Object)strFieldName, (Object)strValue);
        }
        if (StringHelper.Compare((String)strCondition, (String)"<", (boolean)true) == 0) {
            return StringHelper.Format((String)"%1$s < %2$s", (Object)strFieldName, (Object)strValue);
        }
        if (StringHelper.Compare((String)strCondition, (String)"<=", (boolean)true) == 0) {
            return StringHelper.Format((String)"%1$s <= %2$s", (Object)strFieldName, (Object)strValue);
        }
        return "";
    }

    protected String GetDoubleConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue) {
        Object objValue = DataTypeParse.TestBigInt((String)strValue);
        if (objValue == null) {
            log.error((Object)StringHelper.Format((String)"\u503c[%1$s]\u975e\u6d6e\u70b9\u503c", (Object)strValue));
            return "";
        }
        if (StringHelper.Compare((String)strCondition, (String)"=", (boolean)true) == 0) {
            return StringHelper.Format((String)"%1$s = %2$s", (Object)strFieldName, (Object)strValue);
        }
        if (StringHelper.Compare((String)strCondition, (String)"<>", (boolean)true) == 0) {
            return StringHelper.Format((String)"%1$s <> %2$s", (Object)strFieldName, (Object)strValue);
        }
        if (StringHelper.Compare((String)strCondition, (String)">", (boolean)true) == 0) {
            return StringHelper.Format((String)"%1$s > %2$s", (Object)strFieldName, (Object)strValue);
        }
        if (StringHelper.Compare((String)strCondition, (String)">=", (boolean)true) == 0) {
            return StringHelper.Format((String)"%1$s >= %2$s", (Object)strFieldName, (Object)strValue);
        }
        if (StringHelper.Compare((String)strCondition, (String)"<", (boolean)true) == 0) {
            return StringHelper.Format((String)"%1$s < %2$s", (Object)strFieldName, (Object)strValue);
        }
        if (StringHelper.Compare((String)strCondition, (String)"<=", (boolean)true) == 0) {
            return StringHelper.Format((String)"%1$s <= %2$s", (Object)strFieldName, (Object)strValue);
        }
        return "";
    }

    protected String GetDateTimeConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue) {
        Object objValue = DataTypeParse.TestDateTime((String)strValue);
        if (objValue == null) {
            log.error((Object)StringHelper.Format((String)"\u503c[%1$s]\u975e\u65e5\u671f\u65f6\u95f4\u6027", (Object)strValue));
            return "";
        }
        if (StringHelper.Compare((String)strCondition, (String)"=", (boolean)true) == 0) {
            return StringHelper.Format((String)"%1$s = '%2$s'", (Object)strFieldName, (Object)strValue);
        }
        if (StringHelper.Compare((String)strCondition, (String)"<>", (boolean)true) == 0) {
            return StringHelper.Format((String)"%1$s <> '%2$s'", (Object)strFieldName, (Object)strValue);
        }
        if (StringHelper.Compare((String)strCondition, (String)">", (boolean)true) == 0) {
            return StringHelper.Format((String)"%1$s > '%2$s'", (Object)strFieldName, (Object)strValue);
        }
        if (StringHelper.Compare((String)strCondition, (String)">=", (boolean)true) == 0) {
            return StringHelper.Format((String)"%1$s >= '%2$s'", (Object)strFieldName, (Object)strValue);
        }
        if (StringHelper.Compare((String)strCondition, (String)"<", (boolean)true) == 0) {
            return StringHelper.Format((String)"%1$s < '%2$s'", (Object)strFieldName, (Object)strValue);
        }
        if (StringHelper.Compare((String)strCondition, (String)"<=", (boolean)true) == 0) {
            return StringHelper.Format((String)"%1$s <= '%2$s'", (Object)strFieldName, (Object)strValue);
        }
        return "";
    }

    protected String GetCountSQL() {
        return StringHelper.Format((String)"select count(*) as TOTALROW from %1$s m1", (Object)this.iDEHelper.getDataEntity().getVIEWNAME());
    }

    protected String GetQueryStartSQL() {
        return "";
    }

    protected String GetQueryEndSQL() {
        return "";
    }

    public void Reset() {
    }

    protected synchronized String GetDBObjectId() {
        ++this.nDBObjectId;
        return StringHelper.Format((String)"t%1$s", (Object)this.nDBObjectId);
    }
}

