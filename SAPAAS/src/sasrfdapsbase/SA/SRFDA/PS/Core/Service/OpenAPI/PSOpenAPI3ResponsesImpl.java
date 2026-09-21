/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 */
package SA.SRFDA.PS.Core.Service.OpenAPI;

import SA.SRFDA.PS.Core.DynaModel.PSJsonNodesImpl;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Response;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Responses;
import SA.SRFDA.PS.Core.Service.OpenAPI.PSOpenAPI3ResponseImpl;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class PSOpenAPI3ResponsesImpl
extends PSJsonNodesImpl<IPSOpenAPI3Response>
implements IPSOpenAPI3Responses {
    @Override
    protected IPSOpenAPI3Response getItem(String strName, JsonNode jsonNode) throws Exception {
        if (!(jsonNode instanceof ObjectNode)) {
            throw new Exception(String.format("\u8282\u70b9[%1$s]\u683c\u5f0f\u4e0d\u6b63\u786e", strName));
        }
        ObjectNode objectNode = (ObjectNode)jsonNode;
        return this.getPSOpenAPI3Response(strName, objectNode);
    }

    protected IPSOpenAPI3Response getPSOpenAPI3Response(String strName, ObjectNode objData) throws Exception {
        PSOpenAPI3ResponseImpl psOpenAPI3ResponseImpl = new PSOpenAPI3ResponseImpl();
        psOpenAPI3ResponseImpl.init(this.getDAGlobalHelper(), this, strName, (JsonNode)objData);
        return psOpenAPI3ResponseImpl;
    }

    @Override
    public String getModelType() {
        return "PSOPENAPI3RESPONSES$" + this.getPSJsonNodeOwner().getModelType();
    }
}

