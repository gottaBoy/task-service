/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Service;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Service.IPSServiceAPIDTO;

@PSModelPFIgnoreMeta
public interface IPSServiceAPIDTOField
extends IPSModelObject {
    public static final String TYPE_SIMPLE = "SIMPLE";
    public static final String TYPE_SIMPLES = "SIMPLES";
    public static final String TYPE_DTO = "DTO";
    public static final String TYPE_DTOS = "DTOS";

    public String getType();

    public int getStdDataType();

    public IPSServiceAPIDTO getRefPSServiceAPIDTO() throws Exception;

    @Override
    public String getCodeName();

    public boolean isReadOnly();
}

