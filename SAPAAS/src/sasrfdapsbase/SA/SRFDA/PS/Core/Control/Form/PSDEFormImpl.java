/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.control.form.IFormItem
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicGroupDetail;
import SA.SRFDA.PS.Core.App.Res.IPSAppDEFInputTipSet;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Form.IPSDEForm;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDRUIPart;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormFormPart;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItemUpdate;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItemVR;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormLogic;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormMDCtrl;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormPage;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormParam;
import SA.SRFDA.PS.Core.Control.Form.IPSFormDetailType;
import SA.SRFDA.PS.Core.Control.Form.PSDEFormItemUpdateImpl;
import SA.SRFDA.PS.Core.Control.Form.PSDEFormItemVRImpl;
import SA.SRFDA.PS.Core.Control.Form.PSDEFormLogicImpl;
import SA.SRFDA.PS.Core.Control.Form.PSDEFormParamImpl;
import SA.SRFDA.PS.Core.Control.IPSAjaxControlParam;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.IPSThickness;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayout;
import SA.SRFDA.PS.Core.Control.Layout.PSLayoutFactory;
import SA.SRFDA.PS.Core.Control.PSAjaxControlContainerImpl;
import SA.SRFDA.PS.Core.Control.PSThicknessImpl;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSDEFDLogic;
import SA.SRFDA.PS.Data.PSDEFIUDetail;
import SA.SRFDA.PS.Data.PSDEFIUpdate;
import SA.SRFDA.PS.Data.PSDEForm;
import SA.SRFDA.PS.Data.PSDEFormDetail;
import SA.SRFDA.PS.Data.PSDEFormItemVR;
import SA.SRFDA.PS.Data.PSDEFormLogic;
import SA.SRFDA.PS.Data.PSDEFormRF;
import SA.SRFDA.PS.Data.PSLayout;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import net.ibizsys.paas.control.form.IFormItem;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFormImpl
extends PSAjaxControlContainerImpl
implements IPSDEForm {
    private static final Log log = LogFactory.getLog(PSDEFormImpl.class);
    protected PSDEForm psDEForm;
    protected ArrayList<IPSDEFormPage> psDEFormPageList = new ArrayList();
    protected ArrayList<IPSDEFormItem> psDEFormItemList = new ArrayList();
    protected ArrayList<IPSDEFormDetail> psDEFormDetailList = new ArrayList();
    protected Map<String, IPSDEFormItem> psDEFormItemMap = new LinkedHashMap<String, IPSDEFormItem>();
    protected ArrayList<IPSDEFormDRUIPart> psDEFormDRUIPartList = new ArrayList();
    protected Map<String, IPSDEFormItemUpdate> psDEFormItemUpdateMap = new LinkedHashMap<String, IPSDEFormItemUpdate>();
    protected Map<String, IPSDEFormItemVR> psDEFormItemVRMap = new LinkedHashMap<String, IPSDEFormItemVR>();
    protected ArrayList<IPSDEFormMDCtrl> psDEFormMDCtrlList = null;
    protected ArrayList<IPSDEFormFormPart> psDEFormFormPartList = null;
    protected Vector<PSDEFormRF> psDEFormRFList = new Vector();
    protected ArrayList<IFormItem> formItemList = new ArrayList();
    private Map<String, PSDEFormDetail> formPartDetailMap = new LinkedHashMap<String, PSDEFormDetail>();
    protected double fFormWidth = 1.0;
    protected PSDEFormParamImpl psDEFormParamImpl = null;
    private String strCodeName = "";
    protected IPSThickness defaultGroupPadding = PSThicknessImpl.getEmpty();
    protected IPSThickness defaultGroupPadding2 = PSThicknessImpl.getEmpty();
    protected IPSThickness defaultGroupMargin = PSThicknessImpl.getEmpty();
    protected IPSThickness defaultGroupMargin2 = new PSThicknessImpl(8);
    protected String strLayoutMode = "";
    private int nColumnCount = 0;
    protected int nLabelColSpan = 1;
    protected int nCtrlColSpan = 2;
    private int nFirstLabelColSpan = 2;
    private String strFormFuncMode = "";
    protected int nLabelWidth = 130;
    private Boolean bShowTabHeader = null;
    private String strFormStyle = "";
    private Map<String, Object> hookPSDEFormItemMap = null;
    private IPSLayout iPSLayout = null;
    private String strDefaultDetailStyle = "";
    private String strDefaultFormItemStyle = "";
    private String strTabHeaderPos = "TOP";
    private boolean bInvalidId = false;
    private boolean bMobileControl = false;
    protected List<PSDEFormLogicImpl> psDEFormLogicList = new ArrayList<PSDEFormLogicImpl>();
    private IPSAppDEFInputTipSet iPSAppDEFInputTipSet = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSControlContainer(iPSControlContainer);
            IPSDEFormParam iPSDEFormParam = (IPSDEFormParam)iPSControlParam;
            this.psDEForm = new PSDEForm();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSDEFormParam.getPSDEFormId())) {
                CallResult callResult = this.getPSModelHelper().getPSDEForm(iPSDEFormParam.getPSDEFormId(), this.psDEForm);
                if (callResult.isError()) {
                    throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u8868\u5355\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                this.setId(this.psDEForm.getPSDEFORMID());
            } else {
                this.setId(SA.SRFramework.Utility.StringHelper.Format((String)"%1$s_%2$s", (Object)this.getPSAppView().getId(), (Object)strName));
                this.bInvalidId = true;
            }
            this.setName(strName);
            this.setLogicName(this.psDEForm.getPSDEFORMNAME());
            this.setPSObjectData(this.psDEForm);
            if (this.getPSDataEntity() != null) {
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEForm.getPSDEID()) && SA.SRFramework.Utility.StringHelper.Compare((String)this.psDEForm.getPSDEID(), (String)this.getPSDataEntity().getId(), (boolean)true) != 0) {
                    this.setPSDataEntity(this.getPSAppView().getPSSystem().getPSDataEntity2(this.psDEForm.getPSDEID()));
                }
            } else if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEForm.getPSDEID())) {
                this.setPSDataEntity(this.getPSAppView().getPSSystem().getPSDataEntity2(this.psDEForm.getPSDEID()));
            }
            if (this.getId().indexOf("SRFTEMPKEY:") == 0) {
                this.setDesignMode(true);
                this.setPreviewPSPF(this.calcPreviewPSPF());
            }
            this.psDEFormParamImpl = this.createPSDEFormParamImpl();
            this.psDEFormParamImpl.setPSAjaxControlHandlerId(this.psDEForm.getPSACHANDLERID());
            this.psDEFormParamImpl.setPSCtrlMsgId(this.psDEForm.getPSCTRLMSGID());
            this.psDEFormParamImpl.setPSSysPFPluginId(this.psDEForm.getPSSYSPFPLUGINID());
            this.psDEFormParamImpl.setPSDEUILogicGroupId(this.psDEForm.getPSCTRLLOGICGROUPID());
            this.psDEFormParamImpl.setPSSysCssId(this.psDEForm.getPSSYSCSSID());
            this.psDEFormParamImpl.merge(iPSControlParam);
            if (!this.psDEForm.isFORMWIDTHNull()) {
                this.fFormWidth = this.psDEForm.getFORMWIDTH();
            } else if (this.getPSAppView() != null && this.getPSAppView().getPSPFStyle().getPFEngineVer() >= 20) {
                this.fFormWidth = 0.0;
            }
            this.strCodeName = this.psDEForm.getCODENAME();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.getName();
            }
            if (!(SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName) || this.getPSSystem() != null && this.getPSSystem().getPSSystemSetting().isFixCodeNameAutoCapitalize())) {
                String strHeader = this.strCodeName.substring(0, 1).toUpperCase();
                this.strCodeName = String.valueOf(strHeader) + this.strCodeName.substring(1);
            }
            this.strFormFuncMode = this.psDEForm.getFUNCMODE();
            this.bMobileControl = this.psDEForm.getMOBFLAG();
            if (!this.psDEForm.isSHOWTABHEADERNull()) {
                this.bShowTabHeader = this.psDEForm.getSHOWTABHEADER();
            }
            this.strFormStyle = this.psDEForm.getFORMSTYLE();
            this.strDefaultDetailStyle = this.psDEForm.getDETAILSTYLE();
            this.strDefaultFormItemStyle = this.psDEForm.getFORMITEMSTYLE();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strDefaultFormItemStyle)) {
                this.strDefaultFormItemStyle = this.strDefaultDetailStyle;
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEForm.getTABHEADERPOS())) {
                this.strTabHeaderPos = this.psDEForm.getTABHEADERPOS();
            }
            super.init(iDAGlobalHelper, iPSControlContainer, strName, this.psDEFormParamImpl);
        }
        catch (Exception ex) {
            this.throwCriticalInitException(ex);
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    protected PSDEFormParamImpl createPSDEFormParamImpl() {
        return new PSDEFormParamImpl();
    }

    @Override
    protected void onInit() throws Exception {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEForm.getPSDEFINPUTTIPSETID())) {
            this.iPSAppDEFInputTipSet = this.getPSApplication().getPSAppDEFInputTipSet(this.psDEForm.getPSDEFINPUTTIPSETID());
        }
        super.onInit();
        this.onPreparePSDEFormLayout();
        if (!this.bInvalidId) {
            this.onPreparePSDEFormRFs();
            this.onPreparePSDEFormItemUpdates();
            this.onPreparePSDEFormDetails();
            this.onPreparePSDEFormItems();
            this.onPreparePSDEFormDRUIParts();
            this.onPreparePSDEFormItemVRs();
            this.onPreparePSDEFormLogics();
        }
        this.formItemList.clear();
        this.formItemList.addAll(this.psDEFormItemList);
        this.onPrepareAllPSDEFormDetails();
        Iterator<IPSDEFormDetail> psDEFormDetails = this.getAllPSDEFormDetails();
        if (psDEFormDetails != null) {
            while (psDEFormDetails.hasNext()) {
                IPSDEFormDetail iPSDEFormDetail = psDEFormDetails.next();
                if (iPSDEFormDetail instanceof IPSDEFormMDCtrl) {
                    if (this.psDEFormMDCtrlList == null) {
                        this.psDEFormMDCtrlList = new ArrayList();
                    }
                    this.psDEFormMDCtrlList.add((IPSDEFormMDCtrl)iPSDEFormDetail);
                    continue;
                }
                if (!(iPSDEFormDetail instanceof IPSDEFormFormPart)) continue;
                if (this.psDEFormFormPartList == null) {
                    this.psDEFormFormPartList = new ArrayList();
                }
                this.psDEFormFormPartList.add((IPSDEFormFormPart)iPSDEFormDetail);
            }
        }
        for (IPSDEFormPage iPSDEFormPage : this.psDEFormPageList) {
            iPSDEFormPage.layout();
        }
    }

    protected void onPreparePSDEFormLayout() throws Exception {
        this.strLayoutMode = this.psDEForm.getLAYOUTMODE();
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strLayoutMode)) {
            if (this.isDesignMode()) {
                this.strLayoutMode = this.getPreviewPSPF().getFormLayoutMode();
            } else {
                String strPFType = this.getPFType();
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strPFType)) {
                    strPFType = this.getPSAppView().getPSApplication().getPFType();
                }
                IPSPF iPSPF = this.getPSModelStorage().getPSPF(strPFType);
                this.strLayoutMode = iPSPF.getFormLayoutMode();
            }
        }
        if (this.psDEForm.getLABELCOLSPAN() > 0) {
            this.nLabelColSpan = this.psDEForm.getLABELCOLSPAN();
            if (this.getPSAppView().getPSApplication().getPSApplicationUI().isEnableCol12ToCol24()) {
                this.nLabelColSpan *= 2;
            }
        }
        if (this.psDEForm.getCTRLCOLSPAN() > 0) {
            this.nCtrlColSpan = this.psDEForm.getCTRLCOLSPAN();
            if (this.getPSAppView().getPSApplication().getPSApplicationUI().isEnableCol12ToCol24()) {
                this.nCtrlColSpan *= 2;
            }
        }
        if (this.psDEForm.getLABELCOLSPAN2() > 0) {
            this.nFirstLabelColSpan = this.psDEForm.getLABELCOLSPAN2();
            if (this.getPSAppView().getPSApplication().getPSApplicationUI().isEnableCol12ToCol24()) {
                this.nFirstLabelColSpan *= 2;
            }
        }
        if (!this.psDEForm.isLABELWIDTHNull() && this.psDEForm.getLABELWIDTH() >= 0) {
            this.nLabelWidth = this.psDEForm.getLABELWIDTH();
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strLayoutMode)) {
            PSLayout psLayout = new PSLayout();
            this.iPSLayout = PSLayoutFactory.createPSLayout(this, this.strLayoutMode, psLayout);
        }
    }

    protected void onPreparePSDEFormDetails() throws Exception {
        this.psDEFormPageList.clear();
        this.formPartDetailMap.clear();
        for (PSDEFormRF psDEFormRF : this.psDEFormRFList) {
            this.onPreparePSDEFormDetails(psDEFormRF.getMINORPSDEFORMID(), false);
        }
        this.onPreparePSDEFormDetails(this.getId(), true);
    }

    protected void onPreparePSDEFormDetails(String strPSDEFormId, boolean bMajor) throws Exception {
        Vector<PSDEFormDetail> psDEFormPageList = new Vector<PSDEFormDetail>();
        CallResult callResult = this.getPSModelHelper().getPSDEFormDetails(strPSDEFormId, psDEFormPageList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u8868\u5355\u6210\u5458\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, PSDEFormDetail> psDEFormDetailMap = new HashMap<String, PSDEFormDetail>();
        for (PSDEFormDetail psDEFormDetail : psDEFormPageList) {
            psDEFormDetailMap.put(psDEFormDetail.getPSDEFORMDETAILID(), psDEFormDetail);
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strPSDEFormId, (String)this.getId(), (boolean)true) == 0) continue;
            this.formPartDetailMap.put(psDEFormDetail.getPSDEFORMDETAILID(), psDEFormDetail);
        }
        for (PSDEFormDetail psDEFormDetail : psDEFormPageList) {
            PSDEForm psDEForm;
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEFormDetail.getPPSDEFORMDETAILID())) continue;
            PSDEFormDetail psDEFormDetail2 = psDEFormDetail;
            Object parentPSDEFormDetail = (PSDEFormDetail)((Object)psDEFormDetailMap.get(psDEFormDetail.getPPSDEFORMDETAILID()));
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
                        if (this.getPSSystemUtil() != null) {
                            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
                            String strLogInfo = null;
                            if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getId(), (String)strPSDEFormId, (boolean)false) == 0) {
                                strLogInfo = SA.SRFramework.Utility.StringHelper.Format((String)"\u5c06\u8868\u5355[%1$s]\u5f15\u7528\u6210\u5458[%2$s]\u7c7b\u578b\u4fee\u6539\u4e3a[\u5206\u7ec4\u9762\u677f]", (Object)this.getLogicName(), (Object)psDEFormDetail2.getPSDEFORMDETAILNAME());
                            } else {
                                PSDEForm psDEForm2 = new PSDEForm();
                                this.getPSModelHelper().getPSDEForm(psDEFormDetail2.getPSDEFORMID(), psDEForm2);
                                strLogInfo = SA.SRFramework.Utility.StringHelper.Format((String)"\u5c06\u8868\u5355[%1$s]\u5f15\u7528\u6210\u5458[%2$s]\u7c7b\u578b\u4fee\u6539\u4e3a[\u5206\u7ec4\u9762\u677f]", (Object)psDEForm2.getPSDEFORMNAME(), (Object)psDEFormDetail2.getPSDEFORMDETAILNAME());
                            }
                            this.getPSSystemUtil().getPSSysConsole().warn(strLogName, strLogInfo);
                        }
                    }
                }
            }
            if (psDEFormDetail == null) {
                if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getId(), (String)strPSDEFormId, (boolean)false) == 0) {
                    throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u8868\u5355[%1$s]\u6210\u5458[%2$s]\u5f15\u7528\u8868\u5355\u65e0\u6548", (Object)this.getLogicName(), (Object)psDEFormDetail2.getPSDEFORMDETAILNAME()));
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
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEFDLogic.getPPSDEFDLOGICID())) continue;
            PSDEFDLogic parentPSDEFDLogic = (PSDEFDLogic)((Object)psDEFDLogicMap.get(psDEFDLogic.getPPSDEFDLOGICID()));
            if (parentPSDEFDLogic != null) {
                parentPSDEFDLogic.getChildPSDEFDLogics(true).add(psDEFDLogic);
                continue;
            }
            this.getPSSystemUtil().getPSSysConsole().warn(this.getLogName(), SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u7236\u8868\u5355\u6210\u5458\u903b\u8f91[%1$s]\uff0c\u5ffd\u7565\u6b64\u6a21\u578b", (Object)psDEFDLogic.getPPSDEFDLOGICID()), "PSDEFDLOGIC", "REMOVE", psDEFDLogic.getPSDEFDLOGICID());
        }
        for (PSDEFDLogic psDEFDLogic : psDEFDLogicList) {
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEFDLogic.getPPSDEFDLOGICID())) continue;
            PSDEFormDetail psDEFormDetail = (PSDEFormDetail)((Object)psDEFormDetailMap.get(psDEFDLogic.getPSDEFORMDETAILID()));
            if (psDEFormDetail != null) {
                psDEFormDetail.getChildPSDEFDLogics(psDEFDLogic.getLOGICCAT(), true).add(psDEFDLogic);
                continue;
            }
            this.getPSSystemUtil().getPSSysConsole().warn(this.getLogName(), SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u8868\u5355\u6210\u5458[%1$s]\uff0c\u5ffd\u7565\u6b64\u6a21\u578b", (Object)psDEFDLogic.getPPSDEFDLOGICID()), "PSDEFDLOGIC", "REMOVE", psDEFDLogic.getPSDEFDLOGICID());
        }
        if (SA.SRFramework.Utility.StringHelper.Compare((String)strPSDEFormId, (String)this.getId(), (boolean)true) == 0) {
            int nIndex = 0;
            for (PSDEFormDetail psDEFormDetail : psDEFormPageList) {
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEFormDetail.getPPSDEFORMDETAILID()) || SA.SRFramework.Utility.StringHelper.Compare((String)psDEFormDetail.getDETAILTYPE(), (String)"FORMPAGE", (boolean)true) != 0) continue;
                psDEFormDetail.set("PAGEINDEX", nIndex);
                IPSFormDetailType iPSFormDetailType = this.getPSModelStorage().getPSFormDetailType(psDEFormDetail.getDETAILTYPE());
                IPSDEFormDetail iPSDEFormDetail = iPSFormDetailType.createPSDEFormDetail(psDEFormDetail);
                iPSDEFormDetail.init(this.getDAGlobalHelper(), this, null, psDEFormDetail);
                this.psDEFormPageList.add((IPSDEFormPage)iPSDEFormDetail);
                ++nIndex;
            }
            for (PSDEFormDetail psDEFormDetail : psDEFormPageList) {
                psDEFormDetail.resetChildDatas();
            }
        }
    }

    protected void onPrepareAllPSDEFormDetails() throws Exception {
        ArrayList<IPSDEFormDetail> tempList = new ArrayList<IPSDEFormDetail>();
        for (IPSDEFormDetail iPSDEFormDetail : this.psDEFormDetailList) {
            if (iPSDEFormDetail instanceof IPSDEFormItem) continue;
            tempList.add(iPSDEFormDetail);
        }
        this.psDEFormDetailList.clear();
        this.psDEFormDetailList.addAll(tempList);
        this.psDEFormDetailList.addAll(this.psDEFormItemList);
    }

    protected void onPreparePSDEFormItems() throws Exception {
        this.psDEFormItemList.clear();
        this.psDEFormItemMap.clear();
        this.psDEFormDetailList.clear();
        for (IPSDEFormPage iPSDEFormPage : this.psDEFormPageList) {
            iPSDEFormPage.fillPSDEFormItems(this.psDEFormItemList);
        }
        for (IPSDEFormPage iPSDEFormPage : this.psDEFormPageList) {
            iPSDEFormPage.fillPSDEFormDetails(this.psDEFormDetailList);
        }
        HashMap<String, IPSDEFormItem> psDEFFormItemMap = new HashMap<String, IPSDEFormItem>();
        for (IPSDEFormItem iPSDEFormItem : this.psDEFormItemList) {
            psDEFFormItemMap.put(iPSDEFormItem.getCodeName(), iPSDEFormItem);
        }
        HashMap<String, String> createItemMap = new HashMap<String, String>();
        for (IPSDEFormItem iPSDEFormItem : this.psDEFormItemList) {
            String[] valueItemNames = iPSDEFormItem.getValueItemNames();
            if (valueItemNames == null) continue;
            String[] stringArray = valueItemNames;
            int n = valueItemNames.length;
            int n2 = 0;
            while (n2 < n) {
                String strValueItemName = stringArray[n2];
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strValueItemName) && !psDEFFormItemMap.containsKey(strValueItemName.toLowerCase())) {
                    createItemMap.put(strValueItemName, "");
                }
                ++n2;
            }
        }
        this.fillExtPSDEFormItems(psDEFFormItemMap, createItemMap);
        for (String strItemName : createItemMap.keySet()) {
            PSDEFormDetail psDEFormDetail = new PSDEFormDetail();
            psDEFormDetail.setPSDEID(this.getPSDataEntity().getId());
            psDEFormDetail.setFORMTYPE(this.getControlType());
            psDEFormDetail.setPSDEFORMDETAILID(strItemName);
            psDEFormDetail.setPSDEFORMDETAILNAME(strItemName);
            psDEFormDetail.setEDITORTYPE("HIDDEN");
            psDEFormDetail.setDETAILTYPE("FORMITEM");
            IPSDEField iPSDEField = this.getPSDataEntity().getPSDEField(strItemName, true);
            if (iPSDEField != null) {
                psDEFormDetail.setPSDEFID(iPSDEField.getId());
                psDEFormDetail.setPSDEFNAME(iPSDEField.getName());
            }
            if (this.isEnableUIModelEx() && this.psDEFormPageList.size() > 0) {
                IPSDEFormPage iPSDEFormPage = this.psDEFormPageList.get(0);
                IPSDEFormDetail iPSDEFormDetail = iPSDEFormPage.addPSDEFormDetail(psDEFormDetail);
                this.psDEFormItemList.add((IPSDEFormItem)iPSDEFormDetail);
                continue;
            }
            IPSFormDetailType iPSFormDetailType = this.getPSModelStorage().getPSFormDetailType(psDEFormDetail.getDETAILTYPE());
            IPSDEFormDetail iPSDEFormDetail = iPSFormDetailType.createPSDEFormDetail(psDEFormDetail);
            iPSDEFormDetail.init(this.getDAGlobalHelper(), this, null, psDEFormDetail);
            this.psDEFormItemList.add((IPSDEFormItem)iPSDEFormDetail);
        }
        for (IPSDEFormItem iPSDEFormItem : this.psDEFormItemList) {
            this.psDEFormItemMap.put(iPSDEFormItem.getId(), iPSDEFormItem);
            this.psDEFormItemMap.put(iPSDEFormItem.getCodeName(), iPSDEFormItem);
        }
    }

    protected void onPreparePSDEFormDRUIParts() throws Exception {
        this.psDEFormDRUIPartList.clear();
        for (IPSDEFormPage iPSDEFormPage : this.psDEFormPageList) {
            iPSDEFormPage.fillPSDEFormDRUIParts(this.psDEFormDRUIPartList);
        }
    }

    protected void onPreparePSDEFormRFs() throws Exception {
        this.psDEFormRFList.clear();
        CallResult callResult = this.getPSModelHelper().getPSDEFormRFs(this.getId(), this.psDEFormRFList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u8868\u5355\u5f15\u7528\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
    }

    protected void onPreparePSDEFormItemUpdates() throws Exception {
        this.psDEFormItemUpdateMap.clear();
        this.onPreparePSDEFormItemUpdates(this.getId());
        for (PSDEFormRF psDEFormRF : this.psDEFormRFList) {
            this.onPreparePSDEFormItemUpdates(psDEFormRF.getMINORPSDEFORMID());
        }
    }

    protected void onPreparePSDEFormItemUpdates(String strPSDEFormId) throws Exception {
        Vector<PSDEFIUpdate> psDEFIUpdateList = new Vector<PSDEFIUpdate>();
        CallResult callResult = this.getPSModelHelper().getPSDEFIUpdates(strPSDEFormId, psDEFIUpdateList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u8868\u5355\u9879\u66f4\u65b0\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, PSDEFIUpdate> psDEFIUpdateMap = new HashMap<String, PSDEFIUpdate>();
        for (PSDEFIUpdate psDEFIUpdate : psDEFIUpdateList) {
            psDEFIUpdateMap.put(psDEFIUpdate.getPSDEFIUPDATEID(), psDEFIUpdate);
        }
        Vector<PSDEFIUDetail> psDEFIUDetailList = new Vector<PSDEFIUDetail>();
        callResult = this.getPSModelHelper().getPSDEFIUDetails(strPSDEFormId, psDEFIUDetailList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u8868\u5355\u9879\u66f4\u65b0\u6210\u5458\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEFIUDetail psDEFIUDetail : psDEFIUDetailList) {
            PSDEFIUpdate psDEFIUpdate = (PSDEFIUpdate)((Object)psDEFIUpdateMap.get(psDEFIUDetail.getPSDEFIUPDATEID()));
            if (psDEFIUpdate != null) {
                psDEFIUpdate.getPSDEFIUDetails(true).add(psDEFIUDetail);
                continue;
            }
            this.getPSSystemUtil().getPSSysConsole().warn(this.getLogName(), SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u8868\u5355\u9879\u66f4\u65b0[%1$s]\uff0c\u5ffd\u7565\u6b64\u6a21\u578b", (Object)psDEFIUDetail.getPSDEFIUPDATEID()), "PSDEFIUDETAIL", "REMOVE", psDEFIUDetail.getPSDEFIUDETAILID());
        }
        for (PSDEFIUpdate psDEFIUpdate : psDEFIUpdateList) {
            PSDEFormItemUpdateImpl psDEFIUpdateImpl = new PSDEFormItemUpdateImpl();
            psDEFIUpdateImpl.init(this.getDAGlobalHelper(), this, psDEFIUpdate);
            this.psDEFormItemUpdateMap.put(psDEFIUpdateImpl.getId(), psDEFIUpdateImpl);
        }
    }

    protected void onPreparePSDEFormItemVRs() throws Exception {
        this.psDEFormItemVRMap.clear();
        this.onPreparePSDEFormItemVRs(this.getId());
    }

    protected void onPreparePSDEFormItemVRs(String strPSDEFormId) throws Exception {
        Vector<PSDEFormItemVR> psDEFormItemVRList = new Vector<PSDEFormItemVR>();
        CallResult callResult = this.getPSModelHelper().getPSDEFormItemVRs(strPSDEFormId, psDEFormItemVRList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u8868\u5355\u9879\u503c\u89c4\u5219\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEFormItemVR psDEFormItemVR : psDEFormItemVRList) {
            PSDEFormItemVRImpl psDEFormItemVRImpl = new PSDEFormItemVRImpl();
            psDEFormItemVRImpl.init(this.getDAGlobalHelper(), this, psDEFormItemVR);
            this.psDEFormItemVRMap.put(psDEFormItemVRImpl.getId(), psDEFormItemVRImpl);
        }
    }

    protected void onPreparePSDEFormLogics() throws Exception {
        this.psDEFormLogicList.clear();
        this.onPreparePSDEFormLogics(this.getId());
    }

    protected void onPreparePSDEFormLogics(String strPSDEFormId) throws Exception {
        Vector<PSDEFormLogic> psDEFormLogicList = new Vector<PSDEFormLogic>();
        CallResult callResult = this.getPSModelHelper().getPSDEFormLogics(strPSDEFormId, psDEFormLogicList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u8868\u5355\u903b\u8f91\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEFormLogic psDEFormLogic : psDEFormLogicList) {
            PSDEFormLogicImpl psDEFormLogicImpl = new PSDEFormLogicImpl();
            psDEFormLogicImpl.init(this.getDAGlobalHelper(), this, psDEFormLogic);
            this.psDEFormLogicList.add(psDEFormLogicImpl);
        }
    }

    protected void fillExtPSDEFormItems(HashMap<String, IPSDEFormItem> psDEFFormItemMap, HashMap<String, String> createItemMap) throws Exception {
    }

    protected boolean isInvalidId() {
        return this.bInvalidId;
    }

    @Override
    @PSModelRTMeta(description="\u8868\u5355\u5206\u9875\u96c6\u5408", child=true, outputdoc="false")
    public Iterator<IPSDEFormPage> getPSDEFormPages() {
        return this.psDEFormPageList.iterator();
    }

    public Iterator<IFormItem> getFormItems() {
        return this.formItemList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u8868\u5355\u9879\u96c6\u5408", child=true, dumpref=true, modelreftype="SIMPLE", group="\u90e8\u4ef6\u5143\u7d20", order=160, ignorert=3)
    public Iterator<IPSDEFormItem> getPSDEFormItems() {
        return this.psDEFormItemList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u6807\u7b7e\u5bbd\u5ea6", ignorepf=true, fields={"LABELWIDTH"}, ignoresetvalues="*")
    public int getDefaultLabelWidth() {
        return this.nLabelWidth;
    }

    @Override
    @PSModelRTMeta(description="\u9690\u85cf\u5206\u9875\u5934\u90e8", fields={"SHOWTABHEADER"})
    public boolean isNoTabHeader() {
        if (this.bShowTabHeader == null) {
            return this.psDEFormPageList.size() == 1;
        }
        return this.bShowTabHeader == false;
    }

    @Override
    @PSModelRTMeta(description="\u8868\u5355\u5bbd\u5ea6", ignoredumpvalues="0.0", fields={"FORMWIDTH"}, ignoresetvalues="0.0")
    public double getFormWidth() {
        return this.fFormWidth;
    }

    @Override
    public IPSAjaxControlParam getPSAjaxControlParam() {
        return this.psDEFormParamImpl;
    }

    public IFormItem getFormItem(String strName, boolean bTryMode) throws Exception {
        return this.getPSDEFormItem(strName, bTryMode);
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        super.fillRelatedPSAppViews(relatedAppViewList);
        for (IPSDEFormPage iPSDEFormPage : this.psDEFormPageList) {
            iPSDEFormPage.fillRelatedPSAppViews(relatedAppViewList);
        }
    }

    @Override
    @PSModelRTMeta(description="\u8868\u5355\u5173\u7cfb\u90e8\u4ef6\u96c6\u5408", group="\u90e8\u4ef6\u5143\u7d20", order=165)
    public Iterator<IPSDEFormDRUIPart> getPSDEFormDRUIParts() {
        if (this.psDEFormDRUIPartList == null || this.psDEFormDRUIPartList.size() == 0) {
            return null;
        }
        return this.psDEFormDRUIPartList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    @Override
    protected String onGetCodeName() {
        return this.getPSApplication().getViewCodeName(null, this.strCodeName, null);
    }

    @Override
    public IPSThickness getDefaultGroupMargin(boolean bShowCaption) {
        return bShowCaption ? this.defaultGroupMargin2 : this.defaultGroupMargin;
    }

    @Override
    public IPSThickness getDefaultGroupPadding(boolean bShowCaption) {
        return bShowCaption ? this.defaultGroupPadding2 : this.defaultGroupPadding;
    }

    @Override
    @PSModelRTMeta(description="\u8868\u5355\u9879\u66f4\u65b0\u96c6\u5408", child=true, group="\u90e8\u4ef6\u903b\u8f91", order=210)
    public Iterator<IPSDEFormItemUpdate> getPSDEFormItemUpdates() {
        return this.psDEFormItemUpdateMap.values().iterator();
    }

    @Override
    public IPSDEFormItemUpdate getPSDEFormItemUpdate(String strPSDEFormItemUpdateId) throws Exception {
        IPSDEFormItemUpdate iPSDEFormItemUpdate = this.psDEFormItemUpdateMap.get(strPSDEFormItemUpdateId);
        if (strPSDEFormItemUpdateId == null) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u8868\u5355\u9879\u66f4\u65b0[%1$s]", (Object)strPSDEFormItemUpdateId));
        }
        return iPSDEFormItemUpdate;
    }

    @Override
    public String getModelScope() {
        return "DE";
    }

    @Override
    public String getPFType() {
        return this.psDEForm.getPSPFID();
    }

    @Override
    @PSModelRTMeta(description="\u884c\u9996\u6807\u9898\u9ed8\u8ba4\u5217\u6570", dump=false)
    public int getFirstLabelColSpan() {
        return this.nFirstLabelColSpan;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u9ed8\u8ba4\u5217\u6570", dump=false)
    public int getLabelColSpan() {
        return this.nLabelColSpan;
    }

    @Override
    @PSModelRTMeta(description="\u63a7\u4ef6\u9ed8\u8ba4\u5217\u6570", dump=false)
    public int getCtrlColSpan() {
        return this.nCtrlColSpan;
    }

    @Override
    @PSModelRTMeta(description="\u5e03\u5c40\u6a21\u5f0f", codelist="FormDetailLayoutMode", dump=false)
    public String getLayoutMode() {
        return this.strLayoutMode;
    }

    @Override
    public void fillEmbeddedPSAppViewRefs(String strContainerId, ArrayList<IPSAppViewRef> embeddedPSAppViewRefList) throws Exception {
        super.fillEmbeddedPSAppViewRefs(strContainerId, embeddedPSAppViewRefList);
        for (IPSDEFormPage iPSDEFormPage : this.psDEFormPageList) {
            iPSDEFormPage.fillEmbeddedPSAppViewRefs(strContainerId, embeddedPSAppViewRefList);
        }
    }

    @Override
    public void fillRelatedPSCodeLists(ArrayList<IPSCodeList> relatedPSCodeListList) throws Exception {
        for (IPSDEFormItem iPSDEFormItem : this.psDEFormItemList) {
            if (iPSDEFormItem.getPSCodeList() == null) continue;
            relatedPSCodeListList.add(iPSDEFormItem.getPSCodeList());
        }
    }

    @Override
    @PSModelRTMeta(description="\u8868\u5355\u529f\u80fd\u6a21\u5f0f", hideempty2=true, fields={"FUNCMODE"}, codelist="FormFuncMode")
    public String getFormFuncMode() {
        return this.strFormFuncMode;
    }

    @Override
    @PSModelRTMeta(description="\u8868\u5355\u9879\u503c\u89c4\u5219\u96c6\u5408", child=true, group="\u90e8\u4ef6\u903b\u8f91", order=215)
    public Iterator<IPSDEFormItemVR> getPSDEFormItemVRs() {
        return this.psDEFormItemVRMap.values().iterator();
    }

    @Override
    public IPSDEFormItemVR getPSDEFormItemVR(String strPSDEFormItemVRId) throws Exception {
        IPSDEFormItemVR iPSDEFormItemVR = this.psDEFormItemVRMap.get(strPSDEFormItemVRId);
        if (strPSDEFormItemVRId == null) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u8868\u5355\u9879\u503c\u89c4\u5219[%1$s]", (Object)strPSDEFormItemVRId));
        }
        return iPSDEFormItemVR;
    }

    @Override
    public IPSDEFormItem getPSDEFormItem(String strPSDEFormItemId) throws Exception {
        return this.getPSDEFormItem(strPSDEFormItemId, false);
    }

    @Override
    public IPSDEFormItem getPSDEFormItem(String strPSDEFormItemId, boolean bTryMode) throws Exception {
        IPSDEFormItem iPSDEFormItem = this.psDEFormItemMap.get(strPSDEFormItemId);
        if (strPSDEFormItemId == null && !bTryMode) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u8868\u5355\u9879[%1$s]", (Object)strPSDEFormItemId));
        }
        return iPSDEFormItem;
    }

    @Override
    public Iterator<IPSDEFormDetail> getPSDEFormDetails() {
        return this.psDEFormDetailList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u8868\u5355\u6837\u5f0f", fields={"FORMSTYLE"})
    public String getFormStyle() {
        return this.strFormStyle;
    }

    @Override
    @PSModelRTMeta(description="\u8868\u5355\u5206\u9875\u6570\u91cf", dump=false, outputdoc="false")
    public int getPSDEFormPageCount() {
        return this.psDEFormPageList.size();
    }

    @Override
    public IPSDEFormPage getPSDEFormPage(int nIndex) throws Exception {
        if (nIndex < 0 || nIndex > this.getPSDEFormPageCount()) {
            throw new Exception("\u8868\u5355\u5206\u9875\u5e8f\u53f7\u65e0\u6548");
        }
        return this.psDEFormPageList.get(nIndex);
    }

    @Override
    public String getModelType() {
        return "PSDEFORM";
    }

    @Override
    public void hookPSDEFormItem(String strPSDEFDName, Object hookObj) throws Exception {
        if (this.hookPSDEFormItemMap == null) {
            this.hookPSDEFormItemMap = new LinkedHashMap<String, Object>();
        }
        this.hookPSDEFormItemMap.put(strPSDEFDName.toLowerCase(), hookObj);
    }

    @Override
    public boolean isHookPSDEFormItem(String strPSDEFDName) {
        if (this.hookPSDEFormItemMap == null) {
            return false;
        }
        return this.hookPSDEFormItemMap.containsKey(strPSDEFDName.toLowerCase());
    }

    @Override
    @PSModelRTMeta(description="\u76d1\u63a7\u8868\u5355\u6210\u5458\u96c6\u5408", outputdoc="false")
    public Iterator<String> getHookPSDEFormItems() {
        if (this.hookPSDEFormItemMap == null || this.hookPSDEFormItemMap.size() == 0) {
            return null;
        }
        return this.hookPSDEFormItemMap.keySet().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u8868\u5355\u5e03\u5c40\u5bf9\u8c61", child=true)
    public IPSLayout getPSLayout() {
        return this.iPSLayout;
    }

    @Override
    public String getDefaultDetailStyle() {
        return this.strDefaultDetailStyle;
    }

    @Override
    public String getDefaultFormItemStyle() {
        return this.strDefaultFormItemStyle;
    }

    @Override
    @PSModelRTMeta(description="\u5168\u90e8\u8868\u5355\u6210\u5458\u96c6\u5408", outputdoc="false")
    public Iterator<IPSDEFormDetail> getAllPSDEFormDetails() {
        return this.getPSDEFormDetails();
    }

    @Override
    public IPSDEFormDetail getPSDEFormDetail(String strPSDEFormDetailName) throws Exception {
        return this.getPSDEFormDetail(strPSDEFormDetailName, false);
    }

    @Override
    public IPSDEFormDetail getPSDEFormDetail(String strPSDEFormDetailName, boolean bTryMode) throws Exception {
        if (this.psDEFormDetailList != null) {
            for (IPSDEFormDetail iPSDEFormDetail : this.psDEFormDetailList) {
                if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEFormDetail.getName(), (String)strPSDEFormDetailName, (boolean)true) != 0) continue;
                return iPSDEFormDetail;
            }
        }
        if (!bTryMode) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u8868\u5355\u6210\u5458[%1$s]", (Object)strPSDEFormDetailName));
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u8868\u5355\u591a\u6570\u636e\u90e8\u4ef6\u96c6\u5408", outputdoc="false")
    public Iterator<IPSDEFormMDCtrl> getPSDEFormMDCtrls() {
        if (this.psDEFormMDCtrlList == null || this.psDEFormMDCtrlList.size() == 0) {
            return null;
        }
        return this.psDEFormMDCtrlList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u8868\u5355\u8868\u5355\u90e8\u4ef6\u96c6\u5408", outputdoc="false")
    public Iterator<IPSDEFormFormPart> getPSDEFormFormParts() {
        if (this.psDEFormFormPartList == null || this.psDEFormFormPartList.size() == 0) {
            return null;
        }
        return this.psDEFormFormPartList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u8868\u5355\u5206\u9875\u5934\u90e8\u4f4d\u7f6e", codelist="FormTabHeaderPos", fields={"TABHEADERPOS"})
    public String getTabHeaderPos() {
        return this.strTabHeaderPos;
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u52a8\u7aef\u90e8\u4ef6", ignoredumpvalues="false", fields={"MOBFLAG"})
    public boolean isMobileControl() {
        return this.bMobileControl;
    }

    @Override
    @PSModelRTMeta(description="\u8868\u683c\u903b\u8f91\u96c6\u5408", group="\u90e8\u4ef6\u903b\u8f91", order=217)
    public Iterator<? extends IPSDEFormLogic> getPSDEFormLogics() {
        if (this.psDEFormLogicList == null || this.psDEFormLogicList.size() == 0) {
            return null;
        }
        return this.psDEFormLogicList.iterator();
    }

    @Override
    protected Iterator<? extends IPSAppDEUILogicGroupDetail> getPSAppDEUILogicGroupDetails() {
        if (this.psDEFormLogicList == null || this.psDEFormLogicList.size() == 0) {
            return null;
        }
        return this.psDEFormLogicList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u8868\u5355\u9879\u8fc7\u6ee4\u5668", ignoredumpvalues="false", fields={"ENABLEITEMFILTER"})
    public boolean isEnableItemFilter() {
        return this.psDEForm.getENABLEITEMFILTER();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027\u8f93\u5165\u63d0\u793a\u96c6\u5408", dumpref=true, fields={"PSDEFINPUTTIPSETID"})
    public IPSAppDEFInputTipSet getPSAppDEFInputTipSet() {
        return this.iPSAppDEFInputTipSet;
    }
}

