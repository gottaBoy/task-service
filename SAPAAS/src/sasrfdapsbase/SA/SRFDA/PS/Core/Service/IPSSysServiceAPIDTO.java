/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Service;

import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Service.IPSServiceAPIDTO;
import SA.SRFDA.PS.Core.Service.IPSSysServiceAPI;
import SA.SRFDA.PS.Core.Service.IPSSysServiceAPIDTOField;
import java.util.Iterator;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3DTO\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSSysServiceAPIDTO
extends IPSServiceAPIDTO {
    public static final String TYPE_DEACTIONINPUT = "DEACTIONINPUT";
    public static final String TYPE_DEFILTER = "DEFILTER";
    public static final String TYPE_DEDOMAIN = "DEDOMAIN";

    public IPSSysServiceAPI getPSSysServiceAPI();

    public Iterator<? extends IPSSysServiceAPIDTOField> getPSSysServiceAPIDTOFields();
}

