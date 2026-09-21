/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 */
package SA.SRFDA.PS.Core.DynaModel;

import SA.SRFDA.PS.Core.DynaModel.IPSJsonArraySchema;
import SA.SRFDA.PS.Core.DynaModel.IPSJsonNodeSchema;
import SA.SRFDA.PS.Core.DynaModel.PSJsonNodeSchemaHelper;
import SA.SRFDA.PS.Core.DynaModel.PSJsonNodeSchemaImplBase;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PSJsonArraySchemaImpl
extends PSJsonNodeSchemaImplBase
implements IPSJsonArraySchema {
    private boolean bEnableAdditionalItems = true;
    private IPSJsonNodeSchema iPSJsonNodeSchema = null;
    private List<IPSJsonNodeSchema> prefixPSJsonNodeSchemaList = null;
    private List<IPSJsonNodeSchema> containsPSJsonNodeSchemaList = null;
    private boolean bEnableUniqueItems = false;

    @Override
    protected void onInit() throws Exception {
        JsonNode jsonNode;
        if (this.getObjectNode().has("items")) {
            jsonNode = this.getObjectNode().get("items");
            if (jsonNode.isBoolean()) {
                this.setEnableAdditionalItems(jsonNode.booleanValue());
            } else if (jsonNode instanceof ObjectNode) {
                this.setPSJsonNodeSchema(this.getPSJsonNodeSchema("item", (ObjectNode)jsonNode));
            } else {
                throw new Exception(String.format("\u8282\u70b9[%1$s]\u683c\u5f0f\u4e0d\u6b63\u786e", "items"));
            }
        }
        if (this.getObjectNode().has("Contains")) {
            jsonNode = this.getObjectNode().get("Contains");
            this.setContainsPSJsonNodeSchemas(this.getContainsPSJsonNodeSchemas("Contains", jsonNode));
        }
        if (this.getObjectNode().has("prefixItems")) {
            jsonNode = this.getObjectNode().get("prefixItems");
            this.setPrefixPSJsonNodeSchemas(this.getPrefixPSJsonNodeSchemas("prefixItems", jsonNode));
        }
        if (this.getObjectNode().has("uniqueItems")) {
            jsonNode = this.getObjectNode().get("uniqueItems");
            if (jsonNode.isBoolean()) {
                this.setEnableUniqueItems(jsonNode.booleanValue());
            } else {
                throw new Exception(String.format("\u8282\u70b9[%1$s]\u683c\u5f0f\u4e0d\u6b63\u786e", "uniqueItems"));
            }
        }
        super.onInit();
    }

    @Override
    protected String onGetType() {
        return "array";
    }

    @Override
    @PSModelRTMeta(description="\u8282\u70b9\u7c7b\u578b")
    public IPSJsonNodeSchema getPSJsonNodeSchema() {
        return this.iPSJsonNodeSchema;
    }

    protected void setPSJsonNodeSchema(IPSJsonNodeSchema iPSJsonNodeSchema) {
        this.iPSJsonNodeSchema = iPSJsonNodeSchema;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u989d\u5916\u8282\u70b9")
    public boolean isEnableAdditionalItems() {
        return this.bEnableAdditionalItems;
    }

    protected void setEnableAdditionalItems(boolean bEnableAdditionalItems) {
        this.bEnableAdditionalItems = bEnableAdditionalItems;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7f6e\u8282\u70b9\u96c6\u5408")
    public Iterator<IPSJsonNodeSchema> getPrefixPSJsonNodeSchemas() {
        if (this.prefixPSJsonNodeSchemaList == null || this.prefixPSJsonNodeSchemaList.size() == 0) {
            return null;
        }
        return this.prefixPSJsonNodeSchemaList.iterator();
    }

    protected void setPrefixPSJsonNodeSchemas(List<IPSJsonNodeSchema> prefixPSJsonNodeSchemaList) {
        this.prefixPSJsonNodeSchemaList = prefixPSJsonNodeSchemaList;
    }

    protected List<IPSJsonNodeSchema> getPrefixPSJsonNodeSchemas(String strName, JsonNode jsonNode) throws Exception {
        ArrayList<IPSJsonNodeSchema> list = new ArrayList<IPSJsonNodeSchema>();
        if (jsonNode instanceof ObjectNode) {
            IPSJsonNodeSchema iPSJsonNodeSchema = this.getPSJsonNodeSchema(strName, (ObjectNode)jsonNode);
            list.add(iPSJsonNodeSchema);
        } else if (jsonNode instanceof ArrayNode) {
            ArrayNode arrayNode = (ArrayNode)jsonNode;
            int i = 0;
            while (i < arrayNode.size()) {
                JsonNode item = arrayNode.get(i);
                if (!(item instanceof ObjectNode)) {
                    throw new Exception(String.format("\u8282\u70b9[%1$s][%2$s]\u683c\u5f0f\u4e0d\u6b63\u786e", strName, i));
                }
                IPSJsonNodeSchema iPSJsonNodeSchema = this.getPSJsonNodeSchema(String.format("%1$s%2$s", strName, i), (ObjectNode)item);
                list.add(iPSJsonNodeSchema);
                ++i;
            }
        } else {
            throw new Exception(String.format("\u8282\u70b9[%1$s]\u683c\u5f0f\u4e0d\u6b63\u786e", strName));
        }
        return list;
    }

    @Override
    @PSModelRTMeta(description="\u5305\u542b\u8282\u70b9\u7c7b\u578b")
    public Iterator<IPSJsonNodeSchema> getContainsPSJsonNodeSchemas() {
        if (this.containsPSJsonNodeSchemaList == null || this.containsPSJsonNodeSchemaList.size() == 0) {
            return null;
        }
        return this.containsPSJsonNodeSchemaList.iterator();
    }

    protected void setContainsPSJsonNodeSchemas(List<IPSJsonNodeSchema> containsPSJsonNodeSchemaList) {
        this.containsPSJsonNodeSchemaList = containsPSJsonNodeSchemaList;
    }

    protected List<IPSJsonNodeSchema> getContainsPSJsonNodeSchemas(String strName, JsonNode jsonNode) throws Exception {
        ArrayList<IPSJsonNodeSchema> list = new ArrayList<IPSJsonNodeSchema>();
        if (jsonNode instanceof ObjectNode) {
            IPSJsonNodeSchema iPSJsonNodeSchema = this.getPSJsonNodeSchema(strName, (ObjectNode)jsonNode);
            list.add(iPSJsonNodeSchema);
        } else if (jsonNode instanceof ArrayNode) {
            ArrayNode arrayNode = (ArrayNode)jsonNode;
            int i = 0;
            while (i < arrayNode.size()) {
                JsonNode item = arrayNode.get(i);
                if (!(item instanceof ObjectNode)) {
                    throw new Exception(String.format("\u8282\u70b9[%1$s][%2$s]\u683c\u5f0f\u4e0d\u6b63\u786e", strName, i));
                }
                IPSJsonNodeSchema iPSJsonNodeSchema = this.getPSJsonNodeSchema(String.format("%1$s%2$s", strName, i), (ObjectNode)item);
                list.add(iPSJsonNodeSchema);
                ++i;
            }
        } else {
            throw new Exception(String.format("\u8282\u70b9[%1$s]\u683c\u5f0f\u4e0d\u6b63\u786e", strName));
        }
        return list;
    }

    protected IPSJsonNodeSchema getPSJsonNodeSchema(String strName, ObjectNode objectNode) throws Exception {
        return PSJsonNodeSchemaHelper.getInstance().getPSJsonNodeSchema(this, strName, objectNode);
    }

    @Override
    @PSModelRTMeta(description="\u552f\u4e00\u9879\u9650\u5236")
    public boolean isEnableUniqueItems() {
        return this.bEnableUniqueItems;
    }

    protected void setEnableUniqueItems(boolean bEnableUniqueItems) {
        this.bEnableUniqueItems = bEnableUniqueItems;
    }
}

