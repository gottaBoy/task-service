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
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysSQLCmdSQLDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysSQLCmdSQLDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSQLCmd;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSQLCmdBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSQLCmdSQL;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysSQLCmdSQLServiceBase
extends PSCoreSysServiceBase<PSSysSQLCmdSQL> {
    private static final Log log = LogFactory.getLog(PSSysSQLCmdSQLServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysSQLCmdSQLDEModel pSSysSQLCmdSQLDEModel;
    private PSSysSQLCmdSQLDAO pSSysSQLCmdSQLDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysSQLCmdSQLService";
    }

    public PSSysSQLCmdSQLDEModel getPSSysSQLCmdSQLDEModel() {
        if (this.pSSysSQLCmdSQLDEModel == null) {
            try {
                this.pSSysSQLCmdSQLDEModel = (PSSysSQLCmdSQLDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysSQLCmdSQLDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysSQLCmdSQLDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysSQLCmdSQLDEModel();
    }

    public PSSysSQLCmdSQLDAO getPSSysSQLCmdSQLDAO() {
        if (this.pSSysSQLCmdSQLDAO == null) {
            try {
                this.pSSysSQLCmdSQLDAO = (PSSysSQLCmdSQLDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysSQLCmdSQLDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysSQLCmdSQLDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysSQLCmdSQLDAO();
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

    protected void onFillParentInfo(PSSysSQLCmdSQL pSSysSQLCmdSQL, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSQLCMDSQL_PSSYSSQLCMD_PSSYSSQLCMDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSQLCmdService", (SessionFactory)this.getSessionFactory());
            PSSysSQLCmd pSSysSQLCmd = (PSSysSQLCmd)iService.getDEModel().createEntity();
            pSSysSQLCmd.set("PSSYSSQLCMDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysSQLCmd);
            } else {
                iService.get((IEntity)pSSysSQLCmd);
            }
            this.onFillParentInfo_PSSysSqlCmd(pSSysSQLCmdSQL, pSSysSQLCmd);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysSQLCmdSQL, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSysSqlCmd(PSSysSQLCmdSQL pSSysSQLCmdSQL, PSSysSQLCmd pSSysSQLCmd) throws Exception {
        pSSysSQLCmdSQL.setPSSysSQLCmdId(pSSysSQLCmd.getPSSysSQLCmdId());
        pSSysSQLCmdSQL.setPSSysSQLCmdName(pSSysSQLCmd.getLogicName());
    }

    protected void onFillEntityFullInfo(PSSysSQLCmdSQL pSSysSQLCmdSQL, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSSysSQLCmdSQL, bl);
        this.onFillEntityFullInfo_PSSysSqlCmd(pSSysSQLCmdSQL, bl);
    }

    protected void onFillEntityFullInfo_PSSysSqlCmd(PSSysSQLCmdSQL pSSysSQLCmdSQL, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysSQLCmdSQL pSSysSQLCmdSQL, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysSQLCmdSQL, bl);
    }

    public ArrayList<PSSysSQLCmdSQL> selectByPSSysSqlCmd(PSSysSQLCmdBase pSSysSQLCmdBase) throws Exception {
        return this.selectByPSSysSqlCmd(pSSysSQLCmdBase, "", -1);
    }

    public ArrayList<PSSysSQLCmdSQL> selectByPSSysSqlCmd(PSSysSQLCmdBase pSSysSQLCmdBase, String string) throws Exception {
        return this.selectByPSSysSqlCmd(pSSysSQLCmdBase, string, -1);
    }

    public ArrayList<PSSysSQLCmdSQL> selectByPSSysSqlCmd(PSSysSQLCmdBase pSSysSQLCmdBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSSQLCMDID", (Object)pSSysSQLCmdBase.getPSSysSQLCmdId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysSqlCmdCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysSqlCmdCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSysSqlCmd(PSSysSQLCmd pSSysSQLCmd) throws Exception {
    }

    public void resetPSSysSqlCmd(PSSysSQLCmd pSSysSQLCmd) throws Exception {
        ArrayList<PSSysSQLCmdSQL> arrayList = this.selectByPSSysSqlCmd(pSSysSQLCmd);
        for (PSSysSQLCmdSQL pSSysSQLCmdSQL : arrayList) {
            PSSysSQLCmdSQL pSSysSQLCmdSQL2 = (PSSysSQLCmdSQL)this.getDEModel().createEntity();
            pSSysSQLCmdSQL2.setPSSysSQLCmdSQLId(pSSysSQLCmdSQL.getPSSysSQLCmdSQLId());
            pSSysSQLCmdSQL2.setPSSysSQLCmdId(null);
            this.update(pSSysSQLCmdSQL2);
        }
    }

    public void removeByPSSysSqlCmd(PSSysSQLCmd pSSysSQLCmd) throws Exception {
        final PSSysSQLCmd pSSysSQLCmd2 = pSSysSQLCmd;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSQLCmdSQLServiceBase.this.onBeforeRemoveByPSSysSqlCmd(pSSysSQLCmd2);
                PSSysSQLCmdSQLServiceBase.this.internalRemoveByPSSysSqlCmd(pSSysSQLCmd2);
                PSSysSQLCmdSQLServiceBase.this.onAfterRemoveByPSSysSqlCmd(pSSysSQLCmd2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSqlCmd(PSSysSQLCmd pSSysSQLCmd) throws Exception {
    }

    protected void internalRemoveByPSSysSqlCmd(PSSysSQLCmd pSSysSQLCmd) throws Exception {
        ArrayList<PSSysSQLCmdSQL> arrayList = this.selectByPSSysSqlCmd(pSSysSQLCmd);
        this.onBeforeRemoveByPSSysSqlCmd(pSSysSQLCmd, arrayList);
        for (PSSysSQLCmdSQL pSSysSQLCmdSQL : arrayList) {
            this.remove((IEntity)pSSysSQLCmdSQL);
        }
        this.onAfterRemoveByPSSysSqlCmd(pSSysSQLCmd, arrayList);
    }

    protected void onAfterRemoveByPSSysSqlCmd(PSSysSQLCmd pSSysSQLCmd) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSqlCmd(PSSysSQLCmd pSSysSQLCmd, ArrayList<PSSysSQLCmdSQL> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSqlCmd(PSSysSQLCmd pSSysSQLCmd, ArrayList<PSSysSQLCmdSQL> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysSQLCmdSQL pSSysSQLCmdSQL) throws Exception {
        super.onBeforeRemove(pSSysSQLCmdSQL);
    }

    protected void replaceParentInfo(PSSysSQLCmdSQL pSSysSQLCmdSQL, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysSQLCmdSQL, cloneSession);
        if (pSSysSQLCmdSQL.getPSSysSQLCmdId() != null && (iEntity = cloneSession.getEntity("PSSYSSQLCMD", (Object)pSSysSQLCmdSQL.getPSSysSQLCmdId())) != null) {
            this.onFillParentInfo_PSSysSqlCmd(pSSysSQLCmdSQL, (PSSysSQLCmd)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysSQLCmdSQL pSSysSQLCmdSQL, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysSQLCmdSQL, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysSQLCmdSQL pSSysSQLCmdSQL, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSSysSQLCmdSQL, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSQLCmdId(bl, pSSysSQLCmdSQL, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSQLCmdSQLId(bl, pSSysSQLCmdSQL, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSQLCmdSQLName(bl, pSSysSQLCmdSQL, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SQLCode(bl, pSSysSQLCmdSQL, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SqlCode2(bl, pSSysSQLCmdSQL, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SQLParams(bl, pSSysSQLCmdSQL, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysSQLCmdSQL, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysSQLCmdSQL, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysSQLCmdSQL, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysSQLCmdSQL, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysSQLCmdSQL, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysSQLCmdSQL, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysSQLCmdSQL pSSysSQLCmdSQL, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSQLCmdSQL.isMemoDirty() : !pSSysSQLCmdSQL.isMemoDirty()) {
            return null;
        }
        String string = pSSysSQLCmdSQL.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysSQLCmdSQL, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysSQLCmdId(boolean bl, PSSysSQLCmdSQL pSSysSQLCmdSQL, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSQLCmdSQL.isPSSysSQLCmdIdDirty() && !bl2 : !pSSysSQLCmdSQL.isPSSysSQLCmdIdDirty()) {
            return null;
        }
        String string = pSSysSQLCmdSQL.getPSSysSQLCmdId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSQLCMDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSQLCmdId_Default((IEntity)pSSysSQLCmdSQL, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSQLCMDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSQLCmdSQLId(boolean bl, PSSysSQLCmdSQL pSSysSQLCmdSQL, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSQLCmdSQL.isPSSysSQLCmdSQLIdDirty() && !bl2 : !pSSysSQLCmdSQL.isPSSysSQLCmdSQLIdDirty()) {
            return null;
        }
        String string = pSSysSQLCmdSQL.getPSSysSQLCmdSQLId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSQLCMDSQLID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSQLCmdSQLId_Default((IEntity)pSSysSQLCmdSQL, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSQLCMDSQLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSQLCmdSQLName(boolean bl, PSSysSQLCmdSQL pSSysSQLCmdSQL, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSQLCmdSQL.isPSSysSQLCmdSQLNameDirty() && !bl2 : !pSSysSQLCmdSQL.isPSSysSQLCmdSQLNameDirty()) {
            return null;
        }
        String string = pSSysSQLCmdSQL.getPSSysSQLCmdSQLName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSQLCMDSQLNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSQLCmdSQLName_Default((IEntity)pSSysSQLCmdSQL, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSQLCMDSQLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSSYSSQLCMDID";
                String string4 = this.checkFieldDupRule(this.getPSSysSQLCmdSQLDEModel(), "PSSYSSQLCMDSQLNAME", string3, pSSysSQLCmdSQL, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSSQLCMDSQLNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SQLCode(boolean bl, PSSysSQLCmdSQL pSSysSQLCmdSQL, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSQLCmdSQL.isSQLCodeDirty() && !bl2 : !pSSysSQLCmdSQL.isSQLCodeDirty()) {
            return null;
        }
        String string = pSSysSQLCmdSQL.getSQLCode();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SQLCODE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_SQLCode_Default((IEntity)pSSysSQLCmdSQL, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SQLCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SqlCode2(boolean bl, PSSysSQLCmdSQL pSSysSQLCmdSQL, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSQLCmdSQL.isSqlCode2Dirty() : !pSSysSQLCmdSQL.isSqlCode2Dirty()) {
            return null;
        }
        String string = pSSysSQLCmdSQL.getSqlCode2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SqlCode2_Default((IEntity)pSSysSQLCmdSQL, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SQLCODE2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SQLParams(boolean bl, PSSysSQLCmdSQL pSSysSQLCmdSQL, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSQLCmdSQL.isSQLParamsDirty() : !pSSysSQLCmdSQL.isSQLParamsDirty()) {
            return null;
        }
        String string = pSSysSQLCmdSQL.getSQLParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SQLParams_Default((IEntity)pSSysSQLCmdSQL, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SQLPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysSQLCmdSQL pSSysSQLCmdSQL, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSQLCmdSQL.isUserCatDirty() : !pSSysSQLCmdSQL.isUserCatDirty()) {
            return null;
        }
        String string = pSSysSQLCmdSQL.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSSysSQLCmdSQL, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysSQLCmdSQL pSSysSQLCmdSQL, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSQLCmdSQL.isUserTagDirty() : !pSSysSQLCmdSQL.isUserTagDirty()) {
            return null;
        }
        String string = pSSysSQLCmdSQL.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSSysSQLCmdSQL, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysSQLCmdSQL pSSysSQLCmdSQL, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSQLCmdSQL.isUserTag2Dirty() : !pSSysSQLCmdSQL.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysSQLCmdSQL.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSSysSQLCmdSQL, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysSQLCmdSQL pSSysSQLCmdSQL, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSQLCmdSQL.isUserTag3Dirty() : !pSSysSQLCmdSQL.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysSQLCmdSQL.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSSysSQLCmdSQL, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysSQLCmdSQL pSSysSQLCmdSQL, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSQLCmdSQL.isUserTag4Dirty() : !pSSysSQLCmdSQL.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysSQLCmdSQL.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSSysSQLCmdSQL, bl2, bl3);
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

    protected void onSyncEntity(PSSysSQLCmdSQL pSSysSQLCmdSQL, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysSQLCmdSQL, bl);
    }

    protected void onSyncIndexEntities(PSSysSQLCmdSQL pSSysSQLCmdSQL, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysSQLCmdSQL, bl);
    }

    public Object getDataContextValue(PSSysSQLCmdSQL pSSysSQLCmdSQL, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysSQLCmdSQL, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysSQLCmd pSSysSQLCmd = pSSysSQLCmdSQL.getPSSysSqlCmd();
        if (pSSysSQLCmd != null && pSSysSQLCmd.contains(string)) {
            return pSSysSQLCmd.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysSQLCmdSQL pSSysSQLCmdSQL, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysSQLCmdSQL, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSSYSSQLCMDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSQLCmdId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSQLCMDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSQLCmdName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSQLCMDSQLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSQLCmdSQLId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSQLCMDSQLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSQLCmdSQLName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SQLCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SQLCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SQLCODE2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SqlCode2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SQLPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SQLParams_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSSysSQLCmdId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSQLCMDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSQLCmdName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSQLCMDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSQLCmdSQLId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSQLCMDSQLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSQLCmdSQLName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSQLCMDSQLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SQLCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SQLCODE", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SqlCode2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SQLCODE2", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SQLParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SQLPARAMS", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
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
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysSQLCmdSQL pSSysSQLCmdSQL) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysSQLCmdSQL)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysSQLCmdSQL pSSysSQLCmdSQL) throws Exception {
        super.onUpdateParent((IEntity)pSSysSQLCmdSQL);
    }

    @Override
    protected void exportCurXmlModel(PSSysSQLCmdSQL pSSysSQLCmdSQL, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSSQLCMDSQL");
        if (!bl) {
            pSSysSQLCmdSQL.setCreateDate(null);
            pSSysSQLCmdSQL.setCreateMan(null);
            pSSysSQLCmdSQL.setPSSysSQLCmdSQLId(null);
            pSSysSQLCmdSQL.setUpdateDate(null);
            pSSysSQLCmdSQL.setUpdateMan(null);
            super.exportCurXmlModel(pSSysSQLCmdSQL, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysSQLCmdSQL pSSysSQLCmdSQL, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysSQLCmdSQL, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSSQLCMDID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSSQLCMD#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSSQLCMDID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSSQLCMDSQL_PSSYSSQLCMD_PSSYSSQLCMDID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSSQLCMDID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSSQLCMDNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSSQLCMD", (boolean)true) == 0) {
            iEntity.set("PSSYSSQLCMDID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSSQLCMDID"};
    }

    @Override
    public String getModelV2Tag(PSSysSQLCmdSQL pSSysSQLCmdSQL) {
        if (!StringHelper.isNullOrEmpty((String)pSSysSQLCmdSQL.getPSSysSQLCmdSQLName())) {
            return pSSysSQLCmdSQL.getPSSysSQLCmdSQLName();
        }
        return super.getModelV2Tag(pSSysSQLCmdSQL);
    }

    @Override
    public boolean setModelV2Tag(PSSysSQLCmdSQL pSSysSQLCmdSQL, String string) {
        return super.setModelV2Tag(pSSysSQLCmdSQL, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSSQLCMDSQLNAME", "");
        map.put("PSSYSSQLCMDID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysSQLCmdSQL pSSysSQLCmdSQL, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysSQLCmdSQL.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysSQLCmdSQL, true);
        pSSysSQLCmdSQL.set("PSSYSSQLCMDSQLNAME", string);
        if (this.select(pSSysSQLCmdSQL, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysSQLCmdSQL, true);
        return super.getModelV2Entity(pSSysSQLCmdSQL, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysSQLCmdSQL pSSysSQLCmdSQL, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSSysSQLCmdSQL, objectNode, string, string2, n);
    }
}

