/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDFSysDataSyncAgentSinkNode;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.PSDEDataFlowSinkNodeImpl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSSysDataSyncAgent;
import net.ibizsys.paas.util.StringHelper;

@PSModelPFIgnoreMeta
@PSModelImplementMeta(implement="IPSDEDataFlowNode", typevalues={"DFSYSDATASYNCAGENTSINK"})
public class PSDEDFSysDataSyncAgentSinkNodeImpl
extends PSDEDataFlowSinkNodeImpl
implements IPSDEDFSysDataSyncAgentSinkNode {
    private IPSSysDataSyncAgent iPSSysDataSyncAgent = null;
    private String strSubType = "RAW";
    private IPSDataEntity dstPSDataEntity = null;

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
        this.getDstPSDataEntity();
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u7c7b\u578b", hideempty=true, codelist="DEDataFlowSysDataSyncAgentSinkType", ignoredumpvalues="RAW", fields={"LOGICNODESUBTYPE"})
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

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5b9e\u4f53\u5bf9\u8c61", hideempty=true, dumpref=true, ignorepf=true, fields={"DSTPSDEID"})
    public IPSDataEntity getDstPSDataEntity() throws Exception {
        if (StringHelper.compare((String)this.getSubType(), (String)"DEDATASYNC", (boolean)false) == 0) {
            if (this.dstPSDataEntity == null) {
                if (StringHelper.isNullOrEmpty((String)this.psDELogicNode.getDSTPSDEID())) {
                    throw new Exception("\u672a\u6307\u5b9a\u76ee\u6807\u5b9e\u4f53\u6807\u8bc6");
                }
                this.dstPSDataEntity = this.getPSSystem().getPSDataEntity2(this.psDELogicNode.getDSTPSDEID());
            }
            return this.dstPSDataEntity;
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u4e8b\u4ef6\u7c7b\u578b", codelist="DataSyncInformType", ignoredumpvalues="0", fields={"PARAM7"})
    public int getEventType() {
        if (StringHelper.compare((String)this.getSubType(), (String)"DEDATASYNC", (boolean)false) == 0) {
            return this.psDELogicNode.getPARAM7();
        }
        return 0;
    }
}

