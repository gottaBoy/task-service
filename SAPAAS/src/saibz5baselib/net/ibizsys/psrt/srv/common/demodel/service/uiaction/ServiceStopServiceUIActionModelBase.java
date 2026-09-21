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

public abstract class ServiceStopServiceUIActionModelBase
extends DEUIActionModelBase<Service> {
    private static final Log log = LogFactory.getLog(ServiceStopServiceUIActionModelBase.class);

    public ServiceStopServiceUIActionModelBase() {
        this.setId("1DAF43F4-0D78-42EE-BFFA-85F59F1A70FB");
        this.setName("StopService");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("StopService");
        this.setReloadData(true);
        this.setSuccessMsg("\u670d\u52a1\u505c\u6b62\u6210\u529f\uff01");
    }
}

