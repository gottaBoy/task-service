/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSetCond
 *  net.ibizsys.paas.core.IDEACMode
 *  net.ibizsys.paas.core.IDEDataQuery
 *  net.ibizsys.paas.core.IDEDataQueryCodeCond
 *  net.ibizsys.paas.core.IDEDataSet
 *  net.ibizsys.paas.core.IDEFSearchMode
 *  net.ibizsys.paas.core.IDEField
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.core.ISystem
 *  net.ibizsys.paas.demodel.DEFSearchModeModel
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.sysmodel.SysModelGlobal
 */
package net.ibizsys.pscore.srv.config.demodel;

import net.ibizsys.paas.core.DEDataSetCond;
import net.ibizsys.paas.core.IDEACMode;
import net.ibizsys.paas.core.IDEDataQuery;
import net.ibizsys.paas.core.IDEDataQueryCodeCond;
import net.ibizsys.paas.core.IDEDataSet;
import net.ibizsys.paas.core.IDEFSearchMode;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.demodel.DEFSearchModeModel;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.SysModelGlobal;
import net.ibizsys.pscore.srv.PSCoreSysModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.ac.PSSysPFPluginDefaultACModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysACIDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysAppCounterDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysAppMenuDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysAppMenuItemDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysAppUILogicDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysAppUtilDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysAppValueRuleDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysCDVDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysCalendarDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysCalendarItemDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysChartAxisDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysChartCSDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysChartSeriesDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysCustomDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysDCRDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysDEDataExportDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysDEDataImportDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysDEFValueRuleDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysDEMethodDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysDEUIActionDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysDLRDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysDVIDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysDashboardDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysDashboardPartDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysDataViewDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysECSDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysEFDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysFUCDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysGCRDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysGridDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysLIRDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysMapViewDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysMapViewItemDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysPCDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysPTBDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysPanelDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysPanelItemDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysSBDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysSBIDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysSFDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysTBDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysTBIDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysTitleBarDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysTreeDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysTreeExpBarDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysUEDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysULNDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysWithIconDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginCurSysWizardPanelDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataquery.PSSysPFPluginDefaultDQModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysACIDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysAppCounterDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysAppMenuDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysAppMenuItemDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysAppUILogicDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysAppUtilDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysAppValueRuleDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysCDVDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysCalendarDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysCalendarItemDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysChartAxisDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysChartCSDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysChartSeriesDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysCustomDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysDCRDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysDEDataExportDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysDEDataImportDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysDEFValueRuleDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysDEMethodDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysDEUIActionDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysDLRDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysDVIDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysDashboardDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysDataViewDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysECSDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysEFDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysFUCDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysGCRDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysGridDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysLIRDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysMapViewDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysMapViewItemDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysPCDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysPTBDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysPanelDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysPanelItemDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysSBDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysSBIDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysSFDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysTBDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysTBIDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysTitleBarDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysTreeDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysTreeExpBarDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysUEDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysULNDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysWithIconDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginCurSysWizardPanelDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginDashboardPartDSModel;
import net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset.PSSysPFPluginDefaultDSModel;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.core.IPSDEFGroupModel;
import net.ibizsys.pscore.srv.core.IPSDEFieldModel;
import net.ibizsys.pscore.srv.core.PSDEFGroupDetailModel;
import net.ibizsys.pscore.srv.core.PSDEFGroupModel;
import net.ibizsys.pscore.srv.core.PSDEFieldModel;
import net.ibizsys.pscore.srv.core.PSDataEntityModelBase;

