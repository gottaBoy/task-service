package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSDevSlnSysDynaInst;
import SA.SRFDA.PS.Core.IPSModelObjectLogger;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemRuntime;
import SA.SRFDA.PS.Core.PSSystemUtil;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.IPSApplicationRuntime;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CheckSysModelPSSysDevBKTaskImpl extends PSSysDevBKTaskImplBase {
   private static final Log log = LogFactory.getLog(CheckSysModelPSSysDevBKTaskImpl.class);

   @Override
   protected void onInit() throws Exception {
      super.onInit();
   }

   @Override
   protected String onRun() throws Exception {
      try {
         return this.checkSysModel();
      } catch (Exception ex) {
         Throwable ex2 = ex;
         String strMessage = ex.getMessage();
         if (!StringHelper.isNullOrEmpty(strMessage) && strMessage.indexOf("null") != -1) {
            IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(this.psSysDevBKTask.getPSDEVSLNSYSID());
            this.getPSModelHelper(iPSDevSlnSys.getPSSysModelInstId()).resetCache();
            return this.checkSysModel();
         }

         while (ex2 != null) {
            if (ex2 instanceof NullPointerException) {
               IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(this.psSysDevBKTask.getPSDEVSLNSYSID());
               this.getPSModelHelper(iPSDevSlnSys.getPSSysModelInstId()).resetCache();
               return this.checkSysModel();
            }

            ex2 = ex2.getCause();
         }

         throw ex;
      }
   }

   protected String checkSysModel() throws Exception {
      IPSModelObjectLogger lastPSModelObjectLogger = null;
      IPSSystemRuntime iPSSystemRuntime = null;
      StringBuilderEx sBuilderEx = new StringBuilderEx();
      IPSDevSlnSys iPSDevSlnSys = null;
      IPSDevSlnSysDynaInst iPSDevSlnSysDynaInst = null;
      if (!StringHelper.isNullOrEmpty(this.psSysDevBKTask.getPSDYNAINSTID())) {
         return null;
      }

      iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(this.psSysDevBKTask.getPSDEVSLNSYSID());

      try {
         IPSSystem iPSSystem = iPSDevSlnSys.getPSSystem(false);
         if (iPSSystem.getLoadedLevel() < this.getModelLoadLevel()) {
            iPSSystem = iPSDevSlnSys.reloadPSSystem(this.getModelLoadLevel());
         }

         if (iPSSystem instanceof IPSSystemRuntime) {
            iPSSystemRuntime = (IPSSystemRuntime)iPSSystem;
            lastPSModelObjectLogger = iPSSystemRuntime.getPSModelObjectLogger();
            iPSSystemRuntime.setPSModelObjectLogger(this.getPSModelObjectLogger());
            Map<String, Object> params = new HashMap<>();
            params.put("sys", iPSSystem);
            PSTemplHelper.setCurrentParams(params);
         }

         int nCount = iPSSystem.check(0);
         if (nCount > 0) {
            throw new PSSysBTException(5, StringHelper.format("系统模型存在错误[%1$s]，具体查看【系统问题】", nCount));
         }

         ArrayList<String> reloadAppIds = new ArrayList<>();
         Iterator<IPSApplication> psApplications = iPSSystem.getAllPSApps();

         while (psApplications.hasNext()) {
            IPSApplication iPSApplication = psApplications.next();
            if (iPSApplication.getLoadedLevel() < this.getModelLoadLevel()) {
               reloadAppIds.add(iPSApplication.getId());
            }
         }

         for (String strPSSysAppId : reloadAppIds) {
            PSSystemUtil.loadPSApplication(iPSSystem, strPSSysAppId, this.getModelLoadLevel());
         }

         psApplications = iPSSystem.getAllPSApps();

         while (psApplications.hasNext()) {
            IPSApplication iPSApplication = psApplications.next();
            ((IPSApplicationRuntime)iPSApplication).calcPSAppViewSysRefFlag();
         }

         nCount = iPSSystem.check(1);
         if (nCount > 0) {
            throw new PSSysBTException(5, StringHelper.format("系统模型存在错误[%1$s]，具体查看【系统问题】", nCount));
         }

         sBuilderEx.append("[v%1$s]系统模型检查完成", iPSSystem.getVersion());
         if (iPSSystemRuntime != null) {
            iPSSystemRuntime.setPSModelObjectLogger(lastPSModelObjectLogger);
            PSTemplHelper.setCurrentParams(null);
         }
      } catch (Exception ex) {
         if (iPSSystemRuntime != null) {
            iPSSystemRuntime.setPSModelObjectLogger(lastPSModelObjectLogger);
            PSTemplHelper.setCurrentParams(null);
         }

         throw ex;
      }

      return sBuilderEx.toString();
   }
}
