/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDevUser
 *  net.ibizsys.pscore.srv.devcenter.service.PSDevUserService
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTempl
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnUser
 *  net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnUserService
 *  net.ibizsys.pscore.srv.util.gitlab.IPSGitLabPlugin
 *  net.ibizsys.pscore.srv.util.gitlab.PSGitLabPluginImpl
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Ctrl.Util;

import java.util.HashMap;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUser;
import net.ibizsys.pscore.srv.devcenter.service.PSDevUserService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnUser;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnUserService;
import net.ibizsys.pscore.srv.util.gitlab.IPSGitLabPlugin;
import net.ibizsys.pscore.srv.util.gitlab.PSGitLabPluginImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSDevSlnGitLabHelper
extends PSGitLabPluginImpl {
    private static final Log log = LogFactory.getLog(PSDevSlnGitLabHelper.class);

    /*
     * Unable to fully structure code
     */
    public void convertV6toV7(PSDevSln psDevSln) throws Exception {
        block33: {
            block32: {
                block31: {
                    strSLNTag = null;
                    strSLNTag2 = null;
                    if (psDevSln.getPSDevCenterSVN() != null && psDevSln.getPSDevCenterSVN().getPSSVNInstRepo() != null) {
                        strSLNTag = psDevSln.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag();
                        strSLNTag2 = psDevSln.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag2();
                    } else {
                        strSLNTag = psDevSln.getSlnTag();
                        strSLNTag2 = psDevSln.getSlnTag2();
                    }
                    if (StringHelper.isNullOrEmpty((String)strSLNTag)) {
                        throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u65b9\u6848[%1$s]\u6ca1\u6709\u6307\u5b9a\u7248\u672c\u4ed3\u5e93", (Object)psDevSln.getPSDevSlnName()));
                    }
                    if (StringHelper.isNullOrEmpty((String)strSLNTag2)) {
                        throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u65b9\u6848[%1$s]\u6ca1\u6709\u6307\u5b9a\u7fa4\u7ec4\u6807\u8bc6", (Object)psDevSln.getPSDevSlnName()));
                    }
                    PSCoreSysServiceBase.setEnableGitLabPlugin((boolean)true);
                    PSCoreSysServiceBase.setPSGitLabPlugin((IPSGitLabPlugin)new PSGitLabPluginImpl());
                    psDevSlnUserService = (PSDevSlnUserService)ServiceGlobal.getService(PSDevSlnUserService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                    psDevSlnUserList = psDevSln.getPSDevSlnUsers();
                    psSVNServer = this.getPSSVNServer(strSLNTag);
                    slnGroup = this.getNamespace(psSVNServer, strSLNTag2);
                    psDevUserService = (PSDevUserService)ServiceGlobal.getService(PSDevUserService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                    psDevCenter = new PSDevCenter();
                    psDevCenter.setPSDevCenterId(psDevSln.getPSDevCenterId());
                    psDevUserList = psDevUserService.selectByPSDevCenter((PSDevCenterBase)psDevCenter);
                    psDevUserMap = new HashMap<Object, PSDevUser>();
                    for (PSDevUser psDevUser : psDevUserList) {
                        strFullLoginName = psDevUser.getFullLoginName();
                        if (StringHelper.isNullOrEmpty((String)strFullLoginName)) {
                            strFullLoginName = psDevUser.getLoginName();
                        }
                        if (StringHelper.isNullOrEmpty((String)strFullLoginName)) continue;
                        strLogicName = strFullLoginName.toLowerCase();
                        psDevUserMap.put(strLogicName, psDevUser);
                    }
                    members = this.listGroupMembers(psSVNServer, slnGroup.getId());
                    if (members == null) break block31;
                    var16_21 = members;
                    strLogicName = members.length;
                    strFullLoginName = 0;
                    while (strFullLoginName < strLogicName) {
                        member = var16_21[strFullLoginName];
                        PSDevSlnGitLabHelper.log.debug((Object)StringHelper.format((String)"\u5f00\u53d1\u65b9\u6848[%1$s]\u7528\u6237[%2$s][%3$s]", (Object)psDevSln.getPSDevSlnName(), (Object)member.getUsername(), (Object)member.getAccessLevel().value));
                        psDevUser = (PSDevUser)psDevUserMap.get(member.getUsername().toLowerCase());
                        if (psDevUser != null) ** GOTO lbl64
                        psDevUser2 = new PSDevUser();
                        psDevUser2.setPSDevCenterName(member.getUsername());
                        psDevUser2.setFullLoginName(member.getUsername());
                        if (!psDevUserService.select((IEntity)psDevUser2, true)) {
                            PSDevSlnGitLabHelper.log.error((Object)StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u5f00\u53d1\u7528\u6237[%1$s]", (Object)member.getUsername()));
                        } else {
                            member.setUsername(member.getUsername().toLowerCase());
                            psDevUser = new PSDevUser();
                            psDevUser.setPSDevCenterId(psDevSln.getPSDevCenterId());
                            psDevUser.setPSDevCenterName(psDevSln.getPSDevCenterName());
                            psDevUser.setFromUserMode(Integer.valueOf(1));
                            psDevUser.setPSDevUserName(psDevUser2.getPSDevUserName());
                            psDevUser.setLoginName(psDevUser2.getFullLoginName());
                            psDevUser.setFromLoginName(psDevUser2.getFullLoginName());
                            psDevUser.setFromPSDCId(psDevUser2.getPSDevCenterId());
                            psDevUser.setFromPSDCName(psDevUser2.getPSDevCenterName());
                            psDevUser.setFromPSDevUserId(psDevUser2.getPSDevUserId());
                            psDevUser.setFromPSDevUserName(psDevUser2.getPSDevUserName());
                            psDevUserService.create((IEntity)psDevUser);
                            psDevUserMap.put(member.getUsername(), psDevUser);
lbl64:
                            // 2 sources

                            dstPSDevSlnUser = null;
                            for (PSDevSlnUser psDevSlnUser : psDevSlnUserList) {
                                if (StringHelper.compare((String)psDevSlnUser.getPSDevUserObjId(), (String)psDevUser.getPSDevUserId(), (boolean)false) != 0 || !StringHelper.isNullOrEmpty((String)psDevSlnUser.getPSDevSlnSysId()) || !StringHelper.isNullOrEmpty((String)psDevSlnUser.getPSDevSlnTemplId())) continue;
                                dstPSDevSlnUser = psDevSlnUser;
                                break;
                            }
                            if (dstPSDevSlnUser == null) {
                                dstPSDevSlnUser = new PSDevSlnUser();
                                dstPSDevSlnUser.setPSDevSlnId(psDevSln.getPSDevSlnId());
                                dstPSDevSlnUser.setPSDevSlnName(psDevSln.getPSDevSlnName());
                                dstPSDevSlnUser.setAllSysFlag(Integer.valueOf(1));
                                dstPSDevSlnUser.setPSDevSlnUserName(psDevUser.getPSDevUserName());
                                dstPSDevSlnUser.setPSDevUserObjId(psDevUser.getPSDevUserId());
                                dstPSDevSlnUser.setPSDevUserObjName(psDevUser.getPSDevUserName());
                                if (member.getAccessLevel().value >= 50) {
                                    dstPSDevSlnUser.setAccMode(Integer.valueOf(19));
                                } else if (member.getAccessLevel().value >= 30) {
                                    dstPSDevSlnUser.setAccMode(Integer.valueOf(3));
                                } else {
                                    dstPSDevSlnUser.setAccMode(Integer.valueOf(1));
                                }
                                psDevSlnUserService.create((IEntity)dstPSDevSlnUser);
                            }
                        }
                        ++strFullLoginName;
                    }
                }
                if ((psDevSlnSysList = psDevSln.getPSDevSlnSyss()).size() <= 0) break block32;
                for (PSDevSlnSys psDevSlnSys : psDevSlnSysList) {
                    psDevCenterSVN = psDevSlnSys.getPSDevCenterSVN();
                    modelPSDevCenterSVN = psDevSlnSys.getModelPSDevCenterSVN();
                    if (psDevCenterSVN == null || psDevCenterSVN.getPSSVNInstRepo() == null || StringHelper.isNullOrEmpty((String)psDevCenterSVN.getPSSVNInstRepo().getRepoTag2()) || (members = this.listProjectMembers(psSVNServer, psDevCenterSVN.getPSSVNInstRepo().getRepoTag2())) == null) continue;
                    var21_30 = members;
                    var20_28 = members.length;
                    var19_25 = 0;
                    while (var19_25 < var20_28) {
                        member = var21_30[var19_25];
                        PSDevSlnGitLabHelper.log.debug((Object)StringHelper.format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u7528\u6237[%2$s][%3$s]", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)member.getUsername(), (Object)member.getAccessLevel().value));
                        psDevUser = (PSDevUser)psDevUserMap.get(member.getUsername().toLowerCase());
                        if (psDevUser != null) ** GOTO lbl122
                        psDevUser2 = new PSDevUser();
                        psDevUser2.setPSDevCenterName(member.getUsername());
                        psDevUser2.setFullLoginName(member.getUsername());
                        if (!psDevUserService.select((IEntity)psDevUser2, true)) {
                            PSDevSlnGitLabHelper.log.error((Object)StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u5f00\u53d1\u7528\u6237[%1$s]", (Object)member.getUsername()));
                        } else {
                            member.setUsername(member.getUsername().toLowerCase());
                            psDevUser = new PSDevUser();
                            psDevUser.setPSDevCenterId(psDevSln.getPSDevCenterId());
                            psDevUser.setPSDevCenterName(psDevSln.getPSDevCenterName());
                            psDevUser.setFromUserMode(Integer.valueOf(1));
                            psDevUser.setPSDevUserName(psDevUser2.getPSDevUserName());
                            psDevUser.setLoginName(psDevUser2.getFullLoginName());
                            psDevUser.setFromLoginName(psDevUser2.getFullLoginName());
                            psDevUser.setFromPSDCId(psDevUser2.getPSDevCenterId());
                            psDevUser.setFromPSDCName(psDevUser2.getPSDevCenterName());
                            psDevUser.setFromPSDevUserId(psDevUser2.getPSDevUserId());
                            psDevUser.setFromPSDevUserName(psDevUser2.getPSDevUserName());
                            psDevUserService.create((IEntity)psDevUser);
                            psDevUserMap.put(member.getUsername(), psDevUser);
lbl122:
                            // 2 sources

                            dstPSDevSlnUser = null;
                            for (PSDevSlnUser psDevSlnUser : psDevSlnUserList) {
                                if (StringHelper.compare((String)psDevSlnUser.getPSDevUserObjId(), (String)psDevUser.getPSDevUserId(), (boolean)false) != 0 || StringHelper.isNullOrEmpty((String)psDevSlnUser.getPSDevSlnSysId())) continue;
                                dstPSDevSlnUser = psDevSlnUser;
                                break;
                            }
                            if (dstPSDevSlnUser == null) {
                                dstPSDevSlnUser = new PSDevSlnUser();
                                dstPSDevSlnUser.setPSDevSlnId(psDevSln.getPSDevSlnId());
                                dstPSDevSlnUser.setPSDevSlnName(psDevSln.getPSDevSlnName());
                                dstPSDevSlnUser.setAllSysFlag(Integer.valueOf(0));
                                dstPSDevSlnUser.setPSDevSlnUserName(psDevUser.getPSDevUserName());
                                dstPSDevSlnUser.setPSDevUserObjId(psDevUser.getPSDevUserId());
                                dstPSDevSlnUser.setPSDevUserObjName(psDevUser.getPSDevUserName());
                                dstPSDevSlnUser.setPSDevSlnSysId(psDevSlnSys.getPSDevSlnSysId());
                                dstPSDevSlnUser.setPSDevSlnSysName(psDevSlnSys.getPSDevSlnSysName());
                                if (member.getAccessLevel().value >= 30) {
                                    dstPSDevSlnUser.setAccMode(Integer.valueOf(3));
                                } else {
                                    dstPSDevSlnUser.setAccMode(Integer.valueOf(1));
                                }
                                psDevSlnUserService.create((IEntity)dstPSDevSlnUser);
                            }
                        }
                        ++var19_25;
                    }
                }
            }
            if ((psDevSlnTemplList = psDevSln.getPSDevSlnTempls()).size() <= 0) break block33;
            for (PSDevSlnTempl psDevSlnTempl : psDevSlnTemplList) {
                psDevCenterSVN = psDevSlnTempl.getPSDevCenterSVN();
                if (psDevCenterSVN == null || psDevCenterSVN.getPSSVNInstRepo() == null || StringHelper.isNullOrEmpty((String)psDevCenterSVN.getPSSVNInstRepo().getRepoTag2()) || (members = this.listProjectMembers(psSVNServer, psDevCenterSVN.getPSSVNInstRepo().getRepoTag2())) == null) continue;
                var21_30 = members;
                var20_29 = members.length;
                var19_26 = 0;
                while (var19_26 < var20_29) {
                    member = var21_30[var19_26];
                    PSDevSlnGitLabHelper.log.debug((Object)StringHelper.format((String)"\u5f00\u53d1\u6a21\u677f[%1$s]\u7528\u6237[%2$s][%3$s]", (Object)psDevSlnTempl.getPSDevSlnTemplName(), (Object)member.getUsername(), (Object)member.getAccessLevel().value));
                    psDevUser = (PSDevUser)psDevUserMap.get(member.getUsername().toLowerCase());
                    if (psDevUser != null) ** GOTO lbl179
                    psDevUser2 = new PSDevUser();
                    psDevUser2.setPSDevCenterName(member.getUsername());
                    psDevUser2.setFullLoginName(member.getUsername());
                    if (!psDevUserService.select((IEntity)psDevUser2, true)) {
                        PSDevSlnGitLabHelper.log.error((Object)StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u5f00\u53d1\u7528\u6237[%1$s]", (Object)member.getUsername()));
                    } else {
                        member.setUsername(member.getUsername().toLowerCase());
                        psDevUser = new PSDevUser();
                        psDevUser.setPSDevCenterId(psDevSln.getPSDevCenterId());
                        psDevUser.setPSDevCenterName(psDevSln.getPSDevCenterName());
                        psDevUser.setFromUserMode(Integer.valueOf(1));
                        psDevUser.setPSDevUserName(psDevUser2.getPSDevUserName());
                        psDevUser.setLoginName(psDevUser2.getFullLoginName());
                        psDevUser.setFromLoginName(psDevUser2.getFullLoginName());
                        psDevUser.setFromPSDCId(psDevUser2.getPSDevCenterId());
                        psDevUser.setFromPSDCName(psDevUser2.getPSDevCenterName());
                        psDevUser.setFromPSDevUserId(psDevUser2.getPSDevUserId());
                        psDevUser.setFromPSDevUserName(psDevUser2.getPSDevUserName());
                        psDevUserService.create((IEntity)psDevUser);
                        psDevUserMap.put(member.getUsername(), psDevUser);
lbl179:
                        // 2 sources

                        dstPSDevSlnUser = null;
                        for (PSDevSlnUser psDevSlnUser : psDevSlnUserList) {
                            if (StringHelper.compare((String)psDevSlnUser.getPSDevUserObjId(), (String)psDevUser.getPSDevUserId(), (boolean)false) != 0 || StringHelper.isNullOrEmpty((String)psDevSlnUser.getPSDevSlnSysId())) continue;
                            dstPSDevSlnUser = psDevSlnUser;
                            break;
                        }
                        if (dstPSDevSlnUser == null) {
                            dstPSDevSlnUser = new PSDevSlnUser();
                            dstPSDevSlnUser.setPSDevSlnId(psDevSln.getPSDevSlnId());
                            dstPSDevSlnUser.setPSDevSlnName(psDevSln.getPSDevSlnName());
                            dstPSDevSlnUser.setAllSysFlag(Integer.valueOf(2));
                            dstPSDevSlnUser.setPSDevSlnUserName(psDevUser.getPSDevUserName());
                            dstPSDevSlnUser.setPSDevUserObjId(psDevUser.getPSDevUserId());
                            dstPSDevSlnUser.setPSDevUserObjName(psDevUser.getPSDevUserName());
                            dstPSDevSlnUser.setPSDevSlnTemplId(psDevSlnTempl.getPSDevSlnTemplId());
                            dstPSDevSlnUser.setPSDevSlnTemplName(psDevSlnTempl.getPSDevSlnTemplName());
                            if (member.getAccessLevel().value >= 30) {
                                dstPSDevSlnUser.setAccMode(Integer.valueOf(3));
                            } else {
                                dstPSDevSlnUser.setAccMode(Integer.valueOf(1));
                            }
                            psDevSlnUserService.create((IEntity)dstPSDevSlnUser);
                        }
                    }
                    ++var19_26;
                }
            }
        }
    }
}

