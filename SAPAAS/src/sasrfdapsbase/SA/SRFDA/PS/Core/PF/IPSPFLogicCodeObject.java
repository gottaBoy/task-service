/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.PF.IPSPFPlugin;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSPFLogicCodeObject {
    public static final String LOGICCODECAT_APPFUNC = "APPFUNC";
    public static final String LOGICCODECAT_UIACTION = "UIACTION";
    public static final String LOGICCODECAT_VIEWLOGIC = "VIEWLOGIC";
    public static final String LOGICCODECAT_CODELIST = "CODELIST";
    public static final String LOGICCODECAT_APPUTIL = "APPUTIL";
    public static final String LOGICCODECAT_COUNTER = "COUNTER";
    public static final String LOGICCODECAT_VALUERULE = "VALUERULE";
    public static final String LOGICCODECAT_THRESHOLDGROUP = "THRESHOLDGROUP";
    public static final String LOGICCODECAT_MSGTEMPL = "MSGTEMPL";
    public static final String LOGICCODECAT_DEFINPUTTIPSET = "DEFINPUTTIPSET";

    public String getPFLogicCodeCat();

    public String getPFLogicCodeType();

    public IPSPFPlugin getPSPFPlugin();
}

