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
import net.ibizsys.pscore.srv.dynasys.dao.PSDynaWFDAO;
import net.ibizsys.pscore.srv.dynasys.demodel.PSDynaWFDEModel;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaSys;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaSysBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaWF;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaWFVerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDynaWFServiceBase
extends PSCoreSysServiceBase<PSDynaWF> {
    private static final Log log = LogFactory.getLog(PSDynaWFServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDynaWFDEModel pSDynaWFDEModel;
    private PSDynaWFDAO pSDynaWFDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dynasys.service.PSDynaWFService";
    }

    public PSDynaWFDEModel getPSDynaWFDEModel() {
        if (this.pSDynaWFDEModel == null) {
            try {
                this.pSDynaWFDEModel = (PSDynaWFDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dynasys.demodel.PSDynaWFDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDynaWFDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDynaWFDEModel();
    }

    public PSDynaWFDAO getPSDynaWFDAO() {
        if (this.pSDynaWFDAO == null) {
            try {
                this.pSDynaWFDAO = (PSDynaWFDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dynasys.dao.PSDynaWFDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDynaWFDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDynaWFDAO();
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

    protected void onFillParentInfo(PSDynaWF pSDynaWF, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDYNAWF_PSDYNASYS_PSDYNASYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaSysService", (SessionFactory)this.getSessionFactory());
            PSDynaSys pSDynaSys = (PSDynaSys)iService.getDEModel().createEntity();
            pSDynaSys.set("PSDYNASYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDynaSys);
            } else {
                iService.get((IEntity)pSDynaSys);
            }
            this.onFillParentInfo_PSDynaSys(pSDynaWF, pSDynaSys);
            return;
        }
        super.onFillParentInfo((IEntity)pSDynaWF, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDynaSys(PSDynaWF pSDynaWF, PSDynaSys pSDynaSys) throws Exception {
        pSDynaWF.setPSDynaSysId(pSDynaSys.getPSDynaSysId());
        pSDynaWF.setPSDynaSysName(pSDynaSys.getPSDynaSysName());
    }

    protected void onFillEntityFullInfo(PSDynaWF pSDynaWF, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDynaWF, bl);
        this.onFillEntityFullInfo_PSDynaSys(pSDynaWF, bl);
    }

    protected void onFillEntityFullInfo_PSDynaSys(PSDynaWF pSDynaWF, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDynaWF pSDynaWF, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDynaWF, bl);
    }

    public ArrayList<PSDynaWF> selectByPSDynaSys(PSDynaSysBase pSDynaSysBase) throws Exception {
        return this.selectByPSDynaSys(pSDynaSysBase, "", -1);
    }

    public ArrayList<PSDynaWF> selectByPSDynaSys(PSDynaSysBase pSDynaSysBase, String string) throws Exception {
        return this.selectByPSDynaSys(pSDynaSysBase, string, -1);
    }

    public ArrayList<PSDynaWF> selectByPSDynaSys(PSDynaSysBase pSDynaSysBase, String string, int n) throws Exception {
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
        ArrayList<PSDynaWF> arrayList = this.selectByPSDynaSys(pSDynaSys, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDYNASYS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDynaSys);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDYNAWF_PSDYNASYS_PSDYNASYSID", "", iDataEntityModel.getName(), "PSDYNAWF", iDataEntityModel.getDataInfo((IEntity)pSDynaSys), arrayList.get(0)));
        }
    }

    public void resetPSDynaSys(PSDynaSys pSDynaSys) throws Exception {
        ArrayList<PSDynaWF> arrayList = this.selectByPSDynaSys(pSDynaSys);
        for (PSDynaWF pSDynaWF : arrayList) {
            PSDynaWF pSDynaWF2 = (PSDynaWF)this.getDEModel().createEntity();
            pSDynaWF2.setPSDynaWFId(pSDynaWF.getPSDynaWFId());
            pSDynaWF2.setPSDynaSysId(null);
            this.update(pSDynaWF2);
        }
    }

    public void removeByPSDynaSys(PSDynaSys pSDynaSys) throws Exception {
        final PSDynaSys pSDynaSys2 = pSDynaSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDynaWFServiceBase.this.onBeforeRemoveByPSDynaSys(pSDynaSys2);
                PSDynaWFServiceBase.this.internalRemoveByPSDynaSys(pSDynaSys2);
                PSDynaWFServiceBase.this.onAfterRemoveByPSDynaSys(pSDynaSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSDynaSys(PSDynaSys pSDynaSys) throws Exception {
    }

    protected void internalRemoveByPSDynaSys(PSDynaSys pSDynaSys) throws Exception {
        ArrayList<PSDynaWF> arrayList = this.selectByPSDynaSys(pSDynaSys);
        this.onBeforeRemoveByPSDynaSys(pSDynaSys, arrayList);
        for (PSDynaWF pSDynaWF : arrayList) {
            this.remove((IEntity)pSDynaWF);
        }
        this.onAfterRemoveByPSDynaSys(pSDynaSys, arrayList);
    }

    protected void onAfterRemoveByPSDynaSys(PSDynaSys pSDynaSys) throws Exception {
    }

    protected void onBeforeRemoveByPSDynaSys(PSDynaSys pSDynaSys, ArrayList<PSDynaWF> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDynaSys(PSDynaSys pSDynaSys, ArrayList<PSDynaWF> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDynaWF pSDynaWF) throws Exception {
        PSDynaWFVerService pSDynaWFVerService = (PSDynaWFVerService)ServiceGlobal.getService(PSDynaWFVerService.class, (SessionFactory)this.getSessionFactory());
        pSDynaWFVerService.testRemoveByPSDynaWF(pSDynaWF);
        pSDynaWFVerService.removeByPSDynaWF(pSDynaWF);
        super.onBeforeRemove(pSDynaWF);
    }

    protected void replaceParentInfo(PSDynaWF pSDynaWF, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDynaWF, cloneSession);
        if (pSDynaWF.getPSDynaSysId() != null && (iEntity = cloneSession.getEntity("PSDYNASYS", (Object)pSDynaWF.getPSDynaSysId())) != null) {
            this.onFillParentInfo_PSDynaSys(pSDynaWF, (PSDynaSys)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDynaWF pSDynaWF, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDynaWF, bl);
    }

    protected void onCheckEntity(boolean bl, PSDynaWF pSDynaWF, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSDynaWF, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaSysId(bl, pSDynaWF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaWFId(bl, pSDynaWF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaWFName(bl, pSDynaWF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDynaWF, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDynaWF pSDynaWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaWF.isMemoDirty() : !pSDynaWF.isMemoDirty()) {
            return null;
        }
        String string = pSDynaWF.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDynaWF, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaSysId(boolean bl, PSDynaWF pSDynaWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaWF.isPSDynaSysIdDirty() && !bl2 : !pSDynaWF.isPSDynaSysIdDirty()) {
            return null;
        }
        String string = pSDynaWF.getPSDynaSysId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNASYSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaSysId_Default((IEntity)pSDynaWF, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaWFId(boolean bl, PSDynaWF pSDynaWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaWF.isPSDynaWFIdDirty() && !bl2 : !pSDynaWF.isPSDynaWFIdDirty()) {
            return null;
        }
        String string = pSDynaWF.getPSDynaWFId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAWFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaWFId_Default((IEntity)pSDynaWF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAWFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaWFName(boolean bl, PSDynaWF pSDynaWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaWF.isPSDynaWFNameDirty() && !bl2 : !pSDynaWF.isPSDynaWFNameDirty()) {
            return null;
        }
        String string = pSDynaWF.getPSDynaWFName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAWFNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaWFName_Default((IEntity)pSDynaWF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAWFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDynaWF pSDynaWF, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDynaWF, bl);
    }

    protected void onSyncIndexEntities(PSDynaWF pSDynaWF, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDynaWF, bl);
    }

    public Object getDataContextValue(PSDynaWF pSDynaWF, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDynaWF, string, iDataContextParam)) != null) {
            return object;
        }
        PSDynaSys pSDynaSys = pSDynaWF.getPSDynaSys();
        if (pSDynaSys != null && pSDynaSys.contains(string)) {
            return pSDynaSys.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDynaWF pSDynaWF, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDynaWF, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSDYNASYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNASYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAWFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaWFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAWFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaWFName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDynaWFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAWFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaWFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAWFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDynaWF pSDynaWF) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDynaWF)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDynaWF pSDynaWF) throws Exception {
        super.onUpdateParent((IEntity)pSDynaWF);
    }

    @Override
    protected void exportCurXmlModel(PSDynaWF pSDynaWF, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDYNAWF");
        if (!bl) {
            pSDynaWF.setCreateDate(null);
            pSDynaWF.setCreateMan(null);
            pSDynaWF.setPSDynaSysId(null);
            pSDynaWF.setPSDynaSysName(null);
            pSDynaWF.setPSDynaWFId(null);
            pSDynaWF.setUpdateDate(null);
            pSDynaWF.setUpdateMan(null);
            super.exportCurXmlModel(pSDynaWF, xmlNode, bl);
        }
    }
}

