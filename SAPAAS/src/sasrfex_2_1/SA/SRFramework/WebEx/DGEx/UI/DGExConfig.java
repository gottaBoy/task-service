/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.DGEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.DGEx.UI.DGExDataGroupConfig;
import SA.SRFramework.WebEx.DGEx.UI.DGExGroupConfig;
import SA.SRFramework.WebEx.UI.BaseControlConfig;
import SA.SRFramework.WebEx.UI.PagingToolbarConfig;
import org.w3c.dom.Node;

public class DGExConfig
extends BaseControlConfig {
    public static final String TAG_SRFEXDGEX = "SRFEXDGEX";
    public static final String TAG_DATAURL = "DATAURL";
    public static final String TAG_DEFAULTCONDITION = "DEFAULTCONDITION";
    public static final String TAG_PAGING = "PAGING";
    public static final String TAG_LOADDEFAULT = "LOADDEFAULT";
    public static final String TAG_BACKENDCONFIG = "BACKENDCONFIG";
    public static final String TAG_BACKENDCTRL = "BACKENDCTRL";
    public static final String TAG_TIMEOUT = "TIMEOUT";
    public static final String TAG_LOADINGMSG = "LOADINGMSG";
    public static final String TAG_DEFEREMPTYTEXT = "DEFEREMPTYTEXT";
    protected String strDataURL = "";
    protected String strDefaultCondition = "";
    protected boolean bPaging = false;
    protected int nTimeout = 60000;
    protected boolean bLoadDefault = false;
    protected String strBackEndCtrl = "";
    protected String strBackEndConfig = "";
    protected String strLoadingMsg = "";
    protected boolean bDeferEmptyText = true;
    protected DGExDataGroupConfig dataGroupConfig = null;
    protected DGExGroupConfig groupConfig = null;
    protected PagingToolbarConfig pagingToolbarConfig = null;

    protected void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXDGEXDATAGROUP", (boolean)true) == 0) {
            if (this.dataGroupConfig == null) {
                this.dataGroupConfig = new DGExDataGroupConfig();
                this.dataGroupConfig.LoadConfig(xmlNode);
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXDGEXGROUP", (boolean)true) == 0) {
            if (this.groupConfig == null) {
                this.groupConfig = new DGExGroupConfig();
                this.groupConfig.LoadConfig(xmlNode);
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXPAGINGTOOLBAR", (boolean)true) == 0) {
            if (this.pagingToolbarConfig == null) {
                this.pagingToolbarConfig = new PagingToolbarConfig();
                this.pagingToolbarConfig.LoadConfig(xmlNode);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_DATAURL, (boolean)true) == 0) {
            this.strDataURL = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DEFAULTCONDITION, (boolean)true) == 0) {
            this.strDefaultCondition = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_PAGING, (boolean)true) == 0) {
            this.bPaging = DGExConfig.GetValue((String)strValue, (boolean)this.bPaging);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_LOADDEFAULT, (boolean)true) == 0) {
            this.bLoadDefault = DGExConfig.GetValue((String)strValue, (boolean)this.bLoadDefault);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_BACKENDCTRL, (boolean)true) == 0) {
            this.strBackEndCtrl = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_BACKENDCONFIG, (boolean)true) == 0) {
            this.strBackEndConfig = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_LOADINGMSG, (boolean)true) == 0) {
            this.strLoadingMsg = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DEFEREMPTYTEXT, (boolean)true) == 0) {
            this.bDeferEmptyText = DGExConfig.GetValue((String)strValue, (boolean)this.bDeferEmptyText);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_TIMEOUT, (boolean)true) == 0) {
            this.setTimeout(DGExConfig.GetValue((String)strValue, (int)this.getTimeout()));
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public DGExDataGroupConfig getDataGroupConfig() {
        return this.dataGroupConfig;
    }

    public DGExGroupConfig getRootGroupConfig() {
        return this.groupConfig;
    }

    public void setDataURL(String strDataURL) {
        this.strDataURL = strDataURL;
    }

    public String getDataURL() {
        return this.strDataURL;
    }

    public void setDefaultCondition(String strDefaultCondition) {
        this.strDefaultCondition = strDefaultCondition;
    }

    public String getDefaultCondition() {
        return this.strDefaultCondition;
    }

    public void setPaging(boolean bPaging) {
        this.bPaging = bPaging;
    }

    public boolean getPaging() {
        return this.bPaging;
    }

    public void setLoadDefault(boolean bLoadDefault) {
        this.bLoadDefault = bLoadDefault;
    }

    public boolean getLoadDefault() {
        return this.bLoadDefault;
    }

    public String getBackEndCtrl() {
        return this.strBackEndCtrl;
    }

    public void setBackEndCtrl(String strBackEndCtrl) {
        this.strBackEndCtrl = strBackEndCtrl;
    }

    public String getBackEndConfig() {
        return this.strBackEndConfig;
    }

    public void setBackEndConfig(String strBackEndConfig) {
        this.strBackEndConfig = strBackEndConfig;
    }

    public boolean isDeferEmptyText() {
        return this.bDeferEmptyText;
    }

    public void setDeferEmptyText(boolean bDeferEmptyText) {
        this.bDeferEmptyText = bDeferEmptyText;
    }

    public int getTimeout() {
        return this.nTimeout;
    }

    public void setTimeout(int nTimeout) {
        this.nTimeout = nTimeout;
        if (this.nTimeout <= 0) {
            this.nTimeout = 60000;
        }
    }

    public PagingToolbarConfig getPagingToolbarConfig() {
        return this.pagingToolbarConfig;
    }
}

