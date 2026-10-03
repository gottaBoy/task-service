/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLCollectionExConfig
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.DGEx.UI;

import SA.SRFramework.Base.XMLCollectionExConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.DGEx.UI.DGExBaseCellConfig;
import SA.SRFramework.WebEx.DGEx.UI.DGExCellConfig;
import SA.SRFramework.WebEx.DGEx.UI.DGExComplexCellConfig;
import SA.SRFramework.WebEx.DGEx.UI.DGExGroupCellConfig;
import SA.SRFramework.WebEx.DGEx.UI.DGExLabelCellConfig;
import SA.SRFramework.WebEx.DGEx.UI.DGExMacroCellConfig;
import SA.SRFramework.WebEx.DGEx.UI.DGExSNCellConfig;
import java.util.TreeMap;
import org.w3c.dom.Node;

public class DGExCellsConfig
extends XMLCollectionExConfig<DGExBaseCellConfig> {
    protected static TreeMap<String, String> childNodeMap = new TreeMap();
    public static final String TAG_SRFEXDGEXCELLS = "SRFEXDGEXCELLS";

    static {
        childNodeMap.put("SRFEXDGEXLABELCELL", DGExLabelCellConfig.class.getName());
        childNodeMap.put("SRFEXDGEXCELL", DGExCellConfig.class.getName());
        childNodeMap.put("SRFEXDGEXCOMPLEXCELL", DGExComplexCellConfig.class.getName());
        childNodeMap.put("SRFEXDGEXGROUPCELL", DGExGroupCellConfig.class.getName());
        childNodeMap.put("SRFEXDGEXMACROCELL", DGExMacroCellConfig.class.getName());
        childNodeMap.put("SRFEXDGEXSNCELL", DGExSNCellConfig.class.getName());
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        XMLConfig childNode;
        String strObject;
        if (childNodeMap.containsKey(strName) && !StringHelper.IsNullOrEmpty((String)(strObject = childNodeMap.get(strName))) && (childNode = DGExCellsConfig.CreateChildNode((String)strObject)) != null) {
            childNode.LoadConfig(xmlNode);
            if (this.OnChildNodeLoaded((DGExBaseCellConfig)childNode)) {
                this.add((DGExBaseCellConfig)childNode);
                return;
            }
        }
        super.OnLoadNode(strName, xmlNode);
    }
}
