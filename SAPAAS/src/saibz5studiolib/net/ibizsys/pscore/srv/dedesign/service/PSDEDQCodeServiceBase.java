/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
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
 *  net.ibizsys.paas.entity.EntityBase
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
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.dedesign.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
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
import net.ibizsys.paas.entity.EntityBase;
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
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEDQCodeDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEDQCodeDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCodeCond;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCodeCondBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCodeExp;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCodeExpBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQueryBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDQCodeCondService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDQCodeCondServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDQCodeExpService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDQCodeExpServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDQCodeServiceBase
extends PSCoreSysServiceBase<PSDEDQCode> {
    private static final Log log = LogFactory.getLog(PSDEDQCodeServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEDQCodeDEModel pSDEDQCodeDEModel;
    private PSDEDQCodeDAO pSDEDQCodeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEDQCodeService";
    }

    public PSDEDQCodeDEModel getPSDEDQCodeDEModel() {
        if (this.pSDEDQCodeDEModel == null) {
            try {
                this.pSDEDQCodeDEModel = (PSDEDQCodeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEDQCodeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDQCodeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEDQCodeDEModel();
    }

    public PSDEDQCodeDAO getPSDEDQCodeDAO() {
        if (this.pSDEDQCodeDAO == null) {
            try {
                this.pSDEDQCodeDAO = (PSDEDQCodeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEDQCodeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDQCodeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEDQCodeDAO();
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

    protected void onFillParentInfo(PSDEDQCode pSDEDQCode, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDQCODE_PSDEDATAQUERY_PSDEDQID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService", (SessionFactory)this.getSessionFactory());
            PSDEDataQuery pSDEDataQuery = (PSDEDataQuery)iService.getDEModel().createEntity();
            pSDEDataQuery.set("PSDEDATAQUERYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataQuery);
            } else {
                iService.get((IEntity)pSDEDataQuery);
            }
            this.onFillParentInfo_PSDEDQ(pSDEDQCode, pSDEDataQuery);
            return;
        }
        super.onFillParentInfo((IEntity)pSDEDQCode, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDEDQ(PSDEDQCode pSDEDQCode, PSDEDataQuery pSDEDataQuery) throws Exception {
        pSDEDQCode.setPSDEDQId(pSDEDataQuery.getPSDEDataQueryId());
        pSDEDQCode.setPSDEDQName(pSDEDataQuery.getPSDEDataQueryName());
    }

    protected boolean onFillEntityKeyValue(PSDEDQCode pSDEDQCode, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSDEDQCode.get("PSDEDQID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSDEDQCode.get("DBTYPE");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSDEDQCode.set(this.getPSDEDQCodeDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSDEDQCode pSDEDQCode, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDEDQCode, bl);
        this.onFillEntityFullInfo_PSDEDQ(pSDEDQCode, bl);
    }

    protected void onFillEntityFullInfo_PSDEDQ(PSDEDQCode pSDEDQCode, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEDQCode pSDEDQCode, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEDQCode, bl);
    }

    public ArrayList<PSDEDQCode> selectByPSDEDQ(PSDEDataQueryBase pSDEDataQueryBase) throws Exception {
        return this.selectByPSDEDQ(pSDEDataQueryBase, "", -1);
    }

    public ArrayList<PSDEDQCode> selectByPSDEDQ(PSDEDataQueryBase pSDEDataQueryBase, String string) throws Exception {
        return this.selectByPSDEDQ(pSDEDataQueryBase, string, -1);
    }

    public ArrayList<PSDEDQCode> selectByPSDEDQ(PSDEDataQueryBase pSDEDataQueryBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDQID", (Object)pSDEDataQueryBase.getPSDEDataQueryId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEDQCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEDQCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
    }

    public void resetPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSDEDQCode> arrayList = this.selectByPSDEDQ(pSDEDataQuery);
        for (PSDEDQCode pSDEDQCode : arrayList) {
            PSDEDQCode pSDEDQCode2 = (PSDEDQCode)this.getDEModel().createEntity();
            pSDEDQCode2.setPSDEDQCodeId(pSDEDQCode.getPSDEDQCodeId());
            pSDEDQCode2.setPSDEDQId(null);
            this.update(pSDEDQCode2);
        }
    }

    public void removeByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
        final PSDEDataQuery pSDEDataQuery2 = pSDEDataQuery;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDQCodeServiceBase.this.onBeforeRemoveByPSDEDQ(pSDEDataQuery2);
                PSDEDQCodeServiceBase.this.internalRemoveByPSDEDQ(pSDEDataQuery2);
                PSDEDQCodeServiceBase.this.onAfterRemoveByPSDEDQ(pSDEDataQuery2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
    }

    protected void internalRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSDEDQCode> arrayList = this.selectByPSDEDQ(pSDEDataQuery);
        this.onBeforeRemoveByPSDEDQ(pSDEDataQuery, arrayList);
        for (PSDEDQCode pSDEDQCode : arrayList) {
            this.remove((IEntity)pSDEDQCode);
        }
        this.onAfterRemoveByPSDEDQ(pSDEDataQuery, arrayList);
    }

    protected void onAfterRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery, ArrayList<PSDEDQCode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery, ArrayList<PSDEDQCode> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEDQCode pSDEDQCode) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEDQCodeCondService)ServiceGlobal.getService(PSDEDQCodeCondService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDQCodeCondServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDQCode(pSDEDQCode);
        ((PSDEDQCodeCondServiceBase)pSCoreSysServiceBase).removeByPSDEDQCode(pSDEDQCode);
        pSCoreSysServiceBase = (PSDEDQCodeExpService)ServiceGlobal.getService(PSDEDQCodeExpService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDQCodeExpServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDQCode(pSDEDQCode);
        ((PSDEDQCodeExpServiceBase)pSCoreSysServiceBase).removeByPSDEDQCode(pSDEDQCode);
        super.onBeforeRemove(pSDEDQCode);
    }

    protected void replaceParentInfo(PSDEDQCode pSDEDQCode, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDEDQCode, cloneSession);
        if (pSDEDQCode.getPSDEDQId() != null && (iEntity = cloneSession.getEntity("PSDEDATAQUERY", (Object)pSDEDQCode.getPSDEDQId())) != null) {
            this.onFillParentInfo_PSDEDQ(pSDEDQCode, (PSDEDataQuery)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEDQCode pSDEDQCode, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEDQCode, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEDQCode pSDEDQCode, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DBType(bl, pSDEDQCode, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEDQCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDQCodeId(bl, pSDEDQCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDQCodeName(bl, pSDEDQCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDQId(bl, pSDEDQCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_QueryCode(bl, pSDEDQCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_QueryCodeTemp(bl, pSDEDQCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserQueryCode(bl, pSDEDQCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserQueryCode2(bl, pSDEDQCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEDQCode, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DBType(boolean bl, PSDEDQCode pSDEDQCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCode.isDBTypeDirty() && !bl2 : !pSDEDQCode.isDBTypeDirty()) {
            return null;
        }
        String string = pSDEDQCode.getDBType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DBTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DBType_Default((IEntity)pSDEDQCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DBTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEDQCode pSDEDQCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCode.isMemoDirty() : !pSDEDQCode.isMemoDirty()) {
            return null;
        }
        String string = pSDEDQCode.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDEDQCode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEDQCodeId(boolean bl, PSDEDQCode pSDEDQCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCode.isPSDEDQCodeIdDirty() && !bl2 : !pSDEDQCode.isPSDEDQCodeIdDirty()) {
            return null;
        }
        String string = pSDEDQCode.getPSDEDQCodeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDQCODEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDQCodeId_Default((IEntity)pSDEDQCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDQCODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDQCodeName(boolean bl, PSDEDQCode pSDEDQCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCode.isPSDEDQCodeNameDirty() && !bl2 : !pSDEDQCode.isPSDEDQCodeNameDirty()) {
            return null;
        }
        String string = pSDEDQCode.getPSDEDQCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDQCODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDQCodeName_Default((IEntity)pSDEDQCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDQCODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDQId(boolean bl, PSDEDQCode pSDEDQCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCode.isPSDEDQIdDirty() && !bl2 : !pSDEDQCode.isPSDEDQIdDirty()) {
            return null;
        }
        String string = pSDEDQCode.getPSDEDQId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDQID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDQId_Default((IEntity)pSDEDQCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDQID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_QueryCode(boolean bl, PSDEDQCode pSDEDQCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCode.isQueryCodeDirty() : !pSDEDQCode.isQueryCodeDirty()) {
            return null;
        }
        String string = pSDEDQCode.getQueryCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_QueryCode_Default((IEntity)pSDEDQCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("QUERYCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_QueryCodeTemp(boolean bl, PSDEDQCode pSDEDQCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCode.isQueryCodeTempDirty() : !pSDEDQCode.isQueryCodeTempDirty()) {
            return null;
        }
        String string = pSDEDQCode.getQueryCodeTemp();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_QueryCodeTemp_Default((IEntity)pSDEDQCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("QUERYCODETEMP");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserQueryCode(boolean bl, PSDEDQCode pSDEDQCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCode.isUserQueryCodeDirty() : !pSDEDQCode.isUserQueryCodeDirty()) {
            return null;
        }
        String string = pSDEDQCode.getUserQueryCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserQueryCode_Default((IEntity)pSDEDQCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERQUERYCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserQueryCode2(boolean bl, PSDEDQCode pSDEDQCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCode.isUserQueryCode2Dirty() : !pSDEDQCode.isUserQueryCode2Dirty()) {
            return null;
        }
        String string = pSDEDQCode.getUserQueryCode2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserQueryCode2_Default((IEntity)pSDEDQCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERQUERYCODE2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDEDQCode pSDEDQCode, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEDQCode, bl);
    }

    protected void onSyncIndexEntities(PSDEDQCode pSDEDQCode, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEDQCode, bl);
    }

    public Object getDataContextValue(PSDEDQCode pSDEDQCode, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDEDQCode, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEDataQuery pSDEDataQuery = pSDEDQCode.getPSDEDQ();
        if (pSDEDataQuery != null && pSDEDataQuery.contains(string)) {
            return pSDEDataQuery.get(string);
        }
        return null;
    }

    protected void onExportRelatedModel(PSDEDQCode pSDEDQCode, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportRelatedModel_PSDEDQCodeCond_PSDEDQCode(pSDEDQCode, arrayList, n);
        this.onExportRelatedModel_PSDEDQCodeExp_PSDEDQCode(pSDEDQCode, arrayList, n);
        super.onExportRelatedModel((IEntity)pSDEDQCode, arrayList, n);
    }

    protected void onExportRelatedModel_PSDEDQCodeCond_PSDEDQCode(PSDEDQCode pSDEDQCode, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDEDQCodeCondService pSDEDQCodeCondService = (PSDEDQCodeCondService)ServiceGlobal.getService(PSDEDQCodeCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDQCodeCond> arrayList2 = pSDEDQCodeCondService.selectByPSDEDQCode(pSDEDQCode);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"a63ba29a6a13297f39887a66a86f3d3a");
            jSONObject.put("srfdename", (Object)"PSDEDQCODECOND");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDEDQCODECOND_PSDEDQCODE_PSDEDQCODEID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDEDQCode, (String)"PSDEDQCODEID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSDEDQCodeCond pSDEDQCodeCond : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDEDQCodeCond, (String)"srfsyspub", (int)1) == 0) continue;
            pSDEDQCodeCondService.exportModel(pSDEDQCodeCond, arrayList, n);
        }
    }

    protected void onExportRelatedModel_PSDEDQCodeExp_PSDEDQCode(PSDEDQCode pSDEDQCode, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDEDQCodeExpService pSDEDQCodeExpService = (PSDEDQCodeExpService)ServiceGlobal.getService(PSDEDQCodeExpService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDQCodeExp> arrayList2 = pSDEDQCodeExpService.selectByPSDEDQCode(pSDEDQCode);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"bf89136c010eda8f9843dc97530daf67");
            jSONObject.put("srfdename", (Object)"PSDEDQCODEEXP");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDEDQCODEEXP_PSDEDQCODE_PSDEDQCODEID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDEDQCode, (String)"PSDEDQCODEID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSDEDQCodeExp pSDEDQCodeExp : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDEDQCodeExp, (String)"srfsyspub", (int)1) == 0) continue;
            pSDEDQCodeExpService.exportModel(pSDEDQCodeExp, arrayList, n);
        }
    }

    protected void onExportMajorModel(PSDEDQCode pSDEDQCode, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDEDQCode, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DBTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DBType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDQCODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDQCodeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDQCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDQCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDQID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDQId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDQNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDQName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"QUERYCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_QueryCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"QUERYCODETEMP", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_QueryCodeTemp_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERQUERYCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserQueryCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERQUERYCODE2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserQueryCode2_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DBType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DBTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
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

    protected String onTestValueRule_PSDEDQCodeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDQCODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDQCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDQCODENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDQId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDQID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDQName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDQNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_QueryCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("QUERYCODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_QueryCodeTemp_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("QUERYCODETEMP", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected String onTestValueRule_UserQueryCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERQUERYCODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserQueryCode2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERQUERYCODE2", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSDEDQCode pSDEDQCode) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEDQCode)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEDQCode pSDEDQCode) throws Exception {
        super.onUpdateParent((IEntity)pSDEDQCode);
    }

    protected void onCopyDetails(PSDEDQCode pSDEDQCode, Object object) throws Exception {
        Object object2;
        PSDEDQCode pSDEDQCode2 = new PSDEDQCode();
        pSDEDQCode2.set("PSDEDQCODEID", object);
        String string = DataObject.getStringValue((Object)pSDEDQCode.get("PSDEDQCODEID"));
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEDQCodeCondService)ServiceGlobal.getService(PSDEDQCodeCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<EntityBase> arrayList = ((PSDEDQCodeCondServiceBase)pSCoreSysServiceBase).selectByPSDEDQCode(pSDEDQCode2);
        for (EntityBase entityBase : arrayList) {
            object2 = entityBase.get("PSDEDQCODECONDID");
            pSCoreSysServiceBase.getDraftFrom((IEntity)entityBase);
            pSCoreSysServiceBase.fillParentInfo((IEntity)entityBase, "DER1N", "DER1N_PSDEDQCODECOND_PSDEDQCODE_PSDEDQCODEID", string);
            pSCoreSysServiceBase.create(entityBase);
            pSCoreSysServiceBase.copyDetails(entityBase, object2);
        }
        pSCoreSysServiceBase = (PSDEDQCodeExpService)ServiceGlobal.getService(PSDEDQCodeExpService.class, (SessionFactory)this.getSessionFactory());
        arrayList = ((PSDEDQCodeExpServiceBase)pSCoreSysServiceBase).selectByPSDEDQCode(pSDEDQCode2);
        for (EntityBase entityBase : arrayList) {
            object2 = entityBase.get("PSDEDQCODEEXPID");
            pSCoreSysServiceBase.getDraftFrom((IEntity)entityBase);
            pSCoreSysServiceBase.fillParentInfo((IEntity)entityBase, "DER1N", "DER1N_PSDEDQCODEEXP_PSDEDQCODE_PSDEDQCODEID", string);
            pSCoreSysServiceBase.create(entityBase);
            pSCoreSysServiceBase.copyDetails(entityBase, object2);
        }
        super.onCopyDetails((IEntity)pSDEDQCode, object);
    }

    @Override
    protected void exportCurXmlModel(PSDEDQCode pSDEDQCode, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEDQCODE");
        if (!bl) {
            pSDEDQCode.setCreateDate(null);
            pSDEDQCode.setCreateMan(null);
            pSDEDQCode.setPSDEDQCodeId(null);
            pSDEDQCode.setUpdateDate(null);
            pSDEDQCode.setUpdateMan(null);
            super.exportCurXmlModel(pSDEDQCode, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSDEDQCode pSDEDQCode, PSSystem pSSystem) throws Exception {
        PSDEDQCode pSDEDQCode2 = new PSDEDQCode();
        pSDEDQCode2.setPSDEDQId(pSDEDQCode.getPSDEDQId());
        pSDEDQCode2.setDBType(pSDEDQCode.getDBType());
        if (this.selectOne((IEntity)pSDEDQCode2, true)) {
            return pSDEDQCode2.getPSDEDQCodeId();
        }
        return super.getEntityFolderKeyValue(pSDEDQCode, pSSystem);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEDQCode pSDEDQCode, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEDQCode, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEDQID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEDATAQUERY#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEDQID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEDQCODE_PSDEDATAQUERY_PSDEDQID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEDQID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEDQNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDEDATAQUERY", (boolean)true) == 0) {
            iEntity.set("PSDEDQID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDEDQID"};
    }

    @Override
    public String getModelV2Tag(PSDEDQCode pSDEDQCode) {
        if (!StringHelper.isNullOrEmpty((String)pSDEDQCode.getDBType())) {
            return pSDEDQCode.getDBType();
        }
        return super.getModelV2Tag(pSDEDQCode);
    }

    @Override
    public boolean setModelV2Tag(PSDEDQCode pSDEDQCode, String string) {
        pSDEDQCode.setDBType(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("DBTYPE", "");
        map.put("PSDEDQID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEDQCode pSDEDQCode, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEDQCode.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEDQCode, true);
        pSDEDQCode.set("DBTYPE", string);
        if (this.select(pSDEDQCode, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEDQCode, true);
        return super.getModelV2Entity(pSDEDQCode, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEDQCode pSDEDQCode, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEDQCode, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSDEDQCODEEXP_PSDEDQCODE_PSDEDQCODEID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 60;
        }
        if (StringHelper.compare((String)"DER1N_PSDEDQCODECOND_PSDEDQCODE_PSDEDQCODEID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 70;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(PSDEDQCode pSDEDQCode, String string, String string2) throws Exception {
        String string3;
        EntityBase entityBase;
        ObjectNode objectNode;
        ArrayList<String> arrayList;
        File file;
        String string4;
        String string5;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file2 = null;
        if (this.isExportRelatedModelV2("DER1N_PSDEDQCODEEXP_PSDEDQCODE_PSDEDQCODEID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEDQCODE#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSDEDQCODEEXP", (Object)pSDEDQCode.getPSDEDQCodeId()))).exists()) {
            pSCoreSysServiceBase = (PSDEDQCodeExpService)ServiceGlobal.getService(PSDEDQCodeExpService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSDEDQCodeExp();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSDEDQCodeExpServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSDEDQCodeExp)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSDEDQCODEEXP", (Object)entityBase.getPSDEDQCodeExpId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSDEDQCODECOND_PSDEDQCODE_PSDEDQCODEID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEDQCODE#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSDEDQCODECOND", (Object)pSDEDQCode.getPSDEDQCodeId()))).exists()) {
            pSCoreSysServiceBase = (PSDEDQCodeCondService)ServiceGlobal.getService(PSDEDQCodeCondService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSDEDQCodeCond();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSDEDQCodeCondServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSDEDQCodeCond)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSDEDQCODECOND", (Object)entityBase.getPSDEDQCodeCondId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        super.onExportRelatedModelV2(pSDEDQCode, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDEDQCode pSDEDQCode, ObjectNode objectNode, String string, boolean bl) throws Exception {
        Object object;
        EntityBase entityBase2;
        Object object2;
        ArrayNode arrayNode;
        Object object3;
        ArrayList<PSDEDQCodeExp> arrayList;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEDQCODEEXP_PSDEDQCODE_PSDEDQCODEID")) {
            pSCoreSysServiceBase = (PSDEDQCodeExpService)ServiceGlobal.getService(PSDEDQCodeExpService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEDQCODE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEDQCODEEXP", (Object)pSDEDQCode.getPSDEDQCodeId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object3 = PSModelV2Helper.readFile2(file);
                    arrayNode = ((ArrayList)object3).iterator();
                    while (arrayNode.hasNext()) {
                        object2 = (String)arrayNode.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add((PSDEDQCodeExp)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSDEDQCodeExp>();
                object3 = ((PSDEDQCodeExpServiceBase)pSCoreSysServiceBase).selectByPSDEDQCode(pSDEDQCode);
                arrayNode = StringHelper.format((String)"PSDEDQCODE#%1$s", (Object)pSDEDQCode.getPSDEDQCodeId());
                object2 = ((ArrayList)object3).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSDEDQCodeExp)object2.next();
                    object = ((PSDEDQCodeExpServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(arrayNode, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEDQCodeExp)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object3 = pSCoreSysServiceBase.getModelV2Name(false);
                arrayNode = objectNode.putArray(((String)object3).toLowerCase());
                Collections.sort(arrayList, new Comparator<ObjectNode>(){

                    @Override
                    public int compare(ObjectNode objectNode, ObjectNode objectNode2) {
                        int n;
                        int n2 = 1000;
                        int n3 = 1000;
                        if (objectNode.has("ordervalue")) {
                            n2 = objectNode.get("ordervalue").asInt();
                        }
                        if (objectNode2.has("ordervalue")) {
                            n3 = objectNode2.get("ordervalue").asInt();
                        }
                        if ((n = n2 - n3) != 0) {
                            return n;
                        }
                        String string = null;
                        String string2 = null;
                        if (objectNode.has("psdedqcodeexpname")) {
                            string = objectNode.get("psdedqcodeexpname").asText();
                        }
                        if (objectNode2.has("psdedqcodeexpname")) {
                            string2 = objectNode2.get("psdedqcodeexpname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSDEDQCodeExp();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    arrayNode.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEDQCODECOND_PSDEDQCODE_PSDEDQCODEID")) {
            pSCoreSysServiceBase = (PSDEDQCodeCondService)ServiceGlobal.getService(PSDEDQCodeCondService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEDQCODE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEDQCODECOND", (Object)pSDEDQCode.getPSDEDQCodeId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object3 = PSModelV2Helper.readFile2(file);
                    arrayNode = ((ArrayList)object3).iterator();
                    while (arrayNode.hasNext()) {
                        object2 = (String)arrayNode.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSDEDQCodeExp)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object3 = ((PSDEDQCodeCondServiceBase)pSCoreSysServiceBase).selectByPSDEDQCode(pSDEDQCode);
                arrayNode = StringHelper.format((String)"PSDEDQCODE#%1$s", (Object)pSDEDQCode.getPSDEDQCodeId());
                object2 = ((ArrayList)object3).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSDEDQCodeCond)object2.next();
                    object = ((PSDEDQCodeCondServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)arrayNode, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEDQCodeExp)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object3 = pSCoreSysServiceBase.getModelV2Name(false);
                arrayNode = objectNode.putArray(((String)object3).toLowerCase());
                Collections.sort(arrayList, new Comparator<ObjectNode>(){

                    @Override
                    public int compare(ObjectNode objectNode, ObjectNode objectNode2) {
                        int n;
                        int n2 = 1000;
                        int n3 = 1000;
                        if (objectNode.has("ordervalue")) {
                            n2 = objectNode.get("ordervalue").asInt();
                        }
                        if (objectNode2.has("ordervalue")) {
                            n3 = objectNode2.get("ordervalue").asInt();
                        }
                        if ((n = n2 - n3) != 0) {
                            return n;
                        }
                        String string = null;
                        String string2 = null;
                        if (objectNode.has("psdedqcodecondname")) {
                            string = objectNode.get("psdedqcodecondname").asText();
                        }
                        if (objectNode2.has("psdedqcodecondname")) {
                            string2 = objectNode2.get("psdedqcodecondname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSDEDQCodeCond();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    arrayNode.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSDEDQCode, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDEDQCode pSDEDQCode) throws Exception {
        super.onEmptyModelV2(pSDEDQCode);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEDQCodeExpService)ServiceGlobal.getService(PSDEDQCodeExpService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDEDQCodeCondService)ServiceGlobal.getService(PSDEDQCodeCondService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDEDQCode pSDEDQCode, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSDEDQCodeExp();
        entityBase.set("PSDEDQCODEID", pSDEDQCode.getPSDEDQCodeId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEDQCodeExpService)ServiceGlobal.getService(PSDEDQCodeExpService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDEDQCodeCond();
        entityBase.set("PSDEDQCODEID", pSDEDQCode.getPSDEDQCodeId());
        pSCoreSysServiceBase = (PSDEDQCodeCondService)ServiceGlobal.getService(PSDEDQCodeCondService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDEDQCode, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDEDQCode pSDEDQCode, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        EntityBase entityBase;
        Object object;
        Object object2;
        int n2;
        String string3;
        ArrayNode arrayNode;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        if (!PSDEDQCodeServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSDEDQCodeExpService)ServiceGlobal.getService(PSDEDQCodeExpService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                    object2 = (ObjectNode)arrayNode.get(n2);
                    object = new PSDEDQCodeExp();
                    ((PSDEDQCodeExpBase)object).setPSDEDQCodeId(pSDEDQCode.getPSDEDQCodeId());
                    ((PSDEDQCodeExpBase)object).setPSDEDQCodeName(pSDEDQCode.getPSDEDQCodeName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string4);
                if (((File)object2).exists()) {
                    object = ((File)object2).listFiles();
                    for (Object object3 : object) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSDEDQCodeExp();
                        entityBase.setPSDEDQCodeId(pSDEDQCode.getPSDEDQCodeId());
                        entityBase.setPSDEDQCodeName(pSDEDQCode.getPSDEDQCodeName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSDEDQCodeServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSDEDQCodeCondService)ServiceGlobal.getService(PSDEDQCodeCondService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                    object2 = (ObjectNode)arrayNode.get(n2);
                    object = new PSDEDQCodeCond();
                    ((PSDEDQCodeCondBase)object).setPSDEDQCodeId(pSDEDQCode.getPSDEDQCodeId());
                    ((PSDEDQCodeCondBase)object).setPSDEDQCodeName(pSDEDQCode.getPSDEDQCodeName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string5);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSDEDQCodeCond();
                        entityBase.setPSDEDQCodeId(pSDEDQCode.getPSDEDQCodeId());
                        entityBase.setPSDEDQCodeName(pSDEDQCode.getPSDEDQCodeName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSDEDQCode, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDEDQCode pSDEDQCode, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        Object var5_5 = null;
        return super.onPasteFile(pSDEDQCode, pSMOSFile, string, iPSMOSFileAction);
    }

    @Override
    protected void onFillPasteHelps(PSDEDQCode pSDEDQCode, List<PSHelpSection> list) throws Exception {
        super.onFillPasteHelps(pSDEDQCode, list);
    }
}

