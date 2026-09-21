/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.UI;

import SA.SRFramework.Web.UI.MainViewConfig;
import SA.SRFramework.Web.UI.ParamConfig;
import java.util.ArrayList;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SubViewConfig
extends MainViewConfig {
    protected static String ITEMPARAMS = "ITEMPARAMS";
    protected static String ITEMPARAM = "ITEMPARAM";
    protected static String INFORMFUNC = "INFORMFUNC";
    protected ArrayList itemParamList = new ArrayList();
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
        if (strName.compareToIgnoreCase(ITEMPARAMS) == 0) {
            this.OnLoadItemParams(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public void OnLoadItemParams(Node xmlNode) {
        NodeList nodes = xmlNode.getChildNodes();
        int i = 0;
        while (i < nodes.getLength()) {
            ParamConfig item;
            Node childNode = nodes.item(i);
            if (childNode.getNodeName().compareToIgnoreCase(ITEMPARAM) == 0 && (item = new ParamConfig()).LoadConfig(childNode)) {
                this.itemParamList.add(item);
            }
            ++i;
        }
    }

    public ArrayList getItemParams() {
        return this.itemParamList;
    }

    public String getInformFunc() {
        return this.strInformFunc;
    }
}

