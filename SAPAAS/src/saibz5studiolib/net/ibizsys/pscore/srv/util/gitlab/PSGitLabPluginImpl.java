package net.ibizsys.pscore.srv.util.gitlab;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Random;
import net.ibizsys.paas.data.DataObject;
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
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnUser;
import net.ibizsys.pscore.srv.util.PSCoreEntityKeeperGlobal;
import net.ibizsys.pscore.srv.util.PSDevCenterHelper;
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

public class PSGitLabPluginImpl extends PSGitLabPluginImplBase {
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

   protected PSSVNServer getPSSVNServer(String var1) throws Exception {
      return PSCoreEntityKeeperGlobal.getCurrent(PSCoreSysServiceBase.getCurMajorSessionFactory()).getPSSVNServer(var1);
   }

   @Override
   public User createUserByPSDevUser(PSDevUser var1) throws Exception {
      if (var1.getPSDevCenter() == null) {
         throw new Exception(StringHelper.format("传入开发用户应用中心无效"));
      }

      if (var1.getPSDevCenter().getV6PSSvnInstRepo() == null) {
         throw new Exception(StringHelper.format("传入开发用户应用中心版本仓库无效"));
      }

      PSSVNServer var2 = this.getPSSVNServer(var1.getPSDevCenter().getV6PSSvnInstRepo().getPSSVNServerId());
      return this.createUserByPSDevUser(var2, var1, null, false);
   }

   protected User createUserByPSDevUser(PSSVNServer var1, PSDevUser var2, String var3, boolean var4) throws Exception {
      if (StringHelper.isNullOrEmpty(var3)) {
         var3 = this.getUserNameByPSDevUser(var2);
      }

      User var5 = null;

      try {
         var5 = this.getUser(var1, var3);
      } catch (Exception var10) {
         log.error(StringHelper.format("获取仓库服务器用户发生异常，%1$s", var10.getMessage()), var10);
         throw new Exception(StringHelper.format("获取仓库服务器用户发生异常，%1$s", var10.getMessage()), var10);
      }

      if (var5 != null) {
         if (var4) {
            return var5;
         } else {
            throw new Exception(StringHelper.format("仓库服务器已存在指定用户[%1$s]", var3));
         }
      } else {
         HashMap var6 = new HashMap();
         var6.put("username", var3);
         var6.put("name", var2.getPSDevUserName());
         var6.put("email", var3 + "@ibizlab.cn");
         var6.put("password", "w1" + KeyValueHelper.genUniqueId(var2.getPSDevUserId()).substring(0, 10).toUpperCase());
         if (!StringHelper.isNullOrEmpty(var1.getUserTag())) {
            var6.put("provider", "ldap");
            var6.put("extern_uid", StringHelper.format(var1.getUserTag(), var3));
         }

         var6.put("skip_confirmation", "true");
         String var7 = null;

         try {
            var7 = this.executePost(var1, "users", var6, null, null);
         } catch (Exception var9) {
            log.error(StringHelper.format("建立用户发生异常，%1$s", var9.getMessage()), var9);
            throw new Exception(StringHelper.format("建立用户发生异常，%1$s", var9.getMessage()), var9);
         }

         return this.jacksonJson.unmarshal(User.class, var7);
      }
   }

   @Override
   public Group createGroupByPSDevSln(PSDevSln var1) throws Exception {
      HashMap var2 = new HashMap();
      String var3 = var1.getCodeName();
      String var4 = var1.getPSDevSlnName();
      if (PSDevCenterHelper.isLabDC(var1.getPSDevCenter())) {
         String var5 = var1.getPSDevCenter().getDCTag4();
         if (StringHelper.isNullOrEmpty(var5) || !var5.contentEquals("PRO")) {
            var3 = "t" + KeyValueHelper.genUniqueId(var3, Long.toString(random.nextLong()), Long.toString(System.currentTimeMillis()));
         }
      }

      var2.put("path", var3);
      var2.put("name", var4);
      String var12 = null;
      PSSVNServer var6 = this.getPSSVNServer(var1.getSlnTag());
      User var7 = null;

      try {
         if (!StringHelper.isNullOrEmpty(var6.getGITUserName())) {
            var7 = this.getUser(var6, var6.getGITUserName());
            if (var7 == null) {
               throw new Exception(StringHelper.format("无法获取代码提交用户账户"));
            }
         }

         var12 = this.executePost(var6, "groups", var2, this.getCurUserName(var1.getPSDevCenter()), null);
      } catch (Exception var11) {
         log.error(StringHelper.format("建立开发方案群组发生异常，%1$s", var11.getMessage()), var11);
         throw new Exception(StringHelper.format("建立开发方案群组发生异常，%1$s", var11.getMessage()), var11);
      }

      Group var8 = this.jacksonJson.unmarshal(Group.class, var12);
      var1.setSlnTag2(Integer.toString(var8.getId()));
      if (var7 != null && !PSDevCenterHelper.isRecycleDC(var1.getPSDevCenter()) && !PSCoreSysServiceBase.isCloudMode()) {
         var2.clear();
         var2.put("user_id", Integer.toString(var7.getId()));
         var2.put("access_level", Integer.toString(40));

         try {
            var12 = this.executePost(var6, StringHelper.format("groups/%1$s/members", var8.getId()), var2, this.getCurUserName(var1.getPSDevCenter()), null);
         } catch (Exception var10) {
            log.error(StringHelper.format("建立群组成员发生异常，%1$s", var10.getMessage()), var10);
            throw new Exception(StringHelper.format("建立群组成员发生异常，%1$s", var10.getMessage()), var10);
         }
      }

      return var8;
   }

   protected Group createSubGroupByPSDevSlnSysDynaInst(PSDevSln var1, PSDevSlnSysDynaInst var2) throws Exception {
      HashMap var3 = new HashMap();
      String var4 = "DynaInst"
         + KeyValueHelper.genUniqueId(var2.getPSDevSlnSysDynaInstId(), Long.toString(random.nextLong()), Long.toString(System.currentTimeMillis()));
      String var5 = var2.getPSDevSlnSysDynaInstName();
      var3.put("path", var4);
      var3.put("name", var5);
      var3.put("parent_id", var1.getSlnTag2());
      String var6 = null;
      PSSVNServer var7 = this.getPSSVNServer(var1.getSlnTag());
      User var8 = null;

      try {
         if (!StringHelper.isNullOrEmpty(var7.getGITUserName())) {
            var8 = this.getUser(var7, var7.getGITUserName());
            if (var8 == null) {
               throw new Exception(StringHelper.format("无法获取代码提交用户账户"));
            }
         }

         var6 = this.executePost(var7, "groups", var3, this.getCurUserName(var1.getPSDevCenter()), null);
      } catch (Exception var12) {
         log.error(StringHelper.format("建立动态实例子群组发生异常，%1$s", var12.getMessage()), var12);
         throw new Exception(StringHelper.format("建立动态实例子群组发生异常，%1$s", var12.getMessage()), var12);
      }

      Group var9 = this.jacksonJson.unmarshal(Group.class, var6);
      var2.setInstTag3(Integer.toString(var9.getId()));
      if (var8 != null && !PSDevCenterHelper.isRecycleDC(var1.getPSDevCenter())) {
         var3.clear();
         var3.put("user_id", Integer.toString(var8.getId()));
         var3.put("access_level", Integer.toString(40));

         try {
            var6 = this.executePost(var7, StringHelper.format("groups/%1$s/members", var9.getId()), var3, this.getCurUserName(var1.getPSDevCenter()), null);
         } catch (Exception var11) {
            log.error(StringHelper.format("建立群组成员发生异常，%1$s", var11.getMessage()), var11);
            throw new Exception(StringHelper.format("建立群组成员发生异常，%1$s", var11.getMessage()), var11);
         }
      }

      return var9;
   }

