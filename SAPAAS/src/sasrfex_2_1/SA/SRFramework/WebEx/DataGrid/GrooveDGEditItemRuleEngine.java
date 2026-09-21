/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.WebEx.DataGrid;

import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.WebEx.DataGrid.ISRFExDGEditItemRuleEngine;
import SA.SRFramework.WebEx.ISRFExWebContext;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.UI.DataGridEditItemConfig;
import SA.SRFramework.WebEx.Utility.GrooveRuleEngine;

public class GrooveDGEditItemRuleEngine
extends GrooveRuleEngine
implements ISRFExDGEditItemRuleEngine {
    protected SRFExDataGrid dataGrid = null;

    @Override
    public boolean Init(SRFExDataGrid dataGrid, BaseDataEntity dataEntity) {
        this.dataGrid = dataGrid;
        this.dataEntity = dataEntity;
        return true;
    }

    @Override
    public boolean TestAllowEmpty(DataGridEditItemConfig dgEditItemConfig) {
        return this.InternalTest(dgEditItemConfig.getAllowEmptyCond(), false);
    }

    @Override
    public boolean TestProcess(DataGridEditItemConfig dgEditItemConfig) {
        return this.InternalTest(dgEditItemConfig.getValidCond(), false);
    }

    @Override
    public boolean TestValueRule(DataGridEditItemConfig dgEditItemConfig, Object objValue, String strValue) {
        return this.InternalTest(dgEditItemConfig.getValueRuleCode(), false);
    }

    @Override
    public boolean TestValueRule(DataGridEditItemConfig dgEditItemConfig) {
        return this.TestValueRule(dgEditItemConfig, null, null);
    }

    @Override
    protected ISRFExWebContext GetWebContext() {
        return this.dataGrid.getPage().getWebContext();
    }
}

