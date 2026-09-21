/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.CollectionXMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.ValueRule;

import SA.SRFramework.Base.CollectionXMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.ValueRule.FormItemValueRuleConfig;
import org.w3c.dom.Node;

public class FormValueRuleConfig
extends CollectionXMLConfig {
    public static final String TAG_SRFEXFORMVALUERULE = "FORMVALUERULE";

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)FormItemValueRuleConfig.TAG_SRFEXFORMITEMVALUERULE, (boolean)true) == 0) {
            FormItemValueRuleConfig formItemValueRuleConfig = new FormItemValueRuleConfig();
            if (formItemValueRuleConfig.LoadConfig(xmlNode)) {
                this.arrayList.add(formItemValueRuleConfig);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public FormItemValueRuleConfig GetFormItemValueRuleConfig(String strFormItemId) {
        int nCount = this.arrayList.size();
        int i = 0;
        while (i < nCount) {
            FormItemValueRuleConfig formItemValueRuleConfig = (FormItemValueRuleConfig)((Object)this.arrayList.get(i));
            if (StringHelper.Compare((String)formItemValueRuleConfig.getFormItemId(), (String)strFormItemId, (boolean)true) == 0) {
                return formItemValueRuleConfig;
            }
            ++i;
        }
        return null;
    }
}

