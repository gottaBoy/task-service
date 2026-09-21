/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Action;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDEMethod;

@PSModelPFIgnoreMeta
@PSModelExtendMeta(typevalue={"REMOTE"}, title="\u5b9e\u4f53\u8fdc\u7a0b\u8c03\u7528\u884c\u4e3a\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSDERemoteAction
extends IPSDEAction {
    @Override
    public IPSSubSysServiceAPIDEMethod getPSSubSysServiceAPIDEMethod() throws Exception;
}

