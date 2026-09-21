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

public class PagingToolbarConfig
extends XMLConfig {
    public static final String TAG_SRFEXPAGINGTOOLBAR = "SRFEXPAGINGTOOLBAR";
    public static final String TAG_PAGESIZE = "PAGESIZE";
    public static final String TAG_DISPLAYMSG = "DISPLAYMSG";
    public static final String TAG_EMPTYMSG = "EMPTYMSG";
    public static final String TAG_BEFOREPAGEMSG = "BEFOREPAGEMSG";
    public static final String TAG_AFTERPAGEMSG = "AFTERPAGEMSG";
    protected int nPageSize = 20;
    protected String strDisplayMsg = "\u5f53\u524d\u663e\u793a\u8bb0\u5f55 {0} - {1} \u603b\u8ba1 {2}";
    protected String strEmptyMsg = "\u65e0\u4efb\u4f55\u8bb0\u5f55";
    protected String strBeforePageMsg = "\u5f53\u524d";
    protected String strAfterPageMsg = "/{0}\u9875";

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_PAGESIZE, (boolean)true) == 0) {
            this.nPageSize = PagingToolbarConfig.GetValue((String)strValue, (int)this.nPageSize);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DISPLAYMSG, (boolean)true) == 0) {
            this.strDisplayMsg = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_EMPTYMSG, (boolean)true) == 0) {
            this.strEmptyMsg = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_BEFOREPAGEMSG, (boolean)true) == 0) {
            this.strBeforePageMsg = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_AFTERPAGEMSG, (boolean)true) == 0) {
            this.strAfterPageMsg = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public void setPageSize(int nPageSize) {
        this.nPageSize = nPageSize;
    }

    public int getPageSize() {
        return this.nPageSize;
    }

    public String getDisplayMsg() {
        return this.strDisplayMsg;
    }

    public void setDisplayMsg(String strDisplayMsg) {
        this.strDisplayMsg = strDisplayMsg;
    }

    public String getEmptyMsg() {
        return this.strEmptyMsg;
    }

    public void setEmptyMsg(String strEmptyMsg) {
        this.strEmptyMsg = strEmptyMsg;
    }

    public String getBeforePageMsg() {
        return this.strBeforePageMsg;
    }

    public void setBeforePageMsg(String strBeforePageMsg) {
        this.strBeforePageMsg = strBeforePageMsg;
    }

    public String getAfterPageMsg() {
        return this.strAfterPageMsg;
    }

    public void setAfterPageMsg(String strAfterPageMsg) {
        this.strAfterPageMsg = strAfterPageMsg;
    }
}

