/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.ControlConfigContext;
import SA.SRFramework.WebEx.UI.DataLinksConfig;
import SA.SRFramework.WebEx.UI.HiddenConfig;
import SA.SRFramework.WebEx.UI.TextBoxConfig;
import java.util.HashMap;
import org.w3c.dom.Node;

public class PickerConfig
extends HiddenConfig {
    public static final String TAG_PICKER = "SRFEXPICKER";
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
    protected String strImage = "../sasrfex/images/default/icon_datapicker_1.gif";
    protected String strDisableImage = "../sasrfex/images/default/icon_datapicker_3.gif";
    protected String strResetImage = "../sasrfex/images/default/icon_reset.gif";
    protected String strPickupCall = "pickup";
    protected String strTipMessage = "\u70b9\u51fb\u9009\u62e9\u6570\u636e";
    protected String strResetTipMessage = "\u70b9\u51fb\u6e05\u7a7a\u9009\u62e9\u6570\u636e";
    protected String strCodeList = "";
    protected boolean bPickOnly = true;
    protected boolean bResetEnable = false;
    protected String strDataLinkImage = "../sasrfex/images/default/icon_datalink_1.png";
    protected String strDisableDataLinkImage = "../sasrfex/images/default/icon_datalink_2.png";
    protected String strDataLinkJSCode = "";
    protected String strDataLinkTipMessage = "\u70b9\u51fb\u67e5\u770b\u8be6\u7ec6\u4fe1\u606f";
    protected TextBoxConfig textBoxConfig = new TextBoxConfig();
    protected DataLinksConfig dataLinksConfig = null;

    public PickerConfig() {
        this.textBoxConfig.setCssClass("sx-pickerinput");
    }

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
        if (StringHelper.Compare((String)strName, (String)"SRFEXDATALINK", (boolean)true) == 0) {
            if (this.dataLinksConfig == null) {
                this.dataLinksConfig = new DataLinksConfig();
            }
            this.dataLinksConfig.LoadConfig(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    @Override
    protected void OnSetPropertyEx(HashMap<String, String> attrMap) {
        if (attrMap.size() == 0) {
            return;
        }
        String strValue = "";
        strValue = attrMap.remove(TAG_IMAGE);
        if (strValue != null) {
            this.strImage = strValue;
        }
        if ((strValue = attrMap.remove(TAG_DISABLEIMAGE)) != null) {
            this.strDisableImage = strValue;
        }
        if ((strValue = attrMap.remove(TAG_RESETIMAGE)) != null) {
            this.strResetImage = strValue;
        }
        if ((strValue = attrMap.remove(TAG_PICKUPCALL)) != null) {
            this.strPickupCall = strValue;
        }
        if ((strValue = attrMap.remove(TAG_PICKONLY)) != null) {
            this.bPickOnly = PickerConfig.GetValue((String)strValue, (boolean)this.bPickOnly);
        }
        if ((strValue = attrMap.remove(TAG_TIPMESSAGE)) != null) {
            this.strTipMessage = strValue;
        }
        if ((strValue = attrMap.remove(TAG_RESETTIPMESSAGE)) != null) {
            this.strResetTipMessage = strValue;
        }
        if ((strValue = attrMap.remove(TAG_CODELIST)) != null) {
            this.strCodeList = strValue;
        }
        if ((strValue = attrMap.remove(TAG_RESETENABLE)) != null) {
            this.bResetEnable = PickerConfig.GetValue((String)strValue, (boolean)this.bResetEnable);
        }
        if ((strValue = attrMap.remove(TAG_DATALINKIMAGE)) != null) {
            this.setDataLinkImage(strValue);
        }
        if ((strValue = attrMap.remove(TAG_DISABLEDATALINKIMAGE)) != null) {
            this.setDisableDataLinkImage(strValue);
        }
        if ((strValue = attrMap.remove(TAG_DATALINKJSCODE)) != null) {
            this.setDataLinkJSCode(strValue);
        }
        if ((strValue = attrMap.remove(TAG_DATALINKTIP)) != null) {
            this.setDataLinkTipMessage(strValue);
        }
        super.OnSetPropertyEx(attrMap);
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

    public String getDataLinkImage() {
        return this.strDataLinkImage;
    }

    public String getDisableDataLinkImage() {
        return this.strDisableDataLinkImage;
    }

    public String getDataLinkJSCode() {
        return this.strDataLinkJSCode;
    }

    public void setDataLinkImage(String strDataLinkImage) {
        this.strDataLinkImage = strDataLinkImage;
    }

    public void setDisableDataLinkImage(String strDisableDataLinkImage) {
        this.strDisableDataLinkImage = strDisableDataLinkImage;
    }

    public void setDataLinkJSCode(String strDataLinkJSCode) {
        this.strDataLinkJSCode = strDataLinkJSCode;
    }

    public String getDataLinkTipMessage() {
        return this.strDataLinkTipMessage;
    }

    public void setDataLinkTipMessage(String strDataLinkTipMessage) {
        this.strDataLinkTipMessage = strDataLinkTipMessage;
    }

    public DataLinksConfig getDataLinksConfig() {
        return this.dataLinksConfig;
    }

    public void setDataLinksConfig(DataLinksConfig dataLinksConfig) {
        this.dataLinksConfig = dataLinksConfig;
    }
}

