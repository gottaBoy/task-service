/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.App.Control.IPSAppCounter;
import SA.SRFDA.PS.Core.App.Control.IPSAppCounterRef;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxControlHandler;
import SA.SRFDA.PS.Core.Control.Ajax.PSAjaxControlHandlerActionImpl;
import SA.SRFDA.PS.Core.Control.Ajax.PSAjaxControlHandlerImpl;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounterRef;
import SA.SRFDA.PS.Core.Control.Form.IPSDEEditForm;
import SA.SRFDA.PS.Core.Control.Form.IPSDEEditFormParam;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Control.Form.IPSDEWizardEditForm;
import SA.SRFDA.PS.Core.Control.Form.IPSFormDetailType;
import SA.SRFDA.PS.Core.Control.Form.IPSWFEditForm;
import SA.SRFDA.PS.Core.Control.Form.PSDEEditFormParamImpl;
import SA.SRFDA.PS.Core.Control.Form.PSDEFormImpl;
import SA.SRFDA.PS.Core.Control.Form.PSDEFormParamImpl;
import SA.SRFDA.PS.Core.Control.IPSControlAction;
import SA.SRFDA.PS.Core.Control.IPSControlNavContext;
import SA.SRFDA.PS.Core.Control.IPSControlNavParam;
import SA.SRFDA.PS.Core.Control.PSControlNavContextImpl;
import SA.SRFDA.PS.Core.Control.PSControlNavParamImpl;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEWizardForm;
import SA.SRFDA.PS.Core.IPSSystemRuntime;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Data.PSACHandler;
import SA.SRFDA.PS.Data.PSACHandlerAction;
import SA.SRFDA.PS.Data.PSDEFormDetail;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSControl", typevalues={"FORM"})
public class PSDEEditFormImpl
extends PSDEFormImpl
implements IPSDEEditForm,
IPSDEWizardEditForm,
IPSWFEditForm {
    private static final Log log = LogFactory.getLog(PSDEEditFormImpl.class);
    public static final String PFSTYLEPARAM_EDITFORM_LABLEWIDTH = "EDITFORM.LABLEWIDTH";
    protected PSDEEditFormParamImpl psDEEditFormParamImpl = null;
    private IPSDEWizardForm iPSDEWizardForm = null;
    private boolean bShowFormNavBar = false;
    private boolean bInfoFormMode = false;
    private boolean bInfoFormConvertPickerToLink = false;
    private boolean bInfoFormReadOnlyMode = false;
    protected boolean bEnableAutoSave = false;
    protected int nAutoSaveMode = 0;
    private List<IPSAppDEField> psAppDEFieldList = null;
    private Map<String, IPSControlNavContext> psControlNavContextMap = null;
    private Map<String, IPSControlNavParam> psControlNavParamMap = null;
    private IPSSysCounterRef iPSSysCounterRef = null;
    private boolean bEnableCounter = true;
    private boolean bEnableCustomized = false;
    private IPSSysCss iNavBarPSSysCss = null;

    @Override
    protected void onInit() throws Exception {
        if (!this.isInvalidId() && StringHelper.compare((String)this.psDEForm.getFORMTYPE(), (String)"EDITFORM", (boolean)true) != 0 && StringHelper.compare((String)this.psDEForm.getFORMTYPE(), (String)"FORM", (boolean)true) != 0) {
            throw new Exception(String.format("\u8868\u5355\u7c7b\u578b[%1$s]\u4e0d\u6b63\u786e", this.psDEForm.getFORMTYPE()));
        }
        if (!this.psDEForm.isINFOFORMFLAGNull()) {
            this.bInfoFormMode = this.psDEForm.getINFOFORMFLAG() >= 1;
            this.bInfoFormConvertPickerToLink = this.psDEForm.getINFOFORMFLAG() == 3;
            this.bInfoFormReadOnlyMode = this.psDEForm.getINFOFORMFLAG() == 5;
        } else if (!StringHelper.isNullOrEmpty((String)this.getFormStyle()) && this.getFormStyle().indexOf("INFOPANEL") != -1) {
            this.bInfoFormMode = true;
        }
        boolean bl = this.bEnableAutoSave = this.psDEForm.getENABLEAUTOSAVE() > 0;
        if (this.psDEEditFormParamImpl.isEnableAutoSave() != null) {
            this.bEnableAutoSave = this.psDEEditFormParamImpl.isEnableAutoSave();
        }
        if (this.bEnableAutoSave) {
            this.nAutoSaveMode = this.psDEForm.getENABLEAUTOSAVE();
            if (this.nAutoSaveMode <= 0) {
                this.nAutoSaveMode = 1;
            }
        }
        if (!this.psDEForm.isENABLECUSTOMIZEDNull()) {
            this.bEnableCustomized = this.psDEForm.getENABLECUSTOMIZED();
        }
        if (!this.isDesignMode() && StringHelper.compare((String)this.getFormFuncMode(), (String)"WIZARDFORM", (boolean)true) == 0) {
            this.iPSDEWizardForm = this.psDEEditFormParamImpl.getPSDEWizardForm();
            if (this.iPSDEWizardForm == null) {
                throw new Exception("\u5411\u5bfc\u8868\u5355\u53ea\u80fd\u5728\u5411\u5bfc\u4e2d\u4f7f\u7528");
            }
        }
        super.onInit();
        if (this.isEnableCounter()) {
            this.setPSSysCounterRef(this.preparePSSysCounterRef());
        }
        if (this.isShowFormNavBar() && !StringHelper.isNullOrEmpty((String)this.psDEForm.getNAVBARPSSYSCSSID())) {
            this.iNavBarPSSysCss = this.getPSAppView().getPSApplication().getPSSystem().getPSSysCss(this.psDEForm.getNAVBARPSSYSCSSID());
        }
        this.onPreparePSControlNavParams();
    }

    protected void onPreparePSControlNavParams() throws Exception {
        Iterator<String> names;
        if (this.getPSControlParam() != null && (names = this.getPSControlParam().getCtrlParamNames()) != null) {
            while (names.hasNext()) {
                boolean bRawValue;
                String strKey = names.next();
                String strValue = this.getPSControlParam().getCtrlParam(strKey, "");
                String strTag = strKey.toUpperCase();
                if (strTag.indexOf("SRFNAVCTX.") == 0) {
                    bRawValue = true;
                    strTag = strKey.substring("SRFNAVCTX.".length()).toUpperCase();
                    if (!StringHelper.isNullOrEmpty((String)strValue) && strValue.charAt(0) == '%' && strValue.charAt(strValue.length() - 1) == '%') {
                        strValue = strValue.replace("%", "");
                        bRawValue = false;
                    }
                    PSControlNavContextImpl psControlNavContextImpl = new PSControlNavContextImpl();
                    psControlNavContextImpl.init(this.getDAGlobalHelper(), this, strTag, strValue, null, bRawValue);
                    if (this.psControlNavContextMap == null) {
                        this.psControlNavContextMap = new LinkedHashMap<String, IPSControlNavContext>();
                    }
                    this.psControlNavContextMap.put(strTag, psControlNavContextImpl);
                    continue;
                }
                if (strTag.indexOf("SRFNAVPARAM.") != 0) continue;
                bRawValue = true;
                strTag = strKey.substring("SRFNAVPARAM.".length()).toLowerCase();
                if (!StringHelper.isNullOrEmpty((String)strValue) && strValue.charAt(0) == '%' && strValue.charAt(strValue.length() - 1) == '%') {
                    strValue = strValue.replace("%", "");
                    bRawValue = false;
                }
                PSControlNavParamImpl psControlNavParamImpl = new PSControlNavParamImpl();
                psControlNavParamImpl.init(this.getDAGlobalHelper(), this, strTag, strValue, null, bRawValue);
                if (this.psControlNavParamMap == null) {
                    this.psControlNavParamMap = new LinkedHashMap<String, IPSControlNavParam>();
                }
                this.psControlNavParamMap.put(strTag, psControlNavParamImpl);
            }
        }
    }

    protected IPSSysCounterRef preparePSSysCounterRef() throws Exception {
        IPSDEEditFormParam iPSDEEditFormParam;
        String strPSSysCounterId;
        if (this.getPSControlParam() instanceof IPSDEEditFormParam && !StringHelper.isNullOrEmpty((String)(strPSSysCounterId = (iPSDEEditFormParam = (IPSDEEditFormParam)this.getPSControlParam()).getPSSysCounterId()))) {
            IPSAppCounter iPSSysCounter = this.getPSAppView().getPSApplication().getPSAppCounter(strPSSysCounterId, false);
            JSONObject refModeObj = new JSONObject();
            if (this.isPrepareDefaultPSAppViewLogics()) {
                return this.registerPSAppCounter(iPSSysCounter, refModeObj);
            }
            return this.getPSAppView().registerPSSysCounter(iPSSysCounter, refModeObj);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u8ba1\u6570\u5668\u5f15\u7528", hideempty=true)
    public IPSSysCounterRef getPSSysCounterRef() {
        return this.iPSSysCounterRef;
    }

    protected void setPSSysCounterRef(IPSSysCounterRef iPSSysCounterRef) {
        this.iPSSysCounterRef = iPSSysCounterRef;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u8ba1\u6570\u5668\u5f15\u7528", hideempty=true, dumpref=true, from="__self__", fields={"PSSYSCOUNTERID"})
    public IPSAppCounterRef getPSAppCounterRef() {
        if (this.getPSSysCounterRef() != null && this.getPSSysCounterRef() instanceof IPSAppCounterRef) {
            return (IPSAppCounterRef)this.getPSSysCounterRef();
        }
        return null;
    }

    @Override
    protected String onGetControlType() {
        return "FORM";
    }

    @Override
    protected void onPreparePSDEFormLayout() throws Exception {
        this.nLabelWidth = this.getPSAppView().getPSApplication().getPFStyleParam(PFSTYLEPARAM_EDITFORM_LABLEWIDTH, this.nLabelWidth);
        if (!this.psDEForm.isFORMNAVBARNull()) {
            this.bShowFormNavBar = this.psDEForm.getFORMNAVBAR();
        }
        super.onPreparePSDEFormLayout();
    }

    @Override
    protected PSDEFormParamImpl createPSDEFormParamImpl() {
        this.psDEEditFormParamImpl = new PSDEEditFormParamImpl();
        this.psDEEditFormParamImpl.setPSSysCounterId(this.psDEForm.getPSSYSCOUNTERID());
        return this.psDEEditFormParamImpl;
    }

    @Override
    protected void onPreparePSDEFormItems() throws Exception {
        String strFormItemName;
        IPSDEField iPSDEField;
        IPSSystemRuntime iPSSystemRuntime;
        IPSDEField updateDataPSDEField;
        IPSDEFormDetail iPSDEFormDetail;
        IPSFormDetailType iPSFormDetailType;
        PSDEFormDetail psDEFormDetail;
        super.onPreparePSDEFormItems();
        ArrayList<IPSDEFormItem> privPSDEFormItemList = new ArrayList<IPSDEFormItem>();
        for (IPSDEFormItem iPSDEFormItem : this.psDEFormItemList) {
            if (StringHelper.isNullOrEmpty((String)iPSDEFormItem.getPrivFieldName())) continue;
            PSDEFormDetail psDEFormDetail2 = new PSDEFormDetail();
            psDEFormDetail2.setPSDEID(this.getPSDataEntity().getId());
            psDEFormDetail2.setFORMTYPE(this.getControlType());
            psDEFormDetail2.setPSDEFORMDETAILID(StringHelper.format((String)"%1$s%2$s", (Object)"srfip_", (Object)iPSDEFormItem.getPrivFieldName().toLowerCase()));
            psDEFormDetail2.setPSDEFORMDETAILNAME(StringHelper.format((String)"%1$s%2$s", (Object)"srfip_", (Object)iPSDEFormItem.getPrivFieldName().toLowerCase()));
            psDEFormDetail2.setEDITORTYPE("HIDDEN");
            psDEFormDetail2.setDETAILTYPE("FORMITEM");
            IPSFormDetailType iPSFormDetailType2 = this.getPSModelStorage().getPSFormDetailType(psDEFormDetail2.getDETAILTYPE());
            IPSDEFormDetail iPSDEFormDetail2 = iPSFormDetailType2.createPSDEFormDetail(psDEFormDetail2);
            iPSDEFormDetail2.init(this.getDAGlobalHelper(), this, null, psDEFormDetail2);
            privPSDEFormItemList.add(0, (IPSDEFormItem)iPSDEFormDetail2);
        }
        for (IPSDEFormItem iPSDEFormItem : privPSDEFormItemList) {
            if (this.psDEFormItemMap.containsKey(iPSDEFormItem.getName())) continue;
            this.psDEFormItemList.add(0, iPSDEFormItem);
            this.psDEFormItemMap.put(iPSDEFormItem.getName(), iPSDEFormItem);
        }
        if (!this.psDEFormItemMap.containsKey("srfsourcekey")) {
            psDEFormDetail = new PSDEFormDetail();
            psDEFormDetail.setPSDEID(this.getPSDataEntity().getId());
            psDEFormDetail.setFORMTYPE(this.getControlType());
            psDEFormDetail.setPSDEFORMDETAILID("srfsourcekey");
            psDEFormDetail.setPSDEFORMDETAILNAME("srfsourcekey");
            psDEFormDetail.setEDITORTYPE("HIDDEN");
            psDEFormDetail.setDETAILTYPE("FORMITEM");
            iPSFormDetailType = this.getPSModelStorage().getPSFormDetailType(psDEFormDetail.getDETAILTYPE());
            iPSDEFormDetail = iPSFormDetailType.createPSDEFormDetail(psDEFormDetail);
            iPSDEFormDetail.init(this.getDAGlobalHelper(), this, null, psDEFormDetail);
            this.psDEFormItemList.add(0, (IPSDEFormItem)iPSDEFormDetail);
            this.psDEFormItemMap.put(iPSDEFormDetail.getName(), (IPSDEFormItem)iPSDEFormDetail);
        }
        if (!this.psDEFormItemMap.containsKey("srfdeid")) {
            psDEFormDetail = new PSDEFormDetail();
            psDEFormDetail.setPSDEID(this.getPSDataEntity().getId());
            psDEFormDetail.setFORMTYPE(this.getControlType());
            psDEFormDetail.setPSDEFORMDETAILID("srfdeid");
            psDEFormDetail.setPSDEFORMDETAILNAME("srfdeid");
            psDEFormDetail.setEDITORTYPE("HIDDEN");
            psDEFormDetail.setDETAILTYPE("FORMITEM");
            iPSFormDetailType = this.getPSModelStorage().getPSFormDetailType(psDEFormDetail.getDETAILTYPE());
            iPSDEFormDetail = iPSFormDetailType.createPSDEFormDetail(psDEFormDetail);
            iPSDEFormDetail.init(this.getDAGlobalHelper(), this, null, psDEFormDetail);
            this.psDEFormItemList.add(0, (IPSDEFormItem)iPSDEFormDetail);
            this.psDEFormItemMap.put(iPSDEFormDetail.getName(), (IPSDEFormItem)iPSDEFormDetail);
        }
        if (!this.psDEFormItemMap.containsKey("srfuf")) {
            psDEFormDetail = new PSDEFormDetail();
            psDEFormDetail.setPSDEID(this.getPSDataEntity().getId());
            psDEFormDetail.setFORMTYPE(this.getControlType());
            psDEFormDetail.setPSDEFORMDETAILID("srfuf");
            psDEFormDetail.setPSDEFORMDETAILNAME("srfuf");
            psDEFormDetail.setEDITORTYPE("HIDDEN");
            psDEFormDetail.setDETAILTYPE("FORMITEM");
            iPSFormDetailType = this.getPSModelStorage().getPSFormDetailType(psDEFormDetail.getDETAILTYPE());
            iPSDEFormDetail = iPSFormDetailType.createPSDEFormDetail(psDEFormDetail);
            iPSDEFormDetail.init(this.getDAGlobalHelper(), this, null, psDEFormDetail);
            this.psDEFormItemList.add(0, (IPSDEFormItem)iPSDEFormDetail);
            this.psDEFormItemMap.put(iPSDEFormDetail.getName(), (IPSDEFormItem)iPSDEFormDetail);
        }
        if (!this.psDEFormItemMap.containsKey("srftempmode")) {
            psDEFormDetail = new PSDEFormDetail();
            psDEFormDetail.setPSDEID(this.getPSDataEntity().getId());
            psDEFormDetail.setFORMTYPE(this.getControlType());
            psDEFormDetail.setPSDEFORMDETAILID("srftempmode");
            psDEFormDetail.setPSDEFORMDETAILNAME("srftempmode");
            psDEFormDetail.setEDITORTYPE("HIDDEN");
            psDEFormDetail.setDETAILTYPE("FORMITEM");
            iPSFormDetailType = this.getPSModelStorage().getPSFormDetailType(psDEFormDetail.getDETAILTYPE());
            iPSDEFormDetail = iPSFormDetailType.createPSDEFormDetail(psDEFormDetail);
            iPSDEFormDetail.init(this.getDAGlobalHelper(), this, null, psDEFormDetail);
            this.psDEFormItemList.add(0, (IPSDEFormItem)iPSDEFormDetail);
            this.psDEFormItemMap.put(iPSDEFormDetail.getName(), (IPSDEFormItem)iPSDEFormDetail);
        }
        if (!this.psDEFormItemMap.containsKey("srfmajortext") && this.getPSDataEntity().getMajorPSDEField() != null) {
            psDEFormDetail = new PSDEFormDetail();
            psDEFormDetail.setPSDEID(this.getPSDataEntity().getId());
            psDEFormDetail.setFORMTYPE(this.getControlType());
            psDEFormDetail.setPSDEFORMDETAILID("srfmajortext");
            psDEFormDetail.setPSDEFORMDETAILNAME("srfmajortext");
            psDEFormDetail.setEDITORTYPE("HIDDEN");
            psDEFormDetail.setPSDEFID(this.getPSDataEntity().getMajorPSDEField().getId());
            psDEFormDetail.setPSDEFNAME(this.getPSDataEntity().getMajorPSDEField().getName());
            psDEFormDetail.setDETAILTYPE("FORMITEM");
            psDEFormDetail.setALLOWEMPTY(true);
            iPSFormDetailType = this.getPSModelStorage().getPSFormDetailType(psDEFormDetail.getDETAILTYPE());
            iPSDEFormDetail = iPSFormDetailType.createPSDEFormDetail(psDEFormDetail);
            iPSDEFormDetail.init(this.getDAGlobalHelper(), this, null, psDEFormDetail);
            this.psDEFormItemList.add(0, (IPSDEFormItem)iPSDEFormDetail);
            this.psDEFormItemMap.put(iPSDEFormDetail.getName(), (IPSDEFormItem)iPSDEFormDetail);
        }
        if (!this.psDEFormItemMap.containsKey("srfkey")) {
            psDEFormDetail = new PSDEFormDetail();
            psDEFormDetail.setPSDEID(this.getPSDataEntity().getId());
            psDEFormDetail.setFORMTYPE(this.getControlType());
            psDEFormDetail.setPSDEFORMDETAILID("srfkey");
            psDEFormDetail.setPSDEFORMDETAILNAME("srfkey");
            psDEFormDetail.setEDITORTYPE("HIDDEN");
            psDEFormDetail.setPSDEFID(this.getPSDataEntity().getKeyPSDEField().getId());
            psDEFormDetail.setPSDEFNAME(this.getPSDataEntity().getKeyPSDEField().getName());
            psDEFormDetail.setDETAILTYPE("FORMITEM");
            psDEFormDetail.setALLOWEMPTY(true);
            iPSFormDetailType = this.getPSModelStorage().getPSFormDetailType(psDEFormDetail.getDETAILTYPE());
            iPSDEFormDetail = iPSFormDetailType.createPSDEFormDetail(psDEFormDetail);
            iPSDEFormDetail.init(this.getDAGlobalHelper(), this, null, psDEFormDetail);
            this.psDEFormItemList.add(0, (IPSDEFormItem)iPSDEFormDetail);
            this.psDEFormItemMap.put(iPSDEFormDetail.getName(), (IPSDEFormItem)iPSDEFormDetail);
        }
        if (!this.psDEFormItemMap.containsKey("srforikey")) {
            psDEFormDetail = new PSDEFormDetail();
            psDEFormDetail.setPSDEID(this.getPSDataEntity().getId());
            psDEFormDetail.setFORMTYPE(this.getControlType());
            psDEFormDetail.setPSDEFORMDETAILID("srforikey");
            psDEFormDetail.setPSDEFORMDETAILNAME("srforikey");
            psDEFormDetail.setEDITORTYPE("HIDDEN");
            psDEFormDetail.setDETAILTYPE("FORMITEM");
            iPSFormDetailType = this.getPSModelStorage().getPSFormDetailType(psDEFormDetail.getDETAILTYPE());
            iPSDEFormDetail = iPSFormDetailType.createPSDEFormDetail(psDEFormDetail);
            iPSDEFormDetail.init(this.getDAGlobalHelper(), this, null, psDEFormDetail);
            this.psDEFormItemList.add(0, (IPSDEFormItem)iPSDEFormDetail);
            this.psDEFormItemMap.put(iPSDEFormDetail.getName(), (IPSDEFormItem)iPSDEFormDetail);
        }
        if ((updateDataPSDEField = this.getPSDataEntity().getPSDEFieldByPDT("UPDATEDATE", true)) != null && !this.psDEFormItemMap.containsKey("srfupdatedate")) {
            PSDEFormDetail psDEFormDetail3 = new PSDEFormDetail();
            psDEFormDetail3.setPSDEID(this.getPSDataEntity().getId());
            psDEFormDetail3.setFORMTYPE(this.getControlType());
            psDEFormDetail3.setPSDEFORMDETAILID("srfupdatedate");
            psDEFormDetail3.setPSDEFORMDETAILNAME("srfupdatedate");
            psDEFormDetail3.setEDITORTYPE("HIDDEN");
            psDEFormDetail3.setPSDEFID(updateDataPSDEField.getId());
            psDEFormDetail3.setPSDEFNAME(updateDataPSDEField.getName());
            psDEFormDetail3.setDETAILTYPE("FORMITEM");
            psDEFormDetail3.setALLOWEMPTY(true);
            IPSFormDetailType iPSFormDetailType3 = this.getPSModelStorage().getPSFormDetailType(psDEFormDetail3.getDETAILTYPE());
            IPSDEFormDetail iPSDEFormDetail3 = iPSFormDetailType3.createPSDEFormDetail(psDEFormDetail3);
            iPSDEFormDetail3.init(this.getDAGlobalHelper(), this, null, psDEFormDetail3);
            this.psDEFormItemList.add(0, (IPSDEFormItem)iPSDEFormDetail3);
            this.psDEFormItemMap.put(iPSDEFormDetail3.getName(), (IPSDEFormItem)iPSDEFormDetail3);
        }
        if (this.getPSSystem() instanceof IPSSystemRuntime && (iPSSystemRuntime = (IPSSystemRuntime)((Object)this.getPSSystem())).getDynaInstMode() == 2 && (iPSDEField = this.getPSDataEntity().getDataTypePSDEField()) != null && iPSDEField.getPSCodeList() != null && iPSDEField.getPSCodeList().isModuleInstCodeList() && StringHelper.compare((String)iPSSystemRuntime.getDynaInstTag(), (String)iPSDEField.getPSCodeList().getDynaInstTag(), (boolean)false) == 0 && !this.psDEFormItemMap.containsKey(strFormItemName = iPSDEField.getName().toLowerCase())) {
            PSDEFormDetail psDEFormDetail4 = new PSDEFormDetail();
            psDEFormDetail4.setPSDEID(this.getPSDataEntity().getId());
            psDEFormDetail4.setFORMTYPE(this.getControlType());
            psDEFormDetail4.setPSDEFORMDETAILID(strFormItemName);
            psDEFormDetail4.setPSDEFORMDETAILNAME(strFormItemName);
            psDEFormDetail4.setEDITORTYPE("HIDDEN");
            psDEFormDetail4.setDETAILTYPE("FORMITEM");
            psDEFormDetail4.setCREATEDV(iPSSystemRuntime.getDynaInstTag2());
            psDEFormDetail4.setPSDEFID(iPSDEField.getId());
            psDEFormDetail4.setPSDEFNAME(iPSDEField.getName());
            IPSFormDetailType iPSFormDetailType4 = this.getPSModelStorage().getPSFormDetailType(psDEFormDetail4.getDETAILTYPE());
            IPSDEFormDetail iPSDEFormDetail4 = iPSFormDetailType4.createPSDEFormDetail(psDEFormDetail4);
            iPSDEFormDetail4.init(this.getDAGlobalHelper(), this, null, psDEFormDetail4);
            this.psDEFormItemList.add(0, (IPSDEFormItem)iPSDEFormDetail4);
            this.psDEFormItemMap.put(iPSDEFormDetail4.getName(), (IPSDEFormItem)iPSDEFormDetail4);
        }
    }

    @Override
    protected void fillExtPSDEFormItems(HashMap<String, IPSDEFormItem> psDEFFormItemMap, HashMap<String, String> createItemMap) throws Exception {
        super.fillExtPSDEFormItems(psDEFFormItemMap, createItemMap);
        if (!psDEFFormItemMap.containsKey(this.getPSDataEntity().getKeyDEField().getName().toLowerCase())) {
            createItemMap.put(this.getPSDataEntity().getKeyDEField().getName().toLowerCase(), "");
        }
        if (this.getPSSystemSetting().isEnableDEFieldRestrictedUI() && !this.isInfoFormMode()) {
            for (IPSDEFormItem iPSDEFormItem : this.psDEFormItemList) {
                String strItemName;
                if (!iPSDEFormItem.isEditable() || iPSDEFormItem.isHidden() || iPSDEFormItem.getPSDEField() == null || iPSDEFormItem.getPSDEField().getRestrictedPSDEField() == null || psDEFFormItemMap.containsKey(strItemName = iPSDEFormItem.getPSDEField().getRestrictedPSDEField().getName().toLowerCase()) || createItemMap.containsKey(strItemName)) continue;
                createItemMap.put(strItemName, "");
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5411\u5bfc\u8868\u5355\u5bf9\u8c61", hideempty2=true, child=true)
    public IPSDEWizardForm getPSDEWizardForm() {
        return this.iPSDEWizardForm;
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u8868\u5355\u5bfc\u822a\u680f", ignoredumpvalues="false", fields={"FORMNAVBAR"})
    public boolean isShowFormNavBar() {
        return this.bShowFormNavBar;
    }

    @Override
    @PSModelRTMeta(description="\u4fe1\u606f\u8868\u5355", ignoredumpvalues="false", fields={"INFOFORMFLAG"})
    public boolean isInfoFormMode() {
        return this.bInfoFormMode;
    }

    @Override
    public String getModelType() {
        return "PSDEFORM_EDITFORM";
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u81ea\u52a8\u4fdd\u5b58", ignoredumpvalues="false", fields={"CTRLPARAM5"})
    public boolean isEnableAutoSave() {
        return this.bEnableAutoSave;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u52a8\u4fdd\u5b58\u6a21\u5f0f", ignoredumpvalues="0", fields={"ENABLEAUTOSAVE"}, doc="\u89c6\u56fe\u90e8\u4ef6\u6a21\u578b{@link PSDEViewCtrlDTO#FIELD_CTRLPARAM5}\u4f18\u5148\u5b9a\u4e49")
    public int getAutoSaveMode() {
        return this.nAutoSaveMode;
    }

    @Override
    protected IPSAjaxControlHandler createDefaultPSAjaxControlHandler() throws Exception {
        if (this.getPSDEWizardForm() != null) {
            PSACHandlerAction psACHandlerAction;
            PSAjaxControlHandlerActionImpl psAjaxControlHandlerActionImpl;
            PSAjaxControlHandlerImpl psAjaxControlHandlerImpl = new PSAjaxControlHandlerImpl();
            PSACHandler psAjaxControlHandler = new PSACHandler();
            psAjaxControlHandlerImpl.init(this.getDAGlobalHelper(), this.getPSAppView(), this, psAjaxControlHandler);
            if (this.getPSDEWizardForm().getLoadPSDEAction() != null) {
                psAjaxControlHandlerActionImpl = new PSAjaxControlHandlerActionImpl();
                psACHandlerAction = new PSACHandlerAction();
                psACHandlerAction.setPSACHANDLERACTIONID("load");
                psACHandlerAction.setPSACHANDLERACTIONNAME("load");
                psACHandlerAction.setACTIONTYPE("DEACTION");
                psACHandlerAction.setPSDEACTIONID(this.getPSDEWizardForm().getLoadPSDEAction().getId());
                psACHandlerAction.setPSDEACTIONNAME(this.getPSDEWizardForm().getLoadPSDEAction().getName());
                psAjaxControlHandlerActionImpl.init(this.getDAGlobalHelper(), psAjaxControlHandlerImpl, psACHandlerAction);
                psAjaxControlHandlerImpl.registerPSAjaxHandlerAction(psAjaxControlHandlerActionImpl);
            }
            if (this.getPSDEWizardForm().getSavePSDEAction() != null) {
                psAjaxControlHandlerActionImpl = new PSAjaxControlHandlerActionImpl();
                psACHandlerAction = new PSACHandlerAction();
                psACHandlerAction.setPSACHANDLERACTIONID("update");
                psACHandlerAction.setPSACHANDLERACTIONNAME("update");
                psACHandlerAction.setACTIONTYPE("DEACTION");
                psACHandlerAction.setPSDEACTIONID(this.getPSDEWizardForm().getSavePSDEAction().getId());
                psACHandlerAction.setPSDEACTIONNAME(this.getPSDEWizardForm().getSavePSDEAction().getName());
                psAjaxControlHandlerActionImpl.init(this.getDAGlobalHelper(), psAjaxControlHandlerImpl, psACHandlerAction);
                psAjaxControlHandlerImpl.registerPSAjaxHandlerAction(psAjaxControlHandlerActionImpl);
            }
            if (this.getPSDEWizardForm().getGoBackPSDEAction() != null) {
                psAjaxControlHandlerActionImpl = new PSAjaxControlHandlerActionImpl();
                psACHandlerAction = new PSACHandlerAction();
                psACHandlerAction.setPSACHANDLERACTIONID("goback");
                psACHandlerAction.setPSACHANDLERACTIONNAME("goback");
                psACHandlerAction.setACTIONTYPE("DEACTION");
                psACHandlerAction.setPSDEACTIONID(this.getPSDEWizardForm().getGoBackPSDEAction().getId());
                psACHandlerAction.setPSDEACTIONNAME(this.getPSDEWizardForm().getGoBackPSDEAction().getName());
                psAjaxControlHandlerActionImpl.init(this.getDAGlobalHelper(), psAjaxControlHandlerImpl, psACHandlerAction);
                psAjaxControlHandlerImpl.registerPSAjaxHandlerAction(psAjaxControlHandlerActionImpl);
            }
            return psAjaxControlHandlerImpl;
        }
        return super.createDefaultPSAjaxControlHandler();
    }

    @Override
    @PSModelRTMeta(description="\u5efa\u7acb\u6570\u636e\u884c\u4e3a", hideempty=true, dumpref=true, from="__self__", from_method="getPSControlHandlerMust().getPSControlHandlerAction")
    public IPSControlAction getCreatePSControlAction() {
        try {
            if (this.getPSAjaxControlHandler() != null) {
                return this.getPSAjaxControlHandler().getPSAjaxHandlerAction("create", true);
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u66f4\u65b0\u6570\u636e\u884c\u4e3a", hideempty=true, dumpref=true, from="__self__", from_method="getPSControlHandlerMust().getPSControlHandlerAction")
    public IPSControlAction getUpdatePSControlAction() {
        try {
            if (this.getPSAjaxControlHandler() != null) {
                return this.getPSAjaxControlHandler().getPSAjaxHandlerAction("update", true);
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u5220\u9664\u6570\u636e\u884c\u4e3a", hideempty=true, dumpref=true, from="__self__", from_method="getPSControlHandlerMust().getPSControlHandlerAction")
    public IPSControlAction getRemovePSControlAction() {
        try {
            if (this.getPSAjaxControlHandler() != null) {
                return this.getPSAjaxControlHandler().getPSAjaxHandlerAction("remove", true);
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u83b7\u53d6\u6570\u636e\u884c\u4e3a", hideempty=true, dumpref=true, from="__self__", from_method="getPSControlHandlerMust().getPSControlHandlerAction")
    public IPSControlAction getGetPSControlAction() {
        try {
            if (this.getPSAjaxControlHandler() != null) {
                return this.getPSAjaxControlHandler().getPSAjaxHandlerAction("load", true);
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u83b7\u53d6\u8349\u7a3f\u6570\u636e\u884c\u4e3a", hideempty=true, dumpref=true, from="__self__", from_method="getPSControlHandlerMust().getPSControlHandlerAction")
    public IPSControlAction getGetDraftPSControlAction() {
        try {
            if (this.getPSAjaxControlHandler() != null) {
                return this.getPSAjaxControlHandler().getPSAjaxHandlerAction("loaddraft", true);
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u83b7\u53d6\u8349\u7a3f\u6570\u636e\u884c\u4e3a\uff08\u62f7\u8d1d\uff09", hideempty=true, dumpref=true, from="__self__", from_method="getPSControlHandlerMust().getPSControlHandlerAction")
    public IPSControlAction getGetDraftFromPSControlAction() {
        try {
            if (this.getPSAjaxControlHandler() != null) {
                return this.getPSAjaxControlHandler().getPSAjaxHandlerAction("loaddraftfrom", true);
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u56de\u9000\u6570\u636e\u884c\u4e3a", hideempty=true, dumpref=true, from="__self__", from_method="getPSControlHandlerMust().getPSControlHandlerAction")
    public IPSControlAction getGoBackPSControlAction() {
        try {
            if (this.getPSAjaxControlHandler() != null) {
                return this.getPSAjaxControlHandler().getPSAjaxHandlerAction("goback", true);
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u542f\u52a8\u884c\u4e3a", hideempty=true, dumpref=true, from="__self__", from_method="getPSControlHandlerMust().getPSControlHandlerAction")
    public IPSControlAction getWFStartPSControlAction() {
        try {
            if (this.getPSAjaxControlHandler() != null) {
                return this.getPSAjaxControlHandler().getPSAjaxHandlerAction("wfstart", true);
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u63d0\u4ea4\u884c\u4e3a", hideempty=true, dumpref=true, from="__self__", from_method="getPSControlHandlerMust().getPSControlHandlerAction")
    public IPSControlAction getWFSubmitPSControlAction() {
        try {
            if (this.getPSAjaxControlHandler() != null) {
                return this.getPSAjaxControlHandler().getPSAjaxHandlerAction("wfsubmit", true);
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5c5e\u6027\u96c6\u5408", hideempty=true)
    public Iterator<IPSAppDEField> getPSAppDEFields() throws Exception {
        if (this.psAppDEFieldList == null) {
            LinkedHashMap<String, IPSAppDEField> psAppDEFieldMap = new LinkedHashMap<String, IPSAppDEField>();
            Iterator<IPSDEFormDetail> psDEFormDetails = this.getAllPSDEFormDetails();
            if (psDEFormDetails != null) {
                while (psDEFormDetails.hasNext()) {
                    IPSDEFormItem iPSDEFormItem;
                    IPSDEFormDetail iPSDEFormDetail = psDEFormDetails.next();
                    if (!(iPSDEFormDetail instanceof IPSDEFormItem) || (iPSDEFormItem = (IPSDEFormItem)iPSDEFormDetail).getPSAppDEField() == null) continue;
                    psAppDEFieldMap.put(iPSDEFormItem.getPSAppDEField().getName(), iPSDEFormItem.getPSAppDEField());
                }
            }
            ArrayList<IPSAppDEField> psAppDEFieldList = new ArrayList<IPSAppDEField>();
            psAppDEFieldList.addAll(psAppDEFieldMap.values());
            Collections.sort(psAppDEFieldList, new Comparator<IPSAppDEField>(){

                @Override
                public int compare(IPSAppDEField o1, IPSAppDEField o2) {
                    return StringHelper.compare((String)o1.getName(), (String)o2.getName(), (boolean)false);
                }
            });
            if (this.psAppDEFieldList == null) {
                this.psAppDEFieldList = psAppDEFieldList;
            }
        }
        return this.psAppDEFieldList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u4fe1\u606f\u8868\u5355\u8f6c\u5316\u9009\u62e9\u90e8\u4ef6\u81f3\u94fe\u63a5\u90e8\u4ef6", hideempty=true, dump=false)
    public boolean isInfoFormConvertPickerToLink() {
        return this.bInfoFormConvertPickerToLink;
    }

    @Override
    @PSModelRTMeta(description="\u4fe1\u606f\u8868\u5355\u542f\u7528\u53ea\u8bfb\u6a21\u5f0f", hideempty=true, dump=false)
    public boolean isInfoFormReadOnlyMode() {
        return this.bInfoFormReadOnlyMode;
    }

    @Override
    @PSModelRTMeta(description="\u53ea\u8bfb\u6a21\u5f0f", ignoredumpvalues="false")
    public boolean isReadOnly() {
        return this.onGetReadOnly();
    }

    protected boolean onGetReadOnly() {
        return false;
    }

    @Override
    protected boolean isNeedFillPSACHandlerData() {
        if (!(this.getPSDEWizardForm() != null || StringHelper.isNullOrEmpty((String)this.psDEForm.getGETDRAFTPSDEACTIONID()) && StringHelper.isNullOrEmpty((String)this.psDEForm.getCREATEPSDEACTIONID()) && StringHelper.isNullOrEmpty((String)this.psDEForm.getGETPSDEACTIONID()) && StringHelper.isNullOrEmpty((String)this.psDEForm.getUPDATEPSDEACTIONID()) && StringHelper.isNullOrEmpty((String)this.psDEForm.getREMOVEPSDEACTIONID()) && StringHelper.isNullOrEmpty((String)this.psDEForm.getCOPYPSDEACTIONID()) && StringHelper.isNullOrEmpty((String)this.psDEForm.getUSERPSDEACTIONID()) && StringHelper.isNullOrEmpty((String)this.psDEForm.getUSER2PSDEACTIONID()))) {
            return true;
        }
        return super.isNeedFillPSACHandlerData();
    }

    @Override
    protected void fillPSACHandlerData(PSACHandler psACHandler) throws Exception {
        super.fillPSACHandlerData(psACHandler);
        if (StringHelper.isNullOrEmpty((String)psACHandler.getGETDRAFTPSDEACTIONID()) && !StringHelper.isNullOrEmpty((String)this.psDEForm.getGETDRAFTPSDEACTIONID())) {
            psACHandler.setGETDRAFTPSDEACTIONID(this.psDEForm.getGETDRAFTPSDEACTIONID());
            psACHandler.setGETDRAFTPSDEACTIONNAME(this.psDEForm.getGETDRAFTPSDEACTIONNAME());
        }
        if (StringHelper.isNullOrEmpty((String)psACHandler.getCREATEPSDEACTIONID()) && !StringHelper.isNullOrEmpty((String)this.psDEForm.getCREATEPSDEACTIONID())) {
            psACHandler.setCREATEPSDEACTIONID(this.psDEForm.getCREATEPSDEACTIONID());
            psACHandler.setCREATEPSDEACTIONNAME(this.psDEForm.getCREATEPSDEACTIONNAME());
        }
        if (StringHelper.isNullOrEmpty((String)psACHandler.getGETPSDEACTIONID()) && !StringHelper.isNullOrEmpty((String)this.psDEForm.getGETPSDEACTIONID())) {
            psACHandler.setGETPSDEACTIONID(this.psDEForm.getGETPSDEACTIONID());
            psACHandler.setGETPSDEACTIONNAME(this.psDEForm.getGETPSDEACTIONNAME());
        }
        if (StringHelper.isNullOrEmpty((String)psACHandler.getUPDATEPSDEACTIONID()) && !StringHelper.isNullOrEmpty((String)this.psDEForm.getUPDATEPSDEACTIONID())) {
            psACHandler.setUPDATEPSDEACTIONID(this.psDEForm.getUPDATEPSDEACTIONID());
            psACHandler.setUPDATEPSDEACTIONNAME(this.psDEForm.getUPDATEPSDEACTIONNAME());
        }
        if (StringHelper.isNullOrEmpty((String)psACHandler.getREMOVEPSDEACTIONID()) && !StringHelper.isNullOrEmpty((String)this.psDEForm.getREMOVEPSDEACTIONID())) {
            psACHandler.setREMOVEPSDEACTIONID(this.psDEForm.getREMOVEPSDEACTIONID());
            psACHandler.setREMOVEPSDEACTIONNAME(this.psDEForm.getREMOVEPSDEACTIONNAME());
        }
        if (StringHelper.isNullOrEmpty((String)psACHandler.getCOPYPSDEACTIONID()) && !StringHelper.isNullOrEmpty((String)this.psDEForm.getCOPYPSDEACTIONID())) {
            psACHandler.setCOPYPSDEACTIONID(this.psDEForm.getCOPYPSDEACTIONID());
            psACHandler.setCOPYPSDEACTIONNAME(this.psDEForm.getCOPYPSDEACTIONNAME());
        }
        if (StringHelper.isNullOrEmpty((String)psACHandler.getUSERPSDEACTIONID()) && !StringHelper.isNullOrEmpty((String)this.psDEForm.getUSERPSDEACTIONID())) {
            psACHandler.setUSERPSDEACTIONID(this.psDEForm.getUSERPSDEACTIONID());
            psACHandler.setUSERPSDEACTIONNAME(this.psDEForm.getUSERPSDEACTIONNAME());
        }
        if (StringHelper.isNullOrEmpty((String)psACHandler.getUSER2PSDEACTIONID()) && !StringHelper.isNullOrEmpty((String)this.psDEForm.getUSER2PSDEACTIONID())) {
            psACHandler.setUSER2PSDEACTIONID(this.psDEForm.getUSER2PSDEACTIONID());
            psACHandler.setUSER2PSDEACTIONNAME(this.psDEForm.getUSER2PSDEACTIONNAME());
        }
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u5bfc\u822a\u53c2\u6570\u96c6\u5408", child=true)
    public Iterator<IPSControlNavParam> getPSControlNavParams() throws Exception {
        if (this.psControlNavParamMap == null || this.psControlNavParamMap.size() == 0) {
            return null;
        }
        return this.psControlNavParamMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u5bfc\u822a\u4e0a\u4e0b\u6587\u96c6\u5408", child=true)
    public Iterator<IPSControlNavContext> getPSControlNavContexts() throws Exception {
        if (this.psControlNavContextMap == null || this.psControlNavContextMap.size() == 0) {
            return null;
        }
        return this.psControlNavContextMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5f53\u524d\u6570\u636e\u6a21\u5f0f", ignoredumpvalues="false")
    public boolean isActiveDataMode() {
        if (this.psDEEditFormParamImpl.isActiveDataMode() == null) {
            return false;
        }
        return this.psDEEditFormParamImpl.isActiveDataMode();
    }

    @Override
    @PSModelRTMeta(description="\u5f53\u524d\u6570\u636e\u5c5e\u6027")
    public String getActiveDataField() {
        if (this.isActiveDataMode()) {
            return this.psDEEditFormParamImpl.getActiveDataField();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u8868\u5355\u6570\u636e\u7c7b\u578b", ignorert=3, fields={"DATATYPE"})
    public String getDataType() {
        return this.psDEForm.getDATATYPE();
    }

    public boolean isEnableCounter() {
        return this.bEnableCounter;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u81ea\u5b9a\u4e49\u8868\u5355\u9879", ignoredumpvalues="false", fields={"ENABLECUSTOMIZED"})
    public boolean isEnableCustomized() {
        return this.bEnableCustomized;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u680f\u4f4d\u7f6e", codelist="FormNavBarPos", fields={"NAVBARPOS"})
    public String getNavBarPos() {
        if (this.isShowFormNavBar()) {
            return this.psDEForm.getNAVBARPOS();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u680f\u6837\u5f0f", fields={"NAVBARSTYLE"})
    public String getNavBarStyle() {
        if (this.isShowFormNavBar()) {
            return this.psDEForm.getNAVBARSTYLE();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u680f\u5bbd\u5ea6", ignoredumpvalues="0.0", fields={"NAVBARWIDTH"})
    public double getNavBarWidth() {
        if (this.isShowFormNavBar() && !this.psDEForm.isNAVBARWIDTHNull() && this.psDEForm.getNAVBARWIDTH() > 0) {
            return this.psDEForm.getNAVBARWIDTH();
        }
        return 0.0;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u680f\u9ad8\u5ea6", ignoredumpvalues="0.0", fields={"NAVBARHEIGHT"})
    public double getNavbarHeight() {
        if (this.isShowFormNavBar() && !this.psDEForm.isNAVBARHEIGHTNull() && this.psDEForm.getNAVBARHEIGHT() > 0) {
            return this.psDEForm.getNAVBARHEIGHT();
        }
        return 0.0;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u680f\u6837\u5f0f\u8868", fields={"NAVBARPSSYSCSSID"})
    public IPSSysCss getNavBarPSSysCss() {
        if (this.isShowFormNavBar()) {
            return this.iNavBarPSSysCss;
        }
        return null;
    }
}

