/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataRow
 */
package SA.SRFramework.WebEx.DGEx;

import SA.SRFramework.Data.DataRow;

public class DataRowHelper {
    protected DataRow dr = null;

    public DataRowHelper(DataRow dr) {
        this.dr = dr;
    }

    public Object Val(String strField) {
        return this.Val(strField, null);
    }

    public Object Val(String strField, Object objDefault) {
        try {
            if (this.dr.IsDBNull(strField)) {
                return objDefault;
            }
            return this.dr.Get(strField);
        }
        catch (Exception e) {
            e.printStackTrace();
            return objDefault;
        }
    }
}

