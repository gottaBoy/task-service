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
 *  net.ibizsys.paas.db.ISelectContext
 *  net.ibizsys.paas.db.ISelectField
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.db.SelectContext
 *  net.ibizsys.paas.db.SelectField
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
 *  net.ibizsys.paas.service.SessionFactoryManager
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
import net.ibizsys.paas.db.ISelectContext;
import net.ibizsys.paas.db.ISelectField;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.db.SelectField;
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
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppDERSService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppDERSServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppLocalDEService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppLocalDEServiceBase;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableDERService;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableDERServiceBase;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableRSService;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableRSServiceBase;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableService;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableServiceBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeMSJoinService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeMSJoinServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDERDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDERDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEACMode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEACModeBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroupBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPrivBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDERBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDERDEFMap;
import net.ibizsys.pscore.srv.dedesign.entity.PSDERDEFMapBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartParamService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartParamServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDQJoinService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDQJoinServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRItemServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFSFItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFSFItemServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFUIModeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFUIModeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridColServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEModelService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEModelServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDERDEFMapService;
import net.ibizsys.pscore.srv.dedesign.service.PSDERDEFMapServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeRSService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeRSServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseServiceBase;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIDERService;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIDERServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBColumn;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDERGroupDetailService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDERGroupDetailServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDESARSService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDESARSServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBColumnService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapItemServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSMOSFileUtil;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDERServiceBase
extends PSCoreSysServiceBase<PSDER> {
    private static final Log log = LogFactory.getLog(PSDERServiceBase.class);
    public static final String DATASET_CURDEDER11 = "CurDEDER11";
    public static final String DATASET_CURDEDER11_CUSTOM = "CurDEDER11_Custom";
    public static final String DATASET_CURDEDER1N = "CurDEDER1N";
    public static final String DATASET_CURDEDER1N2 = "CurDEDER1N2";
    public static final String DATASET_CURDEDER1N_CUSTOM = "CurDEDER1N_Custom";
    public static final String DATASET_CURDEDERCUSTOM = "CurDEDERCustom";
    public static final String DATASET_CURDEMAJOR = "CurDEMajor";
    public static final String DATASET_CURDEMAJOR2 = "CurDEMajor2";
    public static final String DATASET_CURDEMAJORAGGDATA = "CurDEMajorAggData";
    public static final String DATASET_CURDEMINOR = "CurDEMinor";
    public static final String DATASET_CURDEMINOR2 = "CurDEMinor2";
    public static final String DATASET_CURSYSDER = "CurSysDER";
    public static final String DATASET_CURSYSDER1N = "CurSysDER1N";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_FORMTYPE = "FormType";
    public static final String DATASET_MAJORMINORDER1N = "MajorMinorDER1N";
    public static final String DATASET_X1N = "X1N";
    public static final String ACTION_CREATEDEOPPRIV = "CreateDEOPPriv";
    public static final String ACTION_CREATEDEFAULTVR = "CreateDefaultVR";
    public static final String ACTION_CREATEPICKUPTEXTFIELD = "CreatePickupTextField";
    private PSDERDEModel pSDERDEModel;
    private PSDERDAO pSDERDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDERService";
    }

    public PSDERDEModel getPSDERDEModel() {
        if (this.pSDERDEModel == null) {
            try {
                this.pSDERDEModel = (PSDERDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDERDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDERDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDERDEModel();
    }

    public PSDERDAO getPSDERDAO() {
        if (this.pSDERDAO == null) {
            try {
                this.pSDERDAO = (PSDERDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDERDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDERDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDERDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDEDER11, (boolean)true) == 0) {
            return this.fetchCurDEDER11(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDEDER11_CUSTOM, (boolean)true) == 0) {
            return this.fetchCurDEDER11_Custom(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDEDER1N, (boolean)true) == 0) {
            return this.fetchCurDEDER1N(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDEDER1N2, (boolean)true) == 0) {
            return this.fetchCurDEDER1N2(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDEDER1N_CUSTOM, (boolean)true) == 0) {
            return this.fetchCurDEDER1N_Custom(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDEDERCUSTOM, (boolean)true) == 0) {
            return this.fetchCurDEDERCustom(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDEMAJOR, (boolean)true) == 0) {
            return this.fetchCurDEMajor(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDEMAJOR2, (boolean)true) == 0) {
            return this.fetchCurDEMajor2(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDEMAJORAGGDATA, (boolean)true) == 0) {
            return this.fetchCurDEMajorAggData(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDEMINOR, (boolean)true) == 0) {
            return this.fetchCurDEMinor(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDEMINOR2, (boolean)true) == 0) {
            return this.fetchCurDEMinor2(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSDER, (boolean)true) == 0) {
            return this.fetchCurSysDER(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSDER1N, (boolean)true) == 0) {
            return this.fetchCurSysDER1N(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_FORMTYPE, (boolean)true) == 0) {
            return this.fetchFormType(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_MAJORMINORDER1N, (boolean)true) == 0) {
            return this.fetchMajorMinorDER1N(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_X1N, (boolean)true) == 0) {
            return this.fetchX1N(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_CREATEDEOPPRIV, (boolean)true) == 0) {
            this.createDEOPPriv((PSDER)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_CREATEDEFAULTVR, (boolean)true) == 0) {
            this.createDefaultVR((PSDER)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_CREATEPICKUPTEXTFIELD, (boolean)true) == 0) {
            this.createPickupTextField((PSDER)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurDEDER11(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEDER11, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDEDER11_Custom(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEDER11_CUSTOM, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDEDER1N(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEDER1N, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDEDER1N2(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEDER1N2, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDEDER1N_Custom(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEDER1N_CUSTOM, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDEDERCustom(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEDERCUSTOM, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDEMajor(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEMAJOR, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDEMajor2(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEMAJOR2, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDEMajorAggData(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEMAJORAGGDATA, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDEMinor(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEMINOR, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDEMinor2(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEMINOR2, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysDER(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSDER, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysDER1N(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSDER1N, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchFormType(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_FORMTYPE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchMajorMinorDER1N(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_MAJORMINORDER1N, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchX1N(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_X1N, false);
        return dBFetchResult;
    }

    public void createDEOPPriv(PSDER pSDER) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CREATEDEOPPRIV, 0, (IEntity)pSDER, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDER, ACTION_CREATEDEOPPRIV);
        final PSDER pSDER2 = pSDER;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDERServiceBase.this.getService(), PSDERServiceBase.ACTION_CREATEDEOPPRIV, 40, (IEntity)pSDER2, null).getResult() != 1) {
                    PSDERServiceBase.this.onCreateDEOPPriv(pSDER2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CREATEDEOPPRIV, 99, (IEntity)pSDER, null);
        }
    }

    protected void onCreateDEOPPriv(PSDER pSDER) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CreateDEOPPriv]");
    }

    public void createDefaultVR(PSDER pSDER) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CREATEDEFAULTVR, 0, (IEntity)pSDER, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDER, ACTION_CREATEDEFAULTVR);
        final PSDER pSDER2 = pSDER;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDERServiceBase.this.getService(), PSDERServiceBase.ACTION_CREATEDEFAULTVR, 40, (IEntity)pSDER2, null).getResult() != 1) {
                    PSDERServiceBase.this.onCreateDefaultVR(pSDER2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CREATEDEFAULTVR, 99, (IEntity)pSDER, null);
        }
    }

    protected void onCreateDefaultVR(PSDER pSDER) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CreateDefaultVR]");
    }

    public void createPickupTextField(PSDER pSDER) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CREATEPICKUPTEXTFIELD, 0, (IEntity)pSDER, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDER, ACTION_CREATEPICKUPTEXTFIELD);
        final PSDER pSDER2 = pSDER;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDERServiceBase.this.getService(), PSDERServiceBase.ACTION_CREATEPICKUPTEXTFIELD, 40, (IEntity)pSDER2, null).getResult() != 1) {
                    PSDERServiceBase.this.onCreatePickupTextField(pSDER2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CREATEPICKUPTEXTFIELD, 99, (IEntity)pSDER, null);
        }
    }

    protected void onCreatePickupTextField(PSDER pSDER) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CreatePickupTextField]");
    }

    protected void onFillParentInfo(PSDER pSDER, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDER_PSDATAENTITY_MAJORPSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_MajorPSDE(pSDER, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDER_PSDATAENTITY_MINORPSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_MinorPSDE(pSDER, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDER_PSDEACMODE_PSDEACMODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEACModeService", (SessionFactory)this.getSessionFactory());
            PSDEACMode pSDEACMode = (PSDEACMode)iService.getDEModel().createEntity();
            pSDEACMode.set("PSDEACMODEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEACMode);
            } else {
                iService.get((IEntity)pSDEACMode);
            }
            this.onFillParentInfo_PSDEACMode(pSDER, pSDEACMode);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDER_PSDEDATASET_MINORPSDEDSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataSet);
            } else {
                iService.get((IEntity)pSDEDataSet);
            }
            this.onFillParentInfo_MinorPSDEDS(pSDER, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDER_PSDEDATASET_PSDEDATASETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataSet);
            } else {
                iService.get((IEntity)pSDEDataSet);
            }
            this.onFillParentInfo_PSDEDataSet(pSDER, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDER_PSDEFGROUP_PSDEFGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupService", (SessionFactory)this.getSessionFactory());
            PSDEFGroup pSDEFGroup = (PSDEFGroup)iService.getDEModel().createEntity();
            pSDEFGroup.set("PSDEFGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEFGroup);
            } else {
                iService.get((IEntity)pSDEFGroup);
            }
            this.onFillParentInfo_PSDEFGroup(pSDER, pSDEFGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDER_PSDEFIELD_CNTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_CntPSDEF(pSDER, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDER_PSDEFIELD_EXTMAJORPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_ExtMajorPSDEF(pSDER, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDER_PSDEFIELD_EXTMINORPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_ExtMinorPSDEF(pSDER, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDER_PSDER_MAJORPSDERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDERService", (SessionFactory)this.getSessionFactory());
            PSDER pSDER2 = (PSDER)iService.getDEModel().createEntity();
            pSDER2.set("PSDERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDER2);
            } else {
                iService.get((IEntity)pSDER2);
            }
            this.onFillParentInfo_MajorPSDER(pSDER, pSDER2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDER_PSDER_MINORPSDERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDERService", (SessionFactory)this.getSessionFactory());
            PSDER pSDER3 = (PSDER)iService.getDEModel().createEntity();
            pSDER3.set("PSDERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDER3);
            } else {
                iService.get((IEntity)pSDER3);
            }
            this.onFillParentInfo_MinorPSDER(pSDER, pSDER3);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDER_PSDEVIEWBASE_LINKPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEViewBase);
            } else {
                iService.get((IEntity)pSDEViewBase);
            }
            this.onFillParentInfo_LinkPSDEView(pSDER, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDER_PSDEVIEWBASE_MDPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEViewBase);
            } else {
                iService.get((IEntity)pSDEViewBase);
            }
            this.onFillParentInfo_MDPSDEView(pSDER, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDER_PSDEVIEWBASE_MOBLINKPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEViewBase);
            } else {
                iService.get((IEntity)pSDEViewBase);
            }
            this.onFillParentInfo_MobLinkPSDEView(pSDER, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDER_PSDEVIEWBASE_MOBMDPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEViewBase);
            } else {
                iService.get((IEntity)pSDEViewBase);
            }
            this.onFillParentInfo_MobMDPSDEView(pSDER, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDER_PSDEVIEWBASE_MOBSDPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEViewBase);
            } else {
                iService.get((IEntity)pSDEViewBase);
            }
            this.onFillParentInfo_MobSDPSDEView(pSDER, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDER_PSDEVIEWBASE_RSPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEViewBase);
            } else {
                iService.get((IEntity)pSDEViewBase);
            }
            this.onFillParentInfo_RSPSDEView(pSDER, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDER_PSDEVIEWBASE_SDPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEViewBase);
            } else {
                iService.get((IEntity)pSDEViewBase);
            }
            this.onFillParentInfo_SDPSDEView(pSDER, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDER_PSLANGUAGERES_REMOVEREJECTPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSLanguageRes);
            } else {
                iService.get((IEntity)pSLanguageRes);
            }
            this.onFillParentInfo_RemoveRejectPSLanRes(pSDER, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDER_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDynaModel);
            } else {
                iService.get((IEntity)pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSDER, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDER_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysSFPlugin);
            } else {
                iService.get((IEntity)pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSDER, pSSysSFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDER_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystem);
            } else {
                iService.get((IEntity)pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSDER, pSSystem);
            return;
        }
        super.onFillParentInfo((IEntity)pSDER, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_MajorPSDE(PSDER pSDER, PSDataEntity pSDataEntity) throws Exception {
        pSDER.setMajorPSDEId(pSDataEntity.getPSDataEntityId());
        pSDER.setMajorPSDEName(pSDataEntity.getPSDataEntityName());
        if (pSDataEntity.getPSSystem() != null) {
            this.onFillParentInfo_PSSystem(pSDER, pSDataEntity.getPSSystem());
        }
    }

    protected void onFillParentInfo_MinorPSDE(PSDER pSDER, PSDataEntity pSDataEntity) throws Exception {
        pSDER.setMinorPSDEId(pSDataEntity.getPSDataEntityId());
        pSDER.setMinorPSDEName(pSDataEntity.getPSDataEntityName());
        if (pSDataEntity.getPSSystem() != null) {
            this.onFillParentInfo_PSSystem(pSDER, pSDataEntity.getPSSystem());
        }
    }

    protected void onFillParentInfo_PSDEACMode(PSDER pSDER, PSDEACMode pSDEACMode) throws Exception {
        pSDER.setPSDEACModeId(pSDEACMode.getPSDEACModeId());
        pSDER.setPSDEACModeName(pSDEACMode.getPSDEACModeName());
    }

    protected void onFillParentInfo_MinorPSDEDS(PSDER pSDER, PSDEDataSet pSDEDataSet) throws Exception {
        pSDER.setMinorPSDEDSId(pSDEDataSet.getPSDEDataSetId());
        pSDER.setMinorPSDEDSName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_PSDEDataSet(PSDER pSDER, PSDEDataSet pSDEDataSet) throws Exception {
        pSDER.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
        pSDER.setPSDEDataSetName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_PSDEFGroup(PSDER pSDER, PSDEFGroup pSDEFGroup) throws Exception {
        pSDER.setPSDEFGroupId(pSDEFGroup.getPSDEFGroupId());
        pSDER.setPSDEFGroupName(pSDEFGroup.getPSDEFGroupName());
    }

    protected void onFillParentInfo_CntPSDEF(PSDER pSDER, PSDEField pSDEField) throws Exception {
        pSDER.setCntPSDEFId(pSDEField.getPSDEFieldId());
        pSDER.setCntPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_ExtMajorPSDEF(PSDER pSDER, PSDEField pSDEField) throws Exception {
        pSDER.setEXTMajorPSDEFId(pSDEField.getPSDEFieldId());
        pSDER.setEXTMajorPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_ExtMinorPSDEF(PSDER pSDER, PSDEField pSDEField) throws Exception {
        pSDER.setEXTMinorPSDEFId(pSDEField.getPSDEFieldId());
        pSDER.setEXTMinorPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_MajorPSDER(PSDER pSDER, PSDER pSDER2) throws Exception {
        pSDER.setMajorPSDERId(pSDER2.getPSDERId());
        pSDER.setMajorPSDERName(pSDER2.getPSDERName());
    }

    protected void onFillParentInfo_MinorPSDER(PSDER pSDER, PSDER pSDER2) throws Exception {
        pSDER.setMinorPSDERId(pSDER2.getPSDERId());
        pSDER.setMinorPSDERName(pSDER2.getPSDERName());
    }

    protected void onFillParentInfo_LinkPSDEView(PSDER pSDER, PSDEViewBase pSDEViewBase) throws Exception {
        pSDER.setLinkPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSDER.setLinkPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_MDPSDEView(PSDER pSDER, PSDEViewBase pSDEViewBase) throws Exception {
        pSDER.setMDPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSDER.setMDPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_MobLinkPSDEView(PSDER pSDER, PSDEViewBase pSDEViewBase) throws Exception {
        pSDER.setMobLinkPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSDER.setMobLinkPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_MobMDPSDEView(PSDER pSDER, PSDEViewBase pSDEViewBase) throws Exception {
        pSDER.setMobMDPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSDER.setMobMDPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_MobSDPSDEView(PSDER pSDER, PSDEViewBase pSDEViewBase) throws Exception {
        pSDER.setMobSDPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSDER.setMobSDPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_RSPSDEView(PSDER pSDER, PSDEViewBase pSDEViewBase) throws Exception {
        pSDER.setRSPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSDER.setRSPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_SDPSDEView(PSDER pSDER, PSDEViewBase pSDEViewBase) throws Exception {
        pSDER.setSDPSDEViewID(pSDEViewBase.getPSDEViewBaseId());
        pSDER.setSDPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_RemoveRejectPSLanRes(PSDER pSDER, PSLanguageRes pSLanguageRes) throws Exception {
        pSDER.setRemoveRejectPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDER.setRemoveRejectPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSDER pSDER, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSDER.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSDER.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSDER pSDER, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSDER.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSDER.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillParentInfo_PSSystem(PSDER pSDER, PSSystem pSSystem) throws Exception {
        pSDER.setPSSystemId(pSSystem.getPSSystemId());
        pSDER.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSDER pSDER, boolean bl) throws Exception {
        if (bl) {
            if (pSDER.getPSDEDRItemsCnt() == null) {
                pSDER.setPSDEDRItemsCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDER.getPSDEFieldsCnt() == null) {
                pSDER.setPSDEFieldsCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDER.getPSDEOPPrivsCnt() == null) {
                pSDER.setPSDEOPPrivsCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDER.getPSDERDEFMapsCnt() == null) {
                pSDER.setPSDERDEFMapsCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDER.getValidFlag() == null) {
                pSDER.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSDER, bl);
        this.onFillEntityFullInfo_MajorPSDE(pSDER, bl);
        this.onFillEntityFullInfo_MinorPSDE(pSDER, bl);
        this.onFillEntityFullInfo_PSDEACMode(pSDER, bl);
        this.onFillEntityFullInfo_MinorPSDEDS(pSDER, bl);
        this.onFillEntityFullInfo_PSDEDataSet(pSDER, bl);
        this.onFillEntityFullInfo_PSDEFGroup(pSDER, bl);
        this.onFillEntityFullInfo_CntPSDEF(pSDER, bl);
        this.onFillEntityFullInfo_ExtMajorPSDEF(pSDER, bl);
        this.onFillEntityFullInfo_ExtMinorPSDEF(pSDER, bl);
        this.onFillEntityFullInfo_MajorPSDER(pSDER, bl);
        this.onFillEntityFullInfo_MinorPSDER(pSDER, bl);
        this.onFillEntityFullInfo_LinkPSDEView(pSDER, bl);
        this.onFillEntityFullInfo_MDPSDEView(pSDER, bl);
        this.onFillEntityFullInfo_MobLinkPSDEView(pSDER, bl);
        this.onFillEntityFullInfo_MobMDPSDEView(pSDER, bl);
        this.onFillEntityFullInfo_MobSDPSDEView(pSDER, bl);
        this.onFillEntityFullInfo_RSPSDEView(pSDER, bl);
        this.onFillEntityFullInfo_SDPSDEView(pSDER, bl);
        this.onFillEntityFullInfo_RemoveRejectPSLanRes(pSDER, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSDER, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSDER, bl);
        this.onFillEntityFullInfo_PSSystem(pSDER, bl);
    }

    protected void onFillEntityFullInfo_MajorPSDE(PSDER pSDER, boolean bl) throws Exception {
        if (pSDER.isMajorPSDEIdDirty()) {
            if (pSDER.getMajorPSDEId() != null) {
                PSDataEntity pSDataEntity;
                if (pSDER.getMajorPSDEId() == null || pSDER.getMajorPSDEName() == null) {
                    pSDataEntity = pSDER.getMajorPSDE();
                    pSDER.setMajorPSDEName(pSDataEntity.getPSDataEntityName());
                }
                if (DataTypeHelper.compare((int)25, (Object)(pSDataEntity = pSDER.getMajorPSDE()).getPSSystemId(), (Object)pSDER.getPSSystemId()) != 0L) {
                    pSDER.setPSSystemId(pSDataEntity.getPSSystemId());
                    this.onFillEntityFullInfo_PSSystem(pSDER, bl);
                }
            } else {
                pSDER.setMajorPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_MinorPSDE(PSDER pSDER, boolean bl) throws Exception {
        if (pSDER.isMinorPSDEIdDirty()) {
            if (pSDER.getMinorPSDEId() != null) {
                PSDataEntity pSDataEntity;
                if (pSDER.getMinorPSDEId() == null || pSDER.getMinorPSDEName() == null) {
                    pSDataEntity = pSDER.getMinorPSDE();
                    pSDER.setMinorPSDEName(pSDataEntity.getPSDataEntityName());
                }
                if (DataTypeHelper.compare((int)25, (Object)(pSDataEntity = pSDER.getMinorPSDE()).getPSSystemId(), (Object)pSDER.getPSSystemId()) != 0L) {
                    pSDER.setPSSystemId(pSDataEntity.getPSSystemId());
                    this.onFillEntityFullInfo_PSSystem(pSDER, bl);
                }
            } else {
                pSDER.setMinorPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEACMode(PSDER pSDER, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MinorPSDEDS(PSDER pSDER, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEDataSet(PSDER pSDER, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEFGroup(PSDER pSDER, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_CntPSDEF(PSDER pSDER, boolean bl) throws Exception {
        if (pSDER.isCntPSDEFIdDirty()) {
            if (pSDER.getCntPSDEFId() != null) {
                if (pSDER.getCntPSDEFId() == null || pSDER.getCntPSDEFName() == null) {
                    PSDEField pSDEField = pSDER.getCntPSDEF();
                    pSDER.setCntPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDER.setCntPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_ExtMajorPSDEF(PSDER pSDER, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_ExtMinorPSDEF(PSDER pSDER, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MajorPSDER(PSDER pSDER, boolean bl) throws Exception {
        if (pSDER.isMajorPSDERIdDirty()) {
            if (pSDER.getMajorPSDERId() != null) {
                if (pSDER.getMajorPSDERId() == null || pSDER.getMajorPSDERName() == null) {
                    PSDER pSDER2 = pSDER.getMajorPSDER();
                    pSDER.setMajorPSDERName(pSDER2.getPSDERName());
                }
            } else {
                pSDER.setMajorPSDERName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_MinorPSDER(PSDER pSDER, boolean bl) throws Exception {
        if (pSDER.isMinorPSDERIdDirty()) {
            if (pSDER.getMinorPSDERId() != null) {
                if (pSDER.getMinorPSDERId() == null || pSDER.getMinorPSDERName() == null) {
                    PSDER pSDER2 = pSDER.getMinorPSDER();
                    pSDER.setMinorPSDERName(pSDER2.getPSDERName());
                }
            } else {
                pSDER.setMinorPSDERName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_LinkPSDEView(PSDER pSDER, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MDPSDEView(PSDER pSDER, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MobLinkPSDEView(PSDER pSDER, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MobMDPSDEView(PSDER pSDER, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MobSDPSDEView(PSDER pSDER, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RSPSDEView(PSDER pSDER, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_SDPSDEView(PSDER pSDER, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RemoveRejectPSLanRes(PSDER pSDER, boolean bl) throws Exception {
        if (pSDER.isRemoveRejectPSLanResIdDirty()) {
            if (pSDER.getRemoveRejectPSLanResId() != null) {
                if (pSDER.getRemoveRejectPSLanResId() == null || pSDER.getRemoveRejectPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDER.getRemoveRejectPSLanRes();
                    pSDER.setRemoveRejectPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDER.setRemoveRejectPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSDER pSDER, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSDER pSDER, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSDER pSDER, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDER pSDER, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDER, bl);
    }

    public ArrayList<PSDER> selectByMajorPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByMajorPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDER> selectByMajorPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByMajorPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDER> selectByMajorPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MAJORPSDEID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMajorPSDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMajorPSDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDER> selectByMinorPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByMinorPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDER> selectByMinorPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByMinorPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDER> selectByMinorPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MINORPSDEID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMinorPSDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMinorPSDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDER> selectByPSDEACMode(PSDEACModeBase pSDEACModeBase) throws Exception {
        return this.selectByPSDEACMode(pSDEACModeBase, "", -1);
    }

    public ArrayList<PSDER> selectByPSDEACMode(PSDEACModeBase pSDEACModeBase, String string) throws Exception {
        return this.selectByPSDEACMode(pSDEACModeBase, string, -1);
    }

    public ArrayList<PSDER> selectByPSDEACMode(PSDEACModeBase pSDEACModeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEACMODEID", (Object)pSDEACModeBase.getPSDEACModeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEACModeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEACModeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDER> selectByMinorPSDEDS(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByMinorPSDEDS(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSDER> selectByMinorPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByMinorPSDEDS(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSDER> selectByMinorPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MINORPSDEDSID", (Object)pSDEDataSetBase.getPSDEDataSetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMinorPSDEDSCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMinorPSDEDSCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDER> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByPSDEDataSet(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSDER> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByPSDEDataSet(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSDER> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
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

    public ArrayList<PSDER> selectByPSDEFGroup(PSDEFGroupBase pSDEFGroupBase) throws Exception {
        return this.selectByPSDEFGroup(pSDEFGroupBase, "", -1);
    }

    public ArrayList<PSDER> selectByPSDEFGroup(PSDEFGroupBase pSDEFGroupBase, String string) throws Exception {
        return this.selectByPSDEFGroup(pSDEFGroupBase, string, -1);
    }

    public ArrayList<PSDER> selectByPSDEFGroup(PSDEFGroupBase pSDEFGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFGROUPID", (Object)pSDEFGroupBase.getPSDEFGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDER> selectByCntPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByCntPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDER> selectByCntPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByCntPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDER> selectByCntPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CNTPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByCntPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByCntPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDER> selectByExtMajorPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByExtMajorPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDER> selectByExtMajorPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByExtMajorPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDER> selectByExtMajorPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("EXTMAJORPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByExtMajorPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByExtMajorPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDER> selectByExtMinorPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByExtMinorPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDER> selectByExtMinorPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByExtMinorPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDER> selectByExtMinorPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("EXTMINORPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByExtMinorPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByExtMinorPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDER> selectByMajorPSDER(PSDERBase pSDERBase) throws Exception {
        return this.selectByMajorPSDER(pSDERBase, "", -1);
    }

    public ArrayList<PSDER> selectByMajorPSDER(PSDERBase pSDERBase, String string) throws Exception {
        return this.selectByMajorPSDER(pSDERBase, string, -1);
    }

    public ArrayList<PSDER> selectByMajorPSDER(PSDERBase pSDERBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MAJORPSDERID", (Object)pSDERBase.getPSDERId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMajorPSDERCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMajorPSDERCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDER> selectByMinorPSDER(PSDERBase pSDERBase) throws Exception {
        return this.selectByMinorPSDER(pSDERBase, "", -1);
    }

    public ArrayList<PSDER> selectByMinorPSDER(PSDERBase pSDERBase, String string) throws Exception {
        return this.selectByMinorPSDER(pSDERBase, string, -1);
    }

    public ArrayList<PSDER> selectByMinorPSDER(PSDERBase pSDERBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MINORPSDERID", (Object)pSDERBase.getPSDERId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMinorPSDERCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMinorPSDERCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDER> selectByLinkPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByLinkPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSDER> selectByLinkPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByLinkPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSDER> selectByLinkPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("LINKPSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByLinkPSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByLinkPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDER> selectByMDPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByMDPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSDER> selectByMDPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByMDPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSDER> selectByMDPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MDPSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMDPSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMDPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDER> selectByMobLinkPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByMobLinkPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSDER> selectByMobLinkPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByMobLinkPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSDER> selectByMobLinkPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MOBLINKPSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMobLinkPSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMobLinkPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDER> selectByMobMDPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByMobMDPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSDER> selectByMobMDPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByMobMDPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSDER> selectByMobMDPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MOBMDPSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMobMDPSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMobMDPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDER> selectByMobSDPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByMobSDPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSDER> selectByMobSDPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByMobSDPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSDER> selectByMobSDPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MOBSDPSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMobSDPSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMobSDPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDER> selectByRSPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByRSPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSDER> selectByRSPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByRSPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSDER> selectByRSPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("RSPSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRSPSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRSPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDER> selectBySDPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectBySDPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSDER> selectBySDPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectBySDPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSDER> selectBySDPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SDPSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectBySDPSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectBySDPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDER> selectByRemoveRejectPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByRemoveRejectPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDER> selectByRemoveRejectPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByRemoveRejectPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDER> selectByRemoveRejectPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REMOVEREJECTPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRemoveRejectPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRemoveRejectPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDER> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSDER> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSDER> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
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

    public ArrayList<PSDER> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSDER> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSDER> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSDER> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSDER> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSDER> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public void testRemoveByMajorPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByMajorPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDER_PSDATAENTITY_MAJORPSDEID", "", iDataEntityModel.getName(), "PSDER", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetMajorPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByMajorPSDE(pSDataEntity);
        for (PSDER pSDER : arrayList) {
            PSDER pSDER2 = (PSDER)this.getDEModel().createEntity();
            pSDER2.setPSDERId(pSDER.getPSDERId());
            pSDER2.setMajorPSDEId(null);
            this.update(pSDER2);
        }
    }

    public void removeByMajorPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDERServiceBase.this.onBeforeRemoveByMajorPSDE(pSDataEntity2);
                PSDERServiceBase.this.internalRemoveByMajorPSDE(pSDataEntity2);
                PSDERServiceBase.this.onAfterRemoveByMajorPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByMajorPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByMajorPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByMajorPSDE(pSDataEntity);
        this.onBeforeRemoveByMajorPSDE(pSDataEntity, arrayList);
        for (PSDER pSDER : arrayList) {
            this.remove((IEntity)pSDER);
        }
        this.onAfterRemoveByMajorPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByMajorPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByMajorPSDE(PSDataEntity pSDataEntity, ArrayList<PSDER> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMajorPSDE(PSDataEntity pSDataEntity, ArrayList<PSDER> arrayList) throws Exception {
    }

    public void testRemoveByMinorPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByMinorPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDER_PSDATAENTITY_MINORPSDEID", "", iDataEntityModel.getName(), "PSDER", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetMinorPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByMinorPSDE(pSDataEntity);
        for (PSDER pSDER : arrayList) {
            PSDER pSDER2 = (PSDER)this.getDEModel().createEntity();
            pSDER2.setPSDERId(pSDER.getPSDERId());
            pSDER2.setMinorPSDEId(null);
            this.update(pSDER2);
        }
    }

    public void removeByMinorPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDERServiceBase.this.onBeforeRemoveByMinorPSDE(pSDataEntity2);
                PSDERServiceBase.this.internalRemoveByMinorPSDE(pSDataEntity2);
                PSDERServiceBase.this.onAfterRemoveByMinorPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByMinorPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByMinorPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByMinorPSDE(pSDataEntity);
        this.onBeforeRemoveByMinorPSDE(pSDataEntity, arrayList);
        for (PSDER pSDER : arrayList) {
            this.remove((IEntity)pSDER);
        }
        this.onAfterRemoveByMinorPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByMinorPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByMinorPSDE(PSDataEntity pSDataEntity, ArrayList<PSDER> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMinorPSDE(PSDataEntity pSDataEntity, ArrayList<PSDER> arrayList) throws Exception {
    }

    public void testRemoveByPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByPSDEACMode(pSDEACMode, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACMODE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEACMode);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDER_PSDEACMODE_PSDEACMODEID", "", iDataEntityModel.getName(), "PSDER", iDataEntityModel.getDataInfo((IEntity)pSDEACMode), arrayList.get(0)));
        }
    }

    public void resetPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByPSDEACMode(pSDEACMode);
        for (PSDER pSDER : arrayList) {
            PSDER pSDER2 = (PSDER)this.getDEModel().createEntity();
            pSDER2.setPSDERId(pSDER.getPSDERId());
            pSDER2.setPSDEACModeId(null);
            this.update(pSDER2);
        }
    }

    public void removeByPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
        final PSDEACMode pSDEACMode2 = pSDEACMode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDERServiceBase.this.onBeforeRemoveByPSDEACMode(pSDEACMode2);
                PSDERServiceBase.this.internalRemoveByPSDEACMode(pSDEACMode2);
                PSDERServiceBase.this.onAfterRemoveByPSDEACMode(pSDEACMode2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
    }

    protected void internalRemoveByPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByPSDEACMode(pSDEACMode);
        this.onBeforeRemoveByPSDEACMode(pSDEACMode, arrayList);
        for (PSDER pSDER : arrayList) {
            this.remove((IEntity)pSDER);
        }
        this.onAfterRemoveByPSDEACMode(pSDEACMode, arrayList);
    }

    protected void onAfterRemoveByPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
    }

    protected void onBeforeRemoveByPSDEACMode(PSDEACMode pSDEACMode, ArrayList<PSDER> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEACMode(PSDEACMode pSDEACMode, ArrayList<PSDER> arrayList) throws Exception {
    }

    public void testRemoveByMinorPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByMinorPSDEDS(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDER_PSDEDATASET_MINORPSDEDSID", "", iDataEntityModel.getName(), "PSDER", iDataEntityModel.getDataInfo((IEntity)pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetMinorPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByMinorPSDEDS(pSDEDataSet);
        for (PSDER pSDER : arrayList) {
            PSDER pSDER2 = (PSDER)this.getDEModel().createEntity();
            pSDER2.setPSDERId(pSDER.getPSDERId());
            pSDER2.setMinorPSDEDSId(null);
            this.update(pSDER2);
        }
    }

    public void removeByMinorPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDERServiceBase.this.onBeforeRemoveByMinorPSDEDS(pSDEDataSet2);
                PSDERServiceBase.this.internalRemoveByMinorPSDEDS(pSDEDataSet2);
                PSDERServiceBase.this.onAfterRemoveByMinorPSDEDS(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByMinorPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByMinorPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByMinorPSDEDS(pSDEDataSet);
        this.onBeforeRemoveByMinorPSDEDS(pSDEDataSet, arrayList);
        for (PSDER pSDER : arrayList) {
            this.remove((IEntity)pSDER);
        }
        this.onAfterRemoveByMinorPSDEDS(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByMinorPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByMinorPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSDER> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMinorPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSDER> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByPSDEDataSet(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDER_PSDEDATASET_PSDEDATASETID", "", iDataEntityModel.getName(), "PSDER", iDataEntityModel.getDataInfo((IEntity)pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByPSDEDataSet(pSDEDataSet);
        for (PSDER pSDER : arrayList) {
            PSDER pSDER2 = (PSDER)this.getDEModel().createEntity();
            pSDER2.setPSDERId(pSDER.getPSDERId());
            pSDER2.setPSDEDataSetId(null);
            this.update(pSDER2);
        }
    }

    public void removeByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDERServiceBase.this.onBeforeRemoveByPSDEDataSet(pSDEDataSet2);
                PSDERServiceBase.this.internalRemoveByPSDEDataSet(pSDEDataSet2);
                PSDERServiceBase.this.onAfterRemoveByPSDEDataSet(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByPSDEDataSet(pSDEDataSet);
        this.onBeforeRemoveByPSDEDataSet(pSDEDataSet, arrayList);
        for (PSDER pSDER : arrayList) {
            this.remove((IEntity)pSDER);
        }
        this.onAfterRemoveByPSDEDataSet(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSDER> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSDER> arrayList) throws Exception {
    }

    public void testRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByPSDEFGroup(pSDEFGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEFGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDER_PSDEFGROUP_PSDEFGROUPID", "", iDataEntityModel.getName(), "PSDER", iDataEntityModel.getDataInfo((IEntity)pSDEFGroup), arrayList.get(0)));
        }
    }

    public void resetPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByPSDEFGroup(pSDEFGroup);
        for (PSDER pSDER : arrayList) {
            PSDER pSDER2 = (PSDER)this.getDEModel().createEntity();
            pSDER2.setPSDERId(pSDER.getPSDERId());
            pSDER2.setPSDEFGroupId(null);
            this.update(pSDER2);
        }
    }

    public void removeByPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        final PSDEFGroup pSDEFGroup2 = pSDEFGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDERServiceBase.this.onBeforeRemoveByPSDEFGroup(pSDEFGroup2);
                PSDERServiceBase.this.internalRemoveByPSDEFGroup(pSDEFGroup2);
                PSDERServiceBase.this.onAfterRemoveByPSDEFGroup(pSDEFGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
    }

    protected void internalRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByPSDEFGroup(pSDEFGroup);
        this.onBeforeRemoveByPSDEFGroup(pSDEFGroup, arrayList);
        for (PSDER pSDER : arrayList) {
            this.remove((IEntity)pSDER);
        }
        this.onAfterRemoveByPSDEFGroup(pSDEFGroup, arrayList);
    }

    protected void onAfterRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup, ArrayList<PSDER> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup, ArrayList<PSDER> arrayList) throws Exception {
    }

    public void testRemoveByCntPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByCntPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDER_PSDEFIELD_CNTPSDEFID", "", iDataEntityModel.getName(), "PSDER", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetCntPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByCntPSDEF(pSDEField);
        for (PSDER pSDER : arrayList) {
            PSDER pSDER2 = (PSDER)this.getDEModel().createEntity();
            pSDER2.setPSDERId(pSDER.getPSDERId());
            pSDER2.setCntPSDEFId(null);
            this.update(pSDER2);
        }
    }

    public void removeByCntPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDERServiceBase.this.onBeforeRemoveByCntPSDEF(pSDEField2);
                PSDERServiceBase.this.internalRemoveByCntPSDEF(pSDEField2);
                PSDERServiceBase.this.onAfterRemoveByCntPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByCntPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByCntPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByCntPSDEF(pSDEField);
        this.onBeforeRemoveByCntPSDEF(pSDEField, arrayList);
        for (PSDER pSDER : arrayList) {
            this.remove((IEntity)pSDER);
        }
        this.onAfterRemoveByCntPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByCntPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByCntPSDEF(PSDEField pSDEField, ArrayList<PSDER> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCntPSDEF(PSDEField pSDEField, ArrayList<PSDER> arrayList) throws Exception {
    }

    public void testRemoveByExtMajorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByExtMajorPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDER_PSDEFIELD_EXTMAJORPSDEFID", "", iDataEntityModel.getName(), "PSDER", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetExtMajorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByExtMajorPSDEF(pSDEField);
        for (PSDER pSDER : arrayList) {
            PSDER pSDER2 = (PSDER)this.getDEModel().createEntity();
            pSDER2.setPSDERId(pSDER.getPSDERId());
            pSDER2.setEXTMajorPSDEFId(null);
            this.update(pSDER2);
        }
    }

    public void removeByExtMajorPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDERServiceBase.this.onBeforeRemoveByExtMajorPSDEF(pSDEField2);
                PSDERServiceBase.this.internalRemoveByExtMajorPSDEF(pSDEField2);
                PSDERServiceBase.this.onAfterRemoveByExtMajorPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByExtMajorPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByExtMajorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByExtMajorPSDEF(pSDEField);
        this.onBeforeRemoveByExtMajorPSDEF(pSDEField, arrayList);
        for (PSDER pSDER : arrayList) {
            this.remove((IEntity)pSDER);
        }
        this.onAfterRemoveByExtMajorPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByExtMajorPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByExtMajorPSDEF(PSDEField pSDEField, ArrayList<PSDER> arrayList) throws Exception {
    }

    protected void onAfterRemoveByExtMajorPSDEF(PSDEField pSDEField, ArrayList<PSDER> arrayList) throws Exception {
    }

    public void testRemoveByExtMinorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByExtMinorPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDER_PSDEFIELD_EXTMINORPSDEFID", "", iDataEntityModel.getName(), "PSDER", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetExtMinorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByExtMinorPSDEF(pSDEField);
        for (PSDER pSDER : arrayList) {
            PSDER pSDER2 = (PSDER)this.getDEModel().createEntity();
            pSDER2.setPSDERId(pSDER.getPSDERId());
            pSDER2.setEXTMinorPSDEFId(null);
            this.update(pSDER2);
        }
    }

    public void removeByExtMinorPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDERServiceBase.this.onBeforeRemoveByExtMinorPSDEF(pSDEField2);
                PSDERServiceBase.this.internalRemoveByExtMinorPSDEF(pSDEField2);
                PSDERServiceBase.this.onAfterRemoveByExtMinorPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByExtMinorPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByExtMinorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByExtMinorPSDEF(pSDEField);
        this.onBeforeRemoveByExtMinorPSDEF(pSDEField, arrayList);
        for (PSDER pSDER : arrayList) {
            this.remove((IEntity)pSDER);
        }
        this.onAfterRemoveByExtMinorPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByExtMinorPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByExtMinorPSDEF(PSDEField pSDEField, ArrayList<PSDER> arrayList) throws Exception {
    }

    protected void onAfterRemoveByExtMinorPSDEF(PSDEField pSDEField, ArrayList<PSDER> arrayList) throws Exception {
    }

    public void testRemoveByMajorPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByMajorPSDER(pSDER, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDER);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDER_PSDER_MAJORPSDERID", "", iDataEntityModel.getName(), "PSDER", iDataEntityModel.getDataInfo((IEntity)pSDER), arrayList.get(0)));
        }
    }

    public void resetMajorPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByMajorPSDER(pSDER);
        for (PSDER pSDER2 : arrayList) {
            PSDER pSDER3 = (PSDER)this.getDEModel().createEntity();
            pSDER3.setPSDERId(pSDER2.getPSDERId());
            pSDER3.setMajorPSDERId(null);
            this.update(pSDER3);
        }
    }

    public void removeByMajorPSDER(PSDER pSDER) throws Exception {
        final PSDER pSDER2 = pSDER;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDERServiceBase.this.onBeforeRemoveByMajorPSDER(pSDER2);
                PSDERServiceBase.this.internalRemoveByMajorPSDER(pSDER2);
                PSDERServiceBase.this.onAfterRemoveByMajorPSDER(pSDER2);
            }
        });
    }

    protected void onBeforeRemoveByMajorPSDER(PSDER pSDER) throws Exception {
    }

    protected void internalRemoveByMajorPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByMajorPSDER(pSDER);
        this.onBeforeRemoveByMajorPSDER(pSDER, arrayList);
        for (PSDER pSDER2 : arrayList) {
            this.remove((IEntity)pSDER2);
        }
        this.onAfterRemoveByMajorPSDER(pSDER, arrayList);
    }

    protected void onAfterRemoveByMajorPSDER(PSDER pSDER) throws Exception {
    }

    protected void onBeforeRemoveByMajorPSDER(PSDER pSDER, ArrayList<PSDER> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMajorPSDER(PSDER pSDER, ArrayList<PSDER> arrayList) throws Exception {
    }

    public void testRemoveByMinorPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByMinorPSDER(pSDER, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDER);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDER_PSDER_MINORPSDERID", "", iDataEntityModel.getName(), "PSDER", iDataEntityModel.getDataInfo((IEntity)pSDER), arrayList.get(0)));
        }
    }

    public void resetMinorPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByMinorPSDER(pSDER);
        for (PSDER pSDER2 : arrayList) {
            PSDER pSDER3 = (PSDER)this.getDEModel().createEntity();
            pSDER3.setPSDERId(pSDER2.getPSDERId());
            pSDER3.setMinorPSDERId(null);
            this.update(pSDER3);
        }
    }

    public void removeByMinorPSDER(PSDER pSDER) throws Exception {
        final PSDER pSDER2 = pSDER;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDERServiceBase.this.onBeforeRemoveByMinorPSDER(pSDER2);
                PSDERServiceBase.this.internalRemoveByMinorPSDER(pSDER2);
                PSDERServiceBase.this.onAfterRemoveByMinorPSDER(pSDER2);
            }
        });
    }

    protected void onBeforeRemoveByMinorPSDER(PSDER pSDER) throws Exception {
    }

    protected void internalRemoveByMinorPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByMinorPSDER(pSDER);
        this.onBeforeRemoveByMinorPSDER(pSDER, arrayList);
        for (PSDER pSDER2 : arrayList) {
            this.remove((IEntity)pSDER2);
        }
        this.onAfterRemoveByMinorPSDER(pSDER, arrayList);
    }

    protected void onAfterRemoveByMinorPSDER(PSDER pSDER) throws Exception {
    }

    protected void onBeforeRemoveByMinorPSDER(PSDER pSDER, ArrayList<PSDER> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMinorPSDER(PSDER pSDER, ArrayList<PSDER> arrayList) throws Exception {
    }

    public void testRemoveByLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByLinkPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDER_PSDEVIEWBASE_LINKPSDEVIEWID", "", iDataEntityModel.getName(), "PSDER", iDataEntityModel.getDataInfo((IEntity)pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByLinkPSDEView(pSDEViewBase);
        for (PSDER pSDER : arrayList) {
            PSDER pSDER2 = (PSDER)this.getDEModel().createEntity();
            pSDER2.setPSDERId(pSDER.getPSDERId());
            pSDER2.setLinkPSDEViewId(null);
            this.update(pSDER2);
        }
    }

    public void removeByLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDERServiceBase.this.onBeforeRemoveByLinkPSDEView(pSDEViewBase2);
                PSDERServiceBase.this.internalRemoveByLinkPSDEView(pSDEViewBase2);
                PSDERServiceBase.this.onAfterRemoveByLinkPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByLinkPSDEView(pSDEViewBase);
        this.onBeforeRemoveByLinkPSDEView(pSDEViewBase, arrayList);
        for (PSDER pSDER : arrayList) {
            this.remove((IEntity)pSDER);
        }
        this.onAfterRemoveByLinkPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByLinkPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDER> arrayList) throws Exception {
    }

    protected void onAfterRemoveByLinkPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDER> arrayList) throws Exception {
    }

    public void testRemoveByMDPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByMDPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDER_PSDEVIEWBASE_MDPSDEVIEWID", "", iDataEntityModel.getName(), "PSDER", iDataEntityModel.getDataInfo((IEntity)pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetMDPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByMDPSDEView(pSDEViewBase);
        for (PSDER pSDER : arrayList) {
            PSDER pSDER2 = (PSDER)this.getDEModel().createEntity();
            pSDER2.setPSDERId(pSDER.getPSDERId());
            pSDER2.setMDPSDEViewId(null);
            this.update(pSDER2);
        }
    }

    public void removeByMDPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDERServiceBase.this.onBeforeRemoveByMDPSDEView(pSDEViewBase2);
                PSDERServiceBase.this.internalRemoveByMDPSDEView(pSDEViewBase2);
                PSDERServiceBase.this.onAfterRemoveByMDPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByMDPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByMDPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByMDPSDEView(pSDEViewBase);
        this.onBeforeRemoveByMDPSDEView(pSDEViewBase, arrayList);
        for (PSDER pSDER : arrayList) {
            this.remove((IEntity)pSDER);
        }
        this.onAfterRemoveByMDPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByMDPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByMDPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDER> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMDPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDER> arrayList) throws Exception {
    }

    public void testRemoveByMobLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByMobLinkPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDER_PSDEVIEWBASE_MOBLINKPSDEVIEWID", "", iDataEntityModel.getName(), "PSDER", iDataEntityModel.getDataInfo((IEntity)pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetMobLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByMobLinkPSDEView(pSDEViewBase);
        for (PSDER pSDER : arrayList) {
            PSDER pSDER2 = (PSDER)this.getDEModel().createEntity();
            pSDER2.setPSDERId(pSDER.getPSDERId());
            pSDER2.setMobLinkPSDEViewId(null);
            this.update(pSDER2);
        }
    }

    public void removeByMobLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDERServiceBase.this.onBeforeRemoveByMobLinkPSDEView(pSDEViewBase2);
                PSDERServiceBase.this.internalRemoveByMobLinkPSDEView(pSDEViewBase2);
                PSDERServiceBase.this.onAfterRemoveByMobLinkPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByMobLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByMobLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByMobLinkPSDEView(pSDEViewBase);
        this.onBeforeRemoveByMobLinkPSDEView(pSDEViewBase, arrayList);
        for (PSDER pSDER : arrayList) {
            this.remove((IEntity)pSDER);
        }
        this.onAfterRemoveByMobLinkPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByMobLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByMobLinkPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDER> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMobLinkPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDER> arrayList) throws Exception {
    }

    public void testRemoveByMobMDPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByMobMDPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDER_PSDEVIEWBASE_MOBMDPSDEVIEWID", "", iDataEntityModel.getName(), "PSDER", iDataEntityModel.getDataInfo((IEntity)pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetMobMDPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByMobMDPSDEView(pSDEViewBase);
        for (PSDER pSDER : arrayList) {
            PSDER pSDER2 = (PSDER)this.getDEModel().createEntity();
            pSDER2.setPSDERId(pSDER.getPSDERId());
            pSDER2.setMobMDPSDEViewId(null);
            this.update(pSDER2);
        }
    }

    public void removeByMobMDPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDERServiceBase.this.onBeforeRemoveByMobMDPSDEView(pSDEViewBase2);
                PSDERServiceBase.this.internalRemoveByMobMDPSDEView(pSDEViewBase2);
                PSDERServiceBase.this.onAfterRemoveByMobMDPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByMobMDPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByMobMDPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByMobMDPSDEView(pSDEViewBase);
        this.onBeforeRemoveByMobMDPSDEView(pSDEViewBase, arrayList);
        for (PSDER pSDER : arrayList) {
            this.remove((IEntity)pSDER);
        }
        this.onAfterRemoveByMobMDPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByMobMDPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByMobMDPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDER> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMobMDPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDER> arrayList) throws Exception {
    }

    public void testRemoveByMobSDPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByMobSDPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDER_PSDEVIEWBASE_MOBSDPSDEVIEWID", "", iDataEntityModel.getName(), "PSDER", iDataEntityModel.getDataInfo((IEntity)pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetMobSDPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByMobSDPSDEView(pSDEViewBase);
        for (PSDER pSDER : arrayList) {
            PSDER pSDER2 = (PSDER)this.getDEModel().createEntity();
            pSDER2.setPSDERId(pSDER.getPSDERId());
            pSDER2.setMobSDPSDEViewId(null);
            this.update(pSDER2);
        }
    }

    public void removeByMobSDPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDERServiceBase.this.onBeforeRemoveByMobSDPSDEView(pSDEViewBase2);
                PSDERServiceBase.this.internalRemoveByMobSDPSDEView(pSDEViewBase2);
                PSDERServiceBase.this.onAfterRemoveByMobSDPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByMobSDPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByMobSDPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByMobSDPSDEView(pSDEViewBase);
        this.onBeforeRemoveByMobSDPSDEView(pSDEViewBase, arrayList);
        for (PSDER pSDER : arrayList) {
            this.remove((IEntity)pSDER);
        }
        this.onAfterRemoveByMobSDPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByMobSDPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByMobSDPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDER> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMobSDPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDER> arrayList) throws Exception {
    }

    public void testRemoveByRSPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByRSPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDER_PSDEVIEWBASE_RSPSDEVIEWID", "", iDataEntityModel.getName(), "PSDER", iDataEntityModel.getDataInfo((IEntity)pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetRSPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByRSPSDEView(pSDEViewBase);
        for (PSDER pSDER : arrayList) {
            PSDER pSDER2 = (PSDER)this.getDEModel().createEntity();
            pSDER2.setPSDERId(pSDER.getPSDERId());
            pSDER2.setRSPSDEViewId(null);
            this.update(pSDER2);
        }
    }

    public void removeByRSPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDERServiceBase.this.onBeforeRemoveByRSPSDEView(pSDEViewBase2);
                PSDERServiceBase.this.internalRemoveByRSPSDEView(pSDEViewBase2);
                PSDERServiceBase.this.onAfterRemoveByRSPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByRSPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByRSPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByRSPSDEView(pSDEViewBase);
        this.onBeforeRemoveByRSPSDEView(pSDEViewBase, arrayList);
        for (PSDER pSDER : arrayList) {
            this.remove((IEntity)pSDER);
        }
        this.onAfterRemoveByRSPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByRSPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByRSPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDER> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRSPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDER> arrayList) throws Exception {
    }

    public void testRemoveBySDPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDER> arrayList = this.selectBySDPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDER_PSDEVIEWBASE_SDPSDEVIEWID", "", iDataEntityModel.getName(), "PSDER", iDataEntityModel.getDataInfo((IEntity)pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetSDPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDER> arrayList = this.selectBySDPSDEView(pSDEViewBase);
        for (PSDER pSDER : arrayList) {
            PSDER pSDER2 = (PSDER)this.getDEModel().createEntity();
            pSDER2.setPSDERId(pSDER.getPSDERId());
            pSDER2.setSDPSDEViewID(null);
            this.update(pSDER2);
        }
    }

    public void removeBySDPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDERServiceBase.this.onBeforeRemoveBySDPSDEView(pSDEViewBase2);
                PSDERServiceBase.this.internalRemoveBySDPSDEView(pSDEViewBase2);
                PSDERServiceBase.this.onAfterRemoveBySDPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveBySDPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveBySDPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDER> arrayList = this.selectBySDPSDEView(pSDEViewBase);
        this.onBeforeRemoveBySDPSDEView(pSDEViewBase, arrayList);
        for (PSDER pSDER : arrayList) {
            this.remove((IEntity)pSDER);
        }
        this.onAfterRemoveBySDPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveBySDPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveBySDPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDER> arrayList) throws Exception {
    }

    protected void onAfterRemoveBySDPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDER> arrayList) throws Exception {
    }

    public void testRemoveByRemoveRejectPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByRemoveRejectPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDER_PSLANGUAGERES_REMOVEREJECTPSLANRESID", "", iDataEntityModel.getName(), "PSDER", iDataEntityModel.getDataInfo((IEntity)pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetRemoveRejectPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByRemoveRejectPSLanRes(pSLanguageRes);
        for (PSDER pSDER : arrayList) {
            PSDER pSDER2 = (PSDER)this.getDEModel().createEntity();
            pSDER2.setPSDERId(pSDER.getPSDERId());
            pSDER2.setRemoveRejectPSLanResId(null);
            this.update(pSDER2);
        }
    }

    public void removeByRemoveRejectPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDERServiceBase.this.onBeforeRemoveByRemoveRejectPSLanRes(pSLanguageRes2);
                PSDERServiceBase.this.internalRemoveByRemoveRejectPSLanRes(pSLanguageRes2);
                PSDERServiceBase.this.onAfterRemoveByRemoveRejectPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByRemoveRejectPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByRemoveRejectPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByRemoveRejectPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByRemoveRejectPSLanRes(pSLanguageRes, arrayList);
        for (PSDER pSDER : arrayList) {
            this.remove((IEntity)pSDER);
        }
        this.onAfterRemoveByRemoveRejectPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByRemoveRejectPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByRemoveRejectPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDER> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRemoveRejectPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDER> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDER_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSDER", iDataEntityModel.getDataInfo((IEntity)pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSDER pSDER : arrayList) {
            PSDER pSDER2 = (PSDER)this.getDEModel().createEntity();
            pSDER2.setPSDERId(pSDER.getPSDERId());
            pSDER2.setPSSysDynaModelId(null);
            this.update(pSDER2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDERServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSDERServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSDERServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSDER pSDER : arrayList) {
            this.remove((IEntity)pSDER);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDER> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDER> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDER_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSDER", iDataEntityModel.getDataInfo((IEntity)pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSDER pSDER : arrayList) {
            PSDER pSDER2 = (PSDER)this.getDEModel().createEntity();
            pSDER2.setPSDERId(pSDER.getPSDERId());
            pSDER2.setPSSysSFPluginId(null);
            this.update(pSDER2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDERServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSDERServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSDERServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSDER pSDER : arrayList) {
            this.remove((IEntity)pSDER);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSDER> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSDER> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByPSSystem(pSSystem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSystem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDER_PSSYSTEM_PSSYSTEMID", "", iDataEntityModel.getName(), "PSDER", iDataEntityModel.getDataInfo((IEntity)pSSystem), arrayList.get(0)));
        }
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByPSSystem(pSSystem);
        for (PSDER pSDER : arrayList) {
            PSDER pSDER2 = (PSDER)this.getDEModel().createEntity();
            pSDER2.setPSDERId(pSDER.getPSDERId());
            pSDER2.setPSSystemId(null);
            this.update(pSDER2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDERServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSDERServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSDERServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSDER> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSDER pSDER : arrayList) {
            this.remove((IEntity)pSDER);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSDER> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSDER> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDER pSDER) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppDERSService)ServiceGlobal.getService(PSAppDERSService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppDERSServiceBase)pSCoreSysServiceBase).testRemoveByPSDER(pSDER);
        pSCoreSysServiceBase = (PSAppLocalDEService)ServiceGlobal.getService(PSAppLocalDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppLocalDEServiceBase)pSCoreSysServiceBase).testRemoveByPSDER(pSDER);
        pSCoreSysServiceBase = (PSDEActionLogicService)ServiceGlobal.getService(PSDEActionLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionLogicServiceBase)pSCoreSysServiceBase).testRemoveByMajorPSDEId(pSDER);
        pSCoreSysServiceBase = (PSDEActionLogicService)ServiceGlobal.getService(PSDEActionLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionLogicServiceBase)pSCoreSysServiceBase).testRemoveByMinorPSDER(pSDER);
        pSCoreSysServiceBase = (PSDEChartParamService)ServiceGlobal.getService(PSDEChartParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEChartParamServiceBase)pSCoreSysServiceBase).testRemoveByPSDER(pSDER);
        pSCoreSysServiceBase = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataSetServiceBase)pSCoreSysServiceBase).testRemoveByAggDataPSDER(pSDER);
        pSCoreSysServiceBase = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataViewServiceBase)pSCoreSysServiceBase).testRemoveByNavPSDER(pSDER);
        pSCoreSysServiceBase = (PSDEDQJoinService)ServiceGlobal.getService(PSDEDQJoinService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDQJoinServiceBase)pSCoreSysServiceBase).testRemoveByPSDER(pSDER);
        pSCoreSysServiceBase = (PSDEDRItemService)ServiceGlobal.getService(PSDEDRItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDRItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDER(pSDER);
        ((PSDEDRItemServiceBase)pSCoreSysServiceBase).removeByPSDER(pSDER);
        pSCoreSysServiceBase = (PSDEFUIModeService)ServiceGlobal.getService(PSDEFUIModeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFUIModeServiceBase)pSCoreSysServiceBase).testRemoveByRefPSDER(pSDER);
        pSCoreSysServiceBase = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFieldServiceBase)pSCoreSysServiceBase).testRemoveByO2MPSDER(pSDER);
        ((PSDEFieldServiceBase)pSCoreSysServiceBase).removeByO2MPSDER(pSDER);
        pSCoreSysServiceBase = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFieldServiceBase)pSCoreSysServiceBase).testRemoveByO2OPSDER(pSDER);
        ((PSDEFieldServiceBase)pSCoreSysServiceBase).removeByO2OPSDER(pSDER);
        pSCoreSysServiceBase = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFieldServiceBase)pSCoreSysServiceBase).testRemoveByPSDER(pSDER);
        ((PSDEFieldServiceBase)pSCoreSysServiceBase).removeByPSDER(pSDER);
        pSCoreSysServiceBase = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).testRemoveByRefPSDER(pSDER);
        pSCoreSysServiceBase = (PSDEFSFItemService)ServiceGlobal.getService(PSDEFSFItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFSFItemServiceBase)pSCoreSysServiceBase).testRemoveByRefPSDER(pSDER);
        pSCoreSysServiceBase = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridColServiceBase)pSCoreSysServiceBase).testRemoveByRefPSDER(pSDER);
        pSCoreSysServiceBase = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridServiceBase)pSCoreSysServiceBase).testRemoveByNavPSDER(pSDER);
        pSCoreSysServiceBase = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListServiceBase)pSCoreSysServiceBase).testRemoveByNavPSDER(pSDER);
        pSCoreSysServiceBase = (PSDEModelService)ServiceGlobal.getService(PSDEModelService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEModelServiceBase)pSCoreSysServiceBase).testRemoveByPSDER(pSDER);
        ((PSDEModelServiceBase)pSCoreSysServiceBase).removeByPSDER(pSDER);
        pSCoreSysServiceBase = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEOPPrivServiceBase)pSCoreSysServiceBase).testRemoveByPSDER(pSDER);
        pSCoreSysServiceBase = (PSDERDEFMapService)ServiceGlobal.getService(PSDERDEFMapService.class, (SessionFactory)this.getSessionFactory());
        ((PSDERDEFMapServiceBase)pSCoreSysServiceBase).testRemoveByPSDER(pSDER);
        ((PSDERDEFMapServiceBase)pSCoreSysServiceBase).removeByPSDER(pSDER);
        pSCoreSysServiceBase = (PSDERGroupDetailService)ServiceGlobal.getService(PSDERGroupDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDERGroupDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSDER(pSDER);
        pSCoreSysServiceBase = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
        ((PSDERServiceBase)pSCoreSysServiceBase).testRemoveByMajorPSDER(pSDER);
        pSCoreSysServiceBase = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
        ((PSDERServiceBase)pSCoreSysServiceBase).testRemoveByMinorPSDER(pSDER);
        pSCoreSysServiceBase = (PSDESARSService)ServiceGlobal.getService(PSDESARSService.class, (SessionFactory)this.getSessionFactory());
        ((PSDESARSServiceBase)pSCoreSysServiceBase).testRemoveByPSDER(pSDER);
        pSCoreSysServiceBase = (PSDETreeNodeRSService)ServiceGlobal.getService(PSDETreeNodeRSService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeRSServiceBase)pSCoreSysServiceBase).testRemoveByPSDER(pSDER);
        pSCoreSysServiceBase = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSDER(pSDER);
        pSCoreSysServiceBase = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewBaseServiceBase)pSCoreSysServiceBase).testRemoveByPSDER(pSDER);
        ((PSDEViewBaseServiceBase)pSCoreSysServiceBase).resetPSDER(pSDER);
        pSCoreSysServiceBase = (PSSysBDTableDERService)ServiceGlobal.getService(PSSysBDTableDERService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBDTableDERServiceBase)pSCoreSysServiceBase).testRemoveByPSDER(pSDER);
        pSCoreSysServiceBase = (PSSysBDTableRSService)ServiceGlobal.getService(PSSysBDTableRSService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBDTableRSServiceBase)pSCoreSysServiceBase).testRemoveByPSDER(pSDER);
        pSCoreSysServiceBase = (PSSysBDTableService)ServiceGlobal.getService(PSSysBDTableService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBDTableServiceBase)pSCoreSysServiceBase).testRemoveByPSDER(pSDER);
        pSCoreSysServiceBase = (PSSysBICubeMSJoinService)ServiceGlobal.getService(PSSysBICubeMSJoinService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBICubeMSJoinServiceBase)pSCoreSysServiceBase).testRemoveByPSDER(pSDER);
        pSCoreSysServiceBase = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDER(pSDER);
        pSCoreSysServiceBase = (PSSysEAIDERService)ServiceGlobal.getService(PSSysEAIDERService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysEAIDERServiceBase)pSCoreSysServiceBase).testRemoveByPSDER(pSDER);
        pSCoreSysServiceBase = (PSSysMapItemService)ServiceGlobal.getService(PSSysMapItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMapItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDER(pSDER);
        super.onBeforeRemove(pSDER);
    }

    protected void replaceParentInfo(PSDER pSDER, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDER, cloneSession);
        if (pSDER.getMajorPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDER.getMajorPSDEId())) != null) {
            this.onFillParentInfo_MajorPSDE(pSDER, (PSDataEntity)iEntity);
        }
        if (pSDER.getMinorPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDER.getMinorPSDEId())) != null) {
            this.onFillParentInfo_MinorPSDE(pSDER, (PSDataEntity)iEntity);
        }
        if (pSDER.getPSDEACModeId() != null && (iEntity = cloneSession.getEntity("PSDEACMODE", (Object)pSDER.getPSDEACModeId())) != null) {
            this.onFillParentInfo_PSDEACMode(pSDER, (PSDEACMode)iEntity);
        }
        if (pSDER.getMinorPSDEDSId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSDER.getMinorPSDEDSId())) != null) {
            this.onFillParentInfo_MinorPSDEDS(pSDER, (PSDEDataSet)iEntity);
        }
        if (pSDER.getPSDEDataSetId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSDER.getPSDEDataSetId())) != null) {
            this.onFillParentInfo_PSDEDataSet(pSDER, (PSDEDataSet)iEntity);
        }
        if (pSDER.getPSDEFGroupId() != null && (iEntity = cloneSession.getEntity("PSDEFGROUP", (Object)pSDER.getPSDEFGroupId())) != null) {
            this.onFillParentInfo_PSDEFGroup(pSDER, (PSDEFGroup)iEntity);
        }
        if (pSDER.getCntPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDER.getCntPSDEFId())) != null) {
            this.onFillParentInfo_CntPSDEF(pSDER, (PSDEField)iEntity);
        }
        if (pSDER.getEXTMajorPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDER.getEXTMajorPSDEFId())) != null) {
            this.onFillParentInfo_ExtMajorPSDEF(pSDER, (PSDEField)iEntity);
        }
        if (pSDER.getEXTMinorPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDER.getEXTMinorPSDEFId())) != null) {
            this.onFillParentInfo_ExtMinorPSDEF(pSDER, (PSDEField)iEntity);
        }
        if (pSDER.getMajorPSDERId() != null && (iEntity = cloneSession.getEntity("PSDER", (Object)pSDER.getMajorPSDERId())) != null) {
            this.onFillParentInfo_MajorPSDER(pSDER, (PSDER)iEntity);
        }
        if (pSDER.getMinorPSDERId() != null && (iEntity = cloneSession.getEntity("PSDER", (Object)pSDER.getMinorPSDERId())) != null) {
            this.onFillParentInfo_MinorPSDER(pSDER, (PSDER)iEntity);
        }
        if (pSDER.getLinkPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSDER.getLinkPSDEViewId())) != null) {
            this.onFillParentInfo_LinkPSDEView(pSDER, (PSDEViewBase)iEntity);
        }
        if (pSDER.getMDPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSDER.getMDPSDEViewId())) != null) {
            this.onFillParentInfo_MDPSDEView(pSDER, (PSDEViewBase)iEntity);
        }
        if (pSDER.getMobLinkPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSDER.getMobLinkPSDEViewId())) != null) {
            this.onFillParentInfo_MobLinkPSDEView(pSDER, (PSDEViewBase)iEntity);
        }
        if (pSDER.getMobMDPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSDER.getMobMDPSDEViewId())) != null) {
            this.onFillParentInfo_MobMDPSDEView(pSDER, (PSDEViewBase)iEntity);
        }
        if (pSDER.getMobSDPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSDER.getMobSDPSDEViewId())) != null) {
            this.onFillParentInfo_MobSDPSDEView(pSDER, (PSDEViewBase)iEntity);
        }
        if (pSDER.getRSPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSDER.getRSPSDEViewId())) != null) {
            this.onFillParentInfo_RSPSDEView(pSDER, (PSDEViewBase)iEntity);
        }
        if (pSDER.getSDPSDEViewID() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSDER.getSDPSDEViewID())) != null) {
            this.onFillParentInfo_SDPSDEView(pSDER, (PSDEViewBase)iEntity);
        }
        if (pSDER.getRemoveRejectPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDER.getRemoveRejectPSLanResId())) != null) {
            this.onFillParentInfo_RemoveRejectPSLanRes(pSDER, (PSLanguageRes)iEntity);
        }
        if (pSDER.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSDER.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSDER, (PSSysDynaModel)iEntity);
        }
        if (pSDER.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSDER.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSDER, (PSSysSFPlugin)iEntity);
        }
        if (pSDER.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSDER.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSDER, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDER pSDER, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDER, bl);
        pSDER.resetPSDERName();
    }

    protected void onCheckEntity(boolean bl, PSDER pSDER, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CloneOrderValue(bl, pSDER, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CloneRSFields(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CntPSDEFId(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CntPSDEFName(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEFInheritMode(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DERFieldLName(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DERFieldName(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DERSubType(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DERTag(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DERTag2(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DERType(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableClone(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnaDEFieldWriteBack(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnaExtRange(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnaPDEREQ(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExportMajorModel(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExportModel(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExportScope(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExportScope2(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExportScope3(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExportScope4(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExportScope5(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExportScope6(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EXTMajorPSDEFId(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EXTMinorPSDEFId(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FKeyName(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ForeignKey(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IgnoreDEFields(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IndexValue(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InheritMode(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LinkPSDEViewId(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MajorPSDEId(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MajorPSDEName(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MajorPSDERId(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MajorPSDERName(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MasterOrderValue(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MasterRS(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MDPSDEViewId(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorCodeName(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorLogicName(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorPSDEDSId(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorPSDEId(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorPSDEName(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorPSDERId(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorPSDERName(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorServiceCodeName(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MobLinkPSDEViewId(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MobMDPSDEViewId(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MobSDPSDEViewId(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PredefinedType(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PropertyMap(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEACModeId(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataSetId(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDRItemsCnt(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFGroupId(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFieldsCnt(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEOPPrivsCnt(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDERDEFMapsCnt(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDERId(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDERName(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RemoveActionType(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RemoveOrder(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RemoveRejectMsg(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RemoveRejectPSLanResId(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RemoveRejectPSLanResName(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RSPSDEViewId(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SDPSDEViewID(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServiceCodeName(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SyncExportModel(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TempOrderValue(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UpdatePhsicalDEField(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserParams(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDER, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CloneOrderValue(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isCloneOrderValueDirty() : !pSDER.isCloneOrderValueDirty()) {
            return null;
        }
        Integer n = pSDER.getCloneOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CloneOrderValue_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CLONEORDERVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CloneRSFields(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isCloneRSFieldsDirty() : !pSDER.isCloneRSFieldsDirty()) {
            return null;
        }
        String string = pSDER.getCloneRSFields();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CloneRSFields_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CLONERSFIELDS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CntPSDEFId(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isCntPSDEFIdDirty() : !pSDER.isCntPSDEFIdDirty()) {
            return null;
        }
        String string = pSDER.getCntPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CntPSDEFId_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CNTPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CntPSDEFName(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isCntPSDEFNameDirty() : !pSDER.isCntPSDEFNameDirty()) {
            return null;
        }
        String string = pSDER.getCntPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CntPSDEFName_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CNTPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isCodeNameDirty() : !pSDER.isCodeNameDirty()) {
            return null;
        }
        String string = pSDER.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSDER, bl2, bl3);
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
                string3 = "MINORPSDEID";
                String string4 = this.checkFieldDupRule(this.getPSDERDEModel(), "CODENAME", string3, pSDER, bl2, bl3);
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

    protected EntityFieldError onCheckField_DEFInheritMode(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isDEFInheritModeDirty() : !pSDER.isDEFInheritModeDirty()) {
            return null;
        }
        Integer n = pSDER.getDEFInheritMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DEFInheritMode_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFINHERITMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DERFieldLName(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isDERFieldLNameDirty() : !pSDER.isDERFieldLNameDirty()) {
            return null;
        }
        String string = pSDER.getDERFieldLName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DERFieldLName_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DERFIELDLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DERFieldName(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isDERFieldNameDirty() : !pSDER.isDERFieldNameDirty()) {
            return null;
        }
        String string = pSDER.getDERFieldName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DERFieldName_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DERFIELDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DERSubType(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isDERSubTypeDirty() : !pSDER.isDERSubTypeDirty()) {
            return null;
        }
        String string = pSDER.getDERSubType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DERSubType_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DERSUBTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DERTag(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isDERTagDirty() : !pSDER.isDERTagDirty()) {
            return null;
        }
        String string = pSDER.getDERTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DERTag_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DERTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DERTag2(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isDERTag2Dirty() : !pSDER.isDERTag2Dirty()) {
            return null;
        }
        String string = pSDER.getDERTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DERTag2_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DERTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DERType(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isDERTypeDirty() && !bl2 : !pSDER.isDERTypeDirty()) {
            return null;
        }
        String string = pSDER.getDERType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DERTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DERType_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DERTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            bl4 = DataTypeHelper.compare((int)25, (Object)string, (Object)"DERINHERIT") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"DER11") == 0L;
            if (bl4) {
                String string3 = "";
                string3 = "MINORPSDEID";
                String string4 = this.checkFieldDupRule(this.getPSDERDEModel(), "DERTYPE", string3, pSDER, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("DERTYPE");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isDynaModelFlagDirty() : !pSDER.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSDER.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNAMODELFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableClone(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isEnableCloneDirty() : !pSDER.isEnableCloneDirty()) {
            return null;
        }
        Integer n = pSDER.getEnableClone();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableClone_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLECLONE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnaDEFieldWriteBack(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isEnaDEFieldWriteBackDirty() : !pSDER.isEnaDEFieldWriteBackDirty()) {
            return null;
        }
        Integer n = pSDER.getEnaDEFieldWriteBack();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnaDEFieldWriteBack_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENADEFIELDWRITEBACK");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnaExtRange(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isEnaExtRangeDirty() : !pSDER.isEnaExtRangeDirty()) {
            return null;
        }
        Integer n = pSDER.getEnaExtRange();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnaExtRange_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENAEXTRANGE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnaPDEREQ(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isEnaPDEREQDirty() : !pSDER.isEnaPDEREQDirty()) {
            return null;
        }
        Integer n = pSDER.getEnaPDEREQ();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnaPDEREQ_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENAPDEREQ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExportMajorModel(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isExportMajorModelDirty() : !pSDER.isExportMajorModelDirty()) {
            return null;
        }
        Integer n = pSDER.getExportMajorModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExportMajorModel_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPORTMAJORMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExportModel(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isExportModelDirty() : !pSDER.isExportModelDirty()) {
            return null;
        }
        Integer n = pSDER.getExportModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExportModel_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPORTMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExportScope(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isExportScopeDirty() : !pSDER.isExportScopeDirty()) {
            return null;
        }
        Integer n = pSDER.getExportScope();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExportScope_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPORTSCOPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExportScope2(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isExportScope2Dirty() : !pSDER.isExportScope2Dirty()) {
            return null;
        }
        Integer n = pSDER.getExportScope2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExportScope2_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPORTSCOPE2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExportScope3(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isExportScope3Dirty() : !pSDER.isExportScope3Dirty()) {
            return null;
        }
        Integer n = pSDER.getExportScope3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExportScope3_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPORTSCOPE3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExportScope4(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isExportScope4Dirty() : !pSDER.isExportScope4Dirty()) {
            return null;
        }
        Integer n = pSDER.getExportScope4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExportScope4_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPORTSCOPE4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExportScope5(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isExportScope5Dirty() : !pSDER.isExportScope5Dirty()) {
            return null;
        }
        Integer n = pSDER.getExportScope5();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExportScope5_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPORTSCOPE5");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExportScope6(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isExportScope6Dirty() : !pSDER.isExportScope6Dirty()) {
            return null;
        }
        Integer n = pSDER.getExportScope6();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExportScope6_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPORTSCOPE6");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EXTMajorPSDEFId(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isEXTMajorPSDEFIdDirty() : !pSDER.isEXTMajorPSDEFIdDirty()) {
            return null;
        }
        String string = pSDER.getEXTMajorPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EXTMajorPSDEFId_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXTMAJORPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EXTMinorPSDEFId(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isEXTMinorPSDEFIdDirty() : !pSDER.isEXTMinorPSDEFIdDirty()) {
            return null;
        }
        String string = pSDER.getEXTMinorPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EXTMinorPSDEFId_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXTMINORPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FKeyName(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isFKeyNameDirty() : !pSDER.isFKeyNameDirty()) {
            return null;
        }
        String string = pSDER.getFKeyName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FKeyName_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FKEYNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ForeignKey(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isForeignKeyDirty() : !pSDER.isForeignKeyDirty()) {
            return null;
        }
        Integer n = pSDER.getForeignKey();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ForeignKey_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FOREIGNKEY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IgnoreDEFields(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isIgnoreDEFieldsDirty() : !pSDER.isIgnoreDEFieldsDirty()) {
            return null;
        }
        String string = pSDER.getIgnoreDEFields();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IgnoreDEFields_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IGNOREDEFIELDS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IndexValue(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isIndexValueDirty() : !pSDER.isIndexValueDirty()) {
            return null;
        }
        String string = pSDER.getIndexValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IndexValue_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INDEXVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InheritMode(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isInheritModeDirty() : !pSDER.isInheritModeDirty()) {
            return null;
        }
        Integer n = pSDER.getInheritMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_InheritMode_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INHERITMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LinkPSDEViewId(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isLinkPSDEViewIdDirty() : !pSDER.isLinkPSDEViewIdDirty()) {
            return null;
        }
        String string = pSDER.getLinkPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LinkPSDEViewId_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LINKPSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isLockFlagDirty() : !pSDER.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSDER.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default((IEntity)pSDER, bl2, bl3);
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

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isLogicNameDirty() : !pSDER.isLogicNameDirty()) {
            return null;
        }
        String string = pSDER.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MajorPSDEId(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isMajorPSDEIdDirty() && !bl2 : !pSDER.isMajorPSDEIdDirty()) {
            return null;
        }
        String string = pSDER.getMajorPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJORPSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_MajorPSDEId_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJORPSDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MajorPSDEName(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isMajorPSDENameDirty() && !bl2 : !pSDER.isMajorPSDENameDirty()) {
            return null;
        }
        String string = pSDER.getMajorPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJORPSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_MajorPSDEName_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJORPSDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MajorPSDERId(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isMajorPSDERIdDirty() : !pSDER.isMajorPSDERIdDirty()) {
            return null;
        }
        String string = pSDER.getMajorPSDERId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MajorPSDERId_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJORPSDERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MajorPSDERName(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isMajorPSDERNameDirty() : !pSDER.isMajorPSDERNameDirty()) {
            return null;
        }
        String string = pSDER.getMajorPSDERName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MajorPSDERName_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJORPSDERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MasterOrderValue(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isMasterOrderValueDirty() : !pSDER.isMasterOrderValueDirty()) {
            return null;
        }
        Integer n = pSDER.getMasterOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MasterOrderValue_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MASTERORDERVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MasterRS(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isMasterRSDirty() : !pSDER.isMasterRSDirty()) {
            return null;
        }
        Integer n = pSDER.getMasterRS();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MasterRS_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MASTERRS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MDPSDEViewId(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isMDPSDEViewIdDirty() : !pSDER.isMDPSDEViewIdDirty()) {
            return null;
        }
        String string = pSDER.getMDPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MDPSDEViewId_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MDPSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isMemoDirty() : !pSDER.isMemoDirty()) {
            return null;
        }
        String string = pSDER.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDER, bl2, bl3);
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

    protected EntityFieldError onCheckField_MinorCodeName(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isMinorCodeNameDirty() : !pSDER.isMinorCodeNameDirty()) {
            return null;
        }
        String string = pSDER.getMinorCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorCodeName_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORCODENAME");
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
                string3 = "MAJORPSDEID";
                String string4 = this.checkFieldDupRule(this.getPSDERDEModel(), "MINORCODENAME", string3, pSDER, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("MINORCODENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MinorLogicName(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isMinorLogicNameDirty() : !pSDER.isMinorLogicNameDirty()) {
            return null;
        }
        String string = pSDER.getMinorLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorLogicName_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORLOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MinorPSDEDSId(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isMinorPSDEDSIdDirty() : !pSDER.isMinorPSDEDSIdDirty()) {
            return null;
        }
        String string = pSDER.getMinorPSDEDSId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorPSDEDSId_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORPSDEDSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MinorPSDEId(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isMinorPSDEIdDirty() && !bl2 : !pSDER.isMinorPSDEIdDirty()) {
            return null;
        }
        String string = pSDER.getMinorPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORPSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorPSDEId_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORPSDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MinorPSDEName(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isMinorPSDENameDirty() && !bl2 : !pSDER.isMinorPSDENameDirty()) {
            return null;
        }
        String string = pSDER.getMinorPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORPSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorPSDEName_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORPSDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MinorPSDERId(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isMinorPSDERIdDirty() : !pSDER.isMinorPSDERIdDirty()) {
            return null;
        }
        String string = pSDER.getMinorPSDERId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorPSDERId_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORPSDERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MinorPSDERName(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isMinorPSDERNameDirty() : !pSDER.isMinorPSDERNameDirty()) {
            return null;
        }
        String string = pSDER.getMinorPSDERName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorPSDERName_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORPSDERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MinorServiceCodeName(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isMinorServiceCodeNameDirty() : !pSDER.isMinorServiceCodeNameDirty()) {
            return null;
        }
        String string = pSDER.getMinorServiceCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorServiceCodeName_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORSERVICECODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MobLinkPSDEViewId(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isMobLinkPSDEViewIdDirty() : !pSDER.isMobLinkPSDEViewIdDirty()) {
            return null;
        }
        String string = pSDER.getMobLinkPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MobLinkPSDEViewId_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MOBLINKPSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MobMDPSDEViewId(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isMobMDPSDEViewIdDirty() : !pSDER.isMobMDPSDEViewIdDirty()) {
            return null;
        }
        String string = pSDER.getMobMDPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MobMDPSDEViewId_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MOBMDPSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MobSDPSDEViewId(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isMobSDPSDEViewIdDirty() : !pSDER.isMobSDPSDEViewIdDirty()) {
            return null;
        }
        String string = pSDER.getMobSDPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MobSDPSDEViewId_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MOBSDPSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isOrderValueDirty() : !pSDER.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDER.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSDER, bl2, bl3);
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

    protected EntityFieldError onCheckField_PredefinedType(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isPredefinedTypeDirty() : !pSDER.isPredefinedTypeDirty()) {
            return null;
        }
        String string = pSDER.getPredefinedType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PredefinedType_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREDEFINEDTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PropertyMap(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isPropertyMapDirty() : !pSDER.isPropertyMapDirty()) {
            return null;
        }
        String string = pSDER.getPropertyMap();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PropertyMap_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PROPERTYMAP");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEACModeId(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isPSDEACModeIdDirty() : !pSDER.isPSDEACModeIdDirty()) {
            return null;
        }
        String string = pSDER.getPSDEACModeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEACModeId_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACMODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDataSetId(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isPSDEDataSetIdDirty() : !pSDER.isPSDEDataSetIdDirty()) {
            return null;
        }
        String string = pSDER.getPSDEDataSetId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataSetId_Default((IEntity)pSDER, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEDRItemsCnt(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isPSDEDRItemsCntDirty() : !pSDER.isPSDEDRItemsCntDirty()) {
            return null;
        }
        Integer n = pSDER.getPSDEDRItemsCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSDEDRItemsCnt_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDRITEMSCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFGroupId(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isPSDEFGroupIdDirty() : !pSDER.isPSDEFGroupIdDirty()) {
            return null;
        }
        String string = pSDER.getPSDEFGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFGroupId_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFieldsCnt(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isPSDEFieldsCntDirty() : !pSDER.isPSDEFieldsCntDirty()) {
            return null;
        }
        Integer n = pSDER.getPSDEFieldsCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSDEFieldsCnt_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFIELDSCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEOPPrivsCnt(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isPSDEOPPrivsCntDirty() : !pSDER.isPSDEOPPrivsCntDirty()) {
            return null;
        }
        Integer n = pSDER.getPSDEOPPrivsCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSDEOPPrivsCnt_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEOPPRIVSCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDERDEFMapsCnt(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isPSDERDEFMapsCntDirty() : !pSDER.isPSDERDEFMapsCntDirty()) {
            return null;
        }
        Integer n = pSDER.getPSDERDEFMapsCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSDERDEFMapsCnt_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERDEFMAPSCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDERId(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isPSDERIdDirty() && !bl2 : !pSDER.isPSDERIdDirty()) {
            return null;
        }
        String string = pSDER.getPSDERId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDERId_Default((IEntity)pSDER, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDERName(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isPSDERNameDirty() && !bl2 : !pSDER.isPSDERNameDirty()) {
            return null;
        }
        String string = pSDER.getPSDERName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDERName_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERNAME");
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
                string3 = "MINORPSDEID";
                String string4 = this.checkFieldDupRule(this.getPSDERDEModel(), "PSDERNAME", string3, pSDER, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDERNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isPSDynaInstIdDirty() : !pSDER.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSDER.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isPSSysDynaModelIdDirty() : !pSDER.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSDER.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default((IEntity)pSDER, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isPSSysSFPluginIdDirty() : !pSDER.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSDER.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default((IEntity)pSDER, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isPSSystemIdDirty() && !bl2 : !pSDER.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSDER.getPSSystemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSDER, bl2, bl3);
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

    protected EntityFieldError onCheckField_RemoveActionType(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isRemoveActionTypeDirty() : !pSDER.isRemoveActionTypeDirty()) {
            return null;
        }
        Integer n = pSDER.getRemoveActionType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RemoveActionType_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REMOVEACTIONTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RemoveOrder(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isRemoveOrderDirty() : !pSDER.isRemoveOrderDirty()) {
            return null;
        }
        Integer n = pSDER.getRemoveOrder();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RemoveOrder_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REMOVEORDER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RemoveRejectMsg(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isRemoveRejectMsgDirty() : !pSDER.isRemoveRejectMsgDirty()) {
            return null;
        }
        String string = pSDER.getRemoveRejectMsg();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RemoveRejectMsg_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REMOVEREJECTMSG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RemoveRejectPSLanResId(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isRemoveRejectPSLanResIdDirty() : !pSDER.isRemoveRejectPSLanResIdDirty()) {
            return null;
        }
        String string = pSDER.getRemoveRejectPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RemoveRejectPSLanResId_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REMOVEREJECTPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RemoveRejectPSLanResName(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isRemoveRejectPSLanResNameDirty() : !pSDER.isRemoveRejectPSLanResNameDirty()) {
            return null;
        }
        String string = pSDER.getRemoveRejectPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RemoveRejectPSLanResName_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REMOVEREJECTPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RSPSDEViewId(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isRSPSDEViewIdDirty() : !pSDER.isRSPSDEViewIdDirty()) {
            return null;
        }
        String string = pSDER.getRSPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RSPSDEViewId_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RSPSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SDPSDEViewID(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isSDPSDEViewIDDirty() : !pSDER.isSDPSDEViewIDDirty()) {
            return null;
        }
        String string = pSDER.getSDPSDEViewID();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SDPSDEViewID_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SDPSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ServiceCodeName(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isServiceCodeNameDirty() : !pSDER.isServiceCodeNameDirty()) {
            return null;
        }
        String string = pSDER.getServiceCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServiceCodeName_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERVICECODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SyncExportModel(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isSyncExportModelDirty() : !pSDER.isSyncExportModelDirty()) {
            return null;
        }
        Integer n = pSDER.getSyncExportModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SyncExportModel_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYNCEXPORTMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TempOrderValue(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isTempOrderValueDirty() : !pSDER.isTempOrderValueDirty()) {
            return null;
        }
        Integer n = pSDER.getTempOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TempOrderValue_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPORDERVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UpdatePhsicalDEField(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isUpdatePhsicalDEFieldDirty() : !pSDER.isUpdatePhsicalDEFieldDirty()) {
            return null;
        }
        Integer n = pSDER.getUpdatePhsicalDEField();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UpdatePhsicalDEField_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UPDATEPHYSICALDEFIELD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isUserCatDirty() : !pSDER.isUserCatDirty()) {
            return null;
        }
        String string = pSDER.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSDER, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserParams(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isUserParamsDirty() : !pSDER.isUserParamsDirty()) {
            return null;
        }
        String string = pSDER.getUserParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserParams_Default((IEntity)pSDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isUserTagDirty() : !pSDER.isUserTagDirty()) {
            return null;
        }
        String string = pSDER.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDER, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isUserTag2Dirty() : !pSDER.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDER.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDER, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isUserTag3Dirty() : !pSDER.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDER.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSDER, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isUserTag4Dirty() : !pSDER.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDER.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSDER, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDER pSDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDER.isValidFlagDirty() : !pSDER.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDER.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSDER, bl2, bl3);
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

    protected void onSyncEntity(PSDER pSDER, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDER, bl);
    }

    protected void onSyncIndexEntities(PSDER pSDER, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDER, bl);
    }

    public Object getDataContextValue(PSDER pSDER, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEACMODE", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"PSDEACMODEID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"PSDEACMODENAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDER, "majorpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEDATASET", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"MINORPSDEDSID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"MINORPSDEDSNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDER, "minorpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEDATASET", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"PSDEDATASETID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"PSDEDATASETNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDER, "majorpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEFGROUP", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"PSDEFGROUPID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"PSDEFGROUPNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDER, "majorpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEFIELD", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"EXTMAJORPSDEFID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"EXTMAJORPSDEFNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDER, "majorpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEFIELD", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"EXTMINORPSDEFID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"EXTMINORPSDEFNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDER, "minorpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDER", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"MINORPSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"MAJORPSDERID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"MAJORPSDERNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDER, "majorpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEVIEWBASE", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"MDPSDEVIEWID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"MDPSDEVIEWNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDER, "majorpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEVIEWBASE", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"MOBLINKPSDEVIEWID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"MOBLINKPSDEVIEWNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDER, "majorpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEVIEWBASE", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"MOBMDPSDEVIEWID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"MOBMDPSDEVIEWNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDER, "majorpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEVIEWBASE", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"MOBSDPSDEVIEWID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"MOBSDPSDEVIEWNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDER, "majorpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEVIEWBASE", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"RSPSDEVIEWID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"RSPSDEVIEWNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDER, "majorpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEVIEWBASE", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"SDPSDEVIEWID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"SDPSDEVIEWNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDER, "majorpsdeid", iDataContextParam)) != null) {
                return object;
            }
        }
        if ((object = super.getDataContextValue((IEntity)pSDER, string, iDataContextParam)) != null) {
            return object;
        }
        PSSystem pSSystem = pSDER.getPSSystem();
        if (pSSystem != null && pSSystem.contains(string)) {
            return pSSystem.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDER pSDER, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportMajorModel_RemoveRejectPSLanRes(pSDER, arrayList, n);
        super.onExportMajorModel((IEntity)pSDER, arrayList, n);
    }

    protected void onExportMajorModel_RemoveRejectPSLanRes(PSDER pSDER, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSDER.getRemoveRejectPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel((IEntity)pSDER.getRemoveRejectPSLanRes(), arrayList, n);
        }
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CLONEORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CloneOrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CLONERSFIELDS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CloneRSFields_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CNTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CntPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CNTPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CntPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFINHERITMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEFInheritMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DERFIELDLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DERFieldLName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DERFIELDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DERFieldName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DERSUBTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DERSubType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DERTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DERTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DERTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DERType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLECLONE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableClone_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENADEFIELDWRITEBACK", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnaDEFieldWriteBack_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENAEXTRANGE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnaExtRange_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENAPDEREQ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnaPDEREQ_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPORTMAJORMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExportMajorModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPORTMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExportModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPORTSCOPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExportScope_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPORTSCOPE2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExportScope2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPORTSCOPE3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExportScope3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPORTSCOPE4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExportScope4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPORTSCOPE5", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExportScope5_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPORTSCOPE6", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExportScope6_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXTMAJORPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EXTMajorPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXTMAJORPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EXTMajorPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXTMINORPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EXTMinorPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXTMINORPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EXTMinorPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FKEYNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FKeyName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FOREIGNKEY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ForeignKey_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IGNOREDEFIELDS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IgnoreDEFields_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INDEXVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IndexValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INHERITMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InheritMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LINKPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LinkPSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LINKPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LinkPSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAJORPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MajorPSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAJORPSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MajorPSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAJORPSDERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MajorPSDERId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAJORPSDERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MajorPSDERName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MASTERORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MasterOrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MASTERRS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MasterRS_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MDPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MDPSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MDPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MDPSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORLOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorLogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORPSDEDSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorPSDEDSId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORPSDEDSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorPSDEDSName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorPSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORPSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorPSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORPSDERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorPSDERId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORPSDERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorPSDERName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORSERVICECODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorServiceCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBLINKPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobLinkPSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBLINKPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobLinkPSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBMDPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobMDPSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBMDPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobMDPSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBSDPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobSDPSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBSDPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobSDPSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREDEFINEDTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PredefinedType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PROPERTYMAP", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PropertyMap_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACMODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEACModeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACMODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEACModeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATASETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataSetId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATASETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataSetName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDRITEMSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDRItemsCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFIELDSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFieldsCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEOPPRIVSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEOPPrivsCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERDEFMAPSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERDEFMapsCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"REMOVEACTIONTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RemoveActionType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REMOVEORDER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RemoveOrder_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REMOVEREJECTMSG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RemoveRejectMsg_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REMOVEREJECTPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RemoveRejectPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REMOVEREJECTPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RemoveRejectPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RSPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RSPSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RSPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RSPSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SDPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SDPSDEViewID_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SDPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SDPSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERVICECODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ServiceCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYNCEXPORTMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SyncExportModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TempOrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEPHYSICALDEFIELD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdatePhsicalDEField_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERCAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserCat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserParams_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_CloneOrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CloneRSFields_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CLONERSFIELDS", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CntPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CNTPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CntPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CNTPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_DEFInheritMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DERFieldLName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DERFIELDLNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DERFieldName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DERFIELDNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DERSubType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DERSUBTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DERTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DERTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DERTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DERTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DERType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DERTYPE", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableClone_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnaDEFieldWriteBack_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnaExtRange_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnaPDEREQ_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExportMajorModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExportModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExportScope_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExportScope2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExportScope3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExportScope4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExportScope5_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExportScope6_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EXTMajorPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EXTMAJORPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EXTMajorPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EXTMAJORPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EXTMinorPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EXTMINORPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EXTMinorPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EXTMINORPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FKeyName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FKEYNAME", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ForeignKey_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_IgnoreDEFields_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("IGNOREDEFIELDS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IndexValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INDEXVALUE", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InheritMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LinkPSDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LINKPSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LinkPSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LINKPSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LockFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MajorPSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAJORPSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MajorPSDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAJORPSDENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MajorPSDERId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAJORPSDERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MajorPSDERName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAJORPSDERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MasterOrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MasterRS_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MDPSDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MDPSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MDPSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MDPSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_MinorCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORCODENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false) && this.checkFieldRegExRule("MINORCODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MinorLogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORLOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MinorPSDEDSId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORPSDEDSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MinorPSDEDSName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORPSDEDSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MinorPSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORPSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MinorPSDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORPSDENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MinorPSDERId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORPSDERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MinorPSDERName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORPSDERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MinorServiceCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORSERVICECODENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobLinkPSDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBLINKPSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobLinkPSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBLINKPSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobMDPSDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBMDPSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobMDPSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBMDPSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobSDPSDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBSDPSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobSDPSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBSDPSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PredefinedType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREDEFINEDTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PropertyMap_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PROPERTYMAP", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEACModeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACMODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEACModeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACMODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected String onTestValueRule_PSDEDRItemsCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDEFGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFieldsCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDEOPPrivsCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDERDEFMapsCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSDynaInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAINSTID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    protected String onTestValueRule_RemoveActionType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_RemoveOrder_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_RemoveRejectMsg_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REMOVEREJECTMSG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RemoveRejectPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REMOVEREJECTPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RemoveRejectPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REMOVEREJECTPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RSPSDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RSPSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RSPSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RSPSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SDPSDEViewID_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SDPSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SDPSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SDPSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ServiceCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SERVICECODENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SyncExportModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TempOrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_UpdatePhsicalDEField_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_UserParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERPARAMS", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
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

    protected boolean onMergeChild(String string, String string2, PSDER pSDER) throws Exception {
        boolean bl = false;
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDRITEM_PSDER_PSDERID", (boolean)true) == 0) && this.onMergeChild_PSDEDRItems(pSDER)) {
            bl = true;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFIELD_PSDER_PSDERID", (boolean)true) == 0) && this.onMergeChild_PSDEFields(pSDER)) {
            bl = true;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEOPPRIV_PSDER_PSDERID", (boolean)true) == 0) && this.onMergeChild_PSDEOPPrivs(pSDER)) {
            bl = true;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDERDEFMAP_PSDER_PSDERID", (boolean)true) == 0) && this.onMergeChild_PSDERDEFMaps(pSDER)) {
            bl = true;
        }
        if (super.onMergeChild(string, string2, (IEntity)pSDER)) {
            bl = true;
        }
        return bl;
    }

    protected boolean onMergeChild_PSDEDRItems(PSDER pSDER) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSDEDRITEMSCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSDER.getPSDERId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDRItemService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSDERID", (Object)pSDER.getPSDERId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSDER, false);
        return true;
    }

    protected boolean onMergeChild_PSDEFields(PSDER pSDER) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSDEFIELDSCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSDER.getPSDERId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSDERID", (Object)pSDER.getPSDERId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSDER, false);
        return true;
    }

    protected boolean onMergeChild_PSDEOPPrivs(PSDER pSDER) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSDEOPPRIVSCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSDER.getPSDERId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSDERID", (Object)pSDER.getPSDERId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSDER, false);
        return true;
    }

    protected boolean onMergeChild_PSDERDEFMaps(PSDER pSDER) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSDERDEFMAPSCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSDER.getPSDERId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDERDEFMapService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSDERID", (Object)pSDER.getPSDERId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSDER, false);
        return true;
    }

    protected void onUpdateParent(PSDER pSDER) throws Exception {
        IService iService;
        Object object = pSDER.get("MAJORPSDEID");
        if (object != null) {
            iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDER_PSDATAENTITY_MAJORPSDEID", object);
        }
        if ((object = pSDER.get("MINORPSDEID")) != null) {
            iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDER_PSDATAENTITY_MINORPSDEID", object);
        }
        super.onUpdateParent((IEntity)pSDER);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSDER pSDER, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDER");
        if (!bl) {
            pSDER.setCreateDate(null);
            pSDER.setCreateMan(null);
            pSDER.setPSDEDRItemsCnt(null);
            pSDER.setPSDEFieldsCnt(null);
            pSDER.setPSDEOPPrivsCnt(null);
            pSDER.setPSDERDEFMapsCnt(null);
            pSDER.setPSDERId(null);
            pSDER.setPSDERName(null);
            pSDER.setUpdateDate(null);
            pSDER.setUpdateMan(null);
            super.exportCurXmlModel(pSDER, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDER pSDER, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDER, string);
        objectNode.remove("psdedritemscnt");
        objectNode.remove("psdefieldscnt");
        objectNode.remove("psdeopprivscnt");
        objectNode.remove("psderdefmapscnt");
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"MINORPSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDATAENTITY#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"MINORPSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDER_PSDATAENTITY_MINORPSDEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"MINORPSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"MINORPSDENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDATAENTITY", (boolean)true) == 0) {
            iEntity.set("MINORPSDEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"MINORPSDEID"};
    }

    @Override
    public String getModelV2Tag(PSDER pSDER) {
        if (!StringHelper.isNullOrEmpty((String)pSDER.getPSDERName())) {
            return pSDER.getPSDERName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDER.getCodeName())) {
            return pSDER.getCodeName();
        }
        return super.getModelV2Tag(pSDER);
    }

    @Override
    public boolean setModelV2Tag(PSDER pSDER, String string) {
        pSDER.setPSDERName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDERNAME", "");
        map.put("CODENAME", "");
        map.put("MINORPSDEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDER pSDER, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDER.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDER, true);
        pSDER.set("PSDERNAME", string);
        if (this.select(pSDER, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDER, true);
        return super.getModelV2Entity(pSDER, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDER pSDER, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDER, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSDEOPPRIV_PSDER_PSDERID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 60;
        }
        if (StringHelper.compare((String)"DER1N_PSDEFIELD_PSDER_PSDERID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 70;
        }
        if (StringHelper.compare((String)"DER1N_PSDERDEFMAP_PSDER_PSDERID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 70;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(PSDER pSDER, String string, String string2) throws Exception {
        String string3;
        EntityBase entityBase;
        ObjectNode objectNode;
        ArrayList<String> arrayList;
        File file;
        String string4;
        String string5;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file2 = null;
        if (this.isExportRelatedModelV2("DER1N_PSDEOPPRIV_PSDER_PSDERID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDER#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSDEOPPRIV", (Object)pSDER.getPSDERId()))).exists()) {
            pSCoreSysServiceBase = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSDEOPPriv();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSDEOPPrivServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSDEOPPriv)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSDEOPPRIV", (Object)entityBase.getPSDEOPPrivId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSDEFIELD_PSDER_PSDERID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDER#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSDEFIELD", (Object)pSDER.getPSDERId()))).exists()) {
            pSCoreSysServiceBase = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSDEField();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSDEFieldServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSDEField)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSDEFIELD", (Object)entityBase.getPSDEFieldId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSDERDEFMAP_PSDER_PSDERID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDER#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSDERDEFMAP", (Object)pSDER.getPSDERId()))).exists()) {
            pSCoreSysServiceBase = (PSDERDEFMapService)ServiceGlobal.getService(PSDERDEFMapService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSDERDEFMap();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSDERDEFMapServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSDERDEFMap)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSDERDEFMAP", (Object)entityBase.getPSDERDEFMapId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        super.onExportRelatedModelV2(pSDER, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDER pSDER, ObjectNode objectNode, String string, boolean bl) throws Exception {
        Object object;
        EntityBase entityBase2;
        Object object2;
        Object object3;
        Object object4;
        ArrayList<PSDEOPPriv> arrayList;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEOPPRIV_PSDER_PSDERID")) {
            pSCoreSysServiceBase = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDER#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEOPPRIV", (Object)pSDER.getPSDERId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add((PSDEOPPriv)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSDEOPPriv>();
                object4 = ((PSDEOPPrivServiceBase)pSCoreSysServiceBase).selectByPSDER(pSDER);
                object3 = StringHelper.format((String)"PSDER#%1$s", (Object)pSDER.getPSDERId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSDEOPPriv)object2.next();
                    object = ((PSDEOPPrivServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEOPPriv)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSCoreSysServiceBase.getModelV2Name(false);
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
                        if (objectNode.has("psdeopprivname")) {
                            string = objectNode.get("psdeopprivname").asText();
                        }
                        if (objectNode2.has("psdeopprivname")) {
                            string2 = objectNode2.get("psdeopprivname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSDEOPPriv();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEFIELD_PSDER_PSDERID")) {
            pSCoreSysServiceBase = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDER#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEFIELD", (Object)pSDER.getPSDERId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSDEOPPriv)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSDEFieldServiceBase)pSCoreSysServiceBase).selectByPSDER(pSDER);
                object3 = StringHelper.format((String)"PSDER#%1$s", (Object)pSDER.getPSDERId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSDEField)object2.next();
                    object = ((PSDEFieldService)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEOPPriv)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSCoreSysServiceBase.getModelV2Name(false);
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
                        if (objectNode.has("psdefieldname")) {
                            string = objectNode.get("psdefieldname").asText();
                        }
                        if (objectNode2.has("psdefieldname")) {
                            string2 = objectNode2.get("psdefieldname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSDEField();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDERDEFMAP_PSDER_PSDERID")) {
            pSCoreSysServiceBase = (PSDERDEFMapService)ServiceGlobal.getService(PSDERDEFMapService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDER#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDERDEFMAP", (Object)pSDER.getPSDERId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSDEOPPriv)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSDERDEFMapServiceBase)pSCoreSysServiceBase).selectByPSDER(pSDER);
                object3 = StringHelper.format((String)"PSDER#%1$s", (Object)pSDER.getPSDERId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSDERDEFMap)object2.next();
                    object = ((PSDERDEFMapServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEOPPriv)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSCoreSysServiceBase.getModelV2Name(false);
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
                        if (objectNode.has("psderdefmapname")) {
                            string = objectNode.get("psderdefmapname").asText();
                        }
                        if (objectNode2.has("psderdefmapname")) {
                            string2 = objectNode2.get("psderdefmapname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSDERDEFMap();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSDER, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDER pSDER) throws Exception {
        super.onEmptyModelV2(pSDER);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDERDEFMapService)ServiceGlobal.getService(PSDERDEFMapService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDER pSDER, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSDEOPPriv();
        entityBase.set("PSDERID", pSDER.getPSDERId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDEField();
        entityBase.set("PSDERID", pSDER.getPSDERId());
        pSCoreSysServiceBase = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDERDEFMap();
        entityBase.set("PSDERID", pSDER.getPSDERId());
        pSCoreSysServiceBase = (PSDERDEFMapService)ServiceGlobal.getService(PSDERDEFMapService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDER, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDER pSDER, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        EntityBase entityBase;
        Object object;
        Object object2;
        int n2;
        String string3;
        ArrayNode arrayNode;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        if (!PSDERServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                    object2 = (ObjectNode)arrayNode.get(n2);
                    object = new PSDEOPPriv();
                    ((PSDEOPPrivBase)object).setDERValidFlag(pSDER.getValidFlag());
                    ((PSDEOPPrivBase)object).setMajorPSDEId(pSDER.getMajorPSDEId());
                    ((PSDEOPPrivBase)object).setPSDERId(pSDER.getPSDERId());
                    ((PSDEOPPrivBase)object).setPSDERName(pSDER.getPSDERName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string4);
                if (((File)object2).exists()) {
                    object = ((File)object2).listFiles();
                    for (Object object3 : object) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSDEOPPriv();
                        entityBase.setDERValidFlag(pSDER.getValidFlag());
                        entityBase.setMajorPSDEId(pSDER.getMajorPSDEId());
                        entityBase.setPSDERId(pSDER.getPSDERId());
                        entityBase.setPSDERName(pSDER.getPSDERName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSDERServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                    object2 = (ObjectNode)arrayNode.get(n2);
                    object = new PSDEField();
                    ((PSDEFieldBase)object).setPSDERId(pSDER.getPSDERId());
                    ((PSDEFieldBase)object).setPSDERName(pSDER.getPSDERName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string5);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSDEField();
                        entityBase.setPSDERId(pSDER.getPSDERId());
                        entityBase.setPSDERName(pSDER.getPSDERName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSDERServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSDERDEFMapService)ServiceGlobal.getService(PSDERDEFMapService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    object = new PSDERDEFMap();
                    ((PSDERDEFMapBase)object).setMajorPSDEId(pSDER.getMajorPSDEId());
                    ((PSDERDEFMapBase)object).setMinorPSDEId(pSDER.getMinorPSDEId());
                    ((PSDERDEFMapBase)object).setPSDERId(pSDER.getPSDERId());
                    ((PSDERDEFMapBase)object).setPSDERName(pSDER.getPSDERName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string6 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string6);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSDERDEFMap();
                        entityBase.setMajorPSDEId(pSDER.getMajorPSDEId());
                        entityBase.setMinorPSDEId(pSDER.getMinorPSDEId());
                        entityBase.setPSDERId(pSDER.getPSDERId());
                        entityBase.setPSDERName(pSDER.getPSDERName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSDER, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDER pSDER, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEOPPRIV_PSDER_PSDERID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEOPPrivs(pSDER, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEFIELD_PSDER_PSDERID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEFields(pSDER, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDERDEFMAP_PSDER_PSDERID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDERDEFMaps(pSDER, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSDER, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSDEOPPrivs(PSDER pSDER, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEOPPRIV", true), (boolean)false) == 0) {
            PSDEOPPrivService pSDEOPPrivService = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
            PSDEOPPriv pSDEOPPriv = new PSDEOPPriv();
            pSDEOPPriv.setPSDEOPPrivId(pSMOSFile.getPSModelId());
            if (!pSDEOPPrivService.get((IEntity)pSDEOPPriv, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEOPPriv.getPSDERId(), (String)pSDER.getPSDERId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEOPPrivService.exportModelV2(pSDEOPPriv);
            pSDEOPPriv.reset();
            if (!pSDEOPPrivService.setModelV2ResScope((IEntity)pSDEOPPriv, "PSDER", pSDER.getPSDERId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEOPPrivService.importModelV2(pSDEOPPriv, objectNode);
            SessionFactoryManager.commit();
            return pSDEOPPrivService.getFile((IEntity)pSDEOPPriv);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSDEFields(PSDER pSDER, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEFIELD", true), (boolean)false) == 0) {
            PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = new PSDEField();
            pSDEField.setPSDEFieldId(pSMOSFile.getPSModelId());
            if (!pSDEFieldService.get((IEntity)pSDEField, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEField.getPSDERId(), (String)pSDER.getPSDERId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEFieldService.exportModelV2(pSDEField);
            pSDEField.reset();
            if (!pSDEFieldService.setModelV2ResScope((IEntity)pSDEField, "PSDER", pSDER.getPSDERId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEFieldService.importModelV2(pSDEField, objectNode);
            SessionFactoryManager.commit();
            return pSDEFieldService.getFile((IEntity)pSDEField);
        }
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSDBCOLUMN", true), (boolean)false) == 0) {
            PSSysDBColumnService pSSysDBColumnService = (PSSysDBColumnService)ServiceGlobal.getService(PSSysDBColumnService.class, (SessionFactory)this.getSessionFactory());
            PSSysDBColumn pSSysDBColumn = new PSSysDBColumn();
            pSSysDBColumn.setPSSysDBColumnId(pSMOSFile.getPSModelId());
            if (!pSSysDBColumnService.get((IEntity)pSSysDBColumn, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = new PSDEField();
            pSDEField.setPSDERId(pSDER.getPSDERId());
            pSDEField.setPSSysDBColumnId(pSSysDBColumn.getPSSysDBColumnId());
            this.fillPasteEntity((IEntity)pSDEField, "PASTETAG");
            pSDEFieldService.create(pSDEField);
            SessionFactoryManager.commit();
            return pSDEFieldService.getFile((IEntity)pSDEField);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSDERDEFMaps(PSDER pSDER, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDERDEFMAP", true), (boolean)false) == 0) {
            PSDERDEFMapService pSDERDEFMapService = (PSDERDEFMapService)ServiceGlobal.getService(PSDERDEFMapService.class, (SessionFactory)this.getSessionFactory());
            PSDERDEFMap pSDERDEFMap = new PSDERDEFMap();
            pSDERDEFMap.setPSDERDEFMapId(pSMOSFile.getPSModelId());
            if (!pSDERDEFMapService.get((IEntity)pSDERDEFMap, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDERDEFMap.getPSDERId(), (String)pSDER.getPSDERId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDERDEFMapService.exportModelV2(pSDERDEFMap);
            pSDERDEFMap.reset();
            if (!pSDERDEFMapService.setModelV2ResScope((IEntity)pSDERDEFMap, "PSDER", pSDER.getPSDERId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDERDEFMapService.importModelV2(pSDERDEFMap, objectNode);
            SessionFactoryManager.commit();
            return pSDERDEFMapService.getFile((IEntity)pSDERDEFMap);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSDER pSDER, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSDEOPPrivs(pSDER, list);
        this.onFillPasteHelps_PSDEFields(pSDER, list);
        this.onFillPasteHelps_PSDERDEFMaps(pSDER, list);
        super.onFillPasteHelps(pSDER, list);
    }

    protected void onFillPasteHelps_PSDEOPPrivs(PSDER pSDER, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEOPPRIV");
        pSHelpSection.setSectionParam2("DER1N_PSDEOPPRIV_PSDER_PSDERID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u5173\u7cfb]\u7684[\u5b9e\u4f53\u64cd\u4f5c\u6807\u8bc6]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSDEFields(PSDER pSDER, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEFIELD");
        pSHelpSection.setSectionParam2("DER1N_PSDEFIELD_PSDER_PSDERID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u5173\u7cfb]\u7684[\u5b9e\u4f53\u5c5e\u6027]");
        list.add(pSHelpSection);
        pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEFIELD");
        pSHelpSection.setSectionParam2("DER1N_PSDEFIELD_PSDER_PSDERID");
        pSHelpSection.setUserTag("DER1N_PSDEFIELD_PSSYSDBCOLUMN_PSSYSDBCOLUMNID");
        pSHelpSection.setContent("\u7c98\u8d34[\u6570\u636e\u5e93\u5217]\u6784\u5efa[\u5b9e\u4f53\u5c5e\u6027]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSDERDEFMaps(PSDER pSDER, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDERDEFMAP");
        pSHelpSection.setSectionParam2("DER1N_PSDERDEFMAP_PSDER_PSDERID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u5173\u7cfb]\u7684[\u5b9e\u4f53\u5173\u7cfb\u5c5e\u6027\u6620\u5c04]");
        list.add(pSHelpSection);
    }

    @Override
    protected PSMOSFile[] onListDRFolders(PSMOSFile pSMOSFile, String string, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        ArrayList arrayList;
        SelectField selectField;
        SelectContext selectContext;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        PSMOSFile pSMOSFile2;
        HashMap<String, PSMOSFile> hashMap = new HashMap<String, PSMOSFile>();
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u5173\u7cfb\u754c\u9762>", "DER1N_PSDEDRITEM_PSDER_PSDERID", "PSDERID", pSMOSFile.getPSModelId(), "", "DER1N;DER11")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSDERServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u5173\u7cfb\u754c\u9762>");
            } else if (PSDERServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psdedritems");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSDEDRITEM_PSDER_PSDERID|PSDERID");
            pSMOSFile2.setFileTag3("PSDEDRITEM");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSDEDRITEM_PSDER_PSDERID", "PSDERID", pSMOSFile.getPSModelId(), "", "DER1N;DER11")) {
                pSCoreSysServiceBase = (PSDEDRItemService)ServiceGlobal.getService(PSDEDRItemService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDEDRITEM_PSDER_PSDERID", "PSDERID", pSMOSFile.getPSModelId(), "", "DER1N;DER11");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSDERServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u5173\u7cfb\u5c5e\u6027>", "DER1N_PSDEFIELD_PSDER_PSDERID", "PSDERID", pSMOSFile.getPSModelId(), "", "DER1N;DER11;DERINHERIT;DERMULINH")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSDERServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u5173\u7cfb\u5c5e\u6027>");
            } else if (PSDERServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psdefields");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSDEFIELD_PSDER_PSDERID|PSDERID");
            pSMOSFile2.setFileTag3("PSDEFIELD");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSDEFIELD_PSDER_PSDERID", "PSDERID", pSMOSFile.getPSModelId(), "", "DER1N;DER11;DERINHERIT;DERMULINH")) {
                pSCoreSysServiceBase = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDEFIELD_PSDER_PSDERID", "PSDERID", pSMOSFile.getPSModelId(), "", "DER1N;DER11;DERINHERIT;DERMULINH");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSDERServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u5c5e\u6027\u503c\u6620\u5c04>", "DER1N_PSDERDEFMAP_PSDER_PSDERID", "PSDERID", pSMOSFile.getPSModelId(), "", "DER1N")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSDERServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u5c5e\u6027\u503c\u6620\u5c04>");
            } else if (PSDERServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psderdefmaps");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSDERDEFMAP_PSDER_PSDERID|PSDERID");
            pSMOSFile2.setFileTag3("PSDERDEFMAP");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSDERDEFMAP_PSDER_PSDERID", "PSDERID", pSMOSFile.getPSModelId(), "", "DER1N")) {
                pSCoreSysServiceBase = (PSDERDEFMapService)ServiceGlobal.getService(PSDERDEFMapService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDERDEFMAP_PSDER_PSDERID", "PSDERID", pSMOSFile.getPSModelId(), "", "DER1N");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSDERServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u64cd\u4f5c\u6807\u8bc6\u6620\u5c04>", "DER1N_PSDEOPPRIV_PSDER_PSDERID", "PSDERID", pSMOSFile.getPSModelId(), "", "DER1N")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSDERServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u64cd\u4f5c\u6807\u8bc6\u6620\u5c04>");
            } else if (PSDERServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psdeopprivs");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSDEOPPRIV_PSDER_PSDERID|PSDERID");
            pSMOSFile2.setFileTag3("PSDEOPPRIV");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSDEOPPRIV_PSDER_PSDERID", "PSDERID", pSMOSFile.getPSModelId(), "", "DER1N")) {
                pSCoreSysServiceBase = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDEOPPRIV_PSDER_PSDERID", "PSDERID", pSMOSFile.getPSModelId(), "", "DER1N");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSDERServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (hashMap.size() > 0) {
            return PSMOSFileUtil.append(hashMap.values().toArray(new PSMOSFile[hashMap.size()]), super.onListDRFolders(pSMOSFile, string, iPSMOSFileFilter));
        }
        return super.onListDRFolders(pSMOSFile, string, iPSMOSFileFilter);
    }

    @Override
    protected PSMOSFile[] onListDRDataFolders(PSMOSFile pSMOSFile, String string, String string2, IPSMOSFileFilter iPSMOSFileFilter, boolean bl) throws Exception {
        PSMOSFile pSMOSFile2;
        ArrayList arrayList;
        SelectContext selectContext;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        ArrayList<PSMOSFile> arrayList2 = new ArrayList<PSMOSFile>();
        if (PSDERServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u5173\u7cfb\u754c\u9762>", (boolean)false) == 0 || PSDERServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSDEDRItems", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSDEDRItemService)ServiceGlobal.getService(PSDEDRItemService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDEDRITEM_PSDER_PSDERID", "PSDERID", pSMOSFile.getPSModelId(), "", "DER1N;DER11");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSDERServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u5173\u7cfb\u5c5e\u6027>", (boolean)false) == 0 || PSDERServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSDEFields", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDEFIELD_PSDER_PSDERID", "PSDERID", pSMOSFile.getPSModelId(), "", "DER1N;DER11;DERINHERIT;DERMULINH");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSDERServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u5c5e\u6027\u503c\u6620\u5c04>", (boolean)false) == 0 || PSDERServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSDERDEFMaps", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSDERDEFMapService)ServiceGlobal.getService(PSDERDEFMapService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDERDEFMAP_PSDER_PSDERID", "PSDERID", pSMOSFile.getPSModelId(), "", "DER1N");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSDERServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u64cd\u4f5c\u6807\u8bc6\u6620\u5c04>", (boolean)false) == 0 || PSDERServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSDEOPPrivs", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDEOPPRIV_PSDER_PSDERID", "PSDERID", pSMOSFile.getPSModelId(), "", "DER1N");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (arrayList2.size() > 0) {
            return PSMOSFileUtil.append(arrayList2.toArray(new PSMOSFile[arrayList2.size()]), super.onListDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, bl));
        }
        return super.onListDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, bl);
    }

    @Override
    public String getDRFolderPath(String string, IEntity iEntity, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEDRITEM_PSDER_PSDERID", (boolean)false) == 0) {
            if (PSDERServiceBase.getMOSVer() == 1) {
                return "<\u5173\u7cfb\u754c\u9762>";
            }
            if (PSDERServiceBase.getMOSVer() == 2) {
                return "psdedritems";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEFIELD_PSDER_PSDERID", (boolean)false) == 0) {
            if (PSDERServiceBase.getMOSVer() == 1) {
                return "<\u5173\u7cfb\u5c5e\u6027>";
            }
            if (PSDERServiceBase.getMOSVer() == 2) {
                return "psdefields";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSDERDEFMAP_PSDER_PSDERID", (boolean)false) == 0) {
            if (PSDERServiceBase.getMOSVer() == 1) {
                return "<\u5c5e\u6027\u503c\u6620\u5c04>";
            }
            if (PSDERServiceBase.getMOSVer() == 2) {
                return "psderdefmaps";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEOPPRIV_PSDER_PSDERID", (boolean)false) == 0) {
            if (PSDERServiceBase.getMOSVer() == 1) {
                return "<\u64cd\u4f5c\u6807\u8bc6\u6620\u5c04>";
            }
            if (PSDERServiceBase.getMOSVer() == 2) {
                return "psdeopprivs";
            }
        }
        return super.getDRFolderPath(string, iEntity, string2);
    }

    @Override
    public boolean isOutputDRFolders() {
        return true;
    }

    @Override
    public Object getDataType(PSDER pSDER) throws Exception {
        return pSDER.getDERType();
    }
}

