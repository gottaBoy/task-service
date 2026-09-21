/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.viewpanel;

import net.ibizsys.model.app.view.IPSAppDEView;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.res.IPSLanguageRes;

public interface IPSDEViewPanel
extends IPSControl {
    public IPSAppDEView getPSAppDEView();

    public String getEmbedViewId();

    public String getCaption();

    public IPSLanguageRes getCapPSLanguageRes();
}

