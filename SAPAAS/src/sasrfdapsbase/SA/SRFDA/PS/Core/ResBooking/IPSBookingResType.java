/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.ResBooking;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.ResBooking.IPSResBooking;
import SA.SRFDA.PS.Data.PSBookingResType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSBookingResType
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSBookingResType var2) throws Exception;

    public void initResBooking(IPSResBooking var1) throws Exception;

    public void restoreResBooking(IPSResBooking var1) throws Exception;

    public void backupResBooking(IPSResBooking var1) throws Exception;

    public void uninitResBooking(IPSResBooking var1) throws Exception;
}

