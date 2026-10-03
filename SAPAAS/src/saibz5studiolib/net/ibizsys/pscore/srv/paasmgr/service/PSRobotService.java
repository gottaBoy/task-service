/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.psop.zookeeper.PSRobotKeeper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.paasmgr.service;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.pscore.srv.paasmgr.entity.PSRobot;
import net.ibizsys.pscore.srv.paasmgr.service.PSRobotServiceBase;
import net.ibizsys.psop.zookeeper.PSRobotKeeper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSRobotService
extends PSRobotServiceBase {
    private static final Log log = LogFactory.getLog(PSRobotService.class);

    @Override
    protected void onAfterUpdate(PSRobot pSRobot) throws Exception {
        PSRobotKeeper.updatePSRobotEnergy(pSRobot);
        super.onAfterUpdate(pSRobot);
    }
}

