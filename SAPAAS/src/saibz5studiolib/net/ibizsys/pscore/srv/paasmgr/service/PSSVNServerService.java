/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ISFSAction
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.paasmgr.service;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ISFSAction;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSVNServer;
import net.ibizsys.pscore.srv.paasmgr.service.PSSVNServerServiceBase;
import net.ibizsys.pscore.srv.util.PSCoreEntityKeeperGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSVNServerService
extends PSSVNServerServiceBase {
    private static final Log log = LogFactory.getLog(PSSVNServerService.class);

    @Override
    protected boolean isUpdateModelKeeper(PSSVNServer pSSVNServer) throws Exception {
        return PSCoreEntityKeeperGlobal.getCurrent(this.getSessionFactory()).isPSSVNServerEnabled();
    }

    @Override
    protected void onUpdateModelKeeper(PSSVNServer pSSVNServer) throws Exception {
        final String string = pSSVNServer.getPSSVNServerId();
        SessionFactoryManager.getCurrentSFS().registerSFSAction(this.getRealSessionFactory(), new ISFSAction(){

            public void commit() {
                try {
                    PSSVNServer pSSVNServer = new PSSVNServer();
                    pSSVNServer.setPSSVNServerId(string);
                    PSSVNServerService.this.get(pSSVNServer);
                    PSCoreEntityKeeperGlobal.getCurrent(PSSVNServerService.this.getSessionFactory()).updatePSSVNServer(pSSVNServer);
                }
                catch (Exception exception) {
                    log.error((Object)exception);
                }
            }

            public void rollback() {
            }
        });
    }
}

