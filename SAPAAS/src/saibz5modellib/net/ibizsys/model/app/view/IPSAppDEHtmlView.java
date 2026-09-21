/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.app.view;

import net.ibizsys.model.app.view.IPSAppDEView;

public interface IPSAppDEHtmlView
extends IPSAppDEView {
    public static final String VIEWPARAM_UI_HTMLURL = "UI.HTMLURL";
    public static final String VIEWPARAM_UI_HTMLURLKEY = "UI.HTMLURLKEY";

    public String getHtmlUrl();
}

