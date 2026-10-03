package SA.SRFDA.PS.Core.DEField.ValueRule;

import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DEField.IPSDEFGroupDetail;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.PSDEFieldObjectImpl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.Pub.IPSXCodeObject;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.ValueRule.IPSSysValueRule;
import SA.SRFDA.PS.Data.PSDEFDLogic;
import SA.SRFDA.PS.Data.PSDEFValueRule;
import SA.SRFDA.PS.Data.PSDEFValueRuleCond;
import SA.SRFDA.PS.Data.PSDEForm;
import SA.SRFDA.PS.Data.PSDEFormDetail;
import SA.SRFDA.PS.Data.PSDEFormRF;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.DataEx.Conditions;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;
import net.ibizsys.paas.util.KeyValueHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFValueRuleImpl extends PSDEFieldObjectImpl implements IPSDEFValueRule {
   private static final Log log = LogFactory.getLog(PSDEFValueRuleImpl.class);
   protected PSDEFValueRule psDEFValueRule = null;
   protected IPSDEFVRGroupCondition iPSDEFVRGroupCondition = null;
   private String strCodeName = "";
   private boolean bDefaultMode = true;
   private String strRuleInfo = "";
   private boolean bCheckDefault = false;
   private int nRuleHolder = 3;
   private boolean bCustomRuleHolder = false;
   private IPSSysPFPlugin iPSSysPFPlugin = null;
   private IPSSysSFPlugin iPSSysSFPlugin = null;
   private IPSXCodeObject iPSXCodeObject = null;
   private boolean bCustomCode = false;
   protected Vector<PSDEFormRF> psDEFormRFList = new Vector<>();
   private Map<String, PSDEFormDetail> formPartDetailMap = new LinkedHashMap<>();
   private ArrayList<IPSDEFVRCondition> allPSDEFVRConditionList = new ArrayList<>();
   private IPSLanguageRes ruleInfoPSLanguageRes = null;

   @Override
   public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEField iPSDEField, PSDEFValueRule psDEFValueRule) throws Exception {
      try {
         this.setDAGlobalHelper(iDAGlobalHelper);
         this.setPSDEField(iPSDEField);
         this.psDEFValueRule = psDEFValueRule;
         this.setId(this.psDEFValueRule.getPSDEFVALUERULEID());
         this.setName(this.psDEFValueRule.getPSDEFVALUERULENAME());
         this.setPSObjectData(this.psDEFValueRule);
         this.strCodeName = this.psDEFValueRule.getCODENAME();
         this.strRuleInfo = this.psDEFValueRule.getRULEINFO();
         this.bDefaultMode = this.psDEFValueRule.getDEFAULTMODE();
         if (this.bDefaultMode) {
            this.bCheckDefault = true;
         } else {
            this.bCheckDefault = this.psDEFValueRule.getCHECKDEFAULT();
            if (!StringHelper.IsNullOrEmpty(this.psDEFValueRule.getVRTYPE())) {
               this.bCustomCode = StringHelper.Compare(this.psDEFValueRule.getVRTYPE(), "SCRIPT", true) == 0;
            }
         }

         if (!this.psDEFValueRule.isRULEHOLDERNull()) {
            this.nRuleHolder = this.psDEFValueRule.getRULEHOLDER();
            this.bCustomRuleHolder = true;
         }

         this.onInit();
      } catch (Exception ex) {
         String strLogName = net.ibizsys.paas.util.StringHelper.format("%1$s[%2$s]", PSModels.getModelName(this.getModelType()), this.getFullModelName());
         String strExInfo = net.ibizsys.paas.util.StringHelper.format("初始化发生异常，%1$s", ex.getMessage());
         log.error(net.ibizsys.paas.util.StringHelper.format("%1$s%2$s", strLogName, strExInfo), ex);
         if (this.getPSSystemUtil() != null) {
            this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
         }

         this.throwInitException(ex);
      }
   }

   @Override
   protected void onInit() throws Exception {
      if (!StringHelper.IsNullOrEmpty(this.psDEFValueRule.getPSSYSPFPLUGINID())) {
         this.iPSSysPFPlugin = this.getPSDataEntity().getPSSystem().getPSSysPFPlugin(this.psDEFValueRule.getPSSYSPFPLUGINID());
      }

      if (!StringHelper.IsNullOrEmpty(this.psDEFValueRule.getPSSYSSFPLUGINID())) {
         this.iPSSysSFPlugin = this.getPSDataEntity().getPSSystem().getPSSysSFPlugin(this.psDEFValueRule.getPSSYSSFPLUGINID());
      }

      if (this.getPSSysSFPlugin() != null) {
         String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId(this.getPSSysSFPlugin().getId(), this.getPSDataEntity().getPSSystem().getPSSFId());
         IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSDataEntity().getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
         if (iPSSysSFPluginTempl != null) {
            this.iPSXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
         }
      }

      if (!StringHelper.IsNullOrEmpty(this.psDEFValueRule.getRIPSLANRESID())) {
         this.ruleInfoPSLanguageRes = this.getPSDataEntity().getPSSystem().getPSLanguageRes(this.psDEFValueRule.getRIPSLANRESID());
      }

      super.onInit();
      if (!this.isCustomCode()) {
         this.onPreparePSDEFVRConds();
      }

      if (StringHelper.Compare(this.strRuleInfo, "默认规则", true) == 0) {
         this.strRuleInfo = "";
      }

      if (StringHelper.IsNullOrEmpty(this.strRuleInfo) && this.iPSDEFVRGroupCondition != null) {
         this.strRuleInfo = this.iPSDEFVRGroupCondition.getRuleInfo();
      }

      if (StringHelper.IsNullOrEmpty(this.strRuleInfo)) {
         this.strRuleInfo = this.getName();
      }
   }

   protected void onPreparePSDEFVRConds() throws Exception {
      this.iPSDEFVRGroupCondition = null;
      this.allPSDEFVRConditionList.clear();
      Vector<PSDEFValueRuleCond> psDEFValueRuleCondList = new Vector<>();
      if (StringHelper.Compare("FORMITEMS", this.psDEFValueRule.getVRTYPE(), true) == 0) {
         if (StringHelper.IsNullOrEmpty(this.psDEFValueRule.getPSDEFORMID())) {
            throw new Exception("值规则类型为表单项，但未指定编辑表单");
         }

         this.onPreparePSDEFormDetails(psDEFValueRuleCondList);
      } else {
         CallResult callResult = this.getPSModelHelper().getPSDEFValueRuleConds(this.getId(), psDEFValueRuleCondList);
         if (callResult.isError()) {
            throw new Exception(StringHelper.Format("查询值规则条件集合发生错误, %1$s", callResult.getErrorInfo()));
         }
      }

      Map<String, PSDEFValueRuleCond> psDEFValueRuleCondMap = new LinkedHashMap<>();

      for (PSDEFValueRuleCond psDEFValueRuleCond : psDEFValueRuleCondList) {
         psDEFValueRuleCondMap.put(psDEFValueRuleCond.getPSDEFVRCONDID(), psDEFValueRuleCond);
      }

      for (PSDEFValueRuleCond psDEFValueRuleCond : psDEFValueRuleCondList) {
         if (!StringHelper.IsNullOrEmpty(psDEFValueRuleCond.getPPSDEFVRCONDID())) {
            PSDEFValueRuleCond parentPSDEFValueRuleCond = psDEFValueRuleCondMap.get(psDEFValueRuleCond.getPPSDEFVRCONDID());
            parentPSDEFValueRuleCond.getChildPSDEFValueRuleConds(true).add(psDEFValueRuleCond);
         }
      }

      PSDEFValueRuleCond psDEFValueRuleCondGroup = new PSDEFValueRuleCond();
      psDEFValueRuleCondGroup.setCONDTYPE("GROUP");
      psDEFValueRuleCondGroup.setGROUPOP("AND");
      psDEFValueRuleCondGroup.setPSDEFVRCONDID(this.getId());
      psDEFValueRuleCondGroup.setPSDEFVRCONDNAME("默认组");

      for (PSDEFValueRuleCond psDEFValueRuleCond : psDEFValueRuleCondList) {
         if (StringHelper.IsNullOrEmpty(psDEFValueRuleCond.getPPSDEFVRCONDID())) {
            psDEFValueRuleCondGroup.getChildPSDEFValueRuleConds(true).add(psDEFValueRuleCond);
         }
      }

      if (StringHelper.Compare(this.getCodeName(), "DEFAULT", true) == 0) {
         if (this.getPSDEField().getStringLength() > 0) {
            PSDEFValueRuleCond psDEFValueRuleCond = new PSDEFValueRuleCond();
            psDEFValueRuleCond.setPSDEFVRCONDID(this.getId() + "_" + "STRINGLENGTH");
            psDEFValueRuleCond.setPSDEFVRCONDNAME("默认字符串长度");
            psDEFValueRuleCond.setCONDTYPE("STRINGLENGTH");
            psDEFValueRuleCond.setPARAM4(this.getPSDEField().getStringLength());
            psDEFValueRuleCond.setPARAM6(true);
            if (this.getPSDEField().getMinStringLength() > 0) {
               psDEFValueRuleCond.setPARAM3(this.getPSDEField().getMinStringLength());
               psDEFValueRuleCond.setPARAM5(true);
            }

            psDEFValueRuleCond.setKEYCONDFLAG(true);
            psDEFValueRuleCondGroup.getChildPSDEFValueRuleConds(true).add(psDEFValueRuleCond);
         }

         if (!StringHelper.IsNullOrEmpty(this.getPSDEField().getMinValueString()) || !StringHelper.IsNullOrEmpty(this.getPSDEField().getMaxValueString())) {
            PSDEFValueRuleCond psDEFValueRuleCond = new PSDEFValueRuleCond();
            psDEFValueRuleCond.setPSDEFVRCONDID(this.getId() + "_" + "VALUERANGE2");
            psDEFValueRuleCond.setPSDEFVRCONDNAME("默认值范围");
            psDEFValueRuleCond.setCONDTYPE("VALUERANGE2");
            if (!StringHelper.IsNullOrEmpty(this.getPSDEField().getMinValueString())) {
               psDEFValueRuleCond.setPARAM7(this.getPSDEField().getMinValueString());
               psDEFValueRuleCond.setPARAM5(true);
            }

            if (!StringHelper.IsNullOrEmpty(this.getPSDEField().getMaxValueString())) {
               psDEFValueRuleCond.setPARAM8(this.getPSDEField().getMaxValueString());
               psDEFValueRuleCond.setPARAM6(true);
            }

            psDEFValueRuleCond.setKEYCONDFLAG(true);
            psDEFValueRuleCondGroup.getChildPSDEFValueRuleConds(true).add(psDEFValueRuleCond);
         }

         if (!StringHelper.IsNullOrEmpty(this.getPSDEField().getPSSysValueRuleId())) {
            IPSSysValueRule iPSSysVaueRule = this.getPSDataEntity().getPSSystem().getPSSysValueRule(this.getPSDEField().getPSSysValueRuleId());
            if (StringHelper.Compare(iPSSysVaueRule.getRuleType(), "REG", true) == 0) {
               PSDEFValueRuleCond psDEFValueRuleCond = new PSDEFValueRuleCond();
               psDEFValueRuleCond.setPSDEFVRCONDID(this.getId() + "_" + "REGEX");
               psDEFValueRuleCond.setPSDEFVRCONDNAME(iPSSysVaueRule.getName());
               psDEFValueRuleCond.setCONDTYPE("REGEX");
               psDEFValueRuleCond.setCONDVALUE(iPSSysVaueRule.getRegExCode());
               psDEFValueRuleCond.setRULEINFO(iPSSysVaueRule.getRuleInfo());
               psDEFValueRuleCond.setKEYCONDFLAG(true);
               psDEFValueRuleCondGroup.getChildPSDEFValueRuleConds(true).add(psDEFValueRuleCond);
            } else {
               PSDEFValueRuleCond psDEFValueRuleCond = new PSDEFValueRuleCond();
               psDEFValueRuleCond.setPSDEFVRCONDID(this.getId() + "_" + "SYSVALUERULE");
               psDEFValueRuleCond.setPSDEFVRCONDNAME(iPSSysVaueRule.getName());
               psDEFValueRuleCond.setCONDTYPE("SYSVALUERULE");
               psDEFValueRuleCond.setPSSYSVALUERULEID(iPSSysVaueRule.getId());
               psDEFValueRuleCond.setRULEINFO(iPSSysVaueRule.getRuleInfo());
               psDEFValueRuleCond.setKEYCONDFLAG(true);
               psDEFValueRuleCondGroup.getChildPSDEFValueRuleConds(true).add(psDEFValueRuleCond);
            }
         }

         if (this.getPSDEField().isCheckRecursion()) {
            PSDEFValueRuleCond psDEFValueRuleCond = new PSDEFValueRuleCond();
            psDEFValueRuleCond.setPSDEFVRCONDID(this.getId() + "_" + "VALUERECURSION");
            psDEFValueRuleCond.setPSDEFVRCONDNAME("默认递归检查");
            psDEFValueRuleCond.setCONDTYPE("VALUERECURSION");
            psDEFValueRuleCond.setKEYCONDFLAG(true);
            IPSDataEntity inheritPSDataEntity = this.getPSDEField().getPSDataEntity().getInheritPSDataEntity();
            if (inheritPSDataEntity != null) {
               psDEFValueRuleCond.setMAJORPSDEID(inheritPSDataEntity.getId());
               psDEFValueRuleCond.setMAJORPSDENAME(inheritPSDataEntity.getName());
            }

            psDEFValueRuleCondGroup.getChildPSDEFValueRuleConds(true).add(psDEFValueRuleCond);
         }

         Iterator<IPSDEFGroup> psDEFGroups = this.getPSDataEntity().getAllPSDEFGroups();
         if (psDEFGroups != null) {
            while (psDEFGroups.hasNext()) {
               IPSDEFGroup iPSDEFGroup = psDEFGroups.next();
               PSDEFValueRuleCond psDEFValueRuleCond = this.calcPSDEFGroupCond(iPSDEFGroup);
               if (psDEFValueRuleCond != null) {
                  psDEFValueRuleCondGroup.getChildPSDEFValueRuleConds(true).add(psDEFValueRuleCond);
               }
            }
         }
      }

      PSDEFVRGroupConditionImpl psDEFVRGroupConditionImpl = new PSDEFVRGroupConditionImpl();
      psDEFVRGroupConditionImpl.init(this.getDAGlobalHelper(), this, null, psDEFValueRuleCondGroup);
      this.iPSDEFVRGroupCondition = psDEFVRGroupConditionImpl;
      this.fillAllPSDEFVRCondition(this.iPSDEFVRGroupCondition);
   }

   protected void onPreparePSDEFormDetails(Vector<PSDEFValueRuleCond> psDEFValueRuleCondList) throws Exception {
      this.formPartDetailMap.clear();

      for (PSDEFormRF psDEFormRF : this.psDEFormRFList) {
         this.onPreparePSDEFormDetails(null, psDEFormRF.getMINORPSDEFORMID(), false);
      }

      this.onPreparePSDEFormDetails(psDEFValueRuleCondList, this.getPSDEFormId(), true);
      this.formPartDetailMap.clear();
   }

   protected void onPreparePSDEFormDetails(Vector<PSDEFValueRuleCond> psDEFValueRuleCondList, String strPSDEFormId, boolean bMajor) throws Exception {
      Vector<PSDEFormDetail> psDEFormPageList = new Vector<>();
      CallResult callResult = this.getPSModelHelper().getPSDEFormDetails(strPSDEFormId, psDEFormPageList);
      if (callResult.isError()) {
         throw new Exception(StringHelper.Format("查询表单成员集合发生错误, %1$s", callResult.getErrorInfo()));
      }

      HashMap<String, PSDEFormDetail> psDEFormDetailMap = new HashMap<>();

      for (PSDEFormDetail psDEFormDetail : psDEFormPageList) {
         psDEFormDetailMap.put(psDEFormDetail.getPSDEFORMDETAILID(), psDEFormDetail);
         if (StringHelper.Compare(strPSDEFormId, this.getPSDEFormId(), true) != 0) {
            this.formPartDetailMap.put(psDEFormDetail.getPSDEFORMDETAILID(), psDEFormDetail);
         }
      }

      Iterator var22 = psDEFormPageList.iterator();

      while (true) {
         PSDEFormDetail psDEFormDetail2;
         PSDEFormDetail parentPSDEFormDetail;
         PSDEFormDetail psDEFormDetail;
         while (true) {
            if (!var22.hasNext()) {
               Vector<PSDEFDLogic> psDEFDLogicList = new Vector<>();
               callResult = this.getPSModelHelper().getPSDEFDLogics(strPSDEFormId, psDEFDLogicList);
               if (callResult.isError()) {
                  throw new Exception(StringHelper.Format("查询表单成员逻辑集合发生错误, %1$s", callResult.getErrorInfo()));
               }

               HashMap<String, PSDEFDLogic> psDEFDLogicMap = new HashMap<>();

               for (PSDEFDLogic psDEFDLogic : psDEFDLogicList) {
                  psDEFDLogicMap.put(psDEFDLogic.getPSDEFDLOGICID(), psDEFDLogic);
               }

               for (PSDEFDLogic psDEFDLogic : psDEFDLogicList) {
                  if (!StringHelper.IsNullOrEmpty(psDEFDLogic.getPPSDEFDLOGICID())) {
                     PSDEFDLogic parentPSDEFDLogic = psDEFDLogicMap.get(psDEFDLogic.getPPSDEFDLOGICID());
                     if (parentPSDEFDLogic != null) {
                        parentPSDEFDLogic.getChildPSDEFDLogics(true).add(psDEFDLogic);
                     }
                  }
               }

               for (PSDEFDLogic psDEFDLogic : psDEFDLogicList) {
                  if (StringHelper.IsNullOrEmpty(psDEFDLogic.getPPSDEFDLOGICID())) {
                     PSDEFormDetail psDEFormDetailx = psDEFormDetailMap.get(psDEFDLogic.getPSDEFORMDETAILID());
                     if (psDEFormDetailx != null) {
                        psDEFormDetailx.getChildPSDEFDLogics(psDEFDLogic.getLOGICCAT(), true).add(psDEFDLogic);
                     }
                  }
               }

               if (StringHelper.Compare(strPSDEFormId, this.getPSDEFormId(), true) == 0) {
                  for (PSDEFormDetail psDEFormDetailx : psDEFormPageList) {
                     if ((
                           StringHelper.Compare(psDEFormDetailx.getDETAILTYPE(), "FORMITEM", true) == 0
                              || StringHelper.Compare(psDEFormDetailx.getDETAILTYPE(), "FORMITEMEX", true) == 0
                        )
                        && !StringHelper.IsNullOrEmpty(psDEFormDetailx.getPSDEFID())) {
                        boolean bAllowEmpty = true;
                        if (!psDEFormDetailx.isALLOWEMPTYNull()) {
                           bAllowEmpty = psDEFormDetailx.getALLOWEMPTY();
                        }

                        if (bAllowEmpty) {
                           ArrayList<PSDEFDLogic> psDEFDLogicList2 = psDEFormDetailx.getChildPSDEFDLogics("ITEMBLANK", false);
                           if (psDEFDLogicList2 != null && psDEFDLogicList2.size() != 0) {
                              PSDEFValueRuleCond groupPSDEFValueRuleCond = new PSDEFValueRuleCond();
                              groupPSDEFValueRuleCond.setCONDTYPE("GROUP");
                              groupPSDEFValueRuleCond.setGROUPOP("OR");
                              PSDEFValueRuleCond psDEFValueRuleCond = new PSDEFValueRuleCond();
                              psDEFValueRuleCond.setPSDEFID(psDEFormDetailx.getPSDEFID());
                              psDEFValueRuleCond.setPSDEFNAME(psDEFormDetailx.getPSDEFNAME());
                              psDEFValueRuleCond.setCONDTYPE("SIMPLE");
                              psDEFValueRuleCond.setPSDBVALUEOPID("ISNOTNULL");
                              psDEFValueRuleCond.setPSDBVALUEOPNAME(Conditions.GetConditionLogicName("ISNOTNULL"));
                              groupPSDEFValueRuleCond.getChildPSDEFValueRuleConds(true).add(psDEFValueRuleCond);
                              psDEFValueRuleCond = new PSDEFValueRuleCond();
                              psDEFValueRuleCond.setCONDTYPE("GROUP");
                              psDEFValueRuleCond.setGROUPOP("AND");
                              psDEFValueRuleCondList.add(groupPSDEFValueRuleCond);
                           }
                        } else {
                           PSDEFValueRuleCond psDEFValueRuleCond = new PSDEFValueRuleCond();
                           psDEFValueRuleCond.setPSDEFID(psDEFormDetailx.getPSDEFID());
                           psDEFValueRuleCond.setPSDEFNAME(psDEFormDetailx.getPSDEFNAME());
                           psDEFValueRuleCond.setCONDTYPE("SIMPLE");
                           psDEFValueRuleCond.setPSDBVALUEOPID("ISNOTNULL");
                           psDEFValueRuleCond.setPSDBVALUEOPNAME(Conditions.GetConditionLogicName("ISNOTNULL"));
                           psDEFValueRuleCondList.add(psDEFValueRuleCond);
                        }
                     }
                  }

                  for (PSDEFormDetail psDEFormDetailx : psDEFormPageList) {
                     psDEFormDetailx.resetChildDatas();
                  }
               }

               return;
            }

            psDEFormDetail = (PSDEFormDetail)var22.next();
            if (!StringHelper.IsNullOrEmpty(psDEFormDetail.getPPSDEFORMDETAILID())) {
               psDEFormDetail2 = psDEFormDetail;
               parentPSDEFormDetail = psDEFormDetailMap.get(psDEFormDetail.getPPSDEFORMDETAILID());
               if (parentPSDEFormDetail == null) {
                  if (StringHelper.Compare(this.getId(), strPSDEFormId, false) == 0) {
                     throw new Exception(StringHelper.Format("表单[%1$s]成员[%2$s]父对象无效", this.getLogicName(), psDEFormDetail2.getPSDEFORMDETAILNAME()));
                  }

                  PSDEForm psDEForm = new PSDEForm();
                  this.getPSModelHelper().getPSDEForm(psDEFormDetail2.getPSDEFORMID(), psDEForm);
                  throw new Exception(StringHelper.Format("表单[%1$s]成员[%2$s]父对象无效", psDEForm.getPSDEFORMNAME(), psDEFormDetail2.getPSDEFORMDETAILNAME()));
               }

               if (!bMajor || StringHelper.Compare(psDEFormDetail.getDETAILTYPE(), "FORMPART", true) != 0) {
                  break;
               }

               String strFormPartType = psDEFormDetail.getCONTENTTYPE();
               if (StringHelper.IsNullOrEmpty(strFormPartType)) {
                  strFormPartType = "FORMRF";
               }

               if (StringHelper.Compare(strFormPartType, "FORMRF", false) != 0) {
                  break;
               }

               String strRefPSDEFormDetailId = psDEFormDetail.getREFPSDEFORMDETAILID();
               if (StringHelper.IsNullOrEmpty(strRefPSDEFormDetailId)) {
                  String strRefPSDEFormId = null;

                  for (PSDEFormRF psDEFormRF : this.psDEFormRFList) {
                     if (StringHelper.Compare(psDEFormDetail.getPSDEFORMRFID(), psDEFormRF.getPSDEFORMRFID(), false) == 0) {
                        strRefPSDEFormId = psDEFormRF.getMINORPSDEFORMID();
                     }
                  }

                  PSDEFormDetail refPSDEFormDetail = null;
                  int nLastOrder = -1;
                  if (!StringHelper.IsNullOrEmpty(strRefPSDEFormId)) {
                     for (PSDEFormDetail detail : this.formPartDetailMap.values()) {
                        if (StringHelper.Compare(detail.getPSDEFORMID(), strRefPSDEFormId, false) == 0
                           && StringHelper.Compare(detail.getDETAILTYPE(), "FORMPAGE", true) == 0) {
                           int nOrderValue = detail.getORDERVALUE();
                           if (nOrderValue == -1) {
                              nOrderValue = 99999;
                           }

                           if (refPSDEFormDetail == null) {
                              refPSDEFormDetail = detail;
                              nLastOrder = nOrderValue;
                           } else if (nOrderValue < nLastOrder) {
                              refPSDEFormDetail = detail;
                              nLastOrder = nOrderValue;
                           }
                        }
                     }

                     if (refPSDEFormDetail != null) {
                        strRefPSDEFormDetailId = refPSDEFormDetail.getPSDEFORMDETAILID();
                     }
                  }
               }

               if (!StringHelper.IsNullOrEmpty(strRefPSDEFormDetailId)) {
                  psDEFormDetail = this.formPartDetailMap.get(strRefPSDEFormDetailId);
                  if (psDEFormDetail != null && StringHelper.Compare(psDEFormDetail.getDETAILTYPE(), "FORMPAGE", true) == 0) {
                     psDEFormDetail.setDETAILTYPE("GROUPPANEL");
                     psDEFormDetail.setSHOWCAPTION(false);
                  }
                  break;
               }
            }
         }

         if (psDEFormDetail == null) {
            if (StringHelper.Compare(this.getId(), strPSDEFormId, false) == 0) {
               throw new Exception(StringHelper.Format("表单[%1$s]成员[%2$s]引用表单无效", this.getPSDEFormName(), psDEFormDetail2.getPSDEFORMDETAILNAME()));
            }

            PSDEForm psDEForm = new PSDEForm();
            this.getPSModelHelper().getPSDEForm(psDEFormDetail2.getPSDEFORMID(), psDEForm);
            throw new Exception(StringHelper.Format("表单[%1$s]成员[%2$s]引用表单无效", psDEForm.getPSDEFORMNAME(), psDEFormDetail2.getPSDEFORMDETAILNAME()));
         }

         parentPSDEFormDetail.getChildPSDEFormDetails(true).add(psDEFormDetail);
      }
   }

   protected void fillAllPSDEFVRCondition(IPSDEFVRCondition iPSDEFVRCondition) throws Exception {
      this.allPSDEFVRConditionList.add(iPSDEFVRCondition);
      if (iPSDEFVRCondition instanceof IPSDEFVRGroupCondition) {
         IPSDEFVRGroupCondition iPSDEFVRGroupCondition = (IPSDEFVRGroupCondition)iPSDEFVRCondition;
         Iterator<IPSDEFVRCondition> psDEFVRConditions = iPSDEFVRGroupCondition.getPSDEFVRConditions();
         if (psDEFVRConditions != null) {
            while (psDEFVRConditions.hasNext()) {
               this.fillAllPSDEFVRCondition(psDEFVRConditions.next());
            }
         }
      }
   }

   @PSModelRTMeta(description = "实体属性值规则条件", child = true, rtname = "getGroupCond")
   @Override
   public IPSDEFVRGroupCondition getPSDEFVRGroupCondition() {
      return this.iPSDEFVRGroupCondition;
   }

   @Override
   public Iterator<IPSDEField> getRelatedPSDEFields() {
      return null;
   }

   @Override
   public String getTypeDetail() {
      return this.psDEFValueRule.getPSDEFVRTYPEDETAILID();
   }

   @PSModelRTMeta(description = "代码名称 ")
   @Override
   public String getCodeName() {
      return this.strCodeName;
   }

   @PSModelRTMeta(description = "默认规则 ", group = "基本", order = 125, fields = "DEFAULTMODE")
   @Override
   public boolean isDefaultMode() {
      return this.bDefaultMode;
   }

   @PSModelRTMeta(description = "规则信息", fields = "RULEINFO")
   @Override
   public String getRuleInfo() {
      return this.strRuleInfo;
   }

   @PSModelRTMeta(description = "规则标记", hideempty2 = true, fields = "RULETAG")
   @Override
   public String getRuleTag() {
      return this.psDEFValueRule.getRULETAG();
   }

   @PSModelRTMeta(description = "规则标记2", hideempty2 = true, fields = "RULETAG2")
   @Override
   public String getRuleTag2() {
      return this.psDEFValueRule.getRULETAG2();
   }

   @PSModelRTMeta(description = "默认检查", group = "基本", order = 126, fields = "CHECKDEFAULT")
   @Override
   public boolean isCheckDefault() {
      return this.bCheckDefault;
   }

   @Override
   public Iterator<IPSDEFVRCondition> getAllPSDEFVRConditions() {
      return this.allPSDEFVRConditionList != null && this.allPSDEFVRConditionList.size() != 0 ? this.allPSDEFVRConditionList.iterator() : null;
   }

   @Override
   public String getModelType() {
      return "PSDEFVALUERULE";
   }

   @Override
   public String getModelName() {
      return StringHelper.Format("%1$s#%2$s", this.getPSDEField().getName(), this.getName());
   }

   @Override
   public String getModelId() {
      return StringHelper.Format("%1$s#%2$s", this.getPSDEField().getModelId(), super.getModelId());
   }

   @PSModelRTMeta(description = "规则持有者", codelist = "DELogicHolder", dump = false, fields = "RULEHOLDER")
   @Override
   public int getRuleHolder() {
      return this.nRuleHolder;
   }

   @PSModelRTMeta(description = "支持后台执行", fields = "RULEHOLDER")
   @Override
   public boolean isEnableBackend() {
      return (this.getRuleHolder() & 1) == 1;
   }

   @PSModelRTMeta(description = "支持前台执行", fields = "RULEHOLDER")
   @Override
   public boolean isEnableFront() {
      return (this.getRuleHolder() & 2) == 2;
   }

   protected boolean isCustomRuleHolder() {
      return this.bCustomRuleHolder;
   }

   @PSModelRTMeta(description = "前端扩展插件", hideempty = true)
   @Override
   public IPSSysPFPlugin getPSSysPFPlugin() {
      return this.iPSSysPFPlugin;
   }

   @PSModelRTMeta(description = "后台扩展插件", hideempty = true)
   @Override
   public IPSSysSFPlugin getPSSysSFPlugin() {
      return this.iPSSysSFPlugin;
   }

   @PSModelRTMeta(description = "扩展绘制器", hideempty = true)
   @Override
   public IPSXCodeObject getRender() {
      return this.iPSXCodeObject;
   }

   protected PSDEFValueRuleCond calcPSDEFGroupCond(IPSDEFGroup iPSDEFGroup) throws Exception {
      if (StringHelper.Compare("SORT", iPSDEFGroup.getLogicMode(), false) == 0) {
         return !iPSDEFGroup.contains(this.getPSDEField()) ? null : this.calcPSDEFGroupSortCond(iPSDEFGroup);
      } else if (StringHelper.Compare("NOTSAME", iPSDEFGroup.getLogicMode(), false) == 0) {
         return !iPSDEFGroup.contains(this.getPSDEField()) ? null : this.calcPSDEFGroupNotSameCond(iPSDEFGroup);
      } else {
         return null;
      }
   }

   protected PSDEFValueRuleCond calcPSDEFGroupSortCond(IPSDEFGroup iPSDEFGroup) throws Exception {
      PSDEFValueRuleCond psDEFValueRuleCondGroup = new PSDEFValueRuleCond();
      psDEFValueRuleCondGroup.setCONDTYPE("GROUP");
      psDEFValueRuleCondGroup.setGROUPOP("AND");
      psDEFValueRuleCondGroup.setPSDEFVRCONDID(this.getId() + "_" + iPSDEFGroup.getId());
      psDEFValueRuleCondGroup.setPSDEFVRCONDNAME(String.format("属性组[%1$s]排序逻辑", iPSDEFGroup.getName()));
      psDEFValueRuleCondGroup.setKEYCONDFLAG(true);
      Iterator<IPSDEFGroupDetail> psDEFGroupDetails = iPSDEFGroup.getPSDEFGroupDetails();
      if (psDEFGroupDetails == null) {
         return null;
      }

      boolean bBigMode = true;

      while (psDEFGroupDetails.hasNext()) {
         IPSDEFGroupDetail iPSDEFGroupDetail = psDEFGroupDetails.next();
         if (StringHelper.Compare(iPSDEFGroupDetail.getPSDEField().getId(), this.getPSDEField().getId(), false) == 0) {
            bBigMode = false;
         } else {
            PSDEFValueRuleCond psDEFValueRuleCondGroup2 = new PSDEFValueRuleCond();
            psDEFValueRuleCondGroup2.setCONDTYPE("GROUP");
            psDEFValueRuleCondGroup2.setGROUPOP("OR");
            psDEFValueRuleCondGroup2.setPSDEFVRCONDID(this.getId() + "_" + iPSDEFGroupDetail.getId());
            psDEFValueRuleCondGroup2.setPSDEFVRCONDNAME(String.format("比较属性[%1$s]", iPSDEFGroupDetail.getPSDEField().getName()));
            psDEFValueRuleCondGroup2.setKEYCONDFLAG(true);
            PSDEFValueRuleCond psDEFValueRuleCond = new PSDEFValueRuleCond();
            psDEFValueRuleCond.setPSDEFVRCONDID(psDEFValueRuleCondGroup2.getPSDEFVRCONDID() + "_NULL");
            psDEFValueRuleCond.setPSDEFVRCONDNAME(String.format("属性[%1$s]为空", iPSDEFGroupDetail.getPSDEField().getName()));
            psDEFValueRuleCond.setCONDTYPE("SIMPLE");
            psDEFValueRuleCond.setPSDEFID(iPSDEFGroupDetail.getPSDEField().getId());
            psDEFValueRuleCond.setPSDEFNAME(iPSDEFGroupDetail.getPSDEField().getName());
            psDEFValueRuleCond.setPSDBVALUEOPID("ISNULL");
            psDEFValueRuleCondGroup2.getChildPSDEFValueRuleConds(true).add(psDEFValueRuleCond);
            psDEFValueRuleCond = new PSDEFValueRuleCond();
            psDEFValueRuleCond.setPSDEFVRCONDID(psDEFValueRuleCondGroup2.getPSDEFVRCONDID() + "_TEST");
            psDEFValueRuleCond.setCONDTYPE("SIMPLE");
            psDEFValueRuleCond.setPSDEFID(this.getPSDEField().getId());
            psDEFValueRuleCond.setPSDEFNAME(this.getPSDEField().getName());
            if (bBigMode) {
               psDEFValueRuleCond.setPSDEFVRCONDNAME(String.format("大于属性[%1$s]", iPSDEFGroupDetail.getPSDEField().getName()));
               psDEFValueRuleCond.setPSDBVALUEOPID("GT");
               psDEFValueRuleCond.setRULEINFO(String.format("值不能小于[%2$s]", this.getPSDEField().getLogicName(), iPSDEFGroupDetail.getPSDEField().getLogicName()));
            } else {
               psDEFValueRuleCond.setPSDEFVRCONDNAME(String.format("小于属性[%1$s]", iPSDEFGroupDetail.getPSDEField().getName()));
               psDEFValueRuleCond.setPSDBVALUEOPID("LT");
               psDEFValueRuleCond.setRULEINFO(String.format("值不能大于[%2$s]", this.getPSDEField().getLogicName(), iPSDEFGroupDetail.getPSDEField().getLogicName()));
            }

            psDEFValueRuleCond.setPARAMTYPE("ENTITYFIELD");
            psDEFValueRuleCond.setCONDVALUE(iPSDEFGroupDetail.getPSDEField().getName());
            psDEFValueRuleCondGroup2.getChildPSDEFValueRuleConds(true).add(psDEFValueRuleCond);
            psDEFValueRuleCondGroup.getChildPSDEFValueRuleConds(true).add(psDEFValueRuleCondGroup2);
         }
      }

      if (psDEFValueRuleCondGroup.getChildPSDEFValueRuleConds(true).size() == 0) {
         return null;
      } else {
         return psDEFValueRuleCondGroup.getChildPSDEFValueRuleConds(true).size() == 1
            ? psDEFValueRuleCondGroup.getChildPSDEFValueRuleConds(true).get(0)
            : psDEFValueRuleCondGroup;
      }
   }

   protected PSDEFValueRuleCond calcPSDEFGroupNotSameCond(IPSDEFGroup iPSDEFGroup) throws Exception {
      PSDEFValueRuleCond psDEFValueRuleCondGroup = new PSDEFValueRuleCond();
      psDEFValueRuleCondGroup.setCONDTYPE("GROUP");
      psDEFValueRuleCondGroup.setGROUPOP("AND");
      psDEFValueRuleCondGroup.setPSDEFVRCONDID(this.getId() + "_" + iPSDEFGroup.getId());
      psDEFValueRuleCondGroup.setPSDEFVRCONDNAME(String.format("属性组[%1$s]值不同逻辑", iPSDEFGroup.getName()));
      psDEFValueRuleCondGroup.setKEYCONDFLAG(true);
      Iterator<IPSDEFGroupDetail> psDEFGroupDetails = iPSDEFGroup.getPSDEFGroupDetails();
      if (psDEFGroupDetails == null) {
         return null;
      }

      while (psDEFGroupDetails.hasNext()) {
         IPSDEFGroupDetail iPSDEFGroupDetail = psDEFGroupDetails.next();
         if (StringHelper.Compare(iPSDEFGroupDetail.getPSDEField().getId(), this.getPSDEField().getId(), false) != 0) {
            PSDEFValueRuleCond psDEFValueRuleCondGroup2 = new PSDEFValueRuleCond();
            psDEFValueRuleCondGroup2.setCONDTYPE("GROUP");
            psDEFValueRuleCondGroup2.setGROUPOP("OR");
            psDEFValueRuleCondGroup2.setPSDEFVRCONDID(this.getId() + "_" + iPSDEFGroupDetail.getId());
            psDEFValueRuleCondGroup2.setPSDEFVRCONDNAME(String.format("比较属性[%1$s]", iPSDEFGroupDetail.getPSDEField().getName()));
            psDEFValueRuleCondGroup2.setKEYCONDFLAG(true);
            PSDEFValueRuleCond psDEFValueRuleCond = new PSDEFValueRuleCond();
            psDEFValueRuleCond.setPSDEFVRCONDID(psDEFValueRuleCondGroup2.getPSDEFVRCONDID() + "_NULL");
            psDEFValueRuleCond.setPSDEFVRCONDNAME(String.format("属性[%1$s]为空", iPSDEFGroupDetail.getPSDEField().getName()));
            psDEFValueRuleCond.setCONDTYPE("SIMPLE");
            psDEFValueRuleCond.setPSDEFID(iPSDEFGroupDetail.getPSDEField().getId());
            psDEFValueRuleCond.setPSDEFNAME(iPSDEFGroupDetail.getPSDEField().getName());
            psDEFValueRuleCond.setPSDBVALUEOPID("ISNULL");
            psDEFValueRuleCondGroup2.getChildPSDEFValueRuleConds(true).add(psDEFValueRuleCond);
            psDEFValueRuleCond = new PSDEFValueRuleCond();
            psDEFValueRuleCond.setPSDEFVRCONDID(psDEFValueRuleCondGroup2.getPSDEFVRCONDID() + "_TEST");
            psDEFValueRuleCond.setCONDTYPE("SIMPLE");
            psDEFValueRuleCond.setPSDEFID(this.getPSDEField().getId());
            psDEFValueRuleCond.setPSDEFNAME(this.getPSDEField().getName());
            psDEFValueRuleCond.setPSDEFVRCONDNAME(String.format("不等于属性[%1$s]", iPSDEFGroupDetail.getPSDEField().getName()));
            psDEFValueRuleCond.setPSDBVALUEOPID("NOTEQ");
            psDEFValueRuleCond.setRULEINFO(String.format("内容不能等于[%2$s]", this.getPSDEField().getLogicName(), iPSDEFGroupDetail.getPSDEField().getLogicName()));
            psDEFValueRuleCond.setPARAMTYPE("ENTITYFIELD");
            psDEFValueRuleCond.setCONDVALUE(iPSDEFGroupDetail.getPSDEField().getName());
            psDEFValueRuleCondGroup2.getChildPSDEFValueRuleConds(true).add(psDEFValueRuleCond);
            psDEFValueRuleCondGroup.getChildPSDEFValueRuleConds(true).add(psDEFValueRuleCondGroup2);
         }
      }

      if (psDEFValueRuleCondGroup.getChildPSDEFValueRuleConds(true).size() == 0) {
         return null;
      } else {
         return psDEFValueRuleCondGroup.getChildPSDEFValueRuleConds(true).size() == 1
            ? psDEFValueRuleCondGroup.getChildPSDEFValueRuleConds(true).get(0)
            : psDEFValueRuleCondGroup;
      }
   }

   @PSModelRTMeta(description = "自定义脚本代码", ignoredumpvalues = "false")
   @Override
   public boolean isCustomCode() {
      return this.bCustomCode;
   }

   @PSModelRTMeta(description = "脚本代码", fields = "CUSTOMCODE")
   @Override
   public String getScriptCode() {
      return this.isCustomCode() ? this.psDEFValueRule.getCUSTOMCODE() : null;
   }

   protected String getPSDEFormId() {
      return this.psDEFValueRule.getPSDEFORMID();
   }

   protected String getPSDEFormName() {
      return this.psDEFValueRule.getPSDEFORMNAME();
   }

   @PSModelRTMeta(description = "规则信息语言资源标记")
   @Override
   public String getRuleInfoLanResTag() {
      return this.getRuleInfoPSLanguageRes() == null ? null : this.getRuleInfoPSLanguageRes().getLanResTag();
   }

   @PSModelRTMeta(description = "规则信息语言资源对象")
   @Override
   public IPSLanguageRes getRuleInfoPSLanguageRes() {
      return this.ruleInfoPSLanguageRes;
   }
}
