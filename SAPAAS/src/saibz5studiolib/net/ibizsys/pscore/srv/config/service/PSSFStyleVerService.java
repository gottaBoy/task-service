package net.ibizsys.pscore.srv.config.service;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSSFCodeFolder;
import net.ibizsys.pscore.srv.config.entity.PSSFCodeTempl;
import net.ibizsys.pscore.srv.config.entity.PSSFCodeType;
import net.ibizsys.pscore.srv.config.entity.PSSFStyle;
import net.ibizsys.pscore.srv.config.entity.PSSFStyleVer;
import net.ibizsys.pscore.srv.config.entity.PSSFVerCode;
import net.ibizsys.pscore.srv.config.entity.PSSFVerCodeItem;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSFStyleVerService extends PSSFStyleVerServiceBase {
   private static final Log log = LogFactory.getLog(PSSFStyleVerService.class);
   public static final String PARAM_PRJFOLDER = "SRFPRJFOLDER";

   @Override
   protected void onPublish(PSSFStyleVer var1) throws Exception {
      this.executeRemoteCall2All("PUBLISHSTYLE", var1);
   }

   @Override
   protected void onImpStyleVer(PSSFStyleVer var1) throws Exception {
      String var2 = DataObject.getStringValue(var1.get("SRFPRJFOLDER"));
      if (StringHelper.isNullOrEmpty(var2)) {
         throw new Exception("当前没有指定项目目录");
      }

      this.get(var1);
      SelectCond var3 = new SelectCond();
      var3.set("PSSFSTYLEID", var1.getPSSFStyleId());
      PSSFCodeTypeService var4 = (PSSFCodeTypeService)ServiceGlobal.getService(PSSFCodeTypeService.class, this.getSessionFactory());
      ArrayList<PSSFCodeType> var5 = var4.select(var3);
      HashMap<String, PSSFCodeType> var6 = new HashMap<String, PSSFCodeType>();

      for (PSSFCodeType var8 : var5) {
         if (DataObject.getBoolValue(var8.getValidFlag(), true)) {
            var6.put(var8.getTypeCode().toUpperCase(), var8);
            var6.put(var8.getPSSFCodeTypeId(), var8);
         }
      }

      HashMap<String, PSSFVerCode> var31 = new HashMap<String, PSSFVerCode>();

      for (PSSFVerCode var10 : var1.getPSSFVerCodes()) {
         PSSFCodeType var11 = (PSSFCodeType)var6.get(var10.getPSSFCodeTypeId());
         if (var11 == null) {
            throw new Exception(StringHelper.format("无法获取服务代码模板[%1$s][%2$s]", var10.getPSSFCodeTypeId(), var10.getPSSFCodeTypeName()));
         }

         var31.put(var11.getTypeCode().toUpperCase(), var10);
      }

      PSSFVerCodeService var33 = (PSSFVerCodeService)ServiceGlobal.getService(PSSFVerCodeService.class, this.getSessionFactory());
      PSSFVerCodeItemService var34 = (PSSFVerCodeItemService)ServiceGlobal.getService(PSSFVerCodeItemService.class, this.getSessionFactory());
      File var35 = new File(var2);
      if (!var35.exists()) {
         var35.mkdirs();
      }

      try {
         File[] var12 = var35.listFiles();

         for (File var16 : var12) {
            if (var16.isDirectory()) {
               String var17 = var16.getName();
               PSSFCodeType var18 = (PSSFCodeType)var6.get(var17.toUpperCase());
               if (var18 == null) {
                  throw new Exception(StringHelper.format("当前服务代码框架[%1$s]不存在代码类型[%2$s]", var1.getPSSFStyleName(), var17.toUpperCase()));
               }

               HashMap<String, File> var19 = new HashMap<String, File>();

               for (File var23 : var16.listFiles()) {
                  if (var23.isFile()) {
                     var19.put(var23.getName().toUpperCase(), var23);
                  }
               }

               String var40 = "";
               if (!StringHelper.isNullOrEmpty(var18.getFileExt())) {
                  var40 = "." + var18.getFileExt();
               }

               File var41 = null;
               if (StringHelper.isNullOrEmpty(var40)) {
                  var41 = (File)var19.remove("MAIN");
               } else {
                  var41 = (File)var19.remove("MAIN" + var40.toUpperCase());
               }

               if (var41 == null) {
                  continue;
               }

               boolean var43 = false;
               PSSFVerCode var45 = (PSSFVerCode)var31.remove(var18.getTypeCode().toUpperCase());
               HashMap<String, PSSFVerCodeItem> var24 = new HashMap<String, PSSFVerCodeItem>();
               if (var45 == null) {
                  var43 = true;
                  var45 = new PSSFVerCode();
                  var45.setPSSFVerCodeName(var18.getPSSFCodeTypeName());
                  var45.setPSSFStyleVerId(var1.getPSSFStyleVerId());
                  var45.setPSSFStyleVerName(var1.getPSSFStyleVerName());
                  var45.setPSSFCodeTypeId(var18.getPSSFCodeTypeId());
                  var45.setPSSFCodeTypeName(var18.getPSSFCodeTypeName());
               }

               String var25 = PSPFStyleService.readFile(var41.getAbsolutePath());
               var45.setCodeTempl(var25);
               var45.setTemplCode2(var25);
               if (var43) {
                  var33.create(var45);
               } else {
                  var33.update(var45);

                  for (PSSFVerCodeItem var28 : var45.getPSSFVerCodeItems()) {
                     var24.put(var28.getPSSFVerCodeItemName().toUpperCase(), var28);
                  }
               }

               for (Entry<String, File> var49 : var19.entrySet()) {
                  String var51 = (String)var49.getKey();
                  if (!StringHelper.isNullOrEmpty(var40)) {
                     if (var51.indexOf(var40.toUpperCase()) != var51.length() - var40.length()) {
                        continue;
                     }

                     var51 = var51.substring(0, var51.length() - var40.length());
                  }

                  var43 = false;
                  PSSFVerCodeItem var29 = (PSSFVerCodeItem)var24.remove(var51);
                  if (var29 == null) {
                     var43 = true;
                     var29 = new PSSFVerCodeItem();
                     var29.setPSSFStyleVerId(var1.getPSSFStyleVerId());
                     var29.setPSSFVerCodeId(var45.getPSSFVerCodeId());
                     var29.setPSSFVerCodeItemName(var51);
                  }

                  var25 = PSPFStyleService.readFile(((File)var49.getValue()).getAbsolutePath());
                  var29.setTemplCode2(var25);
                  var29.setTemplCode(var25);
                  if (var43) {
                     var34.create(var29);
                  } else {
                     var34.update(var29);
                  }
               }

               for (Entry<String, PSSFVerCodeItem> var50 : var24.entrySet()) {
                  var34.remove(var50.getValue());
               }
            }

            for (Entry<String, PSSFVerCode> var39 : var31.entrySet()) {
               var33.remove(var39.getValue());
            }
         }

         String var37 = var1.getPSSFStyleVerId();
         var1.reset();
         var1.setPSSFStyleVerId(var37);
         var1.setLastImpTime(new Timestamp(System.currentTimeMillis()));
         var1.setTemplState(30);
         var1.setTemplInfo(null);
         this.update(var1);
      } catch (Exception var30) {
         String var13 = var1.getPSSFStyleVerId();
         var1.reset();
         var1.setPSSFStyleVerId(var13);
         var1.setTemplInfo(var30.getMessage());
         var1.setTemplState(40);
         this.update(var1);
      }
   }

   @Override
   protected void onExpStyleVer(PSSFStyleVer var1) throws Exception {
      String var2 = DataObject.getStringValue(var1.get("SRFPRJFOLDER"));
      if (StringHelper.isNullOrEmpty(var2)) {
         throw new Exception("当前没有指定项目目录");
      }

      this.get(var1);
      File var3 = new File(var2);
      if (!var3.exists()) {
         var3.mkdirs();
      }

      SelectCond var4 = new SelectCond();
      var4.set("PSSFSTYLEVERID", var1.getPSSFStyleVerId());
      PSSFVerCodeService var5 = (PSSFVerCodeService)ServiceGlobal.getService(PSSFVerCodeService.class, this.getSessionFactory());

      for (PSSFVerCode var8 : var5.select(var4)) {
         PSSFCodeType var9 = var8.getPSSFCodeType();
         String var10 = StringHelper.format("%1$s%2$s%3$s", var2, File.separator, var9.getTypeCode());
         var3 = new File(var10);
         if (!var3.exists()) {
            var3.mkdirs();
         }

         Object var11 = null;
         if (StringHelper.isNullOrEmpty(var9.getFileExt())) {
            var11 = StringHelper.format("%1$s", "MAIN");
         } else {
            var11 = StringHelper.format("%1$s.%2$s", "MAIN", var9.getFileExt());
         }

         String var12 = StringHelper.format("%1$s%2$s%3$s", var10, File.separator, var11);
         PSPFStyleService.writeFile(var12, var8.getTemplCode2());

         for (PSSFVerCodeItem var15 : var8.getPSSFVerCodeItems()) {
            var11 = null;
            if (StringHelper.isNullOrEmpty(var9.getFileExt())) {
               var11 = StringHelper.format("%1$s", var15.getPSSFVerCodeItemName());
            } else {
               var11 = StringHelper.format("%1$s.%2$s", var15.getPSSFVerCodeItemName(), var9.getFileExt());
            }

            var12 = StringHelper.format("%1$s%2$s%3$s", var10, File.separator, var11);
            PSPFStyleService.writeFile(var12, var15.getTemplCode2());
         }
      }
   }

   @Override
   protected void onFixStyleVer(PSSFStyleVer var1) throws Exception {
      this.get(var1);
      ArrayList<PSSFVerCode> var2 = var1.getPSSFVerCodes();
      HashMap<String, PSSFVerCode> var3 = new HashMap<String, PSSFVerCode>();

      for (PSSFVerCode var5 : var2) {
         String var6 = var5.getTypeCode();
         if (DataObject.getBoolValue(var5.getEnableCustomTypeCode(), false)) {
            var6 = var5.getCustomTypeCode();
         }

         var3.put(var6, var5);
      }

      for (PSSFStyle var17 = var1.getPSSFStyle(); var17 != null; var17 = var17.getPPSSFStyle()) {
         for (PSSFCodeFolder var7 : var17.getPSSFCodeFolders()) {
            if (DataObject.getBoolValue(var7.getPubFlag(), false)) {
               for (PSSFCodeType var10 : var7.getPSSFCodeTypes()) {
                  if (!var3.containsKey(var10.getTypeCode()) && DataObject.getBoolValue(var10.getValidFlag(), true)) {
                     PSSFVerCode var11 = new PSSFVerCode();
                     var11.setSessionFactory(this.getSessionFactory());
                     var11.setPSSFStyleVerId(var1.getPSSFStyleVerId());
                     var11.setPSSFStyleVerName(var1.getPSSFStyleVerName());
                     var11.setPSSFVerCodeName(var10.getPSSFCodeTypeName());
                     var11.setPSSFCodeTypeId(var10.getPSSFCodeTypeId());
                     var11.setPSSFCodeTypeName(var10.getPSSFCodeTypeName());
                     var11.setRealPSSFStyleId(var17.getPSSFStyleId());
                     var11.setCustomTypeCode(var10.getTypeCode());
                     var11.setValidFlag(1);
                     var11.setCodeTempl(var10.getCodeTempl());
                     var11.setTemplCode2(var10.getTemplCode2());

                     try {
                        var11.create();

                        for (PSSFCodeTempl var14 : var10.getPSSFCodeTempls()) {
                           if (DataObject.getBoolValue(var14.getValidFlag(), true)) {
                              PSSFVerCodeItem var15 = new PSSFVerCodeItem();
                              var15.setSessionFactory(this.getSessionFactory());
                              var15.setPSSFVerCodeId(var11.getPSSFVerCodeId());
                              var15.setPSSFVerCodeName(var11.getPSSFVerCodeName());
                              var15.setTemplCode(var14.getTemplCode());
                              var15.setTemplCode2(var14.getTemplCode2());
                              var15.setPSSFVerCodeItemName(var14.getPSSFCodeTemplName());
                              var15.create();
                           }
                        }

                        var3.put(var10.getTypeCode(), var11);
                     } catch (Exception var16) {
                        throw new Exception(StringHelper.format("建立系统服务扩展代码模板发生异常，%1$s", var16.getMessage()), var16);
                     }
                  }
               }
            }
         }
      }
   }

   @Override
   public DBFetchResult fetchDefault(IDEDataSetFetchContext var1) throws Exception {
      if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
         PSSFStyleVerService var2 = (PSSFStyleVerService)ServiceGlobal.getService(PSSFStyleVerService.class, PSCoreSysServiceBase.getCurMajorSessionFactory());
         return var2.fetchDefault(var1);
      } else {
         return super.fetchDefault(var1);
      }
   }

   @Override
   public DBFetchResult fetchCurDCAndStyle(IDEDataSetFetchContext var1) throws Exception {
      if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
         PSSFStyleVerService var2 = (PSSFStyleVerService)ServiceGlobal.getService(PSSFStyleVerService.class, PSCoreSysServiceBase.getCurMajorSessionFactory());
         return var2.fetchCurDCAndStyle(var1);
      } else {
         return super.fetchCurDCAndStyle(var1);
      }
   }

   @Override
   public DBFetchResult fetchCurDC(IDEDataSetFetchContext var1) throws Exception {
      if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
         PSSFStyleVerService var2 = (PSSFStyleVerService)ServiceGlobal.getService(PSSFStyleVerService.class, PSCoreSysServiceBase.getCurMajorSessionFactory());
         return var2.fetchCurDC(var1);
      } else {
         return super.fetchCurDC(var1);
      }
   }

   @Override
   public DBFetchResult fetchCurStyle(IDEDataSetFetchContext var1) throws Exception {
      if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
         PSSFStyleVerService var2 = (PSSFStyleVerService)ServiceGlobal.getService(PSSFStyleVerService.class, PSCoreSysServiceBase.getCurMajorSessionFactory());
         return var2.fetchCurStyle(var1);
      } else {
         return super.fetchCurStyle(var1);
      }
   }
}
