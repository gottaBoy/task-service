/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.AI;

import SA.SRFDA.PS.Core.AI.IPSAIPipelineObject;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="AI\u5de5\u5382\u751f\u4ea7\u7ebf\u4f5c\u4e1a\u5bf9\u8c61\u63a5\u53e3")
public interface IPSAIPipelineJob
extends IPSAIPipelineObject {
    public IPSCodeList getStepPSCodeList();
}

