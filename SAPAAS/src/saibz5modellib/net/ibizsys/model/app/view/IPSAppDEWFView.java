/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.app.view;

import net.ibizsys.model.app.view.IPSAppDEView;
import net.ibizsys.model.dataentity.wf.IPSDEWF;
import net.ibizsys.model.wf.IPSWFVersion;
import net.ibizsys.model.wf.IPSWorkflow;

public interface IPSAppDEWFView
extends IPSAppDEView {
    public IPSDEWF getPSDEWF();

    public IPSWFVersion getPSWFVersion();

    public IPSWorkflow getPSWorkflow();

    public boolean isWFIAMode();
}