   @Override
   public Project createCodeProjectByPSDevSlnSys(PSDevSlnSys var1) throws Exception {
      return this.createProjectByPSDevSlnSys(var1, true);
   }

   @Override
   public Project createModelProjectByPSDevSlnSys(PSDevSlnSys var1) throws Exception {
      return this.createProjectByPSDevSlnSys(var1, false);
   }

   @Override
   public Project createRuntimeProjectByPSDevSlnSys(PSDevSlnSys var1) throws Exception {
      return this.createProjectByPSDevSlnSys(var1, 2);
   }

   @Override
   public Project createDocProjectByPSDevSlnSys(PSDevSlnSys var1) throws Exception {
      return this.createProjectByPSDevSlnSys(var1, 3);
   }

   protected Project createProjectByPSDevSlnSys(PSDevSlnSys var1, boolean var2) throws Exception {
      return this.createProjectByPSDevSlnSys(var1, var2 ? 1 : 0);
   }

   protected Project createProjectByPSDevSlnSys(PSDevSlnSys var1, int var2) throws Exception {
      PSDevSln var3 = var1.getPSDevSln();
      if (var3 == null) {
         throw new Exception(StringHelper.format("开发系统没有指定开发方案"));
      }

      String var4 = null;
      String var5 = null;
      if (var3.getPSDevCenterSVN() != null && var3.getPSDevCenterSVN().getPSSVNInstRepo() != null) {
         var4 = var3.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag();
         var5 = var3.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag2();
      } else {
         var4 = var3.getSlnTag();
         var5 = var3.getSlnTag2();
      }

      if (StringHelper.isNullOrEmpty(var4)) {
         throw new Exception(StringHelper.format("开发方案[%1$s]没有指定版本仓库", var3.getPSDevSlnName()));
      }

      if (StringHelper.isNullOrEmpty(var5)) {
         throw new Exception(StringHelper.format("开发方案[%1$s]没有指定群组标识", var3.getPSDevSlnName()));
      }

      PSSVNServer var6 = this.getPSSVNServer(var4);
      Namespace var7 = this.getNamespace(var6, var5);
      if (PSCoreSysServiceBase.isEnableGitBranch()) {
         PSDevSlnSys var8 = var1.getPPSDevSlnSys();
         if (var8 == null) {
            var8 = var1.getMainPSDevSlnSys();
         }

         if (var8 != null) {
            PSDevCenterSVN var22 = null;
            switch (var2) {
               case 0:
                  var22 = var8.getModelPSDevCenterSVN();
                  break;
               case 1:
                  var22 = var8.getPSDevCenterSVN();
                  break;
               case 2:
                  var22 = var8.getRTModelPSDevCenterSVN();
                  break;
               case 3:
                  var22 = var8.getDocPSDevCenterSVN();
            }

            PSSVNInstRepo var23 = null;
            if (var22 != null) {
               var23 = var22.getPSSVNInstRepo();
            }

            if (var23 == null) {
               throw new Exception(String.format("无法获取父系统[%1$s]相关仓库", var1.getPPSDevSlnSys().getPSDevSlnSysName()));
            }

            HashMap var24 = new HashMap();
            var24.put("branch", var1.getPSDevSlnSysName().toLowerCase());
            String var27 = var23.getGitBranch();
            if (StringHelper.isNullOrEmpty(var27)) {
               var27 = "master";
            }

            var24.put("branch", var1.getPSDevSlnSysName().toLowerCase());
            var24.put("ref", var27);
            String var31 = null;
            String var34 = var23.getRepoTag2();

            try {
               var31 = this.executePost(
                  var6, StringHelper.format("projects/%1$s/repository/branches", var34), var24, this.getCurUserName(var3.getPSDevCenter()), null
               );
            } catch (Exception var17) {
               log.error(StringHelper.format("建立项目分支发生异常，%1$s", var17.getMessage()), var17);
               throw new Exception(StringHelper.format("建立项目分支发生异常，%1$s", var17.getMessage()), var17);
            }

            Branch var36 = this.jacksonJson.unmarshal(Branch.class, var31);
            Project var16 = new Project();
            var16.setId(Integer.valueOf(var34));
            var16.setDefaultBranch(var1.getPSDevSlnSysName().toLowerCase());
            var16.setHttpUrlToRepo(var23.getGitPath());
            var16.setPath(var23.getPSSVNInstRepoName());
            return var16;
         }
      }

      HashMap var21 = new HashMap();
      String var9 = var1.getPSDevSlnSysName();
      String var10 = var1.getLogicName();
      if (StringHelper.isNullOrEmpty(var10)) {
         var10 = var9;
      }

      if (var2 == 0) {
         var9 = StringHelper.format(StringHelper.format("%1$s_model", var9));
         var10 = StringHelper.format(StringHelper.format("%1$s模型", var10));
      } else if (var2 == 2) {
         var9 = StringHelper.format(StringHelper.format("%1$s_runtime", var9));
         var10 = StringHelper.format(StringHelper.format("%1$s运行时", var10));
      } else if (var2 == 3) {
         var9 = StringHelper.format(StringHelper.format("%1$s_document", var9));
         var10 = StringHelper.format(StringHelper.format("%1$s文档", var10));
      }

      Project[] var11 = this.listProjectsByPSDevSln(var6, var7);
      if (var11 != null && var11.length > 0) {
         for (Project var15 : var11) {
            if (StringHelper.compare(var15.getPath(), var9, true) == 0) {
               throw new Exception(StringHelper.format("仓库项目路径[%1$s]已存在", var9));
            }
         }

         for (Project var35 : var11) {
            if (StringHelper.compare(var35.getName(), var10, true) == 0) {
               var10 = null;
               break;
            }
         }
      }

      var21.put("path", var9);
      if (!StringHelper.isNullOrEmpty(var10)) {
         var21.put("name", var10);
      }

      var21.put("namespace_id", Integer.toString(var7.getId()));
      Object var26 = var1.get("importurl");
      if (!StringHelper.isNullOrEmpty(var26)) {
         var21.put("import_url", var26);
      } else {
         var21.put("import_url", "");
         var21.put("initialize_with_readme", "true");
      }

      var21.put("description", "");
      var21.put("issues_enabled", "true");
      var21.put("merge_requests_enabled", "true");
      var21.put("wiki_enabled", "true");
      var21.put("snippets_enabled", "true");
      var21.put("visibility_level", "20");
      String var29 = null;

      try {
         var29 = this.executePost(var6, "projects", var21, this.getCurUserName(var3.getPSDevCenter()), null);
      } catch (Exception var18) {
         log.error(StringHelper.format("建立开发系统项目发生异常，%1$s", var18.getMessage()), var18);
         throw new Exception(StringHelper.format("建立开发系统项目发生异常，%1$s", var18.getMessage()), var18);
      }

      return this.jacksonJson.unmarshal(Project.class, var29);
   }

