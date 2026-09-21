/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.AI;

import SA.SRFDA.PS.Core.AI.IPSAIChatAgent;
import SA.SRFDA.PS.Core.AI.IPSSysAIFactoryObject;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="AI\u4ea4\u8c08\u4ee3\u7406\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysAIChatAgent")
public interface IPSSysAIChatAgent
extends IPSSysAIFactoryObject,
IPSAIChatAgent {
    public static final String AGENTTYPE_DEFAULT = "DEFAULT";
    public static final String AGENTTYPE_DE = "DE";

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSDataEntity getPSDataEntity();

    public IPSDELogic getPSDELogic();
}

