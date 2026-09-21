/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Service;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u65b9\u6cd5\u8f93\u5165\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3")
public interface IPSDEMethodInput
extends IPSModelObject {
    public static final String TYPE_NONE = "NONE";
    public static final String TYPE_KEYFIELD = "KEYFIELD";
    public static final String TYPE_KEYFIELDS = "KEYFIELDS";
    public static final String TYPE_DTO = "DTO";
    public static final String TYPE_DTOS = "DTOS";
    public static final String TYPE_UNKNOWN = "UNKNOWN";
    public static final String TYPE_USER = "USER";
    public static final String TYPE_USER2 = "USER2";

    public String getType();
}