   @Override
   public Project createProjectByPSDevSlnTempl(PSDevSlnTempl var1) throws Exception {
      PSDevSln var2 = var1.getPSDevSln();
      if (var2 == null) {
         throw new Exception(StringHelper.format("开发模板没有指定开发方案"));
      }

      String var3 = null;
      String var4 = null;
      if (var2.getPSDevCenterSVN() != null && var2.getPSDevCenterSVN().getPSSVNInstRepo() != null) {
         var3 = var2.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag();
         var4 = var2.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag2();
      } else {
         var3 = var2.getSlnTag();
         var4 = var2.getSlnTag2();
      }

      if (StringHelper.isNullOrEmpty(var3)) {
         throw new Exception(StringHelper.format("开发方案[%1$s]没有指定版本仓库", var2.getPSDevSlnName()));
      }

      if (StringHelper.isNullOrEmpty(var4)) {
         throw new Exception(StringHelper.format("开发方案[%1$s]没有指定群组标识", var2.getPSDevSlnName()));
      }

      PSSVNServer var5 = this.getPSSVNServer(var3);
      Namespace var6 = this.getNamespace(var5, var4);
      HashMap var7 = new HashMap();
      String var8 = var1.getPSDevSlnTemplName();
      String var9 = var1.getLogicName();
      if (StringHelper.isNullOrEmpty(var9)) {
         var9 = var8;
      }

      Project[] var10 = this.listProjectsByPSDevSln(var5, var6);
      if (var10 != null && var10.length > 0) {
         for (Project var14 : var10) {
            if (StringHelper.compare(var14.getPath(), var8, true) == 0) {
               throw new Exception(StringHelper.format("仓库项目路径[%1$s]已存在", var8));
            }
         }

         for (Project var23 : var10) {
            if (StringHelper.compare(var23.getName(), var9, true) == 0) {
               var9 = null;
               break;
            }
         }
      }

      var7.put("path", var8);
      if (!StringHelper.isNullOrEmpty(var9)) {
         var7.put("name", var9);
      }

      var7.put("namespace_id", Integer.toString(var6.getId()));
      var7.put("import_url", "");
      var7.put("description", "");
      var7.put("issues_enabled", "true");
      var7.put("merge_requests_enabled", "true");
      var7.put("wiki_enabled", "true");
      var7.put("snippets_enabled", "true");
      var7.put("visibility_level", "20");
      var7.put("initialize_with_readme", "true");
      String var19 = null;

      try {
         var19 = this.executePost(var5, "projects", var7, this.getCurUserName(var2.getPSDevCenter()), null);
      } catch (Exception var15) {
         log.error(StringHelper.format("建立开发模板项目发生异常，%1$s", var15.getMessage()), var15);
         throw new Exception(StringHelper.format("建立开发模板项目发生异常，%1$s", var15.getMessage()), var15);
      }

      return this.jacksonJson.unmarshal(Project.class, var19);
   }

   @Override
   public Project[] listProjectsByPSDevSln(PSDevSln var1) throws Exception {
      String var2 = null;
      String var3 = null;
      if (var1.getPSDevCenterSVN() != null && var1.getPSDevCenterSVN().getPSSVNInstRepo() != null) {
         var2 = var1.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag();
         var3 = var1.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag2();
      } else {
         var2 = var1.getSlnTag();
         var3 = var1.getSlnTag2();
      }

      if (StringHelper.isNullOrEmpty(var2)) {
         throw new Exception(StringHelper.format("开发方案[%1$s]没有指定版本仓库", var1.getPSDevSlnName()));
      }

      if (StringHelper.isNullOrEmpty(var3)) {
         throw new Exception(StringHelper.format("开发方案[%1$s]没有指定群组标识", var1.getPSDevSlnName()));
      }

      PSSVNServer var4 = this.getPSSVNServer(var2);
      Namespace var5 = this.getNamespace(var4, var3);

      try {
         return this.listProjectsByPSDevSln(var4, var5);
      } catch (Exception var7) {
         log.error(StringHelper.format("查询群组项目发生异常，%1$s", var7.getMessage()), var7);
         throw new Exception(StringHelper.format("查询群组项目发生异常，%1$s", var7.getMessage()), var7);
      }
   }

   @Override
   public Member createMemberByPSDevSlnUser(PSDevSlnUser var1) throws Exception {
      return this.dealMemberByPSDevSlnUser(var1, 1);
   }

   @Override
   public Member updateMemberByPSDevSlnUser(PSDevSlnUser var1) throws Exception {
      return this.dealMemberByPSDevSlnUser(var1, 2);
   }

   @Override
   public void removeMemberByPSDevSlnUser(PSDevSlnUser var1) throws Exception {
      this.dealMemberByPSDevSlnUser(var1, 3);
   }

