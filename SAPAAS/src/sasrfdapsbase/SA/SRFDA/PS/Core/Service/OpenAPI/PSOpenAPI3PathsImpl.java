/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 */
package SA.SRFDA.PS.Core.Service.OpenAPI;

import SA.SRFDA.PS.Core.DynaModel.PSJsonNodesImpl;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Path;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Paths;
import SA.SRFDA.PS.Core.Service.OpenAPI.PSOpenAPI3PathImpl;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class PSOpenAPI3PathsImpl
extends PSJsonNodesImpl<IPSOpenAPI3Path>
implements IPSOpenAPI3Paths {
    @Override
    protected IPSOpenAPI3Path getItem(String strName, JsonNode jsonNode) throws Exception {
        if (!(jsonNode instanceof ObjectNode)) {
            throw new Exception(String.format("\u8282\u70b9[%1$s]\u683c\u5f0f\u4e0d\u6b63\u786e", strName));
        }
        ObjectNode objectNode = (ObjectNode)jsonNode;
        return this.getPSOpenAPI3Path(strName, objectNode);
    }

    protected IPSOpenAPI3Path getPSOpenAPI3Path(String strName, ObjectNode objData) throws Exception {
        PSOpenAPI3PathImpl psOpenAPI3PathImpl = new PSOpenAPI3PathImpl();
        psOpenAPI3PathImpl.init(this.getDAGlobalHelper(), this, strName, (JsonNode)objData);
        return psOpenAPI3PathImpl;
    }

    @Override
    public String getModelType() {
        return "PSOPENAPI3PATHS$" + this.getPSJsonNodeOwner().getModelType();
    }
}

