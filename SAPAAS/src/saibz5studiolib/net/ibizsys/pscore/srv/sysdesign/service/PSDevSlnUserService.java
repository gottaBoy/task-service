/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import java.util.ArrayList;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInst;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnUser;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnUserServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSUAWizard2;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSUAWizard2Service;
import net.ibizsys.pscore.srv.util.PSDevCenterHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDevSlnUserService
extends PSDevSlnUserServiceBase {
    private static final Log log = LogFactory.getLog(PSDevSlnUserService.class);

    @Override
    public void create(PSDevSlnUser pSDevSlnUser, boolean bl) throws Exception {
        PSDevSlnUser pSDevSlnUser2 = new PSDevSlnUser();
        pSDevSlnUser2.setPSDevSlnId(pSDevSlnUser.getPSDevSlnId());
        pSDevSlnUser2.setAllSysFlag(pSDevSlnUser.getAllSysFlag());
        pSDevSlnUser2.setPSDevSlnSysId(pSDevSlnUser.getPSDevSlnSysId());
        pSDevSlnUser2.setPSDevSlnTemplId(pSDevSlnUser.getPSDevSlnTemplId());
        pSDevSlnUser2.setPSDevSlnSysDynaInstId(pSDevSlnUser.getPSDevSlnSysDynaInstId());
        pSDevSlnUser2.setPSDevUserObjId(pSDevSlnUser.getPSDevUserObjId());
        if (this.select(pSDevSlnUser2, true)) {
            pSDevSlnUser.setPSDevSlnUserId(pSDevSlnUser2.getPSDevSlnUserId());
            this.update(pSDevSlnUser, bl);
            return;
        }
        super.create(pSDevSlnUser, bl);
    }

    @Override
    protected void onBeforeCreate(PSDevSlnUser pSDevSlnUser) throws Exception {
        if (pSDevSlnUser.getAllSysFlag() == null) {
            if (StringHelper.isNullOrEmpty((String)pSDevSlnUser.getPSDevSlnSysId()) && StringHelper.isNullOrEmpty((String)pSDevSlnUser.getPSDevSlnTemplId()) && StringHelper.isNullOrEmpty((String)pSDevSlnUser.getPSDevSlnSysDynaInstId())) {
                pSDevSlnUser.setAllSysFlag(1);
            } else if (!StringHelper.isNullOrEmpty((String)pSDevSlnUser.getPSDevSlnSysId())) {
                pSDevSlnUser.setAllSysFlag(0);
                pSDevSlnUser.setPSDevSlnTemplId(null);
                pSDevSlnUser.setPSDevSlnSysDynaInstId(null);
            } else if (!StringHelper.isNullOrEmpty((String)pSDevSlnUser.getPSDevSlnTemplId())) {
                pSDevSlnUser.setAllSysFlag(2);
                pSDevSlnUser.setPSDevSlnSysId(null);
                pSDevSlnUser.setPSDevSlnSysDynaInstId(null);
            } else if (!StringHelper.isNullOrEmpty((String)pSDevSlnUser.getPSDevSlnSysDynaInstId())) {
                pSDevSlnUser.setAllSysFlag(3);
                pSDevSlnUser.setPSDevSlnSysId(null);
                pSDevSlnUser.setPSDevSlnTemplId(null);
            }
        } else {
            int n = DataObject.getIntegerValue((Object)pSDevSlnUser.getAllSysFlag(), (Integer)1);
            switch (n) {
                case 1: {
                    pSDevSlnUser.setPSDevSlnSysId(null);
                    pSDevSlnUser.setPSDevSlnTemplId(null);
                    pSDevSlnUser.setPSDevSlnSysDynaInstId(null);
                    break;
                }
                case 0: {
                    pSDevSlnUser.setPSDevSlnTemplId(null);
                    pSDevSlnUser.setPSDevSlnSysDynaInstId(null);
                    break;
                }
                case 2: {
                    pSDevSlnUser.setPSDevSlnSysId(null);
                    pSDevSlnUser.setPSDevSlnSysDynaInstId(null);
                    break;
                }
                case 3: {
                    pSDevSlnUser.setPSDevSlnSysId(null);
                    pSDevSlnUser.setPSDevSlnTemplId(null);
                }
            }
        }
        super.onBeforeCreate(pSDevSlnUser);
    }

    @Override
    protected void onBeforeUpdate(PSDevSlnUser pSDevSlnUser) throws Exception {
        PSDevSlnUser pSDevSlnUser2;
        if (PSDevSlnUserService.isMajorSessionFactory(this.getSessionFactory()) && DataObject.getBoolValue((Integer)(pSDevSlnUser2 = (PSDevSlnUser)this.getLast((IEntity)pSDevSlnUser)).getDefaultFlag(), (boolean)false)) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u66f4\u65b0\u5f00\u53d1\u65b9\u6848\u9ed8\u8ba4\u6210\u5458"));
        }
        super.onBeforeUpdate(pSDevSlnUser);
    }

    public PSDevSlnUser getPSDevSlnUser(PSDevSlnSys pSDevSlnSys, String string) throws Exception {
        PSDevSlnService pSDevSlnService = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class, (SessionFactory)this.getSessionFactory());
        PSDevSln pSDevSln = new PSDevSln();
        pSDevSln.setPSDevSlnId(pSDevSlnSys.getPSDevSlnId());
        pSDevSlnService.get((IEntity)pSDevSln);
        if (StringHelper.compare((String)pSDevSln.getAdminPSDevUserId(), (String)string, (boolean)false) == 0) {
            PSDevSlnUser pSDevSlnUser = new PSDevSlnUser();
            pSDevSlnUser.setPSDevSlnUserId(KeyValueHelper.genUniqueId((String)pSDevSlnSys.getPSDevSlnSysId(), (String)string));
            pSDevSlnUser.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
            pSDevSlnUser.setAccMode(3);
            return pSDevSlnUser;
        }
        ArrayList<PSDevSlnUser> arrayList = this.selectByPSDevSln(pSDevSlnSys.getPSDevSln());
        for (PSDevSlnUser pSDevSlnUser : arrayList) {
            if (DataObject.getBoolValue((Integer)pSDevSlnUser.getAllSysFlag(), (boolean)false) || StringHelper.compare((String)pSDevSlnUser.getPSDevSlnSysId(), (String)pSDevSlnSys.getPSDevSlnSysId(), (boolean)true) != 0 || StringHelper.compare((String)pSDevSlnUser.getPSDevUserObjId(), (String)string, (boolean)true) != 0) continue;
            return pSDevSlnUser;
        }
        for (PSDevSlnUser pSDevSlnUser : arrayList) {
            if (DataObject.getIntegerValue((Object)pSDevSlnUser.getAllSysFlag()) != 1 || StringHelper.compare((String)pSDevSlnUser.getPSDevUserObjId(), (String)string, (boolean)true) != 0) continue;
            return pSDevSlnUser;
        }
        return null;
    }

    public PSDevSlnUser getPSDevSlnUser(PSDevSlnTempl pSDevSlnTempl, String string) throws Exception {
        PSDevSlnService pSDevSlnService = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class, (SessionFactory)this.getSessionFactory());
        PSDevSln pSDevSln = new PSDevSln();
        pSDevSln.setPSDevSlnId(pSDevSlnTempl.getPSDevSlnId());
        pSDevSlnService.get((IEntity)pSDevSln);
        if (StringHelper.compare((String)pSDevSln.getAdminPSDevUserId(), (String)string, (boolean)false) == 0) {
            PSDevSlnUser pSDevSlnUser = new PSDevSlnUser();
            pSDevSlnUser.setPSDevSlnUserId(KeyValueHelper.genUniqueId((String)pSDevSlnTempl.getPSDevSlnTemplId(), (String)string));
            pSDevSlnUser.setPSDevSlnTemplId(pSDevSlnTempl.getPSDevSlnTemplId());
            pSDevSlnUser.setAccMode(3);
            return pSDevSlnUser;
        }
        ArrayList<PSDevSlnUser> arrayList = this.selectByPSDevSln(pSDevSlnTempl.getPSDevSln());
        for (PSDevSlnUser pSDevSlnUser : arrayList) {
            if (DataObject.getBoolValue((Integer)pSDevSlnUser.getAllSysFlag(), (boolean)false) || StringHelper.compare((String)pSDevSlnUser.getPSDevSlnTemplId(), (String)pSDevSlnTempl.getPSDevSlnTemplId(), (boolean)true) != 0 || StringHelper.compare((String)pSDevSlnUser.getPSDevUserObjId(), (String)string, (boolean)true) != 0) continue;
            return pSDevSlnUser;
        }
        for (PSDevSlnUser pSDevSlnUser : arrayList) {
            if (DataObject.getIntegerValue((Object)pSDevSlnUser.getAllSysFlag()) != 1 || StringHelper.compare((String)pSDevSlnUser.getPSDevUserObjId(), (String)string, (boolean)true) != 0) continue;
            return pSDevSlnUser;
        }
        return null;
    }

    public PSDevSlnUser getPSDevSlnUser(PSDevSlnSysDynaInst pSDevSlnSysDynaInst, String string) throws Exception {
        PSDevSlnService pSDevSlnService = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class, (SessionFactory)this.getSessionFactory());
        PSDevSln pSDevSln = new PSDevSln();
        pSDevSln.setPSDevSlnId(pSDevSlnSysDynaInst.getPSDevSlnId());
        pSDevSlnService.get((IEntity)pSDevSln);
        if (StringHelper.compare((String)pSDevSln.getAdminPSDevUserId(), (String)string, (boolean)false) == 0) {
            PSDevSlnUser pSDevSlnUser = new PSDevSlnUser();
            pSDevSlnUser.setPSDevSlnUserId(KeyValueHelper.genUniqueId((String)pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstId(), (String)string));
            pSDevSlnUser.setPSDevSlnSysDynaInstId(pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstId());
            pSDevSlnUser.setAccMode(3);
            return pSDevSlnUser;
        }
        ArrayList<PSDevSlnUser> arrayList = this.selectByPSDevSln(pSDevSlnSysDynaInst.getPSDevSln());
        for (PSDevSlnUser pSDevSlnUser : arrayList) {
            if (DataObject.getBoolValue((Integer)pSDevSlnUser.getAllSysFlag(), (boolean)false) || StringHelper.compare((String)pSDevSlnUser.getPSDevSlnSysDynaInstId(), (String)pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstId(), (boolean)true) != 0 || StringHelper.compare((String)pSDevSlnUser.getPSDevUserObjId(), (String)string, (boolean)true) != 0) continue;
            return pSDevSlnUser;
        }
        for (PSDevSlnUser pSDevSlnUser : arrayList) {
            if (DataObject.getIntegerValue((Object)pSDevSlnUser.getAllSysFlag()) != 1 || StringHelper.compare((String)pSDevSlnUser.getPSDevUserObjId(), (String)string, (boolean)true) != 0) continue;
            return pSDevSlnUser;
        }
        return null;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    protected void onAfterCreate(PSDevSlnUser pSDevSlnUser) throws Exception {
        super.onAfterCreate(pSDevSlnUser);
        if (pSDevSlnUser.getPSDevSln() == null) return;
        PSDevCenter pSDevCenter = pSDevSlnUser.getPSDevSln().getPSDevCenter();
        if (PSDevCenterHelper.isLabDC(pSDevCenter)) {
            if (PSDevSlnUserService.isCloudMode()) return;
            if (!PSDevSlnUserService.isEnableGitLabPlugin()) throw new Exception(StringHelper.format((String)"\u672a\u914d\u7f6eGitLab\u63d2\u4ef6"));
            try {
                PSDevSlnUserService.getPSGitLabPlugin().createMemberByPSDevSlnUser(pSDevSlnUser);
                return;
            }
            catch (Exception exception) {
                log.error((Object)StringHelper.format((String)"\u5efa\u7acb\u65b9\u6848\u6210\u5458\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
                throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u65b9\u6848\u6210\u5458\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
            }
        } else {
            if (pSDevCenter.getPSSvnInstRepo() == null || StringHelper.isNullOrEmpty((String)pSDevCenter.getPSSvnInstRepo().getPSSVNServerId())) return;
            PSUAWizard2 pSUAWizard2 = new PSUAWizard2();
            pSUAWizard2.set("pssvnserverid", pSDevCenter.getPSSvnInstRepo().getPSSVNServerId());
            PSUAWizard2Service pSUAWizard2Service = (PSUAWizard2Service)ServiceGlobal.getService(PSUAWizard2Service.class, (SessionFactory)this.getSessionFactory());
            pSUAWizard2Service.doUpdateSVNAuthZ(pSUAWizard2);
            if (pSDevCenter.getROPSSvnInstRepo() == null || StringHelper.isNullOrEmpty((String)pSDevCenter.getROPSSvnInstRepo().getPSSVNServerId()) || StringHelper.compare((String)pSDevCenter.getROPSSvnInstRepo().getPSSVNServerId(), (String)pSDevCenter.getPSSvnInstRepo().getPSSVNServerId(), (boolean)false) == 0) return;
            pSUAWizard2.set("pssvnserverid", pSDevCenter.getROPSSvnInstRepo().getPSSVNServerId());
            pSUAWizard2Service.doUpdateSVNAuthZ(pSUAWizard2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    protected void onAfterUpdate(PSDevSlnUser pSDevSlnUser) throws Exception {
        super.onAfterUpdate(pSDevSlnUser);
        if (pSDevSlnUser.getPSDevSln() == null) return;
        PSDevCenter pSDevCenter = pSDevSlnUser.getPSDevSln().getPSDevCenter();
        if (PSDevCenterHelper.isLabDC(pSDevCenter)) {
            if (PSDevSlnUserService.isCloudMode()) return;
            if (!PSDevSlnUserService.isEnableGitLabPlugin()) throw new Exception(StringHelper.format((String)"\u672a\u914d\u7f6eGitLab\u63d2\u4ef6"));
            try {
                PSDevSlnUserService.getPSGitLabPlugin().updateMemberByPSDevSlnUser(pSDevSlnUser);
                return;
            }
            catch (Exception exception) {
                log.error((Object)StringHelper.format((String)"\u66f4\u65b0\u65b9\u6848\u6210\u5458\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
                throw new Exception(StringHelper.format((String)"\u66f4\u65b0\u65b9\u6848\u6210\u5458\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
            }
        } else {
            if (pSDevCenter.getPSSvnInstRepo() == null || StringHelper.isNullOrEmpty((String)pSDevCenter.getPSSvnInstRepo().getPSSVNServerId())) return;
            PSUAWizard2 pSUAWizard2 = new PSUAWizard2();
            pSUAWizard2.set("pssvnserverid", pSDevCenter.getPSSvnInstRepo().getPSSVNServerId());
            PSUAWizard2Service pSUAWizard2Service = (PSUAWizard2Service)ServiceGlobal.getService(PSUAWizard2Service.class, (SessionFactory)this.getSessionFactory());
            pSUAWizard2Service.doUpdateSVNAuthZ(pSUAWizard2);
            if (pSDevCenter.getROPSSvnInstRepo() == null || StringHelper.isNullOrEmpty((String)pSDevCenter.getROPSSvnInstRepo().getPSSVNServerId()) || StringHelper.compare((String)pSDevCenter.getROPSSvnInstRepo().getPSSVNServerId(), (String)pSDevCenter.getPSSvnInstRepo().getPSSVNServerId(), (boolean)false) == 0) return;
            pSUAWizard2.set("pssvnserverid", pSDevCenter.getROPSSvnInstRepo().getPSSVNServerId());
            pSUAWizard2Service.doUpdateSVNAuthZ(pSUAWizard2);
        }
    }

    @Override
    protected void onBeforeRemove(PSDevSlnUser pSDevSlnUser) throws Exception {
        PSDevCenter pSDevCenter;
        if (PSDevSlnUserService.isMajorSessionFactory(this.getSessionFactory())) {
            this.get((IEntity)pSDevSlnUser);
            if (DataObject.getBoolValue((Integer)pSDevSlnUser.getDefaultFlag(), (boolean)false)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u5220\u9664\u5f00\u53d1\u65b9\u6848\u9ed8\u8ba4\u6210\u5458"));
            }
            if (pSDevSlnUser.getPSDevSln() != null && !PSDevCenterHelper.isLabDC(pSDevCenter = pSDevSlnUser.getPSDevSln().getPSDevCenter()) && pSDevCenter.getPSSvnInstRepo() != null && !StringHelper.isNullOrEmpty((String)pSDevCenter.getPSSvnInstRepo().getPSSVNServerId())) {
                PSUAWizard2 pSUAWizard2 = new PSUAWizard2();
                pSUAWizard2.set("pssvnserverid", pSDevCenter.getPSSvnInstRepo().getPSSVNServerId());
                PSUAWizard2Service pSUAWizard2Service = (PSUAWizard2Service)ServiceGlobal.getService(PSUAWizard2Service.class, (SessionFactory)this.getSessionFactory());
                pSUAWizard2Service.doUpdateSVNAuthZ(pSUAWizard2);
                if (pSDevCenter.getROPSSvnInstRepo() != null && !StringHelper.isNullOrEmpty((String)pSDevCenter.getROPSSvnInstRepo().getPSSVNServerId()) && StringHelper.compare((String)pSDevCenter.getROPSSvnInstRepo().getPSSVNServerId(), (String)pSDevCenter.getPSSvnInstRepo().getPSSVNServerId(), (boolean)false) != 0) {
                    pSUAWizard2.set("pssvnserverid", pSDevCenter.getROPSSvnInstRepo().getPSSVNServerId());
                    pSUAWizard2Service.doUpdateSVNAuthZ(pSUAWizard2);
                }
            }
        }
        super.onBeforeRemove(pSDevSlnUser);
        if (PSDevSlnUserService.isMajorSessionFactory(this.getSessionFactory()) && pSDevSlnUser.getPSDevSln() != null && PSDevCenterHelper.isLabDC(pSDevCenter = pSDevSlnUser.getPSDevSln().getPSDevCenter()) && !PSDevSlnUserService.isCloudMode()) {
            if (PSDevSlnUserService.isEnableGitLabPlugin()) {
                try {
                    PSDevSlnUserService.getPSGitLabPlugin().removeMemberByPSDevSlnUser(pSDevSlnUser);
                }
                catch (Exception exception) {
                    log.error((Object)StringHelper.format((String)"\u5220\u9664\u65b9\u6848\u6210\u5458\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
                    throw new Exception(StringHelper.format((String)"\u5220\u9664\u65b9\u6848\u6210\u5458\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
                }
            } else {
                throw new Exception(StringHelper.format((String)"\u672a\u914d\u7f6eGitLab\u63d2\u4ef6"));
            }
        }
    }
}

