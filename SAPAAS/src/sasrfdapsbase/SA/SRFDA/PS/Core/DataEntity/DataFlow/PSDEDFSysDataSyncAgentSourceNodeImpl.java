/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDFSysDataSyncAgentSourceNode;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.PSDEDataFlowSourceNodeImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSSysDataSyncAgent;
import net.ibizsys.paas.util.StringHelper;

@PSModelPFIgnoreMeta
@PSModelImplementMeta(implement="IPSDEDataFlowNode", typevalues={"DFSYSDATASYNCAGENTSOURCE"})
public class PSDEDFSysDataSyncAgentSourceNodeImpl
extends PSDEDataFlowSourceNodeImpl
implements IPSDEDFSysDataSyncAgentSourceNode {
    private IPSSysDataSyncAgent iPSSysDataSyncAgent = null;
    private String strSubType = "RAW";

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.psDELogicNode.getLOGICNODESUBTYPE())) {
            this.strSubType = this.psDELogicNode.getLOGICNODESUBTYPE();
        }
        super.onInit();
    }

    @Override
    protected int onCheck() throws Exception {
        this.getPSSysDataSyncAgent();
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u7c7b\u578b", hideempty=true, codelist="DEDataFlowSysDataSyncAgentSourceType", ignoredumpvalues="RAW", fields={"LOGICNODESUBTYPE"})
    public String getSubType() {
        return this.strSubType;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6570\u636e\u540c\u6b65\u4ee3\u7406", hideempty=true, dumpref=true, ignorepf=true, fields={"PSSYSDATASYNCAGENTID"})
    public IPSSysDataSyncAgent getPSSysDataSyncAgent() throws Exception {
        if (this.iPSSysDataSyncAgent == null) {
            if (StringHelper.isNullOrEmpty((String)this.psDELogicNode.getPSSYSDATASYNCAGENTID())) {
                throw new Exception("\u672a\u6307\u5b9a\u7cfb\u7edf\u6570\u636e\u540c\u6b65\u4ee3\u7406");
            }
            this.iPSSysDataSyncAgent = this.getPSDEDataFlow().getPSDataEntity().getPSSystem().getPSSysDataSyncAgent(this.psDELogicNode.getPSSYSDATASYNCAGENTID());
        }
        return this.iPSSysDataSyncAgent;
    }
}

