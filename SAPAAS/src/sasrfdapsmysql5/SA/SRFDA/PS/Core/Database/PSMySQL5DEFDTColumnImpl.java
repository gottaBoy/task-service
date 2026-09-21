/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Database.PSDBTypeImpl
 *  SA.SRFDA.PS.Core.Database.PSDEFDTColumnImpl
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.Database.PSDBTypeImpl;
import SA.SRFDA.PS.Core.Database.PSDEFDTColumnImpl;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;

public class PSMySQL5DEFDTColumnImpl
extends PSDEFDTColumnImpl {
    public int getJDBCType() throws Exception {
        return PSDBTypeImpl.getJDBCType((int)this.iPSDEField.getStdDataType());
    }

    protected String onGetDBType() {
        return "MYSQL5";
    }

    protected String onGetDBDataType(boolean bAppendNullFlag, boolean bAllowNull, boolean bAppendDefault, String strDefault) throws Exception {
        int nStdDataType = this.iPSDEField.getStdDataType();
        switch (nStdDataType) {
            case 25: {
                int nLength = this.getLength();
                if (nLength <= 0) {
                    nLength = 200;
                }
                if (nLength >= 4000) {
                    nLength = 4000;
                }
                String strDBType = "";
                strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" VARCHAR(%1$s) ", (Object)nLength);
                if (bAppendNullFlag) {
                    strDBType = bAllowNull ? String.valueOf(strDBType) + StringHelper.Format((String)" NULL ") : String.valueOf(strDBType) + StringHelper.Format((String)" NOT NULL ");
                }
                return strDBType;
            }
            case 21: {
                String strDBType = "";
                strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" MEDIUMTEXT ");
                if (bAppendNullFlag) {
                    strDBType = bAllowNull ? String.valueOf(strDBType) + StringHelper.Format((String)" NULL ") : String.valueOf(strDBType) + StringHelper.Format((String)" NOT NULL ");
                }
                return strDBType;
            }
            case 9: {
                String strDBType = "";
                strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" INTEGER ");
                if (this.isUnsigned()) {
                    strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" UNSIGNED ");
                }
                if (bAppendNullFlag) {
                    strDBType = bAllowNull ? String.valueOf(strDBType) + StringHelper.Format((String)" NULL ") : String.valueOf(strDBType) + StringHelper.Format((String)" NOT NULL ");
                }
                return strDBType;
            }
            case 1: {
                int nLength = this.getLength();
                if (nLength <= 0) {
                    nLength = 20;
                }
                String strDBType = "";
                strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" BIGINT(%1$s) ", (Object)nLength);
                if (this.isUnsigned()) {
                    strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" UNSIGNED ");
                }
                if (bAppendNullFlag) {
                    strDBType = bAllowNull ? String.valueOf(strDBType) + StringHelper.Format((String)" NULL ") : String.valueOf(strDBType) + StringHelper.Format((String)" NOT NULL ");
                }
                return strDBType;
            }
            case 7: {
                String strDBType = "";
                strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" DOUBLE ");
                if (bAppendNullFlag) {
                    strDBType = bAllowNull ? String.valueOf(strDBType) + StringHelper.Format((String)" NULL ") : String.valueOf(strDBType) + StringHelper.Format((String)" NOT NULL ");
                }
                return strDBType;
            }
            case 5: {
                String strDBType = "";
                strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" DATETIME ");
                if (bAppendNullFlag) {
                    strDBType = bAllowNull ? String.valueOf(strDBType) + StringHelper.Format((String)" NULL ") : String.valueOf(strDBType) + StringHelper.Format((String)" NOT NULL ");
                }
                return strDBType;
            }
            case 27: {
                String strDBType = "";
                strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" DATE ");
                if (bAppendNullFlag) {
                    strDBType = bAllowNull ? String.valueOf(strDBType) + StringHelper.Format((String)" NULL ") : String.valueOf(strDBType) + StringHelper.Format((String)" NOT NULL ");
                }
                return strDBType;
            }
            case 28: {
                String strDBType = "";
                strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" DATETIME ");
                if (bAppendNullFlag) {
                    strDBType = bAllowNull ? String.valueOf(strDBType) + StringHelper.Format((String)" NULL ") : String.valueOf(strDBType) + StringHelper.Format((String)" NOT NULL ");
                }
                return strDBType;
            }
            case 6: 
            case 29: {
                int nPRECISION;
                int nLength = this.getLength();
                if (nLength <= 0) {
                    nLength = 12;
                }
                if ((nPRECISION = this.iPSDEField.getPrecision()) <= 0) {
                    nPRECISION = 0;
                }
                String strDBType = "";
                strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" DECIMAL(%1$s,%2$s) ", (Object)nLength, (Object)nPRECISION);
                if (bAppendNullFlag) {
                    strDBType = bAllowNull ? String.valueOf(strDBType) + StringHelper.Format((String)" NULL ") : String.valueOf(strDBType) + StringHelper.Format((String)" NOT NULL ");
                }
                return strDBType;
            }
            case 24: {
                String strDBType = "";
                strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" MEDIUMBLOB ");
                if (bAppendNullFlag) {
                    strDBType = bAllowNull ? String.valueOf(strDBType) + StringHelper.Format((String)" NULL ") : String.valueOf(strDBType) + StringHelper.Format((String)" NOT NULL ");
                }
                return strDBType;
            }
        }
        return "";
    }

    protected String onGetDBDataType() throws Exception {
        int nStdDataType = this.iPSDEField.getStdDataType();
        switch (nStdDataType) {
            case 25: {
                return "VARCHAR";
            }
            case 21: {
                return "CLOB";
            }
            case 9: {
                return "INTEGER";
            }
            case 7: {
                return "DOUBLE";
            }
            case 5: {
                return "DATETIME";
            }
            case 27: {
                return "DATE";
            }
            case 28: {
                return "DATETIME";
            }
        }
        return "";
    }

    protected String getStringConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue, String strParamName, String strParamArg) throws Exception {
        if (StringHelper.IsNullOrEmpty((String)strParamName)) {
            if (StringHelper.Compare((String)strCondition, (String)"EQ", (boolean)true) == 0 || StringHelper.Compare((String)strCondition, (String)"ABSEQ", (boolean)true) == 0) {
                strValue = strValue.replace("'", "''");
                return StringHelper.Format((String)"%1$s = '%2$s'", (Object)strFieldName, (Object)strValue);
            }
            if (StringHelper.Compare((String)strCondition, (String)"NOTEQ", (boolean)true) == 0) {
                strValue = strValue.replace("'", "''");
                return StringHelper.Format((String)"%1$s <> '%2$s'", (Object)strFieldName, (Object)strValue);
            }
            if (StringHelper.Compare((String)strCondition, (String)"GT", (boolean)true) == 0) {
                strValue = strValue.replace("'", "''");
                return StringHelper.Format((String)"%1$s > '%2$s'", (Object)strFieldName, (Object)strValue);
            }
            if (StringHelper.Compare((String)strCondition, (String)"GTANDEQ", (boolean)true) == 0) {
                strValue = strValue.replace("'", "''");
                return StringHelper.Format((String)"%1$s >= '%2$s'", (Object)strFieldName, (Object)strValue);
            }
            if (StringHelper.Compare((String)strCondition, (String)"LT", (boolean)true) == 0) {
                strValue = strValue.replace("'", "''");
                return StringHelper.Format((String)"%1$s < '%2$s'", (Object)strFieldName, (Object)strValue);
            }
            if (StringHelper.Compare((String)strCondition, (String)"LTANDEQ", (boolean)true) == 0) {
                strValue = strValue.replace("'", "''");
                return StringHelper.Format((String)"%1$s <= '%2$s'", (Object)strFieldName, (Object)strValue);
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
            if (StringHelper.Compare((String)strCondition, (String)"IN", (boolean)true) == 0 || StringHelper.Compare((String)strCondition, (String)"NOTIN", (boolean)true) == 0) {
                strValue = strValue.replace(",", ";");
                String[] items = StringHelper.SplitEx((String)(strValue = strValue.replace("'", "''")));
                if (items.length == 0) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u53c2\u6570");
                }
                StringBuilderEx sb = new StringBuilderEx();
                sb.Append(strFieldName);
                if (StringHelper.Compare((String)strCondition, (String)"NOTIN", (boolean)true) == 0) {
                    sb.Append(" NOT ");
                }
                sb.Append(" IN (");
                int i = 0;
                while (i < items.length) {
                    if (i != 0) {
                        sb.Append(",");
                    }
                    sb.Append("'%1$s'", (Object)items[i]);
                    ++i;
                }
                sb.Append(")");
                return sb.toString();
            }
        } else {
            if (StringHelper.Compare((String)strCondition, (String)"EQ", (boolean)true) == 0 || StringHelper.Compare((String)strCondition, (String)"ABSEQ", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s =  ${srf%2$s('%3$s','%4$s')}", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
            if (StringHelper.Compare((String)strCondition, (String)"NOTEQ", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s <>  ${srf%2$s('%3$s','%4$s')}", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
            if (StringHelper.Compare((String)strCondition, (String)"GT", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s >  ${srf%2$s('%3$s','%4$s')}", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
            if (StringHelper.Compare((String)strCondition, (String)"GTANDEQ", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s >=  ${srf%2$s('%3$s','%4$s')}", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
            if (StringHelper.Compare((String)strCondition, (String)"LT", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s <  ${srf%2$s('%3$s','%4$s')}", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
            if (StringHelper.Compare((String)strCondition, (String)"LTANDEQ", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s <=  ${srf%2$s('%3$s','%4$s')}", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
            if (StringHelper.Compare((String)strCondition, (String)"LIKE", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s LIKE  CONCAT('%%',${srf%2$s('%3$s','%4$s')},'%%')", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
            if (StringHelper.Compare((String)strCondition, (String)"LEFTLIKE", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s LIKE  CONCAT(${srf%2$s('%3$s','%4$s')},'%%')", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
            if (StringHelper.Compare((String)strCondition, (String)"RIGHTLIKE", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s LIKE  CONCAT('%%',${srf%2$s('%3$s','%4$s')})", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
            if (StringHelper.Compare((String)strCondition, (String)"IN", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s IN (${srf%2$s('%3$s','%4$s')})", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
            if (StringHelper.Compare((String)strCondition, (String)"NOTIN", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s NOT IN (${srf%2$s('%3$s','%4$s')})", (Object)strFieldName, (Object)strParamName, (Object)strValue, (Object)strParamArg);
            }
        }
        if (StringHelper.IsNullOrEmpty((String)strParamName)) {
            throw new Exception(StringHelper.Format((String)"\u4e0d\u652f\u6301\u6761\u4ef6\uff1a%1$s [%2$s] (%3$s)", (Object)strFieldName, (Object)strCondition, (Object)strValue));
        }
        throw new Exception(StringHelper.Format((String)"\u4e0d\u652f\u6301\u6761\u4ef6\uff1a%1$s [%2$s] %3$s(%4$s)", (Object)strFieldName, (Object)strCondition, (Object)strParamName, (Object)strValue));
    }
}

