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
package net.ibizsys.pscore.srv.wfplatform.service;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.wfplatform.dao.PSWPDCAppEntityDAO;
import net.ibizsys.pscore.srv.wfplatform.demodel.PSWPDCAppEntityDEModel;
import net.ibizsys.pscore.srv.wfplatform.entity.PSWPAppEntity;
import net.ibizsys.pscore.srv.wfplatform.entity.PSWPAppEntityBase;
import net.ibizsys.pscore.srv.wfplatform.entity.PSWPDCAppEntity;
import net.ibizsys.pscore.srv.wfplatform.entity.PSWPDCAppInst;
import net.ibizsys.pscore.srv.wfplatform.entity.PSWPDCAppInstBase;
import net.ibizsys.pscore.srv.wfplatform.service.PSWPDCWFInstService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWPDCAppEntityServiceBase
extends PSCoreSysServiceBase<PSWPDCAppEntity> {
    private static final Log log = LogFactory.getLog(PSWPDCAppEntityServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSWPDCAppEntityDEModel pSWPDCAppEntityDEModel;
    private PSWPDCAppEntityDAO pSWPDCAppEntityDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.wfplatform.service.PSWPDCAppEntityService";
    }

    public PSWPDCAppEntityDEModel getPSWPDCAppEntityDEModel() {
        if (this.pSWPDCAppEntityDEModel == null) {
            try {
                this.pSWPDCAppEntityDEModel = (PSWPDCAppEntityDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wfplatform.demodel.PSWPDCAppEntityDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWPDCAppEntityDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSWPDCAppEntityDEModel();
    }

    public PSWPDCAppEntityDAO getPSWPDCAppEntityDAO() {
        if (this.pSWPDCAppEntityDAO == null) {
            try {
                this.pSWPDCAppEntityDAO = (PSWPDCAppEntityDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.wfplatform.dao.PSWPDCAppEntityDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWPDCAppEntityDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSWPDCAppEntityDAO();
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

    protected void onFillParentInfo(PSWPDCAppEntity pSWPDCAppEntity, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWPDCAPPENTITY_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevCenter);
            } else {
                iService.get((IEntity)pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSWPDCAppEntity, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWPDCAPPENTITY_PSWPAPPENTITY_PSWPAPPENTITYID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfplatform.service.PSWPAppEntityService", (SessionFactory)this.getSessionFactory());
            PSWPAppEntity pSWPAppEntity = (PSWPAppEntity)iService.getDEModel().createEntity();
            pSWPAppEntity.set("PSWPAPPENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSWPAppEntity);
            } else {
                iService.get((IEntity)pSWPAppEntity);
            }
            this.onFillParentInfo_PSWPAppEntity(pSWPDCAppEntity, pSWPAppEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWPDCAPPENTITY_PSWPDCAPPINST_PSWPDCAPPINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfplatform.service.PSWPDCAppInstService", (SessionFactory)this.getSessionFactory());
            PSWPDCAppInst pSWPDCAppInst = (PSWPDCAppInst)iService.getDEModel().createEntity();
            pSWPDCAppInst.set("PSWPDCAPPINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSWPDCAppInst);
            } else {
                iService.get((IEntity)pSWPDCAppInst);
            }
            this.onFillParentInfo_PSWPDCAppInst(pSWPDCAppEntity, pSWPDCAppInst);
            return;
        }
        super.onFillParentInfo((IEntity)pSWPDCAppEntity, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevCenter(PSWPDCAppEntity pSWPDCAppEntity, PSDevCenter pSDevCenter) throws Exception {
        pSWPDCAppEntity.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSWPDCAppEntity.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSWPAppEntity(PSWPDCAppEntity pSWPDCAppEntity, PSWPAppEntity pSWPAppEntity) throws Exception {
        pSWPDCAppEntity.setPSWPAppEntityId(pSWPAppEntity.getPSWPAppEntityId());
        pSWPDCAppEntity.setPSWPAppEntityName(pSWPAppEntity.getPSWPAppEntityName());
    }

    protected void onFillParentInfo_PSWPDCAppInst(PSWPDCAppEntity pSWPDCAppEntity, PSWPDCAppInst pSWPDCAppInst) throws Exception {
        pSWPDCAppEntity.setPSWPDCAppInstId(pSWPDCAppInst.getPSWPDCAppInstId());
        pSWPDCAppEntity.setPSWPDCAppInstName(pSWPDCAppInst.getPSWPDCAppInstName());
    }

    protected void onFillEntityFullInfo(PSWPDCAppEntity pSWPDCAppEntity, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSWPDCAppEntity, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSWPDCAppEntity, bl);
        this.onFillEntityFullInfo_PSWPAppEntity(pSWPDCAppEntity, bl);
        this.onFillEntityFullInfo_PSWPDCAppInst(pSWPDCAppEntity, bl);
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSWPDCAppEntity pSWPDCAppEntity, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSWPAppEntity(PSWPDCAppEntity pSWPDCAppEntity, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSWPDCAppInst(PSWPDCAppEntity pSWPDCAppEntity, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSWPDCAppEntity pSWPDCAppEntity, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSWPDCAppEntity, bl);
    }

    public ArrayList<PSWPDCAppEntity> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSWPDCAppEntity> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSWPDCAppEntity> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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

    public ArrayList<PSWPDCAppEntity> selectByPSWPAppEntity(PSWPAppEntityBase pSWPAppEntityBase) throws Exception {
        return this.selectByPSWPAppEntity(pSWPAppEntityBase, "", -1);
    }

    public ArrayList<PSWPDCAppEntity> selectByPSWPAppEntity(PSWPAppEntityBase pSWPAppEntityBase, String string) throws Exception {
        return this.selectByPSWPAppEntity(pSWPAppEntityBase, string, -1);
    }

    public ArrayList<PSWPDCAppEntity> selectByPSWPAppEntity(PSWPAppEntityBase pSWPAppEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWPAPPENTITYID", (Object)pSWPAppEntityBase.getPSWPAppEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSWPAppEntityCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSWPAppEntityCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWPDCAppEntity> selectByPSWPDCAppInst(PSWPDCAppInstBase pSWPDCAppInstBase) throws Exception {
        return this.selectByPSWPDCAppInst(pSWPDCAppInstBase, "", -1);
    }

    public ArrayList<PSWPDCAppEntity> selectByPSWPDCAppInst(PSWPDCAppInstBase pSWPDCAppInstBase, String string) throws Exception {
        return this.selectByPSWPDCAppInst(pSWPDCAppInstBase, string, -1);
    }

    public ArrayList<PSWPDCAppEntity> selectByPSWPDCAppInst(PSWPDCAppInstBase pSWPDCAppInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWPDCAPPINSTID", (Object)pSWPDCAppInstBase.getPSWPDCAppInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSWPDCAppInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSWPDCAppInstCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSWPDCAppEntity> arrayList = this.selectByPSDevCenter(pSDevCenter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevCenter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWPDCAPPENTITY_PSDEVCENTER_PSDEVCENTERID", "", iDataEntityModel.getName(), "PSWPDCAPPENTITY", iDataEntityModel.getDataInfo((IEntity)pSDevCenter), arrayList.get(0)));
        }
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSWPDCAppEntity> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSWPDCAppEntity pSWPDCAppEntity : arrayList) {
            PSWPDCAppEntity pSWPDCAppEntity2 = (PSWPDCAppEntity)this.getDEModel().createEntity();
            pSWPDCAppEntity2.setPSWPDCAppEntityId(pSWPDCAppEntity.getPSWPDCAppEntityId());
            pSWPDCAppEntity2.setPSDevCenterId(null);
            this.update(pSWPDCAppEntity2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWPDCAppEntityServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSWPDCAppEntityServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSWPDCAppEntityServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSWPDCAppEntity> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSWPDCAppEntity pSWPDCAppEntity : arrayList) {
            this.remove((IEntity)pSWPDCAppEntity);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSWPDCAppEntity> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSWPDCAppEntity> arrayList) throws Exception {
    }

    public void testRemoveByPSWPAppEntity(PSWPAppEntity pSWPAppEntity) throws Exception {
        ArrayList<PSWPDCAppEntity> arrayList = this.selectByPSWPAppEntity(pSWPAppEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSWPAPPENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSWPAppEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWPDCAPPENTITY_PSWPAPPENTITY_PSWPAPPENTITYID", "", iDataEntityModel.getName(), "PSWPDCAPPENTITY", iDataEntityModel.getDataInfo((IEntity)pSWPAppEntity), arrayList.get(0)));
        }
    }

    public void resetPSWPAppEntity(PSWPAppEntity pSWPAppEntity) throws Exception {
        ArrayList<PSWPDCAppEntity> arrayList = this.selectByPSWPAppEntity(pSWPAppEntity);
        for (PSWPDCAppEntity pSWPDCAppEntity : arrayList) {
            PSWPDCAppEntity pSWPDCAppEntity2 = (PSWPDCAppEntity)this.getDEModel().createEntity();
            pSWPDCAppEntity2.setPSWPDCAppEntityId(pSWPDCAppEntity.getPSWPDCAppEntityId());
            pSWPDCAppEntity2.setPSWPAppEntityId(null);
            this.update(pSWPDCAppEntity2);
        }
    }

    public void removeByPSWPAppEntity(PSWPAppEntity pSWPAppEntity) throws Exception {
        final PSWPAppEntity pSWPAppEntity2 = pSWPAppEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWPDCAppEntityServiceBase.this.onBeforeRemoveByPSWPAppEntity(pSWPAppEntity2);
                PSWPDCAppEntityServiceBase.this.internalRemoveByPSWPAppEntity(pSWPAppEntity2);
                PSWPDCAppEntityServiceBase.this.onAfterRemoveByPSWPAppEntity(pSWPAppEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSWPAppEntity(PSWPAppEntity pSWPAppEntity) throws Exception {
    }

    protected void internalRemoveByPSWPAppEntity(PSWPAppEntity pSWPAppEntity) throws Exception {
        ArrayList<PSWPDCAppEntity> arrayList = this.selectByPSWPAppEntity(pSWPAppEntity);
        this.onBeforeRemoveByPSWPAppEntity(pSWPAppEntity, arrayList);
        for (PSWPDCAppEntity pSWPDCAppEntity : arrayList) {
            this.remove((IEntity)pSWPDCAppEntity);
        }
        this.onAfterRemoveByPSWPAppEntity(pSWPAppEntity, arrayList);
    }

    protected void onAfterRemoveByPSWPAppEntity(PSWPAppEntity pSWPAppEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSWPAppEntity(PSWPAppEntity pSWPAppEntity, ArrayList<PSWPDCAppEntity> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWPAppEntity(PSWPAppEntity pSWPAppEntity, ArrayList<PSWPDCAppEntity> arrayList) throws Exception {
    }

    public void testRemoveByPSWPDCAppInst(PSWPDCAppInst pSWPDCAppInst) throws Exception {
        ArrayList<PSWPDCAppEntity> arrayList = this.selectByPSWPDCAppInst(pSWPDCAppInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSWPDCAPPINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSWPDCAppInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWPDCAPPENTITY_PSWPDCAPPINST_PSWPDCAPPINSTID", "", iDataEntityModel.getName(), "PSWPDCAPPENTITY", iDataEntityModel.getDataInfo((IEntity)pSWPDCAppInst), arrayList.get(0)));
        }
    }

    public void resetPSWPDCAppInst(PSWPDCAppInst pSWPDCAppInst) throws Exception {
        ArrayList<PSWPDCAppEntity> arrayList = this.selectByPSWPDCAppInst(pSWPDCAppInst);
        for (PSWPDCAppEntity pSWPDCAppEntity : arrayList) {
            PSWPDCAppEntity pSWPDCAppEntity2 = (PSWPDCAppEntity)this.getDEModel().createEntity();
            pSWPDCAppEntity2.setPSWPDCAppEntityId(pSWPDCAppEntity.getPSWPDCAppEntityId());
            pSWPDCAppEntity2.setPSWPDCAppInstId(null);
            this.update(pSWPDCAppEntity2);
        }
    }

    public void removeByPSWPDCAppInst(PSWPDCAppInst pSWPDCAppInst) throws Exception {
        final PSWPDCAppInst pSWPDCAppInst2 = pSWPDCAppInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWPDCAppEntityServiceBase.this.onBeforeRemoveByPSWPDCAppInst(pSWPDCAppInst2);
                PSWPDCAppEntityServiceBase.this.internalRemoveByPSWPDCAppInst(pSWPDCAppInst2);
                PSWPDCAppEntityServiceBase.this.onAfterRemoveByPSWPDCAppInst(pSWPDCAppInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSWPDCAppInst(PSWPDCAppInst pSWPDCAppInst) throws Exception {
    }

    protected void internalRemoveByPSWPDCAppInst(PSWPDCAppInst pSWPDCAppInst) throws Exception {
        ArrayList<PSWPDCAppEntity> arrayList = this.selectByPSWPDCAppInst(pSWPDCAppInst);
        this.onBeforeRemoveByPSWPDCAppInst(pSWPDCAppInst, arrayList);
        for (PSWPDCAppEntity pSWPDCAppEntity : arrayList) {
            this.remove((IEntity)pSWPDCAppEntity);
        }
        this.onAfterRemoveByPSWPDCAppInst(pSWPDCAppInst, arrayList);
    }

    protected void onAfterRemoveByPSWPDCAppInst(PSWPDCAppInst pSWPDCAppInst) throws Exception {
    }

    protected void onBeforeRemoveByPSWPDCAppInst(PSWPDCAppInst pSWPDCAppInst, ArrayList<PSWPDCAppEntity> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWPDCAppInst(PSWPDCAppInst pSWPDCAppInst, ArrayList<PSWPDCAppEntity> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSWPDCAppEntity pSWPDCAppEntity) throws Exception {
        PSWPDCWFInstService pSWPDCWFInstService = (PSWPDCWFInstService)ServiceGlobal.getService(PSWPDCWFInstService.class, (SessionFactory)this.getSessionFactory());
        pSWPDCWFInstService.testRemoveByPswpdcappentity(pSWPDCAppEntity);
        super.onBeforeRemove(pSWPDCAppEntity);
    }

    protected void replaceParentInfo(PSWPDCAppEntity pSWPDCAppEntity, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSWPDCAppEntity, cloneSession);
        if (pSWPDCAppEntity.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSWPDCAppEntity.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSWPDCAppEntity, (PSDevCenter)iEntity);
        }
        if (pSWPDCAppEntity.getPSWPAppEntityId() != null && (iEntity = cloneSession.getEntity("PSWPAPPENTITY", (Object)pSWPDCAppEntity.getPSWPAppEntityId())) != null) {
            this.onFillParentInfo_PSWPAppEntity(pSWPDCAppEntity, (PSWPAppEntity)iEntity);
        }
        if (pSWPDCAppEntity.getPSWPDCAppInstId() != null && (iEntity = cloneSession.getEntity("PSWPDCAPPINST", (Object)pSWPDCAppEntity.getPSWPDCAppInstId())) != null) {
            this.onFillParentInfo_PSWPDCAppInst(pSWPDCAppEntity, (PSWPDCAppInst)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSWPDCAppEntity pSWPDCAppEntity, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSWPDCAppEntity, bl);
    }

    protected void onCheckEntity(boolean bl, PSWPDCAppEntity pSWPDCAppEntity, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_PSDevCenterId(bl, pSWPDCAppEntity, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWPAppEntityId(bl, pSWPDCAppEntity, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWPDCAppEntityId(bl, pSWPDCAppEntity, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWPDCAppEntityName(bl, pSWPDCAppEntity, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWPDCAppInstId(bl, pSWPDCAppEntity, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSWPDCAppEntity, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSWPDCAppEntity pSWPDCAppEntity, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWPDCAppEntity.isPSDevCenterIdDirty() && !bl2 : !pSWPDCAppEntity.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSWPDCAppEntity.getPSDevCenterId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default((IEntity)pSWPDCAppEntity, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSWPAppEntityId(boolean bl, PSWPDCAppEntity pSWPDCAppEntity, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWPDCAppEntity.isPSWPAppEntityIdDirty() && !bl2 : !pSWPDCAppEntity.isPSWPAppEntityIdDirty()) {
            return null;
        }
        String string = pSWPDCAppEntity.getPSWPAppEntityId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPAPPENTITYID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWPAppEntityId_Default((IEntity)pSWPDCAppEntity, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPAPPENTITYID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWPDCAppEntityId(boolean bl, PSWPDCAppEntity pSWPDCAppEntity, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWPDCAppEntity.isPSWPDCAppEntityIdDirty() && !bl2 : !pSWPDCAppEntity.isPSWPDCAppEntityIdDirty()) {
            return null;
        }
        String string = pSWPDCAppEntity.getPSWPDCAppEntityId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPDCAPPENTITYID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWPDCAppEntityId_Default((IEntity)pSWPDCAppEntity, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPDCAPPENTITYID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWPDCAppEntityName(boolean bl, PSWPDCAppEntity pSWPDCAppEntity, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWPDCAppEntity.isPSWPDCAppEntityNameDirty() && !bl2 : !pSWPDCAppEntity.isPSWPDCAppEntityNameDirty()) {
            return null;
        }
        String string = pSWPDCAppEntity.getPSWPDCAppEntityName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPDCAPPENTITYNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWPDCAppEntityName_Default((IEntity)pSWPDCAppEntity, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPDCAPPENTITYNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWPDCAppInstId(boolean bl, PSWPDCAppEntity pSWPDCAppEntity, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWPDCAppEntity.isPSWPDCAppInstIdDirty() && !bl2 : !pSWPDCAppEntity.isPSWPDCAppInstIdDirty()) {
            return null;
        }
        String string = pSWPDCAppEntity.getPSWPDCAppInstId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPDCAPPINSTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWPDCAppInstId_Default((IEntity)pSWPDCAppEntity, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPDCAPPINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSWPDCAppEntity pSWPDCAppEntity, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSWPDCAppEntity, bl);
    }

    protected void onSyncIndexEntities(PSWPDCAppEntity pSWPDCAppEntity, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSWPDCAppEntity, bl);
    }

    public Object getDataContextValue(PSWPDCAppEntity pSWPDCAppEntity, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSWPDCAppEntity, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSWPDCAppEntity pSWPDCAppEntity, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSWPDCAppEntity, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWPAPPENTITYID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWPAppEntityId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWPAPPENTITYNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWPAppEntityName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWPDCAPPENTITYID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWPDCAppEntityId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWPDCAPPENTITYNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWPDCAppEntityName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWPDCAPPINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWPDCAppInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWPDCAPPINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWPDCAppInstName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSWPAppEntityId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWPAPPENTITYID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWPAppEntityName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWPAPPENTITYNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWPDCAppEntityId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWPDCAPPENTITYID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWPDCAppEntityName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWPDCAPPENTITYNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWPDCAppInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWPDCAPPINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWPDCAppInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWPDCAPPINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSWPDCAppEntity pSWPDCAppEntity) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSWPDCAppEntity)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSWPDCAppEntity pSWPDCAppEntity) throws Exception {
        super.onUpdateParent((IEntity)pSWPDCAppEntity);
    }

    @Override
    protected void exportCurXmlModel(PSWPDCAppEntity pSWPDCAppEntity, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSWPDCAPPENTITY");
        if (!bl) {
            pSWPDCAppEntity.setCreateDate(null);
            pSWPDCAppEntity.setCreateMan(null);
            pSWPDCAppEntity.setPSWPDCAppEntityId(null);
            pSWPDCAppEntity.setUpdateDate(null);
            pSWPDCAppEntity.setUpdateMan(null);
            super.exportCurXmlModel(pSWPDCAppEntity, xmlNode, bl);
        }
    }
}

