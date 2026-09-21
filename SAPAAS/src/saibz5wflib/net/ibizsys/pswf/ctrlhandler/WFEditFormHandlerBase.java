/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.core.IDEWF
 *  net.ibizsys.paas.ctrlhandler.EditFormHandlerBase
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.util.DateHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.AjaxActionResult
 *  net.ibizsys.paas.web.FormAjaxActionResult
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 *  net.ibizsys.pswf.core.IWFModel
 *  net.ibizsys.pswf.core.IWFProcessModel
 *  net.ibizsys.pswf.core.IWFService
 *  net.ibizsys.pswf.core.IWFVersionModel
 *  net.ibizsys.pswf.core.WFActionParam
 *  net.ibizsys.pswf.core.WFActionResult
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pswf.ctrlhandler;

import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.IDEWF;
import net.ibizsys.paas.ctrlhandler.EditFormHandlerBase;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.FormAjaxActionResult;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pswf.controller.IWFDEViewController;
import net.ibizsys.pswf.controller.IWFViewController;
import net.ibizsys.pswf.core.IWFInteractiveLinkModel;
import net.ibizsys.pswf.core.IWFInteractiveProcessModel;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFProcessModel;
import net.ibizsys.pswf.core.IWFService;
import net.ibizsys.pswf.core.IWFVersionModel;
import net.ibizsys.pswf.core.WFActionParam;
import net.ibizsys.pswf.core.WFActionResult;
import net.ibizsys.pswf.ctrlhandler.IWFEditFormHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class WFEditFormHandlerBase
extends EditFormHandlerBase
implements IWFEditFormHandler {
    private static final Log log = LogFactory.getLog(WFEditFormHandlerBase.class);

    protected IDEWF getDEWF() {
        if (this.getViewController() instanceof IWFDEViewController) {
            return ((IWFDEViewController)this.getViewController()).getDEWF();
        }
        return null;
    }

    protected boolean isWFIAMode() {
        if (this.getViewController() instanceof IWFViewController) {
            return ((IWFViewController)this.getViewController()).isWFIAMode();
        }
        return false;
    }

    protected IWFModel getWFModel() {
        if (this.getViewController() instanceof IWFViewController) {
            return ((IWFViewController)this.getViewController()).getWFModel();
        }
        return null;
    }

    protected IWFVersionModel getWFVersionModel() {
        return this.getWFModel().getLastWFVersionModel();
    }

    protected String getWFStepValue() {
        if (this.getViewController() instanceof IWFViewController) {
            return ((IWFViewController)this.getViewController()).getWFStepValue();
        }
        return "";
    }

    protected AjaxActionResult onProcessAction(String strAction) throws Exception {
        if (StringHelper.compare((String)strAction, (String)"wfstart", (boolean)true) == 0) {
            return this.onWFStart();
        }
        if (StringHelper.compare((String)strAction, (String)"wfsubmit", (boolean)true) == 0) {
            return this.onWFSubmit();
        }
        return super.onProcessAction(strAction);
    }

    protected AjaxActionResult onWFStart() throws Exception {
        FormAjaxActionResult formAjaxActionResult = new FormAjaxActionResult();
        this.getWebContext().setCurAjaxActionResult((AjaxActionResult)formAjaxActionResult);
        String strKey = WebContext.getRealKey((IWebContext)this.getWebContext());
        if (StringHelper.isNullOrEmpty((String)strKey)) {
            formAjaxActionResult.setRetCode(4);
            return formAjaxActionResult;
        }
        String strDataAccessAction = this.getDataAccessAction("wfstart");
        CallResult callResult = this.testDataAccessAction(strKey, strDataAccessAction);
        if (!callResult.isOk()) {
            formAjaxActionResult.setRetCode(2);
            formAjaxActionResult.setErrorInfo(callResult.getErrorInfo());
            return formAjaxActionResult;
        }
        IWFService iWFService = this.getWFModel().getWFService();
        WFActionParam wfActionParam = new WFActionParam();
        wfActionParam.setUserData(strKey);
        wfActionParam.setUserData4(this.getDEModel().getId());
        wfActionParam.setOpPersonId(this.getWebContext().getCurUserId());
        wfActionParam.setWFMode(this.getWebContext().getWFMode());
        iWFService.start(wfActionParam);
        IEntity iEntity = this.getEntity(strKey);
        this.fillDefaultValues((IDataObject)iEntity, true);
        iEntity.set("srfuf", (Object)1);
        iEntity.set("srftempmode", (Object)this.getTempMode());
        this.fillOutputDatas((IDataObject)iEntity, true, formAjaxActionResult);
        return formAjaxActionResult;
    }

    protected AjaxActionResult onWFSubmit() throws Exception {
        IEntity iEntity;
        String strWFStepValue;
        FormAjaxActionResult formAjaxActionResult = new FormAjaxActionResult();
        this.getWebContext().setCurAjaxActionResult((AjaxActionResult)formAjaxActionResult);
        String strKey = WebContext.getRealKey((IWebContext)this.getWebContext());
        if (StringHelper.isNullOrEmpty((String)strKey)) {
            formAjaxActionResult.setRetCode(4);
            return formAjaxActionResult;
        }
        Object objKeyValue = this.getEditFormModel().getItemInputValue("srfkey", this.getWebContext());
        if (objKeyValue == null) {
            formAjaxActionResult.setRetCode(4);
            return formAjaxActionResult;
        }
        IEntity updateEntity = this.getSimpleEntity(objKeyValue);
        int nVer = -1;
        if (!StringHelper.isNullOrEmpty((String)this.getDEWF().getWFVerField())) {
            nVer = DataObject.getIntegerValue((IDataObject)updateEntity, (String)this.getDEWF().getWFVerField(), (int)1);
        }
        if (StringHelper.isNullOrEmpty((String)(strWFStepValue = this.getWFStepValue()))) {
            strWFStepValue = DataObject.getStringValue((IDataObject)updateEntity, (String)this.getDEWF().getWFStepField(), (String)"");
        }
        IWFService iWFService = this.getWFModel().getWFService();
        String strIATag = WebContext.getWFIATag((IWebContext)this.getWebContext());
        String strSubmitMemo = "";
        String strMemoField = "";
        IWFProcessModel iWFProcessModel = this.getWFModel().getWFVersionModelByWFVersion(nVer).getWFProcessModelByWFStepValue(strWFStepValue, false);
        if (iWFProcessModel instanceof IWFInteractiveProcessModel) {
            IWFInteractiveProcessModel iWFInteractiveProcessModel = (IWFInteractiveProcessModel)iWFProcessModel;
            IWFInteractiveLinkModel iWFInteractiveLinkModel = iWFInteractiveProcessModel.getWFInteractiveLinkModel(strIATag, true);
            if (iWFInteractiveLinkModel != null) {
                strMemoField = iWFInteractiveLinkModel.getMemoField();
            }
            if (StringHelper.isNullOrEmpty((String)strMemoField)) {
                strMemoField = iWFInteractiveProcessModel.getMemoField();
            }
        }
        WFActionParam wfActionParam = new WFActionParam();
        wfActionParam.setUserData(strKey);
        wfActionParam.setUserData4(this.getDEModel().getId());
        wfActionParam.setOpPersonId(this.getWebContext().getCurUserId());
        wfActionParam.setStepId(iWFProcessModel.getId());
        wfActionParam.setWFMode(this.getWebContext().getWFMode());
        wfActionParam.setTestMode(true);
        WFActionResult wfActionResult = iWFService.submit(wfActionParam);
        if (wfActionResult.isError()) {
            formAjaxActionResult.setRetCode(2);
            formAjaxActionResult.setErrorInfo(wfActionResult.getErrorInfo());
            return formAjaxActionResult;
        }
        try {
            SessionFactoryManager.addRef();
            iEntity = this.getDEModel().createEntity();
            this.fillInputValues((IDataObject)iEntity, true, false);
            this.testInputValueRule((IDataObject)iEntity, true);
            if (iEntity.contains("srfwfmemo")) {
                strSubmitMemo = DataObject.getStringValue((IDataObject)iEntity, (String)"srfwfmemo", (String)"");
            }
            String strLastSubmitMemo = "";
            if (!StringHelper.isNullOrEmpty((String)strMemoField)) {
                IEntity iEntity2 = this.getEntity(objKeyValue);
                strLastSubmitMemo = DataObject.getStringValue((IDataObject)iEntity2, (String)strMemoField, (String)"");
                if (!StringHelper.isNullOrEmpty((String)strLastSubmitMemo)) {
                    strLastSubmitMemo = String.valueOf(strLastSubmitMemo) + "\r\n\r\n";
                }
                strLastSubmitMemo = String.valueOf(strLastSubmitMemo) + StringHelper.format((String)"%1$s %2$s \u5904\u7406:\r\n%3$s", (Object)this.getWebContext().getCurUserName(), (Object)DateHelper.getCurTimeString(), (Object)strSubmitMemo);
                iEntity.set(strMemoField, (Object)strLastSubmitMemo);
            }
            iEntity.set(this.getDEModel().getKeyDEField().getName(), objKeyValue);
            iEntity = this.updateEntity(iEntity);
            WFActionParam wfActionParam2 = new WFActionParam();
            wfActionParam2.setUserData(strKey);
            wfActionParam2.setUserData4(this.getDEModel().getId());
            wfActionParam2.setOpPersonId(this.getWebContext().getCurUserId());
            wfActionParam2.setStepId(iWFProcessModel.getId());
            wfActionParam2.setConnection(strIATag);
            wfActionParam2.setDescription(strSubmitMemo);
            wfActionParam2.setWFMode(this.getWebContext().getWFMode());
            iWFService.submit(wfActionParam2);
            SessionFactoryManager.releaseRef((boolean)true);
        }
        catch (Exception ex) {
            log.error((Object)ex.getMessage(), (Throwable)ex);
            SessionFactoryManager.releaseRef((boolean)false);
            throw ex;
        }
        iEntity = this.getEntity(objKeyValue);
        this.fillDefaultValues((IDataObject)iEntity, true);
        iEntity.set("srfuf", (Object)1);
        iEntity.set("srftempmode", (Object)this.getTempMode());
        this.fillOutputDatas((IDataObject)iEntity, true, formAjaxActionResult);
        return formAjaxActionResult;
    }

    protected AjaxActionResult onUpdate() throws Exception {
        FormAjaxActionResult formAjaxActionResult = new FormAjaxActionResult();
        this.getWebContext().setCurAjaxActionResult((AjaxActionResult)formAjaxActionResult);
        Object objKeyValue = this.getEditFormModel().getItemInputValue("srfkey", this.getWebContext());
        if (objKeyValue == null) {
            formAjaxActionResult.setRetCode(4);
            return formAjaxActionResult;
        }
        IEntity updateEntity = this.getSimpleEntity(objKeyValue);
        if (updateEntity != null) {
            if (this.isWFIAMode()) {
                String strWFStepValue;
                int nVer = -1;
                if (!StringHelper.isNullOrEmpty((String)this.getDEWF().getWFVerField())) {
                    nVer = DataObject.getIntegerValue((IDataObject)updateEntity, (String)this.getDEWF().getWFVerField(), (int)1);
                }
                if (StringHelper.isNullOrEmpty((String)(strWFStepValue = this.getWFStepValue()))) {
                    strWFStepValue = DataObject.getStringValue((IDataObject)updateEntity, (String)this.getDEWF().getWFStepField(), (String)"");
                }
                IWFService iWFService = this.getWFModel().getWFService();
                IWFProcessModel iWFProcessModel = this.getWFModel().getWFVersionModelByWFVersion(nVer).getWFProcessModelByWFStepValue(strWFStepValue, false);
                WFActionParam wfActionParam = new WFActionParam();
                wfActionParam.setUserData((String)updateEntity.get(this.getDEModel().getKeyDEField().getName()));
                wfActionParam.setUserData4(this.getDEModel().getId());
                wfActionParam.setOpPersonId(this.getWebContext().getCurUserId());
                wfActionParam.setStepId(iWFProcessModel.getId());
                wfActionParam.setTestMode(true);
                wfActionParam.setWFMode(this.getWebContext().getWFMode());
                WFActionResult wfActionResult = iWFService.submit(wfActionParam);
                if (wfActionResult.isError()) {
                    formAjaxActionResult.setRetCode(2);
                    formAjaxActionResult.setErrorInfo(wfActionResult.getErrorInfo());
                    return formAjaxActionResult;
                }
            } else {
                String strDataAccessAction = this.getDataAccessAction("update");
                CallResult callResult = this.testDataAccessAction(updateEntity, strDataAccessAction);
                if (!callResult.isOk()) {
                    formAjaxActionResult.setRetCode(2);
                    formAjaxActionResult.setErrorInfo(callResult.getErrorInfo());
                    return formAjaxActionResult;
                }
            }
        }
        IEntity iEntity = this.getDEModel().createEntity();
        this.fillInputValues((IDataObject)iEntity, true, false);
        this.testInputValueRule((IDataObject)iEntity, true);
        iEntity.set(this.getDEModel().getKeyDEField().getName(), objKeyValue);
        iEntity = this.updateEntity(iEntity);
        iEntity.set("srfuf", (Object)1);
        iEntity.set("srftempmode", (Object)this.getTempMode());
        this.fillOutputDatas((IDataObject)iEntity, true, formAjaxActionResult);
        this.fillDataAccActions(formAjaxActionResult.getDataAccAction(true), iEntity);
        return formAjaxActionResult;
    }

    protected CallResult testDataAccessAction(IEntity iEntity, String strDataAccessAction) throws Exception {
        if (this.isWFIAMode()) {
            String strWFStepValue;
            CallResult callResult = new CallResult();
            int nVer = -1;
            if (!StringHelper.isNullOrEmpty((String)this.getDEWF().getWFVerField())) {
                nVer = DataObject.getIntegerValue((IDataObject)iEntity, (String)this.getDEWF().getWFVerField(), (int)1);
            }
            if (StringHelper.isNullOrEmpty((String)(strWFStepValue = this.getWFStepValue()))) {
                strWFStepValue = DataObject.getStringValue((IDataObject)iEntity, (String)this.getDEWF().getWFStepField(), (String)"");
            }
            if (StringHelper.compare((String)strDataAccessAction, (String)"READ", (boolean)true) == 0) {
                IWFService iWFService = this.getWFModel().getWFService();
                IWFProcessModel iWFProcessModel = this.getWFModel().getWFVersionModelByWFVersion(nVer).getWFProcessModelByWFStepValue(strWFStepValue, false);
                WFActionParam wfActionParam = new WFActionParam();
                String strKey = DataObject.getStringValue((Object)iEntity.get(this.getDEModel().getKeyDEField().getName()), (String)"");
                if (KeyValueHelper.isTempKey((String)strKey)) {
                    wfActionParam.setUserData((String)EntityBase.getOriginKey((IEntity)iEntity));
                } else {
                    wfActionParam.setUserData(strKey);
                }
                wfActionParam.setUserData4(this.getDEModel().getId());
                wfActionParam.setOpPersonId(this.getWebContext().getCurUserId());
                wfActionParam.setStepId(iWFProcessModel.getId());
                wfActionParam.setTestMode(true);
                wfActionParam.setWFMode(this.getWebContext().getWFMode());
                WFActionResult wfActionResult = iWFService.submit(wfActionParam);
                if (wfActionResult.isError()) {
                    callResult.setRetCode(2);
                    callResult.setErrorInfo(wfActionResult.getErrorInfo());
                    return callResult;
                }
                return callResult;
            }
            if (StringHelper.compare((String)strDataAccessAction, (String)"UPDATE", (boolean)true) == 0) {
                IWFInteractiveProcessModel iWFProcessModel = (IWFInteractiveProcessModel)this.getWFModel().getWFVersionModelByWFVersion(nVer).getWFProcessModelByWFStepValue(strWFStepValue, false);
                if (iWFProcessModel.isEditable()) {
                    callResult.setRetCode(0);
                    return callResult;
                }
                callResult.setRetCode(2);
                callResult.setErrorInfo("\u5f53\u524d\u6d41\u7a0b\u6b65\u9aa4\u4e0d\u5141\u8bb8\u7f16\u8f91");
                return callResult;
            }
        }
        return super.testDataAccessAction(iEntity, strDataAccessAction);
    }
}

