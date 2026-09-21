/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.DevStudio.IPSBKTask;
import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskSessionContext;
import SA.SRFDA.PS.Core.DevStudio.IPSSysDevBKTask;
import SA.SRFDA.PS.Core.DevStudio.IPSSysDevBKTaskSessionContext;
import SA.SRFDA.PS.Core.DevStudio.PSBKTaskHandler;

public class PSSysDevBKTaskHandler
extends PSBKTaskHandler {
    private IPSSysDevBKTask iPSSysDevBKTask = null;
    private IPSSysDevBKTaskSessionContext iPSSysDevBKTaskSessionContext = null;

    public PSSysDevBKTaskHandler(IPSBKTask iPSBKTask, IPSBKTaskSessionContext iPSBKTaskSessionContext) {
        super(iPSBKTask, iPSBKTaskSessionContext);
        this.iPSSysDevBKTask = (IPSSysDevBKTask)iPSBKTask;
        this.iPSSysDevBKTaskSessionContext = (IPSSysDevBKTaskSessionContext)iPSBKTaskSessionContext;
    }

    public IPSSysDevBKTask getPSSysDevBKTask() {
        return this.iPSSysDevBKTask;
    }
}

