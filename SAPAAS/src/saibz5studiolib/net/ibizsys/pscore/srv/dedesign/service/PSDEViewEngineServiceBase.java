/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.SimpleEntity
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
package net.ibizsys.pscore.srv.dedesign.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
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
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
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
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPluginBase;
import net.ibizsys.pscore.srv.config.entity.PSUIEngineType;
import net.ibizsys.pscore.srv.config.entity.PSUIEngineTypeBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEViewEngineDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEViewEngineDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewCtrl;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewCtrlBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewEngine;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewLogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewLogicBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEViewEngineServiceBase
extends PSCoreSysServiceBase<PSDEViewEngine> {
    private static final Log log = LogFactory.getLog(PSDEViewEngineServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEViewEngineDEModel pSDEViewEngineDEModel;
    private PSDEViewEngineDAO pSDEViewEngineDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEViewEngineService";
    }

    public PSDEViewEngineDEModel getPSDEViewEngineDEModel() {
        if (this.pSDEViewEngineDEModel == null) {
            try {
                this.pSDEViewEngineDEModel = (PSDEViewEngineDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEViewEngineDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEViewEngineDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEViewEngineDEModel();
    }

    public PSDEViewEngineDAO getPSDEViewEngineDAO() {
        if (this.pSDEViewEngineDAO == null) {
            try {
                this.pSDEViewEngineDAO = (PSDEViewEngineDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEViewEngineDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEViewEngineDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEViewEngineDAO();
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

    protected void onFillParentInfo(PSDEViewEngine pSDEViewEngine, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWENGINE_PSDEVIEWBASE_PSDEVIEWBASEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewBase);
            } else {
                iService.get(pSDEViewBase);
            }
            this.onFillParentInfo_PSDEViewBase(pSDEViewEngine, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWENGINE_PSDEVIEWCTRL_NO2PSDEVIEWCTRLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService", (SessionFactory)this.getSessionFactory());
            PSDEViewCtrl pSDEViewCtrl = (PSDEViewCtrl)iService.getDEModel().createEntity();
            pSDEViewCtrl.set("PSDEVIEWCTRLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewCtrl);
            } else {
                iService.get(pSDEViewCtrl);
            }
            this.onFillParentInfo_No2PSDEViewCtrl(pSDEViewEngine, pSDEViewCtrl);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWENGINE_PSDEVIEWCTRL_NO3PSDEVIEWCTRLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService", (SessionFactory)this.getSessionFactory());
            PSDEViewCtrl pSDEViewCtrl = (PSDEViewCtrl)iService.getDEModel().createEntity();
            pSDEViewCtrl.set("PSDEVIEWCTRLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewCtrl);
            } else {
                iService.get(pSDEViewCtrl);
            }
            this.onFillParentInfo_No3PSDEViewCtrl(pSDEViewEngine, pSDEViewCtrl);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWENGINE_PSDEVIEWCTRL_NO4PSDEVIEWCTRLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService", (SessionFactory)this.getSessionFactory());
            PSDEViewCtrl pSDEViewCtrl = (PSDEViewCtrl)iService.getDEModel().createEntity();
            pSDEViewCtrl.set("PSDEVIEWCTRLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewCtrl);
            } else {
                iService.get(pSDEViewCtrl);
            }
            this.onFillParentInfo_No4PSDEViewCtrl(pSDEViewEngine, pSDEViewCtrl);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWENGINE_PSDEVIEWCTRL_PSDEVIEWCTRLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService", (SessionFactory)this.getSessionFactory());
            PSDEViewCtrl pSDEViewCtrl = (PSDEViewCtrl)iService.getDEModel().createEntity();
            pSDEViewCtrl.set("PSDEVIEWCTRLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewCtrl);
            } else {
                iService.get(pSDEViewCtrl);
            }
            this.onFillParentInfo_PSDEViewCtrl(pSDEViewEngine, pSDEViewCtrl);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWENGINE_PSDEVIEWLOGIC_NO2PSDEVIEWLOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewLogicService", (SessionFactory)this.getSessionFactory());
            PSDEViewLogic pSDEViewLogic = (PSDEViewLogic)iService.getDEModel().createEntity();
            pSDEViewLogic.set("PSDEVIEWLOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewLogic);
            } else {
                iService.get(pSDEViewLogic);
            }
            this.onFillParentInfo_No2PSDEViewLogic(pSDEViewEngine, pSDEViewLogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWENGINE_PSDEVIEWLOGIC_NO3PSDEVIEWLOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewLogicService", (SessionFactory)this.getSessionFactory());
            PSDEViewLogic pSDEViewLogic = (PSDEViewLogic)iService.getDEModel().createEntity();
            pSDEViewLogic.set("PSDEVIEWLOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewLogic);
            } else {
                iService.get(pSDEViewLogic);
            }
            this.onFillParentInfo_No3PSDEViewLogic(pSDEViewEngine, pSDEViewLogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWENGINE_PSDEVIEWLOGIC_NO4PSDEVIEWLOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewLogicService", (SessionFactory)this.getSessionFactory());
            PSDEViewLogic pSDEViewLogic = (PSDEViewLogic)iService.getDEModel().createEntity();
            pSDEViewLogic.set("PSDEVIEWLOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewLogic);
            } else {
                iService.get(pSDEViewLogic);
            }
            this.onFillParentInfo_No4PSDEViewLogic(pSDEViewEngine, pSDEViewLogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWENGINE_PSDEVIEWLOGIC_PSDEVIEWLOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewLogicService", (SessionFactory)this.getSessionFactory());
            PSDEViewLogic pSDEViewLogic = (PSDEViewLogic)iService.getDEModel().createEntity();
            pSDEViewLogic.set("PSDEVIEWLOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewLogic);
            } else {
                iService.get(pSDEViewLogic);
            }
            this.onFillParentInfo_PSDEViewLogic(pSDEViewEngine, pSDEViewLogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWENGINE_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPFPlugin);
            } else {
                iService.get(pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSDEViewEngine, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWENGINE_PSUIENGINETYPE_PSUIENGINETYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSUIEngineTypeService", (SessionFactory)this.getSessionFactory());
            PSUIEngineType pSUIEngineType = (PSUIEngineType)iService.getDEModel().createEntity();
            pSUIEngineType.set("PSUIENGINETYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSUIEngineType);
            } else {
                iService.get(pSUIEngineType);
            }
            this.onFillParentInfo_PSUIEngineType(pSDEViewEngine, pSUIEngineType);
            return;
        }
        super.onFillParentInfo(pSDEViewEngine, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDEViewBase(PSDEViewEngine pSDEViewEngine, PSDEViewBase pSDEViewBase) throws Exception {
        pSDEViewEngine.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
        pSDEViewEngine.setPSDEViewBaseName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_No2PSDEViewCtrl(PSDEViewEngine pSDEViewEngine, PSDEViewCtrl pSDEViewCtrl) throws Exception {
        pSDEViewEngine.setNo2PSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
        pSDEViewEngine.setNo2PSDEViewCtrlName(pSDEViewCtrl.getPSDEViewCtrlName());
    }

    protected void onFillParentInfo_No3PSDEViewCtrl(PSDEViewEngine pSDEViewEngine, PSDEViewCtrl pSDEViewCtrl) throws Exception {
        pSDEViewEngine.setNo3PSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
        pSDEViewEngine.setNo3PSDEViewCtrlName(pSDEViewCtrl.getPSDEViewCtrlName());
    }

    protected void onFillParentInfo_No4PSDEViewCtrl(PSDEViewEngine pSDEViewEngine, PSDEViewCtrl pSDEViewCtrl) throws Exception {
        pSDEViewEngine.setNo4PSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
        pSDEViewEngine.setNo4PSDEViewCtrlName(pSDEViewCtrl.getPSDEViewCtrlName());
    }

    protected void onFillParentInfo_PSDEViewCtrl(PSDEViewEngine pSDEViewEngine, PSDEViewCtrl pSDEViewCtrl) throws Exception {
        pSDEViewEngine.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
        pSDEViewEngine.setPSDEViewCtrlName(pSDEViewCtrl.getPSDEViewCtrlName());
    }

    protected void onFillParentInfo_No2PSDEViewLogic(PSDEViewEngine pSDEViewEngine, PSDEViewLogic pSDEViewLogic) throws Exception {
        pSDEViewEngine.setNo2PSDEViewLogicId(pSDEViewLogic.getPSDEViewLogicId());
        pSDEViewEngine.setNo2PSDEViewLogicName(pSDEViewLogic.getPSDEViewLogicName());
    }

    protected void onFillParentInfo_No3PSDEViewLogic(PSDEViewEngine pSDEViewEngine, PSDEViewLogic pSDEViewLogic) throws Exception {
        pSDEViewEngine.setNo3PSDEViewLogicId(pSDEViewLogic.getPSDEViewLogicId());
        pSDEViewEngine.setNo3PSDEViewLogicName(pSDEViewLogic.getPSDEViewLogicName());
    }

    protected void onFillParentInfo_No4PSDEViewLogic(PSDEViewEngine pSDEViewEngine, PSDEViewLogic pSDEViewLogic) throws Exception {
        pSDEViewEngine.setNo4PSDEViewLogicId(pSDEViewLogic.getPSDEViewLogicId());
        pSDEViewEngine.setNo4PSDEViewLogicName(pSDEViewLogic.getPSDEViewLogicName());
    }

    protected void onFillParentInfo_PSDEViewLogic(PSDEViewEngine pSDEViewEngine, PSDEViewLogic pSDEViewLogic) throws Exception {
        pSDEViewEngine.setPSDEViewLogicId(pSDEViewLogic.getPSDEViewLogicId());
        pSDEViewEngine.setPSDEViewLogicName(pSDEViewLogic.getPSDEViewLogicName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSDEViewEngine pSDEViewEngine, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSDEViewEngine.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSDEViewEngine.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSUIEngineType(PSDEViewEngine pSDEViewEngine, PSUIEngineType pSUIEngineType) throws Exception {
        pSDEViewEngine.setPSUIEngineTypeId(pSUIEngineType.getPSUIEngineTypeId());
        pSDEViewEngine.setPSUIEngineTypeName(pSUIEngineType.getPSUIEngineTypeName());
    }

    protected void onFillEntityFullInfo(PSDEViewEngine pSDEViewEngine, boolean bl) throws Exception {
        if (bl && pSDEViewEngine.getValidFlag() == null) {
            pSDEViewEngine.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSDEViewEngine, bl);
        this.onFillEntityFullInfo_PSDEViewBase(pSDEViewEngine, bl);
        this.onFillEntityFullInfo_No2PSDEViewCtrl(pSDEViewEngine, bl);
        this.onFillEntityFullInfo_No3PSDEViewCtrl(pSDEViewEngine, bl);
        this.onFillEntityFullInfo_No4PSDEViewCtrl(pSDEViewEngine, bl);
        this.onFillEntityFullInfo_PSDEViewCtrl(pSDEViewEngine, bl);
        this.onFillEntityFullInfo_No2PSDEViewLogic(pSDEViewEngine, bl);
        this.onFillEntityFullInfo_No3PSDEViewLogic(pSDEViewEngine, bl);
        this.onFillEntityFullInfo_No4PSDEViewLogic(pSDEViewEngine, bl);
        this.onFillEntityFullInfo_PSDEViewLogic(pSDEViewEngine, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSDEViewEngine, bl);
        this.onFillEntityFullInfo_PSUIEngineType(pSDEViewEngine, bl);
    }

    protected void onFillEntityFullInfo_PSDEViewBase(PSDEViewEngine pSDEViewEngine, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_No2PSDEViewCtrl(PSDEViewEngine pSDEViewEngine, boolean bl) throws Exception {
        if (pSDEViewEngine.isNo2PSDEViewCtrlIdDirty()) {
            if (pSDEViewEngine.getNo2PSDEViewCtrlId() != null) {
                if (pSDEViewEngine.getNo2PSDEViewCtrlId() == null || pSDEViewEngine.getNo2PSDEViewCtrlName() == null) {
                    PSDEViewCtrl pSDEViewCtrl = pSDEViewEngine.getNo2PSDEViewCtrl();
                    pSDEViewEngine.setNo2PSDEViewCtrlName(pSDEViewCtrl.getPSDEViewCtrlName());
                }
            } else {
                pSDEViewEngine.setNo2PSDEViewCtrlName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_No3PSDEViewCtrl(PSDEViewEngine pSDEViewEngine, boolean bl) throws Exception {
        if (pSDEViewEngine.isNo3PSDEViewCtrlIdDirty()) {
            if (pSDEViewEngine.getNo3PSDEViewCtrlId() != null) {
                if (pSDEViewEngine.getNo3PSDEViewCtrlId() == null || pSDEViewEngine.getNo3PSDEViewCtrlName() == null) {
                    PSDEViewCtrl pSDEViewCtrl = pSDEViewEngine.getNo3PSDEViewCtrl();
                    pSDEViewEngine.setNo3PSDEViewCtrlName(pSDEViewCtrl.getPSDEViewCtrlName());
                }
            } else {
                pSDEViewEngine.setNo3PSDEViewCtrlName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_No4PSDEViewCtrl(PSDEViewEngine pSDEViewEngine, boolean bl) throws Exception {
        if (pSDEViewEngine.isNo4PSDEViewCtrlIdDirty()) {
            if (pSDEViewEngine.getNo4PSDEViewCtrlId() != null) {
                if (pSDEViewEngine.getNo4PSDEViewCtrlId() == null || pSDEViewEngine.getNo4PSDEViewCtrlName() == null) {
                    PSDEViewCtrl pSDEViewCtrl = pSDEViewEngine.getNo4PSDEViewCtrl();
                    pSDEViewEngine.setNo4PSDEViewCtrlName(pSDEViewCtrl.getPSDEViewCtrlName());
                }
            } else {
                pSDEViewEngine.setNo4PSDEViewCtrlName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEViewCtrl(PSDEViewEngine pSDEViewEngine, boolean bl) throws Exception {
        if (pSDEViewEngine.isPSDEViewCtrlIdDirty()) {
            if (pSDEViewEngine.getPSDEViewCtrlId() != null) {
                if (pSDEViewEngine.getPSDEViewCtrlId() == null || pSDEViewEngine.getPSDEViewCtrlName() == null) {
                    PSDEViewCtrl pSDEViewCtrl = pSDEViewEngine.getPSDEViewCtrl();
                    pSDEViewEngine.setPSDEViewCtrlName(pSDEViewCtrl.getPSDEViewCtrlName());
                }
            } else {
                pSDEViewEngine.setPSDEViewCtrlName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_No2PSDEViewLogic(PSDEViewEngine pSDEViewEngine, boolean bl) throws Exception {
        if (pSDEViewEngine.isNo2PSDEViewLogicIdDirty()) {
            if (pSDEViewEngine.getNo2PSDEViewLogicId() != null) {
                if (pSDEViewEngine.getNo2PSDEViewLogicId() == null || pSDEViewEngine.getNo2PSDEViewLogicName() == null) {
                    PSDEViewLogic pSDEViewLogic = pSDEViewEngine.getNo2PSDEViewLogic();
                    pSDEViewEngine.setNo2PSDEViewLogicName(pSDEViewLogic.getPSDEViewLogicName());
                }
            } else {
                pSDEViewEngine.setNo2PSDEViewLogicName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_No3PSDEViewLogic(PSDEViewEngine pSDEViewEngine, boolean bl) throws Exception {
        if (pSDEViewEngine.isNo3PSDEViewLogicIdDirty()) {
            if (pSDEViewEngine.getNo3PSDEViewLogicId() != null) {
                if (pSDEViewEngine.getNo3PSDEViewLogicId() == null || pSDEViewEngine.getNo3PSDEViewLogicName() == null) {
                    PSDEViewLogic pSDEViewLogic = pSDEViewEngine.getNo3PSDEViewLogic();
                    pSDEViewEngine.setNo3PSDEViewLogicName(pSDEViewLogic.getPSDEViewLogicName());
                }
            } else {
                pSDEViewEngine.setNo3PSDEViewLogicName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_No4PSDEViewLogic(PSDEViewEngine pSDEViewEngine, boolean bl) throws Exception {
        if (pSDEViewEngine.isNo4PSDEViewLogicIdDirty()) {
            if (pSDEViewEngine.getNo4PSDEViewLogicId() != null) {
                if (pSDEViewEngine.getNo4PSDEViewLogicId() == null || pSDEViewEngine.getNo4PSDEViewLogicName() == null) {
                    PSDEViewLogic pSDEViewLogic = pSDEViewEngine.getNo4PSDEViewLogic();
                    pSDEViewEngine.setNo4PSDEViewLogicName(pSDEViewLogic.getPSDEViewLogicName());
                }
            } else {
                pSDEViewEngine.setNo4PSDEViewLogicName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEViewLogic(PSDEViewEngine pSDEViewEngine, boolean bl) throws Exception {
        if (pSDEViewEngine.isPSDEViewLogicIdDirty()) {
            if (pSDEViewEngine.getPSDEViewLogicId() != null) {
                if (pSDEViewEngine.getPSDEViewLogicId() == null || pSDEViewEngine.getPSDEViewLogicName() == null) {
                    PSDEViewLogic pSDEViewLogic = pSDEViewEngine.getPSDEViewLogic();
                    pSDEViewEngine.setPSDEViewLogicName(pSDEViewLogic.getPSDEViewLogicName());
                }
            } else {
                pSDEViewEngine.setPSDEViewLogicName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSDEViewEngine pSDEViewEngine, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSUIEngineType(PSDEViewEngine pSDEViewEngine, boolean bl) throws Exception {
        if (pSDEViewEngine.isPSUIEngineTypeIdDirty()) {
            if (pSDEViewEngine.getPSUIEngineTypeId() != null) {
                if (pSDEViewEngine.getPSUIEngineTypeId() == null || pSDEViewEngine.getPSUIEngineTypeName() == null) {
                    PSUIEngineType pSUIEngineType = pSDEViewEngine.getPSUIEngineType();
                    pSDEViewEngine.setPSUIEngineTypeName(pSUIEngineType.getPSUIEngineTypeName());
                }
            } else {
                pSDEViewEngine.setPSUIEngineTypeName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDEViewEngine pSDEViewEngine, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEViewEngine, bl);
    }

    public ArrayList<PSDEViewEngine> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByPSDEViewBase(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSDEViewEngine> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByPSDEViewBase(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSDEViewEngine> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVIEWBASEID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEViewBaseCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEViewBaseCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewEngine> selectTempByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectTempByPSDEViewBase(pSDEViewBaseBase, "");
    }

    public ArrayList<PSDEViewEngine> selectTempByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVIEWBASEID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEViewBaseCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEViewBaseCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewEngine> selectByNo2PSDEViewCtrl(PSDEViewCtrlBase pSDEViewCtrlBase) throws Exception {
        return this.selectByNo2PSDEViewCtrl(pSDEViewCtrlBase, "", -1);
    }

    public ArrayList<PSDEViewEngine> selectByNo2PSDEViewCtrl(PSDEViewCtrlBase pSDEViewCtrlBase, String string) throws Exception {
        return this.selectByNo2PSDEViewCtrl(pSDEViewCtrlBase, string, -1);
    }

    public ArrayList<PSDEViewEngine> selectByNo2PSDEViewCtrl(PSDEViewCtrlBase pSDEViewCtrlBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NO2PSDEVIEWCTRLID", (Object)pSDEViewCtrlBase.getPSDEViewCtrlId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByNo2PSDEViewCtrlCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByNo2PSDEViewCtrlCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewEngine> selectTempByNo2PSDEViewCtrl(PSDEViewCtrlBase pSDEViewCtrlBase) throws Exception {
        return this.selectTempByNo2PSDEViewCtrl(pSDEViewCtrlBase, "");
    }

    public ArrayList<PSDEViewEngine> selectTempByNo2PSDEViewCtrl(PSDEViewCtrlBase pSDEViewCtrlBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NO2PSDEVIEWCTRLID", (Object)pSDEViewCtrlBase.getPSDEViewCtrlId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByNo2PSDEViewCtrlCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByNo2PSDEViewCtrlCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewEngine> selectByNo3PSDEViewCtrl(PSDEViewCtrlBase pSDEViewCtrlBase) throws Exception {
        return this.selectByNo3PSDEViewCtrl(pSDEViewCtrlBase, "", -1);
    }

    public ArrayList<PSDEViewEngine> selectByNo3PSDEViewCtrl(PSDEViewCtrlBase pSDEViewCtrlBase, String string) throws Exception {
        return this.selectByNo3PSDEViewCtrl(pSDEViewCtrlBase, string, -1);
    }

    public ArrayList<PSDEViewEngine> selectByNo3PSDEViewCtrl(PSDEViewCtrlBase pSDEViewCtrlBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NO3PSDEVIEWCTRLID", (Object)pSDEViewCtrlBase.getPSDEViewCtrlId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByNo3PSDEViewCtrlCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByNo3PSDEViewCtrlCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewEngine> selectTempByNo3PSDEViewCtrl(PSDEViewCtrlBase pSDEViewCtrlBase) throws Exception {
        return this.selectTempByNo3PSDEViewCtrl(pSDEViewCtrlBase, "");
    }

    public ArrayList<PSDEViewEngine> selectTempByNo3PSDEViewCtrl(PSDEViewCtrlBase pSDEViewCtrlBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NO3PSDEVIEWCTRLID", (Object)pSDEViewCtrlBase.getPSDEViewCtrlId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByNo3PSDEViewCtrlCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByNo3PSDEViewCtrlCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewEngine> selectByNo4PSDEViewCtrl(PSDEViewCtrlBase pSDEViewCtrlBase) throws Exception {
        return this.selectByNo4PSDEViewCtrl(pSDEViewCtrlBase, "", -1);
    }

    public ArrayList<PSDEViewEngine> selectByNo4PSDEViewCtrl(PSDEViewCtrlBase pSDEViewCtrlBase, String string) throws Exception {
        return this.selectByNo4PSDEViewCtrl(pSDEViewCtrlBase, string, -1);
    }

    public ArrayList<PSDEViewEngine> selectByNo4PSDEViewCtrl(PSDEViewCtrlBase pSDEViewCtrlBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NO4PSDEVIEWCTRLID", (Object)pSDEViewCtrlBase.getPSDEViewCtrlId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByNo4PSDEViewCtrlCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByNo4PSDEViewCtrlCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewEngine> selectTempByNo4PSDEViewCtrl(PSDEViewCtrlBase pSDEViewCtrlBase) throws Exception {
        return this.selectTempByNo4PSDEViewCtrl(pSDEViewCtrlBase, "");
    }

    public ArrayList<PSDEViewEngine> selectTempByNo4PSDEViewCtrl(PSDEViewCtrlBase pSDEViewCtrlBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NO4PSDEVIEWCTRLID", (Object)pSDEViewCtrlBase.getPSDEViewCtrlId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByNo4PSDEViewCtrlCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByNo4PSDEViewCtrlCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewEngine> selectByPSDEViewCtrl(PSDEViewCtrlBase pSDEViewCtrlBase) throws Exception {
        return this.selectByPSDEViewCtrl(pSDEViewCtrlBase, "", -1);
    }

    public ArrayList<PSDEViewEngine> selectByPSDEViewCtrl(PSDEViewCtrlBase pSDEViewCtrlBase, String string) throws Exception {
        return this.selectByPSDEViewCtrl(pSDEViewCtrlBase, string, -1);
    }

    public ArrayList<PSDEViewEngine> selectByPSDEViewCtrl(PSDEViewCtrlBase pSDEViewCtrlBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVIEWCTRLID", (Object)pSDEViewCtrlBase.getPSDEViewCtrlId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEViewCtrlCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEViewCtrlCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewEngine> selectTempByPSDEViewCtrl(PSDEViewCtrlBase pSDEViewCtrlBase) throws Exception {
        return this.selectTempByPSDEViewCtrl(pSDEViewCtrlBase, "");
    }

    public ArrayList<PSDEViewEngine> selectTempByPSDEViewCtrl(PSDEViewCtrlBase pSDEViewCtrlBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVIEWCTRLID", (Object)pSDEViewCtrlBase.getPSDEViewCtrlId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEViewCtrlCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEViewCtrlCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewEngine> selectByNo2PSDEViewLogic(PSDEViewLogicBase pSDEViewLogicBase) throws Exception {
        return this.selectByNo2PSDEViewLogic(pSDEViewLogicBase, "", -1);
    }

    public ArrayList<PSDEViewEngine> selectByNo2PSDEViewLogic(PSDEViewLogicBase pSDEViewLogicBase, String string) throws Exception {
        return this.selectByNo2PSDEViewLogic(pSDEViewLogicBase, string, -1);
    }

    public ArrayList<PSDEViewEngine> selectByNo2PSDEViewLogic(PSDEViewLogicBase pSDEViewLogicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NO2PSDEVIEWLOGICID", (Object)pSDEViewLogicBase.getPSDEViewLogicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByNo2PSDEViewLogicCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByNo2PSDEViewLogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewEngine> selectTempByNo2PSDEViewLogic(PSDEViewLogicBase pSDEViewLogicBase) throws Exception {
        return this.selectTempByNo2PSDEViewLogic(pSDEViewLogicBase, "");
    }

    public ArrayList<PSDEViewEngine> selectTempByNo2PSDEViewLogic(PSDEViewLogicBase pSDEViewLogicBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NO2PSDEVIEWLOGICID", (Object)pSDEViewLogicBase.getPSDEViewLogicId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByNo2PSDEViewLogicCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByNo2PSDEViewLogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewEngine> selectByNo3PSDEViewLogic(PSDEViewLogicBase pSDEViewLogicBase) throws Exception {
        return this.selectByNo3PSDEViewLogic(pSDEViewLogicBase, "", -1);
    }

    public ArrayList<PSDEViewEngine> selectByNo3PSDEViewLogic(PSDEViewLogicBase pSDEViewLogicBase, String string) throws Exception {
        return this.selectByNo3PSDEViewLogic(pSDEViewLogicBase, string, -1);
    }

    public ArrayList<PSDEViewEngine> selectByNo3PSDEViewLogic(PSDEViewLogicBase pSDEViewLogicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NO3PSDEVIEWLOGICID", (Object)pSDEViewLogicBase.getPSDEViewLogicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByNo3PSDEViewLogicCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByNo3PSDEViewLogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewEngine> selectTempByNo3PSDEViewLogic(PSDEViewLogicBase pSDEViewLogicBase) throws Exception {
        return this.selectTempByNo3PSDEViewLogic(pSDEViewLogicBase, "");
    }

    public ArrayList<PSDEViewEngine> selectTempByNo3PSDEViewLogic(PSDEViewLogicBase pSDEViewLogicBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NO3PSDEVIEWLOGICID", (Object)pSDEViewLogicBase.getPSDEViewLogicId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByNo3PSDEViewLogicCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByNo3PSDEViewLogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewEngine> selectByNo4PSDEViewLogic(PSDEViewLogicBase pSDEViewLogicBase) throws Exception {
        return this.selectByNo4PSDEViewLogic(pSDEViewLogicBase, "", -1);
    }

    public ArrayList<PSDEViewEngine> selectByNo4PSDEViewLogic(PSDEViewLogicBase pSDEViewLogicBase, String string) throws Exception {
        return this.selectByNo4PSDEViewLogic(pSDEViewLogicBase, string, -1);
    }

    public ArrayList<PSDEViewEngine> selectByNo4PSDEViewLogic(PSDEViewLogicBase pSDEViewLogicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NO4PSDEVIEWLOGICID", (Object)pSDEViewLogicBase.getPSDEViewLogicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByNo4PSDEViewLogicCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByNo4PSDEViewLogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewEngine> selectTempByNo4PSDEViewLogic(PSDEViewLogicBase pSDEViewLogicBase) throws Exception {
        return this.selectTempByNo4PSDEViewLogic(pSDEViewLogicBase, "");
    }

    public ArrayList<PSDEViewEngine> selectTempByNo4PSDEViewLogic(PSDEViewLogicBase pSDEViewLogicBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NO4PSDEVIEWLOGICID", (Object)pSDEViewLogicBase.getPSDEViewLogicId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByNo4PSDEViewLogicCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByNo4PSDEViewLogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewEngine> selectByPSDEViewLogic(PSDEViewLogicBase pSDEViewLogicBase) throws Exception {
        return this.selectByPSDEViewLogic(pSDEViewLogicBase, "", -1);
    }

    public ArrayList<PSDEViewEngine> selectByPSDEViewLogic(PSDEViewLogicBase pSDEViewLogicBase, String string) throws Exception {
        return this.selectByPSDEViewLogic(pSDEViewLogicBase, string, -1);
    }

    public ArrayList<PSDEViewEngine> selectByPSDEViewLogic(PSDEViewLogicBase pSDEViewLogicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVIEWLOGICID", (Object)pSDEViewLogicBase.getPSDEViewLogicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEViewLogicCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEViewLogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewEngine> selectTempByPSDEViewLogic(PSDEViewLogicBase pSDEViewLogicBase) throws Exception {
        return this.selectTempByPSDEViewLogic(pSDEViewLogicBase, "");
    }

    public ArrayList<PSDEViewEngine> selectTempByPSDEViewLogic(PSDEViewLogicBase pSDEViewLogicBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVIEWLOGICID", (Object)pSDEViewLogicBase.getPSDEViewLogicId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEViewLogicCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEViewLogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewEngine> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSDEViewEngine> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSDEViewEngine> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSPFPLUGINID", (Object)pSSysPFPluginBase.getPSSysPFPluginId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysPFPluginCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysPFPluginCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewEngine> selectByPSUIEngineType(PSUIEngineTypeBase pSUIEngineTypeBase) throws Exception {
        return this.selectByPSUIEngineType(pSUIEngineTypeBase, "", -1);
    }

    public ArrayList<PSDEViewEngine> selectByPSUIEngineType(PSUIEngineTypeBase pSUIEngineTypeBase, String string) throws Exception {
        return this.selectByPSUIEngineType(pSUIEngineTypeBase, string, -1);
    }

    public ArrayList<PSDEViewEngine> selectByPSUIEngineType(PSUIEngineTypeBase pSUIEngineTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSUIENGINETYPEID", (Object)pSUIEngineTypeBase.getPSUIEngineTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSUIEngineTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSUIEngineTypeCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    public void resetPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectByPSDEViewBase(pSDEViewBase);
        for (PSDEViewEngine pSDEViewEngine : arrayList) {
            PSDEViewEngine pSDEViewEngine2 = (PSDEViewEngine)this.getDEModel().createEntity();
            pSDEViewEngine2.setPSDEViewEngineId(pSDEViewEngine.getPSDEViewEngineId());
            pSDEViewEngine2.setPSDEViewBaseId(null);
            this.update(pSDEViewEngine2);
        }
    }

    public void resetTempPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectTempByPSDEViewBase(pSDEViewBase);
        for (PSDEViewEngine pSDEViewEngine : arrayList) {
            PSDEViewEngine pSDEViewEngine2 = (PSDEViewEngine)this.getDEModel().createEntity();
            pSDEViewEngine2.setPSDEViewEngineId(pSDEViewEngine.getPSDEViewEngineId());
            pSDEViewEngine2.setPSDEViewBaseId(null);
            this.updateTemp(pSDEViewEngine2);
        }
    }

    public void removeByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewEngineServiceBase.this.onBeforeRemoveByPSDEViewBase(pSDEViewBase2);
                PSDEViewEngineServiceBase.this.internalRemoveByPSDEViewBase(pSDEViewBase2);
                PSDEViewEngineServiceBase.this.onAfterRemoveByPSDEViewBase(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectByPSDEViewBase(pSDEViewBase);
        this.onBeforeRemoveByPSDEViewBase(pSDEViewBase, arrayList);
        for (PSDEViewEngine pSDEViewEngine : arrayList) {
            this.remove(pSDEViewEngine);
        }
        this.onAfterRemoveByPSDEViewBase(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSDEViewEngine> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSDEViewEngine> arrayList) throws Exception {
    }

    public void testRemoveByNo2PSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectByNo2PSDEViewCtrl(pSDEViewCtrl, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWCTRL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEViewCtrl);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWENGINE_PSDEVIEWCTRL_NO2PSDEVIEWCTRLID", "", iDataEntityModel.getName(), "PSDEVIEWENGINE", iDataEntityModel.getDataInfo(pSDEViewCtrl), arrayList.get(0)));
        }
    }

    public void resetNo2PSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectByNo2PSDEViewCtrl(pSDEViewCtrl);
        for (PSDEViewEngine pSDEViewEngine : arrayList) {
            PSDEViewEngine pSDEViewEngine2 = (PSDEViewEngine)this.getDEModel().createEntity();
            pSDEViewEngine2.setPSDEViewEngineId(pSDEViewEngine.getPSDEViewEngineId());
            pSDEViewEngine2.setNo2PSDEViewCtrlId(null);
            this.update(pSDEViewEngine2);
        }
    }

    public void resetTempNo2PSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectTempByNo2PSDEViewCtrl(pSDEViewCtrl);
        for (PSDEViewEngine pSDEViewEngine : arrayList) {
            PSDEViewEngine pSDEViewEngine2 = (PSDEViewEngine)this.getDEModel().createEntity();
            pSDEViewEngine2.setPSDEViewEngineId(pSDEViewEngine.getPSDEViewEngineId());
            pSDEViewEngine2.setNo2PSDEViewCtrlId(null);
            this.updateTemp(pSDEViewEngine2);
        }
    }

    public void removeByNo2PSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        final PSDEViewCtrl pSDEViewCtrl2 = pSDEViewCtrl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewEngineServiceBase.this.onBeforeRemoveByNo2PSDEViewCtrl(pSDEViewCtrl2);
                PSDEViewEngineServiceBase.this.internalRemoveByNo2PSDEViewCtrl(pSDEViewCtrl2);
                PSDEViewEngineServiceBase.this.onAfterRemoveByNo2PSDEViewCtrl(pSDEViewCtrl2);
            }
        });
    }

    protected void onBeforeRemoveByNo2PSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
    }

    protected void internalRemoveByNo2PSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectByNo2PSDEViewCtrl(pSDEViewCtrl);
        this.onBeforeRemoveByNo2PSDEViewCtrl(pSDEViewCtrl, arrayList);
        for (PSDEViewEngine pSDEViewEngine : arrayList) {
            this.remove(pSDEViewEngine);
        }
        this.onAfterRemoveByNo2PSDEViewCtrl(pSDEViewCtrl, arrayList);
    }

    protected void onAfterRemoveByNo2PSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
    }

    protected void onBeforeRemoveByNo2PSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl, ArrayList<PSDEViewEngine> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNo2PSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl, ArrayList<PSDEViewEngine> arrayList) throws Exception {
    }

    public void testRemoveByNo3PSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectByNo3PSDEViewCtrl(pSDEViewCtrl, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWCTRL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEViewCtrl);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWENGINE_PSDEVIEWCTRL_NO3PSDEVIEWCTRLID", "", iDataEntityModel.getName(), "PSDEVIEWENGINE", iDataEntityModel.getDataInfo(pSDEViewCtrl), arrayList.get(0)));
        }
    }

    public void resetNo3PSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectByNo3PSDEViewCtrl(pSDEViewCtrl);
        for (PSDEViewEngine pSDEViewEngine : arrayList) {
            PSDEViewEngine pSDEViewEngine2 = (PSDEViewEngine)this.getDEModel().createEntity();
            pSDEViewEngine2.setPSDEViewEngineId(pSDEViewEngine.getPSDEViewEngineId());
            pSDEViewEngine2.setNo3PSDEViewCtrlId(null);
            this.update(pSDEViewEngine2);
        }
    }

    public void resetTempNo3PSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectTempByNo3PSDEViewCtrl(pSDEViewCtrl);
        for (PSDEViewEngine pSDEViewEngine : arrayList) {
            PSDEViewEngine pSDEViewEngine2 = (PSDEViewEngine)this.getDEModel().createEntity();
            pSDEViewEngine2.setPSDEViewEngineId(pSDEViewEngine.getPSDEViewEngineId());
            pSDEViewEngine2.setNo3PSDEViewCtrlId(null);
            this.updateTemp(pSDEViewEngine2);
        }
    }

    public void removeByNo3PSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        final PSDEViewCtrl pSDEViewCtrl2 = pSDEViewCtrl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewEngineServiceBase.this.onBeforeRemoveByNo3PSDEViewCtrl(pSDEViewCtrl2);
                PSDEViewEngineServiceBase.this.internalRemoveByNo3PSDEViewCtrl(pSDEViewCtrl2);
                PSDEViewEngineServiceBase.this.onAfterRemoveByNo3PSDEViewCtrl(pSDEViewCtrl2);
            }
        });
    }

    protected void onBeforeRemoveByNo3PSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
    }

    protected void internalRemoveByNo3PSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectByNo3PSDEViewCtrl(pSDEViewCtrl);
        this.onBeforeRemoveByNo3PSDEViewCtrl(pSDEViewCtrl, arrayList);
        for (PSDEViewEngine pSDEViewEngine : arrayList) {
            this.remove(pSDEViewEngine);
        }
        this.onAfterRemoveByNo3PSDEViewCtrl(pSDEViewCtrl, arrayList);
    }

    protected void onAfterRemoveByNo3PSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
    }

    protected void onBeforeRemoveByNo3PSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl, ArrayList<PSDEViewEngine> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNo3PSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl, ArrayList<PSDEViewEngine> arrayList) throws Exception {
    }

    public void testRemoveByNo4PSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectByNo4PSDEViewCtrl(pSDEViewCtrl, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWCTRL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEViewCtrl);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWENGINE_PSDEVIEWCTRL_NO4PSDEVIEWCTRLID", "", iDataEntityModel.getName(), "PSDEVIEWENGINE", iDataEntityModel.getDataInfo(pSDEViewCtrl), arrayList.get(0)));
        }
    }

    public void resetNo4PSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectByNo4PSDEViewCtrl(pSDEViewCtrl);
        for (PSDEViewEngine pSDEViewEngine : arrayList) {
            PSDEViewEngine pSDEViewEngine2 = (PSDEViewEngine)this.getDEModel().createEntity();
            pSDEViewEngine2.setPSDEViewEngineId(pSDEViewEngine.getPSDEViewEngineId());
            pSDEViewEngine2.setNo4PSDEViewCtrlId(null);
            this.update(pSDEViewEngine2);
        }
    }

    public void resetTempNo4PSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectTempByNo4PSDEViewCtrl(pSDEViewCtrl);
        for (PSDEViewEngine pSDEViewEngine : arrayList) {
            PSDEViewEngine pSDEViewEngine2 = (PSDEViewEngine)this.getDEModel().createEntity();
            pSDEViewEngine2.setPSDEViewEngineId(pSDEViewEngine.getPSDEViewEngineId());
            pSDEViewEngine2.setNo4PSDEViewCtrlId(null);
            this.updateTemp(pSDEViewEngine2);
        }
    }

    public void removeByNo4PSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        final PSDEViewCtrl pSDEViewCtrl2 = pSDEViewCtrl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewEngineServiceBase.this.onBeforeRemoveByNo4PSDEViewCtrl(pSDEViewCtrl2);
                PSDEViewEngineServiceBase.this.internalRemoveByNo4PSDEViewCtrl(pSDEViewCtrl2);
                PSDEViewEngineServiceBase.this.onAfterRemoveByNo4PSDEViewCtrl(pSDEViewCtrl2);
            }
        });
    }

    protected void onBeforeRemoveByNo4PSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
    }

    protected void internalRemoveByNo4PSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectByNo4PSDEViewCtrl(pSDEViewCtrl);
        this.onBeforeRemoveByNo4PSDEViewCtrl(pSDEViewCtrl, arrayList);
        for (PSDEViewEngine pSDEViewEngine : arrayList) {
            this.remove(pSDEViewEngine);
        }
        this.onAfterRemoveByNo4PSDEViewCtrl(pSDEViewCtrl, arrayList);
    }

    protected void onAfterRemoveByNo4PSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
    }

    protected void onBeforeRemoveByNo4PSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl, ArrayList<PSDEViewEngine> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNo4PSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl, ArrayList<PSDEViewEngine> arrayList) throws Exception {
    }

    public void testRemoveByPSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectByPSDEViewCtrl(pSDEViewCtrl, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWCTRL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEViewCtrl);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWENGINE_PSDEVIEWCTRL_PSDEVIEWCTRLID", "", iDataEntityModel.getName(), "PSDEVIEWENGINE", iDataEntityModel.getDataInfo(pSDEViewCtrl), arrayList.get(0)));
        }
    }

    public void resetPSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectByPSDEViewCtrl(pSDEViewCtrl);
        for (PSDEViewEngine pSDEViewEngine : arrayList) {
            PSDEViewEngine pSDEViewEngine2 = (PSDEViewEngine)this.getDEModel().createEntity();
            pSDEViewEngine2.setPSDEViewEngineId(pSDEViewEngine.getPSDEViewEngineId());
            pSDEViewEngine2.setPSDEViewCtrlId(null);
            this.update(pSDEViewEngine2);
        }
    }

    public void resetTempPSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectTempByPSDEViewCtrl(pSDEViewCtrl);
        for (PSDEViewEngine pSDEViewEngine : arrayList) {
            PSDEViewEngine pSDEViewEngine2 = (PSDEViewEngine)this.getDEModel().createEntity();
            pSDEViewEngine2.setPSDEViewEngineId(pSDEViewEngine.getPSDEViewEngineId());
            pSDEViewEngine2.setPSDEViewCtrlId(null);
            this.updateTemp(pSDEViewEngine2);
        }
    }

    public void removeByPSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        final PSDEViewCtrl pSDEViewCtrl2 = pSDEViewCtrl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewEngineServiceBase.this.onBeforeRemoveByPSDEViewCtrl(pSDEViewCtrl2);
                PSDEViewEngineServiceBase.this.internalRemoveByPSDEViewCtrl(pSDEViewCtrl2);
                PSDEViewEngineServiceBase.this.onAfterRemoveByPSDEViewCtrl(pSDEViewCtrl2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
    }

    protected void internalRemoveByPSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectByPSDEViewCtrl(pSDEViewCtrl);
        this.onBeforeRemoveByPSDEViewCtrl(pSDEViewCtrl, arrayList);
        for (PSDEViewEngine pSDEViewEngine : arrayList) {
            this.remove(pSDEViewEngine);
        }
        this.onAfterRemoveByPSDEViewCtrl(pSDEViewCtrl, arrayList);
    }

    protected void onAfterRemoveByPSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
    }

    protected void onBeforeRemoveByPSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl, ArrayList<PSDEViewEngine> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl, ArrayList<PSDEViewEngine> arrayList) throws Exception {
    }

    public void testRemoveByNo2PSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectByNo2PSDEViewLogic(pSDEViewLogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWLOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEViewLogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWENGINE_PSDEVIEWLOGIC_NO2PSDEVIEWLOGICID", "", iDataEntityModel.getName(), "PSDEVIEWENGINE", iDataEntityModel.getDataInfo(pSDEViewLogic), arrayList.get(0)));
        }
    }

    public void resetNo2PSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectByNo2PSDEViewLogic(pSDEViewLogic);
        for (PSDEViewEngine pSDEViewEngine : arrayList) {
            PSDEViewEngine pSDEViewEngine2 = (PSDEViewEngine)this.getDEModel().createEntity();
            pSDEViewEngine2.setPSDEViewEngineId(pSDEViewEngine.getPSDEViewEngineId());
            pSDEViewEngine2.setNo2PSDEViewLogicId(null);
            this.update(pSDEViewEngine2);
        }
    }

    public void resetTempNo2PSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectTempByNo2PSDEViewLogic(pSDEViewLogic);
        for (PSDEViewEngine pSDEViewEngine : arrayList) {
            PSDEViewEngine pSDEViewEngine2 = (PSDEViewEngine)this.getDEModel().createEntity();
            pSDEViewEngine2.setPSDEViewEngineId(pSDEViewEngine.getPSDEViewEngineId());
            pSDEViewEngine2.setNo2PSDEViewLogicId(null);
            this.updateTemp(pSDEViewEngine2);
        }
    }

    public void removeByNo2PSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
        final PSDEViewLogic pSDEViewLogic2 = pSDEViewLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewEngineServiceBase.this.onBeforeRemoveByNo2PSDEViewLogic(pSDEViewLogic2);
                PSDEViewEngineServiceBase.this.internalRemoveByNo2PSDEViewLogic(pSDEViewLogic2);
                PSDEViewEngineServiceBase.this.onAfterRemoveByNo2PSDEViewLogic(pSDEViewLogic2);
            }
        });
    }

    protected void onBeforeRemoveByNo2PSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
    }

    protected void internalRemoveByNo2PSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectByNo2PSDEViewLogic(pSDEViewLogic);
        this.onBeforeRemoveByNo2PSDEViewLogic(pSDEViewLogic, arrayList);
        for (PSDEViewEngine pSDEViewEngine : arrayList) {
            this.remove(pSDEViewEngine);
        }
        this.onAfterRemoveByNo2PSDEViewLogic(pSDEViewLogic, arrayList);
    }

    protected void onAfterRemoveByNo2PSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
    }

    protected void onBeforeRemoveByNo2PSDEViewLogic(PSDEViewLogic pSDEViewLogic, ArrayList<PSDEViewEngine> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNo2PSDEViewLogic(PSDEViewLogic pSDEViewLogic, ArrayList<PSDEViewEngine> arrayList) throws Exception {
    }

    public void testRemoveByNo3PSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectByNo3PSDEViewLogic(pSDEViewLogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWLOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEViewLogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWENGINE_PSDEVIEWLOGIC_NO3PSDEVIEWLOGICID", "", iDataEntityModel.getName(), "PSDEVIEWENGINE", iDataEntityModel.getDataInfo(pSDEViewLogic), arrayList.get(0)));
        }
    }

    public void resetNo3PSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectByNo3PSDEViewLogic(pSDEViewLogic);
        for (PSDEViewEngine pSDEViewEngine : arrayList) {
            PSDEViewEngine pSDEViewEngine2 = (PSDEViewEngine)this.getDEModel().createEntity();
            pSDEViewEngine2.setPSDEViewEngineId(pSDEViewEngine.getPSDEViewEngineId());
            pSDEViewEngine2.setNo3PSDEViewLogicId(null);
            this.update(pSDEViewEngine2);
        }
    }

    public void resetTempNo3PSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectTempByNo3PSDEViewLogic(pSDEViewLogic);
        for (PSDEViewEngine pSDEViewEngine : arrayList) {
            PSDEViewEngine pSDEViewEngine2 = (PSDEViewEngine)this.getDEModel().createEntity();
            pSDEViewEngine2.setPSDEViewEngineId(pSDEViewEngine.getPSDEViewEngineId());
            pSDEViewEngine2.setNo3PSDEViewLogicId(null);
            this.updateTemp(pSDEViewEngine2);
        }
    }

    public void removeByNo3PSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
        final PSDEViewLogic pSDEViewLogic2 = pSDEViewLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewEngineServiceBase.this.onBeforeRemoveByNo3PSDEViewLogic(pSDEViewLogic2);
                PSDEViewEngineServiceBase.this.internalRemoveByNo3PSDEViewLogic(pSDEViewLogic2);
                PSDEViewEngineServiceBase.this.onAfterRemoveByNo3PSDEViewLogic(pSDEViewLogic2);
            }
        });
    }

    protected void onBeforeRemoveByNo3PSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
    }

    protected void internalRemoveByNo3PSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectByNo3PSDEViewLogic(pSDEViewLogic);
        this.onBeforeRemoveByNo3PSDEViewLogic(pSDEViewLogic, arrayList);
        for (PSDEViewEngine pSDEViewEngine : arrayList) {
            this.remove(pSDEViewEngine);
        }
        this.onAfterRemoveByNo3PSDEViewLogic(pSDEViewLogic, arrayList);
    }

    protected void onAfterRemoveByNo3PSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
    }

    protected void onBeforeRemoveByNo3PSDEViewLogic(PSDEViewLogic pSDEViewLogic, ArrayList<PSDEViewEngine> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNo3PSDEViewLogic(PSDEViewLogic pSDEViewLogic, ArrayList<PSDEViewEngine> arrayList) throws Exception {
    }

    public void testRemoveByNo4PSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectByNo4PSDEViewLogic(pSDEViewLogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWLOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEViewLogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWENGINE_PSDEVIEWLOGIC_NO4PSDEVIEWLOGICID", "", iDataEntityModel.getName(), "PSDEVIEWENGINE", iDataEntityModel.getDataInfo(pSDEViewLogic), arrayList.get(0)));
        }
    }

    public void resetNo4PSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectByNo4PSDEViewLogic(pSDEViewLogic);
        for (PSDEViewEngine pSDEViewEngine : arrayList) {
            PSDEViewEngine pSDEViewEngine2 = (PSDEViewEngine)this.getDEModel().createEntity();
            pSDEViewEngine2.setPSDEViewEngineId(pSDEViewEngine.getPSDEViewEngineId());
            pSDEViewEngine2.setNo4PSDEViewLogicId(null);
            this.update(pSDEViewEngine2);
        }
    }

    public void resetTempNo4PSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectTempByNo4PSDEViewLogic(pSDEViewLogic);
        for (PSDEViewEngine pSDEViewEngine : arrayList) {
            PSDEViewEngine pSDEViewEngine2 = (PSDEViewEngine)this.getDEModel().createEntity();
            pSDEViewEngine2.setPSDEViewEngineId(pSDEViewEngine.getPSDEViewEngineId());
            pSDEViewEngine2.setNo4PSDEViewLogicId(null);
            this.updateTemp(pSDEViewEngine2);
        }
    }

    public void removeByNo4PSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
        final PSDEViewLogic pSDEViewLogic2 = pSDEViewLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewEngineServiceBase.this.onBeforeRemoveByNo4PSDEViewLogic(pSDEViewLogic2);
                PSDEViewEngineServiceBase.this.internalRemoveByNo4PSDEViewLogic(pSDEViewLogic2);
                PSDEViewEngineServiceBase.this.onAfterRemoveByNo4PSDEViewLogic(pSDEViewLogic2);
            }
        });
    }

    protected void onBeforeRemoveByNo4PSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
    }

    protected void internalRemoveByNo4PSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectByNo4PSDEViewLogic(pSDEViewLogic);
        this.onBeforeRemoveByNo4PSDEViewLogic(pSDEViewLogic, arrayList);
        for (PSDEViewEngine pSDEViewEngine : arrayList) {
            this.remove(pSDEViewEngine);
        }
        this.onAfterRemoveByNo4PSDEViewLogic(pSDEViewLogic, arrayList);
    }

    protected void onAfterRemoveByNo4PSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
    }

    protected void onBeforeRemoveByNo4PSDEViewLogic(PSDEViewLogic pSDEViewLogic, ArrayList<PSDEViewEngine> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNo4PSDEViewLogic(PSDEViewLogic pSDEViewLogic, ArrayList<PSDEViewEngine> arrayList) throws Exception {
    }

    public void testRemoveByPSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectByPSDEViewLogic(pSDEViewLogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWLOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEViewLogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWENGINE_PSDEVIEWLOGIC_PSDEVIEWLOGICID", "", iDataEntityModel.getName(), "PSDEVIEWENGINE", iDataEntityModel.getDataInfo(pSDEViewLogic), arrayList.get(0)));
        }
    }

    public void resetPSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectByPSDEViewLogic(pSDEViewLogic);
        for (PSDEViewEngine pSDEViewEngine : arrayList) {
            PSDEViewEngine pSDEViewEngine2 = (PSDEViewEngine)this.getDEModel().createEntity();
            pSDEViewEngine2.setPSDEViewEngineId(pSDEViewEngine.getPSDEViewEngineId());
            pSDEViewEngine2.setPSDEViewLogicId(null);
            this.update(pSDEViewEngine2);
        }
    }

    public void resetTempPSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectTempByPSDEViewLogic(pSDEViewLogic);
        for (PSDEViewEngine pSDEViewEngine : arrayList) {
            PSDEViewEngine pSDEViewEngine2 = (PSDEViewEngine)this.getDEModel().createEntity();
            pSDEViewEngine2.setPSDEViewEngineId(pSDEViewEngine.getPSDEViewEngineId());
            pSDEViewEngine2.setPSDEViewLogicId(null);
            this.updateTemp(pSDEViewEngine2);
        }
    }

    public void removeByPSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
        final PSDEViewLogic pSDEViewLogic2 = pSDEViewLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewEngineServiceBase.this.onBeforeRemoveByPSDEViewLogic(pSDEViewLogic2);
                PSDEViewEngineServiceBase.this.internalRemoveByPSDEViewLogic(pSDEViewLogic2);
                PSDEViewEngineServiceBase.this.onAfterRemoveByPSDEViewLogic(pSDEViewLogic2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
    }

    protected void internalRemoveByPSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectByPSDEViewLogic(pSDEViewLogic);
        this.onBeforeRemoveByPSDEViewLogic(pSDEViewLogic, arrayList);
        for (PSDEViewEngine pSDEViewEngine : arrayList) {
            this.remove(pSDEViewEngine);
        }
        this.onAfterRemoveByPSDEViewLogic(pSDEViewLogic, arrayList);
    }

    protected void onAfterRemoveByPSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
    }

    protected void onBeforeRemoveByPSDEViewLogic(PSDEViewLogic pSDEViewLogic, ArrayList<PSDEViewEngine> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEViewLogic(PSDEViewLogic pSDEViewLogic, ArrayList<PSDEViewEngine> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWENGINE_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSDEVIEWENGINE", iDataEntityModel.getDataInfo(pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSDEViewEngine pSDEViewEngine : arrayList) {
            PSDEViewEngine pSDEViewEngine2 = (PSDEViewEngine)this.getDEModel().createEntity();
            pSDEViewEngine2.setPSDEViewEngineId(pSDEViewEngine.getPSDEViewEngineId());
            pSDEViewEngine2.setPSSysPFPluginId(null);
            this.update(pSDEViewEngine2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewEngineServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEViewEngineServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEViewEngineServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSDEViewEngine pSDEViewEngine : arrayList) {
            this.remove(pSDEViewEngine);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEViewEngine> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEViewEngine> arrayList) throws Exception {
    }

    public void testRemoveByPSUIEngineType(PSUIEngineType pSUIEngineType) throws Exception {
    }

    public void resetPSUIEngineType(PSUIEngineType pSUIEngineType) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectByPSUIEngineType(pSUIEngineType);
        for (PSDEViewEngine pSDEViewEngine : arrayList) {
            PSDEViewEngine pSDEViewEngine2 = (PSDEViewEngine)this.getDEModel().createEntity();
            pSDEViewEngine2.setPSDEViewEngineId(pSDEViewEngine.getPSDEViewEngineId());
            pSDEViewEngine2.setPSUIEngineTypeId(null);
            this.update(pSDEViewEngine2);
        }
    }

    public void removeByPSUIEngineType(PSUIEngineType pSUIEngineType) throws Exception {
        final PSUIEngineType pSUIEngineType2 = pSUIEngineType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewEngineServiceBase.this.onBeforeRemoveByPSUIEngineType(pSUIEngineType2);
                PSDEViewEngineServiceBase.this.internalRemoveByPSUIEngineType(pSUIEngineType2);
                PSDEViewEngineServiceBase.this.onAfterRemoveByPSUIEngineType(pSUIEngineType2);
            }
        });
    }

    protected void onBeforeRemoveByPSUIEngineType(PSUIEngineType pSUIEngineType) throws Exception {
    }

    protected void internalRemoveByPSUIEngineType(PSUIEngineType pSUIEngineType) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectByPSUIEngineType(pSUIEngineType);
        this.onBeforeRemoveByPSUIEngineType(pSUIEngineType, arrayList);
        for (PSDEViewEngine pSDEViewEngine : arrayList) {
            this.remove(pSDEViewEngine);
        }
        this.onAfterRemoveByPSUIEngineType(pSUIEngineType, arrayList);
    }

    protected void onAfterRemoveByPSUIEngineType(PSUIEngineType pSUIEngineType) throws Exception {
    }

    protected void onBeforeRemoveByPSUIEngineType(PSUIEngineType pSUIEngineType, ArrayList<PSDEViewEngine> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSUIEngineType(PSUIEngineType pSUIEngineType, ArrayList<PSDEViewEngine> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEViewEngine pSDEViewEngine) throws Exception {
        super.onBeforeRemove(pSDEViewEngine);
    }

    public void removeTempByNo2PSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        final PSDEViewCtrl pSDEViewCtrl2 = pSDEViewCtrl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewEngineServiceBase.this.onBeforeRemoveTempByNo2PSDEViewCtrl(pSDEViewCtrl2);
                PSDEViewEngineServiceBase.this.internalRemoveTempByNo2PSDEViewCtrl(pSDEViewCtrl2);
                PSDEViewEngineServiceBase.this.onAfterRemoveTempByNo2PSDEViewCtrl(pSDEViewCtrl2);
            }
        });
    }

    protected void onBeforeRemoveTempByNo2PSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
    }

    protected void internalRemoveTempByNo2PSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectTempByNo2PSDEViewCtrl(pSDEViewCtrl);
        this.onBeforeRemoveTempByNo2PSDEViewCtrl(pSDEViewCtrl, arrayList);
        for (PSDEViewEngine pSDEViewEngine : arrayList) {
            this.removeTemp(pSDEViewEngine);
        }
        this.onAfterRemoveTempByNo2PSDEViewCtrl(pSDEViewCtrl, arrayList);
    }

    protected void onAfterRemoveTempByNo2PSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
    }

    protected void onBeforeRemoveTempByNo2PSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl, ArrayList<PSDEViewEngine> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByNo2PSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl, ArrayList<PSDEViewEngine> arrayList) throws Exception {
    }

    public void removeTempByNo3PSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        final PSDEViewCtrl pSDEViewCtrl2 = pSDEViewCtrl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewEngineServiceBase.this.onBeforeRemoveTempByNo3PSDEViewCtrl(pSDEViewCtrl2);
                PSDEViewEngineServiceBase.this.internalRemoveTempByNo3PSDEViewCtrl(pSDEViewCtrl2);
                PSDEViewEngineServiceBase.this.onAfterRemoveTempByNo3PSDEViewCtrl(pSDEViewCtrl2);
            }
        });
    }

    protected void onBeforeRemoveTempByNo3PSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
    }

    protected void internalRemoveTempByNo3PSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectTempByNo3PSDEViewCtrl(pSDEViewCtrl);
        this.onBeforeRemoveTempByNo3PSDEViewCtrl(pSDEViewCtrl, arrayList);
        for (PSDEViewEngine pSDEViewEngine : arrayList) {
            this.removeTemp(pSDEViewEngine);
        }
        this.onAfterRemoveTempByNo3PSDEViewCtrl(pSDEViewCtrl, arrayList);
    }

    protected void onAfterRemoveTempByNo3PSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
    }

    protected void onBeforeRemoveTempByNo3PSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl, ArrayList<PSDEViewEngine> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByNo3PSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl, ArrayList<PSDEViewEngine> arrayList) throws Exception {
    }

    public void removeTempByNo4PSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        final PSDEViewCtrl pSDEViewCtrl2 = pSDEViewCtrl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewEngineServiceBase.this.onBeforeRemoveTempByNo4PSDEViewCtrl(pSDEViewCtrl2);
                PSDEViewEngineServiceBase.this.internalRemoveTempByNo4PSDEViewCtrl(pSDEViewCtrl2);
                PSDEViewEngineServiceBase.this.onAfterRemoveTempByNo4PSDEViewCtrl(pSDEViewCtrl2);
            }
        });
    }

    protected void onBeforeRemoveTempByNo4PSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
    }

    protected void internalRemoveTempByNo4PSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectTempByNo4PSDEViewCtrl(pSDEViewCtrl);
        this.onBeforeRemoveTempByNo4PSDEViewCtrl(pSDEViewCtrl, arrayList);
        for (PSDEViewEngine pSDEViewEngine : arrayList) {
            this.removeTemp(pSDEViewEngine);
        }
        this.onAfterRemoveTempByNo4PSDEViewCtrl(pSDEViewCtrl, arrayList);
    }

    protected void onAfterRemoveTempByNo4PSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
    }

    protected void onBeforeRemoveTempByNo4PSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl, ArrayList<PSDEViewEngine> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByNo4PSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl, ArrayList<PSDEViewEngine> arrayList) throws Exception {
    }

    public void removeTempByPSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        final PSDEViewCtrl pSDEViewCtrl2 = pSDEViewCtrl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewEngineServiceBase.this.onBeforeRemoveTempByPSDEViewCtrl(pSDEViewCtrl2);
                PSDEViewEngineServiceBase.this.internalRemoveTempByPSDEViewCtrl(pSDEViewCtrl2);
                PSDEViewEngineServiceBase.this.onAfterRemoveTempByPSDEViewCtrl(pSDEViewCtrl2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
    }

    protected void internalRemoveTempByPSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectTempByPSDEViewCtrl(pSDEViewCtrl);
        this.onBeforeRemoveTempByPSDEViewCtrl(pSDEViewCtrl, arrayList);
        for (PSDEViewEngine pSDEViewEngine : arrayList) {
            this.removeTemp(pSDEViewEngine);
        }
        this.onAfterRemoveTempByPSDEViewCtrl(pSDEViewCtrl, arrayList);
    }

    protected void onAfterRemoveTempByPSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl, ArrayList<PSDEViewEngine> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEViewCtrl(PSDEViewCtrl pSDEViewCtrl, ArrayList<PSDEViewEngine> arrayList) throws Exception {
    }

    public void removeTempByNo2PSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
        final PSDEViewLogic pSDEViewLogic2 = pSDEViewLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewEngineServiceBase.this.onBeforeRemoveTempByNo2PSDEViewLogic(pSDEViewLogic2);
                PSDEViewEngineServiceBase.this.internalRemoveTempByNo2PSDEViewLogic(pSDEViewLogic2);
                PSDEViewEngineServiceBase.this.onAfterRemoveTempByNo2PSDEViewLogic(pSDEViewLogic2);
            }
        });
    }

    protected void onBeforeRemoveTempByNo2PSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
    }

    protected void internalRemoveTempByNo2PSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectTempByNo2PSDEViewLogic(pSDEViewLogic);
        this.onBeforeRemoveTempByNo2PSDEViewLogic(pSDEViewLogic, arrayList);
        for (PSDEViewEngine pSDEViewEngine : arrayList) {
            this.removeTemp(pSDEViewEngine);
        }
        this.onAfterRemoveTempByNo2PSDEViewLogic(pSDEViewLogic, arrayList);
    }

    protected void onAfterRemoveTempByNo2PSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
    }

    protected void onBeforeRemoveTempByNo2PSDEViewLogic(PSDEViewLogic pSDEViewLogic, ArrayList<PSDEViewEngine> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByNo2PSDEViewLogic(PSDEViewLogic pSDEViewLogic, ArrayList<PSDEViewEngine> arrayList) throws Exception {
    }

    public void removeTempByNo3PSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
        final PSDEViewLogic pSDEViewLogic2 = pSDEViewLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewEngineServiceBase.this.onBeforeRemoveTempByNo3PSDEViewLogic(pSDEViewLogic2);
                PSDEViewEngineServiceBase.this.internalRemoveTempByNo3PSDEViewLogic(pSDEViewLogic2);
                PSDEViewEngineServiceBase.this.onAfterRemoveTempByNo3PSDEViewLogic(pSDEViewLogic2);
            }
        });
    }

    protected void onBeforeRemoveTempByNo3PSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
    }

    protected void internalRemoveTempByNo3PSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectTempByNo3PSDEViewLogic(pSDEViewLogic);
        this.onBeforeRemoveTempByNo3PSDEViewLogic(pSDEViewLogic, arrayList);
        for (PSDEViewEngine pSDEViewEngine : arrayList) {
            this.removeTemp(pSDEViewEngine);
        }
        this.onAfterRemoveTempByNo3PSDEViewLogic(pSDEViewLogic, arrayList);
    }

    protected void onAfterRemoveTempByNo3PSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
    }

    protected void onBeforeRemoveTempByNo3PSDEViewLogic(PSDEViewLogic pSDEViewLogic, ArrayList<PSDEViewEngine> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByNo3PSDEViewLogic(PSDEViewLogic pSDEViewLogic, ArrayList<PSDEViewEngine> arrayList) throws Exception {
    }

    public void removeTempByNo4PSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
        final PSDEViewLogic pSDEViewLogic2 = pSDEViewLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewEngineServiceBase.this.onBeforeRemoveTempByNo4PSDEViewLogic(pSDEViewLogic2);
                PSDEViewEngineServiceBase.this.internalRemoveTempByNo4PSDEViewLogic(pSDEViewLogic2);
                PSDEViewEngineServiceBase.this.onAfterRemoveTempByNo4PSDEViewLogic(pSDEViewLogic2);
            }
        });
    }

    protected void onBeforeRemoveTempByNo4PSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
    }

    protected void internalRemoveTempByNo4PSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectTempByNo4PSDEViewLogic(pSDEViewLogic);
        this.onBeforeRemoveTempByNo4PSDEViewLogic(pSDEViewLogic, arrayList);
        for (PSDEViewEngine pSDEViewEngine : arrayList) {
            this.removeTemp(pSDEViewEngine);
        }
        this.onAfterRemoveTempByNo4PSDEViewLogic(pSDEViewLogic, arrayList);
    }

    protected void onAfterRemoveTempByNo4PSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
    }

    protected void onBeforeRemoveTempByNo4PSDEViewLogic(PSDEViewLogic pSDEViewLogic, ArrayList<PSDEViewEngine> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByNo4PSDEViewLogic(PSDEViewLogic pSDEViewLogic, ArrayList<PSDEViewEngine> arrayList) throws Exception {
    }

    public void removeTempByPSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
        final PSDEViewLogic pSDEViewLogic2 = pSDEViewLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewEngineServiceBase.this.onBeforeRemoveTempByPSDEViewLogic(pSDEViewLogic2);
                PSDEViewEngineServiceBase.this.internalRemoveTempByPSDEViewLogic(pSDEViewLogic2);
                PSDEViewEngineServiceBase.this.onAfterRemoveTempByPSDEViewLogic(pSDEViewLogic2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
    }

    protected void internalRemoveTempByPSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectTempByPSDEViewLogic(pSDEViewLogic);
        this.onBeforeRemoveTempByPSDEViewLogic(pSDEViewLogic, arrayList);
        for (PSDEViewEngine pSDEViewEngine : arrayList) {
            this.removeTemp(pSDEViewEngine);
        }
        this.onAfterRemoveTempByPSDEViewLogic(pSDEViewLogic, arrayList);
    }

    protected void onAfterRemoveTempByPSDEViewLogic(PSDEViewLogic pSDEViewLogic) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEViewLogic(PSDEViewLogic pSDEViewLogic, ArrayList<PSDEViewEngine> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEViewLogic(PSDEViewLogic pSDEViewLogic, ArrayList<PSDEViewEngine> arrayList) throws Exception {
    }

    public void removeTempByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewEngineServiceBase.this.onBeforeRemoveTempByPSDEViewBase(pSDEViewBase2);
                PSDEViewEngineServiceBase.this.internalRemoveTempByPSDEViewBase(pSDEViewBase2);
                PSDEViewEngineServiceBase.this.onAfterRemoveTempByPSDEViewBase(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveTempByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEViewEngine> arrayList = this.selectTempByPSDEViewBase(pSDEViewBase);
        this.onBeforeRemoveTempByPSDEViewBase(pSDEViewBase, arrayList);
        for (PSDEViewEngine pSDEViewEngine : arrayList) {
            this.removeTemp(pSDEViewEngine);
        }
        this.onAfterRemoveTempByPSDEViewBase(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveTempByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSDEViewEngine> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSDEViewEngine> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSDEViewEngine pSDEViewEngine, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEViewEngine, cloneSession);
        if (pSDEViewEngine.getPSDEViewBaseId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSDEViewEngine.getPSDEViewBaseId())) != null) {
            this.onFillParentInfo_PSDEViewBase(pSDEViewEngine, (PSDEViewBase)iEntity);
        }
        if (pSDEViewEngine.getNo2PSDEViewCtrlId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWCTRL", (Object)pSDEViewEngine.getNo2PSDEViewCtrlId())) != null) {
            this.onFillParentInfo_No2PSDEViewCtrl(pSDEViewEngine, (PSDEViewCtrl)iEntity);
        }
        if (pSDEViewEngine.getNo3PSDEViewCtrlId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWCTRL", (Object)pSDEViewEngine.getNo3PSDEViewCtrlId())) != null) {
            this.onFillParentInfo_No3PSDEViewCtrl(pSDEViewEngine, (PSDEViewCtrl)iEntity);
        }
        if (pSDEViewEngine.getNo4PSDEViewCtrlId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWCTRL", (Object)pSDEViewEngine.getNo4PSDEViewCtrlId())) != null) {
            this.onFillParentInfo_No4PSDEViewCtrl(pSDEViewEngine, (PSDEViewCtrl)iEntity);
        }
        if (pSDEViewEngine.getPSDEViewCtrlId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWCTRL", (Object)pSDEViewEngine.getPSDEViewCtrlId())) != null) {
            this.onFillParentInfo_PSDEViewCtrl(pSDEViewEngine, (PSDEViewCtrl)iEntity);
        }
        if (pSDEViewEngine.getNo2PSDEViewLogicId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWLOGIC", (Object)pSDEViewEngine.getNo2PSDEViewLogicId())) != null) {
            this.onFillParentInfo_No2PSDEViewLogic(pSDEViewEngine, (PSDEViewLogic)iEntity);
        }
        if (pSDEViewEngine.getNo3PSDEViewLogicId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWLOGIC", (Object)pSDEViewEngine.getNo3PSDEViewLogicId())) != null) {
            this.onFillParentInfo_No3PSDEViewLogic(pSDEViewEngine, (PSDEViewLogic)iEntity);
        }
        if (pSDEViewEngine.getNo4PSDEViewLogicId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWLOGIC", (Object)pSDEViewEngine.getNo4PSDEViewLogicId())) != null) {
            this.onFillParentInfo_No4PSDEViewLogic(pSDEViewEngine, (PSDEViewLogic)iEntity);
        }
        if (pSDEViewEngine.getPSDEViewLogicId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWLOGIC", (Object)pSDEViewEngine.getPSDEViewLogicId())) != null) {
            this.onFillParentInfo_PSDEViewLogic(pSDEViewEngine, (PSDEViewLogic)iEntity);
        }
        if (pSDEViewEngine.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSDEViewEngine.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSDEViewEngine, (PSSysPFPlugin)iEntity);
        }
        if (pSDEViewEngine.getPSUIEngineTypeId() != null && (iEntity = cloneSession.getEntity("PSUIENGINETYPE", (Object)pSDEViewEngine.getPSUIEngineTypeId())) != null) {
            this.onFillParentInfo_PSUIEngineType(pSDEViewEngine, (PSUIEngineType)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEViewEngine pSDEViewEngine, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEViewEngine, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DEViewCtrlFlag(bl, pSDEViewEngine, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEViewCtrlLabel(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEViewLogicFlag(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEViewLogicLabel(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineOption(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam10(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam10Flag(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam10Label(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam2(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam2Flag(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam2Label(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam3(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam3Flag(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam3Label(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam4(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam4Flag(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam4Label(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam5(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam5Flag(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam5Label(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam6(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam6Flag(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam6Label(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam7(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam7Flag(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam7Label(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam8(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam8Flag(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam8Label(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam9(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam9Flag(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam9Label(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParamFlag(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParamLabel(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No2DEViewCtrlFlag(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No2DEViewCtrlLabel(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No2DEViewLogicFlag(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No2DEViewLogicLabel(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No2PSDEViewCtrlId(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No2PSDEViewCtrlName(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No2PSDEViewLogicId(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No2PSDEViewLogicName(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No3DEViewCtrlFlag(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No3DEViewCtrlLabel(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No3DEViewLogicFlag(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No3DEViewLogicLabel(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No3PSDEViewCtrlId(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No3PSDEViewCtrlName(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No3PSDEViewLogicId(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No3PSDEViewLogicName(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No4DEViewCtrlFlag(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No4DEViewCtrlLabel(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No4DEViewLogicFlag(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No4DEViewLogicLabel(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No4PSDEViewCtrlId(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No4PSDEViewCtrlName(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No4PSDEViewLogicId(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No4PSDEViewLogicName(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewBaseId(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewCtrlId(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewCtrlName(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewEngineId(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewEngineName(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewLogicId(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewLogicName(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSUIEngineTypeId(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSUIEngineTypeName(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParam(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParam10(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParam2(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParam3(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParam4(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParam5(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParam6(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParam7(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParam8(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParam9(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFViewParam(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFViewParam2(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFViewParam3(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFViewParam4(bl, pSDEViewEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEViewEngine, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DEViewCtrlFlag(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isDEViewCtrlFlagDirty() : !pSDEViewEngine.isDEViewCtrlFlagDirty()) {
            return null;
        }
        Integer n = pSDEViewEngine.getDEViewCtrlFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DEViewCtrlFlag_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEVIEWCTRLFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEViewCtrlLabel(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isDEViewCtrlLabelDirty() : !pSDEViewEngine.isDEViewCtrlLabelDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getDEViewCtrlLabel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DEViewCtrlLabel_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEVIEWCTRLLABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEViewLogicFlag(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isDEViewLogicFlagDirty() : !pSDEViewEngine.isDEViewLogicFlagDirty()) {
            return null;
        }
        Integer n = pSDEViewEngine.getDEViewLogicFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DEViewLogicFlag_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEVIEWLOGICFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEViewLogicLabel(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isDEViewLogicLabelDirty() : !pSDEViewEngine.isDEViewLogicLabelDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getDEViewLogicLabel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DEViewLogicLabel_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEVIEWLOGICLABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineOption(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isEngineOptionDirty() : !pSDEViewEngine.isEngineOptionDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getEngineOption();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EngineOption_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEOPTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isEngineParamDirty() : !pSDEViewEngine.isEngineParamDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getEngineParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EngineParam_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam10(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isEngineParam10Dirty() : !pSDEViewEngine.isEngineParam10Dirty()) {
            return null;
        }
        Integer n = pSDEViewEngine.getEngineParam10();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EngineParam10_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM10");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam10Flag(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isEngineParam10FlagDirty() : !pSDEViewEngine.isEngineParam10FlagDirty()) {
            return null;
        }
        Integer n = pSDEViewEngine.getEngineParam10Flag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EngineParam10Flag_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM10FLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam10Label(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isEngineParam10LabelDirty() : !pSDEViewEngine.isEngineParam10LabelDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getEngineParam10Label();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EngineParam10Label_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM10LABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam2(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isEngineParam2Dirty() : !pSDEViewEngine.isEngineParam2Dirty()) {
            return null;
        }
        String string = pSDEViewEngine.getEngineParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EngineParam2_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam2Flag(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isEngineParam2FlagDirty() : !pSDEViewEngine.isEngineParam2FlagDirty()) {
            return null;
        }
        Integer n = pSDEViewEngine.getEngineParam2Flag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EngineParam2Flag_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM2FLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam2Label(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isEngineParam2LabelDirty() : !pSDEViewEngine.isEngineParam2LabelDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getEngineParam2Label();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EngineParam2Label_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM2LABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam3(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isEngineParam3Dirty() : !pSDEViewEngine.isEngineParam3Dirty()) {
            return null;
        }
        String string = pSDEViewEngine.getEngineParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EngineParam3_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam3Flag(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isEngineParam3FlagDirty() : !pSDEViewEngine.isEngineParam3FlagDirty()) {
            return null;
        }
        Integer n = pSDEViewEngine.getEngineParam3Flag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EngineParam3Flag_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM3FLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam3Label(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isEngineParam3LabelDirty() : !pSDEViewEngine.isEngineParam3LabelDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getEngineParam3Label();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EngineParam3Label_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM3LABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam4(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isEngineParam4Dirty() : !pSDEViewEngine.isEngineParam4Dirty()) {
            return null;
        }
        String string = pSDEViewEngine.getEngineParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EngineParam4_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam4Flag(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isEngineParam4FlagDirty() : !pSDEViewEngine.isEngineParam4FlagDirty()) {
            return null;
        }
        Integer n = pSDEViewEngine.getEngineParam4Flag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EngineParam4Flag_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM4FLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam4Label(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isEngineParam4LabelDirty() : !pSDEViewEngine.isEngineParam4LabelDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getEngineParam4Label();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EngineParam4Label_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM4LABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam5(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isEngineParam5Dirty() : !pSDEViewEngine.isEngineParam5Dirty()) {
            return null;
        }
        Integer n = pSDEViewEngine.getEngineParam5();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EngineParam5_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM5");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam5Flag(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isEngineParam5FlagDirty() : !pSDEViewEngine.isEngineParam5FlagDirty()) {
            return null;
        }
        Integer n = pSDEViewEngine.getEngineParam5Flag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EngineParam5Flag_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM5FLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam5Label(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isEngineParam5LabelDirty() : !pSDEViewEngine.isEngineParam5LabelDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getEngineParam5Label();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EngineParam5Label_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM5LABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam6(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isEngineParam6Dirty() : !pSDEViewEngine.isEngineParam6Dirty()) {
            return null;
        }
        Integer n = pSDEViewEngine.getEngineParam6();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EngineParam6_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM6");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam6Flag(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isEngineParam6FlagDirty() : !pSDEViewEngine.isEngineParam6FlagDirty()) {
            return null;
        }
        Integer n = pSDEViewEngine.getEngineParam6Flag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EngineParam6Flag_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM6FLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam6Label(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isEngineParam6LabelDirty() : !pSDEViewEngine.isEngineParam6LabelDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getEngineParam6Label();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EngineParam6Label_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM6LABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam7(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isEngineParam7Dirty() : !pSDEViewEngine.isEngineParam7Dirty()) {
            return null;
        }
        Integer n = pSDEViewEngine.getEngineParam7();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EngineParam7_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM7");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam7Flag(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isEngineParam7FlagDirty() : !pSDEViewEngine.isEngineParam7FlagDirty()) {
            return null;
        }
        Integer n = pSDEViewEngine.getEngineParam7Flag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EngineParam7Flag_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM7FLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam7Label(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isEngineParam7LabelDirty() : !pSDEViewEngine.isEngineParam7LabelDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getEngineParam7Label();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EngineParam7Label_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM7LABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam8(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isEngineParam8Dirty() : !pSDEViewEngine.isEngineParam8Dirty()) {
            return null;
        }
        Integer n = pSDEViewEngine.getEngineParam8();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EngineParam8_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM8");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam8Flag(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isEngineParam8FlagDirty() : !pSDEViewEngine.isEngineParam8FlagDirty()) {
            return null;
        }
        Integer n = pSDEViewEngine.getEngineParam8Flag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EngineParam8Flag_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM8FLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam8Label(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isEngineParam8LabelDirty() : !pSDEViewEngine.isEngineParam8LabelDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getEngineParam8Label();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EngineParam8Label_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM8LABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam9(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isEngineParam9Dirty() : !pSDEViewEngine.isEngineParam9Dirty()) {
            return null;
        }
        Integer n = pSDEViewEngine.getEngineParam9();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EngineParam9_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM9");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam9Flag(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isEngineParam9FlagDirty() : !pSDEViewEngine.isEngineParam9FlagDirty()) {
            return null;
        }
        Integer n = pSDEViewEngine.getEngineParam9Flag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EngineParam9Flag_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM9FLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam9Label(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isEngineParam9LabelDirty() : !pSDEViewEngine.isEngineParam9LabelDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getEngineParam9Label();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EngineParam9Label_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM9LABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParamFlag(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isEngineParamFlagDirty() : !pSDEViewEngine.isEngineParamFlagDirty()) {
            return null;
        }
        Integer n = pSDEViewEngine.getEngineParamFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EngineParamFlag_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAMFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParamLabel(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isEngineParamLabelDirty() : !pSDEViewEngine.isEngineParamLabelDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getEngineParamLabel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EngineParamLabel_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAMLABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isMemoDirty() : !pSDEViewEngine.isMemoDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDEViewEngine, bl2, bl3);
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

    protected EntityFieldError onCheckField_No2DEViewCtrlFlag(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isNo2DEViewCtrlFlagDirty() : !pSDEViewEngine.isNo2DEViewCtrlFlagDirty()) {
            return null;
        }
        Integer n = pSDEViewEngine.getNo2DEViewCtrlFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_No2DEViewCtrlFlag_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO2DEVIEWCTRLFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No2DEViewCtrlLabel(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isNo2DEViewCtrlLabelDirty() : !pSDEViewEngine.isNo2DEViewCtrlLabelDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getNo2DEViewCtrlLabel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No2DEViewCtrlLabel_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO2DEVIEWCTRLLABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No2DEViewLogicFlag(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isNo2DEViewLogicFlagDirty() : !pSDEViewEngine.isNo2DEViewLogicFlagDirty()) {
            return null;
        }
        Integer n = pSDEViewEngine.getNo2DEViewLogicFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_No2DEViewLogicFlag_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO2DEVIEWLOGICFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No2DEViewLogicLabel(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isNo2DEViewLogicLabelDirty() : !pSDEViewEngine.isNo2DEViewLogicLabelDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getNo2DEViewLogicLabel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No2DEViewLogicLabel_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO2DEVIEWLOGICLABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No2PSDEViewCtrlId(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isNo2PSDEViewCtrlIdDirty() : !pSDEViewEngine.isNo2PSDEViewCtrlIdDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getNo2PSDEViewCtrlId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No2PSDEViewCtrlId_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO2PSDEVIEWCTRLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No2PSDEViewCtrlName(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isNo2PSDEViewCtrlNameDirty() : !pSDEViewEngine.isNo2PSDEViewCtrlNameDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getNo2PSDEViewCtrlName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No2PSDEViewCtrlName_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO2PSDEVIEWCTRLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No2PSDEViewLogicId(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isNo2PSDEViewLogicIdDirty() : !pSDEViewEngine.isNo2PSDEViewLogicIdDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getNo2PSDEViewLogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No2PSDEViewLogicId_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO2PSDEVIEWLOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No2PSDEViewLogicName(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isNo2PSDEViewLogicNameDirty() : !pSDEViewEngine.isNo2PSDEViewLogicNameDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getNo2PSDEViewLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No2PSDEViewLogicName_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO2PSDEVIEWLOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No3DEViewCtrlFlag(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isNo3DEViewCtrlFlagDirty() : !pSDEViewEngine.isNo3DEViewCtrlFlagDirty()) {
            return null;
        }
        Integer n = pSDEViewEngine.getNo3DEViewCtrlFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_No3DEViewCtrlFlag_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO3DEVIEWCTRLFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No3DEViewCtrlLabel(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isNo3DEViewCtrlLabelDirty() : !pSDEViewEngine.isNo3DEViewCtrlLabelDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getNo3DEViewCtrlLabel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No3DEViewCtrlLabel_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO3DEVIEWCTRLLABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No3DEViewLogicFlag(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isNo3DEViewLogicFlagDirty() : !pSDEViewEngine.isNo3DEViewLogicFlagDirty()) {
            return null;
        }
        Integer n = pSDEViewEngine.getNo3DEViewLogicFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_No3DEViewLogicFlag_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO3DEVIEWLOGICFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No3DEViewLogicLabel(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isNo3DEViewLogicLabelDirty() : !pSDEViewEngine.isNo3DEViewLogicLabelDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getNo3DEViewLogicLabel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No3DEViewLogicLabel_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO3DEVIEWLOGICLABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No3PSDEViewCtrlId(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isNo3PSDEViewCtrlIdDirty() : !pSDEViewEngine.isNo3PSDEViewCtrlIdDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getNo3PSDEViewCtrlId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No3PSDEViewCtrlId_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO3PSDEVIEWCTRLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No3PSDEViewCtrlName(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isNo3PSDEViewCtrlNameDirty() : !pSDEViewEngine.isNo3PSDEViewCtrlNameDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getNo3PSDEViewCtrlName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No3PSDEViewCtrlName_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO3PSDEVIEWCTRLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No3PSDEViewLogicId(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isNo3PSDEViewLogicIdDirty() : !pSDEViewEngine.isNo3PSDEViewLogicIdDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getNo3PSDEViewLogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No3PSDEViewLogicId_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO3PSDEVIEWLOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No3PSDEViewLogicName(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isNo3PSDEViewLogicNameDirty() : !pSDEViewEngine.isNo3PSDEViewLogicNameDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getNo3PSDEViewLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No3PSDEViewLogicName_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO3PSDEVIEWLOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No4DEViewCtrlFlag(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isNo4DEViewCtrlFlagDirty() : !pSDEViewEngine.isNo4DEViewCtrlFlagDirty()) {
            return null;
        }
        Integer n = pSDEViewEngine.getNo4DEViewCtrlFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_No4DEViewCtrlFlag_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO4DEVIEWCTRLFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No4DEViewCtrlLabel(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isNo4DEViewCtrlLabelDirty() : !pSDEViewEngine.isNo4DEViewCtrlLabelDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getNo4DEViewCtrlLabel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No4DEViewCtrlLabel_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO4DEVIEWCTRLLABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No4DEViewLogicFlag(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isNo4DEViewLogicFlagDirty() : !pSDEViewEngine.isNo4DEViewLogicFlagDirty()) {
            return null;
        }
        Integer n = pSDEViewEngine.getNo4DEViewLogicFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_No4DEViewLogicFlag_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO4DEVIEWLOGICFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No4DEViewLogicLabel(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isNo4DEViewLogicLabelDirty() : !pSDEViewEngine.isNo4DEViewLogicLabelDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getNo4DEViewLogicLabel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No4DEViewLogicLabel_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO4DEVIEWLOGICLABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No4PSDEViewCtrlId(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isNo4PSDEViewCtrlIdDirty() : !pSDEViewEngine.isNo4PSDEViewCtrlIdDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getNo4PSDEViewCtrlId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No4PSDEViewCtrlId_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO4PSDEVIEWCTRLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No4PSDEViewCtrlName(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isNo4PSDEViewCtrlNameDirty() : !pSDEViewEngine.isNo4PSDEViewCtrlNameDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getNo4PSDEViewCtrlName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No4PSDEViewCtrlName_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO4PSDEVIEWCTRLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No4PSDEViewLogicId(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isNo4PSDEViewLogicIdDirty() : !pSDEViewEngine.isNo4PSDEViewLogicIdDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getNo4PSDEViewLogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No4PSDEViewLogicId_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO4PSDEVIEWLOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No4PSDEViewLogicName(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isNo4PSDEViewLogicNameDirty() : !pSDEViewEngine.isNo4PSDEViewLogicNameDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getNo4PSDEViewLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No4PSDEViewLogicName_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO4PSDEVIEWLOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isOrderValueDirty() : !pSDEViewEngine.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDEViewEngine.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSDEViewEngine, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEViewBaseId(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isPSDEViewBaseIdDirty() && !bl2 : !pSDEViewEngine.isPSDEViewBaseIdDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getPSDEViewBaseId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWBASEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewBaseId_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWBASEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEViewCtrlId(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isPSDEViewCtrlIdDirty() : !pSDEViewEngine.isPSDEViewCtrlIdDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getPSDEViewCtrlId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewCtrlId_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWCTRLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEViewCtrlName(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isPSDEViewCtrlNameDirty() : !pSDEViewEngine.isPSDEViewCtrlNameDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getPSDEViewCtrlName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewCtrlName_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWCTRLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEViewEngineId(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isPSDEViewEngineIdDirty() && !bl2 : !pSDEViewEngine.isPSDEViewEngineIdDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getPSDEViewEngineId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWENGINEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewEngineId_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWENGINEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEViewEngineName(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isPSDEViewEngineNameDirty() && !bl2 : !pSDEViewEngine.isPSDEViewEngineNameDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getPSDEViewEngineName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWENGINENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewEngineName_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWENGINENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (string == null) {
                bl4 = false;
            }
            if (bl4) {
                String string3 = "";
                string3 = "PSDEVIEWBASEID";
                String string4 = this.checkFieldDupRule(this.getPSDEViewEngineDEModel(), "PSDEVIEWENGINENAME", string3, pSDEViewEngine, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEVIEWENGINENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEViewLogicId(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isPSDEViewLogicIdDirty() : !pSDEViewEngine.isPSDEViewLogicIdDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getPSDEViewLogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewLogicId_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWLOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEViewLogicName(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isPSDEViewLogicNameDirty() : !pSDEViewEngine.isPSDEViewLogicNameDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getPSDEViewLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewLogicName_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWLOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isPSSysPFPluginIdDirty() : !pSDEViewEngine.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSPFPLUGINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSUIEngineTypeId(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isPSUIEngineTypeIdDirty() && !bl2 : !pSDEViewEngine.isPSUIEngineTypeIdDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getPSUIEngineTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUIENGINETYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSUIEngineTypeId_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUIENGINETYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSUIEngineTypeName(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isPSUIEngineTypeNameDirty() : !pSDEViewEngine.isPSUIEngineTypeNameDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getPSUIEngineTypeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSUIEngineTypeName_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUIENGINETYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isUserCatDirty() : !pSDEViewEngine.isUserCatDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDEViewEngine, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isUserTagDirty() : !pSDEViewEngine.isUserTagDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDEViewEngine, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isUserTag2Dirty() : !pSDEViewEngine.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEViewEngine.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDEViewEngine, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isUserTag3Dirty() : !pSDEViewEngine.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEViewEngine.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDEViewEngine, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isUserTag4Dirty() : !pSDEViewEngine.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEViewEngine.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDEViewEngine, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isValidFlagDirty() && !bl2 : !pSDEViewEngine.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDEViewEngine.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDEViewEngine, bl2, bl3);
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

    protected EntityFieldError onCheckField_ViewParam(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isViewParamDirty() : !pSDEViewEngine.isViewParamDirty()) {
            return null;
        }
        String string = pSDEViewEngine.getViewParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ViewParam_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewParam10(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isViewParam10Dirty() : !pSDEViewEngine.isViewParam10Dirty()) {
            return null;
        }
        Integer n = pSDEViewEngine.getViewParam10();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ViewParam10_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAM10");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewParam2(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isViewParam2Dirty() : !pSDEViewEngine.isViewParam2Dirty()) {
            return null;
        }
        String string = pSDEViewEngine.getViewParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ViewParam2_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewParam3(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isViewParam3Dirty() : !pSDEViewEngine.isViewParam3Dirty()) {
            return null;
        }
        Integer n = pSDEViewEngine.getViewParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ViewParam3_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAM3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewParam4(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isViewParam4Dirty() : !pSDEViewEngine.isViewParam4Dirty()) {
            return null;
        }
        Integer n = pSDEViewEngine.getViewParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ViewParam4_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAM4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewParam5(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isViewParam5Dirty() : !pSDEViewEngine.isViewParam5Dirty()) {
            return null;
        }
        Integer n = pSDEViewEngine.getViewParam5();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ViewParam5_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAM5");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewParam6(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isViewParam6Dirty() : !pSDEViewEngine.isViewParam6Dirty()) {
            return null;
        }
        Integer n = pSDEViewEngine.getViewParam6();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ViewParam6_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAM6");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewParam7(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isViewParam7Dirty() : !pSDEViewEngine.isViewParam7Dirty()) {
            return null;
        }
        String string = pSDEViewEngine.getViewParam7();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ViewParam7_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAM7");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewParam8(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isViewParam8Dirty() : !pSDEViewEngine.isViewParam8Dirty()) {
            return null;
        }
        String string = pSDEViewEngine.getViewParam8();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ViewParam8_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAM8");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewParam9(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isViewParam9Dirty() : !pSDEViewEngine.isViewParam9Dirty()) {
            return null;
        }
        Integer n = pSDEViewEngine.getViewParam9();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ViewParam9_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAM9");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFViewParam(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isWFViewParamDirty() : !pSDEViewEngine.isWFViewParamDirty()) {
            return null;
        }
        Integer n = pSDEViewEngine.getWFViewParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_WFViewParam_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFVIEWPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFViewParam2(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isWFViewParam2Dirty() : !pSDEViewEngine.isWFViewParam2Dirty()) {
            return null;
        }
        Integer n = pSDEViewEngine.getWFViewParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_WFViewParam2_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFVIEWPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFViewParam3(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isWFViewParam3Dirty() : !pSDEViewEngine.isWFViewParam3Dirty()) {
            return null;
        }
        String string = pSDEViewEngine.getWFViewParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFViewParam3_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFVIEWPARAM3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFViewParam4(boolean bl, PSDEViewEngine pSDEViewEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewEngine.isWFViewParam4Dirty() : !pSDEViewEngine.isWFViewParam4Dirty()) {
            return null;
        }
        String string = pSDEViewEngine.getWFViewParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFViewParam4_Default(pSDEViewEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFVIEWPARAM4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDEViewEngine pSDEViewEngine, boolean bl) throws Exception {
        super.onSyncEntity(pSDEViewEngine, bl);
    }

    protected void onSyncIndexEntities(PSDEViewEngine pSDEViewEngine, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEViewEngine, bl);
    }

    public Object getDataContextValue(PSDEViewEngine pSDEViewEngine, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDEViewEngine, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEViewBase pSDEViewBase = pSDEViewEngine.getPSDEViewBase();
        if (pSDEViewBase != null && pSDEViewBase.contains(string)) {
            return pSDEViewBase.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEViewEngine pSDEViewEngine, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDEViewEngine, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEVIEWCTRLFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEViewCtrlFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEVIEWCTRLLABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEViewCtrlLabel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEVIEWLOGICFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEViewLogicFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEVIEWLOGICLABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEViewLogicLabel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEOPTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineOption_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM10", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam10_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM10FLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam10Flag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM10LABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam10Label_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM2FLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam2Flag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM2LABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam2Label_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM3FLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam3Flag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM3LABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam3Label_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM4FLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam4Flag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM4LABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam4Label_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM5", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam5_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM5FLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam5Flag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM5LABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam5Label_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM6", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam6_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM6FLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam6Flag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM6LABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam6Label_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM7", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam7_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM7FLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam7Flag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM7LABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam7Label_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM8", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam8_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM8FLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam8Flag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM8LABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam8Label_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM9", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam9_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM9FLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam9Flag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM9LABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam9Label_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAMFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParamFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAMLABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParamLabel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO2DEVIEWCTRLFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No2DEViewCtrlFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO2DEVIEWCTRLLABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No2DEViewCtrlLabel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO2DEVIEWLOGICFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No2DEViewLogicFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO2DEVIEWLOGICLABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No2DEViewLogicLabel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO2PSDEVIEWCTRLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No2PSDEViewCtrlId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO2PSDEVIEWCTRLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No2PSDEViewCtrlName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO2PSDEVIEWLOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No2PSDEViewLogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO2PSDEVIEWLOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No2PSDEViewLogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO3DEVIEWCTRLFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No3DEViewCtrlFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO3DEVIEWCTRLLABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No3DEViewCtrlLabel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO3DEVIEWLOGICFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No3DEViewLogicFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO3DEVIEWLOGICLABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No3DEViewLogicLabel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO3PSDEVIEWCTRLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No3PSDEViewCtrlId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO3PSDEVIEWCTRLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No3PSDEViewCtrlName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO3PSDEVIEWLOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No3PSDEViewLogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO3PSDEVIEWLOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No3PSDEViewLogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO4DEVIEWCTRLFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No4DEViewCtrlFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO4DEVIEWCTRLLABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No4DEViewCtrlLabel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO4DEVIEWLOGICFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No4DEViewLogicFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO4DEVIEWLOGICLABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No4DEViewLogicLabel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO4PSDEVIEWCTRLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No4PSDEViewCtrlId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO4PSDEVIEWCTRLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No4PSDEViewCtrlName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO4PSDEVIEWLOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No4PSDEViewLogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO4PSDEVIEWLOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No4PSDEViewLogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWBASEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewBaseId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWBASENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewBaseName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWCTRLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewCtrlId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWCTRLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewCtrlName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWENGINEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewEngineId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWENGINENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewEngineName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWLOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewLogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWLOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewLogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUIENGINETYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUIEngineTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUIENGINETYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUIEngineTypeName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAM10", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParam10_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAM3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParam3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAM4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParam4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAM5", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParam5_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAM6", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParam6_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAM7", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParam7_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAM8", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParam8_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAM9", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParam9_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFVIEWPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFViewParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFVIEWPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFViewParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFVIEWPARAM3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFViewParam3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFVIEWPARAM4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFViewParam4_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DEViewCtrlFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DEViewCtrlLabel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEVIEWCTRLLABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DEViewLogicFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DEViewLogicLabel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEVIEWLOGICLABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EngineOption_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENGINEOPTION", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EngineParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENGINEPARAM", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EngineParam10_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EngineParam10Flag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EngineParam10Label_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENGINEPARAM10LABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EngineParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENGINEPARAM2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EngineParam2Flag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EngineParam2Label_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENGINEPARAM2LABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EngineParam3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENGINEPARAM3", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EngineParam3Flag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EngineParam3Label_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENGINEPARAM3LABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EngineParam4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENGINEPARAM4", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EngineParam4Flag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EngineParam4Label_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENGINEPARAM4LABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EngineParam5_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EngineParam5Flag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EngineParam5Label_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENGINEPARAM5LABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EngineParam6_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EngineParam6Flag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EngineParam6Label_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENGINEPARAM6LABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EngineParam7_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EngineParam7Flag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EngineParam7Label_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENGINEPARAM7LABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EngineParam8_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EngineParam8Flag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EngineParam8Label_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENGINEPARAM8LABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EngineParam9_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EngineParam9Flag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EngineParam9Label_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENGINEPARAM9LABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EngineParamFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EngineParamLabel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENGINEPARAMLABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
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

    protected String onTestValueRule_No2DEViewCtrlFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_No2DEViewCtrlLabel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO2DEVIEWCTRLLABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No2DEViewLogicFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_No2DEViewLogicLabel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO2DEVIEWLOGICLABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No2PSDEViewCtrlId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO2PSDEVIEWCTRLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No2PSDEViewCtrlName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO2PSDEVIEWCTRLNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No2PSDEViewLogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO2PSDEVIEWLOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No2PSDEViewLogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO2PSDEVIEWLOGICNAME", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No3DEViewCtrlFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_No3DEViewCtrlLabel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO3DEVIEWCTRLLABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No3DEViewLogicFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_No3DEViewLogicLabel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO3DEVIEWLOGICLABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No3PSDEViewCtrlId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO3PSDEVIEWCTRLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No3PSDEViewCtrlName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO3PSDEVIEWCTRLNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No3PSDEViewLogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO3PSDEVIEWLOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No3PSDEViewLogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO3PSDEVIEWLOGICNAME", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No4DEViewCtrlFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_No4DEViewCtrlLabel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO4DEVIEWCTRLLABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No4DEViewLogicFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_No4DEViewLogicLabel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO4DEVIEWLOGICLABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No4PSDEViewCtrlId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO4PSDEVIEWCTRLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No4PSDEViewCtrlName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO4PSDEVIEWCTRLNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No4PSDEViewLogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO4PSDEVIEWLOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No4PSDEViewLogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO4PSDEVIEWLOGICNAME", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDEViewBaseId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWBASEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEViewBaseName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWBASENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEViewCtrlId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWCTRLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEViewCtrlName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWCTRLNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEViewEngineId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWENGINEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEViewEngineName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWENGINENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false) && this.checkFieldRegExRule("PSDEVIEWENGINENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEViewLogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWLOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEViewLogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWLOGICNAME", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysPFPluginId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSPFPLUGINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysPFPluginName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSPFPLUGINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSUIEngineTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSUIENGINETYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSUIEngineTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSUIENGINETYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ViewParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEWPARAM", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ViewParam10_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ViewParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEWPARAM2", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ViewParam3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ViewParam4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ViewParam5_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ViewParam6_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ViewParam7_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEWPARAM7", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ViewParam8_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEWPARAM8", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ViewParam9_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_WFViewParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_WFViewParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_WFViewParam3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFVIEWPARAM3", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFViewParam4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFVIEWPARAM4", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDEViewEngine pSDEViewEngine) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEViewEngine)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEViewEngine pSDEViewEngine) throws Exception {
        super.onUpdateParent(pSDEViewEngine);
    }

    @Override
    protected void exportCurXmlModel(PSDEViewEngine pSDEViewEngine, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVIEWENGINE");
        if (!bl) {
            pSDEViewEngine.setCreateDate(null);
            pSDEViewEngine.setCreateMan(null);
            pSDEViewEngine.setPSDEViewBaseName(null);
            pSDEViewEngine.setPSDEViewEngineId(null);
            pSDEViewEngine.setUpdateDate(null);
            pSDEViewEngine.setUpdateMan(null);
            pSDEViewEngine.setNo2PSDEViewCtrlId(null);
            pSDEViewEngine.setNo3PSDEViewCtrlId(null);
            pSDEViewEngine.setNo4PSDEViewCtrlId(null);
            pSDEViewEngine.setPSDEViewCtrlId(null);
            pSDEViewEngine.setNo2PSDEViewLogicId(null);
            pSDEViewEngine.setNo3PSDEViewLogicId(null);
            pSDEViewEngine.setNo4PSDEViewLogicId(null);
            pSDEViewEngine.setPSDEViewLogicId(null);
            pSDEViewEngine.setPSDEViewBaseId(null);
            pSDEViewEngine.setPSDEViewBaseName(null);
            super.exportCurXmlModel(pSDEViewEngine, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEViewEngine pSDEViewEngine, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEViewEngine, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEVIEWBASEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEVIEWBASE#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEVIEWBASEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEVIEWENGINE_PSDEVIEWBASE_PSDEVIEWBASEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEVIEWBASEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEVIEWBASENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDEVIEWBASE", (boolean)true) == 0) {
            iEntity.set("PSDEVIEWBASEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDEVIEWBASEID"};
    }

    @Override
    public String getModelV2Tag(PSDEViewEngine pSDEViewEngine) {
        if (!StringHelper.isNullOrEmpty((String)pSDEViewEngine.getPSDEViewEngineName())) {
            return pSDEViewEngine.getPSDEViewEngineName();
        }
        return super.getModelV2Tag(pSDEViewEngine);
    }

    @Override
    public boolean setModelV2Tag(PSDEViewEngine pSDEViewEngine, String string) {
        pSDEViewEngine.setPSDEViewEngineName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDEVIEWENGINENAME", "");
        map.put("PSDEVIEWBASEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEViewEngine pSDEViewEngine, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEViewEngine.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEViewEngine, true);
        pSDEViewEngine.set("PSDEVIEWENGINENAME", string);
        if (this.select(pSDEViewEngine, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEViewEngine, true);
        return super.getModelV2Entity(pSDEViewEngine, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEViewEngine pSDEViewEngine, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSDEViewEngine, objectNode, string, string2, n);
    }
}

