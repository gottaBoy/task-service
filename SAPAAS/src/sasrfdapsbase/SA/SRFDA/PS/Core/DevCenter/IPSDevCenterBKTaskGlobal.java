/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DevCenter;

import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskGlobal;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDCBKTask;

@PSModelIgnoreMeta
public interface IPSDevCenterBKTaskGlobal
extends IPSBKTaskGlobal {
    public void addPSDCBKTask(PSDCBKTask var1) throws Exception;

    public void cancelPSDCBKTask(PSDCBKTask var1) throws Exception;
}

