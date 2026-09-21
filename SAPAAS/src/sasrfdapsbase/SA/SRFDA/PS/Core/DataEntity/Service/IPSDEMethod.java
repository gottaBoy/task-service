/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Service;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;

@PSModelPFIgnoreMeta
@PSModelIgnoreMeta
public interface IPSDEMethod
extends IPSDataEntityObject {
    public static final String METHODTYPE_UNKNOWN = "UNKNOWN";
    public static final String METHODTYPE_DEACTION = "DEACTION";
    public static final String METHODTYPE_FETCH = "FETCH";
    public static final String METHODTYPE_SELECT = "SELECT";
    public static final String METHODTYPE_FETCHTEMP = "FETCHTEMP";
    public static final String METHODTYPE_SELECTTEMP = "SELECTTEMP";

    public String getMethodType();

    @Override
    public String getCodeName();

    public IPSSFXCodeObject getRender();
}

