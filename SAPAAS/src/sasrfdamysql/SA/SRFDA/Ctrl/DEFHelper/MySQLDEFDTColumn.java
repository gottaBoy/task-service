/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.DEFDTColumn
 *  SA.SRFramework.Data.DB2.DB2DBProcCaller
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.DEFHelper;

import SA.SRFDA.Ctrl.DEFHelper.DEFDTColumn;
import SA.SRFramework.Data.DB2.DB2DBProcCaller;
import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.Utility.StringHelper;

public class MySQLDEFDTColumn
extends DEFDTColumn {
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
            return "VARCHAR";
        }
        if (StringHelper.Compare((String)strStdDataType, (String)"TEXT", (boolean)true) == 0) {
            return "LONGTEXT";
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
            return "DATE";
        }
        if (StringHelper.Compare((String)strStdDataType, (String)"DECIMAL", (boolean)true) == 0) {
            return "DECIMAL";
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
            strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" VARCHAR(%1$s) ", (Object)nLength);
            if (appendNullFlag) {
                strDBType = allowNull ? String.valueOf(strDBType) + StringHelper.Format((String)" NULL ") : String.valueOf(strDBType) + StringHelper.Format((String)" NOT NULL ");
            }
            return strDBType;
        }
        if (StringHelper.Compare((String)strStdDataType, (String)"TEXT", (boolean)true) == 0) {
            String strDBType = "";
            strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" LONGTEXT ");
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
            strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" DATE ");
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
}

