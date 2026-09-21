/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 */
package SA.SRFDA.PS.Core.Service.OpenAPI;

import SA.SRFDA.PS.Core.DynaModel.PSJsonNodesImpl;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Parameter;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Parameters;
import SA.SRFDA.PS.Core.Service.OpenAPI.PSOpenAPI3ParameterImpl;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class PSOpenAPI3ParametersImpl
extends PSJsonNodesImpl<IPSOpenAPI3Parameter>
implements IPSOpenAPI3Parameters {
    @Override
    protected IPSOpenAPI3Parameter getItem(String strName, JsonNode jsonNode) throws Exception {
        if (!(jsonNode instanceof ObjectNode)) {
            throw new Exception(String.format("\u8282\u70b9[%1$s]\u683c\u5f0f\u4e0d\u6b63\u786e", strName));
        }
        ObjectNode objectNode = (ObjectNode)jsonNode;
        return this.getPSOpenAPI3Parameter(strName, objectNode);
    }

    protected IPSOpenAPI3Parameter getPSOpenAPI3Parameter(String strName, ObjectNode objData) throws Exception {
        PSOpenAPI3ParameterImpl psOpenAPI3ParameterImpl = new PSOpenAPI3ParameterImpl();
        psOpenAPI3ParameterImpl.init(this.getDAGlobalHelper(), this, strName, (JsonNode)objData);
        return psOpenAPI3ParameterImpl;
    }

    @Override
    public String getModelType() {
        return "PSOPENAPI3PARAMETERS$" + this.getPSJsonNodeOwner().getModelType();
    }
}

