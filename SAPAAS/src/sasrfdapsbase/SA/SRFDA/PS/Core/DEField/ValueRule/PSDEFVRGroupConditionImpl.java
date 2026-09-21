/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  net.ibizsys.paas.core.valuerule.IDEFVRCondition
 */
package SA.SRFDA.PS.Core.DEField.ValueRule;

import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFVRCondition;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFVRGroupCondition;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFValueRuleType;
import SA.SRFDA.PS.Core.DEField.ValueRule.PSDEFVRConditionImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSDEFValueRuleCond;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.core.valuerule.IDEFVRCondition;

@PSModelImplementMeta(implement="IPSDEFVRCondition", typevalues={"GROUP"})
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
            iPSDEFValueRuleCondition.init(this.getDAGlobalHelper(), this.getPSDEFValueRule(), this, psDEFValueRuleCond);
            this.psDEFValueRuleConditionList.add(iPSDEFValueRuleCondition);
        }
        this.conditionList.addAll(this.psDEFValueRuleConditionList);
    }

    protected IPSDEFVRCondition createPSDEFValueRuleCondition(PSDEFValueRuleCond psDEFValueRuleCond) throws Exception {
        if (StringHelper.Compare((String)psDEFValueRuleCond.getCONDTYPE(), (String)"GROUP", (boolean)true) == 0) {
            return new PSDEFVRGroupConditionImpl();
        }
        IPSDEFValueRuleType iPSDEFValueRuleType = this.getPSModelStorage().getPSDEFValueRuleType(psDEFValueRuleCond.getCONDTYPE());
        return iPSDEFValueRuleType.createPSDEFVRCondition(psDEFValueRuleCond);
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u6761\u4ef6\u96c6\u5408", child=true, rtname="getConds")
    public Iterator<IPSDEFVRCondition> getPSDEFVRConditions() {
        if (this.psDEFValueRuleConditionList == null || this.psDEFValueRuleConditionList.size() == 0) {
            return null;
        }
        return this.psDEFValueRuleConditionList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u7ec4\u5408\u6761\u4ef6\u64cd\u4f5c", codelist="GroupCond", fields={"GROUPOP"})
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
            iPSDEFVRCondition.fillRelatedPSDEFields(relatedPSDEFieldList);
        }
    }

    @Override
    protected String onCalcRuleInfo() throws Exception {
        if (this.psDEFValueRuleConditionList == null || this.psDEFValueRuleConditionList.size() == 0) {
            return super.onCalcRuleInfo();
        }
        StringBuilderEx sb = new StringBuilderEx();
        boolean bGroup = false;
        if (this.isNotMode()) {
            sb.Append("\u4e0d\u80fd\u51fa\u73b0(");
        }
        boolean bFirst = true;
        for (IPSDEFVRCondition iPSDEFVRCondition : this.psDEFValueRuleConditionList) {
            if (StringHelper.IsNullOrEmpty((String)iPSDEFVRCondition.getRuleInfo())) continue;
            if (bFirst) {
                bFirst = false;
            } else {
                bGroup = true;
                if (StringHelper.Compare((String)this.getCondOp(), (String)"AND", (boolean)true) == 0) {
                    sb.Append(" \u5e76\u4e14 ");
                } else {
                    sb.Append(" \u6216\u8005 ");
                }
            }
            sb.Append(iPSDEFVRCondition.getRuleInfo());
        }
        if (this.isNotMode()) {
            sb.Append(")");
        }
        if (bGroup && !this.isNotMode()) {
            return "(" + sb.toString() + ")";
        }
        return sb.toString();
    }
}

