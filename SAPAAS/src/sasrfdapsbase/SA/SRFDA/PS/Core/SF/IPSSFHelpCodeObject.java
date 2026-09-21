/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSSFHelpCodeObject {
    public static final String HELPCODECAT_HELPPRJ = "HELPPRJ";
    public static final String HELPCODECAT_HELPARTICLE = "HELPARTICLE";
    public static final String HELPCODECAT_HELPSECTION = "HELPSECTION";
    public static final String HELPCODECAT_HELPMODULE = "HELPMODULE";

    public String getSFHelpCodeCat();

    public String getSFHelpCodeType();
}

