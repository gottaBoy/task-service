/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.WebEx.UI.PickerConfig;
import java.util.HashMap;

public class PickerExConfig
extends PickerConfig {
    public static final String TAG_PICKEREX = "SRFEXPICKEREX";
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
    public static final String TAG_APPENDURLPARAMS = "APPENDURLPARAMS";
    public static final String TAG_PICKERDIALOGID = "PICKERDIALOGID";
    public static final String TAG_DIALOGID = "DIALOGID";
    public static final String TAG_SHOWBUTTON = "SHOWBUTTON";
    public static final String TAG_COMPATIBLE = "COMPATIBLE";
    public static final String TAG_TOOLTIPURL = "TOOLTIPURL";
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
    protected boolean bShowButton = true;
    protected boolean bCompatible = false;
    protected String strAppendURLParams = "";
    protected String strTooltipURL = "";

    @Override
    protected void OnSetPropertyEx(HashMap<String, String> attrMap) {
        if (attrMap.size() == 0) {
            return;
        }
        String strValue = "";
        strValue = attrMap.remove(TAG_APPENDPARAMS);
        if (strValue != null) {
            this.strAppendParams = strValue;
        }
        if ((strValue = attrMap.remove(TAG_APPENDFORMPARAMS)) != null) {
            this.strAppendFormParams = strValue;
        }
        if ((strValue = attrMap.remove(TAG_UPDATEFORMPARAMS)) != null) {
            this.strUpdateFormParams = strValue;
        }
        if ((strValue = attrMap.remove(TAG_OKJSCODE)) != null) {
            this.strOKJSCode = strValue;
        }
        if ((strValue = attrMap.remove(TAG_CANCELJSCODE)) != null) {
            this.strCANCELJSCode = strValue;
        }
        if ((strValue = attrMap.remove(TAG_DIALOGURL)) != null) {
            this.strDialogURL = strValue;
        }
        if ((strValue = attrMap.remove(TAG_DIALOGRESIZABLE)) != null) {
            this.strDialogResizable = strValue;
        }
        if ((strValue = attrMap.remove(TAG_DIALOGSCROLL)) != null) {
            this.strDialogScroll = strValue;
        }
        if ((strValue = attrMap.remove(TAG_DIALOGSTATUS)) != null) {
            this.strDialogStatus = strValue;
        }
        if ((strValue = attrMap.remove(TAG_DIALOGWIDTH)) != null) {
            this.nDialogWidth = PickerExConfig.GetValue((String)strValue, (int)this.nDialogWidth);
        }
        if ((strValue = attrMap.remove(TAG_DIALOGHEIGHT)) != null) {
            this.nDialogHeight = PickerExConfig.GetValue((String)strValue, (int)this.nDialogHeight);
        }
        if ((strValue = attrMap.remove(TAG_PICKERDIALOGID)) != null) {
            this.strPickerDialogId = strValue;
        }
        if ((strValue = attrMap.remove(TAG_DIALOGID)) != null) {
            this.strPickerDialogId = strValue;
        }
        if ((strValue = attrMap.remove(TAG_SHOWBUTTON)) != null) {
            this.bShowButton = PickerExConfig.GetValue((String)strValue, (boolean)this.bShowButton);
        }
        if ((strValue = attrMap.remove(TAG_COMPATIBLE)) != null) {
            this.bCompatible = PickerExConfig.GetValue((String)strValue, (boolean)this.bCompatible);
        }
        if ((strValue = attrMap.remove(TAG_APPENDURLPARAMS)) != null) {
            this.strAppendURLParams = strValue;
        }
        if ((strValue = attrMap.remove(TAG_TOOLTIPURL)) != null) {
            this.setTooltipURL(strValue);
        }
        super.OnSetPropertyEx(attrMap);
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

    public boolean isShowButton() {
        return this.bShowButton;
    }

    public void setShowButton(boolean showButton) {
        this.bShowButton = showButton;
    }

    public boolean isCompatible() {
        return this.bCompatible;
    }

    public void setCompatible(boolean compatible) {
        this.bCompatible = compatible;
    }

    public String getAppendURLParams() {
        return this.strAppendURLParams;
    }

    public void setAppendURLParams(String strAppendURLParams) {
        this.strAppendURLParams = strAppendURLParams;
    }

    public String getTooltipURL() {
        return this.strTooltipURL;
    }

    public void setTooltipURL(String strTooltipURL) {
        this.strTooltipURL = strTooltipURL;
    }
}

