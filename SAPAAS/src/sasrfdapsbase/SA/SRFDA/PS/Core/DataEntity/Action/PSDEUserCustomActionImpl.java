/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Action;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEUserCustomAction;
import SA.SRFDA.PS.Core.DataEntity.Action.PSDEActionImplBase;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

public class PSDEUserCustomActionImpl
extends PSDEActionImplBase
implements IPSDEUserCustomAction {
    private IPSDEDataSet iPSDEDataSet = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected int onCheck() throws Exception {
        this.getPSDEDataSet();
        return super.onCheck();
    }

    @Override
    public String getModelType() {
        return "PSDEACTION";
    }

    @Override
    protected String onCalcActionMode(String strPSDEActionName) throws Exception {
        String strActionMode = super.onCalcActionMode(strPSDEActionName);
        if (this.getPSSystem().isEnableModelRT() && StringHelper.compare((String)strActionMode, (String)"UNKNOWN", (boolean)false) == 0) {
            return "CUSTOM";
        }
        return strActionMode;
    }

    @Override
    @PSModelRTMeta(description="\u76f8\u5173\u5b9e\u4f53\u6570\u636e\u96c6", ignorepf=true, dumpref=true, from="IPSDataEntity", fields={"PSDEDATASETID"})
    public IPSDEDataSet getPSDEDataSet() throws Exception {
        if (this.iPSDEDataSet == null && !StringHelper.isNullOrEmpty((String)this.psDEAction.getPSDEDATASETID())) {
            this.iPSDEDataSet = this.getPSDataEntity().getPSDEDataSet(this.psDEAction.getPSDEDATASETID());
        }
        return this.iPSDEDataSet;
    }
}

