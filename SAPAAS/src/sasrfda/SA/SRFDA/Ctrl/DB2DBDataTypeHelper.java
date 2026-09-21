/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDBDataTypeHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;

public class DB2DBDataTypeHelper
extends BaseDBDataTypeHelper {
    @Override
    public String GetString(int nLength, boolean bAppendNullFlag, boolean bAllowNull, boolean bAppendDefault, String strDefault) {
        StringBuilderEx sql = new StringBuilderEx();
        sql.Append(" VARCHAR(%1$s)", (Object)nLength);
        this.AppendNullAndDefault(sql, bAppendNullFlag, bAllowNull, bAppendDefault, strDefault);
        return sql.toString();
    }

    protected void AppendNullAndDefault(StringBuilderEx sql, boolean bAppendNullFlag, boolean bAllowNull, boolean bAppendDefault, String strDefault) {
        if (bAppendNullFlag) {
            if (bAllowNull) {
                sql.Append(" NULL");
            } else {
                sql.Append(" NOT NULL");
            }
        } else if (bAppendDefault) {
            sql.Append(" default %1$s", (Object)strDefault);
        }
    }
}

