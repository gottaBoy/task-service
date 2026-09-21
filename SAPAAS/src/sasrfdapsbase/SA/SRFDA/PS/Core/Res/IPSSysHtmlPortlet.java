/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysPortlet;

@PSModelPFIgnoreMeta
public interface IPSSysHtmlPortlet
extends IPSSysPortlet {
    public static final String HTMLSHOWMODE_INNER = "INNER";
    public static final String HTMLSHOWMODE_IFRAME = "IFRAME";

    public String getPageUrl();

    public String getHtmlShowMode();
}

