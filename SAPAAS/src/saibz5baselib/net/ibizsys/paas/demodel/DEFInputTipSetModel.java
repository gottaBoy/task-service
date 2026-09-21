/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.demodel;

import java.util.HashMap;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.IDEFInputTip;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.demodel.DEFInputTipModel;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDEFInputTipSetModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.sysmodel.SystemModelObjectBase;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DEFInputTipSetModel
extends SystemModelObjectBase
implements IDEFInputTipSetModel {
    private static final Log log = LogFactory.getLog(DEFInputTipSetModel.class);
    String strDEName;
    String strDEDataSetName;
    String strEnableCloseField;
    String strContentField;
    String strUniqueTagField;
    String strLinkField;
    protected Boolean bPrepareDEFInputTips = false;
    private Object objPrepareDEFInputTips = new Object();
    protected HashMap<String, IDEFInputTip> defInputTipMap = new HashMap();

    @Override
    public void init(ISystemModel iSystemModel) throws Exception {
        this.setSystemModel(iSystemModel);
        this.onInit();
    }

    public void setId(String strId) {
        this.strId = strId;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    @Override
    public String getDEName() {
        return this.strDEName;
    }

    public void setDEName(String strDEName) {
        this.strDEName = strDEName;
    }

    @Override
    public String getDEDataSetName() {
        return this.strDEDataSetName;
    }

    public void setDEDataSetName(String strDEDataSetName) {
        this.strDEDataSetName = strDEDataSetName;
    }

    @Override
    public String getEnableCloseField() {
        return this.strEnableCloseField;
    }

    public void setEnableCloseField(String strEnableCloseField) {
        this.strEnableCloseField = strEnableCloseField;
    }

    @Override
    public String getContentField() {
        return this.strContentField;
    }

    public void setContentField(String strContentField) {
        this.strContentField = strContentField;
    }

    @Override
    public String getUniqueTagField() {
        return this.strUniqueTagField;
    }

    public void setUniqueTagField(String strUniqueTagField) {
        this.strUniqueTagField = strUniqueTagField;
    }

    @Override
    public String getLinkField() {
        return this.strLinkField;
    }

    public void setLinkField(String strLinkField) {
        this.strLinkField = strLinkField;
    }

    @Override
    public IDEFInputTip getDEFInputTip(String strUniqueTag) throws Exception {
        return this.getDEFInputTip(strUniqueTag, false);
    }

    @Override
    public IDEFInputTip getDEFInputTip(String strUniqueTag, boolean bTryMode) throws Exception {
        this.prepareDEFInputTips();
        IDEFInputTip iDEFInputTip = this.defInputTipMap.get(strUniqueTag);
        if (iDEFInputTip == null) {
            if (!bTryMode) {
                throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u8f93\u5165\u63d0\u793a\u6807\u8bc6[%1$s]", strUniqueTag));
            }
            log.warn((Object)StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u8f93\u5165\u63d0\u793a\u6807\u8bc6[%1$s]", strUniqueTag));
        }
        return iDEFInputTip;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void prepareDEFInputTips() throws Exception {
        Object object = this.objPrepareDEFInputTips;
        synchronized (object) {
            if (this.bPrepareDEFInputTips.booleanValue()) {
                return;
            }
            this.onPrepareDEFInputTips();
            this.bPrepareDEFInputTips = true;
        }
    }

    protected void onPrepareDEFInputTips() throws Exception {
        DEDataSetFetchContext deDataSetFetchContextImpl = new DEDataSetFetchContext(null);
        deDataSetFetchContextImpl.setFetchTotalRow(false);
        deDataSetFetchContextImpl.setPaging(false);
        this.fillDEDataSetFetchContext(deDataSetFetchContextImpl);
        DBFetchResult dbFetchResult = this.fetchDEDataSet(deDataSetFetchContextImpl);
        if (dbFetchResult.isError()) {
            throw new Exception(StringHelper.format("\u83b7\u53d6\u6570\u636e\u96c6\u53d1\u751f\u9519\u8bef\uff0c%1$s", dbFetchResult.getErrorInfo()));
        }
        try {
            try {
                IDataTable iDataTable = dbFetchResult.getDataSet().getDataTable(0);
                int nCacheRowCount = iDataTable.getCachedRowCount();
                if (nCacheRowCount == -1) {
                    int nRowCount;
                    int nBatchSize = 50;
                    do {
                        nRowCount = iDataTable.cacheRows(nBatchSize);
                        int i = 0;
                        while (i < nRowCount) {
                            IDataRow iDataRow = iDataTable.getCachedRow(i);
                            IDEFInputTip iDEFInputTip = this.createDEFInputTip(iDataRow);
                            if (iDEFInputTip != null) {
                                if (StringHelper.isNullOrEmpty(iDEFInputTip.getUniqueTag())) {
                                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027\u8f93\u5165\u63d0\u793a\u552f\u4e00\u6807\u8bc6");
                                }
                                this.defInputTipMap.put(iDEFInputTip.getUniqueTag(), iDEFInputTip);
                            }
                            ++i;
                        }
                    } while (nRowCount >= nBatchSize);
                } else {
                    int i = 0;
                    while (i < nCacheRowCount) {
                        IDataRow iDataRow = iDataTable.getCachedRow(i);
                        IDEFInputTip iDEFInputTip = this.createDEFInputTip(iDataRow);
                        if (iDEFInputTip != null) {
                            if (StringHelper.isNullOrEmpty(iDEFInputTip.getUniqueTag())) {
                                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027\u8f93\u5165\u63d0\u793a\u552f\u4e00\u6807\u8bc6");
                            }
                            this.defInputTipMap.put(iDEFInputTip.getUniqueTag(), iDEFInputTip);
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

    protected IDEFInputTip createDEFInputTip(IDataRow iDataRow) throws Exception {
        DEFInputTipModel defInputTipModel = new DEFInputTipModel();
        if (!StringHelper.isNullOrEmpty(this.getContentField())) {
            defInputTipModel.setContent(DataObject.getStringValue(iDataRow.get(this.getContentField()), null));
        }
        if (!StringHelper.isNullOrEmpty(this.getEnableCloseField())) {
            defInputTipModel.setEnableClose(DataTypeHelper.getIntegerValue(iDataRow, this.getEnableCloseField(), 1) == 1);
        }
        if (!StringHelper.isNullOrEmpty(this.getLinkField())) {
            defInputTipModel.setMoreUrl(DataTypeHelper.getStringValue(iDataRow, this.getLinkField(), null));
        }
        if (!StringHelper.isNullOrEmpty(this.getUniqueTagField())) {
            defInputTipModel.setUniqueTag(DataTypeHelper.getStringValue(iDataRow, this.getUniqueTagField(), null));
        }
        return defInputTipModel;
    }

    protected void fillDEDataSetFetchContext(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
        this.onFillDEDataSetFetchContext(deDataSetFetchContextImpl);
    }

    protected void onFillDEDataSetFetchContext(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
    }

    protected DBFetchResult fetchDEDataSet(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
        IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel(this.getDEName());
        IService iService = iDataEntityModel.getService();
        return iService.fetchDataSet(this.getDEDataSetName(), deDataSetFetchContextImpl);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void resetAll() {
        Object object = this.objPrepareDEFInputTips;
        synchronized (object) {
            if (!this.bPrepareDEFInputTips.booleanValue()) {
                return;
            }
            this.defInputTipMap.clear();
            this.bPrepareDEFInputTips = false;
        }
    }
}

