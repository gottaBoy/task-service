package net.ibizsys.pscore.srv.sysdesign.service;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatform;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatformFunc;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformFuncService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDeploy;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDevSlnMSDeployService extends PSDevSlnMSDeployServiceBase {
   private static final Log log = LogFactory.getLog(PSDevSlnMSDeployService.class);
   public static final String CONFIG_DBINST = "dbinst";
   public static final String CONFIG_DBINST_DBTYPE = "dbtype";
   public static final String CONFIG_DBINST_DBNAME = "dbname";
   public static final String CONFIG_DBINST_USERNAME = "username";
   public static final String CONFIG_DBINST_PASSWORD = "password";
   public static final String CONFIG_DBINST_URL = "url";
   public static final String CONFIG_CLOUDUTIL = "cloudutil";
   public static final String CONFIG_CLOUDCONF = "cloudconf";
   public static final String CONFIG_CLOUDNODE = "cloudnode";

   @Override
   protected void onPubConfigs(PSDevSlnMSDeploy var1) throws Exception {
      this.get(var1);
      if (StringHelper.isNullOrEmpty(var1.getPSDevSlnId())) {
         throw new Exception(String.format("微服务部署方案未指定开发方案"));
      }

      if (StringHelper.isNullOrEmpty(var1.getPSDCMSPlatformId())) {
         throw new Exception(String.format("微服务部署方案未指定微服务平台"));
      }

      PSDevSln var2 = var1.getPSDevSln();
      PSDCMSPlatform var3 = var1.getPSDCMSPlatform();
      if (DataTypeHelper.getIntegerValue(var2.getEnableCallback(), 1) != 1) {
         throw new Exception(String.format("开发方案未启用回调"));
      }

      String var4 = var2.getCallbackUrl();
      if (StringHelper.isNullOrEmpty(var4)) {
         throw new Exception(String.format("开发方案未定义回调路径"));
      }

      PSDevCenterDBInstService var5 = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, this.getSessionFactory());
      ObjectNode var6 = JsonNodeHelper.createObjectNode();
      ArrayList<PSDevCenterDBInst> var7 = var5.selectByPSDevSln(var2);
      if (var7 != null) {
         ObjectNode var8 = var6.putObject("dbinst");

         for (PSDevCenterDBInst var10 : var7) {
            ObjectNode var11 = var8.putObject(var10.getPSDevCenterDBInstName());
            var11.put("dbtype", var10.getDBType());
            if (!StringHelper.isNullOrEmpty(var10.getUserName())) {
               var11.put("username", var10.getUserName());
            }

            if (!StringHelper.isNullOrEmpty(var10.getPasswd())) {
               var11.put("password", var10.getPasswd());
            }

            if (!StringHelper.isNullOrEmpty(var10.getConnStr())) {
               var11.put("url", var10.getConnStr());
            }
         }
      }

      PSDCMSPlatformFuncService var20 = (PSDCMSPlatformFuncService)ServiceGlobal.getService(PSDCMSPlatformFuncService.class, this.getSessionFactory());
      ArrayList<PSDCMSPlatformFunc> var21 = var20.selectByPSDCMSPlatform(var3);
      if (var21 != null) {
         ObjectNode var22 = var6.putObject("cloudutil");
         ObjectNode var24 = var6.putObject("cloudconf");

         for (PSDCMSPlatformFunc var13 : var21) {
            if (DataObject.getIntegerValue(var13.getValidFlag(), 1) == 1) {
               String var14 = var13.getMSFuncType();
               if (!StringHelper.isNullOrEmpty(var14) && var14.indexOf("CLOUD") == 0) {
                  String var15 = var13.getFuncParam9();
                  if (!StringHelper.isNullOrEmpty(var15) && !StringHelper.isNullOrEmpty(var13.getFuncParam10())) {
                     var15 = var15 + "\r\n";
                     var15 = var15 + var13.getFuncParam10();
                  }

                  if (!StringHelper.isNullOrEmpty(var15)) {
                     if ("CLOUDCONFITEM".equals(var14)) {
                        if (!StringHelper.isNullOrEmpty(var13.getPSDCMSPlatformFuncName())) {
                           var24.put(var13.getPSDCMSPlatformFuncName(), var15);
                        }
                     } else {
                        String var16 = var14.replace("CLOUD", "").replace("UTIL", "").toLowerCase();
                        var22.put(var16, var15);
                     }
                  }
               }
            }
         }
      }

      ArrayList<PSDevSlnMSDepAPI> var23 = var1.getPSDevSlnMSDepAPIs();
      if (var23 != null) {
         HashMap<String, List> var25 = new HashMap<String, List>();

         for (PSDevSlnMSDepAPI var29 : var23) {
            if (DataObject.getIntegerValue(var29.getValidFlag(), 1) == 1
               && var29.getPSDCMSPlatformNode() != null
               && var29.getPSDevSlnSys() != null
               && var29.getPSDevSlnSysAPI() != null) {
               if (StringHelper.isNullOrEmpty(var29.getPSDevSlnSys().getDeploySysId())) {
                  log.warn(String.format("开发系统[%1$s]未指定部署系统标识", var29.getPSDevSlnSys().getPSDevSlnSysName()));
               } else {
                  List var31 = (List)var25.get(var29.getPSDCMSPlatformNode().getPSDCMSPlatformNodeName());
                  if (var31 == null) {
                     var31 = new ArrayList();
                     var25.put(var29.getPSDCMSPlatformNode().getPSDCMSPlatformNodeName(), var31);
                  }

                  var31.add(var29);
               }
            }
         }

         if (var25.size() > 0) {
            ObjectNode var28 = var6.putObject("cloudnode");

            for (Entry var32 : var25.entrySet()) {
               ArrayNode var34 = var28.putArray((String)var32.getKey());

               for (PSDevSlnMSDepAPI var18 : (List<PSDevSlnMSDepAPI>)var32.getValue()) {
                  ObjectNode var19 = var34.addObject();
                  var19.put("systemid", var18.getPSDevSlnSys().getDeploySysId());
                  var19.put("apiname", var18.getPSDevSlnSysAPI().getPSDevSlnSysAPIName());
               }
            }
         }
      }

      String var26 = var2.getCallbackTag() == null ? "" : var2.getCallbackTag();
      this.executeCallback(this.getRealCallbackUrl(var4, "", var2.getPSDevSlnId(), "PUBCONFIG", "srfcloudplatform", "", var26), var6.toString());
   }
}
