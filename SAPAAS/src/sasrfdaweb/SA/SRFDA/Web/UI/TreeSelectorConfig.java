/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.UI.HiddenConfig
 */
package SA.SRFDA.Web.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.HiddenConfig;

public class TreeSelectorConfig
extends HiddenConfig {
    public static final String TAG_HIDDEN = "SRFDATREESELECTOR";
    public static final String TAG_DATAURL = "DATAURL";
    public static final String TAG_TREEVIEWID = "TREEVIEWID";
    protected String strDataUrl = "";
    protected String strTreeViewId = "";

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_DATAURL, (boolean)true) == 0) {
            this.strDataUrl = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_TREEVIEWID, (boolean)true) == 0) {
            this.setTreeViewId(strValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getDataUrl() {
        return this.strDataUrl;
    }

    public void setDataUrl(String strDataUrl) {
        this.strDataUrl = strDataUrl;
    }

    public String getTreeViewId() {
        return this.strTreeViewId;
    }

    public void setTreeViewId(String strTreeViewId) {
        this.strTreeViewId = strTreeViewId;
    }
}

