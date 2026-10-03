/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLCollectionExConfig
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Model;

import SA.SRFDA.Model.DGModelBaseLogicConfig;
import SA.SRFDA.Model.DGModelCustomLogicConfig;
import SA.SRFDA.Model.DGModelGroupLogicConfig;
import SA.SRFDA.Model.DGModelSingleLogicConfig;
import SA.SRFramework.Base.XMLCollectionExConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import java.util.TreeMap;
import org.w3c.dom.Node;

public class DGModelLogicsConfig
extends XMLCollectionExConfig<DGModelBaseLogicConfig> {
    public static final String TAG_DGMODELLOGICS = "SRFDADGMODELLOGICS";
    protected static TreeMap<String, String> childNodeMap = new TreeMap();

    static {
        childNodeMap.put("SRFDADGMODELSINGLELOGIC", DGModelSingleLogicConfig.class.getName());
        childNodeMap.put("SRFDADGMODELGROUPLOGIC", DGModelGroupLogicConfig.class.getName());
        childNodeMap.put("SRFDADGMODELCUSTOMLOGIC", DGModelCustomLogicConfig.class.getName());
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        XMLConfig childNode;
        String strObject;
        if (childNodeMap.containsKey(strName) && !StringHelper.IsNullOrEmpty((String)(strObject = childNodeMap.get(strName))) && (childNode = DGModelLogicsConfig.CreateChildNode((String)strObject)) != null) {
            childNode.LoadConfig(xmlNode);
            if (this.OnChildNodeLoaded((DGModelBaseLogicConfig)childNode)) {
                this.add((DGModelBaseLogicConfig)childNode);
                return;
            }
        }
        super.OnLoadNode(strName, xmlNode);
    }
}
