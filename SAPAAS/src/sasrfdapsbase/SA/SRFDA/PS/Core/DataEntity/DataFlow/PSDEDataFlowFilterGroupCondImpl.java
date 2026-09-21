/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowFilterCond;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowFilterGroupCond;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.PSDEDataFlowFilterCondImpl;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.PSDEDataFlowFilterSingleCondImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PSDEDataFlowFilterGroupCondImpl
extends PSDEDataFlowFilterCondImpl
implements IPSDEDataFlowFilterGroupCond {
    private String strCondOp = "AND";
    private boolean bNotMode = false;
    private List<IPSDEDataFlowFilterCond> psDEDFJoinCondList = new ArrayList<IPSDEDataFlowFilterCond>();

    @Override
    protected void onInit() throws Exception {
        JsonNode notNode;
        JsonNode opNode = this.objectNode.get("op");
        if (opNode != null) {
            this.strCondOp = opNode.asText();
        }
        if ((notNode = this.objectNode.get("not")) != null) {
            this.bNotMode = notNode.asBoolean(false);
        }
        super.onInit();
        this.onPreparePSDEDataFlowFilterConds();
    }

    protected void onPreparePSDEDataFlowFilterConds() throws Exception {
        JsonNode itemsNode = this.objectNode.get("items");
        if (!(itemsNode instanceof ArrayNode)) {
            return;
        }
        ArrayNode arrayNode = (ArrayNode)itemsNode;
        int i = 0;
        while (i < arrayNode.size()) {
            PSDEDataFlowFilterCondImpl item;
            JsonNode jsonNode = arrayNode.get(i);
            if (!(jsonNode instanceof ObjectNode)) {
                throw new Exception("\u6a21\u578b\u4e0d\u6b63\u786e");
            }
            ObjectNode objectNode = (ObjectNode)jsonNode;
            JsonNode typeJsonNode = objectNode.get("type");
            if (typeJsonNode == null) {
                throw new Exception("\u6a21\u578b\u4e0d\u6b63\u786e");
            }
            String strType = typeJsonNode.asText();
            if ("GROUP".equalsIgnoreCase(strType)) {
                item = new PSDEDataFlowFilterGroupCondImpl();
                item.init(this.getDAGlobalHelper(), this.getPSDEDataFlowFilterCondContainer(), this, objectNode);
                this.psDEDFJoinCondList.add(item);
            } else if ("SINGLE".equalsIgnoreCase(strType)) {
                item = new PSDEDataFlowFilterSingleCondImpl();
                item.init(this.getDAGlobalHelper(), this.getPSDEDataFlowFilterCondContainer(), this, objectNode);
                this.psDEDFJoinCondList.add(item);
            } else {
                throw new Exception(String.format("\u65e0\u6cd5\u8bc6\u522b\u7684\u6761\u4ef6\u7c7b\u578b[%1$s]", strType));
            }
            ++i;
        }
    }

    @Override
    @PSModelRTMeta(description="\u6761\u4ef6\u7c7b\u578b", codelist="DELogicLinkCondType")
    public String getCondType() {
        return "GROUP";
    }

    @Override
    @PSModelRTMeta(description="\u7ec4\u5408\u6761\u4ef6", codelist="GroupCond")
    public String getCondOp() {
        return this.strCondOp;
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u53d6\u53cd", ignoredumpvalues="false")
    public boolean isNotMode() {
        return this.bNotMode;
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u6761\u4ef6\u96c6\u5408", child=true)
    public Iterator<? extends IPSDEDataFlowFilterCond> getPSDEDataFlowFilterConds() {
        if (this.psDEDFJoinCondList == null || this.psDEDFJoinCondList.size() == 0) {
            return null;
        }
        return this.psDEDFJoinCondList.iterator();
    }
}

