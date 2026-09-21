/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.Helper
 */
package SA.SRFramework.WebEx.DataGrid;

import SA.SRFramework.Utility.Helper;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.UI.DataGridColumnEditorConfig;

public class SRFExDataGridBaseEditor {
    protected SRFExDataGrid dataGrid = null;
    protected DataGridColumnEditorConfig baseConfig = null;
    public static final String TAG_GRIDEDITOR = "_GRIDEDITOR";
    protected String strUniqueId = Helper.GenGuid();

    public void setConfig(DataGridColumnEditorConfig config) {
        this.baseConfig = config;
        this.OnSetConfig();
    }

    public DataGridColumnEditorConfig getConfig() {
        return this.baseConfig;
    }

    protected void OnSetConfig() {
    }

    public SRFExDataGrid getDataGrid() {
        return this.dataGrid;
    }

    public void setDataGrid(SRFExDataGrid dataGrid) {
        this.dataGrid = dataGrid;
    }

    public String RenderHTMLCode() {
        return this.OnRenderHTMLCode();
    }

    protected String OnRenderHTMLCode() {
        if (this.baseConfig != null) {
            return this.baseConfig.getHTMLCode();
        }
        return "";
    }

    public String RenderJSCode() {
        return this.OnRenderJSCode();
    }

    protected String OnRenderJSCode() {
        if (this.baseConfig != null) {
            return this.baseConfig.getJSCode();
        }
        return "";
    }

    protected SRFExWebContext getWebContext() {
        if (this.dataGrid != null) {
            return this.dataGrid.getWebContext();
        }
        return null;
    }

    public String getUniqueID() {
        if (this.dataGrid != null && this.baseConfig != null) {
            return String.valueOf(this.dataGrid.getUniqueID()) + "_ED_" + this.baseConfig.getID();
        }
        return this.strUniqueId;
    }
}

