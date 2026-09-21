/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Report.List;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;

public class ListColumnConfig
extends XMLConfig {
    public static final String TAG_SRFDALISTCOLUMN = "SRFDALISTCOLUMN";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_ALIGN = "ALIGN";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_CAPLANRESID = "CAPLANRESID";
    public static final String TAG_FORMAT = "FORMAT";
    public static final String TAG_PARAMS = "PARAMS";
    public static final String TAG_DEFAULT = "DEFAULT";
    public static final String TAG_GROUP = "GROUP";
    public static final String TAG_CUSTOM = "CUSTOM";
    public static final String TAG_CUSTOMTAG = "CUSTOMTAG";
    protected String strCaption = "";
    protected String strCapLanResId = "";
    protected int nWidth = 0;
    protected String strAlign = "";
    protected String strFormat = "";
    protected String strParams = "";
    protected String strDefault = "";
    protected boolean bGroup = false;
    protected String strCustom = "";
    protected String strCustomTag = "";

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_CAPTION, (boolean)true) == 0) {
            this.strCaption = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_WIDTH, (boolean)true) == 0) {
            this.nWidth = ListColumnConfig.GetValue((String)strValue, (int)this.nWidth);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ALIGN, (boolean)true) == 0) {
            this.strAlign = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_FORMAT, (boolean)true) == 0) {
            this.strFormat = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_PARAMS, (boolean)true) == 0) {
            this.strParams = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DEFAULT, (boolean)true) == 0) {
            this.strDefault = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_GROUP, (boolean)true) == 0) {
            this.bGroup = ListColumnConfig.GetValue((String)strValue, (boolean)this.bGroup);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CUSTOM, (boolean)true) == 0) {
            this.strCustom = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CUSTOMTAG, (boolean)true) == 0) {
            this.strCustomTag = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CAPLANRESID, (boolean)true) == 0) {
            this.strCapLanResId = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getCaption() {
        return this.strCaption;
    }

    public int getWidth() {
        return this.nWidth;
    }

    public String getAlign() {
        return this.strAlign;
    }

    public void setCaption(String strCaption) {
        this.strCaption = strCaption;
    }

    public void setWidth(int width) {
        this.nWidth = width;
    }

    public void setAlign(String strAlign) {
        this.strAlign = strAlign;
    }

    public String getParams() {
        return this.strParams;
    }

    public String getDefault() {
        return this.strDefault;
    }

    public boolean isGroup() {
        return this.bGroup;
    }

    public void setParams(String strParams) {
        this.strParams = strParams;
    }

    public void setDefault(String strDefault) {
        this.strDefault = strDefault;
    }

    public void setGroup(boolean group) {
        this.bGroup = group;
    }

    public String getFormat() {
        return this.strFormat;
    }

    public void setFormat(String strFormat) {
        this.strFormat = strFormat;
    }

    public String getCustom() {
        return this.strCustom;
    }

    public String getCustomTag() {
        return this.strCustomTag;
    }

    public void setCustom(String strCustom) {
        this.strCustom = strCustom;
    }

    public void setCustomTag(String strCustomTag) {
        this.strCustomTag = strCustomTag;
    }

    public String getCapLanResId() {
        return this.strCapLanResId;
    }

    public void setCapLanResId(String strCapLanResId) {
        this.strCapLanResId = strCapLanResId;
    }
}

