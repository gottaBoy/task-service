/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 */
package SA.SRFDA.PS.Core.Service.OpenAPI;

import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Contact;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Info;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3License;
import SA.SRFDA.PS.Core.Service.OpenAPI.PSOpenAPI3ContactImpl;
import SA.SRFDA.PS.Core.Service.OpenAPI.PSOpenAPI3LicenseImpl;
import SA.SRFDA.PS.Core.Service.OpenAPI.PSOpenAPI3ObjectImpl;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class PSOpenAPI3InfoImpl
extends PSOpenAPI3ObjectImpl
implements IPSOpenAPI3Info {
    private IPSOpenAPI3Contact iPSOpenAPI3Contact = null;
    private IPSOpenAPI3License iPSOpenAPI3License = null;

    @Override
    protected void onInit() throws Exception {
        JsonNode jsonNode;
        if (this.getObjectNode().has("contact")) {
            jsonNode = this.getObjectNode().get("contact");
            if (jsonNode instanceof ObjectNode) {
                PSOpenAPI3ContactImpl psOpenAPI3ContactImpl = new PSOpenAPI3ContactImpl();
                psOpenAPI3ContactImpl.init(this.getDAGlobalHelper(), this, "contact", (JsonNode)((ObjectNode)jsonNode));
                this.setPSOpenAPI3Contact(psOpenAPI3ContactImpl);
            } else {
                throw new Exception(String.format("\u8054\u7cfb\u4eba\u8282\u70b9[%1$s]\u683c\u5f0f\u4e0d\u6b63\u786e", "contact"));
            }
        }
        if (this.getObjectNode().has("license")) {
            jsonNode = this.getObjectNode().get("license");
            if (jsonNode instanceof ObjectNode) {
                PSOpenAPI3LicenseImpl psOpenAPI3LicenseImpl = new PSOpenAPI3LicenseImpl();
                psOpenAPI3LicenseImpl.init(this.getDAGlobalHelper(), this, "license", (JsonNode)((ObjectNode)jsonNode));
                this.setPSOpenAPI3License(psOpenAPI3LicenseImpl);
            } else {
                throw new Exception(String.format("\u534f\u8bae\u8282\u70b9[%1$s]\u683c\u5f0f\u4e0d\u6b63\u786e", "license"));
            }
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u62ac\u5934")
    public String getTitle() {
        if (this.getObjectNode().has("title")) {
            return this.getObjectNode().get("title").textValue();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7248\u672c")
    public String getAPIVersion() {
        if (this.getObjectNode().has("version")) {
            return this.getObjectNode().get("version").textValue();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u6761\u6b3e\u8def\u5f84")
    public String getTermsOfService() {
        if (this.getObjectNode().has("termsOfService")) {
            return this.getObjectNode().get("termsOfService").textValue();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u63a5\u53e3\u8054\u7cfb\u4eba\u5bf9\u8c61")
    public IPSOpenAPI3Contact getPSOpenAPI3Contact() {
        return this.iPSOpenAPI3Contact;
    }

    protected void setPSOpenAPI3Contact(IPSOpenAPI3Contact iPSOpenAPI3Contact) {
        this.iPSOpenAPI3Contact = iPSOpenAPI3Contact;
    }

    @Override
    @PSModelRTMeta(description="\u63a5\u53e3\u534f\u8bae\u5bf9\u8c61")
    public IPSOpenAPI3License getPSOpenAPI3License() {
        return this.iPSOpenAPI3License;
    }

    protected void setPSOpenAPI3License(IPSOpenAPI3License iPSOpenAPI3License) {
        this.iPSOpenAPI3License = iPSOpenAPI3License;
    }

    @Override
    public String getModelType() {
        return "PSOPENAPI3INFO$" + this.getPSJsonNodeOwner().getModelType();
    }

    @Override
    public String getModelId() {
        return this.getPSJsonNodeOwner().getModelId();
    }
}

