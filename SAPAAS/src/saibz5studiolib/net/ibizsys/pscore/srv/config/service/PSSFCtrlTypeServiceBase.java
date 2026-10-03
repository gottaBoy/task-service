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
package net.ibizsys.pscore.srv.config.service;

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
import net.ibizsys.pscore.srv.config.dao.PSSFCtrlTypeDAO;
import net.ibizsys.pscore.srv.config.demodel.PSSFCtrlTypeDEModel;
import net.ibizsys.pscore.srv.config.entity.PSCtrlType;
import net.ibizsys.pscore.srv.config.entity.PSCtrlTypeBase;
import net.ibizsys.pscore.srv.config.entity.PSSF;
import net.ibizsys.pscore.srv.config.entity.PSSFBase;
import net.ibizsys.pscore.srv.config.entity.PSSFCtrlType;
import net.ibizsys.pscore.srv.config.entity.PSSFStyle;
import net.ibizsys.pscore.srv.config.entity.PSSFStyleBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFCtrlTypeServiceBase
extends PSCoreSysServiceBase<PSSFCtrlType> {
    private static final Log log = LogFactory.getLog(PSSFCtrlTypeServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSFCtrlTypeDEModel pSSFCtrlTypeDEModel;
    private PSSFCtrlTypeDAO pSSFCtrlTypeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSSFCtrlTypeService";
    }

    public PSSFCtrlTypeDEModel getPSSFCtrlTypeDEModel() {
        if (this.pSSFCtrlTypeDEModel == null) {
            try {
                this.pSSFCtrlTypeDEModel = (PSSFCtrlTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSFCtrlTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFCtrlTypeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSFCtrlTypeDEModel();
    }

    public PSSFCtrlTypeDAO getPSSFCtrlTypeDAO() {
        if (this.pSSFCtrlTypeDAO == null) {
            try {
                this.pSSFCtrlTypeDAO = (PSSFCtrlTypeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSSFCtrlTypeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFCtrlTypeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSFCtrlTypeDAO();
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

    protected void onFillParentInfo(PSSFCtrlType pSSFCtrlType, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSFCTRLTYPE_PSCTRLTYPE_PSCTRLTYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSCtrlTypeService", (SessionFactory)this.getSessionFactory());
            PSCtrlType pSCtrlType = (PSCtrlType)iService.getDEModel().createEntity();
            pSCtrlType.set("PSCTRLTYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCtrlType);
            } else {
                iService.get(pSCtrlType);
            }
            this.onFillParentInfo_PSCtrlType(pSSFCtrlType, pSCtrlType);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSFCTRLTYPE_PSSFSTYLE_PSSFSTYLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFStyleService", (SessionFactory)this.getSessionFactory());
            PSSFStyle pSSFStyle = (PSSFStyle)iService.getDEModel().createEntity();
            pSSFStyle.set("PSSFSTYLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSFStyle);
            } else {
                iService.get(pSSFStyle);
            }
            this.onFillParentInfo_PSSFStyle(pSSFCtrlType, pSSFStyle);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSFCTRLTYPE_PSSF_PSSFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFService", (SessionFactory)this.getSessionFactory());
            PSSF pSSF = (PSSF)iService.getDEModel().createEntity();
            pSSF.set("PSSFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSF);
            } else {
                iService.get(pSSF);
            }
            this.onFillParentInfo_PSSF(pSSFCtrlType, pSSF);
            return;
        }
        super.onFillParentInfo(pSSFCtrlType, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSCtrlType(PSSFCtrlType pSSFCtrlType, PSCtrlType pSCtrlType) throws Exception {
        pSSFCtrlType.setPSCtrlTypeId(pSCtrlType.getPSCtrlTypeId());
        pSSFCtrlType.setPSCtrlTypeName(pSCtrlType.getPSCtrlTypeName());
    }

    protected void onFillParentInfo_PSSFStyle(PSSFCtrlType pSSFCtrlType, PSSFStyle pSSFStyle) throws Exception {
        pSSFCtrlType.setPSSFStyleId(pSSFStyle.getPSSFStyleId());
        pSSFCtrlType.setPSSFStyleName(pSSFStyle.getPSSFStyleName());
    }

    protected void onFillParentInfo_PSSF(PSSFCtrlType pSSFCtrlType, PSSF pSSF) throws Exception {
        pSSFCtrlType.setPSSFId(pSSF.getPSSFId());
        pSSFCtrlType.setPSSFName(pSSF.getPSSFName());
    }

    protected void onFillEntityFullInfo(PSSFCtrlType pSSFCtrlType, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSSFCtrlType, bl);
        this.onFillEntityFullInfo_PSCtrlType(pSSFCtrlType, bl);
        this.onFillEntityFullInfo_PSSFStyle(pSSFCtrlType, bl);
        this.onFillEntityFullInfo_PSSF(pSSFCtrlType, bl);
    }

    protected void onFillEntityFullInfo_PSCtrlType(PSSFCtrlType pSSFCtrlType, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSFStyle(PSSFCtrlType pSSFCtrlType, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSF(PSSFCtrlType pSSFCtrlType, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSFCtrlType pSSFCtrlType, boolean bl) throws Exception {
        super.onWriteBackParent(pSSFCtrlType, bl);
    }

    public ArrayList<PSSFCtrlType> selectByPSCtrlType(PSCtrlTypeBase pSCtrlTypeBase) throws Exception {
        return this.selectByPSCtrlType(pSCtrlTypeBase, "", -1);
    }

    public ArrayList<PSSFCtrlType> selectByPSCtrlType(PSCtrlTypeBase pSCtrlTypeBase, String string) throws Exception {
        return this.selectByPSCtrlType(pSCtrlTypeBase, string, -1);
    }

    public ArrayList<PSSFCtrlType> selectByPSCtrlType(PSCtrlTypeBase pSCtrlTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCTRLTYPEID", (Object)pSCtrlTypeBase.getPSCtrlTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCtrlTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCtrlTypeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSFCtrlType> selectByPSSFStyle(PSSFStyleBase pSSFStyleBase) throws Exception {
        return this.selectByPSSFStyle(pSSFStyleBase, "", -1);
    }

    public ArrayList<PSSFCtrlType> selectByPSSFStyle(PSSFStyleBase pSSFStyleBase, String string) throws Exception {
        return this.selectByPSSFStyle(pSSFStyleBase, string, -1);
    }

    public ArrayList<PSSFCtrlType> selectByPSSFStyle(PSSFStyleBase pSSFStyleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSFSTYLEID", (Object)pSSFStyleBase.getPSSFStyleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSFStyleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSFStyleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSFCtrlType> selectByPSSF(PSSFBase pSSFBase) throws Exception {
        return this.selectByPSSF(pSSFBase, "", -1);
    }

    public ArrayList<PSSFCtrlType> selectByPSSF(PSSFBase pSSFBase, String string) throws Exception {
        return this.selectByPSSF(pSSFBase, string, -1);
    }

    public ArrayList<PSSFCtrlType> selectByPSSF(PSSFBase pSSFBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSFID", (Object)pSSFBase.getPSSFId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSFCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSCtrlType(PSCtrlType pSCtrlType) throws Exception {
        ArrayList<PSSFCtrlType> arrayList = this.selectByPSCtrlType(pSCtrlType, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCTRLTYPE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCtrlType);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSFCTRLTYPE_PSCTRLTYPE_PSCTRLTYPEID", "", iDataEntityModel.getName(), "PSSFCTRLTYPE", iDataEntityModel.getDataInfo(pSCtrlType), arrayList.get(0)));
        }
    }

    public void resetPSCtrlType(PSCtrlType pSCtrlType) throws Exception {
        ArrayList<PSSFCtrlType> arrayList = this.selectByPSCtrlType(pSCtrlType);
        for (PSSFCtrlType pSSFCtrlType : arrayList) {
            PSSFCtrlType pSSFCtrlType2 = (PSSFCtrlType)this.getDEModel().createEntity();
            pSSFCtrlType2.setPSSFCtrlTypeId(pSSFCtrlType.getPSSFCtrlTypeId());
            pSSFCtrlType2.setPSCtrlTypeId(null);
            this.update(pSSFCtrlType2);
        }
    }

    public void removeByPSCtrlType(PSCtrlType pSCtrlType) throws Exception {
        final PSCtrlType pSCtrlType2 = pSCtrlType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSFCtrlTypeServiceBase.this.onBeforeRemoveByPSCtrlType(pSCtrlType2);
                PSSFCtrlTypeServiceBase.this.internalRemoveByPSCtrlType(pSCtrlType2);
                PSSFCtrlTypeServiceBase.this.onAfterRemoveByPSCtrlType(pSCtrlType2);
            }
        });
    }

    protected void onBeforeRemoveByPSCtrlType(PSCtrlType pSCtrlType) throws Exception {
    }

    protected void internalRemoveByPSCtrlType(PSCtrlType pSCtrlType) throws Exception {
        ArrayList<PSSFCtrlType> arrayList = this.selectByPSCtrlType(pSCtrlType);
        this.onBeforeRemoveByPSCtrlType(pSCtrlType, arrayList);
        for (PSSFCtrlType pSSFCtrlType : arrayList) {
            this.remove(pSSFCtrlType);
        }
        this.onAfterRemoveByPSCtrlType(pSCtrlType, arrayList);
    }

    protected void onAfterRemoveByPSCtrlType(PSCtrlType pSCtrlType) throws Exception {
    }

    protected void onBeforeRemoveByPSCtrlType(PSCtrlType pSCtrlType, ArrayList<PSSFCtrlType> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCtrlType(PSCtrlType pSCtrlType, ArrayList<PSSFCtrlType> arrayList) throws Exception {
    }

    public void testRemoveByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        ArrayList<PSSFCtrlType> arrayList = this.selectByPSSFStyle(pSSFStyle, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSFSTYLE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSFStyle);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSFCTRLTYPE_PSSFSTYLE_PSSFSTYLEID", "", iDataEntityModel.getName(), "PSSFCTRLTYPE", iDataEntityModel.getDataInfo(pSSFStyle), arrayList.get(0)));
        }
    }

    public void resetPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        ArrayList<PSSFCtrlType> arrayList = this.selectByPSSFStyle(pSSFStyle);
        for (PSSFCtrlType pSSFCtrlType : arrayList) {
            PSSFCtrlType pSSFCtrlType2 = (PSSFCtrlType)this.getDEModel().createEntity();
            pSSFCtrlType2.setPSSFCtrlTypeId(pSSFCtrlType.getPSSFCtrlTypeId());
            pSSFCtrlType2.setPSSFStyleId(null);
            this.update(pSSFCtrlType2);
        }
    }

    public void removeByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        final PSSFStyle pSSFStyle2 = pSSFStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSFCtrlTypeServiceBase.this.onBeforeRemoveByPSSFStyle(pSSFStyle2);
                PSSFCtrlTypeServiceBase.this.internalRemoveByPSSFStyle(pSSFStyle2);
                PSSFCtrlTypeServiceBase.this.onAfterRemoveByPSSFStyle(pSSFStyle2);
            }
        });
    }

    protected void onBeforeRemoveByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
    }

    protected void internalRemoveByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        ArrayList<PSSFCtrlType> arrayList = this.selectByPSSFStyle(pSSFStyle);
        this.onBeforeRemoveByPSSFStyle(pSSFStyle, arrayList);
        for (PSSFCtrlType pSSFCtrlType : arrayList) {
            this.remove(pSSFCtrlType);
        }
        this.onAfterRemoveByPSSFStyle(pSSFStyle, arrayList);
    }

    protected void onAfterRemoveByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
    }

    protected void onBeforeRemoveByPSSFStyle(PSSFStyle pSSFStyle, ArrayList<PSSFCtrlType> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSFStyle(PSSFStyle pSSFStyle, ArrayList<PSSFCtrlType> arrayList) throws Exception {
    }

    public void testRemoveByPSSF(PSSF pSSF) throws Exception {
        ArrayList<PSSFCtrlType> arrayList = this.selectByPSSF(pSSF, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSF");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSF);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSFCTRLTYPE_PSSF_PSSFID", "", iDataEntityModel.getName(), "PSSFCTRLTYPE", iDataEntityModel.getDataInfo(pSSF), arrayList.get(0)));
        }
    }

    public void resetPSSF(PSSF pSSF) throws Exception {
        ArrayList<PSSFCtrlType> arrayList = this.selectByPSSF(pSSF);
        for (PSSFCtrlType pSSFCtrlType : arrayList) {
            PSSFCtrlType pSSFCtrlType2 = (PSSFCtrlType)this.getDEModel().createEntity();
            pSSFCtrlType2.setPSSFCtrlTypeId(pSSFCtrlType.getPSSFCtrlTypeId());
            pSSFCtrlType2.setPSSFId(null);
            this.update(pSSFCtrlType2);
        }
    }

    public void removeByPSSF(PSSF pSSF) throws Exception {
        final PSSF pSSF2 = pSSF;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSFCtrlTypeServiceBase.this.onBeforeRemoveByPSSF(pSSF2);
                PSSFCtrlTypeServiceBase.this.internalRemoveByPSSF(pSSF2);
                PSSFCtrlTypeServiceBase.this.onAfterRemoveByPSSF(pSSF2);
            }
        });
    }

    protected void onBeforeRemoveByPSSF(PSSF pSSF) throws Exception {
    }

    protected void internalRemoveByPSSF(PSSF pSSF) throws Exception {
        ArrayList<PSSFCtrlType> arrayList = this.selectByPSSF(pSSF);
        this.onBeforeRemoveByPSSF(pSSF, arrayList);
        for (PSSFCtrlType pSSFCtrlType : arrayList) {
            this.remove(pSSFCtrlType);
        }
        this.onAfterRemoveByPSSF(pSSF, arrayList);
    }

    protected void onAfterRemoveByPSSF(PSSF pSSF) throws Exception {
    }

    protected void onBeforeRemoveByPSSF(PSSF pSSF, ArrayList<PSSFCtrlType> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSF(PSSF pSSF, ArrayList<PSSFCtrlType> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSFCtrlType pSSFCtrlType) throws Exception {
        super.onBeforeRemove(pSSFCtrlType);
    }

    protected void replaceParentInfo(PSSFCtrlType pSSFCtrlType, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSFCtrlType, cloneSession);
        if (pSSFCtrlType.getPSCtrlTypeId() != null && (iEntity = cloneSession.getEntity("PSCTRLTYPE", (Object)pSSFCtrlType.getPSCtrlTypeId())) != null) {
            this.onFillParentInfo_PSCtrlType(pSSFCtrlType, (PSCtrlType)iEntity);
        }
        if (pSSFCtrlType.getPSSFStyleId() != null && (iEntity = cloneSession.getEntity("PSSFSTYLE", (Object)pSSFCtrlType.getPSSFStyleId())) != null) {
            this.onFillParentInfo_PSSFStyle(pSSFCtrlType, (PSSFStyle)iEntity);
        }
        if (pSSFCtrlType.getPSSFId() != null && (iEntity = cloneSession.getEntity("PSSF", (Object)pSSFCtrlType.getPSSFId())) != null) {
            this.onFillParentInfo_PSSF(pSSFCtrlType, (PSSF)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSFCtrlType pSSFCtrlType, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSFCtrlType, bl);
    }

    protected void onCheckEntity(boolean bl, PSSFCtrlType pSSFCtrlType, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CtrlDesc(bl, pSSFCtrlType, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HandlerClass(bl, pSSFCtrlType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSFCtrlType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelClass(bl, pSSFCtrlType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlTypeId(bl, pSSFCtrlType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFCtrlTypeId(bl, pSSFCtrlType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFCtrlTypeName(bl, pSSFCtrlType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFId(bl, pSSFCtrlType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFStyleId(bl, pSSFCtrlType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSFCtrlType, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CtrlDesc(boolean bl, PSSFCtrlType pSSFCtrlType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCtrlType.isCtrlDescDirty() : !pSSFCtrlType.isCtrlDescDirty()) {
            return null;
        }
        String string = pSSFCtrlType.getCtrlDesc();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CtrlDesc_Default(pSSFCtrlType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLDESC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HandlerClass(boolean bl, PSSFCtrlType pSSFCtrlType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCtrlType.isHandlerClassDirty() : !pSSFCtrlType.isHandlerClassDirty()) {
            return null;
        }
        String string = pSSFCtrlType.getHandlerClass();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HandlerClass_Default(pSSFCtrlType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HANDLERCLASS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSFCtrlType pSSFCtrlType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCtrlType.isMemoDirty() : !pSSFCtrlType.isMemoDirty()) {
            return null;
        }
        String string = pSSFCtrlType.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSFCtrlType, bl2, bl3);
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

    protected EntityFieldError onCheckField_ModelClass(boolean bl, PSSFCtrlType pSSFCtrlType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCtrlType.isModelClassDirty() : !pSSFCtrlType.isModelClassDirty()) {
            return null;
        }
        String string = pSSFCtrlType.getModelClass();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModelClass_Default(pSSFCtrlType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODELCLASS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCtrlTypeId(boolean bl, PSSFCtrlType pSSFCtrlType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCtrlType.isPSCtrlTypeIdDirty() : !pSSFCtrlType.isPSCtrlTypeIdDirty()) {
            return null;
        }
        String string = pSSFCtrlType.getPSCtrlTypeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlTypeId_Default(pSSFCtrlType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFCtrlTypeId(boolean bl, PSSFCtrlType pSSFCtrlType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCtrlType.isPSSFCtrlTypeIdDirty() && !bl2 : !pSSFCtrlType.isPSSFCtrlTypeIdDirty()) {
            return null;
        }
        String string = pSSFCtrlType.getPSSFCtrlTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFCTRLTYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFCtrlTypeId_Default(pSSFCtrlType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFCTRLTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFCtrlTypeName(boolean bl, PSSFCtrlType pSSFCtrlType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCtrlType.isPSSFCtrlTypeNameDirty() && !bl2 : !pSSFCtrlType.isPSSFCtrlTypeNameDirty()) {
            return null;
        }
        String string = pSSFCtrlType.getPSSFCtrlTypeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFCTRLTYPENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFCtrlTypeName_Default(pSSFCtrlType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFCTRLTYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFId(boolean bl, PSSFCtrlType pSSFCtrlType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCtrlType.isPSSFIdDirty() : !pSSFCtrlType.isPSSFIdDirty()) {
            return null;
        }
        String string = pSSFCtrlType.getPSSFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFId_Default(pSSFCtrlType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFStyleId(boolean bl, PSSFCtrlType pSSFCtrlType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCtrlType.isPSSFStyleIdDirty() : !pSSFCtrlType.isPSSFStyleIdDirty()) {
            return null;
        }
        String string = pSSFCtrlType.getPSSFStyleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFStyleId_Default(pSSFCtrlType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFSTYLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSFCtrlType pSSFCtrlType, boolean bl) throws Exception {
        super.onSyncEntity(pSSFCtrlType, bl);
    }

    protected void onSyncIndexEntities(PSSFCtrlType pSSFCtrlType, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSFCtrlType, bl);
    }

    public Object getDataContextValue(PSSFCtrlType pSSFCtrlType, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSFCtrlType, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSFCtrlType pSSFCtrlType, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSFCtrlType, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLDESC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlDesc_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HANDLERCLASS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HandlerClass_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELCLASS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelClass_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFCTRLTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFCtrlTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFCTRLTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFCtrlTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFSTYLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFStyleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFSTYLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFStyleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_CtrlDesc_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CTRLDESC", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HandlerClass_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HANDLERCLASS", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
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

    protected String onTestValueRule_ModelClass_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODELCLASS", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCtrlTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCtrlTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFCtrlTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFCTRLTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFCtrlTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFCTRLTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFStyleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFSTYLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFStyleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFSTYLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSFCtrlType pSSFCtrlType) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSFCtrlType)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSFCtrlType pSSFCtrlType) throws Exception {
        super.onUpdateParent(pSSFCtrlType);
    }

    @Override
    protected void exportCurXmlModel(PSSFCtrlType pSSFCtrlType, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSFCTRLTYPE");
        if (!bl) {
            pSSFCtrlType.setCreateDate(null);
            pSSFCtrlType.setCreateMan(null);
            pSSFCtrlType.setPSCtrlTypeName(null);
            pSSFCtrlType.setPSSFCtrlTypeId(null);
            pSSFCtrlType.setPSSFName(null);
            pSSFCtrlType.setPSSFStyleName(null);
            pSSFCtrlType.setUpdateDate(null);
            pSSFCtrlType.setUpdateMan(null);
            super.exportCurXmlModel(pSSFCtrlType, xmlNode, bl);
        }
    }
}

