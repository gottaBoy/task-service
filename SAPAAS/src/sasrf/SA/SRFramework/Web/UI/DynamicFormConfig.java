/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.UI;

import SA.SRFramework.Web.UI.FormItemGroup;
import SA.SRFramework.Web.UI.WebFormConfig;
import java.util.ArrayList;
import org.w3c.dom.Node;

public class DynamicFormConfig
extends WebFormConfig {
    protected static String FORMITEMGROUP = "FORMITEMGROUP";
    protected ArrayList groupList = new ArrayList();

    public ArrayList getGroups() {
        return this.groupList;
    }

    @Override
    public void OnLoadNode(String strName, Node xmlNode) {
        if (strName.compareToIgnoreCase(FORMITEMGROUP) == 0) {
            this.OnLoadFormItemGroup(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public void OnLoadFormItemGroup(Node xmlNode) {
        FormItemGroup formItemGroup = new FormItemGroup();
        if (formItemGroup.LoadConfig(xmlNode)) {
            this.groupList.add(formItemGroup);
        }
    }
}

