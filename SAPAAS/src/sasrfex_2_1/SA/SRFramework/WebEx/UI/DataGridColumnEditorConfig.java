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
import org.w3c.dom.Node;

public class DataGridColumnEditorConfig
extends XMLConfig {
    public static final String TAG_SRFEXDATAGRIDCOLUMNEDITOR = "SRFEXDATAGRIDCOLUMNEDITOR";
    public static final String TAG_SRFEXJSCODE = "SRFEXJSCODE";
    public static final String TAG_SRFEXHTMLCODE = "SRFEXHTMLCODE";
    public static final String TAG_OBJECT = "OBJECT";
    protected DataGridConfig dataGridConfig = null;
    protected XMLConfig jsCodeConfig = null;
    protected XMLConfig htmlCodeConfig = null;
    protected String strObject = "";

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)TAG_SRFEXJSCODE, (boolean)true) == 0) {
            if (this.jsCodeConfig == null) {
                this.jsCodeConfig = new XMLConfig();
            }
            this.jsCodeConfig.LoadConfig(xmlNode);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_SRFEXHTMLCODE, (boolean)true) == 0) {
            if (this.htmlCodeConfig == null) {
                this.htmlCodeConfig = new XMLConfig();
            }
            this.htmlCodeConfig.LoadConfig(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

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

    public String getJSCode() {
        if (this.jsCodeConfig != null) {
            return this.jsCodeConfig.getNodeValue();
        }
        return "";
    }

    public void setJSCode(String strJSCode) {
        if (this.jsCodeConfig == null) {
            this.jsCodeConfig = new XMLConfig();
        }
        this.jsCodeConfig.setNodeValue(strJSCode);
    }

    public String getHTMLCode() {
        if (this.htmlCodeConfig != null) {
            return this.htmlCodeConfig.getNodeValue();
        }
        return "";
    }

    public void setHTMLCode(String strHTMLCode) {
        if (this.htmlCodeConfig == null) {
            this.htmlCodeConfig = new XMLConfig();
        }
        this.htmlCodeConfig.setNodeValue(strHTMLCode);
    }

    public void setObject(String strObject) {
        this.strObject = strObject;
    }

    public String getObject() {
        return this.strObject;
    }
}

