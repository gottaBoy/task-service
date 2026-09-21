/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Service.OpenAPI;

import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3License;
import SA.SRFDA.PS.Core.Service.OpenAPI.PSOpenAPI3ObjectImpl;

public class PSOpenAPI3LicenseImpl
extends PSOpenAPI3ObjectImpl
implements IPSOpenAPI3License {
    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u534f\u8baeURL\u5730\u5740")
    public String getUrl() {
        if (this.getObjectNode().has("url")) {
            return this.getObjectNode().get("url").textValue();
        }
        return null;
    }

    @Override
    public String getModelType() {
        return "PSOPENAPI3LICENSE$" + this.getPSJsonNodeOwner().getModelType();
    }

    @Override
    public String getModelId() {
        return this.getPSJsonNodeOwner().getModelId();
    }
}

