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
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.service.PSVarSampleValueService;
import net.ibizsys.pscore.srv.config.service.PSVarSampleValueServiceBase;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset.PSDEUAWizardCurDEDQCondCondValueDSModelBase;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset.PSDEUAWizardDataSetUtil;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeItemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSDEUAWizardCurDEDQCondCondValueDSModel
extends PSDEUAWizardCurDEDQCondCondValueDSModelBase {
    private static final Log log = LogFactory.getLog(PSDEUAWizardCurDEDQCondCondValueDSModel.class);

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
        String string = jSONObject2.optString("PSDEFID".toLowerCase());
        String string2 = jSONObject2.optString("PSSYSDBVFID".toLowerCase());
        if (StringHelper.isNullOrEmpty((String)string) || !StringHelper.isNullOrEmpty((String)string2)) {
            return dBFetchResult;
        }
        String string3 = jSONObject2.optString("PSVARTYPEID".toLowerCase());
        if (StringHelper.isNullOrEmpty((String)string3)) {
            IDEDataSetCond iDEDataSetCond;
            PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)sessionFactory);
            PSDEField pSDEField = new PSDEField();
            pSDEField.setPSDEFieldId(string);
            if (!pSDEFieldService.get(pSDEField, true)) {
                log.error((Object)StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u5236\u5b9a\u5c5e\u6027[%1$s]", (Object)pSDEField.getPSDEFieldId()));
                return dBFetchResult;
            }
            String string4 = pSDEField.getPSCodeListId();
            if (StringHelper.isNullOrEmpty((String)string4)) {
                SimpleDataRowImpl simpleDataRowImpl = new SimpleDataRowImpl();
                simpleDataRowImpl.set("PSUAWIZARDID", (Object)pSDEField.getPSDEFieldName().toLowerCase());
                simpleDataRowImpl.set("PSUAWIZARDNAME", (Object)pSDEField.getPSDEFieldName().toLowerCase());
                simpleDataRowImpl.set("WIZARDPARAM4", (Object)pSDEField.getLogicName());
                simpleDataTableImpl.addCachedRow((IDataRow)simpleDataRowImpl);
                dBFetchResult.setTotalRow(1);
                return dBFetchResult;
            }
            PSCodeItemService pSCodeItemService = (PSCodeItemService)ServiceGlobal.getService(PSCodeItemService.class, (SessionFactory)sessionFactory);
            DEDataSetFetchContext dEDataSetFetchContext = new DEDataSetFetchContext();
            String string5 = WebContext.getFetchQuickSearch((IWebContext)WebContext.getCurrent());
            if (!StringHelper.isNullOrEmpty((String)string5) && (iDEDataSetCond = pSCodeItemService.getDEModel().getFetchQuickSearchCondition(string5)) != null) {
                dEDataSetFetchContext.getConditionList().add(iDEDataSetCond);
            }
            if (!StringHelper.isNullOrEmpty((String)string4)) {
                DEDataSetCond codeListCondition = new DEDataSetCond();
                codeListCondition.setCondType("DEFIELD");
                codeListCondition.setCondOp("EQ");
                codeListCondition.setDEFName("PSCODELISTID");
                codeListCondition.setCondValue(string4);
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
                    simpleDataRowImpl.set("PSUAWIZARDID", iDataRow.get("PSCODEITEMNAME"));
                    simpleDataRowImpl.set("PSUAWIZARDNAME", iDataRow.get("CODEITEMVALUE"));
                    simpleDataRowImpl.set("WIZARDPARAM4", iDataRow.get("PSCODEITEMNAME"));
                    simpleDataTableImpl.addCachedRow((IDataRow)simpleDataRowImpl);
                }
            }
            dBFetchResult.setTotalRow(n);
        } else {
            SimpleDataRowImpl simpleDataRowImpl;
            String string6 = WebContext.getFetchQuickSearch((IWebContext)WebContext.getCurrent());
            PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)sessionFactory);
            PSDEField pSDEField = new PSDEField();
            pSDEField.setPSDEFieldId(string);
            if (pSCoreSysServiceBase.get(pSDEField, true) && (StringHelper.isNullOrEmpty((String)string6) || pSDEField.getPSDEFieldName().toLowerCase().indexOf(string6.toLowerCase()) != -1)) {
                simpleDataRowImpl = new SimpleDataRowImpl();
                simpleDataRowImpl.set("PSUAWIZARDID", (Object)pSDEField.getLogicName());
                simpleDataRowImpl.set("PSUAWIZARDNAME", (Object)pSDEField.getPSDEFieldName().toLowerCase());
                simpleDataRowImpl.set("WIZARDPARAM4", (Object)pSDEField.getLogicName());
                simpleDataTableImpl.addCachedRow((IDataRow)simpleDataRowImpl);
                dBFetchResult.setTotalRow(1);
            }
            PSVarSampleValueService sampleValueService = (PSVarSampleValueService)ServiceGlobal.getService(PSVarSampleValueService.class);
            DEDataSetFetchContext sampleValueContext = new DEDataSetFetchContext();
            IDEDataSetCond quickSearchCondition;
            if (!StringHelper.isNullOrEmpty((String)string6) && (quickSearchCondition = sampleValueService.getDEModel().getFetchQuickSearchCondition(string6)) != null) {
                sampleValueContext.getConditionList().add(quickSearchCondition);
            }
            DEDataSetCond varTypeCondition = new DEDataSetCond();
            varTypeCondition.setCondType("DEFIELD");
            varTypeCondition.setCondOp("EQ");
            varTypeCondition.setDEFName("VARTYPE");
            varTypeCondition.setCondValue(string3);
            sampleValueContext.getConditionList().add(varTypeCondition);
            sampleValueContext.setSort("PSVARSAMPLEVALUENAME");
            DBFetchResult sampleValueResult = sampleValueService.fetchDefault((IDEDataSetFetchContext)sampleValueContext);
            if (sampleValueResult.isError()) {
                return sampleValueResult;
            }
            IDataTable iDataTable = sampleValueResult.getDataSet().getDataTable(0);
            int n = iDataTable.getCachedRowCount();
            if (n > 0) {
                for (int i = 0; i < n; ++i) {
                    IDataRow iDataRow = iDataTable.getCachedRow(i);
                    SimpleDataRowImpl simpleDataRowImpl2 = new SimpleDataRowImpl();
                    simpleDataRowImpl2.set("PSUAWIZARDID", iDataRow.get("PSVARSAMPLEVALUENAME"));
                    simpleDataRowImpl2.set("PSUAWIZARDNAME", iDataRow.get("VALUE"));
                    simpleDataRowImpl2.set("WIZARDPARAM4", iDataRow.get("PSVARSAMPLEVALUENAME"));
                    simpleDataTableImpl.addCachedRow((IDataRow)simpleDataRowImpl2);
                }
            }
            dBFetchResult.setTotalRow(n + dBFetchResult.getTotalRow());
        }
        return dBFetchResult;
    }
}
