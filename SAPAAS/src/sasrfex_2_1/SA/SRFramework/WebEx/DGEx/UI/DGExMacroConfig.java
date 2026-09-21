/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.DGEx.UI;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.DGEx.UI.DGExMacroParamsConfig;
import org.w3c.dom.Node;

public class DGExMacroConfig
extends XMLConfig {
    public static final String TAG_SRFEXDGEXMACRO = "SRFEXDGEXMACRO";
    public static final String TAG_FUNC = "FUNC";
    public static final String FUNC_SUM = "SUM";
    public static final String FUNC_AVG = "AVG";
    public static final String FUNC_MAX = "MAX";
    public static final String FUNC_MIN = "MIN";
    public static final String TAG_DATAGROUPID = "DATAGROUPID";
    protected String strDataGroupId = "";
    protected String strFunc = "";
    protected DGExMacroParamsConfig macroParamsConfig = new DGExMacroParamsConfig();

    protected void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXDGEXMACROPARAMS", (boolean)true) == 0) {
            this.macroParamsConfig.LoadConfig(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_FUNC, (boolean)true) == 0) {
            this.setFunc(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DATAGROUPID, (boolean)true) == 0) {
            this.setDataGroupId(strValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getFunc() {
        return this.strFunc;
    }

    public void setFunc(String strFunc) {
        this.strFunc = strFunc;
    }

    public DGExMacroParamsConfig getMacroParamsConfig() {
        return this.macroParamsConfig;
    }

    public String getDataGroupId() {
        return this.strDataGroupId;
    }

    public void setDataGroupId(String strDataGroupId) {
        this.strDataGroupId = strDataGroupId;
    }
}

