/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Service.OpenAPI;

import SA.SRFDA.PS.Core.DynaModel.IPSJsonNodeSchema;
import SA.SRFDA.PS.Core.DynaModel.PSJsonNodeImpl;
import SA.SRFDA.PS.Core.DynaModel.PSJsonNodeSchemaHelper;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3MediaType;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3MediaTypes;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Object;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Parameter;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3RequestBody;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Responses;
import SA.SRFDA.PS.Core.Service.OpenAPI.PSOpenAPI3MediaTypeImpl;
import SA.SRFDA.PS.Core.Service.OpenAPI.PSOpenAPI3MediaTypesImpl;
import SA.SRFDA.PS.Core.Service.OpenAPI.PSOpenAPI3ParameterImpl;
import SA.SRFDA.PS.Core.Service.OpenAPI.PSOpenAPI3RequestBodyImpl;
import SA.SRFDA.PS.Core.Service.OpenAPI.PSOpenAPI3ResponsesImpl;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;

public abstract class PSOpenAPI3ObjectImpl
extends PSJsonNodeImpl
implements IPSOpenAPI3Object {
    @Override
    protected void onInit() throws Exception {
        if (this.getObjectNode().has("name")) {
            this.setName(this.getObjectNode().get("name").textValue());
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u63cf\u8ff0\u4fe1\u606f")
    public String getDescription() {
        if (this.getObjectNode().has("description")) {
            return this.getObjectNode().get("description").textValue();
        }
        return null;
    }

    protected Map<String, IPSOpenAPI3Parameter> getPSOpenAPI3ParameterMap(String strName, JsonNode jsonNode) throws Exception {
        LinkedHashMap<String, IPSOpenAPI3Parameter> psOpenAPI3ParameterMap = new LinkedHashMap<String, IPSOpenAPI3Parameter>();
        if (jsonNode instanceof ArrayNode) {
            ArrayNode arrayNode = (ArrayNode)jsonNode;
            int i = 0;
            while (i < arrayNode.size()) {
                String strParameterName;
                ObjectNode parameterObject;
                JsonNode item = arrayNode.get(i);
                if (item instanceof ObjectNode) {
                    parameterObject = (ObjectNode)item;
                    strParameterName = null;
                    JsonNode nameNode = parameterObject.get("name");
                    if (nameNode != null) {
                        strParameterName = nameNode.textValue();
                    }
                    if (StringHelper.isNullOrEmpty(strParameterName)) {
                        throw new Exception(String.format("\u8282\u70b9[%1$s][%2$s]\u672a\u6307\u5b9a\u540d\u79f0", strName, i));
                    }
                } else {
                    throw new Exception(String.format("\u8282\u70b9[%1$s][%2$s]\u683c\u5f0f\u4e0d\u6b63\u786e", strName, i));
                }
                psOpenAPI3ParameterMap.put(strParameterName, this.getPSOpenAPI3Parameter(strParameterName, (JsonNode)parameterObject));
                ++i;
            }
            return psOpenAPI3ParameterMap;
        }
        throw new Exception(String.format("\u8282\u70b9[%1$s]\u683c\u5f0f\u4e0d\u6b63\u786e", strName));
    }

    protected IPSOpenAPI3Parameter getPSOpenAPI3Parameter(String strName, JsonNode jsonNode) throws Exception {
        if (jsonNode instanceof ObjectNode) {
            PSOpenAPI3ParameterImpl psOpenAPI3ParameterImpl = new PSOpenAPI3ParameterImpl();
            psOpenAPI3ParameterImpl.init(this.getDAGlobalHelper(), this, strName, (JsonNode)((ObjectNode)jsonNode));
            return psOpenAPI3ParameterImpl;
        }
        throw new Exception(String.format("\u8282\u70b9[%1$s]\u683c\u5f0f\u4e0d\u6b63\u786e", strName));
    }

    protected IPSJsonNodeSchema getPSJsonNodeSchema(String strName, ObjectNode objData) throws Exception {
        return PSJsonNodeSchemaHelper.getInstance().getPSJsonNodeSchema(this, strName, objData);
    }

    protected Map<String, IPSOpenAPI3MediaType> getPSOpenAPI3MediaTypeMap(String strName, JsonNode jsonNode) throws Exception {
        LinkedHashMap<String, IPSOpenAPI3MediaType> psOpenAPI3MediaTypeMap = new LinkedHashMap<String, IPSOpenAPI3MediaType>();
        if (jsonNode instanceof ArrayNode) {
            ArrayNode arrayNode = (ArrayNode)jsonNode;
            int i = 0;
            while (i < arrayNode.size()) {
                String strMediaTypeName;
                ObjectNode parameterObject;
                JsonNode item = arrayNode.get(i);
                if (item instanceof ObjectNode) {
                    parameterObject = (ObjectNode)item;
                    strMediaTypeName = null;
                    JsonNode nameNode = parameterObject.get("name");
                    if (nameNode != null) {
                        strMediaTypeName = nameNode.textValue();
                    }
                    if (StringHelper.isNullOrEmpty(strMediaTypeName)) {
                        throw new Exception(String.format("\u8282\u70b9[%1$s][%2$s]\u672a\u6307\u5b9a\u540d\u79f0", strName, i));
                    }
                } else {
                    throw new Exception(String.format("\u8282\u70b9[%1$s][%2$s]\u683c\u5f0f\u4e0d\u6b63\u786e", strName, i));
                }
                psOpenAPI3MediaTypeMap.put(strMediaTypeName, this.getPSOpenAPI3MediaType(strMediaTypeName, (JsonNode)parameterObject));
                ++i;
            }
            return psOpenAPI3MediaTypeMap;
        }
        if (jsonNode instanceof ObjectNode) {
            ObjectNode objectNode = (ObjectNode)jsonNode;
            Iterator names = objectNode.fieldNames();
            if (names != null) {
                while (names.hasNext()) {
                    String strMediaTypeName = (String)names.next();
                    JsonNode item = objectNode.get(strMediaTypeName);
                    if (item instanceof ObjectNode) {
                        ObjectNode parameterObject = (ObjectNode)item;
                        psOpenAPI3MediaTypeMap.put(strMediaTypeName, this.getPSOpenAPI3MediaType(strMediaTypeName, (JsonNode)parameterObject));
                        continue;
                    }
                    throw new Exception(String.format("\u8282\u70b9[%1$s][%2$s]\u683c\u5f0f\u4e0d\u6b63\u786e", strName, strMediaTypeName));
                }
            }
            return psOpenAPI3MediaTypeMap;
        }
        throw new Exception(String.format("\u8282\u70b9[%1$s]\u683c\u5f0f\u4e0d\u6b63\u786e", strName));
    }

    protected IPSOpenAPI3MediaType getPSOpenAPI3MediaType(String strName, JsonNode jsonNode) throws Exception {
        if (jsonNode instanceof ObjectNode) {
            PSOpenAPI3MediaTypeImpl psOpenAPI3MediaTypeImpl = new PSOpenAPI3MediaTypeImpl();
            psOpenAPI3MediaTypeImpl.init(this.getDAGlobalHelper(), this, strName, (JsonNode)((ObjectNode)jsonNode));
            return psOpenAPI3MediaTypeImpl;
        }
        throw new Exception(String.format("\u8282\u70b9[%1$s]\u683c\u5f0f\u4e0d\u6b63\u786e", strName));
    }

    protected IPSOpenAPI3RequestBody getPSOpenAPI3RequestBody(String strName, JsonNode jsonNode) throws Exception {
        if (jsonNode instanceof ObjectNode) {
            PSOpenAPI3RequestBodyImpl psOpenAPI3RequestBodyImpl = new PSOpenAPI3RequestBodyImpl();
            psOpenAPI3RequestBodyImpl.init(this.getDAGlobalHelper(), this, strName, (JsonNode)((ObjectNode)jsonNode));
            return psOpenAPI3RequestBodyImpl;
        }
        throw new Exception(String.format("\u8282\u70b9[%1$s]\u683c\u5f0f\u4e0d\u6b63\u786e", strName));
    }

    protected IPSOpenAPI3MediaTypes getPSOpenAPI3MediaTypes(String strName, JsonNode jsonNode) throws Exception {
        if (jsonNode instanceof ObjectNode) {
            PSOpenAPI3MediaTypesImpl psOpenAPI3MediaTypesImpl = new PSOpenAPI3MediaTypesImpl();
            psOpenAPI3MediaTypesImpl.init(this.getDAGlobalHelper(), this, strName, (ObjectNode)jsonNode);
            return psOpenAPI3MediaTypesImpl;
        }
        throw new Exception(String.format("\u8282\u70b9[%1$s]\u683c\u5f0f\u4e0d\u6b63\u786e", strName));
    }

    protected IPSOpenAPI3Responses getPSOpenAPI3Responses(String strName, JsonNode jsonNode) throws Exception {
        if (jsonNode instanceof ObjectNode) {
            PSOpenAPI3ResponsesImpl psOpenAPI3ResponsesImpl = new PSOpenAPI3ResponsesImpl();
            psOpenAPI3ResponsesImpl.init(this.getDAGlobalHelper(), this, strName, (ObjectNode)jsonNode);
            return psOpenAPI3ResponsesImpl;
        }
        throw new Exception(String.format("\u8282\u70b9[%1$s]\u683c\u5f0f\u4e0d\u6b63\u786e", strName));
    }
}

