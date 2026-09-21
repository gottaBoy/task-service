/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.WebEx.DataGrid;

import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.UI.DataGridEditItemConfig;

public interface ISRFExDGEditItemRuleEngine {
    public boolean Init(SRFExDataGrid var1, BaseDataEntity var2);

    public boolean TestProcess(DataGridEditItemConfig var1);

    public boolean TestAllowEmpty(DataGridEditItemConfig var1);

    public boolean TestValueRule(DataGridEditItemConfig var1, Object var2, String var3);

    public boolean TestValueRule(DataGridEditItemConfig var1);
}

