/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Service.OpenAPI;

import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Response;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSOpenAPI3ResponseListOwner {
    public Iterator<IPSOpenAPI3Response> getPSOpenAPI3Responses();

    public IPSOpenAPI3Response getPSOpenAPI3Response(String var1, boolean var2) throws Exception;
}