   protected Member dealMemberByPSDevSlnUser(PSDevSlnUser var1, int var2) throws Exception {
      if (var1.getAllSysFlag() == null) {
         throw new Exception("传入开发方案成员不正确");
      }

      PSDevUser var3 = null;
      if (StringHelper.compare(var1.getDevUserObjType(), "USER", false) == 0) {
         PSDevUserService var4 = (PSDevUserService)ServiceGlobal.getService(PSDevUserService.class, PSCoreSysServiceBase.getCurMajorSessionFactory());
         var3 = new PSDevUser();
         var3.setPSDevUserId(var1.getPSDevUserObjId());
         if (!var4.get(var3, true)) {
            var3 = null;
         }
      }

      if (var3 == null) {
         log.error(StringHelper.format("传入开发方案成员不正确，[%1$s|%2$s]开发用户无效", var1.getPSDevUserObjId(), var1.getPSDevUserObjName()));
         throw new Exception(StringHelper.format("传入开发方案成员不正确，[%1$s]开发用户无效", var1.getPSDevUserObjName()));
      }

      String var18 = this.getUserNameByPSDevUser(var3);
      if (StringHelper.isNullOrEmpty(var18)) {
         throw new Exception(StringHelper.format("传入开发方案成员不正确，[%1$s]用户名称无效", var3.getPSDevUserName()));
      }

      boolean var5 = false;
      String var6 = "";
      String var7 = "";
      String var8 = "";
      String var9 = "";
      String var10 = "";
      switch (var1.getAllSysFlag()) {
         case 0:
            if (var1.getPSDevSlnSys() == null
               || var1.getPSDevSlnSys().getPSDevCenterSVN() == null
               || var1.getPSDevSlnSys().getPSDevCenterSVN().getPSSVNInstRepo() == null) {
               throw new Exception("传入开发方案成员不正确，开发系统代码仓库无效");
            }

            var7 = var1.getPSDevSlnSys().getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag2();
            if (StringHelper.isNullOrEmpty(var7)) {
               throw new Exception("传入开发方案成员不正确，开发系统代码仓库标识无效");
            }

            if (var1.getPSDevSlnSys() == null
               || var1.getPSDevSlnSys().getModelPSDevCenterSVN() == null
               || var1.getPSDevSlnSys().getModelPSDevCenterSVN().getPSSVNInstRepo() == null) {
               throw new Exception("传入开发方案成员不正确，开发系统模型仓库无效");
            }

            var8 = var1.getPSDevSlnSys().getModelPSDevCenterSVN().getPSSVNInstRepo().getRepoTag2();
            if (StringHelper.isNullOrEmpty(var8)) {
               throw new Exception("传入开发方案成员不正确，开发系统模型仓库标识无效");
            }

            if (var1.getPSDevSlnSys().getRTModelPSDevCenterSVN() != null && var1.getPSDevSlnSys().getRTModelPSDevCenterSVN().getPSSVNInstRepo() != null) {
               var9 = var1.getPSDevSlnSys().getRTModelPSDevCenterSVN().getPSSVNInstRepo().getRepoTag2();
            }

            if (var1.getPSDevSlnSys().getDocPSDevCenterSVN() != null && var1.getPSDevSlnSys().getDocPSDevCenterSVN().getPSSVNInstRepo() != null) {
               var10 = var1.getPSDevSlnSys().getDocPSDevCenterSVN().getPSSVNInstRepo().getRepoTag2();
            }
         case 1:
         default:
            break;
         case 2:
            if (var1.getPSDevSlnTempl() == null
               || var1.getPSDevSlnTempl().getPSDevCenterSVN() == null
               || var1.getPSDevSlnTempl().getPSDevCenterSVN().getPSSVNInstRepo() == null) {
               throw new Exception("传入开发方案成员不正确，开发模板无效");
            }

            var7 = var1.getPSDevSlnTempl().getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag2();
            if (StringHelper.isNullOrEmpty(var7)) {
               throw new Exception("传入开发方案成员不正确，开发模板仓库标识无效");
            }
            break;
         case 3:
            if (var1.getPSDevSlnSysDynaInst() == null
               || var1.getPSDevSlnSysDynaInst().getCfgPSDevCenterSVN() == null
               || var1.getPSDevSlnSysDynaInst().getCfgPSDevCenterSVN().getPSSVNInstRepo() == null) {
               throw new Exception("传入开发方案成员不正确，动态实例配置仓库无效");
            }

            var7 = var1.getPSDevSlnSysDynaInst().getCfgPSDevCenterSVN().getPSSVNInstRepo().getRepoTag2();
            if (StringHelper.isNullOrEmpty(var7)) {
               throw new Exception("传入开发方案成员不正确，动态实例配置仓库标识无效");
            }

            if (var1.getPSDevSlnSysDynaInst() == null
               || var1.getPSDevSlnSysDynaInst().getModelPSDevCenterSVN() == null
               || var1.getPSDevSlnSysDynaInst().getModelPSDevCenterSVN().getPSSVNInstRepo() == null) {
               throw new Exception("传入开发方案成员不正确，动态实例模型仓库无效");
            }

            var8 = var1.getPSDevSlnSysDynaInst().getModelPSDevCenterSVN().getPSSVNInstRepo().getRepoTag2();
            if (StringHelper.isNullOrEmpty(var8)) {
               throw new Exception("传入开发方案成员不正确，动态实例模型仓库标识无效");
            }

            var6 = var1.getPSDevSlnSysDynaInst().getInstTag3();
            if (StringHelper.isNullOrEmpty(var6)) {
               if (var1.getPSDevSlnSysDynaInst().getPPSDevSlnSysDynaInst() != null) {
                  var6 = var1.getPSDevSlnSysDynaInst().getPPSDevSlnSysDynaInst().getInstTag3();
               }

               if (StringHelper.isNullOrEmpty(var6)) {
                  throw new Exception("传入开发方案成员不正确，动态实例子分组标识无效");
               }
            }

            if (StringHelper.isNullOrEmpty(var1.getPSDevSlnSysDynaInst().getPPSDevSlnSysDynaInstId())) {
               var7 = "";
               var8 = "";
            }

            var5 = true;
      }

      String var11 = null;
      String var12 = null;
      PSDevSln var13 = var1.getPSDevSln();
      if (var13 != null && var13.getPSDevCenter() != null) {
         if (var13.getPSDevCenterSVN() != null && var13.getPSDevCenterSVN().getPSSVNInstRepo() != null) {
            var11 = var13.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag();
            var12 = var13.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag2();
         } else {
            var11 = var13.getSlnTag();
            var12 = var13.getSlnTag2();
         }

         if (StringHelper.isNullOrEmpty(var11)) {
            throw new Exception(StringHelper.format("开发方案[%1$s]没有指定版本仓库", var13.getPSDevSlnName()));
         }

         if (StringHelper.isNullOrEmpty(var12)) {
            throw new Exception(StringHelper.format("开发方案[%1$s]没有指定群组标识", var13.getPSDevSlnName()));
         }

         PSSVNServer var14 = this.getPSSVNServer(var11);
         User var15 = null;

         try {
            if (var2 == 3) {
               var15 = this.getUser(var14, var18);
               if (var15 == null) {
                  return null;
               }
            } else {
               var15 = this.createUserByPSDevUser(var14, var3, var18, true);
            }
         } catch (Exception var17) {
            log.error(StringHelper.format("获取仓库服务器用户发生异常，%1$s", var17.getMessage()), var17);
            throw new Exception(StringHelper.format("获取仓库服务器用户发生异常，%1$s", var17.getMessage()), var17);
         }

         if (var15 == null) {
            throw new Exception(StringHelper.format("仓库服务器不存在指定用户[%1$s]", var18));
         }

         int var16 = DataObject.getIntegerValue(var1.getAccMode(), SlnSysAccModeCodeListModel.READ);
         if (PSDevCenterHelper.isLabDC(var13.getPSDevCenter())) {
            if (PSDevCenterHelper.isLabDCRepoReadonly(var13.getPSDevCenter())) {
               var16 = 1;
            } else if ((var16 & 3) == 3) {
               var16 = 3;
            } else {
               var16 = 1;
            }
         }

         if (var5) {
            var16 = 1;
         }

         if (!StringHelper.isNullOrEmpty(var6)) {
            var12 = var6;
         }

         if (StringHelper.isNullOrEmpty(var7) && StringHelper.isNullOrEmpty(var8)) {
            return this.dealMember(var14, var13, var2, var12, null, var15, var16);
         }

         if (!StringHelper.isNullOrEmpty(var9)) {
            this.dealMember(var14, var13, var2, var12, var9, var15, var16);
         }

         if (!StringHelper.isNullOrEmpty(var10)) {
            this.dealMember(var14, var13, var2, var12, var10, var15, var16);
         }

         if (!StringHelper.isNullOrEmpty(var8)) {
            this.dealMember(var14, var13, var2, var12, var8, var15, var16);
         }

         return this.dealMember(var14, var13, var2, var12, var7, var15, var16);
      } else {
         throw new Exception("传入开发方案用户不正确，开发方案无效");
      }
   }

