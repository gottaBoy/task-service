/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.AI;

import SA.SRFDA.PS.Core.AI.IPSAIPipelineWorker;
import SA.SRFDA.PS.Core.AI.IPSSysAIPipelineObject;
import SA.SRFDA.PS.Core.AI.IPSSysAIWorkerAgent;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="AI\u5de5\u5382\u751f\u4ea7\u7ebf\u5de5\u4f5c\u8005\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysAIPipelineWorker")
public interface IPSSysAIPipelineWorker
extends IPSAIPipelineWorker,
IPSSysAIPipelineObject {
    public IPSSysAIWorkerAgent getPSSysAIWorkerAgent();
}

