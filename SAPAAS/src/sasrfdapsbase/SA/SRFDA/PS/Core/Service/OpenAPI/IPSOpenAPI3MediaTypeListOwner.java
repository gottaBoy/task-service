/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Service.OpenAPI;

import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3MediaType;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSOpenAPI3MediaTypeListOwner {
    public Iterator<IPSOpenAPI3MediaType> getPSOpenAPI3MediaTypes();

    public IPSOpenAPI3MediaType getPSOpenAPI3MediaType(String var1, boolean var2) throws Exception;
}

