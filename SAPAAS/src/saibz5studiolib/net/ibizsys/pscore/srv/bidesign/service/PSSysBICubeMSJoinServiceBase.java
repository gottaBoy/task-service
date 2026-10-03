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
package net.ibizsys.pscore.srv.bidesign.service;

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
import net.ibizsys.pscore.srv.bidesign.dao.PSSysBICubeMSJoinDAO;
import net.ibizsys.pscore.srv.bidesign.demodel.PSSysBICubeMSJoinDEModel;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeMSJoin;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeMSJoinBase;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeMeasure;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeMeasureBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeMSJoinService;
import net.ibizsys.pscore.srv.config.entity.PSDEJoinType;
import net.ibizsys.pscore.srv.config.entity.PSDEJoinTypeBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDERBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysBICubeMSJoinServiceBase
extends PSCoreSysServiceBase<PSSysBICubeMSJoin> {
    private static final Log log = LogFactory.getLog(PSSysBICubeMSJoinServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysBICubeMSJoinDEModel pSSysBICubeMSJoinDEModel;
    private PSSysBICubeMSJoinDAO pSSysBICubeMSJoinDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeMSJoinService";
    }

    public PSSysBICubeMSJoinDEModel getPSSysBICubeMSJoinDEModel() {
        if (this.pSSysBICubeMSJoinDEModel == null) {
            try {
                this.pSSysBICubeMSJoinDEModel = (PSSysBICubeMSJoinDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.bidesign.demodel.PSSysBICubeMSJoinDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBICubeMSJoinDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysBICubeMSJoinDEModel();
    }

    public PSSysBICubeMSJoinDAO getPSSysBICubeMSJoinDAO() {
        if (this.pSSysBICubeMSJoinDAO == null) {
            try {
                this.pSSysBICubeMSJoinDAO = (PSSysBICubeMSJoinDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.bidesign.dao.PSSysBICubeMSJoinDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBICubeMSJoinDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysBICubeMSJoinDAO();
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

    protected void onFillParentInfo(PSSysBICubeMSJoin pSSysBICubeMSJoin, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBICUBEMSJOIN_PSDATAENTITY_JOINPSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_JoinPSDE(pSSysBICubeMSJoin, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBICUBEMSJOIN_PSDEJOINTYPE_PSDEJOINTYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDEJoinTypeService", (SessionFactory)this.getSessionFactory());
            PSDEJoinType pSDEJoinType = (PSDEJoinType)iService.getDEModel().createEntity();
            pSDEJoinType.set("PSDEJOINTYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEJoinType);
            } else {
                iService.get(pSDEJoinType);
            }
            this.onFillParentInfo_PSDEJoinType(pSSysBICubeMSJoin, pSDEJoinType);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBICUBEMSJOIN_PSDER_PSDERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDERService", (SessionFactory)this.getSessionFactory());
            PSDER pSDER = (PSDER)iService.getDEModel().createEntity();
            pSDER.set("PSDERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDER);
            } else {
                iService.get(pSDER);
            }
            this.onFillParentInfo_PSDER(pSSysBICubeMSJoin, pSDER);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBICUBEMSJOIN_PSSYSBICUBEMEASURE_PSSYSBICUBEMEASUREID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeMeasureService", (SessionFactory)this.getSessionFactory());
            PSSysBICubeMeasure pSSysBICubeMeasure = (PSSysBICubeMeasure)iService.getDEModel().createEntity();
            pSSysBICubeMeasure.set("PSSYSBICUBEMEASUREID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysBICubeMeasure);
            } else {
                iService.get(pSSysBICubeMeasure);
            }
            this.onFillParentInfo_PSSysBICubeMeasure(pSSysBICubeMSJoin, pSSysBICubeMeasure);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBICUBEMSJOIN_PSSYSBICUBEMSJOIN_PPSSYSBICUBEMSJOINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeMSJoinService", (SessionFactory)this.getSessionFactory());
            PSSysBICubeMSJoin pSSysBICubeMSJoin2 = (PSSysBICubeMSJoin)iService.getDEModel().createEntity();
            pSSysBICubeMSJoin2.set("PSSYSBICUBEMSJOINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysBICubeMSJoin2);
            } else {
                iService.get(pSSysBICubeMSJoin2);
            }
            this.onFillParentInfo_PPSSysBICubeMSJoin(pSSysBICubeMSJoin, pSSysBICubeMSJoin2);
            return;
        }
        super.onFillParentInfo(pSSysBICubeMSJoin, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_JoinPSDE(PSSysBICubeMSJoin pSSysBICubeMSJoin, PSDataEntity pSDataEntity) throws Exception {
        pSSysBICubeMSJoin.setJoinPSDEId(pSDataEntity.getPSDataEntityId());
        pSSysBICubeMSJoin.setJoinPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDEJoinType(PSSysBICubeMSJoin pSSysBICubeMSJoin, PSDEJoinType pSDEJoinType) throws Exception {
        pSSysBICubeMSJoin.setPSDEJoinTypeId(pSDEJoinType.getPSDEJoinTypeId());
        pSSysBICubeMSJoin.setPSDEJoinTypeName(pSDEJoinType.getPSDEJoinTypeName());
    }

    protected void onFillParentInfo_PSDER(PSSysBICubeMSJoin pSSysBICubeMSJoin, PSDER pSDER) throws Exception {
        pSSysBICubeMSJoin.setPSDERId(pSDER.getPSDERId());
        pSSysBICubeMSJoin.setPSDERName(pSDER.getPSDERName());
    }

    protected void onFillParentInfo_PSSysBICubeMeasure(PSSysBICubeMSJoin pSSysBICubeMSJoin, PSSysBICubeMeasure pSSysBICubeMeasure) throws Exception {
        pSSysBICubeMSJoin.setPSSysBICubeMeasureId(pSSysBICubeMeasure.getPSSysBICubeMeasureId());
        pSSysBICubeMSJoin.setPSSysBICubeMeasureName(pSSysBICubeMeasure.getPSSysBICubeMeasureName());
    }

    protected void onFillParentInfo_PPSSysBICubeMSJoin(PSSysBICubeMSJoin pSSysBICubeMSJoin, PSSysBICubeMSJoin pSSysBICubeMSJoin2) throws Exception {
        pSSysBICubeMSJoin.setPJoinPSDEId(pSSysBICubeMSJoin2.getJoinPSDEId());
        pSSysBICubeMSJoin.setPPSSysBICubeMSJoinId(pSSysBICubeMSJoin2.getPSSysBICubeMSJoinId());
        pSSysBICubeMSJoin.setPPSSysBICubeMSJoinName(pSSysBICubeMSJoin2.getPSSysBICubeMSJoinName());
    }

    protected void onFillEntityFullInfo(PSSysBICubeMSJoin pSSysBICubeMSJoin, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSSysBICubeMSJoin, bl);
        this.onFillEntityFullInfo_JoinPSDE(pSSysBICubeMSJoin, bl);
        this.onFillEntityFullInfo_PSDEJoinType(pSSysBICubeMSJoin, bl);
        this.onFillEntityFullInfo_PSDER(pSSysBICubeMSJoin, bl);
        this.onFillEntityFullInfo_PSSysBICubeMeasure(pSSysBICubeMSJoin, bl);
        this.onFillEntityFullInfo_PPSSysBICubeMSJoin(pSSysBICubeMSJoin, bl);
    }

    protected void onFillEntityFullInfo_JoinPSDE(PSSysBICubeMSJoin pSSysBICubeMSJoin, boolean bl) throws Exception {
        if (pSSysBICubeMSJoin.isJoinPSDEIdDirty()) {
            if (pSSysBICubeMSJoin.getJoinPSDEId() != null) {
                if (pSSysBICubeMSJoin.getJoinPSDEId() == null || pSSysBICubeMSJoin.getJoinPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSSysBICubeMSJoin.getJoinPSDE();
                    pSSysBICubeMSJoin.setJoinPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysBICubeMSJoin.setJoinPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEJoinType(PSSysBICubeMSJoin pSSysBICubeMSJoin, boolean bl) throws Exception {
        if (pSSysBICubeMSJoin.isPSDEJoinTypeIdDirty()) {
            if (pSSysBICubeMSJoin.getPSDEJoinTypeId() != null) {
                if (pSSysBICubeMSJoin.getPSDEJoinTypeId() == null || pSSysBICubeMSJoin.getPSDEJoinTypeName() == null) {
                    PSDEJoinType pSDEJoinType = pSSysBICubeMSJoin.getPSDEJoinType();
                    pSSysBICubeMSJoin.setPSDEJoinTypeName(pSDEJoinType.getPSDEJoinTypeName());
                }
            } else {
                pSSysBICubeMSJoin.setPSDEJoinTypeName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDER(PSSysBICubeMSJoin pSSysBICubeMSJoin, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysBICubeMeasure(PSSysBICubeMSJoin pSSysBICubeMSJoin, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PPSSysBICubeMSJoin(PSSysBICubeMSJoin pSSysBICubeMSJoin, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysBICubeMSJoin pSSysBICubeMSJoin, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysBICubeMSJoin, bl);
    }

    public ArrayList<PSSysBICubeMSJoin> selectByJoinPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByJoinPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysBICubeMSJoin> selectByJoinPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByJoinPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysBICubeMSJoin> selectByJoinPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("JOINPSDEID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByJoinPSDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByJoinPSDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBICubeMSJoin> selectByPSDEJoinType(PSDEJoinTypeBase pSDEJoinTypeBase) throws Exception {
        return this.selectByPSDEJoinType(pSDEJoinTypeBase, "", -1);
    }

    public ArrayList<PSSysBICubeMSJoin> selectByPSDEJoinType(PSDEJoinTypeBase pSDEJoinTypeBase, String string) throws Exception {
        return this.selectByPSDEJoinType(pSDEJoinTypeBase, string, -1);
    }

    public ArrayList<PSSysBICubeMSJoin> selectByPSDEJoinType(PSDEJoinTypeBase pSDEJoinTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEJOINTYPEID", (Object)pSDEJoinTypeBase.getPSDEJoinTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEJoinTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEJoinTypeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBICubeMSJoin> selectByPSDER(PSDERBase pSDERBase) throws Exception {
        return this.selectByPSDER(pSDERBase, "", -1);
    }

    public ArrayList<PSSysBICubeMSJoin> selectByPSDER(PSDERBase pSDERBase, String string) throws Exception {
        return this.selectByPSDER(pSDERBase, string, -1);
    }

    public ArrayList<PSSysBICubeMSJoin> selectByPSDER(PSDERBase pSDERBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDERID", (Object)pSDERBase.getPSDERId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDERCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDERCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBICubeMSJoin> selectByPSSysBICubeMeasure(PSSysBICubeMeasureBase pSSysBICubeMeasureBase) throws Exception {
        return this.selectByPSSysBICubeMeasure(pSSysBICubeMeasureBase, "", -1);
    }

    public ArrayList<PSSysBICubeMSJoin> selectByPSSysBICubeMeasure(PSSysBICubeMeasureBase pSSysBICubeMeasureBase, String string) throws Exception {
        return this.selectByPSSysBICubeMeasure(pSSysBICubeMeasureBase, string, -1);
    }

    public ArrayList<PSSysBICubeMSJoin> selectByPSSysBICubeMeasure(PSSysBICubeMeasureBase pSSysBICubeMeasureBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSBICUBEMEASUREID", (Object)pSSysBICubeMeasureBase.getPSSysBICubeMeasureId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysBICubeMeasureCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysBICubeMeasureCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBICubeMSJoin> selectByPPSSysBICubeMSJoin(PSSysBICubeMSJoinBase pSSysBICubeMSJoinBase) throws Exception {
        return this.selectByPPSSysBICubeMSJoin(pSSysBICubeMSJoinBase, "", -1);
    }

    public ArrayList<PSSysBICubeMSJoin> selectByPPSSysBICubeMSJoin(PSSysBICubeMSJoinBase pSSysBICubeMSJoinBase, String string) throws Exception {
        return this.selectByPPSSysBICubeMSJoin(pSSysBICubeMSJoinBase, string, -1);
    }

    public ArrayList<PSSysBICubeMSJoin> selectByPPSSysBICubeMSJoin(PSSysBICubeMSJoinBase pSSysBICubeMSJoinBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSSYSBICUBEMSJOINID", (Object)pSSysBICubeMSJoinBase.getPSSysBICubeMSJoinId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSSysBICubeMSJoinCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSSysBICubeMSJoinCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByJoinPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysBICubeMSJoin> arrayList = this.selectByJoinPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBICUBEMSJOIN_PSDATAENTITY_JOINPSDEID", "", iDataEntityModel.getName(), "PSSYSBICUBEMSJOIN", iDataEntityModel.getDataInfo(pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetJoinPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysBICubeMSJoin> arrayList = this.selectByJoinPSDE(pSDataEntity);
        for (PSSysBICubeMSJoin pSSysBICubeMSJoin : arrayList) {
            PSSysBICubeMSJoin pSSysBICubeMSJoin2 = (PSSysBICubeMSJoin)this.getDEModel().createEntity();
            pSSysBICubeMSJoin2.setPSSysBICubeMSJoinId(pSSysBICubeMSJoin.getPSSysBICubeMSJoinId());
            pSSysBICubeMSJoin2.setJoinPSDEId(null);
            this.update(pSSysBICubeMSJoin2);
        }
    }

    public void removeByJoinPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBICubeMSJoinServiceBase.this.onBeforeRemoveByJoinPSDE(pSDataEntity2);
                PSSysBICubeMSJoinServiceBase.this.internalRemoveByJoinPSDE(pSDataEntity2);
                PSSysBICubeMSJoinServiceBase.this.onAfterRemoveByJoinPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByJoinPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByJoinPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysBICubeMSJoin> arrayList = this.selectByJoinPSDE(pSDataEntity);
        this.onBeforeRemoveByJoinPSDE(pSDataEntity, arrayList);
        for (PSSysBICubeMSJoin pSSysBICubeMSJoin : arrayList) {
            this.remove(pSSysBICubeMSJoin);
        }
        this.onAfterRemoveByJoinPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByJoinPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByJoinPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysBICubeMSJoin> arrayList) throws Exception {
    }

    protected void onAfterRemoveByJoinPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysBICubeMSJoin> arrayList) throws Exception {
    }

    public void testRemoveByPSDEJoinType(PSDEJoinType pSDEJoinType) throws Exception {
        ArrayList<PSSysBICubeMSJoin> arrayList = this.selectByPSDEJoinType(pSDEJoinType, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEJOINTYPE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEJoinType);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBICUBEMSJOIN_PSDEJOINTYPE_PSDEJOINTYPEID", "", iDataEntityModel.getName(), "PSSYSBICUBEMSJOIN", iDataEntityModel.getDataInfo(pSDEJoinType), arrayList.get(0)));
        }
    }

    public void resetPSDEJoinType(PSDEJoinType pSDEJoinType) throws Exception {
        ArrayList<PSSysBICubeMSJoin> arrayList = this.selectByPSDEJoinType(pSDEJoinType);
        for (PSSysBICubeMSJoin pSSysBICubeMSJoin : arrayList) {
            PSSysBICubeMSJoin pSSysBICubeMSJoin2 = (PSSysBICubeMSJoin)this.getDEModel().createEntity();
            pSSysBICubeMSJoin2.setPSSysBICubeMSJoinId(pSSysBICubeMSJoin.getPSSysBICubeMSJoinId());
            pSSysBICubeMSJoin2.setPSDEJoinTypeId(null);
            this.update(pSSysBICubeMSJoin2);
        }
    }

    public void removeByPSDEJoinType(PSDEJoinType pSDEJoinType) throws Exception {
        final PSDEJoinType pSDEJoinType2 = pSDEJoinType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBICubeMSJoinServiceBase.this.onBeforeRemoveByPSDEJoinType(pSDEJoinType2);
                PSSysBICubeMSJoinServiceBase.this.internalRemoveByPSDEJoinType(pSDEJoinType2);
                PSSysBICubeMSJoinServiceBase.this.onAfterRemoveByPSDEJoinType(pSDEJoinType2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEJoinType(PSDEJoinType pSDEJoinType) throws Exception {
    }

    protected void internalRemoveByPSDEJoinType(PSDEJoinType pSDEJoinType) throws Exception {
        ArrayList<PSSysBICubeMSJoin> arrayList = this.selectByPSDEJoinType(pSDEJoinType);
        this.onBeforeRemoveByPSDEJoinType(pSDEJoinType, arrayList);
        for (PSSysBICubeMSJoin pSSysBICubeMSJoin : arrayList) {
            this.remove(pSSysBICubeMSJoin);
        }
        this.onAfterRemoveByPSDEJoinType(pSDEJoinType, arrayList);
    }

    protected void onAfterRemoveByPSDEJoinType(PSDEJoinType pSDEJoinType) throws Exception {
    }

    protected void onBeforeRemoveByPSDEJoinType(PSDEJoinType pSDEJoinType, ArrayList<PSSysBICubeMSJoin> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEJoinType(PSDEJoinType pSDEJoinType, ArrayList<PSSysBICubeMSJoin> arrayList) throws Exception {
    }

    public void testRemoveByPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSSysBICubeMSJoin> arrayList = this.selectByPSDER(pSDER, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDER);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBICUBEMSJOIN_PSDER_PSDERID", "", iDataEntityModel.getName(), "PSSYSBICUBEMSJOIN", iDataEntityModel.getDataInfo(pSDER), arrayList.get(0)));
        }
    }

    public void resetPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSSysBICubeMSJoin> arrayList = this.selectByPSDER(pSDER);
        for (PSSysBICubeMSJoin pSSysBICubeMSJoin : arrayList) {
            PSSysBICubeMSJoin pSSysBICubeMSJoin2 = (PSSysBICubeMSJoin)this.getDEModel().createEntity();
            pSSysBICubeMSJoin2.setPSSysBICubeMSJoinId(pSSysBICubeMSJoin.getPSSysBICubeMSJoinId());
            pSSysBICubeMSJoin2.setPSDERId(null);
            this.update(pSSysBICubeMSJoin2);
        }
    }

    public void removeByPSDER(PSDER pSDER) throws Exception {
        final PSDER pSDER2 = pSDER;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBICubeMSJoinServiceBase.this.onBeforeRemoveByPSDER(pSDER2);
                PSSysBICubeMSJoinServiceBase.this.internalRemoveByPSDER(pSDER2);
                PSSysBICubeMSJoinServiceBase.this.onAfterRemoveByPSDER(pSDER2);
            }
        });
    }

    protected void onBeforeRemoveByPSDER(PSDER pSDER) throws Exception {
    }

    protected void internalRemoveByPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSSysBICubeMSJoin> arrayList = this.selectByPSDER(pSDER);
        this.onBeforeRemoveByPSDER(pSDER, arrayList);
        for (PSSysBICubeMSJoin pSSysBICubeMSJoin : arrayList) {
            this.remove(pSSysBICubeMSJoin);
        }
        this.onAfterRemoveByPSDER(pSDER, arrayList);
    }

    protected void onAfterRemoveByPSDER(PSDER pSDER) throws Exception {
    }

    protected void onBeforeRemoveByPSDER(PSDER pSDER, ArrayList<PSSysBICubeMSJoin> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDER(PSDER pSDER, ArrayList<PSSysBICubeMSJoin> arrayList) throws Exception {
    }

    public void testRemoveByPSSysBICubeMeasure(PSSysBICubeMeasure pSSysBICubeMeasure) throws Exception {
    }

    public void resetPSSysBICubeMeasure(PSSysBICubeMeasure pSSysBICubeMeasure) throws Exception {
        ArrayList<PSSysBICubeMSJoin> arrayList = this.selectByPSSysBICubeMeasure(pSSysBICubeMeasure);
        for (PSSysBICubeMSJoin pSSysBICubeMSJoin : arrayList) {
            PSSysBICubeMSJoin pSSysBICubeMSJoin2 = (PSSysBICubeMSJoin)this.getDEModel().createEntity();
            pSSysBICubeMSJoin2.setPSSysBICubeMSJoinId(pSSysBICubeMSJoin.getPSSysBICubeMSJoinId());
            pSSysBICubeMSJoin2.setPSSysBICubeMeasureId(null);
            this.update(pSSysBICubeMSJoin2);
        }
    }

    public void removeByPSSysBICubeMeasure(PSSysBICubeMeasure pSSysBICubeMeasure) throws Exception {
        final PSSysBICubeMeasure pSSysBICubeMeasure2 = pSSysBICubeMeasure;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBICubeMSJoinServiceBase.this.onBeforeRemoveByPSSysBICubeMeasure(pSSysBICubeMeasure2);
                PSSysBICubeMSJoinServiceBase.this.internalRemoveByPSSysBICubeMeasure(pSSysBICubeMeasure2);
                PSSysBICubeMSJoinServiceBase.this.onAfterRemoveByPSSysBICubeMeasure(pSSysBICubeMeasure2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBICubeMeasure(PSSysBICubeMeasure pSSysBICubeMeasure) throws Exception {
    }

    protected void internalRemoveByPSSysBICubeMeasure(PSSysBICubeMeasure pSSysBICubeMeasure) throws Exception {
        ArrayList<PSSysBICubeMSJoin> arrayList = this.selectByPSSysBICubeMeasure(pSSysBICubeMeasure);
        this.onBeforeRemoveByPSSysBICubeMeasure(pSSysBICubeMeasure, arrayList);
        for (PSSysBICubeMSJoin pSSysBICubeMSJoin : arrayList) {
            this.remove(pSSysBICubeMSJoin);
        }
        this.onAfterRemoveByPSSysBICubeMeasure(pSSysBICubeMeasure, arrayList);
    }

    protected void onAfterRemoveByPSSysBICubeMeasure(PSSysBICubeMeasure pSSysBICubeMeasure) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBICubeMeasure(PSSysBICubeMeasure pSSysBICubeMeasure, ArrayList<PSSysBICubeMSJoin> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBICubeMeasure(PSSysBICubeMeasure pSSysBICubeMeasure, ArrayList<PSSysBICubeMSJoin> arrayList) throws Exception {
    }

    public void testRemoveByPPSSysBICubeMSJoin(PSSysBICubeMSJoin pSSysBICubeMSJoin) throws Exception {
    }

    public void resetPPSSysBICubeMSJoin(PSSysBICubeMSJoin pSSysBICubeMSJoin) throws Exception {
        ArrayList<PSSysBICubeMSJoin> arrayList = this.selectByPPSSysBICubeMSJoin(pSSysBICubeMSJoin);
        for (PSSysBICubeMSJoin pSSysBICubeMSJoin2 : arrayList) {
            PSSysBICubeMSJoin pSSysBICubeMSJoin3 = (PSSysBICubeMSJoin)this.getDEModel().createEntity();
            pSSysBICubeMSJoin3.setPSSysBICubeMSJoinId(pSSysBICubeMSJoin2.getPSSysBICubeMSJoinId());
            pSSysBICubeMSJoin3.setPPSSysBICubeMSJoinId(null);
            this.update(pSSysBICubeMSJoin3);
        }
    }

    public void removeByPPSSysBICubeMSJoin(PSSysBICubeMSJoin pSSysBICubeMSJoin) throws Exception {
        final PSSysBICubeMSJoin pSSysBICubeMSJoin2 = pSSysBICubeMSJoin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBICubeMSJoinServiceBase.this.onBeforeRemoveByPPSSysBICubeMSJoin(pSSysBICubeMSJoin2);
                PSSysBICubeMSJoinServiceBase.this.internalRemoveByPPSSysBICubeMSJoin(pSSysBICubeMSJoin2);
                PSSysBICubeMSJoinServiceBase.this.onAfterRemoveByPPSSysBICubeMSJoin(pSSysBICubeMSJoin2);
            }
        });
    }

    protected void onBeforeRemoveByPPSSysBICubeMSJoin(PSSysBICubeMSJoin pSSysBICubeMSJoin) throws Exception {
    }

    protected void internalRemoveByPPSSysBICubeMSJoin(PSSysBICubeMSJoin pSSysBICubeMSJoin) throws Exception {
        ArrayList<PSSysBICubeMSJoin> arrayList = this.selectByPPSSysBICubeMSJoin(pSSysBICubeMSJoin);
        this.onBeforeRemoveByPPSSysBICubeMSJoin(pSSysBICubeMSJoin, arrayList);
        for (PSSysBICubeMSJoin pSSysBICubeMSJoin2 : arrayList) {
            this.remove(pSSysBICubeMSJoin2);
        }
        this.onAfterRemoveByPPSSysBICubeMSJoin(pSSysBICubeMSJoin, arrayList);
    }

    protected void onAfterRemoveByPPSSysBICubeMSJoin(PSSysBICubeMSJoin pSSysBICubeMSJoin) throws Exception {
    }

    protected void onBeforeRemoveByPPSSysBICubeMSJoin(PSSysBICubeMSJoin pSSysBICubeMSJoin, ArrayList<PSSysBICubeMSJoin> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSSysBICubeMSJoin(PSSysBICubeMSJoin pSSysBICubeMSJoin, ArrayList<PSSysBICubeMSJoin> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysBICubeMSJoin pSSysBICubeMSJoin) throws Exception {
        PSSysBICubeMSJoinService pSSysBICubeMSJoinService = (PSSysBICubeMSJoinService)ServiceGlobal.getService(PSSysBICubeMSJoinService.class, (SessionFactory)this.getSessionFactory());
        pSSysBICubeMSJoinService.testRemoveByPPSSysBICubeMSJoin(pSSysBICubeMSJoin);
        pSSysBICubeMSJoinService.removeByPPSSysBICubeMSJoin(pSSysBICubeMSJoin);
        super.onBeforeRemove(pSSysBICubeMSJoin);
    }

    protected void replaceParentInfo(PSSysBICubeMSJoin pSSysBICubeMSJoin, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysBICubeMSJoin, cloneSession);
        if (pSSysBICubeMSJoin.getJoinPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysBICubeMSJoin.getJoinPSDEId())) != null) {
            this.onFillParentInfo_JoinPSDE(pSSysBICubeMSJoin, (PSDataEntity)iEntity);
        }
        if (pSSysBICubeMSJoin.getPSDEJoinTypeId() != null && (iEntity = cloneSession.getEntity("PSDEJOINTYPE", (Object)pSSysBICubeMSJoin.getPSDEJoinTypeId())) != null) {
            this.onFillParentInfo_PSDEJoinType(pSSysBICubeMSJoin, (PSDEJoinType)iEntity);
        }
        if (pSSysBICubeMSJoin.getPSDERId() != null && (iEntity = cloneSession.getEntity("PSDER", (Object)pSSysBICubeMSJoin.getPSDERId())) != null) {
            this.onFillParentInfo_PSDER(pSSysBICubeMSJoin, (PSDER)iEntity);
        }
        if (pSSysBICubeMSJoin.getPSSysBICubeMeasureId() != null && (iEntity = cloneSession.getEntity("PSSYSBICUBEMEASURE", (Object)pSSysBICubeMSJoin.getPSSysBICubeMeasureId())) != null) {
            this.onFillParentInfo_PSSysBICubeMeasure(pSSysBICubeMSJoin, (PSSysBICubeMeasure)iEntity);
        }
        if (pSSysBICubeMSJoin.getPPSSysBICubeMSJoinId() != null && (iEntity = cloneSession.getEntity("PSSYSBICUBEMSJOIN", (Object)pSSysBICubeMSJoin.getPPSSysBICubeMSJoinId())) != null) {
            this.onFillParentInfo_PPSSysBICubeMSJoin(pSSysBICubeMSJoin, (PSSysBICubeMSJoin)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysBICubeMSJoin pSSysBICubeMSJoin, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysBICubeMSJoin, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysBICubeMSJoin pSSysBICubeMSJoin, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_JoinPSDEId(bl, pSSysBICubeMSJoin, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_JoinPSDEName(bl, pSSysBICubeMSJoin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_JoinTag(bl, pSSysBICubeMSJoin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_JoinTag2(bl, pSSysBICubeMSJoin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysBICubeMSJoin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysBICubeMSJoin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSSysBICubeMSJoinId(bl, pSSysBICubeMSJoin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEJoinTypeId(bl, pSSysBICubeMSJoin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEJoinTypeName(bl, pSSysBICubeMSJoin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDERId(bl, pSSysBICubeMSJoin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBICubeMeasureId(bl, pSSysBICubeMSJoin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBICubeMSJoinId(bl, pSSysBICubeMSJoin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBICubeMSJoinName(bl, pSSysBICubeMSJoin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysBICubeMSJoin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysBICubeMSJoin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysBICubeMSJoin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysBICubeMSJoin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysBICubeMSJoin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysBICubeMSJoin, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_JoinPSDEId(boolean bl, PSSysBICubeMSJoin pSSysBICubeMSJoin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSJoin.isJoinPSDEIdDirty() : !pSSysBICubeMSJoin.isJoinPSDEIdDirty()) {
            return null;
        }
        String string = pSSysBICubeMSJoin.getJoinPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_JoinPSDEId_Default(pSSysBICubeMSJoin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("JOINPSDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_JoinPSDEName(boolean bl, PSSysBICubeMSJoin pSSysBICubeMSJoin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSJoin.isJoinPSDENameDirty() : !pSSysBICubeMSJoin.isJoinPSDENameDirty()) {
            return null;
        }
        String string = pSSysBICubeMSJoin.getJoinPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_JoinPSDEName_Default(pSSysBICubeMSJoin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("JOINPSDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_JoinTag(boolean bl, PSSysBICubeMSJoin pSSysBICubeMSJoin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSJoin.isJoinTagDirty() : !pSSysBICubeMSJoin.isJoinTagDirty()) {
            return null;
        }
        String string = pSSysBICubeMSJoin.getJoinTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_JoinTag_Default(pSSysBICubeMSJoin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("JOINTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_JoinTag2(boolean bl, PSSysBICubeMSJoin pSSysBICubeMSJoin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSJoin.isJoinTag2Dirty() : !pSSysBICubeMSJoin.isJoinTag2Dirty()) {
            return null;
        }
        String string = pSSysBICubeMSJoin.getJoinTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_JoinTag2_Default(pSSysBICubeMSJoin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("JOINTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysBICubeMSJoin pSSysBICubeMSJoin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSJoin.isMemoDirty() : !pSSysBICubeMSJoin.isMemoDirty()) {
            return null;
        }
        String string = pSSysBICubeMSJoin.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysBICubeMSJoin, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysBICubeMSJoin pSSysBICubeMSJoin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSJoin.isOrderValueDirty() : !pSSysBICubeMSJoin.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysBICubeMSJoin.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSSysBICubeMSJoin, bl2, bl3);
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

    protected EntityFieldError onCheckField_PPSSysBICubeMSJoinId(boolean bl, PSSysBICubeMSJoin pSSysBICubeMSJoin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSJoin.isPPSSysBICubeMSJoinIdDirty() : !pSSysBICubeMSJoin.isPPSSysBICubeMSJoinIdDirty()) {
            return null;
        }
        String string = pSSysBICubeMSJoin.getPPSSysBICubeMSJoinId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSSysBICubeMSJoinId_Default(pSSysBICubeMSJoin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSSYSBICUBEMSJOINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEJoinTypeId(boolean bl, PSSysBICubeMSJoin pSSysBICubeMSJoin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSJoin.isPSDEJoinTypeIdDirty() : !pSSysBICubeMSJoin.isPSDEJoinTypeIdDirty()) {
            return null;
        }
        String string = pSSysBICubeMSJoin.getPSDEJoinTypeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEJoinTypeId_Default(pSSysBICubeMSJoin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEJOINTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEJoinTypeName(boolean bl, PSSysBICubeMSJoin pSSysBICubeMSJoin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSJoin.isPSDEJoinTypeNameDirty() : !pSSysBICubeMSJoin.isPSDEJoinTypeNameDirty()) {
            return null;
        }
        String string = pSSysBICubeMSJoin.getPSDEJoinTypeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEJoinTypeName_Default(pSSysBICubeMSJoin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEJOINTYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDERId(boolean bl, PSSysBICubeMSJoin pSSysBICubeMSJoin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSJoin.isPSDERIdDirty() : !pSSysBICubeMSJoin.isPSDERIdDirty()) {
            return null;
        }
        String string = pSSysBICubeMSJoin.getPSDERId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDERId_Default(pSSysBICubeMSJoin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBICubeMeasureId(boolean bl, PSSysBICubeMSJoin pSSysBICubeMSJoin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSJoin.isPSSysBICubeMeasureIdDirty() : !pSSysBICubeMSJoin.isPSSysBICubeMeasureIdDirty()) {
            return null;
        }
        String string = pSSysBICubeMSJoin.getPSSysBICubeMeasureId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBICubeMeasureId_Default(pSSysBICubeMSJoin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBICUBEMEASUREID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBICubeMSJoinId(boolean bl, PSSysBICubeMSJoin pSSysBICubeMSJoin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSJoin.isPSSysBICubeMSJoinIdDirty() && !bl2 : !pSSysBICubeMSJoin.isPSSysBICubeMSJoinIdDirty()) {
            return null;
        }
        String string = pSSysBICubeMSJoin.getPSSysBICubeMSJoinId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBICUBEMSJOINID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBICubeMSJoinId_Default(pSSysBICubeMSJoin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBICUBEMSJOINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBICubeMSJoinName(boolean bl, PSSysBICubeMSJoin pSSysBICubeMSJoin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSJoin.isPSSysBICubeMSJoinNameDirty() && !bl2 : !pSSysBICubeMSJoin.isPSSysBICubeMSJoinNameDirty()) {
            return null;
        }
        String string = pSSysBICubeMSJoin.getPSSysBICubeMSJoinName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBICUBEMSJOINNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBICubeMSJoinName_Default(pSSysBICubeMSJoin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBICUBEMSJOINNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysBICubeMSJoin pSSysBICubeMSJoin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSJoin.isUserCatDirty() : !pSSysBICubeMSJoin.isUserCatDirty()) {
            return null;
        }
        String string = pSSysBICubeMSJoin.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysBICubeMSJoin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERCAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysBICubeMSJoin pSSysBICubeMSJoin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSJoin.isUserTagDirty() : !pSSysBICubeMSJoin.isUserTagDirty()) {
            return null;
        }
        String string = pSSysBICubeMSJoin.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysBICubeMSJoin, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysBICubeMSJoin pSSysBICubeMSJoin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSJoin.isUserTag2Dirty() : !pSSysBICubeMSJoin.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysBICubeMSJoin.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysBICubeMSJoin, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysBICubeMSJoin pSSysBICubeMSJoin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSJoin.isUserTag3Dirty() : !pSSysBICubeMSJoin.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysBICubeMSJoin.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysBICubeMSJoin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysBICubeMSJoin pSSysBICubeMSJoin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSJoin.isUserTag4Dirty() : !pSSysBICubeMSJoin.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysBICubeMSJoin.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysBICubeMSJoin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysBICubeMSJoin pSSysBICubeMSJoin, boolean bl) throws Exception {
        super.onSyncEntity(pSSysBICubeMSJoin, bl);
    }

    protected void onSyncIndexEntities(PSSysBICubeMSJoin pSSysBICubeMSJoin, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysBICubeMSJoin, bl);
    }

    public Object getDataContextValue(PSSysBICubeMSJoin pSSysBICubeMSJoin, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysBICubeMSJoin, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysBICubeMSJoin pSSysBICubeMSJoin, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysBICubeMSJoin, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"JOINPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_JoinPSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"JOINPSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_JoinPSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"JOINTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_JoinTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"JOINTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_JoinTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PJOINPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PJoinPSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSSYSBICUBEMSJOINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSSysBICubeMSJoinId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSSYSBICUBEMSJOINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSSysBICubeMSJoinName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEJOINTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEJoinTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEJOINTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEJoinTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBICUBEMEASUREID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBICubeMeasureId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBICUBEMEASURENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBICubeMeasureName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBICUBEMSJOINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBICubeMSJoinId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBICUBEMSJOINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBICubeMSJoinName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERCAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserCat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag4_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_JoinPSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("JOINPSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_JoinPSDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("JOINPSDENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_JoinTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("JOINTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_JoinTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("JOINTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_PJoinPSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PJOINPSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSSysBICubeMSJoinId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSSYSBICUBEMSJOINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSSysBICubeMSJoinName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSSYSBICUBEMSJOINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEJoinTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEJOINTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEJoinTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEJOINTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDERId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDERName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBICubeMeasureId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBICUBEMEASUREID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBICubeMeasureName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBICUBEMEASURENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBICubeMSJoinId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBICUBEMSJOINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBICubeMSJoinName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBICUBEMSJOINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_UserCat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERCAT", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG3", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG4", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSSysBICubeMSJoin pSSysBICubeMSJoin) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysBICubeMSJoin)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysBICubeMSJoin pSSysBICubeMSJoin) throws Exception {
        super.onUpdateParent(pSSysBICubeMSJoin);
    }

    @Override
    protected void exportCurXmlModel(PSSysBICubeMSJoin pSSysBICubeMSJoin, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSBICUBEMSJOIN");
        if (!bl) {
            pSSysBICubeMSJoin.setCreateDate(null);
            pSSysBICubeMSJoin.setCreateMan(null);
            pSSysBICubeMSJoin.setPSSysBICubeMSJoinId(null);
            pSSysBICubeMSJoin.setUpdateDate(null);
            pSSysBICubeMSJoin.setUpdateMan(null);
            super.exportCurXmlModel(pSSysBICubeMSJoin, xmlNode, bl);
        }
    }
}

