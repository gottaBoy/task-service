/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.AI;

import SA.SRFDA.PS.Core.AI.IPSAIChatAgent;
import SA.SRFDA.PS.Core.AI.IPSAIPipelineAgent;
import SA.SRFDA.PS.Core.AI.IPSAIWorkerAgent;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import java.util.Iterator;
import java.util.Properties;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="AI\u5de5\u5382\u5bf9\u8c61\u63a5\u53e3")
public interface IPSAIFactory
extends IPSModelObject {
    @Override
    public String getCodeName();

    public String getAIFactoryType();

    public Iterator<? extends IPSAIChatAgent> getAllPSAIChatAgents() throws Exception;

    public IPSAIChatAgent getPSAIChatAgent(String var1) throws Exception;

    public IPSAIChatAgent getPSAIChatAgent(String var1, boolean var2) throws Exception;

    public Iterator<? extends IPSAIWorkerAgent> getAllPSAIWorkerAgents() throws Exception;

    public IPSAIWorkerAgent getPSAIWorkerAgent(String var1) throws Exception;

    public IPSAIWorkerAgent getPSAIWorkerAgent(String var1, boolean var2) throws Exception;

    public Iterator<? extends IPSAIPipelineAgent> getAllPSAIPipelineAgents() throws Exception;

    public IPSAIPipelineAgent getPSAIPipelineAgent(String var1) throws Exception;

    public IPSAIPipelineAgent getPSAIPipelineAgent(String var1, boolean var2) throws Exception;

    public String getAIFactoryTag();

    public String getAIFactoryTag2();

    public Properties getAIFactoryParams();

    public String getAIPlatformType();
}

