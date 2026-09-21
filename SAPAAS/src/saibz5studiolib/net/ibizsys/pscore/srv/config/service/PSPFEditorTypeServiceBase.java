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
import net.ibizsys.pscore.srv.config.dao.PSPFEditorTypeDAO;
import net.ibizsys.pscore.srv.config.demodel.PSPFEditorTypeDEModel;
import net.ibizsys.pscore.srv.config.entity.PSEditorType;
import net.ibizsys.pscore.srv.config.entity.PSEditorTypeBase;
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFBase;
import net.ibizsys.pscore.srv.config.entity.PSPFEditorType;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.entity.PSPFStyleBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFEditorTypeServiceBase
extends PSCoreSysServiceBase<PSPFEditorType> {
    private static final Log log = LogFactory.getLog(PSPFEditorTypeServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSPFEditorTypeDEModel pSPFEditorTypeDEModel;
    private PSPFEditorTypeDAO pSPFEditorTypeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSPFEditorTypeService";
    }

    public PSPFEditorTypeDEModel getPSPFEditorTypeDEModel() {
        if (this.pSPFEditorTypeDEModel == null) {
            try {
                this.pSPFEditorTypeDEModel = (PSPFEditorTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSPFEditorTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFEditorTypeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSPFEditorTypeDEModel();
    }

    public PSPFEditorTypeDAO getPSPFEditorTypeDAO() {
        if (this.pSPFEditorTypeDAO == null) {
            try {
                this.pSPFEditorTypeDAO = (PSPFEditorTypeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSPFEditorTypeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFEditorTypeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSPFEditorTypeDAO();
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

    protected void onFillParentInfo(PSPFEditorType pSPFEditorType, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFEDITORTYPE_PSEDITORTYPE_PSEDITORTYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSEditorTypeService", (SessionFactory)this.getSessionFactory());
            PSEditorType pSEditorType = (PSEditorType)iService.getDEModel().createEntity();
            pSEditorType.set("PSEDITORTYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSEditorType);
            } else {
                iService.get((IEntity)pSEditorType);
            }
            this.onFillParentInfo_PSEditorType(pSPFEditorType, pSEditorType);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFEDITORTYPE_PSPFSTYLE_PSPFSTYLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFStyleService", (SessionFactory)this.getSessionFactory());
            PSPFStyle pSPFStyle = (PSPFStyle)iService.getDEModel().createEntity();
            pSPFStyle.set("PSPFSTYLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSPFStyle);
            } else {
                iService.get((IEntity)pSPFStyle);
            }
            this.onFillParentInfo_PSPFStyle(pSPFEditorType, pSPFStyle);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFEDITORTYPE_PSPF_PSPFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFService", (SessionFactory)this.getSessionFactory());
            PSPF pSPF = (PSPF)iService.getDEModel().createEntity();
            pSPF.set("PSPFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSPF);
            } else {
                iService.get((IEntity)pSPF);
            }
            this.onFillParentInfo_PSPF(pSPFEditorType, pSPF);
            return;
        }
        super.onFillParentInfo((IEntity)pSPFEditorType, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSEditorType(PSPFEditorType pSPFEditorType, PSEditorType pSEditorType) throws Exception {
        pSPFEditorType.setPSEditorTypeId(pSEditorType.getPSEditorTypeId());
        pSPFEditorType.setPSEditorTypeName(pSEditorType.getPSEditorTypeName());
    }

    protected void onFillParentInfo_PSPFStyle(PSPFEditorType pSPFEditorType, PSPFStyle pSPFStyle) throws Exception {
        pSPFEditorType.setPSPFStyleId(pSPFStyle.getPSPFStyleId());
        pSPFEditorType.setPSPFStyleName(pSPFStyle.getPSPFStyleName());
    }

    protected void onFillParentInfo_PSPF(PSPFEditorType pSPFEditorType, PSPF pSPF) throws Exception {
        pSPFEditorType.setPSPFId(pSPF.getPSPFId());
        pSPFEditorType.setPSPFName(pSPF.getPSPFName());
    }

    protected void onFillEntityFullInfo(PSPFEditorType pSPFEditorType, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSPFEditorType, bl);
        this.onFillEntityFullInfo_PSEditorType(pSPFEditorType, bl);
        this.onFillEntityFullInfo_PSPFStyle(pSPFEditorType, bl);
        this.onFillEntityFullInfo_PSPF(pSPFEditorType, bl);
    }

    protected void onFillEntityFullInfo_PSEditorType(PSPFEditorType pSPFEditorType, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSPFStyle(PSPFEditorType pSPFEditorType, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSPF(PSPFEditorType pSPFEditorType, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSPFEditorType pSPFEditorType, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSPFEditorType, bl);
    }

    public ArrayList<PSPFEditorType> selectByPSEditorType(PSEditorTypeBase pSEditorTypeBase) throws Exception {
        return this.selectByPSEditorType(pSEditorTypeBase, "", -1);
    }

    public ArrayList<PSPFEditorType> selectByPSEditorType(PSEditorTypeBase pSEditorTypeBase, String string) throws Exception {
        return this.selectByPSEditorType(pSEditorTypeBase, string, -1);
    }

    public ArrayList<PSPFEditorType> selectByPSEditorType(PSEditorTypeBase pSEditorTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSEDITORTYPEID", (Object)pSEditorTypeBase.getPSEditorTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSEditorTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSEditorTypeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPFEditorType> selectByPSPFStyle(PSPFStyleBase pSPFStyleBase) throws Exception {
        return this.selectByPSPFStyle(pSPFStyleBase, "", -1);
    }

    public ArrayList<PSPFEditorType> selectByPSPFStyle(PSPFStyleBase pSPFStyleBase, String string) throws Exception {
        return this.selectByPSPFStyle(pSPFStyleBase, string, -1);
    }

    public ArrayList<PSPFEditorType> selectByPSPFStyle(PSPFStyleBase pSPFStyleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPFSTYLEID", (Object)pSPFStyleBase.getPSPFStyleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSPFStyleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSPFStyleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPFEditorType> selectByPSPF(PSPFBase pSPFBase) throws Exception {
        return this.selectByPSPF(pSPFBase, "", -1);
    }

    public ArrayList<PSPFEditorType> selectByPSPF(PSPFBase pSPFBase, String string) throws Exception {
        return this.selectByPSPF(pSPFBase, string, -1);
    }

    public ArrayList<PSPFEditorType> selectByPSPF(PSPFBase pSPFBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPFID", (Object)pSPFBase.getPSPFId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSPFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSPFCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSEditorType(PSEditorType pSEditorType) throws Exception {
        ArrayList<PSPFEditorType> arrayList = this.selectByPSEditorType(pSEditorType, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSEDITORTYPE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSEditorType);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPFEDITORTYPE_PSEDITORTYPE_PSEDITORTYPEID", "", iDataEntityModel.getName(), "PSPFEDITORTYPE", iDataEntityModel.getDataInfo((IEntity)pSEditorType), arrayList.get(0)));
        }
    }

    public void resetPSEditorType(PSEditorType pSEditorType) throws Exception {
        ArrayList<PSPFEditorType> arrayList = this.selectByPSEditorType(pSEditorType);
        for (PSPFEditorType pSPFEditorType : arrayList) {
            PSPFEditorType pSPFEditorType2 = (PSPFEditorType)this.getDEModel().createEntity();
            pSPFEditorType2.setPSPFEditorTypeId(pSPFEditorType.getPSPFEditorTypeId());
            pSPFEditorType2.setPSEditorTypeId(null);
            this.update(pSPFEditorType2);
        }
    }

    public void removeByPSEditorType(PSEditorType pSEditorType) throws Exception {
        final PSEditorType pSEditorType2 = pSEditorType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFEditorTypeServiceBase.this.onBeforeRemoveByPSEditorType(pSEditorType2);
                PSPFEditorTypeServiceBase.this.internalRemoveByPSEditorType(pSEditorType2);
                PSPFEditorTypeServiceBase.this.onAfterRemoveByPSEditorType(pSEditorType2);
            }
        });
    }

    protected void onBeforeRemoveByPSEditorType(PSEditorType pSEditorType) throws Exception {
    }

    protected void internalRemoveByPSEditorType(PSEditorType pSEditorType) throws Exception {
        ArrayList<PSPFEditorType> arrayList = this.selectByPSEditorType(pSEditorType);
        this.onBeforeRemoveByPSEditorType(pSEditorType, arrayList);
        for (PSPFEditorType pSPFEditorType : arrayList) {
            this.remove((IEntity)pSPFEditorType);
        }
        this.onAfterRemoveByPSEditorType(pSEditorType, arrayList);
    }

    protected void onAfterRemoveByPSEditorType(PSEditorType pSEditorType) throws Exception {
    }

    protected void onBeforeRemoveByPSEditorType(PSEditorType pSEditorType, ArrayList<PSPFEditorType> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSEditorType(PSEditorType pSEditorType, ArrayList<PSPFEditorType> arrayList) throws Exception {
    }

    public void testRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        ArrayList<PSPFEditorType> arrayList = this.selectByPSPFStyle(pSPFStyle, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPFSTYLE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSPFStyle);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPFEDITORTYPE_PSPFSTYLE_PSPFSTYLEID", "", iDataEntityModel.getName(), "PSPFEDITORTYPE", iDataEntityModel.getDataInfo((IEntity)pSPFStyle), arrayList.get(0)));
        }
    }

    public void resetPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        ArrayList<PSPFEditorType> arrayList = this.selectByPSPFStyle(pSPFStyle);
        for (PSPFEditorType pSPFEditorType : arrayList) {
            PSPFEditorType pSPFEditorType2 = (PSPFEditorType)this.getDEModel().createEntity();
            pSPFEditorType2.setPSPFEditorTypeId(pSPFEditorType.getPSPFEditorTypeId());
            pSPFEditorType2.setPSPFStyleId(null);
            this.update(pSPFEditorType2);
        }
    }

    public void removeByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        final PSPFStyle pSPFStyle2 = pSPFStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFEditorTypeServiceBase.this.onBeforeRemoveByPSPFStyle(pSPFStyle2);
                PSPFEditorTypeServiceBase.this.internalRemoveByPSPFStyle(pSPFStyle2);
                PSPFEditorTypeServiceBase.this.onAfterRemoveByPSPFStyle(pSPFStyle2);
            }
        });
    }

    protected void onBeforeRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
    }

    protected void internalRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        ArrayList<PSPFEditorType> arrayList = this.selectByPSPFStyle(pSPFStyle);
        this.onBeforeRemoveByPSPFStyle(pSPFStyle, arrayList);
        for (PSPFEditorType pSPFEditorType : arrayList) {
            this.remove((IEntity)pSPFEditorType);
        }
        this.onAfterRemoveByPSPFStyle(pSPFStyle, arrayList);
    }

    protected void onAfterRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
    }

    protected void onBeforeRemoveByPSPFStyle(PSPFStyle pSPFStyle, ArrayList<PSPFEditorType> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPFStyle(PSPFStyle pSPFStyle, ArrayList<PSPFEditorType> arrayList) throws Exception {
    }

    public void testRemoveByPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSPFEditorType> arrayList = this.selectByPSPF(pSPF, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPF");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSPF);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPFEDITORTYPE_PSPF_PSPFID", "", iDataEntityModel.getName(), "PSPFEDITORTYPE", iDataEntityModel.getDataInfo((IEntity)pSPF), arrayList.get(0)));
        }
    }

    public void resetPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSPFEditorType> arrayList = this.selectByPSPF(pSPF);
        for (PSPFEditorType pSPFEditorType : arrayList) {
            PSPFEditorType pSPFEditorType2 = (PSPFEditorType)this.getDEModel().createEntity();
            pSPFEditorType2.setPSPFEditorTypeId(pSPFEditorType.getPSPFEditorTypeId());
            pSPFEditorType2.setPSPFId(null);
            this.update(pSPFEditorType2);
        }
    }

    public void removeByPSPF(PSPF pSPF) throws Exception {
        final PSPF pSPF2 = pSPF;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFEditorTypeServiceBase.this.onBeforeRemoveByPSPF(pSPF2);
                PSPFEditorTypeServiceBase.this.internalRemoveByPSPF(pSPF2);
                PSPFEditorTypeServiceBase.this.onAfterRemoveByPSPF(pSPF2);
            }
        });
    }

    protected void onBeforeRemoveByPSPF(PSPF pSPF) throws Exception {
    }

    protected void internalRemoveByPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSPFEditorType> arrayList = this.selectByPSPF(pSPF);
        this.onBeforeRemoveByPSPF(pSPF, arrayList);
        for (PSPFEditorType pSPFEditorType : arrayList) {
            this.remove((IEntity)pSPFEditorType);
        }
        this.onAfterRemoveByPSPF(pSPF, arrayList);
    }

    protected void onAfterRemoveByPSPF(PSPF pSPF) throws Exception {
    }

    protected void onBeforeRemoveByPSPF(PSPF pSPF, ArrayList<PSPFEditorType> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPF(PSPF pSPF, ArrayList<PSPFEditorType> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSPFEditorType pSPFEditorType) throws Exception {
        super.onBeforeRemove(pSPFEditorType);
    }

    protected void replaceParentInfo(PSPFEditorType pSPFEditorType, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSPFEditorType, cloneSession);
        if (pSPFEditorType.getPSEditorTypeId() != null && (iEntity = cloneSession.getEntity("PSEDITORTYPE", (Object)pSPFEditorType.getPSEditorTypeId())) != null) {
            this.onFillParentInfo_PSEditorType(pSPFEditorType, (PSEditorType)iEntity);
        }
        if (pSPFEditorType.getPSPFStyleId() != null && (iEntity = cloneSession.getEntity("PSPFSTYLE", (Object)pSPFEditorType.getPSPFStyleId())) != null) {
            this.onFillParentInfo_PSPFStyle(pSPFEditorType, (PSPFStyle)iEntity);
        }
        if (pSPFEditorType.getPSPFId() != null && (iEntity = cloneSession.getEntity("PSPF", (Object)pSPFEditorType.getPSPFId())) != null) {
            this.onFillParentInfo_PSPF(pSPFEditorType, (PSPF)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSPFEditorType pSPFEditorType, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSPFEditorType, bl);
    }

    protected void onCheckEntity(boolean bl, PSPFEditorType pSPFEditorType, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_EditorClass(bl, pSPFEditorType, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EditorDesc(bl, pSPFEditorType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSPFEditorType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSEditorTypeId(bl, pSPFEditorType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFEditorTypeId(bl, pSPFEditorType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFEditorTypeName(bl, pSPFEditorType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFId(bl, pSPFEditorType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFStyleId(bl, pSPFEditorType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSPFEditorType, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_EditorClass(boolean bl, PSPFEditorType pSPFEditorType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFEditorType.isEditorClassDirty() : !pSPFEditorType.isEditorClassDirty()) {
            return null;
        }
        String string = pSPFEditorType.getEditorClass();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EditorClass_Default((IEntity)pSPFEditorType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EDITORCLASS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EditorDesc(boolean bl, PSPFEditorType pSPFEditorType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFEditorType.isEditorDescDirty() : !pSPFEditorType.isEditorDescDirty()) {
            return null;
        }
        String string = pSPFEditorType.getEditorDesc();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EditorDesc_Default((IEntity)pSPFEditorType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EDITORDESC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSPFEditorType pSPFEditorType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFEditorType.isMemoDirty() : !pSPFEditorType.isMemoDirty()) {
            return null;
        }
        String string = pSPFEditorType.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSPFEditorType, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSEditorTypeId(boolean bl, PSPFEditorType pSPFEditorType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFEditorType.isPSEditorTypeIdDirty() : !pSPFEditorType.isPSEditorTypeIdDirty()) {
            return null;
        }
        String string = pSPFEditorType.getPSEditorTypeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSEditorTypeId_Default((IEntity)pSPFEditorType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSEDITORTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFEditorTypeId(boolean bl, PSPFEditorType pSPFEditorType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFEditorType.isPSPFEditorTypeIdDirty() && !bl2 : !pSPFEditorType.isPSPFEditorTypeIdDirty()) {
            return null;
        }
        String string = pSPFEditorType.getPSPFEditorTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFEDITORTYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFEditorTypeId_Default((IEntity)pSPFEditorType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFEDITORTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFEditorTypeName(boolean bl, PSPFEditorType pSPFEditorType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFEditorType.isPSPFEditorTypeNameDirty() && !bl2 : !pSPFEditorType.isPSPFEditorTypeNameDirty()) {
            return null;
        }
        String string = pSPFEditorType.getPSPFEditorTypeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFEDITORTYPENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFEditorTypeName_Default((IEntity)pSPFEditorType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFEDITORTYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFId(boolean bl, PSPFEditorType pSPFEditorType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFEditorType.isPSPFIdDirty() : !pSPFEditorType.isPSPFIdDirty()) {
            return null;
        }
        String string = pSPFEditorType.getPSPFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFId_Default((IEntity)pSPFEditorType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFStyleId(boolean bl, PSPFEditorType pSPFEditorType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFEditorType.isPSPFStyleIdDirty() : !pSPFEditorType.isPSPFStyleIdDirty()) {
            return null;
        }
        String string = pSPFEditorType.getPSPFStyleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFStyleId_Default((IEntity)pSPFEditorType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFSTYLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSPFEditorType pSPFEditorType, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSPFEditorType, bl);
    }

    protected void onSyncIndexEntities(PSPFEditorType pSPFEditorType, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSPFEditorType, bl);
    }

    public Object getDataContextValue(PSPFEditorType pSPFEditorType, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSPFEditorType, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSPFEditorType pSPFEditorType, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSPFEditorType, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EDITORCLASS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EditorClass_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EDITORDESC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EditorDesc_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSEDITORTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSEditorTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSEDITORTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSEditorTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFEDITORTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFEditorTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFEDITORTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFEditorTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFSTYLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFStyleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFSTYLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFStyleName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_EditorClass_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EDITORCLASS", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EditorDesc_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EDITORDESC", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected String onTestValueRule_PSEditorTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSEDITORTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSEditorTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSEDITORTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFEditorTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFEDITORTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFEditorTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFEDITORTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFStyleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFSTYLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFStyleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFSTYLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSPFEditorType pSPFEditorType) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSPFEditorType)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSPFEditorType pSPFEditorType) throws Exception {
        super.onUpdateParent((IEntity)pSPFEditorType);
    }

    @Override
    protected void exportCurXmlModel(PSPFEditorType pSPFEditorType, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSPFEDITORTYPE");
        if (!bl) {
            pSPFEditorType.setCreateDate(null);
            pSPFEditorType.setCreateMan(null);
            pSPFEditorType.setPSEditorTypeName(null);
            pSPFEditorType.setPSPFEditorTypeId(null);
            pSPFEditorType.setPSPFName(null);
            pSPFEditorType.setPSPFStyleName(null);
            pSPFEditorType.setUpdateDate(null);
            pSPFEditorType.setUpdateMan(null);
            super.exportCurXmlModel(pSPFEditorType, xmlNode, bl);
        }
    }
}

