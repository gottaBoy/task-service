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
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnSysSrcDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnSysSrcDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysSrc;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnSysSrcServiceBase
extends PSCoreSysServiceBase<PSDevSlnSysSrc> {
    private static final Log log = LogFactory.getLog(PSDevSlnSysSrcServiceBase.class);
    private PSDevSlnSysSrcDEModel pSDevSlnSysSrcDEModel;
    private PSDevSlnSysSrcDAO pSDevSlnSysSrcDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysSrcService";
    }

    public PSDevSlnSysSrcDEModel getPSDevSlnSysSrcDEModel() {
        if (this.pSDevSlnSysSrcDEModel == null) {
            try {
                this.pSDevSlnSysSrcDEModel = (PSDevSlnSysSrcDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnSysSrcDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnSysSrcDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevSlnSysSrcDEModel();
    }

    public PSDevSlnSysSrcDAO getPSDevSlnSysSrcDAO() {
        if (this.pSDevSlnSysSrcDAO == null) {
            try {
                this.pSDevSlnSysSrcDAO = (PSDevSlnSysSrcDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnSysSrcDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnSysSrcDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevSlnSysSrcDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    protected void onFillParentInfo(PSDevSlnSysSrc pSDevSlnSysSrc, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSSRC_PSDEVSLNSYS_PSDEVSLNSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSys pSDevSlnSys = (PSDevSlnSys)iService.getDEModel().createEntity();
            pSDevSlnSys.set("PSDEVSLNSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnSys);
            } else {
                iService.get(pSDevSlnSys);
            }
            this.onFillParentInfo_PSDevSlnSys(pSDevSlnSysSrc, pSDevSlnSys);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSSRC_PSDEVSLNSYS_SRCPSDEVSLNSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSys pSDevSlnSys = (PSDevSlnSys)iService.getDEModel().createEntity();
            pSDevSlnSys.set("PSDEVSLNSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnSys);
            } else {
                iService.get(pSDevSlnSys);
            }
            this.onFillParentInfo_SrcPSDevSlnSys(pSDevSlnSysSrc, pSDevSlnSys);
            return;
        }
        super.onFillParentInfo(pSDevSlnSysSrc, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevSlnSys(PSDevSlnSysSrc pSDevSlnSysSrc, PSDevSlnSys pSDevSlnSys) throws Exception {
        pSDevSlnSysSrc.setPSDevSlnId(pSDevSlnSys.getPSDevSlnId());
        pSDevSlnSysSrc.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
        pSDevSlnSysSrc.setPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
    }

    protected void onFillParentInfo_SrcPSDevSlnSys(PSDevSlnSysSrc pSDevSlnSysSrc, PSDevSlnSys pSDevSlnSys) throws Exception {
        pSDevSlnSysSrc.setSrcPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
        pSDevSlnSysSrc.setSrcPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
    }

    protected void onFillEntityFullInfo(PSDevSlnSysSrc pSDevSlnSysSrc, boolean bl) throws Exception {
        if (bl && pSDevSlnSysSrc.getValidFlag() == null) {
            pSDevSlnSysSrc.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSDevSlnSysSrc, bl);
        this.onFillEntityFullInfo_PSDevSlnSys(pSDevSlnSysSrc, bl);
        this.onFillEntityFullInfo_SrcPSDevSlnSys(pSDevSlnSysSrc, bl);
    }

    protected void onFillEntityFullInfo_PSDevSlnSys(PSDevSlnSysSrc pSDevSlnSysSrc, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_SrcPSDevSlnSys(PSDevSlnSysSrc pSDevSlnSysSrc, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDevSlnSysSrc pSDevSlnSysSrc, boolean bl) throws Exception {
        super.onWriteBackParent(pSDevSlnSysSrc, bl);
    }

    public ArrayList<PSDevSlnSysSrc> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, "", -1);
    }

    public ArrayList<PSDevSlnSysSrc> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, string, -1);
    }

    public ArrayList<PSDevSlnSysSrc> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnSysSrc> selectBySrcPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase) throws Exception {
        return this.selectBySrcPSDevSlnSys(pSDevSlnSysBase, "", -1);
    }

    public ArrayList<PSDevSlnSysSrc> selectBySrcPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string) throws Exception {
        return this.selectBySrcPSDevSlnSys(pSDevSlnSysBase, string, -1);
    }

    public ArrayList<PSDevSlnSysSrc> selectBySrcPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SRCPSDEVSLNSYSID", (Object)pSDevSlnSysBase.getPSDevSlnSysId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectBySrcPSDevSlnSysCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectBySrcPSDevSlnSysCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    public void resetPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnSysSrc> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        for (PSDevSlnSysSrc pSDevSlnSysSrc : arrayList) {
            PSDevSlnSysSrc pSDevSlnSysSrc2 = (PSDevSlnSysSrc)this.getDEModel().createEntity();
            pSDevSlnSysSrc2.setPSDevSlnSysSrcId(pSDevSlnSysSrc.getPSDevSlnSysSrcId());
            pSDevSlnSysSrc2.setPSDevSlnSysId(null);
            this.update(pSDevSlnSysSrc2);
        }
    }

    public void removeByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysSrcServiceBase.this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnSysSrcServiceBase.this.internalRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnSysSrcServiceBase.this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnSysSrc> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
        for (PSDevSlnSysSrc pSDevSlnSysSrc : arrayList) {
            this.remove(pSDevSlnSysSrc);
        }
        this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnSysSrc> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnSysSrc> arrayList) throws Exception {
    }

    public void testRemoveBySrcPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnSysSrc> arrayList = this.selectBySrcPSDevSlnSys(pSDevSlnSys, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNSYS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevSlnSys);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSSRC_PSDEVSLNSYS_SRCPSDEVSLNSYSID", "", iDataEntityModel.getName(), "PSDEVSLNSYSSRC", iDataEntityModel.getDataInfo(pSDevSlnSys), arrayList.get(0)));
        }
    }

    public void resetSrcPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnSysSrc> arrayList = this.selectBySrcPSDevSlnSys(pSDevSlnSys);
        for (PSDevSlnSysSrc pSDevSlnSysSrc : arrayList) {
            PSDevSlnSysSrc pSDevSlnSysSrc2 = (PSDevSlnSysSrc)this.getDEModel().createEntity();
            pSDevSlnSysSrc2.setPSDevSlnSysSrcId(pSDevSlnSysSrc.getPSDevSlnSysSrcId());
            pSDevSlnSysSrc2.setSrcPSDevSlnSysId(null);
            this.update(pSDevSlnSysSrc2);
        }
    }

    public void removeBySrcPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysSrcServiceBase.this.onBeforeRemoveBySrcPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnSysSrcServiceBase.this.internalRemoveBySrcPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnSysSrcServiceBase.this.onAfterRemoveBySrcPSDevSlnSys(pSDevSlnSys2);
            }
        });
    }

    protected void onBeforeRemoveBySrcPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void internalRemoveBySrcPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnSysSrc> arrayList = this.selectBySrcPSDevSlnSys(pSDevSlnSys);
        this.onBeforeRemoveBySrcPSDevSlnSys(pSDevSlnSys, arrayList);
        for (PSDevSlnSysSrc pSDevSlnSysSrc : arrayList) {
            this.remove(pSDevSlnSysSrc);
        }
        this.onAfterRemoveBySrcPSDevSlnSys(pSDevSlnSys, arrayList);
    }

    protected void onAfterRemoveBySrcPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void onBeforeRemoveBySrcPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnSysSrc> arrayList) throws Exception {
    }

    protected void onAfterRemoveBySrcPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnSysSrc> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevSlnSysSrc pSDevSlnSysSrc) throws Exception {
        super.onBeforeRemove(pSDevSlnSysSrc);
    }

    protected void replaceParentInfo(PSDevSlnSysSrc pSDevSlnSysSrc, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDevSlnSysSrc, cloneSession);
        if (pSDevSlnSysSrc.getPSDevSlnSysId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYS", (Object)pSDevSlnSysSrc.getPSDevSlnSysId())) != null) {
            this.onFillParentInfo_PSDevSlnSys(pSDevSlnSysSrc, (PSDevSlnSys)iEntity);
        }
        if (pSDevSlnSysSrc.getSrcPSDevSlnSysId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYS", (Object)pSDevSlnSysSrc.getSrcPSDevSlnSysId())) != null) {
            this.onFillParentInfo_SrcPSDevSlnSys(pSDevSlnSysSrc, (PSDevSlnSys)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevSlnSysSrc pSDevSlnSysSrc, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDevSlnSysSrc, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevSlnSysSrc pSDevSlnSysSrc, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSDevSlnSysSrc, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysId(bl, pSDevSlnSysSrc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysSrcId(bl, pSDevSlnSysSrc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysSrcName(bl, pSDevSlnSysSrc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SourceId(bl, pSDevSlnSysSrc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SrcPSDevSlnSysId(bl, pSDevSlnSysSrc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDevSlnSysSrc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDevSlnSysSrc, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevSlnSysSrc pSDevSlnSysSrc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysSrc.isMemoDirty() : !pSDevSlnSysSrc.isMemoDirty()) {
            return null;
        }
        String string = pSDevSlnSysSrc.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDevSlnSysSrc, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnSysId(boolean bl, PSDevSlnSysSrc pSDevSlnSysSrc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysSrc.isPSDevSlnSysIdDirty() && !bl2 : !pSDevSlnSysSrc.isPSDevSlnSysIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysSrc.getPSDevSlnSysId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysId_Default(pSDevSlnSysSrc, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnSysSrcId(boolean bl, PSDevSlnSysSrc pSDevSlnSysSrc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysSrc.isPSDevSlnSysSrcIdDirty() && !bl2 : !pSDevSlnSysSrc.isPSDevSlnSysSrcIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysSrc.getPSDevSlnSysSrcId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSSRCID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysSrcId_Default(pSDevSlnSysSrc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSSRCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysSrcName(boolean bl, PSDevSlnSysSrc pSDevSlnSysSrc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysSrc.isPSDevSlnSysSrcNameDirty() && !bl2 : !pSDevSlnSysSrc.isPSDevSlnSysSrcNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysSrc.getPSDevSlnSysSrcName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSSRCNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysSrcName_Default(pSDevSlnSysSrc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSSRCNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SourceId(boolean bl, PSDevSlnSysSrc pSDevSlnSysSrc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysSrc.isSourceIdDirty() && !bl2 : !pSDevSlnSysSrc.isSourceIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysSrc.getSourceId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SOURCEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_SourceId_Default(pSDevSlnSysSrc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SOURCEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "SRCPSDEVSLNSYSID";
                String string4 = this.checkFieldDupRule(this.getPSDevSlnSysSrcDEModel(), "SOURCEID", string3, pSDevSlnSysSrc, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("SOURCEID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SrcPSDevSlnSysId(boolean bl, PSDevSlnSysSrc pSDevSlnSysSrc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysSrc.isSrcPSDevSlnSysIdDirty() : !pSDevSlnSysSrc.isSrcPSDevSlnSysIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysSrc.getSrcPSDevSlnSysId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SrcPSDevSlnSysId_Default(pSDevSlnSysSrc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCPSDEVSLNSYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDevSlnSysSrc pSDevSlnSysSrc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysSrc.isValidFlagDirty() && !bl2 : !pSDevSlnSysSrc.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDevSlnSysSrc.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDevSlnSysSrc, bl2, bl3);
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

    protected void onSyncEntity(PSDevSlnSysSrc pSDevSlnSysSrc, boolean bl) throws Exception {
        super.onSyncEntity(pSDevSlnSysSrc, bl);
    }

    protected void onSyncIndexEntities(PSDevSlnSysSrc pSDevSlnSysSrc, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDevSlnSysSrc, bl);
    }

    public Object getDataContextValue(PSDevSlnSysSrc pSDevSlnSysSrc, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDevSlnSysSrc, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDevSlnSysSrc pSDevSlnSysSrc, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDevSlnSysSrc, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSSRCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysSrcId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSSRCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysSrcName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SOURCEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_SourceId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCPSDEVSLNSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_SrcPSDevSlnSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCPSDEVSLNSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_SrcPSDevSlnSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDevSlnId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_PSDevSlnSysSrcId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSSRCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysSrcName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSSRCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SourceId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SOURCEID", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SrcPSDevSlnSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SRCPSDEVSLNSYSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SrcPSDevSlnSysName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SRCPSDEVSLNSYSNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDevSlnSysSrc pSDevSlnSysSrc) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDevSlnSysSrc)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevSlnSysSrc pSDevSlnSysSrc) throws Exception {
        super.onUpdateParent(pSDevSlnSysSrc);
    }

    @Override
    protected void exportCurXmlModel(PSDevSlnSysSrc pSDevSlnSysSrc, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVSLNSYSSRC");
        if (!bl) {
            pSDevSlnSysSrc.setCreateDate(null);
            pSDevSlnSysSrc.setCreateMan(null);
            pSDevSlnSysSrc.setPSDevSlnSysSrcId(null);
            pSDevSlnSysSrc.setSrcPSDevSlnSysName(null);
            pSDevSlnSysSrc.setUpdateDate(null);
            pSDevSlnSysSrc.setUpdateMan(null);
            super.exportCurXmlModel(pSDevSlnSysSrc, xmlNode, bl);
        }
    }
}

