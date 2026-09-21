/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.BasePanelConfig;
import SA.SRFramework.WebEx.UI.ControlConfigContext;
import SA.SRFramework.WebEx.UI.ControlPanelConfig;
import SA.SRFramework.WebEx.UI.GroupPanelConfig;
import SA.SRFramework.WebEx.UI.HiddenPanelConfig;
import SA.SRFramework.WebEx.UI.RemotePanelConfig;
import SA.SRFramework.WebEx.UI.TabPanelConfig;
import SA.SRFramework.WebEx.UI.TemplatePanelConfig;
import java.util.ArrayList;
import org.w3c.dom.Node;

public class PanelConfig
extends BasePanelConfig {
    public static final String TAG_PANEL = "SRFEXPANEL";
    public static final String TAG_SUMMARYMODE = "SUMMARYMODE";
    public static final String TAG_BACKENDCONFIG = "BACKENDCONFIG";
    public static final String TAG_BACKENDCTRL = "BACKENDCTRL";
    protected ArrayList childPanels = new ArrayList();
    protected String strBackEndCtrl = "";
    protected String strBackEndConfig = "";

    public void OnLoadNode(String strName, Node xmlNode) {
        ControlConfigContext controlConfigContext = this.getConfigContext();
        ControlConfigContext tempContext = null;
        if (controlConfigContext != null) {
            tempContext = controlConfigContext.Clone();
            tempContext.setParentUIStyle(controlConfigContext.getCurUIStyle());
            tempContext.setCurUIStyle(null);
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXHIDDENPANEL", (boolean)true) == 0) {
            HiddenPanelConfig hiddenPanelConfig = new HiddenPanelConfig();
            if (hiddenPanelConfig.LoadConfig(xmlNode, tempContext)) {
                hiddenPanelConfig.setParentPanel(this);
                this.childPanels.add(hiddenPanelConfig);
                if (controlConfigContext != null) {
                    controlConfigContext.FromParamList(tempContext.getParamList());
                }
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXREMOTEPANEL", (boolean)true) == 0) {
            RemotePanelConfig remotePanelConfig = new RemotePanelConfig();
            if (remotePanelConfig.LoadConfig(xmlNode, tempContext)) {
                remotePanelConfig.setParentPanel(this);
                this.childPanels.add(remotePanelConfig);
                if (controlConfigContext != null) {
                    controlConfigContext.FromParamList(tempContext.getParamList());
                }
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_PANEL, (boolean)true) == 0) {
            PanelConfig panelConfig = new PanelConfig();
            if (panelConfig.LoadConfig(xmlNode, tempContext)) {
                panelConfig.setParentPanel(this);
                this.childPanels.add(panelConfig);
                if (controlConfigContext != null) {
                    controlConfigContext.FromParamList(tempContext.getParamList());
                }
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXGROUPPANEL", (boolean)true) == 0) {
            GroupPanelConfig groupPanelConfig = new GroupPanelConfig();
            if (groupPanelConfig.LoadConfig(xmlNode, tempContext)) {
                groupPanelConfig.setParentPanel(this);
                this.childPanels.add(groupPanelConfig);
                if (controlConfigContext != null) {
                    controlConfigContext.FromParamList(tempContext.getParamList());
                }
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXCONTROLPANEL", (boolean)true) == 0) {
            ControlPanelConfig controlPanelConfig = new ControlPanelConfig();
            if (controlPanelConfig.LoadConfig(xmlNode, tempContext)) {
                controlPanelConfig.setParentPanel(this);
                this.childPanels.add(controlPanelConfig);
                if (controlConfigContext != null) {
                    controlConfigContext.FromParamList(tempContext.getParamList());
                }
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXTABPANEL", (boolean)true) == 0) {
            TabPanelConfig tabPanelConfig = new TabPanelConfig();
            if (tabPanelConfig.LoadConfig(xmlNode, tempContext)) {
                tabPanelConfig.setParentPanel(this);
                this.childPanels.add(tabPanelConfig);
                if (controlConfigContext != null) {
                    controlConfigContext.FromParamList(tempContext.getParamList());
                }
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXTEMPLATEPANEL", (boolean)true) == 0) {
            TemplatePanelConfig templatePanelConfig = new TemplatePanelConfig();
            if (templatePanelConfig.LoadConfig(xmlNode, tempContext)) {
                ArrayList arrs = templatePanelConfig.getPanels(tempContext);
                if (arrs != null) {
                    int i = 0;
                    while (i < arrs.size()) {
                        Object objPanel = arrs.get(i);
                        if (objPanel instanceof BasePanelConfig) {
                            BasePanelConfig basePanelConfig = (BasePanelConfig)((Object)objPanel);
                            basePanelConfig.setParentPanel(this);
                            this.childPanels.add(basePanelConfig);
                        }
                        ++i;
                    }
                }
                if (controlConfigContext != null) {
                    controlConfigContext.FromParamList(tempContext.getParamList());
                }
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_BACKENDCTRL, (boolean)true) == 0) {
            this.strBackEndCtrl = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_BACKENDCONFIG, (boolean)true) == 0) {
            this.strBackEndConfig = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public ArrayList getPanels() {
        return this.childPanels;
    }

    public void AddPanel(BasePanelConfig panelConfig) {
        panelConfig.setParentPanel(this);
        this.childPanels.add(panelConfig);
    }

    public void RemovePanel(BasePanelConfig panelConfig) {
        this.childPanels.remove((Object)panelConfig);
    }

    public BasePanelConfig GetPanel(int nIndex) {
        return (BasePanelConfig)((Object)this.childPanels.get(nIndex));
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
}

