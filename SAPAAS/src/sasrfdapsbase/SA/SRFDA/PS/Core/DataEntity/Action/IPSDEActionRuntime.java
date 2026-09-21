/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Action;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionLogic;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDEMethod;

@PSModelIgnoreMeta
public interface IPSDEActionRuntime {
    public void setPSSubSysServiceAPIDEMethod(IPSSubSysServiceAPIDEMethod var1) throws Exception;

    public void registerPSDEActionLogic(IPSDEActionLogic var1) throws Exception;
}

