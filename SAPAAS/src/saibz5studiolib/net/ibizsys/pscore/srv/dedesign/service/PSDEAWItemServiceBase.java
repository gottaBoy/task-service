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
package net.ibizsys.pscore.srv.dedesign.service;

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
import net.ibizsys.pscore.srv.dedesign.dao.PSDEAWItemDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEAWItemDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAWItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionWizard;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionWizardBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEAWItemServiceBase
extends PSCoreSysServiceBase<PSDEAWItem> {
    private static final Log log = LogFactory.getLog(PSDEAWItemServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEAWItemDEModel pSDEAWItemDEModel;
    private PSDEAWItemDAO pSDEAWItemDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEAWItemService";
    }

    public PSDEAWItemDEModel getPSDEAWItemDEModel() {
        if (this.pSDEAWItemDEModel == null) {
            try {
                this.pSDEAWItemDEModel = (PSDEAWItemDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEAWItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEAWItemDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEAWItemDEModel();
    }

    public PSDEAWItemDAO getPSDEAWItemDAO() {
        if (this.pSDEAWItemDAO == null) {
            try {
                this.pSDEAWItemDAO = (PSDEAWItemDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEAWItemDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEAWItemDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEAWItemDAO();
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

    protected void onFillParentInfo(PSDEAWItem pSDEAWItem, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEAWITEM_PSDEACTIONWIZARD_PSDEACTIONWIZARDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionWizardService", (SessionFactory)this.getSessionFactory());
            PSDEActionWizard pSDEActionWizard = (PSDEActionWizard)iService.getDEModel().createEntity();
            pSDEActionWizard.set("PSDEACTIONWIZARDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEActionWizard);
            } else {
                iService.get((IEntity)pSDEActionWizard);
            }
            this.onFillParentInfo_PSDEActionWizard(pSDEAWItem, pSDEActionWizard);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEAWITEM_PSDEFIELD_PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_PSDEF(pSDEAWItem, pSDEField);
            return;
        }
        super.onFillParentInfo((IEntity)pSDEAWItem, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDEActionWizard(PSDEAWItem pSDEAWItem, PSDEActionWizard pSDEActionWizard) throws Exception {
        pSDEAWItem.setPSDEActionWizardId(pSDEActionWizard.getPSDEActionWizardId());
        pSDEAWItem.setPSDEActionWizardName(pSDEActionWizard.getPSDEActionWizardName());
    }

    protected void onFillParentInfo_PSDEF(PSDEAWItem pSDEAWItem, PSDEField pSDEField) throws Exception {
        pSDEAWItem.setPSDEFID(pSDEField.getPSDEFieldId());
        pSDEAWItem.setPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillEntityFullInfo(PSDEAWItem pSDEAWItem, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDEAWItem, bl);
        this.onFillEntityFullInfo_PSDEActionWizard(pSDEAWItem, bl);
        this.onFillEntityFullInfo_PSDEF(pSDEAWItem, bl);
    }

    protected void onFillEntityFullInfo_PSDEActionWizard(PSDEAWItem pSDEAWItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEF(PSDEAWItem pSDEAWItem, boolean bl) throws Exception {
        if (pSDEAWItem.isPSDEFIDDirty()) {
            if (pSDEAWItem.getPSDEFID() != null) {
                if (pSDEAWItem.getPSDEFID() == null || pSDEAWItem.getPSDEFName() == null) {
                    PSDEField pSDEField = pSDEAWItem.getPSDEF();
                    pSDEAWItem.setPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEAWItem.setPSDEFName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDEAWItem pSDEAWItem, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEAWItem, bl);
    }

    public ArrayList<PSDEAWItem> selectByPSDEActionWizard(PSDEActionWizardBase pSDEActionWizardBase) throws Exception {
        return this.selectByPSDEActionWizard(pSDEActionWizardBase, "", -1);
    }

    public ArrayList<PSDEAWItem> selectByPSDEActionWizard(PSDEActionWizardBase pSDEActionWizardBase, String string) throws Exception {
        return this.selectByPSDEActionWizard(pSDEActionWizardBase, string, -1);
    }

    public ArrayList<PSDEAWItem> selectByPSDEActionWizard(PSDEActionWizardBase pSDEActionWizardBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEACTIONWIZARDID", (Object)pSDEActionWizardBase.getPSDEActionWizardId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEActionWizardCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEActionWizardCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEAWItem> selectTempByPSDEActionWizard(PSDEActionWizardBase pSDEActionWizardBase) throws Exception {
        return this.selectTempByPSDEActionWizard(pSDEActionWizardBase, "");
    }

    public ArrayList<PSDEAWItem> selectTempByPSDEActionWizard(PSDEActionWizardBase pSDEActionWizardBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEACTIONWIZARDID", (Object)pSDEActionWizardBase.getPSDEActionWizardId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEActionWizardCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEActionWizardCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEAWItem> selectByPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEAWItem> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEAWItem> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDEActionWizard(PSDEActionWizard pSDEActionWizard) throws Exception {
    }

    public void resetPSDEActionWizard(PSDEActionWizard pSDEActionWizard) throws Exception {
        ArrayList<PSDEAWItem> arrayList = this.selectByPSDEActionWizard(pSDEActionWizard);
        for (PSDEAWItem pSDEAWItem : arrayList) {
            PSDEAWItem pSDEAWItem2 = (PSDEAWItem)this.getDEModel().createEntity();
            pSDEAWItem2.setPSDEAWItemId(pSDEAWItem.getPSDEAWItemId());
            pSDEAWItem2.setPSDEActionWizardId(null);
            this.update(pSDEAWItem2);
        }
    }

    public void resetTempPSDEActionWizard(PSDEActionWizard pSDEActionWizard) throws Exception {
        ArrayList<PSDEAWItem> arrayList = this.selectTempByPSDEActionWizard(pSDEActionWizard);
        for (PSDEAWItem pSDEAWItem : arrayList) {
            PSDEAWItem pSDEAWItem2 = (PSDEAWItem)this.getDEModel().createEntity();
            pSDEAWItem2.setPSDEAWItemId(pSDEAWItem.getPSDEAWItemId());
            pSDEAWItem2.setPSDEActionWizardId(null);
            this.updateTemp((IEntity)pSDEAWItem2);
        }
    }

    public void removeByPSDEActionWizard(PSDEActionWizard pSDEActionWizard) throws Exception {
        final PSDEActionWizard pSDEActionWizard2 = pSDEActionWizard;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEAWItemServiceBase.this.onBeforeRemoveByPSDEActionWizard(pSDEActionWizard2);
                PSDEAWItemServiceBase.this.internalRemoveByPSDEActionWizard(pSDEActionWizard2);
                PSDEAWItemServiceBase.this.onAfterRemoveByPSDEActionWizard(pSDEActionWizard2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEActionWizard(PSDEActionWizard pSDEActionWizard) throws Exception {
    }

    protected void internalRemoveByPSDEActionWizard(PSDEActionWizard pSDEActionWizard) throws Exception {
        ArrayList<PSDEAWItem> arrayList = this.selectByPSDEActionWizard(pSDEActionWizard);
        this.onBeforeRemoveByPSDEActionWizard(pSDEActionWizard, arrayList);
        for (PSDEAWItem pSDEAWItem : arrayList) {
            this.remove((IEntity)pSDEAWItem);
        }
        this.onAfterRemoveByPSDEActionWizard(pSDEActionWizard, arrayList);
    }

    protected void onAfterRemoveByPSDEActionWizard(PSDEActionWizard pSDEActionWizard) throws Exception {
    }

    protected void onBeforeRemoveByPSDEActionWizard(PSDEActionWizard pSDEActionWizard, ArrayList<PSDEAWItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEActionWizard(PSDEActionWizard pSDEActionWizard, ArrayList<PSDEAWItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEAWItem> arrayList = this.selectByPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEAWITEM_PSDEFIELD_PSDEFID", "", iDataEntityModel.getName(), "PSDEAWITEM", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEAWItem> arrayList = this.selectByPSDEF(pSDEField);
        for (PSDEAWItem pSDEAWItem : arrayList) {
            PSDEAWItem pSDEAWItem2 = (PSDEAWItem)this.getDEModel().createEntity();
            pSDEAWItem2.setPSDEAWItemId(pSDEAWItem.getPSDEAWItemId());
            pSDEAWItem2.setPSDEFID(null);
            this.update(pSDEAWItem2);
        }
    }

    public void removeByPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEAWItemServiceBase.this.onBeforeRemoveByPSDEF(pSDEField2);
                PSDEAWItemServiceBase.this.internalRemoveByPSDEF(pSDEField2);
                PSDEAWItemServiceBase.this.onAfterRemoveByPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEAWItem> arrayList = this.selectByPSDEF(pSDEField);
        this.onBeforeRemoveByPSDEF(pSDEField, arrayList);
        for (PSDEAWItem pSDEAWItem : arrayList) {
            this.remove((IEntity)pSDEAWItem);
        }
        this.onAfterRemoveByPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSDEAWItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSDEAWItem> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEAWItem pSDEAWItem) throws Exception {
        super.onBeforeRemove(pSDEAWItem);
    }

    public void removeTempByPSDEActionWizard(PSDEActionWizard pSDEActionWizard) throws Exception {
        final PSDEActionWizard pSDEActionWizard2 = pSDEActionWizard;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEAWItemServiceBase.this.onBeforeRemoveTempByPSDEActionWizard(pSDEActionWizard2);
                PSDEAWItemServiceBase.this.internalRemoveTempByPSDEActionWizard(pSDEActionWizard2);
                PSDEAWItemServiceBase.this.onAfterRemoveTempByPSDEActionWizard(pSDEActionWizard2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEActionWizard(PSDEActionWizard pSDEActionWizard) throws Exception {
    }

    protected void internalRemoveTempByPSDEActionWizard(PSDEActionWizard pSDEActionWizard) throws Exception {
        ArrayList<PSDEAWItem> arrayList = this.selectTempByPSDEActionWizard(pSDEActionWizard);
        this.onBeforeRemoveTempByPSDEActionWizard(pSDEActionWizard, arrayList);
        for (PSDEAWItem pSDEAWItem : arrayList) {
            this.removeTemp((IEntity)pSDEAWItem);
        }
        this.onAfterRemoveTempByPSDEActionWizard(pSDEActionWizard, arrayList);
    }

    protected void onAfterRemoveTempByPSDEActionWizard(PSDEActionWizard pSDEActionWizard) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEActionWizard(PSDEActionWizard pSDEActionWizard, ArrayList<PSDEAWItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEActionWizard(PSDEActionWizard pSDEActionWizard, ArrayList<PSDEAWItem> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSDEAWItem pSDEAWItem, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDEAWItem, cloneSession);
        if (pSDEAWItem.getPSDEActionWizardId() != null && (iEntity = cloneSession.getEntity("PSDEACTIONWIZARD", (Object)pSDEAWItem.getPSDEActionWizardId())) != null) {
            this.onFillParentInfo_PSDEActionWizard(pSDEAWItem, (PSDEActionWizard)iEntity);
        }
        if (pSDEAWItem.getPSDEFID() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEAWItem.getPSDEFID())) != null) {
            this.onFillParentInfo_PSDEF(pSDEAWItem, (PSDEField)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEAWItem pSDEAWItem, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEAWItem, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEAWItem pSDEAWItem, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ActionValue(bl, pSDEAWItem, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Content(bl, pSDEAWItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEAWItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MoreUrl(bl, pSDEAWItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDEAWItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEActionWizardId(bl, pSDEAWItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEAWItemId(bl, pSDEAWItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEAWItemName(bl, pSDEAWItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFID(bl, pSDEAWItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFName(bl, pSDEAWItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEAWItem, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ActionValue(boolean bl, PSDEAWItem pSDEAWItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAWItem.isActionValueDirty() : !pSDEAWItem.isActionValueDirty()) {
            return null;
        }
        String string = pSDEAWItem.getActionValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ActionValue_Default((IEntity)pSDEAWItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTIONVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Content(boolean bl, PSDEAWItem pSDEAWItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAWItem.isContentDirty() : !pSDEAWItem.isContentDirty()) {
            return null;
        }
        String string = pSDEAWItem.getContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Content_Default((IEntity)pSDEAWItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEAWItem pSDEAWItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAWItem.isMemoDirty() : !pSDEAWItem.isMemoDirty()) {
            return null;
        }
        String string = pSDEAWItem.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDEAWItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_MoreUrl(boolean bl, PSDEAWItem pSDEAWItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAWItem.isMoreUrlDirty() : !pSDEAWItem.isMoreUrlDirty()) {
            return null;
        }
        String string = pSDEAWItem.getMoreUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MoreUrl_Default((IEntity)pSDEAWItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MOREURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDEAWItem pSDEAWItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAWItem.isOrderValueDirty() : !pSDEAWItem.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDEAWItem.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSDEAWItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEActionWizardId(boolean bl, PSDEAWItem pSDEAWItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAWItem.isPSDEActionWizardIdDirty() : !pSDEAWItem.isPSDEActionWizardIdDirty()) {
            return null;
        }
        String string = pSDEAWItem.getPSDEActionWizardId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEActionWizardId_Default((IEntity)pSDEAWItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACTIONWIZARDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEAWItemId(boolean bl, PSDEAWItem pSDEAWItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAWItem.isPSDEAWItemIdDirty() && !bl2 : !pSDEAWItem.isPSDEAWItemIdDirty()) {
            return null;
        }
        String string = pSDEAWItem.getPSDEAWItemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEAWITEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEAWItemId_Default((IEntity)pSDEAWItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEAWITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEAWItemName(boolean bl, PSDEAWItem pSDEAWItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAWItem.isPSDEAWItemNameDirty() && !bl2 : !pSDEAWItem.isPSDEAWItemNameDirty()) {
            return null;
        }
        String string = pSDEAWItem.getPSDEAWItemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEAWITEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEAWItemName_Default((IEntity)pSDEAWItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEAWITEMNAME");
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
                string3 = "PSDEACTIONWIZARDID";
                String string4 = this.checkFieldDupRule(this.getPSDEAWItemDEModel(), "PSDEAWITEMNAME", string3, pSDEAWItem, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEAWITEMNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFID(boolean bl, PSDEAWItem pSDEAWItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAWItem.isPSDEFIDDirty() && !bl2 : !pSDEAWItem.isPSDEFIDDirty()) {
            return null;
        }
        String string = pSDEAWItem.getPSDEFID();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFID_Default((IEntity)pSDEAWItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFName(boolean bl, PSDEAWItem pSDEAWItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEAWItem.isPSDEFNameDirty() && !bl2 : !pSDEAWItem.isPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEAWItem.getPSDEFName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFName_Default((IEntity)pSDEAWItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDEAWItem pSDEAWItem, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEAWItem, bl);
    }

    protected void onSyncIndexEntities(PSDEAWItem pSDEAWItem, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEAWItem, bl);
    }

    public Object getDataContextValue(PSDEAWItem pSDEAWItem, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDEAWItem, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEActionWizard pSDEActionWizard = pSDEAWItem.getPSDEActionWizard();
        if (pSDEActionWizard != null && pSDEActionWizard.contains(string)) {
            return pSDEActionWizard.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEAWItem pSDEAWItem, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDEAWItem, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ACTIONVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActionValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Content_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOREURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MoreUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONWIZARDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionWizardId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONWIZARDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionWizardName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEAWITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEAWItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEAWITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEAWItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFID_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_ActionValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACTIONVALUE", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Content_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENT", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
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

    protected String onTestValueRule_MoreUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOREURL", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDEActionWizardId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACTIONWIZARDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEActionWizardName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACTIONWIZARDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEAWItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEAWITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEAWItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEAWITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFID_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected boolean onMergeChild(String string, String string2, PSDEAWItem pSDEAWItem) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEAWItem)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEAWItem pSDEAWItem) throws Exception {
        super.onUpdateParent((IEntity)pSDEAWItem);
    }

    @Override
    protected void exportCurXmlModel(PSDEAWItem pSDEAWItem, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEAWITEM");
        if (!bl) {
            pSDEAWItem.setCreateDate(null);
            pSDEAWItem.setCreateMan(null);
            pSDEAWItem.setPSDEActionWizardName(null);
            pSDEAWItem.setPSDEAWItemId(null);
            pSDEAWItem.setUpdateDate(null);
            pSDEAWItem.setUpdateMan(null);
            pSDEAWItem.setPSDEActionWizardId(null);
            pSDEAWItem.setPSDEActionWizardName(null);
            super.exportCurXmlModel(pSDEAWItem, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEAWItem pSDEAWItem, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEAWItem, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEACTIONWIZARDID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEACTIONWIZARD#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEACTIONWIZARDID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEAWITEM_PSDEACTIONWIZARD_PSDEACTIONWIZARDID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEACTIONWIZARDID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEACTIONWIZARDNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDEACTIONWIZARD", (boolean)true) == 0) {
            iEntity.set("PSDEACTIONWIZARDID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDEACTIONWIZARDID"};
    }

    @Override
    public String getModelV2Tag(PSDEAWItem pSDEAWItem) {
        if (!StringHelper.isNullOrEmpty((String)pSDEAWItem.getPSDEAWItemName())) {
            return pSDEAWItem.getPSDEAWItemName();
        }
        return super.getModelV2Tag(pSDEAWItem);
    }

    @Override
    public boolean setModelV2Tag(PSDEAWItem pSDEAWItem, String string) {
        return super.setModelV2Tag(pSDEAWItem, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDEAWITEMNAME", "");
        map.put("PSDEACTIONWIZARDID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEAWItem pSDEAWItem, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEAWItem.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEAWItem, true);
        pSDEAWItem.set("PSDEAWITEMNAME", string);
        if (this.select(pSDEAWItem, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEAWItem, true);
        return super.getModelV2Entity(pSDEAWItem, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEAWItem pSDEAWItem, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSDEAWItem, objectNode, string, string2, n);
    }
}