public abstract class PSSysPFPluginDEModelBase
extends PSDataEntityModelBase<PSSysPFPlugin> {
    private PSCoreSysModel pSCoreSysModel;
    private PSSysPFPluginService pSSysPFPluginService;

    public PSSysPFPluginDEModelBase() throws Exception {
        this.setId("850bff46135ea742014684051bf67889");
        this.setName("PSSYSPFPLUGIN");
        this.setCodeName("PSSysPFPlugin");
        this.setTableName("T_SRFPSSYSPFPLUGIN");
        this.setViewName("v_PSSYSPFPLUGIN");
        this.setLogicName("\u524d\u7aef\u6a21\u677f\u63d2\u4ef6");
        this.setMemo("\u7cfb\u7edf\u524d\u7aef\u6a21\u677f\u63d2\u4ef6\u6a21\u578b\uff0c\u6a21\u677f\u63d2\u4ef6\u652f\u6301\u7528\u6237\u4e0d\u4fee\u6539\u6807\u51c6\u6a21\u677f\u3001\u4e0d\u76f4\u63a5\u7f16\u5199\u6700\u7ec8\u4ee3\u7801\u5c31\u80fd\u5b9e\u73b0\u76ee\u6807\u529f\u80fd\u3002\u63d2\u4ef6\u7684\u4f7f\u7528\u65e2\u4fdd\u8bc1\u4e86\u4f53\u7cfb\u7684\u4e00\u81f4\u6027\uff0c\u4e5f\u80fd\u5b9e\u73b0\u5e94\u7528\u7684\u4e2a\u6027");
        this.setDSLink("DEFAULT");
        this.setDataAccCtrlMode(1);
        this.setAuditMode(0);
        this.setUserTag("MODELV2");
        this.setUserTag2("CENTRALMODEL");
        if (this.isRegisterToDEModelGlobal()) {
            DEModelGlobal.registerDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSysPFPluginDEModel", (IDataEntityModel)this);
            this.getPSCoreSysModel().registerDataEntityModel(this);
        }
        this.prepareModels();
    }

    public PSCoreSysModel getPSCoreSysModel() {
        if (this.pSCoreSysModel == null) {
            try {
                this.pSCoreSysModel = (PSCoreSysModel)SysModelGlobal.getSystem((String)"net.ibizsys.pscore.srv.PSCoreSysModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCoreSysModel;
    }

    public ISystem getSystem() {
        return this.getPSCoreSysModel();
    }

    public PSSysPFPluginService getRealService() {
        if (this.pSSysPFPluginService == null) {
            try {
                this.pSSysPFPluginService = (PSSysPFPluginService)ServiceGlobal.getService((String)this.getServiceId());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysPFPluginService;
    }

    public IService getService() {
        return this.getRealService();
    }

    public String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSSysPFPluginService";
    }

    public PSSysPFPlugin createEntity() {
        return new PSSysPFPlugin();
    }

    protected void prepareDEFields() throws Exception {
        DEFSearchModeModel dEFSearchModeModel;
        PSDEFieldModel pSDEFieldModel;
        Object object = null;
        IDEFSearchMode iDEFSearchMode = null;
        object = this.createDEField("CODENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("21db484a9dd43d7c88460da2b711b277");
            pSDEFieldModel.setName("CODENAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4ee3\u7801\u6807\u8bc6");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("CodeName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u524d\u7aef\u6a21\u677f\u63d2\u4ef6\u7684\u4ee3\u7801\u6807\u8bc6\uff0c\u9700\u8981\u5728\u6240\u5728\u7684\u6a21\u578b\u57df\uff08\u7cfb\u7edf\u6a21\u5757\u6216\u7cfb\u7edf\uff09\u4e2d\u5177\u6709\u552f\u4e00\u6027");
            pSDEFieldModel.setValueRuleName("\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd");
            pSDEFieldModel.setLength(30);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_CODENAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_CODENAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CREATEDATE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("9622b4a785c38e99cd9a908565e0c482");
            pSDEFieldModel.setName("CREATEDATE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5efa\u7acb\u65f6\u95f4");
            pSDEFieldModel.setDataType("DATETIME");
            pSDEFieldModel.setStdDataType(5);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setPreDefinedType("CREATEDATE");
            pSDEFieldModel.setValueFormat("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS");
            pSDEFieldModel.setCodeName("CreateDate");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CREATEMAN");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("3eb90c1f38d1c0f60d677a124be20704");
            pSDEFieldModel.setName("CREATEMAN");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5efa\u7acb\u4eba");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setPreDefinedType("CREATEMAN");
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.SysOperatorCodeListModel");
            pSDEFieldModel.setCodeName("CreateMan");
            pSDEFieldModel.setLength(60);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DYNAMODELFLAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1f97f735dfc421a4a9e09f82f420f2f6");
            pSDEFieldModel.setName("DYNAMODELFLAG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u52a8\u6001\u6a21\u578b\u7c7b\u578b");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DynaModelTypeCodeListModel");
            pSDEFieldModel.setCodeName("DynaModelFlag");
            pSDEFieldModel.setUserTag("RESERVEMODELV2");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_DYNAMODELFLAG_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_DYNAMODELFLAG_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("EXTENDSTYLEONLY");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("3b97bee9c3d4ae439587af9c84fc8e01");
            pSDEFieldModel.setName("EXTENDSTYLEONLY");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4ec5\u6269\u5c55\u6837\u5f0f");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("ExtendStyleOnly");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("KEYWORDS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a44d83cd6a510c49525a05d260d034bf");
            pSDEFieldModel.setName("KEYWORDS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5173\u952e\u5b57");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Keywords");
            pSDEFieldModel.setLength(300);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("LOCKFLAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("380b06423f311d995a907fe3bf3ee01e");
            pSDEFieldModel.setName("LOCKFLAG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6a21\u578b\u9501\u6807\u5fd7");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ModelLockModeCodeListModel");
            pSDEFieldModel.setCodeName("LockFlag");
            pSDEFieldModel.setUserTag("RESERVEMODELV2");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MEMO");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c7a8d38437629d0ac2e52d1b8f956070");
            pSDEFieldModel.setName("MEMO");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5907\u6ce8");
            pSDEFieldModel.setDataType("LONGTEXT_1000");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Memo");
            pSDEFieldModel.setLength(4000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ORDERVALUE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("e169ed172bee5b9bfe4b56a3c426592b");
            pSDEFieldModel.setName("ORDERVALUE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6392\u5e8f\u503c");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("OrderValue");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PLUGINDESC");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("72b883f3d9f9529f2f39077d0ccdc7fa");
            pSDEFieldModel.setName("PLUGINDESC");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u63d2\u4ef6\u63cf\u8ff0");
            pSDEFieldModel.setDataType("LONGTEXT_1000");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("PluginDesc");
            pSDEFieldModel.setLength(4000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PLUGINMODEL");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a85f029f3f461b50977b4c955c3be1e0");
            pSDEFieldModel.setName("PLUGINMODEL");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u63d2\u4ef6\u6a21\u578b");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("PluginModel");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PLUGINPARAMS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7d26d566667e526a942d65c6404f6ebe");
            pSDEFieldModel.setName("PLUGINPARAMS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u63d2\u4ef6\u53c2\u6570");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("PluginParams");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PLUGINTAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f69f074f43d7bea6fc6907b5a0a804f4");
            pSDEFieldModel.setName("PLUGINTAG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u63d2\u4ef6\u6807\u8bc6");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("PluginTag");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u524d\u7aef\u6a21\u677f\u63d2\u4ef6\u7684\u6807\u8bb0\uff0c\u9700\u8981\u5728\u6240\u5728\u63d2\u4ef6\u7c7b\u578b\u4e2d\u5177\u6709\u552f\u4e00\u6027");
            pSDEFieldModel.setValueRuleName("\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd");
            pSDEFieldModel.setLength(30);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PLUGINTAG2");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("40b083f5471c3ea07dd1eb06d66094e4");
            pSDEFieldModel.setName("PLUGINTAG2");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u63d2\u4ef6\u6807\u8bc62");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("PluginTag2");
            pSDEFieldModel.setLength(500);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PLUGINTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("9fe9a995cdd4d8a38a2f37b7b9db8508");
            pSDEFieldModel.setName("PLUGINTYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u63d2\u4ef6\u7c7b\u578b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.PFPluginTypeCodeListModel");
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("PluginType");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u524d\u7aef\u6a21\u677f\u63d2\u4ef6\u7684\u7c7b\u578b");
            pSDEFieldModel.setLength(40);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PLUGINTYPE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PLUGINTYPE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PREVIEWHTML");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("e224f053c5decdb22ebb21e5bef266b4");
            pSDEFieldModel.setName("PREVIEWHTML");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9884\u89c8\u5185\u5bb9");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("PreviewHtml");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PREVIEWPSNDFILEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("586306d78515992b362a60b0a430ee60");
            pSDEFieldModel.setName("PREVIEWPSNDFILEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9884\u89c8\u7f51\u76d8\u6587\u4ef6\u6807\u8bc6");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("PreviewPSNDFileId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PREVIEWURL");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("960e07e4985cacadd9c447b0f75a6b86");
            pSDEFieldModel.setName("PREVIEWURL");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6548\u679c\u9884\u89c8\u8def\u5f84");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("PreviewUrl");
            pSDEFieldModel.setUserTag("RESERVEMODELV2");
            pSDEFieldModel.setLength(250);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDYNAINSTID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a758c74a5b984ac2c3e35c3b033f277a");
            pSDEFieldModel.setName("PSDYNAINSTID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("PSDYNAINSTID");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("PSDynaInstId");
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.setLength(60);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSMODULEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a22942bb72356148d56213fbc61b07db");
            pSDEFieldModel.setName("PSMODULEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u6a21\u5757");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSPFPLUGIN_PSMODULE_PSMODULEID");
            pSDEFieldModel.setLinkDEFName("PSMODULEID");
            pSDEFieldModel.setCodeName("PSModuleId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSMODULEID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSMODULEID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSMODULENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8cceaf015853c49499327b5091d4ea2b");
            pSDEFieldModel.setName("PSMODULENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u6a21\u5757");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSPFPLUGIN_PSMODULE_PSMODULEID");
            pSDEFieldModel.setLinkDEFName("PSMODULENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSModuleName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u524d\u7aef\u6a21\u677f\u63d2\u4ef6\u6240\u5728\u7684\u7cfb\u7edf\u6a21\u5757");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSMODULENAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSMODULENAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSMODULENAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSMODULENAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSPFPLUGINID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("99b72bf362d431161019c566890c5bdc");
            pSDEFieldModel.setName("PSPFPLUGINID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5e73\u53f0\u9884\u7f6e\u63d2\u4ef6");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSPFPLUGIN_PSPFPLUGIN_PSPFPLUGINID");
            pSDEFieldModel.setLinkDEFName("PSPFPLUGINID");
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("PSPFPluginId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSPFPLUGINID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSPFPLUGINID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSPFPLUGINNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("b88d4d30ce8eac9fc7b9bf0ec3c7215e");
            pSDEFieldModel.setName("PSPFPLUGINNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5e73\u53f0\u9884\u7f6e\u63d2\u4ef6");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSPFPLUGIN_PSPFPLUGIN_PSPFPLUGINID");
            pSDEFieldModel.setLinkDEFName("PSPFPLUGINNAME");
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("PSPFPluginName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u524d\u7aef\u6a21\u677f\u63d2\u4ef6\u6765\u6e90\u7684\u5e73\u53f0\u9884\u7f6e\u63d2\u4ef6");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSPFPLUGINNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSPFPLUGINNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSPFPLUGINNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSPFPLUGINNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSFILEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a5ec58c583efcea491a1448377be6d45");
            pSDEFieldModel.setName("PSSYSFILEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u6587\u4ef6\u6807\u8bc6");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("PSSysFileId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSPFPITEMPLSCNT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d46dfaf9907062f9f23e1aca19cc9216");
            pSDEFieldModel.setName("PSSYSPFPITEMPLSCNT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u5e94\u7528\u63d2\u4ef6\u6a21\u677f\u8ba1\u6570");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("PSSysPFPITemplsCnt");
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSPFPLUGINID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f00f89e64b5ea9f43a04321130f0e7ea");
            pSDEFieldModel.setName("PSSYSPFPLUGINID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u5e94\u7528\u63d2\u4ef6\u6807\u8bc6");
            pSDEFieldModel.setDataType("GUID");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setKeyDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("PSSysPFPluginId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSPFPLUGINNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("cf0306212177a79001d21f1d96c4cc9b");
            pSDEFieldModel.setName("PSSYSPFPLUGINNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u63d2\u4ef6\u540d\u79f0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setMajorDEField(true);
            pSDEFieldModel.setImportOrder(100);
            pSDEFieldModel.setCodeName("PSSysPFPluginName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u524d\u7aef\u6a21\u677f\u63d2\u4ef6\u7684\u540d\u79f0");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSPFPLUGINNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSPFPLUGINNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSPFPLUGINNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSPFPLUGINNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSTEMID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1a8ee4732c23814a17e8cde4f9612472");
            pSDEFieldModel.setName("PSSYSTEMID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSPFPLUGIN_PSSYSTEM_PSSYSTEMID");
            pSDEFieldModel.setLinkDEFName("PSSYSTEMID");
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("PSSystemId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSTEMID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSTEMID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSTEMNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a144a0cb8f94c186b37b8de2ae5f7811");
            pSDEFieldModel.setName("PSSYSTEMNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSPFPLUGIN_PSSYSTEM_PSSYSTEMID");
            pSDEFieldModel.setLinkDEFName("PSSYSTEMNAME");
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("PSSystemName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSTEMNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSTEMNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSTEMNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSTEMNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("REPDEFAULT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a79b4df44ab1dc8fd4ba9181a7b174cf");
            pSDEFieldModel.setName("REPDEFAULT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u66ff\u6362\u9ed8\u8ba4\u6837\u5f0f");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("RepDefault");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("RTOBJECTMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a0f84b1844caea836ee5fc5744ec2df9");
            pSDEFieldModel.setName("RTOBJECTMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8fd0\u884c\u65f6\u63d2\u4ef6\u6a21\u5f0f");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.PFPluginRTModeCodeListModel");
            pSDEFieldModel.setCodeName("RTObjectMode");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_RTOBJECTMODE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_RTOBJECTMODE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("RTOBJECTNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ceffbd14b35254265db73e5010501785");
            pSDEFieldModel.setName("RTOBJECTNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8fd0\u884c\u65f6\u63d2\u4ef6\u5b8c\u6574\u540d\u79f0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("RTObjectName");
            pSDEFieldModel.setLength(250);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("RTOBJECTREPO");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c1655d0c13100a06d55cc587e6650a3b");
            pSDEFieldModel.setName("RTOBJECTREPO");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8fd0\u884c\u65f6\u63d2\u4ef6\u4ed3\u5e93\u914d\u7f6e");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("RTObjectRepo");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("STUDIOICON");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8dbd7b0a19052563cf7171b5306b4983");
            pSDEFieldModel.setName("STUDIOICON");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5de5\u5177\u56fe\u6807");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("StudioIcon");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TEMPLATEFUNC");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("3bb6656b99e7e78071c459a17f8a43b1");
            pSDEFieldModel.setName("TEMPLATEFUNC");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6a21\u677f\u51fd\u6570\u96c6\u5408");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("TempalteFunc");
            pSDEFieldModel.setLength(500);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TEMPLATEMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c001ce3a05389b86f0db1bf836d51ae1");
            pSDEFieldModel.setName("TEMPLATEMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6a21\u677f\u6a21\u5f0f");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("TemplateMode");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_TEMPLATEMODE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_TEMPLATEMODE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("UPDATEDATE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0ebf5b3262ee7378fb1e2c43931023f1");
            pSDEFieldModel.setName("UPDATEDATE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u66f4\u65b0\u65f6\u95f4");
            pSDEFieldModel.setDataType("DATETIME");
            pSDEFieldModel.setStdDataType(5);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setPreDefinedType("UPDATEDATE");
            pSDEFieldModel.setValueFormat("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS");
            pSDEFieldModel.setCodeName("UpdateDate");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("UPDATEMAN");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7d4b62581f1cc59a24341c4dffaf1c25");
            pSDEFieldModel.setName("UPDATEMAN");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u66f4\u65b0\u4eba");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setPreDefinedType("UPDATEMAN");
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.SysOperatorCodeListModel");
            pSDEFieldModel.setCodeName("UpdateMan");
            pSDEFieldModel.setLength(60);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("USERCAT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("214fe165758903de2616b1c01c2a2421");
            pSDEFieldModel.setName("USERCAT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7528\u6237\u5206\u7c7b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ModelUserCatCodeListModel");
            pSDEFieldModel.setCodeName("UserCat");
            pSDEFieldModel.setLength(10);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_USERCAT_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_USERCAT_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("USERTAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("2c1defce47feb9728a868717ef8517da");
            pSDEFieldModel.setName("USERTAG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7528\u6237\u6807\u8bb0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("UserTag");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_USERTAG_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_USERTAG_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("USERTAG2");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("9e6f6d193c279bbfd8671a30f968254f");
            pSDEFieldModel.setName("USERTAG2");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7528\u6237\u6807\u8bb02");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("UserTag2");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_USERTAG2_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_USERTAG2_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("USERTAG3");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("2b5b5a1f30f50473cbc63656fc5e633e");
            pSDEFieldModel.setName("USERTAG3");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7528\u6237\u6807\u8bb03");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("UserTag3");
            pSDEFieldModel.setLength(50);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_USERTAG3_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_USERTAG3_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("USERTAG4");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f4350ca12802c8a9edc9ebe90ad343f8");
            pSDEFieldModel.setName("USERTAG4");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7528\u6237\u6807\u8bb04");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("UserTag4");
            pSDEFieldModel.setLength(50);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_USERTAG4_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_USERTAG4_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
    }

    @Override
    protected void onPrepareDEACModes() throws Exception {
        PSSysPFPluginDefaultACModel pSSysPFPluginDefaultACModel = new PSSysPFPluginDefaultACModel();
        pSSysPFPluginDefaultACModel.init((IDataEntity)this);
        this.registerDEACMode((IDEACMode)pSSysPFPluginDefaultACModel);
    }

    protected void prepareDEDBConfigs() throws Exception {
    }

    protected void prepareDEDataSets() throws Exception {
        PSSysPFPluginCurSysDSModel pSSysPFPluginCurSysDSModel = new PSSysPFPluginCurSysDSModel();
        pSSysPFPluginCurSysDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysDSModel);
        PSSysPFPluginCurSysACIDSModel pSSysPFPluginCurSysACIDSModel = new PSSysPFPluginCurSysACIDSModel();
        pSSysPFPluginCurSysACIDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysACIDSModel);
        PSSysPFPluginCurSysAppCounterDSModel pSSysPFPluginCurSysAppCounterDSModel = new PSSysPFPluginCurSysAppCounterDSModel();
        pSSysPFPluginCurSysAppCounterDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysAppCounterDSModel);
        PSSysPFPluginCurSysAppMenuDSModel pSSysPFPluginCurSysAppMenuDSModel = new PSSysPFPluginCurSysAppMenuDSModel();
        pSSysPFPluginCurSysAppMenuDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysAppMenuDSModel);
        PSSysPFPluginCurSysAppMenuItemDSModel pSSysPFPluginCurSysAppMenuItemDSModel = new PSSysPFPluginCurSysAppMenuItemDSModel();
        pSSysPFPluginCurSysAppMenuItemDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysAppMenuItemDSModel);
        PSSysPFPluginCurSysAppUILogicDSModel pSSysPFPluginCurSysAppUILogicDSModel = new PSSysPFPluginCurSysAppUILogicDSModel();
        pSSysPFPluginCurSysAppUILogicDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysAppUILogicDSModel);
        PSSysPFPluginCurSysAppUtilDSModel pSSysPFPluginCurSysAppUtilDSModel = new PSSysPFPluginCurSysAppUtilDSModel();
        pSSysPFPluginCurSysAppUtilDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysAppUtilDSModel);
        PSSysPFPluginCurSysAppValueRuleDSModel pSSysPFPluginCurSysAppValueRuleDSModel = new PSSysPFPluginCurSysAppValueRuleDSModel();
        pSSysPFPluginCurSysAppValueRuleDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysAppValueRuleDSModel);
        PSSysPFPluginCurSysCDVDSModel pSSysPFPluginCurSysCDVDSModel = new PSSysPFPluginCurSysCDVDSModel();
        pSSysPFPluginCurSysCDVDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysCDVDSModel);
        PSSysPFPluginCurSysCalendarDSModel pSSysPFPluginCurSysCalendarDSModel = new PSSysPFPluginCurSysCalendarDSModel();
        pSSysPFPluginCurSysCalendarDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysCalendarDSModel);
        PSSysPFPluginCurSysCalendarItemDSModel pSSysPFPluginCurSysCalendarItemDSModel = new PSSysPFPluginCurSysCalendarItemDSModel();
        pSSysPFPluginCurSysCalendarItemDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysCalendarItemDSModel);
        PSSysPFPluginCurSysChartAxisDSModel pSSysPFPluginCurSysChartAxisDSModel = new PSSysPFPluginCurSysChartAxisDSModel();
        pSSysPFPluginCurSysChartAxisDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysChartAxisDSModel);
        PSSysPFPluginCurSysChartCSDSModel pSSysPFPluginCurSysChartCSDSModel = new PSSysPFPluginCurSysChartCSDSModel();
        pSSysPFPluginCurSysChartCSDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysChartCSDSModel);
        PSSysPFPluginCurSysChartSeriesDSModel pSSysPFPluginCurSysChartSeriesDSModel = new PSSysPFPluginCurSysChartSeriesDSModel();
        pSSysPFPluginCurSysChartSeriesDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysChartSeriesDSModel);
        PSSysPFPluginCurSysCustomDSModel pSSysPFPluginCurSysCustomDSModel = new PSSysPFPluginCurSysCustomDSModel();
        pSSysPFPluginCurSysCustomDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysCustomDSModel);
        PSSysPFPluginCurSysDCRDSModel pSSysPFPluginCurSysDCRDSModel = new PSSysPFPluginCurSysDCRDSModel();
        pSSysPFPluginCurSysDCRDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysDCRDSModel);
        PSSysPFPluginCurSysDEDataExportDSModel pSSysPFPluginCurSysDEDataExportDSModel = new PSSysPFPluginCurSysDEDataExportDSModel();
        pSSysPFPluginCurSysDEDataExportDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysDEDataExportDSModel);
        PSSysPFPluginCurSysDEDataImportDSModel pSSysPFPluginCurSysDEDataImportDSModel = new PSSysPFPluginCurSysDEDataImportDSModel();
        pSSysPFPluginCurSysDEDataImportDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysDEDataImportDSModel);
        PSSysPFPluginCurSysDEFValueRuleDSModel pSSysPFPluginCurSysDEFValueRuleDSModel = new PSSysPFPluginCurSysDEFValueRuleDSModel();
        pSSysPFPluginCurSysDEFValueRuleDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysDEFValueRuleDSModel);
        PSSysPFPluginCurSysDEMethodDSModel pSSysPFPluginCurSysDEMethodDSModel = new PSSysPFPluginCurSysDEMethodDSModel();
        pSSysPFPluginCurSysDEMethodDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysDEMethodDSModel);
        PSSysPFPluginCurSysDEUIActionDSModel pSSysPFPluginCurSysDEUIActionDSModel = new PSSysPFPluginCurSysDEUIActionDSModel();
        pSSysPFPluginCurSysDEUIActionDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysDEUIActionDSModel);
        PSSysPFPluginCurSysDLRDSModel pSSysPFPluginCurSysDLRDSModel = new PSSysPFPluginCurSysDLRDSModel();
        pSSysPFPluginCurSysDLRDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysDLRDSModel);
        PSSysPFPluginCurSysDVIDSModel pSSysPFPluginCurSysDVIDSModel = new PSSysPFPluginCurSysDVIDSModel();
        pSSysPFPluginCurSysDVIDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysDVIDSModel);
        PSSysPFPluginCurSysDashboardDSModel pSSysPFPluginCurSysDashboardDSModel = new PSSysPFPluginCurSysDashboardDSModel();
        pSSysPFPluginCurSysDashboardDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysDashboardDSModel);
        PSSysPFPluginCurSysDataViewDSModel pSSysPFPluginCurSysDataViewDSModel = new PSSysPFPluginCurSysDataViewDSModel();
        pSSysPFPluginCurSysDataViewDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysDataViewDSModel);
        PSSysPFPluginCurSysECSDSModel pSSysPFPluginCurSysECSDSModel = new PSSysPFPluginCurSysECSDSModel();
        pSSysPFPluginCurSysECSDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysECSDSModel);
        PSSysPFPluginCurSysEFDSModel pSSysPFPluginCurSysEFDSModel = new PSSysPFPluginCurSysEFDSModel();
        pSSysPFPluginCurSysEFDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysEFDSModel);
        PSSysPFPluginCurSysFUCDSModel pSSysPFPluginCurSysFUCDSModel = new PSSysPFPluginCurSysFUCDSModel();
        pSSysPFPluginCurSysFUCDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysFUCDSModel);
        PSSysPFPluginCurSysGCRDSModel pSSysPFPluginCurSysGCRDSModel = new PSSysPFPluginCurSysGCRDSModel();
        pSSysPFPluginCurSysGCRDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysGCRDSModel);
        PSSysPFPluginCurSysGridDSModel pSSysPFPluginCurSysGridDSModel = new PSSysPFPluginCurSysGridDSModel();
        pSSysPFPluginCurSysGridDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysGridDSModel);
        PSSysPFPluginCurSysLIRDSModel pSSysPFPluginCurSysLIRDSModel = new PSSysPFPluginCurSysLIRDSModel();
        pSSysPFPluginCurSysLIRDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysLIRDSModel);
        PSSysPFPluginCurSysMapViewDSModel pSSysPFPluginCurSysMapViewDSModel = new PSSysPFPluginCurSysMapViewDSModel();
        pSSysPFPluginCurSysMapViewDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysMapViewDSModel);
        PSSysPFPluginCurSysMapViewItemDSModel pSSysPFPluginCurSysMapViewItemDSModel = new PSSysPFPluginCurSysMapViewItemDSModel();
        pSSysPFPluginCurSysMapViewItemDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysMapViewItemDSModel);
        PSSysPFPluginCurSysPCDSModel pSSysPFPluginCurSysPCDSModel = new PSSysPFPluginCurSysPCDSModel();
        pSSysPFPluginCurSysPCDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysPCDSModel);
        PSSysPFPluginCurSysPTBDSModel pSSysPFPluginCurSysPTBDSModel = new PSSysPFPluginCurSysPTBDSModel();
        pSSysPFPluginCurSysPTBDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysPTBDSModel);
        PSSysPFPluginCurSysPanelDSModel pSSysPFPluginCurSysPanelDSModel = new PSSysPFPluginCurSysPanelDSModel();
        pSSysPFPluginCurSysPanelDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysPanelDSModel);
        PSSysPFPluginCurSysPanelItemDSModel pSSysPFPluginCurSysPanelItemDSModel = new PSSysPFPluginCurSysPanelItemDSModel();
        pSSysPFPluginCurSysPanelItemDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysPanelItemDSModel);
        PSSysPFPluginCurSysSBDSModel pSSysPFPluginCurSysSBDSModel = new PSSysPFPluginCurSysSBDSModel();
        pSSysPFPluginCurSysSBDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysSBDSModel);
        PSSysPFPluginCurSysSBIDSModel pSSysPFPluginCurSysSBIDSModel = new PSSysPFPluginCurSysSBIDSModel();
        pSSysPFPluginCurSysSBIDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysSBIDSModel);
        PSSysPFPluginCurSysSFDSModel pSSysPFPluginCurSysSFDSModel = new PSSysPFPluginCurSysSFDSModel();
        pSSysPFPluginCurSysSFDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysSFDSModel);
        PSSysPFPluginCurSysTBDSModel pSSysPFPluginCurSysTBDSModel = new PSSysPFPluginCurSysTBDSModel();
        pSSysPFPluginCurSysTBDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysTBDSModel);
        PSSysPFPluginCurSysTBIDSModel pSSysPFPluginCurSysTBIDSModel = new PSSysPFPluginCurSysTBIDSModel();
        pSSysPFPluginCurSysTBIDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysTBIDSModel);
        PSSysPFPluginCurSysTitleBarDSModel pSSysPFPluginCurSysTitleBarDSModel = new PSSysPFPluginCurSysTitleBarDSModel();
        pSSysPFPluginCurSysTitleBarDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysTitleBarDSModel);
        PSSysPFPluginCurSysTreeDSModel pSSysPFPluginCurSysTreeDSModel = new PSSysPFPluginCurSysTreeDSModel();
        pSSysPFPluginCurSysTreeDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysTreeDSModel);
        PSSysPFPluginCurSysTreeExpBarDSModel pSSysPFPluginCurSysTreeExpBarDSModel = new PSSysPFPluginCurSysTreeExpBarDSModel();
        pSSysPFPluginCurSysTreeExpBarDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysTreeExpBarDSModel);
        PSSysPFPluginCurSysUEDSModel pSSysPFPluginCurSysUEDSModel = new PSSysPFPluginCurSysUEDSModel();
        pSSysPFPluginCurSysUEDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysUEDSModel);
        PSSysPFPluginCurSysULNDSModel pSSysPFPluginCurSysULNDSModel = new PSSysPFPluginCurSysULNDSModel();
        pSSysPFPluginCurSysULNDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysULNDSModel);
        PSSysPFPluginCurSysWithIconDSModel pSSysPFPluginCurSysWithIconDSModel = new PSSysPFPluginCurSysWithIconDSModel();
        pSSysPFPluginCurSysWithIconDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysWithIconDSModel);
        PSSysPFPluginCurSysWizardPanelDSModel pSSysPFPluginCurSysWizardPanelDSModel = new PSSysPFPluginCurSysWizardPanelDSModel();
        pSSysPFPluginCurSysWizardPanelDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginCurSysWizardPanelDSModel);
        PSSysPFPluginDashboardPartDSModel pSSysPFPluginDashboardPartDSModel = new PSSysPFPluginDashboardPartDSModel();
        pSSysPFPluginDashboardPartDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginDashboardPartDSModel);
        PSSysPFPluginDefaultDSModel pSSysPFPluginDefaultDSModel = new PSSysPFPluginDefaultDSModel();
        pSSysPFPluginDefaultDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysPFPluginDefaultDSModel);
    }

    protected void prepareDEDataQueries() throws Exception {
        PSSysPFPluginCurSysDQModel pSSysPFPluginCurSysDQModel = new PSSysPFPluginCurSysDQModel();
        pSSysPFPluginCurSysDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysDQModel);
        PSSysPFPluginCurSysACIDQModel pSSysPFPluginCurSysACIDQModel = new PSSysPFPluginCurSysACIDQModel();
        pSSysPFPluginCurSysACIDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysACIDQModel);
        PSSysPFPluginCurSysAppCounterDQModel pSSysPFPluginCurSysAppCounterDQModel = new PSSysPFPluginCurSysAppCounterDQModel();
        pSSysPFPluginCurSysAppCounterDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysAppCounterDQModel);
        PSSysPFPluginCurSysAppMenuDQModel pSSysPFPluginCurSysAppMenuDQModel = new PSSysPFPluginCurSysAppMenuDQModel();
        pSSysPFPluginCurSysAppMenuDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysAppMenuDQModel);
        PSSysPFPluginCurSysAppMenuItemDQModel pSSysPFPluginCurSysAppMenuItemDQModel = new PSSysPFPluginCurSysAppMenuItemDQModel();
        pSSysPFPluginCurSysAppMenuItemDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysAppMenuItemDQModel);
        PSSysPFPluginCurSysAppUILogicDQModel pSSysPFPluginCurSysAppUILogicDQModel = new PSSysPFPluginCurSysAppUILogicDQModel();
        pSSysPFPluginCurSysAppUILogicDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysAppUILogicDQModel);
        PSSysPFPluginCurSysAppUtilDQModel pSSysPFPluginCurSysAppUtilDQModel = new PSSysPFPluginCurSysAppUtilDQModel();
        pSSysPFPluginCurSysAppUtilDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysAppUtilDQModel);
        PSSysPFPluginCurSysAppValueRuleDQModel pSSysPFPluginCurSysAppValueRuleDQModel = new PSSysPFPluginCurSysAppValueRuleDQModel();
        pSSysPFPluginCurSysAppValueRuleDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysAppValueRuleDQModel);
        PSSysPFPluginCurSysCDVDQModel pSSysPFPluginCurSysCDVDQModel = new PSSysPFPluginCurSysCDVDQModel();
        pSSysPFPluginCurSysCDVDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysCDVDQModel);
        PSSysPFPluginCurSysCalendarDQModel pSSysPFPluginCurSysCalendarDQModel = new PSSysPFPluginCurSysCalendarDQModel();
        pSSysPFPluginCurSysCalendarDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysCalendarDQModel);
        PSSysPFPluginCurSysCalendarItemDQModel pSSysPFPluginCurSysCalendarItemDQModel = new PSSysPFPluginCurSysCalendarItemDQModel();
        pSSysPFPluginCurSysCalendarItemDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysCalendarItemDQModel);
        PSSysPFPluginCurSysChartAxisDQModel pSSysPFPluginCurSysChartAxisDQModel = new PSSysPFPluginCurSysChartAxisDQModel();
        pSSysPFPluginCurSysChartAxisDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysChartAxisDQModel);
        PSSysPFPluginCurSysChartCSDQModel pSSysPFPluginCurSysChartCSDQModel = new PSSysPFPluginCurSysChartCSDQModel();
        pSSysPFPluginCurSysChartCSDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysChartCSDQModel);
        PSSysPFPluginCurSysChartSeriesDQModel pSSysPFPluginCurSysChartSeriesDQModel = new PSSysPFPluginCurSysChartSeriesDQModel();
        pSSysPFPluginCurSysChartSeriesDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysChartSeriesDQModel);
        PSSysPFPluginCurSysCustomDQModel pSSysPFPluginCurSysCustomDQModel = new PSSysPFPluginCurSysCustomDQModel();
        pSSysPFPluginCurSysCustomDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysCustomDQModel);
        PSSysPFPluginCurSysDCRDQModel pSSysPFPluginCurSysDCRDQModel = new PSSysPFPluginCurSysDCRDQModel();
        pSSysPFPluginCurSysDCRDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysDCRDQModel);
        PSSysPFPluginCurSysDEDataExportDQModel pSSysPFPluginCurSysDEDataExportDQModel = new PSSysPFPluginCurSysDEDataExportDQModel();
        pSSysPFPluginCurSysDEDataExportDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysDEDataExportDQModel);
        PSSysPFPluginCurSysDEDataImportDQModel pSSysPFPluginCurSysDEDataImportDQModel = new PSSysPFPluginCurSysDEDataImportDQModel();
        pSSysPFPluginCurSysDEDataImportDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysDEDataImportDQModel);
        PSSysPFPluginCurSysDEFValueRuleDQModel pSSysPFPluginCurSysDEFValueRuleDQModel = new PSSysPFPluginCurSysDEFValueRuleDQModel();
        pSSysPFPluginCurSysDEFValueRuleDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysDEFValueRuleDQModel);
        PSSysPFPluginCurSysDEMethodDQModel pSSysPFPluginCurSysDEMethodDQModel = new PSSysPFPluginCurSysDEMethodDQModel();
        pSSysPFPluginCurSysDEMethodDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysDEMethodDQModel);
        PSSysPFPluginCurSysDEUIActionDQModel pSSysPFPluginCurSysDEUIActionDQModel = new PSSysPFPluginCurSysDEUIActionDQModel();
        pSSysPFPluginCurSysDEUIActionDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysDEUIActionDQModel);
        PSSysPFPluginCurSysDLRDQModel pSSysPFPluginCurSysDLRDQModel = new PSSysPFPluginCurSysDLRDQModel();
        pSSysPFPluginCurSysDLRDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysDLRDQModel);
        PSSysPFPluginCurSysDVIDQModel pSSysPFPluginCurSysDVIDQModel = new PSSysPFPluginCurSysDVIDQModel();
        pSSysPFPluginCurSysDVIDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysDVIDQModel);
        PSSysPFPluginCurSysDashboardDQModel pSSysPFPluginCurSysDashboardDQModel = new PSSysPFPluginCurSysDashboardDQModel();
        pSSysPFPluginCurSysDashboardDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysDashboardDQModel);
        PSSysPFPluginCurSysDashboardPartDQModel pSSysPFPluginCurSysDashboardPartDQModel = new PSSysPFPluginCurSysDashboardPartDQModel();
        pSSysPFPluginCurSysDashboardPartDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysDashboardPartDQModel);
        PSSysPFPluginCurSysDataViewDQModel pSSysPFPluginCurSysDataViewDQModel = new PSSysPFPluginCurSysDataViewDQModel();
        pSSysPFPluginCurSysDataViewDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysDataViewDQModel);
        PSSysPFPluginCurSysECSDQModel pSSysPFPluginCurSysECSDQModel = new PSSysPFPluginCurSysECSDQModel();
        pSSysPFPluginCurSysECSDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysECSDQModel);
        PSSysPFPluginCurSysEFDQModel pSSysPFPluginCurSysEFDQModel = new PSSysPFPluginCurSysEFDQModel();
        pSSysPFPluginCurSysEFDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysEFDQModel);
        PSSysPFPluginCurSysFUCDQModel pSSysPFPluginCurSysFUCDQModel = new PSSysPFPluginCurSysFUCDQModel();
        pSSysPFPluginCurSysFUCDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysFUCDQModel);
        PSSysPFPluginCurSysGCRDQModel pSSysPFPluginCurSysGCRDQModel = new PSSysPFPluginCurSysGCRDQModel();
        pSSysPFPluginCurSysGCRDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysGCRDQModel);
        PSSysPFPluginCurSysGridDQModel pSSysPFPluginCurSysGridDQModel = new PSSysPFPluginCurSysGridDQModel();
        pSSysPFPluginCurSysGridDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysGridDQModel);
        PSSysPFPluginCurSysLIRDQModel pSSysPFPluginCurSysLIRDQModel = new PSSysPFPluginCurSysLIRDQModel();
        pSSysPFPluginCurSysLIRDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysLIRDQModel);
        PSSysPFPluginCurSysMapViewDQModel pSSysPFPluginCurSysMapViewDQModel = new PSSysPFPluginCurSysMapViewDQModel();
        pSSysPFPluginCurSysMapViewDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysMapViewDQModel);
        PSSysPFPluginCurSysMapViewItemDQModel pSSysPFPluginCurSysMapViewItemDQModel = new PSSysPFPluginCurSysMapViewItemDQModel();
        pSSysPFPluginCurSysMapViewItemDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysMapViewItemDQModel);
        PSSysPFPluginCurSysPCDQModel pSSysPFPluginCurSysPCDQModel = new PSSysPFPluginCurSysPCDQModel();
        pSSysPFPluginCurSysPCDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysPCDQModel);
        PSSysPFPluginCurSysPTBDQModel pSSysPFPluginCurSysPTBDQModel = new PSSysPFPluginCurSysPTBDQModel();
        pSSysPFPluginCurSysPTBDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysPTBDQModel);
        PSSysPFPluginCurSysPanelDQModel pSSysPFPluginCurSysPanelDQModel = new PSSysPFPluginCurSysPanelDQModel();
        pSSysPFPluginCurSysPanelDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysPanelDQModel);
        PSSysPFPluginCurSysPanelItemDQModel pSSysPFPluginCurSysPanelItemDQModel = new PSSysPFPluginCurSysPanelItemDQModel();
        pSSysPFPluginCurSysPanelItemDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysPanelItemDQModel);
        PSSysPFPluginCurSysSBDQModel pSSysPFPluginCurSysSBDQModel = new PSSysPFPluginCurSysSBDQModel();
        pSSysPFPluginCurSysSBDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysSBDQModel);
        PSSysPFPluginCurSysSBIDQModel pSSysPFPluginCurSysSBIDQModel = new PSSysPFPluginCurSysSBIDQModel();
        pSSysPFPluginCurSysSBIDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysSBIDQModel);
        PSSysPFPluginCurSysSFDQModel pSSysPFPluginCurSysSFDQModel = new PSSysPFPluginCurSysSFDQModel();
        pSSysPFPluginCurSysSFDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysSFDQModel);
        PSSysPFPluginCurSysTBDQModel pSSysPFPluginCurSysTBDQModel = new PSSysPFPluginCurSysTBDQModel();
        pSSysPFPluginCurSysTBDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysTBDQModel);
        PSSysPFPluginCurSysTBIDQModel pSSysPFPluginCurSysTBIDQModel = new PSSysPFPluginCurSysTBIDQModel();
        pSSysPFPluginCurSysTBIDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysTBIDQModel);
        PSSysPFPluginCurSysTitleBarDQModel pSSysPFPluginCurSysTitleBarDQModel = new PSSysPFPluginCurSysTitleBarDQModel();
        pSSysPFPluginCurSysTitleBarDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysTitleBarDQModel);
        PSSysPFPluginCurSysTreeDQModel pSSysPFPluginCurSysTreeDQModel = new PSSysPFPluginCurSysTreeDQModel();
        pSSysPFPluginCurSysTreeDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysTreeDQModel);
        PSSysPFPluginCurSysTreeExpBarDQModel pSSysPFPluginCurSysTreeExpBarDQModel = new PSSysPFPluginCurSysTreeExpBarDQModel();
        pSSysPFPluginCurSysTreeExpBarDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysTreeExpBarDQModel);
        PSSysPFPluginCurSysUEDQModel pSSysPFPluginCurSysUEDQModel = new PSSysPFPluginCurSysUEDQModel();
        pSSysPFPluginCurSysUEDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysUEDQModel);
        PSSysPFPluginCurSysULNDQModel pSSysPFPluginCurSysULNDQModel = new PSSysPFPluginCurSysULNDQModel();
        pSSysPFPluginCurSysULNDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysULNDQModel);
        PSSysPFPluginCurSysWithIconDQModel pSSysPFPluginCurSysWithIconDQModel = new PSSysPFPluginCurSysWithIconDQModel();
        pSSysPFPluginCurSysWithIconDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysWithIconDQModel);
        PSSysPFPluginCurSysWizardPanelDQModel pSSysPFPluginCurSysWizardPanelDQModel = new PSSysPFPluginCurSysWizardPanelDQModel();
        pSSysPFPluginCurSysWizardPanelDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginCurSysWizardPanelDQModel);
        PSSysPFPluginDefaultDQModel pSSysPFPluginDefaultDQModel = new PSSysPFPluginDefaultDQModel();
        pSSysPFPluginDefaultDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysPFPluginDefaultDQModel);
    }

    protected void prepareDEActions() throws Exception {
    }

    protected void prepareDELogics() throws Exception {
    }

    @Override
    protected void onPrepareDEUIActions() throws Exception {
    }

    protected void prepareDEWFs() throws Exception {
    }

    protected void prepareDEUniStates() throws Exception {
    }

    protected void prepareDEMainStates() throws Exception {
    }

    protected void prepareDEDataSyncs() throws Exception {
    }

    @Override
    protected void onPreparePDTDEViews() throws Exception {
        this.registerPDTDEView("EDITVIEW", "fc473ca7e3094cfa537ae57affda26bd");
        this.registerPDTDEView("MPICKUPVIEW", "2b3aaac3fa89cfb59f35031e4bf68c39");
        this.registerPDTDEView("PICKUPVIEW", "786b8951da3997509305bb0b3ff7071a");
        this.registerPDTDEView("REDIRECTVIEW", "ff793db09b36ea5de9d9965d7212ad97");
    }

    protected void prepareDEOPPrivTagMaps() throws Exception {
    }

    protected void prepareDEPrints() throws Exception {
    }

    protected void prepareDEReports() throws Exception {
    }

    protected void prepareDEDataExports() throws Exception {
    }

    protected void prepareDEActionWizards() throws Exception {
    }

    protected void prepareDEActionWizardGroups() throws Exception {
    }

    protected void prepareDEBATables() throws Exception {
    }

    protected void prepareDEUserRoles() throws Exception {
    }

    protected void prepareDEOPPrivRoles() throws Exception {
    }

    protected void onFillFetchQuickSearchConditions(DEDataSetCond dEDataSetCond, String string) throws Exception {
        super.onFillFetchQuickSearchConditions(dEDataSetCond, string);
        DEDataSetCond dEDataSetCond2 = new DEDataSetCond();
        dEDataSetCond2.setCondType("DEFIELD");
        dEDataSetCond2.setCondOp("LIKE");
        dEDataSetCond2.setDEFName("PSSYSPFPLUGINNAME");
        dEDataSetCond2.setCondValue(string);
        dEDataSetCond.addChildDEDataQueryCond((IDEDataQueryCodeCond)dEDataSetCond2);
    }

    @Override
    protected void onPreparePSDEFGroupModels() throws Exception {
        IPSDEFGroupModel iPSDEFGroupModel = this.preparePSDEFGroupModel__DEFAULT();
        if (iPSDEFGroupModel != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel__DEFAULT() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("_DEFAULT");
        pSDEFGroupModel.setName("\u901a\u7528");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("21db484a9dd43d7c88460da2b711b277");
        pSDEFGroupDetailModel.setName("CODENAME");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("CODENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u524d\u7aef\u6a21\u677f\u63d2\u4ef6\u7684\u4ee3\u7801\u6807\u8bc6\uff0c\u9700\u8981\u5728\u6240\u5728\u7684\u6a21\u578b\u57df\uff08\u7cfb\u7edf\u6a21\u5757\u6216\u7cfb\u7edf\uff09\u4e2d\u5177\u6709\u552f\u4e00\u6027");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a44d83cd6a510c49525a05d260d034bf");
        pSDEFGroupDetailModel.setName("KEYWORDS");
        iPSDEFieldModel = this.getDEField("KEYWORDS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("380b06423f311d995a907fe3bf3ee01e");
        pSDEFGroupDetailModel.setName("LOCKFLAG");
        iPSDEFieldModel = this.getDEField("LOCKFLAG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ModelLockModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c7a8d38437629d0ac2e52d1b8f956070");
        pSDEFGroupDetailModel.setName("MEMO");
        iPSDEFieldModel = this.getDEField("MEMO", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a22942bb72356148d56213fbc61b07db");
        pSDEFGroupDetailModel.setName("PSMODULEID");
        iPSDEFieldModel = this.getDEField("PSMODULEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u524d\u7aef\u6a21\u677f\u63d2\u4ef6\u6240\u5728\u7684\u7cfb\u7edf\u6a21\u5757");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8cceaf015853c49499327b5091d4ea2b");
        pSDEFGroupDetailModel.setName("PSMODULENAME");
        iPSDEFieldModel = this.getDEField("PSMODULENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u524d\u7aef\u6a21\u677f\u63d2\u4ef6\u6240\u5728\u7684\u7cfb\u7edf\u6a21\u5757");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("99b72bf362d431161019c566890c5bdc");
        pSDEFGroupDetailModel.setName("PSPFPLUGINID");
        iPSDEFieldModel = this.getDEField("PSPFPLUGINID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u524d\u7aef\u6a21\u677f\u63d2\u4ef6\u6765\u6e90\u7684\u5e73\u53f0\u9884\u7f6e\u63d2\u4ef6");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("b88d4d30ce8eac9fc7b9bf0ec3c7215e");
        pSDEFGroupDetailModel.setName("PSPFPLUGINNAME");
        iPSDEFieldModel = this.getDEField("PSPFPLUGINNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u524d\u7aef\u6a21\u677f\u63d2\u4ef6\u6765\u6e90\u7684\u5e73\u53f0\u9884\u7f6e\u63d2\u4ef6");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("cf0306212177a79001d21f1d96c4cc9b");
        pSDEFGroupDetailModel.setName("PSSYSPFPLUGINNAME");
        iPSDEFieldModel = this.getDEField("PSSYSPFPLUGINNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u524d\u7aef\u6a21\u677f\u63d2\u4ef6\u7684\u540d\u79f0");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1a8ee4732c23814a17e8cde4f9612472");
        pSDEFGroupDetailModel.setName("PSSYSTEMID");
        iPSDEFieldModel = this.getDEField("PSSYSTEMID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a144a0cb8f94c186b37b8de2ae5f7811");
        pSDEFGroupDetailModel.setName("PSSYSTEMNAME");
        iPSDEFieldModel = this.getDEField("PSSYSTEMNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("72b883f3d9f9529f2f39077d0ccdc7fa");
        pSDEFGroupDetailModel.setName("PLUGINDESC");
        iPSDEFieldModel = this.getDEField("PLUGINDESC", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("f69f074f43d7bea6fc6907b5a0a804f4");
        pSDEFGroupDetailModel.setName("PLUGINTAG");
        iPSDEFieldModel = this.getDEField("PLUGINTAG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u524d\u7aef\u6a21\u677f\u63d2\u4ef6\u7684\u6807\u8bb0\uff0c\u9700\u8981\u5728\u6240\u5728\u63d2\u4ef6\u7c7b\u578b\u4e2d\u5177\u6709\u552f\u4e00\u6027");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("9fe9a995cdd4d8a38a2f37b7b9db8508");
        pSDEFGroupDetailModel.setName("PLUGINTYPE");
        iPSDEFieldModel = this.getDEField("PLUGINTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.PFPluginTypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u524d\u7aef\u6a21\u677f\u63d2\u4ef6\u7684\u7c7b\u578b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("960e07e4985cacadd9c447b0f75a6b86");
        pSDEFGroupDetailModel.setName("PREVIEWURL");
        iPSDEFieldModel = this.getDEField("PREVIEWURL", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }
}

