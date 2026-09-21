/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

import SA.SRFramework.Data.BaseRuleConfig;
import SA.SRFramework.Data.BaseRuleGroupConfig;
import java.util.Hashtable;

public class RulesORGroupConfig
extends BaseRuleGroupConfig {
    @Override
    public boolean Check(int type, Object objValue, Hashtable paramList) throws Exception {
        int nCount = this.childRuleList.size();
        int i = 0;
        while (i < nCount) {
            BaseRuleConfig rule = (BaseRuleConfig)this.childRuleList.get(i);
            if (rule.Check(type, objValue, paramList)) {
                return true;
            }
            ++i;
        }
        return false;
    }
}

