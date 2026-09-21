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

public class UserControlItemConfig
extends XMLConfig {
    public static final String TAG_USERCONTROLITEM = "SRFEXUSERCONTROLITEM";
    public static final String TAG_TAGNAME = "TAGNAME";
    public static final String TAG_CONTROLOBJECT = "CONTROLOBJECT";
    public static final String TAG_RENDERMODE = "RENDERMODE";
    protected String strRenderMode = "";
    protected String strTagName = "";
    protected String strControlObject = "";

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_TAGNAME, (boolean)true) == 0) {
            this.strTagName = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CONTROLOBJECT, (boolean)true) == 0) {
            this.strControlObject = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_RENDERMODE, (boolean)true) == 0) {
            this.strRenderMode = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CONTROLOBJECT, (boolean)true) == 0) {
            this.strControlObject = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getTagName() {
        return this.strTagName;
    }

    public void setTagName(String strTagName) {
        this.strTagName = strTagName;
    }

    public String getControlObject() {
        return this.strControlObject;
    }

    public void setControlObject(String strControlObject) {
        this.strControlObject = strControlObject;
    }

    public String getRenderMode() {
        return this.strRenderMode;
    }

    public void setRenderMode(String strRenderMode) {
        this.strRenderMode = strRenderMode;
    }
}

