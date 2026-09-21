/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Service.OpenAPI;

import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Operation;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSOpenAPI3OperationListOwner {
    public Iterator<IPSOpenAPI3Operation> getPSOpenAPI3Operations();
}

