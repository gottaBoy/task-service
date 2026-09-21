/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.WF.IPSWFProcess;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;

@PSModelPFIgnoreMeta
public interface IPSWFCallActivityProcess
extends IPSWFProcess {
    public IPSWorkflow getTargetPSWF();

    public String getMultiInstMode();
}

