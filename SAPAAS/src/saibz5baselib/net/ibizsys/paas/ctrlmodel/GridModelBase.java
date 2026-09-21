/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONNull
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.ctrlmodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.control.grid.GridRowError;
import net.ibizsys.paas.control.grid.GridRowException;
import net.ibizsys.paas.control.grid.IGridColumn;
import net.ibizsys.paas.control.grid.IGridDataItem;
import net.ibizsys.paas.control.grid.IGridEditItem;
import net.ibizsys.paas.ctrlhandler.CtrlHandler;
import net.ibizsys.paas.ctrlhandler.ICtrlHandler;
import net.ibizsys.paas.ctrlhandler.IMDCtrlHandler;
import net.ibizsys.paas.ctrlmodel.CtrlModelBase;
import net.ibizsys.paas.ctrlmodel.IGridModel;
import net.ibizsys.paas.data.IDataItemParam;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityException;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONNull;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class GridModelBase
extends CtrlModelBase
implements IGridModel {
    private static final Log log = LogFactory.getLog(GridModelBase.class);
    protected ArrayList<IGridColumn> gridColumnList = new ArrayList();
    protected ArrayList<IGridDataItem> gridDataItemList = new ArrayList();
    protected HashMap<String, IGridDataItem> gridDataItemMap = new HashMap();
    protected ArrayList<IGridEditItem> gridEditItemList = new ArrayList();
    protected HashMap<String, IGridEditItem> gridEditItemMap = new HashMap();

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.prepareGridColumnModels();
        this.prepareGridDataItemModels();
        this.prepareGridEditItemModels();
    }

    @Override
    public String getControlType() {
        return "GRID";
    }

    protected void prepareGridColumnModels() throws Exception {
    }

    protected void prepareGridDataItemModels() throws Exception {
    }

    protected void prepareGridEditItemModels() throws Exception {
    }

    protected IGridColumn createGridColumn(String strName) throws Exception {
        return null;
    }

    protected IGridDataItem createGridDataItem(String strName) throws Exception {
        return null;
    }

    protected IGridEditItem createGridEditItem(String strName) throws Exception {
        return null;
    }

    @Override
    public Iterator<IGridColumn> getGridColumns() {
        return this.gridColumnList.iterator();
    }

    @Override
    public Iterator<IGridDataItem> getGridDataItems() {
        return this.gridDataItemList.iterator();
    }

    @Override
    public Iterator<IGridEditItem> getGridEditItems() {
        return this.gridEditItemList.iterator();
    }

    protected void registerGridColumn(IGridColumn iGridColumn) {
        this.gridColumnList.add(iGridColumn);
    }

    protected void registerGridDataItem(IGridDataItem iGridDataItem) {
        this.gridDataItemList.add(iGridDataItem);
        this.gridDataItemMap.put(iGridDataItem.getName().toLowerCase(), iGridDataItem);
    }

    @Override
    public IGridDataItem getGridDataItem(String strName) throws Exception {
        IGridDataItem iGridDataItem = this.gridDataItemMap.get(strName.toLowerCase());
        if (iGridDataItem == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e\u9879[%1$s]", strName));
        }
        return iGridDataItem;
    }

    protected void registerGridEditItem(IGridEditItem iGridEditItem) {
        this.gridEditItemList.add(iGridEditItem);
        this.gridEditItemMap.put(iGridEditItem.getName().toLowerCase(), iGridEditItem);
    }

    @Override
    public IGridEditItem getGridEditItem(String strName, boolean bTryMode) throws Exception {
        IGridEditItem iGridEditItem = this.gridEditItemMap.get(strName.toLowerCase());
        if (iGridEditItem == null && !bTryMode) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7f16\u8f91\u9879[%1$s]", strName));
        }
        return iGridEditItem;
    }

    @Override
    public void fillFetchResult(MDAjaxActionResult fetchResult, IDataTable dt) throws Exception {
        ICtrlHandler iCtrlHandler = CtrlHandler.getCurrent();
        IMDCtrlHandler iMDCtrlHandler = null;
        boolean bEnableItemPriv = false;
        if (iCtrlHandler != null && iCtrlHandler instanceof IMDCtrlHandler) {
            iMDCtrlHandler = (IMDCtrlHandler)iCtrlHandler;
            bEnableItemPriv = iMDCtrlHandler.isEnableItemPriv();
        }
        if (dt.getCachedRowCount() == -1) {
            IDataRow iDataRow;
            while ((iDataRow = dt.next()) != null) {
                JSONObject jo = new JSONObject();
                for (IGridDataItem iGridDataItem : this.gridDataItemList) {
                    String strPrivilegeId;
                    boolean bItemReadOk = true;
                    if (bEnableItemPriv && !StringHelper.isNullOrEmpty(strPrivilegeId = iGridDataItem.getPrivilegeId()) && (this.getViewController().getWebContext().getUserPrivilegeMgr().testDEField(this.getViewController().getWebContext(), strPrivilegeId) & 1) == 0) {
                        bItemReadOk = false;
                    }
                    if (bItemReadOk) {
                        Object[] objs;
                        Object objValue;
                        boolean bGetValue;
                        try {
                            Object objValue2 = this.getGridDataItemValue(iGridDataItem, iDataRow);
                            JSONObjectHelper.put(jo, iGridDataItem.getName(), objValue2);
                            continue;
                        }
                        catch (Exception e) {
                            bGetValue = false;
                            objValue = null;
                            objs = new Object[iGridDataItem.getDataItemParams().length];
                            try {
                                int j = 0;
                                while (j < iGridDataItem.getDataItemParams().length) {
                                    IDataItemParam iDataItemParam = iGridDataItem.getDataItemParams()[j];
                                    if (iDataRow.isDBNull(iDataItemParam.getName())) {
                                        objValue = iDataItemParam.getDefaultValue();
                                        bGetValue = true;
                                    }
                                    objs[j] = iDataRow.get(iDataItemParam.getName());
                                    ++j;
                                }
                            }
                            catch (Exception ex2) {
                                log.error((Object)ex2);
                                throw e;
                            }
                        }
                        if (!bGetValue) {
                            objValue = StringHelper.format(iGridDataItem.getFormat(), objs);
                        }
                        JSONObjectHelper.put(jo, iGridDataItem.getName(), objValue);
                        String strCodeListId = "";
                        IDataItemParam[] iDataItemParamArray = iGridDataItem.getDataItemParams();
                        int n = iDataItemParamArray.length;
                        int n2 = 0;
                        while (n2 < n) {
                            IDataItemParam dip = iDataItemParamArray[n2];
                            if (!StringHelper.isNullOrEmpty(dip.getCodeListId())) {
                                strCodeListId = dip.getCodeListId();
                            }
                            ++n2;
                        }
                        if (StringHelper.isNullOrEmpty(strCodeListId)) {
                            strCodeListId = iGridDataItem.getCodeListId();
                        }
                        log.error((Object)StringHelper.format("\u4ee3\u7801\u8868[%1$s]\u5904\u7406\u9519\u8bef\uff1a%2$s", strCodeListId, e.getMessage()));
                        continue;
                    }
                    jo.put(iGridDataItem.getName(), (Object)JSONNull.getInstance());
                }
                fetchResult.getRows().add(jo);
            }
        } else {
            int nRows = dt.getCachedRowCount();
            int i = 0;
            while (i < nRows) {
                IDataRow iDataRow = dt.getCachedRow(i);
                JSONObject jo = new JSONObject();
                for (IGridDataItem iGridDataItem : this.gridDataItemList) {
                    String strPrivilegeId;
                    boolean bItemReadOk = true;
                    if (bEnableItemPriv && !StringHelper.isNullOrEmpty(strPrivilegeId = iGridDataItem.getPrivilegeId()) && (this.getViewController().getWebContext().getUserPrivilegeMgr().testDEField(this.getViewController().getWebContext(), strPrivilegeId) & 1) == 0) {
                        bItemReadOk = false;
                    }
                    if (bItemReadOk) {
                        Object[] objs;
                        Object objValue;
                        boolean bGetValue;
                        try {
                            Object objValue3 = this.getGridDataItemValue(iGridDataItem, iDataRow);
                            JSONObjectHelper.put(jo, iGridDataItem.getName(), objValue3);
                            continue;
                        }
                        catch (Exception e) {
                            bGetValue = false;
                            objValue = null;
                            objs = new Object[iGridDataItem.getDataItemParams().length];
                            try {
                                int j = 0;
                                while (j < iGridDataItem.getDataItemParams().length) {
                                    IDataItemParam iDataItemParam = iGridDataItem.getDataItemParams()[j];
                                    if (iDataRow.isDBNull(iDataItemParam.getName())) {
                                        objValue = iDataItemParam.getDefaultValue();
                                        bGetValue = true;
                                    }
                                    objs[j] = iDataRow.get(iDataItemParam.getName());
                                    ++j;
                                }
                            }
                            catch (Exception ex2) {
                                log.error((Object)ex2);
                                throw e;
                            }
                        }
                        if (!bGetValue) {
                            objValue = StringHelper.format(iGridDataItem.getFormat(), objs);
                        }
                        JSONObjectHelper.put(jo, iGridDataItem.getName(), objValue);
                        String strCodeListId = "";
                        IDataItemParam[] iDataItemParamArray = iGridDataItem.getDataItemParams();
                        int n = iDataItemParamArray.length;
                        int n3 = 0;
                        while (n3 < n) {
                            IDataItemParam dip = iDataItemParamArray[n3];
                            if (!StringHelper.isNullOrEmpty(dip.getCodeListId())) {
                                strCodeListId = dip.getCodeListId();
                            }
                            ++n3;
                        }
                        if (StringHelper.isNullOrEmpty(strCodeListId)) {
                            strCodeListId = iGridDataItem.getCodeListId();
                        }
                        log.error((Object)StringHelper.format("\u4ee3\u7801\u8868[%1$s]\u5904\u7406\u9519\u8bef\uff1a%2$s", strCodeListId, e.getMessage()));
                        continue;
                    }
                    jo.put(iGridDataItem.getName(), (Object)JSONNull.getInstance());
                }
                fetchResult.getRows().add(jo);
                ++i;
            }
        }
    }

    protected Object getGridDataItemValue(IGridDataItem iGridDataItem, IDataRow iDataRow) throws Exception {
        Object objValue = iGridDataItem.getValue(this.getViewController().getWebContext(), iDataRow);
        if (objValue == null) {
            return JSONNull.getInstance();
        }
        return objValue;
    }

    @Override
    public boolean convertEntityFieldError(EntityFieldError entityFieldError) throws Exception {
        IGridEditItem iGridEditItem = this.getGridEditItem(entityFieldError.getFieldName(), true);
        if (iGridEditItem != null) {
            if (WebContext.getCurrent() != null) {
                entityFieldError.setFieldLogicName(WebContext.getCurrent().getLocalization(iGridEditItem.getCapLanId(), iGridEditItem.getCaption()));
            } else {
                entityFieldError.setFieldLogicName(iGridEditItem.getCaption());
            }
            return true;
        }
        return false;
    }

    @Override
    public void fillRowOutputDatas(IDataObject iDataObject, boolean bUpdate, JSONObject data, JSONObject state, JSONObject config) throws Exception {
        IGridEditItem iGridEditItem;
        if (iDataObject == null) {
            throw new Exception(StringHelper.format("\u6570\u636e\u5bf9\u8c61\u65e0\u6548"));
        }
        Iterator<IGridEditItem> gridEditItems = this.getGridEditItems();
        while (gridEditItems.hasNext()) {
            iGridEditItem = gridEditItems.next();
            String strPrivilegeId = iGridEditItem.getPrivilegeId();
            StringHelper.isNullOrEmpty(strPrivilegeId);
        }
        gridEditItems = this.getGridEditItems();
        while (gridEditItems.hasNext()) {
            JSONObject itemConfig;
            iGridEditItem = gridEditItems.next();
            Object objValue = iGridEditItem.getOutputValue(this.getViewController().getWebContext(), iDataObject, true);
            if (objValue == null) {
                objValue = "";
            }
            JSONObjectHelper.put(data, iGridEditItem.getName(), objValue);
            if (state != null) {
                int nState = 0;
                if (bUpdate) {
                    if ((iGridEditItem.getEnableCond() & 2) > 0) {
                        nState = 1;
                    }
                } else if ((iGridEditItem.getEnableCond() & 1) > 0) {
                    nState = 1;
                }
                state.put(iGridEditItem.getName(), nState);
            }
            if (config == null || (itemConfig = iGridEditItem.getConfig(this.getViewController().getWebContext(), iDataObject, bUpdate)) == null) continue;
            config.put(iGridEditItem.getName(), (Object)itemConfig);
        }
        Iterator<IGridDataItem> gridDataItems = this.getGridDataItems();
        while (gridDataItems.hasNext()) {
            IGridDataItem iGridDataItem = gridDataItems.next();
            if (data.has(iGridDataItem.getName())) continue;
            Object objValue = iGridDataItem.getValue(this.getViewController().getWebContext(), iDataObject);
            if (objValue == null) {
                objValue = "";
            }
            JSONObjectHelper.put(data, iGridDataItem.getName(), objValue);
        }
    }

    @Override
    public void fillRowInputValues(IDataObject iDataObject, boolean bUpdate, boolean bIgnoreEmpty) throws Exception {
        boolean bRet = true;
        if (iDataObject == null) {
            throw new Exception(StringHelper.format("\u6570\u636e\u5bf9\u8c61\u65e0\u6548"));
        }
        GridRowError gridRowError = new GridRowError();
        this.onFillInputValues(iDataObject, bUpdate, bIgnoreEmpty, gridRowError);
        if (gridRowError.getGridEditItemErrorList().size() > 0) {
            throw new GridRowException(gridRowError);
        }
        Iterator<IGridEditItem> gridEditItems = this.getGridEditItems();
        while (gridEditItems.hasNext()) {
            Object objValue;
            IGridEditItem iGridEditItem = gridEditItems.next();
            if (bUpdate) {
                if ((iGridEditItem.getIgnoreInput() & 2) <= 0) continue;
                iDataObject.remove(iGridEditItem.getName());
                objValue = iGridEditItem.getDefaultValue(this.getViewController().getWebContext(), bUpdate);
                if (StringHelper.isNullOrEmpty(objValue)) continue;
                iDataObject.set(iGridEditItem.getName(), objValue);
                continue;
            }
            if ((iGridEditItem.getIgnoreInput() & 1) <= 0) continue;
            iDataObject.remove(iGridEditItem.getName());
            objValue = iGridEditItem.getDefaultValue(this.getViewController().getWebContext(), bUpdate);
            if (StringHelper.isNullOrEmpty(objValue)) continue;
            iDataObject.set(iGridEditItem.getName(), objValue);
        }
    }

    protected void onFillInputValues(IDataObject iDataObject, boolean bUpdate, boolean bIgnoreEmpty, GridRowError gridRowError) throws Exception {
        Iterator<IGridEditItem> gridEditItems = this.getGridEditItems();
        while (gridEditItems.hasNext()) {
            IGridEditItem iGridEditItem = gridEditItems.next();
            try {
                Object objValue = iGridEditItem.getInputValue(this.getViewController().getWebContext());
                if (objValue != null && objValue instanceof String) {
                    String strValue = (String)objValue;
                    if (StringHelper.isNullOrEmpty(strValue = StringHelper.trimRight(strValue))) {
                        objValue = null;
                    }
                }
                if (!bIgnoreEmpty && objValue == null && !iGridEditItem.isAllowEmpty()) {
                    gridRowError.register(iGridEditItem.getName(), iGridEditItem.getCaption(), iGridEditItem.getCapLanId(), 1, this.getGridEditItemErrorInfo(iGridEditItem, 1));
                    continue;
                }
                iDataObject.set(iGridEditItem.getName(), objValue);
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.format("\u83b7\u53d6\u7f16\u8f91\u9879[%1$s]\u503c\u53d1\u751f\u5f02\u5e38\uff0c%2$s", iGridEditItem.getName(), ex.getMessage()), (Throwable)ex);
                gridRowError.register(iGridEditItem.getName(), iGridEditItem.getCaption(), iGridEditItem.getCapLanId(), 2, this.getGridEditItemErrorInfo(iGridEditItem, 2));
            }
        }
    }

    @Override
    public Object getGridEditItemInputValue(String strGridEditItem, IWebContext iWebContext) throws Exception {
        IGridEditItem iGridEditItem = this.getGridEditItem(strGridEditItem, false);
        Object objKeyValue = iGridEditItem.getInputValue(iWebContext);
        return objKeyValue;
    }

    @Override
    public void fillRowDefaultValues(IDataObject iDataObject, boolean bUpdate) throws Exception {
        boolean bRet = true;
        if (iDataObject == null) {
            throw new Exception(StringHelper.format("\u6570\u636e\u5bf9\u8c61\u65e0\u6548"));
        }
        this.onFillRowDefaultValues(iDataObject, bUpdate);
    }

    protected void onFillRowDefaultValues(IDataObject iDataObject, boolean bUpdate) throws Exception {
        Iterator<IGridEditItem> gridEditItems = this.getGridEditItems();
        while (gridEditItems.hasNext()) {
            String strValue;
            IGridEditItem iGridEditItem = gridEditItems.next();
            if (iDataObject.get(iGridEditItem.getName()) != null) continue;
            Object objValue = iGridEditItem.getDefaultValue(this.getViewController().getWebContext(), bUpdate);
            if (objValue != null && objValue instanceof String && StringHelper.isNullOrEmpty(strValue = (String)objValue)) {
                objValue = null;
            }
            if (objValue == null) continue;
            iDataObject.set(iGridEditItem.getName(), objValue);
        }
    }

    @Override
    public void testRowValueRule(IService iService, IDataObject iDataObject, boolean bUpdate) throws Exception {
        EntityError entityError = new EntityError();
        this.onTestRowValueRule(iService, iDataObject, bUpdate, entityError);
        if (entityError.hasError()) {
            throw new EntityException(entityError);
        }
    }

    protected void onTestRowValueRule(IService iService, IDataObject iDataObject, boolean bUpdate, EntityError entityError) throws Exception {
    }

    protected String getGridEditItemErrorInfo(IGridEditItem iGridEditItem, int nErrorType) throws Exception {
        switch (nErrorType) {
            case 1: {
                return StringHelper.format("\u3010%1$s\u3011 \u4e0d\u80fd\u8f93\u5165\u4e3a\u7a7a\uff0c\u5fc5\u987b\u4e3a\u5176\u6307\u5b9a\u503c", iGridEditItem.getCaption());
            }
            case 2: {
                return StringHelper.format("\u3010%1$s\u3011 \u8f93\u5165\u5185\u5bb9\u4e0d\u6b63\u786e\uff0c\u5fc5\u987b\u8f93\u5165\u7c7b\u578b\u4e3a[%2$s]\u7684\u503c", iGridEditItem.getCaption(), DataTypeHelper.getTypeName(iGridEditItem.getDataItem().getDataType()));
            }
        }
        return StringHelper.format("\u3010%1$s\u3011 \u8f93\u5165\u4e0d\u6b63\u786e", iGridEditItem.getCaption());
    }

    @Override
    public String getColumnExcelText(IGridColumn iGridColumn, IWebContext iWebContext, Object object, boolean bEnableItemPrivilege) throws Exception {
        return iGridColumn.getExcelText(iWebContext, object, bEnableItemPrivilege);
    }
}

