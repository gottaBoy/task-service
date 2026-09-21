/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DevCenter;

import SA.SRFDA.PS.Core.DevCenter.IPSDevCenterBKTask;
import SA.SRFDA.PS.Core.DevCenter.IPSDevCenterBKTaskSessionContext;
import SA.SRFDA.PS.Core.DevStudio.IPSBKTask;
import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskSessionContext;
import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskWork2;
import SA.SRFDA.PS.Core.DevStudio.PSBKTaskHandler;
import SA.SRFDA.PS.Core.DevStudio.PSBKTaskWorkHelper;

public class PSDevCenterBKTaskHandler
extends PSBKTaskHandler {
    private IPSDevCenterBKTask iPSDevCenterBKTask = null;
    private IPSDevCenterBKTaskSessionContext iPSDevCenterBKTaskSessionContext = null;

    public PSDevCenterBKTaskHandler(IPSBKTask iPSBKTask, IPSBKTaskSessionContext iPSBKTaskSessionContext) {
        super(iPSBKTask, iPSBKTaskSessionContext);
        this.iPSDevCenterBKTask = (IPSDevCenterBKTask)iPSBKTask;
        this.iPSDevCenterBKTaskSessionContext = (IPSDevCenterBKTaskSessionContext)iPSBKTaskSessionContext;
    }

    public IPSDevCenterBKTask getPSDevCenterBKTask() {
        return this.iPSDevCenterBKTask;
    }

    @Override
    public void run() {
        PSBKTaskWorkHelper.execute(new IPSBKTaskWork2(){

            @Override
            public void execute(Object obj) {
                PSDevCenterBKTaskHandler.this.onRun();
            }
        });
    }

    @Override
    protected void onRun() {
        this.iPSDevCenterBKTask.run(this.iPSDevCenterBKTaskSessionContext);
    }

    @Override
    public void cancel(boolean bUserCancel, String strReason) {
        final boolean bUserCancel2 = bUserCancel;
        final String strReason2 = strReason;
        PSBKTaskWorkHelper.execute(new IPSBKTaskWork2(){

            @Override
            public void execute(Object obj) {
                PSDevCenterBKTaskHandler.this.onCancel(bUserCancel2, strReason2);
            }
        });
    }

    @Override
    protected void onCancel(boolean bUserCancel, String strReason) {
        this.iPSDevCenterBKTask.cancel(bUserCancel, strReason);
    }
}

