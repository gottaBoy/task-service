/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.WebContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.util.gitlab;

import java.io.Serializable;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.codelist.SlnSysAccModeCodeListModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUser;
import net.ibizsys.pscore.srv.devcenter.service.PSDevUserService;
import net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInst;
import net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInstTag;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSVNInstRepo;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSVNServer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnUser;
import net.ibizsys.pscore.srv.util.PSCoreEntityKeeperGlobal;
import net.ibizsys.pscore.srv.util.PSDevCenterHelper;
import net.ibizsys.pscore.srv.util.gitlab.PSGitLabPluginImplBase;
import net.ibizsys.pscore.srv.util.gitlab.model.Branch;
import net.ibizsys.pscore.srv.util.gitlab.model.Group;
import net.ibizsys.pscore.srv.util.gitlab.model.Member;
import net.ibizsys.pscore.srv.util.gitlab.model.Namespace;
import net.ibizsys.pscore.srv.util.gitlab.model.Project;
import net.ibizsys.pscore.srv.util.gitlab.model.Tag;
import net.ibizsys.pscore.srv.util.gitlab.model.User;
import net.ibizsys.pscore.srv.util.gitlab.model.WikiPage;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSGitLabPluginImpl
extends PSGitLabPluginImplBase {
    private static final Log log = LogFactory.getLog(PSGitLabPluginImpl.class);
    private JacksonJson jacksonJson = new JacksonJson();
    protected static final int ACTION_CREATE = 1;
    protected static final int ACTION_UPDATE = 2;
    protected static final int ACTION_REMOVE = 3;
    protected static final int PROJECT_CODE = 1;
    protected static final int PROJECT_MODEL = 0;
    protected static final int PROJECT_RUNTIME = 2;
    protected static final int PROJECT_DOCUMENT = 3;
    private static Random random = new Random();

    protected PSSVNServer getPSSVNServer(String string) throws Exception {
        return PSCoreEntityKeeperGlobal.getCurrent(PSCoreSysServiceBase.getCurMajorSessionFactory()).getPSSVNServer(string);
    }

    @Override
    public User createUserByPSDevUser(PSDevUser pSDevUser) throws Exception {
        if (pSDevUser.getPSDevCenter() == null) {
            throw new Exception(StringHelper.format((String)"\u4f20\u5165\u5f00\u53d1\u7528\u6237\u5e94\u7528\u4e2d\u5fc3\u65e0\u6548"));
        }
        if (pSDevUser.getPSDevCenter().getV6PSSvnInstRepo() == null) {
            throw new Exception(StringHelper.format((String)"\u4f20\u5165\u5f00\u53d1\u7528\u6237\u5e94\u7528\u4e2d\u5fc3\u7248\u672c\u4ed3\u5e93\u65e0\u6548"));
        }
        PSSVNServer pSSVNServer = this.getPSSVNServer(pSDevUser.getPSDevCenter().getV6PSSvnInstRepo().getPSSVNServerId());
        return this.createUserByPSDevUser(pSSVNServer, pSDevUser, null, false);
    }

    protected User createUserByPSDevUser(PSSVNServer pSSVNServer, PSDevUser pSDevUser, String string, boolean bl) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string)) {
            string = this.getUserNameByPSDevUser(pSDevUser);
        }
        User user = null;
        try {
            user = this.getUser(pSSVNServer, string);
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u4ed3\u5e93\u670d\u52a1\u5668\u7528\u6237\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
            throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u4ed3\u5e93\u670d\u52a1\u5668\u7528\u6237\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
        if (user != null) {
            if (bl) {
                return user;
            }
            throw new Exception(StringHelper.format((String)"\u4ed3\u5e93\u670d\u52a1\u5668\u5df2\u5b58\u5728\u6307\u5b9a\u7528\u6237[%1$s]", (Object)string));
        }
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("username", string);
        hashMap.put("name", pSDevUser.getPSDevUserName());
        hashMap.put("email", string + "@ibizlab.cn");
        hashMap.put("password", "w1" + KeyValueHelper.genUniqueId((String)pSDevUser.getPSDevUserId()).substring(0, 10).toUpperCase());
        if (!StringHelper.isNullOrEmpty((String)pSSVNServer.getUserTag())) {
            hashMap.put("provider", "ldap");
            hashMap.put("extern_uid", StringHelper.format((String)pSSVNServer.getUserTag(), (Object)string));
        }
        hashMap.put("skip_confirmation", "true");
        String string2 = null;
        try {
            string2 = this.executePost(pSSVNServer, "users", hashMap, null, null);
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u5efa\u7acb\u7528\u6237\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
            throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u7528\u6237\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
        user = this.jacksonJson.unmarshal(User.class, string2);
        return user;
    }

    @Override
    public Group createGroupByPSDevSln(PSDevSln pSDevSln) throws Exception {
        String string;
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        String string2 = pSDevSln.getCodeName();
        String string3 = pSDevSln.getPSDevSlnName();
        if (PSDevCenterHelper.isLabDC(pSDevSln.getPSDevCenter()) && (StringHelper.isNullOrEmpty((String)(string = pSDevSln.getPSDevCenter().getDCTag4())) || !string.contentEquals("PRO"))) {
            string2 = "t" + KeyValueHelper.genUniqueId((String)string2, (String)Long.toString(random.nextLong()), (String)Long.toString(System.currentTimeMillis()));
        }
        hashMap.put("path", string2);
        hashMap.put("name", string3);
        string = null;
        PSSVNServer pSSVNServer = this.getPSSVNServer(pSDevSln.getSlnTag());
        User user = null;
        try {
            if (!StringHelper.isNullOrEmpty((String)pSSVNServer.getGITUserName()) && (user = this.getUser(pSSVNServer, pSSVNServer.getGITUserName())) == null) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u4ee3\u7801\u63d0\u4ea4\u7528\u6237\u8d26\u6237"));
            }
            string = this.executePost(pSSVNServer, "groups", hashMap, this.getCurUserName(pSDevSln.getPSDevCenter()), null);
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u5efa\u7acb\u5f00\u53d1\u65b9\u6848\u7fa4\u7ec4\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
            throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u5f00\u53d1\u65b9\u6848\u7fa4\u7ec4\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
        Group group = this.jacksonJson.unmarshal(Group.class, string);
        pSDevSln.setSlnTag2(Integer.toString(group.getId()));
        if (user != null && !PSDevCenterHelper.isRecycleDC(pSDevSln.getPSDevCenter()) && !PSCoreSysServiceBase.isCloudMode()) {
            hashMap.clear();
            hashMap.put("user_id", Integer.toString(user.getId()));
            hashMap.put("access_level", Integer.toString(40));
            try {
                string = this.executePost(pSSVNServer, StringHelper.format((String)"groups/%1$s/members", (Object)group.getId()), hashMap, this.getCurUserName(pSDevSln.getPSDevCenter()), null);
            }
            catch (Exception exception) {
                log.error((Object)StringHelper.format((String)"\u5efa\u7acb\u7fa4\u7ec4\u6210\u5458\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
                throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u7fa4\u7ec4\u6210\u5458\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
            }
        }
        return group;
    }

    protected Group createSubGroupByPSDevSlnSysDynaInst(PSDevSln pSDevSln, PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        String string = "DynaInst" + KeyValueHelper.genUniqueId((String)pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstId(), (String)Long.toString(random.nextLong()), (String)Long.toString(System.currentTimeMillis()));
        String string2 = pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstName();
        hashMap.put("path", string);
        hashMap.put("name", string2);
        hashMap.put("parent_id", pSDevSln.getSlnTag2());
        String string3 = null;
        PSSVNServer pSSVNServer = this.getPSSVNServer(pSDevSln.getSlnTag());
        User user = null;
        try {
            if (!StringHelper.isNullOrEmpty((String)pSSVNServer.getGITUserName()) && (user = this.getUser(pSSVNServer, pSSVNServer.getGITUserName())) == null) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u4ee3\u7801\u63d0\u4ea4\u7528\u6237\u8d26\u6237"));
            }
            string3 = this.executePost(pSSVNServer, "groups", hashMap, this.getCurUserName(pSDevSln.getPSDevCenter()), null);
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u5efa\u7acb\u52a8\u6001\u5b9e\u4f8b\u5b50\u7fa4\u7ec4\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
            throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u52a8\u6001\u5b9e\u4f8b\u5b50\u7fa4\u7ec4\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
        Group group = this.jacksonJson.unmarshal(Group.class, string3);
        pSDevSlnSysDynaInst.setInstTag3(Integer.toString(group.getId()));
        if (user != null && !PSDevCenterHelper.isRecycleDC(pSDevSln.getPSDevCenter())) {
            hashMap.clear();
            hashMap.put("user_id", Integer.toString(user.getId()));
            hashMap.put("access_level", Integer.toString(40));
            try {
                string3 = this.executePost(pSSVNServer, StringHelper.format((String)"groups/%1$s/members", (Object)group.getId()), hashMap, this.getCurUserName(pSDevSln.getPSDevCenter()), null);
            }
            catch (Exception exception) {
                log.error((Object)StringHelper.format((String)"\u5efa\u7acb\u7fa4\u7ec4\u6210\u5458\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
                throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u7fa4\u7ec4\u6210\u5458\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
            }
        }
        return group;
    }

    @Override
    public Project createCodeProjectByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        return this.createProjectByPSDevSlnSys(pSDevSlnSys, true);
    }

    @Override
    public Project createModelProjectByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        return this.createProjectByPSDevSlnSys(pSDevSlnSys, false);
    }

    @Override
    public Project createRuntimeProjectByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        return this.createProjectByPSDevSlnSys(pSDevSlnSys, 2);
    }

    @Override
    public Project createDocProjectByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        return this.createProjectByPSDevSlnSys(pSDevSlnSys, 3);
    }

    protected Project createProjectByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, boolean bl) throws Exception {
        return this.createProjectByPSDevSlnSys(pSDevSlnSys, bl ? 1 : 0);
    }

    /*
     * WARNING - void declaration
     */
    protected Project createProjectByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, int n) throws Exception {
        Serializable serializable;
        PSDevSln pSDevSln = pSDevSlnSys.getPSDevSln();
        if (pSDevSln == null) {
            throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u7cfb\u7edf\u6ca1\u6709\u6307\u5b9a\u5f00\u53d1\u65b9\u6848"));
        }
        String string = null;
        String string2 = null;
        if (pSDevSln.getPSDevCenterSVN() != null && pSDevSln.getPSDevCenterSVN().getPSSVNInstRepo() != null) {
            string = pSDevSln.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag();
            string2 = pSDevSln.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag2();
        } else {
            string = pSDevSln.getSlnTag();
            string2 = pSDevSln.getSlnTag2();
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u65b9\u6848[%1$s]\u6ca1\u6709\u6307\u5b9a\u7248\u672c\u4ed3\u5e93", (Object)pSDevSln.getPSDevSlnName()));
        }
        if (StringHelper.isNullOrEmpty((String)string2)) {
            throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u65b9\u6848[%1$s]\u6ca1\u6709\u6307\u5b9a\u7fa4\u7ec4\u6807\u8bc6", (Object)pSDevSln.getPSDevSlnName()));
        }
        PSSVNServer pSSVNServer = this.getPSSVNServer(string);
        Namespace namespace = this.getNamespace(pSSVNServer, string2);
        if (PSCoreSysServiceBase.isEnableGitBranch()) {
            serializable = pSDevSlnSys.getPPSDevSlnSys();
            if (serializable == null) {
                serializable = pSDevSlnSys.getMainPSDevSlnSys();
            }
            if (serializable != null) {
                void var12_17;
                PSDevCenterSVN pSDevCenterSVN = null;
                switch (n) {
                    case 1: {
                        pSDevCenterSVN = ((PSDevSlnSysBase)serializable).getPSDevCenterSVN();
                        break;
                    }
                    case 0: {
                        pSDevCenterSVN = ((PSDevSlnSysBase)serializable).getModelPSDevCenterSVN();
                        break;
                    }
                    case 2: {
                        pSDevCenterSVN = ((PSDevSlnSysBase)serializable).getRTModelPSDevCenterSVN();
                        break;
                    }
                    case 3: {
                        pSDevCenterSVN = ((PSDevSlnSysBase)serializable).getDocPSDevCenterSVN();
                    }
                }
                PSSVNInstRepo pSSVNInstRepo = null;
                if (pSDevCenterSVN != null) {
                    pSSVNInstRepo = pSDevCenterSVN.getPSSVNInstRepo();
                }
                if (pSSVNInstRepo == null) {
                    throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u7236\u7cfb\u7edf[%1$s]\u76f8\u5173\u4ed3\u5e93", pSDevSlnSys.getPPSDevSlnSys().getPSDevSlnSysName()));
                }
                HashMap<String, Object> hashMap = new HashMap<String, Object>();
                hashMap.put("branch", pSDevSlnSys.getPSDevSlnSysName().toLowerCase());
                String string3 = pSSVNInstRepo.getGitBranch();
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    String object = "master";
                }
                hashMap.put("branch", pSDevSlnSys.getPSDevSlnSysName().toLowerCase());
                hashMap.put("ref", var12_17);
                String string4 = null;
                String string5 = pSSVNInstRepo.getRepoTag2();
                try {
                    string4 = this.executePost(pSSVNServer, StringHelper.format((String)"projects/%1$s/repository/branches", (Object)string5), hashMap, this.getCurUserName(pSDevSln.getPSDevCenter()), null);
                }
                catch (Exception exception) {
                    log.error((Object)StringHelper.format((String)"\u5efa\u7acb\u9879\u76ee\u5206\u652f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
                    throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u9879\u76ee\u5206\u652f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
                }
                Branch branch = this.jacksonJson.unmarshal(Branch.class, string4);
                Project project = new Project();
                project.setId(Integer.valueOf(string5));
                project.setDefaultBranch(pSDevSlnSys.getPSDevSlnSysName().toLowerCase());
                project.setHttpUrlToRepo(pSSVNInstRepo.getGitPath());
                project.setPath(pSSVNInstRepo.getPSSVNInstRepoName());
                return project;
            }
        }
        serializable = new HashMap();
        String string6 = pSDevSlnSys.getPSDevSlnSysName();
        String string7 = pSDevSlnSys.getLogicName();
        if (StringHelper.isNullOrEmpty((String)string7)) {
            string7 = string6;
        }
        if (n == 0) {
            string6 = StringHelper.format((String)StringHelper.format((String)"%1$s_model", (Object)string6));
            string7 = StringHelper.format((String)StringHelper.format((String)"%1$s\u6a21\u578b", (Object)string7));
        } else if (n == 2) {
            string6 = StringHelper.format((String)StringHelper.format((String)"%1$s_runtime", (Object)string6));
            string7 = StringHelper.format((String)StringHelper.format((String)"%1$s\u8fd0\u884c\u65f6", (Object)string7));
        } else if (n == 3) {
            string6 = StringHelper.format((String)StringHelper.format((String)"%1$s_document", (Object)string6));
            string7 = StringHelper.format((String)StringHelper.format((String)"%1$s\u6587\u6863", (Object)string7));
        }
        Project[] projectArray = this.listProjectsByPSDevSln(pSSVNServer, namespace);
        if (projectArray != null && projectArray.length > 0) {
            for (Project project : projectArray) {
                if (StringHelper.compare((String)project.getPath(), (String)string6, (boolean)true) != 0) continue;
                throw new Exception(StringHelper.format((String)"\u4ed3\u5e93\u9879\u76ee\u8def\u5f84[%1$s]\u5df2\u5b58\u5728", (Object)string6));
            }
            for (Project project : projectArray) {
                if (StringHelper.compare((String)project.getName(), (String)string7, (boolean)true) != 0) continue;
                string7 = null;
                break;
            }
        }
        serializable.put("path", string6);
        if (!StringHelper.isNullOrEmpty((String)string7)) {
            serializable.put("name", string7);
        }
        serializable.put("namespace_id", Integer.toString(namespace.getId()));
        Object object = pSDevSlnSys.get("importurl");
        if (!StringHelper.isNullOrEmpty((Object)object)) {
            serializable.put("import_url", object);
        } else {
            serializable.put("import_url", "");
            serializable.put("initialize_with_readme", "true");
        }
        serializable.put("description", "");
        serializable.put("issues_enabled", "true");
        serializable.put("merge_requests_enabled", "true");
        serializable.put("wiki_enabled", "true");
        serializable.put("snippets_enabled", "true");
        serializable.put("visibility_level", "20");
        String string8 = null;
        try {
            string8 = this.executePost(pSSVNServer, "projects", (Map<String, Object>)((Object)serializable), this.getCurUserName(pSDevSln.getPSDevCenter()), null);
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u5efa\u7acb\u5f00\u53d1\u7cfb\u7edf\u9879\u76ee\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
            throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u5f00\u53d1\u7cfb\u7edf\u9879\u76ee\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
        Project project = this.jacksonJson.unmarshal(Project.class, string8);
        return project;
    }

    @Override
    public Project createProjectByPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        String string;
        Project[] projectArray;
        PSDevSln pSDevSln = pSDevSlnTempl.getPSDevSln();
        if (pSDevSln == null) {
            throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u6a21\u677f\u6ca1\u6709\u6307\u5b9a\u5f00\u53d1\u65b9\u6848"));
        }
        String string2 = null;
        String string22 = null;
        if (pSDevSln.getPSDevCenterSVN() != null && pSDevSln.getPSDevCenterSVN().getPSSVNInstRepo() != null) {
            string2 = pSDevSln.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag();
            string22 = pSDevSln.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag2();
        } else {
            string2 = pSDevSln.getSlnTag();
            string22 = pSDevSln.getSlnTag2();
        }
        if (StringHelper.isNullOrEmpty((String)string2)) {
            throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u65b9\u6848[%1$s]\u6ca1\u6709\u6307\u5b9a\u7248\u672c\u4ed3\u5e93", (Object)pSDevSln.getPSDevSlnName()));
        }
        if (StringHelper.isNullOrEmpty((String)string22)) {
            throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u65b9\u6848[%1$s]\u6ca1\u6709\u6307\u5b9a\u7fa4\u7ec4\u6807\u8bc6", (Object)pSDevSln.getPSDevSlnName()));
        }
        PSSVNServer pSSVNServer = this.getPSSVNServer(string2);
        Namespace namespace = this.getNamespace(pSSVNServer, string22);
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        String string3 = pSDevSlnTempl.getPSDevSlnTemplName();
        String string4 = pSDevSlnTempl.getLogicName();
        if (StringHelper.isNullOrEmpty((String)string4)) {
            string4 = string3;
        }
        if ((projectArray = this.listProjectsByPSDevSln(pSSVNServer, namespace)) != null && projectArray.length > 0) {
            for (Project project : projectArray) {
                if (StringHelper.compare((String)project.getPath(), (String)string3, (boolean)true) != 0) continue;
                throw new Exception(StringHelper.format((String)"\u4ed3\u5e93\u9879\u76ee\u8def\u5f84[%1$s]\u5df2\u5b58\u5728", (Object)string3));
            }
            for (Project project : projectArray) {
                if (StringHelper.compare((String)project.getName(), (String)string4, (boolean)true) != 0) continue;
                string4 = null;
                break;
            }
        }
        hashMap.put("path", string3);
        if (!StringHelper.isNullOrEmpty((String)string4)) {
            hashMap.put("name", string4);
        }
        hashMap.put("namespace_id", Integer.toString(namespace.getId()));
        hashMap.put("import_url", "");
        hashMap.put("description", "");
        hashMap.put("issues_enabled", "true");
        hashMap.put("merge_requests_enabled", "true");
        hashMap.put("wiki_enabled", "true");
        hashMap.put("snippets_enabled", "true");
        hashMap.put("visibility_level", "20");
        hashMap.put("initialize_with_readme", "true");
        Object var11_13 = null;
        try {
            string = this.executePost(pSSVNServer, "projects", hashMap, this.getCurUserName(pSDevSln.getPSDevCenter()), null);
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u5efa\u7acb\u5f00\u53d1\u6a21\u677f\u9879\u76ee\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
            throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u5f00\u53d1\u6a21\u677f\u9879\u76ee\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
        Project project = this.jacksonJson.unmarshal(Project.class, string);
        return project;
    }

    @Override
    public Project[] listProjectsByPSDevSln(PSDevSln pSDevSln) throws Exception {
        String string = null;
        String string2 = null;
        if (pSDevSln.getPSDevCenterSVN() != null && pSDevSln.getPSDevCenterSVN().getPSSVNInstRepo() != null) {
            string = pSDevSln.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag();
            string2 = pSDevSln.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag2();
        } else {
            string = pSDevSln.getSlnTag();
            string2 = pSDevSln.getSlnTag2();
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u65b9\u6848[%1$s]\u6ca1\u6709\u6307\u5b9a\u7248\u672c\u4ed3\u5e93", (Object)pSDevSln.getPSDevSlnName()));
        }
        if (StringHelper.isNullOrEmpty((String)string2)) {
            throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u65b9\u6848[%1$s]\u6ca1\u6709\u6307\u5b9a\u7fa4\u7ec4\u6807\u8bc6", (Object)pSDevSln.getPSDevSlnName()));
        }
        PSSVNServer pSSVNServer = this.getPSSVNServer(string);
        Namespace namespace = this.getNamespace(pSSVNServer, string2);
        try {
            return this.listProjectsByPSDevSln(pSSVNServer, namespace);
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u67e5\u8be2\u7fa4\u7ec4\u9879\u76ee\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u7fa4\u7ec4\u9879\u76ee\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
    }

    @Override
    public Member createMemberByPSDevSlnUser(PSDevSlnUser pSDevSlnUser) throws Exception {
        return this.dealMemberByPSDevSlnUser(pSDevSlnUser, 1);
    }

    @Override
    public Member updateMemberByPSDevSlnUser(PSDevSlnUser pSDevSlnUser) throws Exception {
        return this.dealMemberByPSDevSlnUser(pSDevSlnUser, 2);
    }

    @Override
    public void removeMemberByPSDevSlnUser(PSDevSlnUser pSDevSlnUser) throws Exception {
        this.dealMemberByPSDevSlnUser(pSDevSlnUser, 3);
    }

    protected Member dealMemberByPSDevSlnUser(PSDevSlnUser pSDevSlnUser, int n) throws Exception {
        Object object;
        if (pSDevSlnUser.getAllSysFlag() == null) {
            throw new Exception("\u4f20\u5165\u5f00\u53d1\u65b9\u6848\u6210\u5458\u4e0d\u6b63\u786e");
        }
        PSDevUser pSDevUser = null;
        if (StringHelper.compare((String)pSDevSlnUser.getDevUserObjType(), (String)"USER", (boolean)false) == 0) {
            object = (PSDevUserService)ServiceGlobal.getService(PSDevUserService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            pSDevUser = new PSDevUser();
            pSDevUser.setPSDevUserId(pSDevSlnUser.getPSDevUserObjId());
            if (!object.get((IEntity)pSDevUser, true)) {
                pSDevUser = null;
            }
        }
        if (pSDevUser == null) {
            log.error((Object)StringHelper.format((String)"\u4f20\u5165\u5f00\u53d1\u65b9\u6848\u6210\u5458\u4e0d\u6b63\u786e\uff0c[%1$s|%2$s]\u5f00\u53d1\u7528\u6237\u65e0\u6548", (Object)pSDevSlnUser.getPSDevUserObjId(), (Object)pSDevSlnUser.getPSDevUserObjName()));
            throw new Exception(StringHelper.format((String)"\u4f20\u5165\u5f00\u53d1\u65b9\u6848\u6210\u5458\u4e0d\u6b63\u786e\uff0c[%1$s]\u5f00\u53d1\u7528\u6237\u65e0\u6548", (Object)pSDevSlnUser.getPSDevUserObjName()));
        }
        object = this.getUserNameByPSDevUser(pSDevUser);
        if (StringHelper.isNullOrEmpty((String)object)) {
            throw new Exception(StringHelper.format((String)"\u4f20\u5165\u5f00\u53d1\u65b9\u6848\u6210\u5458\u4e0d\u6b63\u786e\uff0c[%1$s]\u7528\u6237\u540d\u79f0\u65e0\u6548", (Object)pSDevUser.getPSDevUserName()));
        }
        boolean bl = false;
        String string = "";
        String string2 = "";
        String string3 = "";
        String string4 = "";
        String string5 = "";
        switch (pSDevSlnUser.getAllSysFlag()) {
            case 0: {
                if (pSDevSlnUser.getPSDevSlnSys() == null || pSDevSlnUser.getPSDevSlnSys().getPSDevCenterSVN() == null || pSDevSlnUser.getPSDevSlnSys().getPSDevCenterSVN().getPSSVNInstRepo() == null) {
                    throw new Exception("\u4f20\u5165\u5f00\u53d1\u65b9\u6848\u6210\u5458\u4e0d\u6b63\u786e\uff0c\u5f00\u53d1\u7cfb\u7edf\u4ee3\u7801\u4ed3\u5e93\u65e0\u6548");
                }
                string2 = pSDevSlnUser.getPSDevSlnSys().getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag2();
                if (StringHelper.isNullOrEmpty((String)string2)) {
                    throw new Exception("\u4f20\u5165\u5f00\u53d1\u65b9\u6848\u6210\u5458\u4e0d\u6b63\u786e\uff0c\u5f00\u53d1\u7cfb\u7edf\u4ee3\u7801\u4ed3\u5e93\u6807\u8bc6\u65e0\u6548");
                }
                if (pSDevSlnUser.getPSDevSlnSys() == null || pSDevSlnUser.getPSDevSlnSys().getModelPSDevCenterSVN() == null || pSDevSlnUser.getPSDevSlnSys().getModelPSDevCenterSVN().getPSSVNInstRepo() == null) {
                    throw new Exception("\u4f20\u5165\u5f00\u53d1\u65b9\u6848\u6210\u5458\u4e0d\u6b63\u786e\uff0c\u5f00\u53d1\u7cfb\u7edf\u6a21\u578b\u4ed3\u5e93\u65e0\u6548");
                }
                string3 = pSDevSlnUser.getPSDevSlnSys().getModelPSDevCenterSVN().getPSSVNInstRepo().getRepoTag2();
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception("\u4f20\u5165\u5f00\u53d1\u65b9\u6848\u6210\u5458\u4e0d\u6b63\u786e\uff0c\u5f00\u53d1\u7cfb\u7edf\u6a21\u578b\u4ed3\u5e93\u6807\u8bc6\u65e0\u6548");
                }
                if (pSDevSlnUser.getPSDevSlnSys().getRTModelPSDevCenterSVN() != null && pSDevSlnUser.getPSDevSlnSys().getRTModelPSDevCenterSVN().getPSSVNInstRepo() != null) {
                    string4 = pSDevSlnUser.getPSDevSlnSys().getRTModelPSDevCenterSVN().getPSSVNInstRepo().getRepoTag2();
                }
                if (pSDevSlnUser.getPSDevSlnSys().getDocPSDevCenterSVN() == null || pSDevSlnUser.getPSDevSlnSys().getDocPSDevCenterSVN().getPSSVNInstRepo() == null) break;
                string5 = pSDevSlnUser.getPSDevSlnSys().getDocPSDevCenterSVN().getPSSVNInstRepo().getRepoTag2();
                break;
            }
            case 2: {
                if (pSDevSlnUser.getPSDevSlnTempl() == null || pSDevSlnUser.getPSDevSlnTempl().getPSDevCenterSVN() == null || pSDevSlnUser.getPSDevSlnTempl().getPSDevCenterSVN().getPSSVNInstRepo() == null) {
                    throw new Exception("\u4f20\u5165\u5f00\u53d1\u65b9\u6848\u6210\u5458\u4e0d\u6b63\u786e\uff0c\u5f00\u53d1\u6a21\u677f\u65e0\u6548");
                }
                string2 = pSDevSlnUser.getPSDevSlnTempl().getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag2();
                if (!StringHelper.isNullOrEmpty((String)string2)) break;
                throw new Exception("\u4f20\u5165\u5f00\u53d1\u65b9\u6848\u6210\u5458\u4e0d\u6b63\u786e\uff0c\u5f00\u53d1\u6a21\u677f\u4ed3\u5e93\u6807\u8bc6\u65e0\u6548");
            }
            case 3: {
                if (pSDevSlnUser.getPSDevSlnSysDynaInst() == null || pSDevSlnUser.getPSDevSlnSysDynaInst().getCfgPSDevCenterSVN() == null || pSDevSlnUser.getPSDevSlnSysDynaInst().getCfgPSDevCenterSVN().getPSSVNInstRepo() == null) {
                    throw new Exception("\u4f20\u5165\u5f00\u53d1\u65b9\u6848\u6210\u5458\u4e0d\u6b63\u786e\uff0c\u52a8\u6001\u5b9e\u4f8b\u914d\u7f6e\u4ed3\u5e93\u65e0\u6548");
                }
                string2 = pSDevSlnUser.getPSDevSlnSysDynaInst().getCfgPSDevCenterSVN().getPSSVNInstRepo().getRepoTag2();
                if (StringHelper.isNullOrEmpty((String)string2)) {
                    throw new Exception("\u4f20\u5165\u5f00\u53d1\u65b9\u6848\u6210\u5458\u4e0d\u6b63\u786e\uff0c\u52a8\u6001\u5b9e\u4f8b\u914d\u7f6e\u4ed3\u5e93\u6807\u8bc6\u65e0\u6548");
                }
                if (pSDevSlnUser.getPSDevSlnSysDynaInst() == null || pSDevSlnUser.getPSDevSlnSysDynaInst().getModelPSDevCenterSVN() == null || pSDevSlnUser.getPSDevSlnSysDynaInst().getModelPSDevCenterSVN().getPSSVNInstRepo() == null) {
                    throw new Exception("\u4f20\u5165\u5f00\u53d1\u65b9\u6848\u6210\u5458\u4e0d\u6b63\u786e\uff0c\u52a8\u6001\u5b9e\u4f8b\u6a21\u578b\u4ed3\u5e93\u65e0\u6548");
                }
                string3 = pSDevSlnUser.getPSDevSlnSysDynaInst().getModelPSDevCenterSVN().getPSSVNInstRepo().getRepoTag2();
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception("\u4f20\u5165\u5f00\u53d1\u65b9\u6848\u6210\u5458\u4e0d\u6b63\u786e\uff0c\u52a8\u6001\u5b9e\u4f8b\u6a21\u578b\u4ed3\u5e93\u6807\u8bc6\u65e0\u6548");
                }
                string = pSDevSlnUser.getPSDevSlnSysDynaInst().getInstTag3();
                if (StringHelper.isNullOrEmpty((String)string)) {
                    if (pSDevSlnUser.getPSDevSlnSysDynaInst().getPPSDevSlnSysDynaInst() != null) {
                        string = pSDevSlnUser.getPSDevSlnSysDynaInst().getPPSDevSlnSysDynaInst().getInstTag3();
                    }
                    if (StringHelper.isNullOrEmpty((String)string)) {
                        throw new Exception("\u4f20\u5165\u5f00\u53d1\u65b9\u6848\u6210\u5458\u4e0d\u6b63\u786e\uff0c\u52a8\u6001\u5b9e\u4f8b\u5b50\u5206\u7ec4\u6807\u8bc6\u65e0\u6548");
                    }
                }
                if (StringHelper.isNullOrEmpty((String)pSDevSlnUser.getPSDevSlnSysDynaInst().getPPSDevSlnSysDynaInstId())) {
                    string2 = "";
                    string3 = "";
                }
                bl = true;
            }
        }
        String string6 = null;
        String string7 = null;
        PSDevSln pSDevSln = pSDevSlnUser.getPSDevSln();
        if (pSDevSln == null || pSDevSln.getPSDevCenter() == null) {
            throw new Exception("\u4f20\u5165\u5f00\u53d1\u65b9\u6848\u7528\u6237\u4e0d\u6b63\u786e\uff0c\u5f00\u53d1\u65b9\u6848\u65e0\u6548");
        }
        if (pSDevSln.getPSDevCenterSVN() != null && pSDevSln.getPSDevCenterSVN().getPSSVNInstRepo() != null) {
            string6 = pSDevSln.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag();
            string7 = pSDevSln.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag2();
        } else {
            string6 = pSDevSln.getSlnTag();
            string7 = pSDevSln.getSlnTag2();
        }
        if (StringHelper.isNullOrEmpty((String)string6)) {
            throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u65b9\u6848[%1$s]\u6ca1\u6709\u6307\u5b9a\u7248\u672c\u4ed3\u5e93", (Object)pSDevSln.getPSDevSlnName()));
        }
        if (StringHelper.isNullOrEmpty((String)string7)) {
            throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u65b9\u6848[%1$s]\u6ca1\u6709\u6307\u5b9a\u7fa4\u7ec4\u6807\u8bc6", (Object)pSDevSln.getPSDevSlnName()));
        }
        PSSVNServer pSSVNServer = this.getPSSVNServer(string6);
        User user = null;
        try {
            if (n == 3) {
                user = this.getUser(pSSVNServer, object);
                if (user == null) {
                    return null;
                }
            } else {
                user = this.createUserByPSDevUser(pSSVNServer, pSDevUser, (String)object, true);
            }
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u4ed3\u5e93\u670d\u52a1\u5668\u7528\u6237\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
            throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u4ed3\u5e93\u670d\u52a1\u5668\u7528\u6237\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
        if (user == null) {
            throw new Exception(StringHelper.format((String)"\u4ed3\u5e93\u670d\u52a1\u5668\u4e0d\u5b58\u5728\u6307\u5b9a\u7528\u6237[%1$s]", (Object)object));
        }
        int n2 = DataObject.getIntegerValue((Object)pSDevSlnUser.getAccMode(), (Integer)SlnSysAccModeCodeListModel.READ);
        if (PSDevCenterHelper.isLabDC(pSDevSln.getPSDevCenter())) {
            n2 = PSDevCenterHelper.isLabDCRepoReadonly(pSDevSln.getPSDevCenter()) ? 1 : ((n2 & 3) == 3 ? 3 : 1);
        }
        if (bl) {
            n2 = 1;
        }
        if (!StringHelper.isNullOrEmpty((String)string)) {
            string7 = string;
        }
        if (StringHelper.isNullOrEmpty((String)string2) && StringHelper.isNullOrEmpty((String)string3)) {
            return this.dealMember(pSSVNServer, pSDevSln, n, string7, null, user, n2);
        }
        if (!StringHelper.isNullOrEmpty((String)string4)) {
            this.dealMember(pSSVNServer, pSDevSln, n, string7, string4, user, n2);
        }
        if (!StringHelper.isNullOrEmpty((String)string5)) {
            this.dealMember(pSSVNServer, pSDevSln, n, string7, string5, user, n2);
        }
        if (!StringHelper.isNullOrEmpty((String)string3)) {
            this.dealMember(pSSVNServer, pSDevSln, n, string7, string3, user, n2);
        }
        return this.dealMember(pSSVNServer, pSDevSln, n, string7, string2, user, n2);
    }

    protected Member dealMember(PSSVNServer pSSVNServer, PSDevSln pSDevSln, int n, String string, String string2, User user, int n2) throws Exception {
        Integer n3 = 0;
        switch (n2) {
            case 1: {
                n3 = 20;
                break;
            }
            case 3: {
                n3 = 30;
                break;
            }
            case 7: {
                n3 = 40;
                break;
            }
            default: {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u8bbf\u95ee\u6a21\u5f0f[%1$s]", (Object)n2));
            }
        }
        Member[] memberArray = null;
        if (!StringHelper.isNullOrEmpty((String)string2)) {
            try {
                memberArray = this.listProjectMembers(pSSVNServer, string2);
            }
            catch (Exception exception) {
                log.error((Object)StringHelper.format((String)"\u67e5\u8be2\u9879\u76ee\u6210\u5458\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
                throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u9879\u76ee\u6210\u5458\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
            }
        }
        try {
            memberArray = this.listGroupMembers(pSSVNServer, string);
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u67e5\u8be2\u7fa4\u7ec4\u6210\u5458\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u7fa4\u7ec4\u6210\u5458\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
        Member member = null;
        if (memberArray != null) {
            for (Member member2 : memberArray) {
                if (StringHelper.compare((String)member2.getUsername(), (String)user.getUsername(), (boolean)false) != 0) continue;
                member = member2;
                break;
            }
        }
        if (n == 3) {
            if (member == null) {
                return null;
            }
        } else if (member == null) {
            n = 1;
        } else {
            n = 2;
            if (member.getAccessLevel().value >= 50) {
                return member;
            }
        }
        HashMap hashMap = new HashMap();
        String string3 = null;
        if (n == 1) {
            hashMap.put("user_id", Integer.toString(user.getId()));
            hashMap.put("access_level", Integer.toString(n3));
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                try {
                    string3 = this.executePost(pSSVNServer, StringHelper.format((String)"projects/%1$s/members", (Object)string2), hashMap, this.getCurUserName(pSDevSln.getPSDevCenter()), null);
                }
                catch (Exception exception) {
                    log.error((Object)StringHelper.format((String)"\u5efa\u7acb\u9879\u76ee\u6210\u5458\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
                    throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u9879\u76ee\u6210\u5458\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
                }
            }
            try {
                string3 = this.executePost(pSSVNServer, StringHelper.format((String)"groups/%1$s/members", (Object)string), hashMap, this.getCurUserName(pSDevSln.getPSDevCenter()), null);
            }
            catch (Exception exception) {
                log.error((Object)StringHelper.format((String)"\u5efa\u7acb\u7fa4\u7ec4\u6210\u5458\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
                throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u7fa4\u7ec4\u6210\u5458\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
            }
            Member member3 = this.jacksonJson.unmarshal(Member.class, string3);
            return member3;
        }
        if (n == 2) {
            hashMap.put("access_level", Integer.toString(n3));
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                try {
                    string3 = this.executePut(pSSVNServer, StringHelper.format((String)"projects/%1$s/members/%2$s", (Object)string2, (Object)user.getId()), hashMap, this.getCurUserName(pSDevSln.getPSDevCenter()), null);
                }
                catch (Exception exception) {
                    log.error((Object)StringHelper.format((String)"\u66f4\u65b0\u9879\u76ee\u6210\u5458\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
                    throw new Exception(StringHelper.format((String)"\u66f4\u65b0\u9879\u76ee\u6210\u5458\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
                }
            }
            try {
                string3 = this.executePut(pSSVNServer, StringHelper.format((String)"groups/%1$s/members/%2$s", (Object)string, (Object)user.getId()), hashMap, this.getCurUserName(pSDevSln.getPSDevCenter()), null);
            }
            catch (Exception exception) {
                log.error((Object)StringHelper.format((String)"\u66f4\u65b0\u7fa4\u7ec4\u6210\u5458\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
                throw new Exception(StringHelper.format((String)"\u66f4\u65b0\u7fa4\u7ec4\u6210\u5458\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
            }
            Member member4 = this.jacksonJson.unmarshal(Member.class, string3);
            return member4;
        }
        if (n == 3) {
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                try {
                    string3 = this.executeDelete(pSSVNServer, StringHelper.format((String)"projects/%1$s/members/%2$s", (Object)string2, (Object)user.getId()), hashMap, this.getCurUserName(pSDevSln.getPSDevCenter()), null);
                }
                catch (Exception exception) {
                    log.error((Object)StringHelper.format((String)"\u5220\u9664\u9879\u76ee\u6210\u5458\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
                    throw new Exception(StringHelper.format((String)"\u5220\u9664\u9879\u76ee\u6210\u5458\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
                }
            }
            try {
                string3 = this.executeDelete(pSSVNServer, StringHelper.format((String)"groups/%1$s/members/%2$s", (Object)string, (Object)user.getId()), hashMap, this.getCurUserName(pSDevSln.getPSDevCenter()), null);
            }
            catch (Exception exception) {
                log.error((Object)StringHelper.format((String)"\u5220\u9664\u7fa4\u7ec4\u6210\u5458\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
                throw new Exception(StringHelper.format((String)"\u5220\u9664\u7fa4\u7ec4\u6210\u5458\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
            }
            return null;
        }
        return null;
    }

    protected Project[] listProjectsByPSDevSln(PSSVNServer pSSVNServer, Namespace namespace) throws Exception {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("per_page", "1000");
        String string = this.executeGet(pSSVNServer, String.format("groups/%1$s/projects", namespace.getId()), hashMap, null);
        Project[] projectArray = this.jacksonJson.unmarshal(Project[].class, string);
        return projectArray;
    }

    protected Member[] listGroupMembers(PSSVNServer pSSVNServer, Object object) throws Exception {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("per_page", "1000");
        String string = this.executeGet(pSSVNServer, String.format("groups/%1$s/members", object), hashMap, null);
        Member[] memberArray = this.jacksonJson.unmarshal(Member[].class, string);
        return memberArray;
    }

    protected Member[] listProjectMembers(PSSVNServer pSSVNServer, Object object) throws Exception {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("per_page", "1000");
        String string = this.executeGet(pSSVNServer, String.format("projects/%1$s/members", object), hashMap, null);
        Member[] memberArray = this.jacksonJson.unmarshal(Member[].class, string);
        return memberArray;
    }

    protected Tag[] listTags(PSSVNServer pSSVNServer, String string) throws Exception {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("per_page", "1000");
        String string2 = this.executeGet(pSSVNServer, String.format("projects/%1$s/repository/tags", string), hashMap, null);
        Tag[] tagArray = this.jacksonJson.unmarshal(Tag[].class, string2);
        return tagArray;
    }

    protected Namespace getNamespace(PSSVNServer pSSVNServer, Object object) throws Exception {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        String string = this.executeGet(pSSVNServer, String.format("namespaces/%1$s", object), hashMap, null);
        Namespace namespace = this.jacksonJson.unmarshal(Namespace.class, string);
        if (namespace == null || namespace.getId() == null) {
            return null;
        }
        return namespace;
    }

    @Override
    public User getUserByPSDevUser(PSDevUser pSDevUser, boolean bl) throws Exception {
        if (pSDevUser.getPSDevCenter() == null) {
            throw new Exception(StringHelper.format((String)"\u4f20\u5165\u5f00\u53d1\u7528\u6237\u5e94\u7528\u4e2d\u5fc3\u65e0\u6548"));
        }
        if (pSDevUser.getPSDevCenter().getV6PSSvnInstRepo() == null) {
            throw new Exception(StringHelper.format((String)"\u4f20\u5165\u5f00\u53d1\u7528\u6237\u5e94\u7528\u4e2d\u5fc3\u7248\u672c\u4ed3\u5e93\u65e0\u6548"));
        }
        String string = this.getUserNameByPSDevUser(pSDevUser);
        PSSVNServer pSSVNServer = this.getPSSVNServer(pSDevUser.getPSDevCenter().getV6PSSvnInstRepo().getPSSVNServerId());
        try {
            User user = this.getUser(pSSVNServer, string);
            if (user == null && !bl) {
                throw new Exception(StringHelper.format((String)"\u4ed3\u5e93\u670d\u52a1\u5668\u4e0d\u5b58\u5728\u7528\u6237[%1$s]", (Object)pSDevUser.getLoginName()));
            }
            return user;
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u4ed3\u5e93\u670d\u52a1\u5668\u7528\u6237\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
            throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u4ed3\u5e93\u670d\u52a1\u5668\u7528\u6237\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
    }

    protected User getUser(PSSVNServer pSSVNServer, Object object) throws Exception {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        String string = this.executeGet(pSSVNServer, String.format("users?username=%1$s", object), hashMap, null);
        User[] userArray = this.jacksonJson.unmarshal(User[].class, string);
        if (userArray == null || userArray.length == 0) {
            return null;
        }
        if (userArray[0].getId() == null) {
            return null;
        }
        return userArray[0];
    }

    protected String getCurUserName(PSDevCenter pSDevCenter) {
        if (pSDevCenter != null && PSDevCenterHelper.isLabDC(pSDevCenter)) {
            return null;
        }
        if (WebContext.getCurrent() == null) {
            return "@";
        }
        return WebContext.getCurrent().getCurLoginName();
    }

    protected boolean isAutoCreateUser(PSDevCenter pSDevCenter, PSDevUser pSDevUser) {
        return pSDevCenter != null && PSDevCenterHelper.isLabDC(pSDevCenter);
    }

    protected String getUserNameByPSDevUser(PSDevUser pSDevUser) throws Exception {
        String string = null;
        if (StringHelper.isNullOrEmpty(string)) {
            string = DataObject.getIntegerValue((Object)pSDevUser.getFromUserMode(), (Integer)0) == 1 ? pSDevUser.getFromLoginName() : pSDevUser.getLoginName();
        }
        if (StringHelper.compare(string, (String)"admin", (boolean)true) == 0 && StringHelper.compare((String)pSDevUser.getFullLoginName(), (String)"admin@demo.com", (boolean)true) == 0) {
            string = "admin_demo_com";
        }
        return string;
    }

    @Override
    public void removeGroupByPSDevSln(PSDevSln pSDevSln) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public void removeCodeProjectByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public void removeModelProjectByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public void removeProjectByPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public Project moveCodeProjectByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, PSDevSln pSDevSln) throws Exception {
        PSDevCenterSVN pSDevCenterSVN = pSDevSlnSys.getPSDevCenterSVN();
        if (pSDevCenterSVN != null) {
            return this.moveProject(pSDevCenterSVN, pSDevSln);
        }
        return null;
    }

    @Override
    public Project moveModelProjectByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, PSDevSln pSDevSln) throws Exception {
        PSDevCenterSVN pSDevCenterSVN = pSDevSlnSys.getModelPSDevCenterSVN();
        if (pSDevCenterSVN != null) {
            return this.moveProject(pSDevCenterSVN, pSDevSln);
        }
        return null;
    }

    @Override
    public Project moveProjectByPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl, PSDevSln pSDevSln) throws Exception {
        PSDevCenterSVN pSDevCenterSVN = pSDevSlnTempl.getPSDevCenterSVN();
        if (pSDevCenterSVN != null) {
            return this.moveProject(pSDevCenterSVN, pSDevSln);
        }
        return null;
    }

    protected Project moveProject(PSDevCenterSVN pSDevCenterSVN, PSDevSln pSDevSln) throws Exception {
        String string = null;
        String string2 = null;
        if (pSDevSln.getPSDevCenterSVN() != null && pSDevSln.getPSDevCenterSVN().getPSSVNInstRepo() != null) {
            string = pSDevSln.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag();
            string2 = pSDevSln.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag2();
        } else {
            string = pSDevSln.getSlnTag();
            string2 = pSDevSln.getSlnTag2();
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u65b9\u6848[%1$s]\u6ca1\u6709\u6307\u5b9a\u7248\u672c\u4ed3\u5e93", (Object)pSDevSln.getPSDevSlnName()));
        }
        if (StringHelper.isNullOrEmpty((String)string2)) {
            throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u65b9\u6848[%1$s]\u6ca1\u6709\u6307\u5b9a\u7fa4\u7ec4\u6807\u8bc6", (Object)pSDevSln.getPSDevSlnName()));
        }
        String string3 = null;
        if (pSDevCenterSVN.getPSSVNInstRepo() != null) {
            string3 = pSDevCenterSVN.getPSSVNInstRepo().getRepoTag2();
            if (StringHelper.isNullOrEmpty((String)string3)) {
                return null;
            }
            if (StringHelper.compare((String)pSDevCenterSVN.getPSSVNInstRepo().getRepoTag(), (String)string, (boolean)false) != 0) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8de8\u7248\u672c\u4ed3\u5e93\u8f6c\u79fb\u7fa4\u7ec4"));
            }
        }
        PSSVNServer pSSVNServer = this.getPSSVNServer(string);
        Namespace namespace = this.getNamespace(pSSVNServer, string2);
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("namespace", Integer.toString(namespace.getId()));
        if (!StringHelper.isNullOrEmpty((String)string3)) {
            String string4 = null;
            try {
                string4 = this.executePut(pSSVNServer, StringHelper.format((String)"projects/%1$s/transfer", (Object)string3), hashMap, this.getCurUserName(pSDevSln.getPSDevCenter()), null);
            }
            catch (Exception exception) {
                log.error((Object)StringHelper.format((String)"\u66f4\u65b0\u9879\u76ee\u6210\u5458\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
                throw new Exception(StringHelper.format((String)"\u66f4\u65b0\u9879\u76ee\u6210\u5458\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
            }
            Project project = this.jacksonJson.unmarshal(Project.class, string4);
            return project;
        }
        return null;
    }

    @Override
    public Project createProjectByPSDevSlnSysDynaInst(PSDevSln pSDevSln, PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl) throws Exception {
        String string = null;
        String string2 = null;
        if (pSDevSln.getPSDevCenterSVN() != null && pSDevSln.getPSDevCenterSVN().getPSSVNInstRepo() != null) {
            string = pSDevSln.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag();
            string2 = pSDevSln.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag2();
        } else {
            string = pSDevSln.getSlnTag();
            string2 = pSDevSln.getSlnTag2();
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u65b9\u6848[%1$s]\u6ca1\u6709\u6307\u5b9a\u7248\u672c\u4ed3\u5e93", (Object)pSDevSln.getPSDevSlnName()));
        }
        if (StringHelper.isNullOrEmpty((String)string2)) {
            throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u65b9\u6848[%1$s]\u6ca1\u6709\u6307\u5b9a\u7fa4\u7ec4\u6807\u8bc6", (Object)pSDevSln.getPSDevSlnName()));
        }
        PSSVNServer pSSVNServer = this.getPSSVNServer(string);
        if (StringHelper.isNullOrEmpty((String)pSDevSlnSysDynaInst.getPPSDevSlnSysDynaInstId())) {
            if (StringHelper.isNullOrEmpty((String)pSDevSlnSysDynaInst.getInstTag3())) {
                if (StringHelper.isNullOrEmpty((String)pSDevSln.getSlnTag2())) {
                    pSDevSln.setSlnTag2(string2);
                }
                this.createSubGroupByPSDevSlnSysDynaInst(pSDevSln, pSDevSlnSysDynaInst);
            }
            string2 = pSDevSlnSysDynaInst.getInstTag3();
        } else {
            string2 = pSDevSlnSysDynaInst.getPPSDevSlnSysDynaInst().getInstTag3();
            pSDevSlnSysDynaInst.setInstTag3(string2);
        }
        if (StringHelper.isNullOrEmpty((String)string2)) {
            throw new Exception(StringHelper.format((String)"\u52a8\u6001\u5b9e\u4f8b[%1$s]\u6ca1\u6709\u6307\u5b9a\u7fa4\u7ec4\u6807\u8bc6", (Object)pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstName()));
        }
        Namespace namespace = this.getNamespace(pSSVNServer, string2);
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        String string3 = (bl ? "Model" : "Cfg") + KeyValueHelper.genUniqueId((String)pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstId(), (String)Long.toString(random.nextLong()), (String)Long.toString(System.currentTimeMillis()));
        String string4 = pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstName();
        string4 = bl ? string4 + "\uff08\u6a21\u578b\uff09" : string4 + "\uff08\u914d\u7f6e\uff09";
        if (StringHelper.isNullOrEmpty((String)string4)) {
            string4 = string3;
        }
        hashMap.put("path", string3);
        if (!StringHelper.isNullOrEmpty((String)string4)) {
            hashMap.put("name", string4);
        }
        hashMap.put("namespace_id", Integer.toString(namespace.getId()));
        hashMap.put("import_url", "");
        hashMap.put("description", "");
        hashMap.put("issues_enabled", "true");
        hashMap.put("merge_requests_enabled", "true");
        hashMap.put("wiki_enabled", "true");
        hashMap.put("snippets_enabled", "true");
        hashMap.put("visibility_level", "20");
        String string5 = null;
        try {
            string5 = this.executePost(pSSVNServer, "projects", hashMap, this.getCurUserName(pSDevSln.getPSDevCenter()), null);
        }
        catch (Exception exception) {
            if (bl) {
                log.error((Object)StringHelper.format((String)"\u5efa\u7acb\u52a8\u6001\u5b9e\u4f8b\u6a21\u578b\u9879\u76ee\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
                throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u52a8\u6001\u5b9e\u4f8b\u6a21\u578b\u9879\u76ee\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
            }
            log.error((Object)StringHelper.format((String)"\u5efa\u7acb\u52a8\u6001\u5b9e\u4f8b\u914d\u7f6e\u9879\u76ee\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
            throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u52a8\u6001\u5b9e\u4f8b\u914d\u7f6e\u9879\u76ee\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
        Project project = this.jacksonJson.unmarshal(Project.class, string5);
        return project;
    }

    @Override
    public Tag[] listTagsByPSDevSlnSysDynaInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        PSDevSln pSDevSln = pSDevSlnSysDynaInst.getPSDevSln();
        if (pSDevSln == null) {
            throw new Exception(StringHelper.format((String)"\u52a8\u6001\u5b9e\u4f8b\u6ca1\u6709\u6307\u5b9a\u5f00\u53d1\u65b9\u6848"));
        }
        String string = null;
        String string2 = null;
        if (pSDevSln.getPSDevCenterSVN() != null && pSDevSln.getPSDevCenterSVN().getPSSVNInstRepo() != null) {
            string = pSDevSln.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag();
            string2 = pSDevSln.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag2();
        } else {
            string = pSDevSln.getSlnTag();
            string2 = pSDevSln.getSlnTag2();
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u65b9\u6848[%1$s]\u6ca1\u6709\u6307\u5b9a\u7248\u672c\u4ed3\u5e93", (Object)pSDevSln.getPSDevSlnName()));
        }
        if (StringHelper.isNullOrEmpty((String)string2)) {
            throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u65b9\u6848[%1$s]\u6ca1\u6709\u6307\u5b9a\u7fa4\u7ec4\u6807\u8bc6", (Object)pSDevSln.getPSDevSlnName()));
        }
        PSSVNServer pSSVNServer = this.getPSSVNServer(string);
        PSDevCenterSVN pSDevCenterSVN = pSDevSlnSysDynaInst.getModelPSDevCenterSVN();
        if (pSDevCenterSVN == null || pSDevCenterSVN.getPSSVNInstRepo() == null) {
            throw new Exception("\u52a8\u6001\u5b9e\u4f8b\u6a21\u578b\u4ed3\u5e93\u65e0\u6548");
        }
        String string3 = pSDevCenterSVN.getPSSVNInstRepo().getRepoTag2();
        try {
            return this.listTags(pSSVNServer, string3);
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u67e5\u8be2\u52a8\u6001\u5b9e\u4f8b\u6807\u8bb0\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u52a8\u6001\u5b9e\u4f8b\u6807\u8bb0\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
    }

    @Override
    public Tag getTagByPSDevSlnSysDynaInstTag(PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag) throws Exception {
        PSDevSlnSysDynaInst pSDevSlnSysDynaInst = pSDevSlnSysDynaInstTag.getPSDevSlnSysDynaInst();
        if (pSDevSlnSysDynaInst == null) {
            throw new Exception(StringHelper.format((String)"\u52a8\u6001\u5b9e\u4f8b\u6807\u8bb0\u6ca1\u6709\u6307\u5b9a\u52a8\u6001\u5b9e\u4f8b"));
        }
        PSDevSln pSDevSln = pSDevSlnSysDynaInst.getPSDevSln();
        if (pSDevSln == null) {
            throw new Exception(StringHelper.format((String)"\u52a8\u6001\u5b9e\u4f8b\u6ca1\u6709\u6307\u5b9a\u5f00\u53d1\u65b9\u6848"));
        }
        String string = null;
        String string2 = null;
        if (pSDevSln.getPSDevCenterSVN() != null && pSDevSln.getPSDevCenterSVN().getPSSVNInstRepo() != null) {
            string = pSDevSln.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag();
            string2 = pSDevSln.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag2();
        } else {
            string = pSDevSln.getSlnTag();
            string2 = pSDevSln.getSlnTag2();
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u65b9\u6848[%1$s]\u6ca1\u6709\u6307\u5b9a\u7248\u672c\u4ed3\u5e93", (Object)pSDevSln.getPSDevSlnName()));
        }
        if (StringHelper.isNullOrEmpty((String)string2)) {
            throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u65b9\u6848[%1$s]\u6ca1\u6709\u6307\u5b9a\u7fa4\u7ec4\u6807\u8bc6", (Object)pSDevSln.getPSDevSlnName()));
        }
        PSSVNServer pSSVNServer = this.getPSSVNServer(string);
        PSDevCenterSVN pSDevCenterSVN = pSDevSlnSysDynaInst.getModelPSDevCenterSVN();
        if (pSDevCenterSVN == null || pSDevCenterSVN.getPSSVNInstRepo() == null) {
            throw new Exception("\u52a8\u6001\u5b9e\u4f8b\u6a21\u578b\u4ed3\u5e93\u65e0\u6548");
        }
        String string3 = pSDevCenterSVN.getPSSVNInstRepo().getRepoTag2();
        try {
            HashMap<String, Object> hashMap = new HashMap<String, Object>();
            String string4 = this.executeGet(pSSVNServer, String.format("projects/%1$s/repository/tags/%2$s", string3, pSDevSlnSysDynaInstTag.getPSDevSlnSysDynaInstTagName()), hashMap, null);
            Tag tag = this.jacksonJson.unmarshal(Tag.class, string4);
            if (tag == null || tag.getName() == null) {
                return null;
            }
            return tag;
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u52a8\u6001\u5b9e\u4f8b\u6807\u8bb0\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
            throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u52a8\u6001\u5b9e\u4f8b\u6807\u8bb0\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
    }

    @Override
    public Tag createTagByPSDevSlnSysDynaInstTag(PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag) throws Exception {
        PSDevSlnSysDynaInst pSDevSlnSysDynaInst = pSDevSlnSysDynaInstTag.getPSDevSlnSysDynaInst();
        if (pSDevSlnSysDynaInst == null) {
            throw new Exception(StringHelper.format((String)"\u52a8\u6001\u5b9e\u4f8b\u6807\u8bb0\u6ca1\u6709\u6307\u5b9a\u52a8\u6001\u5b9e\u4f8b"));
        }
        PSDevSln pSDevSln = pSDevSlnSysDynaInst.getPSDevSln();
        if (pSDevSln == null) {
            throw new Exception(StringHelper.format((String)"\u52a8\u6001\u5b9e\u4f8b\u6ca1\u6709\u6307\u5b9a\u5f00\u53d1\u65b9\u6848"));
        }
        String string = null;
        String string2 = null;
        if (pSDevSln.getPSDevCenterSVN() != null && pSDevSln.getPSDevCenterSVN().getPSSVNInstRepo() != null) {
            string = pSDevSln.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag();
            string2 = pSDevSln.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag2();
        } else {
            string = pSDevSln.getSlnTag();
            string2 = pSDevSln.getSlnTag2();
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u65b9\u6848[%1$s]\u6ca1\u6709\u6307\u5b9a\u7248\u672c\u4ed3\u5e93", (Object)pSDevSln.getPSDevSlnName()));
        }
        if (StringHelper.isNullOrEmpty((String)string2)) {
            throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u65b9\u6848[%1$s]\u6ca1\u6709\u6307\u5b9a\u7fa4\u7ec4\u6807\u8bc6", (Object)pSDevSln.getPSDevSlnName()));
        }
        PSSVNServer pSSVNServer = this.getPSSVNServer(string);
        PSDevCenterSVN pSDevCenterSVN = pSDevSlnSysDynaInst.getModelPSDevCenterSVN();
        if (pSDevCenterSVN == null || pSDevCenterSVN.getPSSVNInstRepo() == null) {
            throw new Exception("\u52a8\u6001\u5b9e\u4f8b\u6a21\u578b\u4ed3\u5e93\u65e0\u6548");
        }
        String string3 = pSDevCenterSVN.getPSSVNInstRepo().getRepoTag2();
        Tag[] tagArray = this.listTags(pSSVNServer, string3);
        if (tagArray != null && tagArray.length > 0) {
            for (Tag tag : tagArray) {
                if (StringHelper.compare((String)tag.getName(), (String)pSDevSlnSysDynaInstTag.getPSDevSlnSysDynaInstTagName(), (boolean)true) != 0) continue;
                throw new Exception(StringHelper.format((String)"\u52a8\u6001\u5b9e\u4f8b\u6807\u8bb0[%1$s]\u5df2\u5b58\u5728", (Object)pSDevSlnSysDynaInstTag.getPSDevSlnSysDynaInstTagName()));
            }
        }
        Tag[] tagArray2 = new HashMap();
        tagArray2.put("tag_name", pSDevSlnSysDynaInstTag.getPSDevSlnSysDynaInstTagName());
        tagArray2.put("ref", "master");
        if (!StringHelper.isNullOrEmpty((String)pSDevSlnSysDynaInstTag.getMemo())) {
            tagArray2.put("message", pSDevSlnSysDynaInstTag.getMemo());
        }
        String string4 = null;
        try {
            string4 = this.executePost(pSSVNServer, String.format("projects/%1$s/repository/tags", string3), (Map<String, Object>)tagArray2, this.getCurUserName(pSDevSln.getPSDevCenter()), null);
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u5efa\u7acb\u52a8\u6001\u5b9e\u4f8b\u6807\u8bb0\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
            throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u52a8\u6001\u5b9e\u4f8b\u6807\u8bb0\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
        Tag tag = this.jacksonJson.unmarshal(Tag.class, string4);
        return tag;
    }

    @Override
    public Tag updateTagByPSDevSlnSysDynaInstTag(PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag) throws Exception {
        return null;
    }

    @Override
    public void removeTagByPSDevSlnSysDynaInstTag(PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag) throws Exception {
        PSDevSlnSysDynaInst pSDevSlnSysDynaInst = pSDevSlnSysDynaInstTag.getPSDevSlnSysDynaInst();
        if (pSDevSlnSysDynaInst == null) {
            throw new Exception(StringHelper.format((String)"\u52a8\u6001\u5b9e\u4f8b\u6807\u8bb0\u6ca1\u6709\u6307\u5b9a\u52a8\u6001\u5b9e\u4f8b"));
        }
        PSDevSln pSDevSln = pSDevSlnSysDynaInst.getPSDevSln();
        if (pSDevSln == null) {
            throw new Exception(StringHelper.format((String)"\u52a8\u6001\u5b9e\u4f8b\u6ca1\u6709\u6307\u5b9a\u5f00\u53d1\u65b9\u6848"));
        }
        String string = null;
        String string2 = null;
        if (pSDevSln.getPSDevCenterSVN() != null && pSDevSln.getPSDevCenterSVN().getPSSVNInstRepo() != null) {
            string = pSDevSln.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag();
            string2 = pSDevSln.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag2();
        } else {
            string = pSDevSln.getSlnTag();
            string2 = pSDevSln.getSlnTag2();
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u65b9\u6848[%1$s]\u6ca1\u6709\u6307\u5b9a\u7248\u672c\u4ed3\u5e93", (Object)pSDevSln.getPSDevSlnName()));
        }
        if (StringHelper.isNullOrEmpty((String)string2)) {
            throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u65b9\u6848[%1$s]\u6ca1\u6709\u6307\u5b9a\u7fa4\u7ec4\u6807\u8bc6", (Object)pSDevSln.getPSDevSlnName()));
        }
        PSSVNServer pSSVNServer = this.getPSSVNServer(string);
        PSDevCenterSVN pSDevCenterSVN = pSDevSlnSysDynaInst.getModelPSDevCenterSVN();
        if (pSDevCenterSVN == null || pSDevCenterSVN.getPSSVNInstRepo() == null) {
            throw new Exception("\u52a8\u6001\u5b9e\u4f8b\u6a21\u578b\u4ed3\u5e93\u65e0\u6548");
        }
        String string3 = pSDevCenterSVN.getPSSVNInstRepo().getRepoTag2();
        try {
            HashMap<String, Object> hashMap = new HashMap<String, Object>();
            String string4 = this.executeDelete(pSSVNServer, String.format("projects/%1$s/repository/tags/%2$s", string3, pSDevSlnSysDynaInstTag.getPSDevSlnSysDynaInstTagName()), hashMap, this.getCurUserName(pSDevSln.getPSDevCenter()), null);
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u5220\u9664\u52a8\u6001\u5b9e\u4f8b\u6807\u8bb0\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
            throw new Exception(StringHelper.format((String)"\u5220\u9664\u52a8\u6001\u5b9e\u4f8b\u6807\u8bb0\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
    }

    @Override
    public void revertTagByPSDevSlnSysDynaInstTag(PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag) throws Exception {
        Object object;
        Object object2;
        PSDevSlnSysDynaInst pSDevSlnSysDynaInst = pSDevSlnSysDynaInstTag.getPSDevSlnSysDynaInst();
        if (pSDevSlnSysDynaInst == null) {
            throw new Exception(StringHelper.format((String)"\u52a8\u6001\u5b9e\u4f8b\u6807\u8bb0\u6ca1\u6709\u6307\u5b9a\u52a8\u6001\u5b9e\u4f8b"));
        }
        PSDevSln pSDevSln = pSDevSlnSysDynaInst.getPSDevSln();
        if (pSDevSln == null) {
            throw new Exception(StringHelper.format((String)"\u52a8\u6001\u5b9e\u4f8b\u6ca1\u6709\u6307\u5b9a\u5f00\u53d1\u65b9\u6848"));
        }
        String string = null;
        String string2 = null;
        if (pSDevSln.getPSDevCenterSVN() != null && pSDevSln.getPSDevCenterSVN().getPSSVNInstRepo() != null) {
            string = pSDevSln.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag();
            string2 = pSDevSln.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag2();
        } else {
            string = pSDevSln.getSlnTag();
            string2 = pSDevSln.getSlnTag2();
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u65b9\u6848[%1$s]\u6ca1\u6709\u6307\u5b9a\u7248\u672c\u4ed3\u5e93", (Object)pSDevSln.getPSDevSlnName()));
        }
        if (StringHelper.isNullOrEmpty((String)string2)) {
            throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u65b9\u6848[%1$s]\u6ca1\u6709\u6307\u5b9a\u7fa4\u7ec4\u6807\u8bc6", (Object)pSDevSln.getPSDevSlnName()));
        }
        PSSVNServer pSSVNServer = this.getPSSVNServer(string);
        PSDevCenterSVN pSDevCenterSVN = pSDevSlnSysDynaInst.getModelPSDevCenterSVN();
        if (pSDevCenterSVN == null || pSDevCenterSVN.getPSSVNInstRepo() == null) {
            throw new Exception("\u52a8\u6001\u5b9e\u4f8b\u6a21\u578b\u4ed3\u5e93\u65e0\u6548");
        }
        String string3 = pSDevCenterSVN.getPSSVNInstRepo().getRepoTag2();
        Tag tag = null;
        try {
            object2 = new HashMap<String, Object>();
            object = this.executeGet(pSSVNServer, String.format("projects/%1$s/repository/tags/%2$s", string3, pSDevSlnSysDynaInstTag.getPSDevSlnSysDynaInstTagName()), (Map<String, Object>)object2, null);
            tag = this.jacksonJson.unmarshal(Tag.class, (String)object);
            if (tag == null || tag.getCommit() == null || StringHelper.isNullOrEmpty((String)tag.getCommit().getId())) {
                throw new Exception("\u6307\u5b9a\u6807\u8bb0\u65e0\u6548");
            }
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u53cd\u505a\u52a8\u6001\u5b9e\u4f8b\u6807\u8bb0\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
            throw new Exception(StringHelper.format((String)"\u53cd\u505a\u52a8\u6001\u5b9e\u4f8b\u6807\u8bb0\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
        object2 = null;
        try {
            object = new HashMap();
            object.put("branch", "master");
            object2 = this.executePost(pSSVNServer, String.format("projects/%1$s/repository/commits/%2$s/revert", string3, tag.getCommit().getId()), (Map<String, Object>)object, this.getCurUserName(pSDevSln.getPSDevCenter()), null);
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u53cd\u505a\u52a8\u6001\u5b9e\u4f8b\u6807\u8bb0\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
            throw new Exception(StringHelper.format((String)"\u53cd\u505a\u52a8\u6001\u5b9e\u4f8b\u6807\u8bb0\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
    }

    @Override
    public WikiPage getWikiPage(PSDevSlnSys pSDevSlnSys, String string, boolean bl) throws Exception {
        if (pSDevSlnSys.getPSDevCenterSVN() == null || pSDevSlnSys.getPSDevCenterSVN().getPSSVNInstRepo() == null) {
            if (bl) {
                return null;
            }
            throw new Exception("\u5f00\u53d1\u7cfb\u7edf\u4ee3\u7801\u4ed3\u5e93\u65e0\u6548");
        }
        String string2 = pSDevSlnSys.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag2();
        if (StringHelper.isNullOrEmpty((String)string2)) {
            if (bl) {
                return null;
            }
            throw new Exception("\u5f00\u53d1\u7cfb\u7edf\u4ee3\u7801\u4ed3\u5e93\u6807\u8bc6\u65e0\u6548");
        }
        String string3 = pSDevSlnSys.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag();
        if (StringHelper.isNullOrEmpty((String)string3)) {
            if (bl) {
                return null;
            }
            throw new Exception("\u5f00\u53d1\u7cfb\u7edf\u4ee3\u7801\u4ed3\u5e93\u65e0\u6548");
        }
        PSSVNServer pSSVNServer = this.getPSSVNServer(string3);
        WikiPage wikiPage = null;
        try {
            HashMap<String, Object> hashMap = new HashMap<String, Object>();
            String string4 = this.executeGet(pSSVNServer, String.format("projects/%1$s/wikis/%2$s", string2, URLEncoder.encode(string, "UTF-8")), hashMap, null, null);
            wikiPage = this.jacksonJson.unmarshal(WikiPage.class, string4);
            if (wikiPage == null) {
                throw new Exception("\u6307\u5b9aWiki\u8def\u5f84\u65e0\u6548");
            }
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9aWiki\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
            if (bl) {
                return null;
            }
            throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9aWiki\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
        return wikiPage;
    }

    @Override
    public void updateWikiPage(PSDevSlnSys pSDevSlnSys, String string, String string2, String string3, boolean bl) throws Exception {
        String string4;
        HashMap<String, Object> hashMap;
        if (pSDevSlnSys.getPSDevCenterSVN() == null || pSDevSlnSys.getPSDevCenterSVN().getPSSVNInstRepo() == null) {
            if (bl) {
                return;
            }
            throw new Exception("\u5f00\u53d1\u7cfb\u7edf\u4ee3\u7801\u4ed3\u5e93\u65e0\u6548");
        }
        String string5 = pSDevSlnSys.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag2();
        if (StringHelper.isNullOrEmpty((String)string5)) {
            if (bl) {
                return;
            }
            throw new Exception("\u5f00\u53d1\u7cfb\u7edf\u4ee3\u7801\u4ed3\u5e93\u6807\u8bc6\u65e0\u6548");
        }
        String string6 = pSDevSlnSys.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag();
        if (StringHelper.isNullOrEmpty((String)string6)) {
            if (bl) {
                return;
            }
            throw new Exception("\u5f00\u53d1\u7cfb\u7edf\u4ee3\u7801\u4ed3\u5e93\u65e0\u6548");
        }
        PSSVNServer pSSVNServer = this.getPSSVNServer(string6);
        PSDevCenter pSDevCenter = pSDevSlnSys.getPSDevSln().getPSDevCenter();
        WikiPage wikiPage = null;
        try {
            hashMap = new HashMap<String, Object>();
            string4 = this.executeGet(pSSVNServer, String.format("projects/%1$s/wikis/%2$s", string5, URLEncoder.encode(string, "UTF-8")), hashMap, null, null);
            wikiPage = this.jacksonJson.unmarshal(WikiPage.class, string4);
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9aWiki\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
        }
        try {
            hashMap = new HashMap();
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                hashMap.put("title", string2);
            }
            if (!StringHelper.isNullOrEmpty((String)string3)) {
                hashMap.put("content", string3);
            }
            if (wikiPage == null) {
                hashMap.put("title", string);
                string4 = this.executePost(pSSVNServer, String.format("projects/%1$s/wikis", string5), hashMap, this.getCurUserName(pSDevCenter), null);
                wikiPage = this.jacksonJson.unmarshal(WikiPage.class, string4);
            } else {
                hashMap.put("title", string);
                string4 = this.executePut(pSSVNServer, String.format("projects/%1$s/wikis/%2$s", string5, URLEncoder.encode(string, "UTF-8")), hashMap, this.getCurUserName(pSDevCenter), null);
                wikiPage = this.jacksonJson.unmarshal(WikiPage.class, string4);
            }
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u66f4\u65b0\u6307\u5b9aWiki\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
            if (bl) {
                return;
            }
            throw new Exception(StringHelper.format((String)"\u66f4\u65b0\u6307\u5b9aWiki\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
    }
}

