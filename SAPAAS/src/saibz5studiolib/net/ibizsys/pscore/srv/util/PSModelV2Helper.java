package net.ibizsys.pscore.srv.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.db.SelectFieldFilter;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDEFieldModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.IPSCoreSysService;
import net.ibizsys.pscore.srv.IPSModelV2Service;
import net.ibizsys.pscore.srv.IPSRawSelectWork;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.wfdesign.entity.PSSysWFSetting;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcRole;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersion;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflow;
import net.ibizsys.pscore.srv.wfdesign.service.PSSysWFSettingService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcRoleService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSModelV2Helper {
   private static ObjectMapper mapper = new ObjectMapper();
   private static Map<String, String> exportModelMap = new HashMap<>();
   private static HashMap<String, String> modelLogicNameMap = new HashMap<>();
   private static final Pattern codeNamePattern = Pattern.compile("[a-zA-Z_$][a-zA-Z0-9_$]*");
   private static final Log log = LogFactory.getLog(PSModelV2Helper.class);
   private SessionFactory sessionFactory = null;
   private PSSysModelInst psSysModelInst = null;
   private String strPSDSConsoleId = null;
   private String strPSSystemId = "2C40DFCD-0DF5-47BF-91A5-C45F810B0001";
   private String strPSSysModelInstId = null;
   private String strPSSystemName = "Sys";
   private static ThreadLocal<Map<String, String>> modelV2UniqueTagMap = new ThreadLocal<>();
   private static ThreadLocal<Map<String, String>> modelV2KeyMap = new ThreadLocal<>();
   private static ThreadLocal<Map<String, String>> modelV2UniqueKeyMap = new ThreadLocal<>();
   private static ThreadLocal<Map<String, Integer>> modelV2CounterMap = new ThreadLocal<>();
   private static ThreadLocal<Map<String, Integer>> modelV2CounterMap2 = new ThreadLocal<>();
   private static ThreadLocal<Map<String, String>> modelV2UniqueFileMap = new ThreadLocal<>();
   public static final String EXPORTMODELV2_INHERITDATA = "[SRFINHERIT]";
   public static final String EXPORTMODELV2_STAR = "[SRFSTAR]";
   public static final String EXPORTMODELV2_DOT = "[SRFDOT]";
   public static final String EXPORTMODELV2_LASTFILE = "SRFLASTFILE";
   private boolean bAppendMode = true;
   private IPSWorkspace iPSWorkspace;
   private static int nBatchSize = 2000;

   public void init(String var1, String var2, String var3, String var4) throws Exception {
      this.sessionFactory = PSSysModelInstGlobal.getSessionFactory(var2);
      this.psSysModelInst = PSSysModelInstGlobal.getPSSysModelInst(var2);
      this.strPSSysModelInstId = var2;
      this.strPSDSConsoleId = var4;
      if (!StringHelper.isNullOrEmpty(var1)) {
         this.strPSSystemId = var1;
      }

      if (!StringHelper.isNullOrEmpty(var3)) {
         this.strPSSystemName = var3;
      }
   }

   public void init(String var1, String var2, String var3) throws Exception {
      this.init(var1, var2, null, null);
   }

   public void init(String var1, String var2) throws Exception {
      this.init(var1, var2, null);
   }

   public String getPSSystemId() {
      return this.strPSSystemId;
   }

   public String getPSSysModelInstId() {
      return this.strPSSysModelInstId;
   }

   public IPSWorkspace getPSWorkspace() {
      return this.iPSWorkspace;
   }

   public void setPSWorkspace(IPSWorkspace var1) {
      this.iPSWorkspace = var1;
   }

   public static int getBatchSize() {
      return nBatchSize;
   }

   public static void setBatchSize(int var0) {
      if (var0 > 0 && var0 <= 2000) {
         nBatchSize = var0;
      }
   }

   public void quit() {
   }

   public int export(String var1, String var2) throws Exception {
      return this.export(var1, var2, true);
   }

   public int export(String var1, final String var2, boolean var3) throws Exception {
      if (!StringHelper.isNullOrEmpty(var1) && !StringHelper.isNullOrEmpty(var2)) {
         Map var4 = this.getExportDataMap();
         var4.remove("PSDCTASKLOG");
         var4.remove("PSSTUDIOSERVERLOG");
         var4.remove("PSBKTASKLOG");
         var4.remove("PSTASKSERVERLOG");
         var4.remove("PSDEVCENTERLOG");
         var4.remove("PSDSBOOKINGLOG");
         var4.remove("PSASBOOKINGLOG");
         var4.remove("PSDCROBOTLOG");
         var4.remove("PSSYSDBCHGLOG");
         var4.remove("PSSYSDMITEMLOG");
         var4.remove("PSSYSDEVBKTASK");
         var4.remove("PSSYSRUNSESSION");
         var4.remove("PSSYSRUNLOG");
         final ArrayList var5 = new ArrayList();
         final ArrayList var6 = new ArrayList();
         final ArrayList var7 = new ArrayList();
         ArrayList<Integer> var8 = new ArrayList<>();
         var5.addAll(var4.keySet());
         var5.remove("PSDEDQCODEEXP");
         var5.remove("PSSYSDMITEM");
         var5.remove("PSDEFDTCOL");
         var5.remove("PSDEFFORMITEM");
         var5.remove("PSDEFORMDETAIL");
         var5.remove("PSDEFIELD");
         var5.remove("PSDEVIEWCTRL");
         var5.remove("PSLANGUAGERES");
         var5.remove("PSDEFSFITEM");
         var5.remove("PSDEACTION");
         var5.remove("PSDEVIEWBASE");
         var5.remove("PSDEFINPUTTIP");
         var5.remove("PSCODEITEM");
         var5.remove("PSDEGRIDCOL");
         var5.add(0, "PSDEVIEWCTRL");
         var5.add(0, "PSLANGUAGERES");
         var5.add(0, "PSDEFSFITEM");
         var5.add(0, "PSDEACTION");
         var5.add(0, "PSDEVIEWBASE");
         var5.add(0, "PSDEFINPUTTIP");
         var5.add(0, "PSCODEITEM");
         var5.add(0, "PSDEGRIDCOL");
         var5.add(0, "PSDEDQCODEEXP");
         var5.add(0, "PSDEFFORMITEM");
         var5.add(0, "PSDEFORMDETAIL");
         var5.add(0, "PSDEFIELD");
         var5.add(0, "PSSYSDMITEM");
         var5.add(0, "PSDEFDTCOL");
         HashMap<String, String> var9 = new HashMap<>();
         var9.put("PSSYSVIEWLOGIC", "CODENAME");
         var9.put("PSSYSSAHANDLER", "CODENAME");
         var9.put("PSSYSDYNAMODEL", "CODENAME");
         var9.put("PSSYSCOUNTER", "CODENAME");
         var9.put("PSSYSPDTVIEW", "CODENAME");
         var9.put("PSSYSIMAGE", "CODENAME");
         var9.put("PSSYSCSSCAT", "CODENAME");
         var9.put("PSSYSCSS", "CODENAME");
         var9.put("PSDETOOLBAR", "CODENAME");
         var9.put("PSACHANDLER", "CODENAME");
         var9.put("PSAPPFUNC", "CODENAME");
         var9.put("PSSYSPFPLUGIN", "CODENAME");
         var9.put("PSSUBVIEWTYPE", "CODENAME");
         var9.put("PSDEUAGROUP", "CODENAME");
         var9.put("PSCTRLMSG", "CODENAME");
         var9.put("PSSYSUNIT", "CODENAME");
         var9.put("PSSYSSFPLUGIN", "CODENAME");
         var9.put("PSDEDRGROUP", "CODENAME");
         var9.put("PSDEDRITEM", "CODENAME");
         var9.put("PSLANGUAGERES", "CODENAME");
         var9.put("PSSYSWFSETTING", "CODENAME");
         var9.put("PSDEFFORMITEM", "CODENAME");
         var9.put("PSSYSEDITORSTYLE", "CODENAME");
         var9.put("PSSYSVALUERULE", "CODENAME");
         var9.put("PSAPPTITLEBAR", "CODENAME");
         var9.put("PSMOBAPPPACK", "CODENAME");
         var9.put("PSMOBAPPPACKTD", "CODENAME");
         var9.put("PSSYSVIEWPANEL", "CODENAME");
         var9.put("PSSYSDBVF", "CODENAME");
         var9.put("PSSYSDELOGICNODE", "CODENAME");
         var9.put("PSDEACTIONLOGIC", "CODENAME");
         var9.put("PSSYSMSGTEMPL", "CODENAME");
         var9.put("PSSYSDICTCAT", "CODENAME");
         var9.put("PSSYSFILE", "CODENAME");
         var9.put("PSSYSMODELGROUP", "CODENAME");
         var9.put("PSSYSSEARCHBAR", "CODENAME");
         var9.put("PSWFWORKTIME", "CODENAME");
         var9.put("PSDEACTIONTEMPL", "CODENAME");
         var9.put("PSCODELIST", "CODENAME");
         var9.put("PSDESAMPLEDATA", "CODENAME");
         var9.put("PSWXMENU", "CODENAME");
         var9.put("PSWXMENUFUNC", "CODENAME");
         var9.put("PSDEACTIONWIZARD", "CODENAME");
         var9.put("PSSYSDATASYNCAGENT", "CODENAME");
         var9.put("PSSYSTESTCASE", "CODENAME");
         var9.put("PSSYSOPPRIV", "CODENAME");
         var9.put("PSSYSDBSCHEME", "CODENAME");
         var9.put("PSDEFINPUTTIP", "CODENAME");
         var9.put("PSDEFINPUTTIPSET", "CODENAME");
         var9.put("PSSYSSAMPLEVALUE", "CODENAME");
         var9.put("PSDEDTSQUEUE", "CODENAME");
         var9.put("PSSYSUSERMODE", "CODENAME");
         var9.put("PSSYSREQITEM", "CODENAME");
         var9.put("PSSYSREQMODULE", "CODENAME");
         var9.put("PSSYSCONTENTCAT", "CODENAME");
         var9.put("PSSYSCONTENT", "CODENAME");
         var9.put("PSSYSACTOR", "CODENAME");
         var9.put("PSSYSUSERCASE", "CODENAME");
         var9.put("PSSYSUSERCASERS", "CODENAME");
         var9.put("PSSYSUCMAP", "CODENAME");
         var9.put("PSSYSTESTDATA", "CODENAME");
         var9.put("PSHELPMODULE", "CODENAME");
         var9.put("PSHELPRESOURCE", "CODENAME");
         var9.put("PSHELPARTICLE", "CODENAME");
         var9.put("PSHELPSECTION", "CODENAME");
         var9.put("PSSYSTESTMODULE", "CODENAME");
         var9.put("PSHELPPRJ", "CODENAME");
         var9.put("PSCTRLLOGICGROUP", "CODENAME");
         var9.put("PSVIEWMSG", "CODENAME");
         var9.put("PSVIEWMSGGROUP", "CODENAME");
         var9.put("PSVIEWWIZARDGROUP", "CODENAME");
         var9.put("PSSYSTASK", "CODENAME");
         var9.put("PSSYSBDSCHEME", "CODENAME");
         var9.put("PSWFLINK", "CODENAME");
         var9.put("PSAPPUTILPAGE", "CODENAME");
         final HashMap var10 = new HashMap();
         var10.put("PSWFLINK", "");
         var10.put("PSDEUAGRPDETAIL", "");
         var10.put("PSDELOGICLINK", "");
         var10.put("PSDETREENODERS", "");
         var10.put("PSDEFIUDETAIL", "");
         boolean var11 = PSCoreSysServiceBase.isEnableMergeCount();

         try {
            PSCoreSysServiceBase.setEnableMergeCount(false);
            SessionFactory var12 = PSSysModelInstGlobal.getSessionFactory(this.strPSSysModelInstId);
            if (!StringHelper.isNullOrEmpty(this.getPSSystemId())) {
               PSSysWFSetting var13 = new PSSysWFSetting();
               var13.setPSSysWFSettingId(this.getPSSystemId());
               PSSysWFSettingService var14 = (PSSysWFSettingService)ServiceGlobal.getService(PSSysWFSettingService.class, var12);
               var14.rebuildPSWFUtilActions(var13);
            }

            PSWFVersionService var43 = (PSWFVersionService)ServiceGlobal.getService(PSWFVersionService.class, var12);
            SelectCond var45 = new SelectCond();
            if (!StringHelper.isNullOrEmpty(this.getPSSystemId())) {
               var45.set("PSSYSTEMID", this.getPSSystemId());
            }

            for (PSWFVersion var17 : var43.select(var45)) {
               var43.rebuildPSDEUIActions(var17);
            }

            PSWorkflowService var49 = (PSWorkflowService)ServiceGlobal.getService(PSWorkflowService.class, var12);
            var45.reset();
            if (!StringHelper.isNullOrEmpty(this.getPSSystemId())) {
               var45.set("PSSYSTEMID", this.getPSSystemId());
            }

            for (PSWorkflow var19 : var49.select(var45)) {
               var49.rebuildPSDEUIActions(var19);
            }

            PSWFProcRoleService var54 = (PSWFProcRoleService)ServiceGlobal.getService(PSWFProcRoleService.class, var12);
            SelectCond var56 = new SelectCond();
            ArrayList<PSWFProcRole> var20 = var54.select(var56);
            HashMap<String, PSWFProcRole> var21 = new HashMap<>();
            ArrayList<PSWFProcRole> var22 = new ArrayList<>();

            for (PSWFProcRole var24 : var20) {
               String var25 = String.format("%1$s|%2$s", var24.getPSWFProcessId(), var24.getPSWFProcRoleName());
               if (var21.containsKey(var25)) {
                  var22.add(var24);
               } else {
                  var21.put(var25, var24);
               }
            }

            for (PSWFProcRole var72 : var22) {
               int var78 = 1;

               String var26;
               do {
                  var26 = String.format("%1$s|%2$s(%3$s)", var72.getPSWFProcessId(), var72.getPSWFProcRoleName(), ++var78);
               } while (var21.containsKey(var26));

               PSWFProcRole var27 = new PSWFProcRole();
               var27.setPSWFProcRoleId(var72.getPSWFProcRoleId());
               var27.setPSWFProcRoleName(String.format("%1$s(%2$s)", var72.getPSWFProcRoleName(), var78));
               var54.sysUpdate(var27, false);
               var21.put(var26, var27);
            }

            for (Entry var73 : var9.entrySet()) {
               IDataEntityModel var79 = DEModelGlobal.getDEModel((String)var73.getKey(), true);
               if (var79 != null) {
                  IDEField var82 = var79.getDEField((String)var73.getValue(), true);
                  if (var82 == null) {
                     log.warn(StringHelper.format("实体[%1$s]不存在代码名称属性[%2$s]", var73.getKey(), var73.getValue()));
                  } else {
                     boolean var84 = var79.getName().equals("PSDEFFORMITEM");
                     PSSysModelInstGlobal.active(this.strPSSysModelInstId);
                     HashMap<String, String> var28 = new HashMap<>();
                     IService<IEntity> var29 = var79.getService(var12);
                     SelectContext var30 = new SelectContext();
                     var30.addSelectField(var82.getName());
                     SelectFieldFilter var31 = new SelectFieldFilter();
                     var31.setDEFName(var82.getName());
                     var31.setCondOp("ISNOTNULL");
                     var30.setSelectFilter(var31);

                     for (IEntity var34 : var29.select(var30)) {
                        String var35 = DataObject.getStringValue(var34.get(var82.getName()));
                        var28.put(var35.toUpperCase(), "");
                     }

                     var30.reset();
                     var30.addSelectField(var29.getDEModel().getKeyDEField().getName());
                     if (var84) {
                        var30.addSelectField("FTMODE");
                     }

                     var31.setCondOp("ISNULL");
                     var30.setSelectFilter(var31);
                     ArrayList<IEntity> var85 = var29.select(var30);
                     int var86 = 0;
                     String var87 = var29.getDEModel().getKeyDEField().getName();

                     for (IEntity var36 : var85) {
                        String var37 = DataObject.getStringValue(var36.get(var87));
                        if (var84) {
                           String var38 = DataObject.getStringValue(var36.get("FTMODE"));
                           if ("DEFAULT".equals(var38)) {
                              IEntity var93 = var29.getDEModel().createEntity();
                              var93.set(var87, var37);
                              var93.set("CODENAME", "Default");
                              EntityBase.setIgnoreCheck(var93, true);
                              var29.sysUpdate(var93, false);
                              continue;
                           }

                           if ("MOBILEDEFAULT".equals(var38)) {
                              IEntity var92 = var29.getDEModel().createEntity();
                              var92.set(var87, var37);
                              var92.set("CODENAME", "MobileDefault");
                              EntityBase.setIgnoreCheck(var92, true);
                              var29.sysUpdate(var92, false);
                              continue;
                           }
                        }

                        String var89 = StringHelper.format("A%1$s", KeyValueHelper.genUniqueId(var37).substring(0, 18));
                        if (!var28.containsKey(var89.toUpperCase())) {
                           IEntity var91 = var29.getDEModel().createEntity();
                           var91.set(var87, var37);
                           var91.set(var82.getName(), var89);
                           EntityBase.setIgnoreCheck(var91, true);
                           var29.sysUpdate(var91, false);
                           var28.put(var89.toUpperCase(), "");
                        } else {
                           do {
                              var89 = StringHelper.format("Auto%1$s", ++var86);
                           } while (var28.containsKey(var89.toUpperCase()));

                           IEntity var39 = var29.getDEModel().createEntity();
                           var39.set(var87, var37);
                           var39.set(var82.getName(), var89);
                           EntityBase.setIgnoreCheck(var39, true);
                           var29.sysUpdate(var39, false);
                           var28.put(var89.toUpperCase(), "");
                        }
                     }
                  }
               }
            }

            PSCoreSysServiceBase.setEnableMergeCount(var11);
         } catch (Exception var41) {
            PSCoreSysServiceBase.setEnableMergeCount(var11);
            throw var41;
         }

         PSSystemService var42 = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, this.sessionFactory);
         PSSystem var44 = new PSSystem();
         var44.setPSSystemId(this.strPSSystemId);
         if (!var42.get(var44, true)) {
            ArrayList var46 = var42.select(new SelectCond());
            if (var46.size() > 0) {
               var44 = (PSSystem)var46.get(0);
            }
         }

         int var47 = DataObject.getIntegerValue(var44.getModelV2ExpMode(), 0);
         final boolean var48 = (1 & var47) == 1;
         final ConcurrentHashMap<String, String> var50 = new ConcurrentHashMap<>();
         this.sendStudioConsole(null, "DEBUG", "[开始执行] 提取模型数据");
         long var52 = System.currentTimeMillis();
         final int var57 = var5.size();
         final String var59 = this.strPSSysModelInstId;
         ExecutorService var61 = Executors.newCachedThreadPool();

         for (int var64 = 0; var64 < 8; var64++) {
            var61.execute(
               new Runnable() {
                  @Override
                  public void run() {
                     String var1x = null;

                     try {
                        SessionFactory var2x = PSSysModelInstGlobal.getSessionFactory(var59);

                        while (var7.size() == 0) {
                           var1x = null;
                           synchronized (var5) {
                              if (var5.size() > 0) {
                                 var1x = (String)var5.remove(0);
                              }
                           }

                           if (StringHelper.isNullOrEmpty(var1x)) {
                              break;
                           }

                           PSSysModelInstGlobal.active(var59);
                           IDataEntityModel var17 = DEModelGlobal.getDEModel(var1x, true);
                           if (var17 != null) {
                              IService var18 = var17.getService(var2x);
                              if (var18 instanceof IPSModelV2Service) {
                                 ArrayList var5x = new ArrayList();
                                 if (!var48) {
                                    var5x.add("CREATEMAN");
                                    var5x.add("UPDATEDATE");
                                    var5x.add("UPDATEMAN");
                                 }

                                 Iterator var6x = var17.getDEFields();
                                 if (var6x != null) {
                                    while (var6x.hasNext()) {
                                       IDEFieldModel var7x = (IDEFieldModel)var6x.next();
                                       if (!StringHelper.isNullOrEmpty(var7x.getUserTag())
                                          && StringHelper.compare("IGNOREMODELV2", var7x.getUserTag(), true) == 0) {
                                          var5x.add(var7x.getName());
                                       }
                                    }
                                 }

                                 IPSModelV2Service var19 = (IPSModelV2Service)var18;
                                 String var8x = StringHelper.format("select * from %1$s ", var17.getTableName());
                                 if ((var17.getInheritDEModel() != null || var10.containsKey(var17.getName()))
                                    && !StringHelper.isNullOrEmpty(var17.getViewName())) {
                                    var8x = StringHelper.format("select * from %1$s ", var17.getViewName());
                                 }

                                 ((IPSCoreSysService)var18).selectRaw(var8x, null, PSModelV2Helper.this.new ExportHelper(var2, var19, var50, var5x));
                                 synchronized (var6) {
                                    var6.add(var1x);
                                    String var10x = StringHelper.format("提取[%1$s]，当前已完成 %2$s/%3$s", var1x, var6.size(), var57);
                                    PSModelV2Helper.log.debug(var10x);
                                    PSModelV2Helper.this.sendStudioConsole(null, "INFO", var10x);
                                 }
                              }
                           }
                        }
                     } catch (Exception var14) {
                        if (StringHelper.isNullOrEmpty(var1x)) {
                           var1x = "未知模型";
                        }

                        String var3x = StringHelper.format("[%1$s] %2$s", var1x, var14.getMessage());
                        var7.add(var3x);
                        StringBuilderEx var4x = new StringBuilderEx();
                        var14.printStackTrace(new PrintWriter(var4x.getWriter()));
                        var3x = StringHelper.format("提取[%1$s]发生异常，%2$s", var1x, var4x.toString());
                        PSModelV2Helper.this.sendStudioConsole(null, "ERROR", var3x);
                        PSModelV2Helper.log.error(var14);
                     }
                  }
               }
            );
         }

         long var65 = 0L;

         while (var6.size() != var57 && var7.size() == 0) {
            Thread.sleep(50L);
            if (System.currentTimeMillis() - var65 >= 10000L) {
               PSSysModelInstGlobal.active(this.getPSSysModelInstId());
               var65 = System.currentTimeMillis();
            }
         }

         var61.shutdown();
         if (var7.size() > 0) {
            throw new Exception("提取发生错误");
         }

         int var74 = 0;

         for (int var83 : var8) {
            var74 += var83;
         }

         String var81 = StringHelper.format("[结束执行] 提取模型数据，耗时[%1$s]ms", System.currentTimeMillis() - var52);
         log.debug(var81);
         this.sendStudioConsole(null, "INFO", var81);
         ConcurrentHashMap<String, String> var53 = new ConcurrentHashMap<>();
         boolean var55 = PSCoreSysServiceBase.isSimpleImportExportMode();

         try {
            this.sendStudioConsole(null, "DEBUG", "[开始执行] 导出模型文件");
            long var58 = System.currentTimeMillis();
            ArrayList<String> var63 = new ArrayList<>();
            if (!var48) {
               var63.add("CREATEMAN");
               var63.add("UPDATEDATE");
               var63.add("UPDATEMAN");
            }

            Iterator var66 = var42.getDEModel().getDEFields();
            if (var66 != null) {
               while (var66.hasNext()) {
                  IDEFieldModel var69 = (IDEFieldModel)var66.next();
                  if (!StringHelper.isNullOrEmpty(var69.getUserTag()) && StringHelper.compare("IGNOREMODELV2", var69.getUserTag(), true) == 0) {
                     var63.add(var69.getName());
                  }
               }
            }

            for (String var75 : var63) {
               var44.remove(var75);
            }

            setUniqueFileMap(var53);
            setUniqueTagMap(var50);
            PSCoreSysServiceBase.setSimpleImportExportMode(false);
            var42.exportModelV2(var44, var1, var2);
            PSCoreSysServiceBase.setSimpleImportExportMode(var55);
            setUniqueTagMap(null);
            setUniqueFileMap(null);
            var50.clear();
            var53.clear();
            int var71 = -1;
            if (var3) {
               var71 = this.compile(var1 + "2", var1, true);
            }

            String var77;
            if (var71 == -1) {
               var77 = StringHelper.format("[结束执行] 导出模型文件，耗时[%1$s]ms", System.currentTimeMillis() - var58);
            } else {
               var77 = StringHelper.format("[结束执行] 导出模型文件，模型项总计[%2$s]，耗时[%1$s]ms", System.currentTimeMillis() - var58, var71);
            }

            log.debug(var77);
            this.sendStudioConsole(null, "INFO", var77);
            return var71;
         } catch (Exception var40) {
            PSCoreSysServiceBase.setSimpleImportExportMode(var55);
            StringBuilderEx var60 = new StringBuilderEx();
            var40.printStackTrace(new PrintWriter(var60.getWriter()));
            String var62 = StringHelper.format("导出模型发生异常，%1$s", var60.toString());
            this.sendStudioConsole(null, "ERROR", var62);
            setUniqueTagMap(null);
            setUniqueFileMap(null);
            throw var40;
         }
      } else {
         throw new Exception("没有指定导出目录");
      }
   }

   public int compile(String var1, String var2, boolean var3) throws Exception {
      if (!StringHelper.isNullOrEmpty(var1) && !StringHelper.isNullOrEmpty(var2)) {
         PSSystemService var4 = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, this.sessionFactory);
         PSSystem var5 = new PSSystem();
         var5.setSessionFactory(this.sessionFactory);
         var5.setPSSystemId(this.strPSSystemId);
         if (!StringHelper.isNullOrEmpty(this.strPSSystemName)) {
            var5.setPSSystemName(this.strPSSystemName);
         }

         ConcurrentHashMap<String, String> var6 = new ConcurrentHashMap<>();
         ConcurrentHashMap<String, Integer> var7 = new ConcurrentHashMap<>();
         ConcurrentHashMap<String, String> var8 = new ConcurrentHashMap<>();
         boolean var9 = PSCoreSysServiceBase.isSimpleImportExportMode();

         try {
            this.sendStudioConsole(null, "DEBUG", "[开始执行] 编译模型文件");
            PSCoreSysServiceBase.beginImpSysModel(var5);
            setKeyMap(var6);
            setUniqueKeyMap(var8);
            if (var3) {
               setCounterMap(var7);
               setCounterMap2(null);
            } else {
               setCounterMap(null);
               setCounterMap2(var7);
            }

            PSCoreSysServiceBase.setSimpleImportExportMode(false);
            var4.compileModelV2(var5, null, var1, var2, 1);
            var4.compileModelV2(var5, null, var1, var2, 2);
            PSCoreSysServiceBase.setSimpleImportExportMode(var9);
            var6.clear();
            setCounterMap(null);
            setCounterMap2(null);
            setKeyMap(null);
            setUniqueKeyMap(null);
            PSCoreSysServiceBase.endImpSysModel(true);
            this.sendStudioConsole(null, "INFO", "[结束执行] 编译模型文件");
         } catch (Exception var20) {
            PSCoreSysServiceBase.setSimpleImportExportMode(var9);
            StringBuilderEx var11 = new StringBuilderEx();
            var20.printStackTrace(new PrintWriter(var11.getWriter()));
            String var12 = StringHelper.format("编译模型文件发生异常，%1$s", var11.toString());
            this.sendStudioConsole(null, "ERROR", var12);
            String var13 = (String)var6.get("SRFLASTFILE");
            var6.clear();
            setCounterMap(null);
            setCounterMap2(null);
            setKeyMap(null);
            setUniqueKeyMap(null);
            PSCoreSysServiceBase.endImpSysModel(true);
            if (StringHelper.isNullOrEmpty(var13)) {
               throw var20;
            }

            File var14 = new File(var13);
            String var15 = var14.getCanonicalPath().replace(new File(var2).getCanonicalPath(), "");
            var15 = var15.replace("\\", "/");
            throw new Exception(StringHelper.format("%1$s，文件(%2$s)", var20.getMessage(), var15), var20);
         }

         int var10 = 0;
         if (var3) {
            Map<String, String> var21 = this.getExportDataMap();
            var21.remove("PSDCTASKLOG");
            var21.remove("PSSTUDIOSERVERLOG");
            var21.remove("PSBKTASKLOG");
            var21.remove("PSTASKSERVERLOG");
            var21.remove("PSDEVCENTERLOG");
            var21.remove("PSDSBOOKINGLOG");
            var21.remove("PSASBOOKINGLOG");
            var21.remove("PSDCROBOTLOG");
            var21.remove("PSSYSDBCHGLOG");
            var21.remove("PSSYSDMITEMLOG");
            var21.remove("PSSYSDEVBKTASK");
            var21.remove("PSSYSRUNSESSION");
            var21.remove("PSSYSRUNLOG");
            int var25 = 0;

            for (Entry var32 : var7.entrySet()) {
               int var36 = 0;
               if (var32.getValue() != null) {
                  var36 = (Integer)var32.getValue();
               }

               ArrayList<IEntity> var16 = var4.selectRaw(StringHelper.format("SELECT COUNT(1) AS CNT FROM T_SRF%1$s", var32.getKey()), null);
               int var17 = DataObject.getIntegerValue(var16.get(0).get("CNT"), -1);
               if (var17 != var36) {
                  log.warn(StringHelper.format("模型[%1$s]计数[%2$s][%3$s]不一致", var32.getKey(), var17, var36));
               }

               var25 += var17;
               var10 += var36;
               var21.remove(var32.getKey());
            }

            log.debug(StringHelper.format("查询合计[%1$s]模型合计[%2$s]", var25, var10));

            for (String var33 : var21.keySet()) {
               ArrayList<IEntity> var37 = var4.selectRaw(StringHelper.format("SELECT COUNT(1) AS CNT FROM T_SRF%1$s", var33), null);
               if (DataObject.getIntegerValue(var37.get(0).get("CNT"), -1) != 0) {
                  log.warn(StringHelper.format("模型[%1$s]计数不为0", var33));
               }
            }
         } else {
            for (Entry var26 : var7.entrySet()) {
               int var30 = 0;
               if (var26.getValue() != null) {
                  var30 = (Integer)var26.getValue();
               }

               var10 += var30;
            }

            if (this.getPSWorkspace() != null) {
               int var23 = this.getPSWorkspace().getTotalPSModelLimit();
               if (var23 != -1 && var10 > var23) {
                  throw new Exception(StringHelper.format("导入模型项数量[%1$s]超出生产线限制[%2$s]，无法导入", var10, var23));
               }

               var23 = this.getPSWorkspace().getPSModelLimit("PSDATAENTITY");
               if (var23 != -1) {
                  List<IEntity> var27 = this.getPSModel(var1 + File.separator + "DATAS", "PSDATAENTITY");
                  if (var27 != null && var27.size() > 0) {
                     HashMap var31 = null;
                     Iterator var34 = this.getPSWorkspace().getEntities();
                     if (var34 != null) {
                        var31 = new HashMap();

                        while (var34.hasNext()) {
                           var31.put(var34.next(), "");
                        }
                     }

                     int var38 = 0;

                     for (IEntity var40 : var27) {
                        PSDataEntity var18 = (PSDataEntity)var40;
                        if (DataObject.getIntegerValue(var18.getValidFlag(), 1) == 1) {
                           if (var31 != null && !StringHelper.isNullOrEmpty(var18.getPSDataEntityName())) {
                              String var19 = (String)var31.remove(var18.getPSDataEntityName().toUpperCase());
                              if (!StringHelper.isNullOrEmpty(var19)) {
                                 continue;
                              }
                           }

                           var38++;
                        }
                     }

                     if (var38 > var23) {
                        throw new Exception(StringHelper.format("导入模型[PSDATAENTITY|实体]数量[%1$s]超出生产线限制[%2$s]，无法导入", var38, var23));
                     }
                  }
               }
            }
         }

         log.debug(StringHelper.format("编译模型项数量[%1$s]", var10));
         return var10;
      } else {
         throw new Exception("没有指定导出目录");
      }
   }

   protected List<IEntity> getPSModel(String var1, String var2) throws Exception {
      ArrayList<IEntity> var3 = new ArrayList<>();
      File var4 = new File(var1 + File.separator + var2 + File.separator + "ALL.txt");
      if (!var4.exists()) {
         return var3;
      }

      IDataEntityModel var5 = DEModelGlobal.getDEModel(var2, true);
      IService var6 = var5.getService(this.sessionFactory);

      for (String var9 : readFile2(var4)) {
         if (!StringHelper.isNullOrEmpty(var9)) {
            ObjectNode var10 = (ObjectNode)JsonNodeHelper.fromString(var9);
            IEntity var11 = var5.createEntity();
            fromJSONObject(var11, var10, true);
            var3.add(var11);
         }
      }

      return var3;
   }

   public void import2(final String var1) throws Exception {
      if (StringHelper.isNullOrEmpty(var1)) {
         throw new Exception("没有指定导入目录");
      }

      long var2 = System.currentTimeMillis();
      Map var4 = this.getExportDataMap();
      var4.put("PSSYSTEM", "T_SRFPSSYSTEM");
      var4.remove("PSDCTASKLOG");
      var4.remove("PSSTUDIOSERVERLOG");
      var4.remove("PSBKTASKLOG");
      var4.remove("PSTASKSERVERLOG");
      var4.remove("PSDEVCENTERLOG");
      var4.remove("PSDSBOOKINGLOG");
      var4.remove("PSASBOOKINGLOG");
      var4.remove("PSDCROBOTLOG");
      var4.remove("PSSYSDBCHGLOG");
      var4.remove("PSSYSDMITEMLOG");
      var4.remove("PSSYSDEVBKTASK");
      var4.remove("PSSYSRUNSESSION");
      var4.remove("PSSYSRUNLOG");
      final ArrayList var5 = new ArrayList();
      final ArrayList var6 = new ArrayList();
      final ArrayList<String> var7 = new ArrayList<>();
      final ArrayList<Integer> var8 = new ArrayList<>();
      var5.addAll(var4.keySet());
      var5.remove("PSDEDQCODEEXP");
      var5.remove("PSSYSDMITEM");
      var5.remove("PSDEFDTCOL");
      var5.remove("PSDEFFORMITEM");
      var5.remove("PSDEFORMDETAIL");
      var5.remove("PSDEFIELD");
      var5.remove("PSDEVIEWCTRL");
      var5.remove("PSLANGUAGERES");
      var5.remove("PSDEFSFITEM");
      var5.remove("PSDEACTION");
      var5.remove("PSDEVIEWBASE");
      var5.remove("PSDEFINPUTTIP");
      var5.remove("PSCODEITEM");
      var5.remove("PSDEGRIDCOL");
      var5.add(0, "PSDEVIEWCTRL");
      var5.add(0, "PSLANGUAGERES");
      var5.add(0, "PSDEFSFITEM");
      var5.add(0, "PSDEACTION");
      var5.add(0, "PSDEVIEWBASE");
      var5.add(0, "PSDEFINPUTTIP");
      var5.add(0, "PSCODEITEM");
      var5.add(0, "PSDEGRIDCOL");
      var5.add(0, "PSDEDQCODEEXP");
      var5.add(0, "PSDEFFORMITEM");
      var5.add(0, "PSDEFORMDETAIL");
      var5.add(0, "PSDEFIELD");
      var5.add(0, "PSSYSDMITEM");
      var5.add(0, "PSDEFDTCOL");
      final Timestamp var9 = new Timestamp(System.currentTimeMillis());
      final ConcurrentHashMap<String, Integer> var10 = new ConcurrentHashMap<>();
      var10.put("DBVER", 1);
      var10.put("DBVERSION", 1);
      var10.put("MODELVER", 1);
      this.sendStudioConsole(null, "DEBUG", "[开始执行] 导入模型文件");
      final int var11 = var5.size();
      ExecutorService var12 = Executors.newCachedThreadPool();

      for (int var13 = 0; var13 < 8; var13++) {
         var12.execute(new Runnable() {
            @Override
            public void run() {
               String var1x = null;

               try {
                  SessionFactory var2x = PSSysModelInstGlobal.getSessionFactory(PSModelV2Helper.this.getPSSysModelInstId());

                  while (var7.size() == 0) {
                     var1x = null;
                     synchronized (var5) {
                        if (var5.size() > 0) {
                           var1x = (String)var5.remove(0);
                        }
                     }

                     if (StringHelper.isNullOrEmpty(var1x)) {
                        break;
                     }

                     IDataEntityModel var30 = DEModelGlobal.getDEModel(var1x, true);
                     if (var30 == null) {
                        synchronized (var6) {
                           var6.add(var1x);
                           String var34 = StringHelper.format("导入[%1$s]，当前已完成 %2$s/%3$s", var1x, var6.size(), var11);
                           PSModelV2Helper.log.debug(var34);
                           PSModelV2Helper.this.sendStudioConsole(null, "INFO", var34);
                        }
                     } else {
                        File var31 = new File(var1 + File.separator + var1x + File.separator + "ALL.txt");
                        if (!var31.exists()) {
                           synchronized (var6) {
                              var6.add(var1x);
                              String var35 = StringHelper.format("导入[%1$s]，当前已完成 %2$s/%3$s", var1x, var6.size(), var11);
                              PSModelV2Helper.log.debug(var35);
                              PSModelV2Helper.this.sendStudioConsole(null, "INFO", var35);
                           }
                        } else {
                           IService var5x = var30.getService(var2x);
                           ArrayList<IEntity> var6x = new ArrayList<>();

                           for (String var9x : PSModelV2Helper.readFile2(var31)) {
                              if (!StringHelper.isNullOrEmpty(var9x)) {
                                 ObjectNode var10x = (ObjectNode)JsonNodeHelper.fromString(var9x);
                                 IEntity var11x = var30.createEntity();
                                 PSModelV2Helper.fromJSONObject(var11x, var10x, true);
                                 Timestamp var12x = DataObject.getTimestampValue(var11x, "CREATEDATE", null);
                                 if (var12x == null) {
                                    var11x.set("CREATEDATE", var9);
                                 }

                                 Timestamp var13x = DataObject.getTimestampValue(var11x, "UPDATEDATE", null);
                                 if (var13x == null) {
                                    var11x.set("UPDATEDATE", var9);
                                 }

                                 String var14 = DataObject.getStringValue(var11x, "CREATEMAN", null);
                                 if (StringHelper.isNullOrEmpty(var14)) {
                                    var11x.set("CREATEMAN", "SYSTEM");
                                 }

                                 String var15 = DataObject.getStringValue(var11x, "UPDATEMAN", null);
                                 if (StringHelper.isNullOrEmpty(var15)) {
                                    var11x.set("UPDATEMAN", "SYSTEM");
                                 }

                                 var11x.set("ENABLE", 1);

                                 for (Entry var17 : var10.entrySet()) {
                                    IDEField var18 = var30.getDEField((String)var17.getKey(), true);
                                    if (var18 != null) {
                                       Object var19 = var11x.get(var18.getName());
                                       if (var19 == null) {
                                          var11x.set(var18.getName(), var17.getValue());
                                       }
                                    }
                                 }

                                 var6x.add(var11x);
                              }
                           }

                           PSSysModelInstGlobal.active(PSModelV2Helper.this.getPSSysModelInstId());
                           ((IPSCoreSysService)var5x).executeBatchCreate(var6x, PSModelV2Helper.getBatchSize());
                           synchronized (var8) {
                              var8.add(var6x.size());
                           }

                           var6x.clear();
                           synchronized (var6) {
                              var6.add(var1x);
                              String var38 = StringHelper.format("导入[%1$s]，当前已完成 %2$s/%3$s", var1x, var6.size(), var11);
                              PSModelV2Helper.log.debug(var38);
                              PSModelV2Helper.this.sendStudioConsole(null, "INFO", var38);
                           }
                        }
                     }
                  }
               } catch (Exception var27) {
                  PSModelV2Helper.log.error(var27);
                  if (StringHelper.isNullOrEmpty(var1x)) {
                     var1x = "未知模型";
                  }

                  String var3 = StringHelper.format("[%1$s] %2$s", var1x, var27.getMessage());
                  if (var27.getCause() != null) {
                     var3 = var3 + String.format("\r\n%1$s", var27.getCause().getMessage());
                  }

                  var7.add(var3);
                  StringBuilderEx var4x = new StringBuilderEx();
                  var27.printStackTrace(new PrintWriter(var4x.getWriter()));
                  var3 = StringHelper.format("导入[%1$s]发生异常，%2$s", var1x, var4x.toString());
                  PSModelV2Helper.this.sendStudioConsole(null, "ERROR", var3);
               }
            }
         });
      }

      long var19 = 0L;

      while (var6.size() != var11 && var7.size() == 0) {
         Thread.sleep(50L);
         if (System.currentTimeMillis() - var19 >= 10000L) {
            PSSysModelInstGlobal.active(this.getPSSysModelInstId());
            var19 = System.currentTimeMillis();
         }
      }

      var12.shutdown();
      if (var7.size() > 0) {
         StringBuilderEx var20 = new StringBuilderEx();
         var20.append("导入模型发生错误：");
         boolean var22 = true;

         for (String var18 : var7) {
            if (var22) {
               var22 = false;
            } else {
               var20.append("\r\n");
            }

            var20.append(var18);
         }

         throw new Exception(var20.toString());
      } else {
         int var15 = 0;

         for (int var17 : var8) {
            var15 += var17;
         }

         String var21 = StringHelper.format("[结束执行] 导入模型文件，模型项总计[%1$s]，耗时[%2$s]ms", var15, System.currentTimeMillis() - var2);
         log.debug(var21);
         this.sendStudioConsole(null, "INFO", var21);
      }
   }

   protected Map<String, String> getExportDataMap() throws Exception {
      String var1 = StringHelper.format(
         "select `TABLE_NAME`,`TABLE_ROWS` as `ROWCNT` from INFORMATION_SCHEMA.TABLES where TABLE_TYPE ='BASE TABLE' AND UPPER(TABLE_SCHEMA)='%1$s' ",
         this.psSysModelInst.getDBName().toUpperCase()
      );
      HashMap var2 = new HashMap();
      var2.putAll(exportModelMap);
      return var2;
   }

   public static void writeFile(String var0, String var1) throws Exception {
      writeFile(var0, var1, false);
   }

   public static void writeFile(String var0, String var1, boolean var2) throws Exception {
      File var3 = new File(var0);
      if (var3.exists()) {
         log.error(StringHelper.format("导出模型文件[%1$s]已经存在", var0));
         if (var2) {
            throw new Exception("目标文件已存在");
         }
      } else {
         OutputStreamWriter var4 = new OutputStreamWriter(new FileOutputStream(var3), "UTF-8");
         BufferedWriter var5 = new BufferedWriter(var4);
         var5.write(var1);
         var5.flush();
         var5.close();
      }
   }

   public static void appendFile(String var0, String var1) throws Exception {
      File var2 = new File(var0);
      OutputStreamWriter var3 = new OutputStreamWriter(new FileOutputStream(var2, true), "UTF-8");
      BufferedWriter var4 = new BufferedWriter(var3);
      var4.write(var1);
      var4.flush();
      var4.close();
   }

   public static String getModelV2TagFolderName(String var0) {
      if (var0.indexOf("*") != -1) {
         var0 = var0.replace("*", "[SRFSTAR]");
      }

      if (var0.indexOf("/") != -1) {
         var0 = var0.replace("/", "-1-");
      }

      if (var0.indexOf("\\") != -1) {
         var0 = var0.replace("\\", "-2-");
      }

      if (var0.indexOf("?") != -1) {
         var0 = var0.replace("?", "-3-");
      }

      if (var0.indexOf(":") != -1) {
         var0 = var0.replace(":", "-4-");
      }

      if (var0.indexOf("\"") != -1) {
         var0 = var0.replace("\"", "-5-");
      }

      if (var0.indexOf("<") != -1) {
         var0 = var0.replace("<", "-6-");
      }

      if (var0.indexOf(">") != -1) {
         var0 = var0.replace(">", "-7-");
      }

      if (var0.indexOf("|") != -1) {
         var0 = var0.replace("|", "-8-");
      }

      return var0;
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

   public static ArrayList<String> readFile2(File var0) throws Exception {
      ArrayList var1 = new ArrayList();
      FileInputStream var2 = null;
      InputStreamReader var3 = null;
      BufferedReader var4 = null;

      try {
         var2 = new FileInputStream(var0);
         var3 = new InputStreamReader(var2, "UTF-8");
         var4 = new BufferedReader(var3);
         String var5 = "";
         String var6 = "";

         while ((var5 = var4.readLine()) != null) {
            if (var5.length() == 0) {
               if (var6.length() != 0) {
                  var1.add(var6);
                  var6 = "";
               }
            } else {
               if (var6.length() != 0) {
                  var6 = var6 + "\n";
               }

               var6 = var6 + var5;
            }
         }

         if (var6.length() != 0) {
            var1.add(var6);
            var6 = "";
         }
      } catch (FileNotFoundException var27) {
         var27.printStackTrace();
      } catch (IOException var28) {
         var28.printStackTrace();
      } finally {
         if (var4 != null) {
            try {
               var4.close();
            } catch (IOException var26) {
               var26.printStackTrace();
            }
         }

         if (var3 != null) {
            try {
               var3.close();
            } catch (IOException var25) {
               var25.printStackTrace();
            }
         }

         if (var2 != null) {
            try {
               var2.close();
            } catch (IOException var24) {
               var24.printStackTrace();
            }
         }
      }

      return var1;
   }

   protected boolean isAppendMode() {
      return this.bAppendMode;
   }

   public static void setUniqueTagMap(Map<String, String> var0) {
      modelV2UniqueTagMap.set(var0);
   }

   public static Map<String, String> getUniqueTagMap() {
      return modelV2UniqueTagMap.get();
   }

   public static void setKeyMap(Map<String, String> var0) {
      modelV2KeyMap.set(var0);
   }

   public static Map<String, String> getKeyMap() {
      return modelV2KeyMap.get();
   }

   public static void setUniqueKeyMap(Map<String, String> var0) {
      modelV2UniqueKeyMap.set(var0);
   }

   public static Map<String, String> getUniqueKeyMap() {
      return modelV2UniqueKeyMap.get();
   }

   public static void setCounterMap(Map<String, Integer> var0) {
      modelV2CounterMap.set(var0);
   }

   public static Map<String, Integer> getCounterMap() {
      return modelV2CounterMap.get();
   }

   public static void setCounterMap2(Map<String, Integer> var0) {
      modelV2CounterMap2.set(var0);
   }

   public static Map<String, Integer> getCounterMap2() {
      return modelV2CounterMap2.get();
   }

   public static void setUniqueFileMap(Map<String, String> var0) {
      modelV2UniqueFileMap.set(var0);
   }

   public static Map<String, String> getUniqueFileMap() {
      return modelV2UniqueFileMap.get();
   }

   public void backup(final String var1) throws Exception {
      if (StringHelper.isNullOrEmpty(var1)) {
         throw new Exception("没有指定导出目录");
      }

      Map var2 = this.getBackupDataMap();
      final ArrayList var3 = new ArrayList();
      final ArrayList var4 = new ArrayList();
      final ArrayList var5 = new ArrayList();
      ArrayList<Integer> var6 = new ArrayList<>();
      var3.addAll(var2.keySet());
      var3.remove("PSDEDQCODEEXP");
      var3.remove("PSSYSDMITEM");
      var3.remove("PSDEFDTCOL");
      var3.remove("PSDEFFORMITEM");
      var3.remove("PSDEFORMDETAIL");
      var3.remove("PSDEFIELD");
      var3.remove("PSDEVIEWCTRL");
      var3.remove("PSLANGUAGERES");
      var3.remove("PSDEFSFITEM");
      var3.remove("PSDEACTION");
      var3.remove("PSDEVIEWBASE");
      var3.remove("PSDEFINPUTTIP");
      var3.remove("PSCODEITEM");
      var3.remove("PSDEGRIDCOL");
      var3.add(0, "PSDEVIEWCTRL");
      var3.add(0, "PSLANGUAGERES");
      var3.add(0, "PSDEFSFITEM");
      var3.add(0, "PSDEACTION");
      var3.add(0, "PSDEVIEWBASE");
      var3.add(0, "PSDEFINPUTTIP");
      var3.add(0, "PSCODEITEM");
      var3.add(0, "PSDEGRIDCOL");
      var3.add(0, "PSDEDQCODEEXP");
      var3.add(0, "PSDEFFORMITEM");
      var3.add(0, "PSDEFORMDETAIL");
      var3.add(0, "PSDEFIELD");
      var3.add(0, "PSSYSDMITEM");
      var3.add(0, "PSDEFDTCOL");
      SessionFactory var7 = PSSysModelInstGlobal.getSessionFactory(this.strPSSysModelInstId);
      final PSSystemService var8 = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, var7);
      long var9 = System.currentTimeMillis();
      final int var11 = var3.size();
      final String var12 = this.strPSSysModelInstId;
      ExecutorService var13 = Executors.newCachedThreadPool();

      for (int var14 = 0; var14 < 8; var14++) {
         var13.execute(new Runnable() {
            @Override
            public void run() {
               try {
                  SessionFactory var1x = PSSysModelInstGlobal.getSessionFactory(var12);

                  while (true) {
                     String var2x = null;
                     synchronized (var3) {
                        if (var3.size() > 0) {
                           var2x = (String)var3.remove(0);
                        }
                     }

                     if (StringHelper.isNullOrEmpty(var2x)) {
                        break;
                     }

                     PSSysModelInstGlobal.active(var12);
                     IDataEntityModel var13x = DEModelGlobal.getDEModel(var2x, true);
                     if (var13x == null) {
                        synchronized (var4) {
                           var4.add(var2x);
                           PSModelV2Helper.log.debug(StringHelper.format("忽略导出[%1$s]，实体对象不存在，当前已完成 %2$s/%3$s", var2x, var4.size(), var11));
                        }
                     } else {
                        IService var14x = var13x.getService(var1x);
                        if (var14x.getSessionFactory() != var1x) {
                           synchronized (var4) {
                              var4.add(var2x);
                              PSModelV2Helper.log.debug(StringHelper.format("忽略导出[%1$s]，数据源不一致，当前已完成 %2$s/%3$s", var2x, var4.size(), var11));
                           }
                        } else {
                           String var15 = StringHelper.format("select * from %1$s ", var13x.getTableName());
                           if (var13x.getInheritDEModel() != null && !StringHelper.isNullOrEmpty(var13x.getViewName())) {
                              var15 = StringHelper.format("select * from %1$s ", var13x.getViewName());
                           }

                           if (var14x instanceof IPSCoreSysService) {
                              ((IPSCoreSysService)var14x).selectRaw(var15, null, PSModelV2Helper.this.new BackupHelper(var1, var14x, var13x));
                           } else {
                              var8.selectRaw(var15, null, PSModelV2Helper.this.new BackupHelper(var1, var8, var13x));
                           }

                           synchronized (var4) {
                              var4.add(var2x);
                              PSModelV2Helper.log.debug(StringHelper.format("导出[%1$s]，当前已完成 %2$s/%3$s", var2x, var4.size(), var11));
                           }
                        }
                     }
                  }
               } catch (Exception var12x) {
                  PSModelV2Helper.log.error(var12x);
                  var5.add(var12x.getMessage());
               }
            }
         });
      }

      while (var4.size() != var11 && var5.size() == 0) {
         Thread.sleep(50L);
      }

      var13.shutdown();
      if (var5.size() > 0) {
         throw new Exception("导出发生错误");
      }

      int var17 = 0;

      for (int var16 : var6) {
         var17 += var16;
      }

      log.debug(StringHelper.format("导出记录数[%1$s]，耗时[%2$s]", var17, System.currentTimeMillis() - var9));
   }

   public void restore(final String var1) throws Exception {
      if (StringHelper.isNullOrEmpty(var1)) {
         throw new Exception("没有指定导入目录");
      }

      long var2 = System.currentTimeMillis();
      Map var4 = this.getBackupDataMap();
      final ArrayList var5 = new ArrayList();
      final ArrayList var6 = new ArrayList();
      final ArrayList<String> var7 = new ArrayList<>();
      final ArrayList<Integer> var8 = new ArrayList<>();
      var5.addAll(var4.keySet());
      var5.remove("PSDEDQCODEEXP");
      var5.remove("PSSYSDMITEM");
      var5.remove("PSDEFDTCOL");
      var5.remove("PSDEFFORMITEM");
      var5.remove("PSDEFORMDETAIL");
      var5.remove("PSDEFIELD");
      var5.remove("PSDEVIEWCTRL");
      var5.remove("PSLANGUAGERES");
      var5.remove("PSDEFSFITEM");
      var5.remove("PSDEACTION");
      var5.remove("PSDEVIEWBASE");
      var5.remove("PSDEFINPUTTIP");
      var5.remove("PSCODEITEM");
      var5.remove("PSDEGRIDCOL");
      var5.add(0, "PSDEVIEWCTRL");
      var5.add(0, "PSLANGUAGERES");
      var5.add(0, "PSDEFSFITEM");
      var5.add(0, "PSDEACTION");
      var5.add(0, "PSDEVIEWBASE");
      var5.add(0, "PSDEFINPUTTIP");
      var5.add(0, "PSCODEITEM");
      var5.add(0, "PSDEGRIDCOL");
      var5.add(0, "PSDEDQCODEEXP");
      var5.add(0, "PSDEFFORMITEM");
      var5.add(0, "PSDEFORMDETAIL");
      var5.add(0, "PSDEFIELD");
      var5.add(0, "PSSYSDMITEM");
      var5.add(0, "PSDEFDTCOL");
      var5.remove("PSSYSCONSOLE");
      final Timestamp var9 = new Timestamp(System.currentTimeMillis());
      SessionFactory var10 = PSSysModelInstGlobal.getSessionFactory(this.getPSSysModelInstId());
      final PSSystemService var11 = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, var10);
      final int var12 = var5.size();
      ExecutorService var13 = Executors.newCachedThreadPool();

      for (int var14 = 0; var14 < 8; var14++) {
         var13.execute(new Runnable() {
            @Override
            public void run() {
               String var1x = null;

               try {
                  SessionFactory var2x = PSSysModelInstGlobal.getSessionFactory(PSModelV2Helper.this.getPSSysModelInstId());

                  while (var7.size() == 0) {
                     var1x = null;
                     synchronized (var5) {
                        if (var5.size() > 0) {
                           var1x = (String)var5.remove(0);
                        }
                     }

                     if (StringHelper.isNullOrEmpty(var1x)) {
                        break;
                     }

                     IDataEntityModel var25 = DEModelGlobal.getDEModel(var1x, true);
                     if (var25 == null) {
                        synchronized (var6) {
                           var6.add(var1x);
                           PSModelV2Helper.log.debug(StringHelper.format("导入[%1$s]，当前已完成 %2$s/%3$s", var1x, var6.size(), var12));
                        }
                     } else {
                        File var4x = new File(var1 + File.separator + var1x + File.separator + "ALL.txt");
                        if (!var4x.exists()) {
                           synchronized (var6) {
                              var6.add(var1x);
                              PSModelV2Helper.log.debug(StringHelper.format("导入[%1$s]，当前已完成 %2$s/%3$s", var1x, var6.size(), var12));
                           }
                        } else {
                           IService var5x = var25.getService(var2x);
                           if (var5x.getSessionFactory() != var2x) {
                              synchronized (var6) {
                                 var6.add(var1x);
                                 PSModelV2Helper.log.debug(StringHelper.format("忽略导入[%1$s]，数据源不一致，当前已完成 %2$s/%3$s", var1x, var6.size(), var12));
                              }
                           } else {
                              ArrayList var6x = new ArrayList();

                              for (String var9x : PSModelV2Helper.readFile2(var4x)) {
                                 if (!StringHelper.isNullOrEmpty(var9x)) {
                                    IEntity var10x = var25.createEntity();
                                    ObjectNode var11x = (ObjectNode)JsonNodeHelper.fromString(var9x);
                                    PSModelV2Helper.fromJSONObject(var10x, var11x, false);
                                    Timestamp var12x = DataObject.getTimestampValue(var10x, "CREATEDATE", null);
                                    if (var12x == null) {
                                       var10x.set("CREATEDATE", var9);
                                    }

                                    Timestamp var13x = DataObject.getTimestampValue(var10x, "UPDATEDATE", null);
                                    if (var13x == null) {
                                       var10x.set("UPDATEDATE", var9);
                                    }

                                    String var14x = DataObject.getStringValue(var10x, "CREATEMAN", null);
                                    if (StringHelper.isNullOrEmpty(var14x)) {
                                       var10x.set("CREATEMAN", "SYSTEM");
                                    }

                                    String var15 = DataObject.getStringValue(var10x, "UPDATEMAN", null);
                                    if (StringHelper.isNullOrEmpty(var15)) {
                                       var10x.set("UPDATEMAN", "SYSTEM");
                                    }

                                    var10x.set("ENABLE", 1);
                                    var6x.add(var10x);
                                 }
                              }

                              PSModelV2Helper.log.debug(StringHelper.format("模型恢复[%1$s]数量[%2$s]", var1x, var6x.size()));
                              PSSysModelInstGlobal.active(PSModelV2Helper.this.getPSSysModelInstId());
                              if (var5x instanceof IPSCoreSysService) {
                                 ((IPSCoreSysService)var5x).executeBatchCreate(var6x, 2000);
                              } else {
                                 var11.executeBatchCreate(var6x, 2000, var25);
                              }

                              synchronized (var8) {
                                 var8.add(var6x.size());
                              }

                              var6x.clear();
                              synchronized (var6) {
                                 var6.add(var1x);
                                 PSModelV2Helper.log.debug(StringHelper.format("导入[%1$s]，当前已完成 %2$s/%3$s", var1x, var6.size(), var12));
                              }
                           }
                        }
                     }
                  }
               } catch (Exception var24) {
                  PSModelV2Helper.log.error(var24);
                  if (StringHelper.isNullOrEmpty(var1x)) {
                     var7.add("未知模型");
                  } else {
                     var7.add(var1x);
                  }
               }
            }
         });
      }

      long var20 = 0L;

      while (var6.size() != var12 && var7.size() == 0) {
         Thread.sleep(50L);
         if (System.currentTimeMillis() - var20 >= 10000L) {
            PSSysModelInstGlobal.active(this.getPSSysModelInstId());
            var20 = System.currentTimeMillis();
         }
      }

      var13.shutdown();
      if (var7.size() > 0) {
         StringBuilderEx var21 = new StringBuilderEx();
         var21.append("导入模型发生错误：");
         boolean var22 = true;

         for (String var19 : var7) {
            if (var22) {
               var22 = false;
            } else {
               var21.append(",");
            }

            var21.append(var19);
         }

         throw new Exception(var21.toString());
      } else {
         int var16 = 0;

         for (int var18 : var8) {
            var16 += var18;
         }

         log.debug(StringHelper.format("导入记录数[%1$s]，耗时[%2$s]", var16, System.currentTimeMillis() - var2));
      }
   }

   protected Map<String, String> getBackupDataMap() throws Exception {
      HashMap var1 = new HashMap();
      var1.put("FILE", "");
      var1.put("PSACHANDLER", "");
      var1.put("PSACHANDLERACTION", "");
      var1.put("PSAMITEMTYPE", "");
      var1.put("PSAPPCTRLSTYLE", "");
      var1.put("PSAPPDERS", "");
      var1.put("PSAPPDERSVIEW", "");
      var1.put("PSAPPDEVIEW", "");
      var1.put("PSAPPDEVIEWREF", "");
      var1.put("PSAPPDYNADEVIEW", "");
      var1.put("PSAPPEDITORTEMPL", "");
      var1.put("PSAPPFUNC", "");
      var1.put("PSAPPFUNCTYPE", "");
      var1.put("PSAPPINDEXVIEW", "");
      var1.put("PSAPPLAN", "");
      var1.put("PSAPPLOCALDE", "");
      var1.put("PSAPPMENU", "");
      var1.put("PSAPPMENUITEM", "");
      var1.put("PSAPPMODULE", "");
      var1.put("PSAPPPANELVIEW", "");
      var1.put("PSAPPPDTVIEW", "");
      var1.put("PSAPPPKG", "");
      var1.put("PSAPPPORTALVIEW", "");
      var1.put("PSAPPPVPART", "");
      var1.put("PSAPPSERVER", "");
      var1.put("PSAPPSUBAPP", "");
      var1.put("PSAPPTITLEBAR", "");
      var1.put("PSAPPTYPE", "");
      var1.put("PSAPPUISTYLE", "");
      var1.put("PSAPPUITHEME", "");
      var1.put("PSAPPUSERMODE", "");
      var1.put("PSAPPUTIL", "");
      var1.put("PSAPPUTILPAGE", "");
      var1.put("PSAPPUTILVIEW", "");
      var1.put("PSAPPVIEWCODE", "");
      var1.put("PSAPPVIEWLOGIC", "");
      var1.put("PSAPPVIEWREF", "");
      var1.put("PSAPPVIEWSTYLE", "");
      var1.put("PSAPPVIEWTEMPL", "");
      var1.put("PSAPPWF", "");
      var1.put("PSAPPWFVER", "");
      var1.put("PSASBOOKING", "");
      var1.put("PSASBOOKINGLOG", "");
      var1.put("PSASGROUP", "");
      var1.put("PSASTYPE", "");
      var1.put("PSBACKSERVICE", "");
      var1.put("PSBDDEVINST", "");
      var1.put("PSBDSERVER", "");
      var1.put("PSBDTYPE", "");
      var1.put("PSBKTASKLOG", "");
      var1.put("PSBOOKINGRESTYPE", "");
      var1.put("PSCHARTTYPE", "");
      var1.put("PSCODEITEM", "");
      var1.put("PSCODELIST", "");
      var1.put("PSCODELISTTEMPL", "");
      var1.put("PSCODENAME", "");
      var1.put("PSCODEPREVIEWACTION", "");
      var1.put("PSCODESERVERACTION", "");
      var1.put("PSCODESNIPPETTYPE", "");
      var1.put("PSCONSOLESERVER", "");
      var1.put("PSCOREPRD", "");
      var1.put("PSCOREPRDCAT", "");
      var1.put("PSCOREPRDFUNC", "");
      var1.put("PSCOREPRDINSTLOG", "");
      var1.put("PSCOREPRDISSUE", "");
      var1.put("PSCOREPRDVER", "");
      var1.put("PSCOUNTER", "");
      var1.put("PSCOUNTERTYPE", "");
      var1.put("PSCOUNTERTYPESF", "");
      var1.put("PSCPVFUNC", "");
      var1.put("PSCPVISSUE", "");
      var1.put("PSCSSCATTEMPL", "");
      var1.put("PSCSSTEMPL", "");
      var1.put("PSCTRLACTION", "");
      var1.put("PSCTRLEVENT", "");
      var1.put("PSCTRLMODEL", "");
      var1.put("PSCTRLMSG", "");
      var1.put("PSCTRLMSGITEM", "");
      var1.put("PSCTRLMSGTAG", "");
      var1.put("PSCTRLTYPE", "");
      var1.put("PSCTRLTYPEACTION", "");
      var1.put("PSCTRLTYPEEVENT", "");
      var1.put("PSCTRLTYPEMODEL", "");
      var1.put("PSCTRLTYPEMSGTAG", "");
      var1.put("PSDATAENTITY", "");
      var1.put("PSDATASYNCAGENTTYPE", "");
      var1.put("PSDBDEVINST", "");
      var1.put("PSDBDEVINSTBK", "");
      var1.put("PSDBOBJTYPE", "");
      var1.put("PSDBPROCPARAM", "");
      var1.put("PSDBSERVER", "");
      var1.put("PSDBSPPARTTEMPL", "");
      var1.put("PSDBSYSPROCTEMPL", "");
      var1.put("PSDBSYSPROCTYPE", "");
      var1.put("PSDBTYPE", "");
      var1.put("PSDBVALUEFUNC", "");
      var1.put("PSDBVALUEMODE", "");
      var1.put("PSDBVALUEOP", "");
      var1.put("PSDBVFCODE", "");
      var1.put("PSDCABILITY", "");
      var1.put("PSDCASGROUP", "");
      var1.put("PSDCBDINST", "");
      var1.put("PSDCBKTASK", "");
      var1.put("PSDCBKTYPE", "");
      var1.put("PSDCBULLETIN", "");
      var1.put("PSDCCODESNIPPET", "");
      var1.put("PSDCCODESNIPPETREF", "");
      var1.put("PSDCCOREPRDISSUE", "");
      var1.put("PSDCDBFUNC", "");
      var1.put("PSDCDBINDEX", "");
      var1.put("PSDCDBINSTBK", "");
      var1.put("PSDCDBINSTREF", "");
      var1.put("PSDCDBOBJ", "");
      var1.put("PSDCDBPROC", "");
      var1.put("PSDCDBSEQU", "");
      var1.put("PSDCDBTABLE", "");
      var1.put("PSDCDBVIEW", "");
      var1.put("PSDCDEPLOYCENTER", "");
      var1.put("PSDCDEPLOYSERVER", "");
      var1.put("PSDCDETEMPL", "");
      var1.put("PSDCDETEMPLFIELD", "");
      var1.put("PSDCINST", "");
      var1.put("PSDCMAVENREPO", "");
      var1.put("PSDCMOBAPPTDREF", "");
      var1.put("PSDCMOBAPPTESTDEVICE", "");
      var1.put("PSDCMOBPACKCERT", "");
      var1.put("PSDCMODELTEMPL", "");
      var1.put("PSDCMSGACCOUNT", "");
      var1.put("PSDCMSPLATFORM", "");
      var1.put("PSDCMSPLATFORMFUNC", "");
      var1.put("PSDCMSPLATFORMNODE", "");
      var1.put("PSDCMTDECAT", "");
      var1.put("PSDCMTDEF", "");
      var1.put("PSDCNWFLOW", "");
      var1.put("PSDCORG", "");
      var1.put("PSDCORGSECTOR", "");
      var1.put("PSDCORGUSER", "");
      var1.put("PSDCPFPITEMPL", "");
      var1.put("PSDCPFPLUGIN", "");
      var1.put("PSDCPRODUCT", "");
      var1.put("PSDCRESHOURS", "");
      var1.put("PSDCRESHOURSLOG", "");
      var1.put("PSDCRESREP", "");
      var1.put("PSDCROBOT", "");
      var1.put("PSDCROBOTABILITY", "");
      var1.put("PSDCROBOTLOG", "");
      var1.put("PSDCRTMSG", "");
      var1.put("PSDCSERVER", "");
      var1.put("PSDCSERVERSTATE", "");
      var1.put("PSDCSFPKG", "");
      var1.put("PSDCSFPKGVER", "");
      var1.put("PSDCSVNBK", "");
      var1.put("PSDCSYNCAGENT", "");
      var1.put("PSDCSYNCDATA", "");
      var1.put("PSDCSYNCDATA2", "");
      var1.put("PSDCSYNCDATATYPE", "");
      var1.put("PSDCSYSINSTACTION", "");
      var1.put("PSDCSYSLIC", "");
      var1.put("PSDCSYSMODELINST", "");
      var1.put("PSDCSYSPRDVER", "");
      var1.put("PSDCSYSPRODUCT", "");
      var1.put("PSDCSYSRES", "");
      var1.put("PSDCTASKLOG", "");
      var1.put("PSDCWORKSHOPSERVER", "");
      var1.put("PSDCWORKSPACE", "");
      var1.put("PSDCWORKSPACEACTION", "");
      var1.put("PSDCWORKSPACELOG", "");
      var1.put("PSDCWORKSPACEUSER", "");
      var1.put("PSDEACMODE", "");
      var1.put("PSDEACMODEITEM", "");
      var1.put("PSDEACTION", "");
      var1.put("PSDEACTIONLOGIC", "");
      var1.put("PSDEACTIONPARAM", "");
      var1.put("PSDEACTIONTEMPL", "");
      var1.put("PSDEACTIONTYPE", "");
      var1.put("PSDEACTIONWIZARD", "");
      var1.put("PSDEAWGROUP", "");
      var1.put("PSDEAWGRPDETAIL", "");
      var1.put("PSDEAWITEM", "");
      var1.put("PSDECHART", "");
      var1.put("PSDECHARTAXES", "");
      var1.put("PSDECHARTPARAM", "");
      var1.put("PSDECTRL", "");
      var1.put("PSDEDATAEXP", "");
      var1.put("PSDEDATAIMP", "");
      var1.put("PSDEDATAIMPITEM", "");
      var1.put("PSDEDATAQUERY", "");
      var1.put("PSDEDATARELATION", "");
      var1.put("PSDEDATASET", "");
      var1.put("PSDEDATASYNC", "");
      var1.put("PSDEDATAVIEW", "");
      var1.put("PSDEDBCFG", "");
      var1.put("PSDEDBIDXFIELD", "");
      var1.put("PSDEDBINDEX", "");
      var1.put("PSDEDBOBJSQL", "");
      var1.put("PSDEDQCODE", "");
      var1.put("PSDEDQCODECOND", "");
      var1.put("PSDEDQCODEEXP", "");
      var1.put("PSDEDQCOND", "");
      var1.put("PSDEDQJOIN", "");
      var1.put("PSDEDQPDCOND", "");
      var1.put("PSDEDRDETAIL", "");
      var1.put("PSDEDRGROUP", "");
      var1.put("PSDEDRITEM", "");
      var1.put("PSDEDSCODE", "");
      var1.put("PSDEDSDQ", "");
      var1.put("PSDEDSGRPPARAM", "");
      var1.put("PSDEDSPARAM", "");
      var1.put("PSDEDTSQUEUE", "");
      var1.put("PSDEDUPRULE", "");
      var1.put("PSDEDUPRULEITEM", "");
      var1.put("PSDEFDATATYPE", "");
      var1.put("PSDEFDLOGIC", "");
      var1.put("PSDEFDTCOL", "");
      var1.put("PSDEFFORMITEM", "");
      var1.put("PSDEFGRIDCOL", "");
      var1.put("PSDEFGROUP", "");
      var1.put("PSDEFGROUPDETAIL", "");
      var1.put("PSDEFIELD", "");
      var1.put("PSDEFINPUTTIP", "");
      var1.put("PSDEFINPUTTIPSET", "");
      var1.put("PSDEFIUDETAIL", "");
      var1.put("PSDEFIUPDATE", "");
      var1.put("PSDEFIVR", "");
      var1.put("PSDEFORM", "");
      var1.put("PSDEFORMDETAIL", "");
      var1.put("PSDEFORMRF", "");
      var1.put("PSDEFSFITEM", "");
      var1.put("PSDEFTYPE", "");
      var1.put("PSDEFVALUERULE", "");
      var1.put("PSDEFVRCODETYPE", "");
      var1.put("PSDEFVRCOND", "");
      var1.put("PSDEFVRDSPARAM", "");
      var1.put("PSDEFVRTYPE", "");
      var1.put("PSDEFVRTYPEDETAIL", "");
      var1.put("PSDEGCTYPE", "");
      var1.put("PSDEGEIUDETAIL", "");
      var1.put("PSDEGEIUPDATE", "");
      var1.put("PSDEGRID", "");
      var1.put("PSDEGRIDCOL", "");
      var1.put("PSDEGROUP", "");
      var1.put("PSDEGROUPDETAIL", "");
      var1.put("PSDEINITCFG", "");
      var1.put("PSDEJOINTYPE", "");
      var1.put("PSDELIST", "");
      var1.put("PSDELISTITEM", "");
      var1.put("PSDELLCOND", "");
      var1.put("PSDELLCONDTYPE", "");
      var1.put("PSDELLTYPE", "");
      var1.put("PSDELNPARAM", "");
      var1.put("PSDELNTYPE", "");
      var1.put("PSDELOGIC", "");
      var1.put("PSDELOGICLINK", "");
      var1.put("PSDELOGICNODE", "");
      var1.put("PSDELOGICPARAM", "");
      var1.put("PSDEMAINSTATE", "");
      var1.put("PSDEMAINSTATERS", "");
      var1.put("PSDEMAP", "");
      var1.put("PSDEMAPACTION", "");
      var1.put("PSDEMAPDETAIL", "");
      var1.put("PSDEMAPDQ", "");
      var1.put("PSDEMAPDS", "");
      var1.put("PSDEMODEL", "");
      var1.put("PSDEMODELCNT", "");
      var1.put("PSDEMSACTION", "");
      var1.put("PSDEMSOPPRIV", "");
      var1.put("PSDEOPPRIV", "");
      var1.put("PSDEOPPRIVROLE", "");
      var1.put("PSDEPLOYCENTER", "");
      var1.put("PSDEPLOYSERVER", "");
      var1.put("PSDEPRINT", "");
      var1.put("PSDEPSAASSYS", "");
      var1.put("PSDEPSAASSYSAPP", "");
      var1.put("PSDEPSAASSYSVER", "");
      var1.put("PSDEPSLN", "");
      var1.put("PSDEPSLNAS", "");
      var1.put("PSDEPSLNASGRP", "");
      var1.put("PSDEPSLNASITEM", "");
      var1.put("PSDEPSLNDBINST", "");
      var1.put("PSDEPSLNDEPSESSION", "");
      var1.put("PSDEPSLNHOST", "");
      var1.put("PSDEPSLNLOG", "");
      var1.put("PSDEPSLNMODE", "");
      var1.put("PSDEPSLNMODEPRD", "");
      var1.put("PSDEPSLNMQINST", "");
      var1.put("PSDEPSLNPACK", "");
      var1.put("PSDEPSLNPRD", "");
      var1.put("PSDEPSLNRUNLOG", "");
      var1.put("PSDEPSLNSYS", "");
      var1.put("PSDEPSLNSYSAS", "");
      var1.put("PSDEPSLNSYSDB", "");
      var1.put("PSDEPSLNSYSDYNAINST", "");
      var1.put("PSDEPSLNSYSKEY", "");
      var1.put("PSDEPSLNSYSMQ", "");
      var1.put("PSDEPSLNTYPE", "");
      var1.put("PSDEPSLNUSER", "");
      var1.put("PSDEPSYS", "");
      var1.put("PSDEPSYSAPI", "");
      var1.put("PSDEPSYSAPP", "");
      var1.put("PSDEPSYSTYPE", "");
      var1.put("PSDEPSYSVER", "");
      var1.put("PSDEPTOOLTYPE", "");
      var1.put("PSDER", "");
      var1.put("PSDERDEFMAP", "");
      var1.put("PSDEREPITEM", "");
      var1.put("PSDEREPORT", "");
      var1.put("PSDERGROUP", "");
      var1.put("PSDERGROUPDETAIL", "");
      var1.put("PSDERTAW", "");
      var1.put("PSDERTAWI", "");
      var1.put("PSDERTYPE", "");
      var1.put("PSDESADETAIL", "");
      var1.put("PSDESAMPLEDATA", "");
      var1.put("PSDESAMPLEDATAREF", "");
      var1.put("PSDESARS", "");
      var1.put("PSDESERVICEAPI", "");
      var1.put("PSDESPCODE", "");
      var1.put("PSDESPCODEPART", "");
      var1.put("PSDESPFIELD", "");
      var1.put("PSDESYSPROC", "");
      var1.put("PSDETABLE", "");
      var1.put("PSDETBITEM", "");
      var1.put("PSDETOOLBAR", "");
      var1.put("PSDETREECOL", "");
      var1.put("PSDETREENODE", "");
      var1.put("PSDETREENODECOL", "");
      var1.put("PSDETREENODERS", "");
      var1.put("PSDETREENODERV", "");
      var1.put("PSDETREEVIEW", "");
      var1.put("PSDEUAGROUP", "");
      var1.put("PSDEUAGRPDETAIL", "");
      var1.put("PSDEUIACTION", "");
      var1.put("PSDEUIACTIONTYPE", "");
      var1.put("PSDEUSERROLE", "");
      var1.put("PSDEUTILDE", "");
      var1.put("PSDEUTILTYPE", "");
      var1.put("PSDEVCENTER", "");
      var1.put("PSDEVCENTERAS", "");
      var1.put("PSDEVCENTERDBINST", "");
      var1.put("PSDEVCENTERFILE", "");
      var1.put("PSDEVCENTERLOG", "");
      var1.put("PSDEVCENTERMQ", "");
      var1.put("PSDEVCENTERPF", "");
      var1.put("PSDEVCENTERRES", "");
      var1.put("PSDEVCENTERSERVER", "");
      var1.put("PSDEVCENTERSF", "");
      var1.put("PSDEVCENTERSRV", "");
      var1.put("PSDEVCENTERSVN", "");
      var1.put("PSDEVCENTERTS", "");
      var1.put("PSDEVENV", "");
      var1.put("PSDEVIEWBASE", "");
      var1.put("PSDEVIEWCTRL", "");
      var1.put("PSDEVIEWCTRLDS", "");
      var1.put("PSDEVIEWENGINE", "");
      var1.put("PSDEVIEWGROUP", "");
      var1.put("PSDEVIEWGRPDETAIL", "");
      var1.put("PSDEVIEWLOGIC", "");
      var1.put("PSDEVIEWRV", "");
      var1.put("PSDEVIEWSERVICE", "");
      var1.put("PSDEVPRD", "");
      var1.put("PSDEVPRDISSUE", "");
      var1.put("PSDEVPRDISSUEPLAN", "");
      var1.put("PSDEVPRDSEPCPLAN", "");
      var1.put("PSDEVPRDSPEC", "");
      var1.put("PSDEVPRDSPECPLAN", "");
      var1.put("PSDEVPRDSUBVER", "");
      var1.put("PSDEVPRDSYS", "");
      var1.put("PSDEVPRDSYSSYNC", "");
      var1.put("PSDEVPRDSYSSYNCITEM", "");
      var1.put("PSDEVPRDVER", "");
      var1.put("PSDEVRGROUP", "");
      var1.put("PSDEVRGRPDETAIL", "");
      var1.put("PSDEVSERVER", "");
      var1.put("PSDEVSERVERLEASE", "");
      var1.put("PSDEVSERVERTYPE", "");
      var1.put("PSDEVSLN", "");
      var1.put("PSDEVSLNCODESERVER", "");
      var1.put("PSDEVSLNCSSESSION", "");
      var1.put("PSDEVSLNLINK", "");
      var1.put("PSDEVSLNMSDEPAPI", "");
      var1.put("PSDEVSLNMSDEPAPP", "");
      var1.put("PSDEVSLNMSDEPFUNC", "");
      var1.put("PSDEVSLNMSDEPFUNCITEM", "");
      var1.put("PSDEVSLNMSDEPLOY", "");
      var1.put("PSDEVSLNRECENT", "");
      var1.put("PSDEVSLNSYS", "");
      var1.put("PSDEVSLNSYSAPI", "");
      var1.put("PSDEVSLNSYSAPP", "");
      var1.put("PSDEVSLNSYSBAK", "");
      var1.put("PSDEVSLNSYSBAKLINK", "");
      var1.put("PSDEVSLNSYSDEPINST", "");
      var1.put("PSDEVSLNSYSDYNAINST", "");
      var1.put("PSDEVSLNSYSGD", "");
      var1.put("PSDEVSLNSYSGROUP", "");
      var1.put("PSDEVSLNSYSKEY", "");
      var1.put("PSDEVSLNSYSLOCKLOG", "");
      var1.put("PSDEVSLNSYSMODEL", "");
      var1.put("PSDEVSLNSYSPATCH", "");
      var1.put("PSDEVSLNSYSPUBLOCK", "");
      var1.put("PSDEVSLNSYSREF", "");
      var1.put("PSDEVSLNSYSREFLINK", "");
      var1.put("PSDEVSLNSYSRES", "");
      var1.put("PSDEVSLNSYSSRC", "");
      var1.put("PSDEVSLNSYSSRV", "");
      var1.put("PSDEVSLNSYSTS", "");
      var1.put("PSDEVSLNSYSVER", "");
      var1.put("PSDEVSLNSYSWSGIT", "");
      var1.put("PSDEVSLNTEMPL", "");
      var1.put("PSDEVSLNUSER", "");
      var1.put("PSDEVSLNUSERCS", "");
      var1.put("PSDEVSYSDIFFITEM", "");
      var1.put("PSDEVSYSDIFFREP", "");
      var1.put("PSDEVUSER", "");
      var1.put("PSDEVUSERGROUP", "");
      var1.put("PSDEVUSERMODEL", "");
      var1.put("PSDEVUSEROBJ", "");
      var1.put("PSDEVUSERRECENT", "");
      var1.put("PSDEVUSERSQL", "");
      var1.put("PSDEWIZARD", "");
      var1.put("PSDEWIZARDFORM", "");
      var1.put("PSDEWIZARDSTEP", "");
      var1.put("PSDRITEMTYPE", "");
      var1.put("PSDSBOOKING", "");
      var1.put("PSDSBOOKINGLOG", "");
      var1.put("PSDSCONSOLE", "");
      var1.put("PSDSPANELTOOLBOX", "");
      var1.put("PSDSSYSAPPBAR", "");
      var1.put("PSDSSYSAPPBARFILTER", "");
      var1.put("PSDYNAAPP", "");
      var1.put("PSDYNAAPPVCINST", "");
      var1.put("PSDYNAAPPVIEW", "");
      var1.put("PSDYNAAPPVIEWCTRL", "");
      var1.put("PSDYNAAPPVIEWINST", "");
      var1.put("PSDYNACODELIST", "");
      var1.put("PSDYNACODELISTINST", "");
      var1.put("PSDYNADE", "");
      var1.put("PSDYNADEFORM", "");
      var1.put("PSDYNADEFORMINST", "");
      var1.put("PSDYNADEFORMTEMPL", "");
      var1.put("PSDYNADETEMPL", "");
      var1.put("PSDYNADEVIEWTEMPL", "");
      var1.put("PSDYNAINST", "");
      var1.put("PSDYNASYS", "");
      var1.put("PSDYNAWF", "");
      var1.put("PSDYNAWFVER", "");
      var1.put("PSDYNAWFVERINST", "");
      var1.put("PSDYNAWORKFLOW", "");
      var1.put("PSEDITORSTYLE", "");
      var1.put("PSEDITORTYPE", "");
      var1.put("PSFDLOGICTYPE", "");
      var1.put("PSFORMDETAILTYPE", "");
      var1.put("PSFORMTYPE", "");
      var1.put("PSGITUSER", "");
      var1.put("PSHELPARTICLE", "");
      var1.put("PSHELPARTICLECAT", "");
      var1.put("PSHELPARTICLETEMPL", "");
      var1.put("PSHELPARTICLETYPE", "");
      var1.put("PSHELPARTSEC", "");
      var1.put("PSHELPMODART", "");
      var1.put("PSHELPMODULE", "");
      var1.put("PSHELPPRJ", "");
      var1.put("PSHELPPRJTEMPL", "");
      var1.put("PSHELPPRJTYPE", "");
      var1.put("PSHELPRESOURCE", "");
      var1.put("PSHELPSECTION", "");
      var1.put("PSHELPSECTIONTEMPL", "");
      var1.put("PSHELPSECTIONTYPE", "");
      var1.put("PSIMAGETEMPL", "");
      var1.put("PSLANGUAGE", "");
      var1.put("PSLANGUAGEITEM", "");
      var1.put("PSLANGUAGERES", "");
      var1.put("PSLISTITEMTYPE", "");
      var1.put("PSMAVENREPO", "");
      var1.put("PSMAVENSERVER", "");
      var1.put("PSMAVENSERVERTYPE", "");
      var1.put("PSMIDETAIL", "");
      var1.put("PSMOBAPPPACK", "");
      var1.put("PSMOBAPPPACKSERVER", "");
      var1.put("PSMOBAPPPACKSESSION", "");
      var1.put("PSMOBAPPPACKTD", "");
      var1.put("PSMOBAPPSTARTPAGE", "");
      var1.put("PSMODEL", "");
      var1.put("PSMODELAPI", "");
      var1.put("PSMODELAPIINT", "");
      var1.put("PSMODELAPIMETHOD", "");
      var1.put("PSMODELAPIRS", "");
      var1.put("PSMODELBOOKMARK", "");
      var1.put("PSMODELERROR", "");
      var1.put("PSMODELEXAMPLE", "");
      var1.put("PSMODELEXAMPLECAT", "");
      var1.put("PSMODELEXAMPLESTEP", "");
      var1.put("PSMODELFIELD", "");
      var1.put("PSMODELFIELDVALUE", "");
      var1.put("PSMODELHOTCODE", "");
      var1.put("PSMODELIMPORT", "");
      var1.put("PSMODELINIT", "");
      var1.put("PSMODELMEMO", "");
      var1.put("PSMODELMODULE", "");
      var1.put("PSMODELOBJ", "");
      var1.put("PSMODELOBJREF", "");
      var1.put("PSMODELPFCODE", "");
      var1.put("PSMODELPLUGIN", "");
      var1.put("PSMODELREF", "");
      var1.put("PSMODELRESOURCE", "");
      var1.put("PSMODELRS", "");
      var1.put("PSMODELRT", "");
      var1.put("PSMODELRTMSG", "");
      var1.put("PSMODELSECTION", "");
      var1.put("PSMODELSEQ", "");
      var1.put("PSMODELSFCODE", "");
      var1.put("PSMODELSTATE", "");
      var1.put("PSMODELSTORAGE", "");
      var1.put("PSMODELSUBVIEW", "");
      var1.put("PSMODELSUMMARYTEMPL", "");
      var1.put("PSMODELUIACTION", "");
      var1.put("PSMODELVALUEGROUP", "");
      var1.put("PSMODELVIEW", "");
      var1.put("PSMODELVIEWUIACTION", "");
      var1.put("PSMODULE", "");
      var1.put("PSMQINST", "");
      var1.put("PSMQTYPE", "");
      var1.put("PSMSPLATFORM", "");
      var1.put("PSMSPLATFORMFUNC", "");
      var1.put("PSMSPLATFORMNODE", "");
      var1.put("PSNDFILE", "");
      var1.put("PSNDFILELINK", "");
      var1.put("PSPANELDETAILTYPE", "");
      var1.put("PSPANELENGINE", "");
      var1.put("PSPANELITEMLOGIC", "");
      var1.put("PSPANELLLCOND", "");
      var1.put("PSPANELLLCONDTYPE", "");
      var1.put("PSPANELLLTYPE", "");
      var1.put("PSPANELLNPARAM", "");
      var1.put("PSPANELLNTYPE", "");
      var1.put("PSPANELLOGICLINK", "");
      var1.put("PSPANELLOGICNODE", "");
      var1.put("PSPANELLOGICPARAM", "");
      var1.put("PSPDTAPPFUNC", "");
      var1.put("PSPDTVIEW", "");
      var1.put("PSPF", "");
      var1.put("PSPFAPPTEMPL", "");
      var1.put("PSPFCDN", "");
      var1.put("PSPFCODEFOLDER", "");
      var1.put("PSPFCTDETAIL", "");
      var1.put("PSPFCTRLTEMPL", "");
      var1.put("PSPFCTRLTYPE", "");
      var1.put("PSPFEDITORTEMPL", "");
      var1.put("PSPFEDITORTYPE", "");
      var1.put("PSPFPKG", "");
      var1.put("PSPFPKGCAT", "");
      var1.put("PSPFPKGVER", "");
      var1.put("PSPFPKGVERCDN", "");
      var1.put("PSPFPLUGIN", "");
      var1.put("PSPFPLUGINTEMPL", "");
      var1.put("PSPFPLUGINTYPE", "");
      var1.put("PSPFPREVIEWACTION", "");
      var1.put("PSPFPREVIEWNODE", "");
      var1.put("PSPFPUBCODE", "");
      var1.put("PSPFPUBOBJ", "");
      var1.put("PSPFPUBOBJPARAM", "");
      var1.put("PSPFQUICKTEMPL", "");
      var1.put("PSPFRESOURCE", "");
      var1.put("PSPFSTYLE", "");
      var1.put("PSPFSTYLECODE", "");
      var1.put("PSPFSTYLELOG", "");
      var1.put("PSPFSTYLEPKG", "");
      var1.put("PSPFSTYLEPRJ", "");
      var1.put("PSPFUATEMPL", "");
      var1.put("PSPFVIEWTEMPL", "");
      var1.put("PSPFVIEWTYPE", "");
      var1.put("PSPFVLTEMPL", "");
      var1.put("PSPILOGICTYPE", "");
      var1.put("PSPORTLET", "");
      var1.put("PSPORTLETTYPE", "");
      var1.put("PSPRODUCT", "");
      var1.put("PSPRODUCTTYPE", "");
      var1.put("PSROBOT", "");
      var1.put("PSROBOTABILITY", "");
      var1.put("PSROBOTTYPE", "");
      var1.put("PSROBOTTYPEABILITY", "");
      var1.put("PSROBOTWORK", "");
      var1.put("PSROBOTWORKTYPE", "");
      var1.put("PSROSSERVER", "");
      var1.put("PSRTWXACCOUNT", "");
      var1.put("PSSAASSYS", "");
      var1.put("PSSAASSYSAPI", "");
      var1.put("PSSAASSYSAPP", "");
      var1.put("PSSAASSYSDB", "");
      var1.put("PSSAASSYSVER", "");
      var1.put("PSSAHANDLER", "");
      var1.put("PSSAMPLEVALUE", "");
      var1.put("PSSF", "");
      var1.put("PSSFACHANDLER", "");
      var1.put("PSSFCODEFOLDER", "");
      var1.put("PSSFCODETEMPL", "");
      var1.put("PSSFCODETYPE", "");
      var1.put("PSSFCONFIG", "");
      var1.put("PSSFCTRLTYPE", "");
      var1.put("PSSFEXCEPTION", "");
      var1.put("PSSFPF", "");
      var1.put("PSSFPKG", "");
      var1.put("PSSFPKGCAT", "");
      var1.put("PSSFPKGVER", "");
      var1.put("PSSFPLUGIN", "");
      var1.put("PSSFPLUGINTEMPL", "");
      var1.put("PSSFPREVIEWACTION", "");
      var1.put("PSSFPUBOBJ", "");
      var1.put("PSSFPUBOBJPARAM", "");
      var1.put("PSSFSAHANDLER", "");
      var1.put("PSSFSTYLE", "");
      var1.put("PSSFSTYLECODE", "");
      var1.put("PSSFSTYLELOG", "");
      var1.put("PSSFSTYLEPARAM", "");
      var1.put("PSSFSTYLEPKG", "");
      var1.put("PSSFSTYLEPRJ", "");
      var1.put("PSSFSTYLEREF", "");
      var1.put("PSSFSTYLEVER", "");
      var1.put("PSSFVERCODE", "");
      var1.put("PSSFVERCODEITEM", "");
      var1.put("PSSFVIEWTYPE", "");
      var1.put("PSSTUDIOSERVER", "");
      var1.put("PSSTUDIOSERVERGRP", "");
      var1.put("PSSTUDIOSERVERLOG", "");
      var1.put("PSSTUDIOTHEME", "");
      var1.put("PSSUBAPP", "");
      var1.put("PSSUBAPPVIEW", "");
      var1.put("PSSUBDE", "");
      var1.put("PSSUBDEACTION", "");
      var1.put("PSSUBDEVIEW", "");
      var1.put("PSSUBSYS", "");
      var1.put("PSSUBSYSDM", "");
      var1.put("PSSUBSYSSADETAIL", "");
      var1.put("PSSUBSYSSERVICEAPI", "");
      var1.put("PSSUBSYSSF", "");
      var1.put("PSSUBSYSVER", "");
      var1.put("PSSUBSYSVERINST", "");
      var1.put("PSSUBVIEWTYPE", "");
      var1.put("PSSVNINSTREPO", "");
      var1.put("PSSVNSERVER", "");
      var1.put("PSSVRDOMAIN", "");
      var1.put("PSSVRPROVIDER", "");
      var1.put("PSSVRSERVER", "");
      var1.put("PSSYSACHANDLER", "");
      var1.put("PSSYSACTOR", "");
      var1.put("PSSYSAPP", "");
      var1.put("PSSYSBACKSERVICE", "");
      var1.put("PSSYSBDCOLSET", "");
      var1.put("PSSYSBDCOLUMN", "");
      var1.put("PSSYSBDINSTCFG", "");
      var1.put("PSSYSBDMODULE", "");
      var1.put("PSSYSBDPART", "");
      var1.put("PSSYSBDSCHEME", "");
      var1.put("PSSYSBDTABLE", "");
      var1.put("PSSYSBDTABLEDE", "");
      var1.put("PSSYSBDTABLEDER", "");
      var1.put("PSSYSBDTABLERS", "");
      var1.put("PSSYSCALENDAR", "");
      var1.put("PSSYSCALENDARITEM", "");
      var1.put("PSSYSCALENDARITEMRV", "");
      var1.put("PSSYSCODESNIPPET", "");
      var1.put("PSSYSCONSOLE", "");
      var1.put("PSSYSCOUNTER", "");
      var1.put("PSSYSCOUNTERITEM", "");
      var1.put("PSSYSCSS", "");
      var1.put("PSSYSCSSCAT", "");
      var1.put("PSSYSCTRLSTYLE", "");
      var1.put("PSSYSDASHBOARD", "");
      var1.put("PSSYSDATASYNCAGENT", "");
      var1.put("PSSYSDBCHGLOG", "");
      var1.put("PSSYSDBCOLUMN", "");
      var1.put("PSSYSDBDETAIL", "");
      var1.put("PSSYSDBPART", "");
      var1.put("PSSYSDBSCHEME", "");
      var1.put("PSSYSDBTABLE", "");
      var1.put("PSSYSDBVALUEOP", "");
      var1.put("PSSYSDBVF", "");
      var1.put("PSSYSDBVFCODE", "");
      var1.put("PSSYSDEFTYPE", "");
      var1.put("PSSYSDELOGICNODE", "");
      var1.put("PSSYSDEPLOY", "");
      var1.put("PSSYSDEPLOYAPP", "");
      var1.put("PSSYSDEPLOYAS", "");
      var1.put("PSSYSDEPLOYDB", "");
      var1.put("PSSYSDEVBKTASK", "");
      var1.put("PSSYSDEVBTTYPE", "");
      var1.put("PSSYSDEVINFO", "");
      var1.put("PSSYSDEVINFOTYPE", "");
      var1.put("PSSYSDEVSTUDIO", "");
      var1.put("PSSYSDICTCAT", "");
      var1.put("PSSYSDMITEM", "");
      var1.put("PSSYSDMITEMLOG", "");
      var1.put("PSSYSDMVER", "");
      var1.put("PSSYSDMVERITEM", "");
      var1.put("PSSYSDSACTION", "");
      var1.put("PSSYSDSACTIONTYPE", "");
      var1.put("PSSYSDYNAMODEL", "");
      var1.put("PSSYSDYNAMODELATTR", "");
      var1.put("PSSYSDYNAMODELCAT", "");
      var1.put("PSSYSEDITORSTYLE", "");
      var1.put("PSSYSENGINECFG", "");
      var1.put("PSSYSERMAP", "");
      var1.put("PSSYSERMAPNODE", "");
      var1.put("PSSYSFILE", "");
      var1.put("PSSYSIMAGE", "");
      var1.put("PSSYSISSUE", "");
      var1.put("PSSYSISSUEENGINE", "");
      var1.put("PSSYSISSUETYPE", "");
      var1.put("PSSYSLANITEM", "");
      var1.put("PSSYSLANRES", "");
      var1.put("PSSYSMODELACTION", "");
      var1.put("PSSYSMODELFOLDER", "");
      var1.put("PSSYSMODELFOLDERITEM", "");
      var1.put("PSSYSMODELFUNC", "");
      var1.put("PSSYSMODELFUNCCAT", "");
      var1.put("PSSYSMODELFUNCTEMPL", "");
      var1.put("PSSYSMODELGROUP", "");
      var1.put("PSSYSMODELINST", "");
      var1.put("PSSYSMODELINSTBK", "");
      var1.put("PSSYSMODELINSTSUM", "");
      var1.put("PSSYSMODELLOADLOG", "");
      var1.put("PSSYSMODELLOG", "");
      var1.put("PSSYSMODELMSG", "");
      var1.put("PSSYSMODELSYNC", "");
      var1.put("PSSYSMODELVER", "");
      var1.put("PSSYSMSGTEMPL", "");
      var1.put("PSSYSOPPRIV", "");
      var1.put("PSSYSORGTYPE", "");
      var1.put("PSSYSOUTYPE", "");
      var1.put("PSSYSOUTYPERS", "");
      var1.put("PSSYSPDTVIEW", "");
      var1.put("PSSYSPFPITEMPL", "");
      var1.put("PSSYSPFPLUGIN", "");
      var1.put("PSSYSPOLICY", "");
      var1.put("PSSYSPOLICYMODEL", "");
      var1.put("PSSYSPORTLET", "");
      var1.put("PSSYSPRDVER", "");
      var1.put("PSSYSPRODUCT", "");
      var1.put("PSSYSPROJECT", "");
      var1.put("PSSYSREF", "");
      var1.put("PSSYSREFDE", "");
      var1.put("PSSYSREPORT", "");
      var1.put("PSSYSREQITEM", "");
      var1.put("PSSYSREQITEMDATA", "");
      var1.put("PSSYSREQITEMHIS", "");
      var1.put("PSSYSREQMODULE", "");
      var1.put("PSSYSRTDEFINPUTTIP", "");
      var1.put("PSSYSRTMSG", "");
      var1.put("PSSYSRUNLOG", "");
      var1.put("PSSYSRUNSESSION", "");
      var1.put("PSSYSSAHANDLER", "");
      var1.put("PSSYSSAMPLEVALUE", "");
      var1.put("PSSYSSEARCHBAR", "");
      var1.put("PSSYSSEARCHBARITEM", "");
      var1.put("PSSYSSERVICEAPI", "");
      var1.put("PSSYSSFCODE", "");
      var1.put("PSSYSSFPITEMPL", "");
      var1.put("PSSYSSFPLUGIN", "");
      var1.put("PSSYSSFPUB", "");
      var1.put("PSSYSSFPUBPKG", "");
      var1.put("PSSYSSFPUBREF", "");
      var1.put("PSSYSSQLCMD", "");
      var1.put("PSSYSSQLCMDSQL", "");
      var1.put("PSSYSTASK", "");
      var1.put("PSSYSTASKDATA", "");
      var1.put("PSSYSTBITEM", "");
      var1.put("PSSYSTCASSERT", "");
      var1.put("PSSYSTCINPUT", "");
      var1.put("PSSYSTDITEM", "");
      var1.put("PSSYSTEM", "");
      var1.put("PSSYSTEMAS", "");
      var1.put("PSSYSTEMDBCFG", "");
      var1.put("PSSYSTEMMQ", "");
      var1.put("PSSYSTEMRUN", "");
      var1.put("PSSYSTEMSRC", "");
      var1.put("PSSYSTESTCASE", "");
      var1.put("PSSYSTESTDATA", "");
      var1.put("PSSYSTITLEBAR", "");
      var1.put("PSSYSTOOLBAR", "");
      var1.put("PSSYSUIACTION", "");
      var1.put("PSSYSUNIRES", "");
      var1.put("PSSYSUNISTATE", "");
      var1.put("PSSYSUNIT", "");
      var1.put("PSSYSUSERCASE", "");
      var1.put("PSSYSUSERCASERS", "");
      var1.put("PSSYSUSERDR", "");
      var1.put("PSSYSUSERMODE", "");
      var1.put("PSSYSUSERROLERES", "");
      var1.put("PSSYSUSERROLEDATA", "");
      var1.put("PSSYSUTILDE", "");
      var1.put("PSSYSUTILTYPE", "");
      var1.put("PSSYSVALUERULE", "");
      var1.put("PSSYSVIEWLOGIC", "");
      var1.put("PSSYSVIEWLOGICPARAM", "");
      var1.put("PSSYSVIEWPANEL", "");
      var1.put("PSSYSVIEWPANELITEM", "");
      var1.put("PSSYSVIEWPANELLOGIC", "");
      var1.put("PSSYSVIEWPANELMODEL", "");
      var1.put("PSSYSWFMODE", "");
      var1.put("PSSYSWFSETTING", "");
      var1.put("PSTASKSERVER", "");
      var1.put("PSTASKSERVERLOG", "");
      var1.put("PSTBITEMTYPE", "");
      var1.put("PSTREENODETYPE", "");
      var1.put("PSTSCMD", "");
      var1.put("PSUACAPPTYPE", "");
      var1.put("PSUAWIZARD", "");
      var1.put("PSUAWIZARD2", "");
      var1.put("PSUAWIZARD3", "");
      var1.put("PSUIENGINETYPE", "");
      var1.put("PSUIENGINETYPEPARAM", "");
      var1.put("PSUNIT", "");
      var1.put("PSUSDCAPPPOLICY", "");
      var1.put("PSUSDCMODULE", "");
      var1.put("PSUSDCMODULEINST", "");
      var1.put("PSUSDCMODULEINSTFUNC", "");
      var1.put("PSUSDCMODULEINSTREF", "");
      var1.put("PSUSMODULE", "");
      var1.put("PSUSMODULEINST", "");
      var1.put("PSUSMODULEINSTFUNC", "");
      var1.put("PSUSMODULEINSTREF", "");
      var1.put("PSUWAPPFUNC", "");
      var1.put("PSUWAPPVIEW", "");
      var1.put("PSUWCREATEDE", "");
      var1.put("PSUWCREATEDEDEF", "");
      var1.put("PSUWCREATEDEDER", "");
      var1.put("PSUWCREATEDEITEM", "");
      var1.put("PSUWCREATEMODEL", "");
      var1.put("PSUWDEDRITEM", "");
      var1.put("PSUWDEUNIONKEY", "");
      var1.put("PSUWPICKUPMODEL", "");
      var1.put("PSVALUERULE", "");
      var1.put("PSVARSAMPLEVALUE", "");
      var1.put("PSVARTYPE", "");
      var1.put("PSVIEWENGINE", "");
      var1.put("PSVIEWLOGICTYPE", "");
      var1.put("PSVIEWLOGICTYPEPARAM", "");
      var1.put("PSVIEWMSG", "");
      var1.put("PSVIEWMSGGROUP", "");
      var1.put("PSVIEWMSGGRPDETAIL", "");
      var1.put("PSVIEWRTMSG", "");
      var1.put("PSVIEWSTYLE", "");
      var1.put("PSVIEWTYPE", "");
      var1.put("PSVIEWTYPECAT", "");
      var1.put("PSVIEWTYPELOGIC", "");
      var1.put("PSVIEWWIZARDGROUP", "");
      var1.put("PSVTCATDETAIL", "");
      var1.put("PSVTCTRL", "");
      var1.put("PSVTRV", "");
      var1.put("PSVTSAMPLE", "");
      var1.put("PSVTSTYLE", "");
      var1.put("PSWFDE", "");
      var1.put("PSWFENGINETYPE", "");
      var1.put("PSWFLINK", "");
      var1.put("PSWFLINKCOND", "");
      var1.put("PSWFLINKCONDTYPE", "");
      var1.put("PSWFLINKROLE", "");
      var1.put("PSWFLINKTYPE", "");
      var1.put("PSWFPROCESS", "");
      var1.put("PSWFPROCESSTYPE", "");
      var1.put("PSWFPROCPARAM", "");
      var1.put("PSWFPROCROLE", "");
      var1.put("PSWFPROCSUBWF", "");
      var1.put("PSWFROLE", "");
      var1.put("PSWFSUBWF", "");
      var1.put("PSWFUTILUIACTION", "");
      var1.put("PSWFVERLOG", "");
      var1.put("PSWFVERSION", "");
      var1.put("PSWFWORKTIME", "");
      var1.put("PSWORKFLOW", "");
      var1.put("PSWORKSHOPSERVER", "");
      var1.put("PSWORKSPACE", "");
      var1.put("PSWORKSPACELOG", "");
      var1.put("PSWORKSPACETYPE", "");
      var1.put("PSWPAPP", "");
      var1.put("PSWPAPPENTITY", "");
      var1.put("PSWPAPPINST", "");
      var1.put("PSWPDCAPPENTITY", "");
      var1.put("PSWPDCAPPINST", "");
      var1.put("PSWPDCENGINEINST", "");
      var1.put("PSWPDCWFCAT", "");
      var1.put("PSWPDCWFINST", "");
      var1.put("PSWPDCWORKFLOW", "");
      var1.put("PSWPENGINE", "");
      var1.put("PSWPENGINEINST", "");
      var1.put("PSWXACCOUNT", "");
      var1.put("PSWXENTAPP", "");
      var1.put("PSWXLOGIC", "");
      var1.put("PSWXMENU", "");
      var1.put("PSWXMENUFUNC", "");
      var1.put("PSWXMENUITEM", "");
      var1.put("PSSUBSYSSADE", "");
      var1.put("PSSUBSYSSADEFIELD", "");
      var1.put("PSSUBSYSSADERS", "");
      var1.put("PSSYSDBPROC", "");
      var1.put("PSSYSDBPROCPARAM", "");
      var1.put("PSDESAVR", "");
      var1.put("PSSYSCONTENT", "");
      var1.put("PSSYSRESOURCE", "");
      var1.put("PSAPPSTORYBOARD", "");
      var1.put("PSAPPSBITEMRS", "");
      var1.put("PSAPPSBITEM", "");
      var1.put("PSAPPRESOURCE", "");
      var1.put("PSSYSCONTENTCAT", "");
      var1.put("PSSYSTESTMODULE", "");
      var1.put("PSSYSTESTPRJ", "");
      var1.put("PSSYSUCMAP", "");
      var1.put("PSSYSUCMAPNODE", "");
      var1.put("PSDEACTIONGROUP", "");
      var1.put("PSDEAGDETAIL", "");
      var1.put("PSCTRLLOGICGROUP", "");
      var1.put("PSCTRLLOGICGRPDETAIL", "");
      var1.put("PSSYSSEARCHSCHEME", "");
      var1.put("PSSYSSEARCHDOC", "");
      var1.put("PSSYSSEARCHFIELD", "");
      var1.put("PSSYSSEARCHDE", "");
      var1.put("PSSYSSEARCHDEFIELD", "");
      var1.put("PSSYSMAPVIEW", "");
      var1.put("PSSYSMAPITEM", "");
      var1.put("PSSYSPORTLETCAT", "");
      var1.put("PSAPPPORTLET", "");
      var1.put("PSSYSWFCAT", "");
      var1.put("PSAPPSTORYBOARD", "");
      var1.put("PSAPPSBITEM", "");
      var1.put("PSAPPSBITEMRS", "");
      var1.put("PSDEGEIVR", "");
      var1.put("PSDEACTIONVR", "");
      var1.put("PSDEMSFIELD", "");
      var1.put("PSSYSSEQUENCE", "");
      var1.put("PSSYSTRANSLATOR", "");
      var1.put("PSSYSMSGQUEUE", "");
      var1.put("PSSYSMSGTARGET", "");
      var1.put("PSDENOTIFY", "");
      var1.put("PSDENOTIFYTARGET", "");
      var1.put("PSSYSEAIDATATYPEITEM", "");
      var1.put("PSSYSEAIDER", "");
      var1.put("PSSYSEAIDEFIELD", "");
      var1.put("PSSYSEAIDE", "");
      var1.put("PSSYSEAIELEMENTRE", "");
      var1.put("PSSYSEAIELEMENTATTR", "");
      var1.put("PSSYSEAIELEMENT", "");
      var1.put("PSSYSEAIDATATYPE", "");
      var1.put("PSSYSEAISCHEME", "");
      var1.put("PSSYSBIAGGCOLUMN", "");
      var1.put("PSSYSBIAGGTABLE", "");
      var1.put("PSSYSBICUBELEVEL", "");
      var1.put("PSSYSBICUBEMEASURE", "");
      var1.put("PSSYSBICUBEDIMENSION", "");
      var1.put("PSSYSBILEVEL", "");
      var1.put("PSSYSBIHIERARCHY", "");
      var1.put("PSSYSBIDIMENSION", "");
      var1.put("PSSYSBICUBE", "");
      var1.put("PSSYSBISCHEME", "");
      var1.put("PSTHRESHOLD", "");
      var1.put("PSTHRESHOLDGROUP", "");
      var1.put("PSSYSCHARTTHEME", "");
      var1.put("PSSYSCANVAS", "");
      var1.put("PSSYSCANVASMODEL", "");
      var1.put("PSSYSDASHBOARDLOGIC", "");
      var1.put("PSAPPMENULOGIC", "");
      var1.put("PSDEFORMLOGIC", "");
      var1.put("PSSYSSEARCHBARLOGIC", "");
      var1.put("PSAPPLOGIC", "");
      var1.put("PSDETOOLBARLOGIC", "");
      var1.put("PSDEWIZARDLOGIC", "");
      var1.put("PSDELISTLOGIC", " ");
      var1.put("PSSYSMAPLOGIC", "");
      var1.put("PSDETREELOGIC", "");
      var1.put("PSDEDATAVIEWLOGIC", "");
      var1.put("PSSYSCALENDARLOGIC", "");
      var1.put("PSDEGRIDLOGIC", "");
      var1.put("PSDECHARTLOGIC", "");
      var1.put("PSDEDRLOGIC", "");
      var1.put("PSDETEIUDETAIL", "");
      var1.put("PSDETEIUPDATE", "");
      var1.put("PSSYSUSECASECAT", "");
      var1.put("PSDETEIUPDATE", "");
      var1.put("PSDETEIUDETAIL", "");
      var1.put("PSSYSBIREPORT", "");
      var1.put("PSSYSBIREPORTITEM", "");
      var1.put("PSAPPPFPLUGIN", "");
      var1.put("PSSYSAICHATAGENT", "");
      var1.put("PSSYSAIFACTORY", "");
      var1.put("PSSYSAIPIPELINEAGENT", "");
      var1.put("PSSYSAIPIPELINEJOB", "");
      var1.put("PSSYSAIPIPELINEWORKER", "");
      var1.put("PSSYSAIWORKERAGENT", "");
      return var1;
   }

   public Map<String, Integer> count() throws Exception {
      final ConcurrentHashMap<String, Integer> var1 = new ConcurrentHashMap<>();
      long var2 = System.currentTimeMillis();
      Map var4 = this.getBackupDataMap();
      var4.remove("PSSYSCONSOLE");
      final ArrayList var5 = new ArrayList();
      final ArrayList var6 = new ArrayList();
      final ArrayList<String> var7 = new ArrayList<>();
      var5.addAll(var4.keySet());
      var5.add("PSAPPVIEW");
      final int var8 = var5.size();
      ExecutorService var9 = Executors.newCachedThreadPool();

      for (int var10 = 0; var10 < 8; var10++) {
         var9.execute(new Runnable() {
            @Override
            public void run() {
               String var1x = null;

               try {
                  SessionFactory var2x = PSSysModelInstGlobal.getSessionFactory(PSModelV2Helper.this.getPSSysModelInstId());

                  while (var7.size() == 0) {
                     var1x = null;
                     synchronized (var5) {
                        if (var5.size() > 0) {
                           var1x = (String)var5.remove(0);
                        }
                     }

                     if (StringHelper.isNullOrEmpty(var1x)) {
                        break;
                     }

                     IDataEntityModel var15 = DEModelGlobal.getDEModel(var1x, true);
                     if (var15 == null) {
                        synchronized (var6) {
                           var6.add(var1x);
                           PSModelV2Helper.log.debug(StringHelper.format("计数[%1$s]，当前已完成 %2$s/%3$s", var1x, var6.size(), var8));
                        }
                     } else {
                        IService var16 = var15.getService(var2x);
                        if (var16.getSessionFactory() != var2x) {
                           synchronized (var6) {
                              var6.add(var1x);
                              PSModelV2Helper.log.debug(StringHelper.format("忽略计数[%1$s]，数据源不一致，当前已完成 %2$s/%3$s", var1x, var6.size(), var8));
                           }
                        } else {
                           try {
                              String var17 = StringHelper.format("SELECT COUNT(1) AS CNT FROM %1$s", var15.getTableName());
                              ArrayList<IEntity> var6x = var16.selectRaw(var17, null);
                              int var7x = DataObject.getIntegerValue(var6x.get(0), "CNT", 0);
                              var1.put(var1x, var7x);
                           } catch (Exception var10x) {
                              PSModelV2Helper.log.error(var10x);
                              var1.put(var1x, 0);
                           }

                           synchronized (var6) {
                              var6.add(var1x);
                              PSModelV2Helper.log.debug(StringHelper.format("计数[%1$s]，当前已完成 %2$s/%3$s", var1x, var6.size(), var8));
                           }
                        }
                     }
                  }
               } catch (Exception var14) {
                  PSModelV2Helper.log.error(var14);
                  if (StringHelper.isNullOrEmpty(var1x)) {
                     var7.add("未知模型");
                  } else {
                     var7.add(var1x);
                  }
               }
            }
         });
      }

      while (var6.size() != var8 && var7.size() == 0) {
         Thread.sleep(50L);
      }

      var9.shutdown();
      if (var7.size() > 0) {
         StringBuilderEx var14 = new StringBuilderEx();
         var14.append("模型计数发生错误：");
         boolean var11 = true;

         for (String var13 : var7) {
            if (var11) {
               var11 = false;
            } else {
               var14.append(",");
            }

            var14.append(var13);
         }

         throw new Exception(var14.toString());
      } else {
         log.debug(StringHelper.format("模型计数耗时[%1$s]", System.currentTimeMillis() - var2));
         return var1;
      }
   }

   protected void sendStudioConsoleRaw(String var1, String var2) {
      this.sendStudioConsoleRaw(var1, var2, null);
   }

   protected void sendStudioConsoleRaw(String var1, String var2, String var3) {
      if (PSStudioConsoleHelper.getCurrent() != null) {
         if (StringHelper.isNullOrEmpty(var1)) {
            var1 = this.getStudioConsoleId();
         }

         if (StringHelper.isNullOrEmpty(var1)) {
            return;
         }

         PSStudioConsoleHelper.getCurrent().sendConsole(var1, var2, var3);
      }
   }

   protected void sendStudioConsole(String var1, String var2, String var3) {
      this.sendStudioConsole(var1, var2, var3, null);
   }

   protected void sendStudioConsole(String var1, String var2, String var3, String var4) {
      if (PSStudioConsoleHelper.getCurrent() != null) {
         if (StringHelper.isNullOrEmpty(var1)) {
            var1 = this.getStudioConsoleId();
         }

         if (StringHelper.isNullOrEmpty(var1)) {
            return;
         }

         if (!StringHelper.isNullOrEmpty(var2)) {
            if (StringHelper.compare(var2, "INFO", false) == 0) {
               var3 = PSStudioConsoleHelper.getContent(var3, 34, -1, 0);
            } else if (StringHelper.compare(var2, "WARN", false) == 0) {
               var3 = PSStudioConsoleHelper.getContent(var3, 33, -1, 1);
            } else if (StringHelper.compare(var2, "ERROR", false) == 0) {
               var3 = PSStudioConsoleHelper.getContent(var3, 31, -1, 1);
            } else if (StringHelper.compare(var2, "DEBUG", false) == 0) {
               var3 = PSStudioConsoleHelper.getContent(var3, 37, -1, 0);
            } else {
               var3 = PSStudioConsoleHelper.getContent(var3, 32, -1, 0);
            }
         }

         PSStudioConsoleHelper.getCurrent().sendConsole(var1, var3, var4);
      }
   }

   public String getStudioConsoleId() {
      return this.strPSDSConsoleId;
   }

   public static boolean testExportModel(String var0) {
      return exportModelMap.containsKey(var0);
   }

   public static IDataObject fromJSONObject(IDataObject var0, ObjectNode var1, boolean var2) throws Exception {
      Iterator var3 = var1.fields();

      while (var3.hasNext()) {
         Entry var4 = (Entry)var3.next();
         String var5 = (String)var4.getKey();
         JsonNode var6 = (JsonNode)var4.getValue();

         try {
            if (var6 instanceof NullNode) {
               var0.set(var5, null);
            } else if (var6.isTextual()) {
               var0.set(var5, var6.asText());
            } else if (var6.isInt()) {
               var0.set(var5, ((IntNode)var6).intValue());
            } else if (var6.isDouble()) {
               var0.set(var5, ((DoubleNode)var6).asDouble());
            } else if (var6 instanceof ObjectNode) {
               ObjectNode var12 = (ObjectNode)var6;
               if (!var12.has("time") && !var12.has("timestr")) {
                  var0.set(var5, var12.toString());
               } else {
                  long var8 = 0L;
                  if (var12.has("timestr")) {
                     var8 = Long.parseLong(var12.get("timestr").asText());
                  } else {
                     var8 = var12.get("time").asLong();
                  }

                  Timestamp var10 = new Timestamp(var8);
                  var0.set(var5, var10);
               }
            } else if (var6 instanceof ArrayNode) {
               ArrayNode var7 = (ArrayNode)var6;
               var0.set(var5, var7.toString());
            } else {
               var0.set(var5, var6.asText());
            }
         } catch (Exception var11) {
            if (!var2) {
               throw var11;
            }
         }
      }

      return var0;
   }

   public static ObjectNode toJSONObject(IEntity var0, boolean var1) throws Exception {
      ObjectNode var2 = JsonNodeHelper.createObjectNode();
      HashMap<String, Object> var3 = new HashMap<>();
      var0.fillMap(var3, false);

      for (Entry var5 : var3.entrySet()) {
         if (var5.getValue() != null && var5.getValue() != DataObject.EMPTY) {
            if (var5.getValue() instanceof Timestamp) {
               Long var6 = ((Timestamp)var5.getValue()).getTime();
               ObjectNode var7 = JsonNodeHelper.createObjectNode();
               if (var6 < 0L) {
                  var7.put("timestr", Long.toString(var6));
               } else {
                  var7.put("time", var6);
               }

               JsonNodeHelper.put(var2, ((String)var5.getKey()).toLowerCase(), var7);
            } else {
               JsonNodeHelper.put(var2, ((String)var5.getKey()).toLowerCase(), var5.getValue());
            }
         }
      }

      return var2;
   }

   public static String toJSONString(IEntity var0, boolean var1) throws Exception {
      ObjectNode var2 = toJSONObject(var0, var1);
      return mapper.writeValueAsString(var2);
   }

   public static Iterator<String> getExportModelV2s() {
      return exportModelMap.keySet().iterator();
   }

   public static boolean containsModelV2(String var0) {
      return exportModelMap.containsKey(var0);
   }

   public static String getModelV2Name(String var0, boolean var1) {
      return var1 ? var0 : Inflector.getInstance().pluralize(var0).toUpperCase();
   }

   public static String getModelV2LogicName(String var0) {
      String var1 = modelLogicNameMap.get(var0);
      return !StringHelper.isNullOrEmpty(var1) ? var1 : var0;
   }

   public static boolean isCodeName(String var0) {
      Matcher var1 = codeNamePattern.matcher(var0);
      return var1.matches();
   }

   static {
      modelLogicNameMap.put("PSDETREECOL", "树视图表格列");
      modelLogicNameMap.put("PSDETREENODECOL", "树节点数据项");
      modelLogicNameMap.put("PSDEACTIONTEMPL", "系统实体行为模板");
      modelLogicNameMap.put("PSDATAENTITY", "实体");
      modelLogicNameMap.put("PSSYSTEM", "系统");
      modelLogicNameMap.put("PSDEFIELD", "实体属性");
      modelLogicNameMap.put("PSAPPVIEW", "应用视图");
      modelLogicNameMap.put("PSCODELIST", "代码表");
      modelLogicNameMap.put("PSDEACMODE", "实体自填模式");
      modelLogicNameMap.put("PSWORKFLOW", "工作流");
      modelLogicNameMap.put("PSWFVERSION", "工作流版本");
      modelLogicNameMap.put("PSWFROLE", "工作流角色");
      modelLogicNameMap.put("PSDELOGIC", "实体逻辑");
      modelLogicNameMap.put("PSDEDATAQUERY", "实体查询");
      modelLogicNameMap.put("PSDEDATASET", "实体结果集合");
      modelLogicNameMap.put("PSSYSAPP", "系统应用");
      modelLogicNameMap.put("PSDEPRINT", "实体打印");
      modelLogicNameMap.put("PSDEREPORT", "实体报表");
      modelLogicNameMap.put("PSPFPKGCAT", "应用框架包分类");
      modelLogicNameMap.put("PSCPVISSUE", "平台核心产品版本修复");
      modelLogicNameMap.put("PSAPPVIEWTEMPL", "应用视图模版");
      modelLogicNameMap.put("PSDCSFPKGVER", "中心服务框架组件版本");
      modelLogicNameMap.put("PSSYSUIACTION", "平台预置界面行为");
      modelLogicNameMap.put("PSMODELSFCODE", "模型后台代码");
      modelLogicNameMap.put("PSDEPSLN", "部署方案");
      modelLogicNameMap.put("PSDELOGICLINK", "实体处理逻辑连接");
      modelLogicNameMap.put("PSDEVSLNSYSTS", "开发系统任务加载");
      modelLogicNameMap.put("PSPFCTRLTEMPL", "应用部件代码模版");
      modelLogicNameMap.put("PSSYSCTRLSTYLE", "系统部件样式");
      modelLogicNameMap.put("PSSYSTEMAS", "系统应用服务器");
      modelLogicNameMap.put("PSDEDATARELATION", "实体关系界面组");
      modelLogicNameMap.put("PSSFCODETYPE", "后台技术架构框架代码");
      modelLogicNameMap.put("PSSYSBACKSERVICE", "系统后台任务");
      modelLogicNameMap.put("PSMODELAPIMETHOD", "平台API接口方法");
      modelLogicNameMap.put("PSPFSTYLELOG", "前台技术架构框架变更");
      modelLogicNameMap.put("PSSYSRUNSESSION", "系统运行会话");
      modelLogicNameMap.put("PSSFACHANDLER", "系统服务部件处理器");
      modelLogicNameMap.put("PSSYSDSACTION", "系统开发操作");
      modelLogicNameMap.put("PSDEFDTCOL", "属性数据列");
      modelLogicNameMap.put("PSPORTLETTYPE", "平台门户部件类型");
      modelLogicNameMap.put("PSDEAWITEM", "实体操作向导项");
      modelLogicNameMap.put("PSDEFVRTYPEDETAIL", "实体属性值规则类型明细");
      modelLogicNameMap.put("PSDEVSYSDIFFITEM", "应用系统差异项");
      modelLogicNameMap.put("PSDELOGICPARAM", "实体逻辑参数");
      modelLogicNameMap.put("PSDEPSLNMODE", "部署方案模式");
      modelLogicNameMap.put("PSSYSTDITEM", "系统测试数据项");
      modelLogicNameMap.put("PSDEVSLNSYSVER", "开发系统版本");
      modelLogicNameMap.put("PSSYSDATASYNCAGENT", "系统数据同步代理");
      modelLogicNameMap.put("PSSYSPOLICYMODEL", "平台系统策略模型项");
      modelLogicNameMap.put("PSDEMAINSTATE", "实体主状态");
      modelLogicNameMap.put("PSDEMAINSTATERS", "实体主状态关系");
      modelLogicNameMap.put("PSDEDBCFG", "实体数据库配置");
      modelLogicNameMap.put("PSWFLINKROLE", "流程处理连接角色");
      modelLogicNameMap.put("PSSYSUSERCASE", "系统用例");
      modelLogicNameMap.put("PSDEACTION", "实体行为");
      modelLogicNameMap.put("PSDEPSLNDBINST", "部署方案数据库实例");
      modelLogicNameMap.put("PSSUBDEVIEW", "子系统实体视图");
      modelLogicNameMap.put("PSAPPVIEWLOGIC", "视图逻辑");
      modelLogicNameMap.put("PSSYSSFPUBPKG", "后台服务体系组件");
      modelLogicNameMap.put("PSLANGUAGEITEM", "语言定义项");
      modelLogicNameMap.put("PSDEFVRTYPE", "实体属性值规则类型");
      modelLogicNameMap.put("PSSYSBDSCHEME", "系统大数据体系");
      modelLogicNameMap.put("PSDEACMODEITEM", "实体自填数据项");
      modelLogicNameMap.put("PSFORMDETAILTYPE", "平台表单成员类型");
      modelLogicNameMap.put("PSSYSWFSETTING", "系统流程配置");
      modelLogicNameMap.put("PSBDTYPE", "大数据库类型");
      modelLogicNameMap.put("PSDEJOINTYPE", "实体查询连接类型");
      modelLogicNameMap.put("PSMQINST", "平台MQ实例");
      modelLogicNameMap.put("PSDEVSLNUSER", "开发方案用户");
      modelLogicNameMap.put("PSVALUERULE", "平台值规则");
      modelLogicNameMap.put("PSDEGCTYPE", "实体表格列类型");
      modelLogicNameMap.put("PSSYSOPPRIV", "系统权限标识");
      modelLogicNameMap.put("PSPRODUCTTYPE", "平台产品类型");
      modelLogicNameMap.put("PSSYSWFMODE", "系统工作流模式");
      modelLogicNameMap.put("PSSYSSAMPLEVALUE", "系统示例值");
      modelLogicNameMap.put("PSDEDATAEXP", "实体数据导出");
      modelLogicNameMap.put("PSVIEWENGINE", "视图引擎");
      modelLogicNameMap.put("PSWXLOGIC", "微信交互逻辑");
      modelLogicNameMap.put("PSSYSDBCHGLOG", "系统模型变更日志");
      modelLogicNameMap.put("PSPFPKG", "应用组件包");
      modelLogicNameMap.put("PSPFPKGVER", "前端应用组件包版本");
      modelLogicNameMap.put("PSSYSCOUNTERITEM", "系统计数器项");
      modelLogicNameMap.put("PSDEUAGRPDETAIL", "实体界面行为组成员");
      modelLogicNameMap.put("PSAPPDEUAGRPDETAIL", "应用实体界面行为组成员");
      modelLogicNameMap.put("PSSYSAPPDEUAGRPDETAIL", "全局应用实体界面行为组成员");
      modelLogicNameMap.put("PSHELPSECTIONTYPE", "帮助文章章节类型");
      modelLogicNameMap.put("PSDEACTIONLOGIC", "实体行为逻辑");
      modelLogicNameMap.put("PSPFSTYLE", "应用样式");
      modelLogicNameMap.put("PSAPPEDITORTEMPL", "应用编辑器模版");
      modelLogicNameMap.put("PSMODELHOTCODE", "系统模型热代码");
      modelLogicNameMap.put("PSSYSBDTABLE", "大数据库表");
      modelLogicNameMap.put("PSHELPARTSEC", "帮助文章预置章节");
      modelLogicNameMap.put("PSVTCTRL", "平台视图类型部件");
      modelLogicNameMap.put("PSDBVALUEMODE", "数据库值模式");
      modelLogicNameMap.put("PSAPPFUNC", "应用功能");
      modelLogicNameMap.put("PSVIEWSTYLE", "平台视图样式");
      modelLogicNameMap.put("PSDECHARTPARAM", "实体图表数据序列");
      modelLogicNameMap.put("PSDEREPITEM", "实体报表项");
      modelLogicNameMap.put("PSTREENODETYPE", "平台树节点类型");
      modelLogicNameMap.put("PSCSSTEMPL", "平台界面样式表模板");
      modelLogicNameMap.put("PSDEFINPUTTIP", "属性输入提示");
      modelLogicNameMap.put("PSV3MIGRATEDE", "平台V3迁移实体");
      modelLogicNameMap.put("PSPFSTYLEPRJ", "前端应用样式项目");
      modelLogicNameMap.put("PSASBOOKINGLOG", "平台应用容器预约日志");
      modelLogicNameMap.put("PSSYSACHANDLER", "平台部件处理器");
      modelLogicNameMap.put("PSSYSMSGTEMPL", "系统消息模板");
      modelLogicNameMap.put("PSCODEITEM", "系统代码表项");
      modelLogicNameMap.put("PSFDLOGICTYPE", "平台表单成员逻辑类型");
      modelLogicNameMap.put("PSWXENTAPP", "微信企业应用");
      modelLogicNameMap.put("PSSUBDE", "平台子系统实体");
      modelLogicNameMap.put("PSDEUIACTIONTYPE", "实体界面行为类型");
      modelLogicNameMap.put("PSVIEWTYPECAT", "平台视图类型分类");
      modelLogicNameMap.put("PSSFCONFIG", "系统服务框架配置");
      modelLogicNameMap.put("PSV3MGGRID", "平台V3迁移表格");
      modelLogicNameMap.put("PSCOREPRDFUNC", "平台核心产品功能");
      modelLogicNameMap.put("PSSYSUNIT", "系统单位");
      modelLogicNameMap.put("PSPDTAPPFUNC", "平台预置应用功能");
      modelLogicNameMap.put("PSDEVIEWRV", "实体视图关联视图");
      modelLogicNameMap.put("PSSYSDICTCAT", "系统输入词条类别");
      modelLogicNameMap.put("PSTASKSERVER", "平台任务服务器");
      modelLogicNameMap.put("PSVIEWTYPELOGIC", "视图类型内置逻辑");
      modelLogicNameMap.put("PSAPPUITHEME", "应用界面主题");
      modelLogicNameMap.put("PSAPPLAN", "应用多语言");
      modelLogicNameMap.put("PSDEFSFITEM", "实体属性搜索项");
      modelLogicNameMap.put("PSHELPMODART", "帮助模块文章");
      modelLogicNameMap.put("PSDCBKTASK", "中心后台任务");
      modelLogicNameMap.put("PSDCDBPROC", "中心数据库过程");
      modelLogicNameMap.put("PSV3MGVIEW", "平台V3默认视图");
      modelLogicNameMap.put("PSSVNINSTREPO", "平台SVN仓库");
      modelLogicNameMap.put("PSAPPPKG", "系统应用组件包");
      modelLogicNameMap.put("PSASTYPE", "应用服务器类型");
      modelLogicNameMap.put("PSDEDSDQ", "实体数据集合查询");
      modelLogicNameMap.put("PSDBSPPARTTEMPL", "数据库系统过程成员模版");
      modelLogicNameMap.put("PSSYSDEVBKTASK", "系统开发后台任务");
      modelLogicNameMap.put("PSDETBITEM", "实体工具栏项");
      modelLogicNameMap.put("PSDEPSLNMODEPRD", "部署方案产品部署");
      modelLogicNameMap.put("PSDEVSLNSYS", "开发系统");
      modelLogicNameMap.put("PSSYSVALUERULE", "系统值规则");
      modelLogicNameMap.put("PSSYSPFPITEMPL", "前端插件模板");
      modelLogicNameMap.put("PSDEVRGRPDETAIL", "实体属性值规则组成员");
      modelLogicNameMap.put("PSAPPCTRLSTYLE", "应用部件样式");
      modelLogicNameMap.put("PSROSSERVER", "ROS服务器");
      modelLogicNameMap.put("PSDEDRITEM", "实体关系界面");
      modelLogicNameMap.put("PSDEACTIONTYPE", "实体行为类型");
      modelLogicNameMap.put("PSCOREPRDVER", "平台核心产品版本");
      modelLogicNameMap.put("PSPFVIEWTEMPL", "应用视图代码模版");
      modelLogicNameMap.put("PSSYSTASK", "TODO任务");
      modelLogicNameMap.put("PSVTSAMPLE", "视图类型示例");
      modelLogicNameMap.put("PSDBVFCODE", "数据库值函数代码");
      modelLogicNameMap.put("PSDELNPARAM", "实体处理逻辑节点参数");
      modelLogicNameMap.put("PSSVRSERVER", "平台系统主机");
      modelLogicNameMap.put("PSDECHARTAXES", "实体图像维度");
      modelLogicNameMap.put("PSUNKNOWN", "未知模型接口");
      modelLogicNameMap.put("PSTASKSERVERLOG", "任务服务器日志");
      modelLogicNameMap.put("PSSUBSYSSADETAIL", "外部服务接口成员");
      modelLogicNameMap.put("PSSVRDOMAIN", "平台服务域");
      modelLogicNameMap.put("PSHELPRESOURCE", "帮助资源");
      modelLogicNameMap.put("PSAPPUSERMODE", "应用用户模式");
      modelLogicNameMap.put("PSDERDEFMAP", "实体关系属性映射");
      modelLogicNameMap.put("PSCTRLMSGITEM", "部件消息项");
      modelLogicNameMap.put("PSDEVCENTERDBINST", "中心数据库实例");
      modelLogicNameMap.put("PSHELPARTICLETEMPL", "帮助文章模板");
      modelLogicNameMap.put("PSCODELISTTEMPL", "平台代码表模版");
      modelLogicNameMap.put("PSSFSTYLECODE", "系统服务框架宏");
      modelLogicNameMap.put("PSPDTVIEW", "平台预置视图");
      modelLogicNameMap.put("PSDEFVRDSPARAM", "实体属性值规则参数");
      modelLogicNameMap.put("PSDEVCENTERMQ", "中心MQ服务");
      modelLogicNameMap.put("PSDESPCODEPART", "系统存储过程代码块");
      modelLogicNameMap.put("PSDEVCENTERTS", "中心任务服务器");
      modelLogicNameMap.put("PSSYSUSERDR", "系统自定义数据范围");
      modelLogicNameMap.put("PSSYSOUTYPE", "系统组织单元类型");
      modelLogicNameMap.put("PSV3MIGRATE", "平台V3迁移");
      modelLogicNameMap.put("PSSFSTYLE", "服务框架");
      modelLogicNameMap.put("PSSYSDEVINFOTYPE", "系统开发信息类型");
      modelLogicNameMap.put("PSSYSTCINPUT", "测试用例输入");
      modelLogicNameMap.put("PSSYSTCINPUT2", "测试用例输入");
      modelLogicNameMap.put("PSDATASYNCAGENTTYPE", "数据同步代理类型");
      modelLogicNameMap.put("PSSYSLANITEM", "平台语言项");
      modelLogicNameMap.put("PSDEDSCODE", "实体数据集合代码");
      modelLogicNameMap.put("PSDCPRODUCT", "中心产品");
      modelLogicNameMap.put("PSDEDQPDCOND", "实体数据查询预置条件");
      modelLogicNameMap.put("PSSYSISSUEENGINE", "系统问题分析引擎");
      modelLogicNameMap.put("PSDCSFPKG", "中心服务框架组件包");
      modelLogicNameMap.put("PSDEVUSER", "中心用户");
      modelLogicNameMap.put("PSMIDETAIL", "模型初始化步骤");
      modelLogicNameMap.put("PSDEPSLNPRD", "部署方案产品");
      modelLogicNameMap.put("PSAPPFUNCTYPE", "应用功能类型");
      modelLogicNameMap.put("PSPFPLUGINTYPE", "应用框架插件类型");
      modelLogicNameMap.put("PSEDITORTYPE", "平台编辑器类型");
      modelLogicNameMap.put("PSSVRPROVIDER", "服务提供商");
      modelLogicNameMap.put("PSDCBKTYPE", "中心后台任务类型");
      modelLogicNameMap.put("PSMODELRS", "系统模型关系");
      modelLogicNameMap.put("PSWFSUBWF", "流程子流程");
      modelLogicNameMap.put("PSDEFDATATYPE", "实体属性数据类型");
      modelLogicNameMap.put("PSDEFVRCODETYPE", "平台属性规则代码类型");
      modelLogicNameMap.put("PSSFSTYLELOG", "服务框架变更");
      modelLogicNameMap.put("PSDESPFIELD", "系统存储过程属性");
      modelLogicNameMap.put("PSPFSTYLEPKG", "前端应用样式组件包");
      modelLogicNameMap.put("PSMODELREF", "模型引用");
      modelLogicNameMap.put("PSHELPSECTIONTEMPL", "帮助章节模板");
      modelLogicNameMap.put("PSDEFFORMITEM", "属性表单项模式");
      modelLogicNameMap.put("PSSYSREQMODULE", "系统需求模块");
      modelLogicNameMap.put("PSDRITEMTYPE", "平台数据关系项类型");
      modelLogicNameMap.put("PSSYSDEVBTTYPE", "系统开发后台任务类型");
      modelLogicNameMap.put("PSSUBSYSSERVICEAPI", "外部服务接口");
      modelLogicNameMap.put("PSDCSYSPRODUCT", "中心系统产品");
      modelLogicNameMap.put("PSDECTRL", "实体部件配置");
      modelLogicNameMap.put("PSDEPSLNRUNLOG", "部署方案运行日志");
      modelLogicNameMap.put("PSSYSBDPART", "大数据分区");
      modelLogicNameMap.put("PSSYSTOOLBAR", "平台预置工具栏");
      modelLogicNameMap.put("PSDEDRGROUP", "实体关系界面分组");
      modelLogicNameMap.put("PSDEDQCOND", "实体数据查询条件");
      modelLogicNameMap.put("PSCPVFUNC", "平台核心产品版本功能");
      modelLogicNameMap.put("PSDEFGRIDCOL", "实体属性表格列");
      modelLogicNameMap.put("PSDCDBFUNC", "中心数据库函数");
      modelLogicNameMap.put("PSDEFIUDETAIL", "实体表单项更新明细");
      modelLogicNameMap.put("PSWXMENUITEM", "微信菜单项");
      modelLogicNameMap.put("PSDEVRGROUP", "实体属性值规则组");
      modelLogicNameMap.put("PSDEVSLNSYSKEY", "开发系统访问标识");
      modelLogicNameMap.put("PSDEVCENTERRES", "中心资源");
      modelLogicNameMap.put("PSCTRLTYPEACTION", "平台部件操作");
      modelLogicNameMap.put("PSSUBSYSDM", "子系统数据库结构");
      modelLogicNameMap.put("PSDEVUSERRECENT", "应用用户最近访问");
      modelLogicNameMap.put("PSSYSTEMDBCFG", "系统数据库");
      modelLogicNameMap.put("PSSYSPRDVER", "系统商品版本");
      modelLogicNameMap.put("PSWXMENU", "微信菜单");
      modelLogicNameMap.put("PSSAMPLEVALUE", "平台示例值");
      modelLogicNameMap.put("PSBDSERVER", "平台大数据服务器");
      modelLogicNameMap.put("PSWXACCOUNT", "微信公众号");
      modelLogicNameMap.put("PSSYSDMITEM", "系统数据库模型项");
      modelLogicNameMap.put("PSSYSTASKDATA", "系统开发任务讨论");
      modelLogicNameMap.put("PSWFPROCPARAM", "流程处理参数");
      modelLogicNameMap.put("PSWFPROCROLE", "流程处理角色");
      modelLogicNameMap.put("PSDEVENV", "开发环境");
      modelLogicNameMap.put("PSDELISTITEM", "实体列表项");
      modelLogicNameMap.put("PSSYSSFCODE", "系统服务自定义代码");
      modelLogicNameMap.put("PSDESYSPROC", "实体系统存储过程");
      modelLogicNameMap.put("PSSYSMODELVER", "系统模型版本");
      modelLogicNameMap.put("PSSFPKGCAT", "服务框架包分类");
      modelLogicNameMap.put("PSHELPPRJ", "系统帮助项目");
      modelLogicNameMap.put("PSSYSIMAGE", "系统图片资源");
      modelLogicNameMap.put("PSSUBAPP", "平台子系统应用");
      modelLogicNameMap.put("PSBACKSERVICE", "平台预置后台任务");
      modelLogicNameMap.put("PSAPPVIEWSTYLE", "应用视图样式（已废弃）");
      modelLogicNameMap.put("PSDEDBINDEX", "实体数据库索引");
      modelLogicNameMap.put("PSCTRLTYPE", "平台部件类型");
      modelLogicNameMap.put("PSAPPPORTALVIEW", "应用门户视图");
      modelLogicNameMap.put("PSSYSDEVINFO", "系统开发信息");
      modelLogicNameMap.put("PSDCSYSPRDVER", "中心系统产品版本");
      modelLogicNameMap.put("PSSYSREQITEMDATA", "需求项讨论");
      modelLogicNameMap.put("PSAPPVIEWCODE", "系统应用自定义代码");
      modelLogicNameMap.put("PSUNIT", "平台预置单位");
      modelLogicNameMap.put("PSSYSREFDE", "系统引用实体");
      modelLogicNameMap.put("PSSYSBDTABLERS", "大数据表关系");
      modelLogicNameMap.put("PSDER_DER11", "实体关系（1:1）");
      modelLogicNameMap.put("PSSUBSYSVER", "平台子系统版本");
      modelLogicNameMap.put("PSDEGEIUPDATE", "表格编辑项更新模式");
      modelLogicNameMap.put("PSMODELAPIRS", "系统模型API关系");
      modelLogicNameMap.put("PSSYSCSSCAT", "系统样式表分类");
      modelLogicNameMap.put("PSHELPSECTION", "帮助章节");
      modelLogicNameMap.put("PSDETREENODERV", "树节点关联视图");
      modelLogicNameMap.put("PSWFDE", "工作流实体");
      modelLogicNameMap.put("PSDEDUPRULE", "实体数据重复规则");
      modelLogicNameMap.put("PSSYSMODELFUNCTEMPL", "系统模型功能模板实现");
      modelLogicNameMap.put("PSPFPLUGINTEMPL", "平台预置应用框架插件模板");
      modelLogicNameMap.put("PSAPPUTILPAGE", "应用功能页面");
      modelLogicNameMap.put("PSSFSTYLEVER", "服务框架扩展");
      modelLogicNameMap.put("PSSUBDEACTION", "平台子实体操作");
      modelLogicNameMap.put("PSVTSTYLE", "平台视图类型样式");
      modelLogicNameMap.put("PSSYSEDITORSTYLE", "系统编辑器样式");
      modelLogicNameMap.put("PSVIEWLOGICTYPE", "视图预置逻辑");
      modelLogicNameMap.put("PSSFVERCODE", "系统服务扩展代码模板");
      modelLogicNameMap.put("PSPFCTDETAIL", "应用部件代码模版成员");
      modelLogicNameMap.put("PSSYSDEPLOYDB", "系统部署数据库");
      modelLogicNameMap.put("PSDEVSERVER", "平台开发主机");
      modelLogicNameMap.put("PSSYSDBVFCODE", "系统数据库值函数代码");
      modelLogicNameMap.put("PSDCCOREPRDISSUE", "中心核心产品问题");
      modelLogicNameMap.put("PSWFPROCESS", "流程处理");
      modelLogicNameMap.put("PSSFVERCODEITEM", "系统服务框架版本代码项");
      modelLogicNameMap.put("PSDER_DERMULINH", "实体关系（多继承）");
      modelLogicNameMap.put("PSSYSSERVICEAPI", "系统服务接口");
      modelLogicNameMap.put("PSSYSISSUE", "系统问题");
      modelLogicNameMap.put("PSDEVUSEROBJ", "中心用户对象");
      modelLogicNameMap.put("PSSYSREQITEM", "系统需求项");
      modelLogicNameMap.put("PSDEVCENTERSF", "中心服务框架");
      modelLogicNameMap.put("PSSYSPFPLUGIN", "系统前端插件");
      modelLogicNameMap.put("PSCTRLMSG", "部件消息");
      modelLogicNameMap.put("PSDBVALUEOP", "数据库值操作符");
      modelLogicNameMap.put("PSDEPSLNASGRP", "部署方案应用服务器组");
      modelLogicNameMap.put("PSAPPSERVER", "平台应用服务器");
      modelLogicNameMap.put("PSSFSTYLEPRJ", "服务框架项目");
      modelLogicNameMap.put("PSDEDQJOIN", "实体数据查询连接");
      modelLogicNameMap.put("PSDEPSLNAS", "部署方案应用服务器");
      modelLogicNameMap.put("PSMODELINIT", "模型初始化配置");
      modelLogicNameMap.put("PSDEFORM", "实体表单");
      modelLogicNameMap.put("PSSYSISSUETYPE", "系统问题类型");
      modelLogicNameMap.put("PSCOUNTER", "平台预置计数器");
      modelLogicNameMap.put("PSIMAGETEMPL", "平台图片模版");
      modelLogicNameMap.put("PSDEDBOBJSQL", "实体数据库对象代码");
      modelLogicNameMap.put("PSDECHART", "实体图表");
      modelLogicNameMap.put("PSSYSUSERMODE", "系统用户模式");
      modelLogicNameMap.put("PSSUBSYSSF", "平台子系统服务体系");
      modelLogicNameMap.put("PSMODELAPI", "平台API");
      modelLogicNameMap.put("PSSFPKGVER", "服务框架组件版本");
      modelLogicNameMap.put("PSCOREPRDCAT", "平台核心产品分类");
      modelLogicNameMap.put("PSDER_DER1N", "实体关系（1:N）");
      modelLogicNameMap.put("PSDESADETAIL", "实体服务接口成员");
      modelLogicNameMap.put("PSSYSPRODUCT", "平台系统产品");
      modelLogicNameMap.put("PSSYSACTOR", "系统角色");
      modelLogicNameMap.put("PSACHANDLER", "部件后台处理");
      modelLogicNameMap.put("PSDEVCENTERLOG", "中心日志");
      modelLogicNameMap.put("PSSYSRUNLOG", "系统运行日志");
      modelLogicNameMap.put("PSDEVUSERMODEL", "用户访问模型");
      modelLogicNameMap.put("PSAPPMENU", "应用菜单");
      modelLogicNameMap.put("PSDEGRID", "实体表格");
      modelLogicNameMap.put("PSVIEWTYPE", "平台视图类型");
      modelLogicNameMap.put("PSDBDEVINST", "平台数据库开发实例");
      modelLogicNameMap.put("PSHELPARTICLETYPE", "帮助文章类型");
      modelLogicNameMap.put("PSDEVCENTERSERVER", "中心主机");
      modelLogicNameMap.put("PSTSCMD", "任务服务器后台命令");
      modelLogicNameMap.put("PSDEPSLNASITEM", "部署方案应用服务器组成员");
      modelLogicNameMap.put("PSDEUAGROUP", "实体界面行为组");
      modelLogicNameMap.put("PSAPPDEUAGROUP", "应用实体界面行为组");
      modelLogicNameMap.put("PSSYSAPPDEUAGROUP", "全局应用实体界面行为组");
      modelLogicNameMap.put("PSDCDBTABLE", "中心数据库表");
      modelLogicNameMap.put("PSSFEXCEPTION", "系统服务体系异常对象");
      modelLogicNameMap.put("PSDELOGICNODE", "实体处理逻辑节点");
      modelLogicNameMap.put("PSPFEDITORTEMPL", "前台编辑器模版");
      modelLogicNameMap.put("PSSYSUSERCASERS", "系统用例关系");
      modelLogicNameMap.put("PSDEVSYSDIFFREP", "开发系统差异分析");
      modelLogicNameMap.put("PSSVNSERVER", "SVN服务器");
      modelLogicNameMap.put("PSDELLCOND", "实体处理逻辑连接条件");
      modelLogicNameMap.put("PSCOUNTERTYPESF", "平台计数器类型服务框架");
      modelLogicNameMap.put("PSDBSERVER", "平台数据库主机");
      modelLogicNameMap.put("PSSYSTESTDATA", "系统测试数据");
      modelLogicNameMap.put("PSCSSCATTEMPL", "平台样式表分类模板");
      modelLogicNameMap.put("PSSYSUNIRES", "系统统一资源");
      modelLogicNameMap.put("PSDEPSLNLOG", "部署方案操作日志");
      modelLogicNameMap.put("PSDCDBSEQU", "中心数据库序列");
      modelLogicNameMap.put("PSSYSDEPLOY", "系统部署");
      modelLogicNameMap.put("PSSYSDSACTIONTYPE", "系统开发环境操作类型");
      modelLogicNameMap.put("PSDEDQCODE", "数据数据查询代码");
      modelLogicNameMap.put("PSCOUNTERTYPE", "平台计数器类型");
      modelLogicNameMap.put("PSCTRLEVENT", "控件事件");
      modelLogicNameMap.put("PSDCBULLETIN", "中心公告");
      modelLogicNameMap.put("PSSFSTYLEPKG", "服务框架样式组件");
      modelLogicNameMap.put("PSVIEWWIZARDGROUP", "视图向导组");
      modelLogicNameMap.put("PSCTRLTYPEEVENT", "平台部件事件");
      modelLogicNameMap.put("PSDEVSERVERLEASE", "开发主机租约");
      modelLogicNameMap.put("PSDCMTDEF", "模型模板预置属性");
      modelLogicNameMap.put("PSDEUIACTION", "实体界面行为");
      modelLogicNameMap.put("PSLANGUAGERES", "语言资源");
      modelLogicNameMap.put("PSDEMSACTION", "主状态操作行为");
      modelLogicNameMap.put("PSSYSBDTABLEDE", "大数据表实体关系");
      modelLogicNameMap.put("PSVIEWMSG", "视图消息");
      modelLogicNameMap.put("PSDCTASKLOG", "中心后台作业日志");
      modelLogicNameMap.put("PSPFVLTEMPL", "视图逻辑模版");
      modelLogicNameMap.put("PSROBOT", "平台机器人");
      modelLogicNameMap.put("PSDESERVICEAPI", "实体服务接口");
      modelLogicNameMap.put("PSSYSERMAP", "系统ER图");
      modelLogicNameMap.put("PSDEDQCODECOND", "实体查询代码条件");
      modelLogicNameMap.put("PSHELPARTICLE", "帮助文章");
      modelLogicNameMap.put("PSPORTLET", "平台预置门户部件");
      modelLogicNameMap.put("PSSYSTEMRUN", "系统运行");
      modelLogicNameMap.put("PSSYSPOLICY", "平台系统策略");
      modelLogicNameMap.put("PSWFLINK", "流程处理连接");
      modelLogicNameMap.put("PSV3MGFORM", "平台V3迁移表单");
      modelLogicNameMap.put("PSSYSLANRES", "平台语言资源");
      modelLogicNameMap.put("PSAPPVIEWREF", "视图引用");
      modelLogicNameMap.put("PSDEVSLN", "开发方案");
      modelLogicNameMap.put("PSDCBDINST", "中心大数据库实例");
      modelLogicNameMap.put("PSVTRV", "平台视图类型关联视图");
      modelLogicNameMap.put("PSDCSYSRES", "中心系统资源");
      modelLogicNameMap.put("PSDEWIZARD", "实体向导");
      modelLogicNameMap.put("PSSYSMODELFUNC", "系统模型功能");
      modelLogicNameMap.put("PSSYSREQITEMHIS", "需求项备份");
      modelLogicNameMap.put("PSMOBAPPPACK", "移动应用打包");
      modelLogicNameMap.put("PSWFLINKCOND", "流程处理连接条件");
      modelLogicNameMap.put("PSSYSTEMMQ", "系统MQ");
      modelLogicNameMap.put("PSPFPLUGIN", "平台预置应用框架插件");
      modelLogicNameMap.put("PSDEVCENTERSRV", "中心服务");
      modelLogicNameMap.put("PSSYSDBDETAIL", "系统数据库发布版本");
      modelLogicNameMap.put("PSDEMAPDETAIL", "实体映射明细");
      modelLogicNameMap.put("PSSTUDIOSERVER", "开发工具服务器");
      modelLogicNameMap.put("PSSYSPDTVIEW", "系统预置视图");
      modelLogicNameMap.put("PSVARTYPE", "平台变量类型");
      modelLogicNameMap.put("PSDEFIUPDATE", "实体表单项更新");
      modelLogicNameMap.put("PSWFPROCESSTYPE", "系统流程处理类型");
      modelLogicNameMap.put("PSWFWORKTIME", "流程工作时间");
      modelLogicNameMap.put("PSAPPMODULE", "应用模块");
      modelLogicNameMap.put("PSSUBAPPVIEW", "平台子系统应用视图");
      modelLogicNameMap.put("PSWFLINKTYPE", "系统流程连接类型");
      modelLogicNameMap.put("PSSUBVIEWTYPE", "系统视图样式");
      modelLogicNameMap.put("PSUAWIZARD", "实体界面操作向导");
      modelLogicNameMap.put("PSVIEWMSGGRPDETAIL", "视图消息成员");
      modelLogicNameMap.put("PSDEDSPARAM", "实体数据集合参数");
      modelLogicNameMap.put("PSSYSMODELINST", "系统模型实例");
      modelLogicNameMap.put("PSDEFORMDETAIL", "实体表单成员");
      modelLogicNameMap.put("PSDBPROCPARAM", "系统存储过程参数");
      modelLogicNameMap.put("PSDCSERVER", "平台中心服务器");
      modelLogicNameMap.put("PSDEGRIDCOL", "实体表格列");
      modelLogicNameMap.put("PSSFCODETEMPL", "系统服务代码模版");
      modelLogicNameMap.put("PSWFPROCSUBWF", "流程处理子流程");
      modelLogicNameMap.put("PSDEDATASYNC", "实体数据同步");
      modelLogicNameMap.put("PSPFAPPTEMPL", "应用应用代码模版");
      modelLogicNameMap.put("PSDCDBOBJ", "中心实例命令记录");
      modelLogicNameMap.put("PSDEDQCODEEXP", "实体查询代码表达式");
      modelLogicNameMap.put("PSHELPMODULE", "帮助模块");
      modelLogicNameMap.put("PSDEVSERVERTYPE", "开发桌面类型");
      modelLogicNameMap.put("PSDERGROUP", "实体关系组");
      modelLogicNameMap.put("PSMODELPFCODE", "模型前台代码");
      modelLogicNameMap.put("PSAPPPVPART", "应用门户视图部件");
      modelLogicNameMap.put("PSDEGEIUDETAIL", "表格编辑项更新成员");
      modelLogicNameMap.put("PSSFPKG", "服务框架组件包");
      modelLogicNameMap.put("PSMODEL", "系统模型");
      modelLogicNameMap.put("PSFORMTYPE", "平台表单类型");
      modelLogicNameMap.put("PSCTRLACTION", "控件行为");
      modelLogicNameMap.put("PSSYSBDCOLUMN", "大数据列");
      modelLogicNameMap.put("PSSYSTCASSERT", "测试用例断言");
      modelLogicNameMap.put("PSSYSTCASSERT2", "测试用例断言");
      modelLogicNameMap.put("PSDEFDLOGIC", "体表单成员逻辑项");
      modelLogicNameMap.put("PSSYSTESTCASE", "系统测试用例");
      modelLogicNameMap.put("PSSYSTESTCASE2", "测试用例");
      modelLogicNameMap.put("PSDETREENODERS", "实体树节点关系");
      modelLogicNameMap.put("PSSYSDEVSTUDIO", "系统开发用户");
      modelLogicNameMap.put("PSDERTYPE", "实体关系类型");
      modelLogicNameMap.put("PSSYSMODELLOG", "系统模型变更");
      modelLogicNameMap.put("PSSYSORGTYPE", "系统组织类型");
      modelLogicNameMap.put("PSSYSCOUNTER", "系统计数器");
      modelLogicNameMap.put("PSSUBSYS", "平台子系统");
      modelLogicNameMap.put("PSDEVIEWCTRL", "实体视图部件");
      modelLogicNameMap.put("PSDCMTDECAT", "模型模板实体分类");
      modelLogicNameMap.put("PSDEVCENTERAS", "中心应用服务器");
      modelLogicNameMap.put("PSAMITEMTYPE", "应用菜单项类型");
      modelLogicNameMap.put("PSDEVCENTER", "中心");
      modelLogicNameMap.put("PSEDITORSTYLE", "平台预置编辑器样式");
      modelLogicNameMap.put("PSBKTASKLOG", "平台后台任务日志");
      modelLogicNameMap.put("PSLISTITEMTYPE", "平台列表项类型");
      modelLogicNameMap.put("PSSYSDEPLOYAS", "系统部署应用服务器");
      modelLogicNameMap.put("PSVIEWMSGGROUP", "视图消息组");
      modelLogicNameMap.put("PSDER", "实体关系");
      modelLogicNameMap.put("PSDCDBINDEX", "中心数据库索引");
      modelLogicNameMap.put("PSDBOBJTYPE", "平台数据库对象类型");
      modelLogicNameMap.put("PSAPPUISTYLE", "应用界面样式");
      modelLogicNameMap.put("PSSYSREPORT", "系统报表");
      modelLogicNameMap.put("PSCOREPRD", "平台核心产品");
      modelLogicNameMap.put("PSDEMODELCNT", "实体模型计数");
      modelLogicNameMap.put("PSPFPUBCODE", "应用框架发布代码");
      modelLogicNameMap.put("PSDEFTYPE", "实体属性类型");
      modelLogicNameMap.put("PSSF", "后台技术架构");
      modelLogicNameMap.put("PSLANGUAGE", "平台语言");
      modelLogicNameMap.put("PSDEDATAIMP", "实体数据导入");
      modelLogicNameMap.put("PSPRODUCT", "平台产品");
      modelLogicNameMap.put("PSDEFIVR", "实体表单项值规则");
      modelLogicNameMap.put("PSMODELAPIINT", "平台API接口");
      modelLogicNameMap.put("PSSYSOUTYPERS", "系统组织单元类型关系");
      modelLogicNameMap.put("PSAPPMENUITEM", "应用菜单项");
      modelLogicNameMap.put("PSDEVSLNSYSPATCH", "系统打包版本补丁");
      modelLogicNameMap.put("PSDEACTIONWIZARD", "实体操作向导");
      modelLogicNameMap.put("PSDEVIEWLOGIC", "实体视图逻辑");
      modelLogicNameMap.put("PSDEFORMRF", "实体表单引用");
      modelLogicNameMap.put("PSSYSVIEWPANEL", "系统面板");
      modelLogicNameMap.put("PSWFLINKCONDTYPE", "流程连接条件类型");
      modelLogicNameMap.put("PSSYSDEPLOYAPP", "系统部署应用");
      modelLogicNameMap.put("PSVTCATDETAIL", "视图类型分类成员");
      modelLogicNameMap.put("PSAPPTYPE", "应用类型");
      modelLogicNameMap.put("PSSYSBDCOLSET", "大数据表列族");
      modelLogicNameMap.put("PSPFSTYLECODE", "应用样式宏代码");
      modelLogicNameMap.put("PSDEDSGRPPARAM", "实体数据集分组参数");
      modelLogicNameMap.put("PSDBSYSPROCTEMPL", "数据库系统过程模版");
      modelLogicNameMap.put("PSDETOOLBAR", "实体工具栏");
      modelLogicNameMap.put("PSDEDUPRULEITEM", "实体数据重复规则项");
      modelLogicNameMap.put("PSDETREENODE", "实体树节点");
      modelLogicNameMap.put("PSSYSTBITEM", "平台预置工具栏项");
      modelLogicNameMap.put("PSDEWIZARDSTEP", "实体向导步骤");
      modelLogicNameMap.put("PSSYSPORTLET", "系统门户部件");
      modelLogicNameMap.put("PSDEDRDETAIL", "实体界面组成员");
      modelLogicNameMap.put("PSWXMENUFUNC", "微信菜单功能");
      modelLogicNameMap.put("PSDEVCENTERPF", "中心应用框架");
      modelLogicNameMap.put("PSDEDATAVIEW", "实体卡片视图");
      modelLogicNameMap.put("PSDELNTYPE", "实体逻辑处理节点类型");
      modelLogicNameMap.put("PSPFCODEFOLDER", "应用代码目录");
      modelLogicNameMap.put("PSSFCODEFOLDER", "系统服务代码目录");
      modelLogicNameMap.put("PSSYSMODELACTION", "系统模块实例操作");
      modelLogicNameMap.put("PSCOREPRDISSUE", "平台核心产品问题");
      modelLogicNameMap.put("PSDEVIEWBASE", "实体视图");
      modelLogicNameMap.put("PSSYSPROJECT", "系统工程项目");
      modelLogicNameMap.put("PSDBTYPE", "数据库类型");
      modelLogicNameMap.put("PSDBSYSPROCTYPE", "数据库系统过程类型");
      modelLogicNameMap.put("PSDEAWGRPDETAIL", "实体操作向导组成员");
      modelLogicNameMap.put("PSDEMAP", "实体映射");
      modelLogicNameMap.put("PSDELLTYPE", "实体逻辑处理连接类型");
      modelLogicNameMap.put("PSDEWIZARDFORM", "实体向导表单");
      modelLogicNameMap.put("PSAPPSUBAPP", "应用子应用");
      modelLogicNameMap.put("PSDEDBIDXFIELD", "实体数据库索引属性");
      modelLogicNameMap.put("PSSYSDMITEMLOG", "系统数据库模型关键变更");
      modelLogicNameMap.put("PSTBITEMTYPE", "平台工具栏项类型");
      modelLogicNameMap.put("PSDCMODELTEMPL", "中心模型模板");
      modelLogicNameMap.put("PSDESPCODE", "系统存储过程代码");
      modelLogicNameMap.put("PSBDDEVINST", "平台大数据实例");
      modelLogicNameMap.put("PSDBVALUEFUNC", "数据库值函数");
      modelLogicNameMap.put("PSPFUATEMPL", "应用界面行为代码模版");
      modelLogicNameMap.put("PSCODENAME", "代码名称库");
      modelLogicNameMap.put("PSUAWIZARD2", "界面操作向导2");
      modelLogicNameMap.put("PSDCSERVERSTATE", "中心主机状态");
      modelLogicNameMap.put("PSSYSSFPUB", "系统后台服务体系");
      modelLogicNameMap.put("PSSYSDBVF", "系统数据库值函数");
      modelLogicNameMap.put("PSDEVCENTERSVN", "中心代码库");
      modelLogicNameMap.put("PSHELPARTICLECAT", "帮助文章分类");
      modelLogicNameMap.put("PSDELIST", "实体列表");
      modelLogicNameMap.put("PSDEFVRCOND", "实体属性值规则项");
      modelLogicNameMap.put("PSSYSCSS", "系统界面样式表");
      modelLogicNameMap.put("PSDEVSLNSYSMODEL", "开发系统模型");
      modelLogicNameMap.put("PSDCINST", "中心实例");
      modelLogicNameMap.put("PSMODULE", "系统模块");
      modelLogicNameMap.put("PSSYSERMAPNODE", "系统ER图节点");
      modelLogicNameMap.put("PSSYSREF", "系统引用");
      modelLogicNameMap.put("PSSYSVIEWLOGIC", "预置视图逻辑");
      modelLogicNameMap.put("PSDCDBVIEW", "中心数据库视图");
      modelLogicNameMap.put("PSDEVUSERGROUP", "中心用户组");
      modelLogicNameMap.put("PSDEFVALUERULE", "实体属性值规则");
      modelLogicNameMap.put("PSDELLCONDTYPE", "实体逻辑处理连接条件类型");
      modelLogicNameMap.put("PSSYSBDINSTCFG", "系统大数据实例配置");
      modelLogicNameMap.put("PSDEVUSERSQL", "开发用户文件");
      modelLogicNameMap.put("PSDETREEVIEW", "实体树视图");
      modelLogicNameMap.put("PSCHARTTYPE", "平台图表类型");
      modelLogicNameMap.put("PSAPPDEVIEW", "应用实体视图");
      modelLogicNameMap.put("PSDEAWGROUP", "实体操作向导组");
      modelLogicNameMap.put("PSAPPINDEXVIEW", "应用首页视图");
      modelLogicNameMap.put("PSDEOPPRIV", "实体操作权限");
      modelLogicNameMap.put("PSPF", "前台技术架构");
      modelLogicNameMap.put("PSHELPPRJTYPE", "帮助项目类型");
      modelLogicNameMap.put("PSHELPPRJTEMPL", "帮助项目模板");
      modelLogicNameMap.put("PSMODELPLUGIN", "平台模型插件");
      modelLogicNameMap.put("PSMODELMODULE", "系统模型模块");
      modelLogicNameMap.put("PSVARSAMPLEVALUE", "平台变量示例值");
      modelLogicNameMap.put("PSCOREPRDINSTLOG", "核心产品安装日志");
      modelLogicNameMap.put("PSMODELSECTION", "系统模块章节");
      modelLogicNameMap.put("PSMODELEXAMPLE", "系统模型例子");
      modelLogicNameMap.put("PSMODELRESOURCE", "系统模型资源");
      modelLogicNameMap.put("PSRTWXACCOUNT", "平台运行微信企业号");
      modelLogicNameMap.put("PSDERGROUPDETAIL", "实体关系组成员");
      modelLogicNameMap.put("PSROBOTWORK", "机器人作业");
      modelLogicNameMap.put("PSDEMSOPPRIV", "主状态操作标识");
      modelLogicNameMap.put("PSMODELOBJ", "模型对象");
      modelLogicNameMap.put("PSSYSVIEWPANELITEM", "系统视图面板成员");
      modelLogicNameMap.put("PSDEFGROUPDETAIL", "实体属性组成员");
      modelLogicNameMap.put("PSDEFGROUP", "实体属性组");
      modelLogicNameMap.put("PSSYSSEARCHBAR", "搜索栏");
      modelLogicNameMap.put("PSSYSBDTABLEDER", "大数据表关系");
      modelLogicNameMap.put("PSSYSBDMODULE", "大数据体系模块");
      modelLogicNameMap.put("PSDEPSLNSYSAS", "部署方案系统部署");
      modelLogicNameMap.put("PSDEPSLNSYSMQ", "部署方案系统MQ");
      modelLogicNameMap.put("PSDEPSLNSYSDB", "部署方案系统数据库");
      modelLogicNameMap.put("PSDEPSLNMQINST", "部署方案MQ实例");
      modelLogicNameMap.put("PSDEPSLNSYS", "部署方案系统");
      modelLogicNameMap.put("PSSTUDIOSERVERGRP", "平台开发工具服务器组");
      modelLogicNameMap.put("PSDEPSAASSYSAPP", "部署SaaS系统应用（暂时废弃）");
      modelLogicNameMap.put("PSDEPSAASSYSVER", "部署SaaS系统版本（暂时废弃）");
      modelLogicNameMap.put("PSDEPSAASSYS", "部署SaaS系统（暂时废弃）");
      modelLogicNameMap.put("PSDEPSYSAPP", "部署系统应用");
      modelLogicNameMap.put("PSDEPSYS", "可部署系统");
      modelLogicNameMap.put("PSDEPSYSVER", "可部署系统版本");
      modelLogicNameMap.put("PSDEPSLNHOST", "部署方案主机");
      modelLogicNameMap.put("PSSAASSYSDB", "SaaS系统数据库");
      modelLogicNameMap.put("PSDEPSLNPACK", "部署方案打包");
      modelLogicNameMap.put("PSDEPSLNDEPSESSION", "部署方案部署操作");
      modelLogicNameMap.put("PSGITUSER", "平台GIT用户");
      modelLogicNameMap.put("PSNDFILE", "平台网盘文件");
      modelLogicNameMap.put("PSNDFILELINK", "平台网盘文件链接");
      modelLogicNameMap.put("PSSYSENGINECFG", "系统引擎配置");
      modelLogicNameMap.put("PSDEVPRD", "开发产品");
      modelLogicNameMap.put("PSDEVPRDVER", "开发产品主干");
      modelLogicNameMap.put("PSDEVPRDSUBVER", "开发产品版本");
      modelLogicNameMap.put("PSDEVPRDSYS", "开发产品系统");
      modelLogicNameMap.put("PSDEVPRDSYSSYNC", "开发产品系统同步");
      modelLogicNameMap.put("PSDSBOOKINGLOG", "平台开发主机预约日志");
      modelLogicNameMap.put("PSDCDBINSTREF", "中心数据库实例引用");
      modelLogicNameMap.put("PSDEVPRDSYSSYNCITEM", "开发产品系统同步项");
      modelLogicNameMap.put("PSDEVPRDSPEC", "开发产品规格");
      modelLogicNameMap.put("PSDEVPRDSEPCPLAN", "开发产品规范计划（废弃）");
      modelLogicNameMap.put("PSDEVPRDSPECPLAN", "开发产品规范计划");
      modelLogicNameMap.put("PSDEVSLNSYSRES", "开发系统资源包");
      modelLogicNameMap.put("PSPFCDN", "应用框架CDN");
      modelLogicNameMap.put("PSPFEDITORTYPE", "前端编辑器参数");
      modelLogicNameMap.put("PSMODELERROR", "系统模型错误");
      modelLogicNameMap.put("PSPFPKGVERCDN", "前端应用组件包版本CDN");
      modelLogicNameMap.put("PSSYSMODELFUNCCAT", "系统模型功能分类");
      modelLogicNameMap.put("PSMODELSTATE", "模型状态");
      modelLogicNameMap.put("PSMODELVALUEGROUP", "系统模型值组");
      modelLogicNameMap.put("PSMODELFIELDVALUE", "系统模型属性取值");
      modelLogicNameMap.put("PSMODELFIELD", "系统模型属性");
      modelLogicNameMap.put("PSSFVIEWTYPE", "后台服务视图参数");
      modelLogicNameMap.put("PSSFCTRLTYPE", "后台服务部件参数");
      modelLogicNameMap.put("PSPFVIEWTYPE", "前端视图参数");
      modelLogicNameMap.put("PSPFCTRLTYPE", "前端部件参数");
      modelLogicNameMap.put("PSMODELUIACTION", "系统模型界面行为");
      modelLogicNameMap.put("PSASBOOKING", "平台应用容器预约");
      modelLogicNameMap.put("PSDEDTSQUEUE", "实体分布事务队列");
      modelLogicNameMap.put("PSMODELEXAMPLESTEP", "模型示例步骤");
      modelLogicNameMap.put("PSMODELEXAMPLECAT", "模型实例分类");
      modelLogicNameMap.put("PSMODELSUBVIEW", "模型子视图");
      modelLogicNameMap.put("PSMODELVIEW", "系统模型视图");
      modelLogicNameMap.put("PSDEPSYSTYPE", "部署系统类型");
      modelLogicNameMap.put("PSMQTYPE", "平台MQ类型");
      modelLogicNameMap.put("PSDCASGROUP", "中心应用容器组");
      modelLogicNameMap.put("PSASGROUP", "应用容器集群");
      modelLogicNameMap.put("PSDEPSLNTYPE", "部署方案类型");
      modelLogicNameMap.put("PSMODELVIEWUIACTION", "模型视图界面行为");
      modelLogicNameMap.put("PSDCSYSLIC", "中心系统授权");
      modelLogicNameMap.put("PSDCDBINSTBK", "中心数据库备份");
      modelLogicNameMap.put("PSDCSVNBK", "中心SVN备份");
      modelLogicNameMap.put("PSSAASSYSAPP", "SaaS系统应用");
      modelLogicNameMap.put("PSSAASSYSVER", "SaaS系统版本");
      modelLogicNameMap.put("PSSAASSYS", "SaaS系统");
      modelLogicNameMap.put("PSDEVCENTERFILE", "中心文件");
      modelLogicNameMap.put("PSSYSMODELMSG", "系统模型消息");
      modelLogicNameMap.put("PSDER_DERINHERIT", "实体关系（继承）");
      modelLogicNameMap.put("PSDSBOOKING", "平台开发主机预约");
      modelLogicNameMap.put("PSDEPLOYSERVER", "平台部署服务器");
      modelLogicNameMap.put("PSSTUDIOSERVERLOG", "开发工具服务器日志");
      modelLogicNameMap.put("PSDBDEVINSTBK", "数据库开发实例备份");
      modelLogicNameMap.put("PSSYSMODELINSTBK", "系统模型库备份");
      modelLogicNameMap.put("PSSYSUNISTATE", "系统状态协同");
      modelLogicNameMap.put("PSSYSRTMSG", "系统模型运行信息");
      modelLogicNameMap.put("PSSYSSQLCMD", "系统数据库命令");
      modelLogicNameMap.put("PSSYSSQLCMDSQL", "系统数据库命令代码");
      modelLogicNameMap.put("PSDERTAW", "实体运行操作向导库");
      modelLogicNameMap.put("PSDERTAWI", "实体运行操作向导项");
      modelLogicNameMap.put("PSSYSRTDEFINPUTTIP", "系统运行属性输入提示");
      modelLogicNameMap.put("PSMODELRTMSG", "模型运行消息");
      modelLogicNameMap.put("PSROBOTTYPE", "平台机器人类型");
      modelLogicNameMap.put("PSROBOTWORKTYPE", "平台机器人能力类型");
      modelLogicNameMap.put("PSROBOTTYPEABILITY", "机器人类型能力");
      modelLogicNameMap.put("PSSUBSYSVERINST", "子系统版本实例");
      modelLogicNameMap.put("PSCTRLMSGTAG", "平台部件消息标记");
      modelLogicNameMap.put("PSBOOKINGRESTYPE", "平台预约资源类型");
      modelLogicNameMap.put("PSDEFINPUTTIPSET", "系统属性输入提示集合");
      modelLogicNameMap.put("PSDCNWFLOW", "中心流量");
      modelLogicNameMap.put("PSDCROBOT", "中心机器人");
      modelLogicNameMap.put("PSDCROBOTABILITY", "中心机器人能力");
      modelLogicNameMap.put("PSDCROBOTLOG", "中心机器人日志");
      modelLogicNameMap.put("PSDCRTMSG", "中心运行信息");
      modelLogicNameMap.put("PSDCRESREP", "中心资源报告");
      modelLogicNameMap.put("PSDCABILITY", "中心能力");
      modelLogicNameMap.put("PSDCRESHOURSLOG", "中心资源时间日志");
      modelLogicNameMap.put("PSDCRESHOURS", "中心资源时间");
      modelLogicNameMap.put("PSVIEWRTMSG", "视图运行消息");
      modelLogicNameMap.put("PSSYSMODELINSTSUM", "系统模型实例模型计数");
      modelLogicNameMap.put("PSDCDEPLOYSERVER", "中心部署服务器");
      modelLogicNameMap.put("PSSYSSEARCHBARITEM", "搜索栏项");
      modelLogicNameMap.put("PSROBOTABILITY", "机器人能力项");
      modelLogicNameMap.put("PSDEUSERROLE", "实体操作能力");
      modelLogicNameMap.put("PSDER_DERINDEX", "实体关系（索引）");
      modelLogicNameMap.put("PSDEFORMDETAIL_BUTTON", "表单成员（表单按钮）");
      modelLogicNameMap.put("PSDEFORMDETAIL_FORMPART", "表单成员（表单部件）");
      modelLogicNameMap.put("PSDEFORMDETAIL_FORMPAGE", "表单成员（表单分页）");
      modelLogicNameMap.put("PSDEFORMDETAIL_FORMITEM", "表单成员（表单项）");
      modelLogicNameMap.put("PSDEFORMDETAIL_TABPANEL", "表单成员（分页部件）");
      modelLogicNameMap.put("PSDEFORMDETAIL_TABPAGE", "表单成员（分页面板）");
      modelLogicNameMap.put("PSDEFORMDETAIL_GROUPPANEL", "表单成员（分组面板）");
      modelLogicNameMap.put("PSDEFORMDETAIL_DATAGRID", "表单成员（数据表格）");
      modelLogicNameMap.put("PSDEFORMDETAIL_DRUIPART", "表单成员（数据关系界面）");
      modelLogicNameMap.put("PSDEFORMDETAIL_USERCONTROL", "表单成员（用户控件）");
      modelLogicNameMap.put("PSDEFORMDETAIL_RAWITEM", "表单成员（直接内容）");
      modelLogicNameMap.put("PSDEFORMDETAIL_IFRAME", "表单成员（直接页面嵌入）");
      modelLogicNameMap.put("PSDEFORMDETAIL_FORMITEMEX", "表单成员（复合表单项）");
      modelLogicNameMap.put("PSDEFORMDETAIL_MDCTRL", "表单成员（多数据部件）");
      modelLogicNameMap.put("PSDEFORMDETAIL_BUTTONLIST", "表单成员（表单按钮列表）");
      modelLogicNameMap.put("PSDEFORM_EDITFORM", "实体编辑表单");
      modelLogicNameMap.put("PSDEFORM_SEARCHFORM", "实体搜索表单");
      modelLogicNameMap.put("PSDCMOBAPPTESTDEVICE", "中心移动应用测试终端");
      modelLogicNameMap.put("PSDCMOBAPPTDREF", "中心测试设备引用");
      modelLogicNameMap.put("PSMOBAPPSTARTPAGE", "移动应用欢迎页");
      modelLogicNameMap.put("PSMOBAPPPACKSESSION", "移动应用打包会话");
      modelLogicNameMap.put("PSDCMOBPACKCERT", "中心移动端打包证书");
      modelLogicNameMap.put("PSMODELRT", "模型运行时");
      modelLogicNameMap.put("PSMOBAPPPACKTD", "移动应用打包测试设备");
      modelLogicNameMap.put("PSSYSDEFTYPE", "系统属性类型默认逻辑");
      modelLogicNameMap.put("PSSYSDELOGICNODE", "系统逻辑处理节点");
      modelLogicNameMap.put("PSDEVPRDISSUE", "开发产品问题");
      modelLogicNameMap.put("PSDEVPRDISSUEPLAN", "开发产品问题修复计划");
      modelLogicNameMap.put("PSDCPFPITEMPL", "中心前端插件模板");
      modelLogicNameMap.put("PSDCPFPLUGIN", "中心前端应用插件");
      modelLogicNameMap.put("PSMOBAPPPACKSERVER", "移动应用打包服务器");
      modelLogicNameMap.put("PSDCSYNCAGENT", "中心同步代理");
      modelLogicNameMap.put("PSDCSYNCDATATYPE", "中心同步数据类型");
      modelLogicNameMap.put("PSDCSYNCDATA", "中心同步数据");
      modelLogicNameMap.put("PSDCSYNCDATA2", "中心同步输入数据");
      modelLogicNameMap.put("PSSFPUBOBJPARAM", "服务模板发布对象参数");
      modelLogicNameMap.put("PSSFPUBOBJ", "服务模板发布对象");
      modelLogicNameMap.put("PSPFPUBOBJ", "应用模板发布对象");
      modelLogicNameMap.put("PSPFPUBOBJPARAM", "应用模板发布对象参数");
      modelLogicNameMap.put("PSDEOPPRIVROLE", "实体操作能力标识");
      modelLogicNameMap.put("PSDEVIEWCTRLDS", "视图部件附加数据集");
      modelLogicNameMap.put("PSDELOGIC_VIEWLOGIC", "视图逻辑");
      modelLogicNameMap.put("PSSYSDBPART", "系统数据看板");
      modelLogicNameMap.put("PSSYSMODELLOADLOG", "系统模型加载日志");
      modelLogicNameMap.put("PSSYSDASHBOARD", "系统数据看板");
      modelLogicNameMap.put("PSSYSUTILDE", "系统功能配置");
      modelLogicNameMap.put("PSDEUTILDE", "实体功能配置");
      modelLogicNameMap.put("PSAPPLOCALDE", "应用本地实体");
      modelLogicNameMap.put("PSSYSUSERROLERES", "系统角色资源");
      modelLogicNameMap.put("PSSYSSFPITEMPL", "后台插件模板");
      modelLogicNameMap.put("PSSYSSFPLUGIN", "系统后台模板插件");
      modelLogicNameMap.put("PSSFPLUGIN", "后台服务插件");
      modelLogicNameMap.put("PSSFPLUGINTEMPL", "后台服务插件模板");
      modelLogicNameMap.put("PSDEUTILTYPE", "实体功能类型");
      modelLogicNameMap.put("PSDEMODEL", "实体模型配置");
      modelLogicNameMap.put("PSDEVIEWGRPDETAIL", "实体视图组成员");
      modelLogicNameMap.put("PSDEVIEWGROUP", "系统实体视图组");
      modelLogicNameMap.put("PSAPPUTIL", "应用功能配置");
      modelLogicNameMap.put("PSSYSCONSOLE", "系统控制台信息");
      modelLogicNameMap.put("PSDCCODESNIPPETREF", "中心代码模板引用");
      modelLogicNameMap.put("PSDCCODESNIPPET", "中心代码片段");
      modelLogicNameMap.put("PSSYSCODESNIPPET", "系统代码块");
      modelLogicNameMap.put("PSDEVSLNMSDEPAPI", "开发方案微服务服务部署");
      modelLogicNameMap.put("PSDEVSLNSYSAPI", "开发系统服务接口");
      modelLogicNameMap.put("PSDEVSLNSYSAPP", "开发系统应用");
      modelLogicNameMap.put("PSDEVSLNMSDEPAPP", "开发方案微服务应用部署");
      modelLogicNameMap.put("PSDEVSLNMSDEPLOY", "开发方案微服务部署");
      modelLogicNameMap.put("PSDCMSPLATFORMNODE", "中心微服务平台节点");
      modelLogicNameMap.put("PSDCMSPLATFORMFUNC", "中心微服务平台功能");
      modelLogicNameMap.put("PSDCMSPLATFORM", "中心微服务平台");
      modelLogicNameMap.put("PSMSPLATFORMNODE", "平台微服务平台节点");
      modelLogicNameMap.put("PSMSPLATFORMFUNC", "平台微服务平台功能");
      modelLogicNameMap.put("PSMSPLATFORM", "平台微服务平台");
      modelLogicNameMap.put("PSDEPLOYCENTER", "平台部署中心");
      modelLogicNameMap.put("PSCODESNIPPETTYPE", "平台代码片段类型");
      modelLogicNameMap.put("PSDCDEPLOYCENTER", "中心部署中心");
      modelLogicNameMap.put("PSWORKSHOPSERVER", "平台系统工程服务器");
      modelLogicNameMap.put("PSDCWORKSHOPSERVER", "中心工程服务器");
      modelLogicNameMap.put("PSAPPDEVIEWREF", "应用实体视图引用");
      modelLogicNameMap.put("PSDEDATAIMPITEM", "实体数据导入项");
      modelLogicNameMap.put("PSDEVSLNSYSWSGIT", "开发系统工程服务器GIT库");
      modelLogicNameMap.put("PSSYSDYNAMODEL", "系统动态模型对象");
      modelLogicNameMap.put("PSSYSDYNAMODELATTR", "系统动态模型属性");
      modelLogicNameMap.put("PSSYSTITLEBAR", "系统标题栏");
      modelLogicNameMap.put("PSAPPTITLEBAR", "应用标题栏");
      modelLogicNameMap.put("PSSYSVIEWLOGICPARAM", "视图逻辑参数");
      modelLogicNameMap.put("PSSYSTEM_SETTING", "系统全局设置");
      modelLogicNameMap.put("PSSYSAPP_UI", "应用界面设置");
      modelLogicNameMap.put("PSSYSCOUNTERREF", "系统计数器引用");
      modelLogicNameMap.put("PSDEGRIDEDITITEM", "实体表格编辑项");
      modelLogicNameMap.put("PSDEGRIDDATAITEM", "实体表格数据项");
      modelLogicNameMap.put("PSACHANDLER_GRIDEDITITEM", "表格编辑项后台处理器");
      modelLogicNameMap.put("PSACHANDLER_FORMITEM", "表单项后台处理器");
      modelLogicNameMap.put("PSCUSTOMCONTROL", "自定义部件");
      modelLogicNameMap.put("PSDELLCOND_GROUP", "实体逻辑组合条件");
      modelLogicNameMap.put("PSDELLCOND_SINGLE", "实体逻辑单项条件");
      modelLogicNameMap.put("PSDELLCOND_CUSTOM", "实体逻辑自定义条件");
      modelLogicNameMap.put("PSACHANDLERACTION", "部件后台处理行为");
      modelLogicNameMap.put("PSDEDRBAR", "实体数据关系栏");
      modelLogicNameMap.put("PSDEDRTAB", "实体数据关系分页部件");
      modelLogicNameMap.put("PSDEDRBARGROUP", "实体数据关系栏分组");
      modelLogicNameMap.put("PSDEDRBARITEM", "实体数据关系栏项目");
      modelLogicNameMap.put("PSSYSDBPART", "数据看板部件");
      modelLogicNameMap.put("PSCODEITEM", "代码表项");
      modelLogicNameMap.put("PSDEDATAEXPITEM", "实体数据导出项");
      modelLogicNameMap.put("PSDEDATAEXPGROUP", "实体数据导出分组");
      modelLogicNameMap.put("PSDECHARTTITLE", "实体图表标题");
      modelLogicNameMap.put("PSDECHARTLEGEND", "实体图表图例");
      modelLogicNameMap.put("PSDECHARTGRID", "实体图表直角坐标表格");
      modelLogicNameMap.put("PSDECHARTRADAR", "实体图表雷达部件");
      modelLogicNameMap.put("PSDECHARTPOLAR", "实体图表极坐标系组件");
      modelLogicNameMap.put("PSDECHARTPARALLEL", "实体图表平行坐标系组件");
      modelLogicNameMap.put("PSDECHARTSINGLE", "实体图表单轴坐标系组件");
      modelLogicNameMap.put("PSDECHARTGEO", "实体地理坐标系组件");
      modelLogicNameMap.put("PSDECHARTCALENDAR", "实体日历坐标系组件");
      modelLogicNameMap.put("PSDECHARTDATASET", "实体图表数据集");
      modelLogicNameMap.put("PSDECHARTDATASETFIELD", "实体图表数据集属性");
      modelLogicNameMap.put("PSDECHARTDATASETGROUP", "实体图表数据集分组");
      modelLogicNameMap.put("PSDEUNISTATE", "实体统一状态");
      modelLogicNameMap.put("PSDEDATAVIEWDATAITEM", "实体卡片视图数据项");
      modelLogicNameMap.put("PSEXPBAR", "导航栏");
      modelLogicNameMap.put("PSWFUIACTION", "工作流界面行为");
      modelLogicNameMap.put("PSWFUAGROUP", "工作流界面行为组");
      modelLogicNameMap.put("PSWFUAGRPDETAIL", "工作流界面行为组成员");
      modelLogicNameMap.put("PSVIEWPANEL", "视图面板");
      modelLogicNameMap.put("PSDEWIZARDPANEL", "向导面板");
      modelLogicNameMap.put("PSDECONTEXTMENU", "上下文菜单");
      modelLogicNameMap.put("PSSYSDTSQUEUE", "系统分布事务队列");
      modelLogicNameMap.put("PSDEOPPRIV", "实体操作标识");
      modelLogicNameMap.put("PSDEREPORTPANEL", "实体报表面板");
      modelLogicNameMap.put("PSSYSDMVER", "系统数据库模型版本");
      modelLogicNameMap.put("PSDEACTIONPARAM", "实体行为参数");
      modelLogicNameMap.put("PSSYSCALENDAR", "日历部件");
      modelLogicNameMap.put("PSSYSCALENDARITEM", "日历部件项");
      modelLogicNameMap.put("PSSYSCALENDARITEMRV", "日历部件项视图");
      modelLogicNameMap.put("PSDESAMPLEDATA", "实体示例数据");
      modelLogicNameMap.put("PSSYSVIEWPANELITEM_CONTAINER", "面板容器部件");
      modelLogicNameMap.put("PSSYSVIEWPANELITEM_FIELD", "面板属性部件");
      modelLogicNameMap.put("PSSYSVIEWPANELITEM_TABPANEL", "面板分页部件");
      modelLogicNameMap.put("PSSYSVIEWPANELITEM_TABPAGE", "面板分页面板");
      modelLogicNameMap.put("PSSYSVIEWPANELITEM_CONTROL", "面板部件");
      modelLogicNameMap.put("PSSYSVIEWPANELITEM_CTRLPOS", "面板部件占位");
      modelLogicNameMap.put("PSSYSVIEWPANELITEM_USERCONTROL", "面板自定义部件");
      modelLogicNameMap.put("PSSYSVIEWPANELITEM_RAWITEM", "面板直接内容");
      modelLogicNameMap.put("PSSYSVIEWPANELITEM_BUTTON", "面板按钮");
      modelLogicNameMap.put("PSSYSVIEWPANELITEM_BUTTONLIST", "面板按钮列表");
      modelLogicNameMap.put("PSSYSVIEWPANELITEM_PARAM", "面板项参数");
      modelLogicNameMap.put("PSSYSVIEWPANELMODEL", "面板模型");
      modelLogicNameMap.put("PSSYSVIEWPANELLOGIC", "面板逻辑");
      modelLogicNameMap.put("PSPANELLOGICPARAM", "面板逻辑参数");
      modelLogicNameMap.put("PSPANELLOGICNODE", "面板逻辑节点");
      modelLogicNameMap.put("PSPANELLOGICLINK", "面板逻辑连接");
      modelLogicNameMap.put("PSPANELLLCOND", "面板逻辑连接条件");
      modelLogicNameMap.put("PSPANELLNPARAM", "面板逻辑节点参数");
      modelLogicNameMap.put("PSPANELLLCOND_GROUP", "面板逻辑组合条件");
      modelLogicNameMap.put("PSPANELLLCOND_SINGLE", "面板逻辑单项条件");
      modelLogicNameMap.put("PSPANELLLCOND_CUSTOM", "面板逻辑自定义条件");
      modelLogicNameMap.put("PSDELISTDATAITEM", "实体列表数据项");
      modelLogicNameMap.put("PSAPPDYNADEVIEW", "应用动态实体视图");
      modelLogicNameMap.put("PSAPPUTILVIEW", "应用功能视图");
      modelLogicNameMap.put("PSAPPPANELVIEW", "应用面板视图");
      modelLogicNameMap.put("PSDEVSLNMSDEPFUNC", "开发方案微服务功能部署");
      modelLogicNameMap.put("PSSYSVIEWLAYOUTPANEL", "视图布局面板");
      modelLogicNameMap.put("PSAPPVIEWLOGICREFVIEW", "视图逻辑视图引用");
      modelLogicNameMap.put("PSAPPVIEWENGINE", "视图界面引擎");
      modelLogicNameMap.put("PSAPPVIEWENGINEPARAM", "视图界面引擎参数");
      modelLogicNameMap.put("PSAPPDATAENTITY", "应用实体");
      modelLogicNameMap.put("PSAPPVIEWPARAM", "视图参数");
      modelLogicNameMap.put("PSAPPVIEWNAVCONTEXT", "视图导航上下文");
      modelLogicNameMap.put("PSAPPVIEWNAVPARAM", "视图导航参数");
      modelLogicNameMap.put("PSLAYOUT", "布局容器");
      modelLogicNameMap.put("PSLAYOUTPOS", "布局位置");
      modelLogicNameMap.put("PSAPPVIEWUIACTION", "应用视图界面行为");
      modelLogicNameMap.put("PSCONTROLLOGIC", "部件逻辑");
      modelLogicNameMap.put("PSAPPUILOGIC", "预置视图逻辑");
      modelLogicNameMap.put("PSAPPUILOGICBUILDIN", "预置视图逻辑");
      modelLogicNameMap.put("PSDEMAPACTION", "实体映射行为");
      modelLogicNameMap.put("PSDEMAPDQ", "实体映射查询");
      modelLogicNameMap.put("PSDEMAPDS", "实体映射数据集合");
      modelLogicNameMap.put("PSDEMAPDETAIL", "实体映射属性");
      modelLogicNameMap.put("PSTABEXPPANEL", "分页导航面板");
      modelLogicNameMap.put("PSDEDRTABPAGE", "关系分页部件成员");
      modelLogicNameMap.put("PSPFXCODEOBJECT", "前端扩展插件");
      modelLogicNameMap.put("PSSFXCODEOBJECT", "后端扩展插件");
      modelLogicNameMap.put("PSAPPWF", "应用工作流");
      modelLogicNameMap.put("PSAPPWFVER", "应用工作流版本");
      modelLogicNameMap.put("PSDESERVICEAPIFIELD", "实体服务接口属性");
      modelLogicNameMap.put("PSDESARS", "实体服务接口关系");
      modelLogicNameMap.put("PSAPPDERS", "应用实体关系");
      modelLogicNameMap.put("PSAPPDERSVIEW", "应用实体关系视图");
      modelLogicNameMap.put("PSSUBSYSSADE", "外部接口实体");
      modelLogicNameMap.put("PSSUBSYSSADERS", "外部接口实体关系");
      modelLogicNameMap.put("PSSUBSYSSADEFIELD", "外部接口实体属性");
      modelLogicNameMap.put("PSSYSDBSCHEME", "系统数据库架构");
      modelLogicNameMap.put("PSSYSDBTABLE", "数据库表对象");
      modelLogicNameMap.put("PSSYSDBCOLUMN", "数据库列对象");
      modelLogicNameMap.put("PSDESAVR", "实体接口值规则");
      modelLogicNameMap.put("PSSYSRESOURCE", "系统预置资源");
      modelLogicNameMap.put("PSSYSCONTENT", "系统预置内容");
      modelLogicNameMap.put("PSSYSCONTENTCAT", "系统内容分类");
      modelLogicNameMap.put("PSAPPRESOURCE", "应用预置资源");
      modelLogicNameMap.put("PSAPPDEMETHOD", "应用实体方法");
      modelLogicNameMap.put("PSAPPDEFIELD", "应用实体属性");
      modelLogicNameMap.put("PSAPPDEUIACTION", "应用实体界面行为");
      modelLogicNameMap.put("PSSYSAPPDEUIACTION", "全局应用实体界面行为");
      modelLogicNameMap.put("PSDEGROUPDETAIL", "实体组成员");
      modelLogicNameMap.put("PSDEGROUP", "实体组");
      modelLogicNameMap.put("PSDERGROUPDETAIL", "实体关系组成员");
      modelLogicNameMap.put("PSDERGROUP", "实体关系组");
      modelLogicNameMap.put("PSDEACTIONGROUP", "实体行为组");
      modelLogicNameMap.put("PSDEAGDETAIL", "实体行为组成员");
      modelLogicNameMap.put("PSSYSTESTPRJ", "系统测试项目");
      modelLogicNameMap.put("PSSYSTESTMODULE", "测试用例模块");
      modelLogicNameMap.put("PSDERNN", "实体多对多关系");
      modelLogicNameMap.put("PSSYSSAHANDLER", "系统服务接口处理");
      modelLogicNameMap.put("PSDETABLE", "实体数据表");
      modelLogicNameMap.put("PSSYSDEOPPRIV", "系统实体操作标识");
      modelLogicNameMap.put("PSAPPCOUNTER", "应用计数器");
      modelLogicNameMap.put("PSAPPCODELIST", "应用代码表");
      modelLogicNameMap.put("PSAPPMSGTEMPL", "应用消息模板");
      modelLogicNameMap.put("PSAPPVIEWMSG", "应用视图消息");
      modelLogicNameMap.put("PSAPPVIEWMSGGROUP", "应用视图消息组");
      modelLogicNameMap.put("PSAPPVIEWMSGGRPDETAIL", "应用视图消息组成员");
      modelLogicNameMap.put("PSDEUILOGIC", "实体界面逻辑");
      modelLogicNameMap.put("PSAPPDELOGIC", "应用实体处理逻辑");
      modelLogicNameMap.put("PSAPPDEUILOGIC", "应用实体界面逻辑");
      modelLogicNameMap.put("PSAPPDELOGICNODE", "应用实体逻辑节点");
      modelLogicNameMap.put("PSAPPDEUILOGICNODE", "应用实体界面逻辑节点");
      modelLogicNameMap.put("PSAPPDELOGICPARAM", "应用实体逻辑参数");
      modelLogicNameMap.put("PSAPPDELOGICLINK", "应用实体逻辑连接");
      modelLogicNameMap.put("PSAPPDELLCOND", "应用实体逻辑连接条件");
      modelLogicNameMap.put("PSAPPDELNPARAM", "应用实体逻辑节点参数");
      modelLogicNameMap.put("PSCTRLLOGICGROUP", "界面逻辑组");
      modelLogicNameMap.put("PSCTRLLOGICGRPDETAIL", "界面逻辑组成员");
      modelLogicNameMap.put("PSSYSCTRLLOGICGROUP", "全局界面逻辑组");
      modelLogicNameMap.put("PSSYSCTRLLOGICGRPDETAIL", "全局界面逻辑组成员");
      modelLogicNameMap.put("PSPANELITEMLOGIC", "面板成员逻辑项");
      modelLogicNameMap.put("PSPANELENGINE", "面板界面引擎");
      modelLogicNameMap.put("PSPANELENGINEPARAM", "面板界面引擎参数");
      modelLogicNameMap.put("PSDEUILOGIC", "实体界面逻辑");
      modelLogicNameMap.put("PSDEUILOGICPARAM", "实体界面逻辑参数");
      modelLogicNameMap.put("PSDEUILOGICNODE", "实体界面逻辑节点");
      modelLogicNameMap.put("PSDEUILOGICLINK", "实体界面逻辑连接");
      modelLogicNameMap.put("PSDEUILNPARAM", "实体界面逻辑节点参数");
      modelLogicNameMap.put("PSDEUILLCOND", "实体界面逻辑连接条件");
      modelLogicNameMap.put("PSAPPDEUILOGIC", "应用实体界面逻辑");
      modelLogicNameMap.put("PSAPPDEUILOGICNODE", "应用实体界面处理逻辑节点");
      modelLogicNameMap.put("PSAPPDEUILOGICPARAM", "应用实体界面逻辑参数");
      modelLogicNameMap.put("PSAPPDEUILOGICLINK", "应用实体界面逻辑连接");
      modelLogicNameMap.put("PSAPPDEUILLCOND", "应用实体界面逻辑连接条件");
      modelLogicNameMap.put("PSAPPDEUILNPARAM", "应用实体界面逻辑节点参数");
      modelLogicNameMap.put("PSAPPDEACMODE", "应用实体自填模式");
      modelLogicNameMap.put("PSAPPDEACMODEITEM", "应用实体自填模式项");
      modelLogicNameMap.put("PSEDITOR", "编辑器对象");
      modelLogicNameMap.put("PSSYSMODELGROUP", "系统模型组");
      modelLogicNameMap.put("PSSYSSEARCHSCHEME", "全文检索体系");
      modelLogicNameMap.put("PSSYSSEARCHDOC", "全文检索文档");
      modelLogicNameMap.put("PSSYSSEARCHDE", "全文检索实体");
      modelLogicNameMap.put("PSSYSSEARCHFIELD", "全文检索属性");
      modelLogicNameMap.put("PSSYSSEARCHDEFIELD", "全文检索实体属性");
      modelLogicNameMap.put("PSDESEARCH", "实体全文检索");
      modelLogicNameMap.put("PSDEFSEARCH", "实体属性全文检索");
      modelLogicNameMap.put("PSDEBDTABLE", "实体大数据表");
      modelLogicNameMap.put("PSSYSMAPVIEW", "系统地图部件");
      modelLogicNameMap.put("PSSYSMAPITEM", "系统地图项");
      modelLogicNameMap.put("PSAPPWFUIACTION", "应用流程界面行为");
      modelLogicNameMap.put("PSAPPWFVERUIACTION", "应用流程版本界面行为");
      modelLogicNameMap.put("PSAPPWFUAGROUP", "应用流程界面行为组");
      modelLogicNameMap.put("PSAPPWFVERUAGROUP", "应用流程版本界面行为组");
      modelLogicNameMap.put("PSAPPWFUAGRPDETAIL", "应用流程界面行为组成员");
      modelLogicNameMap.put("PSAPPWFVERUAGRPDETAIL", "应用流程版本界面行为组成员");
      modelLogicNameMap.put("PSSYSPORTLETCAT", "系统门户部件分类");
      modelLogicNameMap.put("PSAPPPORTLET", "应用门户部件");
      modelLogicNameMap.put("PSAPPPORTLETCAT", "应用门户部件分类");
      modelLogicNameMap.put("PSAPPDEDRITEM", "应用实体关系界面");
      modelLogicNameMap.put("PSAPPDEDRGROUP", "应用实体关系界面分组");
      modelLogicNameMap.put("PSAPPDEPORTLET", "应用实体门户部件");
      modelLogicNameMap.put("PSSYSUSERROLEDATA", "系统角色数据能力");
      modelLogicNameMap.put("PSAPPPDTVIEW", "应用预置视图");
      modelLogicNameMap.put("PSDECHARTCOORDINATESYSTEM", "实体图表坐标系统");
      modelLogicNameMap.put("PSDECHARTGRIDXAXIS", "实体图表直角坐标表格X轴");
      modelLogicNameMap.put("PSDECHARTGRIDYAXIS", "实体图表直角坐标表格Y轴");
      modelLogicNameMap.put("PSDECHARTPOLARANGLEAXIS", "实体图表极坐标角度轴");
      modelLogicNameMap.put("PSDECHARTPOLARRADIUSAXIS", "实体图表极坐标径向轴");
      modelLogicNameMap.put("PSDECHARTPARALLELAXIS", "实体图表平行坐标轴");
      modelLogicNameMap.put("PSDECHARTSINGLEAXIS", "实体图表单一坐标轴");
      modelLogicNameMap.put("PSDECHARTSERIESENCODE", "实体图表序列编码");
      modelLogicNameMap.put("PSAPPDEDATAEXP", "应用实体数据导出");
      modelLogicNameMap.put("PSAPPDEDATAEXPITEM", "应用实体数据导出项");
      modelLogicNameMap.put("PSAPPDEDATAEXPGROUP", "应用实体数据导出分组");
      modelLogicNameMap.put("PSAPPDEDATAIMP", "应用实体数据导入");
      modelLogicNameMap.put("PSAPPDEDATAIMPITEM", "应用实体数据导入项");
      modelLogicNameMap.put("PSAPPVALUERULE", "应用值规则");
      modelLogicNameMap.put("PSDATAITEMPARAM", "数据项参数");
      modelLogicNameMap.put("PSDEFORMDATAITEM", "实体表单数据项");
      modelLogicNameMap.put("PSDEDATAVIEWITEM", "实体卡片视图项");
      modelLogicNameMap.put("PSSYSPANELDATAITEM", "系统面板数据项");
      modelLogicNameMap.put("PSDEACMODEDATAITEM", "实体自填数据项");
      modelLogicNameMap.put("PSAPPDEACMODEDATAITEM", "应用实体自填数据项");
      modelLogicNameMap.put("PSCONTROL", "界面部件");
      modelLogicNameMap.put("PSDCWORKSPACE", "中心生产线");
      modelLogicNameMap.put("PSDETREENODERSPARAM", "树节点关系参数");
      modelLogicNameMap.put("PSDETREENODERSNAVCONTEXT", "树节点关系导航上下文");
      modelLogicNameMap.put("PSDETREENODERSNAVPARAM", "树节点关系导航参数");
      modelLogicNameMap.put("PSSFPUBHELP", "后台发布目标");
      modelLogicNameMap.put("PSPFPUBHELP", "前端发布目标");
      modelLogicNameMap.put("PSSFCODEPUBLISHERMACRO", "发布器路径变量");
      modelLogicNameMap.put("PSPFCODEPUBLISHERMACRO", "发布器路径变量");
      modelLogicNameMap.put("PSSFCODEPUBLISHERPARAM", "发布器内置变量");
      modelLogicNameMap.put("PSPFCODEPUBLISHERPARAM", "发布器内置变量");
      modelLogicNameMap.put("PSDETREEGRIDEX", "树表格部件");
      modelLogicNameMap.put("PSDEGANTT", "甘特部件");
      modelLogicNameMap.put("PSDESARSDETAIL", "实体服务接口成员");
      modelLogicNameMap.put("PSDEGEIVR", "表格编辑项值规则");
      modelLogicNameMap.put("PSDEKANBAN", "看板部件");
      modelLogicNameMap.put("PSSYSSEARCHBARFILTER", "搜索栏过滤项");
      modelLogicNameMap.put("PSSYSSEARCHBARQUICKSEARCH", "搜索栏快速搜索项");
      modelLogicNameMap.put("PSSYSSEARCHBARGROUP", "搜索栏分组项");
      modelLogicNameMap.put("PSNAVIGATECONTEXT", "导航上下文");
      modelLogicNameMap.put("PSNAVIGATEPARAM", "导航参数");
      modelLogicNameMap.put("PSUIACTIONPARAM", "界面行为参数");
      modelLogicNameMap.put("PSDER1NDEFMAP", "实体1:N关系属性映射");
      modelLogicNameMap.put("PSDERINDEXDEFMAP", "实体索引关系属性映射");
      modelLogicNameMap.put("PSDEMETHOD", "实体方法");
      modelLogicNameMap.put("PSDEACTIONMETHOD", "实体行为方法");
      modelLogicNameMap.put("PSDEDATASETMETHOD", "实体数据集方法");
      modelLogicNameMap.put("PSDEACTIONVR", "实体行为值规则");
      modelLogicNameMap.put("PSDESTATEWIZARDPANEL", "状态向导面板");
      modelLogicNameMap.put("PSDEFLOGIC", "实体属性逻辑");
      modelLogicNameMap.put("PSAPPDEFLOGIC", "应用实体属性逻辑");
      modelLogicNameMap.put("PSDEFUIMODE", "属性界面模式");
      modelLogicNameMap.put("PSDEFGRIDCOLUMN", "属性表格列模式");
      modelLogicNameMap.put("PSDEMSFIELD", "实体主状态属性");
      modelLogicNameMap.put("PSDER_DERCUSTOM", "实体关系（自定义）");
      modelLogicNameMap.put("PSSYSSEQUENCE", "系统值序列");
      modelLogicNameMap.put("PSSYSTRANSLATOR", "系统值转换器");
      modelLogicNameMap.put("PSSYSMSGQUEUE", "系统消息队列");
      modelLogicNameMap.put("PSSYSMSGTARGET", "系统消息目标");
      modelLogicNameMap.put("PSDENOTIFY", "实体通知");
      modelLogicNameMap.put("PSDENOTIFYTARGET", "实体通知目标");
      modelLogicNameMap.put("PSSYSEAIDATATYPEITEM", "集成数据类型项");
      modelLogicNameMap.put("PSSYSEAIDER", "集成实体关系映射");
      modelLogicNameMap.put("PSSYSEAIDEFIELD", "集成实体属性映射");
      modelLogicNameMap.put("PSSYSEAIDE", "集成实体映射");
      modelLogicNameMap.put("PSSYSEAIELEMENTRE", "集成元素元素");
      modelLogicNameMap.put("PSSYSEAIELEMENTATTR", "集成元素属性");
      modelLogicNameMap.put("PSSYSEAIELEMENT", "集成元素");
      modelLogicNameMap.put("PSSYSEAIDATATYPE", "集成数据类型");
      modelLogicNameMap.put("PSSYSEAISCHEME", "应用集成体系");
      modelLogicNameMap.put("PSSYSBIAGGCOLUMN", "智能报表聚合数据列");
      modelLogicNameMap.put("PSSYSBIAGGTABLE", "智能报表聚合数据");
      modelLogicNameMap.put("PSSYSBICUBELEVEL", "智能报表立方体维度层级");
      modelLogicNameMap.put("PSSYSBICUBEMEASURE", "智能报表立方体指标");
      modelLogicNameMap.put("PSSYSBICUBEDIMENSION", "智能报表立方体维度");
      modelLogicNameMap.put("PSSYSBILEVEL", "智能报表维度层级");
      modelLogicNameMap.put("PSSYSBIHIERARCHY", "智能报表维度体系");
      modelLogicNameMap.put("PSSYSBIDIMENSION", "智能报表维度");
      modelLogicNameMap.put("PSSYSBICUBE", "智能报表立方体");
      modelLogicNameMap.put("PSSYSBISCHEME", "智能报表体系");
      modelLogicNameMap.put("PSTHRESHOLD", "阈值项");
      modelLogicNameMap.put("PSTHRESHOLDGROUP", "阈值组");
      modelLogicNameMap.put("PSSYSCHARTTHEME", "系统图表主题");
      modelLogicNameMap.put("PSSYSCANVAS", "系统画布");
      modelLogicNameMap.put("PSSYSCANVASMODEL", "系统画布引用模型");
      modelLogicNameMap.put("PSSYSDASHBOARDLOGIC", "数据看板逻辑");
      modelLogicNameMap.put("PSAPPMENULOGIC", "应用菜单逻辑");
      modelLogicNameMap.put("PSDEFORMLOGIC", "实体表单逻辑");
      modelLogicNameMap.put("PSSYSSEARCHBARLOGIC", "搜索栏逻辑");
      modelLogicNameMap.put("PSAPPLOGIC", "前端应用逻辑");
      modelLogicNameMap.put("PSDETOOLBARLOGIC", "工具栏逻辑");
      modelLogicNameMap.put("PSDEWIZARDLOGIC", "实体向导逻辑");
      modelLogicNameMap.put("PSDELISTLOGIC", "实体列表逻辑");
      modelLogicNameMap.put("PSSYSMAPLOGIC", "地图部件逻辑");
      modelLogicNameMap.put("PSDETREELOGIC", "实体树视图逻辑");
      modelLogicNameMap.put("PSDEDATAVIEWLOGIC", "卡片视图部件逻辑");
      modelLogicNameMap.put("PSSYSCALENDARLOGIC", "日历部件逻辑");
      modelLogicNameMap.put("PSDEGRIDLOGIC", "实体表格逻辑");
      modelLogicNameMap.put("PSDECHARTLOGIC", "实体图表逻辑");
      modelLogicNameMap.put("PSDEDRLOGIC", "实体关系部件逻辑");
      modelLogicNameMap.put("PSSYSUSECASECAT", "系统用例分类");
      modelLogicNameMap.put("PSDETEIUPDATE", "树表编辑项更新模式");
      modelLogicNameMap.put("PSDETEIUDETAIL", "树表编辑项更新成员");
      modelLogicNameMap.put("PSSYSBIREPORT", "智能报表");
      modelLogicNameMap.put("PSSYSBIREPORTITEM", "智能报表项");
      modelLogicNameMap.put("PSAPPPFPLUGIN", "应用前端插件");
      modelLogicNameMap.put("PSSYSAICHATAGENT", "系统AI交谈代理");
      modelLogicNameMap.put("PSSYSAIFACTORY", "系统AI工厂");
      modelLogicNameMap.put("PSSYSAIPIPELINEAGENT", "系统AI生产线代理");
      modelLogicNameMap.put("PSSYSAIPIPELINEJOB", "系统AI生产线作业");
      modelLogicNameMap.put("PSSYSAIPIPELINEWORKER", "系统AI生产线工作者");
      modelLogicNameMap.put("PSSYSAIWORKERAGENT", "系统AI工作者代理");
      exportModelMap.put("PSSYSUNISTATE", "T_SRFPSSYSUNISTATE");
      exportModelMap.put("PSSYSERMAP", "T_SRFPSSYSERMAP");
      exportModelMap.put("PSSYSVIEWLOGIC", "T_SRFPSSYSVIEWLOGIC");
      exportModelMap.put("PSDEFIELD", "T_SRFPSDEFIELD");
      exportModelMap.put("PSPANELLOGICNODE", "T_SRFPSPANELLOGICNODE");
      exportModelMap.put("PSDELNPARAM", "T_SRFPSDELNPARAM");
      exportModelMap.put("PSAPPUTIL", "T_SRFPSAPPUTIL");
      exportModelMap.put("PSSYSDMITEM", "T_SRFPSSYSDMITEM");
      exportModelMap.put("PSSYSUSERMODE", "T_SRFPSSYSUSERMODE");
      exportModelMap.put("PSSYSTESTDATA", "T_SRFPSSYSTESTDATA");
      exportModelMap.put("PSSYSDBPART", "T_SRFPSSYSDBPART");
      exportModelMap.put("PSSYSSFCODE", "T_SRFPSSYSSFCODE");
      exportModelMap.put("PSCODELIST", "T_SRFPSCODELIST");
      exportModelMap.put("PSSUBSYSSERVICEAPI", "T_SRFPSSUBSYSSERVICEAPI");
      exportModelMap.put("PSDECHARTAXES", "T_SRFPSDECHARTAXES");
      exportModelMap.put("PSDEFDLOGIC", "T_SRFPSDEFDLOGIC");
      exportModelMap.put("PSSYSSERVICEAPI", "T_SRFPSSYSSERVICEAPI");
      exportModelMap.put("PSSYSWFMODE", "T_SRFPSSYSWFMODE");
      exportModelMap.put("PSSYSTEMMQ", "T_SRFPSSYSTEMMQ");
      exportModelMap.put("PSPANELITEMLOGIC", "T_SRFPSPANELITEMLOGIC");
      exportModelMap.put("PSDESAMPLEDATA", "T_SRFPSDESAMPLEDATA");
      exportModelMap.put("PSLANGUAGERES", "T_SRFPSLANGUAGERES");
      exportModelMap.put("PSDEUAGROUP", "T_SRFPSDEUAGROUP");
      exportModelMap.put("PSWXMENU", "T_SRFPSWXMENU");
      exportModelMap.put("PSSYSVALUERULE", "T_SRFPSSYSVALUERULE");
      exportModelMap.put("PSDEACTIONWIZARD", "T_SRFPSDEACTIONWIZARD");
      exportModelMap.put("PSDEACTIONLOGIC", "T_SRFPSDEACTIONLOGIC");
      exportModelMap.put("PSSYSPORTLET", "T_SRFPSSYSPORTLET");
      exportModelMap.put("PSDETOOLBAR", "T_SRFPSDETOOLBAR");
      exportModelMap.put("PSSYSTEMAS", "T_SRFPSSYSTEMAS");
      exportModelMap.put("PSDETOOLBAR", "T_SRFPSDETOOLBAR");
      exportModelMap.put("PSSYSBDTABLE", "T_SRFPSSYSBDTABLE");
      exportModelMap.put("PSDEACTION", "T_SRFPSDEACTION");
      exportModelMap.put("PSSYSBDCOLSET", "T_SRFPSSYSBDCOLSET");
      exportModelMap.put("PSSYSUTILDE", "T_SRFPSSYSUTILDE");
      exportModelMap.put("PSDEGEIUPDATE", "T_SRFPSDEGEIUPDATE");
      exportModelMap.put("PSDEACTIONPARAM", "T_SRFPSDEACTIONPARAM");
      exportModelMap.put("PSSYSMSGTEMPL", "T_SRFPSSYSMSGTEMPL");
      exportModelMap.put("PSDEWIZARD", "T_SRFPSDEWIZARD");
      exportModelMap.put("PSSYSDBTABLE", "T_SRFPSSYSDBTABLE");
      exportModelMap.put("PSDEMAPACTION", "T_SRFPSDEMAPACTION");
      exportModelMap.put("PSDELIST", "T_SRFPSDELIST");
      exportModelMap.put("PSDETREENODERV", "T_SRFPSDETREENODERV");
      exportModelMap.put("PSAPPFUNC", "T_SRFPSAPPFUNC");
      exportModelMap.put("PSSYSSEARCHBARITEM", "T_SRFPSSYSSEARCHBARITEM");
      exportModelMap.put("PSSYSVIEWPANELITEM", "T_SRFPSSYSVIEWPANELITEM");
      exportModelMap.put("PSSYSSFPLUGIN", "T_SRFPSSYSSFPLUGIN");
      exportModelMap.put("PSDETREENODERS", "T_SRFPSDETREENODERS");
      exportModelMap.put("PSDEFSFITEM", "T_SRFPSDEFSFITEM");
      exportModelMap.put("PSSYSUSERDR", "T_SRFPSSYSUSERDR");
      exportModelMap.put("PSSYSCOUNTER", "T_SRFPSSYSCOUNTER");
      exportModelMap.put("PSSYSWFMODE", "T_SRFPSSYSWFMODE");
      exportModelMap.put("PSSYSDATASYNCAGENT", "T_SRFPSSYSDATASYNCAGENT");
      exportModelMap.put("PSSYSCALENDARITEM", "T_SRFPSSYSCALENDARITEM");
      exportModelMap.put("PSAPPUISTYLE", "T_SRFPSAPPUISTYLE");
      exportModelMap.put("PSDEFDLOGIC", "T_SRFPSDEFDLOGIC");
      exportModelMap.put("PSSYSSQLCMD", "T_SRFPSSYSSQLCMD");
      exportModelMap.put("PSDEACTIONTEMPL", "T_SRFPSDEACTIONTEMPL");
      exportModelMap.put("PSAPPMENU", "T_SRFPSAPPMENU");
      exportModelMap.put("PSDEWIZARDFORM", "T_SRFPSDEWIZARDFORM");
      exportModelMap.put("PSAPPLOCALDE", "T_SRFPSAPPLOCALDE");
      exportModelMap.put("PSDEACMODEITEM", "T_SRFPSDEACMODEITEM");
      exportModelMap.put("PSWXMENUITEM", "T_SRFPSWXMENUITEM");
      exportModelMap.put("PSSYSBDPART", "T_SRFPSSYSBDPART");
      exportModelMap.put("PSWFLINKCOND", "T_SRFPSWFLINKCOND");
      exportModelMap.put("PSDEDRDETAIL", "T_SRFPSDEDRDETAIL");
      exportModelMap.put("PSDEFIUPDATE", "T_SRFPSDEFIUPDATE");
      exportModelMap.put("PSSYSDYNAMODEL", "T_SRFPSSYSDYNAMODEL");
      exportModelMap.put("PSDESADETAIL", "T_SRFPSDESADETAIL");
      exportModelMap.put("PSMOBAPPPACKTD", "T_SRFPSMOBAPPPACKTD");
      exportModelMap.put("PSDEDATAIMP", "T_SRFPSDEDATAIMP");
      exportModelMap.put("PSAPPWFVER", "T_SRFPSAPPWFVER");
      exportModelMap.put("PSDEMSOPPRIV", "T_SRFPSDEMSOPPRIV");
      exportModelMap.put("PSSYSBDINSTCFG", "T_SRFPSSYSBDINSTCFG");
      exportModelMap.put("PSDETREENODECOL", "T_SRFPSDETREENODECOL");
      exportModelMap.put("PSPANELENGINE", "T_SRFPSPANELENGINE");
      exportModelMap.put("PSSYSIMAGE", "T_SRFPSSYSIMAGE");
      exportModelMap.put("PSWFROLE", "T_SRFPSWFROLE");
      exportModelMap.put("PSDEFVALUERULE", "T_SRFPSDEFVALUERULE");
      exportModelMap.put("PSDERGROUP", "T_SRFPSDERGROUP");
      exportModelMap.put("PSDEDQJOIN", "T_SRFPSDEDQJOIN");
      exportModelMap.put("PSSYSCSS", "T_SRFPSSYSCSS");
      exportModelMap.put("PSDEFFORMITEM", "T_SRFPSDEFFORMITEM");
      exportModelMap.put("PSWFLINKCOND", "T_SRFPSWFLINKCOND");
      exportModelMap.put("PSWFLINK", "T_SRFPSWFLINK");
      exportModelMap.put("PSDEAWGRPDETAIL", "T_SRFPSDEAWGRPDETAIL");
      exportModelMap.put("PSWFROLE", "T_SRFPSWFROLE");
      exportModelMap.put("PSSYSCALENDAR", "T_SRFPSSYSCALENDAR");
      exportModelMap.put("PSWXMENUITEM", "T_SRFPSWXMENUITEM");
      exportModelMap.put("PSCTRLMSG", "T_SRFPSCTRLMSG");
      exportModelMap.put("PSSYSDICTCAT", "T_SRFPSSYSDICTCAT");
      exportModelMap.put("PSSYSVIEWLOGIC", "T_SRFPSSYSVIEWLOGIC");
      exportModelMap.put("PSSYSSFPLUGIN", "T_SRFPSSYSSFPLUGIN");
      exportModelMap.put("PSDECHART", "T_SRFPSDECHART");
      exportModelMap.put("PSAPPWF", "T_SRFPSAPPWF");
      exportModelMap.put("PSDEUIACTION", "T_SRFPSDEUIACTION");
      exportModelMap.put("PSWFWORKTIME", "T_SRFPSWFWORKTIME");
      exportModelMap.put("PSDEPRINT", "T_SRFPSDEPRINT");
      exportModelMap.put("PSSUBSYSSERVICEAPI", "T_SRFPSSUBSYSSERVICEAPI");
      exportModelMap.put("PSDEGEIUDETAIL", "T_SRFPSDEGEIUDETAIL");
      exportModelMap.put("PSAPPUITHEME", "T_SRFPSAPPUITHEME");
      exportModelMap.put("PSDEUIACTION", "T_SRFPSDEUIACTION");
      exportModelMap.put("PSSYSIMAGE", "T_SRFPSSYSIMAGE");
      exportModelMap.put("PSWORKFLOW", "T_SRFPSWORKFLOW");
      exportModelMap.put("PSSYSTITLEBAR", "T_SRFPSSYSTITLEBAR");
      exportModelMap.put("PSCTRLMSGITEM", "T_SRFPSCTRLMSGITEM");
      exportModelMap.put("PSSYSDMVER", "T_SRFPSSYSDMVER");
      exportModelMap.put("PSDELLCOND", "T_SRFPSDELLCOND");
      exportModelMap.put("PSWFVERSION", "T_SRFPSWFVERSION");
      exportModelMap.put("PSPANELLLCOND", "T_SRFPSPANELLLCOND");
      exportModelMap.put("PSDEDBCFG", "T_SRFPSDEDBCFG");
      exportModelMap.put("PSAPPMODULE", "T_SRFPSAPPMODULE");
      exportModelMap.put("PSDEVIEWLOGIC", "T_SRFPSDEVIEWLOGIC");
      exportModelMap.put("PSWXACCOUNT", "T_SRFPSWXACCOUNT");
      exportModelMap.put("PSDEOPPRIV", "T_SRFPSDEOPPRIV");
      exportModelMap.put("PSAPPUTILPAGE", "T_SRFPSAPPUTILPAGE");
      exportModelMap.put("PSDEOPPRIV", "T_SRFPSDEOPPRIV");
      exportModelMap.put("PSSYSCALENDARITEMRV", "T_SRFPSSYSCALENDARITEMRV");
      exportModelMap.put("PSSYSSQLCMDSQL", "T_SRFPSSYSSQLCMDSQL");
      exportModelMap.put("PSDEDATARELATION", "T_SRFPSDEDATARELATION");
      exportModelMap.put("PSDETABLE", "T_SRFPSDETABLE");
      exportModelMap.put("PSDESAMPLEDATAREF", "T_SRFPSDESAMPLEDATAREF");
      exportModelMap.put("PSSYSBDSCHEME", "T_SRFPSSYSBDSCHEME");
      exportModelMap.put("PSDEMAPDQ", "T_SRFPSDEMAPDQ");
      exportModelMap.put("PSSYSUNIT", "T_SRFPSSYSUNIT");
      exportModelMap.put("PSDEDRITEM", "T_SRFPSDEDRITEM");
      exportModelMap.put("PSSYSTCINPUT", "T_SRFPSSYSTCINPUT");
      exportModelMap.put("PSACHANDLERACTION", "T_SRFPSACHANDLERACTION");
      exportModelMap.put("PSSYSBACKSERVICE", "T_SRFPSSYSBACKSERVICE");
      exportModelMap.put("PSDEUAGRPDETAIL", "T_SRFPSDEUAGRPDETAIL");
      exportModelMap.put("PSLANGUAGE", "T_SRFPSLANGUAGE");
      exportModelMap.put("PSDETBITEM", "T_SRFPSDETBITEM");
      exportModelMap.put("PSDELOGIC", "T_SRFPSDELOGIC");
      exportModelMap.put("PSDECHARTPARAM", "T_SRFPSDECHARTPARAM");
      exportModelMap.put("PSDEVIEWRV", "T_SRFPSDEVIEWRV");
      exportModelMap.put("PSSYSUNIRES", "T_SRFPSSYSUNIRES");
      exportModelMap.put("PSDEDSCODE", "T_SRFPSDEDSCODE");
      exportModelMap.put("PSDETREEVIEW", "T_SRFPSDETREEVIEW");
      exportModelMap.put("PSSYSERMAPNODE", "T_SRFPSSYSERMAPNODE");
      exportModelMap.put("PSSYSDBVALUEOP", "T_SRFPSSYSDBVALUEOP");
      exportModelMap.put("PSDEGRIDCOL", "T_SRFPSDEGRIDCOL");
      exportModelMap.put("PSDEFDTCOL", "T_SRFPSDEFDTCOL");
      exportModelMap.put("PSSYSDELOGICNODE", "T_SRFPSSYSDELOGICNODE");
      exportModelMap.put("PSSYSUNIT", "T_SRFPSSYSUNIT");
      exportModelMap.put("PSSYSPORTLET", "T_SRFPSSYSPORTLET");
      exportModelMap.put("PSSYSBDMODULE", "T_SRFPSSYSBDMODULE");
      exportModelMap.put("PSDETREEVIEW", "T_SRFPSDETREEVIEW");
      exportModelMap.put("PSSYSTEMDBCFG", "T_SRFPSSYSTEMDBCFG");
      exportModelMap.put("PSSYSDYNAMODEL", "T_SRFPSSYSDYNAMODEL");
      exportModelMap.put("PSDEDQCODEEXP", "T_SRFPSDEDQCODEEXP");
      exportModelMap.put("PSSUBSYSSADETAIL", "T_SRFPSSUBSYSSADETAIL");
      exportModelMap.put("PSDEDSGRPPARAM", "T_SRFPSDEDSGRPPARAM");
      exportModelMap.put("PSDEREPORT", "T_SRFPSDEREPORT");
      exportModelMap.put("PSSYSCOUNTERITEM", "T_SRFPSSYSCOUNTERITEM");
      exportModelMap.put("PSSYSDBSCHEME", "T_SRFPSSYSDBSCHEME");
      exportModelMap.put("PSDEMAINSTATE", "T_SRFPSDEMAINSTATE");
      exportModelMap.put("PSDEMAINSTATERS", "T_SRFPSDEMAINSTATERS");
      exportModelMap.put("PSDEOPPRIV", "T_SRFPSDEOPPRIV");
      exportModelMap.put("PSWXACCOUNT", "T_SRFPSWXACCOUNT");
      exportModelMap.put("PSSYSPDTVIEW", "T_SRFPSSYSPDTVIEW");
      exportModelMap.put("PSSYSPFPLUGIN", "T_SRFPSSYSPFPLUGIN");
      exportModelMap.put("PSDEDTSQUEUE", "T_SRFPSDEDTSQUEUE");
      exportModelMap.put("PSWFLINKROLE", "T_SRFPSWFLINKROLE");
      exportModelMap.put("PSDEFORMDETAIL", "T_SRFPSDEFORMDETAIL");
      exportModelMap.put("PSSYSUSERDR", "T_SRFPSSYSUSERDR");
      exportModelMap.put("PSSYSCSSCAT", "T_SRFPSSYSCSSCAT");
      exportModelMap.put("PSSYSVIEWPANEL", "T_SRFPSSYSVIEWPANEL");
      exportModelMap.put("PSDETREECOL", "T_SRFPSDETREECOL");
      exportModelMap.put("PSAPPPVPART", "T_SRFPSAPPPVPART");
      exportModelMap.put("PSWFPROCSUBWF", "T_SRFPSWFPROCSUBWF");
      exportModelMap.put("PSSYSDICTCAT", "T_SRFPSSYSDICTCAT");
      exportModelMap.put("PSSYSVIEWPANELMODEL", "T_SRFPSSYSVIEWPANELMODEL");
      exportModelMap.put("PSDEMSACTION", "T_SRFPSDEMSACTION");
      exportModelMap.put("PSSYSSAHANDLER", "T_SRFPSSYSSAHANDLER");
      exportModelMap.put("PSSYSDBPART", "T_SRFPSSYSDBPART");
      exportModelMap.put("PSDEFVRCOND", "T_SRFPSDEFVRCOND");
      exportModelMap.put("PSDELOGICPARAM", "T_SRFPSDELOGICPARAM");
      exportModelMap.put("PSSYSWFSETTING", "T_SRFPSSYSWFSETTING");
      exportModelMap.put("PSAPPPVPART", "T_SRFPSAPPPVPART");
      exportModelMap.put("PSDEDATAEXP", "T_SRFPSDEDATAEXP");
      exportModelMap.put("PSSYSTDITEM", "T_SRFPSSYSTDITEM");
      exportModelMap.put("PSDEUAGROUP", "T_SRFPSDEUAGROUP");
      exportModelMap.put("PSSYSDBCOLUMN", "T_SRFPSSYSDBCOLUMN");
      exportModelMap.put("PSDATAENTITY", "T_SRFPSDATAENTITY");
      exportModelMap.put("PSMOBAPPPACK", "T_SRFPSMOBAPPPACK");
      exportModelMap.put("PSDERDEFMAP", "T_SRFPSDERDEFMAP");
      exportModelMap.put("PSDEUTILDE", "T_SRFPSDEUTILDE");
      exportModelMap.put("PSSYSPORTLET", "T_SRFPSSYSPORTLET");
      exportModelMap.put("PSWFDE", "T_SRFPSWFDE");
      exportModelMap.put("PSDEGRIDCOL", "T_SRFPSDEGRIDCOL");
      exportModelMap.put("PSSYSCODESNIPPET", "T_SRFPSSYSCODESNIPPET");
      exportModelMap.put("PSDEDSDQ", "T_SRFPSDEDSDQ");
      exportModelMap.put("PSSYSEDITORSTYLE", "T_SRFPSSYSEDITORSTYLE");
      exportModelMap.put("PSSYSSFPUB", "T_SRFPSSYSSFPUB");
      exportModelMap.put("PSDELISTITEM", "T_SRFPSDELISTITEM");
      exportModelMap.put("PSSYSSFPUBPKG", "T_SRFPSSYSSFPUBPKG");
      exportModelMap.put("PSWFPROCPARAM", "T_SRFPSWFPROCPARAM");
      exportModelMap.put("PSSYSDASHBOARD", "T_SRFPSSYSDASHBOARD");
      exportModelMap.put("PSSYSMODELGROUP", "T_SRFPSSYSMODELGROUP");
      exportModelMap.put("PSDEDBIDXFIELD", "T_SRFPSDEDBIDXFIELD");
      exportModelMap.put("PSSYSVIEWPANEL", "T_SRFPSSYSVIEWPANEL");
      exportModelMap.put("PSDEDBINDEX", "T_SRFPSDEDBINDEX");
      exportModelMap.put("PSDEMAPDETAIL", "T_SRFPSDEMAPDETAIL");
      exportModelMap.put("PSDEACTIONTEMPL", "T_SRFPSDEACTIONTEMPL");
      exportModelMap.put("PSDETBITEM", "T_SRFPSDETBITEM");
      exportModelMap.put("PSSYSDBVF", "T_SRFPSSYSDBVF");
      exportModelMap.put("PSSYSDBVFCODE", "T_SRFPSSYSDBVFCODE");
      exportModelMap.put("PSDEFIVR", "T_SRFPSDEFIVR");
      exportModelMap.put("PSSYSBDTABLEDE", "T_SRFPSSYSBDTABLEDE");
      exportModelMap.put("PSSYSCOUNTER", "T_SRFPSSYSCOUNTER");
      exportModelMap.put("PSLANGUAGEITEM", "T_SRFPSLANGUAGEITEM");
      exportModelMap.put("PSDESERVICEAPI", "T_SRFPSDESERVICEAPI");
      exportModelMap.put("PSCODEITEM", "T_SRFPSCODEITEM");
      exportModelMap.put("PSVIEWMSGGROUP", "T_SRFPSVIEWMSGGROUP");
      exportModelMap.put("PSWFSUBWF", "T_SRFPSWFSUBWF");
      exportModelMap.put("PSDEGRID", "T_SRFPSDEGRID");
      exportModelMap.put("PSACHANDLER", "T_SRFPSACHANDLER");
      exportModelMap.put("PSSYSBDCOLUMN", "T_SRFPSSYSBDCOLUMN");
      exportModelMap.put("PSWXMENUFUNC", "T_SRFPSWXMENUFUNC");
      exportModelMap.put("PSACHANDLER", "T_SRFPSACHANDLER");
      exportModelMap.put("PSMOBAPPSTARTPAGE", "T_SRFPSMOBAPPSTARTPAGE");
      exportModelMap.put("PSDEDATAIMPITEM", "T_SRFPSDEDATAIMPITEM");
      exportModelMap.put("PSSYSPFPITEMPL", "T_SRFPSSYSPFPITEMPL");
      exportModelMap.put("PSAPPTITLEBAR", "T_SRFPSAPPTITLEBAR");
      exportModelMap.put("PSDELOGICNODE", "T_SRFPSDELOGICNODE");
      exportModelMap.put("PSPANELLOGICPARAM", "T_SRFPSPANELLOGICPARAM");
      exportModelMap.put("PSSYSTESTCASE", "T_SRFPSSYSTESTCASE");
      exportModelMap.put("PSDEDATAVIEW", "T_SRFPSDEDATAVIEW");
      exportModelMap.put("PSVIEWMSG", "T_SRFPSVIEWMSG");
      exportModelMap.put("PSDEDATAQUERY", "T_SRFPSDEDATAQUERY");
      exportModelMap.put("PSDEFINPUTTIP", "T_SRFPSDEFINPUTTIP");
      exportModelMap.put("PSSYSPDTVIEW", "T_SRFPSSYSPDTVIEW");
      exportModelMap.put("PSSYSTESTDATA", "T_SRFPSSYSTESTDATA");
      exportModelMap.put("PSDETREENODE", "T_SRFPSDETREENODE");
      exportModelMap.put("PSAPPMENUITEM", "T_SRFPSAPPMENUITEM");
      exportModelMap.put("PSSYSBDTABLEDER", "T_SRFPSSYSBDTABLEDER");
      exportModelMap.put("PSSYSBDTABLERS", "T_SRFPSSYSBDTABLERS");
      exportModelMap.put("PSSYSREF", "T_SRFPSSYSREF");
      exportModelMap.put("PSCODEITEM", "T_SRFPSCODEITEM");
      exportModelMap.put("PSWFUTILUIACTION", "T_SRFPSWFUTILUIACTION");
      exportModelMap.put("PSAPPMENUITEM", "T_SRFPSAPPMENUITEM");
      exportModelMap.put("PSDEUIACTION", "T_SRFPSDEUIACTION");
      exportModelMap.put("PSLANGUAGERES", "T_SRFPSLANGUAGERES");
      exportModelMap.put("PSDEDQJOIN", "T_SRFPSDEDQJOIN");
      exportModelMap.put("PSSYSDASHBOARD", "T_SRFPSSYSDASHBOARD");
      exportModelMap.put("PSDEFVRCOND", "T_SRFPSDEFVRCOND");
      exportModelMap.put("PSSYSSFPITEMPL", "T_SRFPSSYSSFPITEMPL");
      exportModelMap.put("PSSYSCSS", "T_SRFPSSYSCSS");
      exportModelMap.put("PSWORKFLOW", "T_SRFPSWORKFLOW");
      exportModelMap.put("PSSYSTEMRUN", "T_SRFPSSYSTEMRUN");
      exportModelMap.put("PSPANELLOGICLINK", "T_SRFPSPANELLOGICLINK");
      exportModelMap.put("PSSYSSEARCHBAR", "T_SRFPSSYSSEARCHBAR");
      exportModelMap.put("PSDEDATASET", "T_SRFPSDEDATASET");
      exportModelMap.put("PSSYSMSGTEMPL", "T_SRFPSSYSMSGTEMPL");
      exportModelMap.put("PSDEFORMDETAIL", "T_SRFPSDEFORMDETAIL");
      exportModelMap.put("PSDEFORM", "T_SRFPSDEFORM");
      exportModelMap.put("PSWFUTILUIACTION", "T_SRFPSWFUTILUIACTION");
      exportModelMap.put("PSSYSDELOGICNODE", "T_SRFPSSYSDELOGICNODE");
      exportModelMap.put("PSDEREPITEM", "T_SRFPSDEREPITEM");
      exportModelMap.put("PSSYSDYNAMODELATTR", "T_SRFPSSYSDYNAMODELATTR");
      exportModelMap.put("PSSYSCSSCAT", "T_SRFPSSYSCSSCAT");
      exportModelMap.put("PSACHANDLER", "T_SRFPSACHANDLER");
      exportModelMap.put("PSSYSDASHBOARD", "T_SRFPSSYSDASHBOARD");
      exportModelMap.put("PSSYSBDSCHEME", "T_SRFPSSYSBDSCHEME");
      exportModelMap.put("PSAPPPKG", "T_SRFPSAPPPKG");
      exportModelMap.put("PSDELLCOND", "T_SRFPSDELLCOND");
      exportModelMap.put("PSMODULE", "T_SRFPSMODULE");
      exportModelMap.put("PSDEMAPDS", "T_SRFPSDEMAPDS");
      exportModelMap.put("PSDEAWGROUP", "T_SRFPSDEAWGROUP");
      exportModelMap.put("PSVIEWWIZARDGROUP", "T_SRFPSVIEWWIZARDGROUP");
      exportModelMap.put("PSPANELITEMLOGIC", "T_SRFPSPANELITEMLOGIC");
      exportModelMap.put("PSDEMAP", "T_SRFPSDEMAP");
      exportModelMap.put("PSDEGROUP", "T_SRFPSDEGROUP");
      exportModelMap.put("PSWXENTAPP", "T_SRFPSWXENTAPP");
      exportModelMap.put("PSDEDATASYNC", "T_SRFPSDEDATASYNC");
      exportModelMap.put("PSAPPLAN", "T_SRFPSAPPLAN");
      exportModelMap.put("PSSYSSAHANDLER", "T_SRFPSSYSSAHANDLER");
      exportModelMap.put("PSSYSERMAP", "T_SRFPSSYSERMAP");
      exportModelMap.put("PSDEAWITEM", "T_SRFPSDEAWITEM");
      exportModelMap.put("PSDEDRGROUP", "T_SRFPSDEDRGROUP");
      exportModelMap.put("PSPANELLLCOND", "T_SRFPSPANELLLCOND");
      exportModelMap.put("PSSYSUSERROLERES", "T_SRFPSSYSUSERROLERES");
      exportModelMap.put("PSSYSUSERROLEDATA", "T_SRFPSSYSUSERROLEDATA");
      exportModelMap.put("PSDEDQCOND", "T_SRFPSDEDQCOND");
      exportModelMap.put("PSDEVIEWBASE", "T_SRFPSDEVIEWBASE");
      exportModelMap.put("PSDETOOLBAR", "T_SRFPSDETOOLBAR");
      exportModelMap.put("PSSYSVIEWLOGICPARAM", "T_SRFPSSYSVIEWLOGICPARAM");
      exportModelMap.put("PSSYSUNISTATE", "T_SRFPSSYSUNISTATE");
      exportModelMap.put("PSDEFIUDETAIL", "T_SRFPSDEFIUDETAIL");
      exportModelMap.put("PSDEUSERROLE", "T_SRFPSDEUSERROLE");
      exportModelMap.put("PSDEDQCOND", "T_SRFPSDEDQCOND");
      exportModelMap.put("PSSYSAPP", "T_SRFPSSYSAPP");
      exportModelMap.put("PSSYSTCASSERT", "T_SRFPSSYSTCASSERT");
      exportModelMap.put("PSVIEWMSGGRPDETAIL", "T_SRFPSVIEWMSGGRPDETAIL");
      exportModelMap.put("PSDEDQCODE", "T_SRFPSDEDQCODE");
      exportModelMap.put("PSDELOGICLINK", "T_SRFPSDELOGICLINK");
      exportModelMap.put("PSWFPROCROLE", "T_SRFPSWFPROCROLE");
      exportModelMap.put("PSSYSVIEWPANELLOGIC", "T_SRFPSSYSVIEWPANELLOGIC");
      exportModelMap.put("PSSYSCALENDAR", "T_SRFPSSYSCALENDAR");
      exportModelMap.put("PSSYSVIEWPANELITEM", "T_SRFPSSYSVIEWPANELITEM");
      exportModelMap.put("PSAPPDEVIEW", "V_PSAPPDEVIEW");
      exportModelMap.put("PSAPPDYNADEVIEW", "V_PSAPPDYNADEVIEW");
      exportModelMap.put("PSAPPINDEXVIEW", "V_PSAPPINDEXVIEW");
      exportModelMap.put("PSAPPPANELVIEW", "V_PSAPPPANELVIEW");
      exportModelMap.put("PSAPPPORTALVIEW", "V_PSAPPPORTALVIEW");
      exportModelMap.put("PSAPPUTILVIEW", "V_PSAPPUTILVIEW");
      exportModelMap.put("PSDEUAGROUP", "T_SRFPSDEUAGROUP");
      exportModelMap.put("PSDEDQCODECOND", "T_SRFPSDEDQCODECOND");
      exportModelMap.put("PSSYSFILE", "T_SRFPSSYSFILE");
      exportModelMap.put("PSAPPPDTVIEW", "T_SRFPSAPPPDTVIEW");
      exportModelMap.put("PSWFPROCESS", "T_SRFPSWFPROCESS");
      exportModelMap.put("PSDEVIEWENGINE", "T_SRFPSDEVIEWENGINE");
      exportModelMap.put("PSPANELLNPARAM", "T_SRFPSPANELLNPARAM");
      exportModelMap.put("PSDEFORMRF", "T_SRFPSDEFORMRF");
      exportModelMap.put("PSDEOPPRIVROLE", "T_SRFPSDEOPPRIVROLE");
      exportModelMap.put("PSAPPUSERMODE", "T_SRFPSAPPUSERMODE");
      exportModelMap.put("PSSUBVIEWTYPE", "T_SRFPSSUBVIEWTYPE");
      exportModelMap.put("PSSYSSERVICEAPI", "T_SRFPSSYSSERVICEAPI");
      exportModelMap.put("PSDERGROUPDETAIL", "T_SRFPSDERGROUPDETAIL");
      exportModelMap.put("PSSYSCALENDAR", "T_SRFPSSYSCALENDAR");
      exportModelMap.put("PSWXLOGIC", "T_SRFPSWXLOGIC");
      exportModelMap.put("PSDEWIZARDSTEP", "T_SRFPSDEWIZARDSTEP");
      exportModelMap.put("PSDEACMODE", "T_SRFPSDEACMODE");
      exportModelMap.put("PSMODULE", "T_SRFPSMODULE");
      exportModelMap.put("PSDELISTITEM", "T_SRFPSDELISTITEM");
      exportModelMap.put("PSDEVIEWCTRL", "T_SRFPSDEVIEWCTRL");
      exportModelMap.put("PSDER", "T_SRFPSDER");
      exportModelMap.put("PSDEDSPARAM", "T_SRFPSDEDSPARAM");
      exportModelMap.put("PSDEFGROUP", "T_SRFPSDEFGROUP");
      exportModelMap.put("PSDEFGROUPDETAIL", "T_SRFPSDEFGROUPDETAIL");
      exportModelMap.put("PSDESARS", "T_SRFPSDESARS");
      exportModelMap.put("PSAPPDERS", "T_SRFPSAPPDERS");
      exportModelMap.put("PSAPPDERSVIEW", "T_SRFPSAPPDERSVIEW");
      exportModelMap.put("PSSUBSYSSADE", "T_SRFPSSUBSYSSADE");
      exportModelMap.put("PSSUBSYSSADEFIELD", "T_SRFPSSUBSYSSADEFIELD");
      exportModelMap.put("PSSUBSYSSADERS", "T_SRFPSSUBSYSSADERS");
      exportModelMap.put("PSSYSOPPRIV", "T_SRFPSSYSOPPRIV");
      exportModelMap.put("PSSYSDBPROC", "T_SRFPSSYSDBPROC");
      exportModelMap.put("PSSYSDBPROCPARAM", "T_SRFPSSYSDBPROCPARAM");
      exportModelMap.put("PSSYSSAMPLEVALUE", "T_SRFPSSYSSAMPLEVALUE");
      exportModelMap.put("PSDESAVR", "T_SRFPSDESAVR");
      exportModelMap.put("PSSYSCONTENT", "T_SRFPSSYSCONTENT");
      exportModelMap.put("PSSYSRESOURCE", "T_SRFPSSYSRESOURCE");
      exportModelMap.put("PSAPPSTORYBOARD", "T_SRFPSAPPSTORYBOARD");
      exportModelMap.put("PSAPPSBITEMRS", "T_SRFPSAPPSBITEMRS");
      exportModelMap.put("PSAPPSBITEM", "T_SRFPSAPPSBITEM");
      exportModelMap.put("PSAPPRESOURCE", "T_SRFPSAPPRESOURCE");
      exportModelMap.put("PSSYSREQITEM", "T_SRFPSSYSREQITEM");
      exportModelMap.put("PSSYSREQITEMDATA", "T_SRFPSSYSREQITEMDATA");
      exportModelMap.put("PSSYSREQITEMHIS", "T_SRFPSSYSREQITEMHIS");
      exportModelMap.put("PSSYSREQMODULE", "T_SRFPSSYSREQMODULE");
      exportModelMap.put("PSSYSCONTENTCAT", "T_SRFPSSYSCONTENTCAT");
      exportModelMap.put("PSSYSACTOR", "T_SRFPSSYSACTOR");
      exportModelMap.put("PSSYSUSERCASE", "T_SRFPSSYSUSERCASE");
      exportModelMap.put("PSSYSUSERCASERS", "T_SRFPSSYSUSERCASERS");
      exportModelMap.put("PSSYSUCMAP", "T_SRFPSSYSUCMAP");
      exportModelMap.put("PSSYSUCMAPNODE", "T_SRFPSSYSUCMAPNODE");
      exportModelMap.put("PSSYSTESTPRJ", "T_SRFPSSYSTESTPRJ");
      exportModelMap.put("PSSYSTESTMODULE", "T_SRFPSSYSTESTMODULE");
      exportModelMap.put("PSHELPPRJ", "T_SRFPSHELPPRJ");
      exportModelMap.put("PSHELPRESOURCE", "T_SRFPSHELPRESOURCE");
      exportModelMap.put("PSHELPMODULE", "T_SRFPSHELPMODULE");
      exportModelMap.put("PSHELPARTICLE", "T_SRFPSHELPARTICLE");
      exportModelMap.put("PSHELPSECTION", "T_SRFPSHELPSECTION");
      exportModelMap.put("PSCTRLLOGICGROUP", "T_SRFPSCTRLLOGICGROUP");
      exportModelMap.put("PSCTRLLOGICGRPDETAIL", "T_SRFPSCTRLLOGICGRPDETAIL");
      exportModelMap.put("PSSYSSEARCHSCHEME", "T_SRFPSSYSSEARCHSCHEME");
      exportModelMap.put("PSSYSSEARCHDOC", "T_SRFPSSYSSEARCHDOC");
      exportModelMap.put("PSSYSSEARCHFIELD", "T_SRFPSSYSSEARCHFIELD");
      exportModelMap.put("PSSYSSEARCHDE", "T_SRFPSSYSSEARCHDE");
      exportModelMap.put("PSSYSSEARCHDEFIELD", "T_SRFPSSYSSEARCHDEFIELD");
      exportModelMap.put("PSSYSMAPVIEW", "T_SRFPSSYSMAPVIEW");
      exportModelMap.put("PSSYSMAPITEM", "T_SRFPSSYSMAPITEM");
      exportModelMap.put("PSSYSPORTLETCAT", "T_SRFPSSYSPORTLETCAT");
      exportModelMap.put("PSAPPPORTLET", "T_SRFPSAPPPORTLET");
      exportModelMap.put("PSSYSDEFTYPE", "T_SRFPSSYSDEFTYPE");
      exportModelMap.put("PSSYSWFCAT", "T_SRFPSSYSWFCAT");
      exportModelMap.put("PSAPPSTORYBOARD", "T_SRFPSAPPSTORYBOARD");
      exportModelMap.put("PSAPPSBITEM", "T_SRFPSAPPSBITEM");
      exportModelMap.put("PSAPPSBITEMRS", "T_SRFPSAPPSBITEMRS");
      exportModelMap.put("PSDEGEIVR", "T_SRFPSDEGEIVR");
      exportModelMap.put("PSDEACTIONVR", "T_SRFPSDEACTIONVR");
      exportModelMap.put("PSDEGROUPDETAIL", "T_SRFPSDEGROUPDETAIL");
      exportModelMap.put("PSDEAGDETAIL", "T_SRFPSDEAGDETAIL");
      exportModelMap.put("PSDEACTIONGROUP", "T_SRFPSDEACTIONGROUP");
      exportModelMap.put("PSDEFINPUTTIPSET", "T_SRFPSDEFINPUTTIPSET");
      exportModelMap.put("PSSYSMODELFOLDER", "T_SRFPSSYSMODELFOLDER");
      exportModelMap.put("PSSYSMODELFOLDERITEM", "T_SRFPSSYSMODELFOLDERITEM");
      exportModelMap.put("PSDEMSFIELD", "T_SRFPSDEMSFIELD");
      exportModelMap.put("PSSYSSEQUENCE", "T_SRFPSSYSSEQUENCE");
      exportModelMap.put("PSSYSTRANSLATOR", "T_SRFPSSYSTRANSLATOR");
      exportModelMap.put("PSSYSMSGQUEUE", "T_SRFPSSYSMSGQUEUE");
      exportModelMap.put("PSSYSMSGTARGET", "T_SRFPSSYSMSGTARGET");
      exportModelMap.put("PSDENOTIFY", "T_SRFPSDENOTIFY");
      exportModelMap.put("PSDENOTIFYTARGET", "T_SRFPSDENOTIFYTARGET");
      exportModelMap.put("PSSYSEAIDATATYPEITEM", "T_SRFPSSYSEAIDATATYPEITEM");
      exportModelMap.put("PSSYSEAIDER", "T_SRFPSSYSEAIDER");
      exportModelMap.put("PSSYSEAIDEFIELD", "T_SRFPSSYSEAIDEFIELD");
      exportModelMap.put("PSSYSEAIDE", "T_SRFPSSYSEAIDE");
      exportModelMap.put("PSSYSEAIELEMENTRE", "T_SRFPSSYSEAIELEMENTRE");
      exportModelMap.put("PSSYSEAIELEMENTATTR", "T_SRFPSSYSEAIELEMENTATTR");
      exportModelMap.put("PSSYSEAIELEMENT", "T_SRFPSSYSEAIELEMENT");
      exportModelMap.put("PSSYSEAIDATATYPE", "T_SRFPSSYSEAIDATATYPE");
      exportModelMap.put("PSSYSEAISCHEME", "T_SRFPSSYSEAISCHEME");
      exportModelMap.put("PSSYSBIAGGCOLUMN", "T_SRFPSSYSBIAGGCOLUMN");
      exportModelMap.put("PSSYSBIAGGTABLE", "T_SRFPSSYSBIAGGTABLE");
      exportModelMap.put("PSSYSBICUBELEVEL", "T_SRFPSSYSBICUBELEVEL");
      exportModelMap.put("PSSYSBICUBEMEASURE", "T_SRFPSSYSBICUBEMEASURE");
      exportModelMap.put("PSSYSBICUBEDIMENSION", "T_SRFPSSYSBICUBEDIMENSION");
      exportModelMap.put("PSSYSBILEVEL", "T_SRFPSSYSBILEVEL");
      exportModelMap.put("PSSYSBIHIERARCHY", "T_SRFPSSYSBIHIERARCHY");
      exportModelMap.put("PSSYSBIDIMENSION", "T_SRFPSSYSBIDIMENSION");
      exportModelMap.put("PSSYSBICUBE", "T_SRFPSSYSBICUBE");
      exportModelMap.put("PSSYSBISCHEME", "T_SRFPSSYSBISCHEME");
      exportModelMap.put("PSTHRESHOLD", "T_SRFPSTHRESHOLD");
      exportModelMap.put("PSTHRESHOLDGROUP", "T_SRFPSTHRESHOLDGROUP");
      exportModelMap.put("PSSYSCHARTTHEME", "T_SRFPSSYSCHARTTHEME");
      exportModelMap.put("PSSYSCANVAS", "T_SRFPSSYSCANVAS");
      exportModelMap.put("PSSYSCANVASMODEL", "T_SRFPSSYSCANVASMODEL");
      exportModelMap.put("PSDEVRGROUP", "T_SRFPSDEVRGROUP");
      exportModelMap.put("PSDEVRGRPDETAIL", "T_SRFPSDEVRGRPDETAIL");
      exportModelMap.put("PSSYSDASHBOARDLOGIC", "T_SRFPSSYSDASHBOARDLOGIC");
      exportModelMap.put("PSAPPMENULOGIC", "T_SRFPSAPPMENULOGIC");
      exportModelMap.put("PSDEFORMLOGIC", "T_SRFPSDEFORMLOGIC");
      exportModelMap.put("PSSYSSEARCHBARLOGIC", "T_SRFPSSYSSEARCHBARLOGIC");
      exportModelMap.put("PSAPPLOGIC", "T_SRFPSAPPLOGIC");
      exportModelMap.put("PSDETOOLBARLOGIC", "T_SRFPSDETOOLBARLOGIC");
      exportModelMap.put("PSDEWIZARDLOGIC", "T_SRFPSDEWIZARDLOGIC");
      exportModelMap.put("PSDELISTLOGIC", "T_SRFPSDELISTLOGIC ");
      exportModelMap.put("PSSYSMAPLOGIC", "T_SRFPSSYSMAPLOGIC");
      exportModelMap.put("PSDETREELOGIC", "T_SRFPSDETREELOGIC");
      exportModelMap.put("PSDEDATAVIEWLOGIC", "T_SRFPSDEDATAVIEWLOGIC");
      exportModelMap.put("PSSYSCALENDARLOGIC", "T_SRFPSSYSCALENDARLOGIC");
      exportModelMap.put("PSDEGRIDLOGIC", "T_SRFPSDEGRIDLOGIC");
      exportModelMap.put("PSDECHARTLOGIC", "T_SRFPSDECHARTLOGIC");
      exportModelMap.put("PSDEDRLOGIC", "T_SRFPSDEDRLOGIC");
      exportModelMap.put("PSSYSUSECASECAT", "T_SRFPSSYSUSECASECAT");
      exportModelMap.put("PSDETEIUDETAIL", "T_SRFPSDETEIUDETAIL");
      exportModelMap.put("PSDETEIUPDATE", "T_SRFPSDETEIUPDATE");
      exportModelMap.put("PSSYSBIREPORT", "T_SRFPSSYSBIREPORT");
      exportModelMap.put("PSSYSBIREPORTITEM", "T_SRFPSSYSBIREPORTITEM");
      exportModelMap.put("PSAPPPFPLUGIN", "T_SRFPSAPPPFPLUGIN");
      exportModelMap.put("PSSYSAICHATAGENT", "T_SRFPSSYSAICHATAGENT");
      exportModelMap.put("PSSYSAIFACTORY", "T_SRFPSSYSAIFACTORY");
      exportModelMap.put("PSSYSAIPIPELINEAGENT", "T_SRFPSSYSAIPIPELINEAGENT");
      exportModelMap.put("PSSYSAIPIPELINEJOB", "T_SRFPSSYSAIPIPELINEJOB");
      exportModelMap.put("PSSYSAIPIPELINEWORKER", "T_SRFPSSYSAIPIPELINEWORKER");
      exportModelMap.put("PSSYSAIWORKERAGENT", "T_SRFPSSYSAIWORKERAGENT");
   }

   protected class BackupHelper implements IPSRawSelectWork {
      private IDataEntityModel iDataEntityModel = null;
      private String strModelFolder = null;
      private IService iService = null;

      public BackupHelper(String var2, IService var3, IDataEntityModel var4) throws Exception {
         this.iService = var3;
         if (var4 != null) {
            this.iDataEntityModel = var4;
         } else {
            this.iDataEntityModel = this.iService.getDEModel();
         }

         this.strModelFolder = var2 + File.separator + this.iDataEntityModel.getName();
         File var5 = new File(this.strModelFolder);
         if (!var5.exists()) {
            var5.mkdirs();
         }
      }

      @Override
      public void process(IDataTable var1) throws Exception {
         short var2 = 2000;

         int var3;
         do {
            var3 = var1.cacheRows(var2);

            for (int var4 = 0; var4 < var3; var4++) {
               IDataRow var5 = var1.getCachedRow(var4);
               IEntity var6 = this.iDataEntityModel.createEntity();
               DataObject.fromDataRow(var6, var5);
               String var7 = this.strModelFolder + File.separator + "ALL.txt";
               PSModelV2Helper.appendFile(var7, PSModelV2Helper.toJSONString(var6, false) + "\n\n");
            }
         } while (var3 >= var2);
      }
   }

   protected class ExportHelper implements IPSRawSelectWork {
      private String strResFolder = null;
      private IDataEntityModel iDataEntityModel = null;
      private String strModelFolder = null;
      private IPSModelV2Service iPSModelV2Service = null;
      private boolean bHasPSSystemId = false;
      private Map<String, String> linkValueMap = null;
      private int nAutoCodeNameIndex = 0;
      private boolean bExportLink = false;
      private String strKeyFieldName = null;
      private List<String> ignoreFieldList = null;

      public ExportHelper(String var2, IPSModelV2Service var3, Map<String, String> var4, List<String> var5) throws Exception {
         this.strResFolder = var2;
         this.iPSModelV2Service = var3;
         this.iDataEntityModel = this.iPSModelV2Service.getDEModel();
         this.strKeyFieldName = this.iDataEntityModel.getKeyDEField().getName();
         this.linkValueMap = var4;
         if (var5 != null && var5.size() > 0) {
            this.ignoreFieldList = var5;
         }

         this.strModelFolder = var2 + File.separator + this.iDataEntityModel.getName();
         File var6 = new File(this.strModelFolder);
         if (!var6.exists()) {
            var6.mkdirs();
         }

         if (this.iDataEntityModel.getDEField("PSSYSTEMID", true) != null) {
            this.bHasPSSystemId = true;
         }

         Iterator var7 = this.iDataEntityModel.getDERs(true);
         if (var7 != null && var7.hasNext()) {
            this.bExportLink = true;
         }

         if (!this.bExportLink && this.iDataEntityModel.getInheritDEModel() != null) {
            this.bExportLink = true;
         }
      }

      @Override
      public void process(IDataTable var1) throws Exception {
         short var2 = 2000;

         int var3;
         do {
            var3 = var1.cacheRows(var2);

            for (int var4 = 0; var4 < var3; var4++) {
               IDataRow var5 = var1.getCachedRow(var4);
               IEntity var6 = this.iDataEntityModel.createEntity();
               DataObject.fromDataRow(var6, var5);
               if (this.ignoreFieldList != null) {
                  for (String var8 : this.ignoreFieldList) {
                     var6.remove(var8);
                  }
               }

               String var12 = DataObject.getStringValue(var6.get(this.strKeyFieldName));
               if (this.bHasPSSystemId) {
                  String var13 = DataObject.getStringValue(var6.get("PSSYSTEMID"));
                  if (StringHelper.isNullOrEmpty(var13)) {
                     var6.set("PSSYSTEMID", PSModelV2Helper.this.getPSSystemId());
                  }
               }

               String var14 = this.iPSModelV2Service.getModelV2ResPath(var6, PSModelV2Helper.this.isAppendMode());
               if (!StringHelper.isNullOrEmpty(var14)) {
                  var14 = this.strResFolder + File.separator + var14;
                  File var9 = new File(var14);
                  if (!var9.getParentFile().exists()) {
                     var9.getParentFile().mkdirs();
                  }

                  if (PSModelV2Helper.this.isAppendMode()) {
                     PSModelV2Helper.appendFile(var14, PSModelV2Helper.toJSONString(var6, false) + "\n\n");
                  } else {
                     PSModelV2Helper.writeFile(var14, PSModelV2Helper.toJSONString(var6, false));
                  }

                  if (this.bExportLink) {
                     if (PSModelV2Helper.this.isAppendMode()) {
                        if (this.linkValueMap != null) {
                           var14 = StringHelper.format("%1$s/%2$s", this.iDataEntityModel.getName(), var12).toLowerCase();
                           String var10 = this.iPSModelV2Service.getModelV2ResScope(var6);
                           if (!StringHelper.isNullOrEmpty(var10)) {
                              String var11 = PSModelV2Helper.getModelV2TagFolderName(this.iPSModelV2Service.getModelV2Tag(var6));
                              if (var10.indexOf("PSSYSTEM#") == 0) {
                                 this.linkValueMap.put(var14, var11);
                              } else {
                                 this.linkValueMap.put(var14, StringHelper.format("%1$s/%2$s", var10, var11));
                              }

                              if (this.iDataEntityModel.getInheritDEModel() != null) {
                                 var14 = StringHelper.format("%1$s/%2$s", this.iDataEntityModel.getInheritDEModel().getName(), var12).toLowerCase();
                                 if (var10.indexOf("PSSYSTEM#") == 0) {
                                    this.linkValueMap.put(var14, var11);
                                 } else {
                                    this.linkValueMap.put(var14, StringHelper.format("%1$s/%2$s", var10, var11));
                                 }
                              }
                           }
                        }
                     } else {
                        var14 = this.strResFolder
                           + File.separator
                           + StringHelper.format(
                              "%1$s%2$s%3$s.txt", this.iDataEntityModel.getName(), File.separator, PSModelV2Helper.getModelV2TagFolderName(var12)
                           );
                        String var21 = this.iPSModelV2Service.getModelV2ResScope(var6);
                        if (!StringHelper.isNullOrEmpty(var21)) {
                           String var22 = PSModelV2Helper.getModelV2TagFolderName(this.iPSModelV2Service.getModelV2Tag(var6));
                           if (var21.indexOf("PSSYSTEM#") == 0) {
                              PSModelV2Helper.writeFile(var14, var22);
                           } else {
                              PSModelV2Helper.writeFile(var14, StringHelper.format("%1$s/%2$s", var21, var22));
                           }

                           if (this.iDataEntityModel.getInheritDEModel() != null) {
                              var14 = this.strResFolder
                                 + File.separator
                                 + StringHelper.format(
                                    "%1$s%2$s%3$s.txt",
                                    this.iDataEntityModel.getInheritDEModel().getName(),
                                    File.separator,
                                    PSModelV2Helper.getModelV2TagFolderName(var12)
                                 );
                              var9 = new File(var14);
                              if (!var9.getParentFile().exists()) {
                                 var9.getParentFile().mkdirs();
                              }

                              if (var21.indexOf("PSSYSTEM#") == 0) {
                                 PSModelV2Helper.writeFile(var14, var22);
                              } else {
                                 PSModelV2Helper.writeFile(var14, StringHelper.format("%1$s/%2$s", var21, var22));
                              }
                           }
                        }
                     }
                  }
               }
            }
         } while (var3 >= var2);
      }
   }
}
