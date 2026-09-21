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
package net.ibizsys.pscore.srv.sysdesign.service;

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
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeServiceBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysUniStateDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysUniStateDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniState;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUtilDE;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUtilDEBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysUniStateServiceBase
extends PSCoreSysServiceBase<PSSysUniState> {
    private static final Log log = LogFactory.getLog(PSSysUniStateServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSSysUniStateDEModel pSSysUniStateDEModel;
    private PSSysUniStateDAO pSSysUniStateDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysUniStateService";
    }

    public PSSysUniStateDEModel getPSSysUniStateDEModel() {
        if (this.pSSysUniStateDEModel == null) {
            try {
                this.pSSysUniStateDEModel = (PSSysUniStateDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysUniStateDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysUniStateDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysUniStateDEModel();
    }

    public PSSysUniStateDAO getPSSysUniStateDAO() {
        if (this.pSSysUniStateDAO == null) {
            try {
                this.pSSysUniStateDAO = (PSSysUniStateDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysUniStateDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysUniStateDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysUniStateDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSysUniState pSSysUniState, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUNISTATE_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSSysUniState, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUNISTATE_PSDEDATASET_PSDEDATASETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataSet);
            } else {
                iService.get((IEntity)pSDEDataSet);
            }
            this.onFillParentInfo_PSDEDataSet(pSSysUniState, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUNISTATE_PSDEFIELD_KEY2PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_Key2PSDEF(pSSysUniState, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUNISTATE_PSDEFIELD_KEY3PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_Key3PSDEF(pSSysUniState, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUNISTATE_PSDEFIELD_KEY4PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_Key4PSDEF(pSSysUniState, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUNISTATE_PSDEFIELD_KEY5PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_Key5PSDEF(pSSysUniState, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUNISTATE_PSDEFIELD_KEY6PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_Key6PSDEF(pSSysUniState, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUNISTATE_PSDEFIELD_KEY7PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_Key7PSDEF(pSSysUniState, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUNISTATE_PSDEFIELD_KEY8PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_Key8PSDEF(pSSysUniState, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUNISTATE_PSDEFIELD_KEY9PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_Key9PSDEF(pSSysUniState, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUNISTATE_PSDEFIELD_KEYPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_KeyPSDEF(pSSysUniState, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUNISTATE_PSDEFIELD_STATE2PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_State2PSDEF(pSSysUniState, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUNISTATE_PSDEFIELD_STATE3PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_State3PSDEF(pSSysUniState, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUNISTATE_PSDEFIELD_STATE4PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_State4PSDEF(pSSysUniState, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUNISTATE_PSDEFIELD_STATE5PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_State5PSDEF(pSSysUniState, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUNISTATE_PSDEFIELD_STATE6PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_State6PSDEF(pSSysUniState, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUNISTATE_PSDEFIELD_STATE7PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_State7PSDEF(pSSysUniState, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUNISTATE_PSDEFIELD_STATE8PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_State8PSDEF(pSSysUniState, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUNISTATE_PSDEFIELD_STATEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_StatePSDEF(pSSysUniState, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUNISTATE_PSDELOGIC_INITPSDELOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDELogic);
            } else {
                iService.get((IEntity)pSDELogic);
            }
            this.onFillParentInfo_InitPSDELogic(pSSysUniState, pSDELogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUNISTATE_PSDELOGIC_ONCHANGEPSDELOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDELogic);
            } else {
                iService.get((IEntity)pSDELogic);
            }
            this.onFillParentInfo_OnChangePSDELogic(pSSysUniState, pSDELogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUNISTATE_PSDELOGIC_ONDELETEPSDELOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDELogic);
            } else {
                iService.get((IEntity)pSDELogic);
            }
            this.onFillParentInfo_OnDeletePSDELogic(pSSysUniState, pSDELogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUNISTATE_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSModule);
            } else {
                iService.get((IEntity)pSModule);
            }
            this.onFillParentInfo_PSModule(pSSysUniState, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUNISTATE_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysSFPlugin);
            } else {
                iService.get((IEntity)pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSSysUniState, pSSysSFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUNISTATE_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystem);
            } else {
                iService.get((IEntity)pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysUniState, pSSystem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUNISTATE_PSSYSUTILDE_PSSYSUTILDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUtilDEService", (SessionFactory)this.getSessionFactory());
            PSSysUtilDE pSSysUtilDE = (PSSysUtilDE)iService.getDEModel().createEntity();
            pSSysUtilDE.set("PSSYSUTILDEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysUtilDE);
            } else {
                iService.get((IEntity)pSSysUtilDE);
            }
            this.onFillParentInfo_PSSysUtilDE(pSSysUniState, pSSysUtilDE);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysUniState, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSSysUniState pSSysUniState, PSDataEntity pSDataEntity) throws Exception {
        pSSysUniState.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSSysUniState.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDEDataSet(PSSysUniState pSSysUniState, PSDEDataSet pSDEDataSet) throws Exception {
        pSSysUniState.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
        pSSysUniState.setPSDEDataSetName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_Key2PSDEF(PSSysUniState pSSysUniState, PSDEField pSDEField) throws Exception {
        pSSysUniState.setKey2PSDEFId(pSDEField.getPSDEFieldId());
        pSSysUniState.setKey2PSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_Key3PSDEF(PSSysUniState pSSysUniState, PSDEField pSDEField) throws Exception {
        pSSysUniState.setKey3PSDEFId(pSDEField.getPSDEFieldId());
        pSSysUniState.setKey3PSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_Key4PSDEF(PSSysUniState pSSysUniState, PSDEField pSDEField) throws Exception {
        pSSysUniState.setKey4PSDEFId(pSDEField.getPSDEFieldId());
        pSSysUniState.setKey4PSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_Key5PSDEF(PSSysUniState pSSysUniState, PSDEField pSDEField) throws Exception {
        pSSysUniState.setKey5PSDEFId(pSDEField.getPSDEFieldId());
        pSSysUniState.setKey5PSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_Key6PSDEF(PSSysUniState pSSysUniState, PSDEField pSDEField) throws Exception {
        pSSysUniState.setKey6PSDEFId(pSDEField.getPSDEFieldId());
        pSSysUniState.setKey6PSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_Key7PSDEF(PSSysUniState pSSysUniState, PSDEField pSDEField) throws Exception {
        pSSysUniState.setKey7PSDEFId(pSDEField.getPSDEFieldId());
        pSSysUniState.setKey7PSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_Key8PSDEF(PSSysUniState pSSysUniState, PSDEField pSDEField) throws Exception {
        pSSysUniState.setKey8PSDEFId(pSDEField.getPSDEFieldId());
        pSSysUniState.setKey8PSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_Key9PSDEF(PSSysUniState pSSysUniState, PSDEField pSDEField) throws Exception {
        pSSysUniState.setKey9PSDEFId(pSDEField.getPSDEFieldId());
        pSSysUniState.setKey9PSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_KeyPSDEF(PSSysUniState pSSysUniState, PSDEField pSDEField) throws Exception {
        pSSysUniState.setKeyPSDEFId(pSDEField.getPSDEFieldId());
        pSSysUniState.setKeyPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_State2PSDEF(PSSysUniState pSSysUniState, PSDEField pSDEField) throws Exception {
        pSSysUniState.setState2PSDEFId(pSDEField.getPSDEFieldId());
        pSSysUniState.setState2PSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_State3PSDEF(PSSysUniState pSSysUniState, PSDEField pSDEField) throws Exception {
        pSSysUniState.setState3PSDEFId(pSDEField.getPSDEFieldId());
        pSSysUniState.setState3PSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_State4PSDEF(PSSysUniState pSSysUniState, PSDEField pSDEField) throws Exception {
        pSSysUniState.setState4PSDEFId(pSDEField.getPSDEFieldId());
        pSSysUniState.setState4PSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_State5PSDEF(PSSysUniState pSSysUniState, PSDEField pSDEField) throws Exception {
        pSSysUniState.setState5PSDEFId(pSDEField.getPSDEFieldId());
        pSSysUniState.setState5PSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_State6PSDEF(PSSysUniState pSSysUniState, PSDEField pSDEField) throws Exception {
        pSSysUniState.setState6PSDEFId(pSDEField.getPSDEFieldId());
        pSSysUniState.setState6PSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_State7PSDEF(PSSysUniState pSSysUniState, PSDEField pSDEField) throws Exception {
        pSSysUniState.setState7PSDEFId(pSDEField.getPSDEFieldId());
        pSSysUniState.setState7PSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_State8PSDEF(PSSysUniState pSSysUniState, PSDEField pSDEField) throws Exception {
        pSSysUniState.setState8PSDEFId(pSDEField.getPSDEFieldId());
        pSSysUniState.setState8PSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_StatePSDEF(PSSysUniState pSSysUniState, PSDEField pSDEField) throws Exception {
        pSSysUniState.setStatePSDEFId(pSDEField.getPSDEFieldId());
        pSSysUniState.setStatePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_InitPSDELogic(PSSysUniState pSSysUniState, PSDELogic pSDELogic) throws Exception {
        pSSysUniState.setInitPSDELogicId(pSDELogic.getPSDELogicId());
        pSSysUniState.setInitPSDELogicName(pSDELogic.getPSDELogicName());
    }

    protected void onFillParentInfo_OnChangePSDELogic(PSSysUniState pSSysUniState, PSDELogic pSDELogic) throws Exception {
        pSSysUniState.setOnChangePSDELogicId(pSDELogic.getPSDELogicId());
        pSSysUniState.setOnChangePSDELogicName(pSDELogic.getPSDELogicName());
    }

    protected void onFillParentInfo_OnDeletePSDELogic(PSSysUniState pSSysUniState, PSDELogic pSDELogic) throws Exception {
        pSSysUniState.setOnDeletePSDELogicId(pSDELogic.getPSDELogicId());
        pSSysUniState.setOnDeletePSDELogicName(pSDELogic.getPSDELogicName());
    }

    protected void onFillParentInfo_PSModule(PSSysUniState pSSysUniState, PSModule pSModule) throws Exception {
        pSSysUniState.setPSModuleId(pSModule.getPSModuleId());
        pSSysUniState.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSSysUniState pSSysUniState, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSSysUniState.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSSysUniState.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillParentInfo_PSSystem(PSSysUniState pSSysUniState, PSSystem pSSystem) throws Exception {
        pSSysUniState.setPSSystemId(pSSystem.getPSSystemId());
        pSSysUniState.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillParentInfo_PSSysUtilDE(PSSysUniState pSSysUniState, PSSysUtilDE pSSysUtilDE) throws Exception {
        pSSysUniState.setPSSysUtilDEId(pSSysUtilDE.getPSSysUtilDEId());
        pSSysUniState.setPSSysUtilDEName(pSSysUtilDE.getPSSysUtilDEName());
    }

    protected void onFillEntityFullInfo(PSSysUniState pSSysUniState, boolean bl) throws Exception {
        if (bl) {
            if (pSSysUniState.getPSSysUniStateName() == null) {
                pSSysUniState.setPSSysUniStateName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u72b6\u6001\u534f\u540c", 25));
            }
            if (pSSysUniState.getUniqueTag() == null) {
                pSSysUniState.setUniqueTag((String)this.getDefaultValue(this.getWebContext(), "USER", "UNISTATE", 25));
            }
            if (pSSysUniState.getUniStateType() == null) {
                pSSysUniState.setUniStateType((String)this.getDefaultValue(this.getWebContext(), "", "DE", 25));
            }
            if (pSSysUniState.getValidFlag() == null) {
                pSSysUniState.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSSysUniState, bl);
        this.onFillEntityFullInfo_PSDE(pSSysUniState, bl);
        this.onFillEntityFullInfo_PSDEDataSet(pSSysUniState, bl);
        this.onFillEntityFullInfo_Key2PSDEF(pSSysUniState, bl);
        this.onFillEntityFullInfo_Key3PSDEF(pSSysUniState, bl);
        this.onFillEntityFullInfo_Key4PSDEF(pSSysUniState, bl);
        this.onFillEntityFullInfo_Key5PSDEF(pSSysUniState, bl);
        this.onFillEntityFullInfo_Key6PSDEF(pSSysUniState, bl);
        this.onFillEntityFullInfo_Key7PSDEF(pSSysUniState, bl);
        this.onFillEntityFullInfo_Key8PSDEF(pSSysUniState, bl);
        this.onFillEntityFullInfo_Key9PSDEF(pSSysUniState, bl);
        this.onFillEntityFullInfo_KeyPSDEF(pSSysUniState, bl);
        this.onFillEntityFullInfo_State2PSDEF(pSSysUniState, bl);
        this.onFillEntityFullInfo_State3PSDEF(pSSysUniState, bl);
        this.onFillEntityFullInfo_State4PSDEF(pSSysUniState, bl);
        this.onFillEntityFullInfo_State5PSDEF(pSSysUniState, bl);
        this.onFillEntityFullInfo_State6PSDEF(pSSysUniState, bl);
        this.onFillEntityFullInfo_State7PSDEF(pSSysUniState, bl);
        this.onFillEntityFullInfo_State8PSDEF(pSSysUniState, bl);
        this.onFillEntityFullInfo_StatePSDEF(pSSysUniState, bl);
        this.onFillEntityFullInfo_InitPSDELogic(pSSysUniState, bl);
        this.onFillEntityFullInfo_OnChangePSDELogic(pSSysUniState, bl);
        this.onFillEntityFullInfo_OnDeletePSDELogic(pSSysUniState, bl);
        this.onFillEntityFullInfo_PSModule(pSSysUniState, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSSysUniState, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysUniState, bl);
        this.onFillEntityFullInfo_PSSysUtilDE(pSSysUniState, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSSysUniState pSSysUniState, boolean bl) throws Exception {
        if (pSSysUniState.isPSDEIdDirty()) {
            if (pSSysUniState.getPSDEId() != null) {
                if (pSSysUniState.getPSDEId() == null || pSSysUniState.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSSysUniState.getPSDE();
                    pSSysUniState.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysUniState.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEDataSet(PSSysUniState pSSysUniState, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_Key2PSDEF(PSSysUniState pSSysUniState, boolean bl) throws Exception {
        if (pSSysUniState.isKey2PSDEFIdDirty()) {
            if (pSSysUniState.getKey2PSDEFId() != null) {
                if (pSSysUniState.getKey2PSDEFId() == null || pSSysUniState.getKey2PSDEFName() == null) {
                    PSDEField pSDEField = pSSysUniState.getKey2PSDEF();
                    pSSysUniState.setKey2PSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysUniState.setKey2PSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_Key3PSDEF(PSSysUniState pSSysUniState, boolean bl) throws Exception {
        if (pSSysUniState.isKey3PSDEFIdDirty()) {
            if (pSSysUniState.getKey3PSDEFId() != null) {
                if (pSSysUniState.getKey3PSDEFId() == null || pSSysUniState.getKey3PSDEFName() == null) {
                    PSDEField pSDEField = pSSysUniState.getKey3PSDEF();
                    pSSysUniState.setKey3PSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysUniState.setKey3PSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_Key4PSDEF(PSSysUniState pSSysUniState, boolean bl) throws Exception {
        if (pSSysUniState.isKey4PSDEFIdDirty()) {
            if (pSSysUniState.getKey4PSDEFId() != null) {
                if (pSSysUniState.getKey4PSDEFId() == null || pSSysUniState.getKey4PSDEFName() == null) {
                    PSDEField pSDEField = pSSysUniState.getKey4PSDEF();
                    pSSysUniState.setKey4PSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysUniState.setKey4PSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_Key5PSDEF(PSSysUniState pSSysUniState, boolean bl) throws Exception {
        if (pSSysUniState.isKey5PSDEFIdDirty()) {
            if (pSSysUniState.getKey5PSDEFId() != null) {
                if (pSSysUniState.getKey5PSDEFId() == null || pSSysUniState.getKey5PSDEFName() == null) {
                    PSDEField pSDEField = pSSysUniState.getKey5PSDEF();
                    pSSysUniState.setKey5PSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysUniState.setKey5PSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_Key6PSDEF(PSSysUniState pSSysUniState, boolean bl) throws Exception {
        if (pSSysUniState.isKey6PSDEFIdDirty()) {
            if (pSSysUniState.getKey6PSDEFId() != null) {
                if (pSSysUniState.getKey6PSDEFId() == null || pSSysUniState.getKey6PSDEFName() == null) {
                    PSDEField pSDEField = pSSysUniState.getKey6PSDEF();
                    pSSysUniState.setKey6PSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysUniState.setKey6PSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_Key7PSDEF(PSSysUniState pSSysUniState, boolean bl) throws Exception {
        if (pSSysUniState.isKey7PSDEFIdDirty()) {
            if (pSSysUniState.getKey7PSDEFId() != null) {
                if (pSSysUniState.getKey7PSDEFId() == null || pSSysUniState.getKey7PSDEFName() == null) {
                    PSDEField pSDEField = pSSysUniState.getKey7PSDEF();
                    pSSysUniState.setKey7PSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysUniState.setKey7PSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_Key8PSDEF(PSSysUniState pSSysUniState, boolean bl) throws Exception {
        if (pSSysUniState.isKey8PSDEFIdDirty()) {
            if (pSSysUniState.getKey8PSDEFId() != null) {
                if (pSSysUniState.getKey8PSDEFId() == null || pSSysUniState.getKey8PSDEFName() == null) {
                    PSDEField pSDEField = pSSysUniState.getKey8PSDEF();
                    pSSysUniState.setKey8PSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysUniState.setKey8PSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_Key9PSDEF(PSSysUniState pSSysUniState, boolean bl) throws Exception {
        if (pSSysUniState.isKey9PSDEFIdDirty()) {
            if (pSSysUniState.getKey9PSDEFId() != null) {
                if (pSSysUniState.getKey9PSDEFId() == null || pSSysUniState.getKey9PSDEFName() == null) {
                    PSDEField pSDEField = pSSysUniState.getKey9PSDEF();
                    pSSysUniState.setKey9PSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysUniState.setKey9PSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_KeyPSDEF(PSSysUniState pSSysUniState, boolean bl) throws Exception {
        if (pSSysUniState.isKeyPSDEFIdDirty()) {
            if (pSSysUniState.getKeyPSDEFId() != null) {
                if (pSSysUniState.getKeyPSDEFId() == null || pSSysUniState.getKeyPSDEFName() == null) {
                    PSDEField pSDEField = pSSysUniState.getKeyPSDEF();
                    pSSysUniState.setKeyPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysUniState.setKeyPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_State2PSDEF(PSSysUniState pSSysUniState, boolean bl) throws Exception {
        if (pSSysUniState.isState2PSDEFIdDirty()) {
            if (pSSysUniState.getState2PSDEFId() != null) {
                if (pSSysUniState.getState2PSDEFId() == null || pSSysUniState.getState2PSDEFName() == null) {
                    PSDEField pSDEField = pSSysUniState.getState2PSDEF();
                    pSSysUniState.setState2PSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysUniState.setState2PSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_State3PSDEF(PSSysUniState pSSysUniState, boolean bl) throws Exception {
        if (pSSysUniState.isState3PSDEFIdDirty()) {
            if (pSSysUniState.getState3PSDEFId() != null) {
                if (pSSysUniState.getState3PSDEFId() == null || pSSysUniState.getState3PSDEFName() == null) {
                    PSDEField pSDEField = pSSysUniState.getState3PSDEF();
                    pSSysUniState.setState3PSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysUniState.setState3PSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_State4PSDEF(PSSysUniState pSSysUniState, boolean bl) throws Exception {
        if (pSSysUniState.isState4PSDEFIdDirty()) {
            if (pSSysUniState.getState4PSDEFId() != null) {
                if (pSSysUniState.getState4PSDEFId() == null || pSSysUniState.getState4PSDEFName() == null) {
                    PSDEField pSDEField = pSSysUniState.getState4PSDEF();
                    pSSysUniState.setState4PSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysUniState.setState4PSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_State5PSDEF(PSSysUniState pSSysUniState, boolean bl) throws Exception {
        if (pSSysUniState.isState5PSDEFIdDirty()) {
            if (pSSysUniState.getState5PSDEFId() != null) {
                if (pSSysUniState.getState5PSDEFId() == null || pSSysUniState.getState5PSDEFName() == null) {
                    PSDEField pSDEField = pSSysUniState.getState5PSDEF();
                    pSSysUniState.setState5PSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysUniState.setState5PSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_State6PSDEF(PSSysUniState pSSysUniState, boolean bl) throws Exception {
        if (pSSysUniState.isState6PSDEFIdDirty()) {
            if (pSSysUniState.getState6PSDEFId() != null) {
                if (pSSysUniState.getState6PSDEFId() == null || pSSysUniState.getState6PSDEFName() == null) {
                    PSDEField pSDEField = pSSysUniState.getState6PSDEF();
                    pSSysUniState.setState6PSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysUniState.setState6PSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_State7PSDEF(PSSysUniState pSSysUniState, boolean bl) throws Exception {
        if (pSSysUniState.isState7PSDEFIdDirty()) {
            if (pSSysUniState.getState7PSDEFId() != null) {
                if (pSSysUniState.getState7PSDEFId() == null || pSSysUniState.getState7PSDEFName() == null) {
                    PSDEField pSDEField = pSSysUniState.getState7PSDEF();
                    pSSysUniState.setState7PSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysUniState.setState7PSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_State8PSDEF(PSSysUniState pSSysUniState, boolean bl) throws Exception {
        if (pSSysUniState.isState8PSDEFIdDirty()) {
            if (pSSysUniState.getState8PSDEFId() != null) {
                if (pSSysUniState.getState8PSDEFId() == null || pSSysUniState.getState8PSDEFName() == null) {
                    PSDEField pSDEField = pSSysUniState.getState8PSDEF();
                    pSSysUniState.setState8PSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysUniState.setState8PSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_StatePSDEF(PSSysUniState pSSysUniState, boolean bl) throws Exception {
        if (pSSysUniState.isStatePSDEFIdDirty()) {
            if (pSSysUniState.getStatePSDEFId() != null) {
                if (pSSysUniState.getStatePSDEFId() == null || pSSysUniState.getStatePSDEFName() == null) {
                    PSDEField pSDEField = pSSysUniState.getStatePSDEF();
                    pSSysUniState.setStatePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysUniState.setStatePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_InitPSDELogic(PSSysUniState pSSysUniState, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_OnChangePSDELogic(PSSysUniState pSSysUniState, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_OnDeletePSDELogic(PSSysUniState pSSysUniState, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSModule(PSSysUniState pSSysUniState, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSSysUniState pSSysUniState, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysUniState pSSysUniState, boolean bl) throws Exception {
        if (pSSysUniState.isPSSystemIdDirty()) {
            if (pSSysUniState.getPSSystemId() != null) {
                if (pSSysUniState.getPSSystemId() == null || pSSysUniState.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSysUniState.getPSSystem();
                    pSSysUniState.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSysUniState.setPSSystemName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysUtilDE(PSSysUniState pSSysUniState, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysUniState pSSysUniState, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysUniState, bl);
    }

    public ArrayList<PSSysUniState> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysUniState> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysUniState> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysUniState> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByPSDEDataSet(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSSysUniState> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByPSDEDataSet(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSSysUniState> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDATASETID", (Object)pSDEDataSetBase.getPSDEDataSetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEDataSetCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEDataSetCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUniState> selectByKey2PSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByKey2PSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysUniState> selectByKey2PSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByKey2PSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysUniState> selectByKey2PSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("KEY2PSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByKey2PSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByKey2PSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUniState> selectByKey3PSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByKey3PSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysUniState> selectByKey3PSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByKey3PSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysUniState> selectByKey3PSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("KEY3PSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByKey3PSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByKey3PSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUniState> selectByKey4PSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByKey4PSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysUniState> selectByKey4PSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByKey4PSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysUniState> selectByKey4PSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("KEY4PSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByKey4PSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByKey4PSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUniState> selectByKey5PSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByKey5PSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysUniState> selectByKey5PSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByKey5PSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysUniState> selectByKey5PSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("KEY5PSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByKey5PSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByKey5PSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUniState> selectByKey6PSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByKey6PSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysUniState> selectByKey6PSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByKey6PSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysUniState> selectByKey6PSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("KEY6PSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByKey6PSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByKey6PSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUniState> selectByKey7PSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByKey7PSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysUniState> selectByKey7PSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByKey7PSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysUniState> selectByKey7PSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("KEY7PSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByKey7PSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByKey7PSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUniState> selectByKey8PSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByKey8PSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysUniState> selectByKey8PSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByKey8PSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysUniState> selectByKey8PSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("KEY8PSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByKey8PSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByKey8PSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUniState> selectByKey9PSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByKey9PSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysUniState> selectByKey9PSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByKey9PSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysUniState> selectByKey9PSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("KEY9PSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByKey9PSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByKey9PSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUniState> selectByKeyPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByKeyPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysUniState> selectByKeyPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByKeyPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysUniState> selectByKeyPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("KEYPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByKeyPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByKeyPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUniState> selectByState2PSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByState2PSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysUniState> selectByState2PSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByState2PSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysUniState> selectByState2PSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("STATE2PSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByState2PSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByState2PSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUniState> selectByState3PSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByState3PSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysUniState> selectByState3PSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByState3PSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysUniState> selectByState3PSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("STATE3PSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByState3PSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByState3PSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUniState> selectByState4PSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByState4PSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysUniState> selectByState4PSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByState4PSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysUniState> selectByState4PSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("STATE4PSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByState4PSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByState4PSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUniState> selectByState5PSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByState5PSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysUniState> selectByState5PSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByState5PSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysUniState> selectByState5PSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("STATE5PSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByState5PSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByState5PSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUniState> selectByState6PSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByState6PSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysUniState> selectByState6PSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByState6PSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysUniState> selectByState6PSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("STATE6PSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByState6PSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByState6PSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUniState> selectByState7PSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByState7PSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysUniState> selectByState7PSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByState7PSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysUniState> selectByState7PSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("STATE7PSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByState7PSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByState7PSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUniState> selectByState8PSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByState8PSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysUniState> selectByState8PSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByState8PSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysUniState> selectByState8PSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("STATE8PSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByState8PSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByState8PSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUniState> selectByStatePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByStatePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysUniState> selectByStatePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByStatePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysUniState> selectByStatePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("STATEPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByStatePSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByStatePSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUniState> selectByInitPSDELogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByInitPSDELogic(pSDELogicBase, "", -1);
    }

    public ArrayList<PSSysUniState> selectByInitPSDELogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByInitPSDELogic(pSDELogicBase, string, -1);
    }

    public ArrayList<PSSysUniState> selectByInitPSDELogic(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("INITPSDELOGICID", (Object)pSDELogicBase.getPSDELogicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByInitPSDELogicCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByInitPSDELogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUniState> selectByOnChangePSDELogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByOnChangePSDELogic(pSDELogicBase, "", -1);
    }

    public ArrayList<PSSysUniState> selectByOnChangePSDELogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByOnChangePSDELogic(pSDELogicBase, string, -1);
    }

    public ArrayList<PSSysUniState> selectByOnChangePSDELogic(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ONCHANGEPSDELOGICID", (Object)pSDELogicBase.getPSDELogicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByOnChangePSDELogicCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByOnChangePSDELogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUniState> selectByOnDeletePSDELogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByOnDeletePSDELogic(pSDELogicBase, "", -1);
    }

    public ArrayList<PSSysUniState> selectByOnDeletePSDELogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByOnDeletePSDELogic(pSDELogicBase, string, -1);
    }

    public ArrayList<PSSysUniState> selectByOnDeletePSDELogic(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ONDELETEPSDELOGICID", (Object)pSDELogicBase.getPSDELogicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByOnDeletePSDELogicCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByOnDeletePSDELogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUniState> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSSysUniState> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSSysUniState> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSMODULEID", (Object)pSModuleBase.getPSModuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSModuleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSModuleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUniState> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSSysUniState> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSSysUniState> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSSFPLUGINID", (Object)pSSysSFPluginBase.getPSSysSFPluginId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysSFPluginCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysSFPluginCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUniState> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysUniState> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysUniState> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTEMID", (Object)pSSystemBase.getPSSystemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSystemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSystemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUniState> selectByPSSysUtilDE(PSSysUtilDEBase pSSysUtilDEBase) throws Exception {
        return this.selectByPSSysUtilDE(pSSysUtilDEBase, "", -1);
    }

    public ArrayList<PSSysUniState> selectByPSSysUtilDE(PSSysUtilDEBase pSSysUtilDEBase, String string) throws Exception {
        return this.selectByPSSysUtilDE(pSSysUtilDEBase, string, -1);
    }

    public ArrayList<PSSysUniState> selectByPSSysUtilDE(PSSysUtilDEBase pSSysUtilDEBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSUTILDEID", (Object)pSSysUtilDEBase.getPSSysUtilDEId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysUtilDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysUtilDECond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUNISTATE_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSSYSUNISTATE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSSysUniState pSSysUniState : arrayList) {
            PSSysUniState pSSysUniState2 = (PSSysUniState)this.getDEModel().createEntity();
            pSSysUniState2.setPSSysUniStateId(pSSysUniState.getPSSysUniStateId());
            pSSysUniState2.setPSDEId(null);
            this.update(pSSysUniState2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUniStateServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSSysUniStateServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSSysUniStateServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSSysUniState pSSysUniState : arrayList) {
            this.remove((IEntity)pSSysUniState);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByPSDEDataSet(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUNISTATE_PSDEDATASET_PSDEDATASETID", "", iDataEntityModel.getName(), "PSSYSUNISTATE", iDataEntityModel.getDataInfo((IEntity)pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByPSDEDataSet(pSDEDataSet);
        for (PSSysUniState pSSysUniState : arrayList) {
            PSSysUniState pSSysUniState2 = (PSSysUniState)this.getDEModel().createEntity();
            pSSysUniState2.setPSSysUniStateId(pSSysUniState.getPSSysUniStateId());
            pSSysUniState2.setPSDEDataSetId(null);
            this.update(pSSysUniState2);
        }
    }

    public void removeByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUniStateServiceBase.this.onBeforeRemoveByPSDEDataSet(pSDEDataSet2);
                PSSysUniStateServiceBase.this.internalRemoveByPSDEDataSet(pSDEDataSet2);
                PSSysUniStateServiceBase.this.onAfterRemoveByPSDEDataSet(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByPSDEDataSet(pSDEDataSet);
        this.onBeforeRemoveByPSDEDataSet(pSDEDataSet, arrayList);
        for (PSSysUniState pSSysUniState : arrayList) {
            this.remove((IEntity)pSSysUniState);
        }
        this.onAfterRemoveByPSDEDataSet(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    public void testRemoveByKey2PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByKey2PSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUNISTATE_PSDEFIELD_KEY2PSDEFID", "", iDataEntityModel.getName(), "PSSYSUNISTATE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetKey2PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByKey2PSDEF(pSDEField);
        for (PSSysUniState pSSysUniState : arrayList) {
            PSSysUniState pSSysUniState2 = (PSSysUniState)this.getDEModel().createEntity();
            pSSysUniState2.setPSSysUniStateId(pSSysUniState.getPSSysUniStateId());
            pSSysUniState2.setKey2PSDEFId(null);
            this.update(pSSysUniState2);
        }
    }

    public void removeByKey2PSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUniStateServiceBase.this.onBeforeRemoveByKey2PSDEF(pSDEField2);
                PSSysUniStateServiceBase.this.internalRemoveByKey2PSDEF(pSDEField2);
                PSSysUniStateServiceBase.this.onAfterRemoveByKey2PSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByKey2PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByKey2PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByKey2PSDEF(pSDEField);
        this.onBeforeRemoveByKey2PSDEF(pSDEField, arrayList);
        for (PSSysUniState pSSysUniState : arrayList) {
            this.remove((IEntity)pSSysUniState);
        }
        this.onAfterRemoveByKey2PSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByKey2PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByKey2PSDEF(PSDEField pSDEField, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    protected void onAfterRemoveByKey2PSDEF(PSDEField pSDEField, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    public void testRemoveByKey3PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByKey3PSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUNISTATE_PSDEFIELD_KEY3PSDEFID", "", iDataEntityModel.getName(), "PSSYSUNISTATE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetKey3PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByKey3PSDEF(pSDEField);
        for (PSSysUniState pSSysUniState : arrayList) {
            PSSysUniState pSSysUniState2 = (PSSysUniState)this.getDEModel().createEntity();
            pSSysUniState2.setPSSysUniStateId(pSSysUniState.getPSSysUniStateId());
            pSSysUniState2.setKey3PSDEFId(null);
            this.update(pSSysUniState2);
        }
    }

    public void removeByKey3PSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUniStateServiceBase.this.onBeforeRemoveByKey3PSDEF(pSDEField2);
                PSSysUniStateServiceBase.this.internalRemoveByKey3PSDEF(pSDEField2);
                PSSysUniStateServiceBase.this.onAfterRemoveByKey3PSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByKey3PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByKey3PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByKey3PSDEF(pSDEField);
        this.onBeforeRemoveByKey3PSDEF(pSDEField, arrayList);
        for (PSSysUniState pSSysUniState : arrayList) {
            this.remove((IEntity)pSSysUniState);
        }
        this.onAfterRemoveByKey3PSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByKey3PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByKey3PSDEF(PSDEField pSDEField, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    protected void onAfterRemoveByKey3PSDEF(PSDEField pSDEField, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    public void testRemoveByKey4PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByKey4PSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUNISTATE_PSDEFIELD_KEY4PSDEFID", "", iDataEntityModel.getName(), "PSSYSUNISTATE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetKey4PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByKey4PSDEF(pSDEField);
        for (PSSysUniState pSSysUniState : arrayList) {
            PSSysUniState pSSysUniState2 = (PSSysUniState)this.getDEModel().createEntity();
            pSSysUniState2.setPSSysUniStateId(pSSysUniState.getPSSysUniStateId());
            pSSysUniState2.setKey4PSDEFId(null);
            this.update(pSSysUniState2);
        }
    }

    public void removeByKey4PSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUniStateServiceBase.this.onBeforeRemoveByKey4PSDEF(pSDEField2);
                PSSysUniStateServiceBase.this.internalRemoveByKey4PSDEF(pSDEField2);
                PSSysUniStateServiceBase.this.onAfterRemoveByKey4PSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByKey4PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByKey4PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByKey4PSDEF(pSDEField);
        this.onBeforeRemoveByKey4PSDEF(pSDEField, arrayList);
        for (PSSysUniState pSSysUniState : arrayList) {
            this.remove((IEntity)pSSysUniState);
        }
        this.onAfterRemoveByKey4PSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByKey4PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByKey4PSDEF(PSDEField pSDEField, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    protected void onAfterRemoveByKey4PSDEF(PSDEField pSDEField, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    public void testRemoveByKey5PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByKey5PSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUNISTATE_PSDEFIELD_KEY5PSDEFID", "", iDataEntityModel.getName(), "PSSYSUNISTATE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetKey5PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByKey5PSDEF(pSDEField);
        for (PSSysUniState pSSysUniState : arrayList) {
            PSSysUniState pSSysUniState2 = (PSSysUniState)this.getDEModel().createEntity();
            pSSysUniState2.setPSSysUniStateId(pSSysUniState.getPSSysUniStateId());
            pSSysUniState2.setKey5PSDEFId(null);
            this.update(pSSysUniState2);
        }
    }

    public void removeByKey5PSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUniStateServiceBase.this.onBeforeRemoveByKey5PSDEF(pSDEField2);
                PSSysUniStateServiceBase.this.internalRemoveByKey5PSDEF(pSDEField2);
                PSSysUniStateServiceBase.this.onAfterRemoveByKey5PSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByKey5PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByKey5PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByKey5PSDEF(pSDEField);
        this.onBeforeRemoveByKey5PSDEF(pSDEField, arrayList);
        for (PSSysUniState pSSysUniState : arrayList) {
            this.remove((IEntity)pSSysUniState);
        }
        this.onAfterRemoveByKey5PSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByKey5PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByKey5PSDEF(PSDEField pSDEField, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    protected void onAfterRemoveByKey5PSDEF(PSDEField pSDEField, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    public void testRemoveByKey6PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByKey6PSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUNISTATE_PSDEFIELD_KEY6PSDEFID", "", iDataEntityModel.getName(), "PSSYSUNISTATE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetKey6PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByKey6PSDEF(pSDEField);
        for (PSSysUniState pSSysUniState : arrayList) {
            PSSysUniState pSSysUniState2 = (PSSysUniState)this.getDEModel().createEntity();
            pSSysUniState2.setPSSysUniStateId(pSSysUniState.getPSSysUniStateId());
            pSSysUniState2.setKey6PSDEFId(null);
            this.update(pSSysUniState2);
        }
    }

    public void removeByKey6PSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUniStateServiceBase.this.onBeforeRemoveByKey6PSDEF(pSDEField2);
                PSSysUniStateServiceBase.this.internalRemoveByKey6PSDEF(pSDEField2);
                PSSysUniStateServiceBase.this.onAfterRemoveByKey6PSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByKey6PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByKey6PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByKey6PSDEF(pSDEField);
        this.onBeforeRemoveByKey6PSDEF(pSDEField, arrayList);
        for (PSSysUniState pSSysUniState : arrayList) {
            this.remove((IEntity)pSSysUniState);
        }
        this.onAfterRemoveByKey6PSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByKey6PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByKey6PSDEF(PSDEField pSDEField, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    protected void onAfterRemoveByKey6PSDEF(PSDEField pSDEField, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    public void testRemoveByKey7PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByKey7PSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUNISTATE_PSDEFIELD_KEY7PSDEFID", "", iDataEntityModel.getName(), "PSSYSUNISTATE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetKey7PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByKey7PSDEF(pSDEField);
        for (PSSysUniState pSSysUniState : arrayList) {
            PSSysUniState pSSysUniState2 = (PSSysUniState)this.getDEModel().createEntity();
            pSSysUniState2.setPSSysUniStateId(pSSysUniState.getPSSysUniStateId());
            pSSysUniState2.setKey7PSDEFId(null);
            this.update(pSSysUniState2);
        }
    }

    public void removeByKey7PSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUniStateServiceBase.this.onBeforeRemoveByKey7PSDEF(pSDEField2);
                PSSysUniStateServiceBase.this.internalRemoveByKey7PSDEF(pSDEField2);
                PSSysUniStateServiceBase.this.onAfterRemoveByKey7PSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByKey7PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByKey7PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByKey7PSDEF(pSDEField);
        this.onBeforeRemoveByKey7PSDEF(pSDEField, arrayList);
        for (PSSysUniState pSSysUniState : arrayList) {
            this.remove((IEntity)pSSysUniState);
        }
        this.onAfterRemoveByKey7PSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByKey7PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByKey7PSDEF(PSDEField pSDEField, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    protected void onAfterRemoveByKey7PSDEF(PSDEField pSDEField, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    public void testRemoveByKey8PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByKey8PSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUNISTATE_PSDEFIELD_KEY8PSDEFID", "", iDataEntityModel.getName(), "PSSYSUNISTATE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetKey8PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByKey8PSDEF(pSDEField);
        for (PSSysUniState pSSysUniState : arrayList) {
            PSSysUniState pSSysUniState2 = (PSSysUniState)this.getDEModel().createEntity();
            pSSysUniState2.setPSSysUniStateId(pSSysUniState.getPSSysUniStateId());
            pSSysUniState2.setKey8PSDEFId(null);
            this.update(pSSysUniState2);
        }
    }

    public void removeByKey8PSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUniStateServiceBase.this.onBeforeRemoveByKey8PSDEF(pSDEField2);
                PSSysUniStateServiceBase.this.internalRemoveByKey8PSDEF(pSDEField2);
                PSSysUniStateServiceBase.this.onAfterRemoveByKey8PSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByKey8PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByKey8PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByKey8PSDEF(pSDEField);
        this.onBeforeRemoveByKey8PSDEF(pSDEField, arrayList);
        for (PSSysUniState pSSysUniState : arrayList) {
            this.remove((IEntity)pSSysUniState);
        }
        this.onAfterRemoveByKey8PSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByKey8PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByKey8PSDEF(PSDEField pSDEField, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    protected void onAfterRemoveByKey8PSDEF(PSDEField pSDEField, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    public void testRemoveByKey9PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByKey9PSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUNISTATE_PSDEFIELD_KEY9PSDEFID", "", iDataEntityModel.getName(), "PSSYSUNISTATE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetKey9PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByKey9PSDEF(pSDEField);
        for (PSSysUniState pSSysUniState : arrayList) {
            PSSysUniState pSSysUniState2 = (PSSysUniState)this.getDEModel().createEntity();
            pSSysUniState2.setPSSysUniStateId(pSSysUniState.getPSSysUniStateId());
            pSSysUniState2.setKey9PSDEFId(null);
            this.update(pSSysUniState2);
        }
    }

    public void removeByKey9PSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUniStateServiceBase.this.onBeforeRemoveByKey9PSDEF(pSDEField2);
                PSSysUniStateServiceBase.this.internalRemoveByKey9PSDEF(pSDEField2);
                PSSysUniStateServiceBase.this.onAfterRemoveByKey9PSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByKey9PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByKey9PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByKey9PSDEF(pSDEField);
        this.onBeforeRemoveByKey9PSDEF(pSDEField, arrayList);
        for (PSSysUniState pSSysUniState : arrayList) {
            this.remove((IEntity)pSSysUniState);
        }
        this.onAfterRemoveByKey9PSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByKey9PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByKey9PSDEF(PSDEField pSDEField, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    protected void onAfterRemoveByKey9PSDEF(PSDEField pSDEField, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    public void testRemoveByKeyPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByKeyPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUNISTATE_PSDEFIELD_KEYPSDEFID", "", iDataEntityModel.getName(), "PSSYSUNISTATE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetKeyPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByKeyPSDEF(pSDEField);
        for (PSSysUniState pSSysUniState : arrayList) {
            PSSysUniState pSSysUniState2 = (PSSysUniState)this.getDEModel().createEntity();
            pSSysUniState2.setPSSysUniStateId(pSSysUniState.getPSSysUniStateId());
            pSSysUniState2.setKeyPSDEFId(null);
            this.update(pSSysUniState2);
        }
    }

    public void removeByKeyPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUniStateServiceBase.this.onBeforeRemoveByKeyPSDEF(pSDEField2);
                PSSysUniStateServiceBase.this.internalRemoveByKeyPSDEF(pSDEField2);
                PSSysUniStateServiceBase.this.onAfterRemoveByKeyPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByKeyPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByKeyPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByKeyPSDEF(pSDEField);
        this.onBeforeRemoveByKeyPSDEF(pSDEField, arrayList);
        for (PSSysUniState pSSysUniState : arrayList) {
            this.remove((IEntity)pSSysUniState);
        }
        this.onAfterRemoveByKeyPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByKeyPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByKeyPSDEF(PSDEField pSDEField, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    protected void onAfterRemoveByKeyPSDEF(PSDEField pSDEField, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    public void testRemoveByState2PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByState2PSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUNISTATE_PSDEFIELD_STATE2PSDEFID", "", iDataEntityModel.getName(), "PSSYSUNISTATE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetState2PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByState2PSDEF(pSDEField);
        for (PSSysUniState pSSysUniState : arrayList) {
            PSSysUniState pSSysUniState2 = (PSSysUniState)this.getDEModel().createEntity();
            pSSysUniState2.setPSSysUniStateId(pSSysUniState.getPSSysUniStateId());
            pSSysUniState2.setState2PSDEFId(null);
            this.update(pSSysUniState2);
        }
    }

    public void removeByState2PSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUniStateServiceBase.this.onBeforeRemoveByState2PSDEF(pSDEField2);
                PSSysUniStateServiceBase.this.internalRemoveByState2PSDEF(pSDEField2);
                PSSysUniStateServiceBase.this.onAfterRemoveByState2PSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByState2PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByState2PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByState2PSDEF(pSDEField);
        this.onBeforeRemoveByState2PSDEF(pSDEField, arrayList);
        for (PSSysUniState pSSysUniState : arrayList) {
            this.remove((IEntity)pSSysUniState);
        }
        this.onAfterRemoveByState2PSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByState2PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByState2PSDEF(PSDEField pSDEField, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    protected void onAfterRemoveByState2PSDEF(PSDEField pSDEField, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    public void testRemoveByState3PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByState3PSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUNISTATE_PSDEFIELD_STATE3PSDEFID", "", iDataEntityModel.getName(), "PSSYSUNISTATE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetState3PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByState3PSDEF(pSDEField);
        for (PSSysUniState pSSysUniState : arrayList) {
            PSSysUniState pSSysUniState2 = (PSSysUniState)this.getDEModel().createEntity();
            pSSysUniState2.setPSSysUniStateId(pSSysUniState.getPSSysUniStateId());
            pSSysUniState2.setState3PSDEFId(null);
            this.update(pSSysUniState2);
        }
    }

    public void removeByState3PSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUniStateServiceBase.this.onBeforeRemoveByState3PSDEF(pSDEField2);
                PSSysUniStateServiceBase.this.internalRemoveByState3PSDEF(pSDEField2);
                PSSysUniStateServiceBase.this.onAfterRemoveByState3PSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByState3PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByState3PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByState3PSDEF(pSDEField);
        this.onBeforeRemoveByState3PSDEF(pSDEField, arrayList);
        for (PSSysUniState pSSysUniState : arrayList) {
            this.remove((IEntity)pSSysUniState);
        }
        this.onAfterRemoveByState3PSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByState3PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByState3PSDEF(PSDEField pSDEField, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    protected void onAfterRemoveByState3PSDEF(PSDEField pSDEField, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    public void testRemoveByState4PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByState4PSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUNISTATE_PSDEFIELD_STATE4PSDEFID", "", iDataEntityModel.getName(), "PSSYSUNISTATE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetState4PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByState4PSDEF(pSDEField);
        for (PSSysUniState pSSysUniState : arrayList) {
            PSSysUniState pSSysUniState2 = (PSSysUniState)this.getDEModel().createEntity();
            pSSysUniState2.setPSSysUniStateId(pSSysUniState.getPSSysUniStateId());
            pSSysUniState2.setState4PSDEFId(null);
            this.update(pSSysUniState2);
        }
    }

    public void removeByState4PSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUniStateServiceBase.this.onBeforeRemoveByState4PSDEF(pSDEField2);
                PSSysUniStateServiceBase.this.internalRemoveByState4PSDEF(pSDEField2);
                PSSysUniStateServiceBase.this.onAfterRemoveByState4PSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByState4PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByState4PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByState4PSDEF(pSDEField);
        this.onBeforeRemoveByState4PSDEF(pSDEField, arrayList);
        for (PSSysUniState pSSysUniState : arrayList) {
            this.remove((IEntity)pSSysUniState);
        }
        this.onAfterRemoveByState4PSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByState4PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByState4PSDEF(PSDEField pSDEField, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    protected void onAfterRemoveByState4PSDEF(PSDEField pSDEField, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    public void testRemoveByState5PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByState5PSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUNISTATE_PSDEFIELD_STATE5PSDEFID", "", iDataEntityModel.getName(), "PSSYSUNISTATE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetState5PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByState5PSDEF(pSDEField);
        for (PSSysUniState pSSysUniState : arrayList) {
            PSSysUniState pSSysUniState2 = (PSSysUniState)this.getDEModel().createEntity();
            pSSysUniState2.setPSSysUniStateId(pSSysUniState.getPSSysUniStateId());
            pSSysUniState2.setState5PSDEFId(null);
            this.update(pSSysUniState2);
        }
    }

    public void removeByState5PSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUniStateServiceBase.this.onBeforeRemoveByState5PSDEF(pSDEField2);
                PSSysUniStateServiceBase.this.internalRemoveByState5PSDEF(pSDEField2);
                PSSysUniStateServiceBase.this.onAfterRemoveByState5PSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByState5PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByState5PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByState5PSDEF(pSDEField);
        this.onBeforeRemoveByState5PSDEF(pSDEField, arrayList);
        for (PSSysUniState pSSysUniState : arrayList) {
            this.remove((IEntity)pSSysUniState);
        }
        this.onAfterRemoveByState5PSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByState5PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByState5PSDEF(PSDEField pSDEField, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    protected void onAfterRemoveByState5PSDEF(PSDEField pSDEField, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    public void testRemoveByState6PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByState6PSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUNISTATE_PSDEFIELD_STATE6PSDEFID", "", iDataEntityModel.getName(), "PSSYSUNISTATE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetState6PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByState6PSDEF(pSDEField);
        for (PSSysUniState pSSysUniState : arrayList) {
            PSSysUniState pSSysUniState2 = (PSSysUniState)this.getDEModel().createEntity();
            pSSysUniState2.setPSSysUniStateId(pSSysUniState.getPSSysUniStateId());
            pSSysUniState2.setState6PSDEFId(null);
            this.update(pSSysUniState2);
        }
    }

    public void removeByState6PSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUniStateServiceBase.this.onBeforeRemoveByState6PSDEF(pSDEField2);
                PSSysUniStateServiceBase.this.internalRemoveByState6PSDEF(pSDEField2);
                PSSysUniStateServiceBase.this.onAfterRemoveByState6PSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByState6PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByState6PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByState6PSDEF(pSDEField);
        this.onBeforeRemoveByState6PSDEF(pSDEField, arrayList);
        for (PSSysUniState pSSysUniState : arrayList) {
            this.remove((IEntity)pSSysUniState);
        }
        this.onAfterRemoveByState6PSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByState6PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByState6PSDEF(PSDEField pSDEField, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    protected void onAfterRemoveByState6PSDEF(PSDEField pSDEField, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    public void testRemoveByState7PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByState7PSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUNISTATE_PSDEFIELD_STATE7PSDEFID", "", iDataEntityModel.getName(), "PSSYSUNISTATE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetState7PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByState7PSDEF(pSDEField);
        for (PSSysUniState pSSysUniState : arrayList) {
            PSSysUniState pSSysUniState2 = (PSSysUniState)this.getDEModel().createEntity();
            pSSysUniState2.setPSSysUniStateId(pSSysUniState.getPSSysUniStateId());
            pSSysUniState2.setState7PSDEFId(null);
            this.update(pSSysUniState2);
        }
    }

    public void removeByState7PSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUniStateServiceBase.this.onBeforeRemoveByState7PSDEF(pSDEField2);
                PSSysUniStateServiceBase.this.internalRemoveByState7PSDEF(pSDEField2);
                PSSysUniStateServiceBase.this.onAfterRemoveByState7PSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByState7PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByState7PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByState7PSDEF(pSDEField);
        this.onBeforeRemoveByState7PSDEF(pSDEField, arrayList);
        for (PSSysUniState pSSysUniState : arrayList) {
            this.remove((IEntity)pSSysUniState);
        }
        this.onAfterRemoveByState7PSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByState7PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByState7PSDEF(PSDEField pSDEField, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    protected void onAfterRemoveByState7PSDEF(PSDEField pSDEField, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    public void testRemoveByState8PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByState8PSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUNISTATE_PSDEFIELD_STATE8PSDEFID", "", iDataEntityModel.getName(), "PSSYSUNISTATE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetState8PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByState8PSDEF(pSDEField);
        for (PSSysUniState pSSysUniState : arrayList) {
            PSSysUniState pSSysUniState2 = (PSSysUniState)this.getDEModel().createEntity();
            pSSysUniState2.setPSSysUniStateId(pSSysUniState.getPSSysUniStateId());
            pSSysUniState2.setState8PSDEFId(null);
            this.update(pSSysUniState2);
        }
    }

    public void removeByState8PSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUniStateServiceBase.this.onBeforeRemoveByState8PSDEF(pSDEField2);
                PSSysUniStateServiceBase.this.internalRemoveByState8PSDEF(pSDEField2);
                PSSysUniStateServiceBase.this.onAfterRemoveByState8PSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByState8PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByState8PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByState8PSDEF(pSDEField);
        this.onBeforeRemoveByState8PSDEF(pSDEField, arrayList);
        for (PSSysUniState pSSysUniState : arrayList) {
            this.remove((IEntity)pSSysUniState);
        }
        this.onAfterRemoveByState8PSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByState8PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByState8PSDEF(PSDEField pSDEField, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    protected void onAfterRemoveByState8PSDEF(PSDEField pSDEField, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    public void testRemoveByStatePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByStatePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUNISTATE_PSDEFIELD_STATEPSDEFID", "", iDataEntityModel.getName(), "PSSYSUNISTATE", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetStatePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByStatePSDEF(pSDEField);
        for (PSSysUniState pSSysUniState : arrayList) {
            PSSysUniState pSSysUniState2 = (PSSysUniState)this.getDEModel().createEntity();
            pSSysUniState2.setPSSysUniStateId(pSSysUniState.getPSSysUniStateId());
            pSSysUniState2.setStatePSDEFId(null);
            this.update(pSSysUniState2);
        }
    }

    public void removeByStatePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUniStateServiceBase.this.onBeforeRemoveByStatePSDEF(pSDEField2);
                PSSysUniStateServiceBase.this.internalRemoveByStatePSDEF(pSDEField2);
                PSSysUniStateServiceBase.this.onAfterRemoveByStatePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByStatePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByStatePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByStatePSDEF(pSDEField);
        this.onBeforeRemoveByStatePSDEF(pSDEField, arrayList);
        for (PSSysUniState pSSysUniState : arrayList) {
            this.remove((IEntity)pSSysUniState);
        }
        this.onAfterRemoveByStatePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByStatePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByStatePSDEF(PSDEField pSDEField, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    protected void onAfterRemoveByStatePSDEF(PSDEField pSDEField, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    public void testRemoveByInitPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByInitPSDELogic(pSDELogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDELogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUNISTATE_PSDELOGIC_INITPSDELOGICID", "", iDataEntityModel.getName(), "PSSYSUNISTATE", iDataEntityModel.getDataInfo((IEntity)pSDELogic), arrayList.get(0)));
        }
    }

    public void resetInitPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByInitPSDELogic(pSDELogic);
        for (PSSysUniState pSSysUniState : arrayList) {
            PSSysUniState pSSysUniState2 = (PSSysUniState)this.getDEModel().createEntity();
            pSSysUniState2.setPSSysUniStateId(pSSysUniState.getPSSysUniStateId());
            pSSysUniState2.setInitPSDELogicId(null);
            this.update(pSSysUniState2);
        }
    }

    public void removeByInitPSDELogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUniStateServiceBase.this.onBeforeRemoveByInitPSDELogic(pSDELogic2);
                PSSysUniStateServiceBase.this.internalRemoveByInitPSDELogic(pSDELogic2);
                PSSysUniStateServiceBase.this.onAfterRemoveByInitPSDELogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByInitPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByInitPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByInitPSDELogic(pSDELogic);
        this.onBeforeRemoveByInitPSDELogic(pSDELogic, arrayList);
        for (PSSysUniState pSSysUniState : arrayList) {
            this.remove((IEntity)pSSysUniState);
        }
        this.onAfterRemoveByInitPSDELogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByInitPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByInitPSDELogic(PSDELogic pSDELogic, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    protected void onAfterRemoveByInitPSDELogic(PSDELogic pSDELogic, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    public void testRemoveByOnChangePSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByOnChangePSDELogic(pSDELogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDELogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUNISTATE_PSDELOGIC_ONCHANGEPSDELOGICID", "", iDataEntityModel.getName(), "PSSYSUNISTATE", iDataEntityModel.getDataInfo((IEntity)pSDELogic), arrayList.get(0)));
        }
    }

    public void resetOnChangePSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByOnChangePSDELogic(pSDELogic);
        for (PSSysUniState pSSysUniState : arrayList) {
            PSSysUniState pSSysUniState2 = (PSSysUniState)this.getDEModel().createEntity();
            pSSysUniState2.setPSSysUniStateId(pSSysUniState.getPSSysUniStateId());
            pSSysUniState2.setOnChangePSDELogicId(null);
            this.update(pSSysUniState2);
        }
    }

    public void removeByOnChangePSDELogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUniStateServiceBase.this.onBeforeRemoveByOnChangePSDELogic(pSDELogic2);
                PSSysUniStateServiceBase.this.internalRemoveByOnChangePSDELogic(pSDELogic2);
                PSSysUniStateServiceBase.this.onAfterRemoveByOnChangePSDELogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByOnChangePSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByOnChangePSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByOnChangePSDELogic(pSDELogic);
        this.onBeforeRemoveByOnChangePSDELogic(pSDELogic, arrayList);
        for (PSSysUniState pSSysUniState : arrayList) {
            this.remove((IEntity)pSSysUniState);
        }
        this.onAfterRemoveByOnChangePSDELogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByOnChangePSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByOnChangePSDELogic(PSDELogic pSDELogic, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    protected void onAfterRemoveByOnChangePSDELogic(PSDELogic pSDELogic, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    public void testRemoveByOnDeletePSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByOnDeletePSDELogic(pSDELogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDELogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUNISTATE_PSDELOGIC_ONDELETEPSDELOGICID", "", iDataEntityModel.getName(), "PSSYSUNISTATE", iDataEntityModel.getDataInfo((IEntity)pSDELogic), arrayList.get(0)));
        }
    }

    public void resetOnDeletePSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByOnDeletePSDELogic(pSDELogic);
        for (PSSysUniState pSSysUniState : arrayList) {
            PSSysUniState pSSysUniState2 = (PSSysUniState)this.getDEModel().createEntity();
            pSSysUniState2.setPSSysUniStateId(pSSysUniState.getPSSysUniStateId());
            pSSysUniState2.setOnDeletePSDELogicId(null);
            this.update(pSSysUniState2);
        }
    }

    public void removeByOnDeletePSDELogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUniStateServiceBase.this.onBeforeRemoveByOnDeletePSDELogic(pSDELogic2);
                PSSysUniStateServiceBase.this.internalRemoveByOnDeletePSDELogic(pSDELogic2);
                PSSysUniStateServiceBase.this.onAfterRemoveByOnDeletePSDELogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByOnDeletePSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByOnDeletePSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByOnDeletePSDELogic(pSDELogic);
        this.onBeforeRemoveByOnDeletePSDELogic(pSDELogic, arrayList);
        for (PSSysUniState pSSysUniState : arrayList) {
            this.remove((IEntity)pSSysUniState);
        }
        this.onAfterRemoveByOnDeletePSDELogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByOnDeletePSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByOnDeletePSDELogic(PSDELogic pSDELogic, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    protected void onAfterRemoveByOnDeletePSDELogic(PSDELogic pSDELogic, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    public void testRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUNISTATE_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSSYSUNISTATE", iDataEntityModel.getDataInfo((IEntity)pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByPSModule(pSModule);
        for (PSSysUniState pSSysUniState : arrayList) {
            PSSysUniState pSSysUniState2 = (PSSysUniState)this.getDEModel().createEntity();
            pSSysUniState2.setPSSysUniStateId(pSSysUniState.getPSSysUniStateId());
            pSSysUniState2.setPSModuleId(null);
            this.update(pSSysUniState2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUniStateServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSSysUniStateServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSSysUniStateServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSSysUniState pSSysUniState : arrayList) {
            this.remove((IEntity)pSSysUniState);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUNISTATE_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSSYSUNISTATE", iDataEntityModel.getDataInfo((IEntity)pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSSysUniState pSSysUniState : arrayList) {
            PSSysUniState pSSysUniState2 = (PSSysUniState)this.getDEModel().createEntity();
            pSSysUniState2.setPSSysUniStateId(pSSysUniState.getPSSysUniStateId());
            pSSysUniState2.setPSSysSFPluginId(null);
            this.update(pSSysUniState2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUniStateServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSSysUniStateServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSSysUniStateServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSSysUniState pSSysUniState : arrayList) {
            this.remove((IEntity)pSSysUniState);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysUniState pSSysUniState : arrayList) {
            PSSysUniState pSSysUniState2 = (PSSysUniState)this.getDEModel().createEntity();
            pSSysUniState2.setPSSysUniStateId(pSSysUniState.getPSSysUniStateId());
            pSSysUniState2.setPSSystemId(null);
            this.update(pSSysUniState2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUniStateServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysUniStateServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysUniStateServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysUniState pSSysUniState : arrayList) {
            this.remove((IEntity)pSSysUniState);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    public void testRemoveByPSSysUtilDE(PSSysUtilDE pSSysUtilDE) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByPSSysUtilDE(pSSysUtilDE, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSUTILDE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysUtilDE);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUNISTATE_PSSYSUTILDE_PSSYSUTILDEID", "", iDataEntityModel.getName(), "PSSYSUNISTATE", iDataEntityModel.getDataInfo((IEntity)pSSysUtilDE), arrayList.get(0)));
        }
    }

    public void resetPSSysUtilDE(PSSysUtilDE pSSysUtilDE) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByPSSysUtilDE(pSSysUtilDE);
        for (PSSysUniState pSSysUniState : arrayList) {
            PSSysUniState pSSysUniState2 = (PSSysUniState)this.getDEModel().createEntity();
            pSSysUniState2.setPSSysUniStateId(pSSysUniState.getPSSysUniStateId());
            pSSysUniState2.setPSSysUtilDEId(null);
            this.update(pSSysUniState2);
        }
    }

    public void removeByPSSysUtilDE(PSSysUtilDE pSSysUtilDE) throws Exception {
        final PSSysUtilDE pSSysUtilDE2 = pSSysUtilDE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUniStateServiceBase.this.onBeforeRemoveByPSSysUtilDE(pSSysUtilDE2);
                PSSysUniStateServiceBase.this.internalRemoveByPSSysUtilDE(pSSysUtilDE2);
                PSSysUniStateServiceBase.this.onAfterRemoveByPSSysUtilDE(pSSysUtilDE2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysUtilDE(PSSysUtilDE pSSysUtilDE) throws Exception {
    }

    protected void internalRemoveByPSSysUtilDE(PSSysUtilDE pSSysUtilDE) throws Exception {
        ArrayList<PSSysUniState> arrayList = this.selectByPSSysUtilDE(pSSysUtilDE);
        this.onBeforeRemoveByPSSysUtilDE(pSSysUtilDE, arrayList);
        for (PSSysUniState pSSysUniState : arrayList) {
            this.remove((IEntity)pSSysUniState);
        }
        this.onAfterRemoveByPSSysUtilDE(pSSysUtilDE, arrayList);
    }

    protected void onAfterRemoveByPSSysUtilDE(PSSysUtilDE pSSysUtilDE) throws Exception {
    }

    protected void onBeforeRemoveByPSSysUtilDE(PSSysUtilDE pSSysUtilDE, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysUtilDE(PSSysUtilDE pSSysUtilDE, ArrayList<PSSysUniState> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysUniState pSSysUniState) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSACHandlerService)ServiceGlobal.getService(PSACHandlerService.class, (SessionFactory)this.getSessionFactory());
        ((PSACHandlerServiceBase)pSCoreSysServiceBase).testRemoveByPSSysUniState(pSSysUniState);
        pSCoreSysServiceBase = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionServiceBase)pSCoreSysServiceBase).testRemoveByPSSysUniState(pSSysUniState);
        pSCoreSysServiceBase = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataSetServiceBase)pSCoreSysServiceBase).testRemoveByPSSysUniState(pSSysUniState);
        pSCoreSysServiceBase = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysUniState(pSSysUniState);
        super.onBeforeRemove(pSSysUniState);
    }

    protected void replaceParentInfo(PSSysUniState pSSysUniState, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysUniState, cloneSession);
        if (pSSysUniState.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysUniState.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSSysUniState, (PSDataEntity)iEntity);
        }
        if (pSSysUniState.getPSDEDataSetId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSSysUniState.getPSDEDataSetId())) != null) {
            this.onFillParentInfo_PSDEDataSet(pSSysUniState, (PSDEDataSet)iEntity);
        }
        if (pSSysUniState.getKey2PSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysUniState.getKey2PSDEFId())) != null) {
            this.onFillParentInfo_Key2PSDEF(pSSysUniState, (PSDEField)iEntity);
        }
        if (pSSysUniState.getKey3PSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysUniState.getKey3PSDEFId())) != null) {
            this.onFillParentInfo_Key3PSDEF(pSSysUniState, (PSDEField)iEntity);
        }
        if (pSSysUniState.getKey4PSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysUniState.getKey4PSDEFId())) != null) {
            this.onFillParentInfo_Key4PSDEF(pSSysUniState, (PSDEField)iEntity);
        }
        if (pSSysUniState.getKey5PSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysUniState.getKey5PSDEFId())) != null) {
            this.onFillParentInfo_Key5PSDEF(pSSysUniState, (PSDEField)iEntity);
        }
        if (pSSysUniState.getKey6PSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysUniState.getKey6PSDEFId())) != null) {
            this.onFillParentInfo_Key6PSDEF(pSSysUniState, (PSDEField)iEntity);
        }
        if (pSSysUniState.getKey7PSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysUniState.getKey7PSDEFId())) != null) {
            this.onFillParentInfo_Key7PSDEF(pSSysUniState, (PSDEField)iEntity);
        }
        if (pSSysUniState.getKey8PSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysUniState.getKey8PSDEFId())) != null) {
            this.onFillParentInfo_Key8PSDEF(pSSysUniState, (PSDEField)iEntity);
        }
        if (pSSysUniState.getKey9PSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysUniState.getKey9PSDEFId())) != null) {
            this.onFillParentInfo_Key9PSDEF(pSSysUniState, (PSDEField)iEntity);
        }
        if (pSSysUniState.getKeyPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysUniState.getKeyPSDEFId())) != null) {
            this.onFillParentInfo_KeyPSDEF(pSSysUniState, (PSDEField)iEntity);
        }
        if (pSSysUniState.getState2PSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysUniState.getState2PSDEFId())) != null) {
            this.onFillParentInfo_State2PSDEF(pSSysUniState, (PSDEField)iEntity);
        }
        if (pSSysUniState.getState3PSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysUniState.getState3PSDEFId())) != null) {
            this.onFillParentInfo_State3PSDEF(pSSysUniState, (PSDEField)iEntity);
        }
        if (pSSysUniState.getState4PSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysUniState.getState4PSDEFId())) != null) {
            this.onFillParentInfo_State4PSDEF(pSSysUniState, (PSDEField)iEntity);
        }
        if (pSSysUniState.getState5PSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysUniState.getState5PSDEFId())) != null) {
            this.onFillParentInfo_State5PSDEF(pSSysUniState, (PSDEField)iEntity);
        }
        if (pSSysUniState.getState6PSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysUniState.getState6PSDEFId())) != null) {
            this.onFillParentInfo_State6PSDEF(pSSysUniState, (PSDEField)iEntity);
        }
        if (pSSysUniState.getState7PSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysUniState.getState7PSDEFId())) != null) {
            this.onFillParentInfo_State7PSDEF(pSSysUniState, (PSDEField)iEntity);
        }
        if (pSSysUniState.getState8PSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysUniState.getState8PSDEFId())) != null) {
            this.onFillParentInfo_State8PSDEF(pSSysUniState, (PSDEField)iEntity);
        }
        if (pSSysUniState.getStatePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysUniState.getStatePSDEFId())) != null) {
            this.onFillParentInfo_StatePSDEF(pSSysUniState, (PSDEField)iEntity);
        }
        if (pSSysUniState.getInitPSDELogicId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSSysUniState.getInitPSDELogicId())) != null) {
            this.onFillParentInfo_InitPSDELogic(pSSysUniState, (PSDELogic)iEntity);
        }
        if (pSSysUniState.getOnChangePSDELogicId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSSysUniState.getOnChangePSDELogicId())) != null) {
            this.onFillParentInfo_OnChangePSDELogic(pSSysUniState, (PSDELogic)iEntity);
        }
        if (pSSysUniState.getOnDeletePSDELogicId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSSysUniState.getOnDeletePSDELogicId())) != null) {
            this.onFillParentInfo_OnDeletePSDELogic(pSSysUniState, (PSDELogic)iEntity);
        }
        if (pSSysUniState.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSSysUniState.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSSysUniState, (PSModule)iEntity);
        }
        if (pSSysUniState.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSSysUniState.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSSysUniState, (PSSysSFPlugin)iEntity);
        }
        if (pSSysUniState.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysUniState.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysUniState, (PSSystem)iEntity);
        }
        if (pSSysUniState.getPSSysUtilDEId() != null && (iEntity = cloneSession.getEntity("PSSYSUTILDE", (Object)pSSysUniState.getPSSysUtilDEId())) != null) {
            this.onFillParentInfo_PSSysUtilDE(pSSysUniState, (PSSysUtilDE)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysUniState pSSysUniState, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysUniState, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AllDataFlag(bl, pSSysUniState, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CacheCat(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CacheScope(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CacheTimeout(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomMode(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEDefaultFlag(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DeleteAsUpdate(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InitPSDELogicId(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Key2PSDEFId(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Key2PSDEFName(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Key3PSDEFId(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Key3PSDEFName(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Key4PSDEFId(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Key4PSDEFName(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Key5PSDEFId(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Key5PSDEFName(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Key6PSDEFId(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Key6PSDEFName(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Key7PSDEFId(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Key7PSDEFName(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Key8PSDEFId(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Key8PSDEFName(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Key9PSDEFId(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Key9PSDEFName(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_KeyFormat(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_KeyPSDEFId(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_KeyPSDEFName(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MonitorFormat(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OnChangePSDELogicId(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OnDeletePSDELogicId(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataSetId(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUniStateId(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUniStateName(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUtilDEId(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ReloadTimer(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_State2PSDEFId(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_State2PSDEFName(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_State3PSDEFId(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_State3PSDEFName(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_State4PSDEFId(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_State4PSDEFName(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_State5PSDEFId(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_State5PSDEFName(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_State6PSDEFId(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_State6PSDEFName(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_State7PSDEFId(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_State7PSDEFName(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_State8PSDEFId(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_State8PSDEFName(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StatePSDEFId(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StatePSDEFName(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UniqueTag(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UniStateMode(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UniStateParams(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UniStateTag(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UniStateTag2(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UniStateType(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysUniState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysUniState, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AllDataFlag(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isAllDataFlagDirty() : !pSSysUniState.isAllDataFlagDirty()) {
            return null;
        }
        Integer n = pSSysUniState.getAllDataFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AllDataFlag_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ALLDATAFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CacheCat(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isCacheCatDirty() : !pSSysUniState.isCacheCatDirty()) {
            return null;
        }
        String string = pSSysUniState.getCacheCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CacheCat_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CACHECAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CacheScope(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isCacheScopeDirty() : !pSSysUniState.isCacheScopeDirty()) {
            return null;
        }
        String string = pSSysUniState.getCacheScope();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CacheScope_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CACHESCOPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CacheTimeout(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isCacheTimeoutDirty() : !pSSysUniState.isCacheTimeoutDirty()) {
            return null;
        }
        Integer n = pSSysUniState.getCacheTimeout();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CacheTimeout_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CACHETIMEOUT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isCustomCodeDirty() : !pSSysUniState.isCustomCodeDirty()) {
            return null;
        }
        String string = pSSysUniState.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomMode(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isCustomModeDirty() : !pSSysUniState.isCustomModeDirty()) {
            return null;
        }
        Integer n = pSSysUniState.getCustomMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CustomMode_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEDefaultFlag(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isDEDefaultFlagDirty() : !pSSysUniState.isDEDefaultFlagDirty()) {
            return null;
        }
        Integer n = pSSysUniState.getDEDefaultFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DEDefaultFlag_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEDEFAULTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            bl4 = DataTypeHelper.compare((int)9, (Object)n, (Object)"1") == 0L;
            if (bl4) {
                String string = "";
                string = "PSDEID";
                String string2 = this.checkFieldDupRule(this.getPSSysUniStateDEModel(), "DEDEFAULTFLAG", string, pSSysUniState, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("DEDEFAULTFLAG");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string2);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DeleteAsUpdate(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isDeleteAsUpdateDirty() : !pSSysUniState.isDeleteAsUpdateDirty()) {
            return null;
        }
        Integer n = pSSysUniState.getDeleteAsUpdate();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DeleteAsUpdate_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DELETEASUPDATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InitPSDELogicId(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isInitPSDELogicIdDirty() : !pSSysUniState.isInitPSDELogicIdDirty()) {
            return null;
        }
        String string = pSSysUniState.getInitPSDELogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InitPSDELogicId_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INITPSDELOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Key2PSDEFId(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isKey2PSDEFIdDirty() : !pSSysUniState.isKey2PSDEFIdDirty()) {
            return null;
        }
        String string = pSSysUniState.getKey2PSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Key2PSDEFId_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("KEY2PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Key2PSDEFName(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isKey2PSDEFNameDirty() : !pSSysUniState.isKey2PSDEFNameDirty()) {
            return null;
        }
        String string = pSSysUniState.getKey2PSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Key2PSDEFName_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("KEY2PSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Key3PSDEFId(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isKey3PSDEFIdDirty() : !pSSysUniState.isKey3PSDEFIdDirty()) {
            return null;
        }
        String string = pSSysUniState.getKey3PSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Key3PSDEFId_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("KEY3PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Key3PSDEFName(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isKey3PSDEFNameDirty() : !pSSysUniState.isKey3PSDEFNameDirty()) {
            return null;
        }
        String string = pSSysUniState.getKey3PSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Key3PSDEFName_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("KEY3PSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Key4PSDEFId(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isKey4PSDEFIdDirty() : !pSSysUniState.isKey4PSDEFIdDirty()) {
            return null;
        }
        String string = pSSysUniState.getKey4PSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Key4PSDEFId_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("KEY4PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Key4PSDEFName(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isKey4PSDEFNameDirty() : !pSSysUniState.isKey4PSDEFNameDirty()) {
            return null;
        }
        String string = pSSysUniState.getKey4PSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Key4PSDEFName_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("KEY4PSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Key5PSDEFId(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isKey5PSDEFIdDirty() : !pSSysUniState.isKey5PSDEFIdDirty()) {
            return null;
        }
        String string = pSSysUniState.getKey5PSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Key5PSDEFId_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("KEY5PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Key5PSDEFName(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isKey5PSDEFNameDirty() : !pSSysUniState.isKey5PSDEFNameDirty()) {
            return null;
        }
        String string = pSSysUniState.getKey5PSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Key5PSDEFName_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("KEY5PSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Key6PSDEFId(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isKey6PSDEFIdDirty() : !pSSysUniState.isKey6PSDEFIdDirty()) {
            return null;
        }
        String string = pSSysUniState.getKey6PSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Key6PSDEFId_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("KEY6PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Key6PSDEFName(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isKey6PSDEFNameDirty() : !pSSysUniState.isKey6PSDEFNameDirty()) {
            return null;
        }
        String string = pSSysUniState.getKey6PSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Key6PSDEFName_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("KEY6PSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Key7PSDEFId(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isKey7PSDEFIdDirty() : !pSSysUniState.isKey7PSDEFIdDirty()) {
            return null;
        }
        String string = pSSysUniState.getKey7PSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Key7PSDEFId_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("KEY7PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Key7PSDEFName(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isKey7PSDEFNameDirty() : !pSSysUniState.isKey7PSDEFNameDirty()) {
            return null;
        }
        String string = pSSysUniState.getKey7PSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Key7PSDEFName_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("KEY7PSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Key8PSDEFId(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isKey8PSDEFIdDirty() : !pSSysUniState.isKey8PSDEFIdDirty()) {
            return null;
        }
        String string = pSSysUniState.getKey8PSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Key8PSDEFId_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("KEY8PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Key8PSDEFName(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isKey8PSDEFNameDirty() : !pSSysUniState.isKey8PSDEFNameDirty()) {
            return null;
        }
        String string = pSSysUniState.getKey8PSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Key8PSDEFName_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("KEY8PSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Key9PSDEFId(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isKey9PSDEFIdDirty() : !pSSysUniState.isKey9PSDEFIdDirty()) {
            return null;
        }
        String string = pSSysUniState.getKey9PSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Key9PSDEFId_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("KEY9PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Key9PSDEFName(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isKey9PSDEFNameDirty() : !pSSysUniState.isKey9PSDEFNameDirty()) {
            return null;
        }
        String string = pSSysUniState.getKey9PSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Key9PSDEFName_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("KEY9PSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_KeyFormat(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isKeyFormatDirty() : !pSSysUniState.isKeyFormatDirty()) {
            return null;
        }
        String string = pSSysUniState.getKeyFormat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_KeyFormat_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("KEYFORMAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_KeyPSDEFId(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isKeyPSDEFIdDirty() : !pSSysUniState.isKeyPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysUniState.getKeyPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_KeyPSDEFId_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("KEYPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_KeyPSDEFName(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isKeyPSDEFNameDirty() : !pSSysUniState.isKeyPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysUniState.getKeyPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_KeyPSDEFName_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("KEYPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isLockFlagDirty() : !pSSysUniState.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSSysUniState.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOCKFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isMemoDirty() : !pSSysUniState.isMemoDirty()) {
            return null;
        }
        String string = pSSysUniState.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysUniState, bl2, bl3);
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

    protected EntityFieldError onCheckField_MonitorFormat(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isMonitorFormatDirty() : !pSSysUniState.isMonitorFormatDirty()) {
            return null;
        }
        String string = pSSysUniState.getMonitorFormat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MonitorFormat_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MONITORFORMAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OnChangePSDELogicId(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isOnChangePSDELogicIdDirty() : !pSSysUniState.isOnChangePSDELogicIdDirty()) {
            return null;
        }
        String string = pSSysUniState.getOnChangePSDELogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OnChangePSDELogicId_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ONCHANGEPSDELOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OnDeletePSDELogicId(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isOnDeletePSDELogicIdDirty() : !pSSysUniState.isOnDeletePSDELogicIdDirty()) {
            return null;
        }
        String string = pSSysUniState.getOnDeletePSDELogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OnDeletePSDELogicId_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ONDELETEPSDELOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDataSetId(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isPSDEDataSetIdDirty() : !pSSysUniState.isPSDEDataSetIdDirty()) {
            return null;
        }
        String string = pSSysUniState.getPSDEDataSetId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataSetId_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATASETID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isPSDEIdDirty() && !bl2 : !pSSysUniState.isPSDEIdDirty()) {
            return null;
        }
        String string = pSSysUniState.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSSysUniState, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isPSDENameDirty() && !bl2 : !pSSysUniState.isPSDENameDirty()) {
            return null;
        }
        String string = pSSysUniState.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default((IEntity)pSSysUniState, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isPSModuleIdDirty() : !pSSysUniState.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSSysUniState.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isPSSysSFPluginIdDirty() : !pSSysUniState.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSSysUniState.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSFPLUGINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isPSSystemIdDirty() : !pSSysUniState.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysUniState.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isPSSystemNameDirty() : !pSSysUniState.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSysUniState.getPSSystemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysUniStateId(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isPSSysUniStateIdDirty() && !bl2 : !pSSysUniState.isPSSysUniStateIdDirty()) {
            return null;
        }
        String string = pSSysUniState.getPSSysUniStateId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUNISTATEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUniStateId_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUNISTATEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysUniStateName(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isPSSysUniStateNameDirty() && !bl2 : !pSSysUniState.isPSSysUniStateNameDirty()) {
            return null;
        }
        String string = pSSysUniState.getPSSysUniStateName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUNISTATENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUniStateName_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUNISTATENAME");
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
                string3 = "PSMODULEID";
                string3 = string3 + ";";
                string3 = string3 + "PSSYSTEMID";
                String string4 = this.checkFieldDupRule(this.getPSSysUniStateDEModel(), "PSSYSUNISTATENAME", string3, pSSysUniState, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSUNISTATENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysUtilDEId(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isPSSysUtilDEIdDirty() : !pSSysUniState.isPSSysUtilDEIdDirty()) {
            return null;
        }
        String string = pSSysUniState.getPSSysUtilDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUtilDEId_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUTILDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ReloadTimer(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isReloadTimerDirty() : !pSSysUniState.isReloadTimerDirty()) {
            return null;
        }
        Integer n = pSSysUniState.getReloadTimer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ReloadTimer_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RELOADTIMER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_State2PSDEFId(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isState2PSDEFIdDirty() : !pSSysUniState.isState2PSDEFIdDirty()) {
            return null;
        }
        String string = pSSysUniState.getState2PSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_State2PSDEFId_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STATE2PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_State2PSDEFName(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isState2PSDEFNameDirty() : !pSSysUniState.isState2PSDEFNameDirty()) {
            return null;
        }
        String string = pSSysUniState.getState2PSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_State2PSDEFName_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STATE2PSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_State3PSDEFId(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isState3PSDEFIdDirty() : !pSSysUniState.isState3PSDEFIdDirty()) {
            return null;
        }
        String string = pSSysUniState.getState3PSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_State3PSDEFId_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STATE3PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_State3PSDEFName(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isState3PSDEFNameDirty() : !pSSysUniState.isState3PSDEFNameDirty()) {
            return null;
        }
        String string = pSSysUniState.getState3PSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_State3PSDEFName_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STATE3PSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_State4PSDEFId(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isState4PSDEFIdDirty() : !pSSysUniState.isState4PSDEFIdDirty()) {
            return null;
        }
        String string = pSSysUniState.getState4PSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_State4PSDEFId_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STATE4PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_State4PSDEFName(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isState4PSDEFNameDirty() : !pSSysUniState.isState4PSDEFNameDirty()) {
            return null;
        }
        String string = pSSysUniState.getState4PSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_State4PSDEFName_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STATE4PSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_State5PSDEFId(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isState5PSDEFIdDirty() : !pSSysUniState.isState5PSDEFIdDirty()) {
            return null;
        }
        String string = pSSysUniState.getState5PSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_State5PSDEFId_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STATE5PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_State5PSDEFName(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isState5PSDEFNameDirty() : !pSSysUniState.isState5PSDEFNameDirty()) {
            return null;
        }
        String string = pSSysUniState.getState5PSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_State5PSDEFName_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STATE5PSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_State6PSDEFId(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isState6PSDEFIdDirty() : !pSSysUniState.isState6PSDEFIdDirty()) {
            return null;
        }
        String string = pSSysUniState.getState6PSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_State6PSDEFId_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STATE6PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_State6PSDEFName(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isState6PSDEFNameDirty() : !pSSysUniState.isState6PSDEFNameDirty()) {
            return null;
        }
        String string = pSSysUniState.getState6PSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_State6PSDEFName_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STATE6PSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_State7PSDEFId(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isState7PSDEFIdDirty() : !pSSysUniState.isState7PSDEFIdDirty()) {
            return null;
        }
        String string = pSSysUniState.getState7PSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_State7PSDEFId_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STATE7PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_State7PSDEFName(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isState7PSDEFNameDirty() : !pSSysUniState.isState7PSDEFNameDirty()) {
            return null;
        }
        String string = pSSysUniState.getState7PSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_State7PSDEFName_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STATE7PSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_State8PSDEFId(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isState8PSDEFIdDirty() : !pSSysUniState.isState8PSDEFIdDirty()) {
            return null;
        }
        String string = pSSysUniState.getState8PSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_State8PSDEFId_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STATE8PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_State8PSDEFName(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isState8PSDEFNameDirty() : !pSSysUniState.isState8PSDEFNameDirty()) {
            return null;
        }
        String string = pSSysUniState.getState8PSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_State8PSDEFName_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STATE8PSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StatePSDEFId(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isStatePSDEFIdDirty() : !pSSysUniState.isStatePSDEFIdDirty()) {
            return null;
        }
        String string = pSSysUniState.getStatePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StatePSDEFId_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STATEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StatePSDEFName(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isStatePSDEFNameDirty() : !pSSysUniState.isStatePSDEFNameDirty()) {
            return null;
        }
        String string = pSSysUniState.getStatePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StatePSDEFName_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STATEPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UniqueTag(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isUniqueTagDirty() && !bl2 : !pSSysUniState.isUniqueTagDirty()) {
            return null;
        }
        String string = pSSysUniState.getUniqueTag();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UNIQUETAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_UniqueTag_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UNIQUETAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSMODULEID";
                string3 = string3 + ";";
                string3 = string3 + "PSSYSTEMID";
                String string4 = this.checkFieldDupRule(this.getPSSysUniStateDEModel(), "UNIQUETAG", string3, pSSysUniState, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("UNIQUETAG");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UniStateMode(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isUniStateModeDirty() : !pSSysUniState.isUniStateModeDirty()) {
            return null;
        }
        String string = pSSysUniState.getUniStateMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UniStateMode_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UNISTATEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UniStateParams(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isUniStateParamsDirty() : !pSSysUniState.isUniStateParamsDirty()) {
            return null;
        }
        String string = pSSysUniState.getUniStateParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UniStateParams_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UNISTATEPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UniStateTag(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isUniStateTagDirty() : !pSSysUniState.isUniStateTagDirty()) {
            return null;
        }
        String string = pSSysUniState.getUniStateTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UniStateTag_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UNISTATETAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UniStateTag2(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isUniStateTag2Dirty() : !pSSysUniState.isUniStateTag2Dirty()) {
            return null;
        }
        String string = pSSysUniState.getUniStateTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UniStateTag2_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UNISTATETAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UniStateType(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isUniStateTypeDirty() && !bl2 : !pSSysUniState.isUniStateTypeDirty()) {
            return null;
        }
        String string = pSSysUniState.getUniStateType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UNISTATETYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_UniStateType_Default((IEntity)pSSysUniState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UNISTATETYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isUserCatDirty() : !pSSysUniState.isUserCatDirty()) {
            return null;
        }
        String string = pSSysUniState.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSSysUniState, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isUserTagDirty() : !pSSysUniState.isUserTagDirty()) {
            return null;
        }
        String string = pSSysUniState.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSSysUniState, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isUserTag2Dirty() : !pSSysUniState.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysUniState.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSSysUniState, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isUserTag3Dirty() : !pSSysUniState.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysUniState.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSSysUniState, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isUserTag4Dirty() : !pSSysUniState.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysUniState.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSSysUniState, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysUniState pSSysUniState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUniState.isValidFlagDirty() && !bl2 : !pSSysUniState.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysUniState.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSSysUniState, bl2, bl3);
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

    protected void onSyncEntity(PSSysUniState pSSysUniState, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysUniState, bl);
    }

    protected void onSyncIndexEntities(PSSysUniState pSSysUniState, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysUniState, bl);
    }

    public Object getDataContextValue(PSSysUniState pSSysUniState, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysUniState, string, iDataContextParam)) != null) {
            return object;
        }
        PSModule pSModule = pSSysUniState.getPSModule();
        if (pSModule != null && pSModule.contains(string)) {
            return pSModule.get(string);
        }
        PSSystem pSSystem = pSSysUniState.getPSSystem();
        if (pSSystem != null && pSSystem.contains(string)) {
            return pSSystem.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysUniState pSSysUniState, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysUniState, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ALLDATAFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AllDataFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CACHECAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CacheCat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CACHESCOPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CacheScope_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CACHETIMEOUT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CacheTimeout_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEDEFAULTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEDefaultFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DELETEASUPDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DeleteAsUpdate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INITPSDELOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InitPSDELogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INITPSDELOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InitPSDELogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"KEY2PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Key2PSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"KEY2PSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Key2PSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"KEY3PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Key3PSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"KEY3PSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Key3PSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"KEY4PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Key4PSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"KEY4PSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Key4PSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"KEY5PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Key5PSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"KEY5PSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Key5PSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"KEY6PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Key6PSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"KEY6PSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Key6PSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"KEY7PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Key7PSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"KEY7PSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Key7PSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"KEY8PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Key8PSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"KEY8PSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Key8PSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"KEY9PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Key9PSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"KEY9PSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Key9PSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"KEYFORMAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_KeyFormat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"KEYPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_KeyPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"KEYPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_KeyPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MONITORFORMAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MonitorFormat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ONCHANGEPSDELOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OnChangePSDELogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ONCHANGEPSDELOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OnChangePSDELogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ONDELETEPSDELOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OnDeletePSDELogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ONDELETEPSDELOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OnDeletePSDELogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATASETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataSetId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATASETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataSetName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUNISTATEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUniStateId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUNISTATENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUniStateName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUTILDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUtilDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUTILDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUtilDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RELOADTIMER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ReloadTimer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STATE2PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_State2PSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STATE2PSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_State2PSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STATE3PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_State3PSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STATE3PSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_State3PSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STATE4PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_State4PSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STATE4PSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_State4PSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STATE5PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_State5PSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STATE5PSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_State5PSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STATE6PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_State6PSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STATE6PSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_State6PSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STATE7PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_State7PSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STATE7PSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_State7PSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STATE8PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_State8PSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STATE8PSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_State8PSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STATEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StatePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STATEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StatePSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UNIQUETAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UniqueTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UNISTATEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UniStateMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UNISTATEPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UniStateParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UNISTATETAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UniStateTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UNISTATETAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UniStateTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UNISTATETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UniStateType_Default(iEntity, bl, bl2);
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
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AllDataFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CacheCat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CACHECAT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CacheScope_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CACHESCOPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CacheTimeout_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_CustomCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CUSTOMCODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CustomMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DEDefaultFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DeleteAsUpdate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_InitPSDELogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INITPSDELOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InitPSDELogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INITPSDELOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Key2PSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("KEY2PSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Key2PSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("KEY2PSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Key3PSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("KEY3PSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Key3PSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("KEY3PSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Key4PSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("KEY4PSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Key4PSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("KEY4PSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Key5PSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("KEY5PSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Key5PSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("KEY5PSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Key6PSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("KEY6PSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Key6PSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("KEY6PSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Key7PSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("KEY7PSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Key7PSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("KEY7PSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Key8PSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("KEY8PSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Key8PSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("KEY8PSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Key9PSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("KEY9PSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Key9PSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("KEY9PSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_KeyFormat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("KEYFORMAT", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_KeyPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("KEYPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_KeyPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("KEYPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LockFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Memo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MonitorFormat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MONITORFORMAT", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OnChangePSDELogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ONCHANGEPSDELOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OnChangePSDELogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ONCHANGEPSDELOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OnDeletePSDELogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ONDELETEPSDELOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OnDeletePSDELogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ONDELETEPSDELOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDataSetId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATASETID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDataSetName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATASETNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_PSModuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSFPluginId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSFPLUGINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSFPluginName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSFPLUGINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUniStateId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUNISTATEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUniStateName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUNISTATENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUtilDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUTILDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUtilDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUTILDENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ReloadTimer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_State2PSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STATE2PSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_State2PSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STATE2PSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_State3PSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STATE3PSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_State3PSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STATE3PSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_State4PSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STATE4PSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_State4PSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STATE4PSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_State5PSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STATE5PSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_State5PSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STATE5PSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_State6PSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STATE6PSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_State6PSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STATE6PSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_State7PSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STATE7PSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_State7PSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STATE7PSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_State8PSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STATE8PSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_State8PSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STATE8PSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StatePSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STATEPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StatePSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STATEPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UniqueTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UNIQUETAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false) && this.checkFieldRegExRule("UNIQUETAG", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UniStateMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UNISTATEMODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UniStateParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UNISTATEPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UniStateTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UNISTATETAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UniStateTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UNISTATETAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UniStateType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UNISTATETYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysUniState pSSysUniState) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysUniState)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysUniState pSSysUniState) throws Exception {
        super.onUpdateParent((IEntity)pSSysUniState);
    }

    @Override
    protected void exportCurXmlModel(PSSysUniState pSSysUniState, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSUNISTATE");
        if (!bl) {
            pSSysUniState.setCreateDate(null);
            pSSysUniState.setCreateMan(null);
            pSSysUniState.setPSSysUniStateId(null);
            pSSysUniState.setUpdateDate(null);
            pSSysUniState.setUpdateMan(null);
            super.exportCurXmlModel(pSSysUniState, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysUniState pSSysUniState, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysUniState, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSMODULE#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSTEM#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSUNISTATE_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSUNISTATE_PSSYSTEM_PSSYSTEMID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULENAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSMODULE", (boolean)true) == 0) {
            iEntity.set("PSMODULEID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEM", (boolean)true) == 0) {
            iEntity.set("PSSYSTEMID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSMODULEID", "PSSYSTEMID"};
    }

    @Override
    public String getModelV2Tag(PSSysUniState pSSysUniState) {
        if (!StringHelper.isNullOrEmpty((String)pSSysUniState.getUniqueTag())) {
            return pSSysUniState.getUniqueTag();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysUniState.getPSSysUniStateName())) {
            return pSSysUniState.getPSSysUniStateName();
        }
        return super.getModelV2Tag(pSSysUniState);
    }

    @Override
    public boolean setModelV2Tag(PSSysUniState pSSysUniState, String string) {
        pSSysUniState.setUniqueTag(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("UNIQUETAG", "");
        map.put("PSSYSUNISTATENAME", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysUniState pSSysUniState, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysUniState.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysUniState, true);
        pSSysUniState.set("UNIQUETAG", string);
        if (this.select(pSSysUniState, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysUniState, true);
        return super.getModelV2Entity(pSSysUniState, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysUniState pSSysUniState, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysUniState, objectNode, string, string2, n);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysUniState pSSysUniState, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("PSSYSUNISTATENAME", "\u72b6\u6001\u534f\u540c");
        defaultValueMap.put("UNIQUETAG", "UNISTATE");
    }
}

