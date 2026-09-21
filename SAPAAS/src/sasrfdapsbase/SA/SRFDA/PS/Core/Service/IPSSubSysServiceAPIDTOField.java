/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Service;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTOField;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Service.IPSServiceAPIDTOField;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDEField;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDERS;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDTO;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5916\u90e8\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3DTO\u5c5e\u6027\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSSubSysServiceAPIDTOField
extends IPSServiceAPIDTOField,
IPSModelSortable {
    public static final String SOURCETYPE_SUBSYSSERVICEAPIDEFIELD = "SUBSYSSERVICEAPIDEFIELD";
    public static final String SOURCETYPE_SUBSYSSERVICEAPIDERS = "SUBSYSSERVICEAPIDERS";
    public static final String SOURCETYPE_DEMETHODDTOFIELD = "DEMETHODDTOFIELD";

    public String getSourceType();

    public IPSSubSysServiceAPIDTO getPSSubSysServiceAPIDTO();

    public IPSSubSysServiceAPIDTO getRefPSSubSysServiceAPIDTO() throws Exception;

    public IPSSubSysServiceAPIDEField getPSSubSysServiceAPIDEField();

    public IPSSubSysServiceAPIDERS getPSSubSysServiceAPIDERS();

    public IPSDEMethodDTOField getPSDEMethodDTOField();

    public String getLogicName();

    public boolean isAllowEmpty();

    public IPSCodeList getPSCodeList();
}

