/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.view;

import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.sysmodel.ISystemRuntime;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.IDEDataSetViewMsgModel;
import net.ibizsys.paas.view.IViewMsgModel;
import net.ibizsys.paas.view.StaticViewMsgModel;
import net.ibizsys.psmsg.util.MsgTemplateGlobal;
import net.ibizsys.psmsg.util.MsgTemplateHelper;
import net.ibizsys.psrt.srv.common.entity.MsgSendQueue;
import net.ibizsys.psrt.srv.common.entity.MsgTemplate;
import org.hibernate.SessionFactory;

public class DEDataSetViewMsgModel
extends StaticViewMsgModel
implements IDEDataSetViewMsgModel {
    private String strDEName;
    private String strDEDataSetName;
    private String strTitleField;
    private String strTitleLanResTagField;
    private String strMsgTypeField;
    private String strMsgPosField;
    private String strRemoveFlagField;
    private String strContentField;
    private String strOrderValueField;
    private boolean bEnableCache = false;
    private int nCacheTimeout = -1;
    private String strCacheScope = null;
    private String strCacheTagField = null;
    private String strCacheTag2Field = null;
    private String strDSLink = null;
    private String strActiveDataDELogicId = null;
    protected HashMap<String, ViewMsgCache> viewMsgCacheMap = new HashMap();
    protected IDataEntityModel iDEModel = null;

    @Override
    protected void onInit() throws Exception {
        this.iDEModel = DEModelGlobal.getDEModel(this.getDEName());
        super.onInit();
    }

    @Override
    public String getDEName() {
        return this.strDEName;
    }

    @Override
    public String getDEDataSetName() {
        return this.strDEDataSetName;
    }

    @Override
    public String getTitleField() {
        return this.strTitleField;
    }

    @Override
    public String getTitleLanResTagField() {
        return this.strTitleLanResTagField;
    }

    @Override
    public String getMsgTypeField() {
        return this.strMsgTypeField;
    }

    @Override
    public String getMsgPosField() {
        return this.strMsgPosField;
    }

    @Override
    public String getRemoveFlagField() {
        return this.strRemoveFlagField;
    }

    @Override
    public String getContentField() {
        return this.strContentField;
    }

    public void setDEName(String strDEName) {
        this.strDEName = strDEName;
    }

    public void setDEDataSetName(String strDEDataSetName) {
        this.strDEDataSetName = strDEDataSetName;
    }

    public void setTitleField(String strTitleField) {
        this.strTitleField = strTitleField;
    }

    public void setTitleLanResTagField(String strTitleLanResTagField) {
        this.strTitleLanResTagField = strTitleLanResTagField;
    }

    public void setMsgTypeField(String strMsgTypeField) {
        this.strMsgTypeField = strMsgTypeField;
    }

    public void setMsgPosField(String strMsgPosField) {
        this.strMsgPosField = strMsgPosField;
    }

    public void setRemoveFlagField(String strRemoveFlagField) {
        this.strRemoveFlagField = strRemoveFlagField;
    }

    @Override
    public String getOrderValueField() {
        return this.strOrderValueField;
    }

    public void setOrderValueField(String strOrderValueField) {
        this.strOrderValueField = strOrderValueField;
    }

    public void setContentField(String strContentField) {
        this.strContentField = strContentField;
    }

    @Override
    public int fillViewMessages(IViewController iViewController, ArrayList<IViewMsgModel> viewMessageList) throws Exception {
        ArrayList<IViewMsgModel> viewMsgModelList = this.prepareViewMsgs(iViewController);
        int nTotal = 0;
        for (IViewMsgModel iViewMsgModel : viewMsgModelList) {
            nTotal += iViewMsgModel.fillViewMessages(iViewController, viewMessageList);
        }
        return nTotal;
    }

    protected ArrayList<IViewMsgModel> prepareViewMsgs(IViewController iViewController) throws Exception {
        ViewMsgCache viewMsgCache;
        Object simpleEntity = this.iDEModel.createEntity();
        this.getSystemModel().fillViewMsgActiveData((IEntity)simpleEntity, this, iViewController);
        if (!StringHelper.isNullOrEmpty(this.getActiveDataDELogicId())) {
            IService iService = this.getService(iViewController.getSessionFactory());
            iService.executeLogic(this.getActiveDataDELogicId(), (IEntity)simpleEntity);
        }
        String strCacheTag = null;
        if (this.isEnableCache() && (viewMsgCache = this.viewMsgCacheMap.get(strCacheTag = this.getCacheTag((IEntity)simpleEntity))) != null && (this.nCacheTimeout <= 0 || viewMsgCache.nLastCacheTime + (long)this.nCacheTimeout > System.currentTimeMillis())) {
            return viewMsgCache.viewMsgModelList;
        }
        ArrayList<IViewMsgModel> viewMsgModelList = this.onPrepareViewMsgs(iViewController, (IEntity)simpleEntity);
        if (strCacheTag != null) {
            ViewMsgCache viewMsgCache2 = new ViewMsgCache();
            viewMsgCache2.nLastCacheTime = System.currentTimeMillis();
            viewMsgCache2.viewMsgModelList = viewMsgModelList;
            this.viewMsgCacheMap.put(strCacheTag, viewMsgCache2);
        }
        return viewMsgModelList;
    }

    protected ArrayList<IViewMsgModel> onPrepareViewMsgs(IViewController iViewController, IEntity simpleEntity) throws Exception {
        DEDataSetFetchContext deDataSetFetchContextImpl = new DEDataSetFetchContext(null);
        deDataSetFetchContextImpl.setActiveDataObject(simpleEntity);
        deDataSetFetchContextImpl.setFetchTotalRow(false);
        deDataSetFetchContextImpl.setPaging(false);
        this.fillDEDataSetFetchContext(deDataSetFetchContextImpl);
        DBFetchResult dbFetchResult = this.fetchDEDataSet(deDataSetFetchContextImpl, iViewController.getSessionFactory());
        if (dbFetchResult.isError()) {
            throw new Exception(StringHelper.format("\u83b7\u53d6\u6570\u636e\u96c6\u53d1\u751f\u9519\u8bef\uff0c%1$s", dbFetchResult.getErrorInfo()));
        }
        ArrayList<IViewMsgModel> viewMsgModelList = new ArrayList<IViewMsgModel>();
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
                            IViewMsgModel iViewMsg = this.createViewMsg(iDataRow);
                            if (iViewMsg != null) {
                                viewMsgModelList.add(iViewMsg);
                            }
                            ++i;
                        }
                    } while (nRowCount >= nBatchSize);
                } else {
                    int i = 0;
                    while (i < nCacheRowCount) {
                        IDataRow iDataRow = iDataTable.getCachedRow(i);
                        IViewMsgModel iViewMsg = this.createViewMsg(iDataRow);
                        if (iViewMsg != null) {
                            viewMsgModelList.add(iViewMsg);
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
        return viewMsgModelList;
    }

    protected IViewMsgModel createViewMsg(IDataRow iDataRow) throws Exception {
        StaticViewMsgModel viewMsgModel = new StaticViewMsgModel();
        if (StringHelper.isNullOrEmpty(this.getMsgTemplateId())) {
            if (!StringHelper.isNullOrEmpty(this.getContentField())) {
                viewMsgModel.setMessage(DataObject.getStringValue(iDataRow.get(this.getContentField()), null));
            }
        } else {
            Object iEntity = this.iDEModel.createEntity();
            DataObject.fromDataRow(iEntity, iDataRow);
            MsgTemplate msgTemplate = MsgTemplateGlobal.getMsgTemplate(this.getMsgTemplateId());
            MsgSendQueue msgSendQueue = MsgTemplateHelper.getMsgSendQueue(1, msgTemplate, this.iDEModel, iEntity, null, null, null, null, null);
            viewMsgModel.setMessage(msgSendQueue.getContent());
            viewMsgModel.setTitle(msgSendQueue.getSubject());
        }
        if (StringHelper.isNullOrEmpty(viewMsgModel.getTitle()) && !StringHelper.isNullOrEmpty(this.getTitleField())) {
            viewMsgModel.setTitle(DataObject.getStringValue(iDataRow.get(this.getTitleField()), null));
        }
        if (!StringHelper.isNullOrEmpty(this.getMsgPosField())) {
            viewMsgModel.setPosition(DataObject.getStringValue(iDataRow.get(this.getMsgPosField()), null));
        } else {
            viewMsgModel.setPosition(this.getPosition());
        }
        if (!StringHelper.isNullOrEmpty(this.getMsgTypeField())) {
            viewMsgModel.setMessageType(DataObject.getStringValue(iDataRow.get(this.getMsgTypeField()), null));
        } else {
            viewMsgModel.setMessageType(this.getMessageType());
        }
        if (!StringHelper.isNullOrEmpty(this.getRemoveFlagField())) {
            viewMsgModel.setEnableRemove(DataObject.getIntegerValue(iDataRow.get(this.getRemoveFlagField()), 0) == 1);
        } else {
            viewMsgModel.setEnableRemove(this.isEnableRemove());
        }
        if (!StringHelper.isNullOrEmpty(this.getOrderValueField())) {
            viewMsgModel.setOrderValue(DataObject.getIntegerValue(iDataRow.get(this.getOrderValueField()), this.getOrderValue()));
        }
        if (StringHelper.isNullOrEmpty(viewMsgModel.getMessage())) {
            return null;
        }
        return viewMsgModel;
    }

    protected void fillDEDataSetFetchContext(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
        this.onFillDEDataSetFetchContext(deDataSetFetchContextImpl);
    }

    protected void onFillDEDataSetFetchContext(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
    }

    protected DBFetchResult fetchDEDataSet(DEDataSetFetchContext deDataSetFetchContextImpl, SessionFactory sessionFactory) throws Exception {
        IService iService = this.getService(sessionFactory);
        return iService.fetchDataSet(this.getDEDataSetName(), deDataSetFetchContextImpl);
    }

    protected IService getService(SessionFactory sessionFactory) throws Exception {
        if (StringHelper.isNullOrEmpty(this.getDSLink())) {
            return this.iDEModel.getService(sessionFactory);
        }
        return this.iDEModel.getService(((ISystemRuntime)this.getSystemModel()).getSessionFactory(this.getDSLink()));
    }

    @Override
    public boolean isEnableCache() {
        return this.bEnableCache;
    }

    @Override
    public String getCacheScope() {
        return this.strCacheScope;
    }

    @Override
    public int getCacheTimeout() {
        return this.nCacheTimeout;
    }

    @Override
    public String getCacheTagField() {
        return this.strCacheTagField;
    }

    @Override
    public String getCacheTag2Field() {
        return this.strCacheTag2Field;
    }

    public void setEnableCache(boolean bEnableCache) {
        this.bEnableCache = bEnableCache;
    }

    public void setCacheTimeout(int nCacheTimeout) {
        this.nCacheTimeout = nCacheTimeout;
    }

    public void setCacheScope(String strCacheScope) {
        this.strCacheScope = strCacheScope;
    }

    public void setCacheTagField(String strCacheTagField) {
        this.strCacheTagField = strCacheTagField;
    }

    public void setCacheTag2Field(String strCacheTag2Field) {
        this.strCacheTag2Field = strCacheTag2Field;
    }

    @Override
    public void resetCache() {
        this.viewMsgCacheMap.clear();
    }

    @Override
    public String getDSLink() {
        return this.strDSLink;
    }

    public void setDSLink(String strDSLink) {
        this.strDSLink = strDSLink;
    }

    @Override
    public String getActiveDataDELogicId() {
        return this.strActiveDataDELogicId;
    }

    public void setActiveDataDELogicId(String strActiveDataDELogicId) {
        this.strActiveDataDELogicId = strActiveDataDELogicId;
    }

    protected String getCacheTag(IEntity iEntity) throws Exception {
        if (StringHelper.isNullOrEmpty(this.getCacheTag2Field())) {
            return StringHelper.format("%1$s_null", iEntity.get(this.getCacheTagField()));
        }
        return StringHelper.format("%1$s_%2$s", iEntity.get(this.getCacheTagField()), iEntity.get(this.getCacheTag2Field()));
    }

    protected class ViewMsgCache {
        public ArrayList<IViewMsgModel> viewMsgModelList = new ArrayList();
        public String strCacheTag = null;
        public long nLastCacheTime = 0L;

        protected ViewMsgCache() {
        }
    }
}

