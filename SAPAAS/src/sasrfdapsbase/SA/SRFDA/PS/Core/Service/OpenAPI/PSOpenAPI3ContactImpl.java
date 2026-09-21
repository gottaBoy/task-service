/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Service.OpenAPI;

import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Contact;
import SA.SRFDA.PS.Core.Service.OpenAPI.PSOpenAPI3ObjectImpl;

public class PSOpenAPI3ContactImpl
extends PSOpenAPI3ObjectImpl
implements IPSOpenAPI3Contact {
    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u8054\u7cfb\u4ebaURL\u5730\u5740")
    public String getUrl() {
        if (this.getObjectNode().has("url")) {
            return this.getObjectNode().get("url").textValue();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u8054\u7cfb\u4eba\u7535\u5b50\u90ae\u4ef6\u5730\u5740")
    public String getEmail() {
        if (this.getObjectNode().has("email")) {
            return this.getObjectNode().get("email").textValue();
        }
        return null;
    }

    @Override
    public String getModelType() {
        return "PSOPENAPI3CONTACT$" + this.getPSJsonNodeOwner().getModelType();
    }

    @Override
    public String getModelId() {
        return this.getPSJsonNodeOwner().getModelId();
    }
}

