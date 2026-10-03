/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSASBooking
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSAppServer
 *  net.ibizsys.pscore.srv.paasmgr.service.PSASBookingLogService
 *  net.ibizsys.pscore.srv.paasmgr.service.PSASBookingService
 *  net.ibizsys.pscore.srv.paasmgr.service.PSAppServerService
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.ResBooking;

import SA.SRFDA.PS.Core.Deploy.IPSAppServerType;
import SA.SRFDA.PS.Core.ResBooking.IPSBookingASType;
import SA.SRFDA.PS.Core.ResBooking.IPSResBooking;
import SA.SRFDA.PS.Core.ResBooking.PSBookingResTypeImpl;
import SA.SRFDA.PS.Core.Util.PasswordHelper;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import java.util.Random;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSASBooking;
import net.ibizsys.pscore.srv.paasmgr.entity.PSAppServer;
import net.ibizsys.pscore.srv.paasmgr.service.PSASBookingLogService;
import net.ibizsys.pscore.srv.paasmgr.service.PSASBookingService;
import net.ibizsys.pscore.srv.paasmgr.service.PSAppServerService;
import org.hibernate.SessionFactory;

public class PSBookingASTypeImpl
extends PSBookingResTypeImpl
implements IPSBookingASType {
    private PSASBookingService psASBookingService = null;
    private PSASBookingLogService psASBookingLogService = null;
    private PSAppServerService psAppServerService = null;
    private static Random random = new Random();

    @Override
    protected void onInit() throws Exception {
        this.psASBookingService = (PSASBookingService)ServiceGlobal.getService(PSASBookingService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        this.psAppServerService = (PSAppServerService)ServiceGlobal.getService(PSAppServerService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        super.onInit();
    }

    @Override
    protected void onInitResBooking(IPSResBooking iPSResBooking) throws Exception {
        PSASBooking psASBooking = (PSASBooking)iPSResBooking.getResBookingData();
        PSAppServer psAppServer = new PSAppServer();
        psAppServer.setPSAppServerId(psASBooking.getPSAppServerId());
        this.psAppServerService.get(psAppServer);
        String strNewPassword = PasswordHelper.generate();
        int nStartPos = DataObject.getIntegerValue((IDataObject)psAppServer, (String)"BEGINPORT", (int)8080);
        int nEndPos = DataObject.getIntegerValue((IDataObject)psAppServer, (String)"ENDPORT", (int)18080);
        int nNewPort = nStartPos + random.nextInt(nEndPos - nStartPos);
        psAppServer.setHttpPort(Integer.valueOf(nNewPort));
        psAppServer.setPasswd(strNewPassword);
        this.psAppServerService.update(psAppServer);
        SA.SRFDA.PS.Data.PSAppServer psAppServerV3 = new SA.SRFDA.PS.Data.PSAppServer();
        PSDEDataCtrl.convertEntity((IEntity)psAppServer, psAppServerV3);
        IPSAppServerType iPSAppServerType = this.getPSModelStorage().getPSAppServerType(psAppServer.getASType());
        iPSAppServerType.initBookingRes(psAppServerV3);
        super.initResBooking(iPSResBooking);
    }

    @Override
    protected void onUninitResBooking(IPSResBooking iPSResBooking) throws Exception {
        PSASBooking psASBooking = (PSASBooking)iPSResBooking.getResBookingData();
        PSAppServer psAppServer = new PSAppServer();
        psAppServer.setPSAppServerId(psASBooking.getPSAppServerId());
        this.psAppServerService.get(psAppServer);
        String strNewPassword = PasswordHelper.generate();
        int nStartPos = DataObject.getIntegerValue((IDataObject)psAppServer, (String)"BEGINPORT", (int)8080);
        int nEndPos = DataObject.getIntegerValue((IDataObject)psAppServer, (String)"ENDPORT", (int)18080);
        int nNewPort = nStartPos + random.nextInt(nEndPos - nStartPos);
        psAppServer.setHttpPort(Integer.valueOf(nNewPort));
        psAppServer.setPasswd(strNewPassword);
        this.psAppServerService.update(psAppServer);
        SA.SRFDA.PS.Data.PSAppServer psAppServerV3 = new SA.SRFDA.PS.Data.PSAppServer();
        PSDEDataCtrl.convertEntity((IEntity)psAppServer, psAppServerV3);
        IPSAppServerType iPSAppServerType = this.getPSModelStorage().getPSAppServerType(psAppServer.getASType());
        iPSAppServerType.uninitBookingRes(psAppServerV3);
        super.onUninitResBooking(iPSResBooking);
    }
}
