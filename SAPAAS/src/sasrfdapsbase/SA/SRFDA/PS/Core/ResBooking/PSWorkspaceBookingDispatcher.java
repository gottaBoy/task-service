/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.paasmgr.service.PSWSBookingService
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.ResBooking;

import SA.SRFDA.PS.Core.ResBooking.IPSResBooking;
import SA.SRFDA.PS.Core.ResBooking.PSResBookingDispatcherBase;
import SA.SRFDA.PS.Core.ResBooking.PSWorkspaceBookingImpl;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSWSBookingService;
import org.hibernate.SessionFactory;

public class PSWorkspaceBookingDispatcher
extends PSResBookingDispatcherBase {
    private PSWSBookingService psWSBookingService = null;

    @Override
    protected void onInit() throws Exception {
        this.psWSBookingService = (PSWSBookingService)ServiceGlobal.getService(PSWSBookingService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        super.onInit();
    }

    @Override
    protected String onCalcQuerySql() {
        String strSQL = "SELECT * FROM T_SRFPSWSBOOKING T1 WHERE T1.PSSVRDOMAINID=?  AND (T1.BEGINTIME <= ? AND T1.ENDTIME >= ?) AND ( T1.BOOKINGSTATE >=10 AND T1.BOOKINGSTATE <30) AND (t1.BOOKINGTYPE='DCRES') ";
        return strSQL;
    }

    @Override
    protected IService getService() {
        return this.psWSBookingService;
    }

    @Override
    protected IPSResBooking createPSResBooking(IEntity iEntity) throws Exception {
        PSWorkspaceBookingImpl psWSBookingImpl = new PSWorkspaceBookingImpl();
        psWSBookingImpl.init(this.getDAGlobalHelper(), this, iEntity);
        return psWSBookingImpl;
    }
}

