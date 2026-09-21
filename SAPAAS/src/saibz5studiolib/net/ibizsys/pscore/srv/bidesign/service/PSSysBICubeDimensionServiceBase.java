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
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.bidesign.service;

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
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.bidesign.dao.PSSysBICubeDimensionDAO;
import net.ibizsys.pscore.srv.bidesign.demodel.PSSysBICubeDimensionDEModel;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICube;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeBase;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeDimension;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeLevel;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIDimension;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIDimensionBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIAggColumnService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIAggColumnServiceBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeLevelService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeLevelServiceBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIReportItemService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIReportItemServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIActionBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeListBase;
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

public abstract class PSSysBICubeDimensionServiceBase
extends PSCoreSysServiceBase<PSSysBICubeDimension> {
    private static final Log log = LogFactory.getLog(PSSysBICubeDimensionServiceBase.class);
    public static final String DATASET_CURCUBE = "CurCube";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSSysBICubeDimensionDEModel pSSysBICubeDimensionDEModel;
    private PSSysBICubeDimensionDAO pSSysBICubeDimensionDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeDimensionService";
    }

    public PSSysBICubeDimensionDEModel getPSSysBICubeDimensionDEModel() {
        if (this.pSSysBICubeDimensionDEModel == null) {
            try {
                this.pSSysBICubeDimensionDEModel = (PSSysBICubeDimensionDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.bidesign.demodel.PSSysBICubeDimensionDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBICubeDimensionDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysBICubeDimensionDEModel();
    }

    public PSSysBICubeDimensionDAO getPSSysBICubeDimensionDAO() {
        if (this.pSSysBICubeDimensionDAO == null) {
            try {
                this.pSSysBICubeDimensionDAO = (PSSysBICubeDimensionDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.bidesign.dao.PSSysBICubeDimensionDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBICubeDimensionDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysBICubeDimensionDAO();
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

    protected void onFillParentInfo(PSSysBICubeDimension pSSysBICubeDimension, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBICUBEDIMENSION_PSCODELIST_PSCODELISTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService", (SessionFactory)this.getSessionFactory());
            PSCodeList pSCodeList = (PSCodeList)iService.getDEModel().createEntity();
            pSCodeList.set("PSCODELISTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCodeList);
            } else {
                iService.get((IEntity)pSCodeList);
            }
            this.onFillParentInfo_PSCodeList(pSSysBICubeDimension, pSCodeList);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBICUBEDIMENSION_PSDEFIELD_PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_PSDEF(pSSysBICubeDimension, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBICUBEDIMENSION_PSDEFIELD_TEXTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_TextPSDEF(pSSysBICubeDimension, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBICUBEDIMENSION_PSDEUIACTION_PARAMPSDEUIACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService", (SessionFactory)this.getSessionFactory());
            PSDEUIAction pSDEUIAction = (PSDEUIAction)iService.getDEModel().createEntity();
            pSDEUIAction.set("PSDEUIACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEUIAction);
            } else {
                iService.get((IEntity)pSDEUIAction);
            }
            this.onFillParentInfo_ParamPSDEUIAction(pSSysBICubeDimension, pSDEUIAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBICUBEDIMENSION_PSSYSBICUBE_PSSYSBICUBEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeService", (SessionFactory)this.getSessionFactory());
            PSSysBICube pSSysBICube = (PSSysBICube)iService.getDEModel().createEntity();
            pSSysBICube.set("PSSYSBICUBEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysBICube);
            } else {
                iService.get((IEntity)pSSysBICube);
            }
            this.onFillParentInfo_PSSysBICube(pSSysBICubeDimension, pSSysBICube);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBICUBEDIMENSION_PSSYSBIDIMENSION_PSSYSBIDIMENSIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBIDimensionService", (SessionFactory)this.getSessionFactory());
            PSSysBIDimension pSSysBIDimension = (PSSysBIDimension)iService.getDEModel().createEntity();
            pSSysBIDimension.set("PSSYSBIDIMENSIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysBIDimension);
            } else {
                iService.get((IEntity)pSSysBIDimension);
            }
            this.onFillParentInfo_PSSysBIDimension(pSSysBICubeDimension, pSSysBIDimension);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBICUBEDIMENSION_PSSYSDBVF_PSSYSDBVFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDBVFService", (SessionFactory)this.getSessionFactory());
            PSSysDBVF pSSysDBVF = (PSSysDBVF)iService.getDEModel().createEntity();
            pSSysDBVF.set("PSSYSDBVFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDBVF);
            } else {
                iService.get((IEntity)pSSysDBVF);
            }
            this.onFillParentInfo_PSSysDBVF(pSSysBICubeDimension, pSSysDBVF);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysBICubeDimension, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSCodeList(PSSysBICubeDimension pSSysBICubeDimension, PSCodeList pSCodeList) throws Exception {
        pSSysBICubeDimension.setPSCodeListId(pSCodeList.getPSCodeListId());
        pSSysBICubeDimension.setPSCodeListName(pSCodeList.getPSCodeListName());
    }

    protected void onFillParentInfo_PSDEF(PSSysBICubeDimension pSSysBICubeDimension, PSDEField pSDEField) throws Exception {
        pSSysBICubeDimension.setPSDEFId(pSDEField.getPSDEFieldId());
        pSSysBICubeDimension.setPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_TextPSDEF(PSSysBICubeDimension pSSysBICubeDimension, PSDEField pSDEField) throws Exception {
        pSSysBICubeDimension.setTextPSDEFId(pSDEField.getPSDEFieldId());
        pSSysBICubeDimension.setTextPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_ParamPSDEUIAction(PSSysBICubeDimension pSSysBICubeDimension, PSDEUIAction pSDEUIAction) throws Exception {
        pSSysBICubeDimension.setParamPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
        pSSysBICubeDimension.setParamPSDEUIActionName(pSDEUIAction.getPSDEUIActionName());
    }

    protected void onFillParentInfo_PSSysBICube(PSSysBICubeDimension pSSysBICubeDimension, PSSysBICube pSSysBICube) throws Exception {
        pSSysBICubeDimension.setPSDEId(pSSysBICube.getPSDEId());
        pSSysBICubeDimension.setPSSysBICubeId(pSSysBICube.getPSSysBICubeId());
        pSSysBICubeDimension.setPSSysBICubeName(pSSysBICube.getPSSysBICubeName());
        pSSysBICubeDimension.setPSSysBISchemeId(pSSysBICube.getPSSysBISchemeId());
    }

    protected void onFillParentInfo_PSSysBIDimension(PSSysBICubeDimension pSSysBICubeDimension, PSSysBIDimension pSSysBIDimension) throws Exception {
        pSSysBICubeDimension.setPSSysBIDimensionId(pSSysBIDimension.getPSSysBIDimensionId());
        pSSysBICubeDimension.setPSSysBIDimensionName(pSSysBIDimension.getPSSysBIDimensionName());
    }

    protected void onFillParentInfo_PSSysDBVF(PSSysBICubeDimension pSSysBICubeDimension, PSSysDBVF pSSysDBVF) throws Exception {
        pSSysBICubeDimension.setPSSysDBVFId(pSSysDBVF.getPSSysDBVFId());
        pSSysBICubeDimension.setPSSysDBVFName(pSSysDBVF.getPSSysDBVFName());
    }

    protected void onFillEntityFullInfo(PSSysBICubeDimension pSSysBICubeDimension, boolean bl) throws Exception {
        if (bl) {
            if (pSSysBICubeDimension.getCodeName() == null) {
                pSSysBICubeDimension.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "Dimension", 25));
            }
            if (pSSysBICubeDimension.getValidFlag() == null) {
                pSSysBICubeDimension.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSSysBICubeDimension, bl);
        this.onFillEntityFullInfo_PSCodeList(pSSysBICubeDimension, bl);
        this.onFillEntityFullInfo_PSDEF(pSSysBICubeDimension, bl);
        this.onFillEntityFullInfo_TextPSDEF(pSSysBICubeDimension, bl);
        this.onFillEntityFullInfo_ParamPSDEUIAction(pSSysBICubeDimension, bl);
        this.onFillEntityFullInfo_PSSysBICube(pSSysBICubeDimension, bl);
        this.onFillEntityFullInfo_PSSysBIDimension(pSSysBICubeDimension, bl);
        this.onFillEntityFullInfo_PSSysDBVF(pSSysBICubeDimension, bl);
    }

    protected void onFillEntityFullInfo_PSCodeList(PSSysBICubeDimension pSSysBICubeDimension, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEF(PSSysBICubeDimension pSSysBICubeDimension, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_TextPSDEF(PSSysBICubeDimension pSSysBICubeDimension, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_ParamPSDEUIAction(PSSysBICubeDimension pSSysBICubeDimension, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysBICube(PSSysBICubeDimension pSSysBICubeDimension, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysBIDimension(PSSysBICubeDimension pSSysBICubeDimension, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDBVF(PSSysBICubeDimension pSSysBICubeDimension, boolean bl) throws Exception {
        if (pSSysBICubeDimension.isPSSysDBVFIdDirty()) {
            if (pSSysBICubeDimension.getPSSysDBVFId() != null) {
                if (pSSysBICubeDimension.getPSSysDBVFId() == null || pSSysBICubeDimension.getPSSysDBVFName() == null) {
                    PSSysDBVF pSSysDBVF = pSSysBICubeDimension.getPSSysDBVF();
                    pSSysBICubeDimension.setPSSysDBVFName(pSSysDBVF.getPSSysDBVFName());
                }
            } else {
                pSSysBICubeDimension.setPSSysDBVFName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSysBICubeDimension pSSysBICubeDimension, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysBICubeDimension, bl);
    }

    public ArrayList<PSSysBICubeDimension> selectByPSCodeList(PSCodeListBase pSCodeListBase) throws Exception {
        return this.selectByPSCodeList(pSCodeListBase, "", -1);
    }

    public ArrayList<PSSysBICubeDimension> selectByPSCodeList(PSCodeListBase pSCodeListBase, String string) throws Exception {
        return this.selectByPSCodeList(pSCodeListBase, string, -1);
    }

    public ArrayList<PSSysBICubeDimension> selectByPSCodeList(PSCodeListBase pSCodeListBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysBICubeDimension> selectByPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysBICubeDimension> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysBICubeDimension> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysBICubeDimension> selectByTextPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByTextPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysBICubeDimension> selectByTextPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByTextPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysBICubeDimension> selectByTextPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysBICubeDimension> selectByParamPSDEUIAction(PSDEUIActionBase pSDEUIActionBase) throws Exception {
        return this.selectByParamPSDEUIAction(pSDEUIActionBase, "", -1);
    }

    public ArrayList<PSSysBICubeDimension> selectByParamPSDEUIAction(PSDEUIActionBase pSDEUIActionBase, String string) throws Exception {
        return this.selectByParamPSDEUIAction(pSDEUIActionBase, string, -1);
    }

    public ArrayList<PSSysBICubeDimension> selectByParamPSDEUIAction(PSDEUIActionBase pSDEUIActionBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysBICubeDimension> selectByPSSysBICube(PSSysBICubeBase pSSysBICubeBase) throws Exception {
        return this.selectByPSSysBICube(pSSysBICubeBase, "", -1);
    }

    public ArrayList<PSSysBICubeDimension> selectByPSSysBICube(PSSysBICubeBase pSSysBICubeBase, String string) throws Exception {
        return this.selectByPSSysBICube(pSSysBICubeBase, string, -1);
    }

    public ArrayList<PSSysBICubeDimension> selectByPSSysBICube(PSSysBICubeBase pSSysBICubeBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysBICubeDimension> selectByPSSysBIDimension(PSSysBIDimensionBase pSSysBIDimensionBase) throws Exception {
        return this.selectByPSSysBIDimension(pSSysBIDimensionBase, "", -1);
    }

    public ArrayList<PSSysBICubeDimension> selectByPSSysBIDimension(PSSysBIDimensionBase pSSysBIDimensionBase, String string) throws Exception {
        return this.selectByPSSysBIDimension(pSSysBIDimensionBase, string, -1);
    }

    public ArrayList<PSSysBICubeDimension> selectByPSSysBIDimension(PSSysBIDimensionBase pSSysBIDimensionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSBIDIMENSIONID", (Object)pSSysBIDimensionBase.getPSSysBIDimensionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysBIDimensionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysBIDimensionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBICubeDimension> selectByPSSysDBVF(PSSysDBVFBase pSSysDBVFBase) throws Exception {
        return this.selectByPSSysDBVF(pSSysDBVFBase, "", -1);
    }

    public ArrayList<PSSysBICubeDimension> selectByPSSysDBVF(PSSysDBVFBase pSSysDBVFBase, String string) throws Exception {
        return this.selectByPSSysDBVF(pSSysDBVFBase, string, -1);
    }

    public ArrayList<PSSysBICubeDimension> selectByPSSysDBVF(PSSysDBVFBase pSSysDBVFBase, String string, int n) throws Exception {
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

    public void testRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSSysBICubeDimension> arrayList = this.selectByPSCodeList(pSCodeList, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCODELIST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSCodeList);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBICUBEDIMENSION_PSCODELIST_PSCODELISTID", "", iDataEntityModel.getName(), "PSSYSBICUBEDIMENSION", iDataEntityModel.getDataInfo((IEntity)pSCodeList), arrayList.get(0)));
        }
    }

    public void resetPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSSysBICubeDimension> arrayList = this.selectByPSCodeList(pSCodeList);
        for (PSSysBICubeDimension pSSysBICubeDimension : arrayList) {
            PSSysBICubeDimension pSSysBICubeDimension2 = (PSSysBICubeDimension)this.getDEModel().createEntity();
            pSSysBICubeDimension2.setPSSysBICubeDimensionId(pSSysBICubeDimension.getPSSysBICubeDimensionId());
            pSSysBICubeDimension2.setPSCodeListId(null);
            this.update(pSSysBICubeDimension2);
        }
    }

    public void removeByPSCodeList(PSCodeList pSCodeList) throws Exception {
        final PSCodeList pSCodeList2 = pSCodeList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBICubeDimensionServiceBase.this.onBeforeRemoveByPSCodeList(pSCodeList2);
                PSSysBICubeDimensionServiceBase.this.internalRemoveByPSCodeList(pSCodeList2);
                PSSysBICubeDimensionServiceBase.this.onAfterRemoveByPSCodeList(pSCodeList2);
            }
        });
    }

    protected void onBeforeRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void internalRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSSysBICubeDimension> arrayList = this.selectByPSCodeList(pSCodeList);
        this.onBeforeRemoveByPSCodeList(pSCodeList, arrayList);
        for (PSSysBICubeDimension pSSysBICubeDimension : arrayList) {
            this.remove((IEntity)pSSysBICubeDimension);
        }
        this.onAfterRemoveByPSCodeList(pSCodeList, arrayList);
    }

    protected void onAfterRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void onBeforeRemoveByPSCodeList(PSCodeList pSCodeList, ArrayList<PSSysBICubeDimension> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCodeList(PSCodeList pSCodeList, ArrayList<PSSysBICubeDimension> arrayList) throws Exception {
    }

    public void testRemoveByPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysBICubeDimension> arrayList = this.selectByPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBICUBEDIMENSION_PSDEFIELD_PSDEFID", "", iDataEntityModel.getName(), "PSSYSBICUBEDIMENSION", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysBICubeDimension> arrayList = this.selectByPSDEF(pSDEField);
        for (PSSysBICubeDimension pSSysBICubeDimension : arrayList) {
            PSSysBICubeDimension pSSysBICubeDimension2 = (PSSysBICubeDimension)this.getDEModel().createEntity();
            pSSysBICubeDimension2.setPSSysBICubeDimensionId(pSSysBICubeDimension.getPSSysBICubeDimensionId());
            pSSysBICubeDimension2.setPSDEFId(null);
            this.update(pSSysBICubeDimension2);
        }
    }

    public void removeByPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBICubeDimensionServiceBase.this.onBeforeRemoveByPSDEF(pSDEField2);
                PSSysBICubeDimensionServiceBase.this.internalRemoveByPSDEF(pSDEField2);
                PSSysBICubeDimensionServiceBase.this.onAfterRemoveByPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysBICubeDimension> arrayList = this.selectByPSDEF(pSDEField);
        this.onBeforeRemoveByPSDEF(pSDEField, arrayList);
        for (PSSysBICubeDimension pSSysBICubeDimension : arrayList) {
            this.remove((IEntity)pSSysBICubeDimension);
        }
        this.onAfterRemoveByPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSSysBICubeDimension> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSSysBICubeDimension> arrayList) throws Exception {
    }

    public void testRemoveByTextPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysBICubeDimension> arrayList = this.selectByTextPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBICUBEDIMENSION_PSDEFIELD_TEXTPSDEFID", "", iDataEntityModel.getName(), "PSSYSBICUBEDIMENSION", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetTextPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysBICubeDimension> arrayList = this.selectByTextPSDEF(pSDEField);
        for (PSSysBICubeDimension pSSysBICubeDimension : arrayList) {
            PSSysBICubeDimension pSSysBICubeDimension2 = (PSSysBICubeDimension)this.getDEModel().createEntity();
            pSSysBICubeDimension2.setPSSysBICubeDimensionId(pSSysBICubeDimension.getPSSysBICubeDimensionId());
            pSSysBICubeDimension2.setTextPSDEFId(null);
            this.update(pSSysBICubeDimension2);
        }
    }

    public void removeByTextPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBICubeDimensionServiceBase.this.onBeforeRemoveByTextPSDEF(pSDEField2);
                PSSysBICubeDimensionServiceBase.this.internalRemoveByTextPSDEF(pSDEField2);
                PSSysBICubeDimensionServiceBase.this.onAfterRemoveByTextPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByTextPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByTextPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysBICubeDimension> arrayList = this.selectByTextPSDEF(pSDEField);
        this.onBeforeRemoveByTextPSDEF(pSDEField, arrayList);
        for (PSSysBICubeDimension pSSysBICubeDimension : arrayList) {
            this.remove((IEntity)pSSysBICubeDimension);
        }
        this.onAfterRemoveByTextPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByTextPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByTextPSDEF(PSDEField pSDEField, ArrayList<PSSysBICubeDimension> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTextPSDEF(PSDEField pSDEField, ArrayList<PSSysBICubeDimension> arrayList) throws Exception {
    }

    public void testRemoveByParamPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSSysBICubeDimension> arrayList = this.selectByParamPSDEUIAction(pSDEUIAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUIACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEUIAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBICUBEDIMENSION_PSDEUIACTION_PARAMPSDEUIACTIONID", "", iDataEntityModel.getName(), "PSSYSBICUBEDIMENSION", iDataEntityModel.getDataInfo((IEntity)pSDEUIAction), arrayList.get(0)));
        }
    }

    public void resetParamPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSSysBICubeDimension> arrayList = this.selectByParamPSDEUIAction(pSDEUIAction);
        for (PSSysBICubeDimension pSSysBICubeDimension : arrayList) {
            PSSysBICubeDimension pSSysBICubeDimension2 = (PSSysBICubeDimension)this.getDEModel().createEntity();
            pSSysBICubeDimension2.setPSSysBICubeDimensionId(pSSysBICubeDimension.getPSSysBICubeDimensionId());
            pSSysBICubeDimension2.setParamPSDEUIActionId(null);
            this.update(pSSysBICubeDimension2);
        }
    }

    public void removeByParamPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        final PSDEUIAction pSDEUIAction2 = pSDEUIAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBICubeDimensionServiceBase.this.onBeforeRemoveByParamPSDEUIAction(pSDEUIAction2);
                PSSysBICubeDimensionServiceBase.this.internalRemoveByParamPSDEUIAction(pSDEUIAction2);
                PSSysBICubeDimensionServiceBase.this.onAfterRemoveByParamPSDEUIAction(pSDEUIAction2);
            }
        });
    }

    protected void onBeforeRemoveByParamPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
    }

    protected void internalRemoveByParamPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSSysBICubeDimension> arrayList = this.selectByParamPSDEUIAction(pSDEUIAction);
        this.onBeforeRemoveByParamPSDEUIAction(pSDEUIAction, arrayList);
        for (PSSysBICubeDimension pSSysBICubeDimension : arrayList) {
            this.remove((IEntity)pSSysBICubeDimension);
        }
        this.onAfterRemoveByParamPSDEUIAction(pSDEUIAction, arrayList);
    }

    protected void onAfterRemoveByParamPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
    }

    protected void onBeforeRemoveByParamPSDEUIAction(PSDEUIAction pSDEUIAction, ArrayList<PSSysBICubeDimension> arrayList) throws Exception {
    }

    protected void onAfterRemoveByParamPSDEUIAction(PSDEUIAction pSDEUIAction, ArrayList<PSSysBICubeDimension> arrayList) throws Exception {
    }

    public void testRemoveByPSSysBICube(PSSysBICube pSSysBICube) throws Exception {
    }

    public void resetPSSysBICube(PSSysBICube pSSysBICube) throws Exception {
        ArrayList<PSSysBICubeDimension> arrayList = this.selectByPSSysBICube(pSSysBICube);
        for (PSSysBICubeDimension pSSysBICubeDimension : arrayList) {
            PSSysBICubeDimension pSSysBICubeDimension2 = (PSSysBICubeDimension)this.getDEModel().createEntity();
            pSSysBICubeDimension2.setPSSysBICubeDimensionId(pSSysBICubeDimension.getPSSysBICubeDimensionId());
            pSSysBICubeDimension2.setPSSysBICubeId(null);
            this.update(pSSysBICubeDimension2);
        }
    }

    public void removeByPSSysBICube(PSSysBICube pSSysBICube) throws Exception {
        final PSSysBICube pSSysBICube2 = pSSysBICube;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBICubeDimensionServiceBase.this.onBeforeRemoveByPSSysBICube(pSSysBICube2);
                PSSysBICubeDimensionServiceBase.this.internalRemoveByPSSysBICube(pSSysBICube2);
                PSSysBICubeDimensionServiceBase.this.onAfterRemoveByPSSysBICube(pSSysBICube2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBICube(PSSysBICube pSSysBICube) throws Exception {
    }

    protected void internalRemoveByPSSysBICube(PSSysBICube pSSysBICube) throws Exception {
        ArrayList<PSSysBICubeDimension> arrayList = this.selectByPSSysBICube(pSSysBICube);
        this.onBeforeRemoveByPSSysBICube(pSSysBICube, arrayList);
        for (PSSysBICubeDimension pSSysBICubeDimension : arrayList) {
            this.remove((IEntity)pSSysBICubeDimension);
        }
        this.onAfterRemoveByPSSysBICube(pSSysBICube, arrayList);
    }

    protected void onAfterRemoveByPSSysBICube(PSSysBICube pSSysBICube) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBICube(PSSysBICube pSSysBICube, ArrayList<PSSysBICubeDimension> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBICube(PSSysBICube pSSysBICube, ArrayList<PSSysBICubeDimension> arrayList) throws Exception {
    }

    public void testRemoveByPSSysBIDimension(PSSysBIDimension pSSysBIDimension) throws Exception {
        ArrayList<PSSysBICubeDimension> arrayList = this.selectByPSSysBIDimension(pSSysBIDimension, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSBIDIMENSION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysBIDimension);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBICUBEDIMENSION_PSSYSBIDIMENSION_PSSYSBIDIMENSIONID", "", iDataEntityModel.getName(), "PSSYSBICUBEDIMENSION", iDataEntityModel.getDataInfo((IEntity)pSSysBIDimension), arrayList.get(0)));
        }
    }

    public void resetPSSysBIDimension(PSSysBIDimension pSSysBIDimension) throws Exception {
        ArrayList<PSSysBICubeDimension> arrayList = this.selectByPSSysBIDimension(pSSysBIDimension);
        for (PSSysBICubeDimension pSSysBICubeDimension : arrayList) {
            PSSysBICubeDimension pSSysBICubeDimension2 = (PSSysBICubeDimension)this.getDEModel().createEntity();
            pSSysBICubeDimension2.setPSSysBICubeDimensionId(pSSysBICubeDimension.getPSSysBICubeDimensionId());
            pSSysBICubeDimension2.setPSSysBIDimensionId(null);
            this.update(pSSysBICubeDimension2);
        }
    }

    public void removeByPSSysBIDimension(PSSysBIDimension pSSysBIDimension) throws Exception {
        final PSSysBIDimension pSSysBIDimension2 = pSSysBIDimension;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBICubeDimensionServiceBase.this.onBeforeRemoveByPSSysBIDimension(pSSysBIDimension2);
                PSSysBICubeDimensionServiceBase.this.internalRemoveByPSSysBIDimension(pSSysBIDimension2);
                PSSysBICubeDimensionServiceBase.this.onAfterRemoveByPSSysBIDimension(pSSysBIDimension2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBIDimension(PSSysBIDimension pSSysBIDimension) throws Exception {
    }

    protected void internalRemoveByPSSysBIDimension(PSSysBIDimension pSSysBIDimension) throws Exception {
        ArrayList<PSSysBICubeDimension> arrayList = this.selectByPSSysBIDimension(pSSysBIDimension);
        this.onBeforeRemoveByPSSysBIDimension(pSSysBIDimension, arrayList);
        for (PSSysBICubeDimension pSSysBICubeDimension : arrayList) {
            this.remove((IEntity)pSSysBICubeDimension);
        }
        this.onAfterRemoveByPSSysBIDimension(pSSysBIDimension, arrayList);
    }

    protected void onAfterRemoveByPSSysBIDimension(PSSysBIDimension pSSysBIDimension) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBIDimension(PSSysBIDimension pSSysBIDimension, ArrayList<PSSysBICubeDimension> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBIDimension(PSSysBIDimension pSSysBIDimension, ArrayList<PSSysBICubeDimension> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDBVF(PSSysDBVF pSSysDBVF) throws Exception {
        ArrayList<PSSysBICubeDimension> arrayList = this.selectByPSSysDBVF(pSSysDBVF, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDBVF");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDBVF);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBICUBEDIMENSION_PSSYSDBVF_PSSYSDBVFID", "", iDataEntityModel.getName(), "PSSYSBICUBEDIMENSION", iDataEntityModel.getDataInfo((IEntity)pSSysDBVF), arrayList.get(0)));
        }
    }

    public void resetPSSysDBVF(PSSysDBVF pSSysDBVF) throws Exception {
        ArrayList<PSSysBICubeDimension> arrayList = this.selectByPSSysDBVF(pSSysDBVF);
        for (PSSysBICubeDimension pSSysBICubeDimension : arrayList) {
            PSSysBICubeDimension pSSysBICubeDimension2 = (PSSysBICubeDimension)this.getDEModel().createEntity();
            pSSysBICubeDimension2.setPSSysBICubeDimensionId(pSSysBICubeDimension.getPSSysBICubeDimensionId());
            pSSysBICubeDimension2.setPSSysDBVFId(null);
            this.update(pSSysBICubeDimension2);
        }
    }

    public void removeByPSSysDBVF(PSSysDBVF pSSysDBVF) throws Exception {
        final PSSysDBVF pSSysDBVF2 = pSSysDBVF;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBICubeDimensionServiceBase.this.onBeforeRemoveByPSSysDBVF(pSSysDBVF2);
                PSSysBICubeDimensionServiceBase.this.internalRemoveByPSSysDBVF(pSSysDBVF2);
                PSSysBICubeDimensionServiceBase.this.onAfterRemoveByPSSysDBVF(pSSysDBVF2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDBVF(PSSysDBVF pSSysDBVF) throws Exception {
    }

    protected void internalRemoveByPSSysDBVF(PSSysDBVF pSSysDBVF) throws Exception {
        ArrayList<PSSysBICubeDimension> arrayList = this.selectByPSSysDBVF(pSSysDBVF);
        this.onBeforeRemoveByPSSysDBVF(pSSysDBVF, arrayList);
        for (PSSysBICubeDimension pSSysBICubeDimension : arrayList) {
            this.remove((IEntity)pSSysBICubeDimension);
        }
        this.onAfterRemoveByPSSysDBVF(pSSysDBVF, arrayList);
    }

    protected void onAfterRemoveByPSSysDBVF(PSSysDBVF pSSysDBVF) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDBVF(PSSysDBVF pSSysDBVF, ArrayList<PSSysBICubeDimension> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDBVF(PSSysDBVF pSSysDBVF, ArrayList<PSSysBICubeDimension> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysBICubeDimension pSSysBICubeDimension) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysBIAggColumnService)ServiceGlobal.getService(PSSysBIAggColumnService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBIAggColumnServiceBase)pSCoreSysServiceBase).testRemoveByPSSysBICubeDimension(pSSysBICubeDimension);
        pSCoreSysServiceBase = (PSSysBICubeLevelService)ServiceGlobal.getService(PSSysBICubeLevelService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBICubeLevelServiceBase)pSCoreSysServiceBase).testRemoveByPSSysBICubeDimension(pSSysBICubeDimension);
        ((PSSysBICubeLevelServiceBase)pSCoreSysServiceBase).removeByPSSysBICubeDimension(pSSysBICubeDimension);
        pSCoreSysServiceBase = (PSSysBIReportItemService)ServiceGlobal.getService(PSSysBIReportItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBIReportItemServiceBase)pSCoreSysServiceBase).testRemoveByPSSysBICubeDimension(pSSysBICubeDimension);
        super.onBeforeRemove(pSSysBICubeDimension);
    }

    protected void replaceParentInfo(PSSysBICubeDimension pSSysBICubeDimension, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysBICubeDimension, cloneSession);
        if (pSSysBICubeDimension.getPSCodeListId() != null && (iEntity = cloneSession.getEntity("PSCODELIST", (Object)pSSysBICubeDimension.getPSCodeListId())) != null) {
            this.onFillParentInfo_PSCodeList(pSSysBICubeDimension, (PSCodeList)iEntity);
        }
        if (pSSysBICubeDimension.getPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysBICubeDimension.getPSDEFId())) != null) {
            this.onFillParentInfo_PSDEF(pSSysBICubeDimension, (PSDEField)iEntity);
        }
        if (pSSysBICubeDimension.getTextPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysBICubeDimension.getTextPSDEFId())) != null) {
            this.onFillParentInfo_TextPSDEF(pSSysBICubeDimension, (PSDEField)iEntity);
        }
        if (pSSysBICubeDimension.getParamPSDEUIActionId() != null && (iEntity = cloneSession.getEntity("PSDEUIACTION", (Object)pSSysBICubeDimension.getParamPSDEUIActionId())) != null) {
            this.onFillParentInfo_ParamPSDEUIAction(pSSysBICubeDimension, (PSDEUIAction)iEntity);
        }
        if (pSSysBICubeDimension.getPSSysBICubeId() != null && (iEntity = cloneSession.getEntity("PSSYSBICUBE", (Object)pSSysBICubeDimension.getPSSysBICubeId())) != null) {
            this.onFillParentInfo_PSSysBICube(pSSysBICubeDimension, (PSSysBICube)iEntity);
        }
        if (pSSysBICubeDimension.getPSSysBIDimensionId() != null && (iEntity = cloneSession.getEntity("PSSYSBIDIMENSION", (Object)pSSysBICubeDimension.getPSSysBIDimensionId())) != null) {
            this.onFillParentInfo_PSSysBIDimension(pSSysBICubeDimension, (PSSysBIDimension)iEntity);
        }
        if (pSSysBICubeDimension.getPSSysDBVFId() != null && (iEntity = cloneSession.getEntity("PSSYSDBVF", (Object)pSSysBICubeDimension.getPSSysDBVFId())) != null) {
            this.onFillParentInfo_PSSysDBVF(pSSysBICubeDimension, (PSSysDBVF)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysBICubeDimension pSSysBICubeDimension, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysBICubeDimension, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysBICubeDimension pSSysBICubeDimension, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AllHierarchyFlag(bl, pSSysBICubeDimension, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BICubeDimensionTag(bl, pSSysBICubeDimension, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BICubeDimensionTag2(bl, pSSysBICubeDimension, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BIDimensionType(bl, pSSysBICubeDimension, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSysBICubeDimension, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultFlag(bl, pSSysBICubeDimension, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DimensionFormula(bl, pSSysBICubeDimension, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExpandFlag(bl, pSSysBICubeDimension, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysBICubeDimension, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysBICubeDimension, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ParamPSDEUIActionId(bl, pSSysBICubeDimension, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCodeListId(bl, pSSysBICubeDimension, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFId(bl, pSSysBICubeDimension, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBICubeDimensionId(bl, pSSysBICubeDimension, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBICubeDimensionName(bl, pSSysBICubeDimension, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBICubeId(bl, pSSysBICubeDimension, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBIDimensionId(bl, pSSysBICubeDimension, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDBVFId(bl, pSSysBICubeDimension, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDBVFName(bl, pSSysBICubeDimension, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StdDataType(bl, pSSysBICubeDimension, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TextPSDEFId(bl, pSSysBICubeDimension, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TextTemplate(bl, pSSysBICubeDimension, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TipTemplate(bl, pSSysBICubeDimension, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysBICubeDimension, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysBICubeDimension, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysBICubeDimension, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysBICubeDimension, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysBICubeDimension, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysBICubeDimension, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysBICubeDimension, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AllHierarchyFlag(boolean bl, PSSysBICubeDimension pSSysBICubeDimension, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeDimension.isAllHierarchyFlagDirty() : !pSSysBICubeDimension.isAllHierarchyFlagDirty()) {
            return null;
        }
        Integer n = pSSysBICubeDimension.getAllHierarchyFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AllHierarchyFlag_Default((IEntity)pSSysBICubeDimension, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ALLHIERARCHYFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BICubeDimensionTag(boolean bl, PSSysBICubeDimension pSSysBICubeDimension, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeDimension.isBICubeDimensionTagDirty() : !pSSysBICubeDimension.isBICubeDimensionTagDirty()) {
            return null;
        }
        String string = pSSysBICubeDimension.getBICubeDimensionTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BICubeDimensionTag_Default((IEntity)pSSysBICubeDimension, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BICUBEDIMENSIONTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BICubeDimensionTag2(boolean bl, PSSysBICubeDimension pSSysBICubeDimension, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeDimension.isBICubeDimensionTag2Dirty() : !pSSysBICubeDimension.isBICubeDimensionTag2Dirty()) {
            return null;
        }
        String string = pSSysBICubeDimension.getBICubeDimensionTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BICubeDimensionTag2_Default((IEntity)pSSysBICubeDimension, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BICUBEDIMENSIONTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BIDimensionType(boolean bl, PSSysBICubeDimension pSSysBICubeDimension, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeDimension.isBIDimensionTypeDirty() : !pSSysBICubeDimension.isBIDimensionTypeDirty()) {
            return null;
        }
        String string = pSSysBICubeDimension.getBIDimensionType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BIDimensionType_Default((IEntity)pSSysBICubeDimension, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BIDIMENSIONTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysBICubeDimension pSSysBICubeDimension, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeDimension.isCodeNameDirty() && !bl2 : !pSSysBICubeDimension.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysBICubeDimension.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSSysBICubeDimension, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSSysBICubeDimensionDEModel(), "CODENAME", string3, pSSysBICubeDimension, bl2, bl3);
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

    protected EntityFieldError onCheckField_DefaultFlag(boolean bl, PSSysBICubeDimension pSSysBICubeDimension, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeDimension.isDefaultFlagDirty() : !pSSysBICubeDimension.isDefaultFlagDirty()) {
            return null;
        }
        Integer n = pSSysBICubeDimension.getDefaultFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DefaultFlag_Default((IEntity)pSSysBICubeDimension, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DimensionFormula(boolean bl, PSSysBICubeDimension pSSysBICubeDimension, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeDimension.isDimensionFormulaDirty() : !pSSysBICubeDimension.isDimensionFormulaDirty()) {
            return null;
        }
        String string = pSSysBICubeDimension.getDimensionFormula();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DimensionFormula_Default((IEntity)pSSysBICubeDimension, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DIMENSIONFORMULA");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExpandFlag(boolean bl, PSSysBICubeDimension pSSysBICubeDimension, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeDimension.isExpandFlagDirty() : !pSSysBICubeDimension.isExpandFlagDirty()) {
            return null;
        }
        Integer n = pSSysBICubeDimension.getExpandFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExpandFlag_Default((IEntity)pSSysBICubeDimension, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPANDFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysBICubeDimension pSSysBICubeDimension, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeDimension.isMemoDirty() : !pSSysBICubeDimension.isMemoDirty()) {
            return null;
        }
        String string = pSSysBICubeDimension.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysBICubeDimension, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysBICubeDimension pSSysBICubeDimension, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeDimension.isOrderValueDirty() : !pSSysBICubeDimension.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysBICubeDimension.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSSysBICubeDimension, bl2, bl3);
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

    protected EntityFieldError onCheckField_ParamPSDEUIActionId(boolean bl, PSSysBICubeDimension pSSysBICubeDimension, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeDimension.isParamPSDEUIActionIdDirty() : !pSSysBICubeDimension.isParamPSDEUIActionIdDirty()) {
            return null;
        }
        String string = pSSysBICubeDimension.getParamPSDEUIActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ParamPSDEUIActionId_Default((IEntity)pSSysBICubeDimension, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCodeListId(boolean bl, PSSysBICubeDimension pSSysBICubeDimension, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeDimension.isPSCodeListIdDirty() : !pSSysBICubeDimension.isPSCodeListIdDirty()) {
            return null;
        }
        String string = pSSysBICubeDimension.getPSCodeListId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCodeListId_Default((IEntity)pSSysBICubeDimension, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFId(boolean bl, PSSysBICubeDimension pSSysBICubeDimension, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeDimension.isPSDEFIdDirty() : !pSSysBICubeDimension.isPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysBICubeDimension.getPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFId_Default((IEntity)pSSysBICubeDimension, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysBICubeDimensionId(boolean bl, PSSysBICubeDimension pSSysBICubeDimension, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeDimension.isPSSysBICubeDimensionIdDirty() && !bl2 : !pSSysBICubeDimension.isPSSysBICubeDimensionIdDirty()) {
            return null;
        }
        String string = pSSysBICubeDimension.getPSSysBICubeDimensionId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBICUBEDIMENSIONID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBICubeDimensionId_Default((IEntity)pSSysBICubeDimension, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBICUBEDIMENSIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBICubeDimensionName(boolean bl, PSSysBICubeDimension pSSysBICubeDimension, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeDimension.isPSSysBICubeDimensionNameDirty() && !bl2 : !pSSysBICubeDimension.isPSSysBICubeDimensionNameDirty()) {
            return null;
        }
        String string = pSSysBICubeDimension.getPSSysBICubeDimensionName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBICUBEDIMENSIONNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBICubeDimensionName_Default((IEntity)pSSysBICubeDimension, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBICUBEDIMENSIONNAME");
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
                String string4 = this.checkFieldDupRule(this.getPSSysBICubeDimensionDEModel(), "PSSYSBICUBEDIMENSIONNAME", string3, pSSysBICubeDimension, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSBICUBEDIMENSIONNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBICubeId(boolean bl, PSSysBICubeDimension pSSysBICubeDimension, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeDimension.isPSSysBICubeIdDirty() && !bl2 : !pSSysBICubeDimension.isPSSysBICubeIdDirty()) {
            return null;
        }
        String string = pSSysBICubeDimension.getPSSysBICubeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBICUBEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBICubeId_Default((IEntity)pSSysBICubeDimension, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysBIDimensionId(boolean bl, PSSysBICubeDimension pSSysBICubeDimension, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeDimension.isPSSysBIDimensionIdDirty() : !pSSysBICubeDimension.isPSSysBIDimensionIdDirty()) {
            return null;
        }
        String string = pSSysBICubeDimension.getPSSysBIDimensionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBIDimensionId_Default((IEntity)pSSysBICubeDimension, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBIDIMENSIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDBVFId(boolean bl, PSSysBICubeDimension pSSysBICubeDimension, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeDimension.isPSSysDBVFIdDirty() : !pSSysBICubeDimension.isPSSysDBVFIdDirty()) {
            return null;
        }
        String string = pSSysBICubeDimension.getPSSysDBVFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDBVFId_Default((IEntity)pSSysBICubeDimension, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDBVFName(boolean bl, PSSysBICubeDimension pSSysBICubeDimension, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeDimension.isPSSysDBVFNameDirty() : !pSSysBICubeDimension.isPSSysDBVFNameDirty()) {
            return null;
        }
        String string = pSSysBICubeDimension.getPSSysDBVFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDBVFName_Default((IEntity)pSSysBICubeDimension, bl2, bl3);
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

    protected EntityFieldError onCheckField_StdDataType(boolean bl, PSSysBICubeDimension pSSysBICubeDimension, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeDimension.isStdDataTypeDirty() : !pSSysBICubeDimension.isStdDataTypeDirty()) {
            return null;
        }
        Integer n = pSSysBICubeDimension.getStdDataType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_StdDataType_Default((IEntity)pSSysBICubeDimension, bl2, bl3);
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

    protected EntityFieldError onCheckField_TextPSDEFId(boolean bl, PSSysBICubeDimension pSSysBICubeDimension, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeDimension.isTextPSDEFIdDirty() : !pSSysBICubeDimension.isTextPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysBICubeDimension.getTextPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TextPSDEFId_Default((IEntity)pSSysBICubeDimension, bl2, bl3);
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

    protected EntityFieldError onCheckField_TextTemplate(boolean bl, PSSysBICubeDimension pSSysBICubeDimension, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeDimension.isTextTemplateDirty() : !pSSysBICubeDimension.isTextTemplateDirty()) {
            return null;
        }
        String string = pSSysBICubeDimension.getTextTemplate();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TextTemplate_Default((IEntity)pSSysBICubeDimension, bl2, bl3);
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

    protected EntityFieldError onCheckField_TipTemplate(boolean bl, PSSysBICubeDimension pSSysBICubeDimension, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeDimension.isTipTemplateDirty() : !pSSysBICubeDimension.isTipTemplateDirty()) {
            return null;
        }
        String string = pSSysBICubeDimension.getTipTemplate();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TipTemplate_Default((IEntity)pSSysBICubeDimension, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysBICubeDimension pSSysBICubeDimension, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeDimension.isUserCatDirty() : !pSSysBICubeDimension.isUserCatDirty()) {
            return null;
        }
        String string = pSSysBICubeDimension.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSSysBICubeDimension, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysBICubeDimension pSSysBICubeDimension, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeDimension.isUserTagDirty() : !pSSysBICubeDimension.isUserTagDirty()) {
            return null;
        }
        String string = pSSysBICubeDimension.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSSysBICubeDimension, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysBICubeDimension pSSysBICubeDimension, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeDimension.isUserTag2Dirty() : !pSSysBICubeDimension.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysBICubeDimension.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSSysBICubeDimension, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysBICubeDimension pSSysBICubeDimension, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeDimension.isUserTag3Dirty() : !pSSysBICubeDimension.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysBICubeDimension.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSSysBICubeDimension, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysBICubeDimension pSSysBICubeDimension, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeDimension.isUserTag4Dirty() : !pSSysBICubeDimension.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysBICubeDimension.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSSysBICubeDimension, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysBICubeDimension pSSysBICubeDimension, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeDimension.isValidFlagDirty() && !bl2 : !pSSysBICubeDimension.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysBICubeDimension.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSSysBICubeDimension, bl2, bl3);
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

    protected void onSyncEntity(PSSysBICubeDimension pSSysBICubeDimension, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysBICubeDimension, bl);
    }

    protected void onSyncIndexEntities(PSSysBICubeDimension pSSysBICubeDimension, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysBICubeDimension, bl);
    }

    public Object getDataContextValue(PSSysBICubeDimension pSSysBICubeDimension, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysBICubeDimension, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysBICube pSSysBICube = pSSysBICubeDimension.getPSSysBICube();
        if (pSSysBICube != null && pSSysBICube.contains(string)) {
            return pSSysBICube.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysBICubeDimension pSSysBICubeDimension, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysBICubeDimension, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ALLHIERARCHYFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AllHierarchyFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BICUBEDIMENSIONTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BICubeDimensionTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BICUBEDIMENSIONTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BICubeDimensionTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BIDIMENSIONTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BIDimensionType_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"DIMENSIONFORMULA", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DimensionFormula_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPANDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExpandFlag_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSBICUBEDIMENSIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBICubeDimensionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBICUBEDIMENSIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBICubeDimensionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBICUBEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBICubeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBICUBENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBICubeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBIDIMENSIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBIDimensionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBIDIMENSIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBIDimensionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBISCHEMEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBISchemeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDBVFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDBVFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDBVFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDBVFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STDDATATYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StdDataType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEXTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TextPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEXTPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TextPSDEFName_Default(iEntity, bl, bl2);
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
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AllHierarchyFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_BICubeDimensionTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BICUBEDIMENSIONTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BICubeDimensionTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BICUBEDIMENSIONTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BIDimensionType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BIDIMENSIONTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
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

    protected String onTestValueRule_DefaultFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DimensionFormula_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DIMENSIONFORMULA", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ExpandFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSSysBICubeDimensionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBICUBEDIMENSIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBICubeDimensionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBICUBEDIMENSIONNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSSysBIDimensionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBIDIMENSIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBIDimensionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBIDIMENSIONNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_StdDataType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysBICubeDimension pSSysBICubeDimension) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysBICubeDimension)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysBICubeDimension pSSysBICubeDimension) throws Exception {
        super.onUpdateParent((IEntity)pSSysBICubeDimension);
    }

    protected void onCopyDetails(PSSysBICubeDimension pSSysBICubeDimension, Object object) throws Exception {
        PSSysBICubeDimension pSSysBICubeDimension2 = new PSSysBICubeDimension();
        pSSysBICubeDimension2.set("PSSYSBICUBEDIMENSIONID", object);
        String string = DataObject.getStringValue((Object)pSSysBICubeDimension.get("PSSYSBICUBEDIMENSIONID"));
        PSSysBICubeLevelService pSSysBICubeLevelService = (PSSysBICubeLevelService)ServiceGlobal.getService(PSSysBICubeLevelService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysBICubeLevel> arrayList = pSSysBICubeLevelService.selectByPSSysBICubeDimension(pSSysBICubeDimension2);
        for (PSSysBICubeLevel pSSysBICubeLevel : arrayList) {
            Object object2 = pSSysBICubeLevel.get("PSSYSBICUBELEVELID");
            pSSysBICubeLevelService.getDraftFrom((IEntity)pSSysBICubeLevel);
            pSSysBICubeLevelService.fillParentInfo((IEntity)pSSysBICubeLevel, "DER1N", "DER1N_PSSYSBICUBELEVEL_PSSYSBICUBEDIMENSION_PSSYSBICUBEDIMENSIONID", string);
            pSSysBICubeLevelService.create(pSSysBICubeLevel);
            pSSysBICubeLevelService.copyDetails(pSSysBICubeLevel, object2);
        }
        super.onCopyDetails((IEntity)pSSysBICubeDimension, object);
    }

    @Override
    protected void exportCurXmlModel(PSSysBICubeDimension pSSysBICubeDimension, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSBICUBEDIMENSION");
        if (!bl) {
            pSSysBICubeDimension.setCreateDate(null);
            pSSysBICubeDimension.setCreateMan(null);
            pSSysBICubeDimension.setPSSysBICubeDimensionId(null);
            pSSysBICubeDimension.setUpdateDate(null);
            pSSysBICubeDimension.setUpdateMan(null);
            super.exportCurXmlModel(pSSysBICubeDimension, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysBICubeDimension pSSysBICubeDimension, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysBICubeDimension, string);
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
            return "DER1N_PSSYSBICUBEDIMENSION_PSSYSBICUBE_PSSYSBICUBEID";
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
    public String getModelV2Tag(PSSysBICubeDimension pSSysBICubeDimension) {
        if (!StringHelper.isNullOrEmpty((String)pSSysBICubeDimension.getCodeName())) {
            return pSSysBICubeDimension.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysBICubeDimension.getPSSysBICubeDimensionName())) {
            return pSSysBICubeDimension.getPSSysBICubeDimensionName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysBICubeDimension.getCodeName())) {
            return pSSysBICubeDimension.getCodeName();
        }
        return super.getModelV2Tag(pSSysBICubeDimension);
    }

    @Override
    public boolean setModelV2Tag(PSSysBICubeDimension pSSysBICubeDimension, String string) {
        pSSysBICubeDimension.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSSYSBICUBEDIMENSIONNAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSBICUBEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysBICubeDimension pSSysBICubeDimension, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysBICubeDimension.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysBICubeDimension, true);
        pSSysBICubeDimension.set("CODENAME", string);
        if (this.select(pSSysBICubeDimension, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysBICubeDimension, true);
        return super.getModelV2Entity(pSSysBICubeDimension, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysBICubeDimension pSSysBICubeDimension, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysBICubeDimension, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSSYSBICUBELEVEL_PSSYSBICUBEDIMENSION_PSSYSBICUBEDIMENSIONID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 60;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(PSSysBICubeDimension pSSysBICubeDimension, String string, String string2) throws Exception {
        File file = null;
        if (this.isExportRelatedModelV2("DER1N_PSSYSBICUBELEVEL_PSSYSBICUBEDIMENSION_PSSYSBICUBEDIMENSIONID") && (file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSBICUBEDIMENSION#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSYSBICUBELEVEL", (Object)pSSysBICubeDimension.getPSSysBICubeDimensionId()))).exists()) {
            PSSysBICubeLevelService pSSysBICubeLevelService = (PSSysBICubeLevelService)ServiceGlobal.getService(PSSysBICubeLevelService.class, (SessionFactory)this.getSessionFactory());
            String string3 = pSSysBICubeLevelService.getModelV2Name(false);
            String string4 = string + File.separator + string3;
            File file2 = new File(string4);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            ArrayList<String> arrayList = PSModelV2Helper.readFile2(file);
            for (String string5 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string5)) continue;
                ObjectNode objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string5);
                PSSysBICubeLevel pSSysBICubeLevel = new PSSysBICubeLevel();
                PSModelV2Helper.fromJSONObject((IDataObject)pSSysBICubeLevel, objectNode, false);
                String string6 = pSSysBICubeLevelService.getModelV2Tag(pSSysBICubeLevel);
                if (StringHelper.isNullOrEmpty((String)string6)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSYSBICUBELEVEL", (Object)pSSysBICubeLevel.getPSSysBICubeLevelId()));
                }
                string6 = PSModelV2Helper.getModelV2TagFolderName(string6);
                file2 = new File(string4 + File.separator + string6);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                pSSysBICubeLevelService.exportModelV2(pSSysBICubeLevel, string4 + File.separator + string6, string2);
            }
        }
        super.onExportRelatedModelV2(pSSysBICubeDimension, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSysBICubeDimension pSSysBICubeDimension, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSBICUBELEVEL_PSSYSBICUBEDIMENSION_PSSYSBICUBEDIMENSIONID")) {
            Object object;
            PSSysBICubeLevel pSSysBICubeLevel2;
            Object object2;
            Object object3;
            Object object4;
            PSSysBICubeLevelService pSSysBICubeLevelService = (PSSysBICubeLevelService)ServiceGlobal.getService(PSSysBICubeLevelService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSSysBICubeLevel> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSBICUBEDIMENSION#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSBICUBELEVEL", (Object)pSSysBICubeDimension.getPSSysBICubeDimensionId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        pSSysBICubeLevel2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add(pSSysBICubeLevel2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSSysBICubeLevel>();
                object4 = pSSysBICubeLevelService.selectByPSSysBICubeDimension(pSSysBICubeDimension);
                object3 = StringHelper.format((String)"PSSYSBICUBEDIMENSION#%1$s", (Object)pSSysBICubeDimension.getPSSysBICubeDimensionId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    pSSysBICubeLevel2 = object2.next();
                    object = pSSysBICubeLevelService.getModelV2ResScope((IEntity)pSSysBICubeLevel2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSysBICubeLevel)PSModelV2Helper.toJSONObject((IEntity)pSSysBICubeLevel2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSSysBICubeLevelService.getModelV2Name(false);
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
                        if (objectNode.has("pssysbicubelevelname")) {
                            string = objectNode.get("pssysbicubelevelname").asText();
                        }
                        if (objectNode2.has("pssysbicubelevelname")) {
                            string2 = objectNode2.get("pssysbicubelevelname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (PSSysBICubeLevel pSSysBICubeLevel2 : arrayList) {
                    object = new PSSysBICubeLevel();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)pSSysBICubeLevel2, false);
                    object3.add((JsonNode)pSSysBICubeLevelService.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSSysBICubeDimension, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSysBICubeDimension pSSysBICubeDimension) throws Exception {
        super.onEmptyModelV2(pSSysBICubeDimension);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSSysBICubeLevelService pSSysBICubeLevelService = (PSSysBICubeLevelService)ServiceGlobal.getService(PSSysBICubeLevelService.class, (SessionFactory)this.getSessionFactory());
        if (pSSysBICubeLevelService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSysBICubeDimension pSSysBICubeDimension, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSSysBICubeLevel pSSysBICubeLevel = new PSSysBICubeLevel();
        pSSysBICubeLevel.set("PSSYSBICUBEDIMENSIONID", pSSysBICubeDimension.getPSSysBICubeDimensionId());
        PSSysBICubeLevelService pSSysBICubeLevelService = (PSSysBICubeLevelService)ServiceGlobal.getService(PSSysBICubeLevelService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSSysBICubeLevelService.getModelV2Entity(pSSysBICubeLevel, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSysBICubeDimension, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysBICubeDimension pSSysBICubeDimension, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (!PSSysBICubeDimensionServiceBase.isSimpleImportExportMode("")) {
            PSSysBICubeLevelService pSSysBICubeLevelService = (PSSysBICubeLevelService)ServiceGlobal.getService(PSSysBICubeLevelService.class, (SessionFactory)this.getSessionFactory());
            ArrayNode arrayNode = null;
            String string3 = pSSysBICubeLevelService.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                    PSSysBICubeLevel pSSysBICubeLevel = new PSSysBICubeLevel();
                    pSSysBICubeLevel.setPSDEId(pSSysBICubeDimension.getPSDEId());
                    pSSysBICubeLevel.setPSSysBICubeDimensionId(pSSysBICubeDimension.getPSSysBICubeDimensionId());
                    pSSysBICubeLevel.setPSSysBICubeDimensionName(pSSysBICubeDimension.getPSSysBICubeDimensionName());
                    pSSysBICubeLevel.setPSSysBIDimensionId(pSSysBICubeDimension.getPSSysBIDimensionId());
                    pSSysBICubeLevelService.compileModelV2(pSSysBICubeLevel, objectNode2, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                File file = new File(string4);
                if (file.exists()) {
                    File[] fileArray;
                    for (File file2 : fileArray = file.listFiles()) {
                        if (!file2.isDirectory()) continue;
                        PSSysBICubeLevel pSSysBICubeLevel = new PSSysBICubeLevel();
                        pSSysBICubeLevel.setPSDEId(pSSysBICubeDimension.getPSDEId());
                        pSSysBICubeLevel.setPSSysBICubeDimensionId(pSSysBICubeDimension.getPSSysBICubeDimensionId());
                        pSSysBICubeLevel.setPSSysBICubeDimensionName(pSSysBICubeDimension.getPSSysBICubeDimensionName());
                        pSSysBICubeLevel.setPSSysBIDimensionId(pSSysBICubeDimension.getPSSysBIDimensionId());
                        pSSysBICubeLevelService.compileModelV2(pSSysBICubeLevel, null, string, file2.getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysBICubeDimension, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSysBICubeDimension pSSysBICubeDimension, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        Object var5_5 = null;
        return super.onPasteFile(pSSysBICubeDimension, pSMOSFile, string, iPSMOSFileAction);
    }

    @Override
    protected void onFillPasteHelps(PSSysBICubeDimension pSSysBICubeDimension, List<PSHelpSection> list) throws Exception {
        super.onFillPasteHelps(pSSysBICubeDimension, list);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysBICubeDimension pSSysBICubeDimension, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "Dimension");
    }
}

