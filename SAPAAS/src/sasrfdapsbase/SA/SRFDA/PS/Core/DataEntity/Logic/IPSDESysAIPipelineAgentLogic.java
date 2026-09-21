/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.AI.IPSSysAIFactory;
import SA.SRFDA.PS.Core.AI.IPSSysAIPipelineAgent;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNode;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParam;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelExtendMeta(title="\u5b9e\u4f53\u5904\u7406\u903b\u8f91AI\u751f\u4ea7\u7ebf\u4ee3\u7406\u8c03\u7528\u8282\u70b9\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"SYSAIPIPELINEAGENT"})
@PSModelPFIgnoreMeta
public interface IPSDESysAIPipelineAgentLogic
extends IPSDELogicNode {
    public IPSSysAIFactory getPSSysAIFactory() throws Exception;

    public IPSSysAIPipelineAgent getPSSysAIPipelineAgent() throws Exception;

    public IPSDELogicParam getDstPSDELogicParam() throws Exception;

    public IPSDELogicParam getRetPSDELogicParam() throws Exception;
}

