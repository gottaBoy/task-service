/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSetCond
 *  net.ibizsys.paas.core.DEDataSetFetchContext
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

import net.ibizsys.paas.core.DEDataSetCond;
import net.ibizsys.paas.core.DEDataSetFetchContext;
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
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.service.PSVarSampleValueService;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset.PSDEUAWizardValueFmtDSModelBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSDEUAWizardValueFmtDSModel
extends PSDEUAWizardValueFmtDSModelBase {
    private static final Log log = LogFactory.getLog(PSDEUAWizardValueFmtDSModel.class);

    public DBFetchResult fetchDEDataSet(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DEDataSetCond dEDataSetCond;
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
        DBFetchResult dBFetchResult = new DBFetchResult();
        SimpleDataSetImpl simpleDataSetImpl = new SimpleDataSetImpl();
        SimpleDataTableImpl simpleDataTableImpl = new SimpleDataTableImpl((IDataSet)simpleDataSetImpl);
        dBFetchResult.setTotalRow(0);
        simpleDataSetImpl.addDataTable((IDataTable)simpleDataTableImpl);
        dBFetchResult.setDataSet((IDataSet)simpleDataSetImpl);
        PSVarSampleValueService pSVarSampleValueService = (PSVarSampleValueService)ServiceGlobal.getService(PSVarSampleValueService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        DEDataSetFetchContext dEDataSetFetchContext = new DEDataSetFetchContext();
        String string = WebContext.getFetchQuickSearch((IWebContext)WebContext.getCurrent());
        if (!StringHelper.isNullOrEmpty((String)string) && (dEDataSetCond = pSVarSampleValueService.getDEModel().getFetchQuickSearchCondition(string)) != null) {
            dEDataSetFetchContext.getConditionList().add(dEDataSetCond);
        }
        dEDataSetCond = new DEDataSetCond();
        dEDataSetCond.setCondType("DEFIELD");
        dEDataSetCond.setCondOp("EQ");
        dEDataSetCond.setDEFName("VALIDFLAG");
        dEDataSetCond.setCondValue("1");
        dEDataSetFetchContext.getConditionList().add(dEDataSetCond);
        dEDataSetCond = new DEDataSetCond();
        dEDataSetCond.setCondType("DEFIELD");
        dEDataSetCond.setCondOp("EQ");
        dEDataSetCond.setDEFName("VARCAT");
        dEDataSetCond.setCondValue("FMT_JAVA");
        dEDataSetFetchContext.getConditionList().add(dEDataSetCond);
        dEDataSetCond = pSVarSampleValueService.fetchDefault((IDEDataSetFetchContext)dEDataSetFetchContext);
        if (dEDataSetCond.isError()) {
            return dEDataSetCond;
        }
        IDataTable iDataTable = dEDataSetCond.getDataSet().getDataTable(0);
        int n = iDataTable.getCachedRowCount();
        if (n > 0) {
            simpleDataTableImpl.reset();
            for (int i = 0; i < n; ++i) {
                IDataRow iDataRow = iDataTable.getCachedRow(i);
                SimpleDataRowImpl simpleDataRowImpl = new SimpleDataRowImpl();
                simpleDataRowImpl.set("PSUAWIZARDID", iDataRow.get("PSVARSAMPLEVALUENAME"));
                simpleDataRowImpl.set("PSUAWIZARDNAME", iDataRow.get("VALUE"));
                simpleDataRowImpl.set("WIZARDPARAM4", iDataRow.get("PSVARSAMPLEVALUENAME"));
                simpleDataTableImpl.addCachedRow((IDataRow)simpleDataRowImpl);
            }
        }
        dBFetchResult.setTotalRow(n);
        return dBFetchResult;
    }
}

