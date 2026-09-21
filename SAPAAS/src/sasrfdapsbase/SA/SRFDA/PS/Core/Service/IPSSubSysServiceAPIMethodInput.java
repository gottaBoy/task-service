/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Service;

import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodInput;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDE;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDEField;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDEMethod;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDTO;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5916\u90e8\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3\u5b9e\u4f53\u884c\u4e3a\u8f93\u5165\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSSubSysServiceAPIMethodInput
extends IPSDEMethodInput {
    public IPSSubSysServiceAPIDEMethod getPSSubSysServiceAPIMethod();

    public IPSSubSysServiceAPIDTO getPSSubSysServiceAPIDTO() throws Exception;

    public IPSSubSysServiceAPIDEField getKeyPSSubSysServiceAPIField();

    public IPSSubSysServiceAPIDE getPSSubSysServiceAPIDE();
}