   protected Member dealMember(PSSVNServer var1, PSDevSln var2, int var3, String var4, String var5, User var6, int var7) throws Exception {
      Integer var8 = 0;
      switch (var7) {
         case 1:
            var8 = 20;
            break;
         case 3:
            var8 = 30;
            break;
         case 7:
            var8 = 40;
            break;
         default:
            throw new Exception(StringHelper.format("无法识别的访问模式[%1$s]", var7));
      }

      Member[] var9 = null;
      if (!StringHelper.isNullOrEmpty(var5)) {
         try {
            var9 = this.listProjectMembers(var1, var5);
         } catch (Exception var22) {
            log.error(StringHelper.format("查询项目成员发生异常，%1$s", var22.getMessage()), var22);
            throw new Exception(StringHelper.format("查询项目成员发生异常，%1$s", var22.getMessage()), var22);
         }
      } else {
         try {
            var9 = this.listGroupMembers(var1, var4);
         } catch (Exception var21) {
            log.error(StringHelper.format("查询群组成员发生异常，%1$s", var21.getMessage()), var21);
            throw new Exception(StringHelper.format("查询群组成员发生异常，%1$s", var21.getMessage()), var21);
         }
      }

      Member var10 = null;
      if (var9 != null) {
         for (Member var14 : var9) {
            if (StringHelper.compare(var14.getUsername(), var6.getUsername(), false) == 0) {
               var10 = var14;
               break;
            }
         }
      }

      if (var3 == 3) {
         if (var10 == null) {
            return null;
         }
      } else if (var10 == null) {
         var3 = 1;
      } else {
         var3 = 2;
         if (var10.getAccessLevel().value >= 50) {
            return var10;
         }
      }

      HashMap var25 = new HashMap();
      String var26 = null;
      if (var3 == 1) {
         var25.put("user_id", Integer.toString(var6.getId()));
         var25.put("access_level", Integer.toString(var8));
         if (!StringHelper.isNullOrEmpty(var5)) {
            try {
               var26 = this.executePost(var1, StringHelper.format("projects/%1$s/members", var5), var25, this.getCurUserName(var2.getPSDevCenter()), null);
            } catch (Exception var16) {
               log.error(StringHelper.format("建立项目成员发生异常，%1$s", var16.getMessage()), var16);
               throw new Exception(StringHelper.format("建立项目成员发生异常，%1$s", var16.getMessage()), var16);
            }
         } else {
            try {
               var26 = this.executePost(var1, StringHelper.format("groups/%1$s/members", var4), var25, this.getCurUserName(var2.getPSDevCenter()), null);
            } catch (Exception var15) {
               log.error(StringHelper.format("建立群组成员发生异常，%1$s", var15.getMessage()), var15);
               throw new Exception(StringHelper.format("建立群组成员发生异常，%1$s", var15.getMessage()), var15);
            }
         }

         return this.jacksonJson.unmarshal(Member.class, var26);
      } else if (var3 == 2) {
         var25.put("access_level", Integer.toString(var8));
         if (!StringHelper.isNullOrEmpty(var5)) {
            try {
               var26 = this.executePut(
                  var1, StringHelper.format("projects/%1$s/members/%2$s", var5, var6.getId()), var25, this.getCurUserName(var2.getPSDevCenter()), null
               );
            } catch (Exception var18) {
               log.error(StringHelper.format("更新项目成员发生异常，%1$s", var18.getMessage()), var18);
               throw new Exception(StringHelper.format("更新项目成员发生异常，%1$s", var18.getMessage()), var18);
            }
         } else {
            try {
               var26 = this.executePut(
                  var1, StringHelper.format("groups/%1$s/members/%2$s", var4, var6.getId()), var25, this.getCurUserName(var2.getPSDevCenter()), null
               );
            } catch (Exception var17) {
               log.error(StringHelper.format("更新群组成员发生异常，%1$s", var17.getMessage()), var17);
               throw new Exception(StringHelper.format("更新群组成员发生异常，%1$s", var17.getMessage()), var17);
            }
         }

         return this.jacksonJson.unmarshal(Member.class, var26);
      } else if (var3 == 3) {
         if (!StringHelper.isNullOrEmpty(var5)) {
            try {
               var26 = this.executeDelete(
                  var1, StringHelper.format("projects/%1$s/members/%2$s", var5, var6.getId()), var25, this.getCurUserName(var2.getPSDevCenter()), null
               );
            } catch (Exception var20) {
               log.error(StringHelper.format("删除项目成员发生异常，%1$s", var20.getMessage()), var20);
               throw new Exception(StringHelper.format("删除项目成员发生异常，%1$s", var20.getMessage()), var20);
            }
         } else {
            try {
               var26 = this.executeDelete(
                  var1, StringHelper.format("groups/%1$s/members/%2$s", var4, var6.getId()), var25, this.getCurUserName(var2.getPSDevCenter()), null
               );
            } catch (Exception var19) {
               log.error(StringHelper.format("删除群组成员发生异常，%1$s", var19.getMessage()), var19);
               throw new Exception(StringHelper.format("删除群组成员发生异常，%1$s", var19.getMessage()), var19);
            }
         }

         return null;
      } else {
         return null;
      }
   }

   protected Project[] listProjectsByPSDevSln(PSSVNServer var1, Namespace var2) throws Exception {
      HashMap var3 = new HashMap();
      var3.put("per_page", "1000");
      String var4 = this.executeGet(var1, String.format("groups/%1$s/projects", var2.getId()), var3, null);
      return this.jacksonJson.unmarshal(Project[].class, var4);
   }

   protected Member[] listGroupMembers(PSSVNServer var1, Object var2) throws Exception {
      HashMap var3 = new HashMap();
      var3.put("per_page", "1000");
      String var4 = this.executeGet(var1, String.format("groups/%1$s/members", var2), var3, null);
      return this.jacksonJson.unmarshal(Member[].class, var4);
   }

   protected Member[] listProjectMembers(PSSVNServer var1, Object var2) throws Exception {
      HashMap var3 = new HashMap();
      var3.put("per_page", "1000");
      String var4 = this.executeGet(var1, String.format("projects/%1$s/members", var2), var3, null);
      return this.jacksonJson.unmarshal(Member[].class, var4);
   }

   protected Tag[] listTags(PSSVNServer var1, String var2) throws Exception {
      HashMap var3 = new HashMap();
      var3.put("per_page", "1000");
      String var4 = this.executeGet(var1, String.format("projects/%1$s/repository/tags", var2), var3, null);
      return this.jacksonJson.unmarshal(Tag[].class, var4);
   }

   protected Namespace getNamespace(PSSVNServer var1, Object var2) throws Exception {
      HashMap var3 = new HashMap();
      String var4 = this.executeGet(var1, String.format("namespaces/%1$s", var2), var3, null);
      Namespace var5 = this.jacksonJson.unmarshal(Namespace.class, var4);
      return var5 != null && var5.getId() != null ? var5 : null;
   }

   @Override
   public User getUserByPSDevUser(PSDevUser var1, boolean var2) throws Exception {
      if (var1.getPSDevCenter() == null) {
         throw new Exception(StringHelper.format("传入开发用户应用中心无效"));
      }

      if (var1.getPSDevCenter().getV6PSSvnInstRepo() == null) {
         throw new Exception(StringHelper.format("传入开发用户应用中心版本仓库无效"));
      }

      String var3 = this.getUserNameByPSDevUser(var1);
      PSSVNServer var4 = this.getPSSVNServer(var1.getPSDevCenter().getV6PSSvnInstRepo().getPSSVNServerId());

      try {
         User var5 = this.getUser(var4, var3);
         if (var5 == null && !var2) {
            throw new Exception(StringHelper.format("仓库服务器不存在用户[%1$s]", var1.getLoginName()));
         } else {
            return var5;
         }
      } catch (Exception var6) {
         log.error(StringHelper.format("获取仓库服务器用户发生异常，%1$s", var6.getMessage()), var6);
         throw new Exception(StringHelper.format("获取仓库服务器用户发生异常，%1$s", var6.getMessage()), var6);
      }
   }

   protected User getUser(PSSVNServer var1, Object var2) throws Exception {
      HashMap var3 = new HashMap();
      String var4 = this.executeGet(var1, String.format("users?username=%1$s", var2), var3, null);
      User[] var5 = this.jacksonJson.unmarshal(User[].class, var4);
      if (var5 == null || var5.length == 0) {
         return null;
      } else {
         return var5[0].getId() == null ? null : var5[0];
      }
   }

   protected String getCurUserName(PSDevCenter var1) {
      if (var1 != null && PSDevCenterHelper.isLabDC(var1)) {
         return null;
      } else {
         return WebContext.getCurrent() == null ? "@" : WebContext.getCurrent().getCurLoginName();
      }
   }

   protected boolean isAutoCreateUser(PSDevCenter var1, PSDevUser var2) {
      return var1 != null && PSDevCenterHelper.isLabDC(var1);
   }

   protected String getUserNameByPSDevUser(PSDevUser var1) throws Exception {
      String var2 = null;
      if (StringHelper.isNullOrEmpty(var2)) {
         if (DataObject.getIntegerValue(var1.getFromUserMode(), 0) == 1) {
            var2 = var1.getFromLoginName();
         } else {
            var2 = var1.getLoginName();
         }
      }

      if (StringHelper.compare(var2, "admin", true) == 0 && StringHelper.compare(var1.getFullLoginName(), "admin@demo.com", true) == 0) {
         var2 = "admin_demo_com";
      }

      return var2;
   }

   @Override
   public void removeGroupByPSDevSln(PSDevSln var1) throws Exception {
      throw new Exception("没有实现");
   }

   @Override
   public void removeCodeProjectByPSDevSlnSys(PSDevSlnSys var1) throws Exception {
      throw new Exception("没有实现");
   }

   @Override
   public void removeModelProjectByPSDevSlnSys(PSDevSlnSys var1) throws Exception {
      throw new Exception("没有实现");
   }

   @Override
   public void removeProjectByPSDevSlnTempl(PSDevSlnTempl var1) throws Exception {
      throw new Exception("没有实现");
   }

