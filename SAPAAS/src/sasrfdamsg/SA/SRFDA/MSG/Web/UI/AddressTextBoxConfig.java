/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.UI.TextBoxConfig
 */
package SA.SRFDA.MSG.Web.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.TextBoxConfig;

public class AddressTextBoxConfig
extends TextBoxConfig {
    public static final String TAG_ADDRESSTEXTBOX = "SRFEXADDRESSTEXTBOX";
    public static final String TAG_IMAGE = "IMAGE";
    public static final String TAG_PICKUPCALL = "PICKUPCALL";
    public static final String TAG_TIPMESSAGE = "TIPMESSAGE";
    protected String strImage = "../sasrfex/images/default/icon_datapicker_1.gif";
    protected String strDisableImage = "../sasrfex/images/default/icon_datapicker_3.gif";
    protected String strPickupCall = "pickup";
    protected String strTipMessage = "\u70b9\u51fb\u9009\u62e9\u6570\u636e";

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_IMAGE, (boolean)true) == 0) {
            this.strImage = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_PICKUPCALL, (boolean)true) == 0) {
            this.strPickupCall = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_TIPMESSAGE, (boolean)true) == 0) {
            this.strTipMessage = strValue;
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

    public void setPickupCall(String strPickupCall) {
        this.strPickupCall = strPickupCall;
    }

    public String getPickupCall() {
        return this.strPickupCall;
    }

    public void setTipMessage(String strTipMessage) {
        this.strTipMessage = strTipMessage;
    }

    public String getTipMessage() {
        return this.strTipMessage;
    }
}

