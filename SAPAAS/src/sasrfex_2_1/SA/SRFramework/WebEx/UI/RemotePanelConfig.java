/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.BasePanelConfig;

public class RemotePanelConfig
extends BasePanelConfig {
    public static final String TAG_REMOTEPANEL = "SRFEXREMOTEPANEL";
    public static final String TAG_REMOTEURL = "REMOTEURL";
    public static final String TAG_AUTOREFRESH = "AUTOREFRESH";
    public static final String TAG_ERRORMSG = "ERRORMSG";
    public static final String TAG_APPENDPARAMS = "APPENDPARAMS";
    public static final String TAG_APPENDPARAMSEX = "APPENDPARAMSEX";
    public static final String TAG_SHOWLOADINDICATOR = "SHOWLOADINDICATOR";
    public static final String TAG_CONTAINER = "CONTAINER";
    public static final String TAG_SCRIPTS = "SCRIPTS";
    protected String strRemoteURL = "";
    protected String strErrorMsg = "<SPAN class='sx-errortext'>\u52a0\u8f7d\u754c\u9762\u53d1\u751f\u9519\u8bef\uff0c\u8bf7\u5237\u65b0\u91cd\u8bd5!</SPAN>";
    protected int nAutoRefresh = 0;
    protected String strAppendParams = "";
    protected String strAppendParamsEx = "";
    protected boolean bShowLoadIndicator = true;
    protected String strContainer = "";
    protected boolean bScripts = true;

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_REMOTEURL, (boolean)true) == 0) {
            this.strRemoteURL = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ERRORMSG, (boolean)true) == 0) {
            this.strErrorMsg = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_AUTOREFRESH, (boolean)true) == 0) {
            this.nAutoRefresh = RemotePanelConfig.GetValue((String)strValue, (int)this.nAutoRefresh);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_APPENDPARAMS, (boolean)true) == 0) {
            this.strAppendParams = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_APPENDPARAMSEX, (boolean)true) == 0) {
            this.strAppendParamsEx = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CONTAINER, (boolean)true) == 0) {
            this.strContainer = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_SHOWLOADINDICATOR, (boolean)true) == 0) {
            this.bShowLoadIndicator = RemotePanelConfig.GetValue((String)strValue, (boolean)this.bShowLoadIndicator);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_SCRIPTS, (boolean)true) == 0) {
            this.setScripts(RemotePanelConfig.GetValue((String)strValue, (boolean)this.getScripts()));
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public void setRemoteURL(String strRemoteURL) {
        this.strRemoteURL = strRemoteURL;
    }

    public String getRemoteURL() {
        return this.strRemoteURL;
    }

    public void setErrorMsg(String strErrorMsg) {
        this.strErrorMsg = strErrorMsg;
    }

    public String getErrorMsg() {
        return this.strErrorMsg;
    }

    public void setAutoRefresh(int nAutoRefresh) {
        this.nAutoRefresh = nAutoRefresh;
    }

    public int getAutoRefresh() {
        return this.nAutoRefresh;
    }

    public void setAppendParams(String strAppendParams) {
        this.strAppendParams = strAppendParams;
    }

    public String getAppendParams() {
        return this.strAppendParams;
    }

    public void setAppendParamsEx(String strAppendParams) {
        this.strAppendParamsEx = strAppendParams;
    }

    public String getAppendParamsEx() {
        return this.strAppendParamsEx;
    }

    public void setShowLoadIndicator(boolean bShowLoadIndicator) {
        this.bShowLoadIndicator = bShowLoadIndicator;
    }

    public boolean getShowLoadIndicator() {
        return this.bShowLoadIndicator;
    }

    @Override
    public String getResourceId() {
        if (this.strResourceId == null) {
            String strCurPagePath = this.getRemoteURL();
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
            strCurPagePath = strCurPagePath.replace(".JSP", "");
            if ((strCurPagePath = strCurPagePath.replace("..", "")).indexOf(47) == 0) {
                strCurPagePath = strCurPagePath.substring(1);
            }
            strCurPagePath = strCurPagePath.replace("/", ".");
            return "PAGE_" + strCurPagePath;
        }
        return this.strResourceId;
    }

    public String getContainer() {
        return this.strContainer;
    }

    public void setContainer(String strContainer) {
        this.strContainer = strContainer;
    }

    public boolean getScripts() {
        return this.bScripts;
    }

    public void setScripts(boolean bScripts) {
        this.bScripts = bScripts;
    }
}

