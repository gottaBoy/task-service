/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.app.view;

import java.util.Iterator;
import net.ibizsys.model.app.view.IPSAppView;

public interface IPSAppRedirectView
extends IPSAppView {
    public static final String VIEWREFMODE_RDITEM = "RDITEM";

    public Iterator<IPSAppView> getRedirectPSAppViews();

    public Iterator<String> getRedirectModes();

    public Iterator<String> getRefRedirectModes();

    public IPSAppView getRedirectPSAppView(String var1, boolean var2) throws Exception;
}

