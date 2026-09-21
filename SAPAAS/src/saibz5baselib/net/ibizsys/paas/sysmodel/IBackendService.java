/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.sysmodel;

import net.ibizsys.psrt.srv.common.entity.Service;

public interface IBackendService {
    public void init(Service var1) throws Exception;

    public void quit() throws Exception;

    public void start() throws Exception;

    public void stop() throws Exception;

    public boolean isStarted() throws Exception;

    public String getServiceId();

    public String getServiceName();
}

