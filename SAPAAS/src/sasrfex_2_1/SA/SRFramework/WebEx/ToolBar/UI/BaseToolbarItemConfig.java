/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.ToolBar.UI;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExWebContext;

public abstract class BaseToolbarItemConfig
extends XMLConfig {
    public static final String TAG_OBJECT = "OBJECT";
    public static final String TAG_RESOURCEID = "RESOURCEID";
    protected String strObject = "";
    protected String strResourceId = "";

    public BaseToolbarItemConfig() {
        this.setID(Helper.GenAppGlobalId());
    }

    public String GetJSCode(SRFExWebContext webContext, Object obj, boolean bNoRight) {
        return this.OnGetJSCode(webContext, obj, bNoRight);
    }

    protected String OnGetJSCode(SRFExWebContext webContext, Object obj, boolean bNoRight) {
        return "";
    }

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_OBJECT, (boolean)true) == 0) {
            this.strObject = strValue;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_RESOURCEID, (boolean)true) == 0) {
            this.strResourceId = strValue;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getObject() {
        return this.strObject;
    }

    public void setObject(String strObject) {
        this.strObject = strObject;
    }

    public String getResourceId() {
        return this.strResourceId;
    }

    public void setResourceId(String strResourceId) {
        this.strResourceId = strResourceId;
    }
}

