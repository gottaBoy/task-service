/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ImportSessionManager
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysAPI
 *  net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysAPIService
 *  net.ibizsys.pscore.srv.util.PSDevSlnSysAPIClientHelper2
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.DevStudio.PSSysDevBKTaskImplBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ImportSessionManager;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysAPI;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysAPIService;
import net.ibizsys.pscore.srv.util.PSDevSlnSysAPIClientHelper2;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class SyncServiceAPIClientModelPSSysDevBKTaskImpl
extends PSSysDevBKTaskImplBase {
    private static final Log log = LogFactory.getLog(SyncServiceAPIClientModelPSSysDevBKTaskImpl.class);

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected String onRun() throws Exception {
        String strPSDevSlnSysAPIId = KeyValueHelper.genUniqueId((String)this.psSysDevBKTask.getPSDEVSLNSYSID(), (String)this.psSysDevBKTask.getTASKPARAM());
        PSDevSlnSysAPIService psDevSlnSysAPIService = (PSDevSlnSysAPIService)ServiceGlobal.getService(PSDevSlnSysAPIService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevSlnSysAPI psDevSlnSysAPI2 = new PSDevSlnSysAPI();
        psDevSlnSysAPI2.setPSDevSlnSysAPIId(strPSDevSlnSysAPIId);
        psDevSlnSysAPIService.get((IEntity)psDevSlnSysAPI2);
        try {
            SessionFactoryManager.addRef();
            String strResult = this.syncPSDevSlnSysAPI(psDevSlnSysAPI2);
            SessionFactoryManager.releaseRef((boolean)true);
            return strResult;
        }
        catch (Exception ex) {
            SessionFactoryManager.releaseRef((boolean)false);
            throw ex;
        }
    }

    protected String syncPSDevSlnSysAPI(PSDevSlnSysAPI psDevSlnSysAPI) throws Exception {
        PSDevSlnSysAPIClientHelper2 psDevSlnSysAPIClientHelper;
        StringBuilderEx sBuilderEx = new StringBuilderEx();
        if (StringHelper.isNullOrEmpty((String)psDevSlnSysAPI.getClientPSDevSlnSysId()) && StringHelper.isNullOrEmpty((String)psDevSlnSysAPI.getClient2PSDevSlnSysId())) {
            return "\u6ca1\u6709\u6307\u5b9a\u540c\u6b65\u7684\u5ba2\u6237\u7aef\u7cfb\u7edf";
        }
        if (!StringHelper.isNullOrEmpty((String)psDevSlnSysAPI.getClientPSDevSlnSysId())) {
            if (StringHelper.compare((String)psDevSlnSysAPI.getPSDevSlnSysId(), (String)psDevSlnSysAPI.getClientPSDevSlnSysId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u540c\u6b65\u5ba2\u6237\u7aef\u7cfb\u7edf\u4e0d\u80fd\u4e0e\u63a5\u53e3\u6240\u5c5e\u5f00\u53d1\u7cfb\u7edf\u4e00\u81f4"));
            }
            try {
                if (psDevSlnSysAPI.getClientPSDevSlnSys() != null) {
                    ImportSessionManager.openSession();
                    if (StringHelper.compare((String)psDevSlnSysAPI.getClientPSDevSlnSys().getTemplEngine(), (String)"V2", (boolean)false) == 0) {
                        psDevSlnSysAPIClientHelper = new PSDevSlnSysAPIClientHelper2();
                        psDevSlnSysAPIClientHelper.init(psDevSlnSysAPI, psDevSlnSysAPI.getClientPSDevSlnSys());
                        psDevSlnSysAPIClientHelper.sync();
                    } else {
                        psDevSlnSysAPIClientHelper = new PSDevSlnSysAPIClientHelper2();
                        psDevSlnSysAPIClientHelper.init(psDevSlnSysAPI, psDevSlnSysAPI.getClientPSDevSlnSys());
                        psDevSlnSysAPIClientHelper.sync();
                    }
                    ImportSessionManager.closeSession();
                    sBuilderEx.append(StringHelper.format((String)"\u540c\u6b65\u5ba2\u6237\u7aef\u7cfb\u7edf[%1$s]\u5b8c\u6210\r\n", (Object)psDevSlnSysAPI.getClientPSDevSlnSys().getPSDevSlnSysName()));
                }
            }
            catch (Exception ex) {
                ImportSessionManager.closeSession();
                sBuilderEx.append(StringHelper.format((String)"\u540c\u6b65\u5ba2\u6237\u7aef\u7cfb\u7edf[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s\r\n", (Object)psDevSlnSysAPI.getClientPSDevSlnSys().getPSDevSlnSysName(), (Object)ex.getMessage()));
                log.error((Object)ex);
            }
        }
        if (!StringHelper.isNullOrEmpty((String)psDevSlnSysAPI.getClient2PSDevSlnSysId())) {
            if (StringHelper.compare((String)psDevSlnSysAPI.getPSDevSlnSysId(), (String)psDevSlnSysAPI.getClient2PSDevSlnSysId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u540c\u6b65\u5ba2\u6237\u7aef\u7cfb\u7edf2\u4e0d\u80fd\u4e0e\u63a5\u53e3\u6240\u5c5e\u5f00\u53d1\u7cfb\u7edf\u4e00\u81f4"));
            }
            try {
                if (psDevSlnSysAPI.getClient2PSDevSlnSys() != null) {
                    ImportSessionManager.openSession();
                    if (StringHelper.compare((String)psDevSlnSysAPI.getClientPSDevSlnSys().getTemplEngine(), (String)"V2", (boolean)false) == 0) {
                        psDevSlnSysAPIClientHelper = new PSDevSlnSysAPIClientHelper2();
                        psDevSlnSysAPIClientHelper.init(psDevSlnSysAPI, psDevSlnSysAPI.getClient2PSDevSlnSys());
                        psDevSlnSysAPIClientHelper.sync();
                    } else {
                        psDevSlnSysAPIClientHelper = new PSDevSlnSysAPIClientHelper2();
                        psDevSlnSysAPIClientHelper.init(psDevSlnSysAPI, psDevSlnSysAPI.getClient2PSDevSlnSys());
                        psDevSlnSysAPIClientHelper.sync();
                    }
                    ImportSessionManager.closeSession();
                    sBuilderEx.append(StringHelper.format((String)"\u540c\u6b65\u5ba2\u6237\u7aef\u7cfb\u7edf[%1$s]\u5b8c\u6210\r\n", (Object)psDevSlnSysAPI.getClient2PSDevSlnSys().getPSDevSlnSysName()));
                }
            }
            catch (Exception ex) {
                ImportSessionManager.closeSession();
                sBuilderEx.append(StringHelper.format((String)"\u540c\u6b65\u5ba2\u6237\u7aef\u7cfb\u7edf[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s\r\n", (Object)psDevSlnSysAPI.getClient2PSDevSlnSys().getPSDevSlnSysName(), (Object)ex.getMessage()));
                log.error((Object)ex);
            }
        }
        return sBuilderEx.toString();
    }
}

