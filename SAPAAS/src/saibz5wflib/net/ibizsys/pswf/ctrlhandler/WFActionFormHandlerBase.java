/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IInheritDEServiceProxy
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.util.DateHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.AjaxActionResult
 *  net.ibizsys.paas.web.FormAjaxActionResult
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 *  net.ibizsys.pswf.core.IWFProcessModel
 *  net.ibizsys.pswf.core.IWFService
 *  net.ibizsys.pswf.core.WFActionParam
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pswf.ctrlhandler;

import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IInheritDEServiceProxy;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.FormAjaxActionResult;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pswf.core.IWFInteractiveLinkModel;
import net.ibizsys.pswf.core.IWFInteractiveProcessModel;
import net.ibizsys.pswf.core.IWFProcessModel;
import net.ibizsys.pswf.core.IWFService;
import net.ibizsys.pswf.core.WFActionParam;
import net.ibizsys.pswf.ctrlhandler.IWFActionFormHandler;
import net.ibizsys.pswf.ctrlhandler.WFEditFormHandlerBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class WFActionFormHandlerBase
extends WFEditFormHandlerBase
implements IWFActionFormHandler {
    private static final Log log = LogFactory.getLog(WFActionFormHandlerBase.class);

    protected AjaxActionResult onLoad() throws Exception {
        FormAjaxActionResult formAjaxActionResult = new FormAjaxActionResult();
        this.getWebContext().setCurAjaxActionResult((AjaxActionResult)formAjaxActionResult);
        Object objKeyValue = this.getEditFormModel().getItemInputValue("srfkey", this.getWebContext());
        if (objKeyValue == null) {
            formAjaxActionResult.setRetCode(4);
            return formAjaxActionResult;
        }
        String strKeyValue = objKeyValue.toString();
        String[] keys = StringHelper.splitEx((String)strKeyValue);
        String strFirstKey = keys[0];
        IEntity iEntity = this.getEntity(strFirstKey);
        this.fillDefaultValues((IDataObject)iEntity, true);
        iEntity.set("srfuf", (Object)1);
        iEntity.set("srftempmode", (Object)this.getTempMode());
        iEntity.set("srfkey", (Object)strKeyValue);
        iEntity.set(this.getDEModel().getKeyDEField().getName(), (Object)strKeyValue);
        this.fillOutputDatas((IDataObject)iEntity, true, formAjaxActionResult);
        return formAjaxActionResult;
    }

    @Override
    protected AjaxActionResult onWFSubmit() throws Exception {
        FormAjaxActionResult formAjaxActionResult = new FormAjaxActionResult();
        this.getWebContext().setCurAjaxActionResult((AjaxActionResult)formAjaxActionResult);
        String strKey = WebContext.getKey((IWebContext)this.getWebContext());
        if (StringHelper.isNullOrEmpty((String)strKey)) {
            formAjaxActionResult.setRetCode(4);
            return formAjaxActionResult;
        }
        Object objKeyValue = this.getEditFormModel().getItemInputValue("srfkey", this.getWebContext());
        if (objKeyValue == null) {
            formAjaxActionResult.setRetCode(4);
            return formAjaxActionResult;
        }
        IEntity srcEntity = this.getDEModel().createEntity();
        this.fillInputValues((IDataObject)srcEntity, true, false);
        IDataEntityModel realDEModel = this.getDEModel();
        if (StringHelper.compare((String)realDEModel.getIndexDEType(), (String)"INHERIT", (boolean)true) == 0) {
            IService realService = ((IInheritDEServiceProxy)this.getService()).getRealService(srcEntity);
            realDEModel = realService.getDEModel();
            this.fillInputValues((IDataObject)srcEntity, true, false);
        }
        String[] keys = strKey.split("[;]");
        String strIATag = WebContext.getWFIATag((IWebContext)this.getWebContext());
        String strSubmitMemo = "";
        String strWFRet = "";
        if (srcEntity.contains("srfwfmemo")) {
            strSubmitMemo = DataObject.getStringValue((IDataObject)srcEntity, (String)"srfwfmemo", (String)"");
        }
        if (srcEntity.contains("srfwfret")) {
            strWFRet = DataObject.getStringValue((IDataObject)srcEntity, (String)"srfwfret", (String)"");
        }
        srcEntity.remove("srfupdatedate");
        IWFService iWFService = this.getWFModel().getWFService();
        String[] stringArray = keys;
        int n = keys.length;
        int n2 = 0;
        while (n2 < n) {
            String strKey2 = stringArray[n2];
            try {
                SessionFactoryManager.addRef();
                int nVer = -1;
                String strWFStepValue = this.getWFStepValue();
                if (StringHelper.isNullOrEmpty((String)strWFStepValue) || !StringHelper.isNullOrEmpty((String)this.getDEWF().getWFVerField())) {
                    IEntity curEntity = this.getEntity(strKey2);
                    if (!StringHelper.isNullOrEmpty((String)this.getDEWF().getWFVerField())) {
                        nVer = DataObject.getIntegerValue((IDataObject)curEntity, (String)this.getDEWF().getWFVerField(), (int)1);
                    }
                    if (StringHelper.isNullOrEmpty((String)strWFStepValue)) {
                        strWFStepValue = DataObject.getStringValue((IDataObject)curEntity, (String)this.getDEWF().getWFStepField(), (String)"");
                    }
                }
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
                IEntity iEntity = this.getDEModel().createEntity();
                srcEntity.copyTo((IDataObject)iEntity, false);
                String strLastSubmitMemo = "";
                if (!StringHelper.isNullOrEmpty((String)strMemoField)) {
                    IEntity iEntity2 = this.getEntity(strKey2);
                    strLastSubmitMemo = DataObject.getStringValue((IDataObject)iEntity2, (String)strMemoField, (String)"");
                    if (!StringHelper.isNullOrEmpty((String)strLastSubmitMemo)) {
                        strLastSubmitMemo = String.valueOf(strLastSubmitMemo) + "\r\n\r\n";
                    }
                    strLastSubmitMemo = String.valueOf(strLastSubmitMemo) + StringHelper.format((String)"%1$s %2$s \u5904\u7406:\r\n%3$s", (Object)this.getWebContext().getCurUserName(), (Object)DateHelper.getCurTimeString(), (Object)strSubmitMemo);
                    iEntity.set(strMemoField, (Object)strLastSubmitMemo);
                }
                iEntity.set(this.getDEModel().getKeyDEField().getName(), (Object)strKey2);
                iEntity = this.updateEntity(iEntity);
                WFActionParam wfActionParam = this.createWFActionParam(iEntity, srcEntity);
                wfActionParam.setUserData(strKey2);
                wfActionParam.setUserData4(realDEModel.getId());
                wfActionParam.setOpPersonId(this.getWebContext().getCurUserId());
                wfActionParam.setStepId(iWFProcessModel.getId());
                wfActionParam.setConnection(strIATag);
                wfActionParam.setActionResult(strWFRet);
                wfActionParam.setDescription(strSubmitMemo);
                wfActionParam.setWFMode(this.getWebContext().getWFMode());
                iWFService.submit(wfActionParam);
                SessionFactoryManager.releaseRef((boolean)true);
            }
            catch (Exception ex) {
                log.error((Object)ex.getMessage(), (Throwable)ex);
                SessionFactoryManager.releaseRef((boolean)false);
                throw ex;
            }
            ++n2;
        }
        IEntity iEntity = this.getDEModel().createEntity();
        this.fillDefaultValues((IDataObject)iEntity, true);
        iEntity.set("srfuf", (Object)1);
        iEntity.set("srftempmode", (Object)this.getTempMode());
        this.fillOutputDatas((IDataObject)iEntity, true, formAjaxActionResult);
        return formAjaxActionResult;
    }

    protected WFActionParam createWFActionParam(IEntity entity, IEntity srcEntity) throws Exception {
        return new WFActionParam();
    }

    @Override
    protected String getWFStepValue() {
        return WebContext.getWFStep((IWebContext)this.getWebContext());
    }
}

