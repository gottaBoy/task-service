/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.DGEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.DGEx.UI.DGExBaseCellConfig;
import SA.SRFramework.WebEx.UI.ItemParamsConfig;
import org.w3c.dom.Node;

public class DGExCellConfig
extends DGExBaseCellConfig {
    public static final String TAG_SRFEXDGEXCELL = "SRFEXDGEXCELL";
    public static final String TAG_ITEMFORMAT = "ITEMFORMAT";
    public static final String TAG_CODELIST = "CODELIST";
    public static final String TAG_TEXTCSSCLASS = "TEXTCSSCLASS";
    public static final String TAG_CUSTOM = "CUSTOM";
    protected String strItemFormat = "";
    protected String strCodeList = "";
    protected ItemParamsConfig itemParamsConfig = null;
    protected String strTextCssClass = "";
    protected String strCustom = "";

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXITEMPARAMS", (boolean)true) == 0 && this.itemParamsConfig == null) {
            this.itemParamsConfig = new ItemParamsConfig();
            this.itemParamsConfig.LoadConfig(xmlNode);
        }
        super.OnLoadNode(strName, xmlNode);
    }

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_ITEMFORMAT, (boolean)true) == 0) {
            this.strItemFormat = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CODELIST, (boolean)true) == 0) {
            this.strCodeList = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_TEXTCSSCLASS, (boolean)true) == 0) {
            this.strTextCssClass = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CUSTOM, (boolean)true) == 0) {
            this.strCustom = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getItemFormat() {
        return this.strItemFormat;
    }

    public void setItemFormat(String strItemFormat) {
        this.strItemFormat = strItemFormat;
    }

    public ItemParamsConfig getItemParamsConfig() {
        return this.itemParamsConfig;
    }

    public String getCodeList() {
        return this.strCodeList;
    }

    public void setCodeList(String strCodeList) {
        this.strCodeList = strCodeList;
    }

    public String getTextCssClass() {
        return this.strTextCssClass;
    }

    public void setTextCssClass(String strTextCssClass) {
        this.strTextCssClass = strTextCssClass;
    }

    public String getCustom() {
        return this.strCustom;
    }

    public void setCustom(String strCustom) {
        this.strCustom = strCustom;
    }
}

