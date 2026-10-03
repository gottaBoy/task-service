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
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEFUIModeDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEFUIModeDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEACMode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEACModeBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFInputTip;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFInputTipBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFUIMode;
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
import net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridColServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeColServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandler;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandlerBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeListBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysAppBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDictCat;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDictCatBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysEditorStyle;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysEditorStyleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImageBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUnit;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUnitBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysValueRule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysValueRuleBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFUIModeServiceBase
extends PSCoreSysServiceBase<PSDEFUIMode> {
    private static final Log log = LogFactory.getLog(PSDEFUIModeServiceBase.class);
    public static final String DATASET_CURAPP = "CurApp";
    public static final String DATASET_CURDEF = "CurDEF";
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSDEFUIModeDEModel pSDEFUIModeDEModel;
    private PSDEFUIModeDAO pSDEFUIModeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEFUIModeService";
    }

    public PSDEFUIModeDEModel getPSDEFUIModeDEModel() {
        if (this.pSDEFUIModeDEModel == null) {
            try {
                this.pSDEFUIModeDEModel = (PSDEFUIModeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEFUIModeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFUIModeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEFUIModeDEModel();
    }

    public PSDEFUIModeDAO getPSDEFUIModeDAO() {
        if (this.pSDEFUIModeDAO == null) {
            try {
                this.pSDEFUIModeDAO = (PSDEFUIModeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEFUIModeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFUIModeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEFUIModeDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAPP, (boolean)true) == 0) {
            return this.fetchCurApp(iDEDataSetFetchContext);
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
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurApp(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPP, false);
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

    protected void onFillParentInfo(PSDEFUIMode pSDEFUIMode, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFFORMITEM_PSACHANDLER_ITEMPSACHANDLERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService", (SessionFactory)this.getSessionFactory());
            PSACHandler pSACHandler = (PSACHandler)iService.getDEModel().createEntity();
            pSACHandler.set("PSACHANDLERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSACHandler);
            } else {
                iService.get(pSACHandler);
            }
            this.onFillParentInfo_ItemPSACHandler(pSDEFUIMode, pSACHandler);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFFORMITEM_PSCODELIST_PSCODELISTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService", (SessionFactory)this.getSessionFactory());
            PSCodeList pSCodeList = (PSCodeList)iService.getDEModel().createEntity();
            pSCodeList.set("PSCODELISTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCodeList);
            } else {
                iService.get(pSCodeList);
            }
            this.onFillParentInfo_PSCodeList(pSDEFUIMode, pSCodeList);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFFORMITEM_PSDATAENTITY_REFPSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_RefPSDE(pSDEFUIMode, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFFORMITEM_PSDEACMODE_REFPSDEACMODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEACModeService", (SessionFactory)this.getSessionFactory());
            PSDEACMode pSDEACMode = (PSDEACMode)iService.getDEModel().createEntity();
            pSDEACMode.set("PSDEACMODEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEACMode);
            } else {
                iService.get(pSDEACMode);
            }
            this.onFillParentInfo_RefPSDEACMode(pSDEFUIMode, pSDEACMode);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFFORMITEM_PSDEDATASET_REFPSDEDATASETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDataSet);
            } else {
                iService.get(pSDEDataSet);
            }
            this.onFillParentInfo_RefPSDEDataSet(pSDEFUIMode, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFFORMITEM_PSDEFIELD_PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_PSDEF(pSDEFUIMode, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFFORMITEM_PSDEFINPUTTIP_PSDEFINPUTTIPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFInputTipService", (SessionFactory)this.getSessionFactory());
            PSDEFInputTip pSDEFInputTip = (PSDEFInputTip)iService.getDEModel().createEntity();
            pSDEFInputTip.set("PSDEFINPUTTIPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEFInputTip);
            } else {
                iService.get(pSDEFInputTip);
            }
            this.onFillParentInfo_PSDEFInputTip(pSDEFUIMode, pSDEFInputTip);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFFORMITEM_PSDELOGIC_REFADPSDELOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDELogic);
            } else {
                iService.get(pSDELogic);
            }
            this.onFillParentInfo_RefADPSDELogic(pSDEFUIMode, pSDELogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFFORMITEM_PSDER_REFPSDERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDERService", (SessionFactory)this.getSessionFactory());
            PSDER pSDER = (PSDER)iService.getDEModel().createEntity();
            pSDER.set("PSDERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDER);
            } else {
                iService.get(pSDER);
            }
            this.onFillParentInfo_RefPSDER(pSDEFUIMode, pSDER);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFFORMITEM_PSDEVIEWBASE_REFLINKPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewBase);
            } else {
                iService.get(pSDEViewBase);
            }
            this.onFillParentInfo_RefLinkPSDEView(pSDEFUIMode, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFFORMITEM_PSDEVIEWBASE_REFMPICKUPPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewBase);
            } else {
                iService.get(pSDEViewBase);
            }
            this.onFillParentInfo_RefMPickupPSDEView(pSDEFUIMode, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFFORMITEM_PSDEVIEWBASE_REFPICKUPPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewBase);
            } else {
                iService.get(pSDEViewBase);
            }
            this.onFillParentInfo_RefPickupPSDEView(pSDEFUIMode, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFFORMITEM_PSLANGUAGERES_CAPPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_CapPSLanRes(pSDEFUIMode, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFFORMITEM_PSLANGUAGERES_PHPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_PHPSLanRes(pSDEFUIMode, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFFORMITEM_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService", (SessionFactory)this.getSessionFactory());
            PSSysApp pSSysApp = (PSSysApp)iService.getDEModel().createEntity();
            pSSysApp.set("PSSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysApp);
            } else {
                iService.get(pSSysApp);
            }
            this.onFillParentInfo_PSSysApp(pSDEFUIMode, pSSysApp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFFORMITEM_PSSYSDICTCAT_PSSYSDICTCATID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDictCatService", (SessionFactory)this.getSessionFactory());
            PSSysDictCat pSSysDictCat = (PSSysDictCat)iService.getDEModel().createEntity();
            pSSysDictCat.set("PSSYSDICTCATID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDictCat);
            } else {
                iService.get(pSSysDictCat);
            }
            this.onFillParentInfo_PSSysDictCat(pSDEFUIMode, pSSysDictCat);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFFORMITEM_PSSYSEDITORSTYLE_PSSYSEDITORSTYLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysEditorStyleService", (SessionFactory)this.getSessionFactory());
            PSSysEditorStyle pSSysEditorStyle = (PSSysEditorStyle)iService.getDEModel().createEntity();
            pSSysEditorStyle.set("PSSYSEDITORSTYLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysEditorStyle);
            } else {
                iService.get(pSSysEditorStyle);
            }
            this.onFillParentInfo_PSSysEditorStyle(pSDEFUIMode, pSSysEditorStyle);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFFORMITEM_PSSYSIMAGE_PSSYSIMAGEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService", (SessionFactory)this.getSessionFactory());
            PSSysImage pSSysImage = (PSSysImage)iService.getDEModel().createEntity();
            pSSysImage.set("PSSYSIMAGEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysImage);
            } else {
                iService.get(pSSysImage);
            }
            this.onFillParentInfo_PSSysImage(pSDEFUIMode, pSSysImage);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFFORMITEM_PSSYSPFPLUGIN_GCRPSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPFPlugin);
            } else {
                iService.get(pSSysPFPlugin);
            }
            this.onFillParentInfo_GCRPSSysPFPlugin(pSDEFUIMode, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFFORMITEM_PSSYSUNIT_PSSYSUNITID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUnitService", (SessionFactory)this.getSessionFactory());
            PSSysUnit pSSysUnit = (PSSysUnit)iService.getDEModel().createEntity();
            pSSysUnit.set("PSSYSUNITID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysUnit);
            } else {
                iService.get(pSSysUnit);
            }
            this.onFillParentInfo_PSSysUnit(pSDEFUIMode, pSSysUnit);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFFORMITEM_PSSYSVALUERULE_PSSYSVALUERULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysValueRuleService", (SessionFactory)this.getSessionFactory());
            PSSysValueRule pSSysValueRule = (PSSysValueRule)iService.getDEModel().createEntity();
            pSSysValueRule.set("PSSYSVALUERULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysValueRule);
            } else {
                iService.get(pSSysValueRule);
            }
            this.onFillParentInfo_PSSysValueRule(pSDEFUIMode, pSSysValueRule);
            return;
        }
        super.onFillParentInfo(pSDEFUIMode, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_ItemPSACHandler(PSDEFUIMode pSDEFUIMode, PSACHandler pSACHandler) throws Exception {
        pSDEFUIMode.setItemPSACHandlerId(pSACHandler.getPSACHandlerId());
        pSDEFUIMode.setItemPSACHandlerName(pSACHandler.getPSACHandlerName());
    }

    protected void onFillParentInfo_PSCodeList(PSDEFUIMode pSDEFUIMode, PSCodeList pSCodeList) throws Exception {
        pSDEFUIMode.setPSCodeListId(pSCodeList.getPSCodeListId());
        pSDEFUIMode.setPSCodeListName(pSCodeList.getPSCodeListName());
    }

    protected void onFillParentInfo_RefPSDE(PSDEFUIMode pSDEFUIMode, PSDataEntity pSDataEntity) throws Exception {
        pSDEFUIMode.setRefPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEFUIMode.setRefPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_RefPSDEACMode(PSDEFUIMode pSDEFUIMode, PSDEACMode pSDEACMode) throws Exception {
        pSDEFUIMode.setRefPSDEACModeId(pSDEACMode.getPSDEACModeId());
        pSDEFUIMode.setRefPSDEACModeName(pSDEACMode.getPSDEACModeName());
    }

    protected void onFillParentInfo_RefPSDEDataSet(PSDEFUIMode pSDEFUIMode, PSDEDataSet pSDEDataSet) throws Exception {
        pSDEFUIMode.setRefPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
        pSDEFUIMode.setRefPSDEDataSetName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_PSDEF(PSDEFUIMode pSDEFUIMode, PSDEField pSDEField) throws Exception {
        pSDEFUIMode.setPSDEFId(pSDEField.getPSDEFieldId());
        pSDEFUIMode.setPSDEFName(pSDEField.getPSDEFieldName());
        pSDEFUIMode.setPSDEId(pSDEField.getPSDEId());
        pSDEFUIMode.setPSDEName(pSDEField.getPSDEName());
        pSDEFUIMode.setPSSystemId(pSDEField.getPSSystemId());
    }

    protected void onFillParentInfo_PSDEFInputTip(PSDEFUIMode pSDEFUIMode, PSDEFInputTip pSDEFInputTip) throws Exception {
        pSDEFUIMode.setPSDEFInputTipId(pSDEFInputTip.getPSDEFInputTipId());
        pSDEFUIMode.setPSDEFInputTipName(pSDEFInputTip.getPSDEFInputTipName());
    }

    protected void onFillParentInfo_RefADPSDELogic(PSDEFUIMode pSDEFUIMode, PSDELogic pSDELogic) throws Exception {
        pSDEFUIMode.setRefADPSDELogicId(pSDELogic.getPSDELogicId());
        pSDEFUIMode.setRefADPSDELogicName(pSDELogic.getPSDELogicName());
    }

    protected void onFillParentInfo_RefPSDER(PSDEFUIMode pSDEFUIMode, PSDER pSDER) throws Exception {
        pSDEFUIMode.setRefPSDERId(pSDER.getPSDERId());
        pSDEFUIMode.setRefPSDERName(pSDER.getPSDERName());
    }

    protected void onFillParentInfo_RefLinkPSDEView(PSDEFUIMode pSDEFUIMode, PSDEViewBase pSDEViewBase) throws Exception {
        pSDEFUIMode.setRefLinkPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSDEFUIMode.setRefLinkPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_RefMPickupPSDEView(PSDEFUIMode pSDEFUIMode, PSDEViewBase pSDEViewBase) throws Exception {
        pSDEFUIMode.setRefMPickupPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSDEFUIMode.setRefMPickupPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_RefPickupPSDEView(PSDEFUIMode pSDEFUIMode, PSDEViewBase pSDEViewBase) throws Exception {
        pSDEFUIMode.setRefPickupPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSDEFUIMode.setRefPickupPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_CapPSLanRes(PSDEFUIMode pSDEFUIMode, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEFUIMode.setCapPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEFUIMode.setCapPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PHPSLanRes(PSDEFUIMode pSDEFUIMode, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEFUIMode.setPHPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEFUIMode.setPHPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSSysApp(PSDEFUIMode pSDEFUIMode, PSSysApp pSSysApp) throws Exception {
        pSDEFUIMode.setPSSysAppId(pSSysApp.getPSSysAppId());
        pSDEFUIMode.setPSSysAppName(pSSysApp.getPSSysAppName());
    }

    protected void onFillParentInfo_PSSysDictCat(PSDEFUIMode pSDEFUIMode, PSSysDictCat pSSysDictCat) throws Exception {
        pSDEFUIMode.setPSSysDictCatId(pSSysDictCat.getPSSysDictCatId());
        pSDEFUIMode.setPSSysDictCatName(pSSysDictCat.getPSSysDictCatName());
    }

    protected void onFillParentInfo_PSSysEditorStyle(PSDEFUIMode pSDEFUIMode, PSSysEditorStyle pSSysEditorStyle) throws Exception {
        pSDEFUIMode.setPSSysEditorStyleId(pSSysEditorStyle.getPSSysEditorStyleId());
        pSDEFUIMode.setPSSysEditorStyleName(pSSysEditorStyle.getPSSysEditorStyleName());
    }

    protected void onFillParentInfo_PSSysImage(PSDEFUIMode pSDEFUIMode, PSSysImage pSSysImage) throws Exception {
        pSDEFUIMode.setPSSysImageId(pSSysImage.getPSSysImageId());
        pSDEFUIMode.setPSSysImageName(pSSysImage.getPSSysImageName());
    }

    protected void onFillParentInfo_GCRPSSysPFPlugin(PSDEFUIMode pSDEFUIMode, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSDEFUIMode.setGCRPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSDEFUIMode.setGCRPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysUnit(PSDEFUIMode pSDEFUIMode, PSSysUnit pSSysUnit) throws Exception {
        pSDEFUIMode.setPSSysUnitId(pSSysUnit.getPSSysUnitId());
        pSDEFUIMode.setPSSysUnitName(pSSysUnit.getPSSysUnitName());
    }

    protected void onFillParentInfo_PSSysValueRule(PSDEFUIMode pSDEFUIMode, PSSysValueRule pSSysValueRule) throws Exception {
        pSDEFUIMode.setPSSysValueRuleId(pSSysValueRule.getPSSysValueRuleId());
        pSDEFUIMode.setPSSysValueRuleName(pSSysValueRule.getPSSysValueRuleName());
    }

    protected void onFillEntityFullInfo(PSDEFUIMode pSDEFUIMode, boolean bl) throws Exception {
        if (bl && pSDEFUIMode.getCodeName() == null) {
            pSDEFUIMode.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "UIMode", 25));
        }
        super.onFillEntityFullInfo(pSDEFUIMode, bl);
        this.onFillEntityFullInfo_ItemPSACHandler(pSDEFUIMode, bl);
        this.onFillEntityFullInfo_PSCodeList(pSDEFUIMode, bl);
        this.onFillEntityFullInfo_RefPSDE(pSDEFUIMode, bl);
        this.onFillEntityFullInfo_RefPSDEACMode(pSDEFUIMode, bl);
        this.onFillEntityFullInfo_RefPSDEDataSet(pSDEFUIMode, bl);
        this.onFillEntityFullInfo_PSDEF(pSDEFUIMode, bl);
        this.onFillEntityFullInfo_PSDEFInputTip(pSDEFUIMode, bl);
        this.onFillEntityFullInfo_RefADPSDELogic(pSDEFUIMode, bl);
        this.onFillEntityFullInfo_RefPSDER(pSDEFUIMode, bl);
        this.onFillEntityFullInfo_RefLinkPSDEView(pSDEFUIMode, bl);
        this.onFillEntityFullInfo_RefMPickupPSDEView(pSDEFUIMode, bl);
        this.onFillEntityFullInfo_RefPickupPSDEView(pSDEFUIMode, bl);
        this.onFillEntityFullInfo_CapPSLanRes(pSDEFUIMode, bl);
        this.onFillEntityFullInfo_PHPSLanRes(pSDEFUIMode, bl);
        this.onFillEntityFullInfo_PSSysApp(pSDEFUIMode, bl);
        this.onFillEntityFullInfo_PSSysDictCat(pSDEFUIMode, bl);
        this.onFillEntityFullInfo_PSSysEditorStyle(pSDEFUIMode, bl);
        this.onFillEntityFullInfo_PSSysImage(pSDEFUIMode, bl);
        this.onFillEntityFullInfo_GCRPSSysPFPlugin(pSDEFUIMode, bl);
        this.onFillEntityFullInfo_PSSysUnit(pSDEFUIMode, bl);
        this.onFillEntityFullInfo_PSSysValueRule(pSDEFUIMode, bl);
    }

    protected void onFillEntityFullInfo_ItemPSACHandler(PSDEFUIMode pSDEFUIMode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSCodeList(PSDEFUIMode pSDEFUIMode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefPSDE(PSDEFUIMode pSDEFUIMode, boolean bl) throws Exception {
        if (pSDEFUIMode.isRefPSDEIdDirty()) {
            if (pSDEFUIMode.getRefPSDEId() != null) {
                if (pSDEFUIMode.getRefPSDEId() == null || pSDEFUIMode.getRefPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEFUIMode.getRefPSDE();
                    pSDEFUIMode.setRefPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEFUIMode.setRefPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_RefPSDEACMode(PSDEFUIMode pSDEFUIMode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefPSDEDataSet(PSDEFUIMode pSDEFUIMode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEF(PSDEFUIMode pSDEFUIMode, boolean bl) throws Exception {
        if (pSDEFUIMode.isPSDEFIdDirty()) {
            if (pSDEFUIMode.getPSDEFId() != null) {
                if (pSDEFUIMode.getPSDEFId() == null || pSDEFUIMode.getPSDEFName() == null) {
                    PSDEField pSDEField = pSDEFUIMode.getPSDEF();
                    pSDEFUIMode.setPSDEFName(pSDEField.getPSDEFieldName());
                    pSDEFUIMode.setPSDEId(pSDEField.getPSDEId());
                    pSDEFUIMode.setPSDEName(pSDEField.getPSDEName());
                    pSDEFUIMode.setPSSystemId(pSDEField.getPSSystemId());
                }
            } else {
                pSDEFUIMode.setPSDEFName(null);
                pSDEFUIMode.setPSDEId(null);
                pSDEFUIMode.setPSDEName(null);
                pSDEFUIMode.setPSSystemId(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEFInputTip(PSDEFUIMode pSDEFUIMode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefADPSDELogic(PSDEFUIMode pSDEFUIMode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefPSDER(PSDEFUIMode pSDEFUIMode, boolean bl) throws Exception {
        if (pSDEFUIMode.isRefPSDERIdDirty()) {
            if (pSDEFUIMode.getRefPSDERId() != null) {
                if (pSDEFUIMode.getRefPSDERId() == null || pSDEFUIMode.getRefPSDERName() == null) {
                    PSDER pSDER = pSDEFUIMode.getRefPSDER();
                    pSDEFUIMode.setRefPSDERName(pSDER.getPSDERName());
                }
            } else {
                pSDEFUIMode.setRefPSDERName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_RefLinkPSDEView(PSDEFUIMode pSDEFUIMode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefMPickupPSDEView(PSDEFUIMode pSDEFUIMode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefPickupPSDEView(PSDEFUIMode pSDEFUIMode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_CapPSLanRes(PSDEFUIMode pSDEFUIMode, boolean bl) throws Exception {
        if (pSDEFUIMode.isCapPSLanResIdDirty()) {
            if (pSDEFUIMode.getCapPSLanResId() != null) {
                if (pSDEFUIMode.getCapPSLanResId() == null || pSDEFUIMode.getCapPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEFUIMode.getCapPSLanRes();
                    pSDEFUIMode.setCapPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEFUIMode.setCapPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PHPSLanRes(PSDEFUIMode pSDEFUIMode, boolean bl) throws Exception {
        if (pSDEFUIMode.isPHPSLanResIdDirty()) {
            if (pSDEFUIMode.getPHPSLanResId() != null) {
                if (pSDEFUIMode.getPHPSLanResId() == null || pSDEFUIMode.getPHPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEFUIMode.getPHPSLanRes();
                    pSDEFUIMode.setPHPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEFUIMode.setPHPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysApp(PSDEFUIMode pSDEFUIMode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDictCat(PSDEFUIMode pSDEFUIMode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysEditorStyle(PSDEFUIMode pSDEFUIMode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysImage(PSDEFUIMode pSDEFUIMode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_GCRPSSysPFPlugin(PSDEFUIMode pSDEFUIMode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysUnit(PSDEFUIMode pSDEFUIMode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysValueRule(PSDEFUIMode pSDEFUIMode, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEFUIMode pSDEFUIMode, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEFUIMode, bl);
    }

    public ArrayList<PSDEFUIMode> selectByItemPSACHandler(PSACHandlerBase pSACHandlerBase) throws Exception {
        return this.selectByItemPSACHandler(pSACHandlerBase, "", -1);
    }

    public ArrayList<PSDEFUIMode> selectByItemPSACHandler(PSACHandlerBase pSACHandlerBase, String string) throws Exception {
        return this.selectByItemPSACHandler(pSACHandlerBase, string, -1);
    }

    public ArrayList<PSDEFUIMode> selectByItemPSACHandler(PSACHandlerBase pSACHandlerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ITEMPSACHANDLERID", (Object)pSACHandlerBase.getPSACHandlerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByItemPSACHandlerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByItemPSACHandlerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFUIMode> selectByPSCodeList(PSCodeListBase pSCodeListBase) throws Exception {
        return this.selectByPSCodeList(pSCodeListBase, "", -1);
    }

    public ArrayList<PSDEFUIMode> selectByPSCodeList(PSCodeListBase pSCodeListBase, String string) throws Exception {
        return this.selectByPSCodeList(pSCodeListBase, string, -1);
    }

    public ArrayList<PSDEFUIMode> selectByPSCodeList(PSCodeListBase pSCodeListBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEFUIMode> selectByRefPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByRefPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEFUIMode> selectByRefPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByRefPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEFUIMode> selectByRefPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEFUIMode> selectByRefPSDEACMode(PSDEACModeBase pSDEACModeBase) throws Exception {
        return this.selectByRefPSDEACMode(pSDEACModeBase, "", -1);
    }

    public ArrayList<PSDEFUIMode> selectByRefPSDEACMode(PSDEACModeBase pSDEACModeBase, String string) throws Exception {
        return this.selectByRefPSDEACMode(pSDEACModeBase, string, -1);
    }

    public ArrayList<PSDEFUIMode> selectByRefPSDEACMode(PSDEACModeBase pSDEACModeBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEFUIMode> selectByRefPSDEDataSet(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByRefPSDEDataSet(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSDEFUIMode> selectByRefPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByRefPSDEDataSet(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSDEFUIMode> selectByRefPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEFUIMode> selectByPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEFUIMode> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEFUIMode> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEFUIMode> selectByPSDEFInputTip(PSDEFInputTipBase pSDEFInputTipBase) throws Exception {
        return this.selectByPSDEFInputTip(pSDEFInputTipBase, "", -1);
    }

    public ArrayList<PSDEFUIMode> selectByPSDEFInputTip(PSDEFInputTipBase pSDEFInputTipBase, String string) throws Exception {
        return this.selectByPSDEFInputTip(pSDEFInputTipBase, string, -1);
    }

    public ArrayList<PSDEFUIMode> selectByPSDEFInputTip(PSDEFInputTipBase pSDEFInputTipBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFINPUTTIPID", (Object)pSDEFInputTipBase.getPSDEFInputTipId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFInputTipCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFInputTipCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFUIMode> selectByRefADPSDELogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByRefADPSDELogic(pSDELogicBase, "", -1);
    }

    public ArrayList<PSDEFUIMode> selectByRefADPSDELogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByRefADPSDELogic(pSDELogicBase, string, -1);
    }

    public ArrayList<PSDEFUIMode> selectByRefADPSDELogic(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEFUIMode> selectByRefPSDER(PSDERBase pSDERBase) throws Exception {
        return this.selectByRefPSDER(pSDERBase, "", -1);
    }

    public ArrayList<PSDEFUIMode> selectByRefPSDER(PSDERBase pSDERBase, String string) throws Exception {
        return this.selectByRefPSDER(pSDERBase, string, -1);
    }

    public ArrayList<PSDEFUIMode> selectByRefPSDER(PSDERBase pSDERBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEFUIMode> selectByRefLinkPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByRefLinkPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSDEFUIMode> selectByRefLinkPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByRefLinkPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSDEFUIMode> selectByRefLinkPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFLINKPSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefLinkPSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefLinkPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFUIMode> selectByRefMPickupPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByRefMPickupPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSDEFUIMode> selectByRefMPickupPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByRefMPickupPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSDEFUIMode> selectByRefMPickupPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEFUIMode> selectByRefPickupPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByRefPickupPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSDEFUIMode> selectByRefPickupPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByRefPickupPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSDEFUIMode> selectByRefPickupPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEFUIMode> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByCapPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEFUIMode> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByCapPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEFUIMode> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEFUIMode> selectByPHPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByPHPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEFUIMode> selectByPHPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByPHPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEFUIMode> selectByPHPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEFUIMode> selectByPSSysApp(PSSysAppBase pSSysAppBase) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, "", -1);
    }

    public ArrayList<PSDEFUIMode> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, string, -1);
    }

    public ArrayList<PSDEFUIMode> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEFUIMode> selectByPSSysDictCat(PSSysDictCatBase pSSysDictCatBase) throws Exception {
        return this.selectByPSSysDictCat(pSSysDictCatBase, "", -1);
    }

    public ArrayList<PSDEFUIMode> selectByPSSysDictCat(PSSysDictCatBase pSSysDictCatBase, String string) throws Exception {
        return this.selectByPSSysDictCat(pSSysDictCatBase, string, -1);
    }

    public ArrayList<PSDEFUIMode> selectByPSSysDictCat(PSSysDictCatBase pSSysDictCatBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSDICTCATID", (Object)pSSysDictCatBase.getPSSysDictCatId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysDictCatCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysDictCatCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFUIMode> selectByPSSysEditorStyle(PSSysEditorStyleBase pSSysEditorStyleBase) throws Exception {
        return this.selectByPSSysEditorStyle(pSSysEditorStyleBase, "", -1);
    }

    public ArrayList<PSDEFUIMode> selectByPSSysEditorStyle(PSSysEditorStyleBase pSSysEditorStyleBase, String string) throws Exception {
        return this.selectByPSSysEditorStyle(pSSysEditorStyleBase, string, -1);
    }

    public ArrayList<PSDEFUIMode> selectByPSSysEditorStyle(PSSysEditorStyleBase pSSysEditorStyleBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEFUIMode> selectByPSSysImage(PSSysImageBase pSSysImageBase) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, "", -1);
    }

    public ArrayList<PSDEFUIMode> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, string, -1);
    }

    public ArrayList<PSDEFUIMode> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEFUIMode> selectByGCRPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByGCRPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSDEFUIMode> selectByGCRPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByGCRPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSDEFUIMode> selectByGCRPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("GCRPSSYSPFPLUGINID", (Object)pSSysPFPluginBase.getPSSysPFPluginId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByGCRPSSysPFPluginCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByGCRPSSysPFPluginCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFUIMode> selectByPSSysUnit(PSSysUnitBase pSSysUnitBase) throws Exception {
        return this.selectByPSSysUnit(pSSysUnitBase, "", -1);
    }

    public ArrayList<PSDEFUIMode> selectByPSSysUnit(PSSysUnitBase pSSysUnitBase, String string) throws Exception {
        return this.selectByPSSysUnit(pSSysUnitBase, string, -1);
    }

    public ArrayList<PSDEFUIMode> selectByPSSysUnit(PSSysUnitBase pSSysUnitBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSUNITID", (Object)pSSysUnitBase.getPSSysUnitId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysUnitCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysUnitCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFUIMode> selectByPSSysValueRule(PSSysValueRuleBase pSSysValueRuleBase) throws Exception {
        return this.selectByPSSysValueRule(pSSysValueRuleBase, "", -1);
    }

    public ArrayList<PSDEFUIMode> selectByPSSysValueRule(PSSysValueRuleBase pSSysValueRuleBase, String string) throws Exception {
        return this.selectByPSSysValueRule(pSSysValueRuleBase, string, -1);
    }

    public ArrayList<PSDEFUIMode> selectByPSSysValueRule(PSSysValueRuleBase pSSysValueRuleBase, String string, int n) throws Exception {
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

    public void testRemoveByItemPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByItemPSACHandler(pSACHandler, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSACHANDLER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSACHandler);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFFORMITEM_PSACHANDLER_ITEMPSACHANDLERID", "", iDataEntityModel.getName(), "PSDEFFORMITEM", iDataEntityModel.getDataInfo(pSACHandler), arrayList.get(0)));
        }
    }

    public void resetItemPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByItemPSACHandler(pSACHandler);
        for (PSDEFUIMode pSDEFUIMode : arrayList) {
            PSDEFUIMode pSDEFUIMode2 = (PSDEFUIMode)this.getDEModel().createEntity();
            pSDEFUIMode2.setPSDEFUIModeId(pSDEFUIMode.getPSDEFUIModeId());
            pSDEFUIMode2.setItemPSACHandlerId(null);
            this.update(pSDEFUIMode2);
        }
    }

    public void removeByItemPSACHandler(PSACHandler pSACHandler) throws Exception {
        final PSACHandler pSACHandler2 = pSACHandler;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFUIModeServiceBase.this.onBeforeRemoveByItemPSACHandler(pSACHandler2);
                PSDEFUIModeServiceBase.this.internalRemoveByItemPSACHandler(pSACHandler2);
                PSDEFUIModeServiceBase.this.onAfterRemoveByItemPSACHandler(pSACHandler2);
            }
        });
    }

    protected void onBeforeRemoveByItemPSACHandler(PSACHandler pSACHandler) throws Exception {
    }

    protected void internalRemoveByItemPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByItemPSACHandler(pSACHandler);
        this.onBeforeRemoveByItemPSACHandler(pSACHandler, arrayList);
        for (PSDEFUIMode pSDEFUIMode : arrayList) {
            this.remove(pSDEFUIMode);
        }
        this.onAfterRemoveByItemPSACHandler(pSACHandler, arrayList);
    }

    protected void onAfterRemoveByItemPSACHandler(PSACHandler pSACHandler) throws Exception {
    }

    protected void onBeforeRemoveByItemPSACHandler(PSACHandler pSACHandler, ArrayList<PSDEFUIMode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByItemPSACHandler(PSACHandler pSACHandler, ArrayList<PSDEFUIMode> arrayList) throws Exception {
    }

    public void testRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByPSCodeList(pSCodeList, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCODELIST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCodeList);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFFORMITEM_PSCODELIST_PSCODELISTID", "", iDataEntityModel.getName(), "PSDEFFORMITEM", iDataEntityModel.getDataInfo(pSCodeList), arrayList.get(0)));
        }
    }

    public void resetPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByPSCodeList(pSCodeList);
        for (PSDEFUIMode pSDEFUIMode : arrayList) {
            PSDEFUIMode pSDEFUIMode2 = (PSDEFUIMode)this.getDEModel().createEntity();
            pSDEFUIMode2.setPSDEFUIModeId(pSDEFUIMode.getPSDEFUIModeId());
            pSDEFUIMode2.setPSCodeListId(null);
            this.update(pSDEFUIMode2);
        }
    }

    public void removeByPSCodeList(PSCodeList pSCodeList) throws Exception {
        final PSCodeList pSCodeList2 = pSCodeList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFUIModeServiceBase.this.onBeforeRemoveByPSCodeList(pSCodeList2);
                PSDEFUIModeServiceBase.this.internalRemoveByPSCodeList(pSCodeList2);
                PSDEFUIModeServiceBase.this.onAfterRemoveByPSCodeList(pSCodeList2);
            }
        });
    }

    protected void onBeforeRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void internalRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByPSCodeList(pSCodeList);
        this.onBeforeRemoveByPSCodeList(pSCodeList, arrayList);
        for (PSDEFUIMode pSDEFUIMode : arrayList) {
            this.remove(pSDEFUIMode);
        }
        this.onAfterRemoveByPSCodeList(pSCodeList, arrayList);
    }

    protected void onAfterRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void onBeforeRemoveByPSCodeList(PSCodeList pSCodeList, ArrayList<PSDEFUIMode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCodeList(PSCodeList pSCodeList, ArrayList<PSDEFUIMode> arrayList) throws Exception {
    }

    public void testRemoveByRefPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByRefPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFFORMITEM_PSDATAENTITY_REFPSDEID", "", iDataEntityModel.getName(), "PSDEFFORMITEM", iDataEntityModel.getDataInfo(pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetRefPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByRefPSDE(pSDataEntity);
        for (PSDEFUIMode pSDEFUIMode : arrayList) {
            PSDEFUIMode pSDEFUIMode2 = (PSDEFUIMode)this.getDEModel().createEntity();
            pSDEFUIMode2.setPSDEFUIModeId(pSDEFUIMode.getPSDEFUIModeId());
            pSDEFUIMode2.setRefPSDEId(null);
            this.update(pSDEFUIMode2);
        }
    }

    public void removeByRefPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFUIModeServiceBase.this.onBeforeRemoveByRefPSDE(pSDataEntity2);
                PSDEFUIModeServiceBase.this.internalRemoveByRefPSDE(pSDataEntity2);
                PSDEFUIModeServiceBase.this.onAfterRemoveByRefPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByRefPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByRefPSDE(pSDataEntity);
        this.onBeforeRemoveByRefPSDE(pSDataEntity, arrayList);
        for (PSDEFUIMode pSDEFUIMode : arrayList) {
            this.remove(pSDEFUIMode);
        }
        this.onAfterRemoveByRefPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByRefPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByRefPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEFUIMode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEFUIMode> arrayList) throws Exception {
    }

    public void testRemoveByRefPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByRefPSDEACMode(pSDEACMode, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACMODE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEACMode);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFFORMITEM_PSDEACMODE_REFPSDEACMODEID", "", iDataEntityModel.getName(), "PSDEFFORMITEM", iDataEntityModel.getDataInfo(pSDEACMode), arrayList.get(0)));
        }
    }

    public void resetRefPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByRefPSDEACMode(pSDEACMode);
        for (PSDEFUIMode pSDEFUIMode : arrayList) {
            PSDEFUIMode pSDEFUIMode2 = (PSDEFUIMode)this.getDEModel().createEntity();
            pSDEFUIMode2.setPSDEFUIModeId(pSDEFUIMode.getPSDEFUIModeId());
            pSDEFUIMode2.setRefPSDEACModeId(null);
            this.update(pSDEFUIMode2);
        }
    }

    public void removeByRefPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
        final PSDEACMode pSDEACMode2 = pSDEACMode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFUIModeServiceBase.this.onBeforeRemoveByRefPSDEACMode(pSDEACMode2);
                PSDEFUIModeServiceBase.this.internalRemoveByRefPSDEACMode(pSDEACMode2);
                PSDEFUIModeServiceBase.this.onAfterRemoveByRefPSDEACMode(pSDEACMode2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
    }

    protected void internalRemoveByRefPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByRefPSDEACMode(pSDEACMode);
        this.onBeforeRemoveByRefPSDEACMode(pSDEACMode, arrayList);
        for (PSDEFUIMode pSDEFUIMode : arrayList) {
            this.remove(pSDEFUIMode);
        }
        this.onAfterRemoveByRefPSDEACMode(pSDEACMode, arrayList);
    }

    protected void onAfterRemoveByRefPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
    }

    protected void onBeforeRemoveByRefPSDEACMode(PSDEACMode pSDEACMode, ArrayList<PSDEFUIMode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSDEACMode(PSDEACMode pSDEACMode, ArrayList<PSDEFUIMode> arrayList) throws Exception {
    }

    public void testRemoveByRefPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByRefPSDEDataSet(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFFORMITEM_PSDEDATASET_REFPSDEDATASETID", "", iDataEntityModel.getName(), "PSDEFFORMITEM", iDataEntityModel.getDataInfo(pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetRefPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByRefPSDEDataSet(pSDEDataSet);
        for (PSDEFUIMode pSDEFUIMode : arrayList) {
            PSDEFUIMode pSDEFUIMode2 = (PSDEFUIMode)this.getDEModel().createEntity();
            pSDEFUIMode2.setPSDEFUIModeId(pSDEFUIMode.getPSDEFUIModeId());
            pSDEFUIMode2.setRefPSDEDataSetId(null);
            this.update(pSDEFUIMode2);
        }
    }

    public void removeByRefPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFUIModeServiceBase.this.onBeforeRemoveByRefPSDEDataSet(pSDEDataSet2);
                PSDEFUIModeServiceBase.this.internalRemoveByRefPSDEDataSet(pSDEDataSet2);
                PSDEFUIModeServiceBase.this.onAfterRemoveByRefPSDEDataSet(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByRefPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByRefPSDEDataSet(pSDEDataSet);
        this.onBeforeRemoveByRefPSDEDataSet(pSDEDataSet, arrayList);
        for (PSDEFUIMode pSDEFUIMode : arrayList) {
            this.remove(pSDEFUIMode);
        }
        this.onAfterRemoveByRefPSDEDataSet(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByRefPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByRefPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSDEFUIMode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSDEFUIMode> arrayList) throws Exception {
    }

    public void testRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    public void resetPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByPSDEF(pSDEField);
        for (PSDEFUIMode pSDEFUIMode : arrayList) {
            PSDEFUIMode pSDEFUIMode2 = (PSDEFUIMode)this.getDEModel().createEntity();
            pSDEFUIMode2.setPSDEFUIModeId(pSDEFUIMode.getPSDEFUIModeId());
            pSDEFUIMode2.setPSDEFId(null);
            this.update(pSDEFUIMode2);
        }
    }

    public void removeByPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFUIModeServiceBase.this.onBeforeRemoveByPSDEF(pSDEField2);
                PSDEFUIModeServiceBase.this.internalRemoveByPSDEF(pSDEField2);
                PSDEFUIModeServiceBase.this.onAfterRemoveByPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByPSDEF(pSDEField);
        this.onBeforeRemoveByPSDEF(pSDEField, arrayList);
        for (PSDEFUIMode pSDEFUIMode : arrayList) {
            this.remove(pSDEFUIMode);
        }
        this.onAfterRemoveByPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSDEFUIMode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSDEFUIMode> arrayList) throws Exception {
    }

    public void testRemoveByPSDEFInputTip(PSDEFInputTip pSDEFInputTip) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByPSDEFInputTip(pSDEFInputTip, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFINPUTTIP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEFInputTip);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFFORMITEM_PSDEFINPUTTIP_PSDEFINPUTTIPID", "", iDataEntityModel.getName(), "PSDEFFORMITEM", iDataEntityModel.getDataInfo(pSDEFInputTip), arrayList.get(0)));
        }
    }

    public void resetPSDEFInputTip(PSDEFInputTip pSDEFInputTip) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByPSDEFInputTip(pSDEFInputTip);
        for (PSDEFUIMode pSDEFUIMode : arrayList) {
            PSDEFUIMode pSDEFUIMode2 = (PSDEFUIMode)this.getDEModel().createEntity();
            pSDEFUIMode2.setPSDEFUIModeId(pSDEFUIMode.getPSDEFUIModeId());
            pSDEFUIMode2.setPSDEFInputTipId(null);
            this.update(pSDEFUIMode2);
        }
    }

    public void removeByPSDEFInputTip(PSDEFInputTip pSDEFInputTip) throws Exception {
        final PSDEFInputTip pSDEFInputTip2 = pSDEFInputTip;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFUIModeServiceBase.this.onBeforeRemoveByPSDEFInputTip(pSDEFInputTip2);
                PSDEFUIModeServiceBase.this.internalRemoveByPSDEFInputTip(pSDEFInputTip2);
                PSDEFUIModeServiceBase.this.onAfterRemoveByPSDEFInputTip(pSDEFInputTip2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEFInputTip(PSDEFInputTip pSDEFInputTip) throws Exception {
    }

    protected void internalRemoveByPSDEFInputTip(PSDEFInputTip pSDEFInputTip) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByPSDEFInputTip(pSDEFInputTip);
        this.onBeforeRemoveByPSDEFInputTip(pSDEFInputTip, arrayList);
        for (PSDEFUIMode pSDEFUIMode : arrayList) {
            this.remove(pSDEFUIMode);
        }
        this.onAfterRemoveByPSDEFInputTip(pSDEFInputTip, arrayList);
    }

    protected void onAfterRemoveByPSDEFInputTip(PSDEFInputTip pSDEFInputTip) throws Exception {
    }

    protected void onBeforeRemoveByPSDEFInputTip(PSDEFInputTip pSDEFInputTip, ArrayList<PSDEFUIMode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEFInputTip(PSDEFInputTip pSDEFInputTip, ArrayList<PSDEFUIMode> arrayList) throws Exception {
    }

    public void testRemoveByRefADPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByRefADPSDELogic(pSDELogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDELogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFFORMITEM_PSDELOGIC_REFADPSDELOGICID", "", iDataEntityModel.getName(), "PSDEFFORMITEM", iDataEntityModel.getDataInfo(pSDELogic), arrayList.get(0)));
        }
    }

    public void resetRefADPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByRefADPSDELogic(pSDELogic);
        for (PSDEFUIMode pSDEFUIMode : arrayList) {
            PSDEFUIMode pSDEFUIMode2 = (PSDEFUIMode)this.getDEModel().createEntity();
            pSDEFUIMode2.setPSDEFUIModeId(pSDEFUIMode.getPSDEFUIModeId());
            pSDEFUIMode2.setRefADPSDELogicId(null);
            this.update(pSDEFUIMode2);
        }
    }

    public void removeByRefADPSDELogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFUIModeServiceBase.this.onBeforeRemoveByRefADPSDELogic(pSDELogic2);
                PSDEFUIModeServiceBase.this.internalRemoveByRefADPSDELogic(pSDELogic2);
                PSDEFUIModeServiceBase.this.onAfterRemoveByRefADPSDELogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByRefADPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByRefADPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByRefADPSDELogic(pSDELogic);
        this.onBeforeRemoveByRefADPSDELogic(pSDELogic, arrayList);
        for (PSDEFUIMode pSDEFUIMode : arrayList) {
            this.remove(pSDEFUIMode);
        }
        this.onAfterRemoveByRefADPSDELogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByRefADPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByRefADPSDELogic(PSDELogic pSDELogic, ArrayList<PSDEFUIMode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefADPSDELogic(PSDELogic pSDELogic, ArrayList<PSDEFUIMode> arrayList) throws Exception {
    }

    public void testRemoveByRefPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByRefPSDER(pSDER, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDER);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFFORMITEM_PSDER_REFPSDERID", "", iDataEntityModel.getName(), "PSDEFFORMITEM", iDataEntityModel.getDataInfo(pSDER), arrayList.get(0)));
        }
    }

    public void resetRefPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByRefPSDER(pSDER);
        for (PSDEFUIMode pSDEFUIMode : arrayList) {
            PSDEFUIMode pSDEFUIMode2 = (PSDEFUIMode)this.getDEModel().createEntity();
            pSDEFUIMode2.setPSDEFUIModeId(pSDEFUIMode.getPSDEFUIModeId());
            pSDEFUIMode2.setRefPSDERId(null);
            this.update(pSDEFUIMode2);
        }
    }

    public void removeByRefPSDER(PSDER pSDER) throws Exception {
        final PSDER pSDER2 = pSDER;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFUIModeServiceBase.this.onBeforeRemoveByRefPSDER(pSDER2);
                PSDEFUIModeServiceBase.this.internalRemoveByRefPSDER(pSDER2);
                PSDEFUIModeServiceBase.this.onAfterRemoveByRefPSDER(pSDER2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSDER(PSDER pSDER) throws Exception {
    }

    protected void internalRemoveByRefPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByRefPSDER(pSDER);
        this.onBeforeRemoveByRefPSDER(pSDER, arrayList);
        for (PSDEFUIMode pSDEFUIMode : arrayList) {
            this.remove(pSDEFUIMode);
        }
        this.onAfterRemoveByRefPSDER(pSDER, arrayList);
    }

    protected void onAfterRemoveByRefPSDER(PSDER pSDER) throws Exception {
    }

    protected void onBeforeRemoveByRefPSDER(PSDER pSDER, ArrayList<PSDEFUIMode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSDER(PSDER pSDER, ArrayList<PSDEFUIMode> arrayList) throws Exception {
    }

    public void testRemoveByRefLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByRefLinkPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFFORMITEM_PSDEVIEWBASE_REFLINKPSDEVIEWID", "", iDataEntityModel.getName(), "PSDEFFORMITEM", iDataEntityModel.getDataInfo(pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetRefLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByRefLinkPSDEView(pSDEViewBase);
        for (PSDEFUIMode pSDEFUIMode : arrayList) {
            PSDEFUIMode pSDEFUIMode2 = (PSDEFUIMode)this.getDEModel().createEntity();
            pSDEFUIMode2.setPSDEFUIModeId(pSDEFUIMode.getPSDEFUIModeId());
            pSDEFUIMode2.setRefLinkPSDEViewId(null);
            this.update(pSDEFUIMode2);
        }
    }

    public void removeByRefLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFUIModeServiceBase.this.onBeforeRemoveByRefLinkPSDEView(pSDEViewBase2);
                PSDEFUIModeServiceBase.this.internalRemoveByRefLinkPSDEView(pSDEViewBase2);
                PSDEFUIModeServiceBase.this.onAfterRemoveByRefLinkPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByRefLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByRefLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByRefLinkPSDEView(pSDEViewBase);
        this.onBeforeRemoveByRefLinkPSDEView(pSDEViewBase, arrayList);
        for (PSDEFUIMode pSDEFUIMode : arrayList) {
            this.remove(pSDEFUIMode);
        }
        this.onAfterRemoveByRefLinkPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByRefLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByRefLinkPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDEFUIMode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefLinkPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDEFUIMode> arrayList) throws Exception {
    }

    public void testRemoveByRefMPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByRefMPickupPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFFORMITEM_PSDEVIEWBASE_REFMPICKUPPSDEVIEWID", "", iDataEntityModel.getName(), "PSDEFFORMITEM", iDataEntityModel.getDataInfo(pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetRefMPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByRefMPickupPSDEView(pSDEViewBase);
        for (PSDEFUIMode pSDEFUIMode : arrayList) {
            PSDEFUIMode pSDEFUIMode2 = (PSDEFUIMode)this.getDEModel().createEntity();
            pSDEFUIMode2.setPSDEFUIModeId(pSDEFUIMode.getPSDEFUIModeId());
            pSDEFUIMode2.setRefMPickupPSDEViewId(null);
            this.update(pSDEFUIMode2);
        }
    }

    public void removeByRefMPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFUIModeServiceBase.this.onBeforeRemoveByRefMPickupPSDEView(pSDEViewBase2);
                PSDEFUIModeServiceBase.this.internalRemoveByRefMPickupPSDEView(pSDEViewBase2);
                PSDEFUIModeServiceBase.this.onAfterRemoveByRefMPickupPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByRefMPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByRefMPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByRefMPickupPSDEView(pSDEViewBase);
        this.onBeforeRemoveByRefMPickupPSDEView(pSDEViewBase, arrayList);
        for (PSDEFUIMode pSDEFUIMode : arrayList) {
            this.remove(pSDEFUIMode);
        }
        this.onAfterRemoveByRefMPickupPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByRefMPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByRefMPickupPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDEFUIMode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefMPickupPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDEFUIMode> arrayList) throws Exception {
    }

    public void testRemoveByRefPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByRefPickupPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFFORMITEM_PSDEVIEWBASE_REFPICKUPPSDEVIEWID", "", iDataEntityModel.getName(), "PSDEFFORMITEM", iDataEntityModel.getDataInfo(pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetRefPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByRefPickupPSDEView(pSDEViewBase);
        for (PSDEFUIMode pSDEFUIMode : arrayList) {
            PSDEFUIMode pSDEFUIMode2 = (PSDEFUIMode)this.getDEModel().createEntity();
            pSDEFUIMode2.setPSDEFUIModeId(pSDEFUIMode.getPSDEFUIModeId());
            pSDEFUIMode2.setRefPickupPSDEViewId(null);
            this.update(pSDEFUIMode2);
        }
    }

    public void removeByRefPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFUIModeServiceBase.this.onBeforeRemoveByRefPickupPSDEView(pSDEViewBase2);
                PSDEFUIModeServiceBase.this.internalRemoveByRefPickupPSDEView(pSDEViewBase2);
                PSDEFUIModeServiceBase.this.onAfterRemoveByRefPickupPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByRefPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByRefPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByRefPickupPSDEView(pSDEViewBase);
        this.onBeforeRemoveByRefPickupPSDEView(pSDEViewBase, arrayList);
        for (PSDEFUIMode pSDEFUIMode : arrayList) {
            this.remove(pSDEFUIMode);
        }
        this.onAfterRemoveByRefPickupPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByRefPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByRefPickupPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDEFUIMode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPickupPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDEFUIMode> arrayList) throws Exception {
    }

    public void testRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByCapPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFFORMITEM_PSLANGUAGERES_CAPPSLANRESID", "", iDataEntityModel.getName(), "PSDEFFORMITEM", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByCapPSLanRes(pSLanguageRes);
        for (PSDEFUIMode pSDEFUIMode : arrayList) {
            PSDEFUIMode pSDEFUIMode2 = (PSDEFUIMode)this.getDEModel().createEntity();
            pSDEFUIMode2.setPSDEFUIModeId(pSDEFUIMode.getPSDEFUIModeId());
            pSDEFUIMode2.setCapPSLanResId(null);
            this.update(pSDEFUIMode2);
        }
    }

    public void removeByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFUIModeServiceBase.this.onBeforeRemoveByCapPSLanRes(pSLanguageRes2);
                PSDEFUIModeServiceBase.this.internalRemoveByCapPSLanRes(pSLanguageRes2);
                PSDEFUIModeServiceBase.this.onAfterRemoveByCapPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByCapPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByCapPSLanRes(pSLanguageRes, arrayList);
        for (PSDEFUIMode pSDEFUIMode : arrayList) {
            this.remove(pSDEFUIMode);
        }
        this.onAfterRemoveByCapPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEFUIMode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEFUIMode> arrayList) throws Exception {
    }

    public void testRemoveByPHPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByPHPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFFORMITEM_PSLANGUAGERES_PHPSLANRESID", "", iDataEntityModel.getName(), "PSDEFFORMITEM", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetPHPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByPHPSLanRes(pSLanguageRes);
        for (PSDEFUIMode pSDEFUIMode : arrayList) {
            PSDEFUIMode pSDEFUIMode2 = (PSDEFUIMode)this.getDEModel().createEntity();
            pSDEFUIMode2.setPSDEFUIModeId(pSDEFUIMode.getPSDEFUIModeId());
            pSDEFUIMode2.setPHPSLanResId(null);
            this.update(pSDEFUIMode2);
        }
    }

    public void removeByPHPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFUIModeServiceBase.this.onBeforeRemoveByPHPSLanRes(pSLanguageRes2);
                PSDEFUIModeServiceBase.this.internalRemoveByPHPSLanRes(pSLanguageRes2);
                PSDEFUIModeServiceBase.this.onAfterRemoveByPHPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByPHPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByPHPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByPHPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByPHPSLanRes(pSLanguageRes, arrayList);
        for (PSDEFUIMode pSDEFUIMode : arrayList) {
            this.remove(pSDEFUIMode);
        }
        this.onAfterRemoveByPHPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByPHPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByPHPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEFUIMode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPHPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEFUIMode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByPSSysApp(pSSysApp, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSAPP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysApp);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFFORMITEM_PSSYSAPP_PSSYSAPPID", "", iDataEntityModel.getName(), "PSDEFFORMITEM", iDataEntityModel.getDataInfo(pSSysApp), arrayList.get(0)));
        }
    }

    public void resetPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByPSSysApp(pSSysApp);
        for (PSDEFUIMode pSDEFUIMode : arrayList) {
            PSDEFUIMode pSDEFUIMode2 = (PSDEFUIMode)this.getDEModel().createEntity();
            pSDEFUIMode2.setPSDEFUIModeId(pSDEFUIMode.getPSDEFUIModeId());
            pSDEFUIMode2.setPSSysAppId(null);
            this.update(pSDEFUIMode2);
        }
    }

    public void removeByPSSysApp(PSSysApp pSSysApp) throws Exception {
        final PSSysApp pSSysApp2 = pSSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFUIModeServiceBase.this.onBeforeRemoveByPSSysApp(pSSysApp2);
                PSDEFUIModeServiceBase.this.internalRemoveByPSSysApp(pSSysApp2);
                PSDEFUIModeServiceBase.this.onAfterRemoveByPSSysApp(pSSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void internalRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByPSSysApp(pSSysApp);
        this.onBeforeRemoveByPSSysApp(pSSysApp, arrayList);
        for (PSDEFUIMode pSDEFUIMode : arrayList) {
            this.remove(pSDEFUIMode);
        }
        this.onAfterRemoveByPSSysApp(pSSysApp, arrayList);
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSDEFUIMode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSDEFUIMode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDictCat(PSSysDictCat pSSysDictCat) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByPSSysDictCat(pSSysDictCat, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDICTCAT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysDictCat);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFFORMITEM_PSSYSDICTCAT_PSSYSDICTCATID", "", iDataEntityModel.getName(), "PSDEFFORMITEM", iDataEntityModel.getDataInfo(pSSysDictCat), arrayList.get(0)));
        }
    }

    public void resetPSSysDictCat(PSSysDictCat pSSysDictCat) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByPSSysDictCat(pSSysDictCat);
        for (PSDEFUIMode pSDEFUIMode : arrayList) {
            PSDEFUIMode pSDEFUIMode2 = (PSDEFUIMode)this.getDEModel().createEntity();
            pSDEFUIMode2.setPSDEFUIModeId(pSDEFUIMode.getPSDEFUIModeId());
            pSDEFUIMode2.setPSSysDictCatId(null);
            this.update(pSDEFUIMode2);
        }
    }

    public void removeByPSSysDictCat(PSSysDictCat pSSysDictCat) throws Exception {
        final PSSysDictCat pSSysDictCat2 = pSSysDictCat;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFUIModeServiceBase.this.onBeforeRemoveByPSSysDictCat(pSSysDictCat2);
                PSDEFUIModeServiceBase.this.internalRemoveByPSSysDictCat(pSSysDictCat2);
                PSDEFUIModeServiceBase.this.onAfterRemoveByPSSysDictCat(pSSysDictCat2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDictCat(PSSysDictCat pSSysDictCat) throws Exception {
    }

    protected void internalRemoveByPSSysDictCat(PSSysDictCat pSSysDictCat) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByPSSysDictCat(pSSysDictCat);
        this.onBeforeRemoveByPSSysDictCat(pSSysDictCat, arrayList);
        for (PSDEFUIMode pSDEFUIMode : arrayList) {
            this.remove(pSDEFUIMode);
        }
        this.onAfterRemoveByPSSysDictCat(pSSysDictCat, arrayList);
    }

    protected void onAfterRemoveByPSSysDictCat(PSSysDictCat pSSysDictCat) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDictCat(PSSysDictCat pSSysDictCat, ArrayList<PSDEFUIMode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDictCat(PSSysDictCat pSSysDictCat, ArrayList<PSDEFUIMode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByPSSysEditorStyle(pSSysEditorStyle, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSEDITORSTYLE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysEditorStyle);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFFORMITEM_PSSYSEDITORSTYLE_PSSYSEDITORSTYLEID", "", iDataEntityModel.getName(), "PSDEFFORMITEM", iDataEntityModel.getDataInfo(pSSysEditorStyle), arrayList.get(0)));
        }
    }

    public void resetPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByPSSysEditorStyle(pSSysEditorStyle);
        for (PSDEFUIMode pSDEFUIMode : arrayList) {
            PSDEFUIMode pSDEFUIMode2 = (PSDEFUIMode)this.getDEModel().createEntity();
            pSDEFUIMode2.setPSDEFUIModeId(pSDEFUIMode.getPSDEFUIModeId());
            pSDEFUIMode2.setPSSysEditorStyleId(null);
            this.update(pSDEFUIMode2);
        }
    }

    public void removeByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle) throws Exception {
        final PSSysEditorStyle pSSysEditorStyle2 = pSSysEditorStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFUIModeServiceBase.this.onBeforeRemoveByPSSysEditorStyle(pSSysEditorStyle2);
                PSDEFUIModeServiceBase.this.internalRemoveByPSSysEditorStyle(pSSysEditorStyle2);
                PSDEFUIModeServiceBase.this.onAfterRemoveByPSSysEditorStyle(pSSysEditorStyle2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle) throws Exception {
    }

    protected void internalRemoveByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByPSSysEditorStyle(pSSysEditorStyle);
        this.onBeforeRemoveByPSSysEditorStyle(pSSysEditorStyle, arrayList);
        for (PSDEFUIMode pSDEFUIMode : arrayList) {
            this.remove(pSDEFUIMode);
        }
        this.onAfterRemoveByPSSysEditorStyle(pSSysEditorStyle, arrayList);
    }

    protected void onAfterRemoveByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle) throws Exception {
    }

    protected void onBeforeRemoveByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle, ArrayList<PSDEFUIMode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle, ArrayList<PSDEFUIMode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByPSSysImage(pSSysImage, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSIMAGE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysImage);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFFORMITEM_PSSYSIMAGE_PSSYSIMAGEID", "", iDataEntityModel.getName(), "PSDEFFORMITEM", iDataEntityModel.getDataInfo(pSSysImage), arrayList.get(0)));
        }
    }

    public void resetPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByPSSysImage(pSSysImage);
        for (PSDEFUIMode pSDEFUIMode : arrayList) {
            PSDEFUIMode pSDEFUIMode2 = (PSDEFUIMode)this.getDEModel().createEntity();
            pSDEFUIMode2.setPSDEFUIModeId(pSDEFUIMode.getPSDEFUIModeId());
            pSDEFUIMode2.setPSSysImageId(null);
            this.update(pSDEFUIMode2);
        }
    }

    public void removeByPSSysImage(PSSysImage pSSysImage) throws Exception {
        final PSSysImage pSSysImage2 = pSSysImage;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFUIModeServiceBase.this.onBeforeRemoveByPSSysImage(pSSysImage2);
                PSDEFUIModeServiceBase.this.internalRemoveByPSSysImage(pSSysImage2);
                PSDEFUIModeServiceBase.this.onAfterRemoveByPSSysImage(pSSysImage2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void internalRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByPSSysImage(pSSysImage);
        this.onBeforeRemoveByPSSysImage(pSSysImage, arrayList);
        for (PSDEFUIMode pSDEFUIMode : arrayList) {
            this.remove(pSDEFUIMode);
        }
        this.onAfterRemoveByPSSysImage(pSSysImage, arrayList);
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSDEFUIMode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSDEFUIMode> arrayList) throws Exception {
    }

    public void testRemoveByGCRPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByGCRPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFFORMITEM_PSSYSPFPLUGIN_GCRPSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSDEFFORMITEM", iDataEntityModel.getDataInfo(pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetGCRPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByGCRPSSysPFPlugin(pSSysPFPlugin);
        for (PSDEFUIMode pSDEFUIMode : arrayList) {
            PSDEFUIMode pSDEFUIMode2 = (PSDEFUIMode)this.getDEModel().createEntity();
            pSDEFUIMode2.setPSDEFUIModeId(pSDEFUIMode.getPSDEFUIModeId());
            pSDEFUIMode2.setGCRPSSysPFPluginId(null);
            this.update(pSDEFUIMode2);
        }
    }

    public void removeByGCRPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFUIModeServiceBase.this.onBeforeRemoveByGCRPSSysPFPlugin(pSSysPFPlugin2);
                PSDEFUIModeServiceBase.this.internalRemoveByGCRPSSysPFPlugin(pSSysPFPlugin2);
                PSDEFUIModeServiceBase.this.onAfterRemoveByGCRPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByGCRPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByGCRPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByGCRPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByGCRPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSDEFUIMode pSDEFUIMode : arrayList) {
            this.remove(pSDEFUIMode);
        }
        this.onAfterRemoveByGCRPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByGCRPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByGCRPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEFUIMode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGCRPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEFUIMode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysUnit(PSSysUnit pSSysUnit) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByPSSysUnit(pSSysUnit, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSUNIT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysUnit);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFFORMITEM_PSSYSUNIT_PSSYSUNITID", "", iDataEntityModel.getName(), "PSDEFFORMITEM", iDataEntityModel.getDataInfo(pSSysUnit), arrayList.get(0)));
        }
    }

    public void resetPSSysUnit(PSSysUnit pSSysUnit) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByPSSysUnit(pSSysUnit);
        for (PSDEFUIMode pSDEFUIMode : arrayList) {
            PSDEFUIMode pSDEFUIMode2 = (PSDEFUIMode)this.getDEModel().createEntity();
            pSDEFUIMode2.setPSDEFUIModeId(pSDEFUIMode.getPSDEFUIModeId());
            pSDEFUIMode2.setPSSysUnitId(null);
            this.update(pSDEFUIMode2);
        }
    }

    public void removeByPSSysUnit(PSSysUnit pSSysUnit) throws Exception {
        final PSSysUnit pSSysUnit2 = pSSysUnit;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFUIModeServiceBase.this.onBeforeRemoveByPSSysUnit(pSSysUnit2);
                PSDEFUIModeServiceBase.this.internalRemoveByPSSysUnit(pSSysUnit2);
                PSDEFUIModeServiceBase.this.onAfterRemoveByPSSysUnit(pSSysUnit2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysUnit(PSSysUnit pSSysUnit) throws Exception {
    }

    protected void internalRemoveByPSSysUnit(PSSysUnit pSSysUnit) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByPSSysUnit(pSSysUnit);
        this.onBeforeRemoveByPSSysUnit(pSSysUnit, arrayList);
        for (PSDEFUIMode pSDEFUIMode : arrayList) {
            this.remove(pSDEFUIMode);
        }
        this.onAfterRemoveByPSSysUnit(pSSysUnit, arrayList);
    }

    protected void onAfterRemoveByPSSysUnit(PSSysUnit pSSysUnit) throws Exception {
    }

    protected void onBeforeRemoveByPSSysUnit(PSSysUnit pSSysUnit, ArrayList<PSDEFUIMode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysUnit(PSSysUnit pSSysUnit, ArrayList<PSDEFUIMode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByPSSysValueRule(pSSysValueRule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVALUERULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysValueRule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFFORMITEM_PSSYSVALUERULE_PSSYSVALUERULEID", "", iDataEntityModel.getName(), "PSDEFFORMITEM", iDataEntityModel.getDataInfo(pSSysValueRule), arrayList.get(0)));
        }
    }

    public void resetPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByPSSysValueRule(pSSysValueRule);
        for (PSDEFUIMode pSDEFUIMode : arrayList) {
            PSDEFUIMode pSDEFUIMode2 = (PSDEFUIMode)this.getDEModel().createEntity();
            pSDEFUIMode2.setPSDEFUIModeId(pSDEFUIMode.getPSDEFUIModeId());
            pSDEFUIMode2.setPSSysValueRuleId(null);
            this.update(pSDEFUIMode2);
        }
    }

    public void removeByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        final PSSysValueRule pSSysValueRule2 = pSSysValueRule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFUIModeServiceBase.this.onBeforeRemoveByPSSysValueRule(pSSysValueRule2);
                PSDEFUIModeServiceBase.this.internalRemoveByPSSysValueRule(pSSysValueRule2);
                PSDEFUIModeServiceBase.this.onAfterRemoveByPSSysValueRule(pSSysValueRule2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
    }

    protected void internalRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        ArrayList<PSDEFUIMode> arrayList = this.selectByPSSysValueRule(pSSysValueRule);
        this.onBeforeRemoveByPSSysValueRule(pSSysValueRule, arrayList);
        for (PSDEFUIMode pSDEFUIMode : arrayList) {
            this.remove(pSDEFUIMode);
        }
        this.onAfterRemoveByPSSysValueRule(pSSysValueRule, arrayList);
    }

    protected void onAfterRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
    }

    protected void onBeforeRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule, ArrayList<PSDEFUIMode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule, ArrayList<PSDEFUIMode> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEFUIMode pSDEFUIMode) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEFGroupDetailService)ServiceGlobal.getService(PSDEFGroupDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFGroupDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSDEFUIMode(pSDEFUIMode);
        pSCoreSysServiceBase = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSDEFUIMode(pSDEFUIMode);
        pSCoreSysServiceBase = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridColServiceBase)pSCoreSysServiceBase).testRemoveByPSDEFUIMode(pSDEFUIMode);
        pSCoreSysServiceBase = (PSDETreeNodeColService)ServiceGlobal.getService(PSDETreeNodeColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeColServiceBase)pSCoreSysServiceBase).testRemoveByPSDEFUIMode(pSDEFUIMode);
        super.onBeforeRemove(pSDEFUIMode);
    }

    protected void replaceParentInfo(PSDEFUIMode pSDEFUIMode, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEFUIMode, cloneSession);
        if (pSDEFUIMode.getItemPSACHandlerId() != null && (iEntity = cloneSession.getEntity("PSACHANDLER", (Object)pSDEFUIMode.getItemPSACHandlerId())) != null) {
            this.onFillParentInfo_ItemPSACHandler(pSDEFUIMode, (PSACHandler)iEntity);
        }
        if (pSDEFUIMode.getPSCodeListId() != null && (iEntity = cloneSession.getEntity("PSCODELIST", (Object)pSDEFUIMode.getPSCodeListId())) != null) {
            this.onFillParentInfo_PSCodeList(pSDEFUIMode, (PSCodeList)iEntity);
        }
        if (pSDEFUIMode.getRefPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEFUIMode.getRefPSDEId())) != null) {
            this.onFillParentInfo_RefPSDE(pSDEFUIMode, (PSDataEntity)iEntity);
        }
        if (pSDEFUIMode.getRefPSDEACModeId() != null && (iEntity = cloneSession.getEntity("PSDEACMODE", (Object)pSDEFUIMode.getRefPSDEACModeId())) != null) {
            this.onFillParentInfo_RefPSDEACMode(pSDEFUIMode, (PSDEACMode)iEntity);
        }
        if (pSDEFUIMode.getRefPSDEDataSetId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSDEFUIMode.getRefPSDEDataSetId())) != null) {
            this.onFillParentInfo_RefPSDEDataSet(pSDEFUIMode, (PSDEDataSet)iEntity);
        }
        if (pSDEFUIMode.getPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEFUIMode.getPSDEFId())) != null) {
            this.onFillParentInfo_PSDEF(pSDEFUIMode, (PSDEField)iEntity);
        }
        if (pSDEFUIMode.getPSDEFInputTipId() != null && (iEntity = cloneSession.getEntity("PSDEFINPUTTIP", (Object)pSDEFUIMode.getPSDEFInputTipId())) != null) {
            this.onFillParentInfo_PSDEFInputTip(pSDEFUIMode, (PSDEFInputTip)iEntity);
        }
        if (pSDEFUIMode.getRefADPSDELogicId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSDEFUIMode.getRefADPSDELogicId())) != null) {
            this.onFillParentInfo_RefADPSDELogic(pSDEFUIMode, (PSDELogic)iEntity);
        }
        if (pSDEFUIMode.getRefPSDERId() != null && (iEntity = cloneSession.getEntity("PSDER", (Object)pSDEFUIMode.getRefPSDERId())) != null) {
            this.onFillParentInfo_RefPSDER(pSDEFUIMode, (PSDER)iEntity);
        }
        if (pSDEFUIMode.getRefLinkPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSDEFUIMode.getRefLinkPSDEViewId())) != null) {
            this.onFillParentInfo_RefLinkPSDEView(pSDEFUIMode, (PSDEViewBase)iEntity);
        }
        if (pSDEFUIMode.getRefMPickupPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSDEFUIMode.getRefMPickupPSDEViewId())) != null) {
            this.onFillParentInfo_RefMPickupPSDEView(pSDEFUIMode, (PSDEViewBase)iEntity);
        }
        if (pSDEFUIMode.getRefPickupPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSDEFUIMode.getRefPickupPSDEViewId())) != null) {
            this.onFillParentInfo_RefPickupPSDEView(pSDEFUIMode, (PSDEViewBase)iEntity);
        }
        if (pSDEFUIMode.getCapPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEFUIMode.getCapPSLanResId())) != null) {
            this.onFillParentInfo_CapPSLanRes(pSDEFUIMode, (PSLanguageRes)iEntity);
        }
        if (pSDEFUIMode.getPHPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEFUIMode.getPHPSLanResId())) != null) {
            this.onFillParentInfo_PHPSLanRes(pSDEFUIMode, (PSLanguageRes)iEntity);
        }
        if (pSDEFUIMode.getPSSysAppId() != null && (iEntity = cloneSession.getEntity("PSSYSAPP", (Object)pSDEFUIMode.getPSSysAppId())) != null) {
            this.onFillParentInfo_PSSysApp(pSDEFUIMode, (PSSysApp)iEntity);
        }
        if (pSDEFUIMode.getPSSysDictCatId() != null && (iEntity = cloneSession.getEntity("PSSYSDICTCAT", (Object)pSDEFUIMode.getPSSysDictCatId())) != null) {
            this.onFillParentInfo_PSSysDictCat(pSDEFUIMode, (PSSysDictCat)iEntity);
        }
        if (pSDEFUIMode.getPSSysEditorStyleId() != null && (iEntity = cloneSession.getEntity("PSSYSEDITORSTYLE", (Object)pSDEFUIMode.getPSSysEditorStyleId())) != null) {
            this.onFillParentInfo_PSSysEditorStyle(pSDEFUIMode, (PSSysEditorStyle)iEntity);
        }
        if (pSDEFUIMode.getPSSysImageId() != null && (iEntity = cloneSession.getEntity("PSSYSIMAGE", (Object)pSDEFUIMode.getPSSysImageId())) != null) {
            this.onFillParentInfo_PSSysImage(pSDEFUIMode, (PSSysImage)iEntity);
        }
        if (pSDEFUIMode.getGCRPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSDEFUIMode.getGCRPSSysPFPluginId())) != null) {
            this.onFillParentInfo_GCRPSSysPFPlugin(pSDEFUIMode, (PSSysPFPlugin)iEntity);
        }
        if (pSDEFUIMode.getPSSysUnitId() != null && (iEntity = cloneSession.getEntity("PSSYSUNIT", (Object)pSDEFUIMode.getPSSysUnitId())) != null) {
            this.onFillParentInfo_PSSysUnit(pSDEFUIMode, (PSSysUnit)iEntity);
        }
        if (pSDEFUIMode.getPSSysValueRuleId() != null && (iEntity = cloneSession.getEntity("PSSYSVALUERULE", (Object)pSDEFUIMode.getPSSysValueRuleId())) != null) {
            this.onFillParentInfo_PSSysValueRule(pSDEFUIMode, (PSSysValueRule)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEFUIMode pSDEFUIMode, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEFUIMode, bl);
        pSDEFUIMode.resetCodeName();
    }

    protected void onCheckEntity(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AllowEmpty(bl, pSDEFUIMode, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CapPSLanResId(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CapPSLanResName(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Caption(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeListConfigMode(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ConvertCIText(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CreateDV(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CreateDVT(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EditorParams(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EditorType(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EditorTypeName(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableInputTip(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableResetItemName(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableUnitName(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableValueRule(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FTMode(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GCRPSSysPFPluginId(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GridColAlign(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GridColCLMode(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GridColWidth(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Height(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IgnoreInput(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemPSACHandlerId(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_JSFormat(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MaxValue(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinStrLength(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinValue(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NeedCodeListConfig(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NoSort(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PHPSLanResId(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PHPSLanResName(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PickupTextOpts(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PlaceHolder(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Precision2(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PreventXSS(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCodeListId(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFUIModeId(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFUIModeName(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFId(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFInputTipId(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFName(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppId(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDictCatId(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysEditorStyleId(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysImageId(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUnitId(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysValueRuleId(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefADPSDELogicId(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefLinkPSDEViewId(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefMPickupPSDEViewId(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPickupPSDEViewId(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDEACModeId(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDEDataSetId(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDEId(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDEName(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDERId(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDERName(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefTempData(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResetItemName(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StringCase(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StrLength(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UnitName(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UnitNameWidth(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UpdateDV(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UpdateDVT(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserParams(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValueFormat(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValueItemName(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Width(bl, pSDEFUIMode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEFUIMode, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AllowEmpty(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isAllowEmptyDirty() : !pSDEFUIMode.isAllowEmptyDirty()) {
            return null;
        }
        Integer n = pSDEFUIMode.getAllowEmpty();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AllowEmpty_Default(pSDEFUIMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ALLOWEMPTY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CapPSLanResId(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isCapPSLanResIdDirty() : !pSDEFUIMode.isCapPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getCapPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CapPSLanResId_Default(pSDEFUIMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_CapPSLanResName(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isCapPSLanResNameDirty() : !pSDEFUIMode.isCapPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getCapPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CapPSLanResName_Default(pSDEFUIMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_Caption(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isCaptionDirty() : !pSDEFUIMode.isCaptionDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getCaption();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Caption_Default(pSDEFUIMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_CodeListConfigMode(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isCodeListConfigModeDirty() : !pSDEFUIMode.isCodeListConfigModeDirty()) {
            return null;
        }
        Integer n = pSDEFUIMode.getCodeListConfigMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CodeListConfigMode_Default(pSDEFUIMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODELISTCONFIGMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isCodeNameDirty() : !pSDEFUIMode.isCodeNameDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSDEFUIMode, bl2, bl3);
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
                string3 = "PSDEFID";
                String string4 = this.checkFieldDupRule(this.getPSDEFUIModeDEModel(), "CODENAME", string3, pSDEFUIMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_ConvertCIText(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isConvertCITextDirty() : !pSDEFUIMode.isConvertCITextDirty()) {
            return null;
        }
        Integer n = pSDEFUIMode.getConvertCIText();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ConvertCIText_Default(pSDEFUIMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONVERTCITEXT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CreateDV(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isCreateDVDirty() : !pSDEFUIMode.isCreateDVDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getCreateDV();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CreateDV_Default(pSDEFUIMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CREATEDV");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CreateDVT(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isCreateDVTDirty() : !pSDEFUIMode.isCreateDVTDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getCreateDVT();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CreateDVT_Default(pSDEFUIMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CREATEDVT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isDynaModelFlagDirty() : !pSDEFUIMode.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSDEFUIMode.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default(pSDEFUIMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_EditorParams(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isEditorParamsDirty() : !pSDEFUIMode.isEditorParamsDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getEditorParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EditorParams_Default(pSDEFUIMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EDITORPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EditorType(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isEditorTypeDirty() : !pSDEFUIMode.isEditorTypeDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getEditorType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EditorType_Default(pSDEFUIMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_EditorTypeName(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isEditorTypeNameDirty() : !pSDEFUIMode.isEditorTypeNameDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getEditorTypeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EditorTypeName_Default(pSDEFUIMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_EnableInputTip(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isEnableInputTipDirty() : !pSDEFUIMode.isEnableInputTipDirty()) {
            return null;
        }
        Integer n = pSDEFUIMode.getEnableInputTip();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableInputTip_Default(pSDEFUIMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEINPUTTIP");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableResetItemName(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isEnableResetItemNameDirty() : !pSDEFUIMode.isEnableResetItemNameDirty()) {
            return null;
        }
        Integer n = pSDEFUIMode.getEnableResetItemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableResetItemName_Default(pSDEFUIMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLERESETITEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableUnitName(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isEnableUnitNameDirty() : !pSDEFUIMode.isEnableUnitNameDirty()) {
            return null;
        }
        Integer n = pSDEFUIMode.getEnableUnitName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableUnitName_Default(pSDEFUIMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEUNITNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableValueRule(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isEnableValueRuleDirty() : !pSDEFUIMode.isEnableValueRuleDirty()) {
            return null;
        }
        Integer n = pSDEFUIMode.getEnableValueRule();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableValueRule_Default(pSDEFUIMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEVALUERULE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FTMode(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isFTModeDirty() && !bl2 : !pSDEFUIMode.isFTModeDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getFTMode();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FTMODE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_FTMode_Default(pSDEFUIMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FTMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            bl4 = DataTypeHelper.compare((int)25, (Object)string, (Object)DATASET_DEFAULT) == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"MOBILEDEFAULT") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"MODE1") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"MODE2") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"MODE3") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"MODE4") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"MODE5") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"MODE6") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"MODE7") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"MODE8") == 0L || DataTypeHelper.compare((int)25, (Object)string, (Object)"MODE9") == 0L;
            if (bl4) {
                String string3 = "";
                string3 = "PSDEFID";
                String string4 = this.checkFieldDupRule(this.getPSDEFUIModeDEModel(), "FTMODE", string3, pSDEFUIMode, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("FTMODE");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GCRPSSysPFPluginId(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isGCRPSSysPFPluginIdDirty() : !pSDEFUIMode.isGCRPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getGCRPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GCRPSSysPFPluginId_Default(pSDEFUIMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GCRPSSYSPFPLUGINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GridColAlign(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isGridColAlignDirty() : !pSDEFUIMode.isGridColAlignDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getGridColAlign();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GridColAlign_Default(pSDEFUIMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GRIDCOLALIGN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GridColCLMode(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isGridColCLModeDirty() : !pSDEFUIMode.isGridColCLModeDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getGridColCLMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GridColCLMode_Default(pSDEFUIMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GRIDCOLCLMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GridColWidth(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isGridColWidthDirty() : !pSDEFUIMode.isGridColWidthDirty()) {
            return null;
        }
        Integer n = pSDEFUIMode.getGridColWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_GridColWidth_Default(pSDEFUIMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GRIDCOLWIDTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Height(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isHeightDirty() : !pSDEFUIMode.isHeightDirty()) {
            return null;
        }
        Integer n = pSDEFUIMode.getHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Height_Default(pSDEFUIMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_IgnoreInput(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isIgnoreInputDirty() : !pSDEFUIMode.isIgnoreInputDirty()) {
            return null;
        }
        Integer n = pSDEFUIMode.getIgnoreInput();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_IgnoreInput_Default(pSDEFUIMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IGNOREINPUT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemPSACHandlerId(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isItemPSACHandlerIdDirty() : !pSDEFUIMode.isItemPSACHandlerIdDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getItemPSACHandlerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemPSACHandlerId_Default(pSDEFUIMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMPSACHANDLERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_JSFormat(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isJSFormatDirty() : !pSDEFUIMode.isJSFormatDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getJSFormat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_JSFormat_Default(pSDEFUIMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("JSFORMAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isLockFlagDirty() : !pSDEFUIMode.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSDEFUIMode.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default(pSDEFUIMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_MaxValue(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isMaxValueDirty() : !pSDEFUIMode.isMaxValueDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getMaxValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MaxValue_Default(pSDEFUIMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAXVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isMemoDirty() : !pSDEFUIMode.isMemoDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDEFUIMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_MinStrLength(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isMinStrLengthDirty() : !pSDEFUIMode.isMinStrLengthDirty()) {
            return null;
        }
        Integer n = pSDEFUIMode.getMinStrLength();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MinStrLength_Default(pSDEFUIMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINSTRLENGTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MinValue(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isMinValueDirty() : !pSDEFUIMode.isMinValueDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getMinValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinValue_Default(pSDEFUIMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NeedCodeListConfig(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isNeedCodeListConfigDirty() : !pSDEFUIMode.isNeedCodeListConfigDirty()) {
            return null;
        }
        Integer n = pSDEFUIMode.getNeedCodeListConfig();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NeedCodeListConfig_Default(pSDEFUIMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NEEDCODELISTCONFIG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NoSort(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isNoSortDirty() : !pSDEFUIMode.isNoSortDirty()) {
            return null;
        }
        Integer n = pSDEFUIMode.getNoSort();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NoSort_Default(pSDEFUIMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NOSORT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PHPSLanResId(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isPHPSLanResIdDirty() : !pSDEFUIMode.isPHPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getPHPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PHPSLanResId_Default(pSDEFUIMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PHPSLanResName(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isPHPSLanResNameDirty() : !pSDEFUIMode.isPHPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getPHPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PHPSLanResName_Default(pSDEFUIMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PickupTextOpts(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isPickupTextOptsDirty() : !pSDEFUIMode.isPickupTextOptsDirty()) {
            return null;
        }
        Integer n = pSDEFUIMode.getPickupTextOpts();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PickupTextOpts_Default(pSDEFUIMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PICKUPTEXTOPTS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PlaceHolder(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isPlaceHolderDirty() : !pSDEFUIMode.isPlaceHolderDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getPlaceHolder();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PlaceHolder_Default(pSDEFUIMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_Precision2(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isPrecision2Dirty() : !pSDEFUIMode.isPrecision2Dirty()) {
            return null;
        }
        Integer n = pSDEFUIMode.getPrecision2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Precision2_Default(pSDEFUIMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PRECISION2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PreventXSS(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isPreventXSSDirty() : !pSDEFUIMode.isPreventXSSDirty()) {
            return null;
        }
        Integer n = pSDEFUIMode.getPreventXSS();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PreventXSS_Default(pSDEFUIMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREVENTXSS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCodeListId(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isPSCodeListIdDirty() : !pSDEFUIMode.isPSCodeListIdDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getPSCodeListId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCodeListId_Default(pSDEFUIMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFUIModeId(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isPSDEFUIModeIdDirty() && !bl2 : !pSDEFUIMode.isPSDEFUIModeIdDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getPSDEFUIModeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFFORMITEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFUIModeId_Default(pSDEFUIMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFFORMITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFUIModeName(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isPSDEFUIModeNameDirty() && !bl2 : !pSDEFUIMode.isPSDEFUIModeNameDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getPSDEFUIModeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFFORMITEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFUIModeName_Default(pSDEFUIMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFFORMITEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFId(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isPSDEFIdDirty() && !bl2 : !pSDEFUIMode.isPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getPSDEFId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFId_Default(pSDEFUIMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFInputTipId(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isPSDEFInputTipIdDirty() : !pSDEFUIMode.isPSDEFInputTipIdDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getPSDEFInputTipId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFInputTipId_Default(pSDEFUIMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFINPUTTIPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFName(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isPSDEFNameDirty() && !bl2 : !pSDEFUIMode.isPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getPSDEFName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFName_Default(pSDEFUIMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isPSDynaInstIdDirty() : !pSDEFUIMode.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default(pSDEFUIMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysAppId(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isPSSysAppIdDirty() : !pSDEFUIMode.isPSSysAppIdDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getPSSysAppId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppId_Default(pSDEFUIMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPID");
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
                string3 = "PSDEFID";
                String string4 = this.checkFieldDupRule(this.getPSDEFUIModeDEModel(), "PSSYSAPPID", string3, pSDEFUIMode, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSAPPID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDictCatId(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isPSSysDictCatIdDirty() : !pSDEFUIMode.isPSSysDictCatIdDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getPSSysDictCatId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDictCatId_Default(pSDEFUIMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDICTCATID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysEditorStyleId(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isPSSysEditorStyleIdDirty() : !pSDEFUIMode.isPSSysEditorStyleIdDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getPSSysEditorStyleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysEditorStyleId_Default(pSDEFUIMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysImageId(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isPSSysImageIdDirty() : !pSDEFUIMode.isPSSysImageIdDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getPSSysImageId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysImageId_Default(pSDEFUIMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysUnitId(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isPSSysUnitIdDirty() : !pSDEFUIMode.isPSSysUnitIdDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getPSSysUnitId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUnitId_Default(pSDEFUIMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUNITID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysValueRuleId(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isPSSysValueRuleIdDirty() : !pSDEFUIMode.isPSSysValueRuleIdDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getPSSysValueRuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysValueRuleId_Default(pSDEFUIMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_RefADPSDELogicId(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isRefADPSDELogicIdDirty() : !pSDEFUIMode.isRefADPSDELogicIdDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getRefADPSDELogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefADPSDELogicId_Default(pSDEFUIMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_RefLinkPSDEViewId(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isRefLinkPSDEViewIdDirty() : !pSDEFUIMode.isRefLinkPSDEViewIdDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getRefLinkPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefLinkPSDEViewId_Default(pSDEFUIMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFLINKPSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefMPickupPSDEViewId(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isRefMPickupPSDEViewIdDirty() : !pSDEFUIMode.isRefMPickupPSDEViewIdDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getRefMPickupPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefMPickupPSDEViewId_Default(pSDEFUIMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_RefPickupPSDEViewId(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isRefPickupPSDEViewIdDirty() : !pSDEFUIMode.isRefPickupPSDEViewIdDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getRefPickupPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPickupPSDEViewId_Default(pSDEFUIMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_RefPSDEACModeId(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isRefPSDEACModeIdDirty() : !pSDEFUIMode.isRefPSDEACModeIdDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getRefPSDEACModeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDEACModeId_Default(pSDEFUIMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_RefPSDEDataSetId(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isRefPSDEDataSetIdDirty() : !pSDEFUIMode.isRefPSDEDataSetIdDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getRefPSDEDataSetId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDEDataSetId_Default(pSDEFUIMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_RefPSDEId(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isRefPSDEIdDirty() : !pSDEFUIMode.isRefPSDEIdDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getRefPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDEId_Default(pSDEFUIMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_RefPSDEName(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isRefPSDENameDirty() : !pSDEFUIMode.isRefPSDENameDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getRefPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDEName_Default(pSDEFUIMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_RefPSDERId(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isRefPSDERIdDirty() : !pSDEFUIMode.isRefPSDERIdDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getRefPSDERId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDERId_Default(pSDEFUIMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_RefPSDERName(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isRefPSDERNameDirty() : !pSDEFUIMode.isRefPSDERNameDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getRefPSDERName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDERName_Default(pSDEFUIMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_RefTempData(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isRefTempDataDirty() : !pSDEFUIMode.isRefTempDataDirty()) {
            return null;
        }
        Integer n = pSDEFUIMode.getRefTempData();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RefTempData_Default(pSDEFUIMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFTEMPDATA");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ResetItemName(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isResetItemNameDirty() : !pSDEFUIMode.isResetItemNameDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getResetItemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ResetItemName_Default(pSDEFUIMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESETITEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StringCase(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isStringCaseDirty() : !pSDEFUIMode.isStringCaseDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getStringCase();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StringCase_Default(pSDEFUIMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STRINGCASE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StrLength(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isStrLengthDirty() : !pSDEFUIMode.isStrLengthDirty()) {
            return null;
        }
        Integer n = pSDEFUIMode.getStrLength();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_StrLength_Default(pSDEFUIMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STRLENGTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UnitName(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isUnitNameDirty() : !pSDEFUIMode.isUnitNameDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getUnitName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UnitName_Default(pSDEFUIMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UNITNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UnitNameWidth(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isUnitNameWidthDirty() : !pSDEFUIMode.isUnitNameWidthDirty()) {
            return null;
        }
        Integer n = pSDEFUIMode.getUnitNameWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UnitNameWidth_Default(pSDEFUIMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UNITNAMEWIDTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UpdateDV(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isUpdateDVDirty() : !pSDEFUIMode.isUpdateDVDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getUpdateDV();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UpdateDV_Default(pSDEFUIMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UPDATEDV");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UpdateDVT(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isUpdateDVTDirty() : !pSDEFUIMode.isUpdateDVTDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getUpdateDVT();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UpdateDVT_Default(pSDEFUIMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UPDATEDVT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isUserCatDirty() : !pSDEFUIMode.isUserCatDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDEFUIMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserParams(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isUserParamsDirty() : !pSDEFUIMode.isUserParamsDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getUserParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserParams_Default(pSDEFUIMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isUserTagDirty() : !pSDEFUIMode.isUserTagDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDEFUIMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isUserTag2Dirty() : !pSDEFUIMode.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEFUIMode.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDEFUIMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isUserTag3Dirty() : !pSDEFUIMode.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEFUIMode.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDEFUIMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isUserTag4Dirty() : !pSDEFUIMode.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEFUIMode.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDEFUIMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValueFormat(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isValueFormatDirty() : !pSDEFUIMode.isValueFormatDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getValueFormat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ValueFormat_Default(pSDEFUIMode, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValueItemName(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isValueItemNameDirty() : !pSDEFUIMode.isValueItemNameDirty()) {
            return null;
        }
        String string = pSDEFUIMode.getValueItemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ValueItemName_Default(pSDEFUIMode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALUEITEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Width(boolean bl, PSDEFUIMode pSDEFUIMode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFUIMode.isWidthDirty() : !pSDEFUIMode.isWidthDirty()) {
            return null;
        }
        Integer n = pSDEFUIMode.getWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Width_Default(pSDEFUIMode, bl2, bl3);
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

    protected void onSyncEntity(PSDEFUIMode pSDEFUIMode, boolean bl) throws Exception {
        super.onSyncEntity(pSDEFUIMode, bl);
    }

    protected void onSyncIndexEntities(PSDEFUIMode pSDEFUIMode, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEFUIMode, bl);
    }

    public Object getDataContextValue(PSDEFUIMode pSDEFUIMode, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEACMODE", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFPSDEACMODEID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFPSDEACMODENAME", (boolean)true) == 0) && (object = super.getDataContextValue(pSDEFUIMode, "refpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEDATASET", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFPSDEDATASETID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFPSDEDATASETNAME", (boolean)true) == 0) && (object = super.getDataContextValue(pSDEFUIMode, "refpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDELOGIC", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFADPSDELOGICID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFADPSDELOGICNAME", (boolean)true) == 0) && (object = super.getDataContextValue(pSDEFUIMode, "refpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEVIEWBASE", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFLINKPSDEVIEWID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFLINKPSDEVIEWNAME", (boolean)true) == 0) && (object = super.getDataContextValue(pSDEFUIMode, "refpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEVIEWBASE", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFMPICKUPPSDEVIEWID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFMPICKUPPSDEVIEWNAME", (boolean)true) == 0) && (object = super.getDataContextValue(pSDEFUIMode, "refpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEVIEWBASE", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFPICKUPPSDEVIEWID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFPICKUPPSDEVIEWNAME", (boolean)true) == 0) && (object = super.getDataContextValue(pSDEFUIMode, "refpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSSYSEDITORSTYLE", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSEDITORTYPEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"PSSYSEDITORSTYLEID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"PSSYSEDITORSTYLENAME", (boolean)true) == 0) && (object = super.getDataContextValue(pSDEFUIMode, "editortype", iDataContextParam)) != null) {
                return object;
            }
        }
        if ((object = super.getDataContextValue(pSDEFUIMode, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEField pSDEField = pSDEFUIMode.getPSDEF();
        if (pSDEField != null && pSDEField.contains(string)) {
            return pSDEField.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEFUIMode pSDEFUIMode, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportMajorModel_CapPSLanRes(pSDEFUIMode, arrayList, n);
        this.onExportMajorModel_PHPSLanRes(pSDEFUIMode, arrayList, n);
        super.onExportMajorModel(pSDEFUIMode, arrayList, n);
    }

    protected void onExportMajorModel_CapPSLanRes(PSDEFUIMode pSDEFUIMode, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSDEFUIMode.getCapPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel(pSDEFUIMode.getCapPSLanRes(), arrayList, n);
        }
    }

    protected void onExportMajorModel_PHPSLanRes(PSDEFUIMode pSDEFUIMode, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSDEFUIMode.getPHPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel(pSDEFUIMode.getPHPSLanRes(), arrayList, n);
        }
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ALLOWEMPTY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AllowEmpty_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"CODELISTCONFIGMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeListConfigMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONVERTCITEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ConvertCIText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDV", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDV_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDVT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDVT_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EDITORPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EditorParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EDITORTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EditorType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EDITORTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EditorTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEINPUTTIP", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableInputTip_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLERESETITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableResetItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEUNITNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableUnitName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEVALUERULE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableValueRule_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FTMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FTMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GCRPSSYSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GCRPSSysPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GCRPSSYSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GCRPSSysPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GRIDCOLALIGN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GridColAlign_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GRIDCOLCLMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GridColCLMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GRIDCOLWIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GridColWidth_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HEIGHT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Height_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IGNOREINPUT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IgnoreInput_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMPSACHANDLERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemPSACHandlerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMPSACHANDLERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemPSACHandlerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"JSFORMAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_JSFormat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAXVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MaxValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINSTRLENGTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinStrLength_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NEEDCODELISTCONFIG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NeedCodeListConfig_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NOSORT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NoSort_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PHPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PHPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PHPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PHPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PICKUPTEXTOPTS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PickupTextOpts_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PLACEHOLDER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PlaceHolder_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PRECISION2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Precision2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREVENTXSS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PreventXSS_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCODELISTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCodeListId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCODELISTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCodeListName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFFORMITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFUIModeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFFORMITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFUIModeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFINPUTTIPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFInputTipId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFINPUTTIPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFInputTipName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDICTCATID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDictCatId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDICTCATNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDictCatName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUNITID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUnitId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUNITNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUnitName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"REFLINKPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefLinkPSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFLINKPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefLinkPSDEViewName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"REFTEMPDATA", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefTempData_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESETITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResetItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STRINGCASE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StringCase_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STRLENGTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StrLength_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UNITNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UnitName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UNITNAMEWIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UnitNameWidth_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDV", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDV_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDVT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDVT_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VALUEITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValueItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Width_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AllowEmpty_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_CodeListConfigMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ConvertCIText_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CreateDate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CreateDV_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATEDV", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CreateDVT_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATEDVT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EditorParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EDITORPARAMS", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
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

    protected String onTestValueRule_EnableInputTip_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableResetItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableUnitName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableValueRule_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FTMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FTMODE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GCRPSSysPFPluginId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GCRPSSYSPFPLUGINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GCRPSSysPFPluginName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GCRPSSYSPFPLUGINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GridColAlign_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GRIDCOLALIGN", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GridColCLMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GRIDCOLCLMODE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GridColWidth_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Height_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_IgnoreInput_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ItemPSACHandlerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMPSACHANDLERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ItemPSACHandlerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMPSACHANDLERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_JSFormat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("JSFORMAT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
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

    protected String onTestValueRule_MaxValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAXVALUE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected String onTestValueRule_MinStrLength_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MinValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINVALUE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NeedCodeListConfig_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_NoSort_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PickupTextOpts_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_Precision2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PreventXSS_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSDEFUIModeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFFORMITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFUIModeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFFORMITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDEFInputTipId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFINPUTTIPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFInputTipName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFINPUTTIPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSSysDictCatId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDICTCATID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDictCatName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDICTCATNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysUnitId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUNITID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUnitName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUNITNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_RefLinkPSDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFLINKPSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefLinkPSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFLINKPSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_RefTempData_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ResetItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RESETITEMNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StringCase_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STRINGCASE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StrLength_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UnitName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UNITNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UnitNameWidth_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UpdateDate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UpdateDV_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPDATEDV", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UpdateDVT_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPDATEDVT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_ValueItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VALUEITEMNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    protected boolean onMergeChild(String string, String string2, PSDEFUIMode pSDEFUIMode) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEFUIMode)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEFUIMode pSDEFUIMode) throws Exception {
        Object object = pSDEFUIMode.get("PSDEFID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEFFORMITEM_PSDEFIELD_PSDEFID", object);
        }
        super.onUpdateParent(pSDEFUIMode);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSDEFUIMode pSDEFUIMode, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEFUIMODE");
        if (!bl) {
            pSDEFUIMode.setCreateDate(null);
            pSDEFUIMode.setCreateMan(null);
            pSDEFUIMode.setPSDEFUIModeId(null);
            pSDEFUIMode.setUpdateDate(null);
            pSDEFUIMode.setUpdateMan(null);
            super.exportCurXmlModel(pSDEFUIMode, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEFUIMode pSDEFUIMode, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEFUIMode, string);
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
            return "DER1N_PSDEFFORMITEM_PSDEFIELD_PSDEFID";
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
    public String getModelV2Tag(PSDEFUIMode pSDEFUIMode) {
        if (!StringHelper.isNullOrEmpty((String)pSDEFUIMode.getCodeName())) {
            return pSDEFUIMode.getCodeName();
        }
        return super.getModelV2Tag(pSDEFUIMode);
    }

    @Override
    public boolean setModelV2Tag(PSDEFUIMode pSDEFUIMode, String string) {
        pSDEFUIMode.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSDEFID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEFUIMode pSDEFUIMode, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEFUIMode.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEFUIMode, true);
        pSDEFUIMode.set("CODENAME", string);
        if (this.select(pSDEFUIMode, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEFUIMode, true);
        return super.getModelV2Entity(pSDEFUIMode, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEFUIMode pSDEFUIMode, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEFUIMode, objectNode, string, string2, n);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSDEFUIMode pSDEFUIMode, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "UIMode");
    }
}

