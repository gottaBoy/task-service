/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.ControlConfigContext;
import SA.SRFramework.WebEx.UI.HiddenConfig;
import SA.SRFramework.WebEx.UI.TextBoxConfig;
import org.w3c.dom.Node;

public class MultiPickerConfig
extends HiddenConfig {
    public static final String TAG_MULTIPICKER = "SRFEXMULTIPICKER";
    public static final String TAG_IMAGE = "IMAGE";
    public static final String TAG_DISABLEIMAGE = "DISABLEIMAGE";
    public static final String TAG_RESETIMAGE = "RESETIMAGE";
    public static final String TAG_DISABLERESETIMAGE = "DISABLERESETIMAGE";
    public static final String TAG_PICKUPCALL = "PICKUPCALL";
    public static final String TAG_PICKONLY = "PICKONLY";
    public static final String TAG_TIPMESSAGE = "TIPMESSAGE";
    public static final String TAG_RESETTIPMESSAGE = "RESETTIPMESSAGE";
    public static final String TAG_RESETENABLE = "RESETENABLE";
    public static final String TAG_CODELIST = "CODELIST";
    public static final String TAG_DATALINKIMAGE = "DATALINKIMAGE";
    public static final String TAG_DISABLEDATALINKIMAGE = "DISABLEDATALINKIMAGE";
    public static final String TAG_DATALINKJSCODE = "DATALINKJSCODE";
    public static final String TAG_DATALINKTIP = "DATALINKTIPMESSAGE";
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
    protected String strImage = "../sasrfex/images/default/icon_datapicker_1.gif";
    protected String strDisableImage = "../sasrfex/images/default/icon_datapicker_3.gif";
    protected String strResetImage = "../sasrfex/images/default/icon_reset.gif";
    protected String strPickupCall = "pickup";
    protected String strTipMessage = "\u70b9\u51fb\u9009\u62e9\u6570\u636e";
    protected String strResetTipMessage = "\u70b9\u51fb\u6e05\u7a7a\u9009\u62e9\u6570\u636e";
    protected String strCodeList = "";
    protected boolean bPickOnly = true;
    protected boolean bResetEnable = false;
    protected TextBoxConfig textBoxConfig = new TextBoxConfig();

    public TextBoxConfig getTextBoxConfig() {
        return this.textBoxConfig;
    }

    @Override
    public void OnLoadNode(String strName, Node xmlNode) {
        ControlConfigContext controlConfigContext = this.getConfigContext();
        ControlConfigContext tempContext = null;
        if (controlConfigContext != null) {
            tempContext = controlConfigContext.Clone();
            tempContext.setParentUIStyle(controlConfigContext.getCurUIStyle());
            tempContext.setCurUIStyle(null);
            tempContext.setParam("CHILDPOS", 0);
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXTEXTBOX", (boolean)true) == 0) {
            this.textBoxConfig.LoadConfig(xmlNode, tempContext);
            if (controlConfigContext != null) {
                tempContext.RemoveParam("CHILDPOS");
                controlConfigContext.FromParamList(tempContext.getParamList());
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_IMAGE, (boolean)true) == 0) {
            this.strImage = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DISABLEIMAGE, (boolean)true) == 0) {
            this.strDisableImage = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_RESETIMAGE, (boolean)true) == 0) {
            this.strResetImage = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_PICKUPCALL, (boolean)true) == 0) {
            this.strPickupCall = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_PICKONLY, (boolean)true) == 0) {
            this.bPickOnly = MultiPickerConfig.GetValue((String)strValue, (boolean)this.bPickOnly);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_TIPMESSAGE, (boolean)true) == 0) {
            this.strTipMessage = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_RESETTIPMESSAGE, (boolean)true) == 0) {
            this.strResetTipMessage = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CODELIST, (boolean)true) == 0) {
            this.strCodeList = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_RESETENABLE, (boolean)true) == 0) {
            this.bResetEnable = MultiPickerConfig.GetValue((String)strValue, (boolean)this.bResetEnable);
            return;
        }
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
            this.nDialogWidth = MultiPickerConfig.GetValue((String)strValue, (int)this.nDialogWidth);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DIALOGHEIGHT, (boolean)true) == 0) {
            this.nDialogHeight = MultiPickerConfig.GetValue((String)strValue, (int)this.nDialogHeight);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_PICKERDIALOGID, (boolean)true) == 0 || StringHelper.Compare((String)strName, (String)TAG_DIALOGID, (boolean)true) == 0) {
            this.strPickerDialogId = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_SHOWBUTTON, (boolean)true) == 0) {
            this.bShowButton = MultiPickerConfig.GetValue((String)strValue, (boolean)this.bShowButton);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_COMPATIBLE, (boolean)true) == 0) {
            this.bCompatible = MultiPickerConfig.GetValue((String)strValue, (boolean)this.bCompatible);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_APPENDURLPARAMS, (boolean)true) == 0) {
            this.strAppendURLParams = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public void setImage(String strImage) {
        this.strImage = strImage;
    }

    public String getImage() {
        return this.strImage;
    }

    public String getDisableImage() {
        return this.strDisableImage;
    }

    public void setDisableImage(String strDisableImage) {
        this.strDisableImage = strDisableImage;
    }

    public void setResetImage(String strResetImage) {
        this.strResetImage = strResetImage;
    }

    public String getResetImage() {
        return this.strResetImage;
    }

    public void setPickupCall(String strPickupCall) {
        this.strPickupCall = strPickupCall;
    }

    public String getPickupCall() {
        return this.strPickupCall;
    }

    public void setPickOnly(boolean bPickOnly) {
        this.bPickOnly = bPickOnly;
    }

    public boolean getPickOnly() {
        return this.bPickOnly;
    }

    public void setTipMessage(String strTipMessage) {
        this.strTipMessage = strTipMessage;
    }

    public String getTipMessage() {
        return this.strTipMessage;
    }

    public void setResetTipMessage(String strResetTipMessage) {
        this.strResetTipMessage = strResetTipMessage;
    }

    public String getResetTipMessage() {
        return this.strResetTipMessage;
    }

    public String getCodeList() {
        return this.strCodeList;
    }

    public void setCodeList(String strCodeList) {
        this.strCodeList = strCodeList;
    }

    public void setResetEnable(boolean bResetEnable) {
        this.bResetEnable = bResetEnable;
    }

    public boolean getResetEnable() {
        return this.bResetEnable;
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
}

