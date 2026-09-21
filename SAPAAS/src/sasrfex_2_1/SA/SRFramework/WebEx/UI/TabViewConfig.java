/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.BasePanelConfig;
import SA.SRFramework.WebEx.UI.TabPanelConfig;
import SA.SRFramework.WebEx.UI.TabViewPageConfig;
import java.util.ArrayList;
import org.w3c.dom.Node;

public class TabViewConfig
extends BasePanelConfig {
    public static final String TAG_TABVIEW = "SRFEXTABVIEW";
    public static final String TAG_TOPHEADER = "TOPHEADER";
    public static final String TAG_RESIZECHILD = "RESIZECHILD";
    public static final String TAG_FIRSTPAGEONLY = "FIRSTPAGEONLY";
    protected ArrayList childPages = new ArrayList();
    protected boolean bTopHeader = true;
    protected boolean bResizeChild = false;
    protected boolean bFirstPageOnly = false;

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXTABVIEWPAGE", (boolean)true) == 0) {
            TabViewPageConfig tabViewPageConfig = new TabViewPageConfig();
            if (tabViewPageConfig.LoadConfig(xmlNode)) {
                tabViewPageConfig.setParentPanel(this);
                this.childPages.add(tabViewPageConfig);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_TOPHEADER, (boolean)true) == 0) {
            this.bTopHeader = TabViewConfig.GetValue((String)strValue, (boolean)this.bTopHeader);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_RESIZECHILD, (boolean)true) == 0) {
            this.bResizeChild = TabViewConfig.GetValue((String)strValue, (boolean)this.bResizeChild);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_FIRSTPAGEONLY, (boolean)true) == 0) {
            this.setFirstPageOnly(TabViewConfig.GetValue((String)strValue, (boolean)this.isFirstPageOnly()));
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public boolean isResizeChild() {
        return this.bResizeChild;
    }

    public void setResizeChild(boolean resizeChild) {
        this.bResizeChild = resizeChild;
    }

    public boolean isFirstPageOnly() {
        return this.bFirstPageOnly;
    }

    public void setFirstPageOnly(boolean firstPageOnly) {
        this.bFirstPageOnly = firstPageOnly;
    }

    public boolean isTopHeader() {
        return this.bTopHeader;
    }

    public void setTopHeader(boolean topHeader) {
        this.bTopHeader = topHeader;
    }

    public ArrayList getTabViewPages() {
        return this.childPages;
    }

    public boolean AddTabPage(TabViewPageConfig tabViewPageConfig) {
        tabViewPageConfig.setParentPanel(this);
        this.childPages.add(tabViewPageConfig);
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

    public void Fill(TabPanelConfig tabPanelConfig) {
        tabPanelConfig.setWidth(this.getWidth());
        tabPanelConfig.setHeight(this.getHeight());
        tabPanelConfig.setCssClass(this.getCssClass());
        tabPanelConfig.setCreateDiv(true);
        tabPanelConfig.setExtStyle(this.getExtStyle());
    }

    public void ActiveTabViewPage(String strTabViewPageId) {
        int i = 0;
        while (i < this.childPages.size()) {
            BasePanelConfig panelConfig = (BasePanelConfig)((Object)this.childPages.get(i));
            if (panelConfig instanceof TabViewPageConfig) {
                TabViewPageConfig tabViewPageConfig = (TabViewPageConfig)panelConfig;
                if (StringHelper.Compare((String)tabViewPageConfig.getID(), (String)strTabViewPageId, (boolean)true) == 0) {
                    tabViewPageConfig.setActive(true);
                } else {
                    tabViewPageConfig.setActive(false);
                }
            }
            ++i;
        }
    }
}

