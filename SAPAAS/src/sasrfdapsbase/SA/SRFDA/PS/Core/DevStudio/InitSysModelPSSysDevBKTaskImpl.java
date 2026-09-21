/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ActionSessionManager
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystem
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSystemService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.DevStudio.PSSysDevBKTaskImplBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class InitSysModelPSSysDevBKTaskImpl
extends PSSysDevBKTaskImplBase {
    private static final Log log = LogFactory.getLog(InitSysModelPSSysDevBKTaskImpl.class);

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected String onRun() throws Exception {
        PSSystemService psSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        PSSystem psSystem2 = new PSSystem();
        psSystem2.setPSSystemId(this.psSysDevBKTask.getTASKPARAM());
        psSystemService.get((IEntity)psSystem2);
        try {
            PSCoreSysServiceBase.setCurrentPSDevSlnSysId((String)this.getPSDevSlnSysId());
            PSCoreSysServiceBase.setCurrentPSSystemId((String)psSystem2.getPSSystemId());
            SessionFactoryManager.addRef();
            String strResult = this.initSyncModel(psSystem2);
            SessionFactoryManager.releaseRef((boolean)true);
            PSCoreSysServiceBase.setCurrentPSSystemId(null);
            PSCoreSysServiceBase.setCurrentPSDevSlnSysId(null);
            return strResult;
        }
        catch (Exception ex) {
            PSCoreSysServiceBase.setCurrentPSSystemId(null);
            PSCoreSysServiceBase.setCurrentPSDevSlnSysId(null);
            SessionFactoryManager.releaseRef((boolean)false);
            throw ex;
        }
    }

    protected String initSyncModel(PSSystem psSystem) throws Exception {
        StringBuilderEx sBuilderEx = new StringBuilderEx();
        ActionSessionManager.openSession((String)"");
        try {
            sBuilderEx.append("\u521d\u59cb\u5316\u7cfb\u7edf\u6a21\u578b\u5f00\u59cb\r\n");
            PSSystemService psSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
            psSystemService.executeAction("INITMODEL", (IEntity)psSystem);
            sBuilderEx.append(ActionSessionManager.getCurrentSession().getActionInfo());
            sBuilderEx.append("\u521d\u59cb\u5316\u7cfb\u7edf\u6a21\u578b\u5b8c\u6210\u3002");
            ActionSessionManager.closeSession();
            return sBuilderEx.toString();
        }
        catch (Exception ex) {
            ActionSessionManager.closeSession();
            throw ex;
        }
    }
}

