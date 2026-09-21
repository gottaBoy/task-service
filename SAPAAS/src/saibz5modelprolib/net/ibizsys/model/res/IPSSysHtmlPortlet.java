/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.res.IPSSysPortlet
 */
package net.ibizsys.model.res;

import net.ibizsys.model.res.IPSSysPortlet;

public interface IPSSysHtmlPortlet
extends IPSSysPortlet {
    public static final String HTMLSHOWMODE_INNER = "INNER";
    public static final String HTMLSHOWMODE_IFRAME = "IFRAME";

    public String getPageUrl();

    public String getHtmlShowMode();
}

