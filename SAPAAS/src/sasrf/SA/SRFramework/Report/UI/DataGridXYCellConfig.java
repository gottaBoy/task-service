/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Report.UI;

import SA.SRFramework.Report.UI.DataGridXAxisConfig;
import SA.SRFramework.Report.UI.DataGridYAxisConfig;
import SA.SRFramework.Web.UI.BaseTableCellConfig;

public class DataGridXYCellConfig
extends BaseTableCellConfig {
    private DataGridXAxisConfig dataGridXAxisConfig = new DataGridXAxisConfig();
    private DataGridYAxisConfig dataGridYAxisConfig = new DataGridYAxisConfig();

    public DataGridXAxisConfig getXAxisConfig() {
        return this.dataGridXAxisConfig;
    }

    public DataGridYAxisConfig getYAxisConfig() {
        return this.dataGridYAxisConfig;
    }

    public void setXAxisConfig(DataGridXAxisConfig value) {
        this.dataGridXAxisConfig = value;
    }

    public void setYAxisConfig(DataGridYAxisConfig value) {
        this.dataGridYAxisConfig = value;
    }
}

