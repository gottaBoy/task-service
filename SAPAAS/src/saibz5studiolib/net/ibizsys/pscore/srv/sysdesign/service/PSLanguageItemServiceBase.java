/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.SimpleEntity
 *  net.ibizsys.paas.service.CloneSession
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.service.CloneSession;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSLanguage;
import net.ibizsys.pscore.srv.config.entity.PSLanguageBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.dao.PSLanguageItemDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSLanguageItemDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSLanguageItemServiceBase
extends PSCoreSysServiceBase<PSLanguageItem> {
    private static final Log log = LogFactory.getLog(PSLanguageItemServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSLanguageItemDEModel pSLanguageItemDEModel;
    private PSLanguageItemDAO pSLanguageItemDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSLanguageItemService";
    }

    public PSLanguageItemDEModel getPSLanguageItemDEModel() {
        if (this.pSLanguageItemDEModel == null) {
            try {
                this.pSLanguageItemDEModel = (PSLanguageItemDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSLanguageItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSLanguageItemDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSLanguageItemDEModel();
    }

    public PSLanguageItemDAO getPSLanguageItemDAO() {
        if (this.pSLanguageItemDAO == null) {
            try {
                this.pSLanguageItemDAO = (PSLanguageItemDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSLanguageItemDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSLanguageItemDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSLanguageItemDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSLanguageItem pSLanguageItem, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSLANGUAGEITEM_PSLANGUAGERES_PSLANGUAGERESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSLanguageRes);
            } else {
                iService.get((IEntity)pSLanguageRes);
            }
            this.onFillParentInfo_PSLanguageRes(pSLanguageItem, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSLANGUAGEITEM_PSLANGUAGE_PSLANGUAGEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSLanguageService", (SessionFactory)this.getSessionFactory());
            PSLanguage pSLanguage = (PSLanguage)iService.getDEModel().createEntity();
            pSLanguage.set("PSLANGUAGEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSLanguage);
            } else {
                iService.get((IEntity)pSLanguage);
            }
            this.onFillParentInfo_PSLanguage(pSLanguageItem, pSLanguage);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSLANGUAGEITEM_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSModule);
            } else {
                iService.get((IEntity)pSModule);
            }
            this.onFillParentInfo_PSModule(pSLanguageItem, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSLANGUAGEITEM_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystem);
            } else {
                iService.get((IEntity)pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSLanguageItem, pSSystem);
            return;
        }
        super.onFillParentInfo((IEntity)pSLanguageItem, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSLanguageRes(PSLanguageItem pSLanguageItem, PSLanguageRes pSLanguageRes) throws Exception {
        pSLanguageItem.setDefContent(pSLanguageRes.getContent());
        pSLanguageItem.setLanResTag(pSLanguageRes.getLanResTag());
        pSLanguageItem.setPSLanguageResId(pSLanguageRes.getPSLanguageResId());
        pSLanguageItem.setPSLanguageResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSLanguage(PSLanguageItem pSLanguageItem, PSLanguage pSLanguage) throws Exception {
        pSLanguageItem.setPSLanguageId(pSLanguage.getPSLanguageId());
        pSLanguageItem.setPSLanguageName(pSLanguage.getPSLanguageName());
    }

    protected void onFillParentInfo_PSModule(PSLanguageItem pSLanguageItem, PSModule pSModule) throws Exception {
        pSLanguageItem.setPSModuleId(pSModule.getPSModuleId());
        pSLanguageItem.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSSystem(PSLanguageItem pSLanguageItem, PSSystem pSSystem) throws Exception {
        pSLanguageItem.setPSSystemId(pSSystem.getPSSystemId());
        pSLanguageItem.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected boolean onFillEntityKeyValue(PSLanguageItem pSLanguageItem, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSLanguageItem.get("PSSYSTEMID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSLanguageItem.get("PSLANGUAGEID");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        stringBuilderEx.append("||");
        Object object3 = pSLanguageItem.get("PSLANGUAGERESID");
        if (object3 == null) {
            object3 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object3);
        String string = stringBuilderEx.toString();
        pSLanguageItem.set(this.getPSLanguageItemDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSLanguageItem pSLanguageItem, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSLanguageItem, bl);
        this.onFillEntityFullInfo_PSLanguageRes(pSLanguageItem, bl);
        this.onFillEntityFullInfo_PSLanguage(pSLanguageItem, bl);
        this.onFillEntityFullInfo_PSModule(pSLanguageItem, bl);
        this.onFillEntityFullInfo_PSSystem(pSLanguageItem, bl);
    }

    protected void onFillEntityFullInfo_PSLanguageRes(PSLanguageItem pSLanguageItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSLanguage(PSLanguageItem pSLanguageItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSModule(PSLanguageItem pSLanguageItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSLanguageItem pSLanguageItem, boolean bl) throws Exception {
        if (pSLanguageItem.isPSSystemIdDirty()) {
            if (pSLanguageItem.getPSSystemId() != null) {
                if (pSLanguageItem.getPSSystemId() == null || pSLanguageItem.getPSSystemName() == null) {
                    PSSystem pSSystem = pSLanguageItem.getPSSystem();
                    pSLanguageItem.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSLanguageItem.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSLanguageItem pSLanguageItem, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSLanguageItem, bl);
    }

    public ArrayList<PSLanguageItem> selectByPSLanguageRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByPSLanguageRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSLanguageItem> selectByPSLanguageRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByPSLanguageRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSLanguageItem> selectByPSLanguageRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSLANGUAGERESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSLanguageResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSLanguageResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSLanguageItem> selectByPSLanguage(PSLanguageBase pSLanguageBase) throws Exception {
        return this.selectByPSLanguage(pSLanguageBase, "", -1);
    }

    public ArrayList<PSLanguageItem> selectByPSLanguage(PSLanguageBase pSLanguageBase, String string) throws Exception {
        return this.selectByPSLanguage(pSLanguageBase, string, -1);
    }

    public ArrayList<PSLanguageItem> selectByPSLanguage(PSLanguageBase pSLanguageBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSLANGUAGEID", (Object)pSLanguageBase.getPSLanguageId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSLanguageCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSLanguageCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSLanguageItem> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSLanguageItem> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSLanguageItem> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSMODULEID", (Object)pSModuleBase.getPSModuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSModuleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSModuleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSLanguageItem> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSLanguageItem> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSLanguageItem> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTEMID", (Object)pSSystemBase.getPSSystemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSystemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSystemCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSLanguageRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    public void resetPSLanguageRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSLanguageItem> arrayList = this.selectByPSLanguageRes(pSLanguageRes);
        for (PSLanguageItem pSLanguageItem : arrayList) {
            PSLanguageItem pSLanguageItem2 = (PSLanguageItem)this.getDEModel().createEntity();
            pSLanguageItem2.setPSLanguageItemId(pSLanguageItem.getPSLanguageItemId());
            pSLanguageItem2.setPSLanguageResId(null);
            this.update(pSLanguageItem2);
        }
    }

    public void removeByPSLanguageRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSLanguageItemServiceBase.this.onBeforeRemoveByPSLanguageRes(pSLanguageRes2);
                PSLanguageItemServiceBase.this.internalRemoveByPSLanguageRes(pSLanguageRes2);
                PSLanguageItemServiceBase.this.onAfterRemoveByPSLanguageRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByPSLanguageRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByPSLanguageRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSLanguageItem> arrayList = this.selectByPSLanguageRes(pSLanguageRes);
        this.onBeforeRemoveByPSLanguageRes(pSLanguageRes, arrayList);
        for (PSLanguageItem pSLanguageItem : arrayList) {
            this.remove((IEntity)pSLanguageItem);
        }
        this.onAfterRemoveByPSLanguageRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByPSLanguageRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByPSLanguageRes(PSLanguageRes pSLanguageRes, ArrayList<PSLanguageItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSLanguageRes(PSLanguageRes pSLanguageRes, ArrayList<PSLanguageItem> arrayList) throws Exception {
    }

    public void testRemoveByPSLanguage(PSLanguage pSLanguage) throws Exception {
        ArrayList<PSLanguageItem> arrayList = this.selectByPSLanguage(pSLanguage, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSLanguage);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSLANGUAGEITEM_PSLANGUAGE_PSLANGUAGEID", "", iDataEntityModel.getName(), "PSLANGUAGEITEM", iDataEntityModel.getDataInfo((IEntity)pSLanguage), arrayList.get(0)));
        }
    }

    public void resetPSLanguage(PSLanguage pSLanguage) throws Exception {
        ArrayList<PSLanguageItem> arrayList = this.selectByPSLanguage(pSLanguage);
        for (PSLanguageItem pSLanguageItem : arrayList) {
            PSLanguageItem pSLanguageItem2 = (PSLanguageItem)this.getDEModel().createEntity();
            pSLanguageItem2.setPSLanguageItemId(pSLanguageItem.getPSLanguageItemId());
            pSLanguageItem2.setPSLanguageId(null);
            this.update(pSLanguageItem2);
        }
    }

    public void removeByPSLanguage(PSLanguage pSLanguage) throws Exception {
        final PSLanguage pSLanguage2 = pSLanguage;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSLanguageItemServiceBase.this.onBeforeRemoveByPSLanguage(pSLanguage2);
                PSLanguageItemServiceBase.this.internalRemoveByPSLanguage(pSLanguage2);
                PSLanguageItemServiceBase.this.onAfterRemoveByPSLanguage(pSLanguage2);
            }
        });
    }

    protected void onBeforeRemoveByPSLanguage(PSLanguage pSLanguage) throws Exception {
    }

    protected void internalRemoveByPSLanguage(PSLanguage pSLanguage) throws Exception {
        ArrayList<PSLanguageItem> arrayList = this.selectByPSLanguage(pSLanguage);
        this.onBeforeRemoveByPSLanguage(pSLanguage, arrayList);
        for (PSLanguageItem pSLanguageItem : arrayList) {
            this.remove((IEntity)pSLanguageItem);
        }
        this.onAfterRemoveByPSLanguage(pSLanguage, arrayList);
    }

    protected void onAfterRemoveByPSLanguage(PSLanguage pSLanguage) throws Exception {
    }

    protected void onBeforeRemoveByPSLanguage(PSLanguage pSLanguage, ArrayList<PSLanguageItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSLanguage(PSLanguage pSLanguage, ArrayList<PSLanguageItem> arrayList) throws Exception {
    }

    public void testRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSLanguageItem> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSLANGUAGEITEM_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSLANGUAGEITEM", iDataEntityModel.getDataInfo((IEntity)pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSLanguageItem> arrayList = this.selectByPSModule(pSModule);
        for (PSLanguageItem pSLanguageItem : arrayList) {
            PSLanguageItem pSLanguageItem2 = (PSLanguageItem)this.getDEModel().createEntity();
            pSLanguageItem2.setPSLanguageItemId(pSLanguageItem.getPSLanguageItemId());
            pSLanguageItem2.setPSModuleId(null);
            this.update(pSLanguageItem2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSLanguageItemServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSLanguageItemServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSLanguageItemServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSLanguageItem> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSLanguageItem pSLanguageItem : arrayList) {
            this.remove((IEntity)pSLanguageItem);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSLanguageItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSLanguageItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSLanguageItem> arrayList = this.selectByPSSystem(pSSystem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSystem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSLANGUAGEITEM_PSSYSTEM_PSSYSTEMID", "", iDataEntityModel.getName(), "PSLANGUAGEITEM", iDataEntityModel.getDataInfo((IEntity)pSSystem), arrayList.get(0)));
        }
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSLanguageItem> arrayList = this.selectByPSSystem(pSSystem);
        for (PSLanguageItem pSLanguageItem : arrayList) {
            PSLanguageItem pSLanguageItem2 = (PSLanguageItem)this.getDEModel().createEntity();
            pSLanguageItem2.setPSLanguageItemId(pSLanguageItem.getPSLanguageItemId());
            pSLanguageItem2.setPSSystemId(null);
            this.update(pSLanguageItem2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSLanguageItemServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSLanguageItemServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSLanguageItemServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSLanguageItem> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSLanguageItem pSLanguageItem : arrayList) {
            this.remove((IEntity)pSLanguageItem);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSLanguageItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSLanguageItem> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSLanguageItem pSLanguageItem) throws Exception {
        super.onBeforeRemove(pSLanguageItem);
    }

    protected void replaceParentInfo(PSLanguageItem pSLanguageItem, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSLanguageItem, cloneSession);
        if (pSLanguageItem.getPSLanguageResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSLanguageItem.getPSLanguageResId())) != null) {
            this.onFillParentInfo_PSLanguageRes(pSLanguageItem, (PSLanguageRes)iEntity);
        }
        if (pSLanguageItem.getPSLanguageId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGE", (Object)pSLanguageItem.getPSLanguageId())) != null) {
            this.onFillParentInfo_PSLanguage(pSLanguageItem, (PSLanguage)iEntity);
        }
        if (pSLanguageItem.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSLanguageItem.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSLanguageItem, (PSModule)iEntity);
        }
        if (pSLanguageItem.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSLanguageItem.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSLanguageItem, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSLanguageItem pSLanguageItem, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSLanguageItem, bl);
    }

    protected void onCheckEntity(boolean bl, PSLanguageItem pSLanguageItem, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Content(bl, pSLanguageItem, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Content2(bl, pSLanguageItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSLanguageItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSLanguageItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSLanguageId(bl, pSLanguageItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSLanguageItemId(bl, pSLanguageItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSLanguageItemName(bl, pSLanguageItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSLanguageResId(bl, pSLanguageItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSLanguageItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSLanguageItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSLanguageItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSLanguageItem, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Content(boolean bl, PSLanguageItem pSLanguageItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSLanguageItem.isContentDirty() : !pSLanguageItem.isContentDirty()) {
            return null;
        }
        String string = pSLanguageItem.getContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Content_Default((IEntity)pSLanguageItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Content2(boolean bl, PSLanguageItem pSLanguageItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSLanguageItem.isContent2Dirty() : !pSLanguageItem.isContent2Dirty()) {
            return null;
        }
        String string = pSLanguageItem.getContent2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Content2_Default((IEntity)pSLanguageItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENT2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSLanguageItem pSLanguageItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSLanguageItem.isLockFlagDirty() : !pSLanguageItem.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSLanguageItem.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default((IEntity)pSLanguageItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOCKFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSLanguageItem pSLanguageItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSLanguageItem.isMemoDirty() : !pSLanguageItem.isMemoDirty()) {
            return null;
        }
        String string = pSLanguageItem.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSLanguageItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MEMO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSLanguageId(boolean bl, PSLanguageItem pSLanguageItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSLanguageItem.isPSLanguageIdDirty() && !bl2 : !pSLanguageItem.isPSLanguageIdDirty()) {
            return null;
        }
        String string = pSLanguageItem.getPSLanguageId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSLANGUAGEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSLanguageId_Default((IEntity)pSLanguageItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSLANGUAGEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSLanguageItemId(boolean bl, PSLanguageItem pSLanguageItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSLanguageItem.isPSLanguageItemIdDirty() && !bl2 : !pSLanguageItem.isPSLanguageItemIdDirty()) {
            return null;
        }
        String string = pSLanguageItem.getPSLanguageItemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSLANGUAGEITEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSLanguageItemId_Default((IEntity)pSLanguageItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSLANGUAGEITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSLanguageItemName(boolean bl, PSLanguageItem pSLanguageItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSLanguageItem.isPSLanguageItemNameDirty() && !bl2 : !pSLanguageItem.isPSLanguageItemNameDirty()) {
            return null;
        }
        String string = pSLanguageItem.getPSLanguageItemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSLANGUAGEITEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSLanguageItemName_Default((IEntity)pSLanguageItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSLANGUAGEITEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSSYSTEMID";
                String string4 = this.checkFieldDupRule(this.getPSLanguageItemDEModel(), "PSLANGUAGEITEMNAME", string3, pSLanguageItem, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSLANGUAGEITEMNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSLanguageResId(boolean bl, PSLanguageItem pSLanguageItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSLanguageItem.isPSLanguageResIdDirty() && !bl2 : !pSLanguageItem.isPSLanguageResIdDirty()) {
            return null;
        }
        String string = pSLanguageItem.getPSLanguageResId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSLANGUAGERESID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSLanguageResId_Default((IEntity)pSLanguageItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSLANGUAGERESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSLanguageItem pSLanguageItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSLanguageItem.isPSModuleIdDirty() : !pSLanguageItem.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSLanguageItem.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default((IEntity)pSLanguageItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSLanguageItem pSLanguageItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSLanguageItem.isPSSystemIdDirty() && !bl2 : !pSLanguageItem.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSLanguageItem.getPSSystemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSLanguageItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSLanguageItem pSLanguageItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSLanguageItem.isPSSystemNameDirty() && !bl2 : !pSLanguageItem.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSLanguageItem.getPSSystemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default((IEntity)pSLanguageItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSLanguageItem pSLanguageItem, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSLanguageItem, bl);
    }

    protected void onSyncIndexEntities(PSLanguageItem pSLanguageItem, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSLanguageItem, bl);
    }

    public Object getDataContextValue(PSLanguageItem pSLanguageItem, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSLanguageItem, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSLanguageItem pSLanguageItem, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSLanguageItem, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Content_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENT2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Content2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFCONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefContent_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LANRESTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LanResTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSLANGUAGEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSLanguageId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSLANGUAGEITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSLanguageItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSLANGUAGEITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSLanguageItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSLANGUAGENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSLanguageName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSLANGUAGERESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSLanguageResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSLANGUAGERESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSLanguageResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_Content_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENT", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Content2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENT2", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CreateDate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CreateMan_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATEMAN", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DefContent_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEFCONTENT", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LanResTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LANRESTAG", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LockFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Memo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSLanguageId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSLANGUAGEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSLanguageItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSLANGUAGEITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSLanguageItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSLANGUAGEITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSLanguageName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSLANGUAGENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSLanguageResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSLANGUAGERESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSLanguageResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSLANGUAGERESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UpdateDate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UpdateMan_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPDATEMAN", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSLanguageItem pSLanguageItem) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSLanguageItem)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSLanguageItem pSLanguageItem) throws Exception {
        Object object = pSLanguageItem.get("PSLANGUAGERESID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSLANGUAGEITEM_PSLANGUAGERES_PSLANGUAGERESID", object);
        }
        super.onUpdateParent((IEntity)pSLanguageItem);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSLanguageItem pSLanguageItem, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSLANGUAGEITEM");
        if (!bl) {
            pSLanguageItem.setCreateDate(null);
            pSLanguageItem.setCreateMan(null);
            pSLanguageItem.setPSLanguageItemId(null);
            pSLanguageItem.setPSLanguageItemName(null);
            pSLanguageItem.setUpdateDate(null);
            pSLanguageItem.setUpdateMan(null);
            super.exportCurXmlModel(pSLanguageItem, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSLanguageItem pSLanguageItem, PSSystem pSSystem) throws Exception {
        PSLanguageItem pSLanguageItem2 = new PSLanguageItem();
        pSLanguageItem2.setPSSystemId(pSLanguageItem.getPSSystemId());
        pSLanguageItem2.setPSLanguageId(pSLanguageItem.getPSLanguageId());
        pSLanguageItem2.setPSLanguageResId(pSLanguageItem.getPSLanguageResId());
        if (this.selectOne((IEntity)pSLanguageItem2, true)) {
            return pSLanguageItem2.getPSLanguageItemId();
        }
        return super.getEntityFolderKeyValue(pSLanguageItem, pSSystem);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSLanguageItem pSLanguageItem, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSLanguageItem, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSMODULE#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSLANGUAGEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSLANGUAGE#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSLANGUAGEITEM_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSLANGUAGEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSLANGUAGEITEM_PSLANGUAGE_PSLANGUAGEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULENAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSLANGUAGEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSLANGUAGENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSMODULE", (boolean)true) == 0) {
            iEntity.set("PSMODULEID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSLANGUAGE", (boolean)true) == 0) {
            iEntity.set("PSLANGUAGEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSMODULEID", "PSLANGUAGEID"};
    }

    @Override
    public String getModelV2Tag(PSLanguageItem pSLanguageItem) {
        if (!StringHelper.isNullOrEmpty((String)pSLanguageItem.getPSLanguageItemName())) {
            return pSLanguageItem.getPSLanguageItemName();
        }
        return super.getModelV2Tag(pSLanguageItem);
    }

    @Override
    public boolean setModelV2Tag(PSLanguageItem pSLanguageItem, String string) {
        pSLanguageItem.setPSLanguageItemName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSLANGUAGEITEMNAME", "");
        map.put("PSLANGUAGEITEMNAME", "");
        map.put("PSMODULEID", "");
        map.put("PSLANGUAGEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSLanguageItem pSLanguageItem, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSLanguageItem.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSLanguageItem, true);
        pSLanguageItem.set("PSLANGUAGEITEMNAME", string);
        if (this.select(pSLanguageItem, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSLanguageItem, true);
        return super.getModelV2Entity(pSLanguageItem, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSLanguageItem pSLanguageItem, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSLanguageItem, objectNode, string, string2, n);
    }
}

