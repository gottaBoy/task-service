/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.BaseButtonConfig;

public class AjaxButtonConfig
extends BaseButtonConfig {
    public static final String TAG_AJAXBUTTON = "SRFEXAJAXBUTTON";
    public static final String TAG_JSCODE = "JSCODE";
    public static final String TAG_REMOTEPATH = "REMOTEPATH";
    public static final String TAG_LOADINGINDICATOR = "LOADINGINDICATOR";
    public static final String TAG_PROCESSTYPE = "PROCESSTYPE";
    public static final String TAG_BACKENDCONFIG = "BACKENDCONFIG";
    public static final String TAG_BACKENDCTRL = "BACKENDCTRL";
    public static final String TAG_CTRLOBJECT = "CTRLOBJECT";
    public static final String TAG_CTRLID = "CTRLID";
    protected String strBackEndCtrl = "";
    protected String strBackEndConfig = "";
    protected String strJSCode = "";
    protected String strRemotePath = "";
    protected String strLoadingIndicator = "";
    protected String strCtrlObject = "";
    protected String strCtrlId = "";
    protected String strProcessType = "";

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_JSCODE, (boolean)true) == 0) {
            this.strJSCode = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_REMOTEPATH, (boolean)true) == 0) {
            this.strRemotePath = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_LOADINGINDICATOR, (boolean)true) == 0) {
            this.strLoadingIndicator = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_BACKENDCTRL, (boolean)true) == 0) {
            this.strBackEndCtrl = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_BACKENDCONFIG, (boolean)true) == 0) {
            this.strBackEndConfig = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CTRLOBJECT, (boolean)true) == 0) {
            this.strCtrlObject = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CTRLID, (boolean)true) == 0) {
            this.strCtrlId = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_PROCESSTYPE, (boolean)true) == 0) {
            this.strProcessType = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public void setJSCode(String strJSCode) {
        this.strJSCode = strJSCode;
    }

    public String getJSCode() {
        return this.strJSCode;
    }

    public void setRemotePath(String strRemotePath) {
        this.strRemotePath = strRemotePath;
    }

    public String getRemotePath() {
        return this.strRemotePath;
    }

    public void setLoadingIndicator(String strLoadingIndicator) {
        this.strLoadingIndicator = strLoadingIndicator;
    }

    public String getLoadingIndicator() {
        return this.strLoadingIndicator;
    }

    public String getBackEndCtrl() {
        return this.strBackEndCtrl;
    }

    public void setBackEndCtrl(String strBackEndCtrl) {
        this.strBackEndCtrl = strBackEndCtrl;
    }

    public String getBackEndConfig() {
        return this.strBackEndConfig;
    }

    public void setBackEndConfig(String strBackEndConfig) {
        this.strBackEndConfig = strBackEndConfig;
    }

    public String getCtrlObject() {
        return this.strCtrlObject;
    }

    public void setCtrlObject(String strCtrlObject) {
        this.strCtrlObject = strCtrlObject;
    }

    public String getCtrlId() {
        return this.strCtrlId;
    }

    public void setCtrlId(String strCtrlId) {
        this.strCtrlId = strCtrlId;
    }

    public String getProcessType() {
        return this.strProcessType;
    }

    public void setProcessType(String strProcessType) {
        this.strProcessType = strProcessType;
    }
}

