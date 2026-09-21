/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.devcenter.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.PSCoreSysServiceBaseBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRobot;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRobotLog;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRobotLogService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRobotServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSRobot;
import net.ibizsys.pscore.srv.paasmgr.service.PSRobotService;
import net.ibizsys.pscore.srv.util.PSCoreEntityKeeperGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDCRobotService
extends PSDCRobotServiceBase {
    private static final Log log = LogFactory.getLog(PSDCRobotService.class);

    public boolean logPSDCRobotActions(PSDCRobot pSDCRobot, ArrayList<PSDCRobotLog> arrayList) throws Exception {
        final PSDCRobot pSDCRobot2 = pSDCRobot;
        final ArrayList<PSDCRobotLog> arrayList2 = arrayList;
        final CallResult callResult = new CallResult();
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                callResult.setUserObject((Object)PSDCRobotService.this.onLogPSDCRobotActions(pSDCRobot2, arrayList2));
            }
        });
        return (Boolean)callResult.getUserObject();
    }

    protected boolean onLogPSDCRobotActions(PSDCRobot pSDCRobot, ArrayList<PSDCRobotLog> arrayList) throws Exception {
        int pSDCRobotLog;
        int n;
        Object n5;
        if (arrayList.size() == 0) {
            return false;
        }
        this.get((IEntity)pSDCRobot);
        int n3 = 0;
        for (PSDCRobotLog entityBase2 : arrayList) {
            n3 += entityBase2.getEnergy().intValue();
        }
        int n4 = DataObject.getIntegerValue((Object)pSDCRobot.getTotalEnergy(), (Integer)0);
        PSDCRobot pSDCRobot2 = new PSDCRobot();
        pSDCRobot2.setPSDCRobotId(pSDCRobot.getPSDCRobotId());
        EntityBase.setLastUpdateDate((IEntity)pSDCRobot2, (Timestamp)pSDCRobot.getUpdateDate());
        if (n3 < 0) {
            n3 = -n3;
            n5 = new Timestamp(System.currentTimeMillis());
            n = this.getCurrentEnergy(pSDCRobot, ((Timestamp)n5).getTime());
            if (n < n3) {
                return false;
            }
            log.info((Object)StringHelper.format((String)"\u673a\u5668\u4eba[%1$s]\u6263\u9664\u80fd\u91cf[%2$s]", (Object)pSDCRobot.getPSDCRobotName(), (Object)n3));
            pSDCRobotLog = DataObject.getIntegerValue((Object)pSDCRobot.getExtEnergy(), (Integer)0);
            if (n - pSDCRobotLog - n3 > 0) {
                pSDCRobot2.setLastEnergy(n - n3 - pSDCRobotLog);
            } else {
                pSDCRobot2.setLastEnergy(0);
                pSDCRobotLog = n - n3;
                if (pSDCRobotLog < 0) {
                    return false;
                }
                pSDCRobot2.setExtEnergy(pSDCRobotLog);
            }
            pSDCRobot2.setLastCalcTime((Timestamp)n5);
            pSDCRobot2.setTotalEnergy(n4 += n3);
        } else {
            int n2 = DataObject.getIntegerValue((Object)pSDCRobot.getExtEnergy(), (Integer)0);
            n = DataObject.getIntegerValue((Object)pSDCRobot.getMaxExtEnergy(), (Integer)0);
            pSDCRobotLog = n3;
            if ((n2 += n3) > n) {
                int n6 = pSDCRobot.getLastEnergy();
                if ((n6 += n2 - n) > pSDCRobot.getMaxEnergy()) {
                    pSDCRobotLog -= n6 - pSDCRobot.getMaxEnergy();
                    n6 = pSDCRobot.getMaxEnergy();
                }
                pSDCRobot2.setLastEnergy(n6);
                n2 = n;
            }
            pSDCRobot2.setExtEnergy(n2);
            arrayList.get(0).setEnergy(pSDCRobotLog);
            log.info((Object)StringHelper.format((String)"\u673a\u5668\u4eba[%1$s]\u589e\u52a0\u80fd\u91cf[%2$s]", (Object)pSDCRobot.getPSDCRobotName(), (Object)pSDCRobotLog));
        }
        n5 = (PSDCRobotLogService)ServiceGlobal.getService(PSDCRobotLogService.class, (SessionFactory)this.getSessionFactory());
        for (PSDCRobotLog pSDCRobotLog2 : arrayList) {
            pSDCRobotLog2.setCancelFlag(0);
            ((PSCoreSysServiceBaseBase)((Object)n5)).create(pSDCRobotLog2);
        }
        this.update(pSDCRobot2);
        this.syncPSRobot(pSDCRobot2);
        pSDCRobot2.copyTo((IDataObject)pSDCRobot, true);
        return true;
    }

    public void cancelPSDCRobotActions(PSDCRobot pSDCRobot, ArrayList<PSDCRobotLog> arrayList) throws Exception {
        final PSDCRobot pSDCRobot2 = pSDCRobot;
        final ArrayList<PSDCRobotLog> arrayList2 = arrayList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCRobotService.this.onCancelPSDCRobotActions(pSDCRobot2, arrayList2);
            }
        });
    }

    protected void onCancelPSDCRobotActions(PSDCRobot pSDCRobot, ArrayList<PSDCRobotLog> arrayList) throws Exception {
        int n;
        this.get((IEntity)pSDCRobot);
        int n2 = 0;
        for (PSDCRobotLog pSDCRobotLog : arrayList) {
            n2 += pSDCRobotLog.getEnergy().intValue();
        }
        log.info((Object)StringHelper.format((String)"\u673a\u5668\u4eba[%1$s]\u589e\u52a0\u80fd\u91cf[%2$s]", (Object)pSDCRobot.getPSDCRobotName(), (Object)n2));
        PSDCRobot pSDCRobot2 = new PSDCRobot();
        pSDCRobot2.setPSDCRobotId(pSDCRobot.getPSDCRobotId());
        int n3 = pSDCRobot.getLastEnergy();
        n3 += n2;
        if (n2 > pSDCRobot.getMaxEnergy()) {
            int n4;
            n = DataObject.getIntegerValue((Object)pSDCRobot.getExtEnergy(), (Integer)0) + (n3 - pSDCRobot.getMaxEnergy());
            if (n > (n4 = DataObject.getIntegerValue((Object)pSDCRobot.getMaxExtEnergy(), (Integer)0).intValue())) {
                n = n4;
            }
            pSDCRobot2.setExtEnergy(n);
            n3 = pSDCRobot.getMaxEnergy();
        }
        pSDCRobot2.setLastEnergy(n3);
        n = DataObject.getIntegerValue((Object)pSDCRobot.getTotalEnergy(), (Integer)0);
        if ((n -= n2) < 0) {
            n = 0;
        }
        pSDCRobot2.setTotalEnergy(n);
        EntityBase.setLastUpdateDate((IEntity)pSDCRobot2, (Timestamp)pSDCRobot.getUpdateDate());
        PSDCRobotLogService pSDCRobotLogService = (PSDCRobotLogService)ServiceGlobal.getService(PSDCRobotLogService.class, (SessionFactory)this.getSessionFactory());
        for (PSDCRobotLog pSDCRobotLog : arrayList) {
            PSDCRobotLog pSDCRobotLog2 = new PSDCRobotLog();
            pSDCRobotLog2.setPSDCRobotLogId(pSDCRobotLog.getPSDCRobotLogId());
            if (!pSDCRobotLogService.get((IEntity)pSDCRobotLog2, true)) continue;
            pSDCRobotLog2.setEnergy(pSDCRobotLog2.getEnergy() + pSDCRobotLog.getEnergy());
            pSDCRobotLog2.setCancelFlag(1);
            pSDCRobotLogService.update(pSDCRobotLog2);
        }
        this.update(pSDCRobot2);
        this.syncPSRobot(pSDCRobot2);
        pSDCRobot2.copyTo((IDataObject)pSDCRobot, true);
    }

    protected void syncPSRobot(PSDCRobot pSDCRobot) throws Exception {
        PSRobotService pSRobotService = (PSRobotService)ServiceGlobal.getService(PSRobotService.class, (SessionFactory)this.getSessionFactory());
        PSRobot pSRobot = new PSRobot();
        pSRobot.setPSRobotId(pSDCRobot.getPSRobotId());
        pSRobot.setLastCalcTime(pSDCRobot.getLastCalcTime());
        pSRobot.setLastEnergy(pSDCRobot.getLastEnergy());
        pSRobot.setMaxEnergy(pSDCRobot.getMaxEnergy());
        pSRobot.setMaxExtEnergy(pSDCRobot.getMaxExtEnergy());
        pSRobot.setExtEnergy(pSDCRobot.getExtEnergy());
        pSRobotService.update(pSRobot);
    }

    public int getCurrentEnergy(PSDCRobot pSDCRobot, long l) throws Exception {
        if (l == 0L) {
            l = System.currentTimeMillis();
        }
        int n = (int)((double)((l - pSDCRobot.getLastCalcTime().getTime()) / 1000L) * pSDCRobot.getEnergyRate());
        n += pSDCRobot.getLastEnergy().intValue();
        int n2 = DataObject.getIntegerValue((Object)pSDCRobot.getMaxExtEnergy(), (Integer)0);
        int n3 = DataObject.getIntegerValue((Object)pSDCRobot.getExtEnergy(), (Integer)0);
        if (n3 > n2) {
            n3 = n2;
        }
        if (n > pSDCRobot.getMaxEnergy()) {
            return pSDCRobot.getMaxEnergy() + n3;
        }
        return n + n3;
    }

    @Override
    protected void onAfterCreate(PSDCRobot pSDCRobot) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = new PSDevCenter();
            pSDevCenter.setPSDevCenterId(pSDCRobot.getPSDevCenterId());
            pSDevCenter.setRobotChgTime(new Timestamp(System.currentTimeMillis()));
            pSDevCenterService.update(pSDevCenter, false);
        }
        super.onAfterCreate(pSDCRobot);
    }

    @Override
    protected void onAfterRemove(PSDCRobot pSDCRobot) throws Exception {
        PSDCRobot pSDCRobot2 = (PSDCRobot)this.getLast((IEntity)pSDCRobot);
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = new PSDevCenter();
            pSDevCenter.setPSDevCenterId(pSDCRobot2.getPSDevCenterId());
            pSDevCenter.setRobotChgTime(new Timestamp(System.currentTimeMillis()));
            pSDevCenterService.update(pSDevCenter, false);
        }
        super.onAfterRemove(pSDCRobot);
    }

    @Override
    protected boolean isPrepareLastForRemove() {
        return true;
    }

    @Override
    protected void onAfterUpdate(PSDCRobot pSDCRobot) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            PSCoreEntityKeeperGlobal.getCurrent(this.getSessionFactory()).updatePSDCRobot(pSDCRobot);
        }
        super.onAfterUpdate(pSDCRobot);
    }
}

