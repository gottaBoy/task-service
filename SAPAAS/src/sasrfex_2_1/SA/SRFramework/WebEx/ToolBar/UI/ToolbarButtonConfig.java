/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.ToolBar.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.ToolBar.ISRFExToolbarButtonHandler;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarTextItemConfig;

public class ToolbarButtonConfig
extends ToolbarTextItemConfig {
    public static String TAG_TOOLBARBUTTON = "SRFEXTOOLBARBUTTON";
    public static final String TAG_IMPORTANCE_HIGH = "HIGH";
    public static final String TAG_IMPORTANCE_NORMAL = "NORMAL";
    public static final String TAG_IMPORTANCE_LOW = "LOW";
    public static final String TAG_TIPS = "TIPS";
    public static final String TAG_TIPSRESID = "TIPSRESID";
    public static final String TAG_CSSCLASS = "CSSCLASS";
    public static final String TAG_ICONCSSCLASS = "ICONCSSCLASS";
    public static final String TAG_ICON = "ICON";
    public static final String TAG_HANDLER = "HANDLER";
    public static final String TAG_HANDLERTYPE = "HANDLERTYPE";
    public static final String TAG_ENABLECONDITION = "ENABLECONDITION";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_ENABLETOGGLE = "ENABLETOGGLE";
    public static final String TAG_TAG = "TAG";
    public static final String TAG_PRESSED = "PRESSED";
    public static final String TAG_IMAGE = "IMAGE";
    public static final String TAG_IMPORTANCE = "IMPORTANCE";
    protected String strTips = "";
    protected String strTipsResId = "";
    protected String strCssClass = "";
    protected String strIconCssClass = "";
    protected String strIcon = "";
    protected String strHandler = "";
    protected String strEnableCondition = "";
    protected boolean bEnable = true;
    protected boolean bEnableToggle = false;
    protected String strTag = "";
    protected boolean bPressed = false;
    protected String strImportance = "";

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_TIPS, (boolean)true) == 0) {
            this.strTips = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_TIPSRESID, (boolean)true) == 0) {
            this.setTipsResId(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CSSCLASS, (boolean)true) == 0) {
            this.strCssClass = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ICONCSSCLASS, (boolean)true) == 0) {
            this.strIconCssClass = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ICON, (boolean)true) == 0) {
            this.strIcon = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_HANDLER, (boolean)true) == 0) {
            this.strHandler = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ENABLECONDITION, (boolean)true) == 0) {
            this.strEnableCondition = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ENABLE, (boolean)true) == 0) {
            this.bEnable = ToolbarButtonConfig.GetValue((String)strValue, (boolean)this.bEnable);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ENABLETOGGLE, (boolean)true) == 0) {
            this.bEnableToggle = ToolbarButtonConfig.GetValue((String)strValue, (boolean)this.bEnableToggle);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_TAG, (boolean)true) == 0) {
            this.strTag = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_PRESSED, (boolean)true) == 0) {
            this.bPressed = ToolbarButtonConfig.GetValue((String)strValue, (boolean)this.bPressed);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_IMPORTANCE, (boolean)true) == 0) {
            this.setImportance(strValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    @Override
    protected String OnGetJSCode(SRFExWebContext webContext, Object obj, boolean bNoRight) {
        StringBuilderEx script = new StringBuilderEx();
        script.Append("{");
        script.Append("id:'%1$s'", this.getID());
        if (!StringHelper.IsNullOrEmpty((String)this.getText())) {
            String strRealText = this.getText();
            if (!StringHelper.IsNullOrEmpty((String)this.strTextResId)) {
                strRealText = webContext.getGlobalHelper().getLocalizationHelper().GetLocalization(webContext.getLocalization(), this.strTextResId, this.getText());
            }
            script.Append(",text:'%1$s'", strRealText);
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getIcon())) {
            script.Append(",icon:'%1$s'", this.getIcon());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getIconCssClass())) {
            script.Append(",iconCls:'%1$s'", this.getIconCssClass());
        }
        if (!bNoRight) {
            String strCode;
            if (!this.isEnable()) {
                script.Append(",disabled:true");
            }
            if (!StringHelper.IsNullOrEmpty((String)this.getHandler()) && !StringHelper.IsNullOrEmpty((String)(strCode = this.GetHandlerCode(this.getHandler(), webContext, obj)))) {
                script.Append(",handler:%1$s", strCode);
            }
            if (!StringHelper.IsNullOrEmpty((String)this.getTips())) {
                String strRealTips = this.getTips();
                if (!StringHelper.IsNullOrEmpty((String)this.strTipsResId)) {
                    strRealTips = webContext.getGlobalHelper().getLocalizationHelper().GetLocalization(webContext.getLocalization(), this.strTipsResId, this.getTips());
                }
                script.Append(",tooltip:'%1$s'", strRealTips);
                script.Append(",tooltipType:'title'");
            }
        } else {
            script.Append(",disabled:true");
            if (!StringHelper.IsNullOrEmpty((String)this.getTips())) {
                script.Append(",tooltip:'%1$s\uff0c%2$s'", this.getTips(), "\u60a8\u7684\u6743\u9650\u4e0d\u8db3\u4e8e\u8fdb\u884c\u6b64\u9879\u64cd\u4f5c\uff01");
            } else {
                script.Append(",tooltip:'%1$s'", "\u60a8\u7684\u6743\u9650\u4e0d\u8db3\u4e8e\u8fdb\u884c\u6b64\u9879\u64cd\u4f5c");
            }
            script.Append(",tooltipType:'title'");
        }
        if (this.bEnableToggle) {
            script.Append(",enableToggle:true");
            if (this.bPressed) {
                script.Append(",pressed:true");
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)this.strTag)) {
            script.Append(",tag:'%1$s'", this.strTag);
        }
        this.OnGetJSCodeExt(script, webContext, obj);
        script.Append("}");
        return script.toString();
    }

    protected void OnGetJSCodeExt(StringBuilderEx script, SRFExWebContext webContext, Object obj) {
    }

    protected String GetHandlerCode(String strHandler, SRFExWebContext webContext, Object obj) {
        ISRFExToolbarButtonHandler handler;
        String strJSCode;
        Object objHander = ObjectHelper.Create(this.getHandler());
        if (objHander != null && objHander instanceof ISRFExToolbarButtonHandler && !StringHelper.IsNullOrEmpty((String)(strJSCode = (handler = (ISRFExToolbarButtonHandler)objHander).getJSCode(this, webContext, obj)))) {
            return strJSCode;
        }
        return "";
    }

    public String getCssClass() {
        return this.strCssClass;
    }

    public void setCssClass(String strCssClass) {
        this.strCssClass = strCssClass;
    }

    public String getIconCssClass() {
        return this.strIconCssClass;
    }

    public void setIconCssClass(String strIconCssClass) {
        this.strIconCssClass = strIconCssClass;
    }

    public String getIcon() {
        return this.strIcon;
    }

    public void setIcon(String strIcon) {
        this.strIcon = strIcon;
    }

    public String getTips() {
        return this.strTips;
    }

    public void setTips(String strTips) {
        this.strTips = strTips;
    }

    public String getHandler() {
        return this.strHandler;
    }

    public void setHandler(String strHandler) {
        this.strHandler = strHandler;
    }

    public String getEnableCondition() {
        return this.strEnableCondition;
    }

    public void setEnableCondition(String strEnableCondition) {
        this.strEnableCondition = strEnableCondition;
    }

    public boolean isEnable() {
        return this.bEnable;
    }

    public void setEnable(boolean enable) {
        this.bEnable = enable;
    }

    public boolean isEnableToggle() {
        return this.bEnableToggle;
    }

    public void setEnableToggle(boolean enableToggle) {
        this.bEnableToggle = enableToggle;
    }

    public String getTag() {
        return this.strTag;
    }

    public void setTag(String strTag) {
        this.strTag = strTag;
    }

    public boolean isPressed() {
        return this.bPressed;
    }

    public void setPressed(boolean pressed) {
        this.bPressed = pressed;
    }

    public String getTipsResId() {
        return this.strTipsResId;
    }

    public void setTipsResId(String strTipsResId) {
        this.strTipsResId = strTipsResId;
    }

    public String getImportance() {
        return this.strImportance;
    }

    public void setImportance(String strImportance) {
        this.strImportance = strImportance;
    }
}

