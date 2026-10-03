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
package net.ibizsys.pscore.srv.sysdesign.service;

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
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysOUTypeRSDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysOUTypeRSDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysOUType;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysOUTypeBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysOUTypeRS;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysOUTypeRSServiceBase
extends PSCoreSysServiceBase<PSSysOUTypeRS> {
    private static final Log log = LogFactory.getLog(PSSysOUTypeRSServiceBase.class);
    public static final String DATASET_CURORG = "CurOrg";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysOUTypeRSDEModel pSSysOUTypeRSDEModel;
    private PSSysOUTypeRSDAO pSSysOUTypeRSDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysOUTypeRSService";
    }

    public PSSysOUTypeRSDEModel getPSSysOUTypeRSDEModel() {
        if (this.pSSysOUTypeRSDEModel == null) {
            try {
                this.pSSysOUTypeRSDEModel = (PSSysOUTypeRSDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysOUTypeRSDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysOUTypeRSDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysOUTypeRSDEModel();
    }

    public PSSysOUTypeRSDAO getPSSysOUTypeRSDAO() {
        if (this.pSSysOUTypeRSDAO == null) {
            try {
                this.pSSysOUTypeRSDAO = (PSSysOUTypeRSDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysOUTypeRSDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysOUTypeRSDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysOUTypeRSDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURORG, (boolean)true) == 0) {
            return this.fetchCurOrg(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurOrg(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURORG, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSysOUTypeRS pSSysOUTypeRS, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSOUTYPERS_PSSYSOUTYPE_CPSSYSOUTYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysOUTypeService", (SessionFactory)this.getSessionFactory());
            PSSysOUType pSSysOUType = (PSSysOUType)iService.getDEModel().createEntity();
            pSSysOUType.set("PSSYSOUTYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysOUType);
            } else {
                iService.get(pSSysOUType);
            }
            this.onFillParentInfo_CPSSysOUType(pSSysOUTypeRS, pSSysOUType);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSOUTYPERS_PSSYSOUTYPE_PPSSYSOUTYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysOUTypeService", (SessionFactory)this.getSessionFactory());
            PSSysOUType pSSysOUType = (PSSysOUType)iService.getDEModel().createEntity();
            pSSysOUType.set("PSSYSOUTYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysOUType);
            } else {
                iService.get(pSSysOUType);
            }
            this.onFillParentInfo_PPSSsysOUType(pSSysOUTypeRS, pSSysOUType);
            return;
        }
        super.onFillParentInfo(pSSysOUTypeRS, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_CPSSysOUType(PSSysOUTypeRS pSSysOUTypeRS, PSSysOUType pSSysOUType) throws Exception {
        pSSysOUTypeRS.setCPSSYSOUTypeID(pSSysOUType.getPSSysOUTypeId());
        pSSysOUTypeRS.setCPSSYSOUTypeName(pSSysOUType.getPSSysOUTypeName());
    }

    protected void onFillParentInfo_PPSSsysOUType(PSSysOUTypeRS pSSysOUTypeRS, PSSysOUType pSSysOUType) throws Exception {
        pSSysOUTypeRS.setPPSSysOUTypeId(pSSysOUType.getPSSysOUTypeId());
        pSSysOUTypeRS.setPPSSYSOUTypeName(pSSysOUType.getPSSysOUTypeName());
    }

    protected void onFillEntityFullInfo(PSSysOUTypeRS pSSysOUTypeRS, boolean bl) throws Exception {
        if (bl && pSSysOUTypeRS.getValidFlag() == null) {
            pSSysOUTypeRS.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSSysOUTypeRS, bl);
        this.onFillEntityFullInfo_CPSSysOUType(pSSysOUTypeRS, bl);
        this.onFillEntityFullInfo_PPSSsysOUType(pSSysOUTypeRS, bl);
    }

    protected void onFillEntityFullInfo_CPSSysOUType(PSSysOUTypeRS pSSysOUTypeRS, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PPSSsysOUType(PSSysOUTypeRS pSSysOUTypeRS, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysOUTypeRS pSSysOUTypeRS, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysOUTypeRS, bl);
    }

    public ArrayList<PSSysOUTypeRS> selectByCPSSysOUType(PSSysOUTypeBase pSSysOUTypeBase) throws Exception {
        return this.selectByCPSSysOUType(pSSysOUTypeBase, "", -1);
    }

    public ArrayList<PSSysOUTypeRS> selectByCPSSysOUType(PSSysOUTypeBase pSSysOUTypeBase, String string) throws Exception {
        return this.selectByCPSSysOUType(pSSysOUTypeBase, string, -1);
    }

    public ArrayList<PSSysOUTypeRS> selectByCPSSysOUType(PSSysOUTypeBase pSSysOUTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CPSSYSOUTYPEID", (Object)pSSysOUTypeBase.getPSSysOUTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByCPSSysOUTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByCPSSysOUTypeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysOUTypeRS> selectByPPSSsysOUType(PSSysOUTypeBase pSSysOUTypeBase) throws Exception {
        return this.selectByPPSSsysOUType(pSSysOUTypeBase, "", -1);
    }

    public ArrayList<PSSysOUTypeRS> selectByPPSSsysOUType(PSSysOUTypeBase pSSysOUTypeBase, String string) throws Exception {
        return this.selectByPPSSsysOUType(pSSysOUTypeBase, string, -1);
    }

    public ArrayList<PSSysOUTypeRS> selectByPPSSsysOUType(PSSysOUTypeBase pSSysOUTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSSYSOUTYPEID", (Object)pSSysOUTypeBase.getPSSysOUTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSSsysOUTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSSsysOUTypeCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByCPSSysOUType(PSSysOUType pSSysOUType) throws Exception {
        ArrayList<PSSysOUTypeRS> arrayList = this.selectByCPSSysOUType(pSSysOUType, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSOUTYPE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysOUType);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSOUTYPERS_PSSYSOUTYPE_CPSSYSOUTYPEID", "", iDataEntityModel.getName(), "PSSYSOUTYPERS", iDataEntityModel.getDataInfo(pSSysOUType), arrayList.get(0)));
        }
    }

    public void resetCPSSysOUType(PSSysOUType pSSysOUType) throws Exception {
        ArrayList<PSSysOUTypeRS> arrayList = this.selectByCPSSysOUType(pSSysOUType);
        for (PSSysOUTypeRS pSSysOUTypeRS : arrayList) {
            PSSysOUTypeRS pSSysOUTypeRS2 = (PSSysOUTypeRS)this.getDEModel().createEntity();
            pSSysOUTypeRS2.setPSSysOUTypeRSId(pSSysOUTypeRS.getPSSysOUTypeRSId());
            pSSysOUTypeRS2.setCPSSYSOUTypeID(null);
            this.update(pSSysOUTypeRS2);
        }
    }

    public void removeByCPSSysOUType(PSSysOUType pSSysOUType) throws Exception {
        final PSSysOUType pSSysOUType2 = pSSysOUType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysOUTypeRSServiceBase.this.onBeforeRemoveByCPSSysOUType(pSSysOUType2);
                PSSysOUTypeRSServiceBase.this.internalRemoveByCPSSysOUType(pSSysOUType2);
                PSSysOUTypeRSServiceBase.this.onAfterRemoveByCPSSysOUType(pSSysOUType2);
            }
        });
    }

    protected void onBeforeRemoveByCPSSysOUType(PSSysOUType pSSysOUType) throws Exception {
    }

    protected void internalRemoveByCPSSysOUType(PSSysOUType pSSysOUType) throws Exception {
        ArrayList<PSSysOUTypeRS> arrayList = this.selectByCPSSysOUType(pSSysOUType);
        this.onBeforeRemoveByCPSSysOUType(pSSysOUType, arrayList);
        for (PSSysOUTypeRS pSSysOUTypeRS : arrayList) {
            this.remove(pSSysOUTypeRS);
        }
        this.onAfterRemoveByCPSSysOUType(pSSysOUType, arrayList);
    }

    protected void onAfterRemoveByCPSSysOUType(PSSysOUType pSSysOUType) throws Exception {
    }

    protected void onBeforeRemoveByCPSSysOUType(PSSysOUType pSSysOUType, ArrayList<PSSysOUTypeRS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCPSSysOUType(PSSysOUType pSSysOUType, ArrayList<PSSysOUTypeRS> arrayList) throws Exception {
    }

    public void testRemoveByPPSSsysOUType(PSSysOUType pSSysOUType) throws Exception {
        ArrayList<PSSysOUTypeRS> arrayList = this.selectByPPSSsysOUType(pSSysOUType, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSOUTYPE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysOUType);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSOUTYPERS_PSSYSOUTYPE_PPSSYSOUTYPEID", "", iDataEntityModel.getName(), "PSSYSOUTYPERS", iDataEntityModel.getDataInfo(pSSysOUType), arrayList.get(0)));
        }
    }

    public void resetPPSSsysOUType(PSSysOUType pSSysOUType) throws Exception {
        ArrayList<PSSysOUTypeRS> arrayList = this.selectByPPSSsysOUType(pSSysOUType);
        for (PSSysOUTypeRS pSSysOUTypeRS : arrayList) {
            PSSysOUTypeRS pSSysOUTypeRS2 = (PSSysOUTypeRS)this.getDEModel().createEntity();
            pSSysOUTypeRS2.setPSSysOUTypeRSId(pSSysOUTypeRS.getPSSysOUTypeRSId());
            pSSysOUTypeRS2.setPPSSysOUTypeId(null);
            this.update(pSSysOUTypeRS2);
        }
    }

    public void removeByPPSSsysOUType(PSSysOUType pSSysOUType) throws Exception {
        final PSSysOUType pSSysOUType2 = pSSysOUType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysOUTypeRSServiceBase.this.onBeforeRemoveByPPSSsysOUType(pSSysOUType2);
                PSSysOUTypeRSServiceBase.this.internalRemoveByPPSSsysOUType(pSSysOUType2);
                PSSysOUTypeRSServiceBase.this.onAfterRemoveByPPSSsysOUType(pSSysOUType2);
            }
        });
    }

    protected void onBeforeRemoveByPPSSsysOUType(PSSysOUType pSSysOUType) throws Exception {
    }

    protected void internalRemoveByPPSSsysOUType(PSSysOUType pSSysOUType) throws Exception {
        ArrayList<PSSysOUTypeRS> arrayList = this.selectByPPSSsysOUType(pSSysOUType);
        this.onBeforeRemoveByPPSSsysOUType(pSSysOUType, arrayList);
        for (PSSysOUTypeRS pSSysOUTypeRS : arrayList) {
            this.remove(pSSysOUTypeRS);
        }
        this.onAfterRemoveByPPSSsysOUType(pSSysOUType, arrayList);
    }

    protected void onAfterRemoveByPPSSsysOUType(PSSysOUType pSSysOUType) throws Exception {
    }

    protected void onBeforeRemoveByPPSSsysOUType(PSSysOUType pSSysOUType, ArrayList<PSSysOUTypeRS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSSsysOUType(PSSysOUType pSSysOUType, ArrayList<PSSysOUTypeRS> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysOUTypeRS pSSysOUTypeRS) throws Exception {
        super.onBeforeRemove(pSSysOUTypeRS);
    }

    protected void replaceParentInfo(PSSysOUTypeRS pSSysOUTypeRS, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysOUTypeRS, cloneSession);
        if (pSSysOUTypeRS.getCPSSYSOUTypeID() != null && (iEntity = cloneSession.getEntity("PSSYSOUTYPE", (Object)pSSysOUTypeRS.getCPSSYSOUTypeID())) != null) {
            this.onFillParentInfo_CPSSysOUType(pSSysOUTypeRS, (PSSysOUType)iEntity);
        }
        if (pSSysOUTypeRS.getPPSSysOUTypeId() != null && (iEntity = cloneSession.getEntity("PSSYSOUTYPE", (Object)pSSysOUTypeRS.getPPSSysOUTypeId())) != null) {
            this.onFillParentInfo_PPSSsysOUType(pSSysOUTypeRS, (PSSysOUType)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysOUTypeRS pSSysOUTypeRS, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysOUTypeRS, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysOUTypeRS pSSysOUTypeRS, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CPSSYSOUTypeID(bl, pSSysOUTypeRS, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysOUTypeRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSSysOUTypeId(bl, pSSysOUTypeRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysOUTypeRSId(bl, pSSysOUTypeRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysOUTypeRSName(bl, pSSysOUTypeRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysOUTypeRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysOUTypeRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysOUTypeRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysOUTypeRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysOUTypeRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysOUTypeRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysOUTypeRS, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CPSSYSOUTypeID(boolean bl, PSSysOUTypeRS pSSysOUTypeRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysOUTypeRS.isCPSSYSOUTypeIDDirty() : !pSSysOUTypeRS.isCPSSYSOUTypeIDDirty()) {
            return null;
        }
        String string = pSSysOUTypeRS.getCPSSYSOUTypeID();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CPSSYSOUTypeID_Default(pSSysOUTypeRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CPSSYSOUTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysOUTypeRS pSSysOUTypeRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysOUTypeRS.isOrderValueDirty() : !pSSysOUTypeRS.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysOUTypeRS.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSSysOUTypeRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_PPSSysOUTypeId(boolean bl, PSSysOUTypeRS pSSysOUTypeRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysOUTypeRS.isPPSSysOUTypeIdDirty() : !pSSysOUTypeRS.isPPSSysOUTypeIdDirty()) {
            return null;
        }
        String string = pSSysOUTypeRS.getPPSSysOUTypeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSSysOUTypeId_Default(pSSysOUTypeRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSSYSOUTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysOUTypeRSId(boolean bl, PSSysOUTypeRS pSSysOUTypeRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysOUTypeRS.isPSSysOUTypeRSIdDirty() && !bl2 : !pSSysOUTypeRS.isPSSysOUTypeRSIdDirty()) {
            return null;
        }
        String string = pSSysOUTypeRS.getPSSysOUTypeRSId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSOUTYPERSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysOUTypeRSId_Default(pSSysOUTypeRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSOUTYPERSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysOUTypeRSName(boolean bl, PSSysOUTypeRS pSSysOUTypeRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysOUTypeRS.isPSSysOUTypeRSNameDirty() && !bl2 : !pSSysOUTypeRS.isPSSysOUTypeRSNameDirty()) {
            return null;
        }
        String string = pSSysOUTypeRS.getPSSysOUTypeRSName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSOUTYPERSNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysOUTypeRSName_Default(pSSysOUTypeRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSOUTYPERSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysOUTypeRS pSSysOUTypeRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysOUTypeRS.isUserCatDirty() : !pSSysOUTypeRS.isUserCatDirty()) {
            return null;
        }
        String string = pSSysOUTypeRS.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysOUTypeRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERCAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysOUTypeRS pSSysOUTypeRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysOUTypeRS.isUserTagDirty() : !pSSysOUTypeRS.isUserTagDirty()) {
            return null;
        }
        String string = pSSysOUTypeRS.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysOUTypeRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysOUTypeRS pSSysOUTypeRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysOUTypeRS.isUserTag2Dirty() : !pSSysOUTypeRS.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysOUTypeRS.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysOUTypeRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysOUTypeRS pSSysOUTypeRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysOUTypeRS.isUserTag3Dirty() : !pSSysOUTypeRS.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysOUTypeRS.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysOUTypeRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysOUTypeRS pSSysOUTypeRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysOUTypeRS.isUserTag4Dirty() : !pSSysOUTypeRS.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysOUTypeRS.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysOUTypeRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysOUTypeRS pSSysOUTypeRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysOUTypeRS.isValidFlagDirty() && !bl2 : !pSSysOUTypeRS.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysOUTypeRS.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSysOUTypeRS, bl2, bl3);
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

    protected void onSyncEntity(PSSysOUTypeRS pSSysOUTypeRS, boolean bl) throws Exception {
        super.onSyncEntity(pSSysOUTypeRS, bl);
    }

    protected void onSyncIndexEntities(PSSysOUTypeRS pSSysOUTypeRS, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysOUTypeRS, bl);
    }

    public Object getDataContextValue(PSSysOUTypeRS pSSysOUTypeRS, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysOUTypeRS, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysOUTypeRS pSSysOUTypeRS, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysOUTypeRS, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CPSSYSOUTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CPSSYSOUTypeID_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CPSSYSOUTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CPSSYSOUTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSSYSOUTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSSysOUTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSSYSOUTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSSYSOUTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSOUTYPERSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysOUTypeRSId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSOUTYPERSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysOUTypeRSName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERCAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserCat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CPSSYSOUTypeID_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CPSSYSOUTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CPSSYSOUTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CPSSYSOUTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PPSSysOUTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSSYSOUTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false) && this.checkFieldRecursionRule("PPSSYSOUTYPEID", "PSSYSOUTYPERS", iEntity, bl2, "")) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSSYSOUTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSSYSOUTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysOUTypeRSId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSOUTYPERSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysOUTypeRSName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSOUTYPERSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_UserCat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERCAT", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG3", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG4", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSSysOUTypeRS pSSysOUTypeRS) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysOUTypeRS)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysOUTypeRS pSSysOUTypeRS) throws Exception {
        super.onUpdateParent(pSSysOUTypeRS);
    }

    @Override
    protected void exportCurXmlModel(PSSysOUTypeRS pSSysOUTypeRS, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSOUTYPERS");
        if (!bl) {
            pSSysOUTypeRS.setCPSSYSOUTypeName(null);
            pSSysOUTypeRS.setPPSSYSOUTypeName(null);
            super.exportCurXmlModel(pSSysOUTypeRS, xmlNode, bl);
        }
    }
}

