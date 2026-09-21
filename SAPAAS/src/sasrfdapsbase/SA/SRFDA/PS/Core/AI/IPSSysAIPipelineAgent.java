/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.AI;

import SA.SRFDA.PS.Core.AI.IPSAIPipelineAgent;
import SA.SRFDA.PS.Core.AI.IPSSysAIFactoryObject;
import SA.SRFDA.PS.Core.AI.IPSSysAIPipelineJob;
import SA.SRFDA.PS.Core.AI.IPSSysAIPipelineWorker;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import java.util.Iterator;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="AI\u5de5\u5382\u751f\u4ea7\u7ebf\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysAIPipelineAgent")
public interface IPSSysAIPipelineAgent
extends IPSAIPipelineAgent,
IPSSysAIFactoryObject {
    public IPSDataEntity getPSDataEntity();

    public Iterator<? extends IPSSysAIPipelineJob> getAllPSSysAIPipelineJobs() throws Exception;

    public IPSSysAIPipelineJob getPSSysAIPipelineJob(String var1) throws Exception;

    public IPSSysAIPipelineJob getPSSysAIPipelineJob(String var1, boolean var2) throws Exception;

    public Iterator<? extends IPSSysAIPipelineWorker> getAllPSSysAIPipelineWorkers() throws Exception;

    public IPSSysAIPipelineWorker getPSSysAIPipelineWorker(String var1) throws Exception;

    public IPSSysAIPipelineWorker getPSSysAIPipelineWorker(String var1, boolean var2) throws Exception;

    public IPSSysSFPlugin getPSSysSFPlugin();
}

