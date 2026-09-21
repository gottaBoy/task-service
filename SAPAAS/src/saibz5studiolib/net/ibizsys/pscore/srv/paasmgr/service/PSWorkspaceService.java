/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ISFSAction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.paasmgr.service;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ISFSAction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspace;
import net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWorkspace;
import net.ibizsys.pscore.srv.paasmgr.service.PSWorkspaceServiceBase;
import net.ibizsys.pscore.srv.util.PSCoreEntityKeeperGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSWorkspaceService
extends PSWorkspaceServiceBase {
    private static final Log log = LogFactory.getLog(PSWorkspaceService.class);

    @Override
    protected boolean isUpdateModelKeeper(PSWorkspace pSWorkspace) throws Exception {
        return PSCoreEntityKeeperGlobal.getCurrent(this.getSessionFactory()).isPSDCWorkspaceEnabled();
    }

    @Override
    protected void onUpdateModelKeeper(PSWorkspace pSWorkspace) throws Exception {
        final String string = pSWorkspace.getPSWorkspaceId();
        SessionFactoryManager.getCurrentSFS().registerSFSAction(this.getRealSessionFactory(), new ISFSAction(){

            public void commit() {
                try {
                    PSWorkspace pSWorkspace = new PSWorkspace();
                    pSWorkspace.setPSWorkspaceId(string);
                    PSWorkspaceService.this.get((IEntity)pSWorkspace);
                    if (!StringHelper.isNullOrEmpty((String)pSWorkspace.getPSDCWorkspaceId())) {
                        PSDCWorkspace pSDCWorkspace = new PSDCWorkspace();
                        pSDCWorkspace.setPSDCWorkspaceId(pSWorkspace.getPSDCWorkspaceId());
                        PSDCWorkspaceService pSDCWorkspaceService = (PSDCWorkspaceService)ServiceGlobal.getService(PSDCWorkspaceService.class, (SessionFactory)PSWorkspaceService.this.getSessionFactory());
                        pSDCWorkspaceService.get((IEntity)pSDCWorkspace);
                        PSCoreEntityKeeperGlobal.getCurrent(PSWorkspaceService.this.getSessionFactory()).updatePSDCWorkspace(pSDCWorkspace);
                    }
                }
                catch (Exception exception) {
                    log.error((Object)exception);
                }
            }

            public void rollback() {
            }
        });
    }

    @Override
    protected void onAfterCreate(PSWorkspace pSWorkspace) throws Exception {
        if (this.isMajorSessionFactory() && !StringHelper.isNullOrEmpty((String)pSWorkspace.getPSDevCenterId())) {
            try {
                this.bindDC(pSWorkspace);
            }
            catch (Exception exception) {
                log.error((Object)StringHelper.format((String)"\u5206\u914d\u751f\u4ea7\u7ebf\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
                throw new Exception(StringHelper.format((String)"\u5206\u914d\u751f\u4ea7\u7ebf\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
            }
        }
        super.onAfterCreate(pSWorkspace);
    }

    @Override
    protected void onBeforeRemove(PSWorkspace pSWorkspace) throws Exception {
        PSWorkspace pSWorkspace2;
        if (this.isMajorSessionFactory() && !StringHelper.isNullOrEmpty((String)(pSWorkspace2 = (PSWorkspace)this.getLast((IEntity)pSWorkspace)).getPSDCWorkspaceId())) {
            throw new Exception("\u751f\u4ea7\u7ebf\u5df2\u7ecf\u5206\u914d\u5230\u5e94\u7528\u4e2d\u5fc3\uff0c\u65e0\u6cd5\u5220\u9664");
        }
        super.onBeforeRemove(pSWorkspace);
    }

    @Override
    protected boolean isPrepareLastForRemove() {
        return true;
    }

    @Override
    protected void onBindDC(PSWorkspace pSWorkspace) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSWorkspace.getPSDevCenterId())) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5206\u914d\u5e94\u7528\u4e2d\u5fc3");
        }
        PSWorkspace pSWorkspace2 = new PSWorkspace();
        pSWorkspace2.setPSWorkspaceId(pSWorkspace.getPSWorkspaceId());
        this.get((IEntity)pSWorkspace2);
        if (!StringHelper.isNullOrEmpty((String)pSWorkspace2.getPSDCWorkspaceId())) {
            throw new Exception("\u751f\u4ea7\u7ebf\u5df2\u7ecf\u5206\u914d\u5230\u5e94\u7528\u4e2d\u5fc3");
        }
        if (!StringHelper.isNullOrEmpty((String)pSWorkspace2.getPSDevCenterId()) && StringHelper.compare((String)pSWorkspace2.getPSDevCenterId(), (String)pSWorkspace.getPSDevCenterId(), (boolean)false) != 0) {
            throw new Exception("\u751f\u4ea7\u7ebf\u9884\u5206\u914d\u5e94\u7528\u4e2d\u5fc3\u4e0e\u4f20\u5165\u4e2d\u5fc3\u4e0d\u4e00\u81f4");
        }
        PSDCWorkspaceService pSDCWorkspaceService = (PSDCWorkspaceService)ServiceGlobal.getService(PSDCWorkspaceService.class, (SessionFactory)this.getSessionFactory());
        PSDCWorkspace pSDCWorkspace = new PSDCWorkspace();
        pSDCWorkspace.setPSDCWorkspaceName(pSWorkspace2.getPSWorkspaceName());
        pSDCWorkspace.setPSWorkspaceId(pSWorkspace2.getPSWorkspaceId());
        pSDCWorkspace.setPSWorkspaceName(pSWorkspace2.getPSWorkspaceName());
        pSDCWorkspace.setPSDevCenterId(pSWorkspace.getPSDevCenterId());
        pSDCWorkspace.setPSDevCenterName(pSWorkspace.getPSDevCenterName());
        if (pSWorkspace2.getWorkspaceType().indexOf("T") == 0) {
            pSDCWorkspace.setResState(42);
        } else {
            pSDCWorkspace.setResState(20);
        }
        try {
            pSDCWorkspaceService.create(pSDCWorkspace);
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u5efa\u7acb\u4e2d\u5fc3\u751f\u4ea7\u7ebf\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
            throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u4e2d\u5fc3\u751f\u4ea7\u7ebf\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
        pSWorkspace.setPSDCWorkspaceId(pSDCWorkspace.getPSDCWorkspaceId());
        pSWorkspace.setWorkspaceState(30);
        try {
            this.update(pSWorkspace);
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u66f4\u65b0\u751f\u4ea7\u7ebf\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
            throw new Exception(StringHelper.format((String)"\u66f4\u65b0\u751f\u4ea7\u7ebf\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
    }

    @Override
    protected void onResetDC(PSWorkspace pSWorkspace) throws Exception {
        this.get((IEntity)pSWorkspace);
        if (!StringHelper.isNullOrEmpty((String)pSWorkspace.getPSDCWorkspaceId())) {
            PSDCWorkspace pSDCWorkspace = new PSDCWorkspace();
            pSDCWorkspace.setPSDCWorkspaceId(pSWorkspace.getPSDCWorkspaceId());
            PSDCWorkspaceService pSDCWorkspaceService = (PSDCWorkspaceService)ServiceGlobal.getService(PSDCWorkspaceService.class, (SessionFactory)this.getSessionFactory());
            try {
                pSDCWorkspaceService.remove((IEntity)pSDCWorkspace);
            }
            catch (Exception exception) {
                log.error((Object)StringHelper.format((String)"\u5220\u9664\u4e2d\u5fc3\u751f\u4ea7\u7ebf\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
                throw new Exception(StringHelper.format((String)"\u5220\u9664\u4e2d\u5fc3\u751f\u4ea7\u7ebf\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
            }
        }
    }

    @Override
    protected void onUninstallSys(PSWorkspace pSWorkspace) throws Exception {
        this.get((IEntity)pSWorkspace);
        if (!StringHelper.isNullOrEmpty((String)pSWorkspace.getPSDCWorkspaceId())) {
            PSDCWorkspace pSDCWorkspace = new PSDCWorkspace();
            pSDCWorkspace.setPSDCWorkspaceId(pSWorkspace.getPSDCWorkspaceId());
            PSDCWorkspaceService pSDCWorkspaceService = (PSDCWorkspaceService)ServiceGlobal.getService(PSDCWorkspaceService.class, (SessionFactory)this.getSessionFactory());
            try {
                pSDCWorkspaceService.get((IEntity)pSDCWorkspace);
            }
            catch (Exception exception) {
                log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u4e2d\u5fc3\u751f\u4ea7\u7ebf\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
                throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u4e2d\u5fc3\u751f\u4ea7\u7ebf\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
            }
            if (!StringHelper.isNullOrEmpty((String)pSDCWorkspace.getPSDevSlnSysId())) {
                try {
                    pSDCWorkspaceService.uninstallSys(pSDCWorkspace);
                }
                catch (Exception exception) {
                    log.error((Object)StringHelper.format((String)"\u4e2d\u5fc3\u751f\u4ea7\u7ebf\u5378\u8f7d\u7cfb\u7edf\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
                    throw new Exception(StringHelper.format((String)"\u4e2d\u5fc3\u751f\u4ea7\u7ebf\u5378\u8f7d\u7cfb\u7edf\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
                }
            }
        }
    }
}

