/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.DevStudio.IPSBKTask;
import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskSessionContext;
import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskWork2;
import SA.SRFDA.PS.Core.DevStudio.PSBKTaskWorkHelper;

public class PSBKTaskHandler
implements Runnable {
    private IPSBKTask iPSBKTask = null;
    private IPSBKTaskSessionContext iPSBKTaskSessionContext = null;

    public PSBKTaskHandler(IPSBKTask iPSBKTask, IPSBKTaskSessionContext iPSBKTaskSessionContext) {
        this.iPSBKTask = iPSBKTask;
        this.iPSBKTaskSessionContext = iPSBKTaskSessionContext;
    }

    public IPSBKTask getPSBKTask() {
        return this.iPSBKTask;
    }

    @Override
    public void run() {
        PSBKTaskWorkHelper.execute(new IPSBKTaskWork2(){

            @Override
            public void execute(Object obj) {
                PSBKTaskHandler.this.onRun();
            }
        });
    }

    protected void onRun() {
        this.iPSBKTask.run(this.iPSBKTaskSessionContext);
    }

    public void cancel(boolean bUserCancel, String strReason) {
        final boolean bUserCancel2 = bUserCancel;
        final String strReason2 = strReason;
        PSBKTaskWorkHelper.execute(new IPSBKTaskWork2(){

            @Override
            public void execute(Object obj) {
                PSBKTaskHandler.this.onCancel(bUserCancel2, strReason2);
            }
        });
    }

    protected void onCancel(boolean bUserCancel, String strReason) {
        this.iPSBKTask.cancel(bUserCancel, strReason);
    }
}

