/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.UI.ListLinkConfig;
import SA.SRFramework.Web.UI.ListMgrColumnConfig;
import SA.SRFramework.Web.UI.MainListConfig;
import java.util.ArrayList;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SubListConfig
extends MainListConfig {
    protected ArrayList listLinkItems = new ArrayList();
    protected ListMgrColumnConfig managerColumn = null;
    protected static String LINKS = "LINKS";
    protected static String MGRCOLUMN = "MGRCOLUMN";
    protected static String LINK = "LINK";

    @Override
    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare(strName, LINKS, true) == 0) {
            this.OnLoadLinks(xmlNode);
            return;
        }
        if (StringHelper.Compare(strName, MGRCOLUMN, true) == 0) {
            this.managerColumn = new ListMgrColumnConfig();
            this.managerColumn.LoadConfig(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public void OnLoadLinks(Node xmlNode) {
        NodeList nodes = xmlNode.getChildNodes();
        int i = 0;
        while (i < nodes.getLength()) {
            ListLinkConfig item;
            Node childNode = nodes.item(i);
            if (StringHelper.Compare(childNode.getNodeName(), LINK, true) == 0 && (item = new ListLinkConfig()).LoadConfig(childNode)) {
                this.listLinkItems.add(item);
            }
            ++i;
        }
    }

    public ArrayList getLinkItems() {
        return this.listLinkItems;
    }

    public ListMgrColumnConfig getMgrColumn() {
        return this.managerColumn;
    }
}

