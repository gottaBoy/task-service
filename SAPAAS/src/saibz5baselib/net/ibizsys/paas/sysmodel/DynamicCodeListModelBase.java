/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.sysmodel;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.codelist.IDynamicCodeList;
import net.ibizsys.paas.core.DEDataSetCond;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.CodeItemModel;
import net.ibizsys.paas.sysmodel.CodeListModelBase;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psrt.srv.common.demodel.CodeItemDEModel;
import net.ibizsys.psrt.srv.common.service.CodeItemService;
import net.sf.json.JSONObject;

public abstract class DynamicCodeListModelBase
extends CodeListModelBase
implements IDynamicCodeList {
    private Boolean bPrepareCodeItems = false;
    private String strTextField = null;
    private String strValueField = null;
    private String strIconPathField = null;
    private String strIconClsField = null;
    private String strIconPathXField = null;
    private String strIconClsXField = null;
    private String strPValueField = null;
    private String strDisableField = null;
    private String strDSCondition = null;
    private Object objPrepareCodeItemsLock = new Object();
    private int nRefreshTimer = 1200000;
    private String strMinorSortField = "";
    private String strMinorSortDir = "";
    private CodeItemDEModel codeItemDEModel;
    private CodeItemService codeItemService;

    @Override
    protected void initAnnotation(Class c) {
        super.initAnnotation(c);
    }

    @Override
    public Iterator<ICodeItem> getCodeItems() throws Exception {
        this.prepareCodeItems();
        return super.getCodeItems();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void prepareCodeItems() throws Exception {
        Object object = this.objPrepareCodeItemsLock;
        synchronized (object) {
            if (!this.bPrepareCodeItems.booleanValue()) {
                this.childCodeItemList.clear();
                this.onPrepareCodeItems();
                this.bPrepareCodeItems = true;
            }
        }
    }

    protected void fillFetchConditions(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
        if (!StringHelper.isNullOrEmpty(this.getDSCondition())) {
            DEDataSetCond condition = new DEDataSetCond();
            condition.setCondType("CUSTOM");
            condition.setCustomCond(this.getDSCondition());
            deDataSetFetchContextImpl.getConditionList().add(condition);
        }
        deDataSetFetchContextImpl.setStartRow(0);
        deDataSetFetchContextImpl.setPageSize(999999);
    }

    protected void fillFetchResult(IDataTable iDataTable) throws Exception {
        ArrayList<CodeItemModel> list = new ArrayList<CodeItemModel>();
        if (iDataTable.getCachedRowCount() == -1) {
            IDataRow iDataRow;
            while ((iDataRow = iDataTable.next()) != null) {
                CodeItemModel codeItemModel = this.createCodeItemModel(iDataRow);
                list.add(codeItemModel);
            }
        } else {
            int nRows = iDataTable.getCachedRowCount();
            int i = 0;
            while (i < nRows) {
                IDataRow iDataRow = iDataTable.getCachedRow(i);
                CodeItemModel codeItemModel = this.createCodeItemModel(iDataRow);
                list.add(codeItemModel);
                ++i;
            }
        }
        String strPValueField = this.getPValueField();
        if (StringHelper.isNullOrEmpty(strPValueField)) {
            strPValueField = this.getParentValue();
        }
        if (StringHelper.isNullOrEmpty(strPValueField)) {
            for (CodeItemModel codeItemModel : list) {
                this.registerCodeItemModel(codeItemModel);
            }
        } else {
            for (CodeItemModel codeItemModel : list) {
                if (StringHelper.isNullOrEmpty(codeItemModel.getParentValue())) {
                    this.registerCodeItemModel(codeItemModel);
                }
                for (CodeItemModel subCodeItemModel : list) {
                    if (StringHelper.compare(subCodeItemModel.getParentValue(), codeItemModel.getValue(), true) != 0) continue;
                    codeItemModel.registerChildCodeItemModel(subCodeItemModel);
                }
            }
        }
    }

    protected CodeItemModel createCodeItemModel(IDataRow iDataRow) throws Exception {
        Object objValue;
        CodeItemModel codeItemModel = new CodeItemModel();
        codeItemModel.init(this, null, null);
        codeItemModel.setText(iDataRow.get(this.getTextField()).toString());
        codeItemModel.setValue(iDataRow.get(this.getValueField()).toString());
        if (!StringHelper.isNullOrEmpty(this.getIconPathField()) && (objValue = iDataRow.get(this.getIconPathField())) != null) {
            codeItemModel.setIconPath((String)objValue);
        }
        if (!StringHelper.isNullOrEmpty(this.getIconClsField()) && (objValue = iDataRow.get(this.getIconClsField())) != null) {
            codeItemModel.setIconCls((String)objValue);
        }
        if (!StringHelper.isNullOrEmpty(this.getIconPathXField()) && (objValue = iDataRow.get(this.getIconPathXField())) != null) {
            codeItemModel.setIconPathX((String)objValue);
        }
        if (!StringHelper.isNullOrEmpty(this.getIconClsXField()) && (objValue = iDataRow.get(this.getIconClsXField())) != null) {
            codeItemModel.setIconClsX((String)objValue);
        }
        if (!StringHelper.isNullOrEmpty(this.getDisableField()) && (objValue = iDataRow.get(this.getDisableField())) != null) {
            codeItemModel.setDisableSelect(DataObject.getBoolValue(objValue, codeItemModel.isDisableSelect()));
        }
        return codeItemModel;
    }

    protected String getTextField() {
        if (!StringHelper.isNullOrEmpty(this.strTextField)) {
            return this.strTextField;
        }
        return this.getDEModel().getMajorDEField().getName();
    }

    protected String getValueField() {
        if (!StringHelper.isNullOrEmpty(this.strValueField)) {
            return this.strValueField;
        }
        return this.getDEModel().getKeyDEField().getName();
    }

    protected String getPValueField() {
        return this.strPValueField;
    }

    protected String getDisableField() {
        return this.strDisableField;
    }

    protected void setTextField(String strTextField) {
        this.strTextField = strTextField;
    }

    protected void setValueField(String strValueField) {
        this.strValueField = strValueField;
    }

    protected void setPValueField(String strPValueField) {
        this.strPValueField = strPValueField;
    }

    protected void setDisableField(String strDisableField) {
        this.strDisableField = strDisableField;
    }

    protected void setIconPathField(String strIconPathField) {
        this.strIconPathField = strIconPathField;
    }

    protected void setDSCondition(String strDSCondition) {
        this.strDSCondition = strDSCondition;
    }

    protected String getIconPathField() {
        return this.strIconPathField;
    }

    protected void setIconClsField(String strIconClsField) {
        this.strIconClsField = strIconClsField;
    }

    protected String getIconClsField() {
        return this.strIconClsField;
    }

    protected void setIconPathXField(String strIconPathXField) {
        this.strIconPathXField = strIconPathXField;
    }

    protected String getIconPathXField() {
        return this.strIconPathXField;
    }

    protected void setIconClsXField(String strIconClsXField) {
        this.strIconClsXField = strIconClsXField;
    }

    protected String getIconClsXField() {
        return this.strIconClsXField;
    }

    protected String getDSCondition() {
        return this.strDSCondition;
    }

    @Override
    public String getCodeListText(String strValue, boolean bRecursion, Object activeData, IWebContext iWebContext) throws Exception {
        this.prepareCodeItems();
        return super.getCodeListText(strValue, bRecursion, activeData, iWebContext);
    }

    @Override
    public Iterator<ICodeItem> queryCodeItems(IWebContext iWebContext, IDataObject iDataObject) throws Exception {
        String strQuickSearch;
        if (this.getWebContext() != null && !StringHelper.isNullOrEmpty(strQuickSearch = WebContext.getFetchQuickSearch(this.getWebContext()))) {
            ArrayList<ICodeItem> codeItemList = new ArrayList<ICodeItem>();
            Iterator<ICodeItem> codeItems = this.getCodeItems();
            while (codeItems.hasNext()) {
                ICodeItem iCodeItem = codeItems.next();
                if (iCodeItem.getText().indexOf(strQuickSearch) == -1) continue;
                codeItemList.add(iCodeItem);
            }
            return codeItemList.iterator();
        }
        return this.getCodeItems();
    }

    private CodeItemDEModel getCodeItemDEModel() {
        if (this.codeItemDEModel == null) {
            try {
                this.codeItemDEModel = (CodeItemDEModel)DEModelGlobal.getDEModel(CodeItemDEModel.class);
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.codeItemDEModel;
    }

    protected IDataEntityModel getDEModel() {
        return this.getDEModel2();
    }

    private IDataEntityModel getDEModel2() {
        return this.getCodeItemDEModel();
    }

    private CodeItemService getRealService() {
        if (this.codeItemService == null) {
            try {
                this.codeItemService = (CodeItemService)ServiceGlobal.getService(CodeItemService.class, this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.codeItemService;
    }

    protected IService getService() {
        return this.getService2();
    }

    private IService getService2() {
        return this.getRealService();
    }

    protected void onPrepareCodeItems() throws Exception {
        DEDataSetFetchContext deDataSetFetchContextImpl = new DEDataSetFetchContext(null);
        deDataSetFetchContextImpl.setSort("ORDERVALUE");
        this.fillFetchConditions(deDataSetFetchContextImpl);
        DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
        deDataSetCondImpl.setCondType("DEFIELD");
        deDataSetCondImpl.setCondOp("EQ");
        deDataSetCondImpl.setDEFName("CODELISTID");
        deDataSetCondImpl.setCondValue(this.getId());
        deDataSetFetchContextImpl.getConditionList().add(deDataSetCondImpl);
        DBFetchResult fetchResult = this.getRealService().fetchDefault(deDataSetFetchContextImpl);
        this.fillFetchResult(fetchResult.getDataSet().getDataTable(0));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void onRefresh() throws Exception {
        Object object = this.objPrepareCodeItemsLock;
        synchronized (object) {
            this.bPrepareCodeItems = false;
        }
        this.getCodeItems();
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void fillFetchResult(MDAjaxActionResult fetchResult, IWebContext iWebContext) throws Exception {
        this.setWebContext(iWebContext);
        codeItems = this.queryCodeItems(iWebContext, null);
        if (codeItems != null) ** GOTO lbl21
        return;
lbl-1000:
        // 1 sources

        {
            iCodeItem = codeItems.next();
            jo = new JSONObject();
            jo.put("text", JSONObjectHelper.stripQuotes(iCodeItem.getText(), true));
            jo.put("realtext", JSONObjectHelper.stripQuotes(iCodeItem.getRealText(), true));
            jo.put("value", JSONObjectHelper.stripQuotes(iCodeItem.getValue(), true));
            if (iCodeItem.isDisableSelect()) {
                jo.put("disabled", true);
            }
            if (iCodeItem.getCodeItems() == null && !iCodeItem.getCodeItems().hasNext()) {
                jo.put("leaf", true);
            }
            fetchResult.getRows().add(jo);
lbl21:
            // 2 sources

            ** while (codeItems.hasNext())
        }
lbl22:
        // 1 sources

    }

    @Override
    public ICodeItem getCodeItemByText(String strText, boolean bRecursion) throws Exception {
        this.prepareCodeItems();
        return super.getCodeItemByText(strText, bRecursion);
    }

    @Override
    public int getRefreshTimer() {
        return this.nRefreshTimer;
    }

    public void setRefreshTimer(int nRefreshTimer) {
        this.nRefreshTimer = nRefreshTimer;
    }

    public String getMinorSortField() {
        return this.strMinorSortField;
    }

    public String getMinorSortDir() {
        return this.strMinorSortDir;
    }

    protected void setMinorSortField(String strMinorSortField) {
        this.strMinorSortField = strMinorSortField;
    }

    protected void setMinorSortDir(String strMinorSortDir) {
        this.strMinorSortDir = strMinorSortDir;
    }
}

