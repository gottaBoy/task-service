/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.app.view;

import java.util.Iterator;
import net.ibizsys.model.app.func.IPSAppFunc;
import net.ibizsys.model.app.view.IPSAppView;

public interface IPSAppPortalView
extends IPSAppView {
    @Override
    public Iterator<IPSAppFunc> getPSAppFuncs();

    public boolean isDefaultPage();
}

