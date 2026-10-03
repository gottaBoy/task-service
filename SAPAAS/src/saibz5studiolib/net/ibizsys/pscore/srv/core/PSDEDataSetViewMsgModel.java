/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSetFetchContext
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.data.ISimpleDataObject
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.IDataRow
 *  net.ibizsys.paas.db.IDataTable
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.view.DEDataSetViewMsgModel
 *  net.ibizsys.psmsg.util.MsgTemplateGlobal
 *  net.ibizsys.psmsg.util.MsgTemplateHelper
 *  net.ibizsys.psrt.srv.common.entity.MsgSendQueue
 *  net.ibizsys.psrt.srv.common.entity.MsgTemplate
 */
package net.ibizsys.pscore.srv.core;

import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.DEDataSetViewMsgModel;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDEDataSetViewMsgModel;
import net.ibizsys.pscore.srv.core.IPSViewMsgFilter;
import net.ibizsys.pscore.srv.core.IPSViewMsgModel;
import net.ibizsys.pscore.srv.core.PSStaticViewMsgModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomainBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsg;
import net.ibizsys.pscore.srv.util.PSCoreEntityKeeperGlobal;
import net.ibizsys.psmsg.util.MsgTemplateGlobal;
import net.ibizsys.psmsg.util.MsgTemplateHelper;
import net.ibizsys.psrt.srv.common.entity.MsgSendQueue;
import net.ibizsys.psrt.srv.common.entity.MsgTemplate;

