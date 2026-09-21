/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.UI;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Web.UI.TabViewConfig;
import java.util.ArrayList;
import java.util.Hashtable;
import org.w3c.dom.Node;

public class TabViewsConfig
extends XMLConfig {
    protected static String TABVIEW = "TABVIEW";
    protected static String INFORMFUNC = "INFORMFUNC";
    protected Hashtable tabViewMap = new Hashtable();
    protected ArrayList tabViewList = new ArrayList();
    protected String strInformFunc = "";

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (strName.compareToIgnoreCase(INFORMFUNC) == 0) {
            this.strInformFunc = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    @Override
    public void OnLoadNode(String strName, Node xmlNode) {
        if (xmlNode.getNodeName().compareToIgnoreCase(TABVIEW) == 0) {
            TabViewConfig item = new TabViewConfig();
            if (item.LoadConfig(xmlNode)) {
                this.tabViewList.add(item);
                this.tabViewMap.put(item.getID(), item);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public ArrayList getTabViews() {
        return this.tabViewList;
    }

    public Hashtable getTabViewsMap() {
        return this.tabViewMap;
    }

    public String getInformFunc() {
        return this.strInformFunc;
    }
}

