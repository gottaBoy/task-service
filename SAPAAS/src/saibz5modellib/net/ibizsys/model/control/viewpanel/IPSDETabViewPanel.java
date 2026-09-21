/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.viewpanel;

import net.ibizsys.model.control.counter.IPSSysCounterRef;
import net.ibizsys.model.control.viewpanel.IPSDEViewPanel;

public interface IPSDETabViewPanel
extends IPSDEViewPanel {
    public IPSSysCounterRef getPSSysCounterRef();

    public String getCounterId();
}

