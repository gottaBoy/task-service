/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDBCallerHelperEx
 */
package SA.SRFDA.EAI.Ctrl;

import SA.SRFramework.DataEx.BaseDBCallerHelperEx;
import javax.sql.DataSource;

public class EAIDBCallerHelperEx
extends BaseDBCallerHelperEx {
    protected DataSource dataSource = null;

    public DataSource getDataSource() {
        return this.dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}

