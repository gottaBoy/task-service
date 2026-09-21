/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.controller.ViewController
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.data.DataObject
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
 *  net.ibizsys.paas.web.WebContext
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset;

import java.util.ArrayList;
import net.ibizsys.paas.controller.ViewController;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.data.DataObject;
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
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSVTRV;
import net.ibizsys.pscore.srv.config.entity.PSViewType;
import net.ibizsys.pscore.srv.config.service.PSVTRVService;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset.PSDEUAWizardCurDEViewRVModeDSModelBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSDEUAWizardCurDEViewRVModeDSModel
extends PSDEUAWizardCurDEViewRVModeDSModelBase {
    private static final Log log = LogFactory.getLog(PSDEUAWizardCurDEViewRVModeDSModel.class);

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
        dBFetchResult.setTotalRow(0);
        simpleDataSetImpl.addDataTable((IDataTable)simpleDataTableImpl);
        dBFetchResult.setDataSet((IDataSet)simpleDataSetImpl);
        String string = jSONObject2.optString("MAJORPSDEVIEWID".toLowerCase());
        if (StringHelper.isNullOrEmpty((String)string)) {
            return dBFetchResult;
        }
        PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)sessionFactory);
        PSDEViewBase pSDEViewBase = new PSDEViewBase();
        pSDEViewBase.setPSDEViewBaseId(string);
        try {
            if (KeyValueHelper.isTempKey((String)string)) {
                pSDEViewBaseService.getTemp((IEntity)pSDEViewBase);
            } else {
                pSDEViewBaseService.get((IEntity)pSDEViewBase);
            }
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u89c6\u56fe[%1$s]", (Object)string));
            return dBFetchResult;
        }
        if (StringHelper.isNullOrEmpty((String)pSDEViewBase.getPSDEViewBaseType())) {
            return dBFetchResult;
        }
        PSVTRVService pSVTRVService = (PSVTRVService)ServiceGlobal.getService(PSVTRVService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSViewType pSViewType = new PSViewType();
        pSViewType.setPSViewTypeId(pSDEViewBase.getPSDEViewBaseType());
        ArrayList<PSVTRV> arrayList = pSVTRVService.selectByPSViewType(pSViewType);
        int n = 0;
        if (arrayList.size() > 0) {
            simpleDataTableImpl.reset();
            for (int i = 0; i < arrayList.size(); ++i) {
                PSVTRV pSVTRV = arrayList.get(i);
                if (!DataObject.getBoolValue((Integer)pSVTRV.getValidFlag(), (boolean)true)) continue;
                SimpleDataRowImpl simpleDataRowImpl = new SimpleDataRowImpl();
                simpleDataRowImpl.set("PSUAWIZARDID", (Object)pSVTRV.getLogicName());
                simpleDataRowImpl.set("PSUAWIZARDNAME", (Object)pSVTRV.getPSVTRVName());
                simpleDataRowImpl.set("WIZARDPARAM4", (Object)pSVTRV.getLogicName());
                simpleDataTableImpl.addCachedRow((IDataRow)simpleDataRowImpl);
                ++n;
            }
        }
        dBFetchResult.setTotalRow(n);
        return dBFetchResult;
    }
}

