/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys
 *  net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevCenter;

import SA.SRFDA.PS.Core.DevCenter.DevSlnSysPSDCBKTaskImplBase;
import SA.SRFramework.Utility.StringHelper;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class CreateDevSlnSys2PSDCBKTaskImpl
extends DevSlnSysPSDCBKTaskImplBase {
    private static final Log log = LogFactory.getLog(CreateDevSlnSys2PSDCBKTaskImpl.class);

    protected String onRun() throws Exception {
        PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
        psDevSlnSys.setPSDevSlnSysId(this.getTaskParam());
        psDevSlnSysService.get((IEntity)psDevSlnSys);
        String strOwnerId = StringHelper.Format((String)"%1$s|%2$s", (Object)psDevSlnSysService.getDEModel().getName(), (Object)psDevSlnSys.getPSDevSlnSysId());
        try {
            PSDevSlnSys psDevSlnSys2 = new PSDevSlnSys();
            psDevSlnSys2.setPSDevSlnSysId(this.getTaskParam());
            psDevSlnSysService.bindSysModel(psDevSlnSys2);
            psDevSlnSys.setPSDevSlnSysId(this.getTaskParam());
            psDevSlnSysService.get((IEntity)psDevSlnSys);
            if (StringHelper.Compare((String)psDevSlnSys.getActionOwner(), (String)strOwnerId, (boolean)false) == 0) {
                psDevSlnSys2 = new PSDevSlnSys();
                psDevSlnSys2.setPSDevSlnSysId(this.getTaskParam());
                psDevSlnSys2.setActionOwner(null);
                psDevSlnSys2.setCurAction("NONE");
                psDevSlnSysService.sysUpdate((IEntity)psDevSlnSys2, false);
            }
            return "\u7ed1\u5b9a\u6210\u529f";
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u7ed1\u5b9a\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)this.getTaskParam(), (Object)ex.getMessage()), (Throwable)ex);
            try {
                psDevSlnSys.setPSDevSlnSysId(this.getTaskParam());
                psDevSlnSysService.get((IEntity)psDevSlnSys);
                if (StringHelper.Compare((String)psDevSlnSys.getActionOwner(), (String)strOwnerId, (boolean)false) == 0) {
                    PSDevSlnSys psDevSlnSys2 = new PSDevSlnSys();
                    psDevSlnSys2.setPSDevSlnSysId(this.getTaskParam());
                    psDevSlnSys2.setActionOwner(null);
                    psDevSlnSys2.setCurAction("NONE");
                    psDevSlnSys2.setDevSysState(Integer.valueOf(42));
                    psDevSlnSysService.sysUpdate((IEntity)psDevSlnSys2, false);
                }
            }
            catch (Exception e) {
                log.error((Object)e);
            }
            throw ex;
        }
    }
}

