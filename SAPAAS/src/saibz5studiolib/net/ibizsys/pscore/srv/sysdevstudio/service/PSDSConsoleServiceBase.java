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
package net.ibizsys.pscore.srv.sysdevstudio.service;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
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
import net.ibizsys.pscore.srv.paasmgr.entity.PSConsoleServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSConsoleServerBase;
import net.ibizsys.pscore.srv.sysdevstudio.dao.PSDSConsoleDAO;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.PSDSConsoleDEModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDSConsole;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDSConsoleServiceBase
extends PSCoreSysServiceBase<PSDSConsole> {
    private static final Log log = LogFactory.getLog(PSDSConsoleServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDSConsoleDEModel pSDSConsoleDEModel;
    private PSDSConsoleDAO pSDSConsoleDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.service.PSDSConsoleService";
    }

    public PSDSConsoleDEModel getPSDSConsoleDEModel() {
        if (this.pSDSConsoleDEModel == null) {
            try {
                this.pSDSConsoleDEModel = (PSDSConsoleDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSDSConsoleDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDSConsoleDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDSConsoleDEModel();
    }

    public PSDSConsoleDAO getPSDSConsoleDAO() {
        if (this.pSDSConsoleDAO == null) {
            try {
                this.pSDSConsoleDAO = (PSDSConsoleDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdevstudio.dao.PSDSConsoleDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDSConsoleDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDSConsoleDAO();
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

    protected void onFillParentInfo(PSDSConsole pSDSConsole, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDSCONSOLE_PSCONSOLESERVER_PSCONSOLESERVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSConsoleServerService", (SessionFactory)this.getSessionFactory());
            PSConsoleServer pSConsoleServer = (PSConsoleServer)iService.getDEModel().createEntity();
            pSConsoleServer.set("PSCONSOLESERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSConsoleServer);
            } else {
                iService.get(pSConsoleServer);
            }
            this.onFillParentInfo_PSConsoleServer(pSDSConsole, pSConsoleServer);
            return;
        }
        super.onFillParentInfo(pSDSConsole, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSConsoleServer(PSDSConsole pSDSConsole, PSConsoleServer pSConsoleServer) throws Exception {
        pSDSConsole.setPSConsoleServerId(pSConsoleServer.getPSConsoleServerId());
        pSDSConsole.setPSConsoleServerName(pSConsoleServer.getPSConsoleServerName());
    }

    protected void onFillEntityFullInfo(PSDSConsole pSDSConsole, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDSConsole, bl);
        this.onFillEntityFullInfo_PSConsoleServer(pSDSConsole, bl);
    }

    protected void onFillEntityFullInfo_PSConsoleServer(PSDSConsole pSDSConsole, boolean bl) throws Exception {
        if (pSDSConsole.isPSConsoleServerIdDirty()) {
            if (pSDSConsole.getPSConsoleServerId() != null) {
                if (pSDSConsole.getPSConsoleServerId() == null || pSDSConsole.getPSConsoleServerName() == null) {
                    PSConsoleServer pSConsoleServer = pSDSConsole.getPSConsoleServer();
                    pSDSConsole.setPSConsoleServerName(pSConsoleServer.getPSConsoleServerName());
                }
            } else {
                pSDSConsole.setPSConsoleServerName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDSConsole pSDSConsole, boolean bl) throws Exception {
        super.onWriteBackParent(pSDSConsole, bl);
    }

    public ArrayList<PSDSConsole> selectByPSConsoleServer(PSConsoleServerBase pSConsoleServerBase) throws Exception {
        return this.selectByPSConsoleServer(pSConsoleServerBase, "", -1);
    }

    public ArrayList<PSDSConsole> selectByPSConsoleServer(PSConsoleServerBase pSConsoleServerBase, String string) throws Exception {
        return this.selectByPSConsoleServer(pSConsoleServerBase, string, -1);
    }

    public ArrayList<PSDSConsole> selectByPSConsoleServer(PSConsoleServerBase pSConsoleServerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCONSOLESERVERID", (Object)pSConsoleServerBase.getPSConsoleServerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSConsoleServerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSConsoleServerCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSConsoleServer(PSConsoleServer pSConsoleServer) throws Exception {
    }

    public void resetPSConsoleServer(PSConsoleServer pSConsoleServer) throws Exception {
        ArrayList<PSDSConsole> arrayList = this.selectByPSConsoleServer(pSConsoleServer);
        for (PSDSConsole pSDSConsole : arrayList) {
            PSDSConsole pSDSConsole2 = (PSDSConsole)this.getDEModel().createEntity();
            pSDSConsole2.setPSDSConsoleId(pSDSConsole.getPSDSConsoleId());
            pSDSConsole2.setPSConsoleServerId(null);
            this.update(pSDSConsole2);
        }
    }

    public void removeByPSConsoleServer(PSConsoleServer pSConsoleServer) throws Exception {
        final PSConsoleServer pSConsoleServer2 = pSConsoleServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDSConsoleServiceBase.this.onBeforeRemoveByPSConsoleServer(pSConsoleServer2);
                PSDSConsoleServiceBase.this.internalRemoveByPSConsoleServer(pSConsoleServer2);
                PSDSConsoleServiceBase.this.onAfterRemoveByPSConsoleServer(pSConsoleServer2);
            }
        });
    }

    protected void onBeforeRemoveByPSConsoleServer(PSConsoleServer pSConsoleServer) throws Exception {
    }

    protected void internalRemoveByPSConsoleServer(PSConsoleServer pSConsoleServer) throws Exception {
        ArrayList<PSDSConsole> arrayList = this.selectByPSConsoleServer(pSConsoleServer);
        this.onBeforeRemoveByPSConsoleServer(pSConsoleServer, arrayList);
        for (PSDSConsole pSDSConsole : arrayList) {
            this.remove(pSDSConsole);
        }
        this.onAfterRemoveByPSConsoleServer(pSConsoleServer, arrayList);
    }

    protected void onAfterRemoveByPSConsoleServer(PSConsoleServer pSConsoleServer) throws Exception {
    }

    protected void onBeforeRemoveByPSConsoleServer(PSConsoleServer pSConsoleServer, ArrayList<PSDSConsole> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSConsoleServer(PSConsoleServer pSConsoleServer, ArrayList<PSDSConsole> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDSConsole pSDSConsole) throws Exception {
        super.onBeforeRemove(pSDSConsole);
    }

    protected void replaceParentInfo(PSDSConsole pSDSConsole, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDSConsole, cloneSession);
        if (pSDSConsole.getPSConsoleServerId() != null && (iEntity = cloneSession.getEntity("PSCONSOLESERVER", (Object)pSDSConsole.getPSConsoleServerId())) != null) {
            this.onFillParentInfo_PSConsoleServer(pSDSConsole, (PSConsoleServer)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDSConsole pSDSConsole, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDSConsole, bl);
    }

    protected void onCheckEntity(boolean bl, PSDSConsole pSDSConsole, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DSTag(bl, pSDSConsole, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DSTag2(bl, pSDSConsole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DSTag3(bl, pSDSConsole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DSTag4(bl, pSDSConsole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HttpAddress(bl, pSDSConsole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HttpPort(bl, pSDSConsole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSConsoleServerId(bl, pSDSConsole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSConsoleServerName(bl, pSDSConsole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysId(bl, pSDSConsole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevUserId(bl, pSDSConsole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDSConsoleId(bl, pSDSConsole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDSConsoleName(bl, pSDSConsole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDSConsole, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DSTag(boolean bl, PSDSConsole pSDSConsole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSConsole.isDSTagDirty() : !pSDSConsole.isDSTagDirty()) {
            return null;
        }
        String string = pSDSConsole.getDSTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DSTag_Default(pSDSConsole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DSTag2(boolean bl, PSDSConsole pSDSConsole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSConsole.isDSTag2Dirty() : !pSDSConsole.isDSTag2Dirty()) {
            return null;
        }
        String string = pSDSConsole.getDSTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DSTag2_Default(pSDSConsole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DSTag3(boolean bl, PSDSConsole pSDSConsole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSConsole.isDSTag3Dirty() : !pSDSConsole.isDSTag3Dirty()) {
            return null;
        }
        String string = pSDSConsole.getDSTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DSTag3_Default(pSDSConsole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DSTag4(boolean bl, PSDSConsole pSDSConsole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSConsole.isDSTag4Dirty() : !pSDSConsole.isDSTag4Dirty()) {
            return null;
        }
        String string = pSDSConsole.getDSTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DSTag4_Default(pSDSConsole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HttpAddress(boolean bl, PSDSConsole pSDSConsole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSConsole.isHttpAddressDirty() : !pSDSConsole.isHttpAddressDirty()) {
            return null;
        }
        String string = pSDSConsole.getHttpAddress();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HttpAddress_Default(pSDSConsole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HTTPADDRESS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HttpPort(boolean bl, PSDSConsole pSDSConsole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSConsole.isHttpPortDirty() : !pSDSConsole.isHttpPortDirty()) {
            return null;
        }
        Integer n = pSDSConsole.getHttpPort();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_HttpPort_Default(pSDSConsole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HTTPPORT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSConsoleServerId(boolean bl, PSDSConsole pSDSConsole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSConsole.isPSConsoleServerIdDirty() : !pSDSConsole.isPSConsoleServerIdDirty()) {
            return null;
        }
        String string = pSDSConsole.getPSConsoleServerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSConsoleServerId_Default(pSDSConsole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCONSOLESERVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSConsoleServerName(boolean bl, PSDSConsole pSDSConsole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSConsole.isPSConsoleServerNameDirty() : !pSDSConsole.isPSConsoleServerNameDirty()) {
            return null;
        }
        String string = pSDSConsole.getPSConsoleServerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSConsoleServerName_Default(pSDSConsole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCONSOLESERVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysId(boolean bl, PSDSConsole pSDSConsole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSConsole.isPSDevSlnSysIdDirty() : !pSDSConsole.isPSDevSlnSysIdDirty()) {
            return null;
        }
        String string = pSDSConsole.getPSDevSlnSysId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysId_Default(pSDSConsole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevUserId(boolean bl, PSDSConsole pSDSConsole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSConsole.isPSDevUserIdDirty() : !pSDSConsole.isPSDevUserIdDirty()) {
            return null;
        }
        String string = pSDSConsole.getPSDevUserId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevUserId_Default(pSDSConsole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVUSERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDSConsoleId(boolean bl, PSDSConsole pSDSConsole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSConsole.isPSDSConsoleIdDirty() && !bl2 : !pSDSConsole.isPSDSConsoleIdDirty()) {
            return null;
        }
        String string = pSDSConsole.getPSDSConsoleId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDSCONSOLEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDSConsoleId_Default(pSDSConsole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDSCONSOLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDSConsoleName(boolean bl, PSDSConsole pSDSConsole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSConsole.isPSDSConsoleNameDirty() && !bl2 : !pSDSConsole.isPSDSConsoleNameDirty()) {
            return null;
        }
        String string = pSDSConsole.getPSDSConsoleName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDSCONSOLENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDSConsoleName_Default(pSDSConsole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDSCONSOLENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDSConsole pSDSConsole, boolean bl) throws Exception {
        super.onSyncEntity(pSDSConsole, bl);
    }

    protected void onSyncIndexEntities(PSDSConsole pSDSConsole, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDSConsole, bl);
    }

    public Object getDataContextValue(PSDSConsole pSDSConsole, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDSConsole, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDSConsole pSDSConsole, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDSConsole, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DSTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DSTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DSTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DSTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HTTPADDRESS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HttpAddress_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HTTPPORT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HttpPort_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCONSOLESERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSConsoleServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCONSOLESERVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSConsoleServerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVUSERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevUserId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDSCONSOLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDSConsoleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDSCONSOLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDSConsoleName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DSTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DSTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DSTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTAG3", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DSTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTAG4", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HttpAddress_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HTTPADDRESS", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HttpPort_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSConsoleServerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCONSOLESERVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSConsoleServerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCONSOLESERVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevUserId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVUSERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDSConsoleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDSCONSOLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDSConsoleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDSCONSOLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDSConsole pSDSConsole) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDSConsole)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDSConsole pSDSConsole) throws Exception {
        super.onUpdateParent(pSDSConsole);
    }

    @Override
    protected void exportCurXmlModel(PSDSConsole pSDSConsole, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDSCONSOLE");
        if (!bl) {
            pSDSConsole.setCreateDate(null);
            pSDSConsole.setCreateMan(null);
            pSDSConsole.setPSDSConsoleId(null);
            pSDSConsole.setUpdateDate(null);
            pSDSConsole.setUpdateMan(null);
            super.exportCurXmlModel(pSDSConsole, xmlNode, bl);
        }
    }
}

