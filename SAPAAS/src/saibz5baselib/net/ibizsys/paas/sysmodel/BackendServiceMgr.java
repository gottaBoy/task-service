/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.sysmodel;

import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.IBackendService;
import net.ibizsys.paas.util.ObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.common.entity.Service;
import net.ibizsys.psrt.srv.common.service.ServiceService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BackendServiceMgr {
    private static BackendServiceMgr curBackendServiceMgr = null;
    private HashMap<String, IBackendService> backendServiceMap = new HashMap();
    private static final Log log = LogFactory.getLog(BackendServiceMgr.class);
    private String strServiceContainerId = "";

    public void init(String strServiceContainerId) throws Exception {
        this.strServiceContainerId = strServiceContainerId;
        this.onInit();
    }

    public String getServiceContainerId() {
        return this.strServiceContainerId;
    }

    protected void onInit() throws Exception {
        ServiceService serviceService = (ServiceService)ServiceGlobal.getService(ServiceService.class);
        SelectCond selectCond = new SelectCond();
        selectCond.set("CONTAINER", this.getServiceContainerId());
        selectCond.setOrderInfo("order by RUNORDER");
        ArrayList serviceList = serviceService.select(selectCond);
        for (Service service : serviceList) {
            try {
                IBackendService iBackendService = this.registerBackendService(service);
                if (StringHelper.compare(service.getStartMode(), "AUTO", true) == 0) {
                    iBackendService.start();
                    service.setServiceState("START");
                } else {
                    service.setServiceState("STOP");
                }
                serviceService.update(service);
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.format("\u542f\u52a8\u540e\u53f0\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", service.getServiceName(), ex.getMessage()));
                service.setServiceState("STARTERROR");
                service.setErrorInfo(ex.getMessage());
                serviceService.update(service);
            }
        }
    }

    protected IBackendService registerBackendService(Service service) throws Exception {
        IBackendService iBackendService = (IBackendService)ObjectHelper.create(service.getServiceObject());
        iBackendService.init(service);
        this.backendServiceMap.put(iBackendService.getServiceId(), iBackendService);
        return iBackendService;
    }

    protected IBackendService getBackendService(String strServiceId) throws Exception {
        IBackendService iBackendService = this.backendServiceMap.get(strServiceId);
        if (iBackendService != null) {
            return iBackendService;
        }
        ServiceService serviceService = (ServiceService)ServiceGlobal.getService(ServiceService.class);
        Service service = new Service();
        service.setServiceId(strServiceId);
        if (!serviceService.get(service, true)) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u540e\u53f0\u670d\u52a1[%1$s]", strServiceId));
        }
        iBackendService = this.registerBackendService(service);
        return iBackendService;
    }

    public void start(String strServiceId) throws Exception {
        IBackendService iBackendService = this.getBackendService(strServiceId);
        if (iBackendService.isStarted()) {
            return;
        }
        ServiceService serviceService = (ServiceService)ServiceGlobal.getService(ServiceService.class);
        Service service = new Service();
        service.setServiceId(strServiceId);
        try {
            iBackendService.start();
            service.setServiceState("START");
            serviceService.update(service);
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format("\u542f\u52a8\u540e\u53f0\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", iBackendService.getServiceName(), ex.getMessage()));
            service.setServiceState("STARTERROR");
            service.setErrorInfo(ex.getMessage());
            serviceService.update(service);
        }
    }

    public void stop(String strServiceId) throws Exception {
        IBackendService iBackendService = this.getBackendService(strServiceId);
        if (!iBackendService.isStarted()) {
            return;
        }
        ServiceService serviceService = (ServiceService)ServiceGlobal.getService(ServiceService.class);
        Service service = new Service();
        service.setServiceId(strServiceId);
        try {
            iBackendService.stop();
            service.setServiceState("STOP");
            serviceService.update(service);
            this.backendServiceMap.put(iBackendService.getServiceId(), iBackendService);
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format("\u505c\u6b62\u540e\u53f0\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", iBackendService.getServiceName(), ex.getMessage()));
            service.setServiceState("STOP");
            serviceService.update(service);
            throw ex;
        }
    }

    public static BackendServiceMgr createInstance(String strServiceContainerId) throws Exception {
        BackendServiceMgr backendServiceMgr;
        curBackendServiceMgr = backendServiceMgr = new BackendServiceMgr();
        backendServiceMgr.init(strServiceContainerId);
        return curBackendServiceMgr;
    }

    public static BackendServiceMgr getInstance() throws Exception {
        return curBackendServiceMgr;
    }
}

