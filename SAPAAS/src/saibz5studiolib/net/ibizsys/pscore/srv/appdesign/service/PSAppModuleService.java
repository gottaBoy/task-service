/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.appdesign.service;

import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppModule;
import net.ibizsys.pscore.srv.appdesign.service.PSAppModuleServiceBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSAppModuleService
extends PSAppModuleServiceBase {
    private static final Log log = LogFactory.getLog(PSAppModuleService.class);

    @Override
    protected void onBeforeCreate(PSAppModule pSAppModule) throws Exception {
        if (pSAppModule.getDefaultFlag() == null) {
            PSAppModule pSAppModule2 = new PSAppModule();
            pSAppModule2.setPSSysAppId(pSAppModule.getPSSysAppId());
            pSAppModule2.setDefaultFlag(1);
            if (!this.existsData(pSAppModule2)) {
                pSAppModule.setDefaultFlag(1);
            }
        } else if (DataObject.getBoolValue((Integer)pSAppModule.getDefaultFlag(), (boolean)false)) {
            PSAppModule pSAppModule3 = new PSAppModule();
            pSAppModule3.setPSSysAppId(pSAppModule.getPSSysAppId());
            pSAppModule3.setDefaultFlag(1);
            if (this.existsData(pSAppModule3)) {
                pSAppModule3.setDefaultFlag(0);
                this.update(pSAppModule3, false);
            }
        }
        super.onBeforeCreate(pSAppModule);
    }

    @Override
    protected void onBeforeUpdate(PSAppModule pSAppModule) throws Exception {
        if (DataObject.getBoolValue((Integer)pSAppModule.getDefaultFlag(), (boolean)false)) {
            PSAppModule pSAppModule2 = new PSAppModule();
            pSAppModule2.setPSSysAppId(pSAppModule.getPSSysAppId());
            pSAppModule2.setDefaultFlag(1);
            if (this.existsData(pSAppModule2)) {
                pSAppModule2.setDefaultFlag(0);
                this.update(pSAppModule2, false);
            }
        }
        super.onBeforeUpdate(pSAppModule);
    }

    @Override
    protected void onInitDefault(PSAppModule pSAppModule) throws Exception {
        pSAppModule.setSessionFactory(this.getSessionFactory());
        if (StringHelper.isNullOrEmpty((String)pSAppModule.getPSSysAppId())) {
            this.getDraft(pSAppModule);
        }
        if (StringHelper.isNullOrEmpty((String)pSAppModule.getPSSysAppId())) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5f53\u524d\u5e94\u7528\u6807\u8bc6");
        }
        PSSysApp pSSysApp = pSAppModule.getPSSysApp();
        PSSysAppService pSSysAppService = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)this.getSessionFactory());
        pSSysAppService.initPSAppModules(pSSysApp);
    }

    public PSAppModule getDefaultByPSDataEntity(final PSSysApp pSSysApp, final PSDataEntity pSDataEntity) throws Exception {
        final PSAppModule pSAppModule = new PSAppModule();
        if (!pSDataEntity.isFullEntity()) {
            pSDataEntity.setSessionFactory(this.getSessionFactory());
            pSDataEntity.get();
        }
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysAppService pSSysAppService = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)PSAppModuleService.this.getSessionFactory());
                pSSysAppService.initPSAppModules(pSSysApp);
                PSAppModuleService pSAppModuleService = (PSAppModuleService)ServiceGlobal.getService(PSAppModuleService.class, (SessionFactory)PSAppModuleService.this.getSessionFactory());
                pSAppModule.setPSSysAppId(pSSysApp.getPSSysAppId());
                pSAppModule.setPSModuleId(pSDataEntity.getPSModuleId());
                if (!pSAppModuleService.select(pSAppModule, true)) {
                    pSAppModule.reset();
                    pSAppModule.setPSSysAppId(pSSysApp.getPSSysAppId());
                    pSAppModule.setCodeName(pSDataEntity.getPSModule().getCodeName());
                    if (!pSAppModuleService.select(pSAppModule, true)) {
                        pSAppModule.reset();
                        pSAppModule.setPSSysAppId(pSSysApp.getPSSysAppId());
                        pSAppModule.setDefaultFlag(1);
                        if (!pSAppModuleService.select(pSAppModule, true)) {
                            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u4e3a\u5b9e\u4f53[%1$s]\u83b7\u53d6\u9ed8\u8ba4\u5e94\u7528\u6a21\u5757", (Object)pSDataEntity.getPSDataEntityName()));
                        }
                    }
                }
            }
        });
        return pSAppModule;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSMODULEID", "");
        map.put("PSMODULENAME", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public String getModelV2Tag(PSAppModule pSAppModule) {
        if (!StringHelper.isNullOrEmpty((String)pSAppModule.getCodeName()) && !StringHelper.isNullOrEmpty((String)pSAppModule.getPSAppModuleName())) {
            if (StringHelper.isNullOrEmpty((String)pSAppModule.getPSModuleId())) {
                return StringHelper.format((String)"%1$s(%2$s)", (Object)pSAppModule.getPSAppModuleName(), (Object)pSAppModule.getCodeName());
            }
            return StringHelper.format((String)"%1$s[M](%2$s)", (Object)pSAppModule.getPSAppModuleName(), (Object)pSAppModule.getCodeName());
        }
        return super.getModelV2Tag(pSAppModule);
    }

    @Override
    public boolean getModelV2Entity(PSAppModule pSAppModule, String string) throws Exception {
        return super.getModelV2Entity(pSAppModule, string);
    }
}

