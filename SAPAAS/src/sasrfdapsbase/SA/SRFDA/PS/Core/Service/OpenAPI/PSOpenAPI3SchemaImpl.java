/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Service.OpenAPI;

import SA.SRFDA.PS.Core.DynaModel.IPSJsonDefs;
import SA.SRFDA.PS.Core.DynaModel.IPSJsonDefsOwner;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Components;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Info;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Paths;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Schema;
import SA.SRFDA.PS.Core.Service.OpenAPI.PSOpenAPI3ComponentsImpl;
import SA.SRFDA.PS.Core.Service.OpenAPI.PSOpenAPI3InfoImpl;
import SA.SRFDA.PS.Core.Service.OpenAPI.PSOpenAPI3ObjectImpl;
import SA.SRFDA.PS.Core.Service.OpenAPI.PSOpenAPI3PathsImpl;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSOpenAPI3SchemaImpl
extends PSOpenAPI3ObjectImpl
implements IPSOpenAPI3Schema,
IPSJsonDefsOwner {
    private static final Log log = LogFactory.getLog(PSOpenAPI3SchemaImpl.class);
    private IPSOpenAPI3Components iPSOpenAPI3Components = null;
    private IPSOpenAPI3Info iPSOpenAPI3Info = null;
    private IPSOpenAPI3Paths iPSOpenAPI3Paths = null;

    @Override
    protected void onInit() throws Exception {
        JsonNode jsonNode;
        if (this.getObjectNode().has("components")) {
            jsonNode = this.getObjectNode().get("components");
            if (jsonNode instanceof ObjectNode) {
                PSOpenAPI3ComponentsImpl psOpenAPI3ComponentsImpl = new PSOpenAPI3ComponentsImpl();
                psOpenAPI3ComponentsImpl.init(this.getDAGlobalHelper(), this, "components", (JsonNode)((ObjectNode)jsonNode));
                this.setPSOpenAPI3Components(psOpenAPI3ComponentsImpl);
            } else {
                throw new Exception(String.format("\u8282\u70b9[%1$s]\u683c\u5f0f\u4e0d\u6b63\u786e", "components"));
            }
        }
        if (this.getObjectNode().has("info")) {
            jsonNode = this.getObjectNode().get("info");
            if (jsonNode instanceof ObjectNode) {
                PSOpenAPI3InfoImpl psOpenAPI3InfoImpl = new PSOpenAPI3InfoImpl();
                psOpenAPI3InfoImpl.init(this.getDAGlobalHelper(), this, "info", (JsonNode)((ObjectNode)jsonNode));
                this.setPSOpenAPI3Info(psOpenAPI3InfoImpl);
            } else {
                throw new Exception(String.format("\u8282\u70b9[%1$s]\u683c\u5f0f\u4e0d\u6b63\u786e", "info"));
            }
        }
        if (this.getObjectNode().has("paths")) {
            jsonNode = this.getObjectNode().get("paths");
            if (jsonNode instanceof ObjectNode) {
                this.setPSOpenAPI3Paths(this.getPSOpenAPI3Paths("paths", (ObjectNode)jsonNode));
            } else {
                throw new Exception(String.format("\u8282\u70b9[%1$s]\u683c\u5f0f\u4e0d\u6b63\u786e", "paths"));
            }
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u63a5\u53e3\u4fe1\u606f\u5bf9\u8c61")
    public IPSOpenAPI3Info getPSOpenAPI3Info() {
        return this.iPSOpenAPI3Info;
    }

    protected void setPSOpenAPI3Info(IPSOpenAPI3Info iPSOpenAPI3Info) {
        this.iPSOpenAPI3Info = iPSOpenAPI3Info;
    }

    @Override
    @PSModelRTMeta(description="\u590d\u7528\u7ec4\u4ef6\u96c6\u5408\u5bf9\u8c61")
    public IPSOpenAPI3Components getPSOpenAPI3Components() {
        return this.iPSOpenAPI3Components;
    }

    protected void setPSOpenAPI3Components(IPSOpenAPI3Components iPSOpenAPI3Components) {
        this.iPSOpenAPI3Components = iPSOpenAPI3Components;
    }

    protected IPSOpenAPI3Paths getPSOpenAPI3Paths(String strName, ObjectNode objectNode) throws Exception {
        PSOpenAPI3PathsImpl psOpenAPI3PathsImpl = new PSOpenAPI3PathsImpl();
        psOpenAPI3PathsImpl.init(this.getDAGlobalHelper(), this, strName, objectNode);
        return psOpenAPI3PathsImpl;
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u8def\u5f84\u96c6\u5408\u5bf9\u8c61")
    public IPSOpenAPI3Paths getPSOpenAPI3Paths() {
        return this.iPSOpenAPI3Paths;
    }

    protected void setPSOpenAPI3Paths(IPSOpenAPI3Paths iPSOpenAPI3Paths) {
        this.iPSOpenAPI3Paths = iPSOpenAPI3Paths;
    }

    @Override
    public String getModelType() {
        return "PSOPENAPI3SCHEMA$" + this.getPSJsonNodeOwner().getModelType();
    }

    @Override
    public String getModelId() {
        return this.getPSJsonNodeOwner().getModelId();
    }

    @Override
    public IPSJsonDefs getPSJsonDefs() {
        if (this.getPSOpenAPI3Components() != null) {
            return this.getPSOpenAPI3Components().getPSJsonDefs();
        }
        return null;
    }
}

