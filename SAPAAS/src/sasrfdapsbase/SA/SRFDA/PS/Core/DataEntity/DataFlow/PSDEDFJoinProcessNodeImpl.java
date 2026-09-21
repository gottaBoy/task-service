/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDFJoinGroupCond;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDFJoinProcessNode;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.PSDEDFJoinGroupCondImpl;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.PSDEDataFlowProcessNodeImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
@PSModelImplementMeta(implement="IPSDEDataFlowNode", typevalues={"DFJOINPROCESS"})
public class PSDEDFJoinProcessNodeImpl
extends PSDEDataFlowProcessNodeImpl
implements IPSDEDFJoinProcessNode {
    private static final Log log = LogFactory.getLog(PSDEDFJoinProcessNodeImpl.class);
    private String strJoinType = null;
    private IPSDEDFJoinGroupCond iPSDEDFJoinGroupCond = null;

    @Override
    protected void onInit() throws Exception {
        this.strJoinType = this.psDELogicNode.getPARAM1();
        if (!StringHelper.isNullOrEmpty((String)this.psDELogicNode.getPARAM5())) {
            ObjectNode objNode = (ObjectNode)JsonNodeHelper.fromString((String)this.psDELogicNode.getPARAM5());
            PSDEDFJoinGroupCondImpl psDEDFJoinGroupCondImpl = new PSDEDFJoinGroupCondImpl();
            psDEDFJoinGroupCondImpl.init(this.getDAGlobalHelper(), this, null, objNode);
            this.iPSDEDFJoinGroupCond = psDEDFJoinGroupCondImpl;
        }
        super.onInit();
    }

    @Override
    protected int onCheck() throws Exception {
        int nRet = 0;
        return nRet + super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u8fde\u63a5\u6a21\u5f0f", codelist="DEDataFlowJoinType", fields={"PARAM1"})
    public String getJoinType() {
        return this.strJoinType;
    }

    @Override
    @PSModelRTMeta(description="\u8fde\u63a5\u6a21\u578b", child=true, fields={"PARAM6"})
    public IPSDEDFJoinGroupCond getPSDEDFJoinGroupCond() {
        return this.iPSDEDFJoinGroupCond;
    }
}

