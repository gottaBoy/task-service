/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.DataEx.Conditions
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DEField.ValueRule;

import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DEField.IPSDEFGroupDetail;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.PSDEFieldObjectImpl;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFVRCondition;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFVRGroupCondition;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFValueRule;
import SA.SRFDA.PS.Core.DEField.ValueRule.PSDEFVRGroupConditionImpl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFValueRuleImpl
extends PSDEFieldObjectImpl
implements IPSDEFValueRule {
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
    protected Vector<PSDEFormRF> psDEFormRFList = new Vector();
    private Map<String, PSDEFormDetail> formPartDetailMap = new LinkedHashMap<String, PSDEFormDetail>();
    private ArrayList<IPSDEFVRCondition> allPSDEFVRConditionList = new ArrayList();
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
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFValueRule.getVRTYPE())) {
                    boolean bl = this.bCustomCode = SA.SRFramework.Utility.StringHelper.Compare((String)this.psDEFValueRule.getVRTYPE(), (String)"SCRIPT", (boolean)true) == 0;
                }
            }
            if (!this.psDEFValueRule.isRULEHOLDERNull()) {
                this.nRuleHolder = this.psDEFValueRule.getRULEHOLDER();
                this.bCustomRuleHolder = true;
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFValueRule.getPSSYSPFPLUGINID())) {
            this.iPSSysPFPlugin = this.getPSDataEntity().getPSSystem().getPSSysPFPlugin(this.psDEFValueRule.getPSSYSPFPLUGINID());
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFValueRule.getPSSYSSFPLUGINID())) {
            this.iPSSysSFPlugin = this.getPSDataEntity().getPSSystem().getPSSysSFPlugin(this.psDEFValueRule.getPSSYSSFPLUGINID());
        }
        if (this.getPSSysSFPlugin() != null) {
            String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSDataEntity().getPSSystem().getPSSFId());
            IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSDataEntity().getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
            if (iPSSysSFPluginTempl != null) {
                this.iPSXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
            }
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFValueRule.getRIPSLANRESID())) {
            this.ruleInfoPSLanguageRes = this.getPSDataEntity().getPSSystem().getPSLanguageRes(this.psDEFValueRule.getRIPSLANRESID());
        }
        super.onInit();
        if (!this.isCustomCode()) {
            this.onPreparePSDEFVRConds();
        }
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.strRuleInfo, (String)"\u9ed8\u8ba4\u89c4\u5219", (boolean)true) == 0) {
            this.strRuleInfo = "";
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strRuleInfo) && this.iPSDEFVRGroupCondition != null) {
            this.strRuleInfo = this.iPSDEFVRGroupCondition.getRuleInfo();
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strRuleInfo)) {
            this.strRuleInfo = this.getName();
        }
    }

    protected void onPreparePSDEFVRConds() throws Exception {
        this.iPSDEFVRGroupCondition = null;
        this.allPSDEFVRConditionList.clear();
        Vector<PSDEFValueRuleCond> psDEFValueRuleCondList = new Vector<PSDEFValueRuleCond>();
        if (SA.SRFramework.Utility.StringHelper.Compare((String)"FORMITEMS", (String)this.psDEFValueRule.getVRTYPE(), (boolean)true) == 0) {
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFValueRule.getPSDEFORMID())) {
                throw new Exception("\u503c\u89c4\u5219\u7c7b\u578b\u4e3a\u8868\u5355\u9879\uff0c\u4f46\u672a\u6307\u5b9a\u7f16\u8f91\u8868\u5355");
            }
            this.onPreparePSDEFormDetails(psDEFValueRuleCondList);
        } else {
            CallResult callResult = this.getPSModelHelper().getPSDEFValueRuleConds(this.getId(), psDEFValueRuleCondList);
            if (callResult.isError()) {
                throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u503c\u89c4\u5219\u6761\u4ef6\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
            }
        }
        LinkedHashMap<String, PSDEFValueRuleCond> psDEFValueRuleCondMap = new LinkedHashMap<String, PSDEFValueRuleCond>();
        for (PSDEFValueRuleCond psDEFValueRuleCond : psDEFValueRuleCondList) {
            psDEFValueRuleCondMap.put(psDEFValueRuleCond.getPSDEFVRCONDID(), psDEFValueRuleCond);
        }
        for (PSDEFValueRuleCond psDEFValueRuleCond : psDEFValueRuleCondList) {
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEFValueRuleCond.getPPSDEFVRCONDID())) continue;
            PSDEFValueRuleCond parentPSDEFValueRuleCond = (PSDEFValueRuleCond)((Object)psDEFValueRuleCondMap.get(psDEFValueRuleCond.getPPSDEFVRCONDID()));
            parentPSDEFValueRuleCond.getChildPSDEFValueRuleConds(true).add(psDEFValueRuleCond);
        }
        PSDEFValueRuleCond psDEFValueRuleCondGroup = new PSDEFValueRuleCond();
        psDEFValueRuleCondGroup.setCONDTYPE("GROUP");
        psDEFValueRuleCondGroup.setGROUPOP("AND");
        psDEFValueRuleCondGroup.setPSDEFVRCONDID(this.getId());
        psDEFValueRuleCondGroup.setPSDEFVRCONDNAME("\u9ed8\u8ba4\u7ec4");
        for (PSDEFValueRuleCond psDEFValueRuleCond : psDEFValueRuleCondList) {
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEFValueRuleCond.getPPSDEFVRCONDID())) continue;
            psDEFValueRuleCondGroup.getChildPSDEFValueRuleConds(true).add(psDEFValueRuleCond);
        }
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getCodeName(), (String)"DEFAULT", (boolean)true) == 0) {
            Iterator<IPSDEFGroup> psDEFGroups;
            PSDEFValueRuleCond psDEFValueRuleCond;
            if (this.getPSDEField().getStringLength() > 0) {
                psDEFValueRuleCond = new PSDEFValueRuleCond();
                psDEFValueRuleCond.setPSDEFVRCONDID(String.valueOf(this.getId()) + "_" + "STRINGLENGTH");
                psDEFValueRuleCond.setPSDEFVRCONDNAME("\u9ed8\u8ba4\u5b57\u7b26\u4e32\u957f\u5ea6");
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
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPSDEField().getMinValueString()) || !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPSDEField().getMaxValueString())) {
                psDEFValueRuleCond = new PSDEFValueRuleCond();
                psDEFValueRuleCond.setPSDEFVRCONDID(String.valueOf(this.getId()) + "_" + "VALUERANGE2");
                psDEFValueRuleCond.setPSDEFVRCONDNAME("\u9ed8\u8ba4\u503c\u8303\u56f4");
                psDEFValueRuleCond.setCONDTYPE("VALUERANGE2");
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPSDEField().getMinValueString())) {
                    psDEFValueRuleCond.setPARAM7(this.getPSDEField().getMinValueString());
                    psDEFValueRuleCond.setPARAM5(true);
                }
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPSDEField().getMaxValueString())) {
                    psDEFValueRuleCond.setPARAM8(this.getPSDEField().getMaxValueString());
                    psDEFValueRuleCond.setPARAM6(true);
                }
                psDEFValueRuleCond.setKEYCONDFLAG(true);
                psDEFValueRuleCondGroup.getChildPSDEFValueRuleConds(true).add(psDEFValueRuleCond);
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPSDEField().getPSSysValueRuleId())) {
                PSDEFValueRuleCond psDEFValueRuleCond2;
                IPSSysValueRule iPSSysVaueRule = this.getPSDataEntity().getPSSystem().getPSSysValueRule(this.getPSDEField().getPSSysValueRuleId());
                if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSSysVaueRule.getRuleType(), (String)"REG", (boolean)true) == 0) {
                    psDEFValueRuleCond2 = new PSDEFValueRuleCond();
                    psDEFValueRuleCond2.setPSDEFVRCONDID(String.valueOf(this.getId()) + "_" + "REGEX");
                    psDEFValueRuleCond2.setPSDEFVRCONDNAME(iPSSysVaueRule.getName());
                    psDEFValueRuleCond2.setCONDTYPE("REGEX");
                    psDEFValueRuleCond2.setCONDVALUE(iPSSysVaueRule.getRegExCode());
                    psDEFValueRuleCond2.setRULEINFO(iPSSysVaueRule.getRuleInfo());
                    psDEFValueRuleCond2.setKEYCONDFLAG(true);
                    psDEFValueRuleCondGroup.getChildPSDEFValueRuleConds(true).add(psDEFValueRuleCond2);
                } else {
                    psDEFValueRuleCond2 = new PSDEFValueRuleCond();
                    psDEFValueRuleCond2.setPSDEFVRCONDID(String.valueOf(this.getId()) + "_" + "SYSVALUERULE");
                    psDEFValueRuleCond2.setPSDEFVRCONDNAME(iPSSysVaueRule.getName());
                    psDEFValueRuleCond2.setCONDTYPE("SYSVALUERULE");
                    psDEFValueRuleCond2.setPSSYSVALUERULEID(iPSSysVaueRule.getId());
                    psDEFValueRuleCond2.setRULEINFO(iPSSysVaueRule.getRuleInfo());
                    psDEFValueRuleCond2.setKEYCONDFLAG(true);
                    psDEFValueRuleCondGroup.getChildPSDEFValueRuleConds(true).add(psDEFValueRuleCond2);
                }
            }
            if (this.getPSDEField().isCheckRecursion()) {
                psDEFValueRuleCond = new PSDEFValueRuleCond();
                psDEFValueRuleCond.setPSDEFVRCONDID(String.valueOf(this.getId()) + "_" + "VALUERECURSION");
                psDEFValueRuleCond.setPSDEFVRCONDNAME("\u9ed8\u8ba4\u9012\u5f52\u68c0\u67e5");
                psDEFValueRuleCond.setCONDTYPE("VALUERECURSION");
                psDEFValueRuleCond.setKEYCONDFLAG(true);
                IPSDataEntity inheritPSDataEntity = this.getPSDEField().getPSDataEntity().getInheritPSDataEntity();
                if (inheritPSDataEntity != null) {
                    psDEFValueRuleCond.setMAJORPSDEID(inheritPSDataEntity.getId());
                    psDEFValueRuleCond.setMAJORPSDENAME(inheritPSDataEntity.getName());
                }
                psDEFValueRuleCondGroup.getChildPSDEFValueRuleConds(true).add(psDEFValueRuleCond);
            }
            if ((psDEFGroups = this.getPSDataEntity().getAllPSDEFGroups()) != null) {
                while (psDEFGroups.hasNext()) {
                    IPSDEFGroup iPSDEFGroup = psDEFGroups.next();
                    PSDEFValueRuleCond psDEFValueRuleCond3 = this.calcPSDEFGroupCond(iPSDEFGroup);
                    if (psDEFValueRuleCond3 == null) continue;
                    psDEFValueRuleCondGroup.getChildPSDEFValueRuleConds(true).add(psDEFValueRuleCond3);
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
        Vector<PSDEFormDetail> psDEFormPageList = new Vector<PSDEFormDetail>();
        CallResult callResult = this.getPSModelHelper().getPSDEFormDetails(strPSDEFormId, psDEFormPageList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u8868\u5355\u6210\u5458\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, PSDEFormDetail> psDEFormDetailMap = new HashMap<String, PSDEFormDetail>();
        for (PSDEFormDetail psDEFormDetail : psDEFormPageList) {
            psDEFormDetailMap.put(psDEFormDetail.getPSDEFORMDETAILID(), psDEFormDetail);
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strPSDEFormId, (String)this.getPSDEFormId(), (boolean)true) == 0) continue;
            this.formPartDetailMap.put(psDEFormDetail.getPSDEFORMDETAILID(), psDEFormDetail);
        }
        for (PSDEFormDetail psDEFormDetail : psDEFormPageList) {
            PSDEForm psDEForm;
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEFormDetail.getPPSDEFORMDETAILID())) continue;
            PSDEFormDetail psDEFormDetail2 = psDEFormDetail;
            PSDEFormDetail parentPSDEFormDetail = (PSDEFormDetail)((Object)psDEFormDetailMap.get(psDEFormDetail.getPPSDEFORMDETAILID()));
            if (parentPSDEFormDetail == null) {
                if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getId(), (String)strPSDEFormId, (boolean)false) == 0) {
                    throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u8868\u5355[%1$s]\u6210\u5458[%2$s]\u7236\u5bf9\u8c61\u65e0\u6548", (Object)this.getLogicName(), (Object)psDEFormDetail2.getPSDEFORMDETAILNAME()));
                }
                psDEForm = new PSDEForm();
                this.getPSModelHelper().getPSDEForm(psDEFormDetail2.getPSDEFORMID(), psDEForm);
                throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u8868\u5355[%1$s]\u6210\u5458[%2$s]\u7236\u5bf9\u8c61\u65e0\u6548", (Object)psDEForm.getPSDEFORMNAME(), (Object)psDEFormDetail2.getPSDEFORMDETAILNAME()));
            }
            if (bMajor && SA.SRFramework.Utility.StringHelper.Compare((String)psDEFormDetail.getDETAILTYPE(), (String)"FORMPART", (boolean)true) == 0) {
                String strFormPartType = psDEFormDetail.getCONTENTTYPE();
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strFormPartType)) {
                    strFormPartType = "FORMRF";
                }
                if (SA.SRFramework.Utility.StringHelper.Compare((String)strFormPartType, (String)"FORMRF", (boolean)false) == 0) {
                    String strRefPSDEFormDetailId = psDEFormDetail.getREFPSDEFORMDETAILID();
                    if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strRefPSDEFormDetailId)) {
                        String strRefPSDEFormId = null;
                        for (PSDEFormRF psDEFormRF : this.psDEFormRFList) {
                            if (SA.SRFramework.Utility.StringHelper.Compare((String)psDEFormDetail.getPSDEFORMRFID(), (String)psDEFormRF.getPSDEFORMRFID(), (boolean)false) != 0) continue;
                            strRefPSDEFormId = psDEFormRF.getMINORPSDEFORMID();
                        }
                        PSDEFormDetail refPSDEFormDetail = null;
                        int nLastOrder = -1;
                        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty(strRefPSDEFormId)) {
                            for (PSDEFormDetail detail : this.formPartDetailMap.values()) {
                                if (SA.SRFramework.Utility.StringHelper.Compare((String)detail.getPSDEFORMID(), (String)strRefPSDEFormId, (boolean)false) != 0 || SA.SRFramework.Utility.StringHelper.Compare((String)detail.getDETAILTYPE(), (String)"FORMPAGE", (boolean)true) != 0) continue;
                                int nOrderValue = detail.getORDERVALUE();
                                if (nOrderValue == -1) {
                                    nOrderValue = 99999;
                                }
                                if (refPSDEFormDetail == null) {
                                    refPSDEFormDetail = detail;
                                    nLastOrder = nOrderValue;
                                    continue;
                                }
                                if (nOrderValue >= nLastOrder) continue;
                                refPSDEFormDetail = detail;
                                nLastOrder = nOrderValue;
                            }
                            if (refPSDEFormDetail != null) {
                                strRefPSDEFormDetailId = refPSDEFormDetail.getPSDEFORMDETAILID();
                            }
                        }
                    }
                    if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strRefPSDEFormDetailId)) continue;
                    psDEFormDetail = this.formPartDetailMap.get(strRefPSDEFormDetailId);
                    if (psDEFormDetail != null && SA.SRFramework.Utility.StringHelper.Compare((String)psDEFormDetail.getDETAILTYPE(), (String)"FORMPAGE", (boolean)true) == 0) {
                        psDEFormDetail.setDETAILTYPE("GROUPPANEL");
                        psDEFormDetail.setSHOWCAPTION(false);
                    }
                }
            }
            if (psDEFormDetail == null) {
                if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getId(), (String)strPSDEFormId, (boolean)false) == 0) {
                    throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u8868\u5355[%1$s]\u6210\u5458[%2$s]\u5f15\u7528\u8868\u5355\u65e0\u6548", (Object)this.getPSDEFormName(), (Object)psDEFormDetail2.getPSDEFORMDETAILNAME()));
                }
                psDEForm = new PSDEForm();
                this.getPSModelHelper().getPSDEForm(psDEFormDetail2.getPSDEFORMID(), psDEForm);
                throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u8868\u5355[%1$s]\u6210\u5458[%2$s]\u5f15\u7528\u8868\u5355\u65e0\u6548", (Object)psDEForm.getPSDEFORMNAME(), (Object)psDEFormDetail2.getPSDEFORMDETAILNAME()));
            }
            parentPSDEFormDetail.getChildPSDEFormDetails(true).add(psDEFormDetail);
        }
        Vector<PSDEFDLogic> psDEFDLogicList = new Vector<PSDEFDLogic>();
        callResult = this.getPSModelHelper().getPSDEFDLogics(strPSDEFormId, psDEFDLogicList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u8868\u5355\u6210\u5458\u903b\u8f91\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, PSDEFDLogic> psDEFDLogicMap = new HashMap<String, PSDEFDLogic>();
        for (PSDEFDLogic psDEFDLogic : psDEFDLogicList) {
            psDEFDLogicMap.put(psDEFDLogic.getPSDEFDLOGICID(), psDEFDLogic);
        }
        for (PSDEFDLogic psDEFDLogic : psDEFDLogicList) {
            PSDEFDLogic parentPSDEFDLogic;
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEFDLogic.getPPSDEFDLOGICID()) || (parentPSDEFDLogic = (PSDEFDLogic)((Object)psDEFDLogicMap.get(psDEFDLogic.getPPSDEFDLOGICID()))) == null) continue;
            parentPSDEFDLogic.getChildPSDEFDLogics(true).add(psDEFDLogic);
        }
        for (PSDEFDLogic psDEFDLogic : psDEFDLogicList) {
            PSDEFormDetail psDEFormDetail;
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEFDLogic.getPPSDEFDLOGICID()) || (psDEFormDetail = (PSDEFormDetail)((Object)psDEFormDetailMap.get(psDEFDLogic.getPSDEFORMDETAILID()))) == null) continue;
            psDEFormDetail.getChildPSDEFDLogics(psDEFDLogic.getLOGICCAT(), true).add(psDEFDLogic);
        }
        if (SA.SRFramework.Utility.StringHelper.Compare((String)strPSDEFormId, (String)this.getPSDEFormId(), (boolean)true) == 0) {
            for (PSDEFormDetail psDEFormDetail : psDEFormPageList) {
                if (SA.SRFramework.Utility.StringHelper.Compare((String)psDEFormDetail.getDETAILTYPE(), (String)"FORMITEM", (boolean)true) != 0 && SA.SRFramework.Utility.StringHelper.Compare((String)psDEFormDetail.getDETAILTYPE(), (String)"FORMITEMEX", (boolean)true) != 0 || SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEFormDetail.getPSDEFID())) continue;
                boolean bAllowEmpty = true;
                if (!psDEFormDetail.isALLOWEMPTYNull()) {
                    bAllowEmpty = psDEFormDetail.getALLOWEMPTY();
                }
                if (bAllowEmpty) {
                    ArrayList<PSDEFDLogic> psDEFDLogicList2 = psDEFormDetail.getChildPSDEFDLogics("ITEMBLANK", false);
                    if (psDEFDLogicList2 == null || psDEFDLogicList2.size() == 0) continue;
                    PSDEFValueRuleCond groupPSDEFValueRuleCond = new PSDEFValueRuleCond();
                    groupPSDEFValueRuleCond.setCONDTYPE("GROUP");
                    groupPSDEFValueRuleCond.setGROUPOP("OR");
                    PSDEFValueRuleCond psDEFValueRuleCond = new PSDEFValueRuleCond();
                    psDEFValueRuleCond.setPSDEFID(psDEFormDetail.getPSDEFID());
                    psDEFValueRuleCond.setPSDEFNAME(psDEFormDetail.getPSDEFNAME());
                    psDEFValueRuleCond.setCONDTYPE("SIMPLE");
                    psDEFValueRuleCond.setPSDBVALUEOPID("ISNOTNULL");
                    psDEFValueRuleCond.setPSDBVALUEOPNAME(Conditions.GetConditionLogicName((String)"ISNOTNULL"));
                    groupPSDEFValueRuleCond.getChildPSDEFValueRuleConds(true).add(psDEFValueRuleCond);
                    PSDEFValueRuleCond andPSDEFValueRuleCond = new PSDEFValueRuleCond();
                    andPSDEFValueRuleCond.setCONDTYPE("GROUP");
                    andPSDEFValueRuleCond.setGROUPOP("AND");
                    psDEFValueRuleCondList.add(groupPSDEFValueRuleCond);
                    continue;
                }
                PSDEFValueRuleCond psDEFValueRuleCond = new PSDEFValueRuleCond();
                psDEFValueRuleCond.setPSDEFID(psDEFormDetail.getPSDEFID());
                psDEFValueRuleCond.setPSDEFNAME(psDEFormDetail.getPSDEFNAME());
                psDEFValueRuleCond.setCONDTYPE("SIMPLE");
                psDEFValueRuleCond.setPSDBVALUEOPID("ISNOTNULL");
                psDEFValueRuleCond.setPSDBVALUEOPNAME(Conditions.GetConditionLogicName((String)"ISNOTNULL"));
                psDEFValueRuleCondList.add(psDEFValueRuleCond);
            }
            for (PSDEFormDetail psDEFormDetail : psDEFormPageList) {
                psDEFormDetail.resetChildDatas();
            }
        }
    }

    protected void fillAllPSDEFVRCondition(IPSDEFVRCondition iPSDEFVRCondition) throws Exception {
        IPSDEFVRGroupCondition iPSDEFVRGroupCondition;
        Iterator<IPSDEFVRCondition> psDEFVRConditions;
        this.allPSDEFVRConditionList.add(iPSDEFVRCondition);
        if (iPSDEFVRCondition instanceof IPSDEFVRGroupCondition && (psDEFVRConditions = (iPSDEFVRGroupCondition = (IPSDEFVRGroupCondition)iPSDEFVRCondition).getPSDEFVRConditions()) != null) {
            while (psDEFVRConditions.hasNext()) {
                this.fillAllPSDEFVRCondition(psDEFVRConditions.next());
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5c5e\u6027\u503c\u89c4\u5219\u6761\u4ef6", child=true, rtname="getGroupCond")
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

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f0 ")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u89c4\u5219 ", group="\u57fa\u672c", order=125, fields={"DEFAULTMODE"})
    public boolean isDefaultMode() {
        return this.bDefaultMode;
    }

    @Override
    @PSModelRTMeta(description="\u89c4\u5219\u4fe1\u606f", fields={"RULEINFO"})
    public String getRuleInfo() {
        return this.strRuleInfo;
    }

    @Override
    @PSModelRTMeta(description="\u89c4\u5219\u6807\u8bb0", hideempty2=true, fields={"RULETAG"})
    public String getRuleTag() {
        return this.psDEFValueRule.getRULETAG();
    }

    @Override
    @PSModelRTMeta(description="\u89c4\u5219\u6807\u8bb02", hideempty2=true, fields={"RULETAG2"})
    public String getRuleTag2() {
        return this.psDEFValueRule.getRULETAG2();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u68c0\u67e5", group="\u57fa\u672c", order=126, fields={"CHECKDEFAULT"})
    public boolean isCheckDefault() {
        return this.bCheckDefault;
    }

    @Override
    public Iterator<IPSDEFVRCondition> getAllPSDEFVRConditions() {
        if (this.allPSDEFVRConditionList == null || this.allPSDEFVRConditionList.size() == 0) {
            return null;
        }
        return this.allPSDEFVRConditionList.iterator();
    }

    @Override
    public String getModelType() {
        return "PSDEFVALUERULE";
    }

    @Override
    public String getModelName() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDEField().getName(), (Object)this.getName());
    }

    @Override
    public String getModelId() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDEField().getModelId(), (Object)super.getModelId());
    }

    @Override
    @PSModelRTMeta(description="\u89c4\u5219\u6301\u6709\u8005", codelist="DELogicHolder", dump=false, fields={"RULEHOLDER"})
    public int getRuleHolder() {
        return this.nRuleHolder;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u540e\u53f0\u6267\u884c", fields={"RULEHOLDER"})
    public boolean isEnableBackend() {
        return (this.getRuleHolder() & 1) == 1;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u524d\u53f0\u6267\u884c", fields={"RULEHOLDER"})
    public boolean isEnableFront() {
        return (this.getRuleHolder() & 2) == 2;
    }

    protected boolean isCustomRuleHolder() {
        return this.bCustomRuleHolder;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u7ed8\u5236\u5668", hideempty=true)
    public IPSXCodeObject getRender() {
        return this.iPSXCodeObject;
    }

    protected PSDEFValueRuleCond calcPSDEFGroupCond(IPSDEFGroup iPSDEFGroup) throws Exception {
        if (SA.SRFramework.Utility.StringHelper.Compare((String)"SORT", (String)iPSDEFGroup.getLogicMode(), (boolean)false) == 0) {
            if (!iPSDEFGroup.contains(this.getPSDEField())) {
                return null;
            }
            return this.calcPSDEFGroupSortCond(iPSDEFGroup);
        }
        if (SA.SRFramework.Utility.StringHelper.Compare((String)"NOTSAME", (String)iPSDEFGroup.getLogicMode(), (boolean)false) == 0) {
            if (!iPSDEFGroup.contains(this.getPSDEField())) {
                return null;
            }
            return this.calcPSDEFGroupNotSameCond(iPSDEFGroup);
        }
        return null;
    }

    protected PSDEFValueRuleCond calcPSDEFGroupSortCond(IPSDEFGroup iPSDEFGroup) throws Exception {
        PSDEFValueRuleCond psDEFValueRuleCondGroup = new PSDEFValueRuleCond();
        psDEFValueRuleCondGroup.setCONDTYPE("GROUP");
        psDEFValueRuleCondGroup.setGROUPOP("AND");
        psDEFValueRuleCondGroup.setPSDEFVRCONDID(String.valueOf(this.getId()) + "_" + iPSDEFGroup.getId());
        psDEFValueRuleCondGroup.setPSDEFVRCONDNAME(String.format("\u5c5e\u6027\u7ec4[%1$s]\u6392\u5e8f\u903b\u8f91", iPSDEFGroup.getName()));
        psDEFValueRuleCondGroup.setKEYCONDFLAG(true);
        Iterator<IPSDEFGroupDetail> psDEFGroupDetails = iPSDEFGroup.getPSDEFGroupDetails();
        if (psDEFGroupDetails == null) {
            return null;
        }
        boolean bBigMode = true;
        while (psDEFGroupDetails.hasNext()) {
            IPSDEFGroupDetail iPSDEFGroupDetail = psDEFGroupDetails.next();
            if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEFGroupDetail.getPSDEField().getId(), (String)this.getPSDEField().getId(), (boolean)false) == 0) {
                bBigMode = false;
                continue;
            }
            PSDEFValueRuleCond psDEFValueRuleCondGroup2 = new PSDEFValueRuleCond();
            psDEFValueRuleCondGroup2.setCONDTYPE("GROUP");
            psDEFValueRuleCondGroup2.setGROUPOP("OR");
            psDEFValueRuleCondGroup2.setPSDEFVRCONDID(String.valueOf(this.getId()) + "_" + iPSDEFGroupDetail.getId());
            psDEFValueRuleCondGroup2.setPSDEFVRCONDNAME(String.format("\u6bd4\u8f83\u5c5e\u6027[%1$s]", iPSDEFGroupDetail.getPSDEField().getName()));
            psDEFValueRuleCondGroup2.setKEYCONDFLAG(true);
            PSDEFValueRuleCond psDEFValueRuleCond = new PSDEFValueRuleCond();
            psDEFValueRuleCond.setPSDEFVRCONDID(String.valueOf(psDEFValueRuleCondGroup2.getPSDEFVRCONDID()) + "_NULL");
            psDEFValueRuleCond.setPSDEFVRCONDNAME(String.format("\u5c5e\u6027[%1$s]\u4e3a\u7a7a", iPSDEFGroupDetail.getPSDEField().getName()));
            psDEFValueRuleCond.setCONDTYPE("SIMPLE");
            psDEFValueRuleCond.setPSDEFID(iPSDEFGroupDetail.getPSDEField().getId());
            psDEFValueRuleCond.setPSDEFNAME(iPSDEFGroupDetail.getPSDEField().getName());
            psDEFValueRuleCond.setPSDBVALUEOPID("ISNULL");
            psDEFValueRuleCondGroup2.getChildPSDEFValueRuleConds(true).add(psDEFValueRuleCond);
            psDEFValueRuleCond = new PSDEFValueRuleCond();
            psDEFValueRuleCond.setPSDEFVRCONDID(String.valueOf(psDEFValueRuleCondGroup2.getPSDEFVRCONDID()) + "_TEST");
            psDEFValueRuleCond.setCONDTYPE("SIMPLE");
            psDEFValueRuleCond.setPSDEFID(this.getPSDEField().getId());
            psDEFValueRuleCond.setPSDEFNAME(this.getPSDEField().getName());
            if (bBigMode) {
                psDEFValueRuleCond.setPSDEFVRCONDNAME(String.format("\u5927\u4e8e\u5c5e\u6027[%1$s]", iPSDEFGroupDetail.getPSDEField().getName()));
                psDEFValueRuleCond.setPSDBVALUEOPID("GT");
                psDEFValueRuleCond.setRULEINFO(String.format("\u503c\u4e0d\u80fd\u5c0f\u4e8e[%2$s]", this.getPSDEField().getLogicName(), iPSDEFGroupDetail.getPSDEField().getLogicName()));
            } else {
                psDEFValueRuleCond.setPSDEFVRCONDNAME(String.format("\u5c0f\u4e8e\u5c5e\u6027[%1$s]", iPSDEFGroupDetail.getPSDEField().getName()));
                psDEFValueRuleCond.setPSDBVALUEOPID("LT");
                psDEFValueRuleCond.setRULEINFO(String.format("\u503c\u4e0d\u80fd\u5927\u4e8e[%2$s]", this.getPSDEField().getLogicName(), iPSDEFGroupDetail.getPSDEField().getLogicName()));
            }
            psDEFValueRuleCond.setPARAMTYPE("ENTITYFIELD");
            psDEFValueRuleCond.setCONDVALUE(iPSDEFGroupDetail.getPSDEField().getName());
            psDEFValueRuleCondGroup2.getChildPSDEFValueRuleConds(true).add(psDEFValueRuleCond);
            psDEFValueRuleCondGroup.getChildPSDEFValueRuleConds(true).add(psDEFValueRuleCondGroup2);
        }
        if (psDEFValueRuleCondGroup.getChildPSDEFValueRuleConds(true).size() == 0) {
            return null;
        }
        if (psDEFValueRuleCondGroup.getChildPSDEFValueRuleConds(true).size() == 1) {
            return psDEFValueRuleCondGroup.getChildPSDEFValueRuleConds(true).get(0);
        }
        return psDEFValueRuleCondGroup;
    }

    /*
     * Unable to fully structure code
     */
    protected PSDEFValueRuleCond calcPSDEFGroupNotSameCond(IPSDEFGroup iPSDEFGroup) throws Exception {
        psDEFValueRuleCondGroup = new PSDEFValueRuleCond();
        psDEFValueRuleCondGroup.setCONDTYPE("GROUP");
        psDEFValueRuleCondGroup.setGROUPOP("AND");
        psDEFValueRuleCondGroup.setPSDEFVRCONDID(String.valueOf(this.getId()) + "_" + iPSDEFGroup.getId());
        psDEFValueRuleCondGroup.setPSDEFVRCONDNAME(String.format("\u5c5e\u6027\u7ec4[%1$s]\u503c\u4e0d\u540c\u903b\u8f91", new Object[]{iPSDEFGroup.getName()}));
        psDEFValueRuleCondGroup.setKEYCONDFLAG(true);
        psDEFGroupDetails = iPSDEFGroup.getPSDEFGroupDetails();
        if (psDEFGroupDetails != null) ** GOTO lbl41
        return null;
lbl-1000:
        // 1 sources

        {
            iPSDEFGroupDetail = psDEFGroupDetails.next();
            if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEFGroupDetail.getPSDEField().getId(), (String)this.getPSDEField().getId(), (boolean)false) == 0) continue;
            psDEFValueRuleCondGroup2 = new PSDEFValueRuleCond();
            psDEFValueRuleCondGroup2.setCONDTYPE("GROUP");
            psDEFValueRuleCondGroup2.setGROUPOP("OR");
            psDEFValueRuleCondGroup2.setPSDEFVRCONDID(String.valueOf(this.getId()) + "_" + iPSDEFGroupDetail.getId());
            psDEFValueRuleCondGroup2.setPSDEFVRCONDNAME(String.format("\u6bd4\u8f83\u5c5e\u6027[%1$s]", new Object[]{iPSDEFGroupDetail.getPSDEField().getName()}));
            psDEFValueRuleCondGroup2.setKEYCONDFLAG(true);
            psDEFValueRuleCond = new PSDEFValueRuleCond();
            psDEFValueRuleCond.setPSDEFVRCONDID(String.valueOf(psDEFValueRuleCondGroup2.getPSDEFVRCONDID()) + "_NULL");
            psDEFValueRuleCond.setPSDEFVRCONDNAME(String.format("\u5c5e\u6027[%1$s]\u4e3a\u7a7a", new Object[]{iPSDEFGroupDetail.getPSDEField().getName()}));
            psDEFValueRuleCond.setCONDTYPE("SIMPLE");
            psDEFValueRuleCond.setPSDEFID(iPSDEFGroupDetail.getPSDEField().getId());
            psDEFValueRuleCond.setPSDEFNAME(iPSDEFGroupDetail.getPSDEField().getName());
            psDEFValueRuleCond.setPSDBVALUEOPID("ISNULL");
            psDEFValueRuleCondGroup2.getChildPSDEFValueRuleConds(true).add(psDEFValueRuleCond);
            psDEFValueRuleCond = new PSDEFValueRuleCond();
            psDEFValueRuleCond.setPSDEFVRCONDID(String.valueOf(psDEFValueRuleCondGroup2.getPSDEFVRCONDID()) + "_TEST");
            psDEFValueRuleCond.setCONDTYPE("SIMPLE");
            psDEFValueRuleCond.setPSDEFID(this.getPSDEField().getId());
            psDEFValueRuleCond.setPSDEFNAME(this.getPSDEField().getName());
            psDEFValueRuleCond.setPSDEFVRCONDNAME(String.format("\u4e0d\u7b49\u4e8e\u5c5e\u6027[%1$s]", new Object[]{iPSDEFGroupDetail.getPSDEField().getName()}));
            psDEFValueRuleCond.setPSDBVALUEOPID("NOTEQ");
            psDEFValueRuleCond.setRULEINFO(String.format("\u5185\u5bb9\u4e0d\u80fd\u7b49\u4e8e[%2$s]", new Object[]{this.getPSDEField().getLogicName(), iPSDEFGroupDetail.getPSDEField().getLogicName()}));
            psDEFValueRuleCond.setPARAMTYPE("ENTITYFIELD");
            psDEFValueRuleCond.setCONDVALUE(iPSDEFGroupDetail.getPSDEField().getName());
            psDEFValueRuleCondGroup2.getChildPSDEFValueRuleConds(true).add(psDEFValueRuleCond);
            psDEFValueRuleCondGroup.getChildPSDEFValueRuleConds(true).add(psDEFValueRuleCondGroup2);
lbl41:
            // 3 sources

            ** while (psDEFGroupDetails.hasNext())
        }
