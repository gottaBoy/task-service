/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Action;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEUserSysUpdateAction;
import SA.SRFDA.PS.Core.DataEntity.Action.PSDEActionImplBase;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public class PSDEUserSysUpdateActionImpl
extends PSDEActionImplBase
implements IPSDEUserSysUpdateAction {
    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getModelType() {
        return "PSDEACTION";
    }

    @Override
    protected String onCalcActionMode(String strPSDEActionName) throws Exception {
        return "UPDATE";
    }
}

