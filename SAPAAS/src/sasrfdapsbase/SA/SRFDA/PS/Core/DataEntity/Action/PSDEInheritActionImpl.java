/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Action;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEInheritAction;
import SA.SRFDA.PS.Core.DataEntity.Action.PSDEActionImplBase;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import net.ibizsys.paas.util.StringHelper;

@PSModelPFIgnoreMeta
public class PSDEInheritActionImpl
extends PSDEActionImplBase
implements IPSDEInheritAction {
    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public IPSDERBase getPSDER() throws Exception {
        return null;
    }

    @Override
    public IPSDEAction getInheritPSDEAction() throws Exception {
        return super.getInheritPSDEAction();
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
}

