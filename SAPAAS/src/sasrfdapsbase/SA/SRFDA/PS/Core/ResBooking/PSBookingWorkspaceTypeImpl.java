/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSWSBooking
 */
package SA.SRFDA.PS.Core.ResBooking;

import SA.SRFDA.PS.Core.ResBooking.IPSBookingWorkspaceType;
import SA.SRFDA.PS.Core.ResBooking.IPSResBooking;
import SA.SRFDA.PS.Core.ResBooking.PSBookingResTypeImpl;
import java.util.Random;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWSBooking;

public class PSBookingWorkspaceTypeImpl
extends PSBookingResTypeImpl
implements IPSBookingWorkspaceType {
    private static Random random = new Random();

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected void onInitResBooking(IPSResBooking iPSResBooking) throws Exception {
        PSWSBooking psWSBooking = (PSWSBooking)iPSResBooking.getResBookingData();
        super.initResBooking(iPSResBooking);
    }

    @Override
    protected void onUninitResBooking(IPSResBooking iPSResBooking) throws Exception {
        PSWSBooking psWSBooking = (PSWSBooking)iPSResBooking.getResBookingData();
        super.onUninitResBooking(iPSResBooking);
    }
}

