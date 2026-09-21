/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.wf.IPSWFEndProcess
 */
package net.ibizsys.model.wf;

import net.ibizsys.model.wf.IPSWFEndProcess;
import net.ibizsys.model.wf.PSWFProcessImpl;

public class EndPSWFProcessImpl
extends PSWFProcessImpl
implements IPSWFEndProcess {
    public String getExitStateValue() {
        return this.psWFProcess.getEXITSTATEVALUE();
    }

    @Override
    public boolean isTerminalProcess() {
        return true;
    }
}

