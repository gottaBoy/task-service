/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.entity.IEntity
 */
package SA.SRFDA.PS.Core.ResBooking;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.ResBooking.IPSBookingResType;
import SA.SRFDA.PS.Core.ResBooking.IPSResBookingDispatcherContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.entity.IEntity;

public interface IPSResBooking
extends IPSObject {
    public static final int ACTION_INIT = 1;
    public static final int ACTION_UNINIT = 4;
    public static final int ACTION_INFORM = 10;
    public static final int STATE_UNKNOWN = 0;
    public static final int STATE_NOTBEGIN = 10;
    public static final int STATE_READYSTART = 15;
    public static final int STATE_INUSE = 20;
    public static final int STATE_READYSTOP = 25;
    public static final int STATE_FINISH = 30;
    public static final int STATE_CANCELED = 40;
    public static final int STATE_EXPIRED = 41;

    public void init(ISRFDAGlobalHelper var1, IPSResBookingDispatcherContext var2, IEntity var3) throws Exception;

    public int getState();

    public long getBeginTime();

    public long getEndTime();

    public boolean run();

    public boolean isRunning();

    public void syncEntity(IEntity var1) throws Exception;

    public String getBookingResType();

    public IPSBookingResType getPSBookingResType();

    public IEntity getResBookingData();

    public void close();
}

