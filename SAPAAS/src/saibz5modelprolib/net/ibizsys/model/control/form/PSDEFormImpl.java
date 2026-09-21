/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.IPSModelJsonExporter
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.app.view.IPSAppViewRef
 *  net.ibizsys.model.codelist.IPSCodeList
 *  net.ibizsys.model.control.IPSAjaxControlParam
 *  net.ibizsys.model.control.IPSControlContainer
 *  net.ibizsys.model.control.IPSControlParam
 *  net.ibizsys.model.control.form.IPSDEForm
 *  net.ibizsys.model.control.form.IPSDEFormDRUIPart
 *  net.ibizsys.model.control.form.IPSDEFormDetail
 *  net.ibizsys.model.control.form.IPSDEFormItem
 *  net.ibizsys.model.control.form.IPSDEFormItemUpdate
 *  net.ibizsys.model.control.form.IPSDEFormItemVR
 *  net.ibizsys.model.control.form.IPSDEFormPage
 *  net.ibizsys.model.control.form.IPSDEFormParam
 *  net.ibizsys.model.dataentity.field.IPSDEField
 *  net.ibizsys.paas.control.form.IFormItem
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.form;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.model.IPSModelJsonExporter;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSAppViewRef;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.control.IPSAjaxControlParam;
import net.ibizsys.model.control.IPSControlContainer;
import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.control.PSAjaxControlImpl;
import net.ibizsys.model.control.form.IPSDEForm;
import net.ibizsys.model.control.form.IPSDEFormDRUIPart;
import net.ibizsys.model.control.form.IPSDEFormDetail;
import net.ibizsys.model.control.form.IPSDEFormDetailRuntime;
import net.ibizsys.model.control.form.IPSDEFormItem;
import net.ibizsys.model.control.form.IPSDEFormItemUpdate;
import net.ibizsys.model.control.form.IPSDEFormItemVR;
import net.ibizsys.model.control.form.IPSDEFormPage;
import net.ibizsys.model.control.form.IPSDEFormParam;
import net.ibizsys.model.control.form.IPSDEFormRuntime;
import net.ibizsys.model.control.form.PSDEFormItemUpdateImpl;
import net.ibizsys.model.control.form.PSDEFormItemVRImpl;
import net.ibizsys.model.control.form.PSDEFormParamImpl;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.entity.PSDEFDLogic;
import net.ibizsys.model.entity.PSDEFIUDetail;
import net.ibizsys.model.entity.PSDEFIUpdate;
import net.ibizsys.model.entity.PSDEForm;
import net.ibizsys.model.entity.PSDEFormDetail;
import net.ibizsys.model.entity.PSDEFormItemVR;
import net.ibizsys.model.pf.IPSPF;
import net.ibizsys.paas.control.form.IFormItem;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDEFormImpl
extends PSAjaxControlImpl
implements IPSDEForm,
IPSDEFormRuntime {
    private static final Log log = LogFactory.getLog(PSDEFormImpl.class);
    protected PSDEForm psDEForm;
    protected ArrayList<IPSDEFormPage> psDEFormPageList = new ArrayList();
    protected ArrayList<IPSDEFormItem> psDEFormItemList = new ArrayList();
    protected ArrayList<IPSDEFormDetail> psDEFormDetailList = new ArrayList();
    protected HashMap<String, IPSDEFormItem> psDEFormItemMap = new HashMap();
    protected ArrayList<IPSDEFormDRUIPart> psDEFormDRUIPartList = new ArrayList();
    protected HashMap<String, IPSDEFormItemUpdate> psDEFormItemUpdateMap = new HashMap();
    protected HashMap<String, IPSDEFormItemVR> psDEFormItemVRMap = new HashMap();
    protected ArrayList<IFormItem> formItemList = new ArrayList();
    protected HashMap<String, PSDEFormDetail> formPartDetailMap = new HashMap();
    protected double fFormWidth = 1.0;
    protected PSDEFormParamImpl psDEFormParamImpl = null;
    private String strCodeName = "";
    protected String strLayoutMode = "";
    private int nColumnCount = 0;
    protected int nLabelColSpan = 1;
    protected int nCtrlColSpan = 2;
    private int nFirstLabelColSpan = 2;
    private String strFormFuncMode = "";
    protected int nLabelWidth = 130;
    private Boolean bShowTabHeader = null;
    private String strFormStyle = "";

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSControlContainer(iPSControlContainer);
            IPSDEFormParam iPSDEFormParam = (IPSDEFormParam)iPSControlParam;
            this.psDEForm = new PSDEForm();
            CallResult callResult = this.getPSModelQueryHelper().getPSDEForm(iPSDEFormParam.getPSDEFormId(), this.psDEForm);
            if (callResult.isError()) {
                throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u5b9e\u4f53\u8868\u5355\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            this.setId(this.psDEForm.getPSDEFORMID());
            this.setName(strName);
            this.setLogicName(this.psDEForm.getPSDEFORMNAME());
            this.setPSObjectData(this.psDEForm);
            if (this.getPSDataEntity() != null) {
                if (StringHelper.compare((String)this.psDEForm.getPSDEID(), (String)this.getPSDataEntity().getId(), (boolean)true) != 0) {
                    this.setPSDataEntity(this.getPSDataEntity().getPSSystem().getPSDataEntity(this.psDEForm.getPSDEID()));
                }
            } else {
                this.setPSDataEntity(this.getPSAppView().getPSSystem().getPSDataEntity(this.psDEForm.getPSDEID()));
            }
            if (this.getId().indexOf("SRFTEMPKEY:") == 0) {
                this.setDesignMode(true);
            }
            this.psDEFormParamImpl = this.createPSDEFormParamImpl();
            this.psDEFormParamImpl.setPSAjaxControlHandlerId(this.psDEForm.getPSACHANDLERID());
            this.psDEFormParamImpl.merge(iPSControlParam);
            if (!this.psDEForm.isFORMWIDTHNull()) {
                this.fFormWidth = this.psDEForm.getFORMWIDTH();
            }
            this.strCodeName = this.psDEForm.getCODENAME();
            if (StringHelper.isNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.getName();
            }
            if (!StringHelper.isNullOrEmpty((String)this.strCodeName)) {
                String strHeader = this.strCodeName.substring(0, 1).toUpperCase();
                this.strCodeName = String.valueOf(strHeader) + this.strCodeName.substring(1);
            }
            this.strFormFuncMode = this.psDEForm.getFUNCMODE();
            if (!this.psDEForm.isSHOWTABHEADERNull()) {
                this.bShowTabHeader = this.psDEForm.getSHOWTABHEADER();
            }
            this.strFormStyle = this.psDEForm.getFORMSTYLE();
            super.init(iPSModelStorageContext, iPSControlContainer, strName, this.psDEFormParamImpl);
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    protected PSDEFormParamImpl createPSDEFormParamImpl() {
        return new PSDEFormParamImpl();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.onPreparePSDEFormLayout();
        this.onPreparePSDEFormItemUpdates();
        this.onPreparePSDEFormDetails();
        this.onPreparePSDEFormItems();
        this.onPreparePSDEFormDRUIParts();
        this.onPreparePSDEFormItemVRs();
        this.formItemList.clear();
        this.formItemList.addAll(this.psDEFormItemList);
        for (IPSDEFormPage iPSDEFormPage : this.psDEFormPageList) {
            ((IPSDEFormDetailRuntime)iPSDEFormPage).layout();
        }
    }

    protected void onPreparePSDEFormLayout() throws Exception {
        this.strLayoutMode = this.psDEForm.getLAYOUTMODE();
        if (StringHelper.isNullOrEmpty((String)this.strLayoutMode)) {
            this.strLayoutMode = this.getPSAppView().getPSApplication().getPSApplicationUI().getFormLayoutMode();
            String strPFType = null;
            if (StringHelper.isNullOrEmpty(strPFType)) {
                strPFType = this.getPSAppView().getPSApplication().getPFType();
            }
            IPSPF iPSPF = this.getPSModelStorageContext().getPSPF(strPFType);
            this.strLayoutMode = iPSPF.getFormLayoutMode();
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
    }

    protected void onPreparePSDEFormDetails() throws Exception {
        this.psDEFormPageList.clear();
        this.formPartDetailMap.clear();
        this.onPreparePSDEFormDetails(this.getId());
    }

    protected void onPreparePSDEFormDetails(String strPSDEFormId) throws Exception {
        Vector<PSDEFormDetail> psDEFormPageList = new Vector<PSDEFormDetail>();
        CallResult callResult = this.getPSModelQueryHelper().getPSDEFormDetails(strPSDEFormId, psDEFormPageList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u8868\u5355\u6210\u5458\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, PSDEFormDetail> psDEFormDetailMap = new HashMap<String, PSDEFormDetail>();
        for (PSDEFormDetail psDEFormDetail : psDEFormPageList) {
            psDEFormDetailMap.put(psDEFormDetail.getPSDEFORMDETAILID(), psDEFormDetail);
            if (StringHelper.compare((String)strPSDEFormId, (String)this.getId(), (boolean)true) == 0) continue;
            this.formPartDetailMap.put(psDEFormDetail.getPSDEFORMDETAILID(), psDEFormDetail);
        }
        for (PSDEFormDetail psDEFormDetail : psDEFormPageList) {
            if (StringHelper.isNullOrEmpty((String)psDEFormDetail.getPPSDEFORMDETAILID())) continue;
            PSDEFormDetail psDEFormDetail2 = psDEFormDetail;
            Object parentPSDEFormDetail = (PSDEFormDetail)((Object)psDEFormDetailMap.get(psDEFormDetail.getPPSDEFORMDETAILID()));
            if (parentPSDEFormDetail == null) {
                if (StringHelper.compare((String)this.getId(), (String)strPSDEFormId, (boolean)false) == 0) {
                    throw new Exception(StringHelper.format((String)"\u8868\u5355[%1$s]\u6210\u5458[%2$s]\u7236\u5bf9\u8c61\u65e0\u6548", (Object)this.getLogicName(), (Object)psDEFormDetail2.getPSDEFORMDETAILNAME()));
                }
                PSDEForm psDEForm = new PSDEForm();
                this.getPSModelQueryHelper().getPSDEForm(psDEFormDetail2.getPSDEFORMID(), psDEForm);
                throw new Exception(StringHelper.format((String)"\u8868\u5355[%1$s]\u6210\u5458[%2$s]\u7236\u5bf9\u8c61\u65e0\u6548", (Object)psDEForm.getPSDEFORMNAME(), (Object)psDEFormDetail2.getPSDEFORMDETAILNAME()));
            }
            if (StringHelper.compare((String)psDEFormDetail.getDETAILTYPE(), (String)"FORMPART", (boolean)true) == 0 && (psDEFormDetail = this.formPartDetailMap.get(psDEFormDetail.getREFPSDEFORMDETAILID())) != null && StringHelper.compare((String)psDEFormDetail.getDETAILTYPE(), (String)"FORMPAGE", (boolean)true) == 0) {
                psDEFormDetail.setDETAILTYPE("GROUPPANEL");
                psDEFormDetail.setSHOWCAPTION(false);
            }
            if (psDEFormDetail == null) {
                if (StringHelper.compare((String)this.getId(), (String)strPSDEFormId, (boolean)false) == 0) {
                    throw new Exception(StringHelper.format((String)"\u8868\u5355[%1$s]\u6210\u5458[%2$s]\u5f15\u7528\u8868\u5355\u65e0\u6548", (Object)this.getLogicName(), (Object)psDEFormDetail2.getPSDEFORMDETAILNAME()));
                }
                PSDEForm psDEForm = new PSDEForm();
                this.getPSModelQueryHelper().getPSDEForm(psDEFormDetail2.getPSDEFORMID(), psDEForm);
                throw new Exception(StringHelper.format((String)"\u8868\u5355[%1$s]\u6210\u5458[%2$s]\u5f15\u7528\u8868\u5355\u65e0\u6548", (Object)psDEForm.getPSDEFORMNAME(), (Object)psDEFormDetail2.getPSDEFORMDETAILNAME()));
            }
            parentPSDEFormDetail.getChildPSDEFormDetails(true).add(psDEFormDetail);
        }
        Vector<PSDEFDLogic> psDEFDLogicList = new Vector<PSDEFDLogic>();
        callResult = this.getPSModelQueryHelper().getPSDEFDLogics(strPSDEFormId, psDEFDLogicList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u8868\u5355\u6210\u5458\u903b\u8f91\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, PSDEFDLogic> psDEFDLogicMap = new HashMap<String, PSDEFDLogic>();
        for (PSDEFDLogic psDEFDLogic : psDEFDLogicList) {
            psDEFDLogicMap.put(psDEFDLogic.getPSDEFDLOGICID(), psDEFDLogic);
        }
        for (PSDEFDLogic psDEFDLogic : psDEFDLogicList) {
            PSDEFDLogic parentPSDEFDLogic;
            if (StringHelper.isNullOrEmpty((String)psDEFDLogic.getPPSDEFDLOGICID()) || (parentPSDEFDLogic = (PSDEFDLogic)((Object)psDEFDLogicMap.get(psDEFDLogic.getPPSDEFDLOGICID()))) == null) continue;
            parentPSDEFDLogic.getChildPSDEFDLogics(true).add(psDEFDLogic);
        }
        for (PSDEFDLogic psDEFDLogic : psDEFDLogicList) {
            PSDEFormDetail psDEFormDetail;
            if (!StringHelper.isNullOrEmpty((String)psDEFDLogic.getPPSDEFDLOGICID()) || (psDEFormDetail = (PSDEFormDetail)((Object)psDEFormDetailMap.get(psDEFDLogic.getPSDEFORMDETAILID()))) == null) continue;
            psDEFormDetail.getChildPSDEFDLogics(psDEFDLogic.getLOGICCAT(), true).add(psDEFDLogic);
        }
        if (StringHelper.compare((String)strPSDEFormId, (String)this.getId(), (boolean)true) == 0) {
            int nIndex = 0;
            for (PSDEFormDetail psDEFormDetail : psDEFormPageList) {
                if (!StringHelper.isNullOrEmpty((String)psDEFormDetail.getPPSDEFORMDETAILID()) || StringHelper.compare((String)psDEFormDetail.getDETAILTYPE(), (String)"FORMPAGE", (boolean)true) != 0) continue;
                psDEFormDetail.set("PAGEINDEX", nIndex);
                IPSDEFormDetail iPSDEFormDetail = this.getPSModelStorageContext().createPSDEFormDetail(this, null, psDEFormDetail);
                this.psDEFormPageList.add((IPSDEFormPage)iPSDEFormDetail);
                ++nIndex;
            }
            for (PSDEFormDetail psDEFormDetail : psDEFormPageList) {
                psDEFormDetail.resetChildDatas();
            }
        } else {
            boolean nIndex = false;
            nIndex = false;
        }
    }

    protected void onPreparePSDEFormItems() throws Exception {
        this.psDEFormItemList.clear();
        this.psDEFormItemMap.clear();
        this.psDEFormDetailList.clear();
        for (IPSDEFormPage iPSDEFormPage : this.psDEFormPageList) {
            ((IPSDEFormDetailRuntime)iPSDEFormPage).fillPSDEFormItems(this.psDEFormItemList);
        }
        for (IPSDEFormPage iPSDEFormPage : this.psDEFormPageList) {
            ((IPSDEFormDetailRuntime)iPSDEFormPage).fillPSDEFormDetails(this.psDEFormDetailList);
        }
        HashMap<String, IPSDEFormItem> psDEFFormItemMap = new HashMap<String, IPSDEFormItem>();
        for (IPSDEFormItem iPSDEFormItem : this.psDEFormItemList) {
            psDEFFormItemMap.put(iPSDEFormItem.getName(), iPSDEFormItem);
        }
        HashMap<String, String> createItemMap = new HashMap<String, String>();
        for (IPSDEFormItem iPSDEFormItem : this.psDEFormItemList) {
            String strValueItemName = iPSDEFormItem.getValueItemName();
            if (StringHelper.isNullOrEmpty((String)strValueItemName) || psDEFFormItemMap.containsKey(strValueItemName.toLowerCase())) continue;
            createItemMap.put(strValueItemName, "");
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
            IPSDEFormDetail iPSDEFormDetail = this.getPSModelStorageContext().createPSDEFormDetail(this, null, psDEFormDetail);
            this.psDEFormItemList.add((IPSDEFormItem)iPSDEFormDetail);
        }
        for (IPSDEFormItem iPSDEFormItem : this.psDEFormItemList) {
            this.psDEFormItemMap.put(iPSDEFormItem.getId(), iPSDEFormItem);
            this.psDEFormItemMap.put(iPSDEFormItem.getName(), iPSDEFormItem);
        }
    }

    protected void onPreparePSDEFormDRUIParts() throws Exception {
        this.psDEFormDRUIPartList.clear();
        for (IPSDEFormPage iPSDEFormPage : this.psDEFormPageList) {
            ((IPSDEFormDetailRuntime)iPSDEFormPage).fillPSDEFormDRUIParts(this.psDEFormDRUIPartList);
        }
    }

    protected void onPreparePSDEFormItemUpdates() throws Exception {
        this.psDEFormItemUpdateMap.clear();
        this.onPreparePSDEFormItemUpdates(this.getId());
    }

    protected void onPreparePSDEFormItemUpdates(String strPSDEFormId) throws Exception {
        Vector<PSDEFIUpdate> psDEFIUpdateList = new Vector<PSDEFIUpdate>();
        CallResult callResult = this.getPSModelQueryHelper().getPSDEFIUpdates(strPSDEFormId, psDEFIUpdateList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u8868\u5355\u9879\u66f4\u65b0\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, PSDEFIUpdate> psDEFIUpdateMap = new HashMap<String, PSDEFIUpdate>();
        for (PSDEFIUpdate psDEFIUpdate : psDEFIUpdateList) {
            psDEFIUpdateMap.put(psDEFIUpdate.getPSDEFIUPDATEID(), psDEFIUpdate);
        }
        Vector<PSDEFIUDetail> psDEFIUDetailList = new Vector<PSDEFIUDetail>();
        callResult = this.getPSModelQueryHelper().getPSDEFIUDetails(strPSDEFormId, psDEFIUDetailList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u8868\u5355\u9879\u66f4\u65b0\u6210\u5458\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEFIUDetail psDEFIUDetail : psDEFIUDetailList) {
            PSDEFIUpdate psDEFIUpdate = (PSDEFIUpdate)((Object)psDEFIUpdateMap.get(psDEFIUDetail.getPSDEFIUPDATEID()));
            if (psDEFIUpdate == null) continue;
            psDEFIUpdate.getPSDEFIUDetails(true).add(psDEFIUDetail);
        }
        for (PSDEFIUpdate psDEFIUpdate : psDEFIUpdateList) {
            PSDEFormItemUpdateImpl psDEFIUpdateImpl = new PSDEFormItemUpdateImpl();
            psDEFIUpdateImpl.init(this.getPSModelStorageContext(), this, psDEFIUpdate);
            this.psDEFormItemUpdateMap.put(psDEFIUpdateImpl.getId(), psDEFIUpdateImpl);
        }
    }

    protected void onPreparePSDEFormItemVRs() throws Exception {
        this.psDEFormItemVRMap.clear();
        this.onPreparePSDEFormItemVRs(this.getId());
    }

    protected void onPreparePSDEFormItemVRs(String strPSDEFormId) throws Exception {
        Vector<PSDEFormItemVR> psDEFormItemVRList = new Vector<PSDEFormItemVR>();
        CallResult callResult = this.getPSModelQueryHelper().getPSDEFormItemVRs(strPSDEFormId, psDEFormItemVRList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u8868\u5355\u9879\u503c\u89c4\u5219\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEFormItemVR psDEFormItemVR : psDEFormItemVRList) {
            PSDEFormItemVRImpl psDEFormItemVRImpl = new PSDEFormItemVRImpl();
            psDEFormItemVRImpl.init(this.getPSModelStorageContext(), this, psDEFormItemVR);
            this.psDEFormItemVRMap.put(psDEFormItemVRImpl.getId(), psDEFormItemVRImpl);
        }
    }

    protected void fillExtPSDEFormItems(HashMap<String, IPSDEFormItem> psDEFFormItemMap, HashMap<String, String> createItemMap) throws Exception {
    }

    @PSModelRTMeta(description="\u8868\u5355\u5206\u9875\u96c6\u5408")
    public Iterator<IPSDEFormPage> getPSDEFormPages() {
        return this.psDEFormPageList.iterator();
    }

    public Iterator<IFormItem> getFormItems() {
        return this.formItemList.iterator();
    }

    @PSModelRTMeta(description="\u8868\u5355\u9879\u96c6\u5408")
    public Iterator<IPSDEFormItem> getPSDEFormItems() {
        return this.psDEFormItemList.iterator();
    }

    @PSModelRTMeta(description="\u9ed8\u8ba4\u6807\u7b7e\u5bbd\u5ea6")
    public int getDefaultLabelWidth() {
        return this.nLabelWidth;
    }

    @PSModelRTMeta(description="\u9690\u85cf\u5206\u9875\u5934\u90e8")
    public boolean isNoTabHeader() {
        if (this.bShowTabHeader == null) {
            return this.psDEFormPageList.size() == 1;
        }
        return this.bShowTabHeader == false;
    }

    @PSModelRTMeta(description="\u8868\u5355\u5bbd\u5ea6")
    public double getFormWidth() {
        return this.fFormWidth;
    }

    @Override
    public IPSAjaxControlParam getPSAjaxControlParam() {
        return this.psDEFormParamImpl;
    }

    public IFormItem getFormItem(String strName, boolean bTryMode) throws Exception {
        return null;
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        super.fillRelatedPSAppViews(relatedAppViewList);
        for (IPSDEFormPage iPSDEFormPage : this.psDEFormPageList) {
            ((IPSDEFormDetailRuntime)iPSDEFormPage).fillRelatedPSAppViews(relatedAppViewList);
        }
    }

    @PSModelRTMeta(description="\u8868\u5355\u5173\u7cfb\u90e8\u4ef6\u96c6\u5408")
    public Iterator<IPSDEFormDRUIPart> getPSDEFormDRUIParts() {
        if (this.psDEFormDRUIPartList == null || this.psDEFormDRUIPartList.size() == 0) {
            return null;
        }
        return this.psDEFormDRUIPartList.iterator();
    }

    @PSModelRTMeta(description="\u8868\u5355\u9879\u66f4\u65b0\u96c6\u5408")
    public Iterator<IPSDEFormItemUpdate> getPSDEFormItemUpdates() {
        return this.psDEFormItemUpdateMap.values().iterator();
    }

    public IPSDEFormItemUpdate getPSDEFormItemUpdate(String strPSDEFormItemUpdateId) throws Exception {
        IPSDEFormItemUpdate iPSDEFormItemUpdate = this.psDEFormItemUpdateMap.get(strPSDEFormItemUpdateId);
        if (strPSDEFormItemUpdateId == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u8868\u5355\u9879\u66f4\u65b0[%1$s]", (Object)strPSDEFormItemUpdateId));
        }
        return iPSDEFormItemUpdate;
    }

    @PSModelRTMeta(description="\u884c\u9996\u6807\u9898\u9ed8\u8ba4\u5217\u6570")
    public int getFirstLabelColSpan() {
        return this.nFirstLabelColSpan;
    }

    @PSModelRTMeta(description="\u6807\u9898\u9ed8\u8ba4\u5217\u6570")
    public int getLabelColSpan() {
        return this.nLabelColSpan;
    }

    @PSModelRTMeta(description="\u63a7\u4ef6\u9ed8\u8ba4\u5217\u6570")
    public int getCtrlColSpan() {
        return this.nCtrlColSpan;
    }

    @PSModelRTMeta(description="\u5e03\u5c40\u6a21\u5f0f", codelist="FormDetailLayoutMode")
    public String getLayoutMode() {
        return this.strLayoutMode;
    }

    @Override
    public void fillEmbeddedPSAppViewRefs(String strContainerId, ArrayList<IPSAppViewRef> embeddedPSAppViewRefList) throws Exception {
        super.fillEmbeddedPSAppViewRefs(strContainerId, embeddedPSAppViewRefList);
        for (IPSDEFormPage iPSDEFormPage : this.psDEFormPageList) {
            ((IPSDEFormDetailRuntime)iPSDEFormPage).fillEmbeddedPSAppViewRefs(strContainerId, embeddedPSAppViewRefList);
        }
    }

    @Override
    public void fillRelatedPSCodeLists(ArrayList<IPSCodeList> relatedPSCodeListList) throws Exception {
        for (IPSDEFormItem iPSDEFormItem : this.psDEFormItemList) {
            if (iPSDEFormItem.getPSCodeList() == null) continue;
            relatedPSCodeListList.add(iPSDEFormItem.getPSCodeList());
        }
    }

    @PSModelRTMeta(description="\u8868\u5355\u529f\u80fd\u6a21\u5f0f", hideempty2=true)
    public String getFormFuncMode() {
        return this.strFormFuncMode;
    }

    @PSModelRTMeta(description="\u8868\u5355\u9879\u503c\u89c4\u5219\u96c6\u5408")
    public Iterator<IPSDEFormItemVR> getPSDEFormItemVRs() {
        return this.psDEFormItemVRMap.values().iterator();
    }

    public IPSDEFormItemVR getPSDEFormItemVR(String strPSDEFormItemVRId) throws Exception {
        IPSDEFormItemVR iPSDEFormItemVR = this.psDEFormItemVRMap.get(strPSDEFormItemVRId);
        if (strPSDEFormItemVRId == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u8868\u5355\u9879\u503c\u89c4\u5219[%1$s]", (Object)strPSDEFormItemVRId));
        }
        return iPSDEFormItemVR;
    }

    public IPSDEFormItem getPSDEFormItem(String strPSDEFormItemId) throws Exception {
        IPSDEFormItem iPSDEFormItem = this.psDEFormItemMap.get(strPSDEFormItemId);
        if (strPSDEFormItemId == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u8868\u5355\u9879[%1$s]", (Object)strPSDEFormItemId));
        }
        return iPSDEFormItem;
    }

    public Iterator<IPSDEFormDetail> getPSDEFormDetails() {
        return this.psDEFormDetailList.iterator();
    }

    @PSModelRTMeta(description="\u8868\u5355\u6837\u5f0f")
    public String getFormStyle() {
        return this.strFormStyle;
    }

    public int getPSDEFormPageCount() {
        return this.psDEFormPageList.size();
    }

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
    protected void onFillJsonObject(ObjectNode objectNode) throws Exception {
        super.onFillJsonObject(objectNode);
        ArrayList<ObjectNode> itemList = new ArrayList<ObjectNode>();
        Iterator<IPSDEFormPage> psDEFormPages = this.getPSDEFormPages();
        while (psDEFormPages.hasNext()) {
            IPSDEFormPage iPSDEFormPage = psDEFormPages.next();
            ObjectNode psDEFormPageObjectNode = ((IPSModelJsonExporter)iPSDEFormPage).toJsonObject(null);
            itemList.add(psDEFormPageObjectNode);
        }
        JsonNodeHelper.put((ObjectNode)objectNode, (String)"items", itemList);
    }
}

