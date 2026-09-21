/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.ITabPageConfig;
import SA.SRFramework.WebEx.UI.PanelConfig;

public class TabPageConfig
extends PanelConfig
implements ITabPageConfig {
    public static final String TAG_TABPAGE = "SRFEXTABPAGE";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_CAPTIONCSSCLASS = "CAPTIONCSSCLASS";
    public static final String TAG_ACTIVE = "ACTIVE";
    public static final String TAG_VISIBLE = "VISIBLE";
    protected String strCaption = "";
    protected String strCaptionCssClass = "";
    protected boolean bActive = false;
    protected boolean bVisible = true;

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
            this.bActive = TabPageConfig.GetValue((String)strValue, (boolean)this.bActive);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_VISIBLE, (boolean)true) == 0) {
            this.bVisible = TabPageConfig.GetValue((String)strValue, (boolean)this.bVisible);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    @Override
    public void setCaption(String strCaption) {
        this.strCaption = strCaption;
    }

    @Override
    public String getCaption() {
        return this.strCaption;
    }

    @Override
    public void setCaptionCssClass(String strCaptionCssClass) {
        this.strCaptionCssClass = strCaptionCssClass;
    }

    @Override
    public String getCaptionCssClass() {
        return this.strCaptionCssClass;
    }

    @Override
    public void setActive(boolean bActive) {
        this.bActive = bActive;
    }

    @Override
    public boolean getActive() {
        return this.bActive;
    }

    @Override
    public void setVisible(boolean bVisible) {
        this.bVisible = bVisible;
    }

    @Override
    public boolean getVisible() {
        return this.bVisible;
    }
}

