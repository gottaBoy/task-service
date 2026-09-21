/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.ctrlhandler;

import java.util.ArrayList;
import net.ibizsys.paas.control.form.FormError;
import net.ibizsys.paas.control.form.FormException;
import net.ibizsys.paas.control.form.IFormItem;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.IDEFInputTip;
import net.ibizsys.paas.ctrlhandler.ICtrlItemHandler;
import net.ibizsys.paas.ctrlhandler.IEditFormHandler;
import net.ibizsys.paas.ctrlhandler.SDCtrlHandlerBase;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.ctrlmodel.IEditFormModel;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.demodel.DEFInputTipSetModelGlobal;
import net.ibizsys.paas.demodel.IDEFInputTipSetModel;
import net.ibizsys.paas.demodel.IDEUIActionModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityException;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.exception.AccessDenyException;
import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.exception.UserConfirmException;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.FormAjaxActionResult;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class EditFormHandlerBase
extends SDCtrlHandlerBase
implements IEditFormHandler {
    private static final Log log = LogFactory.getLog(EditFormHandlerBase.class);

    protected abstract IEditFormModel getEditFormModel();

    @Override
    public ICtrlModel getCtrlModel() {
        return this.getEditFormModel();
    }

    protected AjaxActionResult onLoadDraft() throws Exception {
        return this.onLoadDraft(false);
    }

    protected AjaxActionResult onLoadDraft(boolean bCreate) throws Exception {
        CallResult callResult;
        FormAjaxActionResult formAjaxActionResult = new FormAjaxActionResult();
        this.getWebContext().setCurAjaxActionResult(formAjaxActionResult);
        IEntity iEntity = this.getDraftEntity();
        String strDataAccessAction = this.getDataAccessAction("create");
        if (!StringHelper.isNullOrEmpty(strDataAccessAction) && !(callResult = this.testDataAccessAction(iEntity, strDataAccessAction)).isOk()) {
            this.fillDataAccActions(formAjaxActionResult.getDataAccAction(true), false);
            formAjaxActionResult.setRetCode(2);
            formAjaxActionResult.setErrorInfo(callResult.getErrorInfo());
            return formAjaxActionResult;
        }
        if (bCreate) {
            iEntity.remove("SRFDRAFTFLAG");
            iEntity = this.createEntity(iEntity);
            iEntity.set("srfuf", 1);
            iEntity.set("srftempmode", this.getTempMode());
            this.fillOutputDatas(iEntity, true, formAjaxActionResult);
            this.fillDataAccActions(formAjaxActionResult.getDataAccAction(true), iEntity);
        } else {
            iEntity.set("srfuf", 0);
            iEntity.set("srftempmode", this.getTempMode());
            this.fillOutputDatas(iEntity, false, formAjaxActionResult);
        }
        return formAjaxActionResult;
    }

    protected AjaxActionResult onLoadDraftFrom() throws Exception {
        return this.onLoadDraftFrom(false);
    }

    protected AjaxActionResult onLoadDraftFrom(boolean bCreate) throws Exception {
        String strDataAccessAction;
        CallResult callResult;
        FormAjaxActionResult formAjaxActionResult = new FormAjaxActionResult();
        this.getWebContext().setCurAjaxActionResult(formAjaxActionResult);
        String strSourceKey = this.getEditFormSourceKey();
        IEntity srcEntity = this.getSimpleEntity(strSourceKey);
        if (srcEntity != null && !(callResult = this.testDataAccessAction(srcEntity, strDataAccessAction = this.getDataAccessAction("load"))).isOk()) {
            this.fillDataAccActions(formAjaxActionResult.getDataAccAction(true), false);
            formAjaxActionResult.setRetCode(2);
            formAjaxActionResult.setErrorInfo(callResult.getErrorInfo());
            return formAjaxActionResult;
        }
        IEntity iEntity = this.getDraftEntityFrom(DataTypeHelper.parse(this.getDEModel().getKeyDEField().getStdDataType(), strSourceKey));
        callResult = this.testDataAccessAction(iEntity, strDataAccessAction = this.getDataAccessAction("create"));
        if (!callResult.isOk()) {
            this.fillDataAccActions(formAjaxActionResult.getDataAccAction(true), false);
            formAjaxActionResult.setRetCode(2);
            formAjaxActionResult.setErrorInfo(callResult.getErrorInfo());
            return formAjaxActionResult;
        }
        if (bCreate) {
            this.fillDefaultValues(iEntity, false);
            iEntity.remove("SRFDRAFTFLAG");
            iEntity = this.createEntity(iEntity);
            iEntity.set("srfuf", 1);
            iEntity.set("srftempmode", this.getTempMode());
            this.fillOutputDatas(iEntity, true, formAjaxActionResult);
            this.fillDataAccActions(formAjaxActionResult.getDataAccAction(true), iEntity);
        } else {
            this.fillDefaultValues(iEntity, false);
            iEntity.set("srfuf", 0);
            iEntity.set("srftempmode", this.getTempMode());
            iEntity.set("srfsourcekey", strSourceKey);
            this.fillOutputDatas(iEntity, false, formAjaxActionResult);
        }
        return formAjaxActionResult;
    }

    @Override
    protected AjaxActionResult onLoad() throws Exception {
        String strDataAccessAction;
        CallResult callResult;
        FormAjaxActionResult formAjaxActionResult = new FormAjaxActionResult();
        this.getWebContext().setCurAjaxActionResult(formAjaxActionResult);
        Object objKeyValue = this.getEditFormKeyValue();
        if (objKeyValue == null) {
            formAjaxActionResult.setRetCode(4);
            return formAjaxActionResult;
        }
        IEntity iEntity = null;
        if (!this.isUseServiceAPI() && (callResult = this.testDataAccessAction(strDataAccessAction = this.getDataAccessAction("load"))).isOk() && (iEntity = this.getSimpleEntity(objKeyValue)) != null && !(callResult = this.testDataAccessAction(iEntity, strDataAccessAction)).isOk()) {
            this.fillDataAccActions(formAjaxActionResult.getDataAccAction(true), false);
            formAjaxActionResult.setRetCode(2);
            formAjaxActionResult.setErrorInfo(callResult.getErrorInfo());
            return formAjaxActionResult;
        }
        if (iEntity == null || StringHelper.compare(this.getGetEntityAction(), "GET", true) != 0) {
            iEntity = this.getEntity(objKeyValue);
        }
        this.fillDefaultValues(iEntity, true);
        iEntity.set("srfuf", 1);
        iEntity.set("srftempmode", this.getTempMode());
        this.fillOutputDatas(iEntity, true, formAjaxActionResult);
        this.fillDataAccActions(formAjaxActionResult.getDataAccAction(true), iEntity);
        return formAjaxActionResult;
    }

    @Override
    protected AjaxActionResult onCreate() throws Exception {
        IEntity srcEntity;
        FormAjaxActionResult formAjaxActionResult = new FormAjaxActionResult();
        this.getWebContext().setCurAjaxActionResult(formAjaxActionResult);
        Object iEntity = this.getDEModel().createEntity();
        this.fillInputValues((IDataObject)iEntity, false, false);
        this.testInputValueRule((IDataObject)iEntity, false);
        String strDataAccessAction = this.getDataAccessAction("create");
        CallResult callResult = this.testDataAccessAction((IEntity)iEntity, strDataAccessAction);
        if (!callResult.isOk()) {
            this.fillDataAccActions(formAjaxActionResult.getDataAccAction(true), false);
            formAjaxActionResult.setRetCode(2);
            formAjaxActionResult.setErrorInfo(callResult.getErrorInfo());
            return formAjaxActionResult;
        }
        String strSourceKey = DataObject.getStringValue(iEntity, "srfsourcekey", "");
        if (!StringHelper.isNullOrEmpty(strSourceKey) && (srcEntity = this.getSimpleEntity(strSourceKey)) != null && !(callResult = this.testDataAccessAction(srcEntity, strDataAccessAction = this.getDataAccessAction("load"))).isOk()) {
            this.fillDataAccActions(formAjaxActionResult.getDataAccAction(true), false);
            formAjaxActionResult.setRetCode(2);
            formAjaxActionResult.setErrorInfo(callResult.getErrorInfo());
            return formAjaxActionResult;
        }
        iEntity = this.createEntity((IEntity)iEntity);
        iEntity.set("srfuf", 1);
        iEntity.set("srftempmode", this.getTempMode());
        this.fillOutputDatas((IDataObject)iEntity, true, formAjaxActionResult);
        this.fillDataAccActions(formAjaxActionResult.getDataAccAction(true), (IEntity)iEntity);
        return formAjaxActionResult;
    }

    @Override
    protected AjaxActionResult onUpdate() throws Exception {
        FormAjaxActionResult formAjaxActionResult = new FormAjaxActionResult();
        this.getWebContext().setCurAjaxActionResult(formAjaxActionResult);
        Object objKeyValue = this.getEditFormKeyValue();
        if (objKeyValue == null) {
            formAjaxActionResult.setRetCode(4);
            return formAjaxActionResult;
        }
        IEntity updateEntity = null;
        if (!this.isUseServiceAPI()) {
            String strDataAccessAction = this.getDataAccessAction("update");
            CallResult callResult = this.testDataAccessAction(strDataAccessAction);
            if (callResult.isOk() && (updateEntity = this.getSimpleEntity(objKeyValue)) != null) {
                callResult = this.testDataAccessAction(updateEntity, strDataAccessAction);
            }
            if (!callResult.isOk()) {
                this.fillDataAccActions(formAjaxActionResult.getDataAccAction(true), false);
                formAjaxActionResult.setRetCode(2);
                formAjaxActionResult.setErrorInfo(callResult.getErrorInfo());
                return formAjaxActionResult;
            }
        }
        Object iEntity = this.getDEModel().createEntity();
        if (updateEntity != null) {
            EntityBase.setLast(iEntity, updateEntity);
        }
        this.fillInputValues((IDataObject)iEntity, true, false);
        if (updateEntity != null) {
            EntityBase.setLast(iEntity, null);
        }
        this.testInputValueRule((IDataObject)iEntity, true);
        iEntity.set(this.getDEModel().getKeyDEField().getName(), objKeyValue);
        iEntity = this.updateEntity((IEntity)iEntity);
        iEntity.set("srfuf", 1);
        iEntity.set("srftempmode", this.getTempMode());
        this.fillOutputDatas((IDataObject)iEntity, true, formAjaxActionResult);
        this.fillDataAccActions(formAjaxActionResult.getDataAccAction(true), (IEntity)iEntity);
        return formAjaxActionResult;
    }

    @Override
    protected AjaxActionResult onRemove() throws Exception {
        FormAjaxActionResult formAjaxActionResult = new FormAjaxActionResult();
        this.getWebContext().setCurAjaxActionResult(formAjaxActionResult);
        Object objKeyValue = this.getEditFormKeyValue();
        if (objKeyValue == null) {
            formAjaxActionResult.setRetCode(4);
            return formAjaxActionResult;
        }
        if (!this.isUseServiceAPI()) {
            IEntity removeEntity;
            String strDataAccessAction = this.getDataAccessAction("remove");
            CallResult callResult = this.testDataAccessAction(strDataAccessAction);
            if (callResult.isOk() && (removeEntity = this.getSimpleEntity(objKeyValue)) != null) {
                callResult = this.testDataAccessAction(removeEntity, strDataAccessAction);
            }
            if (!callResult.isOk()) {
                this.fillDataAccActions(formAjaxActionResult.getDataAccAction(true), false);
                formAjaxActionResult.setRetCode(2);
                formAjaxActionResult.setErrorInfo(callResult.getErrorInfo());
                return formAjaxActionResult;
            }
        }
        formAjaxActionResult.getData(true);
        this.removeEntity(objKeyValue);
        return formAjaxActionResult;
    }

    protected IEntity getDraftEntityFrom(Object objKeyValue) throws Exception {
        throw new Exception(StringHelper.format("\u6ca1\u6709\u5b9e\u73b0"));
    }

    protected IEntity getDraftEntity() throws Exception {
        throw new Exception(StringHelper.format("\u6ca1\u6709\u5b9e\u73b0"));
    }

    protected IEntity getEntity(Object objKeyValue) throws Exception {
        throw new Exception(StringHelper.format("\u6ca1\u6709\u5b9e\u73b0"));
    }

    protected IEntity createEntity(IEntity iEntity) throws Exception {
        throw new Exception(StringHelper.format("\u6ca1\u6709\u5b9e\u73b0"));
    }

    protected IEntity updateEntity(IEntity iEntity) throws Exception {
        throw new Exception(StringHelper.format("\u6ca1\u6709\u5b9e\u73b0"));
    }

    protected void removeEntity(Object objKeyValue) throws Exception {
        throw new Exception(StringHelper.format("\u6ca1\u6709\u5b9e\u73b0"));
    }

    protected void fillOutputDatas(IDataObject iDataObject, Boolean bUpdate, FormAjaxActionResult formAjaxActionResult) throws Exception {
        this.getEditFormModel().fillOutputDatas(iDataObject, bUpdate, formAjaxActionResult.getData(true), formAjaxActionResult.getState(true), formAjaxActionResult.getConfig(true));
    }

    protected void fillInputValues(IDataObject iDataObject, boolean bUpdate, boolean bIgnoreEmpty) throws Exception {
        this.getEditFormModel().fillInputValues(iDataObject, bUpdate, bIgnoreEmpty);
    }

    protected void testInputValueRule(IDataObject iDataObject, boolean bUpdate) throws Exception {
        this.getEditFormModel().testValueRule(this.getService(), iDataObject, bUpdate);
    }

    protected void fillDefaultValues(IDataObject iDataObject, boolean bUpdate) throws Exception {
        this.getEditFormModel().fillDefaultValues(iDataObject, bUpdate);
    }

    @Override
    public AjaxActionResult processAction(String strAction, IWebContext iWebContext) throws Exception {
        try {
            return super.processAction(strAction, iWebContext);
        }
        catch (FormException ex) {
            log.error((Object)ex.getMessage(), (Throwable)ex);
            FormAjaxActionResult formAjaxActionResult = new FormAjaxActionResult();
            formAjaxActionResult.setRetCode(5);
            formAjaxActionResult.setErrorInfo(ex.getMessage());
            ex.getFormError().toJSONObject(formAjaxActionResult.getError(true));
            return formAjaxActionResult;
        }
        catch (EntityException ex) {
            log.error((Object)ex.getMessage(), (Throwable)ex);
            FormAjaxActionResult formAjaxActionResult = new FormAjaxActionResult();
            formAjaxActionResult.setRetCode(5);
            formAjaxActionResult.setErrorInfo(ex.getMessage());
            FormError formError = this.getFormError(ex.getEntityError());
            formError.toJSONObject(formAjaxActionResult.getError(true));
            return formAjaxActionResult;
        }
        catch (ErrorException ex) {
            log.error((Object)ex.getMessage(), (Throwable)ex);
            FormAjaxActionResult formAjaxActionResult = new FormAjaxActionResult();
            formAjaxActionResult.setRetCode(ex.getErrorCode());
            formAjaxActionResult.setErrorInfo(ex.getMessage());
            if (ex instanceof AccessDenyException) {
                formAjaxActionResult.setNotLogin(((AccessDenyException)ex).isNotLogin());
            }
            return formAjaxActionResult;
        }
        catch (UserConfirmException ex) {
            log.error((Object)ex.getMessage(), (Throwable)ex);
            FormAjaxActionResult formAjaxActionResult = new FormAjaxActionResult();
            formAjaxActionResult.setRetCode(19);
            formAjaxActionResult.setConfirmMsg(ex.getMessage());
            formAjaxActionResult.setConfirmKey(ex.getConfirmKey());
            formAjaxActionResult.setConfirmTitle(ex.getConfirmTitle());
            formAjaxActionResult.setConfirmOptions(ex.getConfirmOptions());
            formAjaxActionResult.setConfirmActionParam(ex.getConfirmActionParam());
            return formAjaxActionResult;
        }
        catch (Exception ex) {
            log.error((Object)ex.getMessage(), (Throwable)ex);
            FormAjaxActionResult formAjaxActionResult = new FormAjaxActionResult();
            formAjaxActionResult.setRetCode(1);
            formAjaxActionResult.setErrorInfo(ex.getMessage());
            return formAjaxActionResult;
        }
    }

    @Override
    protected AjaxActionResult onProcessAction(String strAction) throws Exception {
        if (StringHelper.compare(strAction, "itemfetch", true) == 0) {
            return this.onItemAction(strAction);
        }
        if (StringHelper.compare(strAction, "loaddraft", true) == 0) {
            return this.onLoadDraft();
        }
        if (StringHelper.compare(strAction, "loaddraftfrom", true) == 0) {
            return this.onLoadDraftFrom();
        }
        if (StringHelper.compare(strAction, "loaddraftandcreate", true) == 0) {
            return this.onLoadDraft(true);
        }
        if (StringHelper.compare(strAction, "loaddraftfromandcreate", true) == 0) {
            return this.onLoadDraftFrom(true);
        }
        if (StringHelper.compare(strAction, "updateformitem", true) == 0) {
            return this.onUpdateFormItem(WebContext.getUFIMode(this.getWebContext()));
        }
        if (StringHelper.compare(strAction, "itemtip", true) == 0) {
            return this.onItemTip();
        }
        return super.onProcessAction(strAction);
    }

    protected AjaxActionResult onItemAction(String strAction) throws Exception {
        String strFormItemName = WebContext.getFormItemId(this.getWebContext());
        ICtrlItemHandler iCtrlItemHandler = this.getCtrlItemHandler("FI:" + strFormItemName);
        return iCtrlItemHandler.processAction(strAction);
    }

    @Override
    protected AjaxActionResult onUIAction() throws Exception {
        String strDEUIActionId = WebContext.getUIActionId(this.getWebContext());
        IDEUIActionModel iDEUIActionModel = (IDEUIActionModel)this.getDEModel().getDEUIAction(strDEUIActionId);
        return this.doUIAction(iDEUIActionModel);
    }

    @Override
    protected AjaxActionResult onLoadUIAction() throws Exception {
        String strDEUIActionId = WebContext.getUIActionId(this.getWebContext());
        IDEUIActionModel iDEUIActionModel = (IDEUIActionModel)this.getDEModel().getDEUIAction(strDEUIActionId);
        return this.onLoadUIAction(iDEUIActionModel);
    }

    protected AjaxActionResult onLoadUIAction(IDEUIActionModel iDEUIActionModel) throws Exception {
        return iDEUIActionModel.getRuntimeModelAjaxActionResult(this.getSessionFactory());
    }

    protected AjaxActionResult doUIAction(IDEUIActionModel iDEUIActionModel) throws Exception {
        FormAjaxActionResult formAjaxActionResult = new FormAjaxActionResult();
        this.getWebContext().setCurAjaxActionResult(formAjaxActionResult);
        IDataEntityModel iDEModel = iDEUIActionModel.getDEModel();
        if (StringHelper.compare(iDEUIActionModel.getActionTarget(), "NONE", true) == 0) {
            CallResult callResult = iDEModel.getDEDataAccMgr().test(this.getWebContext(), null, iDEUIActionModel.getDataAccessAction());
            if (callResult.isError()) {
                formAjaxActionResult.from(callResult);
                return formAjaxActionResult;
            }
            iDEUIActionModel.execute(null, this.getSessionFactory());
        } else {
            String strKeys = WebContext.getKeys(this.getWebContext());
            if (StringHelper.isNullOrEmpty(strKeys)) {
                strKeys = WebContext.getKey(this.getWebContext());
            }
            if (StringHelper.isNullOrEmpty(strKeys)) {
                formAjaxActionResult.setRetCode(4);
                return formAjaxActionResult;
            }
            ArrayList entities = iDEModel.createEntityList();
            String[] keys = strKeys.split("[;]");
            int i = 0;
            while (i < keys.length) {
                Object iEntity = iDEModel.createEntity();
                iEntity.set(iDEModel.getKeyDEField().getName(), keys[i]);
                if (!StringHelper.isNullOrEmpty(iDEUIActionModel.getDataAccessAction())) {
                    if (StringHelper.compare(this.getDEModel().getId(), iDEModel.getId(), false) == 0) {
                        IEntity iEntity2 = this.getSimpleEntity(keys[i]);
                        if (iEntity2 != null) {
                            CallResult callResult = iDEModel.getDEDataAccMgr().test(this.getWebContext(), iEntity2, iDEUIActionModel.getDataAccessAction());
                            if (callResult.isError()) {
                                formAjaxActionResult.from(callResult);
                                return formAjaxActionResult;
                            }
                            if (DataTypeHelper.compare(iDEModel.getKeyDEField().getStdDataType(), iEntity.get(iDEModel.getKeyDEField().getName()), iEntity2.get(iDEModel.getKeyDEField().getName())) == 0L) {
                                iEntity = iEntity2;
                            }
                        }
                    } else {
                        CallResult callResult = iDEModel.getDEDataAccMgr().test(this.getWebContext(), (IEntity)iEntity, iDEUIActionModel.getDataAccessAction());
                        if (callResult.isError()) {
                            formAjaxActionResult.from(callResult);
                            return formAjaxActionResult;
                        }
                    }
                }
                if (this.getDEModel() != null && StringHelper.compare(this.getDEModel().getId(), iDEModel.getId(), false) != 0) {
                    iEntity.set("srfdeid", this.getDEModel().getId());
                }
                entities.add(iEntity);
                ++i;
            }
            iDEUIActionModel.execute(entities, this.getSessionFactory());
        }
        formAjaxActionResult.setReloadData(iDEUIActionModel.isReloadData());
        formAjaxActionResult.setExtAttr("closeEditview", iDEUIActionModel.isCloseEditView());
        formAjaxActionResult.setErrorInfo(iDEUIActionModel.getSuccessMsg());
        return formAjaxActionResult;
    }

    protected AjaxActionResult onUpdateFormItem(String strUFIMode) throws Exception {
        String strCtrlItemName = strUFIMode;
        ICtrlItemHandler iCtrlItemHandler = this.getCtrlItemHandler("FIU:" + strCtrlItemName);
        return iCtrlItemHandler.processAction("updateformitem");
    }

    protected FormError getFormError(EntityError entityError) throws Exception {
        FormError formError = new FormError();
        for (EntityFieldError entityFieldError : entityError.getEntityFieldErrorList()) {
            IFormItem iFormItem = this.getEditFormModel().getFormItem(entityFieldError.getFieldName(), true);
            if (iFormItem != null) {
                formError.register(iFormItem.getName(), iFormItem.getCaption(), "", entityFieldError.getErrorType(), entityFieldError.getErrorInfo());
                continue;
            }
            log.error((Object)StringHelper.format("\u8868\u5355\u4e0d\u5b58\u5728\u5c5e\u6027 [%1$s]\uff0c\u9519\u8bef[%2$s]%3$s", entityFieldError.getFieldName(), entityFieldError.getErrorType(), entityFieldError.getErrorInfo()));
        }
        return formError;
    }

    protected AjaxActionResult onItemTip() throws Exception {
        FormAjaxActionResult formAjaxActionResult = new FormAjaxActionResult();
        this.getWebContext().setCurAjaxActionResult(formAjaxActionResult);
        String strFormItemName = WebContext.getFormItemId(this.getWebContext());
        if (StringHelper.isNullOrEmpty(strFormItemName)) {
            formAjaxActionResult.setRetCode(3);
            formAjaxActionResult.setRetInfo("\u6ca1\u6709\u6307\u5b9a\u8868\u5355\u9879\u540d\u79f0");
            return formAjaxActionResult;
        }
        IFormItem iFormItem = this.getEditFormModel().getFormItem(strFormItemName, true);
        if (iFormItem == null) {
            formAjaxActionResult.setRetCode(3);
            formAjaxActionResult.setRetInfo("\u6307\u5b9a\u8868\u5355\u9879\u4e0d\u5b58\u5728");
            return formAjaxActionResult;
        }
        formAjaxActionResult.setContent(this.getFormItemInputTip(iFormItem));
        return formAjaxActionResult;
    }

    @Override
    public boolean convertEntityFieldError(EntityFieldError entityFieldError) throws Exception {
        if (this.getEditFormModel().convertEntityFieldError(entityFieldError)) {
            return true;
        }
        return super.convertEntityFieldError(entityFieldError);
    }

    protected String getFormItemInputTip(IFormItem iFormItem) throws Exception {
        String strInputTip;
        if (!StringHelper.isNullOrEmpty(iFormItem.getInputTipLanResTag()) && !StringHelper.isNullOrEmpty(strInputTip = this.getWebContext().getLocalization(iFormItem.getInputTipLanResTag(), iFormItem.getInputTip()))) {
            return strInputTip;
        }
        if (!StringHelper.isNullOrEmpty(iFormItem.getInputTip())) {
            return iFormItem.getInputTip();
        }
        if (!StringHelper.isNullOrEmpty(iFormItem.getInputTipSetId()) && !StringHelper.isNullOrEmpty(iFormItem.getInputTipUniqueTag())) {
            IDEFInputTipSetModel iDEFInputTipSetModel = DEFInputTipSetModelGlobal.getDEFInputTipSet(iFormItem.getInputTipSetId());
            IDEFInputTip iDEFInputTip = iDEFInputTipSetModel.getDEFInputTip(iFormItem.getInputTipUniqueTag());
            if (!StringHelper.isNullOrEmpty(iDEFInputTip.getContentLanResTag())) {
                String strInputTip2 = this.getWebContext().getLocalization(iDEFInputTip.getContentLanResTag(), iDEFInputTip.getContent());
                if (!StringHelper.isNullOrEmpty(strInputTip2)) {
                    return strInputTip2;
                }
            } else if (!StringHelper.isNullOrEmpty(iDEFInputTip.getContent())) {
                return iDEFInputTip.getContent();
            }
        }
        return iFormItem.getCaption();
    }

    protected Object getEditFormKeyValue() throws Exception {
        return this.getEditFormModel().getItemInputValue("srfkey", this.getWebContext());
    }

    protected String getEditFormSourceKey() throws Exception {
        return WebContext.getSourceKey(this.getWebContext());
    }
}

