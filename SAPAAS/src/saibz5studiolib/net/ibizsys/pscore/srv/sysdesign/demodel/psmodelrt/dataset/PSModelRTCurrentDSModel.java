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
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.Base64Helper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psmodelrt.dataset;

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
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.Base64Helper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.PSModelHelper;
import net.ibizsys.pscore.srv.sysdesign.demodel.psmodelrt.dataset.PSModelRTCurrentDSModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModelRT;
import net.ibizsys.pscore.srv.sysdesign.service.PSModelRTService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSModelRTCurrentDSModel
extends PSModelRTCurrentDSModelBase {
    private static final Log log = LogFactory.getLog(PSModelRTCurrentDSModel.class);

    public DBFetchResult fetchDEDataSet(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (WebContext.getCurrent() == null) {
            throw new Exception(StringHelper.format((String)"\u5f53\u524d\u8bf7\u6c42\u73af\u5883\u65e0\u6548"));
        }
        String string = WebContext.getDEId((IWebContext)WebContext.getCurrent());
        String string2 = WebContext.getKey((IWebContext)WebContext.getCurrent());
        if (StringHelper.isNullOrEmpty((String)string2)) {
            string2 = WebContext.getKeys((IWebContext)WebContext.getCurrent());
        }
        JSONObject jSONObject = WebContext.getAppData();
        if (StringHelper.isNullOrEmpty((String)string) || StringHelper.isNullOrEmpty((String)string2) || jSONObject == null) {
            throw new Exception(StringHelper.format((String)"\u5f53\u524d\u8bf7\u6c42\u53c2\u6570\u65e0\u6548"));
        }
        DBFetchResult dBFetchResult = new DBFetchResult();
        SimpleDataSetImpl simpleDataSetImpl = new SimpleDataSetImpl();
        PSModelRT pSModelRT = new PSModelRT();
        String string3 = PSModelHelper.getModelName(string);
        if (StringHelper.isNullOrEmpty((String)string3)) {
            string3 = string;
        }
        pSModelRT.set("srfdeid", string3);
        pSModelRT.set("srfkey", string2);
        pSModelRT.set("pssystemid", jSONObject.optString("pssystemid", ""));
        pSModelRT.set("psdevslnsysid", jSONObject.optString("psdevslnsysid", ""));
        SimpleDataTableImpl simpleDataTableImpl = new SimpleDataTableImpl((IDataSet)simpleDataSetImpl);
        PSModelRTService pSModelRTService = (PSModelRTService)ServiceGlobal.getService(PSModelRTService.class, (SessionFactory)iDEDataSetFetchContext.getSessionFactory());
        try {
            pSModelRTService.executeAction("XG_LISTMODELRT", pSModelRT);
        }
        catch (Exception exception) {
            log.error((Object)exception);
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u6a21\u578b\u8fd0\u884c\u65f6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)exception.getMessage()));
        }
        dBFetchResult.setTotalRow(0);
        String string4 = DataObject.getStringValue((IDataObject)pSModelRT, (String)"SRFMODELLIST", null);
        if (!StringHelper.isNullOrEmpty((String)string4)) {
            JSONArray jSONArray = JSONArray.fromString((String)new String(Base64Helper.decode((String)string4), "GBK"));
            for (int i = 0; i < jSONArray.length(); ++i) {
                jSONObject = jSONArray.getJSONObject(i);
                SimpleDataRowImpl simpleDataRowImpl = new SimpleDataRowImpl();
                DataObject.fromJSONObject((IDataObject)simpleDataRowImpl, (JSONObject)jSONObject);
                simpleDataTableImpl.addCachedRow((IDataRow)simpleDataRowImpl);
            }
            dBFetchResult.setTotalRow(jSONArray.length());
        }
        simpleDataSetImpl.addDataTable((IDataTable)simpleDataTableImpl);
        dBFetchResult.setDataSet((IDataSet)simpleDataSetImpl);
        return dBFetchResult;
    }
}

