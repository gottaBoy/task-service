/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.BA;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public interface IPSBDTableDE
extends IPSModelObject {
    public static final int BDTABLEDETYPE_DEFAULT = 1;
    public static final int BDTABLEDETYPE_MAJOR = 2;
    public static final int BDTABLEDETYPE_MINOR = 3;
    public static final int BDTABLEDETYPE_RELATED = 0;

    public int getBDTableDEType();

    public String getRowKeyFormat();

    public String getRowKeyParams();
}

