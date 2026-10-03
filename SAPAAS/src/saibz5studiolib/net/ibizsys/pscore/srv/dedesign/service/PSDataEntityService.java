package net.ibizsys.pscore.srv.dedesign.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.Map.Entry;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.codelist.DEDataQueryColLevel2CodeListModel;
import net.ibizsys.pscore.srv.codelist.DEStorageTypeCodeListModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQJoin;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFSFItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFUIMode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGrid;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGridCol;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPrivRole;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETable;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUserRole;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMTDEF;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCModelTempl;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCSysLic;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSysLicService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADEField;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBScheme;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBTable;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBSchemeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBTableService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSDEFDataTypeHelper;
import net.ibizsys.pscore.srv.util.PSModelFolderKeyHelper;
import net.ibizsys.pscore.srv.util.PSModelGlobal;
import net.ibizsys.pscore.srv.util.PSRTHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDataEntityService extends PSDataEntityServiceBase {
   private static final Log log = LogFactory.getLog(PSDataEntityService.class);
   public static final String TAG_WFINSTANCEID = "WFINSTANCEID";
   public static final String TAG_WFSTATE = "WFSTATE";
   public static final String TAG_WFSTEP = "WFSTEP";
   public static final String TAG_WFVERSION = "WFVERSION";
   public static final String TAG_WFUSERSTATE = "WFUSERSTATE";
   private static HashMap<String, String> rtDEMap = new HashMap<>();
   private static HashMap<String, String> wfActionMap = new HashMap<>();
   private static HashMap<String, String> predefinedFieldMap = new HashMap<>();

   @Override
   protected boolean onFillEntityKeyValue(PSDataEntity var1, boolean var2) throws Exception {
      if (!StringHelper.isNullOrEmpty(var1.getPSSysModelGroupId())) {
         StringBuilderEx var8 = new StringBuilderEx();
         Object var9 = var1.get("PSSYSTEMID");
         if (var9 == null) {
            var9 = "__EMTPY__";
         }

         var8.append("%1$s", var9);
         var8.append("||");
         Object var10 = var1.get("PSDATAENTITYNAME");
         if (var10 == null) {
            var10 = "__EMTPY__";
         }

         var8.append("%1$s", var10);
         Object var11 = var1.get("PSSYSMODELGROUPID");
         if (var11 == null) {
            var11 = "__EMTPY__";
         }

         var8.append("%1$s", var11);
         String var7 = var8.toString();
         var1.set(this.getPSDataEntityDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId(var7));
         return true;
      } else {
         StringBuilderEx var3 = new StringBuilderEx();
         Object var4 = var1.get("PSSYSTEMID");
         if (var4 == null) {
            var4 = "__EMTPY__";
         }

         var3.append("%1$s", var4);
         var3.append("||");
         Object var5 = var1.get("PSDATAENTITYNAME");
         if (var5 == null) {
            var5 = "__EMTPY__";
         }

         var3.append("%1$s", var5);
         String var6 = var3.toString();
         var1.set(this.getPSDataEntityDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId(var6));
         return true;
      }
   }

   public boolean fillEntityKeyValue(PSDataEntity var1, boolean var2) throws Exception {
      if (!PSCoreSysServiceBase.isImpSysModelNow() && !var2 && StringHelper.isNullOrEmpty(var1.getPSSysModelGroupId()) && var1.getPSModule() != null) {
         var1.setPSSysModelGroupId(var1.getPSModule().getPSSysModelGroupId());
      }

      return super.fillEntityKeyValue(var1, var2);
   }

   protected void onBeforeCreate(PSDataEntity var1) throws Exception {
      super.onBeforeCreate(var1);
      if (!PSRTHelper.isRTDE(var1.getPSDataEntityName())) {
         PSSystemService var2 = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, this.getSessionFactory());
         PSSystem var3 = new PSSystem();
         var3.setPSSystemId(var1.getPSSystemId());
         var2.increaseDECnt(var3);
      }

      PSDCModelTempl var10 = null;
      boolean var11 = false;
      if (DataObject.getBoolValue(var1.getExistingModel(), false)) {
         var11 = true;
      }

      if (!var11 && var1.getPSModule() != null && DataObject.getBoolValue(var1.getPSModule().getSubSysModule(), false)) {
         var11 = true;
      }

      if (!var11) {
         PSSystem var4 = var1.getPSSystem();
         if (!StringHelper.isNullOrEmpty(var4.getPSDevSlnSysId())) {
            var10 = PSModelGlobal.getPSDCModelTempl(var4.getPSDevSlnSysId());
         }
      }

      String var12 = var1.getPSDataEntityName().toUpperCase();
      if (var10 != null && var10.getDENameMaxLength() != null && var10.getDENameMaxLength() > 0 && var12.length() > var10.getDENameMaxLength()) {
         throw new Exception(StringHelper.format("模型模板[%1$s]定义实体名称长度不能超过[%2$s]", var10.getPSDCModelTemplName(), var10.getDENameMaxLength()));
      }

      var1.setPSDataEntityName(var12);
      boolean var13 = true;
      if (!StringHelper.isNullOrEmpty(var1.getPSDataEntityId())) {
         var13 = var1.getPSDataEntityId().indexOf("S") != 0;
      }

      if (var13) {
         var1.resetPSDataEntityId();
         this.fillEntityKeyValue(var1);
      }

      if (StringHelper.isNullOrEmpty(var1.getCodeName())) {
         if (isEnableCodeNameUpperCamel()) {
            var1.setCodeName(toUpperCamel(var12));
         } else {
            var1.setCodeName(var12);
         }
      }

      if (var10 == null) {
         if (DataObject.getBoolValue(var1.getSystemFlag(), false)) {
            if (StringHelper.isNullOrEmpty(var1.getTableName())) {
               var1.setTableName(StringHelper.format("ST_%1$s", var12));
            }

            if (StringHelper.isNullOrEmpty(var1.getViewName())) {
               var1.setViewName(StringHelper.format("SV_%1$s", var12));
            }
         } else {
            if (StringHelper.isNullOrEmpty(var1.getTableName())) {
               var1.setTableName(StringHelper.format("T_%1$s", var12));
            }

            if (StringHelper.isNullOrEmpty(var1.getViewName())) {
               var1.setViewName(StringHelper.format("V_%1$s", var12));
            }

            if (StringHelper.isNullOrEmpty(var1.getViewName2())) {
               var1.setViewName2(StringHelper.format("V2_%1$s", var12));
            }

            if (StringHelper.isNullOrEmpty(var1.getViewName3())) {
               var1.setViewName3(StringHelper.format("V3_%1$s", var12));
            }

            if (StringHelper.isNullOrEmpty(var1.getViewName4())) {
               var1.setViewName4(StringHelper.format("V4_%1$s", var12));
            }
         }
      } else {
         String var5 = "";
         String var6 = "";
         String var7 = "";
         String var8 = "";
         String var9 = "";
         if (DataObject.getBoolValue(var10.getTablePrefixFlag(), true)) {
            var5 = var10.getTablePrefix();
            if (StringHelper.isNullOrEmpty(var5)) {
               if (DataObject.getBoolValue(var1.getSystemFlag(), false)) {
                  var5 = "ST_";
               } else {
                  var5 = "T_";
               }
            }
         }

         if (DataObject.getBoolValue(var10.getViewPrefixFlag(), true)) {
            var6 = var10.getViewPrefix();
            if (StringHelper.isNullOrEmpty(var6)) {
               if (DataObject.getBoolValue(var1.getSystemFlag(), false)) {
                  var6 = "SV_";
               } else {
                  var6 = "V_";
               }
            }

            var7 = var10.getView2Prefix();
            if (StringHelper.isNullOrEmpty(var7)) {
               if (DataObject.getBoolValue(var1.getSystemFlag(), false)) {
                  var7 = "SV2_";
               } else {
                  var7 = "V2_";
               }
            }

            var8 = var10.getView3Prefix();
            if (StringHelper.isNullOrEmpty(var8)) {
               if (DataObject.getBoolValue(var1.getSystemFlag(), false)) {
                  var8 = "SV3_";
               } else {
                  var8 = "V3_";
               }
            }

            var9 = var10.getView4Prefix();
            if (StringHelper.isNullOrEmpty(var9)) {
               if (DataObject.getBoolValue(var1.getSystemFlag(), false)) {
                  var9 = "SV4_";
               } else {
                  var9 = "V4_";
               }
            }
         }

         if (StringHelper.isNullOrEmpty(var1.getTableName())) {
            var1.setTableName(StringHelper.format("%1$s%2$s", var5, var12));
         }

         if (StringHelper.isNullOrEmpty(var1.getViewName())) {
            var1.setViewName(StringHelper.format("%1$s%2$s", var6, var12));
         }

         if (StringHelper.isNullOrEmpty(var1.getViewName2())) {
            var1.setViewName2(StringHelper.format("%1$s%2$s", var7, var12));
         }

         if (StringHelper.isNullOrEmpty(var1.getViewName3())) {
            var1.setViewName3(StringHelper.format("%1$s%2$s", var8, var12));
         }

         if (StringHelper.isNullOrEmpty(var1.getViewName4())) {
            var1.setViewName4(StringHelper.format("%1$s%2$s", var9, var12));
         }
      }

      int var14 = DataObject.getIntegerValue(var1.getVirtualFlag(), 0);
      if (var14 > 0) {
         if (var14 != 4 && var14 != 5) {
            var1.resetTableName();
         }

         if (var14 == 3 && StringHelper.compare(var1.getIndexDEType(), "INDEX", false) != 0) {
            this.sendStudioConsole(true, "INFO", StringHelper.format("设置实体[%1$s]索引类型[索引主实体]", var1.getPSDataEntityName()), false);
            var1.setIndexDEType("INDEX");
         }
      }

      if (DataObject.getBoolValue(var1.getNoViewMode(), false)) {
         var1.resetViewName();
         var1.resetViewName2();
         var1.resetViewName3();
         var1.resetViewName4();
      }
   }

   protected void onBeforeUpdate(PSDataEntity var1) throws Exception {
      if (var1.isExistingModelDirty()
         && var1.isNoViewModeDirty()
         && var1.isViewName2Dirty()
         && var1.isViewName3Dirty()
         && var1.isViewName4Dirty()
         && var1.isViewNameDirty()
         && var1.isTableNameDirty()
         && !DataObject.getBoolValue(var1.getNoViewMode(), false)
         && !DataObject.getBoolValue(var1.getExistingModel(), false)
         && (
            StringHelper.isNullOrEmpty(var1.getViewName2())
               || StringHelper.isNullOrEmpty(var1.getViewName3())
               || StringHelper.isNullOrEmpty(var1.getViewName4())
         )) {
         PSDCModelTempl var2 = null;
         boolean var3 = false;
         if (DataObject.getBoolValue(var1.getExistingModel(), false)) {
            var3 = true;
         }

         if (!var3 && var1.getPSModule() != null && DataObject.getBoolValue(var1.getPSModule().getSubSysModule(), false)) {
            var3 = true;
         }

         if (!var3) {
            PSSystem var4 = var1.getPSSystem();
            if (!StringHelper.isNullOrEmpty(var4.getPSDevSlnSysId())) {
               var2 = PSModelGlobal.getPSDCModelTempl(var4.getPSDevSlnSysId());
            }
         }

         String var9 = var1.getPSDataEntityName().toUpperCase();
         if (var2 != null && var2.getDENameMaxLength() != null && var2.getDENameMaxLength() > 0 && var9.length() > var2.getDENameMaxLength()) {
            throw new Exception(StringHelper.format("模型模板[%1$s]定义实体名称长度不能超过[%2$s]", var2.getPSDCModelTemplName(), var2.getDENameMaxLength()));
         }

         var1.setPSDataEntityName(var9);
         if (StringHelper.isNullOrEmpty(var1.getCodeName())) {
            if (isEnableCodeNameUpperCamel()) {
               var1.setCodeName(toUpperCamel(var9));
            } else {
               var1.setCodeName(var9);
            }
         }

         if (var2 == null) {
            if (DataObject.getBoolValue(var1.getSystemFlag(), false)) {
               if (StringHelper.isNullOrEmpty(var1.getTableName())) {
                  var1.setTableName(StringHelper.format("ST_%1$s", var9));
               }

               if (StringHelper.isNullOrEmpty(var1.getViewName())) {
                  var1.setViewName(StringHelper.format("SV_%1$s", var9));
               }
            } else {
               if (StringHelper.isNullOrEmpty(var1.getTableName())) {
                  var1.setTableName(StringHelper.format("T_%1$s", var9));
               }

               if (StringHelper.isNullOrEmpty(var1.getViewName())) {
                  var1.setViewName(StringHelper.format("V_%1$s", var9));
               }

               if (StringHelper.isNullOrEmpty(var1.getViewName2())) {
                  var1.setViewName2(StringHelper.format("V2_%1$s", var9));
               }

               if (StringHelper.isNullOrEmpty(var1.getViewName3())) {
                  var1.setViewName3(StringHelper.format("V3_%1$s", var9));
               }

               if (StringHelper.isNullOrEmpty(var1.getViewName4())) {
                  var1.setViewName4(StringHelper.format("V4_%1$s", var9));
               }
            }
         } else {
            String var10 = "";
            String var5 = "";
            String var6 = "";
            String var7 = "";
            String var8 = "";
            if (DataObject.getBoolValue(var2.getTablePrefixFlag(), true)) {
               var10 = var2.getTablePrefix();
               if (StringHelper.isNullOrEmpty(var10)) {
                  if (DataObject.getBoolValue(var1.getSystemFlag(), false)) {
                     var10 = "ST_";
                  } else {
                     var10 = "T_";
                  }
               }
            }

            if (DataObject.getBoolValue(var2.getViewPrefixFlag(), true)) {
               var5 = var2.getViewPrefix();
               if (StringHelper.isNullOrEmpty(var5)) {
                  if (DataObject.getBoolValue(var1.getSystemFlag(), false)) {
                     var5 = "SV_";
                  } else {
                     var5 = "V_";
                  }
               }

               var6 = var2.getView2Prefix();
               if (StringHelper.isNullOrEmpty(var6)) {
                  if (DataObject.getBoolValue(var1.getSystemFlag(), false)) {
                     var6 = "SV2_";
                  } else {
                     var6 = "V2_";
                  }
               }

               var7 = var2.getView3Prefix();
               if (StringHelper.isNullOrEmpty(var7)) {
                  if (DataObject.getBoolValue(var1.getSystemFlag(), false)) {
                     var7 = "SV3_";
                  } else {
                     var7 = "V3_";
                  }
               }

               var8 = var2.getView4Prefix();
               if (StringHelper.isNullOrEmpty(var8)) {
                  if (DataObject.getBoolValue(var1.getSystemFlag(), false)) {
                     var8 = "SV4_";
                  } else {
                     var8 = "V4_";
                  }
               }
            }

            if (StringHelper.isNullOrEmpty(var1.getTableName())) {
               var1.setTableName(StringHelper.format("%1$s%2$s", var10, var9));
            }

            if (StringHelper.isNullOrEmpty(var1.getViewName())) {
               var1.setViewName(StringHelper.format("%1$s%2$s", var5, var9));
            }

            if (StringHelper.isNullOrEmpty(var1.getViewName2())) {
               var1.setViewName2(StringHelper.format("%1$s%2$s", var6, var9));
            }

            if (StringHelper.isNullOrEmpty(var1.getViewName3())) {
               var1.setViewName3(StringHelper.format("%1$s%2$s", var7, var9));
            }

            if (StringHelper.isNullOrEmpty(var1.getViewName4())) {
               var1.setViewName4(StringHelper.format("%1$s%2$s", var8, var9));
            }
         }

         int var11 = DataObject.getIntegerValue(var1.getVirtualFlag(), 0);
         if (var11 > 0 && var11 != 4 && var11 != 5) {
            var1.resetTableName();
         }

         if (DataObject.getBoolValue(var1.getNoViewMode(), false)) {
            var1.resetViewName();
            var1.resetViewName2();
            var1.resetViewName3();
            var1.resetViewName4();
         }
      }

      super.onBeforeUpdate(var1);
   }

   @Override
   protected void onSyncInheritDEField(PSDataEntity var1) throws Exception {
      if (!var1.isFullEntity()) {
         this.get(var1);
      }

      PSDERService var2 = (PSDERService)ServiceGlobal.getService(PSDERService.class, this.getSessionFactory());
      int var3 = DataObject.getIntegerValue(var1.getVirtualFlag(), 0);
      if (var3 != 1 && var3 != 4 && var3 != 5) {
         if (var3 == 0) {
            PSDER var23 = new PSDER();
            var23.setMinorPSDEId(var1.getPSDataEntityId());
            var23.setDERType("DERINHERIT");
            if (!var2.select(var23, true)) {
               throw new Exception(StringHelper.format("实体[%1$s]没有定义继承关系", var1.getPSDataEntityName()));
            }

            boolean var24 = DataObject.getIntegerValue(var23.getDEFInheritMode(), 1) == 1;
            String var26 = var23.getIgnoreDEFields();
            HashMap var29 = new HashMap();
            HashMap var31 = new HashMap();
            if (!StringHelper.isNullOrEmpty(var26)) {
               var26 = var26.toUpperCase();
               String[] var32 = StringHelper.splitEx(var26);
               if (var32.length > 1) {
                  for (String var47 : var32) {
                     var47 = var47.trim();
                     if (!StringHelper.isNullOrEmpty(var47)) {
                        if (var24) {
                           var29.put(var47, "");
                        } else {
                           var31.put(var47, "");
                        }
                     }
                  }
               } else {
                  Properties var34 = PropertiesHelper.load(var26);

                  for (Object var40 : var34.keySet()) {
                     String var45 = (String)var40;
                     var45 = var45.trim();
                     if (!StringHelper.isNullOrEmpty(var45)) {
                        if (var24) {
                           var29.put(var45, "");
                        } else {
                           var31.put(var45, "");
                        }
                     }
                  }
               }
            }

            boolean var33 = false;
            boolean var36 = false;
            PSDEFieldService var39 = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, this.getSessionFactory());

            for (PSDEField var53 : var39.selectByPSDE(var1)) {
               var29.put(var53.getPSDEFieldName().toUpperCase(), "");
               if (DataObject.getBoolValue(var53.getPKey(), false)) {
                  var33 = true;
               }

               if (DataObject.getBoolValue(var53.getMajorField(), false)) {
                  var36 = true;
               }
            }

            PSDataEntity var50 = new PSDataEntity();
            var50.setPSDataEntityId(var23.getMajorPSDEId());

            for (PSDEField var55 : var39.selectByPSDE(var50)) {
               if ((!DataObject.getBoolValue(var55.getPKey(), false) || !var33)
                  && (!DataObject.getBoolValue(var55.getMajorField(), false) || !var36)
                  && !var29.containsKey(var55.getPSDEFieldName().toUpperCase())
                  && (var24 || var31.containsKey(var55.getPSDEFieldName().toUpperCase()))) {
                  PSDEField var57 = new PSDEField();
                  var55.copyTo(var57, false);
                  var57.remove("FORMULAFORMAT");
                  var57.remove("FORMULAFIELDS");
                  var57.remove("PSDEFIELDID");
                  var57.remove("PSDATATYPEID");
                  var57.remove("PSDATATYPENAME");
                  var57.remove("INDEXTYPE");
                  var57.remove("MULTIFORMFIELD");
                  var57.setPSDataTypeId("INHERIT");
                  var57.setPSDEId(var1.getPSDataEntityId());
                  var57.setPSDEName(var1.getPSDataEntityName());
                  var57.setPSDERId(var23.getPSDERId());
                  var57.setPSDERName(var23.getPSDERName());
                  var57.setDERPSDEFId(var55.getPSDEFieldId());
                  var57.setDERPSDEFName(var55.getPSDEFieldName());
                  var39.create(var57, false);
               }
            }
         }
      } else {
         HashMap var4 = new HashMap();
         PSDEFieldService var5 = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, this.getSessionFactory());

         for (PSDEField var8 : var5.selectByPSDE(var1)) {
            var4.put(var8.getPSDEFieldName().toUpperCase(), "");
         }

         SelectCond var28 = new SelectCond();
         var28.set("DERTYPE", "DERMULINH");
         var28.set("MINORPSDEID", var1.getPSDataEntityId());
         var28.setOrderInfo("ORDER BY ORDERVALUE");
         ArrayList<PSDER> var30 = var2.select(var28);
         if (var30.size() == 0) {
            throw new Exception(StringHelper.format("实体[%1$s]没有定义继承关系", var1.getPSDataEntityName()));
         }

         for (PSDER var10 : var30) {
            PSDataEntity var11 = new PSDataEntity();
            var11.setPSDataEntityId(var10.getMajorPSDEId());
            ArrayList<PSDEField> var25 = var5.selectByPSDE(var11);
            HashMap var12 = new HashMap();

            for (PSDEField var14 : var25) {
               var12.put(var14.getPSDEFieldName(), var14);
            }

            boolean var44 = DataObject.getIntegerValue(var10.getDEFInheritMode(), 1) == 1;
            String var51 = var10.getIgnoreDEFields();
            if (!StringHelper.isNullOrEmpty(var51)) {
               var51 = var51.toUpperCase();
            } else {
               var51 = "";
            }

            Properties var15 = PropertiesHelper.load(var51);
            if (var44) {
               HashMap var56 = new HashMap();

               for (Object var60 : var15.keySet()) {
                  String var62 = (String)var60;
                  String var64 = PropertiesHelper.getProperty(var15, var62);
                  if (StringHelper.isNullOrEmpty(var64)) {
                     var64 = var62;
                  }

                  var56.put(var64, var62);
               }

               for (PSDEField var61 : var25) {
                  if (!var56.containsKey(var61.getPSDEFieldName()) && !var4.containsKey(var61.getPSDEFieldName())) {
                     PSDEField var63 = new PSDEField();
                     var61.copyTo(var63, false);
                     if (!StringHelper.isNullOrEmpty(var61.getCodeName())) {
                        PSDEField var65 = new PSDEField();
                        var65.setPSDEId(var1.getPSDataEntityId());
                        var65.setCodeName(var61.getCodeName());
                        if (var5.select(var65, true)) {
                           var63.remove("CODENAME");
                        }
                     }

                     var63.remove("FORMULAFORMAT");
                     var63.remove("FORMULAFIELDS");
                     var63.remove("PSDEFIELDID");
                     var63.remove("PSDATATYPEID");
                     var63.remove("PSDATATYPENAME");
                     var63.remove("INDEXTYPE");
                     var63.remove("MULTIFORMFIELD");
                     var63.remove("MAJORFIELD");
                     var63.remove("PKEY");
                     var63.remove("FKEY");
                     var63.setDEFType(3);
                     var63.setPhysicalField(0);
                     var63.setPSDataTypeId("INHERIT");
                     var63.setPSDEId(var1.getPSDataEntityId());
                     var63.setPSDEName(var1.getPSDataEntityName());
                     var63.setMajorField(0);
                     var63.setPSDERId(var10.getPSDERId());
                     var63.setPSDERName(var10.getPSDERName());
                     var63.setDERPSDEFId(var61.getPSDEFieldId());
                     var63.setDERPSDEFName(var61.getPSDEFieldName());
                     var5.create(var63, false);
                     var4.put(var63.getPSDEFieldName(), "");
                  }
               }
            } else {
               for (Object var17 : var15.keySet()) {
                  String var18 = (String)var17;
                  if (!var4.containsKey(var18)) {
                     String var19 = PropertiesHelper.getProperty(var15, var18);
                     if (StringHelper.isNullOrEmpty(var19)) {
                        var19 = var18;
                     }

                     PSDEField var20 = (PSDEField)var12.get(var19);
                     if (var20 == null) {
                        throw new Exception(StringHelper.format("实体[%1$s]不存在属性[%2$s]", var10.getMajorPSDEName(), var19));
                     }

                     PSDEField var21 = new PSDEField();
                     var20.copyTo(var21, false);
                     if (!StringHelper.isNullOrEmpty(var20.getCodeName())) {
                        PSDEField var22 = new PSDEField();
                        var22.setPSDEId(var1.getPSDataEntityId());
                        var22.setCodeName(var20.getCodeName());
                        if (var5.select(var22, true)) {
                           var21.remove("CODENAME");
                        }
                     }

                     var21.remove("FORMULAFORMAT");
                     var21.remove("FORMULAFIELDS");
                     var21.remove("PSDEFIELDID");
                     var21.remove("PSDATATYPEID");
                     var21.remove("PSDATATYPENAME");
                     var21.remove("INDEXTYPE");
                     var21.remove("MULTIFORMFIELD");
                     var21.remove("MAJORFIELD");
                     var21.remove("PKEY");
                     var21.remove("FKEY");
                     var21.setDEFType(3);
                     var21.setPhysicalField(0);
                     var21.setPSDataTypeId("INHERIT");
                     var21.setPSDEId(var1.getPSDataEntityId());
                     var21.setPSDEName(var1.getPSDataEntityName());
                     var21.setPSDEFieldName(var18);
                     var21.setMajorField(0);
                     var21.setPSDERId(var10.getPSDERId());
                     var21.setPSDERName(var10.getPSDERName());
                     var21.setDERPSDEFId(var20.getPSDEFieldId());
                     var21.setDERPSDEFName(var20.getPSDEFieldName());
                     var5.create(var21, false);
                     var4.put(var18, "");
                  }
               }
            }
         }
      }
   }

   public String checkObjCodeName(PSDataEntity var1, Object var2, String var3) throws Exception {
      PSDEFieldService var4 = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, this.getSessionFactory());

      for (PSDEField var7 : var4.selectByPSDE(var1)) {
         String var8 = var7.getCodeName();
         if (StringHelper.isNullOrEmpty(var8)) {
            var8 = var7.getPSDEFieldName();
         }

         if (StringHelper.compare(var8, var3, true) == 0) {
            if (var2 != null && var2 instanceof PSDEField) {
               PSDEField var9 = (PSDEField)var2;
               if (StringHelper.compare(var7.getPSDEFieldId(), var9.getPSDEFieldId(), false) == 0) {
                  return null;
               }
            }

            if (var2 != null && var2 instanceof PSDER) {
               PSDER var15 = (PSDER)var2;
               if (StringHelper.compare(var7.getPSDataTypeId(), "ONE2MANYDATA", false) == 0
                  && StringHelper.compare(var7.getO2MPSDERId(), var15.getPSDERId(), false) == 0) {
                  return null;
               }
            }

            return StringHelper.format("实体属性[%1$s]", var7.getPSDEFieldName());
         }
      }

      PSDERService var12 = (PSDERService)ServiceGlobal.getService(PSDERService.class, this.getSessionFactory());

      for (PSDER var16 : var12.selectByMinorPSDE(var1)) {
         String var10 = var16.getCodeName();
         if (!StringHelper.isNullOrEmpty(var10) && StringHelper.compare(var10, var3, true) == 0) {
            if (var2 != null && var2 instanceof PSDER) {
               PSDER var19 = (PSDER)var2;
               if (StringHelper.compare(var16.getPSDERId(), var19.getPSDERId(), false) == 0) {
                  return null;
               }
            }

            if (var2 != null && var2 instanceof PSDEField) {
               PSDEField var20 = (PSDEField)var2;
               if (StringHelper.compare(var20.getPSDataTypeId(), "PICKUPOBJECT", false) == 0
                  && StringHelper.compare(var20.getPSDERId(), var16.getPSDERId(), false) == 0) {
                  return null;
               }
            }

            return StringHelper.format("实体关系[%1$s]", var16.getPSDERName());
         }

         var10 = var16.getMinorCodeName();
         if (!StringHelper.isNullOrEmpty(var10) && StringHelper.compare(var10, var3, true) == 0) {
            if (var2 != null && var2 instanceof PSDER) {
               PSDER var11 = (PSDER)var2;
               if (StringHelper.compare(var16.getPSDERId(), var11.getPSDERId(), false) == 0) {
                  return null;
               }

               if (StringHelper.compare(var16.getMajorPSDEId(), var11.getMajorPSDEId(), false) != 0) {
                  return null;
               }
            }

            if (var2 != null && var2 instanceof PSDEField) {
               PSDEField var18 = (PSDEField)var2;
               if (StringHelper.compare(var18.getPSDataTypeId(), "ONE2MANYDATA", false) == 0
                  && StringHelper.compare(var18.getO2MPSDERId(), var16.getPSDERId(), false) == 0) {
                  return null;
               }
            }

            return StringHelper.format("实体关系[%1$s]", var16.getPSDERName());
         }
      }

      return null;
   }

   public String checkDEFieldName(PSDataEntity var1, Object var2, String var3) throws Exception {
      PSDEFieldService var4 = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, this.getSessionFactory());

      for (PSDEField var7 : var4.selectByPSDE(var1)) {
         if (StringHelper.compare(var3, var7.getPSDEFieldName(), false) == 0) {
            if (var2 != null && var2 instanceof PSDEField) {
               PSDEField var8 = (PSDEField)var2;
               if (StringHelper.compare(var7.getPSDEFieldId(), var8.getPSDEFieldId(), false) == 0) {
                  return null;
               }
            }

            return StringHelper.format("实体属性[%1$s]", var7.getPSDEFieldName());
         }
      }

      return null;
   }

   protected void onInitModel(PSDataEntity var1) throws Exception {
      super.onInitModel(var1);
      PSSystem var2 = getCurrentPSSystem(var1, this.getSessionFactory());
      if (DataObject.getBoolValue(var2.getEnableMultiLan(), isEnableI18NDefault())) {
         this.initPSDataEntityLanRes(var1, false);
      }

      PSSysSFPub var3 = getCurrentDefaultPSSysSFPub(var1, this.getSessionFactory());
      if (var3 != null && "RUNTIME".equals(var3.getDynaModelMode())) {
         this.initModelRTModes(var1);
      }
   }

   protected void initPSDataEntityLanRes(PSDataEntity var1, boolean var2) throws Exception {
      boolean var3 = false;
      PSSysSFPub var4 = getCurrentDefaultPSSysSFPub(var1, this.getSessionFactory());
      if (var4 != null && "RUNTIME".equals(var4.getDynaModelMode())) {
         var3 = true;
      }

      PSLanguageResService var5 = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, this.getSessionFactory());
      if (var1.getLNPSLanResId() == null) {
         PSLanguageRes var6 = new PSLanguageRes();
         var6.setPSSystemId(var1.getPSSystemId());
         var6.setLanResType("DE.LNAME");
         var6.setUserData(var1.getPSDataEntityName());
         var6.setPSDEId(var1.getPSDataEntityId());
         var6.setPSDEName(var1.getPSDataEntityName());
         if (var5.checkKey(var6) == 0) {
            var6.setContent(var1.getLogicName());
            if (var3) {
               var6.setPSModuleId(var1.getPSModuleId());
               var6.setPSModuleName(var1.getPSModuleName());
               var5.save(var6);
            } else {
               var5.create(var6);
            }

            String var7 = var1.getPSDataEntityId();
            var1.reset();
            var1.setPSDataEntityId(var7);
            var1.setLNPSLanResId(var6.getPSLanguageResId());
            var1.setLNPSLanResName(var6.getPSLanguageResName());
            this.update(var1);
         }
      } else if (var2) {
         PSLanguageRes var21 = var1.getLNPSLanRes();
         if (StringHelper.compare(var21.getContent(), var1.getLogicName(), false) != 0) {
            var21.reset();
            var21.setPSSystemId(var1.getPSSystemId());
            if (var3) {
               var21.setPSModuleId(var1.getPSModuleId());
               var21.setPSModuleName(var1.getPSModuleName());
            }

            var21.setLanResType("DE.LNAME");
            var21.setUserData(var1.getPSDataEntityName());
            var21.setPSDEId(var1.getPSDataEntityId());
            var21.setPSDEName(var1.getPSDataEntityName());
            var21.setContent(var1.getLogicName());
            var5.save(var21);
            String var23 = var1.getPSDataEntityId();
            var1.reset();
            var1.setPSDataEntityId(var23);
            var1.setLNPSLanResId(var21.getPSLanguageResId());
            var1.setLNPSLanResName(var21.getPSLanguageResName());
            this.update(var1);
         }
      }

      PSDEFieldService var22 = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, this.getSessionFactory());
      PSDEFUIModeService var24 = (PSDEFUIModeService)ServiceGlobal.getService(PSDEFUIModeService.class, this.getSessionFactory());
      PSDEFSFItemService var8 = (PSDEFSFItemService)ServiceGlobal.getService(PSDEFSFItemService.class, this.getSessionFactory());

      for (PSDEField var11 : var1.getPSDEFields()) {
         if (var11.getLNPSLanResId() == null) {
            PSLanguageRes var27 = new PSLanguageRes();
            var27.setPSSystemId(var1.getPSSystemId());
            var27.setLanResType("DEF.LNAME");
            var27.setUserData(var11.getPSDEFieldName());
            boolean var31 = false;
            if (var3) {
               if (!StringHelper.isNullOrEmpty(var11.getPreDefineType())) {
                  if (!"NONE".equals(var11.getPreDefineType())) {
                     var31 = true;
                  }
               } else {
                  var31 = predefinedFieldMap.containsKey(var11.getPSDEFieldName());
               }
            } else {
               var31 = true;
            }

            if (var31 && var5.select(var27, true)) {
               if (StringHelper.compare(var27.getContent(), var11.getLogicName(), false) != 0) {
                  var27.resetPSLanguageResId();
                  var27.resetPSLanguageResName();
                  var27.resetCodeName();
                  if (var3) {
                     var27.setPSModuleId(var1.getPSModuleId());
                     var27.setPSModuleName(var1.getPSModuleName());
                  }

                  var27.setPSDEId(var11.getPSDEId());
                  var27.setPSDEName(var11.getPSDEName());
                  var27.setPSDEFId(var11.getPSDEFieldId());
                  var27.setPSDEFName(var11.getPSDEFieldName());
                  var27.setUserData(StringHelper.format("%1$s.%2$s", var11.getPSDEName(), var11.getPSDEFieldName()));
                  var27.setContent(var11.getLogicName());
                  if (var5.fillEntityKeyValue(var27)) {
                     if (var5.checkKey(var27) == 0) {
                        var5.create(var27);
                     } else {
                        var5.get(var27);
                     }
                  } else {
                     var5.create(var27);
                  }
               }
            } else if (!var31) {
               var27.setPSDEId(var11.getPSDEId());
               var27.setPSDEName(var11.getPSDEName());
               var27.setPSDEFId(var11.getPSDEFieldId());
               var27.setPSDEFName(var11.getPSDEFieldName());
               var27.setUserData(StringHelper.format("%1$s.%2$s", var11.getPSDEName(), var11.getPSDEFieldName()));
               if (var5.checkKey(var27) == 0) {
                  var27.setContent(var11.getLogicName());
                  if (var3) {
                     var27.setPSModuleId(var1.getPSModuleId());
                     var27.setPSModuleName(var1.getPSModuleName());
                     var5.save(var27);
                  } else {
                     var5.create(var27);
                  }
               } else {
                  var5.get(var27);
               }
            } else {
               var27.setContent(var11.getLogicName());
               var5.create(var27);
            }

            String var14 = var11.getPSDEFieldId();
            var11.reset();
            var11.setPSDEFieldId(var14);
            var11.setLNPSLanResId(var27.getPSLanguageResId());
            var11.setLNPSLanResName(var27.getPSLanguageResName());
            var22.update(var11);
         } else if (var2) {
            PSLanguageRes var12 = var11.getLNPSLanRes();
            if (StringHelper.compare(var12.getContent(), var11.getLogicName(), false) != 0) {
               var12.reset();
               var12.setPSSystemId(var1.getPSSystemId());
               var12.setLanResType("DEF.LNAME");
               if (var3) {
                  var12.setPSModuleId(var1.getPSModuleId());
                  var12.setPSModuleName(var1.getPSModuleName());
               }

               var12.setPSDEId(var11.getPSDEId());
               var12.setPSDEName(var11.getPSDEName());
               var12.setPSDEFId(var11.getPSDEFieldId());
               var12.setPSDEFName(var11.getPSDEFieldName());
               var12.setUserData(StringHelper.format("%1$s.%2$s", var11.getPSDEName(), var11.getPSDEFieldName()));
               var12.setContent(var11.getLogicName());
               var5.save(var12);
               String var13 = var11.getPSDEFieldId();
               var11.reset();
               var11.setPSDEFieldId(var13);
               var11.setLNPSLanResId(var12.getPSLanguageResId());
               var11.setLNPSLanResName(var12.getPSLanguageResName());
               var22.update(var11);
            }
         }

         for (PSDEFUIMode var36 : var11.getPSDEFUIModes()) {
            if (!StringHelper.isNullOrEmpty(var36.getCaption())) {
               if (var36.getCapPSLanResId() == null) {
                  for (int var41 = 0; var41 < 1000; var41++) {
                     PSLanguageRes var16 = new PSLanguageRes();
                     var16.setPSSystemId(var1.getPSSystemId());
                     if (var3) {
                        var16.setPSModuleId(var1.getPSModuleId());
                     }

                     var16.setLanResType("CONTROL");
                     var16.setUserData(StringHelper.format("DEFUIMODE.%1$s.%2$s.%3$s", var11.getPSDEName(), var11.getPSDEFieldName(), var41));
                     if (!var5.select(var16, true)) {
                        if (var3) {
                           var16.setPSModuleId(var1.getPSModuleId());
                           var16.setPSModuleName(var1.getPSModuleName());
                        }

                        var16.setPSDEId(var11.getPSDEId());
                        var16.setPSDEName(var11.getPSDEName());
                        var16.setPSDEFId(var11.getPSDEFieldId());
                        var16.setPSDEFName(var11.getPSDEFieldName());
                        var16.setContent(var36.getCaption());
                        var5.create(var16);
                        String var17 = var36.getPSDEFUIModeId();
                        var36.reset();
                        var36.setPSDEFUIModeId(var17);
                        var36.setCapPSLanResId(var16.getPSLanguageResId());
                        var36.setCapPSLanResName(var16.getPSLanguageResName());
                        var24.update(var36);
                        break;
                     }
                  }
               } else if (var2) {
                  PSLanguageRes var15 = var36.getCapPSLanRes();
                  if (StringHelper.compare(var15.getContent(), var36.getCaption(), false) != 0) {
                     var15.setContent(var36.getCaption());
                     var24.update(var36);
                  }
               }
            }
         }

         for (PSDEFSFItem var42 : var11.getPSDEFSFItems()) {
            if (var42.getCapPSLanResId() == null) {
               PSLanguageRes var46 = new PSLanguageRes();
               var46.setPSSystemId(var1.getPSSystemId());
               if (var3) {
                  var46.setPSModuleId(var1.getPSModuleId());
               }

               var46.setLanResType("CONTROL");
               var46.setUserData(StringHelper.format("DEFSFITEM.%1$s.%2$s", var11.getPSDEName(), var42.getPSDEFSFItemName()));
               if (!var5.select(var46, true)) {
                  if (var3) {
                     var46.setPSModuleId(var1.getPSModuleId());
                     var46.setPSModuleName(var1.getPSModuleName());
                  }

                  var46.setPSDEId(var11.getPSDEId());
                  var46.setPSDEName(var11.getPSDEName());
                  var46.setPSDEFId(var11.getPSDEFieldId());
                  var46.setPSDEFName(var11.getPSDEFieldName());
                  String var50 = var42.getCaption();
                  var46.setContent(var50);
                  var5.create(var46);
                  var50 = var42.getPSDEFSFItemId();
                  var42.reset();
                  var42.setPSDEFSFItemId(var50);
                  var42.setCapPSLanResId(var46.getPSLanguageResId());
                  var42.setCapPSLanResName(var46.getPSLanguageResName());
                  var8.update(var42);
               }
            }
         }
      }

      PSDEFormDetailService var25 = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, this.getSessionFactory());

      for (PSDEForm var34 : var1.getPSDEForms()) {
         for (PSDEFormDetail var47 : var34.getPSDEFormDetails()) {
            if (!StringHelper.isNullOrEmpty(var47.getCaption()) && var47.getCapPSLanResId() == null) {
               PSLanguageRes var52 = new PSLanguageRes();
               var52.setPSSystemId(var1.getPSSystemId());
               if (var3) {
                  var52.setPSModuleId(var1.getPSModuleId());
                  var52.setPSModuleName(var1.getPSModuleName());
               }

               var52.setPSDEId(var34.getPSDEId());
               var52.setPSDEName(var34.getPSDEName());
               var52.setLanResType("CONTROL");
               var52.setUserData(
                  StringHelper.format(
                        "DEFORM.%1$s.%2$s.%3$s.%4$s", var34.getPSDEName(), var34.getCodeName(), var47.getDetailType(), var47.getPSDEFormDetailName()
                     )
                     .toUpperCase()
               );
               if (!var5.select(var52, true)) {
                  var52.setContent(var47.getCaption());
                  var5.create(var52);
                  String var18 = var47.getPSDEFormDetailId();
                  var47.reset();
                  var47.setPSDEFormDetailId(var18);
                  var47.setCapPSLanResId(var52.getPSLanguageResId());
                  var47.setCapPSLanResName(var52.getPSLanguageResName());
                  var25.update(var47);
               }
            }
         }
      }

      PSDEGridColService var30 = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, this.getSessionFactory());

      for (PSDEGrid var44 : var1.getPSDEGrids()) {
         for (PSDEGridCol var55 : var44.getPSDEGridCols()) {
            if (!StringHelper.isNullOrEmpty(var55.getCaption()) && var55.getCapPSLanResId() == null) {
               PSLanguageRes var19 = new PSLanguageRes();
               var19.setPSSystemId(var1.getPSSystemId());
               if (var3) {
                  var19.setPSModuleId(var1.getPSModuleId());
                  var19.setPSModuleName(var1.getPSModuleName());
               }

               var19.setPSDEId(var44.getPSDEId());
               var19.setPSDEName(var44.getPSDEName());
               var19.setLanResType("CONTROL");
               var19.setUserData(
                  StringHelper.format(
                        "DEGRID.%1$s.%2$s.%3$s.%4$s", var44.getPSDEName(), var44.getCodeName(), var55.getGridColType(), var55.getPSDEGridColName()
                     )
                     .toUpperCase()
               );
               if (!var5.select(var19, true)) {
                  var19.setContent(var55.getCaption());
                  var5.create(var19);
                  String var20 = var55.getPSDEGridColId();
                  var55.reset();
                  var55.setPSDEGridColId(var20);
                  var55.setCapPSLanResId(var19.getPSLanguageResId());
                  var55.setCapPSLanResName(var19.getPSLanguageResName());
                  var30.update(var55);
               }
            }
         }
      }

      PSDEViewBaseService var40 = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, this.getSessionFactory());

      for (PSDEViewBase var54 : var1.getPSDEViewBases()) {
         PSDEViewBase var56 = new PSDEViewBase();
         var56.setPSDEViewBaseId(var54.getPSDEViewBaseId());
         boolean var57 = false;
         if (!StringHelper.isNullOrEmpty(var54.getTitle()) && StringHelper.isNullOrEmpty(var54.getTitlePSLanResId())) {
            PSLanguageRes var59 = new PSLanguageRes();
            var59.setPSSystemId(var1.getPSSystemId());
            if (var3) {
               var59.setPSModuleId(var1.getPSModuleId());
            }

            var59.setLanResType("PAGE");
            var59.setUserData(StringHelper.format("TITLE.%1$s.%2$s", var54.getPSDEName(), var54.getCodeName()).toUpperCase());
            if (!var5.select(var59, true)) {
               if (var3) {
                  var59.setPSModuleId(var1.getPSModuleId());
                  var59.setPSModuleName(var1.getPSModuleName());
               }

               var59.setPSDEId(var54.getPSDEId());
               var59.setPSDEName(var54.getPSDEName());
               var59.setPSDEViewBaseId(var54.getPSDEViewBaseId());
               var59.setPSDEViewBaseName(var54.getPSDEViewBaseName());
               var59.setContent(var54.getTitle());
               var5.create(var59);
               var56.setTitlePSLanResId(var59.getPSLanguageResId());
               var56.setTitlePSLanResName(var59.getPSLanguageResName());
               var57 = true;
            }
         } else if (var2 && var54.getTitlePSLanRes() != null) {
            PSLanguageRes var58 = var54.getTitlePSLanRes();
            if (StringHelper.compare(var58.getContent(), var54.getTitle(), false) != 0) {
               var58.reset();
               var58.setPSSystemId(var1.getPSSystemId());
               if (var3) {
                  var58.setPSModuleId(var1.getPSModuleId());
                  var58.setPSModuleName(var1.getPSModuleName());
               }

               var58.setLanResType("PAGE");
               var58.setUserData(StringHelper.format("TITLE.%1$s.%2$s", var54.getPSDEName(), var54.getCodeName()).toUpperCase());
               var58.setPSDEId(var54.getPSDEId());
               var58.setPSDEName(var54.getPSDEName());
               var58.setPSDEViewBaseId(var54.getPSDEViewBaseId());
               var58.setPSDEViewBaseName(var54.getPSDEViewBaseName());
               var58.setContent(var54.getTitle());
               var5.save(var58);
               var56.setTitlePSLanResId(var58.getPSLanguageResId());
               var56.setTitlePSLanResName(var58.getPSLanguageResName());
               var57 = true;
            }
         }

         if (!StringHelper.isNullOrEmpty(var54.getCaption()) && StringHelper.isNullOrEmpty(var54.getCapPSLanResId())) {
            PSLanguageRes var61 = new PSLanguageRes();
            var61.setPSSystemId(var1.getPSSystemId());
            if (var3) {
               var61.setPSModuleId(var1.getPSModuleId());
            }

            var61.setLanResType("PAGE");
            var61.setUserData(StringHelper.format("CAPTION.%1$s.%2$s", var54.getPSDEName(), var54.getCodeName()).toUpperCase());
            if (!var5.select(var61, true)) {
               if (var3) {
                  var61.setPSModuleId(var1.getPSModuleId());
                  var61.setPSModuleName(var1.getPSModuleName());
               }

               var61.setPSDEId(var54.getPSDEId());
               var61.setPSDEName(var54.getPSDEName());
               var61.setPSDEViewBaseId(var54.getPSDEViewBaseId());
               var61.setPSDEViewBaseName(var54.getPSDEViewBaseName());
               var61.setContent(var54.getCaption());
               var5.create(var61);
               var56.setCapPSLanResId(var61.getPSLanguageResId());
               var56.setCapPSLanResName(var61.getPSLanguageResName());
               var57 = true;
            }
         } else if (var2 && var54.getCapPSLanRes() != null) {
            PSLanguageRes var60 = var54.getCapPSLanRes();
            if (StringHelper.compare(var60.getContent(), var54.getCaption(), false) != 0) {
               var60.reset();
               var60.setPSSystemId(var1.getPSSystemId());
               if (var3) {
                  var60.setPSModuleId(var1.getPSModuleId());
                  var60.setPSModuleName(var1.getPSModuleName());
               }

               var60.setLanResType("PAGE");
               var60.setUserData(StringHelper.format("CAPTION.%1$s.%2$s", var54.getPSDEName(), var54.getCodeName()).toUpperCase());
               var60.setPSDEId(var54.getPSDEId());
               var60.setPSDEName(var54.getPSDEName());
               var60.setPSDEViewBaseId(var54.getPSDEViewBaseId());
               var60.setPSDEViewBaseName(var54.getPSDEViewBaseName());
               var60.setContent(var54.getCaption());
               var5.save(var60);
               var56.setCapPSLanResId(var60.getPSLanguageResId());
               var56.setCapPSLanResName(var60.getPSLanguageResName());
               var57 = true;
            }
         }

         if (!StringHelper.isNullOrEmpty(var54.getSubCaption()) && StringHelper.isNullOrEmpty(var54.getSubCapPSLanResId())) {
            PSLanguageRes var63 = new PSLanguageRes();
            var63.setPSSystemId(var1.getPSSystemId());
            if (var3) {
               var63.setPSModuleId(var1.getPSModuleId());
            }

            var63.setLanResType("PAGE");
            var63.setUserData(StringHelper.format("SUBCAP.%1$s.%2$s", var54.getPSDEName(), var54.getCodeName()).toUpperCase());
            if (!var5.select(var63, true)) {
               if (var3) {
                  var63.setPSModuleId(var1.getPSModuleId());
                  var63.setPSModuleName(var1.getPSModuleName());
               }

               var63.setPSDEId(var54.getPSDEId());
               var63.setPSDEName(var54.getPSDEName());
               var63.setPSDEViewBaseId(var54.getPSDEViewBaseId());
               var63.setPSDEViewBaseName(var54.getPSDEViewBaseName());
               var63.setContent(var54.getSubCaption());
               var5.create(var63);
               var56.setSubCapPSLanResId(var63.getPSLanguageResId());
               var56.setSubCapPSLanResName(var63.getPSLanguageResName());
               var57 = true;
            }
         } else if (var2 && var54.getSubCapPSLanRes() != null) {
            PSLanguageRes var62 = var54.getSubCapPSLanRes();
            if (StringHelper.compare(var62.getContent(), var54.getSubCaption(), false) != 0) {
               var62.reset();
               var62.setPSSystemId(var1.getPSSystemId());
               if (var3) {
                  var62.setPSModuleId(var1.getPSModuleId());
                  var62.setPSModuleName(var1.getPSModuleName());
               }

               var62.setLanResType("PAGE");
               var62.setUserData(StringHelper.format("SUBCAP.%1$s.%2$s", var54.getPSDEName(), var54.getCodeName()).toUpperCase());
               var62.setPSDEId(var54.getPSDEId());
               var62.setPSDEName(var54.getPSDEName());
               var62.setPSDEViewBaseId(var54.getPSDEViewBaseId());
               var62.setPSDEViewBaseName(var54.getPSDEViewBaseName());
               var62.setContent(var54.getSubCaption());
               var5.save(var62);
               var56.setSubCapPSLanResId(var62.getPSLanguageResId());
               var56.setSubCapPSLanResName(var62.getPSLanguageResName());
               var57 = true;
            }
         }

         if (var57) {
            var40.update(var56, false);
         }
      }
   }

   protected void onAfterCreate(PSDataEntity var1) throws Exception {
      if (!isImpSysModelNowEx()) {
         this.initPSDETables(var1);
      }

      super.onAfterCreate(var1);
   }

   protected void onAfterUpdate(PSDataEntity var1) throws Exception {
      if (!isImpSysModelNowEx()) {
         this.initPSDETables(var1);
      }

      super.onAfterUpdate(var1);
   }

   @Override
   protected void onBeforeRemove(PSDataEntity var1) throws Exception {
      PSDataEntity var2 = this.getLast(var1);
      if (DataObject.getIntegerValue(var2.getRemoveFlag(), 0) != 1) {
         throw new Exception(StringHelper.format("实体[%1$s]必须设置为[允许删除]才能删除", var2.getPSDataEntityName()));
      }

      if (!PSRTHelper.isRTDE(var2.getPSDataEntityName())) {
         PSSystemService var3 = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, this.getSessionFactory());
         PSSystem var4 = new PSSystem();
         var4.setPSSystemId(var2.getPSSystemId());
         var3.decreaseDECnt(var4);
      }

      super.onBeforeRemove(var1);
   }

   @Override
   protected boolean isPrepareLastForRemove() {
      return true;
   }

   protected void onAfterRemove(PSDataEntity var1) throws Exception {
      PSDataEntity var2 = this.getLast(var1);
      if (var2 != null && !StringHelper.isNullOrEmpty(var2.getPSSystemId())) {
         this.resetPSSysModelLogs(var2.getPSSystemId());
      }

      super.onAfterRemove(var1);
   }

   @Override
   protected boolean onMergeChild_PSDEFields(PSDataEntity var1) throws Exception {
      if (super.onMergeChild_PSDEFields(var1)) {
         PSDataEntity var2 = new PSDataEntity();
         var2.setPSDataEntityId(var1.getPSDataEntityId());
         this.get(var2);
         if (!PSRTHelper.isRTDE(var2.getPSDataEntityName())) {
            PSDCSysLic var3 = this.getPSSystemLic(var2);
            if (var3 != null) {
               PSDCSysLicService var4 = (PSDCSysLicService)ServiceGlobal.getService(PSDCSysLicService.class);
               var4.testLic(var3, "MAXDEFCNTPERDE", var1.getPSDEFieldsCnt());
            }

            return true;
         }
      }

      return false;
   }

   public PSDCSysLic getPSSystemLic(PSDataEntity var1) throws Exception {
      PSSystem var2 = var1.getPSSystem();
      if (var2 != null && !StringHelper.isNullOrEmpty(var2.getPSDevSlnSysId())) {
         PSDevSlnSysService var3 = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, PSCoreSysServiceBase.getCurMajorSessionFactory());
         PSDevSlnSys var4 = new PSDevSlnSys();
         var4.setPSDevSlnSysId(var2.getPSDevSlnSysId());
         var3.get(var4);
         return var4.getPSDCSysLic();
      } else {
         return null;
      }
   }

   @Override
   protected void onFixLanRes(PSDataEntity var1) throws Exception {
      this.get(var1);
      this.initPSDataEntityLanRes(var1, true);
   }

   @Override
   protected void onInitWFFields(PSDataEntity var1) throws Exception {
      String var2 = var1.getPSDataEntityId();
      PSDEFieldService var3 = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, this.getSessionFactory());
      PSDEField var4 = new PSDEField();
      var4.setPSDEId(var2);
      var4.setBizTag("WFINSTANCEID");
      if (!var3.select(var4, true)) {
         var4.setPSDEFieldName("WFINSTANCEID");
         var4.setCodeName("WFInstanceId");
         var4.setLogicName("工作流实例");
         var4.setDEFType(1);
         var4.setPSDataTypeId("TEXT");
         var4.setPSDataTypeName("文本，可指定长度");
         var4.setAllowEmpty(1);
         var3.save(var4);
      }

      var4.reset();
      var4.setPSDEId(var2);
      var4.setBizTag("WFSTATE");
      if (!var3.select(var4, true)) {
         var4.setPSDEFieldName("WFSTATE");
         var4.setCodeName("WFState");
         var4.setLogicName("工作流状态");
         var4.setDEFType(1);
         var4.setPSDataTypeId("WFSTATE");
         var4.setPSDataTypeName("工作流处理状态");
         var4.setAllowEmpty(1);
         var3.save(var4);
      }

      var4.reset();
      var4.setPSDEId(var2);
      var4.setBizTag("WFSTEP");
      if (!var3.select(var4, true)) {
         var4.setPSDEFieldName("WFSTEP");
         var4.setCodeName("WFStep");
         var4.setLogicName("工作流步骤");
         var4.setDEFType(1);
         var4.setPSDataTypeId("SSCODELIST");
         var4.setPSDataTypeName("单项选择(文本值)");
         var4.setAllowEmpty(1);
         var3.save(var4);
      }

      var4.reset();
      var4.setPSDEId(var2);
      var4.setBizTag("WFVERSION");
      if (!var3.select(var4, true)) {
         var4.setPSDEFieldName("WFVERSION");
         var4.setCodeName("WFVersion");
         var4.setLogicName("流程版本");
         var4.setDEFType(1);
         var4.setPSDataTypeId("TEXT");
         var4.setPSDataTypeName("文本，可指定长度");
         var4.setAllowEmpty(1);
         var3.save(var4);
      }

      var4.reset();
      var4.setPSDEId(var2);
      var4.setBizTag("WFUSERSTATE");
      if (!var3.select(var4, true)) {
         var4.setPSDEFieldName(var1.getPSDataEntityName() + "WFSTATE");
         String var5 = var1.getCodeName();
         if (StringHelper.isNullOrEmpty(var5)) {
            var5 = var1.getPSDataEntityName();
         }

         var4.setCodeName(StringHelper.format("%1$sWFState", var5));
         var4.setLogicName("业务状态");
         var4.setDEFType(1);
         var4.setPSDataTypeId("SSCODELIST");
         var4.setPSDataTypeName("单项选择(文本值)");
         var4.setAllowEmpty(1);
         var3.save(var4);
      }
   }

   @Override
   protected void onInitViewMsgFields(PSDataEntity var1) throws Exception {
      String var2 = var1.getPSDataEntityId();
      PSDEFieldService var3 = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, this.getSessionFactory());
      PSDEField var4 = new PSDEField();
      var4.setPSDEId(var2);
      var4.setPSDEFieldName("SRFVIEWID");
      if (!var3.select(var4, true)) {
         var4.setPSDEFieldName("SRFVIEWID");
         var4.setCodeName("SRFViewId");
         var4.setLogicName("视图标识");
         var4.setDEFType(1);
         var4.setPSDataTypeId("TEXT");
         var4.setPSDataTypeName("文本，可指定长度");
         var4.setLength(200);
         var4.setAllowEmpty(1);
         var3.save(var4);
      }

      var4.reset();
      var4.setPSDEId(var2);
      var4.setPSDEFieldName("SRFVIEWCLS");
      if (!var3.select(var4, true)) {
         var4.setPSDEFieldName("SRFVIEWCLS");
         var4.setCodeName("SRFViewCls");
         var4.setLogicName("视图类名");
         var4.setDEFType(1);
         var4.setPSDataTypeId("TEXT");
         var4.setPSDataTypeName("文本，可指定长度");
         var4.setLength(200);
         var4.setAllowEmpty(1);
         var3.save(var4);
      }
   }

   @Override
   protected void onInitDEImage(PSDataEntity var1) throws Exception {
      this.get(var1);
      if (StringHelper.isNullOrEmpty(var1.getPSSysImageId())) {
         PSSysImage var2 = new PSSysImage();
         var2.setSessionFactory(this.getSessionFactory());
         var2.setPSSystemId(var1.getPSSystemId());
         var2.setPSSystemName(var1.getPSSystemName());
         var2.setPSSysImageName(StringHelper.format("实体[%1$s][%2$s]", var1.getPSDataEntityName(), var1.getLogicName()));
         var2.setImagePath(StringHelper.format("default/de/icon_%1$s.png", var1.getPSDataEntityName().toLowerCase()));
         var2.setImagePathX(StringHelper.format("default/de/icon_%1$s@{0}x.png", var1.getPSDataEntityName().toLowerCase()));
         var2.create();
         String var3 = var1.getPSDataEntityId();
         var1.reset();
         var1.setPSDataEntityId(var3);
         var1.setPSSysImageId(var2.getPSSysImageId());
         var1.setPSSysImageName(var2.getPSSysImageName());
         this.update(var1);
      }
   }

   @Override
   protected void onEnableMob(PSDataEntity var1) throws Exception {
      this.get(var1);
      if (!DataObject.getBoolValue(var1.getEnableMob(), false)) {
         String var2 = var1.getPSDataEntityId();
         var1.reset();
         var1.setPSDataEntityId(var2);
         var1.setEnableMob(1);
         this.update(var1);
         this.initModel(var1);
      }
   }

   @Override
   protected String getEntityFolderKeyValue(PSDataEntity var1, PSSystem var2) throws Exception {
      SelectCond var3 = new SelectCond();
      var3.set("PSSYSTEMID", var1.getPSSystemId());
      var3.set("PSDATAENTITYNAME", var1.getPSDataEntityName());
      var3.set("PSSYSMODELGROUPID", SelectCond.ISNULL);
      var3.setFetchFirst(true);
      ArrayList var4 = this.select(var3);
      return var4.size() > 0
         ? ((PSDataEntity)var4.get(0)).getPSDataEntityId()
         : PSModelFolderKeyHelper.getModelKey(var1, var2, this.getDEModel().getName(), "", this.getSessionFactory());
   }

   public void getDraft(PSDataEntity var1) throws Exception {
      super.getDraft(var1);
      if (var1.getDEType() == null) {
         var1.setDEType(1);
      }

      if (StringHelper.isNullOrEmpty(var1.getPSDataEntityName()) && !StringHelper.isNullOrEmpty(var1.getPSSystemId())) {
         int var2 = 0;

         while (true) {
            var2++;
            PSDataEntity var3 = new PSDataEntity();
            var3.setPSSystemId(var1.getPSSystemId());
            var3.setPSDataEntityName(StringHelper.format("ENTITY%1$s", var2 == 1 ? "" : var2));
            if (!this.select(var3, true)) {
               var1.setPSDataEntityName(var3.getPSDataEntityName());
               var3.reset();
               var3.setPSSystemId(var1.getPSSystemId());
               var3.setLogicName(StringHelper.format("实体%1$s", var2 == 1 ? "" : var2));
               if (!this.select(var3, true)) {
                  var1.setLogicName(var3.getLogicName());
                  break;
               }
            }
         }
      }
   }

   protected void initPSDETables(PSDataEntity var1) throws Exception {
      PSDataEntity var2 = null;
      if (var1.isFullEntity()) {
         var2 = var1;
      } else {
         var2 = new PSDataEntity();
         var2.setPSDataEntityId(var1.getPSDataEntityId());
         this.get(var2);
      }

      this.onInitPSDETables(var2);
   }

   protected void onInitPSDETables(PSDataEntity var1) throws Exception {
      PSDETableService var2 = (PSDETableService)ServiceGlobal.getService(PSDETableService.class, this.getSessionFactory());
      ArrayList<PSDETable> var3 = var2.selectByPSDE(var1);
      HashMap<String, PSDETable> var4 = new HashMap<String, PSDETable>();

      for (PSDETable var6 : var3) {
         var4.put(var6.getPSSysDBTableId(), var6);
      }

      if ((DataObject.getIntegerValue(var1.getStorageMode(), DEStorageTypeCodeListModel.SQL) & DEStorageTypeCodeListModel.SQL)
         == DEStorageTypeCodeListModel.SQL) {
         String var17 = "DEFAULT";
         if (!StringHelper.isNullOrEmpty(var1.getDSLink())) {
            var17 = var1.getDSLink();
         }

         PSSysDBSchemeService var19 = (PSSysDBSchemeService)ServiceGlobal.getService(PSSysDBSchemeService.class, this.getSessionFactory());
         PSSysDBScheme var7 = null;
         SelectContext var8 = new SelectContext();
         var8.set("PSSYSTEMID", var1.getPSSystemId());
         var8.set("DSLINK", var17);
         ArrayList<PSSysDBScheme> var9 = var19.select(var8);
         if (var9 != null) {
            for (PSSysDBScheme var11 : var9) {
               if (!StringHelper.isNullOrEmpty(var1.getPSSysModelGroupId())
                  ? var1.getPSSysModelGroupId().equals(var11.getPSSysModelGroupId())
                  : StringHelper.isNullOrEmpty(var11.getPSSysModelGroupId())) {
                  var7 = var11;
                  break;
               }
            }
         }

         if (var7 == null && isCloudMode()) {
            var7 = new PSSysDBScheme();
            var7.setPSSysDBSchemeName(String.format("数据库体系[%1$s]", var17));
            var7.setPSSystemId(var1.getPSSystemId());
            var7.setDSLink(var17);
            if (!StringHelper.isNullOrEmpty(var1.getPSSysModelGroupId())) {
               var7.setPSSysModelGroupId(var1.getPSSysModelGroupId());
            }

            var19.create(var7);
         }

         if (var7 != null) {
            PSSysDBTableService var21 = (PSSysDBTableService)ServiceGlobal.getService(PSSysDBTableService.class, this.getSessionFactory());

            for (int var22 = 0; var22 < 1; var22++) {
               String var12 = "";
               String var13 = "";
               String var14 = "";
               if (var22 != 0) {
                  break;
               }

               var12 = var1.getTableName();
               var13 = "MAIN";
               var14 = var1.getLogicName();
               if (!StringHelper.isNullOrEmpty(var12)) {
                  PSSysDBTable var15 = new PSSysDBTable();
                  var15.setPSSysDBSchemeId(var7.getPSSysDBSchemeId());
                  var15.setPSSysDBTableName(var12.toUpperCase());
                  if (!var21.select(var15, true)) {
                     var15.setCodeName(var12);
                     var15.setLogicName(var14);
                     var15.setPSSysDBSchemeName(var7.getPSSysDBSchemeName());
                     var15.setTableType("TABLE");
                     var21.create(var15, true);
                  }

                  PSDETable var16 = (PSDETable)var4.remove(var15.getPSSysDBTableId());
                  if (var16 == null) {
                     var16 = new PSDETable();
                     var16.setPSDEId(var1.getPSDataEntityId());
                     var16.setPSSysDBTableId(var15.getPSSysDBTableId());
                     var16.setPSDEName(var1.getPSDataEntityName());
                     var16.setPSSysDBTableName(var15.getPSSysDBTableName());
                     var16.setPSDETableName(var15.getPSSysDBTableName());
                     var16.setTableType(var13);
                     EntityBase.setIgnoreCheck(var16, true);
                     var2.create(var16, true);
                  } else if (StringHelper.compare(var16.getTableType(), var13, false) != 0) {
                     var16.setTableType(var13);
                     EntityBase.setIgnoreCheck(var16, true);
                     var2.update(var16, false);
                  }
               }
            }
         }
      }

      for (PSDETable var20 : var4.values()) {
         var2.remove(var20);
      }
   }

   protected void compileCurModelV2(PSDataEntity var1, ObjectNode var2, String var3, String var4, int var5) throws Exception {
      PSCoreSysServiceBase.ModelV2 var6 = this.getLastCompileModelV2("PSSYSMODELGROUP");
      if (var6 != null) {
         String var7 = var6.key;
         var1.setPSSysModelGroupId(var7);
      }

      super.compileCurModelV2(var1, var2, var3, var4, var5);
   }

   public PSDEDataSet getDefaultPSDEDataSet(PSDataEntity var1, String var2) throws Exception {
      PSDEDataSetService var3 = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, this.getSessionFactory());
      ArrayList<PSDEDataSet> var4 = var3.selectByPSDE(var1);
      if (StringHelper.isNullOrEmpty(var2)) {
         for (PSDEDataSet var6 : var4) {
            if (DataObject.getBoolValue(var6.getDefaultMode(), false)) {
               return var6;
            }
         }
      }

      for (PSDEDataSet var8 : var4) {
         if (StringHelper.isNullOrEmpty(var2)) {
            if (StringHelper.isNullOrEmpty(var8.getPredefineType())) {
               return var8;
            }
         } else if (StringHelper.compare(var8.getPredefineType(), var2, false) == 0) {
            return var8;
         }
      }

      return null;
   }

   @Override
   protected void onInitDEMSViews(PSDataEntity var1) throws Exception {
   }

   @Override
   protected SelectContext getListDRDataFolderCond(
      PSMOSFile var1, IPSMOSFileFilter var2, IService var3, String var4, String var5, String var6, String var7, String var8
   ) throws Exception {
      if (StringHelper.compare(var5, "PSDEFID", true) == 0) {
         var5 = "PSDEID";
      }

      return super.getListDRDataFolderCond(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   @Override
   protected void onSyncDETableDEFields(PSDataEntity var1) throws Exception {
      if (!var1.isFullEntity()) {
         this.get(var1);
      }

      this.initPSDETables(var1);
      PSDETableService var2 = (PSDETableService)ServiceGlobal.getService(PSDETableService.class, this.getSessionFactory());

      for (PSDETable var5 : var2.selectByPSDE(var1)) {
         try {
            var2.syncDEFields(var5);
         } catch (Exception var7) {
            throw new Exception(StringHelper.format("同步实体数据表[%1$s]发生异常，%2$s", var5.getPSDETableName(), var7.getMessage()), var7);
         }
      }
   }

   @Override
   protected void onSyncSubSysSADEFields(PSDataEntity var1) throws Exception {
      if (!var1.isFullEntity()) {
         this.get(var1);
      }

      if (var1.getPSSubSysSADE() == null) {
         throw new Exception(StringHelper.format("未绑定外部接口实体"));
      }

      ArrayList<PSSubSysSADEField> var2 = var1.getPSSubSysSADE().getPSSubSysSADEFields();
      HashMap<String, PSSubSysSADEField> var3 = new HashMap<String, PSSubSysSADEField>();

      for (PSSubSysSADEField var5 : var2) {
         var3.put(var5.getPSSubSysSADEFieldName().toUpperCase(), var5);
      }

      boolean var15 = false;

      for (PSDEField var7 : var1.getPSDEFields()) {
         if (!StringHelper.isNullOrEmpty(var7.getPSDEFieldName())) {
            var3.remove(var7.getPSDEFieldName().toUpperCase());
            if (DataObject.getIntegerValue(var7.getPKey(), 0) == 1) {
               var15 = true;
            }
         }
      }

      PSDEFieldService var17 = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, this.getSessionFactory());

      for (PSSubSysSADEField var8 : var3.values()) {
         PSDEField var9 = new PSDEField();
         var9.setPSDEId(var1.getPSDataEntityId());
         var9.setPSDEName(var1.getPSDataEntityName());
         var9.setPSSubSysSADEFieldId(var8.getPSSubSysSADEFieldId());
         var9.setPSSubSysSADEFieldName(var8.getPSSubSysSADEFieldName());
         var9.setDEFType(1);
         var9.setPSDEFieldName(var8.getPSSubSysSADEFieldName().toUpperCase());
         if (!StringHelper.isNullOrEmpty(var8.getLogicName())) {
            var9.setLogicName(var8.getLogicName());
         } else {
            var9.setLogicName(var8.getPSSubSysSADEFieldName());
         }

         if (!StringHelper.isNullOrEmpty(var8.getCodeName())) {
            var9.setCodeName(var8.getCodeName());
         } else {
            var9.setCodeName(var8.getPSSubSysSADEFieldName());
         }

         var9.setAllowEmpty(DataObject.getIntegerValue(var8.getAllowEmpty(), 1));
         Integer var10 = var8.getStdDataType();
         if (var10 == null || var10 == 0) {
            throw new Exception(StringHelper.format("无法识别的数据列[%1$s]数据类型", var8.getPSSubSysSADEFieldName()));
         }

         int var11 = DataObject.getIntegerValue(var8.getLength(), -1);
         int var12 = DataObject.getIntegerValue(var8.getPrecision2(), -1);
         PSDEFDataTypeHelper.fillPSDEField(var9, var10, var11, var12);
         if (!var15 && DataObject.getIntegerValue(var8.getPKey(), 0) == 1) {
            var9.setPKey(1);
            var15 = true;
         }

         try {
            var17.create(var9);
         } catch (Exception var14) {
            throw new Exception(StringHelper.format("建立属性[%1$s]发生异常，%2$s", var9.getPSDEFieldName(), var14.getMessage()), var14);
         }
      }
   }

   @Override
   protected void onAutoSyncDEFields(PSDataEntity var1) throws Exception {
      if (!var1.isFullEntity()) {
         this.get(var1);
      }

      boolean var2 = false;
      if (var1.getPSSubSysSADE() != null) {
         this.sendStudioConsole(true, "INFO", StringHelper.format("实体[%1$s]开始从外部接口实体同步属性", var1.getPSDataEntityName()), false);
         this.syncSubSysSADEFields(var1);
         var2 = true;
      }

      if (DataObject.getIntegerValue(var1.getExistingModel(), 0) == 1) {
         this.sendStudioConsole(true, "INFO", StringHelper.format("实体[%1$s]开始从现有数据结构同步属性", var1.getPSDataEntityName()), false);
         this.syncDETableDEFields(var1);
         var2 = true;
      }

      PSDERService var3 = (PSDERService)ServiceGlobal.getService(PSDERService.class, this.getSessionFactory());
      int var4 = DataObject.getIntegerValue(var1.getVirtualFlag(), 0);
      if (var4 == 1 || var4 == 4 || var4 == 5) {
         SelectCond var7 = new SelectCond();
         var7.set("DERTYPE", "DERMULINH");
         var7.set("MINORPSDEID", var1.getPSDataEntityId());
         var7.setOrderInfo("ORDER BY ORDERVALUE");
         ArrayList var6 = var3.select(var7);
         if (var6.size() > 0) {
            this.sendStudioConsole(true, "INFO", StringHelper.format("实体[%1$s]开始从继承实体同步属性", var1.getPSDataEntityName()), false);
            this.syncInheritDEField(var1);
            var2 = true;
         }
      } else if (var4 == 0) {
         PSDER var5 = new PSDER();
         var5.setMinorPSDEId(var1.getPSDataEntityId());
         var5.setDERType("DERINHERIT");
         if (var3.select(var5, true)) {
            this.sendStudioConsole(true, "INFO", StringHelper.format("实体[%1$s]开始从继承实体同步属性", var1.getPSDataEntityName()), false);
            this.syncInheritDEField(var1);
            var2 = true;
         }
      }

      if (!var2) {
         this.sendStudioConsole(
            true, "ERROR", StringHelper.format("实体[%1$s]无法自动同步属性，当前仅支持以下场景（1）定义有外部接口实体（2）定义为使用外部数据结构（3）定义有继承关系", var1.getPSDataEntityName()), false
         );
         throw new Exception(StringHelper.format("实体[%1$s]无法自动同步属性，当前仅支持以下场景（1）定义有外部接口实体（2）定义为使用外部数据结构（3）定义有继承关系", var1.getPSDataEntityName()));
      }
   }

   protected void initModelRTModes(PSDataEntity var1) throws Exception {
      if (!var1.isFullEntity()) {
         this.get(var1);
      }

      boolean var2 = DataObject.getIntegerValue(var1.getDEType(), 1) == 1;
      if (var2) {
         this.initSimplePSDataQuery(var1);
         if (DataObject.getBoolValue(var1.getEnableOrgModel(), true)) {
            this.initDEOrgModels(var1);
         }
      }

      if (DataObject.getIntegerValue(var1.getEnableAudit(), 0) == 1) {
         this.initAuditPSDataQuery(var1);
      }

      int var3 = var2 ? 0 : 2;
      if ((DataObject.getIntegerValue(var1.getDataAccMode(), var3) & 2) == 2) {
         this.initMapPSDEOPPrivs(var1);
      }

      if (var1.getPSWFDEs().size() > 0) {
         this.initWFPSDEActions(var1);
      }
   }

   protected void initSimplePSDataQuery(PSDataEntity var1) throws Exception {
      PSDEFGroup var2 = new PSDEFGroup();
      var2.setPSDEId(var1.getPSDataEntityId());
      var2.setGroupType("BASEFIELDS");
      boolean var3 = false;
      PSDEFGroupService var4 = (PSDEFGroupService)ServiceGlobal.getService(PSDEFGroupService.class, this.getSessionFactory());
      if (!var4.selectOne(var2, true)) {
         var2.setCodeName("Simple{0}");
         var2.setPSDEFGroupName("基础属性组{0}");
         var4.create(var2, false);
         this.sendStudioConsole(true, "INFO", StringHelper.format("实体[%1$s]建立属性组[%2$s]", var1.getPSDataEntityName(), var2.getPSDEFGroupName()), false);
         var3 = true;
      }

      PSDEDataQuery var5 = new PSDEDataQuery();
      var5.setPSDEId(var1.getPSDataEntityId());
      var5.setViewColLevel(DEDataQueryColLevel2CodeListModel.DEFGROUP);
      var5.setPSDEFGroupId(var2.getPSDEFGroupId());
      PSDEDataQueryService var6 = (PSDEDataQueryService)ServiceGlobal.getService(PSDEDataQueryService.class, this.getSessionFactory());
      if (var3 || !var6.selectOne(var5, true)) {
         var5.setCodeName("Simple{0}");
         var5.setPSDEDataQueryName("SIMPLE{0}");
         var5.setLogicName("基础属性查询{0}");
         var5.setPubMode(0);
         var6.create(var5, false);
         PSDEDQJoin var7 = new PSDEDQJoin();
         var7.setPSDEDQId(var5.getPSDEDataQueryId());
         var7.setPSDEDQName(var5.getPSDEDataQueryName());
         var7.setJoinPSDEId(var5.getPSDEId());
         var7.setJoinPSDEName(var5.getPSDEName());
         var7.setMainFlag(1);
         var7.setPSDEJoinTypeId("MAIN");
         var7.setPSDEDQJoinName(var5.getPSDEName());
         PSDEDQJoinService var8 = (PSDEDQJoinService)ServiceGlobal.getService(PSDEDQJoinService.class, this.getSessionFactory());
         var8.create(var7);
         this.sendStudioConsole(true, "INFO", StringHelper.format("实体[%1$s]建立数据查询[%2$s]", var1.getPSDataEntityName(), var5.getPSDEDataQueryName()), false);
      }
   }

   protected void initAuditPSDataQuery(PSDataEntity var1) throws Exception {
      PSDEFGroup var2 = new PSDEFGroup();
      var2.setPSDEId(var1.getPSDataEntityId());
      var2.setGroupType("AUDITFIELDS");
      boolean var3 = false;
      PSDEFGroupService var4 = (PSDEFGroupService)ServiceGlobal.getService(PSDEFGroupService.class, this.getSessionFactory());
      if (!var4.selectOne(var2, true)) {
         var2.setCodeName("Audit{0}");
         var2.setPSDEFGroupName("审计属性组{0}");
         var4.create(var2, false);
         this.sendStudioConsole(true, "INFO", StringHelper.format("实体[%1$s]建立属性组[%2$s]", var1.getPSDataEntityName(), var2.getPSDEFGroupName()), false);
         var3 = true;
      }

      PSDEDataQuery var5 = new PSDEDataQuery();
      var5.setPSDEId(var1.getPSDataEntityId());
      var5.setViewColLevel(DEDataQueryColLevel2CodeListModel.DEFGROUP);
      var5.setPSDEFGroupId(var2.getPSDEFGroupId());
      PSDEDataQueryService var6 = (PSDEDataQueryService)ServiceGlobal.getService(PSDEDataQueryService.class, this.getSessionFactory());
      if (var3 || !var6.selectOne(var5, true)) {
         var5.setCodeName("Audit{0}");
         var5.setPSDEDataQueryName("AUDIT{0}");
         var5.setLogicName("审计属性查询{0}");
         var5.setPubMode(0);
         var6.create(var5, false);
         PSDEDQJoin var7 = new PSDEDQJoin();
         var7.setPSDEDQId(var5.getPSDEDataQueryId());
         var7.setPSDEDQName(var5.getPSDEDataQueryName());
         var7.setJoinPSDEId(var5.getPSDEId());
         var7.setJoinPSDEName(var5.getPSDEName());
         var7.setMainFlag(1);
         var7.setPSDEJoinTypeId("MAIN");
         var7.setPSDEDQJoinName(var5.getPSDEName());
         PSDEDQJoinService var8 = (PSDEDQJoinService)ServiceGlobal.getService(PSDEDQJoinService.class, this.getSessionFactory());
         var8.create(var7);
         this.sendStudioConsole(true, "INFO", StringHelper.format("实体[%1$s]建立数据查询[%2$s]", var1.getPSDataEntityName(), var5.getPSDEDataQueryName()), false);
      }
   }

   protected void initDEOrgModels(PSDataEntity var1) throws Exception {
      boolean var2 = false;
      if (DataObject.getBoolValue(var1.getExistingModel(), false)) {
         var2 = true;
      }

      if (!var2 && DataObject.getIntegerValue(var1.getVirtualFlag(), 0) > 0) {
         var2 = true;
      }

      if (!var2 && (!StringHelper.isNullOrEmpty(var1.getPSSubSysServiceAPIId()) || !StringHelper.isNullOrEmpty(var1.getPSSubSysSADEId()))) {
         var2 = true;
      }

      PSSystem var3 = getCurrentPSSystem(var1, this.getSessionFactory());
      PSDCModelTempl var4 = null;
      if (!StringHelper.isNullOrEmpty(var3.getPSDevSlnSysId())) {
         var4 = PSModelGlobal.getPSDCModelTempl(var3.getPSDevSlnSysId());
      }

      HashMap var5 = new HashMap();
      if (var4 != null) {
         for (PSDCMTDEF var8 : var4.getPSDCMTDEFs()) {
            if (!StringHelper.isNullOrEmpty(var8.getPreDefinedType())) {
               var5.put(var8.getPreDefinedType(), var8);
            }
         }
      }

      PSDEFieldService var27 = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, this.getSessionFactory());
      if (!var2) {
         PSDEField var28 = new PSDEField();
         var28.setPSDEId(var1.getPSDataEntityId());
         var28.setPreDefineType("ORGID");
         if (!var27.selectOne(var28, true)) {
            var28.resetPreDefineType();
            var28.setPSDEFieldName("ORGID");
            if (!var27.selectOne(var28, true)) {
               PSDCMTDEF var31 = (PSDCMTDEF)var5.remove("ORGID");
               if (var31 != null) {
                  var28.setPSDEFieldName(var31.getPSDCMTDEFName());
                  var28.setCodeName(var31.getCodeName());
                  var28.setLogicName(var31.getLogicName());
                  var28.setPSDataTypeId(var31.getDEFDataType());
                  var28.setLength(var31.getLength());
                  var28.setPreDefineType("ORGID");
               } else {
                  if (isEnableCodeNameUpperCamel()) {
                     var28.setPSDEFieldName(StringHelper.format("ORG_ID"));
                  } else {
                     var28.setPSDEFieldName(StringHelper.format("ORGID"));
                  }

                  var28.setLogicName("组织机构标识");
                  var28.setCodeName("OrgId");
                  var28.setPSDataTypeId("TEXT");
                  var28.setLength(60);
                  var28.setPreDefineType("ORGID");
               }

               var28.setPSDEId(var1.getPSDataEntityId());
               var28.setTableName(var1.getTableName());
               var28.setDEFType(1);
               var28.setPhysicalField(1);
               var28.setAllowEmpty(1);
               var28.setMajorField(0);
               var28.setPKey(0);
               var28.setFKey(0);

               try {
                  var27.create(var28, false);
                  this.sendStudioConsole(true, "INFO", StringHelper.format("实体[%1$s]建立属性[%2$s]", var1.getPSDataEntityName(), var28.getPSDEFieldName()), false);
               } catch (Exception var26) {
                  log.error(String.format("建立实体属性[%1$s]发生异常，%2$s", var28.getPSDEFieldName(), var26.getMessage()), var26);
                  this.sendStudioConsole(
                     true,
                     "ERROR",
                     StringHelper.format("实体[%1$s]建立属性[%2$s]发生异常，%3$s", var1.getPSDataEntityName(), var28.getPSDEFieldName(), var26.getMessage()),
                     false
                  );
                  throw new Exception(String.format("建立实体属性[%1$s]发生异常，%2$s", var28.getPSDEFieldName(), var26.getMessage()), var26);
               }
            }
         }
      }

      if (!var2) {
         PSDEField var29 = new PSDEField();
         var29.setPSDEId(var1.getPSDataEntityId());
         var29.setPreDefineType("ORGSECTORID");
         if (!var27.selectOne(var29, true)) {
            var29.resetPreDefineType();
            var29.setPSDEFieldName("ORGSECTORID");
            if (!var27.selectOne(var29, true)) {
               var29.setPSDEFieldName("DEPTID");
               if (!var27.selectOne(var29, true)) {
                  PSDCMTDEF var32 = (PSDCMTDEF)var5.remove("ORGSECTORID");
                  if (var32 != null) {
                     var29.setPSDEFieldName(var32.getPSDCMTDEFName());
                     var29.setCodeName(var32.getCodeName());
                     var29.setLogicName(var32.getLogicName());
                     var29.setPSDataTypeId(var32.getDEFDataType());
                     var29.setLength(var32.getLength());
                     var29.setPreDefineType("ORGSECTORID");
                  } else {
                     if (isEnableCodeNameUpperCamel()) {
                        var29.setPSDEFieldName(StringHelper.format("DEPT_ID"));
                     } else {
                        var29.setPSDEFieldName(StringHelper.format("DEPTID"));
                     }

                     var29.setLogicName("组织部门标识");
                     var29.setCodeName("DeptId");
                     var29.setPSDataTypeId("TEXT");
                     var29.setLength(60);
                     var29.setPreDefineType("ORGSECTORID");
                  }

                  var29.setPSDEId(var1.getPSDataEntityId());
                  var29.setTableName(var1.getTableName());
                  var29.setDEFType(1);
                  var29.setPhysicalField(1);
                  var29.setAllowEmpty(1);
                  var29.setMajorField(0);
                  var29.setPKey(0);
                  var29.setFKey(0);

                  try {
                     var27.create(var29, false);
                     this.sendStudioConsole(
                        true, "INFO", StringHelper.format("实体[%1$s]建立属性[%2$s]", var1.getPSDataEntityName(), var29.getPSDEFieldName()), false
                     );
                  } catch (Exception var25) {
                     log.error(String.format("建立实体属性[%1$s]发生异常，%2$s", var29.getPSDEFieldName(), var25.getMessage()), var25);
                     this.sendStudioConsole(
                        true,
                        "ERROR",
                        StringHelper.format("实体[%1$s]建立属性[%2$s]发生异常，%3$s", var1.getPSDataEntityName(), var29.getPSDEFieldName(), var25.getMessage()),
                        false
                     );
                     throw new Exception(String.format("建立实体属性[%1$s]发生异常，%2$s", var29.getPSDEFieldName(), var25.getMessage()), var25);
                  }
               }
            }
         }
      }

      PSDEOPPrivService var30 = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, this.getSessionFactory());
      PSDEUserRoleService var33 = (PSDEUserRoleService)ServiceGlobal.getService(PSDEUserRoleService.class, this.getSessionFactory());
      PSDEOPPrivRoleService var9 = (PSDEOPPrivRoleService)ServiceGlobal.getService(PSDEOPPrivRoleService.class, this.getSessionFactory());
      SelectCond var10 = new SelectCond();
      var10.set("PSDEID", var1.getPSDataEntityId());
      ArrayList<PSDEOPPriv> var11 = var30.select(var10);
      if (var11.size() > 0) {
         HashMap var12 = new HashMap();

         for (PSDEOPPriv var14 : var11) {
            if (!var12.containsKey(var14.getPSDEOPPrivName()) || StringHelper.isNullOrEmpty(var14.getPSDERId())) {
               var12.put(var14.getPSDEOPPrivName(), var14);
            }
         }

         PSDEOPPriv var34 = (PSDEOPPriv)var12.get("READ");
         PSDEOPPriv var35 = (PSDEOPPriv)var12.get("UPDATE");
         PSDEOPPriv var15 = (PSDEOPPriv)var12.get("DELETE");
         PSDEOPPriv var16 = (PSDEOPPriv)var12.get("CREATE");
         if (var34 != null) {
            PSDEUserRole var17 = new PSDEUserRole();
            var17.setPSDEId(var1.getPSDataEntityId());
            var17.setUserRoleTag("ALL_R");
            if (!var33.selectOne(var17, true)) {
               var17.setPSDEUserRoleName("全部数据（读）");
               var17.setDefaultFlag(0);
               var17.setAllDataFlag(1);

               try {
                  var33.create(var17);
                  this.sendStudioConsole(
                     true, "INFO", StringHelper.format("实体[%1$s]建立操作角色[%2$s]", var1.getPSDataEntityName(), var17.getPSDEUserRoleName()), false
                  );
               } catch (Exception var24) {
                  log.error(String.format("建立实体操作角色[%1$s]发生异常，%2$s", var17.getPSDEUserRoleName(), var24.getMessage()), var24);
                  this.sendStudioConsole(
                     true,
                     "ERROR",
                     StringHelper.format("实体[%1$s]建立操作角色[%2$s]发生异常，%3$s", var1.getPSDataEntityName(), var17.getPSDEUserRoleName(), var24.getMessage()),
                     false
                  );
                  throw new Exception(String.format("建立实体操作角色[%1$s]发生异常，%2$s", var17.getPSDEUserRoleName(), var24.getMessage()), var24);
               }

               PSDEOPPrivRole var18 = new PSDEOPPrivRole();
               var18.setPSDEId(var1.getPSDataEntityId());
               var18.setPSDEName(var1.getPSDataEntityName());
               var18.setRoleType("DEROLE");
               var18.setPSDEUserRoleId(var17.getPSDEUserRoleId());
               var18.setPSDEOPPrivId(var34.getPSDEOPPrivId());
               var18.setPSDEOPPrivName(var34.getPSDEOPPrivName());
               var18.setPSDEOPPrivRoleName(var34.getPSDEOPPrivName());
               var9.create(var18, false);
            }

            var17 = new PSDEUserRole();
            var17.setPSDEId(var1.getPSDataEntityId());
            var17.setUserRoleTag("CURORG_R");
            if (!var33.selectOne(var17, true)) {
               var17.setPSDEUserRoleName("当前组织（读）");
               var17.setDefaultFlag(0);
               var17.setEnableOrgDR(1);
               var17.setOrgDR(1);

               try {
                  var33.create(var17);
                  this.sendStudioConsole(
                     true, "INFO", StringHelper.format("实体[%1$s]建立操作角色[%2$s]", var1.getPSDataEntityName(), var17.getPSDEUserRoleName()), false
                  );
               } catch (Exception var23) {
                  log.error(String.format("建立实体操作角色[%1$s]发生异常，%2$s", var17.getPSDEUserRoleName(), var23.getMessage()), var23);
                  this.sendStudioConsole(
                     true,
                     "ERROR",
                     StringHelper.format("实体[%1$s]建立操作角色[%2$s]发生异常，%3$s", var1.getPSDataEntityName(), var17.getPSDEUserRoleName(), var23.getMessage()),
                     false
                  );
                  throw new Exception(String.format("建立实体操作角色[%1$s]发生异常，%2$s", var17.getPSDEUserRoleName(), var23.getMessage()), var23);
               }

               PSDEOPPrivRole var41 = new PSDEOPPrivRole();
               var41.setPSDEId(var1.getPSDataEntityId());
               var41.setPSDEName(var1.getPSDataEntityName());
               var41.setRoleType("DEROLE");
               var41.setPSDEUserRoleId(var17.getPSDEUserRoleId());
               var41.setPSDEOPPrivId(var34.getPSDEOPPrivId());
               var41.setPSDEOPPrivName(var34.getPSDEOPPrivName());
               var41.setPSDEOPPrivRoleName(var34.getPSDEOPPrivName());
               var9.create(var41, false);
            }

            var17 = new PSDEUserRole();
            var17.setPSDEId(var1.getPSDataEntityId());
            var17.setUserRoleTag("CURDEPT_R");
            if (!var33.selectOne(var17, true)) {
               var17.setPSDEUserRoleName("当前部门（读）");
               var17.setDefaultFlag(0);
               var17.setEnableSecDR(1);
               var17.setSecDR(1);

               try {
                  var33.create(var17);
                  this.sendStudioConsole(
                     true, "INFO", StringHelper.format("实体[%1$s]建立操作角色[%2$s]", var1.getPSDataEntityName(), var17.getPSDEUserRoleName()), false
                  );
               } catch (Exception var22) {
                  log.error(String.format("建立实体操作角色[%1$s]发生异常，%2$s", var17.getPSDEUserRoleName(), var22.getMessage()), var22);
                  this.sendStudioConsole(
                     true,
                     "ERROR",
                     StringHelper.format("实体[%1$s]建立操作角色[%2$s]发生异常，%3$s", var1.getPSDataEntityName(), var17.getPSDEUserRoleName(), var22.getMessage()),
                     false
                  );
                  throw new Exception(String.format("建立实体操作角色[%1$s]发生异常，%2$s", var17.getPSDEUserRoleName(), var22.getMessage()), var22);
               }

               PSDEOPPrivRole var42 = new PSDEOPPrivRole();
               var42.setPSDEId(var1.getPSDataEntityId());
               var42.setPSDEName(var1.getPSDataEntityName());
               var42.setRoleType("DEROLE");
               var42.setPSDEUserRoleId(var17.getPSDEUserRoleId());
               var42.setPSDEOPPrivId(var34.getPSDEOPPrivId());
               var42.setPSDEOPPrivName(var34.getPSDEOPPrivName());
               var42.setPSDEOPPrivRoleName(var34.getPSDEOPPrivName());
               var9.create(var42, false);
            }
         }

         if (var34 != null && var35 != null && var15 != null && var16 != null) {
            PSDEUserRole var38 = new PSDEUserRole();
            var38.setPSDEId(var1.getPSDataEntityId());
            var38.setUserRoleTag("ALL_RW");
            if (!var33.selectOne(var38, true)) {
               var38.setPSDEUserRoleName("全部数据（读写）");
               var38.setDefaultFlag(0);
               var38.setAllDataFlag(1);

               try {
                  var33.create(var38);
                  this.sendStudioConsole(
                     true, "INFO", StringHelper.format("实体[%1$s]建立操作角色[%2$s]", var1.getPSDataEntityName(), var38.getPSDEUserRoleName()), false
                  );
               } catch (Exception var21) {
                  log.error(String.format("建立实体操作角色[%1$s]发生异常，%2$s", var38.getPSDEUserRoleName(), var21.getMessage()), var21);
                  this.sendStudioConsole(
                     true,
                     "ERROR",
                     StringHelper.format("实体[%1$s]建立操作角色[%2$s]发生异常，%3$s", var1.getPSDataEntityName(), var38.getPSDEUserRoleName(), var21.getMessage()),
                     false
                  );
                  throw new Exception(String.format("建立实体操作角色[%1$s]发生异常，%2$s", var38.getPSDEUserRoleName(), var21.getMessage()), var21);
               }

               PSDEOPPrivRole var43 = new PSDEOPPrivRole();
               var43.setPSDEId(var1.getPSDataEntityId());
               var43.setPSDEName(var1.getPSDataEntityName());
               var43.setRoleType("DEROLE");
               var43.setPSDEUserRoleId(var38.getPSDEUserRoleId());
               var43.setPSDEOPPrivId(var34.getPSDEOPPrivId());
               var43.setPSDEOPPrivName(var34.getPSDEOPPrivName());
               var43.setPSDEOPPrivRoleName(var34.getPSDEOPPrivName());
               var9.create(var43, false);
               var43 = new PSDEOPPrivRole();
               var43.setPSDEId(var1.getPSDataEntityId());
               var43.setPSDEName(var1.getPSDataEntityName());
               var43.setRoleType("DEROLE");
               var43.setPSDEUserRoleId(var38.getPSDEUserRoleId());
               var43.setPSDEOPPrivId(var35.getPSDEOPPrivId());
               var43.setPSDEOPPrivName(var35.getPSDEOPPrivName());
               var43.setPSDEOPPrivRoleName(var35.getPSDEOPPrivName());
               var9.create(var43, false);
               var43 = new PSDEOPPrivRole();
               var43.setPSDEId(var1.getPSDataEntityId());
               var43.setPSDEName(var1.getPSDataEntityName());
               var43.setRoleType("DEROLE");
               var43.setPSDEUserRoleId(var38.getPSDEUserRoleId());
               var43.setPSDEOPPrivId(var15.getPSDEOPPrivId());
               var43.setPSDEOPPrivName(var15.getPSDEOPPrivName());
               var43.setPSDEOPPrivRoleName(var15.getPSDEOPPrivName());
               var9.create(var43, false);
               var43 = new PSDEOPPrivRole();
               var43.setPSDEId(var1.getPSDataEntityId());
               var43.setPSDEName(var1.getPSDataEntityName());
               var43.setRoleType("DEROLE");
               var43.setPSDEUserRoleId(var38.getPSDEUserRoleId());
               var43.setPSDEOPPrivId(var16.getPSDEOPPrivId());
               var43.setPSDEOPPrivName(var16.getPSDEOPPrivName());
               var43.setPSDEOPPrivRoleName(var16.getPSDEOPPrivName());
               var9.create(var43, false);
            }

            var38 = new PSDEUserRole();
            var38.setPSDEId(var1.getPSDataEntityId());
            var38.setUserRoleTag("CURORG_RW");
            if (!var33.selectOne(var38, true)) {
               var38.setPSDEUserRoleName("当前组织（读写）");
               var38.setDefaultFlag(0);
               var38.setEnableOrgDR(1);
               var38.setOrgDR(1);

               try {
                  var33.create(var38);
                  this.sendStudioConsole(
                     true, "INFO", StringHelper.format("实体[%1$s]建立操作角色[%2$s]", var1.getPSDataEntityName(), var38.getPSDEUserRoleName()), false
                  );
               } catch (Exception var20) {
                  log.error(String.format("建立实体操作角色[%1$s]发生异常，%2$s", var38.getPSDEUserRoleName(), var20.getMessage()), var20);
                  this.sendStudioConsole(
                     true,
                     "ERROR",
                     StringHelper.format("实体[%1$s]建立操作角色[%2$s]发生异常，%3$s", var1.getPSDataEntityName(), var38.getPSDEUserRoleName(), var20.getMessage()),
                     false
                  );
                  throw new Exception(String.format("建立实体操作角色[%1$s]发生异常，%2$s", var38.getPSDEUserRoleName(), var20.getMessage()), var20);
               }

               PSDEOPPrivRole var47 = new PSDEOPPrivRole();
               var47.setPSDEId(var1.getPSDataEntityId());
               var47.setPSDEName(var1.getPSDataEntityName());
               var47.setRoleType("DEROLE");
               var47.setPSDEUserRoleId(var38.getPSDEUserRoleId());
               var47.setPSDEOPPrivId(var34.getPSDEOPPrivId());
               var47.setPSDEOPPrivName(var34.getPSDEOPPrivName());
               var47.setPSDEOPPrivRoleName(var34.getPSDEOPPrivName());
               var9.create(var47, false);
               var47 = new PSDEOPPrivRole();
               var47.setPSDEId(var1.getPSDataEntityId());
               var47.setPSDEName(var1.getPSDataEntityName());
               var47.setRoleType("DEROLE");
               var47.setPSDEUserRoleId(var38.getPSDEUserRoleId());
               var47.setPSDEOPPrivId(var35.getPSDEOPPrivId());
               var47.setPSDEOPPrivName(var35.getPSDEOPPrivName());
               var47.setPSDEOPPrivRoleName(var35.getPSDEOPPrivName());
               var9.create(var47, false);
               var47 = new PSDEOPPrivRole();
               var47.setPSDEId(var1.getPSDataEntityId());
               var47.setPSDEName(var1.getPSDataEntityName());
               var47.setRoleType("DEROLE");
               var47.setPSDEUserRoleId(var38.getPSDEUserRoleId());
               var47.setPSDEOPPrivId(var15.getPSDEOPPrivId());
               var47.setPSDEOPPrivName(var15.getPSDEOPPrivName());
               var47.setPSDEOPPrivRoleName(var15.getPSDEOPPrivName());
               var9.create(var47, false);
               var47 = new PSDEOPPrivRole();
               var47.setPSDEId(var1.getPSDataEntityId());
               var47.setPSDEName(var1.getPSDataEntityName());
               var47.setRoleType("DEROLE");
               var47.setPSDEUserRoleId(var38.getPSDEUserRoleId());
               var47.setPSDEOPPrivId(var16.getPSDEOPPrivId());
               var47.setPSDEOPPrivName(var16.getPSDEOPPrivName());
               var47.setPSDEOPPrivRoleName(var16.getPSDEOPPrivName());
               var9.create(var47, false);
            }

            var38 = new PSDEUserRole();
            var38.setPSDEId(var1.getPSDataEntityId());
            var38.setUserRoleTag("CURDEPT_RW");
            if (!var33.selectOne(var38, true)) {
               var38.setPSDEUserRoleName("当前部门（读写）");
               var38.setDefaultFlag(0);
               var38.setEnableSecDR(1);
               var38.setSecDR(1);

               try {
                  var33.create(var38);
                  this.sendStudioConsole(
                     true, "INFO", StringHelper.format("实体[%1$s]建立操作角色[%2$s]", var1.getPSDataEntityName(), var38.getPSDEUserRoleName()), false
                  );
               } catch (Exception var19) {
                  log.error(String.format("建立实体操作角色[%1$s]发生异常，%2$s", var38.getPSDEUserRoleName(), var19.getMessage()), var19);
                  this.sendStudioConsole(
                     true,
                     "ERROR",
                     StringHelper.format("实体[%1$s]建立操作角色[%2$s]发生异常，%3$s", var1.getPSDataEntityName(), var38.getPSDEUserRoleName(), var19.getMessage()),
                     false
                  );
                  throw new Exception(String.format("建立实体操作角色[%1$s]发生异常，%2$s", var38.getPSDEUserRoleName(), var19.getMessage()), var19);
               }

               PSDEOPPrivRole var51 = new PSDEOPPrivRole();
               var51.setPSDEId(var1.getPSDataEntityId());
               var51.setPSDEName(var1.getPSDataEntityName());
               var51.setRoleType("DEROLE");
               var51.setPSDEUserRoleId(var38.getPSDEUserRoleId());
               var51.setPSDEOPPrivId(var34.getPSDEOPPrivId());
               var51.setPSDEOPPrivName(var34.getPSDEOPPrivName());
               var51.setPSDEOPPrivRoleName(var34.getPSDEOPPrivName());
               var9.create(var51, false);
               var51 = new PSDEOPPrivRole();
               var51.setPSDEId(var1.getPSDataEntityId());
               var51.setPSDEName(var1.getPSDataEntityName());
               var51.setRoleType("DEROLE");
               var51.setPSDEUserRoleId(var38.getPSDEUserRoleId());
               var51.setPSDEOPPrivId(var35.getPSDEOPPrivId());
               var51.setPSDEOPPrivName(var35.getPSDEOPPrivName());
               var51.setPSDEOPPrivRoleName(var35.getPSDEOPPrivName());
               var9.create(var51, false);
               var51 = new PSDEOPPrivRole();
               var51.setPSDEId(var1.getPSDataEntityId());
               var51.setPSDEName(var1.getPSDataEntityName());
               var51.setRoleType("DEROLE");
               var51.setPSDEUserRoleId(var38.getPSDEUserRoleId());
               var51.setPSDEOPPrivId(var15.getPSDEOPPrivId());
               var51.setPSDEOPPrivName(var15.getPSDEOPPrivName());
               var51.setPSDEOPPrivRoleName(var15.getPSDEOPPrivName());
               var9.create(var51, false);
               var51 = new PSDEOPPrivRole();
               var51.setPSDEId(var1.getPSDataEntityId());
               var51.setPSDEName(var1.getPSDataEntityName());
               var51.setRoleType("DEROLE");
               var51.setPSDEUserRoleId(var38.getPSDEUserRoleId());
               var51.setPSDEOPPrivId(var16.getPSDEOPPrivId());
               var51.setPSDEOPPrivName(var16.getPSDEOPPrivName());
               var51.setPSDEOPPrivRoleName(var16.getPSDEOPPrivName());
               var9.create(var51, false);
            }
         }
      }
   }

   protected void initMapPSDEOPPrivs(PSDataEntity var1) throws Exception {
      ArrayList<PSDER> var2 = var1.getMinorPSDERs();
      if (var2 != null) {
         PSSystem var3 = getCurrentPSSystem(var1, this.getSessionFactory());
         PSDEOPPrivService var4 = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, this.getSessionFactory());

         for (PSDER var6 : var2) {
            if ("DER1N".equals(var6.getDERType()) || "DERCUSTOM".equals(var6.getDERType()) && "DER1N".equals(var6.getDERSubType())) {
               int var7 = DataObject.getIntegerValue(var6.getMasterRS(), 0);
               if ((var7 & 4) != 0) {
                  PSDEOPPriv var8 = null;
                  PSDEOPPriv var9 = null;
                  SelectCond var10 = new SelectCond();
                  var10.set("PSDEID", var6.getMajorPSDEId());
                  ArrayList<PSDEOPPriv> var11 = var4.select(var10);
                  if (var11.size() > 0) {
                     HashMap var12 = new HashMap();

                     for (PSDEOPPriv var14 : var11) {
                        if (!var12.containsKey(var14.getPSDEOPPrivName()) && StringHelper.isNullOrEmpty(var14.getPSDERId())) {
                           var12.put(var14.getPSDEOPPrivName(), var14);
                        }
                     }

                     var8 = (PSDEOPPriv)var12.get("READ");
                     var9 = (PSDEOPPriv)var12.get("UPDATE");
                  }

                  if (var8 != null) {
                     PSDEOPPriv var21 = new PSDEOPPriv();
                     var21.setPSDEId(var1.getPSDataEntityId());
                     var21.setPSDEOPPrivName("READ");
                     var21.setPSDERId(var6.getPSDERId());
                     if (!var4.selectOne(var21, true)) {
                        var21.setMapPSDEOPPrivId(var8.getPSDEOPPrivId());
                        var21.setMapPSDEOPPrivName(var8.getPSDEOPPrivName());
                        var21.setPSSystemId(var3.getPSSystemId());
                        var21.setPSSystemName(var3.getPSSystemName());

                        try {
                           var4.create(var21);
                           this.sendStudioConsole(
                              true, "INFO", StringHelper.format("实体[%1$s]建立操作标识[%2$s]", var1.getPSDataEntityName(), var21.getPSDEOPPrivName()), false
                           );
                        } catch (Exception var20) {
                           log.error(String.format("建立实体操作标识[%1$s]发生异常，%2$s", var21.getPSDEOPPrivName(), var20.getMessage()), var20);
                           this.sendStudioConsole(
                              true,
                              "ERROR",
                              StringHelper.format("实体[%1$s]建立操作标识[%2$s]发生异常，%3$s", var1.getPSDataEntityName(), var21.getPSDEOPPrivName(), var20.getMessage()),
                              false
                           );
                           throw new Exception(String.format("建立实体操作标识[%1$s]发生异常，%2$s", var21.getPSDEOPPrivName(), var20.getMessage()), var20);
                        }
                     }
                  }

                  if (var9 != null) {
                     String[] var22 = new String[]{"UPDATE", "CREATE", "DELETE"};

                     for (String var16 : var22) {
                        PSDEOPPriv var17 = new PSDEOPPriv();
                        var17.setPSDEId(var1.getPSDataEntityId());
                        var17.setPSDEOPPrivName(var16);
                        var17.setPSDERId(var6.getPSDERId());
                        if (!var4.selectOne(var17, true)) {
                           var17.setMapPSDEOPPrivId(var9.getPSDEOPPrivId());
                           var17.setMapPSDEOPPrivName(var9.getPSDEOPPrivName());
                           var17.setPSSystemId(var3.getPSSystemId());
                           var17.setPSSystemName(var3.getPSSystemName());

                           try {
                              var4.create(var17);
                              this.sendStudioConsole(
                                 true, "INFO", StringHelper.format("实体[%1$s]建立操作标识[%2$s]", var1.getPSDataEntityName(), var17.getPSDEOPPrivName()), false
                              );
                           } catch (Exception var19) {
                              log.error(String.format("建立实体操作标识[%1$s]发生异常，%2$s", var17.getPSDEOPPrivName(), var19.getMessage()), var19);
                              this.sendStudioConsole(
                                 true,
                                 "ERROR",
                                 StringHelper.format("实体[%1$s]建立操作标识[%2$s]发生异常，%3$s", var1.getPSDataEntityName(), var17.getPSDEOPPrivName(), var19.getMessage()),
                                 false
                              );
                              throw new Exception(String.format("建立实体操作标识[%1$s]发生异常，%2$s", var17.getPSDEOPPrivName(), var19.getMessage()), var19);
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }

   protected void initWFPSDEActions(PSDataEntity var1) throws Exception {
      PSDEActionService var2 = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, this.getSessionFactory());

      for (Entry var4 : wfActionMap.entrySet()) {
         PSDEAction var5 = new PSDEAction();
         var5.setPSDEId(var1.getPSDataEntityId());
         var5.setPSDEActionName((String)var4.getKey());
         if (!var2.selectOne(var5, true)) {
            var5.setPSDEName(var1.getPSDataEntityName());
            var5.setCodeName((String)var4.getKey());
            var5.setLogicName((String)var4.getValue());
            var5.setActionType("BUILTIN");
            if (StringHelper.compare((String)var4.getKey(), "wfStart", false) != 0) {
               var5.setPubMode(0);
            }

            try {
               var2.create(var5, false);
               this.sendStudioConsole(true, "INFO", StringHelper.format("实体[%1$s]建立行为[%2$s]", var1.getPSDataEntityName(), var5.getPSDEActionName()), false);
            } catch (Exception var7) {
               log.error(String.format("建立实体行为[%1$s]发生异常，%2$s", var5.getPSDEActionName(), var7.getMessage()), var7);
               this.sendStudioConsole(
                  true,
                  "ERROR",
                  StringHelper.format("实体[%1$s]建立行为[%2$s]发生异常，%3$s", var1.getPSDataEntityName(), var5.getPSDEActionName(), var7.getMessage()),
                  false
               );
               throw new Exception(String.format("建立实体行为[%1$s]发生异常，%2$s", var5.getPSDEActionName(), var7.getMessage()), var7);
            }
         }
      }
   }

   @Override
   public Object getDataContextValue(PSDataEntity var1, String var2, IDataContextParam var3) throws Exception {
      Object var4 = super.getDataContextValue(var1, var2, var3);
      return var4 == null && StringHelper.compare(var2, "psdeid", true) == 0 ? var1.getPSDataEntityId() : var4;
   }

   static {
      rtDEMap.put("WFWORKFLOW", "");
      rtDEMap.put("WFINSTANCE", "");
      rtDEMap.put("SERVICE", "");
      rtDEMap.put("SYSADMIN", "");
      rtDEMap.put("WFSTEPDATA", "");
      rtDEMap.put("WFUSERGROUPDETAIL", "");
      rtDEMap.put("DATAENTITY", "");
      rtDEMap.put("USERROLEDATAACTION", "");
      rtDEMap.put("WFTMPSTEPACTOR", "");
      rtDEMap.put("USERROLEDEFIELD", "");
      rtDEMap.put("PPMODEL", "");
      rtDEMap.put("FILE", "");
      rtDEMap.put("USERROLE", "");
      rtDEMap.put("ORGUSER", "");
      rtDEMap.put("SYSADMINFUNC", "");
      rtDEMap.put("USEROBJECT", "");
      rtDEMap.put("MSGSENDQUEUE", "");
      rtDEMap.put("DATAAUDIT", "");
      rtDEMap.put("WFREMINDER", "");
      rtDEMap.put("ORGUNITCAT", "");
      rtDEMap.put("WFSTEPACTOR", "");
      rtDEMap.put("ORGTYPE", "");
      rtDEMap.put("WFSYSTEMUSER", "");
      rtDEMap.put("USERGROUPDETAIL", "");
      rtDEMap.put("WFCUSTOMPROCESS", "");
      rtDEMap.put("USERDICTITEM", "");
      rtDEMap.put("DALOG", "");
      rtDEMap.put("WFACTION", "");
      rtDEMap.put("ORGSECUSERTYPE", "");
      rtDEMap.put("WFAPPSETTING", "");
      rtDEMap.put("LOGINACCOUNT", "");
      rtDEMap.put("USERGROUP", "");
      rtDEMap.put("CODEITEM", "");
      rtDEMap.put("ORGSECTOR", "");
      rtDEMap.put("WFUIWIZARD", "");
      rtDEMap.put("REGISTRY", "");
      rtDEMap.put("MSGSENDQUEUEHIS", "");
      rtDEMap.put("WFSTEPINST", "");
      rtDEMap.put("WFDYNAMICUSER", "");
      rtDEMap.put("LOGINLOG", "");
      rtDEMap.put("MSGACCOUNT", "");
      rtDEMap.put("DATAAUDITDETAIL", "");
      rtDEMap.put("WFASSISTWORK", "");
      rtDEMap.put("CODELIST", "");
      rtDEMap.put("UNIRES", "");
      rtDEMap.put("WFUSERCANDIDATE", "");
      rtDEMap.put("ORGSECUSER", "");
      rtDEMap.put("WFACTOR", "");
      rtDEMap.put("USERROLEDATADETAIL", "");
      rtDEMap.put("USERROLEDETAIL", "");
      rtDEMap.put("WFSTEP", "");
      rtDEMap.put("MSGACCOUNTDETAIL", "");
      rtDEMap.put("USERROLEDATAS", "");
      rtDEMap.put("WFUSERASSIST", "");
      rtDEMap.put("USERROLEDATA", "");
      rtDEMap.put("USERDICTCAT", "");
      rtDEMap.put("WFWORKLIST", "");
      rtDEMap.put("USERROLEDEFIELDS", "");
      rtDEMap.put("PVPART", "");
      rtDEMap.put("USERDICT", "");
      rtDEMap.put("SYSTEM", "");
      rtDEMap.put("USERDGTHEME", "");
      rtDEMap.put("WFIAACTION", "");
      rtDEMap.put("MSGTEMPLATE", "");
      rtDEMap.put("ORG", "");
      rtDEMap.put("WFUSERGROUP", "");
      rtDEMap.put("ORGUSERLEVEL", "");
      rtDEMap.put("QUERYMODEL", "");
      rtDEMap.put("USERROLERES", "");
      rtDEMap.put("WFUSER", "");
      rtDEMap.put("WFWFVERSION", "");
      rtDEMap.put("USER", "");
      rtDEMap.put("USERROLETYPE", "");
      rtDEMap.put("PORTALPAGE", "");
      rtDEMap.put("WFUCPOLICY", "");
      wfActionMap.put("WFStart", "工作流启动");
      wfActionMap.put("WFInit", "工作流初始化回调");
      wfActionMap.put("WFUpdate", "工作流更新回调");
      wfActionMap.put("WFFinish", "工作流完成回调");
      wfActionMap.put("WFError", "工作流错误回调");
      predefinedFieldMap.put("CREATEMAN", "");
      predefinedFieldMap.put("CREATEMANNAME", "");
      predefinedFieldMap.put("CREATEDATE", "");
      predefinedFieldMap.put("UPDATEMAN", "");
      predefinedFieldMap.put("UPDATEMANNAME", "");
      predefinedFieldMap.put("UPDATEDATE", "");
      predefinedFieldMap.put("ENABLE", "");
      predefinedFieldMap.put("ORGID", "");
      predefinedFieldMap.put("ORGSECTORID", "");
      predefinedFieldMap.put("ORGNAME", "");
      predefinedFieldMap.put("ORGSECTORNAME", "");
      predefinedFieldMap.put("ORDERVALUE", "");
   }
}
