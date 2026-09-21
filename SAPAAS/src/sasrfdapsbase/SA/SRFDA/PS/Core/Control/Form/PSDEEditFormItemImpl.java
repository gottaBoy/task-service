/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.pscore.srv.codelist.FDLogicCatCodeListModel
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethodDTO;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethodDTOField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethodReturn;
import SA.SRFDA.PS.Core.Control.Form.IPSDEEditForm;
import SA.SRFDA.PS.Core.Control.Form.IPSDEEditFormItem;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormGroupBase;
import SA.SRFDA.PS.Core.Control.Form.PSDEFDCatGroupLogicImpl;
import SA.SRFDA.PS.Core.Control.Form.PSDEFormItemImpl;
import SA.SRFDA.PS.Core.DEField.IPSDEFUIMode;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSDEFieldBase;
import SA.SRFDA.PS.Core.DEField.IPSPickupObjectDEField;
import SA.SRFDA.PS.Core.Data.PSDataItemParamImpl;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERCustom;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERNN;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTOField;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemRuntime;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.ValueRule.IPSSysValueRule;
import SA.SRFDA.PS.Data.PSDEFDLogic;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.pscore.srv.codelist.FDLogicCatCodeListModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEEditFormItemImpl
extends PSDEFormItemImpl
implements IPSDEEditFormItem {
    private static final Log log = LogFactory.getLog(PSDEEditFormItemImpl.class);
    private IPSDEFUIMode iPSDEFUIMode = null;

    @Override
    protected void onInit() throws Exception {
        IPSSystemRuntime iPSSystemRuntime;
        if (!this.isRepeatContent() && !StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getPSDEFID())) {
            this.iPSDEField = this.getPSDEForm().getPSDataEntity().getPSDEField(this.psDEFormDetail.getPSDEFID(), false);
        }
        super.onInit();
        int nIgnoreInput = 0;
        nIgnoreInput = !this.psDEFormDetail.isIGNOREINPUTNull() ? this.psDEFormDetail.getIGNOREINPUT() : this.onCalcIgnoreInput();
        if (this.isConvertToCodeItemText()) {
            nIgnoreInput = 3;
        }
        this.setIgnoreInput(nIgnoreInput);
        if (this.getPSSystem() instanceof IPSSystemRuntime && (iPSSystemRuntime = (IPSSystemRuntime)((Object)this.getPSSystem())).getDynaInstMode() == 2 && this.getPSDEField() != null && this.getPSDEField().getPSCodeList() != null && this.getPSDEField().getPSCodeList().isModuleInstCodeList() && StringHelper.Compare((String)iPSSystemRuntime.getDynaInstTag(), (String)this.getPSDEField().getPSCodeList().getDynaInstTag(), (boolean)false) == 0) {
            this.setCreateDV(iPSSystemRuntime.getDynaInstTag2());
            this.setCreateDVT("");
        }
        if (this.getPSSystemSetting().isEnableDEFieldRestrictedUI() && this.isEditable() && !this.isHidden() && !this.isInfoMode() && this.getPSDEField() != null && this.getPSDEField().getRestrictedPSDEField() != null && this.getPSDEFDGroupLogic("ITEMENABLE") == null) {
            ArrayList<PSDEFDLogic> psDEFDLogicList = new ArrayList<PSDEFDLogic>();
            PSDEFDLogic child = new PSDEFDLogic();
            child.setPSDEFORMDETAILID(this.getId());
            child.setPSDEFORMDETAILNAME(this.getName());
            child.setFDNAME(this.getPSDEField().getRestrictedPSDEField().getName().toLowerCase());
            child.setLOGICTYPE("SINGLE");
            child.setPSDBVALUEOPID("ISNOTNULL");
            psDEFDLogicList.add(child);
            child = new PSDEFDLogic();
            child.setPSDEFORMDETAILID(this.getId());
            child.setPSDEFORMDETAILNAME(this.getName());
            child.setFDNAME(this.getPSDEField().getRestrictedPSDEField().getName().toLowerCase());
            child.setLOGICTYPE("SINGLE");
            child.setPSDBVALUEOPID("NOTEQ");
            child.setCONDVALUE("");
            psDEFDLogicList.add(child);
            FDLogicCatCodeListModel fdLogicCatCodeListModel = (FDLogicCatCodeListModel)CodeListGlobal.getCodeList(FDLogicCatCodeListModel.class);
            PSDEFDLogic psDEFDLogic = new PSDEFDLogic();
            psDEFDLogic.setPSDEFDLOGICID(KeyValueHelper.genUniqueId((String)this.getId(), (String)"ITEMENABLE"));
            psDEFDLogic.setPSDEFDLOGICNAME(StringHelper.Format((String)"\u8868\u5355\u6210\u5458[%1$s][%2$s]\u903b\u8f91", (Object)this.getName(), (Object)fdLogicCatCodeListModel.getCodeListText("ITEMENABLE", true)));
            psDEFDLogic.setGROUPOP("AND");
            psDEFDLogic.setLOGICTYPE("GROUP");
            psDEFDLogic.setLOGICCAT("ITEMENABLE");
            psDEFDLogic.getChildPSDEFDLogics(true).addAll(psDEFDLogicList);
            PSDEFDCatGroupLogicImpl iPSDEFDLogic = new PSDEFDCatGroupLogicImpl();
            iPSDEFDLogic.init(this.getDAGlobalHelper(), this, null, psDEFDLogic);
            if (iPSDEFDLogic.getPSDEFDLogics() != null) {
                this.registerPSDEFDGroupLogic("ITEMENABLE", iPSDEFDLogic);
            }
        }
    }

    @Override
    protected void preparePSDEFFormItem() throws Exception {
        if (this.getPSDEField() != null) {
            if (StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getPSDEFFORMITEMID())) {
                String strDEFUIMode = StringHelper.Format((String)"APPDEFAULT:%1$s", (Object)this.getPSDEForm().getPSAppView().getPSApplication().getId());
                this.iPSDEFUIMode = this.getPSDEField().getPSDEFUIMode(strDEFUIMode, true);
                if (this.iPSDEFUIMode == null) {
                    this.iPSDEFUIMode = this.getPSDEForm().getPSAppView().getPSApplication().isMobileApp() ? this.getPSDEField().getPSDEFUIMode("MOBILEDEFAULT") : this.getPSDEField().getPSDEFUIMode("DEFAULT");
                }
            } else {
                this.iPSDEFUIMode = this.getPSDEField().getPSDEFUIMode(this.psDEFormDetail.getPSDEFFORMITEMID());
            }
            this.setPSDEFFormItem(this.iPSDEFUIMode.getPSDEFFormItem());
        }
    }

    @Override
    protected void prepareDataItem() throws Exception {
        super.prepareDataItem();
        boolean bUseDTO = false;
        if (this.getPSDEForm().getPSAppView() != null && this.getPSDEForm().getPSAppView().getPSApplication() != null) {
            bUseDTO = this.getPSDEForm().getPSAppView().getPSApplication().isUseServiceApi();
        }
        if (this.getPSDEField() != null) {
            String strValueFormat = this.psDEFormDetail.getVALUEFORMAT();
            if (StringHelper.IsNullOrEmpty((String)strValueFormat) && this.getPSDEFFormItem() != null) {
                strValueFormat = !bUseDTO ? this.getPSDEFFormItem().getValueFormat() : this.getPSDEFFormItem().getOriginValueFormat();
            }
            if (StringHelper.IsNullOrEmpty((String)strValueFormat) && bUseDTO && this.getPSAppDEField() != null) {
                strValueFormat = this.getPSAppDEField().getValueFormat();
            }
            if (StringHelper.Compare((String)this.getPSDEField().getName(), (String)this.getName(), (boolean)true) != 0) {
                PSDataItemParamImpl psDataItemParamImpl = new PSDataItemParamImpl();
                psDataItemParamImpl.setName(this.getPSDEField().getName());
                psDataItemParamImpl.setFormat(strValueFormat);
                psDataItemParamImpl.setPSDEField(this.getPSDEField());
                psDataItemParamImpl.setPSAppDEField(this.getPSAppDEField());
                this.psDataItemImpl.addDataItemParam(psDataItemParamImpl);
            } else {
                this.psDataItemImpl.setFormat(strValueFormat);
            }
        }
        if (this.isConvertToCodeItemText()) {
            this.psDataItemImpl.setCodeListId(this.getCodeListId());
        }
    }

    @Override
    @PSModelRTMeta(description="\u503c\u683c\u5f0f\u5316", fields={"VALUEFORMAT"})
    public String getValueFormat() {
        if (this.psDataItemImpl != null) {
            if (this.psDataItemImpl.getDataItemParam() != null) {
                return this.psDataItemImpl.getDataItemParam().getFormat();
            }
            return this.psDataItemImpl.getFormat();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u754c\u9762\u6a21\u5f0f")
    public IPSDEFUIMode getPSDEFUIMode() {
        return this.iPSDEFUIMode;
    }

    protected int onCalcIgnoreInput() throws Exception {
        IPSPFStyle iPSPFStyle;
        IPSDEFormGroupBase iPSDEFormGroupBase;
        if (this.getPSDEFFormItem() != null && this.getPSDEFFormItem().isIgnoreInputDefined()) {
            return this.getPSDEFFormItem().getIgnoreInput();
        }
        if (this.getParentPSDEFormDetail() != null && this.getParentPSDEFormDetail() instanceof IPSDEFormGroupBase && (iPSDEFormGroupBase = (IPSDEFormGroupBase)this.getParentPSDEFormDetail()).isItemIgnoreInputDefined()) {
            return iPSDEFormGroupBase.getItemIgnoreInput();
        }
        if (this.getPSDEField() != null && this.getPSDEField().isSystemReserver() && StringHelper.Compare((String)this.getCodeName(), (String)this.getPSDEField().getName(), (boolean)true) == 0 && (iPSPFStyle = this.getPSDEForm().getPSAppView().getPSApplication().getPSPFStyle()).isSystemFieldReadonlyDefault()) {
            return 3;
        }
        return 0;
    }

    @Override
    protected IPSSysValueRule onGetPSSysValueRule() throws Exception {
        if (this.getPSDEFFormItem() != null) {
            if (this.getPSAppDEField() != null) {
                return this.getPSDEFFormItem().getPSSysValueRule(this.getPSAppDEField());
            }
            if (this.getPSDEField() != null) {
                return this.getPSDEFFormItem().getPSSysValueRule(this.getPSDEField());
            }
        } else {
            if (this.getPSAppDEField() != null) {
                return this.getPSAppDEField().getPSSysValueRule();
            }
            if (this.getPSDEField() != null) {
                return this.getPSDEField().getPSSysValueRule();
            }
        }
        return null;
    }

    @Override
    public String getEditorParam(String strParam, String strDefault) {
        String strValue = super.getEditorParam(strParam, strDefault);
        if (StringHelper.IsNullOrEmpty((String)strDefault) && StringHelper.IsNullOrEmpty((String)strValue) && strDefault != null && (StringHelper.Compare((String)strParam, (String)"DEFAULTMAXLENGTH", (boolean)false) == 0 || StringHelper.Compare((String)strParam, (String)"DEFAULTMINLENGTH", (boolean)false) == 0 || StringHelper.Compare((String)strParam, (String)"DEFAULTMAXVALUE", (boolean)false) == 0 || StringHelper.Compare((String)strParam, (String)"DEFAULTMINVALUE", (boolean)false) == 0 || StringHelper.Compare((String)strParam, (String)"DEFAULTPRECISION", (boolean)false) == 0 || StringHelper.Compare((String)strParam, (String)"DEFAULTARRAY", (boolean)false) == 0 || StringHelper.Compare((String)strParam, (String)"DEFAULTARRAYDATATYPE", (boolean)false) == 0 || StringHelper.Compare((String)strParam, (String)"DEFAULTVALUETYPE", (boolean)false) == 0 || StringHelper.Compare((String)strParam, (String)"DEFAULTOBJECTIDFIELD", (boolean)false) == 0 || StringHelper.Compare((String)strParam, (String)"DEFAULTOBJECTNAMEFIELD", (boolean)false) == 0 || StringHelper.Compare((String)strParam, (String)"DEFAULTOBJECTVALUEFIELD", (boolean)false) == 0 || StringHelper.Compare((String)strParam, (String)"DEFAULTTEXTSEPARATOR", (boolean)false) == 0 || StringHelper.Compare((String)strParam, (String)"DEFAULTVALUESEPARATOR", (boolean)false) == 0)) {
            String strValue2 = super.getEditorParam(strParam, null);
            if (strValue2 != null) {
                return strValue2;
            }
            IPSModelObject iPSDEFieldBase = null;
            if (this.getPSAppDEField() != null) {
                iPSDEFieldBase = this.getPSAppDEField();
            } else if (this.getPSDEField() != null) {
                iPSDEFieldBase = this.getPSDEField();
            }
            if (this.getPSDEFFormItem() == null && iPSDEFieldBase == null) {
                return strValue;
            }
            if (StringHelper.Compare((String)strParam, (String)"DEFAULTMAXLENGTH", (boolean)false) == 0) {
                int nLength = -1;
                nLength = this.getPSDEFFormItem() != null ? this.getPSDEFFormItem().getStringLength((IPSDEFieldBase)((Object)iPSDEFieldBase)) : iPSDEFieldBase.getStringLength();
                if (nLength <= 0) {
                    return null;
                }
                return String.format("%1$s", nLength);
            }
            if (StringHelper.Compare((String)strParam, (String)"DEFAULTMINLENGTH", (boolean)false) == 0) {
                int nLength = -1;
                nLength = this.getPSDEFFormItem() != null ? this.getPSDEFFormItem().getMinStringLength((IPSDEFieldBase)((Object)iPSDEFieldBase)) : iPSDEFieldBase.getMinStringLength();
                if (nLength <= 0) {
                    return null;
                }
                return String.format("%1$s", nLength);
            }
            if (StringHelper.Compare((String)strParam, (String)"DEFAULTMAXVALUE", (boolean)false) == 0) {
                if (this.getPSDEFFormItem() != null) {
                    return this.getPSDEFFormItem().getMaxValueString((IPSDEFieldBase)((Object)iPSDEFieldBase));
                }
                return iPSDEFieldBase.getMaxValueString();
            }
            if (StringHelper.Compare((String)strParam, (String)"DEFAULTMINVALUE", (boolean)false) == 0) {
                if (this.getPSDEFFormItem() != null) {
                    return this.getPSDEFFormItem().getMinValueString((IPSDEFieldBase)((Object)iPSDEFieldBase));
                }
                return iPSDEFieldBase.getMinValueString();
            }
            if (StringHelper.Compare((String)strParam, (String)"DEFAULTPRECISION", (boolean)false) == 0) {
                int nLength = -1;
                nLength = this.getPSDEFFormItem() != null ? this.getPSDEFFormItem().getPrecision((IPSDEFieldBase)((Object)iPSDEFieldBase)) : iPSDEFieldBase.getPrecision();
                if (nLength <= 0) {
                    return null;
                }
                return String.format("%1$s", nLength);
            }
            if (this.getPSAppDEField() != null && StringHelper.Compare((String)strParam, (String)"DEFAULTARRAYDATATYPE", (boolean)false) == 0) {
                block63: {
                    IPSAppDEMethodReturn iPSAppDEMethodReturn;
                    IPSDEEditForm iPSDEEditForm = (IPSDEEditForm)this.getPSDEForm();
                    if (iPSDEEditForm.getGetPSControlAction() != null && iPSDEEditForm.getGetPSControlAction().getPSAppDEMethod() != null && (iPSAppDEMethodReturn = iPSDEEditForm.getGetPSControlAction().getPSAppDEMethod().getPSAppDEMethodReturn()) != null && "DTO".equals(iPSAppDEMethodReturn.getType())) {
                        IPSAppDEMethodDTOField iPSAppDEMethodDTOField;
                        block64: {
                            IPSAppDEMethodDTO iPSAppDEMethodDTO = iPSAppDEMethodReturn.getPSAppDEMethodDTO();
                            if (iPSAppDEMethodDTO == null || (iPSAppDEMethodDTOField = iPSAppDEMethodDTO.getPSAppDEMethodDTOField(this.getPSAppDEField(), true)) == null || !"SIMPLES".equals(iPSAppDEMethodDTOField.getType())) break block63;
                            if (!DataTypeHelper.isBigIntType((int)iPSAppDEMethodDTOField.getStdDataType()) && !DataTypeHelper.isBigDecimalType((int)iPSAppDEMethodDTOField.getStdDataType()) && !DataTypeHelper.isDoubleType((int)iPSAppDEMethodDTOField.getStdDataType())) break block64;
                            return "NUMBER";
                        }
                        try {
                            if (DataTypeHelper.isIntType((int)iPSAppDEMethodDTOField.getStdDataType())) {
                                return "INTEGER";
                            }
                            return "STRING";
                        }
                        catch (Exception ex) {
                            log.error((Object)ex);
                        }
                    }
                }
                return strValue;
            }
            if (this.getPSAppDEField() != null && StringHelper.Compare((String)strParam, (String)"DEFAULTARRAY", (boolean)false) == 0) {
                IPSAppDEMethodReturn iPSAppDEMethodReturn;
                IPSDEEditForm iPSDEEditForm = (IPSDEEditForm)this.getPSDEForm();
                if (iPSDEEditForm.getGetPSControlAction() != null && iPSDEEditForm.getGetPSControlAction().getPSAppDEMethod() != null && (iPSAppDEMethodReturn = iPSDEEditForm.getGetPSControlAction().getPSAppDEMethod().getPSAppDEMethodReturn()) != null && "DTO".equals(iPSAppDEMethodReturn.getType())) {
                    try {
                        IPSAppDEMethodDTOField iPSAppDEMethodDTOField;
                        IPSAppDEMethodDTO iPSAppDEMethodDTO = iPSAppDEMethodReturn.getPSAppDEMethodDTO();
                        if (iPSAppDEMethodDTO != null && (iPSAppDEMethodDTOField = iPSAppDEMethodDTO.getPSAppDEMethodDTOField(this.getPSAppDEField(), true)) != null && "SIMPLES".equals(iPSAppDEMethodDTOField.getType())) {
                            return "true";
                        }
                    }
                    catch (Exception ex) {
                        log.error((Object)ex);
                    }
                }
                return strValue;
            }
            if (this.getPSAppDEField() != null && StringHelper.Compare((String)strParam, (String)"DEFAULTVALUETYPE", (boolean)false) == 0) {
                block65: {
                    IPSAppDEMethodDTOField iPSAppDEMethodDTOField;
                    block68: {
                        block67: {
                            block66: {
                                IPSAppDEMethodDTO iPSAppDEMethodDTO = this.getPSAppDEMethodDTO();
                                if (iPSAppDEMethodDTO == null || (iPSAppDEMethodDTOField = iPSAppDEMethodDTO.getPSAppDEMethodDTOField(this.getPSAppDEField(), true)) == null) break block65;
                                if (!"SIMPLE".equals(iPSAppDEMethodDTOField.getType())) break block66;
                                return "SIMPLE";
                            }
                            if (!"SIMPLES".equals(iPSAppDEMethodDTOField.getType())) break block67;
                            return "SIMPLES";
                        }
                        if (!"DTOS".equals(iPSAppDEMethodDTOField.getType())) break block68;
                        return "OBJECTS";
                    }
                    try {
                        if ("DTO".equals(iPSAppDEMethodDTOField.getType())) {
                            return "OBJECT";
                        }
                    }
                    catch (Exception ex) {
                        log.error((Object)ex);
                    }
                }
                return strValue;
            }
            if (this.getPSAppDEField() != null && (StringHelper.Compare((String)strParam, (String)"DEFAULTOBJECTIDFIELD", (boolean)false) == 0 || StringHelper.Compare((String)strParam, (String)"DEFAULTOBJECTNAMEFIELD", (boolean)false) == 0 || StringHelper.Compare((String)strParam, (String)"DEFAULTOBJECTVALUEFIELD", (boolean)false) == 0)) {
                block69: {
                    try {
                        IPSAppDEMethodDTOField dstPSAppDEMethodDTOField;
                        IPSAppDEField dstPSAppDEField;
                        IPSDEMethodDTOField iPSDEMethodDTOField;
                        IPSAppDEMethodDTOField iPSAppDEMethodDTOField;
                        IPSAppDEMethodDTO iPSAppDEMethodDTO = this.getPSAppDEMethodDTO();
                        if (iPSAppDEMethodDTO == null || (iPSAppDEMethodDTOField = iPSAppDEMethodDTO.getPSAppDEMethodDTOField(this.getPSAppDEField(), true)) == null || iPSAppDEMethodDTOField.getPSDEMethodDTOField() == null || (iPSDEMethodDTOField = iPSAppDEMethodDTOField.getPSDEMethodDTOField()).getPSDER() == null || !"DTO".equals(iPSAppDEMethodDTOField.getType()) && !"DTOS".equals(iPSAppDEMethodDTOField.getType()) || iPSAppDEMethodDTOField.getRefPSAppDEMethodDTO() == null || iPSAppDEMethodDTOField.getRefPSAppDataEntity() == null) break block69;
                        IPSDER1N iPSDER1N = null;
                        IPSDERCustom iPSDERCustom = null;
                        IPSDEField pickupPSDEField = null;
                        IPSDEField pickupTextPSDEField = null;
                        IPSPickupObjectDEField pickupObjectPSDEField = null;
                        IPSDataEntity dstPSDataEntity = iPSAppDEMethodDTOField.getRefPSAppDataEntity().getPSDataEntity();
                        IPSDataEntity refPSDataEntity = this.getRefPSDataEntity();
                        if (refPSDataEntity != null) {
                            Iterator<IPSDERBase> psDERs = dstPSDataEntity.getMinorPSDERs();
                            if (psDERs != null) {
                                while (psDERs.hasNext()) {
                                    IPSDERBase iPSDERBase = psDERs.next();
                                    if (StringHelper.Compare((String)refPSDataEntity.getId(), (String)iPSDERBase.getMajorDEId(), (boolean)false) != 0) continue;
                                    if ("DER1N".equals(iPSDERBase.getDERType())) {
                                        iPSDER1N = (IPSDER1N)iPSDERBase;
                                    } else if ("DER11".equals(iPSDERBase.getDERType())) {
                                        iPSDER1N = (IPSDER1N)iPSDERBase;
                                    } else {
                                        if (!"DERCUSTOM".equals(iPSDERBase.getDERType()) || ((IPSDERCustom)iPSDERBase).getPickupPSDEField() == null) continue;
                                        iPSDERCustom = (IPSDERCustom)iPSDERBase;
                                    }
                                    break;
                                }
                            }
                        } else if (dstPSDataEntity.getDEType() == 3) {
                            IPSDERNN iPSDERNN = dstPSDataEntity.getPSDERNN();
                            if (StringHelper.Compare((String)iPSDERNN.getFirstPSDER().getMajorDEId(), (String)this.getPSAppDEField().getPSAppDataEntity().getPSDataEntity().getId(), (boolean)false) == 0) {
                                if (iPSDERNN.getSecondPSDER() instanceof IPSDER1N) {
                                    iPSDER1N = (IPSDER1N)iPSDERNN.getSecondPSDER();
                                } else {
                                    iPSDERCustom = (IPSDERCustom)iPSDERNN.getSecondPSDER();
                                }
                            } else if (iPSDERNN.getFirstPSDER() instanceof IPSDER1N) {
                                iPSDER1N = (IPSDER1N)iPSDERNN.getFirstPSDER();
                            } else {
                                iPSDERCustom = (IPSDERCustom)iPSDERNN.getFirstPSDER();
                            }
                        }
                        if (iPSDER1N != null) {
                            pickupPSDEField = iPSDER1N.getPickupPSDEField();
                            pickupTextPSDEField = iPSDER1N.getPSPickupTextDEField();
                            pickupObjectPSDEField = iPSDER1N.getPSPickupObjectDEField();
                        } else if (iPSDERCustom != null) {
                            iPSDERCustom = (IPSDERCustom)iPSDEMethodDTOField.getPSDER();
                            pickupPSDEField = iPSDERCustom.getPickupPSDEField();
                            pickupTextPSDEField = iPSDERCustom.getPickupTextPSDEField();
                        } else {
                            pickupPSDEField = dstPSDataEntity.getKeyPSDEField();
                            pickupTextPSDEField = dstPSDataEntity.getMajorPSDEField();
                        }
                        if (pickupPSDEField != null && pickupTextPSDEField == null) {
                            pickupTextPSDEField = dstPSDataEntity.getMajorPSDEField();
                        }
                        IPSDEField dstPSDEField = null;
                        if (StringHelper.Compare((String)strParam, (String)"DEFAULTOBJECTIDFIELD", (boolean)false) == 0) {
                            dstPSDEField = pickupPSDEField;
                        } else if (StringHelper.Compare((String)strParam, (String)"DEFAULTOBJECTNAMEFIELD", (boolean)false) == 0) {
                            dstPSDEField = pickupTextPSDEField;
                        } else if (StringHelper.Compare((String)strParam, (String)"DEFAULTOBJECTVALUEFIELD", (boolean)false) == 0) {
                            dstPSDEField = pickupObjectPSDEField;
                        }
                        if (dstPSDEField != null && (dstPSAppDEField = iPSAppDEMethodDTOField.getRefPSAppDataEntity().getPSAppDEField(dstPSDEField, true)) != null && (dstPSAppDEMethodDTOField = iPSAppDEMethodDTOField.getRefPSAppDEMethodDTO().getPSAppDEMethodDTOField(dstPSAppDEField, true)) != null) {
                            return dstPSAppDEMethodDTOField.getName();
                        }
                    }
                    catch (Exception ex) {
                        log.error((Object)ex);
                    }
                }
                return strValue;
            }
        }
        return strValue;
    }

    protected IPSAppDEMethodDTO getPSAppDEMethodDTO() throws Exception {
        IPSAppDEMethodReturn iPSAppDEMethodReturn;
        IPSDEEditForm iPSDEEditForm = (IPSDEEditForm)this.getPSDEForm();
        if (iPSDEEditForm.getGetPSControlAction() != null && iPSDEEditForm.getGetPSControlAction().getPSAppDEMethod() != null && (iPSAppDEMethodReturn = iPSDEEditForm.getGetPSControlAction().getPSAppDEMethod().getPSAppDEMethodReturn()) != null && "DTO".equals(iPSAppDEMethodReturn.getType())) {
            return iPSAppDEMethodReturn.getPSAppDEMethodDTO();
        }
        return null;
    }
}

