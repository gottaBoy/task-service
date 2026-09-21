/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.TreeView.UI;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.TreeView.UI.TreeNodeTemplateConfig;
import java.util.ArrayList;
import org.w3c.dom.Node;

public class TreeNodeTemplatesConfig
extends XMLConfig {
    public static final String TAG_TREENODETEMPLATES = "SRFEXTREENODETEMPLATES";
    protected ArrayList<TreeNodeTemplateConfig> childs = new ArrayList();

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXTREENODETEMPLATE", (boolean)true) == 0) {
            TreeNodeTemplateConfig treeNodeTemplateConfig = new TreeNodeTemplateConfig();
            if (treeNodeTemplateConfig.LoadConfig(xmlNode)) {
                this.childs.add(treeNodeTemplateConfig);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public TreeNodeTemplateConfig GetTreeNodeTemplateConfig(SRFExWebContext webContext, DataRow dr) {
        for (TreeNodeTemplateConfig item : this.childs) {
            if (!item.isMatchCondition(webContext, dr)) continue;
            return item;
        }
        return null;
    }

    public TreeNodeTemplateConfig GetTreeNodeTemplateConfig(SRFExWebContext webContext, BaseDataEntity dataEntity) {
        for (TreeNodeTemplateConfig item : this.childs) {
            if (!item.isMatchCondition(webContext, dataEntity)) continue;
            return item;
        }
        return null;
    }
}

