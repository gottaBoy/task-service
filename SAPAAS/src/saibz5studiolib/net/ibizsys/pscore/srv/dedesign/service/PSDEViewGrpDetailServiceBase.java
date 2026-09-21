/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
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

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
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
import net.ibizsys.pscore.srv.dedesign.dao.PSDEViewGrpDetailDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEViewGrpDetailDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewGroupBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewGrpDetail;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEViewGrpDetailServiceBase
extends PSCoreSysServiceBase<PSDEViewGrpDetail> {
    private static final Log log = LogFactory.getLog(PSDEViewGrpDetailServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEViewGrpDetailDEModel pSDEViewGrpDetailDEModel;
    private PSDEViewGrpDetailDAO pSDEViewGrpDetailDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEViewGrpDetailService";
    }

    public PSDEViewGrpDetailDEModel getPSDEViewGrpDetailDEModel() {
        if (this.pSDEViewGrpDetailDEModel == null) {
            try {
                this.pSDEViewGrpDetailDEModel = (PSDEViewGrpDetailDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEViewGrpDetailDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEViewGrpDetailDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEViewGrpDetailDEModel();
    }

    public PSDEViewGrpDetailDAO getPSDEViewGrpDetailDAO() {
        if (this.pSDEViewGrpDetailDAO == null) {
            try {
                this.pSDEViewGrpDetailDAO = (PSDEViewGrpDetailDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEViewGrpDetailDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEViewGrpDetailDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEViewGrpDetailDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDEViewGrpDetail pSDEViewGrpDetail, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWGRPDETAIL_PSDEVIEWBASE_PSDEVIEWBASEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEViewBase);
            } else {
                iService.get((IEntity)pSDEViewBase);
            }
            this.onFillParentInfo_PSDEViewBase(pSDEViewGrpDetail, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWGRPDETAIL_PSDEVIEWGROUP_PSDEVIEWGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewGroupService", (SessionFactory)this.getSessionFactory());
            PSDEViewGroup pSDEViewGroup = (PSDEViewGroup)iService.getDEModel().createEntity();
            pSDEViewGroup.set("PSDEVIEWGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEViewGroup);
            } else {
                iService.get((IEntity)pSDEViewGroup);
            }
            this.onFillParentInfo_PSDEViewGroup(pSDEViewGrpDetail, pSDEViewGroup);
            return;
        }
        super.onFillParentInfo((IEntity)pSDEViewGrpDetail, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDEViewBase(PSDEViewGrpDetail pSDEViewGrpDetail, PSDEViewBase pSDEViewBase) throws Exception {
        pSDEViewGrpDetail.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
        pSDEViewGrpDetail.setPSDEViewBaseName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_PSDEViewGroup(PSDEViewGrpDetail pSDEViewGrpDetail, PSDEViewGroup pSDEViewGroup) throws Exception {
        pSDEViewGrpDetail.setPSDEViewGroupId(pSDEViewGroup.getPSDEViewGroupId());
        pSDEViewGrpDetail.setPSDEViewGroupName(pSDEViewGroup.getPSDEViewGroupName());
    }

    protected void onFillEntityFullInfo(PSDEViewGrpDetail pSDEViewGrpDetail, boolean bl) throws Exception {
        if (bl && pSDEViewGrpDetail.getValidFlag() == null) {
            pSDEViewGrpDetail.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSDEViewGrpDetail, bl);
        this.onFillEntityFullInfo_PSDEViewBase(pSDEViewGrpDetail, bl);
        this.onFillEntityFullInfo_PSDEViewGroup(pSDEViewGrpDetail, bl);
    }

    protected void onFillEntityFullInfo_PSDEViewBase(PSDEViewGrpDetail pSDEViewGrpDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEViewGroup(PSDEViewGrpDetail pSDEViewGrpDetail, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEViewGrpDetail pSDEViewGrpDetail, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEViewGrpDetail, bl);
    }

    public ArrayList<PSDEViewGrpDetail> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByPSDEViewBase(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSDEViewGrpDetail> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByPSDEViewBase(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSDEViewGrpDetail> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewGrpDetail> selectByPSDEViewGroup(PSDEViewGroupBase pSDEViewGroupBase) throws Exception {
        return this.selectByPSDEViewGroup(pSDEViewGroupBase, "", -1);
    }

    public ArrayList<PSDEViewGrpDetail> selectByPSDEViewGroup(PSDEViewGroupBase pSDEViewGroupBase, String string) throws Exception {
        return this.selectByPSDEViewGroup(pSDEViewGroupBase, string, -1);
    }

    public ArrayList<PSDEViewGrpDetail> selectByPSDEViewGroup(PSDEViewGroupBase pSDEViewGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVIEWGROUPID", (Object)pSDEViewGroupBase.getPSDEViewGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEViewGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEViewGroupCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEViewGrpDetail> arrayList = this.selectByPSDEViewBase(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWGRPDETAIL_PSDEVIEWBASE_PSDEVIEWBASEID", "", iDataEntityModel.getName(), "PSDEVIEWGRPDETAIL", iDataEntityModel.getDataInfo((IEntity)pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEViewGrpDetail> arrayList = this.selectByPSDEViewBase(pSDEViewBase);
        for (PSDEViewGrpDetail pSDEViewGrpDetail : arrayList) {
            PSDEViewGrpDetail pSDEViewGrpDetail2 = (PSDEViewGrpDetail)this.getDEModel().createEntity();
            pSDEViewGrpDetail2.setPSDEViewGrpDetailId(pSDEViewGrpDetail.getPSDEViewGrpDetailId());
            pSDEViewGrpDetail2.setPSDEViewBaseId(null);
            this.update(pSDEViewGrpDetail2);
        }
    }

    public void removeByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewGrpDetailServiceBase.this.onBeforeRemoveByPSDEViewBase(pSDEViewBase2);
                PSDEViewGrpDetailServiceBase.this.internalRemoveByPSDEViewBase(pSDEViewBase2);
                PSDEViewGrpDetailServiceBase.this.onAfterRemoveByPSDEViewBase(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEViewGrpDetail> arrayList = this.selectByPSDEViewBase(pSDEViewBase);
        this.onBeforeRemoveByPSDEViewBase(pSDEViewBase, arrayList);
        for (PSDEViewGrpDetail pSDEViewGrpDetail : arrayList) {
            this.remove((IEntity)pSDEViewGrpDetail);
        }
        this.onAfterRemoveByPSDEViewBase(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSDEViewGrpDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSDEViewGrpDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSDEViewGroup(PSDEViewGroup pSDEViewGroup) throws Exception {
    }

    public void resetPSDEViewGroup(PSDEViewGroup pSDEViewGroup) throws Exception {
        ArrayList<PSDEViewGrpDetail> arrayList = this.selectByPSDEViewGroup(pSDEViewGroup);
        for (PSDEViewGrpDetail pSDEViewGrpDetail : arrayList) {
            PSDEViewGrpDetail pSDEViewGrpDetail2 = (PSDEViewGrpDetail)this.getDEModel().createEntity();
            pSDEViewGrpDetail2.setPSDEViewGrpDetailId(pSDEViewGrpDetail.getPSDEViewGrpDetailId());
            pSDEViewGrpDetail2.setPSDEViewGroupId(null);
            this.update(pSDEViewGrpDetail2);
        }
    }

    public void removeByPSDEViewGroup(PSDEViewGroup pSDEViewGroup) throws Exception {
        final PSDEViewGroup pSDEViewGroup2 = pSDEViewGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewGrpDetailServiceBase.this.onBeforeRemoveByPSDEViewGroup(pSDEViewGroup2);
                PSDEViewGrpDetailServiceBase.this.internalRemoveByPSDEViewGroup(pSDEViewGroup2);
                PSDEViewGrpDetailServiceBase.this.onAfterRemoveByPSDEViewGroup(pSDEViewGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEViewGroup(PSDEViewGroup pSDEViewGroup) throws Exception {
    }

    protected void internalRemoveByPSDEViewGroup(PSDEViewGroup pSDEViewGroup) throws Exception {
        ArrayList<PSDEViewGrpDetail> arrayList = this.selectByPSDEViewGroup(pSDEViewGroup);
        this.onBeforeRemoveByPSDEViewGroup(pSDEViewGroup, arrayList);
        for (PSDEViewGrpDetail pSDEViewGrpDetail : arrayList) {
            this.remove((IEntity)pSDEViewGrpDetail);
        }
        this.onAfterRemoveByPSDEViewGroup(pSDEViewGroup, arrayList);
    }

    protected void onAfterRemoveByPSDEViewGroup(PSDEViewGroup pSDEViewGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSDEViewGroup(PSDEViewGroup pSDEViewGroup, ArrayList<PSDEViewGrpDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEViewGroup(PSDEViewGroup pSDEViewGroup, ArrayList<PSDEViewGrpDetail> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEViewGrpDetail pSDEViewGrpDetail) throws Exception {
        super.onBeforeRemove(pSDEViewGrpDetail);
    }

    protected void replaceParentInfo(PSDEViewGrpDetail pSDEViewGrpDetail, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDEViewGrpDetail, cloneSession);
        if (pSDEViewGrpDetail.getPSDEViewBaseId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSDEViewGrpDetail.getPSDEViewBaseId())) != null) {
            this.onFillParentInfo_PSDEViewBase(pSDEViewGrpDetail, (PSDEViewBase)iEntity);
        }
        if (pSDEViewGrpDetail.getPSDEViewGroupId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWGROUP", (Object)pSDEViewGrpDetail.getPSDEViewGroupId())) != null) {
            this.onFillParentInfo_PSDEViewGroup(pSDEViewGrpDetail, (PSDEViewGroup)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEViewGrpDetail pSDEViewGrpDetail, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEViewGrpDetail, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEViewGrpDetail pSDEViewGrpDetail, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSDEViewGrpDetail, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewBaseId(bl, pSDEViewGrpDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewGroupId(bl, pSDEViewGrpDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewGrpDetailId(bl, pSDEViewGrpDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewGrpDetailName(bl, pSDEViewGrpDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefMode(bl, pSDEViewGrpDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDEViewGrpDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEViewGrpDetail, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEViewGrpDetail pSDEViewGrpDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewGrpDetail.isMemoDirty() : !pSDEViewGrpDetail.isMemoDirty()) {
            return null;
        }
        String string = pSDEViewGrpDetail.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDEViewGrpDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEViewBaseId(boolean bl, PSDEViewGrpDetail pSDEViewGrpDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewGrpDetail.isPSDEViewBaseIdDirty() && !bl2 : !pSDEViewGrpDetail.isPSDEViewBaseIdDirty()) {
            return null;
        }
        String string = pSDEViewGrpDetail.getPSDEViewBaseId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWBASEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewBaseId_Default((IEntity)pSDEViewGrpDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEViewGroupId(boolean bl, PSDEViewGrpDetail pSDEViewGrpDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewGrpDetail.isPSDEViewGroupIdDirty() && !bl2 : !pSDEViewGrpDetail.isPSDEViewGroupIdDirty()) {
            return null;
        }
        String string = pSDEViewGrpDetail.getPSDEViewGroupId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWGROUPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewGroupId_Default((IEntity)pSDEViewGrpDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEViewGrpDetailId(boolean bl, PSDEViewGrpDetail pSDEViewGrpDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewGrpDetail.isPSDEViewGrpDetailIdDirty() && !bl2 : !pSDEViewGrpDetail.isPSDEViewGrpDetailIdDirty()) {
            return null;
        }
        String string = pSDEViewGrpDetail.getPSDEViewGrpDetailId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWGRPDETAILID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewGrpDetailId_Default((IEntity)pSDEViewGrpDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWGRPDETAILID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEViewGrpDetailName(boolean bl, PSDEViewGrpDetail pSDEViewGrpDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewGrpDetail.isPSDEViewGrpDetailNameDirty() && !bl2 : !pSDEViewGrpDetail.isPSDEViewGrpDetailNameDirty()) {
            return null;
        }
        String string = pSDEViewGrpDetail.getPSDEViewGrpDetailName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWGRPDETAILNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewGrpDetailName_Default((IEntity)pSDEViewGrpDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWGRPDETAILNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefMode(boolean bl, PSDEViewGrpDetail pSDEViewGrpDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewGrpDetail.isRefModeDirty() : !pSDEViewGrpDetail.isRefModeDirty()) {
            return null;
        }
        String string = pSDEViewGrpDetail.getRefMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefMode_Default((IEntity)pSDEViewGrpDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFMODE");
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
                string3 = "PSDEVIEWGROUPID";
                String string4 = this.checkFieldDupRule(this.getPSDEViewGrpDetailDEModel(), "REFMODE", string3, pSDEViewGrpDetail, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("REFMODE");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDEViewGrpDetail pSDEViewGrpDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewGrpDetail.isValidFlagDirty() && !bl2 : !pSDEViewGrpDetail.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDEViewGrpDetail.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSDEViewGrpDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDEViewGrpDetail pSDEViewGrpDetail, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEViewGrpDetail, bl);
    }

    protected void onSyncIndexEntities(PSDEViewGrpDetail pSDEViewGrpDetail, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEViewGrpDetail, bl);
    }

    public Object getDataContextValue(PSDEViewGrpDetail pSDEViewGrpDetail, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDEViewGrpDetail, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEViewGroup pSDEViewGroup = pSDEViewGrpDetail.getPSDEViewGroup();
        if (pSDEViewGroup != null && pSDEViewGroup.contains(string)) {
            return pSDEViewGroup.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEViewGrpDetail pSDEViewGrpDetail, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDEViewGrpDetail, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSDEVIEWGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWGRPDETAILID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewGrpDetailId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWGRPDETAILNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewGrpDetailName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
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
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
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

    protected String onTestValueRule_PSDEViewGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEViewGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEViewGrpDetailId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWGRPDETAILID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEViewGrpDetailName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWGRPDETAILNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFMODE", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDEViewGrpDetail pSDEViewGrpDetail) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEViewGrpDetail)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEViewGrpDetail pSDEViewGrpDetail) throws Exception {
        super.onUpdateParent((IEntity)pSDEViewGrpDetail);
    }

    @Override
    protected void exportCurXmlModel(PSDEViewGrpDetail pSDEViewGrpDetail, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVIEWGRPDETAIL");
        if (!bl) {
            pSDEViewGrpDetail.setCreateDate(null);
            pSDEViewGrpDetail.setCreateMan(null);
            pSDEViewGrpDetail.setPSDEViewGrpDetailId(null);
            pSDEViewGrpDetail.setUpdateDate(null);
            pSDEViewGrpDetail.setUpdateMan(null);
            super.exportCurXmlModel(pSDEViewGrpDetail, xmlNode, bl);
        }
    }
}

