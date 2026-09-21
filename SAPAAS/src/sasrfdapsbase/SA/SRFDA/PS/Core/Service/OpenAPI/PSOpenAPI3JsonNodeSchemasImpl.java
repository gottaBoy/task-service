/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Service.OpenAPI;

import SA.SRFDA.PS.Core.DynaModel.IPSJsonNodeSchema;
import SA.SRFDA.PS.Core.DynaModel.IPSJsonSchema;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.DynaModel.PSJsonNodeSchemaHelper;
import SA.SRFDA.PS.Core.DynaModel.PSJsonNodesImpl;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3JsonNodeSchemas;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;

public class PSOpenAPI3JsonNodeSchemasImpl
extends PSJsonNodesImpl<IPSJsonNodeSchema>
implements IPSOpenAPI3JsonNodeSchemas {
    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected IPSJsonNodeSchema getItem(String strName, JsonNode jsonNode) throws Exception {
        if (!(jsonNode instanceof ObjectNode)) {
            throw new Exception(String.format("\u8282\u70b9[%1$s]\u683c\u5f0f\u4e0d\u6b63\u786e", strName));
        }
        ObjectNode objectNode = (ObjectNode)jsonNode;
        return this.getPSJsonNodeSchema(strName, objectNode);
    }

    protected IPSJsonNodeSchema getPSJsonNodeSchema(String strName, ObjectNode objData) throws Exception {
        return PSJsonNodeSchemaHelper.getInstance().getPSJsonNodeSchema(this, strName, objData);
    }

    @Override
    public String getModelType() {
        return "PSOPENAPI3JSONNODESCHEMAS$" + this.getPSJsonNodeOwner().getModelType();
    }

    @Override
    public IPSJsonNodeSchema getItem(String strName, boolean bTryMode) throws Exception {
        Iterator<IPSSysDynaModel> psSysDynaModels;
        if (strName.indexOf("#/components/schemas/") == 0) {
            String strPartName = strName.substring("#/components/schemas/".length());
            Iterator<String> names = this.getItemNames();
            if (names != null) {
                while (names.hasNext()) {
                    String name = names.next();
                    if (StringHelper.compare((String)strPartName, (String)name, (boolean)false) != 0) continue;
                    return this.getItem(name, bTryMode);
                }
            }
        }
        if ((psSysDynaModels = this.getPSSystem().getAllPSSysDynaModels()) != null) {
            while (psSysDynaModels.hasNext()) {
                IPSJsonSchema iPSJsonSchema;
                IPSSysDynaModel iPSSysDynaModel = psSysDynaModels.next();
                if (!(iPSSysDynaModel instanceof IPSJsonSchema) || StringHelper.compare((String)(iPSJsonSchema = (IPSJsonSchema)((Object)iPSSysDynaModel)).getSchemaId(), (String)strName, (boolean)false) != 0) continue;
                return iPSJsonSchema;
            }
        }
        return (IPSJsonNodeSchema)super.getItem(strName, bTryMode);
    }
}

