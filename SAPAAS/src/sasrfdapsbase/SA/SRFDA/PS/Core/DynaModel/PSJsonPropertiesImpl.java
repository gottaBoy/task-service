/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 */
package SA.SRFDA.PS.Core.DynaModel;

import SA.SRFDA.PS.Core.DynaModel.IPSJsonNodeOwner;
import SA.SRFDA.PS.Core.DynaModel.IPSJsonProperties;
import SA.SRFDA.PS.Core.DynaModel.IPSJsonProperty;
import SA.SRFDA.PS.Core.DynaModel.PSJsonNodesImpl;
import SA.SRFDA.PS.Core.DynaModel.PSJsonPropertyImpl;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class PSJsonPropertiesImpl
extends PSJsonNodesImpl<IPSJsonProperty>
implements IPSJsonProperties {
    @Override
    protected IPSJsonProperty getItem(String strName, JsonNode jsonNode) throws Exception {
        if (!(jsonNode instanceof ObjectNode)) {
            throw new Exception(String.format("\u8282\u70b9[%1$s]\u683c\u5f0f\u4e0d\u6b63\u786e", strName));
        }
        PSJsonPropertyImpl psJsonObjectPropertyImpl = new PSJsonPropertyImpl();
        psJsonObjectPropertyImpl.init(this.getDAGlobalHelper(), (IPSJsonNodeOwner)this, strName, jsonNode);
        return psJsonObjectPropertyImpl;
    }

    @Override
    public String getModelType() {
        return "PSJSONPROPERTIES$" + this.getPSJsonNodeOwner().getModelType();
    }
}

