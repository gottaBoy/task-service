/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdevstudio.service;

import net.ibizsys.pscore.srv.sysdevstudio.entity.PSUWPickupModel;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSUWPickupModelServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSUWPickupModelService
extends PSUWPickupModelServiceBase {
    private static final Log log = LogFactory.getLog(PSUWPickupModelService.class);

    @Override
    protected void onInitCtrlPickup(PSUWPickupModel pSUWPickupModel) throws Exception {
        pSUWPickupModel.setWizardMode("CTRL");
        pSUWPickupModel.setPSUWPickupModelName("CTRL");
        this.create(pSUWPickupModel);
    }

    @Override
    protected void onFinishCtrlPickup(PSUWPickupModel pSUWPickupModel) throws Exception {
    }
}

