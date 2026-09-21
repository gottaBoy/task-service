/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.ds.IPSDEDataQuery
 *  net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRQueryCountCondition
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.dataentity.field.valuerule;

import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.dataentity.ds.IPSDEDataQuery;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRQueryCountCondition;
import net.ibizsys.model.dataentity.field.valuerule.PSDEFVRSingleConditionImpl;
import net.ibizsys.paas.util.StringHelper;

public class PSDEFVRQueryCountConditionImpl
extends PSDEFVRSingleConditionImpl
implements IPSDEFVRQueryCountCondition {
    private String strPSDEDataQueryId = null;
    private IPSDEDataQuery iPSDEDataQuery = null;
    private boolean bAlwaysCheck = false;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.strPSDEDataQueryId = this.psDEFValueRuleCond.getPSDEDQID();
        if (!StringHelper.isNullOrEmpty((String)this.strPSDEDataQueryId)) {
            this.iPSDEDataQuery = this.getPSDEFValueRule().getPSDEField().getPSDataEntity().getPSDEDataQuery(this.strPSDEDataQueryId);
        }
        if (this.iPSDEDataQuery == null) {
            throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u5b9a\u4e49\u67e5\u8be2\u8ba1\u6570\u4f7f\u7528\u7684\u6570\u636e\u67e5\u8be2"));
        }
        if (!this.psDEFValueRuleCond.isPARAM9Null()) {
            this.bAlwaysCheck = this.psDEFValueRuleCond.getPARAM9() == 1;
        }
    }

    @PSModelRTMeta(description="\u6700\u5c0f\u503c")
    public Integer getMinValue() {
        if (this.psDEFValueRuleCond.isPARAM3Null()) {
            return null;
        }
        return this.psDEFValueRuleCond.getPARAM3();
    }

    @PSModelRTMeta(description="\u542b\u6700\u5c0f\u503c")
    public boolean isIncludeMinValue() {
        if (this.psDEFValueRuleCond.isPARAM5Null()) {
            return false;
        }
        return this.psDEFValueRuleCond.getPARAM5();
    }

    @PSModelRTMeta(description="\u6700\u5927\u503c")
    public Integer getMaxValue() {
        if (this.psDEFValueRuleCond.isPARAM4Null()) {
            return null;
        }
        return this.psDEFValueRuleCond.getPARAM4();
    }

    @PSModelRTMeta(description="\u542b\u6700\u5927\u503c")
    public boolean isIncludeMaxValue() {
        if (this.psDEFValueRuleCond.isPARAM6Null()) {
            return false;
        }
        return this.psDEFValueRuleCond.getPARAM6();
    }

    public String getPSDEDataQueryId() {
        return this.strPSDEDataQueryId;
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u67e5\u8be2\u5bf9\u8c61")
    public IPSDEDataQuery getPSDEDataQuery() {
        return this.iPSDEDataQuery;
    }

    @PSModelRTMeta(description="\u59cb\u7ec8\u68c0\u67e5")
    public boolean isAlwaysCheck() {
        return this.bAlwaysCheck;
    }
}

