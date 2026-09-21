/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.ValueRule;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.ValueRule.ValueRuleEngineContext;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.UI.DataGridEditItemConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DataGridValueRuleEngineContext
extends ValueRuleEngineContext {
    private static final Log log = LogFactory.getLog(DataGridValueRuleEngineContext.class);
    protected SRFExDataGrid dataGrid = null;

    public SRFExDataGrid getDataGrid() {
        return this.dataGrid;
    }

    public void setDataGrid(SRFExDataGrid dataGrid) {
        this.dataGrid = dataGrid;
    }

    @Override
    public String GetDataEntityParamInfo(String strParamName) {
        if (this.getDataGrid() != null) {
            DataGridEditItemConfig itemConfig = this.getDataGrid().getDataGridConfig().getDataGridDSConfig().FindDataGridEditItem(strParamName);
            if (itemConfig == null) {
                return strParamName;
            }
            if (StringHelper.Length((String)itemConfig.getName()) > 0) {
                return itemConfig.getName();
            }
            return strParamName;
        }
        return super.GetDataEntityParamInfo(strParamName);
    }
}

