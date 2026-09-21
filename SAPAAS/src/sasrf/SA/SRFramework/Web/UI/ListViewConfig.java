/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.UI;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Web.UI.ListColumnConfig;
import SA.SRFramework.Web.UI.UserMessageConfig;
import java.util.ArrayList;
import java.util.Hashtable;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ListViewConfig
extends XMLConfig {
    protected static String ITEMCOUNTPERPAGE = "ITEMCOUNTPERPAGE";
    protected static String COLUMNS = "COLUMNS";
    protected static String COLUMN = "COLUMN";
    protected static String USERMESSAGES = "USERMESSAGES";
    protected static String USERMESSAGE = "USERMESSAGE";
    protected static String ORDERFIELDID = "ORDERFIELDID";
    protected static String ORDERDIRECT = "ORDERDIRECT";
    protected int nItemCountPerPage = 10;
    protected int nOrderFieldId = 0;
    protected int nOrderDirect = 0;
    protected ArrayList arrayColumn = new ArrayList();
    protected Hashtable sortedColumns = new Hashtable();
    protected Hashtable orderColumns = new Hashtable();
    protected Hashtable userMessages = new Hashtable();

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (strName.compareToIgnoreCase(ITEMCOUNTPERPAGE) == 0) {
            this.nItemCountPerPage = ListViewConfig.GetValue(strValue, this.nItemCountPerPage);
            return;
        }
        if (strName.compareToIgnoreCase(ORDERFIELDID) == 0) {
            this.nOrderFieldId = ListViewConfig.GetValue(strValue, this.nOrderFieldId);
            return;
        }
        if (strName.compareToIgnoreCase(ORDERDIRECT) == 0) {
            this.nOrderDirect = ListViewConfig.GetValue(strValue, this.nOrderDirect);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    @Override
    public void OnLoadNode(String strName, Node xmlNode) {
        if (strName.compareToIgnoreCase(COLUMNS) == 0) {
            this.OnLoadColumns(xmlNode);
            return;
        }
        if (strName.compareToIgnoreCase(USERMESSAGES) == 0) {
            this.OnLoadUserMessages(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public void OnLoadColumns(Node xmlNode) {
        NodeList nodes = xmlNode.getChildNodes();
        int i = 0;
        while (i < nodes.getLength()) {
            ListColumnConfig item;
            Node childNode = nodes.item(i);
            if (childNode.getNodeName().compareToIgnoreCase(COLUMN) == 0 && (item = new ListColumnConfig()).LoadConfig(childNode)) {
                this.arrayColumn.add(item);
                this.sortedColumns.put(item.getID(), item);
                if (item.getOrderId() != -1) {
                    this.orderColumns.put(item.getOrderId(), item);
                }
            }
            ++i;
        }
    }

    public void OnLoadUserMessages(Node xmlNode) {
        NodeList nodes = xmlNode.getChildNodes();
        int i = 0;
        while (i < nodes.getLength()) {
            UserMessageConfig userMessage;
            Node childNode = nodes.item(i);
            if (childNode.getNodeName().compareToIgnoreCase(USERMESSAGE) == 0 && (userMessage = new UserMessageConfig()).LoadConfig(childNode)) {
                this.userMessages.put(userMessage.getID(), userMessage);
            }
            ++i;
        }
    }

    public ArrayList getColumnItems() {
        return this.arrayColumn;
    }

    public Hashtable getUserMessages() {
        return this.userMessages;
    }

    public ListColumnConfig GetColumnItem(String strId) {
        return (ListColumnConfig)this.sortedColumns.get(strId);
    }

    public int getItemCountPerPage() {
        return this.nItemCountPerPage;
    }

    public String GetDBFieldByOrderFieldId(int nOrderFieldId) {
        if (this.orderColumns.containsKey(nOrderFieldId)) {
            ListColumnConfig item = (ListColumnConfig)this.orderColumns.get(nOrderFieldId);
            return item.getDBField();
        }
        return "";
    }

    public int getOrderFieldId() {
        return this.nOrderFieldId;
    }

    public int getOrderDirect() {
        return this.nOrderDirect;
    }
}

