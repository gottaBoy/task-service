/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DEField.ValueRule;

import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFVRValueRecursionCondition;
import SA.SRFDA.PS.Core.DEField.ValueRule.PSDEFVRSingleConditionImpl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import net.ibizsys.paas.util.StringHelper;

@PSModelImplementMeta(implement="IPSDEFVRCondition", typevalues={"VALUERECURSION"})
public class PSDEFVRValueRecursionConditionImpl
extends PSDEFVRSingleConditionImpl
implements IPSDEFVRValueRecursionCondition {
    private IPSDataEntity majorPSDataEntity = null;
    private boolean bAlwaysCheck = false;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.majorPSDataEntity = StringHelper.isNullOrEmpty((String)this.psDEFValueRuleCond.getMAJORPSDEID()) ? this.getPSDEField().getPSDataEntity() : this.getPSDEFValueRule().getPSDEField().getPSDataEntity().getPSSystem().getPSDataEntity2(this.psDEFValueRuleCond.getMAJORPSDEID());
        if (!this.psDEFValueRuleCond.isPARAM9Null()) {
            this.bAlwaysCheck = this.psDEFValueRuleCond.getPARAM9() == 1;
        }
    }

    @Override
    public IPSDataEntity getMajorPSDataEntity() {
        return this.majorPSDataEntity;
    }

    @Override
    public boolean isAlwaysCheck() {
        return this.bAlwaysCheck;
    }

    @Override
    public boolean isTryMode() {
        return false;
    }
}

