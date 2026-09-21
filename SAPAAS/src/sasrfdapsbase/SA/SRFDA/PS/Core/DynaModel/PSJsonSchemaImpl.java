/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.ObjectMapper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DynaModel;

import SA.SRFDA.PS.Core.DynaModel.IPSJsonDefs;
import SA.SRFDA.PS.Core.DynaModel.IPSJsonNodeOwner;
import SA.SRFDA.PS.Core.DynaModel.IPSJsonNodeSchema;
import SA.SRFDA.PS.Core.DynaModel.IPSJsonNodeSchemaOwner;
import SA.SRFDA.PS.Core.DynaModel.IPSJsonObjectSchema;
import SA.SRFDA.PS.Core.DynaModel.IPSJsonProperties;
import SA.SRFDA.PS.Core.DynaModel.IPSJsonSchema;
import SA.SRFDA.PS.Core.DynaModel.PSJsonDefsImpl;
import SA.SRFDA.PS.Core.DynaModel.PSJsonObjectSchemaImpl;
import SA.SRFDA.PS.Core.DynaModel.PSSysDynaModelImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSSysDynaModelAttr;
import SA.SRFramework.DataEx.CallResult;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSJsonSchemaImpl
extends PSSysDynaModelImpl
implements IPSJsonSchema,
IPSJsonNodeSchemaOwner {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final Log log = LogFactory.getLog(PSJsonSchemaImpl.class);
    private IPSJsonObjectSchema iPSJsonObjectSchema = null;
    private String strSchemaId = null;
    private IPSJsonDefs iPSJsonDefs = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    protected void onPreparePSSysDynaModelAttrs() throws Exception {
        ObjectNode jsonNode;
        ObjectNode objectNode = null;
        objectNode = !StringHelper.isNullOrEmpty((String)this.getJOString()) ? (ObjectNode)MAPPER.readTree(this.getJOString()) : MAPPER.createObjectNode();
        if (objectNode.has("$id")) {
            this.setSchemaId(objectNode.get("$id").textValue());
        }
        if (objectNode.has("$defs")) {
            jsonNode = objectNode.get("$defs");
            if (!(jsonNode instanceof ObjectNode)) throw new Exception(String.format("\u8282\u70b9[%1$s]\u683c\u5f0f\u4e0d\u6b63\u786e", "$defs"));
            this.setPSJsonDefs(this.getPSJsonDefs("$defs", jsonNode));
        } else {
            jsonNode = MAPPER.createObjectNode();
            this.setPSJsonDefs(this.getPSJsonDefs("$defs", jsonNode));
        }
        Vector<PSSysDynaModelAttr> psSysDynaModelAttrList = new Vector<PSSysDynaModelAttr>();
        CallResult callResult = this.getPSModelHelper().getPSSysDynaModelAttrs(this.getId(), psSysDynaModelAttrList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u7cfb\u7edf\u52a8\u6001\u6a21\u578b\u5c5e\u6027\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        PSJsonObjectSchemaImpl psJsonObjectSchemaImpl = new PSJsonObjectSchemaImpl();
        psJsonObjectSchemaImpl.init(this.getDAGlobalHelper(), this, "Root", objectNode, psSysDynaModelAttrList);
        this.setPSJsonObjectSchema(psJsonObjectSchemaImpl);
    }

    public IPSJsonObjectSchema getPSJsonObjectSchema() {
        return this.iPSJsonObjectSchema;
    }

    protected void setPSJsonObjectSchema(IPSJsonObjectSchema iPSJsonObjectSchema) {
        this.iPSJsonObjectSchema = iPSJsonObjectSchema;
    }

    @Override
    @PSModelRTMeta(description="JsonSchema\u6807\u8bc6")
    public String getSchemaId() {
        return this.strSchemaId;
    }

    protected void setSchemaId(String strSchemaId) {
        this.strSchemaId = strSchemaId;
    }

    protected IPSJsonDefs getPSJsonDefs(String strName, ObjectNode objectNode) throws Exception {
        PSJsonDefsImpl psJsonDefsImpl = new PSJsonDefsImpl();
        psJsonDefsImpl.init(this.getDAGlobalHelper(), this, strName, objectNode);
        return psJsonDefsImpl;
    }

    @Override
    @PSModelRTMeta(description="JsonDefs")
    public IPSJsonDefs getPSJsonDefs() {
        return this.iPSJsonDefs;
    }

    protected void setPSJsonDefs(IPSJsonDefs iPSJsonDefs) {
        this.iPSJsonDefs = iPSJsonDefs;
    }

    @Override
    public String getModelType() {
        return "PSJSONSCHEMA";
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u96c6\u5408")
    public IPSJsonProperties getPSJsonProperties() {
        return this.getPSJsonObjectSchema().getPSJsonProperties();
    }

    @Override
    @PSModelRTMeta(description="\u5fc5\u987b\u5c5e\u6027\u96c6\u5408")
    public Iterator<String> getRequired() {
        return this.getPSJsonObjectSchema().getRequired();
    }

    @Override
    public String getType() {
        return this.getPSJsonObjectSchema().getType();
    }

    @Override
    @PSModelRTMeta(description="\u63cf\u8ff0")
    public String getDescription() {
        return this.getPSJsonObjectSchema().getDescription();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u6269\u5c55\u5c5e\u6027")
    public boolean isEnableAdditionalProperties() {
        return this.getPSJsonObjectSchema().isEnableAdditionalProperties();
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u5c5e\u6027\u7c7b\u578b")
    public IPSJsonNodeSchema getAdditionalPSJsonNodeSchema() {
        return this.getPSJsonObjectSchema().getAdditionalPSJsonNodeSchema();
    }

    @Override
    public IPSJsonNodeSchema getPSJsonNodeSchema() {
        return this.getPSJsonObjectSchema();
    }

    @Override
    public IPSJsonNodeOwner getPSJsonNodeOwner() {
        return null;
    }

    @Override
    public IPSJsonNodeSchema getRefPSJsonNodeSchema() throws Exception {
        return this.getPSJsonObjectSchema().getRefPSJsonNodeSchema();
    }

    @Override
    public boolean isRefMode() {
        return this.getPSJsonObjectSchema().isRefMode();
    }

    @Override
    public String getRefSchemaId() {
        return this.getPSJsonObjectSchema().getRefSchemaId();
    }

    @Override
    public JsonNode getJsonNode() {
        if (this.getPSJsonObjectSchema() != null) {
            return this.getPSJsonObjectSchema().getJsonNode();
        }
        return null;
    }
}

