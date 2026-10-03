package SA.SRFDA.PS.Core.Service;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSDEFieldRuntime;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Data.PSSubSysSADE;
import SA.SRFDA.PS.Data.PSSubSysSADEField;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSSubSysServiceAPIDEImpl extends PSObjectImpl implements IPSSubSysServiceAPIDE, IPSModelSortable {
   private static final Log log = LogFactory.getLog(PSSubSysServiceAPIDEImpl.class);
   protected PSSubSysSADE psSubSysSADE = null;
   private IPSSubSysServiceAPI iPSSubSysServiceAPI = null;
   private ArrayList<IPSSubSysServiceAPIDERS> majorPSSubSysServiceAPIDERSList = null;
   private ArrayList<IPSSubSysServiceAPIDERS> minorPSSubSysServiceAPIDERSList = null;
   protected ArrayList<IPSSubSysServiceAPIDEField> psSubSysServiceAPIDEFieldList = new ArrayList<>();
   protected Map<String, IPSSubSysServiceAPIDEField> psSubSysServiceAPIDEFieldMap = new LinkedHashMap<>();
   private Map<Integer, ArrayList<IPSSubSysServiceAPIDERS>> psSubSysSADERSPathMap = null;
   private List<IPSSubSysServiceAPIDEMethod> psSubSysServiceAPIDEMethodList = null;
   private int nAPIMode = 1;
   private IPSSubSysServiceAPIDEField keyPSSubSysServiceAPIDEField = null;
   private IPSSubSysServiceAPIDEField majorPSSubSysServiceAPIDEField = null;
   private IPSSysSFPlugin iPSSysSFPlugin = null;
   private IPSSFXCodeObject iPSSFXCodeObject = null;
   private String strCodeName = null;
   private String strServiceParam = null;
   private String strServiceParam2 = null;
   private Properties serviceParams = null;

   @Override
   public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSubSysServiceAPI iPSSubSysServiceAPI, PSSubSysSADE psSubSysSADE) throws Exception {
      try {
         this.setDAGlobalHelper(iDAGlobalHelper);
         this.setPSSubSysServiceAPI(iPSSubSysServiceAPI);
         this.psSubSysSADE = psSubSysSADE;
         this.setId(this.psSubSysSADE.getPSSUBSYSSADEID());
         this.setName(this.psSubSysSADE.getPSSUBSYSSADENAME());
         this.setPSObjectData(this.psSubSysSADE);
         this.strCodeName = this.psSubSysSADE.getCODENAME();
         if (this.isAutoModel()) {
            IPSDataEntity iPSDataEntity = this.getPSSubSysServiceAPI().getPSSystem().getPSDataEntity2(this.getId());
            if (iPSDataEntity != null) {
               this.strCodeName = this.getPSSubSysServiceAPI().getAPICodeName(null, iPSDataEntity.getServiceCodeName(), null);
            }
         }

         if (!this.psSubSysSADE.isMAJORFLAGNull()) {
            this.nAPIMode = this.psSubSysSADE.getMAJORFLAG();
         }

         this.strServiceParam = this.psSubSysSADE.getSERVICEPARAM();
         this.strServiceParam2 = this.psSubSysSADE.getSERVICEPARAM2();
         this.serviceParams = PropertiesHelper.load(this.psSubSysSADE.getSERVICEPARAMS());
         if (!StringHelper.IsNullOrEmpty(this.psSubSysSADE.getPSSYSSFPLUGINID())) {
            this.iPSSysSFPlugin = this.getPSSubSysServiceAPI().getPSSystem().getPSSysSFPlugin(this.psSubSysSADE.getPSSYSSFPLUGINID());
         } else if (!StringHelper.IsNullOrEmpty(iPSSubSysServiceAPI.getDEPSSysSFPluginId())) {
            this.iPSSysSFPlugin = this.getPSSubSysServiceAPI().getPSSystem().getPSSysSFPlugin(iPSSubSysServiceAPI.getDEPSSysSFPluginId());
         }

         if (this.getPSSysSFPlugin() != null) {
            String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId(this.getPSSysSFPlugin().getId(), this.getPSSubSysServiceAPI().getPSSystem().getPSSFId());
            IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSubSysServiceAPI().getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
            if (iPSSysSFPluginTempl != null) {
               this.iPSSFXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
            }
         }

         this.onInit();
      } catch (Exception ex) {
         String strLogName = StringHelper.Format("%1$s[%2$s]", PSModels.getModelName(this.getModelType()), this.getFullModelName());
         String strExInfo = StringHelper.Format("初始化发生异常，%1$s", ex.getMessage());
         log.error(StringHelper.Format("%1$s%2$s", strLogName, strExInfo), ex);
         if (this.getPSSystemUtil() != null) {
            this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
         }

         this.throwInitException(ex);
      }
   }

   @Override
   protected void onInit() throws Exception {
      this.onPreparePSSubSysServiceAPIDEFields();
      super.onInit();
   }

   @Override
   protected int onCheck() throws Exception {
      this.getPSSubSysSADERSPathCount();
      int nCount = 0;
      Iterator<? extends IPSSubSysServiceAPIDEMethod> psSubSysServiceAPIDEMethods = this.getPSSubSysServiceAPIDEMethods();
      if (psSubSysServiceAPIDEMethods != null) {
         while (psSubSysServiceAPIDEMethods.hasNext()) {
            IPSSubSysServiceAPIDEMethod iPSSubSysServiceAPIDEMethod = psSubSysServiceAPIDEMethods.next();
            nCount += iPSSubSysServiceAPIDEMethod.check();
         }
      }

      return nCount + super.onCheck();
   }

   protected void onPreparePSSubSysServiceAPIDEFields() throws Exception {
      this.psSubSysServiceAPIDEFieldList.clear();
      this.psSubSysServiceAPIDEFieldMap.clear();
      Vector<PSSubSysSADEField> psSubSysSADEFieldList = new Vector<>();
      if (!this.isAutoModel()) {
         CallResult callResult = this.getPSModelHelper().getPSSubSysSADEFields(this.getId(), psSubSysSADEFieldList);
         if (callResult.isError()) {
            throw new Exception(StringHelper.Format("查询外部接口实体属性发生错误，%1$s", callResult.getErrorInfo()));
         }
      }

      if (psSubSysSADEFieldList.size() == 0) {
         IPSDataEntity iPSDataEntity = null;
         if (this.isAutoModel()) {
            iPSDataEntity = this.getPSSubSysServiceAPI().getPSSystem().getPSDataEntity2(this.getId());
         } else if (StringHelper.Compare(this.getPSSystemUtil().getTemplEngineVer(), "V2", true) == 0) {
            Iterator<IPSDataEntity> psDataEntities = this.getPSSubSysServiceAPI().getPSSystem().getAllPSDataEntities();

            while (psDataEntities.hasNext()) {
               IPSDataEntity iPSDataEntity2 = psDataEntities.next();
               if (StringHelper.Compare(iPSDataEntity2.getPSSubSysSADEId(), this.getId(), false) == 0) {
                  iPSDataEntity = iPSDataEntity2;
                  break;
               }
            }

            if (iPSDataEntity == null) {
               iPSDataEntity = this.getPSSubSysServiceAPI().getPSSystem().getPSDataEntity2(this.getName(), true);
            }
         }

         if (iPSDataEntity != null) {
            Iterator<IPSDEField> psDEFields = iPSDataEntity.getAllPSDEFields();
            if (psDEFields != null) {
               while (psDEFields.hasNext()) {
                  IPSDEField iPSDEField = psDEFields.next();
                  PSSubSysSADEField psSubSysSADEField = new PSSubSysSADEField();
                  psSubSysSADEField.setPSSUBSYSSADEFIELDID(iPSDEField.getId());
                  psSubSysSADEField.setPSSUBSYSSADEFIELDNAME(iPSDEField.getName());
                  psSubSysSADEField.setALLOWEMPTY(iPSDEField.isAllowEmpty());
                  psSubSysSADEField.setCODENAME(iPSDEField.getServiceCodeName());
                  psSubSysSADEField.setSTDDATATYPE(iPSDEField.getStdDataType());
                  psSubSysSADEField.setLENGTH(iPSDEField.getLength());
                  psSubSysSADEField.setPRECISION2(iPSDEField.getPrecision());
                  if (iPSDEField.getPSCodeList() != null) {
                     psSubSysSADEField.setPSCODELISTID(iPSDEField.getPSCodeList().getId());
                  }

                  psSubSysSADEField.setLOGICNAME(iPSDEField.getLogicName());
                  psSubSysSADEField.setMAJORFIELD(iPSDEField.isMajorDEField());
                  psSubSysSADEField.setPKEY(iPSDEField.isKeyDEField() ? 1 : 0);
                  psSubSysSADEField.setORDERVALUE(iPSDEField.getOrderValue());
                  psSubSysSADEField.setVALIDFLAG(true);
                  psSubSysSADEField.setPSSUBSYSSADEID(this.getId());
                  psSubSysSADEField.setPSSUBSYSSADENAME(this.getName());
                  psSubSysSADEField.set("AUTOMODEL", 1);
                  PSSubSysServiceAPIDEFieldImpl psSubSysServiceAPIDEFieldImpl = new PSSubSysServiceAPIDEFieldImpl();
                  psSubSysServiceAPIDEFieldImpl.init(this.getDAGlobalHelper(), this, psSubSysSADEField);
                  this.psSubSysServiceAPIDEFieldList.add(psSubSysServiceAPIDEFieldImpl);
                  if (iPSDEField instanceof IPSDEFieldRuntime) {
                     ((IPSDEFieldRuntime)iPSDEField).setPSSubSysServiceAPIDEField(psSubSysServiceAPIDEFieldImpl);
                  }
               }
            }
         }
      } else {
         for (PSSubSysSADEField psSubSysSADEField : psSubSysSADEFieldList) {
            PSSubSysServiceAPIDEFieldImpl psSubSysServiceAPIDEFieldImpl = new PSSubSysServiceAPIDEFieldImpl();
            psSubSysServiceAPIDEFieldImpl.init(this.getDAGlobalHelper(), this, psSubSysSADEField);
            this.psSubSysServiceAPIDEFieldList.add(psSubSysServiceAPIDEFieldImpl);
         }
      }

      for (IPSSubSysServiceAPIDEField iPSSubSysServiceAPIDEField : this.psSubSysServiceAPIDEFieldList) {
         this.psSubSysServiceAPIDEFieldMap.put(iPSSubSysServiceAPIDEField.getId(), iPSSubSysServiceAPIDEField);
         this.psSubSysServiceAPIDEFieldMap.put(iPSSubSysServiceAPIDEField.getName(), iPSSubSysServiceAPIDEField);
         if (iPSSubSysServiceAPIDEField.isKeyDEField()) {
            this.keyPSSubSysServiceAPIDEField = iPSSubSysServiceAPIDEField;
         }

         if (iPSSubSysServiceAPIDEField.isMajorDEField()) {
            this.majorPSSubSysServiceAPIDEField = iPSSubSysServiceAPIDEField;
         }
      }
   }

   protected void setPSSubSysServiceAPI(IPSSubSysServiceAPI iPSSubSysServiceAPI) {
      this.iPSSubSysServiceAPI = iPSSubSysServiceAPI;
   }

   @PSModelRTMeta(description = "子系统服务接口")
   @Override
   public IPSSubSysServiceAPI getPSSubSysServiceAPI() {
      return this.iPSSubSysServiceAPI;
   }

   @Override
   public String getModelType() {
      return "PSSUBSYSSADE";
   }

   @Override
   public String getFullModelName() {
      return StringHelper.Format("%1$s|%2$s", this.getPSSubSysServiceAPI().getFullModelName(), this.getModelName());
   }

   @Override
   public String getModelId() {
      return StringHelper.Format("%1$s#%2$s", this.getPSSubSysServiceAPI().getModelId(), super.getModelId());
   }

   @PSModelRTMeta(description = "主接口", ignoredumpvalues = "false", doc = "等同{@link #getAPIMode}返回主接口(1)")
   @Override
   public boolean isMajor() {
      return this.nAPIMode == 1;
   }

   protected IPSSystemUtil getPSSystemUtil() {
      return (IPSSystemUtil)this.getPSSubSysServiceAPI().getPSSystem();
   }

   @PSModelRTMeta(description = "代码标识")
   @Override
   public String getCodeName() {
      return this.strCodeName;
   }

   @PSModelRTMeta(description = "代码名称2（复数）", hideempty2 = true)
   @Override
   public String getCodeName2() {
      return this.psSubSysSADE.getCODENAME2();
   }

   @PSModelRTMeta(description = "逻辑名称")
   @Override
   public String getLogicName() {
      return this.psSubSysSADE.getLOGICNAME();
   }

   @Override
   public String getPSSysModelInstId() {
      return this.getPSSubSysServiceAPI().getPSSysModelInstId();
   }

   @Override
   public Iterator<IPSSubSysServiceAPIDERS> getPSSubSysServiceAPIDERSs(boolean bMajor) {
      try {
         Iterator<IPSSubSysServiceAPIDERS> psSubSysSADERSs = this.getPSSubSysServiceAPI().getAllPSSubSysServiceAPIDERSs();
         if (psSubSysSADERSs == null) {
            return null;
         }

         if (bMajor) {
            if (this.majorPSSubSysServiceAPIDERSList == null) {
               ArrayList<IPSSubSysServiceAPIDERS> list = new ArrayList<>();

               while (psSubSysSADERSs.hasNext()) {
                  IPSSubSysServiceAPIDERS iPSSubSysServiceAPIDERS = psSubSysSADERSs.next();
                  if (StringHelper.Compare(iPSSubSysServiceAPIDERS.getPPSSubSysSADEId(), this.getId(), true) == 0) {
                     list.add(iPSSubSysServiceAPIDERS);
                  }
               }

               if (this.majorPSSubSysServiceAPIDERSList == null) {
                  this.majorPSSubSysServiceAPIDERSList = list;
               }
            }

            return this.majorPSSubSysServiceAPIDERSList.iterator();
         } else {
            if (this.minorPSSubSysServiceAPIDERSList == null) {
               ArrayList<IPSSubSysServiceAPIDERS> list = new ArrayList<>();

               while (psSubSysSADERSs.hasNext()) {
                  IPSSubSysServiceAPIDERS iPSSubSysServiceAPIDERS = psSubSysSADERSs.next();
                  if (StringHelper.Compare(iPSSubSysServiceAPIDERS.getCPSSubSysSADEId(), this.getId(), true) == 0) {
                     list.add(iPSSubSysServiceAPIDERS);
                  }
               }

               if (this.minorPSSubSysServiceAPIDERSList == null) {
                  this.minorPSSubSysServiceAPIDERSList = list;
               }
            }

            return this.minorPSSubSysServiceAPIDERSList.iterator();
         }
      } catch (Exception ex) {
         log.error(ex);
         return null;
      }
   }

   @PSModelRTMeta(description = "接口关系集合")
   @Override
   public Iterator<IPSSubSysServiceAPIDERS> getPSSubSysServiceAPIDERSs() {
      return this.getPSSubSysServiceAPIDERSs(true);
   }

   @PSModelRTMeta(description = "接口属性集合", child = true)
   @Override
   public Iterator<IPSSubSysServiceAPIDEField> getPSSubSysServiceAPIDEFields() {
      return this.psSubSysServiceAPIDEFieldList.iterator();
   }

   @Override
   public IPSSubSysServiceAPIDEField getPSSubSysServiceAPIDEField(String strPSDEFieldId) throws Exception {
      return this.getPSSubSysServiceAPIDEField(strPSDEFieldId, false);
   }

   @Override
   public IPSSubSysServiceAPIDEField getPSSubSysServiceAPIDEField(String strPSDEFieldId, boolean bTryMode) throws Exception {
      IPSSubSysServiceAPIDEField iPSSubSysServiceAPIDEField = this.psSubSysServiceAPIDEFieldMap.get(strPSDEFieldId);
      if (iPSSubSysServiceAPIDEField == null && !bTryMode) {
         throw new Exception(StringHelper.Format("无法获取指定外部接口属性[%1$s]", strPSDEFieldId));
      } else {
         return iPSSubSysServiceAPIDEField;
      }
   }

   @PSModelRTMeta(description = "接口关系路径数量", dump = false)
   @Override
   public int getPSSubSysSADERSPathCount() throws Exception {
      this.preparePSSubSysSADERSPaths();
      return this.psSubSysSADERSPathMap == null ? 0 : this.psSubSysSADERSPathMap.size();
   }

   @Override
   public Iterator<? extends IPSSubSysServiceAPIDERS> getPSSubSysSADERSPath(int nPathIndex) throws Exception {
      this.preparePSSubSysSADERSPaths();
      if (this.psSubSysSADERSPathMap == null) {
         return null;
      }

      ArrayList<IPSSubSysServiceAPIDERS> list = this.psSubSysSADERSPathMap.get(nPathIndex);
      return list == null ? null : list.iterator();
   }

   protected synchronized void preparePSSubSysSADERSPaths() throws Exception {
      synchronized (this) {
         if (this.psSubSysSADERSPathMap == null) {
            this.psSubSysSADERSPathMap = new LinkedHashMap<>();
            if (!this.isNested()) {
               Iterator<? extends IPSSubSysServiceAPIDERS> psSubSysSADERSs = this.getPSSubSysServiceAPIDERSs(false);
               if (psSubSysSADERSs != null) {
                  while (psSubSysSADERSs.hasNext()) {
                     IPSSubSysServiceAPIDERS iPSSubSysSADERS = psSubSysSADERSs.next();
                     if (StringHelper.Compare(iPSSubSysSADERS.getPPSSubSysSADEId(), iPSSubSysSADERS.getCPSSubSysSADEId(), false) != 0) {
                        ArrayList<IPSSubSysServiceAPIDERS> list = new ArrayList<>();
                        int nIndex = this.psSubSysSADERSPathMap.size();
                        this.psSubSysSADERSPathMap.put(nIndex, list);
                        this.fillPSSubSysSADERSPath(iPSSubSysSADERS, list);
                     }
                  }

                  if (this.psSubSysSADERSPathMap.size() > 1) {
                     ArrayList<ArrayList<IPSSubSysServiceAPIDERS>> list = new ArrayList<>();
                     list.addAll(this.psSubSysSADERSPathMap.values());
                     Collections.sort(list, new Comparator<ArrayList<IPSSubSysServiceAPIDERS>>() {
                        public int compare(ArrayList<IPSSubSysServiceAPIDERS> arg0, ArrayList<IPSSubSysServiceAPIDERS> arg1) {
                           if (arg0.size() != arg1.size()) {
                              return Integer.valueOf(arg0.size()).compareTo(arg1.size());
                           }

                           for (int i = 0; i < arg0.size(); i++) {
                              int nRet = arg0.get(i).getName().compareTo(arg1.get(i).getName());
                              if (nRet != 0) {
                                 return nRet;
                              }
                           }

                           return 0;
                        }
                     });
                     this.psSubSysSADERSPathMap.clear();

                     for (int i = 0; i < list.size(); i++) {
                        this.psSubSysSADERSPathMap.put(i, list.get(i));
                     }
                  }
               }
            }
         }
      }
   }

   protected synchronized void fillPSSubSysSADERSPath(IPSSubSysServiceAPIDERS iPSSubSysSADERS, ArrayList<IPSSubSysServiceAPIDERS> list) throws Exception {
      for (IPSSubSysServiceAPIDERS tempPSSubSysSADERS : list) {
         if (StringHelper.Compare(iPSSubSysSADERS.getId(), tempPSSubSysSADERS.getId(), false) == 0) {
            throw new Exception(StringHelper.Format("子系统服务接口实体[%1$s]存在递归引用关系[%2$s]", this.getName(), iPSSubSysSADERS.getName()));
         }
      }

      list.add(0, iPSSubSysSADERS);
      Iterator<? extends IPSSubSysServiceAPIDERS> majorList = iPSSubSysSADERS.getMajorPSSubSysServiceAPIDE().getPSSubSysServiceAPIDERSs(false);
      if (majorList != null) {
         ArrayList<IPSSubSysServiceAPIDERS> srcList = new ArrayList<>();
         srcList.addAll(list);
         int nIndex = 0;

         while (majorList.hasNext()) {
            IPSSubSysServiceAPIDERS tempPSSubSysSADERS = majorList.next();
            if (StringHelper.Compare(tempPSSubSysSADERS.getPPSSubSysSADEId(), tempPSSubSysSADERS.getCPSSubSysSADEId(), false) != 0) {
               if (nIndex == 0) {
                  if (iPSSubSysSADERS.getMajorPSSubSysServiceAPIDE().isMajor()) {
                     ArrayList<IPSSubSysServiceAPIDERS> list2 = new ArrayList<>();
                     list2.addAll(srcList);
                     int nIndex2 = this.psSubSysSADERSPathMap.size();
                     this.psSubSysSADERSPathMap.put(nIndex2, list2);
                  }

                  this.fillPSSubSysSADERSPath(tempPSSubSysSADERS, list);
               } else {
                  ArrayList<IPSSubSysServiceAPIDERS> list2 = new ArrayList<>();
                  list2.addAll(srcList);
                  int nIndex2 = this.psSubSysSADERSPathMap.size();
                  this.psSubSysSADERSPathMap.put(nIndex2, list2);
                  this.fillPSSubSysSADERSPath(tempPSSubSysSADERS, list2);
               }

               nIndex++;
            }
         }
      }
   }

   @Override
   public IPSSubSysServiceAPIDERS getPSSubSysSADERSPathFirst(int nPathIndex) throws Exception {
      this.preparePSSubSysSADERSPaths();
      if (this.psSubSysSADERSPathMap == null) {
         return null;
      }

      ArrayList<IPSSubSysServiceAPIDERS> list = this.psSubSysSADERSPathMap.get(nPathIndex);
      return list != null && list.size() != 0 ? list.get(0) : null;
   }

   @Override
   public IPSSubSysServiceAPIDERS getPSSubSysSADERSPathLast(int nPathIndex) throws Exception {
      this.preparePSSubSysSADERSPaths();
      if (this.psSubSysSADERSPathMap == null) {
         return null;
      }

      ArrayList<IPSSubSysServiceAPIDERS> list = this.psSubSysSADERSPathMap.get(nPathIndex);
      return list != null && list.size() != 0 ? list.get(list.size() - 1) : null;
   }

   @PSModelRTMeta(description = "接口关系路径[0]", hideempty = true, dump = false, outputdoc = "false")
   @Override
   public Iterator<? extends IPSSubSysServiceAPIDERS> getPSSubSysSADERSPath0() throws Exception {
      return this.getPSSubSysSADERSPath(0);
   }

   @PSModelRTMeta(description = "接口关系路径[1]", hideempty = true, dump = false, outputdoc = "false")
   @Override
   public Iterator<? extends IPSSubSysServiceAPIDERS> getPSSubSysSADERSPath1() throws Exception {
      return this.getPSSubSysSADERSPath(1);
   }

   @PSModelRTMeta(description = "接口关系路径[2]", hideempty = true, dump = false, outputdoc = "false")
   @Override
   public Iterator<? extends IPSSubSysServiceAPIDERS> getPSSubSysSADERSPath2() throws Exception {
      return this.getPSSubSysSADERSPath(2);
   }

   @PSModelRTMeta(description = "接口关系路径[3]", hideempty = true, dump = false, outputdoc = "false")
   @Override
   public Iterator<? extends IPSSubSysServiceAPIDERS> getPSSubSysSADERSPath3() throws Exception {
      return this.getPSSubSysSADERSPath(3);
   }

   @PSModelRTMeta(description = "接口关系路径[4]", hideempty = true, dump = false, outputdoc = "false")
   @Override
   public Iterator<? extends IPSSubSysServiceAPIDERS> getPSSubSysSADERSPath4() throws Exception {
      return this.getPSSubSysSADERSPath(4);
   }

   @PSModelRTMeta(description = "外部接口实体方法集合", child = true)
   @Override
   public Iterator<? extends IPSSubSysServiceAPIDEMethod> getPSSubSysServiceAPIDEMethods() throws Exception {
      if (this.psSubSysServiceAPIDEMethodList != null) {
         return this.psSubSysServiceAPIDEMethodList.iterator();
      }

      List<IPSSubSysServiceAPIDEMethod> list = new ArrayList<>();
      Iterator<IPSSubSysServiceAPIMethod> psSubSysServiceAPIMethods = this.getPSSubSysServiceAPI().getAllPSSubSysServiceAPIMethods();
      if (psSubSysServiceAPIMethods != null) {
         while (psSubSysServiceAPIMethods.hasNext()) {
            IPSSubSysServiceAPIMethod iPSSubSysServiceAPIMethod = psSubSysServiceAPIMethods.next();
            if (iPSSubSysServiceAPIMethod instanceof IPSSubSysServiceAPIDEMethod) {
               IPSSubSysServiceAPIDEMethod iPSSubSysServiceAPIDEMethod = (IPSSubSysServiceAPIDEMethod)iPSSubSysServiceAPIMethod;
               if (iPSSubSysServiceAPIDEMethod.getPSSubSysServiceAPIDE() != null
                  && StringHelper.Compare(iPSSubSysServiceAPIDEMethod.getPSSubSysServiceAPIDE().getId(), this.getId(), false) == 0) {
                  list.add(iPSSubSysServiceAPIDEMethod);
               }
            }
         }
      }

      if (this.psSubSysServiceAPIDEMethodList == null) {
         this.psSubSysServiceAPIDEMethodList = list;
      }

      return this.psSubSysServiceAPIDEMethodList.iterator();
   }

   @Override
   public IPSSubSysServiceAPIDEMethod getPSSubSysServiceAPIDEMethod(String strPSSubSysServiceAPIDEMethodId, boolean bTryMode) throws Exception {
      IPSSubSysServiceAPIDEMethod iPSSubSysServiceAPIDEMethod = null;
      Iterator<? extends IPSSubSysServiceAPIDEMethod> methods = this.getPSSubSysServiceAPIDEMethods();
      if (methods != null) {
         while (methods.hasNext()) {
            IPSSubSysServiceAPIDEMethod srcPSSubSysServiceAPIDEMethod = methods.next();
            if (StringHelper.Compare(srcPSSubSysServiceAPIDEMethod.getId(), strPSSubSysServiceAPIDEMethodId, false) == 0) {
               iPSSubSysServiceAPIDEMethod = srcPSSubSysServiceAPIDEMethod;
               break;
            }
         }
      }

      if (iPSSubSysServiceAPIDEMethod == null && !bTryMode) {
         throw new Exception(StringHelper.Format("无法获取指定子系统实体方法[%1$s]", strPSSubSysServiceAPIDEMethodId));
      } else {
         return iPSSubSysServiceAPIDEMethod;
      }
   }

   @PSModelRTMeta(description = "接口模式", codelist = "DESAMode", fields = "MAJORFLAG")
   @Override
   public int getAPIMode() {
      return this.nAPIMode;
   }

   @PSModelRTMeta(description = "嵌套成员", ignoredumpvalues = "false", doc = "等同{@link #getAPIMode}返回数据传输对象（DTO）嵌套成员(9)")
   @Override
   public boolean isNested() {
      return this.nAPIMode == 9;
   }

   @PSModelRTMeta(description = "实体标记", hideempty2 = true, fields = "DETAG")
   @Override
   public String getDETag() {
      return this.psSubSysSADE.getDETAG();
   }

   @PSModelRTMeta(description = "实体标记2", hideempty2 = true, fields = "DETAG2")
   @Override
   public String getDETag2() {
      return this.psSubSysSADE.getDETAG2();
   }

   @Override
   public IPSSubSysServiceAPIDEField getKeyPSSubSysServiceAPIDEField() {
      return this.keyPSSubSysServiceAPIDEField;
   }

   @Override
   public IPSSubSysServiceAPIDEField getMajorPSSubSysServiceAPIDEField() {
      return this.majorPSSubSysServiceAPIDEField;
   }

   @PSModelRTMeta(description = "主键属性")
   @Override
   public IPSSubSysServiceAPIDEField getKeyDEField() {
      return this.getKeyPSSubSysServiceAPIDEField();
   }

   @PSModelRTMeta(description = "主信息属性")
   @Override
   public IPSSubSysServiceAPIDEField getMajorDEField() {
      return this.getMajorPSSubSysServiceAPIDEField();
   }

   @PSModelRTMeta(description = "后端扩展插件", hideempty = true)
   @Override
   public IPSSysSFPlugin getPSSysSFPlugin() {
      return this.iPSSysSFPlugin;
   }

   @PSModelRTMeta(description = "绘制器", hideempty = true)
   @Override
   public IPSSFXCodeObject getRender() {
      return this.iPSSFXCodeObject;
   }

   @Override
   protected String onGetDynaModelFolder() {
      return null;
   }

   @Override
   protected IPSModelObject onGetParentModel() {
      return this.getPSSubSysServiceAPI();
   }

   @Override
   protected IPSModelObject onGetScopeModel() {
      return this.getPSSubSysServiceAPI();
   }

   @Override
   public int getOrderValue() {
      return !this.psSubSysSADE.isORDERVALUENull() && this.psSubSysSADE.getORDERVALUE() >= 0 ? this.psSubSysSADE.getORDERVALUE() : 99999;
   }

   @PSModelRTMeta(description = "方法调用脚本代码", hideempty2 = true, fields = "METHODCODE")
   @Override
   public String getMethodScriptCode() {
      return this.psSubSysSADE.getMETHODCODE();
   }

   @PSModelRTMeta(description = "服务参数", fields = "SERVICEPARAM")
   @Override
   public String getServiceParam() {
      return this.strServiceParam;
   }

   @PSModelRTMeta(description = "服务参数2", fields = "SERVICEPARAM2")
   @Override
   public String getServiceParam2() {
      return this.strServiceParam2;
   }

   public Properties getServiceParams() {
      return this.serviceParams;
   }
}
