/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 */
package SA.SRFDA.PS.Core.Service.OpenAPI;

import SA.SRFDA.PS.Core.DynaModel.IPSJsonNodeSchema;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3MediaType;
import SA.SRFDA.PS.Core.Service.OpenAPI.PSOpenAPI3ObjectImpl;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class PSOpenAPI3MediaTypeImpl
extends PSOpenAPI3ObjectImpl
implements IPSOpenAPI3MediaType {
    private IPSJsonNodeSchema iPSJsonNodeSchema = null;

    @Override
    protected void onInit() throws Exception {
        if (this.getObjectNode().has("schema")) {
            JsonNode jsonNode = this.getObjectNode().get("schema");
            if (jsonNode instanceof ObjectNode) {
                this.setPSJsonNodeSchema(this.getPSJsonNodeSchema("schema", (ObjectNode)jsonNode));
            } else {
                throw new Exception(String.format("\u8282\u70b9[%1$s]\u683c\u5f0f\u4e0d\u6b63\u786e", "schema"));
            }
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u7c7b\u578b")
    public IPSJsonNodeSchema getPSJsonNodeSchema() {
        return this.iPSJsonNodeSchema;
    }

    protected void setPSJsonNodeSchema(IPSJsonNodeSchema iPSJsonNodeSchema) {
        this.iPSJsonNodeSchema = iPSJsonNodeSchema;
    }

    @Override
    public String getModelType() {
        return "PSOPENAPI3MEDIATYPE$" + this.getPSJsonNodeOwner().getModelType();
    }
}

