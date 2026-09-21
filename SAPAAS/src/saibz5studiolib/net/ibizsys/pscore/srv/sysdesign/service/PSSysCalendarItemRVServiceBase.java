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
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysCalendarItemRVDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysCalendarItemRVDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCalendarItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCalendarItemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCalendarItemRV;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysCalendarItemRVServiceBase
extends PSCoreSysServiceBase<PSSysCalendarItemRV> {
    private static final Log log = LogFactory.getLog(PSSysCalendarItemRVServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysCalendarItemRVDEModel pSSysCalendarItemRVDEModel;
    private PSSysCalendarItemRVDAO pSSysCalendarItemRVDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarItemRVService";
    }

    public PSSysCalendarItemRVDEModel getPSSysCalendarItemRVDEModel() {
        if (this.pSSysCalendarItemRVDEModel == null) {
            try {
                this.pSSysCalendarItemRVDEModel = (PSSysCalendarItemRVDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysCalendarItemRVDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysCalendarItemRVDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysCalendarItemRVDEModel();
    }

    public PSSysCalendarItemRVDAO getPSSysCalendarItemRVDAO() {
        if (this.pSSysCalendarItemRVDAO == null) {
            try {
                this.pSSysCalendarItemRVDAO = (PSSysCalendarItemRVDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysCalendarItemRVDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysCalendarItemRVDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysCalendarItemRVDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, true);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSysCalendarItemRV pSSysCalendarItemRV, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARITEMRV_PSDEVIEWBASE_PSDEVIEWBASEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEViewBase);
            } else {
                iService.get((IEntity)pSDEViewBase);
            }
            this.onFillParentInfo_PSDEViewBase(pSSysCalendarItemRV, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCALENDARITEMRV_PSSYSCALENDARITEM_PSSYSCALENDARITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarItemService", (SessionFactory)this.getSessionFactory());
            PSSysCalendarItem pSSysCalendarItem = (PSSysCalendarItem)iService.getDEModel().createEntity();
            pSSysCalendarItem.set("PSSYSCALENDARITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysCalendarItem);
            } else {
                iService.get((IEntity)pSSysCalendarItem);
            }
            this.onFillParentInfo_PSSysCalendarItem(pSSysCalendarItemRV, pSSysCalendarItem);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysCalendarItemRV, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDEViewBase(PSSysCalendarItemRV pSSysCalendarItemRV, PSDEViewBase pSDEViewBase) throws Exception {
        pSSysCalendarItemRV.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
        pSSysCalendarItemRV.setPSDEViewBaseName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_PSSysCalendarItem(PSSysCalendarItemRV pSSysCalendarItemRV, PSSysCalendarItem pSSysCalendarItem) throws Exception {
        pSSysCalendarItemRV.setPSSysCalendarId(pSSysCalendarItem.getPSSysCalendarId());
        pSSysCalendarItemRV.setPSSysCalendarItemId(pSSysCalendarItem.getPSSysCalendarItemId());
        pSSysCalendarItemRV.setPSSysCalendarItemName(pSSysCalendarItem.getPSSysCalendarItemName());
    }

    protected void onFillEntityFullInfo(PSSysCalendarItemRV pSSysCalendarItemRV, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSSysCalendarItemRV, bl);
        this.onFillEntityFullInfo_PSDEViewBase(pSSysCalendarItemRV, bl);
        this.onFillEntityFullInfo_PSSysCalendarItem(pSSysCalendarItemRV, bl);
    }

    protected void onFillEntityFullInfo_PSDEViewBase(PSSysCalendarItemRV pSSysCalendarItemRV, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysCalendarItem(PSSysCalendarItemRV pSSysCalendarItemRV, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysCalendarItemRV pSSysCalendarItemRV, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysCalendarItemRV, bl);
    }

    public ArrayList<PSSysCalendarItemRV> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByPSDEViewBase(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSSysCalendarItemRV> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByPSDEViewBase(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSSysCalendarItemRV> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVIEWBASEID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEViewBaseCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEViewBaseCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysCalendarItemRV> selectByPSSysCalendarItem(PSSysCalendarItemBase pSSysCalendarItemBase) throws Exception {
        return this.selectByPSSysCalendarItem(pSSysCalendarItemBase, "", -1);
    }

    public ArrayList<PSSysCalendarItemRV> selectByPSSysCalendarItem(PSSysCalendarItemBase pSSysCalendarItemBase, String string) throws Exception {
        return this.selectByPSSysCalendarItem(pSSysCalendarItemBase, string, -1);
    }

    public ArrayList<PSSysCalendarItemRV> selectByPSSysCalendarItem(PSSysCalendarItemBase pSSysCalendarItemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSCALENDARITEMID", (Object)pSSysCalendarItemBase.getPSSysCalendarItemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysCalendarItemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysCalendarItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysCalendarItemRV> selectTempByPSSysCalendarItem(PSSysCalendarItemBase pSSysCalendarItemBase) throws Exception {
        return this.selectTempByPSSysCalendarItem(pSSysCalendarItemBase, "");
    }

    public ArrayList<PSSysCalendarItemRV> selectTempByPSSysCalendarItem(PSSysCalendarItemBase pSSysCalendarItemBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSCALENDARITEMID", (Object)pSSysCalendarItemBase.getPSSysCalendarItemId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSSysCalendarItemCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSSysCalendarItemCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSSysCalendarItemRV> arrayList = this.selectByPSDEViewBase(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCALENDARITEMRV_PSDEVIEWBASE_PSDEVIEWBASEID", "", iDataEntityModel.getName(), "PSSYSCALENDARITEMRV", iDataEntityModel.getDataInfo((IEntity)pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSSysCalendarItemRV> arrayList = this.selectByPSDEViewBase(pSDEViewBase);
        for (PSSysCalendarItemRV pSSysCalendarItemRV : arrayList) {
            PSSysCalendarItemRV pSSysCalendarItemRV2 = (PSSysCalendarItemRV)this.getDEModel().createEntity();
            pSSysCalendarItemRV2.setPSSysCalendarItemRVId(pSSysCalendarItemRV.getPSSysCalendarItemRVId());
            pSSysCalendarItemRV2.setPSDEViewBaseId(null);
            this.update(pSSysCalendarItemRV2);
        }
    }

    public void removeByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemRVServiceBase.this.onBeforeRemoveByPSDEViewBase(pSDEViewBase2);
                PSSysCalendarItemRVServiceBase.this.internalRemoveByPSDEViewBase(pSDEViewBase2);
                PSSysCalendarItemRVServiceBase.this.onAfterRemoveByPSDEViewBase(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSSysCalendarItemRV> arrayList = this.selectByPSDEViewBase(pSDEViewBase);
        this.onBeforeRemoveByPSDEViewBase(pSDEViewBase, arrayList);
        for (PSSysCalendarItemRV pSSysCalendarItemRV : arrayList) {
            this.remove((IEntity)pSSysCalendarItemRV);
        }
        this.onAfterRemoveByPSDEViewBase(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSSysCalendarItemRV> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSSysCalendarItemRV> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCalendarItem(PSSysCalendarItem pSSysCalendarItem) throws Exception {
    }

    public void resetPSSysCalendarItem(PSSysCalendarItem pSSysCalendarItem) throws Exception {
        ArrayList<PSSysCalendarItemRV> arrayList = this.selectByPSSysCalendarItem(pSSysCalendarItem);
        for (PSSysCalendarItemRV pSSysCalendarItemRV : arrayList) {
            PSSysCalendarItemRV pSSysCalendarItemRV2 = (PSSysCalendarItemRV)this.getDEModel().createEntity();
            pSSysCalendarItemRV2.setPSSysCalendarItemRVId(pSSysCalendarItemRV.getPSSysCalendarItemRVId());
            pSSysCalendarItemRV2.setPSSysCalendarItemId(null);
            this.update(pSSysCalendarItemRV2);
        }
    }

    public void resetTempPSSysCalendarItem(PSSysCalendarItem pSSysCalendarItem) throws Exception {
        ArrayList<PSSysCalendarItemRV> arrayList = this.selectTempByPSSysCalendarItem(pSSysCalendarItem);
        for (PSSysCalendarItemRV pSSysCalendarItemRV : arrayList) {
            PSSysCalendarItemRV pSSysCalendarItemRV2 = (PSSysCalendarItemRV)this.getDEModel().createEntity();
            pSSysCalendarItemRV2.setPSSysCalendarItemRVId(pSSysCalendarItemRV.getPSSysCalendarItemRVId());
            pSSysCalendarItemRV2.setPSSysCalendarItemId(null);
            this.updateTemp((IEntity)pSSysCalendarItemRV2);
        }
    }

    public void removeByPSSysCalendarItem(PSSysCalendarItem pSSysCalendarItem) throws Exception {
        final PSSysCalendarItem pSSysCalendarItem2 = pSSysCalendarItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemRVServiceBase.this.onBeforeRemoveByPSSysCalendarItem(pSSysCalendarItem2);
                PSSysCalendarItemRVServiceBase.this.internalRemoveByPSSysCalendarItem(pSSysCalendarItem2);
                PSSysCalendarItemRVServiceBase.this.onAfterRemoveByPSSysCalendarItem(pSSysCalendarItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCalendarItem(PSSysCalendarItem pSSysCalendarItem) throws Exception {
    }

    protected void internalRemoveByPSSysCalendarItem(PSSysCalendarItem pSSysCalendarItem) throws Exception {
        ArrayList<PSSysCalendarItemRV> arrayList = this.selectByPSSysCalendarItem(pSSysCalendarItem);
        this.onBeforeRemoveByPSSysCalendarItem(pSSysCalendarItem, arrayList);
        for (PSSysCalendarItemRV pSSysCalendarItemRV : arrayList) {
            this.remove((IEntity)pSSysCalendarItemRV);
        }
        this.onAfterRemoveByPSSysCalendarItem(pSSysCalendarItem, arrayList);
    }

    protected void onAfterRemoveByPSSysCalendarItem(PSSysCalendarItem pSSysCalendarItem) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCalendarItem(PSSysCalendarItem pSSysCalendarItem, ArrayList<PSSysCalendarItemRV> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCalendarItem(PSSysCalendarItem pSSysCalendarItem, ArrayList<PSSysCalendarItemRV> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysCalendarItemRV pSSysCalendarItemRV) throws Exception {
        super.onBeforeRemove(pSSysCalendarItemRV);
    }

    public void removeTempByPSSysCalendarItem(PSSysCalendarItem pSSysCalendarItem) throws Exception {
        final PSSysCalendarItem pSSysCalendarItem2 = pSSysCalendarItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCalendarItemRVServiceBase.this.onBeforeRemoveTempByPSSysCalendarItem(pSSysCalendarItem2);
                PSSysCalendarItemRVServiceBase.this.internalRemoveTempByPSSysCalendarItem(pSSysCalendarItem2);
                PSSysCalendarItemRVServiceBase.this.onAfterRemoveTempByPSSysCalendarItem(pSSysCalendarItem2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSSysCalendarItem(PSSysCalendarItem pSSysCalendarItem) throws Exception {
    }

    protected void internalRemoveTempByPSSysCalendarItem(PSSysCalendarItem pSSysCalendarItem) throws Exception {
        ArrayList<PSSysCalendarItemRV> arrayList = this.selectTempByPSSysCalendarItem(pSSysCalendarItem);
        this.onBeforeRemoveTempByPSSysCalendarItem(pSSysCalendarItem, arrayList);
        for (PSSysCalendarItemRV pSSysCalendarItemRV : arrayList) {
            this.removeTemp((IEntity)pSSysCalendarItemRV);
        }
        this.onAfterRemoveTempByPSSysCalendarItem(pSSysCalendarItem, arrayList);
    }

    protected void onAfterRemoveTempByPSSysCalendarItem(PSSysCalendarItem pSSysCalendarItem) throws Exception {
    }

    protected void onBeforeRemoveTempByPSSysCalendarItem(PSSysCalendarItem pSSysCalendarItem, ArrayList<PSSysCalendarItemRV> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSSysCalendarItem(PSSysCalendarItem pSSysCalendarItem, ArrayList<PSSysCalendarItemRV> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSSysCalendarItemRV pSSysCalendarItemRV, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysCalendarItemRV, cloneSession);
        if (pSSysCalendarItemRV.getPSDEViewBaseId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSSysCalendarItemRV.getPSDEViewBaseId())) != null) {
            this.onFillParentInfo_PSDEViewBase(pSSysCalendarItemRV, (PSDEViewBase)iEntity);
        }
        if (pSSysCalendarItemRV.getPSSysCalendarItemId() != null && (iEntity = cloneSession.getEntity("PSSYSCALENDARITEM", (Object)pSSysCalendarItemRV.getPSSysCalendarItemId())) != null) {
            this.onFillParentInfo_PSSysCalendarItem(pSSysCalendarItemRV, (PSSysCalendarItem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysCalendarItemRV pSSysCalendarItemRV, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysCalendarItemRV, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysCalendarItemRV pSSysCalendarItemRV, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSSysCalendarItemRV, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewBaseId(bl, pSSysCalendarItemRV, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCalendarItemId(bl, pSSysCalendarItemRV, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCalendarItemRVId(bl, pSSysCalendarItemRV, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCalendarItemRVName(bl, pSSysCalendarItemRV, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefModeText(bl, pSSysCalendarItemRV, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParams(bl, pSSysCalendarItemRV, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysCalendarItemRV, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysCalendarItemRV pSSysCalendarItemRV, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItemRV.isMemoDirty() : !pSSysCalendarItemRV.isMemoDirty()) {
            return null;
        }
        String string = pSSysCalendarItemRV.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysCalendarItemRV, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEViewBaseId(boolean bl, PSSysCalendarItemRV pSSysCalendarItemRV, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItemRV.isPSDEViewBaseIdDirty() && !bl2 : !pSSysCalendarItemRV.isPSDEViewBaseIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItemRV.getPSDEViewBaseId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWBASEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewBaseId_Default((IEntity)pSSysCalendarItemRV, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWBASEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysCalendarItemId(boolean bl, PSSysCalendarItemRV pSSysCalendarItemRV, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItemRV.isPSSysCalendarItemIdDirty() && !bl2 : !pSSysCalendarItemRV.isPSSysCalendarItemIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItemRV.getPSSysCalendarItemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCALENDARITEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCalendarItemId_Default((IEntity)pSSysCalendarItemRV, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCALENDARITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysCalendarItemRVId(boolean bl, PSSysCalendarItemRV pSSysCalendarItemRV, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItemRV.isPSSysCalendarItemRVIdDirty() && !bl2 : !pSSysCalendarItemRV.isPSSysCalendarItemRVIdDirty()) {
            return null;
        }
        String string = pSSysCalendarItemRV.getPSSysCalendarItemRVId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCALENDARITEMRVID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCalendarItemRVId_Default((IEntity)pSSysCalendarItemRV, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCALENDARITEMRVID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysCalendarItemRVName(boolean bl, PSSysCalendarItemRV pSSysCalendarItemRV, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItemRV.isPSSysCalendarItemRVNameDirty() && !bl2 : !pSSysCalendarItemRV.isPSSysCalendarItemRVNameDirty()) {
            return null;
        }
        String string = pSSysCalendarItemRV.getPSSysCalendarItemRVName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCALENDARITEMRVNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCalendarItemRVName_Default((IEntity)pSSysCalendarItemRV, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCALENDARITEMRVNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (string == null) {
                bl4 = false;
            }
            if (bl4) {
                String string3 = "";
                string3 = "PSSYSCALENDARITEMID";
                String string4 = this.checkFieldDupRule(this.getPSSysCalendarItemRVDEModel(), "PSSYSCALENDARITEMRVNAME", string3, pSSysCalendarItemRV, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSCALENDARITEMRVNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefModeText(boolean bl, PSSysCalendarItemRV pSSysCalendarItemRV, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItemRV.isRefModeTextDirty() : !pSSysCalendarItemRV.isRefModeTextDirty()) {
            return null;
        }
        String string = pSSysCalendarItemRV.getRefModeText();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefModeText_Default((IEntity)pSSysCalendarItemRV, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFMODETEXT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewParams(boolean bl, PSSysCalendarItemRV pSSysCalendarItemRV, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCalendarItemRV.isViewParamsDirty() : !pSSysCalendarItemRV.isViewParamsDirty()) {
            return null;
        }
        String string = pSSysCalendarItemRV.getViewParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ViewParams_Default((IEntity)pSSysCalendarItemRV, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysCalendarItemRV pSSysCalendarItemRV, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysCalendarItemRV, bl);
    }

    protected void onSyncIndexEntities(PSSysCalendarItemRV pSSysCalendarItemRV, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysCalendarItemRV, bl);
    }

    public Object getDataContextValue(PSSysCalendarItemRV pSSysCalendarItemRV, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysCalendarItemRV, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysCalendarItem pSSysCalendarItem = pSSysCalendarItemRV.getPSSysCalendarItem();
        if (pSSysCalendarItem != null && pSSysCalendarItem.contains(string)) {
            return pSSysCalendarItem.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysCalendarItemRV pSSysCalendarItemRV, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysCalendarItemRV, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWBASEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewBaseId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWBASENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewBaseName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCALENDARID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCalendarId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCALENDARITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCalendarItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCALENDARITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCalendarItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCALENDARITEMRVID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCalendarItemRVId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCALENDARITEMRVNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCalendarItemRVName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFMODETEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefModeText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParams_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
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

    protected String onTestValueRule_Memo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEViewBaseId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWBASEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEViewBaseName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWBASENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysCalendarId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCALENDARID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysCalendarItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCALENDARITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysCalendarItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCALENDARITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysCalendarItemRVId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCALENDARITEMRVID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysCalendarItemRVName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCALENDARITEMRVNAME", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefModeText_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFMODETEXT", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ViewParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEWPARAMS", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysCalendarItemRV pSSysCalendarItemRV) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysCalendarItemRV)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysCalendarItemRV pSSysCalendarItemRV) throws Exception {
        super.onUpdateParent((IEntity)pSSysCalendarItemRV);
    }

    @Override
    protected void exportCurXmlModel(PSSysCalendarItemRV pSSysCalendarItemRV, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSCALENDARITEMRV");
        if (!bl) {
            pSSysCalendarItemRV.setCreateDate(null);
            pSSysCalendarItemRV.setCreateMan(null);
            pSSysCalendarItemRV.setPSSysCalendarItemName(null);
            pSSysCalendarItemRV.setPSSysCalendarItemRVId(null);
            pSSysCalendarItemRV.setUpdateDate(null);
            pSSysCalendarItemRV.setUpdateMan(null);
            pSSysCalendarItemRV.setPSSysCalendarId(null);
            pSSysCalendarItemRV.setPSSysCalendarItemId(null);
            pSSysCalendarItemRV.setPSSysCalendarItemName(null);
            super.exportCurXmlModel(pSSysCalendarItemRV, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysCalendarItemRV pSSysCalendarItemRV, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysCalendarItemRV, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSCALENDARITEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSCALENDARITEM#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSCALENDARITEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSCALENDARITEMRV_PSSYSCALENDARITEM_PSSYSCALENDARITEMID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSCALENDARITEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSCALENDARITEMNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSCALENDARITEM", (boolean)true) == 0) {
            iEntity.set("PSSYSCALENDARITEMID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSCALENDARITEMID"};
    }

    @Override
    public String getModelV2Tag(PSSysCalendarItemRV pSSysCalendarItemRV) {
        if (!StringHelper.isNullOrEmpty((String)pSSysCalendarItemRV.getPSSysCalendarItemRVName())) {
            return pSSysCalendarItemRV.getPSSysCalendarItemRVName();
        }
        return super.getModelV2Tag(pSSysCalendarItemRV);
    }

    @Override
    public boolean setModelV2Tag(PSSysCalendarItemRV pSSysCalendarItemRV, String string) {
        pSSysCalendarItemRV.setPSSysCalendarItemRVName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSCALENDARITEMRVNAME", "");
        map.put("PSSYSCALENDARITEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysCalendarItemRV pSSysCalendarItemRV, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysCalendarItemRV.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysCalendarItemRV, true);
        pSSysCalendarItemRV.set("PSSYSCALENDARITEMRVNAME", string);
        if (this.select(pSSysCalendarItemRV, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysCalendarItemRV, true);
        return super.getModelV2Entity(pSSysCalendarItemRV, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysCalendarItemRV pSSysCalendarItemRV, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSSysCalendarItemRV, objectNode, string, string2, n);
    }
}

