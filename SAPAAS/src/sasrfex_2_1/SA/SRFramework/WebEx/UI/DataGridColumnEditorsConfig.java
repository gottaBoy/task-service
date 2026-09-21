/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.CollectionXMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Base.CollectionXMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.DataGrid.UI.DataGridACEditorConfig;
import SA.SRFramework.WebEx.DataGrid.UI.DataGridComboEditorConfig;
import SA.SRFramework.WebEx.DataGrid.UI.DataGridPickerEditorConfig;
import SA.SRFramework.WebEx.DataGrid.UI.DataGridTextEditorConfig;
import SA.SRFramework.WebEx.UI.DataGridColumnEditorConfig;
import SA.SRFramework.WebEx.UI.DataGridConfig;
import org.w3c.dom.Node;

public class DataGridColumnEditorsConfig
extends CollectionXMLConfig {
    public static final String TAG_SRFEXDATAGRIDCOLUMNEDITORS = "SRFEXDATAGRIDCOLUMNEDITORS";
    protected DataGridConfig dataGridConfig = null;

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXDATAGRIDCOLUMNEDITOR", (boolean)true) == 0) {
            DataGridColumnEditorConfig dataGridColumnEditorConfig = new DataGridColumnEditorConfig();
            dataGridColumnEditorConfig.setDataGridConfig(this.dataGridConfig);
            if (dataGridColumnEditorConfig.LoadConfig(xmlNode)) {
                this.arrayList.add(dataGridColumnEditorConfig);
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXDATAGRIDACEDITOR", (boolean)true) == 0) {
            DataGridACEditorConfig dataGridACEditorConfig = new DataGridACEditorConfig();
            dataGridACEditorConfig.setDataGridConfig(this.dataGridConfig);
            if (dataGridACEditorConfig.LoadConfig(xmlNode)) {
                this.arrayList.add(dataGridACEditorConfig);
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXDATAGRIDTEXTEDITOR", (boolean)true) == 0) {
            DataGridTextEditorConfig dataGridTextEditorConfig = new DataGridTextEditorConfig();
            dataGridTextEditorConfig.setDataGridConfig(this.dataGridConfig);
            if (dataGridTextEditorConfig.LoadConfig(xmlNode)) {
                this.arrayList.add(dataGridTextEditorConfig);
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXDATAGRIDCOMBOEDITOR", (boolean)true) == 0) {
            DataGridComboEditorConfig dataGridComboEditorConfig = new DataGridComboEditorConfig();
            dataGridComboEditorConfig.setDataGridConfig(this.dataGridConfig);
            if (dataGridComboEditorConfig.LoadConfig(xmlNode)) {
                this.arrayList.add(dataGridComboEditorConfig);
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXDATAGRIDPICKEREDITOR", (boolean)true) == 0) {
            DataGridPickerEditorConfig dataGridPickerEditorConfig = new DataGridPickerEditorConfig();
            dataGridPickerEditorConfig.setDataGridConfig(this.dataGridConfig);
            if (dataGridPickerEditorConfig.LoadConfig(xmlNode)) {
                this.arrayList.add(dataGridPickerEditorConfig);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public DataGridConfig getDataGridConfig() {
        return this.dataGridConfig;
    }

    public void setDataGridConfig(DataGridConfig dataGridConfig) {
        this.dataGridConfig = dataGridConfig;
    }
}

