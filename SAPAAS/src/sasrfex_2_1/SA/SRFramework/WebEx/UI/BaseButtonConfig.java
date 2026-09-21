/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.BaseControlConfig;

public abstract class BaseButtonConfig
extends BaseControlConfig {
    public static final String TAG_TEXT = "TEXT";
    public static final String TAG_TIPS = "TIPS";
    public static final String TAG_REALCSSCLASS = "REALCSSCLASS";
    public static final String TAG_CONFIRM = "CONFIRM";
    public static final String TAG_ICONCLS = "ICONCLS";
    protected String strText = "";
    protected String strTips = "";
    protected String strRealCssClass = "";
    protected String strConfirm = "";
    protected String strIconCls = "";

    public BaseButtonConfig() {
        this.setCssClass("sx-btnpanel");
    }

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_TEXT, (boolean)true) == 0) {
            this.strText = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_TIPS, (boolean)true) == 0) {
            this.strTips = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_REALCSSCLASS, (boolean)true) == 0) {
            this.strRealCssClass = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CONFIRM, (boolean)true) == 0) {
            this.strConfirm = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ICONCLS, (boolean)true) == 0) {
            this.strIconCls = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public void setRealCssClass(String strRealCssClass) {
        this.strRealCssClass = strRealCssClass;
    }

    public String getRealCssClass() {
        return this.strRealCssClass;
    }

    public void setText(String strText) {
        this.strText = strText;
    }

    public String getText() {
        return this.strText;
    }

    public void setTips(String strTips) {
        this.strTips = strTips;
    }

    public String getTips() {
        return this.strTips;
    }

    public void setConfirm(String strConfirm) {
        this.strConfirm = strConfirm;
    }

    public String getConfirm() {
        return this.strConfirm;
    }

    public String getIconCls() {
        return this.strIconCls;
    }

    public void setIconCls(String strIconCls) {
        this.strIconCls = strIconCls;
    }
}

