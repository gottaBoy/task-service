/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRValueRecursionCondition
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.dataentity.field.valuerule;

import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRValueRecursionCondition;
import net.ibizsys.model.dataentity.field.valuerule.PSDEFVRSingleConditionImpl;
import net.ibizsys.paas.util.StringHelper;

public class PSDEFVRValueRecursionConditionImpl
extends PSDEFVRSingleConditionImpl
implements IPSDEFVRValueRecursionCondition {
    private IPSDataEntity majorPSDataEntity = null;
    private boolean bAlwaysCheck = false;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.majorPSDataEntity = StringHelper.isNullOrEmpty((String)this.psDEFValueRuleCond.getMAJORPSDEID()) ? this.getPSDEField().getPSDataEntity() : this.getPSDEFValueRule().getPSDEField().getPSDataEntity().getPSSystem().getPSDataEntity(this.psDEFValueRuleCond.getMAJORPSDEID());
        if (!this.psDEFValueRuleCond.isPARAM9Null()) {
            this.bAlwaysCheck = this.psDEFValueRuleCond.getPARAM9() == 1;
        }
    }

    public IPSDataEntity getMajorPSDataEntity() {
        return this.majorPSDataEntity;
    }

    public boolean isAlwaysCheck() {
        return this.bAlwaysCheck;
    }

    @Override
    public boolean isTryMode() {
        return false;
    }
}

