/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.BaseControlConfig;

public class FormImageLinkConfig
extends BaseControlConfig {
    public static final String TAG_FORMIMAGELINK = "SRFEXFORMIMAGELINK";
    public static final String TAG_APPENDPARAMS = "APPENDPARAMS";
    public static final String TAG_APPENDFORMPARAMS = "APPENDFORMPARAMS";
    public static final String TAG_LINKURL = "LINKURL";
    public static final String TAG_LINKTARGET = "LINKTARGET";
    public static final String TAG_FORMIMAGELINKID = "FORMIMAGELINKID";
    public static final String TAG_FORMID = "FORMID";
    public static final String TAG_TIPS = "TIPS";
    public static final String TAG_WINDOWMODE = "WINDOWMODE";
    public static final String TAG_WINDOWWIDTH = "WINDOWWIDTH";
    public static final String TAG_WINDOWHEIGHT = "WINDOWHEIGHT";
    public static final String TAG_WINDOWRESIZABLE = "WINDOWRESIZABLE";
    public static final String TAG_WINDOWSCROLL = "WINDOWSCROLL";
    public static final String TAG_WINDOWSTATUS = "WINDOWSTATUS";
    public static final String TAG_MODEL = "MODEL";
    public static final String TAG_JSFUNC = "JSFUNC";
    public static final String TAG_IMAGE = "IMAGE";
    protected String strAppendParams = "";
    protected String strImage = "";
    protected String strAppendFormParams = "";
    protected String strLinkURL = "";
    protected String strLinkTarget = "";
    protected String strFormImageLinkId = "";
    protected String strFormId = null;
    protected String strTips = null;
    protected String strWindowMode = "";
    protected int nWindowWidth = 0;
    protected int nWindowHeight = 0;
    protected String strWindowResizable = "no";
    protected String strWindowScroll = "yes";
    protected String strWindowStatus = "no";
    protected boolean bJSFunc = false;

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_IMAGE, (boolean)true) == 0) {
            this.strImage = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_APPENDPARAMS, (boolean)true) == 0) {
            this.strAppendParams = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_APPENDFORMPARAMS, (boolean)true) == 0) {
            this.strAppendFormParams = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_LINKURL, (boolean)true) == 0) {
            this.strLinkURL = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_LINKTARGET, (boolean)true) == 0) {
            this.strLinkTarget = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_FORMIMAGELINKID, (boolean)true) == 0) {
            this.strFormImageLinkId = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_FORMID, (boolean)true) == 0) {
            this.strFormId = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_TIPS, (boolean)true) == 0) {
            this.strTips = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_WINDOWMODE, (boolean)true) == 0) {
            this.strWindowMode = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_WINDOWRESIZABLE, (boolean)true) == 0) {
            this.strWindowResizable = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_WINDOWSCROLL, (boolean)true) == 0) {
            this.strWindowScroll = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_WINDOWSTATUS, (boolean)true) == 0) {
            this.strWindowStatus = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_WINDOWWIDTH, (boolean)true) == 0) {
            this.nWindowWidth = FormImageLinkConfig.GetValue((String)strValue, (int)this.nWindowWidth);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_WINDOWHEIGHT, (boolean)true) == 0) {
            this.nWindowHeight = FormImageLinkConfig.GetValue((String)strValue, (int)this.nWindowHeight);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_JSFUNC, (boolean)true) == 0) {
            this.bJSFunc = FormImageLinkConfig.GetValue((String)strValue, (boolean)this.bJSFunc);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public boolean getJSFunc() {
        return this.bJSFunc;
    }

    public void setJSFunc(boolean bJSFunc) {
        this.bJSFunc = bJSFunc;
    }

    public void setImage(String strImage) {
        this.strImage = strImage;
    }

    public String getImage() {
        return this.strImage;
    }

    public String getAppendParams() {
        return this.strAppendParams;
    }

    public void setAppendParams(String strAppendParams) {
        this.strAppendParams = strAppendParams;
    }

    public String getAppendFormParams() {
        return this.strAppendFormParams;
    }

    public void setAppendFormParams(String strAppendFormParams) {
        this.strAppendFormParams = strAppendFormParams;
    }

    public String getLinkURL() {
        return this.strLinkURL;
    }

    public void setLinkURL(String strLinkURL) {
        this.strLinkURL = strLinkURL;
    }

    public String getLinkTarget() {
        return this.strLinkTarget;
    }

    public void setLinkTarget(String strLinkTarget) {
        this.strLinkTarget = strLinkTarget;
    }

    public String getFormImageLinkId() {
        return this.strFormImageLinkId;
    }

    public void setFormImageLinkId(String strFormImageLinkId) {
        this.strFormImageLinkId = strFormImageLinkId;
    }

    public String getFormId() {
        return this.strFormId;
    }

    public void setFormId(String strFormId) {
        this.strFormId = strFormId;
    }

    public void setTips(String strTips) {
        this.strTips = strTips;
    }

    public String getTips() {
        return this.strTips;
    }

    public void setWindowMode(String strWindowMode) {
        this.strWindowMode = strWindowMode;
    }

    public String getWindowMode() {
        return this.strWindowMode;
    }

    public String getWindowResizable() {
        return this.strWindowResizable;
    }

    public void setWindowResizable(String strWindowResizable) {
        this.strWindowResizable = strWindowResizable;
    }

    public String getWindowScroll() {
        return this.strWindowScroll;
    }

    public void setWindowScroll(String strWindowScroll) {
        this.strWindowScroll = strWindowScroll;
    }

    public String getWindowStatus() {
        return this.strWindowStatus;
    }

    public void setWindowStatus(String strWindowStatus) {
        this.strWindowStatus = strWindowStatus;
    }

    public int getWindowWidth() {
        return this.nWindowWidth;
    }

    public void setWindowWidth(int nWindowWidth) {
        this.nWindowWidth = nWindowWidth;
    }

    public int getWindowHeight() {
        return this.nWindowHeight;
    }

    public void setWindowHeight(int nWindowHeight) {
        this.nWindowHeight = nWindowHeight;
    }
}

