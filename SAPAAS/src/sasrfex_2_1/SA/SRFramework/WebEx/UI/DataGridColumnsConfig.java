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
import SA.SRFramework.WebEx.UI.DataGridColumnConfig;
import SA.SRFramework.WebEx.UI.DataGridConfig;
import org.w3c.dom.Node;

public class DataGridColumnsConfig
extends CollectionXMLConfig {
    public static final String TAG_SRFEXDATAGRIDCOLUMNS = "SRFEXDATAGRIDCOLUMNS";
    protected DataGridConfig dataGridConfig = null;
    public static final String TAG_AUTPEXPANDCOLUMN = "AUTPEXPANDCOLUMN";
    protected String strAutoExpandColumn = "";

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXDATAGRIDCOLUMN", (boolean)true) == 0) {
            DataGridColumnConfig dataGridColumnConfig = new DataGridColumnConfig();
            dataGridColumnConfig.setDataGridConfig(this.dataGridConfig);
            if (dataGridColumnConfig.LoadConfig(xmlNode)) {
                this.arrayList.add(dataGridColumnConfig);
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

    public DataGridColumnConfig FindDataGridColumnConfig(String strDSItem) {
        int nCount = this.arrayList.size();
        int i = 0;
        while (i < nCount) {
            DataGridColumnConfig dataGridColumnConfig = (DataGridColumnConfig)((Object)this.arrayList.get(i));
            if (StringHelper.Compare((String)dataGridColumnConfig.getDSItem(), (String)strDSItem, (boolean)true) == 0) {
                return dataGridColumnConfig;
            }
            ++i;
        }
        return null;
    }

    public DataGridColumnConfig FindDataGridColumnConfigByDSItem(String strDSItem) {
        return this.FindDataGridColumnConfig(strDSItem);
    }

    public DataGridColumnConfig FindDataGridColumnConfigById(String strId) {
        int nCount = this.arrayList.size();
        int i = 0;
        while (i < nCount) {
            DataGridColumnConfig dataGridColumnConfig = (DataGridColumnConfig)((Object)this.arrayList.get(i));
            if (StringHelper.Compare((String)dataGridColumnConfig.getID(), (String)strId, (boolean)true) == 0) {
                return dataGridColumnConfig;
            }
            ++i;
        }
        return null;
    }

    public void MoveColumn(DataGridColumnConfig dataGridColumnConfig, int nPos) {
        if (!this.arrayList.contains((Object)dataGridColumnConfig)) {
            return;
        }
        int nOrgIndex = this.arrayList.indexOf((Object)dataGridColumnConfig);
        if (nOrgIndex == nPos) {
            return;
        }
        this.arrayList.remove(nOrgIndex);
        if (nPos > this.arrayList.size()) {
            this.arrayList.add(dataGridColumnConfig);
        } else {
            this.arrayList.add(nPos, dataGridColumnConfig);
        }
    }

    public String getAutoExpandColumn() {
        return this.strAutoExpandColumn;
    }

    public void setAutoExpandColumn(String strAutoExpandColumn) {
        this.strAutoExpandColumn = strAutoExpandColumn;
    }
}

