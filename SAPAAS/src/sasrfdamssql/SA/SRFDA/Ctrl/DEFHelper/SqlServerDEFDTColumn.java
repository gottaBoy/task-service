/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.DEFDTColumn
 *  SA.SRFDA.Model.IDAValueFunc
 *  SA.SRFDA.Model.SearchItemConfig
 *  SA.SRFramework.Data.DB2.DB2DBProcCaller
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.DataEx.ConditionHelper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.DEFHelper;

import SA.SRFDA.Ctrl.DEFHelper.DEFDTColumn;
import SA.SRFDA.Model.IDAValueFunc;
import SA.SRFDA.Model.SearchItemConfig;
import SA.SRFramework.Data.DB2.DB2DBProcCaller;
import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.DataEx.ConditionHelper;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SqlServerDEFDTColumn
extends DEFDTColumn {
    private static final Log log = LogFactory.getLog(SqlServerDEFDTColumn.class);

    public int GetJDBCType() {
        String strStdDataType = this.iDEFHelper.GetStdDataType();
        if (StringHelper.IsNullOrEmpty((String)strStdDataType)) {
            return -1;
        }
        int nType = DataTypeHelper.FromString((String)strStdDataType);
        return DB2DBProcCaller.GetJDBCType((int)nType);
    }

    protected String OnGetDBDataType() {
        String strStdDataType = this.iDEFHelper.GetStdDataType();
        if (StringHelper.Compare((String)strStdDataType, (String)"VARCHAR", (boolean)true) == 0) {
            if (this.iDEFHelper.getDEHelper().IsDBUnicodeChar()) {
                return "NVARCHAR";
            }
            return "VARCHAR";
        }
        if (StringHelper.Compare((String)strStdDataType, (String)"TEXT", (boolean)true) == 0) {
            if (this.iDEFHelper.getDEHelper().IsDBUnicodeChar()) {
                return "NTEXT";
            }
            return "TEXT";
        }
        if (StringHelper.Compare((String)strStdDataType, (String)"INT", (boolean)true) == 0) {
            return "INT";
        }
        if (StringHelper.Compare((String)strStdDataType, (String)"FLOAT", (boolean)true) == 0) {
            return "FLOAT";
        }
        if (StringHelper.Compare((String)strStdDataType, (String)"DATETIME", (boolean)true) == 0) {
            return "DATETIME";
        }
        if (StringHelper.Compare((String)strStdDataType, (String)"DATE", (boolean)true) == 0) {
            return "DATETIME";
        }
        return "";
    }

    protected String OnGetDBDataType(boolean appendNullFlag, boolean allowNull, boolean appendDefault, String strDefault) {
        String strStdDataType = this.iDEFHelper.GetStdDataType();
        if (StringHelper.Compare((String)strStdDataType, (String)"VARCHAR", (boolean)true) == 0) {
            int nLength = this.GetLength();
            if (nLength <= 0) {
                nLength = 200;
            }
            if (nLength >= 4000) {
                nLength = 4000;
            }
            String strDBType = "";
            strDBType = this.iDEFHelper.getDEHelper().IsDBUnicodeChar() ? String.valueOf(strDBType) + StringHelper.Format((String)" NVARCHAR(%1$s) ", (Object)nLength) : String.valueOf(strDBType) + StringHelper.Format((String)" VARCHAR(%1$s) ", (Object)nLength);
            if (appendNullFlag) {
                strDBType = allowNull ? String.valueOf(strDBType) + StringHelper.Format((String)" NULL ") : String.valueOf(strDBType) + StringHelper.Format((String)" NOT NULL ");
            }
            return strDBType;
        }
        if (StringHelper.Compare((String)strStdDataType, (String)"TEXT", (boolean)true) == 0) {
            String strDBType = "";
            strDBType = this.iDEFHelper.getDEHelper().IsDBUnicodeChar() ? String.valueOf(strDBType) + StringHelper.Format((String)" NTEXT ") : String.valueOf(strDBType) + StringHelper.Format((String)" TEXT ");
            if (appendNullFlag) {
                strDBType = allowNull ? String.valueOf(strDBType) + StringHelper.Format((String)" NULL ") : String.valueOf(strDBType) + StringHelper.Format((String)" NOT NULL ");
            }
            return strDBType;
        }
        if (StringHelper.Compare((String)strStdDataType, (String)"INT", (boolean)true) == 0) {
            String strDBType = "";
            strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" INT ");
            if (appendNullFlag) {
                strDBType = allowNull ? String.valueOf(strDBType) + StringHelper.Format((String)" NULL ") : String.valueOf(strDBType) + StringHelper.Format((String)" NOT NULL ");
            }
            return strDBType;
        }
        if (StringHelper.Compare((String)strStdDataType, (String)"FLOAT", (boolean)true) == 0) {
            String strDBType = "";
            strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" FLOAT ");
            if (appendNullFlag) {
                strDBType = allowNull ? String.valueOf(strDBType) + StringHelper.Format((String)" NULL ") : String.valueOf(strDBType) + StringHelper.Format((String)" NOT NULL ");
            }
            return strDBType;
        }
        if (StringHelper.Compare((String)strStdDataType, (String)"DATETIME", (boolean)true) == 0) {
            String strDBType = "";
            strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" DATETIME ");
            if (appendNullFlag) {
                strDBType = allowNull ? String.valueOf(strDBType) + StringHelper.Format((String)" NULL ") : String.valueOf(strDBType) + StringHelper.Format((String)" NOT NULL ");
            }
            return strDBType;
        }
        if (StringHelper.Compare((String)strStdDataType, (String)"DATE", (boolean)true) == 0) {
            String strDBType = "";
            strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" DATETIME ");
            if (appendNullFlag) {
                strDBType = allowNull ? String.valueOf(strDBType) + StringHelper.Format((String)" NULL ") : String.valueOf(strDBType) + StringHelper.Format((String)" NOT NULL ");
            }
            return strDBType;
        }
        if (StringHelper.Compare((String)strStdDataType, (String)"DECIMAL", (boolean)true) == 0) {
            int nPRECISION;
            int nLength = this.GetLength();
            if (nLength <= 0) {
                nLength = 12;
            }
            if ((nPRECISION = this.iDEFHelper.GetPrecision()) <= 0) {
                nPRECISION = 0;
            }
            String strDBType = "";
            strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" DECIMAL(%1$s,%2$s) ", (Object)nLength, (Object)nPRECISION);
            if (appendNullFlag) {
                strDBType = allowNull ? String.valueOf(strDBType) + StringHelper.Format((String)" NULL ") : String.valueOf(strDBType) + StringHelper.Format((String)" NOT NULL ");
            }
            return strDBType;
        }
        return "";
    }

    public String GetFormalColumnName() {
        return StringHelper.Format((String)"[%1$s]", (Object)this.GetColumnName());
    }

    public boolean IsSupportSearchAction(SearchItemConfig searchItemConfig) {
        String strSearchFunc = searchItemConfig.getFunc();
        String strDataType = "";
        if (!StringHelper.IsNullOrEmpty((String)strSearchFunc)) {
            IDAValueFunc iDAValueFunc = this.globalHelperEx.getDAConfigMgr().getValueFuncMgr().FindFunc(strSearchFunc);
            if (iDAValueFunc == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6SearchFunc[%1$s]\u5bf9\u5e94\u7684\u5bf9\u8c61", (Object)strSearchFunc));
                return false;
            }
            strDataType = iDAValueFunc.GetDataType();
        } else {
            strDataType = this.iDEFHelper.GetStdDataType();
        }
        if (StringHelper.Compare((String)strDataType, (String)"TEXT", (boolean)true) == 0 && StringHelper.Compare((String)searchItemConfig.getAction(), (String)"LIKE", (boolean)true) == 0) {
            return true;
        }
        return ConditionHelper.IsSupportDataType((String)strDataType, (String)searchItemConfig.getAction());
    }
}

