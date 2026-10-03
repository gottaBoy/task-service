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
import net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnSysGDDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnSysGDDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysGD;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysGroupBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnSysGDServiceBase
extends PSCoreSysServiceBase<PSDevSlnSysGD> {
    private static final Log log = LogFactory.getLog(PSDevSlnSysGDServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDevSlnSysGDDEModel pSDevSlnSysGDDEModel;
    private PSDevSlnSysGDDAO pSDevSlnSysGDDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysGDService";
    }

    public PSDevSlnSysGDDEModel getPSDevSlnSysGDDEModel() {
        if (this.pSDevSlnSysGDDEModel == null) {
            try {
                this.pSDevSlnSysGDDEModel = (PSDevSlnSysGDDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnSysGDDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnSysGDDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevSlnSysGDDEModel();
    }

    public PSDevSlnSysGDDAO getPSDevSlnSysGDDAO() {
        if (this.pSDevSlnSysGDDAO == null) {
            try {
                this.pSDevSlnSysGDDAO = (PSDevSlnSysGDDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnSysGDDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnSysGDDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevSlnSysGDDAO();
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

    protected void onFillParentInfo(PSDevSlnSysGD pSDevSlnSysGD, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSGD_PSDEVSLNSYSGROUP_PSDEVSLNSYSGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysGroupService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSysGroup pSDevSlnSysGroup = (PSDevSlnSysGroup)iService.getDEModel().createEntity();
            pSDevSlnSysGroup.set("PSDEVSLNSYSGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnSysGroup);
            } else {
                iService.get(pSDevSlnSysGroup);
            }
            this.onFillParentInfo_PSDevSlnSysGroup(pSDevSlnSysGD, pSDevSlnSysGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSGD_PSDEVSLNSYS_PSDEVSLNSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSys pSDevSlnSys = (PSDevSlnSys)iService.getDEModel().createEntity();
            pSDevSlnSys.set("PSDEVSLNSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnSys);
            } else {
                iService.get(pSDevSlnSys);
            }
            this.onFillParentInfo_PSDevSlnSys(pSDevSlnSysGD, pSDevSlnSys);
            return;
        }
        super.onFillParentInfo(pSDevSlnSysGD, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevSlnSysGroup(PSDevSlnSysGD pSDevSlnSysGD, PSDevSlnSysGroup pSDevSlnSysGroup) throws Exception {
        pSDevSlnSysGD.setPSDevSlnSysGroupId(pSDevSlnSysGroup.getPSDevSlnSysGroupId());
        pSDevSlnSysGD.setPSDevSlnSysGroupName(pSDevSlnSysGroup.getPSDevSlnSysGroupName());
    }

    protected void onFillParentInfo_PSDevSlnSys(PSDevSlnSysGD pSDevSlnSysGD, PSDevSlnSys pSDevSlnSys) throws Exception {
        pSDevSlnSysGD.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
        pSDevSlnSysGD.setPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
    }

    protected boolean onFillEntityKeyValue(PSDevSlnSysGD pSDevSlnSysGD, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSDevSlnSysGD.get("PSDEVSLNSYSGROUPID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSDevSlnSysGD.get("PSDEVSLNSYSID");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSDevSlnSysGD.set(this.getPSDevSlnSysGDDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSDevSlnSysGD pSDevSlnSysGD, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDevSlnSysGD, bl);
        this.onFillEntityFullInfo_PSDevSlnSysGroup(pSDevSlnSysGD, bl);
        this.onFillEntityFullInfo_PSDevSlnSys(pSDevSlnSysGD, bl);
    }

    protected void onFillEntityFullInfo_PSDevSlnSysGroup(PSDevSlnSysGD pSDevSlnSysGD, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnSys(PSDevSlnSysGD pSDevSlnSysGD, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDevSlnSysGD pSDevSlnSysGD, boolean bl) throws Exception {
        super.onWriteBackParent(pSDevSlnSysGD, bl);
    }

    public ArrayList<PSDevSlnSysGD> selectByPSDevSlnSysGroup(PSDevSlnSysGroupBase pSDevSlnSysGroupBase) throws Exception {
        return this.selectByPSDevSlnSysGroup(pSDevSlnSysGroupBase, "", -1);
    }

    public ArrayList<PSDevSlnSysGD> selectByPSDevSlnSysGroup(PSDevSlnSysGroupBase pSDevSlnSysGroupBase, String string) throws Exception {
        return this.selectByPSDevSlnSysGroup(pSDevSlnSysGroupBase, string, -1);
    }

    public ArrayList<PSDevSlnSysGD> selectByPSDevSlnSysGroup(PSDevSlnSysGroupBase pSDevSlnSysGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNSYSGROUPID", (Object)pSDevSlnSysGroupBase.getPSDevSlnSysGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnSysGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnSysGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysGD> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, "", -1);
    }

    public ArrayList<PSDevSlnSysGD> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, string, -1);
    }

    public ArrayList<PSDevSlnSysGD> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDevSlnSysGroup(PSDevSlnSysGroup pSDevSlnSysGroup) throws Exception {
    }

    public void resetPSDevSlnSysGroup(PSDevSlnSysGroup pSDevSlnSysGroup) throws Exception {
        ArrayList<PSDevSlnSysGD> arrayList = this.selectByPSDevSlnSysGroup(pSDevSlnSysGroup);
        for (PSDevSlnSysGD pSDevSlnSysGD : arrayList) {
            PSDevSlnSysGD pSDevSlnSysGD2 = (PSDevSlnSysGD)this.getDEModel().createEntity();
            pSDevSlnSysGD2.setPSDevSlnSysGDId(pSDevSlnSysGD.getPSDevSlnSysGDId());
            pSDevSlnSysGD2.setPSDevSlnSysGroupId(null);
            this.update(pSDevSlnSysGD2);
        }
    }

    public void removeByPSDevSlnSysGroup(PSDevSlnSysGroup pSDevSlnSysGroup) throws Exception {
        final PSDevSlnSysGroup pSDevSlnSysGroup2 = pSDevSlnSysGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysGDServiceBase.this.onBeforeRemoveByPSDevSlnSysGroup(pSDevSlnSysGroup2);
                PSDevSlnSysGDServiceBase.this.internalRemoveByPSDevSlnSysGroup(pSDevSlnSysGroup2);
                PSDevSlnSysGDServiceBase.this.onAfterRemoveByPSDevSlnSysGroup(pSDevSlnSysGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSysGroup(PSDevSlnSysGroup pSDevSlnSysGroup) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSysGroup(PSDevSlnSysGroup pSDevSlnSysGroup) throws Exception {
        ArrayList<PSDevSlnSysGD> arrayList = this.selectByPSDevSlnSysGroup(pSDevSlnSysGroup);
        this.onBeforeRemoveByPSDevSlnSysGroup(pSDevSlnSysGroup, arrayList);
        for (PSDevSlnSysGD pSDevSlnSysGD : arrayList) {
            this.remove(pSDevSlnSysGD);
        }
        this.onAfterRemoveByPSDevSlnSysGroup(pSDevSlnSysGroup, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSysGroup(PSDevSlnSysGroup pSDevSlnSysGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSysGroup(PSDevSlnSysGroup pSDevSlnSysGroup, ArrayList<PSDevSlnSysGD> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSysGroup(PSDevSlnSysGroup pSDevSlnSysGroup, ArrayList<PSDevSlnSysGD> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnSysGD> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNSYS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevSlnSys);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSGD_PSDEVSLNSYS_PSDEVSLNSYSID", "", iDataEntityModel.getName(), "PSDEVSLNSYSGD", iDataEntityModel.getDataInfo(pSDevSlnSys), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnSysGD> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        for (PSDevSlnSysGD pSDevSlnSysGD : arrayList) {
            PSDevSlnSysGD pSDevSlnSysGD2 = (PSDevSlnSysGD)this.getDEModel().createEntity();
            pSDevSlnSysGD2.setPSDevSlnSysGDId(pSDevSlnSysGD.getPSDevSlnSysGDId());
            pSDevSlnSysGD2.setPSDevSlnSysId(null);
            this.update(pSDevSlnSysGD2);
        }
    }

    public void removeByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysGDServiceBase.this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnSysGDServiceBase.this.internalRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnSysGDServiceBase.this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnSysGD> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
        for (PSDevSlnSysGD pSDevSlnSysGD : arrayList) {
            this.remove(pSDevSlnSysGD);
        }
        this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnSysGD> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnSysGD> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevSlnSysGD pSDevSlnSysGD) throws Exception {
        super.onBeforeRemove(pSDevSlnSysGD);
    }

    protected void replaceParentInfo(PSDevSlnSysGD pSDevSlnSysGD, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDevSlnSysGD, cloneSession);
        if (pSDevSlnSysGD.getPSDevSlnSysGroupId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYSGROUP", (Object)pSDevSlnSysGD.getPSDevSlnSysGroupId())) != null) {
            this.onFillParentInfo_PSDevSlnSysGroup(pSDevSlnSysGD, (PSDevSlnSysGroup)iEntity);
        }
        if (pSDevSlnSysGD.getPSDevSlnSysId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYS", (Object)pSDevSlnSysGD.getPSDevSlnSysId())) != null) {
            this.onFillParentInfo_PSDevSlnSys(pSDevSlnSysGD, (PSDevSlnSys)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevSlnSysGD pSDevSlnSysGD, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDevSlnSysGD, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevSlnSysGD pSDevSlnSysGD, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSDevSlnSysGD, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysGDId(bl, pSDevSlnSysGD, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysGDName(bl, pSDevSlnSysGD, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysGroupId(bl, pSDevSlnSysGD, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysId(bl, pSDevSlnSysGD, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDevSlnSysGD, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevSlnSysGD pSDevSlnSysGD, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysGD.isMemoDirty() : !pSDevSlnSysGD.isMemoDirty()) {
            return null;
        }
        String string = pSDevSlnSysGD.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDevSlnSysGD, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnSysGDId(boolean bl, PSDevSlnSysGD pSDevSlnSysGD, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysGD.isPSDevSlnSysGDIdDirty() && !bl2 : !pSDevSlnSysGD.isPSDevSlnSysGDIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysGD.getPSDevSlnSysGDId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSGDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysGDId_Default(pSDevSlnSysGD, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSGDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysGDName(boolean bl, PSDevSlnSysGD pSDevSlnSysGD, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysGD.isPSDevSlnSysGDNameDirty() && !bl2 : !pSDevSlnSysGD.isPSDevSlnSysGDNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysGD.getPSDevSlnSysGDName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSGDNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysGDName_Default(pSDevSlnSysGD, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSGDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysGroupId(boolean bl, PSDevSlnSysGD pSDevSlnSysGD, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysGD.isPSDevSlnSysGroupIdDirty() && !bl2 : !pSDevSlnSysGD.isPSDevSlnSysGroupIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysGD.getPSDevSlnSysGroupId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSGROUPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysGroupId_Default(pSDevSlnSysGD, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysId(boolean bl, PSDevSlnSysGD pSDevSlnSysGD, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysGD.isPSDevSlnSysIdDirty() && !bl2 : !pSDevSlnSysGD.isPSDevSlnSysIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysGD.getPSDevSlnSysId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysId_Default(pSDevSlnSysGD, bl2, bl3);
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

    protected void onSyncEntity(PSDevSlnSysGD pSDevSlnSysGD, boolean bl) throws Exception {
        super.onSyncEntity(pSDevSlnSysGD, bl);
    }

    protected void onSyncIndexEntities(PSDevSlnSysGD pSDevSlnSysGD, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDevSlnSysGD, bl);
    }

    public Object getDataContextValue(PSDevSlnSysGD pSDevSlnSysGD, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDevSlnSysGD, string, iDataContextParam)) != null) {
            return object;
        }
        PSDevSlnSysGroup pSDevSlnSysGroup = pSDevSlnSysGD.getPSDevSlnSysGroup();
        if (pSDevSlnSysGroup != null && pSDevSlnSysGroup.contains(string)) {
            return pSDevSlnSysGroup.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDevSlnSysGD pSDevSlnSysGD, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDevSlnSysGD, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSGDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysGDId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSGDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysGDName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDevSlnSysGDId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSGDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysGDName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSGDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDevSlnSysGD pSDevSlnSysGD) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDevSlnSysGD)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevSlnSysGD pSDevSlnSysGD) throws Exception {
        super.onUpdateParent(pSDevSlnSysGD);
    }

    @Override
    protected void exportCurXmlModel(PSDevSlnSysGD pSDevSlnSysGD, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVSLNSYSGD");
        if (!bl) {
            pSDevSlnSysGD.setCreateDate(null);
            pSDevSlnSysGD.setCreateMan(null);
            pSDevSlnSysGD.setPSDevSlnSysGDId(null);
            pSDevSlnSysGD.setUpdateDate(null);
            pSDevSlnSysGD.setUpdateMan(null);
            super.exportCurXmlModel(pSDevSlnSysGD, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSDevSlnSysGD pSDevSlnSysGD, PSSystem pSSystem) throws Exception {
        PSDevSlnSysGD pSDevSlnSysGD2 = new PSDevSlnSysGD();
        pSDevSlnSysGD2.setPSDevSlnSysGroupId(pSDevSlnSysGD.getPSDevSlnSysGroupId());
        pSDevSlnSysGD2.setPSDevSlnSysId(pSDevSlnSysGD.getPSDevSlnSysId());
        if (this.selectOne(pSDevSlnSysGD2, true)) {
            return pSDevSlnSysGD2.getPSDevSlnSysGDId();
        }
        return super.getEntityFolderKeyValue(pSDevSlnSysGD, pSSystem);
    }
}