   @Override
   public Project moveCodeProjectByPSDevSlnSys(PSDevSlnSys var1, PSDevSln var2) throws Exception {
      PSDevCenterSVN var3 = var1.getPSDevCenterSVN();
      return var3 != null ? this.moveProject(var3, var2) : null;
   }

   @Override
   public Project moveModelProjectByPSDevSlnSys(PSDevSlnSys var1, PSDevSln var2) throws Exception {
      PSDevCenterSVN var3 = var1.getModelPSDevCenterSVN();
      return var3 != null ? this.moveProject(var3, var2) : null;
   }

   @Override
   public Project moveProjectByPSDevSlnTempl(PSDevSlnTempl var1, PSDevSln var2) throws Exception {
      PSDevCenterSVN var3 = var1.getPSDevCenterSVN();
      return var3 != null ? this.moveProject(var3, var2) : null;
   }

   protected Project moveProject(PSDevCenterSVN var1, PSDevSln var2) throws Exception {
      String var3 = null;
      String var4 = null;
      if (var2.getPSDevCenterSVN() != null && var2.getPSDevCenterSVN().getPSSVNInstRepo() != null) {
         var3 = var2.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag();
         var4 = var2.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag2();
      } else {
         var3 = var2.getSlnTag();
         var4 = var2.getSlnTag2();
      }

      if (StringHelper.isNullOrEmpty(var3)) {
         throw new Exception(StringHelper.format("开发方案[%1$s]没有指定版本仓库", var2.getPSDevSlnName()));
      }

      if (StringHelper.isNullOrEmpty(var4)) {
         throw new Exception(StringHelper.format("开发方案[%1$s]没有指定群组标识", var2.getPSDevSlnName()));
      }

      String var5 = null;
      if (var1.getPSSVNInstRepo() != null) {
         var5 = var1.getPSSVNInstRepo().getRepoTag2();
         if (StringHelper.isNullOrEmpty(var5)) {
            return null;
         }

         if (StringHelper.compare(var1.getPSSVNInstRepo().getRepoTag(), var3, false) != 0) {
            throw new Exception(StringHelper.format("无法跨版本仓库转移群组"));
         }
      }

      PSSVNServer var6 = this.getPSSVNServer(var3);
      Namespace var7 = this.getNamespace(var6, var4);
      HashMap var8 = new HashMap();
      var8.put("namespace", Integer.toString(var7.getId()));
      if (!StringHelper.isNullOrEmpty(var5)) {
         String var9 = null;

         try {
            var9 = this.executePut(var6, StringHelper.format("projects/%1$s/transfer", var5), var8, this.getCurUserName(var2.getPSDevCenter()), null);
         } catch (Exception var11) {
            log.error(StringHelper.format("更新项目成员发生异常，%1$s", var11.getMessage()), var11);
            throw new Exception(StringHelper.format("更新项目成员发生异常，%1$s", var11.getMessage()), var11);
         }

         return this.jacksonJson.unmarshal(Project.class, var9);
      } else {
         return null;
      }
   }

   @Override
   public Project createProjectByPSDevSlnSysDynaInst(PSDevSln var1, PSDevSlnSysDynaInst var2, boolean var3) throws Exception {
      String var4 = null;
      String var5 = null;
      if (var1.getPSDevCenterSVN() != null && var1.getPSDevCenterSVN().getPSSVNInstRepo() != null) {
         var4 = var1.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag();
         var5 = var1.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag2();
      } else {
         var4 = var1.getSlnTag();
         var5 = var1.getSlnTag2();
      }

      if (StringHelper.isNullOrEmpty(var4)) {
         throw new Exception(StringHelper.format("开发方案[%1$s]没有指定版本仓库", var1.getPSDevSlnName()));
      }

      if (StringHelper.isNullOrEmpty(var5)) {
         throw new Exception(StringHelper.format("开发方案[%1$s]没有指定群组标识", var1.getPSDevSlnName()));
      }

      PSSVNServer var6 = this.getPSSVNServer(var4);
      if (StringHelper.isNullOrEmpty(var2.getPPSDevSlnSysDynaInstId())) {
         if (StringHelper.isNullOrEmpty(var2.getInstTag3())) {
            if (StringHelper.isNullOrEmpty(var1.getSlnTag2())) {
               var1.setSlnTag2(var5);
            }

            this.createSubGroupByPSDevSlnSysDynaInst(var1, var2);
         }

         var5 = var2.getInstTag3();
      } else {
         var5 = var2.getPPSDevSlnSysDynaInst().getInstTag3();
         var2.setInstTag3(var5);
      }

      if (StringHelper.isNullOrEmpty(var5)) {
         throw new Exception(StringHelper.format("动态实例[%1$s]没有指定群组标识", var2.getPSDevSlnSysDynaInstName()));
      }

      Namespace var7 = this.getNamespace(var6, var5);
      HashMap var8 = new HashMap();
      String var9 = (var3 ? "Model" : "Cfg")
         + KeyValueHelper.genUniqueId(var2.getPSDevSlnSysDynaInstId(), Long.toString(random.nextLong()), Long.toString(System.currentTimeMillis()));
      String var10 = var2.getPSDevSlnSysDynaInstName();
      if (var3) {
         var10 = var10 + "（模型）";
      } else {
         var10 = var10 + "（配置）";
      }

      if (StringHelper.isNullOrEmpty(var10)) {
         var10 = var9;
      }

      var8.put("path", var9);
      if (!StringHelper.isNullOrEmpty(var10)) {
         var8.put("name", var10);
      }

      var8.put("namespace_id", Integer.toString(var7.getId()));
      var8.put("import_url", "");
      var8.put("description", "");
      var8.put("issues_enabled", "true");
      var8.put("merge_requests_enabled", "true");
      var8.put("wiki_enabled", "true");
      var8.put("snippets_enabled", "true");
      var8.put("visibility_level", "20");
      String var11 = null;

      try {
         var11 = this.executePost(var6, "projects", var8, this.getCurUserName(var1.getPSDevCenter()), null);
      } catch (Exception var13) {
         if (var3) {
            log.error(StringHelper.format("建立动态实例模型项目发生异常，%1$s", var13.getMessage()), var13);
            throw new Exception(StringHelper.format("建立动态实例模型项目发生异常，%1$s", var13.getMessage()), var13);
         }

         log.error(StringHelper.format("建立动态实例配置项目发生异常，%1$s", var13.getMessage()), var13);
         throw new Exception(StringHelper.format("建立动态实例配置项目发生异常，%1$s", var13.getMessage()), var13);
      }

      return this.jacksonJson.unmarshal(Project.class, var11);
   }

   @Override
   public Tag[] listTagsByPSDevSlnSysDynaInst(PSDevSlnSysDynaInst var1) throws Exception {
      PSDevSln var2 = var1.getPSDevSln();
      if (var2 == null) {
         throw new Exception(StringHelper.format("动态实例没有指定开发方案"));
      }

      String var3 = null;
      String var4 = null;
      if (var2.getPSDevCenterSVN() != null && var2.getPSDevCenterSVN().getPSSVNInstRepo() != null) {
         var3 = var2.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag();
         var4 = var2.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag2();
      } else {
         var3 = var2.getSlnTag();
         var4 = var2.getSlnTag2();
      }

      if (StringHelper.isNullOrEmpty(var3)) {
         throw new Exception(StringHelper.format("开发方案[%1$s]没有指定版本仓库", var2.getPSDevSlnName()));
      }

      if (StringHelper.isNullOrEmpty(var4)) {
         throw new Exception(StringHelper.format("开发方案[%1$s]没有指定群组标识", var2.getPSDevSlnName()));
      }

      PSSVNServer var5 = this.getPSSVNServer(var3);
      PSDevCenterSVN var6 = var1.getModelPSDevCenterSVN();
      if (var6 != null && var6.getPSSVNInstRepo() != null) {
         String var7 = var6.getPSSVNInstRepo().getRepoTag2();

         try {
            return this.listTags(var5, var7);
         } catch (Exception var9) {
            log.error(StringHelper.format("查询动态实例标记发生异常，%1$s", var9.getMessage()), var9);
            throw new Exception(StringHelper.format("查询动态实例标记发生异常，%1$s", var9.getMessage()), var9);
         }
      } else {
         throw new Exception("动态实例模型仓库无效");
      }
   }