lbl42:
        // 1 sources

        if (psDEFValueRuleCondGroup.getChildPSDEFValueRuleConds(true).size() == 0) {
            return null;
        }
        if (psDEFValueRuleCondGroup.getChildPSDEFValueRuleConds(true).size() == 1) {
            return psDEFValueRuleCondGroup.getChildPSDEFValueRuleConds(true).get(0);
        }
        return psDEFValueRuleCondGroup;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u811a\u672c\u4ee3\u7801", ignoredumpvalues="false")
    public boolean isCustomCode() {
        return this.bCustomCode;
    }

    @Override
    @PSModelRTMeta(description="\u811a\u672c\u4ee3\u7801", fields={"CUSTOMCODE"})
    public String getScriptCode() {
        if (this.isCustomCode()) {
            return this.psDEFValueRule.getCUSTOMCODE();
        }
        return null;
    }

    protected String getPSDEFormId() {
        return this.psDEFValueRule.getPSDEFORMID();
    }

    protected String getPSDEFormName() {
        return this.psDEFValueRule.getPSDEFORMNAME();
    }

    @Override
    @PSModelRTMeta(description="\u89c4\u5219\u4fe1\u606f\u8bed\u8a00\u8d44\u6e90\u6807\u8bb0")
    public String getRuleInfoLanResTag() {
        if (this.getRuleInfoPSLanguageRes() == null) {
            return null;
        }
        return this.getRuleInfoPSLanguageRes().getLanResTag();
    }

    @Override
    @PSModelRTMeta(description="\u89c4\u5219\u4fe1\u606f\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61")
    public IPSLanguageRes getRuleInfoPSLanguageRes() {
        return this.ruleInfoPSLanguageRes;
    }
}

