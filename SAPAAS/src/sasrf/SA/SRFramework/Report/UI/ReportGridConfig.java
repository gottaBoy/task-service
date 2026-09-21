/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Report.UI;

import SA.SRFramework.Report.UI.BaseGridConfig;
import SA.SRFramework.Report.UI.DataGridValueCellConfig;
import SA.SRFramework.Report.UI.DataGridXYCellConfig;

public class ReportGridConfig
extends BaseGridConfig {
    private DataGridValueCellConfig dataGridValueCellConfig = new DataGridValueCellConfig();
    private DataGridXYCellConfig dataGridXYCellConfig = new DataGridXYCellConfig();

    public DataGridValueCellConfig getValueCellConfig() {
        return this.dataGridValueCellConfig;
    }

    public void setValueCellConfig(DataGridValueCellConfig value) {
        this.dataGridValueCellConfig = value;
    }

    public DataGridXYCellConfig getXYCellConfig() {
        return this.dataGridXYCellConfig;
    }

    public void setXYCellConfig(DataGridXYCellConfig value) {
        this.dataGridXYCellConfig = value;
    }
}

