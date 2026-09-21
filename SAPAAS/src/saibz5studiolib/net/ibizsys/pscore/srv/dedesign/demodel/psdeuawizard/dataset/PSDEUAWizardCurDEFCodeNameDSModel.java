/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.controller.ViewController
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.db.DBCallResult
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.IDataRow
 *  net.ibizsys.paas.db.IDataSet
 *  net.ibizsys.paas.db.IDataTable
 *  net.ibizsys.paas.db.SqlParamList
 *  net.ibizsys.paas.db.impl.SimpleDataRowImpl
 *  net.ibizsys.paas.db.impl.SimpleDataSetImpl
 *  net.ibizsys.paas.db.impl.SimpleDataTableImpl
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 *  net.sf.json.JSONObject
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset;

import net.ibizsys.paas.controller.ViewController;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.db.DBCallResult;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataSet;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.db.impl.SimpleDataRowImpl;
import net.ibizsys.paas.db.impl.SimpleDataSetImpl;
import net.ibizsys.paas.db.impl.SimpleDataTableImpl;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset.PSDEUAWizardCurDEFCodeNameDSModelBase;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset.PSDEUAWizardDataSetUtil;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.sf.json.JSONObject;
import org.hibernate.SessionFactory;

public class PSDEUAWizardCurDEFCodeNameDSModel
extends PSDEUAWizardCurDEFCodeNameDSModelBase {
    public DBFetchResult fetchDEDataSet(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        JSONObject jSONObject;
        if (WebContext.getCurrent() == null) {
            throw new Exception(StringHelper.format((String)"\u5f53\u524d\u8bf7\u6c42\u73af\u5883\u65e0\u6548"));
        }
        JSONObject jSONObject2 = WebContext.getReferData();
        if (jSONObject2 == null) {
            jSONObject2 = WebContext.getActiveData();
        }
        if ((jSONObject = WebContext.getAppData()) == null || jSONObject2 == null) {
            throw new Exception(StringHelper.format((String)"\u5f53\u524d\u8bf7\u6c42\u53c2\u6570\u65e0\u6548"));
        }
        SessionFactory sessionFactory = iDEDataSetFetchContext.getSessionFactory();
        if (sessionFactory == null && ViewController.getCurrent() != null) {
            sessionFactory = ViewController.getCurrent().getSessionFactory();
        }
        DBFetchResult dBFetchResult = new DBFetchResult();
        SimpleDataSetImpl simpleDataSetImpl = new SimpleDataSetImpl();
        SimpleDataTableImpl simpleDataTableImpl = new SimpleDataTableImpl((IDataSet)simpleDataSetImpl);
        dBFetchResult.setTotalRow(PSDEUAWizardDataSetUtil.appendEmptyDataRow(simpleDataTableImpl));
        simpleDataSetImpl.addDataTable((IDataTable)simpleDataTableImpl);
        dBFetchResult.setDataSet((IDataSet)simpleDataSetImpl);
        String string = jSONObject2.optString("PSDEFIELDNAME".toLowerCase());
        if (StringHelper.isNullOrEmpty((String)string)) {
            return dBFetchResult;
        }
        String string2 = WebContext.getFetchQuickSearch((IWebContext)WebContext.getCurrent());
        if (!StringHelper.isNullOrEmpty((String)string2)) {
            string2 = string2.toUpperCase();
        }
        PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)sessionFactory);
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(string);
        DBCallResult dBCallResult = pSDEFieldService.executeRaw("SELECT PSDEFIELDNAME,CODENAME FROM T_SRFPSDEFIELD WHERE PSDEFIELDNAME = ? AND CODENAME IS NOT NULL  GROUP BY PSDEFIELDNAME,CODENAME", sqlParamList);
        if (dBCallResult.isError() || dBCallResult.getDataSet() == null) {
            return dBFetchResult;
        }
        dBCallResult.getDataSet().cacheDataRow();
        IDataTable iDataTable = dBCallResult.getDataSet().getDataTable(0);
        int n = iDataTable.getCachedRowCount();
        if (n > 0) {
            simpleDataTableImpl.reset();
            for (int i = 0; i < n; ++i) {
                IDataRow iDataRow = iDataTable.getCachedRow(i);
                SimpleDataRowImpl simpleDataRowImpl = new SimpleDataRowImpl();
                Object object = iDataRow.get("CODENAME");
                simpleDataRowImpl.set("PSUAWIZARDID", object);
                simpleDataRowImpl.set("PSUAWIZARDNAME", object);
                if (!StringHelper.isNullOrEmpty((String)string2) && object.toString().toUpperCase().indexOf(string2) == -1) continue;
                simpleDataTableImpl.addCachedRow((IDataRow)simpleDataRowImpl);
            }
        }
        if (simpleDataTableImpl.getCachedRowCount() > 0) {
            dBFetchResult.setTotalRow(simpleDataTableImpl.getCachedRowCount());
        } else {
            dBFetchResult.setTotalRow(PSDEUAWizardDataSetUtil.appendEmptyDataRow(simpleDataTableImpl));
        }
        return dBFetchResult;
    }
}

