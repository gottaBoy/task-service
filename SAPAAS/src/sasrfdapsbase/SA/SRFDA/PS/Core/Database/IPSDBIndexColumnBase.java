/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public interface IPSDBIndexColumnBase
extends IPSModelObject {
    public String getSortDir();

    public boolean isIncludeMode();

    public int getLength();
}

