/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Service;

import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTO;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Service.IPSServiceAPIDTO;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPI;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDE;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDTOField;
import java.util.Iterator;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5916\u90e8\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3DTO\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSSubSysServiceAPIDTO
extends IPSServiceAPIDTO {
    public static final String TYPE_SUBSYSSERVICEAPIDE = "SUBSYSSERVICEAPIDE";
    public static final String TYPE_DEMETHODDTO = "DEMETHODDTO";

    public IPSSubSysServiceAPI getPSSubSysServiceAPI();

    public Iterator<? extends IPSSubSysServiceAPIDTOField> getPSSubSysServiceAPIDTOFields();

    public IPSSubSysServiceAPIDE getPSSubSysServiceAPIDE();

    public IPSDEMethodDTO getPSDEMethodDTO();

    public String getTag();

    public String getTag2();
}

