/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.AI;

import SA.SRFDA.PS.Core.AI.IPSAIFactoryObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import java.util.Properties;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="AI\u4ea4\u8c08\u4ee3\u7406\u5bf9\u8c61\u63a5\u53e3")
public interface IPSAIChatAgent
extends IPSAIFactoryObject {
    public String getAgentType();

    @Override
    public String getCodeName();

    public String getAgentTag();

    public String getAgentTag2();

    public Properties getAgentParams();

    public String getAIPlatformType();
}

