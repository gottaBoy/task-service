/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.app.view;

import net.ibizsys.model.app.view.IPSAppDEWFView;
import net.ibizsys.model.wf.IPSWFInteractiveProcess;

public interface IPSAppDEWFActionView
extends IPSAppDEWFView {
    public String getWFStepValue();

    public IPSWFInteractiveProcess getPSWFInteractiveProcess();
}

