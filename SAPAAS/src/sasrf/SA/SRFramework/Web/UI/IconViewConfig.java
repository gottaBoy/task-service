/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.UI;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Web.UI.KeyFieldConfig;
import SA.SRFramework.Web.UI.ListColumnConfig;
import SA.SRFramework.Web.UI.UserMessageConfig;
import java.util.ArrayList;
import java.util.Hashtable;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class IconViewConfig
extends XMLConfig {
    protected static String KEYFIELDS = "KEYFIELDS";
    protected static String KEYFIELD = "KEYFIELD";
    protected static String CALLOUTSIDEFUNC = "CALLOUTSIDEFUNC";
    protected static String IMAGE = "IMAGE";
    protected static String CAPTION = "CAPTION";
    protected static String DESCRIPTION = "DESCRIPTION";
    protected static String USERMESSAGES = "USERMESSAGES";
    protected static String USERMESSAGE = "USERMESSAGE";
    protected ArrayList arrayKeyField = new ArrayList();
    protected String strCallOutsideFunc = "";
    protected ListColumnConfig imageColumn = new ListColumnConfig();
    protected ListColumnConfig captionColumn = new ListColumnConfig();
    protected ListColumnConfig descColumn = new ListColumnConfig();
    protected Hashtable userMessages = new Hashtable();

    public ArrayList getKeyItems() {
        return this.arrayKeyField;
    }

    @Override
    public void OnLoadNode(String strName, Node xmlNode) {
        if (strName.compareToIgnoreCase(KEYFIELDS) == 0) {
            this.OnLoadKeyFields(xmlNode);
            return;
        }
        if (strName.compareToIgnoreCase(IMAGE) == 0) {
            this.imageColumn.LoadConfig(xmlNode);
            return;
        }
        if (strName.compareToIgnoreCase(CAPTION) == 0) {
            this.captionColumn.LoadConfig(xmlNode);
            return;
        }
        if (strName.compareToIgnoreCase(DESCRIPTION) == 0) {
            this.descColumn.LoadConfig(xmlNode);
            return;
        }
        if (strName.compareToIgnoreCase(USERMESSAGES) == 0) {
            this.OnLoadUserMessages(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (strName.compareToIgnoreCase(CALLOUTSIDEFUNC) == 0) {
            this.strCallOutsideFunc = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public void OnLoadKeyFields(Node xmlNode) {
        NodeList nodes = xmlNode.getChildNodes();
        int i = 0;
        while (i < nodes.getLength()) {
            KeyFieldConfig item;
            Node childNode = nodes.item(i);
            if (childNode.getNodeName().compareToIgnoreCase(KEYFIELD) == 0 && (item = new KeyFieldConfig()).LoadConfig(childNode)) {
                this.arrayKeyField.add(item);
            }
            ++i;
        }
    }

    public String getCallOutsideFunc() {
        return this.strCallOutsideFunc;
    }

    public ListColumnConfig getImageColumn() {
        return this.imageColumn;
    }

    public ListColumnConfig getCaptionColumn() {
        return this.captionColumn;
    }

    public ListColumnConfig getDescriptionColumn() {
        return this.descColumn;
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

    public Hashtable getUserMessages() {
        return this.userMessages;
    }
}

