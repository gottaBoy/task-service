/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.ds.IPSDEDataSet
 *  net.ibizsys.model.dataentity.field.IPSDEField
 *  net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRValueRangeCondition
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.dataentity.field.valuerule;

import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRValueRangeCondition;
import net.ibizsys.model.dataentity.field.valuerule.PSDEFVRSingleConditionImpl;
import net.ibizsys.paas.util.StringHelper;

public class PSDEFVRValueRangeConditionImpl
extends PSDEFVRSingleConditionImpl
implements IPSDEFVRValueRangeCondition {
    private IPSDataEntity majorPSDataEntity = null;
    private IPSDEDataSet majorPSDEDataSet = null;
    private IPSDEField majorExtPSDEField = null;
    private IPSDEField minorExtPSDEField = null;
    private boolean bAlwaysCheck = false;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.majorPSDataEntity = this.getPSDEFValueRule().getPSDEField().getPSDataEntity().getPSSystem().getPSDataEntity(this.psDEFValueRuleCond.getMAJORPSDEID());
        this.majorPSDEDataSet = this.majorPSDataEntity.getPSDEDataSet(this.psDEFValueRuleCond.getMAJORPSDEDSTID());
        if (!StringHelper.isNullOrEmpty((String)this.psDEFValueRuleCond.getEXTMAJORPSDEFID())) {
            this.majorExtPSDEField = this.majorPSDataEntity.getPSDEField(this.psDEFValueRuleCond.getEXTMAJORPSDEFID());
            this.minorExtPSDEField = this.getPSDEFValueRule().getPSDEField().getPSDataEntity().getPSDEField(this.psDEFValueRuleCond.getEXTMINORPSDEFID());
        }
        if (!this.psDEFValueRuleCond.isPARAM9Null()) {
            this.bAlwaysCheck = this.psDEFValueRuleCond.getPARAM9() == 1;
        }
    }

    @PSModelRTMeta(description="\u4e3b\u5b9e\u4f53\u5bf9\u8c61")
    public IPSDataEntity getMajorPSDataEntity() {
        return this.majorPSDataEntity;
    }

    @PSModelRTMeta(description="\u4e3b\u5b9e\u4f53\u7ed3\u679c\u96c6\u5bf9\u8c61")
    public IPSDEDataSet getMajorPSDEDataSet() {
        return this.majorPSDEDataSet;
    }

    @PSModelRTMeta(description="\u9644\u52a0\u4e3b\u5b9e\u4f53\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getExtMajorPSDEField() {
        return this.majorExtPSDEField;
    }

    @PSModelRTMeta(description="\u9644\u52a0\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getExtPSDEField() {
        return this.minorExtPSDEField;
    }

    @PSModelRTMeta(description="\u59cb\u7ec8\u68c0\u67e5")
    public boolean isAlwaysCheck() {
        return this.bAlwaysCheck;
    }

    @Override
    @PSModelRTMeta(description="\u68c0\u67e5\u5931\u8d25\u5ffd\u7565")
    public boolean isTryMode() {
        return false;
    }
}

