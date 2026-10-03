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
package net.ibizsys.pscore.srv.devcenter.service;

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
import net.ibizsys.pscore.srv.devcenter.dao.PSDCMobAppTDRefDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCMobAppTDRefDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMobAppTDRef;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMobAppTestDevice;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMobAppTestDeviceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCMobAppTDRefServiceBase
extends PSCoreSysServiceBase<PSDCMobAppTDRef> {
    private static final Log log = LogFactory.getLog(PSDCMobAppTDRefServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDCMobAppTDRefDEModel pSDCMobAppTDRefDEModel;
    private PSDCMobAppTDRefDAO pSDCMobAppTDRefDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCMobAppTDRefService";
    }

    public PSDCMobAppTDRefDEModel getPSDCMobAppTDRefDEModel() {
        if (this.pSDCMobAppTDRefDEModel == null) {
            try {
                this.pSDCMobAppTDRefDEModel = (PSDCMobAppTDRefDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCMobAppTDRefDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCMobAppTDRefDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDCMobAppTDRefDEModel();
    }

    public PSDCMobAppTDRefDAO getPSDCMobAppTDRefDAO() {
        if (this.pSDCMobAppTDRefDAO == null) {
            try {
                this.pSDCMobAppTDRefDAO = (PSDCMobAppTDRefDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDCMobAppTDRefDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCMobAppTDRefDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDCMobAppTDRefDAO();
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

    protected void onFillParentInfo(PSDCMobAppTDRef pSDCMobAppTDRef, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCMOBAPPTDREF_PSDCMOBAPPTESTDEVICE_PSDCMOBAPPTESTDEVICEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCMobAppTestDeviceService", (SessionFactory)this.getSessionFactory());
            PSDCMobAppTestDevice pSDCMobAppTestDevice = (PSDCMobAppTestDevice)iService.getDEModel().createEntity();
            pSDCMobAppTestDevice.set("PSDCMOBAPPTESTDEVICEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCMobAppTestDevice);
            } else {
                iService.get(pSDCMobAppTestDevice);
            }
            this.onFillParentInfo_PSDCMobAppTestDevice(pSDCMobAppTDRef, pSDCMobAppTestDevice);
            return;
        }
        super.onFillParentInfo(pSDCMobAppTDRef, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDCMobAppTestDevice(PSDCMobAppTDRef pSDCMobAppTDRef, PSDCMobAppTestDevice pSDCMobAppTestDevice) throws Exception {
        pSDCMobAppTDRef.setPSDCMobAppTestDeviceId(pSDCMobAppTestDevice.getPSDCMobAppTestDeviceId());
        pSDCMobAppTDRef.setPSDCMobAppTestDeviceName(pSDCMobAppTestDevice.getPSDCMobAppTestDeviceName());
    }

    protected boolean onFillEntityKeyValue(PSDCMobAppTDRef pSDCMobAppTDRef, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSDCMobAppTDRef.get("PSDCMOBAPPTESTDEVICEID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSDCMobAppTDRef.get("REFPSOBJTYPE");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        stringBuilderEx.append("||");
        Object object3 = pSDCMobAppTDRef.get("REFPSOBJID");
        if (object3 == null) {
            object3 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object3);
        String string = stringBuilderEx.toString();
        pSDCMobAppTDRef.set(this.getPSDCMobAppTDRefDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSDCMobAppTDRef pSDCMobAppTDRef, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDCMobAppTDRef, bl);
        this.onFillEntityFullInfo_PSDCMobAppTestDevice(pSDCMobAppTDRef, bl);
    }

    protected void onFillEntityFullInfo_PSDCMobAppTestDevice(PSDCMobAppTDRef pSDCMobAppTDRef, boolean bl) throws Exception {
        if (pSDCMobAppTDRef.isPSDCMobAppTestDeviceIdDirty()) {
            if (pSDCMobAppTDRef.getPSDCMobAppTestDeviceId() != null) {
                if (pSDCMobAppTDRef.getPSDCMobAppTestDeviceId() == null || pSDCMobAppTDRef.getPSDCMobAppTestDeviceName() == null) {
                    PSDCMobAppTestDevice pSDCMobAppTestDevice = pSDCMobAppTDRef.getPSDCMobAppTestDevice();
                    pSDCMobAppTDRef.setPSDCMobAppTestDeviceName(pSDCMobAppTestDevice.getPSDCMobAppTestDeviceName());
                }
            } else {
                pSDCMobAppTDRef.setPSDCMobAppTestDeviceName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDCMobAppTDRef pSDCMobAppTDRef, boolean bl) throws Exception {
        super.onWriteBackParent(pSDCMobAppTDRef, bl);
    }

    public ArrayList<PSDCMobAppTDRef> selectByPSDCMobAppTestDevice(PSDCMobAppTestDeviceBase pSDCMobAppTestDeviceBase) throws Exception {
        return this.selectByPSDCMobAppTestDevice(pSDCMobAppTestDeviceBase, "", -1);
    }

    public ArrayList<PSDCMobAppTDRef> selectByPSDCMobAppTestDevice(PSDCMobAppTestDeviceBase pSDCMobAppTestDeviceBase, String string) throws Exception {
        return this.selectByPSDCMobAppTestDevice(pSDCMobAppTestDeviceBase, string, -1);
    }

    public ArrayList<PSDCMobAppTDRef> selectByPSDCMobAppTestDevice(PSDCMobAppTestDeviceBase pSDCMobAppTestDeviceBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCMOBAPPTESTDEVICEID", (Object)pSDCMobAppTestDeviceBase.getPSDCMobAppTestDeviceId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCMobAppTestDeviceCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCMobAppTestDeviceCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDCMobAppTestDevice(PSDCMobAppTestDevice pSDCMobAppTestDevice) throws Exception {
        ArrayList<PSDCMobAppTDRef> arrayList = this.selectByPSDCMobAppTestDevice(pSDCMobAppTestDevice, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCMOBAPPTESTDEVICE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDCMobAppTestDevice);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCMOBAPPTDREF_PSDCMOBAPPTESTDEVICE_PSDCMOBAPPTESTDEVICEID", "", iDataEntityModel.getName(), "PSDCMOBAPPTDREF", iDataEntityModel.getDataInfo(pSDCMobAppTestDevice), arrayList.get(0)));
        }
    }

    public void resetPSDCMobAppTestDevice(PSDCMobAppTestDevice pSDCMobAppTestDevice) throws Exception {
        ArrayList<PSDCMobAppTDRef> arrayList = this.selectByPSDCMobAppTestDevice(pSDCMobAppTestDevice);
        for (PSDCMobAppTDRef pSDCMobAppTDRef : arrayList) {
            PSDCMobAppTDRef pSDCMobAppTDRef2 = (PSDCMobAppTDRef)this.getDEModel().createEntity();
            pSDCMobAppTDRef2.setPSDCMobAppTDRefId(pSDCMobAppTDRef.getPSDCMobAppTDRefId());
            pSDCMobAppTDRef2.setPSDCMobAppTestDeviceId(null);
            this.update(pSDCMobAppTDRef2);
        }
    }

    public void removeByPSDCMobAppTestDevice(PSDCMobAppTestDevice pSDCMobAppTestDevice) throws Exception {
        final PSDCMobAppTestDevice pSDCMobAppTestDevice2 = pSDCMobAppTestDevice;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCMobAppTDRefServiceBase.this.onBeforeRemoveByPSDCMobAppTestDevice(pSDCMobAppTestDevice2);
                PSDCMobAppTDRefServiceBase.this.internalRemoveByPSDCMobAppTestDevice(pSDCMobAppTestDevice2);
                PSDCMobAppTDRefServiceBase.this.onAfterRemoveByPSDCMobAppTestDevice(pSDCMobAppTestDevice2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCMobAppTestDevice(PSDCMobAppTestDevice pSDCMobAppTestDevice) throws Exception {
    }

    protected void internalRemoveByPSDCMobAppTestDevice(PSDCMobAppTestDevice pSDCMobAppTestDevice) throws Exception {
        ArrayList<PSDCMobAppTDRef> arrayList = this.selectByPSDCMobAppTestDevice(pSDCMobAppTestDevice);
        this.onBeforeRemoveByPSDCMobAppTestDevice(pSDCMobAppTestDevice, arrayList);
        for (PSDCMobAppTDRef pSDCMobAppTDRef : arrayList) {
            this.remove(pSDCMobAppTDRef);
        }
        this.onAfterRemoveByPSDCMobAppTestDevice(pSDCMobAppTestDevice, arrayList);
    }

    protected void onAfterRemoveByPSDCMobAppTestDevice(PSDCMobAppTestDevice pSDCMobAppTestDevice) throws Exception {
    }

    protected void onBeforeRemoveByPSDCMobAppTestDevice(PSDCMobAppTestDevice pSDCMobAppTestDevice, ArrayList<PSDCMobAppTDRef> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCMobAppTestDevice(PSDCMobAppTestDevice pSDCMobAppTestDevice, ArrayList<PSDCMobAppTDRef> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDCMobAppTDRef pSDCMobAppTDRef) throws Exception {
        super.onBeforeRemove(pSDCMobAppTDRef);
    }

    protected void replaceParentInfo(PSDCMobAppTDRef pSDCMobAppTDRef, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDCMobAppTDRef, cloneSession);
        if (pSDCMobAppTDRef.getPSDCMobAppTestDeviceId() != null && (iEntity = cloneSession.getEntity("PSDCMOBAPPTESTDEVICE", (Object)pSDCMobAppTDRef.getPSDCMobAppTestDeviceId())) != null) {
            this.onFillParentInfo_PSDCMobAppTestDevice(pSDCMobAppTDRef, (PSDCMobAppTestDevice)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDCMobAppTDRef pSDCMobAppTDRef, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDCMobAppTDRef, bl);
    }

    protected void onCheckEntity(boolean bl, PSDCMobAppTDRef pSDCMobAppTDRef, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSDCMobAppTDRef, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCMobAppTDRefId(bl, pSDCMobAppTDRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCMobAppTDRefName(bl, pSDCMobAppTDRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCMobAppTestDeviceId(bl, pSDCMobAppTDRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCMobAppTestDeviceName(bl, pSDCMobAppTDRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSObjId(bl, pSDCMobAppTDRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSObjName(bl, pSDCMobAppTDRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSObjType(bl, pSDCMobAppTDRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDCMobAppTDRef, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDCMobAppTDRef pSDCMobAppTDRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMobAppTDRef.isMemoDirty() : !pSDCMobAppTDRef.isMemoDirty()) {
            return null;
        }
        String string = pSDCMobAppTDRef.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDCMobAppTDRef, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCMobAppTDRefId(boolean bl, PSDCMobAppTDRef pSDCMobAppTDRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMobAppTDRef.isPSDCMobAppTDRefIdDirty() && !bl2 : !pSDCMobAppTDRef.isPSDCMobAppTDRefIdDirty()) {
            return null;
        }
        String string = pSDCMobAppTDRef.getPSDCMobAppTDRefId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMOBAPPTDREFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCMobAppTDRefId_Default(pSDCMobAppTDRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMOBAPPTDREFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCMobAppTDRefName(boolean bl, PSDCMobAppTDRef pSDCMobAppTDRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMobAppTDRef.isPSDCMobAppTDRefNameDirty() && !bl2 : !pSDCMobAppTDRef.isPSDCMobAppTDRefNameDirty()) {
            return null;
        }
        String string = pSDCMobAppTDRef.getPSDCMobAppTDRefName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMOBAPPTDREFNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCMobAppTDRefName_Default(pSDCMobAppTDRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMOBAPPTDREFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCMobAppTestDeviceId(boolean bl, PSDCMobAppTDRef pSDCMobAppTDRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMobAppTDRef.isPSDCMobAppTestDeviceIdDirty() && !bl2 : !pSDCMobAppTDRef.isPSDCMobAppTestDeviceIdDirty()) {
            return null;
        }
        String string = pSDCMobAppTDRef.getPSDCMobAppTestDeviceId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMOBAPPTESTDEVICEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCMobAppTestDeviceId_Default(pSDCMobAppTDRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMOBAPPTESTDEVICEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCMobAppTestDeviceName(boolean bl, PSDCMobAppTDRef pSDCMobAppTDRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMobAppTDRef.isPSDCMobAppTestDeviceNameDirty() && !bl2 : !pSDCMobAppTDRef.isPSDCMobAppTestDeviceNameDirty()) {
            return null;
        }
        String string = pSDCMobAppTDRef.getPSDCMobAppTestDeviceName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMOBAPPTESTDEVICENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCMobAppTestDeviceName_Default(pSDCMobAppTDRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMOBAPPTESTDEVICENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSObjId(boolean bl, PSDCMobAppTDRef pSDCMobAppTDRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMobAppTDRef.isRefPSObjIdDirty() && !bl2 : !pSDCMobAppTDRef.isRefPSObjIdDirty()) {
            return null;
        }
        String string = pSDCMobAppTDRef.getRefPSObjId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSOBJID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSObjId_Default(pSDCMobAppTDRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSOBJID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSObjName(boolean bl, PSDCMobAppTDRef pSDCMobAppTDRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMobAppTDRef.isRefPSObjNameDirty() && !bl2 : !pSDCMobAppTDRef.isRefPSObjNameDirty()) {
            return null;
        }
        String string = pSDCMobAppTDRef.getRefPSObjName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSOBJNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSObjName_Default(pSDCMobAppTDRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSOBJNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSObjType(boolean bl, PSDCMobAppTDRef pSDCMobAppTDRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMobAppTDRef.isRefPSObjTypeDirty() && !bl2 : !pSDCMobAppTDRef.isRefPSObjTypeDirty()) {
            return null;
        }
        String string = pSDCMobAppTDRef.getRefPSObjType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSOBJTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSObjType_Default(pSDCMobAppTDRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSOBJTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDCMobAppTDRef pSDCMobAppTDRef, boolean bl) throws Exception {
        super.onSyncEntity(pSDCMobAppTDRef, bl);
    }

    protected void onSyncIndexEntities(PSDCMobAppTDRef pSDCMobAppTDRef, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDCMobAppTDRef, bl);
    }

    public Object getDataContextValue(PSDCMobAppTDRef pSDCMobAppTDRef, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDCMobAppTDRef, string, iDataContextParam)) != null) {
            return object;
        }
        PSDCMobAppTestDevice pSDCMobAppTestDevice = pSDCMobAppTDRef.getPSDCMobAppTestDevice();
        if (pSDCMobAppTestDevice != null && pSDCMobAppTestDevice.contains(string)) {
            return pSDCMobAppTestDevice.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDCMobAppTDRef pSDCMobAppTDRef, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDCMobAppTDRef, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSDCMOBAPPTDREFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMobAppTDRefId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMOBAPPTDREFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMobAppTDRefName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMOBAPPTESTDEVICEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMobAppTestDeviceId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMOBAPPTESTDEVICENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMobAppTestDeviceName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSOBJID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSObjId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSOBJNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSObjName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSOBJTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSObjType_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDCMobAppTDRefId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCMOBAPPTDREFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCMobAppTDRefName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCMOBAPPTDREFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCMobAppTestDeviceId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCMOBAPPTESTDEVICEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCMobAppTestDeviceName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCMOBAPPTESTDEVICENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSObjId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSOBJID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSObjName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSOBJNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSObjType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSOBJTYPE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDCMobAppTDRef pSDCMobAppTDRef) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDCMobAppTDRef)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDCMobAppTDRef pSDCMobAppTDRef) throws Exception {
        super.onUpdateParent(pSDCMobAppTDRef);
    }

    @Override
    protected void exportCurXmlModel(PSDCMobAppTDRef pSDCMobAppTDRef, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDCMOBAPPTDREF");
        if (!bl) {
            pSDCMobAppTDRef.setCreateDate(null);
            pSDCMobAppTDRef.setCreateMan(null);
            pSDCMobAppTDRef.setPSDCMobAppTDRefId(null);
            pSDCMobAppTDRef.setUpdateDate(null);
            pSDCMobAppTDRef.setUpdateMan(null);
            super.exportCurXmlModel(pSDCMobAppTDRef, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSDCMobAppTDRef pSDCMobAppTDRef, PSSystem pSSystem) throws Exception {
        PSDCMobAppTDRef pSDCMobAppTDRef2 = new PSDCMobAppTDRef();
        pSDCMobAppTDRef2.setPSDCMobAppTestDeviceId(pSDCMobAppTDRef.getPSDCMobAppTestDeviceId());
        pSDCMobAppTDRef2.setRefPSObjType(pSDCMobAppTDRef.getRefPSObjType());
        pSDCMobAppTDRef2.setRefPSObjId(pSDCMobAppTDRef.getRefPSObjId());
        if (this.selectOne(pSDCMobAppTDRef2, true)) {
            return pSDCMobAppTDRef2.getPSDCMobAppTDRefId();
        }
        return super.getEntityFolderKeyValue(pSDCMobAppTDRef, pSSystem);
    }
}

