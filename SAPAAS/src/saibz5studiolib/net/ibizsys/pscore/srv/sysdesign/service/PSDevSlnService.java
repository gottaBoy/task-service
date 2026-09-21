/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.WebContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.PSCoreSysServiceBaseBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUser;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDeploy;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnUser;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDeployService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnUserService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSUAWizard2;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSUAWizard2Base;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSUAWizard2Service;
import net.ibizsys.pscore.srv.util.PSDevCenterHelper;
import net.ibizsys.pscore.srv.util.gitlab.PSGitLabHelper;
import net.ibizsys.pscore.srv.util.gitlab.model.Group;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDevSlnService
extends PSDevSlnServiceBase {
    private static final Log log = LogFactory.getLog(PSDevSlnService.class);

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSDevSln pSDevSln, boolean bl) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("PSDEVSLNNAME", "\u5f00\u53d1\u65b9\u6848");
        hashMap.put("CODENAME", "DevSln");
        return hashMap;
    }

    @Override
    protected Map<String, Object> getGetDraftDefaultValueScope(PSDevSln pSDevSln, boolean bl) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("PSDEVCENTERID", "");
        return hashMap;
    }

    @Override
    protected void onBeforeCreate(PSDevSln pSDevSln) throws Exception {
        super.onBeforeCreate(pSDevSln);
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            PSDevCenter pSDevCenter;
            PSDevCenterHelper.testCreate(pSDevSln.getPSDevCenter(), "DEVSLNCNT", false);
            if (StringHelper.isNullOrEmpty((String)pSDevSln.getLogicName())) {
                pSDevSln.setLogicName(pSDevSln.getPSDevSlnName());
            }
            if (StringHelper.isNullOrEmpty((String)pSDevSln.getStudioVer()) && (pSDevCenter = pSDevSln.getPSDevCenter()) != null) {
                pSDevSln.setStudioVer(pSDevCenter.getStudioVer());
                if (StringHelper.isNullOrEmpty((String)pSDevSln.getStudioTag())) {
                    pSDevSln.setStudioTag(pSDevCenter.getStudioTag());
                }
                if (StringHelper.isNullOrEmpty((String)pSDevSln.getStudioTag2())) {
                    pSDevSln.setStudioTag2(pSDevCenter.getStudioTag2());
                }
            }
        }
    }

    @Override
    protected void internalCreate(PSDevSln pSDevSln) throws Exception {
        PSDevCenter pSDevCenter;
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory()) && (pSDevCenter = pSDevSln.getPSDevCenter()) != null && PSDevSlnService.isEnableGitLabPlugin() && pSDevCenter.getV6PSSvnInstRepo() != null) {
            pSDevSln.setSlnTag(pSDevCenter.getV6PSSvnInstRepo().getPSSVNServerId());
            Group group = PSDevSlnService.getPSGitLabPlugin().createGroupByPSDevSln(pSDevSln);
            PSDevCenterSVN pSDevCenterSVN = PSGitLabHelper.createPSDevCenterSVN(pSDevCenter, pSDevSln, group);
            pSDevSln.setPSDevCenterSVNId(pSDevCenterSVN.getPSDevCenterSVNId());
            pSDevSln.setPSDevCenterSVNName(pSDevCenterSVN.getPSDevCenterName());
        }
        super.internalCreate(pSDevSln);
    }

    @Override
    protected void onAfterCreate(PSDevSln pSDevSln) throws Exception {
        super.onAfterCreate(pSDevSln);
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            PSDevCenter pSDevCenter = pSDevSln.getPSDevCenter();
            if (!PSDevCenterHelper.isRecycleDC(pSDevCenter)) {
                if (PSDevCenterHelper.isLabDC(pSDevCenter)) {
                    String string = null;
                    if (WebContext.getCurrent() != null) {
                        string = WebContext.getCurrent().getCurLoginName();
                    }
                    if (!StringHelper.isNullOrEmpty(string)) {
                        int n = 2;
                        if (PSDevSlnService.isCloudMode()) {
                            n = 0;
                        }
                        PSDevUser pSDevUser = PSDevCenterHelper.getPSDevUser(pSDevCenter, string, n);
                        PSDevSlnUserService pSDevSlnUserService = (PSDevSlnUserService)ServiceGlobal.getService(PSDevSlnUserService.class, (SessionFactory)this.getSessionFactory());
                        PSDevSlnUser pSDevSlnUser = new PSDevSlnUser();
                        pSDevSlnUser.setDefaultFlag(1);
                        pSDevSlnUser.setAllSysFlag(1);
                        pSDevSlnUser.setAccMode(19);
                        pSDevSlnUser.setPSDevSlnId(pSDevSln.getPSDevSlnId());
                        pSDevSlnUser.setPSDevSlnName(pSDevSln.getPSDevSlnName());
                        pSDevSlnUser.setPSDevUserObjId(pSDevUser.getPSDevUserId());
                        pSDevSlnUser.setPSDevUserObjName(pSDevUser.getPSDevUserName());
                        pSDevSlnUserService.create(pSDevSlnUser);
                    } else {
                        log.warn((Object)StringHelper.format((String)"\u65e0\u6cd5\u4e3a\u5f00\u53d1\u65b9\u6848[%1$s]\u653e\u5165\u9ed8\u8ba4\u6210\u5458\uff0c\u5f53\u524d\u7528\u6237\u65e0\u6548", (Object)pSDevSln.getPSDevSlnName()));
                    }
                } else if (!StringHelper.isNullOrEmpty((String)pSDevSln.getAdminPSDevUserId()) && pSDevCenter.getPSSvnInstRepo() != null && !StringHelper.isNullOrEmpty((String)pSDevCenter.getPSSvnInstRepo().getPSSVNServerId())) {
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
            PSDevCenterHelper.updatetPSDCResRep(pSDevCenter, "DEVSLNCNT");
        }
    }

    @Override
    protected void onAfterUpdate(PSDevSln pSDevSln) throws Exception {
        PSDevCenter pSDevCenter;
        super.onAfterUpdate(pSDevSln);
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory()) && !PSDevCenterHelper.isRecycleDC(pSDevCenter = pSDevSln.getPSDevCenter()) && !PSDevCenterHelper.isLabDC(pSDevCenter) && pSDevCenter.getPSSvnInstRepo() != null && !StringHelper.isNullOrEmpty((String)pSDevCenter.getPSSvnInstRepo().getPSSVNServerId())) {
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

    @Override
    protected void onBeforeRemove(PSDevSln pSDevSln) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            PSDevSln pSDevSln2 = (PSDevSln)this.getLast((IEntity)pSDevSln);
            Object object = (PSDevSlnUserService)ServiceGlobal.getService(PSDevSlnUserService.class, (SessionFactory)this.getSessionFactory());
            Object object2 = new SelectCond();
            object2.set("PSDEVSLNID", (Object)pSDevSln2.getPSDevSlnId());
            object2.set("ALLSYSFLAG", (Object)1);
            object2.set("DEFAULTFLAG", (Object)1);
            Object object3 = object.select((ISelectCond)object2);
            Iterator iterator = ((ArrayList)object3).iterator();
            while (iterator.hasNext()) {
                PSDevSlnUser pSDevSlnUser = (PSDevSlnUser)iterator.next();
                PSDevSlnUser pSDevSlnUser2 = new PSDevSlnUser();
                pSDevSlnUser2.setPSDevSlnUserId(pSDevSlnUser.getPSDevSlnUserId());
                pSDevSlnUser2.setDefaultFlag(0);
                ((PSCoreSysServiceBaseBase)((Object)object)).sysUpdate(pSDevSlnUser2, false);
            }
            object = pSDevSln2.getPSDevCenter();
            if (!(PSDevCenterHelper.isRecycleDC((PSDevCenter)object) || PSDevCenterHelper.isLabDC((PSDevCenter)object) || ((PSDevCenterBase)object).getPSSvnInstRepo() == null || StringHelper.isNullOrEmpty((String)((PSDevCenterBase)object).getPSSvnInstRepo().getPSSVNServerId()))) {
                object2 = new PSUAWizard2();
                ((PSUAWizard2Base)object2).set("pssvnserverid", ((PSDevCenterBase)object).getPSSvnInstRepo().getPSSVNServerId());
                object3 = (PSUAWizard2Service)ServiceGlobal.getService(PSUAWizard2Service.class, (SessionFactory)this.getSessionFactory());
                ((PSUAWizard2Service)object3).doUpdateSVNAuthZ((PSUAWizard2)object2);
                if (((PSDevCenterBase)object).getROPSSvnInstRepo() != null && !StringHelper.isNullOrEmpty((String)((PSDevCenterBase)object).getROPSSvnInstRepo().getPSSVNServerId()) && StringHelper.compare((String)((PSDevCenterBase)object).getROPSSvnInstRepo().getPSSVNServerId(), (String)((PSDevCenterBase)object).getPSSvnInstRepo().getPSSVNServerId(), (boolean)false) != 0) {
                    ((PSUAWizard2Base)object2).set("pssvnserverid", ((PSDevCenterBase)object).getROPSSvnInstRepo().getPSSVNServerId());
                    ((PSUAWizard2Service)object3).doUpdateSVNAuthZ((PSUAWizard2)object2);
                }
            }
        }
        super.onBeforeRemove(pSDevSln);
    }

    @Override
    protected boolean isPrepareLastForRemove() {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            return true;
        }
        return super.isPrepareLastForRemove();
    }

    @Override
    protected void onAfterRemove(PSDevSln pSDevSln) throws Exception {
        if (this.isMajorSessionFactory()) {
            PSDevSln pSDevSln2 = (PSDevSln)this.getLast((IEntity)pSDevSln);
            PSDevCenterHelper.updatetPSDCResRep(pSDevSln2.getPSDevCenter(), "DEVSLNCNT");
        }
        super.onAfterRemove(pSDevSln);
    }

    @Override
    protected void onFixPSDCSVNs(PSDevSln pSDevSln) throws Exception {
        Object object;
        if (!this.isMajorSessionFactory()) {
            return;
        }
        if (!PSDevSlnService.isEnableGitLabPlugin()) {
            return;
        }
        this.get((IEntity)pSDevSln);
        if (StringHelper.isNullOrEmpty((String)pSDevSln.getSlnTag()) && StringHelper.isNullOrEmpty((String)pSDevSln.getPSDevCenterSVNId())) {
            return;
        }
        ArrayList<PSDevSlnSys> arrayList = pSDevSln.getPSDevSlnSyss();
        if (arrayList != null && arrayList.size() > 0) {
            object = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
            for (PSDevSlnSys object2 : arrayList) {
                ((PSDevSlnSysServiceBase)object).fixPSDCSVNs(object2);
            }
        }
        if ((object = pSDevSln.getPSDevSlnUsers()) != null && ((ArrayList)object).size() > 0) {
            PSDevSlnUserService pSDevSlnUserService = (PSDevSlnUserService)ServiceGlobal.getService(PSDevSlnUserService.class, (SessionFactory)this.getSessionFactory());
            Iterator iterator = ((ArrayList)object).iterator();
            while (iterator.hasNext()) {
                PSDevSlnUser pSDevSlnUser = (PSDevSlnUser)iterator.next();
                try {
                    pSDevSlnUserService.update(pSDevSlnUser);
                }
                catch (Exception exception) {
                    log.error((Object)String.format("\u540c\u6b65\u5f00\u53d1\u7528\u6237[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", pSDevSlnUser.getPSDevSlnUserName(), exception.getMessage()));
                }
            }
        }
    }

    @Override
    protected void onPubMSDConfigs(PSDevSln pSDevSln) throws Exception {
        if (!this.isMajorSessionFactory()) {
            return;
        }
        PSDevSlnMSDeployService pSDevSlnMSDeployService = (PSDevSlnMSDeployService)ServiceGlobal.getService(PSDevSlnMSDeployService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDevSlnMSDeploy> arrayList = pSDevSlnMSDeployService.selectByPSDevSln(pSDevSln);
        if (arrayList == null || arrayList.size() == 0) {
            throw new Exception("\u5f00\u653e\u65b9\u6848\u672a\u5b9a\u4e49\u5fae\u670d\u52a1\u5e73\u53f0\u90e8\u7f72\u65b9\u6848");
        }
        for (PSDevSlnMSDeploy pSDevSlnMSDeploy : arrayList) {
            pSDevSlnMSDeployService.pubConfigs(pSDevSlnMSDeploy);
        }
    }
}

