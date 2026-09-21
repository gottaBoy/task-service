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
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.appdesign.service;

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
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.appdesign.dao.PSAppUtilDAO;
import net.ibizsys.pscore.srv.appdesign.demodel.PSAppUtilDEModel;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppUtil;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPluginBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysAppBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppUtilServiceBase
extends PSCoreSysServiceBase<PSAppUtil> {
    private static final Log log = LogFactory.getLog(PSAppUtilServiceBase.class);
    public static final String DATASET_CURAPP = "CurApp";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSAppUtilDEModel pSAppUtilDEModel;
    private PSAppUtilDAO pSAppUtilDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.appdesign.service.PSAppUtilService";
    }

    public PSAppUtilDEModel getPSAppUtilDEModel() {
        if (this.pSAppUtilDEModel == null) {
            try {
                this.pSAppUtilDEModel = (PSAppUtilDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.appdesign.demodel.PSAppUtilDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppUtilDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSAppUtilDEModel();
    }

    public PSAppUtilDAO getPSAppUtilDAO() {
        if (this.pSAppUtilDAO == null) {
            try {
                this.pSAppUtilDAO = (PSAppUtilDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.appdesign.dao.PSAppUtilDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppUtilDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSAppUtilDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAPP, (boolean)true) == 0) {
            return this.fetchCurApp(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurApp(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPP, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSAppUtil pSAppUtil, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPUTIL_PSDATAENTITY_UTILPSDE2ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE2(pSAppUtil, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPUTIL_PSDATAENTITY_UTILPSDE3ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE3(pSAppUtil, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPUTIL_PSDATAENTITY_UTILPSDE4ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE4(pSAppUtil, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPUTIL_PSDATAENTITY_UTILPSDE5ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE5(pSAppUtil, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPUTIL_PSDATAENTITY_UTILPSDE6ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE6(pSAppUtil, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPUTIL_PSDATAENTITY_UTILPSDE7ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE7(pSAppUtil, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPUTIL_PSDATAENTITY_UTILPSDE8ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE8(pSAppUtil, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPUTIL_PSDATAENTITY_UTILPSDE9ID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE9(pSAppUtil, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPUTIL_PSDATAENTITY_UTILPSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_UtilPSDE(pSAppUtil, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPUTIL_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService", (SessionFactory)this.getSessionFactory());
            PSSysApp pSSysApp = (PSSysApp)iService.getDEModel().createEntity();
            pSSysApp.set("PSSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysApp);
            } else {
                iService.get((IEntity)pSSysApp);
            }
            this.onFillParentInfo_PSSysApp(pSAppUtil, pSSysApp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPUTIL_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDynaModel);
            } else {
                iService.get((IEntity)pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSAppUtil, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPUTIL_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysPFPlugin);
            } else {
                iService.get((IEntity)pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSAppUtil, pSSysPFPlugin);
            return;
        }
        super.onFillParentInfo((IEntity)pSAppUtil, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_UtilPSDE2(PSAppUtil pSAppUtil, PSDataEntity pSDataEntity) throws Exception {
        pSAppUtil.setUtilPSDE2Id(pSDataEntity.getPSDataEntityId());
        pSAppUtil.setUtilPSDE2Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE3(PSAppUtil pSAppUtil, PSDataEntity pSDataEntity) throws Exception {
        pSAppUtil.setUtilPSDE3Id(pSDataEntity.getPSDataEntityId());
        pSAppUtil.setUtilPSDE3Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE4(PSAppUtil pSAppUtil, PSDataEntity pSDataEntity) throws Exception {
        pSAppUtil.setUtilPSDE4Id(pSDataEntity.getPSDataEntityId());
        pSAppUtil.setUtilPSDE4Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE5(PSAppUtil pSAppUtil, PSDataEntity pSDataEntity) throws Exception {
        pSAppUtil.setUtilPSDE5Id(pSDataEntity.getPSDataEntityId());
        pSAppUtil.setUtilPSDE5Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE6(PSAppUtil pSAppUtil, PSDataEntity pSDataEntity) throws Exception {
        pSAppUtil.setUtilPSDE6Id(pSDataEntity.getPSDataEntityId());
        pSAppUtil.setUtilPSDE6Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE7(PSAppUtil pSAppUtil, PSDataEntity pSDataEntity) throws Exception {
        pSAppUtil.setUtilPSDE7Id(pSDataEntity.getPSDataEntityId());
        pSAppUtil.setUtilPSDE7Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE8(PSAppUtil pSAppUtil, PSDataEntity pSDataEntity) throws Exception {
        pSAppUtil.setUtilPSDE8Id(pSDataEntity.getPSDataEntityId());
        pSAppUtil.setUtilPSDE8Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE9(PSAppUtil pSAppUtil, PSDataEntity pSDataEntity) throws Exception {
        pSAppUtil.setUtilPSDE9Id(pSDataEntity.getPSDataEntityId());
        pSAppUtil.setUtilPSDE9Name(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_UtilPSDE(PSAppUtil pSAppUtil, PSDataEntity pSDataEntity) throws Exception {
        pSAppUtil.setUtilPSDEId(pSDataEntity.getPSDataEntityId());
        pSAppUtil.setUtilPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSSysApp(PSAppUtil pSAppUtil, PSSysApp pSSysApp) throws Exception {
        pSAppUtil.setPSSysAppId(pSSysApp.getPSSysAppId());
        pSAppUtil.setPSSysAppName(pSSysApp.getPSSysAppName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSAppUtil pSAppUtil, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSAppUtil.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSAppUtil.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSAppUtil pSAppUtil, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSAppUtil.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSAppUtil.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected boolean onFillEntityKeyValue(PSAppUtil pSAppUtil, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSAppUtil.get("PSSYSAPPID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSAppUtil.get("UTILTYPE");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        stringBuilderEx.append("||");
        Object object3 = pSAppUtil.get("UTILTAG");
        if (object3 == null) {
            object3 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object3);
        String string = stringBuilderEx.toString();
        pSAppUtil.set(this.getPSAppUtilDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSAppUtil pSAppUtil, boolean bl) throws Exception {
        if (bl) {
            if (pSAppUtil.getCodeName() == null) {
                pSAppUtil.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "AppUtil", 25));
            }
            if (pSAppUtil.getValidFlag() == null) {
                pSAppUtil.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSAppUtil, bl);
        this.onFillEntityFullInfo_UtilPSDE2(pSAppUtil, bl);
        this.onFillEntityFullInfo_UtilPSDE3(pSAppUtil, bl);
        this.onFillEntityFullInfo_UtilPSDE4(pSAppUtil, bl);
        this.onFillEntityFullInfo_UtilPSDE5(pSAppUtil, bl);
        this.onFillEntityFullInfo_UtilPSDE6(pSAppUtil, bl);
        this.onFillEntityFullInfo_UtilPSDE7(pSAppUtil, bl);
        this.onFillEntityFullInfo_UtilPSDE8(pSAppUtil, bl);
        this.onFillEntityFullInfo_UtilPSDE9(pSAppUtil, bl);
        this.onFillEntityFullInfo_UtilPSDE(pSAppUtil, bl);
        this.onFillEntityFullInfo_PSSysApp(pSAppUtil, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSAppUtil, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSAppUtil, bl);
    }

    protected void onFillEntityFullInfo_UtilPSDE2(PSAppUtil pSAppUtil, boolean bl) throws Exception {
        if (pSAppUtil.isUtilPSDE2IdDirty()) {
            if (pSAppUtil.getUtilPSDE2Id() != null) {
                if (pSAppUtil.getUtilPSDE2Id() == null || pSAppUtil.getUtilPSDE2Name() == null) {
                    PSDataEntity pSDataEntity = pSAppUtil.getUtilPSDE2();
                    pSAppUtil.setUtilPSDE2Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSAppUtil.setUtilPSDE2Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE3(PSAppUtil pSAppUtil, boolean bl) throws Exception {
        if (pSAppUtil.isUtilPSDE3IdDirty()) {
            if (pSAppUtil.getUtilPSDE3Id() != null) {
                if (pSAppUtil.getUtilPSDE3Id() == null || pSAppUtil.getUtilPSDE3Name() == null) {
                    PSDataEntity pSDataEntity = pSAppUtil.getUtilPSDE3();
                    pSAppUtil.setUtilPSDE3Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSAppUtil.setUtilPSDE3Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE4(PSAppUtil pSAppUtil, boolean bl) throws Exception {
        if (pSAppUtil.isUtilPSDE4IdDirty()) {
            if (pSAppUtil.getUtilPSDE4Id() != null) {
                if (pSAppUtil.getUtilPSDE4Id() == null || pSAppUtil.getUtilPSDE4Name() == null) {
                    PSDataEntity pSDataEntity = pSAppUtil.getUtilPSDE4();
                    pSAppUtil.setUtilPSDE4Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSAppUtil.setUtilPSDE4Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE5(PSAppUtil pSAppUtil, boolean bl) throws Exception {
        if (pSAppUtil.isUtilPSDE5IdDirty()) {
            if (pSAppUtil.getUtilPSDE5Id() != null) {
                if (pSAppUtil.getUtilPSDE5Id() == null || pSAppUtil.getUtilPSDE5Name() == null) {
                    PSDataEntity pSDataEntity = pSAppUtil.getUtilPSDE5();
                    pSAppUtil.setUtilPSDE5Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSAppUtil.setUtilPSDE5Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE6(PSAppUtil pSAppUtil, boolean bl) throws Exception {
        if (pSAppUtil.isUtilPSDE6IdDirty()) {
            if (pSAppUtil.getUtilPSDE6Id() != null) {
                if (pSAppUtil.getUtilPSDE6Id() == null || pSAppUtil.getUtilPSDE6Name() == null) {
                    PSDataEntity pSDataEntity = pSAppUtil.getUtilPSDE6();
                    pSAppUtil.setUtilPSDE6Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSAppUtil.setUtilPSDE6Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE7(PSAppUtil pSAppUtil, boolean bl) throws Exception {
        if (pSAppUtil.isUtilPSDE7IdDirty()) {
            if (pSAppUtil.getUtilPSDE7Id() != null) {
                if (pSAppUtil.getUtilPSDE7Id() == null || pSAppUtil.getUtilPSDE7Name() == null) {
                    PSDataEntity pSDataEntity = pSAppUtil.getUtilPSDE7();
                    pSAppUtil.setUtilPSDE7Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSAppUtil.setUtilPSDE7Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE8(PSAppUtil pSAppUtil, boolean bl) throws Exception {
        if (pSAppUtil.isUtilPSDE8IdDirty()) {
            if (pSAppUtil.getUtilPSDE8Id() != null) {
                if (pSAppUtil.getUtilPSDE8Id() == null || pSAppUtil.getUtilPSDE8Name() == null) {
                    PSDataEntity pSDataEntity = pSAppUtil.getUtilPSDE8();
                    pSAppUtil.setUtilPSDE8Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSAppUtil.setUtilPSDE8Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE9(PSAppUtil pSAppUtil, boolean bl) throws Exception {
        if (pSAppUtil.isUtilPSDE9IdDirty()) {
            if (pSAppUtil.getUtilPSDE9Id() != null) {
                if (pSAppUtil.getUtilPSDE9Id() == null || pSAppUtil.getUtilPSDE9Name() == null) {
                    PSDataEntity pSDataEntity = pSAppUtil.getUtilPSDE9();
                    pSAppUtil.setUtilPSDE9Name(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSAppUtil.setUtilPSDE9Name(null);
            }
        }
    }

    protected void onFillEntityFullInfo_UtilPSDE(PSAppUtil pSAppUtil, boolean bl) throws Exception {
        if (pSAppUtil.isUtilPSDEIdDirty()) {
            if (pSAppUtil.getUtilPSDEId() != null) {
                if (pSAppUtil.getUtilPSDEId() == null || pSAppUtil.getUtilPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSAppUtil.getUtilPSDE();
                    pSAppUtil.setUtilPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSAppUtil.setUtilPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysApp(PSAppUtil pSAppUtil, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSAppUtil pSAppUtil, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSAppUtil pSAppUtil, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSAppUtil pSAppUtil, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSAppUtil, bl);
    }

    public ArrayList<PSAppUtil> selectByUtilPSDE2(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE2(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSAppUtil> selectByUtilPSDE2(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE2(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSAppUtil> selectByUtilPSDE2(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UTILPSDE2ID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUtilPSDE2Cond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUtilPSDE2Cond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppUtil> selectByUtilPSDE3(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE3(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSAppUtil> selectByUtilPSDE3(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE3(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSAppUtil> selectByUtilPSDE3(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UTILPSDE3ID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUtilPSDE3Cond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUtilPSDE3Cond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppUtil> selectByUtilPSDE4(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE4(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSAppUtil> selectByUtilPSDE4(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE4(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSAppUtil> selectByUtilPSDE4(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UTILPSDE4ID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUtilPSDE4Cond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUtilPSDE4Cond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppUtil> selectByUtilPSDE5(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE5(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSAppUtil> selectByUtilPSDE5(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE5(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSAppUtil> selectByUtilPSDE5(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UTILPSDE5ID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUtilPSDE5Cond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUtilPSDE5Cond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppUtil> selectByUtilPSDE6(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE6(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSAppUtil> selectByUtilPSDE6(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE6(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSAppUtil> selectByUtilPSDE6(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UTILPSDE6ID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUtilPSDE6Cond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUtilPSDE6Cond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppUtil> selectByUtilPSDE7(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE7(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSAppUtil> selectByUtilPSDE7(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE7(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSAppUtil> selectByUtilPSDE7(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UTILPSDE7ID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUtilPSDE7Cond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUtilPSDE7Cond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppUtil> selectByUtilPSDE8(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE8(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSAppUtil> selectByUtilPSDE8(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE8(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSAppUtil> selectByUtilPSDE8(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UTILPSDE8ID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUtilPSDE8Cond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUtilPSDE8Cond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppUtil> selectByUtilPSDE9(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE9(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSAppUtil> selectByUtilPSDE9(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE9(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSAppUtil> selectByUtilPSDE9(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UTILPSDE9ID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUtilPSDE9Cond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUtilPSDE9Cond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppUtil> selectByUtilPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByUtilPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSAppUtil> selectByUtilPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByUtilPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSAppUtil> selectByUtilPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UTILPSDEID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUtilPSDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUtilPSDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppUtil> selectByPSSysApp(PSSysAppBase pSSysAppBase) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, "", -1);
    }

    public ArrayList<PSAppUtil> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, string, -1);
    }

    public ArrayList<PSAppUtil> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSAPPID", (Object)pSSysAppBase.getPSSysAppId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysAppCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysAppCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppUtil> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSAppUtil> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSAppUtil> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSDYNAMODELID", (Object)pSSysDynaModelBase.getPSSysDynaModelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysDynaModelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysDynaModelCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppUtil> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSAppUtil> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSAppUtil> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
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

    public void testRemoveByUtilPSDE2(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSAppUtil> arrayList = this.selectByUtilPSDE2(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPUTIL_PSDATAENTITY_UTILPSDE2ID", "", iDataEntityModel.getName(), "PSAPPUTIL", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE2(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSAppUtil> arrayList = this.selectByUtilPSDE2(pSDataEntity);
        for (PSAppUtil pSAppUtil : arrayList) {
            PSAppUtil pSAppUtil2 = (PSAppUtil)this.getDEModel().createEntity();
            pSAppUtil2.setPSAppUtilId(pSAppUtil.getPSAppUtilId());
            pSAppUtil2.setUtilPSDE2Id(null);
            this.update(pSAppUtil2);
        }
    }

    public void removeByUtilPSDE2(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppUtilServiceBase.this.onBeforeRemoveByUtilPSDE2(pSDataEntity2);
                PSAppUtilServiceBase.this.internalRemoveByUtilPSDE2(pSDataEntity2);
                PSAppUtilServiceBase.this.onAfterRemoveByUtilPSDE2(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE2(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE2(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSAppUtil> arrayList = this.selectByUtilPSDE2(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE2(pSDataEntity, arrayList);
        for (PSAppUtil pSAppUtil : arrayList) {
            this.remove((IEntity)pSAppUtil);
        }
        this.onAfterRemoveByUtilPSDE2(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE2(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE2(PSDataEntity pSDataEntity, ArrayList<PSAppUtil> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE2(PSDataEntity pSDataEntity, ArrayList<PSAppUtil> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE3(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSAppUtil> arrayList = this.selectByUtilPSDE3(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPUTIL_PSDATAENTITY_UTILPSDE3ID", "", iDataEntityModel.getName(), "PSAPPUTIL", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE3(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSAppUtil> arrayList = this.selectByUtilPSDE3(pSDataEntity);
        for (PSAppUtil pSAppUtil : arrayList) {
            PSAppUtil pSAppUtil2 = (PSAppUtil)this.getDEModel().createEntity();
            pSAppUtil2.setPSAppUtilId(pSAppUtil.getPSAppUtilId());
            pSAppUtil2.setUtilPSDE3Id(null);
            this.update(pSAppUtil2);
        }
    }

    public void removeByUtilPSDE3(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppUtilServiceBase.this.onBeforeRemoveByUtilPSDE3(pSDataEntity2);
                PSAppUtilServiceBase.this.internalRemoveByUtilPSDE3(pSDataEntity2);
                PSAppUtilServiceBase.this.onAfterRemoveByUtilPSDE3(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE3(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE3(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSAppUtil> arrayList = this.selectByUtilPSDE3(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE3(pSDataEntity, arrayList);
        for (PSAppUtil pSAppUtil : arrayList) {
            this.remove((IEntity)pSAppUtil);
        }
        this.onAfterRemoveByUtilPSDE3(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE3(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE3(PSDataEntity pSDataEntity, ArrayList<PSAppUtil> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE3(PSDataEntity pSDataEntity, ArrayList<PSAppUtil> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE4(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSAppUtil> arrayList = this.selectByUtilPSDE4(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPUTIL_PSDATAENTITY_UTILPSDE4ID", "", iDataEntityModel.getName(), "PSAPPUTIL", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE4(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSAppUtil> arrayList = this.selectByUtilPSDE4(pSDataEntity);
        for (PSAppUtil pSAppUtil : arrayList) {
            PSAppUtil pSAppUtil2 = (PSAppUtil)this.getDEModel().createEntity();
            pSAppUtil2.setPSAppUtilId(pSAppUtil.getPSAppUtilId());
            pSAppUtil2.setUtilPSDE4Id(null);
            this.update(pSAppUtil2);
        }
    }

    public void removeByUtilPSDE4(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppUtilServiceBase.this.onBeforeRemoveByUtilPSDE4(pSDataEntity2);
                PSAppUtilServiceBase.this.internalRemoveByUtilPSDE4(pSDataEntity2);
                PSAppUtilServiceBase.this.onAfterRemoveByUtilPSDE4(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE4(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE4(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSAppUtil> arrayList = this.selectByUtilPSDE4(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE4(pSDataEntity, arrayList);
        for (PSAppUtil pSAppUtil : arrayList) {
            this.remove((IEntity)pSAppUtil);
        }
        this.onAfterRemoveByUtilPSDE4(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE4(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE4(PSDataEntity pSDataEntity, ArrayList<PSAppUtil> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE4(PSDataEntity pSDataEntity, ArrayList<PSAppUtil> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE5(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSAppUtil> arrayList = this.selectByUtilPSDE5(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPUTIL_PSDATAENTITY_UTILPSDE5ID", "", iDataEntityModel.getName(), "PSAPPUTIL", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE5(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSAppUtil> arrayList = this.selectByUtilPSDE5(pSDataEntity);
        for (PSAppUtil pSAppUtil : arrayList) {
            PSAppUtil pSAppUtil2 = (PSAppUtil)this.getDEModel().createEntity();
            pSAppUtil2.setPSAppUtilId(pSAppUtil.getPSAppUtilId());
            pSAppUtil2.setUtilPSDE5Id(null);
            this.update(pSAppUtil2);
        }
    }

    public void removeByUtilPSDE5(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppUtilServiceBase.this.onBeforeRemoveByUtilPSDE5(pSDataEntity2);
                PSAppUtilServiceBase.this.internalRemoveByUtilPSDE5(pSDataEntity2);
                PSAppUtilServiceBase.this.onAfterRemoveByUtilPSDE5(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE5(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE5(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSAppUtil> arrayList = this.selectByUtilPSDE5(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE5(pSDataEntity, arrayList);
        for (PSAppUtil pSAppUtil : arrayList) {
            this.remove((IEntity)pSAppUtil);
        }
        this.onAfterRemoveByUtilPSDE5(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE5(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE5(PSDataEntity pSDataEntity, ArrayList<PSAppUtil> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE5(PSDataEntity pSDataEntity, ArrayList<PSAppUtil> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE6(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSAppUtil> arrayList = this.selectByUtilPSDE6(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPUTIL_PSDATAENTITY_UTILPSDE6ID", "", iDataEntityModel.getName(), "PSAPPUTIL", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE6(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSAppUtil> arrayList = this.selectByUtilPSDE6(pSDataEntity);
        for (PSAppUtil pSAppUtil : arrayList) {
            PSAppUtil pSAppUtil2 = (PSAppUtil)this.getDEModel().createEntity();
            pSAppUtil2.setPSAppUtilId(pSAppUtil.getPSAppUtilId());
            pSAppUtil2.setUtilPSDE6Id(null);
            this.update(pSAppUtil2);
        }
    }

    public void removeByUtilPSDE6(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppUtilServiceBase.this.onBeforeRemoveByUtilPSDE6(pSDataEntity2);
                PSAppUtilServiceBase.this.internalRemoveByUtilPSDE6(pSDataEntity2);
                PSAppUtilServiceBase.this.onAfterRemoveByUtilPSDE6(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE6(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE6(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSAppUtil> arrayList = this.selectByUtilPSDE6(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE6(pSDataEntity, arrayList);
        for (PSAppUtil pSAppUtil : arrayList) {
            this.remove((IEntity)pSAppUtil);
        }
        this.onAfterRemoveByUtilPSDE6(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE6(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE6(PSDataEntity pSDataEntity, ArrayList<PSAppUtil> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE6(PSDataEntity pSDataEntity, ArrayList<PSAppUtil> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE7(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSAppUtil> arrayList = this.selectByUtilPSDE7(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPUTIL_PSDATAENTITY_UTILPSDE7ID", "", iDataEntityModel.getName(), "PSAPPUTIL", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE7(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSAppUtil> arrayList = this.selectByUtilPSDE7(pSDataEntity);
        for (PSAppUtil pSAppUtil : arrayList) {
            PSAppUtil pSAppUtil2 = (PSAppUtil)this.getDEModel().createEntity();
            pSAppUtil2.setPSAppUtilId(pSAppUtil.getPSAppUtilId());
            pSAppUtil2.setUtilPSDE7Id(null);
            this.update(pSAppUtil2);
        }
    }

    public void removeByUtilPSDE7(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppUtilServiceBase.this.onBeforeRemoveByUtilPSDE7(pSDataEntity2);
                PSAppUtilServiceBase.this.internalRemoveByUtilPSDE7(pSDataEntity2);
                PSAppUtilServiceBase.this.onAfterRemoveByUtilPSDE7(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE7(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE7(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSAppUtil> arrayList = this.selectByUtilPSDE7(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE7(pSDataEntity, arrayList);
        for (PSAppUtil pSAppUtil : arrayList) {
            this.remove((IEntity)pSAppUtil);
        }
        this.onAfterRemoveByUtilPSDE7(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE7(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE7(PSDataEntity pSDataEntity, ArrayList<PSAppUtil> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE7(PSDataEntity pSDataEntity, ArrayList<PSAppUtil> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE8(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSAppUtil> arrayList = this.selectByUtilPSDE8(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPUTIL_PSDATAENTITY_UTILPSDE8ID", "", iDataEntityModel.getName(), "PSAPPUTIL", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE8(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSAppUtil> arrayList = this.selectByUtilPSDE8(pSDataEntity);
        for (PSAppUtil pSAppUtil : arrayList) {
            PSAppUtil pSAppUtil2 = (PSAppUtil)this.getDEModel().createEntity();
            pSAppUtil2.setPSAppUtilId(pSAppUtil.getPSAppUtilId());
            pSAppUtil2.setUtilPSDE8Id(null);
            this.update(pSAppUtil2);
        }
    }

    public void removeByUtilPSDE8(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppUtilServiceBase.this.onBeforeRemoveByUtilPSDE8(pSDataEntity2);
                PSAppUtilServiceBase.this.internalRemoveByUtilPSDE8(pSDataEntity2);
                PSAppUtilServiceBase.this.onAfterRemoveByUtilPSDE8(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE8(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE8(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSAppUtil> arrayList = this.selectByUtilPSDE8(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE8(pSDataEntity, arrayList);
        for (PSAppUtil pSAppUtil : arrayList) {
            this.remove((IEntity)pSAppUtil);
        }
        this.onAfterRemoveByUtilPSDE8(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE8(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE8(PSDataEntity pSDataEntity, ArrayList<PSAppUtil> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE8(PSDataEntity pSDataEntity, ArrayList<PSAppUtil> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE9(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSAppUtil> arrayList = this.selectByUtilPSDE9(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPUTIL_PSDATAENTITY_UTILPSDE9ID", "", iDataEntityModel.getName(), "PSAPPUTIL", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE9(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSAppUtil> arrayList = this.selectByUtilPSDE9(pSDataEntity);
        for (PSAppUtil pSAppUtil : arrayList) {
            PSAppUtil pSAppUtil2 = (PSAppUtil)this.getDEModel().createEntity();
            pSAppUtil2.setPSAppUtilId(pSAppUtil.getPSAppUtilId());
            pSAppUtil2.setUtilPSDE9Id(null);
            this.update(pSAppUtil2);
        }
    }

    public void removeByUtilPSDE9(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppUtilServiceBase.this.onBeforeRemoveByUtilPSDE9(pSDataEntity2);
                PSAppUtilServiceBase.this.internalRemoveByUtilPSDE9(pSDataEntity2);
                PSAppUtilServiceBase.this.onAfterRemoveByUtilPSDE9(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE9(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE9(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSAppUtil> arrayList = this.selectByUtilPSDE9(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE9(pSDataEntity, arrayList);
        for (PSAppUtil pSAppUtil : arrayList) {
            this.remove((IEntity)pSAppUtil);
        }
        this.onAfterRemoveByUtilPSDE9(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE9(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE9(PSDataEntity pSDataEntity, ArrayList<PSAppUtil> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE9(PSDataEntity pSDataEntity, ArrayList<PSAppUtil> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSAppUtil> arrayList = this.selectByUtilPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPUTIL_PSDATAENTITY_UTILPSDEID", "", iDataEntityModel.getName(), "PSAPPUTIL", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetUtilPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSAppUtil> arrayList = this.selectByUtilPSDE(pSDataEntity);
        for (PSAppUtil pSAppUtil : arrayList) {
            PSAppUtil pSAppUtil2 = (PSAppUtil)this.getDEModel().createEntity();
            pSAppUtil2.setPSAppUtilId(pSAppUtil.getPSAppUtilId());
            pSAppUtil2.setUtilPSDEId(null);
            this.update(pSAppUtil2);
        }
    }

    public void removeByUtilPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppUtilServiceBase.this.onBeforeRemoveByUtilPSDE(pSDataEntity2);
                PSAppUtilServiceBase.this.internalRemoveByUtilPSDE(pSDataEntity2);
                PSAppUtilServiceBase.this.onAfterRemoveByUtilPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByUtilPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSAppUtil> arrayList = this.selectByUtilPSDE(pSDataEntity);
        this.onBeforeRemoveByUtilPSDE(pSDataEntity, arrayList);
        for (PSAppUtil pSAppUtil : arrayList) {
            this.remove((IEntity)pSAppUtil);
        }
        this.onAfterRemoveByUtilPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByUtilPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDE(PSDataEntity pSDataEntity, ArrayList<PSAppUtil> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDE(PSDataEntity pSDataEntity, ArrayList<PSAppUtil> arrayList) throws Exception {
    }

    public void testRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSAppUtil> arrayList = this.selectByPSSysApp(pSSysApp, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSAPP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysApp);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPUTIL_PSSYSAPP_PSSYSAPPID", "", iDataEntityModel.getName(), "PSAPPUTIL", iDataEntityModel.getDataInfo((IEntity)pSSysApp), arrayList.get(0)));
        }
    }

    public void resetPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSAppUtil> arrayList = this.selectByPSSysApp(pSSysApp);
        for (PSAppUtil pSAppUtil : arrayList) {
            PSAppUtil pSAppUtil2 = (PSAppUtil)this.getDEModel().createEntity();
            pSAppUtil2.setPSAppUtilId(pSAppUtil.getPSAppUtilId());
            pSAppUtil2.setPSSysAppId(null);
            this.update(pSAppUtil2);
        }
    }

    public void removeByPSSysApp(PSSysApp pSSysApp) throws Exception {
        final PSSysApp pSSysApp2 = pSSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppUtilServiceBase.this.onBeforeRemoveByPSSysApp(pSSysApp2);
                PSAppUtilServiceBase.this.internalRemoveByPSSysApp(pSSysApp2);
                PSAppUtilServiceBase.this.onAfterRemoveByPSSysApp(pSSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void internalRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSAppUtil> arrayList = this.selectByPSSysApp(pSSysApp);
        this.onBeforeRemoveByPSSysApp(pSSysApp, arrayList);
        for (PSAppUtil pSAppUtil : arrayList) {
            this.remove((IEntity)pSAppUtil);
        }
        this.onAfterRemoveByPSSysApp(pSSysApp, arrayList);
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSAppUtil> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSAppUtil> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSAppUtil> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPUTIL_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSAPPUTIL", iDataEntityModel.getDataInfo((IEntity)pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSAppUtil> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSAppUtil pSAppUtil : arrayList) {
            PSAppUtil pSAppUtil2 = (PSAppUtil)this.getDEModel().createEntity();
            pSAppUtil2.setPSAppUtilId(pSAppUtil.getPSAppUtilId());
            pSAppUtil2.setPSSysDynaModelId(null);
            this.update(pSAppUtil2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppUtilServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSAppUtilServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSAppUtilServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSAppUtil> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSAppUtil pSAppUtil : arrayList) {
            this.remove((IEntity)pSAppUtil);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSAppUtil> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSAppUtil> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSAppUtil> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPUTIL_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSAPPUTIL", iDataEntityModel.getDataInfo((IEntity)pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSAppUtil> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSAppUtil pSAppUtil : arrayList) {
            PSAppUtil pSAppUtil2 = (PSAppUtil)this.getDEModel().createEntity();
            pSAppUtil2.setPSAppUtilId(pSAppUtil.getPSAppUtilId());
            pSAppUtil2.setPSSysPFPluginId(null);
            this.update(pSAppUtil2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppUtilServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSAppUtilServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSAppUtilServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSAppUtil> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSAppUtil pSAppUtil : arrayList) {
            this.remove((IEntity)pSAppUtil);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSAppUtil> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSAppUtil> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSAppUtil pSAppUtil) throws Exception {
        super.onBeforeRemove(pSAppUtil);
    }

    protected void replaceParentInfo(PSAppUtil pSAppUtil, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSAppUtil, cloneSession);
        if (pSAppUtil.getUtilPSDE2Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSAppUtil.getUtilPSDE2Id())) != null) {
            this.onFillParentInfo_UtilPSDE2(pSAppUtil, (PSDataEntity)iEntity);
        }
        if (pSAppUtil.getUtilPSDE3Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSAppUtil.getUtilPSDE3Id())) != null) {
            this.onFillParentInfo_UtilPSDE3(pSAppUtil, (PSDataEntity)iEntity);
        }
        if (pSAppUtil.getUtilPSDE4Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSAppUtil.getUtilPSDE4Id())) != null) {
            this.onFillParentInfo_UtilPSDE4(pSAppUtil, (PSDataEntity)iEntity);
        }
        if (pSAppUtil.getUtilPSDE5Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSAppUtil.getUtilPSDE5Id())) != null) {
            this.onFillParentInfo_UtilPSDE5(pSAppUtil, (PSDataEntity)iEntity);
        }
        if (pSAppUtil.getUtilPSDE6Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSAppUtil.getUtilPSDE6Id())) != null) {
            this.onFillParentInfo_UtilPSDE6(pSAppUtil, (PSDataEntity)iEntity);
        }
        if (pSAppUtil.getUtilPSDE7Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSAppUtil.getUtilPSDE7Id())) != null) {
            this.onFillParentInfo_UtilPSDE7(pSAppUtil, (PSDataEntity)iEntity);
        }
        if (pSAppUtil.getUtilPSDE8Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSAppUtil.getUtilPSDE8Id())) != null) {
            this.onFillParentInfo_UtilPSDE8(pSAppUtil, (PSDataEntity)iEntity);
        }
        if (pSAppUtil.getUtilPSDE9Id() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSAppUtil.getUtilPSDE9Id())) != null) {
            this.onFillParentInfo_UtilPSDE9(pSAppUtil, (PSDataEntity)iEntity);
        }
        if (pSAppUtil.getUtilPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSAppUtil.getUtilPSDEId())) != null) {
            this.onFillParentInfo_UtilPSDE(pSAppUtil, (PSDataEntity)iEntity);
        }
        if (pSAppUtil.getPSSysAppId() != null && (iEntity = cloneSession.getEntity("PSSYSAPP", (Object)pSAppUtil.getPSSysAppId())) != null) {
            this.onFillParentInfo_PSSysApp(pSAppUtil, (PSSysApp)iEntity);
        }
        if (pSAppUtil.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSAppUtil.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSAppUtil, (PSSysDynaModel)iEntity);
        }
        if (pSAppUtil.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSAppUtil.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSAppUtil, (PSSysPFPlugin)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSAppUtil pSAppUtil, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSAppUtil, bl);
    }

    protected void onCheckEntity(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSAppUtil, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppUtilId(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppUtilName(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppId(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilObj(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilParam(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilParam10(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilParam11(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilParam12(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilParam2(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilParam3(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilParam4(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilParam5(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilParam6(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilParam7(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilParam8(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilParam9(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilParams(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE2Id(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE2Name(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE3Id(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE3Name(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE4Id(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE4Name(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE5Id(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE5Name(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE6Id(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE6Name(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE7Id(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE7Name(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE8Id(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE8Name(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE9Id(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDE9Name(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDEId(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDEName(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilTag(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilType(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSAppUtil, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSAppUtil, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isCodeNameDirty() : !pSAppUtil.isCodeNameDirty()) {
            return null;
        }
        String string = pSAppUtil.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSAppUtil, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
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
                string3 = "PSSYSAPPID";
                String string4 = this.checkFieldDupRule(this.getPSAppUtilDEModel(), "CODENAME", string3, pSAppUtil, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("CODENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isMemoDirty() : !pSAppUtil.isMemoDirty()) {
            return null;
        }
        String string = pSAppUtil.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSAppUtil, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSAppUtilId(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isPSAppUtilIdDirty() && !bl2 : !pSAppUtil.isPSAppUtilIdDirty()) {
            return null;
        }
        String string = pSAppUtil.getPSAppUtilId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPUTILID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppUtilId_Default((IEntity)pSAppUtil, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPUTILID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppUtilName(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isPSAppUtilNameDirty() && !bl2 : !pSAppUtil.isPSAppUtilNameDirty()) {
            return null;
        }
        String string = pSAppUtil.getPSAppUtilName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPUTILNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppUtilName_Default((IEntity)pSAppUtil, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPUTILNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysAppId(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isPSSysAppIdDirty() && !bl2 : !pSAppUtil.isPSSysAppIdDirty()) {
            return null;
        }
        String string = pSAppUtil.getPSSysAppId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppId_Default((IEntity)pSAppUtil, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isPSSysDynaModelIdDirty() : !pSAppUtil.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSAppUtil.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default((IEntity)pSAppUtil, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDYNAMODELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isPSSysPFPluginIdDirty() : !pSAppUtil.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSAppUtil.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default((IEntity)pSAppUtil, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isUserCatDirty() : !pSAppUtil.isUserCatDirty()) {
            return null;
        }
        String string = pSAppUtil.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSAppUtil, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isUserTagDirty() : !pSAppUtil.isUserTagDirty()) {
            return null;
        }
        String string = pSAppUtil.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSAppUtil, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isUserTag2Dirty() : !pSAppUtil.isUserTag2Dirty()) {
            return null;
        }
        String string = pSAppUtil.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSAppUtil, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isUserTag3Dirty() : !pSAppUtil.isUserTag3Dirty()) {
            return null;
        }
        String string = pSAppUtil.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSAppUtil, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isUserTag4Dirty() : !pSAppUtil.isUserTag4Dirty()) {
            return null;
        }
        String string = pSAppUtil.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSAppUtil, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilObj(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isUtilObjDirty() : !pSAppUtil.isUtilObjDirty()) {
            return null;
        }
        String string = pSAppUtil.getUtilObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilObj_Default((IEntity)pSAppUtil, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilParam(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isUtilParamDirty() : !pSAppUtil.isUtilParamDirty()) {
            return null;
        }
        String string = pSAppUtil.getUtilParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilParam_Default((IEntity)pSAppUtil, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilParam10(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isUtilParam10Dirty() : !pSAppUtil.isUtilParam10Dirty()) {
            return null;
        }
        Integer n = pSAppUtil.getUtilParam10();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UtilParam10_Default((IEntity)pSAppUtil, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPARAM10");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilParam11(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isUtilParam11Dirty() : !pSAppUtil.isUtilParam11Dirty()) {
            return null;
        }
        String string = pSAppUtil.getUtilParam11();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilParam11_Default((IEntity)pSAppUtil, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPARAM11");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilParam12(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isUtilParam12Dirty() : !pSAppUtil.isUtilParam12Dirty()) {
            return null;
        }
        String string = pSAppUtil.getUtilParam12();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilParam12_Default((IEntity)pSAppUtil, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPARAM12");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilParam2(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isUtilParam2Dirty() : !pSAppUtil.isUtilParam2Dirty()) {
            return null;
        }
        String string = pSAppUtil.getUtilParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilParam2_Default((IEntity)pSAppUtil, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilParam3(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isUtilParam3Dirty() : !pSAppUtil.isUtilParam3Dirty()) {
            return null;
        }
        String string = pSAppUtil.getUtilParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilParam3_Default((IEntity)pSAppUtil, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPARAM3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilParam4(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isUtilParam4Dirty() : !pSAppUtil.isUtilParam4Dirty()) {
            return null;
        }
        String string = pSAppUtil.getUtilParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilParam4_Default((IEntity)pSAppUtil, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPARAM4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilParam5(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isUtilParam5Dirty() : !pSAppUtil.isUtilParam5Dirty()) {
            return null;
        }
        Integer n = pSAppUtil.getUtilParam5();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UtilParam5_Default((IEntity)pSAppUtil, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPARAM5");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilParam6(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isUtilParam6Dirty() : !pSAppUtil.isUtilParam6Dirty()) {
            return null;
        }
        Integer n = pSAppUtil.getUtilParam6();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UtilParam6_Default((IEntity)pSAppUtil, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPARAM6");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilParam7(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isUtilParam7Dirty() : !pSAppUtil.isUtilParam7Dirty()) {
            return null;
        }
        Integer n = pSAppUtil.getUtilParam7();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UtilParam7_Default((IEntity)pSAppUtil, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPARAM7");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilParam8(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isUtilParam8Dirty() : !pSAppUtil.isUtilParam8Dirty()) {
            return null;
        }
        Integer n = pSAppUtil.getUtilParam8();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UtilParam8_Default((IEntity)pSAppUtil, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPARAM8");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilParam9(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isUtilParam9Dirty() : !pSAppUtil.isUtilParam9Dirty()) {
            return null;
        }
        Integer n = pSAppUtil.getUtilParam9();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UtilParam9_Default((IEntity)pSAppUtil, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPARAM9");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilParams(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isUtilParamsDirty() : !pSAppUtil.isUtilParamsDirty()) {
            return null;
        }
        String string = pSAppUtil.getUtilParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilParams_Default((IEntity)pSAppUtil, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE2Id(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isUtilPSDE2IdDirty() : !pSAppUtil.isUtilPSDE2IdDirty()) {
            return null;
        }
        String string = pSAppUtil.getUtilPSDE2Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE2Id_Default((IEntity)pSAppUtil, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE2ID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE2Name(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isUtilPSDE2NameDirty() : !pSAppUtil.isUtilPSDE2NameDirty()) {
            return null;
        }
        String string = pSAppUtil.getUtilPSDE2Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE2Name_Default((IEntity)pSAppUtil, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE2NAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE3Id(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isUtilPSDE3IdDirty() : !pSAppUtil.isUtilPSDE3IdDirty()) {
            return null;
        }
        String string = pSAppUtil.getUtilPSDE3Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE3Id_Default((IEntity)pSAppUtil, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE3ID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE3Name(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isUtilPSDE3NameDirty() : !pSAppUtil.isUtilPSDE3NameDirty()) {
            return null;
        }
        String string = pSAppUtil.getUtilPSDE3Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE3Name_Default((IEntity)pSAppUtil, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE3NAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE4Id(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isUtilPSDE4IdDirty() : !pSAppUtil.isUtilPSDE4IdDirty()) {
            return null;
        }
        String string = pSAppUtil.getUtilPSDE4Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE4Id_Default((IEntity)pSAppUtil, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE4ID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE4Name(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isUtilPSDE4NameDirty() : !pSAppUtil.isUtilPSDE4NameDirty()) {
            return null;
        }
        String string = pSAppUtil.getUtilPSDE4Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE4Name_Default((IEntity)pSAppUtil, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE4NAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE5Id(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isUtilPSDE5IdDirty() : !pSAppUtil.isUtilPSDE5IdDirty()) {
            return null;
        }
        String string = pSAppUtil.getUtilPSDE5Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE5Id_Default((IEntity)pSAppUtil, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE5ID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE5Name(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isUtilPSDE5NameDirty() : !pSAppUtil.isUtilPSDE5NameDirty()) {
            return null;
        }
        String string = pSAppUtil.getUtilPSDE5Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE5Name_Default((IEntity)pSAppUtil, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE5NAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE6Id(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isUtilPSDE6IdDirty() : !pSAppUtil.isUtilPSDE6IdDirty()) {
            return null;
        }
        String string = pSAppUtil.getUtilPSDE6Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE6Id_Default((IEntity)pSAppUtil, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE6ID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE6Name(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isUtilPSDE6NameDirty() : !pSAppUtil.isUtilPSDE6NameDirty()) {
            return null;
        }
        String string = pSAppUtil.getUtilPSDE6Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE6Name_Default((IEntity)pSAppUtil, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE6NAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE7Id(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isUtilPSDE7IdDirty() : !pSAppUtil.isUtilPSDE7IdDirty()) {
            return null;
        }
        String string = pSAppUtil.getUtilPSDE7Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE7Id_Default((IEntity)pSAppUtil, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE7ID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE7Name(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isUtilPSDE7NameDirty() : !pSAppUtil.isUtilPSDE7NameDirty()) {
            return null;
        }
        String string = pSAppUtil.getUtilPSDE7Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE7Name_Default((IEntity)pSAppUtil, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE7NAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE8Id(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isUtilPSDE8IdDirty() : !pSAppUtil.isUtilPSDE8IdDirty()) {
            return null;
        }
        String string = pSAppUtil.getUtilPSDE8Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE8Id_Default((IEntity)pSAppUtil, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE8ID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE8Name(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isUtilPSDE8NameDirty() : !pSAppUtil.isUtilPSDE8NameDirty()) {
            return null;
        }
        String string = pSAppUtil.getUtilPSDE8Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE8Name_Default((IEntity)pSAppUtil, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE8NAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE9Id(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isUtilPSDE9IdDirty() : !pSAppUtil.isUtilPSDE9IdDirty()) {
            return null;
        }
        String string = pSAppUtil.getUtilPSDE9Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE9Id_Default((IEntity)pSAppUtil, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE9ID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDE9Name(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isUtilPSDE9NameDirty() : !pSAppUtil.isUtilPSDE9NameDirty()) {
            return null;
        }
        String string = pSAppUtil.getUtilPSDE9Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDE9Name_Default((IEntity)pSAppUtil, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDE9NAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDEId(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isUtilPSDEIdDirty() : !pSAppUtil.isUtilPSDEIdDirty()) {
            return null;
        }
        String string = pSAppUtil.getUtilPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDEId_Default((IEntity)pSAppUtil, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilPSDEName(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isUtilPSDENameDirty() : !pSAppUtil.isUtilPSDENameDirty()) {
            return null;
        }
        String string = pSAppUtil.getUtilPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDEName_Default((IEntity)pSAppUtil, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilTag(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isUtilTagDirty() : !pSAppUtil.isUtilTagDirty()) {
            return null;
        }
        String string = pSAppUtil.getUtilTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilTag_Default((IEntity)pSAppUtil, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilType(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isUtilTypeDirty() && !bl2 : !pSAppUtil.isUtilTypeDirty()) {
            return null;
        }
        String string = pSAppUtil.getUtilType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilType_Default((IEntity)pSAppUtil, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSAppUtil pSAppUtil, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppUtil.isValidFlagDirty() && !bl2 : !pSAppUtil.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSAppUtil.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSAppUtil, bl2, bl3);
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

    protected void onSyncEntity(PSAppUtil pSAppUtil, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSAppUtil, bl);
    }

    protected void onSyncIndexEntities(PSAppUtil pSAppUtil, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSAppUtil, bl);
    }

    public Object getDataContextValue(PSAppUtil pSAppUtil, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSAppUtil, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysApp pSSysApp = pSAppUtil.getPSSysApp();
        if (pSSysApp != null && pSSysApp.contains(string)) {
            return pSSysApp.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSAppUtil pSAppUtil, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSAppUtil, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPUTILID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppUtilId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPUTILNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppUtilName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"UTILOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPARAM10", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilParam10_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPARAM11", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilParam11_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPARAM12", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilParam12_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPARAM3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilParam3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPARAM4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilParam4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPARAM5", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilParam5_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPARAM6", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilParam6_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPARAM7", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilParam7_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPARAM8", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilParam8_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPARAM9", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilParam9_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE2ID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE2Id_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE2NAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE2Name_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE3ID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE3Id_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE3NAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE3Name_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE4ID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE4Id_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE4NAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE4Name_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE5ID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE5Id_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE5NAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE5Name_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE6ID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE6Id_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE6NAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE6Name_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE7ID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE7Id_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE7NAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE7Name_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE8ID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE8Id_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE8NAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE8Name_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE9ID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE9Id_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDE9NAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDE9Name_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_PSAppUtilId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPUTILID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppUtilName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPUTILNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAppName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAPPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDynaModelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDYNAMODELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDynaModelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDYNAMODELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_UtilObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPARAM", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilParam10_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UtilParam11_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPARAM11", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilParam12_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPARAM12", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPARAM2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilParam3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPARAM3", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilParam4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPARAM4", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilParam5_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UtilParam6_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UtilParam7_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UtilParam8_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UtilParam9_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UtilParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPARAMS", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE2Id_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE2ID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE2Name_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE2NAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE3Id_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE3ID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE3Name_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE3NAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE4Id_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE4ID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE4Name_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE4NAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE5Id_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE5ID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE5Name_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE5NAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE6Id_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE6ID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE6Name_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE6NAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE7Id_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE7ID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE7Name_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE7NAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE8Id_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE8ID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE8Name_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE8NAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE9Id_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE9ID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDE9Name_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDE9NAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected boolean onMergeChild(String string, String string2, PSAppUtil pSAppUtil) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSAppUtil)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSAppUtil pSAppUtil) throws Exception {
        super.onUpdateParent((IEntity)pSAppUtil);
    }

    @Override
    protected void exportCurXmlModel(PSAppUtil pSAppUtil, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSAPPUTIL");
        if (!bl) {
            pSAppUtil.setCreateDate(null);
            pSAppUtil.setCreateMan(null);
            pSAppUtil.setPSAppUtilId(null);
            pSAppUtil.setUpdateDate(null);
            pSAppUtil.setUpdateMan(null);
            super.exportCurXmlModel(pSAppUtil, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSAppUtil pSAppUtil, PSSystem pSSystem) throws Exception {
        PSAppUtil pSAppUtil2 = new PSAppUtil();
        pSAppUtil2.setPSSysAppId(pSAppUtil.getPSSysAppId());
        pSAppUtil2.setUtilType(pSAppUtil.getUtilType());
        pSAppUtil2.setUtilTag(pSAppUtil.getUtilTag());
        if (this.selectOne((IEntity)pSAppUtil2, true)) {
            return pSAppUtil2.getPSAppUtilId();
        }
        return super.getEntityFolderKeyValue(pSAppUtil, pSSystem);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSAppUtil pSAppUtil, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSAppUtil, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSAPPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSAPP#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSAPPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSAPPUTIL_PSSYSAPP_PSSYSAPPID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSAPPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSAPPNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSAPP", (boolean)true) == 0) {
            iEntity.set("PSSYSAPPID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSAPPID"};
    }

    @Override
    public String getModelV2Tag(PSAppUtil pSAppUtil) {
        if (!StringHelper.isNullOrEmpty((String)pSAppUtil.getCodeName())) {
            return pSAppUtil.getCodeName();
        }
        return super.getModelV2Tag(pSAppUtil);
    }

    @Override
    public boolean setModelV2Tag(PSAppUtil pSAppUtil, String string) {
        pSAppUtil.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSAPPID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSAppUtil pSAppUtil, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSAppUtil.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSAppUtil, true);
        pSAppUtil.set("CODENAME", string);
        if (this.select(pSAppUtil, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSAppUtil, true);
        return super.getModelV2Entity(pSAppUtil, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSAppUtil pSAppUtil, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSAppUtil, objectNode, string, string2, n);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSAppUtil pSAppUtil, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "AppUtil");
    }
}

