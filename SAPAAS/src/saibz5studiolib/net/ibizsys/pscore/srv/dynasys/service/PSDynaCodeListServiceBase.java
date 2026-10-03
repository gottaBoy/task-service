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
package net.ibizsys.pscore.srv.dynasys.service;

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
import net.ibizsys.pscore.srv.dynasys.dao.PSDynaCodeListDAO;
import net.ibizsys.pscore.srv.dynasys.demodel.PSDynaCodeListDEModel;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaCodeList;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaSys;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaSysBase;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaCodeListInstService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaCodeListInstServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDynaCodeListServiceBase
extends PSCoreSysServiceBase<PSDynaCodeList> {
    private static final Log log = LogFactory.getLog(PSDynaCodeListServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDynaCodeListDEModel pSDynaCodeListDEModel;
    private PSDynaCodeListDAO pSDynaCodeListDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dynasys.service.PSDynaCodeListService";
    }

    public PSDynaCodeListDEModel getPSDynaCodeListDEModel() {
        if (this.pSDynaCodeListDEModel == null) {
            try {
                this.pSDynaCodeListDEModel = (PSDynaCodeListDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dynasys.demodel.PSDynaCodeListDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDynaCodeListDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDynaCodeListDEModel();
    }

    public PSDynaCodeListDAO getPSDynaCodeListDAO() {
        if (this.pSDynaCodeListDAO == null) {
            try {
                this.pSDynaCodeListDAO = (PSDynaCodeListDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dynasys.dao.PSDynaCodeListDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDynaCodeListDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDynaCodeListDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDynaCodeList pSDynaCodeList, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDYNACODELIST_PSDYNASYS_PSDYNASYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaSysService", (SessionFactory)this.getSessionFactory());
            PSDynaSys pSDynaSys = (PSDynaSys)iService.getDEModel().createEntity();
            pSDynaSys.set("PSDYNASYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDynaSys);
            } else {
                iService.get(pSDynaSys);
            }
            this.onFillParentInfo_PSDynaSys(pSDynaCodeList, pSDynaSys);
            return;
        }
        super.onFillParentInfo(pSDynaCodeList, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDynaSys(PSDynaCodeList pSDynaCodeList, PSDynaSys pSDynaSys) throws Exception {
        pSDynaCodeList.setPSDynaSysId(pSDynaSys.getPSDynaSysId());
        pSDynaCodeList.setPSDynaSysName(pSDynaSys.getPSDynaSysName());
    }

    protected void onFillEntityFullInfo(PSDynaCodeList pSDynaCodeList, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDynaCodeList, bl);
        this.onFillEntityFullInfo_PSDynaSys(pSDynaCodeList, bl);
    }

    protected void onFillEntityFullInfo_PSDynaSys(PSDynaCodeList pSDynaCodeList, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDynaCodeList pSDynaCodeList, boolean bl) throws Exception {
        super.onWriteBackParent(pSDynaCodeList, bl);
    }

    public ArrayList<PSDynaCodeList> selectByPSDynaSys(PSDynaSysBase pSDynaSysBase) throws Exception {
        return this.selectByPSDynaSys(pSDynaSysBase, "", -1);
    }

    public ArrayList<PSDynaCodeList> selectByPSDynaSys(PSDynaSysBase pSDynaSysBase, String string) throws Exception {
        return this.selectByPSDynaSys(pSDynaSysBase, string, -1);
    }

    public ArrayList<PSDynaCodeList> selectByPSDynaSys(PSDynaSysBase pSDynaSysBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDYNASYSID", (Object)pSDynaSysBase.getPSDynaSysId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDynaSysCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDynaSysCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDynaSys(PSDynaSys pSDynaSys) throws Exception {
        ArrayList<PSDynaCodeList> arrayList = this.selectByPSDynaSys(pSDynaSys, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDYNASYS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDynaSys);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDYNACODELIST_PSDYNASYS_PSDYNASYSID", "", iDataEntityModel.getName(), "PSDYNACODELIST", iDataEntityModel.getDataInfo(pSDynaSys), arrayList.get(0)));
        }
    }

    public void resetPSDynaSys(PSDynaSys pSDynaSys) throws Exception {
        ArrayList<PSDynaCodeList> arrayList = this.selectByPSDynaSys(pSDynaSys);
        for (PSDynaCodeList pSDynaCodeList : arrayList) {
            PSDynaCodeList pSDynaCodeList2 = (PSDynaCodeList)this.getDEModel().createEntity();
            pSDynaCodeList2.setPSDynaCodeListId(pSDynaCodeList.getPSDynaCodeListId());
            pSDynaCodeList2.setPSDynaSysId(null);
            this.update(pSDynaCodeList2);
        }
    }

    public void removeByPSDynaSys(PSDynaSys pSDynaSys) throws Exception {
        final PSDynaSys pSDynaSys2 = pSDynaSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDynaCodeListServiceBase.this.onBeforeRemoveByPSDynaSys(pSDynaSys2);
                PSDynaCodeListServiceBase.this.internalRemoveByPSDynaSys(pSDynaSys2);
                PSDynaCodeListServiceBase.this.onAfterRemoveByPSDynaSys(pSDynaSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSDynaSys(PSDynaSys pSDynaSys) throws Exception {
    }

    protected void internalRemoveByPSDynaSys(PSDynaSys pSDynaSys) throws Exception {
        ArrayList<PSDynaCodeList> arrayList = this.selectByPSDynaSys(pSDynaSys);
        this.onBeforeRemoveByPSDynaSys(pSDynaSys, arrayList);
        for (PSDynaCodeList pSDynaCodeList : arrayList) {
            this.remove(pSDynaCodeList);
        }
        this.onAfterRemoveByPSDynaSys(pSDynaSys, arrayList);
    }

    protected void onAfterRemoveByPSDynaSys(PSDynaSys pSDynaSys) throws Exception {
    }

    protected void onBeforeRemoveByPSDynaSys(PSDynaSys pSDynaSys, ArrayList<PSDynaCodeList> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDynaSys(PSDynaSys pSDynaSys, ArrayList<PSDynaCodeList> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDynaCodeList pSDynaCodeList) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
        ((PSCodeListServiceBase)pSCoreSysServiceBase).testRemoveByPSDynaCodeList(pSDynaCodeList);
        pSCoreSysServiceBase = (PSDynaCodeListInstService)ServiceGlobal.getService(PSDynaCodeListInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSDynaCodeListInstServiceBase)pSCoreSysServiceBase).testRemoveByPSDynaCodeList(pSDynaCodeList);
        super.onBeforeRemove(pSDynaCodeList);
    }

    protected void replaceParentInfo(PSDynaCodeList pSDynaCodeList, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDynaCodeList, cloneSession);
        if (pSDynaCodeList.getPSDynaSysId() != null && (iEntity = cloneSession.getEntity("PSDYNASYS", (Object)pSDynaCodeList.getPSDynaSysId())) != null) {
            this.onFillParentInfo_PSDynaSys(pSDynaCodeList, (PSDynaSys)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDynaCodeList pSDynaCodeList, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDynaCodeList, bl);
    }

    protected void onCheckEntity(boolean bl, PSDynaCodeList pSDynaCodeList, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_LogicName(bl, pSDynaCodeList, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDynaCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaCodeListId(bl, pSDynaCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaCodeListName(bl, pSDynaCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaSysId(bl, pSDynaCodeList, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDynaCodeList, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSDynaCodeList pSDynaCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaCodeList.isLogicNameDirty() : !pSDynaCodeList.isLogicNameDirty()) {
            return null;
        }
        String string = pSDynaCodeList.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default(pSDynaCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDynaCodeList pSDynaCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaCodeList.isMemoDirty() : !pSDynaCodeList.isMemoDirty()) {
            return null;
        }
        String string = pSDynaCodeList.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDynaCodeList, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaCodeListId(boolean bl, PSDynaCodeList pSDynaCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaCodeList.isPSDynaCodeListIdDirty() && !bl2 : !pSDynaCodeList.isPSDynaCodeListIdDirty()) {
            return null;
        }
        String string = pSDynaCodeList.getPSDynaCodeListId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNACODELISTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaCodeListId_Default(pSDynaCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNACODELISTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaCodeListName(boolean bl, PSDynaCodeList pSDynaCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaCodeList.isPSDynaCodeListNameDirty() && !bl2 : !pSDynaCodeList.isPSDynaCodeListNameDirty()) {
            return null;
        }
        String string = pSDynaCodeList.getPSDynaCodeListName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNACODELISTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaCodeListName_Default(pSDynaCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNACODELISTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaSysId(boolean bl, PSDynaCodeList pSDynaCodeList, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaCodeList.isPSDynaSysIdDirty() : !pSDynaCodeList.isPSDynaSysIdDirty()) {
            return null;
        }
        String string = pSDynaCodeList.getPSDynaSysId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaSysId_Default(pSDynaCodeList, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNASYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDynaCodeList pSDynaCodeList, boolean bl) throws Exception {
        super.onSyncEntity(pSDynaCodeList, bl);
    }

    protected void onSyncIndexEntities(PSDynaCodeList pSDynaCodeList, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDynaCodeList, bl);
    }

    public Object getDataContextValue(PSDynaCodeList pSDynaCodeList, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDynaCodeList, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDynaCodeList pSDynaCodeList, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDynaCodeList, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNACODELISTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaCodeListId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNACODELISTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaCodeListName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNASYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNASYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaSysName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_LogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSDynaCodeListId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNACODELISTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaCodeListName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNACODELISTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNASYSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaSysName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNASYSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDynaCodeList pSDynaCodeList) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDynaCodeList)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDynaCodeList pSDynaCodeList) throws Exception {
        super.onUpdateParent(pSDynaCodeList);
    }

    @Override
    protected void exportCurXmlModel(PSDynaCodeList pSDynaCodeList, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDYNACODELIST");
        if (!bl) {
            pSDynaCodeList.setCreateDate(null);
            pSDynaCodeList.setCreateMan(null);
            pSDynaCodeList.setPSDynaCodeListId(null);
            pSDynaCodeList.setPSDynaSysName(null);
            pSDynaCodeList.setUpdateDate(null);
            pSDynaCodeList.setUpdateMan(null);
            super.exportCurXmlModel(pSDynaCodeList, xmlNode, bl);
        }
    }
}

