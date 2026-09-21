/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.SF.IPSSFCodeType;

@PSModelIgnoreMeta
public interface IPSSFCodeType2
extends IPSSFCodeType {
    public String getPubParam();

    public boolean isCheckModelOnly();

    public boolean isRemoveEmptyFile();
}

