/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public interface IPSDBIndexBase
extends IPSModelObject {
    public static final String INDEXTYPE_NORMAL = "NORMAL";
    public static final String INDEXTYPE_UNIQUE = "UNIQUE";

    @Override
    public String getCodeName();

    public String getIndexType();

    public boolean isAllowReverse();
}

