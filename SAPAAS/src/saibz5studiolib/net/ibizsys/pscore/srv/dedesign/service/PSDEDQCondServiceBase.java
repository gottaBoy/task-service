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
import net.ibizsys.pscore.srv.config.entity.PSDBValueOP;
import net.ibizsys.pscore.srv.config.entity.PSDBValueOPBase;
import net.ibizsys.pscore.srv.config.entity.PSDEDQPDCond;
import net.ibizsys.pscore.srv.config.entity.PSDEDQPDCondBase;
import net.ibizsys.pscore.srv.config.entity.PSVarType;
import net.ibizsys.pscore.srv.config.entity.PSVarTypeBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEDQCondDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEDQCondDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCond;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCondBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQJoin;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQJoinBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQueryBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDQCondService;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBVF;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBVFBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDQCondServiceBase
extends PSCoreSysServiceBase<PSDEDQCond> {
    private static final Log log = LogFactory.getLog(PSDEDQCondServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_AJAXFILLCONDVALUE = "AjaxFillCondValue";
    private PSDEDQCondDEModel pSDEDQCondDEModel;
    private PSDEDQCondDAO pSDEDQCondDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEDQCondService";
    }

    public PSDEDQCondDEModel getPSDEDQCondDEModel() {
        if (this.pSDEDQCondDEModel == null) {
            try {
                this.pSDEDQCondDEModel = (PSDEDQCondDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEDQCondDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDQCondDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEDQCondDEModel();
    }

    public PSDEDQCondDAO getPSDEDQCondDAO() {
        if (this.pSDEDQCondDAO == null) {
            try {
                this.pSDEDQCondDAO = (PSDEDQCondDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEDQCondDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDQCondDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEDQCondDAO();
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
        if (StringHelper.compare((String)string, (String)ACTION_AJAXFILLCONDVALUE, (boolean)true) == 0) {
            this.ajaxFillCondValue((PSDEDQCond)iEntity);
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

    public void ajaxFillCondValue(PSDEDQCond pSDEDQCond) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_AJAXFILLCONDVALUE, 0, (IEntity)pSDEDQCond, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEDQCond, ACTION_AJAXFILLCONDVALUE);
        final PSDEDQCond pSDEDQCond2 = pSDEDQCond;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEDQCondServiceBase.this.getService(), PSDEDQCondServiceBase.ACTION_AJAXFILLCONDVALUE, 40, (IEntity)pSDEDQCond2, null).getResult() != 1) {
                    PSDEDQCondServiceBase.this.onAjaxFillCondValue(pSDEDQCond2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_AJAXFILLCONDVALUE, 99, (IEntity)pSDEDQCond, null);
        }
    }

    protected void onAjaxFillCondValue(PSDEDQCond pSDEDQCond) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[AjaxFillCondValue]");
    }

    protected void onFillParentInfo(PSDEDQCond pSDEDQCond, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDQCOND_PSDBVALUEOP_PSDBVALUEOPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDBValueOPService", (SessionFactory)this.getSessionFactory());
            PSDBValueOP pSDBValueOP = (PSDBValueOP)iService.getDEModel().createEntity();
            pSDBValueOP.set("PSDBVALUEOPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDBValueOP);
            } else {
                iService.get((IEntity)pSDBValueOP);
            }
            this.onFillParentInfo_PSDBValueOP(pSDEDQCond, pSDBValueOP);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDQCOND_PSDEDATAQUERY_PSDEDQID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService", (SessionFactory)this.getSessionFactory());
            PSDEDataQuery pSDEDataQuery = (PSDEDataQuery)iService.getDEModel().createEntity();
            pSDEDataQuery.set("PSDEDATAQUERYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataQuery);
            } else {
                iService.get((IEntity)pSDEDataQuery);
            }
            this.onFillParentInfo_PSDEDQ(pSDEDQCond, pSDEDataQuery);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDQCOND_PSDEDQCOND_PPSDEDQCONDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDQCondService", (SessionFactory)this.getSessionFactory());
            PSDEDQCond pSDEDQCond2 = (PSDEDQCond)iService.getDEModel().createEntity();
            pSDEDQCond2.set("PSDEDQCONDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDQCond2);
            } else {
                iService.get((IEntity)pSDEDQCond2);
            }
            this.onFillParentInfo_PPSDEDQCond(pSDEDQCond, pSDEDQCond2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDQCOND_PSDEDQJOIN_PSDEDQJOINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDQJoinService", (SessionFactory)this.getSessionFactory());
            PSDEDQJoin pSDEDQJoin = (PSDEDQJoin)iService.getDEModel().createEntity();
            pSDEDQJoin.set("PSDEDQJOINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDQJoin);
            } else {
                iService.get((IEntity)pSDEDQJoin);
            }
            this.onFillParentInfo_PSDEDQJoin(pSDEDQCond, pSDEDQJoin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDQCOND_PSDEDQPDCOND_PSDEDQPDCONDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDEDQPDCondService", (SessionFactory)this.getSessionFactory());
            PSDEDQPDCond pSDEDQPDCond = (PSDEDQPDCond)iService.getDEModel().createEntity();
            pSDEDQPDCond.set("PSDEDQPDCONDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDQPDCond);
            } else {
                iService.get((IEntity)pSDEDQPDCond);
            }
            this.onFillParentInfo_PSDEDQPDCond(pSDEDQCond, pSDEDQPDCond);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDQCOND_PSDEFIELD_PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_PSDEField(pSDEDQCond, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDQCOND_PSSYSDBVF_PSSYSDBVFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDBVFService", (SessionFactory)this.getSessionFactory());
            PSSysDBVF pSSysDBVF = (PSSysDBVF)iService.getDEModel().createEntity();
            pSSysDBVF.set("PSSYSDBVFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDBVF);
            } else {
                iService.get((IEntity)pSSysDBVF);
            }
            this.onFillParentInfo_PSSysDBVF(pSDEDQCond, pSSysDBVF);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDQCOND_PSVARTYPE_PSVARTYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSVarTypeService", (SessionFactory)this.getSessionFactory());
            PSVarType pSVarType = (PSVarType)iService.getDEModel().createEntity();
            pSVarType.set("PSVARTYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSVarType);
            } else {
                iService.get((IEntity)pSVarType);
            }
            this.onFillParentInfo_PSVarType(pSDEDQCond, pSVarType);
            return;
        }
        super.onFillParentInfo((IEntity)pSDEDQCond, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEDQCOND_PSDEDATAQUERY_PSDEDQID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService", (SessionFactory)this.getSessionFactory());
            PSDEDataQuery pSDEDataQuery = (PSDEDataQuery)iService.getDEModel().createEntity();
            pSDEDataQuery.set("PSDEDATAQUERYID", string2);
            return this.onSyncDER1NData_PSDEDQ(pSDEDataQuery, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDBValueOP(PSDEDQCond pSDEDQCond, PSDBValueOP pSDBValueOP) throws Exception {
        pSDEDQCond.setPSDBValueOPId(pSDBValueOP.getPSDBValueOPId());
        pSDEDQCond.setPSDBValueOPName(pSDBValueOP.getPSDBValueOPName());
    }

    protected void onFillParentInfo_PSDEDQ(PSDEDQCond pSDEDQCond, PSDEDataQuery pSDEDataQuery) throws Exception {
        pSDEDQCond.setPSDEDQId(pSDEDataQuery.getPSDEDataQueryId());
        pSDEDQCond.setPSDEDQName(pSDEDataQuery.getPSDEDataQueryName());
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
            ArrayList<PSDEDQCond> arrayList = this.selectByPSDEDQ(pSDEDataQuery);
            for (PSDEDQCond pSDEDQCond : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSDEDQCond, (String)"PSDEDQCONDID", (String)""))) continue;
                this.remove((IEntity)pSDEDQCond);
            }
        }
        return null;
    }

    protected void onFillParentInfo_PPSDEDQCond(PSDEDQCond pSDEDQCond, PSDEDQCond pSDEDQCond2) throws Exception {
        pSDEDQCond.setPPSDEDQCondId(pSDEDQCond2.getPSDEDQCondId());
        pSDEDQCond.setPPSDEDQCondName(pSDEDQCond2.getPSDEDQCondName());
    }

    protected void onFillParentInfo_PSDEDQJoin(PSDEDQCond pSDEDQCond, PSDEDQJoin pSDEDQJoin) throws Exception {
        pSDEDQCond.setPSDEDQJoinId(pSDEDQJoin.getPSDEDQJoinId());
        pSDEDQCond.setPSDEDQJoinName(pSDEDQJoin.getPSDEDQJoinName());
    }

    protected void onFillParentInfo_PSDEDQPDCond(PSDEDQCond pSDEDQCond, PSDEDQPDCond pSDEDQPDCond) throws Exception {
        pSDEDQCond.setPSDEDQPDCondId(pSDEDQPDCond.getPSDEDQPDCondId());
        pSDEDQCond.setPSDEDQPDCondName(pSDEDQPDCond.getPSDEDQPDCondName());
    }

    protected void onFillParentInfo_PSDEField(PSDEDQCond pSDEDQCond, PSDEField pSDEField) throws Exception {
        pSDEDQCond.setPSDEFId(pSDEField.getPSDEFieldId());
        pSDEDQCond.setPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PSSysDBVF(PSDEDQCond pSDEDQCond, PSSysDBVF pSSysDBVF) throws Exception {
        pSDEDQCond.setPSSysDBVFId(pSSysDBVF.getPSSysDBVFId());
        pSDEDQCond.setPSSysDBVFName(pSSysDBVF.getPSSysDBVFName());
    }

    protected void onFillParentInfo_PSVarType(PSDEDQCond pSDEDQCond, PSVarType pSVarType) throws Exception {
        pSDEDQCond.setPSVARTypeId(pSVarType.getPSVarTypeId());
        pSDEDQCond.setPSVARTypeName(pSVarType.getPSVarTypeName());
    }

    protected void onFillEntityFullInfo(PSDEDQCond pSDEDQCond, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDEDQCond, bl);
        this.onFillEntityFullInfo_PSDBValueOP(pSDEDQCond, bl);
        this.onFillEntityFullInfo_PSDEDQ(pSDEDQCond, bl);
        this.onFillEntityFullInfo_PPSDEDQCond(pSDEDQCond, bl);
        this.onFillEntityFullInfo_PSDEDQJoin(pSDEDQCond, bl);
        this.onFillEntityFullInfo_PSDEDQPDCond(pSDEDQCond, bl);
        this.onFillEntityFullInfo_PSDEField(pSDEDQCond, bl);
        this.onFillEntityFullInfo_PSSysDBVF(pSDEDQCond, bl);
        this.onFillEntityFullInfo_PSVarType(pSDEDQCond, bl);
    }

    protected void onFillEntityFullInfo_PSDBValueOP(PSDEDQCond pSDEDQCond, boolean bl) throws Exception {
        if (pSDEDQCond.isPSDBValueOPIdDirty()) {
            if (pSDEDQCond.getPSDBValueOPId() != null) {
                if (pSDEDQCond.getPSDBValueOPId() == null || pSDEDQCond.getPSDBValueOPName() == null) {
                    PSDBValueOP pSDBValueOP = pSDEDQCond.getPSDBValueOP();
                    pSDEDQCond.setPSDBValueOPName(pSDBValueOP.getPSDBValueOPName());
                }
            } else {
                pSDEDQCond.setPSDBValueOPName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEDQ(PSDEDQCond pSDEDQCond, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PPSDEDQCond(PSDEDQCond pSDEDQCond, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEDQJoin(PSDEDQCond pSDEDQCond, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEDQPDCond(PSDEDQCond pSDEDQCond, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEField(PSDEDQCond pSDEDQCond, boolean bl) throws Exception {
        if (pSDEDQCond.isPSDEFIdDirty()) {
            if (pSDEDQCond.getPSDEFId() != null) {
                if (pSDEDQCond.getPSDEFId() == null || pSDEDQCond.getPSDEFName() == null) {
                    PSDEField pSDEField = pSDEDQCond.getPSDEField();
                    pSDEDQCond.setPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEDQCond.setPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysDBVF(PSDEDQCond pSDEDQCond, boolean bl) throws Exception {
        if (pSDEDQCond.isPSSysDBVFIdDirty()) {
            if (pSDEDQCond.getPSSysDBVFId() != null) {
                if (pSDEDQCond.getPSSysDBVFId() == null || pSDEDQCond.getPSSysDBVFName() == null) {
                    PSSysDBVF pSSysDBVF = pSDEDQCond.getPSSysDBVF();
                    pSDEDQCond.setPSSysDBVFName(pSSysDBVF.getPSSysDBVFName());
                }
            } else {
                pSDEDQCond.setPSSysDBVFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSVarType(PSDEDQCond pSDEDQCond, boolean bl) throws Exception {
        if (pSDEDQCond.isPSVARTypeIdDirty()) {
            if (pSDEDQCond.getPSVARTypeId() != null) {
                if (pSDEDQCond.getPSVARTypeId() == null || pSDEDQCond.getPSVARTypeName() == null) {
                    PSVarType pSVarType = pSDEDQCond.getPSVarType();
                    pSDEDQCond.setPSVARTypeName(pSVarType.getPSVarTypeName());
                }
            } else {
                pSDEDQCond.setPSVARTypeName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDEDQCond pSDEDQCond, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEDQCond, bl);
    }

    public ArrayList<PSDEDQCond> selectByPSDBValueOP(PSDBValueOPBase pSDBValueOPBase) throws Exception {
        return this.selectByPSDBValueOP(pSDBValueOPBase, "", -1);
    }

    public ArrayList<PSDEDQCond> selectByPSDBValueOP(PSDBValueOPBase pSDBValueOPBase, String string) throws Exception {
        return this.selectByPSDBValueOP(pSDBValueOPBase, string, -1);
    }

    public ArrayList<PSDEDQCond> selectByPSDBValueOP(PSDBValueOPBase pSDBValueOPBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDBVALUEOPID", (Object)pSDBValueOPBase.getPSDBValueOPId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDBValueOPCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDBValueOPCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDQCond> selectByPSDEDQ(PSDEDataQueryBase pSDEDataQueryBase) throws Exception {
        return this.selectByPSDEDQ(pSDEDataQueryBase, "", -1);
    }

    public ArrayList<PSDEDQCond> selectByPSDEDQ(PSDEDataQueryBase pSDEDataQueryBase, String string) throws Exception {
        return this.selectByPSDEDQ(pSDEDataQueryBase, string, -1);
    }

    public ArrayList<PSDEDQCond> selectByPSDEDQ(PSDEDataQueryBase pSDEDataQueryBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDQCond> selectTempByPSDEDQ(PSDEDataQueryBase pSDEDataQueryBase) throws Exception {
        return this.selectTempByPSDEDQ(pSDEDataQueryBase, "");
    }

    public ArrayList<PSDEDQCond> selectTempByPSDEDQ(PSDEDataQueryBase pSDEDataQueryBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDQID", (Object)pSDEDataQueryBase.getPSDEDataQueryId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEDQCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEDQCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDQCond> selectByPPSDEDQCond(PSDEDQCondBase pSDEDQCondBase) throws Exception {
        return this.selectByPPSDEDQCond(pSDEDQCondBase, "", -1);
    }

    public ArrayList<PSDEDQCond> selectByPPSDEDQCond(PSDEDQCondBase pSDEDQCondBase, String string) throws Exception {
        return this.selectByPPSDEDQCond(pSDEDQCondBase, string, -1);
    }

    public ArrayList<PSDEDQCond> selectByPPSDEDQCond(PSDEDQCondBase pSDEDQCondBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSDEDQCONDID", (Object)pSDEDQCondBase.getPSDEDQCondId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSDEDQCondCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSDEDQCondCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDQCond> selectTempByPPSDEDQCond(PSDEDQCondBase pSDEDQCondBase) throws Exception {
        return this.selectTempByPPSDEDQCond(pSDEDQCondBase, "");
    }

    public ArrayList<PSDEDQCond> selectTempByPPSDEDQCond(PSDEDQCondBase pSDEDQCondBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSDEDQCONDID", (Object)pSDEDQCondBase.getPSDEDQCondId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPPSDEDQCondCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPPSDEDQCondCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDQCond> selectByPSDEDQJoin(PSDEDQJoinBase pSDEDQJoinBase) throws Exception {
        return this.selectByPSDEDQJoin(pSDEDQJoinBase, "", -1);
    }

    public ArrayList<PSDEDQCond> selectByPSDEDQJoin(PSDEDQJoinBase pSDEDQJoinBase, String string) throws Exception {
        return this.selectByPSDEDQJoin(pSDEDQJoinBase, string, -1);
    }

    public ArrayList<PSDEDQCond> selectByPSDEDQJoin(PSDEDQJoinBase pSDEDQJoinBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDQJOINID", (Object)pSDEDQJoinBase.getPSDEDQJoinId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEDQJoinCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEDQJoinCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDQCond> selectTempByPSDEDQJoin(PSDEDQJoinBase pSDEDQJoinBase) throws Exception {
        return this.selectTempByPSDEDQJoin(pSDEDQJoinBase, "");
    }

    public ArrayList<PSDEDQCond> selectTempByPSDEDQJoin(PSDEDQJoinBase pSDEDQJoinBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDQJOINID", (Object)pSDEDQJoinBase.getPSDEDQJoinId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEDQJoinCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEDQJoinCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDQCond> selectByPSDEDQPDCond(PSDEDQPDCondBase pSDEDQPDCondBase) throws Exception {
        return this.selectByPSDEDQPDCond(pSDEDQPDCondBase, "", -1);
    }

    public ArrayList<PSDEDQCond> selectByPSDEDQPDCond(PSDEDQPDCondBase pSDEDQPDCondBase, String string) throws Exception {
        return this.selectByPSDEDQPDCond(pSDEDQPDCondBase, string, -1);
    }

    public ArrayList<PSDEDQCond> selectByPSDEDQPDCond(PSDEDQPDCondBase pSDEDQPDCondBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDQPDCONDID", (Object)pSDEDQPDCondBase.getPSDEDQPDCondId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEDQPDCondCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEDQPDCondCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDQCond> selectByPSDEField(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByPSDEField(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEDQCond> selectByPSDEField(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByPSDEField(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEDQCond> selectByPSDEField(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFieldCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFieldCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDQCond> selectByPSSysDBVF(PSSysDBVFBase pSSysDBVFBase) throws Exception {
        return this.selectByPSSysDBVF(pSSysDBVFBase, "", -1);
    }

    public ArrayList<PSDEDQCond> selectByPSSysDBVF(PSSysDBVFBase pSSysDBVFBase, String string) throws Exception {
        return this.selectByPSSysDBVF(pSSysDBVFBase, string, -1);
    }

    public ArrayList<PSDEDQCond> selectByPSSysDBVF(PSSysDBVFBase pSSysDBVFBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSDBVFID", (Object)pSSysDBVFBase.getPSSysDBVFId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysDBVFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysDBVFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDQCond> selectByPSVarType(PSVarTypeBase pSVarTypeBase) throws Exception {
        return this.selectByPSVarType(pSVarTypeBase, "", -1);
    }

    public ArrayList<PSDEDQCond> selectByPSVarType(PSVarTypeBase pSVarTypeBase, String string) throws Exception {
        return this.selectByPSVarType(pSVarTypeBase, string, -1);
    }

    public ArrayList<PSDEDQCond> selectByPSVarType(PSVarTypeBase pSVarTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSVARTYPEID", (Object)pSVarTypeBase.getPSVarTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSVarTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSVarTypeCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDBValueOP(PSDBValueOP pSDBValueOP) throws Exception {
        ArrayList<PSDEDQCond> arrayList = this.selectByPSDBValueOP(pSDBValueOP, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDBVALUEOP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDBValueOP);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDQCOND_PSDBVALUEOP_PSDBVALUEOPID", "", iDataEntityModel.getName(), "PSDEDQCOND", iDataEntityModel.getDataInfo((IEntity)pSDBValueOP), arrayList.get(0)));
        }
    }

    public void resetPSDBValueOP(PSDBValueOP pSDBValueOP) throws Exception {
        ArrayList<PSDEDQCond> arrayList = this.selectByPSDBValueOP(pSDBValueOP);
        for (PSDEDQCond pSDEDQCond : arrayList) {
            PSDEDQCond pSDEDQCond2 = (PSDEDQCond)this.getDEModel().createEntity();
            pSDEDQCond2.setPSDEDQCondId(pSDEDQCond.getPSDEDQCondId());
            pSDEDQCond2.setPSDBValueOPId(null);
            this.update(pSDEDQCond2);
        }
    }

    public void removeByPSDBValueOP(PSDBValueOP pSDBValueOP) throws Exception {
        final PSDBValueOP pSDBValueOP2 = pSDBValueOP;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDQCondServiceBase.this.onBeforeRemoveByPSDBValueOP(pSDBValueOP2);
                PSDEDQCondServiceBase.this.internalRemoveByPSDBValueOP(pSDBValueOP2);
                PSDEDQCondServiceBase.this.onAfterRemoveByPSDBValueOP(pSDBValueOP2);
            }
        });
    }

    protected void onBeforeRemoveByPSDBValueOP(PSDBValueOP pSDBValueOP) throws Exception {
    }

    protected void internalRemoveByPSDBValueOP(PSDBValueOP pSDBValueOP) throws Exception {
        ArrayList<PSDEDQCond> arrayList = this.selectByPSDBValueOP(pSDBValueOP);
        this.onBeforeRemoveByPSDBValueOP(pSDBValueOP, arrayList);
        for (PSDEDQCond pSDEDQCond : arrayList) {
            this.remove((IEntity)pSDEDQCond);
        }
        this.onAfterRemoveByPSDBValueOP(pSDBValueOP, arrayList);
    }

    protected void onAfterRemoveByPSDBValueOP(PSDBValueOP pSDBValueOP) throws Exception {
    }

    protected void onBeforeRemoveByPSDBValueOP(PSDBValueOP pSDBValueOP, ArrayList<PSDEDQCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDBValueOP(PSDBValueOP pSDBValueOP, ArrayList<PSDEDQCond> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
    }

    public void resetPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSDEDQCond> arrayList = this.selectByPSDEDQ(pSDEDataQuery);
        for (PSDEDQCond pSDEDQCond : arrayList) {
            PSDEDQCond pSDEDQCond2 = (PSDEDQCond)this.getDEModel().createEntity();
            pSDEDQCond2.setPSDEDQCondId(pSDEDQCond.getPSDEDQCondId());
            pSDEDQCond2.setPSDEDQId(null);
            this.update(pSDEDQCond2);
        }
    }

    public void resetTempPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSDEDQCond> arrayList = this.selectTempByPSDEDQ(pSDEDataQuery);
        for (PSDEDQCond pSDEDQCond : arrayList) {
            PSDEDQCond pSDEDQCond2 = (PSDEDQCond)this.getDEModel().createEntity();
            pSDEDQCond2.setPSDEDQCondId(pSDEDQCond.getPSDEDQCondId());
            pSDEDQCond2.setPSDEDQId(null);
            this.updateTemp((IEntity)pSDEDQCond2);
        }
    }

    public void removeByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
        final PSDEDataQuery pSDEDataQuery2 = pSDEDataQuery;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDQCondServiceBase.this.onBeforeRemoveByPSDEDQ(pSDEDataQuery2);
                PSDEDQCondServiceBase.this.internalRemoveByPSDEDQ(pSDEDataQuery2);
                PSDEDQCondServiceBase.this.onAfterRemoveByPSDEDQ(pSDEDataQuery2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
    }

    protected void internalRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSDEDQCond> arrayList = this.selectByPSDEDQ(pSDEDataQuery);
        this.onBeforeRemoveByPSDEDQ(pSDEDataQuery, arrayList);
        for (PSDEDQCond pSDEDQCond : arrayList) {
            this.remove((IEntity)pSDEDQCond);
        }
        this.onAfterRemoveByPSDEDQ(pSDEDataQuery, arrayList);
    }

    protected void onAfterRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery, ArrayList<PSDEDQCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery, ArrayList<PSDEDQCond> arrayList) throws Exception {
    }

    public void testRemoveByPPSDEDQCond(PSDEDQCond pSDEDQCond) throws Exception {
    }

    public void resetPPSDEDQCond(PSDEDQCond pSDEDQCond) throws Exception {
        ArrayList<PSDEDQCond> arrayList = this.selectByPPSDEDQCond(pSDEDQCond);
        for (PSDEDQCond pSDEDQCond2 : arrayList) {
            PSDEDQCond pSDEDQCond3 = (PSDEDQCond)this.getDEModel().createEntity();
            pSDEDQCond3.setPSDEDQCondId(pSDEDQCond2.getPSDEDQCondId());
            pSDEDQCond3.setPPSDEDQCondId(null);
            this.update(pSDEDQCond3);
        }
    }

    public void resetTempPPSDEDQCond(PSDEDQCond pSDEDQCond) throws Exception {
        ArrayList<PSDEDQCond> arrayList = this.selectTempByPPSDEDQCond(pSDEDQCond);
        for (PSDEDQCond pSDEDQCond2 : arrayList) {
            PSDEDQCond pSDEDQCond3 = (PSDEDQCond)this.getDEModel().createEntity();
            pSDEDQCond3.setPSDEDQCondId(pSDEDQCond2.getPSDEDQCondId());
            pSDEDQCond3.setPPSDEDQCondId(null);
            this.updateTemp((IEntity)pSDEDQCond3);
        }
    }

    public void removeByPPSDEDQCond(PSDEDQCond pSDEDQCond) throws Exception {
        final PSDEDQCond pSDEDQCond2 = pSDEDQCond;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDQCondServiceBase.this.onBeforeRemoveByPPSDEDQCond(pSDEDQCond2);
                PSDEDQCondServiceBase.this.internalRemoveByPPSDEDQCond(pSDEDQCond2);
                PSDEDQCondServiceBase.this.onAfterRemoveByPPSDEDQCond(pSDEDQCond2);
            }
        });
    }

    protected void onBeforeRemoveByPPSDEDQCond(PSDEDQCond pSDEDQCond) throws Exception {
    }

    protected void internalRemoveByPPSDEDQCond(PSDEDQCond pSDEDQCond) throws Exception {
        ArrayList<PSDEDQCond> arrayList = this.selectByPPSDEDQCond(pSDEDQCond);
        this.onBeforeRemoveByPPSDEDQCond(pSDEDQCond, arrayList);
        for (PSDEDQCond pSDEDQCond2 : arrayList) {
            this.remove((IEntity)pSDEDQCond2);
        }
        this.onAfterRemoveByPPSDEDQCond(pSDEDQCond, arrayList);
    }

    protected void onAfterRemoveByPPSDEDQCond(PSDEDQCond pSDEDQCond) throws Exception {
    }

    protected void onBeforeRemoveByPPSDEDQCond(PSDEDQCond pSDEDQCond, ArrayList<PSDEDQCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSDEDQCond(PSDEDQCond pSDEDQCond, ArrayList<PSDEDQCond> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDQJoin(PSDEDQJoin pSDEDQJoin) throws Exception {
    }

    public void resetPSDEDQJoin(PSDEDQJoin pSDEDQJoin) throws Exception {
        ArrayList<PSDEDQCond> arrayList = this.selectByPSDEDQJoin(pSDEDQJoin);
        for (PSDEDQCond pSDEDQCond : arrayList) {
            PSDEDQCond pSDEDQCond2 = (PSDEDQCond)this.getDEModel().createEntity();
            pSDEDQCond2.setPSDEDQCondId(pSDEDQCond.getPSDEDQCondId());
            pSDEDQCond2.setPSDEDQJoinId(null);
            this.update(pSDEDQCond2);
        }
    }

    public void resetTempPSDEDQJoin(PSDEDQJoin pSDEDQJoin) throws Exception {
        ArrayList<PSDEDQCond> arrayList = this.selectTempByPSDEDQJoin(pSDEDQJoin);
        for (PSDEDQCond pSDEDQCond : arrayList) {
            PSDEDQCond pSDEDQCond2 = (PSDEDQCond)this.getDEModel().createEntity();
            pSDEDQCond2.setPSDEDQCondId(pSDEDQCond.getPSDEDQCondId());
            pSDEDQCond2.setPSDEDQJoinId(null);
            this.updateTemp((IEntity)pSDEDQCond2);
        }
    }

    public void removeByPSDEDQJoin(PSDEDQJoin pSDEDQJoin) throws Exception {
        final PSDEDQJoin pSDEDQJoin2 = pSDEDQJoin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDQCondServiceBase.this.onBeforeRemoveByPSDEDQJoin(pSDEDQJoin2);
                PSDEDQCondServiceBase.this.internalRemoveByPSDEDQJoin(pSDEDQJoin2);
                PSDEDQCondServiceBase.this.onAfterRemoveByPSDEDQJoin(pSDEDQJoin2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDQJoin(PSDEDQJoin pSDEDQJoin) throws Exception {
    }

    protected void internalRemoveByPSDEDQJoin(PSDEDQJoin pSDEDQJoin) throws Exception {
        ArrayList<PSDEDQCond> arrayList = this.selectByPSDEDQJoin(pSDEDQJoin);
        this.onBeforeRemoveByPSDEDQJoin(pSDEDQJoin, arrayList);
        for (PSDEDQCond pSDEDQCond : arrayList) {
            this.remove((IEntity)pSDEDQCond);
        }
        this.onAfterRemoveByPSDEDQJoin(pSDEDQJoin, arrayList);
    }

    protected void onAfterRemoveByPSDEDQJoin(PSDEDQJoin pSDEDQJoin) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDQJoin(PSDEDQJoin pSDEDQJoin, ArrayList<PSDEDQCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDQJoin(PSDEDQJoin pSDEDQJoin, ArrayList<PSDEDQCond> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDQPDCond(PSDEDQPDCond pSDEDQPDCond) throws Exception {
        ArrayList<PSDEDQCond> arrayList = this.selectByPSDEDQPDCond(pSDEDQPDCond, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDQPDCOND");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDQPDCond);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDQCOND_PSDEDQPDCOND_PSDEDQPDCONDID", "", iDataEntityModel.getName(), "PSDEDQCOND", iDataEntityModel.getDataInfo((IEntity)pSDEDQPDCond), arrayList.get(0)));
        }
    }

    public void resetPSDEDQPDCond(PSDEDQPDCond pSDEDQPDCond) throws Exception {
        ArrayList<PSDEDQCond> arrayList = this.selectByPSDEDQPDCond(pSDEDQPDCond);
        for (PSDEDQCond pSDEDQCond : arrayList) {
            PSDEDQCond pSDEDQCond2 = (PSDEDQCond)this.getDEModel().createEntity();
            pSDEDQCond2.setPSDEDQCondId(pSDEDQCond.getPSDEDQCondId());
            pSDEDQCond2.setPSDEDQPDCondId(null);
            this.update(pSDEDQCond2);
        }
    }

    public void removeByPSDEDQPDCond(PSDEDQPDCond pSDEDQPDCond) throws Exception {
        final PSDEDQPDCond pSDEDQPDCond2 = pSDEDQPDCond;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDQCondServiceBase.this.onBeforeRemoveByPSDEDQPDCond(pSDEDQPDCond2);
                PSDEDQCondServiceBase.this.internalRemoveByPSDEDQPDCond(pSDEDQPDCond2);
                PSDEDQCondServiceBase.this.onAfterRemoveByPSDEDQPDCond(pSDEDQPDCond2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDQPDCond(PSDEDQPDCond pSDEDQPDCond) throws Exception {
    }

    protected void internalRemoveByPSDEDQPDCond(PSDEDQPDCond pSDEDQPDCond) throws Exception {
        ArrayList<PSDEDQCond> arrayList = this.selectByPSDEDQPDCond(pSDEDQPDCond);
        this.onBeforeRemoveByPSDEDQPDCond(pSDEDQPDCond, arrayList);
        for (PSDEDQCond pSDEDQCond : arrayList) {
            this.remove((IEntity)pSDEDQCond);
        }
        this.onAfterRemoveByPSDEDQPDCond(pSDEDQPDCond, arrayList);
    }

    protected void onAfterRemoveByPSDEDQPDCond(PSDEDQPDCond pSDEDQPDCond) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDQPDCond(PSDEDQPDCond pSDEDQPDCond, ArrayList<PSDEDQCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDQPDCond(PSDEDQPDCond pSDEDQPDCond, ArrayList<PSDEDQCond> arrayList) throws Exception {
    }

    public void testRemoveByPSDEField(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEDQCond> arrayList = this.selectByPSDEField(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDQCOND_PSDEFIELD_PSDEFID", "", iDataEntityModel.getName(), "PSDEDQCOND", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetPSDEField(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEDQCond> arrayList = this.selectByPSDEField(pSDEField);
        for (PSDEDQCond pSDEDQCond : arrayList) {
            PSDEDQCond pSDEDQCond2 = (PSDEDQCond)this.getDEModel().createEntity();
            pSDEDQCond2.setPSDEDQCondId(pSDEDQCond.getPSDEDQCondId());
            pSDEDQCond2.setPSDEFId(null);
            this.update(pSDEDQCond2);
        }
    }

    public void removeByPSDEField(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDQCondServiceBase.this.onBeforeRemoveByPSDEField(pSDEField2);
                PSDEDQCondServiceBase.this.internalRemoveByPSDEField(pSDEField2);
                PSDEDQCondServiceBase.this.onAfterRemoveByPSDEField(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEField(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByPSDEField(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEDQCond> arrayList = this.selectByPSDEField(pSDEField);
        this.onBeforeRemoveByPSDEField(pSDEField, arrayList);
        for (PSDEDQCond pSDEDQCond : arrayList) {
            this.remove((IEntity)pSDEDQCond);
        }
        this.onAfterRemoveByPSDEField(pSDEField, arrayList);
    }

    protected void onAfterRemoveByPSDEField(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByPSDEField(PSDEField pSDEField, ArrayList<PSDEDQCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEField(PSDEField pSDEField, ArrayList<PSDEDQCond> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDBVF(PSSysDBVF pSSysDBVF) throws Exception {
        ArrayList<PSDEDQCond> arrayList = this.selectByPSSysDBVF(pSSysDBVF, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDBVF");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDBVF);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDQCOND_PSSYSDBVF_PSSYSDBVFID", "", iDataEntityModel.getName(), "PSDEDQCOND", iDataEntityModel.getDataInfo((IEntity)pSSysDBVF), arrayList.get(0)));
        }
    }

    public void resetPSSysDBVF(PSSysDBVF pSSysDBVF) throws Exception {
        ArrayList<PSDEDQCond> arrayList = this.selectByPSSysDBVF(pSSysDBVF);
        for (PSDEDQCond pSDEDQCond : arrayList) {
            PSDEDQCond pSDEDQCond2 = (PSDEDQCond)this.getDEModel().createEntity();
            pSDEDQCond2.setPSDEDQCondId(pSDEDQCond.getPSDEDQCondId());
            pSDEDQCond2.setPSSysDBVFId(null);
            this.update(pSDEDQCond2);
        }
    }

    public void removeByPSSysDBVF(PSSysDBVF pSSysDBVF) throws Exception {
        final PSSysDBVF pSSysDBVF2 = pSSysDBVF;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDQCondServiceBase.this.onBeforeRemoveByPSSysDBVF(pSSysDBVF2);
                PSDEDQCondServiceBase.this.internalRemoveByPSSysDBVF(pSSysDBVF2);
                PSDEDQCondServiceBase.this.onAfterRemoveByPSSysDBVF(pSSysDBVF2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDBVF(PSSysDBVF pSSysDBVF) throws Exception {
    }

    protected void internalRemoveByPSSysDBVF(PSSysDBVF pSSysDBVF) throws Exception {
        ArrayList<PSDEDQCond> arrayList = this.selectByPSSysDBVF(pSSysDBVF);
        this.onBeforeRemoveByPSSysDBVF(pSSysDBVF, arrayList);
        for (PSDEDQCond pSDEDQCond : arrayList) {
            this.remove((IEntity)pSDEDQCond);
        }
        this.onAfterRemoveByPSSysDBVF(pSSysDBVF, arrayList);
    }

    protected void onAfterRemoveByPSSysDBVF(PSSysDBVF pSSysDBVF) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDBVF(PSSysDBVF pSSysDBVF, ArrayList<PSDEDQCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDBVF(PSSysDBVF pSSysDBVF, ArrayList<PSDEDQCond> arrayList) throws Exception {
    }

    public void testRemoveByPSVarType(PSVarType pSVarType) throws Exception {
        ArrayList<PSDEDQCond> arrayList = this.selectByPSVarType(pSVarType, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSVARTYPE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSVarType);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDQCOND_PSVARTYPE_PSVARTYPEID", "", iDataEntityModel.getName(), "PSDEDQCOND", iDataEntityModel.getDataInfo((IEntity)pSVarType), arrayList.get(0)));
        }
    }

    public void resetPSVarType(PSVarType pSVarType) throws Exception {
        ArrayList<PSDEDQCond> arrayList = this.selectByPSVarType(pSVarType);
        for (PSDEDQCond pSDEDQCond : arrayList) {
            PSDEDQCond pSDEDQCond2 = (PSDEDQCond)this.getDEModel().createEntity();
            pSDEDQCond2.setPSDEDQCondId(pSDEDQCond.getPSDEDQCondId());
            pSDEDQCond2.setPSVARTypeId(null);
            this.update(pSDEDQCond2);
        }
    }

    public void removeByPSVarType(PSVarType pSVarType) throws Exception {
        final PSVarType pSVarType2 = pSVarType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDQCondServiceBase.this.onBeforeRemoveByPSVarType(pSVarType2);
                PSDEDQCondServiceBase.this.internalRemoveByPSVarType(pSVarType2);
                PSDEDQCondServiceBase.this.onAfterRemoveByPSVarType(pSVarType2);
            }
        });
    }

    protected void onBeforeRemoveByPSVarType(PSVarType pSVarType) throws Exception {
    }

    protected void internalRemoveByPSVarType(PSVarType pSVarType) throws Exception {
        ArrayList<PSDEDQCond> arrayList = this.selectByPSVarType(pSVarType);
        this.onBeforeRemoveByPSVarType(pSVarType, arrayList);
        for (PSDEDQCond pSDEDQCond : arrayList) {
            this.remove((IEntity)pSDEDQCond);
        }
        this.onAfterRemoveByPSVarType(pSVarType, arrayList);
    }

    protected void onAfterRemoveByPSVarType(PSVarType pSVarType) throws Exception {
    }

    protected void onBeforeRemoveByPSVarType(PSVarType pSVarType, ArrayList<PSDEDQCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSVarType(PSVarType pSVarType, ArrayList<PSDEDQCond> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEDQCond pSDEDQCond) throws Exception {
        PSDEDQCondService pSDEDQCondService = (PSDEDQCondService)ServiceGlobal.getService(PSDEDQCondService.class, (SessionFactory)this.getSessionFactory());
        pSDEDQCondService.testRemoveByPPSDEDQCond(pSDEDQCond);
        pSDEDQCondService.removeByPPSDEDQCond(pSDEDQCond);
        super.onBeforeRemove(pSDEDQCond);
    }

    protected void onBeforeRemoveTemp(PSDEDQCond pSDEDQCond) throws Exception {
        PSDEDQCondService pSDEDQCondService = (PSDEDQCondService)ServiceGlobal.getService(PSDEDQCondService.class, (SessionFactory)this.getSessionFactory());
        pSDEDQCondService.resetTempPPSDEDQCond(pSDEDQCond);
        super.onBeforeRemoveTemp((IEntity)pSDEDQCond);
    }

    public void removeTempByPPSDEDQCond(PSDEDQCond pSDEDQCond) throws Exception {
        final PSDEDQCond pSDEDQCond2 = pSDEDQCond;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDQCondServiceBase.this.onBeforeRemoveTempByPPSDEDQCond(pSDEDQCond2);
                PSDEDQCondServiceBase.this.internalRemoveTempByPPSDEDQCond(pSDEDQCond2);
                PSDEDQCondServiceBase.this.onAfterRemoveTempByPPSDEDQCond(pSDEDQCond2);
            }
        });
    }

    protected void onBeforeRemoveTempByPPSDEDQCond(PSDEDQCond pSDEDQCond) throws Exception {
    }

    protected void internalRemoveTempByPPSDEDQCond(PSDEDQCond pSDEDQCond) throws Exception {
        ArrayList<PSDEDQCond> arrayList = this.selectTempByPPSDEDQCond(pSDEDQCond);
        this.onBeforeRemoveTempByPPSDEDQCond(pSDEDQCond, arrayList);
        for (PSDEDQCond pSDEDQCond2 : arrayList) {
            this.removeTemp((IEntity)pSDEDQCond2);
        }
        this.onAfterRemoveTempByPPSDEDQCond(pSDEDQCond, arrayList);
    }

    protected void onAfterRemoveTempByPPSDEDQCond(PSDEDQCond pSDEDQCond) throws Exception {
    }

    protected void onBeforeRemoveTempByPPSDEDQCond(PSDEDQCond pSDEDQCond, ArrayList<PSDEDQCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPPSDEDQCond(PSDEDQCond pSDEDQCond, ArrayList<PSDEDQCond> arrayList) throws Exception {
    }

    public void removeTempByPSDEDQJoin(PSDEDQJoin pSDEDQJoin) throws Exception {
        final PSDEDQJoin pSDEDQJoin2 = pSDEDQJoin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDQCondServiceBase.this.onBeforeRemoveTempByPSDEDQJoin(pSDEDQJoin2);
                PSDEDQCondServiceBase.this.internalRemoveTempByPSDEDQJoin(pSDEDQJoin2);
                PSDEDQCondServiceBase.this.onAfterRemoveTempByPSDEDQJoin(pSDEDQJoin2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEDQJoin(PSDEDQJoin pSDEDQJoin) throws Exception {
    }

    protected void internalRemoveTempByPSDEDQJoin(PSDEDQJoin pSDEDQJoin) throws Exception {
        ArrayList<PSDEDQCond> arrayList = this.selectTempByPSDEDQJoin(pSDEDQJoin);
        this.onBeforeRemoveTempByPSDEDQJoin(pSDEDQJoin, arrayList);
        for (PSDEDQCond pSDEDQCond : arrayList) {
            this.removeTemp((IEntity)pSDEDQCond);
        }
        this.onAfterRemoveTempByPSDEDQJoin(pSDEDQJoin, arrayList);
    }

    protected void onAfterRemoveTempByPSDEDQJoin(PSDEDQJoin pSDEDQJoin) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEDQJoin(PSDEDQJoin pSDEDQJoin, ArrayList<PSDEDQCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEDQJoin(PSDEDQJoin pSDEDQJoin, ArrayList<PSDEDQCond> arrayList) throws Exception {
    }

    public void removeTempByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
        final PSDEDataQuery pSDEDataQuery2 = pSDEDataQuery;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDQCondServiceBase.this.onBeforeRemoveTempByPSDEDQ(pSDEDataQuery2);
                PSDEDQCondServiceBase.this.internalRemoveTempByPSDEDQ(pSDEDataQuery2);
                PSDEDQCondServiceBase.this.onAfterRemoveTempByPSDEDQ(pSDEDataQuery2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
    }

    protected void internalRemoveTempByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSDEDQCond> arrayList = this.selectTempByPSDEDQ(pSDEDataQuery);
        this.onBeforeRemoveTempByPSDEDQ(pSDEDataQuery, arrayList);
        for (PSDEDQCond pSDEDQCond : arrayList) {
            this.removeTemp((IEntity)pSDEDQCond);
        }
        this.onAfterRemoveTempByPSDEDQ(pSDEDataQuery, arrayList);
    }

    protected void onAfterRemoveTempByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEDQ(PSDEDataQuery pSDEDataQuery, ArrayList<PSDEDQCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEDQ(PSDEDataQuery pSDEDataQuery, ArrayList<PSDEDQCond> arrayList) throws Exception {
    }

    protected void getRelatedDataTempMajor(PSDEDQCond pSDEDQCond) throws Exception {
        super.getRelatedDataTempMajor((IEntity)pSDEDQCond);
    }

    protected void updateRelatedDataTempMajor(PSDEDQCond pSDEDQCond, PSDEDQCond pSDEDQCond2) throws Exception {
        super.updateRelatedDataTempMajor((IEntity)pSDEDQCond, (IEntity)pSDEDQCond2);
    }

    protected void replaceParentInfo(PSDEDQCond pSDEDQCond, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDEDQCond, cloneSession);
        if (pSDEDQCond.getPSDBValueOPId() != null && (iEntity = cloneSession.getEntity("PSDBVALUEOP", (Object)pSDEDQCond.getPSDBValueOPId())) != null) {
            this.onFillParentInfo_PSDBValueOP(pSDEDQCond, (PSDBValueOP)iEntity);
        }
        if (pSDEDQCond.getPSDEDQId() != null && (iEntity = cloneSession.getEntity("PSDEDATAQUERY", (Object)pSDEDQCond.getPSDEDQId())) != null) {
            this.onFillParentInfo_PSDEDQ(pSDEDQCond, (PSDEDataQuery)iEntity);
        }
        if (pSDEDQCond.getPPSDEDQCondId() != null && (iEntity = cloneSession.getEntity("PSDEDQCOND", (Object)pSDEDQCond.getPPSDEDQCondId())) != null) {
            this.onFillParentInfo_PPSDEDQCond(pSDEDQCond, (PSDEDQCond)iEntity);
        }
        if (pSDEDQCond.getPSDEDQJoinId() != null && (iEntity = cloneSession.getEntity("PSDEDQJOIN", (Object)pSDEDQCond.getPSDEDQJoinId())) != null) {
            this.onFillParentInfo_PSDEDQJoin(pSDEDQCond, (PSDEDQJoin)iEntity);
        }
        if (pSDEDQCond.getPSDEDQPDCondId() != null && (iEntity = cloneSession.getEntity("PSDEDQPDCOND", (Object)pSDEDQCond.getPSDEDQPDCondId())) != null) {
            this.onFillParentInfo_PSDEDQPDCond(pSDEDQCond, (PSDEDQPDCond)iEntity);
        }
        if (pSDEDQCond.getPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEDQCond.getPSDEFId())) != null) {
            this.onFillParentInfo_PSDEField(pSDEDQCond, (PSDEField)iEntity);
        }
        if (pSDEDQCond.getPSSysDBVFId() != null && (iEntity = cloneSession.getEntity("PSSYSDBVF", (Object)pSDEDQCond.getPSSysDBVFId())) != null) {
            this.onFillParentInfo_PSSysDBVF(pSDEDQCond, (PSSysDBVF)iEntity);
        }
        if (pSDEDQCond.getPSVARTypeId() != null && (iEntity = cloneSession.getEntity("PSVARTYPE", (Object)pSDEDQCond.getPSVARTypeId())) != null) {
            this.onFillParentInfo_PSVarType(pSDEDQCond, (PSVarType)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEDQCond pSDEDQCond, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEDQCond, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEDQCond pSDEDQCond, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CondTag(bl, pSDEDQCond, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CondTag2(bl, pSDEDQCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CondType(bl, pSDEDQCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CondValue(bl, pSDEDQCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CondValueText(bl, pSDEDQCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCond(bl, pSDEDQCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomType(bl, pSDEDQCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupNotFlag(bl, pSDEDQCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupOP(bl, pSDEDQCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IgnoreEmpty(bl, pSDEDQCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LevelTag(bl, pSDEDQCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LevelValue(bl, pSDEDQCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEDQCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDEDQCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSDEDQCondId(bl, pSDEDQCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDBValueOPId(bl, pSDEDQCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDBValueOPName(bl, pSDEDQCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDQCondId(bl, pSDEDQCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDQCondName(bl, pSDEDQCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDQId(bl, pSDEDQCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDQJoinId(bl, pSDEDQCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDQPDCondId(bl, pSDEDQCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFId(bl, pSDEDQCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFName(bl, pSDEDQCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEDQCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDBVFId(bl, pSDEDQCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDBVFName(bl, pSDEDQCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSVARTypeId(bl, pSDEDQCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSVARTypeName(bl, pSDEDQCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEDQCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEDQCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEDQCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEDQCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEDQCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEDQCond, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CondTag(boolean bl, PSDEDQCond pSDEDQCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCond.isCondTagDirty() : !pSDEDQCond.isCondTagDirty()) {
            return null;
        }
        String string = pSDEDQCond.getCondTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CondTag_Default((IEntity)pSDEDQCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONDTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CondTag2(boolean bl, PSDEDQCond pSDEDQCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCond.isCondTag2Dirty() : !pSDEDQCond.isCondTag2Dirty()) {
            return null;
        }
        String string = pSDEDQCond.getCondTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CondTag2_Default((IEntity)pSDEDQCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONDTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CondType(boolean bl, PSDEDQCond pSDEDQCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCond.isCondTypeDirty() && !bl2 : !pSDEDQCond.isCondTypeDirty()) {
            return null;
        }
        String string = pSDEDQCond.getCondType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONDTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CondType_Default((IEntity)pSDEDQCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONDTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CondValue(boolean bl, PSDEDQCond pSDEDQCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCond.isCondValueDirty() : !pSDEDQCond.isCondValueDirty()) {
            return null;
        }
        String string = pSDEDQCond.getCondValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CondValue_Default((IEntity)pSDEDQCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONDVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CondValueText(boolean bl, PSDEDQCond pSDEDQCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCond.isCondValueTextDirty() : !pSDEDQCond.isCondValueTextDirty()) {
            return null;
        }
        String string = pSDEDQCond.getCondValueText();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CondValueText_Default((IEntity)pSDEDQCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONDVALUETEXT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomCond(boolean bl, PSDEDQCond pSDEDQCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCond.isCustomCondDirty() : !pSDEDQCond.isCustomCondDirty()) {
            return null;
        }
        String string = pSDEDQCond.getCustomCond();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCond_Default((IEntity)pSDEDQCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMCOND");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomType(boolean bl, PSDEDQCond pSDEDQCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCond.isCustomTypeDirty() : !pSDEDQCond.isCustomTypeDirty()) {
            return null;
        }
        String string = pSDEDQCond.getCustomType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomType_Default((IEntity)pSDEDQCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupNotFlag(boolean bl, PSDEDQCond pSDEDQCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCond.isGroupNotFlagDirty() : !pSDEDQCond.isGroupNotFlagDirty()) {
            return null;
        }
        Integer n = pSDEDQCond.getGroupNotFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_GroupNotFlag_Default((IEntity)pSDEDQCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPNOTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupOP(boolean bl, PSDEDQCond pSDEDQCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCond.isGroupOPDirty() : !pSDEDQCond.isGroupOPDirty()) {
            return null;
        }
        String string = pSDEDQCond.getGroupOP();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupOP_Default((IEntity)pSDEDQCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPOP");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IgnoreEmpty(boolean bl, PSDEDQCond pSDEDQCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCond.isIgnoreEmptyDirty() : !pSDEDQCond.isIgnoreEmptyDirty()) {
            return null;
        }
        Integer n = pSDEDQCond.getIgnoreEmpty();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_IgnoreEmpty_Default((IEntity)pSDEDQCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IGNOREEMPTY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LevelTag(boolean bl, PSDEDQCond pSDEDQCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCond.isLevelTagDirty() : !pSDEDQCond.isLevelTagDirty()) {
            return null;
        }
        String string = pSDEDQCond.getLevelTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LevelTag_Default((IEntity)pSDEDQCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_LevelValue(boolean bl, PSDEDQCond pSDEDQCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCond.isLevelValueDirty() : !pSDEDQCond.isLevelValueDirty()) {
            return null;
        }
        Integer n = pSDEDQCond.getLevelValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LevelValue_Default((IEntity)pSDEDQCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEDQCond pSDEDQCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCond.isMemoDirty() : !pSDEDQCond.isMemoDirty()) {
            return null;
        }
        String string = pSDEDQCond.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDEDQCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDEDQCond pSDEDQCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCond.isOrderValueDirty() : !pSDEDQCond.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDEDQCond.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSDEDQCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_PPSDEDQCondId(boolean bl, PSDEDQCond pSDEDQCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCond.isPPSDEDQCondIdDirty() : !pSDEDQCond.isPPSDEDQCondIdDirty()) {
            return null;
        }
        String string = pSDEDQCond.getPPSDEDQCondId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSDEDQCondId_Default((IEntity)pSDEDQCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSDEDQCONDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDBValueOPId(boolean bl, PSDEDQCond pSDEDQCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCond.isPSDBValueOPIdDirty() : !pSDEDQCond.isPSDBValueOPIdDirty()) {
            return null;
        }
        String string = pSDEDQCond.getPSDBValueOPId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDBValueOPId_Default((IEntity)pSDEDQCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBVALUEOPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDBValueOPName(boolean bl, PSDEDQCond pSDEDQCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCond.isPSDBValueOPNameDirty() : !pSDEDQCond.isPSDBValueOPNameDirty()) {
            return null;
        }
        String string = pSDEDQCond.getPSDBValueOPName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDBValueOPName_Default((IEntity)pSDEDQCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBVALUEOPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDQCondId(boolean bl, PSDEDQCond pSDEDQCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCond.isPSDEDQCondIdDirty() && !bl2 : !pSDEDQCond.isPSDEDQCondIdDirty()) {
            return null;
        }
        String string = pSDEDQCond.getPSDEDQCondId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDQCONDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDQCondId_Default((IEntity)pSDEDQCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDQCONDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDQCondName(boolean bl, PSDEDQCond pSDEDQCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCond.isPSDEDQCondNameDirty() && !bl2 : !pSDEDQCond.isPSDEDQCondNameDirty()) {
            return null;
        }
        String string = pSDEDQCond.getPSDEDQCondName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDQCONDNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDQCondName_Default((IEntity)pSDEDQCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDQCONDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDQId(boolean bl, PSDEDQCond pSDEDQCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCond.isPSDEDQIdDirty() && !bl2 : !pSDEDQCond.isPSDEDQIdDirty()) {
            return null;
        }
        String string = pSDEDQCond.getPSDEDQId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDQID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDQId_Default((IEntity)pSDEDQCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEDQJoinId(boolean bl, PSDEDQCond pSDEDQCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCond.isPSDEDQJoinIdDirty() && !bl2 : !pSDEDQCond.isPSDEDQJoinIdDirty()) {
            return null;
        }
        String string = pSDEDQCond.getPSDEDQJoinId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDQJOINID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDQJoinId_Default((IEntity)pSDEDQCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEDQPDCondId(boolean bl, PSDEDQCond pSDEDQCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCond.isPSDEDQPDCondIdDirty() : !pSDEDQCond.isPSDEDQPDCondIdDirty()) {
            return null;
        }
        String string = pSDEDQCond.getPSDEDQPDCondId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDQPDCondId_Default((IEntity)pSDEDQCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDQPDCONDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFId(boolean bl, PSDEDQCond pSDEDQCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCond.isPSDEFIdDirty() : !pSDEDQCond.isPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEDQCond.getPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFId_Default((IEntity)pSDEDQCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFName(boolean bl, PSDEDQCond pSDEDQCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCond.isPSDEFNameDirty() : !pSDEDQCond.isPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEDQCond.getPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFName_Default((IEntity)pSDEDQCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEDQCond pSDEDQCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCond.isPSDEIdDirty() : !pSDEDQCond.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEDQCond.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSDEDQCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDBVFId(boolean bl, PSDEDQCond pSDEDQCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCond.isPSSysDBVFIdDirty() : !pSDEDQCond.isPSSysDBVFIdDirty()) {
            return null;
        }
        String string = pSDEDQCond.getPSSysDBVFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDBVFId_Default((IEntity)pSDEDQCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBVFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDBVFName(boolean bl, PSDEDQCond pSDEDQCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCond.isPSSysDBVFNameDirty() : !pSDEDQCond.isPSSysDBVFNameDirty()) {
            return null;
        }
        String string = pSDEDQCond.getPSSysDBVFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDBVFName_Default((IEntity)pSDEDQCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBVFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSVARTypeId(boolean bl, PSDEDQCond pSDEDQCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCond.isPSVARTypeIdDirty() : !pSDEDQCond.isPSVARTypeIdDirty()) {
            return null;
        }
        String string = pSDEDQCond.getPSVARTypeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSVARTypeId_Default((IEntity)pSDEDQCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVARTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSVARTypeName(boolean bl, PSDEDQCond pSDEDQCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCond.isPSVARTypeNameDirty() : !pSDEDQCond.isPSVARTypeNameDirty()) {
            return null;
        }
        String string = pSDEDQCond.getPSVARTypeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSVARTypeName_Default((IEntity)pSDEDQCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVARTYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEDQCond pSDEDQCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCond.isUserCatDirty() : !pSDEDQCond.isUserCatDirty()) {
            return null;
        }
        String string = pSDEDQCond.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSDEDQCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEDQCond pSDEDQCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCond.isUserTagDirty() : !pSDEDQCond.isUserTagDirty()) {
            return null;
        }
        String string = pSDEDQCond.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDEDQCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEDQCond pSDEDQCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCond.isUserTag2Dirty() : !pSDEDQCond.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEDQCond.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDEDQCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEDQCond pSDEDQCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCond.isUserTag3Dirty() : !pSDEDQCond.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEDQCond.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSDEDQCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEDQCond pSDEDQCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDQCond.isUserTag4Dirty() : !pSDEDQCond.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEDQCond.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSDEDQCond, bl2, bl3);
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

    protected void onSyncEntity(PSDEDQCond pSDEDQCond, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEDQCond, bl);
    }

    protected void onSyncIndexEntities(PSDEDQCond pSDEDQCond, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEDQCond, bl);
    }

    public Object getDataContextValue(PSDEDQCond pSDEDQCond, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDEDQCond, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDEDQCond pSDEDQCond, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDEDQCond, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CONDTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CondTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONDTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CondTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONDTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CondType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONDVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CondValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONDVALUETEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CondValueText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMCOND", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomCond_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPNOTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupNotFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPOP", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupOP_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IGNOREEMPTY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IgnoreEmpty_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LEVELTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LevelTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LEVELVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LevelValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSDEDQCONDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSDEDQCondId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSDEDQCONDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSDEDQCondName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDBVALUEOPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBValueOPId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDBVALUEOPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBValueOPName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDQCONDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDQCondId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDQCONDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDQCondName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEDQPDCONDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDQPDCondId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDQPDCONDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDQPDCondName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDBVFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDBVFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDBVFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDBVFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVARTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSVARTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVARTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSVARTypeName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_CondTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONDTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CondTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONDTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CondType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONDTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CondValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONDVALUE", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CondValueText_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONDVALUETEXT", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
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

    protected String onTestValueRule_CustomCond_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CUSTOMCOND", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CustomType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CUSTOMTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupNotFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_GroupOP_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPOP", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IgnoreEmpty_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PPSDEDQCondId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSDEDQCONDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSDEDQCondName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSDEDQCONDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDBValueOPId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDBVALUEOPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDBValueOPName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDBVALUEOPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDQCondId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDQCONDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDQCondName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDQCONDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDEDQPDCondId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDQPDCONDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDQPDCondName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDQPDCONDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDBVFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDBVFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDBVFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDBVFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSVARTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVARTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSVARTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVARTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDEDQCond pSDEDQCond) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEDQCond)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEDQCond pSDEDQCond) throws Exception {
        super.onUpdateParent((IEntity)pSDEDQCond);
    }

    @Override
    protected void exportCurXmlModel(PSDEDQCond pSDEDQCond, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEDQCOND");
        if (!bl) {
            pSDEDQCond.setCreateDate(null);
            pSDEDQCond.setCreateMan(null);
            pSDEDQCond.setLevelTag(null);
            pSDEDQCond.setLevelValue(null);
            pSDEDQCond.setPSDEDQCondId(null);
            pSDEDQCond.setPSDEDQCondName(null);
            pSDEDQCond.setUpdateDate(null);
            pSDEDQCond.setUpdateMan(null);
            pSDEDQCond.setPPSDEDQCondId(null);
            pSDEDQCond.setPSDEDQJoinId(null);
            pSDEDQCond.setPSDEDQJoinName(null);
            pSDEDQCond.setPSDEDQId(null);
            pSDEDQCond.setPSDEDQName(null);
            super.exportCurXmlModel(pSDEDQCond, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDEDQCond pSDEDQCond, XmlNode xmlNode) throws Exception {
        super.onExportRelatedXmlModel(pSDEDQCond, xmlNode);
    }

    @Override
    protected void onImportRelatedXmlModel(PSDEDQCond pSDEDQCond, XmlNode xmlNode) throws Exception {
        super.onImportRelatedXmlModel(pSDEDQCond, xmlNode);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEDQCond pSDEDQCond, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEDQCond, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSDEDQCONDID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEDQCOND#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEDQJOINID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEDQJOIN#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSDEDQCONDID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEDQCOND_PSDEDQCOND_PPSDEDQCONDID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEDQJOINID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEDQCOND_PSDEDQJOIN_PSDEDQJOINID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSDEDQCONDID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PPSDEDQCONDNAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEDQJOINID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEDQJOINNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDEDQCOND", (boolean)true) == 0) {
            iEntity.set("PPSDEDQCONDID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSDEDQJOIN", (boolean)true) == 0) {
            iEntity.set("PSDEDQJOINID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PPSDEDQCONDID", "PSDEDQJOINID"};
    }

    @Override
    public String getModelV2Tag(PSDEDQCond pSDEDQCond) {
        return super.getModelV2Tag(pSDEDQCond);
    }

    @Override
    public boolean setModelV2Tag(PSDEDQCond pSDEDQCond, String string) {
        return super.setModelV2Tag(pSDEDQCond, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PPSDEDQCONDID", "");
        map.put("PSDEDQJOINID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEDQCond pSDEDQCond, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEDQCond.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEDQCond, true);
        return super.getModelV2Entity(pSDEDQCond, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEDQCond pSDEDQCond, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        boolean bl = false;
        if (!StringHelper.isNullOrEmpty((String)pSDEDQCond.getPPSDEDQCondId())) {
            bl = true;
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEDQCond.getPSDEDQJoinId())) {
            bl = true;
        } else if (bl && !objectNode.has("psdedqjoinid")) {
            objectNode.put("psdedqjoinid", "<PSDEDQJOIN>");
        }
        return super.testCompileCurModelV2(pSDEDQCond, objectNode, string, string2, n);
    }

    @Override
    protected ObjectNode onFillModelV2(ObjectNode objectNode, PSDEDQCond pSDEDQCond, String string, Map<String, String> map) throws Exception {
        if (PSDEDQCondServiceBase.isSimpleImportExportMode()) {
            map.put("PPSDEDQCONDID", "");
            map.put("PSDEDQJOINID", "");
        }
        return super.onFillModelV2(objectNode, pSDEDQCond, string, map);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSDEDQCOND_PSDEDQCOND_PPSDEDQCONDID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSDEDQCond pSDEDQCond, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSDEDQCond, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDEDQCond pSDEDQCond, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEDQCOND_PSDEDQCOND_PPSDEDQCONDID")) {
            Object object;
            PSDEDQCond pSDEDQCond22;
            Object object2;
            Object object3;
            Object object4;
            PSDEDQCondService pSDEDQCondService = (PSDEDQCondService)ServiceGlobal.getService(PSDEDQCondService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSDEDQCond> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEDQCOND#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEDQCOND", (Object)pSDEDQCond.getPSDEDQCondId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        pSDEDQCond22 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add(pSDEDQCond22);
                    }
                }
            } else {
                arrayList = new ArrayList<PSDEDQCond>();
                object4 = pSDEDQCondService.selectByPPSDEDQCond(pSDEDQCond);
                object3 = StringHelper.format((String)"PSDEDQCOND#%1$s", (Object)pSDEDQCond.getPSDEDQCondId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    pSDEDQCond22 = object2.next();
                    object = pSDEDQCondService.getModelV2ResScope((IEntity)pSDEDQCond22);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEDQCond)PSModelV2Helper.toJSONObject((IEntity)pSDEDQCond22, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSDEDQCondService.getModelV2Name(false);
                object3 = objectNode.putArray(((String)object4).toLowerCase());
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
                for (PSDEDQCond pSDEDQCond22 : arrayList) {
                    object = new PSDEDQCond();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)pSDEDQCond22, false);
                    ((PSDEDQCondBase)object).remove("ordervalue");
                    object3.add((JsonNode)pSDEDQCondService.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSDEDQCond, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDEDQCond pSDEDQCond) throws Exception {
        PSDEDQCondService pSDEDQCondService = (PSDEDQCondService)ServiceGlobal.getService(PSDEDQCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDQCond> arrayList = pSDEDQCondService.selectByPPSDEDQCond(pSDEDQCond);
        String string = StringHelper.format((String)"PSDEDQCOND#%1$s", (Object)pSDEDQCond.getPSDEDQCondId());
        for (PSDEDQCond pSDEDQCond2 : arrayList) {
            String string2 = pSDEDQCondService.getModelV2ResScope((IEntity)pSDEDQCond2);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSDEDQCondService.emptyModelV2(pSDEDQCond2);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSDEDQCond.getPSDEDQCondId());
        pSDEDQCondService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSDEDQCondService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEDQCOND WHERE PPSDEDQCONDID = ?", sqlParamList);
        super.onEmptyModelV2(pSDEDQCond);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSDEDQCondService pSDEDQCondService = (PSDEDQCondService)ServiceGlobal.getService(PSDEDQCondService.class, (SessionFactory)this.getSessionFactory());
        if (pSDEDQCondService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDEDQCond pSDEDQCond, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSDEDQCond pSDEDQCond2 = new PSDEDQCond();
        pSDEDQCond2.set("PPSDEDQCONDID", pSDEDQCond.getPSDEDQCondId());
        PSDEDQCondService pSDEDQCondService = (PSDEDQCondService)ServiceGlobal.getService(PSDEDQCondService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSDEDQCondService.getModelV2Entity(pSDEDQCond2, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDEDQCond, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDEDQCond pSDEDQCond, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSDEDQCondService pSDEDQCondService = (PSDEDQCondService)ServiceGlobal.getService(PSDEDQCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSDEDQCondService.getModelV2Name(null, false);
        int n2 = 0;
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSDEDQCond pSDEDQCond2 = new PSDEDQCond();
                pSDEDQCond2.setPPSDEDQCondId(pSDEDQCond.getPSDEDQCondId());
                pSDEDQCond2.setPPSDEDQCondName(pSDEDQCond.getPSDEDQCondName());
                pSDEDQCond2.setOrderValue(n2 += 10);
                pSDEDQCondService.compileModelV2(pSDEDQCond2, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSDEDQCond pSDEDQCond3 = new PSDEDQCond();
                    pSDEDQCond3.setPPSDEDQCondId(pSDEDQCond.getPSDEDQCondId());
                    pSDEDQCond3.setPPSDEDQCondName(pSDEDQCond.getPSDEDQCondName());
                    pSDEDQCondService.compileModelV2(pSDEDQCond3, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSDEDQCond, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDEDQCond pSDEDQCond, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        Object var5_5 = null;
        return super.onPasteFile(pSDEDQCond, pSMOSFile, string, iPSMOSFileAction);
    }

    @Override
    protected void onFillPasteHelps(PSDEDQCond pSDEDQCond, List<PSHelpSection> list) throws Exception {
        super.onFillPasteHelps(pSDEDQCond, list);
    }
}

