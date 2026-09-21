/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.ctrlmodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.control.form.FormError;
import net.ibizsys.paas.control.form.FormException;
import net.ibizsys.paas.control.form.IFormItem;
import net.ibizsys.paas.ctrlhandler.CtrlHandler;
import net.ibizsys.paas.ctrlhandler.ICtrlHandler;
import net.ibizsys.paas.ctrlhandler.ISDCtrlHandler;
import net.ibizsys.paas.ctrlmodel.CtrlModelBase;
import net.ibizsys.paas.ctrlmodel.IFormModel;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class FormModelBase
extends CtrlModelBase
implements IFormModel {
    private static final Log log = LogFactory.getLog(FormModelBase.class);
    protected ArrayList<IFormItem> formItemList = new ArrayList();
    protected HashMap<String, IFormItem> formItemMap = new HashMap();

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.prepareFormItems();
    }

    protected IFormItem createFormItem(String strFormItemName) {
        return null;
    }

    protected void prepareFormItems() throws Exception {
    }

    @Override
    public Iterator<IFormItem> getFormItems() {
        return this.formItemList.iterator();
    }

    public IFormItem getFormItem(String strName) throws Exception {
        return this.getFormItem(strName, false);
    }

    @Override
    public IFormItem getFormItem(String strName, boolean bTryMode) throws Exception {
        IFormItem iFormItem = this.formItemMap.get(strName.toLowerCase());
        if (iFormItem == null) {
            if (bTryMode) {
                return null;
            }
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u8868\u5355\u9879[%1$s]", strName));
        }
        return iFormItem;
    }

    protected void registerFormItem(IFormItem iFormItem) {
        this.formItemMap.put(iFormItem.getName().toLowerCase(), iFormItem);
        this.formItemList.add(iFormItem);
    }

    @Override
    public void fillOutputDatas(IDataObject iDataObject, boolean bUpdate, JSONObject data, JSONObject state, JSONObject config) throws Exception {
        if (iDataObject == null) {
            throw new Exception(StringHelper.format("\u6570\u636e\u5bf9\u8c61\u65e0\u6548"));
        }
        this.onFillOutputDatas(iDataObject, bUpdate, data, state, config);
    }

    protected void onFillOutputDatas(IDataObject iDataObject, boolean bUpdate, JSONObject data, JSONObject state, JSONObject config) throws Exception {
        IFormItem iFormItem;
        ICtrlHandler iCtrlHandler = CtrlHandler.getCurrent();
        ISDCtrlHandler iSDCtrlHandler = null;
        boolean bEnableItemPriv = false;
        if (iCtrlHandler != null && iCtrlHandler instanceof ISDCtrlHandler) {
            iSDCtrlHandler = (ISDCtrlHandler)iCtrlHandler;
            bEnableItemPriv = iSDCtrlHandler.isEnableItemPriv();
        }
        Iterator<IFormItem> formItems = this.getFormItems();
        while (formItems.hasNext()) {
            iFormItem = formItems.next();
            String strPrivilegeId = iFormItem.getPrivilegeId();
            if (StringHelper.isNullOrEmpty(strPrivilegeId)) continue;
            String strHiddenItemId = StringHelper.format("%1$s%2$s", "srfip_", iFormItem.getPrivFieldName());
            if (bEnableItemPriv) {
                int nItemPriv = this.getViewController().getWebContext().getUserPrivilegeMgr().testDEField(this.getViewController().getWebContext(), strPrivilegeId);
                if ((nItemPriv & 1) == 0) {
                    iDataObject.set(strHiddenItemId, 0);
                    continue;
                }
                if (this.isOutputFormItemUpdatePrivTag()) {
                    if ((nItemPriv & 3) != 3) {
                        iDataObject.set(strHiddenItemId, 1);
                        continue;
                    }
                    iDataObject.set(strHiddenItemId, 2);
                    continue;
                }
                iDataObject.set(strHiddenItemId, 1);
                continue;
            }
            iDataObject.set(strHiddenItemId, 1);
        }
        formItems = this.getFormItems();
        while (formItems.hasNext()) {
            JSONObject itemConfig;
            String strPrivilegeId;
            iFormItem = formItems.next();
            boolean bItemReadOk = true;
            if (bEnableItemPriv && !StringHelper.isNullOrEmpty(strPrivilegeId = iFormItem.getPrivilegeId()) && (this.getViewController().getWebContext().getUserPrivilegeMgr().testDEField(this.getViewController().getWebContext(), strPrivilegeId) & 1) == 0) {
                bItemReadOk = false;
            }
            Object objValue = null;
            if (bItemReadOk) {
                boolean bSetValue = true;
                if ((iFormItem.getIgnoreInput() & 0xC) == 12) {
                    Boolean bRet = this.onTestFormItemEnabled(iFormItem, iDataObject, bUpdate);
                    if (bRet != null) {
                        if (!bRet.booleanValue()) {
                            bSetValue = false;
                        }
                    } else if (bUpdate) {
                        if ((iFormItem.getEnableCond() & 2) == 0) {
                            bSetValue = false;
                        }
                    } else if ((iFormItem.getEnableCond() & 1) == 0) {
                        bSetValue = false;
                    }
                }
                if (bSetValue) {
                    objValue = iFormItem.getOutputValue(this.getViewController().getWebContext(), iDataObject, true);
                    if (objValue == null) {
                        objValue = "";
                    }
                } else {
                    objValue = "";
                }
            } else {
                objValue = "";
            }
            JSONObjectHelper.putRaw(data, iFormItem.getName(), objValue);
            if (state != null) {
                int nState = 0;
                if (bItemReadOk) {
                    if (bUpdate) {
                        if ((iFormItem.getEnableCond() & 2) == 2) {
                            nState = 1;
                        }
                    } else if ((iFormItem.getEnableCond() & 1) == 1) {
                        nState = 1;
                    }
                }
                state.put(iFormItem.getName(), nState);
            }
            if (config == null || (itemConfig = iFormItem.getConfig(this.getViewController().getWebContext(), iDataObject, bUpdate)) == null) continue;
            config.put(iFormItem.getName(), (Object)itemConfig);
        }
    }

    @Override
    public void fillInputValues(IDataObject iDataObject, boolean bUpdate, boolean bIgnoreEmpty) throws Exception {
        Boolean bRet;
        IFormItem iFormItem;
        if (iDataObject == null) {
            throw new Exception(StringHelper.format("\u6570\u636e\u5bf9\u8c61\u65e0\u6548"));
        }
        IEntity originEntity = null;
        if (iDataObject instanceof IEntity) {
            originEntity = EntityBase.getLast((IEntity)iDataObject);
        }
        FormError formError = new FormError();
        this.onFillInputValues(iDataObject, bUpdate, bIgnoreEmpty, formError);
        if (formError.getFormItemErrorList().size() > 0) {
            throw new FormException(formError);
        }
        Iterator<IFormItem> formItems = this.getFormItems();
        while (formItems.hasNext()) {
            Object objValue;
            iFormItem = formItems.next();
            if (bUpdate) {
                if ((iFormItem.getIgnoreInput() & 2) != 2) continue;
                iDataObject.remove(iFormItem.getName());
                if ((iFormItem.getIgnoreInput() & 0x12) == 18) {
                    if (originEntity == null || !originEntity.contains(iFormItem.getName())) {
                        throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6570\u636e\u5bf9\u8c61\u5c5e\u6027[%1$s]\u539f\u503c", iFormItem.getName()));
                    }
                    iDataObject.set(iFormItem.getName(), originEntity.get(iFormItem.getName()));
                    continue;
                }
                objValue = iFormItem.getDefaultValue(this.getViewController().getWebContext(), bUpdate);
                if (StringHelper.isNullOrEmpty(objValue)) continue;
                iDataObject.set(iFormItem.getName(), objValue);
                continue;
            }
            if ((iFormItem.getIgnoreInput() & 1) != 1) continue;
            iDataObject.remove(iFormItem.getName());
            objValue = iFormItem.getDefaultValue(this.getViewController().getWebContext(), bUpdate);
            if (StringHelper.isNullOrEmpty(objValue)) continue;
            iDataObject.set(iFormItem.getName(), objValue);
        }
        formItems = this.getFormItems();
        while (formItems.hasNext()) {
            iFormItem = formItems.next();
            if ((iFormItem.getIgnoreInput() & 4) != 4) continue;
            boolean bSetValue = true;
            bRet = this.onTestFormItemEnabled(iFormItem, iDataObject, bUpdate);
            if (bRet != null) {
                if (!bRet.booleanValue()) {
                    bSetValue = false;
                }
            } else if (bUpdate) {
                if ((iFormItem.getEnableCond() & 2) == 0) {
                    bSetValue = false;
                }
            } else if ((iFormItem.getEnableCond() & 1) == 0) {
                bSetValue = false;
            }
            if (bSetValue) continue;
            iDataObject.remove(iFormItem.getName());
            Object objValue = iFormItem.getDefaultValue(this.getViewController().getWebContext(), bUpdate);
            if (StringHelper.isNullOrEmpty(objValue)) continue;
            iDataObject.set(iFormItem.getName(), objValue);
        }
        formItems = this.getFormItems();
        while (formItems.hasNext()) {
            iFormItem = formItems.next();
            if (StringHelper.compare(iFormItem.getName(), iFormItem.getDEFName(), true) == 0) continue;
            switch (iFormItem.getWriteBackDEFMode()) {
                case 1: {
                    iDataObject.set(iFormItem.getDEFName(), iDataObject.get(iFormItem.getName()));
                    break;
                }
                case 2: {
                    boolean bSetValue = true;
                    bRet = this.onTestFormItemEnabled(iFormItem, iDataObject, bUpdate);
                    if (bRet != null) {
                        if (!bRet.booleanValue()) {
                            bSetValue = false;
                        }
                    } else if (bUpdate) {
                        if ((iFormItem.getEnableCond() & 2) == 0) {
                            bSetValue = false;
                        }
                    } else if ((iFormItem.getEnableCond() & 1) == 0) {
                        bSetValue = false;
                    }
                    if (!bSetValue) break;
                    iDataObject.set(iFormItem.getDEFName(), iDataObject.get(iFormItem.getName()));
                    break;
                }
            }
        }
    }

    protected void onFillInputValues(IDataObject iDataObject, boolean bUpdate, boolean bIgnoreEmpty, FormError formError) throws Exception {
        ICtrlHandler iCtrlHandler = CtrlHandler.getCurrent();
        ISDCtrlHandler iSDCtrlHandler = null;
        boolean bEnableItemPriv = false;
        if (iCtrlHandler != null && iCtrlHandler instanceof ISDCtrlHandler) {
            iSDCtrlHandler = (ISDCtrlHandler)iCtrlHandler;
            bEnableItemPriv = iSDCtrlHandler.isEnableItemPriv();
        }
        Iterator<IFormItem> formItems = this.getFormItems();
        while (formItems.hasNext()) {
            String strPrivilegeId;
            IFormItem iFormItem = formItems.next();
            if (bEnableItemPriv && !StringHelper.isNullOrEmpty(strPrivilegeId = iFormItem.getPrivilegeId()) && (this.getViewController().getWebContext().getUserPrivilegeMgr().testDEField(this.getViewController().getWebContext(), strPrivilegeId) & 3) == 0) continue;
            try {
                Object objValue = iFormItem.getInputValue(this.getViewController().getWebContext());
                if (objValue != null && objValue instanceof String) {
                    String strValue = (String)objValue;
                    if (StringHelper.isNullOrEmpty(strValue = StringHelper.trimRight(strValue))) {
                        objValue = null;
                    }
                }
                if (!bIgnoreEmpty && objValue == null && !iFormItem.isAllowEmpty()) {
                    formError.register(iFormItem.getName(), iFormItem.getCaption(), iFormItem.getCapLanId(), 1, this.getFormItemErrorInfo(iFormItem, 1));
                    continue;
                }
                iDataObject.set(iFormItem.getName(), objValue);
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.format("\u83b7\u53d6\u8868\u5355\u9879[%1$s]\u503c\u53d1\u751f\u5f02\u5e38\uff0c%2$s", iFormItem.getName(), ex.getMessage()), (Throwable)ex);
                formError.register(iFormItem.getName(), iFormItem.getCaption(), iFormItem.getCapLanId(), 2, this.getFormItemErrorInfo(iFormItem, 2));
            }
        }
    }

    @Override
    public Object getItemInputValue(String strFormItem, IWebContext iWebContext) throws Exception {
        IFormItem iFormItem = this.getFormItem(strFormItem, false);
        Object objKeyValue = iFormItem.getInputValue(iWebContext);
        return objKeyValue;
    }

    @Override
    public void fillDefaultValues(IDataObject iDataObject, boolean bUpdate) throws Exception {
        if (iDataObject == null) {
            throw new Exception(StringHelper.format("\u6570\u636e\u5bf9\u8c61\u65e0\u6548"));
        }
        this.onFillDefaultValues(iDataObject, bUpdate);
    }

    protected void onFillDefaultValues(IDataObject iDataObject, boolean bUpdate) throws Exception {
        Iterator<IFormItem> formItems = this.getFormItems();
        while (formItems.hasNext()) {
            String strValue;
            IFormItem iFormItem = formItems.next();
            if (iDataObject.get(iFormItem.getName()) != null) continue;
            Object objValue = iFormItem.getDefaultValue(this.getViewController().getWebContext(), bUpdate);
            if (objValue != null && objValue instanceof String && StringHelper.isNullOrEmpty(strValue = (String)objValue)) {
                objValue = null;
            }
            if (objValue == null) continue;
            iDataObject.set(iFormItem.getName(), objValue);
        }
    }

    protected String getFormItemErrorInfo(IFormItem iFormItem, int nErrorType) throws Exception {
        String strErrorInfo = null;
        IWebContext iWebContext = WebContext.getCurrent();
        String strCaption = iFormItem.getCaption();
        if (iWebContext != null && !StringHelper.isNullOrEmpty(iFormItem.getCapLanResTag())) {
            strCaption = iWebContext.getLocalization(iFormItem.getCapLanResTag(), strCaption);
        }
        switch (nErrorType) {
            case 1: {
                strErrorInfo = StringHelper.format("\u3010%1$s\u3011 \u4e0d\u80fd\u8f93\u5165\u4e3a\u7a7a\uff0c\u5fc5\u987b\u4e3a\u5176\u6307\u5b9a\u503c", strCaption);
                break;
            }
            case 2: {
                strErrorInfo = StringHelper.format("\u3010%1$s\u3011 \u8f93\u5165\u5185\u5bb9\u4e0d\u6b63\u786e\uff0c\u5fc5\u987b\u8f93\u5165\u7c7b\u578b\u4e3a[%2$s]\u7684\u503c", strCaption, DataTypeHelper.getTypeName(iFormItem.getDataItem().getDataType()));
                break;
            }
            default: {
                strErrorInfo = StringHelper.format("\u3010%1$s\u3011 \u8f93\u5165\u4e0d\u6b63\u786e", strCaption);
            }
        }
        if (iWebContext != null) {
            switch (nErrorType) {
                case 1: {
                    strErrorInfo = iWebContext.getLocalization("ERROR.STD.FORM.NOTALLOWEMPTY", new Object[]{strCaption}, strErrorInfo);
                    break;
                }
                case 2: {
                    strErrorInfo = iWebContext.getLocalization("ERROR.STD.FORM.INVALIDDATATYPE", new Object[]{strCaption, DataTypeHelper.getTypeName(iFormItem.getDataItem().getDataType(), iWebContext.getLocale())}, strErrorInfo);
                    break;
                }
                default: {
                    strErrorInfo = iWebContext.getLocalization("ERROR.STD.FORM.INVALIDVALUE", new Object[]{strCaption}, strErrorInfo);
                }
            }
        }
        return strErrorInfo;
    }

    protected Boolean onTestFormItemEnabled(IFormItem iFormItem, IDataObject iDataObject, boolean bUpdate) throws Exception {
        return null;
    }

    protected boolean isOutputFormItemUpdatePrivTag() {
        return this.getViewController().getAppModel().isOutputFormItemUpdatePrivTag();
    }
}

