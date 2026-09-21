/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.psrt.srv.common.service;

import net.ibizsys.paas.sysmodel.BackendServiceMgr;
import net.ibizsys.psrt.srv.common.entity.Service;
import net.ibizsys.psrt.srv.common.service.ServiceServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class ServiceService
extends ServiceServiceBase {
    private static final Log log = LogFactory.getLog(ServiceService.class);

    @Override
    protected void onStartService(Service service) throws Exception {
        BackendServiceMgr backendServiceMgr = BackendServiceMgr.getInstance();
        backendServiceMgr.start(service.getServiceId());
    }

    @Override
    protected void onStopService(Service service) throws Exception {
        BackendServiceMgr backendServiceMgr = BackendServiceMgr.getInstance();
        backendServiceMgr.stop(service.getServiceId());
    }
}

