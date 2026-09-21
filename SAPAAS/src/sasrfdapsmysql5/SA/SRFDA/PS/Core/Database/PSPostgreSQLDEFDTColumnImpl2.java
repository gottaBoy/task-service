/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.Database.PSPostgreSQLDEFDTColumnImpl;
import SA.SRFramework.Utility.StringHelper;

public class PSPostgreSQLDEFDTColumnImpl2
extends PSPostgreSQLDEFDTColumnImpl {
    @Override
    protected String onGetDBDataType(boolean bAppendNullFlag, boolean bAllowNull, boolean bAppendDefault, String strDefault) throws Exception {
        int nStdDataType = this.iPSDEField.getStdDataType();
        if (nStdDataType == 5) {
            String strDBType = "";
            strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" TIMESTAMP ");
            if (bAppendNullFlag) {
                strDBType = bAllowNull ? String.valueOf(strDBType) + StringHelper.Format((String)" NULL ") : String.valueOf(strDBType) + StringHelper.Format((String)" NOT NULL ");
            }
            return strDBType;
        }
        return super.onGetDBDataType(bAppendNullFlag, bAllowNull, bAppendDefault, strDefault);
    }
}

