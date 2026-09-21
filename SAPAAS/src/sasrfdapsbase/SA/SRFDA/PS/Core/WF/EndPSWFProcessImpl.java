/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.WF.IPSWFEndProcess;
import SA.SRFDA.PS.Core.WF.PSWFProcessImpl;

@PSModelImplementMeta(implement="IPSWFProcess", typevalues={"END"})
@PSModelPFIgnoreMeta
public class EndPSWFProcessImpl
extends PSWFProcessImpl
implements IPSWFEndProcess {
    @Override
    @PSModelRTMeta(description="\u7ed3\u675f\u72b6\u6001\u503c", fields={"EXITSTATEVALUE"})
    public String getExitStateValue() {
        return this.psWFProcess.getEXITSTATEVALUE();
    }

    @Override
    @PSModelRTMeta(description="\u7ec8\u6b62\u5904\u7406", staticcode="true")
    public boolean isTerminalProcess() {
        return true;
    }

    @Override
    protected int getDefaultWidth() {
        return 30;
    }

    @Override
    protected int getDefaultHeight() {
        return 30;
    }
}

