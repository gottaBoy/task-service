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
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormBase;
import net.ibizsys.pscore.srv.dynasys.dao.PSDynaDEFormTemplDAO;
import net.ibizsys.pscore.srv.dynasys.demodel.PSDynaDEFormTemplDEModel;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDEFormTempl;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDETempl;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDETemplBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDynaDEFormTemplServiceBase
extends PSCoreSysServiceBase<PSDynaDEFormTempl> {
    private static final Log log = LogFactory.getLog(PSDynaDEFormTemplServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDynaDEFormTemplDEModel pSDynaDEFormTemplDEModel;
    private PSDynaDEFormTemplDAO pSDynaDEFormTemplDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dynasys.service.PSDynaDEFormTemplService";
    }

    public PSDynaDEFormTemplDEModel getPSDynaDEFormTemplDEModel() {
        if (this.pSDynaDEFormTemplDEModel == null) {
            try {
                this.pSDynaDEFormTemplDEModel = (PSDynaDEFormTemplDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dynasys.demodel.PSDynaDEFormTemplDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDynaDEFormTemplDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDynaDEFormTemplDEModel();
    }

    public PSDynaDEFormTemplDAO getPSDynaDEFormTemplDAO() {
        if (this.pSDynaDEFormTemplDAO == null) {
            try {
                this.pSDynaDEFormTemplDAO = (PSDynaDEFormTemplDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dynasys.dao.PSDynaDEFormTemplDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDynaDEFormTemplDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDynaDEFormTemplDAO();
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

    protected void onFillParentInfo(PSDynaDEFormTempl pSDynaDEFormTempl, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDYNADEFORMTEMPL_PSDEFORM_PSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEForm);
            } else {
                iService.get((IEntity)pSDEForm);
            }
            this.onFillParentInfo_PSDEForm(pSDynaDEFormTempl, pSDEForm);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDYNADEFORMTEMPL_PSDYNADETEMPL_PSDYNADETEMPLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaDETemplService", (SessionFactory)this.getSessionFactory());
            PSDynaDETempl pSDynaDETempl = (PSDynaDETempl)iService.getDEModel().createEntity();
            pSDynaDETempl.set("PSDYNADETEMPLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDynaDETempl);
            } else {
                iService.get((IEntity)pSDynaDETempl);
            }
            this.onFillParentInfo_PSDynaDETempl(pSDynaDEFormTempl, pSDynaDETempl);
            return;
        }
        super.onFillParentInfo((IEntity)pSDynaDEFormTempl, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDEForm(PSDynaDEFormTempl pSDynaDEFormTempl, PSDEForm pSDEForm) throws Exception {
        pSDynaDEFormTempl.setPSDEFormId(pSDEForm.getPSDEFormId());
        pSDynaDEFormTempl.setPSDEFormName(pSDEForm.getPSDEFormName());
    }

    protected void onFillParentInfo_PSDynaDETempl(PSDynaDEFormTempl pSDynaDEFormTempl, PSDynaDETempl pSDynaDETempl) throws Exception {
        pSDynaDEFormTempl.setPSDynaDETemplId(pSDynaDETempl.getPSDynaDETemplId());
        pSDynaDEFormTempl.setPSDynaDETemplName(pSDynaDETempl.getPSDynaDETemplName());
    }

    protected boolean onFillEntityKeyValue(PSDynaDEFormTempl pSDynaDEFormTempl, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSDynaDEFormTempl.get("PSDYNADETEMPLID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSDynaDEFormTempl.get("PSDEFORMID");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSDynaDEFormTempl.set(this.getPSDynaDEFormTemplDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSDynaDEFormTempl pSDynaDEFormTempl, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDynaDEFormTempl, bl);
        this.onFillEntityFullInfo_PSDEForm(pSDynaDEFormTempl, bl);
        this.onFillEntityFullInfo_PSDynaDETempl(pSDynaDEFormTempl, bl);
    }

    protected void onFillEntityFullInfo_PSDEForm(PSDynaDEFormTempl pSDynaDEFormTempl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDynaDETempl(PSDynaDEFormTempl pSDynaDEFormTempl, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDynaDEFormTempl pSDynaDEFormTempl, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDynaDEFormTempl, bl);
    }

    public ArrayList<PSDynaDEFormTempl> selectByPSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectByPSDEForm(pSDEFormBase, "", -1);
    }

    public ArrayList<PSDynaDEFormTempl> selectByPSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        return this.selectByPSDEForm(pSDEFormBase, string, -1);
    }

    public ArrayList<PSDynaDEFormTempl> selectByPSDEForm(PSDEFormBase pSDEFormBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFORMID", (Object)pSDEFormBase.getPSDEFormId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFormCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFormCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDynaDEFormTempl> selectByPSDynaDETempl(PSDynaDETemplBase pSDynaDETemplBase) throws Exception {
        return this.selectByPSDynaDETempl(pSDynaDETemplBase, "", -1);
    }

    public ArrayList<PSDynaDEFormTempl> selectByPSDynaDETempl(PSDynaDETemplBase pSDynaDETemplBase, String string) throws Exception {
        return this.selectByPSDynaDETempl(pSDynaDETemplBase, string, -1);
    }

    public ArrayList<PSDynaDEFormTempl> selectByPSDynaDETempl(PSDynaDETemplBase pSDynaDETemplBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDYNADETEMPLID", (Object)pSDynaDETemplBase.getPSDynaDETemplId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDynaDETemplCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDynaDETemplCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDynaDEFormTempl> arrayList = this.selectByPSDEForm(pSDEForm, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEForm);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDYNADEFORMTEMPL_PSDEFORM_PSDEFORMID", "", iDataEntityModel.getName(), "PSDYNADEFORMTEMPL", iDataEntityModel.getDataInfo((IEntity)pSDEForm), arrayList.get(0)));
        }
    }

    public void resetPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDynaDEFormTempl> arrayList = this.selectByPSDEForm(pSDEForm);
        for (PSDynaDEFormTempl pSDynaDEFormTempl : arrayList) {
            PSDynaDEFormTempl pSDynaDEFormTempl2 = (PSDynaDEFormTempl)this.getDEModel().createEntity();
            pSDynaDEFormTempl2.setPSDynaDEFormTemplId(pSDynaDEFormTempl.getPSDynaDEFormTemplId());
            pSDynaDEFormTempl2.setPSDEFormId(null);
            this.update(pSDynaDEFormTempl2);
        }
    }

    public void removeByPSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDynaDEFormTemplServiceBase.this.onBeforeRemoveByPSDEForm(pSDEForm2);
                PSDynaDEFormTemplServiceBase.this.internalRemoveByPSDEForm(pSDEForm2);
                PSDynaDEFormTemplServiceBase.this.onAfterRemoveByPSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDynaDEFormTempl> arrayList = this.selectByPSDEForm(pSDEForm);
        this.onBeforeRemoveByPSDEForm(pSDEForm, arrayList);
        for (PSDynaDEFormTempl pSDynaDEFormTempl : arrayList) {
            this.remove((IEntity)pSDynaDEFormTempl);
        }
        this.onAfterRemoveByPSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveByPSDEForm(PSDEForm pSDEForm, ArrayList<PSDynaDEFormTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEForm(PSDEForm pSDEForm, ArrayList<PSDynaDEFormTempl> arrayList) throws Exception {
    }

    public void testRemoveByPSDynaDETempl(PSDynaDETempl pSDynaDETempl) throws Exception {
        ArrayList<PSDynaDEFormTempl> arrayList = this.selectByPSDynaDETempl(pSDynaDETempl, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDYNADETEMPL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDynaDETempl);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDYNADEFORMTEMPL_PSDYNADETEMPL_PSDYNADETEMPLID", "", iDataEntityModel.getName(), "PSDYNADEFORMTEMPL", iDataEntityModel.getDataInfo((IEntity)pSDynaDETempl), arrayList.get(0)));
        }
    }

    public void resetPSDynaDETempl(PSDynaDETempl pSDynaDETempl) throws Exception {
        ArrayList<PSDynaDEFormTempl> arrayList = this.selectByPSDynaDETempl(pSDynaDETempl);
        for (PSDynaDEFormTempl pSDynaDEFormTempl : arrayList) {
            PSDynaDEFormTempl pSDynaDEFormTempl2 = (PSDynaDEFormTempl)this.getDEModel().createEntity();
            pSDynaDEFormTempl2.setPSDynaDEFormTemplId(pSDynaDEFormTempl.getPSDynaDEFormTemplId());
            pSDynaDEFormTempl2.setPSDynaDETemplId(null);
            this.update(pSDynaDEFormTempl2);
        }
    }

    public void removeByPSDynaDETempl(PSDynaDETempl pSDynaDETempl) throws Exception {
        final PSDynaDETempl pSDynaDETempl2 = pSDynaDETempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDynaDEFormTemplServiceBase.this.onBeforeRemoveByPSDynaDETempl(pSDynaDETempl2);
                PSDynaDEFormTemplServiceBase.this.internalRemoveByPSDynaDETempl(pSDynaDETempl2);
                PSDynaDEFormTemplServiceBase.this.onAfterRemoveByPSDynaDETempl(pSDynaDETempl2);
            }
        });
    }

    protected void onBeforeRemoveByPSDynaDETempl(PSDynaDETempl pSDynaDETempl) throws Exception {
    }

    protected void internalRemoveByPSDynaDETempl(PSDynaDETempl pSDynaDETempl) throws Exception {
        ArrayList<PSDynaDEFormTempl> arrayList = this.selectByPSDynaDETempl(pSDynaDETempl);
        this.onBeforeRemoveByPSDynaDETempl(pSDynaDETempl, arrayList);
        for (PSDynaDEFormTempl pSDynaDEFormTempl : arrayList) {
            this.remove((IEntity)pSDynaDEFormTempl);
        }
        this.onAfterRemoveByPSDynaDETempl(pSDynaDETempl, arrayList);
    }

    protected void onAfterRemoveByPSDynaDETempl(PSDynaDETempl pSDynaDETempl) throws Exception {
    }

    protected void onBeforeRemoveByPSDynaDETempl(PSDynaDETempl pSDynaDETempl, ArrayList<PSDynaDEFormTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDynaDETempl(PSDynaDETempl pSDynaDETempl, ArrayList<PSDynaDEFormTempl> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDynaDEFormTempl pSDynaDEFormTempl) throws Exception {
        super.onBeforeRemove(pSDynaDEFormTempl);
    }

    protected void replaceParentInfo(PSDynaDEFormTempl pSDynaDEFormTempl, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDynaDEFormTempl, cloneSession);
        if (pSDynaDEFormTempl.getPSDEFormId() != null && (iEntity = cloneSession.getEntity("PSDEFORM", (Object)pSDynaDEFormTempl.getPSDEFormId())) != null) {
            this.onFillParentInfo_PSDEForm(pSDynaDEFormTempl, (PSDEForm)iEntity);
        }
        if (pSDynaDEFormTempl.getPSDynaDETemplId() != null && (iEntity = cloneSession.getEntity("PSDYNADETEMPL", (Object)pSDynaDEFormTempl.getPSDynaDETemplId())) != null) {
            this.onFillParentInfo_PSDynaDETempl(pSDynaDEFormTempl, (PSDynaDETempl)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDynaDEFormTempl pSDynaDEFormTempl, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDynaDEFormTempl, bl);
    }

    protected void onCheckEntity(boolean bl, PSDynaDEFormTempl pSDynaDEFormTempl, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSDynaDEFormTempl, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFormId(bl, pSDynaDEFormTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaDEFormTemplId(bl, pSDynaDEFormTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaDEFormTemplName(bl, pSDynaDEFormTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaDETemplId(bl, pSDynaDEFormTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDynaDEFormTempl, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDynaDEFormTempl pSDynaDEFormTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaDEFormTempl.isMemoDirty() : !pSDynaDEFormTempl.isMemoDirty()) {
            return null;
        }
        String string = pSDynaDEFormTempl.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDynaDEFormTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFormId(boolean bl, PSDynaDEFormTempl pSDynaDEFormTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaDEFormTempl.isPSDEFormIdDirty() && !bl2 : !pSDynaDEFormTempl.isPSDEFormIdDirty()) {
            return null;
        }
        String string = pSDynaDEFormTempl.getPSDEFormId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFORMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFormId_Default((IEntity)pSDynaDEFormTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFORMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaDEFormTemplId(boolean bl, PSDynaDEFormTempl pSDynaDEFormTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaDEFormTempl.isPSDynaDEFormTemplIdDirty() && !bl2 : !pSDynaDEFormTempl.isPSDynaDEFormTemplIdDirty()) {
            return null;
        }
        String string = pSDynaDEFormTempl.getPSDynaDEFormTemplId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNADEFORMTEMPLID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaDEFormTemplId_Default((IEntity)pSDynaDEFormTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNADEFORMTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaDEFormTemplName(boolean bl, PSDynaDEFormTempl pSDynaDEFormTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaDEFormTempl.isPSDynaDEFormTemplNameDirty() && !bl2 : !pSDynaDEFormTempl.isPSDynaDEFormTemplNameDirty()) {
            return null;
        }
        String string = pSDynaDEFormTempl.getPSDynaDEFormTemplName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNADEFORMTEMPLNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaDEFormTemplName_Default((IEntity)pSDynaDEFormTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNADEFORMTEMPLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaDETemplId(boolean bl, PSDynaDEFormTempl pSDynaDEFormTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaDEFormTempl.isPSDynaDETemplIdDirty() && !bl2 : !pSDynaDEFormTempl.isPSDynaDETemplIdDirty()) {
            return null;
        }
        String string = pSDynaDEFormTempl.getPSDynaDETemplId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNADETEMPLID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaDETemplId_Default((IEntity)pSDynaDEFormTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNADETEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDynaDEFormTempl pSDynaDEFormTempl, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDynaDEFormTempl, bl);
    }

    protected void onSyncIndexEntities(PSDynaDEFormTempl pSDynaDEFormTempl, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDynaDEFormTempl, bl);
    }

    public Object getDataContextValue(PSDynaDEFormTempl pSDynaDEFormTempl, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDynaDEFormTempl, string, iDataContextParam)) != null) {
            return object;
        }
        PSDynaDETempl pSDynaDETempl = pSDynaDEFormTempl.getPSDynaDETempl();
        if (pSDynaDETempl != null && pSDynaDETempl.contains(string)) {
            return pSDynaDETempl.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDynaDEFormTempl pSDynaDEFormTempl, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDynaDEFormTempl, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSDEFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFormId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFormName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNADEFORMTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaDEFormTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNADEFORMTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaDEFormTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNADETEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaDETemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNADETEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaDETemplName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDEFormId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFORMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFormName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFORMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaDEFormTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNADEFORMTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaDEFormTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNADEFORMTEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaDETemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNADETEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaDETemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNADETEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDynaDEFormTempl pSDynaDEFormTempl) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDynaDEFormTempl)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDynaDEFormTempl pSDynaDEFormTempl) throws Exception {
        super.onUpdateParent((IEntity)pSDynaDEFormTempl);
    }

    @Override
    protected void exportCurXmlModel(PSDynaDEFormTempl pSDynaDEFormTempl, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDYNADEFORMTEMPL");
        if (!bl) {
            pSDynaDEFormTempl.setCreateDate(null);
            pSDynaDEFormTempl.setCreateMan(null);
            pSDynaDEFormTempl.setPSDynaDEFormTemplId(null);
            pSDynaDEFormTempl.setUpdateDate(null);
            pSDynaDEFormTempl.setUpdateMan(null);
            super.exportCurXmlModel(pSDynaDEFormTempl, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSDynaDEFormTempl pSDynaDEFormTempl, PSSystem pSSystem) throws Exception {
        PSDynaDEFormTempl pSDynaDEFormTempl2 = new PSDynaDEFormTempl();
        pSDynaDEFormTempl2.setPSDynaDETemplId(pSDynaDEFormTempl.getPSDynaDETemplId());
        pSDynaDEFormTempl2.setPSDEFormId(pSDynaDEFormTempl.getPSDEFormId());
        if (this.selectOne((IEntity)pSDynaDEFormTempl2, true)) {
            return pSDynaDEFormTempl2.getPSDynaDEFormTemplId();
        }
        return super.getEntityFolderKeyValue(pSDynaDEFormTempl, pSSystem);
    }
}

