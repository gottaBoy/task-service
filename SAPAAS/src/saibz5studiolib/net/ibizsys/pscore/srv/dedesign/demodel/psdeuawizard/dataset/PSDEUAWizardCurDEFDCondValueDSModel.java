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
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
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
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataSet;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.db.impl.SimpleDataRowImpl;
import net.ibizsys.paas.db.impl.SimpleDataSetImpl;
import net.ibizsys.paas.db.impl.SimpleDataTableImpl;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset.PSDEUAWizardCurDEFDCondValueDSModelBase;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset.PSDEUAWizardDataSetUtil;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormDetail;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeItemService;
import net.sf.json.JSONObject;
import org.hibernate.SessionFactory;

public class PSDEUAWizardCurDEFDCondValueDSModel
extends PSDEUAWizardCurDEFDCondValueDSModelBase {
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
        String string = jSONObject2.optString("FDNAME".toLowerCase());
        String string2 = jSONObject2.optString("PSDEFORMDETAILID".toLowerCase());
        if (StringHelper.isNullOrEmpty((String)string2) || StringHelper.isNullOrEmpty((String)string)) {
            return dBFetchResult;
        }
        PSDEFormDetail pSDEFormDetail = new PSDEFormDetail();
        pSDEFormDetail.setPSDEFormDetailId(string2);
        PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)sessionFactory);
        if (KeyValueHelper.isTempKey((String)string2)) {
            pSDEFormDetailService.getTemp(pSDEFormDetail);
        } else {
            pSDEFormDetailService.get(pSDEFormDetail);
        }
        PSDEFormDetail pSDEFormDetail2 = new PSDEFormDetail();
        pSDEFormDetail2.setPSDEFormId(pSDEFormDetail.getPSDEFormId());
        pSDEFormDetail2.setPSDEFormDetailName(string);
        if (KeyValueHelper.isTempKey((String)pSDEFormDetail2.getPSDEFormId()) ? !pSDEFormDetailService.selectTemp(pSDEFormDetail2, true) : !pSDEFormDetailService.select(pSDEFormDetail2, true)) {
            return dBFetchResult;
        }
        String string3 = pSDEFormDetail2.getPSCodeListId();
        if (StringHelper.isNullOrEmpty((String)string3)) {
            if (pSDEFormDetail2.getPSDEF() == null) {
                return dBFetchResult;
            }
            string3 = pSDEFormDetail2.getPSDEF().getPSCodeListId();
            if (StringHelper.isNullOrEmpty((String)string3)) {
                return dBFetchResult;
            }
        }
        PSCodeItemService pSCodeItemService = (PSCodeItemService)ServiceGlobal.getService(PSCodeItemService.class, (SessionFactory)sessionFactory);
        DEDataSetFetchContext dEDataSetFetchContext = new DEDataSetFetchContext();
        String string4 = WebContext.getFetchQuickSearch((IWebContext)WebContext.getCurrent());
        if (!StringHelper.isNullOrEmpty((String)string4) && (iDEDataSetCond = pSCodeItemService.getDEModel().getFetchQuickSearchCondition(string4)) != null) {
            dEDataSetFetchContext.getConditionList().add(iDEDataSetCond);
        }
        if (!StringHelper.isNullOrEmpty((String)string3)) {
            DEDataSetCond codeListCondition = new DEDataSetCond();
            codeListCondition.setCondType("DEFIELD");
            codeListCondition.setCondOp("EQ");
            codeListCondition.setDEFName("PSCODELISTID");
            codeListCondition.setCondValue(string3);
            dEDataSetFetchContext.getConditionList().add(codeListCondition);
        }
        dEDataSetFetchContext.setSort("ORDERVALUE");
        DBFetchResult codeItemResult = pSCodeItemService.fetchDefault((IDEDataSetFetchContext)dEDataSetFetchContext);
        if (codeItemResult.isError()) {
            return codeItemResult;
        }
        IDataTable iDataTable = codeItemResult.getDataSet().getDataTable(0);
        int n = iDataTable.getCachedRowCount();
        if (n > 0) {
            simpleDataTableImpl.reset();
            for (int i = 0; i < n; ++i) {
                IDataRow iDataRow = iDataTable.getCachedRow(i);
                SimpleDataRowImpl simpleDataRowImpl = new SimpleDataRowImpl();
                simpleDataRowImpl.set("PSUAWIZARDID", iDataRow.get("CODEITEMVALUE"));
                simpleDataRowImpl.set("PSUAWIZARDNAME", iDataRow.get("CODEITEMVALUE"));
                simpleDataRowImpl.set("WIZARDPARAM4", iDataRow.get("PSCODEITEMNAME"));
                simpleDataTableImpl.addCachedRow((IDataRow)simpleDataRowImpl);
            }
        }
        dBFetchResult.setTotalRow(n);
        return dBFetchResult;
    }
}
