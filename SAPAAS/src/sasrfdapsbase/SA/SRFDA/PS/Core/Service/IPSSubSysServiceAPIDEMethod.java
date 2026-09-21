/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Service;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDE;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIMethod;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIMethodInput;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIMethodReturn;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5916\u90e8\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3\u5b9e\u4f53\u884c\u4e3a\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSubSysSADetail")
public interface IPSSubSysServiceAPIDEMethod
extends IPSSubSysServiceAPIMethod {
    public IPSSubSysServiceAPIDE getPSSubSysServiceAPIDE();

    public IPSSubSysServiceAPIDE getInPSSubSysServiceAPIDE() throws Exception;

    public IPSSubSysServiceAPIDE getOutPSSubSysServiceAPIDE() throws Exception;

    public IPSSubSysServiceAPIMethodInput getPSSubSysServiceAPIMethodInput() throws Exception;

    public IPSSubSysServiceAPIMethodReturn getPSSubSysServiceAPIMethodReturn() throws Exception;

    public IPSDataEntity getSourcePSDataEntity();

    public IPSDEAction getSourcePSDEAction();

    public IPSDEDataSet getSourcePSDEDataSet();
}

