/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUIAction;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDEUIAction;

@PSModelIgnoreMeta
public interface IPSAppDataEntityRuntime {
    public IPSAppDEUIAction registerPSAppDEUIAction(PSDEUIAction var1) throws Exception;
}

