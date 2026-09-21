/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 */
package SA.SRFDA.PS.Core.Service.OpenAPI;

import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3MediaTypes;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Response;
import SA.SRFDA.PS.Core.Service.OpenAPI.PSOpenAPI3ObjectImpl;
import com.fasterxml.jackson.databind.JsonNode;

public class PSOpenAPI3ResponseImpl
extends PSOpenAPI3ObjectImpl
implements IPSOpenAPI3Response {
    private IPSOpenAPI3MediaTypes iPSOpenAPI3MediaTypes = null;

    @Override
    protected void onInit() throws Exception {
        if (this.getObjectNode().has("content")) {
            JsonNode jsonNode = this.getObjectNode().get("content");
            this.setPSOpenAPI3MediaTypes(this.getPSOpenAPI3MediaTypes("content", jsonNode));
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9")
    public IPSOpenAPI3MediaTypes getPSOpenAPI3MediaTypes() {
        return this.iPSOpenAPI3MediaTypes;
    }

    protected void setPSOpenAPI3MediaTypes(IPSOpenAPI3MediaTypes iPSOpenAPI3MediaTypes) {
        this.iPSOpenAPI3MediaTypes = iPSOpenAPI3MediaTypes;
    }

    @Override
    public String getModelType() {
        return "PSOPENAPI3RESPONSE$" + this.getPSJsonNodeOwner().getModelType();
    }
}

