/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLCollectionExConfig
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Model;

import SA.SRFDA.Model.ValueRuleConfig;
import SA.SRFramework.Base.XMLCollectionExConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import java.util.TreeMap;
import org.w3c.dom.Node;

public class ValueRuleMgr
extends XMLCollectionExConfig<ValueRuleConfig> {
    protected TreeMap<String, ValueRuleConfig> valueRuleMap = new TreeMap();
    protected static TreeMap<String, String> childNodeMap = new TreeMap();

    static {
        childNodeMap.put("SRFDAVALUERULE", ValueRuleConfig.class.getName());
    }

    public boolean LoadConfig(Node xmlNode) {
        if (!super.LoadConfig(xmlNode)) {
            return false;
        }
        for (ValueRuleConfig valueRuleConfig : this.arr) {
            this.valueRuleMap.put(valueRuleConfig.getID().toUpperCase(), valueRuleConfig);
        }
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ValueRuleConfig FindRuleConfig(String strRuleId) {
        strRuleId = strRuleId.toUpperCase();
        TreeMap<String, ValueRuleConfig> treeMap = this.valueRuleMap;
        synchronized (treeMap) {
            return this.valueRuleMap.get(strRuleId);
        }
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        XMLConfig childNode;
        String strObject;
        if (childNodeMap.containsKey(strName) && !StringHelper.IsNullOrEmpty((String)(strObject = childNodeMap.get(strName))) && (childNode = ValueRuleMgr.CreateChildNode((String)strObject)) != null) {
            childNode.LoadConfig(xmlNode);
            if (this.OnChildNodeLoaded((ValueRuleConfig)childNode)) {
                this.add((ValueRuleConfig)childNode);
                return;
            }
        }
        super.OnLoadNode(strName, xmlNode);
    }
}

