/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Service.OpenAPI;

import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Parameter;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSOpenAPI3ParameterListOwner {
    public Iterator<IPSOpenAPI3Parameter> getPSOpenAPI3Parameters();

    public IPSOpenAPI3Parameter getPSOpenAPI3Parameter(String var1, boolean var2) throws Exception;
}

