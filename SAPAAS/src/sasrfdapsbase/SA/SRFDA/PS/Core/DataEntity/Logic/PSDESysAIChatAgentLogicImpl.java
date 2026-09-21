/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.AI.IPSSysAIChatAgent;
import SA.SRFDA.PS.Core.AI.IPSSysAIFactory;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDESysAIChatAgentLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDELogicNodeImpl;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

@PSModelPFIgnoreMeta
public class PSDESysAIChatAgentLogicImpl
extends PSDELogicNodeImpl
implements IPSDESysAIChatAgentLogic {
    private IPSSysAIFactory iPSSysAIFactory = null;
    private IPSSysAIChatAgent iPSSysAIChatAgent = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected int onCheck() throws Exception {
        this.getPSSysAIFactory();
        this.getPSSysAIChatAgent();
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="AI\u5de5\u5382", hideempty=true, dumpref=true, ignorepf=true, fields={"PSSYSAIFACTORYID"})
    public IPSSysAIFactory getPSSysAIFactory() throws Exception {
        if (this.iPSSysAIFactory == null) {
            if (StringHelper.isNullOrEmpty((String)this.psDELogicNode.getPSSYSAIFACTORYID())) {
                throw new Exception("\u672a\u6307\u5b9aAI\u5de5\u5382");
            }
            this.iPSSysAIFactory = this.getPSDELogic().getPSDataEntity().getPSSystem().getPSSysAIFactory(this.psDELogicNode.getPSSYSAIFACTORYID());
        }
        return this.iPSSysAIFactory;
    }

    @Override
    @PSModelRTMeta(description="AI\u4ea4\u8c08\u4ee3\u7406", hideempty=true, dumpref=true, ignorepf=true, from="IPSSysAIFactory", fields={"PSSYSAICHATAGENTID"})
    public IPSSysAIChatAgent getPSSysAIChatAgent() throws Exception {
        if (this.iPSSysAIChatAgent == null) {
            if (StringHelper.isNullOrEmpty((String)this.psDELogicNode.getPSSYSAICHATAGENTID())) {
                throw new Exception("\u672a\u6307\u5b9aAI\u4ea4\u8c08\u4ee3\u7406");
            }
            this.iPSSysAIChatAgent = this.getPSSysAIFactory().getPSSysAIChatAgent(this.psDELogicNode.getPSSYSAICHATAGENTID(), false);
        }
        return this.iPSSysAIChatAgent;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDELogic", fields={"DSTPSDLPARAMID"})
    public IPSDELogicParam getDstPSDELogicParam() throws Exception {
        return super.getDstPSDELogicParam();
    }

    @Override
    @PSModelRTMeta(description="\u8fd4\u56de\u503c\u7ed1\u5b9a\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDELogic", fields={"RETPSDLPARAMID"})
    public IPSDELogicParam getRetPSDELogicParam() throws Exception {
        return super.getRetPSDELogicParam();
    }
}

