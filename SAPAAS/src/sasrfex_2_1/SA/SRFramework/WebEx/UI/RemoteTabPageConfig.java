/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.RemotePanelConfig;

public class RemoteTabPageConfig
extends RemotePanelConfig {
    public static final String TAG_REMOTETABPAGE = "SRFEXREMOTETABPAGE";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_CAPTIONCSSCLASS = "CAPTIONCSSCLASS";
    public static final String TAG_ACTIVE = "ACTIVE";
    protected String strCaption = "";
    protected String strCaptionCssClass = "";
    protected boolean bActive = false;

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_CAPTION, (boolean)true) == 0) {
            this.strCaption = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CAPTIONCSSCLASS, (boolean)true) == 0) {
            this.strCaptionCssClass = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ACTIVE, (boolean)true) == 0) {
            this.bActive = RemoteTabPageConfig.GetValue((String)strValue, (boolean)this.bActive);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"RESOURCEID", (boolean)true) == 0) {
            this.strResourceId = strValue;
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

    public void setCaptionCssClass(String strCaptionCssClass) {
        this.strCaptionCssClass = strCaptionCssClass;
    }

    public String getCaptionCssClass() {
        return this.strCaptionCssClass;
    }

    public void setActive(boolean bActive) {
        this.bActive = bActive;
    }

    public boolean getActive() {
        return this.bActive;
    }
}

