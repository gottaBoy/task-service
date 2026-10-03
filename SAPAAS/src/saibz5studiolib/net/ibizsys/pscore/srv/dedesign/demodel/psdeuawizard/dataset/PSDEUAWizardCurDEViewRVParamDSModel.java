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
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectContext
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
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.db.impl.SimpleDataRowImpl;
import net.ibizsys.paas.db.impl.SimpleDataSetImpl;
import net.ibizsys.paas.db.impl.SimpleDataTableImpl;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset.PSDEUAWizardCurDEViewRVParamDSModelBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeItemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeListBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSDEUAWizardCurDEViewRVParamDSModel
extends PSDEUAWizardCurDEViewRVParamDSModelBase {
    private static final Log log = LogFactory.getLog(PSDEUAWizardCurDEViewRVParamDSModel.class);

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
        String string2 = jSONObject2.optString("REFMODE".toLowerCase());
        if (StringHelper.isNullOrEmpty((String)string) || StringHelper.isNullOrEmpty((String)string2)) {
            return dBFetchResult;
        }
        if (StringHelper.compare((String)string2, (String)"CUSTOM", (boolean)true) == 0) {
            return dBFetchResult;
        }
        PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)sessionFactory);
        PSDEViewBase pSDEViewBase = new PSDEViewBase();
        pSDEViewBase.setPSDEViewBaseId(string);
        try {
            if (KeyValueHelper.isTempKey((String)string)) {
                pSDEViewBaseService.getTemp(pSDEViewBase);
            } else {
                pSDEViewBaseService.get(pSDEViewBase);
            }
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u89c6\u56fe[%1$s]", (Object)string));
            return dBFetchResult;
        }
        PSDataEntity pSDataEntity = pSDEViewBase.getPSDE();
        if (pSDataEntity == null) {
            return dBFetchResult;
        }
        int n = 0;
        if (StringHelper.compare((String)string2, (String)"NEWDATA", (boolean)true) == 0 || StringHelper.compare((String)string2, (String)"EDITDATA", (boolean)true) == 0) {
            PSCodeList pSCodeList = null;
            PSDEField pSDEField = new PSDEField();
            pSDEField.setPSDEId(pSDataEntity.getPSDataEntityId());
            pSDEField.setSessionFactory(pSDataEntity.getSessionFactory());
            pSDEField.setMultiFormField(1);
            if (pSDEField.select(true)) {
                pSCodeList = pSDEField.getPSCodeList();
            } else {
                pSDEField.resetMultiFormField();
                pSDEField.setIndexType(1);
                if (pSDEField.select(true)) {
                    pSCodeList = pSDEField.getPSCodeList();
                }
            }
            if (pSCodeList != null) {
                ArrayList<PSCodeItem> arrayList = pSCodeList.getPSCodeItems();
                for (PSCodeItem pSCodeItem : arrayList) {
                    if (!DataObject.getBoolValue((Integer)pSCodeItem.getValidFlag(), (boolean)true)) continue;
                    SimpleDataRowImpl simpleDataRowImpl = new SimpleDataRowImpl();
                    simpleDataRowImpl.set("PSUAWIZARDID", (Object)pSCodeItem.getPSCodeItemName());
                    simpleDataRowImpl.set("PSUAWIZARDNAME", (Object)pSCodeItem.getCodeItemValue());
                    simpleDataRowImpl.set("WIZARDPARAM4", (Object)pSCodeItem.getPSCodeItemName());
                    simpleDataTableImpl.addCachedRow((IDataRow)simpleDataRowImpl);
                    ++n;
                }
            }
        } else if (StringHelper.compare((String)string2, (String)"MPICKUPVIEW", (boolean)true) == 0) {
            ArrayList<PSDER> arrayList = pSDataEntity.getMinorPSDERs();
            for (PSDER pSDER : arrayList) {
                if (!DataObject.getBoolValue((Integer)pSDER.getValidFlag(), (boolean)true) || StringHelper.compare((String)pSDER.getDERType(), (String)"DER1N", (boolean)true) != 0) continue;
                SimpleDataRowImpl simpleDataRowImpl = new SimpleDataRowImpl();
                simpleDataRowImpl.set("PSUAWIZARDID", (Object)pSDER.getLogicName());
                simpleDataRowImpl.set("PSUAWIZARDNAME", (Object)pSDER.getCodeName());
                simpleDataRowImpl.set("WIZARDPARAM4", (Object)pSDER.getLogicName());
                simpleDataTableImpl.addCachedRow((IDataRow)simpleDataRowImpl);
                ++n;
            }
        } else if (StringHelper.compare((String)string2, (String)"RDITEM", (boolean)true) == 0) {
            SimpleDataRowImpl editViewRow = new SimpleDataRowImpl();
            editViewRow.set("PSUAWIZARDID", (Object)"\u7f16\u8f91\u89c6\u56fe");
            editViewRow.set("PSUAWIZARDNAME", (Object)"EDITVIEW");
            editViewRow.set("WIZARDPARAM4", (Object)"\u7f16\u8f91\u89c6\u56fe");
            simpleDataTableImpl.addCachedRow((IDataRow)editViewRow);
            ++n;
            PSCodeList codeList = null;
            PSDEField pSDEField = new PSDEField();
            pSDEField.setPSDEId(pSDataEntity.getPSDataEntityId());
            pSDEField.setSessionFactory(pSDataEntity.getSessionFactory());
            pSDEField.setMultiFormField(1);
            if (pSDEField.select(true)) {
                codeList = pSDEField.getPSCodeList();
            } else {
                pSDEField.resetMultiFormField();
                pSDEField.setIndexType(1);
                if (pSDEField.select(true)) {
                    codeList = pSDEField.getPSCodeList();
                }
            }
            if (codeList != null) {
                for (PSCodeItem codeItem : codeList.getPSCodeItems()) {
                    if (!DataObject.getBoolValue((Integer)codeItem.getValidFlag(), (boolean)true)) continue;
                    SimpleDataRowImpl itemRow = new SimpleDataRowImpl();
                    itemRow.set("PSUAWIZARDID", (Object)StringHelper.format((String)"\u7f16\u8f91\u89c6\u56fe(%1$s)", (Object)codeItem.getPSCodeItemName()));
                    itemRow.set("PSUAWIZARDNAME", (Object)StringHelper.format((String)"%1$s:%2$s", (Object)"EDITVIEW", (Object)codeItem.getCodeItemValue()));
                    itemRow.set("WIZARDPARAM4", (Object)StringHelper.format((String)"\u7f16\u8f91\u89c6\u56fe(%1$s)", (Object)codeItem.getPSCodeItemName()));
                    simpleDataTableImpl.addCachedRow((IDataRow)itemRow);
                    ++n;
                }
            }
            SelectContext wfViewContext = new SelectContext();
            wfViewContext.set("PSDEID", (Object)pSDataEntity.getPSDataEntityId());
            wfViewContext.set("PREDEFINEVIEWTYPE", (Object)"WFEDITVIEW");
            for (PSDEViewBase view : pSDEViewBaseService.select((ISelectCond)wfViewContext)) {
                SimpleDataRowImpl viewRow = new SimpleDataRowImpl();
                viewRow.set("PSUAWIZARDID", (Object)view.getPSDEViewBaseName());
                viewRow.set("PSUAWIZARDNAME", (Object)StringHelper.format((String)"%1$s:%2$s", (Object)"WFEDITVIEW", (Object)view.getPDVTParam()));
                viewRow.set("WIZARDPARAM4", (Object)view.getPSDEViewBaseName());
                simpleDataTableImpl.addCachedRow((IDataRow)viewRow);
                ++n;
            }
            if (DataObject.getBoolValue((Integer)pSDataEntity.getEnableMob(), (boolean)false)) {
                SimpleDataRowImpl mobileEditViewRow = new SimpleDataRowImpl();
                mobileEditViewRow.set("PSUAWIZARDID", (Object)"\u79fb\u52a8\u7aef\u7f16\u8f91\u89c6\u56fe");
                mobileEditViewRow.set("PSUAWIZARDNAME", (Object)"MOBEDITVIEW");
                mobileEditViewRow.set("WIZARDPARAM4", (Object)"\u79fb\u52a8\u7aef\u7f16\u8f91\u89c6\u56fe");
                simpleDataTableImpl.addCachedRow((IDataRow)mobileEditViewRow);
                ++n;
                if (codeList != null) {
                    for (PSCodeItem codeItem : codeList.getPSCodeItems()) {
                        if (!DataObject.getBoolValue((Integer)codeItem.getValidFlag(), (boolean)true)) continue;
                        SimpleDataRowImpl itemRow = new SimpleDataRowImpl();
                        itemRow.set("PSUAWIZARDID", (Object)StringHelper.format((String)"\u79fb\u52a8\u7aef\u7f16\u8f91\u89c6\u56fe(%1$s)", (Object)codeItem.getPSCodeItemName()));
                        itemRow.set("PSUAWIZARDNAME", (Object)StringHelper.format((String)"%1$s:%2$s", (Object)"MOBEDITVIEW", (Object)codeItem.getCodeItemValue()));
                        itemRow.set("WIZARDPARAM4", (Object)StringHelper.format((String)"\u79fb\u52a8\u7aef\u7f16\u8f91\u89c6\u56fe(%1$s)", (Object)codeItem.getPSCodeItemName()));
                        simpleDataTableImpl.addCachedRow((IDataRow)itemRow);
                        ++n;
                    }
                }
                SelectContext mobileWfViewContext = new SelectContext();
                mobileWfViewContext.set("PSDEID", (Object)pSDataEntity.getPSDataEntityId());
                mobileWfViewContext.set("PREDEFINEVIEWTYPE", (Object)"MOBWFEDITVIEW");
                for (PSDEViewBase view : pSDEViewBaseService.select((ISelectCond)mobileWfViewContext)) {
                    SimpleDataRowImpl viewRow = new SimpleDataRowImpl();
                    viewRow.set("PSUAWIZARDID", (Object)view.getPSDEViewBaseName());
                    viewRow.set("PSUAWIZARDNAME", (Object)StringHelper.format((String)"%1$s:%2$s", (Object)"MOBWFEDITVIEW", (Object)view.getPDVTParam()));
                    viewRow.set("WIZARDPARAM4", (Object)view.getPSDEViewBaseName());
                    simpleDataTableImpl.addCachedRow((IDataRow)viewRow);
                    ++n;
                }
            }
        }
        dBFetchResult.setTotalRow(n);
        return dBFetchResult;
    }
}
