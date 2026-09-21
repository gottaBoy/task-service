/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.DataGridConfig;

public class DataGridGroupConfig
extends XMLConfig {
    public static final String TAG_SRFEXDATAGRIDGROUP = "SRFEXDATAGRIDGROUP";
    public static final String TAG_GROUPITEM = "GROUPITEM";
    public static final String TAG_GROUPDIR = "GROUPDIR";
    protected DataGridConfig dataGridConfig = null;
    protected String strGroupItem = "";
    protected String strGroupDir = "";

    public void setDataGridConfig(DataGridConfig dataGridConfig) {
        this.dataGridConfig = dataGridConfig;
    }

    public DataGridConfig getDataGridConfig() {
        return this.dataGridConfig;
    }

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_GROUPITEM, (boolean)true) == 0) {
            this.strGroupItem = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_GROUPDIR, (boolean)true) == 0) {
            this.strGroupDir = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getGroupItem() {
        return this.strGroupItem;
    }

    public void setGroupItem(String strGroupItem) {
        this.strGroupItem = strGroupItem;
    }

    public String getGroupDir() {
        return this.strGroupDir;
    }

    public void setGroupDir(String strGroupDir) {
        this.strGroupDir = strGroupDir;
    }
}

