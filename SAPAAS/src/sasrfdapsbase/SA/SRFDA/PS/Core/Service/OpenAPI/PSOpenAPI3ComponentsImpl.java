/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 */
package SA.SRFDA.PS.Core.Service.OpenAPI;

import SA.SRFDA.PS.Core.DynaModel.IPSJsonDefs;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Components;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3JsonNodeSchemas;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Parameters;
import SA.SRFDA.PS.Core.Service.OpenAPI.PSOpenAPI3JsonNodeSchemasImpl;
import SA.SRFDA.PS.Core.Service.OpenAPI.PSOpenAPI3ObjectImpl;
import SA.SRFDA.PS.Core.Service.OpenAPI.PSOpenAPI3ParametersImpl;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class PSOpenAPI3ComponentsImpl
extends PSOpenAPI3ObjectImpl
implements IPSOpenAPI3Components {
    private IPSOpenAPI3JsonNodeSchemas iPSOpenAPI3JsonNodeSchemas = null;
    private IPSOpenAPI3Parameters iPSOpenAPI3Parameters = null;

    @Override
    protected void onInit() throws Exception {
        JsonNode jsonNode;
        if (this.getObjectNode().has("schemas")) {
            jsonNode = this.getObjectNode().get("schemas");
            if (jsonNode instanceof ObjectNode) {
                this.setPSOpenAPI3JsonNodeSchemas(this.getPSOpenAPI3JsonNodeSchemas("schemas", (ObjectNode)jsonNode));
            } else {
                throw new Exception(String.format("\u8282\u70b9[%1$s]\u683c\u5f0f\u4e0d\u6b63\u786e", "schemas"));
            }
        }
        if (this.getObjectNode().has("parameters")) {
            jsonNode = this.getObjectNode().get("parameters");
            if (jsonNode instanceof ObjectNode) {
                this.setPSOpenAPI3Parameters(this.getPSOpenAPI3Parameters("parameters", (ObjectNode)jsonNode));
            } else {
                throw new Exception(String.format("\u8282\u70b9[%1$s]\u683c\u5f0f\u4e0d\u6b63\u786e", "parameters"));
            }
        }
        super.onInit();
    }

    protected IPSOpenAPI3JsonNodeSchemas getPSOpenAPI3JsonNodeSchemas(String strName, ObjectNode data) throws Exception {
        PSOpenAPI3JsonNodeSchemasImpl psOpenAPI3JsonNodeSchemasImpl = new PSOpenAPI3JsonNodeSchemasImpl();
        psOpenAPI3JsonNodeSchemasImpl.init(this.getDAGlobalHelper(), this, "schemas", data);
        return psOpenAPI3JsonNodeSchemasImpl;
    }

    protected IPSOpenAPI3Parameters getPSOpenAPI3Parameters(String strName, ObjectNode data) throws Exception {
        PSOpenAPI3ParametersImpl psOpenAPI3ParametersImpl = new PSOpenAPI3ParametersImpl();
        psOpenAPI3ParametersImpl.init(this.getDAGlobalHelper(), this, "parameters", data);
        return psOpenAPI3ParametersImpl;
    }

    @Override
    @PSModelRTMeta(description="JsonNodeSchema\u96c6\u5408")
    public IPSOpenAPI3JsonNodeSchemas getPSOpenAPI3JsonNodeSchemas() {
        return this.iPSOpenAPI3JsonNodeSchemas;
    }

    protected void setPSOpenAPI3JsonNodeSchemas(IPSOpenAPI3JsonNodeSchemas iPSOpenAPI3JsonNodeSchemas) {
        this.iPSOpenAPI3JsonNodeSchemas = iPSOpenAPI3JsonNodeSchemas;
    }

    @Override
    @PSModelRTMeta(description="Parameter\u96c6\u5408")
    public IPSOpenAPI3Parameters getPSOpenAPI3Parameters() {
        return this.iPSOpenAPI3Parameters;
    }

    protected void setPSOpenAPI3Parameters(IPSOpenAPI3Parameters iPSOpenAPI3Parameters) {
        this.iPSOpenAPI3Parameters = iPSOpenAPI3Parameters;
    }

    @Override
    public String getModelType() {
        return "PSOPENAPI3COMPONENTS$" + this.getPSJsonNodeOwner().getModelType();
    }

    @Override
    public String getModelId() {
        return this.getPSJsonNodeOwner().getModelId();
    }

    @Override
    public IPSJsonDefs getPSJsonDefs() {
        return this.getPSOpenAPI3JsonNodeSchemas();
    }
}

