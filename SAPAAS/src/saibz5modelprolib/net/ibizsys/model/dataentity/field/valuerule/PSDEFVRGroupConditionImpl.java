/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRCondition
 *  net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRGroupCondition
 *  net.ibizsys.paas.core.valuerule.IDEFVRCondition
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.dataentity.field.valuerule;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRCondition;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRConditionRuntime;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRGroupCondition;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFValueRuleType;
import net.ibizsys.model.dataentity.field.valuerule.PSDEFVRConditionImpl;
import net.ibizsys.model.entity.PSDEFValueRuleCond;
import net.ibizsys.paas.core.valuerule.IDEFVRCondition;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;

public class PSDEFVRGroupConditionImpl
extends PSDEFVRConditionImpl
implements IPSDEFVRGroupCondition {
    protected ArrayList<IPSDEFVRCondition> psDEFValueRuleConditionList = new ArrayList();
    protected ArrayList<IDEFVRCondition> conditionList = new ArrayList();

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.onPreparePSDEFValueRuleConditions();
    }

    protected void onPreparePSDEFValueRuleConditions() throws Exception {
        this.psDEFValueRuleConditionList.clear();
        this.conditionList.clear();
        ArrayList<PSDEFValueRuleCond> psDEFValueRuleCondList = this.psDEFValueRuleCond.getChildPSDEFValueRuleConds(false);
        if (psDEFValueRuleCondList == null) {
            return;
        }
        for (PSDEFValueRuleCond psDEFValueRuleCond : psDEFValueRuleCondList) {
            IPSDEFVRCondition iPSDEFValueRuleCondition = this.createPSDEFValueRuleCondition(psDEFValueRuleCond);
            ((IPSDEFVRConditionRuntime)iPSDEFValueRuleCondition).init(this.getPSModelStorageContext(), this.getPSDEFValueRule(), this, psDEFValueRuleCond);
            this.psDEFValueRuleConditionList.add(iPSDEFValueRuleCondition);
        }
        this.conditionList.addAll(this.psDEFValueRuleConditionList);
    }

    protected IPSDEFVRCondition createPSDEFValueRuleCondition(PSDEFValueRuleCond psDEFValueRuleCond) throws Exception {
        if (StringHelper.compare((String)psDEFValueRuleCond.getCONDTYPE(), (String)"GROUP", (boolean)true) == 0) {
            return new PSDEFVRGroupConditionImpl();
        }
        IPSDEFValueRuleType iPSDEFValueRuleType = this.getPSModelStorageContext().getPSDEFValueRuleType(psDEFValueRuleCond.getCONDTYPE());
        return iPSDEFValueRuleType.createPSDEFVRCondition(psDEFValueRuleCond);
    }

    @PSModelRTMeta(description="\u5b50\u6761\u4ef6\u96c6\u5408")
    public Iterator<IPSDEFVRCondition> getPSDEFVRConditions() {
        if (this.psDEFValueRuleConditionList == null || this.psDEFValueRuleConditionList.size() == 0) {
            return null;
        }
        return this.psDEFValueRuleConditionList.iterator();
    }

    @PSModelRTMeta(description="\u7ec4\u5408\u6761\u4ef6\u64cd\u4f5c", codelist="GroupCond")
    public String getCondOp() {
        return this.psDEFValueRuleCond.getGROUPOP();
    }

    public Iterator<IDEFVRCondition> getChildConditions() {
        if (this.conditionList == null || this.conditionList.size() == 0) {
            return null;
        }
        return this.conditionList.iterator();
    }

    @Override
    public void fillRelatedPSDEFields(ArrayList<String> relatedPSDEFieldList) {
        if (this.psDEFValueRuleConditionList == null || this.psDEFValueRuleConditionList.size() == 0) {
            return;
        }
        for (IPSDEFVRCondition iPSDEFVRCondition : this.psDEFValueRuleConditionList) {
            ((IPSDEFVRConditionRuntime)iPSDEFVRCondition).fillRelatedPSDEFields(relatedPSDEFieldList);
        }
    }

    @Override
    protected String onCalcRuleInfo() throws Exception {
        if (this.psDEFValueRuleConditionList == null || this.psDEFValueRuleConditionList.size() == 0) {
            return super.onCalcRuleInfo();
        }
        StringBuilderEx sb = new StringBuilderEx();
        if (this.isNotMode()) {
            sb.append("\u4e0d\u80fd\u51fa\u73b0(");
        } else if (this.psDEFValueRuleConditionList.size() > 1) {
            sb.append("(");
        }
        boolean bFirst = true;
        for (IPSDEFVRCondition iPSDEFVRCondition : this.psDEFValueRuleConditionList) {
            if (StringHelper.isNullOrEmpty((String)iPSDEFVRCondition.getRuleInfo())) continue;
            if (bFirst) {
                bFirst = false;
            } else if (StringHelper.compare((String)this.getCondOp(), (String)"AND", (boolean)true) == 0) {
                sb.append(" \u5e76\u4e14 ");
            } else {
                sb.append(" \u6216\u8005 ");
            }
            sb.append(iPSDEFVRCondition.getRuleInfo());
        }
        if (this.isNotMode() || this.psDEFValueRuleConditionList.size() > 1) {
            sb.append(")");
        }
        return sb.toString();
    }
}

