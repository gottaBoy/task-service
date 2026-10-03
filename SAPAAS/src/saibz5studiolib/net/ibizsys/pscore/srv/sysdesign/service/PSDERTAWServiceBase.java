/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.data.DataObject
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
 *  net.ibizsys.paas.service.IServicePlugin
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
import java.util.HashMap;
import java.util.Iterator;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.data.DataObject;
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
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSDERTAWDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDERTAWDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDERTAW;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDERTAWI;
import net.ibizsys.pscore.srv.sysdesign.service.PSDERTAWIService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDERTAWServiceBase
extends PSCoreSysServiceBase<PSDERTAW> {
    private static final Log log = LogFactory.getLog(PSDERTAWServiceBase.class);
    public static final String DATASET_CURFORM = "CurForm";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_PSDATAENTITY = "PSDATAENTITY";
    public static final String ACTION_EXECUTEAW = "ExecuteAW";
    private PSDERTAWDEModel pSDERTAWDEModel;
    private PSDERTAWDAO pSDERTAWDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSDERTAWService";
    }

    public PSDERTAWDEModel getPSDERTAWDEModel() {
        if (this.pSDERTAWDEModel == null) {
            try {
                this.pSDERTAWDEModel = (PSDERTAWDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDERTAWDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDERTAWDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDERTAWDEModel();
    }

    public PSDERTAWDAO getPSDERTAWDAO() {
        if (this.pSDERTAWDAO == null) {
            try {
                this.pSDERTAWDAO = (PSDERTAWDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSDERTAWDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDERTAWDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDERTAWDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURFORM, (boolean)true) == 0) {
            return this.fetchCurForm(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_PSDATAENTITY, (boolean)true) == 0) {
            return this.fetchPSDataEntity(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURFORM, (boolean)true) == 0) {
            return this.fetchTempCurForm(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_PSDATAENTITY, (boolean)true) == 0) {
            return this.fetchTempPSDataEntity(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_EXECUTEAW, (boolean)true) == 0) {
            this.executeAW((PSDERTAW)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurForm(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURFORM, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurForm(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURFORM, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchPSDataEntity(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_PSDATAENTITY, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempPSDataEntity(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_PSDATAENTITY, true);
        return dBFetchResult;
    }

    public void executeAW(PSDERTAW pSDERTAW) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_EXECUTEAW, 0, pSDERTAW, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDERTAW, ACTION_EXECUTEAW);
        final PSDERTAW pSDERTAW2 = pSDERTAW;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDERTAWServiceBase.this.getService(), PSDERTAWServiceBase.ACTION_EXECUTEAW, 40, pSDERTAW2, null).getResult() != 1) {
                    PSDERTAWServiceBase.this.onExecuteAW(pSDERTAW2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_EXECUTEAW, 99, pSDERTAW, null);
        }
    }

    protected void onExecuteAW(PSDERTAW pSDERTAW) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[ExecuteAW]");
    }

    protected void onFillParentInfo(PSDERTAW pSDERTAW, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDERTAW_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDERTAW, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDERTAW_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSDERTAW, pSDevCenter);
            return;
        }
        super.onFillParentInfo(pSDERTAW, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSDERTAW pSDERTAW, PSDataEntity pSDataEntity) throws Exception {
        pSDERTAW.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDERTAW.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDevCenter(PSDERTAW pSDERTAW, PSDevCenter pSDevCenter) throws Exception {
        pSDERTAW.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDERTAW.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillEntityFullInfo(PSDERTAW pSDERTAW, boolean bl) throws Exception {
        if (bl) {
            if (pSDERTAW.getAllDCFlag() == null) {
                pSDERTAW.setAllDCFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
            if (pSDERTAW.getValidFlag() == null) {
                pSDERTAW.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSDERTAW, bl);
        this.onFillEntityFullInfo_PSDE(pSDERTAW, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSDERTAW, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSDERTAW pSDERTAW, boolean bl) throws Exception {
        if (pSDERTAW.isPSDEIdDirty()) {
            if (pSDERTAW.getPSDEId() != null) {
                if (pSDERTAW.getPSDEId() == null || pSDERTAW.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDERTAW.getPSDE();
                    pSDERTAW.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDERTAW.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSDERTAW pSDERTAW, boolean bl) throws Exception {
        if (pSDERTAW.isPSDevCenterIdDirty()) {
            if (pSDERTAW.getPSDevCenterId() != null) {
                if (pSDERTAW.getPSDevCenterId() == null || pSDERTAW.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSDERTAW.getPSDevCenter();
                    pSDERTAW.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSDERTAW.setPSDevCenterName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDERTAW pSDERTAW, boolean bl) throws Exception {
        super.onWriteBackParent(pSDERTAW, bl);
    }

    public ArrayList<PSDERTAW> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDERTAW> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDERTAW> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDERTAW> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDERTAW> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDERTAW> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDERTAW> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDERTAW pSDERTAW : arrayList) {
            PSDERTAW pSDERTAW2 = (PSDERTAW)this.getDEModel().createEntity();
            pSDERTAW2.setPSDERTAWId(pSDERTAW.getPSDERTAWId());
            pSDERTAW2.setPSDEId(null);
            this.update(pSDERTAW2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDERTAWServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDERTAWServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDERTAWServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDERTAW> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDERTAW pSDERTAW : arrayList) {
            this.remove(pSDERTAW);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDERTAW> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDERTAW> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDERTAW> arrayList = this.selectByPSDevCenter(pSDevCenter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDERTAW_PSDEVCENTER_PSDEVCENTERID", "", iDataEntityModel.getName(), "PSDERTAW", iDataEntityModel.getDataInfo(pSDevCenter), arrayList.get(0)));
        }
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDERTAW> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSDERTAW pSDERTAW : arrayList) {
            PSDERTAW pSDERTAW2 = (PSDERTAW)this.getDEModel().createEntity();
            pSDERTAW2.setPSDERTAWId(pSDERTAW.getPSDERTAWId());
            pSDERTAW2.setPSDevCenterId(null);
            this.update(pSDERTAW2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDERTAWServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSDERTAWServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSDERTAWServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDERTAW> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSDERTAW pSDERTAW : arrayList) {
            this.remove(pSDERTAW);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDERTAW> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDERTAW> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDERTAW pSDERTAW) throws Exception {
        PSDERTAWIService pSDERTAWIService = (PSDERTAWIService)ServiceGlobal.getService(PSDERTAWIService.class, (SessionFactory)this.getSessionFactory());
        pSDERTAWIService.testRemoveByPSDERTAW(pSDERTAW);
        pSDERTAWIService.removeByPSDERTAW(pSDERTAW);
        super.onBeforeRemove(pSDERTAW);
    }

    protected void onBeforeRemoveTemp(PSDERTAW pSDERTAW) throws Exception {
        PSDERTAWIService pSDERTAWIService = (PSDERTAWIService)ServiceGlobal.getService(PSDERTAWIService.class, (SessionFactory)this.getSessionFactory());
        pSDERTAWIService.removeTempByPSDERTAW(pSDERTAW);
        super.onBeforeRemoveTemp(pSDERTAW);
    }

    protected void getRelatedDataTempMajor(PSDERTAW pSDERTAW) throws Exception {
        this.getRelatedDataTempMajor_PSDERTAWI(pSDERTAW);
        super.getRelatedDataTempMajor(pSDERTAW);
    }

    protected void getRelatedDataTempMajor_PSDERTAWI(PSDERTAW pSDERTAW) throws Exception {
        PSDERTAWIService pSDERTAWIService = (PSDERTAWIService)ServiceGlobal.getService(PSDERTAWIService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDERTAWI> arrayList = null;
        String string = pSDERTAW.getPSDERTAWId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDERTAWIService.selectByPSDERTAW(pSDERTAW) : pSDERTAWIService.selectTempByPSDERTAW(pSDERTAW);
        for (PSDERTAWI pSDERTAWI : arrayList) {
            pSDERTAWIService.getTempMajor(pSDERTAWI);
        }
    }

    protected void updateRelatedDataTempMajor(PSDERTAW pSDERTAW, PSDERTAW pSDERTAW2) throws Exception {
        ArrayList<PSDERTAWI> arrayList = this.updateRelatedDataTempMajor_removePSDERTAWI(pSDERTAW, pSDERTAW2);
        this.updateRelatedDataTempMajor_updatePSDERTAWI(pSDERTAW, pSDERTAW2, arrayList);
        super.updateRelatedDataTempMajor(pSDERTAW, pSDERTAW2);
    }

    protected ArrayList<PSDERTAWI> updateRelatedDataTempMajor_removePSDERTAWI(PSDERTAW pSDERTAW, PSDERTAW pSDERTAW2) throws Exception {
        PSDERTAWIService pSDERTAWIService = (PSDERTAWIService)ServiceGlobal.getService(PSDERTAWIService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDERTAWI> arrayList = pSDERTAWIService.selectTempByPSDERTAW(pSDERTAW);
        ArrayList<PSDERTAWI> arrayList2 = pSDERTAWIService.selectByPSDERTAW(pSDERTAW2);
        HashMap<String, PSDERTAWI> hashMap = new HashMap<String, PSDERTAWI>();
        for (PSDERTAWI pSDERTAWI : arrayList2) {
            hashMap.put(pSDERTAWI.getPSDERTAWIId(), pSDERTAWI);
        }
        for (PSDERTAWI pSDERTAWI : arrayList) {
            Object object = pSDERTAWI.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDERTAWI pSDERTAWI : hashMap.values()) {
            pSDERTAWIService.remove(pSDERTAWI);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDERTAWI(PSDERTAW pSDERTAW, PSDERTAW pSDERTAW2, ArrayList<PSDERTAWI> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDERTAWIService pSDERTAWIService = (PSDERTAWIService)ServiceGlobal.getService(PSDERTAWIService.class, (SessionFactory)this.getSessionFactory());
        for (PSDERTAWI pSDERTAWI : arrayList) {
            pSDERTAWIService.updateTempMajor(pSDERTAWI);
        }
    }

    protected void replaceParentInfo(PSDERTAW pSDERTAW, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDERTAW, cloneSession);
        if (pSDERTAW.getPSDEId() != null && (iEntity = cloneSession.getEntity(DATASET_PSDATAENTITY, (Object)pSDERTAW.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDERTAW, (PSDataEntity)iEntity);
        }
        if (pSDERTAW.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDERTAW.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSDERTAW, (PSDevCenter)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDERTAW pSDERTAW, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDERTAW, bl);
    }

    protected void onCheckEntity(boolean bl, PSDERTAW pSDERTAW, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AllDCFlag(bl, pSDERTAW, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AWInputMode(bl, pSDERTAW, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AWItems(bl, pSDERTAW, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AWPath(bl, pSDERTAW, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Keywords(bl, pSDERTAW, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDERTAW, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDERTAW, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDERTAW, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDERTAW, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDERTAWId(bl, pSDERTAW, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDERTAWName(bl, pSDERTAW, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSDERTAW, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSDERTAW, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SRFFormMode(bl, pSDERTAW, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Url(bl, pSDERTAW, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDERTAW, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDERTAW, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDERTAW, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDERTAW, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AllDCFlag(boolean bl, PSDERTAW pSDERTAW, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERTAW.isAllDCFlagDirty() && !bl2 : !pSDERTAW.isAllDCFlagDirty()) {
            return null;
        }
        Integer n = pSDERTAW.getAllDCFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ALLDCFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_AllDCFlag_Default(pSDERTAW, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ALLDCFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AWInputMode(boolean bl, PSDERTAW pSDERTAW, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERTAW.isAWInputModeDirty() && !bl2 : !pSDERTAW.isAWInputModeDirty()) {
            return null;
        }
        Integer n = pSDERTAW.getAWInputMode();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AWINPUTMODE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_AWInputMode_Default(pSDERTAW, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AWINPUTMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AWItems(boolean bl, PSDERTAW pSDERTAW, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERTAW.isAWItemsDirty() : !pSDERTAW.isAWItemsDirty()) {
            return null;
        }
        String string = pSDERTAW.getAWItems();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AWItems_Default(pSDERTAW, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AWITEMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AWPath(boolean bl, PSDERTAW pSDERTAW, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERTAW.isAWPathDirty() : !pSDERTAW.isAWPathDirty()) {
            return null;
        }
        String string = pSDERTAW.getAWPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AWPath_Default(pSDERTAW, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AWPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Keywords(boolean bl, PSDERTAW pSDERTAW, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERTAW.isKeywordsDirty() : !pSDERTAW.isKeywordsDirty()) {
            return null;
        }
        String string = pSDERTAW.getKeywords();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Keywords_Default(pSDERTAW, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("KEYWORDS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDERTAW pSDERTAW, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERTAW.isMemoDirty() : !pSDERTAW.isMemoDirty()) {
            return null;
        }
        String string = pSDERTAW.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDERTAW, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDERTAW pSDERTAW, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERTAW.isOrderValueDirty() : !pSDERTAW.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDERTAW.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSDERTAW, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDERTAW pSDERTAW, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERTAW.isPSDEIdDirty() : !pSDERTAW.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDERTAW.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSDERTAW, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDERTAW pSDERTAW, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERTAW.isPSDENameDirty() : !pSDERTAW.isPSDENameDirty()) {
            return null;
        }
        String string = pSDERTAW.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSDERTAW, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDERTAWId(boolean bl, PSDERTAW pSDERTAW, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERTAW.isPSDERTAWIdDirty() && !bl2 : !pSDERTAW.isPSDERTAWIdDirty()) {
            return null;
        }
        String string = pSDERTAW.getPSDERTAWId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERTAWID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDERTAWId_Default(pSDERTAW, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERTAWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDERTAWName(boolean bl, PSDERTAW pSDERTAW, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERTAW.isPSDERTAWNameDirty() && !bl2 : !pSDERTAW.isPSDERTAWNameDirty()) {
            return null;
        }
        String string = pSDERTAW.getPSDERTAWName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERTAWNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDERTAWName_Default(pSDERTAW, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERTAWNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSDERTAW pSDERTAW, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERTAW.isPSDevCenterIdDirty() : !pSDERTAW.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSDERTAW.getPSDevCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default(pSDERTAW, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSDERTAW pSDERTAW, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERTAW.isPSDevCenterNameDirty() : !pSDERTAW.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSDERTAW.getPSDevCenterName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default(pSDERTAW, bl2, bl3);
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

    protected EntityFieldError onCheckField_SRFFormMode(boolean bl, PSDERTAW pSDERTAW, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERTAW.isSRFFormModeDirty() : !pSDERTAW.isSRFFormModeDirty()) {
            return null;
        }
        String string = pSDERTAW.getSRFFormMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SRFFormMode_Default(pSDERTAW, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRFFORMMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Url(boolean bl, PSDERTAW pSDERTAW, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERTAW.isUrlDirty() : !pSDERTAW.isUrlDirty()) {
            return null;
        }
        String string = pSDERTAW.getUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Url_Default(pSDERTAW, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("URL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDERTAW pSDERTAW, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERTAW.isUserTagDirty() : !pSDERTAW.isUserTagDirty()) {
            return null;
        }
        String string = pSDERTAW.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDERTAW, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDERTAW pSDERTAW, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERTAW.isUserTag2Dirty() : !pSDERTAW.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDERTAW.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDERTAW, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDERTAW pSDERTAW, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERTAW.isValidFlagDirty() && !bl2 : !pSDERTAW.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDERTAW.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDERTAW, bl2, bl3);
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

    protected void onSyncEntity(PSDERTAW pSDERTAW, boolean bl) throws Exception {
        super.onSyncEntity(pSDERTAW, bl);
    }

    protected void onSyncIndexEntities(PSDERTAW pSDERTAW, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDERTAW, bl);
    }

    public Object getDataContextValue(PSDERTAW pSDERTAW, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDERTAW, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDERTAW pSDERTAW, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDERTAW, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ALLDCFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AllDCFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AWINPUTMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AWInputMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AWITEMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AWItems_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AWPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AWPath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"KEYWORDS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Keywords_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERTAWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERTAWId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERTAWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERTAWName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRFFORMMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SRFFormMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"URL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Url_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AllDCFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_AWInputMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_AWItems_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AWITEMS", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AWPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AWPATH", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
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

    protected String onTestValueRule_Keywords_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("KEYWORDS", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDERTAWId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDERTAWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDERTAWName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDERTAWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_SRFFormMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SRFFORMMODE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_Url_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("URL", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSDERTAW pSDERTAW) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDERTAW)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDERTAW pSDERTAW) throws Exception {
        super.onUpdateParent(pSDERTAW);
    }

    protected void onCopyDetails(PSDERTAW pSDERTAW, Object object) throws Exception {
        PSDERTAW pSDERTAW2 = new PSDERTAW();
        pSDERTAW2.set("PSDERTAWID", object);
        String string = DataObject.getStringValue((Object)pSDERTAW.get("PSDERTAWID"));
        super.onCopyDetails(pSDERTAW, object);
    }

    @Override
    protected void exportCurXmlModel(PSDERTAW pSDERTAW, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDERTAW");
        if (!bl) {
            pSDERTAW.setCreateDate(null);
            pSDERTAW.setCreateMan(null);
            pSDERTAW.setPSDERTAWId(null);
            pSDERTAW.setUpdateDate(null);
            pSDERTAW.setUpdateMan(null);
            super.exportCurXmlModel(pSDERTAW, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDERTAW pSDERTAW, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSDERTAWI(pSDERTAW, xmlNode);
        super.onExportRelatedXmlModel(pSDERTAW, xmlNode);
    }

    protected void exportRelatedXmlModel_PSDERTAWI(PSDERTAW pSDERTAW, XmlNode xmlNode) throws Exception {
        PSDERTAWIService pSDERTAWIService = (PSDERTAWIService)ServiceGlobal.getService(PSDERTAWIService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDERTAWI> arrayList = null;
        String string = pSDERTAW.getPSDERTAWId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDERTAWIService.selectByPSDERTAW(pSDERTAW, "ORDER BY ORDERVALUE ASC") : pSDERTAWIService.selectTempByPSDERTAW(pSDERTAW, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDERTAWIS");
            xmlNode.addNode(xmlNode2);
            for (PSDERTAWI pSDERTAWI : arrayList) {
                pSDERTAWI.set("ORDERVALUE", null);
                pSDERTAWIService.exportXmlModel(pSDERTAWI, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSDERTAW pSDERTAW, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSDERTAWIS");
        this.importRelatedXmlModel_PSDERTAWI(pSDERTAW, xmlNode2);
        super.onImportRelatedXmlModel(pSDERTAW, xmlNode);
    }

    protected void importRelatedXmlModel_PSDERTAWI(PSDERTAW pSDERTAW, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDERTAWIService pSDERTAWIService = (PSDERTAWIService)ServiceGlobal.getService(PSDERTAWIService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDERTAW.getPSDERTAWId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDERTAWIService.removeByPSDERTAW(pSDERTAW);
        } else {
            pSDERTAWIService.removeTempByPSDERTAW(pSDERTAW);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDERTAWI pSDERTAWI = new PSDERTAWI();
                pSDERTAWI.setOrderValue(n);
                n += 100;
                pSDERTAWIService.fillParentInfo(pSDERTAWI, "DER1N", "DER1N_PSDERTAWI_PSDERTAW_PSDERTAWID", pSDERTAW.getPSDERTAWId());
                pSDERTAWIService.importXmlModel(pSDERTAWI, xmlNode2);
            }
        }
    }
}

