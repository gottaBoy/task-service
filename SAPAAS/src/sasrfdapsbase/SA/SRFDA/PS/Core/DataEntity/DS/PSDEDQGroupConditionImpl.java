/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQCondition;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQGroupCondition;
import SA.SRFDA.PS.Core.DataEntity.DS.PSDEDQConditionImpl;
import SA.SRFDA.PS.Core.DataEntity.DS.PSDEDQCustomConditionImpl;
import SA.SRFDA.PS.Core.DataEntity.DS.PSDEDQFieldConditionImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSDEDataQueryCond;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;

public class PSDEDQGroupConditionImpl
extends PSDEDQConditionImpl
implements IPSDEDQGroupCondition {
    protected ArrayList<IPSDEDQCondition> psDEDQConditionList = new ArrayList();

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.onPreparePSDEDQConditions();
    }

    protected void onPreparePSDEDQConditions() throws Exception {
        this.psDEDQConditionList.clear();
        ArrayList<PSDEDataQueryCond> psDEDataQueryCondList = this.psDEDataQueryCond.getChildPSDEDataQueryConds(false);
        if (psDEDataQueryCondList == null) {
            return;
        }
        for (PSDEDataQueryCond psDEDataQueryCond : psDEDataQueryCondList) {
            IPSDEDQCondition iPSDEDQCondition = this.createPSDEDQCondition(psDEDataQueryCond);
            iPSDEDQCondition.init(this.getDAGlobalHelper(), this.iPSDEDQJoin, this, psDEDataQueryCond);
            this.psDEDQConditionList.add(iPSDEDQCondition);
        }
    }

    protected IPSDEDQCondition createPSDEDQCondition(PSDEDataQueryCond psDEDataQueryCond) throws Exception {
        if (StringHelper.Compare((String)psDEDataQueryCond.getCONDTYPE(), (String)"GROUP", (boolean)true) == 0) {
            return new PSDEDQGroupConditionImpl();
        }
        if (StringHelper.Compare((String)psDEDataQueryCond.getCONDTYPE(), (String)"SINGLE", (boolean)true) == 0) {
            return new PSDEDQFieldConditionImpl();
        }
        if (StringHelper.Compare((String)psDEDataQueryCond.getCONDTYPE(), (String)"CUSTOM", (boolean)true) == 0) {
            return new PSDEDQCustomConditionImpl();
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u6761\u4ef6\u7c7b\u578b[%1$s]", (Object)psDEDataQueryCond.getCONDTYPE()));
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u6761\u4ef6\u96c6\u5408", child=true)
    public Iterator<IPSDEDQCondition> getPSDEDQConditions() {
        if (this.psDEDQConditionList == null) {
            return null;
        }
        return this.psDEDQConditionList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u7ec4\u5408\u6761\u4ef6", codelist="GroupCond", fields={"GROUPOP"})
    public String getCondOp() {
        return this.psDEDataQueryCond.getGROUPOP();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u53d6\u53cd", ignoredumpvalues="false", fields={"GROUPNOTFLAG"})
    public boolean isNotMode() {
        return this.psDEDataQueryCond.getGROUPNOTFLAG();
    }
}

