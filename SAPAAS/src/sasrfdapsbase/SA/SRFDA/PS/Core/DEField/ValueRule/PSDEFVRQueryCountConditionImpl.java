/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DEField.ValueRule;

import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFVRQueryCountCondition;
import SA.SRFDA.PS.Core.DEField.ValueRule.PSDEFVRSingleConditionImpl;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

@PSModelImplementMeta(implement="IPSDEFVRCondition", typevalues={"QUERYCOUNT"})
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

    @Override
    @PSModelRTMeta(description="\u6700\u5c0f\u503c", fields={"PARAM3"})
    public Integer getMinValue() {
        if (this.psDEFValueRuleCond.isPARAM3Null()) {
            return null;
        }
        return this.psDEFValueRuleCond.getPARAM3();
    }

    @Override
    @PSModelRTMeta(description="\u542b\u6700\u5c0f\u503c", fields={"PARAM5"})
    public boolean isIncludeMinValue() {
        if (this.psDEFValueRuleCond.isPARAM5Null()) {
            return false;
        }
        return this.psDEFValueRuleCond.getPARAM5();
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5927\u503c", fields={"PARAM4"})
    public Integer getMaxValue() {
        if (this.psDEFValueRuleCond.isPARAM4Null()) {
            return null;
        }
        return this.psDEFValueRuleCond.getPARAM4();
    }

    @Override
    @PSModelRTMeta(description="\u542b\u6700\u5927\u503c", fields={"PARAM6"})
    public boolean isIncludeMaxValue() {
        if (this.psDEFValueRuleCond.isPARAM6Null()) {
            return false;
        }
        return this.psDEFValueRuleCond.getPARAM6();
    }

    @Override
    public String getPSDEDataQueryId() {
        return this.strPSDEDataQueryId;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u67e5\u8be2\u5bf9\u8c61", dumpref=true, from="IPSDataEntity", ignorepf=true, fields={"PSDEDQID"})
    public IPSDEDataQuery getPSDEDataQuery() {
        return this.iPSDEDataQuery;
    }

    @Override
    @PSModelRTMeta(description="\u59cb\u7ec8\u68c0\u67e5", fields={"PARAM9"})
    public boolean isAlwaysCheck() {
        return this.bAlwaysCheck;
    }
}

