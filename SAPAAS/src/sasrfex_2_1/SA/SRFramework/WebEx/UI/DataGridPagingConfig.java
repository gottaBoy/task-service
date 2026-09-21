/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.WebEx.UI.DataGridConfig;
import SA.SRFramework.WebEx.UI.PagingToolbarConfig;

public class DataGridPagingConfig
extends PagingToolbarConfig {
    public static final String TAG_SRFEXDATAGRIDPAGING = "SRFEXDATAGRIDPAGING";
    protected DataGridConfig dataGridConfig = null;

    public void setDataGridConfig(DataGridConfig dataGridConfig) {
        this.dataGridConfig = dataGridConfig;
    }

    public DataGridConfig getDataGridConfig() {
        return this.dataGridConfig;
    }
}

