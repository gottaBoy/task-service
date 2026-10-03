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
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.service.PSVarSampleValueService;
import net.ibizsys.pscore.srv.config.service.PSVarSampleValueServiceBase;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset.PSDEUAWizardCurSrcDELNParamKeyDSModelBase;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset.PSDEUAWizardDataSetUtil;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicParam;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicParamService;
import net.sf.json.JSONObject;
import org.hibernate.SessionFactory;

public class PSDEUAWizardCurSrcDELNParamKeyDSModel
extends PSDEUAWizardCurSrcDELNParamKeyDSModelBase {
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
        String string = jSONObject2.optString("SRCVALUETYPE".toLowerCase());
        if (StringHelper.compare((String)string, (String)"SRCDLPARAM", (boolean)true) == 0) {
            SimpleDataRowImpl simpleDataRowImpl;
            IDataRow iDataRow;
            int n;
            IDEDataSetCond iDEDataSetCond;
            String string2 = jSONObject2.optString("SRCPSDLPARAMID".toLowerCase());
            if (StringHelper.isNullOrEmpty((String)string2)) {
                return dBFetchResult;
            }
            PSDELogicParam pSDELogicParam = new PSDELogicParam();
            pSDELogicParam.setPSDELogicParamId(string2);
            PSDELogicParamService pSDELogicParamService = (PSDELogicParamService)ServiceGlobal.getService(PSDELogicParamService.class, (SessionFactory)sessionFactory);
            if (KeyValueHelper.isTempKey((String)string2)) {
                pSDELogicParamService.getTemp(pSDELogicParam);
            } else {
                pSDELogicParamService.get(pSDELogicParam);
            }
            String string3 = pSDELogicParam.getParamPSDEId();
            if (StringHelper.isNullOrEmpty((String)string3)) {
                return dBFetchResult;
            }
            String string4 = WebContext.getFetchQuickSearch((IWebContext)WebContext.getCurrent());
            PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)sessionFactory);
            DEDataSetFetchContext dEDataSetFetchContext = new DEDataSetFetchContext();
            if (!StringHelper.isNullOrEmpty((String)string4) && (iDEDataSetCond = ((PSDEFieldServiceBase)pSCoreSysServiceBase).getDEModel().getFetchQuickSearchCondition(string4)) != null) {
                dEDataSetFetchContext.getConditionList().add(iDEDataSetCond);
            }
            if (!StringHelper.isNullOrEmpty((String)string3)) {
                DEDataSetCond dataEntityCondition = new DEDataSetCond();
                dataEntityCondition.setCondType("DEFIELD");
                dataEntityCondition.setCondOp("EQ");
                dataEntityCondition.setDEFName("PSDEID");
                dataEntityCondition.setCondValue(string3);
                dEDataSetFetchContext.getConditionList().add(dataEntityCondition);
            }
            dEDataSetFetchContext.setSort("PSDEFIELDNAME");
            DBFetchResult fieldResult = ((PSDEFieldServiceBase)pSCoreSysServiceBase).fetchDefault((IDEDataSetFetchContext)dEDataSetFetchContext);
            if (fieldResult.isError()) {
                return fieldResult;
            }
            IDataTable iDataTable = fieldResult.getDataSet().getDataTable(0);
            int n2 = iDataTable.getCachedRowCount();
            if (n2 > 0) {
                simpleDataTableImpl.reset();
                for (n = 0; n < n2; ++n) {
                    iDataRow = iDataTable.getCachedRow(n);
                    simpleDataRowImpl = new SimpleDataRowImpl();
                    simpleDataRowImpl.set("PSUAWIZARDID", iDataRow.get("PSDEFIELDNAME"));
                    simpleDataRowImpl.set("PSUAWIZARDNAME", iDataRow.get("PSDEFIELDNAME"));
                    simpleDataRowImpl.set("WIZARDPARAM4", iDataRow.get("LOGICNAME"));
                    simpleDataTableImpl.addCachedRow((IDataRow)simpleDataRowImpl);
                }
            }
            dBFetchResult.setTotalRow(n2);
            pSCoreSysServiceBase = (PSVarSampleValueService)ServiceGlobal.getService(PSVarSampleValueService.class);
            dEDataSetFetchContext = new DEDataSetFetchContext();
            if (!StringHelper.isNullOrEmpty((String)string4) && (iDEDataSetCond = ((PSVarSampleValueServiceBase)pSCoreSysServiceBase).getDEModel().getFetchQuickSearchCondition(string4)) != null) {
                dEDataSetFetchContext.getConditionList().add(iDEDataSetCond);
            }
            DEDataSetCond varTypeCondition = new DEDataSetCond();
            varTypeCondition.setCondType("DEFIELD");
            varTypeCondition.setCondOp("EQ");
            varTypeCondition.setDEFName("VARTYPE");
            varTypeCondition.setCondValue("DATACONTEXT");
            dEDataSetFetchContext.getConditionList().add(varTypeCondition);
            dEDataSetFetchContext.setSort("PSVARSAMPLEVALUENAME");
            DBFetchResult sampleResult = ((PSVarSampleValueServiceBase)pSCoreSysServiceBase).fetchDefault((IDEDataSetFetchContext)dEDataSetFetchContext);
            if (sampleResult.isError()) {
                return sampleResult;
            }
            iDataTable = sampleResult.getDataSet().getDataTable(0);
            n2 = iDataTable.getCachedRowCount();
            if (n2 > 0) {
                for (n = 0; n < n2; ++n) {
                    iDataRow = iDataTable.getCachedRow(n);
                    simpleDataRowImpl = new SimpleDataRowImpl();
                    simpleDataRowImpl.set("PSUAWIZARDID", iDataRow.get("PSVARSAMPLEVALUENAME"));
                    simpleDataRowImpl.set("PSUAWIZARDNAME", iDataRow.get("VALUE"));
                    simpleDataRowImpl.set("WIZARDPARAM4", iDataRow.get("PSVARSAMPLEVALUENAME"));
                    simpleDataTableImpl.addCachedRow((IDataRow)simpleDataRowImpl);
                }
            }
            dBFetchResult.setTotalRow(n2 + dBFetchResult.getTotalRow());
        }
        return dBFetchResult;
    }
}
