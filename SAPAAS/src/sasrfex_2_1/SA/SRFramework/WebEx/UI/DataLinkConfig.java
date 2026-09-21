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

public class DataLinkConfig
extends XMLConfig {
    public static final String TAG_DATALINK = "SRFEXDATALINK";
    public static final String TAG_DATALINKIMAGE = "DATALINKIMAGE";
    public static final String TAG_DISABLEDATALINKIMAGE = "DISABLEDATALINKIMAGE";
    public static final String TAG_DATALINKJSCODE = "DATALINKJSCODE";
    public static final String TAG_DATALINKTIP = "DATALINKTIPMESSAGE";
    protected String strDataLinkImage = "../sasrfex/images/default/icon_datalink_1.png";
    protected String strDisableDataLinkImage = "../sasrfex/images/default/icon_datalink_2.png";
    protected String strDataLinkJSCode = "";
    protected String strDataLinkTipMessage = "\u70b9\u51fb\u67e5\u770b\u8be6\u7ec6\u4fe1\u606f";

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_DATALINKIMAGE, (boolean)true) == 0) {
            this.setDataLinkImage(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DISABLEDATALINKIMAGE, (boolean)true) == 0) {
            this.setDisableDataLinkImage(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DATALINKJSCODE, (boolean)true) == 0) {
            this.setDataLinkJSCode(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DATALINKTIP, (boolean)true) == 0) {
            this.setDataLinkTipMessage(strValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
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

    public String getDataLinkTipMessage() {
        return this.strDataLinkTipMessage;
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

    public void setDataLinkTipMessage(String strDataLinkTipMessage) {
        this.strDataLinkTipMessage = strDataLinkTipMessage;
    }
}

