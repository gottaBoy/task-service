/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.IDataRow
 *  net.ibizsys.paas.db.IDataSet
 *  net.ibizsys.paas.db.IDataTable
 *  net.ibizsys.paas.db.impl.SimpleDataRowImpl
 *  net.ibizsys.paas.db.impl.SimpleDataSetImpl
 *  net.ibizsys.paas.db.impl.SimpleDataTableImpl
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.Base64Helper
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcdbtable.dataset;

import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataSet;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.db.impl.SimpleDataRowImpl;
import net.ibizsys.paas.db.impl.SimpleDataSetImpl;
import net.ibizsys.paas.db.impl.SimpleDataTableImpl;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.Base64Helper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcdbtable.dataset.PSDCDBTableCurDBDSModelBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBDevInst;
import net.ibizsys.pscore.srv.paasmgr.service.PSDBDevInstService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDCDBTableCurDBDSModel
extends PSDCDBTableCurDBDSModelBase {
    private static final Log log = LogFactory.getLog(PSDCDBTableCurDBDSModel.class);
    public static final String JITDBINST_PREFIX = "JITDBINST:";

    public DBFetchResult fetchDEDataSet(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        return PSDCDBTableCurDBDSModel.fetchDEDataSet(iDEDataSetFetchContext, "GETTABLES", this.getDEModel());
    }

    public static DBFetchResult fetchDEDataSet(IDEDataSetFetchContext iDEDataSetFetchContext, String string, IDataEntityModel iDataEntityModel) throws Exception {
        PSDBDevInst pSDBDevInst;
        Object object;
        DBFetchResult dBFetchResult = new DBFetchResult();
        SimpleDataSetImpl simpleDataSetImpl = new SimpleDataSetImpl();
        SimpleDataTableImpl simpleDataTableImpl = new SimpleDataTableImpl((IDataSet)simpleDataSetImpl);
        IEntity iEntity = (IEntity)iDEDataSetFetchContext.getActiveDataObject();
        if (iEntity == null) {
            throw new Exception(StringHelper.format((String)"\u5f53\u524d\u4e0a\u4e0b\u6587\u6570\u636e\u5bf9\u8c61\u65e0\u6548"));
        }
        String string2 = DataObject.getStringValue((IDataObject)iEntity, (String)"NODEID2", null);
        if (StringHelper.isNullOrEmpty((String)string2)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5f53\u524d\u5e94\u7528\u4e2d\u5fc3\u6570\u636e\u5e93");
        }
        PSDevCenterDBInstService pSDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class);
        PSDevCenterDBInst pSDevCenterDBInst = new PSDevCenterDBInst();
        pSDevCenterDBInst.setPSDevCenterDBInstId(string2);
        if (!pSDevCenterDBInstService.get((IEntity)pSDevCenterDBInst, true)) {
            object = (PSDBDevInstService)ServiceGlobal.getService(PSDBDevInstService.class);
            pSDBDevInst = new PSDBDevInst();
            pSDBDevInst.setPSDBDevInstId(string2);
            if (!object.get((IEntity)pSDBDevInst, true)) {
                throw new Exception("\u6307\u5b9a\u5e94\u7528\u4e2d\u5fc3\u6570\u636e\u5e93\u4e0d\u5b58\u5728");
            }
            pSDevCenterDBInst.setPSDevCenterDBInstId(JITDBINST_PREFIX + string2);
        }
        try {
            pSDevCenterDBInstService.executeAction("X2G_" + string, (IEntity)pSDevCenterDBInst);
        }
        catch (Exception exception) {
            log.error((Object)exception);
            throw new Exception("\u67e5\u8be2\u6570\u636e\u5e93\u6a21\u578b\u53d1\u751f\u9519\u8bef");
        }
        object = DataObject.getStringValue((IDataObject)pSDevCenterDBInst, (String)"SRFMODELLIST", null);
        if (!StringHelper.isNullOrEmpty((String)object)) {
            pSDBDevInst = JSONArray.fromString((String)new String(Base64Helper.decode((String)object), "GBK"));
            for (int i = 0; i < pSDBDevInst.length(); ++i) {
                JSONObject jSONObject = pSDBDevInst.getJSONObject(i);
                SimpleDataRowImpl simpleDataRowImpl = new SimpleDataRowImpl();
                simpleDataRowImpl.set(iDataEntityModel.getKeyDEField().getName(), (Object)jSONObject.optString("name", ""));
                simpleDataRowImpl.set(iDataEntityModel.getMajorDEField().getName(), (Object)jSONObject.optString("name", ""));
                simpleDataRowImpl.set("srfmajortext", (Object)jSONObject.optString("name", ""));
                simpleDataRowImpl.set("srfkey", (Object)jSONObject.optString("name", ""));
                simpleDataTableImpl.addCachedRow((IDataRow)simpleDataRowImpl);
            }
        }
        simpleDataSetImpl.addDataTable((IDataTable)simpleDataTableImpl);
        dBFetchResult.setDataSet((IDataSet)simpleDataSetImpl);
        return dBFetchResult;
    }
}

