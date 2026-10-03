/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.controller.ViewController
 *  net.ibizsys.paas.core.DEDataSetCond
 *  net.ibizsys.paas.core.DEDataSetFetchContext
 *  net.ibizsys.paas.core.IDEDataSetCond
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.IDataRow
 *  net.ibizsys.paas.db.IDataSet
 *  net.ibizsys.paas.db.IDataTable
 *  net.ibizsys.paas.db.impl.SimpleDataRowImpl
 *  net.ibizsys.paas.db.impl.SimpleDataSetImpl
 *  net.ibizsys.paas.db.impl.SimpleDataTableImpl
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.util.freemarker.DataContextMethod
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 *  net.sf.json.JSONObject
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset;

import net.ibizsys.paas.controller.ViewController;
import net.ibizsys.paas.core.DEDataSetCond;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.IDEDataSetCond;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataSet;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.db.impl.SimpleDataRowImpl;
import net.ibizsys.paas.db.impl.SimpleDataSetImpl;
import net.ibizsys.paas.db.impl.SimpleDataTableImpl;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.freemarker.DataContextMethod;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset.PSDEUAWizardCurDEDEFNameDSModelBase;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset.PSDEUAWizardDataSetUtil;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.sf.json.JSONObject;
import org.hibernate.SessionFactory;

public class PSDEUAWizardCurDEDEFNameDSModel
extends PSDEUAWizardCurDEDEFNameDSModelBase {
    public DBFetchResult fetchDEDataSet(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        IDEDataSetCond iDEDataSetCond;
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
        Object object = DataContextMethod.getValue((String)"psdeid", (SessionFactory)sessionFactory);
        if (StringHelper.isNullOrEmpty((Object)object)) {
            return dBFetchResult;
        }
        String string = (String)object;
        if (StringHelper.isNullOrEmpty((String)string)) {
            return dBFetchResult;
        }
        PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)sessionFactory);
        DEDataSetFetchContext dEDataSetFetchContext = new DEDataSetFetchContext();
        String string2 = WebContext.getFetchQuickSearch((IWebContext)WebContext.getCurrent());
        if (!StringHelper.isNullOrEmpty((String)string2) && (iDEDataSetCond = pSDEFieldService.getDEModel().getFetchQuickSearchCondition(string2)) != null) {
            dEDataSetFetchContext.getConditionList().add(iDEDataSetCond);
        }
        if (!StringHelper.isNullOrEmpty((String)string)) {
            DEDataSetCond dEDataSetCond = new DEDataSetCond();
            dEDataSetCond.setCondType("DEFIELD");
            dEDataSetCond.setCondOp("EQ");
            dEDataSetCond.setDEFName("PSDEID");
            dEDataSetCond.setCondValue(string);
            dEDataSetFetchContext.getConditionList().add(dEDataSetCond);
        }
        dEDataSetFetchContext.setSort("PSDEFIELDNAME");
        DBFetchResult fetchResult = pSDEFieldService.fetchDefault((IDEDataSetFetchContext)dEDataSetFetchContext);
        if (fetchResult.isError()) {
            return fetchResult;
        }
        IDataTable iDataTable = fetchResult.getDataSet().getDataTable(0);
        int n = iDataTable.getCachedRowCount();
        if (n > 0) {
            simpleDataTableImpl.reset();
            for (int i = 0; i < n; ++i) {
                IDataRow iDataRow = iDataTable.getCachedRow(i);
                SimpleDataRowImpl simpleDataRowImpl = new SimpleDataRowImpl();
                String string3 = DataObject.getStringValue((Object)iDataRow.get("PSDEFIELDNAME"), (String)"");
                if (this.isToLowerCase()) {
                    string3 = string3.toLowerCase();
                }
                simpleDataRowImpl.set("PSUAWIZARDID", (Object)string3);
                simpleDataRowImpl.set("PSUAWIZARDNAME", (Object)string3);
                simpleDataRowImpl.set("WIZARDPARAM4", iDataRow.get("LOGICNAME"));
                simpleDataTableImpl.addCachedRow((IDataRow)simpleDataRowImpl);
            }
        }
        dBFetchResult.setTotalRow(n);
        return dBFetchResult;
    }

    protected boolean isToLowerCase() {
        return false;
    }
}
