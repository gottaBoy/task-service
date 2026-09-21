/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.wf.IPSWFStartProcess
 */
package net.ibizsys.model.wf;

import net.ibizsys.model.wf.IPSWFStartProcess;
import net.ibizsys.model.wf.PSWFProcessImpl;

public class StartPSWFProcessImpl
extends PSWFProcessImpl
implements IPSWFStartProcess {
    @Override
    public boolean isStartProcess() {
        return true;
    }

    public String getStartPSDEViewId() {
        return this.psWFProcess.getPSDEVIEWBASEID();
    }

    public String getMobStartPSDEViewId() {
        return this.psWFProcess.getMOBPSDEVIEWID();
    }

    public String getStartPSDEViewUserData() {
        return this.psWFProcess.getPSDYNADEVIEWTEMPLID();
    }

    public String getMobStartPSDEViewUserData() {
        return this.psWFProcess.getMOBPSDYNADEVIEWTEMPLID();
    }
}