public class PSDEDataSetViewMsgModel
extends DEDataSetViewMsgModel
implements IPSDEDataSetViewMsgModel {
    private int nLastSyncData = -1;
    protected HashMap<String, PSViewMsgCache> psViewMsgCacheMap = new HashMap();

    @Override
    public int fillPSViewMsgs(IPSViewMsgFilter iPSViewMsgFilter, ArrayList<PSViewMsg> arrayList) throws Exception {
        ArrayList<IPSViewMsgModel> arrayList2 = this.preparePSViewMsgs(iPSViewMsgFilter);
        int n = 0;
        for (IPSViewMsgModel iPSViewMsgModel : arrayList2) {
            n += iPSViewMsgModel.fillPSViewMsgs(iPSViewMsgFilter, arrayList);
        }
        return n;
    }

    protected ArrayList<IPSViewMsgModel> preparePSViewMsgs(IPSViewMsgFilter iPSViewMsgFilter) throws Exception {
        Object object;
        IEntity iEntity = this.iDEModel.createEntity();
        this.fillPSViewMsgActiveData(iEntity, iPSViewMsgFilter);
        String string = null;
        if (this.isEnableCache()) {
            int n = -1;
            if (!StringHelper.isNullOrEmpty((String)PSCoreSysServiceBase.getDefaultPSSvrDomainId())) {
                object = PSCoreEntityKeeperGlobal.getCurrent(PSCoreSysServiceBase.getCurMajorSessionFactory()).getPSSvrDomain(PSCoreSysServiceBase.getDefaultPSSvrDomainId());
                n = DataObject.getIntegerValue((Object)((PSSvrDomainBase)object).getSyncData(), Integer.valueOf(-1));
            }
            string = this.getCacheTag(iEntity);
            object = this.psViewMsgCacheMap.get(string);
            if (n == this.nLastSyncData && object != null && (this.getCacheTimeout() <= 0 || ((PSViewMsgCache)object).nLastCacheTime + (long)this.getCacheTimeout() > System.currentTimeMillis())) {
                return ((PSViewMsgCache)object).viewMsgModelList;
            }
            this.nLastSyncData = n;
        }
        ArrayList<IPSViewMsgModel> arrayList = this.onPreparePSViewMsgs(iPSViewMsgFilter, iEntity);
        if (string != null) {
            object = new PSViewMsgCache();
            ((PSViewMsgCache)object).nLastCacheTime = System.currentTimeMillis();
            ((PSViewMsgCache)object).viewMsgModelList = arrayList;
            this.psViewMsgCacheMap.put(string, (PSViewMsgCache)object);
        }
        return arrayList;
    }

    protected ArrayList<IPSViewMsgModel> onPreparePSViewMsgs(IPSViewMsgFilter iPSViewMsgFilter, IEntity iEntity) throws Exception {
        DEDataSetFetchContext dEDataSetFetchContext = new DEDataSetFetchContext(null);
        dEDataSetFetchContext.setActiveDataObject((ISimpleDataObject)iEntity);
        dEDataSetFetchContext.setFetchTotalRow(false);
        dEDataSetFetchContext.setPaging(false);
        this.fillDEDataSetFetchContext(dEDataSetFetchContext);
        DBFetchResult dBFetchResult = this.fetchDEDataSet(dEDataSetFetchContext, iPSViewMsgFilter.getSessionFactory());
        if (dBFetchResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u6570\u636e\u96c6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)dBFetchResult.getErrorInfo()));
        }
        ArrayList<IPSViewMsgModel> arrayList = new ArrayList<IPSViewMsgModel>();
        try {
            IDataTable iDataTable = dBFetchResult.getDataSet().getDataTable(0);
            int n = iDataTable.getCachedRowCount();
            if (n == -1) {
                int n2;
                int n3 = 50;
                do {
                    n2 = iDataTable.cacheRows(n3);
                    for (int i = 0; i < n2; ++i) {
                        IDataRow iDataRow = iDataTable.getCachedRow(i);
                        IPSViewMsgModel iPSViewMsgModel = this.createPSViewMsg(iDataRow);
                        if (iPSViewMsgModel == null) continue;
                        arrayList.add(iPSViewMsgModel);
                    }
                } while (n2 >= n3);
            } else {
                for (int i = 0; i < n; ++i) {
                    IDataRow iDataRow = iDataTable.getCachedRow(i);
                    IPSViewMsgModel iPSViewMsgModel = this.createPSViewMsg(iDataRow);
                    if (iPSViewMsgModel == null) continue;
                    arrayList.add(iPSViewMsgModel);
                }
            }
        }
        catch (Exception exception) {
            throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u6570\u636e\u96c6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
        finally {
            dBFetchResult.getDataSet().close();
        }
        return arrayList;
    }

    protected IPSViewMsgModel createPSViewMsg(IDataRow iDataRow) throws Exception {
        PSStaticViewMsgModel pSStaticViewMsgModel = new PSStaticViewMsgModel();
        if (StringHelper.isNullOrEmpty((String)this.getMsgTemplateId())) {
            if (!StringHelper.isNullOrEmpty((String)this.getContentField())) {
                pSStaticViewMsgModel.setMessage(DataObject.getStringValue((Object)iDataRow.get(this.getContentField()), null));
            }
        } else {
            IEntity iEntity = this.iDEModel.createEntity();
            DataObject.fromDataRow((IDataObject)iEntity, (IDataRow)iDataRow);
            MsgTemplate msgTemplate = MsgTemplateGlobal.getMsgTemplate((String)this.getMsgTemplateId());
            MsgSendQueue msgSendQueue = MsgTemplateHelper.getMsgSendQueue((int)1, (MsgTemplate)msgTemplate, (IDataEntityModel)this.iDEModel, iEntity, null, null, null, null, null);
            pSStaticViewMsgModel.setMessage(msgSendQueue.getContent());
            pSStaticViewMsgModel.setTitle(msgSendQueue.getSubject());
        }
        if (StringHelper.isNullOrEmpty((String)pSStaticViewMsgModel.getTitle()) && !StringHelper.isNullOrEmpty((String)this.getTitleField())) {
            pSStaticViewMsgModel.setTitle(DataObject.getStringValue((Object)iDataRow.get(this.getTitleField()), null));
        }
        if (!StringHelper.isNullOrEmpty((String)this.getMsgPosField())) {
            pSStaticViewMsgModel.setPosition(DataObject.getStringValue((Object)iDataRow.get(this.getMsgPosField()), null));
        } else {
            pSStaticViewMsgModel.setPosition(this.getPosition());
        }
        if (!StringHelper.isNullOrEmpty((String)this.getMsgTypeField())) {
            pSStaticViewMsgModel.setMessageType(DataObject.getStringValue((Object)iDataRow.get(this.getMsgTypeField()), null));
        } else {
            pSStaticViewMsgModel.setMessageType(this.getMessageType());
        }
        if (!StringHelper.isNullOrEmpty((String)this.getRemoveFlagField())) {
            pSStaticViewMsgModel.setEnableRemove(DataObject.getIntegerValue((Object)iDataRow.get(this.getRemoveFlagField()), (Integer)0) == 1);
            pSStaticViewMsgModel.setCloseMode(DataObject.getIntegerValue((Object)iDataRow.get(this.getRemoveFlagField()), (Integer)0));
        } else {
            pSStaticViewMsgModel.setEnableRemove(this.isEnableRemove());
            pSStaticViewMsgModel.setCloseMode(this.isEnableRemove() ? 0 : 1);
        }
        if (!StringHelper.isNullOrEmpty((String)this.getOrderValueField())) {
            pSStaticViewMsgModel.setOrderValue(DataObject.getIntegerValue((Object)iDataRow.get(this.getOrderValueField()), (Integer)this.getOrderValue()));
        }
        if (StringHelper.isNullOrEmpty((String)pSStaticViewMsgModel.getMessage())) {
            return null;
        }
        return pSStaticViewMsgModel;
    }

    public void fillPSViewMsgActiveData(IEntity iEntity, IPSViewMsgFilter iPSViewMsgFilter) throws Exception {
        iEntity.set("SRFVIEWID", (Object)iPSViewMsgFilter.getAppViewName());
        iEntity.set("SRFVIEWCLS", (Object)iPSViewMsgFilter.getAppViewName());
        if (!StringHelper.isNullOrEmpty((String)iPSViewMsgFilter.getDEName())) {
            iEntity.set("SRFDENAME", (Object)iPSViewMsgFilter.getDEName());
        }
        if (!StringHelper.isNullOrEmpty((String)iPSViewMsgFilter.getKey())) {
            iEntity.set("SRFKEY", (Object)iPSViewMsgFilter.getKey());
        }
    }

    protected class PSViewMsgCache {
        public ArrayList<IPSViewMsgModel> viewMsgModelList = new ArrayList();
        public String strCacheTag = null;
        public long nLastCacheTime = 0L;

        protected PSViewMsgCache() {
        }
    }
}
