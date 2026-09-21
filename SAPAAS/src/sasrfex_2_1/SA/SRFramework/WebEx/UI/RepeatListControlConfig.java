/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.ListControlConfig;

public class RepeatListControlConfig
extends ListControlConfig {
    public static final String TAG_FLOWLEFT = "FLOWLEFT";
    public static final String TAG_ITEMWIDTH = "ITEMWIDTH";
    public static final String TAG_ITEMHEIGHT = "ITEMHEIGHT";
    public static final String TAG_CAPTIONCSSCLASS = "CAPTIONCSSCLASS";
    public static final String TAG_ITEMCSSCLASS = "ITEMCSSCLASS";
    protected boolean bFlowLeft = true;
    protected int nItemWidth = 100;
    protected int nItemHeight = 0;
    protected String strCaptionCssClass = "sx-buttoncaption";
    protected String strItemCssClass = "";

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_FLOWLEFT, (boolean)true) == 0) {
            this.bFlowLeft = RepeatListControlConfig.GetValue((String)strValue, (boolean)this.bFlowLeft);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ITEMWIDTH, (boolean)true) == 0) {
            this.nItemWidth = RepeatListControlConfig.GetValue((String)strValue, (int)this.nItemWidth);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ITEMHEIGHT, (boolean)true) == 0) {
            this.nItemHeight = RepeatListControlConfig.GetValue((String)strValue, (int)this.nItemHeight);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CAPTIONCSSCLASS, (boolean)true) == 0) {
            this.strCaptionCssClass = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ITEMCSSCLASS, (boolean)true) == 0) {
            this.strItemCssClass = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getCaptionCssClass() {
        return this.strCaptionCssClass;
    }

    public void setCaptionCssClass(String strCaptionCssClass) {
        this.strCaptionCssClass = strCaptionCssClass;
    }

    public String getItemCssClass() {
        return this.strItemCssClass;
    }

    public void setItemCssClass(String strItemCssClass) {
        this.strItemCssClass = strItemCssClass;
    }

    public boolean getFlowLeft() {
        return this.bFlowLeft;
    }

    public void setFlowLeft(boolean bFlowLeft) {
        this.bFlowLeft = bFlowLeft;
    }

    public int getItemWidth() {
        return this.nItemWidth;
    }

    public void setItemWidth(int nItemWidth) {
        this.nItemWidth = nItemWidth;
    }

    public int getItemHeight() {
        return this.nItemHeight;
    }

    public void setItemHeight(int nItemHeight) {
        this.nItemHeight = nItemHeight;
    }
}

