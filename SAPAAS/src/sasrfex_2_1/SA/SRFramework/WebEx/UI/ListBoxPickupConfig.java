/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.ListBoxConfig;

public class ListBoxPickupConfig
extends ListBoxConfig {
    public static final String TAG_LISTBOXPICKUP = "SRFEXLISTBOXPICKUP";
    public static final String TAG_APPENDPARAMS = "APPENDPARAMS";
    public static final String TAG_APPENDFORMPARAMS = "APPENDFORMPARAMS";
    public static final String TAG_UPDATEFORMPARAMS = "UPDATEFORMPARAMS";
    public static final String TAG_DIALOGURL = "DIALOGURL";
    public static final String TAG_OKJSCODE = "OKJSCODE";
    public static final String TAG_CANCELJSCODE = "CANCELJSCODE";
    public static final String TAG_DIALOGWIDTH = "DIALOGWIDTH";
    public static final String TAG_DIALOGHEIGHT = "DIALOGHEIGHT";
    public static final String TAG_DIALOGRESIZABLE = "DIALOGRESIZABLE";
    public static final String TAG_DIALOGSCROLL = "DIALOGSCROLL";
    public static final String TAG_DIALOGSTATUS = "DIALOGSTATUS";
    public static final String TAG_TIPMESSAGE = "TIPMESSAGE";
    public static final String TAG_REMOVEBUTTON = "REMOVEBUTTON";
    public static final String TAG_ADDBUTTON = "ADDBUTTON";
    public static final String TAG_VALUEASXML = "VALUEASXML";
    public static final String TAG_PICKERDIALOGID = "PICKERDIALOGID";
    public static final String TAG_DIALOGID = "DIALOGID";
    protected String strAppendParams = "";
    protected String strOKJSCode = "";
    protected String strCANCELJSCode = "";
    protected String strAppendFormParams = "";
    protected String strUpdateFormParams = "";
    protected String strDialogURL = "";
    protected int nDialogWidth = 800;
    protected int nDialogHeight = 600;
    protected String strDialogResizable = "no";
    protected String strDialogScroll = "yes";
    protected String strDialogStatus = "no";
    protected String strPickerDialogId = "";
    protected String strTipMessage = "\u70b9\u51fb\u589e\u52a0\u6570\u636e";
    protected boolean bRemoveButton = true;
    protected boolean bAddButton = true;
    protected boolean bValueAsXML = false;

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_APPENDPARAMS, (boolean)true) == 0) {
            this.strAppendParams = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_APPENDFORMPARAMS, (boolean)true) == 0) {
            this.strAppendFormParams = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_UPDATEFORMPARAMS, (boolean)true) == 0) {
            this.strUpdateFormParams = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_OKJSCODE, (boolean)true) == 0) {
            this.strOKJSCode = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CANCELJSCODE, (boolean)true) == 0) {
            this.strCANCELJSCode = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DIALOGURL, (boolean)true) == 0) {
            this.strDialogURL = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DIALOGRESIZABLE, (boolean)true) == 0) {
            this.strDialogResizable = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DIALOGSCROLL, (boolean)true) == 0) {
            this.strDialogScroll = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DIALOGSTATUS, (boolean)true) == 0) {
            this.strDialogStatus = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DIALOGWIDTH, (boolean)true) == 0) {
            this.nDialogWidth = ListBoxPickupConfig.GetValue((String)strValue, (int)this.nDialogWidth);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DIALOGHEIGHT, (boolean)true) == 0) {
            this.nDialogHeight = ListBoxPickupConfig.GetValue((String)strValue, (int)this.nDialogHeight);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_PICKERDIALOGID, (boolean)true) == 0 || StringHelper.Compare((String)strName, (String)TAG_DIALOGID, (boolean)true) == 0) {
            this.strPickerDialogId = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_TIPMESSAGE, (boolean)true) == 0) {
            this.strTipMessage = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_REMOVEBUTTON, (boolean)true) == 0) {
            this.bRemoveButton = ListBoxPickupConfig.GetValue((String)strValue, (boolean)this.bRemoveButton);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ADDBUTTON, (boolean)true) == 0) {
            this.bAddButton = ListBoxPickupConfig.GetValue((String)strValue, (boolean)this.bAddButton);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_VALUEASXML, (boolean)true) == 0) {
            this.bValueAsXML = ListBoxPickupConfig.GetValue((String)strValue, (boolean)this.bValueAsXML);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getAppendParams() {
        return this.strAppendParams;
    }

    public void setAppendParams(String strAppendParams) {
        this.strAppendParams = strAppendParams;
    }

    public String getAppendFormParams() {
        return this.strAppendFormParams;
    }

    public void setAppendFormParams(String strAppendFormParams) {
        this.strAppendFormParams = strAppendFormParams;
    }

    public String getUpdateFormParams() {
        return this.strUpdateFormParams;
    }

    public void setUpdateFormParams(String strUpdateFormParams) {
        this.strUpdateFormParams = strUpdateFormParams;
    }

    public String getOKJSCode() {
        return this.strOKJSCode;
    }

    public void setOKJSCode(String strOKJSCode) {
        this.strOKJSCode = strOKJSCode;
    }

    public String getCANCELJSCode() {
        return this.strCANCELJSCode;
    }

    public void setCANCELJSCode(String strCANCELJSCode) {
        this.strCANCELJSCode = strCANCELJSCode;
    }

    public String getDialogURL() {
        return this.strDialogURL;
    }

    public void setDialogURL(String strDialogURL) {
        this.strDialogURL = strDialogURL;
    }

    public String getDialogResizable() {
        return this.strDialogResizable;
    }

    public void setDialogResizable(String strDialogResizable) {
        this.strDialogResizable = strDialogResizable;
    }

    public String getDialogScroll() {
        return this.strDialogScroll;
    }

    public void setDialogScroll(String strDialogScroll) {
        this.strDialogScroll = strDialogScroll;
    }

    public String getDialogStatus() {
        return this.strDialogStatus;
    }

    public void setDialogStatus(String strDialogStatus) {
        this.strDialogStatus = strDialogStatus;
    }

    public int getDialogWidth() {
        return this.nDialogWidth;
    }

    public void setDialogWidth(int nDialogWidth) {
        this.nDialogWidth = nDialogWidth;
    }

    public int getDialogHeight() {
        return this.nDialogHeight;
    }

    public void setDialogHeight(int nDialogHeight) {
        this.nDialogHeight = nDialogHeight;
    }

    public void setPickerDialogId(String strPickerDialogId) {
        this.strPickerDialogId = strPickerDialogId;
    }

    public String getPickerDialogId() {
        return this.strPickerDialogId;
    }

    public void setTipMessage(String strTipMessage) {
        this.strTipMessage = strTipMessage;
    }

    public String getTipMessage() {
        return this.strTipMessage;
    }

    public boolean isRemoveButton() {
        return this.bRemoveButton;
    }

    public void setRemoveButton(boolean removeButton) {
        this.bRemoveButton = removeButton;
    }

    public boolean isAddButton() {
        return this.bAddButton;
    }

    public void setAddButton(boolean addButton) {
        this.bAddButton = addButton;
    }

    public boolean isValueAsXML() {
        return this.bValueAsXML;
    }
}

