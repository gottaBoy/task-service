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
import net.ibizsys.pscore.srv.config.dao.PSPFCtrlTypeDAO;
import net.ibizsys.pscore.srv.config.demodel.PSPFCtrlTypeDEModel;
import net.ibizsys.pscore.srv.config.entity.PSCtrlType;
import net.ibizsys.pscore.srv.config.entity.PSCtrlTypeBase;
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFBase;
import net.ibizsys.pscore.srv.config.entity.PSPFCtrlType;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.entity.PSPFStyleBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFCtrlTypeServiceBase
extends PSCoreSysServiceBase<PSPFCtrlType> {
    private static final Log log = LogFactory.getLog(PSPFCtrlTypeServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSPFCtrlTypeDEModel pSPFCtrlTypeDEModel;
    private PSPFCtrlTypeDAO pSPFCtrlTypeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSPFCtrlTypeService";
    }

    public PSPFCtrlTypeDEModel getPSPFCtrlTypeDEModel() {
        if (this.pSPFCtrlTypeDEModel == null) {
            try {
                this.pSPFCtrlTypeDEModel = (PSPFCtrlTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSPFCtrlTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFCtrlTypeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSPFCtrlTypeDEModel();
    }

    public PSPFCtrlTypeDAO getPSPFCtrlTypeDAO() {
        if (this.pSPFCtrlTypeDAO == null) {
            try {
                this.pSPFCtrlTypeDAO = (PSPFCtrlTypeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSPFCtrlTypeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFCtrlTypeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSPFCtrlTypeDAO();
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

    protected void onFillParentInfo(PSPFCtrlType pSPFCtrlType, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFCTRLTYPE_PSCTRLTYPE_PSCTRLTYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSCtrlTypeService", (SessionFactory)this.getSessionFactory());
            PSCtrlType pSCtrlType = (PSCtrlType)iService.getDEModel().createEntity();
            pSCtrlType.set("PSCTRLTYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCtrlType);
            } else {
                iService.get(pSCtrlType);
            }
            this.onFillParentInfo_PSCtrlType(pSPFCtrlType, pSCtrlType);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFCTRLTYPE_PSPFSTYLE_PSPFSTYLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFStyleService", (SessionFactory)this.getSessionFactory());
            PSPFStyle pSPFStyle = (PSPFStyle)iService.getDEModel().createEntity();
            pSPFStyle.set("PSPFSTYLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPFStyle);
            } else {
                iService.get(pSPFStyle);
            }
            this.onFillParentInfo_PSPFStyle(pSPFCtrlType, pSPFStyle);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFCTRLTYPE_PSPF_PSPFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFService", (SessionFactory)this.getSessionFactory());
            PSPF pSPF = (PSPF)iService.getDEModel().createEntity();
            pSPF.set("PSPFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPF);
            } else {
                iService.get(pSPF);
            }
            this.onFillParentInfo_PSPF(pSPFCtrlType, pSPF);
            return;
        }
        super.onFillParentInfo(pSPFCtrlType, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSCtrlType(PSPFCtrlType pSPFCtrlType, PSCtrlType pSCtrlType) throws Exception {
        pSPFCtrlType.setPSCtrlTypeId(pSCtrlType.getPSCtrlTypeId());
        pSPFCtrlType.setPSCtrlTypeName(pSCtrlType.getPSCtrlTypeName());
    }

    protected void onFillParentInfo_PSPFStyle(PSPFCtrlType pSPFCtrlType, PSPFStyle pSPFStyle) throws Exception {
        pSPFCtrlType.setPSPFStyleId(pSPFStyle.getPSPFStyleId());
        pSPFCtrlType.setPSPFStyleName(pSPFStyle.getPSPFStyleName());
    }

    protected void onFillParentInfo_PSPF(PSPFCtrlType pSPFCtrlType, PSPF pSPF) throws Exception {
        pSPFCtrlType.setPSPFId(pSPF.getPSPFId());
        pSPFCtrlType.setPSPFName(pSPF.getPSPFName());
    }

    protected void onFillEntityFullInfo(PSPFCtrlType pSPFCtrlType, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSPFCtrlType, bl);
        this.onFillEntityFullInfo_PSCtrlType(pSPFCtrlType, bl);
        this.onFillEntityFullInfo_PSPFStyle(pSPFCtrlType, bl);
        this.onFillEntityFullInfo_PSPF(pSPFCtrlType, bl);
    }

    protected void onFillEntityFullInfo_PSCtrlType(PSPFCtrlType pSPFCtrlType, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSPFStyle(PSPFCtrlType pSPFCtrlType, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSPF(PSPFCtrlType pSPFCtrlType, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSPFCtrlType pSPFCtrlType, boolean bl) throws Exception {
        super.onWriteBackParent(pSPFCtrlType, bl);
    }

    public ArrayList<PSPFCtrlType> selectByPSCtrlType(PSCtrlTypeBase pSCtrlTypeBase) throws Exception {
        return this.selectByPSCtrlType(pSCtrlTypeBase, "", -1);
    }

    public ArrayList<PSPFCtrlType> selectByPSCtrlType(PSCtrlTypeBase pSCtrlTypeBase, String string) throws Exception {
        return this.selectByPSCtrlType(pSCtrlTypeBase, string, -1);
    }

    public ArrayList<PSPFCtrlType> selectByPSCtrlType(PSCtrlTypeBase pSCtrlTypeBase, String string, int n) throws Exception {
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

    public ArrayList<PSPFCtrlType> selectByPSPFStyle(PSPFStyleBase pSPFStyleBase) throws Exception {
        return this.selectByPSPFStyle(pSPFStyleBase, "", -1);
    }

    public ArrayList<PSPFCtrlType> selectByPSPFStyle(PSPFStyleBase pSPFStyleBase, String string) throws Exception {
        return this.selectByPSPFStyle(pSPFStyleBase, string, -1);
    }

    public ArrayList<PSPFCtrlType> selectByPSPFStyle(PSPFStyleBase pSPFStyleBase, String string, int n) throws Exception {
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

    public ArrayList<PSPFCtrlType> selectByPSPF(PSPFBase pSPFBase) throws Exception {
        return this.selectByPSPF(pSPFBase, "", -1);
    }

    public ArrayList<PSPFCtrlType> selectByPSPF(PSPFBase pSPFBase, String string) throws Exception {
        return this.selectByPSPF(pSPFBase, string, -1);
    }

    public ArrayList<PSPFCtrlType> selectByPSPF(PSPFBase pSPFBase, String string, int n) throws Exception {
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

    public void testRemoveByPSCtrlType(PSCtrlType pSCtrlType) throws Exception {
        ArrayList<PSPFCtrlType> arrayList = this.selectByPSCtrlType(pSCtrlType, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCTRLTYPE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCtrlType);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPFCTRLTYPE_PSCTRLTYPE_PSCTRLTYPEID", "", iDataEntityModel.getName(), "PSPFCTRLTYPE", iDataEntityModel.getDataInfo(pSCtrlType), arrayList.get(0)));
        }
    }

    public void resetPSCtrlType(PSCtrlType pSCtrlType) throws Exception {
        ArrayList<PSPFCtrlType> arrayList = this.selectByPSCtrlType(pSCtrlType);
        for (PSPFCtrlType pSPFCtrlType : arrayList) {
            PSPFCtrlType pSPFCtrlType2 = (PSPFCtrlType)this.getDEModel().createEntity();
            pSPFCtrlType2.setPSPFCtrlTypeId(pSPFCtrlType.getPSPFCtrlTypeId());
            pSPFCtrlType2.setPSCtrlTypeId(null);
            this.update(pSPFCtrlType2);
        }
    }

    public void removeByPSCtrlType(PSCtrlType pSCtrlType) throws Exception {
        final PSCtrlType pSCtrlType2 = pSCtrlType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFCtrlTypeServiceBase.this.onBeforeRemoveByPSCtrlType(pSCtrlType2);
                PSPFCtrlTypeServiceBase.this.internalRemoveByPSCtrlType(pSCtrlType2);
                PSPFCtrlTypeServiceBase.this.onAfterRemoveByPSCtrlType(pSCtrlType2);
            }
        });
    }

    protected void onBeforeRemoveByPSCtrlType(PSCtrlType pSCtrlType) throws Exception {
    }

    protected void internalRemoveByPSCtrlType(PSCtrlType pSCtrlType) throws Exception {
        ArrayList<PSPFCtrlType> arrayList = this.selectByPSCtrlType(pSCtrlType);
        this.onBeforeRemoveByPSCtrlType(pSCtrlType, arrayList);
        for (PSPFCtrlType pSPFCtrlType : arrayList) {
            this.remove(pSPFCtrlType);
        }
        this.onAfterRemoveByPSCtrlType(pSCtrlType, arrayList);
    }

    protected void onAfterRemoveByPSCtrlType(PSCtrlType pSCtrlType) throws Exception {
    }

    protected void onBeforeRemoveByPSCtrlType(PSCtrlType pSCtrlType, ArrayList<PSPFCtrlType> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCtrlType(PSCtrlType pSCtrlType, ArrayList<PSPFCtrlType> arrayList) throws Exception {
    }

    public void testRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        ArrayList<PSPFCtrlType> arrayList = this.selectByPSPFStyle(pSPFStyle, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPFSTYLE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSPFStyle);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPFCTRLTYPE_PSPFSTYLE_PSPFSTYLEID", "", iDataEntityModel.getName(), "PSPFCTRLTYPE", iDataEntityModel.getDataInfo(pSPFStyle), arrayList.get(0)));
        }
    }

    public void resetPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        ArrayList<PSPFCtrlType> arrayList = this.selectByPSPFStyle(pSPFStyle);
        for (PSPFCtrlType pSPFCtrlType : arrayList) {
            PSPFCtrlType pSPFCtrlType2 = (PSPFCtrlType)this.getDEModel().createEntity();
            pSPFCtrlType2.setPSPFCtrlTypeId(pSPFCtrlType.getPSPFCtrlTypeId());
            pSPFCtrlType2.setPSPFStyleId(null);
            this.update(pSPFCtrlType2);
        }
    }

    public void removeByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        final PSPFStyle pSPFStyle2 = pSPFStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFCtrlTypeServiceBase.this.onBeforeRemoveByPSPFStyle(pSPFStyle2);
                PSPFCtrlTypeServiceBase.this.internalRemoveByPSPFStyle(pSPFStyle2);
                PSPFCtrlTypeServiceBase.this.onAfterRemoveByPSPFStyle(pSPFStyle2);
            }
        });
    }

    protected void onBeforeRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
    }

    protected void internalRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        ArrayList<PSPFCtrlType> arrayList = this.selectByPSPFStyle(pSPFStyle);
        this.onBeforeRemoveByPSPFStyle(pSPFStyle, arrayList);
        for (PSPFCtrlType pSPFCtrlType : arrayList) {
            this.remove(pSPFCtrlType);
        }
        this.onAfterRemoveByPSPFStyle(pSPFStyle, arrayList);
    }

    protected void onAfterRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
    }

    protected void onBeforeRemoveByPSPFStyle(PSPFStyle pSPFStyle, ArrayList<PSPFCtrlType> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPFStyle(PSPFStyle pSPFStyle, ArrayList<PSPFCtrlType> arrayList) throws Exception {
    }

    public void testRemoveByPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSPFCtrlType> arrayList = this.selectByPSPF(pSPF, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPF");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSPF);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPFCTRLTYPE_PSPF_PSPFID", "", iDataEntityModel.getName(), "PSPFCTRLTYPE", iDataEntityModel.getDataInfo(pSPF), arrayList.get(0)));
        }
    }

    public void resetPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSPFCtrlType> arrayList = this.selectByPSPF(pSPF);
        for (PSPFCtrlType pSPFCtrlType : arrayList) {
            PSPFCtrlType pSPFCtrlType2 = (PSPFCtrlType)this.getDEModel().createEntity();
            pSPFCtrlType2.setPSPFCtrlTypeId(pSPFCtrlType.getPSPFCtrlTypeId());
            pSPFCtrlType2.setPSPFId(null);
            this.update(pSPFCtrlType2);
        }
    }

    public void removeByPSPF(PSPF pSPF) throws Exception {
        final PSPF pSPF2 = pSPF;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFCtrlTypeServiceBase.this.onBeforeRemoveByPSPF(pSPF2);
                PSPFCtrlTypeServiceBase.this.internalRemoveByPSPF(pSPF2);
                PSPFCtrlTypeServiceBase.this.onAfterRemoveByPSPF(pSPF2);
            }
        });
    }

    protected void onBeforeRemoveByPSPF(PSPF pSPF) throws Exception {
    }

    protected void internalRemoveByPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSPFCtrlType> arrayList = this.selectByPSPF(pSPF);
        this.onBeforeRemoveByPSPF(pSPF, arrayList);
        for (PSPFCtrlType pSPFCtrlType : arrayList) {
            this.remove(pSPFCtrlType);
        }
        this.onAfterRemoveByPSPF(pSPF, arrayList);
    }

    protected void onAfterRemoveByPSPF(PSPF pSPF) throws Exception {
    }

    protected void onBeforeRemoveByPSPF(PSPF pSPF, ArrayList<PSPFCtrlType> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPF(PSPF pSPF, ArrayList<PSPFCtrlType> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSPFCtrlType pSPFCtrlType) throws Exception {
        super.onBeforeRemove(pSPFCtrlType);
    }

    protected void replaceParentInfo(PSPFCtrlType pSPFCtrlType, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSPFCtrlType, cloneSession);
        if (pSPFCtrlType.getPSCtrlTypeId() != null && (iEntity = cloneSession.getEntity("PSCTRLTYPE", (Object)pSPFCtrlType.getPSCtrlTypeId())) != null) {
            this.onFillParentInfo_PSCtrlType(pSPFCtrlType, (PSCtrlType)iEntity);
        }
        if (pSPFCtrlType.getPSPFStyleId() != null && (iEntity = cloneSession.getEntity("PSPFSTYLE", (Object)pSPFCtrlType.getPSPFStyleId())) != null) {
            this.onFillParentInfo_PSPFStyle(pSPFCtrlType, (PSPFStyle)iEntity);
        }
        if (pSPFCtrlType.getPSPFId() != null && (iEntity = cloneSession.getEntity("PSPF", (Object)pSPFCtrlType.getPSPFId())) != null) {
            this.onFillParentInfo_PSPF(pSPFCtrlType, (PSPF)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSPFCtrlType pSPFCtrlType, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSPFCtrlType, bl);
    }

    protected void onCheckEntity(boolean bl, PSPFCtrlType pSPFCtrlType, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CtrlClass(bl, pSPFCtrlType, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlDesc(bl, pSPFCtrlType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSPFCtrlType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlTypeId(bl, pSPFCtrlType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFCtrlTypeId(bl, pSPFCtrlType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFCtrlTypeName(bl, pSPFCtrlType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFId(bl, pSPFCtrlType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFStyleId(bl, pSPFCtrlType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSPFCtrlType, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CtrlClass(boolean bl, PSPFCtrlType pSPFCtrlType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFCtrlType.isCtrlClassDirty() : !pSPFCtrlType.isCtrlClassDirty()) {
            return null;
        }
        String string = pSPFCtrlType.getCtrlClass();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CtrlClass_Default(pSPFCtrlType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLCLASS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlDesc(boolean bl, PSPFCtrlType pSPFCtrlType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFCtrlType.isCtrlDescDirty() : !pSPFCtrlType.isCtrlDescDirty()) {
            return null;
        }
        String string = pSPFCtrlType.getCtrlDesc();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CtrlDesc_Default(pSPFCtrlType, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSPFCtrlType pSPFCtrlType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFCtrlType.isMemoDirty() : !pSPFCtrlType.isMemoDirty()) {
            return null;
        }
        String string = pSPFCtrlType.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSPFCtrlType, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCtrlTypeId(boolean bl, PSPFCtrlType pSPFCtrlType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFCtrlType.isPSCtrlTypeIdDirty() : !pSPFCtrlType.isPSCtrlTypeIdDirty()) {
            return null;
        }
        String string = pSPFCtrlType.getPSCtrlTypeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlTypeId_Default(pSPFCtrlType, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPFCtrlTypeId(boolean bl, PSPFCtrlType pSPFCtrlType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFCtrlType.isPSPFCtrlTypeIdDirty() && !bl2 : !pSPFCtrlType.isPSPFCtrlTypeIdDirty()) {
            return null;
        }
        String string = pSPFCtrlType.getPSPFCtrlTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFCTRLTYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFCtrlTypeId_Default(pSPFCtrlType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFCTRLTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFCtrlTypeName(boolean bl, PSPFCtrlType pSPFCtrlType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFCtrlType.isPSPFCtrlTypeNameDirty() && !bl2 : !pSPFCtrlType.isPSPFCtrlTypeNameDirty()) {
            return null;
        }
        String string = pSPFCtrlType.getPSPFCtrlTypeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFCTRLTYPENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFCtrlTypeName_Default(pSPFCtrlType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFCTRLTYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFId(boolean bl, PSPFCtrlType pSPFCtrlType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFCtrlType.isPSPFIdDirty() : !pSPFCtrlType.isPSPFIdDirty()) {
            return null;
        }
        String string = pSPFCtrlType.getPSPFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFId_Default(pSPFCtrlType, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPFStyleId(boolean bl, PSPFCtrlType pSPFCtrlType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFCtrlType.isPSPFStyleIdDirty() : !pSPFCtrlType.isPSPFStyleIdDirty()) {
            return null;
        }
        String string = pSPFCtrlType.getPSPFStyleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFStyleId_Default(pSPFCtrlType, bl2, bl3);
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

    protected void onSyncEntity(PSPFCtrlType pSPFCtrlType, boolean bl) throws Exception {
        super.onSyncEntity(pSPFCtrlType, bl);
    }

    protected void onSyncIndexEntities(PSPFCtrlType pSPFCtrlType, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSPFCtrlType, bl);
    }

    public Object getDataContextValue(PSPFCtrlType pSPFCtrlType, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSPFCtrlType, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSPFCtrlType pSPFCtrlType, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSPFCtrlType, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLCLASS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlClass_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLDESC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlDesc_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFCTRLTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFCtrlTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFCTRLTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFCtrlTypeName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_CtrlClass_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CTRLCLASS", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
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

    protected String onTestValueRule_PSPFCtrlTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFCTRLTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFCtrlTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFCTRLTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSPFCtrlType pSPFCtrlType) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSPFCtrlType)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSPFCtrlType pSPFCtrlType) throws Exception {
        super.onUpdateParent(pSPFCtrlType);
    }

    @Override
    protected void exportCurXmlModel(PSPFCtrlType pSPFCtrlType, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSPFCTRLTYPE");
        if (!bl) {
            pSPFCtrlType.setCreateDate(null);
            pSPFCtrlType.setCreateMan(null);
            pSPFCtrlType.setPSCtrlTypeName(null);
            pSPFCtrlType.setPSPFCtrlTypeId(null);
            pSPFCtrlType.setPSPFName(null);
            pSPFCtrlType.setPSPFStyleName(null);
            pSPFCtrlType.setUpdateDate(null);
            pSPFCtrlType.setUpdateMan(null);
            super.exportCurXmlModel(pSPFCtrlType, xmlNode, bl);
        }
    }
}

