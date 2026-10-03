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
import net.ibizsys.pscore.srv.bidesign.dao.PSSysBIReportItemDAO;
import net.ibizsys.pscore.srv.bidesign.demodel.PSSysBIReportItemDEModel;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICube;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeBase;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeDimension;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeDimensionBase;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeLevel;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeLevelBase;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeMeasure;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeMeasureBase;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIReport;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIReportBase;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIReportItem;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIReportItemBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIReportItemService;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysBIReportItemServiceBase
extends PSCoreSysServiceBase<PSSysBIReportItem> {
    private static final Log log = LogFactory.getLog(PSSysBIReportItemServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysBIReportItemDEModel pSSysBIReportItemDEModel;
    private PSSysBIReportItemDAO pSSysBIReportItemDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.bidesign.service.PSSysBIReportItemService";
    }

    public PSSysBIReportItemDEModel getPSSysBIReportItemDEModel() {
        if (this.pSSysBIReportItemDEModel == null) {
            try {
                this.pSSysBIReportItemDEModel = (PSSysBIReportItemDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.bidesign.demodel.PSSysBIReportItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBIReportItemDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysBIReportItemDEModel();
    }

    public PSSysBIReportItemDAO getPSSysBIReportItemDAO() {
        if (this.pSSysBIReportItemDAO == null) {
            try {
                this.pSSysBIReportItemDAO = (PSSysBIReportItemDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.bidesign.dao.PSSysBIReportItemDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBIReportItemDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysBIReportItemDAO();
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

    protected void onFillParentInfo(PSSysBIReportItem pSSysBIReportItem, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBIREPORTITEM_PSSYSBICUBEDIMENSION_PSSYSBICUBEDIMENSIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeDimensionService", (SessionFactory)this.getSessionFactory());
            PSSysBICubeDimension pSSysBICubeDimension = (PSSysBICubeDimension)iService.getDEModel().createEntity();
            pSSysBICubeDimension.set("PSSYSBICUBEDIMENSIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysBICubeDimension);
            } else {
                iService.get(pSSysBICubeDimension);
            }
            this.onFillParentInfo_PSSysBICubeDimension(pSSysBIReportItem, pSSysBICubeDimension);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBIREPORTITEM_PSSYSBICUBELEVEL_PSSYSBICUBELEVELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeLevelService", (SessionFactory)this.getSessionFactory());
            PSSysBICubeLevel pSSysBICubeLevel = (PSSysBICubeLevel)iService.getDEModel().createEntity();
            pSSysBICubeLevel.set("PSSYSBICUBELEVELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysBICubeLevel);
            } else {
                iService.get(pSSysBICubeLevel);
            }
            this.onFillParentInfo_PSSysBICubeLevel(pSSysBIReportItem, pSSysBICubeLevel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBIREPORTITEM_PSSYSBICUBEMEASURE_PSSYSBICUBEMEASUREID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeMeasureService", (SessionFactory)this.getSessionFactory());
            PSSysBICubeMeasure pSSysBICubeMeasure = (PSSysBICubeMeasure)iService.getDEModel().createEntity();
            pSSysBICubeMeasure.set("PSSYSBICUBEMEASUREID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysBICubeMeasure);
            } else {
                iService.get(pSSysBICubeMeasure);
            }
            this.onFillParentInfo_PSSysBICubeMeasure(pSSysBIReportItem, pSSysBICubeMeasure);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBIREPORTITEM_PSSYSBICUBEMEASURE_REFPSSYSBICUBEMEASUREID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeMeasureService", (SessionFactory)this.getSessionFactory());
            PSSysBICubeMeasure pSSysBICubeMeasure = (PSSysBICubeMeasure)iService.getDEModel().createEntity();
            pSSysBICubeMeasure.set("PSSYSBICUBEMEASUREID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysBICubeMeasure);
            } else {
                iService.get(pSSysBICubeMeasure);
            }
            this.onFillParentInfo_RefPSSysBICubeMeasure(pSSysBIReportItem, pSSysBICubeMeasure);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBIREPORTITEM_PSSYSBICUBE_PSSYSBICUBEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeService", (SessionFactory)this.getSessionFactory());
            PSSysBICube pSSysBICube = (PSSysBICube)iService.getDEModel().createEntity();
            pSSysBICube.set("PSSYSBICUBEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysBICube);
            } else {
                iService.get(pSSysBICube);
            }
            this.onFillParentInfo_PSSysBICube(pSSysBIReportItem, pSSysBICube);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBIREPORTITEM_PSSYSBIREPORTITEM_PPSSYSBIREPORTITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBIReportItemService", (SessionFactory)this.getSessionFactory());
            PSSysBIReportItem pSSysBIReportItem2 = (PSSysBIReportItem)iService.getDEModel().createEntity();
            pSSysBIReportItem2.set("PSSYSBIREPORTITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysBIReportItem2);
            } else {
                iService.get(pSSysBIReportItem2);
            }
            this.onFillParentInfo_PPSSysBIReportItem(pSSysBIReportItem, pSSysBIReportItem2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBIREPORTITEM_PSSYSBIREPORT_PSSYSBIREPORTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBIReportService", (SessionFactory)this.getSessionFactory());
            PSSysBIReport pSSysBIReport = (PSSysBIReport)iService.getDEModel().createEntity();
            pSSysBIReport.set("PSSYSBIREPORTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysBIReport);
            } else {
                iService.get(pSSysBIReport);
            }
            this.onFillParentInfo_PSSysBIReport(pSSysBIReportItem, pSSysBIReport);
            return;
        }
        super.onFillParentInfo(pSSysBIReportItem, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSysBICubeDimension(PSSysBIReportItem pSSysBIReportItem, PSSysBICubeDimension pSSysBICubeDimension) throws Exception {
        pSSysBIReportItem.setPSSysBICubeDimensionId(pSSysBICubeDimension.getPSSysBICubeDimensionId());
        pSSysBIReportItem.setPSSysBICubeDimensionName(pSSysBICubeDimension.getPSSysBICubeDimensionName());
    }

    protected void onFillParentInfo_PSSysBICubeLevel(PSSysBIReportItem pSSysBIReportItem, PSSysBICubeLevel pSSysBICubeLevel) throws Exception {
        pSSysBIReportItem.setPSSysBICubeLevelId(pSSysBICubeLevel.getPSSysBICubeLevelId());
        pSSysBIReportItem.setPSSysBICubeLevelName(pSSysBICubeLevel.getPSSysBICubeLevelName());
    }

    protected void onFillParentInfo_PSSysBICubeMeasure(PSSysBIReportItem pSSysBIReportItem, PSSysBICubeMeasure pSSysBICubeMeasure) throws Exception {
        pSSysBIReportItem.setPSSysBICubeMeasureId(pSSysBICubeMeasure.getPSSysBICubeMeasureId());
        pSSysBIReportItem.setPSSysBICubeMeasureName(pSSysBICubeMeasure.getPSSysBICubeMeasureName());
    }

    protected void onFillParentInfo_RefPSSysBICubeMeasure(PSSysBIReportItem pSSysBIReportItem, PSSysBICubeMeasure pSSysBICubeMeasure) throws Exception {
        pSSysBIReportItem.setRefPSSysBICubeMeasureId(pSSysBICubeMeasure.getPSSysBICubeMeasureId());
        pSSysBIReportItem.setRefPSSysBICubeMeasureName(pSSysBICubeMeasure.getPSSysBICubeMeasureName());
    }

    protected void onFillParentInfo_PSSysBICube(PSSysBIReportItem pSSysBIReportItem, PSSysBICube pSSysBICube) throws Exception {
        pSSysBIReportItem.setPSSysBICubeId(pSSysBICube.getPSSysBICubeId());
        pSSysBIReportItem.setPSSysBICubeName(pSSysBICube.getPSSysBICubeName());
    }

    protected void onFillParentInfo_PPSSysBIReportItem(PSSysBIReportItem pSSysBIReportItem, PSSysBIReportItem pSSysBIReportItem2) throws Exception {
        pSSysBIReportItem.setPPSSysBIReportItemId(pSSysBIReportItem2.getPSSysBIReportItemId());
        pSSysBIReportItem.setPPSSysBIReportItemName(pSSysBIReportItem2.getPSSysBIReportItemName());
    }

    protected void onFillParentInfo_PSSysBIReport(PSSysBIReportItem pSSysBIReportItem, PSSysBIReport pSSysBIReport) throws Exception {
        pSSysBIReportItem.setPSSysBIReportId(pSSysBIReport.getPSSysBIReportId());
        pSSysBIReportItem.setPSSysBIReportName(pSSysBIReport.getPSSysBIReportName());
        pSSysBIReportItem.setPSSysBISchemeId(pSSysBIReport.getPSSysBISchemeId());
        if (pSSysBIReport.getPSSysBICube() != null) {
            this.onFillParentInfo_PSSysBICube(pSSysBIReportItem, pSSysBIReport.getPSSysBICube());
        }
    }

    protected void onFillEntityFullInfo(PSSysBIReportItem pSSysBIReportItem, boolean bl) throws Exception {
        if (bl && pSSysBIReportItem.getValidFlag() == null) {
            pSSysBIReportItem.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSSysBIReportItem, bl);
        this.onFillEntityFullInfo_PSSysBICubeDimension(pSSysBIReportItem, bl);
        this.onFillEntityFullInfo_PSSysBICubeLevel(pSSysBIReportItem, bl);
        this.onFillEntityFullInfo_PSSysBICubeMeasure(pSSysBIReportItem, bl);
        this.onFillEntityFullInfo_RefPSSysBICubeMeasure(pSSysBIReportItem, bl);
        this.onFillEntityFullInfo_PSSysBICube(pSSysBIReportItem, bl);
        this.onFillEntityFullInfo_PPSSysBIReportItem(pSSysBIReportItem, bl);
        this.onFillEntityFullInfo_PSSysBIReport(pSSysBIReportItem, bl);
    }

    protected void onFillEntityFullInfo_PSSysBICubeDimension(PSSysBIReportItem pSSysBIReportItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysBICubeLevel(PSSysBIReportItem pSSysBIReportItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysBICubeMeasure(PSSysBIReportItem pSSysBIReportItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefPSSysBICubeMeasure(PSSysBIReportItem pSSysBIReportItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysBICube(PSSysBIReportItem pSSysBIReportItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PPSSysBIReportItem(PSSysBIReportItem pSSysBIReportItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysBIReport(PSSysBIReportItem pSSysBIReportItem, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysBIReportItem pSSysBIReportItem, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysBIReportItem, bl);
    }

    public ArrayList<PSSysBIReportItem> selectByPSSysBICubeDimension(PSSysBICubeDimensionBase pSSysBICubeDimensionBase) throws Exception {
        return this.selectByPSSysBICubeDimension(pSSysBICubeDimensionBase, "", -1);
    }

    public ArrayList<PSSysBIReportItem> selectByPSSysBICubeDimension(PSSysBICubeDimensionBase pSSysBICubeDimensionBase, String string) throws Exception {
        return this.selectByPSSysBICubeDimension(pSSysBICubeDimensionBase, string, -1);
    }

    public ArrayList<PSSysBIReportItem> selectByPSSysBICubeDimension(PSSysBICubeDimensionBase pSSysBICubeDimensionBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysBIReportItem> selectByPSSysBICubeLevel(PSSysBICubeLevelBase pSSysBICubeLevelBase) throws Exception {
        return this.selectByPSSysBICubeLevel(pSSysBICubeLevelBase, "", -1);
    }

    public ArrayList<PSSysBIReportItem> selectByPSSysBICubeLevel(PSSysBICubeLevelBase pSSysBICubeLevelBase, String string) throws Exception {
        return this.selectByPSSysBICubeLevel(pSSysBICubeLevelBase, string, -1);
    }

    public ArrayList<PSSysBIReportItem> selectByPSSysBICubeLevel(PSSysBICubeLevelBase pSSysBICubeLevelBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysBIReportItem> selectByPSSysBICubeMeasure(PSSysBICubeMeasureBase pSSysBICubeMeasureBase) throws Exception {
        return this.selectByPSSysBICubeMeasure(pSSysBICubeMeasureBase, "", -1);
    }

    public ArrayList<PSSysBIReportItem> selectByPSSysBICubeMeasure(PSSysBICubeMeasureBase pSSysBICubeMeasureBase, String string) throws Exception {
        return this.selectByPSSysBICubeMeasure(pSSysBICubeMeasureBase, string, -1);
    }

    public ArrayList<PSSysBIReportItem> selectByPSSysBICubeMeasure(PSSysBICubeMeasureBase pSSysBICubeMeasureBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysBIReportItem> selectByRefPSSysBICubeMeasure(PSSysBICubeMeasureBase pSSysBICubeMeasureBase) throws Exception {
        return this.selectByRefPSSysBICubeMeasure(pSSysBICubeMeasureBase, "", -1);
    }

    public ArrayList<PSSysBIReportItem> selectByRefPSSysBICubeMeasure(PSSysBICubeMeasureBase pSSysBICubeMeasureBase, String string) throws Exception {
        return this.selectByRefPSSysBICubeMeasure(pSSysBICubeMeasureBase, string, -1);
    }

    public ArrayList<PSSysBIReportItem> selectByRefPSSysBICubeMeasure(PSSysBICubeMeasureBase pSSysBICubeMeasureBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSSYSBICUBEMEASUREID", (Object)pSSysBICubeMeasureBase.getPSSysBICubeMeasureId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSSysBICubeMeasureCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSSysBICubeMeasureCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBIReportItem> selectByPSSysBICube(PSSysBICubeBase pSSysBICubeBase) throws Exception {
        return this.selectByPSSysBICube(pSSysBICubeBase, "", -1);
    }

    public ArrayList<PSSysBIReportItem> selectByPSSysBICube(PSSysBICubeBase pSSysBICubeBase, String string) throws Exception {
        return this.selectByPSSysBICube(pSSysBICubeBase, string, -1);
    }

    public ArrayList<PSSysBIReportItem> selectByPSSysBICube(PSSysBICubeBase pSSysBICubeBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysBIReportItem> selectByPPSSysBIReportItem(PSSysBIReportItemBase pSSysBIReportItemBase) throws Exception {
        return this.selectByPPSSysBIReportItem(pSSysBIReportItemBase, "", -1);
    }

    public ArrayList<PSSysBIReportItem> selectByPPSSysBIReportItem(PSSysBIReportItemBase pSSysBIReportItemBase, String string) throws Exception {
        return this.selectByPPSSysBIReportItem(pSSysBIReportItemBase, string, -1);
    }

    public ArrayList<PSSysBIReportItem> selectByPPSSysBIReportItem(PSSysBIReportItemBase pSSysBIReportItemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSSYSBIREPORTITEMID", (Object)pSSysBIReportItemBase.getPSSysBIReportItemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSSysBIReportItemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSSysBIReportItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBIReportItem> selectByPSSysBIReport(PSSysBIReportBase pSSysBIReportBase) throws Exception {
        return this.selectByPSSysBIReport(pSSysBIReportBase, "", -1);
    }

    public ArrayList<PSSysBIReportItem> selectByPSSysBIReport(PSSysBIReportBase pSSysBIReportBase, String string) throws Exception {
        return this.selectByPSSysBIReport(pSSysBIReportBase, string, -1);
    }

    public ArrayList<PSSysBIReportItem> selectByPSSysBIReport(PSSysBIReportBase pSSysBIReportBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSBIREPORTID", (Object)pSSysBIReportBase.getPSSysBIReportId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysBIReportCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysBIReportCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBIReportItem> selectTempByPSSysBIReport(PSSysBIReportBase pSSysBIReportBase) throws Exception {
        return this.selectTempByPSSysBIReport(pSSysBIReportBase, "");
    }

    public ArrayList<PSSysBIReportItem> selectTempByPSSysBIReport(PSSysBIReportBase pSSysBIReportBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSBIREPORTID", (Object)pSSysBIReportBase.getPSSysBIReportId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSSysBIReportCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSSysBIReportCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSysBICubeDimension(PSSysBICubeDimension pSSysBICubeDimension) throws Exception {
        ArrayList<PSSysBIReportItem> arrayList = this.selectByPSSysBICubeDimension(pSSysBICubeDimension, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSBICUBEDIMENSION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysBICubeDimension);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBIREPORTITEM_PSSYSBICUBEDIMENSION_PSSYSBICUBEDIMENSIONID", "", iDataEntityModel.getName(), "PSSYSBIREPORTITEM", iDataEntityModel.getDataInfo(pSSysBICubeDimension), arrayList.get(0)));
        }
    }

    public void resetPSSysBICubeDimension(PSSysBICubeDimension pSSysBICubeDimension) throws Exception {
        ArrayList<PSSysBIReportItem> arrayList = this.selectByPSSysBICubeDimension(pSSysBICubeDimension);
        for (PSSysBIReportItem pSSysBIReportItem : arrayList) {
            PSSysBIReportItem pSSysBIReportItem2 = (PSSysBIReportItem)this.getDEModel().createEntity();
            pSSysBIReportItem2.setPSSysBIReportItemId(pSSysBIReportItem.getPSSysBIReportItemId());
            pSSysBIReportItem2.setPSSysBICubeDimensionId(null);
            this.update(pSSysBIReportItem2);
        }
    }

    public void removeByPSSysBICubeDimension(PSSysBICubeDimension pSSysBICubeDimension) throws Exception {
        final PSSysBICubeDimension pSSysBICubeDimension2 = pSSysBICubeDimension;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBIReportItemServiceBase.this.onBeforeRemoveByPSSysBICubeDimension(pSSysBICubeDimension2);
                PSSysBIReportItemServiceBase.this.internalRemoveByPSSysBICubeDimension(pSSysBICubeDimension2);
                PSSysBIReportItemServiceBase.this.onAfterRemoveByPSSysBICubeDimension(pSSysBICubeDimension2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBICubeDimension(PSSysBICubeDimension pSSysBICubeDimension) throws Exception {
    }

    protected void internalRemoveByPSSysBICubeDimension(PSSysBICubeDimension pSSysBICubeDimension) throws Exception {
        ArrayList<PSSysBIReportItem> arrayList = this.selectByPSSysBICubeDimension(pSSysBICubeDimension);
        this.onBeforeRemoveByPSSysBICubeDimension(pSSysBICubeDimension, arrayList);
        for (PSSysBIReportItem pSSysBIReportItem : arrayList) {
            this.remove(pSSysBIReportItem);
        }
        this.onAfterRemoveByPSSysBICubeDimension(pSSysBICubeDimension, arrayList);
    }

    protected void onAfterRemoveByPSSysBICubeDimension(PSSysBICubeDimension pSSysBICubeDimension) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBICubeDimension(PSSysBICubeDimension pSSysBICubeDimension, ArrayList<PSSysBIReportItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBICubeDimension(PSSysBICubeDimension pSSysBICubeDimension, ArrayList<PSSysBIReportItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysBICubeLevel(PSSysBICubeLevel pSSysBICubeLevel) throws Exception {
        ArrayList<PSSysBIReportItem> arrayList = this.selectByPSSysBICubeLevel(pSSysBICubeLevel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSBICUBELEVEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysBICubeLevel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBIREPORTITEM_PSSYSBICUBELEVEL_PSSYSBICUBELEVELID", "", iDataEntityModel.getName(), "PSSYSBIREPORTITEM", iDataEntityModel.getDataInfo(pSSysBICubeLevel), arrayList.get(0)));
        }
    }

    public void resetPSSysBICubeLevel(PSSysBICubeLevel pSSysBICubeLevel) throws Exception {
        ArrayList<PSSysBIReportItem> arrayList = this.selectByPSSysBICubeLevel(pSSysBICubeLevel);
        for (PSSysBIReportItem pSSysBIReportItem : arrayList) {
            PSSysBIReportItem pSSysBIReportItem2 = (PSSysBIReportItem)this.getDEModel().createEntity();
            pSSysBIReportItem2.setPSSysBIReportItemId(pSSysBIReportItem.getPSSysBIReportItemId());
            pSSysBIReportItem2.setPSSysBICubeLevelId(null);
            this.update(pSSysBIReportItem2);
        }
    }

    public void removeByPSSysBICubeLevel(PSSysBICubeLevel pSSysBICubeLevel) throws Exception {
        final PSSysBICubeLevel pSSysBICubeLevel2 = pSSysBICubeLevel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBIReportItemServiceBase.this.onBeforeRemoveByPSSysBICubeLevel(pSSysBICubeLevel2);
                PSSysBIReportItemServiceBase.this.internalRemoveByPSSysBICubeLevel(pSSysBICubeLevel2);
                PSSysBIReportItemServiceBase.this.onAfterRemoveByPSSysBICubeLevel(pSSysBICubeLevel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBICubeLevel(PSSysBICubeLevel pSSysBICubeLevel) throws Exception {
    }

    protected void internalRemoveByPSSysBICubeLevel(PSSysBICubeLevel pSSysBICubeLevel) throws Exception {
        ArrayList<PSSysBIReportItem> arrayList = this.selectByPSSysBICubeLevel(pSSysBICubeLevel);
        this.onBeforeRemoveByPSSysBICubeLevel(pSSysBICubeLevel, arrayList);
        for (PSSysBIReportItem pSSysBIReportItem : arrayList) {
            this.remove(pSSysBIReportItem);
        }
        this.onAfterRemoveByPSSysBICubeLevel(pSSysBICubeLevel, arrayList);
    }

    protected void onAfterRemoveByPSSysBICubeLevel(PSSysBICubeLevel pSSysBICubeLevel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBICubeLevel(PSSysBICubeLevel pSSysBICubeLevel, ArrayList<PSSysBIReportItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBICubeLevel(PSSysBICubeLevel pSSysBICubeLevel, ArrayList<PSSysBIReportItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysBICubeMeasure(PSSysBICubeMeasure pSSysBICubeMeasure) throws Exception {
        ArrayList<PSSysBIReportItem> arrayList = this.selectByPSSysBICubeMeasure(pSSysBICubeMeasure, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSBICUBEMEASURE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysBICubeMeasure);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBIREPORTITEM_PSSYSBICUBEMEASURE_PSSYSBICUBEMEASUREID", "", iDataEntityModel.getName(), "PSSYSBIREPORTITEM", iDataEntityModel.getDataInfo(pSSysBICubeMeasure), arrayList.get(0)));
        }
    }

    public void resetPSSysBICubeMeasure(PSSysBICubeMeasure pSSysBICubeMeasure) throws Exception {
        ArrayList<PSSysBIReportItem> arrayList = this.selectByPSSysBICubeMeasure(pSSysBICubeMeasure);
        for (PSSysBIReportItem pSSysBIReportItem : arrayList) {
            PSSysBIReportItem pSSysBIReportItem2 = (PSSysBIReportItem)this.getDEModel().createEntity();
            pSSysBIReportItem2.setPSSysBIReportItemId(pSSysBIReportItem.getPSSysBIReportItemId());
            pSSysBIReportItem2.setPSSysBICubeMeasureId(null);
            this.update(pSSysBIReportItem2);
        }
    }

    public void removeByPSSysBICubeMeasure(PSSysBICubeMeasure pSSysBICubeMeasure) throws Exception {
        final PSSysBICubeMeasure pSSysBICubeMeasure2 = pSSysBICubeMeasure;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBIReportItemServiceBase.this.onBeforeRemoveByPSSysBICubeMeasure(pSSysBICubeMeasure2);
                PSSysBIReportItemServiceBase.this.internalRemoveByPSSysBICubeMeasure(pSSysBICubeMeasure2);
                PSSysBIReportItemServiceBase.this.onAfterRemoveByPSSysBICubeMeasure(pSSysBICubeMeasure2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBICubeMeasure(PSSysBICubeMeasure pSSysBICubeMeasure) throws Exception {
    }

    protected void internalRemoveByPSSysBICubeMeasure(PSSysBICubeMeasure pSSysBICubeMeasure) throws Exception {
        ArrayList<PSSysBIReportItem> arrayList = this.selectByPSSysBICubeMeasure(pSSysBICubeMeasure);
        this.onBeforeRemoveByPSSysBICubeMeasure(pSSysBICubeMeasure, arrayList);
        for (PSSysBIReportItem pSSysBIReportItem : arrayList) {
            this.remove(pSSysBIReportItem);
        }
        this.onAfterRemoveByPSSysBICubeMeasure(pSSysBICubeMeasure, arrayList);
    }

    protected void onAfterRemoveByPSSysBICubeMeasure(PSSysBICubeMeasure pSSysBICubeMeasure) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBICubeMeasure(PSSysBICubeMeasure pSSysBICubeMeasure, ArrayList<PSSysBIReportItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBICubeMeasure(PSSysBICubeMeasure pSSysBICubeMeasure, ArrayList<PSSysBIReportItem> arrayList) throws Exception {
    }

    public void testRemoveByRefPSSysBICubeMeasure(PSSysBICubeMeasure pSSysBICubeMeasure) throws Exception {
        ArrayList<PSSysBIReportItem> arrayList = this.selectByRefPSSysBICubeMeasure(pSSysBICubeMeasure, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSBICUBEMEASURE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysBICubeMeasure);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBIREPORTITEM_PSSYSBICUBEMEASURE_REFPSSYSBICUBEMEASUREID", "", iDataEntityModel.getName(), "PSSYSBIREPORTITEM", iDataEntityModel.getDataInfo(pSSysBICubeMeasure), arrayList.get(0)));
        }
    }

    public void resetRefPSSysBICubeMeasure(PSSysBICubeMeasure pSSysBICubeMeasure) throws Exception {
        ArrayList<PSSysBIReportItem> arrayList = this.selectByRefPSSysBICubeMeasure(pSSysBICubeMeasure);
        for (PSSysBIReportItem pSSysBIReportItem : arrayList) {
            PSSysBIReportItem pSSysBIReportItem2 = (PSSysBIReportItem)this.getDEModel().createEntity();
            pSSysBIReportItem2.setPSSysBIReportItemId(pSSysBIReportItem.getPSSysBIReportItemId());
            pSSysBIReportItem2.setRefPSSysBICubeMeasureId(null);
            this.update(pSSysBIReportItem2);
        }
    }

    public void removeByRefPSSysBICubeMeasure(PSSysBICubeMeasure pSSysBICubeMeasure) throws Exception {
        final PSSysBICubeMeasure pSSysBICubeMeasure2 = pSSysBICubeMeasure;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBIReportItemServiceBase.this.onBeforeRemoveByRefPSSysBICubeMeasure(pSSysBICubeMeasure2);
                PSSysBIReportItemServiceBase.this.internalRemoveByRefPSSysBICubeMeasure(pSSysBICubeMeasure2);
                PSSysBIReportItemServiceBase.this.onAfterRemoveByRefPSSysBICubeMeasure(pSSysBICubeMeasure2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSSysBICubeMeasure(PSSysBICubeMeasure pSSysBICubeMeasure) throws Exception {
    }

    protected void internalRemoveByRefPSSysBICubeMeasure(PSSysBICubeMeasure pSSysBICubeMeasure) throws Exception {
        ArrayList<PSSysBIReportItem> arrayList = this.selectByRefPSSysBICubeMeasure(pSSysBICubeMeasure);
        this.onBeforeRemoveByRefPSSysBICubeMeasure(pSSysBICubeMeasure, arrayList);
        for (PSSysBIReportItem pSSysBIReportItem : arrayList) {
            this.remove(pSSysBIReportItem);
        }
        this.onAfterRemoveByRefPSSysBICubeMeasure(pSSysBICubeMeasure, arrayList);
    }

    protected void onAfterRemoveByRefPSSysBICubeMeasure(PSSysBICubeMeasure pSSysBICubeMeasure) throws Exception {
    }

    protected void onBeforeRemoveByRefPSSysBICubeMeasure(PSSysBICubeMeasure pSSysBICubeMeasure, ArrayList<PSSysBIReportItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSSysBICubeMeasure(PSSysBICubeMeasure pSSysBICubeMeasure, ArrayList<PSSysBIReportItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysBICube(PSSysBICube pSSysBICube) throws Exception {
        ArrayList<PSSysBIReportItem> arrayList = this.selectByPSSysBICube(pSSysBICube, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSBICUBE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysBICube);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBIREPORTITEM_PSSYSBICUBE_PSSYSBICUBEID", "", iDataEntityModel.getName(), "PSSYSBIREPORTITEM", iDataEntityModel.getDataInfo(pSSysBICube), arrayList.get(0)));
        }
    }

    public void resetPSSysBICube(PSSysBICube pSSysBICube) throws Exception {
        ArrayList<PSSysBIReportItem> arrayList = this.selectByPSSysBICube(pSSysBICube);
        for (PSSysBIReportItem pSSysBIReportItem : arrayList) {
            PSSysBIReportItem pSSysBIReportItem2 = (PSSysBIReportItem)this.getDEModel().createEntity();
            pSSysBIReportItem2.setPSSysBIReportItemId(pSSysBIReportItem.getPSSysBIReportItemId());
            pSSysBIReportItem2.setPSSysBICubeId(null);
            this.update(pSSysBIReportItem2);
        }
    }

    public void removeByPSSysBICube(PSSysBICube pSSysBICube) throws Exception {
        final PSSysBICube pSSysBICube2 = pSSysBICube;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBIReportItemServiceBase.this.onBeforeRemoveByPSSysBICube(pSSysBICube2);
                PSSysBIReportItemServiceBase.this.internalRemoveByPSSysBICube(pSSysBICube2);
                PSSysBIReportItemServiceBase.this.onAfterRemoveByPSSysBICube(pSSysBICube2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBICube(PSSysBICube pSSysBICube) throws Exception {
    }

    protected void internalRemoveByPSSysBICube(PSSysBICube pSSysBICube) throws Exception {
        ArrayList<PSSysBIReportItem> arrayList = this.selectByPSSysBICube(pSSysBICube);
        this.onBeforeRemoveByPSSysBICube(pSSysBICube, arrayList);
        for (PSSysBIReportItem pSSysBIReportItem : arrayList) {
            this.remove(pSSysBIReportItem);
        }
        this.onAfterRemoveByPSSysBICube(pSSysBICube, arrayList);
    }

    protected void onAfterRemoveByPSSysBICube(PSSysBICube pSSysBICube) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBICube(PSSysBICube pSSysBICube, ArrayList<PSSysBIReportItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBICube(PSSysBICube pSSysBICube, ArrayList<PSSysBIReportItem> arrayList) throws Exception {
    }

    public void testRemoveByPPSSysBIReportItem(PSSysBIReportItem pSSysBIReportItem) throws Exception {
        ArrayList<PSSysBIReportItem> arrayList = this.selectByPPSSysBIReportItem(pSSysBIReportItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSBIREPORTITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysBIReportItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBIREPORTITEM_PSSYSBIREPORTITEM_PPSSYSBIREPORTITEMID", "", iDataEntityModel.getName(), "PSSYSBIREPORTITEM", iDataEntityModel.getDataInfo(pSSysBIReportItem), arrayList.get(0)));
        }
    }

    public void resetPPSSysBIReportItem(PSSysBIReportItem pSSysBIReportItem) throws Exception {
        ArrayList<PSSysBIReportItem> arrayList = this.selectByPPSSysBIReportItem(pSSysBIReportItem);
        for (PSSysBIReportItem pSSysBIReportItem2 : arrayList) {
            PSSysBIReportItem pSSysBIReportItem3 = (PSSysBIReportItem)this.getDEModel().createEntity();
            pSSysBIReportItem3.setPSSysBIReportItemId(pSSysBIReportItem2.getPSSysBIReportItemId());
            pSSysBIReportItem3.setPPSSysBIReportItemId(null);
            this.update(pSSysBIReportItem3);
        }
    }

    public void removeByPPSSysBIReportItem(PSSysBIReportItem pSSysBIReportItem) throws Exception {
        final PSSysBIReportItem pSSysBIReportItem2 = pSSysBIReportItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBIReportItemServiceBase.this.onBeforeRemoveByPPSSysBIReportItem(pSSysBIReportItem2);
                PSSysBIReportItemServiceBase.this.internalRemoveByPPSSysBIReportItem(pSSysBIReportItem2);
                PSSysBIReportItemServiceBase.this.onAfterRemoveByPPSSysBIReportItem(pSSysBIReportItem2);
            }
        });
    }

    protected void onBeforeRemoveByPPSSysBIReportItem(PSSysBIReportItem pSSysBIReportItem) throws Exception {
    }

    protected void internalRemoveByPPSSysBIReportItem(PSSysBIReportItem pSSysBIReportItem) throws Exception {
        ArrayList<PSSysBIReportItem> arrayList = this.selectByPPSSysBIReportItem(pSSysBIReportItem);
        this.onBeforeRemoveByPPSSysBIReportItem(pSSysBIReportItem, arrayList);
        for (PSSysBIReportItem pSSysBIReportItem2 : arrayList) {
            this.remove(pSSysBIReportItem2);
        }
        this.onAfterRemoveByPPSSysBIReportItem(pSSysBIReportItem, arrayList);
    }

    protected void onAfterRemoveByPPSSysBIReportItem(PSSysBIReportItem pSSysBIReportItem) throws Exception {
    }

    protected void onBeforeRemoveByPPSSysBIReportItem(PSSysBIReportItem pSSysBIReportItem, ArrayList<PSSysBIReportItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSSysBIReportItem(PSSysBIReportItem pSSysBIReportItem, ArrayList<PSSysBIReportItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysBIReport(PSSysBIReport pSSysBIReport) throws Exception {
    }

    public void resetPSSysBIReport(PSSysBIReport pSSysBIReport) throws Exception {
        ArrayList<PSSysBIReportItem> arrayList = this.selectByPSSysBIReport(pSSysBIReport);
        for (PSSysBIReportItem pSSysBIReportItem : arrayList) {
            PSSysBIReportItem pSSysBIReportItem2 = (PSSysBIReportItem)this.getDEModel().createEntity();
            pSSysBIReportItem2.setPSSysBIReportItemId(pSSysBIReportItem.getPSSysBIReportItemId());
            pSSysBIReportItem2.setPSSysBIReportId(null);
            this.update(pSSysBIReportItem2);
        }
    }

    public void resetTempPSSysBIReport(PSSysBIReport pSSysBIReport) throws Exception {
        ArrayList<PSSysBIReportItem> arrayList = this.selectTempByPSSysBIReport(pSSysBIReport);
        for (PSSysBIReportItem pSSysBIReportItem : arrayList) {
            PSSysBIReportItem pSSysBIReportItem2 = (PSSysBIReportItem)this.getDEModel().createEntity();
            pSSysBIReportItem2.setPSSysBIReportItemId(pSSysBIReportItem.getPSSysBIReportItemId());
            pSSysBIReportItem2.setPSSysBIReportId(null);
            this.updateTemp(pSSysBIReportItem2);
        }
    }

    public void removeByPSSysBIReport(PSSysBIReport pSSysBIReport) throws Exception {
        final PSSysBIReport pSSysBIReport2 = pSSysBIReport;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBIReportItemServiceBase.this.onBeforeRemoveByPSSysBIReport(pSSysBIReport2);
                PSSysBIReportItemServiceBase.this.internalRemoveByPSSysBIReport(pSSysBIReport2);
                PSSysBIReportItemServiceBase.this.onAfterRemoveByPSSysBIReport(pSSysBIReport2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBIReport(PSSysBIReport pSSysBIReport) throws Exception {
    }

    protected void internalRemoveByPSSysBIReport(PSSysBIReport pSSysBIReport) throws Exception {
        ArrayList<PSSysBIReportItem> arrayList = this.selectByPSSysBIReport(pSSysBIReport);
        this.onBeforeRemoveByPSSysBIReport(pSSysBIReport, arrayList);
        for (PSSysBIReportItem pSSysBIReportItem : arrayList) {
            this.remove(pSSysBIReportItem);
        }
        this.onAfterRemoveByPSSysBIReport(pSSysBIReport, arrayList);
    }

    protected void onAfterRemoveByPSSysBIReport(PSSysBIReport pSSysBIReport) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBIReport(PSSysBIReport pSSysBIReport, ArrayList<PSSysBIReportItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBIReport(PSSysBIReport pSSysBIReport, ArrayList<PSSysBIReportItem> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysBIReportItem pSSysBIReportItem) throws Exception {
        PSSysBIReportItemService pSSysBIReportItemService = (PSSysBIReportItemService)ServiceGlobal.getService(PSSysBIReportItemService.class, (SessionFactory)this.getSessionFactory());
        pSSysBIReportItemService.testRemoveByPPSSysBIReportItem(pSSysBIReportItem);
        super.onBeforeRemove(pSSysBIReportItem);
    }

    public void removeTempByPSSysBIReport(PSSysBIReport pSSysBIReport) throws Exception {
        final PSSysBIReport pSSysBIReport2 = pSSysBIReport;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBIReportItemServiceBase.this.onBeforeRemoveTempByPSSysBIReport(pSSysBIReport2);
                PSSysBIReportItemServiceBase.this.internalRemoveTempByPSSysBIReport(pSSysBIReport2);
                PSSysBIReportItemServiceBase.this.onAfterRemoveTempByPSSysBIReport(pSSysBIReport2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSSysBIReport(PSSysBIReport pSSysBIReport) throws Exception {
    }

    protected void internalRemoveTempByPSSysBIReport(PSSysBIReport pSSysBIReport) throws Exception {
        ArrayList<PSSysBIReportItem> arrayList = this.selectTempByPSSysBIReport(pSSysBIReport);
        this.onBeforeRemoveTempByPSSysBIReport(pSSysBIReport, arrayList);
        for (PSSysBIReportItem pSSysBIReportItem : arrayList) {
            this.removeTemp(pSSysBIReportItem);
        }
        this.onAfterRemoveTempByPSSysBIReport(pSSysBIReport, arrayList);
    }

    protected void onAfterRemoveTempByPSSysBIReport(PSSysBIReport pSSysBIReport) throws Exception {
    }

    protected void onBeforeRemoveTempByPSSysBIReport(PSSysBIReport pSSysBIReport, ArrayList<PSSysBIReportItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSSysBIReport(PSSysBIReport pSSysBIReport, ArrayList<PSSysBIReportItem> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSSysBIReportItem pSSysBIReportItem, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysBIReportItem, cloneSession);
        if (pSSysBIReportItem.getPSSysBICubeDimensionId() != null && (iEntity = cloneSession.getEntity("PSSYSBICUBEDIMENSION", (Object)pSSysBIReportItem.getPSSysBICubeDimensionId())) != null) {
            this.onFillParentInfo_PSSysBICubeDimension(pSSysBIReportItem, (PSSysBICubeDimension)iEntity);
        }
        if (pSSysBIReportItem.getPSSysBICubeLevelId() != null && (iEntity = cloneSession.getEntity("PSSYSBICUBELEVEL", (Object)pSSysBIReportItem.getPSSysBICubeLevelId())) != null) {
            this.onFillParentInfo_PSSysBICubeLevel(pSSysBIReportItem, (PSSysBICubeLevel)iEntity);
        }
        if (pSSysBIReportItem.getPSSysBICubeMeasureId() != null && (iEntity = cloneSession.getEntity("PSSYSBICUBEMEASURE", (Object)pSSysBIReportItem.getPSSysBICubeMeasureId())) != null) {
            this.onFillParentInfo_PSSysBICubeMeasure(pSSysBIReportItem, (PSSysBICubeMeasure)iEntity);
        }
        if (pSSysBIReportItem.getRefPSSysBICubeMeasureId() != null && (iEntity = cloneSession.getEntity("PSSYSBICUBEMEASURE", (Object)pSSysBIReportItem.getRefPSSysBICubeMeasureId())) != null) {
            this.onFillParentInfo_RefPSSysBICubeMeasure(pSSysBIReportItem, (PSSysBICubeMeasure)iEntity);
        }
        if (pSSysBIReportItem.getPSSysBICubeId() != null && (iEntity = cloneSession.getEntity("PSSYSBICUBE", (Object)pSSysBIReportItem.getPSSysBICubeId())) != null) {
            this.onFillParentInfo_PSSysBICube(pSSysBIReportItem, (PSSysBICube)iEntity);
        }
        if (pSSysBIReportItem.getPPSSysBIReportItemId() != null && (iEntity = cloneSession.getEntity("PSSYSBIREPORTITEM", (Object)pSSysBIReportItem.getPPSSysBIReportItemId())) != null) {
            this.onFillParentInfo_PPSSysBIReportItem(pSSysBIReportItem, (PSSysBIReportItem)iEntity);
        }
        if (pSSysBIReportItem.getPSSysBIReportId() != null && (iEntity = cloneSession.getEntity("PSSYSBIREPORT", (Object)pSSysBIReportItem.getPSSysBIReportId())) != null) {
            this.onFillParentInfo_PSSysBIReport(pSSysBIReportItem, (PSSysBIReport)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysBIReportItem pSSysBIReportItem, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysBIReportItem, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysBIReportItem pSSysBIReportItem, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AggType(bl, pSSysBIReportItem, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BIRepItemParams(bl, pSSysBIReportItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BIRepItemTag(bl, pSSysBIReportItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BIRepItemTag2(bl, pSSysBIReportItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BIRepItemType(bl, pSSysBIReportItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSysBIReportItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Data(bl, pSSysBIReportItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HAlign(bl, pSSysBIReportItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysBIReportItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysBIReportItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Placement(bl, pSSysBIReportItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PlaceType(bl, pSSysBIReportItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSSysBIReportItemId(bl, pSSysBIReportItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBICubeDimensionId(bl, pSSysBIReportItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBICubeId(bl, pSSysBIReportItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBICubeLevelId(bl, pSSysBIReportItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBICubeMeasureId(bl, pSSysBIReportItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBIReportId(bl, pSSysBIReportItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBIReportItemId(bl, pSSysBIReportItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBIReportItemName(bl, pSSysBIReportItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSSysBICubeMeasureId(bl, pSSysBIReportItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefType(bl, pSSysBIReportItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysBIReportItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysBIReportItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysBIReportItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysBIReportItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysBIReportItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysBIReportItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VAlign(bl, pSSysBIReportItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValueFormat(bl, pSSysBIReportItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Width(bl, pSSysBIReportItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WidthUnit(bl, pSSysBIReportItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysBIReportItem, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AggType(boolean bl, PSSysBIReportItem pSSysBIReportItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReportItem.isAggTypeDirty() : !pSSysBIReportItem.isAggTypeDirty()) {
            return null;
        }
        String string = pSSysBIReportItem.getAggType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AggType_Default(pSSysBIReportItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_BIRepItemParams(boolean bl, PSSysBIReportItem pSSysBIReportItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReportItem.isBIRepItemParamsDirty() : !pSSysBIReportItem.isBIRepItemParamsDirty()) {
            return null;
        }
        String string = pSSysBIReportItem.getBIRepItemParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BIRepItemParams_Default(pSSysBIReportItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BIREPITEMPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BIRepItemTag(boolean bl, PSSysBIReportItem pSSysBIReportItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReportItem.isBIRepItemTagDirty() : !pSSysBIReportItem.isBIRepItemTagDirty()) {
            return null;
        }
        String string = pSSysBIReportItem.getBIRepItemTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BIRepItemTag_Default(pSSysBIReportItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BIREPITEMTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BIRepItemTag2(boolean bl, PSSysBIReportItem pSSysBIReportItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReportItem.isBIRepItemTag2Dirty() : !pSSysBIReportItem.isBIRepItemTag2Dirty()) {
            return null;
        }
        String string = pSSysBIReportItem.getBIRepItemTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BIRepItemTag2_Default(pSSysBIReportItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BIREPITEMTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BIRepItemType(boolean bl, PSSysBIReportItem pSSysBIReportItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReportItem.isBIRepItemTypeDirty() && !bl2 : !pSSysBIReportItem.isBIRepItemTypeDirty()) {
            return null;
        }
        String string = pSSysBIReportItem.getBIRepItemType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BIREPITEMTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_BIRepItemType_Default(pSSysBIReportItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BIREPITEMTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysBIReportItem pSSysBIReportItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReportItem.isCodeNameDirty() : !pSSysBIReportItem.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysBIReportItem.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSysBIReportItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Data(boolean bl, PSSysBIReportItem pSSysBIReportItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReportItem.isDataDirty() : !pSSysBIReportItem.isDataDirty()) {
            return null;
        }
        String string = pSSysBIReportItem.getData();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Data_Default(pSSysBIReportItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATA");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HAlign(boolean bl, PSSysBIReportItem pSSysBIReportItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReportItem.isHAlignDirty() : !pSSysBIReportItem.isHAlignDirty()) {
            return null;
        }
        String string = pSSysBIReportItem.getHAlign();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HAlign_Default(pSSysBIReportItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HALIGN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysBIReportItem pSSysBIReportItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReportItem.isMemoDirty() : !pSSysBIReportItem.isMemoDirty()) {
            return null;
        }
        String string = pSSysBIReportItem.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysBIReportItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysBIReportItem pSSysBIReportItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReportItem.isOrderValueDirty() : !pSSysBIReportItem.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysBIReportItem.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSSysBIReportItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_Placement(boolean bl, PSSysBIReportItem pSSysBIReportItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReportItem.isPlacementDirty() : !pSSysBIReportItem.isPlacementDirty()) {
            return null;
        }
        String string = pSSysBIReportItem.getPlacement();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Placement_Default(pSSysBIReportItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PLACEMENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PlaceType(boolean bl, PSSysBIReportItem pSSysBIReportItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReportItem.isPlaceTypeDirty() : !pSSysBIReportItem.isPlaceTypeDirty()) {
            return null;
        }
        String string = pSSysBIReportItem.getPlaceType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PlaceType_Default(pSSysBIReportItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PLACETYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPSSysBIReportItemId(boolean bl, PSSysBIReportItem pSSysBIReportItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReportItem.isPPSSysBIReportItemIdDirty() : !pSSysBIReportItem.isPPSSysBIReportItemIdDirty()) {
            return null;
        }
        String string = pSSysBIReportItem.getPPSSysBIReportItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSSysBIReportItemId_Default(pSSysBIReportItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSSYSBIREPORTITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBICubeDimensionId(boolean bl, PSSysBIReportItem pSSysBIReportItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReportItem.isPSSysBICubeDimensionIdDirty() : !pSSysBIReportItem.isPSSysBICubeDimensionIdDirty()) {
            return null;
        }
        String string = pSSysBIReportItem.getPSSysBICubeDimensionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBICubeDimensionId_Default(pSSysBIReportItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysBICubeId(boolean bl, PSSysBIReportItem pSSysBIReportItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReportItem.isPSSysBICubeIdDirty() : !pSSysBIReportItem.isPSSysBICubeIdDirty()) {
            return null;
        }
        String string = pSSysBIReportItem.getPSSysBICubeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBICubeId_Default(pSSysBIReportItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysBICubeLevelId(boolean bl, PSSysBIReportItem pSSysBIReportItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReportItem.isPSSysBICubeLevelIdDirty() : !pSSysBIReportItem.isPSSysBICubeLevelIdDirty()) {
            return null;
        }
        String string = pSSysBIReportItem.getPSSysBICubeLevelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBICubeLevelId_Default(pSSysBIReportItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysBICubeMeasureId(boolean bl, PSSysBIReportItem pSSysBIReportItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReportItem.isPSSysBICubeMeasureIdDirty() : !pSSysBIReportItem.isPSSysBICubeMeasureIdDirty()) {
            return null;
        }
        String string = pSSysBIReportItem.getPSSysBICubeMeasureId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBICubeMeasureId_Default(pSSysBIReportItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysBIReportId(boolean bl, PSSysBIReportItem pSSysBIReportItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReportItem.isPSSysBIReportIdDirty() : !pSSysBIReportItem.isPSSysBIReportIdDirty()) {
            return null;
        }
        String string = pSSysBIReportItem.getPSSysBIReportId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBIReportId_Default(pSSysBIReportItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBIREPORTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBIReportItemId(boolean bl, PSSysBIReportItem pSSysBIReportItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReportItem.isPSSysBIReportItemIdDirty() && !bl2 : !pSSysBIReportItem.isPSSysBIReportItemIdDirty()) {
            return null;
        }
        String string = pSSysBIReportItem.getPSSysBIReportItemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBIREPORTITEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBIReportItemId_Default(pSSysBIReportItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBIREPORTITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBIReportItemName(boolean bl, PSSysBIReportItem pSSysBIReportItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReportItem.isPSSysBIReportItemNameDirty() && !bl2 : !pSSysBIReportItem.isPSSysBIReportItemNameDirty()) {
            return null;
        }
        String string = pSSysBIReportItem.getPSSysBIReportItemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBIREPORTITEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBIReportItemName_Default(pSSysBIReportItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBIREPORTITEMNAME");
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
                string3 = "PSSYSBIREPORTID";
                String string4 = this.checkFieldDupRule(this.getPSSysBIReportItemDEModel(), "PSSYSBIREPORTITEMNAME", string3, pSSysBIReportItem, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSBIREPORTITEMNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSSysBICubeMeasureId(boolean bl, PSSysBIReportItem pSSysBIReportItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReportItem.isRefPSSysBICubeMeasureIdDirty() : !pSSysBIReportItem.isRefPSSysBICubeMeasureIdDirty()) {
            return null;
        }
        String string = pSSysBIReportItem.getRefPSSysBICubeMeasureId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSSysBICubeMeasureId_Default(pSSysBIReportItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSSYSBICUBEMEASUREID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefType(boolean bl, PSSysBIReportItem pSSysBIReportItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReportItem.isRefTypeDirty() : !pSSysBIReportItem.isRefTypeDirty()) {
            return null;
        }
        String string = pSSysBIReportItem.getRefType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefType_Default(pSSysBIReportItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysBIReportItem pSSysBIReportItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReportItem.isUserCatDirty() : !pSSysBIReportItem.isUserCatDirty()) {
            return null;
        }
        String string = pSSysBIReportItem.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysBIReportItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysBIReportItem pSSysBIReportItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReportItem.isUserTagDirty() : !pSSysBIReportItem.isUserTagDirty()) {
            return null;
        }
        String string = pSSysBIReportItem.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysBIReportItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysBIReportItem pSSysBIReportItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReportItem.isUserTag2Dirty() : !pSSysBIReportItem.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysBIReportItem.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysBIReportItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysBIReportItem pSSysBIReportItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReportItem.isUserTag3Dirty() : !pSSysBIReportItem.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysBIReportItem.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysBIReportItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysBIReportItem pSSysBIReportItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReportItem.isUserTag4Dirty() : !pSSysBIReportItem.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysBIReportItem.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysBIReportItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysBIReportItem pSSysBIReportItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReportItem.isValidFlagDirty() && !bl2 : !pSSysBIReportItem.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysBIReportItem.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSysBIReportItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_VAlign(boolean bl, PSSysBIReportItem pSSysBIReportItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReportItem.isVAlignDirty() : !pSSysBIReportItem.isVAlignDirty()) {
            return null;
        }
        String string = pSSysBIReportItem.getVAlign();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VAlign_Default(pSSysBIReportItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIGN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValueFormat(boolean bl, PSSysBIReportItem pSSysBIReportItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReportItem.isValueFormatDirty() : !pSSysBIReportItem.isValueFormatDirty()) {
            return null;
        }
        String string = pSSysBIReportItem.getValueFormat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ValueFormat_Default(pSSysBIReportItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_Width(boolean bl, PSSysBIReportItem pSSysBIReportItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReportItem.isWidthDirty() : !pSSysBIReportItem.isWidthDirty()) {
            return null;
        }
        Integer n = pSSysBIReportItem.getWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Width_Default(pSSysBIReportItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_WidthUnit(boolean bl, PSSysBIReportItem pSSysBIReportItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIReportItem.isWidthUnitDirty() : !pSSysBIReportItem.isWidthUnitDirty()) {
            return null;
        }
        String string = pSSysBIReportItem.getWidthUnit();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WidthUnit_Default(pSSysBIReportItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WIDTHUNIT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysBIReportItem pSSysBIReportItem, boolean bl) throws Exception {
        super.onSyncEntity(pSSysBIReportItem, bl);
    }

    protected void onSyncIndexEntities(PSSysBIReportItem pSSysBIReportItem, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysBIReportItem, bl);
    }

    public Object getDataContextValue(PSSysBIReportItem pSSysBIReportItem, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysBIReportItem, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysBIReport pSSysBIReport = pSSysBIReportItem.getPSSysBIReport();
        if (pSSysBIReport != null && pSSysBIReport.contains(string)) {
            return pSSysBIReport.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysBIReportItem pSSysBIReportItem, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysBIReportItem, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"AGGTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AggType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BIREPITEMPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BIRepItemParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BIREPITEMTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BIRepItemTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BIREPITEMTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BIRepItemTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BIREPITEMTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BIRepItemType_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"DATA", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Data_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HALIGN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HAlign_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PLACEMENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Placement_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PLACETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PlaceType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSSYSBIREPORTITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSSysBIReportItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSSYSBIREPORTITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSSysBIReportItemName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSBICUBENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBICubeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBIREPORTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBIReportId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBIREPORTITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBIReportItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBIREPORTITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBIReportItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBIREPORTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBIReportName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBISCHEMEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBISchemeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSSYSBICUBEMEASUREID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSSysBICubeMeasureId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSSYSBICUBEMEASURENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSSysBICubeMeasureName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefType_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VALIGN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VAlign_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALUEFORMAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValueFormat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Width_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WIDTHUNIT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WidthUnit_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_BIRepItemParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BIREPITEMPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BIRepItemTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BIREPITEMTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BIRepItemTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BIREPITEMTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BIRepItemType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BIREPITEMTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
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
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    protected String onTestValueRule_Data_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATA", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HAlign_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HALIGN", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Placement_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PLACEMENT", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PlaceType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PLACETYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSSysBIReportItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSSYSBIREPORTITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSSysBIReportItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSSYSBIREPORTITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysBIReportId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBIREPORTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBIReportItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBIREPORTITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBIReportItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBIREPORTITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false) && this.checkFieldRegExRule("PSSYSBIREPORTITEMNAME", iEntity, bl2, "[A-Za-z]+[\\w.]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u53ca\u70b9\u53f7\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u53ca\u70b9\u53f7\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBIReportName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBIREPORTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_RefPSSysBICubeMeasureId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSSYSBICUBEMEASUREID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSSysBICubeMeasureName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSSYSBICUBEMEASURENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected String onTestValueRule_VAlign_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VALIGN", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValueFormat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VALUEFORMAT", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Width_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_WidthUnit_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WIDTHUNIT", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysBIReportItem pSSysBIReportItem) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysBIReportItem)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysBIReportItem pSSysBIReportItem) throws Exception {
        super.onUpdateParent(pSSysBIReportItem);
    }

    @Override
    protected void exportCurXmlModel(PSSysBIReportItem pSSysBIReportItem, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSBIREPORTITEM");
        if (!bl) {
            pSSysBIReportItem.setCreateDate(null);
            pSSysBIReportItem.setCreateMan(null);
            pSSysBIReportItem.setPSSysBIReportItemId(null);
            pSSysBIReportItem.setUpdateDate(null);
            pSSysBIReportItem.setUpdateMan(null);
            pSSysBIReportItem.setPSSysBIReportId(null);
            pSSysBIReportItem.setPSSysBIReportName(null);
            pSSysBIReportItem.setPSSysBISchemeId(null);
            super.exportCurXmlModel(pSSysBIReportItem, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysBIReportItem pSSysBIReportItem, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysBIReportItem, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBIREPORTID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSBIREPORT#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBIREPORTID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSBIREPORTITEM_PSSYSBIREPORT_PSSYSBIREPORTID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBIREPORTID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBIREPORTNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSBIREPORT", (boolean)true) == 0) {
            iEntity.set("PSSYSBIREPORTID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSBIREPORTID"};
    }

    @Override
    public String getModelV2Tag(PSSysBIReportItem pSSysBIReportItem) {
        if (!StringHelper.isNullOrEmpty((String)pSSysBIReportItem.getPSSysBIReportItemName())) {
            return pSSysBIReportItem.getPSSysBIReportItemName();
        }
        return super.getModelV2Tag(pSSysBIReportItem);
    }

    @Override
    public boolean setModelV2Tag(PSSysBIReportItem pSSysBIReportItem, String string) {
        pSSysBIReportItem.setPSSysBIReportItemName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSBIREPORTITEMNAME", "");
        map.put("PSSYSBIREPORTID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysBIReportItem pSSysBIReportItem, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysBIReportItem.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysBIReportItem, true);
        pSSysBIReportItem.set("PSSYSBIREPORTITEMNAME", string);
        if (this.select(pSSysBIReportItem, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysBIReportItem, true);
        return super.getModelV2Entity(pSSysBIReportItem, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysBIReportItem pSSysBIReportItem, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysBIReportItem, objectNode, string, string2, n);
    }
}

