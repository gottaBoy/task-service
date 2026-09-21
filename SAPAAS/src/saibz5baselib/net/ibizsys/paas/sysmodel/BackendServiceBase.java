/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.sysmodel;

import java.util.Properties;
import java.util.TimerTask;
import net.ibizsys.paas.sysmodel.IBackendService;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.common.entity.Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class BackendServiceBase
extends TimerTask
implements IBackendService {
    protected Service service = null;
    protected boolean bStart = false;
    protected Properties serviceParams = null;
    private static final Log log = LogFactory.getLog(BackendServiceBase.class);
    private boolean bRunFlag = false;

    @Override
    public void init(Service service) throws Exception {
        this.service = service;
        try {
            if (!StringHelper.isNullOrEmpty(service.getServiceParam())) {
                this.serviceParams = PropertiesHelper.load(service.getServiceParam());
            }
        }
        catch (Exception e) {
            throw new Exception(StringHelper.format("\u52a0\u8f7d\u670d\u52a1\u914d\u7f6e\u53c2\u6570\u53d1\u751f\u9519\u8bef"), e);
        }
        this.onInit();
    }

    protected void onInit() throws Exception {
    }

    @Override
    public void start() throws Exception {
        if (this.bStart) {
            return;
        }
        try {
            this.onStart();
            this.bStart = true;
        }
        catch (Exception ex) {
            this.onStop();
            throw ex;
        }
    }

    protected void onStart() throws Exception {
    }

    @Override
    public void stop() throws Exception {
        if (!this.bStart) {
            return;
        }
        this.onStop();
        this.bStart = false;
    }

    protected void onStop() throws Exception {
    }

    @Override
    public boolean isStarted() {
        return this.bStart;
    }

    @Override
    public String getServiceId() {
        return this.service.getServiceId();
    }

    @Override
    public String getServiceName() {
        return this.service.getServiceName();
    }

    @Override
    public void quit() throws Exception {
        this.onQuit();
    }

    protected void onQuit() throws Exception {
        this.stop();
    }

    protected String getServiceParam(String strPropertyName) {
        strPropertyName = strPropertyName.toUpperCase();
        String strDefaultValue = "";
        return PropertiesHelper.getProperty(this.serviceParams, strPropertyName, strDefaultValue);
    }

    protected String getServiceParam(String strPropertyName, String strDefaultValue) {
        strPropertyName = strPropertyName.toUpperCase();
        return PropertiesHelper.getProperty(this.serviceParams, strPropertyName, strDefaultValue);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void runTask() {
        BackendServiceBase backendServiceBase = this;
        synchronized (backendServiceBase) {
            if (this.bRunFlag) {
                return;
            }
            this.bRunFlag = true;
        }
        try {
            this.onRun();
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format("\u670d\u52a1[%1$s]\u5904\u7406\u53d1\u751f\u5f02\u5e38\uff0c%2$s", this.getServiceId(), ex.getMessage()), (Throwable)ex);
        }
        backendServiceBase = this;
        synchronized (backendServiceBase) {
            this.bRunFlag = false;
        }
    }

    @Override
    public void run() {
        this.runTask();
    }

    protected void onRun() throws Exception {
    }
}

