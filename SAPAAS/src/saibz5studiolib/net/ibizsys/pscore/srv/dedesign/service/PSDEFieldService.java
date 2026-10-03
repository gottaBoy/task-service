package net.ibizsys.pscore.srv.dedesign.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.freemarker.DataContextMethod;
import net.ibizsys.pscore.srv.PSCoreSysModel;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.codelist.DEFDataTypeCodeListModel;
import net.ibizsys.pscore.srv.config.entity.PSDEFDataType;
import net.ibizsys.pscore.srv.config.entity.PSVarSampleValue;
import net.ibizsys.pscore.srv.config.service.PSDEFDataTypeService;
import net.ibizsys.pscore.srv.config.service.PSVarSampleValueService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFInputTip;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFValueRule;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMTDEF;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCModelTempl;
import net.ibizsys.pscore.srv.service.IPSModelService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDMItemService;
import net.ibizsys.pscore.srv.util.PSModelGlobal;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEFieldService extends PSDEFieldServiceBase implements IPSModelService<PSDEField> {
   private static final Log log = LogFactory.getLog(PSDEFieldService.class);
   public static final String RESERVERTAG_KEY = "R1";
   public static final String RESERVERTAG_MAJOR = "R2";
   public static final String RESERVERTAG_LOGICVALID = "R3";
   public static final String RESERVERTAG_CREATEMAN = "R4";
   public static final String RESERVERTAG_CREATEDATE = "R5";
   public static final String RESERVERTAG_UPDATEMAN = "R6";
   public static final String RESERVERTAG_UPDATEDATE = "R7";
   public static final String RESERVERTAG_CREATEMANNAME = "R8";
   public static final String RESERVERTAG_UPDATEMANNAME = "R9";
   public static final String RESERVERTAG_INDEXTYPE = "R30";
   public static final String RESERVERTAG_ORGID = "R31";

   public ArrayList<PSDEField> selectByDataEntity(String var1) throws Exception {
      SelectCond var2 = new SelectCond();
      var2.setConditon("PSDEID", var1);
      var2.setOrderInfo(" ORDER BY PSDEFIELDNAME ASC");
      return this.select(var2);
   }

   public void getDraft(PSDEField var1) throws Exception {
      super.getDraft(var1);
      if (StringHelper.isNullOrEmpty(var1.getPSDataTypeId())) {
         PSDEFDataType var2 = new PSDEFDataType();
         var2.setSessionFactory(this.getSessionFactory());
         var2.setPSDEFDataTypeId("TEXT");
         if (var2.get(true)) {
            var1.setPSDataTypeId(var2.getPSDEFDataTypeId());
            var1.setPSDataTypeName(var2.getPSDEFDataTypeName());
         }
      }

      if (StringHelper.isNullOrEmpty(var1.getPSDEFieldName()) && !StringHelper.isNullOrEmpty(var1.getPSDEId())) {
         int var4 = 0;

         while (true) {
            var4++;
            PSDEField var3 = new PSDEField();
            var3.setPSDEId(var1.getPSDEId());
            var3.setPSDEFieldName(StringHelper.format("FIELD%1$s", var4 == 1 ? "" : var4));
            if (!this.select(var3, true)) {
               var1.setPSDEFieldName(var3.getPSDEFieldName());
               var3.reset();
               var3.setPSDEId(var1.getPSDEId());
               var3.setLogicName(StringHelper.format("属性%1$s", var4 == 1 ? "" : var4));
               if (!this.select(var3, true)) {
                  var1.setLogicName(var3.getLogicName());
                  break;
               }
            }
         }
      }
   }

   protected void onBeforeCreate(PSDEField var1) throws Exception {
      PSDCModelTempl var2 = null;
      PSDataEntity var3 = var1.getPSDE();
      boolean var4 = false;
      if (DataObject.getBoolValue(var3.getExistingModel(), false)) {
         var4 = true;
      }

      if (!var4 && var3.getPSModule() != null && DataObject.getBoolValue(var3.getPSModule().getSubSysModule(), false)) {
         var4 = true;
      }

      if (!var4) {
         PSSystem var5 = var3.getPSSystem();
         if (!StringHelper.isNullOrEmpty(var5.getPSDevSlnSysId())) {
            var2 = PSModelGlobal.getPSDCModelTempl(var5.getPSDevSlnSysId());
         }
      }

      if (var2 != null) {
         String var6 = var1.getPSDEFieldName();
         if (var2.getDEFNameMaxLength() != null && var2.getDEFNameMaxLength() > 0 && var6.length() > var2.getDEFNameMaxLength()) {
            throw new Exception(StringHelper.format("模型模板[%1$s]定义属性名称长度不能超过[%2$s]", var2.getPSDCModelTemplName(), var2.getDEFNameMaxLength()));
         }
      }

      if (StringHelper.isNullOrEmpty(var1.getCodeName())) {
         String var7 = this.calcDEFieldCodeName(var1.getPSDEFieldName());
         if (StringHelper.isNullOrEmpty(var7) && isEnableCodeNameUpperCamel()) {
            var7 = toUpperCamel(var1.getPSDEFieldName());
         }

         if (StringHelper.isNullOrEmpty(var7)) {
            if (StringHelper.length(var1.getPSDEFieldName()) > 1) {
               var7 = var1.getPSDEFieldName().substring(0, 1).toUpperCase() + var1.getPSDEFieldName().substring(1).toLowerCase();
            } else {
               var7 = var1.getPSDEFieldName().toUpperCase();
            }
         }

         if (!StringHelper.isNullOrEmpty(var7)) {
            var1.setCodeName(var7);
         }
      }

      if (var1.getDEFType() != null && var1.getDEFType() == 1) {
         int var8 = DataObject.getIntegerValue(var1.getPSDE().getVirtualFlag(), 0);
         if (var8 == 1 || var8 == 3 || var8 == 2) {
            throw new Exception(StringHelper.format("虚拟实体不能建立物理属性"));
         }

         var1.setTableName(var1.getPSDE().getTableName());
         if (StringHelper.isNullOrEmpty(var1.getTableName())) {
            throw new Exception(StringHelper.format("物理属性表名无效"));
         }

         var1.setPhysicalField(1);
         PSDEFDataType var9 = new PSDEFDataType();
         var9.setPSDEFDataTypeId(var1.getPSDataTypeId());
         PSDEFDataTypeService var10 = (PSDEFDataTypeService)ServiceGlobal.getService(PSDEFDataTypeService.class, this.getSessionFactory());
         var10.get(var9);
         if (var9.getLength() != null && var1.getLength() == null) {
            var1.setLength(var9.getLength());
         }

         if (var9.getPrecision2() != null && var1.getPrecision2() == null) {
            var1.setPrecision2(var9.getPrecision2());
         }
      } else {
         var1.setPhysicalField(0);
      }

      super.onBeforeCreate(var1);
   }

   protected void onAfterCreate(PSDEField var1) throws Exception {
      if (var1.isMajorFieldDirty() && DataObject.getBoolValue(var1.getMajorField(), false)) {
         this.reCalcMajorDEField(var1);
      }

      super.onAfterCreate(var1);
   }

   protected void onBeforeUpdate(PSDEField var1) throws Exception {
      super.onBeforeUpdate(var1);
   }

   protected void onAfterUpdate(PSDEField var1) throws Exception {
      if (var1.isMajorFieldDirty() && DataObject.getBoolValue(var1.getMajorField(), false)) {
         this.reCalcMajorDEField(var1);
      }

      super.onAfterUpdate(var1);
   }

   protected void reCalcMajorDEField(PSDEField var1) throws Exception {
      PSDEField var2 = new PSDEField();
      var2.setMajorField(1);
      var2.setPSDEId(var1.getPSDEId());
      if (this.select(var2, true)) {
         if (StringHelper.compare(var1.getPSDEFieldId(), var2.getPSDEFieldId(), true) != 0) {
            PSDEField var3 = new PSDEField();
            var3.setPSDEFieldId(var2.getPSDEFieldId());
            var3.setMajorField(0);
            this.update(var3);
         }
      }
   }

   @Override
   public void makeLinkMode(PSDEField var1) throws Exception {
      this.get(var1);
      if (DataObject.getBoolValue(var1.getPhysicalField(), false)) {
         if (StringHelper.compare(var1.getPSDataTypeId(), "PICKUPDATA", true) != 0 && StringHelper.compare(var1.getPSDataTypeId(), "PICKUPTEXT", true) != 0) {
            String var3 = DEFDataTypeCodeListModel.getInstance().getCodeListText(var1.getPSDataTypeId(), true);
            this.sendStudioConsole(
               true, "WARN", StringHelper.format("属性[%1$s]类型[%2$s]，无法设置为链接模式，链接模式仅支持类型[外键值文本]及[外键值附加数据]", var1.getPSDEFieldName(), var3), false
            );
         } else {
            String var2 = var1.getPSDEFieldId();
            var1.reset();
            var1.setPSDEFieldId(var2);
            var1.setPhysicalField(0);
            var1.setDEFType(3);
            var1.setTableName(null);
            this.update(var1);
         }
      }
   }

   @Override
   public void makeRealMode(PSDEField var1) throws Exception {
      this.get(var1);
      if (!DataObject.getBoolValue(var1.getPhysicalField(), false)) {
         if (StringHelper.compare(var1.getPSDataTypeId(), "PICKUPDATA", true) != 0 && StringHelper.compare(var1.getPSDataTypeId(), "PICKUPTEXT", true) != 0) {
            String var4 = DEFDataTypeCodeListModel.getInstance().getCodeListText(var1.getPSDataTypeId(), true);
            this.sendStudioConsole(
               true, "WARN", StringHelper.format("属性[%1$s]类型[%2$s]，无法设置为物理模式，物理模式仅支持类型[外键值文本]及[外键值附加数据]", var1.getPSDEFieldName(), var4), false
            );
         } else {
            String var2 = var1.getPSDE().getTableName();
            String var3 = var1.getPSDEFieldId();
            var1.reset();
            var1.setPSDEFieldId(var3);
            var1.setPhysicalField(1);
            var1.setDEFType(1);
            var1.setTableName(var2);
            this.update(var1);
         }
      }
   }

   @Override
   public void initModel(String var1, IEntity var2, String var3) throws Exception {
      if (StringHelper.compare(var1, "PSDATAENTITY", true) == 0) {
         PSDataEntity var4 = new PSDataEntity();
         var4.proxy(var2);
         boolean var5 = false;
         if (DataObject.getBoolValue(var4.getExistingModel(), false)) {
            this.sendStudioConsole(true, "WARN", StringHelper.format("现有结构实体[%1$s]不会自动初始化默认属性", var4.getPSDataEntityName()), false);
            var5 = true;
         }

         if (!var5 && DataObject.getIntegerValue(var4.getVirtualFlag(), 0) > 0) {
            var5 = true;
            this.sendStudioConsole(true, "WARN", StringHelper.format("虚拟实体[%1$s]不会自动初始化默认属性", var4.getPSDataEntityName()), false);
         }

         if (!var5 && !StringHelper.isNullOrEmpty(var4.getPSSubSysSADEId())) {
            var5 = true;
            this.sendStudioConsole(true, "WARN", StringHelper.format("外部接口实体[%1$s]不会自动初始化默认属性", var4.getPSDataEntityName()), false);
         }

         if (!var5 && var4.getPSModule() != null && DataObject.getBoolValue(var4.getPSModule().getSubSysModule(), false)) {
            var5 = true;
            this.sendStudioConsole(true, "WARN", StringHelper.format("子系统实体[%1$s]不会自动初始化默认属性", var4.getPSDataEntityName()), false);
         }

         if (!var5) {
            PSSystem var6 = getCurrentPSSystem(var4, this.getSessionFactory());
            boolean var7 = false;
            if (PSCoreSysModel.isEnableFolderKey() && DataObject.getBoolValue(var6.getEnableFolderKey(), false)) {
               var7 = true;
            }

            PSDCModelTempl var8 = null;
            if (!StringHelper.isNullOrEmpty(var6.getPSDevSlnSysId())) {
               var8 = PSModelGlobal.getPSDCModelTempl(var6.getPSDevSlnSysId());
            }

            String var9 = var4.getPSDataEntityName();
            String var10 = var4.getLogicName();
            String var11 = var4.getCodeName();
            ArrayList<PSDCMTDEF> var12 = new ArrayList<PSDCMTDEF>();
            PSDCMTDEF var13 = null;
            PSDCMTDEF var14 = null;
            HashMap<String, PSDCMTDEF> var15 = new HashMap<String, PSDCMTDEF>();
            if (var8 != null) {
               for (PSDCMTDEF var18 : var8.getPSDCMTDEFs()) {
                  if (DataObject.getBoolValue(var18.getPKey(), false)) {
                     var13 = var18;
                  } else if (DataObject.getBoolValue(var18.getMajorField(), false)) {
                     var14 = var18;
                  } else if (!StringHelper.isNullOrEmpty(var18.getPreDefinedType())) {
                     var15.put(var18.getPreDefinedType(), var18);
                  } else {
                     var12.add(var18);
                  }
               }
            }

            PSDEField var24 = new PSDEField();
            var24.setPSDEId(var4.getPSDataEntityId());
            var24.setPKey(1);
            if (!this.select(var24, true)) {
               if (var13 != null) {
                  String var29 = var13.getPSDCMTDEFName().replace("_DENAME_", var9);
                  if (!StringHelper.isNullOrEmpty(var29) && var29.indexOf("_") == 0 && var29.lastIndexOf("_") == var29.length() - 1) {
                     var29 = var29.substring(1);
                     if (!StringHelper.isNullOrEmpty(var29)) {
                        var29 = var29.substring(0, var29.length() - 1);
                     }
                  }

                  if (StringHelper.compare(var29, var13.getPSDCMTDEFName(), false) == 0) {
                     var29 = var9 + var13.getPSDCMTDEFName();
                  }

                  var24.setPSDEFieldName(var29);
                  var24.setLength(var13.getLength());
                  if (!StringHelper.isNullOrEmpty(var13.getLogicName())) {
                     String var40 = var13.getLogicName().replace("_DENAME_", var10);
                     var24.setLogicName(var40);
                  }

                  if (!StringHelper.isNullOrEmpty(var13.getCodeName())) {
                     String var41 = var13.getCodeName().replace("_DENAME_", var11);
                     var24.setCodeName(var41);
                  }

                  if (var13.getOrderValue() != null) {
                     var24.setOrderValue(var13.getOrderValue());
                  }
               } else {
                  if (isEnableCodeNameUpperCamel()) {
                     var24.setPSDEFieldName(StringHelper.format("%1$s_ID", var9));
                  } else {
                     var24.setPSDEFieldName(StringHelper.format("%1$sID", var9));
                  }

                  if (StringHelper.isNullOrEmpty(var24.getCodeName())) {
                     var24.setCodeName(StringHelper.format("%1$sId", var11));
                  }
               }

               if (StringHelper.isNullOrEmpty(var24.getLogicName())) {
                  var24.setLogicName(StringHelper.format("%1$s标识", var10));
               }

               var24.setPSDataTypeId("GUID");
               var24.setPSDEId(var4.getPSDataEntityId());
               if (var7) {
                  var24.setPSDEFieldId(StringHelper.format("%1$s-%2$s", var24.getPSDEId(), "R1"));
               } else {
                  var24.setPSDEFieldId(KeyValueHelper.genUniqueId(var24.getPSDEId(), var24.getPSDEFieldName()));
               }

               if (this.checkKey(var24) == 0) {
                  var24.setTableName(var4.getTableName());
                  var24.setDEFType(1);
                  var24.setPhysicalField(1);
                  var24.setAllowEmpty(0);
                  var24.setLength(100);
                  var24.setMajorField(0);
                  var24.setPKey(1);
                  var24.setFKey(0);
                  this.create(var24, false);
               }
            }

            var24 = new PSDEField();
            var24.setPSDEId(var4.getPSDataEntityId());
            var24.setMajorField(1);
            if (!this.select(var24, true)) {
               if (var14 != null) {
                  String var30 = var14.getPSDCMTDEFName().replace("_DENAME_", var9);
                  if (!StringHelper.isNullOrEmpty(var30) && var30.indexOf("_") == 0 && var30.lastIndexOf("_") == var30.length() - 1) {
                     var30 = var30.substring(1);
                     if (!StringHelper.isNullOrEmpty(var30)) {
                        var30 = var30.substring(0, var30.length() - 1);
                     }
                  }

                  if (StringHelper.compare(var30, var14.getPSDCMTDEFName(), false) == 0) {
                     var30 = var9 + var14.getPSDCMTDEFName();
                  }

                  var24.setPSDEFieldName(var30);
                  var24.setPSDataTypeId(var14.getDEFDataType());
                  var24.setLength(var14.getLength());
                  if (!StringHelper.isNullOrEmpty(var14.getLogicName())) {
                     String var42 = var14.getLogicName().replace("_DENAME_", var10);
                     var24.setLogicName(var42);
                  }

                  if (!StringHelper.isNullOrEmpty(var14.getCodeName())) {
                     String var43 = var14.getCodeName().replace("_DENAME_", var11);
                     var24.setCodeName(var43);
                  }

                  if (var14.getOrderValue() != null) {
                     var24.setOrderValue(var14.getOrderValue());
                  }
               } else {
                  if (isEnableCodeNameUpperCamel()) {
                     var24.setPSDEFieldName(StringHelper.format("%1$s_NAME", var9));
                  } else {
                     var24.setPSDEFieldName(StringHelper.format("%1$sNAME", var9));
                  }

                  if (StringHelper.isNullOrEmpty(var24.getCodeName())) {
                     var24.setCodeName(StringHelper.format("%1$sName", var11));
                  }
               }

               if (StringHelper.isNullOrEmpty(var24.getDEFType())) {
                  var24.setPSDataTypeId("TEXT");
                  if (var24.getLength() == null || var24.getLength() <= 0) {
                     var24.setLength(200);
                  }
               }

               if (StringHelper.isNullOrEmpty(var24.getLogicName())) {
                  var24.setLogicName(StringHelper.format("%1$s名称", var10));
               }

               var24.setTableName(var4.getTableName());
               var24.setDEFType(1);
               var24.setPhysicalField(1);
               var24.setEnableUserInput(3);
               var24.setAllowEmpty(1);
               var24.setPSDEId(var4.getPSDataEntityId());
               if (var7) {
                  var24.setPSDEFieldId(StringHelper.format("%1$s-%2$s", var24.getPSDEId(), "R2"));
               } else {
                  var24.setPSDEFieldId(KeyValueHelper.genUniqueId(var24.getPSDEId(), var24.getPSDEFieldName()));
               }

               if (this.checkKey(var24) == 0) {
                  var24.setMajorField(1);
                  var24.setPKey(0);
                  var24.setFKey(0);
                  this.create(var24, false);
               }
            }

            if (DataObject.getBoolValue(var4.getLogicValid(), false)) {
               var24 = new PSDEField();
               var24.setPSDEId(var4.getPSDataEntityId());
               var24.setPreDefineType("LOGICVALID");
               if (!this.select(var24, true)) {
                  PSDCMTDEF var31 = (PSDCMTDEF)var15.get("LOGICVALID");
                  if (var31 != null) {
                     var24.setPSDEFieldName(var31.getPSDCMTDEFName());
                     var24.setCodeName(var31.getCodeName());
                     var24.setLogicName(var31.getLogicName());
                     var24.setPSDataTypeId(var31.getDEFDataType());
                     var24.setLength(var31.getLength());
                     var24.setPreDefineType("LOGICVALID");
                     if (var31.getOrderValue() != null) {
                        var24.setOrderValue(var31.getOrderValue());
                     }
                  } else {
                     var24.setPSDEFieldName("ENABLE");
                     var24.setCodeName("Enable");
                     var24.setLogicName("逻辑有效标志");
                     var24.setPSDataTypeId("YESNO");
                     var24.setLength(8);
                  }

                  var24.setPSDEId(var4.getPSDataEntityId());
                  var24.setTableName(var4.getTableName());
                  var24.setDEFType(1);
                  var24.setPhysicalField(1);
                  var24.setAllowEmpty(0);
                  var24.setMajorField(0);
                  var24.setPKey(0);
                  var24.setFKey(0);
                  if (var7) {
                     var24.setPSDEFieldId(StringHelper.format("%1$s-%2$s", var24.getPSDEId(), "R3"));
                  } else {
                     var24.setPSDEFieldId(KeyValueHelper.genUniqueId(var24.getPSDEId(), var24.getPSDEFieldName()));
                  }

                  if (this.checkKey(var24) == 0) {
                     this.create(var24, false);
                  }
               }
            }

            if (!StringHelper.isNullOrEmpty(var4.getIndexDEType())) {
               var24 = new PSDEField();
               var24.setPSDEId(var4.getPSDataEntityId());
               var24.setIndexType(1);
               if (!this.select(var24, true)) {
                  if (isEnableCodeNameUpperCamel()) {
                     var24.setPSDEFieldName(StringHelper.format("%1$s_TYPE", var9));
                  } else {
                     var24.setPSDEFieldName(StringHelper.format("%1$sTYPE", var9));
                  }

                  var24.setPSDEId(var4.getPSDataEntityId());
                  var24.setLogicName("分组类型");
                  var24.setCodeName(StringHelper.format("%1$sType", var11));
                  var24.setTableName(var4.getTableName());
                  var24.setDEFType(1);
                  var24.setAllowEmpty(0);
                  var24.setPSDataTypeId("SSCODELIST");
                  var24.setLength(100);
                  var24.setPhysicalField(1);
                  var24.setIndexType(1);
                  var24.setMajorField(0);
                  var24.setPKey(0);
                  var24.setFKey(0);
                  if (var7) {
                     var24.setPSDEFieldId(StringHelper.format("%1$s-%2$s", var24.getPSDEId(), "R30"));
                  } else {
                     var24.setPSDEFieldId(KeyValueHelper.genUniqueId(var24.getPSDEId(), var24.getPSDEFieldName()));
                  }

                  if (this.checkKey(var24) == 0) {
                     this.create(var24, false);
                  }
               }
            }

            boolean var28 = false;
            if (var4.isEnableOPNameModelDirty()) {
               var28 = DataObject.getBoolValue(var4.getEnableOPNameModel(), false);
            } else if (var4.getPSSystem() != null) {
               var28 = DataObject.getBoolValue(var4.getPSSystem().getEnableOPNameModel(), false);
            }

            PSDEField var32 = new PSDEField();
            var32.setPSDEId(var4.getPSDataEntityId());
            var32.setPreDefineType("CREATEMAN");
            if (!this.select(var32, true)) {
               PSDCMTDEF var44 = (PSDCMTDEF)var15.remove("CREATEMAN");
               if (var44 != null) {
                  var32.setPSDEFieldName(var44.getPSDCMTDEFName());
                  var32.setCodeName(var44.getCodeName());
                  var32.setLogicName(var44.getLogicName());
                  var32.setPSDataTypeId(var44.getDEFDataType());
                  var32.setLength(var44.getLength());
                  var32.setPreDefineType("CREATEMAN");
                  if (var44.getOrderValue() != null) {
                     var32.setOrderValue(var44.getOrderValue());
                  }
               } else {
                  var32.setLogicName("建立人");
                  var32.setCodeName("CreateMan");
                  if (isEnableCodeNameUpperCamel()) {
                     var32.setPSDEFieldName(StringHelper.format("CREATE_MAN", var9));
                  } else {
                     var32.setPSDEFieldName(StringHelper.format("CREATEMAN", var9));
                  }

                  var32.setPSDataTypeId("TEXT");
                  var32.setLength(60);
               }

               var32.setPSDEId(var4.getPSDataEntityId());
               var32.setTableName(var4.getTableName());
               var32.setDEFType(1);
               var32.setPhysicalField(1);
               var32.setAllowEmpty(0);
               var32.setMajorField(0);
               var32.setPKey(0);
               var32.setFKey(0);
               if (var7) {
                  var32.setPSDEFieldId(StringHelper.format("%1$s-%2$s", var32.getPSDEId(), "R4"));
               } else {
                  var32.setPSDEFieldId(KeyValueHelper.genUniqueId(var32.getPSDEId(), var32.getPSDEFieldName()));
               }

               if (this.checkKey(var32) == 0) {
                  this.create(var32, false);
               }
            }

            if (var28) {
               var32 = new PSDEField();
               var32.setPSDEId(var4.getPSDataEntityId());
               var32.setPreDefineType("CREATEMANNAME");
               if (!this.select(var32, true)) {
                  PSDCMTDEF var45 = (PSDCMTDEF)var15.remove("CREATEMANNAME");
                  if (var45 != null) {
                     var32.setPSDEFieldName(var45.getPSDCMTDEFName());
                     var32.setCodeName(var45.getCodeName());
                     var32.setLogicName(var45.getLogicName());
                     var32.setPSDataTypeId(var45.getDEFDataType());
                     var32.setLength(var45.getLength());
                     var32.setPreDefineType("CREATEMANNAME");
                     if (var45.getOrderValue() != null) {
                        var32.setOrderValue(var45.getOrderValue());
                     }
                  } else {
                     var32.setLogicName("建立人名称");
                     var32.setCodeName("CreateManName");
                     if (isEnableCodeNameUpperCamel()) {
                        var32.setPSDEFieldName(StringHelper.format("CREATE_MAN_NAME", var9));
                     } else {
                        var32.setPSDEFieldName(StringHelper.format("CREATEMANNAME", var9));
                     }

                     var32.setPSDataTypeId("TEXT");
                     var32.setLength(100);
                  }

                  var32.setPSDEId(var4.getPSDataEntityId());
                  var32.setTableName(var4.getTableName());
                  var32.setDEFType(1);
                  var32.setPhysicalField(1);
                  var32.setAllowEmpty(1);
                  var32.setMajorField(0);
                  var32.setPKey(0);
                  var32.setFKey(0);
                  if (var7) {
                     var32.setPSDEFieldId(StringHelper.format("%1$s-%2$s", var32.getPSDEId(), "R8"));
                  } else {
                     var32.setPSDEFieldId(KeyValueHelper.genUniqueId(var32.getPSDEId(), var32.getPSDEFieldName()));
                  }

                  if (this.checkKey(var32) == 0) {
                     this.create(var32, false);
                  }
               }
            }

            var32 = new PSDEField();
            var32.setPSDEId(var4.getPSDataEntityId());
            var32.setPreDefineType("CREATEDATE");
            if (!this.select(var32, true)) {
               PSDCMTDEF var46 = (PSDCMTDEF)var15.remove("CREATEDATE");
               if (var46 != null) {
                  var32.setPSDEFieldName(var46.getPSDCMTDEFName());
                  var32.setCodeName(var46.getCodeName());
                  var32.setLogicName(var46.getLogicName());
                  var32.setPSDataTypeId(var46.getDEFDataType());
                  var32.setLength(var46.getLength());
                  var32.setPreDefineType("CREATEDATE");
                  if (var46.getOrderValue() != null) {
                     var32.setOrderValue(var46.getOrderValue());
                  }
               } else {
                  if (isEnableCodeNameUpperCamel()) {
                     var32.setPSDEFieldName(StringHelper.format("CREATE_DATE", var9));
                  } else {
                     var32.setPSDEFieldName(StringHelper.format("CREATEDATE", var9));
                  }

                  var32.setLogicName("建立时间");
                  var32.setCodeName("CreateDate");
                  var32.setPSDataTypeId("DATETIME");
                  var32.setLength(8);
               }

               var32.setPSDEId(var4.getPSDataEntityId());
               var32.setTableName(var4.getTableName());
               var32.setDEFType(1);
               var32.setPhysicalField(1);
               var32.setAllowEmpty(0);
               var32.setMajorField(0);
               var32.setPKey(0);
               var32.setFKey(0);
               if (var7) {
                  var32.setPSDEFieldId(StringHelper.format("%1$s-%2$s", var32.getPSDEId(), "R5"));
               } else {
                  var32.setPSDEFieldId(KeyValueHelper.genUniqueId(var32.getPSDEId(), var32.getPSDEFieldName()));
               }

               if (this.checkKey(var32) == 0) {
                  this.create(var32, false);
               }
            }

            var32 = new PSDEField();
            var32.setPSDEId(var4.getPSDataEntityId());
            var32.setPreDefineType("UPDATEMAN");
            if (!this.select(var32, true)) {
               PSDCMTDEF var47 = (PSDCMTDEF)var15.remove("UPDATEMAN");
               if (var47 != null) {
                  var32.setPSDEFieldName(var47.getPSDCMTDEFName());
                  var32.setCodeName(var47.getCodeName());
                  var32.setLogicName(var47.getLogicName());
                  var32.setPSDataTypeId(var47.getDEFDataType());
                  var32.setLength(var47.getLength());
                  var32.setPreDefineType("UPDATEMAN");
                  if (var47.getOrderValue() != null) {
                     var32.setOrderValue(var47.getOrderValue());
                  }
               } else {
                  if (isEnableCodeNameUpperCamel()) {
                     var32.setPSDEFieldName(StringHelper.format("UPDATE_MAN", var9));
                  } else {
                     var32.setPSDEFieldName(StringHelper.format("UPDATEMAN", var9));
                  }

                  var32.setLogicName("更新人");
                  var32.setCodeName("UpdateMan");
                  var32.setPSDataTypeId("TEXT");
                  var32.setLength(60);
               }

               var32.setPSDEId(var4.getPSDataEntityId());
               var32.setTableName(var4.getTableName());
               var32.setDEFType(1);
               var32.setAllowEmpty(0);
               var32.setMajorField(0);
               var32.setPKey(0);
               var32.setFKey(0);
               if (var7) {
                  var32.setPSDEFieldId(StringHelper.format("%1$s-%2$s", var32.getPSDEId(), "R6"));
               } else {
                  var32.setPSDEFieldId(KeyValueHelper.genUniqueId(var32.getPSDEId(), var32.getPSDEFieldName()));
               }

               if (this.checkKey(var32) == 0) {
                  this.create(var32, false);
               }
            }

            if (var28) {
               var32 = new PSDEField();
               var32.setPSDEId(var4.getPSDataEntityId());
               var32.setPreDefineType("UPDATEMANNAME");
               if (!this.select(var32, true)) {
                  PSDCMTDEF var48 = (PSDCMTDEF)var15.remove("UPDATEMANNAME");
                  if (var48 != null) {
                     var32.setPSDEFieldName(var48.getPSDCMTDEFName());
                     var32.setCodeName(var48.getCodeName());
                     var32.setLogicName(var48.getLogicName());
                     var32.setPSDataTypeId(var48.getDEFDataType());
                     var32.setLength(var48.getLength());
                     var32.setPreDefineType("UPDATEMANNAME");
                     if (var48.getOrderValue() != null) {
                        var32.setOrderValue(var48.getOrderValue());
                     }
                  } else {
                     var32.setLogicName("更新人名称");
                     var32.setCodeName("UpdateManName");
                     if (isEnableCodeNameUpperCamel()) {
                        var32.setPSDEFieldName(StringHelper.format("UPDATE_MAN_NAME", var9));
                     } else {
                        var32.setPSDEFieldName(StringHelper.format("UPDATEMANNAME", var9));
                     }

                     var32.setPSDataTypeId("TEXT");
                     var32.setLength(100);
                  }

                  var32.setPSDEId(var4.getPSDataEntityId());
                  var32.setTableName(var4.getTableName());
                  var32.setDEFType(1);
                  var32.setPhysicalField(1);
                  var32.setAllowEmpty(1);
                  var32.setMajorField(0);
                  var32.setPKey(0);
                  var32.setFKey(0);
                  if (var7) {
                     var32.setPSDEFieldId(StringHelper.format("%1$s-%2$s", var32.getPSDEId(), "R9"));
                  } else {
                     var32.setPSDEFieldId(KeyValueHelper.genUniqueId(var32.getPSDEId(), var32.getPSDEFieldName()));
                  }

                  if (this.checkKey(var32) == 0) {
                     this.create(var32, false);
                  }
               }
            }

            var32 = new PSDEField();
            var32.setPSDEId(var4.getPSDataEntityId());
            var32.setPreDefineType("UPDATEDATE");
            if (!this.select(var32, true)) {
               PSDCMTDEF var49 = (PSDCMTDEF)var15.remove("UPDATEDATE");
               if (var49 != null) {
                  var32.setPSDEFieldName(var49.getPSDCMTDEFName());
                  var32.setCodeName(var49.getCodeName());
                  var32.setLogicName(var49.getLogicName());
                  var32.setPSDataTypeId(var49.getDEFDataType());
                  var32.setLength(var49.getLength());
                  var32.setPreDefineType("UPDATEDATE");
                  if (var49.getOrderValue() != null) {
                     var32.setOrderValue(var49.getOrderValue());
                  }
               } else {
                  if (isEnableCodeNameUpperCamel()) {
                     var32.setPSDEFieldName(StringHelper.format("UPDATE_DATE", var9));
                  } else {
                     var32.setPSDEFieldName(StringHelper.format("UPDATEDATE", var9));
                  }

                  var32.setLogicName("更新时间");
                  var32.setCodeName("UpdateDate");
                  var32.setPSDataTypeId("DATETIME");
                  var32.setLength(8);
               }

               var32.setPSDEId(var4.getPSDataEntityId());
               var32.setTableName(var4.getTableName());
               var32.setDEFType(1);
               var32.setPhysicalField(1);
               var32.setAllowEmpty(0);
               var32.setMajorField(0);
               var32.setPKey(0);
               var32.setFKey(0);
               if (var7) {
                  var32.setPSDEFieldId(StringHelper.format("%1$s-%2$s", var32.getPSDEId(), "R7"));
               } else {
                  var32.setPSDEFieldId(KeyValueHelper.genUniqueId(var32.getPSDEId(), var32.getPSDEFieldName()));
               }

               if (this.checkKey(var32) == 0) {
                  this.create(var32, false);
               }
            }

            if (DataObject.getBoolValue(var4.getEnableOrgModel(), false)) {
               var32 = new PSDEField();
               var32.setPSDEId(var4.getPSDataEntityId());
               var32.setPreDefineType("ORGID");
               if (!this.select(var32, true)) {
                  PSDCMTDEF var50 = (PSDCMTDEF)var15.remove("ORGID");
                  if (var50 != null) {
                     var32.setPSDEFieldName(var50.getPSDCMTDEFName());
                     var32.setCodeName(var50.getCodeName());
                     var32.setLogicName(var50.getLogicName());
                     var32.setPSDataTypeId(var50.getDEFDataType());
                     var32.setLength(var50.getLength());
                     var32.setPreDefineType("ORGID");
                     if (var50.getOrderValue() != null) {
                        var32.setOrderValue(var50.getOrderValue());
                     }
                  } else {
                     if (isEnableCodeNameUpperCamel()) {
                        var32.setPSDEFieldName(StringHelper.format("ORG_ID"));
                     } else {
                        var32.setPSDEFieldName(StringHelper.format("ORGID"));
                     }

                     var32.setLogicName("组织机构标识");
                     var32.setCodeName("OrgId");
                     var32.setPSDataTypeId("TEXT");
                     var32.setLength(60);
                  }

                  var32.setPSDEId(var4.getPSDataEntityId());
                  var32.setTableName(var4.getTableName());
                  var32.setDEFType(1);
                  var32.setPhysicalField(1);
                  var32.setAllowEmpty(0);
                  var32.setMajorField(0);
                  var32.setPKey(0);
                  var32.setFKey(0);
                  if (var7) {
                     var32.setPSDEFieldId(StringHelper.format("%1$s-%2$s", var32.getPSDEId(), "R31"));
                  } else {
                     var32.setPSDEFieldId(KeyValueHelper.genUniqueId(var32.getPSDEId(), var32.getPSDEFieldName()));
                  }

                  if (this.checkKey(var32) == 0) {
                     this.create(var32, false);
                  }
               }
            }

            var12.addAll(var15.values());

            for (PSDCMTDEF var51 : var12) {
               PSDEField var19 = new PSDEField();
               var19.setPSDEFieldName(var51.getPSDCMTDEFName());
               var19.setCodeName(var51.getCodeName());
               var19.setLogicName(var51.getLogicName());
               var19.setPSDataTypeId(var51.getDEFDataType());
               var19.setLength(var51.getLength());
               var19.setPreDefineType(var51.getPreDefinedType());
               var19.setPSDEId(var4.getPSDataEntityId());
               var19.setTableName(var4.getTableName());
               var19.setDEFType(1);
               var19.setPhysicalField(1);
               var19.setAllowEmpty(1);
               var19.setMajorField(0);
               var19.setPKey(0);
               var19.setFKey(0);
               if (var51.getOrderValue() != null) {
                  var19.setOrderValue(var51.getOrderValue());
               }

               if (var7) {
                  PSDEField var20 = new PSDEField();
                  var20.setPSDEId(var19.getPSDEId());
                  var20.setPSDEFieldName(var19.getPSDEFieldName());
                  if (!this.selectOne(var20, true)) {
                     this.create(var19, false);
                  }
               } else {
                  var19.setPSDEFieldId(KeyValueHelper.genUniqueId(var19.getPSDEId(), var19.getPSDEFieldName()));
                  if (this.checkKey(var19) == 0) {
                     this.create(var19, false);
                  }
               }
            }
         }

         for (PSDEField var23 : this.selectByPSDE(var4)) {
            this.initModel(var23);
         }
      }
   }

   @Override
   protected void onBeforeRemove(PSDEField var1) throws Exception {
      PSSysDMItemService var2 = (PSSysDMItemService)ServiceGlobal.getService(PSSysDMItemService.class, this.getSessionFactory());
      SelectCond var3 = new SelectCond();
      var3.set("DBOBJTYPE", "COLUMN");
      var3.set("PSOBJID", var1.getPSDEFieldId());
      var2.remove(var3, true);
      var3.reset();
      var3.set("DBOBJTYPE", "FKEY");
      var3.set("PSOBJID", var1.getPSDEFieldId());
      var2.remove(var3, true);
      super.onBeforeRemove(var1);
   }

   @Override
   protected void onResetRefs(PSDEField var1) throws Exception {
   }

   @Override
   protected void onCheckEntity(boolean var1, PSDEField var2, boolean var3, boolean var4, EntityError var5) throws Exception {
      if (!var1) {
         PSDataEntity var6 = new PSDataEntity();
         var6.setPSDataEntityId(var2.getPSDEId());
         PSDataEntityService var7 = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, this.getSessionFactory());
         if (!StringHelper.isNullOrEmpty(var2.getCodeName())) {
            String var8 = var7.checkObjCodeName(var6, var2, var2.getCodeName());
            if (!StringHelper.isNullOrEmpty(var8)) {
               var5.register("CODENAME", "代码名称", "", 3, StringHelper.format("代码名称[%1$s]已经被%2$s使用", var2.getCodeName(), var8));
            }
         }
      }

      super.onCheckEntity(var1, var2, var3, var4, var5);
   }

   protected String calcDEFieldCodeName(String var1) throws Exception {
      Object var2 = DataContextMethod.getValue("pssystemid", this.getSessionFactory());
      if (StringHelper.isNullOrEmpty(var2)) {
         var2 = "2C40DFCD-0DF5-47BF-91A5-C45F810B0001";
      }

      SelectCond var3 = new SelectCond();
      var3.set("PSSYSTEMID", var2);
      var3.set("PSDEFIELDNAME", var1);
      var3.set("CODENAME", SelectCond.ISNOTNULL);
      var3.setOrderInfo(" ORDER BY UPDATEDATE DESC");
      var3.setFetchFirst(true);
      ArrayList var4 = this.select(var3);
      return var4.size() > 0 ? ((PSDEField)var4.get(0)).getCodeName() : null;
   }

   @Override
   protected void onExecuteAction(String var1, ArrayList<IEntity> var2) throws Exception {
      if (StringHelper.compare(var1, "AUTOCODENAME", true) == 0) {
         this.fillDEFieldsCodeName(var2);
      } else {
         super.onExecuteAction(var1, var2);
      }
   }

   protected void fillDEFieldsCodeName(ArrayList<IEntity> var1) throws Exception {
      HashMap var2 = new HashMap();

      for (IEntity var4 : var1) {
         PSDEField var5 = new PSDEField();
         var5.setPSDEFieldId(DataObject.getStringValue(var4.get("PSDEFIELDID")));
         this.get(var5);
         if (StringHelper.isNullOrEmpty(var5.getCodeName())) {
            String var6 = (String)var2.get(var5.getPSDEFieldName());
            if (var6 == null) {
               var6 = this.calcDEFieldCodeName(var5.getPSDEFieldName());
               if (StringHelper.isNullOrEmpty(var6) && isEnableCodeNameUpperCamel()) {
                  var6 = toUpperCamel(var5.getPSDEFieldName());
               }

               if (StringHelper.isNullOrEmpty(var6)) {
                  var6 = "";
               }

               var2.put(var5.getPSDEFieldName(), var6);
            }

            if (!StringHelper.isNullOrEmpty(var6)) {
               var5.reset();
               var5.setPSDEFieldId(DataObject.getStringValue(var4.get("PSDEFIELDID")));
               var5.setCodeName(var6);
               this.update(var5, false);
            }
         }
      }
   }

   @Override
   protected void onAutoCodeName(PSDEField var1) throws Exception {
      this.get(var1);
      if (StringHelper.isNullOrEmpty(var1.getCodeName())) {
         String var2 = this.calcDEFieldCodeName(var1.getPSDEFieldName());
         if (StringHelper.isNullOrEmpty(var2) && isEnableCodeNameUpperCamel()) {
            var2 = toUpperCamel(var1.getPSDEFieldName());
         }

         if (!StringHelper.isNullOrEmpty(var2)) {
            var1.setCodeName(var2);
            this.update(var1, false);
         }
      }
   }

   @Override
   protected void onCreateDefaultInputTip(PSDEField var1) throws Exception {
      this.get(var1);
      PSDEFInputTipService var2 = (PSDEFInputTipService)ServiceGlobal.getService(PSDEFInputTipService.class, this.getSessionFactory());
      PSDEFInputTip var3 = new PSDEFInputTip();
      var3.setPSDEFId(var1.getPSDEFieldId());
      var3.setDefaultFlag(1);
      if (!var2.select(var3, true)) {
         PSDataEntity var4 = (PSDataEntity)this.getWebContextCacheEntity("PSDATAENTITY", var1.getPSDEId());
         var3.reset();
         var3.setPSDEFInputTipName(StringHelper.format("[%1$s]默认输入提示", var1.getPSDEFieldName()));
         var3.setPSDEFId(var1.getPSDEFieldId());
         var3.setPSDEFName(var1.getPSDEFieldName());
         var3.setPSDEId(var1.getPSDEId());
         var3.setPSDEName(var1.getPSDEName());
         var3.setDefaultFlag(1);
         if (!StringHelper.isNullOrEmpty(var4.getPSDEFInputTipSetId())) {
            var3.setPSDEFInputTipSetId(var4.getPSDEFInputTipSetId());
            var3.setUniqueTag(StringHelper.format("%1$s__%2$s", var4.getPSDataEntityName(), var1.getPSDEFieldName()).toUpperCase());
         }

         var2.create(var3);
      }
   }

   @Override
   protected void onCreateDefaultVR(PSDEField var1) throws Exception {
      this.get(var1);
      PSDEFValueRule var2 = new PSDEFValueRule();
      var2.setDefaultMode(1);
      var2.setSessionFactory(this.getSessionFactory());
      var2.setPSDEFId(var1.getPSDEFieldId());
      if (!var2.select(true)) {
         String var3 = "";

         for (int var4 = 1; var4 < 100; var4++) {
            var3 = "Default";
            if (var4 >= 2) {
               var3 = var3 + Integer.toString(var4);
            }

            var2.reset();
            var2.setSessionFactory(this.getSessionFactory());
            var2.setPSDEFId(var1.getPSDEFieldId());
            var2.setCodeName(var3);
            if (!var2.select(true)) {
               break;
            }
         }

         var2.reset();
         var2.setDefaultMode(1);
         var2.setSessionFactory(this.getSessionFactory());
         var2.setPSDEId(var1.getPSDEId());
         var2.setPSDEName(var1.getPSDEName());
         var2.setPSDEFId(var1.getPSDEFieldId());
         var2.setPSDEFName(var1.getPSDEFieldName());
         var2.setCodeName(var3);
         var2.setPSDEFValueRuleName(StringHelper.format("默认规则", var1.getLogicName()));
         var2.setRuleInfo(StringHelper.format("默认规则", var1.getLogicName()));
         var2.create();
      }
   }

   @Override
   protected void onAjaxFillDVT(PSDEField var1) throws Exception {
      if (this.getWebContext() != null && this.getWebContext().getCurAjaxActionResult() != null) {
         String var2 = this.getWebContext().getPostValue("srfactionparam");
         if (!StringHelper.isNullOrEmpty(var2)) {
            JSONObject var3 = JSONObject.fromString(var2);
            String var4 = var3.optString("srfkey");
            if (!StringHelper.isNullOrEmpty(var4)) {
               PSVarSampleValueService var5 = (PSVarSampleValueService)ServiceGlobal.getService(
                  PSVarSampleValueService.class, PSCoreSysServiceBase.getCurMajorSessionFactory()
               );
               PSVarSampleValue var6 = new PSVarSampleValue();
               var6.setPSVarSampleValueId(var4);
               if (var5.get(var6, true)) {
                  var1.setDefaultValueType(var6.getVarType());
                  var1.setDefaultValue(var6.getValue());
               }
            }
         }
      } else {
         throw new Exception("当前请求环境不正确");
      }
   }

   @Override
   protected void onAjaxFillDataType(PSDEField var1) throws Exception {
      if (this.getWebContext() != null && this.getWebContext().getCurAjaxActionResult() != null) {
         String var2 = this.getWebContext().getPostValue("srfactionparam");
         if (!StringHelper.isNullOrEmpty(var2)) {
            JSONObject var3 = JSONObject.fromString(var2);
            String var4 = var3.optString("srfkey");
            if (!StringHelper.isNullOrEmpty(var4)) {
               String var5 = var3.optString("srfmajortext");
               var1.setPSDataTypeId(var4);
               var1.setPSDataTypeName(var5);
            }
         }
      } else {
         throw new Exception("当前请求环境不正确");
      }
   }

   protected void syncPSDEFDataType(PSDEField var1) throws Exception {
      if (!StringHelper.isNullOrEmpty(var1.getPSDataTypeId())) {
         if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            PSDEFDataTypeService var2 = (PSDEFDataTypeService)ServiceGlobal.getService(PSDEFDataTypeService.class, this.getSessionFactory());
            PSDEFDataType var3 = new PSDEFDataType();
            var3.setPSDEFDataTypeId(var1.getPSDataTypeId());
            if (!var2.get(var3, true)) {
               PSDEFDataTypeService var4 = (PSDEFDataTypeService)ServiceGlobal.getService(
                  PSDEFDataTypeService.class, PSCoreSysServiceBase.getCurMajorSessionFactory()
               );
               PSDEFDataType var5 = new PSDEFDataType();
               var5.setPSDEFDataTypeId(var1.getPSDataTypeId());
               if (!var4.get(var5, true)) {
                  throw new Exception(StringHelper.format("无法获取指定属性数据类型[%1$s]", var1.getPSDataTypeId()));
               }

               var5.setPSUnitId(null);
               var5.setPSUnitName(null);
               var5.setPSValueRuleId(null);
               var5.setPSValueRuleName(null);
               var2.create(var5);
            }
         }
      }
   }

   public ObjectNode exportModelV2(PSDEField var1) throws Exception {
      ObjectNode var2 = super.exportModelV2(var1);
      if (var2 != null) {
         var2.remove("tablename");
         var2.remove("psdetableid");
         var2.remove("pssysdbcolumnid");
      }

      return var2;
   }

   @Override
   public String getModelV2ResScope(IEntity var1) throws Exception {
      if (isSimpleImportExportMode()) {
         String var2 = DataObject.getStringValue(var1, "PSDERID", null);
         if (!StringHelper.isNullOrEmpty(var2)) {
            return StringHelper.format("PSDER#%1$s", var2);
         }
      }

      return super.getModelV2ResScope(var1);
   }

   @Override
   public Object getDataContextValue(PSDEField var1, String var2, IDataContextParam var3) throws Exception {
      Object var4 = super.getDataContextValue(var1, var2, var3);
      return var4 == null && StringHelper.compare(var2, "psdefid", true) == 0 ? var1.getPSDEFieldId() : var4;
   }
}
