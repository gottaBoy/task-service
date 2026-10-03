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
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
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
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.dao.PSSFSAHandlerDAO;
import net.ibizsys.pscore.srv.config.demodel.PSSFSAHandlerDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSAHandler;
import net.ibizsys.pscore.srv.config.entity.PSSAHandlerBase;
import net.ibizsys.pscore.srv.config.entity.PSSF;
import net.ibizsys.pscore.srv.config.entity.PSSFBase;
import net.ibizsys.pscore.srv.config.entity.PSSFSAHandler;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFSAHandlerServiceBase
extends PSCoreSysServiceBase<PSSFSAHandler> {
    private static final Log log = LogFactory.getLog(PSSFSAHandlerServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSFSAHandlerDEModel pSSFSAHandlerDEModel;
    private PSSFSAHandlerDAO pSSFSAHandlerDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSSFSAHandlerService";
    }

    public PSSFSAHandlerDEModel getPSSFSAHandlerDEModel() {
        if (this.pSSFSAHandlerDEModel == null) {
            try {
                this.pSSFSAHandlerDEModel = (PSSFSAHandlerDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSFSAHandlerDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFSAHandlerDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSFSAHandlerDEModel();
    }

    public PSSFSAHandlerDAO getPSSFSAHandlerDAO() {
        if (this.pSSFSAHandlerDAO == null) {
            try {
                this.pSSFSAHandlerDAO = (PSSFSAHandlerDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSSFSAHandlerDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFSAHandlerDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSFSAHandlerDAO();
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

    protected void onFillParentInfo(PSSFSAHandler pSSFSAHandler, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSFSAHANDLER_PSSAHANDLER_PSSAHANDLERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSAHandlerService", (SessionFactory)this.getSessionFactory());
            PSSAHandler pSSAHandler = (PSSAHandler)iService.getDEModel().createEntity();
            pSSAHandler.set("PSSAHANDLERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSAHandler);
            } else {
                iService.get(pSSAHandler);
            }
            this.onFillParentInfo_PSSAHandler(pSSFSAHandler, pSSAHandler);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSFSAHANDLER_PSSF_PSSFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFService", (SessionFactory)this.getSessionFactory());
            PSSF pSSF = (PSSF)iService.getDEModel().createEntity();
            pSSF.set("PSSFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSF);
            } else {
                iService.get(pSSF);
            }
            this.onFillParentInfo_PSSF(pSSFSAHandler, pSSF);
            return;
        }
        super.onFillParentInfo(pSSFSAHandler, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSAHandler(PSSFSAHandler pSSFSAHandler, PSSAHandler pSSAHandler) throws Exception {
        pSSFSAHandler.setPSSAHandlerId(pSSAHandler.getPSSAHandlerId());
        pSSFSAHandler.setPSSAHandlerName(pSSAHandler.getPSSAHandlerName());
    }

    protected void onFillParentInfo_PSSF(PSSFSAHandler pSSFSAHandler, PSSF pSSF) throws Exception {
        pSSFSAHandler.setPSSFId(pSSF.getPSSFId());
        pSSFSAHandler.setPSSFName(pSSF.getPSSFName());
    }

    protected boolean onFillEntityKeyValue(PSSFSAHandler pSSFSAHandler, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSSFSAHandler.get("PSSAHANDLERID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSSFSAHandler.get("PSSFID");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSSFSAHandler.set(this.getPSSFSAHandlerDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSSFSAHandler pSSFSAHandler, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSSFSAHandler, bl);
        this.onFillEntityFullInfo_PSSAHandler(pSSFSAHandler, bl);
        this.onFillEntityFullInfo_PSSF(pSSFSAHandler, bl);
    }

    protected void onFillEntityFullInfo_PSSAHandler(PSSFSAHandler pSSFSAHandler, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSF(PSSFSAHandler pSSFSAHandler, boolean bl) throws Exception {
        if (pSSFSAHandler.isPSSFIdDirty()) {
            if (pSSFSAHandler.getPSSFId() != null) {
                if (pSSFSAHandler.getPSSFId() == null || pSSFSAHandler.getPSSFName() == null) {
                    PSSF pSSF = pSSFSAHandler.getPSSF();
                    pSSFSAHandler.setPSSFName(pSSF.getPSSFName());
                }
            } else {
                pSSFSAHandler.setPSSFName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSFSAHandler pSSFSAHandler, boolean bl) throws Exception {
        super.onWriteBackParent(pSSFSAHandler, bl);
    }

    public ArrayList<PSSFSAHandler> selectByPSSAHandler(PSSAHandlerBase pSSAHandlerBase) throws Exception {
        return this.selectByPSSAHandler(pSSAHandlerBase, "", -1);
    }

    public ArrayList<PSSFSAHandler> selectByPSSAHandler(PSSAHandlerBase pSSAHandlerBase, String string) throws Exception {
        return this.selectByPSSAHandler(pSSAHandlerBase, string, -1);
    }

    public ArrayList<PSSFSAHandler> selectByPSSAHandler(PSSAHandlerBase pSSAHandlerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSAHANDLERID", (Object)pSSAHandlerBase.getPSSAHandlerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSAHandlerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSAHandlerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSFSAHandler> selectByPSSF(PSSFBase pSSFBase) throws Exception {
        return this.selectByPSSF(pSSFBase, "", -1);
    }

    public ArrayList<PSSFSAHandler> selectByPSSF(PSSFBase pSSFBase, String string) throws Exception {
        return this.selectByPSSF(pSSFBase, string, -1);
    }

    public ArrayList<PSSFSAHandler> selectByPSSF(PSSFBase pSSFBase, String string, int n) throws Exception {
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

    public void testRemoveByPSSAHandler(PSSAHandler pSSAHandler) throws Exception {
        ArrayList<PSSFSAHandler> arrayList = this.selectByPSSAHandler(pSSAHandler, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSAHANDLER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSAHandler);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSFSAHANDLER_PSSAHANDLER_PSSAHANDLERID", "", iDataEntityModel.getName(), "PSSFSAHANDLER", iDataEntityModel.getDataInfo(pSSAHandler), arrayList.get(0)));
        }
    }

    public void resetPSSAHandler(PSSAHandler pSSAHandler) throws Exception {
        ArrayList<PSSFSAHandler> arrayList = this.selectByPSSAHandler(pSSAHandler);
        for (PSSFSAHandler pSSFSAHandler : arrayList) {
            PSSFSAHandler pSSFSAHandler2 = (PSSFSAHandler)this.getDEModel().createEntity();
            pSSFSAHandler2.setPSSFSAHandlerId(pSSFSAHandler.getPSSFSAHandlerId());
            pSSFSAHandler2.setPSSAHandlerId(null);
            this.update(pSSFSAHandler2);
        }
    }

    public void removeByPSSAHandler(PSSAHandler pSSAHandler) throws Exception {
        final PSSAHandler pSSAHandler2 = pSSAHandler;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSFSAHandlerServiceBase.this.onBeforeRemoveByPSSAHandler(pSSAHandler2);
                PSSFSAHandlerServiceBase.this.internalRemoveByPSSAHandler(pSSAHandler2);
                PSSFSAHandlerServiceBase.this.onAfterRemoveByPSSAHandler(pSSAHandler2);
            }
        });
    }

    protected void onBeforeRemoveByPSSAHandler(PSSAHandler pSSAHandler) throws Exception {
    }

    protected void internalRemoveByPSSAHandler(PSSAHandler pSSAHandler) throws Exception {
        ArrayList<PSSFSAHandler> arrayList = this.selectByPSSAHandler(pSSAHandler);
        this.onBeforeRemoveByPSSAHandler(pSSAHandler, arrayList);
        for (PSSFSAHandler pSSFSAHandler : arrayList) {
            this.remove(pSSFSAHandler);
        }
        this.onAfterRemoveByPSSAHandler(pSSAHandler, arrayList);
    }

    protected void onAfterRemoveByPSSAHandler(PSSAHandler pSSAHandler) throws Exception {
    }

    protected void onBeforeRemoveByPSSAHandler(PSSAHandler pSSAHandler, ArrayList<PSSFSAHandler> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSAHandler(PSSAHandler pSSAHandler, ArrayList<PSSFSAHandler> arrayList) throws Exception {
    }

    public void testRemoveByPSSF(PSSF pSSF) throws Exception {
        ArrayList<PSSFSAHandler> arrayList = this.selectByPSSF(pSSF, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSF");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSF);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSFSAHANDLER_PSSF_PSSFID", "", iDataEntityModel.getName(), "PSSFSAHANDLER", iDataEntityModel.getDataInfo(pSSF), arrayList.get(0)));
        }
    }

    public void resetPSSF(PSSF pSSF) throws Exception {
        ArrayList<PSSFSAHandler> arrayList = this.selectByPSSF(pSSF);
        for (PSSFSAHandler pSSFSAHandler : arrayList) {
            PSSFSAHandler pSSFSAHandler2 = (PSSFSAHandler)this.getDEModel().createEntity();
            pSSFSAHandler2.setPSSFSAHandlerId(pSSFSAHandler.getPSSFSAHandlerId());
            pSSFSAHandler2.setPSSFId(null);
            this.update(pSSFSAHandler2);
        }
    }

    public void removeByPSSF(PSSF pSSF) throws Exception {
        final PSSF pSSF2 = pSSF;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSFSAHandlerServiceBase.this.onBeforeRemoveByPSSF(pSSF2);
                PSSFSAHandlerServiceBase.this.internalRemoveByPSSF(pSSF2);
                PSSFSAHandlerServiceBase.this.onAfterRemoveByPSSF(pSSF2);
            }
        });
    }

    protected void onBeforeRemoveByPSSF(PSSF pSSF) throws Exception {
    }

    protected void internalRemoveByPSSF(PSSF pSSF) throws Exception {
        ArrayList<PSSFSAHandler> arrayList = this.selectByPSSF(pSSF);
        this.onBeforeRemoveByPSSF(pSSF, arrayList);
        for (PSSFSAHandler pSSFSAHandler : arrayList) {
            this.remove(pSSFSAHandler);
        }
        this.onAfterRemoveByPSSF(pSSF, arrayList);
    }

    protected void onAfterRemoveByPSSF(PSSF pSSF) throws Exception {
    }

    protected void onBeforeRemoveByPSSF(PSSF pSSF, ArrayList<PSSFSAHandler> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSF(PSSF pSSF, ArrayList<PSSFSAHandler> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSFSAHandler pSSFSAHandler) throws Exception {
        super.onBeforeRemove(pSSFSAHandler);
    }

    protected void replaceParentInfo(PSSFSAHandler pSSFSAHandler, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSFSAHandler, cloneSession);
        if (pSSFSAHandler.getPSSAHandlerId() != null && (iEntity = cloneSession.getEntity("PSSAHANDLER", (Object)pSSFSAHandler.getPSSAHandlerId())) != null) {
            this.onFillParentInfo_PSSAHandler(pSSFSAHandler, (PSSAHandler)iEntity);
        }
        if (pSSFSAHandler.getPSSFId() != null && (iEntity = cloneSession.getEntity("PSSF", (Object)pSSFSAHandler.getPSSFId())) != null) {
            this.onFillParentInfo_PSSF(pSSFSAHandler, (PSSF)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSFSAHandler pSSFSAHandler, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSFSAHandler, bl);
    }

    protected void onCheckEntity(boolean bl, PSSFSAHandler pSSFSAHandler, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ClientHandlerObj(bl, pSSFSAHandler, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ClientHandlerObj2(bl, pSSFSAHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HandlerObj(bl, pSSFSAHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HandlerObj2(bl, pSSFSAHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HandlerObj3(bl, pSSFSAHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HandlerObj4(bl, pSSFSAHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSFSAHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSAHandlerId(bl, pSSFSAHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFId(bl, pSSFSAHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFName(bl, pSSFSAHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFSAHandlerId(bl, pSSFSAHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFSAHandlerName(bl, pSSFSAHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SAType(bl, pSSFSAHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSFSAHandler, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSFSAHandler, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ClientHandlerObj(boolean bl, PSSFSAHandler pSSFSAHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFSAHandler.isClientHandlerObjDirty() && !bl2 : !pSSFSAHandler.isClientHandlerObjDirty()) {
            return null;
        }
        String string = pSSFSAHandler.getClientHandlerObj();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CLIENTHANDLEROBJ");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ClientHandlerObj_Default(pSSFSAHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CLIENTHANDLEROBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ClientHandlerObj2(boolean bl, PSSFSAHandler pSSFSAHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFSAHandler.isClientHandlerObj2Dirty() : !pSSFSAHandler.isClientHandlerObj2Dirty()) {
            return null;
        }
        String string = pSSFSAHandler.getClientHandlerObj2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ClientHandlerObj2_Default(pSSFSAHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CLIENTHANDLEROBJ2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HandlerObj(boolean bl, PSSFSAHandler pSSFSAHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFSAHandler.isHandlerObjDirty() && !bl2 : !pSSFSAHandler.isHandlerObjDirty()) {
            return null;
        }
        String string = pSSFSAHandler.getHandlerObj();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HANDLEROBJ");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_HandlerObj_Default(pSSFSAHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HANDLEROBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HandlerObj2(boolean bl, PSSFSAHandler pSSFSAHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFSAHandler.isHandlerObj2Dirty() : !pSSFSAHandler.isHandlerObj2Dirty()) {
            return null;
        }
        String string = pSSFSAHandler.getHandlerObj2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HandlerObj2_Default(pSSFSAHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HANDLEROBJ2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HandlerObj3(boolean bl, PSSFSAHandler pSSFSAHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFSAHandler.isHandlerObj3Dirty() : !pSSFSAHandler.isHandlerObj3Dirty()) {
            return null;
        }
        String string = pSSFSAHandler.getHandlerObj3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HandlerObj3_Default(pSSFSAHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HANDLEROBJ3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HandlerObj4(boolean bl, PSSFSAHandler pSSFSAHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFSAHandler.isHandlerObj4Dirty() : !pSSFSAHandler.isHandlerObj4Dirty()) {
            return null;
        }
        String string = pSSFSAHandler.getHandlerObj4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HandlerObj4_Default(pSSFSAHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HANDLEROBJ4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSFSAHandler pSSFSAHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFSAHandler.isMemoDirty() : !pSSFSAHandler.isMemoDirty()) {
            return null;
        }
        String string = pSSFSAHandler.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSFSAHandler, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSAHandlerId(boolean bl, PSSFSAHandler pSSFSAHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFSAHandler.isPSSAHandlerIdDirty() && !bl2 : !pSSFSAHandler.isPSSAHandlerIdDirty()) {
            return null;
        }
        String string = pSSFSAHandler.getPSSAHandlerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSAHANDLERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSAHandlerId_Default(pSSFSAHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSAHANDLERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFId(boolean bl, PSSFSAHandler pSSFSAHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFSAHandler.isPSSFIdDirty() && !bl2 : !pSSFSAHandler.isPSSFIdDirty()) {
            return null;
        }
        String string = pSSFSAHandler.getPSSFId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFId_Default(pSSFSAHandler, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSFName(boolean bl, PSSFSAHandler pSSFSAHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFSAHandler.isPSSFNameDirty() : !pSSFSAHandler.isPSSFNameDirty()) {
            return null;
        }
        String string = pSSFSAHandler.getPSSFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFName_Default(pSSFSAHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFSAHandlerId(boolean bl, PSSFSAHandler pSSFSAHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFSAHandler.isPSSFSAHandlerIdDirty() && !bl2 : !pSSFSAHandler.isPSSFSAHandlerIdDirty()) {
            return null;
        }
        String string = pSSFSAHandler.getPSSFSAHandlerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFSAHANDLERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFSAHandlerId_Default(pSSFSAHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFSAHANDLERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFSAHandlerName(boolean bl, PSSFSAHandler pSSFSAHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFSAHandler.isPSSFSAHandlerNameDirty() && !bl2 : !pSSFSAHandler.isPSSFSAHandlerNameDirty()) {
            return null;
        }
        String string = pSSFSAHandler.getPSSFSAHandlerName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFSAHANDLERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFSAHandlerName_Default(pSSFSAHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFSAHANDLERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SAType(boolean bl, PSSFSAHandler pSSFSAHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFSAHandler.isSATypeDirty() && !bl2 : !pSSFSAHandler.isSATypeDirty()) {
            return null;
        }
        String string = pSSFSAHandler.getSAType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SATYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_SAType_Default(pSSFSAHandler, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SATYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSFSAHandler pSSFSAHandler, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFSAHandler.isValidFlagDirty() && !bl2 : !pSSFSAHandler.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSFSAHandler.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSFSAHandler, bl2, bl3);
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

    protected void onSyncEntity(PSSFSAHandler pSSFSAHandler, boolean bl) throws Exception {
        super.onSyncEntity(pSSFSAHandler, bl);
    }

    protected void onSyncIndexEntities(PSSFSAHandler pSSFSAHandler, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSFSAHandler, bl);
    }

    public Object getDataContextValue(PSSFSAHandler pSSFSAHandler, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSFSAHandler, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSFSAHandler pSSFSAHandler, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSFSAHandler, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CLIENTHANDLEROBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ClientHandlerObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CLIENTHANDLEROBJ2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ClientHandlerObj2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HANDLEROBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HandlerObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HANDLEROBJ2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HandlerObj2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HANDLEROBJ3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HandlerObj3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HANDLEROBJ4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HandlerObj4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSAHANDLERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSAHandlerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSAHANDLERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSAHandlerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFSAHANDLERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFSAHandlerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFSAHANDLERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFSAHandlerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SATYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SAType_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_ClientHandlerObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CLIENTHANDLEROBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ClientHandlerObj2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CLIENTHANDLEROBJ2", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
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

    protected String onTestValueRule_HandlerObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HANDLEROBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HandlerObj2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HANDLEROBJ2", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HandlerObj3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HANDLEROBJ3", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HandlerObj4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HANDLEROBJ4", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
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

    protected String onTestValueRule_PSSAHandlerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSAHANDLERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSAHandlerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSAHANDLERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSFSAHandlerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFSAHANDLERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFSAHandlerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFSAHANDLERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SAType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SATYPE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected boolean onMergeChild(String string, String string2, PSSFSAHandler pSSFSAHandler) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSFSAHandler)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSFSAHandler pSSFSAHandler) throws Exception {
        super.onUpdateParent(pSSFSAHandler);
    }

    @Override
    protected void exportCurXmlModel(PSSFSAHandler pSSFSAHandler, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSFSAHANDLER");
        if (!bl) {
            pSSFSAHandler.setCreateDate(null);
            pSSFSAHandler.setCreateMan(null);
            pSSFSAHandler.setPSSAHandlerName(null);
            pSSFSAHandler.setPSSFSAHandlerId(null);
            pSSFSAHandler.setUpdateDate(null);
            pSSFSAHandler.setUpdateMan(null);
            super.exportCurXmlModel(pSSFSAHandler, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSSFSAHandler pSSFSAHandler, PSSystem pSSystem) throws Exception {
        PSSFSAHandler pSSFSAHandler2 = new PSSFSAHandler();
        pSSFSAHandler2.setPSSAHandlerId(pSSFSAHandler.getPSSAHandlerId());
        pSSFSAHandler2.setPSSFId(pSSFSAHandler.getPSSFId());
        if (this.selectOne(pSSFSAHandler2, true)) {
            return pSSFSAHandler2.getPSSFSAHandlerId();
        }
        return super.getEntityFolderKeyValue(pSSFSAHandler, pSSystem);
    }
}

