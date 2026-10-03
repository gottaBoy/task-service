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
import net.ibizsys.pscore.srv.devcenter.dao.PSDCMobAppTestDeviceDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCMobAppTestDeviceDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMobAppTestDevice;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMobAppTDRefService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCMobAppTestDeviceServiceBase
extends PSCoreSysServiceBase<PSDCMobAppTestDevice> {
    private static final Log log = LogFactory.getLog(PSDCMobAppTestDeviceServiceBase.class);
    public static final String DATASET_CURDC = "CurDC";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDCMobAppTestDeviceDEModel pSDCMobAppTestDeviceDEModel;
    private PSDCMobAppTestDeviceDAO pSDCMobAppTestDeviceDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCMobAppTestDeviceService";
    }

    public PSDCMobAppTestDeviceDEModel getPSDCMobAppTestDeviceDEModel() {
        if (this.pSDCMobAppTestDeviceDEModel == null) {
            try {
                this.pSDCMobAppTestDeviceDEModel = (PSDCMobAppTestDeviceDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCMobAppTestDeviceDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCMobAppTestDeviceDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDCMobAppTestDeviceDEModel();
    }

    public PSDCMobAppTestDeviceDAO getPSDCMobAppTestDeviceDAO() {
        if (this.pSDCMobAppTestDeviceDAO == null) {
            try {
                this.pSDCMobAppTestDeviceDAO = (PSDCMobAppTestDeviceDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDCMobAppTestDeviceDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCMobAppTestDeviceDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDCMobAppTestDeviceDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDC, (boolean)true) == 0) {
            return this.fetchCurDC(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurDC(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDC, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDCMobAppTestDevice pSDCMobAppTestDevice, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCMOBAPPTESTDEVICE_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSDCMobAppTestDevice, pSDevCenter);
            return;
        }
        super.onFillParentInfo(pSDCMobAppTestDevice, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevCenter(PSDCMobAppTestDevice pSDCMobAppTestDevice, PSDevCenter pSDevCenter) throws Exception {
        pSDCMobAppTestDevice.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDCMobAppTestDevice.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillEntityFullInfo(PSDCMobAppTestDevice pSDCMobAppTestDevice, boolean bl) throws Exception {
        if (bl && pSDCMobAppTestDevice.getValidFlag() == null) {
            pSDCMobAppTestDevice.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSDCMobAppTestDevice, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSDCMobAppTestDevice, bl);
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSDCMobAppTestDevice pSDCMobAppTestDevice, boolean bl) throws Exception {
        if (pSDCMobAppTestDevice.isPSDevCenterIdDirty()) {
            if (pSDCMobAppTestDevice.getPSDevCenterId() != null) {
                if (pSDCMobAppTestDevice.getPSDevCenterId() == null || pSDCMobAppTestDevice.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSDCMobAppTestDevice.getPSDevCenter();
                    pSDCMobAppTestDevice.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSDCMobAppTestDevice.setPSDevCenterName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDCMobAppTestDevice pSDCMobAppTestDevice, boolean bl) throws Exception {
        super.onWriteBackParent(pSDCMobAppTestDevice, bl);
    }

    public ArrayList<PSDCMobAppTestDevice> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDCMobAppTestDevice> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDCMobAppTestDevice> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVCENTERID", (Object)pSDevCenterBase.getPSDevCenterId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevCenterCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevCenterCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCMobAppTestDevice> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSDCMobAppTestDevice pSDCMobAppTestDevice : arrayList) {
            PSDCMobAppTestDevice pSDCMobAppTestDevice2 = (PSDCMobAppTestDevice)this.getDEModel().createEntity();
            pSDCMobAppTestDevice2.setPSDCMobAppTestDeviceId(pSDCMobAppTestDevice.getPSDCMobAppTestDeviceId());
            pSDCMobAppTestDevice2.setPSDevCenterId(null);
            this.update(pSDCMobAppTestDevice2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCMobAppTestDeviceServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSDCMobAppTestDeviceServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSDCMobAppTestDeviceServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCMobAppTestDevice> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSDCMobAppTestDevice pSDCMobAppTestDevice : arrayList) {
            this.remove(pSDCMobAppTestDevice);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCMobAppTestDevice> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCMobAppTestDevice> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDCMobAppTestDevice pSDCMobAppTestDevice) throws Exception {
        PSDCMobAppTDRefService pSDCMobAppTDRefService = (PSDCMobAppTDRefService)ServiceGlobal.getService(PSDCMobAppTDRefService.class, (SessionFactory)this.getSessionFactory());
        pSDCMobAppTDRefService.testRemoveByPSDCMobAppTestDevice(pSDCMobAppTestDevice);
        super.onBeforeRemove(pSDCMobAppTestDevice);
    }

    protected void replaceParentInfo(PSDCMobAppTestDevice pSDCMobAppTestDevice, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDCMobAppTestDevice, cloneSession);
        if (pSDCMobAppTestDevice.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDCMobAppTestDevice.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSDCMobAppTestDevice, (PSDevCenter)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDCMobAppTestDevice pSDCMobAppTestDevice, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDCMobAppTestDevice, bl);
    }

    protected void onCheckEntity(boolean bl, PSDCMobAppTestDevice pSDCMobAppTestDevice, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DeviceId(bl, pSDCMobAppTestDevice, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDCMobAppTestDevice, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OSType(bl, pSDCMobAppTestDevice, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OSVer(bl, pSDCMobAppTestDevice, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCMobAppTestDeviceId(bl, pSDCMobAppTestDevice, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCMobAppTestDeviceName(bl, pSDCMobAppTestDevice, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSDCMobAppTestDevice, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSDCMobAppTestDevice, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefCount(bl, pSDCMobAppTestDevice, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDCMobAppTestDevice, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDCMobAppTestDevice, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DeviceId(boolean bl, PSDCMobAppTestDevice pSDCMobAppTestDevice, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMobAppTestDevice.isDeviceIdDirty() : !pSDCMobAppTestDevice.isDeviceIdDirty()) {
            return null;
        }
        String string = pSDCMobAppTestDevice.getDeviceId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DeviceId_Default(pSDCMobAppTestDevice, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEVICEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDCMobAppTestDevice pSDCMobAppTestDevice, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMobAppTestDevice.isMemoDirty() : !pSDCMobAppTestDevice.isMemoDirty()) {
            return null;
        }
        String string = pSDCMobAppTestDevice.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDCMobAppTestDevice, bl2, bl3);
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

    protected EntityFieldError onCheckField_OSType(boolean bl, PSDCMobAppTestDevice pSDCMobAppTestDevice, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMobAppTestDevice.isOSTypeDirty() && !bl2 : !pSDCMobAppTestDevice.isOSTypeDirty()) {
            return null;
        }
        String string = pSDCMobAppTestDevice.getOSType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OSTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_OSType_Default(pSDCMobAppTestDevice, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OSTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OSVer(boolean bl, PSDCMobAppTestDevice pSDCMobAppTestDevice, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMobAppTestDevice.isOSVerDirty() && !bl2 : !pSDCMobAppTestDevice.isOSVerDirty()) {
            return null;
        }
        String string = pSDCMobAppTestDevice.getOSVer();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OSVER");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_OSVer_Default(pSDCMobAppTestDevice, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OSVER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCMobAppTestDeviceId(boolean bl, PSDCMobAppTestDevice pSDCMobAppTestDevice, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMobAppTestDevice.isPSDCMobAppTestDeviceIdDirty() && !bl2 : !pSDCMobAppTestDevice.isPSDCMobAppTestDeviceIdDirty()) {
            return null;
        }
        String string = pSDCMobAppTestDevice.getPSDCMobAppTestDeviceId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMOBAPPTESTDEVICEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCMobAppTestDeviceId_Default(pSDCMobAppTestDevice, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCMobAppTestDeviceName(boolean bl, PSDCMobAppTestDevice pSDCMobAppTestDevice, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMobAppTestDevice.isPSDCMobAppTestDeviceNameDirty() && !bl2 : !pSDCMobAppTestDevice.isPSDCMobAppTestDeviceNameDirty()) {
            return null;
        }
        String string = pSDCMobAppTestDevice.getPSDCMobAppTestDeviceName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMOBAPPTESTDEVICENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCMobAppTestDeviceName_Default(pSDCMobAppTestDevice, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSDCMobAppTestDevice pSDCMobAppTestDevice, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMobAppTestDevice.isPSDevCenterIdDirty() : !pSDCMobAppTestDevice.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSDCMobAppTestDevice.getPSDevCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default(pSDCMobAppTestDevice, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSDCMobAppTestDevice pSDCMobAppTestDevice, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMobAppTestDevice.isPSDevCenterNameDirty() : !pSDCMobAppTestDevice.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSDCMobAppTestDevice.getPSDevCenterName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default(pSDCMobAppTestDevice, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefCount(boolean bl, PSDCMobAppTestDevice pSDCMobAppTestDevice, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMobAppTestDevice.isRefCountDirty() : !pSDCMobAppTestDevice.isRefCountDirty()) {
            return null;
        }
        Integer n = pSDCMobAppTestDevice.getRefCount();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RefCount_Default(pSDCMobAppTestDevice, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFCOUNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDCMobAppTestDevice pSDCMobAppTestDevice, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMobAppTestDevice.isValidFlagDirty() && !bl2 : !pSDCMobAppTestDevice.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDCMobAppTestDevice.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDCMobAppTestDevice, bl2, bl3);
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

    protected void onSyncEntity(PSDCMobAppTestDevice pSDCMobAppTestDevice, boolean bl) throws Exception {
        super.onSyncEntity(pSDCMobAppTestDevice, bl);
    }

    protected void onSyncIndexEntities(PSDCMobAppTestDevice pSDCMobAppTestDevice, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDCMobAppTestDevice, bl);
    }

    public Object getDataContextValue(PSDCMobAppTestDevice pSDCMobAppTestDevice, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDCMobAppTestDevice, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDCMobAppTestDevice pSDCMobAppTestDevice, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDCMobAppTestDevice, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEVICEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DeviceId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OSTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OSType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OSVER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OSVer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMOBAPPTESTDEVICEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMobAppTestDeviceId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMOBAPPTESTDEVICENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMobAppTestDeviceName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFCOUNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefCount_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
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

    protected String onTestValueRule_DeviceId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEVICEID", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_OSType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OSTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OSVer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OSVER", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
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

    protected String onTestValueRule_PSDevCenterId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefCount_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected boolean onMergeChild(String string, String string2, PSDCMobAppTestDevice pSDCMobAppTestDevice) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDCMobAppTestDevice)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDCMobAppTestDevice pSDCMobAppTestDevice) throws Exception {
        super.onUpdateParent(pSDCMobAppTestDevice);
    }

    @Override
    protected void exportCurXmlModel(PSDCMobAppTestDevice pSDCMobAppTestDevice, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDCMOBAPPTESTDEVICE");
        if (!bl) {
            pSDCMobAppTestDevice.setCreateDate(null);
            pSDCMobAppTestDevice.setCreateMan(null);
            pSDCMobAppTestDevice.setPSDCMobAppTestDeviceId(null);
            pSDCMobAppTestDevice.setRefCount(null);
            pSDCMobAppTestDevice.setUpdateDate(null);
            pSDCMobAppTestDevice.setUpdateMan(null);
            super.exportCurXmlModel(pSDCMobAppTestDevice, xmlNode, bl);
        }
    }
}

