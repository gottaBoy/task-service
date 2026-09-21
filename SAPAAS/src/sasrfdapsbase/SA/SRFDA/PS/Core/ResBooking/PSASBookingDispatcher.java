/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.paasmgr.service.PSASBookingService
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.ResBooking;

import SA.SRFDA.PS.Core.ResBooking.IPSResBooking;
import SA.SRFDA.PS.Core.ResBooking.PSASBookingImpl;
import SA.SRFDA.PS.Core.ResBooking.PSResBookingDispatcherBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSASBookingService;
import org.hibernate.SessionFactory;

public class PSASBookingDispatcher
extends PSResBookingDispatcherBase {
    private PSASBookingService psASBookingService = null;

    @Override
    protected void onInit() throws Exception {
        this.psASBookingService = (PSASBookingService)ServiceGlobal.getService(PSASBookingService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        super.onInit();
    }

    @Override
    protected String onCalcQuerySql() {
        String strSQL = "SELECT * FROM T_SRFPSASBOOKING T1 WHERE T1.PSSVRDOMAINID=?  AND (T1.BEGINTIME <= ? AND T1.ENDTIME >= ?) AND ( T1.BOOKINGSTATE >=10 AND T1.BOOKINGSTATE <30) AND (t1.BOOKINGTYPE='DCRES') ";
        return strSQL;
    }

    @Override
    protected IService getService() {
        return this.psASBookingService;
    }

    @Override
    protected IPSResBooking createPSResBooking(IEntity iEntity) throws Exception {
        PSASBookingImpl psASBookingImpl = new PSASBookingImpl();
        psASBookingImpl.init(this.getDAGlobalHelper(), this, iEntity);
        return psASBookingImpl;
    }
}

