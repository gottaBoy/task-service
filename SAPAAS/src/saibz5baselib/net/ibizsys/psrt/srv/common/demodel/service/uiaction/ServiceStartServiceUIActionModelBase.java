/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psrt.srv.common.demodel.service.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.psrt.srv.common.entity.Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class ServiceStartServiceUIActionModelBase
extends DEUIActionModelBase<Service> {
    private static final Log log = LogFactory.getLog(ServiceStartServiceUIActionModelBase.class);

    public ServiceStartServiceUIActionModelBase() {
        this.setId("4289D139-69BA-439E-8C91-B1BF69B6403A");
        this.setName("StartService");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("StartService");
        this.setReloadData(true);
        this.setSuccessMsg("\u670d\u52a1\u542f\u52a8\u6210\u529f\uff01");
    }
}

