/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLCollectionExConfig
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.DEDC.Ctrl.Model;

import SA.SRFDA.DEDC.Ctrl.Model.DEDCRuleConfig;
import SA.SRFramework.Base.XMLCollectionExConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import java.util.TreeMap;
import org.w3c.dom.Node;

public class DEDCRuleProcessConfig
extends XMLCollectionExConfig<DEDCRuleConfig> {
    public static final String TAG_SRFDADEDCRULEPROCESS = "SRFDADEDCRULEPROCESS";
    protected static TreeMap<String, String> childNodeMap = new TreeMap();

    static {
        childNodeMap.put("SRFDADEDCRULE", DEDCRuleConfig.class.getName());
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        XMLConfig childNode;
        String strObject;
        if (childNodeMap.containsKey(strName) && !StringHelper.IsNullOrEmpty((String)(strObject = childNodeMap.get(strName))) && (childNode = DEDCRuleProcessConfig.CreateChildNode((String)strObject)) != null) {
            childNode.LoadConfig(xmlNode);
            this.arr.add((DEDCRuleConfig)childNode);
        }
        super.OnLoadNode(strName, xmlNode);
    }
}

