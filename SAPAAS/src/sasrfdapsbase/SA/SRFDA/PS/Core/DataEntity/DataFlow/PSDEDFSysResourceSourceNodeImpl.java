/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDFSysResourceSourceNode;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.PSDEDataFlowSourceNodeImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSSysResource;
import net.ibizsys.paas.util.StringHelper;

@PSModelPFIgnoreMeta
@PSModelImplementMeta(implement="IPSDEDataFlowNode", typevalues={"DFSYSRESOURCESOURCE"})
public class PSDEDFSysResourceSourceNodeImpl
extends PSDEDataFlowSourceNodeImpl
implements IPSDEDFSysResourceSourceNode {
    private IPSSysResource iPSSysResource = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected int onCheck() throws Exception {
        this.getPSSysResource();
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u9884\u7f6e\u8d44\u6e90", hideempty=true, dumpref=true, ignorepf=true, fields={"PSSYSRESOURCEID"})
    public IPSSysResource getPSSysResource() throws Exception {
        if (this.iPSSysResource == null) {
            if (StringHelper.isNullOrEmpty((String)this.psDELogicNode.getPSSYSRESOURCEID())) {
                throw new Exception("\u672a\u6307\u5b9a\u7cfb\u7edf\u9884\u7f6e\u8d44\u6e90");
            }
            this.iPSSysResource = this.getPSDEDataFlow().getPSDataEntity().getPSSystem().getPSSysResource(this.psDELogicNode.getPSSYSRESOURCEID());
        }
        return this.iPSSysResource;
    }
}

