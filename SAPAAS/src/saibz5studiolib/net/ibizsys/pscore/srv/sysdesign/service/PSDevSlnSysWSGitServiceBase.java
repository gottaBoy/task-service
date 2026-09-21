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
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkshopServer;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkshopServerBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnSysWSGitDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnSysWSGitDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysWSGit;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnSysWSGitServiceBase
extends PSCoreSysServiceBase<PSDevSlnSysWSGit> {
    private static final Log log = LogFactory.getLog(PSDevSlnSysWSGitServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDevSlnSysWSGitDEModel pSDevSlnSysWSGitDEModel;
    private PSDevSlnSysWSGitDAO pSDevSlnSysWSGitDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysWSGitService";
    }

    public PSDevSlnSysWSGitDEModel getPSDevSlnSysWSGitDEModel() {
        if (this.pSDevSlnSysWSGitDEModel == null) {
            try {
                this.pSDevSlnSysWSGitDEModel = (PSDevSlnSysWSGitDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnSysWSGitDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnSysWSGitDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevSlnSysWSGitDEModel();
    }

    public PSDevSlnSysWSGitDAO getPSDevSlnSysWSGitDAO() {
        if (this.pSDevSlnSysWSGitDAO == null) {
            try {
                this.pSDevSlnSysWSGitDAO = (PSDevSlnSysWSGitDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnSysWSGitDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnSysWSGitDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevSlnSysWSGitDAO();
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

    protected void onFillParentInfo(PSDevSlnSysWSGit pSDevSlnSysWSGit, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSWSGIT_PSDCWORKSHOPSERVER_PSDCWORKSHOPSERVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCWorkshopServerService", (SessionFactory)this.getSessionFactory());
            PSDCWorkshopServer pSDCWorkshopServer = (PSDCWorkshopServer)iService.getDEModel().createEntity();
            pSDCWorkshopServer.set("PSDCWORKSHOPSERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDCWorkshopServer);
            } else {
                iService.get((IEntity)pSDCWorkshopServer);
            }
            this.onFillParentInfo_PSDCWorkshopServer(pSDevSlnSysWSGit, pSDCWorkshopServer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSWSGIT_PSDEVSLNSYS_PSDEVSLNSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSys pSDevSlnSys = (PSDevSlnSys)iService.getDEModel().createEntity();
            pSDevSlnSys.set("PSDEVSLNSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnSys);
            } else {
                iService.get((IEntity)pSDevSlnSys);
            }
            this.onFillParentInfo_PSDevSlnSys(pSDevSlnSysWSGit, pSDevSlnSys);
            return;
        }
        super.onFillParentInfo((IEntity)pSDevSlnSysWSGit, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDCWorkshopServer(PSDevSlnSysWSGit pSDevSlnSysWSGit, PSDCWorkshopServer pSDCWorkshopServer) throws Exception {
        pSDevSlnSysWSGit.setPSDCWorkshopServerId(pSDCWorkshopServer.getPSDCWorkshopServerId());
        pSDevSlnSysWSGit.setPSDCWorkshopServerName(pSDCWorkshopServer.getPSDCWorkshopServerName());
    }

    protected void onFillParentInfo_PSDevSlnSys(PSDevSlnSysWSGit pSDevSlnSysWSGit, PSDevSlnSys pSDevSlnSys) throws Exception {
        pSDevSlnSysWSGit.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
        pSDevSlnSysWSGit.setPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
    }

    protected boolean onFillEntityKeyValue(PSDevSlnSysWSGit pSDevSlnSysWSGit, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSDevSlnSysWSGit.get("PSDEVSLNSYSID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSDevSlnSysWSGit.get("PSDCWORKSHOPSERVERID");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSDevSlnSysWSGit.set(this.getPSDevSlnSysWSGitDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSDevSlnSysWSGit pSDevSlnSysWSGit, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDevSlnSysWSGit, bl);
        this.onFillEntityFullInfo_PSDCWorkshopServer(pSDevSlnSysWSGit, bl);
        this.onFillEntityFullInfo_PSDevSlnSys(pSDevSlnSysWSGit, bl);
    }

    protected void onFillEntityFullInfo_PSDCWorkshopServer(PSDevSlnSysWSGit pSDevSlnSysWSGit, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnSys(PSDevSlnSysWSGit pSDevSlnSysWSGit, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDevSlnSysWSGit pSDevSlnSysWSGit, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDevSlnSysWSGit, bl);
    }

    public ArrayList<PSDevSlnSysWSGit> selectByPSDCWorkshopServer(PSDCWorkshopServerBase pSDCWorkshopServerBase) throws Exception {
        return this.selectByPSDCWorkshopServer(pSDCWorkshopServerBase, "", -1);
    }

    public ArrayList<PSDevSlnSysWSGit> selectByPSDCWorkshopServer(PSDCWorkshopServerBase pSDCWorkshopServerBase, String string) throws Exception {
        return this.selectByPSDCWorkshopServer(pSDCWorkshopServerBase, string, -1);
    }

    public ArrayList<PSDevSlnSysWSGit> selectByPSDCWorkshopServer(PSDCWorkshopServerBase pSDCWorkshopServerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCWORKSHOPSERVERID", (Object)pSDCWorkshopServerBase.getPSDCWorkshopServerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCWorkshopServerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCWorkshopServerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysWSGit> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, "", -1);
    }

    public ArrayList<PSDevSlnSysWSGit> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, string, -1);
    }

    public ArrayList<PSDevSlnSysWSGit> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNSYSID", (Object)pSDevSlnSysBase.getPSDevSlnSysId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnSysCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnSysCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDCWorkshopServer(PSDCWorkshopServer pSDCWorkshopServer) throws Exception {
        ArrayList<PSDevSlnSysWSGit> arrayList = this.selectByPSDCWorkshopServer(pSDCWorkshopServer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCWORKSHOPSERVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDCWorkshopServer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSWSGIT_PSDCWORKSHOPSERVER_PSDCWORKSHOPSERVERID", "", iDataEntityModel.getName(), "PSDEVSLNSYSWSGIT", iDataEntityModel.getDataInfo((IEntity)pSDCWorkshopServer), arrayList.get(0)));
        }
    }

    public void resetPSDCWorkshopServer(PSDCWorkshopServer pSDCWorkshopServer) throws Exception {
        ArrayList<PSDevSlnSysWSGit> arrayList = this.selectByPSDCWorkshopServer(pSDCWorkshopServer);
        for (PSDevSlnSysWSGit pSDevSlnSysWSGit : arrayList) {
            PSDevSlnSysWSGit pSDevSlnSysWSGit2 = (PSDevSlnSysWSGit)this.getDEModel().createEntity();
            pSDevSlnSysWSGit2.setPSDevSlnSysWSGitId(pSDevSlnSysWSGit.getPSDevSlnSysWSGitId());
            pSDevSlnSysWSGit2.setPSDCWorkshopServerId(null);
            this.update(pSDevSlnSysWSGit2);
        }
    }

    public void removeByPSDCWorkshopServer(PSDCWorkshopServer pSDCWorkshopServer) throws Exception {
        final PSDCWorkshopServer pSDCWorkshopServer2 = pSDCWorkshopServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysWSGitServiceBase.this.onBeforeRemoveByPSDCWorkshopServer(pSDCWorkshopServer2);
                PSDevSlnSysWSGitServiceBase.this.internalRemoveByPSDCWorkshopServer(pSDCWorkshopServer2);
                PSDevSlnSysWSGitServiceBase.this.onAfterRemoveByPSDCWorkshopServer(pSDCWorkshopServer2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCWorkshopServer(PSDCWorkshopServer pSDCWorkshopServer) throws Exception {
    }

    protected void internalRemoveByPSDCWorkshopServer(PSDCWorkshopServer pSDCWorkshopServer) throws Exception {
        ArrayList<PSDevSlnSysWSGit> arrayList = this.selectByPSDCWorkshopServer(pSDCWorkshopServer);
        this.onBeforeRemoveByPSDCWorkshopServer(pSDCWorkshopServer, arrayList);
        for (PSDevSlnSysWSGit pSDevSlnSysWSGit : arrayList) {
            this.remove((IEntity)pSDevSlnSysWSGit);
        }
        this.onAfterRemoveByPSDCWorkshopServer(pSDCWorkshopServer, arrayList);
    }

    protected void onAfterRemoveByPSDCWorkshopServer(PSDCWorkshopServer pSDCWorkshopServer) throws Exception {
    }

    protected void onBeforeRemoveByPSDCWorkshopServer(PSDCWorkshopServer pSDCWorkshopServer, ArrayList<PSDevSlnSysWSGit> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCWorkshopServer(PSDCWorkshopServer pSDCWorkshopServer, ArrayList<PSDevSlnSysWSGit> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    public void resetPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnSysWSGit> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        for (PSDevSlnSysWSGit pSDevSlnSysWSGit : arrayList) {
            PSDevSlnSysWSGit pSDevSlnSysWSGit2 = (PSDevSlnSysWSGit)this.getDEModel().createEntity();
            pSDevSlnSysWSGit2.setPSDevSlnSysWSGitId(pSDevSlnSysWSGit.getPSDevSlnSysWSGitId());
            pSDevSlnSysWSGit2.setPSDevSlnSysId(null);
            this.update(pSDevSlnSysWSGit2);
        }
    }

    public void removeByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysWSGitServiceBase.this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnSysWSGitServiceBase.this.internalRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnSysWSGitServiceBase.this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnSysWSGit> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
        for (PSDevSlnSysWSGit pSDevSlnSysWSGit : arrayList) {
            this.remove((IEntity)pSDevSlnSysWSGit);
        }
        this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnSysWSGit> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnSysWSGit> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevSlnSysWSGit pSDevSlnSysWSGit) throws Exception {
        super.onBeforeRemove(pSDevSlnSysWSGit);
    }

    protected void replaceParentInfo(PSDevSlnSysWSGit pSDevSlnSysWSGit, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDevSlnSysWSGit, cloneSession);
        if (pSDevSlnSysWSGit.getPSDCWorkshopServerId() != null && (iEntity = cloneSession.getEntity("PSDCWORKSHOPSERVER", (Object)pSDevSlnSysWSGit.getPSDCWorkshopServerId())) != null) {
            this.onFillParentInfo_PSDCWorkshopServer(pSDevSlnSysWSGit, (PSDCWorkshopServer)iEntity);
        }
        if (pSDevSlnSysWSGit.getPSDevSlnSysId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYS", (Object)pSDevSlnSysWSGit.getPSDevSlnSysId())) != null) {
            this.onFillParentInfo_PSDevSlnSys(pSDevSlnSysWSGit, (PSDevSlnSys)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevSlnSysWSGit pSDevSlnSysWSGit, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDevSlnSysWSGit, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevSlnSysWSGit pSDevSlnSysWSGit, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_GITPassword(bl, pSDevSlnSysWSGit, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GitPath(bl, pSDevSlnSysWSGit, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GITUserName(bl, pSDevSlnSysWSGit, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDevSlnSysWSGit, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCWorkshopServerId(bl, pSDevSlnSysWSGit, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysId(bl, pSDevSlnSysWSGit, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysWSGitId(bl, pSDevSlnSysWSGit, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysWSGitName(bl, pSDevSlnSysWSGit, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDevSlnSysWSGit, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_GITPassword(boolean bl, PSDevSlnSysWSGit pSDevSlnSysWSGit, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysWSGit.isGITPasswordDirty() : !pSDevSlnSysWSGit.isGITPasswordDirty()) {
            return null;
        }
        String string = pSDevSlnSysWSGit.getGITPassword();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GITPassword_Default((IEntity)pSDevSlnSysWSGit, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GITPASSWORD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GitPath(boolean bl, PSDevSlnSysWSGit pSDevSlnSysWSGit, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysWSGit.isGitPathDirty() : !pSDevSlnSysWSGit.isGitPathDirty()) {
            return null;
        }
        String string = pSDevSlnSysWSGit.getGitPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GitPath_Default((IEntity)pSDevSlnSysWSGit, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GITPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GITUserName(boolean bl, PSDevSlnSysWSGit pSDevSlnSysWSGit, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysWSGit.isGITUserNameDirty() : !pSDevSlnSysWSGit.isGITUserNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysWSGit.getGITUserName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GITUserName_Default((IEntity)pSDevSlnSysWSGit, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GITUSERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevSlnSysWSGit pSDevSlnSysWSGit, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysWSGit.isMemoDirty() : !pSDevSlnSysWSGit.isMemoDirty()) {
            return null;
        }
        String string = pSDevSlnSysWSGit.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDevSlnSysWSGit, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCWorkshopServerId(boolean bl, PSDevSlnSysWSGit pSDevSlnSysWSGit, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysWSGit.isPSDCWorkshopServerIdDirty() && !bl2 : !pSDevSlnSysWSGit.isPSDCWorkshopServerIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysWSGit.getPSDCWorkshopServerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCWORKSHOPSERVERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCWorkshopServerId_Default((IEntity)pSDevSlnSysWSGit, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCWORKSHOPSERVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysId(boolean bl, PSDevSlnSysWSGit pSDevSlnSysWSGit, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysWSGit.isPSDevSlnSysIdDirty() && !bl2 : !pSDevSlnSysWSGit.isPSDevSlnSysIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysWSGit.getPSDevSlnSysId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysId_Default((IEntity)pSDevSlnSysWSGit, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnSysWSGitId(boolean bl, PSDevSlnSysWSGit pSDevSlnSysWSGit, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysWSGit.isPSDevSlnSysWSGitIdDirty() && !bl2 : !pSDevSlnSysWSGit.isPSDevSlnSysWSGitIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysWSGit.getPSDevSlnSysWSGitId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSWSGITID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysWSGitId_Default((IEntity)pSDevSlnSysWSGit, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSWSGITID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysWSGitName(boolean bl, PSDevSlnSysWSGit pSDevSlnSysWSGit, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysWSGit.isPSDevSlnSysWSGitNameDirty() && !bl2 : !pSDevSlnSysWSGit.isPSDevSlnSysWSGitNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysWSGit.getPSDevSlnSysWSGitName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSWSGITNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysWSGitName_Default((IEntity)pSDevSlnSysWSGit, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSWSGITNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSDCWORKSHOPSERVERID";
                String string4 = this.checkFieldDupRule(this.getPSDevSlnSysWSGitDEModel(), "PSDEVSLNSYSWSGITNAME", string3, pSDevSlnSysWSGit, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEVSLNSYSWSGITNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDevSlnSysWSGit pSDevSlnSysWSGit, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDevSlnSysWSGit, bl);
    }

    protected void onSyncIndexEntities(PSDevSlnSysWSGit pSDevSlnSysWSGit, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDevSlnSysWSGit, bl);
    }

    public Object getDataContextValue(PSDevSlnSysWSGit pSDevSlnSysWSGit, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDevSlnSysWSGit, string, iDataContextParam)) != null) {
            return object;
        }
        PSDevSlnSys pSDevSlnSys = pSDevSlnSysWSGit.getPSDevSlnSys();
        if (pSDevSlnSys != null && pSDevSlnSys.contains(string)) {
            return pSDevSlnSys.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDevSlnSysWSGit pSDevSlnSysWSGit, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDevSlnSysWSGit, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GITPASSWORD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GITPassword_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GITPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GitPath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GITUSERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GITUserName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCWORKSHOPSERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCWorkshopServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCWORKSHOPSERVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCWorkshopServerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSWSGITID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysWSGitId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSWSGITNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysWSGitName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_GITPassword_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GITPASSWORD", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GitPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GITPATH", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GITUserName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GITUSERNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
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

    protected String onTestValueRule_PSDCWorkshopServerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCWORKSHOPSERVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCWorkshopServerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCWORKSHOPSERVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDevSlnSysName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysWSGitId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSWSGITID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysWSGitName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSWSGITNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDevSlnSysWSGit pSDevSlnSysWSGit) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDevSlnSysWSGit)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevSlnSysWSGit pSDevSlnSysWSGit) throws Exception {
        super.onUpdateParent((IEntity)pSDevSlnSysWSGit);
    }

    @Override
    protected void exportCurXmlModel(PSDevSlnSysWSGit pSDevSlnSysWSGit, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVSLNSYSWSGIT");
        if (!bl) {
            pSDevSlnSysWSGit.setCreateDate(null);
            pSDevSlnSysWSGit.setCreateMan(null);
            pSDevSlnSysWSGit.setPSDevSlnSysWSGitId(null);
            pSDevSlnSysWSGit.setUpdateDate(null);
            pSDevSlnSysWSGit.setUpdateMan(null);
            super.exportCurXmlModel(pSDevSlnSysWSGit, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSDevSlnSysWSGit pSDevSlnSysWSGit, PSSystem pSSystem) throws Exception {
        PSDevSlnSysWSGit pSDevSlnSysWSGit2 = new PSDevSlnSysWSGit();
        pSDevSlnSysWSGit2.setPSDevSlnSysId(pSDevSlnSysWSGit.getPSDevSlnSysId());
        pSDevSlnSysWSGit2.setPSDCWorkshopServerId(pSDevSlnSysWSGit.getPSDCWorkshopServerId());
        if (this.selectOne((IEntity)pSDevSlnSysWSGit2, true)) {
            return pSDevSlnSysWSGit2.getPSDevSlnSysWSGitId();
        }
        return super.getEntityFolderKeyValue(pSDevSlnSysWSGit, pSSystem);
    }
}

