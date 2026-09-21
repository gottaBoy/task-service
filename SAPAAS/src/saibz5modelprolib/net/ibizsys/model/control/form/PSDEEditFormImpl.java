/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.form.IPSDEEditForm
 *  net.ibizsys.model.control.form.IPSDEFormDetail
 *  net.ibizsys.model.control.form.IPSDEFormItem
 *  net.ibizsys.model.control.form.IPSDEWizardEditForm
 *  net.ibizsys.model.dataentity.field.IPSDEField
 *  net.ibizsys.model.dataentity.wizard.IPSDEWizardForm
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.control.form;

import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.control.form.IPSDEEditForm;
import net.ibizsys.model.control.form.IPSDEFormDetail;
import net.ibizsys.model.control.form.IPSDEFormItem;
import net.ibizsys.model.control.form.IPSDEWizardEditForm;
import net.ibizsys.model.control.form.PSDEEditFormParamImpl;
import net.ibizsys.model.control.form.PSDEFormImpl;
import net.ibizsys.model.control.form.PSDEFormParamImpl;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.wizard.IPSDEWizardForm;
import net.ibizsys.model.entity.PSDEFormDetail;
import net.ibizsys.paas.util.StringHelper;

public class PSDEEditFormImpl
extends PSDEFormImpl
implements IPSDEEditForm,
IPSDEWizardEditForm {
    public static final String PFSTYLEPARAM_EDITFORM_LABLEWIDTH = "EDITFORM.LABLEWIDTH";
    protected PSDEEditFormParamImpl psDEEditFormParamImpl = null;
    private IPSDEWizardForm iPSDEWizardForm = null;
    private boolean bShowFormNavBar = false;
    private boolean bInfoFormMode = false;

    @Override
    protected void onInit() throws Exception {
        if (!this.psDEForm.isINFOFORMFLAGNull()) {
            this.bInfoFormMode = this.psDEForm.getINFOFORMFLAG();
        } else if (!StringHelper.isNullOrEmpty((String)this.getFormStyle()) && this.getFormStyle().indexOf("INFOPANEL") != -1) {
            this.bInfoFormMode = true;
        }
        super.onInit();
    }

    @PSModelRTMeta(description="\u90e8\u4ef6\u7c7b\u578b")
    public String getControlType() {
        return "FORM";
    }

    @Override
    protected void onPreparePSDEFormLayout() throws Exception {
        if (!this.isDesignMode() && StringHelper.compare((String)this.getFormFuncMode(), (String)"WIZARDFORM", (boolean)true) == 0) {
            this.iPSDEWizardForm = this.psDEEditFormParamImpl.getPSDEWizardForm();
            if (this.iPSDEWizardForm == null) {
                throw new Exception("\u5411\u5bfc\u8868\u5355\u6ca1\u6709\u6307\u5b9a\u76f8\u5e94\u53c2\u6570");
            }
        }
        if (!this.psDEForm.isFORMNAVBARNull()) {
            this.bShowFormNavBar = this.psDEForm.getFORMNAVBAR();
        }
        super.onPreparePSDEFormLayout();
    }

    @Override
    protected PSDEFormParamImpl createPSDEFormParamImpl() {
        this.psDEEditFormParamImpl = new PSDEEditFormParamImpl();
        return this.psDEEditFormParamImpl;
    }

    @Override
    protected void onPreparePSDEFormItems() throws Exception {
        IPSDEField updateDataPSDEField;
        IPSDEFormDetail iPSDEFormDetail;
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
            IPSDEFormDetail iPSDEFormDetail2 = this.getPSModelStorageContext().createPSDEFormDetail(this, null, psDEFormDetail2);
            privPSDEFormItemList.add(0, (IPSDEFormItem)iPSDEFormDetail2);
        }
        for (IPSDEFormItem iPSDEFormItem : privPSDEFormItemList) {
            this.psDEFormItemList.add(0, iPSDEFormItem);
        }
        if (!this.psDEFormItemMap.containsKey("srfsourcekey")) {
            psDEFormDetail = new PSDEFormDetail();
            psDEFormDetail.setPSDEID(this.getPSDataEntity().getId());
            psDEFormDetail.setFORMTYPE(this.getControlType());
            psDEFormDetail.setPSDEFORMDETAILID("srfsourcekey");
            psDEFormDetail.setPSDEFORMDETAILNAME("srfsourcekey");
            psDEFormDetail.setEDITORTYPE("HIDDEN");
            psDEFormDetail.setDETAILTYPE("FORMITEM");
            iPSDEFormDetail = this.getPSModelStorageContext().createPSDEFormDetail(this, null, psDEFormDetail);
            this.psDEFormItemList.add(0, (IPSDEFormItem)iPSDEFormDetail);
        }
        if (!this.psDEFormItemMap.containsKey("srfdeid")) {
            psDEFormDetail = new PSDEFormDetail();
            psDEFormDetail.setPSDEID(this.getPSDataEntity().getId());
            psDEFormDetail.setFORMTYPE(this.getControlType());
            psDEFormDetail.setPSDEFORMDETAILID("srfdeid");
            psDEFormDetail.setPSDEFORMDETAILNAME("srfdeid");
            psDEFormDetail.setEDITORTYPE("HIDDEN");
            psDEFormDetail.setDETAILTYPE("FORMITEM");
            iPSDEFormDetail = this.getPSModelStorageContext().createPSDEFormDetail(this, null, psDEFormDetail);
            this.psDEFormItemList.add(0, (IPSDEFormItem)iPSDEFormDetail);
        }
        if (!this.psDEFormItemMap.containsKey("srfuf")) {
            psDEFormDetail = new PSDEFormDetail();
            psDEFormDetail.setPSDEID(this.getPSDataEntity().getId());
            psDEFormDetail.setFORMTYPE(this.getControlType());
            psDEFormDetail.setPSDEFORMDETAILID("srfuf");
            psDEFormDetail.setPSDEFORMDETAILNAME("srfuf");
            psDEFormDetail.setEDITORTYPE("HIDDEN");
            psDEFormDetail.setDETAILTYPE("FORMITEM");
            iPSDEFormDetail = this.getPSModelStorageContext().createPSDEFormDetail(this, null, psDEFormDetail);
            this.psDEFormItemList.add(0, (IPSDEFormItem)iPSDEFormDetail);
        }
        if (!this.psDEFormItemMap.containsKey("srftempmode")) {
            psDEFormDetail = new PSDEFormDetail();
            psDEFormDetail.setPSDEID(this.getPSDataEntity().getId());
            psDEFormDetail.setFORMTYPE(this.getControlType());
            psDEFormDetail.setPSDEFORMDETAILID("srftempmode");
            psDEFormDetail.setPSDEFORMDETAILNAME("srftempmode");
            psDEFormDetail.setEDITORTYPE("HIDDEN");
            psDEFormDetail.setDETAILTYPE("FORMITEM");
            iPSDEFormDetail = this.getPSModelStorageContext().createPSDEFormDetail(this, null, psDEFormDetail);
            this.psDEFormItemList.add(0, (IPSDEFormItem)iPSDEFormDetail);
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
            iPSDEFormDetail = this.getPSModelStorageContext().createPSDEFormDetail(this, null, psDEFormDetail);
            this.psDEFormItemList.add(0, (IPSDEFormItem)iPSDEFormDetail);
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
            iPSDEFormDetail = this.getPSModelStorageContext().createPSDEFormDetail(this, null, psDEFormDetail);
            this.psDEFormItemList.add(0, (IPSDEFormItem)iPSDEFormDetail);
        }
        if (!this.psDEFormItemMap.containsKey("srforikey")) {
            psDEFormDetail = new PSDEFormDetail();
            psDEFormDetail.setPSDEID(this.getPSDataEntity().getId());
            psDEFormDetail.setFORMTYPE(this.getControlType());
            psDEFormDetail.setPSDEFORMDETAILID("srforikey");
            psDEFormDetail.setPSDEFORMDETAILNAME("srforikey");
            psDEFormDetail.setEDITORTYPE("HIDDEN");
            psDEFormDetail.setDETAILTYPE("FORMITEM");
            iPSDEFormDetail = this.getPSModelStorageContext().createPSDEFormDetail(this, null, psDEFormDetail);
            this.psDEFormItemList.add(0, (IPSDEFormItem)iPSDEFormDetail);
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
            IPSDEFormDetail iPSDEFormDetail3 = this.getPSModelStorageContext().createPSDEFormDetail(this, null, psDEFormDetail3);
            this.psDEFormItemList.add(0, (IPSDEFormItem)iPSDEFormDetail3);
        }
    }

    @Override
    protected void fillExtPSDEFormItems(HashMap<String, IPSDEFormItem> psDEFFormItemMap, HashMap<String, String> createItemMap) throws Exception {
        super.fillExtPSDEFormItems(psDEFFormItemMap, createItemMap);
        if (!psDEFFormItemMap.containsKey(this.getPSDataEntity().getKeyDEField().getName().toLowerCase())) {
            createItemMap.put(this.getPSDataEntity().getKeyDEField().getName().toLowerCase(), "");
        }
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u5411\u5bfc\u8868\u5355\u5bf9\u8c61", hideempty2=true)
    public IPSDEWizardForm getPSDEWizardForm() {
        return this.iPSDEWizardForm;
    }

    @PSModelRTMeta(description="\u663e\u793a\u8868\u5355\u5bfc\u822a\u680f")
    public boolean isShowFormNavBar() {
        return this.bShowFormNavBar;
    }

    @PSModelRTMeta(description="\u4fe1\u606f\u8868\u5355")
    public boolean isInfoFormMode() {
        return this.bInfoFormMode;
    }
}

