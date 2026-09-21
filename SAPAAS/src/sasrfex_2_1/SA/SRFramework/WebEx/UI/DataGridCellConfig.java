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

public class DataGridCellConfig
extends XMLConfig {
    public static final String TAG_SRFEXDATAGRIDCELL = "SRFEXDATAGRIDCELL";
    public static final String TAG_PANELMODEL = "PANELMODEL";
    public static final String TAG_HEIGHT = "HEIGHT";
    public static final String TAG_LONGPRESSEDIT = "LONGPRESSEDIT";
    public static final String TAG_SELMODE = "SELMODE";
    public static final String TAG_SELSTYLE = "SELSTYLE";
    public static final String TAG_SELMODE_DISABLE = "DISABLE";
    public static final String TAG_SELMODE_SINGLE = "SINGLE";
    public static final String TAG_SELMODE_MULTI = "MULTI";
    public static final String TAG_SELSTYLE_NONE = "NONE";
    public static final String TAG_SELSTYLE_BK = "BK";
    public static final String TAG_SELSTYLE_CHECK = "CHECK";
    protected DataGridConfig dataGridConfig = null;
    protected String strPanelModel = "";
    protected int nHeight = 0;
    protected boolean bLongPressEdit = false;
    protected String strSelMode = "";
    protected String strSelStype = "";

    public void setDataGridConfig(DataGridConfig dataGridConfig) {
        this.dataGridConfig = dataGridConfig;
    }

    public DataGridConfig getDataGridConfig() {
        return this.dataGridConfig;
    }

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_PANELMODEL, (boolean)true) == 0) {
            this.strPanelModel = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_HEIGHT, (boolean)true) == 0) {
            this.nHeight = XMLConfig.GetValue((String)strValue, (int)0);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_SELMODE, (boolean)true) == 0) {
            this.setSelMode(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_SELSTYLE, (boolean)true) == 0) {
            this.setSelStype(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_LONGPRESSEDIT, (boolean)true) == 0) {
            this.setLongPressEdit(DataGridCellConfig.GetValue((String)strValue, (boolean)this.isLongPressEdit()));
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getPanelModel() {
        return this.strPanelModel;
    }

    public void setPanelModel(String strPanelModel) {
        this.strPanelModel = strPanelModel;
    }

    public int getHeight() {
        return this.nHeight;
    }

    public void setHeight(int nHeight) {
        this.nHeight = nHeight;
    }

    public boolean isLongPressEdit() {
        return this.bLongPressEdit;
    }

    public void setLongPressEdit(boolean bLongPressEdit) {
        this.bLongPressEdit = bLongPressEdit;
    }

    public String getSelMode() {
        return this.strSelMode;
    }

    public void setSelMode(String strSelMode) {
        this.strSelMode = strSelMode;
    }

    public String getSelStype() {
        return this.strSelStype;
    }

    public void setSelStype(String strSelStype) {
        this.strSelStype = strSelStype;
    }
}

