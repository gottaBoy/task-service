/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSSFLogicCodeObject {
    public static final String LOGICCODECAT_DEACTION = "DEACTION";
    public static final String LOGICCODECAT_DEFVALUERULE = "DEFVALUERULE";
    public static final String LOGICCODECAT_CODELIST = "CODELIST";

    public String getSFLogicCodeCat();

    public String getSFLogicCodeType();
}

