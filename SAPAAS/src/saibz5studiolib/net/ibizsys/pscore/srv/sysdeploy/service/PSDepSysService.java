package net.ibizsys.pscore.srv.sysdeploy.service;

import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.devcenter.entity.PSSaaSSys;
import net.ibizsys.pscore.srv.devcenter.entity.PSSaaSSysVer;
import net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysVerService;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSys;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSysVer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDepSysService extends PSDepSysServiceBase {
   private static final Log log = LogFactory.getLog(PSDepSysService.class);

   protected void onBeforeCreate(PSDepSys var1) throws Exception {
      PSDevSlnService var2 = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class);
      String var3 = "DepSysSln";
      PSDevSln var4 = new PSDevSln();
      var4.setPSDevCenterId(var1.getPSDevCenterId());
      var4.setPSDevCenterName(var1.getPSDevCenterName());
      int var5 = 0;

      while (true) {
         String var6 = StringHelper.format("%1$s%2$s", var3, ++var5);
         var4.resetCodeName();
         var4.setPSDevSlnName(var6);
         if (!var2.select(var4, true)) {
            var4.resetPSDevSlnName();
            var4.setCodeName(var6);
            if (!var2.select(var4, true)) {
               var4.setPSDevSlnId(var1.getPSDepSysId());
               var4.setSLNType("DEPSYS");
               var4.setPSDevSlnName(var6);
               var4.setCodeName(var6);
               var4.setLogicName(StringHelper.format("可部署系统[%1$s]扩展开发方案", var1.getPSDepSysName()));
               var2.create(var4);
               super.onBeforeCreate(var1);
               return;
            }
            continue;
         }
      }
   }

   @Override
   protected void onSyncSysVer(PSDepSys var1) throws Exception {
      this.get(var1);
      PSDepSysVerService var2 = (PSDepSysVerService)ServiceGlobal.getService(PSDepSysVerService.class);
      if (StringHelper.compare(var1.getPSDepSysType(), "SAASSYS", true) == 0) {
         PSSaaSSys var3 = new PSSaaSSys();
         var3.setPSSaaSSysId(var1.getPSSaaSSysId());
         PSSaaSSysVerService var4 = (PSSaaSSysVerService)ServiceGlobal.getService(PSSaaSSysVerService.class);

         for (PSSaaSSysVer var7 : var4.selectByPSSaaSSys(var3)) {
            PSDepSysVer var8 = new PSDepSysVer();
            var8.setPSDepSysVerId(KeyValueHelper.genUniqueId(var1.getPSDepSysId(), var1.getPSDepSysType(), var7.getPSSaaSSysVerId()));
            if (var2.checkKey(var8) == 0) {
               var8.setPSDepSysId(var1.getPSDepSysId());
               var8.setPSDepSysName(var1.getPSDepSysName());
               var8.setPSDepSysVerType(var1.getPSDepSysType());
               var8.setPSSaaSSysVerId(var7.getPSSaaSSysVerId());
               var8.setPSSaaSSysVerName(var7.getPSSaaSSysVerName());
               var8.setPSDepSysVerName(var7.getPSSaaSSysVerName());
               var2.create(var8);
            }
         }
      }
   }
}
