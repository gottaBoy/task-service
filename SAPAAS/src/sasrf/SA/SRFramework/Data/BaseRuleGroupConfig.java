/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

import SA.SRFramework.Data.BaseRuleConfig;
import SA.SRFramework.Data.RulesANDGroupConfig;
import SA.SRFramework.Data.RulesORGroupConfig;
import SA.SRFramework.Data.ValueEQRuleConfig;
import SA.SRFramework.Data.ValueGTAndEQRuleConfig;
import SA.SRFramework.Data.ValueGTRuleConfig;
import SA.SRFramework.Data.ValueLTAndEQRuleConfig;
import SA.SRFramework.Data.ValueLTRuleConfig;
import SA.SRFramework.Data.ValueNotEQRuleConfig;
import SA.SRFramework.Data.ValueRegRuleConfig;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import org.w3c.dom.Node;

public class BaseRuleGroupConfig
extends BaseRuleConfig {
    protected ArrayList childRuleList = new ArrayList();

    @Override
    public void OnLoadNode(String strName, Node xmlNode) {
        BaseRuleConfig config;
        if (StringHelper.Compare(strName, "RULESAND", true) == 0 && (config = new RulesANDGroupConfig()).LoadConfig(xmlNode)) {
            this.childRuleList.add(config);
            return;
        }
        if (StringHelper.Compare(strName, "RULESOR", true) == 0 && (config = new RulesORGroupConfig()).LoadConfig(xmlNode)) {
            this.childRuleList.add(config);
            return;
        }
        if (StringHelper.Compare(strName, "VALUEEQ", true) == 0 && (config = new ValueEQRuleConfig()).LoadConfig(xmlNode)) {
            this.childRuleList.add(config);
            return;
        }
        if (StringHelper.Compare(strName, "VALUENOTEQ", true) == 0 && (config = new ValueNotEQRuleConfig()).LoadConfig(xmlNode)) {
            this.childRuleList.add(config);
            return;
        }
        if (StringHelper.Compare(strName, "VALUEGT", true) == 0 && (config = new ValueGTRuleConfig()).LoadConfig(xmlNode)) {
            this.childRuleList.add(config);
            return;
        }
        if (StringHelper.Compare(strName, "VALUELT", true) == 0 && (config = new ValueLTRuleConfig()).LoadConfig(xmlNode)) {
            this.childRuleList.add(config);
            return;
        }
        if (StringHelper.Compare(strName, "VALUEGTANDEQ", true) == 0 && (config = new ValueGTAndEQRuleConfig()).LoadConfig(xmlNode)) {
            this.childRuleList.add(config);
            return;
        }
        if (StringHelper.Compare(strName, "VALUELTANDEQ", true) == 0 && (config = new ValueLTAndEQRuleConfig()).LoadConfig(xmlNode)) {
            this.childRuleList.add(config);
            return;
        }
        if (StringHelper.Compare(strName, "VALUEREG", true) == 0 && (config = new ValueRegRuleConfig()).LoadConfig(xmlNode)) {
            this.childRuleList.add(config);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }
}

