package SA.SRFDA.PS.Ctrl.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUser;
import net.ibizsys.pscore.srv.devcenter.service.PSDevUserService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSVNServer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnUser;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnUserService;
import net.ibizsys.pscore.srv.util.gitlab.PSGitLabPluginImpl;
import net.ibizsys.pscore.srv.util.gitlab.model.Member;
import net.ibizsys.pscore.srv.util.gitlab.model.Namespace;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDevSlnGitLabHelper extends PSGitLabPluginImpl {
   private static final Log log = LogFactory.getLog(PSDevSlnGitLabHelper.class);

   public void convertV6toV7(PSDevSln psDevSln) throws Exception {
      String strSLNTag = null;
      String strSLNTag2 = null;
      if (psDevSln.getPSDevCenterSVN() != null && psDevSln.getPSDevCenterSVN().getPSSVNInstRepo() != null) {
         strSLNTag = psDevSln.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag();
         strSLNTag2 = psDevSln.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag2();
      } else {
         strSLNTag = psDevSln.getSlnTag();
         strSLNTag2 = psDevSln.getSlnTag2();
      }

      if (StringHelper.isNullOrEmpty(strSLNTag)) {
         throw new Exception(StringHelper.format("开发方案[%1$s]没有指定版本仓库", psDevSln.getPSDevSlnName()));
      }

      if (StringHelper.isNullOrEmpty(strSLNTag2)) {
         throw new Exception(StringHelper.format("开发方案[%1$s]没有指定群组标识", psDevSln.getPSDevSlnName()));
      }

      PSCoreSysServiceBase.setEnableGitLabPlugin(true);
      PSCoreSysServiceBase.setPSGitLabPlugin(new PSGitLabPluginImpl());
      PSDevSlnUserService psDevSlnUserService = (PSDevSlnUserService)ServiceGlobal.getService(
         PSDevSlnUserService.class, PSCoreSysServiceBase.getCurMajorSessionFactory()
      );
      ArrayList<PSDevSlnUser> psDevSlnUserList = psDevSln.getPSDevSlnUsers();
      PSSVNServer psSVNServer = this.getPSSVNServer(strSLNTag);
      Namespace slnGroup = this.getNamespace(psSVNServer, strSLNTag2);
      PSDevUserService psDevUserService = (PSDevUserService)ServiceGlobal.getService(PSDevUserService.class, PSCoreSysServiceBase.getCurMajorSessionFactory());
      PSDevCenter psDevCenter = new PSDevCenter();
      psDevCenter.setPSDevCenterId(psDevSln.getPSDevCenterId());
      ArrayList<PSDevUser> psDevUserList = psDevUserService.selectByPSDevCenter(psDevCenter);
      Map<String, PSDevUser> psDevUserMap = new HashMap<>();

      for (PSDevUser psDevUser : psDevUserList) {
         String strFullLoginName = psDevUser.getFullLoginName();
         if (StringHelper.isNullOrEmpty(strFullLoginName)) {
            strFullLoginName = psDevUser.getLoginName();
         }

         if (!StringHelper.isNullOrEmpty(strFullLoginName)) {
            String strLogicName = strFullLoginName.toLowerCase();
            psDevUserMap.put(strLogicName, psDevUser);
         }
      }

      Member[] members = this.listGroupMembers(psSVNServer, slnGroup.getId());
      if (members != null) {
         Member[] psDevCenterSVN = members;
         int var36 = members.length;

         for (int var33 = 0; var33 < var36; var33++) {
            Member member = psDevCenterSVN[var33];
            log.debug(StringHelper.format("开发方案[%1$s]用户[%2$s][%3$s]", psDevSln.getPSDevSlnName(), member.getUsername(), member.getAccessLevel().value));
            PSDevUser psDevUser = psDevUserMap.get(member.getUsername().toLowerCase());
            if (psDevUser == null) {
               PSDevUser psDevUser2 = new PSDevUser();
               psDevUser2.setPSDevCenterName(member.getUsername());
               psDevUser2.setFullLoginName(member.getUsername());
               if (!psDevUserService.select(psDevUser2, true)) {
                  log.error(StringHelper.format("无法获取开发用户[%1$s]", member.getUsername()));
                  continue;
               }

               member.setUsername(member.getUsername().toLowerCase());
               psDevUser = new PSDevUser();
               psDevUser.setPSDevCenterId(psDevSln.getPSDevCenterId());
               psDevUser.setPSDevCenterName(psDevSln.getPSDevCenterName());
               psDevUser.setFromUserMode(1);
               psDevUser.setPSDevUserName(psDevUser2.getPSDevUserName());
               psDevUser.setLoginName(psDevUser2.getFullLoginName());
               psDevUser.setFromLoginName(psDevUser2.getFullLoginName());
               psDevUser.setFromPSDCId(psDevUser2.getPSDevCenterId());
               psDevUser.setFromPSDCName(psDevUser2.getPSDevCenterName());
               psDevUser.setFromPSDevUserId(psDevUser2.getPSDevUserId());
               psDevUser.setFromPSDevUserName(psDevUser2.getPSDevUserName());
               psDevUserService.create(psDevUser);
               psDevUserMap.put(member.getUsername(), psDevUser);
            }

            PSDevSlnUser dstPSDevSlnUser = null;

            for (PSDevSlnUser psDevSlnUser : psDevSlnUserList) {
               if (StringHelper.compare(psDevSlnUser.getPSDevUserObjId(), psDevUser.getPSDevUserId(), false) == 0
                  && StringHelper.isNullOrEmpty(psDevSlnUser.getPSDevSlnSysId())
                  && StringHelper.isNullOrEmpty(psDevSlnUser.getPSDevSlnTemplId())) {
                  dstPSDevSlnUser = psDevSlnUser;
                  break;
               }
            }

            if (dstPSDevSlnUser == null) {
               dstPSDevSlnUser = new PSDevSlnUser();
               dstPSDevSlnUser.setPSDevSlnId(psDevSln.getPSDevSlnId());
               dstPSDevSlnUser.setPSDevSlnName(psDevSln.getPSDevSlnName());
               dstPSDevSlnUser.setAllSysFlag(1);
               dstPSDevSlnUser.setPSDevSlnUserName(psDevUser.getPSDevUserName());
               dstPSDevSlnUser.setPSDevUserObjId(psDevUser.getPSDevUserId());
               dstPSDevSlnUser.setPSDevUserObjName(psDevUser.getPSDevUserName());
               if (member.getAccessLevel().value >= 50) {
                  dstPSDevSlnUser.setAccMode(19);
               } else if (member.getAccessLevel().value >= 30) {
                  dstPSDevSlnUser.setAccMode(3);
               } else {
                  dstPSDevSlnUser.setAccMode(1);
               }

               psDevSlnUserService.create(dstPSDevSlnUser);
            }
         }
      }

      ArrayList<PSDevSlnSys> psDevSlnSysList = psDevSln.getPSDevSlnSyss();
      if (psDevSlnSysList.size() > 0) {
         for (PSDevSlnSys psDevSlnSys : psDevSlnSysList) {
            PSDevCenterSVN psDevCenterSVN = psDevSlnSys.getPSDevCenterSVN();
            PSDevCenterSVN modelPSDevCenterSVN = psDevSlnSys.getModelPSDevCenterSVN();
            if (psDevCenterSVN != null
               && psDevCenterSVN.getPSSVNInstRepo() != null
               && !StringHelper.isNullOrEmpty(psDevCenterSVN.getPSSVNInstRepo().getRepoTag2())) {
               members = this.listProjectMembers(psSVNServer, psDevCenterSVN.getPSSVNInstRepo().getRepoTag2());
               if (members != null) {
                  Member[] var21 = members;
                  int var49 = members.length;

                  for (int var47 = 0; var47 < var49; var47++) {
                     Member member = var21[var47];
                     log.debug(
                        StringHelper.format("开发系统[%1$s]用户[%2$s][%3$s]", psDevSlnSys.getPSDevSlnSysName(), member.getUsername(), member.getAccessLevel().value)
                     );
                     PSDevUser psDevUser = psDevUserMap.get(member.getUsername().toLowerCase());
                     if (psDevUser == null) {
                        PSDevUser psDevUser2 = new PSDevUser();
                        psDevUser2.setPSDevCenterName(member.getUsername());
                        psDevUser2.setFullLoginName(member.getUsername());
                        if (!psDevUserService.select(psDevUser2, true)) {
                           log.error(StringHelper.format("无法获取开发用户[%1$s]", member.getUsername()));
                           continue;
                        }

                        member.setUsername(member.getUsername().toLowerCase());
                        psDevUser = new PSDevUser();
                        psDevUser.setPSDevCenterId(psDevSln.getPSDevCenterId());
                        psDevUser.setPSDevCenterName(psDevSln.getPSDevCenterName());
                        psDevUser.setFromUserMode(1);
                        psDevUser.setPSDevUserName(psDevUser2.getPSDevUserName());
                        psDevUser.setLoginName(psDevUser2.getFullLoginName());
                        psDevUser.setFromLoginName(psDevUser2.getFullLoginName());
                        psDevUser.setFromPSDCId(psDevUser2.getPSDevCenterId());
                        psDevUser.setFromPSDCName(psDevUser2.getPSDevCenterName());
                        psDevUser.setFromPSDevUserId(psDevUser2.getPSDevUserId());
                        psDevUser.setFromPSDevUserName(psDevUser2.getPSDevUserName());
                        psDevUserService.create(psDevUser);
                        psDevUserMap.put(member.getUsername(), psDevUser);
                     }

                     PSDevSlnUser dstPSDevSlnUser = null;

                     for (PSDevSlnUser psDevSlnUser : psDevSlnUserList) {
                        if (StringHelper.compare(psDevSlnUser.getPSDevUserObjId(), psDevUser.getPSDevUserId(), false) == 0
                           && !StringHelper.isNullOrEmpty(psDevSlnUser.getPSDevSlnSysId())) {
                           dstPSDevSlnUser = psDevSlnUser;
                           break;
                        }
                     }

                     if (dstPSDevSlnUser == null) {
                        dstPSDevSlnUser = new PSDevSlnUser();
                        dstPSDevSlnUser.setPSDevSlnId(psDevSln.getPSDevSlnId());
                        dstPSDevSlnUser.setPSDevSlnName(psDevSln.getPSDevSlnName());
                        dstPSDevSlnUser.setAllSysFlag(0);
                        dstPSDevSlnUser.setPSDevSlnUserName(psDevUser.getPSDevUserName());
                        dstPSDevSlnUser.setPSDevUserObjId(psDevUser.getPSDevUserId());
                        dstPSDevSlnUser.setPSDevUserObjName(psDevUser.getPSDevUserName());
                        dstPSDevSlnUser.setPSDevSlnSysId(psDevSlnSys.getPSDevSlnSysId());
                        dstPSDevSlnUser.setPSDevSlnSysName(psDevSlnSys.getPSDevSlnSysName());
                        if (member.getAccessLevel().value >= 30) {
                           dstPSDevSlnUser.setAccMode(3);
                        } else {
                           dstPSDevSlnUser.setAccMode(1);
                        }

                        psDevSlnUserService.create(dstPSDevSlnUser);
                     }
                  }
               }
            }
         }
      }

      ArrayList<PSDevSlnTempl> psDevSlnTemplList = psDevSln.getPSDevSlnTempls();
      if (psDevSlnTemplList.size() > 0) {
         for (PSDevSlnTempl psDevSlnTempl : psDevSlnTemplList) {
            PSDevCenterSVN psDevCenterSVN = psDevSlnTempl.getPSDevCenterSVN();
            if (psDevCenterSVN != null
               && psDevCenterSVN.getPSSVNInstRepo() != null
               && !StringHelper.isNullOrEmpty(psDevCenterSVN.getPSSVNInstRepo().getRepoTag2())) {
               members = this.listProjectMembers(psSVNServer, psDevCenterSVN.getPSSVNInstRepo().getRepoTag2());
               if (members != null) {
                  Member[] var51 = members;
                  int var50 = members.length;

                  for (int var48 = 0; var48 < var50; var48++) {
                     Member member = var51[var48];
                     log.debug(
                        StringHelper.format(
                           "开发模板[%1$s]用户[%2$s][%3$s]", psDevSlnTempl.getPSDevSlnTemplName(), member.getUsername(), member.getAccessLevel().value
                        )
                     );
                     PSDevUser psDevUser = psDevUserMap.get(member.getUsername().toLowerCase());
                     if (psDevUser == null) {
                        PSDevUser psDevUser2 = new PSDevUser();
                        psDevUser2.setPSDevCenterName(member.getUsername());
                        psDevUser2.setFullLoginName(member.getUsername());
                        if (!psDevUserService.select(psDevUser2, true)) {
                           log.error(StringHelper.format("无法获取开发用户[%1$s]", member.getUsername()));
                           continue;
                        }

                        member.setUsername(member.getUsername().toLowerCase());
                        psDevUser = new PSDevUser();
                        psDevUser.setPSDevCenterId(psDevSln.getPSDevCenterId());
                        psDevUser.setPSDevCenterName(psDevSln.getPSDevCenterName());
                        psDevUser.setFromUserMode(1);
                        psDevUser.setPSDevUserName(psDevUser2.getPSDevUserName());
                        psDevUser.setLoginName(psDevUser2.getFullLoginName());
                        psDevUser.setFromLoginName(psDevUser2.getFullLoginName());
                        psDevUser.setFromPSDCId(psDevUser2.getPSDevCenterId());
                        psDevUser.setFromPSDCName(psDevUser2.getPSDevCenterName());
                        psDevUser.setFromPSDevUserId(psDevUser2.getPSDevUserId());
                        psDevUser.setFromPSDevUserName(psDevUser2.getPSDevUserName());
                        psDevUserService.create(psDevUser);
                        psDevUserMap.put(member.getUsername(), psDevUser);
                     }

                     PSDevSlnUser dstPSDevSlnUser = null;

                     for (PSDevSlnUser psDevSlnUser : psDevSlnUserList) {
                        if (StringHelper.compare(psDevSlnUser.getPSDevUserObjId(), psDevUser.getPSDevUserId(), false) == 0
                           && !StringHelper.isNullOrEmpty(psDevSlnUser.getPSDevSlnSysId())) {
                           dstPSDevSlnUser = psDevSlnUser;
                           break;
                        }
                     }

                     if (dstPSDevSlnUser == null) {
                        dstPSDevSlnUser = new PSDevSlnUser();
                        dstPSDevSlnUser.setPSDevSlnId(psDevSln.getPSDevSlnId());
                        dstPSDevSlnUser.setPSDevSlnName(psDevSln.getPSDevSlnName());
                        dstPSDevSlnUser.setAllSysFlag(2);
                        dstPSDevSlnUser.setPSDevSlnUserName(psDevUser.getPSDevUserName());
                        dstPSDevSlnUser.setPSDevUserObjId(psDevUser.getPSDevUserId());
                        dstPSDevSlnUser.setPSDevUserObjName(psDevUser.getPSDevUserName());
                        dstPSDevSlnUser.setPSDevSlnTemplId(psDevSlnTempl.getPSDevSlnTemplId());
                        dstPSDevSlnUser.setPSDevSlnTemplName(psDevSlnTempl.getPSDevSlnTemplName());
                        if (member.getAccessLevel().value >= 30) {
                           dstPSDevSlnUser.setAccMode(3);
                        } else {
                           dstPSDevSlnUser.setAccMode(1);
                        }

                        psDevSlnUserService.create(dstPSDevSlnUser);
                     }
                  }
               }
            }
         }
      }
   }
}
