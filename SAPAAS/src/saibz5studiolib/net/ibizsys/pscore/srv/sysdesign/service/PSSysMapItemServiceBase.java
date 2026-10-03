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
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPluginBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPrivBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDERBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbar;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbarBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroupBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysMapItemDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysMapItemDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCssBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImageBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMapItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMapView;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMapViewBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapLogicService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysMapItemServiceBase
extends PSCoreSysServiceBase<PSSysMapItem> {
    private static final Log log = LogFactory.getLog(PSSysMapItemServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysMapItemDEModel pSSysMapItemDEModel;
    private PSSysMapItemDAO pSSysMapItemDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysMapItemService";
    }

    public PSSysMapItemDEModel getPSSysMapItemDEModel() {
        if (this.pSSysMapItemDEModel == null) {
            try {
                this.pSSysMapItemDEModel = (PSSysMapItemDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysMapItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysMapItemDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysMapItemDEModel();
    }

    public PSSysMapItemDAO getPSSysMapItemDAO() {
        if (this.pSSysMapItemDAO == null) {
            try {
                this.pSSysMapItemDAO = (PSSysMapItemDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysMapItemDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysMapItemDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysMapItemDAO();
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

    protected void onFillParentInfo(PSSysMapItem pSSysMapItem, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMAPITEM_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSSysMapItem, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMAPITEM_PSDEACTION_MOVEPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_MovePSDEAction(pSSysMapItem, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMAPITEM_PSDEACTION_REMOVEPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_RemovePSDEAction(pSSysMapItem, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMAPITEM_PSDEDATASET_ASYNCPSDEDSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDataSet);
            } else {
                iService.get(pSDEDataSet);
            }
            this.onFillParentInfo_AsyncPSDEDS(pSSysMapItem, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMAPITEM_PSDEDATASET_PSDEDSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDataSet);
            } else {
                iService.get(pSDEDataSet);
            }
            this.onFillParentInfo_PSDEDS(pSSysMapItem, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMAPITEM_PSDEFIELD_ALTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_AltPSDEF(pSSysMapItem, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMAPITEM_PSDEFIELD_BKCOLORPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_BKColorPSDEF(pSSysMapItem, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMAPITEM_PSDEFIELD_CLSPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_ClsPSDEF(pSSysMapItem, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMAPITEM_PSDEFIELD_COLORPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_ColorPSDEF(pSSysMapItem, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMAPITEM_PSDEFIELD_CONTENTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_ContentPSDEF(pSSysMapItem, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMAPITEM_PSDEFIELD_DATA2PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_Data2PSDEF(pSSysMapItem, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMAPITEM_PSDEFIELD_DATAPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_DataPSDEF(pSSysMapItem, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMAPITEM_PSDEFIELD_GROUPPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_GroupPSDEF(pSSysMapItem, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMAPITEM_PSDEFIELD_ICONPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_IconPSDEF(pSSysMapItem, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMAPITEM_PSDEFIELD_KEYPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_KeyPSDEF(pSSysMapItem, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMAPITEM_PSDEFIELD_LATPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_LatPSDEF(pSSysMapItem, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMAPITEM_PSDEFIELD_LINKPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_LinkPSDEF(pSSysMapItem, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMAPITEM_PSDEFIELD_LONGPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_LongPSDEF(pSSysMapItem, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMAPITEM_PSDEFIELD_ORDERVALUEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_OrderValuePSDEF(pSSysMapItem, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMAPITEM_PSDEFIELD_SHAPECLSPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_ShapeClsPSDEF(pSSysMapItem, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMAPITEM_PSDEFIELD_TAG2PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_Tag2PSDEF(pSSysMapItem, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMAPITEM_PSDEFIELD_TAGPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_TagPSDEF(pSSysMapItem, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMAPITEM_PSDEFIELD_TEXTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_TextPSDEF(pSSysMapItem, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMAPITEM_PSDEFIELD_TIMEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_TimePSDEF(pSSysMapItem, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMAPITEM_PSDEFIELD_TIPSPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_TipsPSDEF(pSSysMapItem, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMAPITEM_PSDELOGIC_PSDELOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDELogic);
            } else {
                iService.get(pSDELogic);
            }
            this.onFillParentInfo_PSDELogic(pSSysMapItem, pSDELogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMAPITEM_PSDEOPPRIV_MOVEPSDEOPPRIVID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService", (SessionFactory)this.getSessionFactory());
            PSDEOPPriv pSDEOPPriv = (PSDEOPPriv)iService.getDEModel().createEntity();
            pSDEOPPriv.set("PSDEOPPRIVID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEOPPriv);
            } else {
                iService.get(pSDEOPPriv);
            }
            this.onFillParentInfo_MovePSDEOPPriv(pSSysMapItem, pSDEOPPriv);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMAPITEM_PSDEOPPRIV_REMOVEPSDEOPPRIVID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService", (SessionFactory)this.getSessionFactory());
            PSDEOPPriv pSDEOPPriv = (PSDEOPPriv)iService.getDEModel().createEntity();
            pSDEOPPriv.set("PSDEOPPRIVID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEOPPriv);
            } else {
                iService.get(pSDEOPPriv);
            }
            this.onFillParentInfo_RemovePSDEOPPriv(pSSysMapItem, pSDEOPPriv);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMAPITEM_PSDER_PSDERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDERService", (SessionFactory)this.getSessionFactory());
            PSDER pSDER = (PSDER)iService.getDEModel().createEntity();
            pSDER.set("PSDERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDER);
            } else {
                iService.get(pSDER);
            }
            this.onFillParentInfo_PSDER(pSSysMapItem, pSDER);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMAPITEM_PSDETOOLBAR_PSDETOOLBARID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService", (SessionFactory)this.getSessionFactory());
            PSDEToolbar pSDEToolbar = (PSDEToolbar)iService.getDEModel().createEntity();
            pSDEToolbar.set("PSDETOOLBARID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEToolbar);
            } else {
                iService.get(pSDEToolbar);
            }
            this.onFillParentInfo_PSDEToolbar(pSSysMapItem, pSDEToolbar);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMAPITEM_PSDEUAGROUP_GROUPPSDEUAGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService", (SessionFactory)this.getSessionFactory());
            PSDEUAGroup pSDEUAGroup = (PSDEUAGroup)iService.getDEModel().createEntity();
            pSDEUAGroup.set("PSDEUAGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEUAGroup);
            } else {
                iService.get(pSDEUAGroup);
            }
            this.onFillParentInfo_GroupPSDEUAGroup(pSSysMapItem, pSDEUAGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMAPITEM_PSDEVIEWBASE_PSDEVIEWBASEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewBase);
            } else {
                iService.get(pSDEViewBase);
            }
            this.onFillParentInfo_PSDEViewBase(pSSysMapItem, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMAPITEM_PSLANGUAGERES_NAMEPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_NamePSLanRes(pSSysMapItem, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMAPITEM_PSSYSCSS_PSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysCss);
            } else {
                iService.get(pSSysCss);
            }
            this.onFillParentInfo_PSSysCss(pSSysMapItem, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMAPITEM_PSSYSCSS_SHAPEPSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysCss);
            } else {
                iService.get(pSSysCss);
            }
            this.onFillParentInfo_ShapePSSysCss(pSSysMapItem, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMAPITEM_PSSYSIMAGE_PSSYSIMAGEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService", (SessionFactory)this.getSessionFactory());
            PSSysImage pSSysImage = (PSSysImage)iService.getDEModel().createEntity();
            pSSysImage.set("PSSYSIMAGEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysImage);
            } else {
                iService.get(pSSysImage);
            }
            this.onFillParentInfo_PSSysImage(pSSysMapItem, pSSysImage);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMAPITEM_PSSYSMAPVIEW_PSSYSMAPVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysMapViewService", (SessionFactory)this.getSessionFactory());
            PSSysMapView pSSysMapView = (PSSysMapView)iService.getDEModel().createEntity();
            pSSysMapView.set("PSSYSMAPVIEWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysMapView);
            } else {
                iService.get(pSSysMapView);
            }
            this.onFillParentInfo_PSSysMapView(pSSysMapItem, pSSysMapView);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMAPITEM_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPFPlugin);
            } else {
                iService.get(pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSSysMapItem, pSSysPFPlugin);
            return;
        }
        super.onFillParentInfo(pSSysMapItem, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSSysMapItem pSSysMapItem, PSDataEntity pSDataEntity) throws Exception {
        pSSysMapItem.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSSysMapItem.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_MovePSDEAction(PSSysMapItem pSSysMapItem, PSDEAction pSDEAction) throws Exception {
        pSSysMapItem.setMovePSDEActionId(pSDEAction.getPSDEActionId());
        pSSysMapItem.setMovePSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_RemovePSDEAction(PSSysMapItem pSSysMapItem, PSDEAction pSDEAction) throws Exception {
        pSSysMapItem.setRemovePSDEActionId(pSDEAction.getPSDEActionId());
        pSSysMapItem.setRemovePSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_AsyncPSDEDS(PSSysMapItem pSSysMapItem, PSDEDataSet pSDEDataSet) throws Exception {
        pSSysMapItem.setAsyncPSDEDSId(pSDEDataSet.getPSDEDataSetId());
        pSSysMapItem.setAsyncPSDEDSName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_PSDEDS(PSSysMapItem pSSysMapItem, PSDEDataSet pSDEDataSet) throws Exception {
        pSSysMapItem.setPSDEDSId(pSDEDataSet.getPSDEDataSetId());
        pSSysMapItem.setPSDEDSName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_AltPSDEF(PSSysMapItem pSSysMapItem, PSDEField pSDEField) throws Exception {
        pSSysMapItem.setAltPSDEFId(pSDEField.getPSDEFieldId());
        pSSysMapItem.setAltPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_BKColorPSDEF(PSSysMapItem pSSysMapItem, PSDEField pSDEField) throws Exception {
        pSSysMapItem.setBKColorPSDEFId(pSDEField.getPSDEFieldId());
        pSSysMapItem.setBKColorPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_ClsPSDEF(PSSysMapItem pSSysMapItem, PSDEField pSDEField) throws Exception {
        pSSysMapItem.setClsPSDEFId(pSDEField.getPSDEFieldId());
        pSSysMapItem.setClsPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_ColorPSDEF(PSSysMapItem pSSysMapItem, PSDEField pSDEField) throws Exception {
        pSSysMapItem.setColorPSDEFId(pSDEField.getPSDEFieldId());
        pSSysMapItem.setColorPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_ContentPSDEF(PSSysMapItem pSSysMapItem, PSDEField pSDEField) throws Exception {
        pSSysMapItem.setContentPSDEFId(pSDEField.getPSDEFieldId());
        pSSysMapItem.setContentPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_Data2PSDEF(PSSysMapItem pSSysMapItem, PSDEField pSDEField) throws Exception {
        pSSysMapItem.setData2PSDEFId(pSDEField.getPSDEFieldId());
        pSSysMapItem.setData2PSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_DataPSDEF(PSSysMapItem pSSysMapItem, PSDEField pSDEField) throws Exception {
        pSSysMapItem.setDataPSDEFId(pSDEField.getPSDEFieldId());
        pSSysMapItem.setDataPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_GroupPSDEF(PSSysMapItem pSSysMapItem, PSDEField pSDEField) throws Exception {
        pSSysMapItem.setGroupPSDEFId(pSDEField.getPSDEFieldId());
        pSSysMapItem.setGroupPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_IconPSDEF(PSSysMapItem pSSysMapItem, PSDEField pSDEField) throws Exception {
        pSSysMapItem.setIconPSDEFId(pSDEField.getPSDEFieldId());
        pSSysMapItem.setIconPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_KeyPSDEF(PSSysMapItem pSSysMapItem, PSDEField pSDEField) throws Exception {
        pSSysMapItem.setKeyPSDEFId(pSDEField.getPSDEFieldId());
        pSSysMapItem.setKeyPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_LatPSDEF(PSSysMapItem pSSysMapItem, PSDEField pSDEField) throws Exception {
        pSSysMapItem.setLatPSDEFId(pSDEField.getPSDEFieldId());
        pSSysMapItem.setLatPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_LinkPSDEF(PSSysMapItem pSSysMapItem, PSDEField pSDEField) throws Exception {
        pSSysMapItem.setLinkPSDEFId(pSDEField.getPSDEFieldId());
        pSSysMapItem.setLinkPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_LongPSDEF(PSSysMapItem pSSysMapItem, PSDEField pSDEField) throws Exception {
        pSSysMapItem.setLongPSDEFId(pSDEField.getPSDEFieldId());
        pSSysMapItem.setLongPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_OrderValuePSDEF(PSSysMapItem pSSysMapItem, PSDEField pSDEField) throws Exception {
        pSSysMapItem.setOrderValuePSDEFId(pSDEField.getPSDEFieldId());
        pSSysMapItem.setOrderValuePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_ShapeClsPSDEF(PSSysMapItem pSSysMapItem, PSDEField pSDEField) throws Exception {
        pSSysMapItem.setShapeClsPSDEFId(pSDEField.getPSDEFieldId());
        pSSysMapItem.setShapeClsPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_Tag2PSDEF(PSSysMapItem pSSysMapItem, PSDEField pSDEField) throws Exception {
        pSSysMapItem.setTag2PSDEFId(pSDEField.getPSDEFieldId());
        pSSysMapItem.setTag2PSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_TagPSDEF(PSSysMapItem pSSysMapItem, PSDEField pSDEField) throws Exception {
        pSSysMapItem.setTagPSDEFId(pSDEField.getPSDEFieldId());
        pSSysMapItem.setTagPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_TextPSDEF(PSSysMapItem pSSysMapItem, PSDEField pSDEField) throws Exception {
        pSSysMapItem.setTextPSDEFId(pSDEField.getPSDEFieldId());
        pSSysMapItem.setTextPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_TimePSDEF(PSSysMapItem pSSysMapItem, PSDEField pSDEField) throws Exception {
        pSSysMapItem.setTimePSDEFId(pSDEField.getPSDEFieldId());
        pSSysMapItem.setTimePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_TipsPSDEF(PSSysMapItem pSSysMapItem, PSDEField pSDEField) throws Exception {
        pSSysMapItem.setTipsPSDEFId(pSDEField.getPSDEFieldId());
        pSSysMapItem.setTipsPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PSDELogic(PSSysMapItem pSSysMapItem, PSDELogic pSDELogic) throws Exception {
        pSSysMapItem.setPSDELogicId(pSDELogic.getPSDELogicId());
        pSSysMapItem.setPSDELogicName(pSDELogic.getPSDELogicName());
    }

    protected void onFillParentInfo_MovePSDEOPPriv(PSSysMapItem pSSysMapItem, PSDEOPPriv pSDEOPPriv) throws Exception {
        pSSysMapItem.setMovePSDEOPPrivId(pSDEOPPriv.getPSDEOPPrivId());
        pSSysMapItem.setMovePSDEOPPrivName(pSDEOPPriv.getPSDEOPPrivName());
    }

    protected void onFillParentInfo_RemovePSDEOPPriv(PSSysMapItem pSSysMapItem, PSDEOPPriv pSDEOPPriv) throws Exception {
        pSSysMapItem.setRemovePSDEOPPrivId(pSDEOPPriv.getPSDEOPPrivId());
        pSSysMapItem.setRemovePSDEOPPrivName(pSDEOPPriv.getPSDEOPPrivName());
    }

    protected void onFillParentInfo_PSDER(PSSysMapItem pSSysMapItem, PSDER pSDER) throws Exception {
        pSSysMapItem.setPSDERId(pSDER.getPSDERId());
        pSSysMapItem.setPSDERName(pSDER.getPSDERName());
    }

    protected void onFillParentInfo_PSDEToolbar(PSSysMapItem pSSysMapItem, PSDEToolbar pSDEToolbar) throws Exception {
        pSSysMapItem.setPSDEToolbarId(pSDEToolbar.getPSDEToolbarId());
        pSSysMapItem.setPSDEToolbarName(pSDEToolbar.getPSDEToolbarName());
    }

    protected void onFillParentInfo_GroupPSDEUAGroup(PSSysMapItem pSSysMapItem, PSDEUAGroup pSDEUAGroup) throws Exception {
        pSSysMapItem.setGroupPSDEUAGroupId(pSDEUAGroup.getPSDEUAGroupId());
        pSSysMapItem.setGroupPSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
    }

    protected void onFillParentInfo_PSDEViewBase(PSSysMapItem pSSysMapItem, PSDEViewBase pSDEViewBase) throws Exception {
        pSSysMapItem.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
        pSSysMapItem.setPSDEViewBaseName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_NamePSLanRes(PSSysMapItem pSSysMapItem, PSLanguageRes pSLanguageRes) throws Exception {
        pSSysMapItem.setNamePSLanResId(pSLanguageRes.getPSLanguageResId());
        pSSysMapItem.setNamePSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSSysCss(PSSysMapItem pSSysMapItem, PSSysCss pSSysCss) throws Exception {
        pSSysMapItem.setPSSysCssId(pSSysCss.getPSSysCssId());
        pSSysMapItem.setPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_ShapePSSysCss(PSSysMapItem pSSysMapItem, PSSysCss pSSysCss) throws Exception {
        pSSysMapItem.setShapePSSysCssId(pSSysCss.getPSSysCssId());
        pSSysMapItem.setShapePSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_PSSysImage(PSSysMapItem pSSysMapItem, PSSysImage pSSysImage) throws Exception {
        pSSysMapItem.setPSSysImageId(pSSysImage.getPSSysImageId());
        pSSysMapItem.setPSSysImageName(pSSysImage.getPSSysImageName());
    }

    protected void onFillParentInfo_PSSysMapView(PSSysMapItem pSSysMapItem, PSSysMapView pSSysMapView) throws Exception {
        pSSysMapItem.setPSSysMapViewId(pSSysMapView.getPSSysMapViewId());
        pSSysMapItem.setPSSysMapViewName(pSSysMapView.getPSSysMapViewName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSSysMapItem pSSysMapItem, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSSysMapItem.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSSysMapItem.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillEntityFullInfo(PSSysMapItem pSSysMapItem, boolean bl) throws Exception {
        if (bl && pSSysMapItem.getValidFlag() == null) {
            pSSysMapItem.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSSysMapItem, bl);
        this.onFillEntityFullInfo_PSDE(pSSysMapItem, bl);
        this.onFillEntityFullInfo_MovePSDEAction(pSSysMapItem, bl);
        this.onFillEntityFullInfo_RemovePSDEAction(pSSysMapItem, bl);
        this.onFillEntityFullInfo_AsyncPSDEDS(pSSysMapItem, bl);
        this.onFillEntityFullInfo_PSDEDS(pSSysMapItem, bl);
        this.onFillEntityFullInfo_AltPSDEF(pSSysMapItem, bl);
        this.onFillEntityFullInfo_BKColorPSDEF(pSSysMapItem, bl);
        this.onFillEntityFullInfo_ClsPSDEF(pSSysMapItem, bl);
        this.onFillEntityFullInfo_ColorPSDEF(pSSysMapItem, bl);
        this.onFillEntityFullInfo_ContentPSDEF(pSSysMapItem, bl);
        this.onFillEntityFullInfo_Data2PSDEF(pSSysMapItem, bl);
        this.onFillEntityFullInfo_DataPSDEF(pSSysMapItem, bl);
        this.onFillEntityFullInfo_GroupPSDEF(pSSysMapItem, bl);
        this.onFillEntityFullInfo_IconPSDEF(pSSysMapItem, bl);
        this.onFillEntityFullInfo_KeyPSDEF(pSSysMapItem, bl);
        this.onFillEntityFullInfo_LatPSDEF(pSSysMapItem, bl);
        this.onFillEntityFullInfo_LinkPSDEF(pSSysMapItem, bl);
        this.onFillEntityFullInfo_LongPSDEF(pSSysMapItem, bl);
        this.onFillEntityFullInfo_OrderValuePSDEF(pSSysMapItem, bl);
        this.onFillEntityFullInfo_ShapeClsPSDEF(pSSysMapItem, bl);
        this.onFillEntityFullInfo_Tag2PSDEF(pSSysMapItem, bl);
        this.onFillEntityFullInfo_TagPSDEF(pSSysMapItem, bl);
        this.onFillEntityFullInfo_TextPSDEF(pSSysMapItem, bl);
        this.onFillEntityFullInfo_TimePSDEF(pSSysMapItem, bl);
        this.onFillEntityFullInfo_TipsPSDEF(pSSysMapItem, bl);
        this.onFillEntityFullInfo_PSDELogic(pSSysMapItem, bl);
        this.onFillEntityFullInfo_MovePSDEOPPriv(pSSysMapItem, bl);
        this.onFillEntityFullInfo_RemovePSDEOPPriv(pSSysMapItem, bl);
        this.onFillEntityFullInfo_PSDER(pSSysMapItem, bl);
        this.onFillEntityFullInfo_PSDEToolbar(pSSysMapItem, bl);
        this.onFillEntityFullInfo_GroupPSDEUAGroup(pSSysMapItem, bl);
        this.onFillEntityFullInfo_PSDEViewBase(pSSysMapItem, bl);
        this.onFillEntityFullInfo_NamePSLanRes(pSSysMapItem, bl);
        this.onFillEntityFullInfo_PSSysCss(pSSysMapItem, bl);
        this.onFillEntityFullInfo_ShapePSSysCss(pSSysMapItem, bl);
        this.onFillEntityFullInfo_PSSysImage(pSSysMapItem, bl);
        this.onFillEntityFullInfo_PSSysMapView(pSSysMapItem, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSSysMapItem, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSSysMapItem pSSysMapItem, boolean bl) throws Exception {
        if (pSSysMapItem.isPSDEIdDirty()) {
            if (pSSysMapItem.getPSDEId() != null) {
                if (pSSysMapItem.getPSDEId() == null || pSSysMapItem.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSSysMapItem.getPSDE();
                    pSSysMapItem.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysMapItem.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_MovePSDEAction(PSSysMapItem pSSysMapItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RemovePSDEAction(PSSysMapItem pSSysMapItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_AsyncPSDEDS(PSSysMapItem pSSysMapItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEDS(PSSysMapItem pSSysMapItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_AltPSDEF(PSSysMapItem pSSysMapItem, boolean bl) throws Exception {
        if (pSSysMapItem.isAltPSDEFIdDirty()) {
            if (pSSysMapItem.getAltPSDEFId() != null) {
                if (pSSysMapItem.getAltPSDEFId() == null || pSSysMapItem.getAltPSDEFName() == null) {
                    PSDEField pSDEField = pSSysMapItem.getAltPSDEF();
                    pSSysMapItem.setAltPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMapItem.setAltPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_BKColorPSDEF(PSSysMapItem pSSysMapItem, boolean bl) throws Exception {
        if (pSSysMapItem.isBKColorPSDEFIdDirty()) {
            if (pSSysMapItem.getBKColorPSDEFId() != null) {
                if (pSSysMapItem.getBKColorPSDEFId() == null || pSSysMapItem.getBKColorPSDEFName() == null) {
                    PSDEField pSDEField = pSSysMapItem.getBKColorPSDEF();
                    pSSysMapItem.setBKColorPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMapItem.setBKColorPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_ClsPSDEF(PSSysMapItem pSSysMapItem, boolean bl) throws Exception {
        if (pSSysMapItem.isClsPSDEFIdDirty()) {
            if (pSSysMapItem.getClsPSDEFId() != null) {
                if (pSSysMapItem.getClsPSDEFId() == null || pSSysMapItem.getClsPSDEFName() == null) {
                    PSDEField pSDEField = pSSysMapItem.getClsPSDEF();
                    pSSysMapItem.setClsPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMapItem.setClsPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_ColorPSDEF(PSSysMapItem pSSysMapItem, boolean bl) throws Exception {
        if (pSSysMapItem.isColorPSDEFIdDirty()) {
            if (pSSysMapItem.getColorPSDEFId() != null) {
                if (pSSysMapItem.getColorPSDEFId() == null || pSSysMapItem.getColorPSDEFName() == null) {
                    PSDEField pSDEField = pSSysMapItem.getColorPSDEF();
                    pSSysMapItem.setColorPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMapItem.setColorPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_ContentPSDEF(PSSysMapItem pSSysMapItem, boolean bl) throws Exception {
        if (pSSysMapItem.isContentPSDEFIdDirty()) {
            if (pSSysMapItem.getContentPSDEFId() != null) {
                if (pSSysMapItem.getContentPSDEFId() == null || pSSysMapItem.getContentPSDEFName() == null) {
                    PSDEField pSDEField = pSSysMapItem.getContentPSDEF();
                    pSSysMapItem.setContentPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMapItem.setContentPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_Data2PSDEF(PSSysMapItem pSSysMapItem, boolean bl) throws Exception {
        if (pSSysMapItem.isData2PSDEFIdDirty()) {
            if (pSSysMapItem.getData2PSDEFId() != null) {
                if (pSSysMapItem.getData2PSDEFId() == null || pSSysMapItem.getData2PSDEFName() == null) {
                    PSDEField pSDEField = pSSysMapItem.getData2PSDEF();
                    pSSysMapItem.setData2PSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMapItem.setData2PSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_DataPSDEF(PSSysMapItem pSSysMapItem, boolean bl) throws Exception {
        if (pSSysMapItem.isDataPSDEFIdDirty()) {
            if (pSSysMapItem.getDataPSDEFId() != null) {
                if (pSSysMapItem.getDataPSDEFId() == null || pSSysMapItem.getDataPSDEFName() == null) {
                    PSDEField pSDEField = pSSysMapItem.getDataPSDEF();
                    pSSysMapItem.setDataPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMapItem.setDataPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_GroupPSDEF(PSSysMapItem pSSysMapItem, boolean bl) throws Exception {
        if (pSSysMapItem.isGroupPSDEFIdDirty()) {
            if (pSSysMapItem.getGroupPSDEFId() != null) {
                if (pSSysMapItem.getGroupPSDEFId() == null || pSSysMapItem.getGroupPSDEFName() == null) {
                    PSDEField pSDEField = pSSysMapItem.getGroupPSDEF();
                    pSSysMapItem.setGroupPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMapItem.setGroupPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_IconPSDEF(PSSysMapItem pSSysMapItem, boolean bl) throws Exception {
        if (pSSysMapItem.isIconPSDEFIdDirty()) {
            if (pSSysMapItem.getIconPSDEFId() != null) {
                if (pSSysMapItem.getIconPSDEFId() == null || pSSysMapItem.getIconPSDEFName() == null) {
                    PSDEField pSDEField = pSSysMapItem.getIconPSDEF();
                    pSSysMapItem.setIconPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMapItem.setIconPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_KeyPSDEF(PSSysMapItem pSSysMapItem, boolean bl) throws Exception {
        if (pSSysMapItem.isKeyPSDEFIdDirty()) {
            if (pSSysMapItem.getKeyPSDEFId() != null) {
                if (pSSysMapItem.getKeyPSDEFId() == null || pSSysMapItem.getKeyPSDEFName() == null) {
                    PSDEField pSDEField = pSSysMapItem.getKeyPSDEF();
                    pSSysMapItem.setKeyPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMapItem.setKeyPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_LatPSDEF(PSSysMapItem pSSysMapItem, boolean bl) throws Exception {
        if (pSSysMapItem.isLatPSDEFIdDirty()) {
            if (pSSysMapItem.getLatPSDEFId() != null) {
                if (pSSysMapItem.getLatPSDEFId() == null || pSSysMapItem.getLatPSDEFName() == null) {
                    PSDEField pSDEField = pSSysMapItem.getLatPSDEF();
                    pSSysMapItem.setLatPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMapItem.setLatPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_LinkPSDEF(PSSysMapItem pSSysMapItem, boolean bl) throws Exception {
        if (pSSysMapItem.isLinkPSDEFIdDirty()) {
            if (pSSysMapItem.getLinkPSDEFId() != null) {
                if (pSSysMapItem.getLinkPSDEFId() == null || pSSysMapItem.getLinkPSDEFName() == null) {
                    PSDEField pSDEField = pSSysMapItem.getLinkPSDEF();
                    pSSysMapItem.setLinkPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMapItem.setLinkPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_LongPSDEF(PSSysMapItem pSSysMapItem, boolean bl) throws Exception {
        if (pSSysMapItem.isLongPSDEFIdDirty()) {
            if (pSSysMapItem.getLongPSDEFId() != null) {
                if (pSSysMapItem.getLongPSDEFId() == null || pSSysMapItem.getLongPSDEFName() == null) {
                    PSDEField pSDEField = pSSysMapItem.getLongPSDEF();
                    pSSysMapItem.setLongPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMapItem.setLongPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_OrderValuePSDEF(PSSysMapItem pSSysMapItem, boolean bl) throws Exception {
        if (pSSysMapItem.isOrderValuePSDEFIdDirty()) {
            if (pSSysMapItem.getOrderValuePSDEFId() != null) {
                if (pSSysMapItem.getOrderValuePSDEFId() == null || pSSysMapItem.getOrderValuePSDEFName() == null) {
                    PSDEField pSDEField = pSSysMapItem.getOrderValuePSDEF();
                    pSSysMapItem.setOrderValuePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMapItem.setOrderValuePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_ShapeClsPSDEF(PSSysMapItem pSSysMapItem, boolean bl) throws Exception {
        if (pSSysMapItem.isShapeClsPSDEFIdDirty()) {
            if (pSSysMapItem.getShapeClsPSDEFId() != null) {
                if (pSSysMapItem.getShapeClsPSDEFId() == null || pSSysMapItem.getShapeClsPSDEFName() == null) {
                    PSDEField pSDEField = pSSysMapItem.getShapeClsPSDEF();
                    pSSysMapItem.setShapeClsPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMapItem.setShapeClsPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_Tag2PSDEF(PSSysMapItem pSSysMapItem, boolean bl) throws Exception {
        if (pSSysMapItem.isTag2PSDEFIdDirty()) {
            if (pSSysMapItem.getTag2PSDEFId() != null) {
                if (pSSysMapItem.getTag2PSDEFId() == null || pSSysMapItem.getTag2PSDEFName() == null) {
                    PSDEField pSDEField = pSSysMapItem.getTag2PSDEF();
                    pSSysMapItem.setTag2PSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMapItem.setTag2PSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TagPSDEF(PSSysMapItem pSSysMapItem, boolean bl) throws Exception {
        if (pSSysMapItem.isTagPSDEFIdDirty()) {
            if (pSSysMapItem.getTagPSDEFId() != null) {
                if (pSSysMapItem.getTagPSDEFId() == null || pSSysMapItem.getTagPSDEFName() == null) {
                    PSDEField pSDEField = pSSysMapItem.getTagPSDEF();
                    pSSysMapItem.setTagPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMapItem.setTagPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TextPSDEF(PSSysMapItem pSSysMapItem, boolean bl) throws Exception {
        if (pSSysMapItem.isTextPSDEFIdDirty()) {
            if (pSSysMapItem.getTextPSDEFId() != null) {
                if (pSSysMapItem.getTextPSDEFId() == null || pSSysMapItem.getTextPSDEFName() == null) {
                    PSDEField pSDEField = pSSysMapItem.getTextPSDEF();
                    pSSysMapItem.setTextPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMapItem.setTextPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TimePSDEF(PSSysMapItem pSSysMapItem, boolean bl) throws Exception {
        if (pSSysMapItem.isTimePSDEFIdDirty()) {
            if (pSSysMapItem.getTimePSDEFId() != null) {
                if (pSSysMapItem.getTimePSDEFId() == null || pSSysMapItem.getTimePSDEFName() == null) {
                    PSDEField pSDEField = pSSysMapItem.getTimePSDEF();
                    pSSysMapItem.setTimePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMapItem.setTimePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TipsPSDEF(PSSysMapItem pSSysMapItem, boolean bl) throws Exception {
        if (pSSysMapItem.isTipsPSDEFIdDirty()) {
            if (pSSysMapItem.getTipsPSDEFId() != null) {
                if (pSSysMapItem.getTipsPSDEFId() == null || pSSysMapItem.getTipsPSDEFName() == null) {
                    PSDEField pSDEField = pSSysMapItem.getTipsPSDEF();
                    pSSysMapItem.setTipsPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysMapItem.setTipsPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDELogic(PSSysMapItem pSSysMapItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MovePSDEOPPriv(PSSysMapItem pSSysMapItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RemovePSDEOPPriv(PSSysMapItem pSSysMapItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDER(PSSysMapItem pSSysMapItem, boolean bl) throws Exception {
        if (pSSysMapItem.isPSDERIdDirty()) {
            if (pSSysMapItem.getPSDERId() != null) {
                if (pSSysMapItem.getPSDERId() == null || pSSysMapItem.getPSDERName() == null) {
                    PSDER pSDER = pSSysMapItem.getPSDER();
                    pSSysMapItem.setPSDERName(pSDER.getPSDERName());
                }
            } else {
                pSSysMapItem.setPSDERName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEToolbar(PSSysMapItem pSSysMapItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_GroupPSDEUAGroup(PSSysMapItem pSSysMapItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEViewBase(PSSysMapItem pSSysMapItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_NamePSLanRes(PSSysMapItem pSSysMapItem, boolean bl) throws Exception {
        if (pSSysMapItem.isNamePSLanResIdDirty()) {
            if (pSSysMapItem.getNamePSLanResId() != null) {
                if (pSSysMapItem.getNamePSLanResId() == null || pSSysMapItem.getNamePSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSSysMapItem.getNamePSLanRes();
                    pSSysMapItem.setNamePSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSSysMapItem.setNamePSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysCss(PSSysMapItem pSSysMapItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_ShapePSSysCss(PSSysMapItem pSSysMapItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysImage(PSSysMapItem pSSysMapItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysMapView(PSSysMapItem pSSysMapItem, boolean bl) throws Exception {
        if (pSSysMapItem.isPSSysMapViewIdDirty()) {
            if (pSSysMapItem.getPSSysMapViewId() != null) {
                if (pSSysMapItem.getPSSysMapViewId() == null || pSSysMapItem.getPSSysMapViewName() == null) {
                    PSSysMapView pSSysMapView = pSSysMapItem.getPSSysMapView();
                    pSSysMapItem.setPSSysMapViewName(pSSysMapView.getPSSysMapViewName());
                }
            } else {
                pSSysMapItem.setPSSysMapViewName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSSysMapItem pSSysMapItem, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysMapItem pSSysMapItem, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysMapItem, bl);
    }

    public ArrayList<PSSysMapItem> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysMapItem> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysMapItem> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysMapItem> selectByMovePSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByMovePSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSSysMapItem> selectByMovePSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByMovePSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSSysMapItem> selectByMovePSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MOVEPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMovePSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMovePSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMapItem> selectByRemovePSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByRemovePSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSSysMapItem> selectByRemovePSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByRemovePSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSSysMapItem> selectByRemovePSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REMOVEPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRemovePSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRemovePSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMapItem> selectByAsyncPSDEDS(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByAsyncPSDEDS(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSSysMapItem> selectByAsyncPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByAsyncPSDEDS(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSSysMapItem> selectByAsyncPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ASYNCPSDEDSID", (Object)pSDEDataSetBase.getPSDEDataSetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByAsyncPSDEDSCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByAsyncPSDEDSCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMapItem> selectByPSDEDS(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByPSDEDS(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSSysMapItem> selectByPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByPSDEDS(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSSysMapItem> selectByPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDSID", (Object)pSDEDataSetBase.getPSDEDataSetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEDSCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEDSCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMapItem> selectByAltPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByAltPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMapItem> selectByAltPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByAltPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMapItem> selectByAltPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ALTPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByAltPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByAltPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMapItem> selectByBKColorPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByBKColorPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMapItem> selectByBKColorPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByBKColorPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMapItem> selectByBKColorPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("BKCOLORPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByBKColorPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByBKColorPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMapItem> selectByClsPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByClsPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMapItem> selectByClsPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByClsPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMapItem> selectByClsPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CLSPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByClsPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByClsPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMapItem> selectByColorPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByColorPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMapItem> selectByColorPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByColorPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMapItem> selectByColorPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("COLORPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByColorPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByColorPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMapItem> selectByContentPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByContentPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMapItem> selectByContentPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByContentPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMapItem> selectByContentPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CONTENTPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByContentPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByContentPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMapItem> selectByData2PSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByData2PSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMapItem> selectByData2PSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByData2PSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMapItem> selectByData2PSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DATA2PSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByData2PSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByData2PSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMapItem> selectByDataPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByDataPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMapItem> selectByDataPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByDataPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMapItem> selectByDataPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DATAPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDataPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDataPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMapItem> selectByGroupPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByGroupPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMapItem> selectByGroupPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByGroupPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMapItem> selectByGroupPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("GROUPPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByGroupPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByGroupPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMapItem> selectByIconPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByIconPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMapItem> selectByIconPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByIconPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMapItem> selectByIconPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ICONPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByIconPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByIconPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMapItem> selectByKeyPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByKeyPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMapItem> selectByKeyPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByKeyPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMapItem> selectByKeyPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysMapItem> selectByLatPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByLatPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMapItem> selectByLatPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByLatPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMapItem> selectByLatPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("LATPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByLatPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByLatPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMapItem> selectByLinkPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByLinkPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMapItem> selectByLinkPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByLinkPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMapItem> selectByLinkPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("LINKPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByLinkPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByLinkPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMapItem> selectByLongPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByLongPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMapItem> selectByLongPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByLongPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMapItem> selectByLongPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("LONGPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByLongPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByLongPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMapItem> selectByOrderValuePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByOrderValuePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMapItem> selectByOrderValuePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByOrderValuePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMapItem> selectByOrderValuePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ORDERVALUEPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByOrderValuePSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByOrderValuePSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMapItem> selectByShapeClsPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByShapeClsPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMapItem> selectByShapeClsPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByShapeClsPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMapItem> selectByShapeClsPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SHAPECLSPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByShapeClsPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByShapeClsPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMapItem> selectByTag2PSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByTag2PSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMapItem> selectByTag2PSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByTag2PSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMapItem> selectByTag2PSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TAG2PSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTag2PSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTag2PSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMapItem> selectByTagPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByTagPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMapItem> selectByTagPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByTagPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMapItem> selectByTagPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TAGPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTagPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTagPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMapItem> selectByTextPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByTextPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMapItem> selectByTextPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByTextPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMapItem> selectByTextPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TEXTPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTextPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTextPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMapItem> selectByTimePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByTimePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMapItem> selectByTimePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByTimePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMapItem> selectByTimePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TIMEPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTimePSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTimePSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMapItem> selectByTipsPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByTipsPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysMapItem> selectByTipsPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByTipsPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysMapItem> selectByTipsPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TIPSPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTipsPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTipsPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMapItem> selectByPSDELogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, "", -1);
    }

    public ArrayList<PSSysMapItem> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, string, -1);
    }

    public ArrayList<PSSysMapItem> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDELOGICID", (Object)pSDELogicBase.getPSDELogicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDELogicCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDELogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMapItem> selectByMovePSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase) throws Exception {
        return this.selectByMovePSDEOPPriv(pSDEOPPrivBase, "", -1);
    }

    public ArrayList<PSSysMapItem> selectByMovePSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string) throws Exception {
        return this.selectByMovePSDEOPPriv(pSDEOPPrivBase, string, -1);
    }

    public ArrayList<PSSysMapItem> selectByMovePSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MOVEPSDEOPPRIVID", (Object)pSDEOPPrivBase.getPSDEOPPrivId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMovePSDEOPPrivCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMovePSDEOPPrivCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMapItem> selectByRemovePSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase) throws Exception {
        return this.selectByRemovePSDEOPPriv(pSDEOPPrivBase, "", -1);
    }

    public ArrayList<PSSysMapItem> selectByRemovePSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string) throws Exception {
        return this.selectByRemovePSDEOPPriv(pSDEOPPrivBase, string, -1);
    }

    public ArrayList<PSSysMapItem> selectByRemovePSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REMOVEPSDEOPPRIVID", (Object)pSDEOPPrivBase.getPSDEOPPrivId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRemovePSDEOPPrivCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRemovePSDEOPPrivCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMapItem> selectByPSDER(PSDERBase pSDERBase) throws Exception {
        return this.selectByPSDER(pSDERBase, "", -1);
    }

    public ArrayList<PSSysMapItem> selectByPSDER(PSDERBase pSDERBase, String string) throws Exception {
        return this.selectByPSDER(pSDERBase, string, -1);
    }

    public ArrayList<PSSysMapItem> selectByPSDER(PSDERBase pSDERBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysMapItem> selectByPSDEToolbar(PSDEToolbarBase pSDEToolbarBase) throws Exception {
        return this.selectByPSDEToolbar(pSDEToolbarBase, "", -1);
    }

    public ArrayList<PSSysMapItem> selectByPSDEToolbar(PSDEToolbarBase pSDEToolbarBase, String string) throws Exception {
        return this.selectByPSDEToolbar(pSDEToolbarBase, string, -1);
    }

    public ArrayList<PSSysMapItem> selectByPSDEToolbar(PSDEToolbarBase pSDEToolbarBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDETOOLBARID", (Object)pSDEToolbarBase.getPSDEToolbarId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEToolbarCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEToolbarCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMapItem> selectByGroupPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase) throws Exception {
        return this.selectByGroupPSDEUAGroup(pSDEUAGroupBase, "", -1);
    }

    public ArrayList<PSSysMapItem> selectByGroupPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string) throws Exception {
        return this.selectByGroupPSDEUAGroup(pSDEUAGroupBase, string, -1);
    }

    public ArrayList<PSSysMapItem> selectByGroupPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("GROUPPSDEUAGROUPID", (Object)pSDEUAGroupBase.getPSDEUAGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByGroupPSDEUAGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByGroupPSDEUAGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMapItem> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByPSDEViewBase(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSSysMapItem> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByPSDEViewBase(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSSysMapItem> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysMapItem> selectByNamePSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByNamePSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSSysMapItem> selectByNamePSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByNamePSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSSysMapItem> selectByNamePSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NAMEPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByNamePSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByNamePSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMapItem> selectByPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSSysMapItem> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSSysMapItem> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSCSSID", (Object)pSSysCssBase.getPSSysCssId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysCssCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysCssCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMapItem> selectByShapePSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByShapePSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSSysMapItem> selectByShapePSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByShapePSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSSysMapItem> selectByShapePSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SHAPEPSSYSCSSID", (Object)pSSysCssBase.getPSSysCssId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByShapePSSysCssCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByShapePSSysCssCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMapItem> selectByPSSysImage(PSSysImageBase pSSysImageBase) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, "", -1);
    }

    public ArrayList<PSSysMapItem> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, string, -1);
    }

    public ArrayList<PSSysMapItem> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSIMAGEID", (Object)pSSysImageBase.getPSSysImageId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysImageCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysImageCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMapItem> selectByPSSysMapView(PSSysMapViewBase pSSysMapViewBase) throws Exception {
        return this.selectByPSSysMapView(pSSysMapViewBase, "", -1);
    }

    public ArrayList<PSSysMapItem> selectByPSSysMapView(PSSysMapViewBase pSSysMapViewBase, String string) throws Exception {
        return this.selectByPSSysMapView(pSSysMapViewBase, string, -1);
    }

    public ArrayList<PSSysMapItem> selectByPSSysMapView(PSSysMapViewBase pSSysMapViewBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSMAPVIEWID", (Object)pSSysMapViewBase.getPSSysMapViewId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysMapViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysMapViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMapItem> selectTempByPSSysMapView(PSSysMapViewBase pSSysMapViewBase) throws Exception {
        return this.selectTempByPSSysMapView(pSSysMapViewBase, "");
    }

    public ArrayList<PSSysMapItem> selectTempByPSSysMapView(PSSysMapViewBase pSSysMapViewBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSMAPVIEWID", (Object)pSSysMapViewBase.getPSSysMapViewId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSSysMapViewCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSSysMapViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysMapItem> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSSysMapItem> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSSysMapItem> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMAPITEM_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSSYSMAPITEM", iDataEntityModel.getDataInfo(pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            PSSysMapItem pSSysMapItem2 = (PSSysMapItem)this.getDEModel().createEntity();
            pSSysMapItem2.setPSSysMapItemId(pSSysMapItem.getPSSysMapItemId());
            pSSysMapItem2.setPSDEId(null);
            this.update(pSSysMapItem2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMapItemServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSSysMapItemServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSSysMapItemServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            this.remove(pSSysMapItem);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    public void testRemoveByMovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByMovePSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMAPITEM_PSDEACTION_MOVEPSDEACTIONID", "", iDataEntityModel.getName(), "PSSYSMAPITEM", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetMovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByMovePSDEAction(pSDEAction);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            PSSysMapItem pSSysMapItem2 = (PSSysMapItem)this.getDEModel().createEntity();
            pSSysMapItem2.setPSSysMapItemId(pSSysMapItem.getPSSysMapItemId());
            pSSysMapItem2.setMovePSDEActionId(null);
            this.update(pSSysMapItem2);
        }
    }

    public void removeByMovePSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMapItemServiceBase.this.onBeforeRemoveByMovePSDEAction(pSDEAction2);
                PSSysMapItemServiceBase.this.internalRemoveByMovePSDEAction(pSDEAction2);
                PSSysMapItemServiceBase.this.onAfterRemoveByMovePSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByMovePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByMovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByMovePSDEAction(pSDEAction);
        this.onBeforeRemoveByMovePSDEAction(pSDEAction, arrayList);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            this.remove(pSSysMapItem);
        }
        this.onAfterRemoveByMovePSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByMovePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByMovePSDEAction(PSDEAction pSDEAction, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMovePSDEAction(PSDEAction pSDEAction, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    public void testRemoveByRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByRemovePSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMAPITEM_PSDEACTION_REMOVEPSDEACTIONID", "", iDataEntityModel.getName(), "PSSYSMAPITEM", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByRemovePSDEAction(pSDEAction);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            PSSysMapItem pSSysMapItem2 = (PSSysMapItem)this.getDEModel().createEntity();
            pSSysMapItem2.setPSSysMapItemId(pSSysMapItem.getPSSysMapItemId());
            pSSysMapItem2.setRemovePSDEActionId(null);
            this.update(pSSysMapItem2);
        }
    }

    public void removeByRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMapItemServiceBase.this.onBeforeRemoveByRemovePSDEAction(pSDEAction2);
                PSSysMapItemServiceBase.this.internalRemoveByRemovePSDEAction(pSDEAction2);
                PSSysMapItemServiceBase.this.onAfterRemoveByRemovePSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByRemovePSDEAction(pSDEAction);
        this.onBeforeRemoveByRemovePSDEAction(pSDEAction, arrayList);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            this.remove(pSSysMapItem);
        }
        this.onAfterRemoveByRemovePSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByRemovePSDEAction(PSDEAction pSDEAction, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRemovePSDEAction(PSDEAction pSDEAction, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    public void testRemoveByAsyncPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByAsyncPSDEDS(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMAPITEM_PSDEDATASET_ASYNCPSDEDSID", "", iDataEntityModel.getName(), "PSSYSMAPITEM", iDataEntityModel.getDataInfo(pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetAsyncPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByAsyncPSDEDS(pSDEDataSet);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            PSSysMapItem pSSysMapItem2 = (PSSysMapItem)this.getDEModel().createEntity();
            pSSysMapItem2.setPSSysMapItemId(pSSysMapItem.getPSSysMapItemId());
            pSSysMapItem2.setAsyncPSDEDSId(null);
            this.update(pSSysMapItem2);
        }
    }

    public void removeByAsyncPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMapItemServiceBase.this.onBeforeRemoveByAsyncPSDEDS(pSDEDataSet2);
                PSSysMapItemServiceBase.this.internalRemoveByAsyncPSDEDS(pSDEDataSet2);
                PSSysMapItemServiceBase.this.onAfterRemoveByAsyncPSDEDS(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByAsyncPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByAsyncPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByAsyncPSDEDS(pSDEDataSet);
        this.onBeforeRemoveByAsyncPSDEDS(pSDEDataSet, arrayList);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            this.remove(pSSysMapItem);
        }
        this.onAfterRemoveByAsyncPSDEDS(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByAsyncPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByAsyncPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByAsyncPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByPSDEDS(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMAPITEM_PSDEDATASET_PSDEDSID", "", iDataEntityModel.getName(), "PSSYSMAPITEM", iDataEntityModel.getDataInfo(pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByPSDEDS(pSDEDataSet);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            PSSysMapItem pSSysMapItem2 = (PSSysMapItem)this.getDEModel().createEntity();
            pSSysMapItem2.setPSSysMapItemId(pSSysMapItem.getPSSysMapItemId());
            pSSysMapItem2.setPSDEDSId(null);
            this.update(pSSysMapItem2);
        }
    }

    public void removeByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMapItemServiceBase.this.onBeforeRemoveByPSDEDS(pSDEDataSet2);
                PSSysMapItemServiceBase.this.internalRemoveByPSDEDS(pSDEDataSet2);
                PSSysMapItemServiceBase.this.onAfterRemoveByPSDEDS(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByPSDEDS(pSDEDataSet);
        this.onBeforeRemoveByPSDEDS(pSDEDataSet, arrayList);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            this.remove(pSSysMapItem);
        }
        this.onAfterRemoveByPSDEDS(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    public void testRemoveByAltPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByAltPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMAPITEM_PSDEFIELD_ALTPSDEFID", "", iDataEntityModel.getName(), "PSSYSMAPITEM", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetAltPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByAltPSDEF(pSDEField);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            PSSysMapItem pSSysMapItem2 = (PSSysMapItem)this.getDEModel().createEntity();
            pSSysMapItem2.setPSSysMapItemId(pSSysMapItem.getPSSysMapItemId());
            pSSysMapItem2.setAltPSDEFId(null);
            this.update(pSSysMapItem2);
        }
    }

    public void removeByAltPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMapItemServiceBase.this.onBeforeRemoveByAltPSDEF(pSDEField2);
                PSSysMapItemServiceBase.this.internalRemoveByAltPSDEF(pSDEField2);
                PSSysMapItemServiceBase.this.onAfterRemoveByAltPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByAltPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByAltPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByAltPSDEF(pSDEField);
        this.onBeforeRemoveByAltPSDEF(pSDEField, arrayList);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            this.remove(pSSysMapItem);
        }
        this.onAfterRemoveByAltPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByAltPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByAltPSDEF(PSDEField pSDEField, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByAltPSDEF(PSDEField pSDEField, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    public void testRemoveByBKColorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByBKColorPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMAPITEM_PSDEFIELD_BKCOLORPSDEFID", "", iDataEntityModel.getName(), "PSSYSMAPITEM", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetBKColorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByBKColorPSDEF(pSDEField);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            PSSysMapItem pSSysMapItem2 = (PSSysMapItem)this.getDEModel().createEntity();
            pSSysMapItem2.setPSSysMapItemId(pSSysMapItem.getPSSysMapItemId());
            pSSysMapItem2.setBKColorPSDEFId(null);
            this.update(pSSysMapItem2);
        }
    }

    public void removeByBKColorPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMapItemServiceBase.this.onBeforeRemoveByBKColorPSDEF(pSDEField2);
                PSSysMapItemServiceBase.this.internalRemoveByBKColorPSDEF(pSDEField2);
                PSSysMapItemServiceBase.this.onAfterRemoveByBKColorPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByBKColorPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByBKColorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByBKColorPSDEF(pSDEField);
        this.onBeforeRemoveByBKColorPSDEF(pSDEField, arrayList);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            this.remove(pSSysMapItem);
        }
        this.onAfterRemoveByBKColorPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByBKColorPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByBKColorPSDEF(PSDEField pSDEField, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByBKColorPSDEF(PSDEField pSDEField, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    public void testRemoveByClsPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByClsPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMAPITEM_PSDEFIELD_CLSPSDEFID", "", iDataEntityModel.getName(), "PSSYSMAPITEM", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetClsPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByClsPSDEF(pSDEField);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            PSSysMapItem pSSysMapItem2 = (PSSysMapItem)this.getDEModel().createEntity();
            pSSysMapItem2.setPSSysMapItemId(pSSysMapItem.getPSSysMapItemId());
            pSSysMapItem2.setClsPSDEFId(null);
            this.update(pSSysMapItem2);
        }
    }

    public void removeByClsPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMapItemServiceBase.this.onBeforeRemoveByClsPSDEF(pSDEField2);
                PSSysMapItemServiceBase.this.internalRemoveByClsPSDEF(pSDEField2);
                PSSysMapItemServiceBase.this.onAfterRemoveByClsPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByClsPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByClsPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByClsPSDEF(pSDEField);
        this.onBeforeRemoveByClsPSDEF(pSDEField, arrayList);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            this.remove(pSSysMapItem);
        }
        this.onAfterRemoveByClsPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByClsPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByClsPSDEF(PSDEField pSDEField, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByClsPSDEF(PSDEField pSDEField, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    public void testRemoveByColorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByColorPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMAPITEM_PSDEFIELD_COLORPSDEFID", "", iDataEntityModel.getName(), "PSSYSMAPITEM", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetColorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByColorPSDEF(pSDEField);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            PSSysMapItem pSSysMapItem2 = (PSSysMapItem)this.getDEModel().createEntity();
            pSSysMapItem2.setPSSysMapItemId(pSSysMapItem.getPSSysMapItemId());
            pSSysMapItem2.setColorPSDEFId(null);
            this.update(pSSysMapItem2);
        }
    }

    public void removeByColorPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMapItemServiceBase.this.onBeforeRemoveByColorPSDEF(pSDEField2);
                PSSysMapItemServiceBase.this.internalRemoveByColorPSDEF(pSDEField2);
                PSSysMapItemServiceBase.this.onAfterRemoveByColorPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByColorPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByColorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByColorPSDEF(pSDEField);
        this.onBeforeRemoveByColorPSDEF(pSDEField, arrayList);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            this.remove(pSSysMapItem);
        }
        this.onAfterRemoveByColorPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByColorPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByColorPSDEF(PSDEField pSDEField, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByColorPSDEF(PSDEField pSDEField, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    public void testRemoveByContentPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByContentPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMAPITEM_PSDEFIELD_CONTENTPSDEFID", "", iDataEntityModel.getName(), "PSSYSMAPITEM", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetContentPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByContentPSDEF(pSDEField);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            PSSysMapItem pSSysMapItem2 = (PSSysMapItem)this.getDEModel().createEntity();
            pSSysMapItem2.setPSSysMapItemId(pSSysMapItem.getPSSysMapItemId());
            pSSysMapItem2.setContentPSDEFId(null);
            this.update(pSSysMapItem2);
        }
    }

    public void removeByContentPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMapItemServiceBase.this.onBeforeRemoveByContentPSDEF(pSDEField2);
                PSSysMapItemServiceBase.this.internalRemoveByContentPSDEF(pSDEField2);
                PSSysMapItemServiceBase.this.onAfterRemoveByContentPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByContentPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByContentPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByContentPSDEF(pSDEField);
        this.onBeforeRemoveByContentPSDEF(pSDEField, arrayList);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            this.remove(pSSysMapItem);
        }
        this.onAfterRemoveByContentPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByContentPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByContentPSDEF(PSDEField pSDEField, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByContentPSDEF(PSDEField pSDEField, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    public void testRemoveByData2PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByData2PSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMAPITEM_PSDEFIELD_DATA2PSDEFID", "", iDataEntityModel.getName(), "PSSYSMAPITEM", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetData2PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByData2PSDEF(pSDEField);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            PSSysMapItem pSSysMapItem2 = (PSSysMapItem)this.getDEModel().createEntity();
            pSSysMapItem2.setPSSysMapItemId(pSSysMapItem.getPSSysMapItemId());
            pSSysMapItem2.setData2PSDEFId(null);
            this.update(pSSysMapItem2);
        }
    }

    public void removeByData2PSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMapItemServiceBase.this.onBeforeRemoveByData2PSDEF(pSDEField2);
                PSSysMapItemServiceBase.this.internalRemoveByData2PSDEF(pSDEField2);
                PSSysMapItemServiceBase.this.onAfterRemoveByData2PSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByData2PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByData2PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByData2PSDEF(pSDEField);
        this.onBeforeRemoveByData2PSDEF(pSDEField, arrayList);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            this.remove(pSSysMapItem);
        }
        this.onAfterRemoveByData2PSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByData2PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByData2PSDEF(PSDEField pSDEField, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByData2PSDEF(PSDEField pSDEField, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    public void testRemoveByDataPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByDataPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMAPITEM_PSDEFIELD_DATAPSDEFID", "", iDataEntityModel.getName(), "PSSYSMAPITEM", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetDataPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByDataPSDEF(pSDEField);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            PSSysMapItem pSSysMapItem2 = (PSSysMapItem)this.getDEModel().createEntity();
            pSSysMapItem2.setPSSysMapItemId(pSSysMapItem.getPSSysMapItemId());
            pSSysMapItem2.setDataPSDEFId(null);
            this.update(pSSysMapItem2);
        }
    }

    public void removeByDataPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMapItemServiceBase.this.onBeforeRemoveByDataPSDEF(pSDEField2);
                PSSysMapItemServiceBase.this.internalRemoveByDataPSDEF(pSDEField2);
                PSSysMapItemServiceBase.this.onAfterRemoveByDataPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByDataPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByDataPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByDataPSDEF(pSDEField);
        this.onBeforeRemoveByDataPSDEF(pSDEField, arrayList);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            this.remove(pSSysMapItem);
        }
        this.onAfterRemoveByDataPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByDataPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByDataPSDEF(PSDEField pSDEField, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDataPSDEF(PSDEField pSDEField, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    public void testRemoveByGroupPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByGroupPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMAPITEM_PSDEFIELD_GROUPPSDEFID", "", iDataEntityModel.getName(), "PSSYSMAPITEM", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetGroupPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByGroupPSDEF(pSDEField);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            PSSysMapItem pSSysMapItem2 = (PSSysMapItem)this.getDEModel().createEntity();
            pSSysMapItem2.setPSSysMapItemId(pSSysMapItem.getPSSysMapItemId());
            pSSysMapItem2.setGroupPSDEFId(null);
            this.update(pSSysMapItem2);
        }
    }

    public void removeByGroupPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMapItemServiceBase.this.onBeforeRemoveByGroupPSDEF(pSDEField2);
                PSSysMapItemServiceBase.this.internalRemoveByGroupPSDEF(pSDEField2);
                PSSysMapItemServiceBase.this.onAfterRemoveByGroupPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByGroupPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByGroupPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByGroupPSDEF(pSDEField);
        this.onBeforeRemoveByGroupPSDEF(pSDEField, arrayList);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            this.remove(pSSysMapItem);
        }
        this.onAfterRemoveByGroupPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByGroupPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByGroupPSDEF(PSDEField pSDEField, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGroupPSDEF(PSDEField pSDEField, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    public void testRemoveByIconPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByIconPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMAPITEM_PSDEFIELD_ICONPSDEFID", "", iDataEntityModel.getName(), "PSSYSMAPITEM", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetIconPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByIconPSDEF(pSDEField);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            PSSysMapItem pSSysMapItem2 = (PSSysMapItem)this.getDEModel().createEntity();
            pSSysMapItem2.setPSSysMapItemId(pSSysMapItem.getPSSysMapItemId());
            pSSysMapItem2.setIconPSDEFId(null);
            this.update(pSSysMapItem2);
        }
    }

    public void removeByIconPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMapItemServiceBase.this.onBeforeRemoveByIconPSDEF(pSDEField2);
                PSSysMapItemServiceBase.this.internalRemoveByIconPSDEF(pSDEField2);
                PSSysMapItemServiceBase.this.onAfterRemoveByIconPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByIconPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByIconPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByIconPSDEF(pSDEField);
        this.onBeforeRemoveByIconPSDEF(pSDEField, arrayList);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            this.remove(pSSysMapItem);
        }
        this.onAfterRemoveByIconPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByIconPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByIconPSDEF(PSDEField pSDEField, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByIconPSDEF(PSDEField pSDEField, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    public void testRemoveByKeyPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByKeyPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMAPITEM_PSDEFIELD_KEYPSDEFID", "", iDataEntityModel.getName(), "PSSYSMAPITEM", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetKeyPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByKeyPSDEF(pSDEField);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            PSSysMapItem pSSysMapItem2 = (PSSysMapItem)this.getDEModel().createEntity();
            pSSysMapItem2.setPSSysMapItemId(pSSysMapItem.getPSSysMapItemId());
            pSSysMapItem2.setKeyPSDEFId(null);
            this.update(pSSysMapItem2);
        }
    }

    public void removeByKeyPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMapItemServiceBase.this.onBeforeRemoveByKeyPSDEF(pSDEField2);
                PSSysMapItemServiceBase.this.internalRemoveByKeyPSDEF(pSDEField2);
                PSSysMapItemServiceBase.this.onAfterRemoveByKeyPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByKeyPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByKeyPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByKeyPSDEF(pSDEField);
        this.onBeforeRemoveByKeyPSDEF(pSDEField, arrayList);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            this.remove(pSSysMapItem);
        }
        this.onAfterRemoveByKeyPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByKeyPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByKeyPSDEF(PSDEField pSDEField, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByKeyPSDEF(PSDEField pSDEField, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    public void testRemoveByLatPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByLatPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMAPITEM_PSDEFIELD_LATPSDEFID", "", iDataEntityModel.getName(), "PSSYSMAPITEM", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetLatPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByLatPSDEF(pSDEField);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            PSSysMapItem pSSysMapItem2 = (PSSysMapItem)this.getDEModel().createEntity();
            pSSysMapItem2.setPSSysMapItemId(pSSysMapItem.getPSSysMapItemId());
            pSSysMapItem2.setLatPSDEFId(null);
            this.update(pSSysMapItem2);
        }
    }

    public void removeByLatPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMapItemServiceBase.this.onBeforeRemoveByLatPSDEF(pSDEField2);
                PSSysMapItemServiceBase.this.internalRemoveByLatPSDEF(pSDEField2);
                PSSysMapItemServiceBase.this.onAfterRemoveByLatPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByLatPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByLatPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByLatPSDEF(pSDEField);
        this.onBeforeRemoveByLatPSDEF(pSDEField, arrayList);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            this.remove(pSSysMapItem);
        }
        this.onAfterRemoveByLatPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByLatPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByLatPSDEF(PSDEField pSDEField, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByLatPSDEF(PSDEField pSDEField, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    public void testRemoveByLinkPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByLinkPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMAPITEM_PSDEFIELD_LINKPSDEFID", "", iDataEntityModel.getName(), "PSSYSMAPITEM", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetLinkPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByLinkPSDEF(pSDEField);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            PSSysMapItem pSSysMapItem2 = (PSSysMapItem)this.getDEModel().createEntity();
            pSSysMapItem2.setPSSysMapItemId(pSSysMapItem.getPSSysMapItemId());
            pSSysMapItem2.setLinkPSDEFId(null);
            this.update(pSSysMapItem2);
        }
    }

    public void removeByLinkPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMapItemServiceBase.this.onBeforeRemoveByLinkPSDEF(pSDEField2);
                PSSysMapItemServiceBase.this.internalRemoveByLinkPSDEF(pSDEField2);
                PSSysMapItemServiceBase.this.onAfterRemoveByLinkPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByLinkPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByLinkPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByLinkPSDEF(pSDEField);
        this.onBeforeRemoveByLinkPSDEF(pSDEField, arrayList);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            this.remove(pSSysMapItem);
        }
        this.onAfterRemoveByLinkPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByLinkPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByLinkPSDEF(PSDEField pSDEField, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByLinkPSDEF(PSDEField pSDEField, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    public void testRemoveByLongPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByLongPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMAPITEM_PSDEFIELD_LONGPSDEFID", "", iDataEntityModel.getName(), "PSSYSMAPITEM", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetLongPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByLongPSDEF(pSDEField);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            PSSysMapItem pSSysMapItem2 = (PSSysMapItem)this.getDEModel().createEntity();
            pSSysMapItem2.setPSSysMapItemId(pSSysMapItem.getPSSysMapItemId());
            pSSysMapItem2.setLongPSDEFId(null);
            this.update(pSSysMapItem2);
        }
    }

    public void removeByLongPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMapItemServiceBase.this.onBeforeRemoveByLongPSDEF(pSDEField2);
                PSSysMapItemServiceBase.this.internalRemoveByLongPSDEF(pSDEField2);
                PSSysMapItemServiceBase.this.onAfterRemoveByLongPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByLongPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByLongPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByLongPSDEF(pSDEField);
        this.onBeforeRemoveByLongPSDEF(pSDEField, arrayList);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            this.remove(pSSysMapItem);
        }
        this.onAfterRemoveByLongPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByLongPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByLongPSDEF(PSDEField pSDEField, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByLongPSDEF(PSDEField pSDEField, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    public void testRemoveByOrderValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByOrderValuePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMAPITEM_PSDEFIELD_ORDERVALUEPSDEFID", "", iDataEntityModel.getName(), "PSSYSMAPITEM", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetOrderValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByOrderValuePSDEF(pSDEField);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            PSSysMapItem pSSysMapItem2 = (PSSysMapItem)this.getDEModel().createEntity();
            pSSysMapItem2.setPSSysMapItemId(pSSysMapItem.getPSSysMapItemId());
            pSSysMapItem2.setOrderValuePSDEFId(null);
            this.update(pSSysMapItem2);
        }
    }

    public void removeByOrderValuePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMapItemServiceBase.this.onBeforeRemoveByOrderValuePSDEF(pSDEField2);
                PSSysMapItemServiceBase.this.internalRemoveByOrderValuePSDEF(pSDEField2);
                PSSysMapItemServiceBase.this.onAfterRemoveByOrderValuePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByOrderValuePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByOrderValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByOrderValuePSDEF(pSDEField);
        this.onBeforeRemoveByOrderValuePSDEF(pSDEField, arrayList);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            this.remove(pSSysMapItem);
        }
        this.onAfterRemoveByOrderValuePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByOrderValuePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByOrderValuePSDEF(PSDEField pSDEField, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByOrderValuePSDEF(PSDEField pSDEField, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    public void testRemoveByShapeClsPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByShapeClsPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMAPITEM_PSDEFIELD_SHAPECLSPSDEFID", "", iDataEntityModel.getName(), "PSSYSMAPITEM", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetShapeClsPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByShapeClsPSDEF(pSDEField);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            PSSysMapItem pSSysMapItem2 = (PSSysMapItem)this.getDEModel().createEntity();
            pSSysMapItem2.setPSSysMapItemId(pSSysMapItem.getPSSysMapItemId());
            pSSysMapItem2.setShapeClsPSDEFId(null);
            this.update(pSSysMapItem2);
        }
    }

    public void removeByShapeClsPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMapItemServiceBase.this.onBeforeRemoveByShapeClsPSDEF(pSDEField2);
                PSSysMapItemServiceBase.this.internalRemoveByShapeClsPSDEF(pSDEField2);
                PSSysMapItemServiceBase.this.onAfterRemoveByShapeClsPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByShapeClsPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByShapeClsPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByShapeClsPSDEF(pSDEField);
        this.onBeforeRemoveByShapeClsPSDEF(pSDEField, arrayList);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            this.remove(pSSysMapItem);
        }
        this.onAfterRemoveByShapeClsPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByShapeClsPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByShapeClsPSDEF(PSDEField pSDEField, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByShapeClsPSDEF(PSDEField pSDEField, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    public void testRemoveByTag2PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByTag2PSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMAPITEM_PSDEFIELD_TAG2PSDEFID", "", iDataEntityModel.getName(), "PSSYSMAPITEM", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetTag2PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByTag2PSDEF(pSDEField);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            PSSysMapItem pSSysMapItem2 = (PSSysMapItem)this.getDEModel().createEntity();
            pSSysMapItem2.setPSSysMapItemId(pSSysMapItem.getPSSysMapItemId());
            pSSysMapItem2.setTag2PSDEFId(null);
            this.update(pSSysMapItem2);
        }
    }

    public void removeByTag2PSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMapItemServiceBase.this.onBeforeRemoveByTag2PSDEF(pSDEField2);
                PSSysMapItemServiceBase.this.internalRemoveByTag2PSDEF(pSDEField2);
                PSSysMapItemServiceBase.this.onAfterRemoveByTag2PSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByTag2PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByTag2PSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByTag2PSDEF(pSDEField);
        this.onBeforeRemoveByTag2PSDEF(pSDEField, arrayList);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            this.remove(pSSysMapItem);
        }
        this.onAfterRemoveByTag2PSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByTag2PSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByTag2PSDEF(PSDEField pSDEField, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTag2PSDEF(PSDEField pSDEField, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    public void testRemoveByTagPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByTagPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMAPITEM_PSDEFIELD_TAGPSDEFID", "", iDataEntityModel.getName(), "PSSYSMAPITEM", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetTagPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByTagPSDEF(pSDEField);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            PSSysMapItem pSSysMapItem2 = (PSSysMapItem)this.getDEModel().createEntity();
            pSSysMapItem2.setPSSysMapItemId(pSSysMapItem.getPSSysMapItemId());
            pSSysMapItem2.setTagPSDEFId(null);
            this.update(pSSysMapItem2);
        }
    }

    public void removeByTagPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMapItemServiceBase.this.onBeforeRemoveByTagPSDEF(pSDEField2);
                PSSysMapItemServiceBase.this.internalRemoveByTagPSDEF(pSDEField2);
                PSSysMapItemServiceBase.this.onAfterRemoveByTagPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByTagPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByTagPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByTagPSDEF(pSDEField);
        this.onBeforeRemoveByTagPSDEF(pSDEField, arrayList);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            this.remove(pSSysMapItem);
        }
        this.onAfterRemoveByTagPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByTagPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByTagPSDEF(PSDEField pSDEField, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTagPSDEF(PSDEField pSDEField, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    public void testRemoveByTextPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByTextPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMAPITEM_PSDEFIELD_TEXTPSDEFID", "", iDataEntityModel.getName(), "PSSYSMAPITEM", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetTextPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByTextPSDEF(pSDEField);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            PSSysMapItem pSSysMapItem2 = (PSSysMapItem)this.getDEModel().createEntity();
            pSSysMapItem2.setPSSysMapItemId(pSSysMapItem.getPSSysMapItemId());
            pSSysMapItem2.setTextPSDEFId(null);
            this.update(pSSysMapItem2);
        }
    }

    public void removeByTextPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMapItemServiceBase.this.onBeforeRemoveByTextPSDEF(pSDEField2);
                PSSysMapItemServiceBase.this.internalRemoveByTextPSDEF(pSDEField2);
                PSSysMapItemServiceBase.this.onAfterRemoveByTextPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByTextPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByTextPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByTextPSDEF(pSDEField);
        this.onBeforeRemoveByTextPSDEF(pSDEField, arrayList);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            this.remove(pSSysMapItem);
        }
        this.onAfterRemoveByTextPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByTextPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByTextPSDEF(PSDEField pSDEField, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTextPSDEF(PSDEField pSDEField, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    public void testRemoveByTimePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByTimePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMAPITEM_PSDEFIELD_TIMEPSDEFID", "", iDataEntityModel.getName(), "PSSYSMAPITEM", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetTimePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByTimePSDEF(pSDEField);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            PSSysMapItem pSSysMapItem2 = (PSSysMapItem)this.getDEModel().createEntity();
            pSSysMapItem2.setPSSysMapItemId(pSSysMapItem.getPSSysMapItemId());
            pSSysMapItem2.setTimePSDEFId(null);
            this.update(pSSysMapItem2);
        }
    }

    public void removeByTimePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMapItemServiceBase.this.onBeforeRemoveByTimePSDEF(pSDEField2);
                PSSysMapItemServiceBase.this.internalRemoveByTimePSDEF(pSDEField2);
                PSSysMapItemServiceBase.this.onAfterRemoveByTimePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByTimePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByTimePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByTimePSDEF(pSDEField);
        this.onBeforeRemoveByTimePSDEF(pSDEField, arrayList);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            this.remove(pSSysMapItem);
        }
        this.onAfterRemoveByTimePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByTimePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByTimePSDEF(PSDEField pSDEField, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTimePSDEF(PSDEField pSDEField, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    public void testRemoveByTipsPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByTipsPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMAPITEM_PSDEFIELD_TIPSPSDEFID", "", iDataEntityModel.getName(), "PSSYSMAPITEM", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetTipsPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByTipsPSDEF(pSDEField);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            PSSysMapItem pSSysMapItem2 = (PSSysMapItem)this.getDEModel().createEntity();
            pSSysMapItem2.setPSSysMapItemId(pSSysMapItem.getPSSysMapItemId());
            pSSysMapItem2.setTipsPSDEFId(null);
            this.update(pSSysMapItem2);
        }
    }

    public void removeByTipsPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMapItemServiceBase.this.onBeforeRemoveByTipsPSDEF(pSDEField2);
                PSSysMapItemServiceBase.this.internalRemoveByTipsPSDEF(pSDEField2);
                PSSysMapItemServiceBase.this.onAfterRemoveByTipsPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByTipsPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByTipsPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByTipsPSDEF(pSDEField);
        this.onBeforeRemoveByTipsPSDEF(pSDEField, arrayList);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            this.remove(pSSysMapItem);
        }
        this.onAfterRemoveByTipsPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByTipsPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByTipsPSDEF(PSDEField pSDEField, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTipsPSDEF(PSDEField pSDEField, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByPSDELogic(pSDELogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDELogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMAPITEM_PSDELOGIC_PSDELOGICID", "", iDataEntityModel.getName(), "PSSYSMAPITEM", iDataEntityModel.getDataInfo(pSDELogic), arrayList.get(0)));
        }
    }

    public void resetPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByPSDELogic(pSDELogic);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            PSSysMapItem pSSysMapItem2 = (PSSysMapItem)this.getDEModel().createEntity();
            pSSysMapItem2.setPSSysMapItemId(pSSysMapItem.getPSSysMapItemId());
            pSSysMapItem2.setPSDELogicId(null);
            this.update(pSSysMapItem2);
        }
    }

    public void removeByPSDELogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMapItemServiceBase.this.onBeforeRemoveByPSDELogic(pSDELogic2);
                PSSysMapItemServiceBase.this.internalRemoveByPSDELogic(pSDELogic2);
                PSSysMapItemServiceBase.this.onAfterRemoveByPSDELogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByPSDELogic(pSDELogic);
        this.onBeforeRemoveByPSDELogic(pSDELogic, arrayList);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            this.remove(pSSysMapItem);
        }
        this.onAfterRemoveByPSDELogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    public void testRemoveByMovePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByMovePSDEOPPriv(pSDEOPPriv, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEOPPRIV");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEOPPriv);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMAPITEM_PSDEOPPRIV_MOVEPSDEOPPRIVID", "", iDataEntityModel.getName(), "PSSYSMAPITEM", iDataEntityModel.getDataInfo(pSDEOPPriv), arrayList.get(0)));
        }
    }

    public void resetMovePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByMovePSDEOPPriv(pSDEOPPriv);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            PSSysMapItem pSSysMapItem2 = (PSSysMapItem)this.getDEModel().createEntity();
            pSSysMapItem2.setPSSysMapItemId(pSSysMapItem.getPSSysMapItemId());
            pSSysMapItem2.setMovePSDEOPPrivId(null);
            this.update(pSSysMapItem2);
        }
    }

    public void removeByMovePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        final PSDEOPPriv pSDEOPPriv2 = pSDEOPPriv;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMapItemServiceBase.this.onBeforeRemoveByMovePSDEOPPriv(pSDEOPPriv2);
                PSSysMapItemServiceBase.this.internalRemoveByMovePSDEOPPriv(pSDEOPPriv2);
                PSSysMapItemServiceBase.this.onAfterRemoveByMovePSDEOPPriv(pSDEOPPriv2);
            }
        });
    }

    protected void onBeforeRemoveByMovePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void internalRemoveByMovePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByMovePSDEOPPriv(pSDEOPPriv);
        this.onBeforeRemoveByMovePSDEOPPriv(pSDEOPPriv, arrayList);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            this.remove(pSSysMapItem);
        }
        this.onAfterRemoveByMovePSDEOPPriv(pSDEOPPriv, arrayList);
    }

    protected void onAfterRemoveByMovePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void onBeforeRemoveByMovePSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMovePSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    public void testRemoveByRemovePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByRemovePSDEOPPriv(pSDEOPPriv, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEOPPRIV");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEOPPriv);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMAPITEM_PSDEOPPRIV_REMOVEPSDEOPPRIVID", "", iDataEntityModel.getName(), "PSSYSMAPITEM", iDataEntityModel.getDataInfo(pSDEOPPriv), arrayList.get(0)));
        }
    }

    public void resetRemovePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByRemovePSDEOPPriv(pSDEOPPriv);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            PSSysMapItem pSSysMapItem2 = (PSSysMapItem)this.getDEModel().createEntity();
            pSSysMapItem2.setPSSysMapItemId(pSSysMapItem.getPSSysMapItemId());
            pSSysMapItem2.setRemovePSDEOPPrivId(null);
            this.update(pSSysMapItem2);
        }
    }

    public void removeByRemovePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        final PSDEOPPriv pSDEOPPriv2 = pSDEOPPriv;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMapItemServiceBase.this.onBeforeRemoveByRemovePSDEOPPriv(pSDEOPPriv2);
                PSSysMapItemServiceBase.this.internalRemoveByRemovePSDEOPPriv(pSDEOPPriv2);
                PSSysMapItemServiceBase.this.onAfterRemoveByRemovePSDEOPPriv(pSDEOPPriv2);
            }
        });
    }

    protected void onBeforeRemoveByRemovePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void internalRemoveByRemovePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByRemovePSDEOPPriv(pSDEOPPriv);
        this.onBeforeRemoveByRemovePSDEOPPriv(pSDEOPPriv, arrayList);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            this.remove(pSSysMapItem);
        }
        this.onAfterRemoveByRemovePSDEOPPriv(pSDEOPPriv, arrayList);
    }

    protected void onAfterRemoveByRemovePSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void onBeforeRemoveByRemovePSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRemovePSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByPSDER(pSDER, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDER);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMAPITEM_PSDER_PSDERID", "", iDataEntityModel.getName(), "PSSYSMAPITEM", iDataEntityModel.getDataInfo(pSDER), arrayList.get(0)));
        }
    }

    public void resetPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByPSDER(pSDER);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            PSSysMapItem pSSysMapItem2 = (PSSysMapItem)this.getDEModel().createEntity();
            pSSysMapItem2.setPSSysMapItemId(pSSysMapItem.getPSSysMapItemId());
            pSSysMapItem2.setPSDERId(null);
            this.update(pSSysMapItem2);
        }
    }

    public void removeByPSDER(PSDER pSDER) throws Exception {
        final PSDER pSDER2 = pSDER;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMapItemServiceBase.this.onBeforeRemoveByPSDER(pSDER2);
                PSSysMapItemServiceBase.this.internalRemoveByPSDER(pSDER2);
                PSSysMapItemServiceBase.this.onAfterRemoveByPSDER(pSDER2);
            }
        });
    }

    protected void onBeforeRemoveByPSDER(PSDER pSDER) throws Exception {
    }

    protected void internalRemoveByPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByPSDER(pSDER);
        this.onBeforeRemoveByPSDER(pSDER, arrayList);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            this.remove(pSSysMapItem);
        }
        this.onAfterRemoveByPSDER(pSDER, arrayList);
    }

    protected void onAfterRemoveByPSDER(PSDER pSDER) throws Exception {
    }

    protected void onBeforeRemoveByPSDER(PSDER pSDER, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDER(PSDER pSDER, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByPSDEToolbar(pSDEToolbar, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDETOOLBAR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEToolbar);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMAPITEM_PSDETOOLBAR_PSDETOOLBARID", "", iDataEntityModel.getName(), "PSSYSMAPITEM", iDataEntityModel.getDataInfo(pSDEToolbar), arrayList.get(0)));
        }
    }

    public void resetPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByPSDEToolbar(pSDEToolbar);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            PSSysMapItem pSSysMapItem2 = (PSSysMapItem)this.getDEModel().createEntity();
            pSSysMapItem2.setPSSysMapItemId(pSSysMapItem.getPSSysMapItemId());
            pSSysMapItem2.setPSDEToolbarId(null);
            this.update(pSSysMapItem2);
        }
    }

    public void removeByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        final PSDEToolbar pSDEToolbar2 = pSDEToolbar;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMapItemServiceBase.this.onBeforeRemoveByPSDEToolbar(pSDEToolbar2);
                PSSysMapItemServiceBase.this.internalRemoveByPSDEToolbar(pSDEToolbar2);
                PSSysMapItemServiceBase.this.onAfterRemoveByPSDEToolbar(pSDEToolbar2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
    }

    protected void internalRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByPSDEToolbar(pSDEToolbar);
        this.onBeforeRemoveByPSDEToolbar(pSDEToolbar, arrayList);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            this.remove(pSSysMapItem);
        }
        this.onAfterRemoveByPSDEToolbar(pSDEToolbar, arrayList);
    }

    protected void onAfterRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
    }

    protected void onBeforeRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    public void testRemoveByGroupPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByGroupPSDEUAGroup(pSDEUAGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUAGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEUAGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMAPITEM_PSDEUAGROUP_GROUPPSDEUAGROUPID", "", iDataEntityModel.getName(), "PSSYSMAPITEM", iDataEntityModel.getDataInfo(pSDEUAGroup), arrayList.get(0)));
        }
    }

    public void resetGroupPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByGroupPSDEUAGroup(pSDEUAGroup);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            PSSysMapItem pSSysMapItem2 = (PSSysMapItem)this.getDEModel().createEntity();
            pSSysMapItem2.setPSSysMapItemId(pSSysMapItem.getPSSysMapItemId());
            pSSysMapItem2.setGroupPSDEUAGroupId(null);
            this.update(pSSysMapItem2);
        }
    }

    public void removeByGroupPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        final PSDEUAGroup pSDEUAGroup2 = pSDEUAGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMapItemServiceBase.this.onBeforeRemoveByGroupPSDEUAGroup(pSDEUAGroup2);
                PSSysMapItemServiceBase.this.internalRemoveByGroupPSDEUAGroup(pSDEUAGroup2);
                PSSysMapItemServiceBase.this.onAfterRemoveByGroupPSDEUAGroup(pSDEUAGroup2);
            }
        });
    }

    protected void onBeforeRemoveByGroupPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void internalRemoveByGroupPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByGroupPSDEUAGroup(pSDEUAGroup);
        this.onBeforeRemoveByGroupPSDEUAGroup(pSDEUAGroup, arrayList);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            this.remove(pSSysMapItem);
        }
        this.onAfterRemoveByGroupPSDEUAGroup(pSDEUAGroup, arrayList);
    }

    protected void onAfterRemoveByGroupPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void onBeforeRemoveByGroupPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGroupPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByPSDEViewBase(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMAPITEM_PSDEVIEWBASE_PSDEVIEWBASEID", "", iDataEntityModel.getName(), "PSSYSMAPITEM", iDataEntityModel.getDataInfo(pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByPSDEViewBase(pSDEViewBase);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            PSSysMapItem pSSysMapItem2 = (PSSysMapItem)this.getDEModel().createEntity();
            pSSysMapItem2.setPSSysMapItemId(pSSysMapItem.getPSSysMapItemId());
            pSSysMapItem2.setPSDEViewBaseId(null);
            this.update(pSSysMapItem2);
        }
    }

    public void removeByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMapItemServiceBase.this.onBeforeRemoveByPSDEViewBase(pSDEViewBase2);
                PSSysMapItemServiceBase.this.internalRemoveByPSDEViewBase(pSDEViewBase2);
                PSSysMapItemServiceBase.this.onAfterRemoveByPSDEViewBase(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByPSDEViewBase(pSDEViewBase);
        this.onBeforeRemoveByPSDEViewBase(pSDEViewBase, arrayList);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            this.remove(pSSysMapItem);
        }
        this.onAfterRemoveByPSDEViewBase(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    public void testRemoveByNamePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByNamePSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMAPITEM_PSLANGUAGERES_NAMEPSLANRESID", "", iDataEntityModel.getName(), "PSSYSMAPITEM", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetNamePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByNamePSLanRes(pSLanguageRes);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            PSSysMapItem pSSysMapItem2 = (PSSysMapItem)this.getDEModel().createEntity();
            pSSysMapItem2.setPSSysMapItemId(pSSysMapItem.getPSSysMapItemId());
            pSSysMapItem2.setNamePSLanResId(null);
            this.update(pSSysMapItem2);
        }
    }

    public void removeByNamePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMapItemServiceBase.this.onBeforeRemoveByNamePSLanRes(pSLanguageRes2);
                PSSysMapItemServiceBase.this.internalRemoveByNamePSLanRes(pSLanguageRes2);
                PSSysMapItemServiceBase.this.onAfterRemoveByNamePSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByNamePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByNamePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByNamePSLanRes(pSLanguageRes);
        this.onBeforeRemoveByNamePSLanRes(pSLanguageRes, arrayList);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            this.remove(pSSysMapItem);
        }
        this.onAfterRemoveByNamePSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByNamePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByNamePSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNamePSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMAPITEM_PSSYSCSS_PSSYSCSSID", "", iDataEntityModel.getName(), "PSSYSMAPITEM", iDataEntityModel.getDataInfo(pSSysCss), arrayList.get(0)));
        }
    }

    public void resetPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByPSSysCss(pSSysCss);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            PSSysMapItem pSSysMapItem2 = (PSSysMapItem)this.getDEModel().createEntity();
            pSSysMapItem2.setPSSysMapItemId(pSSysMapItem.getPSSysMapItemId());
            pSSysMapItem2.setPSSysCssId(null);
            this.update(pSSysMapItem2);
        }
    }

    public void removeByPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMapItemServiceBase.this.onBeforeRemoveByPSSysCss(pSSysCss2);
                PSSysMapItemServiceBase.this.internalRemoveByPSSysCss(pSSysCss2);
                PSSysMapItemServiceBase.this.onAfterRemoveByPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByPSSysCss(pSSysCss);
        this.onBeforeRemoveByPSSysCss(pSSysCss, arrayList);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            this.remove(pSSysMapItem);
        }
        this.onAfterRemoveByPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    public void testRemoveByShapePSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByShapePSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMAPITEM_PSSYSCSS_SHAPEPSSYSCSSID", "", iDataEntityModel.getName(), "PSSYSMAPITEM", iDataEntityModel.getDataInfo(pSSysCss), arrayList.get(0)));
        }
    }

    public void resetShapePSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByShapePSSysCss(pSSysCss);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            PSSysMapItem pSSysMapItem2 = (PSSysMapItem)this.getDEModel().createEntity();
            pSSysMapItem2.setPSSysMapItemId(pSSysMapItem.getPSSysMapItemId());
            pSSysMapItem2.setShapePSSysCssId(null);
            this.update(pSSysMapItem2);
        }
    }

    public void removeByShapePSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMapItemServiceBase.this.onBeforeRemoveByShapePSSysCss(pSSysCss2);
                PSSysMapItemServiceBase.this.internalRemoveByShapePSSysCss(pSSysCss2);
                PSSysMapItemServiceBase.this.onAfterRemoveByShapePSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByShapePSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByShapePSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByShapePSSysCss(pSSysCss);
        this.onBeforeRemoveByShapePSSysCss(pSSysCss, arrayList);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            this.remove(pSSysMapItem);
        }
        this.onAfterRemoveByShapePSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByShapePSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByShapePSSysCss(PSSysCss pSSysCss, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByShapePSSysCss(PSSysCss pSSysCss, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByPSSysImage(pSSysImage, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSIMAGE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysImage);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMAPITEM_PSSYSIMAGE_PSSYSIMAGEID", "", iDataEntityModel.getName(), "PSSYSMAPITEM", iDataEntityModel.getDataInfo(pSSysImage), arrayList.get(0)));
        }
    }

    public void resetPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByPSSysImage(pSSysImage);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            PSSysMapItem pSSysMapItem2 = (PSSysMapItem)this.getDEModel().createEntity();
            pSSysMapItem2.setPSSysMapItemId(pSSysMapItem.getPSSysMapItemId());
            pSSysMapItem2.setPSSysImageId(null);
            this.update(pSSysMapItem2);
        }
    }

    public void removeByPSSysImage(PSSysImage pSSysImage) throws Exception {
        final PSSysImage pSSysImage2 = pSSysImage;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMapItemServiceBase.this.onBeforeRemoveByPSSysImage(pSSysImage2);
                PSSysMapItemServiceBase.this.internalRemoveByPSSysImage(pSSysImage2);
                PSSysMapItemServiceBase.this.onAfterRemoveByPSSysImage(pSSysImage2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void internalRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByPSSysImage(pSSysImage);
        this.onBeforeRemoveByPSSysImage(pSSysImage, arrayList);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            this.remove(pSSysMapItem);
        }
        this.onAfterRemoveByPSSysImage(pSSysImage, arrayList);
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysMapView(PSSysMapView pSSysMapView) throws Exception {
    }

    public void resetPSSysMapView(PSSysMapView pSSysMapView) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByPSSysMapView(pSSysMapView);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            PSSysMapItem pSSysMapItem2 = (PSSysMapItem)this.getDEModel().createEntity();
            pSSysMapItem2.setPSSysMapItemId(pSSysMapItem.getPSSysMapItemId());
            pSSysMapItem2.setPSSysMapViewId(null);
            this.update(pSSysMapItem2);
        }
    }

    public void resetTempPSSysMapView(PSSysMapView pSSysMapView) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectTempByPSSysMapView(pSSysMapView);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            PSSysMapItem pSSysMapItem2 = (PSSysMapItem)this.getDEModel().createEntity();
            pSSysMapItem2.setPSSysMapItemId(pSSysMapItem.getPSSysMapItemId());
            pSSysMapItem2.setPSSysMapViewId(null);
            this.updateTemp(pSSysMapItem2);
        }
    }

    public void removeByPSSysMapView(PSSysMapView pSSysMapView) throws Exception {
        final PSSysMapView pSSysMapView2 = pSSysMapView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMapItemServiceBase.this.onBeforeRemoveByPSSysMapView(pSSysMapView2);
                PSSysMapItemServiceBase.this.internalRemoveByPSSysMapView(pSSysMapView2);
                PSSysMapItemServiceBase.this.onAfterRemoveByPSSysMapView(pSSysMapView2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysMapView(PSSysMapView pSSysMapView) throws Exception {
    }

    protected void internalRemoveByPSSysMapView(PSSysMapView pSSysMapView) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByPSSysMapView(pSSysMapView);
        this.onBeforeRemoveByPSSysMapView(pSSysMapView, arrayList);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            this.remove(pSSysMapItem);
        }
        this.onAfterRemoveByPSSysMapView(pSSysMapView, arrayList);
    }

    protected void onAfterRemoveByPSSysMapView(PSSysMapView pSSysMapView) throws Exception {
    }

    protected void onBeforeRemoveByPSSysMapView(PSSysMapView pSSysMapView, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysMapView(PSSysMapView pSSysMapView, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMAPITEM_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSSYSMAPITEM", iDataEntityModel.getDataInfo(pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            PSSysMapItem pSSysMapItem2 = (PSSysMapItem)this.getDEModel().createEntity();
            pSSysMapItem2.setPSSysMapItemId(pSSysMapItem.getPSSysMapItemId());
            pSSysMapItem2.setPSSysPFPluginId(null);
            this.update(pSSysMapItem2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMapItemServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSSysMapItemServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSSysMapItemServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            this.remove(pSSysMapItem);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysMapItem pSSysMapItem) throws Exception {
        PSSysMapLogicService pSSysMapLogicService = (PSSysMapLogicService)ServiceGlobal.getService(PSSysMapLogicService.class, (SessionFactory)this.getSessionFactory());
        pSSysMapLogicService.testRemoveByPSSysMapItem(pSSysMapItem);
        super.onBeforeRemove(pSSysMapItem);
    }

    protected void onBeforeRemoveTemp(PSSysMapItem pSSysMapItem) throws Exception {
        PSSysMapLogicService pSSysMapLogicService = (PSSysMapLogicService)ServiceGlobal.getService(PSSysMapLogicService.class, (SessionFactory)this.getSessionFactory());
        pSSysMapLogicService.resetTempPSSysMapItem(pSSysMapItem);
        super.onBeforeRemoveTemp(pSSysMapItem);
    }

    public void removeTempByPSSysMapView(PSSysMapView pSSysMapView) throws Exception {
        final PSSysMapView pSSysMapView2 = pSSysMapView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysMapItemServiceBase.this.onBeforeRemoveTempByPSSysMapView(pSSysMapView2);
                PSSysMapItemServiceBase.this.internalRemoveTempByPSSysMapView(pSSysMapView2);
                PSSysMapItemServiceBase.this.onAfterRemoveTempByPSSysMapView(pSSysMapView2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSSysMapView(PSSysMapView pSSysMapView) throws Exception {
    }

    protected void internalRemoveTempByPSSysMapView(PSSysMapView pSSysMapView) throws Exception {
        ArrayList<PSSysMapItem> arrayList = this.selectTempByPSSysMapView(pSSysMapView);
        this.onBeforeRemoveTempByPSSysMapView(pSSysMapView, arrayList);
        for (PSSysMapItem pSSysMapItem : arrayList) {
            this.removeTemp(pSSysMapItem);
        }
        this.onAfterRemoveTempByPSSysMapView(pSSysMapView, arrayList);
    }

    protected void onAfterRemoveTempByPSSysMapView(PSSysMapView pSSysMapView) throws Exception {
    }

    protected void onBeforeRemoveTempByPSSysMapView(PSSysMapView pSSysMapView, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSSysMapView(PSSysMapView pSSysMapView, ArrayList<PSSysMapItem> arrayList) throws Exception {
    }

    protected void getRelatedDataTempMajor(PSSysMapItem pSSysMapItem) throws Exception {
        super.getRelatedDataTempMajor(pSSysMapItem);
    }

    protected void updateRelatedDataTempMajor(PSSysMapItem pSSysMapItem, PSSysMapItem pSSysMapItem2) throws Exception {
        super.updateRelatedDataTempMajor(pSSysMapItem, pSSysMapItem2);
    }

    protected void replaceParentInfo(PSSysMapItem pSSysMapItem, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysMapItem, cloneSession);
        if (pSSysMapItem.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysMapItem.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSSysMapItem, (PSDataEntity)iEntity);
        }
        if (pSSysMapItem.getMovePSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSSysMapItem.getMovePSDEActionId())) != null) {
            this.onFillParentInfo_MovePSDEAction(pSSysMapItem, (PSDEAction)iEntity);
        }
        if (pSSysMapItem.getRemovePSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSSysMapItem.getRemovePSDEActionId())) != null) {
            this.onFillParentInfo_RemovePSDEAction(pSSysMapItem, (PSDEAction)iEntity);
        }
        if (pSSysMapItem.getAsyncPSDEDSId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSSysMapItem.getAsyncPSDEDSId())) != null) {
            this.onFillParentInfo_AsyncPSDEDS(pSSysMapItem, (PSDEDataSet)iEntity);
        }
        if (pSSysMapItem.getPSDEDSId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSSysMapItem.getPSDEDSId())) != null) {
            this.onFillParentInfo_PSDEDS(pSSysMapItem, (PSDEDataSet)iEntity);
        }
        if (pSSysMapItem.getAltPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMapItem.getAltPSDEFId())) != null) {
            this.onFillParentInfo_AltPSDEF(pSSysMapItem, (PSDEField)iEntity);
        }
        if (pSSysMapItem.getBKColorPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMapItem.getBKColorPSDEFId())) != null) {
            this.onFillParentInfo_BKColorPSDEF(pSSysMapItem, (PSDEField)iEntity);
        }
        if (pSSysMapItem.getClsPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMapItem.getClsPSDEFId())) != null) {
            this.onFillParentInfo_ClsPSDEF(pSSysMapItem, (PSDEField)iEntity);
        }
        if (pSSysMapItem.getColorPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMapItem.getColorPSDEFId())) != null) {
            this.onFillParentInfo_ColorPSDEF(pSSysMapItem, (PSDEField)iEntity);
        }
        if (pSSysMapItem.getContentPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMapItem.getContentPSDEFId())) != null) {
            this.onFillParentInfo_ContentPSDEF(pSSysMapItem, (PSDEField)iEntity);
        }
        if (pSSysMapItem.getData2PSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMapItem.getData2PSDEFId())) != null) {
            this.onFillParentInfo_Data2PSDEF(pSSysMapItem, (PSDEField)iEntity);
        }
        if (pSSysMapItem.getDataPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMapItem.getDataPSDEFId())) != null) {
            this.onFillParentInfo_DataPSDEF(pSSysMapItem, (PSDEField)iEntity);
        }
        if (pSSysMapItem.getGroupPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMapItem.getGroupPSDEFId())) != null) {
            this.onFillParentInfo_GroupPSDEF(pSSysMapItem, (PSDEField)iEntity);
        }
        if (pSSysMapItem.getIconPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMapItem.getIconPSDEFId())) != null) {
            this.onFillParentInfo_IconPSDEF(pSSysMapItem, (PSDEField)iEntity);
        }
        if (pSSysMapItem.getKeyPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMapItem.getKeyPSDEFId())) != null) {
            this.onFillParentInfo_KeyPSDEF(pSSysMapItem, (PSDEField)iEntity);
        }
        if (pSSysMapItem.getLatPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMapItem.getLatPSDEFId())) != null) {
            this.onFillParentInfo_LatPSDEF(pSSysMapItem, (PSDEField)iEntity);
        }
        if (pSSysMapItem.getLinkPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMapItem.getLinkPSDEFId())) != null) {
            this.onFillParentInfo_LinkPSDEF(pSSysMapItem, (PSDEField)iEntity);
        }
        if (pSSysMapItem.getLongPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMapItem.getLongPSDEFId())) != null) {
            this.onFillParentInfo_LongPSDEF(pSSysMapItem, (PSDEField)iEntity);
        }
        if (pSSysMapItem.getOrderValuePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMapItem.getOrderValuePSDEFId())) != null) {
            this.onFillParentInfo_OrderValuePSDEF(pSSysMapItem, (PSDEField)iEntity);
        }
        if (pSSysMapItem.getShapeClsPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMapItem.getShapeClsPSDEFId())) != null) {
            this.onFillParentInfo_ShapeClsPSDEF(pSSysMapItem, (PSDEField)iEntity);
        }
        if (pSSysMapItem.getTag2PSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMapItem.getTag2PSDEFId())) != null) {
            this.onFillParentInfo_Tag2PSDEF(pSSysMapItem, (PSDEField)iEntity);
        }
        if (pSSysMapItem.getTagPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMapItem.getTagPSDEFId())) != null) {
            this.onFillParentInfo_TagPSDEF(pSSysMapItem, (PSDEField)iEntity);
        }
        if (pSSysMapItem.getTextPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMapItem.getTextPSDEFId())) != null) {
            this.onFillParentInfo_TextPSDEF(pSSysMapItem, (PSDEField)iEntity);
        }
        if (pSSysMapItem.getTimePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMapItem.getTimePSDEFId())) != null) {
            this.onFillParentInfo_TimePSDEF(pSSysMapItem, (PSDEField)iEntity);
        }
        if (pSSysMapItem.getTipsPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysMapItem.getTipsPSDEFId())) != null) {
            this.onFillParentInfo_TipsPSDEF(pSSysMapItem, (PSDEField)iEntity);
        }
        if (pSSysMapItem.getPSDELogicId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSSysMapItem.getPSDELogicId())) != null) {
            this.onFillParentInfo_PSDELogic(pSSysMapItem, (PSDELogic)iEntity);
        }
        if (pSSysMapItem.getMovePSDEOPPrivId() != null && (iEntity = cloneSession.getEntity("PSDEOPPRIV", (Object)pSSysMapItem.getMovePSDEOPPrivId())) != null) {
            this.onFillParentInfo_MovePSDEOPPriv(pSSysMapItem, (PSDEOPPriv)iEntity);
        }
        if (pSSysMapItem.getRemovePSDEOPPrivId() != null && (iEntity = cloneSession.getEntity("PSDEOPPRIV", (Object)pSSysMapItem.getRemovePSDEOPPrivId())) != null) {
            this.onFillParentInfo_RemovePSDEOPPriv(pSSysMapItem, (PSDEOPPriv)iEntity);
        }
        if (pSSysMapItem.getPSDERId() != null && (iEntity = cloneSession.getEntity("PSDER", (Object)pSSysMapItem.getPSDERId())) != null) {
            this.onFillParentInfo_PSDER(pSSysMapItem, (PSDER)iEntity);
        }
        if (pSSysMapItem.getPSDEToolbarId() != null && (iEntity = cloneSession.getEntity("PSDETOOLBAR", (Object)pSSysMapItem.getPSDEToolbarId())) != null) {
            this.onFillParentInfo_PSDEToolbar(pSSysMapItem, (PSDEToolbar)iEntity);
        }
        if (pSSysMapItem.getGroupPSDEUAGroupId() != null && (iEntity = cloneSession.getEntity("PSDEUAGROUP", (Object)pSSysMapItem.getGroupPSDEUAGroupId())) != null) {
            this.onFillParentInfo_GroupPSDEUAGroup(pSSysMapItem, (PSDEUAGroup)iEntity);
        }
        if (pSSysMapItem.getPSDEViewBaseId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSSysMapItem.getPSDEViewBaseId())) != null) {
            this.onFillParentInfo_PSDEViewBase(pSSysMapItem, (PSDEViewBase)iEntity);
        }
        if (pSSysMapItem.getNamePSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSSysMapItem.getNamePSLanResId())) != null) {
            this.onFillParentInfo_NamePSLanRes(pSSysMapItem, (PSLanguageRes)iEntity);
        }
        if (pSSysMapItem.getPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSSysMapItem.getPSSysCssId())) != null) {
            this.onFillParentInfo_PSSysCss(pSSysMapItem, (PSSysCss)iEntity);
        }
        if (pSSysMapItem.getShapePSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSSysMapItem.getShapePSSysCssId())) != null) {
            this.onFillParentInfo_ShapePSSysCss(pSSysMapItem, (PSSysCss)iEntity);
        }
        if (pSSysMapItem.getPSSysImageId() != null && (iEntity = cloneSession.getEntity("PSSYSIMAGE", (Object)pSSysMapItem.getPSSysImageId())) != null) {
            this.onFillParentInfo_PSSysImage(pSSysMapItem, (PSSysImage)iEntity);
        }
        if (pSSysMapItem.getPSSysMapViewId() != null && (iEntity = cloneSession.getEntity("PSSYSMAPVIEW", (Object)pSSysMapItem.getPSSysMapViewId())) != null) {
            this.onFillParentInfo_PSSysMapView(pSSysMapItem, (PSSysMapView)iEntity);
        }
        if (pSSysMapItem.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSSysMapItem.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSSysMapItem, (PSSysPFPlugin)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysMapItem pSSysMapItem, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysMapItem, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AltPSDEFId(bl, pSSysMapItem, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AltPSDEFName(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AsyncPSDEDSId(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BKColor(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BKColorPSDEFId(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BKColorPSDEFName(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BorderColor(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BorderWidth(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ClsPSDEFId(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ClsPSDEFName(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Color(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ColorPSDEFId(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ColorPSDEFName(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ContentPSDEFId(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ContentPSDEFName(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCond(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomType(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Data2PSDEFId(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Data2PSDEFName(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DataPSDEFId(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DataPSDEFName(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaClass(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupPSDEFId(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupPSDEFName(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupPSDEUAGroupId(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IconPSDEFId(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IconPSDEFName(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemStyle(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemType(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_KeyPSDEFId(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_KeyPSDEFName(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LatPSDEFId(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LatPSDEFName(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LinkPSDEFId(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LinkPSDEFName(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LongPSDEFId(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LongPSDEFName(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MaxSize(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelObj(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MovePSDEActionId(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MovePSDEOPPrivId(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NamePSLanResId(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NamePSLanResName(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewFilter(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewParam(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValuePSDEFId(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValuePSDEFName(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDSId(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDELogicId(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDERId(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDERName(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEToolbarId(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewBaseId(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCssId(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysImageId(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysMapItemId(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysMapItemName(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysMapViewId(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysMapViewName(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Radius(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RemovePSDEActionId(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RemovePSDEOPPrivId(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ShapeClsPSDEFId(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ShapeClsPSDEFName(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ShapeDynaClass(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ShapePSSysCssId(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Tag2PSDEFId(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Tag2PSDEFName(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TagPSDEFId(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TagPSDEFName(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TextPSDEFId(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TextPSDEFName(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TimePSDEFId(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TimePSDEFName(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TipsPSDEFId(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TipsPSDEFName(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysMapItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysMapItem, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AltPSDEFId(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isAltPSDEFIdDirty() : !pSSysMapItem.isAltPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMapItem.getAltPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AltPSDEFId_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ALTPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AltPSDEFName(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isAltPSDEFNameDirty() : !pSSysMapItem.isAltPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMapItem.getAltPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AltPSDEFName_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ALTPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AsyncPSDEDSId(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isAsyncPSDEDSIdDirty() : !pSSysMapItem.isAsyncPSDEDSIdDirty()) {
            return null;
        }
        String string = pSSysMapItem.getAsyncPSDEDSId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AsyncPSDEDSId_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ASYNCPSDEDSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BKColor(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isBKColorDirty() : !pSSysMapItem.isBKColorDirty()) {
            return null;
        }
        String string = pSSysMapItem.getBKColor();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BKColor_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BKCOLOR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BKColorPSDEFId(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isBKColorPSDEFIdDirty() : !pSSysMapItem.isBKColorPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMapItem.getBKColorPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BKColorPSDEFId_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BKCOLORPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BKColorPSDEFName(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isBKColorPSDEFNameDirty() : !pSSysMapItem.isBKColorPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMapItem.getBKColorPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BKColorPSDEFName_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BKCOLORPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BorderColor(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isBorderColorDirty() : !pSSysMapItem.isBorderColorDirty()) {
            return null;
        }
        String string = pSSysMapItem.getBorderColor();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BorderColor_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BORDERCOLOR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BorderWidth(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isBorderWidthDirty() : !pSSysMapItem.isBorderWidthDirty()) {
            return null;
        }
        Integer n = pSSysMapItem.getBorderWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BorderWidth_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BORDERWIDTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ClsPSDEFId(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isClsPSDEFIdDirty() : !pSSysMapItem.isClsPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMapItem.getClsPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ClsPSDEFId_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CLSPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ClsPSDEFName(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isClsPSDEFNameDirty() : !pSSysMapItem.isClsPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMapItem.getClsPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ClsPSDEFName_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CLSPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Color(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isColorDirty() : !pSSysMapItem.isColorDirty()) {
            return null;
        }
        String string = pSSysMapItem.getColor();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Color_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COLOR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ColorPSDEFId(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isColorPSDEFIdDirty() : !pSSysMapItem.isColorPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMapItem.getColorPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ColorPSDEFId_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COLORPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ColorPSDEFName(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isColorPSDEFNameDirty() : !pSSysMapItem.isColorPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMapItem.getColorPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ColorPSDEFName_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COLORPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ContentPSDEFId(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isContentPSDEFIdDirty() : !pSSysMapItem.isContentPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMapItem.getContentPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ContentPSDEFId_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENTPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ContentPSDEFName(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isContentPSDEFNameDirty() : !pSSysMapItem.isContentPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMapItem.getContentPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ContentPSDEFName_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENTPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomCond(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isCustomCondDirty() : !pSSysMapItem.isCustomCondDirty()) {
            return null;
        }
        String string = pSSysMapItem.getCustomCond();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCond_Default(pSSysMapItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomType(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isCustomTypeDirty() : !pSSysMapItem.isCustomTypeDirty()) {
            return null;
        }
        String string = pSSysMapItem.getCustomType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomType_Default(pSSysMapItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_Data2PSDEFId(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isData2PSDEFIdDirty() : !pSSysMapItem.isData2PSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMapItem.getData2PSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Data2PSDEFId_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATA2PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Data2PSDEFName(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isData2PSDEFNameDirty() : !pSSysMapItem.isData2PSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMapItem.getData2PSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Data2PSDEFName_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATA2PSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DataPSDEFId(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isDataPSDEFIdDirty() : !pSSysMapItem.isDataPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMapItem.getDataPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DataPSDEFId_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATAPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DataPSDEFName(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isDataPSDEFNameDirty() : !pSSysMapItem.isDataPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMapItem.getDataPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DataPSDEFName_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATAPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaClass(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isDynaClassDirty() : !pSSysMapItem.isDynaClassDirty()) {
            return null;
        }
        String string = pSSysMapItem.getDynaClass();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DynaClass_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNACLASS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupPSDEFId(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isGroupPSDEFIdDirty() : !pSSysMapItem.isGroupPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMapItem.getGroupPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupPSDEFId_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupPSDEFName(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isGroupPSDEFNameDirty() : !pSSysMapItem.isGroupPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMapItem.getGroupPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupPSDEFName_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupPSDEUAGroupId(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isGroupPSDEUAGroupIdDirty() : !pSSysMapItem.isGroupPSDEUAGroupIdDirty()) {
            return null;
        }
        String string = pSSysMapItem.getGroupPSDEUAGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupPSDEUAGroupId_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPPSDEUAGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IconPSDEFId(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isIconPSDEFIdDirty() : !pSSysMapItem.isIconPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMapItem.getIconPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IconPSDEFId_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ICONPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IconPSDEFName(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isIconPSDEFNameDirty() : !pSSysMapItem.isIconPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMapItem.getIconPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IconPSDEFName_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ICONPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemStyle(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isItemStyleDirty() && !bl2 : !pSSysMapItem.isItemStyleDirty()) {
            return null;
        }
        String string = pSSysMapItem.getItemStyle();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMSTYLE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemStyle_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemType(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isItemTypeDirty() && !bl2 : !pSSysMapItem.isItemTypeDirty()) {
            return null;
        }
        String string = pSSysMapItem.getItemType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemType_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMTYPE");
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
                string3 = "PSSYSMAPVIEWID";
                String string4 = this.checkFieldDupRule(this.getPSSysMapItemDEModel(), "ITEMTYPE", string3, pSSysMapItem, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("ITEMTYPE");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_KeyPSDEFId(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isKeyPSDEFIdDirty() : !pSSysMapItem.isKeyPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMapItem.getKeyPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_KeyPSDEFId_Default(pSSysMapItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_KeyPSDEFName(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isKeyPSDEFNameDirty() : !pSSysMapItem.isKeyPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMapItem.getKeyPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_KeyPSDEFName_Default(pSSysMapItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_LatPSDEFId(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isLatPSDEFIdDirty() : !pSSysMapItem.isLatPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMapItem.getLatPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LatPSDEFId_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LATPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LatPSDEFName(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isLatPSDEFNameDirty() : !pSSysMapItem.isLatPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMapItem.getLatPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LatPSDEFName_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LATPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LinkPSDEFId(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isLinkPSDEFIdDirty() : !pSSysMapItem.isLinkPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMapItem.getLinkPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LinkPSDEFId_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LINKPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LinkPSDEFName(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isLinkPSDEFNameDirty() : !pSSysMapItem.isLinkPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMapItem.getLinkPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LinkPSDEFName_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LINKPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LongPSDEFId(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isLongPSDEFIdDirty() : !pSSysMapItem.isLongPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMapItem.getLongPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LongPSDEFId_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LONGPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LongPSDEFName(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isLongPSDEFNameDirty() : !pSSysMapItem.isLongPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMapItem.getLongPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LongPSDEFName_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LONGPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MaxSize(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isMaxSizeDirty() : !pSSysMapItem.isMaxSizeDirty()) {
            return null;
        }
        Integer n = pSSysMapItem.getMaxSize();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MaxSize_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAXSIZE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isMemoDirty() : !pSSysMapItem.isMemoDirty()) {
            return null;
        }
        String string = pSSysMapItem.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysMapItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_ModelObj(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isModelObjDirty() : !pSSysMapItem.isModelObjDirty()) {
            return null;
        }
        String string = pSSysMapItem.getModelObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModelObj_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODELOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MovePSDEActionId(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isMovePSDEActionIdDirty() : !pSSysMapItem.isMovePSDEActionIdDirty()) {
            return null;
        }
        String string = pSSysMapItem.getMovePSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MovePSDEActionId_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MOVEPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MovePSDEOPPrivId(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isMovePSDEOPPrivIdDirty() : !pSSysMapItem.isMovePSDEOPPrivIdDirty()) {
            return null;
        }
        String string = pSSysMapItem.getMovePSDEOPPrivId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MovePSDEOPPrivId_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MOVEPSDEOPPRIVID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NamePSLanResId(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isNamePSLanResIdDirty() : !pSSysMapItem.isNamePSLanResIdDirty()) {
            return null;
        }
        String string = pSSysMapItem.getNamePSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NamePSLanResId_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAMEPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NamePSLanResName(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isNamePSLanResNameDirty() : !pSSysMapItem.isNamePSLanResNameDirty()) {
            return null;
        }
        String string = pSSysMapItem.getNamePSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NamePSLanResName_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAMEPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavViewFilter(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isNavViewFilterDirty() : !pSSysMapItem.isNavViewFilterDirty()) {
            return null;
        }
        String string = pSSysMapItem.getNavViewFilter();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NavViewFilter_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVVIEWFILTER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavViewParam(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isNavViewParamDirty() : !pSSysMapItem.isNavViewParamDirty()) {
            return null;
        }
        String string = pSSysMapItem.getNavViewParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NavViewParam_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVVIEWPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isOrderValueDirty() : !pSSysMapItem.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysMapItem.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSSysMapItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValuePSDEFId(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isOrderValuePSDEFIdDirty() : !pSSysMapItem.isOrderValuePSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMapItem.getOrderValuePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OrderValuePSDEFId_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValuePSDEFName(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isOrderValuePSDEFNameDirty() : !pSSysMapItem.isOrderValuePSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMapItem.getOrderValuePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OrderValuePSDEFName_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUEPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDSId(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isPSDEDSIdDirty() : !pSSysMapItem.isPSDEDSIdDirty()) {
            return null;
        }
        String string = pSSysMapItem.getPSDEDSId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDSId_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isPSDEIdDirty() : !pSSysMapItem.isPSDEIdDirty()) {
            return null;
        }
        String string = pSSysMapItem.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSSysMapItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDELogicId(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isPSDELogicIdDirty() : !pSSysMapItem.isPSDELogicIdDirty()) {
            return null;
        }
        String string = pSSysMapItem.getPSDELogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDELogicId_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isPSDENameDirty() : !pSSysMapItem.isPSDENameDirty()) {
            return null;
        }
        String string = pSSysMapItem.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSSysMapItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDERId(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isPSDERIdDirty() : !pSSysMapItem.isPSDERIdDirty()) {
            return null;
        }
        String string = pSSysMapItem.getPSDERId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDERId_Default(pSSysMapItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDERName(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isPSDERNameDirty() : !pSSysMapItem.isPSDERNameDirty()) {
            return null;
        }
        String string = pSSysMapItem.getPSDERName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDERName_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEToolbarId(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isPSDEToolbarIdDirty() : !pSSysMapItem.isPSDEToolbarIdDirty()) {
            return null;
        }
        String string = pSSysMapItem.getPSDEToolbarId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEToolbarId_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETOOLBARID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEViewBaseId(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isPSDEViewBaseIdDirty() : !pSSysMapItem.isPSDEViewBaseIdDirty()) {
            return null;
        }
        String string = pSSysMapItem.getPSDEViewBaseId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewBaseId_Default(pSSysMapItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysCssId(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isPSSysCssIdDirty() : !pSSysMapItem.isPSSysCssIdDirty()) {
            return null;
        }
        String string = pSSysMapItem.getPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCssId_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCSSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysImageId(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isPSSysImageIdDirty() : !pSSysMapItem.isPSSysImageIdDirty()) {
            return null;
        }
        String string = pSSysMapItem.getPSSysImageId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysImageId_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSIMAGEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysMapItemId(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isPSSysMapItemIdDirty() && !bl2 : !pSSysMapItem.isPSSysMapItemIdDirty()) {
            return null;
        }
        String string = pSSysMapItem.getPSSysMapItemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMAPITEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysMapItemId_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMAPITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysMapItemName(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isPSSysMapItemNameDirty() && !bl2 : !pSSysMapItem.isPSSysMapItemNameDirty()) {
            return null;
        }
        String string = pSSysMapItem.getPSSysMapItemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMAPITEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysMapItemName_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMAPITEMNAME");
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
                string3 = "PSSYSMAPVIEWID";
                String string4 = this.checkFieldDupRule(this.getPSSysMapItemDEModel(), "PSSYSMAPITEMNAME", string3, pSSysMapItem, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSMAPITEMNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysMapViewId(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isPSSysMapViewIdDirty() : !pSSysMapItem.isPSSysMapViewIdDirty()) {
            return null;
        }
        String string = pSSysMapItem.getPSSysMapViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysMapViewId_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMAPVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysMapViewName(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isPSSysMapViewNameDirty() : !pSSysMapItem.isPSSysMapViewNameDirty()) {
            return null;
        }
        String string = pSSysMapItem.getPSSysMapViewName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysMapViewName_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMAPVIEWNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isPSSysPFPluginIdDirty() : !pSSysMapItem.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSSysMapItem.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default(pSSysMapItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_Radius(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isRadiusDirty() : !pSSysMapItem.isRadiusDirty()) {
            return null;
        }
        Integer n = pSSysMapItem.getRadius();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Radius_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RADIUS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RemovePSDEActionId(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isRemovePSDEActionIdDirty() : !pSSysMapItem.isRemovePSDEActionIdDirty()) {
            return null;
        }
        String string = pSSysMapItem.getRemovePSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RemovePSDEActionId_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REMOVEPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RemovePSDEOPPrivId(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isRemovePSDEOPPrivIdDirty() : !pSSysMapItem.isRemovePSDEOPPrivIdDirty()) {
            return null;
        }
        String string = pSSysMapItem.getRemovePSDEOPPrivId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RemovePSDEOPPrivId_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REMOVEPSDEOPPRIVID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ShapeClsPSDEFId(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isShapeClsPSDEFIdDirty() : !pSSysMapItem.isShapeClsPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMapItem.getShapeClsPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ShapeClsPSDEFId_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SHAPECLSPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ShapeClsPSDEFName(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isShapeClsPSDEFNameDirty() : !pSSysMapItem.isShapeClsPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMapItem.getShapeClsPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ShapeClsPSDEFName_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SHAPECLSPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ShapeDynaClass(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isShapeDynaClassDirty() : !pSSysMapItem.isShapeDynaClassDirty()) {
            return null;
        }
        String string = pSSysMapItem.getShapeDynaClass();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ShapeDynaClass_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SHAPEDYNACLASS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ShapePSSysCssId(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isShapePSSysCssIdDirty() : !pSSysMapItem.isShapePSSysCssIdDirty()) {
            return null;
        }
        String string = pSSysMapItem.getShapePSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ShapePSSysCssId_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SHAPEPSSYSCSSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Tag2PSDEFId(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isTag2PSDEFIdDirty() : !pSSysMapItem.isTag2PSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMapItem.getTag2PSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Tag2PSDEFId_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TAG2PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Tag2PSDEFName(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isTag2PSDEFNameDirty() : !pSSysMapItem.isTag2PSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMapItem.getTag2PSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Tag2PSDEFName_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TAG2PSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TagPSDEFId(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isTagPSDEFIdDirty() : !pSSysMapItem.isTagPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMapItem.getTagPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TagPSDEFId_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TAGPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TagPSDEFName(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isTagPSDEFNameDirty() : !pSSysMapItem.isTagPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMapItem.getTagPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TagPSDEFName_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TAGPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TextPSDEFId(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isTextPSDEFIdDirty() : !pSSysMapItem.isTextPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMapItem.getTextPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TextPSDEFId_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEXTPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TextPSDEFName(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isTextPSDEFNameDirty() : !pSSysMapItem.isTextPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMapItem.getTextPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TextPSDEFName_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEXTPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TimePSDEFId(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isTimePSDEFIdDirty() : !pSSysMapItem.isTimePSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMapItem.getTimePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TimePSDEFId_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TIMEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TimePSDEFName(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isTimePSDEFNameDirty() : !pSSysMapItem.isTimePSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMapItem.getTimePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TimePSDEFName_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TIMEPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TipsPSDEFId(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isTipsPSDEFIdDirty() : !pSSysMapItem.isTipsPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysMapItem.getTipsPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TipsPSDEFId_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TIPSPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TipsPSDEFName(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isTipsPSDEFNameDirty() : !pSSysMapItem.isTipsPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysMapItem.getTipsPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TipsPSDEFName_Default(pSSysMapItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TIPSPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isUserCatDirty() : !pSSysMapItem.isUserCatDirty()) {
            return null;
        }
        String string = pSSysMapItem.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysMapItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isUserTagDirty() : !pSSysMapItem.isUserTagDirty()) {
            return null;
        }
        String string = pSSysMapItem.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysMapItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isUserTag2Dirty() : !pSSysMapItem.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysMapItem.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysMapItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isUserTag3Dirty() : !pSSysMapItem.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysMapItem.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysMapItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isUserTag4Dirty() : !pSSysMapItem.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysMapItem.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysMapItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysMapItem pSSysMapItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysMapItem.isValidFlagDirty() && !bl2 : !pSSysMapItem.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysMapItem.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSysMapItem, bl2, bl3);
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

    protected void onSyncEntity(PSSysMapItem pSSysMapItem, boolean bl) throws Exception {
        super.onSyncEntity(pSSysMapItem, bl);
    }

    protected void onSyncIndexEntities(PSSysMapItem pSSysMapItem, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysMapItem, bl);
    }

    public Object getDataContextValue(PSSysMapItem pSSysMapItem, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysMapItem, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysMapView pSSysMapView = pSSysMapItem.getPSSysMapView();
        if (pSSysMapView != null && pSSysMapView.contains(string)) {
            return pSSysMapView.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysMapItem pSSysMapItem, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysMapItem, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ALTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AltPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ALTPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AltPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ASYNCPSDEDSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AsyncPSDEDSId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ASYNCPSDEDSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AsyncPSDEDSName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BKCOLOR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BKColor_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BKCOLORPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BKColorPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BKCOLORPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BKColorPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BORDERCOLOR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BorderColor_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BORDERWIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BorderWidth_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CLSPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ClsPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CLSPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ClsPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COLOR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Color_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COLORPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ColorPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COLORPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ColorPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ContentPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENTPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ContentPSDEFName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"DATA2PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Data2PSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATA2PSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Data2PSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATAPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DataPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATAPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DataPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNACLASS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaClass_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPPSDEUAGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupPSDEUAGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPPSDEUAGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupPSDEUAGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ICONPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IconPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ICONPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IconPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMSTYLETEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemStyleText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"KEYPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_KeyPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"KEYPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_KeyPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LATPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LatPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LATPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LatPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LINKPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LinkPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LINKPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LinkPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LONGPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LongPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LONGPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LongPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAXSIZE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MaxSize_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOVEPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MovePSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOVEPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MovePSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOVEPSDEOPPRIVID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MovePSDEOPPrivId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOVEPSDEOPPRIVNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MovePSDEOPPrivName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAMEPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NamePSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAMEPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NamePSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVVIEWFILTER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavViewFilter_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVVIEWPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavViewParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValuePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValuePSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDSId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDSName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDELOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDELogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDELOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDELogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETOOLBARID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEToolbarId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETOOLBARNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEToolbarName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWBASEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewBaseId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWBASENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewBaseName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCSSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCssId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCSSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCssName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSIMAGEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysImageId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSIMAGENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysImageName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMAPITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysMapItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMAPITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysMapItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMAPVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysMapViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMAPVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysMapViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RADIUS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Radius_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REMOVEPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RemovePSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REMOVEPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RemovePSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REMOVEPSDEOPPRIVID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RemovePSDEOPPrivId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REMOVEPSDEOPPRIVNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RemovePSDEOPPrivName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SHAPECLSPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ShapeClsPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SHAPECLSPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ShapeClsPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SHAPEDYNACLASS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ShapeDynaClass_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SHAPEPSSYSCSSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ShapePSSysCssId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SHAPEPSSYSCSSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ShapePSSysCssName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TAG2PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Tag2PSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TAG2PSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Tag2PSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TAGPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TagPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TAGPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TagPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEXTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TextPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEXTPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TextPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIMEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TimePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIMEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TimePSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIPSPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TipsPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIPSPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TipsPSDEFName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_AltPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ALTPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AltPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ALTPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AsyncPSDEDSId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ASYNCPSDEDSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AsyncPSDEDSName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ASYNCPSDEDSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BKColor_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BKCOLOR", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BKColorPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BKCOLORPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BKColorPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BKCOLORPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BorderColor_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BORDERCOLOR", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BorderWidth_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ClsPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CLSPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ClsPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CLSPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Color_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("COLOR", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ColorPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("COLORPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ColorPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("COLORPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ContentPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENTPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ContentPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENTPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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
            if (this.checkFieldStringLengthRule("CUSTOMCOND", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
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

    protected String onTestValueRule_Data2PSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATA2PSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Data2PSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATA2PSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DataPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATAPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DataPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATAPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DynaClass_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DYNACLASS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupPSDEUAGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPPSDEUAGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupPSDEUAGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPPSDEUAGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IconPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ICONPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IconPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ICONPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ItemStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMSTYLE", iEntity, bl2, null, false, 16, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[16]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[16]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ItemStyleText_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMSTYLETEXT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ItemType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMTYPE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false) && this.checkFieldRegExRule("ITEMTYPE", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_LatPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LATPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LatPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LATPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LinkPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LINKPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LinkPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LINKPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LongPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LONGPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LongPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LONGPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MaxSize_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_ModelObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODELOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MovePSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOVEPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MovePSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOVEPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MovePSDEOPPrivId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOVEPSDEOPPRIVID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MovePSDEOPPrivName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOVEPSDEOPPRIVNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NamePSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NAMEPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NamePSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NAMEPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NavViewFilter_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NAVVIEWFILTER", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NavViewParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NAVVIEWPARAM", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_OrderValuePSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ORDERVALUEPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValuePSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ORDERVALUEPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDSId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDSName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDELogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDELOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDELogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDELOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSDEToolbarId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDETOOLBARID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEToolbarName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDETOOLBARNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_PSSysCssId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCSSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysCssName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCSSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysImageId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSIMAGEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysImageName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSIMAGENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysMapItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMAPITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysMapItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMAPITEMNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysMapViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMAPVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysMapViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMAPVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_Radius_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_RemovePSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REMOVEPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RemovePSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REMOVEPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RemovePSDEOPPrivId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REMOVEPSDEOPPRIVID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RemovePSDEOPPrivName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REMOVEPSDEOPPRIVNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ShapeClsPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SHAPECLSPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ShapeClsPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SHAPECLSPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ShapeDynaClass_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SHAPEDYNACLASS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ShapePSSysCssId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SHAPEPSSYSCSSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ShapePSSysCssName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SHAPEPSSYSCSSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Tag2PSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TAG2PSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Tag2PSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TAG2PSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TagPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TAGPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TagPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TAGPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TextPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEXTPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TextPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEXTPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TimePSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TIMEPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TimePSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TIMEPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TipsPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TIPSPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TipsPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TIPSPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSysMapItem pSSysMapItem) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysMapItem)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysMapItem pSSysMapItem) throws Exception {
        super.onUpdateParent(pSSysMapItem);
    }

    @Override
    protected void exportCurXmlModel(PSSysMapItem pSSysMapItem, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSMAPITEM");
        if (!bl) {
            pSSysMapItem.setCreateDate(null);
            pSSysMapItem.setCreateMan(null);
            pSSysMapItem.setPSSysMapItemId(null);
            pSSysMapItem.setRemovePSDEOPPrivName(null);
            pSSysMapItem.setUpdateDate(null);
            pSSysMapItem.setUpdateMan(null);
            pSSysMapItem.setPSSysMapViewId(null);
            pSSysMapItem.setPSSysMapViewName(null);
            super.exportCurXmlModel(pSSysMapItem, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSSysMapItem pSSysMapItem, XmlNode xmlNode) throws Exception {
        super.onExportRelatedXmlModel(pSSysMapItem, xmlNode);
    }

    @Override
    protected void onImportRelatedXmlModel(PSSysMapItem pSSysMapItem, XmlNode xmlNode) throws Exception {
        super.onImportRelatedXmlModel(pSSysMapItem, xmlNode);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysMapItem pSSysMapItem, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysMapItem, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSMAPVIEWID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSMAPVIEW#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSMAPVIEWID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSMAPITEM_PSSYSMAPVIEW_PSSYSMAPVIEWID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSMAPVIEWID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSMAPVIEWNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSMAPVIEW", (boolean)true) == 0) {
            iEntity.set("PSSYSMAPVIEWID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSMAPVIEWID"};
    }

    @Override
    public String getModelV2Tag(PSSysMapItem pSSysMapItem) {
        if (!StringHelper.isNullOrEmpty((String)pSSysMapItem.getPSSysMapItemName())) {
            return pSSysMapItem.getPSSysMapItemName();
        }
        return super.getModelV2Tag(pSSysMapItem);
    }

    @Override
    public boolean setModelV2Tag(PSSysMapItem pSSysMapItem, String string) {
        pSSysMapItem.setPSSysMapItemName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSMAPITEMNAME", "");
        map.put("PSSYSMAPVIEWID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysMapItem pSSysMapItem, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysMapItem.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysMapItem, true);
        pSSysMapItem.set("PSSYSMAPITEMNAME", string);
        if (this.select(pSSysMapItem, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysMapItem, true);
        return super.getModelV2Entity(pSSysMapItem, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysMapItem pSSysMapItem, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysMapItem, objectNode, string, string2, n);
    }
}

