/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQCustomCondition;
import SA.SRFDA.PS.Core.DataEntity.DS.PSDEDQConditionImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;

public class PSDEDQCustomConditionImpl
extends PSDEDQConditionImpl
implements IPSDEDQCustomCondition {
    private String strCondition = "";
    private String strCustomType = "";

    @Override
    protected void onInit() throws Exception {
        this.strCondition = this.psDEDataQueryCond.getCONDVALUE();
        this.strCustomType = this.psDEDataQueryCond.getCUSTOMTYPE();
        super.onInit();
    }

    @Override
    public String getCondOp() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u6761\u4ef6", fields={"CONDVALUE"})
    public String getCondition() {
        return this.strCondition;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u6761\u4ef6", fields={"CUSTOMTYPE"})
    public String getCustomType() {
        return this.strCustomType;
    }
}

