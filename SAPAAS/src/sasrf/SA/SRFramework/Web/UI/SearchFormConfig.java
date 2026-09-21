/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.UI;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Web.UI.SearchCtrlConfig;
import SA.SRFramework.Web.UI.SearchFormModeHelper;
import SA.SRFramework.Web.UI.SearchFormShowViewHelper;
import SA.SRFramework.Web.UI.WebFormConfig;
import java.util.ArrayList;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SearchFormConfig
extends WebFormConfig {
    public static final String SEARCHITEMS = "SEARCHITEMS";
    public static final String SEARCHITEM = "SEARCHITEM";
    public static final String SHOW = "SHOW";
    public static final String MODE = "MODE";
    public static final String USERPARAMS = "USERPARAMS";
    public static final String USERPARAM = "USERPARAM";
    protected ArrayList itemList = new ArrayList();
    protected ArrayList userParamList = null;
    protected int showView = 1;
    protected int searchFormMode = 0;

    public SearchFormConfig() {
        this.curFormStyle = 1;
    }

    public int getShowView() {
        return this.showView;
    }

    public int getMode() {
        return this.searchFormMode;
    }

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (strName.compareToIgnoreCase(SHOW) == 0) {
            this.showView = SearchFormShowViewHelper.FromString(strValue);
            return;
        }
        if (strName.compareToIgnoreCase(MODE) == 0) {
            this.searchFormMode = SearchFormModeHelper.FromString(strValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    @Override
    public void OnLoadNode(String strName, Node xmlNode) {
        if (strName.compareToIgnoreCase(SEARCHITEMS) == 0) {
            this.OnLoadSearchItems(xmlNode);
            return;
        }
        if (strName.compareToIgnoreCase(USERPARAMS) == 0) {
            this.OnLoadUserParams(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    protected void OnLoadSearchItems(Node xmlNode) {
        NodeList nodes = xmlNode.getChildNodes();
        int i = 0;
        while (i < nodes.getLength()) {
            SearchCtrlConfig searchCtrlConfig;
            Node childNode = nodes.item(i);
            if (childNode.getNodeName().compareToIgnoreCase(SEARCHITEM) == 0 && (searchCtrlConfig = new SearchCtrlConfig()).LoadConfig(childNode)) {
                this.itemList.add(searchCtrlConfig);
            }
            ++i;
        }
    }

    protected void OnLoadUserParams(Node xmlNode) {
        if (this.userParamList == null) {
            this.userParamList = new ArrayList();
        }
        NodeList nodes = xmlNode.getChildNodes();
        int i = 0;
        while (i < nodes.getLength()) {
            XMLConfig userParam;
            Node childNode = nodes.item(i);
            if (childNode.getNodeName().compareToIgnoreCase(USERPARAM) == 0 && (userParam = new XMLConfig()).LoadConfig(childNode)) {
                this.userParamList.add(userParam.getID());
            }
            ++i;
        }
    }

    public ArrayList getSearchItems() {
        return this.itemList;
    }

    public ArrayList getUserParams() {
        return this.userParamList;
    }
}

