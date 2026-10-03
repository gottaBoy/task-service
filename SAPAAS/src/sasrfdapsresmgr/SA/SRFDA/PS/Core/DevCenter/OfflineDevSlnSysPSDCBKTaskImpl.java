/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Util.PSDevSlnSysHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DateHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.codelist.BackendActionStateCodeListModel
 *  net.ibizsys.pscore.srv.codelist.DevSysStateCodeListModel
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDCSysInstAction
 *  net.ibizsys.pscore.srv.devcenter.service.PSDCSysInstActionService
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys
 *  net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService
 *  net.ibizsys.pscore.srv.util.PSCoreEntityKeeperGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevCenter;

import SA.SRFDA.PS.Core.DevCenter.DevSlnSysPSDCBKTaskImplBase;
import SA.SRFDA.PS.Core.Util.PSDevSlnSysHelper;
import SA.SRFramework.Utility.StringHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.codelist.BackendActionStateCodeListModel;
import net.ibizsys.pscore.srv.codelist.DevSysStateCodeListModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCSysInstAction;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSysInstActionService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.util.PSCoreEntityKeeperGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class OfflineDevSlnSysPSDCBKTaskImpl
extends DevSlnSysPSDCBKTaskImplBase {
    private static final Log log = LogFactory.getLog(OfflineDevSlnSysPSDCBKTaskImpl.class);

    protected String onRun() throws Exception {
        PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
        PSDCSysInstActionService psDCSysInstActionService = (PSDCSysInstActionService)ServiceGlobal.getService(PSDCSysInstActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDCSysInstAction psDCSysInstAction = new PSDCSysInstAction();
        PSDCSysInstAction psDCSysInstAction2 = new PSDCSysInstAction();
        String strOwnerId = StringHelper.Format((String)"%1$s|%2$s", (Object)psDCSysInstActionService.getDEModel().getName(), (Object)this.getTaskParam2());
        try {
            psDevSlnSys.setPSDevSlnSysId(this.getTaskParam());
            psDevSlnSysService.get(psDevSlnSys);
            if (StringHelper.Compare((String)psDevSlnSys.getActionOwner(), (String)strOwnerId, (boolean)false) != 0) {
                throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u5f53\u524d\u6240\u6709\u8005\u4e0d\u4e3a\u5f53\u524d\u4efb\u52a1\uff0c\u65e0\u6cd5\u79bb\u7ebf\u7cfb\u7edf", (Object)psDevSlnSys.getPSDevSlnSysName()));
            }
            PSDevSlnSys psDevSlnSys2 = new PSDevSlnSys();
            psDevSlnSys2.setPSDevSlnSysId(this.getTaskParam());
            psDevSlnSys2.setDevSysState(DevSysStateCodeListModel.MAINTAIN);
            psDevSlnSysService.sysUpdate(psDevSlnSys2, true);
            PSCoreEntityKeeperGlobal.getCurrent((SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory()).updatePSDevSlnSys(psDevSlnSys2);
            psDCSysInstAction.setPSDCSysInstActionId(this.getTaskParam2());
            psDCSysInstActionService.get(psDCSysInstAction);
            psDCSysInstAction2.setPSDCSysInstActionId(this.getTaskParam2());
            psDCSysInstAction2.setBeginTime(DateHelper.getCurTime());
            psDCSysInstAction2.setActionState(BackendActionStateCodeListModel.CREATING);
            psDCSysInstActionService.sysUpdate(psDCSysInstAction2, false);
            this.updatePSSysModelInstVer(psDevSlnSys);
            PSDevSlnSysHelper.offline((String)psDevSlnSys.getPSDevSlnSysId(), null);
            psDevSlnSys.reset();
            psDevSlnSys.setPSDevSlnSysId(this.getTaskParam());
            psDevSlnSysService.get(psDevSlnSys);
            if (StringHelper.Compare((String)psDevSlnSys.getActionOwner(), (String)strOwnerId, (boolean)false) == 0) {
                psDevSlnSys2 = new PSDevSlnSys();
                psDevSlnSys2.setPSDevSlnSysId(this.getTaskParam());
                psDevSlnSys2.setActionOwner(null);
                psDevSlnSys2.setCurAction("NONE");
                psDevSlnSys2.setDevSysState(DevSysStateCodeListModel.OFFLINE);
                psDevSlnSysService.sysUpdate(psDevSlnSys2, false);
                PSCoreEntityKeeperGlobal.getCurrent((SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory()).updatePSDevSlnSys(psDevSlnSys2);
            } else {
                psDevSlnSys2 = new PSDevSlnSys();
                psDevSlnSys2.setPSDevSlnSysId(this.getTaskParam());
                psDevSlnSysService.sysUpdate(psDevSlnSys2, false);
                PSCoreEntityKeeperGlobal.getCurrent((SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory()).updatePSDevSlnSys(psDevSlnSys2);
            }
            psDCSysInstAction.reset();
            psDCSysInstAction2.setPSDCSysInstActionId(this.getTaskParam2());
            psDCSysInstAction2.setEndTime(DateHelper.getCurTime());
            psDCSysInstAction2.setActionState(BackendActionStateCodeListModel.CREATED);
            psDCSysInstActionService.sysUpdate(psDCSysInstAction2, false);
            return "\u79bb\u7ebf\u6210\u529f";
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u79bb\u7ebf\u5f00\u53d1\u7cfb\u7edf[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)this.getTaskParam(), (Object)ex.getMessage()), (Throwable)ex);
            try {
                psDevSlnSys.setPSDevSlnSysId(this.getTaskParam());
                psDevSlnSysService.get(psDevSlnSys);
                if (StringHelper.Compare((String)psDevSlnSys.getActionOwner(), (String)strOwnerId, (boolean)false) == 0) {
                    PSDevSlnSys psDevSlnSys2 = new PSDevSlnSys();
                    psDevSlnSys2.setPSDevSlnSysId(this.getTaskParam());
                    psDevSlnSys2.setActionOwner(null);
                    psDevSlnSys2.setCurAction("NONE");
                    psDevSlnSys2.setDevSysState(DevSysStateCodeListModel.ONLINE);
                    psDevSlnSysService.sysUpdate(psDevSlnSys2, true);
                    PSCoreEntityKeeperGlobal.getCurrent((SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory()).updatePSDevSlnSys(psDevSlnSys2);
                }
            }
            catch (Exception e) {
                log.error((Object)e);
            }
            try {
                psDCSysInstAction.reset();
                psDCSysInstAction2.setPSDCSysInstActionId(this.getTaskParam2());
                psDCSysInstAction2.setEndTime(DateHelper.getCurTime());
                psDCSysInstAction2.setActionState(BackendActionStateCodeListModel.FAILED);
                psDCSysInstActionService.sysUpdate(psDCSysInstAction2, false);
            }
            catch (Exception e) {
                log.error((Object)e);
            }
            throw ex;
        }
    }
}
