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

import java.sql.Timestamp;
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
import net.ibizsys.pscore.srv.devcenter.dao.PSDCResRepDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCResRepDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCResRep;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCResRepServiceBase
extends PSCoreSysServiceBase<PSDCResRep> {
    private static final Log log = LogFactory.getLog(PSDCResRepServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDCResRepDEModel pSDCResRepDEModel;
    private PSDCResRepDAO pSDCResRepDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCResRepService";
    }

    public PSDCResRepDEModel getPSDCResRepDEModel() {
        if (this.pSDCResRepDEModel == null) {
            try {
                this.pSDCResRepDEModel = (PSDCResRepDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCResRepDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCResRepDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDCResRepDEModel();
    }

    public PSDCResRepDAO getPSDCResRepDAO() {
        if (this.pSDCResRepDAO == null) {
            try {
                this.pSDCResRepDAO = (PSDCResRepDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDCResRepDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCResRepDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDCResRepDAO();
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

    protected void onFillParentInfo(PSDCResRep pSDCResRep, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCRESREP_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevCenter);
            } else {
                iService.get((IEntity)pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSDCResRep, pSDevCenter);
            return;
        }
        super.onFillParentInfo((IEntity)pSDCResRep, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevCenter(PSDCResRep pSDCResRep, PSDevCenter pSDevCenter) throws Exception {
        pSDCResRep.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDCResRep.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillEntityFullInfo(PSDCResRep pSDCResRep, boolean bl) throws Exception {
        if (bl) {
            if (pSDCResRep.getASCnt() == null) {
                pSDCResRep.setASCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDCResRep.getCodeRepoCnt() == null) {
                pSDCResRep.setCodeRepoCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDCResRep.getDBInstCnt() == null) {
                pSDCResRep.setDBInstCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDCResRep.getDCBalance() == null) {
                pSDCResRep.setDCBalance((Double)this.getDefaultValue(this.getWebContext(), "", "0", 6));
            }
            if (pSDCResRep.getDefaultFlag() == null) {
                pSDCResRep.setDefaultFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDCResRep.getDevSlnCnt() == null) {
                pSDCResRep.setDevSlnCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDCResRep.getDevSysCnt() == null) {
                pSDCResRep.setDevSysCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDCResRep.getDevTemplCnt() == null) {
                pSDCResRep.setDevTemplCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDCResRep.getDiskSize() == null) {
                pSDCResRep.setDiskSize((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDCResRep.getDiskUsed() == null) {
                pSDCResRep.setDiskUsed((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDCResRep.getExpiredASCnt() == null) {
                pSDCResRep.setExpiredASCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDCResRep.getExpiredASCnt2() == null) {
                pSDCResRep.setExpiredASCnt2((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDCResRep.getExpiredCodeRepoCnt() == null) {
                pSDCResRep.setExpiredCodeRepoCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDCResRep.getExpiredCodeRepoCnt2() == null) {
                pSDCResRep.setExpiredCodeRepoCnt2((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDCResRep.getExpiredDBInstCnt() == null) {
                pSDCResRep.setExpiredDBInstCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDCResRep.getExpiredDBInstCnt2() == null) {
                pSDCResRep.setExpiredDBInstCnt2((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDCResRep.getExpiredMQInstCnt() == null) {
                pSDCResRep.setExpiredMQInstCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDCResRep.getExpiredMQInstCnt2() == null) {
                pSDCResRep.setExpiredMQInstCnt2((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDCResRep.getIdleASCnt() == null) {
                pSDCResRep.setIdleASCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDCResRep.getIdleCodeRepoCnt() == null) {
                pSDCResRep.setIdleCodeRepoCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDCResRep.getIdleDBInstCnt() == null) {
                pSDCResRep.setIdleDBInstCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDCResRep.getIdleMQInstCnt() == null) {
                pSDCResRep.setIdleMQInstCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDCResRep.getMonthNWFlowSize() == null) {
                pSDCResRep.setMonthNWFlowSize((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDCResRep.getMonthNWFlowUsed() == null) {
                pSDCResRep.setMonthNWFlowUsed((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDCResRep.getMQInstCnt() == null) {
                pSDCResRep.setMQInstCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDCResRep.getMSPCnt() == null) {
                pSDCResRep.setMSPCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDCResRep.getObj2Cnt() == null) {
                pSDCResRep.setObj2Cnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDCResRep.getObj3Cnt() == null) {
                pSDCResRep.setObj3Cnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDCResRep.getObj4Cnt() == null) {
                pSDCResRep.setObj4Cnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDCResRep.getObjCnt() == null) {
                pSDCResRep.setObjCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDCResRep.getRobotCnt() == null) {
                pSDCResRep.setRobotCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDCResRep.getSysBakCnt() == null) {
                pSDCResRep.setSysBakCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDCResRep.getUsedASCnt() == null) {
                pSDCResRep.setUsedASCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDCResRep.getUsedCodeRepoCnt() == null) {
                pSDCResRep.setUsedCodeRepoCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDCResRep.getUsedDBInstCnt() == null) {
                pSDCResRep.setUsedDBInstCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDCResRep.getUsedMQInstCnt() == null) {
                pSDCResRep.setUsedMQInstCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDCResRep.getUserASCnt() == null) {
                pSDCResRep.setUserASCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDCResRep.getUserCnt() == null) {
                pSDCResRep.setUserCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDCResRep.getUserCodeRepoCnt() == null) {
                pSDCResRep.setUserCodeRepoCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDCResRep.getUserDBInstCnt() == null) {
                pSDCResRep.setUserDBInstCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDCResRep.getUserMQInstCnt() == null) {
                pSDCResRep.setUserMQInstCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDCResRep.getWorkspaceCnt() == null) {
                pSDCResRep.setWorkspaceCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSDCResRep, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSDCResRep, bl);
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSDCResRep pSDCResRep, boolean bl) throws Exception {
        if (pSDCResRep.isPSDevCenterIdDirty()) {
            if (pSDCResRep.getPSDevCenterId() != null) {
                if (pSDCResRep.getPSDevCenterId() == null || pSDCResRep.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSDCResRep.getPSDevCenter();
                    pSDCResRep.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSDCResRep.setPSDevCenterName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDCResRep pSDCResRep, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDCResRep, bl);
    }

    public ArrayList<PSDCResRep> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDCResRep> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDCResRep> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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
        ArrayList<PSDCResRep> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSDCResRep pSDCResRep : arrayList) {
            PSDCResRep pSDCResRep2 = (PSDCResRep)this.getDEModel().createEntity();
            pSDCResRep2.setPSDCResRepId(pSDCResRep.getPSDCResRepId());
            pSDCResRep2.setPSDevCenterId(null);
            this.update(pSDCResRep2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCResRepServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSDCResRepServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSDCResRepServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCResRep> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSDCResRep pSDCResRep : arrayList) {
            this.remove((IEntity)pSDCResRep);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCResRep> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCResRep> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDCResRep pSDCResRep) throws Exception {
        super.onBeforeRemove(pSDCResRep);
    }

    protected void replaceParentInfo(PSDCResRep pSDCResRep, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDCResRep, cloneSession);
        if (pSDCResRep.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDCResRep.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSDCResRep, (PSDevCenter)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDCResRep pSDCResRep, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDCResRep, bl);
    }

    protected void onCheckEntity(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ASCnt(bl, pSDCResRep, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeRepoCnt(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Content(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DBInstCnt(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DCBalance(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultFlag(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DepInstCnt(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DevSlnCnt(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DevSysCnt(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DevTemplCnt(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DiskSize(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DiskUsed(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaInstCnt(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExpiredASCnt(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExpiredASCnt2(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExpiredCodeRepoCnt(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExpiredCodeRepoCnt2(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExpiredDBInstCnt(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExpiredDBInstCnt2(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExpiredMQInstCnt(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExpiredMQInstCnt2(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IdleASCnt(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IdleCodeRepoCnt(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IdleDBInstCnt(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IdleMQInstCnt(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MonthNWFlowSize(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MonthNWFlowUsed(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MQInstCnt(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MSPCnt(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Obj2Cnt(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Obj3Cnt(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Obj4Cnt(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ObjCnt(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCResRepId(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCResRepName(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ReportUrl(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RepTime(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RobotCnt(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysBakCnt(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UsedASCnt(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UsedCodeRepoCnt(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UsedDBInstCnt(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UsedMQInstCnt(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserASCnt(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCnt(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCodeRepoCnt(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserDBInstCnt(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserMQInstCnt(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WorkspaceCnt(bl, pSDCResRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDCResRep, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ASCnt(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isASCntDirty() : !pSDCResRep.isASCntDirty()) {
            return null;
        }
        Integer n = pSDCResRep.getASCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ASCnt_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ASCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeRepoCnt(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isCodeRepoCntDirty() : !pSDCResRep.isCodeRepoCntDirty()) {
            return null;
        }
        Integer n = pSDCResRep.getCodeRepoCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CodeRepoCnt_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODEREPOCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Content(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isContentDirty() : !pSDCResRep.isContentDirty()) {
            return null;
        }
        String string = pSDCResRep.getContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Content_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DBInstCnt(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isDBInstCntDirty() : !pSDCResRep.isDBInstCntDirty()) {
            return null;
        }
        Integer n = pSDCResRep.getDBInstCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DBInstCnt_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DBINSTCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DCBalance(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isDCBalanceDirty() : !pSDCResRep.isDCBalanceDirty()) {
            return null;
        }
        Double d = pSDCResRep.getDCBalance();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DCBalance_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DCBALANCE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefaultFlag(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isDefaultFlagDirty() && !bl2 : !pSDCResRep.isDefaultFlagDirty()) {
            return null;
        }
        Integer n = pSDCResRep.getDefaultFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_DefaultFlag_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            bl4 = DataTypeHelper.compare((int)9, (Object)n, (Object)"1") == 0L;
            if (bl4) {
                String string = "";
                string = "PSDEVCENTERID";
                String string2 = this.checkFieldDupRule(this.getPSDCResRepDEModel(), "DEFAULTFLAG", string, pSDCResRep, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("DEFAULTFLAG");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string2);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DepInstCnt(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isDepInstCntDirty() : !pSDCResRep.isDepInstCntDirty()) {
            return null;
        }
        Integer n = pSDCResRep.getDepInstCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DepInstCnt_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEPINSTCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DevSlnCnt(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isDevSlnCntDirty() : !pSDCResRep.isDevSlnCntDirty()) {
            return null;
        }
        Integer n = pSDCResRep.getDevSlnCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DevSlnCnt_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEVSLNCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DevSysCnt(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isDevSysCntDirty() : !pSDCResRep.isDevSysCntDirty()) {
            return null;
        }
        Integer n = pSDCResRep.getDevSysCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DevSysCnt_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEVSYSCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DevTemplCnt(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isDevTemplCntDirty() : !pSDCResRep.isDevTemplCntDirty()) {
            return null;
        }
        Integer n = pSDCResRep.getDevTemplCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DevTemplCnt_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEVTEMPLCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DiskSize(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isDiskSizeDirty() : !pSDCResRep.isDiskSizeDirty()) {
            return null;
        }
        Integer n = pSDCResRep.getDiskSize();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DiskSize_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DISKSIZE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DiskUsed(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isDiskUsedDirty() : !pSDCResRep.isDiskUsedDirty()) {
            return null;
        }
        Integer n = pSDCResRep.getDiskUsed();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DiskUsed_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DISKUSED");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaInstCnt(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isDynaInstCntDirty() : !pSDCResRep.isDynaInstCntDirty()) {
            return null;
        }
        Integer n = pSDCResRep.getDynaInstCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaInstCnt_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNAINSTCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExpiredASCnt(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isExpiredASCntDirty() : !pSDCResRep.isExpiredASCntDirty()) {
            return null;
        }
        Integer n = pSDCResRep.getExpiredASCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExpiredASCnt_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPIREDASCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExpiredASCnt2(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isExpiredASCnt2Dirty() : !pSDCResRep.isExpiredASCnt2Dirty()) {
            return null;
        }
        Integer n = pSDCResRep.getExpiredASCnt2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExpiredASCnt2_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPIREDASCNT2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExpiredCodeRepoCnt(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isExpiredCodeRepoCntDirty() : !pSDCResRep.isExpiredCodeRepoCntDirty()) {
            return null;
        }
        Integer n = pSDCResRep.getExpiredCodeRepoCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExpiredCodeRepoCnt_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPIREDCODEREPOCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExpiredCodeRepoCnt2(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isExpiredCodeRepoCnt2Dirty() : !pSDCResRep.isExpiredCodeRepoCnt2Dirty()) {
            return null;
        }
        Integer n = pSDCResRep.getExpiredCodeRepoCnt2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExpiredCodeRepoCnt2_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPIREDCODEREPOCNT2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExpiredDBInstCnt(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isExpiredDBInstCntDirty() : !pSDCResRep.isExpiredDBInstCntDirty()) {
            return null;
        }
        Integer n = pSDCResRep.getExpiredDBInstCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExpiredDBInstCnt_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPIREDDBINSTCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExpiredDBInstCnt2(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isExpiredDBInstCnt2Dirty() : !pSDCResRep.isExpiredDBInstCnt2Dirty()) {
            return null;
        }
        Integer n = pSDCResRep.getExpiredDBInstCnt2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExpiredDBInstCnt2_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPIREDDBINSTCNT2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExpiredMQInstCnt(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isExpiredMQInstCntDirty() : !pSDCResRep.isExpiredMQInstCntDirty()) {
            return null;
        }
        Integer n = pSDCResRep.getExpiredMQInstCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExpiredMQInstCnt_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPIREDMQINSTCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExpiredMQInstCnt2(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isExpiredMQInstCnt2Dirty() : !pSDCResRep.isExpiredMQInstCnt2Dirty()) {
            return null;
        }
        Integer n = pSDCResRep.getExpiredMQInstCnt2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExpiredMQInstCnt2_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPIREDMQINSTCNT2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IdleASCnt(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isIdleASCntDirty() : !pSDCResRep.isIdleASCntDirty()) {
            return null;
        }
        Integer n = pSDCResRep.getIdleASCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_IdleASCnt_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IDLEASCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IdleCodeRepoCnt(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isIdleCodeRepoCntDirty() : !pSDCResRep.isIdleCodeRepoCntDirty()) {
            return null;
        }
        Integer n = pSDCResRep.getIdleCodeRepoCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_IdleCodeRepoCnt_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IDLECODEREPOCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IdleDBInstCnt(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isIdleDBInstCntDirty() : !pSDCResRep.isIdleDBInstCntDirty()) {
            return null;
        }
        Integer n = pSDCResRep.getIdleDBInstCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_IdleDBInstCnt_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IDLEDBINSTCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IdleMQInstCnt(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isIdleMQInstCntDirty() : !pSDCResRep.isIdleMQInstCntDirty()) {
            return null;
        }
        Integer n = pSDCResRep.getIdleMQInstCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_IdleMQInstCnt_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IDLEMQINSTCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isMemoDirty() : !pSDCResRep.isMemoDirty()) {
            return null;
        }
        String string = pSDCResRep.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDCResRep, bl2, bl3);
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

    protected EntityFieldError onCheckField_MonthNWFlowSize(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isMonthNWFlowSizeDirty() : !pSDCResRep.isMonthNWFlowSizeDirty()) {
            return null;
        }
        Integer n = pSDCResRep.getMonthNWFlowSize();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MonthNWFlowSize_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MONTHNWFLOWSIZE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MonthNWFlowUsed(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isMonthNWFlowUsedDirty() : !pSDCResRep.isMonthNWFlowUsedDirty()) {
            return null;
        }
        Integer n = pSDCResRep.getMonthNWFlowUsed();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MonthNWFlowUsed_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MONTHNWFLOWUSED");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MQInstCnt(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isMQInstCntDirty() : !pSDCResRep.isMQInstCntDirty()) {
            return null;
        }
        Integer n = pSDCResRep.getMQInstCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MQInstCnt_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MQINSTCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MSPCnt(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isMSPCntDirty() : !pSDCResRep.isMSPCntDirty()) {
            return null;
        }
        Integer n = pSDCResRep.getMSPCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MSPCnt_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSPCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Obj2Cnt(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isObj2CntDirty() : !pSDCResRep.isObj2CntDirty()) {
            return null;
        }
        Integer n = pSDCResRep.getObj2Cnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Obj2Cnt_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OBJ2CNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Obj3Cnt(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isObj3CntDirty() : !pSDCResRep.isObj3CntDirty()) {
            return null;
        }
        Integer n = pSDCResRep.getObj3Cnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Obj3Cnt_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OBJ3CNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Obj4Cnt(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isObj4CntDirty() : !pSDCResRep.isObj4CntDirty()) {
            return null;
        }
        Integer n = pSDCResRep.getObj4Cnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Obj4Cnt_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OBJ4CNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ObjCnt(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isObjCntDirty() : !pSDCResRep.isObjCntDirty()) {
            return null;
        }
        Integer n = pSDCResRep.getObjCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ObjCnt_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OBJCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCResRepId(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isPSDCResRepIdDirty() && !bl2 : !pSDCResRep.isPSDCResRepIdDirty()) {
            return null;
        }
        String string = pSDCResRep.getPSDCResRepId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCRESREPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCResRepId_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCRESREPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCResRepName(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isPSDCResRepNameDirty() && !bl2 : !pSDCResRep.isPSDCResRepNameDirty()) {
            return null;
        }
        String string = pSDCResRep.getPSDCResRepName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCRESREPNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCResRepName_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCRESREPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isPSDevCenterIdDirty() : !pSDCResRep.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSDCResRep.getPSDevCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default((IEntity)pSDCResRep, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isPSDevCenterNameDirty() : !pSDCResRep.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSDCResRep.getPSDevCenterName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default((IEntity)pSDCResRep, bl2, bl3);
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

    protected EntityFieldError onCheckField_ReportUrl(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isReportUrlDirty() : !pSDCResRep.isReportUrlDirty()) {
            return null;
        }
        String string = pSDCResRep.getReportUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ReportUrl_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REPORTURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RepTime(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isRepTimeDirty() : !pSDCResRep.isRepTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDCResRep.getRepTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RepTime_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REPTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RobotCnt(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isRobotCntDirty() : !pSDCResRep.isRobotCntDirty()) {
            return null;
        }
        Integer n = pSDCResRep.getRobotCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RobotCnt_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ROBOTCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysBakCnt(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isSysBakCntDirty() : !pSDCResRep.isSysBakCntDirty()) {
            return null;
        }
        Integer n = pSDCResRep.getSysBakCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SysBakCnt_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSBAKCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UsedASCnt(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isUsedASCntDirty() : !pSDCResRep.isUsedASCntDirty()) {
            return null;
        }
        Integer n = pSDCResRep.getUsedASCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UsedASCnt_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USEDASCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UsedCodeRepoCnt(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isUsedCodeRepoCntDirty() : !pSDCResRep.isUsedCodeRepoCntDirty()) {
            return null;
        }
        Integer n = pSDCResRep.getUsedCodeRepoCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UsedCodeRepoCnt_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USEDCODEREPOCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UsedDBInstCnt(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isUsedDBInstCntDirty() : !pSDCResRep.isUsedDBInstCntDirty()) {
            return null;
        }
        Integer n = pSDCResRep.getUsedDBInstCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UsedDBInstCnt_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USEDDBINSTCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UsedMQInstCnt(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isUsedMQInstCntDirty() : !pSDCResRep.isUsedMQInstCntDirty()) {
            return null;
        }
        Integer n = pSDCResRep.getUsedMQInstCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UsedMQInstCnt_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USEDMQINSTCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserASCnt(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isUserASCntDirty() : !pSDCResRep.isUserASCntDirty()) {
            return null;
        }
        Integer n = pSDCResRep.getUserASCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UserASCnt_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERASCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCnt(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isUserCntDirty() : !pSDCResRep.isUserCntDirty()) {
            return null;
        }
        Integer n = pSDCResRep.getUserCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UserCnt_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCodeRepoCnt(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isUserCodeRepoCntDirty() : !pSDCResRep.isUserCodeRepoCntDirty()) {
            return null;
        }
        Integer n = pSDCResRep.getUserCodeRepoCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UserCodeRepoCnt_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERCODEREPOCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserDBInstCnt(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isUserDBInstCntDirty() : !pSDCResRep.isUserDBInstCntDirty()) {
            return null;
        }
        Integer n = pSDCResRep.getUserDBInstCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UserDBInstCnt_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERDBINSTCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserMQInstCnt(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isUserMQInstCntDirty() : !pSDCResRep.isUserMQInstCntDirty()) {
            return null;
        }
        Integer n = pSDCResRep.getUserMQInstCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UserMQInstCnt_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERMQINSTCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WorkspaceCnt(boolean bl, PSDCResRep pSDCResRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResRep.isWorkspaceCntDirty() : !pSDCResRep.isWorkspaceCntDirty()) {
            return null;
        }
        Integer n = pSDCResRep.getWorkspaceCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_WorkspaceCnt_Default((IEntity)pSDCResRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WORKSPACECNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDCResRep pSDCResRep, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDCResRep, bl);
    }

    protected void onSyncIndexEntities(PSDCResRep pSDCResRep, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDCResRep, bl);
    }

    public Object getDataContextValue(PSDCResRep pSDCResRep, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDCResRep, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDCResRep pSDCResRep, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDCResRep, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ASCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ASCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODEREPOCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeRepoCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Content_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DBINSTCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DBInstCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DCBALANCE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DCBalance_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEPINSTCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DepInstCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEVSLNCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DevSlnCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEVSYSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DevSysCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEVTEMPLCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DevTemplCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DISKSIZE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DiskSize_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DISKUSED", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DiskUsed_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAINSTCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaInstCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPIREDASCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExpiredASCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPIREDASCNT2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExpiredASCnt2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPIREDCODEREPOCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExpiredCodeRepoCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPIREDCODEREPOCNT2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExpiredCodeRepoCnt2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPIREDDBINSTCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExpiredDBInstCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPIREDDBINSTCNT2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExpiredDBInstCnt2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPIREDMQINSTCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExpiredMQInstCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPIREDMQINSTCNT2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExpiredMQInstCnt2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IDLEASCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IdleASCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IDLECODEREPOCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IdleCodeRepoCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IDLEDBINSTCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IdleDBInstCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IDLEMQINSTCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IdleMQInstCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MONTHNWFLOWSIZE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MonthNWFlowSize_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MONTHNWFLOWUSED", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MonthNWFlowUsed_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MQINSTCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MQInstCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MSPCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MSPCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OBJ2CNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Obj2Cnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OBJ3CNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Obj3Cnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OBJ4CNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Obj4Cnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OBJCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ObjCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCRESREPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCResRepId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCRESREPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCResRepName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REPORTURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ReportUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REPTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RepTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ROBOTCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RobotCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSBAKCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysBakCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USEDASCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UsedASCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USEDCODEREPOCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UsedCodeRepoCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USEDDBINSTCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UsedDBInstCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USEDMQINSTCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UsedMQInstCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERASCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserASCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERCODEREPOCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserCodeRepoCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERDBINSTCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserDBInstCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERMQINSTCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserMQInstCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WORKSPACECNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WorkspaceCnt_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_ASCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CodeRepoCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Content_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENT", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_DBInstCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DCBalance_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DefaultFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DepInstCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DevSlnCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DevSysCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DevTemplCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DiskSize_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DiskUsed_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DynaInstCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExpiredASCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExpiredASCnt2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExpiredCodeRepoCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExpiredCodeRepoCnt2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExpiredDBInstCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExpiredDBInstCnt2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExpiredMQInstCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExpiredMQInstCnt2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_IdleASCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_IdleCodeRepoCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_IdleDBInstCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_IdleMQInstCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_MonthNWFlowSize_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MonthNWFlowUsed_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MQInstCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MSPCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Obj2Cnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Obj3Cnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Obj4Cnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ObjCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDCResRepId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCRESREPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCResRepName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCRESREPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ReportUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REPORTURL", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RepTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_RobotCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SysBakCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_UsedASCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UsedCodeRepoCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UsedDBInstCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UsedMQInstCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UserASCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UserCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UserCodeRepoCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UserDBInstCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UserMQInstCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_WorkspaceCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDCResRep pSDCResRep) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDCResRep)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDCResRep pSDCResRep) throws Exception {
        super.onUpdateParent((IEntity)pSDCResRep);
    }

    @Override
    protected void exportCurXmlModel(PSDCResRep pSDCResRep, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDCRESREP");
        if (!bl) {
            pSDCResRep.setCreateDate(null);
            pSDCResRep.setCreateMan(null);
            pSDCResRep.setPSDCResRepId(null);
            pSDCResRep.setUpdateDate(null);
            pSDCResRep.setUpdateMan(null);
            super.exportCurXmlModel(pSDCResRep, xmlNode, bl);
        }
    }
}

