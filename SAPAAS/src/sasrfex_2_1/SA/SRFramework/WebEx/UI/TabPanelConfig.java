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
import SA.SRFramework.WebEx.UI.LinkTabPageConfig;
import SA.SRFramework.WebEx.UI.RealTabPageConfig;
import SA.SRFramework.WebEx.UI.RemoteTabPageConfig;
import SA.SRFramework.WebEx.UI.TabPageConfig;
import java.util.ArrayList;
import org.w3c.dom.Node;

public class TabPanelConfig
extends BasePanelConfig {
    public static final String TAG_TABPANEL = "SRFEXTABPANEL";
    public static final String TAG_CREATEDIV = "CREATEDIV";
    public static final String TAG_MAXTABWIDTH = "MAXTABWIDTH";
    public static final String TAG_MINTABWIDTH = "MINTABWIDTH";
    public static final String TAG_AUTOSIZE = "AUTOSIZE";
    protected boolean bCreateDiv = true;
    protected ArrayList childPages = new ArrayList();
    protected int nMaxTabWidth = 0;
    protected int nMinTabWidth = 0;
    protected boolean bAutoSize = false;

    public TabPanelConfig() {
        this.nWidth = 1.0;
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        ControlConfigContext controlConfigContext = this.getConfigContext();
        ControlConfigContext tempContext = null;
        if (controlConfigContext != null) {
            tempContext = controlConfigContext.Clone();
            tempContext.setParentUIStyle(controlConfigContext.getCurUIStyle());
            tempContext.setCurUIStyle(null);
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXTABPAGE", (boolean)true) == 0) {
            TabPageConfig tabPageConfig = new TabPageConfig();
            if (tabPageConfig.LoadConfig(xmlNode, tempContext)) {
                tabPageConfig.setParentPanel(this);
                this.childPages.add(tabPageConfig);
                if (controlConfigContext != null) {
                    controlConfigContext.FromParamList(tempContext.getParamList());
                }
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXREMOTETABPAGE", (boolean)true) == 0) {
            RemoteTabPageConfig remoteTabPageConfig = new RemoteTabPageConfig();
            if (remoteTabPageConfig.LoadConfig(xmlNode, tempContext)) {
                remoteTabPageConfig.setParentPanel(this);
                this.childPages.add(remoteTabPageConfig);
                if (controlConfigContext != null) {
                    controlConfigContext.FromParamList(tempContext.getParamList());
                }
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXREALTABPAGE", (boolean)true) == 0) {
            RealTabPageConfig realTabPageConfig = new RealTabPageConfig();
            if (realTabPageConfig.LoadConfig(xmlNode, tempContext)) {
                realTabPageConfig.setParentPanel(this);
                this.childPages.add(realTabPageConfig);
                if (controlConfigContext != null) {
                    controlConfigContext.FromParamList(tempContext.getParamList());
                }
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXLINKTABPAGE", (boolean)true) == 0) {
            LinkTabPageConfig linkTabPageConfig = new LinkTabPageConfig();
            if (linkTabPageConfig.LoadConfig(xmlNode, tempContext)) {
                linkTabPageConfig.setParentPanel(this);
                this.childPages.add(linkTabPageConfig);
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
        if (StringHelper.Compare((String)strName, (String)TAG_CREATEDIV, (boolean)true) == 0) {
            this.bCreateDiv = TabPanelConfig.GetValue((String)strValue, (boolean)this.bCreateDiv);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_MAXTABWIDTH, (boolean)true) == 0) {
            this.nMaxTabWidth = TabPanelConfig.GetValue((String)strValue, (int)this.nMaxTabWidth);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_MINTABWIDTH, (boolean)true) == 0) {
            this.nMinTabWidth = TabPanelConfig.GetValue((String)strValue, (int)this.nMinTabWidth);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_AUTOSIZE, (boolean)true) == 0) {
            this.bAutoSize = TabPanelConfig.GetValue((String)strValue, (boolean)this.bAutoSize);
        }
        super.OnSetProperty(strName, strValue);
    }

    public ArrayList getTabPages() {
        return this.childPages;
    }

    public boolean AddTabPage(RemoteTabPageConfig remoteTabPageConfig) {
        remoteTabPageConfig.setParentPanel(this);
        this.childPages.add(remoteTabPageConfig);
        return true;
    }

    public boolean AddTabPage(TabPageConfig tabPageConfig) {
        tabPageConfig.setParentPanel(this);
        this.childPages.add(tabPageConfig);
        return true;
    }

    public boolean AddTabPage(RealTabPageConfig tabPageConfig) {
        tabPageConfig.setParentPanel(this);
        this.childPages.add(tabPageConfig);
        return true;
    }

    public boolean AddTabPage(LinkTabPageConfig tabPageConfig) {
        tabPageConfig.setParentPanel(this);
        this.childPages.add(tabPageConfig);
        return true;
    }

    public void RemoveTabPage(Object objTabPage) {
        if (this.childPages.contains(objTabPage)) {
            this.childPages.remove(objTabPage);
        }
    }

    public void RemoveTabPage(String strTabPageId) {
        int i = 0;
        while (i < this.childPages.size()) {
            BasePanelConfig panelConfig = (BasePanelConfig)((Object)this.childPages.get(i));
            if (StringHelper.Compare((String)strTabPageId, (String)panelConfig.getID(), (boolean)true) == 0) {
                this.childPages.remove(i);
                break;
            }
            ++i;
        }
    }

    public void setCreateDiv(boolean bCreateDiv) {
        this.bCreateDiv = bCreateDiv;
    }

    public boolean getCreateDiv() {
        return this.bCreateDiv;
    }

    public void setMaxTabWidth(int nMaxTabWidth) {
        this.nMaxTabWidth = nMaxTabWidth;
    }

    public int getMaxTabWidth() {
        return this.nMaxTabWidth;
    }

    public void setMinTabWidth(int nMinTabWidth) {
        this.nMinTabWidth = nMinTabWidth;
    }

    public int getMinTabWidth() {
        return this.nMinTabWidth;
    }

    public boolean isAutoSize() {
        return this.bAutoSize;
    }

    public void setAutoSize(boolean autoSize) {
        this.bAutoSize = autoSize;
    }
}