   @Override
   public Tag getTagByPSDevSlnSysDynaInstTag(PSDevSlnSysDynaInstTag var1) throws Exception {
      PSDevSlnSysDynaInst var2 = var1.getPSDevSlnSysDynaInst();
      if (var2 == null) {
         throw new Exception(StringHelper.format("动态实例标记没有指定动态实例"));
      }

      PSDevSln var3 = var2.getPSDevSln();
      if (var3 == null) {
         throw new Exception(StringHelper.format("动态实例没有指定开发方案"));
      }

      String var4 = null;
      String var5 = null;
      if (var3.getPSDevCenterSVN() != null && var3.getPSDevCenterSVN().getPSSVNInstRepo() != null) {
         var4 = var3.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag();
         var5 = var3.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag2();
      } else {
         var4 = var3.getSlnTag();
         var5 = var3.getSlnTag2();
      }

      if (StringHelper.isNullOrEmpty(var4)) {
         throw new Exception(StringHelper.format("开发方案[%1$s]没有指定版本仓库", var3.getPSDevSlnName()));
      }

      if (StringHelper.isNullOrEmpty(var5)) {
         throw new Exception(StringHelper.format("开发方案[%1$s]没有指定群组标识", var3.getPSDevSlnName()));
      }

      PSSVNServer var6 = this.getPSSVNServer(var4);
      PSDevCenterSVN var7 = var2.getModelPSDevCenterSVN();
      if (var7 != null && var7.getPSSVNInstRepo() != null) {
         String var8 = var7.getPSSVNInstRepo().getRepoTag2();

         try {
            HashMap var9 = new HashMap();
            String var10 = this.executeGet(var6, String.format("projects/%1$s/repository/tags/%2$s", var8, var1.getPSDevSlnSysDynaInstTagName()), var9, null);
            Tag var11 = this.jacksonJson.unmarshal(Tag.class, var10);
            return var11 != null && var11.getName() != null ? var11 : null;
         } catch (Exception var12) {
            log.error(StringHelper.format("获取动态实例标记发生异常，%1$s", var12.getMessage()), var12);
            throw new Exception(StringHelper.format("获取动态实例标记发生异常，%1$s", var12.getMessage()), var12);
         }
      } else {
         throw new Exception("动态实例模型仓库无效");
      }
   }

   @Override
   public Tag createTagByPSDevSlnSysDynaInstTag(PSDevSlnSysDynaInstTag var1) throws Exception {
      PSDevSlnSysDynaInst var2 = var1.getPSDevSlnSysDynaInst();
      if (var2 == null) {
         throw new Exception(StringHelper.format("动态实例标记没有指定动态实例"));
      }

      PSDevSln var3 = var2.getPSDevSln();
      if (var3 == null) {
         throw new Exception(StringHelper.format("动态实例没有指定开发方案"));
      }

      String var4 = null;
      String var5 = null;
      if (var3.getPSDevCenterSVN() != null && var3.getPSDevCenterSVN().getPSSVNInstRepo() != null) {
         var4 = var3.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag();
         var5 = var3.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag2();
      } else {
         var4 = var3.getSlnTag();
         var5 = var3.getSlnTag2();
      }

      if (StringHelper.isNullOrEmpty(var4)) {
         throw new Exception(StringHelper.format("开发方案[%1$s]没有指定版本仓库", var3.getPSDevSlnName()));
      }

      if (StringHelper.isNullOrEmpty(var5)) {
         throw new Exception(StringHelper.format("开发方案[%1$s]没有指定群组标识", var3.getPSDevSlnName()));
      }

      PSSVNServer var6 = this.getPSSVNServer(var4);
      PSDevCenterSVN var7 = var2.getModelPSDevCenterSVN();
      if (var7 != null && var7.getPSSVNInstRepo() != null) {
         String var8 = var7.getPSSVNInstRepo().getRepoTag2();
         Tag[] var9 = this.listTags(var6, var8);
         if (var9 != null && var9.length > 0) {
            for (Tag var13 : var9) {
               if (StringHelper.compare(var13.getName(), var1.getPSDevSlnSysDynaInstTagName(), true) == 0) {
                  throw new Exception(StringHelper.format("动态实例标记[%1$s]已存在", var1.getPSDevSlnSysDynaInstTagName()));
               }
            }
         }

         HashMap var17 = new HashMap();
         var17.put("tag_name", var1.getPSDevSlnSysDynaInstTagName());
         var17.put("ref", "master");
         if (!StringHelper.isNullOrEmpty(var1.getMemo())) {
            var17.put("message", var1.getMemo());
         }

         String var18 = null;

         try {
            var18 = this.executePost(var6, String.format("projects/%1$s/repository/tags", var8), var17, this.getCurUserName(var3.getPSDevCenter()), null);
         } catch (Exception var14) {
            log.error(StringHelper.format("建立动态实例标记发生异常，%1$s", var14.getMessage()), var14);
            throw new Exception(StringHelper.format("建立动态实例标记发生异常，%1$s", var14.getMessage()), var14);
         }

         return this.jacksonJson.unmarshal(Tag.class, var18);
      } else {
         throw new Exception("动态实例模型仓库无效");
      }
   }

   @Override
   public Tag updateTagByPSDevSlnSysDynaInstTag(PSDevSlnSysDynaInstTag var1) throws Exception {
      return null;
   }

   @Override
   public void removeTagByPSDevSlnSysDynaInstTag(PSDevSlnSysDynaInstTag var1) throws Exception {
      PSDevSlnSysDynaInst var2 = var1.getPSDevSlnSysDynaInst();
      if (var2 == null) {
         throw new Exception(StringHelper.format("动态实例标记没有指定动态实例"));
      }

      PSDevSln var3 = var2.getPSDevSln();
      if (var3 == null) {
         throw new Exception(StringHelper.format("动态实例没有指定开发方案"));
      }

      String var4 = null;
      String var5 = null;
      if (var3.getPSDevCenterSVN() != null && var3.getPSDevCenterSVN().getPSSVNInstRepo() != null) {
         var4 = var3.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag();
         var5 = var3.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag2();
      } else {
         var4 = var3.getSlnTag();
         var5 = var3.getSlnTag2();
      }

      if (StringHelper.isNullOrEmpty(var4)) {
         throw new Exception(StringHelper.format("开发方案[%1$s]没有指定版本仓库", var3.getPSDevSlnName()));
      }

      if (StringHelper.isNullOrEmpty(var5)) {
         throw new Exception(StringHelper.format("开发方案[%1$s]没有指定群组标识", var3.getPSDevSlnName()));
      }

      PSSVNServer var6 = this.getPSSVNServer(var4);
      PSDevCenterSVN var7 = var2.getModelPSDevCenterSVN();
      if (var7 != null && var7.getPSSVNInstRepo() != null) {
         String var8 = var7.getPSSVNInstRepo().getRepoTag2();

         try {
            HashMap var9 = new HashMap();
            String var10 = this.executeDelete(
               var6,
               String.format("projects/%1$s/repository/tags/%2$s", var8, var1.getPSDevSlnSysDynaInstTagName()),
               var9,
               this.getCurUserName(var3.getPSDevCenter()),
               null
            );
         } catch (Exception var11) {
            log.error(StringHelper.format("删除动态实例标记发生异常，%1$s", var11.getMessage()), var11);
            throw new Exception(StringHelper.format("删除动态实例标记发生异常，%1$s", var11.getMessage()), var11);
         }
      } else {
         throw new Exception("动态实例模型仓库无效");
      }
   }

