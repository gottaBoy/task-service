/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDESysDataSyncAgentOutLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDELogicNodeImpl;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSSysDataSyncAgent;
import net.ibizsys.paas.util.StringHelper;

@PSModelPFIgnoreMeta
public class PSDESysDataSyncAgentOutLogicImpl
extends PSDELogicNodeImpl
implements IPSDESysDataSyncAgentOutLogic {
    private IPSSysDataSyncAgent iPSSysDataSyncAgent = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected int onCheck() throws Exception {
        this.getPSSysDataSyncAgent();
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6570\u636e\u540c\u6b65\u4ee3\u7406", hideempty=true, dumpref=true, ignorepf=true, fields={"PSSYSDATASYNCAGENTID"})
    public IPSSysDataSyncAgent getPSSysDataSyncAgent() throws Exception {
        if (this.iPSSysDataSyncAgent == null) {
            if (StringHelper.isNullOrEmpty((String)this.psDELogicNode.getPSSYSDATASYNCAGENTID())) {
                throw new Exception("\u672a\u6307\u5b9a\u7cfb\u7edf\u6570\u636e\u540c\u6b65\u4ee3\u7406");
            }
            this.iPSSysDataSyncAgent = this.getPSDELogic().getPSDataEntity().getPSSystem().getPSSysDataSyncAgent(this.psDELogicNode.getPSSYSDATASYNCAGENTID());
        }
        return this.iPSSysDataSyncAgent;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDELogic", fields={"DSTPSDLPARAMID"})
    public IPSDELogicParam getDstPSDELogicParam() throws Exception {
        return super.getDstPSDELogicParam();
    }
}

