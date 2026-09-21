/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.UI;

import SA.SRFramework.Base.XMLConfig;

public class TabViewConfig
extends XMLConfig {
    protected static String SHOW = "SHOW";
    protected static String ANCHORIMG = "ANCHORIMG";
    protected static String ANCHORTIP = "ANCHORTIP";
    protected static String NAME = "NAME";
    protected boolean bShow = true;
    protected String strAnchorImg = "";
    protected String strAnchorTip = "";
    protected String strShowName = "";

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (strName.compareToIgnoreCase(SHOW) == 0) {
            this.bShow = TabViewConfig.GetValue(strValue, true);
            return;
        }
        if (strName.compareToIgnoreCase(ANCHORIMG) == 0) {
            this.strAnchorImg = strValue;
            return;
        }
        if (strName.compareToIgnoreCase(ANCHORTIP) == 0) {
            this.strAnchorTip = strValue;
            return;
        }
        if (strName.compareToIgnoreCase(NAME) == 0) {
            this.strShowName = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public boolean getShow() {
        return this.bShow;
    }

    public String getAnchorImg() {
        return this.strAnchorImg;
    }

    public String getAnchorTip() {
        return this.strAnchorTip;
    }

    public String getName() {
        return this.strShowName;
    }
}

