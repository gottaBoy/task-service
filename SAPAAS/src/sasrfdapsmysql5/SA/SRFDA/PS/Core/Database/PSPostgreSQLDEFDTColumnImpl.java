/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.DataEntity.IPSDataEntity
 *  SA.SRFDA.PS.Core.Database.PSDBTypeImpl
 *  SA.SRFDA.PS.Core.Database.PSDEFDTColumnImpl
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.Database.PSDBTypeImpl;
import SA.SRFDA.PS.Core.Database.PSDEFDTColumnImpl;
import SA.SRFramework.Utility.StringHelper;

public class PSPostgreSQLDEFDTColumnImpl
extends PSDEFDTColumnImpl {
    public int getJDBCType() throws Exception {
        return PSDBTypeImpl.getJDBCType((int)this.iPSDEField.getStdDataType());
    }

    protected String onGetDBType() {
        return "POSTGRESQL";
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
                strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" TEXT ");
                if (bAppendNullFlag) {
                    strDBType = bAllowNull ? String.valueOf(strDBType) + StringHelper.Format((String)" NULL ") : String.valueOf(strDBType) + StringHelper.Format((String)" NOT NULL ");
                }
                return strDBType;
            }
            case 9: {
                String strDBType = "";
                strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" INTEGER ");
                if (bAppendNullFlag) {
                    strDBType = bAllowNull ? String.valueOf(strDBType) + StringHelper.Format((String)" NULL ") : String.valueOf(strDBType) + StringHelper.Format((String)" NOT NULL ");
                }
                return strDBType;
            }
            case 7: {
                String strDBType = "";
                strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" DOUBLE PRECISION");
                if (bAppendNullFlag) {
                    strDBType = bAllowNull ? String.valueOf(strDBType) + StringHelper.Format((String)" NULL ") : String.valueOf(strDBType) + StringHelper.Format((String)" NOT NULL ");
                }
                return strDBType;
            }
            case 5: {
                String strDBType = "";
                strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" DATE ");
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
                strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" DATE ");
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
                strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" BYTEA ");
                if (bAppendNullFlag) {
                    strDBType = bAllowNull ? String.valueOf(strDBType) + StringHelper.Format((String)" NULL ") : String.valueOf(strDBType) + StringHelper.Format((String)" NOT NULL ");
                }
                return strDBType;
            }
            case 1: {
                if (this.isAutoIncrement() && this.iPSDEDBConfig.getPSDataEntity().getSaaSMode() == IPSDataEntity.SAASMODE_NOTSUPPORTED.intValue()) {
                    return " BIGSERIAL ";
                }
                int nLength = this.getLength();
                String strDBType = "";
                strDBType = nLength > 0 ? String.valueOf(strDBType) + StringHelper.Format((String)" BIGINT(%1$s) ", (Object)nLength) : String.valueOf(strDBType) + StringHelper.Format((String)" BIGINT ");
                if (this.isUnsigned()) {
                    strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" UNSIGNED ");
                }
                if (bAppendNullFlag) {
                    strDBType = bAllowNull ? String.valueOf(strDBType) + StringHelper.Format((String)" NULL ") : String.valueOf(strDBType) + StringHelper.Format((String)" NOT NULL ");
                }
                return strDBType;
            }
            case 3: {
                String strDBType = "";
                strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" BOOLEAN ");
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
                return "TEXT";
            }
            case 9: {
                return "INTEGER";
            }
            case 7: {
                return "DOUBLE PERCISION";
            }
            case 5: {
                return "DATE";
            }
            case 27: {
                return "DATE";
            }
            case 28: {
                return "DATE";
            }
        }
        return "";
    }
}

