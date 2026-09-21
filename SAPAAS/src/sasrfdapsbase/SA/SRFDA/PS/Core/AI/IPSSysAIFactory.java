/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.AI;

import SA.SRFDA.PS.Core.AI.IPSAIFactory;
import SA.SRFDA.PS.Core.AI.IPSSysAIChatAgent;
import SA.SRFDA.PS.Core.AI.IPSSysAIPipelineAgent;
import SA.SRFDA.PS.Core.AI.IPSSysAIWorkerAgent;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.Res.IPSSysResource;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIBase;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import java.util.Iterator;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="AI\u5de5\u5382\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysAIFactory")
public interface IPSSysAIFactory
extends IPSAIFactory,
IPSSystemObject,
IPSSysSFPubObject,
IPSSubSysServiceAPIBase {
    public Iterator<? extends IPSSysAIChatAgent> getAllPSSysAIChatAgents() throws Exception;

    public IPSSysAIChatAgent getPSSysAIChatAgent(String var1) throws Exception;

    public IPSSysAIChatAgent getPSSysAIChatAgent(String var1, boolean var2) throws Exception;

    public Iterator<? extends IPSSysAIWorkerAgent> getAllPSSysAIWorkerAgents() throws Exception;

    public IPSSysAIWorkerAgent getPSSysAIWorkerAgent(String var1) throws Exception;

    public IPSSysAIWorkerAgent getPSSysAIWorkerAgent(String var1, boolean var2) throws Exception;

    public Iterator<? extends IPSSysAIPipelineAgent> getAllPSSysAIPipelineAgents() throws Exception;

    public IPSSysAIPipelineAgent getPSSysAIPipelineAgent(String var1) throws Exception;

    public IPSSysAIPipelineAgent getPSSysAIPipelineAgent(String var1, boolean var2) throws Exception;

    public IPSSystemModule getPSSystemModule();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSSFXCodeObject getRender();

    public IPSSysResource getPSSysResource();
}

