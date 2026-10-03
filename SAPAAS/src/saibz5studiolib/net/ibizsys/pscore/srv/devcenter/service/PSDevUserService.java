/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.psrt.srv.common.entity.LoginAccount
 *  net.ibizsys.psrt.srv.common.service.LoginAccountService
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.devcenter.service;

import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUser;
import net.ibizsys.pscore.srv.devcenter.service.PSDevUserServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSUAWizard2;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSUAWizard2Base;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSUAWizard2Service;
import net.ibizsys.pscore.srv.util.PSDevCenterHelper;
import net.ibizsys.psrt.srv.common.entity.LoginAccount;
import net.ibizsys.psrt.srv.common.service.LoginAccountService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDevUserService
extends PSDevUserServiceBase {
    private static final String _PASSWORD_ = "__HASH_PASS__";
    private static final Log log = LogFactory.getLog(PSDevUserService.class);

    protected void onAfterGet(PSDevUser pSDevUser) throws Exception {
        super.onAfterGet(pSDevUser);
        pSDevUser.setLoginPwd(_PASSWORD_);
    }

    @Override
    protected void onBeforeCreate(PSDevUser pSDevUser) throws Exception {
        if (this.isMajorSessionFactory() && !DataObject.getBoolValue((Integer)pSDevUser.getDefaultFlag(), (boolean)false)) {
            PSDevCenterHelper.testCreatePSDevUser(pSDevUser, false);
        }
        super.onBeforeCreate(pSDevUser);
    }

    @Override
    protected void onAfterCreate(PSDevUser pSDevUser) throws Exception {
        super.onAfterCreate(pSDevUser);
        if (StringHelper.isNullOrEmpty((String)pSDevUser.getFromPSDevUserId()) && !DataObject.getBoolValue((Integer)pSDevUser.getFromUserMode(), (boolean)false)) {
            String string3;
            String string4 = pSDevUser.getLoginPwd();
            if (StringHelper.isNullOrEmpty((String)string4)) {
                string4 = "123456";
            }
            boolean bl = false;
            PSDevCenter pSDevCenter = pSDevUser.getPSDevCenter();
            if (pSDevCenter.getDCLevel() != null && pSDevCenter.getDCLevel() >= 10 && pSDevCenter.getDCLevel() < 100) {
                bl = true;
            }
            if (StringHelper.isNullOrEmpty((String)(string3 = pSDevUser.getFullLoginName()))) {
                string3 = bl ? pSDevUser.getLoginName() : (!StringHelper.isNullOrEmpty((String)pSDevCenter.getFullDomainName()) ? StringHelper.format((String)"%1$s@%2$s", (Object)pSDevUser.getLoginName(), (Object)pSDevCenter.getFullDomainName()) : StringHelper.format((String)"%1$s@%2$s", (Object)pSDevUser.getLoginName(), (Object)pSDevCenter.getDomainName()));
            }
            if (!PSDevUserService.isCloudMode()) {
                LoginAccount loginAccount = new LoginAccount();
                loginAccount.setPwd(KeyValueHelper.genUniqueId((String)string3, (String)string4));
                loginAccount.setLoginAccountName(string3);
                loginAccount.setUserId(pSDevUser.getPSDevUserId());
                loginAccount.setUserName(pSDevUser.getPSDevUserName());
                loginAccount.setIsEnable(Integer.valueOf(1));
                LoginAccountService loginAccountService = (LoginAccountService)ServiceGlobal.getService(LoginAccountService.class, (SessionFactory)this.getSessionFactory());
                loginAccountService.create(loginAccount);
                Object object = new PSUAWizard2();
                ((PSUAWizard2Base)object).set("loginname", string3);
                ((PSUAWizard2Base)object).set("oripassword", string4);
                ((PSUAWizard2Base)object).set("newpassword", string4);
                ((PSUAWizard2Base)object).set("newpassword2", string4);
                ((PSUAWizard2Base)object).set("psdevcenterid", pSDevCenter.getPSDevCenterId());
                Object object2 = (PSUAWizard2Service)ServiceGlobal.getService(PSUAWizard2Service.class, (SessionFactory)this.getSessionFactory());
                ((PSUAWizard2Service)object2).doCreateUser((PSUAWizard2)object);
                object = pSDevUser.getFullLoginName2();
                if (!StringHelper.isNullOrEmpty((String)object)) {
                    loginAccount.reset();
                    loginAccount.setPwd(KeyValueHelper.genUniqueId((String)object, (String)string4));
                    loginAccount.setLoginAccountName((String)object);
                    loginAccount.setUserId(pSDevUser.getPSDevUserId());
                    loginAccount.setUserName(pSDevUser.getPSDevUserName());
                    loginAccount.setIsEnable(Integer.valueOf(1));
                    loginAccountService.create(loginAccount);
                    object2 = new PSUAWizard2();
                    ((PSUAWizard2Base)object2).set("loginname", object);
                    ((PSUAWizard2Base)object2).set("oripassword", string4);
                    ((PSUAWizard2Base)object2).set("newpassword", string4);
                    ((PSUAWizard2Base)object2).set("newpassword2", string4);
                    ((PSUAWizard2Base)object2).set("psdevcenterid", pSDevCenter.getPSDevCenterId());
                    PSUAWizard2Service pSUAWizard2Service = (PSUAWizard2Service)ServiceGlobal.getService(PSUAWizard2Service.class, (SessionFactory)this.getSessionFactory());
                    pSUAWizard2Service.doCreateUser((PSUAWizard2)object2);
                }
                if (bl) {
                    if (PSDevUserService.isEnableGitLabPlugin()) {
                        try {
                            PSDevUserService.getPSGitLabPlugin().createUserByPSDevUser(pSDevUser);
                        }
                        catch (Exception exception) {
                            log.error((Object)StringHelper.format((String)"\u5efa\u7acb\u4ed3\u5e93\u7528\u6237\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
                            throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u4ed3\u5e93\u7528\u6237\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
                        }
                    } else {
                        throw new Exception(StringHelper.format((String)"\u672a\u914d\u7f6eGitLab\u63d2\u4ef6"));
                    }
                }
            }
            String devUserId = pSDevUser.getPSDevUserId();
            String devCenterId = pSDevUser.getPSDevCenterId();
            pSDevUser.reset();
            pSDevUser.setPSDevUserId(devUserId);
            pSDevUser.setPSDevCenterId(devCenterId);
            pSDevUser.setFullLoginName(string3);
            pSDevUser.setLoginPwd(_PASSWORD_);
            this.update(pSDevUser);
        }
        if (this.isMajorSessionFactory()) {
            PSDevCenterHelper.updatetPSDCResRep(pSDevUser.getPSDevCenter(), "USERCNT");
        }
    }

    @Override
    protected void onBeforeUpdate(PSDevUser pSDevUser) throws Exception {
        PSDevUser pSDevUser2 = new PSDevUser();
        pSDevUser2.setPSDevUserId(pSDevUser.getPSDevUserId());
        this.get(pSDevUser2);
        if (this.isMajorSessionFactory()) {
            boolean bl = false;
            bl = pSDevUser.getDefaultFlag() != null ? DataObject.getBoolValue((Integer)pSDevUser.getDefaultFlag(), (boolean)false) : DataObject.getBoolValue((Integer)pSDevUser2.getDefaultFlag(), (boolean)false);
            if (!bl && pSDevUser.getValidFlag() != null && EntityBase.getBoolValue((Integer)pSDevUser.getValidFlag(), (boolean)true) && !EntityBase.getBoolValue((Integer)pSDevUser2.getValidFlag(), (boolean)false)) {
                PSDevCenterHelper.testCreatePSDevUser(pSDevUser, false);
            }
        }
        if (pSDevUser2 == null || StringHelper.isNullOrEmpty((String)pSDevUser2.getFromPSDevUserId()) && !DataObject.getBoolValue((Integer)pSDevUser2.getFromUserMode(), (boolean)false)) {
            PSDevCenter pSDevCenter = pSDevUser.getPSDevCenter();
            if (pSDevCenter == null || pSDevUser2 != null) {
                pSDevCenter = pSDevUser2.getPSDevCenter();
            }
            boolean bl = false;
            if (pSDevCenter.getDCLevel() != null && pSDevCenter.getDCLevel() >= 10 && pSDevCenter.getDCLevel() < 100) {
                bl = true;
            }
            if (!PSDevUserService.isCloudMode()) {
                PSUAWizard2Service pSUAWizard2Service;
                PSUAWizard2 pSUAWizard2;
                LoginAccountService loginAccountService = (LoginAccountService)ServiceGlobal.getService(LoginAccountService.class, (SessionFactory)this.getSessionFactory());
                if (!StringHelper.isNullOrEmpty((String)pSDevUser.getFullLoginName())) {
                    LoginAccount loginAccount = new LoginAccount();
                    loginAccount.setLoginAccountName(pSDevUser.getFullLoginName());
                    loginAccountService.select(loginAccount, false);
                    boolean bl2 = false;
                    if (DataObject.getBoolValue((Integer)pSDevUser.getValidFlag(), (boolean)true) != DataObject.getBoolValue((Integer)loginAccount.getIsEnable(), (boolean)true)) {
                        bl2 = true;
                        loginAccount.setIsEnable(pSDevUser.getValidFlag());
                    }
                    if (StringHelper.compare((String)pSDevUser.getLoginPwd(), (String)_PASSWORD_, (boolean)true) != 0) {
                        loginAccount.setPwd(KeyValueHelper.genUniqueId((String)pSDevUser.getFullLoginName(), (String)pSDevUser.getLoginPwd()));
                        loginAccountService.update(loginAccount, false);
                        pSUAWizard2 = new PSUAWizard2();
                        pSUAWizard2.set("loginname", pSDevUser.getFullLoginName());
                        pSUAWizard2.set("oripassword", pSDevUser.getLoginPwd());
                        pSUAWizard2.set("newpassword", pSDevUser.getLoginPwd());
                        pSUAWizard2.set("newpassword2", pSDevUser.getLoginPwd());
                        pSUAWizard2.set("psdevcenterid", pSDevUser.getPSDevCenterId());
                        pSUAWizard2.set("updateloginaccount", 0);
                        pSUAWizard2Service = (PSUAWizard2Service)ServiceGlobal.getService(PSUAWizard2Service.class, (SessionFactory)this.getSessionFactory());
                        pSUAWizard2Service.doChangePwd(pSUAWizard2);
                    } else if (bl2) {
                        loginAccountService.update(loginAccount, false);
                    }
                }
                if (!StringHelper.isNullOrEmpty((String)pSDevUser.getFullLoginName2())) {
                    boolean bl3 = false;
                    LoginAccount loginAccount = new LoginAccount();
                    loginAccount.setLoginAccountName(pSDevUser.getFullLoginName2());
                    if (loginAccountService.select(loginAccount, true) && DataObject.getBoolValue((Integer)pSDevUser.getValidFlag(), (boolean)true) != DataObject.getBoolValue((Integer)loginAccount.getIsEnable(), (boolean)true)) {
                        bl3 = true;
                        loginAccount.setIsEnable(pSDevUser.getValidFlag());
                    }
                    if (StringHelper.compare((String)pSDevUser.getLoginPwd(), (String)_PASSWORD_, (boolean)true) != 0) {
                        if (StringHelper.compare((String)pSDevUser2.getFullLoginName2(), (String)pSDevUser.getFullLoginName2(), (boolean)true) == 0) {
                            loginAccount.setPwd(KeyValueHelper.genUniqueId((String)pSDevUser.getFullLoginName2(), (String)pSDevUser.getLoginPwd()));
                            loginAccountService.update(loginAccount, false);
                            pSUAWizard2 = new PSUAWizard2();
                            pSUAWizard2.set("loginname", pSDevUser.getFullLoginName2());
                            pSUAWizard2.set("oripassword", pSDevUser.getLoginPwd());
                            pSUAWizard2.set("newpassword", pSDevUser.getLoginPwd());
                            pSUAWizard2.set("newpassword2", pSDevUser.getLoginPwd());
                            pSUAWizard2.set("psdevcenterid", pSDevUser2.getPSDevCenterId());
                            pSUAWizard2.set("updateloginaccount", 0);
                            pSUAWizard2Service = (PSUAWizard2Service)ServiceGlobal.getService(PSUAWizard2Service.class, (SessionFactory)this.getSessionFactory());
                            pSUAWizard2Service.doChangePwd(pSUAWizard2);
                        } else {
                            if (!StringHelper.isNullOrEmpty((String)pSDevUser2.getFullLoginName2())) {
                                loginAccount.reset();
                                loginAccount.setLoginAccountName(pSDevUser2.getFullLoginName2());
                                loginAccountService.select(loginAccount, false);
                                loginAccount.setIsEnable(Integer.valueOf(0));
                                loginAccount.setLoginAccountName(pSDevUser2.getFullLoginName2() + "@old_" + KeyValueHelper.genGuidEx());
                                loginAccountService.update(loginAccount, false);
                            }
                            loginAccount.reset();
                            loginAccount.setPwd(KeyValueHelper.genUniqueId((String)pSDevUser.getFullLoginName2(), (String)pSDevUser.getLoginPwd()));
                            loginAccount.setLoginAccountName(pSDevUser.getFullLoginName2());
                            loginAccount.setUserId(pSDevUser2.getPSDevUserId());
                            loginAccount.setUserName(pSDevUser2.getPSDevUserName());
                            loginAccount.setIsEnable(pSDevUser.getValidFlag());
                            loginAccountService.create(loginAccount);
                            pSUAWizard2 = new PSUAWizard2();
                            pSUAWizard2.set("loginname", pSDevUser.getFullLoginName2());
                            pSUAWizard2.set("oripassword", pSDevUser.getLoginPwd());
                            pSUAWizard2.set("newpassword", pSDevUser.getLoginPwd());
                            pSUAWizard2.set("newpassword2", pSDevUser.getLoginPwd());
                            pSUAWizard2.set("psdevcenterid", pSDevUser2.getPSDevCenterId());
                            pSUAWizard2Service = (PSUAWizard2Service)ServiceGlobal.getService(PSUAWizard2Service.class, (SessionFactory)this.getSessionFactory());
                            pSUAWizard2Service.doCreateUser(pSUAWizard2);
                        }
                    } else if (bl3) {
                        loginAccountService.update(loginAccount, false);
                    }
                }
            }
        }
        pSDevUser.setLoginPwd(_PASSWORD_);
        super.onBeforeUpdate(pSDevUser);
    }

    @Override
    protected void onAfterUpdate(PSDevUser pSDevUser) throws Exception {
        super.onAfterUpdate(pSDevUser);
        if (this.isMajorSessionFactory()) {
            PSDevCenter pSDevCenter;
            if (StringHelper.isNullOrEmpty((String)pSDevUser.getFromPSDevUserId()) && !DataObject.getBoolValue((Integer)pSDevUser.getFromUserMode(), (boolean)false) && !PSDevCenterHelper.isLabDC(pSDevCenter = pSDevUser.getPSDevCenter()) && (StringHelper.isNullOrEmpty((String)pSDevCenter.getStudioVer()) || "S0500".equals(pSDevCenter.getStudioVer())) && pSDevCenter.getPSSvnInstRepo() != null && !StringHelper.isNullOrEmpty((String)pSDevCenter.getPSSvnInstRepo().getPSSVNServerId())) {
                PSUAWizard2 pSUAWizard2 = new PSUAWizard2();
                pSUAWizard2.set("pssvnserverid", pSDevCenter.getPSSvnInstRepo().getPSSVNServerId());
                PSUAWizard2Service pSUAWizard2Service = (PSUAWizard2Service)ServiceGlobal.getService(PSUAWizard2Service.class, (SessionFactory)this.getSessionFactory());
                pSUAWizard2Service.doUpdateSVNAuthZ(pSUAWizard2);
                if (pSDevCenter.getROPSSvnInstRepo() != null && !StringHelper.isNullOrEmpty((String)pSDevCenter.getROPSSvnInstRepo().getPSSVNServerId()) && StringHelper.compare((String)pSDevCenter.getROPSSvnInstRepo().getPSSVNServerId(), (String)pSDevCenter.getPSSvnInstRepo().getPSSVNServerId(), (boolean)false) != 0) {
                    pSUAWizard2.set("pssvnserverid", pSDevCenter.getROPSSvnInstRepo().getPSSVNServerId());
                    pSUAWizard2Service.doUpdateSVNAuthZ(pSUAWizard2);
                }
            }
            PSDevCenterHelper.updatetPSDCResRep(pSDevUser.getPSDevCenter(), "USERCNT");
        }
    }

    @Override
    protected void onBeforeRemove(PSDevUser pSDevUser) throws Exception {
        if (this.isMajorSessionFactory()) {
            PSDevCenter pSDevCenter;
            this.get(pSDevUser);
            if (DataObject.getBoolValue((Integer)pSDevUser.getDefaultFlag(), (boolean)false)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u5220\u9664\u4e2d\u5fc3\u9ed8\u8ba4\u7528\u6237"));
            }
            if (StringHelper.isNullOrEmpty((String)pSDevUser.getFromPSDevUserId()) && !DataObject.getBoolValue((Integer)pSDevUser.getFromUserMode(), (boolean)false) && !PSDevCenterHelper.isLabDC(pSDevCenter = pSDevUser.getPSDevCenter()) && (StringHelper.isNullOrEmpty((String)pSDevCenter.getStudioVer()) || "S0500".equals(pSDevCenter.getStudioVer())) && pSDevCenter.getPSSvnInstRepo() != null && !StringHelper.isNullOrEmpty((String)pSDevCenter.getPSSvnInstRepo().getPSSVNServerId())) {
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
        super.onBeforeRemove(pSDevUser);
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    @Override
    protected void onToggleInvalid(PSDevUser pSDevUser) throws Exception {
    }

    @Override
    protected void onToggleValid(PSDevUser pSDevUser) throws Exception {
    }

    @Override
    protected void onInitAliasUser(PSDevUser pSDevUser) throws Exception {
        this.get(pSDevUser);
        if (DataObject.getBoolValue((Integer)pSDevUser.getFromUserMode(), (boolean)false)) {
            return;
        }
        if (DataObject.getBoolValue((Integer)pSDevUser.getAliasUserMode(), (boolean)false)) {
            return;
        }
        PSDevUser pSDevUser2 = new PSDevUser();
        pSDevUser2.setPSDevCenterId(pSDevUser.getPSDevCenterId());
        pSDevUser2.setAliasUserMode(1);
        pSDevUser2.setAliasPSDevUserId(pSDevUser.getPSDevUserId());
        if (this.select(pSDevUser2, true)) {
            return;
        }
        pSDevUser2.setPSDevCenterName(pSDevUser.getPSDevCenterName());
        pSDevUser2.setFromUserMode(1);
        pSDevUser2.setAliasPSDevUserName(pSDevUser.getPSDevUserName());
        pSDevUser2.setPSDevUserName(StringHelper.format((String)"%1$s\uff08\u522b\u540d\uff09", (Object)pSDevUser.getPSDevUserName()));
        pSDevUser2.setAdminMode(pSDevUser.getAdminMode());
        this.create(pSDevUser2);
    }

    @Override
    protected boolean isPrepareLastForRemove() {
        if (this.isMajorSessionFactory()) {
            return true;
        }
        return super.isPrepareLastForRemove();
    }

    @Override
    protected void onAfterRemove(PSDevUser pSDevUser) throws Exception {
        if (this.isMajorSessionFactory()) {
            PSDevUser pSDevUser2 = (PSDevUser)this.getLast(pSDevUser);
            PSDevCenterHelper.updatetPSDCResRep(pSDevUser2.getPSDevCenter(), "USERCNT");
        }
        super.onAfterRemove(pSDevUser);
    }

    @Override
    protected void onSyncEntity_User(PSDevUser pSDevUser, boolean bl) throws Exception {
        if (!PSDevUserService.isCloudMode()) {
            super.onSyncEntity_User(pSDevUser, bl);
        }
    }
}
