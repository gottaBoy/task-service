/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.FileUploaderConfig;

public class PictureUploaderConfig
extends FileUploaderConfig {
    public static final String TAG_PICTUREUPLOADER = "SRFEXPICTUREUPLOADER";
    public static final String TAG_ITEMWIDTH = "ITEMWIDTH";
    public static final String TAG_ITEMHEIGHT = "ITEMHEIGHT";
    protected int nItemWidth = 100;
    protected int nItemHeight = 0;

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_ITEMWIDTH, (boolean)true) == 0) {
            this.nItemWidth = PictureUploaderConfig.GetValue((String)strValue, (int)this.nItemWidth);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ITEMHEIGHT, (boolean)true) == 0) {
            this.nItemHeight = PictureUploaderConfig.GetValue((String)strValue, (int)this.nItemHeight);
            return;
        }
        super.OnSetProperty(strName, strValue);
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

