/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DEField.ValueRule;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFVRValueRangeCondition;
import SA.SRFDA.PS.Core.DEField.ValueRule.PSDEFVRSingleConditionImpl;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

@PSModelImplementMeta(implement="IPSDEFVRCondition", typevalues={"VALUERANGE"})
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
        this.majorPSDataEntity = this.getPSDEFValueRule().getPSDEField().getPSDataEntity().getPSSystem().getPSDataEntity2(this.psDEFValueRuleCond.getMAJORPSDEID());
        this.majorPSDEDataSet = this.majorPSDataEntity.getPSDEDataSet(this.psDEFValueRuleCond.getMAJORPSDEDSTID());
        if (!StringHelper.isNullOrEmpty((String)this.psDEFValueRuleCond.getEXTMAJORPSDEFID())) {
            this.majorExtPSDEField = this.majorPSDataEntity.getPSDEField(this.psDEFValueRuleCond.getEXTMAJORPSDEFID());
            this.minorExtPSDEField = this.getPSDEFValueRule().getPSDEField().getPSDataEntity().getPSDEField(this.psDEFValueRuleCond.getEXTMINORPSDEFID());
        }
        if (!this.psDEFValueRuleCond.isPARAM9Null()) {
            this.bAlwaysCheck = this.psDEFValueRuleCond.getPARAM9() == 1;
        }
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u5b9e\u4f53\u5bf9\u8c61", dumpref=true, ignorepf=true, fields={"MAJORPSDEID"})
    public IPSDataEntity getMajorPSDataEntity() {
        return this.majorPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u5b9e\u4f53\u7ed3\u679c\u96c6\u5bf9\u8c61", dumpref=true, ignorepf=true, fields={"MAJORPSDEDSTID"})
    public IPSDEDataSet getMajorPSDEDataSet() {
        return this.majorPSDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u9644\u52a0\u4e3b\u5b9e\u4f53\u5c5e\u6027\u5bf9\u8c61", dumpref=true, ignorepf=true, fields={"EXTMAJORPSDEFID"})
    public IPSDEField getExtMajorPSDEField() {
        return this.majorExtPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u9644\u52a0\u5c5e\u6027\u5bf9\u8c61", dumpref=true, ignorepf=true, fields={"EXTMINORPSDEFID"})
    public IPSDEField getExtPSDEField() {
        return this.minorExtPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u59cb\u7ec8\u68c0\u67e5", fields={"PARAM9"})
    public boolean isAlwaysCheck() {
        return this.bAlwaysCheck;
    }

    @Override
    @PSModelRTMeta(description="\u68c0\u67e5\u5931\u8d25\u5ffd\u7565", doc="\u6052\u4e3afalse", staticcode="false")
    public boolean isTryMode() {
        return false;
    }
}

