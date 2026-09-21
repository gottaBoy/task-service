/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.psrt.srv.wf.service;

import java.util.ArrayList;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.codelist.WFUCPolicyStateCodeListModel;
import net.ibizsys.psrt.srv.wf.entity.WFUCPolicy;
import net.ibizsys.psrt.srv.wf.entity.WFUser;
import net.ibizsys.psrt.srv.wf.entity.WFUserCandidate;
import net.ibizsys.psrt.srv.wf.service.WFUCPolicyServiceBase;
import net.ibizsys.psrt.srv.wf.service.WFUserCandidateService;
import net.ibizsys.psrt.srv.wf.service.WFUserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class WFUCPolicyService
extends WFUCPolicyServiceBase {
    private static final Log log = LogFactory.getLog(WFUCPolicyService.class);

    @Override
    protected void onEnablePolicy(WFUCPolicy wFUCPolicy) throws Exception {
        wFUCPolicy.resetPolicyState();
        wFUCPolicy.setValidFlag(1);
        this.update(wFUCPolicy);
    }

    @Override
    protected void onDisablePolicy(WFUCPolicy wFUCPolicy) throws Exception {
        wFUCPolicy.resetPolicyState();
        wFUCPolicy.setValidFlag(0);
        this.update(wFUCPolicy);
    }

    @Override
    protected void onBeforeCreate(WFUCPolicy et) throws Exception {
        this.calcWFUCPolicyState(et);
        this.calcWFUCPolicyName(et);
        super.onBeforeCreate(et);
    }

    @Override
    protected void onBeforeUpdate(WFUCPolicy et) throws Exception {
        this.calcWFUCPolicyState(et);
        this.calcWFUCPolicyName(et);
        super.onBeforeUpdate(et);
    }

    @Override
    protected void onAfterRemove(WFUCPolicy et) throws Exception {
        this.removeWFUserCandidate(et);
        super.onAfterRemove(et);
    }

    @Override
    protected void onAfterCreate(WFUCPolicy et) throws Exception {
        this.createOrRemoveWFUserCandidate(et);
        super.onAfterCreate(et);
    }

    @Override
    protected void onAfterUpdate(WFUCPolicy et) throws Exception {
        this.createOrRemoveWFUserCandidate(et);
        super.onAfterUpdate(et);
    }

    protected void calcWFUCPolicyName(WFUCPolicy et) throws Exception {
        if (et.getMajorWFUser() != null && et.getMinorWFUser() != null) {
            String strWFUCPolicyName = StringHelper.format("\u6d41\u7a0b\u5de5\u4f5c\u59d4\u6258\u7b56\u7565[%1$s-%2$s]", et.getMajorWFUserName(), et.getMinorWFUserName());
            et.setWFUCPolicyName(strWFUCPolicyName);
        }
    }

    protected void calcWFUCPolicyState(WFUCPolicy et) throws Exception {
        if (et.getPolicyState() == null) {
            boolean bValidFlag = DataObject.getBoolValue(et.getValidFlag(), true);
            if (bValidFlag) {
                if (et.getBeginTime() != null && et.getBeginTime().getTime() > System.currentTimeMillis()) {
                    et.setPolicyState(WFUCPolicyStateCodeListModel.NOTAPPLIED);
                    return;
                }
                if (et.getEndTime() != null && et.getEndTime().getTime() < System.currentTimeMillis()) {
                    et.setPolicyState(WFUCPolicyStateCodeListModel.EXPIRED);
                    return;
                }
                et.setPolicyState(WFUCPolicyStateCodeListModel.APPLIED);
                return;
            }
            et.setPolicyState(WFUCPolicyStateCodeListModel.CANCELED);
            return;
        }
    }

    protected void createOrRemoveWFUserCandidate(WFUCPolicy et) throws Exception {
        if (et.getPolicyState() != null) {
            if (et.getPolicyState() == WFUCPolicyStateCodeListModel.APPLIED) {
                this.createWFUserCandidate(et);
            } else {
                this.removeWFUserCandidate(et);
            }
        }
    }

    protected void createWFUserCandidate(WFUCPolicy et) throws Exception {
        WFUserCandidate wfUserCandidate = new WFUserCandidate();
        wfUserCandidate.setWFUserCandidateId(et.getWFUCPolicyId());
        WFUserCandidateService wfUserCandidateService = (WFUserCandidateService)ServiceGlobal.getService(WFUserCandidateService.class, this.getSessionFactory());
        if (wfUserCandidateService.checkKey(wfUserCandidate) == 0) {
            wfUserCandidate.setWFUserCandidateName(et.getMinorWFUserName());
            wfUserCandidate.setWFMajorUserId(et.getMajorWFUserId());
            wfUserCandidate.setWFMajorUserName(et.getMajorWFUserName());
            wfUserCandidate.setWFMinorUserId(et.getMinorWFUserId());
            wfUserCandidate.setWFMinorUserName(et.getMinorWFUserName());
            wfUserCandidate.setUserData(et.getWFUCPolicyId());
            wfUserCandidateService.create(wfUserCandidate, false);
            WFUser wfUser = new WFUser();
            wfUser.setWFUserId(wfUserCandidate.getWFMajorUserId());
            wfUser.setIsRecvWork(0);
            WFUserService wfUserService = (WFUserService)ServiceGlobal.getService(WFUserService.class, this.getSessionFactory());
            wfUserService.update(wfUser, false);
        }
    }

    protected void removeWFUserCandidate(WFUCPolicy et) throws Exception {
        WFUserCandidate wfUserCandidate = new WFUserCandidate();
        wfUserCandidate.setWFUserCandidateId(et.getWFUCPolicyId());
        WFUserCandidateService wfUserCandidateService = (WFUserCandidateService)ServiceGlobal.getService(WFUserCandidateService.class, this.getSessionFactory());
        if (wfUserCandidateService.get(wfUserCandidate, true)) {
            wfUserCandidateService.remove(wfUserCandidate);
            WFUser wfUser = new WFUser();
            wfUser.setWFUserId(wfUserCandidate.getWFMajorUserId());
            ArrayList<WFUserCandidate> wfUserCandidateList = wfUserCandidateService.selectByWFMajorUser(wfUser);
            if (wfUserCandidateList.size() == 0) {
                wfUser.setIsRecvWork(1);
            } else {
                wfUser.setIsRecvWork(0);
            }
            WFUserService wfUserService = (WFUserService)ServiceGlobal.getService(WFUserService.class, this.getSessionFactory());
            wfUserService.update(wfUser, false);
        }
    }
}

