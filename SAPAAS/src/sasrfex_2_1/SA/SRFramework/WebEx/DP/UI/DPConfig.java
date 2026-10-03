/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.DP.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.DP.UI.DPDefaultGroupConfig;
import SA.SRFramework.WebEx.DP.UI.DPEventsConfig;
import SA.SRFramework.WebEx.DP.UI.DPHiddenGroupConfig;
import SA.SRFramework.WebEx.DP.UI.DPPageGroupConfig;
import SA.SRFramework.WebEx.DP.UI.DPPageGroupsConfig;
import SA.SRFramework.WebEx.UI.BaseControlConfig;
import java.util.ArrayList;
import org.w3c.dom.Node;

public class DPConfig
extends BaseControlConfig {
    public static final String TAG_DP = "SRFEXDP";
    public static final String TAG_BACKENDCTRL = "BACKENDCTRL";
    public static final String TAG_BACKENDCONFIG = "BACKENDCONFIG";
    public static final String TAG_CTRLOBJECT = "CTRLOBJECT";
    public static final String TAG_CTRLID = "CTRLID";
    public static final String TAG_READONLY = "READONLY";
    public static final String TAG_SIMPLEMODE = "SIMPLEMODE";
    public static final String TAG_HIDETABHEADER = "HIDETABHEADER";
    public static final String TAG_DPPLUGIN = "DPPLUGIN";
    public static final String TAG_RETURNNAV = "RETURNNAV";
    public static final String TAG_DPSCRIPT = "SCRIPT";
    protected String strBackEndCtrl = "";
    protected String strBackEndConfig = "";
    protected String strCtrlObject = "";
    protected String strCtrlId = "";
    protected boolean bSimpleMode = false;
    protected boolean bHideTabHeader = false;
    protected boolean bReadonly = false;
    protected boolean bReturnNav = true;
    protected DPPageGroupsConfig pageGroupsConfig = new DPPageGroupsConfig();
    protected DPHiddenGroupConfig dpHiddenConfig = null;
    protected DPDefaultGroupConfig dpDefaultConfig = null;
    protected DPEventsConfig dpEventsConfig = null;
    protected String strDPPlugin = "";
    protected String strDPScript = "";

    protected void OnSetProperty(String strName, String strValue) {
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
        if (StringHelper.Compare((String)strName, (String)TAG_SIMPLEMODE, (boolean)true) == 0) {
            this.setSimpleMode(DPConfig.GetValue((String)strValue, (boolean)this.isSimpleMode()));
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_READONLY, (boolean)true) == 0) {
            this.setReadonly(DPConfig.GetValue((String)strValue, (boolean)this.isReadonly()));
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DPPLUGIN, (boolean)true) == 0) {
            this.setDPPlugin(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_RETURNNAV, (boolean)true) == 0) {
            this.setReturnNav(DPConfig.GetValue((String)strValue, (boolean)this.isReturnNav()));
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DPSCRIPT, (boolean)true) == 0) {
            this.setDPScript(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_HIDETABHEADER, (boolean)true) == 0) {
            this.setHideTabHeader(DPConfig.GetValue((String)strValue, (boolean)this.isHideTabHeader()));
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXDPPAGEGROUP", (boolean)true) == 0) {
            DPPageGroupConfig pageGroupConfig = new DPPageGroupConfig();
            pageGroupConfig.setDPConfig(this);
            if (pageGroupConfig.LoadConfig(xmlNode)) {
                this.pageGroupsConfig.add(pageGroupConfig);
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXDPHIDDENGROUP", (boolean)true) == 0) {
            if (this.dpHiddenConfig == null) {
                this.dpHiddenConfig = new DPHiddenGroupConfig();
            }
            this.dpHiddenConfig.LoadConfig(xmlNode);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXDPDEFAULTGROUP", (boolean)true) == 0) {
            if (this.dpDefaultConfig == null) {
                this.dpDefaultConfig = new DPDefaultGroupConfig();
            }
            this.dpDefaultConfig.LoadConfig(xmlNode);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXDPEVENTS", (boolean)true) == 0) {
            if (this.dpEventsConfig == null) {
                this.dpEventsConfig = new DPEventsConfig();
            }
            this.dpEventsConfig.LoadConfig(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public DPPageGroupsConfig getPageGroupsConfig() {
        return this.pageGroupsConfig;
    }

    public void GetFormCtrlConfig(ArrayList list) {
        int i = 0;
        while (i < this.pageGroupsConfig.size()) {
            ((DPPageGroupConfig)((Object)this.pageGroupsConfig.get(i))).GetFormCtrlConfig(list);
            ++i;
        }
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

    public DPHiddenGroupConfig getDPHiddenGroupConfig() {
        return this.dpHiddenConfig;
    }

    public void setDPHiddenGroupConfig(DPHiddenGroupConfig dpHiddenConfig) {
        this.dpHiddenConfig = dpHiddenConfig;
    }

    public DPDefaultGroupConfig getDPDefaultGroupConfig() {
        return this.dpDefaultConfig;
    }

    public void setDPDefaultGroupConfig(DPDefaultGroupConfig dpDefaultConfig) {
        this.dpDefaultConfig = dpDefaultConfig;
    }

    public DPEventsConfig getDPEventsConfig() {
        return this.dpEventsConfig;
    }

    public boolean isSimpleMode() {
        if (this.pageGroupsConfig.size() != 1) {
            return false;
        }
        return this.bSimpleMode;
    }

    public void setSimpleMode(boolean simpleMode) {
        this.bSimpleMode = simpleMode;
    }

    public boolean isReadonly() {
        return this.bReadonly;
    }

    public void setReadonly(boolean readonly) {
        this.bReadonly = readonly;
    }

    public String getDPPlugin() {
        return this.strDPPlugin;
    }

    public void setDPPlugin(String strDPPlugin) {
        this.strDPPlugin = strDPPlugin;
    }

    public boolean isReturnNav() {
        return this.bReturnNav;
    }

    public void setReturnNav(boolean bReturnNav) {
        this.bReturnNav = bReturnNav;
    }

    public String getDPScript() {
        return this.strDPScript;
    }

    public void setDPScript(String strScript) {
        this.strDPScript = strScript;
    }

    public boolean isHideTabHeader() {
        return this.bHideTabHeader;
    }

    public void setHideTabHeader(boolean bHideTabHeader) {
        this.bHideTabHeader = bHideTabHeader;
    }
}
