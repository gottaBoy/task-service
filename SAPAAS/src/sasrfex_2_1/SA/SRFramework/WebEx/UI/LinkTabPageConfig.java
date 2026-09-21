/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.BasePanelConfig;

public class LinkTabPageConfig
extends BasePanelConfig {
    public static final String TAG_LINKTABPAGE = "SRFEXLINKTABPAGE";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_CAPTIONCSSCLASS = "CAPTIONCSSCLASS";
    public static final String TAG_ACTIVE = "ACTIVE";
    public static final String TAG_HREF = "HREF";
    protected String strCaption = "";
    protected String strCaptionCssClass = "";
    protected boolean bActive = false;
    protected String strHref = "";

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
        if (StringHelper.Compare((String)strName, (String)TAG_HREF, (boolean)true) == 0) {
            this.strHref = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ACTIVE, (boolean)true) == 0) {
            this.bActive = LinkTabPageConfig.GetValue((String)strValue, (boolean)this.bActive);
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

    public void setHref(String strHref) {
        this.strHref = strHref;
    }

    public String getHref() {
        return this.strHref;
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

