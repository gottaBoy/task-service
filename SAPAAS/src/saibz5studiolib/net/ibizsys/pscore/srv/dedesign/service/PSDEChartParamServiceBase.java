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
import net.ibizsys.pscore.srv.dedesign.dao.PSDEChartParamDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEChartParamDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEChart;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEChartAxes;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEChartAxesBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEChartBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEChartParam;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDERBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartLogicService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeListBase;
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

public abstract class PSDEChartParamServiceBase
extends PSCoreSysServiceBase<PSDEChartParam> {
    private static final Log log = LogFactory.getLog(PSDEChartParamServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEChartParamDEModel pSDEChartParamDEModel;
    private PSDEChartParamDAO pSDEChartParamDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEChartParamService";
    }

    public PSDEChartParamDEModel getPSDEChartParamDEModel() {
        if (this.pSDEChartParamDEModel == null) {
            try {
                this.pSDEChartParamDEModel = (PSDEChartParamDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEChartParamDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEChartParamDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEChartParamDEModel();
    }

    public PSDEChartParamDAO getPSDEChartParamDAO() {
        if (this.pSDEChartParamDAO == null) {
            try {
                this.pSDEChartParamDAO = (PSDEChartParamDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEChartParamDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEChartParamDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEChartParamDAO();
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

    protected void onFillParentInfo(PSDEChartParam pSDEChartParam, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDECHARTPARAM_PSCODELIST_SFPSCODELISTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService", (SessionFactory)this.getSessionFactory());
            PSCodeList pSCodeList = (PSCodeList)iService.getDEModel().createEntity();
            pSCodeList.set("PSCODELISTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCodeList);
            } else {
                iService.get((IEntity)pSCodeList);
            }
            this.onFillParentInfo_SFPSCodeList(pSDEChartParam, pSCodeList);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDECHARTPARAM_PSCODELIST_XFPSCODELISTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService", (SessionFactory)this.getSessionFactory());
            PSCodeList pSCodeList = (PSCodeList)iService.getDEModel().createEntity();
            pSCodeList.set("PSCODELISTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCodeList);
            } else {
                iService.get((IEntity)pSCodeList);
            }
            this.onFillParentInfo_XFPSCodeList(pSDEChartParam, pSCodeList);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDECHARTPARAM_PSDECHARTAXES_XPSDECHARTAXESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEChartAxesService", (SessionFactory)this.getSessionFactory());
            PSDEChartAxes pSDEChartAxes = (PSDEChartAxes)iService.getDEModel().createEntity();
            pSDEChartAxes.set("PSDECHARTAXESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEChartAxes);
            } else {
                iService.get((IEntity)pSDEChartAxes);
            }
            this.onFillParentInfo_XPSDEChartAxes(pSDEChartParam, pSDEChartAxes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDECHARTPARAM_PSDECHARTAXES_YPSDECHARTAXESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEChartAxesService", (SessionFactory)this.getSessionFactory());
            PSDEChartAxes pSDEChartAxes = (PSDEChartAxes)iService.getDEModel().createEntity();
            pSDEChartAxes.set("PSDECHARTAXESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEChartAxes);
            } else {
                iService.get((IEntity)pSDEChartAxes);
            }
            this.onFillParentInfo_YPSDEChartAxes(pSDEChartParam, pSDEChartAxes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDECHARTPARAM_PSDECHART_PSDECHARTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEChartService", (SessionFactory)this.getSessionFactory());
            PSDEChart pSDEChart = (PSDEChart)iService.getDEModel().createEntity();
            pSDEChart.set("PSDECHARTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEChart);
            } else {
                iService.get((IEntity)pSDEChart);
            }
            this.onFillParentInfo_PSDEChart(pSDEChartParam, pSDEChart);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDECHARTPARAM_PSDER_PSDERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDERService", (SessionFactory)this.getSessionFactory());
            PSDER pSDER = (PSDER)iService.getDEModel().createEntity();
            pSDER.set("PSDERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDER);
            } else {
                iService.get((IEntity)pSDER);
            }
            this.onFillParentInfo_PSDER(pSDEChartParam, pSDER);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDECHARTPARAM_PSDEVIEWBASE_PSDEVIEWBASEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEViewBase);
            } else {
                iService.get((IEntity)pSDEViewBase);
            }
            this.onFillParentInfo_PSDEViewBase(pSDEChartParam, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDECHARTPARAM_PSLANGUAGERES_CAPPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSLanguageRes);
            } else {
                iService.get((IEntity)pSLanguageRes);
            }
            this.onFillParentInfo_CapPSLanRes(pSDEChartParam, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDECHARTPARAM_PSSYSDYNAMODEL_CSPSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDynaModel);
            } else {
                iService.get((IEntity)pSSysDynaModel);
            }
            this.onFillParentInfo_CSPSSysDynaModel(pSDEChartParam, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDECHARTPARAM_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDynaModel);
            } else {
                iService.get((IEntity)pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSDEChartParam, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDECHARTPARAM_PSSYSPFPLUGIN_CSPSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysPFPlugin);
            } else {
                iService.get((IEntity)pSSysPFPlugin);
            }
            this.onFillParentInfo_CSPSSysPFPlugin(pSDEChartParam, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDECHARTPARAM_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysPFPlugin);
            } else {
                iService.get((IEntity)pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSDEChartParam, pSSysPFPlugin);
            return;
        }
        super.onFillParentInfo((IEntity)pSDEChartParam, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDECHARTPARAM_PSDECHART_PSDECHARTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEChartService", (SessionFactory)this.getSessionFactory());
            PSDEChart pSDEChart = (PSDEChart)iService.getDEModel().createEntity();
            pSDEChart.set("PSDECHARTID", string2);
            return this.onSyncDER1NData_PSDEChart(pSDEChart, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_SFPSCodeList(PSDEChartParam pSDEChartParam, PSCodeList pSCodeList) throws Exception {
        pSDEChartParam.setSFPSCodeListId(pSCodeList.getPSCodeListId());
        pSDEChartParam.setSFPSCodeListName(pSCodeList.getPSCodeListName());
    }

    protected void onFillParentInfo_XFPSCodeList(PSDEChartParam pSDEChartParam, PSCodeList pSCodeList) throws Exception {
        pSDEChartParam.setXFPSCodeListId(pSCodeList.getPSCodeListId());
        pSDEChartParam.setXFPSCodeListName(pSCodeList.getPSCodeListName());
    }

    protected void onFillParentInfo_XPSDEChartAxes(PSDEChartParam pSDEChartParam, PSDEChartAxes pSDEChartAxes) throws Exception {
        pSDEChartParam.setXPSDEChartAxesId(pSDEChartAxes.getPSDEChartAxesId());
        pSDEChartParam.setXPSDEChartAxesName(pSDEChartAxes.getPSDEChartAxesName());
    }

    protected void onFillParentInfo_YPSDEChartAxes(PSDEChartParam pSDEChartParam, PSDEChartAxes pSDEChartAxes) throws Exception {
        pSDEChartParam.setYPSDEChartAxesId(pSDEChartAxes.getPSDEChartAxesId());
        pSDEChartParam.setYPSDEChartAxesName(pSDEChartAxes.getPSDEChartAxesName());
    }

    protected void onFillParentInfo_PSDEChart(PSDEChartParam pSDEChartParam, PSDEChart pSDEChart) throws Exception {
        pSDEChartParam.setPSDEChartId(pSDEChart.getPSDEChartId());
        pSDEChartParam.setPSDEChartName(pSDEChart.getPSDEChartName());
        pSDEChartParam.setPSDEId(pSDEChart.getPSDEId());
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
            ArrayList<PSDEChartParam> arrayList = this.selectByPSDEChart(pSDEChart);
            for (PSDEChartParam pSDEChartParam : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSDEChartParam, (String)"PSDECHARTPARAMID", (String)""))) continue;
                this.remove((IEntity)pSDEChartParam);
            }
        }
        return null;
    }

    protected void onFillParentInfo_PSDER(PSDEChartParam pSDEChartParam, PSDER pSDER) throws Exception {
        pSDEChartParam.setPSDERId(pSDER.getPSDERId());
        pSDEChartParam.setPSDERName(pSDER.getPSDERName());
    }

    protected void onFillParentInfo_PSDEViewBase(PSDEChartParam pSDEChartParam, PSDEViewBase pSDEViewBase) throws Exception {
        pSDEChartParam.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
        pSDEChartParam.setPSDEViewBaseName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_CapPSLanRes(PSDEChartParam pSDEChartParam, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEChartParam.setCapPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEChartParam.setCapPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_CSPSSysDynaModel(PSDEChartParam pSDEChartParam, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSDEChartParam.setCSPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSDEChartParam.setCSPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSDEChartParam pSDEChartParam, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSDEChartParam.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSDEChartParam.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_CSPSSysPFPlugin(PSDEChartParam pSDEChartParam, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSDEChartParam.setCSPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSDEChartParam.setCSPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSDEChartParam pSDEChartParam, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSDEChartParam.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSDEChartParam.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillEntityFullInfo(PSDEChartParam pSDEChartParam, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDEChartParam, bl);
        this.onFillEntityFullInfo_SFPSCodeList(pSDEChartParam, bl);
        this.onFillEntityFullInfo_XFPSCodeList(pSDEChartParam, bl);
        this.onFillEntityFullInfo_XPSDEChartAxes(pSDEChartParam, bl);
        this.onFillEntityFullInfo_YPSDEChartAxes(pSDEChartParam, bl);
        this.onFillEntityFullInfo_PSDEChart(pSDEChartParam, bl);
        this.onFillEntityFullInfo_PSDER(pSDEChartParam, bl);
        this.onFillEntityFullInfo_PSDEViewBase(pSDEChartParam, bl);
        this.onFillEntityFullInfo_CapPSLanRes(pSDEChartParam, bl);
        this.onFillEntityFullInfo_CSPSSysDynaModel(pSDEChartParam, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSDEChartParam, bl);
        this.onFillEntityFullInfo_CSPSSysPFPlugin(pSDEChartParam, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSDEChartParam, bl);
    }

    protected void onFillEntityFullInfo_SFPSCodeList(PSDEChartParam pSDEChartParam, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_XFPSCodeList(PSDEChartParam pSDEChartParam, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_XPSDEChartAxes(PSDEChartParam pSDEChartParam, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_YPSDEChartAxes(PSDEChartParam pSDEChartParam, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEChart(PSDEChartParam pSDEChartParam, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDER(PSDEChartParam pSDEChartParam, boolean bl) throws Exception {
        if (pSDEChartParam.isPSDERIdDirty()) {
            if (pSDEChartParam.getPSDERId() != null) {
                if (pSDEChartParam.getPSDERId() == null || pSDEChartParam.getPSDERName() == null) {
                    PSDER pSDER = pSDEChartParam.getPSDER();
                    pSDEChartParam.setPSDERName(pSDER.getPSDERName());
                }
            } else {
                pSDEChartParam.setPSDERName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEViewBase(PSDEChartParam pSDEChartParam, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_CapPSLanRes(PSDEChartParam pSDEChartParam, boolean bl) throws Exception {
        if (pSDEChartParam.isCapPSLanResIdDirty()) {
            if (pSDEChartParam.getCapPSLanResId() != null) {
                if (pSDEChartParam.getCapPSLanResId() == null || pSDEChartParam.getCapPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEChartParam.getCapPSLanRes();
                    pSDEChartParam.setCapPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEChartParam.setCapPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_CSPSSysDynaModel(PSDEChartParam pSDEChartParam, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSDEChartParam pSDEChartParam, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_CSPSSysPFPlugin(PSDEChartParam pSDEChartParam, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSDEChartParam pSDEChartParam, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEChartParam pSDEChartParam, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEChartParam, bl);
    }

    public ArrayList<PSDEChartParam> selectBySFPSCodeList(PSCodeListBase pSCodeListBase) throws Exception {
        return this.selectBySFPSCodeList(pSCodeListBase, "", -1);
    }

    public ArrayList<PSDEChartParam> selectBySFPSCodeList(PSCodeListBase pSCodeListBase, String string) throws Exception {
        return this.selectBySFPSCodeList(pSCodeListBase, string, -1);
    }

    public ArrayList<PSDEChartParam> selectBySFPSCodeList(PSCodeListBase pSCodeListBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SFPSCODELISTID", (Object)pSCodeListBase.getPSCodeListId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectBySFPSCodeListCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectBySFPSCodeListCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEChartParam> selectByXFPSCodeList(PSCodeListBase pSCodeListBase) throws Exception {
        return this.selectByXFPSCodeList(pSCodeListBase, "", -1);
    }

    public ArrayList<PSDEChartParam> selectByXFPSCodeList(PSCodeListBase pSCodeListBase, String string) throws Exception {
        return this.selectByXFPSCodeList(pSCodeListBase, string, -1);
    }

    public ArrayList<PSDEChartParam> selectByXFPSCodeList(PSCodeListBase pSCodeListBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("XFPSCODELISTID", (Object)pSCodeListBase.getPSCodeListId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByXFPSCodeListCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByXFPSCodeListCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEChartParam> selectByXPSDEChartAxes(PSDEChartAxesBase pSDEChartAxesBase) throws Exception {
        return this.selectByXPSDEChartAxes(pSDEChartAxesBase, "", -1);
    }

    public ArrayList<PSDEChartParam> selectByXPSDEChartAxes(PSDEChartAxesBase pSDEChartAxesBase, String string) throws Exception {
        return this.selectByXPSDEChartAxes(pSDEChartAxesBase, string, -1);
    }

    public ArrayList<PSDEChartParam> selectByXPSDEChartAxes(PSDEChartAxesBase pSDEChartAxesBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("XPSDECHARTAXESID", (Object)pSDEChartAxesBase.getPSDEChartAxesId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByXPSDEChartAxesCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByXPSDEChartAxesCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEChartParam> selectTempByXPSDEChartAxes(PSDEChartAxesBase pSDEChartAxesBase) throws Exception {
        return this.selectTempByXPSDEChartAxes(pSDEChartAxesBase, "");
    }

    public ArrayList<PSDEChartParam> selectTempByXPSDEChartAxes(PSDEChartAxesBase pSDEChartAxesBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("XPSDECHARTAXESID", (Object)pSDEChartAxesBase.getPSDEChartAxesId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByXPSDEChartAxesCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByXPSDEChartAxesCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEChartParam> selectByYPSDEChartAxes(PSDEChartAxesBase pSDEChartAxesBase) throws Exception {
        return this.selectByYPSDEChartAxes(pSDEChartAxesBase, "", -1);
    }

    public ArrayList<PSDEChartParam> selectByYPSDEChartAxes(PSDEChartAxesBase pSDEChartAxesBase, String string) throws Exception {
        return this.selectByYPSDEChartAxes(pSDEChartAxesBase, string, -1);
    }

    public ArrayList<PSDEChartParam> selectByYPSDEChartAxes(PSDEChartAxesBase pSDEChartAxesBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("YPSDECHARTAXESID", (Object)pSDEChartAxesBase.getPSDEChartAxesId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByYPSDEChartAxesCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByYPSDEChartAxesCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEChartParam> selectTempByYPSDEChartAxes(PSDEChartAxesBase pSDEChartAxesBase) throws Exception {
        return this.selectTempByYPSDEChartAxes(pSDEChartAxesBase, "");
    }

    public ArrayList<PSDEChartParam> selectTempByYPSDEChartAxes(PSDEChartAxesBase pSDEChartAxesBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("YPSDECHARTAXESID", (Object)pSDEChartAxesBase.getPSDEChartAxesId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByYPSDEChartAxesCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByYPSDEChartAxesCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEChartParam> selectByPSDEChart(PSDEChartBase pSDEChartBase) throws Exception {
        return this.selectByPSDEChart(pSDEChartBase, "", -1);
    }

    public ArrayList<PSDEChartParam> selectByPSDEChart(PSDEChartBase pSDEChartBase, String string) throws Exception {
        return this.selectByPSDEChart(pSDEChartBase, string, -1);
    }

    public ArrayList<PSDEChartParam> selectByPSDEChart(PSDEChartBase pSDEChartBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEChartParam> selectTempByPSDEChart(PSDEChartBase pSDEChartBase) throws Exception {
        return this.selectTempByPSDEChart(pSDEChartBase, "");
    }

    public ArrayList<PSDEChartParam> selectTempByPSDEChart(PSDEChartBase pSDEChartBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDECHARTID", (Object)pSDEChartBase.getPSDEChartId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEChartCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEChartCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEChartParam> selectByPSDER(PSDERBase pSDERBase) throws Exception {
        return this.selectByPSDER(pSDERBase, "", -1);
    }

    public ArrayList<PSDEChartParam> selectByPSDER(PSDERBase pSDERBase, String string) throws Exception {
        return this.selectByPSDER(pSDERBase, string, -1);
    }

    public ArrayList<PSDEChartParam> selectByPSDER(PSDERBase pSDERBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEChartParam> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByPSDEViewBase(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSDEChartParam> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByPSDEViewBase(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSDEChartParam> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEChartParam> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByCapPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEChartParam> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByCapPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEChartParam> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEChartParam> selectByCSPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByCSPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSDEChartParam> selectByCSPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByCSPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSDEChartParam> selectByCSPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CSPSSYSDYNAMODELID", (Object)pSSysDynaModelBase.getPSSysDynaModelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByCSPSSysDynaModelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByCSPSSysDynaModelCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEChartParam> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSDEChartParam> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSDEChartParam> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEChartParam> selectByCSPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByCSPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSDEChartParam> selectByCSPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByCSPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSDEChartParam> selectByCSPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CSPSSYSPFPLUGINID", (Object)pSSysPFPluginBase.getPSSysPFPluginId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByCSPSSysPFPluginCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByCSPSSysPFPluginCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEChartParam> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSDEChartParam> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSDEChartParam> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
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

    public void testRemoveBySFPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDEChartParam> arrayList = this.selectBySFPSCodeList(pSCodeList, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCODELIST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSCodeList);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDECHARTPARAM_PSCODELIST_SFPSCODELISTID", "", iDataEntityModel.getName(), "PSDECHARTPARAM", iDataEntityModel.getDataInfo((IEntity)pSCodeList), arrayList.get(0)));
        }
    }

    public void resetSFPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDEChartParam> arrayList = this.selectBySFPSCodeList(pSCodeList);
        for (PSDEChartParam pSDEChartParam : arrayList) {
            PSDEChartParam pSDEChartParam2 = (PSDEChartParam)this.getDEModel().createEntity();
            pSDEChartParam2.setPSDEChartParamId(pSDEChartParam.getPSDEChartParamId());
            pSDEChartParam2.setSFPSCodeListId(null);
            this.update(pSDEChartParam2);
        }
    }

    public void removeBySFPSCodeList(PSCodeList pSCodeList) throws Exception {
        final PSCodeList pSCodeList2 = pSCodeList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEChartParamServiceBase.this.onBeforeRemoveBySFPSCodeList(pSCodeList2);
                PSDEChartParamServiceBase.this.internalRemoveBySFPSCodeList(pSCodeList2);
                PSDEChartParamServiceBase.this.onAfterRemoveBySFPSCodeList(pSCodeList2);
            }
        });
    }

    protected void onBeforeRemoveBySFPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void internalRemoveBySFPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDEChartParam> arrayList = this.selectBySFPSCodeList(pSCodeList);
        this.onBeforeRemoveBySFPSCodeList(pSCodeList, arrayList);
        for (PSDEChartParam pSDEChartParam : arrayList) {
            this.remove((IEntity)pSDEChartParam);
        }
        this.onAfterRemoveBySFPSCodeList(pSCodeList, arrayList);
    }

    protected void onAfterRemoveBySFPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void onBeforeRemoveBySFPSCodeList(PSCodeList pSCodeList, ArrayList<PSDEChartParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveBySFPSCodeList(PSCodeList pSCodeList, ArrayList<PSDEChartParam> arrayList) throws Exception {
    }

    public void testRemoveByXFPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDEChartParam> arrayList = this.selectByXFPSCodeList(pSCodeList, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCODELIST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSCodeList);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDECHARTPARAM_PSCODELIST_XFPSCODELISTID", "", iDataEntityModel.getName(), "PSDECHARTPARAM", iDataEntityModel.getDataInfo((IEntity)pSCodeList), arrayList.get(0)));
        }
    }

    public void resetXFPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDEChartParam> arrayList = this.selectByXFPSCodeList(pSCodeList);
        for (PSDEChartParam pSDEChartParam : arrayList) {
            PSDEChartParam pSDEChartParam2 = (PSDEChartParam)this.getDEModel().createEntity();
            pSDEChartParam2.setPSDEChartParamId(pSDEChartParam.getPSDEChartParamId());
            pSDEChartParam2.setXFPSCodeListId(null);
            this.update(pSDEChartParam2);
        }
    }

    public void removeByXFPSCodeList(PSCodeList pSCodeList) throws Exception {
        final PSCodeList pSCodeList2 = pSCodeList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEChartParamServiceBase.this.onBeforeRemoveByXFPSCodeList(pSCodeList2);
                PSDEChartParamServiceBase.this.internalRemoveByXFPSCodeList(pSCodeList2);
                PSDEChartParamServiceBase.this.onAfterRemoveByXFPSCodeList(pSCodeList2);
            }
        });
    }

    protected void onBeforeRemoveByXFPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void internalRemoveByXFPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDEChartParam> arrayList = this.selectByXFPSCodeList(pSCodeList);
        this.onBeforeRemoveByXFPSCodeList(pSCodeList, arrayList);
        for (PSDEChartParam pSDEChartParam : arrayList) {
            this.remove((IEntity)pSDEChartParam);
        }
        this.onAfterRemoveByXFPSCodeList(pSCodeList, arrayList);
    }

    protected void onAfterRemoveByXFPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void onBeforeRemoveByXFPSCodeList(PSCodeList pSCodeList, ArrayList<PSDEChartParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveByXFPSCodeList(PSCodeList pSCodeList, ArrayList<PSDEChartParam> arrayList) throws Exception {
    }

    public void testRemoveByXPSDEChartAxes(PSDEChartAxes pSDEChartAxes) throws Exception {
        ArrayList<PSDEChartParam> arrayList = this.selectByXPSDEChartAxes(pSDEChartAxes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDECHARTAXES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEChartAxes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDECHARTPARAM_PSDECHARTAXES_XPSDECHARTAXESID", "", iDataEntityModel.getName(), "PSDECHARTPARAM", iDataEntityModel.getDataInfo((IEntity)pSDEChartAxes), arrayList.get(0)));
        }
    }

    public void resetXPSDEChartAxes(PSDEChartAxes pSDEChartAxes) throws Exception {
        ArrayList<PSDEChartParam> arrayList = this.selectByXPSDEChartAxes(pSDEChartAxes);
        for (PSDEChartParam pSDEChartParam : arrayList) {
            PSDEChartParam pSDEChartParam2 = (PSDEChartParam)this.getDEModel().createEntity();
            pSDEChartParam2.setPSDEChartParamId(pSDEChartParam.getPSDEChartParamId());
            pSDEChartParam2.setXPSDEChartAxesId(null);
            this.update(pSDEChartParam2);
        }
    }

    public void resetTempXPSDEChartAxes(PSDEChartAxes pSDEChartAxes) throws Exception {
        ArrayList<PSDEChartParam> arrayList = this.selectTempByXPSDEChartAxes(pSDEChartAxes);
        for (PSDEChartParam pSDEChartParam : arrayList) {
            PSDEChartParam pSDEChartParam2 = (PSDEChartParam)this.getDEModel().createEntity();
            pSDEChartParam2.setPSDEChartParamId(pSDEChartParam.getPSDEChartParamId());
            pSDEChartParam2.setXPSDEChartAxesId(null);
            this.updateTemp((IEntity)pSDEChartParam2);
        }
    }

    public void removeByXPSDEChartAxes(PSDEChartAxes pSDEChartAxes) throws Exception {
        final PSDEChartAxes pSDEChartAxes2 = pSDEChartAxes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEChartParamServiceBase.this.onBeforeRemoveByXPSDEChartAxes(pSDEChartAxes2);
                PSDEChartParamServiceBase.this.internalRemoveByXPSDEChartAxes(pSDEChartAxes2);
                PSDEChartParamServiceBase.this.onAfterRemoveByXPSDEChartAxes(pSDEChartAxes2);
            }
        });
    }

    protected void onBeforeRemoveByXPSDEChartAxes(PSDEChartAxes pSDEChartAxes) throws Exception {
    }

    protected void internalRemoveByXPSDEChartAxes(PSDEChartAxes pSDEChartAxes) throws Exception {
        ArrayList<PSDEChartParam> arrayList = this.selectByXPSDEChartAxes(pSDEChartAxes);
        this.onBeforeRemoveByXPSDEChartAxes(pSDEChartAxes, arrayList);
        for (PSDEChartParam pSDEChartParam : arrayList) {
            this.remove((IEntity)pSDEChartParam);
        }
        this.onAfterRemoveByXPSDEChartAxes(pSDEChartAxes, arrayList);
    }

    protected void onAfterRemoveByXPSDEChartAxes(PSDEChartAxes pSDEChartAxes) throws Exception {
    }

    protected void onBeforeRemoveByXPSDEChartAxes(PSDEChartAxes pSDEChartAxes, ArrayList<PSDEChartParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveByXPSDEChartAxes(PSDEChartAxes pSDEChartAxes, ArrayList<PSDEChartParam> arrayList) throws Exception {
    }

    public void testRemoveByYPSDEChartAxes(PSDEChartAxes pSDEChartAxes) throws Exception {
        ArrayList<PSDEChartParam> arrayList = this.selectByYPSDEChartAxes(pSDEChartAxes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDECHARTAXES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEChartAxes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDECHARTPARAM_PSDECHARTAXES_YPSDECHARTAXESID", "", iDataEntityModel.getName(), "PSDECHARTPARAM", iDataEntityModel.getDataInfo((IEntity)pSDEChartAxes), arrayList.get(0)));
        }
    }

    public void resetYPSDEChartAxes(PSDEChartAxes pSDEChartAxes) throws Exception {
        ArrayList<PSDEChartParam> arrayList = this.selectByYPSDEChartAxes(pSDEChartAxes);
        for (PSDEChartParam pSDEChartParam : arrayList) {
            PSDEChartParam pSDEChartParam2 = (PSDEChartParam)this.getDEModel().createEntity();
            pSDEChartParam2.setPSDEChartParamId(pSDEChartParam.getPSDEChartParamId());
            pSDEChartParam2.setYPSDEChartAxesId(null);
            this.update(pSDEChartParam2);
        }
    }

    public void resetTempYPSDEChartAxes(PSDEChartAxes pSDEChartAxes) throws Exception {
        ArrayList<PSDEChartParam> arrayList = this.selectTempByYPSDEChartAxes(pSDEChartAxes);
        for (PSDEChartParam pSDEChartParam : arrayList) {
            PSDEChartParam pSDEChartParam2 = (PSDEChartParam)this.getDEModel().createEntity();
            pSDEChartParam2.setPSDEChartParamId(pSDEChartParam.getPSDEChartParamId());
            pSDEChartParam2.setYPSDEChartAxesId(null);
            this.updateTemp((IEntity)pSDEChartParam2);
        }
    }

    public void removeByYPSDEChartAxes(PSDEChartAxes pSDEChartAxes) throws Exception {
        final PSDEChartAxes pSDEChartAxes2 = pSDEChartAxes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEChartParamServiceBase.this.onBeforeRemoveByYPSDEChartAxes(pSDEChartAxes2);
                PSDEChartParamServiceBase.this.internalRemoveByYPSDEChartAxes(pSDEChartAxes2);
                PSDEChartParamServiceBase.this.onAfterRemoveByYPSDEChartAxes(pSDEChartAxes2);
            }
        });
    }

    protected void onBeforeRemoveByYPSDEChartAxes(PSDEChartAxes pSDEChartAxes) throws Exception {
    }

    protected void internalRemoveByYPSDEChartAxes(PSDEChartAxes pSDEChartAxes) throws Exception {
        ArrayList<PSDEChartParam> arrayList = this.selectByYPSDEChartAxes(pSDEChartAxes);
        this.onBeforeRemoveByYPSDEChartAxes(pSDEChartAxes, arrayList);
        for (PSDEChartParam pSDEChartParam : arrayList) {
            this.remove((IEntity)pSDEChartParam);
        }
        this.onAfterRemoveByYPSDEChartAxes(pSDEChartAxes, arrayList);
    }

    protected void onAfterRemoveByYPSDEChartAxes(PSDEChartAxes pSDEChartAxes) throws Exception {
    }

    protected void onBeforeRemoveByYPSDEChartAxes(PSDEChartAxes pSDEChartAxes, ArrayList<PSDEChartParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveByYPSDEChartAxes(PSDEChartAxes pSDEChartAxes, ArrayList<PSDEChartParam> arrayList) throws Exception {
    }

    public void testRemoveByPSDEChart(PSDEChart pSDEChart) throws Exception {
    }

    public void resetPSDEChart(PSDEChart pSDEChart) throws Exception {
        ArrayList<PSDEChartParam> arrayList = this.selectByPSDEChart(pSDEChart);
        for (PSDEChartParam pSDEChartParam : arrayList) {
            PSDEChartParam pSDEChartParam2 = (PSDEChartParam)this.getDEModel().createEntity();
            pSDEChartParam2.setPSDEChartParamId(pSDEChartParam.getPSDEChartParamId());
            pSDEChartParam2.setPSDEChartId(null);
            this.update(pSDEChartParam2);
        }
    }

    public void resetTempPSDEChart(PSDEChart pSDEChart) throws Exception {
        ArrayList<PSDEChartParam> arrayList = this.selectTempByPSDEChart(pSDEChart);
        for (PSDEChartParam pSDEChartParam : arrayList) {
            PSDEChartParam pSDEChartParam2 = (PSDEChartParam)this.getDEModel().createEntity();
            pSDEChartParam2.setPSDEChartParamId(pSDEChartParam.getPSDEChartParamId());
            pSDEChartParam2.setPSDEChartId(null);
            this.updateTemp((IEntity)pSDEChartParam2);
        }
    }

    public void removeByPSDEChart(PSDEChart pSDEChart) throws Exception {
        final PSDEChart pSDEChart2 = pSDEChart;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEChartParamServiceBase.this.onBeforeRemoveByPSDEChart(pSDEChart2);
                PSDEChartParamServiceBase.this.internalRemoveByPSDEChart(pSDEChart2);
                PSDEChartParamServiceBase.this.onAfterRemoveByPSDEChart(pSDEChart2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEChart(PSDEChart pSDEChart) throws Exception {
    }

    protected void internalRemoveByPSDEChart(PSDEChart pSDEChart) throws Exception {
        ArrayList<PSDEChartParam> arrayList = this.selectByPSDEChart(pSDEChart);
        this.onBeforeRemoveByPSDEChart(pSDEChart, arrayList);
        for (PSDEChartParam pSDEChartParam : arrayList) {
            this.remove((IEntity)pSDEChartParam);
        }
        this.onAfterRemoveByPSDEChart(pSDEChart, arrayList);
    }

    protected void onAfterRemoveByPSDEChart(PSDEChart pSDEChart) throws Exception {
    }

    protected void onBeforeRemoveByPSDEChart(PSDEChart pSDEChart, ArrayList<PSDEChartParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEChart(PSDEChart pSDEChart, ArrayList<PSDEChartParam> arrayList) throws Exception {
    }

    public void testRemoveByPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEChartParam> arrayList = this.selectByPSDER(pSDER, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDER);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDECHARTPARAM_PSDER_PSDERID", "", iDataEntityModel.getName(), "PSDECHARTPARAM", iDataEntityModel.getDataInfo((IEntity)pSDER), arrayList.get(0)));
        }
    }

    public void resetPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEChartParam> arrayList = this.selectByPSDER(pSDER);
        for (PSDEChartParam pSDEChartParam : arrayList) {
            PSDEChartParam pSDEChartParam2 = (PSDEChartParam)this.getDEModel().createEntity();
            pSDEChartParam2.setPSDEChartParamId(pSDEChartParam.getPSDEChartParamId());
            pSDEChartParam2.setPSDERId(null);
            this.update(pSDEChartParam2);
        }
    }

    public void removeByPSDER(PSDER pSDER) throws Exception {
        final PSDER pSDER2 = pSDER;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEChartParamServiceBase.this.onBeforeRemoveByPSDER(pSDER2);
                PSDEChartParamServiceBase.this.internalRemoveByPSDER(pSDER2);
                PSDEChartParamServiceBase.this.onAfterRemoveByPSDER(pSDER2);
            }
        });
    }

    protected void onBeforeRemoveByPSDER(PSDER pSDER) throws Exception {
    }

    protected void internalRemoveByPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEChartParam> arrayList = this.selectByPSDER(pSDER);
        this.onBeforeRemoveByPSDER(pSDER, arrayList);
        for (PSDEChartParam pSDEChartParam : arrayList) {
            this.remove((IEntity)pSDEChartParam);
        }
        this.onAfterRemoveByPSDER(pSDER, arrayList);
    }

    protected void onAfterRemoveByPSDER(PSDER pSDER) throws Exception {
    }

    protected void onBeforeRemoveByPSDER(PSDER pSDER, ArrayList<PSDEChartParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDER(PSDER pSDER, ArrayList<PSDEChartParam> arrayList) throws Exception {
    }

    public void testRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEChartParam> arrayList = this.selectByPSDEViewBase(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDECHARTPARAM_PSDEVIEWBASE_PSDEVIEWBASEID", "", iDataEntityModel.getName(), "PSDECHARTPARAM", iDataEntityModel.getDataInfo((IEntity)pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEChartParam> arrayList = this.selectByPSDEViewBase(pSDEViewBase);
        for (PSDEChartParam pSDEChartParam : arrayList) {
            PSDEChartParam pSDEChartParam2 = (PSDEChartParam)this.getDEModel().createEntity();
            pSDEChartParam2.setPSDEChartParamId(pSDEChartParam.getPSDEChartParamId());
            pSDEChartParam2.setPSDEViewBaseId(null);
            this.update(pSDEChartParam2);
        }
    }

    public void removeByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEChartParamServiceBase.this.onBeforeRemoveByPSDEViewBase(pSDEViewBase2);
                PSDEChartParamServiceBase.this.internalRemoveByPSDEViewBase(pSDEViewBase2);
                PSDEChartParamServiceBase.this.onAfterRemoveByPSDEViewBase(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEChartParam> arrayList = this.selectByPSDEViewBase(pSDEViewBase);
        this.onBeforeRemoveByPSDEViewBase(pSDEViewBase, arrayList);
        for (PSDEChartParam pSDEChartParam : arrayList) {
            this.remove((IEntity)pSDEChartParam);
        }
        this.onAfterRemoveByPSDEViewBase(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSDEChartParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSDEChartParam> arrayList) throws Exception {
    }

    public void testRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEChartParam> arrayList = this.selectByCapPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDECHARTPARAM_PSLANGUAGERES_CAPPSLANRESID", "", iDataEntityModel.getName(), "PSDECHARTPARAM", iDataEntityModel.getDataInfo((IEntity)pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEChartParam> arrayList = this.selectByCapPSLanRes(pSLanguageRes);
        for (PSDEChartParam pSDEChartParam : arrayList) {
            PSDEChartParam pSDEChartParam2 = (PSDEChartParam)this.getDEModel().createEntity();
            pSDEChartParam2.setPSDEChartParamId(pSDEChartParam.getPSDEChartParamId());
            pSDEChartParam2.setCapPSLanResId(null);
            this.update(pSDEChartParam2);
        }
    }

    public void removeByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEChartParamServiceBase.this.onBeforeRemoveByCapPSLanRes(pSLanguageRes2);
                PSDEChartParamServiceBase.this.internalRemoveByCapPSLanRes(pSLanguageRes2);
                PSDEChartParamServiceBase.this.onAfterRemoveByCapPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEChartParam> arrayList = this.selectByCapPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByCapPSLanRes(pSLanguageRes, arrayList);
        for (PSDEChartParam pSDEChartParam : arrayList) {
            this.remove((IEntity)pSDEChartParam);
        }
        this.onAfterRemoveByCapPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEChartParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEChartParam> arrayList) throws Exception {
    }

    public void testRemoveByCSPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEChartParam> arrayList = this.selectByCSPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDECHARTPARAM_PSSYSDYNAMODEL_CSPSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSDECHARTPARAM", iDataEntityModel.getDataInfo((IEntity)pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetCSPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEChartParam> arrayList = this.selectByCSPSSysDynaModel(pSSysDynaModel);
        for (PSDEChartParam pSDEChartParam : arrayList) {
            PSDEChartParam pSDEChartParam2 = (PSDEChartParam)this.getDEModel().createEntity();
            pSDEChartParam2.setPSDEChartParamId(pSDEChartParam.getPSDEChartParamId());
            pSDEChartParam2.setCSPSSysDynaModelId(null);
            this.update(pSDEChartParam2);
        }
    }

    public void removeByCSPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEChartParamServiceBase.this.onBeforeRemoveByCSPSSysDynaModel(pSSysDynaModel2);
                PSDEChartParamServiceBase.this.internalRemoveByCSPSSysDynaModel(pSSysDynaModel2);
                PSDEChartParamServiceBase.this.onAfterRemoveByCSPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByCSPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByCSPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEChartParam> arrayList = this.selectByCSPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByCSPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSDEChartParam pSDEChartParam : arrayList) {
            this.remove((IEntity)pSDEChartParam);
        }
        this.onAfterRemoveByCSPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByCSPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByCSPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDEChartParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCSPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDEChartParam> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEChartParam> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDECHARTPARAM_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSDECHARTPARAM", iDataEntityModel.getDataInfo((IEntity)pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEChartParam> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSDEChartParam pSDEChartParam : arrayList) {
            PSDEChartParam pSDEChartParam2 = (PSDEChartParam)this.getDEModel().createEntity();
            pSDEChartParam2.setPSDEChartParamId(pSDEChartParam.getPSDEChartParamId());
            pSDEChartParam2.setPSSysDynaModelId(null);
            this.update(pSDEChartParam2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEChartParamServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSDEChartParamServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSDEChartParamServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEChartParam> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSDEChartParam pSDEChartParam : arrayList) {
            this.remove((IEntity)pSDEChartParam);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDEChartParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDEChartParam> arrayList) throws Exception {
    }

    public void testRemoveByCSPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEChartParam> arrayList = this.selectByCSPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDECHARTPARAM_PSSYSPFPLUGIN_CSPSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSDECHARTPARAM", iDataEntityModel.getDataInfo((IEntity)pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetCSPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEChartParam> arrayList = this.selectByCSPSSysPFPlugin(pSSysPFPlugin);
        for (PSDEChartParam pSDEChartParam : arrayList) {
            PSDEChartParam pSDEChartParam2 = (PSDEChartParam)this.getDEModel().createEntity();
            pSDEChartParam2.setPSDEChartParamId(pSDEChartParam.getPSDEChartParamId());
            pSDEChartParam2.setCSPSSysPFPluginId(null);
            this.update(pSDEChartParam2);
        }
    }

    public void removeByCSPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEChartParamServiceBase.this.onBeforeRemoveByCSPSSysPFPlugin(pSSysPFPlugin2);
                PSDEChartParamServiceBase.this.internalRemoveByCSPSSysPFPlugin(pSSysPFPlugin2);
                PSDEChartParamServiceBase.this.onAfterRemoveByCSPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByCSPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByCSPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEChartParam> arrayList = this.selectByCSPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByCSPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSDEChartParam pSDEChartParam : arrayList) {
            this.remove((IEntity)pSDEChartParam);
        }
        this.onAfterRemoveByCSPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByCSPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByCSPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEChartParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCSPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEChartParam> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEChartParam> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDECHARTPARAM_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSDECHARTPARAM", iDataEntityModel.getDataInfo((IEntity)pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEChartParam> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSDEChartParam pSDEChartParam : arrayList) {
            PSDEChartParam pSDEChartParam2 = (PSDEChartParam)this.getDEModel().createEntity();
            pSDEChartParam2.setPSDEChartParamId(pSDEChartParam.getPSDEChartParamId());
            pSDEChartParam2.setPSSysPFPluginId(null);
            this.update(pSDEChartParam2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEChartParamServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEChartParamServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEChartParamServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEChartParam> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSDEChartParam pSDEChartParam : arrayList) {
            this.remove((IEntity)pSDEChartParam);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEChartParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEChartParam> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEChartParam pSDEChartParam) throws Exception {
        PSDEChartLogicService pSDEChartLogicService = (PSDEChartLogicService)ServiceGlobal.getService(PSDEChartLogicService.class, (SessionFactory)this.getSessionFactory());
        pSDEChartLogicService.testRemoveByPSDEChartParam(pSDEChartParam);
        super.onBeforeRemove(pSDEChartParam);
    }

    protected void onBeforeRemoveTemp(PSDEChartParam pSDEChartParam) throws Exception {
        PSDEChartLogicService pSDEChartLogicService = (PSDEChartLogicService)ServiceGlobal.getService(PSDEChartLogicService.class, (SessionFactory)this.getSessionFactory());
        pSDEChartLogicService.resetTempPSDEChartParam(pSDEChartParam);
        super.onBeforeRemoveTemp((IEntity)pSDEChartParam);
    }

    public void removeTempByXPSDEChartAxes(PSDEChartAxes pSDEChartAxes) throws Exception {
        final PSDEChartAxes pSDEChartAxes2 = pSDEChartAxes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEChartParamServiceBase.this.onBeforeRemoveTempByXPSDEChartAxes(pSDEChartAxes2);
                PSDEChartParamServiceBase.this.internalRemoveTempByXPSDEChartAxes(pSDEChartAxes2);
                PSDEChartParamServiceBase.this.onAfterRemoveTempByXPSDEChartAxes(pSDEChartAxes2);
            }
        });
    }

    protected void onBeforeRemoveTempByXPSDEChartAxes(PSDEChartAxes pSDEChartAxes) throws Exception {
    }

    protected void internalRemoveTempByXPSDEChartAxes(PSDEChartAxes pSDEChartAxes) throws Exception {
        ArrayList<PSDEChartParam> arrayList = this.selectTempByXPSDEChartAxes(pSDEChartAxes);
        this.onBeforeRemoveTempByXPSDEChartAxes(pSDEChartAxes, arrayList);
        for (PSDEChartParam pSDEChartParam : arrayList) {
            this.removeTemp((IEntity)pSDEChartParam);
        }
        this.onAfterRemoveTempByXPSDEChartAxes(pSDEChartAxes, arrayList);
    }

    protected void onAfterRemoveTempByXPSDEChartAxes(PSDEChartAxes pSDEChartAxes) throws Exception {
    }

    protected void onBeforeRemoveTempByXPSDEChartAxes(PSDEChartAxes pSDEChartAxes, ArrayList<PSDEChartParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByXPSDEChartAxes(PSDEChartAxes pSDEChartAxes, ArrayList<PSDEChartParam> arrayList) throws Exception {
    }

    public void removeTempByYPSDEChartAxes(PSDEChartAxes pSDEChartAxes) throws Exception {
        final PSDEChartAxes pSDEChartAxes2 = pSDEChartAxes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEChartParamServiceBase.this.onBeforeRemoveTempByYPSDEChartAxes(pSDEChartAxes2);
                PSDEChartParamServiceBase.this.internalRemoveTempByYPSDEChartAxes(pSDEChartAxes2);
                PSDEChartParamServiceBase.this.onAfterRemoveTempByYPSDEChartAxes(pSDEChartAxes2);
            }
        });
    }

    protected void onBeforeRemoveTempByYPSDEChartAxes(PSDEChartAxes pSDEChartAxes) throws Exception {
    }

    protected void internalRemoveTempByYPSDEChartAxes(PSDEChartAxes pSDEChartAxes) throws Exception {
        ArrayList<PSDEChartParam> arrayList = this.selectTempByYPSDEChartAxes(pSDEChartAxes);
        this.onBeforeRemoveTempByYPSDEChartAxes(pSDEChartAxes, arrayList);
        for (PSDEChartParam pSDEChartParam : arrayList) {
            this.removeTemp((IEntity)pSDEChartParam);
        }
        this.onAfterRemoveTempByYPSDEChartAxes(pSDEChartAxes, arrayList);
    }

    protected void onAfterRemoveTempByYPSDEChartAxes(PSDEChartAxes pSDEChartAxes) throws Exception {
    }

    protected void onBeforeRemoveTempByYPSDEChartAxes(PSDEChartAxes pSDEChartAxes, ArrayList<PSDEChartParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByYPSDEChartAxes(PSDEChartAxes pSDEChartAxes, ArrayList<PSDEChartParam> arrayList) throws Exception {
    }

    public void removeTempByPSDEChart(PSDEChart pSDEChart) throws Exception {
        final PSDEChart pSDEChart2 = pSDEChart;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEChartParamServiceBase.this.onBeforeRemoveTempByPSDEChart(pSDEChart2);
                PSDEChartParamServiceBase.this.internalRemoveTempByPSDEChart(pSDEChart2);
                PSDEChartParamServiceBase.this.onAfterRemoveTempByPSDEChart(pSDEChart2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEChart(PSDEChart pSDEChart) throws Exception {
    }

    protected void internalRemoveTempByPSDEChart(PSDEChart pSDEChart) throws Exception {
        ArrayList<PSDEChartParam> arrayList = this.selectTempByPSDEChart(pSDEChart);
        this.onBeforeRemoveTempByPSDEChart(pSDEChart, arrayList);
        for (PSDEChartParam pSDEChartParam : arrayList) {
            this.removeTemp((IEntity)pSDEChartParam);
        }
        this.onAfterRemoveTempByPSDEChart(pSDEChart, arrayList);
    }

    protected void onAfterRemoveTempByPSDEChart(PSDEChart pSDEChart) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEChart(PSDEChart pSDEChart, ArrayList<PSDEChartParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEChart(PSDEChart pSDEChart, ArrayList<PSDEChartParam> arrayList) throws Exception {
    }

    protected void getRelatedDataTempMajor(PSDEChartParam pSDEChartParam) throws Exception {
        super.getRelatedDataTempMajor((IEntity)pSDEChartParam);
    }

    protected void updateRelatedDataTempMajor(PSDEChartParam pSDEChartParam, PSDEChartParam pSDEChartParam2) throws Exception {
        super.updateRelatedDataTempMajor((IEntity)pSDEChartParam, (IEntity)pSDEChartParam2);
    }

    protected void replaceParentInfo(PSDEChartParam pSDEChartParam, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDEChartParam, cloneSession);
        if (pSDEChartParam.getSFPSCodeListId() != null && (iEntity = cloneSession.getEntity("PSCODELIST", (Object)pSDEChartParam.getSFPSCodeListId())) != null) {
            this.onFillParentInfo_SFPSCodeList(pSDEChartParam, (PSCodeList)iEntity);
        }
        if (pSDEChartParam.getXFPSCodeListId() != null && (iEntity = cloneSession.getEntity("PSCODELIST", (Object)pSDEChartParam.getXFPSCodeListId())) != null) {
            this.onFillParentInfo_XFPSCodeList(pSDEChartParam, (PSCodeList)iEntity);
        }
        if (pSDEChartParam.getXPSDEChartAxesId() != null && (iEntity = cloneSession.getEntity("PSDECHARTAXES", (Object)pSDEChartParam.getXPSDEChartAxesId())) != null) {
            this.onFillParentInfo_XPSDEChartAxes(pSDEChartParam, (PSDEChartAxes)iEntity);
        }
        if (pSDEChartParam.getYPSDEChartAxesId() != null && (iEntity = cloneSession.getEntity("PSDECHARTAXES", (Object)pSDEChartParam.getYPSDEChartAxesId())) != null) {
            this.onFillParentInfo_YPSDEChartAxes(pSDEChartParam, (PSDEChartAxes)iEntity);
        }
        if (pSDEChartParam.getPSDEChartId() != null && (iEntity = cloneSession.getEntity("PSDECHART", (Object)pSDEChartParam.getPSDEChartId())) != null) {
            this.onFillParentInfo_PSDEChart(pSDEChartParam, (PSDEChart)iEntity);
        }
        if (pSDEChartParam.getPSDERId() != null && (iEntity = cloneSession.getEntity("PSDER", (Object)pSDEChartParam.getPSDERId())) != null) {
            this.onFillParentInfo_PSDER(pSDEChartParam, (PSDER)iEntity);
        }
        if (pSDEChartParam.getPSDEViewBaseId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSDEChartParam.getPSDEViewBaseId())) != null) {
            this.onFillParentInfo_PSDEViewBase(pSDEChartParam, (PSDEViewBase)iEntity);
        }
        if (pSDEChartParam.getCapPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEChartParam.getCapPSLanResId())) != null) {
            this.onFillParentInfo_CapPSLanRes(pSDEChartParam, (PSLanguageRes)iEntity);
        }
        if (pSDEChartParam.getCSPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSDEChartParam.getCSPSSysDynaModelId())) != null) {
            this.onFillParentInfo_CSPSSysDynaModel(pSDEChartParam, (PSSysDynaModel)iEntity);
        }
        if (pSDEChartParam.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSDEChartParam.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSDEChartParam, (PSSysDynaModel)iEntity);
        }
        if (pSDEChartParam.getCSPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSDEChartParam.getCSPSSysPFPluginId())) != null) {
            this.onFillParentInfo_CSPSSysPFPlugin(pSDEChartParam, (PSSysPFPlugin)iEntity);
        }
        if (pSDEChartParam.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSDEChartParam.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSDEChartParam, (PSSysPFPlugin)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEChartParam pSDEChartParam, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEChartParam, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BarCategoryGap(bl, pSDEChartParam, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BarGap(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BarMaxWidth(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BarMinHeight(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BarMinWidth(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BarWidth(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BottomPos(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BoxWidths(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CapPSLanResId(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CapPSLanResName(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Caption(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Center(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ChartType(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ClockWise(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CoordinateSystem(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CoordinateSystemId(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CSPSSysDynaModelId(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CSPSSysPFPluginId(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DataField(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaClass(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EndAngle(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExtField(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExtField2(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExtField3(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExtField4(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FunnelAlign(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Height(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LeftPos(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MapType(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MaxSize(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MaxValue(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinAngle(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinShowLabelAngle(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinSize(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinValue(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewFilter(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewParam(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEChartId(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEChartParamId(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEChartParamName(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDERId(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDERName(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewBaseId(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Radius(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RightPos(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RoseType(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SampleData(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SeriesField(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SeriesLayoutBy(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SeriesParam(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SeriesParam10(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SeriesParam11(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SeriesParam12(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SeriesParam2(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SeriesParam3(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SeriesParam4(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SeriesParam5(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SeriesParam6(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SeriesParam7(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SeriesParam8(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SeriesParam9(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SFPSCodeListId(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SortDir(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SplitNumber(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Stack(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StartAngle(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Step(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TagField(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TimeGroup(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TopPos(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserParams(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Width(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_XField(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_XFPSCodeListId(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_XPSDEChartAxesId(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_YField(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_YPSDEChartAxesId(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ZField(bl, pSDEChartParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEChartParam, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BarCategoryGap(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isBarCategoryGapDirty() : !pSDEChartParam.isBarCategoryGapDirty()) {
            return null;
        }
        String string = pSDEChartParam.getBarCategoryGap();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BarCategoryGap_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BARCATEGORYGAP");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BarGap(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isBarGapDirty() : !pSDEChartParam.isBarGapDirty()) {
            return null;
        }
        String string = pSDEChartParam.getBarGap();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BarGap_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BARGAP");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BarMaxWidth(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isBarMaxWidthDirty() : !pSDEChartParam.isBarMaxWidthDirty()) {
            return null;
        }
        String string = pSDEChartParam.getBarMaxWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BarMaxWidth_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BARMAXWIDTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BarMinHeight(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isBarMinHeightDirty() : !pSDEChartParam.isBarMinHeightDirty()) {
            return null;
        }
        String string = pSDEChartParam.getBarMinHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BarMinHeight_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BARMINHEIGHT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BarMinWidth(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isBarMinWidthDirty() : !pSDEChartParam.isBarMinWidthDirty()) {
            return null;
        }
        String string = pSDEChartParam.getBarMinWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BarMinWidth_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BARMINWIDTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BarWidth(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isBarWidthDirty() : !pSDEChartParam.isBarWidthDirty()) {
            return null;
        }
        String string = pSDEChartParam.getBarWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BarWidth_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BARWIDTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BottomPos(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isBottomPosDirty() : !pSDEChartParam.isBottomPosDirty()) {
            return null;
        }
        String string = pSDEChartParam.getBottomPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BottomPos_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BOTTOMPOS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BoxWidths(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isBoxWidthsDirty() : !pSDEChartParam.isBoxWidthsDirty()) {
            return null;
        }
        String string = pSDEChartParam.getBoxWidths();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BoxWidths_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BOXWIDTHS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CapPSLanResId(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isCapPSLanResIdDirty() : !pSDEChartParam.isCapPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEChartParam.getCapPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CapPSLanResId_Default((IEntity)pSDEChartParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_CapPSLanResName(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isCapPSLanResNameDirty() : !pSDEChartParam.isCapPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEChartParam.getCapPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CapPSLanResName_Default((IEntity)pSDEChartParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_Caption(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isCaptionDirty() : !pSDEChartParam.isCaptionDirty()) {
            return null;
        }
        String string = pSDEChartParam.getCaption();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Caption_Default((IEntity)pSDEChartParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_Center(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isCenterDirty() : !pSDEChartParam.isCenterDirty()) {
            return null;
        }
        String string = pSDEChartParam.getCenter();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Center_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CENTER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ChartType(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isChartTypeDirty() && !bl2 : !pSDEChartParam.isChartTypeDirty()) {
            return null;
        }
        String string = pSDEChartParam.getChartType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CHARTTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ChartType_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CHARTTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ClockWise(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isClockWiseDirty() : !pSDEChartParam.isClockWiseDirty()) {
            return null;
        }
        Integer n = pSDEChartParam.getClockWise();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ClockWise_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CLOCKWISE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CoordinateSystem(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isCoordinateSystemDirty() : !pSDEChartParam.isCoordinateSystemDirty()) {
            return null;
        }
        String string = pSDEChartParam.getCoordinateSystem();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CoordinateSystem_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COORDINATESYSTEM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CoordinateSystemId(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isCoordinateSystemIdDirty() : !pSDEChartParam.isCoordinateSystemIdDirty()) {
            return null;
        }
        Integer n = pSDEChartParam.getCoordinateSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CoordinateSystemId_Default((IEntity)pSDEChartParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_CSPSSysDynaModelId(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isCSPSSysDynaModelIdDirty() : !pSDEChartParam.isCSPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSDEChartParam.getCSPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CSPSSysDynaModelId_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CSPSSYSDYNAMODELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CSPSSysPFPluginId(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isCSPSSysPFPluginIdDirty() : !pSDEChartParam.isCSPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSDEChartParam.getCSPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CSPSSysPFPluginId_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CSPSSYSPFPLUGINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DataField(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isDataFieldDirty() : !pSDEChartParam.isDataFieldDirty()) {
            return null;
        }
        String string = pSDEChartParam.getDataField();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DataField_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATAFIELD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaClass(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isDynaClassDirty() : !pSDEChartParam.isDynaClassDirty()) {
            return null;
        }
        String string = pSDEChartParam.getDynaClass();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DynaClass_Default((IEntity)pSDEChartParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_EndAngle(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isEndAngleDirty() : !pSDEChartParam.isEndAngleDirty()) {
            return null;
        }
        Integer n = pSDEChartParam.getEndAngle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EndAngle_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENDANGLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExtField(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isExtFieldDirty() : !pSDEChartParam.isExtFieldDirty()) {
            return null;
        }
        String string = pSDEChartParam.getExtField();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ExtField_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXTFIELD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExtField2(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isExtField2Dirty() : !pSDEChartParam.isExtField2Dirty()) {
            return null;
        }
        String string = pSDEChartParam.getExtField2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ExtField2_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXTFIELD2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExtField3(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isExtField3Dirty() : !pSDEChartParam.isExtField3Dirty()) {
            return null;
        }
        String string = pSDEChartParam.getExtField3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ExtField3_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXTFIELD3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExtField4(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isExtField4Dirty() : !pSDEChartParam.isExtField4Dirty()) {
            return null;
        }
        String string = pSDEChartParam.getExtField4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ExtField4_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXTFIELD4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FunnelAlign(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isFunnelAlignDirty() : !pSDEChartParam.isFunnelAlignDirty()) {
            return null;
        }
        String string = pSDEChartParam.getFunnelAlign();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FunnelAlign_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FUNNELALIGN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Height(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isHeightDirty() : !pSDEChartParam.isHeightDirty()) {
            return null;
        }
        String string = pSDEChartParam.getHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Height_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HEIGHT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LeftPos(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isLeftPosDirty() : !pSDEChartParam.isLeftPosDirty()) {
            return null;
        }
        String string = pSDEChartParam.getLeftPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LeftPos_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LEFTPOS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MapType(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isMapTypeDirty() : !pSDEChartParam.isMapTypeDirty()) {
            return null;
        }
        String string = pSDEChartParam.getMapType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MapType_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAPTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MaxSize(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isMaxSizeDirty() : !pSDEChartParam.isMaxSizeDirty()) {
            return null;
        }
        String string = pSDEChartParam.getMaxSize();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MaxSize_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAXSIZE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MaxValue(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isMaxValueDirty() : !pSDEChartParam.isMaxValueDirty()) {
            return null;
        }
        Integer n = pSDEChartParam.getMaxValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MaxValue_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAXVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isMemoDirty() : !pSDEChartParam.isMemoDirty()) {
            return null;
        }
        String string = pSDEChartParam.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDEChartParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_MinAngle(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isMinAngleDirty() : !pSDEChartParam.isMinAngleDirty()) {
            return null;
        }
        Integer n = pSDEChartParam.getMinAngle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MinAngle_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINANGLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MinShowLabelAngle(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isMinShowLabelAngleDirty() : !pSDEChartParam.isMinShowLabelAngleDirty()) {
            return null;
        }
        Integer n = pSDEChartParam.getMinShowLabelAngle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MinShowLabelAngle_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINSHOWLABELANGLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MinSize(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isMinSizeDirty() : !pSDEChartParam.isMinSizeDirty()) {
            return null;
        }
        String string = pSDEChartParam.getMinSize();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinSize_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINSIZE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MinValue(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isMinValueDirty() : !pSDEChartParam.isMinValueDirty()) {
            return null;
        }
        Integer n = pSDEChartParam.getMinValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MinValue_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavViewFilter(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isNavViewFilterDirty() : !pSDEChartParam.isNavViewFilterDirty()) {
            return null;
        }
        String string = pSDEChartParam.getNavViewFilter();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NavViewFilter_Default((IEntity)pSDEChartParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_NavViewParam(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isNavViewParamDirty() : !pSDEChartParam.isNavViewParamDirty()) {
            return null;
        }
        String string = pSDEChartParam.getNavViewParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NavViewParam_Default((IEntity)pSDEChartParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isOrderValueDirty() : !pSDEChartParam.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDEChartParam.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSDEChartParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEChartId(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isPSDEChartIdDirty() : !pSDEChartParam.isPSDEChartIdDirty()) {
            return null;
        }
        String string = pSDEChartParam.getPSDEChartId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEChartId_Default((IEntity)pSDEChartParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEChartParamId(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isPSDEChartParamIdDirty() && !bl2 : !pSDEChartParam.isPSDEChartParamIdDirty()) {
            return null;
        }
        String string = pSDEChartParam.getPSDEChartParamId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDECHARTPARAMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEChartParamId_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDECHARTPARAMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEChartParamName(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isPSDEChartParamNameDirty() && !bl2 : !pSDEChartParam.isPSDEChartParamNameDirty()) {
            return null;
        }
        String string = pSDEChartParam.getPSDEChartParamName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDECHARTPARAMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEChartParamName_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDECHARTPARAMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSDECHARTID";
                String string4 = this.checkFieldDupRule(this.getPSDEChartParamDEModel(), "PSDECHARTPARAMNAME", string3, pSDEChartParam, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDECHARTPARAMNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDERId(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isPSDERIdDirty() : !pSDEChartParam.isPSDERIdDirty()) {
            return null;
        }
        String string = pSDEChartParam.getPSDERId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDERId_Default((IEntity)pSDEChartParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDERName(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isPSDERNameDirty() : !pSDEChartParam.isPSDERNameDirty()) {
            return null;
        }
        String string = pSDEChartParam.getPSDERName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDERName_Default((IEntity)pSDEChartParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEViewBaseId(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isPSDEViewBaseIdDirty() : !pSDEChartParam.isPSDEViewBaseIdDirty()) {
            return null;
        }
        String string = pSDEChartParam.getPSDEViewBaseId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewBaseId_Default((IEntity)pSDEChartParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isPSSysDynaModelIdDirty() : !pSDEChartParam.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSDEChartParam.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default((IEntity)pSDEChartParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isPSSysPFPluginIdDirty() : !pSDEChartParam.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSDEChartParam.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default((IEntity)pSDEChartParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_Radius(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isRadiusDirty() : !pSDEChartParam.isRadiusDirty()) {
            return null;
        }
        String string = pSDEChartParam.getRadius();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Radius_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RADIUS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RightPos(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isRightPosDirty() : !pSDEChartParam.isRightPosDirty()) {
            return null;
        }
        String string = pSDEChartParam.getRightPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RightPos_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RIGHTPOS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RoseType(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isRoseTypeDirty() : !pSDEChartParam.isRoseTypeDirty()) {
            return null;
        }
        String string = pSDEChartParam.getRoseType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RoseType_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ROSETYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SampleData(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isSampleDataDirty() : !pSDEChartParam.isSampleDataDirty()) {
            return null;
        }
        String string = pSDEChartParam.getSampleData();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SampleData_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SAMPLEDATA");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SeriesField(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isSeriesFieldDirty() : !pSDEChartParam.isSeriesFieldDirty()) {
            return null;
        }
        String string = pSDEChartParam.getSeriesField();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SeriesField_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERIESFIELD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SeriesLayoutBy(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isSeriesLayoutByDirty() : !pSDEChartParam.isSeriesLayoutByDirty()) {
            return null;
        }
        String string = pSDEChartParam.getSeriesLayoutBy();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SeriesLayoutBy_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERIESLAYOUTBY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SeriesParam(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isSeriesParamDirty() : !pSDEChartParam.isSeriesParamDirty()) {
            return null;
        }
        String string = pSDEChartParam.getSeriesParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SeriesParam_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERIESPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SeriesParam10(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isSeriesParam10Dirty() : !pSDEChartParam.isSeriesParam10Dirty()) {
            return null;
        }
        Double d = pSDEChartParam.getSeriesParam10();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SeriesParam10_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERIESPARAM10");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SeriesParam11(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isSeriesParam11Dirty() : !pSDEChartParam.isSeriesParam11Dirty()) {
            return null;
        }
        Integer n = pSDEChartParam.getSeriesParam11();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SeriesParam11_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERIESPARAM11");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SeriesParam12(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isSeriesParam12Dirty() : !pSDEChartParam.isSeriesParam12Dirty()) {
            return null;
        }
        Integer n = pSDEChartParam.getSeriesParam12();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SeriesParam12_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERIESPARAM12");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SeriesParam2(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isSeriesParam2Dirty() : !pSDEChartParam.isSeriesParam2Dirty()) {
            return null;
        }
        String string = pSDEChartParam.getSeriesParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SeriesParam2_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERIESPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SeriesParam3(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isSeriesParam3Dirty() : !pSDEChartParam.isSeriesParam3Dirty()) {
            return null;
        }
        String string = pSDEChartParam.getSeriesParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SeriesParam3_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERIESPARAM3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SeriesParam4(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isSeriesParam4Dirty() : !pSDEChartParam.isSeriesParam4Dirty()) {
            return null;
        }
        String string = pSDEChartParam.getSeriesParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SeriesParam4_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERIESPARAM4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SeriesParam5(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isSeriesParam5Dirty() : !pSDEChartParam.isSeriesParam5Dirty()) {
            return null;
        }
        Integer n = pSDEChartParam.getSeriesParam5();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SeriesParam5_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERIESPARAM5");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SeriesParam6(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isSeriesParam6Dirty() : !pSDEChartParam.isSeriesParam6Dirty()) {
            return null;
        }
        Integer n = pSDEChartParam.getSeriesParam6();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SeriesParam6_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERIESPARAM6");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SeriesParam7(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isSeriesParam7Dirty() : !pSDEChartParam.isSeriesParam7Dirty()) {
            return null;
        }
        Integer n = pSDEChartParam.getSeriesParam7();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SeriesParam7_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERIESPARAM7");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SeriesParam8(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isSeriesParam8Dirty() : !pSDEChartParam.isSeriesParam8Dirty()) {
            return null;
        }
        Integer n = pSDEChartParam.getSeriesParam8();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SeriesParam8_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERIESPARAM8");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SeriesParam9(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isSeriesParam9Dirty() : !pSDEChartParam.isSeriesParam9Dirty()) {
            return null;
        }
        Double d = pSDEChartParam.getSeriesParam9();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SeriesParam9_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERIESPARAM9");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SFPSCodeListId(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isSFPSCodeListIdDirty() : !pSDEChartParam.isSFPSCodeListIdDirty()) {
            return null;
        }
        String string = pSDEChartParam.getSFPSCodeListId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SFPSCodeListId_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SFPSCODELISTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SortDir(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isSortDirDirty() : !pSDEChartParam.isSortDirDirty()) {
            return null;
        }
        String string = pSDEChartParam.getSortDir();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SortDir_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SORTDIR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SplitNumber(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isSplitNumberDirty() : !pSDEChartParam.isSplitNumberDirty()) {
            return null;
        }
        Integer n = pSDEChartParam.getSplitNumber();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SplitNumber_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SPLITNUMBER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Stack(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isStackDirty() : !pSDEChartParam.isStackDirty()) {
            return null;
        }
        Integer n = pSDEChartParam.getStack();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Stack_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STACK");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StartAngle(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isStartAngleDirty() : !pSDEChartParam.isStartAngleDirty()) {
            return null;
        }
        Integer n = pSDEChartParam.getStartAngle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_StartAngle_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STARTANGLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Step(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isStepDirty() : !pSDEChartParam.isStepDirty()) {
            return null;
        }
        String string = pSDEChartParam.getStep();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Step_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STEP");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TagField(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isTagFieldDirty() : !pSDEChartParam.isTagFieldDirty()) {
            return null;
        }
        String string = pSDEChartParam.getTagField();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TagField_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TAGFIELD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TimeGroup(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isTimeGroupDirty() : !pSDEChartParam.isTimeGroupDirty()) {
            return null;
        }
        String string = pSDEChartParam.getTimeGroup();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TimeGroup_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TIMEGROUP");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TopPos(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isTopPosDirty() : !pSDEChartParam.isTopPosDirty()) {
            return null;
        }
        String string = pSDEChartParam.getTopPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TopPos_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TOPPOS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isUserCatDirty() : !pSDEChartParam.isUserCatDirty()) {
            return null;
        }
        String string = pSDEChartParam.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSDEChartParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserParams(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isUserParamsDirty() : !pSDEChartParam.isUserParamsDirty()) {
            return null;
        }
        String string = pSDEChartParam.getUserParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserParams_Default((IEntity)pSDEChartParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isUserTagDirty() : !pSDEChartParam.isUserTagDirty()) {
            return null;
        }
        String string = pSDEChartParam.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDEChartParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isUserTag2Dirty() : !pSDEChartParam.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEChartParam.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDEChartParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isUserTag3Dirty() : !pSDEChartParam.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEChartParam.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSDEChartParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isUserTag4Dirty() : !pSDEChartParam.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEChartParam.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSDEChartParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_Width(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isWidthDirty() : !pSDEChartParam.isWidthDirty()) {
            return null;
        }
        String string = pSDEChartParam.getWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Width_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WIDTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_XField(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isXFieldDirty() : !pSDEChartParam.isXFieldDirty()) {
            return null;
        }
        String string = pSDEChartParam.getXField();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_XField_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("XFIELD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_XFPSCodeListId(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isXFPSCodeListIdDirty() : !pSDEChartParam.isXFPSCodeListIdDirty()) {
            return null;
        }
        String string = pSDEChartParam.getXFPSCodeListId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_XFPSCodeListId_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("XFPSCODELISTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_XPSDEChartAxesId(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isXPSDEChartAxesIdDirty() : !pSDEChartParam.isXPSDEChartAxesIdDirty()) {
            return null;
        }
        String string = pSDEChartParam.getXPSDEChartAxesId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_XPSDEChartAxesId_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("XPSDECHARTAXESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_YField(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isYFieldDirty() : !pSDEChartParam.isYFieldDirty()) {
            return null;
        }
        String string = pSDEChartParam.getYField();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_YField_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("YFIELD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_YPSDEChartAxesId(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isYPSDEChartAxesIdDirty() : !pSDEChartParam.isYPSDEChartAxesIdDirty()) {
            return null;
        }
        String string = pSDEChartParam.getYPSDEChartAxesId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_YPSDEChartAxesId_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("YPSDECHARTAXESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ZField(boolean bl, PSDEChartParam pSDEChartParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEChartParam.isZFieldDirty() : !pSDEChartParam.isZFieldDirty()) {
            return null;
        }
        String string = pSDEChartParam.getZField();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ZField_Default((IEntity)pSDEChartParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ZFIELD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDEChartParam pSDEChartParam, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEChartParam, bl);
    }

    protected void onSyncIndexEntities(PSDEChartParam pSDEChartParam, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEChartParam, bl);
    }

    public Object getDataContextValue(PSDEChartParam pSDEChartParam, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDEChartParam, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEChart pSDEChart = pSDEChartParam.getPSDEChart();
        if (pSDEChart != null && pSDEChart.contains(string)) {
            return pSDEChart.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEChartParam pSDEChartParam, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportMajorModel_CapPSLanRes(pSDEChartParam, arrayList, n);
        super.onExportMajorModel((IEntity)pSDEChartParam, arrayList, n);
    }

    protected void onExportMajorModel_CapPSLanRes(PSDEChartParam pSDEChartParam, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSDEChartParam.getCapPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel((IEntity)pSDEChartParam.getCapPSLanRes(), arrayList, n);
        }
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BARCATEGORYGAP", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BarCategoryGap_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BARGAP", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BarGap_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BARMAXWIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BarMaxWidth_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BARMINHEIGHT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BarMinHeight_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BARMINWIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BarMinWidth_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BARWIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BarWidth_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BOTTOMPOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BottomPos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BOXWIDTHS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BoxWidths_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"CENTER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Center_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CHARTTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ChartType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CLOCKWISE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ClockWise_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COORDINATESYSTEM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CoordinateSystem_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"CSPSSYSDYNAMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CSPSSysDynaModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CSPSSYSDYNAMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CSPSSysDynaModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CSPSSYSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CSPSSysPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CSPSSYSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CSPSSysPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATAFIELD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DataField_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNACLASS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaClass_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENDANGLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EndAngle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXTFIELD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExtField_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXTFIELD2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExtField2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXTFIELD3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExtField3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXTFIELD4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExtField4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FUNNELALIGN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FunnelAlign_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HEIGHT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Height_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LEFTPOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LeftPos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAPTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MapType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAXSIZE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MaxSize_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAXVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MaxValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINANGLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinAngle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINSHOWLABELANGLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinShowLabelAngle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINSIZE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinSize_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinValue_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDECHARTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEChartId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDECHARTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEChartName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDECHARTPARAMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEChartParamId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDECHARTPARAMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEChartParamName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWBASEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewBaseId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWBASENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewBaseName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"RADIUS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Radius_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RIGHTPOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RightPos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ROSETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RoseType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SAMPLEDATA", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SampleData_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERIESFIELD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SeriesField_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERIESLAYOUTBY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SeriesLayoutBy_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERIESPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SeriesParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERIESPARAM10", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SeriesParam10_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERIESPARAM11", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SeriesParam11_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERIESPARAM12", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SeriesParam12_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERIESPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SeriesParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERIESPARAM3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SeriesParam3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERIESPARAM4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SeriesParam4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERIESPARAM5", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SeriesParam5_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERIESPARAM6", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SeriesParam6_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERIESPARAM7", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SeriesParam7_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERIESPARAM8", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SeriesParam8_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERIESPARAM9", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SeriesParam9_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SFPSCODELISTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SFPSCodeListId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SFPSCODELISTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SFPSCodeListName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SORTDIR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SortDir_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SPLITNUMBER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SplitNumber_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STACK", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Stack_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STARTANGLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StartAngle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STEP", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Step_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TAGFIELD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TagField_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIMEGROUP", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TimeGroup_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TOPPOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TopPos_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"WIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Width_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"XFIELD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_XField_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"XFPSCODELISTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_XFPSCodeListId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"XFPSCODELISTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_XFPSCodeListName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"XPSDECHARTAXESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_XPSDEChartAxesId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"XPSDECHARTAXESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_XPSDEChartAxesName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"YFIELD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_YField_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"YPSDECHARTAXESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_YPSDEChartAxesId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"YPSDECHARTAXESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_YPSDEChartAxesName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ZFIELD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ZField_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_BarCategoryGap_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BARCATEGORYGAP", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BarGap_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BARGAP", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BarMaxWidth_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BARMAXWIDTH", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BarMinHeight_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BARMINHEIGHT", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BarMinWidth_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BARMINWIDTH", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BarWidth_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BARWIDTH", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BottomPos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BOTTOMPOS", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BoxWidths_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BOXWIDTHS", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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
            if (this.checkFieldStringLengthRule("CAPTION", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Center_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CENTER", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ChartType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CHARTTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ClockWise_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CoordinateSystem_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("COORDINATESYSTEM", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected String onTestValueRule_CSPSSysDynaModelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CSPSSYSDYNAMODELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CSPSSysDynaModelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CSPSSYSDYNAMODELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CSPSSysPFPluginId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CSPSSYSPFPLUGINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CSPSSysPFPluginName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CSPSSYSPFPLUGINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DataField_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATAFIELD", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected String onTestValueRule_EndAngle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExtField_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EXTFIELD", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ExtField2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EXTFIELD2", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ExtField3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EXTFIELD3", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ExtField4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EXTFIELD4", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FunnelAlign_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FUNNELALIGN", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Height_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HEIGHT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LeftPos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LEFTPOS", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MapType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAPTYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MaxSize_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAXSIZE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MaxValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_MinAngle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MinShowLabelAngle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MinSize_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINSIZE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MinValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSDEChartParamId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDECHARTPARAMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEChartParamName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDECHARTPARAMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false) && this.checkFieldRegExRule("PSDECHARTPARAMNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_Radius_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RADIUS", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RightPos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RIGHTPOS", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RoseType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ROSETYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SampleData_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SAMPLEDATA", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SeriesField_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SERIESFIELD", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SeriesLayoutBy_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SERIESLAYOUTBY", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SeriesParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SERIESPARAM", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SeriesParam10_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SeriesParam11_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SeriesParam12_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SeriesParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SERIESPARAM2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SeriesParam3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SERIESPARAM3", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SeriesParam4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SERIESPARAM4", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SeriesParam5_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SeriesParam6_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SeriesParam7_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SeriesParam8_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SeriesParam9_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SFPSCodeListId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SFPSCODELISTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SFPSCodeListName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SFPSCODELISTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SortDir_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SORTDIR", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SplitNumber_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Stack_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_StartAngle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Step_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STEP", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TagField_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TAGFIELD", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TimeGroup_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TIMEGROUP", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TopPos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TOPPOS", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected String onTestValueRule_Width_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WIDTH", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_XField_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("XFIELD", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_XFPSCodeListId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("XFPSCODELISTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_XFPSCodeListName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("XFPSCODELISTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_XPSDEChartAxesId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("XPSDECHARTAXESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_XPSDEChartAxesName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("XPSDECHARTAXESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_YField_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("YFIELD", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_YPSDEChartAxesId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("YPSDECHARTAXESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_YPSDEChartAxesName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("YPSDECHARTAXESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ZField_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ZFIELD", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDEChartParam pSDEChartParam) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEChartParam)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEChartParam pSDEChartParam) throws Exception {
        super.onUpdateParent((IEntity)pSDEChartParam);
    }

    @Override
    protected void exportCurXmlModel(PSDEChartParam pSDEChartParam, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDECHARTPARAM");
        if (!bl) {
            pSDEChartParam.setPSDEChartName(null);
            pSDEChartParam.setXPSDEChartAxesId(null);
            pSDEChartParam.setYPSDEChartAxesId(null);
            pSDEChartParam.setPSDEChartId(null);
            pSDEChartParam.setPSDEChartName(null);
            pSDEChartParam.setPSDEId(null);
            super.exportCurXmlModel(pSDEChartParam, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDEChartParam pSDEChartParam, XmlNode xmlNode) throws Exception {
        super.onExportRelatedXmlModel(pSDEChartParam, xmlNode);
    }

    @Override
    protected void onImportRelatedXmlModel(PSDEChartParam pSDEChartParam, XmlNode xmlNode) throws Exception {
        super.onImportRelatedXmlModel(pSDEChartParam, xmlNode);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEChartParam pSDEChartParam, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEChartParam, string);
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
            return "DER1N_PSDECHARTPARAM_PSDECHART_PSDECHARTID";
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
    public String getModelV2Tag(PSDEChartParam pSDEChartParam) {
        if (!StringHelper.isNullOrEmpty((String)pSDEChartParam.getPSDEChartParamName())) {
            return pSDEChartParam.getPSDEChartParamName();
        }
        return super.getModelV2Tag(pSDEChartParam);
    }

    @Override
    public boolean setModelV2Tag(PSDEChartParam pSDEChartParam, String string) {
        pSDEChartParam.setPSDEChartParamName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDECHARTPARAMNAME", "");
        map.put("PSDECHARTID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEChartParam pSDEChartParam, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEChartParam.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEChartParam, true);
        pSDEChartParam.set("PSDECHARTPARAMNAME", string);
        if (this.select(pSDEChartParam, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEChartParam, true);
        return super.getModelV2Entity(pSDEChartParam, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEChartParam pSDEChartParam, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEChartParam, objectNode, string, string2, n);
    }
}

