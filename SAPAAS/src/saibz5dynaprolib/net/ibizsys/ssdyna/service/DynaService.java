/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.der.IPSDER1N
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.core.IDERBase
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.saas.service.ServiceBase
 */
package net.ibizsys.ssdyna.service;

import java.util.Iterator;
import net.ibizsys.model.der.IPSDER1N;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.core.IDERBase;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.saas.service.ServiceBase;
import net.ibizsys.ssdyna.dao.DynaDAO;
import net.ibizsys.ssdyna.demodel.IDynaDEModel;
import net.ibizsys.ssdyna.entity.DynaEntity;
import net.ibizsys.ssdyna.service.IDynaService;
import net.ibizsys.ssdyna.sysmodel.IDynaSysModel;

public class DynaService
extends ServiceBase<DynaEntity>
implements IDynaService<DynaEntity> {
    private IDynaDEModel<DynaEntity> iDynaDEModel = null;
    private DynaDAO psJITDAO = null;

    @Override
    public void init(IDynaDEModel<DynaEntity> iDynaDEModel) throws Exception {
        this.iDynaDEModel = iDynaDEModel;
        this.psJITDAO = new DynaDAO();
        this.psJITDAO.setSessionFactory(iDynaDEModel.getDynaSysModel().getSessionFactory());
        this.psJITDAO.setDBDialect(iDynaDEModel.getDynaSysModel().getDBDialect());
        this.psJITDAO.init(iDynaDEModel);
    }

    public IDynaSysModel getDynaSysModel() {
        return this.iDynaDEModel.getDynaSysModel();
    }

    public IDataEntityModel<DynaEntity> getDEModel() {
        return this.iDynaDEModel;
    }

    public IDAO getDAO() {
        return this.psJITDAO;
    }

    protected void internalCreate(DynaEntity et) throws Exception {
        if (this.getDEModel().getInheritDEModel() != null) {
            IEntity realET = this.getDEModel().getInheritDEModel().createEntity();
            et.copyTo((IDataObject)realET, false);
            if (!StringHelper.isNullOrEmpty((String)this.getDEModel().getInheritTypeValue())) {
                realET.set(this.getDEModel().getInheritDEModel().getIndexTypeDEField().getName(), (Object)this.getDEModel().getInheritTypeValue());
            }
            IService iService = this.getDEModel().getInheritDEModel().getService(this.getSessionFactory());
            iService.create(realET, false);
            if (this.isEnableDynaStorage()) {
                this.internalCreateDynaStorage(et);
            }
            return;
        }
        super.internalCreate((IEntity)et);
    }

    protected void internalUpdate(DynaEntity et) throws Exception {
        if (this.getDEModel().getInheritDEModel() != null) {
            IEntity realET = this.getDEModel().getInheritDEModel().createEntity();
            et.copyTo((IDataObject)realET, false);
            IService iService = this.getDEModel().getInheritDEModel().getService(this.getSessionFactory());
            iService.update(realET, false);
            if (this.isEnableDynaStorage()) {
                this.internalUpdateDynaStorage(et);
            }
            return;
        }
        super.internalUpdate((IEntity)et);
    }

    protected void internalSysUpdate(DynaEntity et) throws Exception {
        if (this.getDEModel().getInheritDEModel() != null) {
            IEntity realET = this.getDEModel().getInheritDEModel().createEntity();
            et.copyTo((IDataObject)realET, false);
            IService iService = this.getDEModel().getInheritDEModel().getService(this.getSessionFactory());
            iService.sysUpdate(realET, false);
            if (this.isEnableDynaStorage()) {
                this.internalUpdateDynaStorage(et);
            }
            return;
        }
        super.internalSysUpdate((IEntity)et);
    }

    protected void internalRemove(DynaEntity et) throws Exception {
        if (this.getDEModel().getInheritDEModel() != null) {
            if (this.isEnableDynaStorage()) {
                this.internalRemoveDynaStorage(et);
            }
            IEntity realET = this.getDEModel().getInheritDEModel().createEntity();
            et.copyTo((IDataObject)realET, false);
            IService iService = this.getDEModel().getInheritDEModel().getService(this.getSessionFactory());
            iService.remove(realET);
            return;
        }
        super.internalRemove((IEntity)et);
    }

    protected CallResult internalGet(DynaEntity et, boolean bTryMode, int nViewLevel) throws Exception {
        if (this.getDEModel().getInheritDEModel() != null) {
            CallResult callResult = new CallResult();
            IEntity realET = this.getDEModel().getInheritDEModel().createEntity();
            et.copyTo((IDataObject)realET, false);
            IService iService = this.getDEModel().getInheritDEModel().getService(this.getSessionFactory());
            if (!iService.get(realET, bTryMode)) {
                callResult.setRetCode(3);
                return callResult;
            }
            realET.copyTo((IDataObject)et, false);
            if (this.isEnableDynaStorage()) {
                this.internalGetDynaStorage(et);
            }
            et.setSessionFactory(this.getSessionFactory());
            et.markFullEntity(true);
            return callResult;
        }
        return super.internalGet((IEntity)et, bTryMode, nViewLevel);
    }

    protected DBFetchResult onfetchDataSet(String strDataSetName, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dbFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, strDataSetName, false);
        return dbFetchResult;
    }

    protected DBFetchResult onfetchDataSetTemp(String strDataSetName, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dbFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, strDataSetName, true);
        return dbFetchResult;
    }

    protected void onExecuteAction(String strAction, IEntity entity) throws Exception {
        super.onExecuteAction(strAction, entity);
    }

    protected void onFillParentInfo(DynaEntity et, String strParentType, String strTypeParam, String strParentKey) throws Exception {
        Iterator dERBases = this.getDEModel().getDERs(false);
        if (dERBases != null) {
            while (dERBases.hasNext()) {
                IDERBase iPSDERBase = (IDERBase)dERBases.next();
                if (StringHelper.compare((String)iPSDERBase.getDERType(), (String)"DER1N", (boolean)false) != 0 && StringHelper.compare((String)iPSDERBase.getDERType(), (String)"DER11", (boolean)false) != 0 || StringHelper.compare((String)strParentType, (String)"DER1N", (boolean)true) != 0 && StringHelper.compare((String)strParentType, (String)"SYSDER1N", (boolean)true) != 0 && StringHelper.compare((String)strParentType, (String)"DER11", (boolean)true) != 0 && StringHelper.compare((String)strParentType, (String)"SYSDER11", (boolean)true) != 0 || StringHelper.compare((String)strTypeParam, (String)iPSDERBase.getName(), (boolean)true) != 0) continue;
                IDynaService iService = this.getDynaSysModel().getDynaService(iPSDERBase.getMajorDEId(), this.getSessionFactory());
                IEntity parentEntity = iService.getDEModel().createEntity();
                parentEntity.set(iService.getDEModel().getKeyDEField().getName(), DataTypeHelper.parse((int)iService.getDEModel().getKeyDEField().getStdDataType(), (String)strParentKey));
                if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                    iService.getTemp(parentEntity);
                } else {
                    iService.get(parentEntity);
                }
                this.onFillParentInfo_DER1N((IPSDER1N)iPSDERBase, et, parentEntity);
                return;
            }
        }
        super.onFillParentInfo((IEntity)et, strParentType, strTypeParam, strParentKey);
    }

    protected void onFillParentInfo_DER1N(IPSDER1N iPSDER1N, DynaEntity et, IEntity parentEntity) throws Exception {
    }

    @Override
    public boolean isDynaDETemplMode() {
        return false;
    }
}

