/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.ToolBar.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.ToolBar.UI.BaseToolbarItemConfig;

public class ToolbarTextItemConfig
extends BaseToolbarItemConfig {
    public static String TAG_TOOLBARTEXTITEM = "SRFEXTOOLBARTEXTITEM";
    public static String TAG_TEXT = "TEXT";
    public static String TAG_TEXTRESID = "TEXTRESID";
    protected String strText = "";
    protected String strTextResId = "";

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)TAG_TEXT, (String)strName, (boolean)true) == 0) {
            this.strText = strValue;
            return;
        }
        if (StringHelper.Compare((String)TAG_TEXTRESID, (String)strName, (boolean)true) == 0) {
            this.strTextResId = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getText() {
        return this.strText;
    }

    public void setText(String strText) {
        this.strText = strText;
    }

    public String getTextResId() {
        return this.strTextResId;
    }

    public void setTextResId(String strTextResId) {
        this.strTextResId = strTextResId;
    }

    @Override
    protected String OnGetJSCode(SRFExWebContext webContext, Object obj, boolean bNoRight) {
        String strRealText = this.strText;
        if (!StringHelper.IsNullOrEmpty((String)this.strTextResId)) {
            strRealText = webContext.getGlobalHelper().getLocalizationHelper().GetLocalization(webContext.getLocalization(), this.strTextResId, this.strText);
        }
        return StringHelper.Format((String)"'%1$s'", (Object)strRealText);
    }
}

