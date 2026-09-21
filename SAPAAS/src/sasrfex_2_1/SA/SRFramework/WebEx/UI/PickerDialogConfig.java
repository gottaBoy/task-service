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

public class PickerDialogConfig
extends XMLConfig {
    public static final String TAG_PICKERDIALOG = "SRFEXPICKERDIALOG";
    public static final String TAG_DIALOGWIDTH = "DIALOGWIDTH";
    public static final String TAG_DIALOGHEIGHT = "DIALOGHEIGHT";
    public static final String TAG_DIALOGRESIZABLE = "DIALOGRESIZABLE";
    public static final String TAG_DIALOGSCROLL = "DIALOGSCROLL";
    public static final String TAG_DIALOGSTATUS = "DIALOGSTATUS";
    public static final String TAG_DIALOGURL = "DIALOGURL";
    public static final String TAG_APPENDPARAMS = "APPENDPARAMS";
    public static final String TAG_APPENDFORMPARAMS = "APPENDFORMPARAMS";
    public static final String TAG_UPDATEFORMPARAMS = "UPDATEFORMPARAMS";
    protected String strDialogURL = "";
    protected int nDialogWidth = 800;
    protected int nDialogHeight = 600;
    protected String strDialogResizable = "no";
    protected String strDialogScroll = "yes";
    protected String strDialogStatus = "no";
    protected String strAppendParams = "";
    protected String strAppendFormParams = "";
    protected String strUpdateFormParams = "";

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_APPENDPARAMS, (boolean)true) == 0) {
            this.strAppendParams = strValue;
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
            this.nDialogWidth = PickerDialogConfig.GetValue((String)strValue, (int)this.nDialogWidth);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DIALOGHEIGHT, (boolean)true) == 0) {
            this.nDialogHeight = PickerDialogConfig.GetValue((String)strValue, (int)this.nDialogHeight);
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
        super.OnSetProperty(strName, strValue);
    }

    public String getAppendParams() {
        return this.strAppendParams;
    }

    public void setAppendParams(String strAppendParams) {
        this.strAppendParams = strAppendParams;
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
}

