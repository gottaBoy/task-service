/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.ReportEx.Model;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.BaseControlConfig;

public class ChartConfig
extends BaseControlConfig {
    public static final String TAG_CHART = "SRFEXCHART";
    public static final String TAG_DATAURL = "DATAURL";
    public static final String TAG_LOADDEFAULT = "LOADDEFAULT";
    public static final String TAG_EDITABLE = "EDITABLE";
    public static final String TAG_CONTAINER = "CONTAINER";
    public static final String TAG_GRIDPOS = "GRIDPOS";
    public static final String TAG_GRIDWIDTH = "GRIDWIDTH";
    public static final String TAG_GRIDHEIGHT = "GRIDHEIGHT";
    public static final String GRIDPOS_NONE = "NONE";
    public static final String GRIDPOS_LEFT = "LEFT";
    public static final String GRIDPOS_RIGHT = "RIGHT";
    public static final String GRIDPOS_TOP = "TOP";
    public static final String GRIDPOS_BOTTOM = "BOTTOM";
    public static final String GRIDPOS_LEFTTOP = "LEFTTOP";
    public static final String GRIDPOS_LEFTBOTTOM = "LEFTBOTTOM";
    public static final String GRIDPOS_RIGHTTOP = "RIGHTTOP";
    public static final String GRIDPOS_RIGHTBOTTOM = "RIGHTBOTTOM";
    public static final String GRIDPOS_TOPLEFT = "TOPLEFT";
    public static final String GRIDPOS_BOTTOMLEFT = "BOTTOMLEFT";
    public static final String GRIDPOS_TOPRIGHT = "TOPRIGHT";
    public static final String GRIDPOS_BOTTOMRIGHT = "BOTTOMRIGHT";
    public static final String TAG_CHARTSTYLE = "CHARTSTYLE";
    public static final String TAG_BACKENDCONFIG = "BACKENDCONFIG";
    public static final String TAG_BACKENDCTRL = "BACKENDCTRL";
    public static final String TAG_HIDEHEADER = "HIDEHEADER";
    public static final String TAG_CTRLOBJECT = "CTRLOBJECT";
    public static final String TAG_CTRLID = "CTRLID";
    public static final String TAG_CLICKSTOEDIT = "CLICKSTOEDIT";
    public static final String TAG_SPEXCONFIGID = "SPEXCONFIGID";
    protected String strDataURL = "";
    protected boolean bLoadDefault = true;
    protected boolean bEditable = false;
    protected String strBackEndCtrl = "";
    protected String strBackEndConfig = "";
    protected String strCtrlObject = "";
    protected String strCtrlId = "";
    protected String strChartStyle = "";
    protected String strContainer = "";
    protected String strGridPos = "NONE";
    protected int nGridWidth = 0;
    protected int nGridHeight = 0;
    protected String strSPExConfigId = "";

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_DATAURL, (boolean)true) == 0) {
            this.strDataURL = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_LOADDEFAULT, (boolean)true) == 0) {
            this.bLoadDefault = ChartConfig.GetValue((String)strValue, (boolean)this.bLoadDefault);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_EDITABLE, (boolean)true) == 0) {
            this.bEditable = ChartConfig.GetValue((String)strValue, (boolean)this.bEditable);
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
        if (StringHelper.Compare((String)strName, (String)TAG_CTRLOBJECT, (boolean)true) == 0) {
            this.strCtrlObject = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CTRLID, (boolean)true) == 0) {
            this.strCtrlId = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CHARTSTYLE, (boolean)true) == 0) {
            this.strChartStyle = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CONTAINER, (boolean)true) == 0) {
            this.strContainer = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_GRIDPOS, (boolean)true) == 0) {
            this.setGridPos(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_GRIDWIDTH, (boolean)true) == 0) {
            this.setGridWidth(ChartConfig.GetValue((String)strValue, (int)this.getGridWidth()));
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_GRIDHEIGHT, (boolean)true) == 0) {
            this.setGridHeight(ChartConfig.GetValue((String)strValue, (int)this.getGridHeight()));
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_SPEXCONFIGID, (boolean)true) == 0) {
            this.setSPExConfigId(strValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public void setDataURL(String strDataURL) {
        this.strDataURL = strDataURL;
    }

    public String getDataURL() {
        return this.strDataURL;
    }

    public void setLoadDefault(boolean bLoadDefault) {
        this.bLoadDefault = bLoadDefault;
    }

    public boolean getLoadDefault() {
        return this.bLoadDefault;
    }

    public void setEditable(boolean bEditable) {
        this.bEditable = bEditable;
    }

    public boolean getEditable() {
        return this.bEditable;
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

    public String getCtrlObject() {
        return this.strCtrlObject;
    }

    public void setCtrlObject(String strCtrlObject) {
        this.strCtrlObject = strCtrlObject;
    }

    public String getCtrlId() {
        return this.strCtrlId;
    }

    public void setCtrlId(String strCtrlId) {
        this.strCtrlId = strCtrlId;
    }

    public String getChartStyle() {
        return this.strChartStyle;
    }

    public void setChartStyle(String strChartStyle) {
        this.strChartStyle = strChartStyle;
    }

    public String getContainer() {
        return this.strContainer;
    }

    public void setContainer(String strContainer) {
        this.strContainer = strContainer;
    }

    public String getGridPos() {
        return this.strGridPos;
    }

    public int getGridWidth() {
        return this.nGridWidth;
    }

    public void setGridPos(String strGridPos) {
        this.strGridPos = strGridPos;
    }

    public void setGridWidth(int nGridWidth) {
        this.nGridWidth = nGridWidth;
    }

    public int getGridHeight() {
        return this.nGridHeight;
    }

    public void setGridHeight(int nGridHeight) {
        this.nGridHeight = nGridHeight;
    }

    public String getSPExConfigId() {
        return this.strSPExConfigId;
    }

    public void setSPExConfigId(String strSPExConfigId) {
        this.strSPExConfigId = strSPExConfigId;
    }
}

