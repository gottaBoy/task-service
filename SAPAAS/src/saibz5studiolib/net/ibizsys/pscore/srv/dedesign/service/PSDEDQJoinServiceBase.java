/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.db.SqlParamList
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.SimpleEntity
 *  net.ibizsys.paas.service.CloneSession
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.IServicePlugin
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.dedesign.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.service.CloneSession;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSDEJoinType;
import net.ibizsys.pscore.srv.config.entity.PSDEJoinTypeBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEDQJoinDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEDQJoinDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCond;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCondBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQJoin;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQJoinBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQueryBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDERBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDQCondService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDQCondServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDQJoinService;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDQJoinServiceBase
extends PSCoreSysServiceBase<PSDEDQJoin> {
    private static final Log log = LogFactory.getLog(PSDEDQJoinServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_CALCJOINPSDEID = "CalcJoinPSDEId";
    public static final String ACTION_CREATEWITHMODEL = "CreateWithModel";
    public static final String ACTION_GETWITHMODEL = "GetWithModel";
    public static final String ACTION_UPDATEWITHMODEL = "UpdateWithModel";
    private PSDEDQJoinDEModel pSDEDQJoinDEModel;
    private PSDEDQJoinDAO pSDEDQJoinDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEDQJoinService";
    }

    public PSDEDQJoinDEModel getPSDEDQJoinDEModel() {
        if (this.pSDEDQJoinDEModel == null) {
            try {
                this.pSDEDQJoinDEModel = (PSDEDQJoinDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEDQJoinDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDQJoinDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEDQJoinDEModel();
    }

    public PSDEDQJoinDAO getPSDEDQJoinDAO() {
        if (this.pSDEDQJoinDAO == null) {
            try {
                this.pSDEDQJoinDAO = (PSDEDQJoinDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEDQJoinDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDQJoinDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEDQJoinDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_CALCJOINPSDEID, (boolean)true) == 0) {
            this.calcJoinPSDEId((PSDEDQJoin)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_CREATEWITHMODEL, (boolean)true) == 0) {
            this.createWithModel((PSDEDQJoin)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETWITHMODEL, (boolean)true) == 0) {
            this.getWithModel((PSDEDQJoin)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_UPDATEWITHMODEL, (boolean)true) == 0) {
            this.updateWithModel((PSDEDQJoin)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, true);
        return dBFetchResult;
    }

    public void calcJoinPSDEId(PSDEDQJoin pSDEDQJoin) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CALCJOINPSDEID, 0, (IEntity)pSDEDQJoin, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEDQJoin, ACTION_CALCJOINPSDEID);
        final PSDEDQJoin pSDEDQJoin2 = pSDEDQJoin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEDQJoinServiceBase.this.getService(), PSDEDQJoinServiceBase.ACTION_CALCJOINPSDEID, 40, (IEntity)pSDEDQJoin2, null).getResult() != 1) {
                    PSDEDQJoinServiceBase.this.onCalcJoinPSDEId(pSDEDQJoin2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CALCJOINPSDEID, 99, (IEntity)pSDEDQJoin, null);
        }
    }

    protected void onCalcJoinPSDEId(PSDEDQJoin pSDEDQJoin) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CalcJoinPSDEId]");
    }

    public void createWithModel(PSDEDQJoin pSDEDQJoin) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 0, (IEntity)pSDEDQJoin, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEDQJoin, ACTION_CREATEWITHMODEL);
        final PSDEDQJoin pSDEDQJoin2 = pSDEDQJoin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEDQJoinServiceBase.this.getService(), PSDEDQJoinServiceBase.ACTION_CREATEWITHMODEL, 40, (IEntity)pSDEDQJoin2, null).getResult() != 1) {
                    PSDEDQJoinServiceBase.this.onCreateWithModel(pSDEDQJoin2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 99, (IEntity)pSDEDQJoin, null);
        }
    }

    protected void onCreateWithModel(PSDEDQJoin pSDEDQJoin) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CreateWithModel]");
    }

    public void getWithModel(PSDEDQJoin pSDEDQJoin) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 0, (IEntity)pSDEDQJoin, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEDQJoin, ACTION_GETWITHMODEL);
        final PSDEDQJoin pSDEDQJoin2 = pSDEDQJoin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEDQJoinServiceBase.this.getService(), PSDEDQJoinServiceBase.ACTION_GETWITHMODEL, 40, (IEntity)pSDEDQJoin2, null).getResult() != 1) {
                    PSDEDQJoinServiceBase.this.onGetWithModel(pSDEDQJoin2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 99, (IEntity)pSDEDQJoin, null);
        }
    }

    protected void onGetWithModel(PSDEDQJoin pSDEDQJoin) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetWithModel]");
    }

    public void updateWithModel(PSDEDQJoin pSDEDQJoin) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 0, (IEntity)pSDEDQJoin, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEDQJoin, ACTION_UPDATEWITHMODEL);
        final PSDEDQJoin pSDEDQJoin2 = pSDEDQJoin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEDQJoinServiceBase.this.getService(), PSDEDQJoinServiceBase.ACTION_UPDATEWITHMODEL, 40, (IEntity)pSDEDQJoin2, null).getResult() != 1) {
                    PSDEDQJoinServiceBase.this.onUpdateWithModel(pSDEDQJoin2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 99, (IEntity)pSDEDQJoin, null);
        }
    }

    protected void onUpdateWithModel(PSDEDQJoin pSDEDQJoin) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[UpdateWithModel]");
    }

    protected void onFillParentInfo(PSDEDQJoin pSDEDQJoin, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDQJOIN_PSDATAENTITY_JOINPSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_JoinPSDE(pSDEDQJoin, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDQJOIN_PSDEDATAQUERY_PSDEDQID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService", (SessionFactory)this.getSessionFactory());
            PSDEDataQuery pSDEDataQuery = (PSDEDataQuery)iService.getDEModel().createEntity();
            pSDEDataQuery.set("PSDEDATAQUERYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataQuery);
            } else {
                iService.get((IEntity)pSDEDataQuery);
            }
            this.onFillParentInfo_PSDEDQ(pSDEDQJoin, pSDEDataQuery);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDQJOIN_PSDEDQJOIN_PPSDEDQJOINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDQJoinService", (SessionFactory)this.getSessionFactory());
            PSDEDQJoin pSDEDQJoin2 = (PSDEDQJoin)iService.getDEModel().createEntity();
            pSDEDQJoin2.set("PSDEDQJOINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDQJoin2);
            } else {
                iService.get((IEntity)pSDEDQJoin2);
            }
            this.onFillParentInfo_PPSDEDQJoin(pSDEDQJoin, pSDEDQJoin2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDQJOIN_PSDEJOINTYPE_PSDEJOINTYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDEJoinTypeService", (SessionFactory)this.getSessionFactory());
            PSDEJoinType pSDEJoinType = (PSDEJoinType)iService.getDEModel().createEntity();
            pSDEJoinType.set("PSDEJOINTYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEJoinType);
            } else {
                iService.get((IEntity)pSDEJoinType);
            }
            this.onFillParentInfo_PSDEJoinType(pSDEDQJoin, pSDEJoinType);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDQJOIN_PSDER_PSDERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDERService", (SessionFactory)this.getSessionFactory());
            PSDER pSDER = (PSDER)iService.getDEModel().createEntity();
            pSDER.set("PSDERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDER);
            } else {
                iService.get((IEntity)pSDER);
            }
            this.onFillParentInfo_PSDER(pSDEDQJoin, pSDER);
            return;
        }
        super.onFillParentInfo((IEntity)pSDEDQJoin, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEDQJOIN_PSDEDATAQUERY_PSDEDQID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService", (SessionFactory)this.getSessionFactory());
            PSDEDataQuery pSDEDataQuery = (PSDEDataQuery)iService.getDEModel().createEntity();
            pSDEDataQuery.set("PSDEDATAQUERYID", string2);
            return this.onSyncDER1NData_PSDEDQ(pSDEDataQuery, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_JoinPSDE(PSDEDQJoin pSDEDQJoin, PSDataEntity pSDataEntity) throws Exception {
        pSDEDQJoin.setJoinPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEDQJoin.setJoinPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDEDQ(PSDEDQJoin pSDEDQJoin, PSDEDataQuery pSDEDataQuery) throws Exception {
        pSDEDQJoin.setPSDEDQId(pSDEDataQuery.getPSDEDataQueryId());
        pSDEDQJoin.setPSDEDQName(pSDEDataQuery.getPSDEDataQueryName());
    }

    protected String onSyncDER1NData_PSDEDQ(PSDEDataQuery pSDEDataQuery, String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.removeByPSDEDQ(pSDEDataQuery);
        } else {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            String[] stringArray = StringHelper.splitEx((String)string);
            if (stringArray != null) {
                for (int i = 0; i < stringArray.length; ++i) {
                    if (StringHelper.isNullOrEmpty((String)stringArray[i])) continue;
                    hashMap.put(stringArray[i], "");
                }
            }
            ArrayList<PSDEDQJoin> arrayList = this.selectByPSDEDQ(pSDEDataQuery);
            for (PSDEDQJoin pSDEDQJoin : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSDEDQJoin, (String)"PSDEDQJOINID", (String)""))) continue;
                this.remove((IEntity)pSDEDQJoin);
            }
        }
        return null;
    }

    protected void onFillParentInfo_PPSDEDQJoin(PSDEDQJoin pSDEDQJoin, PSDEDQJoin pSDEDQJoin2) throws Exception {
        pSDEDQJoin.setPJoinPSDEId(pSDEDQJoin2.getJoinPSDEId());
        pSDEDQJoin.setPPSDEDQJoinId(pSDEDQJoin2.getPSDEDQJoinId());
        pSDEDQJoin.setPPSDEDQJoinName(pSDEDQJoin2.getPSDEDQJoinName());
        if (pSDEDQJoin2.getPSDEDQ() != null) {
            this.onFillParentInfo_PSDEDQ(pSDEDQJoin, pSDEDQJoin2.getPSDEDQ());
        }
    }

    protected void onFillParentInfo_PSDEJoinType(PSDEDQJoin pSDEDQJoin, PSDEJoinType pSDEJoinType) throws Exception {
        pSDEDQJoin.setPSDEJoinTypeId(pSDEJoinType.getPSDEJoinTypeId());
        pSDEDQJoin.setPSDEJoinTypeName(pSDEJoinType.getPSDEJoinTypeName());
    }

    protected void onFillParentInfo_PSDER(PSDEDQJoin pSDEDQJoin, PSDER pSDER) throws Exception {
        pSDEDQJoin.setPSDERId(pSDER.getPSDERId());
        pSDEDQJoin.setPSDERName(pSDER.getPSDERName());
    }

    protected void onFillEntityFullInfo(PSDEDQJoin pSDEDQJoin, boolean bl) throws Exception {
        if (bl && pSDEDQJoin.getModelState() == null) {
            pSDEDQJoin.setModelState((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSDEDQJoin, bl);
        this.onFillEntityFullInfo_JoinPSDE(pSDEDQJoin, bl);
        this.onFillEntityFullInfo_PSDEDQ(pSDEDQJoin, bl);
        this.onFillEntityFullInfo_PPSDEDQJoin(pSDEDQJoin, bl);
        this.onFillEntityFullInfo_PSDEJoinType(pSDEDQJoin, bl);
        this.onFillEntityFullInfo_PSDER(pSDEDQJoin, bl);
    }

    protected void onFillEntityFullInfo_JoinPSDE(PSDEDQJoin pSDEDQJoin, boolean bl) throws Exception {
        if (pSDEDQJoin.isJoinPSDEIdDirty()) {
            if (pSDEDQJoin.getJoinPSDEId() != null) {
                if (pSDEDQJoin.getJoinPSDEId() == null || pSDEDQJoin.getJoinPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEDQJoin.getJoinPSDE();
                    pSDEDQJoin.setJoinPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEDQJoin.setJoinPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEDQ(PSDEDQJoin pSDEDQJoin, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PPSDEDQJoin(PSDEDQJoin pSDEDQJoin, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEJoinType(PSDEDQJoin pSDEDQJoin, boolean bl) throws Exception {
        if (pSDEDQJoin.isPSDEJoinTypeIdDirty()) {
            if (pSDEDQJoin.getPSDEJoinTypeId() != null) {
                if (pSDEDQJoin.getPSDEJoinTypeId() == null || pSDEDQJoin.getPSDEJoinTypeName() == null) {
                    PSDEJoinType pSDEJoinType = pSDEDQJoin.getPSDEJoinType();
                    pSDEDQJoin.setPSDEJoinTypeName(pSDEJoinType.getPSDEJoinTypeName());
                }
            } else {
                pSDEDQJoin.setPSDEJoinTypeName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDER(PSDEDQJoin pSDEDQJoin, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEDQJoin pSDEDQJoin, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEDQJoin, bl);
    }

    public ArrayList<PSDEDQJoin> selectByJoinPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByJoinPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEDQJoin> selectByJoinPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByJoinPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEDQJoin> selectByJoinPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDQJoin> selectByPSDEDQ(PSDEDataQueryBase pSDEDataQueryBase) throws Exception {
        return this.selectByPSDEDQ(pSDEDataQueryBase, "", -1);
    }

    public ArrayList<PSDEDQJoin> selectByPSDEDQ(PSDEDataQueryBase pSDEDataQueryBase, String string) throws Exception {
        return this.selectByPSDEDQ(pSDEDataQueryBase, string, -1);
    }

    public ArrayList<PSDEDQJoin> selectByPSDEDQ(PSDEDataQueryBase pSDEDataQueryBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDQID", (Object)pSDEDataQueryBase.getPSDEDataQueryId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEDQCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEDQCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDQJoin> selectTempByPSDEDQ(PSDEDataQueryBase pSDEDataQueryBase) throws Exception {
        return this.selectTempByPSDEDQ(pSDEDataQueryBase, "");
    }

    public ArrayList<PSDEDQJoin> selectTempByPSDEDQ(PSDEDataQueryBase pSDEDataQueryBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDQID", (Object)pSDEDataQueryBase.getPSDEDataQueryId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEDQCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEDQCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDQJoin> selectByPPSDEDQJoin(PSDEDQJoinBase pSDEDQJoinBase) throws Exception {
        return this.selectByPPSDEDQJoin(pSDEDQJoinBase, "", -1);
    }

    public ArrayList<PSDEDQJoin> selectByPPSDEDQJoin(PSDEDQJoinBase pSDEDQJoinBase, String string) throws Exception {
        return this.selectByPPSDEDQJoin(pSDEDQJoinBase, string, -1);
    }

    public ArrayList<PSDEDQJoin> selectByPPSDEDQJoin(PSDEDQJoinBase pSDEDQJoinBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSDEDQJOINID", (Object)pSDEDQJoinBase.getPSDEDQJoinId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSDEDQJoinCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSDEDQJoinCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDQJoin> selectTempByPPSDEDQJoin(PSDEDQJoinBase pSDEDQJoinBase) throws Exception {
        return this.selectTempByPPSDEDQJoin(pSDEDQJoinBase, "");
    }

    public ArrayList<PSDEDQJoin> selectTempByPPSDEDQJoin(PSDEDQJoinBase pSDEDQJoinBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSDEDQJOINID", (Object)pSDEDQJoinBase.getPSDEDQJoinId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPPSDEDQJoinCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPPSDEDQJoinCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDQJoin> selectByPSDEJoinType(PSDEJoinTypeBase pSDEJoinTypeBase) throws Exception {
        return this.selectByPSDEJoinType(pSDEJoinTypeBase, "", -1);
    }

    public ArrayList<PSDEDQJoin> selectByPSDEJoinType(PSDEJoinTypeBase pSDEJoinTypeBase, String string) throws Exception {
        return this.selectByPSDEJoinType(pSDEJoinTypeBase, string, -1);
    }

    public ArrayList<PSDEDQJoin> selectByPSDEJoinType(PSDEJoinTypeBase pSDEJoinTypeBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDQJoin> selectByPSDER(PSDERBase pSDERBase) throws Exception {
        return this.selectByPSDER(pSDERBase, "", -1);
    }

    public ArrayList<PSDEDQJoin> selectByPSDER(PSDERBase pSDERBase, String string) throws Exception {
        return this.selectByPSDER(pSDERBase, string, -1);
    }

    public ArrayList<PSDEDQJoin> selectByPSDER(PSDERBase pSDERBase, String string, int n) throws Exception {
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

    public void testRemoveByJoinPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEDQJoin> arrayList = this.selectByJoinPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDQJOIN_PSDATAENTITY_JOINPSDEID", "", iDataEntityModel.getName(), "PSDEDQJOIN", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetJoinPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEDQJoin> arrayList = this.selectByJoinPSDE(pSDataEntity);
        for (PSDEDQJoin pSDEDQJoin : arrayList) {
            PSDEDQJoin pSDEDQJoin2 = (PSDEDQJoin)this.getDEModel().createEntity();
            pSDEDQJoin2.setPSDEDQJoinId(pSDEDQJoin.getPSDEDQJoinId());
            pSDEDQJoin2.setJoinPSDEId(null);
            this.update(pSDEDQJoin2);
        }
    }

    public void removeByJoinPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDQJoinServiceBase.this.onBeforeRemoveByJoinPSDE(pSDataEntity2);
                PSDEDQJoinServiceBase.this.internalRemoveByJoinPSDE(pSDataEntity2);
                PSDEDQJoinServiceBase.this.onAfterRemoveByJoinPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByJoinPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByJoinPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEDQJoin> arrayList = this.selectByJoinPSDE(pSDataEntity);
        this.onBeforeRemoveByJoinPSDE(pSDataEntity, arrayList);
        for (PSDEDQJoin pSDEDQJoin : arrayList) {
            this.remove((IEntity)pSDEDQJoin);
        }
        this.onAfterRemoveByJoinPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByJoinPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByJoinPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEDQJoin> arrayList) throws Exception {
    }

    protected void onAfterRemoveByJoinPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEDQJoin> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
    }

    public void resetPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSDEDQJoin> arrayList = this.selectByPSDEDQ(pSDEDataQuery);
        for (PSDEDQJoin pSDEDQJoin : arrayList) {
            PSDEDQJoin pSDEDQJoin2 = (PSDEDQJoin)this.getDEModel().createEntity();
            pSDEDQJoin2.setPSDEDQJoinId(pSDEDQJoin.getPSDEDQJoinId());
            pSDEDQJoin2.setPSDEDQId(null);
            this.update(pSDEDQJoin2);
        }
    }

    public void resetTempPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSDEDQJoin> arrayList = this.selectTempByPSDEDQ(pSDEDataQuery);
        for (PSDEDQJoin pSDEDQJoin : arrayList) {
            PSDEDQJoin pSDEDQJoin2 = (PSDEDQJoin)this.getDEModel().createEntity();
            pSDEDQJoin2.setPSDEDQJoinId(pSDEDQJoin.getPSDEDQJoinId());
            pSDEDQJoin2.setPSDEDQId(null);
            this.updateTemp((IEntity)pSDEDQJoin2);
        }
    }

    public void removeByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
        final PSDEDataQuery pSDEDataQuery2 = pSDEDataQuery;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDQJoinServiceBase.this.onBeforeRemoveByPSDEDQ(pSDEDataQuery2);
                PSDEDQJoinServiceBase.this.internalRemoveByPSDEDQ(pSDEDataQuery2);
                PSDEDQJoinServiceBase.this.onAfterRemoveByPSDEDQ(pSDEDataQuery2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
    }

    protected void internalRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSDEDQJoin> arrayList = this.selectByPSDEDQ(pSDEDataQuery);
        this.onBeforeRemoveByPSDEDQ(pSDEDataQuery, arrayList);
        for (PSDEDQJoin pSDEDQJoin : arrayList) {
            this.remove((IEntity)pSDEDQJoin);
        }
        this.onAfterRemoveByPSDEDQ(pSDEDataQuery, arrayList);
    }

    protected void onAfterRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery, ArrayList<PSDEDQJoin> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery, ArrayList<PSDEDQJoin> arrayList) throws Exception {
    }

    public void testRemoveByPPSDEDQJoin(PSDEDQJoin pSDEDQJoin) throws Exception {
    }

    public void resetPPSDEDQJoin(PSDEDQJoin pSDEDQJoin) throws Exception {
        ArrayList<PSDEDQJoin> arrayList = this.selectByPPSDEDQJoin(pSDEDQJoin);
        for (PSDEDQJoin pSDEDQJoin2 : arrayList) {
            PSDEDQJoin pSDEDQJoin3 = (PSDEDQJoin)this.getDEModel().createEntity();
            pSDEDQJoin3.setPSDEDQJoinId(pSDEDQJoin2.getPSDEDQJoinId());
            pSDEDQJoin3.setPPSDEDQJoinId(null);
            this.update(pSDEDQJoin3);
        }
    }

    public void resetTempPPSDEDQJoin(PSDEDQJoin pSDEDQJoin) throws Exception {
        ArrayList<PSDEDQJoin> arrayList = this.selectTempByPPSDEDQJoin(pSDEDQJoin);
        for (PSDEDQJoin pSDEDQJoin2 : arrayList) {
            PSDEDQJoin pSDEDQJoin3 = (PSDEDQJoin)this.getDEModel().createEntity();
            pSDEDQJoin3.setPSDEDQJoinId(pSDEDQJoin2.getPSDEDQJoinId());
            pSDEDQJoin3.setPPSDEDQJoinId(null);
            this.updateTemp((IEntity)pSDEDQJoin3);
        }
    }

    public void removeByPPSDEDQJoin(PSDEDQJoin pSDEDQJoin) throws Exception {
        final PSDEDQJoin pSDEDQJoin2 = pSDEDQJoin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDQJoinServiceBase.this.onBeforeRemoveByPPSDEDQJoin(pSDEDQJoin2);
                PSDEDQJoinServiceBase.this.internalRemoveByPPSDEDQJoin(pSDEDQJoin2);
                PSDEDQJoinServiceBase.this.onAfterRemoveByPPSDEDQJoin(pSDEDQJoin2);
            }
        });
    }

    protected void onBeforeRemoveByPPSDEDQJoin(PSDEDQJoin pSDEDQJoin) throws Exception {
    }

    protected void internalRemoveByPPSDEDQJoin(PSDEDQJoin pSDEDQJoin) throws Exception {
        ArrayList<PSDEDQJoin> arrayList = this.selectByPPSDEDQJoin(pSDEDQJoin);
        this.onBeforeRemoveByPPSDEDQJoin(pSDEDQJoin, arrayList);
        for (PSDEDQJoin pSDEDQJoin2 : arrayList) {
            this.remove((IEntity)pSDEDQJoin2);
        }
        this.onAfterRemoveByPPSDEDQJoin(pSDEDQJoin, arrayList);
    }

    protected void onAfterRemoveByPPSDEDQJoin(PSDEDQJoin pSDEDQJoin) throws Exception {
    }

    protected void onBeforeRemoveByPPSDEDQJoin(PSDEDQJoin pSDEDQJoin, ArrayList<PSDEDQJoin> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSDEDQJoin(PSDEDQJoin pSDEDQJoin, ArrayList<PSDEDQJoin> arrayList) throws Exception {
    }

    public void testRemoveByPSDEJoinType(PSDEJoinType pSDEJoinType) throws Exception {
        ArrayList<PSDEDQJoin> arrayList = this.selectByPSDEJoinType(pSDEJoinType, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEJOINTYPE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEJoinType);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDQJOIN_PSDEJOINTYPE_PSDEJOINTYPEID", "", iDataEntityModel.getName(), "PSDEDQJOIN", iDataEntityModel.getDataInfo((IEntity)pSDEJoinType), arrayList.get(0)));
        }
    }

    public void resetPSDEJoinType(PSDEJoinType pSDEJoinType) throws Exception {
        ArrayList<PSDEDQJoin> arrayList = this.selectByPSDEJoinType(pSDEJoinType);
        for (PSDEDQJoin pSDEDQJoin : arrayList) {
            PSDEDQJoin pSDEDQJoin2 = (PSDEDQJoin)this.getDEModel().createEntity();
            pSDEDQJoin2.setPSDEDQJoinId(pSDEDQJoin.getPSDEDQJoinId());
            pSDEDQJoin2.setPSDEJoinTypeId(null);
            this.update(pSDEDQJoin2);
        }
    }

    public void removeByPSDEJoinType(PSDEJoinType pSDEJoinType) throws Exception {
        final PSDEJoinType pSDEJoinType2 = pSDEJoinType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDQJoinServiceBase.this.onBeforeRemoveByPSDEJoinType(pSDEJoinType2);
                PSDEDQJoinServiceBase.this.internalRemoveByPSDEJoinType(pSDEJoinType2);
                PSDEDQJoinServiceBase.this.onAfterRemoveByPSDEJoinType(pSDEJoinType2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEJoinType(PSDEJoinType pSDEJoinType) throws Exception {
    }

    protected void internalRemoveByPSDEJoinType(PSDEJoinType pSDEJoinType) throws Exception {
        ArrayList<PSDEDQJoin> arrayList = this.selectByPSDEJoinType(pSDEJoinType);
        this.onBeforeRemoveByPSDEJoinType(pSDEJoinType, arrayList);
        for (PSDEDQJoin pSDEDQJoin : arrayList) {
            this.remove((IEntity)pSDEDQJoin);
        }
        this.onAfterRemoveByPSDEJoinType(pSDEJoinType, arrayList);
    }

    protected void onAfterRemoveByPSDEJoinType(PSDEJoinType pSDEJoinType) throws Exception {
    }

    protected void onBeforeRemoveByPSDEJoinType(PSDEJoinType pSDEJoinType, ArrayList<PSDEDQJoin> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEJoinType(PSDEJoinType pSDEJoinType, ArrayList<PSDEDQJoin> arrayList) throws Exception {
    }

    public void testRemoveByPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEDQJoin> arrayList = this.selectByPSDER(pSDER, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDER);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDQJOIN_PSDER_PSDERID", "", iDataEntityModel.getName(), "PSDEDQJOIN", iDataEntityModel.getDataInfo((IEntity)pSDER), arrayList.get(0)));
        }
    }

    public void resetPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEDQJoin> arrayList = this.selectByPSDER(pSDER);
        for (PSDEDQJoin pSDEDQJoin : arrayList) {
            PSDEDQJoin pSDEDQJoin2 = (PSDEDQJoin)this.getDEModel().createEntity();
            pSDEDQJoin2.setPSDEDQJoinId(pSDEDQJoin.getPSDEDQJoinId());
            pSDEDQJoin2.setPSDERId(null);
            this.update(pSDEDQJoin2);
        }
    }

    public void removeByPSDER(PSDER pSDER) throws Exception {
        final PSDER pSDER2 = pSDER;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDQJoinServiceBase.this.onBeforeRemoveByPSDER(pSDER2);
                PSDEDQJoinServiceBase.this.internalRemoveByPSDER(pSDER2);
                PSDEDQJoinServiceBase.this.onAfterRemoveByPSDER(pSDER2);
            }
        });
    }

    protected void onBeforeRemoveByPSDER(PSDER pSDER) throws Exception {
    }

    protected void internalRemoveByPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEDQJoin> arrayList = this.selectByPSDER(pSDER);
        this.onBeforeRemoveByPSDER(pSDER, arrayList);
        for (PSDEDQJoin pSDEDQJoin : arrayList) {
            this.remove((IEntity)pSDEDQJoin);
        }
        this.onAfterRemoveByPSDER(pSDER, arrayList);
    }

    protected void onAfterRemoveByPSDER(PSDER pSDER) throws Exception {
    }

    protected void onBeforeRemoveByPSDER(PSDER pSDER, ArrayList<PSDEDQJoin> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDER(PSDER pSDER, ArrayList<PSDEDQJoin> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEDQJoin pSDEDQJoin) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEDQCondService)ServiceGlobal.getService(PSDEDQCondService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDQCondServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDQJoin(pSDEDQJoin);
        ((PSDEDQCondServiceBase)pSCoreSysServiceBase).removeByPSDEDQJoin(pSDEDQJoin);
        pSCoreSysServiceBase = (PSDEDQJoinService)ServiceGlobal.getService(PSDEDQJoinService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDQJoinServiceBase)pSCoreSysServiceBase).testRemoveByPPSDEDQJoin(pSDEDQJoin);
        ((PSDEDQJoinServiceBase)pSCoreSysServiceBase).removeByPPSDEDQJoin(pSDEDQJoin);
        super.onBeforeRemove(pSDEDQJoin);
    }

    protected void onBeforeRemoveTemp(PSDEDQJoin pSDEDQJoin) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEDQCondService)ServiceGlobal.getService(PSDEDQCondService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDQCondServiceBase)pSCoreSysServiceBase).removeTempByPSDEDQJoin(pSDEDQJoin);
        pSCoreSysServiceBase = (PSDEDQJoinService)ServiceGlobal.getService(PSDEDQJoinService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDQJoinServiceBase)pSCoreSysServiceBase).resetTempPPSDEDQJoin(pSDEDQJoin);
        super.onBeforeRemoveTemp((IEntity)pSDEDQJoin);
    }

    public void removeTempByPPSDEDQJoin(PSDEDQJoin pSDEDQJoin) throws Exception {
        final PSDEDQJoin pSDEDQJoin2 = pSDEDQJoin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDQJoinServiceBase.this.onBeforeRemoveTempByPPSDEDQJoin(pSDEDQJoin2);
                PSDEDQJoinServiceBase.this.internalRemoveTempByPPSDEDQJoin(pSDEDQJoin2);
                PSDEDQJoinServiceBase.this.onAfterRemoveTempByPPSDEDQJoin(pSDEDQJoin2);
            }
        });
    }

    protected void onBeforeRemoveTempByPPSDEDQJoin(PSDEDQJoin pSDEDQJoin) throws Exception {
    }

    protected void internalRemoveTempByPPSDEDQJoin(PSDEDQJoin pSDEDQJoin) throws Exception {
        ArrayList<PSDEDQJoin> arrayList = this.selectTempByPPSDEDQJoin(pSDEDQJoin);
        this.onBeforeRemoveTempByPPSDEDQJoin(pSDEDQJoin, arrayList);
        for (PSDEDQJoin pSDEDQJoin2 : arrayList) {
            this.removeTemp((IEntity)pSDEDQJoin2);
        }
        this.onAfterRemoveTempByPPSDEDQJoin(pSDEDQJoin, arrayList);
    }

    protected void onAfterRemoveTempByPPSDEDQJoin(PSDEDQJoin pSDEDQJoin) throws Exception {
    }

    protected void onBeforeRemoveTempByPPSDEDQJoin(PSDEDQJoin pSDEDQJoin, ArrayList<PSDEDQJoin> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPPSDEDQJoin(PSDEDQJoin pSDEDQJoin, ArrayList<PSDEDQJoin> arrayList) throws Exception {
    }

    public void removeTempByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
        final PSDEDataQuery pSDEDataQuery2 = pSDEDataQuery;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDQJoinServiceBase.this.onBeforeRemoveTempByPSDEDQ(pSDEDataQuery2);
                PSDEDQJoinServiceBase.this.internalRemoveTempByPSDEDQ(pSDEDataQuery2);
                PSDEDQJoinServiceBase.this.onAfterRemoveTempByPSDEDQ(pSDEDataQuery2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
    }

    protected void internalRemoveTempByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSDEDQJoin> arrayList = this.selectTempByPSDEDQ(pSDEDataQuery);
        this.onBeforeRemoveTempByPSDEDQ(pSDEDataQuery, arrayList);
        for (PSDEDQJoin pSDEDQJoin : arrayList) {
            this.removeTemp((IEntity)pSDEDQJoin);
        }
        this.onAfterRemoveTempByPSDEDQ(pSDEDataQuery, arrayList);
    }

    protected void onAfterRemoveTempByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEDQ(PSDEDataQuery pSDEDataQuery, ArrayList<PSDEDQJoin> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEDQ(PSDEDataQuery pSDEDataQuery, ArrayList<PSDEDQJoin> arrayList) throws Exception {
    }

    protected void getRelatedDataTempMajor(PSDEDQJoin pSDEDQJoin) throws Exception {
        this.getRelatedDataTempMajor_PSDEDQCond(pSDEDQJoin);
        super.getRelatedDataTempMajor((IEntity)pSDEDQJoin);
    }

    protected void getRelatedDataTempMajor_PSDEDQCond(PSDEDQJoin pSDEDQJoin) throws Exception {
        PSDEDQCondService pSDEDQCondService = (PSDEDQCondService)ServiceGlobal.getService(PSDEDQCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDQCond> arrayList = null;
        String string = pSDEDQJoin.getPSDEDQJoinId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEDQCondService.selectByPSDEDQJoin(pSDEDQJoin) : pSDEDQCondService.selectTempByPSDEDQJoin(pSDEDQJoin);
        PSDEDQJoinServiceBase.sortHierarchyEntities(arrayList, (String)"PSDEDQCONDID", (String)"PPSDEDQCONDID");
        for (PSDEDQCond pSDEDQCond : arrayList) {
            pSDEDQCondService.getTempMajor(pSDEDQCond);
        }
    }

    protected void updateRelatedDataTempMajor(PSDEDQJoin pSDEDQJoin, PSDEDQJoin pSDEDQJoin2) throws Exception {
        ArrayList<PSDEDQCond> arrayList = this.updateRelatedDataTempMajor_removePSDEDQCond(pSDEDQJoin, pSDEDQJoin2);
        this.updateRelatedDataTempMajor_updatePSDEDQCond(pSDEDQJoin, pSDEDQJoin2, arrayList);
        super.updateRelatedDataTempMajor((IEntity)pSDEDQJoin, (IEntity)pSDEDQJoin2);
    }

    protected ArrayList<PSDEDQCond> updateRelatedDataTempMajor_removePSDEDQCond(PSDEDQJoin pSDEDQJoin, PSDEDQJoin pSDEDQJoin2) throws Exception {
        PSDEDQCondService pSDEDQCondService = (PSDEDQCondService)ServiceGlobal.getService(PSDEDQCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDQCond> arrayList = pSDEDQCondService.selectTempByPSDEDQJoin(pSDEDQJoin);
        ArrayList<PSDEDQCond> arrayList2 = pSDEDQCondService.selectByPSDEDQJoin(pSDEDQJoin2);
        HashMap<String, PSDEDQCond> hashMap = new HashMap<String, PSDEDQCond>();
        for (PSDEDQCond pSDEDQCond : arrayList2) {
            hashMap.put(pSDEDQCond.getPSDEDQCondId(), pSDEDQCond);
        }
        PSDEDQJoinServiceBase.sortHierarchyEntities(arrayList, (String)"PSDEDQCONDID", (String)"PPSDEDQCONDID");
        for (PSDEDQCond pSDEDQCond : arrayList) {
            Object object = pSDEDQCond.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEDQCond pSDEDQCond : hashMap.values()) {
            pSDEDQCondService.remove((IEntity)pSDEDQCond);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEDQCond(PSDEDQJoin pSDEDQJoin, PSDEDQJoin pSDEDQJoin2, ArrayList<PSDEDQCond> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEDQCondService pSDEDQCondService = (PSDEDQCondService)ServiceGlobal.getService(PSDEDQCondService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEDQCond pSDEDQCond : arrayList) {
            pSDEDQCondService.updateTempMajor(pSDEDQCond);
        }
    }

    protected void replaceParentInfo(PSDEDQJoin pSDEDQJoin, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDEDQJoin, cloneSession);
        if (pSDEDQJoin.getJoinPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEDQJoin.getJoinPSDEId())) != null) {
            this.onFillParentInfo_JoinPSDE(pSDEDQJoin, (PSDataEntity)iEntity);
        }
        if (pSDEDQJoin.getPSDEDQId() != null && (iEntity = cloneSession.getEntity("PSDEDATAQUERY", (Object)pSDEDQJoin.getPSDEDQId())) != null) {
            this.onFillParentInfo_PSDEDQ(pSDEDQJoin, (PSDEDataQuery)iEntity);
        }
        if (pSDEDQJoin.getPPSDEDQJoinId() != null && (iEntity = cloneSession.getEntity("PSDEDQJOIN", (Object)pSDEDQJoin.getPPSDEDQJoinId())) != null) {
            this.onFillParentInfo_PPSDEDQJoin(pSDEDQJoin, (PSDEDQJoin)iEntity);
        }
        if (pSDEDQJoin.getPSDEJoinTypeId() != null && (iEntity = cloneSession.getEntity("PSDEJOINTYPE", (Object)pSDEDQJoin.getPSDEJoinTypeId())) != null) {
            this.onFillParentInfo_PSDEJoinType(pSDEDQJoin, (PSDEJoinType)iEntity);
        }
        if (pSDEDQJoin.getPSDERId() != null && (iEntity = cloneSession.getEntity("PSDER", (Object)pSDEDQJoin.getPSDERId())) != null) {
            this.onFillParentInfo_PSDER(pSDEDQJoin, (PSDER)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEDQJoin pSDEDQJoin, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEDQJoin, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEDQJoin pSDEDQJoin, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AliasName(bl, pSDEDQJoin, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CondFlag(bl, pSDEDQJoin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CondModel(bl, pSDEDQJoin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExtColumns(bl, pSDEDQJoin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_JoinPSDEId(bl, pSDEDQJoin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_JoinPSDEName(bl, pSDEDQJoin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_JoinTag(bl, pSDEDQJoin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_JoinTag2(bl, pSDEDQJoin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LevelTag(bl, pSDEDQJoin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LevelValue(bl, pSDEDQJoin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MainFlag(bl, pSDEDQJoin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEDQJoin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelState(bl, pSDEDQJoin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDEDQJoin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSDEDQJoinId(bl, pSDEDQJoin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDQId(bl, pSDEDQJoin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDQJoinId(bl, pSDEDQJoin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDQJoinName(bl, pSDEDQJoin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEJoinTypeId(bl, pSDEDQJoin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEJoinTypeName(bl, pSDEDQJoin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDERId(bl, pSDEDQJoin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_QueryViewFlag(bl, pSDEDQJoin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEDQJoin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEDQJoin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEDQJoin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEDQJoin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEDQJoin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEDQJoin, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AliasName(boolean bl, PSDEDQJoin pSDEDQJoin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQJoin.isAliasNameDirty() : !pSDEDQJoin.isAliasNameDirty()) {
            return null;
        }
        String string = pSDEDQJoin.getAliasName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AliasName_Default((IEntity)pSDEDQJoin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ALIASNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CondFlag(boolean bl, PSDEDQJoin pSDEDQJoin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQJoin.isCondFlagDirty() : !pSDEDQJoin.isCondFlagDirty()) {
            return null;
        }
        Integer n = pSDEDQJoin.getCondFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CondFlag_Default((IEntity)pSDEDQJoin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONDFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CondModel(boolean bl, PSDEDQJoin pSDEDQJoin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQJoin.isCondModelDirty() : !pSDEDQJoin.isCondModelDirty()) {
            return null;
        }
        String string = pSDEDQJoin.getCondModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CondModel_Default((IEntity)pSDEDQJoin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONDMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExtColumns(boolean bl, PSDEDQJoin pSDEDQJoin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQJoin.isExtColumnsDirty() : !pSDEDQJoin.isExtColumnsDirty()) {
            return null;
        }
        String string = pSDEDQJoin.getExtColumns();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ExtColumns_Default((IEntity)pSDEDQJoin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXTCOLUMNS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_JoinPSDEId(boolean bl, PSDEDQJoin pSDEDQJoin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQJoin.isJoinPSDEIdDirty() && !bl2 : !pSDEDQJoin.isJoinPSDEIdDirty()) {
            return null;
        }
        String string = pSDEDQJoin.getJoinPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("JOINPSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_JoinPSDEId_Default((IEntity)pSDEDQJoin, bl2, bl3);
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

    protected EntityFieldError onCheckField_JoinPSDEName(boolean bl, PSDEDQJoin pSDEDQJoin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQJoin.isJoinPSDENameDirty() && !bl2 : !pSDEDQJoin.isJoinPSDENameDirty()) {
            return null;
        }
        String string = pSDEDQJoin.getJoinPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("JOINPSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_JoinPSDEName_Default((IEntity)pSDEDQJoin, bl2, bl3);
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

    protected EntityFieldError onCheckField_JoinTag(boolean bl, PSDEDQJoin pSDEDQJoin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQJoin.isJoinTagDirty() : !pSDEDQJoin.isJoinTagDirty()) {
            return null;
        }
        String string = pSDEDQJoin.getJoinTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_JoinTag_Default((IEntity)pSDEDQJoin, bl2, bl3);
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

    protected EntityFieldError onCheckField_JoinTag2(boolean bl, PSDEDQJoin pSDEDQJoin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQJoin.isJoinTag2Dirty() : !pSDEDQJoin.isJoinTag2Dirty()) {
            return null;
        }
        String string = pSDEDQJoin.getJoinTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_JoinTag2_Default((IEntity)pSDEDQJoin, bl2, bl3);
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

    protected EntityFieldError onCheckField_LevelTag(boolean bl, PSDEDQJoin pSDEDQJoin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQJoin.isLevelTagDirty() : !pSDEDQJoin.isLevelTagDirty()) {
            return null;
        }
        String string = pSDEDQJoin.getLevelTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LevelTag_Default((IEntity)pSDEDQJoin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LEVELTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LevelValue(boolean bl, PSDEDQJoin pSDEDQJoin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQJoin.isLevelValueDirty() : !pSDEDQJoin.isLevelValueDirty()) {
            return null;
        }
        Integer n = pSDEDQJoin.getLevelValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LevelValue_Default((IEntity)pSDEDQJoin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LEVELVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MainFlag(boolean bl, PSDEDQJoin pSDEDQJoin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQJoin.isMainFlagDirty() : !pSDEDQJoin.isMainFlagDirty()) {
            return null;
        }
        Integer n = pSDEDQJoin.getMainFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MainFlag_Default((IEntity)pSDEDQJoin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAINFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEDQJoin pSDEDQJoin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQJoin.isMemoDirty() : !pSDEDQJoin.isMemoDirty()) {
            return null;
        }
        String string = pSDEDQJoin.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDEDQJoin, bl2, bl3);
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

    protected EntityFieldError onCheckField_ModelState(boolean bl, PSDEDQJoin pSDEDQJoin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQJoin.isModelStateDirty() : !pSDEDQJoin.isModelStateDirty()) {
            return null;
        }
        Integer n = pSDEDQJoin.getModelState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ModelState_Default((IEntity)pSDEDQJoin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODELSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDEDQJoin pSDEDQJoin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQJoin.isOrderValueDirty() : !pSDEDQJoin.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDEDQJoin.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSDEDQJoin, bl2, bl3);
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

    protected EntityFieldError onCheckField_PPSDEDQJoinId(boolean bl, PSDEDQJoin pSDEDQJoin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQJoin.isPPSDEDQJoinIdDirty() : !pSDEDQJoin.isPPSDEDQJoinIdDirty()) {
            return null;
        }
        String string = pSDEDQJoin.getPPSDEDQJoinId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSDEDQJoinId_Default((IEntity)pSDEDQJoin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSDEDQJOINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDQId(boolean bl, PSDEDQJoin pSDEDQJoin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQJoin.isPSDEDQIdDirty() && !bl2 : !pSDEDQJoin.isPSDEDQIdDirty()) {
            return null;
        }
        String string = pSDEDQJoin.getPSDEDQId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDQID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDQId_Default((IEntity)pSDEDQJoin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDQID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDQJoinId(boolean bl, PSDEDQJoin pSDEDQJoin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQJoin.isPSDEDQJoinIdDirty() && !bl2 : !pSDEDQJoin.isPSDEDQJoinIdDirty()) {
            return null;
        }
        String string = pSDEDQJoin.getPSDEDQJoinId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDQJOINID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDQJoinId_Default((IEntity)pSDEDQJoin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDQJOINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDQJoinName(boolean bl, PSDEDQJoin pSDEDQJoin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQJoin.isPSDEDQJoinNameDirty() && !bl2 : !pSDEDQJoin.isPSDEDQJoinNameDirty()) {
            return null;
        }
        String string = pSDEDQJoin.getPSDEDQJoinName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDQJOINNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDQJoinName_Default((IEntity)pSDEDQJoin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDQJOINNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEJoinTypeId(boolean bl, PSDEDQJoin pSDEDQJoin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQJoin.isPSDEJoinTypeIdDirty() && !bl2 : !pSDEDQJoin.isPSDEJoinTypeIdDirty()) {
            return null;
        }
        String string = pSDEDQJoin.getPSDEJoinTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEJOINTYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEJoinTypeId_Default((IEntity)pSDEDQJoin, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEJoinTypeName(boolean bl, PSDEDQJoin pSDEDQJoin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQJoin.isPSDEJoinTypeNameDirty() && !bl2 : !pSDEDQJoin.isPSDEJoinTypeNameDirty()) {
            return null;
        }
        String string = pSDEDQJoin.getPSDEJoinTypeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEJOINTYPENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEJoinTypeName_Default((IEntity)pSDEDQJoin, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDERId(boolean bl, PSDEDQJoin pSDEDQJoin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQJoin.isPSDERIdDirty() : !pSDEDQJoin.isPSDERIdDirty()) {
            return null;
        }
        String string = pSDEDQJoin.getPSDERId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDERId_Default((IEntity)pSDEDQJoin, bl2, bl3);
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

    protected EntityFieldError onCheckField_QueryViewFlag(boolean bl, PSDEDQJoin pSDEDQJoin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQJoin.isQueryViewFlagDirty() : !pSDEDQJoin.isQueryViewFlagDirty()) {
            return null;
        }
        Integer n = pSDEDQJoin.getQueryViewFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_QueryViewFlag_Default((IEntity)pSDEDQJoin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("QUERYVIEWFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEDQJoin pSDEDQJoin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQJoin.isUserCatDirty() : !pSDEDQJoin.isUserCatDirty()) {
            return null;
        }
        String string = pSDEDQJoin.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSDEDQJoin, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEDQJoin pSDEDQJoin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQJoin.isUserTagDirty() : !pSDEDQJoin.isUserTagDirty()) {
            return null;
        }
        String string = pSDEDQJoin.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDEDQJoin, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEDQJoin pSDEDQJoin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQJoin.isUserTag2Dirty() : !pSDEDQJoin.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEDQJoin.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDEDQJoin, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEDQJoin pSDEDQJoin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQJoin.isUserTag3Dirty() : !pSDEDQJoin.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEDQJoin.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSDEDQJoin, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEDQJoin pSDEDQJoin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQJoin.isUserTag4Dirty() : !pSDEDQJoin.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEDQJoin.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSDEDQJoin, bl2, bl3);
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

    protected void onSyncEntity(PSDEDQJoin pSDEDQJoin, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEDQJoin, bl);
    }

    protected void onSyncIndexEntities(PSDEDQJoin pSDEDQJoin, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEDQJoin, bl);
    }

    public Object getDataContextValue(PSDEDQJoin pSDEDQJoin, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDEDQJoin, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDEDQJoin pSDEDQJoin, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDEDQJoin, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ALIASNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AliasName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CondFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONDMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CondModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXTCOLUMNS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExtColumns_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"LEVELTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LevelTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LEVELVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LevelValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAINFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MainFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PJOINPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PJoinPSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSDEDQJOINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSDEDQJoinId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSDEDQJOINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSDEDQJoinName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDQID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDQId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDQJOINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDQJoinId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDQJOINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDQJoinName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDQNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDQName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"QUERYVIEWFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_QueryViewFlag_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_AliasName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ALIASNAME", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false) && this.checkFieldRegExRule("ALIASNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CondFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CondModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONDMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected String onTestValueRule_ExtColumns_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EXTCOLUMNS", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
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

    protected String onTestValueRule_LevelTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LEVELTAG", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LevelValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MainFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_ModelState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PPSDEDQJoinId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSDEDQJOINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSDEDQJoinName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSDEDQJOINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDQId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDQID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDQJoinId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDQJOINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDQJoinName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDQJOINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDQName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDQNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_QueryViewFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected boolean onMergeChild(String string, String string2, PSDEDQJoin pSDEDQJoin) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEDQJoin)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEDQJoin pSDEDQJoin) throws Exception {
        super.onUpdateParent((IEntity)pSDEDQJoin);
    }

    @Override
    protected void exportCurXmlModel(PSDEDQJoin pSDEDQJoin, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEDQJOIN");
        if (!bl) {
            pSDEDQJoin.setCondFlag(null);
            pSDEDQJoin.setCreateDate(null);
            pSDEDQJoin.setCreateMan(null);
            pSDEDQJoin.setLevelTag(null);
            pSDEDQJoin.setLevelValue(null);
            pSDEDQJoin.setModelState(null);
            pSDEDQJoin.setPSDEDQJoinId(null);
            pSDEDQJoin.setPSDEDQJoinName(null);
            pSDEDQJoin.setUpdateDate(null);
            pSDEDQJoin.setUpdateMan(null);
            pSDEDQJoin.setPJoinPSDEId(null);
            pSDEDQJoin.setPPSDEDQJoinId(null);
            pSDEDQJoin.setPSDEDQId(null);
            pSDEDQJoin.setPSDEDQName(null);
            super.exportCurXmlModel(pSDEDQJoin, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDEDQJoin pSDEDQJoin, XmlNode xmlNode) throws Exception {
        super.onExportRelatedXmlModel(pSDEDQJoin, xmlNode);
    }

    @Override
    protected void onImportRelatedXmlModel(PSDEDQJoin pSDEDQJoin, XmlNode xmlNode) throws Exception {
        super.onImportRelatedXmlModel(pSDEDQJoin, xmlNode);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEDQJoin pSDEDQJoin, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEDQJoin, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSDEDQJOINID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEDQJOIN#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEDQID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEDATAQUERY#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSDEDQJOINID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEDQJOIN_PSDEDQJOIN_PPSDEDQJOINID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEDQID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEDQJOIN_PSDEDATAQUERY_PSDEDQID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSDEDQJOINID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PPSDEDQJOINNAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEDQID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEDQNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDEDQJOIN", (boolean)true) == 0) {
            iEntity.set("PPSDEDQJOINID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATAQUERY", (boolean)true) == 0) {
            iEntity.set("PSDEDQID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PPSDEDQJOINID", "PSDEDQID"};
    }

    @Override
    public String getModelV2Tag(PSDEDQJoin pSDEDQJoin) {
        return super.getModelV2Tag(pSDEDQJoin);
    }

    @Override
    public boolean setModelV2Tag(PSDEDQJoin pSDEDQJoin, String string) {
        return super.setModelV2Tag(pSDEDQJoin, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PPSDEDQJOINID", "");
        map.put("PSDEDQID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEDQJoin pSDEDQJoin, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEDQJoin.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEDQJoin, true);
        return super.getModelV2Entity(pSDEDQJoin, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEDQJoin pSDEDQJoin, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        boolean bl = false;
        if (!StringHelper.isNullOrEmpty((String)pSDEDQJoin.getPPSDEDQJoinId())) {
            bl = true;
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEDQJoin.getPSDEDQId())) {
            bl = true;
        } else if (bl && !objectNode.has("psdedqid")) {
            objectNode.put("psdedqid", "<PSDEDATAQUERY>");
        }
        return super.testCompileCurModelV2(pSDEDQJoin, objectNode, string, string2, n);
    }

    @Override
    protected ObjectNode onFillModelV2(ObjectNode objectNode, PSDEDQJoin pSDEDQJoin, String string, Map<String, String> map) throws Exception {
        if (PSDEDQJoinServiceBase.isSimpleImportExportMode()) {
            map.put("PPSDEDQJOINID", "");
            map.put("PSDEDQID", "");
        }
        return super.onFillModelV2(objectNode, pSDEDQJoin, string, map);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSDEDQJOIN_PSDEDQJOIN_PPSDEDQJOINID", (String)string, (boolean)true) == 0) {
            return false;
        }
        return StringHelper.compare((String)"DER1N_PSDEDQCOND_PSDEDQJOIN_PSDEDQJOINID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSDEDQJoin pSDEDQJoin, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSDEDQJoin, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDEDQJoin pSDEDQJoin, ObjectNode objectNode, String string, boolean bl) throws Exception {
        Object object;
        EntityBase entityBase2;
        Object object2;
        ArrayNode arrayNode;
        Object object3;
        ArrayList<PSDEDQJoin> arrayList;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEDQJOIN_PSDEDQJOIN_PPSDEDQJOINID")) {
            pSCoreSysServiceBase = (PSDEDQJoinService)ServiceGlobal.getService(PSDEDQJoinService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEDQJOIN#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEDQJOIN", (Object)pSDEDQJoin.getPSDEDQJoinId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object3 = PSModelV2Helper.readFile2(file);
                    arrayNode = ((ArrayList)object3).iterator();
                    while (arrayNode.hasNext()) {
                        object2 = (String)arrayNode.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add((PSDEDQJoin)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSDEDQJoin>();
                object3 = ((PSDEDQJoinServiceBase)pSCoreSysServiceBase).selectByPPSDEDQJoin(pSDEDQJoin);
                arrayNode = StringHelper.format((String)"PSDEDQJOIN#%1$s", (Object)pSDEDQJoin.getPSDEDQJoinId());
                object2 = ((ArrayList)object3).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSDEDQJoin)object2.next();
                    object = ((PSDEDQJoinServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(arrayNode, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEDQJoin)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object3 = pSCoreSysServiceBase.getModelV2Name(false);
                arrayNode = objectNode.putArray(((String)object3).toLowerCase());
                Collections.sort(arrayList, new Comparator<ObjectNode>(){

                    @Override
                    public int compare(ObjectNode objectNode, ObjectNode objectNode2) {
                        int n;
                        int n2 = 1000;
                        int n3 = 1000;
                        if (objectNode.has("ordervalue")) {
                            n2 = objectNode.get("ordervalue").asInt();
                        }
                        if (objectNode2.has("ordervalue")) {
                            n3 = objectNode2.get("ordervalue").asInt();
                        }
                        if ((n = n2 - n3) != 0) {
                            return n;
                        }
                        String string = null;
                        String string2 = null;
                        if (objectNode.has("psdedqjoinname")) {
                            string = objectNode.get("psdedqjoinname").asText();
                        }
                        if (objectNode2.has("psdedqjoinname")) {
                            string2 = objectNode2.get("psdedqjoinname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSDEDQJoin();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    ((PSDEDQJoinBase)object).remove("ordervalue");
                    arrayNode.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEDQCOND_PSDEDQJOIN_PSDEDQJOINID")) {
            pSCoreSysServiceBase = (PSDEDQCondService)ServiceGlobal.getService(PSDEDQCondService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEDQJOIN#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEDQCOND", (Object)pSDEDQJoin.getPSDEDQJoinId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object3 = PSModelV2Helper.readFile2(file);
                    arrayNode = ((ArrayList)object3).iterator();
                    while (arrayNode.hasNext()) {
                        object2 = (String)arrayNode.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSDEDQJoin)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object3 = ((PSDEDQCondServiceBase)pSCoreSysServiceBase).selectByPSDEDQJoin(pSDEDQJoin);
                arrayNode = StringHelper.format((String)"PSDEDQJOIN#%1$s", (Object)pSDEDQJoin.getPSDEDQJoinId());
                object2 = ((ArrayList)object3).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSDEDQCond)object2.next();
                    object = ((PSDEDQCondServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)arrayNode, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEDQJoin)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object3 = pSCoreSysServiceBase.getModelV2Name(false);
                arrayNode = objectNode.putArray(((String)object3).toLowerCase());
                Collections.sort(arrayList, new Comparator<ObjectNode>(){

                    @Override
                    public int compare(ObjectNode objectNode, ObjectNode objectNode2) {
                        int n;
                        int n2 = 1000;
                        int n3 = 1000;
                        if (objectNode.has("ordervalue")) {
                            n2 = objectNode.get("ordervalue").asInt();
                        }
                        if (objectNode2.has("ordervalue")) {
                            n3 = objectNode2.get("ordervalue").asInt();
                        }
                        if ((n = n2 - n3) != 0) {
                            return n;
                        }
                        String string = null;
                        String string2 = null;
                        if (objectNode.has("psdedqcondname")) {
                            string = objectNode.get("psdedqcondname").asText();
                        }
                        if (objectNode2.has("psdedqcondname")) {
                            string2 = objectNode2.get("psdedqcondname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSDEDQCond();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    ((PSDEDQCondBase)object).remove("ordervalue");
                    arrayNode.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSDEDQJoin, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDEDQJoin pSDEDQJoin) throws Exception {
        String string;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEDQJoinService)ServiceGlobal.getService(PSDEDQJoinService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<EntityBase> arrayList = ((PSDEDQJoinServiceBase)pSCoreSysServiceBase).selectByPPSDEDQJoin(pSDEDQJoin);
        String string2 = StringHelper.format((String)"PSDEDQJOIN#%1$s", (Object)pSDEDQJoin.getPSDEDQJoinId());
        for (PSDEDQJoin entityBase : arrayList) {
            string = ((PSDEDQJoinServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(entityBase);
        }
        Object object = new SqlParamList();
        object.addString(pSDEDQJoin.getPSDEDQJoinId());
        ((PSDEDQJoinServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDEDQJoinServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEDQJOIN WHERE PPSDEDQJOINID = ?", (SqlParamList)object);
        pSCoreSysServiceBase = (PSDEDQCondService)ServiceGlobal.getService(PSDEDQCondService.class, (SessionFactory)this.getSessionFactory());
        arrayList = ((PSDEDQCondServiceBase)pSCoreSysServiceBase).selectByPSDEDQJoin(pSDEDQJoin);
        string2 = StringHelper.format((String)"PSDEDQJOIN#%1$s", (Object)pSDEDQJoin.getPSDEDQJoinId());
        for (PSDEDQCond pSDEDQCond : arrayList) {
            string = ((PSDEDQCondServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)pSDEDQCond);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSDEDQCond);
        }
        object = new SqlParamList();
        object.addString(pSDEDQJoin.getPSDEDQJoinId());
        ((PSDEDQCondServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDEDQCondServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEDQCOND WHERE PSDEDQJOINID = ?", (SqlParamList)object);
        super.onEmptyModelV2(pSDEDQJoin);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEDQJoinService)ServiceGlobal.getService(PSDEDQJoinService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDEDQCondService)ServiceGlobal.getService(PSDEDQCondService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDEDQJoin pSDEDQJoin, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSDEDQJoin();
        entityBase.set("PPSDEDQJOINID", pSDEDQJoin.getPSDEDQJoinId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEDQJoinService)ServiceGlobal.getService(PSDEDQJoinService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDEDQCond();
        entityBase.set("PSDEDQJOINID", pSDEDQJoin.getPSDEDQJoinId());
        pSCoreSysServiceBase = (PSDEDQCondService)ServiceGlobal.getService(PSDEDQCondService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDEDQJoin, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDEDQJoin pSDEDQJoin, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        EntityBase entityBase;
        Object object;
        Object object2;
        int n2;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEDQJoinService)ServiceGlobal.getService(PSDEDQJoinService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        int n3 = 0;
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                object2 = (ObjectNode)arrayNode.get(n2);
                object = new PSDEDQJoin();
                ((PSDEDQJoinBase)object).setPJoinPSDEId(pSDEDQJoin.getJoinPSDEId());
                ((PSDEDQJoinBase)object).setPPSDEDQJoinId(pSDEDQJoin.getPSDEDQJoinId());
                ((PSDEDQJoinBase)object).setPPSDEDQJoinName(pSDEDQJoin.getPSDEDQJoinName());
                ((PSDEDQJoinBase)object).setOrderValue(n3 += 10);
                pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            object2 = new File(string4);
            if (((File)object2).exists()) {
                object = ((File)object2).listFiles();
                for (Object object3 : object) {
                    if (!((File)object3).isDirectory()) continue;
                    entityBase = new PSDEDQJoin();
                    entityBase.setPJoinPSDEId(pSDEDQJoin.getJoinPSDEId());
                    entityBase.setPPSDEDQJoinId(pSDEDQJoin.getPSDEDQJoinId());
                    entityBase.setPPSDEDQJoinName(pSDEDQJoin.getPSDEDQJoinName());
                    pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSDEDQCondService)ServiceGlobal.getService(PSDEDQCondService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        n3 = 0;
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                object2 = (ObjectNode)arrayNode.get(n2);
                object = new PSDEDQCond();
                ((PSDEDQCondBase)object).setPSDEDQJoinId(pSDEDQJoin.getPSDEDQJoinId());
                ((PSDEDQCondBase)object).setPSDEDQJoinName(pSDEDQJoin.getPSDEDQJoinName());
                ((PSDEDQCondBase)object).setOrderValue(n3 += 10);
                pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
            }
        } else {
            String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            object2 = new File(string5);
            if (((File)object2).exists()) {
                for (Object object3 : object = ((File)object2).listFiles()) {
                    if (!((File)object3).isDirectory()) continue;
                    entityBase = new PSDEDQCond();
                    entityBase.setPSDEDQJoinId(pSDEDQJoin.getPSDEDQJoinId());
                    entityBase.setPSDEDQJoinName(pSDEDQJoin.getPSDEDQJoinName());
                    pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSDEDQJoin, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDEDQJoin pSDEDQJoin, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        Object var5_5 = null;
        return super.onPasteFile(pSDEDQJoin, pSMOSFile, string, iPSMOSFileAction);
    }

    @Override
    protected void onFillPasteHelps(PSDEDQJoin pSDEDQJoin, List<PSHelpSection> list) throws Exception {
        super.onFillPasteHelps(pSDEDQJoin, list);
    }
}

