/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.ResBooking;

import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskWork2;
import SA.SRFDA.PS.Core.DevStudio.PSBKTaskWorkHelper;
import SA.SRFDA.PS.Core.ResBooking.IPSResBooking;
import SA.SRFDA.PS.Core.ResBooking.IPSResBookingHandler;
import SA.SRFDA.PS.Core.ResBooking.IPSResBookingRuntime;

public abstract class PSResBookingHandler
implements IPSResBookingHandler {
    private IPSResBookingRuntime iPSResBookingRuntime = null;

    public PSResBookingHandler(IPSResBookingRuntime iPSResBookingRuntime) {
        this.iPSResBookingRuntime = iPSResBookingRuntime;
        this.iPSResBookingRuntime.setRunning(true);
    }

    public IPSResBooking getPSResBooking() {
        return this.iPSResBookingRuntime;
    }

    @Override
    public void run() {
        PSBKTaskWorkHelper.execute(new IPSBKTaskWork2(){

            @Override
            public void execute(Object obj) {
                PSResBookingHandler.this.onRun();
                PSResBookingHandler.this.iPSResBookingRuntime.setRunning(false);
            }
        });
    }

    protected abstract void onRun();
}

