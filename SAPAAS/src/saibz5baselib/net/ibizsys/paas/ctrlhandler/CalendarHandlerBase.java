/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.control.calendar.CalendarItem;
import net.ibizsys.paas.control.calendar.ICalendarItem;
import net.ibizsys.paas.controller.ViewController;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.ctrlhandler.CalendarItemFetchContext;
import net.ibizsys.paas.ctrlhandler.ICalendarHandler;
import net.ibizsys.paas.ctrlhandler.ICalendarItemFetchContext;
import net.ibizsys.paas.ctrlhandler.ICalendarRender;
import net.ibizsys.paas.ctrlhandler.ICtrlRender;
import net.ibizsys.paas.ctrlhandler.MDCtrlHandlerBase;
import net.ibizsys.paas.ctrlmodel.ICalendarItemModel;
import net.ibizsys.paas.ctrlmodel.ICalendarModel;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDEUIActionModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;

public abstract class CalendarHandlerBase
extends MDCtrlHandlerBase
implements ICalendarHandler {
    protected ICalendarModel getCalendarModel() {
        return null;
    }

    @Override
    public ICtrlModel getCtrlModel() {
        return this.getCalendarModel();
    }

    protected void fillDEDataSetFetchContext(DEDataSetFetchContext deDataSetFetchContextImpl, ICalendarItemModel iCalendarItemModel, ICalendarItemFetchContext iCalendarItemFetchContext) throws Exception {
    }

    @Override
    protected AjaxActionResult onFetch() throws Exception {
        MDAjaxActionResult mdAjaxActionResult = new MDAjaxActionResult();
        this.getWebContext().setCurAjaxActionResult(mdAjaxActionResult);
        CalendarItemFetchContext calendarItemFetchContext = new CalendarItemFetchContext(this.getWebContext());
        Iterator<ICalendarItemModel> iCalendarItemModelModels = this.getCalendarModel().getCalendarItemModels();
        while (iCalendarItemModelModels.hasNext()) {
            ICalendarItemModel iCalendarItemModel = iCalendarItemModelModels.next();
            if (!this.isOutputCalendarItemModel(calendarItemFetchContext, iCalendarItemModel)) continue;
            this.fillCalendarItemFetchResult(calendarItemFetchContext, iCalendarItemModel, mdAjaxActionResult);
        }
        return mdAjaxActionResult;
    }

    protected boolean isOutputCalendarItem(ICalendarItemFetchContext iCalendarItemFetchContext, ICalendarItem iCalendarItem) throws Exception {
        return this.getCalendarModel().isOutputCalendarItem(iCalendarItemFetchContext, iCalendarItem);
    }

    protected boolean isOutputCalendarItemModel(ICalendarItemFetchContext iCalendarItemFetchContext, ICalendarItemModel iCalendarItemModel) throws Exception {
        return this.getCalendarModel().isOutputCalendarItemModel(iCalendarItemFetchContext, iCalendarItemModel);
    }

    protected void fillCalendarItemFetchResult(ICalendarItemFetchContext iCalendarItemFetchContext, ICalendarItemModel iCalendarItemModel, MDAjaxActionResult calendarItemLoadResult) throws Exception {
        IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel(iCalendarItemModel.getDEName());
        IService iService = iDataEntityModel.getService(ViewController.getCurrent().getSessionFactory());
        SimpleEntity srcDataEntity = new SimpleEntity();
        srcDataEntity.set("BEGINTIME", iCalendarItemFetchContext.getBeginTime());
        srcDataEntity.set("ENDTIME", iCalendarItemFetchContext.getEndTime());
        if (!StringHelper.isNullOrEmpty(iCalendarItemModel.getActiveDataDELogicId())) {
            iService.executeLogic(iCalendarItemModel.getActiveDataDELogicId(), srcDataEntity);
        }
        String strQueryModelId = iCalendarItemModel.getDEDataSetName();
        DEDataSetFetchContext deDataSetFetchContext = new DEDataSetFetchContext(null);
        deDataSetFetchContext.setActiveDataObject(srcDataEntity);
        deDataSetFetchContext.setStartRow(0);
        if (iCalendarItemModel.getMaxSize() > 0) {
            deDataSetFetchContext.setPageSize(iCalendarItemModel.getMaxSize());
        } else {
            deDataSetFetchContext.setPageSize(9999);
        }
        deDataSetFetchContext.setSessionFactory(ViewController.getCurrent().getSessionFactory());
        if (this.isEnableParentCondition()) {
            this.onFillFetchParentCondition(deDataSetFetchContext.getConditionList());
        }
        this.fillDEDataSetFetchContext(deDataSetFetchContext, iCalendarItemModel, iCalendarItemFetchContext);
        DBFetchResult dbFetchResult = iService.fetchDataSet(strQueryModelId, deDataSetFetchContext);
        ArrayList<ICalendarItem> calendarItemList = new ArrayList<ICalendarItem>();
        iCalendarItemModel.fillFetchResult(iCalendarItemFetchContext, calendarItemList, dbFetchResult.getDataSet().getDataTable(0));
        ArrayList<ICalendarItem> calendarItemList2 = new ArrayList<ICalendarItem>();
        for (ICalendarItem iCalendarItem : calendarItemList) {
            if (!this.isOutputCalendarItem(iCalendarItemFetchContext, iCalendarItem)) continue;
            calendarItemList2.add(iCalendarItem);
        }
        this.fillFetchResult(calendarItemLoadResult, calendarItemList2);
    }

    protected void fillFetchResult(MDAjaxActionResult fetchResult, ArrayList<ICalendarItem> calendarItemList) throws Exception {
        ICtrlRender iCtrlRender = this.getCtrlRender();
        if (iCtrlRender != null) {
            ICalendarRender iCalendarRender = (ICalendarRender)iCtrlRender;
            iCalendarRender.fillFetchResult(this.getCalendarModel(), fetchResult, calendarItemList);
        } else {
            for (ICalendarItem iCalendarItem : calendarItemList) {
                fetchResult.getRows().add(CalendarItem.toJSONObject(iCalendarItem, false));
            }
        }
    }

    protected void fillItemResult(MDAjaxActionResult fetchResult, ICalendarItem iCalendarItem) throws Exception {
        ICtrlRender iCtrlRender = this.getCtrlRender();
        if (iCtrlRender != null) {
            ICalendarRender iCalendarRender = (ICalendarRender)iCtrlRender;
            iCalendarRender.fillItemResult(this.getCalendarModel(), fetchResult, iCalendarItem);
        } else {
            fetchResult.setData(CalendarItem.toJSONObject(iCalendarItem, false));
        }
    }

    protected String getCurItemId(IWebContext iWebContext) throws Exception {
        ICtrlRender iCtrlRender = this.getCtrlRender();
        if (iCtrlRender != null) {
            ICalendarRender iCalendarRender = (ICalendarRender)iCtrlRender;
            return iCalendarRender.getItemId(iWebContext);
        }
        return WebContext.getItemId(iWebContext);
    }

    protected String getCurItemType(IWebContext iWebContext) throws Exception {
        ICtrlRender iCtrlRender = this.getCtrlRender();
        if (iCtrlRender != null) {
            ICalendarRender iCalendarRender = (ICalendarRender)iCtrlRender;
            return iCalendarRender.getItemType(iWebContext);
        }
        return WebContext.getItemType(iWebContext);
    }

    @Override
    protected AjaxActionResult onProcessAction(String strAction) throws Exception {
        if (StringHelper.compare(strAction, "create", true) == 0) {
            return this.onCreate();
        }
        if (StringHelper.compare(strAction, "update", true) == 0) {
            return this.onUpdate();
        }
        return super.onProcessAction(strAction);
    }

    protected AjaxActionResult onCreate() throws Exception {
        MDAjaxActionResult ajaxActionResult = new MDAjaxActionResult();
        String strCalendarItemTypeId = this.getCurItemType(this.getWebContext());
        if (StringHelper.isNullOrEmpty(strCalendarItemTypeId)) {
            ajaxActionResult.setRetCode(1);
            ajaxActionResult.setErrorInfo(StringHelper.format("\u65e5\u5386\u9879\u7c7b\u578b[%1$s]\u65e0\u6548", strCalendarItemTypeId));
            return ajaxActionResult;
        }
        ICalendarItemModel calendarItem = this.getCalendarModel().getCalendarItemModel(strCalendarItemTypeId);
        if (calendarItem == null) {
            ajaxActionResult.setRetCode(1);
            ajaxActionResult.setErrorInfo(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u65e5\u5386\u9879\u7c7b\u578b[%1$s]", strCalendarItemTypeId));
            return ajaxActionResult;
        }
        try {
            IEntity iEntity = this.createCalendarItem(calendarItem);
            ICalendarItem iCalendarItem = this.getCalendarItemOutputItem(calendarItem, iEntity, false);
            this.fillItemResult(ajaxActionResult, iCalendarItem);
        }
        catch (ErrorException ex) {
            ajaxActionResult.setRetCode(ex.getErrorCode());
            ajaxActionResult.setErrorInfo(ex.getMessage());
            return ajaxActionResult;
        }
        catch (Exception ex) {
            ajaxActionResult.setRetCode(1);
            ajaxActionResult.setErrorInfo(ex.getMessage());
            return ajaxActionResult;
        }
        return ajaxActionResult;
    }

    protected IEntity createCalendarItem(ICalendarItemModel iCalendarItemModel) throws Exception {
        String strCreateDEActionName = iCalendarItemModel.getCreateDEActionName();
        if (StringHelper.isNullOrEmpty(strCreateDEActionName)) {
            throw new Exception(StringHelper.format("\u65e5\u5386\u9879[%1$s]\u4e0d\u652f\u6301\u5efa\u7acb\u64cd\u4f5c", iCalendarItemModel.getName()));
        }
        IDataEntityModel iDEModel = DEModelGlobal.getDEModel(iCalendarItemModel.getDEName());
        String strDataAccessAction = iCalendarItemModel.getCreateDataAccessAction();
        if (StringHelper.isNullOrEmpty(strDataAccessAction)) {
            strDataAccessAction = "CREATE";
        }
        Object iEntity = iDEModel.createEntity();
        this.fillCalendarItemInputValues(iCalendarItemModel, (IDataObject)iEntity, false, true);
        CallResult callResult = this.testDataAccessAction(iDEModel, (IEntity)iEntity, strDataAccessAction);
        if (!callResult.isOk()) {
            throw new ErrorException(2, callResult.getErrorInfo());
        }
        iDEModel.getService(this.getSessionFactory()).executeAction(strCreateDEActionName, (IEntity)iEntity);
        return iEntity;
    }

    protected AjaxActionResult onUpdate() throws Exception {
        MDAjaxActionResult ajaxActionResult = new MDAjaxActionResult();
        String strCalendarItemId = this.getCurItemId(this.getWebContext());
        if (StringHelper.isNullOrEmpty(strCalendarItemId)) {
            ajaxActionResult.setRetCode(1);
            ajaxActionResult.setErrorInfo(StringHelper.format("\u65e5\u5386\u9879[%1$s]\u6807\u8bc6\u65e0\u6548", strCalendarItemId));
            return ajaxActionResult;
        }
        String strRealItemId = "";
        int nPos = strCalendarItemId.indexOf(";");
        if (nPos == -1) {
            ajaxActionResult.setRetCode(1);
            ajaxActionResult.setErrorInfo(StringHelper.format("\u65e5\u5386\u9879[%1$s]\u6807\u8bc6\u65e0\u6548", strCalendarItemId));
            return ajaxActionResult;
        }
        String strItemType = strCalendarItemId.substring(0, nPos);
        strRealItemId = strCalendarItemId.substring(nPos + 1);
        ICalendarItemModel calendarItem = this.getCalendarModel().getCalendarItemModel(strItemType);
        if (calendarItem == null) {
            ajaxActionResult.setRetCode(1);
            ajaxActionResult.setErrorInfo(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u65e5\u5386\u9879\u7c7b\u578b[%1$s]", strItemType));
            return ajaxActionResult;
        }
        try {
            IEntity iEntity = this.updateCalendarItem(calendarItem, strRealItemId);
            ICalendarItem iCalendarItem = this.getCalendarItemOutputItem(calendarItem, iEntity, true);
            this.fillItemResult(ajaxActionResult, iCalendarItem);
        }
        catch (ErrorException ex) {
            ajaxActionResult.setRetCode(ex.getErrorCode());
            ajaxActionResult.setErrorInfo(ex.getMessage());
            return ajaxActionResult;
        }
        catch (Exception ex) {
            ajaxActionResult.setRetCode(1);
            ajaxActionResult.setErrorInfo(ex.getMessage());
            return ajaxActionResult;
        }
        return ajaxActionResult;
    }

    protected IEntity updateCalendarItem(ICalendarItemModel iCalendarItemModel, String strRealItemId) throws Exception {
        IEntity iEntity;
        CallResult callResult;
        String strUpdateDEActionName = iCalendarItemModel.getUpdateDEActionName();
        if (StringHelper.isNullOrEmpty(strUpdateDEActionName)) {
            throw new Exception(StringHelper.format("\u65e5\u5386\u9879[%1$s]\u4e0d\u652f\u6301\u66f4\u65b0\u64cd\u4f5c", iCalendarItemModel.getName()));
        }
        IDataEntityModel iDEModel = DEModelGlobal.getDEModel(iCalendarItemModel.getDEName());
        String strDataAccessAction = iCalendarItemModel.getUpdateDataAccessAction();
        if (StringHelper.isNullOrEmpty(strDataAccessAction)) {
            strDataAccessAction = "UPDATE";
        }
        if (!(callResult = this.testDataAccessAction(iDEModel, iEntity = this.getSimpleEntity(iDEModel, strRealItemId), strDataAccessAction)).isOk()) {
            throw new ErrorException(2, callResult.getErrorInfo());
        }
        iEntity.reset();
        this.fillCalendarItemInputValues(iCalendarItemModel, iEntity, true, true);
        iEntity.set(iDEModel.getKeyDEField().getName(), strRealItemId);
        iDEModel.getService(this.getSessionFactory()).executeAction(strUpdateDEActionName, iEntity);
        return iEntity;
    }

    protected void fillCalendarItemInputValues(ICalendarItemModel iCalendarItemModel, IDataObject iDataObject, boolean bUpdate, boolean bIgnoreEmpty) throws Exception {
        iCalendarItemModel.fillInputValues(iDataObject, bUpdate, bIgnoreEmpty);
    }

    protected ICalendarItem getCalendarItemOutputItem(ICalendarItemModel iCalendarItemModel, IDataObject iDataObject, boolean bUpdate) throws Exception {
        return iCalendarItemModel.getCalendarItem(iDataObject, bUpdate);
    }

    @Override
    protected AjaxActionResult onRemove() throws Exception {
        MDAjaxActionResult ajaxActionResult = new MDAjaxActionResult();
        String strCalendarItemId = this.getCurItemId(this.getWebContext());
        if (StringHelper.isNullOrEmpty(strCalendarItemId)) {
            ajaxActionResult.setRetCode(1);
            ajaxActionResult.setErrorInfo(StringHelper.format("\u65e5\u5386\u9879[%1$s]\u6807\u8bc6\u65e0\u6548", strCalendarItemId));
            return ajaxActionResult;
        }
        String strRealItemId = "";
        int nPos = strCalendarItemId.indexOf(";");
        if (nPos == -1) {
            ajaxActionResult.setRetCode(1);
            ajaxActionResult.setErrorInfo(StringHelper.format("\u65e5\u5386\u9879[%1$s]\u6807\u8bc6\u65e0\u6548", strCalendarItemId));
            return ajaxActionResult;
        }
        String strItemType = strCalendarItemId.substring(0, nPos);
        strRealItemId = strCalendarItemId.substring(nPos + 1);
        ICalendarItemModel calendarItem = this.getCalendarModel().getCalendarItemModel(strItemType);
        if (calendarItem == null) {
            ajaxActionResult.setRetCode(1);
            ajaxActionResult.setErrorInfo(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u65e5\u5386\u9879[%1$s]", strCalendarItemId));
            return ajaxActionResult;
        }
        try {
            this.removeCalendarItem(calendarItem, strRealItemId);
        }
        catch (ErrorException ex) {
            ajaxActionResult.setRetCode(ex.getErrorCode());
            ajaxActionResult.setErrorInfo(ex.getMessage());
            return ajaxActionResult;
        }
        catch (Exception ex) {
            ajaxActionResult.setRetCode(1);
            ajaxActionResult.setErrorInfo(ex.getMessage());
            return ajaxActionResult;
        }
        ajaxActionResult.setReloadData(true);
        return ajaxActionResult;
    }

    protected void removeCalendarItem(ICalendarItemModel iCalendarItemModel, String strRealItemId) throws Exception {
        IEntity iEntity;
        CallResult callResult;
        String strKey = strRealItemId;
        String strRemoveDEActionName = iCalendarItemModel.getRemoveDEActionName();
        if (StringHelper.isNullOrEmpty(strRemoveDEActionName)) {
            throw new Exception(StringHelper.format("\u65e5\u5386\u9879[%1$s]\u4e0d\u652f\u6301\u5220\u9664\u64cd\u4f5c", iCalendarItemModel.getName()));
        }
        IDataEntityModel iDEModel = DEModelGlobal.getDEModel(iCalendarItemModel.getDEName());
        String strDataAccessAction = iCalendarItemModel.getRemoveDataAccessAction();
        if (StringHelper.isNullOrEmpty(strDataAccessAction)) {
            strDataAccessAction = "DELETE";
        }
        if (!(callResult = this.testDataAccessAction(iDEModel, iEntity = this.getSimpleEntity(iDEModel, strKey), strDataAccessAction)).isOk()) {
            throw new ErrorException(2, callResult.getErrorInfo());
        }
        iDEModel.getService(this.getSessionFactory()).executeAction(strRemoveDEActionName, iEntity);
    }

    @Override
    protected IEntity getSimpleEntity(IDataEntityModel iDEModel, Object objKey) throws Exception {
        if (objKey != null && objKey instanceof String && ((String)objKey).indexOf("SRFTEMPKEY:") == 0) {
            return null;
        }
        Object iEntity = iDEModel.createEntity();
        iEntity.set(iDEModel.getKeyDEField().getName(), objKey);
        iDEModel.getService(this.getSessionFactory()).get(iEntity);
        return iEntity;
    }

    protected CallResult testDataAccessAction(IDataEntityModel iDEModel, IEntity iEntity, String strDataAccessAction) throws Exception {
        return this.getWebContext().getUserPrivilegeMgr().testDataAccessAction(this.getWebContext(), iDEModel, iEntity, strDataAccessAction);
    }

    @Override
    protected AjaxActionResult onUIAction() throws Exception {
        String strDEUIActionId = WebContext.getUIActionId(this.getWebContext());
        String strCalendarItemType = WebContext.getNodeType(this.getWebContext());
        IDEUIActionModel iDEUIActionModel = null;
        if (StringHelper.isNullOrEmpty(strCalendarItemType)) {
            iDEUIActionModel = (IDEUIActionModel)this.getDEModel().getDEUIAction(strDEUIActionId);
        } else {
            ICalendarItemModel iCalendarItemModel = this.getCalendarModel().getCalendarItemModel(strCalendarItemType);
            if (!StringHelper.isNullOrEmpty(iCalendarItemModel.getDEName())) {
                IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel(iCalendarItemModel.getDEName());
                iDEUIActionModel = (IDEUIActionModel)iDataEntityModel.getDEUIAction(strDEUIActionId);
            }
        }
        return this.doUIAction(iDEUIActionModel);
    }

    @Override
    protected AjaxActionResult doUIAction(IDEUIActionModel iDEUIActionModel) throws Exception {
        MDAjaxActionResult mdAjaxActionResult = this.createFetchActionResult();
        this.getWebContext().setCurAjaxActionResult(mdAjaxActionResult);
        if (StringHelper.compare(iDEUIActionModel.getActionTarget(), "NONE", true) == 0) {
            CallResult callResult;
            if (!StringHelper.isNullOrEmpty(iDEUIActionModel.getDataAccessAction()) && (callResult = iDEUIActionModel.getDEModel().getDEDataAccMgr().test(this.getWebContext(), null, iDEUIActionModel.getDataAccessAction())).isError()) {
                mdAjaxActionResult.from(callResult);
                return mdAjaxActionResult;
            }
            iDEUIActionModel.execute(null, this.getSessionFactory());
        } else {
            String strKeys = WebContext.getKeys(this.getWebContext());
            if (StringHelper.isNullOrEmpty(strKeys)) {
                strKeys = WebContext.getKey(this.getWebContext());
            }
            if (StringHelper.isNullOrEmpty(strKeys)) {
                mdAjaxActionResult.setRetCode(4);
                return mdAjaxActionResult;
            }
            ArrayList entities = iDEUIActionModel.getDEModel().createEntityList();
            String[] keys = strKeys.split("[|]");
            int i = 0;
            while (i < keys.length) {
                IEntity iEntity2;
                String strCalendarItemId = keys[i];
                int nPos = strCalendarItemId.indexOf(";");
                if (nPos == -1) {
                    mdAjaxActionResult.setRetCode(1);
                    mdAjaxActionResult.setErrorInfo(StringHelper.format("\u65e5\u5386\u9879[%1$s]\u6807\u8bc6\u65e0\u6548", strCalendarItemId));
                    return mdAjaxActionResult;
                }
                String strNodeType = strCalendarItemId.substring(0, nPos);
                String strRealItemId = strCalendarItemId.substring(nPos + 1);
                Object iEntity = iDEUIActionModel.getDEModel().createEntity();
                iEntity.set(iDEUIActionModel.getDEModel().getKeyDEField().getName(), strRealItemId);
                if (!StringHelper.isNullOrEmpty(iDEUIActionModel.getDataAccessAction()) && (iEntity2 = this.getSimpleEntity(iDEUIActionModel.getDEModel(), strRealItemId)) != null) {
                    CallResult callResult = iDEUIActionModel.getDEModel().getDEDataAccMgr().test(this.getWebContext(), iEntity2, iDEUIActionModel.getDataAccessAction());
                    if (callResult.isError()) {
                        mdAjaxActionResult.from(callResult);
                        return mdAjaxActionResult;
                    }
                    if (DataTypeHelper.compare(iDEUIActionModel.getDEModel().getKeyDEField().getStdDataType(), iEntity.get(iDEUIActionModel.getDEModel().getKeyDEField().getName()), iEntity2.get(iDEUIActionModel.getDEModel().getKeyDEField().getName())) == 0L) {
                        iEntity = iEntity2;
                    }
                }
                entities.add(iEntity);
                ++i;
            }
            iDEUIActionModel.execute(entities, this.getSessionFactory());
        }
        mdAjaxActionResult.setReloadData(iDEUIActionModel.isReloadData());
        mdAjaxActionResult.setErrorInfo(iDEUIActionModel.getSuccessMsg());
        return mdAjaxActionResult;
    }
}

