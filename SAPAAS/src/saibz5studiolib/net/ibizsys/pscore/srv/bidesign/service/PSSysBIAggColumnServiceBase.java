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
import net.ibizsys.pscore.srv.bidesign.dao.PSSysBIAggColumnDAO;
import net.ibizsys.pscore.srv.bidesign.demodel.PSSysBIAggColumnDEModel;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIAggColumn;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIAggTable;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIAggTableBase;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeDimension;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeDimensionBase;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeLevel;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeLevelBase;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeMeasure;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeMeasureBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysBIAggColumnServiceBase
extends PSCoreSysServiceBase<PSSysBIAggColumn> {
    private static final Log log = LogFactory.getLog(PSSysBIAggColumnServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSSysBIAggColumnDEModel pSSysBIAggColumnDEModel;
    private PSSysBIAggColumnDAO pSSysBIAggColumnDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.bidesign.service.PSSysBIAggColumnService";
    }

    public PSSysBIAggColumnDEModel getPSSysBIAggColumnDEModel() {
        if (this.pSSysBIAggColumnDEModel == null) {
            try {
                this.pSSysBIAggColumnDEModel = (PSSysBIAggColumnDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.bidesign.demodel.PSSysBIAggColumnDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBIAggColumnDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysBIAggColumnDEModel();
    }

    public PSSysBIAggColumnDAO getPSSysBIAggColumnDAO() {
        if (this.pSSysBIAggColumnDAO == null) {
            try {
                this.pSSysBIAggColumnDAO = (PSSysBIAggColumnDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.bidesign.dao.PSSysBIAggColumnDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBIAggColumnDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysBIAggColumnDAO();
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

    protected void onFillParentInfo(PSSysBIAggColumn pSSysBIAggColumn, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBIAGGCOLUMN_PSDEFIELD_PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_PSDEF(pSSysBIAggColumn, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBIAGGCOLUMN_PSSYSBIAGGTABLE_PSSYSBIAGGTABLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBIAggTableService", (SessionFactory)this.getSessionFactory());
            PSSysBIAggTable pSSysBIAggTable = (PSSysBIAggTable)iService.getDEModel().createEntity();
            pSSysBIAggTable.set("PSSYSBIAGGTABLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysBIAggTable);
            } else {
                iService.get(pSSysBIAggTable);
            }
            this.onFillParentInfo_PSSysBIAggTable(pSSysBIAggColumn, pSSysBIAggTable);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBIAGGCOLUMN_PSSYSBICUBEDIMENSION_PSSYSBICUBEDIMENSIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeDimensionService", (SessionFactory)this.getSessionFactory());
            PSSysBICubeDimension pSSysBICubeDimension = (PSSysBICubeDimension)iService.getDEModel().createEntity();
            pSSysBICubeDimension.set("PSSYSBICUBEDIMENSIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysBICubeDimension);
            } else {
                iService.get(pSSysBICubeDimension);
            }
            this.onFillParentInfo_PSSysBICubeDimension(pSSysBIAggColumn, pSSysBICubeDimension);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBIAGGCOLUMN_PSSYSBICUBELEVEL_PSSYSBICUBELEVELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeLevelService", (SessionFactory)this.getSessionFactory());
            PSSysBICubeLevel pSSysBICubeLevel = (PSSysBICubeLevel)iService.getDEModel().createEntity();
            pSSysBICubeLevel.set("PSSYSBICUBELEVELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysBICubeLevel);
            } else {
                iService.get(pSSysBICubeLevel);
            }
            this.onFillParentInfo_PSSysBICubeLevel(pSSysBIAggColumn, pSSysBICubeLevel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBIAGGCOLUMN_PSSYSBICUBEMEASURE_PSSYSBICUBEMEASUREID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeMeasureService", (SessionFactory)this.getSessionFactory());
            PSSysBICubeMeasure pSSysBICubeMeasure = (PSSysBICubeMeasure)iService.getDEModel().createEntity();
            pSSysBICubeMeasure.set("PSSYSBICUBEMEASUREID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysBICubeMeasure);
            } else {
                iService.get(pSSysBICubeMeasure);
            }
            this.onFillParentInfo_PSSysBICubeMeasure(pSSysBIAggColumn, pSSysBICubeMeasure);
            return;
        }
        super.onFillParentInfo(pSSysBIAggColumn, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDEF(PSSysBIAggColumn pSSysBIAggColumn, PSDEField pSDEField) throws Exception {
        pSSysBIAggColumn.setPSDEFId(pSDEField.getPSDEFieldId());
        pSSysBIAggColumn.setPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PSSysBIAggTable(PSSysBIAggColumn pSSysBIAggColumn, PSSysBIAggTable pSSysBIAggTable) throws Exception {
        pSSysBIAggColumn.setPSDEId(pSSysBIAggTable.getPSDEId());
        pSSysBIAggColumn.setPSSysBIAggTableId(pSSysBIAggTable.getPSSysBIAggTableId());
        pSSysBIAggColumn.setPSSysBIAggTableName(pSSysBIAggTable.getPSSysBIAggTableName());
        pSSysBIAggColumn.setPSSysBICubeId(pSSysBIAggTable.getPSSysBICubeId());
    }

    protected void onFillParentInfo_PSSysBICubeDimension(PSSysBIAggColumn pSSysBIAggColumn, PSSysBICubeDimension pSSysBICubeDimension) throws Exception {
        pSSysBIAggColumn.setPSSysBICubeDimensionId(pSSysBICubeDimension.getPSSysBICubeDimensionId());
        pSSysBIAggColumn.setPSSysBICubeDimensionName(pSSysBICubeDimension.getPSSysBICubeDimensionName());
    }

    protected void onFillParentInfo_PSSysBICubeLevel(PSSysBIAggColumn pSSysBIAggColumn, PSSysBICubeLevel pSSysBICubeLevel) throws Exception {
        pSSysBIAggColumn.setPSSysBICubeLevelId(pSSysBICubeLevel.getPSSysBICubeLevelId());
        pSSysBIAggColumn.setPSSysBICubeLevelName(pSSysBICubeLevel.getPSSysBICubeLevelName());
    }

    protected void onFillParentInfo_PSSysBICubeMeasure(PSSysBIAggColumn pSSysBIAggColumn, PSSysBICubeMeasure pSSysBICubeMeasure) throws Exception {
        pSSysBIAggColumn.setPSSysBICubeMeasureId(pSSysBICubeMeasure.getPSSysBICubeMeasureId());
        pSSysBIAggColumn.setPSSysBICubeMeasureName(pSSysBICubeMeasure.getPSSysBICubeMeasureName());
    }

    protected void onFillEntityFullInfo(PSSysBIAggColumn pSSysBIAggColumn, boolean bl) throws Exception {
        if (bl) {
            if (pSSysBIAggColumn.getCodeName() == null) {
                pSSysBIAggColumn.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "AggColumn", 25));
            }
            if (pSSysBIAggColumn.getValidFlag() == null) {
                pSSysBIAggColumn.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSSysBIAggColumn, bl);
        this.onFillEntityFullInfo_PSDEF(pSSysBIAggColumn, bl);
        this.onFillEntityFullInfo_PSSysBIAggTable(pSSysBIAggColumn, bl);
        this.onFillEntityFullInfo_PSSysBICubeDimension(pSSysBIAggColumn, bl);
        this.onFillEntityFullInfo_PSSysBICubeLevel(pSSysBIAggColumn, bl);
        this.onFillEntityFullInfo_PSSysBICubeMeasure(pSSysBIAggColumn, bl);
    }

    protected void onFillEntityFullInfo_PSDEF(PSSysBIAggColumn pSSysBIAggColumn, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysBIAggTable(PSSysBIAggColumn pSSysBIAggColumn, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysBICubeDimension(PSSysBIAggColumn pSSysBIAggColumn, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysBICubeLevel(PSSysBIAggColumn pSSysBIAggColumn, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysBICubeMeasure(PSSysBIAggColumn pSSysBIAggColumn, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysBIAggColumn pSSysBIAggColumn, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysBIAggColumn, bl);
    }

    public ArrayList<PSSysBIAggColumn> selectByPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysBIAggColumn> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysBIAggColumn> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysBIAggColumn> selectByPSSysBIAggTable(PSSysBIAggTableBase pSSysBIAggTableBase) throws Exception {
        return this.selectByPSSysBIAggTable(pSSysBIAggTableBase, "", -1);
    }

    public ArrayList<PSSysBIAggColumn> selectByPSSysBIAggTable(PSSysBIAggTableBase pSSysBIAggTableBase, String string) throws Exception {
        return this.selectByPSSysBIAggTable(pSSysBIAggTableBase, string, -1);
    }

    public ArrayList<PSSysBIAggColumn> selectByPSSysBIAggTable(PSSysBIAggTableBase pSSysBIAggTableBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSBIAGGTABLEID", (Object)pSSysBIAggTableBase.getPSSysBIAggTableId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysBIAggTableCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysBIAggTableCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBIAggColumn> selectTempByPSSysBIAggTable(PSSysBIAggTableBase pSSysBIAggTableBase) throws Exception {
        return this.selectTempByPSSysBIAggTable(pSSysBIAggTableBase, "");
    }

    public ArrayList<PSSysBIAggColumn> selectTempByPSSysBIAggTable(PSSysBIAggTableBase pSSysBIAggTableBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSBIAGGTABLEID", (Object)pSSysBIAggTableBase.getPSSysBIAggTableId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSSysBIAggTableCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSSysBIAggTableCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBIAggColumn> selectByPSSysBICubeDimension(PSSysBICubeDimensionBase pSSysBICubeDimensionBase) throws Exception {
        return this.selectByPSSysBICubeDimension(pSSysBICubeDimensionBase, "", -1);
    }

    public ArrayList<PSSysBIAggColumn> selectByPSSysBICubeDimension(PSSysBICubeDimensionBase pSSysBICubeDimensionBase, String string) throws Exception {
        return this.selectByPSSysBICubeDimension(pSSysBICubeDimensionBase, string, -1);
    }

    public ArrayList<PSSysBIAggColumn> selectByPSSysBICubeDimension(PSSysBICubeDimensionBase pSSysBICubeDimensionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSBICUBEDIMENSIONID", (Object)pSSysBICubeDimensionBase.getPSSysBICubeDimensionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysBICubeDimensionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysBICubeDimensionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBIAggColumn> selectByPSSysBICubeLevel(PSSysBICubeLevelBase pSSysBICubeLevelBase) throws Exception {
        return this.selectByPSSysBICubeLevel(pSSysBICubeLevelBase, "", -1);
    }

    public ArrayList<PSSysBIAggColumn> selectByPSSysBICubeLevel(PSSysBICubeLevelBase pSSysBICubeLevelBase, String string) throws Exception {
        return this.selectByPSSysBICubeLevel(pSSysBICubeLevelBase, string, -1);
    }

    public ArrayList<PSSysBIAggColumn> selectByPSSysBICubeLevel(PSSysBICubeLevelBase pSSysBICubeLevelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSBICUBELEVELID", (Object)pSSysBICubeLevelBase.getPSSysBICubeLevelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysBICubeLevelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysBICubeLevelCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBIAggColumn> selectByPSSysBICubeMeasure(PSSysBICubeMeasureBase pSSysBICubeMeasureBase) throws Exception {
        return this.selectByPSSysBICubeMeasure(pSSysBICubeMeasureBase, "", -1);
    }

    public ArrayList<PSSysBIAggColumn> selectByPSSysBICubeMeasure(PSSysBICubeMeasureBase pSSysBICubeMeasureBase, String string) throws Exception {
        return this.selectByPSSysBICubeMeasure(pSSysBICubeMeasureBase, string, -1);
    }

    public ArrayList<PSSysBIAggColumn> selectByPSSysBICubeMeasure(PSSysBICubeMeasureBase pSSysBICubeMeasureBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSBICUBEMEASUREID", (Object)pSSysBICubeMeasureBase.getPSSysBICubeMeasureId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysBICubeMeasureCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysBICubeMeasureCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysBIAggColumn> arrayList = this.selectByPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBIAGGCOLUMN_PSDEFIELD_PSDEFID", "", iDataEntityModel.getName(), "PSSYSBIAGGCOLUMN", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysBIAggColumn> arrayList = this.selectByPSDEF(pSDEField);
        for (PSSysBIAggColumn pSSysBIAggColumn : arrayList) {
            PSSysBIAggColumn pSSysBIAggColumn2 = (PSSysBIAggColumn)this.getDEModel().createEntity();
            pSSysBIAggColumn2.setPSSysBIAggColumnId(pSSysBIAggColumn.getPSSysBIAggColumnId());
            pSSysBIAggColumn2.setPSDEFId(null);
            this.update(pSSysBIAggColumn2);
        }
    }

    public void removeByPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBIAggColumnServiceBase.this.onBeforeRemoveByPSDEF(pSDEField2);
                PSSysBIAggColumnServiceBase.this.internalRemoveByPSDEF(pSDEField2);
                PSSysBIAggColumnServiceBase.this.onAfterRemoveByPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysBIAggColumn> arrayList = this.selectByPSDEF(pSDEField);
        this.onBeforeRemoveByPSDEF(pSDEField, arrayList);
        for (PSSysBIAggColumn pSSysBIAggColumn : arrayList) {
            this.remove(pSSysBIAggColumn);
        }
        this.onAfterRemoveByPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSSysBIAggColumn> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSSysBIAggColumn> arrayList) throws Exception {
    }

    public void testRemoveByPSSysBIAggTable(PSSysBIAggTable pSSysBIAggTable) throws Exception {
    }

    public void resetPSSysBIAggTable(PSSysBIAggTable pSSysBIAggTable) throws Exception {
        ArrayList<PSSysBIAggColumn> arrayList = this.selectByPSSysBIAggTable(pSSysBIAggTable);
        for (PSSysBIAggColumn pSSysBIAggColumn : arrayList) {
            PSSysBIAggColumn pSSysBIAggColumn2 = (PSSysBIAggColumn)this.getDEModel().createEntity();
            pSSysBIAggColumn2.setPSSysBIAggColumnId(pSSysBIAggColumn.getPSSysBIAggColumnId());
            pSSysBIAggColumn2.setPSSysBIAggTableId(null);
            this.update(pSSysBIAggColumn2);
        }
    }

    public void resetTempPSSysBIAggTable(PSSysBIAggTable pSSysBIAggTable) throws Exception {
        ArrayList<PSSysBIAggColumn> arrayList = this.selectTempByPSSysBIAggTable(pSSysBIAggTable);
        for (PSSysBIAggColumn pSSysBIAggColumn : arrayList) {
            PSSysBIAggColumn pSSysBIAggColumn2 = (PSSysBIAggColumn)this.getDEModel().createEntity();
            pSSysBIAggColumn2.setPSSysBIAggColumnId(pSSysBIAggColumn.getPSSysBIAggColumnId());
            pSSysBIAggColumn2.setPSSysBIAggTableId(null);
            this.updateTemp(pSSysBIAggColumn2);
        }
    }

    public void removeByPSSysBIAggTable(PSSysBIAggTable pSSysBIAggTable) throws Exception {
        final PSSysBIAggTable pSSysBIAggTable2 = pSSysBIAggTable;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBIAggColumnServiceBase.this.onBeforeRemoveByPSSysBIAggTable(pSSysBIAggTable2);
                PSSysBIAggColumnServiceBase.this.internalRemoveByPSSysBIAggTable(pSSysBIAggTable2);
                PSSysBIAggColumnServiceBase.this.onAfterRemoveByPSSysBIAggTable(pSSysBIAggTable2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBIAggTable(PSSysBIAggTable pSSysBIAggTable) throws Exception {
    }

    protected void internalRemoveByPSSysBIAggTable(PSSysBIAggTable pSSysBIAggTable) throws Exception {
        ArrayList<PSSysBIAggColumn> arrayList = this.selectByPSSysBIAggTable(pSSysBIAggTable);
        this.onBeforeRemoveByPSSysBIAggTable(pSSysBIAggTable, arrayList);
        for (PSSysBIAggColumn pSSysBIAggColumn : arrayList) {
            this.remove(pSSysBIAggColumn);
        }
        this.onAfterRemoveByPSSysBIAggTable(pSSysBIAggTable, arrayList);
    }

    protected void onAfterRemoveByPSSysBIAggTable(PSSysBIAggTable pSSysBIAggTable) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBIAggTable(PSSysBIAggTable pSSysBIAggTable, ArrayList<PSSysBIAggColumn> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBIAggTable(PSSysBIAggTable pSSysBIAggTable, ArrayList<PSSysBIAggColumn> arrayList) throws Exception {
    }

    public void testRemoveByPSSysBICubeDimension(PSSysBICubeDimension pSSysBICubeDimension) throws Exception {
        ArrayList<PSSysBIAggColumn> arrayList = this.selectByPSSysBICubeDimension(pSSysBICubeDimension, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSBICUBEDIMENSION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysBICubeDimension);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBIAGGCOLUMN_PSSYSBICUBEDIMENSION_PSSYSBICUBEDIMENSIONID", "", iDataEntityModel.getName(), "PSSYSBIAGGCOLUMN", iDataEntityModel.getDataInfo(pSSysBICubeDimension), arrayList.get(0)));
        }
    }

    public void resetPSSysBICubeDimension(PSSysBICubeDimension pSSysBICubeDimension) throws Exception {
        ArrayList<PSSysBIAggColumn> arrayList = this.selectByPSSysBICubeDimension(pSSysBICubeDimension);
        for (PSSysBIAggColumn pSSysBIAggColumn : arrayList) {
            PSSysBIAggColumn pSSysBIAggColumn2 = (PSSysBIAggColumn)this.getDEModel().createEntity();
            pSSysBIAggColumn2.setPSSysBIAggColumnId(pSSysBIAggColumn.getPSSysBIAggColumnId());
            pSSysBIAggColumn2.setPSSysBICubeDimensionId(null);
            this.update(pSSysBIAggColumn2);
        }
    }

    public void removeByPSSysBICubeDimension(PSSysBICubeDimension pSSysBICubeDimension) throws Exception {
        final PSSysBICubeDimension pSSysBICubeDimension2 = pSSysBICubeDimension;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBIAggColumnServiceBase.this.onBeforeRemoveByPSSysBICubeDimension(pSSysBICubeDimension2);
                PSSysBIAggColumnServiceBase.this.internalRemoveByPSSysBICubeDimension(pSSysBICubeDimension2);
                PSSysBIAggColumnServiceBase.this.onAfterRemoveByPSSysBICubeDimension(pSSysBICubeDimension2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBICubeDimension(PSSysBICubeDimension pSSysBICubeDimension) throws Exception {
    }

    protected void internalRemoveByPSSysBICubeDimension(PSSysBICubeDimension pSSysBICubeDimension) throws Exception {
        ArrayList<PSSysBIAggColumn> arrayList = this.selectByPSSysBICubeDimension(pSSysBICubeDimension);
        this.onBeforeRemoveByPSSysBICubeDimension(pSSysBICubeDimension, arrayList);
        for (PSSysBIAggColumn pSSysBIAggColumn : arrayList) {
            this.remove(pSSysBIAggColumn);
        }
        this.onAfterRemoveByPSSysBICubeDimension(pSSysBICubeDimension, arrayList);
    }

    protected void onAfterRemoveByPSSysBICubeDimension(PSSysBICubeDimension pSSysBICubeDimension) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBICubeDimension(PSSysBICubeDimension pSSysBICubeDimension, ArrayList<PSSysBIAggColumn> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBICubeDimension(PSSysBICubeDimension pSSysBICubeDimension, ArrayList<PSSysBIAggColumn> arrayList) throws Exception {
    }

    public void testRemoveByPSSysBICubeLevel(PSSysBICubeLevel pSSysBICubeLevel) throws Exception {
        ArrayList<PSSysBIAggColumn> arrayList = this.selectByPSSysBICubeLevel(pSSysBICubeLevel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSBICUBELEVEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysBICubeLevel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBIAGGCOLUMN_PSSYSBICUBELEVEL_PSSYSBICUBELEVELID", "", iDataEntityModel.getName(), "PSSYSBIAGGCOLUMN", iDataEntityModel.getDataInfo(pSSysBICubeLevel), arrayList.get(0)));
        }
    }

    public void resetPSSysBICubeLevel(PSSysBICubeLevel pSSysBICubeLevel) throws Exception {
        ArrayList<PSSysBIAggColumn> arrayList = this.selectByPSSysBICubeLevel(pSSysBICubeLevel);
        for (PSSysBIAggColumn pSSysBIAggColumn : arrayList) {
            PSSysBIAggColumn pSSysBIAggColumn2 = (PSSysBIAggColumn)this.getDEModel().createEntity();
            pSSysBIAggColumn2.setPSSysBIAggColumnId(pSSysBIAggColumn.getPSSysBIAggColumnId());
            pSSysBIAggColumn2.setPSSysBICubeLevelId(null);
            this.update(pSSysBIAggColumn2);
        }
    }

    public void removeByPSSysBICubeLevel(PSSysBICubeLevel pSSysBICubeLevel) throws Exception {
        final PSSysBICubeLevel pSSysBICubeLevel2 = pSSysBICubeLevel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBIAggColumnServiceBase.this.onBeforeRemoveByPSSysBICubeLevel(pSSysBICubeLevel2);
                PSSysBIAggColumnServiceBase.this.internalRemoveByPSSysBICubeLevel(pSSysBICubeLevel2);
                PSSysBIAggColumnServiceBase.this.onAfterRemoveByPSSysBICubeLevel(pSSysBICubeLevel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBICubeLevel(PSSysBICubeLevel pSSysBICubeLevel) throws Exception {
    }

    protected void internalRemoveByPSSysBICubeLevel(PSSysBICubeLevel pSSysBICubeLevel) throws Exception {
        ArrayList<PSSysBIAggColumn> arrayList = this.selectByPSSysBICubeLevel(pSSysBICubeLevel);
        this.onBeforeRemoveByPSSysBICubeLevel(pSSysBICubeLevel, arrayList);
        for (PSSysBIAggColumn pSSysBIAggColumn : arrayList) {
            this.remove(pSSysBIAggColumn);
        }
        this.onAfterRemoveByPSSysBICubeLevel(pSSysBICubeLevel, arrayList);
    }

    protected void onAfterRemoveByPSSysBICubeLevel(PSSysBICubeLevel pSSysBICubeLevel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBICubeLevel(PSSysBICubeLevel pSSysBICubeLevel, ArrayList<PSSysBIAggColumn> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBICubeLevel(PSSysBICubeLevel pSSysBICubeLevel, ArrayList<PSSysBIAggColumn> arrayList) throws Exception {
    }

    public void testRemoveByPSSysBICubeMeasure(PSSysBICubeMeasure pSSysBICubeMeasure) throws Exception {
        ArrayList<PSSysBIAggColumn> arrayList = this.selectByPSSysBICubeMeasure(pSSysBICubeMeasure, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSBICUBEMEASURE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysBICubeMeasure);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBIAGGCOLUMN_PSSYSBICUBEMEASURE_PSSYSBICUBEMEASUREID", "", iDataEntityModel.getName(), "PSSYSBIAGGCOLUMN", iDataEntityModel.getDataInfo(pSSysBICubeMeasure), arrayList.get(0)));
        }
    }

    public void resetPSSysBICubeMeasure(PSSysBICubeMeasure pSSysBICubeMeasure) throws Exception {
        ArrayList<PSSysBIAggColumn> arrayList = this.selectByPSSysBICubeMeasure(pSSysBICubeMeasure);
        for (PSSysBIAggColumn pSSysBIAggColumn : arrayList) {
            PSSysBIAggColumn pSSysBIAggColumn2 = (PSSysBIAggColumn)this.getDEModel().createEntity();
            pSSysBIAggColumn2.setPSSysBIAggColumnId(pSSysBIAggColumn.getPSSysBIAggColumnId());
            pSSysBIAggColumn2.setPSSysBICubeMeasureId(null);
            this.update(pSSysBIAggColumn2);
        }
    }

    public void removeByPSSysBICubeMeasure(PSSysBICubeMeasure pSSysBICubeMeasure) throws Exception {
        final PSSysBICubeMeasure pSSysBICubeMeasure2 = pSSysBICubeMeasure;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBIAggColumnServiceBase.this.onBeforeRemoveByPSSysBICubeMeasure(pSSysBICubeMeasure2);
                PSSysBIAggColumnServiceBase.this.internalRemoveByPSSysBICubeMeasure(pSSysBICubeMeasure2);
                PSSysBIAggColumnServiceBase.this.onAfterRemoveByPSSysBICubeMeasure(pSSysBICubeMeasure2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBICubeMeasure(PSSysBICubeMeasure pSSysBICubeMeasure) throws Exception {
    }

    protected void internalRemoveByPSSysBICubeMeasure(PSSysBICubeMeasure pSSysBICubeMeasure) throws Exception {
        ArrayList<PSSysBIAggColumn> arrayList = this.selectByPSSysBICubeMeasure(pSSysBICubeMeasure);
        this.onBeforeRemoveByPSSysBICubeMeasure(pSSysBICubeMeasure, arrayList);
        for (PSSysBIAggColumn pSSysBIAggColumn : arrayList) {
            this.remove(pSSysBIAggColumn);
        }
        this.onAfterRemoveByPSSysBICubeMeasure(pSSysBICubeMeasure, arrayList);
    }

    protected void onAfterRemoveByPSSysBICubeMeasure(PSSysBICubeMeasure pSSysBICubeMeasure) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBICubeMeasure(PSSysBICubeMeasure pSSysBICubeMeasure, ArrayList<PSSysBIAggColumn> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBICubeMeasure(PSSysBICubeMeasure pSSysBICubeMeasure, ArrayList<PSSysBIAggColumn> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysBIAggColumn pSSysBIAggColumn) throws Exception {
        super.onBeforeRemove(pSSysBIAggColumn);
    }

    public void removeTempByPSSysBIAggTable(PSSysBIAggTable pSSysBIAggTable) throws Exception {
        final PSSysBIAggTable pSSysBIAggTable2 = pSSysBIAggTable;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBIAggColumnServiceBase.this.onBeforeRemoveTempByPSSysBIAggTable(pSSysBIAggTable2);
                PSSysBIAggColumnServiceBase.this.internalRemoveTempByPSSysBIAggTable(pSSysBIAggTable2);
                PSSysBIAggColumnServiceBase.this.onAfterRemoveTempByPSSysBIAggTable(pSSysBIAggTable2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSSysBIAggTable(PSSysBIAggTable pSSysBIAggTable) throws Exception {
    }

    protected void internalRemoveTempByPSSysBIAggTable(PSSysBIAggTable pSSysBIAggTable) throws Exception {
        ArrayList<PSSysBIAggColumn> arrayList = this.selectTempByPSSysBIAggTable(pSSysBIAggTable);
        this.onBeforeRemoveTempByPSSysBIAggTable(pSSysBIAggTable, arrayList);
        for (PSSysBIAggColumn pSSysBIAggColumn : arrayList) {
            this.removeTemp(pSSysBIAggColumn);
        }
        this.onAfterRemoveTempByPSSysBIAggTable(pSSysBIAggTable, arrayList);
    }

    protected void onAfterRemoveTempByPSSysBIAggTable(PSSysBIAggTable pSSysBIAggTable) throws Exception {
    }

    protected void onBeforeRemoveTempByPSSysBIAggTable(PSSysBIAggTable pSSysBIAggTable, ArrayList<PSSysBIAggColumn> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSSysBIAggTable(PSSysBIAggTable pSSysBIAggTable, ArrayList<PSSysBIAggColumn> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSSysBIAggColumn pSSysBIAggColumn, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysBIAggColumn, cloneSession);
        if (pSSysBIAggColumn.getPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysBIAggColumn.getPSDEFId())) != null) {
            this.onFillParentInfo_PSDEF(pSSysBIAggColumn, (PSDEField)iEntity);
        }
        if (pSSysBIAggColumn.getPSSysBIAggTableId() != null && (iEntity = cloneSession.getEntity("PSSYSBIAGGTABLE", (Object)pSSysBIAggColumn.getPSSysBIAggTableId())) != null) {
            this.onFillParentInfo_PSSysBIAggTable(pSSysBIAggColumn, (PSSysBIAggTable)iEntity);
        }
        if (pSSysBIAggColumn.getPSSysBICubeDimensionId() != null && (iEntity = cloneSession.getEntity("PSSYSBICUBEDIMENSION", (Object)pSSysBIAggColumn.getPSSysBICubeDimensionId())) != null) {
            this.onFillParentInfo_PSSysBICubeDimension(pSSysBIAggColumn, (PSSysBICubeDimension)iEntity);
        }
        if (pSSysBIAggColumn.getPSSysBICubeLevelId() != null && (iEntity = cloneSession.getEntity("PSSYSBICUBELEVEL", (Object)pSSysBIAggColumn.getPSSysBICubeLevelId())) != null) {
            this.onFillParentInfo_PSSysBICubeLevel(pSSysBIAggColumn, (PSSysBICubeLevel)iEntity);
        }
        if (pSSysBIAggColumn.getPSSysBICubeMeasureId() != null && (iEntity = cloneSession.getEntity("PSSYSBICUBEMEASURE", (Object)pSSysBIAggColumn.getPSSysBICubeMeasureId())) != null) {
            this.onFillParentInfo_PSSysBICubeMeasure(pSSysBIAggColumn, (PSSysBICubeMeasure)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysBIAggColumn pSSysBIAggColumn, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysBIAggColumn, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysBIAggColumn pSSysBIAggColumn, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BIAggColumnTag(bl, pSSysBIAggColumn, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BIAggColumnTag2(bl, pSSysBIAggColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BIAggColumnType(bl, pSSysBIAggColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSysBIAggColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultValue(bl, pSSysBIAggColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultValueType(bl, pSSysBIAggColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysBIAggColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFId(bl, pSSysBIAggColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBIAggColumnId(bl, pSSysBIAggColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBIAggColumnName(bl, pSSysBIAggColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBIAggTableId(bl, pSSysBIAggColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBICubeDimensionId(bl, pSSysBIAggColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBICubeLevelId(bl, pSSysBIAggColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBICubeMeasureId(bl, pSSysBIAggColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysBIAggColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysBIAggColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysBIAggColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysBIAggColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysBIAggColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysBIAggColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysBIAggColumn, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BIAggColumnTag(boolean bl, PSSysBIAggColumn pSSysBIAggColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIAggColumn.isBIAggColumnTagDirty() : !pSSysBIAggColumn.isBIAggColumnTagDirty()) {
            return null;
        }
        String string = pSSysBIAggColumn.getBIAggColumnTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BIAggColumnTag_Default(pSSysBIAggColumn, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BIAGGCOLUMNTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BIAggColumnTag2(boolean bl, PSSysBIAggColumn pSSysBIAggColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIAggColumn.isBIAggColumnTag2Dirty() : !pSSysBIAggColumn.isBIAggColumnTag2Dirty()) {
            return null;
        }
        String string = pSSysBIAggColumn.getBIAggColumnTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BIAggColumnTag2_Default(pSSysBIAggColumn, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BIAGGCOLUMNTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BIAggColumnType(boolean bl, PSSysBIAggColumn pSSysBIAggColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIAggColumn.isBIAggColumnTypeDirty() && !bl2 : !pSSysBIAggColumn.isBIAggColumnTypeDirty()) {
            return null;
        }
        String string = pSSysBIAggColumn.getBIAggColumnType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BIAGGCOLUMNTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_BIAggColumnType_Default(pSSysBIAggColumn, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BIAGGCOLUMNTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysBIAggColumn pSSysBIAggColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIAggColumn.isCodeNameDirty() && !bl2 : !pSSysBIAggColumn.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysBIAggColumn.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSysBIAggColumn, bl2, bl3);
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
                string3 = "PSSYSBIAGGTABLEID";
                String string4 = this.checkFieldDupRule(this.getPSSysBIAggColumnDEModel(), "CODENAME", string3, pSSysBIAggColumn, bl2, bl3);
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

    protected EntityFieldError onCheckField_DefaultValue(boolean bl, PSSysBIAggColumn pSSysBIAggColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIAggColumn.isDefaultValueDirty() : !pSSysBIAggColumn.isDefaultValueDirty()) {
            return null;
        }
        String string = pSSysBIAggColumn.getDefaultValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DefaultValue_Default(pSSysBIAggColumn, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefaultValueType(boolean bl, PSSysBIAggColumn pSSysBIAggColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIAggColumn.isDefaultValueTypeDirty() : !pSSysBIAggColumn.isDefaultValueTypeDirty()) {
            return null;
        }
        String string = pSSysBIAggColumn.getDefaultValueType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DefaultValueType_Default(pSSysBIAggColumn, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DVT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysBIAggColumn pSSysBIAggColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIAggColumn.isMemoDirty() : !pSSysBIAggColumn.isMemoDirty()) {
            return null;
        }
        String string = pSSysBIAggColumn.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysBIAggColumn, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFId(boolean bl, PSSysBIAggColumn pSSysBIAggColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIAggColumn.isPSDEFIdDirty() && !bl2 : !pSSysBIAggColumn.isPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysBIAggColumn.getPSDEFId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFId_Default(pSSysBIAggColumn, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysBIAggColumnId(boolean bl, PSSysBIAggColumn pSSysBIAggColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIAggColumn.isPSSysBIAggColumnIdDirty() && !bl2 : !pSSysBIAggColumn.isPSSysBIAggColumnIdDirty()) {
            return null;
        }
        String string = pSSysBIAggColumn.getPSSysBIAggColumnId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBIAGGCOLUMNID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBIAggColumnId_Default(pSSysBIAggColumn, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBIAGGCOLUMNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBIAggColumnName(boolean bl, PSSysBIAggColumn pSSysBIAggColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIAggColumn.isPSSysBIAggColumnNameDirty() && !bl2 : !pSSysBIAggColumn.isPSSysBIAggColumnNameDirty()) {
            return null;
        }
        String string = pSSysBIAggColumn.getPSSysBIAggColumnName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBIAGGCOLUMNNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBIAggColumnName_Default(pSSysBIAggColumn, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBIAGGCOLUMNNAME");
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
                string3 = "PSSYSBIAGGTABLEID";
                String string4 = this.checkFieldDupRule(this.getPSSysBIAggColumnDEModel(), "PSSYSBIAGGCOLUMNNAME", string3, pSSysBIAggColumn, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSBIAGGCOLUMNNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBIAggTableId(boolean bl, PSSysBIAggColumn pSSysBIAggColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIAggColumn.isPSSysBIAggTableIdDirty() && !bl2 : !pSSysBIAggColumn.isPSSysBIAggTableIdDirty()) {
            return null;
        }
        String string = pSSysBIAggColumn.getPSSysBIAggTableId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBIAGGTABLEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBIAggTableId_Default(pSSysBIAggColumn, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBIAGGTABLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBICubeDimensionId(boolean bl, PSSysBIAggColumn pSSysBIAggColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIAggColumn.isPSSysBICubeDimensionIdDirty() : !pSSysBIAggColumn.isPSSysBICubeDimensionIdDirty()) {
            return null;
        }
        String string = pSSysBIAggColumn.getPSSysBICubeDimensionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBICubeDimensionId_Default(pSSysBIAggColumn, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysBICubeLevelId(boolean bl, PSSysBIAggColumn pSSysBIAggColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIAggColumn.isPSSysBICubeLevelIdDirty() : !pSSysBIAggColumn.isPSSysBICubeLevelIdDirty()) {
            return null;
        }
        String string = pSSysBIAggColumn.getPSSysBICubeLevelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBICubeLevelId_Default(pSSysBIAggColumn, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBICUBELEVELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBICubeMeasureId(boolean bl, PSSysBIAggColumn pSSysBIAggColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIAggColumn.isPSSysBICubeMeasureIdDirty() : !pSSysBIAggColumn.isPSSysBICubeMeasureIdDirty()) {
            return null;
        }
        String string = pSSysBIAggColumn.getPSSysBICubeMeasureId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBICubeMeasureId_Default(pSSysBIAggColumn, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBICUBEMEASUREID");
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
                string3 = "PSSYSBIAGGTABLEID";
                String string4 = this.checkFieldDupRule(this.getPSSysBIAggColumnDEModel(), "PSSYSBICUBEMEASUREID", string3, pSSysBIAggColumn, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSBICUBEMEASUREID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysBIAggColumn pSSysBIAggColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIAggColumn.isUserCatDirty() : !pSSysBIAggColumn.isUserCatDirty()) {
            return null;
        }
        String string = pSSysBIAggColumn.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysBIAggColumn, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysBIAggColumn pSSysBIAggColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIAggColumn.isUserTagDirty() : !pSSysBIAggColumn.isUserTagDirty()) {
            return null;
        }
        String string = pSSysBIAggColumn.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysBIAggColumn, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysBIAggColumn pSSysBIAggColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIAggColumn.isUserTag2Dirty() : !pSSysBIAggColumn.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysBIAggColumn.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysBIAggColumn, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysBIAggColumn pSSysBIAggColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIAggColumn.isUserTag3Dirty() : !pSSysBIAggColumn.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysBIAggColumn.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysBIAggColumn, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysBIAggColumn pSSysBIAggColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIAggColumn.isUserTag4Dirty() : !pSSysBIAggColumn.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysBIAggColumn.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysBIAggColumn, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysBIAggColumn pSSysBIAggColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIAggColumn.isValidFlagDirty() && !bl2 : !pSSysBIAggColumn.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysBIAggColumn.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSysBIAggColumn, bl2, bl3);
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

    protected void onSyncEntity(PSSysBIAggColumn pSSysBIAggColumn, boolean bl) throws Exception {
        super.onSyncEntity(pSSysBIAggColumn, bl);
    }

    protected void onSyncIndexEntities(PSSysBIAggColumn pSSysBIAggColumn, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysBIAggColumn, bl);
    }

    public Object getDataContextValue(PSSysBIAggColumn pSSysBIAggColumn, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysBIAggColumn, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysBIAggTable pSSysBIAggTable = pSSysBIAggColumn.getPSSysBIAggTable();
        if (pSSysBIAggTable != null && pSSysBIAggTable.contains(string)) {
            return pSSysBIAggTable.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysBIAggColumn pSSysBIAggColumn, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysBIAggColumn, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BIAGGCOLUMNTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BIAggColumnTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BIAGGCOLUMNTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BIAggColumnTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BIAGGCOLUMNTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BIAggColumnType_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"DEFAULTVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DVT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultValueType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSBIAGGCOLUMNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBIAggColumnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBIAGGCOLUMNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBIAggColumnName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBIAGGTABLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBIAggTableId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBIAGGTABLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBIAggTableName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSBICUBELEVELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBICubeLevelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBICUBELEVELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBICubeLevelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBICUBEMEASUREID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBICubeMeasureId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBICUBEMEASURENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBICubeMeasureName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_BIAggColumnTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BIAGGCOLUMNTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BIAggColumnTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BIAGGCOLUMNTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BIAggColumnType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BIAGGCOLUMNTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
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

    protected String onTestValueRule_DefaultValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEFAULTVALUE", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DefaultValueType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DVT", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected String onTestValueRule_PSSysBIAggColumnId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBIAGGCOLUMNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBIAggColumnName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBIAGGCOLUMNNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBIAggTableId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBIAGGTABLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBIAggTableName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBIAGGTABLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSSysBICubeLevelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBICUBELEVELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBICubeLevelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBICUBELEVELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected boolean onMergeChild(String string, String string2, PSSysBIAggColumn pSSysBIAggColumn) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysBIAggColumn)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysBIAggColumn pSSysBIAggColumn) throws Exception {
        super.onUpdateParent(pSSysBIAggColumn);
    }

    @Override
    protected void exportCurXmlModel(PSSysBIAggColumn pSSysBIAggColumn, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSBIAGGCOLUMN");
        if (!bl) {
            pSSysBIAggColumn.setCreateDate(null);
            pSSysBIAggColumn.setCreateMan(null);
            pSSysBIAggColumn.setPSSysBIAggColumnId(null);
            pSSysBIAggColumn.setUpdateDate(null);
            pSSysBIAggColumn.setUpdateMan(null);
            pSSysBIAggColumn.setPSDEId(null);
            pSSysBIAggColumn.setPSSysBIAggTableId(null);
            pSSysBIAggColumn.setPSSysBIAggTableName(null);
            pSSysBIAggColumn.setPSSysBICubeId(null);
            super.exportCurXmlModel(pSSysBIAggColumn, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysBIAggColumn pSSysBIAggColumn, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysBIAggColumn, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBIAGGTABLEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSBIAGGTABLE#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBIAGGTABLEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSBIAGGCOLUMN_PSSYSBIAGGTABLE_PSSYSBIAGGTABLEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBIAGGTABLEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBIAGGTABLENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSBIAGGTABLE", (boolean)true) == 0) {
            iEntity.set("PSSYSBIAGGTABLEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSBIAGGTABLEID"};
    }

    @Override
    public String getModelV2Tag(PSSysBIAggColumn pSSysBIAggColumn) {
        if (!StringHelper.isNullOrEmpty((String)pSSysBIAggColumn.getCodeName())) {
            return pSSysBIAggColumn.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysBIAggColumn.getPSSysBIAggColumnName())) {
            return pSSysBIAggColumn.getPSSysBIAggColumnName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysBIAggColumn.getCodeName())) {
            return pSSysBIAggColumn.getCodeName();
        }
        return super.getModelV2Tag(pSSysBIAggColumn);
    }

    @Override
    public boolean setModelV2Tag(PSSysBIAggColumn pSSysBIAggColumn, String string) {
        pSSysBIAggColumn.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSSYSBIAGGCOLUMNNAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSBIAGGTABLEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysBIAggColumn pSSysBIAggColumn, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysBIAggColumn.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysBIAggColumn, true);
        pSSysBIAggColumn.set("CODENAME", string);
        if (this.select(pSSysBIAggColumn, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysBIAggColumn, true);
        return super.getModelV2Entity(pSSysBIAggColumn, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysBIAggColumn pSSysBIAggColumn, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSSysBIAggColumn, objectNode, string, string2, n);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysBIAggColumn pSSysBIAggColumn, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "AggColumn");
    }
}

