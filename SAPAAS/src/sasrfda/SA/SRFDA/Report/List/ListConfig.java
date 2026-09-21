/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.UI.BaseControlConfig
 */
package SA.SRFDA.Report.List;

import SA.SRFDA.Report.List.ListColumnsConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.BaseControlConfig;
import org.w3c.dom.Node;

public class ListConfig
extends BaseControlConfig {
    public static final String TAG_HIDEHEADER = "HIDEHEADER";
    public static final String TAG_EMPTYMSG = "EMPTYMSG";
    public static final String TAG_DATAURL = "DATAURL";
    public static final String TAG_LOADDEFAULT = "LOADDEFAULT";
    public static final String TAG_RELOADTIMER = "RELOADTIMER";
    protected ListColumnsConfig listColumnsConfig = new ListColumnsConfig();
    protected boolean bHideHeader = false;
    protected String strEmptyMsg = "\u6ca1\u6709\u4efb\u4f55\u6570\u636e";
    protected String strDataURL = "";
    protected boolean bLoadDefault = true;
    protected int nReloadTimer = 0;

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_DATAURL, (boolean)true) == 0) {
            this.strDataURL = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_LOADDEFAULT, (boolean)true) == 0) {
            this.bLoadDefault = ListConfig.GetValue((String)strValue, (boolean)this.bLoadDefault);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_HIDEHEADER, (boolean)true) == 0) {
            this.bHideHeader = ListConfig.GetValue((String)strValue, (boolean)this.bHideHeader);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_EMPTYMSG, (boolean)true) == 0) {
            this.strEmptyMsg = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_RELOADTIMER, (boolean)true) == 0) {
            this.nReloadTimer = ListConfig.GetValue((String)strValue, (int)this.nReloadTimer);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFDALISTCOLUMNS", (boolean)true) == 0) {
            this.listColumnsConfig.LoadConfig(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public ListColumnsConfig getListColumnsConfig() {
        return this.listColumnsConfig;
    }

    public boolean isHideHeader() {
        return this.bHideHeader;
    }

    public void setHideHeader(boolean hideHeader) {
        this.bHideHeader = hideHeader;
    }

    public String getEmptyMsg() {
        return this.strEmptyMsg;
    }

    public void setEmptyMsg(String strEmptyMsg) {
        this.strEmptyMsg = strEmptyMsg;
    }

    public String getDataURL() {
        return this.strDataURL;
    }

    public boolean isLoadDefault() {
        return this.bLoadDefault;
    }

    public void setDataURL(String strDataURL) {
        this.strDataURL = strDataURL;
    }

    public void setLoadDefault(boolean bLoadDefault) {
        this.bLoadDefault = bLoadDefault;
    }

    public void setReloadTimer(int nReloadTimer) {
        this.nReloadTimer = nReloadTimer;
    }

    public int getReloadTimer() {
        return this.nReloadTimer;
    }
}

