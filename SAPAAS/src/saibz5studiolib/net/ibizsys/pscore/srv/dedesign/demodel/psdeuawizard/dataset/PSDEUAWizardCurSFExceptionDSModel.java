/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.controller.ViewController
 *  net.ibizsys.paas.core.DEDataSetCond
 *  net.ibizsys.paas.core.DEDataSetFetchContext
 *  net.ibizsys.paas.core.IDEDataSetCond
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.IDataRow
 *  net.ibizsys.paas.db.IDataSet
 *  net.ibizsys.paas.db.IDataTable
 *  net.ibizsys.paas.db.impl.SimpleDataRowImpl
 *  net.ibizsys.paas.db.impl.SimpleDataSetImpl
 *  net.ibizsys.paas.db.impl.SimpleDataTableImpl
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset;

import net.ibizsys.paas.controller.ViewController;
import net.ibizsys.paas.core.DEDataSetCond;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.IDEDataSetCond;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataSet;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.db.impl.SimpleDataRowImpl;
import net.ibizsys.paas.db.impl.SimpleDataSetImpl;
import net.ibizsys.paas.db.impl.SimpleDataTableImpl;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.config.service.PSSFExceptionService;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset.PSDEUAWizardCurSFExceptionDSModelBase;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset.PSDEUAWizardDataSetUtil;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSDEUAWizardCurSFExceptionDSModel
extends PSDEUAWizardCurSFExceptionDSModelBase {
    private static final Log log = LogFactory.getLog(PSDEUAWizardCurSFExceptionDSModel.class);

    public DBFetchResult fetchDEDataSet(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        IDEDataSetCond iDEDataSetCond;
        if (WebContext.getCurrent() == null) {
            throw new Exception(StringHelper.format((String)"\u5f53\u524d\u8bf7\u6c42\u73af\u5883\u65e0\u6548"));
        }
        JSONObject jSONObject = WebContext.getAppData();
        if (jSONObject == null) {
            throw new Exception(StringHelper.format((String)"\u5f53\u524d\u8bf7\u6c42\u53c2\u6570\u65e0\u6548"));
        }
        String string = jSONObject.optString("pssystemid", "");
        PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)ViewController.getCurrent().getSessionFactory());
        PSSystem pSSystem = new PSSystem();
        pSSystem.setPSSystemId(string);
        pSSystemService.get((IEntity)pSSystem);
        PSSFExceptionService pSSFExceptionService = (PSSFExceptionService)ServiceGlobal.getService(PSSFExceptionService.class);
        DEDataSetFetchContext dEDataSetFetchContext = new DEDataSetFetchContext();
        String string2 = WebContext.getFetchQuickSearch((IWebContext)WebContext.getCurrent());
        if (!StringHelper.isNullOrEmpty((String)string2) && (iDEDataSetCond = pSSFExceptionService.getDEModel().getFetchQuickSearchCondition(string2)) != null) {
            dEDataSetFetchContext.getConditionList().add(iDEDataSetCond);
        }
        if (!StringHelper.isNullOrEmpty((String)pSSystem.getPSSFId())) {
            iDEDataSetCond = new DEDataSetCond();
            iDEDataSetCond.setCondType("DEFIELD");
            iDEDataSetCond.setCondOp("EQ");
            iDEDataSetCond.setDEFName("PSSFID");
            iDEDataSetCond.setCondValue(pSSystem.getPSSFId());
            dEDataSetFetchContext.getConditionList().add(iDEDataSetCond);
        }
        dEDataSetFetchContext.setSort("PSSFEXCEPTIONNAME");
        iDEDataSetCond = pSSFExceptionService.fetchDefault((IDEDataSetFetchContext)dEDataSetFetchContext);
        if (iDEDataSetCond.isError()) {
            return iDEDataSetCond;
        }
        DBFetchResult dBFetchResult = new DBFetchResult();
        SimpleDataSetImpl simpleDataSetImpl = new SimpleDataSetImpl();
        SimpleDataTableImpl simpleDataTableImpl = new SimpleDataTableImpl((IDataSet)simpleDataSetImpl);
        simpleDataSetImpl.addDataTable((IDataTable)simpleDataTableImpl);
        dBFetchResult.setDataSet((IDataSet)simpleDataSetImpl);
        dBFetchResult.setTotalRow(PSDEUAWizardDataSetUtil.appendEmptyDataRow(simpleDataTableImpl));
        IDataTable iDataTable = iDEDataSetCond.getDataSet().getDataTable(0);
        int n = iDataTable.getCachedRowCount();
        if (n > 0) {
            simpleDataTableImpl.reset();
            for (int i = 0; i < n; ++i) {
                IDataRow iDataRow = iDataTable.getCachedRow(i);
                SimpleDataRowImpl simpleDataRowImpl = new SimpleDataRowImpl();
                simpleDataRowImpl.set("PSUAWIZARDID", iDataRow.get("PSSFEXCEPTIONNAME"));
                simpleDataRowImpl.set("PSUAWIZARDNAME", iDataRow.get("PSSFEXCEPTIONNAME"));
                simpleDataTableImpl.addCachedRow((IDataRow)simpleDataRowImpl);
            }
        }
        dBFetchResult.setTotalRow(n);
        return dBFetchResult;
    }
}

