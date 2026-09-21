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
 *  net.ibizsys.paas.service.IServicePlugin
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
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSDBValueOP;
import net.ibizsys.pscore.srv.config.entity.PSDBValueOPBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEFSFItemDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEFSFItemDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEACMode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEACModeBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFSFItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFSFItemBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFValueRule;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFValueRuleBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDERBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDSParamService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDSParamServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFSFItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridColServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeListBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBVF;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBVFBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysEditorStyle;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysEditorStyleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImageBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTranslator;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTranslatorBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysValueRule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysValueRuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarItemServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFSFItemServiceBase
extends PSCoreSysServiceBase<PSDEFSFItem> {
    private static final Log log = LogFactory.getLog(PSDEFSFItemServiceBase.class);
    public static final String DATASET_CURDE = "CurDE";
    public static final String DATASET_CURDEF = "CurDEF";
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_CALCDSTPSDEID = "CalcDstPSDEId";
    private PSDEFSFItemDEModel pSDEFSFItemDEModel;
    private PSDEFSFItemDAO pSDEFSFItemDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEFSFItemService";
    }

    public PSDEFSFItemDEModel getPSDEFSFItemDEModel() {
        if (this.pSDEFSFItemDEModel == null) {
            try {
                this.pSDEFSFItemDEModel = (PSDEFSFItemDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEFSFItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFSFItemDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEFSFItemDEModel();
    }

    public PSDEFSFItemDAO getPSDEFSFItemDAO() {
        if (this.pSDEFSFItemDAO == null) {
            try {
                this.pSDEFSFItemDAO = (PSDEFSFItemDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEFSFItemDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFSFItemDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEFSFItemDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchCurDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDEF, (boolean)true) == 0) {
            return this.fetchCurDEF(iDEDataSetFetchContext);
        }
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
        if (StringHelper.compare((String)string, (String)ACTION_CALCDSTPSDEID, (boolean)true) == 0) {
            this.calcDstPSDEId((PSDEFSFItem)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDEF(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEF, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void calcDstPSDEId(PSDEFSFItem pSDEFSFItem) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CALCDSTPSDEID, 0, (IEntity)pSDEFSFItem, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEFSFItem, ACTION_CALCDSTPSDEID);
        final PSDEFSFItem pSDEFSFItem2 = pSDEFSFItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEFSFItemServiceBase.this.getService(), PSDEFSFItemServiceBase.ACTION_CALCDSTPSDEID, 40, (IEntity)pSDEFSFItem2, null).getResult() != 1) {
                    PSDEFSFItemServiceBase.this.onCalcDstPSDEId(pSDEFSFItem2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CALCDSTPSDEID, 99, (IEntity)pSDEFSFItem, null);
        }
    }

    protected void onCalcDstPSDEId(PSDEFSFItem pSDEFSFItem) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CalcDstPSDEId]");
    }

    protected void onFillParentInfo(PSDEFSFItem pSDEFSFItem, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFSFITEM_PSCODELIST_PSCODELISTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService", (SessionFactory)this.getSessionFactory());
            PSCodeList pSCodeList = (PSCodeList)iService.getDEModel().createEntity();
            pSCodeList.set("PSCODELISTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCodeList);
            } else {
                iService.get((IEntity)pSCodeList);
            }
            this.onFillParentInfo_PSCodeList(pSDEFSFItem, pSCodeList);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFSFITEM_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDEFSFItem, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFSFITEM_PSDATAENTITY_REFPSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_RefPSDE(pSDEFSFItem, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFSFITEM_PSDBVALUEOP_PSDBVALUEOPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDBValueOPService", (SessionFactory)this.getSessionFactory());
            PSDBValueOP pSDBValueOP = (PSDBValueOP)iService.getDEModel().createEntity();
            pSDBValueOP.set("PSDBVALUEOPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDBValueOP);
            } else {
                iService.get((IEntity)pSDBValueOP);
            }
            this.onFillParentInfo_PSDBValueOP(pSDEFSFItem, pSDBValueOP);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFSFITEM_PSDEACMODE_REFPSDEACMODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEACModeService", (SessionFactory)this.getSessionFactory());
            PSDEACMode pSDEACMode = (PSDEACMode)iService.getDEModel().createEntity();
            pSDEACMode.set("PSDEACMODEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEACMode);
            } else {
                iService.get((IEntity)pSDEACMode);
            }
            this.onFillParentInfo_RefPSDEACMode(pSDEFSFItem, pSDEACMode);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFSFITEM_PSDEDATASET_REFPSDEDATASETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataSet);
            } else {
                iService.get((IEntity)pSDEDataSet);
            }
            this.onFillParentInfo_RefPSDEDataSet(pSDEFSFItem, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFSFITEM_PSDEFIELD_PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_PSDEF(pSDEFSFItem, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFSFITEM_PSDEFSFITEM_DSTPSDEFSFITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFSFItemService", (SessionFactory)this.getSessionFactory());
            PSDEFSFItem pSDEFSFItem2 = (PSDEFSFItem)iService.getDEModel().createEntity();
            pSDEFSFItem2.set("PSDEFSFITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEFSFItem2);
            } else {
                iService.get((IEntity)pSDEFSFItem2);
            }
            this.onFillParentInfo_DstPSDEFSFItem(pSDEFSFItem, pSDEFSFItem2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFSFITEM_PSDEFVALUERULE_PSDEFVALUERULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFValueRuleService", (SessionFactory)this.getSessionFactory());
            PSDEFValueRule pSDEFValueRule = (PSDEFValueRule)iService.getDEModel().createEntity();
            pSDEFValueRule.set("PSDEFVALUERULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEFValueRule);
            } else {
                iService.get((IEntity)pSDEFValueRule);
            }
            this.onFillParentInfo_PSDEFValueRule(pSDEFSFItem, pSDEFValueRule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFSFITEM_PSDELOGIC_REFADPSDELOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDELogic);
            } else {
                iService.get((IEntity)pSDELogic);
            }
            this.onFillParentInfo_RefADPSDELogic(pSDEFSFItem, pSDELogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFSFITEM_PSDER_REFPSDERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDERService", (SessionFactory)this.getSessionFactory());
            PSDER pSDER = (PSDER)iService.getDEModel().createEntity();
            pSDER.set("PSDERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDER);
            } else {
                iService.get((IEntity)pSDER);
            }
            this.onFillParentInfo_RefPSDER(pSDEFSFItem, pSDER);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFSFITEM_PSDEVIEWBASE_REFMOBMPICKUPPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEViewBase);
            } else {
                iService.get((IEntity)pSDEViewBase);
            }
            this.onFillParentInfo_RefMobMPickupPSDEView(pSDEFSFItem, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFSFITEM_PSDEVIEWBASE_REFMOBPICKUPPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEViewBase);
            } else {
                iService.get((IEntity)pSDEViewBase);
            }
            this.onFillParentInfo_RefMobPickupPSDEView(pSDEFSFItem, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFSFITEM_PSDEVIEWBASE_REFMPICKUPPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEViewBase);
            } else {
                iService.get((IEntity)pSDEViewBase);
            }
            this.onFillParentInfo_RefMPickupPSDEView(pSDEFSFItem, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFSFITEM_PSDEVIEWBASE_REFPICKUPPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEViewBase);
            } else {
                iService.get((IEntity)pSDEViewBase);
            }
            this.onFillParentInfo_RefPickupPSDEView(pSDEFSFItem, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFSFITEM_PSLANGUAGERES_CAPPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSLanguageRes);
            } else {
                iService.get((IEntity)pSLanguageRes);
            }
            this.onFillParentInfo_CapPSLanRes(pSDEFSFItem, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFSFITEM_PSLANGUAGERES_PHPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSLanguageRes);
            } else {
                iService.get((IEntity)pSLanguageRes);
            }
            this.onFillParentInfo_PHPSLanRes(pSDEFSFItem, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFSFITEM_PSSYSDBVF_PSSYSDBVFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDBVFService", (SessionFactory)this.getSessionFactory());
            PSSysDBVF pSSysDBVF = (PSSysDBVF)iService.getDEModel().createEntity();
            pSSysDBVF.set("PSSYSDBVFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDBVF);
            } else {
                iService.get((IEntity)pSSysDBVF);
            }
            this.onFillParentInfo_PSSysDBVF(pSDEFSFItem, pSSysDBVF);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFSFITEM_PSSYSEDITORSTYLE_PSSYSEDITORSTYLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysEditorStyleService", (SessionFactory)this.getSessionFactory());
            PSSysEditorStyle pSSysEditorStyle = (PSSysEditorStyle)iService.getDEModel().createEntity();
            pSSysEditorStyle.set("PSSYSEDITORSTYLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysEditorStyle);
            } else {
                iService.get((IEntity)pSSysEditorStyle);
            }
            this.onFillParentInfo_PSSysEditorStyle(pSDEFSFItem, pSSysEditorStyle);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFSFITEM_PSSYSIMAGE_PSSYSIMAGEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService", (SessionFactory)this.getSessionFactory());
            PSSysImage pSSysImage = (PSSysImage)iService.getDEModel().createEntity();
            pSSysImage.set("PSSYSIMAGEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysImage);
            } else {
                iService.get((IEntity)pSSysImage);
            }
            this.onFillParentInfo_PSSysImage(pSDEFSFItem, pSSysImage);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFSFITEM_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysSFPlugin);
            } else {
                iService.get((IEntity)pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSDEFSFItem, pSSysSFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFSFITEM_PSSYSTRANSLATOR_PSSYSTRANSLATORID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysTranslatorService", (SessionFactory)this.getSessionFactory());
            PSSysTranslator pSSysTranslator = (PSSysTranslator)iService.getDEModel().createEntity();
            pSSysTranslator.set("PSSYSTRANSLATORID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysTranslator);
            } else {
                iService.get((IEntity)pSSysTranslator);
            }
            this.onFillParentInfo_PSSysTranslator(pSDEFSFItem, pSSysTranslator);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFSFITEM_PSSYSVALUERULE_PSSYSVALUERULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysValueRuleService", (SessionFactory)this.getSessionFactory());
            PSSysValueRule pSSysValueRule = (PSSysValueRule)iService.getDEModel().createEntity();
            pSSysValueRule.set("PSSYSVALUERULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysValueRule);
            } else {
                iService.get((IEntity)pSSysValueRule);
            }
            this.onFillParentInfo_PSSysValueRule(pSDEFSFItem, pSSysValueRule);
            return;
        }
        super.onFillParentInfo((IEntity)pSDEFSFItem, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSCodeList(PSDEFSFItem pSDEFSFItem, PSCodeList pSCodeList) throws Exception {
        pSDEFSFItem.setPSCodeListId(pSCodeList.getPSCodeListId());
        pSDEFSFItem.setPSCodeListName(pSCodeList.getPSCodeListName());
    }

    protected void onFillParentInfo_PSDE(PSDEFSFItem pSDEFSFItem, PSDataEntity pSDataEntity) throws Exception {
        pSDEFSFItem.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEFSFItem.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_RefPSDE(PSDEFSFItem pSDEFSFItem, PSDataEntity pSDataEntity) throws Exception {
        pSDEFSFItem.setRefPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEFSFItem.setRefPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDBValueOP(PSDEFSFItem pSDEFSFItem, PSDBValueOP pSDBValueOP) throws Exception {
        pSDEFSFItem.setPSDBValueOPId(pSDBValueOP.getPSDBValueOPId());
        pSDEFSFItem.setPSDBValueOPName(pSDBValueOP.getPSDBValueOPName());
    }

    protected void onFillParentInfo_RefPSDEACMode(PSDEFSFItem pSDEFSFItem, PSDEACMode pSDEACMode) throws Exception {
        pSDEFSFItem.setRefPSDEACModeId(pSDEACMode.getPSDEACModeId());
        pSDEFSFItem.setRefPSDEACModeName(pSDEACMode.getPSDEACModeName());
    }

    protected void onFillParentInfo_RefPSDEDataSet(PSDEFSFItem pSDEFSFItem, PSDEDataSet pSDEDataSet) throws Exception {
        pSDEFSFItem.setRefPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
        pSDEFSFItem.setRefPSDEDataSetName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_PSDEF(PSDEFSFItem pSDEFSFItem, PSDEField pSDEField) throws Exception {
        pSDEFSFItem.setLogicName(pSDEField.getLogicName());
        pSDEFSFItem.setO2MPSDERId(pSDEField.getO2MPSDERId());
        pSDEFSFItem.setO2OPSDERId(pSDEField.getO2OPSDERId());
        pSDEFSFItem.setPSDEFId(pSDEField.getPSDEFieldId());
        pSDEFSFItem.setPSDEFName(pSDEField.getPSDEFieldName());
        if (pSDEField.getPSDE() != null) {
            this.onFillParentInfo_PSDE(pSDEFSFItem, pSDEField.getPSDE());
        }
    }

    protected void onFillParentInfo_DstPSDEFSFItem(PSDEFSFItem pSDEFSFItem, PSDEFSFItem pSDEFSFItem2) throws Exception {
        pSDEFSFItem.setDstPSDEFId(pSDEFSFItem2.getPSDEFId());
        pSDEFSFItem.setDstPSDEFSFItemId(pSDEFSFItem2.getPSDEFSFItemId());
        pSDEFSFItem.setDstPSDEFSFItemName(pSDEFSFItem2.getPSDEFSFItemName());
        pSDEFSFItem.setDstPSDEId(pSDEFSFItem2.getPSDEId());
    }

    protected void onFillParentInfo_PSDEFValueRule(PSDEFSFItem pSDEFSFItem, PSDEFValueRule pSDEFValueRule) throws Exception {
        pSDEFSFItem.setPSDEFValueRuleId(pSDEFValueRule.getPSDEFValueRuleId());
        pSDEFSFItem.setPSDEFValueRuleName(pSDEFValueRule.getPSDEFValueRuleName());
    }

    protected void onFillParentInfo_RefADPSDELogic(PSDEFSFItem pSDEFSFItem, PSDELogic pSDELogic) throws Exception {
        pSDEFSFItem.setRefADPSDELogicId(pSDELogic.getPSDELogicId());
        pSDEFSFItem.setRefADPSDELogicName(pSDELogic.getPSDELogicName());
    }

    protected void onFillParentInfo_RefPSDER(PSDEFSFItem pSDEFSFItem, PSDER pSDER) throws Exception {
        pSDEFSFItem.setRefPSDERId(pSDER.getPSDERId());
        pSDEFSFItem.setRefPSDERName(pSDER.getPSDERName());
    }

    protected void onFillParentInfo_RefMobMPickupPSDEView(PSDEFSFItem pSDEFSFItem, PSDEViewBase pSDEViewBase) throws Exception {
        pSDEFSFItem.setRefMobMPickupPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSDEFSFItem.setRefMobMPickupPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_RefMobPickupPSDEView(PSDEFSFItem pSDEFSFItem, PSDEViewBase pSDEViewBase) throws Exception {
        pSDEFSFItem.setRefMobPickupPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSDEFSFItem.setRefMobPickupPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_RefMPickupPSDEView(PSDEFSFItem pSDEFSFItem, PSDEViewBase pSDEViewBase) throws Exception {
        pSDEFSFItem.setRefMPickupPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSDEFSFItem.setRefMPickupPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_RefPickupPSDEView(PSDEFSFItem pSDEFSFItem, PSDEViewBase pSDEViewBase) throws Exception {
        pSDEFSFItem.setRefPickupPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSDEFSFItem.setRefPickupPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_CapPSLanRes(PSDEFSFItem pSDEFSFItem, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEFSFItem.setCapPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEFSFItem.setCapPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PHPSLanRes(PSDEFSFItem pSDEFSFItem, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEFSFItem.setPHPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEFSFItem.setPHPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSSysDBVF(PSDEFSFItem pSDEFSFItem, PSSysDBVF pSSysDBVF) throws Exception {
        pSDEFSFItem.setPSSysDBVFId(pSSysDBVF.getPSSysDBVFId());
        pSDEFSFItem.setPSSysDBVFName(pSSysDBVF.getPSSysDBVFName());
    }

    protected void onFillParentInfo_PSSysEditorStyle(PSDEFSFItem pSDEFSFItem, PSSysEditorStyle pSSysEditorStyle) throws Exception {
        pSDEFSFItem.setPSSysEditorStyleId(pSSysEditorStyle.getPSSysEditorStyleId());
        pSDEFSFItem.setPSSysEditorStyleName(pSSysEditorStyle.getPSSysEditorStyleName());
    }

    protected void onFillParentInfo_PSSysImage(PSDEFSFItem pSDEFSFItem, PSSysImage pSSysImage) throws Exception {
        pSDEFSFItem.setPSSysImageId(pSSysImage.getPSSysImageId());
        pSDEFSFItem.setPSSysImageName(pSSysImage.getPSSysImageName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSDEFSFItem pSDEFSFItem, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSDEFSFItem.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSDEFSFItem.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillParentInfo_PSSysTranslator(PSDEFSFItem pSDEFSFItem, PSSysTranslator pSSysTranslator) throws Exception {
        pSDEFSFItem.setPSSysTranslatorId(pSSysTranslator.getPSSysTranslatorId());
        pSDEFSFItem.setPSSysTranslatorName(pSSysTranslator.getPSSysTranslatorName());
    }

    protected void onFillParentInfo_PSSysValueRule(PSDEFSFItem pSDEFSFItem, PSSysValueRule pSSysValueRule) throws Exception {
        pSDEFSFItem.setPSSysValueRuleId(pSSysValueRule.getPSSysValueRuleId());
        pSDEFSFItem.setPSSysValueRuleName(pSSysValueRule.getPSSysValueRuleName());
    }

    protected boolean onFillEntityKeyValue(PSDEFSFItem pSDEFSFItem, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSDEFSFItem.get("PSDEFID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSDEFSFItem.get("PSDEFSFITEMNAME");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSDEFSFItem.set(this.getPSDEFSFItemDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSDEFSFItem pSDEFSFItem, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDEFSFItem, bl);
        this.onFillEntityFullInfo_PSCodeList(pSDEFSFItem, bl);
        this.onFillEntityFullInfo_PSDE(pSDEFSFItem, bl);
        this.onFillEntityFullInfo_RefPSDE(pSDEFSFItem, bl);
        this.onFillEntityFullInfo_PSDBValueOP(pSDEFSFItem, bl);
        this.onFillEntityFullInfo_RefPSDEACMode(pSDEFSFItem, bl);
        this.onFillEntityFullInfo_RefPSDEDataSet(pSDEFSFItem, bl);
        this.onFillEntityFullInfo_PSDEF(pSDEFSFItem, bl);
        this.onFillEntityFullInfo_DstPSDEFSFItem(pSDEFSFItem, bl);
        this.onFillEntityFullInfo_PSDEFValueRule(pSDEFSFItem, bl);
        this.onFillEntityFullInfo_RefADPSDELogic(pSDEFSFItem, bl);
        this.onFillEntityFullInfo_RefPSDER(pSDEFSFItem, bl);
        this.onFillEntityFullInfo_RefMobMPickupPSDEView(pSDEFSFItem, bl);
        this.onFillEntityFullInfo_RefMobPickupPSDEView(pSDEFSFItem, bl);
        this.onFillEntityFullInfo_RefMPickupPSDEView(pSDEFSFItem, bl);
        this.onFillEntityFullInfo_RefPickupPSDEView(pSDEFSFItem, bl);
        this.onFillEntityFullInfo_CapPSLanRes(pSDEFSFItem, bl);
        this.onFillEntityFullInfo_PHPSLanRes(pSDEFSFItem, bl);
        this.onFillEntityFullInfo_PSSysDBVF(pSDEFSFItem, bl);
        this.onFillEntityFullInfo_PSSysEditorStyle(pSDEFSFItem, bl);
        this.onFillEntityFullInfo_PSSysImage(pSDEFSFItem, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSDEFSFItem, bl);
        this.onFillEntityFullInfo_PSSysTranslator(pSDEFSFItem, bl);
        this.onFillEntityFullInfo_PSSysValueRule(pSDEFSFItem, bl);
    }

    protected void onFillEntityFullInfo_PSCodeList(PSDEFSFItem pSDEFSFItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDE(PSDEFSFItem pSDEFSFItem, boolean bl) throws Exception {
        if (pSDEFSFItem.isPSDEIdDirty()) {
            if (pSDEFSFItem.getPSDEId() != null) {
                if (pSDEFSFItem.getPSDEId() == null || pSDEFSFItem.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEFSFItem.getPSDE();
                    pSDEFSFItem.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEFSFItem.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_RefPSDE(PSDEFSFItem pSDEFSFItem, boolean bl) throws Exception {
        if (pSDEFSFItem.isRefPSDEIdDirty()) {
            if (pSDEFSFItem.getRefPSDEId() != null) {
                if (pSDEFSFItem.getRefPSDEId() == null || pSDEFSFItem.getRefPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEFSFItem.getRefPSDE();
                    pSDEFSFItem.setRefPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEFSFItem.setRefPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDBValueOP(PSDEFSFItem pSDEFSFItem, boolean bl) throws Exception {
        if (pSDEFSFItem.isPSDBValueOPIdDirty()) {
            if (pSDEFSFItem.getPSDBValueOPId() != null) {
                if (pSDEFSFItem.getPSDBValueOPId() == null || pSDEFSFItem.getPSDBValueOPName() == null) {
                    PSDBValueOP pSDBValueOP = pSDEFSFItem.getPSDBValueOP();
                    pSDEFSFItem.setPSDBValueOPName(pSDBValueOP.getPSDBValueOPName());
                }
            } else {
                pSDEFSFItem.setPSDBValueOPName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_RefPSDEACMode(PSDEFSFItem pSDEFSFItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefPSDEDataSet(PSDEFSFItem pSDEFSFItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEF(PSDEFSFItem pSDEFSFItem, boolean bl) throws Exception {
        if (pSDEFSFItem.isPSDEFIdDirty()) {
            if (pSDEFSFItem.getPSDEFId() != null) {
                PSDEField pSDEField;
                if (pSDEFSFItem.getPSDEFId() == null || pSDEFSFItem.getPSDEFName() == null) {
                    pSDEField = pSDEFSFItem.getPSDEF();
                    pSDEFSFItem.setLogicName(pSDEField.getLogicName());
                    pSDEFSFItem.setO2MPSDERId(pSDEField.getO2MPSDERId());
                    pSDEFSFItem.setO2OPSDERId(pSDEField.getO2OPSDERId());
                    pSDEFSFItem.setPSDEFName(pSDEField.getPSDEFieldName());
                }
                if (DataTypeHelper.compare((int)25, (Object)(pSDEField = pSDEFSFItem.getPSDEF()).getPSDEId(), (Object)pSDEFSFItem.getPSDEId()) != 0L) {
                    pSDEFSFItem.setPSDEId(pSDEField.getPSDEId());
                    this.onFillEntityFullInfo_PSDE(pSDEFSFItem, bl);
                }
            } else {
                pSDEFSFItem.setLogicName(null);
                pSDEFSFItem.setO2MPSDERId(null);
                pSDEFSFItem.setO2OPSDERId(null);
                pSDEFSFItem.setPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_DstPSDEFSFItem(PSDEFSFItem pSDEFSFItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEFValueRule(PSDEFSFItem pSDEFSFItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefADPSDELogic(PSDEFSFItem pSDEFSFItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefPSDER(PSDEFSFItem pSDEFSFItem, boolean bl) throws Exception {
        if (pSDEFSFItem.isRefPSDERIdDirty()) {
            if (pSDEFSFItem.getRefPSDERId() != null) {
                if (pSDEFSFItem.getRefPSDERId() == null || pSDEFSFItem.getRefPSDERName() == null) {
                    PSDER pSDER = pSDEFSFItem.getRefPSDER();
                    pSDEFSFItem.setRefPSDERName(pSDER.getPSDERName());
                }
            } else {
                pSDEFSFItem.setRefPSDERName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_RefMobMPickupPSDEView(PSDEFSFItem pSDEFSFItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefMobPickupPSDEView(PSDEFSFItem pSDEFSFItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefMPickupPSDEView(PSDEFSFItem pSDEFSFItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefPickupPSDEView(PSDEFSFItem pSDEFSFItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_CapPSLanRes(PSDEFSFItem pSDEFSFItem, boolean bl) throws Exception {
        if (pSDEFSFItem.isCapPSLanResIdDirty()) {
            if (pSDEFSFItem.getCapPSLanResId() != null) {
                if (pSDEFSFItem.getCapPSLanResId() == null || pSDEFSFItem.getCapPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEFSFItem.getCapPSLanRes();
                    pSDEFSFItem.setCapPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEFSFItem.setCapPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PHPSLanRes(PSDEFSFItem pSDEFSFItem, boolean bl) throws Exception {
        if (pSDEFSFItem.isPHPSLanResIdDirty()) {
            if (pSDEFSFItem.getPHPSLanResId() != null) {
                if (pSDEFSFItem.getPHPSLanResId() == null || pSDEFSFItem.getPHPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEFSFItem.getPHPSLanRes();
                    pSDEFSFItem.setPHPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEFSFItem.setPHPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysDBVF(PSDEFSFItem pSDEFSFItem, boolean bl) throws Exception {
        if (pSDEFSFItem.isPSSysDBVFIdDirty()) {
            if (pSDEFSFItem.getPSSysDBVFId() != null) {
                if (pSDEFSFItem.getPSSysDBVFId() == null || pSDEFSFItem.getPSSysDBVFName() == null) {
                    PSSysDBVF pSSysDBVF = pSDEFSFItem.getPSSysDBVF();
                    pSDEFSFItem.setPSSysDBVFName(pSSysDBVF.getPSSysDBVFName());
                }
            } else {
                pSDEFSFItem.setPSSysDBVFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysEditorStyle(PSDEFSFItem pSDEFSFItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysImage(PSDEFSFItem pSDEFSFItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSDEFSFItem pSDEFSFItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysTranslator(PSDEFSFItem pSDEFSFItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysValueRule(PSDEFSFItem pSDEFSFItem, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEFSFItem pSDEFSFItem, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEFSFItem, bl);
    }

    public ArrayList<PSDEFSFItem> selectByPSCodeList(PSCodeListBase pSCodeListBase) throws Exception {
        return this.selectByPSCodeList(pSCodeListBase, "", -1);
    }

    public ArrayList<PSDEFSFItem> selectByPSCodeList(PSCodeListBase pSCodeListBase, String string) throws Exception {
        return this.selectByPSCodeList(pSCodeListBase, string, -1);
    }

    public ArrayList<PSDEFSFItem> selectByPSCodeList(PSCodeListBase pSCodeListBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCODELISTID", (Object)pSCodeListBase.getPSCodeListId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCodeListCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCodeListCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFSFItem> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEFSFItem> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEFSFItem> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEFSFItem> selectByRefPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByRefPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEFSFItem> selectByRefPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByRefPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEFSFItem> selectByRefPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSDEID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFSFItem> selectByPSDBValueOP(PSDBValueOPBase pSDBValueOPBase) throws Exception {
        return this.selectByPSDBValueOP(pSDBValueOPBase, "", -1);
    }

    public ArrayList<PSDEFSFItem> selectByPSDBValueOP(PSDBValueOPBase pSDBValueOPBase, String string) throws Exception {
        return this.selectByPSDBValueOP(pSDBValueOPBase, string, -1);
    }

    public ArrayList<PSDEFSFItem> selectByPSDBValueOP(PSDBValueOPBase pSDBValueOPBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEFSFItem> selectByRefPSDEACMode(PSDEACModeBase pSDEACModeBase) throws Exception {
        return this.selectByRefPSDEACMode(pSDEACModeBase, "", -1);
    }

    public ArrayList<PSDEFSFItem> selectByRefPSDEACMode(PSDEACModeBase pSDEACModeBase, String string) throws Exception {
        return this.selectByRefPSDEACMode(pSDEACModeBase, string, -1);
    }

    public ArrayList<PSDEFSFItem> selectByRefPSDEACMode(PSDEACModeBase pSDEACModeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSDEACMODEID", (Object)pSDEACModeBase.getPSDEACModeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSDEACModeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSDEACModeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFSFItem> selectByRefPSDEDataSet(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByRefPSDEDataSet(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSDEFSFItem> selectByRefPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByRefPSDEDataSet(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSDEFSFItem> selectByRefPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSDEDATASETID", (Object)pSDEDataSetBase.getPSDEDataSetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSDEDataSetCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSDEDataSetCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFSFItem> selectByPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEFSFItem> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEFSFItem> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFSFItem> selectByDstPSDEFSFItem(PSDEFSFItemBase pSDEFSFItemBase) throws Exception {
        return this.selectByDstPSDEFSFItem(pSDEFSFItemBase, "", -1);
    }

    public ArrayList<PSDEFSFItem> selectByDstPSDEFSFItem(PSDEFSFItemBase pSDEFSFItemBase, String string) throws Exception {
        return this.selectByDstPSDEFSFItem(pSDEFSFItemBase, string, -1);
    }

    public ArrayList<PSDEFSFItem> selectByDstPSDEFSFItem(PSDEFSFItemBase pSDEFSFItemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDEFSFITEMID", (Object)pSDEFSFItemBase.getPSDEFSFItemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSDEFSFItemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSDEFSFItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFSFItem> selectByPSDEFValueRule(PSDEFValueRuleBase pSDEFValueRuleBase) throws Exception {
        return this.selectByPSDEFValueRule(pSDEFValueRuleBase, "", -1);
    }

    public ArrayList<PSDEFSFItem> selectByPSDEFValueRule(PSDEFValueRuleBase pSDEFValueRuleBase, String string) throws Exception {
        return this.selectByPSDEFValueRule(pSDEFValueRuleBase, string, -1);
    }

    public ArrayList<PSDEFSFItem> selectByPSDEFValueRule(PSDEFValueRuleBase pSDEFValueRuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFVALUERULEID", (Object)pSDEFValueRuleBase.getPSDEFValueRuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFValueRuleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFValueRuleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFSFItem> selectByRefADPSDELogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByRefADPSDELogic(pSDELogicBase, "", -1);
    }

    public ArrayList<PSDEFSFItem> selectByRefADPSDELogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByRefADPSDELogic(pSDELogicBase, string, -1);
    }

    public ArrayList<PSDEFSFItem> selectByRefADPSDELogic(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFADPSDELOGICID", (Object)pSDELogicBase.getPSDELogicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefADPSDELogicCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefADPSDELogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFSFItem> selectByRefPSDER(PSDERBase pSDERBase) throws Exception {
        return this.selectByRefPSDER(pSDERBase, "", -1);
    }

    public ArrayList<PSDEFSFItem> selectByRefPSDER(PSDERBase pSDERBase, String string) throws Exception {
        return this.selectByRefPSDER(pSDERBase, string, -1);
    }

    public ArrayList<PSDEFSFItem> selectByRefPSDER(PSDERBase pSDERBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSDERID", (Object)pSDERBase.getPSDERId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSDERCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSDERCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFSFItem> selectByRefMobMPickupPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByRefMobMPickupPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSDEFSFItem> selectByRefMobMPickupPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByRefMobMPickupPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSDEFSFItem> selectByRefMobMPickupPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFMOBMPICKUPPSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefMobMPickupPSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefMobMPickupPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFSFItem> selectByRefMobPickupPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByRefMobPickupPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSDEFSFItem> selectByRefMobPickupPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByRefMobPickupPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSDEFSFItem> selectByRefMobPickupPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFMOBPICKUPPSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefMobPickupPSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefMobPickupPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFSFItem> selectByRefMPickupPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByRefMPickupPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSDEFSFItem> selectByRefMPickupPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByRefMPickupPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSDEFSFItem> selectByRefMPickupPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFMPICKUPPSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefMPickupPSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefMPickupPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFSFItem> selectByRefPickupPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByRefPickupPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSDEFSFItem> selectByRefPickupPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByRefPickupPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSDEFSFItem> selectByRefPickupPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPICKUPPSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPickupPSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPickupPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFSFItem> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByCapPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEFSFItem> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByCapPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEFSFItem> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CAPPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByCapPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByCapPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFSFItem> selectByPHPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByPHPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEFSFItem> selectByPHPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByPHPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEFSFItem> selectByPHPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PHPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPHPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPHPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFSFItem> selectByPSSysDBVF(PSSysDBVFBase pSSysDBVFBase) throws Exception {
        return this.selectByPSSysDBVF(pSSysDBVFBase, "", -1);
    }

    public ArrayList<PSDEFSFItem> selectByPSSysDBVF(PSSysDBVFBase pSSysDBVFBase, String string) throws Exception {
        return this.selectByPSSysDBVF(pSSysDBVFBase, string, -1);
    }

    public ArrayList<PSDEFSFItem> selectByPSSysDBVF(PSSysDBVFBase pSSysDBVFBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEFSFItem> selectByPSSysEditorStyle(PSSysEditorStyleBase pSSysEditorStyleBase) throws Exception {
        return this.selectByPSSysEditorStyle(pSSysEditorStyleBase, "", -1);
    }

    public ArrayList<PSDEFSFItem> selectByPSSysEditorStyle(PSSysEditorStyleBase pSSysEditorStyleBase, String string) throws Exception {
        return this.selectByPSSysEditorStyle(pSSysEditorStyleBase, string, -1);
    }

    public ArrayList<PSDEFSFItem> selectByPSSysEditorStyle(PSSysEditorStyleBase pSSysEditorStyleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSEDITORSTYLEID", (Object)pSSysEditorStyleBase.getPSSysEditorStyleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysEditorStyleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysEditorStyleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFSFItem> selectByPSSysImage(PSSysImageBase pSSysImageBase) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, "", -1);
    }

    public ArrayList<PSDEFSFItem> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, string, -1);
    }

    public ArrayList<PSDEFSFItem> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEFSFItem> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSDEFSFItem> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSDEFSFItem> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEFSFItem> selectByPSSysTranslator(PSSysTranslatorBase pSSysTranslatorBase) throws Exception {
        return this.selectByPSSysTranslator(pSSysTranslatorBase, "", -1);
    }

    public ArrayList<PSDEFSFItem> selectByPSSysTranslator(PSSysTranslatorBase pSSysTranslatorBase, String string) throws Exception {
        return this.selectByPSSysTranslator(pSSysTranslatorBase, string, -1);
    }

    public ArrayList<PSDEFSFItem> selectByPSSysTranslator(PSSysTranslatorBase pSSysTranslatorBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTRANSLATORID", (Object)pSSysTranslatorBase.getPSSysTranslatorId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysTranslatorCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysTranslatorCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFSFItem> selectByPSSysValueRule(PSSysValueRuleBase pSSysValueRuleBase) throws Exception {
        return this.selectByPSSysValueRule(pSSysValueRuleBase, "", -1);
    }

    public ArrayList<PSDEFSFItem> selectByPSSysValueRule(PSSysValueRuleBase pSSysValueRuleBase, String string) throws Exception {
        return this.selectByPSSysValueRule(pSSysValueRuleBase, string, -1);
    }

    public ArrayList<PSDEFSFItem> selectByPSSysValueRule(PSSysValueRuleBase pSSysValueRuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSVALUERULEID", (Object)pSSysValueRuleBase.getPSSysValueRuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysValueRuleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysValueRuleCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByPSCodeList(pSCodeList, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCODELIST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSCodeList);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFSFITEM_PSCODELIST_PSCODELISTID", "", iDataEntityModel.getName(), "PSDEFSFITEM", iDataEntityModel.getDataInfo((IEntity)pSCodeList), arrayList.get(0)));
        }
    }

    public void resetPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByPSCodeList(pSCodeList);
        for (PSDEFSFItem pSDEFSFItem : arrayList) {
            PSDEFSFItem pSDEFSFItem2 = (PSDEFSFItem)this.getDEModel().createEntity();
            pSDEFSFItem2.setPSDEFSFItemId(pSDEFSFItem.getPSDEFSFItemId());
            pSDEFSFItem2.setPSCodeListId(null);
            this.update(pSDEFSFItem2);
        }
    }

    public void removeByPSCodeList(PSCodeList pSCodeList) throws Exception {
        final PSCodeList pSCodeList2 = pSCodeList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFSFItemServiceBase.this.onBeforeRemoveByPSCodeList(pSCodeList2);
                PSDEFSFItemServiceBase.this.internalRemoveByPSCodeList(pSCodeList2);
                PSDEFSFItemServiceBase.this.onAfterRemoveByPSCodeList(pSCodeList2);
            }
        });
    }

    protected void onBeforeRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void internalRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByPSCodeList(pSCodeList);
        this.onBeforeRemoveByPSCodeList(pSCodeList, arrayList);
        for (PSDEFSFItem pSDEFSFItem : arrayList) {
            this.remove((IEntity)pSDEFSFItem);
        }
        this.onAfterRemoveByPSCodeList(pSCodeList, arrayList);
    }

    protected void onAfterRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void onBeforeRemoveByPSCodeList(PSCodeList pSCodeList, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCodeList(PSCodeList pSCodeList, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFSFITEM_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSDEFSFITEM", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDEFSFItem pSDEFSFItem : arrayList) {
            PSDEFSFItem pSDEFSFItem2 = (PSDEFSFItem)this.getDEModel().createEntity();
            pSDEFSFItem2.setPSDEFSFItemId(pSDEFSFItem.getPSDEFSFItemId());
            pSDEFSFItem2.setPSDEId(null);
            this.update(pSDEFSFItem2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFSFItemServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDEFSFItemServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDEFSFItemServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDEFSFItem pSDEFSFItem : arrayList) {
            this.remove((IEntity)pSDEFSFItem);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    public void testRemoveByRefPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByRefPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFSFITEM_PSDATAENTITY_REFPSDEID", "", iDataEntityModel.getName(), "PSDEFSFITEM", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetRefPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByRefPSDE(pSDataEntity);
        for (PSDEFSFItem pSDEFSFItem : arrayList) {
            PSDEFSFItem pSDEFSFItem2 = (PSDEFSFItem)this.getDEModel().createEntity();
            pSDEFSFItem2.setPSDEFSFItemId(pSDEFSFItem.getPSDEFSFItemId());
            pSDEFSFItem2.setRefPSDEId(null);
            this.update(pSDEFSFItem2);
        }
    }

    public void removeByRefPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFSFItemServiceBase.this.onBeforeRemoveByRefPSDE(pSDataEntity2);
                PSDEFSFItemServiceBase.this.internalRemoveByRefPSDE(pSDataEntity2);
                PSDEFSFItemServiceBase.this.onAfterRemoveByRefPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByRefPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByRefPSDE(pSDataEntity);
        this.onBeforeRemoveByRefPSDE(pSDataEntity, arrayList);
        for (PSDEFSFItem pSDEFSFItem : arrayList) {
            this.remove((IEntity)pSDEFSFItem);
        }
        this.onAfterRemoveByRefPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByRefPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByRefPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDBValueOP(PSDBValueOP pSDBValueOP) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByPSDBValueOP(pSDBValueOP, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDBVALUEOP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDBValueOP);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFSFITEM_PSDBVALUEOP_PSDBVALUEOPID", "", iDataEntityModel.getName(), "PSDEFSFITEM", iDataEntityModel.getDataInfo((IEntity)pSDBValueOP), arrayList.get(0)));
        }
    }

    public void resetPSDBValueOP(PSDBValueOP pSDBValueOP) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByPSDBValueOP(pSDBValueOP);
        for (PSDEFSFItem pSDEFSFItem : arrayList) {
            PSDEFSFItem pSDEFSFItem2 = (PSDEFSFItem)this.getDEModel().createEntity();
            pSDEFSFItem2.setPSDEFSFItemId(pSDEFSFItem.getPSDEFSFItemId());
            pSDEFSFItem2.setPSDBValueOPId(null);
            this.update(pSDEFSFItem2);
        }
    }

    public void removeByPSDBValueOP(PSDBValueOP pSDBValueOP) throws Exception {
        final PSDBValueOP pSDBValueOP2 = pSDBValueOP;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFSFItemServiceBase.this.onBeforeRemoveByPSDBValueOP(pSDBValueOP2);
                PSDEFSFItemServiceBase.this.internalRemoveByPSDBValueOP(pSDBValueOP2);
                PSDEFSFItemServiceBase.this.onAfterRemoveByPSDBValueOP(pSDBValueOP2);
            }
        });
    }

    protected void onBeforeRemoveByPSDBValueOP(PSDBValueOP pSDBValueOP) throws Exception {
    }

    protected void internalRemoveByPSDBValueOP(PSDBValueOP pSDBValueOP) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByPSDBValueOP(pSDBValueOP);
        this.onBeforeRemoveByPSDBValueOP(pSDBValueOP, arrayList);
        for (PSDEFSFItem pSDEFSFItem : arrayList) {
            this.remove((IEntity)pSDEFSFItem);
        }
        this.onAfterRemoveByPSDBValueOP(pSDBValueOP, arrayList);
    }

    protected void onAfterRemoveByPSDBValueOP(PSDBValueOP pSDBValueOP) throws Exception {
    }

    protected void onBeforeRemoveByPSDBValueOP(PSDBValueOP pSDBValueOP, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDBValueOP(PSDBValueOP pSDBValueOP, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    public void testRemoveByRefPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByRefPSDEACMode(pSDEACMode, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACMODE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEACMode);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFSFITEM_PSDEACMODE_REFPSDEACMODEID", "", iDataEntityModel.getName(), "PSDEFSFITEM", iDataEntityModel.getDataInfo((IEntity)pSDEACMode), arrayList.get(0)));
        }
    }

    public void resetRefPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByRefPSDEACMode(pSDEACMode);
        for (PSDEFSFItem pSDEFSFItem : arrayList) {
            PSDEFSFItem pSDEFSFItem2 = (PSDEFSFItem)this.getDEModel().createEntity();
            pSDEFSFItem2.setPSDEFSFItemId(pSDEFSFItem.getPSDEFSFItemId());
            pSDEFSFItem2.setRefPSDEACModeId(null);
            this.update(pSDEFSFItem2);
        }
    }

    public void removeByRefPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
        final PSDEACMode pSDEACMode2 = pSDEACMode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFSFItemServiceBase.this.onBeforeRemoveByRefPSDEACMode(pSDEACMode2);
                PSDEFSFItemServiceBase.this.internalRemoveByRefPSDEACMode(pSDEACMode2);
                PSDEFSFItemServiceBase.this.onAfterRemoveByRefPSDEACMode(pSDEACMode2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
    }

    protected void internalRemoveByRefPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByRefPSDEACMode(pSDEACMode);
        this.onBeforeRemoveByRefPSDEACMode(pSDEACMode, arrayList);
        for (PSDEFSFItem pSDEFSFItem : arrayList) {
            this.remove((IEntity)pSDEFSFItem);
        }
        this.onAfterRemoveByRefPSDEACMode(pSDEACMode, arrayList);
    }

    protected void onAfterRemoveByRefPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
    }

    protected void onBeforeRemoveByRefPSDEACMode(PSDEACMode pSDEACMode, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSDEACMode(PSDEACMode pSDEACMode, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    public void testRemoveByRefPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByRefPSDEDataSet(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFSFITEM_PSDEDATASET_REFPSDEDATASETID", "", iDataEntityModel.getName(), "PSDEFSFITEM", iDataEntityModel.getDataInfo((IEntity)pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetRefPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByRefPSDEDataSet(pSDEDataSet);
        for (PSDEFSFItem pSDEFSFItem : arrayList) {
            PSDEFSFItem pSDEFSFItem2 = (PSDEFSFItem)this.getDEModel().createEntity();
            pSDEFSFItem2.setPSDEFSFItemId(pSDEFSFItem.getPSDEFSFItemId());
            pSDEFSFItem2.setRefPSDEDataSetId(null);
            this.update(pSDEFSFItem2);
        }
    }

    public void removeByRefPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFSFItemServiceBase.this.onBeforeRemoveByRefPSDEDataSet(pSDEDataSet2);
                PSDEFSFItemServiceBase.this.internalRemoveByRefPSDEDataSet(pSDEDataSet2);
                PSDEFSFItemServiceBase.this.onAfterRemoveByRefPSDEDataSet(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByRefPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByRefPSDEDataSet(pSDEDataSet);
        this.onBeforeRemoveByRefPSDEDataSet(pSDEDataSet, arrayList);
        for (PSDEFSFItem pSDEFSFItem : arrayList) {
            this.remove((IEntity)pSDEFSFItem);
        }
        this.onAfterRemoveByRefPSDEDataSet(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByRefPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByRefPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    public void resetPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByPSDEF(pSDEField);
        for (PSDEFSFItem pSDEFSFItem : arrayList) {
            PSDEFSFItem pSDEFSFItem2 = (PSDEFSFItem)this.getDEModel().createEntity();
            pSDEFSFItem2.setPSDEFSFItemId(pSDEFSFItem.getPSDEFSFItemId());
            pSDEFSFItem2.setPSDEFId(null);
            this.update(pSDEFSFItem2);
        }
    }

    public void removeByPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFSFItemServiceBase.this.onBeforeRemoveByPSDEF(pSDEField2);
                PSDEFSFItemServiceBase.this.internalRemoveByPSDEF(pSDEField2);
                PSDEFSFItemServiceBase.this.onAfterRemoveByPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByPSDEF(pSDEField);
        this.onBeforeRemoveByPSDEF(pSDEField, arrayList);
        for (PSDEFSFItem pSDEFSFItem : arrayList) {
            this.remove((IEntity)pSDEFSFItem);
        }
        this.onAfterRemoveByPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    public void testRemoveByDstPSDEFSFItem(PSDEFSFItem pSDEFSFItem) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByDstPSDEFSFItem(pSDEFSFItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFSFITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEFSFItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFSFITEM_PSDEFSFITEM_DSTPSDEFSFITEMID", "", iDataEntityModel.getName(), "PSDEFSFITEM", iDataEntityModel.getDataInfo((IEntity)pSDEFSFItem), arrayList.get(0)));
        }
    }

    public void resetDstPSDEFSFItem(PSDEFSFItem pSDEFSFItem) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByDstPSDEFSFItem(pSDEFSFItem);
        for (PSDEFSFItem pSDEFSFItem2 : arrayList) {
            PSDEFSFItem pSDEFSFItem3 = (PSDEFSFItem)this.getDEModel().createEntity();
            pSDEFSFItem3.setPSDEFSFItemId(pSDEFSFItem2.getPSDEFSFItemId());
            pSDEFSFItem3.setDstPSDEFSFItemId(null);
            this.update(pSDEFSFItem3);
        }
    }

    public void removeByDstPSDEFSFItem(PSDEFSFItem pSDEFSFItem) throws Exception {
        final PSDEFSFItem pSDEFSFItem2 = pSDEFSFItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFSFItemServiceBase.this.onBeforeRemoveByDstPSDEFSFItem(pSDEFSFItem2);
                PSDEFSFItemServiceBase.this.internalRemoveByDstPSDEFSFItem(pSDEFSFItem2);
                PSDEFSFItemServiceBase.this.onAfterRemoveByDstPSDEFSFItem(pSDEFSFItem2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSDEFSFItem(PSDEFSFItem pSDEFSFItem) throws Exception {
    }

    protected void internalRemoveByDstPSDEFSFItem(PSDEFSFItem pSDEFSFItem) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByDstPSDEFSFItem(pSDEFSFItem);
        this.onBeforeRemoveByDstPSDEFSFItem(pSDEFSFItem, arrayList);
        for (PSDEFSFItem pSDEFSFItem2 : arrayList) {
            this.remove((IEntity)pSDEFSFItem2);
        }
        this.onAfterRemoveByDstPSDEFSFItem(pSDEFSFItem, arrayList);
    }

    protected void onAfterRemoveByDstPSDEFSFItem(PSDEFSFItem pSDEFSFItem) throws Exception {
    }

    protected void onBeforeRemoveByDstPSDEFSFItem(PSDEFSFItem pSDEFSFItem, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSDEFSFItem(PSDEFSFItem pSDEFSFItem, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDEFValueRule(PSDEFValueRule pSDEFValueRule) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByPSDEFValueRule(pSDEFValueRule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFVALUERULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEFValueRule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFSFITEM_PSDEFVALUERULE_PSDEFVALUERULEID", "", iDataEntityModel.getName(), "PSDEFSFITEM", iDataEntityModel.getDataInfo((IEntity)pSDEFValueRule), arrayList.get(0)));
        }
    }

    public void resetPSDEFValueRule(PSDEFValueRule pSDEFValueRule) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByPSDEFValueRule(pSDEFValueRule);
        for (PSDEFSFItem pSDEFSFItem : arrayList) {
            PSDEFSFItem pSDEFSFItem2 = (PSDEFSFItem)this.getDEModel().createEntity();
            pSDEFSFItem2.setPSDEFSFItemId(pSDEFSFItem.getPSDEFSFItemId());
            pSDEFSFItem2.setPSDEFValueRuleId(null);
            this.update(pSDEFSFItem2);
        }
    }

    public void removeByPSDEFValueRule(PSDEFValueRule pSDEFValueRule) throws Exception {
        final PSDEFValueRule pSDEFValueRule2 = pSDEFValueRule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFSFItemServiceBase.this.onBeforeRemoveByPSDEFValueRule(pSDEFValueRule2);
                PSDEFSFItemServiceBase.this.internalRemoveByPSDEFValueRule(pSDEFValueRule2);
                PSDEFSFItemServiceBase.this.onAfterRemoveByPSDEFValueRule(pSDEFValueRule2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEFValueRule(PSDEFValueRule pSDEFValueRule) throws Exception {
    }

    protected void internalRemoveByPSDEFValueRule(PSDEFValueRule pSDEFValueRule) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByPSDEFValueRule(pSDEFValueRule);
        this.onBeforeRemoveByPSDEFValueRule(pSDEFValueRule, arrayList);
        for (PSDEFSFItem pSDEFSFItem : arrayList) {
            this.remove((IEntity)pSDEFSFItem);
        }
        this.onAfterRemoveByPSDEFValueRule(pSDEFValueRule, arrayList);
    }

    protected void onAfterRemoveByPSDEFValueRule(PSDEFValueRule pSDEFValueRule) throws Exception {
    }

    protected void onBeforeRemoveByPSDEFValueRule(PSDEFValueRule pSDEFValueRule, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEFValueRule(PSDEFValueRule pSDEFValueRule, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    public void testRemoveByRefADPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByRefADPSDELogic(pSDELogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDELogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFSFITEM_PSDELOGIC_REFADPSDELOGICID", "", iDataEntityModel.getName(), "PSDEFSFITEM", iDataEntityModel.getDataInfo((IEntity)pSDELogic), arrayList.get(0)));
        }
    }

    public void resetRefADPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByRefADPSDELogic(pSDELogic);
        for (PSDEFSFItem pSDEFSFItem : arrayList) {
            PSDEFSFItem pSDEFSFItem2 = (PSDEFSFItem)this.getDEModel().createEntity();
            pSDEFSFItem2.setPSDEFSFItemId(pSDEFSFItem.getPSDEFSFItemId());
            pSDEFSFItem2.setRefADPSDELogicId(null);
            this.update(pSDEFSFItem2);
        }
    }

    public void removeByRefADPSDELogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFSFItemServiceBase.this.onBeforeRemoveByRefADPSDELogic(pSDELogic2);
                PSDEFSFItemServiceBase.this.internalRemoveByRefADPSDELogic(pSDELogic2);
                PSDEFSFItemServiceBase.this.onAfterRemoveByRefADPSDELogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByRefADPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByRefADPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByRefADPSDELogic(pSDELogic);
        this.onBeforeRemoveByRefADPSDELogic(pSDELogic, arrayList);
        for (PSDEFSFItem pSDEFSFItem : arrayList) {
            this.remove((IEntity)pSDEFSFItem);
        }
        this.onAfterRemoveByRefADPSDELogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByRefADPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByRefADPSDELogic(PSDELogic pSDELogic, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefADPSDELogic(PSDELogic pSDELogic, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    public void testRemoveByRefPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByRefPSDER(pSDER, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDER);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFSFITEM_PSDER_REFPSDERID", "", iDataEntityModel.getName(), "PSDEFSFITEM", iDataEntityModel.getDataInfo((IEntity)pSDER), arrayList.get(0)));
        }
    }

    public void resetRefPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByRefPSDER(pSDER);
        for (PSDEFSFItem pSDEFSFItem : arrayList) {
            PSDEFSFItem pSDEFSFItem2 = (PSDEFSFItem)this.getDEModel().createEntity();
            pSDEFSFItem2.setPSDEFSFItemId(pSDEFSFItem.getPSDEFSFItemId());
            pSDEFSFItem2.setRefPSDERId(null);
            this.update(pSDEFSFItem2);
        }
    }

    public void removeByRefPSDER(PSDER pSDER) throws Exception {
        final PSDER pSDER2 = pSDER;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFSFItemServiceBase.this.onBeforeRemoveByRefPSDER(pSDER2);
                PSDEFSFItemServiceBase.this.internalRemoveByRefPSDER(pSDER2);
                PSDEFSFItemServiceBase.this.onAfterRemoveByRefPSDER(pSDER2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSDER(PSDER pSDER) throws Exception {
    }

    protected void internalRemoveByRefPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByRefPSDER(pSDER);
        this.onBeforeRemoveByRefPSDER(pSDER, arrayList);
        for (PSDEFSFItem pSDEFSFItem : arrayList) {
            this.remove((IEntity)pSDEFSFItem);
        }
        this.onAfterRemoveByRefPSDER(pSDER, arrayList);
    }

    protected void onAfterRemoveByRefPSDER(PSDER pSDER) throws Exception {
    }

    protected void onBeforeRemoveByRefPSDER(PSDER pSDER, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSDER(PSDER pSDER, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    public void testRemoveByRefMobMPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByRefMobMPickupPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFSFITEM_PSDEVIEWBASE_REFMOBMPICKUPPSDEVIEWID", "", iDataEntityModel.getName(), "PSDEFSFITEM", iDataEntityModel.getDataInfo((IEntity)pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetRefMobMPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByRefMobMPickupPSDEView(pSDEViewBase);
        for (PSDEFSFItem pSDEFSFItem : arrayList) {
            PSDEFSFItem pSDEFSFItem2 = (PSDEFSFItem)this.getDEModel().createEntity();
            pSDEFSFItem2.setPSDEFSFItemId(pSDEFSFItem.getPSDEFSFItemId());
            pSDEFSFItem2.setRefMobMPickupPSDEViewId(null);
            this.update(pSDEFSFItem2);
        }
    }

    public void removeByRefMobMPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFSFItemServiceBase.this.onBeforeRemoveByRefMobMPickupPSDEView(pSDEViewBase2);
                PSDEFSFItemServiceBase.this.internalRemoveByRefMobMPickupPSDEView(pSDEViewBase2);
                PSDEFSFItemServiceBase.this.onAfterRemoveByRefMobMPickupPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByRefMobMPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByRefMobMPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByRefMobMPickupPSDEView(pSDEViewBase);
        this.onBeforeRemoveByRefMobMPickupPSDEView(pSDEViewBase, arrayList);
        for (PSDEFSFItem pSDEFSFItem : arrayList) {
            this.remove((IEntity)pSDEFSFItem);
        }
        this.onAfterRemoveByRefMobMPickupPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByRefMobMPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByRefMobMPickupPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefMobMPickupPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    public void testRemoveByRefMobPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByRefMobPickupPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFSFITEM_PSDEVIEWBASE_REFMOBPICKUPPSDEVIEWID", "", iDataEntityModel.getName(), "PSDEFSFITEM", iDataEntityModel.getDataInfo((IEntity)pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetRefMobPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByRefMobPickupPSDEView(pSDEViewBase);
        for (PSDEFSFItem pSDEFSFItem : arrayList) {
            PSDEFSFItem pSDEFSFItem2 = (PSDEFSFItem)this.getDEModel().createEntity();
            pSDEFSFItem2.setPSDEFSFItemId(pSDEFSFItem.getPSDEFSFItemId());
            pSDEFSFItem2.setRefMobPickupPSDEViewId(null);
            this.update(pSDEFSFItem2);
        }
    }

    public void removeByRefMobPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFSFItemServiceBase.this.onBeforeRemoveByRefMobPickupPSDEView(pSDEViewBase2);
                PSDEFSFItemServiceBase.this.internalRemoveByRefMobPickupPSDEView(pSDEViewBase2);
                PSDEFSFItemServiceBase.this.onAfterRemoveByRefMobPickupPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByRefMobPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByRefMobPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByRefMobPickupPSDEView(pSDEViewBase);
        this.onBeforeRemoveByRefMobPickupPSDEView(pSDEViewBase, arrayList);
        for (PSDEFSFItem pSDEFSFItem : arrayList) {
            this.remove((IEntity)pSDEFSFItem);
        }
        this.onAfterRemoveByRefMobPickupPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByRefMobPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByRefMobPickupPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefMobPickupPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    public void testRemoveByRefMPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByRefMPickupPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFSFITEM_PSDEVIEWBASE_REFMPICKUPPSDEVIEWID", "", iDataEntityModel.getName(), "PSDEFSFITEM", iDataEntityModel.getDataInfo((IEntity)pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetRefMPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByRefMPickupPSDEView(pSDEViewBase);
        for (PSDEFSFItem pSDEFSFItem : arrayList) {
            PSDEFSFItem pSDEFSFItem2 = (PSDEFSFItem)this.getDEModel().createEntity();
            pSDEFSFItem2.setPSDEFSFItemId(pSDEFSFItem.getPSDEFSFItemId());
            pSDEFSFItem2.setRefMPickupPSDEViewId(null);
            this.update(pSDEFSFItem2);
        }
    }

    public void removeByRefMPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFSFItemServiceBase.this.onBeforeRemoveByRefMPickupPSDEView(pSDEViewBase2);
                PSDEFSFItemServiceBase.this.internalRemoveByRefMPickupPSDEView(pSDEViewBase2);
                PSDEFSFItemServiceBase.this.onAfterRemoveByRefMPickupPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByRefMPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByRefMPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByRefMPickupPSDEView(pSDEViewBase);
        this.onBeforeRemoveByRefMPickupPSDEView(pSDEViewBase, arrayList);
        for (PSDEFSFItem pSDEFSFItem : arrayList) {
            this.remove((IEntity)pSDEFSFItem);
        }
        this.onAfterRemoveByRefMPickupPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByRefMPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByRefMPickupPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefMPickupPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    public void testRemoveByRefPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByRefPickupPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFSFITEM_PSDEVIEWBASE_REFPICKUPPSDEVIEWID", "", iDataEntityModel.getName(), "PSDEFSFITEM", iDataEntityModel.getDataInfo((IEntity)pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetRefPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByRefPickupPSDEView(pSDEViewBase);
        for (PSDEFSFItem pSDEFSFItem : arrayList) {
            PSDEFSFItem pSDEFSFItem2 = (PSDEFSFItem)this.getDEModel().createEntity();
            pSDEFSFItem2.setPSDEFSFItemId(pSDEFSFItem.getPSDEFSFItemId());
            pSDEFSFItem2.setRefPickupPSDEViewId(null);
            this.update(pSDEFSFItem2);
        }
    }

    public void removeByRefPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFSFItemServiceBase.this.onBeforeRemoveByRefPickupPSDEView(pSDEViewBase2);
                PSDEFSFItemServiceBase.this.internalRemoveByRefPickupPSDEView(pSDEViewBase2);
                PSDEFSFItemServiceBase.this.onAfterRemoveByRefPickupPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByRefPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByRefPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByRefPickupPSDEView(pSDEViewBase);
        this.onBeforeRemoveByRefPickupPSDEView(pSDEViewBase, arrayList);
        for (PSDEFSFItem pSDEFSFItem : arrayList) {
            this.remove((IEntity)pSDEFSFItem);
        }
        this.onAfterRemoveByRefPickupPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByRefPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByRefPickupPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPickupPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    public void testRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByCapPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFSFITEM_PSLANGUAGERES_CAPPSLANRESID", "", iDataEntityModel.getName(), "PSDEFSFITEM", iDataEntityModel.getDataInfo((IEntity)pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByCapPSLanRes(pSLanguageRes);
        for (PSDEFSFItem pSDEFSFItem : arrayList) {
            PSDEFSFItem pSDEFSFItem2 = (PSDEFSFItem)this.getDEModel().createEntity();
            pSDEFSFItem2.setPSDEFSFItemId(pSDEFSFItem.getPSDEFSFItemId());
            pSDEFSFItem2.setCapPSLanResId(null);
            this.update(pSDEFSFItem2);
        }
    }

    public void removeByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFSFItemServiceBase.this.onBeforeRemoveByCapPSLanRes(pSLanguageRes2);
                PSDEFSFItemServiceBase.this.internalRemoveByCapPSLanRes(pSLanguageRes2);
                PSDEFSFItemServiceBase.this.onAfterRemoveByCapPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByCapPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByCapPSLanRes(pSLanguageRes, arrayList);
        for (PSDEFSFItem pSDEFSFItem : arrayList) {
            this.remove((IEntity)pSDEFSFItem);
        }
        this.onAfterRemoveByCapPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    public void testRemoveByPHPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByPHPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFSFITEM_PSLANGUAGERES_PHPSLANRESID", "", iDataEntityModel.getName(), "PSDEFSFITEM", iDataEntityModel.getDataInfo((IEntity)pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetPHPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByPHPSLanRes(pSLanguageRes);
        for (PSDEFSFItem pSDEFSFItem : arrayList) {
            PSDEFSFItem pSDEFSFItem2 = (PSDEFSFItem)this.getDEModel().createEntity();
            pSDEFSFItem2.setPSDEFSFItemId(pSDEFSFItem.getPSDEFSFItemId());
            pSDEFSFItem2.setPHPSLanResId(null);
            this.update(pSDEFSFItem2);
        }
    }

    public void removeByPHPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFSFItemServiceBase.this.onBeforeRemoveByPHPSLanRes(pSLanguageRes2);
                PSDEFSFItemServiceBase.this.internalRemoveByPHPSLanRes(pSLanguageRes2);
                PSDEFSFItemServiceBase.this.onAfterRemoveByPHPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByPHPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByPHPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByPHPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByPHPSLanRes(pSLanguageRes, arrayList);
        for (PSDEFSFItem pSDEFSFItem : arrayList) {
            this.remove((IEntity)pSDEFSFItem);
        }
        this.onAfterRemoveByPHPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByPHPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByPHPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPHPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDBVF(PSSysDBVF pSSysDBVF) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByPSSysDBVF(pSSysDBVF, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDBVF");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDBVF);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFSFITEM_PSSYSDBVF_PSSYSDBVFID", "", iDataEntityModel.getName(), "PSDEFSFITEM", iDataEntityModel.getDataInfo((IEntity)pSSysDBVF), arrayList.get(0)));
        }
    }

    public void resetPSSysDBVF(PSSysDBVF pSSysDBVF) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByPSSysDBVF(pSSysDBVF);
        for (PSDEFSFItem pSDEFSFItem : arrayList) {
            PSDEFSFItem pSDEFSFItem2 = (PSDEFSFItem)this.getDEModel().createEntity();
            pSDEFSFItem2.setPSDEFSFItemId(pSDEFSFItem.getPSDEFSFItemId());
            pSDEFSFItem2.setPSSysDBVFId(null);
            this.update(pSDEFSFItem2);
        }
    }

    public void removeByPSSysDBVF(PSSysDBVF pSSysDBVF) throws Exception {
        final PSSysDBVF pSSysDBVF2 = pSSysDBVF;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFSFItemServiceBase.this.onBeforeRemoveByPSSysDBVF(pSSysDBVF2);
                PSDEFSFItemServiceBase.this.internalRemoveByPSSysDBVF(pSSysDBVF2);
                PSDEFSFItemServiceBase.this.onAfterRemoveByPSSysDBVF(pSSysDBVF2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDBVF(PSSysDBVF pSSysDBVF) throws Exception {
    }

    protected void internalRemoveByPSSysDBVF(PSSysDBVF pSSysDBVF) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByPSSysDBVF(pSSysDBVF);
        this.onBeforeRemoveByPSSysDBVF(pSSysDBVF, arrayList);
        for (PSDEFSFItem pSDEFSFItem : arrayList) {
            this.remove((IEntity)pSDEFSFItem);
        }
        this.onAfterRemoveByPSSysDBVF(pSSysDBVF, arrayList);
    }

    protected void onAfterRemoveByPSSysDBVF(PSSysDBVF pSSysDBVF) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDBVF(PSSysDBVF pSSysDBVF, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDBVF(PSSysDBVF pSSysDBVF, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByPSSysEditorStyle(pSSysEditorStyle, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSEDITORSTYLE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysEditorStyle);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFSFITEM_PSSYSEDITORSTYLE_PSSYSEDITORSTYLEID", "", iDataEntityModel.getName(), "PSDEFSFITEM", iDataEntityModel.getDataInfo((IEntity)pSSysEditorStyle), arrayList.get(0)));
        }
    }

    public void resetPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByPSSysEditorStyle(pSSysEditorStyle);
        for (PSDEFSFItem pSDEFSFItem : arrayList) {
            PSDEFSFItem pSDEFSFItem2 = (PSDEFSFItem)this.getDEModel().createEntity();
            pSDEFSFItem2.setPSDEFSFItemId(pSDEFSFItem.getPSDEFSFItemId());
            pSDEFSFItem2.setPSSysEditorStyleId(null);
            this.update(pSDEFSFItem2);
        }
    }

    public void removeByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle) throws Exception {
        final PSSysEditorStyle pSSysEditorStyle2 = pSSysEditorStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFSFItemServiceBase.this.onBeforeRemoveByPSSysEditorStyle(pSSysEditorStyle2);
                PSDEFSFItemServiceBase.this.internalRemoveByPSSysEditorStyle(pSSysEditorStyle2);
                PSDEFSFItemServiceBase.this.onAfterRemoveByPSSysEditorStyle(pSSysEditorStyle2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle) throws Exception {
    }

    protected void internalRemoveByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByPSSysEditorStyle(pSSysEditorStyle);
        this.onBeforeRemoveByPSSysEditorStyle(pSSysEditorStyle, arrayList);
        for (PSDEFSFItem pSDEFSFItem : arrayList) {
            this.remove((IEntity)pSDEFSFItem);
        }
        this.onAfterRemoveByPSSysEditorStyle(pSSysEditorStyle, arrayList);
    }

    protected void onAfterRemoveByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle) throws Exception {
    }

    protected void onBeforeRemoveByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByPSSysImage(pSSysImage, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSIMAGE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysImage);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFSFITEM_PSSYSIMAGE_PSSYSIMAGEID", "", iDataEntityModel.getName(), "PSDEFSFITEM", iDataEntityModel.getDataInfo((IEntity)pSSysImage), arrayList.get(0)));
        }
    }

    public void resetPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByPSSysImage(pSSysImage);
        for (PSDEFSFItem pSDEFSFItem : arrayList) {
            PSDEFSFItem pSDEFSFItem2 = (PSDEFSFItem)this.getDEModel().createEntity();
            pSDEFSFItem2.setPSDEFSFItemId(pSDEFSFItem.getPSDEFSFItemId());
            pSDEFSFItem2.setPSSysImageId(null);
            this.update(pSDEFSFItem2);
        }
    }

    public void removeByPSSysImage(PSSysImage pSSysImage) throws Exception {
        final PSSysImage pSSysImage2 = pSSysImage;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFSFItemServiceBase.this.onBeforeRemoveByPSSysImage(pSSysImage2);
                PSDEFSFItemServiceBase.this.internalRemoveByPSSysImage(pSSysImage2);
                PSDEFSFItemServiceBase.this.onAfterRemoveByPSSysImage(pSSysImage2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void internalRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByPSSysImage(pSSysImage);
        this.onBeforeRemoveByPSSysImage(pSSysImage, arrayList);
        for (PSDEFSFItem pSDEFSFItem : arrayList) {
            this.remove((IEntity)pSDEFSFItem);
        }
        this.onAfterRemoveByPSSysImage(pSSysImage, arrayList);
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFSFITEM_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSDEFSFITEM", iDataEntityModel.getDataInfo((IEntity)pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSDEFSFItem pSDEFSFItem : arrayList) {
            PSDEFSFItem pSDEFSFItem2 = (PSDEFSFItem)this.getDEModel().createEntity();
            pSDEFSFItem2.setPSDEFSFItemId(pSDEFSFItem.getPSDEFSFItemId());
            pSDEFSFItem2.setPSSysSFPluginId(null);
            this.update(pSDEFSFItem2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFSFItemServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSDEFSFItemServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSDEFSFItemServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSDEFSFItem pSDEFSFItem : arrayList) {
            this.remove((IEntity)pSDEFSFItem);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByPSSysTranslator(pSSysTranslator, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTRANSLATOR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysTranslator);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFSFITEM_PSSYSTRANSLATOR_PSSYSTRANSLATORID", "", iDataEntityModel.getName(), "PSDEFSFITEM", iDataEntityModel.getDataInfo((IEntity)pSSysTranslator), arrayList.get(0)));
        }
    }

    public void resetPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByPSSysTranslator(pSSysTranslator);
        for (PSDEFSFItem pSDEFSFItem : arrayList) {
            PSDEFSFItem pSDEFSFItem2 = (PSDEFSFItem)this.getDEModel().createEntity();
            pSDEFSFItem2.setPSDEFSFItemId(pSDEFSFItem.getPSDEFSFItemId());
            pSDEFSFItem2.setPSSysTranslatorId(null);
            this.update(pSDEFSFItem2);
        }
    }

    public void removeByPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
        final PSSysTranslator pSSysTranslator2 = pSSysTranslator;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFSFItemServiceBase.this.onBeforeRemoveByPSSysTranslator(pSSysTranslator2);
                PSDEFSFItemServiceBase.this.internalRemoveByPSSysTranslator(pSSysTranslator2);
                PSDEFSFItemServiceBase.this.onAfterRemoveByPSSysTranslator(pSSysTranslator2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
    }

    protected void internalRemoveByPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByPSSysTranslator(pSSysTranslator);
        this.onBeforeRemoveByPSSysTranslator(pSSysTranslator, arrayList);
        for (PSDEFSFItem pSDEFSFItem : arrayList) {
            this.remove((IEntity)pSDEFSFItem);
        }
        this.onAfterRemoveByPSSysTranslator(pSSysTranslator, arrayList);
    }

    protected void onAfterRemoveByPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
    }

    protected void onBeforeRemoveByPSSysTranslator(PSSysTranslator pSSysTranslator, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysTranslator(PSSysTranslator pSSysTranslator, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByPSSysValueRule(pSSysValueRule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVALUERULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysValueRule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFSFITEM_PSSYSVALUERULE_PSSYSVALUERULEID", "", iDataEntityModel.getName(), "PSDEFSFITEM", iDataEntityModel.getDataInfo((IEntity)pSSysValueRule), arrayList.get(0)));
        }
    }

    public void resetPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByPSSysValueRule(pSSysValueRule);
        for (PSDEFSFItem pSDEFSFItem : arrayList) {
            PSDEFSFItem pSDEFSFItem2 = (PSDEFSFItem)this.getDEModel().createEntity();
            pSDEFSFItem2.setPSDEFSFItemId(pSDEFSFItem.getPSDEFSFItemId());
            pSDEFSFItem2.setPSSysValueRuleId(null);
            this.update(pSDEFSFItem2);
        }
    }

    public void removeByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        final PSSysValueRule pSSysValueRule2 = pSSysValueRule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFSFItemServiceBase.this.onBeforeRemoveByPSSysValueRule(pSSysValueRule2);
                PSDEFSFItemServiceBase.this.internalRemoveByPSSysValueRule(pSSysValueRule2);
                PSDEFSFItemServiceBase.this.onAfterRemoveByPSSysValueRule(pSSysValueRule2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
    }

    protected void internalRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        ArrayList<PSDEFSFItem> arrayList = this.selectByPSSysValueRule(pSSysValueRule);
        this.onBeforeRemoveByPSSysValueRule(pSSysValueRule, arrayList);
        for (PSDEFSFItem pSDEFSFItem : arrayList) {
            this.remove((IEntity)pSDEFSFItem);
        }
        this.onAfterRemoveByPSSysValueRule(pSSysValueRule, arrayList);
    }

    protected void onAfterRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
    }

    protected void onBeforeRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule, ArrayList<PSDEFSFItem> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEFSFItem pSDEFSFItem) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEDSParamService)ServiceGlobal.getService(PSDEDSParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDSParamServiceBase)pSCoreSysServiceBase).testRemoveByPSDEFSFItem(pSDEFSFItem);
        pSCoreSysServiceBase = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSDEFSFItem(pSDEFSFItem);
        pSCoreSysServiceBase = (PSDEFSFItemService)ServiceGlobal.getService(PSDEFSFItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFSFItemServiceBase)pSCoreSysServiceBase).testRemoveByDstPSDEFSFItem(pSDEFSFItem);
        pSCoreSysServiceBase = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridColServiceBase)pSCoreSysServiceBase).testRemoveByPSDEFSFItem(pSDEFSFItem);
        pSCoreSysServiceBase = (PSSysSearchBarItemService)ServiceGlobal.getService(PSSysSearchBarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSearchBarItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDEFSFItem(pSDEFSFItem);
        super.onBeforeRemove(pSDEFSFItem);
    }

    protected void replaceParentInfo(PSDEFSFItem pSDEFSFItem, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDEFSFItem, cloneSession);
        if (pSDEFSFItem.getPSCodeListId() != null && (iEntity = cloneSession.getEntity("PSCODELIST", (Object)pSDEFSFItem.getPSCodeListId())) != null) {
            this.onFillParentInfo_PSCodeList(pSDEFSFItem, (PSCodeList)iEntity);
        }
        if (pSDEFSFItem.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEFSFItem.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDEFSFItem, (PSDataEntity)iEntity);
        }
        if (pSDEFSFItem.getRefPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEFSFItem.getRefPSDEId())) != null) {
            this.onFillParentInfo_RefPSDE(pSDEFSFItem, (PSDataEntity)iEntity);
        }
        if (pSDEFSFItem.getPSDBValueOPId() != null && (iEntity = cloneSession.getEntity("PSDBVALUEOP", (Object)pSDEFSFItem.getPSDBValueOPId())) != null) {
            this.onFillParentInfo_PSDBValueOP(pSDEFSFItem, (PSDBValueOP)iEntity);
        }
        if (pSDEFSFItem.getRefPSDEACModeId() != null && (iEntity = cloneSession.getEntity("PSDEACMODE", (Object)pSDEFSFItem.getRefPSDEACModeId())) != null) {
            this.onFillParentInfo_RefPSDEACMode(pSDEFSFItem, (PSDEACMode)iEntity);
        }
        if (pSDEFSFItem.getRefPSDEDataSetId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSDEFSFItem.getRefPSDEDataSetId())) != null) {
            this.onFillParentInfo_RefPSDEDataSet(pSDEFSFItem, (PSDEDataSet)iEntity);
        }
        if (pSDEFSFItem.getPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEFSFItem.getPSDEFId())) != null) {
            this.onFillParentInfo_PSDEF(pSDEFSFItem, (PSDEField)iEntity);
        }
        if (pSDEFSFItem.getDstPSDEFSFItemId() != null && (iEntity = cloneSession.getEntity("PSDEFSFITEM", (Object)pSDEFSFItem.getDstPSDEFSFItemId())) != null) {
            this.onFillParentInfo_DstPSDEFSFItem(pSDEFSFItem, (PSDEFSFItem)iEntity);
        }
        if (pSDEFSFItem.getPSDEFValueRuleId() != null && (iEntity = cloneSession.getEntity("PSDEFVALUERULE", (Object)pSDEFSFItem.getPSDEFValueRuleId())) != null) {
            this.onFillParentInfo_PSDEFValueRule(pSDEFSFItem, (PSDEFValueRule)iEntity);
        }
        if (pSDEFSFItem.getRefADPSDELogicId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSDEFSFItem.getRefADPSDELogicId())) != null) {
            this.onFillParentInfo_RefADPSDELogic(pSDEFSFItem, (PSDELogic)iEntity);
        }
        if (pSDEFSFItem.getRefPSDERId() != null && (iEntity = cloneSession.getEntity("PSDER", (Object)pSDEFSFItem.getRefPSDERId())) != null) {
            this.onFillParentInfo_RefPSDER(pSDEFSFItem, (PSDER)iEntity);
        }
        if (pSDEFSFItem.getRefMobMPickupPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSDEFSFItem.getRefMobMPickupPSDEViewId())) != null) {
            this.onFillParentInfo_RefMobMPickupPSDEView(pSDEFSFItem, (PSDEViewBase)iEntity);
        }
        if (pSDEFSFItem.getRefMobPickupPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSDEFSFItem.getRefMobPickupPSDEViewId())) != null) {
            this.onFillParentInfo_RefMobPickupPSDEView(pSDEFSFItem, (PSDEViewBase)iEntity);
        }
        if (pSDEFSFItem.getRefMPickupPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSDEFSFItem.getRefMPickupPSDEViewId())) != null) {
            this.onFillParentInfo_RefMPickupPSDEView(pSDEFSFItem, (PSDEViewBase)iEntity);
        }
        if (pSDEFSFItem.getRefPickupPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSDEFSFItem.getRefPickupPSDEViewId())) != null) {
            this.onFillParentInfo_RefPickupPSDEView(pSDEFSFItem, (PSDEViewBase)iEntity);
        }
        if (pSDEFSFItem.getCapPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEFSFItem.getCapPSLanResId())) != null) {
            this.onFillParentInfo_CapPSLanRes(pSDEFSFItem, (PSLanguageRes)iEntity);
        }
        if (pSDEFSFItem.getPHPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEFSFItem.getPHPSLanResId())) != null) {
            this.onFillParentInfo_PHPSLanRes(pSDEFSFItem, (PSLanguageRes)iEntity);
        }
        if (pSDEFSFItem.getPSSysDBVFId() != null && (iEntity = cloneSession.getEntity("PSSYSDBVF", (Object)pSDEFSFItem.getPSSysDBVFId())) != null) {
            this.onFillParentInfo_PSSysDBVF(pSDEFSFItem, (PSSysDBVF)iEntity);
        }
        if (pSDEFSFItem.getPSSysEditorStyleId() != null && (iEntity = cloneSession.getEntity("PSSYSEDITORSTYLE", (Object)pSDEFSFItem.getPSSysEditorStyleId())) != null) {
            this.onFillParentInfo_PSSysEditorStyle(pSDEFSFItem, (PSSysEditorStyle)iEntity);
        }
        if (pSDEFSFItem.getPSSysImageId() != null && (iEntity = cloneSession.getEntity("PSSYSIMAGE", (Object)pSDEFSFItem.getPSSysImageId())) != null) {
            this.onFillParentInfo_PSSysImage(pSDEFSFItem, (PSSysImage)iEntity);
        }
        if (pSDEFSFItem.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSDEFSFItem.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSDEFSFItem, (PSSysSFPlugin)iEntity);
        }
        if (pSDEFSFItem.getPSSysTranslatorId() != null && (iEntity = cloneSession.getEntity("PSSYSTRANSLATOR", (Object)pSDEFSFItem.getPSSysTranslatorId())) != null) {
            this.onFillParentInfo_PSSysTranslator(pSDEFSFItem, (PSSysTranslator)iEntity);
        }
        if (pSDEFSFItem.getPSSysValueRuleId() != null && (iEntity = cloneSession.getEntity("PSSYSVALUERULE", (Object)pSDEFSFItem.getPSSysValueRuleId())) != null) {
            this.onFillParentInfo_PSSysValueRule(pSDEFSFItem, (PSSysValueRule)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEFSFItem pSDEFSFItem, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEFSFItem, bl);
        pSDEFSFItem.resetPSDEFSFItemName();
    }

    protected void onCheckEntity(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ArrayFlag(bl, pSDEFSFItem, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CapPSLanResId(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CapPSLanResName(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Caption(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultFlag(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDEFSFItemId(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EditorType(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EditorTypeName(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExtendMode(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Height(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemTag(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemTag2(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_JsonFormat(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PHPSLanResId(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PHPSLanResName(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PlaceHolder(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCodeListId(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDBValueOPId(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDBValueOPName(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFId(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFName(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFSFItemId(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFSFItemName(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFValueRuleId(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDBVFId(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDBVFName(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysEditorStyleId(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysImageId(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTranslatorId(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysValueRuleId(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefADPSDELogicId(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefMobMPickupPSDEViewId(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefMobPickupPSDEViewId(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefMPickupPSDEViewId(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPickupPSDEViewId(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDEACModeId(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDEDataSetId(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDEId(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDEName(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDERId(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDERName(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SearchMode(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServiceCodeName(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserParams(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValueFormat(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValueSeperator(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Width(bl, pSDEFSFItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEFSFItem, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ArrayFlag(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isArrayFlagDirty() : !pSDEFSFItem.isArrayFlagDirty()) {
            return null;
        }
        Integer n = pSDEFSFItem.getArrayFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ArrayFlag_Default((IEntity)pSDEFSFItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ARRAYFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CapPSLanResId(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isCapPSLanResIdDirty() : !pSDEFSFItem.isCapPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getCapPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CapPSLanResId_Default((IEntity)pSDEFSFItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CAPPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CapPSLanResName(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isCapPSLanResNameDirty() : !pSDEFSFItem.isCapPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getCapPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CapPSLanResName_Default((IEntity)pSDEFSFItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CAPPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Caption(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isCaptionDirty() : !pSDEFSFItem.isCaptionDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getCaption();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Caption_Default((IEntity)pSDEFSFItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CAPTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isCodeNameDirty() : !pSDEFSFItem.isCodeNameDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSDEFSFItem, bl2, bl3);
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
                string3 = "PSDEID";
                String string4 = this.checkFieldDupRule(this.getPSDEFSFItemDEModel(), "CODENAME", string3, pSDEFSFItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_DefaultFlag(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isDefaultFlagDirty() : !pSDEFSFItem.isDefaultFlagDirty()) {
            return null;
        }
        Integer n = pSDEFSFItem.getDefaultFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DefaultFlag_Default((IEntity)pSDEFSFItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            bl4 = DataTypeHelper.compare((int)9, (Object)n, (Object)"1") == 0L;
            if (bl4) {
                String string = "";
                string = "PSDEFID";
                String string2 = this.checkFieldDupRule(this.getPSDEFSFItemDEModel(), "DEFAULTFLAG", string, pSDEFSFItem, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("DEFAULTFLAG");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string2);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDEFSFItemId(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isDstPSDEFSFItemIdDirty() : !pSDEFSFItem.isDstPSDEFSFItemIdDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getDstPSDEFSFItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDEFSFItemId_Default((IEntity)pSDEFSFItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDEFSFITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EditorType(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isEditorTypeDirty() : !pSDEFSFItem.isEditorTypeDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getEditorType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EditorType_Default((IEntity)pSDEFSFItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EDITORTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EditorTypeName(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isEditorTypeNameDirty() : !pSDEFSFItem.isEditorTypeNameDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getEditorTypeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EditorTypeName_Default((IEntity)pSDEFSFItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EDITORTYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExtendMode(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isExtendModeDirty() : !pSDEFSFItem.isExtendModeDirty()) {
            return null;
        }
        Integer n = pSDEFSFItem.getExtendMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExtendMode_Default((IEntity)pSDEFSFItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXTENDMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Height(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isHeightDirty() : !pSDEFSFItem.isHeightDirty()) {
            return null;
        }
        Integer n = pSDEFSFItem.getHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Height_Default((IEntity)pSDEFSFItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HEIGHT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemTag(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isItemTagDirty() : !pSDEFSFItem.isItemTagDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getItemTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemTag_Default((IEntity)pSDEFSFItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemTag2(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isItemTag2Dirty() : !pSDEFSFItem.isItemTag2Dirty()) {
            return null;
        }
        String string = pSDEFSFItem.getItemTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemTag2_Default((IEntity)pSDEFSFItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_JsonFormat(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isJsonFormatDirty() : !pSDEFSFItem.isJsonFormatDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getJsonFormat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_JsonFormat_Default((IEntity)pSDEFSFItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("JSONFORMAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isLockFlagDirty() : !pSDEFSFItem.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSDEFSFItem.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default((IEntity)pSDEFSFItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isMemoDirty() : !pSDEFSFItem.isMemoDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDEFSFItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PHPSLanResId(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isPHPSLanResIdDirty() : !pSDEFSFItem.isPHPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getPHPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PHPSLanResId_Default((IEntity)pSDEFSFItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PHPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PHPSLanResName(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isPHPSLanResNameDirty() : !pSDEFSFItem.isPHPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getPHPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PHPSLanResName_Default((IEntity)pSDEFSFItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PHPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PlaceHolder(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isPlaceHolderDirty() : !pSDEFSFItem.isPlaceHolderDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getPlaceHolder();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PlaceHolder_Default((IEntity)pSDEFSFItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PLACEHOLDER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCodeListId(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isPSCodeListIdDirty() : !pSDEFSFItem.isPSCodeListIdDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getPSCodeListId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCodeListId_Default((IEntity)pSDEFSFItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCODELISTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDBValueOPId(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isPSDBValueOPIdDirty() && !bl2 : !pSDEFSFItem.isPSDBValueOPIdDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getPSDBValueOPId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBVALUEOPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDBValueOPId_Default((IEntity)pSDEFSFItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDBValueOPName(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isPSDBValueOPNameDirty() && !bl2 : !pSDEFSFItem.isPSDBValueOPNameDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getPSDBValueOPName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBVALUEOPNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDBValueOPName_Default((IEntity)pSDEFSFItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFId(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isPSDEFIdDirty() && !bl2 : !pSDEFSFItem.isPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getPSDEFId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFId_PSDEF((IEntity)pSDEFSFItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_PSDEFId_Default((IEntity)pSDEFSFItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFName(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isPSDEFNameDirty() && !bl2 : !pSDEFSFItem.isPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getPSDEFName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFName_Default((IEntity)pSDEFSFItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFSFItemId(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isPSDEFSFItemIdDirty() && !bl2 : !pSDEFSFItem.isPSDEFSFItemIdDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getPSDEFSFItemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFSFITEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFSFItemId_Default((IEntity)pSDEFSFItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFSFITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFSFItemName(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isPSDEFSFItemNameDirty() && !bl2 : !pSDEFSFItem.isPSDEFSFItemNameDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getPSDEFSFItemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFSFITEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFSFItemName_Default((IEntity)pSDEFSFItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFSFITEMNAME");
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
                string3 = "PSDEID";
                String string4 = this.checkFieldDupRule(this.getPSDEFSFItemDEModel(), "PSDEFSFITEMNAME", string3, pSDEFSFItem, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEFSFITEMNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFValueRuleId(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isPSDEFValueRuleIdDirty() : !pSDEFSFItem.isPSDEFValueRuleIdDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getPSDEFValueRuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFValueRuleId_Default((IEntity)pSDEFSFItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFVALUERULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isPSDEIdDirty() && !bl2 : !pSDEFSFItem.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSDEFSFItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isPSDENameDirty() && !bl2 : !pSDEFSFItem.isPSDENameDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default((IEntity)pSDEFSFItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDBVFId(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isPSSysDBVFIdDirty() : !pSDEFSFItem.isPSSysDBVFIdDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getPSSysDBVFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDBVFId_Default((IEntity)pSDEFSFItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDBVFName(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isPSSysDBVFNameDirty() : !pSDEFSFItem.isPSSysDBVFNameDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getPSSysDBVFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDBVFName_Default((IEntity)pSDEFSFItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysEditorStyleId(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isPSSysEditorStyleIdDirty() : !pSDEFSFItem.isPSSysEditorStyleIdDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getPSSysEditorStyleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysEditorStyleId_Default((IEntity)pSDEFSFItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEDITORSTYLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysImageId(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isPSSysImageIdDirty() : !pSDEFSFItem.isPSSysImageIdDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getPSSysImageId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysImageId_Default((IEntity)pSDEFSFItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isPSSysSFPluginIdDirty() : !pSDEFSFItem.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default((IEntity)pSDEFSFItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysTranslatorId(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isPSSysTranslatorIdDirty() : !pSDEFSFItem.isPSSysTranslatorIdDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getPSSysTranslatorId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysTranslatorId_Default((IEntity)pSDEFSFItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTRANSLATORID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysValueRuleId(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isPSSysValueRuleIdDirty() : !pSDEFSFItem.isPSSysValueRuleIdDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getPSSysValueRuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysValueRuleId_Default((IEntity)pSDEFSFItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVALUERULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefADPSDELogicId(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isRefADPSDELogicIdDirty() : !pSDEFSFItem.isRefADPSDELogicIdDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getRefADPSDELogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefADPSDELogicId_Default((IEntity)pSDEFSFItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFADPSDELOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefMobMPickupPSDEViewId(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isRefMobMPickupPSDEViewIdDirty() : !pSDEFSFItem.isRefMobMPickupPSDEViewIdDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getRefMobMPickupPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefMobMPickupPSDEViewId_Default((IEntity)pSDEFSFItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFMOBMPICKUPPSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefMobPickupPSDEViewId(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isRefMobPickupPSDEViewIdDirty() : !pSDEFSFItem.isRefMobPickupPSDEViewIdDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getRefMobPickupPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefMobPickupPSDEViewId_Default((IEntity)pSDEFSFItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFMOBPICKUPPSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefMPickupPSDEViewId(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isRefMPickupPSDEViewIdDirty() : !pSDEFSFItem.isRefMPickupPSDEViewIdDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getRefMPickupPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefMPickupPSDEViewId_Default((IEntity)pSDEFSFItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFMPICKUPPSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPickupPSDEViewId(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isRefPickupPSDEViewIdDirty() : !pSDEFSFItem.isRefPickupPSDEViewIdDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getRefPickupPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPickupPSDEViewId_Default((IEntity)pSDEFSFItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPICKUPPSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSDEACModeId(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isRefPSDEACModeIdDirty() : !pSDEFSFItem.isRefPSDEACModeIdDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getRefPSDEACModeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDEACModeId_Default((IEntity)pSDEFSFItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDEACMODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSDEDataSetId(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isRefPSDEDataSetIdDirty() : !pSDEFSFItem.isRefPSDEDataSetIdDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getRefPSDEDataSetId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDEDataSetId_Default((IEntity)pSDEFSFItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDEDATASETID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSDEId(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isRefPSDEIdDirty() : !pSDEFSFItem.isRefPSDEIdDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getRefPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDEId_Default((IEntity)pSDEFSFItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSDEName(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isRefPSDENameDirty() : !pSDEFSFItem.isRefPSDENameDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getRefPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDEName_Default((IEntity)pSDEFSFItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSDERId(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isRefPSDERIdDirty() : !pSDEFSFItem.isRefPSDERIdDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getRefPSDERId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDERId_Default((IEntity)pSDEFSFItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSDERName(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isRefPSDERNameDirty() : !pSDEFSFItem.isRefPSDERNameDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getRefPSDERName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDERName_Default((IEntity)pSDEFSFItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SearchMode(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isSearchModeDirty() : !pSDEFSFItem.isSearchModeDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getSearchMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SearchMode_Default((IEntity)pSDEFSFItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SEARCHMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ServiceCodeName(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isServiceCodeNameDirty() : !pSDEFSFItem.isServiceCodeNameDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getServiceCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServiceCodeName_Default((IEntity)pSDEFSFItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isUserCatDirty() : !pSDEFSFItem.isUserCatDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSDEFSFItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserParams(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isUserParamsDirty() : !pSDEFSFItem.isUserParamsDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getUserParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserParams_Default((IEntity)pSDEFSFItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isUserTagDirty() : !pSDEFSFItem.isUserTagDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDEFSFItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isUserTag2Dirty() : !pSDEFSFItem.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEFSFItem.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDEFSFItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isUserTag3Dirty() : !pSDEFSFItem.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEFSFItem.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSDEFSFItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isUserTag4Dirty() : !pSDEFSFItem.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEFSFItem.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSDEFSFItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValueFormat(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isValueFormatDirty() : !pSDEFSFItem.isValueFormatDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getValueFormat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ValueFormat_Default((IEntity)pSDEFSFItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALUEFORMAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValueSeperator(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isValueSeperatorDirty() : !pSDEFSFItem.isValueSeperatorDirty()) {
            return null;
        }
        String string = pSDEFSFItem.getValueSeperator();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ValueSeperator_Default((IEntity)pSDEFSFItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALUESEPERATOR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Width(boolean bl, PSDEFSFItem pSDEFSFItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFSFItem.isWidthDirty() : !pSDEFSFItem.isWidthDirty()) {
            return null;
        }
        Integer n = pSDEFSFItem.getWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Width_Default((IEntity)pSDEFSFItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WIDTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDEFSFItem pSDEFSFItem, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEFSFItem, bl);
    }

    protected void onSyncIndexEntities(PSDEFSFItem pSDEFSFItem, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEFSFItem, bl);
    }

    public Object getDataContextValue(PSDEFSFItem pSDEFSFItem, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEACMODE", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFPSDEACMODEID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFPSDEACMODENAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDEFSFItem, "refpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEDATASET", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFPSDEDATASETID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFPSDEDATASETNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDEFSFItem, "refpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDELOGIC", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFADPSDELOGICID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFADPSDELOGICNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDEFSFItem, "refpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEVIEWBASE", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFMPICKUPPSDEVIEWID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFMPICKUPPSDEVIEWNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDEFSFItem, "refpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEVIEWBASE", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFPICKUPPSDEVIEWID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFPICKUPPSDEVIEWNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDEFSFItem, "refpsdeid", iDataContextParam)) != null) {
                return object;
            }
        }
        if ((object = super.getDataContextValue((IEntity)pSDEFSFItem, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEField pSDEField = pSDEFSFItem.getPSDEF();
        if (pSDEField != null && pSDEField.contains(string)) {
            return pSDEField.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEFSFItem pSDEFSFItem, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportMajorModel_CapPSLanRes(pSDEFSFItem, arrayList, n);
        this.onExportMajorModel_PHPSLanRes(pSDEFSFItem, arrayList, n);
        super.onExportMajorModel((IEntity)pSDEFSFItem, arrayList, n);
    }

    protected void onExportMajorModel_CapPSLanRes(PSDEFSFItem pSDEFSFItem, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSDEFSFItem.getCapPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel((IEntity)pSDEFSFItem.getCapPSLanRes(), arrayList, n);
        }
    }

    protected void onExportMajorModel_PHPSLanRes(PSDEFSFItem pSDEFSFItem, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSDEFSFItem.getPHPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel((IEntity)pSDEFSFItem.getPHPSLanRes(), arrayList, n);
        }
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ARRAYFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ArrayFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CAPPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CapPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CAPPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CapPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CAPTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Caption_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"DEFAULTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEFSFITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEFSFItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEFSFITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEFSFItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EDITORTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EditorType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EDITORTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EditorTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXTENDMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExtendMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HEIGHT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Height_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"JSONFORMAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_JsonFormat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"O2MPSDERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_O2MPSDERId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"O2OPSDERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_O2OPSDERId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PHPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PHPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PHPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PHPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PLACEHOLDER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PlaceHolder_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCODELISTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCodeListId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCODELISTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCodeListName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDBVALUEOPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBValueOPId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDBVALUEOPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBValueOPName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"PSDEF", (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFId_PSDEF(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFSFITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFSFItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFSFITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFSFItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFVALUERULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFValueRuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFVALUERULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFValueRuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDBVFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDBVFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDBVFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDBVFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEDITORSTYLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEditorStyleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEDITORSTYLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEditorStyleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSIMAGEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysImageId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSIMAGENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysImageName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTRANSLATORID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTranslatorId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTRANSLATORNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTranslatorName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVALUERULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysValueRuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVALUERULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysValueRuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFADPSDELOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefADPSDELogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFADPSDELOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefADPSDELogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFMOBMPICKUPPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefMobMPickupPSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFMOBMPICKUPPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefMobMPickupPSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFMOBPICKUPPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefMobPickupPSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFMOBPICKUPPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefMobPickupPSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFMPICKUPPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefMPickupPSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFMPICKUPPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefMPickupPSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPICKUPPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPickupPSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPICKUPPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPickupPSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEACMODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDEACModeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEACMODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDEACModeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEDATASETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDEDataSetId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEDATASETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDEDataSetName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDERId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDERName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SEARCHMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SearchMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERVICECODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ServiceCodeName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VALUEFORMAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValueFormat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALUESEPERATOR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValueSeperator_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Width_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_ArrayFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CapPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CAPPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CapPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CAPPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Caption_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CAPTION", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected String onTestValueRule_DefaultFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DstPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEFSFItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEFSFITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEFSFItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEFSFITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EditorType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EDITORTYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EditorTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EDITORTYPENAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ExtendMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Height_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ItemTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ItemTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_JsonFormat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("JSONFORMAT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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
            if (this.checkFieldStringLengthRule("LOGICNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
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

    protected String onTestValueRule_O2MPSDERId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("O2MPSDERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_O2OPSDERId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("O2OPSDERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PHPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PHPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PHPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PHPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PlaceHolder_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PLACEHOLDER", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCodeListId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCODELISTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCodeListName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCODELISTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDEFId_PSDEF(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("PSDEFID", "PSDEFIELD", DATASET_CURDE, iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u5b9e\u4f53\u5c5e\u6027\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
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

    protected String onTestValueRule_PSDEFSFItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFSFITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFSFItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFSFITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFValueRuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFVALUERULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFValueRuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFVALUERULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysEditorStyleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEDITORSTYLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEditorStyleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEDITORSTYLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysTranslatorId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTRANSLATORID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysTranslatorName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTRANSLATORNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysValueRuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVALUERULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysValueRuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVALUERULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefADPSDELogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFADPSDELOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefADPSDELogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFADPSDELOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefMobMPickupPSDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFMOBMPICKUPPSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefMobMPickupPSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFMOBMPICKUPPSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefMobPickupPSDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFMOBPICKUPPSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefMobPickupPSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFMOBPICKUPPSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefMPickupPSDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFMPICKUPPSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefMPickupPSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFMPICKUPPSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPickupPSDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPICKUPPSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPickupPSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPICKUPPSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDEACModeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEACMODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDEACModeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEACMODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDEDataSetId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEDATASETID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDEDataSetName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEDATASETNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDERId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDERName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SearchMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SEARCHMODE", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
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

    protected String onTestValueRule_ValueFormat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VALUEFORMAT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValueSeperator_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VALUESEPERATOR", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Width_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDEFSFItem pSDEFSFItem) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEFSFItem)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEFSFItem pSDEFSFItem) throws Exception {
        IService iService;
        Object object = pSDEFSFItem.get("PSDEID");
        if (object != null) {
            iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEFSFITEM_PSDATAENTITY_PSDEID", object);
        }
        if ((object = pSDEFSFItem.get("PSDEFID")) != null) {
            iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEFSFITEM_PSDEFIELD_PSDEFID", object);
        }
        super.onUpdateParent((IEntity)pSDEFSFItem);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSDEFSFItem pSDEFSFItem, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEFSFITEM");
        if (!bl) {
            pSDEFSFItem.setCreateDate(null);
            pSDEFSFItem.setCreateMan(null);
            pSDEFSFItem.setPSDEFSFItemId(null);
            pSDEFSFItem.setPSDEFSFItemName(null);
            pSDEFSFItem.setUpdateDate(null);
            pSDEFSFItem.setUpdateMan(null);
            super.exportCurXmlModel(pSDEFSFItem, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSDEFSFItem pSDEFSFItem, PSSystem pSSystem) throws Exception {
        PSDEFSFItem pSDEFSFItem2 = new PSDEFSFItem();
        pSDEFSFItem2.setPSDEFId(pSDEFSFItem.getPSDEFId());
        pSDEFSFItem2.setPSDEFSFItemName(pSDEFSFItem.getPSDEFSFItemName());
        if (this.selectOne((IEntity)pSDEFSFItem2, true)) {
            return pSDEFSFItem2.getPSDEFSFItemId();
        }
        return super.getEntityFolderKeyValue(pSDEFSFItem, pSSystem);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEFSFItem pSDEFSFItem, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEFSFItem, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEFIELD#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEFSFITEM_PSDEFIELD_PSDEFID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDEFIELD", (boolean)true) == 0) {
            iEntity.set("PSDEFID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDEFID"};
    }

    @Override
    public String getModelV2Tag(PSDEFSFItem pSDEFSFItem) {
        if (!StringHelper.isNullOrEmpty((String)pSDEFSFItem.getPSDEFSFItemName())) {
            return pSDEFSFItem.getPSDEFSFItemName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEFSFItem.getCodeName())) {
            return pSDEFSFItem.getCodeName();
        }
        return super.getModelV2Tag(pSDEFSFItem);
    }

    @Override
    public boolean setModelV2Tag(PSDEFSFItem pSDEFSFItem, String string) {
        pSDEFSFItem.setPSDEFSFItemName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDEFSFITEMNAME", "");
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSDEFSFITEMNAME", "");
        map.put("PSDEFID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEFSFItem pSDEFSFItem, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEFSFItem.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEFSFItem, true);
        pSDEFSFItem.set("PSDEFSFITEMNAME", string);
        if (this.select(pSDEFSFItem, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEFSFItem, true);
        return super.getModelV2Entity(pSDEFSFItem, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEFSFItem pSDEFSFItem, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEFSFItem, objectNode, string, string2, n);
    }
}

