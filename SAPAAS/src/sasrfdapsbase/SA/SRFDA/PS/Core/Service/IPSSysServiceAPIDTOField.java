/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Service;

import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Service.IPSServiceAPIDTOField;
import SA.SRFDA.PS.Core.Service.IPSSysServiceAPIDTO;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3DTO\u5c5e\u6027\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSSysServiceAPIDTOField
extends IPSServiceAPIDTOField {
    public IPSSysServiceAPIDTO getPSSysServiceAPIDTO();

    public IPSSysServiceAPIDTO getRefPSSysServiceAPIDTO() throws Exception;
}

