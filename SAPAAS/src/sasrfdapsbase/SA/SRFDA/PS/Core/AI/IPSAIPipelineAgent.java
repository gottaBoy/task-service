/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.AI;

import SA.SRFDA.PS.Core.AI.IPSAIFactoryObject;
import SA.SRFDA.PS.Core.AI.IPSAIPipelineJob;
import SA.SRFDA.PS.Core.AI.IPSAIPipelineWorker;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import java.util.Iterator;
import java.util.Properties;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="AI\u5de5\u5382\u751f\u4ea7\u7ebf\u4ee3\u7406\u5bf9\u8c61\u63a5\u53e3")
public interface IPSAIPipelineAgent
extends IPSAIFactoryObject {
    public String getAgentType();

    @Override
    public String getCodeName();

    public String getAgentTag();

    public String getAgentTag2();

    public Properties getAgentParams();

    public Iterator<? extends IPSAIPipelineJob> getAllPSAIPipelineJobs() throws Exception;

    public IPSAIPipelineJob getPSAIPipelineJob(String var1) throws Exception;

    public IPSAIPipelineJob getPSAIPipelineJob(String var1, boolean var2) throws Exception;

    public Iterator<? extends IPSAIPipelineWorker> getAllPSAIPipelineWorkers() throws Exception;

    public IPSAIPipelineWorker getPSAIPipelineWorker(String var1) throws Exception;

    public IPSAIPipelineWorker getPSAIPipelineWorker(String var1, boolean var2) throws Exception;

    public String getAIPlatformType();
}

