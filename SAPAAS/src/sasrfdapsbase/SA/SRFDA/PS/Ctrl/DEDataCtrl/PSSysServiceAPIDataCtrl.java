/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.codelist.DevSysActionCodeListModel
 *  net.ibizsys.pscore.srv.codelist.DevSysStateCodeListModel
 *  net.ibizsys.pscore.srv.codelist.SysDevBKTaskStateCodeListModel
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEAction
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDER
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDESADetail
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEServiceAPI
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity
 *  net.ibizsys.pscore.srv.dedesign.service.PSDERService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDESADetailService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEServiceAPIService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDESARS
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysAPI
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPI
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPIBase
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystem
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase
 *  net.ibizsys.pscore.srv.sysdesign.service.PSDESARSService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysAPIService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIService
 *  net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevBKTask
 *  net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevBKTaskService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskWork;
import SA.SRFDA.PS.Core.DevStudio.PSBKTaskWorkHelper;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSSysServiceAPI;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.codelist.DevSysActionCodeListModel;
import net.ibizsys.pscore.srv.codelist.DevSysStateCodeListModel;
import net.ibizsys.pscore.srv.codelist.SysDevBKTaskStateCodeListModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESADetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEServiceAPI;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.dedesign.service.PSDESADetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEServiceAPIService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDESARS;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPIBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDESARSService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevBKTask;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevBKTaskService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSSysServiceAPIDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSSysServiceAPIDataCtrl.class);
    public static final String CUSTOMCALL_ADDSYNCCLIENTMODELTASK = "ADDSYNCCLIENTMODELTASK";
    public static final String CUSTOMCALL_INITSTUDIOAPI = "INITSTUDIOAPI";

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_ADDSYNCCLIENTMODELTASK, (boolean)true) == 0) {
            return this.addSyncServiceAPIClientModelTask(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_INITSTUDIOAPI, (boolean)true) == 0) {
            return this.initStudioAPI(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult addSyncServiceAPIClientModelTask(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSSysServiceAPI psSysServiceAPI = new PSSysServiceAPI();
            psSysServiceAPI.proxy(dataEntity);
            this.onAddSyncServiceAPIClientModelTask(psSysServiceAPI);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5efa\u7acb\u540c\u6b65\u670d\u52a1\u63a5\u53e3\u5ba2\u6237\u90fd\u6a21\u578b\u4efb\u52a1\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onAddSyncServiceAPIClientModelTask(PSSysServiceAPI psSysServiceAPI) throws Exception {
        IPSSystem iPSSystem = null;
        String strPSDevSlnSysId = psSysServiceAPI.getParamStringValue("PSDEVSLNSYSID", "");
        PSDevSlnSysAPIService psDevSlnSysAPIService = (PSDevSlnSysAPIService)ServiceGlobal.getService(PSDevSlnSysAPIService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevSlnSysAPI psDevSlnSysAPI = new PSDevSlnSysAPI();
        psDevSlnSysAPI.setPSDevSlnSysId(strPSDevSlnSysId);
        psDevSlnSysAPI.setPSSysServiceAPIId(psSysServiceAPI.getPSSYSSERVICEAPIID());
        if (!psDevSlnSysAPIService.select(psDevSlnSysAPI, true)) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7684\u5f00\u53d1\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3"));
        }
        ArrayList<PSDevSlnSys> psDevSlnSysList = new ArrayList<PSDevSlnSys>();
        if (psDevSlnSysAPI.getPSDevSlnSys() != null) {
            psDevSlnSysList.add(psDevSlnSysAPI.getPSDevSlnSys());
        }
        if (psDevSlnSysAPI.getClientPSDevSlnSys() != null) {
            psDevSlnSysList.add(psDevSlnSysAPI.getClientPSDevSlnSys());
        }
        if (psDevSlnSysAPI.getClient2PSDevSlnSys() != null) {
            psDevSlnSysList.add(psDevSlnSysAPI.getClient2PSDevSlnSys());
        }
        for (PSDevSlnSys psDevSlnSys : psDevSlnSysList) {
            if (DataObject.getBoolValue((Integer)psDevSlnSys.getShareFlag(), (boolean)false)) {
                throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u4e3a\u5171\u4eab\u6a21\u578b\u7cfb\u7edf\uff0c\u65e0\u6cd5\u5efa\u7acb\u5907\u4efd\u4efb\u52a1", (Object)psDevSlnSys.getPSDevSlnSysName()));
            }
            if (DataObject.getIntegerValue((Object)psDevSlnSys.getDevSysState(), (Integer)30) != 30) {
                throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u5f53\u524d\u72b6\u6001[%2$s]\uff0c\u65e0\u6cd5\u5efa\u7acb\u5907\u4efd\u4efb\u52a1", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)DevSysStateCodeListModel.getInstance().getCodeItem(psDevSlnSys.getDevSysState().toString()).getText()));
            }
            if (StringHelper.IsNullOrEmpty((String)psDevSlnSys.getCurAction()) || StringHelper.Compare((String)psDevSlnSys.getCurAction(), (String)"NONE", (boolean)true) == 0) continue;
            throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u6b63\u5728\u8fdb\u884c[%2$s]\u64cd\u4f5c\uff0c\u65e0\u6cd5\u5efa\u7acb\u5907\u4efd\u4efb\u52a1", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)DevSysActionCodeListModel.getInstance().getCodeItem(psDevSlnSys.getCurAction()).getText()));
        }
        IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(strPSDevSlnSysId);
        PSSysServiceAPIService psSysServiceAPIService = (PSSysServiceAPIService)ServiceGlobal.getService(PSSysServiceAPIService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)iPSDevSlnSys.getPSSysModelInstId()));
        net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPI psSysServiceAPI2 = new net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPI();
        psSysServiceAPI2.setPSSysServiceAPIId(psSysServiceAPI.getPSSYSSERVICEAPIID());
        psSysServiceAPIService.get(psSysServiceAPI2);
        iPSSystem = iPSDevSlnSys.getPSSystem(false);
        PSSysDevBKTask psSysDevBKTask = new PSSysDevBKTask();
        psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u540c\u6b65\u670d\u52a1\u63a5\u53e3[%1$s]\u5ba2\u6237\u7aef\u6a21\u578b", (Object)psSysServiceAPI2.getPSSysServiceAPIName()));
        psSysDevBKTask.setPSDevSlnSysId(strPSDevSlnSysId);
        if (PSTaskServerEnvImpl.getCurrent() != null) {
            psSysDevBKTask.setPSTaskServerId(PSTaskServerEnvImpl.getCurrent().getId());
            psSysDevBKTask.setPSTaskServerName(PSTaskServerEnvImpl.getCurrent().getName());
        }
        psSysDevBKTask.setPSSysModelInstId(iPSDevSlnSys.getPSSysModelInstId());
        psSysDevBKTask.setTaskType("SYNCSERVICEAPICLIENTMODEL");
        psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
        psSysDevBKTask.setPSSystemId(iPSSystem.getId());
        psSysDevBKTask.setPSSystemName(iPSSystem.getName());
        psSysDevBKTask.setTaskParam(psSysServiceAPI.getPSSYSSERVICEAPIID());
        psSysDevBKTask.setModelLevel(IPSSystem.LOADLEVEL_CODE);
        PSSysDevBKTaskService psSysDevBKTaskService = (PSSysDevBKTaskService)ServiceGlobal.getService(PSSysDevBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)iPSDevSlnSys.getPSSysModelInstId()));
        psSysDevBKTaskService.create(psSysDevBKTask);
        SA.SRFDA.PS.Data.PSSysDevBKTask psSysDevBKTask2 = new SA.SRFDA.PS.Data.PSSysDevBKTask();
        PSSysServiceAPIDataCtrl.convertEntity((IEntity)psSysDevBKTask, psSysDevBKTask2);
        this.getPSModelStorage().getPSSysDevBKTaskGlobal().addPSSysDevBKTask(psSysDevBKTask2);
    }

    public CallResult initStudioAPI(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final BaseDataEntity dataEntity2 = dataEntity;
            PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

                @Override
                public void execute(Object obj) throws Exception {
                    PSSysServiceAPIDataCtrl.this.onInitStudioAPI(dataEntity2);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316StudioAPI\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onInitStudioAPI(BaseDataEntity dataEntity) throws Exception {
        net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPI psSysServiceAPI = new net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPI();
        PSDEDataCtrl.convertEntity2(dataEntity, (IEntity)psSysServiceAPI);
        PSSysServiceAPIService psSysServiceAPIService = (PSSysServiceAPIService)ServiceGlobal.getService(PSSysServiceAPIService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        psSysServiceAPIService.get(psSysServiceAPI);
        HashMap<String, String> dataMap = new HashMap<String, String>();
        dataMap.put("PSSYSUNISTATE", "T_SRFPSSYSUNISTATE");
        dataMap.put("PSSYSERMAP", "T_SRFPSSYSERMAP");
        dataMap.put("PSSYSVIEWLOGIC", "T_SRFPSSYSVIEWLOGIC");
        dataMap.put("PSDEFIELD", "T_SRFPSDEFIELD");
        dataMap.put("PSPANELLOGICNODE", "T_SRFPSPANELLOGICNODE");
        dataMap.put("PSDELNPARAM", "T_SRFPSDELNPARAM");
        dataMap.put("PSAPPUTIL", "T_SRFPSAPPUTIL");
        dataMap.put("PSSYSDMITEM", "T_SRFPSSYSDMITEM");
        dataMap.put("PSSYSUSERMODE", "T_SRFPSSYSUSERMODE");
        dataMap.put("PSSYSTESTDATA", "T_SRFPSSYSTESTDATA");
        dataMap.put("PSSYSDBPART", "T_SRFPSSYSDBPART");
        dataMap.put("PSSYSSFCODE", "T_SRFPSSYSSFCODE");
        dataMap.put("PSCODELIST", "T_SRFPSCODELIST");
        dataMap.put("PSSUBSYSSERVICEAPI", "T_SRFPSSUBSYSSERVICEAPI");
        dataMap.put("PSDECHARTAXES", "T_SRFPSDECHARTAXES");
        dataMap.put("PSDEFDLOGIC", "T_SRFPSDEFDLOGIC");
        dataMap.put("PSSYSSERVICEAPI", "T_SRFPSSYSSERVICEAPI");
        dataMap.put("PSSYSWFMODE", "T_SRFPSSYSWFMODE");
        dataMap.put("PSSYSTEMMQ", "T_SRFPSSYSTEMMQ");
        dataMap.put("PSPANELITEMLOGIC", "T_SRFPSPANELITEMLOGIC");
        dataMap.put("PSDESAMPLEDATA", "T_SRFPSDESAMPLEDATA");
        dataMap.put("PSLANGUAGERES", "T_SRFPSLANGUAGERES");
        dataMap.put("PSDEUAGROUP", "T_SRFPSDEUAGROUP");
        dataMap.put("PSWXMENU", "T_SRFPSWXMENU");
        dataMap.put("PSSYSVALUERULE", "T_SRFPSSYSVALUERULE");
        dataMap.put("PSDEACTIONWIZARD", "T_SRFPSDEACTIONWIZARD");
        dataMap.put("PSDEACTIONLOGIC", "T_SRFPSDEACTIONLOGIC");
        dataMap.put("PSSYSPORTLET", "T_SRFPSSYSPORTLET");
        dataMap.put("PSDETOOLBAR", "T_SRFPSDETOOLBAR");
        dataMap.put("PSSYSTEMAS", "T_SRFPSSYSTEMAS");
        dataMap.put("PSDETOOLBAR", "T_SRFPSDETOOLBAR");
        dataMap.put("PSSYSBDTABLE", "T_SRFPSSYSBDTABLE");
        dataMap.put("PSDEACTION", "T_SRFPSDEACTION");
        dataMap.put("PSSYSBDCOLSET", "T_SRFPSSYSBDCOLSET");
        dataMap.put("PSSYSUTILDE", "T_SRFPSSYSUTILDE");
        dataMap.put("PSDEGEIUPDATE", "T_SRFPSDEGEIUPDATE");
        dataMap.put("PSDEACTIONPARAM", "T_SRFPSDEACTIONPARAM");
        dataMap.put("PSSYSMSGTEMPL", "T_SRFPSSYSMSGTEMPL");
        dataMap.put("PSDEWIZARD", "T_SRFPSDEWIZARD");
        dataMap.put("PSSYSDBTABLE", "T_SRFPSSYSDBTABLE");
        dataMap.put("PSDEMAPACTION", "T_SRFPSDEMAPACTION");
        dataMap.put("PSDELIST", "T_SRFPSDELIST");
        dataMap.put("PSDETREENODERV", "T_SRFPSDETREENODERV");
        dataMap.put("PSAPPFUNC", "T_SRFPSAPPFUNC");
        dataMap.put("PSSYSSEARCHBARITEM", "T_SRFPSSYSSEARCHBARITEM");
        dataMap.put("PSSYSVIEWPANELITEM", "T_SRFPSSYSVIEWPANELITEM");
        dataMap.put("PSSYSSFPLUGIN", "T_SRFPSSYSSFPLUGIN");
        dataMap.put("PSDETREENODERS", "T_SRFPSDETREENODERS");
        dataMap.put("PSDEFSFITEM", "T_SRFPSDEFSFITEM");
        dataMap.put("PSSYSUSERDR", "T_SRFPSSYSUSERDR");
        dataMap.put("PSSYSCOUNTER", "T_SRFPSSYSCOUNTER");
        dataMap.put("PSSYSWFMODE", "T_SRFPSSYSWFMODE");
        dataMap.put("PSSYSDATASYNCAGENT", "T_SRFPSSYSDATASYNCAGENT");
        dataMap.put("PSSYSCALENDARITEM", "T_SRFPSSYSCALENDARITEM");
        dataMap.put("PSAPPUISTYLE", "T_SRFPSAPPUISTYLE");
        dataMap.put("PSDEFDLOGIC", "T_SRFPSDEFDLOGIC");
        dataMap.put("PSSYSSQLCMD", "T_SRFPSSYSSQLCMD");
        dataMap.put("PSDEACTIONTEMPL", "T_SRFPSDEACTIONTEMPL");
        dataMap.put("PSAPPMENU", "T_SRFPSAPPMENU");
        dataMap.put("PSDEWIZARDFORM", "T_SRFPSDEWIZARDFORM");
        dataMap.put("PSAPPLOCALDE", "T_SRFPSAPPLOCALDE");
        dataMap.put("PSDEACMODEITEM", "T_SRFPSDEACMODEITEM");
        dataMap.put("PSWXMENUITEM", "T_SRFPSWXMENUITEM");
        dataMap.put("PSSYSBDPART", "T_SRFPSSYSBDPART");
        dataMap.put("PSWFLINKCOND", "T_SRFPSWFLINKCOND");
        dataMap.put("PSDEDRDETAIL", "T_SRFPSDEDRDETAIL");
        dataMap.put("PSDEFIUPDATE", "T_SRFPSDEFIUPDATE");
        dataMap.put("PSSYSDYNAMODEL", "T_SRFPSSYSDYNAMODEL");
        dataMap.put("PSDESADETAIL", "T_SRFPSDESADETAIL");
        dataMap.put("PSMOBAPPPACKTD", "T_SRFPSMOBAPPPACKTD");
        dataMap.put("PSDEDATAIMP", "T_SRFPSDEDATAIMP");
        dataMap.put("PSAPPWFVER", "T_SRFPSAPPWFVER");
        dataMap.put("PSDEMSOPPRIV", "T_SRFPSDEMSOPPRIV");
        dataMap.put("PSSYSBDINSTCFG", "T_SRFPSSYSBDINSTCFG");
        dataMap.put("PSDETREENODECOL", "T_SRFPSDETREENODECOL");
        dataMap.put("PSPANELENGINE", "T_SRFPSPANELENGINE");
        dataMap.put("PSSYSIMAGE", "T_SRFPSSYSIMAGE");
        dataMap.put("PSWFROLE", "T_SRFPSWFROLE");
        dataMap.put("PSDEFVALUERULE", "T_SRFPSDEFVALUERULE");
        dataMap.put("PSDERGROUP", "T_SRFPSDERGROUP");
        dataMap.put("PSDEDQJOIN", "T_SRFPSDEDQJOIN");
        dataMap.put("PSSYSCSS", "T_SRFPSSYSCSS");
        dataMap.put("PSDEFFORMITEM", "T_SRFPSDEFFORMITEM");
        dataMap.put("PSWFLINKCOND", "T_SRFPSWFLINKCOND");
        dataMap.put("PSWFLINK", "T_SRFPSWFLINK");
        dataMap.put("PSDEAWGRPDETAIL", "T_SRFPSDEAWGRPDETAIL");
        dataMap.put("PSWFROLE", "T_SRFPSWFROLE");
        dataMap.put("PSSYSCALENDAR", "T_SRFPSSYSCALENDAR");
        dataMap.put("PSWXMENUITEM", "T_SRFPSWXMENUITEM");
        dataMap.put("PSCTRLMSG", "T_SRFPSCTRLMSG");
        dataMap.put("PSSYSDICTCAT", "T_SRFPSSYSDICTCAT");
        dataMap.put("PSSYSVIEWLOGIC", "T_SRFPSSYSVIEWLOGIC");
        dataMap.put("PSSYSSFPLUGIN", "T_SRFPSSYSSFPLUGIN");
        dataMap.put("PSDECHART", "T_SRFPSDECHART");
        dataMap.put("PSAPPWF", "T_SRFPSAPPWF");
        dataMap.put("PSDEUIACTION", "T_SRFPSDEUIACTION");
        dataMap.put("PSWFWORKTIME", "T_SRFPSWFWORKTIME");
        dataMap.put("PSDEPRINT", "T_SRFPSDEPRINT");
        dataMap.put("PSSUBSYSSERVICEAPI", "T_SRFPSSUBSYSSERVICEAPI");
        dataMap.put("PSDEGEIUDETAIL", "T_SRFPSDEGEIUDETAIL");
        dataMap.put("PSAPPUITHEME", "T_SRFPSAPPUITHEME");
        dataMap.put("PSDEUIACTION", "T_SRFPSDEUIACTION");
        dataMap.put("PSSYSIMAGE", "T_SRFPSSYSIMAGE");
        dataMap.put("PSWORKFLOW", "T_SRFPSWORKFLOW");
        dataMap.put("PSSYSTITLEBAR", "T_SRFPSSYSTITLEBAR");
        dataMap.put("PSCTRLMSGITEM", "T_SRFPSCTRLMSGITEM");
        dataMap.put("PSSYSDMVER", "T_SRFPSSYSDMVER");
        dataMap.put("PSDELLCOND", "T_SRFPSDELLCOND");
        dataMap.put("PSWFVERSION", "T_SRFPSWFVERSION");
        dataMap.put("PSPANELLLCOND", "T_SRFPSPANELLLCOND");
        dataMap.put("PSDEDBCFG", "T_SRFPSDEDBCFG");
        dataMap.put("PSAPPMODULE", "T_SRFPSAPPMODULE");
        dataMap.put("PSDEVIEWLOGIC", "T_SRFPSDEVIEWLOGIC");
        dataMap.put("PSWXACCOUNT", "T_SRFPSWXACCOUNT");
        dataMap.put("PSDEOPPRIV", "T_SRFPSDEOPPRIV");
        dataMap.put("PSAPPUTILPAGE", "T_SRFPSAPPUTILPAGE");
        dataMap.put("PSDEOPPRIV", "T_SRFPSDEOPPRIV");
        dataMap.put("PSSYSCALENDARITEMRV", "T_SRFPSSYSCALENDARITEMRV");
        dataMap.put("PSSYSSQLCMDSQL", "T_SRFPSSYSSQLCMDSQL");
        dataMap.put("PSDEDATARELATION", "T_SRFPSDEDATARELATION");
        dataMap.put("PSDETABLE", "T_SRFPSDETABLE");
        dataMap.put("PSDESAMPLEDATAREF", "T_SRFPSDESAMPLEDATAREF");
        dataMap.put("PSSYSBDSCHEME", "T_SRFPSSYSBDSCHEME");
        dataMap.put("PSDEMAPDQ", "T_SRFPSDEMAPDQ");
        dataMap.put("PSSYSUNIT", "T_SRFPSSYSUNIT");
        dataMap.put("PSDEDRITEM", "T_SRFPSDEDRITEM");
        dataMap.put("PSSYSTCINPUT", "T_SRFPSSYSTCINPUT");
        dataMap.put("PSACHANDLERACTION", "T_SRFPSACHANDLERACTION");
        dataMap.put("PSSYSBACKSERVICE", "T_SRFPSSYSBACKSERVICE");
        dataMap.put("PSDEUAGRPDETAIL", "T_SRFPSDEUAGRPDETAIL");
        dataMap.put("PSLANGUAGE", "T_SRFPSLANGUAGE");
        dataMap.put("PSDETBITEM", "T_SRFPSDETBITEM");
        dataMap.put("PSDELOGIC", "T_SRFPSDELOGIC");
        dataMap.put("PSDECHARTPARAM", "T_SRFPSDECHARTPARAM");
        dataMap.put("PSDEVIEWRV", "T_SRFPSDEVIEWRV");
        dataMap.put("PSSYSUNIRES", "T_SRFPSSYSUNIRES");
        dataMap.put("PSDEDSCODE", "T_SRFPSDEDSCODE");
        dataMap.put("PSDETREEVIEW", "T_SRFPSDETREEVIEW");
        dataMap.put("PSSYSERMAPNODE", "T_SRFPSSYSERMAPNODE");
        dataMap.put("PSSYSDBVALUEOP", "T_SRFPSSYSDBVALUEOP");
        dataMap.put("PSDEGRIDCOL", "T_SRFPSDEGRIDCOL");
        dataMap.put("PSDEFDTCOL", "T_SRFPSDEFDTCOL");
        dataMap.put("PSSYSDELOGICNODE", "T_SRFPSSYSDELOGICNODE");
        dataMap.put("PSSYSUNIT", "T_SRFPSSYSUNIT");
        dataMap.put("PSSYSPORTLET", "T_SRFPSSYSPORTLET");
        dataMap.put("PSSYSBDMODULE", "T_SRFPSSYSBDMODULE");
        dataMap.put("PSDETREEVIEW", "T_SRFPSDETREEVIEW");
        dataMap.put("PSSYSTEMDBCFG", "T_SRFPSSYSTEMDBCFG");
        dataMap.put("PSSYSDYNAMODEL", "T_SRFPSSYSDYNAMODEL");
        dataMap.put("PSDEDQCODEEXP", "T_SRFPSDEDQCODEEXP");
        dataMap.put("PSSUBSYSSADETAIL", "T_SRFPSSUBSYSSADETAIL");
        dataMap.put("PSDEDSGRPPARAM", "T_SRFPSDEDSGRPPARAM");
        dataMap.put("PSDEREPORT", "T_SRFPSDEREPORT");
        dataMap.put("PSSYSCOUNTERITEM", "T_SRFPSSYSCOUNTERITEM");
        dataMap.put("PSSYSDBSCHEME", "T_SRFPSSYSDBSCHEME");
        dataMap.put("PSDEMAINSTATE", "T_SRFPSDEMAINSTATE");
        dataMap.put("PSDEOPPRIV", "T_SRFPSDEOPPRIV");
        dataMap.put("PSWXACCOUNT", "T_SRFPSWXACCOUNT");
        dataMap.put("PSSYSPDTVIEW", "T_SRFPSSYSPDTVIEW");
        dataMap.put("PSSYSPFPLUGIN", "T_SRFPSSYSPFPLUGIN");
        dataMap.put("PSDEDTSQUEUE", "T_SRFPSDEDTSQUEUE");
        dataMap.put("PSWFLINKROLE", "T_SRFPSWFLINKROLE");
        dataMap.put("PSDEFORMDETAIL", "T_SRFPSDEFORMDETAIL");
        dataMap.put("PSSYSUSERDR", "T_SRFPSSYSUSERDR");
        dataMap.put("PSSYSCSSCAT", "T_SRFPSSYSCSSCAT");
        dataMap.put("PSSYSVIEWPANEL", "T_SRFPSSYSVIEWPANEL");
        dataMap.put("PSDETREECOL", "T_SRFPSDETREECOL");
        dataMap.put("PSAPPPVPART", "T_SRFPSAPPPVPART");
        dataMap.put("PSWFPROCSUBWF", "T_SRFPSWFPROCSUBWF");
        dataMap.put("PSSYSDICTCAT", "T_SRFPSSYSDICTCAT");
        dataMap.put("PSSYSVIEWPANELMODEL", "T_SRFPSSYSVIEWPANELMODEL");
        dataMap.put("PSDEMSACTION", "T_SRFPSDEMSACTION");
        dataMap.put("PSSYSSAHANDLER", "T_SRFPSSYSSAHANDLER");
        dataMap.put("PSSYSDBPART", "T_SRFPSSYSDBPART");
        dataMap.put("PSDEFVRCOND", "T_SRFPSDEFVRCOND");
        dataMap.put("PSDELOGICPARAM", "T_SRFPSDELOGICPARAM");
        dataMap.put("PSSYSWFSETTING", "T_SRFPSSYSWFSETTING");
        dataMap.put("PSAPPPVPART", "T_SRFPSAPPPVPART");
        dataMap.put("PSDEDATAEXP", "T_SRFPSDEDATAEXP");
        dataMap.put("PSSYSTDITEM", "T_SRFPSSYSTDITEM");
        dataMap.put("PSDEUAGROUP", "T_SRFPSDEUAGROUP");
        dataMap.put("PSSYSDBCOLUMN", "T_SRFPSSYSDBCOLUMN");
        dataMap.put("PSDATAENTITY", "T_SRFPSDATAENTITY");
        dataMap.put("PSMOBAPPPACK", "T_SRFPSMOBAPPPACK");
        dataMap.put("PSDERDEFMAP", "T_SRFPSDERDEFMAP");
        dataMap.put("PSDEUTILDE", "T_SRFPSDEUTILDE");
        dataMap.put("PSSYSPORTLET", "T_SRFPSSYSPORTLET");
        dataMap.put("PSWFDE", "T_SRFPSWFDE");
        dataMap.put("PSDEGRIDCOL", "T_SRFPSDEGRIDCOL");
        dataMap.put("PSSYSCODESNIPPET", "T_SRFPSSYSCODESNIPPET");
        dataMap.put("PSDEDSDQ", "T_SRFPSDEDSDQ");
        dataMap.put("PSSYSEDITORSTYLE", "T_SRFPSSYSEDITORSTYLE");
        dataMap.put("PSSYSSFPUB", "T_SRFPSSYSSFPUB");
        dataMap.put("PSDELISTITEM", "T_SRFPSDELISTITEM");
        dataMap.put("PSSYSSFPUBPKG", "T_SRFPSSYSSFPUBPKG");
        dataMap.put("PSWFPROCPARAM", "T_SRFPSWFPROCPARAM");
        dataMap.put("PSSYSDASHBOARD", "T_SRFPSSYSDASHBOARD");
        dataMap.put("PSSYSMODELGROUP", "T_SRFPSSYSMODELGROUP");
        dataMap.put("PSDEDBIDXFIELD", "T_SRFPSDEDBIDXFIELD");
        dataMap.put("PSSYSVIEWPANEL", "T_SRFPSSYSVIEWPANEL");
        dataMap.put("PSDEDBINDEX", "T_SRFPSDEDBINDEX");
        dataMap.put("PSDEMAPDETAIL", "T_SRFPSDEMAPDETAIL");
        dataMap.put("PSDEACTIONTEMPL", "T_SRFPSDEACTIONTEMPL");
        dataMap.put("PSDETBITEM", "T_SRFPSDETBITEM");
        dataMap.put("PSSYSDBVF", "T_SRFPSSYSDBVF");
        dataMap.put("PSSYSDBVFCODE", "T_SRFPSSYSDBVFCODE");
        dataMap.put("PSDEFIVR", "T_SRFPSDEFIVR");
        dataMap.put("PSSYSBDTABLEDE", "T_SRFPSSYSBDTABLEDE");
        dataMap.put("PSSYSCOUNTER", "T_SRFPSSYSCOUNTER");
        dataMap.put("PSLANGUAGEITEM", "T_SRFPSLANGUAGEITEM");
        dataMap.put("PSDESERVICEAPI", "T_SRFPSDESERVICEAPI");
        dataMap.put("PSCODEITEM", "T_SRFPSCODEITEM");
        dataMap.put("PSVIEWMSGGROUP", "T_SRFPSVIEWMSGGROUP");
        dataMap.put("PSWFSUBWF", "T_SRFPSWFSUBWF");
        dataMap.put("PSDEGRID", "T_SRFPSDEGRID");
        dataMap.put("PSACHANDLER", "T_SRFPSACHANDLER");
        dataMap.put("PSSYSBDCOLUMN", "T_SRFPSSYSBDCOLUMN");
        dataMap.put("PSWXMENUFUNC", "T_SRFPSWXMENUFUNC");
        dataMap.put("PSACHANDLER", "T_SRFPSACHANDLER");
        dataMap.put("PSMOBAPPSTARTPAGE", "T_SRFPSMOBAPPSTARTPAGE");
        dataMap.put("PSDEDATAIMPITEM", "T_SRFPSDEDATAIMPITEM");
        dataMap.put("PSSYSPFPITEMPL", "T_SRFPSSYSPFPITEMPL");
        dataMap.put("PSAPPTITLEBAR", "T_SRFPSAPPTITLEBAR");
        dataMap.put("PSDELOGICNODE", "T_SRFPSDELOGICNODE");
        dataMap.put("PSPANELLOGICPARAM", "T_SRFPSPANELLOGICPARAM");
        dataMap.put("PSSYSTESTCASE", "T_SRFPSSYSTESTCASE");
        dataMap.put("PSDEDATAVIEW", "T_SRFPSDEDATAVIEW");
        dataMap.put("PSVIEWMSG", "T_SRFPSVIEWMSG");
        dataMap.put("PSDEDATAQUERY", "T_SRFPSDEDATAQUERY");
        dataMap.put("PSDEFINPUTTIP", "T_SRFPSDEFINPUTTIP");
        dataMap.put("PSSYSPDTVIEW", "T_SRFPSSYSPDTVIEW");
        dataMap.put("PSSYSTESTDATA", "T_SRFPSSYSTESTDATA");
        dataMap.put("PSDETREENODE", "T_SRFPSDETREENODE");
        dataMap.put("PSAPPMENUITEM", "T_SRFPSAPPMENUITEM");
        dataMap.put("PSSYSBDTABLEDER", "T_SRFPSSYSBDTABLEDER");
        dataMap.put("PSSYSBDTABLERS", "T_SRFPSSYSBDTABLERS");
        dataMap.put("PSSYSREF", "T_SRFPSSYSREF");
        dataMap.put("PSCODEITEM", "T_SRFPSCODEITEM");
        dataMap.put("PSWFUTILUIACTION", "T_SRFPSWFUTILUIACTION");
        dataMap.put("PSAPPMENUITEM", "T_SRFPSAPPMENUITEM");
        dataMap.put("PSDEUIACTION", "T_SRFPSDEUIACTION");
        dataMap.put("PSLANGUAGERES", "T_SRFPSLANGUAGERES");
        dataMap.put("PSDEDQJOIN", "T_SRFPSDEDQJOIN");
        dataMap.put("PSSYSDASHBOARD", "T_SRFPSSYSDASHBOARD");
        dataMap.put("PSDEFVRCOND", "T_SRFPSDEFVRCOND");
        dataMap.put("PSSYSSFPITEMPL", "T_SRFPSSYSSFPITEMPL");
        dataMap.put("PSSYSCSS", "T_SRFPSSYSCSS");
        dataMap.put("PSWORKFLOW", "T_SRFPSWORKFLOW");
        dataMap.put("PSSYSTEMRUN", "T_SRFPSSYSTEMRUN");
        dataMap.put("PSPANELLOGICLINK", "T_SRFPSPANELLOGICLINK");
        dataMap.put("PSSYSSEARCHBAR", "T_SRFPSSYSSEARCHBAR");
        dataMap.put("PSDEDATASET", "T_SRFPSDEDATASET");
        dataMap.put("PSSYSMSGTEMPL", "T_SRFPSSYSMSGTEMPL");
        dataMap.put("PSDEFORMDETAIL", "T_SRFPSDEFORMDETAIL");
        dataMap.put("PSDEFORM", "T_SRFPSDEFORM");
        dataMap.put("PSWFUTILUIACTION", "T_SRFPSWFUTILUIACTION");
        dataMap.put("PSSYSDELOGICNODE", "T_SRFPSSYSDELOGICNODE");
        dataMap.put("PSDEREPITEM", "T_SRFPSDEREPITEM");
        dataMap.put("PSSYSDYNAMODELATTR", "T_SRFPSSYSDYNAMODELATTR");
        dataMap.put("PSSYSCSSCAT", "T_SRFPSSYSCSSCAT");
        dataMap.put("PSACHANDLER", "T_SRFPSACHANDLER");
        dataMap.put("PSSYSDASHBOARD", "T_SRFPSSYSDASHBOARD");
        dataMap.put("PSSYSBDSCHEME", "T_SRFPSSYSBDSCHEME");
        dataMap.put("PSAPPPKG", "T_SRFPSAPPPKG");
        dataMap.put("PSDELLCOND", "T_SRFPSDELLCOND");
        dataMap.put("PSMODULE", "T_SRFPSMODULE");
        dataMap.put("PSDEMAPDS", "T_SRFPSDEMAPDS");
        dataMap.put("PSDEAWGROUP", "T_SRFPSDEAWGROUP");
        dataMap.put("PSVIEWWIZARDGROUP", "T_SRFPSVIEWWIZARDGROUP");
        dataMap.put("PSPANELITEMLOGIC", "T_SRFPSPANELITEMLOGIC");
        dataMap.put("PSDEMAP", "T_SRFPSDEMAP");
        dataMap.put("PSDEGROUP", "T_SRFPSDEGROUP");
        dataMap.put("PSWXENTAPP", "T_SRFPSWXENTAPP");
        dataMap.put("PSDEDATASYNC", "T_SRFPSDEDATASYNC");
        dataMap.put("PSAPPLAN", "T_SRFPSAPPLAN");
        dataMap.put("PSSYSSAHANDLER", "T_SRFPSSYSSAHANDLER");
        dataMap.put("PSSYSERMAP", "T_SRFPSSYSERMAP");
        dataMap.put("PSDEAWITEM", "T_SRFPSDEAWITEM");
        dataMap.put("PSDEDRGROUP", "T_SRFPSDEDRGROUP");
        dataMap.put("PSPANELLLCOND", "T_SRFPSPANELLLCOND");
        dataMap.put("PSSYSUSERROLERES", "T_SRFPSSYSUSERROLERES");
        dataMap.put("PSDEDQCOND", "T_SRFPSDEDQCOND");
        dataMap.put("PSDEVIEWBASE", "T_SRFPSDEVIEWBASE");
        dataMap.put("PSDETOOLBAR", "T_SRFPSDETOOLBAR");
        dataMap.put("PSSYSVIEWLOGICPARAM", "T_SRFPSSYSVIEWLOGICPARAM");
        dataMap.put("PSSYSUNISTATE", "T_SRFPSSYSUNISTATE");
        dataMap.put("PSDEFIUDETAIL", "T_SRFPSDEFIUDETAIL");
        dataMap.put("PSDEUSERROLE", "T_SRFPSDEUSERROLE");
        dataMap.put("PSDEDQCOND", "T_SRFPSDEDQCOND");
        dataMap.put("PSSYSAPP", "T_SRFPSSYSAPP");
        dataMap.put("PSSYSTCASSERT", "T_SRFPSSYSTCASSERT");
        dataMap.put("PSVIEWMSGGRPDETAIL", "T_SRFPSVIEWMSGGRPDETAIL");
        dataMap.put("PSDEDQCODE", "T_SRFPSDEDQCODE");
        dataMap.put("PSDELOGICLINK", "T_SRFPSDELOGICLINK");
        dataMap.put("PSWFPROCROLE", "T_SRFPSWFPROCROLE");
        dataMap.put("PSSYSVIEWPANELLOGIC", "T_SRFPSSYSVIEWPANELLOGIC");
        dataMap.put("PSSYSCALENDAR", "T_SRFPSSYSCALENDAR");
        dataMap.put("PSSYSVIEWPANELITEM", "T_SRFPSSYSVIEWPANELITEM");
        dataMap.put("PSAPPDEVIEW", "V_PSAPPDEVIEW");
        dataMap.put("PSAPPDYNADEVIEW", "V_PSAPPDYNADEVIEW");
        dataMap.put("PSAPPINDEXVIEW", "V_PSAPPINDEXVIEW");
        dataMap.put("PSAPPPANELVIEW", "V_PSAPPPANELVIEW");
        dataMap.put("PSAPPPORTALVIEW", "V_PSAPPPORTALVIEW");
        dataMap.put("PSAPPUTILVIEW", "V_PSAPPUTILVIEW");
        dataMap.put("PSDEUAGROUP", "T_SRFPSDEUAGROUP");
        dataMap.put("PSDEDQCODECOND", "T_SRFPSDEDQCODECOND");
        dataMap.put("PSSYSFILE", "T_SRFPSSYSFILE");
        dataMap.put("PSAPPPDTVIEW", "T_SRFPSAPPPDTVIEW");
        dataMap.put("PSWFPROCESS", "T_SRFPSWFPROCESS");
        dataMap.put("PSDEVIEWENGINE", "T_SRFPSDEVIEWENGINE");
        dataMap.put("PSPANELLNPARAM", "T_SRFPSPANELLNPARAM");
        dataMap.put("PSDEFORMRF", "T_SRFPSDEFORMRF");
        dataMap.put("PSDEOPPRIVROLE", "T_SRFPSDEOPPRIVROLE");
        dataMap.put("PSAPPUSERMODE", "T_SRFPSAPPUSERMODE");
        dataMap.put("PSSUBVIEWTYPE", "T_SRFPSSUBVIEWTYPE");
        dataMap.put("PSSYSSERVICEAPI", "T_SRFPSSYSSERVICEAPI");
        dataMap.put("PSDERGROUPDETAIL", "T_SRFPSDERGROUPDETAIL");
        dataMap.put("PSSYSCALENDAR", "T_SRFPSSYSCALENDAR");
        dataMap.put("PSWXLOGIC", "T_SRFPSWXLOGIC");
        dataMap.put("PSDEWIZARDSTEP", "T_SRFPSDEWIZARDSTEP");
        dataMap.put("PSDEACMODE", "T_SRFPSDEACMODE");
        dataMap.put("PSMODULE", "T_SRFPSMODULE");
        dataMap.put("PSDELISTITEM", "T_SRFPSDELISTITEM");
        dataMap.put("PSDEVIEWCTRL", "T_SRFPSDEVIEWCTRL");
        dataMap.put("PSDER", "T_SRFPSDER");
        dataMap.put("PSDEFGROUP", "T_SRFPSDEFGROUP");
        dataMap.put("PSDEFGROUPDETAIL", "T_SRFPSDEFGROUPDETAIL");
        dataMap.put("PSDESARS", "T_SRFPSDESARS");
        dataMap.put("PSAPPDERS", "T_SRFPSAPPDERS");
        dataMap.put("PSAPPDERSVIEW", "T_SRFPSAPPDERSVIEW");
        dataMap.put("PSSUBSYSSADE", "T_SRFPSSUBSYSSADE");
        dataMap.put("PSSUBSYSSADEFIELD", "T_SRFPSSUBSYSSADEFIELD");
        dataMap.put("PSSUBSYSSADERS", "T_SRFPSSUBSYSSADERS");
        dataMap.put("PSSYSOPPRIV", "T_SRFPSSYSOPPRIV");
        dataMap.put("PSSYSDBPROC", "T_SRFPSSYSDBPROC");
        dataMap.put("PSSYSDBPROCPARAM", "T_SRFPSSYSDBPROCPARAM");
        dataMap.put("PSSYSSAMPLEVALUE", "T_SRFPSSYSSAMPLEVALUE");
        PSSystem psSystem = new PSSystem();
        psSystem.setPSSystemId(psSysServiceAPI.getPSSystemId());
        PSDataEntityService psDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDEServiceAPIService psDEServiceAPIService = (PSDEServiceAPIService)ServiceGlobal.getService(PSDEServiceAPIService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDERService psDERService = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDESARSService psDESARSService = (PSDESARSService)ServiceGlobal.getService(PSDESARSService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDESADetailService psDESADetailService = (PSDESADetailService)ServiceGlobal.getService(PSDESADetailService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        ArrayList<PSDataEntity> psDataEntityList = psDataEntityService.selectByPSSystem((PSSystemBase)psSystem);
        ArrayList<PSDEServiceAPI> psDEServiceAPIList = psDEServiceAPIService.selectByPSSysServiceAPI((PSSysServiceAPIBase)psSysServiceAPI);
        ArrayList<PSDER> psDERList = psDERService.selectByPSSystem((PSSystemBase)psSystem);
        ArrayList<PSDESARS> psDESARSList = psDESARSService.selectByPSSysServiceAPI((PSSysServiceAPIBase)psSysServiceAPI);
        HashMap<String, PSDataEntity> psDataEntityMap = new HashMap<String, PSDataEntity>();
        for (PSDataEntity pSDataEntity : psDataEntityList) {
            if (!dataMap.containsKey(pSDataEntity.getPSDataEntityName())) continue;
            psDataEntityMap.put(pSDataEntity.getPSDataEntityId(), pSDataEntity);
        }
        for (PSDEServiceAPI pSDEServiceAPI : psDEServiceAPIList) {
            psDataEntityMap.remove(pSDEServiceAPI.getPSDEId());
        }
        for (Map.Entry<String, PSDataEntity> entry : psDataEntityMap.entrySet()) {
            PSDEServiceAPI psDEServiceAPI = new PSDEServiceAPI();
            psDEServiceAPI.setPSSysServiceAPIId(psSysServiceAPI.getPSSysServiceAPIId());
            psDEServiceAPI.setPSSysServiceAPIName(psSysServiceAPI.getPSSysServiceAPIName());
            psDEServiceAPI.setPSDEServiceAPIName(((PSDataEntity)entry.getValue()).getPSDataEntityName());
            psDEServiceAPI.setPSDEId(((PSDataEntity)entry.getValue()).getPSDataEntityId());
            psDEServiceAPI.setPSDEName(((PSDataEntity)entry.getValue()).getPSDataEntityName());
            psDEServiceAPI.setCodeName(((PSDataEntity)entry.getValue()).getCodeName());
            psDEServiceAPI.setMajorFlag(Integer.valueOf(0));
            psDEServiceAPIService.create(psDEServiceAPI);
            psDEServiceAPIList.add(psDEServiceAPI);
        }
        HashMap<String, PSDEServiceAPI> hashMap = new HashMap<String, PSDEServiceAPI>();
        for (PSDEServiceAPI psDEServiceAPI : psDEServiceAPIList) {
            hashMap.put(psDEServiceAPI.getPSDEId(), psDEServiceAPI);
        }
        String[] stdActions = new String[]{"Create", "Update", "Remove", "Get"};
        for (PSDEServiceAPI psDEServiceAPI : psDEServiceAPIList) {
            ArrayList<PSDESADetail> psDESADetailList = psDEServiceAPI.getPSDESADetails();
            ArrayList<PSDEAction> psDEActionList = psDEServiceAPI.getPSDE().getPSDEActions();
            boolean bSelectAction = true;
            for (PSDESADetail psDESADetail : psDESADetailList) {
                if (StringHelper.Compare((String)psDESADetail.getDetailType(), (String)"SELECT", (boolean)false) != 0) continue;
                bSelectAction = false;
                break;
            }
            if (bSelectAction) {
                PSDESADetail psDESADetail;
                psDESADetail = new PSDESADetail();
                psDESADetail.setDetailType("SELECT");
                psDESADetail.setPSDEServiceAPIId(psDEServiceAPI.getPSDEServiceAPIId());
                psDESADetail.setPSDEServiceAPIName(psDEServiceAPI.getPSDEServiceAPIName());
                psDESADetail.setOrderValue(Integer.valueOf(5000));
                psDESADetailService.create(psDESADetail, false);
            }
            String[] stringArray = stdActions;
            int n = stdActions.length;
            int n2 = 0;
            while (n2 < n) {
                String strAction = stringArray[n2];
                PSDEAction insertPSDEAction = null;
                for (PSDEAction psDEAction : psDEActionList) {
                    if (StringHelper.Compare((String)psDEAction.getCodeName(), (String)strAction, (boolean)true) != 0) continue;
                    insertPSDEAction = psDEAction;
                    break;
                }
                if (insertPSDEAction != null) {
                    boolean bInsertAction = true;
                    for (PSDESADetail psDESADetail : psDESADetailList) {
                        if (StringHelper.Compare((String)psDESADetail.getDetailType(), (String)"DEACTION", (boolean)false) != 0 || StringHelper.Compare((String)psDESADetail.getPSDEActionId(), (String)insertPSDEAction.getPSDEActionId(), (boolean)false) != 0) continue;
                        bInsertAction = false;
                        break;
                    }
                    if (bInsertAction) {
                        PSDESADetail psDESADetail;
                        psDESADetail = new PSDESADetail();
                        psDESADetail.setDetailType("DEACTION");
                        psDESADetail.setPSDEServiceAPIId(psDEServiceAPI.getPSDEServiceAPIId());
                        psDESADetail.setPSDEServiceAPIName(psDEServiceAPI.getPSDEServiceAPIName());
                        psDESADetail.setPSDEActionId(insertPSDEAction.getPSDEActionId());
                        psDESADetail.setPSDEActionName(insertPSDEAction.getPSDEActionName());
                        if (StringHelper.Compare((String)strAction, (String)"Create", (boolean)true) == 0) {
                            psDESADetail.setOrderValue(Integer.valueOf(1000));
                        } else if (StringHelper.Compare((String)strAction, (String)"Update", (boolean)true) == 0) {
                            psDESADetail.setOrderValue(Integer.valueOf(2000));
                        } else if (StringHelper.Compare((String)strAction, (String)"Get", (boolean)true) == 0) {
                            psDESADetail.setOrderValue(Integer.valueOf(3000));
                        } else if (StringHelper.Compare((String)strAction, (String)"Remove", (boolean)true) == 0) {
                            psDESADetail.setOrderValue(Integer.valueOf(4000));
                        }
                        psDESADetailService.create(psDESADetail, false);
                    }
                }
                ++n2;
            }
        }
        HashMap<String, PSDESARS> psDESARSMap = new HashMap<String, PSDESARS>();
        for (PSDESARS psDESARS : psDESARSList) {
            psDESARSMap.put(psDESARS.getPSDERId(), psDESARS);
        }
        for (PSDER psDER : psDERList) {
            if (psDESARSMap.containsKey(psDER.getPSDERId()) || DataObject.getIntegerValue((Object)psDER.getTempOrderValue(), (Integer)0) <= 0 && DataObject.getIntegerValue((Object)psDER.getExportScope(), (Integer)0) <= 0) continue;
            PSDEServiceAPI majorPSDEServiceAPI = (PSDEServiceAPI)hashMap.get(psDER.getMajorPSDEId());
            PSDEServiceAPI minorPSDEServiceAPI = (PSDEServiceAPI)hashMap.get(psDER.getMinorPSDEId());
            if (majorPSDEServiceAPI == null && minorPSDEServiceAPI != null) {
                if (StringHelper.Compare((String)psDER.getMajorPSDEName(), (String)"PSSYSTEM", (boolean)true) != 0 || DataObject.getBoolValue((Integer)minorPSDEServiceAPI.getMajorFlag(), (boolean)false)) continue;
                minorPSDEServiceAPI.setMajorFlag(Integer.valueOf(1));
                psDEServiceAPIService.update(minorPSDEServiceAPI);
                continue;
            }
            if (majorPSDEServiceAPI == null || minorPSDEServiceAPI == null || StringHelper.Compare((String)psDER.getMajorPSDEName(), (String)"PSSYSREF", (boolean)true) == 0 || StringHelper.Compare((String)psDER.getMajorPSDEName(), (String)"PSMODULE", (boolean)true) == 0) continue;
            PSDESARS psDESARS = new PSDESARS();
            psDESARS.setPSDESARSName(psDER.getPSDERName());
            psDESARS.setPPSDEServiceAPIId(majorPSDEServiceAPI.getPSDEServiceAPIId());
            psDESARS.setPPSDEServiceAPIName(majorPSDEServiceAPI.getPSDEServiceAPIName());
            psDESARS.setCPSDEServiceAPIId(minorPSDEServiceAPI.getPSDEServiceAPIId());
            psDESARS.setCPSDEServiceAPIName(minorPSDEServiceAPI.getPSDEServiceAPIName());
            psDESARS.setPSDERId(psDER.getPSDERId());
            psDESARS.setPSDERName(psDER.getPSDERName());
            psDESARS.setPSSysServiceAPIId(psSysServiceAPI.getPSSysServiceAPIId());
            psDESARS.setPSSysServiceAPIName(psSysServiceAPI.getPSSysServiceAPIName());
            if (DataObject.getIntegerValue((Object)psDER.getTempOrderValue(), Integer.valueOf(-1)) >= 0) {
                psDESARS.setDataRSMode(Integer.valueOf(7));
            }
            psDESARSService.create(psDESARS);
        }
    }
}
