/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Service;

import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Data.PSDESARS;
import java.util.List;

@PSModelPFIgnoreMeta
@PSModelIgnoreMeta
public interface IPSDEServiceAPIRuntime {
    public List<PSDESARS> getAutoPSDESARSs() throws Exception;
}

