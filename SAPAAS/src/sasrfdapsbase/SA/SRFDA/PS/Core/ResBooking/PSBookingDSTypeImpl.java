/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSDSBooking
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSDevServer
 *  net.ibizsys.pscore.srv.paasmgr.service.PSDSBookingLogService
 *  net.ibizsys.pscore.srv.paasmgr.service.PSDSBookingService
 *  net.ibizsys.pscore.srv.paasmgr.service.PSDevServerService
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.ResBooking;

import SA.SRFDA.PS.Core.Deploy.IPSDevServerType;
import SA.SRFDA.PS.Core.ResBooking.IPSBookingDSType;
import SA.SRFDA.PS.Core.ResBooking.IPSResBooking;
import SA.SRFDA.PS.Core.ResBooking.PSBookingResTypeImpl;
import SA.SRFDA.PS.Core.Util.PasswordHelper;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import java.util.Random;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDSBooking;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDevServer;
import net.ibizsys.pscore.srv.paasmgr.service.PSDSBookingLogService;
import net.ibizsys.pscore.srv.paasmgr.service.PSDSBookingService;
import net.ibizsys.pscore.srv.paasmgr.service.PSDevServerService;
import org.hibernate.SessionFactory;

public class PSBookingDSTypeImpl
extends PSBookingResTypeImpl
implements IPSBookingDSType {
    private PSDSBookingService psDSBookingService = null;
    private PSDSBookingLogService psDSBookingLogService = null;
    private PSDevServerService psDevServerService = null;
    private static Random random = new Random();

    @Override
    protected void onInit() throws Exception {
        this.psDSBookingService = (PSDSBookingService)ServiceGlobal.getService(PSDSBookingService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        this.psDevServerService = (PSDevServerService)ServiceGlobal.getService(PSDevServerService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        super.onInit();
    }

    @Override
    protected void onInitResBooking(IPSResBooking iPSResBooking) throws Exception {
        PSDSBooking psDSBooking = (PSDSBooking)iPSResBooking.getResBookingData();
        PSDevServer psDevServer = new PSDevServer();
        psDevServer.setPSDevServerId(psDSBooking.getPSDevServerId());
        this.psDevServerService.get((IEntity)psDevServer);
        String strNewPassword = PasswordHelper.generate();
        psDevServer.setPasswd(strNewPassword);
        this.psDevServerService.update((IEntity)psDevServer);
        SA.SRFDA.PS.Data.PSDevServer psDevServerV3 = new SA.SRFDA.PS.Data.PSDevServer();
        PSDEDataCtrl.convertEntity((IEntity)psDevServer, psDevServerV3);
        IPSDevServerType iPSDevServerType = this.getPSModelStorage().getPSDevServerType(psDevServer.getDSType());
        iPSDevServerType.initBookingRes(psDevServerV3);
        super.initResBooking(iPSResBooking);
    }

    @Override
    protected void onUninitResBooking(IPSResBooking iPSResBooking) throws Exception {
        PSDSBooking psDSBooking = (PSDSBooking)iPSResBooking.getResBookingData();
        PSDevServer psDevServer = new PSDevServer();
        psDevServer.setPSDevServerId(psDSBooking.getPSDevServerId());
        this.psDevServerService.get((IEntity)psDevServer);
        String strNewPassword = PasswordHelper.generate();
        psDevServer.setPasswd(strNewPassword);
        this.psDevServerService.update((IEntity)psDevServer);
        SA.SRFDA.PS.Data.PSDevServer psDevServerV3 = new SA.SRFDA.PS.Data.PSDevServer();
        PSDEDataCtrl.convertEntity((IEntity)psDevServer, psDevServerV3);
        IPSDevServerType iPSDevServerType = this.getPSModelStorage().getPSDevServerType(psDevServer.getDSType());
        iPSDevServerType.uninitBookingRes(psDevServerV3);
        super.onUninitResBooking(iPSResBooking);
    }
}

