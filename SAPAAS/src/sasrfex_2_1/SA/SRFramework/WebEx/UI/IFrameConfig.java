/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.BaseControlConfig;

public class IFrameConfig
extends BaseControlConfig {
    public static final String TAG_IFRAME = "SRFEXIFRAME";
    public static final String TAG_RESIZABLE = "RESIZABLE";
    public static final String TAG_SCROLL = "SCROLL";
    public static final String TAG_URL = "URL";
    public static final String TAG_APPENDPARAMS = "APPENDPARAMS";
    public static final String TAG_APPENDFORMPARAMS = "APPENDFORMPARAMS";
    public static final String TAG_UPDATEFORMPARAMS = "UPDATEFORMPARAMS";
    public static final String TAG_FRAMEBORDER = "FRAMEBORDER";
    public static final String TAG_FRAMEALIAS = "FRAMEALIAS";
    protected String strURL = "";
    protected String strResizable = "no";
    protected String strScroll = "no";
    protected String strAppendParams = "";
    protected String strAppendFormParams = "";
    protected String strUpdateFormParams = "";
    protected int nFrameBorder = 0;
    protected String strFrameAlias = "";

    public IFrameConfig() {
        this.nWidth = 1.0;
        this.nHeight = 1.0;
    }

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_APPENDPARAMS, (boolean)true) == 0) {
            this.strAppendParams = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_URL, (boolean)true) == 0) {
            this.strURL = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_RESIZABLE, (boolean)true) == 0) {
            this.strResizable = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_SCROLL, (boolean)true) == 0) {
            this.strScroll = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_APPENDFORMPARAMS, (boolean)true) == 0) {
            this.strAppendFormParams = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_UPDATEFORMPARAMS, (boolean)true) == 0) {
            this.strUpdateFormParams = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_FRAMEALIAS, (boolean)true) == 0) {
            this.setFrameAlias(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_FRAMEBORDER, (boolean)true) == 0) {
            this.setFrameBorder(IFrameConfig.GetValue((String)strValue, (int)this.getFrameBorder()));
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getAppendParams() {
        return this.strAppendParams;
    }

    public void setAppendParams(String strAppendParams) {
        this.strAppendParams = strAppendParams;
    }

    public String getURL() {
        return this.strURL;
    }

    public void setURL(String strURL) {
        this.strURL = strURL;
    }

    public String getResizable() {
        return this.strResizable;
    }

    public void setResizable(String strResizable) {
        this.strResizable = strResizable;
    }

    public String getScroll() {
        return this.strScroll;
    }

    public void setScroll(String strScroll) {
        this.strScroll = strScroll;
    }

    public String getAppendFormParams() {
        return this.strAppendFormParams;
    }

    public void setAppendFormParams(String strAppendFormParams) {
        this.strAppendFormParams = strAppendFormParams;
    }

    public String getUpdateFormParams() {
        return this.strUpdateFormParams;
    }

    public void setUpdateFormParams(String strUpdateFormParams) {
        this.strUpdateFormParams = strUpdateFormParams;
    }

    public int getFrameBorder() {
        return this.nFrameBorder;
    }

    public void setFrameBorder(int nFrameBorder) {
        if (nFrameBorder < 0) {
            nFrameBorder = 0;
        }
        this.nFrameBorder = nFrameBorder;
    }

    public String getFrameAlias() {
        return this.strFrameAlias;
    }

    public void setFrameAlias(String strFrameAlias) {
        this.strFrameAlias = strFrameAlias;
    }
}

