/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.ObjectMapper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.yaml.snakeyaml.Yaml
 */
package SA.SRFDA.PS.Core.DynaModel;

import SA.SRFDA.PS.Core.DynaModel.IPSJsonNodeOwner;
import SA.SRFDA.PS.Core.DynaModel.PSSysDynaModelImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Components;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Info;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Paths;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Schema;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3SchemaOwner;
import SA.SRFDA.PS.Core.Service.OpenAPI.PSOpenAPI3SchemaImpl;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.yaml.snakeyaml.Yaml;

@PSModelImplementMeta(implement="IPSSysDynaModel", typevalues={"OPENAPI3SCHEMA"})
public class PSOpenAPI3SchemaModelImpl
extends PSSysDynaModelImpl
implements IPSOpenAPI3Schema,
IPSOpenAPI3SchemaOwner {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final Log log = LogFactory.getLog(PSOpenAPI3SchemaModelImpl.class);
    private IPSOpenAPI3Schema iPSOpenAPI3Schema = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected void onPreparePSSysDynaModelAttrs() throws Exception {
        ObjectNode objectNode = null;
        if (!StringHelper.isNullOrEmpty((String)this.getJOString())) {
            String strContent = this.getJOString();
            if (strContent.indexOf("{") != 0) {
                Yaml yaml = new Yaml();
                Object objMap = yaml.load(strContent);
                strContent = MAPPER.writeValueAsString(objMap);
            }
            objectNode = (ObjectNode)MAPPER.readTree(strContent);
        } else {
            objectNode = MAPPER.createObjectNode();
        }
        PSOpenAPI3SchemaImpl psOpenAPI3SchemaImpl = new PSOpenAPI3SchemaImpl();
        psOpenAPI3SchemaImpl.init(this.getDAGlobalHelper(), this, this.getName(), (JsonNode)objectNode);
        this.iPSOpenAPI3Schema = psOpenAPI3SchemaImpl;
    }

    @Override
    public String getModelType() {
        return "PSOPENAPI3SCHEMA";
    }

    @Override
    public String getDescription() {
        return this.getPSOpenAPI3Schema().getDescription();
    }

    @Override
    @PSModelRTMeta(description="\u63a5\u53e3\u4fe1\u606f\u5bf9\u8c61")
    public IPSOpenAPI3Info getPSOpenAPI3Info() {
        return this.getPSOpenAPI3Schema().getPSOpenAPI3Info();
    }

    @Override
    @PSModelRTMeta(description="\u590d\u7528\u7ec4\u4ef6\u96c6\u5408\u5bf9\u8c61")
    public IPSOpenAPI3Components getPSOpenAPI3Components() {
        return this.getPSOpenAPI3Schema().getPSOpenAPI3Components();
    }

    @Override
    public IPSOpenAPI3Schema getPSOpenAPI3Schema() {
        return this.iPSOpenAPI3Schema;
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u8def\u5f84\u96c6\u5408\u5bf9\u8c61")
    public IPSOpenAPI3Paths getPSOpenAPI3Paths() {
        return this.getPSOpenAPI3Schema().getPSOpenAPI3Paths();
    }

    @Override
    public IPSJsonNodeOwner getPSJsonNodeOwner() {
        return null;
    }

    @Override
    public JsonNode getJsonNode() {
        if (this.getPSOpenAPI3Schema() != null) {
            return this.getPSOpenAPI3Schema().getJsonNode();
        }
        return null;
    }
}

