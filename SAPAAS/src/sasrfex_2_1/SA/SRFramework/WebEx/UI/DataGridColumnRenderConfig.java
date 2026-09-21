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

public class DataGridColumnRenderConfig
extends XMLConfig {
    public static final String TAG_SRFEXDATAGRIDCOLUMNRENDER = "SRFEXDATAGRIDCOLUMNRENDER";
    public static final String TAG_OBJECT = "OBJECT";
    public static final String TAG_PARAM = "PARAM";
    protected DataGridConfig dataGridConfig = null;
    protected XMLConfig jsCodeConfig = null;
    protected XMLConfig htmlCodeConfig = null;
    protected String strObject = "";
    protected String strParam = "";

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_OBJECT, (boolean)true) == 0) {
            this.setObject(strValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public DataGridConfig getDataGridConfig() {
        return this.dataGridConfig;
    }

    public void setDataGridConfig(DataGridConfig dataGridConfig) {
        this.dataGridConfig = dataGridConfig;
    }

    public void setObject(String strObject) {
        this.strObject = strObject;
    }

    public String getObject() {
        return this.strObject;
    }

    public String getParam() {
        return this.strParam;
    }

    public void setParam(String strParam) {
        this.strParam = strParam;
    }
}

