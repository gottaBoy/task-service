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
package net.ibizsys.pscore.srv.bidesign.service;

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
import net.ibizsys.pscore.srv.bidesign.dao.PSSysBICubeMeasureDAO;
import net.ibizsys.pscore.srv.bidesign.demodel.PSSysBICubeMeasureDEModel;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICube;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeBase;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeMeasure;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIAggColumnService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIAggColumnServiceBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeMSCondService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeMSCondServiceBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeMSJoinService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeMSJoinServiceBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIReportItemService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIReportItemServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeListBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTranslator;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTranslatorBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSThresholdGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSThresholdGroupBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysBICubeMeasureServiceBase
extends PSCoreSysServiceBase<PSSysBICubeMeasure> {
    private static final Log log = LogFactory.getLog(PSSysBICubeMeasureServiceBase.class);
    public static final String DATASET_CURCUBE = "CurCube";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSSysBICubeMeasureDEModel pSSysBICubeMeasureDEModel;
    private PSSysBICubeMeasureDAO pSSysBICubeMeasureDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeMeasureService";
    }

    public PSSysBICubeMeasureDEModel getPSSysBICubeMeasureDEModel() {
        if (this.pSSysBICubeMeasureDEModel == null) {
            try {
                this.pSSysBICubeMeasureDEModel = (PSSysBICubeMeasureDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.bidesign.demodel.PSSysBICubeMeasureDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBICubeMeasureDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysBICubeMeasureDEModel();
    }

    public PSSysBICubeMeasureDAO getPSSysBICubeMeasureDAO() {
        if (this.pSSysBICubeMeasureDAO == null) {
            try {
                this.pSSysBICubeMeasureDAO = (PSSysBICubeMeasureDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.bidesign.dao.PSSysBICubeMeasureDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBICubeMeasureDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysBICubeMeasureDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURCUBE, (boolean)true) == 0) {
            return this.fetchCurCube(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurCube(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURCUBE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSysBICubeMeasure pSSysBICubeMeasure, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBICUBEMEASURE_PSCODELIST_PSCODELISTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService", (SessionFactory)this.getSessionFactory());
            PSCodeList pSCodeList = (PSCodeList)iService.getDEModel().createEntity();
            pSCodeList.set("PSCODELISTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCodeList);
            } else {
                iService.get(pSCodeList);
            }
            this.onFillParentInfo_PSCodeList(pSSysBICubeMeasure, pSCodeList);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBICUBEMEASURE_PSDEFIELD_PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_PSDEF(pSSysBICubeMeasure, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBICUBEMEASURE_PSDEUIACTION_PARAMPSDEUIACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService", (SessionFactory)this.getSessionFactory());
            PSDEUIAction pSDEUIAction = (PSDEUIAction)iService.getDEModel().createEntity();
            pSDEUIAction.set("PSDEUIACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEUIAction);
            } else {
                iService.get(pSDEUIAction);
            }
            this.onFillParentInfo_ParamPSDEUIAction(pSSysBICubeMeasure, pSDEUIAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBICUBEMEASURE_PSDEVIEWBASE_DRILLDETAILPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewBase);
            } else {
                iService.get(pSDEViewBase);
            }
            this.onFillParentInfo_DrillDetailPSDEView(pSSysBICubeMeasure, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBICUBEMEASURE_PSDEVIEWBASE_DRILLDOWNPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewBase);
            } else {
                iService.get(pSDEViewBase);
            }
            this.onFillParentInfo_DrillDownPSDEView(pSSysBICubeMeasure, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBICUBEMEASURE_PSSYSBICUBE_PSSYSBICUBEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeService", (SessionFactory)this.getSessionFactory());
            PSSysBICube pSSysBICube = (PSSysBICube)iService.getDEModel().createEntity();
            pSSysBICube.set("PSSYSBICUBEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysBICube);
            } else {
                iService.get(pSSysBICube);
            }
            this.onFillParentInfo_PSSysBICube(pSSysBICubeMeasure, pSSysBICube);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBICUBEMEASURE_PSSYSTRANSLATOR_PSSYSTRANSLATORID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysTranslatorService", (SessionFactory)this.getSessionFactory());
            PSSysTranslator pSSysTranslator = (PSSysTranslator)iService.getDEModel().createEntity();
            pSSysTranslator.set("PSSYSTRANSLATORID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysTranslator);
            } else {
                iService.get(pSSysTranslator);
            }
            this.onFillParentInfo_PSSysTranslator(pSSysBICubeMeasure, pSSysTranslator);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBICUBEMEASURE_PSTHRESHOLDGROUP_PSTHRESHOLDGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSThresholdGroupService", (SessionFactory)this.getSessionFactory());
            PSThresholdGroup pSThresholdGroup = (PSThresholdGroup)iService.getDEModel().createEntity();
            pSThresholdGroup.set("PSTHRESHOLDGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSThresholdGroup);
            } else {
                iService.get(pSThresholdGroup);
            }
            this.onFillParentInfo_PSThresholdGroup(pSSysBICubeMeasure, pSThresholdGroup);
            return;
        }
        super.onFillParentInfo(pSSysBICubeMeasure, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSCodeList(PSSysBICubeMeasure pSSysBICubeMeasure, PSCodeList pSCodeList) throws Exception {
        pSSysBICubeMeasure.setPSCodeListId(pSCodeList.getPSCodeListId());
        pSSysBICubeMeasure.setPSCodeListName(pSCodeList.getPSCodeListName());
    }

    protected void onFillParentInfo_PSDEF(PSSysBICubeMeasure pSSysBICubeMeasure, PSDEField pSDEField) throws Exception {
        pSSysBICubeMeasure.setPSDEFId(pSDEField.getPSDEFieldId());
        pSSysBICubeMeasure.setPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_ParamPSDEUIAction(PSSysBICubeMeasure pSSysBICubeMeasure, PSDEUIAction pSDEUIAction) throws Exception {
        pSSysBICubeMeasure.setParamPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
        pSSysBICubeMeasure.setParamPSDEUIActionName(pSDEUIAction.getPSDEUIActionName());
    }

    protected void onFillParentInfo_DrillDetailPSDEView(PSSysBICubeMeasure pSSysBICubeMeasure, PSDEViewBase pSDEViewBase) throws Exception {
        pSSysBICubeMeasure.setDrillDetailPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSSysBICubeMeasure.setDrillDetailPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_DrillDownPSDEView(PSSysBICubeMeasure pSSysBICubeMeasure, PSDEViewBase pSDEViewBase) throws Exception {
        pSSysBICubeMeasure.setDrillDownPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSSysBICubeMeasure.setDrillDownPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_PSSysBICube(PSSysBICubeMeasure pSSysBICubeMeasure, PSSysBICube pSSysBICube) throws Exception {
        pSSysBICubeMeasure.setPSDEId(pSSysBICube.getPSDEId());
        pSSysBICubeMeasure.setPSSysBICubeId(pSSysBICube.getPSSysBICubeId());
        pSSysBICubeMeasure.setPSSysBICubeName(pSSysBICube.getPSSysBICubeName());
        pSSysBICubeMeasure.setPSSysBISchemeId(pSSysBICube.getPSSysBISchemeId());
    }

    protected void onFillParentInfo_PSSysTranslator(PSSysBICubeMeasure pSSysBICubeMeasure, PSSysTranslator pSSysTranslator) throws Exception {
        pSSysBICubeMeasure.setPSSysTranslatorId(pSSysTranslator.getPSSysTranslatorId());
        pSSysBICubeMeasure.setPSSysTranslatorName(pSSysTranslator.getPSSysTranslatorName());
    }

    protected void onFillParentInfo_PSThresholdGroup(PSSysBICubeMeasure pSSysBICubeMeasure, PSThresholdGroup pSThresholdGroup) throws Exception {
        pSSysBICubeMeasure.setPSThresholdGroupId(pSThresholdGroup.getPSThresholdGroupId());
        pSSysBICubeMeasure.setPSThresholdGroupName(pSThresholdGroup.getPSThresholdGroupName());
    }

    protected void onFillEntityFullInfo(PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl) throws Exception {
        if (bl) {
            if (pSSysBICubeMeasure.getCodeName() == null) {
                pSSysBICubeMeasure.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "Measure", 25));
            }
            if (pSSysBICubeMeasure.getValidFlag() == null) {
                pSSysBICubeMeasure.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSSysBICubeMeasure, bl);
        this.onFillEntityFullInfo_PSCodeList(pSSysBICubeMeasure, bl);
        this.onFillEntityFullInfo_PSDEF(pSSysBICubeMeasure, bl);
        this.onFillEntityFullInfo_ParamPSDEUIAction(pSSysBICubeMeasure, bl);
        this.onFillEntityFullInfo_DrillDetailPSDEView(pSSysBICubeMeasure, bl);
        this.onFillEntityFullInfo_DrillDownPSDEView(pSSysBICubeMeasure, bl);
        this.onFillEntityFullInfo_PSSysBICube(pSSysBICubeMeasure, bl);
        this.onFillEntityFullInfo_PSSysTranslator(pSSysBICubeMeasure, bl);
        this.onFillEntityFullInfo_PSThresholdGroup(pSSysBICubeMeasure, bl);
    }

    protected void onFillEntityFullInfo_PSCodeList(PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEF(PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_ParamPSDEUIAction(PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_DrillDetailPSDEView(PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_DrillDownPSDEView(PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysBICube(PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysTranslator(PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSThresholdGroup(PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysBICubeMeasure, bl);
    }

    public ArrayList<PSSysBICubeMeasure> selectByPSCodeList(PSCodeListBase pSCodeListBase) throws Exception {
        return this.selectByPSCodeList(pSCodeListBase, "", -1);
    }

    public ArrayList<PSSysBICubeMeasure> selectByPSCodeList(PSCodeListBase pSCodeListBase, String string) throws Exception {
        return this.selectByPSCodeList(pSCodeListBase, string, -1);
    }

    public ArrayList<PSSysBICubeMeasure> selectByPSCodeList(PSCodeListBase pSCodeListBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysBICubeMeasure> selectByPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysBICubeMeasure> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysBICubeMeasure> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysBICubeMeasure> selectByParamPSDEUIAction(PSDEUIActionBase pSDEUIActionBase) throws Exception {
        return this.selectByParamPSDEUIAction(pSDEUIActionBase, "", -1);
    }

    public ArrayList<PSSysBICubeMeasure> selectByParamPSDEUIAction(PSDEUIActionBase pSDEUIActionBase, String string) throws Exception {
        return this.selectByParamPSDEUIAction(pSDEUIActionBase, string, -1);
    }

    public ArrayList<PSSysBICubeMeasure> selectByParamPSDEUIAction(PSDEUIActionBase pSDEUIActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PARAMPSDEUIACTIONID", (Object)pSDEUIActionBase.getPSDEUIActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByParamPSDEUIActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByParamPSDEUIActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBICubeMeasure> selectByDrillDetailPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByDrillDetailPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSSysBICubeMeasure> selectByDrillDetailPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByDrillDetailPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSSysBICubeMeasure> selectByDrillDetailPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DRILLDETAILPSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDrillDetailPSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDrillDetailPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBICubeMeasure> selectByDrillDownPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByDrillDownPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSSysBICubeMeasure> selectByDrillDownPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByDrillDownPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSSysBICubeMeasure> selectByDrillDownPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DRILLDOWNPSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDrillDownPSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDrillDownPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBICubeMeasure> selectByPSSysBICube(PSSysBICubeBase pSSysBICubeBase) throws Exception {
        return this.selectByPSSysBICube(pSSysBICubeBase, "", -1);
    }

    public ArrayList<PSSysBICubeMeasure> selectByPSSysBICube(PSSysBICubeBase pSSysBICubeBase, String string) throws Exception {
        return this.selectByPSSysBICube(pSSysBICubeBase, string, -1);
    }

    public ArrayList<PSSysBICubeMeasure> selectByPSSysBICube(PSSysBICubeBase pSSysBICubeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSBICUBEID", (Object)pSSysBICubeBase.getPSSysBICubeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysBICubeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysBICubeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBICubeMeasure> selectByPSSysTranslator(PSSysTranslatorBase pSSysTranslatorBase) throws Exception {
        return this.selectByPSSysTranslator(pSSysTranslatorBase, "", -1);
    }

    public ArrayList<PSSysBICubeMeasure> selectByPSSysTranslator(PSSysTranslatorBase pSSysTranslatorBase, String string) throws Exception {
        return this.selectByPSSysTranslator(pSSysTranslatorBase, string, -1);
    }

    public ArrayList<PSSysBICubeMeasure> selectByPSSysTranslator(PSSysTranslatorBase pSSysTranslatorBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysBICubeMeasure> selectByPSThresholdGroup(PSThresholdGroupBase pSThresholdGroupBase) throws Exception {
        return this.selectByPSThresholdGroup(pSThresholdGroupBase, "", -1);
    }

    public ArrayList<PSSysBICubeMeasure> selectByPSThresholdGroup(PSThresholdGroupBase pSThresholdGroupBase, String string) throws Exception {
        return this.selectByPSThresholdGroup(pSThresholdGroupBase, string, -1);
    }

    public ArrayList<PSSysBICubeMeasure> selectByPSThresholdGroup(PSThresholdGroupBase pSThresholdGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSTHRESHOLDGROUPID", (Object)pSThresholdGroupBase.getPSThresholdGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSThresholdGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSThresholdGroupCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSSysBICubeMeasure> arrayList = this.selectByPSCodeList(pSCodeList, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCODELIST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCodeList);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBICUBEMEASURE_PSCODELIST_PSCODELISTID", "", iDataEntityModel.getName(), "PSSYSBICUBEMEASURE", iDataEntityModel.getDataInfo(pSCodeList), arrayList.get(0)));
        }
    }

    public void resetPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSSysBICubeMeasure> arrayList = this.selectByPSCodeList(pSCodeList);
        for (PSSysBICubeMeasure pSSysBICubeMeasure : arrayList) {
            PSSysBICubeMeasure pSSysBICubeMeasure2 = (PSSysBICubeMeasure)this.getDEModel().createEntity();
            pSSysBICubeMeasure2.setPSSysBICubeMeasureId(pSSysBICubeMeasure.getPSSysBICubeMeasureId());
            pSSysBICubeMeasure2.setPSCodeListId(null);
            this.update(pSSysBICubeMeasure2);
        }
    }

    public void removeByPSCodeList(PSCodeList pSCodeList) throws Exception {
        final PSCodeList pSCodeList2 = pSCodeList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBICubeMeasureServiceBase.this.onBeforeRemoveByPSCodeList(pSCodeList2);
                PSSysBICubeMeasureServiceBase.this.internalRemoveByPSCodeList(pSCodeList2);
                PSSysBICubeMeasureServiceBase.this.onAfterRemoveByPSCodeList(pSCodeList2);
            }
        });
    }

    protected void onBeforeRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void internalRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSSysBICubeMeasure> arrayList = this.selectByPSCodeList(pSCodeList);
        this.onBeforeRemoveByPSCodeList(pSCodeList, arrayList);
        for (PSSysBICubeMeasure pSSysBICubeMeasure : arrayList) {
            this.remove(pSSysBICubeMeasure);
        }
        this.onAfterRemoveByPSCodeList(pSCodeList, arrayList);
    }

    protected void onAfterRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void onBeforeRemoveByPSCodeList(PSCodeList pSCodeList, ArrayList<PSSysBICubeMeasure> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCodeList(PSCodeList pSCodeList, ArrayList<PSSysBICubeMeasure> arrayList) throws Exception {
    }

    public void testRemoveByPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysBICubeMeasure> arrayList = this.selectByPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBICUBEMEASURE_PSDEFIELD_PSDEFID", "", iDataEntityModel.getName(), "PSSYSBICUBEMEASURE", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysBICubeMeasure> arrayList = this.selectByPSDEF(pSDEField);
        for (PSSysBICubeMeasure pSSysBICubeMeasure : arrayList) {
            PSSysBICubeMeasure pSSysBICubeMeasure2 = (PSSysBICubeMeasure)this.getDEModel().createEntity();
            pSSysBICubeMeasure2.setPSSysBICubeMeasureId(pSSysBICubeMeasure.getPSSysBICubeMeasureId());
            pSSysBICubeMeasure2.setPSDEFId(null);
            this.update(pSSysBICubeMeasure2);
        }
    }

    public void removeByPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBICubeMeasureServiceBase.this.onBeforeRemoveByPSDEF(pSDEField2);
                PSSysBICubeMeasureServiceBase.this.internalRemoveByPSDEF(pSDEField2);
                PSSysBICubeMeasureServiceBase.this.onAfterRemoveByPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysBICubeMeasure> arrayList = this.selectByPSDEF(pSDEField);
        this.onBeforeRemoveByPSDEF(pSDEField, arrayList);
        for (PSSysBICubeMeasure pSSysBICubeMeasure : arrayList) {
            this.remove(pSSysBICubeMeasure);
        }
        this.onAfterRemoveByPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSSysBICubeMeasure> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSSysBICubeMeasure> arrayList) throws Exception {
    }

    public void testRemoveByParamPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSSysBICubeMeasure> arrayList = this.selectByParamPSDEUIAction(pSDEUIAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUIACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEUIAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBICUBEMEASURE_PSDEUIACTION_PARAMPSDEUIACTIONID", "", iDataEntityModel.getName(), "PSSYSBICUBEMEASURE", iDataEntityModel.getDataInfo(pSDEUIAction), arrayList.get(0)));
        }
    }

    public void resetParamPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSSysBICubeMeasure> arrayList = this.selectByParamPSDEUIAction(pSDEUIAction);
        for (PSSysBICubeMeasure pSSysBICubeMeasure : arrayList) {
            PSSysBICubeMeasure pSSysBICubeMeasure2 = (PSSysBICubeMeasure)this.getDEModel().createEntity();
            pSSysBICubeMeasure2.setPSSysBICubeMeasureId(pSSysBICubeMeasure.getPSSysBICubeMeasureId());
            pSSysBICubeMeasure2.setParamPSDEUIActionId(null);
            this.update(pSSysBICubeMeasure2);
        }
    }

    public void removeByParamPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        final PSDEUIAction pSDEUIAction2 = pSDEUIAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBICubeMeasureServiceBase.this.onBeforeRemoveByParamPSDEUIAction(pSDEUIAction2);
                PSSysBICubeMeasureServiceBase.this.internalRemoveByParamPSDEUIAction(pSDEUIAction2);
                PSSysBICubeMeasureServiceBase.this.onAfterRemoveByParamPSDEUIAction(pSDEUIAction2);
            }
        });
    }

    protected void onBeforeRemoveByParamPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
    }

    protected void internalRemoveByParamPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSSysBICubeMeasure> arrayList = this.selectByParamPSDEUIAction(pSDEUIAction);
        this.onBeforeRemoveByParamPSDEUIAction(pSDEUIAction, arrayList);
        for (PSSysBICubeMeasure pSSysBICubeMeasure : arrayList) {
            this.remove(pSSysBICubeMeasure);
        }
        this.onAfterRemoveByParamPSDEUIAction(pSDEUIAction, arrayList);
    }

    protected void onAfterRemoveByParamPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
    }

    protected void onBeforeRemoveByParamPSDEUIAction(PSDEUIAction pSDEUIAction, ArrayList<PSSysBICubeMeasure> arrayList) throws Exception {
    }

    protected void onAfterRemoveByParamPSDEUIAction(PSDEUIAction pSDEUIAction, ArrayList<PSSysBICubeMeasure> arrayList) throws Exception {
    }

    public void testRemoveByDrillDetailPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSSysBICubeMeasure> arrayList = this.selectByDrillDetailPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBICUBEMEASURE_PSDEVIEWBASE_DRILLDETAILPSDEVIEWID", "", iDataEntityModel.getName(), "PSSYSBICUBEMEASURE", iDataEntityModel.getDataInfo(pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetDrillDetailPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSSysBICubeMeasure> arrayList = this.selectByDrillDetailPSDEView(pSDEViewBase);
        for (PSSysBICubeMeasure pSSysBICubeMeasure : arrayList) {
            PSSysBICubeMeasure pSSysBICubeMeasure2 = (PSSysBICubeMeasure)this.getDEModel().createEntity();
            pSSysBICubeMeasure2.setPSSysBICubeMeasureId(pSSysBICubeMeasure.getPSSysBICubeMeasureId());
            pSSysBICubeMeasure2.setDrillDetailPSDEViewId(null);
            this.update(pSSysBICubeMeasure2);
        }
    }

    public void removeByDrillDetailPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBICubeMeasureServiceBase.this.onBeforeRemoveByDrillDetailPSDEView(pSDEViewBase2);
                PSSysBICubeMeasureServiceBase.this.internalRemoveByDrillDetailPSDEView(pSDEViewBase2);
                PSSysBICubeMeasureServiceBase.this.onAfterRemoveByDrillDetailPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByDrillDetailPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByDrillDetailPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSSysBICubeMeasure> arrayList = this.selectByDrillDetailPSDEView(pSDEViewBase);
        this.onBeforeRemoveByDrillDetailPSDEView(pSDEViewBase, arrayList);
        for (PSSysBICubeMeasure pSSysBICubeMeasure : arrayList) {
            this.remove(pSSysBICubeMeasure);
        }
        this.onAfterRemoveByDrillDetailPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByDrillDetailPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByDrillDetailPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSSysBICubeMeasure> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDrillDetailPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSSysBICubeMeasure> arrayList) throws Exception {
    }

    public void testRemoveByDrillDownPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSSysBICubeMeasure> arrayList = this.selectByDrillDownPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBICUBEMEASURE_PSDEVIEWBASE_DRILLDOWNPSDEVIEWID", "", iDataEntityModel.getName(), "PSSYSBICUBEMEASURE", iDataEntityModel.getDataInfo(pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetDrillDownPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSSysBICubeMeasure> arrayList = this.selectByDrillDownPSDEView(pSDEViewBase);
        for (PSSysBICubeMeasure pSSysBICubeMeasure : arrayList) {
            PSSysBICubeMeasure pSSysBICubeMeasure2 = (PSSysBICubeMeasure)this.getDEModel().createEntity();
            pSSysBICubeMeasure2.setPSSysBICubeMeasureId(pSSysBICubeMeasure.getPSSysBICubeMeasureId());
            pSSysBICubeMeasure2.setDrillDownPSDEViewId(null);
            this.update(pSSysBICubeMeasure2);
        }
    }

    public void removeByDrillDownPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBICubeMeasureServiceBase.this.onBeforeRemoveByDrillDownPSDEView(pSDEViewBase2);
                PSSysBICubeMeasureServiceBase.this.internalRemoveByDrillDownPSDEView(pSDEViewBase2);
                PSSysBICubeMeasureServiceBase.this.onAfterRemoveByDrillDownPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByDrillDownPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByDrillDownPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSSysBICubeMeasure> arrayList = this.selectByDrillDownPSDEView(pSDEViewBase);
        this.onBeforeRemoveByDrillDownPSDEView(pSDEViewBase, arrayList);
        for (PSSysBICubeMeasure pSSysBICubeMeasure : arrayList) {
            this.remove(pSSysBICubeMeasure);
        }
        this.onAfterRemoveByDrillDownPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByDrillDownPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByDrillDownPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSSysBICubeMeasure> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDrillDownPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSSysBICubeMeasure> arrayList) throws Exception {
    }

    public void testRemoveByPSSysBICube(PSSysBICube pSSysBICube) throws Exception {
    }

    public void resetPSSysBICube(PSSysBICube pSSysBICube) throws Exception {
        ArrayList<PSSysBICubeMeasure> arrayList = this.selectByPSSysBICube(pSSysBICube);
        for (PSSysBICubeMeasure pSSysBICubeMeasure : arrayList) {
            PSSysBICubeMeasure pSSysBICubeMeasure2 = (PSSysBICubeMeasure)this.getDEModel().createEntity();
            pSSysBICubeMeasure2.setPSSysBICubeMeasureId(pSSysBICubeMeasure.getPSSysBICubeMeasureId());
            pSSysBICubeMeasure2.setPSSysBICubeId(null);
            this.update(pSSysBICubeMeasure2);
        }
    }

    public void removeByPSSysBICube(PSSysBICube pSSysBICube) throws Exception {
        final PSSysBICube pSSysBICube2 = pSSysBICube;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBICubeMeasureServiceBase.this.onBeforeRemoveByPSSysBICube(pSSysBICube2);
                PSSysBICubeMeasureServiceBase.this.internalRemoveByPSSysBICube(pSSysBICube2);
                PSSysBICubeMeasureServiceBase.this.onAfterRemoveByPSSysBICube(pSSysBICube2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBICube(PSSysBICube pSSysBICube) throws Exception {
    }

    protected void internalRemoveByPSSysBICube(PSSysBICube pSSysBICube) throws Exception {
        ArrayList<PSSysBICubeMeasure> arrayList = this.selectByPSSysBICube(pSSysBICube);
        this.onBeforeRemoveByPSSysBICube(pSSysBICube, arrayList);
        for (PSSysBICubeMeasure pSSysBICubeMeasure : arrayList) {
            this.remove(pSSysBICubeMeasure);
        }
        this.onAfterRemoveByPSSysBICube(pSSysBICube, arrayList);
    }

    protected void onAfterRemoveByPSSysBICube(PSSysBICube pSSysBICube) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBICube(PSSysBICube pSSysBICube, ArrayList<PSSysBICubeMeasure> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBICube(PSSysBICube pSSysBICube, ArrayList<PSSysBICubeMeasure> arrayList) throws Exception {
    }

    public void testRemoveByPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
        ArrayList<PSSysBICubeMeasure> arrayList = this.selectByPSSysTranslator(pSSysTranslator, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTRANSLATOR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysTranslator);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBICUBEMEASURE_PSSYSTRANSLATOR_PSSYSTRANSLATORID", "", iDataEntityModel.getName(), "PSSYSBICUBEMEASURE", iDataEntityModel.getDataInfo(pSSysTranslator), arrayList.get(0)));
        }
    }

    public void resetPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
        ArrayList<PSSysBICubeMeasure> arrayList = this.selectByPSSysTranslator(pSSysTranslator);
        for (PSSysBICubeMeasure pSSysBICubeMeasure : arrayList) {
            PSSysBICubeMeasure pSSysBICubeMeasure2 = (PSSysBICubeMeasure)this.getDEModel().createEntity();
            pSSysBICubeMeasure2.setPSSysBICubeMeasureId(pSSysBICubeMeasure.getPSSysBICubeMeasureId());
            pSSysBICubeMeasure2.setPSSysTranslatorId(null);
            this.update(pSSysBICubeMeasure2);
        }
    }

    public void removeByPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
        final PSSysTranslator pSSysTranslator2 = pSSysTranslator;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBICubeMeasureServiceBase.this.onBeforeRemoveByPSSysTranslator(pSSysTranslator2);
                PSSysBICubeMeasureServiceBase.this.internalRemoveByPSSysTranslator(pSSysTranslator2);
                PSSysBICubeMeasureServiceBase.this.onAfterRemoveByPSSysTranslator(pSSysTranslator2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
    }

    protected void internalRemoveByPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
        ArrayList<PSSysBICubeMeasure> arrayList = this.selectByPSSysTranslator(pSSysTranslator);
        this.onBeforeRemoveByPSSysTranslator(pSSysTranslator, arrayList);
        for (PSSysBICubeMeasure pSSysBICubeMeasure : arrayList) {
            this.remove(pSSysBICubeMeasure);
        }
        this.onAfterRemoveByPSSysTranslator(pSSysTranslator, arrayList);
    }

    protected void onAfterRemoveByPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
    }

    protected void onBeforeRemoveByPSSysTranslator(PSSysTranslator pSSysTranslator, ArrayList<PSSysBICubeMeasure> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysTranslator(PSSysTranslator pSSysTranslator, ArrayList<PSSysBICubeMeasure> arrayList) throws Exception {
    }

    public void testRemoveByPSThresholdGroup(PSThresholdGroup pSThresholdGroup) throws Exception {
        ArrayList<PSSysBICubeMeasure> arrayList = this.selectByPSThresholdGroup(pSThresholdGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSTHRESHOLDGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSThresholdGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBICUBEMEASURE_PSTHRESHOLDGROUP_PSTHRESHOLDGROUPID", "", iDataEntityModel.getName(), "PSSYSBICUBEMEASURE", iDataEntityModel.getDataInfo(pSThresholdGroup), arrayList.get(0)));
        }
    }

    public void resetPSThresholdGroup(PSThresholdGroup pSThresholdGroup) throws Exception {
        ArrayList<PSSysBICubeMeasure> arrayList = this.selectByPSThresholdGroup(pSThresholdGroup);
        for (PSSysBICubeMeasure pSSysBICubeMeasure : arrayList) {
            PSSysBICubeMeasure pSSysBICubeMeasure2 = (PSSysBICubeMeasure)this.getDEModel().createEntity();
            pSSysBICubeMeasure2.setPSSysBICubeMeasureId(pSSysBICubeMeasure.getPSSysBICubeMeasureId());
            pSSysBICubeMeasure2.setPSThresholdGroupId(null);
            this.update(pSSysBICubeMeasure2);
        }
    }

    public void removeByPSThresholdGroup(PSThresholdGroup pSThresholdGroup) throws Exception {
        final PSThresholdGroup pSThresholdGroup2 = pSThresholdGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBICubeMeasureServiceBase.this.onBeforeRemoveByPSThresholdGroup(pSThresholdGroup2);
                PSSysBICubeMeasureServiceBase.this.internalRemoveByPSThresholdGroup(pSThresholdGroup2);
                PSSysBICubeMeasureServiceBase.this.onAfterRemoveByPSThresholdGroup(pSThresholdGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSThresholdGroup(PSThresholdGroup pSThresholdGroup) throws Exception {
    }

    protected void internalRemoveByPSThresholdGroup(PSThresholdGroup pSThresholdGroup) throws Exception {
        ArrayList<PSSysBICubeMeasure> arrayList = this.selectByPSThresholdGroup(pSThresholdGroup);
        this.onBeforeRemoveByPSThresholdGroup(pSThresholdGroup, arrayList);
        for (PSSysBICubeMeasure pSSysBICubeMeasure : arrayList) {
            this.remove(pSSysBICubeMeasure);
        }
        this.onAfterRemoveByPSThresholdGroup(pSThresholdGroup, arrayList);
    }

    protected void onAfterRemoveByPSThresholdGroup(PSThresholdGroup pSThresholdGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSThresholdGroup(PSThresholdGroup pSThresholdGroup, ArrayList<PSSysBICubeMeasure> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSThresholdGroup(PSThresholdGroup pSThresholdGroup, ArrayList<PSSysBICubeMeasure> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysBICubeMeasure pSSysBICubeMeasure) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysBIAggColumnService)ServiceGlobal.getService(PSSysBIAggColumnService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBIAggColumnServiceBase)pSCoreSysServiceBase).testRemoveByPSSysBICubeMeasure(pSSysBICubeMeasure);
        pSCoreSysServiceBase = (PSSysBICubeMSCondService)ServiceGlobal.getService(PSSysBICubeMSCondService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBICubeMSCondServiceBase)pSCoreSysServiceBase).testRemoveByPSSysBICubeMeasure(pSSysBICubeMeasure);
        ((PSSysBICubeMSCondServiceBase)pSCoreSysServiceBase).removeByPSSysBICubeMeasure(pSSysBICubeMeasure);
        pSCoreSysServiceBase = (PSSysBICubeMSJoinService)ServiceGlobal.getService(PSSysBICubeMSJoinService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBICubeMSJoinServiceBase)pSCoreSysServiceBase).testRemoveByPSSysBICubeMeasure(pSSysBICubeMeasure);
        ((PSSysBICubeMSJoinServiceBase)pSCoreSysServiceBase).removeByPSSysBICubeMeasure(pSSysBICubeMeasure);
        pSCoreSysServiceBase = (PSSysBIReportItemService)ServiceGlobal.getService(PSSysBIReportItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBIReportItemServiceBase)pSCoreSysServiceBase).testRemoveByPSSysBICubeMeasure(pSSysBICubeMeasure);
        pSCoreSysServiceBase = (PSSysBIReportItemService)ServiceGlobal.getService(PSSysBIReportItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBIReportItemServiceBase)pSCoreSysServiceBase).testRemoveByRefPSSysBICubeMeasure(pSSysBICubeMeasure);
        super.onBeforeRemove(pSSysBICubeMeasure);
    }

    protected void replaceParentInfo(PSSysBICubeMeasure pSSysBICubeMeasure, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysBICubeMeasure, cloneSession);
        if (pSSysBICubeMeasure.getPSCodeListId() != null && (iEntity = cloneSession.getEntity("PSCODELIST", (Object)pSSysBICubeMeasure.getPSCodeListId())) != null) {
            this.onFillParentInfo_PSCodeList(pSSysBICubeMeasure, (PSCodeList)iEntity);
        }
        if (pSSysBICubeMeasure.getPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysBICubeMeasure.getPSDEFId())) != null) {
            this.onFillParentInfo_PSDEF(pSSysBICubeMeasure, (PSDEField)iEntity);
        }
        if (pSSysBICubeMeasure.getParamPSDEUIActionId() != null && (iEntity = cloneSession.getEntity("PSDEUIACTION", (Object)pSSysBICubeMeasure.getParamPSDEUIActionId())) != null) {
            this.onFillParentInfo_ParamPSDEUIAction(pSSysBICubeMeasure, (PSDEUIAction)iEntity);
        }
        if (pSSysBICubeMeasure.getDrillDetailPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSSysBICubeMeasure.getDrillDetailPSDEViewId())) != null) {
            this.onFillParentInfo_DrillDetailPSDEView(pSSysBICubeMeasure, (PSDEViewBase)iEntity);
        }
        if (pSSysBICubeMeasure.getDrillDownPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSSysBICubeMeasure.getDrillDownPSDEViewId())) != null) {
            this.onFillParentInfo_DrillDownPSDEView(pSSysBICubeMeasure, (PSDEViewBase)iEntity);
        }
        if (pSSysBICubeMeasure.getPSSysBICubeId() != null && (iEntity = cloneSession.getEntity("PSSYSBICUBE", (Object)pSSysBICubeMeasure.getPSSysBICubeId())) != null) {
            this.onFillParentInfo_PSSysBICube(pSSysBICubeMeasure, (PSSysBICube)iEntity);
        }
        if (pSSysBICubeMeasure.getPSSysTranslatorId() != null && (iEntity = cloneSession.getEntity("PSSYSTRANSLATOR", (Object)pSSysBICubeMeasure.getPSSysTranslatorId())) != null) {
            this.onFillParentInfo_PSSysTranslator(pSSysBICubeMeasure, (PSSysTranslator)iEntity);
        }
        if (pSSysBICubeMeasure.getPSThresholdGroupId() != null && (iEntity = cloneSession.getEntity("PSTHRESHOLDGROUP", (Object)pSSysBICubeMeasure.getPSThresholdGroupId())) != null) {
            this.onFillParentInfo_PSThresholdGroup(pSSysBICubeMeasure, (PSThresholdGroup)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysBICubeMeasure, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AggType(bl, pSSysBICubeMeasure, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BICubeMeasureTag(bl, pSSysBICubeMeasure, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BICubeMeasureTag2(bl, pSSysBICubeMeasure, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BIMeasureGroup(bl, pSSysBICubeMeasure, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BIMeasureType(bl, pSSysBICubeMeasure, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSysBICubeMeasure, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DrillDetailCustomCond(bl, pSSysBICubeMeasure, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DrillDetailCustomType(bl, pSSysBICubeMeasure, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DrillDetailPSDEViewId(bl, pSSysBICubeMeasure, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DrillDownCustomCond(bl, pSSysBICubeMeasure, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DrillDownCustomType(bl, pSSysBICubeMeasure, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DrillDownPSDEViewId(bl, pSSysBICubeMeasure, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HiddenDataItem(bl, pSSysBICubeMeasure, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_JsonFormat(bl, pSSysBICubeMeasure, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MeasureFormula(bl, pSSysBICubeMeasure, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysBICubeMeasure, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysBICubeMeasure, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ParamPSDEUIActionId(bl, pSSysBICubeMeasure, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCodeListId(bl, pSSysBICubeMeasure, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFId(bl, pSSysBICubeMeasure, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBICubeId(bl, pSSysBICubeMeasure, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBICubeMeasureId(bl, pSSysBICubeMeasure, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBICubeMeasureName(bl, pSSysBICubeMeasure, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTranslatorId(bl, pSSysBICubeMeasure, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSThresholdGroupId(bl, pSSysBICubeMeasure, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StdDataType(bl, pSSysBICubeMeasure, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TextTemplate(bl, pSSysBICubeMeasure, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TipTemplate(bl, pSSysBICubeMeasure, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysBICubeMeasure, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysBICubeMeasure, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysBICubeMeasure, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysBICubeMeasure, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysBICubeMeasure, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysBICubeMeasure, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValueFormat(bl, pSSysBICubeMeasure, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysBICubeMeasure, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AggType(boolean bl, PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMeasure.isAggTypeDirty() : !pSSysBICubeMeasure.isAggTypeDirty()) {
            return null;
        }
        String string = pSSysBICubeMeasure.getAggType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AggType_Default(pSSysBICubeMeasure, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AGGTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BICubeMeasureTag(boolean bl, PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMeasure.isBICubeMeasureTagDirty() : !pSSysBICubeMeasure.isBICubeMeasureTagDirty()) {
            return null;
        }
        String string = pSSysBICubeMeasure.getBICubeMeasureTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BICubeMeasureTag_Default(pSSysBICubeMeasure, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BICUBEMEASURETAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BICubeMeasureTag2(boolean bl, PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMeasure.isBICubeMeasureTag2Dirty() : !pSSysBICubeMeasure.isBICubeMeasureTag2Dirty()) {
            return null;
        }
        String string = pSSysBICubeMeasure.getBICubeMeasureTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BICubeMeasureTag2_Default(pSSysBICubeMeasure, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BICUBEMEASURETAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BIMeasureGroup(boolean bl, PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMeasure.isBIMeasureGroupDirty() : !pSSysBICubeMeasure.isBIMeasureGroupDirty()) {
            return null;
        }
        String string = pSSysBICubeMeasure.getBIMeasureGroup();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BIMeasureGroup_Default(pSSysBICubeMeasure, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BIMEASUREGROUP");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BIMeasureType(boolean bl, PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMeasure.isBIMeasureTypeDirty() && !bl2 : !pSSysBICubeMeasure.isBIMeasureTypeDirty()) {
            return null;
        }
        String string = pSSysBICubeMeasure.getBIMeasureType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BIMEASURETYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_BIMeasureType_Default(pSSysBICubeMeasure, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BIMEASURETYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMeasure.isCodeNameDirty() && !bl2 : !pSSysBICubeMeasure.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysBICubeMeasure.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSysBICubeMeasure, bl2, bl3);
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
                string3 = "PSSYSBICUBEID";
                String string4 = this.checkFieldDupRule(this.getPSSysBICubeMeasureDEModel(), "CODENAME", string3, pSSysBICubeMeasure, bl2, bl3);
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

    protected EntityFieldError onCheckField_DrillDetailCustomCond(boolean bl, PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMeasure.isDrillDetailCustomCondDirty() : !pSSysBICubeMeasure.isDrillDetailCustomCondDirty()) {
            return null;
        }
        String string = pSSysBICubeMeasure.getDrillDetailCustomCond();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DrillDetailCustomCond_Default(pSSysBICubeMeasure, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DRILLDETAILCUSTOMCOND");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DrillDetailCustomType(boolean bl, PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMeasure.isDrillDetailCustomTypeDirty() : !pSSysBICubeMeasure.isDrillDetailCustomTypeDirty()) {
            return null;
        }
        String string = pSSysBICubeMeasure.getDrillDetailCustomType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DrillDetailCustomType_Default(pSSysBICubeMeasure, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DRILLDETAILCUSTOMTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DrillDetailPSDEViewId(boolean bl, PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMeasure.isDrillDetailPSDEViewIdDirty() : !pSSysBICubeMeasure.isDrillDetailPSDEViewIdDirty()) {
            return null;
        }
        String string = pSSysBICubeMeasure.getDrillDetailPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DrillDetailPSDEViewId_Default(pSSysBICubeMeasure, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DRILLDETAILPSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DrillDownCustomCond(boolean bl, PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMeasure.isDrillDownCustomCondDirty() : !pSSysBICubeMeasure.isDrillDownCustomCondDirty()) {
            return null;
        }
        String string = pSSysBICubeMeasure.getDrillDownCustomCond();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DrillDownCustomCond_Default(pSSysBICubeMeasure, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DRILLDOWNCUSTOMCOND");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DrillDownCustomType(boolean bl, PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMeasure.isDrillDownCustomTypeDirty() : !pSSysBICubeMeasure.isDrillDownCustomTypeDirty()) {
            return null;
        }
        String string = pSSysBICubeMeasure.getDrillDownCustomType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DrillDownCustomType_Default(pSSysBICubeMeasure, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DRILLDOWNCUSTOMTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DrillDownPSDEViewId(boolean bl, PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMeasure.isDrillDownPSDEViewIdDirty() : !pSSysBICubeMeasure.isDrillDownPSDEViewIdDirty()) {
            return null;
        }
        String string = pSSysBICubeMeasure.getDrillDownPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DrillDownPSDEViewId_Default(pSSysBICubeMeasure, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DRILLDOWNPSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HiddenDataItem(boolean bl, PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMeasure.isHiddenDataItemDirty() : !pSSysBICubeMeasure.isHiddenDataItemDirty()) {
            return null;
        }
        Integer n = pSSysBICubeMeasure.getHiddenDataItem();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_HiddenDataItem_Default(pSSysBICubeMeasure, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HIDDENDATAITEM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_JsonFormat(boolean bl, PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMeasure.isJsonFormatDirty() : !pSSysBICubeMeasure.isJsonFormatDirty()) {
            return null;
        }
        String string = pSSysBICubeMeasure.getJsonFormat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_JsonFormat_Default(pSSysBICubeMeasure, bl2, bl3);
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

    protected EntityFieldError onCheckField_MeasureFormula(boolean bl, PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMeasure.isMeasureFormulaDirty() : !pSSysBICubeMeasure.isMeasureFormulaDirty()) {
            return null;
        }
        String string = pSSysBICubeMeasure.getMeasureFormula();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MeasureFormula_Default(pSSysBICubeMeasure, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MEASUREFORMULA");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMeasure.isMemoDirty() : !pSSysBICubeMeasure.isMemoDirty()) {
            return null;
        }
        String string = pSSysBICubeMeasure.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysBICubeMeasure, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMeasure.isOrderValueDirty() : !pSSysBICubeMeasure.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysBICubeMeasure.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSSysBICubeMeasure, bl2, bl3);
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

    protected EntityFieldError onCheckField_ParamPSDEUIActionId(boolean bl, PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMeasure.isParamPSDEUIActionIdDirty() : !pSSysBICubeMeasure.isParamPSDEUIActionIdDirty()) {
            return null;
        }
        String string = pSSysBICubeMeasure.getParamPSDEUIActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ParamPSDEUIActionId_Default(pSSysBICubeMeasure, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAMPSDEUIACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCodeListId(boolean bl, PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMeasure.isPSCodeListIdDirty() : !pSSysBICubeMeasure.isPSCodeListIdDirty()) {
            return null;
        }
        String string = pSSysBICubeMeasure.getPSCodeListId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCodeListId_Default(pSSysBICubeMeasure, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFId(boolean bl, PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMeasure.isPSDEFIdDirty() : !pSSysBICubeMeasure.isPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysBICubeMeasure.getPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFId_Default(pSSysBICubeMeasure, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysBICubeId(boolean bl, PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMeasure.isPSSysBICubeIdDirty() : !pSSysBICubeMeasure.isPSSysBICubeIdDirty()) {
            return null;
        }
        String string = pSSysBICubeMeasure.getPSSysBICubeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBICubeId_Default(pSSysBICubeMeasure, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBICUBEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBICubeMeasureId(boolean bl, PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMeasure.isPSSysBICubeMeasureIdDirty() && !bl2 : !pSSysBICubeMeasure.isPSSysBICubeMeasureIdDirty()) {
            return null;
        }
        String string = pSSysBICubeMeasure.getPSSysBICubeMeasureId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBICUBEMEASUREID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBICubeMeasureId_Default(pSSysBICubeMeasure, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysBICubeMeasureName(boolean bl, PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMeasure.isPSSysBICubeMeasureNameDirty() && !bl2 : !pSSysBICubeMeasure.isPSSysBICubeMeasureNameDirty()) {
            return null;
        }
        String string = pSSysBICubeMeasure.getPSSysBICubeMeasureName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBICUBEMEASURENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBICubeMeasureName_Default(pSSysBICubeMeasure, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBICUBEMEASURENAME");
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
                string3 = "PSSYSBICUBEID";
                String string4 = this.checkFieldDupRule(this.getPSSysBICubeMeasureDEModel(), "PSSYSBICUBEMEASURENAME", string3, pSSysBICubeMeasure, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSBICUBEMEASURENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysTranslatorId(boolean bl, PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMeasure.isPSSysTranslatorIdDirty() : !pSSysBICubeMeasure.isPSSysTranslatorIdDirty()) {
            return null;
        }
        String string = pSSysBICubeMeasure.getPSSysTranslatorId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysTranslatorId_Default(pSSysBICubeMeasure, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSThresholdGroupId(boolean bl, PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMeasure.isPSThresholdGroupIdDirty() : !pSSysBICubeMeasure.isPSThresholdGroupIdDirty()) {
            return null;
        }
        String string = pSSysBICubeMeasure.getPSThresholdGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSThresholdGroupId_Default(pSSysBICubeMeasure, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSTHRESHOLDGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StdDataType(boolean bl, PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMeasure.isStdDataTypeDirty() : !pSSysBICubeMeasure.isStdDataTypeDirty()) {
            return null;
        }
        Integer n = pSSysBICubeMeasure.getStdDataType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_StdDataType_Default(pSSysBICubeMeasure, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STDDATATYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TextTemplate(boolean bl, PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMeasure.isTextTemplateDirty() : !pSSysBICubeMeasure.isTextTemplateDirty()) {
            return null;
        }
        String string = pSSysBICubeMeasure.getTextTemplate();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TextTemplate_Default(pSSysBICubeMeasure, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEXTTEMPLATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TipTemplate(boolean bl, PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMeasure.isTipTemplateDirty() : !pSSysBICubeMeasure.isTipTemplateDirty()) {
            return null;
        }
        String string = pSSysBICubeMeasure.getTipTemplate();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TipTemplate_Default(pSSysBICubeMeasure, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TIPTEMPLATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMeasure.isUserCatDirty() : !pSSysBICubeMeasure.isUserCatDirty()) {
            return null;
        }
        String string = pSSysBICubeMeasure.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysBICubeMeasure, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMeasure.isUserTagDirty() : !pSSysBICubeMeasure.isUserTagDirty()) {
            return null;
        }
        String string = pSSysBICubeMeasure.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysBICubeMeasure, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMeasure.isUserTag2Dirty() : !pSSysBICubeMeasure.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysBICubeMeasure.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysBICubeMeasure, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMeasure.isUserTag3Dirty() : !pSSysBICubeMeasure.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysBICubeMeasure.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysBICubeMeasure, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMeasure.isUserTag4Dirty() : !pSSysBICubeMeasure.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysBICubeMeasure.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysBICubeMeasure, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMeasure.isValidFlagDirty() && !bl2 : !pSSysBICubeMeasure.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysBICubeMeasure.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSysBICubeMeasure, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValueFormat(boolean bl, PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMeasure.isValueFormatDirty() : !pSSysBICubeMeasure.isValueFormatDirty()) {
            return null;
        }
        String string = pSSysBICubeMeasure.getValueFormat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ValueFormat_Default(pSSysBICubeMeasure, bl2, bl3);
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

    protected void onSyncEntity(PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl) throws Exception {
        super.onSyncEntity(pSSysBICubeMeasure, bl);
    }

    protected void onSyncIndexEntities(PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysBICubeMeasure, bl);
    }

    public Object getDataContextValue(PSSysBICubeMeasure pSSysBICubeMeasure, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysBICubeMeasure, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysBICube pSSysBICube = pSSysBICubeMeasure.getPSSysBICube();
        if (pSSysBICube != null && pSSysBICube.contains(string)) {
            return pSSysBICube.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysBICubeMeasure pSSysBICubeMeasure, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysBICubeMeasure, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"AGGTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AggType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BICUBEMEASURETAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BICubeMeasureTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BICUBEMEASURETAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BICubeMeasureTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BIMEASUREGROUP", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BIMeasureGroup_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BIMEASURETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BIMeasureType_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"DRILLDETAILCUSTOMCOND", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DrillDetailCustomCond_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DRILLDETAILCUSTOMTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DrillDetailCustomType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DRILLDETAILPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DrillDetailPSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DRILLDETAILPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DrillDetailPSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DRILLDOWNCUSTOMCOND", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DrillDownCustomCond_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DRILLDOWNCUSTOMTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DrillDownCustomType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DRILLDOWNPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DrillDownPSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DRILLDOWNPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DrillDownPSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HIDDENDATAITEM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HiddenDataItem_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"JSONFORMAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_JsonFormat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEASUREFORMULA", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MeasureFormula_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAMPSDEUIACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ParamPSDEUIActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAMPSDEUIACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ParamPSDEUIActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCODELISTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCodeListId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCODELISTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCodeListName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSBICUBEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBICubeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBICUBEMEASUREID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBICubeMeasureId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBICUBEMEASURENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBICubeMeasureName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBICUBENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBICubeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBISCHEMEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBISchemeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTRANSLATORID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTranslatorId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTRANSLATORNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTranslatorName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSTHRESHOLDGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSThresholdGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSTHRESHOLDGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSThresholdGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STDDATATYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StdDataType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEXTTEMPLATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TextTemplate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIPTEMPLATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TipTemplate_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VALUEFORMAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValueFormat_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AggType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AGGTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BICubeMeasureTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BICUBEMEASURETAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BICubeMeasureTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BICUBEMEASURETAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BIMeasureGroup_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BIMEASUREGROUP", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BIMeasureType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BIMEASURETYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected String onTestValueRule_DrillDetailCustomCond_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DRILLDETAILCUSTOMCOND", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DrillDetailCustomType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DRILLDETAILCUSTOMTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DrillDetailPSDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DRILLDETAILPSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DrillDetailPSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DRILLDETAILPSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DrillDownCustomCond_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DRILLDOWNCUSTOMCOND", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DrillDownCustomType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DRILLDOWNCUSTOMTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DrillDownPSDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DRILLDOWNPSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DrillDownPSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DRILLDOWNPSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HiddenDataItem_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_MeasureFormula_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEASUREFORMULA", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
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

    protected String onTestValueRule_ParamPSDEUIActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAMPSDEUIACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ParamPSDEUIActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAMPSDEUIACTIONNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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
            if (this.checkFieldStringLengthRule("PSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBICubeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBICUBEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_PSSysBICubeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBICUBENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBISchemeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBISCHEMEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_PSThresholdGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSTHRESHOLDGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSThresholdGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSTHRESHOLDGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StdDataType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TextTemplate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEXTTEMPLATE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TipTemplate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TIPTEMPLATE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysBICubeMeasure pSSysBICubeMeasure) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysBICubeMeasure)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysBICubeMeasure pSSysBICubeMeasure) throws Exception {
        super.onUpdateParent(pSSysBICubeMeasure);
    }

    @Override
    protected void exportCurXmlModel(PSSysBICubeMeasure pSSysBICubeMeasure, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSBICUBEMEASURE");
        if (!bl) {
            pSSysBICubeMeasure.setCreateDate(null);
            pSSysBICubeMeasure.setCreateMan(null);
            pSSysBICubeMeasure.setPSSysBICubeMeasureId(null);
            pSSysBICubeMeasure.setUpdateDate(null);
            pSSysBICubeMeasure.setUpdateMan(null);
            super.exportCurXmlModel(pSSysBICubeMeasure, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysBICubeMeasure pSSysBICubeMeasure, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysBICubeMeasure, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBICUBEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSBICUBE#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBICUBEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSBICUBEMEASURE_PSSYSBICUBE_PSSYSBICUBEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBICUBEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBICUBENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSBICUBE", (boolean)true) == 0) {
            iEntity.set("PSSYSBICUBEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSBICUBEID"};
    }

    @Override
    public String getModelV2Tag(PSSysBICubeMeasure pSSysBICubeMeasure) {
        if (!StringHelper.isNullOrEmpty((String)pSSysBICubeMeasure.getCodeName())) {
            return pSSysBICubeMeasure.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysBICubeMeasure.getPSSysBICubeMeasureName())) {
            return pSSysBICubeMeasure.getPSSysBICubeMeasureName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysBICubeMeasure.getCodeName())) {
            return pSSysBICubeMeasure.getCodeName();
        }
        return super.getModelV2Tag(pSSysBICubeMeasure);
    }

    @Override
    public boolean setModelV2Tag(PSSysBICubeMeasure pSSysBICubeMeasure, String string) {
        pSSysBICubeMeasure.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSSYSBICUBEMEASURENAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSBICUBEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysBICubeMeasure pSSysBICubeMeasure, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysBICubeMeasure.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysBICubeMeasure, true);
        pSSysBICubeMeasure.set("CODENAME", string);
        if (this.select(pSSysBICubeMeasure, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysBICubeMeasure, true);
        return super.getModelV2Entity(pSSysBICubeMeasure, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysBICubeMeasure pSSysBICubeMeasure, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysBICubeMeasure, objectNode, string, string2, n);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysBICubeMeasure pSSysBICubeMeasure, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "Measure");
    }
}