   @Override
   public void revertTagByPSDevSlnSysDynaInstTag(PSDevSlnSysDynaInstTag var1) throws Exception {
      PSDevSlnSysDynaInst var2 = var1.getPSDevSlnSysDynaInst();
      if (var2 == null) {
         throw new Exception(StringHelper.format("动态实例标记没有指定动态实例"));
      }

      PSDevSln var3 = var2.getPSDevSln();
      if (var3 == null) {
         throw new Exception(StringHelper.format("动态实例没有指定开发方案"));
      }

      String var4 = null;
      String var5 = null;
      if (var3.getPSDevCenterSVN() != null && var3.getPSDevCenterSVN().getPSSVNInstRepo() != null) {
         var4 = var3.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag();
         var5 = var3.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag2();
      } else {
         var4 = var3.getSlnTag();
         var5 = var3.getSlnTag2();
      }

      if (StringHelper.isNullOrEmpty(var4)) {
         throw new Exception(StringHelper.format("开发方案[%1$s]没有指定版本仓库", var3.getPSDevSlnName()));
      }

      if (StringHelper.isNullOrEmpty(var5)) {
         throw new Exception(StringHelper.format("开发方案[%1$s]没有指定群组标识", var3.getPSDevSlnName()));
      }

      PSSVNServer var6 = this.getPSSVNServer(var4);
      PSDevCenterSVN var7 = var2.getModelPSDevCenterSVN();
      if (var7 != null && var7.getPSSVNInstRepo() != null) {
         String var8 = var7.getPSSVNInstRepo().getRepoTag2();
         Tag var9 = null;

         try {
            HashMap var10 = new HashMap();
            String var11 = this.executeGet(var6, String.format("projects/%1$s/repository/tags/%2$s", var8, var1.getPSDevSlnSysDynaInstTagName()), var10, null);
            var9 = this.jacksonJson.unmarshal(Tag.class, var11);
            if (var9 == null || var9.getCommit() == null || StringHelper.isNullOrEmpty(var9.getCommit().getId())) {
               throw new Exception("指定标记无效");
            }
         } catch (Exception var13) {
            log.error(StringHelper.format("反做动态实例标记发生异常，%1$s", var13.getMessage()), var13);
            throw new Exception(StringHelper.format("反做动态实例标记发生异常，%1$s", var13.getMessage()), var13);
         }

         Object var17 = null;

         try {
            HashMap var19 = new HashMap();
            var19.put("branch", "master");
            var17 = this.executePost(
               var6,
               String.format("projects/%1$s/repository/commits/%2$s/revert", var8, var9.getCommit().getId()),
               var19,
               this.getCurUserName(var3.getPSDevCenter()),
               null
            );
         } catch (Exception var12) {
            log.error(StringHelper.format("反做动态实例标记发生异常，%1$s", var12.getMessage()), var12);
            throw new Exception(StringHelper.format("反做动态实例标记发生异常，%1$s", var12.getMessage()), var12);
         }
      } else {
         throw new Exception("动态实例模型仓库无效");
      }
   }

   @Override
   public WikiPage getWikiPage(PSDevSlnSys var1, String var2, boolean var3) throws Exception {
      if (var1.getPSDevCenterSVN() != null && var1.getPSDevCenterSVN().getPSSVNInstRepo() != null) {
         String var4 = var1.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag2();
         if (!StringHelper.isNullOrEmpty(var4)) {
            String var5 = var1.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag();
            if (!StringHelper.isNullOrEmpty(var5)) {
               PSSVNServer var6 = this.getPSSVNServer(var5);
               WikiPage var7 = null;

               try {
                  HashMap var8 = new HashMap();
                  String var9 = this.executeGet(var6, String.format("projects/%1$s/wikis/%2$s", var4, URLEncoder.encode(var2, "UTF-8")), var8, null, null);
                  var7 = this.jacksonJson.unmarshal(WikiPage.class, var9);
                  if (var7 == null) {
                     throw new Exception("指定Wiki路径无效");
                  } else {
                     return var7;
                  }
               } catch (Exception var10) {
                  log.error(StringHelper.format("获取指定Wiki发生异常，%1$s", var10.getMessage()), var10);
                  if (var3) {
                     return null;
                  } else {
                     throw new Exception(StringHelper.format("获取指定Wiki发生异常，%1$s", var10.getMessage()), var10);
                  }
               }
            } else if (var3) {
               return null;
            } else {
               throw new Exception("开发系统代码仓库无效");
            }
         } else if (var3) {
            return null;
         } else {
            throw new Exception("开发系统代码仓库标识无效");
         }
      } else if (var3) {
         return null;
      } else {
         throw new Exception("开发系统代码仓库无效");
      }
   }

   @Override
   public void updateWikiPage(PSDevSlnSys var1, String var2, String var3, String var4, boolean var5) throws Exception {
      if (var1.getPSDevCenterSVN() != null && var1.getPSDevCenterSVN().getPSSVNInstRepo() != null) {
         String var6 = var1.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag2();
         if (!StringHelper.isNullOrEmpty(var6)) {
            String var7 = var1.getPSDevCenterSVN().getPSSVNInstRepo().getRepoTag();
            if (!StringHelper.isNullOrEmpty(var7)) {
               PSSVNServer var8 = this.getPSSVNServer(var7);
               PSDevCenter var9 = var1.getPSDevSln().getPSDevCenter();
               WikiPage var10 = null;

               try {
                  HashMap var11 = new HashMap();
                  String var12 = this.executeGet(var8, String.format("projects/%1$s/wikis/%2$s", var6, URLEncoder.encode(var2, "UTF-8")), var11, null, null);
                  var10 = this.jacksonJson.unmarshal(WikiPage.class, var12);
               } catch (Exception var13) {
                  log.error(StringHelper.format("获取指定Wiki发生异常，%1$s", var13.getMessage()), var13);
               }

               try {
                  HashMap var17 = new HashMap();
                  if (!StringHelper.isNullOrEmpty(var3)) {
                     var17.put("title", var3);
                  }

                  if (!StringHelper.isNullOrEmpty(var4)) {
                     var17.put("content", var4);
                  }

                  if (var10 == null) {
                     var17.put("title", var2);
                     String var18 = this.executePost(var8, String.format("projects/%1$s/wikis", var6), var17, this.getCurUserName(var9), null);
                     var10 = this.jacksonJson.unmarshal(WikiPage.class, var18);
                  } else {
                     var17.put("title", var2);
                     String var19 = this.executePut(
                        var8, String.format("projects/%1$s/wikis/%2$s", var6, URLEncoder.encode(var2, "UTF-8")), var17, this.getCurUserName(var9), null
                     );
                     var10 = this.jacksonJson.unmarshal(WikiPage.class, var19);
                  }
               } catch (Exception var14) {
                  log.error(StringHelper.format("更新指定Wiki发生异常，%1$s", var14.getMessage()), var14);
                  if (!var5) {
                     throw new Exception(StringHelper.format("更新指定Wiki发生异常，%1$s", var14.getMessage()), var14);
                  }
               }
            } else if (!var5) {
               throw new Exception("开发系统代码仓库无效");
            }
         } else if (!var5) {
            throw new Exception("开发系统代码仓库标识无效");
         }
      } else if (!var5) {
         throw new Exception("开发系统代码仓库无效");
      }
   }
}
