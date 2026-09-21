/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLCollectionExConfig
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Web.Form.Model;

import SA.SRFDA.Web.Form.Model.FormItemRuleConfig;
import SA.SRFramework.Base.XMLCollectionExConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import java.util.TreeMap;
import org.w3c.dom.Node;

public class FormItemLogicConfig
extends XMLCollectionExConfig<FormItemRuleConfig> {
    public static final String TAG_SRFDAFORMITEMLOGIC = "SRFDAFORMITEMLOGIC";
    protected static TreeMap<String, String> childNodeMap = new TreeMap();
    protected TreeMap<String, FormItemRuleConfig> ruleItemMap = new TreeMap();

    static {
        childNodeMap.put("SRFDAFORMITEMRULE", FormItemRuleConfig.class.getName());
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        XMLConfig childNode;
        String strObject;
        if (childNodeMap.containsKey(strName) && !StringHelper.IsNullOrEmpty((String)(strObject = childNodeMap.get(strName))) && (childNode = FormItemLogicConfig.CreateChildNode((String)strObject)) != null) {
            childNode.LoadConfig(xmlNode);
            FormItemRuleConfig formItemRuleConfig = (FormItemRuleConfig)childNode;
            this.arr.add(formItemRuleConfig);
            this.ruleItemMap.put(formItemRuleConfig.getRuleType(), formItemRuleConfig);
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public FormItemRuleConfig FindFormItemRuleConfig(String strRuleType) {
        return this.ruleItemMap.get(strRuleType);
    }
}

