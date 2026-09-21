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

public abstract class BaseMenuExConfig
extends XMLConfig {
    public static final String OPENMODE_BLANK = "BLANK";
    public static final String OPENMODE_TOPCONTAINER = "TOPCONTAINER";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_CAPRESID = "CAPRESID";
    public static final String TAG_CUSTOM = "CUSTOM";
    public static final String TAG_PRIVILEGE = "PRIVILEGE";
    public static final String TAG_PAGEPATH = "PAGEPATH";
    public static final String TAG_TIPS = "TIPS";
    public static final String TAG_TIPSRESID = "TIPSRESID";
    public static final String TAG_OPENMODE = "OPENMODE";
    public static final String TAG_RESOURCEID = "RESOURCEID";
    public static final String TAG_JSCODE = "JSCODE";
    public static final String TAG_INCLUDEPARAMS = "INCLUDEPARAMS";
    public static final String TAG_EXCLUDEPARAMS = "EXCLUDEPARAMS";
    public static final String TAG_APPENDPARAMS = "APPENDPARAMS";
    public static final String TAG_USERMENUCAPTIONID = "USERMENUCAPTIONID";
    public static final String TAG_AUTOREFRESH = "AUTOREFRESH";
    public static final String TAG_IMAGEPATH = "IMAGEPATH";
    public static final String TAG_ICONCLS = "ICONCLS";
    public static final String TAG_APPENDPARENTCAP = "APPENDPARENTCAP";
    public static final String TAG_COUNTERID = "COUNTERID";
    public static final String TAG_COUNTERPARAM = "COUNTERPARAM";
    protected String strCaption = "";
    protected boolean bAppendParentCaption = false;
    protected String strCapResId = "";
    protected String strCustom = "";
    protected String strPrivilege = "";
    protected String strPagePath = "";
    protected String strIncludeParams = "";
    protected String strExcludeParams = "";
    protected String strAppendParams = "";
    protected String strJSCode = "";
    protected String strTips = "";
    protected String strTipsResId = "";
    protected String strResourceId = null;
    protected String strUserMenuCaptionId = "";
    protected int nAutoRefresh = 60;
    protected String strImagePath = "";
    protected String strIconCls = "";
    protected String strOpenMode = "";
    protected String strCounterId = "";
    protected String strCounterParam = "";

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_CAPTION, (boolean)true) == 0) {
            this.strCaption = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CAPRESID, (boolean)true) == 0) {
            this.strCapResId = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_USERMENUCAPTIONID, (boolean)true) == 0) {
            this.strUserMenuCaptionId = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CUSTOM, (boolean)true) == 0) {
            this.strCustom = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_PRIVILEGE, (boolean)true) == 0) {
            this.strPrivilege = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_PAGEPATH, (boolean)true) == 0) {
            this.strPagePath = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_INCLUDEPARAMS, (boolean)true) == 0) {
            this.strIncludeParams = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_EXCLUDEPARAMS, (boolean)true) == 0) {
            this.strExcludeParams = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_APPENDPARAMS, (boolean)true) == 0) {
            this.strAppendParams = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_JSCODE, (boolean)true) == 0) {
            this.strJSCode = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_TIPS, (boolean)true) == 0) {
            this.strTips = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_TIPSRESID, (boolean)true) == 0) {
            this.strTipsResId = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_RESOURCEID, (boolean)true) == 0) {
            this.strResourceId = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_AUTOREFRESH, (boolean)true) == 0) {
            this.nAutoRefresh = BaseMenuExConfig.GetValue((String)strValue, (int)this.nAutoRefresh);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_IMAGEPATH, (boolean)true) == 0) {
            this.strImagePath = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ICONCLS, (boolean)true) == 0) {
            this.setIconCls(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_OPENMODE, (boolean)true) == 0) {
            this.setOpenMode(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_APPENDPARENTCAP, (boolean)true) == 0) {
            this.setAppendParentCaption(BaseMenuExConfig.GetValue((String)strValue, (boolean)this.isAppendParentCaption()));
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_COUNTERID, (boolean)true) == 0) {
            this.setCounterId(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_COUNTERPARAM, (boolean)true) == 0) {
            this.setCounterParam(strValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public void setCaption(String strCaption) {
        this.strCaption = strCaption;
    }

    public String getCaption() {
        return this.strCaption;
    }

    public String getCustom() {
        return this.strCustom;
    }

    public void setCustom(String strCustom) {
        this.strCustom = strCustom;
    }

    public String getPrivilege() {
        return this.strPrivilege;
    }

    public void setPrivilege(String strPrivilege) {
        this.strPrivilege = strPrivilege;
    }

    public void setPagePath(String strPagePath) {
        this.strPagePath = strPagePath;
    }

    public String getPagePath() {
        return this.strPagePath;
    }

    public void setIncludeParams(String strIncludeParams) {
        this.strIncludeParams = strIncludeParams;
    }

    public String getIncludeParams() {
        return this.strIncludeParams;
    }

    public void setExcludeParams(String strExcludeParams) {
        this.strExcludeParams = strExcludeParams;
    }

    public String getExcludeParams() {
        return this.strExcludeParams;
    }

    public void setAppendParams(String strAppendParams) {
        this.strAppendParams = strAppendParams;
    }

    public String getAppendParams() {
        return this.strAppendParams;
    }

    public void setJSCode(String strJSCode) {
        this.strJSCode = strJSCode;
    }

    public String getJSCode() {
        return this.strJSCode;
    }

    public void setTips(String strTips) {
        this.strTips = strTips;
    }

    public String getTips() {
        return this.strTips;
    }

    public void setResourceId(String strResourceId) {
        this.strResourceId = strResourceId;
    }

    public String getResourceId() {
        if (this.strResourceId == null) {
            if (StringHelper.Length((String)this.strJSCode) > 0) {
                return "";
            }
            String strCurPagePath = this.getPagePath();
            if (StringHelper.Length((String)strCurPagePath) == 0) {
                return "";
            }
            if ((strCurPagePath = strCurPagePath.toUpperCase()).indexOf(".JSP") == -1) {
                return "";
            }
            int nPos = strCurPagePath.indexOf(63);
            if (nPos != -1) {
                strCurPagePath = strCurPagePath.substring(0, nPos);
            }
            if ((strCurPagePath = strCurPagePath.replace(".JSP", "")).indexOf(47) == 0) {
                strCurPagePath = strCurPagePath.substring(1);
            }
            strCurPagePath = strCurPagePath.replace("/", ".");
            return "PAGE_" + strCurPagePath;
        }
        return this.strResourceId;
    }

    public String getUserMenuCaptionId() {
        return this.strUserMenuCaptionId;
    }

    public void setUserMenuCaptionId(String strUserMenuCaptionId) {
        this.strUserMenuCaptionId = strUserMenuCaptionId;
    }

    public void setAutoRefresh(int nAutoRefresh) {
        this.nAutoRefresh = nAutoRefresh;
    }

    public int getAutoRefresh() {
        return this.nAutoRefresh;
    }

    public String getImagePath() {
        return this.strImagePath;
    }

    public void setImagePath(String strImagePath) {
        this.strImagePath = strImagePath;
    }

    public String getIconCls() {
        return this.strIconCls;
    }

    public void setIconCls(String strIconCls) {
        this.strIconCls = strIconCls;
    }

    public String getCapResId() {
        return this.strCapResId;
    }

    public String getTipsResId() {
        return this.strTipsResId;
    }

    public void setCapResId(String strCapResId) {
        this.strCapResId = strCapResId;
    }

    public void setTipsResId(String strTipsResId) {
        this.strTipsResId = strTipsResId;
    }

    public String getOpenMode() {
        return this.strOpenMode;
    }

    public void setOpenMode(String strOpenMode) {
        this.strOpenMode = strOpenMode;
    }

    public boolean isAppendParentCaption() {
        return this.bAppendParentCaption;
    }

    public void setAppendParentCaption(boolean bAppendParentCaption) {
        this.bAppendParentCaption = bAppendParentCaption;
    }

    public String getCounterId() {
        return this.strCounterId;
    }

    public void setCounterId(String strCounterId) {
        this.strCounterId = strCounterId;
    }

    public String getCounterParam() {
        return this.strCounterParam;
    }

    public void setCounterParam(String strCounterParam) {
        this.strCounterParam = strCounterParam;
    }
}

