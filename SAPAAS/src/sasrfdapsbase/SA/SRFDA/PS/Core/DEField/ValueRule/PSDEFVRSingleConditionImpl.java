/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DEField.ValueRule;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFVRSingleCondition;
import SA.SRFDA.PS.Core.DEField.ValueRule.PSDEFVRConditionImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import java.util.ArrayList;
import net.ibizsys.paas.util.StringHelper;

public class PSDEFVRSingleConditionImpl
extends PSDEFVRConditionImpl
implements IPSDEFVRSingleCondition {
    private IPSDEField iPSDEField = null;
    private String strDEFName = "";

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.strDEFName = this.psDEFValueRuleCond.getCUSTOMDEFNAME();
        this.iPSDEField = StringHelper.isNullOrEmpty((String)this.psDEFValueRuleCond.getPSDEFID()) ? this.getPSDEFValueRule().getPSDEField() : (StringHelper.compare((String)this.psDEFValueRuleCond.getPSDEFID(), (String)this.getPSDEFValueRule().getPSDEField().getId(), (boolean)false) == 0 ? this.getPSDEFValueRule().getPSDEField() : this.getPSDEFValueRule().getPSDEField().getPSDataEntity().getPSDEField(this.psDEFValueRuleCond.getPSDEFID()));
        if (StringHelper.isNullOrEmpty((String)this.strDEFName)) {
            this.strDEFName = this.iPSDEField.getName();
        }
    }

    @Override
    public String getPSDEFId() {
        return this.iPSDEField.getId();
    }

    @Override
    public void fillRelatedPSDEFields(ArrayList<String> relatedPSDEFieldList) {
        if (!StringHelper.isNullOrEmpty((String)this.getPSDEFId())) {
            relatedPSDEFieldList.add(this.getPSDEFId());
        }
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u5bf9\u8c61", hideempty2=true)
    public IPSDEField getPSDEField() {
        return this.iPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u540d\u79f0", hideempty2=true, fields={"CUSTOMDEFNAME", "PSDEFID"})
    public String getDEFName() {
        return this.strDEFName;
    }

    @Override
    public String getCondOp() {
        return null;
    }
}

