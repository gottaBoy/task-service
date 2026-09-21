/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ImportSessionManager
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystem
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSystemService
 *  net.ibizsys.pscore.srv.sysdevstudio.entity.PSUWCreateDE
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.DevStudio.PSSysDevBKTaskImplBase;
import SA.SRFDA.PS.Core.Util.PSModelCloneHelper3;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ImportSessionManager;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSUWCreateDE;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class CloneDEModelPSSysDevBKTaskImpl
extends PSSysDevBKTaskImplBase {
    private static final Log log = LogFactory.getLog(CloneDEModelPSSysDevBKTaskImpl.class);

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected String onRun() throws Exception {
        PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
        psDevSlnSys.setPSDevSlnSysId(this.getPSDevSlnSysId());
        psDevSlnSys.setSessionFactory(PSCoreSysServiceBase.getCurMajorSessionFactory());
        if (!psDevSlnSys.get(true)) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u5f53\u524d\u5f00\u53d1\u7cfb\u7edf[%1$s]", (Object)this.getPSDevSlnSysId()));
        }
        SessionFactory srcSessionFactory = PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId());
        PSUWCreateDE psUWCreateDE = new PSUWCreateDE();
        psUWCreateDE.setPSUWCreateDEId(this.psSysDevBKTask.getTASKPARAM());
        psUWCreateDE.setSessionFactory(srcSessionFactory);
        if (!psUWCreateDE.get(true)) {
            return StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u514b\u9686\u5b9e\u4f8b\u5411\u5bfc\uff0c\u6807\u8bc6\u4e3a[%1$s]", (Object)psUWCreateDE.getPSUWCreateDEId());
        }
        PSSystemService psSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)srcSessionFactory);
        PSSystem psSystem2 = new PSSystem();
        psSystem2.setPSSystemId(psDevSlnSys.getPSSystemId());
        psSystemService.get((IEntity)psSystem2);
        try {
            PSCoreSysServiceBase.setCurrentPSDevSlnSysId((String)psDevSlnSys.getPSDevSlnSysId());
            PSCoreSysServiceBase.setCurrentPSSystemId((String)psDevSlnSys.getPSSystemId());
            SessionFactoryManager.addRef();
            PSCoreSysServiceBase.beginImpSysModel((PSSystem)psSystem2);
            String strResult = this.cloneDEModel(psUWCreateDE, psSystem2, srcSessionFactory);
            PSCoreSysServiceBase.endImpSysModel();
            SessionFactoryManager.releaseRef((boolean)true);
            PSCoreSysServiceBase.setCurrentPSSystemId(null);
            PSCoreSysServiceBase.setCurrentPSDevSlnSysId(null);
            return strResult;
        }
        catch (Exception ex) {
            PSCoreSysServiceBase.endImpSysModel();
            PSCoreSysServiceBase.setCurrentPSSystemId(null);
            PSCoreSysServiceBase.setCurrentPSDevSlnSysId(null);
            SessionFactoryManager.releaseRef((boolean)false);
            throw ex;
        }
    }

    protected String cloneDEModel(PSUWCreateDE psUWCreateDE, PSSystem psSystem, SessionFactory srcSessionFactory) throws Exception {
        StringBuilderEx sBuilderEx = new StringBuilderEx();
        try {
            ImportSessionManager.openSession();
            PSModelCloneHelper3 psModelCloneHelper = new PSModelCloneHelper3(psSystem, srcSessionFactory, srcSessionFactory, this.getPSSysModelInstId(), this.getPSSysModelInstId());
            sBuilderEx.append(psModelCloneHelper.cloneDataEntities(psUWCreateDE));
            ImportSessionManager.closeSession();
        }
        catch (Exception ex) {
            ImportSessionManager.closeSession();
            throw ex;
        }
        return sBuilderEx.toString();
    }
}

