/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.CodeList.CodeItemConfig
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.CommonEx.Errors
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.IPSModelInitDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSModelDEDataCtrl;
import SA.SRFDA.PS.Data.PSCodeItem;
import SA.SRFDA.PS.Data.PSCodeList;
import SA.SRFDA.PS.Data.PSCodeListTempl;
import SA.SRFDA.PS.Data.PSDEField;
import SA.SRFDA.PS.Data.PSDEToolbar;
import SA.SRFDA.PS.Data.PSDEUIAction;
import SA.SRFDA.PS.Data.PSDataEntity;
import SA.SRFDA.PS.Data.PSImageTempl;
import SA.SRFDA.PS.Data.PSSysImage;
import SA.SRFDA.PS.Data.PSSysToolbar;
import SA.SRFDA.PS.Data.PSSysUIAction;
import SA.SRFDA.PS.Data.PSSysValueRule;
import SA.SRFDA.PS.Data.PSSystem;
import SA.SRFDA.PS.Data.PSValueRule;
import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.CommonEx.Errors;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSystemDataCtrl
extends PSModelDEDataCtrl {
    public static final String CUSTOMCALL_PUBLISHRTMODEL = "PUBLISHRTMODEL";
    public static final String CUSTOMCALL_CALCCODELISTREF = "CALCCODELISTREF";
    public static final String CUSTOMCALL_INITDEDBCFG = "INITDEDBCFG";
    private static final Log log = LogFactory.getLog(PSSystemDataCtrl.class);

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        return callResult;
    }

    @Override
    protected void onReloadModel(BaseDataEntity dataEntity) throws Exception {
        String strPSSystemId = dataEntity.getParamStringValue("PSSYSTEMID", "");
        this.getPSModelStorage().resetPSSystem(strPSSystemId);
        this.getPSModelHelper().startLoadPSSystem(strPSSystemId, IPSSystem.LOADLEVEL_CODE);
        try {
            IPSSystem ipsSystem = this.getPSModelStorage().getPSSystem(strPSSystemId);
            ipsSystem.load(IPSSystem.LOADLEVEL_CODE);
            this.getPSModelHelper().stopLoadPSSystem();
        }
        catch (Exception ex) {
            this.getPSModelHelper().stopLoadPSSystem();
            throw ex;
        }
    }

    @Override
    public CallResult initModel(BaseDataEntity dataEntity) {
        CallResult callResult = super.initModel(dataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSSystem psSystem = new PSSystem();
            psSystem.proxy(dataEntity);
            this.onInitModel(psSystem);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u7cfb\u7edf\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onInitModel(PSSystem psSystem) throws Exception {
        this.initPSCodeListTempl(psSystem);
        this.initPSSysImages(psSystem);
        this.initPSSysValueRules(psSystem);
        this.initPSDEUIActions(psSystem);
        this.initPSDEToolbars(psSystem);
        this.initPSDEUIActions(psSystem);
    }

    protected void initPSDEUIActions(PSSystem psSystem) throws Exception {
        IDEDataCtrl psSysUIActionDataCtrl = this.GetRelatedDataCtrl("DE1508");
        IDEDataCtrl psDEUIActionDataCtrl = this.GetRelatedDataCtrl("DE2080");
        BaseDataEntity cond = new BaseDataEntity();
        Vector<PSSysUIAction> psSysUIActionList = new Vector<PSSysUIAction>();
        CallResult callResult = psSysUIActionDataCtrl.Select(cond, psSysUIActionList, PSSysUIAction.class.getName());
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u4e91\u5e73\u53f0\u9884\u7f6e\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysUIAction psSysUIAction : psSysUIActionList) {
            PSDEUIAction psDEUIAction = new PSDEUIAction();
            psDEUIAction.setPSDEUIACTIONID(Helper.GenUniqueId((String)psSystem.getPSSYSTEMID(), (String)psSysUIAction.getPSSYSUIACTIONID()));
            callResult = psDEUIActionDataCtrl.Get((BaseDataEntity)psDEUIAction);
            if (Errors.IsSpecialError((int)callResult.getRetCode(), (int)3)) {
                psDEUIAction.setPSSYSTEMID(psSystem.getPSSYSTEMID());
                psDEUIAction.setUIACTIONTYPE("SYS");
                psDEUIAction.setPSSYSUIACTIONID(psSysUIAction.getPSSYSUIACTIONID());
                psDEUIAction.setPSSYSUIACTIONNAME(psSysUIAction.getPSSYSUIACTIONNAME());
                psDEUIAction.setPSDEUIACTIONNAME(psSysUIAction.getPSSYSUIACTIONNAME());
                psDEUIAction.setMEMO(psSysUIAction.getMEMO());
                psDEUIAction.setCODENAME(psSysUIAction.getCODENAME());
                psDEUIAction.setCAPTION(psSysUIAction.getCAPTION());
                psDEUIAction.setTEMPLMODE(true);
                psDEUIAction.setACTIONTARGET(psSysUIAction.getACTIONTARGET());
                if (!StringHelper.IsNullOrEmpty((String)psSysUIAction.getPSIMAGETEMPLID())) {
                    String strPSSysImageId = Helper.GenUniqueId((String)psSystem.getPSSYSTEMID(), (String)psSysUIAction.getPSIMAGETEMPLID());
                    psDEUIAction.setPSSYSIMAGEID(strPSSysImageId);
                }
                if (!(callResult = psDEUIActionDataCtrl.Save(true, (BaseDataEntity)psDEUIAction)).isError()) continue;
                throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u7cfb\u7edf\u5168\u5c40\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            boolean bUpdate = false;
            if (!StringHelper.IsNullOrEmpty((String)psSysUIAction.getPSIMAGETEMPLID()) && StringHelper.IsNullOrEmpty((String)psDEUIAction.getPSSYSIMAGEID())) {
                String strPSSysImageId = Helper.GenUniqueId((String)psSystem.getPSSYSTEMID(), (String)psSysUIAction.getPSIMAGETEMPLID());
                psDEUIAction.setPSSYSIMAGEID(strPSSysImageId);
                bUpdate = true;
            }
            if (!bUpdate || !(callResult = psDEUIActionDataCtrl.Save(false, (BaseDataEntity)psDEUIAction)).isError()) continue;
            throw new Exception(StringHelper.Format((String)"\u66f4\u65b0\u7cfb\u7edf\u5168\u5c40\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    protected void initPSSysValueRules(PSSystem psSystem) throws Exception {
        IDEDataCtrl psValueRuleDataCtrl = this.GetRelatedDataCtrl("DE1543");
        IDEDataCtrl psSysValueRuleDataCtrl = this.GetRelatedDataCtrl("DE2034");
        BaseDataEntity cond = new BaseDataEntity();
        Vector<PSValueRule> psValueRuleList = new Vector<PSValueRule>();
        CallResult callResult = psValueRuleDataCtrl.Select(cond, psValueRuleList, PSValueRule.class.getName());
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u4e91\u5e73\u53f0\u9884\u7f6e\u503c\u89c4\u5219\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSValueRule psValueRule : psValueRuleList) {
            PSSysValueRule psSysValueRule = new PSSysValueRule();
            psSysValueRule.setPSSYSVALUERULEID(Helper.GenUniqueId((String)psSystem.getPSSYSTEMID(), (String)psValueRule.getPSVALUERULEID()));
            callResult = psSysValueRuleDataCtrl.Get((BaseDataEntity)psSysValueRule);
            if (!Errors.IsSpecialError((int)callResult.getRetCode(), (int)3)) continue;
            psValueRule.CopyTo(psSysValueRule, false);
            psSysValueRule.setPSSYSVALUERULEID(Helper.GenUniqueId((String)psSystem.getPSSYSTEMID(), (String)psValueRule.getPSVALUERULEID()));
            psSysValueRule.setPSSYSVALUERULENAME(psValueRule.getPSVALUERULENAME());
            psSysValueRule.setPSSYSTEMID(psSystem.getPSSYSTEMID());
            psSysValueRule.setPSSYSTEMNAME(psSystem.getPSSYSTEMNAME());
            callResult = psSysValueRuleDataCtrl.Save(true, (BaseDataEntity)psSysValueRule);
            if (!callResult.isError()) continue;
            throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u7cfb\u7edf\u5168\u5c40\u503c\u89c4\u5219\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    protected void initPSSysImages(PSSystem psSystem) throws Exception {
        IDEDataCtrl psImageTemplDataCtrl = this.GetRelatedDataCtrl("DE1531");
        IDEDataCtrl psSysImageDataCtrl = this.GetRelatedDataCtrl("DE2120");
        BaseDataEntity cond = new BaseDataEntity();
        Vector<PSImageTempl> psImageTemplList = new Vector<PSImageTempl>();
        CallResult callResult = psImageTemplDataCtrl.Select(cond, psImageTemplList, PSImageTempl.class.getName());
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u4e91\u5e73\u53f0\u56fe\u7247\u8d44\u6e90\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        cond.Reset();
        cond.setParamValue("PSSYSTEMID", (Object)psSystem.getPSSYSTEMID());
        Vector<PSSysImage> psSysImageList = new Vector<PSSysImage>();
        callResult = psSysImageDataCtrl.Select(cond, psSysImageList, PSSysImage.class.getName());
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u56fe\u7247\u8d44\u6e90\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, PSSysImage> psSysImageMap = new HashMap<String, PSSysImage>();
        for (PSSysImage psSysImage : psSysImageList) {
            psSysImageMap.put(psSysImage.getPSSYSIMAGEID(), psSysImage);
        }
        for (PSImageTempl psImageTempl : psImageTemplList) {
            PSSysImage psSysImage = new PSSysImage();
            psSysImage.setPSSYSIMAGEID(Helper.GenUniqueId((String)psSystem.getPSSYSTEMID(), (String)psImageTempl.getPSIMAGETEMPLID()));
            if (psSysImageMap.containsKey(psSysImage.getPSSYSIMAGEID())) continue;
            psImageTempl.CopyTo(psSysImage, false);
            psSysImage.setPSSYSIMAGEID(Helper.GenUniqueId((String)psSystem.getPSSYSTEMID(), (String)psImageTempl.getPSIMAGETEMPLID()));
            psSysImage.setPSSYSIMAGENAME(psImageTempl.getPSIMAGETEMPLNAME());
            psSysImage.setPSSYSTEMID(psSystem.getPSSYSTEMID());
            psSysImage.setPSSYSTEMNAME(psSystem.getPSSYSTEMNAME());
            callResult = psSysImageDataCtrl.Save(true, (BaseDataEntity)psSysImage);
            if (!callResult.isError()) continue;
            throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u7cfb\u7edf\u5168\u5c40\u56fe\u7247\u8d44\u6e90\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    protected void initPSDEToolbars(PSSystem psSystem) throws Exception {
        IDEDataCtrl psSysToolbarDataCtrl = this.GetRelatedDataCtrl("DE1620");
        IDEDataCtrl psDEToolbarDataCtrl = this.GetRelatedDataCtrl("DE2206");
        BaseDataEntity cond = new BaseDataEntity();
        Vector<PSSysToolbar> psSysToolbarList = new Vector<PSSysToolbar>();
        CallResult callResult = psSysToolbarDataCtrl.Select(cond, psSysToolbarList, PSSysToolbar.class.getName());
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u4e91\u5e73\u53f0\u9884\u7f6e\u5de5\u5177\u680f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysToolbar psSysToolbar : psSysToolbarList) {
            PSDEToolbar psDEToolbar = new PSDEToolbar();
            psDEToolbar.setPSDETOOLBARID(Helper.GenUniqueId((String)psSystem.getPSSYSTEMID(), (String)psSysToolbar.getPSSYSTOOLBARID()));
            callResult = psDEToolbarDataCtrl.Get((BaseDataEntity)psDEToolbar);
            if (!Errors.IsSpecialError((int)callResult.getRetCode(), (int)3)) continue;
            psDEToolbar.setPSSYSTEMID(psSystem.getPSSYSTEMID());
            psDEToolbar.setPSSYSTOOLBARID(psSysToolbar.getPSSYSTOOLBARID());
            psDEToolbar.setPSSYSTOOLBARNAME(psSysToolbar.getPSSYSTOOLBARNAME());
            psDEToolbar.setPSDETOOLBARNAME(psSysToolbar.getPSSYSTOOLBARNAME());
            psDEToolbar.setMEMO(psSysToolbar.getMEMO());
            psDEToolbar.setTEMPLTOOLBAR(true);
            callResult = psDEToolbarDataCtrl.Save(true, (BaseDataEntity)psDEToolbar);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u7cfb\u7edf\u5168\u5c40\u5de5\u5177\u680f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            callResult = psDEToolbarDataCtrl.CustomCall("INITFROMSYSTOOLBAR", (BaseDataEntity)psDEToolbar);
            if (!callResult.isError()) continue;
            throw new Exception(StringHelper.Format((String)"\u521d\u59cb\u5316\u7cfb\u7edf\u5168\u5c40\u5de5\u5177\u680f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    public CallResult initPSCodeListTempl(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSSystem psSystem = new PSSystem();
            psSystem.proxy(dataEntity);
            this.onInitPSCodeListTempl(psSystem);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u4e91\u5e73\u53f0\u4ee3\u7801\u8868\u6a21\u7248\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onInitPSCodeListTempl(PSSystem psSystem) throws Exception {
        String strPSSystemId = psSystem.getPSSYSTEMID();
        IDEDataCtrl psCodeListTemplDataCtrl = this.GetRelatedDataCtrl("DE1530");
        IDEDataCtrl psCodeListDataCtrl = this.GetRelatedDataCtrl("DE2040");
        BaseDataEntity cond = new BaseDataEntity();
        Vector<PSCodeListTempl> psCodeListTemplList = new Vector<PSCodeListTempl>();
        CallResult callResult = psCodeListTemplDataCtrl.Select(cond, psCodeListTemplList, PSCodeListTempl.class.getName());
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u4e91\u5e73\u53f0\u4ee3\u7801\u8868\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSCodeListTempl psCodeListTempl : psCodeListTemplList) {
            PSCodeList psCodeList = new PSCodeList();
            psCodeList.setPSCODELISTID(Helper.GenUniqueId((String)strPSSystemId, (String)psCodeListTempl.getPSCODELISTTEMPLID()));
            callResult = psCodeListDataCtrl.Get((BaseDataEntity)psCodeList);
            if (!Errors.IsSpecialError((int)callResult.getRetCode(), (int)3)) continue;
            psCodeListTempl.CopyTo(psCodeList, false);
            psCodeList.setPSCODELISTNAME(psCodeListTempl.getPSCODELISTTEMPLNAME());
            psCodeList.setPSSYSTEMID(strPSSystemId);
            psCodeList.setCLTYPE("STATIC");
            psCodeList.setCODELISTSN(psCodeListTempl.getPSCODELISTTEMPLID());
            psCodeList.setPSCODELISTTEMPLID(psCodeListTempl.getPSCODELISTTEMPLID());
            psCodeList.setUSERSCOPE(false);
            psCodeList.setCODENAME(psCodeListTempl.getCODENAME());
            callResult = psCodeListDataCtrl.Save(true, (BaseDataEntity)psCodeList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u7cfb\u7edf\u4ee3\u7801\u8868\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            this.onInitPSCodeList(psCodeList);
        }
    }

    protected void onInitPSCodeList(PSCodeList psCodeList) throws Exception {
        CodeListConfig codeListConfig = this.getGlobalHelper().getCodeListMgr().GetCodeListConfig(psCodeList.getPSCODELISTTEMPLID());
        if (codeListConfig.getCodeItems() == null || codeListConfig.getCodeItems().size() == 0) {
            return;
        }
        IDEDataCtrl psCodeItemDataCtrl = this.GetRelatedDataCtrl("DE2041");
        BaseDataEntity cond = new BaseDataEntity();
        cond.setParamValue("PSCODELISTID", (Object)psCodeList.getPSCODELISTID());
        Vector psCodeItemList = new Vector();
        CallResult callResult = psCodeItemDataCtrl.Select(cond, psCodeItemList, PSCodeItem.class.getName());
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u4ee3\u7801\u8868\u4ee3\u7801\u9879\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (psCodeItemList.size() > 0) {
            return;
        }
        int i = 0;
        while (i < codeListConfig.getCodeItems().size()) {
            CodeItemConfig codeItemConfig = (CodeItemConfig)codeListConfig.getCodeItems().get(i);
            this.onInitPSCodeItem(psCodeList, null, codeItemConfig, i);
            ++i;
        }
    }

    protected void onInitPSCodeItem(PSCodeList psCodeList, PSCodeItem parentPSCodeItem, CodeItemConfig codeItemConfig, int nIndex) throws Exception {
        CallResult callResult;
        IDEDataCtrl psCodeItemDataCtrl = this.GetRelatedDataCtrl("DE2041");
        PSCodeItem psCodeItem = new PSCodeItem();
        psCodeItem.setPSCODELISTID(psCodeList.getPSCODELISTID());
        psCodeItem.setCODEITEMVALUE(codeItemConfig.getValue());
        psCodeItem.setPSCODEITEMNAME(codeItemConfig.getText());
        psCodeItem.setORDERVALUE(nIndex);
        if (parentPSCodeItem != null) {
            psCodeItem.setPPSCODEITEMID(parentPSCodeItem.getPSCODEITEMID());
        }
        if ((callResult = psCodeItemDataCtrl.Save(true, (BaseDataEntity)psCodeItem)).isError()) {
            throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u7cfb\u7edf\u4ee3\u7801\u8868\u4ee3\u7801\u9879\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (codeItemConfig.getCodeItems() == null || codeItemConfig.getCodeItems().size() == 0) {
            return;
        }
        int i = 0;
        while (i < codeItemConfig.getCodeItems().size()) {
            CodeItemConfig childCodeItemConfig = (CodeItemConfig)codeItemConfig.getCodeItems().get(i);
            this.onInitPSCodeItem(psCodeList, psCodeItem, childCodeItemConfig, i);
            ++i;
        }
    }

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_CALCCODELISTREF, (boolean)true) == 0) {
            return this.calcCodeListRef(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_INITDEDBCFG, (boolean)true) == 0) {
            return this.initDEDBCfg(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult calcCodeListRef(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSSystem psSystem = new PSSystem();
            psSystem.proxy(dataEntity);
            this.onCalcCodeListRef(psSystem);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5237\u65b0\u4ee3\u7801\u8868\u5f15\u7528\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onCalcCodeListRef(PSSystem psSystem) throws Exception {
        String strPSSystemId = psSystem.getPSSYSTEMID();
    }

    public CallResult initDEDBCfg(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            PSSystem psSystem = new PSSystem();
            psSystem.proxy(dataEntity);
            this.onInitDEDBCfg(psSystem);
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().CommitAndBegin();
            }
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u5b9e\u4f53\u6570\u636e\u5e93\u914d\u7f6e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onInitDEDBCfg(PSSystem psSystem) throws Exception {
        String strPSSystemId = psSystem.getPSSYSTEMID();
        IDEDataCtrl psDataEntityDataCtrl = this.GetRelatedDataCtrl("DE2050");
        IDEDataCtrl psDEFieldDataCtrl = this.GetRelatedDataCtrl("DE2051");
        IPSModelInitDataCtrl psDEDBCfgDataCtrl = (IPSModelInitDataCtrl)this.GetRelatedDataCtrl("DE2055");
        IPSModelInitDataCtrl psDEFDTColDataCtrl = (IPSModelInitDataCtrl)this.GetRelatedDataCtrl("DE2060");
        BaseDataEntity cond = new BaseDataEntity();
        cond.setParamValue("PSSYSTEMID", (Object)strPSSystemId);
        Vector<PSDataEntity> psDataEntityList = new Vector<PSDataEntity>();
        CallResult callResult = psDataEntityDataCtrl.Select(cond, psDataEntityList, PSDataEntity.class.getName());
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5b9e\u4f53\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        Vector<PSDEField> psDEFieldList = new Vector<PSDEField>();
        callResult = psDEFieldDataCtrl.Select(cond, psDEFieldList, PSDEField.class.getName());
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5b9e\u4f53\u5c5e\u6027\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDataEntity psDataEntity : psDataEntityList) {
            callResult = psDEDBCfgDataCtrl.initModel("DE2050", psDataEntity, "");
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u521d\u59cb\u5316\u5b9e\u4f53\u6570\u636e\u5e93\u914d\u7f6e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            if (this.getTransactionManager() == null) continue;
            this.getTransactionManager().CommitAndBegin();
        }
        for (PSDEField psDEField : psDEFieldList) {
            callResult = psDEFDTColDataCtrl.initModel("DE2051", psDEField, "");
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u521d\u59cb\u5316\u5b9e\u4f53\u5c5e\u6027\u6570\u636e\u5e93\u914d\u7f6e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            if (this.getTransactionManager() == null) continue;
            this.getTransactionManager().CommitAndBegin();
        }
    }
}
