/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDFPredefinedSourceNode;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.PSDEDataFlowSourceNodeImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

@PSModelPFIgnoreMeta
@PSModelImplementMeta(implement="IPSDEDataFlowNode", typevalues={"DFPREDEFINEDSOURCE"})
public class PSDEDFPredefinedSourceNodeImpl
extends PSDEDataFlowSourceNodeImpl
implements IPSDEDFPredefinedSourceNode {
    private String strSubType = "SESSION";

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.psDELogicNode.getLOGICNODESUBTYPE())) {
            this.strSubType = this.psDELogicNode.getLOGICNODESUBTYPE();
        }
        super.onInit();
    }

    @Override
    protected int onCheck() throws Exception {
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u9884\u5b9a\u4e49\u7c7b\u578b", codelist="DEDataFlowPredefinedSourceType", hideempty=true, ignorepf=true, fields={"LOGICNODESUBTYPE"})
    public String getPredefinedType() {
        return this.strSubType;
    }
}

