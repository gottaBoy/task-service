/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
 */
package SA.SRFDA.PS.Core.Service.OpenAPI;

import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Operation;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Parameter;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3RequestBody;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Responses;
import SA.SRFDA.PS.Core.Service.OpenAPI.PSOpenAPI3ObjectImpl;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PSOpenAPI3OperationImpl
extends PSOpenAPI3ObjectImpl
implements IPSOpenAPI3Operation {
    private List<String> tagList = null;
    private Map<String, IPSOpenAPI3Parameter> psOpenAPI3ParameterMap = null;
    private IPSOpenAPI3RequestBody iPSOpenAPI3RequestBody = null;
    private IPSOpenAPI3Responses iPSOpenAPI3Responses = null;

    @Override
    protected void onInit() throws Exception {
        JsonNode jsonNode;
        if (this.getObjectNode().has("tags")) {
            this.setTags(this.getTags("tags", this.getObjectNode().get("tags")));
        }
        if (this.getObjectNode().has("parameters")) {
            jsonNode = this.getObjectNode().get("parameters");
            this.setPSOpenAPI3ParameterMap(this.getPSOpenAPI3ParameterMap("parameters", jsonNode));
        }
        if (this.getObjectNode().has("requestBody")) {
            jsonNode = this.getObjectNode().get("requestBody");
            this.setPSOpenAPI3RequestBody(this.getPSOpenAPI3RequestBody("requestBody", jsonNode));
        }
        if (this.getObjectNode().has("responses")) {
            jsonNode = this.getObjectNode().get("responses");
            this.setPSOpenAPI3Responses(this.getPSOpenAPI3Responses("responses", jsonNode));
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u6807\u8bb0\u96c6\u5408")
    public Iterator<String> getTags() {
        if (this.tagList == null || this.tagList.size() == 0) {
            return null;
        }
        return this.tagList.iterator();
    }

    protected void setTags(List<String> tagList) {
        this.tagList = tagList;
    }

    protected List<String> getTags(String strName, JsonNode node) throws Exception {
        if (node instanceof ArrayNode) {
            ArrayList<String> tagList = new ArrayList<String>();
            ArrayNode arrayNode = (ArrayNode)node;
            int i = 0;
            while (i < arrayNode.size()) {
                String strText = arrayNode.get(i).textValue();
                tagList.add(strText);
                ++i;
            }
            return tagList;
        }
        throw new Exception(String.format("\u8282\u70b9[%1$s]\u683c\u5f0f\u4e0d\u6b63\u786e", "tags"));
    }

    @Override
    @PSModelRTMeta(description="\u64cd\u4f5c\u6807\u8bc6")
    public String getOperationId() {
        if (this.getObjectNode().has("operationId")) {
            return this.getObjectNode().get("operationId").textValue();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u64cd\u4f5c\u6458\u8981")
    public String getSummary() {
        if (this.getObjectNode().has("summary")) {
            return this.getObjectNode().get("summary").textValue();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u53c2\u6570\u96c6\u5408")
    public Iterator<IPSOpenAPI3Parameter> getPSOpenAPI3Parameters() {
        if (this.psOpenAPI3ParameterMap == null || this.psOpenAPI3ParameterMap.size() == 0) {
            return null;
        }
        return this.psOpenAPI3ParameterMap.values().iterator();
    }

    @Override
    public IPSOpenAPI3Parameter getPSOpenAPI3Parameter(String strName, boolean bTryMode) throws Exception {
        IPSOpenAPI3Parameter iPSOpenAPI3Parameter = this.psOpenAPI3ParameterMap.get(strName);
        if (iPSOpenAPI3Parameter != null || bTryMode) {
            return iPSOpenAPI3Parameter;
        }
        throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u53c2\u6570\u5bf9\u8c61[%1$s]", strName));
    }

    protected void setPSOpenAPI3ParameterMap(Map<String, IPSOpenAPI3Parameter> psOpenAPI3ParameterMap) {
        this.psOpenAPI3ParameterMap = psOpenAPI3ParameterMap;
    }

    @Override
    @PSModelRTMeta(description="\u8bf7\u6c42\u4f53")
    public IPSOpenAPI3RequestBody getPSOpenAPI3RequestBody() {
        return this.iPSOpenAPI3RequestBody;
    }

    protected void setPSOpenAPI3RequestBody(IPSOpenAPI3RequestBody iPSOpenAPI3RequestBody) {
        this.iPSOpenAPI3RequestBody = iPSOpenAPI3RequestBody;
    }

    @Override
    @PSModelRTMeta(description="\u8fd4\u56de\u96c6\u5408")
    public IPSOpenAPI3Responses getPSOpenAPI3Responses() {
        return this.iPSOpenAPI3Responses;
    }

    protected void setPSOpenAPI3Responses(IPSOpenAPI3Responses iPSOpenAPI3Responses) {
        this.iPSOpenAPI3Responses = iPSOpenAPI3Responses;
    }

    @Override
    public String getModelType() {
        return "PSOPENAPI3OPERATION$" + this.getPSJsonNodeOwner().getModelType();
    }
}

