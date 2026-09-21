/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Database.PSDBTypeImpl
 *  SA.SRFDA.PS.Core.Database.PSDEFDTColumnImpl
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.Database.PSDBTypeImpl;
import SA.SRFDA.PS.Core.Database.PSDEFDTColumnImpl;
import SA.SRFramework.Utility.StringHelper;

public class PSPPASDEFDTColumnImpl
extends PSDEFDTColumnImpl {
    public int getJDBCType() throws Exception {
        return PSDBTypeImpl.getJDBCType((int)this.iPSDEField.getStdDataType());
    }

    protected String onGetDBType() {
        return "PPAS";
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
                strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" CLOB ");
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
                strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" FLOAT ");
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
                strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" BLOB ");
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
                return "FLOAT";
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
            case 6: {
                return "DECIMAL";
            }
        }
        return "";
    }
}

