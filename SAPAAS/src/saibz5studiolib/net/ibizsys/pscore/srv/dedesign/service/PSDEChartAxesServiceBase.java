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
import net.ibizsys.pscore.srv.dedesign.dao.PSDEChartAxesDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEChartAxesDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEChart;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEChartAxes;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEChartBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartParamService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartParamServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEChartAxesServiceBase
extends PSCoreSysServiceBase<PSDEChartAxes> {
    private static final Log log = LogFactory.getLog(PSDEChartAxesServiceBase.class);
    public static final String DATASET_CURXAXES = "CurXAxes";
    public static final String DATASET_CURYAXES = "CurYAxes";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEChartAxesDEModel pSDEChartAxesDEModel;
    private PSDEChartAxesDAO pSDEChartAxesDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEChartAxesService";
    }

    public PSDEChartAxesDEModel getPSDEChartAxesDEModel() {
        if (this.pSDEChartAxesDEModel == null) {
            try {
                this.pSDEChartAxesDEModel = (PSDEChartAxesDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEChartAxesDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEChartAxesDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEChartAxesDEModel();
    }

    public PSDEChartAxesDAO getPSDEChartAxesDAO() {
        if (this.pSDEChartAxesDAO == null) {
            try {
                this.pSDEChartAxesDAO = (PSDEChartAxesDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEChartAxesDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEChartAxesDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEChartAxesDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURXAXES, (boolean)true) == 0) {
            return this.fetchCurXAxes(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURYAXES, (boolean)true) == 0) {
            return this.fetchCurYAxes(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURXAXES, (boolean)true) == 0) {
            return this.fetchTempCurXAxes(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURYAXES, (boolean)true) == 0) {
            return this.fetchTempCurYAxes(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurXAxes(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURXAXES, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurXAxes(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURXAXES, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurYAxes(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURYAXES, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurYAxes(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURYAXES, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, true);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDEChartAxes pSDEChartAxes, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDECHARTAXES_PSDECHART_PSDECHARTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEChartService", (SessionFactory)this.getSessionFactory());
            PSDEChart pSDEChart = (PSDEChart)iService.getDEModel().createEntity();
            pSDEChart.set("PSDECHARTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEChart);
            } else {
                iService.get(pSDEChart);
            }
            this.onFillParentInfo_PSDEChart(pSDEChartAxes, pSDEChart);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDECHARTAXES_PSLANGUAGERES_CAPPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_CapPSLanRes(pSDEChartAxes, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDECHARTAXES_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDynaModel);
            } else {
                iService.get(pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSDEChartAxes, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDECHARTAXES_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPFPlugin);
            } else {
                iService.get(pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSDEChartAxes, pSSysPFPlugin);
            return;
        }
        super.onFillParentInfo(pSDEChartAxes, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDECHARTAXES_PSDECHART_PSDECHARTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEChartService", (SessionFactory)this.getSessionFactory());
            PSDEChart pSDEChart = (PSDEChart)iService.getDEModel().createEntity();
            pSDEChart.set("PSDECHARTID", string2);
            return this.onSyncDER1NData_PSDEChart(pSDEChart, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDEChart(PSDEChartAxes pSDEChartAxes, PSDEChart pSDEChart) throws Exception {
        pSDEChartAxes.setPSDEChartId(pSDEChart.getPSDEChartId());
        pSDEChartAxes.setPSDEChartName(pSDEChart.getPSDEChartName());
        pSDEChartAxes.setPSDEId(pSDEChart.getPSDEId());
    }

    protected String onSyncDER1NData_PSDEChart(PSDEChart pSDEChart, String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.removeByPSDEChart(pSDEChart);
        } else {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            String[] stringArray = StringHelper.splitEx((String)string);
            if (stringArray != null) {
                for (int i = 0; i < stringArray.length; ++i) {
                    if (StringHelper.isNullOrEmpty((String)stringArray[i])) continue;
                    hashMap.put(stringArray[i], "");
                }
            }
            ArrayList<PSDEChartAxes> arrayList = this.selectByPSDEChart(pSDEChart);
            for (PSDEChartAxes pSDEChartAxes : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSDEChartAxes, (String)"PSDECHARTAXESID", (String)""))) continue;
                this.remove(pSDEChartAxes);
            }
        }
        return null;
    }

    protected void onFillParentInfo_CapPSLanRes(PSDEChartAxes pSDEChartAxes, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEChartAxes.setCapPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEChartAxes.setCapPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSDEChartAxes pSDEChartAxes, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSDEChartAxes.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSDEChartAxes.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSDEChartAxes pSDEChartAxes, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSDEChartAxes.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSDEChartAxes.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillEntityFullInfo(PSDEChartAxes pSDEChartAxes, boolean bl) throws Exception {
        if (bl) {
            if (pSDEChartAxes.getAxesPos() == null) {
                pSDEChartAxes.setAxesPos((String)this.getDefaultValue(this.getWebContext(), "", "left", 25));
            }
            if (pSDEChartAxes.getAxesType() == null) {
                pSDEChartAxes.setAxesType((String)this.getDefaultValue(this.getWebContext(), "", "numeric", 25));
            }
        }
        super.onFillEntityFullInfo(pSDEChartAxes, bl);
        this.onFillEntityFullInfo_PSDEChart(pSDEChartAxes, bl);
        this.onFillEntityFullInfo_CapPSLanRes(pSDEChartAxes, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSDEChartAxes, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSDEChartAxes, bl);
    }

    protected void onFillEntityFullInfo_PSDEChart(PSDEChartAxes pSDEChartAxes, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_CapPSLanRes(PSDEChartAxes pSDEChartAxes, boolean bl) throws Exception {
        if (pSDEChartAxes.isCapPSLanResIdDirty()) {
            if (pSDEChartAxes.getCapPSLanResId() != null) {
                if (pSDEChartAxes.getCapPSLanResId() == null || pSDEChartAxes.getCapPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEChartAxes.getCapPSLanRes();
                    pSDEChartAxes.setCapPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEChartAxes.setCapPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSDEChartAxes pSDEChartAxes, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSDEChartAxes pSDEChartAxes, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEChartAxes pSDEChartAxes, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEChartAxes, bl);
    }

    public ArrayList<PSDEChartAxes> selectByPSDEChart(PSDEChartBase pSDEChartBase) throws Exception {
        return this.selectByPSDEChart(pSDEChartBase, "", -1);
    }

    public ArrayList<PSDEChartAxes> selectByPSDEChart(PSDEChartBase pSDEChartBase, String string) throws Exception {
        return this.selectByPSDEChart(pSDEChartBase, string, -1);
    }

    public ArrayList<PSDEChartAxes> selectByPSDEChart(PSDEChartBase pSDEChartBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDECHARTID", (Object)pSDEChartBase.getPSDEChartId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEChartCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEChartCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEChartAxes> selectTempByPSDEChart(PSDEChartBase pSDEChartBase) throws Exception {
        return this.selectTempByPSDEChart(pSDEChartBase, "");
    }

    public ArrayList<PSDEChartAxes> selectTempByPSDEChart(PSDEChartBase pSDEChartBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDECHARTID", (Object)pSDEChartBase.getPSDEChartId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEChartCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEChartCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEChartAxes> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByCapPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEChartAxes> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByCapPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEChartAxes> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEChartAxes> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSDEChartAxes> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSDEChartAxes> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEChartAxes> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSDEChartAxes> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSDEChartAxes> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDEChart(PSDEChart pSDEChart) throws Exception {
    }

    public void resetPSDEChart(PSDEChart pSDEChart) throws Exception {
        ArrayList<PSDEChartAxes> arrayList = this.selectByPSDEChart(pSDEChart);
        for (PSDEChartAxes pSDEChartAxes : arrayList) {
            PSDEChartAxes pSDEChartAxes2 = (PSDEChartAxes)this.getDEModel().createEntity();
            pSDEChartAxes2.setPSDEChartAxesId(pSDEChartAxes.getPSDEChartAxesId());
            pSDEChartAxes2.setPSDEChartId(null);
            this.update(pSDEChartAxes2);
        }
    }

    public void resetTempPSDEChart(PSDEChart pSDEChart) throws Exception {
        ArrayList<PSDEChartAxes> arrayList = this.selectTempByPSDEChart(pSDEChart);
        for (PSDEChartAxes pSDEChartAxes : arrayList) {
            PSDEChartAxes pSDEChartAxes2 = (PSDEChartAxes)this.getDEModel().createEntity();
            pSDEChartAxes2.setPSDEChartAxesId(pSDEChartAxes.getPSDEChartAxesId());
            pSDEChartAxes2.setPSDEChartId(null);
            this.updateTemp(pSDEChartAxes2);
        }
    }

    public void removeByPSDEChart(PSDEChart pSDEChart) throws Exception {
        final PSDEChart pSDEChart2 = pSDEChart;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEChartAxesServiceBase.this.onBeforeRemoveByPSDEChart(pSDEChart2);
                PSDEChartAxesServiceBase.this.internalRemoveByPSDEChart(pSDEChart2);
                PSDEChartAxesServiceBase.this.onAfterRemoveByPSDEChart(pSDEChart2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEChart(PSDEChart pSDEChart) throws Exception {
    }

    protected void internalRemoveByPSDEChart(PSDEChart pSDEChart) throws Exception {
        ArrayList<PSDEChartAxes> arrayList = this.selectByPSDEChart(pSDEChart);
        this.onBeforeRemoveByPSDEChart(pSDEChart, arrayList);
        for (PSDEChartAxes pSDEChartAxes : arrayList) {
            this.remove(pSDEChartAxes);
        }
        this.onAfterRemoveByPSDEChart(pSDEChart, arrayList);
    }

    protected void onAfterRemoveByPSDEChart(PSDEChart pSDEChart) throws Exception {
    }

    protected void onBeforeRemoveByPSDEChart(PSDEChart pSDEChart, ArrayList<PSDEChartAxes> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEChart(PSDEChart pSDEChart, ArrayList<PSDEChartAxes> arrayList) throws Exception {
    }

    public void testRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEChartAxes> arrayList = this.selectByCapPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDECHARTAXES_PSLANGUAGERES_CAPPSLANRESID", "", iDataEntityModel.getName(), "PSDECHARTAXES", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEChartAxes> arrayList = this.selectByCapPSLanRes(pSLanguageRes);
        for (PSDEChartAxes pSDEChartAxes : arrayList) {
            PSDEChartAxes pSDEChartAxes2 = (PSDEChartAxes)this.getDEModel().createEntity();
            pSDEChartAxes2.setPSDEChartAxesId(pSDEChartAxes.getPSDEChartAxesId());
            pSDEChartAxes2.setCapPSLanResId(null);
            this.update(pSDEChartAxes2);
        }
    }

    public void removeByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEChartAxesServiceBase.this.onBeforeRemoveByCapPSLanRes(pSLanguageRes2);
                PSDEChartAxesServiceBase.this.internalRemoveByCapPSLanRes(pSLanguageRes2);
                PSDEChartAxesServiceBase.this.onAfterRemoveByCapPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEChartAxes> arrayList = this.selectByCapPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByCapPSLanRes(pSLanguageRes, arrayList);
        for (PSDEChartAxes pSDEChartAxes : arrayList) {
            this.remove(pSDEChartAxes);
        }
        this.onAfterRemoveByCapPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEChartAxes> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEChartAxes> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEChartAxes> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDECHARTAXES_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSDECHARTAXES", iDataEntityModel.getDataInfo(pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEChartAxes> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSDEChartAxes pSDEChartAxes : arrayList) {
            PSDEChartAxes pSDEChartAxes2 = (PSDEChartAxes)this.getDEModel().createEntity();
            pSDEChartAxes2.setPSDEChartAxesId(pSDEChartAxes.getPSDEChartAxesId());
            pSDEChartAxes2.setPSSysDynaModelId(null);
            this.update(pSDEChartAxes2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEChartAxesServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSDEChartAxesServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSDEChartAxesServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEChartAxes> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSDEChartAxes pSDEChartAxes : arrayList) {
            this.remove(pSDEChartAxes);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDEChartAxes> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDEChartAxes> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEChartAxes> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDECHARTAXES_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSDECHARTAXES", iDataEntityModel.getDataInfo(pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEChartAxes> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSDEChartAxes pSDEChartAxes : arrayList) {
            PSDEChartAxes pSDEChartAxes2 = (PSDEChartAxes)this.getDEModel().createEntity();
            pSDEChartAxes2.setPSDEChartAxesId(pSDEChartAxes.getPSDEChartAxesId());
            pSDEChartAxes2.setPSSysPFPluginId(null);
            this.update(pSDEChartAxes2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEChartAxesServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEChartAxesServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEChartAxesServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEChartAxes> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSDEChartAxes pSDEChartAxes : arrayList) {
            this.remove(pSDEChartAxes);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEChartAxes> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEChartAxes> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEChartAxes pSDEChartAxes) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEChartLogicService)ServiceGlobal.getService(PSDEChartLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEChartLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSDEChartAxes(pSDEChartAxes);
        pSCoreSysServiceBase = (PSDEChartParamService)ServiceGlobal.getService(PSDEChartParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEChartParamServiceBase)pSCoreSysServiceBase).testRemoveByXPSDEChartAxes(pSDEChartAxes);
        pSCoreSysServiceBase = (PSDEChartParamService)ServiceGlobal.getService(PSDEChartParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEChartParamServiceBase)pSCoreSysServiceBase).testRemoveByYPSDEChartAxes(pSDEChartAxes);
        super.onBeforeRemove(pSDEChartAxes);
    }

    protected void onBeforeRemoveTemp(PSDEChartAxes pSDEChartAxes) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEChartParamService)ServiceGlobal.getService(PSDEChartParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEChartParamServiceBase)pSCoreSysServiceBase).resetTempYPSDEChartAxes(pSDEChartAxes);
        pSCoreSysServiceBase = (PSDEChartParamService)ServiceGlobal.getService(PSDEChartParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEChartParamServiceBase)pSCoreSysServiceBase).resetTempXPSDEChartAxes(pSDEChartAxes);
        pSCoreSysServiceBase = (PSDEChartLogicService)ServiceGlobal.getService(PSDEChartLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEChartLogicServiceBase)pSCoreSysServiceBase).resetTempPSDEChartAxes(pSDEChartAxes);
        super.onBeforeRemoveTemp(pSDEChartAxes);
    }

    public void removeTempByPSDEChart(PSDEChart pSDEChart) throws Exception {
        final PSDEChart pSDEChart2 = pSDEChart;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEChartAxesServiceBase.this.onBeforeRemoveTempByPSDEChart(pSDEChart2);
                PSDEChartAxesServiceBase.this.internalRemoveTempByPSDEChart(pSDEChart2);
                PSDEChartAxesServiceBase.this.onAfterRemoveTempByPSDEChart(pSDEChart2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEChart(PSDEChart pSDEChart) throws Exception {
    }

    protected void internalRemoveTempByPSDEChart(PSDEChart pSDEChart) throws Exception {
        ArrayList<PSDEChartAxes> arrayList = this.selectTempByPSDEChart(pSDEChart);
        this.onBeforeRemoveTempByPSDEChart(pSDEChart, arrayList);
        for (PSDEChartAxes pSDEChartAxes : arrayList) {
            this.removeTemp(pSDEChartAxes);
        }
        this.onAfterRemoveTempByPSDEChart(pSDEChart, arrayList);
    }

    protected void onAfterRemoveTempByPSDEChart(PSDEChart pSDEChart) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEChart(PSDEChart pSDEChart, ArrayList<PSDEChartAxes> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEChart(PSDEChart pSDEChart, ArrayList<PSDEChartAxes> arrayList) throws Exception {
    }

    protected void getRelatedDataTempMajor(PSDEChartAxes pSDEChartAxes) throws Exception {
        super.getRelatedDataTempMajor(pSDEChartAxes);
    }

    protected void updateRelatedDataTempMajor(PSDEChartAxes pSDEChartAxes, PSDEChartAxes pSDEChartAxes2) throws Exception {
        super.updateRelatedDataTempMajor(pSDEChartAxes, pSDEChartAxes2);
    }

    protected void replaceParentInfo(PSDEChartAxes pSDEChartAxes, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEChartAxes, cloneSession);
        if (pSDEChartAxes.getPSDEChartId() != null && (iEntity = cloneSession.getEntity("PSDECHART", (Object)pSDEChartAxes.getPSDEChartId())) != null) {
            this.onFillParentInfo_PSDEChart(pSDEChartAxes, (PSDEChart)iEntity);
        }
        if (pSDEChartAxes.getCapPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEChartAxes.getCapPSLanResId())) != null) {
            this.onFillParentInfo_CapPSLanRes(pSDEChartAxes, (PSLanguageRes)iEntity);
        }
        if (pSDEChartAxes.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSDEChartAxes.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSDEChartAxes, (PSSysDynaModel)iEntity);
        }
        if (pSDEChartAxes.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSDEChartAxes.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSDEChartAxes, (PSSysPFPlugin)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEChartAxes pSDEChartAxes, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEChartAxes, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEChartAxes pSDEChartAxes, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AxesData(bl, pSDEChartAxes, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AxesData2(bl, pSDEChartAxes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AxesMaxValue(bl, pSDEChartAxes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AxesMinValue(bl, pSDEChartAxes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AxesPos(bl, pSDEChartAxes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AxesType(bl, pSDEChartAxes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CapPSLanResId(bl, pSDEChartAxes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CapPSLanResName(bl, pSDEChartAxes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Caption(bl, pSDEChartAxes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CoordinateSystemId(bl, pSDEChartAxes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DataShowMode(bl, pSDEChartAxes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaClass(bl, pSDEChartAxes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Fields(bl, pSDEChartAxes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEChartAxes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDEChartAxes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEChartAxesId(bl, pSDEChartAxes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEChartAxesName(bl, pSDEChartAxes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEChartId(bl, pSDEChartAxes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSDEChartAxes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSDEChartAxes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEChartAxes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserParams(bl, pSDEChartAxes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEChartAxes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEChartAxes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEChartAxes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEChartAxes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEChartAxes, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AxesData(boolean bl, PSDEChartAxes pSDEChartAxes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartAxes.isAxesDataDirty() : !pSDEChartAxes.isAxesDataDirty()) {
            return null;
        }
        String string = pSDEChartAxes.getAxesData();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AxesData_Default(pSDEChartAxes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AXESDATA");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AxesData2(boolean bl, PSDEChartAxes pSDEChartAxes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartAxes.isAxesData2Dirty() : !pSDEChartAxes.isAxesData2Dirty()) {
            return null;
        }
        String string = pSDEChartAxes.getAxesData2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AxesData2_Default(pSDEChartAxes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AXESDATA2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AxesMaxValue(boolean bl, PSDEChartAxes pSDEChartAxes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartAxes.isAxesMaxValueDirty() : !pSDEChartAxes.isAxesMaxValueDirty()) {
            return null;
        }
        Double d = pSDEChartAxes.getAxesMaxValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AxesMaxValue_Default(pSDEChartAxes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AXESMAXVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AxesMinValue(boolean bl, PSDEChartAxes pSDEChartAxes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartAxes.isAxesMinValueDirty() : !pSDEChartAxes.isAxesMinValueDirty()) {
            return null;
        }
        Double d = pSDEChartAxes.getAxesMinValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AxesMinValue_Default(pSDEChartAxes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AXESMINVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AxesPos(boolean bl, PSDEChartAxes pSDEChartAxes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartAxes.isAxesPosDirty() && !bl2 : !pSDEChartAxes.isAxesPosDirty()) {
            return null;
        }
        String string = pSDEChartAxes.getAxesPos();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AXESPOS");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_AxesPos_Default(pSDEChartAxes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AXESPOS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AxesType(boolean bl, PSDEChartAxes pSDEChartAxes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartAxes.isAxesTypeDirty() && !bl2 : !pSDEChartAxes.isAxesTypeDirty()) {
            return null;
        }
        String string = pSDEChartAxes.getAxesType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AXESTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_AxesType_Default(pSDEChartAxes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AXESTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CapPSLanResId(boolean bl, PSDEChartAxes pSDEChartAxes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartAxes.isCapPSLanResIdDirty() : !pSDEChartAxes.isCapPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEChartAxes.getCapPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CapPSLanResId_Default(pSDEChartAxes, bl2, bl3);
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

    protected EntityFieldError onCheckField_CapPSLanResName(boolean bl, PSDEChartAxes pSDEChartAxes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartAxes.isCapPSLanResNameDirty() : !pSDEChartAxes.isCapPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEChartAxes.getCapPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CapPSLanResName_Default(pSDEChartAxes, bl2, bl3);
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

    protected EntityFieldError onCheckField_Caption(boolean bl, PSDEChartAxes pSDEChartAxes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartAxes.isCaptionDirty() : !pSDEChartAxes.isCaptionDirty()) {
            return null;
        }
        String string = pSDEChartAxes.getCaption();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Caption_Default(pSDEChartAxes, bl2, bl3);
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

    protected EntityFieldError onCheckField_CoordinateSystemId(boolean bl, PSDEChartAxes pSDEChartAxes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartAxes.isCoordinateSystemIdDirty() : !pSDEChartAxes.isCoordinateSystemIdDirty()) {
            return null;
        }
        Integer n = pSDEChartAxes.getCoordinateSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CoordinateSystemId_Default(pSDEChartAxes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COORDINATESYSTEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DataShowMode(boolean bl, PSDEChartAxes pSDEChartAxes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartAxes.isDataShowModeDirty() : !pSDEChartAxes.isDataShowModeDirty()) {
            return null;
        }
        Integer n = pSDEChartAxes.getDataShowMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DataShowMode_Default(pSDEChartAxes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATASHOWMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaClass(boolean bl, PSDEChartAxes pSDEChartAxes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartAxes.isDynaClassDirty() : !pSDEChartAxes.isDynaClassDirty()) {
            return null;
        }
        String string = pSDEChartAxes.getDynaClass();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DynaClass_Default(pSDEChartAxes, bl2, bl3);
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

    protected EntityFieldError onCheckField_Fields(boolean bl, PSDEChartAxes pSDEChartAxes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartAxes.isFieldsDirty() : !pSDEChartAxes.isFieldsDirty()) {
            return null;
        }
        String string = pSDEChartAxes.getFields();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Fields_Default(pSDEChartAxes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FIELDS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEChartAxes pSDEChartAxes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartAxes.isMemoDirty() : !pSDEChartAxes.isMemoDirty()) {
            return null;
        }
        String string = pSDEChartAxes.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDEChartAxes, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDEChartAxes pSDEChartAxes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartAxes.isOrderValueDirty() : !pSDEChartAxes.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDEChartAxes.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSDEChartAxes, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEChartAxesId(boolean bl, PSDEChartAxes pSDEChartAxes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartAxes.isPSDEChartAxesIdDirty() && !bl2 : !pSDEChartAxes.isPSDEChartAxesIdDirty()) {
            return null;
        }
        String string = pSDEChartAxes.getPSDEChartAxesId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDECHARTAXESID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEChartAxesId_Default(pSDEChartAxes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDECHARTAXESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEChartAxesName(boolean bl, PSDEChartAxes pSDEChartAxes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartAxes.isPSDEChartAxesNameDirty() && !bl2 : !pSDEChartAxes.isPSDEChartAxesNameDirty()) {
            return null;
        }
        String string = pSDEChartAxes.getPSDEChartAxesName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDECHARTAXESNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEChartAxesName_Default(pSDEChartAxes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDECHARTAXESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSDECHARTID";
                String string4 = this.checkFieldDupRule(this.getPSDEChartAxesDEModel(), "PSDECHARTAXESNAME", string3, pSDEChartAxes, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDECHARTAXESNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEChartId(boolean bl, PSDEChartAxes pSDEChartAxes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartAxes.isPSDEChartIdDirty() && !bl2 : !pSDEChartAxes.isPSDEChartIdDirty()) {
            return null;
        }
        String string = pSDEChartAxes.getPSDEChartId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDECHARTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEChartId_Default(pSDEChartAxes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDECHARTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSDEChartAxes pSDEChartAxes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartAxes.isPSSysDynaModelIdDirty() : !pSDEChartAxes.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSDEChartAxes.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default(pSDEChartAxes, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSDEChartAxes pSDEChartAxes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartAxes.isPSSysPFPluginIdDirty() : !pSDEChartAxes.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSDEChartAxes.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default(pSDEChartAxes, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEChartAxes pSDEChartAxes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartAxes.isUserCatDirty() : !pSDEChartAxes.isUserCatDirty()) {
            return null;
        }
        String string = pSDEChartAxes.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDEChartAxes, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserParams(boolean bl, PSDEChartAxes pSDEChartAxes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartAxes.isUserParamsDirty() : !pSDEChartAxes.isUserParamsDirty()) {
            return null;
        }
        String string = pSDEChartAxes.getUserParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserParams_Default(pSDEChartAxes, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEChartAxes pSDEChartAxes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartAxes.isUserTagDirty() : !pSDEChartAxes.isUserTagDirty()) {
            return null;
        }
        String string = pSDEChartAxes.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDEChartAxes, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEChartAxes pSDEChartAxes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartAxes.isUserTag2Dirty() : !pSDEChartAxes.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEChartAxes.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDEChartAxes, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEChartAxes pSDEChartAxes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartAxes.isUserTag3Dirty() : !pSDEChartAxes.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEChartAxes.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDEChartAxes, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEChartAxes pSDEChartAxes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartAxes.isUserTag4Dirty() : !pSDEChartAxes.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEChartAxes.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDEChartAxes, bl2, bl3);
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

    protected void onSyncEntity(PSDEChartAxes pSDEChartAxes, boolean bl) throws Exception {
        super.onSyncEntity(pSDEChartAxes, bl);
    }

    protected void onSyncIndexEntities(PSDEChartAxes pSDEChartAxes, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEChartAxes, bl);
    }

    public Object getDataContextValue(PSDEChartAxes pSDEChartAxes, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDEChartAxes, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEChart pSDEChart = pSDEChartAxes.getPSDEChart();
        if (pSDEChart != null && pSDEChart.contains(string)) {
            return pSDEChart.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEChartAxes pSDEChartAxes, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportMajorModel_CapPSLanRes(pSDEChartAxes, arrayList, n);
        super.onExportMajorModel(pSDEChartAxes, arrayList, n);
    }

    protected void onExportMajorModel_CapPSLanRes(PSDEChartAxes pSDEChartAxes, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSDEChartAxes.getCapPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel(pSDEChartAxes.getCapPSLanRes(), arrayList, n);
        }
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"AXESDATA", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AxesData_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AXESDATA2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AxesData2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AXESMAXVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AxesMaxValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AXESMINVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AxesMinValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AXESPOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AxesPos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AXESTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AxesType_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"COORDINATESYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CoordinateSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATASHOWMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DataShowMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNACLASS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaClass_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FIELDS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Fields_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDECHARTAXESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEChartAxesId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDECHARTAXESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEChartAxesName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDECHARTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEChartId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDECHARTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEChartName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
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
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AxesData_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AXESDATA", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AxesData2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AXESDATA2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AxesMaxValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_AxesMinValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_AxesPos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AXESPOS", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AxesType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AXESTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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
            if (this.checkFieldStringLengthRule("CAPTION", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CoordinateSystemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_DataShowMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_Fields_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FIELDS", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDEChartAxesId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDECHARTAXESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEChartAxesName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDECHARTAXESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEChartId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDECHARTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEChartName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDECHARTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_UserParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERPARAMS", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDEChartAxes pSDEChartAxes) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEChartAxes)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEChartAxes pSDEChartAxes) throws Exception {
        super.onUpdateParent(pSDEChartAxes);
    }

    @Override
    protected void exportCurXmlModel(PSDEChartAxes pSDEChartAxes, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDECHARTAXES");
        if (!bl) {
            pSDEChartAxes.setPSDEChartId(null);
            pSDEChartAxes.setPSDEChartName(null);
            pSDEChartAxes.setPSDEId(null);
            super.exportCurXmlModel(pSDEChartAxes, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDEChartAxes pSDEChartAxes, XmlNode xmlNode) throws Exception {
        super.onExportRelatedXmlModel(pSDEChartAxes, xmlNode);
    }

    @Override
    protected void onImportRelatedXmlModel(PSDEChartAxes pSDEChartAxes, XmlNode xmlNode) throws Exception {
        super.onImportRelatedXmlModel(pSDEChartAxes, xmlNode);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEChartAxes pSDEChartAxes, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEChartAxes, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDECHARTID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDECHART#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDECHARTID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDECHARTAXES_PSDECHART_PSDECHARTID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDECHARTID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDECHARTNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDECHART", (boolean)true) == 0) {
            iEntity.set("PSDECHARTID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDECHARTID"};
    }

    @Override
    public String getModelV2Tag(PSDEChartAxes pSDEChartAxes) {
        if (!StringHelper.isNullOrEmpty((String)pSDEChartAxes.getPSDEChartAxesName())) {
            return pSDEChartAxes.getPSDEChartAxesName();
        }
        return super.getModelV2Tag(pSDEChartAxes);
    }

    @Override
    public boolean setModelV2Tag(PSDEChartAxes pSDEChartAxes, String string) {
        pSDEChartAxes.setPSDEChartAxesName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDECHARTAXESNAME", "");
        map.put("PSDECHARTID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEChartAxes pSDEChartAxes, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEChartAxes.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEChartAxes, true);
        pSDEChartAxes.set("PSDECHARTAXESNAME", string);
        if (this.select(pSDEChartAxes, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEChartAxes, true);
        return super.getModelV2Entity(pSDEChartAxes, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEChartAxes pSDEChartAxes, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEChartAxes, objectNode, string, string2, n);
    }
}

