/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 */
package SA.SRFDA.PS.Core.Service.OpenAPI;

import SA.SRFDA.PS.Core.DynaModel.PSJsonNodesImpl;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3MediaType;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3MediaTypes;
import SA.SRFDA.PS.Core.Service.OpenAPI.PSOpenAPI3MediaTypeImpl;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class PSOpenAPI3MediaTypesImpl
extends PSJsonNodesImpl<IPSOpenAPI3MediaType>
implements IPSOpenAPI3MediaTypes {
    @Override
    protected IPSOpenAPI3MediaType getItem(String strName, JsonNode jsonNode) throws Exception {
        if (!(jsonNode instanceof ObjectNode)) {
            throw new Exception(String.format("\u8282\u70b9[%1$s]\u683c\u5f0f\u4e0d\u6b63\u786e", strName));
        }
        ObjectNode objectNode = (ObjectNode)jsonNode;
        return this.getPSOpenAPI3MediaType(strName, objectNode);
    }

    protected IPSOpenAPI3MediaType getPSOpenAPI3MediaType(String strName, ObjectNode objData) throws Exception {
        PSOpenAPI3MediaTypeImpl psOpenAPI3MediaTypeImpl = new PSOpenAPI3MediaTypeImpl();
        psOpenAPI3MediaTypeImpl.init(this.getDAGlobalHelper(), this, strName, (JsonNode)objData);
        return psOpenAPI3MediaTypeImpl;
    }

    @Override
    public String getModelType() {
        return "PSOPENAPI3MEDIATYPES$" + this.getPSJsonNodeOwner().getModelType();
    }
}

