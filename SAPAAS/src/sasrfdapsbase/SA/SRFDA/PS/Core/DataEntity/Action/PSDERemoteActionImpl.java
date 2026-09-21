/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Action;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDERemoteAction;
import SA.SRFDA.PS.Core.DataEntity.Action.PSDEActionImplBase;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDEMethod;
import net.ibizsys.paas.util.StringHelper;

@PSModelPFIgnoreMeta
public class PSDERemoteActionImpl
extends PSDEActionImplBase
implements IPSDERemoteAction {
    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getModelType() {
        return "PSDEACTION";
    }

    @Override
    @PSModelRTMeta(description="\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u65b9\u6cd5", hideempty=true, dumpref=true, dynamodelmode=4, from="IPSDataEntity", from_method="getPSSubSysServiceAPIDEMust().getPSSubSysServiceAPIDEMethod", fields={"PSSUBSYSSADETAILID"})
    public IPSSubSysServiceAPIDEMethod getPSSubSysServiceAPIDEMethod() throws Exception {
        return super.getPSSubSysServiceAPIDEMethod();
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

