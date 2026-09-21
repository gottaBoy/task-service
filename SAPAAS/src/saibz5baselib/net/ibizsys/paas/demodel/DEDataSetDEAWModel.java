/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.IDEActionWizard;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.demodel.DEActionWizardItemModel;
import net.ibizsys.paas.demodel.DEActionWizardModel;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDEActionWizardItemModel;
import net.ibizsys.paas.demodel.IDEActionWizardModel;
import net.ibizsys.paas.demodel.IDEDataSetDEAWModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.IViewWizard;

public class DEDataSetDEAWModel
extends DEActionWizardModel
implements IDEDataSetDEAWModel {
    protected ArrayList<IDEActionWizardModel> deActionWizardList = new ArrayList();
    protected HashMap<String, IDEActionWizardModel> deActionWizardMap = new HashMap();
    private Boolean bPrepareDEActionWizards = false;
    private Object objPrepareDEActionWizardsLock = new Object();
    String strAWDEName;
    String strAWDEDataSetName;
    String strAWNameField;
    String strAWKeywordField;
    String strAWSortField;
    String strAWIDEName;
    String strAWIDEDataSetName;
    String strAWINameField;
    String strAWIValueField;
    String strAWIFKeyField;
    String strAWIContentField;
    String strAWIUrlField;
    String strAWISortField;
    String strAWKeyField;

    @Override
    public String getAWDEName() {
        return this.strAWDEName;
    }

    public void setAWDEName(String strAWDEName) {
        this.strAWDEName = strAWDEName;
    }

    @Override
    public String getAWDEDataSetName() {
        return this.strAWDEDataSetName;
    }

    public void setAWDEDataSetName(String strAWDEDataSetName) {
        this.strAWDEDataSetName = strAWDEDataSetName;
    }

    @Override
    public String getAWNameField() {
        return this.strAWNameField;
    }

    public void setAWNameField(String strAWNameField) {
        this.strAWNameField = strAWNameField;
    }

    @Override
    public String getAWKeywordField() {
        return this.strAWKeywordField;
    }

    public void setAWKeywordField(String strAWKeywordField) {
        this.strAWKeywordField = strAWKeywordField;
    }

    @Override
    public String getAWSortField() {
        return this.strAWSortField;
    }

    public void setAWSortField(String strAWSortField) {
        this.strAWSortField = strAWSortField;
    }

    @Override
    public String getAWIDEName() {
        return this.strAWIDEName;
    }

    public void setAWIDEName(String strAWIDEName) {
        this.strAWIDEName = strAWIDEName;
    }

    @Override
    public String getAWIDEDataSetName() {
        return this.strAWIDEDataSetName;
    }

    public void setAWIDEDataSetName(String strAWIDEDataSetName) {
        this.strAWIDEDataSetName = strAWIDEDataSetName;
    }

    @Override
    public String getAWINameField() {
        return this.strAWINameField;
    }

    public void setAWINameField(String strAWINameField) {
        this.strAWINameField = strAWINameField;
    }

    @Override
    public String getAWIValueField() {
        return this.strAWIValueField;
    }

    public void setAWIValueField(String strAWIValueField) {
        this.strAWIValueField = strAWIValueField;
    }

    @Override
    public String getAWIFKeyField() {
        return this.strAWIFKeyField;
    }

    public void setAWIFKeyField(String strAWIFKeyField) {
        this.strAWIFKeyField = strAWIFKeyField;
    }

    @Override
    public String getAWIContentField() {
        return this.strAWIContentField;
    }

    public void setAWIContentField(String strAWIContentField) {
        this.strAWIContentField = strAWIContentField;
    }

    @Override
    public String getAWIUrlField() {
        return this.strAWIUrlField;
    }

    public void setAWIUrlField(String strAWIUrlField) {
        this.strAWIUrlField = strAWIUrlField;
    }

    @Override
    public String getAWISortField() {
        return this.strAWISortField;
    }

    public void setAWISortField(String strAWISortField) {
        this.strAWISortField = strAWISortField;
    }

    @Override
    public int fillViewWizards(IViewController iViewController, String strQuery, ArrayList<IViewWizard> viewWizardList) throws Exception {
        int nTotal = 0;
        this.prepareDEActionWizards();
        for (IDEActionWizard iDEActionWizard : this.deActionWizardList) {
            nTotal += ((IDEActionWizardModel)iDEActionWizard).fillViewWizards(iViewController, strQuery, viewWizardList);
        }
        return nTotal;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void prepareDEActionWizards() throws Exception {
        Object object = this.objPrepareDEActionWizardsLock;
        synchronized (object) {
            if (this.bPrepareDEActionWizards.booleanValue()) {
                return;
            }
            this.onPrepareDEActionWizards();
            this.bPrepareDEActionWizards = true;
        }
    }

    protected void onPrepareDEActionWizards() throws Exception {
        int i;
        IDEActionWizardModel iDEActionWizardModel;
        IDataRow iDataRow;
        int nRowCount;
        int nBatchSize;
        int nCacheRowCount;
        IDataTable iDataTable;
        this.deActionWizardMap.clear();
        this.deActionWizardList.clear();
        IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel(this.getAWDEName());
        this.strAWKeyField = iDataEntityModel.getKeyDEField().getName();
        DEDataSetFetchContext deDataSetFetchContextImpl = new DEDataSetFetchContext(null);
        this.fillAWDEDataSetFetchContext(deDataSetFetchContextImpl);
        DBFetchResult dbFetchResult = this.fetchAWDEDataSet(deDataSetFetchContextImpl);
        if (dbFetchResult.isError()) {
            throw new Exception(StringHelper.format("\u83b7\u53d6\u64cd\u4f5c\u5411\u5bfc\u6570\u636e\u96c6\u53d1\u751f\u9519\u8bef\uff0c%1$s", dbFetchResult.getErrorInfo()));
        }
        try {
            try {
                iDataTable = dbFetchResult.getDataSet().getDataTable(0);
                nCacheRowCount = iDataTable.getCachedRowCount();
                if (nCacheRowCount == -1) {
                    nBatchSize = 50;
                    do {
                        nRowCount = iDataTable.cacheRows(nBatchSize);
                        int i2 = 0;
                        while (i2 < nRowCount) {
                            iDataRow = iDataTable.getCachedRow(i2);
                            iDEActionWizardModel = this.createDEActionWizardModel(iDataRow);
                            if (iDEActionWizardModel != null) {
                                if (StringHelper.isNullOrEmpty(iDEActionWizardModel.getId())) {
                                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u64cd\u4f5c\u5411\u5bfc\u552f\u4e00\u6807\u8bc6");
                                }
                                this.deActionWizardMap.put(iDEActionWizardModel.getId(), iDEActionWizardModel);
                                this.deActionWizardList.add(iDEActionWizardModel);
                            }
                            ++i2;
                        }
                    } while (nRowCount >= nBatchSize);
                } else {
                    i = 0;
                    while (i < nCacheRowCount) {
                        IDataRow iDataRow2 = iDataTable.getCachedRow(i);
                        IDEActionWizardModel iDEActionWizardModel2 = this.createDEActionWizardModel(iDataRow2);
                        if (iDEActionWizardModel2 != null) {
                            if (StringHelper.isNullOrEmpty(iDEActionWizardModel2.getId())) {
                                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u64cd\u4f5c\u5411\u5bfc\u552f\u4e00\u6807\u8bc6");
                            }
                            this.deActionWizardMap.put(iDEActionWizardModel2.getId(), iDEActionWizardModel2);
                            this.deActionWizardList.add(iDEActionWizardModel2);
                        }
                        ++i;
                    }
                }
            }
            catch (Exception ex) {
                throw new Exception(StringHelper.format("\u83b7\u53d6\u6570\u636e\u96c6\u53d1\u751f\u9519\u8bef\uff0c%1$s", ex.getMessage()), ex);
            }
        }
        finally {
            dbFetchResult.getDataSet().close();
        }
        deDataSetFetchContextImpl = new DEDataSetFetchContext(null);
        this.fillAWIDEDataSetFetchContext(deDataSetFetchContextImpl);
        dbFetchResult = this.fetchAWIDEDataSet(deDataSetFetchContextImpl);
        if (dbFetchResult.isError()) {
            throw new Exception(StringHelper.format("\u83b7\u53d6\u64cd\u4f5c\u5411\u5bfc\u9879\u6570\u636e\u96c6\u53d1\u751f\u9519\u8bef\uff0c%1$s", dbFetchResult.getErrorInfo()));
        }
        try {
            try {
                iDataTable = dbFetchResult.getDataSet().getDataTable(0);
                nCacheRowCount = iDataTable.getCachedRowCount();
                if (nCacheRowCount == -1) {
                    nBatchSize = 50;
                    do {
                        nRowCount = iDataTable.cacheRows(nBatchSize);
                        int i3 = 0;
                        while (i3 < nRowCount) {
                            iDataRow = iDataTable.getCachedRow(i3);
                            IDEActionWizardItemModel iDEActionWizardItemModel = this.createDEActionWizardItemModel(iDataRow);
                            String strDEActionWizardId = DataObject.getStringValue(iDataRow.get(this.getAWIFKeyField()), null);
                            if (iDEActionWizardItemModel != null) {
                                if (StringHelper.isNullOrEmpty(strDEActionWizardId)) {
                                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u64cd\u4f5c\u5411\u5bfc\u552f\u4e00\u6807\u8bc6");
                                }
                                IDEActionWizardModel iDEActionWizardModel3 = this.deActionWizardMap.get(strDEActionWizardId);
                                if (iDEActionWizardModel3 == null) {
                                    throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u64cd\u4f5c\u5411\u5bfc[%1$s]", strDEActionWizardId));
                                }
                                iDEActionWizardModel3.registerDEActionWizardItemModel(iDEActionWizardItemModel);
                            }
                            ++i3;
                        }
                    } while (nRowCount >= nBatchSize);
                } else {
                    i = 0;
                    while (i < nCacheRowCount) {
                        IDataRow iDataRow3 = iDataTable.getCachedRow(i);
                        IDEActionWizardItemModel iDEActionWizardItemModel = this.createDEActionWizardItemModel(iDataRow3);
                        String strDEActionWizardId = DataObject.getStringValue(iDataRow3.get(this.getAWIFKeyField()), null);
                        if (iDEActionWizardItemModel != null) {
                            if (StringHelper.isNullOrEmpty(strDEActionWizardId)) {
                                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u64cd\u4f5c\u5411\u5bfc\u552f\u4e00\u6807\u8bc6");
                            }
                            iDEActionWizardModel = this.deActionWizardMap.get(strDEActionWizardId);
                            if (iDEActionWizardModel == null) {
                                throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u64cd\u4f5c\u5411\u5bfc[%1$s]", strDEActionWizardId));
                            }
                            iDEActionWizardModel.registerDEActionWizardItemModel(iDEActionWizardItemModel);
                        }
                        ++i;
                    }
                }
            }
            catch (Exception ex) {
                throw new Exception(StringHelper.format("\u83b7\u53d6\u6570\u636e\u96c6\u53d1\u751f\u9519\u8bef\uff0c%1$s", ex.getMessage()), ex);
            }
        }
        finally {
            dbFetchResult.getDataSet().close();
        }
    }

    protected IDEActionWizardModel createDEActionWizardModel(IDataRow iDataRow) throws Exception {
        DEActionWizardModel deActionWizardModel = new DEActionWizardModel();
        String strKey = DataObject.getStringValue(iDataRow.get(this.strAWKeyField), null);
        deActionWizardModel.setId(strKey);
        if (!StringHelper.isNullOrEmpty(this.getAWNameField())) {
            deActionWizardModel.setName(DataTypeHelper.getStringValue(iDataRow, this.getAWNameField(), null));
        }
        return deActionWizardModel;
    }

    protected IDEActionWizardItemModel createDEActionWizardItemModel(IDataRow iDataRow) throws Exception {
        DEActionWizardItemModel deActionWizardItemModel = new DEActionWizardItemModel();
        if (!StringHelper.isNullOrEmpty(this.getAWINameField())) {
            deActionWizardItemModel.setName(DataTypeHelper.getStringValue(iDataRow, this.getAWINameField(), null));
        }
        if (!StringHelper.isNullOrEmpty(this.getAWIContentField())) {
            deActionWizardItemModel.setContent(DataTypeHelper.getStringValue(iDataRow, this.getAWIContentField(), null));
        }
        if (!StringHelper.isNullOrEmpty(this.getAWIUrlField())) {
            deActionWizardItemModel.setMoreUrl(DataTypeHelper.getStringValue(iDataRow, this.getAWIUrlField(), null));
        }
        if (!StringHelper.isNullOrEmpty(this.getAWIValueField())) {
            deActionWizardItemModel.setActionValue(DataTypeHelper.getStringValue(iDataRow, this.getAWIValueField(), null));
        }
        return deActionWizardItemModel;
    }

    protected void fillAWDEDataSetFetchContext(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
        if (!StringHelper.isNullOrEmpty(this.getAWSortField())) {
            deDataSetFetchContextImpl.setSort(this.getAWSortField());
        }
        this.onFillAWDEDataSetFetchContext(deDataSetFetchContextImpl);
    }

    protected void onFillAWDEDataSetFetchContext(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
    }

    protected void fillAWIDEDataSetFetchContext(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
        if (!StringHelper.isNullOrEmpty(this.getAWISortField())) {
            deDataSetFetchContextImpl.setSort(this.getAWISortField());
        }
        this.onFillAWIDEDataSetFetchContext(deDataSetFetchContextImpl);
    }

    protected void onFillAWIDEDataSetFetchContext(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
    }

    protected DBFetchResult fetchAWDEDataSet(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
        IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel(this.getAWDEName());
        IService iService = iDataEntityModel.getService();
        return iService.fetchDataSet(this.getAWDEDataSetName(), deDataSetFetchContextImpl);
    }

    protected DBFetchResult fetchAWIDEDataSet(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
        IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel(this.getAWIDEName());
        IService iService = iDataEntityModel.getService();
        return iService.fetchDataSet(this.getAWIDEDataSetName(), deDataSetFetchContextImpl);
    }
}

