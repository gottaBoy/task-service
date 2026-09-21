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
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset.PSDEUAWizardCurDEMSStateValueDSModelBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeItemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSDEUAWizardCurDEMSStateValueDSModel
extends PSDEUAWizardCurDEMSStateValueDSModelBase {
    private static final Log log = LogFactory.getLog(PSDEUAWizardCurDEMSStateValueDSModel.class);

    public DBFetchResult fetchDEDataSet(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        return PSDEUAWizardCurDEMSStateValueDSModel.fetchDEDataSet(iDEDataSetFetchContext, 1);
    }

    public static DBFetchResult fetchDEDataSet(IDEDataSetFetchContext iDEDataSetFetchContext, int n) throws Exception {
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
        dBFetchResult.setTotalRow(0);
        simpleDataSetImpl.addDataTable((IDataTable)simpleDataTableImpl);
        dBFetchResult.setDataSet((IDataSet)simpleDataSetImpl);
        String string = jSONObject2.optString("PSDEID".toLowerCase());
        if (StringHelper.isNullOrEmpty((String)string)) {
            return dBFetchResult;
        }
        PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)sessionFactory);
        PSDEField pSDEField = new PSDEField();
        pSDEField.setPSDEId(string);
        switch (n) {
            case 1: {
                pSDEField.setStateField("STATE1");
                break;
            }
            case 2: {
                pSDEField.setStateField("STATE2");
                break;
            }
            case 3: {
                pSDEField.setStateField("STATE3");
                break;
            }
            default: {
                return dBFetchResult;
            }
        }
        if (!pSDEFieldService.select(pSDEField, true)) {
            log.error((Object)StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u5236\u5b9a\u5b9e\u4f53[%1$s]\u72b6\u6001\u5c5e\u6027%2$s", (Object)string, (Object)n));
            return dBFetchResult;
        }
        String string2 = pSDEField.getPSCodeListId();
        if (StringHelper.isNullOrEmpty((String)string2)) {
            return dBFetchResult;
        }
        PSCodeItemService pSCodeItemService = (PSCodeItemService)ServiceGlobal.getService(PSCodeItemService.class, (SessionFactory)sessionFactory);
        DEDataSetFetchContext dEDataSetFetchContext = new DEDataSetFetchContext();
        String string3 = WebContext.getFetchQuickSearch((IWebContext)WebContext.getCurrent());
        if (!StringHelper.isNullOrEmpty((String)string3) && (iDEDataSetCond = pSCodeItemService.getDEModel().getFetchQuickSearchCondition(string3)) != null) {
            dEDataSetFetchContext.getConditionList().add(iDEDataSetCond);
        }
        if (!StringHelper.isNullOrEmpty((String)string2)) {
            iDEDataSetCond = new DEDataSetCond();
            iDEDataSetCond.setCondType("DEFIELD");
            iDEDataSetCond.setCondOp("EQ");
            iDEDataSetCond.setDEFName("PSCODELISTID");
            iDEDataSetCond.setCondValue(string2);
            dEDataSetFetchContext.getConditionList().add(iDEDataSetCond);
        }
        dEDataSetFetchContext.setSort("ORDERVALUE");
        iDEDataSetCond = pSCodeItemService.fetchDefault((IDEDataSetFetchContext)dEDataSetFetchContext);
        if (iDEDataSetCond.isError()) {
            return iDEDataSetCond;
        }
        IDataTable iDataTable = iDEDataSetCond.getDataSet().getDataTable(0);
        int n2 = iDataTable.getCachedRowCount();
        if (n2 > 0) {
            simpleDataTableImpl.reset();
            for (int i = 0; i < n2; ++i) {
                IDataRow iDataRow = iDataTable.getCachedRow(i);
                SimpleDataRowImpl simpleDataRowImpl = new SimpleDataRowImpl();
                simpleDataRowImpl.set("PSUAWIZARDID", iDataRow.get("PSCODEITEMNAME"));
                simpleDataRowImpl.set("PSUAWIZARDNAME", iDataRow.get("CODEITEMVALUE"));
                simpleDataRowImpl.set("WIZARDPARAM4", iDataRow.get("PSCODEITEMNAME"));
                simpleDataTableImpl.addCachedRow((IDataRow)simpleDataRowImpl);
            }
        }
        dBFetchResult.setTotalRow(n2);
        return dBFetchResult;
    }
}

