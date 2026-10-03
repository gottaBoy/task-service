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
 *  net.ibizsys.paas.web.WebContext
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset;

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
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset.PSDEUAWizardCurJITUserDSModelBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAWizard;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAWizardService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSDEUAWizardCurJITUserDSModel
extends PSDEUAWizardCurJITUserDSModelBase {
    private static final Log log = LogFactory.getLog(PSDEUAWizardCurJITUserDSModel.class);

    public DBFetchResult fetchDEDataSet(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (WebContext.getCurrent() == null) {
            throw new Exception(StringHelper.format((String)"\u5f53\u524d\u8bf7\u6c42\u73af\u5883\u65e0\u6548"));
        }
        JSONObject jSONObject = WebContext.getAppData();
        if (jSONObject == null) {
            throw new Exception(StringHelper.format((String)"\u5f53\u524d\u8bf7\u6c42\u53c2\u6570\u65e0\u6548"));
        }
        DBFetchResult dBFetchResult = new DBFetchResult();
        SimpleDataSetImpl simpleDataSetImpl = new SimpleDataSetImpl();
        PSDEUAWizard pSDEUAWizard = new PSDEUAWizard();
        pSDEUAWizard.set("pssystemid", jSONObject.optString("pssystemid", ""));
        pSDEUAWizard.set("psdevslnsysid", jSONObject.optString("psdevslnsysid", ""));
        SimpleDataTableImpl simpleDataTableImpl = new SimpleDataTableImpl((IDataSet)simpleDataSetImpl);
        PSDEUAWizardService pSDEUAWizardService = (PSDEUAWizardService)ServiceGlobal.getService(PSDEUAWizardService.class, (SessionFactory)iDEDataSetFetchContext.getSessionFactory());
        try {
            pSDEUAWizardService.executeAction("XG_LISTJITUSERS", pSDEUAWizard);
        }
        catch (Exception exception) {
            log.error((Object)exception);
            throw new Exception("\u67e5\u8be2JIT\u7528\u6237\u53d1\u751f\u9519\u8bef");
        }
        dBFetchResult.setTotalRow(0);
        String string = DataObject.getStringValue((IDataObject)pSDEUAWizard, (String)"SRFMODELLIST", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            JSONArray jSONArray = JSONArray.fromString((String)new String(Base64Helper.decode((String)string), "GBK"));
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

