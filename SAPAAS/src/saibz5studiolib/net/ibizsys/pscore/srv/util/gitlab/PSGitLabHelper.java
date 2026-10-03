/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.util.gitlab;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSGitUser;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSVNInstRepo;
import net.ibizsys.pscore.srv.paasmgr.service.PSGitUserService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSVNInstRepoService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.util.gitlab.model.Group;
import net.ibizsys.pscore.srv.util.gitlab.model.Project;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSGitLabHelper {
    private static final Log log = LogFactory.getLog(PSGitLabHelper.class);

    public static PSDevCenterSVN createPSDevCenterSVN(PSDevCenter pSDevCenter, PSDevSln pSDevSln, Project project) throws Exception {
        PSSVNInstRepo pSSVNInstRepo = new PSSVNInstRepo();
        pSSVNInstRepo.setPSSVNInstRepoName(project.getPath());
        pSSVNInstRepo.setSVNType("GIT");
        pSSVNInstRepo.setPSSVNServerId(pSDevSln.getSlnTag());
        pSSVNInstRepo.setConnStr(project.getHttpUrlToRepo());
        pSSVNInstRepo.setRepoState(20);
        pSSVNInstRepo.setGitPath(project.getHttpUrlToRepo());
        pSSVNInstRepo.setGitBranch(project.getDefaultBranch());
        pSSVNInstRepo.setRepoTag(pSDevSln.getSlnTag());
        pSSVNInstRepo.setRepoTag2(Integer.toString(project.getId()));
        pSSVNInstRepo.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSSVNInstRepo.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
        PSGitUserService pSGitUserService = (PSGitUserService)ServiceGlobal.getService(PSGitUserService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSGitUser pSGitUser = new PSGitUser();
        pSGitUser.setPSGitUserId(pSDevSln.getSlnTag());
        if (!pSGitUserService.get(pSGitUser, true)) {
            log.warn((Object)StringHelper.format((String)"GIT\u670d\u52a1\u5668[%1$s]\u6ca1\u6709\u6307\u5b9a\u9ed8\u8ba4\u8bbf\u95ee\u7528\u6237", (Object)pSDevSln.getSlnTag()));
            pSGitUser = null;
        }
        if (pSGitUser != null) {
            pSSVNInstRepo.setPSGitUserId(pSGitUser.getPSGitUserId());
            pSSVNInstRepo.setPSGitUserName(pSGitUser.getPSGitUserName());
        }
        PSSVNInstRepoService pSSVNInstRepoService = (PSSVNInstRepoService)ServiceGlobal.getService(PSSVNInstRepoService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        try {
            pSSVNInstRepoService.create(pSSVNInstRepo);
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u521b\u5efa\u5e73\u53f0\u4ee3\u7801\u4ed3\u5e93\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
            throw new Exception(StringHelper.format((String)"\u521b\u5efa\u5e73\u53f0\u4ee3\u7801\u4ed3\u5e93\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
        PSDevCenterSVN pSDevCenterSVN = new PSDevCenterSVN();
        pSDevCenterSVN.setPSDevCenterId(pSSVNInstRepo.getPSDevCenterId());
        pSDevCenterSVN.setPSDevCenterName(pSSVNInstRepo.getPSDevCenterName());
        pSDevCenterSVN.setPSDevCenterSVNId(pSSVNInstRepo.getPSSVNInstRepoId());
        pSDevCenterSVN.setPSDevCenterSVNName(pSSVNInstRepo.getPSSVNInstRepoName());
        pSDevCenterSVN.setResState(20);
        pSDevCenterSVN.setResPos(1);
        pSDevCenterSVN.setGitPath(pSSVNInstRepo.getGitPath());
        pSDevCenterSVN.setGitBranch(pSSVNInstRepo.getGitBranch());
        pSDevCenterSVN.setPSSVNInstRepoId(pSSVNInstRepo.getPSSVNInstRepoId());
        pSDevCenterSVN.setPSSVNInstRepoName(pSSVNInstRepo.getPSSVNInstRepoName());
        pSDevCenterSVN.setPSDevSlnId(pSDevSln.getPSDevSlnId());
        pSDevCenterSVN.setPSDevSlnName(pSDevSln.getPSDevSlnName());
        pSDevCenterSVN.setSVNType("GIT");
        pSDevCenterSVN.setGitRepo("IBIZ");
        if (pSGitUser != null) {
            pSDevCenterSVN.setPSGitUserId(pSGitUser.getPSGitUserId());
            pSDevCenterSVN.setPSGitUserName(pSGitUser.getPSGitUserName());
        }
        pSDevCenterSVN.setRefFlag(1);
        PSDevCenterSVNService pSDevCenterSVNService = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        try {
            pSDevCenterSVNService.create(pSDevCenterSVN);
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u521b\u5efa\u4e2d\u5fc3\u4ee3\u7801\u4ed3\u5e93\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
            throw new Exception(StringHelper.format((String)"\u521b\u5efa\u4e2d\u5fc3\u4ee3\u7801\u4ed3\u5e93\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
        return pSDevCenterSVN;
    }

    public static void movePSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, Project project, PSDevSln pSDevSln) throws Exception {
        if (!StringHelper.isNullOrEmpty((String)pSDevCenterSVN.getPSSVNInstRepoId())) {
            PSSVNInstRepo pSSVNInstRepo = new PSSVNInstRepo();
            pSSVNInstRepo.setPSSVNInstRepoId(pSDevCenterSVN.getPSSVNInstRepoId());
            if (project != null) {
                pSSVNInstRepo.setConnStr(project.getHttpUrlToRepo());
                pSSVNInstRepo.setGitPath(project.getHttpUrlToRepo());
                pSSVNInstRepo.setGitBranch(project.getDefaultBranch());
                pSSVNInstRepo.setRepoTag2(Integer.toString(project.getId()));
            }
            if (pSDevSln != null) {
                pSSVNInstRepo.setPSDevCenterId(pSDevSln.getPSDevCenterId());
                pSSVNInstRepo.setPSDevCenterName(pSDevSln.getPSDevCenterName());
            }
            PSSVNInstRepoService pSSVNInstRepoService = (PSSVNInstRepoService)ServiceGlobal.getService(PSSVNInstRepoService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            try {
                pSSVNInstRepoService.update(pSSVNInstRepo);
            }
            catch (Exception exception) {
                log.error((Object)StringHelper.format((String)"\u66f4\u65b0\u5e73\u53f0\u4ee3\u7801\u4ed3\u5e93\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
                throw new Exception(StringHelper.format((String)"\u66f4\u65b0\u5e73\u53f0\u4ee3\u7801\u4ed3\u5e93\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
            }
        }
        if (pSDevSln != null) {
            PSDevCenterSVN updatedPSDevCenterSVN = new PSDevCenterSVN();
            updatedPSDevCenterSVN.setPSDevCenterSVNId(pSDevCenterSVN.getPSDevCenterSVNId());
            updatedPSDevCenterSVN.setPSDevCenterId(pSDevSln.getPSDevCenterId());
            updatedPSDevCenterSVN.setPSDevCenterName(pSDevSln.getPSDevCenterName());
            updatedPSDevCenterSVN.setPSDevSlnId(pSDevSln.getPSDevSlnId());
            updatedPSDevCenterSVN.setPSDevSlnName(pSDevSln.getPSDevSlnName());
            updatedPSDevCenterSVN.setRefFlag(1);
            PSDevCenterSVNService pSDevCenterSVNService = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            try {
                pSDevCenterSVNService.update(updatedPSDevCenterSVN);
            }
            catch (Exception exception) {
                log.error((Object)StringHelper.format((String)"\u66f4\u65b0\u4e2d\u5fc3\u4ee3\u7801\u4ed3\u5e93\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
                throw new Exception(StringHelper.format((String)"\u66f4\u65b0\u4e2d\u5fc3\u4ee3\u7801\u4ed3\u5e93\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
            }
        }
    }

    public static PSDevCenterSVN createPSDevCenterSVN(PSDevCenter pSDevCenter, PSDevSln pSDevSln, Group group) throws Exception {
        PSSVNInstRepo pSSVNInstRepo = new PSSVNInstRepo();
        pSSVNInstRepo.setPSSVNInstRepoName(group.getPath());
        pSSVNInstRepo.setSVNType("GIT");
        pSSVNInstRepo.setPSSVNServerId(pSDevSln.getSlnTag());
        pSSVNInstRepo.setConnStr(group.getWebUrl());
        pSSVNInstRepo.setRepoState(20);
        pSSVNInstRepo.setGitPath(group.getWebUrl());
        pSSVNInstRepo.setRepoTag(pSDevSln.getSlnTag());
        pSSVNInstRepo.setRepoTag2(Integer.toString(group.getId()));
        pSSVNInstRepo.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSSVNInstRepo.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
        PSGitUserService pSGitUserService = (PSGitUserService)ServiceGlobal.getService(PSGitUserService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSGitUser pSGitUser = new PSGitUser();
        pSGitUser.setPSGitUserId(pSDevSln.getSlnTag());
        if (!pSGitUserService.get(pSGitUser, true)) {
            log.warn((Object)StringHelper.format((String)"GIT\u670d\u52a1\u5668[%1$s]\u6ca1\u6709\u6307\u5b9a\u9ed8\u8ba4\u8bbf\u95ee\u7528\u6237", (Object)pSDevSln.getSlnTag()));
            pSGitUser = null;
        }
        if (pSGitUser != null) {
            pSSVNInstRepo.setPSGitUserId(pSGitUser.getPSGitUserId());
            pSSVNInstRepo.setPSGitUserName(pSGitUser.getPSGitUserName());
        }
        PSSVNInstRepoService pSSVNInstRepoService = (PSSVNInstRepoService)ServiceGlobal.getService(PSSVNInstRepoService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        try {
            pSSVNInstRepoService.create(pSSVNInstRepo);
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u521b\u5efa\u5e73\u53f0\u4ee3\u7801\u4ed3\u5e93\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
            throw new Exception(StringHelper.format((String)"\u521b\u5efa\u5e73\u53f0\u4ee3\u7801\u4ed3\u5e93\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
        PSDevCenterSVN pSDevCenterSVN = new PSDevCenterSVN();
        pSDevCenterSVN.setPSDevCenterId(pSSVNInstRepo.getPSDevCenterId());
        pSDevCenterSVN.setPSDevCenterName(pSSVNInstRepo.getPSDevCenterName());
        pSDevCenterSVN.setPSDevCenterSVNId(pSSVNInstRepo.getPSSVNInstRepoId());
        pSDevCenterSVN.setPSDevCenterSVNName(pSSVNInstRepo.getPSSVNInstRepoName());
        pSDevCenterSVN.setResState(20);
        pSDevCenterSVN.setResPos(1);
        pSDevCenterSVN.setGitPath(pSSVNInstRepo.getGitPath());
        pSDevCenterSVN.setPSSVNInstRepoId(pSSVNInstRepo.getPSSVNInstRepoId());
        pSDevCenterSVN.setPSSVNInstRepoName(pSSVNInstRepo.getPSSVNInstRepoName());
        pSDevCenterSVN.setSVNType("GIT");
        pSDevCenterSVN.setGitRepo("IBIZ");
        if (pSGitUser != null) {
            pSDevCenterSVN.setPSGitUserId(pSGitUser.getPSGitUserId());
            pSDevCenterSVN.setPSGitUserName(pSGitUser.getPSGitUserName());
        }
        pSDevCenterSVN.setRefFlag(1);
        PSDevCenterSVNService pSDevCenterSVNService = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        try {
            pSDevCenterSVNService.create(pSDevCenterSVN);
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u521b\u5efa\u4e2d\u5fc3\u4ee3\u7801\u4ed3\u5e93\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
            throw new Exception(StringHelper.format((String)"\u521b\u5efa\u4e2d\u5fc3\u4ee3\u7801\u4ed3\u5e93\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
        return pSDevCenterSVN;
    }
}
