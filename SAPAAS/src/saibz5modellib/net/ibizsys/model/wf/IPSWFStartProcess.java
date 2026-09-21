/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.wf;

import net.ibizsys.model.wf.IPSWFProcess;

public interface IPSWFStartProcess
extends IPSWFProcess {
    public String getStartPSDEViewId();

    public String getMobStartPSDEViewId();

    public String getStartPSDEViewUserData();

    public String getMobStartPSDEViewUserData();
}

