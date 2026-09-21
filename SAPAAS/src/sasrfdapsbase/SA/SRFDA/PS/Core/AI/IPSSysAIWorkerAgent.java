/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.AI;

import SA.SRFDA.PS.Core.AI.IPSAIWorkerAgent;
import SA.SRFDA.PS.Core.AI.IPSSysAIFactoryObject;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="AI\u5de5\u4f5c\u8005\u4ee3\u7406\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysAIWorkerAgent")
public interface IPSSysAIWorkerAgent
extends IPSSysAIFactoryObject,
IPSAIWorkerAgent {
    public static final String AGENTTYPE_DEFAULT = "DEFAULT";
    public static final String AGENTTYPE_DE = "DE";

    public IPSDataEntity getPSDataEntity();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSDELogic getPSDELogic();
}

