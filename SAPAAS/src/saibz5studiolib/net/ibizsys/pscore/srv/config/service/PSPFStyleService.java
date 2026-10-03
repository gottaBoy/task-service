package net.ibizsys.pscore.srv.config.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.codelist.EditorContainersCodeListModel;
import net.ibizsys.pscore.srv.config.entity.PSCtrlType;
import net.ibizsys.pscore.srv.config.entity.PSEditorType;
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFAppTempl;
import net.ibizsys.pscore.srv.config.entity.PSPFCTDetail;
import net.ibizsys.pscore.srv.config.entity.PSPFCodeFolder;
import net.ibizsys.pscore.srv.config.entity.PSPFCtrlTempl;
import net.ibizsys.pscore.srv.config.entity.PSPFEditorTempl;
import net.ibizsys.pscore.srv.config.entity.PSPFPubCode;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.entity.PSPFStyleCode;
import net.ibizsys.pscore.srv.config.entity.PSPFViewTempl;
import net.ibizsys.pscore.srv.config.entity.PSViewType;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSPFStyleService extends PSPFStyleServiceBase {
   private static final Log log = LogFactory.getLog(PSPFStyleService.class);
   public static final String PARAM_PRJFOLDER = "SRFPRJFOLDER";

   protected void onBeforeCreate(PSPFStyle var1) throws Exception {
      if (var1.isPSDevCenterIdDirty() && !StringHelper.isNullOrEmpty(var1.getPSDevCenterId())) {
         var1.setPubMode(2);
         String var2 = StringHelper.format("%1$s@%2$s", var1.getPSDevCenter().getDomainName(), var1.getDCStyleCode());
         var1.setStyleCode(var2.toUpperCase());
      }

      if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory()) && !StringHelper.isNullOrEmpty(var1.getPSDevCenterSVNId())) {
         PSDevCenterSVNService var4 = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, this.getSessionFactory());
         PSDevCenterSVN var3 = new PSDevCenterSVN();
         var3.setPSDevCenterSVNId(var1.getPSDevCenterSVNId());
         var3.setRefObjType("PSPFSTYLE");
         var3.setRefObjId(var1.getPSPFStyleId());
         var3.setRefObjName(var1.getPSPFStyleName());
         var4.bind(var3);
      }

      super.onBeforeCreate(var1);
   }

   protected void onBeforeUpdate(PSPFStyle var1) throws Exception {
      if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory()) && var1.isPSDevCenterSVNIdDirty()) {
         PSPFStyle var2 = this.getLast(var1);
         if (StringHelper.isNullOrEmpty(var1.getPSDevCenterSVNId())) {
            if (!StringHelper.isNullOrEmpty(var2.getPSDevCenterSVNId())) {
               PSDevCenterSVNService var3 = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, this.getSessionFactory());
               PSDevCenterSVN var4 = new PSDevCenterSVN();
               var4.setPSDevCenterSVNId(var2.getPSDevCenterSVNId());
               var4.setRefObjType("PSPFSTYLE");
               var4.setRefObjId(var2.getPSPFStyleId());
               var4.setRefObjName(var2.getPSPFStyleName());
               var3.unbind(var4);
            }
         } else if (StringHelper.compare(var1.getPSDevCenterSVNId(), var2.getPSDevCenterSVNId(), false) != 0) {
            if (!StringHelper.isNullOrEmpty(var2.getPSDevCenterSVNId())) {
               PSDevCenterSVNService var5 = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, this.getSessionFactory());
               PSDevCenterSVN var7 = new PSDevCenterSVN();
               var7.setPSDevCenterSVNId(var2.getPSDevCenterSVNId());
               var7.setRefObjType("PSPFSTYLE");
               var7.setRefObjId(var2.getPSPFStyleId());
               var7.setRefObjName(var2.getPSPFStyleName());
               var5.unbind(var7);
            }

            if (!StringHelper.isNullOrEmpty(var1.getPSDevCenterSVNId())) {
               PSDevCenterSVNService var6 = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, this.getSessionFactory());
               PSDevCenterSVN var8 = new PSDevCenterSVN();
               var8.setPSDevCenterSVNId(var1.getPSDevCenterSVNId());
               var8.setRefObjType("PSPFSTYLE");
               var8.setRefObjId(var1.getPSPFStyleId());
               if (StringHelper.isNullOrEmpty(var1.getPSPFStyleName())) {
                  var8.setRefObjName(var2.getPSPFStyleName());
               } else {
                  var8.setRefObjName(var1.getPSPFStyleName());
               }

               var6.bind(var8);
            }
         }
      }

      super.onBeforeUpdate(var1);
   }

   @Override
   protected void onBeforeRemove(PSPFStyle var1) throws Exception {
      if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
         PSPFStyle var2 = this.getLast(var1);
         if (StringHelper.isNullOrEmpty(var1.getPSDevCenterSVNId()) && !StringHelper.isNullOrEmpty(var2.getPSDevCenterSVNId())) {
            PSDevCenterSVNService var3 = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, this.getSessionFactory());
            PSDevCenterSVN var4 = new PSDevCenterSVN();
            var4.setPSDevCenterSVNId(var2.getPSDevCenterSVNId());
            var4.setRefObjType("PSPFSTYLE");
            var4.setRefObjId(var2.getPSPFStyleId());
            var4.setRefObjName(var2.getPSPFStyleName());
            var3.unbind(var4);
         }
      }

      super.onBeforeRemove(var1);
   }

   @Override
   protected void onPublish(PSPFStyle var1) throws Exception {
      this.executeRemoteCall2All("PUBLISHSTYLE", var1);
   }

   @Override
   protected void onCheckEntity(boolean var1, PSPFStyle var2, boolean var3, boolean var4, EntityError var5) throws Exception {
      if (!var1) {
         for (PSPFStyle var6 = var2.getTemplPSPFStyle(); var6 != null; var6 = var6.getTemplPSPFStyle()) {
            if (StringHelper.compare(var6.getPSPFStyleId(), var2.getPSPFStyleId(), false) == 0) {
               throw new Exception("模板样式存在递归");
            }
         }
      }

      super.onCheckEntity(var1, var2, var3, var4, var5);
   }

   @Override
   protected void onImpStyle(PSPFStyle var1) throws Exception {
      String var2 = DataObject.getStringValue(var1.get("SRFPRJFOLDER"));
      if (StringHelper.isNullOrEmpty(var2)) {
         throw new Exception("当前没有指定项目目录");
      }

      this.get(var1);
      PSPF var3 = var1.getPSPF();
      ArrayList<PSPFPubCode> var4 = var3.getPSPFPubCodes();
      HashMap<String, PSPFPubCode> var5 = new HashMap<>();
      HashMap<String, PSPFPubCode> var6 = new HashMap<>();

      for (PSPFPubCode var8 : var4) {
         var5.put(var8.getPSPFPubCodeId(), var8);
         if (StringHelper.compare(var8.getTargetType(), "VIEW", false) == 0) {
            var6.put(StringHelper.format("%1$s%2$s", var8.getPSPFPubCodeName(), var8.getCodeEXT()).toUpperCase(), var8);
         }
      }

      try {
         PSPFStyleCodeService var39 = (PSPFStyleCodeService)ServiceGlobal.getService(PSPFStyleCodeService.class, this.getSessionFactory());
         ArrayList<PSPFStyleCode> var45 = var1.getPSPFStyleCodes();
         HashMap<String, PSPFStyleCode> var9 = new HashMap<>();

         for (PSPFStyleCode var11 : var45) {
            var9.put(var11.getPSPFStyleCodeName().toUpperCase(), var11);
         }

         String var52 = StringHelper.format("%1$s%2$smacro", var2, File.separator);
         File var56 = new File(var52);
         if (!var56.exists()) {
            var56.mkdirs();
         }

         File var12 = new File(var52);
         File[] var13 = var12.listFiles();

         for (File var17 : var13) {
            if (var17.isFile()) {
               String var18 = var17.getName().toUpperCase();
               if (var18.indexOf(".TXT") == var18.length() - 4) {
                  String var19 = readFile(var17.getAbsolutePath());
                  String var20 = var18.substring(0, var18.length() - 4);
                  PSPFStyleCode var21 = (PSPFStyleCode)var9.get(var20);
                  if (var21 != null) {
                     var9.remove(var20);
                     if (StringHelper.compare(var19, var21.getStyleCode(), false) != 0) {
                        var21.setStyleCode(var19);
                        EntityBase.setIgnoreCheck(var21, false);
                        var39.update(var21);
                     }
                  } else {
                     var21 = new PSPFStyleCode();
                     var21.setStyleCode(var19);
                     var21.setPSPFStyleId(var1.getPSPFStyleId());
                     var21.setPSPFStyleName(var1.getPSPFStyleName());
                     var21.setPSPFStyleCodeName(var20);
                     EntityBase.setIgnoreCheck(var21, false);
                     var39.create(var21);
                  }
               }
            }
         }

         for (Entry<String, PSPFStyleCode> var76 : var9.entrySet()) {
            log.debug(StringHelper.format("移除样式宏数据[%1$s]", var76.getValue().getPSPFStyleCodeName()));
            var39.remove(var76.getValue());
         }

         PSViewTypeService var40 = (PSViewTypeService)ServiceGlobal.getService(PSViewTypeService.class, this.getSessionFactory());
         PSPFViewTemplService var46 = (PSPFViewTemplService)ServiceGlobal.getService(PSPFViewTemplService.class, this.getSessionFactory());
         ArrayList<PSPFViewTempl> var49 = var1.getPSPFViewTempls();
         HashMap<String, PSPFViewTempl> var53 = new HashMap<>();

         for (PSPFViewTempl var62 : var49) {
            var53.put(var62.getPSPFViewTemplId(), var62);
         }

         String var58 = StringHelper.format("%1$s%2$sview", var2, File.separator);
         var12 = new File(var58);
         if (!var12.exists()) {
            var12.mkdirs();
         }

         File var68 = new File(var58);
         File[] var73 = var68.listFiles();

         for (File var92 : var73) {
            if (var92.isDirectory()) {
               String var95 = var92.getName();
               PSViewType var98 = new PSViewType();
               var98.setPSViewTypeId(var95);
               if (!var40.get(var98, true)) {
                  throw new Exception(StringHelper.format("云平台不存在视图类型[%1$s]", var95));
               }

               HashMap<String, File> var102 = new HashMap<>();

               for (File var25 : var92.listFiles()) {
                  if (var25.isFile()) {
                     var102.put(var25.getName().toUpperCase(), var25);
                  }
               }

               for (Entry<String, PSPFPubCode> var108 : var6.entrySet()) {
                  File var112 = (File)var102.get(var108.getKey());
                  String var116 = "";
                  if (var112 != null) {
                     var116 = readFile(var112.getAbsolutePath());
                  }

                  PSPFViewTempl var26 = new PSPFViewTempl();
                  var26.setPSPFId(var3.getPSPFId());
                  var26.setPSPFName(var3.getPSPFName());
                  var26.setPSPFPubCodeId(((PSPFPubCode)var108.getValue()).getPSPFPubCodeId());
                  var26.setPSPFPubCodeName(((PSPFPubCode)var108.getValue()).getPSPFPubCodeName());
                  var26.setPSPFStyleId(var1.getPSPFStyleId());
                  var26.setPSPFStyleName(var1.getPSPFStyleName());
                  var26.setPSViewTypeId(var98.getPSViewTypeId());
                  var26.setPSViewTypeName(var98.getPSViewTypeName());
                  var26.setTemplCode2(var116);
                  var46.fillEntityKeyValue(var26, false);
                  if (var46.checkKey(var26) != 0) {
                     EntityBase.setIgnoreCheck(var26, false);
                     var46.update(var26);
                  } else {
                     for (PSPFStyle var27 = var1.getTemplPSPFStyle(); var27 != null; var27 = var27.getTemplPSPFStyle()) {
                        PSPFViewTempl var28 = new PSPFViewTempl();
                        var28.setPSPFId(var3.getPSPFId());
                        var28.setPSPFName(var3.getPSPFName());
                        var28.setPSPFPubCodeId(((PSPFPubCode)var108.getValue()).getPSPFPubCodeId());
                        var28.setPSPFPubCodeName(((PSPFPubCode)var108.getValue()).getPSPFPubCodeName());
                        var28.setPSPFStyleId(var27.getPSPFStyleId());
                        var28.setPSPFStyleName(var27.getPSPFStyleName());
                        var28.setPSViewTypeId(var98.getPSViewTypeId());
                        var28.setPSViewTypeName(var98.getPSViewTypeName());
                        var46.fillEntityKeyValue(var28, false);
                        if (var46.get(var28, true)) {
                           var26.setPubObj(var28.getPubObj());
                           var26.setLogicName(var28.getLogicName());
                           break;
                        }
                     }

                     EntityBase.setIgnoreCheck(var26, false);
                     var46.create(var26);
                  }

                  var53.remove(var26.getPSPFViewTemplId());
               }
            }
         }

         for (Entry<String, PSPFViewTempl> var83 : var53.entrySet()) {
            log.debug(StringHelper.format("移除视图模板[%1$s]", var83.getValue().getPSPFViewTemplName()));
            var46.remove(var83.getValue());
         }

         PSCtrlTypeService var41 = (PSCtrlTypeService)ServiceGlobal.getService(PSCtrlTypeService.class, this.getSessionFactory());
         PSPFCtrlTemplService var47 = (PSPFCtrlTemplService)ServiceGlobal.getService(PSPFCtrlTemplService.class, this.getSessionFactory());
         PSPFCTDetailService var50 = (PSPFCTDetailService)ServiceGlobal.getService(PSPFCTDetailService.class, this.getSessionFactory());
         ArrayList<PSPFCtrlTempl> var54 = var1.getPSPFCtrlTempls();
         HashMap<String, PSPFCtrlTempl> var59 = new HashMap<>();

         for (PSPFCtrlTempl var69 : var54) {
            var59.put(var69.getPSPFCtrlTemplId(), var69);
         }

         String var65 = StringHelper.format("%1$s%2$sctrl", var2, File.separator);
         File var70 = new File(var65);
         if (!var70.exists()) {
            var70.mkdirs();
         }

         File var74 = new File(var65);
         File[] var79 = var74.listFiles();

         for (File var96 : var79) {
            if (var96.isDirectory()) {
               String var99 = var96.getName();
               PSCtrlType var103 = new PSCtrlType();
               var103.setPSCtrlTypeId(var99);
               if (!var41.get(var103, true)) {
                  throw new Exception(StringHelper.format("云平台不存在部件类型[%1$s]", var99));
               }

               HashMap<String, File> var106 = new HashMap<>();

               for (File var121 : var96.listFiles()) {
                  if (var121.isFile()) {
                     var106.put(var121.getName().toUpperCase(), var121);
                  }
               }

               for (Entry<String, PSPFPubCode> var114 : var6.entrySet()) {
                  String var118 = "";
                  String var122 = "";
                  String var125 = "";
                  String var129 = "";
                  File var29 = (File)var106.remove(var114.getKey());
                  if (var29 != null) {
                     var118 = readFile(var29.getAbsolutePath());
                  }

                  var29 = (File)var106.remove(
                     StringHelper.format("%1$s_CODE2%2$s", ((PSPFPubCode)var114.getValue()).getPSPFPubCodeName(), ((PSPFPubCode)var114.getValue()).getCodeEXT())
                        .toUpperCase()
                  );
                  if (var29 != null) {
                     var122 = readFile(var29.getAbsolutePath());
                  }

                  var29 = (File)var106.remove(
                     StringHelper.format("%1$s_CODE3%2$s", ((PSPFPubCode)var114.getValue()).getPSPFPubCodeName(), ((PSPFPubCode)var114.getValue()).getCodeEXT())
                        .toUpperCase()
                  );
                  if (var29 != null) {
                     var125 = readFile(var29.getAbsolutePath());
                  }

                  var29 = (File)var106.remove(
                     StringHelper.format("%1$s_CODE4%2$s", ((PSPFPubCode)var114.getValue()).getPSPFPubCodeName(), ((PSPFPubCode)var114.getValue()).getCodeEXT())
                        .toUpperCase()
                  );
                  if (var29 != null) {
                     var129 = readFile(var29.getAbsolutePath());
                  }

                  if (!StringHelper.isNullOrEmpty(var118)
                     || !StringHelper.isNullOrEmpty(var122)
                     || !StringHelper.isNullOrEmpty(var125)
                     || !StringHelper.isNullOrEmpty(var129)) {
                     PSPFCtrlTempl var30 = new PSPFCtrlTempl();
                     var30.setPSPFId(var3.getPSPFId());
                     var30.setPSPFName(var3.getPSPFName());
                     var30.setPSPFPubCodeId(((PSPFPubCode)var114.getValue()).getPSPFPubCodeId());
                     var30.setPSPFPubCodeName(((PSPFPubCode)var114.getValue()).getPSPFPubCodeName());
                     var30.setPSPFStyleId(var1.getPSPFStyleId());
                     var30.setPSPFStyleName(var1.getPSPFStyleName());
                     var30.setPSCtrlTypeId(var103.getPSCtrlTypeId());
                     var30.setPSCtrlTypeName(var103.getPSCtrlTypeName());
                     var30.setTemplCode(var118);
                     var30.setTemplCode2(var122);
                     var30.setTemplCode3(var125);
                     var30.setTemplCode4(var129);
                     var47.fillEntityKeyValue(var30, false);
                     boolean var31 = false;
                     ArrayList<PSPFCTDetail> var32 = null;
                     if (var47.checkKey(var30) != 0) {
                        EntityBase.setIgnoreCheck(var30, false);
                        var47.update(var30);
                        var32 = var30.getPSPFCTDetails();
                     } else {
                        for (PSPFStyle var33 = var1.getTemplPSPFStyle(); var33 != null; var33 = var33.getTemplPSPFStyle()) {
                           PSPFCtrlTempl var34 = new PSPFCtrlTempl();
                           var34.setPSPFId(var3.getPSPFId());
                           var34.setPSPFName(var3.getPSPFName());
                           var34.setPSPFPubCodeId(((PSPFPubCode)var114.getValue()).getPSPFPubCodeId());
                           var34.setPSPFPubCodeName(((PSPFPubCode)var114.getValue()).getPSPFPubCodeName());
                           var34.setPSPFStyleId(var33.getPSPFStyleId());
                           var34.setPSPFStyleName(var33.getPSPFStyleName());
                           var34.setPSCtrlTypeId(var103.getPSCtrlTypeId());
                           var34.setPSCtrlTypeName(var103.getPSCtrlTypeName());
                           var47.fillEntityKeyValue(var34, false);
                           if (var47.get(var34, true)) {
                              var30.setPubObj(var34.getPubObj());
                              var30.setLogicName(var34.getLogicName());
                              var32 = var30.getPSPFCTDetails();
                              break;
                           }
                        }

                        EntityBase.setIgnoreCheck(var30, false);
                        var47.create(var30);
                        var31 = true;
                     }

                     var59.remove(var30.getPSPFCtrlTemplId());
                     if (var32 != null) {
                        for (PSPFCTDetail var151 : var32) {
                           if (var31) {
                              var151.setPSPFCtrlTemplId(var30.getPSPFCtrlTemplId());
                              var151.setPSPFCtrlTemplName(var30.getPSPFCtrlTemplName());
                              var151.resetPSPFCTDetailId();
                           }

                           var118 = "";
                           var122 = "";
                           var125 = "";
                           var129 = "";
                           var29 = (File)var106.remove(
                              StringHelper.format(
                                    "%1$s_%3$s%2$s",
                                    ((PSPFPubCode)var114.getValue()).getPSPFPubCodeName(),
                                    ((PSPFPubCode)var114.getValue()).getCodeEXT(),
                                    var151.getPSPFCTDetailName()
                                 )
                                 .toUpperCase()
                           );
                           if (var29 != null) {
                              var118 = readFile(var29.getAbsolutePath());
                           }

                           var29 = (File)var106.remove(
                              StringHelper.format(
                                    "%1$s_%3$s_CODE2%2$s",
                                    ((PSPFPubCode)var114.getValue()).getPSPFPubCodeName(),
                                    ((PSPFPubCode)var114.getValue()).getCodeEXT(),
                                    var151.getPSPFCTDetailName()
                                 )
                                 .toUpperCase()
                           );
                           if (var29 != null) {
                              var122 = readFile(var29.getAbsolutePath());
                           }

                           var29 = (File)var106.remove(
                              StringHelper.format(
                                    "%1$s_%3$s_CODE3%2$s",
                                    ((PSPFPubCode)var114.getValue()).getPSPFPubCodeName(),
                                    ((PSPFPubCode)var114.getValue()).getCodeEXT(),
                                    var151.getPSPFCTDetailName()
                                 )
                                 .toUpperCase()
                           );
                           if (var29 != null) {
                              var125 = readFile(var29.getAbsolutePath());
                           }

                           var29 = (File)var106.remove(
                              StringHelper.format(
                                    "%1$s_%3$s_CODE4%2$s",
                                    ((PSPFPubCode)var114.getValue()).getPSPFPubCodeName(),
                                    ((PSPFPubCode)var114.getValue()).getCodeEXT(),
                                    var151.getPSPFCTDetailName()
                                 )
                                 .toUpperCase()
                           );
                           if (var29 != null) {
                              var129 = readFile(var29.getAbsolutePath());
                           }

                           var151.setTemplCode(var118);
                           var151.setTemplCode2(var122);
                           var151.setTemplCode3(var125);
                           var151.setTemplCode4(var129);
                           if (var31) {
                              EntityBase.setIgnoreCheck(var151, false);
                              var50.create(var151);
                           } else {
                              EntityBase.setIgnoreCheck(var151, false);
                              var50.update(var151);
                           }
                        }
                     }
                  }
               }
            }
         }

         for (Entry<String, PSPFCtrlTempl> var90 : var59.entrySet()) {
            log.debug(StringHelper.format("移除部件模板[%1$s]", var90.getValue().getPSPFCtrlTemplName()));
            var47.remove(var90.getValue());
         }

         PSEditorTypeService var42 = (PSEditorTypeService)ServiceGlobal.getService(PSEditorTypeService.class, this.getSessionFactory());
         PSPFEditorTemplService var48 = (PSPFEditorTemplService)ServiceGlobal.getService(PSPFEditorTemplService.class, this.getSessionFactory());
         ArrayList<PSPFEditorTempl> var51 = var1.getPSPFEditorTempls();
         HashMap<String, PSPFEditorTempl> var55 = new HashMap<>();

         for (PSPFEditorTempl var66 : var51) {
            var55.put(var66.getPSPFEditorTemplId(), var66);
         }

         String var61 = StringHelper.format("%1$s%2$seditor", var2, File.separator);
         var12 = new File(var61);
         if (!var12.exists()) {
            var12.mkdirs();
         }

         File var71 = new File(var61);
         var73 = var71.listFiles();

         for (File var94 : var73) {
            if (var94.isDirectory()) {
               String var97 = var94.getName();
               PSEditorType var100 = new PSEditorType();
               var100.setPSEditorTypeId(var97);
               if (!var42.get(var100, true)) {
                  throw new Exception(StringHelper.format("云平台不存在编辑器类型[%1$s]", var97));
               }

               for (File var115 : var94.listFiles()) {
                  if (var115.isDirectory()) {
                     String var120 = var115.getName();
                     if (StringHelper.compare(var120, "FORMITEM", false) != 0 && StringHelper.compare(var120, "GRIDCOLUMN", false) != 0) {
                        throw new Exception(StringHelper.format("云平台不存在编辑器应用场合类型[%1$s]", var115.getName()));
                     }

                     HashMap<String, File> var124 = new HashMap<>();

                     for (File var142 : var115.listFiles()) {
                        if (var142.isFile()) {
                           var124.put(var142.getName().toUpperCase(), var142);
                        }
                     }

                     for (Entry<String, PSPFPubCode> var132 : var6.entrySet()) {
                        String var141 = "";
                        String var143 = "";
                        String var144 = "";
                        String var145 = "";
                        File var147 = (File)var124.remove(var132.getKey());
                        if (var147 != null) {
                           var141 = readFile(var147.getAbsolutePath());
                        }

                        var147 = (File)var124.remove(
                           StringHelper.format(
                                 "%1$s_CODE2%2$s", ((PSPFPubCode)var132.getValue()).getPSPFPubCodeName(), ((PSPFPubCode)var132.getValue()).getCodeEXT()
                              )
                              .toUpperCase()
                        );
                        if (var147 != null) {
                           var143 = readFile(var147.getAbsolutePath());
                        }

                        var147 = (File)var124.remove(
                           StringHelper.format(
                                 "%1$s_CODE3%2$s", ((PSPFPubCode)var132.getValue()).getPSPFPubCodeName(), ((PSPFPubCode)var132.getValue()).getCodeEXT()
                              )
                              .toUpperCase()
                        );
                        if (var147 != null) {
                           var144 = readFile(var147.getAbsolutePath());
                        }

                        var147 = (File)var124.remove(
                           StringHelper.format(
                                 "%1$s_CODE4%2$s", ((PSPFPubCode)var132.getValue()).getPSPFPubCodeName(), ((PSPFPubCode)var132.getValue()).getCodeEXT()
                              )
                              .toUpperCase()
                        );
                        if (var147 != null) {
                           var145 = readFile(var147.getAbsolutePath());
                        }

                        if (!StringHelper.isNullOrEmpty(var141)
                           || !StringHelper.isNullOrEmpty(var143)
                           || !StringHelper.isNullOrEmpty(var144)
                           || !StringHelper.isNullOrEmpty(var145)) {
                           PSPFEditorTempl var152 = new PSPFEditorTempl();
                           var152.setPSPFId(var3.getPSPFId());
                           var152.setPSPFName(var3.getPSPFName());
                           var152.setPSPFPubCodeId(((PSPFPubCode)var132.getValue()).getPSPFPubCodeId());
                           var152.setPSPFPubCodeName(((PSPFPubCode)var132.getValue()).getPSPFPubCodeName());
                           var152.setPSPFStyleId(var1.getPSPFStyleId());
                           var152.setPSPFStyleName(var1.getPSPFStyleName());
                           var152.setContainerType(var120);
                           var152.setPSEditorTypeId(var100.getPSEditorTypeId());
                           var152.setPSEditorTypeName(var100.getPSEditorTypeName());
                           var152.set("PSDEVCENTERID", var1.getPSDevCenterId());
                           var152.set("PSDEVCENTERNAME", var1.getPSDevCenterName());
                           var152.setTemplCode(var141);
                           var152.setTemplCode2(var143);
                           var152.setTemplCode3(var144);
                           var152.setTemplCode4(var145);
                           var48.fillEntityKeyValue(var152, false);
                           boolean var35 = false;
                           if (var48.checkKey(var152) != 0) {
                              EntityBase.setIgnoreCheck(var152, false);
                              var48.update(var152);
                           } else {
                              for (PSPFStyle var36 = var1.getTemplPSPFStyle(); var36 != null; var36 = var36.getTemplPSPFStyle()) {
                                 PSPFEditorTempl var37 = new PSPFEditorTempl();
                                 var37.setPSPFId(var3.getPSPFId());
                                 var37.setPSPFName(var3.getPSPFName());
                                 var37.setPSPFPubCodeId(((PSPFPubCode)var132.getValue()).getPSPFPubCodeId());
                                 var37.setPSPFPubCodeName(((PSPFPubCode)var132.getValue()).getPSPFPubCodeName());
                                 var37.setPSPFStyleId(var36.getPSPFStyleId());
                                 var37.setPSPFStyleName(var36.getPSPFStyleName());
                                 var37.setPSEditorTypeId(var100.getPSEditorTypeId());
                                 var37.setPSEditorTypeName(var100.getPSEditorTypeName());
                                 var37.setContainerType(var120);
                                 var48.fillEntityKeyValue(var37, false);
                                 if (var48.get(var37, true)) {
                                    var152.setPubObj(var37.getPubObj());
                                    var152.setLogicName(var37.getLogicName());
                                    break;
                                 }
                              }

                              EntityBase.setIgnoreCheck(var152, false);
                              var48.create(var152);
                              var35 = true;
                           }

                           var55.remove(var152.getPSPFEditorTemplId());
                        }
                     }
                  }
               }
            }
         }

         for (Entry<String, PSPFEditorTempl> var87 : var55.entrySet()) {
            log.debug(StringHelper.format("移除编辑器模板[%1$s]", var87.getValue().getPSPFEditorTemplName()));
            var48.remove(var87.getValue());
         }

         String var43 = var1.getPSPFStyleId();
         var1.reset();
         var1.setPSPFStyleId(var43);
         var1.setLastImpTime(new Timestamp(System.currentTimeMillis()));
         var1.setTemplState(30);
         var1.setTemplInfo(null);
         this.mergeCode(var1);
         this.update(var1);
      } catch (Exception var38) {
         String var44 = var1.getPSPFStyleId();
         var1.reset();
         var1.setPSPFStyleId(var44);
         var1.setTemplInfo(var38.getMessage());
         var1.setTemplState(40);
         this.update(var1);
      }
   }

   @Override
   protected void onExpStyle(PSPFStyle var1) throws Exception {
      String var2 = DataObject.getStringValue(var1.get("SRFPRJFOLDER"));
      if (StringHelper.isNullOrEmpty(var2)) {
         throw new Exception("当前没有指定项目目录");
      }

      this.get(var1);
      PSPF var3 = var1.getPSPF();
      ArrayList<PSPFPubCode> var4 = var3.getPSPFPubCodes();
      HashMap<String, PSPFPubCode> var5 = new HashMap<>();

      for (PSPFPubCode var7 : var4) {
         if (DataObject.getBoolValue(var7.getValidFlag(), true)) {
            var5.put(var7.getPSPFPubCodeId(), var7);
         }
      }

      SelectCond var36 = new SelectCond();
      var36.set("PSPFID", var3.getPSPFId());
      PSPFCodeFolderService var37 = (PSPFCodeFolderService)ServiceGlobal.getService(PSPFCodeFolderService.class, this.getSessionFactory());
      ArrayList<PSPFCodeFolder> var8 = var37.select(var36);
      HashMap<String, PSPFCodeFolder> var9 = new HashMap<>();

      for (PSPFCodeFolder var11 : var8) {
         var9.put(var11.getPSPFCodeFolderId(), var11);
      }

      PSEditorTypeService var38 = (PSEditorTypeService)ServiceGlobal.getService(PSEditorTypeService.class, this.getSessionFactory());
      PSCtrlTypeService var39 = (PSCtrlTypeService)ServiceGlobal.getService(PSCtrlTypeService.class, this.getSessionFactory());
      PSViewTypeService var12 = (PSViewTypeService)ServiceGlobal.getService(PSViewTypeService.class, this.getSessionFactory());
      var36.reset();
      boolean var13 = true;
      if (var13) {
         HashMap<String, String> var14 = new HashMap<>();
         ArrayList<PSPFStyleCode> var15 = var1.getPSPFStyleCodes();
         String var16 = StringHelper.format("%1$s%2$s@MACRO", var2, File.separator);
         File var17 = new File(var16);
         if (!var17.exists()) {
            var17.mkdirs();
         }

         File var18 = new File(var16);
         File[] var19 = var18.listFiles();
         HashMap<String, File> var20 = new HashMap<>();

         for (File var24 : var19) {
            if (var24.isFile()) {
               var20.put(var24.getName().toUpperCase(), var24);
            }
         }

         HashMap<String, String> var106 = new HashMap<>();

         for (PSPFStyleCode var146 : var15) {
            String var164 = StringHelper.format("<#SRFINC(%1$s)>", var146.getPSPFStyleCodeName().toUpperCase());
            String var25 = StringHelper.format("<#ibizinclude>../../@MACRO/%1$s.ftl</#ibizinclude>", var146.getPSPFStyleCodeName().toUpperCase());
            String var26 = StringHelper.format("<#ibizinclude>%1$s.ftl</#ibizinclude>", var146.getPSPFStyleCodeName().toUpperCase());
            var14.put(var164, var25);
            var106.put(var164, var26);
         }

         for (PSPFStyleCode var147 : var15) {
            String var165 = StringHelper.format("%1$s.ftl", var147.getPSPFStyleCodeName().toUpperCase());
            String var191 = StringHelper.format("%1$s%2$s%3$s", var16, File.separator, var165);
            String var219 = var147.getStyleCode();

            for (Entry<String, String> var28 : var106.entrySet()) {
               var219 = var219.replace((CharSequence)var28.getKey(), (CharSequence)var28.getValue());
            }

            writeFile(var191, var219);
            var20.remove(var165.toUpperCase());
         }

         for (Entry<String, File> var148 : var20.entrySet()) {
            log.debug(StringHelper.format("移除文件[%1$s]", ((File)var148.getValue()).getAbsolutePath()));
         }

         ArrayList<PSPFViewTempl> var15View = var1.getPSPFViewTempls();
         var16 = StringHelper.format("%1$s%2$s@VIEW", var2, File.separator);
         var17 = new File(var16);
         if (!var17.exists()) {
            var17.mkdirs();
         }

         var18 = new File(var16);
         var19 = var18.listFiles();
         var20 = new HashMap<>();

         for (File var166 : var19) {
            if (var166.isDirectory()) {
               for (File var256 : var166.listFiles()) {
                  var20.put(StringHelper.format("%1$s%2$s%3$s", var166.getName(), File.separator, var256.getName().toUpperCase()), var256);
               }
            }
         }

         for (PSPFViewTempl var131 : var15View) {
            String var150 = StringHelper.format("%1$s%2$s%3$s", var16, File.separator, var131.getPSViewTypeName());
            var17 = new File(var150);
            if (!var17.exists()) {
               var17.mkdirs();
            }

            StringBuilderEx var167 = new StringBuilderEx();
            if (var131.getPSViewTypeId().indexOf("APP") == 0) {
               var167.append("VIEWTYPE=%1$s", var131.getPSViewTypeId());
            } else {
               var167.append("VIEWTYPE=APP%1$s", var131.getPSViewTypeId());
            }

            String var193 = StringHelper.format("%1$s%2$s%3$s", var150, File.separator, "template.properties");
            writeFile(var193, var167.toString());
            PSPFPubCode var168 = (PSPFPubCode)var5.get(var131.getPSPFPubCodeId());
            if (var168 != null) {
               var193 = var168.getCodeEXT();
               if (!StringHelper.isNullOrEmpty(var193)) {
                  String[] var221 = var193.split("[.]");
                  var193 = "." + var221[var221.length - 1];
               }

               var193 = "";
               String var222 = StringHelper.format("%1$s%2$s.ftl", var168.getPSPFPubCodeName(), var193);
               String var238 = StringHelper.format("%1$s%2$s%3$s", var150, File.separator, var222);
               String var257 = var131.getTemplCode2();
               if (StringHelper.isNullOrEmpty(var257)) {
                  var257 = "";
               }

               for (Entry<String, String> var30 : var14.entrySet()) {
                  var257 = var257.replace((CharSequence)var30.getKey(), (CharSequence)var30.getValue());
               }

               if (!StringHelper.isNullOrEmpty(var131.getPubObj())) {
                  StringBuilderEx var272 = new StringBuilderEx();
                  String var288 = var131.getPubObj();
                  var288 = var288.replace("SA.SRFDA.PS.Core.Pub.", "");
                  var288 = var288.replace("PublisherImpl", "");
                  var272.append("<#ibiztemplate>\r\n");
                  var272.append("PUBOBJ=%1$s\r\n", var288);
                  var272.append("</#ibiztemplate>\r\n");
                  var272.append(var257);
                  var257 = var272.toString();
               }

               writeFile(var238, var257);
               var20.remove(StringHelper.format("%1$s%2$s%3$s", var150, File.separator, var222.toUpperCase()));
            }
         }

         for (Entry<String, File> var132 : var20.entrySet()) {
            log.debug(StringHelper.format("移除文件[%1$s]", ((File)var132.getValue()).getAbsolutePath()));
         }

         ArrayList<PSPFCtrlTempl> var15Ctrl = var1.getPSPFCtrlTempls();
         var16 = StringHelper.format("%1$s%2$s@CONTROL", var2, File.separator);
         var17 = new File(var16);
         if (!var17.exists()) {
            var17.mkdirs();
         }

         var18 = new File(var16);
         var19 = var18.listFiles();
         var20 = new HashMap<>();

         for (File var169 : var19) {
            if (var169.isDirectory()) {
               for (File var258 : var169.listFiles()) {
                  var20.put(StringHelper.format("%1$s%2$s%3$s", var169.getName(), File.separator, var258.getName().toUpperCase()), var258);
               }
            }
         }

         for (PSPFCtrlTempl var134 : var15Ctrl) {
            String var152 = StringHelper.format("%1$s%2$s%3$s", var16, File.separator, var134.getPSCtrlTypeName());
            var17 = new File(var152);
            if (!var17.exists()) {
               var17.mkdirs();
            }

            StringBuilderEx var170 = new StringBuilderEx();
            var170.append("CTRLTYPE=%1$s", var134.getPSCtrlTypeId());
            String var198 = StringHelper.format("%1$s%2$s%3$s", var152, File.separator, "template.properties");
            writeFile(var198, var170.toString());
            PSPFPubCode var171 = (PSPFPubCode)var5.get(var134.getPSPFPubCodeId());
            if (var171 != null) {
               var198 = var171.getCodeEXT();
               if (!StringHelper.isNullOrEmpty(var198)) {
                  String[] var224 = var198.split("[.]");
                  var198 = "." + var224[var224.length - 1];
               }

               var198 = "";
               String var225 = StringHelper.format("%1$s%2$s.ftl", var171.getPSPFPubCodeName(), var198);
               String var240 = StringHelper.format("%1$s%2$s%3$s", var152, File.separator, var225);
               String var259 = var134.getTemplCode();
               if (StringHelper.isNullOrEmpty(var259)) {
                  var259 = "";
               }

               for (Entry<String, String> var291 : var14.entrySet()) {
                  var259 = var259.replace((CharSequence)var291.getKey(), (CharSequence)var291.getValue());
               }

               if (!StringHelper.isNullOrEmpty(var134.getPubObj())) {
                  StringBuilderEx var274 = new StringBuilderEx();
                  String var292 = var134.getPubObj();
                  var292 = var292.replace("SA.SRFDA.PS.Core.Pub.", "");
                  var292 = var292.replace("PublisherImpl", "");
                  var274.append("<#ibiztemplate>\r\n");
                  var274.append("PUBOBJ=%1$s\r\n", var292);
                  var274.append("</#ibiztemplate>\r\n");
                  var274.append(var259);
                  var259 = var274.toString();
               }

               writeFile(var240, var259);
               var20.remove(StringHelper.format("%1$s%2$s%3$s", var152, File.separator, var225.toUpperCase()));
               if (!StringHelper.isNullOrEmpty(var134.getTemplCode2())) {
                  var225 = StringHelper.format("%1$s%2$s#CODE2.ftl", var171.getPSPFPubCodeName(), var198);
                  var240 = StringHelper.format("%1$s%2$s%3$s", var152, File.separator, var225);
                  var259 = var134.getTemplCode2();

                  for (Entry<String, String> var295 : var14.entrySet()) {
                     var259 = var259.replace((CharSequence)var295.getKey(), (CharSequence)var295.getValue());
                  }

                  writeFile(var240, var259);
                  var20.remove(StringHelper.format("%1$s%2$s%3$s", var152, File.separator, var225.toUpperCase()));
               }

               if (!StringHelper.isNullOrEmpty(var134.getTemplCode3())) {
                  var225 = StringHelper.format("%1$s%2$s#CODE3.ftl", var171.getPSPFPubCodeName(), var198);
                  var240 = StringHelper.format("%1$s%2$s%3$s", var152, File.separator, var225);
                  var259 = var134.getTemplCode3();

                  for (Entry<String, String> var296 : var14.entrySet()) {
                     var259 = var259.replace((CharSequence)var296.getKey(), (CharSequence)var296.getValue());
                  }

                  writeFile(var240, var259);
                  var20.remove(StringHelper.format("%1$s%2$s%3$s", var152, File.separator, var225.toUpperCase()));
               }

               if (!StringHelper.isNullOrEmpty(var134.getTemplCode4())) {
                  var225 = StringHelper.format("%1$s%2$s#CODE4.ftl", var171.getPSPFPubCodeName(), var198);
                  var240 = StringHelper.format("%1$s%2$s%3$s", var152, File.separator, var225);
                  var259 = var134.getTemplCode4();

                  for (Entry<String, String> var297 : var14.entrySet()) {
                     var259 = var259.replace((CharSequence)var297.getKey(), (CharSequence)var297.getValue());
                  }

                  writeFile(var240, var259);
                  var20.remove(StringHelper.format("%1$s%2$s%3$s", var152, File.separator, var225.toUpperCase()));
               }

               for (PSPFCTDetail var263 : var134.getPSPFCTDetails()) {
                  if (DataObject.getBoolValue(var263.getValidFlag(), true)) {
                     String var278 = StringHelper.format("%1$s%2$s#%3$s.ftl", var171.getPSPFPubCodeName(), var198, var263.getPSPFCTDetailName());
                     String var298 = StringHelper.format("%1$s%2$s%3$s", var152, File.separator, var278);
                     String var31 = var263.getTemplCode();
                     if (StringHelper.isNullOrEmpty(var31)) {
                        var31 = "";
                     }

                     for (Entry<String, String> var33 : var14.entrySet()) {
                        var31 = var31.replace((CharSequence)var33.getKey(), (CharSequence)var33.getValue());
                     }

                     if (!StringHelper.isNullOrEmpty(var263.getPubObj())) {
                        StringBuilderEx var318 = new StringBuilderEx();
                        String var327 = var263.getPubObj();
                        var327 = var327.replace("SA.SRFDA.PS.Core.Pub.", "");
                        var327 = var327.replace("PublisherImpl", "");
                        var318.append("<#ibiztemplate>\r\n");
                        var318.append("PUBOBJ=%1$s\r\n", var327);
                        var318.append("</#ibiztemplate>\r\n");
                        var318.append(var31);
                        var31 = var318.toString();
                     }

                     writeFile(var298, var31);
                     var20.remove(StringHelper.format("%1$s%2$s%3$s", var152, File.separator, var278.toUpperCase()));
                     if (!StringHelper.isNullOrEmpty(var263.getTemplCode2())) {
                        var278 = StringHelper.format("%1$s%2$s#%3$s#CODE2.ftl", var171.getPSPFPubCodeName(), var198, var263.getPSPFCTDetailName());
                        var298 = StringHelper.format("%1$s%2$s%3$s", var152, File.separator, var278);
                        var31 = var263.getTemplCode2();
                        if (StringHelper.isNullOrEmpty(var31)) {
                           var31 = "";
                        }

                        for (Entry<String, String> var330 : var14.entrySet()) {
                           var31 = var31.replace((CharSequence)var330.getKey(), (CharSequence)var330.getValue());
                        }

                        writeFile(var298, var31);
                        var20.remove(StringHelper.format("%1$s%2$s%3$s", var152, File.separator, var278.toUpperCase()));
                     }

                     if (!StringHelper.isNullOrEmpty(var263.getTemplCode3())) {
                        var278 = StringHelper.format("%1$s%2$s#%3$s#CODE3.ftl", var171.getPSPFPubCodeName(), var198, var263.getPSPFCTDetailName());
                        var298 = StringHelper.format("%1$s%2$s%3$s", var152, File.separator, var278);
                        var31 = var263.getTemplCode3();
                        if (StringHelper.isNullOrEmpty(var31)) {
                           var31 = "";
                        }

                        for (Entry<String, String> var331 : var14.entrySet()) {
                           var31 = var31.replace((CharSequence)var331.getKey(), (CharSequence)var331.getValue());
                        }

                        writeFile(var298, var31);
                        var20.remove(StringHelper.format("%1$s%2$s%3$s", var152, File.separator, var278.toUpperCase()));
                     }

                     if (!StringHelper.isNullOrEmpty(var263.getTemplCode4())) {
                        var278 = StringHelper.format("%1$s%2$s#%3$s#CODE4.ftl", var171.getPSPFPubCodeName(), var198, var263.getPSPFCTDetailName());
                        var298 = StringHelper.format("%1$s%2$s%3$s", var152, File.separator, var278);
                        var31 = var263.getTemplCode4();
                        if (StringHelper.isNullOrEmpty(var31)) {
                           var31 = "";
                        }

                        for (Entry<String, String> var332 : var14.entrySet()) {
                           var31 = var31.replace((CharSequence)var332.getKey(), (CharSequence)var332.getValue());
                        }

                        writeFile(var298, var31);
                        var20.remove(StringHelper.format("%1$s%2$s%3$s", var152, File.separator, var278.toUpperCase()));
                     }
                  }
               }
            }
         }

         for (Entry<String, File> var135 : var20.entrySet()) {
            log.debug(StringHelper.format("移除文件[%1$s]", ((File)var135.getValue()).getAbsolutePath()));
         }

         var36.reset();
         var36.set("PSPFID", var1.getPSPFId());
         var36.setIsNull("PSPFSTYLEID");
         PSPFEditorTemplService var46 = (PSPFEditorTemplService)ServiceGlobal.getService(PSPFEditorTemplService.class, this.getSessionFactory());
         ArrayList<PSPFEditorTempl> var54 = var46.select(var36);
         ArrayList<PSPFEditorTempl> var67 = var1.getPSPFEditorTempls();
         var54.addAll(var67);
         String var75 = StringHelper.format("%1$s%2$s@EDITOR", var2, File.separator);
         File var83 = new File(var75);
         if (!var83.exists()) {
            var83.mkdirs();
         }

         File var92 = new File(var75);
         File[] var113 = var92.listFiles();
         HashMap<String, File> var136 = new HashMap<>();

         for (File var230 : var113) {
            if (var230.isDirectory()) {
               for (File var302 : var230.listFiles()) {
                  if (var302.isDirectory()) {
                     for (File var34 : var302.listFiles()) {
                        if (var34.isFile()) {
                           var136.put(
                              StringHelper.format("%1$s%2$s%3$s%2$s%4$s", var230.getName(), File.separator, var302.getName(), var34.getName().toUpperCase()),
                              var34
                           );
                        }
                     }
                  }
               }
            }
         }

         EditorContainersCodeListModel var154 = (EditorContainersCodeListModel)CodeListGlobal.getCodeList(
            "net.ibizsys.pscore.srv.codelist.EditorContainersCodeListModel"
         );

         for (PSPFEditorTempl var203 : var54) {
            String var231 = var203.getContainerType();
            String var246 = var154.getCodeListText(var231, false);
            String var265 = StringHelper.format("%1$s%2$s%3$s（%4$s）", var75, File.separator, var203.getPSEditorTypeName(), var246);
            File var84 = new File(var265);
            if (!var84.exists()) {
               var84.mkdirs();
            }

            StringBuilderEx var283 = new StringBuilderEx();
            var283.append("EDITORTYPE=%1$s", var203.getPSEditorTypeId());
            String var303 = StringHelper.format("%1$s%2$s%3$s", var265, File.separator, "template.properties");
            writeFile(var303, var283.toString());
            PSPFPubCode var284 = (PSPFPubCode)var5.get(var203.getPSPFPubCodeId());
            if (var284 != null) {
               var303 = var284.getCodeEXT();
               if (!StringHelper.isNullOrEmpty(var303)) {
                  String[] var312 = var303.split("[.]");
                  var303 = "." + var312[var312.length - 1];
               }

               var303 = "";
               String var313 = StringHelper.format("%1$s%2$s.ftl", var284.getPSPFPubCodeName(), var303);
               String var323 = StringHelper.format("%1$s%2$s%3$s", var265, File.separator, var313);
               String var334 = var203.getTemplCode();
               if (StringHelper.isNullOrEmpty(var334)) {
                  var334 = "";
               }

               for (Entry<String, String> var35 : var14.entrySet()) {
                  var334 = var334.replace((CharSequence)var35.getKey(), (CharSequence)var35.getValue());
               }

               StringBuilderEx var340 = new StringBuilderEx();
               String var344 = var203.getPubObj();
               if (!StringHelper.isNullOrEmpty(var344)) {
                  var344 = var344.replace("SA.SRFDA.PS.Core.Pub.", "");
                  var344 = var344.replace("PublisherImpl", "");
               }

               var340.append("<#ibiztemplate>\r\n");
               if (!StringHelper.isNullOrEmpty(var344)) {
                  var340.append("PUBOBJ=%1$s\r\n", var344);
               }

               var340.append("CONTAINER=%1$s\r\n", var231);
               var340.append("</#ibiztemplate>\r\n");
               var340.append(var334);
               var334 = var340.toString();
               writeFile(var323, var334);
               var136.remove(StringHelper.format("%1$s%2$s%3$s", var265, File.separator, var313.toUpperCase()));
               if (!StringHelper.isNullOrEmpty(var203.getTemplCode2())) {
                  var313 = StringHelper.format("%1$s%2$s#CODE2.ftl", var284.getPSPFPubCodeName(), var303);
                  var323 = StringHelper.format("%1$s%2$s%3$s", var265, File.separator, var313);
                  var334 = var203.getTemplCode2();

                  for (Entry<String, String> var346 : var14.entrySet()) {
                     var334 = var334.replace((CharSequence)var346.getKey(), (CharSequence)var346.getValue());
                  }

                  writeFile(var323, var334);
                  var136.remove(StringHelper.format("%1$s%2$s%3$s", var265, File.separator, var313.toUpperCase()));
               }

               if (!StringHelper.isNullOrEmpty(var203.getTemplCode3())) {
                  var313 = StringHelper.format("%1$s%2$s#CODE3.ftl", var284.getPSPFPubCodeName(), var303);
                  var323 = StringHelper.format("%1$s%2$s%3$s", var265, File.separator, var313);
                  var334 = var203.getTemplCode3();

                  for (Entry<String, String> var347 : var14.entrySet()) {
                     var334 = var334.replace((CharSequence)var347.getKey(), (CharSequence)var347.getValue());
                  }

                  writeFile(var323, var334);
                  var136.remove(StringHelper.format("%1$s%2$s%3$s", var265, File.separator, var313.toUpperCase()));
               }

               if (!StringHelper.isNullOrEmpty(var203.getTemplCode4())) {
                  var313 = StringHelper.format("%1$s%2$s#CODE4.ftl", var284.getPSPFPubCodeName(), var303);
                  var323 = StringHelper.format("%1$s%2$s%3$s", var265, File.separator, var313);
                  var334 = var203.getTemplCode4();

                  for (Entry<String, String> var348 : var14.entrySet()) {
                     var334 = var334.replace((CharSequence)var348.getKey(), (CharSequence)var348.getValue());
                  }

                  writeFile(var323, var334);
                  var136.remove(StringHelper.format("%1$s%2$s%3$s", var265, File.separator, var313.toUpperCase()));
               }
            }
         }

         for (Entry<String, File> var204 : var136.entrySet()) {
            log.debug(StringHelper.format("移除文件[%1$s]", ((File)var204.getValue()).getAbsolutePath()));
         }

         PSPFAppTemplService var47 = (PSPFAppTemplService)ServiceGlobal.getService(PSPFAppTemplService.class, this.getSessionFactory());
         var36.reset();
         var36.set("PSPFSTYLEID", var1.getPSPFStyleId());

         for (PSPFAppTempl var76 : var47.select(var36)) {
            PSPFPubCode var85 = (PSPFPubCode)var5.get(var76.getPSPFPubCodeId());
            if (var85 != null) {
               PSPFCodeFolder var93 = (PSPFCodeFolder)var9.get(var85.getPSPFCodeFolderId());
               String var114 = StringHelper.format("%1$s%2$s%3$s", var2, File.separator, var93.getFolderName());
               File var137 = new File(var114);
               if (!var137.exists()) {
                  var137.mkdirs();
               }

               String var155 = var85.getPSPFPubCodeName();
               if (StringHelper.isNullOrEmpty(var155)) {
                  var155 = "";
               }

               String var175 = var85.getCodeEXT();
               if (StringHelper.isNullOrEmpty(var175)) {
                  var175 = "";
               }

               var175 = "";
               String var205 = StringHelper.format("%1$s%2$s.ftl", var155, var175);
               String var232 = StringHelper.format("%1$s%2$s%3$s", var114, File.separator, var205);
               String var247 = var76.getTemplCode();
               if (StringHelper.isNullOrEmpty(var247)) {
                  var247 = "";
               }

               StringBuilderEx var266 = new StringBuilderEx();
               String var285 = var76.getPubObj();
               if (!StringHelper.isNullOrEmpty(var76.getPubObj())) {
                  var285 = var285.replace("SA.SRFDA.PS.Core.Pub.", "");
                  var285 = var285.replace("PublisherImpl", "");
               }

               var266.append("<#ibiztemplate>\r\n");
               if (!StringHelper.isNullOrEmpty(var285)) {
                  var266.append("PUBOBJ=%1$s\r\n", var285);
               }

               var266.append("TARGET=%1$s\r\n", "PSSYSAPP");
               var266.append("</#ibiztemplate>\r\n");
               var266.append(var247);
               var247 = var266.toString();
               writeFile(var232, var247);
            }
         }
      } else {
         ArrayList<PSPFStyleCode> var40 = var1.getPSPFStyleCodes();
         String var48 = StringHelper.format("%1$s%2$smacro", var2, File.separator);
         File var56 = new File(var48);
         if (!var56.exists()) {
            var56.mkdirs();
         }

         File var69 = new File(var48);
         File[] var77 = var69.listFiles();
         HashMap<String, File> var86 = new HashMap<>();

         for (File var156 : var77) {
            if (var156.isFile()) {
               var86.put(var156.getName().toUpperCase(), var156);
            }
         }

         for (PSPFStyleCode var116 : var40) {
            String var139 = StringHelper.format("%1$s.txt", var116.getPSPFStyleCodeName().toUpperCase());
            String var157 = StringHelper.format("%1$s%2$s%3$s", var48, File.separator, var139);
            writeFile(var157, var116.getStyleCode());
            var86.remove(var139.toUpperCase());
         }

         for (Entry<String, File> var117 : var86.entrySet()) {
            log.debug(StringHelper.format("移除文件[%1$s]", ((File)var117.getValue()).getAbsolutePath()));
         }

         ArrayList<PSPFViewTempl> var40View = var1.getPSPFViewTempls();
         var48 = StringHelper.format("%1$s%2$sview", var2, File.separator);
         var56 = new File(var48);
         if (!var56.exists()) {
            var56.mkdirs();
         }

         var69 = new File(var48);
         var77 = var69.listFiles();
         var86 = new HashMap<>();

         for (File var158 : var77) {
            if (var158.isDirectory()) {
               for (File var249 : var158.listFiles()) {
                  var86.put(StringHelper.format("%1$s%2$s%3$s", var158.getName(), File.separator, var249.getName().toUpperCase()), var249);
               }
            }
         }

         for (PSPFViewTempl var119 : var40View) {
            String var141 = StringHelper.format("%1$s%2$s%3$s", var48, File.separator, var119.getPSViewTypeId());
            var56 = new File(var141);
            if (!var56.exists()) {
               var56.mkdirs();
            }

            PSPFPubCode var159 = (PSPFPubCode)var5.get(var119.getPSPFPubCodeId());
            String var179 = StringHelper.format("%1$s%2$s", var159.getPSPFPubCodeName(), var159.getCodeEXT());
            String var207 = StringHelper.format("%1$s%2$s%3$s", var141, File.separator, var179);
            writeFile(var207, var119.getTemplCode2());
            var86.remove(StringHelper.format("%1$s%2$s%3$s", var141, File.separator, var179.toUpperCase()));
         }

         for (Entry<String, File> var120 : var86.entrySet()) {
            log.debug(StringHelper.format("移除文件[%1$s]", ((File)var120.getValue()).getAbsolutePath()));
         }

         ArrayList<PSPFCtrlTempl> var40Ctrl = var1.getPSPFCtrlTempls();
         var48 = StringHelper.format("%1$s%2$sctrl", var2, File.separator);
         var56 = new File(var48);
         if (!var56.exists()) {
            var56.mkdirs();
         }

         var69 = new File(var48);
         var77 = var69.listFiles();
         var86 = new HashMap<>();

         for (File var160 : var77) {
            if (var160.isDirectory()) {
               for (File var250 : var160.listFiles()) {
                  var86.put(StringHelper.format("%1$s%2$s%3$s", var160.getName(), File.separator, var250.getName().toUpperCase()), var250);
               }
            }
         }

         for (PSPFCtrlTempl var122 : var40Ctrl) {
            String var143 = StringHelper.format("%1$s%2$s%3$s", var48, File.separator, var122.getPSCtrlTypeId());
            var56 = new File(var143);
            if (!var56.exists()) {
               var56.mkdirs();
            }

            PSPFPubCode var161 = (PSPFPubCode)var5.get(var122.getPSPFPubCodeId());
            if (!StringHelper.isNullOrEmpty(var122.getTemplCode())) {
               String var181 = StringHelper.format("%1$s%2$s", var161.getPSPFPubCodeName(), var161.getCodeEXT());
               String var209 = StringHelper.format("%1$s%2$s%3$s", var143, File.separator, var181);
               writeFile(var209, var122.getTemplCode());
               var86.remove(StringHelper.format("%1$s%2$s%3$s", var143, File.separator, var181.toUpperCase()));
            }

            if (!StringHelper.isNullOrEmpty(var122.getTemplCode2())) {
               String var182 = StringHelper.format("%1$s_CODE2%2$s", var161.getPSPFPubCodeName(), var161.getCodeEXT());
               String var210 = StringHelper.format("%1$s%2$s%3$s", var143, File.separator, var182);
               writeFile(var210, var122.getTemplCode2());
               var86.remove(StringHelper.format("%1$s%2$s%3$s", var143, File.separator, var182.toUpperCase()));
            }

            if (!StringHelper.isNullOrEmpty(var122.getTemplCode3())) {
               String var183 = StringHelper.format("%1$s_CODE3%2$s", var161.getPSPFPubCodeName(), var161.getCodeEXT());
               String var211 = StringHelper.format("%1$s%2$s%3$s", var143, File.separator, var183);
               writeFile(var211, var122.getTemplCode3());
               var86.remove(StringHelper.format("%1$s%2$s%3$s", var143, File.separator, var183.toUpperCase()));
            }

            if (!StringHelper.isNullOrEmpty(var122.getTemplCode4())) {
               String var184 = StringHelper.format("%1$s_CODE4%2$s", var161.getPSPFPubCodeName(), var161.getCodeEXT());
               String var212 = StringHelper.format("%1$s%2$s%3$s", var143, File.separator, var184);
               writeFile(var212, var122.getTemplCode4());
               var86.remove(StringHelper.format("%1$s%2$s%3$s", var143, File.separator, var184.toUpperCase()));
            }

            for (PSPFCTDetail var235 : var122.getPSPFCTDetails()) {
               if (DataObject.getBoolValue(var235.getValidFlag(), true)) {
                  if (!StringHelper.isNullOrEmpty(var235.getTemplCode())) {
                     String var251 = StringHelper.format("%1$s_%3$s%2$s", var161.getPSPFPubCodeName(), var161.getCodeEXT(), var235.getPSPFCTDetailName());
                     String var267 = StringHelper.format("%1$s%2$s%3$s", var143, File.separator, var251);
                     writeFile(var267, var235.getTemplCode());
                     var86.remove(StringHelper.format("%1$s%2$s%3$s", var143, File.separator, var251.toUpperCase()));
                  }

                  if (!StringHelper.isNullOrEmpty(var235.getTemplCode2())) {
                     String var252 = StringHelper.format("%1$s_%3$s_CODE2%2$s", var161.getPSPFPubCodeName(), var161.getCodeEXT(), var235.getPSPFCTDetailName());
                     String var268 = StringHelper.format("%1$s%2$s%3$s", var143, File.separator, var252);
                     writeFile(var268, var235.getTemplCode2());
                     var86.remove(StringHelper.format("%1$s%2$s%3$s", var143, File.separator, var252.toUpperCase()));
                  }

                  if (!StringHelper.isNullOrEmpty(var235.getTemplCode3())) {
                     String var253 = StringHelper.format("%1$s_%3$s_CODE3%2$s", var161.getPSPFPubCodeName(), var161.getCodeEXT(), var235.getPSPFCTDetailName());
                     String var269 = StringHelper.format("%1$s%2$s%3$s", var143, File.separator, var253);
                     writeFile(var269, var235.getTemplCode3());
                     var86.remove(StringHelper.format("%1$s%2$s%3$s", var143, File.separator, var253.toUpperCase()));
                  }

                  if (!StringHelper.isNullOrEmpty(var235.getTemplCode4())) {
                     String var254 = StringHelper.format("%1$s_%3$s_CODE4%2$s", var161.getPSPFPubCodeName(), var161.getCodeEXT(), var235.getPSPFCTDetailName());
                     String var270 = StringHelper.format("%1$s%2$s%3$s", var143, File.separator, var254);
                     writeFile(var270, var235.getTemplCode4());
                     var86.remove(StringHelper.format("%1$s%2$s%3$s", var143, File.separator, var254.toUpperCase()));
                  }
               }
            }
         }

         for (Entry<String, File> var123 : var86.entrySet()) {
            log.debug(StringHelper.format("移除文件[%1$s]", ((File)var123.getValue()).getAbsolutePath()));
         }

         ArrayList<PSPFEditorTempl> var40Editor = var1.getPSPFEditorTempls();
         var48 = StringHelper.format("%1$s%2$seditor", var2, File.separator);
         var56 = new File(var48);
         if (!var56.exists()) {
            var56.mkdirs();
         }

         var69 = new File(var48);
         var77 = var69.listFiles();
         var86 = new HashMap<>();

         for (File var162 : var77) {
            if (var162.isDirectory()) {
               for (File var255 : var162.listFiles()) {
                  if (var255.isDirectory()) {
                     for (File var317 : var255.listFiles()) {
                        if (var317.isFile()) {
                           var86.put(
                              StringHelper.format("%1$s%2$s%3$s%2$s%4$s", var162.getName(), File.separator, var255.getName(), var317.getName().toUpperCase()),
                              var317
                           );
                        }
                     }
                  }
               }
            }
         }

         for (PSPFEditorTempl var125 : var40Editor) {
            String var145 = StringHelper.format("%1$s%2$s%3$s%2$s%4$s", var48, File.separator, var125.getPSEditorTypeId(), var125.getContainerType());
            var56 = new File(var145);
            if (!var56.exists()) {
               var56.mkdirs();
            }

            PSPFPubCode var163 = (PSPFPubCode)var5.get(var125.getPSPFPubCodeId());
            if (!StringHelper.isNullOrEmpty(var125.getTemplCode())) {
               String var187 = StringHelper.format("%1$s%2$s", var163.getPSPFPubCodeName(), var163.getCodeEXT());
               String var215 = StringHelper.format("%1$s%2$s%3$s", var145, File.separator, var187);
               writeFile(var215, var125.getTemplCode());
               var86.remove(StringHelper.format("%1$s%2$s%3$s", var145, File.separator, var187.toUpperCase()));
            }

            if (!StringHelper.isNullOrEmpty(var125.getTemplCode2())) {
               String var188 = StringHelper.format("%1$s_CODE2%2$s", var163.getPSPFPubCodeName(), var163.getCodeEXT());
               String var216 = StringHelper.format("%1$s%2$s%3$s", var145, File.separator, var188);
               writeFile(var216, var125.getTemplCode2());
               var86.remove(StringHelper.format("%1$s%2$s%3$s", var145, File.separator, var188.toUpperCase()));
            }

            if (!StringHelper.isNullOrEmpty(var125.getTemplCode3())) {
               String var189 = StringHelper.format("%1$s_CODE3%2$s", var163.getPSPFPubCodeName(), var163.getCodeEXT());
               String var217 = StringHelper.format("%1$s%2$s%3$s", var145, File.separator, var189);
               writeFile(var217, var125.getTemplCode3());
               var86.remove(StringHelper.format("%1$s%2$s%3$s", var145, File.separator, var189.toUpperCase()));
            }

            if (!StringHelper.isNullOrEmpty(var125.getTemplCode4())) {
               String var190 = StringHelper.format("%1$s_CODE4%2$s", var163.getPSPFPubCodeName(), var163.getCodeEXT());
               String var218 = StringHelper.format("%1$s%2$s%3$s", var145, File.separator, var190);
               writeFile(var218, var125.getTemplCode4());
               var86.remove(StringHelper.format("%1$s%2$s%3$s", var145, File.separator, var190.toUpperCase()));
            }
         }

         for (Entry<String, File> var126 : var86.entrySet()) {
            log.debug(StringHelper.format("移除文件[%1$s]", ((File)var126.getValue()).getAbsolutePath()));
         }
      }
   }

   public static void writeFile(String var0, String var1) throws Exception {
      OutputStreamWriter var2 = new OutputStreamWriter(new FileOutputStream(new File(var0)), "UTF-8");
      BufferedWriter var3 = new BufferedWriter(var2);
      var3.write(var1);
      var3.close();
   }

   public static String readFile(String var0) throws Exception {
      StringBuffer var1 = new StringBuffer();
      InputStreamReader var2 = null;

      try {
         FileInputStream var3 = new FileInputStream(var0);
         var2 = new InputStreamReader(var3, "UTF-8");
         char[] var4 = new char[4096];

         while (true) {
            int var5 = var2.read(var4);
            if (var5 == -1) {
               break;
            }

            var1.append(new String(var4, 0, var5));
         }
      } catch (Exception var14) {
         var14.printStackTrace();
      } finally {
         if (var2 != null) {
            try {
               var2.close();
            } catch (IOException var13) {
            }
         }
      }

      return var1.toString();
   }

   protected void mergeCode(PSPFStyle var1) throws Exception {
      PSPFStyleCodeService var2 = (PSPFStyleCodeService)ServiceGlobal.getService(PSPFStyleCodeService.class, this.getSessionFactory());
      ArrayList<PSPFStyleCode> var3 = var2.selectByPSPFStyle(var1);
      PSPFViewTemplService var4 = (PSPFViewTemplService)ServiceGlobal.getService(PSPFViewTemplService.class, this.getSessionFactory());
      ArrayList<PSPFViewTempl> var5 = var4.selectByPSPFStyle(var1);
      PSPFAppTemplService var6 = (PSPFAppTemplService)ServiceGlobal.getService(PSPFAppTemplService.class, this.getSessionFactory());
      ArrayList<PSPFAppTempl> var7 = var6.selectByPSPFStyle(var1);

      for (PSPFViewTempl var9 : var5) {
         String var10 = var9.getTemplCode2();

         for (int var11 = 0; var11 < 10; var11++) {
            boolean var12 = false;

            for (PSPFStyleCode var14 : var3) {
               String var15 = StringHelper.format("<#SRFINC(%1$s)>", var14.getPSPFStyleCodeName().toUpperCase());
               if (var10.indexOf(var15) != -1) {
                  var10 = var10.replace(var15, var14.getStyleCode());
                  var12 = true;
               }
            }

            if (!var12) {
               break;
            }
         }

         if (StringHelper.compare(var10, var9.getTemplCode(), false) != 0) {
            var9.setTemplCode(var10);
            var4.update(var9);
         }
      }

      for (PSPFAppTempl var17 : var7) {
         String var18 = var17.getTemplCode2();

         for (int var19 = 0; var19 < 10; var19++) {
            boolean var20 = false;

            for (PSPFStyleCode var22 : var3) {
               String var23 = StringHelper.format("<#SRFINC(%1$s)>", var22.getPSPFStyleCodeName().toUpperCase());
               if (var18.indexOf(var23) != -1) {
                  var18 = var18.replace(var23, var22.getStyleCode());
                  var20 = true;
               }
            }

            if (!var20) {
               break;
            }
         }

         if (StringHelper.compare(var18, var17.getTemplCode(), false) != 0) {
            var17.setTemplCode(var18);
            var6.update(var17);
         }
      }
   }

   @Override
   protected void onFixStyle(PSPFStyle var1) throws Exception {
      this.get(var1);
      if (var1.getTemplPSPFStyle() != null) {
         ArrayList<PSPFStyleCode> var2 = var1.getPSPFStyleCodes();
         HashMap<String, PSPFStyleCode> var3 = new HashMap<>();

         for (PSPFStyleCode var5 : var2) {
            var3.put(var5.getPSPFStyleCodeName(), var5);
         }

         PSPFViewTemplService var25 = (PSPFViewTemplService)ServiceGlobal.getService(PSPFViewTemplService.class, this.getSessionFactory());
         PSPFCtrlTemplService var26 = (PSPFCtrlTemplService)ServiceGlobal.getService(PSPFCtrlTemplService.class, this.getSessionFactory());
         PSPFAppTemplService var6 = (PSPFAppTemplService)ServiceGlobal.getService(PSPFAppTemplService.class, this.getSessionFactory());
         PSPFEditorTemplService var7 = (PSPFEditorTemplService)ServiceGlobal.getService(PSPFEditorTemplService.class, this.getSessionFactory());

         for (PSPFStyle var8 = var1.getTemplPSPFStyle(); var8 != null; var8 = var8.getTemplPSPFStyle()) {
            for (PSPFStyleCode var10 : var8.getPSPFStyleCodes()) {
               if (!var3.containsKey(var10.getPSPFStyleCodeName())) {
                  var10.resetPSPFStyleCodeId();
                  var10.setPSPFStyleId(var1.getPSPFStyleId());
                  var10.setPSPFStyleName(var1.getPSPFStyleName());

                  try {
                     var10.resetMemo();
                     var10.create();
                     var3.put(var10.getPSPFStyleCodeName(), var10);
                  } catch (Exception var19) {
                     throw new Exception(StringHelper.format("建立样式宏代码发生异常，%1$s", var19.getMessage()), var19);
                  }
               }
            }

            for (PSPFViewTempl var11 : var8.getPSPFViewTempls()) {
               var11.resetPSPFViewTemplId();
               var11.resetPSPFViewTemplName();
               var11.setPSPFStyleId(var1.getPSPFStyleId());
               var11.setPSPFStyleName(var1.getPSPFStyleName());
               if (var25.checkKey(var11) == 0) {
                  try {
                     var11.resetMemo();
                     var25.create(var11);
                  } catch (Exception var22) {
                     throw new Exception(StringHelper.format("建立视图模板发生异常，%1$s", var22.getMessage()), var22);
                  }
               }
            }

            for (PSPFAppTempl var12 : var8.getPSPFAppTempls()) {
               var12.resetPSPFAppTemplId();
               var12.resetPSPFAppTemplName();
               var12.setPSPFStyleId(var1.getPSPFStyleId());
               var12.setPSPFStyleName(var1.getPSPFStyleName());
               if (var6.checkKey(var12) == 0) {
                  try {
                     var12.resetMemo();
                     var6.create(var12);
                  } catch (Exception var21) {
                     throw new Exception(StringHelper.format("建立应用模板发生异常，%1$s", var21.getMessage()), var21);
                  }
               }
            }

            for (PSPFCtrlTempl var13 : var8.getPSPFCtrlTempls()) {
               PSPFCtrlTempl var14 = new PSPFCtrlTempl();
               var13.copyTo(var14, false);
               var14.resetPSPFCtrlTemplId();
               var14.resetPSPFCtrlTemplName();
               var14.setPSPFStyleId(var1.getPSPFStyleId());
               var14.setPSPFStyleName(var1.getPSPFStyleName());
               if (var26.checkKey(var14) == 0) {
                  try {
                     var14.resetMemo();
                     var26.create(var14);

                     for (PSPFCTDetail var17 : var13.getPSPFCTDetails()) {
                        var17.resetPSPFCTDetailId();
                        var17.setPSPFCtrlTemplId(var14.getPSPFCtrlTemplId());
                        var17.setPSPFCtrlTemplName(var14.getPSPFCtrlTemplName());
                        var17.resetMemo();
                        var17.create();
                     }
                  } catch (Exception var23) {
                     throw new Exception(StringHelper.format("建立部件模板发生异常，%1$s", var23.getMessage()), var23);
                  }
               }
            }

            for (PSPFEditorTempl var39 : var8.getPSPFEditorTempls()) {
               var39.resetPSPFEditorTemplId();
               var39.resetPSPFEditorTemplName();
               var39.setPSPFStyleId(var1.getPSPFStyleId());
               var39.setPSPFStyleName(var1.getPSPFStyleName());
               if (var7.checkKey(var39) == 0) {
                  try {
                     var39.resetMemo();
                     var7.create(var39);
                  } catch (Exception var20) {
                     throw new Exception(StringHelper.format("建立编辑器模板发生异常，%1$s", var20.getMessage()), var20);
                  }
               }
            }
         }

         SelectCond var28 = new SelectCond();
         var28.set("PSPFID", var1.getPSPFId());
         var28.set("PSPFSTYLEID", SelectCond.ISNULL);

         for (PSPFEditorTempl var37 : var7.select(var28)) {
            var37.resetPSPFEditorTemplId();
            var37.resetPSPFEditorTemplName();
            var37.setPSPFStyleId(var1.getPSPFStyleId());
            var37.setPSPFStyleName(var1.getPSPFStyleName());
            if (var7.checkKey(var37) == 0) {
               try {
                  var37.resetMemo();
                  var7.create(var37);
               } catch (Exception var18) {
                  throw new Exception(StringHelper.format("建立编辑器模板发生异常，%1$s", var18.getMessage()), var18);
               }
            }
         }
      }
   }

   @Override
   protected boolean isPrepareLastForRemove() {
      return true;
   }

   @Override
   protected boolean isPrepareLastForUpdate() {
      return true;
   }

   @Override
   public DBFetchResult fetchCurDCPF3(IDEDataSetFetchContext var1) throws Exception {
      if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
         PSPFStyleService var2 = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, PSCoreSysServiceBase.getCurMajorSessionFactory());
         return var2.fetchCurDCPF3(var1);
      } else {
         return super.fetchCurDCPF3(var1);
      }
   }

   @Override
   public DBFetchResult fetchCurDCPF2(IDEDataSetFetchContext var1) throws Exception {
      if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
         PSPFStyleService var2 = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, PSCoreSysServiceBase.getCurMajorSessionFactory());
         return var2.fetchCurDCPF2(var1);
      } else {
         return super.fetchCurDCPF2(var1);
      }
   }

   @Override
   public DBFetchResult fetchCurDCPF(IDEDataSetFetchContext var1) throws Exception {
      if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
         PSPFStyleService var2 = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, PSCoreSysServiceBase.getCurMajorSessionFactory());
         return var2.fetchCurDCPF(var1);
      } else {
         return super.fetchCurDCPF(var1);
      }
   }

   @Override
   public DBFetchResult fetchCurDCPFAll(IDEDataSetFetchContext var1) throws Exception {
      if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
         PSPFStyleService var2 = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, PSCoreSysServiceBase.getCurMajorSessionFactory());
         return var2.fetchCurDCPFAll(var1);
      } else {
         return super.fetchCurDCPFAll(var1);
      }
   }

   @Override
   public DBFetchResult fetchCurDCPFAll2(IDEDataSetFetchContext var1) throws Exception {
      if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
         PSPFStyleService var2 = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, PSCoreSysServiceBase.getCurMajorSessionFactory());
         return var2.fetchCurDCPFAll2(var1);
      } else {
         return super.fetchCurDCPFAll2(var1);
      }
   }

   @Override
   public DBFetchResult fetchCurPF(IDEDataSetFetchContext var1) throws Exception {
      if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
         PSPFStyleService var2 = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, PSCoreSysServiceBase.getCurMajorSessionFactory());
         return var2.fetchCurDCPFAll(var1);
      } else {
         return super.fetchCurPF(var1);
      }
   }
}
