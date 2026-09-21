/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.WF.IPSWFTimerEventProcess;
import SA.SRFDA.PS.Core.WF.PSWFProcessImpl;

@PSModelImplementMeta(implement="IPSWFProcess", typevalues={"TIMEREVENT"})
@PSModelPFIgnoreMeta
public class PSWFTimerEventProcessImpl
extends PSWFProcessImpl
implements IPSWFTimerEventProcess {
    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }
}

