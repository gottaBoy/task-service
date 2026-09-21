/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowFilterSingleCond;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.PSDEDataFlowFilterCondImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import com.fasterxml.jackson.databind.JsonNode;

public class PSDEDataFlowFilterSingleCondImpl
extends PSDEDataFlowFilterCondImpl
implements IPSDEDataFlowFilterSingleCond {
    private String strCondOp = "EQ";
    private String strFilterFieldScope = null;
    private String strFilterFieldName = null;
    private String strCondValueType = null;
    private String strCondValue = null;
    private int nStdDataType = 0;

    @Override
    protected void onInit() throws Exception {
        JsonNode dataTypeNode;
        JsonNode valueNode;
        JsonNode valueTypeNode;
        JsonNode fieldNode;
        JsonNode fieldScopeNode;
        JsonNode opNode = this.objectNode.get("op");
        if (opNode != null) {
            this.strCondOp = opNode.asText();
        }
        if ((fieldScopeNode = this.objectNode.get("fieldscope")) != null) {
            this.strFilterFieldScope = fieldScopeNode.asText();
        }
        if ((fieldNode = this.objectNode.get("field")) != null) {
            this.strFilterFieldName = fieldNode.asText();
        }
        if ((valueTypeNode = this.objectNode.get("valuetype")) != null) {
            this.strCondValueType = valueTypeNode.asText();
        }
        if ((valueNode = this.objectNode.get("value")) != null) {
            this.strCondValue = valueNode.asText();
        }
        if ((dataTypeNode = this.objectNode.get("datatype")) != null) {
            this.nStdDataType = valueNode.asInt();
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u6761\u4ef6\u7c7b\u578b", codelist="DELogicLinkCondType")
    public String getCondType() {
        return "SINGLE";
    }

    @Override
    @PSModelRTMeta(description="\u6761\u4ef6")
    public String getCondOp() {
        return this.strCondOp;
    }

    @Override
    @PSModelRTMeta(description="\u8fc7\u6ee4\u5c5e\u6027\u5f52\u5c5e", codelist="DEDataFlowFieldScope", ignoredumpvalues="DATASTREAM")
    public String getFilterFieldScope() {
        return this.strFilterFieldScope;
    }

    @Override
    @PSModelRTMeta(description="\u8fc7\u6ee4\u5c5e\u6027\u540d\u79f0")
    public String getFilterField() {
        return this.strFilterFieldName;
    }

    @Override
    @PSModelRTMeta(description="\u6761\u4ef6\u503c\u7c7b\u578b", codelist="DEDataFlowCondValueType")
    public String getCondValueType() {
        return this.strCondValueType;
    }

    @Override
    @PSModelRTMeta(description="\u6761\u4ef6\u503c")
    public String getCondValue() {
        return this.strCondValue;
    }

    @Override
    @PSModelRTMeta(description="\u7b80\u5355\u6570\u636e\u7c7b\u578b", codelist="StdDataType", ignoredumpvalues="0")
    public int getStdDataType() {
        return this.nStdDataType;
    }
}

