/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  com.fasterxml.jackson.databind.ObjectMapper
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.db.DBCallResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.appdesign.entity.PSAppDEView
 *  net.ibizsys.pscore.srv.appdesign.entity.PSAppModule
 *  net.ibizsys.pscore.srv.appdesign.service.PSAppDEViewService
 *  net.ibizsys.pscore.srv.appdesign.service.PSAppModuleService
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEAction
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEForm
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEFormDetail
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEServiceAPI
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroupDetail
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEViewCtrl
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEActionService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEFormService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEServiceAPIService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupDetailService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService
 *  net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst
 *  net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSModule
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBDetail
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystem
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase
 *  net.ibizsys.pscore.srv.sysdesign.service.PSModuleService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysDBDetailService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSystemService
 *  net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile
 *  net.ibizsys.pscore.srv.util.IPSWorkspace
 *  net.ibizsys.pscore.srv.util.PSModelV2Helper
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  net.ibizsys.pscore.srv.util.gitlab.IPSGitLabPlugin
 *  net.ibizsys.pscore.srv.util.gitlab.PSGitLabPluginImpl2
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.Database.IPSDBType2;
import SA.SRFDA.PS.Core.Database.IPSDBType4;
import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskWork;
import SA.SRFDA.PS.Core.DevStudio.PSBKTaskWorkHelper;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.Paas.PSSysModelInstImpl;
import SA.SRFDA.PS.Core.Util.PSSysModelInstHelper;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Ctrl.Util.MOSHelper;
import SA.SRFDA.PS.Data.PSDBServer;
import SA.SRFDA.PS.Data.PSSysModelInstBK;
import SA.SRFDA.PS.Data.PSSysModelVer;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.DBCallResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppDEView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppModule;
import net.ibizsys.pscore.srv.appdesign.service.PSAppDEViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppModuleService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEServiceAPI;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroupDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewCtrl;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEServiceAPIService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBDetail;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBDetailService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSWorkspace;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import net.ibizsys.pscore.srv.util.gitlab.IPSGitLabPlugin;
import net.ibizsys.pscore.srv.util.gitlab.PSGitLabPluginImpl2;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSSysModelInstDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSSysModelInstDataCtrl.class);
    private static ObjectMapper mapper = new ObjectMapper();
    public static final String CUSTOMCALL_INIT = "INIT";
    public static final String CUSTOMCALL_CLONE = "CLONE";
    public static final String CUSTOMCALL_UPDATECOUNTER = "UPDATECOUNTER";
    public static final String CUSTOMCALL_CLOSESF = "CLOSESF";
    public static final String CUSTOMCALL_CLOSEALLSF = "CLOSEALLSF";
    public static final String CUSTOMCALL_UPDATEUSEDSIZE = "UPDATEUSEDSIZE";
    public static final String CUSTOMCALL_CLEAN = "CLEAN";
    public static final String CUSTOMCALL_BACKUP = "BACKUP";
    public static final String CUSTOMCALL_OFFLINE = "OFFLINE";
    public static final String CUSTOMCALL_RESTORE = "RESTORE";
    public static final String CUSTOMCALL_INITSAME = "INITSAME";
    public static final String ATTRIBUTE_CURVER = "PSSysModelInstDataCtrl@ModelCurVer@";
    public static final String CUSTOMCALL_EXPORTV2 = "EXPORTV2";
    public static final String CUSTOMCALL_IMPORTV2 = "IMPORTV2";
    public static final String CUSTOMCALL_BACKUPV2 = "BACKUPV2";
    public static final String CUSTOMCALL_RESTOREV2 = "RESTOREV2";
    public static final String CUSTOMCALL_ONLINE = "ONLINE";

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        return callResult;
    }

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_INIT, (boolean)true) == 0) {
            return this.initSysModel(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_INITSAME, (boolean)true) == 0) {
            return this.initSameSysModel(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_CLONE, (boolean)true) == 0) {
            return this.cloneSysModel(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_UPDATECOUNTER, (boolean)true) == 0) {
            return this.updateCounter(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_CLOSESF, (boolean)true) == 0) {
            return this.closeSessionFactory(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_UPDATEUSEDSIZE, (boolean)true) == 0) {
            return this.updateUsedSize(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_CLEAN, (boolean)true) == 0) {
            return this.cleanDBInst(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_BACKUP, (boolean)true) == 0) {
            return this.backupDBInst(dataEntity, false);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_OFFLINE, (boolean)true) == 0) {
            return this.backupDBInst(dataEntity, true);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_RESTORE, (boolean)true) == 0) {
            return this.restoreDBInst(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_EXPORTV2, (boolean)true) == 0) {
            return this.exportV2Model(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_IMPORTV2, (boolean)true) == 0) {
            return this.importV2Model(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_BACKUPV2, (boolean)true) == 0) {
            return this.backupV2Model(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_RESTOREV2, (boolean)true) == 0) {
            return this.restoreV2Model(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_ONLINE, (boolean)true) == 0) {
            return this.onlineModel(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult initSysModel(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            SA.SRFDA.PS.Data.PSSysModelInst psSysModelInst = new SA.SRFDA.PS.Data.PSSysModelInst();
            psSysModelInst.proxy(dataEntity);
            this.onInitSysModel(psSysModelInst);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u7cfb\u7edf\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    public CallResult initSameSysModel(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            SA.SRFDA.PS.Data.PSSysModelInst psSysModelInst = new SA.SRFDA.PS.Data.PSSysModelInst();
            psSysModelInst.proxy(dataEntity);
            BaseDataEntity cond = new BaseDataEntity();
            cond.setParamValue("MODELVER", (Object)psSysModelInst.getMODELVER());
            if (!StringHelper.IsNullOrEmpty((String)psSysModelInst.getPSSVRDOMAINID())) {
                cond.setParamValue("PSSVRDOMAINID", (Object)psSysModelInst.getPSSVRDOMAINID());
            }
            if (!StringHelper.IsNullOrEmpty((String)psSysModelInst.getINSTGROUP())) {
                cond.setParamValue("INSTGROUP", (Object)psSysModelInst.getINSTGROUP());
            }
            if (!StringHelper.IsNullOrEmpty((String)psSysModelInst.getINSTSTATE())) {
                cond.setParamValue("INSTSTATE", (Object)psSysModelInst.getINSTSTATE());
            }
            if (!StringHelper.IsNullOrEmpty((String)psSysModelInst.getSYSTYPE())) {
                cond.setParamValue("SYSTYPE", (Object)psSysModelInst.getSYSTYPE());
            } else {
                cond.setParamValue("SYSTYPE", (Object)"DEVSYS");
            }
            Vector<BaseDataEntity> psSysModelInstList = new Vector<BaseDataEntity>();
            callResult = this.Select(cond, psSysModelInstList);
            if (callResult.isError()) {
                return callResult;
            }
            for (BaseDataEntity baseDataEntity : psSysModelInstList) {
                SA.SRFDA.PS.Data.PSSysModelInst psSysModelInst2 = new SA.SRFDA.PS.Data.PSSysModelInst();
                psSysModelInst2.proxy(baseDataEntity);
                this.onInitSysModel(psSysModelInst2);
            }
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u7cfb\u7edf\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onInitSysModel(SA.SRFDA.PS.Data.PSSysModelInst psSysModelInst) throws Exception {
        if (StringHelper.Compare((String)psSysModelInst.getDBTYPE(), (String)"HBASE", (boolean)true) == 0) {
            return;
        }
        IDEDataCtrl psSysModelVerDataCtrl = this.GetRelatedDataCtrl("DE1896");
        CallResult callResult = null;
        int nCurModelVer = psSysModelInst.getMODELVER();
        PSSysModelVer psSysModelVer = null;
        Object objPSSysModelVer = this.getWebContext().getAttribute(ATTRIBUTE_CURVER);
        if (objPSSysModelVer == null) {
            psSysModelVer = new PSSysModelVer();
            psSysModelVer.setACTIVEFLAG(true);
            psSysModelVer.setDBTYPE(psSysModelInst.getDBTYPE());
            psSysModelVer.setSYSTYPE(psSysModelInst.getSYSTYPE());
            if (StringHelper.IsNullOrEmpty((String)psSysModelVer.getSYSTYPE())) {
                psSysModelVer.setSYSTYPE("DEVSYS");
            }
            if ((callResult = psSysModelVerDataCtrl.Select((BaseDataEntity)psSysModelVer, "", "ORDER BY MODELVER DESC ")).isError()) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e\u5e93\u6a21\u578b\u7248\u672c"));
            }
            PSSysModelInstDataCtrl.fillPSSysModelVer(this.getGlobalHelper(), psSysModelVer);
            this.getWebContext().setAttribute(ATTRIBUTE_CURVER, (Object)psSysModelVer);
        } else {
            psSysModelVer = (PSSysModelVer)((Object)objPSSysModelVer);
        }
        if (nCurModelVer == psSysModelVer.getMODELVER()) {
            return;
        }
        PSSysModelVer curPSSysModelVer = null;
        Object objCurPSSysModelVer = this.getWebContext().getAttribute(ATTRIBUTE_CURVER + Integer.toString(nCurModelVer));
        if (objCurPSSysModelVer == null) {
            curPSSysModelVer = new PSSysModelVer();
            curPSSysModelVer.setMODELVER(nCurModelVer);
            curPSSysModelVer.setDBTYPE(psSysModelInst.getDBTYPE());
            curPSSysModelVer.setSYSTYPE(psSysModelInst.getSYSTYPE());
            if (StringHelper.IsNullOrEmpty((String)curPSSysModelVer.getSYSTYPE())) {
                curPSSysModelVer.setSYSTYPE("DEVSYS");
            }
            if ((callResult = psSysModelVerDataCtrl.Select((BaseDataEntity)curPSSysModelVer)).isError()) {
                log.warn((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b\u7248\u672c[%1$s][%2$s]", (Object)psSysModelInst.getDBTYPE(), (Object)nCurModelVer));
                curPSSysModelVer = null;
            }
            if (curPSSysModelVer != null) {
                PSSysModelInstDataCtrl.fillPSSysModelVer(this.getGlobalHelper(), curPSSysModelVer);
            }
            if (curPSSysModelVer != null) {
                this.getWebContext().setAttribute(ATTRIBUTE_CURVER + Integer.toString(nCurModelVer), (Object)curPSSysModelVer);
            }
        } else {
            curPSSysModelVer = (PSSysModelVer)((Object)objCurPSSysModelVer);
        }
        HashMap<String, String> lastSqlMap = null;
        Object objLastSqlMap = this.getWebContext().getAttribute("PSSysModelInstDataCtrl@ModelCurVer@MAP@" + Integer.toString(nCurModelVer));
        if (objLastSqlMap == null) {
            lastSqlMap = new HashMap<String, String>();
            if (curPSSysModelVer != null) {
                ArrayList<String> modelList = new ArrayList<String>();
                if (!StringHelper.IsNullOrEmpty((String)curPSSysModelVer.getMODELSQL())) {
                    modelList.add(curPSSysModelVer.getMODELSQL());
                }
                if (!StringHelper.IsNullOrEmpty((String)curPSSysModelVer.getMODELSQL2())) {
                    modelList.add(curPSSysModelVer.getMODELSQL2());
                }
                if (!StringHelper.IsNullOrEmpty((String)curPSSysModelVer.getMODELSQL3())) {
                    modelList.add(curPSSysModelVer.getMODELSQL3());
                }
                for (String strModel : modelList) {
                    String[] sqls;
                    strModel = strModel.replace("\r\n", "\n");
                    String[] stringArray = sqls = StringHelper.Split((String)strModel, (String)"/**\u5206\u5272\u7ebf**/");
                    int n = sqls.length;
                    int n2 = 0;
                    while (n2 < n) {
                        String strSql = stringArray[n2];
                        if (!StringHelper.IsNullOrEmpty((String)(strSql = strSql.trim()))) {
                            lastSqlMap.put(strSql, "");
                        }
                        ++n2;
                    }
                }
            }
            this.getWebContext().setAttribute("PSSysModelInstDataCtrl@ModelCurVer@MAP@" + Integer.toString(nCurModelVer), lastSqlMap);
        } else {
            lastSqlMap = (HashMap<String, String>)objLastSqlMap;
        }
        ArrayList<String> modelList2 = null;
        String strTag = null;
        strTag = StringHelper.Compare((String)psSysModelInst.getINSTSTATE(), (String)"10", (boolean)true) != 0 ? "PSSysModelInstDataCtrl@ModelCurVer@LIST@" + Integer.toString(nCurModelVer) : "PSSysModelInstDataCtrl@ModelCurVer@LIST@NONE";
        Object objModelList2 = this.getWebContext().getAttribute(strTag);
        if (objModelList2 == null) {
            modelList2 = new ArrayList<String>();
            ArrayList<String> modelList = new ArrayList<String>();
            if (!StringHelper.IsNullOrEmpty((String)psSysModelVer.getMODELSQL())) {
                modelList.add(psSysModelVer.getMODELSQL());
            }
            if (StringHelper.Compare((String)psSysModelInst.getINSTSTATE(), (String)"10", (boolean)true) != 0 && !StringHelper.IsNullOrEmpty((String)psSysModelVer.getMODELSQL2())) {
                modelList.add(psSysModelVer.getMODELSQL2());
            }
            if (!StringHelper.IsNullOrEmpty((String)psSysModelVer.getMODELSQL3())) {
                modelList.add(psSysModelVer.getMODELSQL3());
            }
            if (!StringHelper.IsNullOrEmpty((String)psSysModelVer.getMODELSQL4())) {
                modelList.add(psSysModelVer.getMODELSQL4());
            }
            for (String strModel : modelList) {
                String[] sqls;
                strModel = strModel.replace("\r\n", "\n");
                String[] stringArray = sqls = StringHelper.Split((String)strModel, (String)"/**\u5206\u5272\u7ebf**/");
                int n = sqls.length;
                int n3 = 0;
                while (n3 < n) {
                    String strSql = stringArray[n3];
                    if (!StringHelper.IsNullOrEmpty((String)(strSql = strSql.trim())) && !lastSqlMap.containsKey(strSql)) {
                        modelList2.add(strSql);
                    }
                    ++n3;
                }
            }
            this.getWebContext().setAttribute(strTag, modelList2);
        } else {
            modelList2 = (ArrayList<String>)objModelList2;
        }
        SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory((String)psSysModelInst.getPSSYSMODELINSTID());
        int nIndex = 0;
        int nTotalSize = modelList2.size();
        IService iService = ServiceGlobal.getService(PSSysModelInstService.class, (SessionFactory)sessionFactory);
        for (String strSql : modelList2) {
            PSSysModelInstGlobal.active((String)psSysModelInst.getPSSYSMODELINSTID());
            log.debug((Object)StringHelper.Format((String)"\u6267\u884c\u6a21\u578b\u4ee3\u7801[%1$s/%2$s]", (Object)(++nIndex), (Object)nTotalSize));
            try {
                DBCallResult dbResult = iService.executeRaw(strSql, null);
                if (!dbResult.isError()) continue;
                log.error((Object)StringHelper.Format((String)"%1$s\r\n%2$s", (Object)callResult.getErrorInfo(), (Object)strSql));
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"%1$s\r\n%2$s", (Object)ex.getMessage(), (Object)strSql));
            }
        }
        if (StringHelper.IsNullOrEmpty((String)psSysModelInst.getINSTSTATE()) || StringHelper.Compare((String)psSysModelInst.getINSTSTATE(), (String)"10", (boolean)true) == 0) {
            psSysModelInst.setINSTSTATE("20");
        }
        psSysModelInst.setMODELVER(psSysModelVer.getMODELVER());
        callResult = this.Save(false, psSysModelInst);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u66f4\u65b0\u6a21\u578b\u5b9e\u4f8b\u72b6\u6001\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    public CallResult cloneSysModel(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            SA.SRFDA.PS.Data.PSSysModelInst psSysModelInst = new SA.SRFDA.PS.Data.PSSysModelInst();
            psSysModelInst.proxy(dataEntity);
            this.onCloneSysModel(psSysModelInst);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u7cfb\u7edf\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onCloneSysModel(SA.SRFDA.PS.Data.PSSysModelInst psSysModelInst) throws Exception {
        String strSrcPSSysModelInstId = psSysModelInst.getParamStringValue("SRCPSSYSMODELINSTID", "");
        if (StringHelper.IsNullOrEmpty((String)strSrcPSSysModelInstId)) {
            throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u6e90\u6a21\u578b\u5b9e\u4f8b"));
        }
        CallResult callResult = this.Get(psSysModelInst);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u76ee\u6807\u7cfb\u7edf\u6a21\u578b\u5b9e\u4f8b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        SA.SRFDA.PS.Data.PSSysModelInst srcPSSysModelInst = new SA.SRFDA.PS.Data.PSSysModelInst();
        srcPSSysModelInst.setPSSYSMODELINSTID(strSrcPSSysModelInstId);
        callResult = this.Get(srcPSSysModelInst);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6e90\u7cfb\u7edf\u6a21\u578b\u5b9e\u4f8b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (StringHelper.IsNullOrEmpty((String)psSysModelInst.getPSDBSERVERID()) || StringHelper.IsNullOrEmpty((String)srcPSSysModelInst.getPSDBSERVERID())) {
            throw new Exception(StringHelper.Format((String)"\u76ee\u6807\u7cfb\u7edf\u6a21\u578b\u5b9e\u4f8b\u4e0e\u6e90\u7cfb\u7edf\u6a21\u578b\u5b9e\u4f8b\u4e0d\u5339\u914d"));
        }
        PSDBServer psDBServer = new PSDBServer();
        psDBServer.setPSDBSERVERID(psSysModelInst.getPSDBSERVERID());
        IDEDataCtrl psDBServerDataCtrl = this.GetRelatedDataCtrl("DE1891");
        callResult = psDBServerDataCtrl.Get((BaseDataEntity)psDBServer);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6570\u636e\u5e93\u670d\u52a1\u5668\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        PSDBServer psDBServerSrc = new PSDBServer();
        psDBServerSrc.setPSDBSERVERID(srcPSSysModelInst.getPSDBSERVERID());
        callResult = psDBServerDataCtrl.Get((BaseDataEntity)psDBServerSrc);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6570\u636e\u5e93\u670d\u52a1\u5668\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        SA.SRFDA.PS.Data.PSSysModelInst srcPSSysModelInst2 = new SA.SRFDA.PS.Data.PSSysModelInst();
        srcPSSysModelInst2.setPSSYSMODELINSTID(psSysModelInst.getPSSYSMODELINSTID());
        srcPSSysModelInst2.setINSTSTATE("15");
        this.Save(false, srcPSSysModelInst2);
        String strToolFolder = this.getGlobalHelper().getWebExConfig().GetValue("SRFPS", "TOOLFOLDER", "");
        String strCmd = StringHelper.Format((String)"cmd.exe /c %1$s%2$smysql5%2$sbin%2$smysqldump.exe -h %10$s  %3$s  -u %4$s -p%5$s --add-drop-table --set-gtid-purged=OFF --default-character-set=utf8|%1$s%2$ssed%2$ssed.exe -e \"s/DEFINER[ ]*=[ ]*[^*]*\\*/\\*/\" |%1$s%2$smysql5%2$sbin%2$smysql.exe -h %9$s %6$s -u %7$s -p%8$s --default-character-set=utf8", (Object)strToolFolder, (Object)File.separator, (Object)srcPSSysModelInst.getDBNAME(), (Object)psDBServerSrc.getDBUSERNAME(), (Object)psDBServerSrc.getDBPASSWD(), (Object)psSysModelInst.getDBNAME(), (Object)psDBServer.getDBUSERNAME(), (Object)psDBServer.getDBPASSWD(), (Object)psDBServer.getIPADDR(), (Object)psDBServerSrc.getIPADDR());
        log.info((Object)StringHelper.Format((String)"\u51c6\u5907\u6267\u884c\u547d\u4ee4:%1$s", (Object)strCmd));
        log.info((Object)StringHelper.Format((String)"\u6267\u884c\u547d\u4ee4:%1$s\r\n%2$s", (Object)strCmd, (Object)this.runBat(strCmd)));
        psSysModelInst.setMODELVER(srcPSSysModelInst.getMODELVER());
    }

    public CallResult updateCounter(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            SA.SRFDA.PS.Data.PSSysModelInst psSysModelInst = new SA.SRFDA.PS.Data.PSSysModelInst();
            psSysModelInst.proxy(dataEntity);
            this.onUpdateCounter(psSysModelInst);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u66f4\u65b0\u7cfb\u7edf\u6a21\u578b\u8ba1\u6570\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onUpdateCounter(SA.SRFDA.PS.Data.PSSysModelInst psSysModelInst) throws Exception {
        SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory((String)psSysModelInst.getPSSYSMODELINSTID());
        PSSysDBDetailService psSysDBDetailService = (PSSysDBDetailService)ServiceGlobal.getService(PSSysDBDetailService.class, (SessionFactory)sessionFactory);
        ArrayList<PSSysDBDetail> psSysDBDetailList = psSysDBDetailService.select((ISelectCond)new SelectCond());
        HashMap<String, Boolean> psSysDBDetailMap = new HashMap<String, Boolean>();
        for (PSSysDBDetail psSysDBDetail : psSysDBDetailList) {
            psSysDBDetailMap.put(psSysDBDetail.getPSSysDBDetailId(), psSysDBDetail.getDBVer() == psSysDBDetail.getPubDBVer());
        }
        ArrayList<String> psCounterDEList = new ArrayList<String>();
        psCounterDEList.add("PSDCMODELTEMPL");
        psCounterDEList.add("PSWFVERSION");
        psCounterDEList.add("PSDEFIELD");
        psCounterDEList.add("PSDEVIEWBASE");
        psCounterDEList.add("PSWORKFLOW");
        psCounterDEList.add("PSSYSAPP");
        psCounterDEList.add("PSDEACTION");
        psCounterDEList.add("PSDEVSLN");
        psCounterDEList.add("PSDER");
        psCounterDEList.add("PSDEMAINSTATE");
        psCounterDEList.add("PSSYSPFPLUGIN");
        psCounterDEList.add("PSDATAENTITY");
        for (String strDEName : psCounterDEList) {
            IService iService = DEModelGlobal.getDEModel((String)strDEName).getService(sessionFactory);
            SelectCond selectCond = new SelectCond();
            ArrayList arr = iService.select((ISelectCond)selectCond);
            for (Object obj : arr) {
                IEntity iEntity = (IEntity)obj;
                iService.mergeChild("", "", iEntity.get(iService.getDEModel().getKeyDEField().getName()));
            }
        }
        psSysDBDetailList = psSysDBDetailService.select((ISelectCond)new SelectCond());
        for (PSSysDBDetail psSysDBDetail : psSysDBDetailList) {
            Boolean bMatch;
            if (psSysDBDetail.getDBVer() == psSysDBDetail.getPubDBVer() || (bMatch = (Boolean)psSysDBDetailMap.get(psSysDBDetail.getPSSysDBDetailId())) == null || !bMatch.booleanValue()) continue;
            psSysDBDetail.setPubDBVer(psSysDBDetail.getDBVer());
            psSysDBDetailService.update(psSysDBDetail);
        }
    }

    public static void fillPSSysModelVer(ISRFDAGlobalHelper iDAGlobalHelper, PSSysModelVer psSysModelVer) throws Exception {
        if (StringHelper.Compare((String)psSysModelVer.getMODELSQL(), (String)"/*FROMFILE*/", (boolean)true) != 0) {
            return;
        }
        String strSysModelFolder = iDAGlobalHelper.getWebExConfig().GetValue("SRFPS", "SYSMODELFOLDER", null);
        if (StringHelper.Compare((String)psSysModelVer.getSYSTYPE(), (String)"DEPSYS", (boolean)true) == 0) {
            strSysModelFolder = String.valueOf(strSysModelFolder) + "_DEP";
        }
        strSysModelFolder = String.valueOf(strSysModelFolder) + StringHelper.Format((String)"%1$s%2$s%1$s", (Object)File.separator, (Object)psSysModelVer.getMODELVER());
        psSysModelVer.setMODELSQL(PSSysModelInstDataCtrl.readFile(String.valueOf(strSysModelFolder) + "1.sql"));
        psSysModelVer.setMODELSQL2(PSSysModelInstDataCtrl.readFile(String.valueOf(strSysModelFolder) + "2.sql"));
        psSysModelVer.setMODELSQL3(PSSysModelInstDataCtrl.readFile(String.valueOf(strSysModelFolder) + "3.sql"));
        psSysModelVer.setMODELSQL4(PSSysModelInstDataCtrl.readFile(String.valueOf(strSysModelFolder) + "4.sql"));
    }

    static String readFile(String strFilePath) throws Exception {
        StringBuffer sb;
        String strError;
        block16: {
            strError = null;
            sb = new StringBuffer();
            InputStreamReader reader = null;
            try {
                try {
                    int nLength;
                    FileInputStream fis = new FileInputStream(strFilePath);
                    reader = new InputStreamReader((InputStream)fis, "UTF-8");
                    char[] buf = new char[4096];
                    while ((nLength = reader.read(buf)) != -1) {
                        sb.append(new String(buf, 0, nLength));
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                    strError = e.toString();
                    if (reader != null) {
                        try {
                            reader.close();
                        }
                        catch (IOException e1) {
                            strError = e1.toString();
                        }
                    }
                    break block16;
                }
            }
            catch (Throwable throwable) {
                if (reader != null) {
                    try {
                        reader.close();
                    }
                    catch (IOException e1) {
                        strError = e1.toString();
                    }
                }
                throw throwable;
            }
            if (reader != null) {
                try {
                    reader.close();
                }
                catch (IOException e1) {
                    strError = e1.toString();
                }
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)strError)) {
            throw new Exception(strError);
        }
        return sb.toString();
    }

    public CallResult closeSessionFactory(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            SA.SRFDA.PS.Data.PSSysModelInst psSysModelInst = new SA.SRFDA.PS.Data.PSSysModelInst();
            psSysModelInst.proxy(dataEntity);
            PSSysModelInstGlobal.resetSessionFactory((String)psSysModelInst.getPSSYSMODELINSTID());
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5173\u95ed\u6a21\u578b\u5b9e\u4f8b\u4f1a\u8bdd\u5de5\u5382\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    public CallResult updateUsedSize(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            final SA.SRFDA.PS.Data.PSSysModelInst psSysModelInst = new SA.SRFDA.PS.Data.PSSysModelInst();
            psSysModelInst.proxy(dataEntity);
            this.Get(psSysModelInst);
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

                @Override
                public void execute(Object obj) throws Exception {
                    PSSysModelInstDataCtrl.this.onUpdateUsedSize(psSysModelInst);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u66f4\u65b0\u6a21\u578b\u5b9e\u4f8b\u7a7a\u95f4\u4fe1\u606f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onUpdateUsedSize(SA.SRFDA.PS.Data.PSSysModelInst psSysModelInst) throws Exception {
        PSSysModelInstService psSysModelInstService = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        IPSDBType2 iPSDBType = (IPSDBType2)this.getPSModelStorage().getPSDBType(psSysModelInst.getDBTYPE());
        BaseDataEntity entity = new BaseDataEntity();
        PSSysModelInstImpl psSysModelInstImpl = null;
        Vector<BaseDataEntity> rowCountList = new Vector<BaseDataEntity>();
        try {
            psSysModelInstImpl = new PSSysModelInstImpl();
            psSysModelInstImpl.init(this.getGlobalHelper(), psSysModelInst);
            CallResult callResult = iPSDBType.getDBUsedSize(psSysModelInstImpl, entity);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u6a21\u578b\u5b9e\u4f8b\u4f7f\u7528\u7a7a\u95f4\u60c5\u51b5\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            callResult = iPSDBType.getTableSummaries(psSysModelInstImpl, rowCountList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u6a21\u578b\u5b9e\u4f8b\u8868\u6982\u8981\u6570\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            if (psSysModelInstImpl != null) {
                psSysModelInstImpl.close();
            }
        }
        catch (Exception ex) {
            if (psSysModelInstImpl != null) {
                psSysModelInstImpl.close();
            }
            throw ex;
        }
        PSSysModelInst psSysModelInstV5 = new PSSysModelInst();
        psSysModelInstV5.setPSSysModelInstId(psSysModelInst.getPSSYSMODELINSTID());
        psSysModelInstV5.setUsedSize(Integer.valueOf(entity.GetParamIntValue("USEDSIZE", 0)));
        psSysModelInstV5.setRowCnt(Integer.valueOf(entity.GetParamIntValue("ROWCNT", 0)));
        psSysModelInstService.update(psSysModelInstV5, true);
    }

    public CallResult cleanDBInst(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            final SA.SRFDA.PS.Data.PSSysModelInst psSysModelInst = new SA.SRFDA.PS.Data.PSSysModelInst();
            psSysModelInst.proxy(dataEntity);
            this.Get(psSysModelInst);
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

                @Override
                public void execute(Object obj) throws Exception {
                    PSSysModelInstDataCtrl.this.onCleanDBInst(psSysModelInst);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u6e05\u7406\u6a21\u578b\u5b9e\u4f8b\u4fe1\u606f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onCleanDBInst(SA.SRFDA.PS.Data.PSSysModelInst psSysModelInst) throws Exception {
        IPSDBType2 iPSDBType = (IPSDBType2)this.getPSModelStorage().getPSDBType(psSysModelInst.getDBTYPE());
        BaseDataEntity entity = new BaseDataEntity();
        PSSysModelInstImpl psSysModelInstImpl = null;
        Vector<BaseDataEntity> rowCountList = new Vector<BaseDataEntity>();
        try {
            String strDEName;
            psSysModelInstImpl = new PSSysModelInstImpl();
            psSysModelInstImpl.init(this.getGlobalHelper(), psSysModelInst);
            CallResult callResult = iPSDBType.getTableSummaries(psSysModelInstImpl, rowCountList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u6a21\u578b\u5b9e\u4f8b\u8868\u6982\u8981\u6570\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            for (BaseDataEntity tableSummary : rowCountList) {
                strDEName = tableSummary.getParamStringValue("TABLE_NAME", "").toUpperCase();
                if (strDEName.indexOf("T_SRFPS") != 0 || strDEName.indexOf("_TMP") == -1) continue;
                int nRowCnt = 0;
                nRowCnt = tableSummary.ContainesParam("ROWCNT") ? tableSummary.GetParamIntValue("ROWCNT", 0) : tableSummary.GetParamIntValue("TABLE_ROWS", 0);
                if (nRowCnt <= 0 || !(callResult = iPSDBType.callCreateDBModelSql(psSysModelInstImpl, StringHelper.Format((String)"DELETE FROM %1$s", (Object)tableSummary.getParamValue("TABLE_NAME")))).isError()) continue;
                log.error((Object)StringHelper.Format((String)"\u6e05\u7406\u4e34\u65f6\u8868[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)tableSummary.getParamValue("TABLE_NAME"), (Object)callResult.getErrorInfo()));
            }
            for (BaseDataEntity tableSummary : rowCountList) {
                strDEName = tableSummary.getParamStringValue("TABLE_NAME", "").toUpperCase();
                if (strDEName.indexOf("T_SRFPS") != 0 || !(callResult = iPSDBType.callCreateDBModelSql(psSysModelInstImpl, StringHelper.Format((String)"OPTIMIZE TABLE %1$s", (Object)tableSummary.getParamValue("TABLE_NAME")))).isError()) continue;
                log.error((Object)StringHelper.Format((String)"\u4f18\u5316\u4e34\u65f6\u8868[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)tableSummary.getParamValue("TABLE_NAME"), (Object)callResult.getErrorInfo()));
            }
            if (psSysModelInstImpl != null) {
                psSysModelInstImpl.close();
            }
        }
        catch (Exception ex) {
            if (psSysModelInstImpl != null) {
                psSysModelInstImpl.close();
            }
            throw ex;
        }
    }

    public CallResult backupDBInst(BaseDataEntity dataEntity, boolean bOffline) {
        CallResult callResult = new CallResult();
        try {
            final SA.SRFDA.PS.Data.PSSysModelInst psSysModelInst = new SA.SRFDA.PS.Data.PSSysModelInst();
            final boolean bOffline2 = bOffline;
            psSysModelInst.proxy(dataEntity);
            this.Get(psSysModelInst);
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

                @Override
                public void execute(Object obj) throws Exception {
                    PSSysModelInstDataCtrl.this.onBackupDBInst(psSysModelInst, bOffline2);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5907\u4efd\u6a21\u578b\u5b9e\u4f8b\u4fe1\u606f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onBackupDBInst(SA.SRFDA.PS.Data.PSSysModelInst psSysModelInst, boolean bOffline) throws Exception {
        IPSDBType iPSDBType = this.getPSModelStorage().getPSDBType(psSysModelInst.getDBTYPE());
        if (!(iPSDBType instanceof IPSDBType4)) {
            throw new Exception(StringHelper.Format((String)"\u6570\u636e\u5e93\u7c7b\u578b[%1$s]\u4e0d\u652f\u6301\u6b64\u64cd\u4f5c", (Object)iPSDBType.getName()));
        }
        IPSDBType4 iPSDBType4 = (IPSDBType4)((Object)iPSDBType);
        PSSysModelInstBK psSysModelInstBk = new PSSysModelInstBK();
        psSysModelInstBk.setPSSYSMODELINSTID(psSysModelInst.getPSSYSMODELINSTID());
        psSysModelInstBk.setPSSYSMODELINSTNAME(psSysModelInst.getPSSYSMODELINSTNAME());
        psSysModelInstBk.setPSTASKSERVERID(this.getPSModelStorage().getPSTaskServerEnv().getId());
        psSysModelInstBk.setPSTASKSERVERNAME(this.getPSModelStorage().getPSTaskServerEnv().getName());
        iPSDBType4.backupDBInst("PSSYSMODELINST", psSysModelInst, psSysModelInstBk, bOffline);
    }

    public CallResult restoreDBInst(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            final SA.SRFDA.PS.Data.PSSysModelInst psSysModelInst = new SA.SRFDA.PS.Data.PSSysModelInst();
            psSysModelInst.proxy(dataEntity);
            this.Get(psSysModelInst);
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

                @Override
                public void execute(Object obj) throws Exception {
                    PSSysModelInstDataCtrl.this.onRestoreDBInst(psSysModelInst);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5907\u4efd\u6a21\u578b\u5b9e\u4f8b\u7a7a\u95f4\u4fe1\u606f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onRestoreDBInst(SA.SRFDA.PS.Data.PSSysModelInst psSysModelInst) throws Exception {
        IPSDBType iPSDBType = this.getPSModelStorage().getPSDBType(psSysModelInst.getDBTYPE());
        if (!(iPSDBType instanceof IPSDBType4)) {
            throw new Exception(StringHelper.Format((String)"\u6570\u636e\u5e93\u7c7b\u578b[%1$s]\u4e0d\u652f\u6301\u6b64\u64cd\u4f5c", (Object)iPSDBType.getName()));
        }
        IPSDBType4 iPSDBType4 = (IPSDBType4)((Object)iPSDBType);
        PSSysModelInstBK psSysModelInstBk = new PSSysModelInstBK();
        iPSDBType4.restoreDBInst("PSSYSMODELINST", psSysModelInst, psSysModelInstBk);
        psSysModelInstBk.setPSSYSMODELINSTID(psSysModelInst.getPSSYSMODELINSTID());
        psSysModelInstBk.setPSSYSMODELINSTNAME(psSysModelInst.getPSSYSMODELINSTNAME());
        psSysModelInstBk.setPSTASKSERVERID(this.getPSModelStorage().getPSTaskServerEnv().getId());
        psSysModelInstBk.setPSTASKSERVERNAME(this.getPSModelStorage().getPSTaskServerEnv().getName());
    }

    public CallResult exportV2Model(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            final SA.SRFDA.PS.Data.PSSysModelInst psSysModelInst = new SA.SRFDA.PS.Data.PSSysModelInst();
            psSysModelInst.proxy(dataEntity);
            this.Get(psSysModelInst);
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

                @Override
                public void execute(Object obj) throws Exception {
                    PSSysModelInstDataCtrl.this.onExportV2Model(psSysModelInst);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5bfc\u51fa\u5b9e\u4f8b\u6a21\u578bV2\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onExportV2Model(SA.SRFDA.PS.Data.PSSysModelInst psSysModelInst) throws Exception {
        boolean bExportSimple = false;
        if (bExportSimple) {
            this.testPSMOS(psSysModelInst);
        } else {
            PSModelV2Helper psModelV2Helper = new PSModelV2Helper();
            psModelV2Helper.init(null, psSysModelInst.getPSSYSMODELINSTID());
            String strFolder = PSTaskServerEnvImpl.getCurrent().createTempFolder();
            File folder = new File(String.valueOf(strFolder) + "MODEL");
            if (!folder.exists()) {
                folder.mkdirs();
            }
            if (!(folder = new File(String.valueOf(strFolder) + "MODEL2")).exists()) {
                folder.mkdirs();
            }
            if (!(folder = new File(String.valueOf(strFolder) + "RES")).exists()) {
                folder.mkdirs();
            }
            psModelV2Helper.export(String.valueOf(strFolder) + "MODEL", String.valueOf(strFolder) + "RES");
        }
    }

    protected void testPSMOS(SA.SRFDA.PS.Data.PSSysModelInst psSysModelInst) throws Exception {
        SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory((String)psSysModelInst.getPSSYSMODELINSTID());
        PSSystemService psSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)sessionFactory);
        ArrayList psSystemList = psSystemService.select((ISelectCond)new SelectCond());
        if (psSystemList.size() == 0) {
            return;
        }
        PSCoreSysServiceBase.setMOSVer((int)2);
        PSSystem psSystem = (PSSystem)psSystemList.get(0);
        PSCoreSysServiceBase.setCurrentPSSvrDomainId((String)"SVRDOMAIN0001");
        PSCoreSysServiceBase.setEnableGitLabPlugin((boolean)true);
        PSCoreSysServiceBase.setPSGitLabPlugin((IPSGitLabPlugin)new PSGitLabPluginImpl2());
        PSCoreSysServiceBase.setCurrentPSDevSlnSysId((String)"C4F6A0A6-084D-4983-B1D6-414F757C323C");
        PSCoreSysServiceBase.setCurrentPSSystemId((String)psSystem.getPSSystemId());
        PSMOSFile psMOSFile = new PSMOSFile();
        psMOSFile.setPSModelType("PSSYSTEM");
        psMOSFile.setPSModelId(psSystem.getPSSystemId());
        boolean bWiki = true;
        if (bWiki) {
            String strContent = psSystemService.getFileWiki(psMOSFile, "/psmodules/Module/psdataentities/ENTITY");
            strContent = StringHelper.IsNullOrEmpty((String)strContent) ? "\u65b0\u5efaWiki" : "\u66f4\u65b0" + strContent;
            psSystemService.updateFileWiki(psMOSFile, "/psmodules/Module/psdataentities/ENTITY", strContent);
            strContent = psSystemService.getFileWiki(psMOSFile, "/psmodules/Module/psdataentities/ENTITY");
            return;
        }
        this.outputPSMOSFiles(psSystemService, psSystem, "/");
        this.outputPSMOSFiles(psSystemService, psSystem, "/psmodules");
        this.outputPSMOSFiles(psSystemService, psSystem, "/psmodules/OrderMgr");
        this.outputPSMOSFiles(psSystemService, psSystem, "/psmodules/OrderMgr/psdataentities/ORDER");
        this.outputPSMOSFiles(psSystemService, psSystem, "/psmodules/OrderMgr/psdataentities/ORDER/minorpsders/DER1N_ORDER_CUSTOMER_CUSTOMERID/psdefields");
        this.outputPSMOSFile(psSystemService, psSystem, "/psmodules/OrderMgr/psdataentities/ORDER");
        this.outputPSMOSFile(psSystemService, psSystem, "/psmodules/OrderMgr/psdataentities/ORDER/psdeforms/Main");
        PSDataEntity psDataEntity = new PSDataEntity();
        psDataEntity.setPSDataEntityId("fb256ae72dcecd2acf433f6640cd2648");
        PSDataEntityService psDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)psSysModelInst.getPSSYSMODELINSTID()));
        psDataEntityService.get(psDataEntity);
        String strRet = psDataEntityService.exportModelV2Ex(psDataEntity, "YAML");
        log.debug((Object)strRet);
        PSMOSFile formPSMOSFile = psSystemService.getFile(psMOSFile, "/psmodules/OrderMgr/psdataentities/ORDER/psdeforms/Main");
        PSDEForm psDEForm = new PSDEForm();
        psDEForm.setPSDEFormId(formPSMOSFile.getPSModelId());
        PSDEFormService psDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)psSysModelInst.getPSSYSMODELINSTID()));
        psDEFormService.get(psDEForm);
        strRet = psDEFormService.exportModelV2Ex(psDEForm, "YAML");
        log.debug((Object)strRet);
        PSDEForm psDEForm2 = new PSDEForm();
        psDEForm2.setPSDEFormId(formPSMOSFile.getPSModelId());
        psDEFormService.importModelV2Ex(psDEForm2, strRet, "YAML");
        PSDEForm psDEForm3 = new PSDEForm();
        psDEForm3.setPSDEFormId(formPSMOSFile.getPSModelId());
        psDEFormService.get(psDEForm3);
        String strRet2 = psDEFormService.exportModelV2Ex(psDEForm3, "YAML");
        if (StringHelper.Compare((String)strRet, (String)strRet2, (boolean)false) != 0) {
            log.debug((Object)strRet2);
            throw new Exception("\u4e24\u6b21\u5bfc\u51fa\u5185\u5bb9\u4e0d\u4e00\u81f4");
        }
        PSMOSFile psMOSFile2 = psSystemService.createFile(psMOSFile, "/psmodules/OrderMgr/psdataentities/ORDER1234/psdefields/ABC", null);
    }

    protected void outputPSMOSFiles(PSSystemService psSystemService, PSSystem psSystem, String strPath) {
        try {
            PSMOSFile psMOSFile = new PSMOSFile();
            psMOSFile.setPSModelType("PSSYSTEM");
            psMOSFile.setPSModelId(psSystem.getPSSystemId());
            PSMOSFile[] files = psSystemService.listFiles(psMOSFile, strPath, null);
            if (files == null || files.length == 0) {
                log.warn((Object)StringHelper.Format((String)"\u67e5\u8be2\u8def\u5f84[%1$s]\u8fd4\u56denull", (Object)strPath));
                return;
            }
            log.info((Object)StringHelper.Format((String)"\u67e5\u8be2\u8def\u5f84[%1$s]\u8fd4\u56de\u5bf9\u8c61[%2$s]", (Object)strPath, (Object)files.length));
            int i = 0;
            while (i < files.length) {
                log.info((Object)StringHelper.Format((String)"[%1$s][%2$s][%3$s]", (Object)i, (Object)files[i].getPSMOSFileName(), (Object)files[i].getPSMOSFileId()));
                ++i;
            }
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u8def\u5f84[%1$s]\u5f02\u5e38\uff0c%2$s", (Object)strPath, (Object)ex.getMessage()));
        }
    }

    protected void outputPSMOSFile(PSSystemService psSystemService, PSSystem psSystem, String strPath) {
        try {
            PSMOSFile psMOSFile = psSystemService.getFile((IEntity)psSystem);
            PSMOSFile file = psSystemService.getFile(psMOSFile, strPath);
            if (file == null) {
                log.warn((Object)StringHelper.Format((String)"\u67e5\u8be2\u8def\u5f84[%1$s]\u8fd4\u56denull", (Object)strPath));
                return;
            }
            log.info((Object)StringHelper.Format((String)"\u67e5\u8be2\u8def\u5f84[%1$s]\u8fd4\u56de\u5bf9\u8c61[%2$s][%3$s][%4$s][%5$s][%6$s]", (Object)strPath, (Object)file.getPSModelType(), (Object)file.getPSModelId(), (Object)file.getFileTag(), (Object)file.getPSMOSFileName(), (Object)file.getPSMOSFileId()));
            PSMOSFile file2 = psSystemService.getFileSummary(psMOSFile, strPath);
            if (file2 == null) {
                log.warn((Object)StringHelper.Format((String)"\u67e5\u8be2\u8def\u5f84[%1$s]\u8fd4\u56denull", (Object)strPath));
                return;
            }
            log.debug((Object)mapper.writeValueAsString((Object)file2.toDTOMap()));
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u8def\u5f84[%1$s]\u5f02\u5e38\uff0c%2$s", (Object)strPath, (Object)ex.getMessage()));
        }
    }

    public CallResult importV2Model(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            final SA.SRFDA.PS.Data.PSSysModelInst psSysModelInst = new SA.SRFDA.PS.Data.PSSysModelInst();
            psSysModelInst.proxy(dataEntity);
            this.Get(psSysModelInst);
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

                @Override
                public void execute(Object obj) throws Exception {
                    PSSysModelInstDataCtrl.this.onImportV2Model(psSysModelInst);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5bfc\u5165\u5b9e\u4f8b\u6a21\u578bV2\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onImportV2Model(SA.SRFDA.PS.Data.PSSysModelInst psSysModelInst) throws Exception {
        IPSWorkspace iPSWorkspace = null;
        PSModelV2Helper psModelV2Helper = new PSModelV2Helper();
        psModelV2Helper.init(null, psSysModelInst.getPSSYSMODELINSTID());
        psModelV2Helper.setPSWorkspace(iPSWorkspace);
        String strFolder = PSTaskServerEnvImpl.getCurrent().createTempFolder();
        File folder = new File(String.valueOf(strFolder) + "MODEL2");
        if (!folder.exists()) {
            folder.mkdirs();
        }
        psModelV2Helper.compile(String.valueOf(strFolder) + "MODEL2", "C:\\SRFEX_TEMP\\2019-09-14\\MODEL", false);
        psModelV2Helper.import2(String.valueOf(strFolder) + "MODEL2" + File.separator + "DATAS");
    }

    public CallResult backupV2Model(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            final SA.SRFDA.PS.Data.PSSysModelInst psSysModelInst = new SA.SRFDA.PS.Data.PSSysModelInst();
            psSysModelInst.proxy(dataEntity);
            this.Get(psSysModelInst);
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

                @Override
                public void execute(Object obj) throws Exception {
                    PSSysModelInstDataCtrl.this.onBackupV2Model(psSysModelInst);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5907\u4efd\u5b9e\u4f8b\u6a21\u578bV2\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onBackupV2Model(SA.SRFDA.PS.Data.PSSysModelInst psSysModelInst) throws Exception {
        PSModelV2Helper psModelV2Helper = new PSModelV2Helper();
        psModelV2Helper.init(null, psSysModelInst.getPSSYSMODELINSTID());
        String strFolder = PSTaskServerEnvImpl.getCurrent().createTempFolder();
        File folder = new File(String.valueOf(strFolder) + "MODEL3");
        if (!folder.exists()) {
            folder.mkdirs();
        }
        psModelV2Helper.backup(String.valueOf(strFolder) + "MODEL3");
    }

    public CallResult restoreV2Model(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            final SA.SRFDA.PS.Data.PSSysModelInst psSysModelInst = new SA.SRFDA.PS.Data.PSSysModelInst();
            psSysModelInst.proxy(dataEntity);
            this.Get(psSysModelInst);
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

                @Override
                public void execute(Object obj) throws Exception {
                    PSSysModelInstDataCtrl.this.onRestoreV2Model(psSysModelInst);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u6062\u590d\u5b9e\u4f8b\u6a21\u578bV2\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onRestoreV2Model(SA.SRFDA.PS.Data.PSSysModelInst psSysModelInst) throws Exception {
        PSModelV2Helper psModelV2Helper = new PSModelV2Helper();
        psModelV2Helper.init(null, psSysModelInst.getPSSYSMODELINSTID());
        psModelV2Helper.restore("C:\\SRFEX_TEMP\\2019-09-14\\MODEL3");
    }

    public CallResult onlineModel(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            final SA.SRFDA.PS.Data.PSSysModelInst psSysModelInst = new SA.SRFDA.PS.Data.PSSysModelInst();
            psSysModelInst.proxy(dataEntity);
            this.Get(psSysModelInst);
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

                @Override
                public void execute(Object obj) throws Exception {
                    PSSysModelInstDataCtrl.this.onOnlineModel(psSysModelInst);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u8fde\u7ebf\u5b9e\u4f8b\u6a21\u578bV2\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onOnlineModel(SA.SRFDA.PS.Data.PSSysModelInst psSysModelInst) throws Exception {
        PSSysModelInstHelper.online(psSysModelInst.getPSSYSMODELINSTID());
    }

    protected void dealPaste(SA.SRFDA.PS.Data.PSSysModelInst psSysModelInst) throws Exception {
        SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory((String)psSysModelInst.getPSSYSMODELINSTID());
        PSDEServiceAPIService psDEServiceAPIService = (PSDEServiceAPIService)ServiceGlobal.getService(PSDEServiceAPIService.class, (SessionFactory)sessionFactory);
        PSDEServiceAPI psDEServiceAPI = new PSDEServiceAPI();
        psDEServiceAPI.setPSDEServiceAPIId("390726870b5604664515ee12c3847708");
        psDEServiceAPIService.get(psDEServiceAPI);
        PSHelpSection[] helps = psDEServiceAPIService.getPasteHelps(null);
        if (helps != null) {
            PSHelpSection[] pSHelpSectionArray = helps;
            int n = helps.length;
            int n2 = 0;
            while (n2 < n) {
                PSHelpSection psHelpSection = pSHelpSectionArray[n2];
                System.out.println(psHelpSection.getContent());
                ++n2;
            }
        }
    }

    protected void dealMOS(SA.SRFDA.PS.Data.PSSysModelInst psSysModelInst) throws Exception {
        SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory((String)psSysModelInst.getPSSYSMODELINSTID());
        PSSysModelInstGlobal.activeAlways((String)psSysModelInst.getPSSYSMODELINSTID());
        MOSHelper mosHelper = new MOSHelper(sessionFactory);
        mosHelper.init();
    }

    protected void dealV6(SA.SRFDA.PS.Data.PSSysModelInst psSysModelInst) throws Exception {
        SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory((String)psSysModelInst.getPSSYSMODELINSTID());
        PSSystemService psSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)sessionFactory);
        ArrayList psSystemList = psSystemService.select((ISelectCond)new SelectCond());
        if (psSystemList.size() != 1) {
            return;
        }
        try {
            PSSysModelInstGlobal.activeAlways((String)psSysModelInst.getPSSYSMODELINSTID());
            PSSystem psSystem = (PSSystem)psSystemList.get(0);
            PSCoreSysServiceBase.setEnableMergeCount((boolean)false);
            PSCoreSysServiceBase.beginImpSysModel((PSSystem)psSystem);
            HashMap<String, PSDataEntity> modelV2Map = new HashMap<String, PSDataEntity>();
            Iterator modelV2s = PSModelV2Helper.getExportModelV2s();
            while (modelV2s.hasNext()) {
                modelV2Map.put((String)modelV2s.next(), null);
            }
            modelV2Map.put("PSAPPVIEW", null);
            PSDataEntityService psDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)sessionFactory);
            ArrayList<PSDataEntity> psDataEntities = psDataEntityService.selectByPSSystem((PSSystemBase)psSystem);
            for (PSDataEntity psDataEntity : psDataEntities) {
                if (!modelV2Map.containsKey(psDataEntity.getPSDataEntityName())) continue;
                modelV2Map.put(psDataEntity.getPSDataEntityName(), psDataEntity);
            }
            this.onInitV6MosQuickInfoViewUAGroup_Major(psSystem, modelV2Map, sessionFactory);
            PSCoreSysServiceBase.endImpSysModel();
        }
        catch (Exception ex) {
            log.error((Object)ex);
            PSCoreSysServiceBase.endImpSysModel();
        }
    }

    protected void onInitV6MosQuickInfoViewToolbar(PSSystem psSystem, Map<String, PSDataEntity> modelV2Map, SessionFactory sessionFactory) throws Exception {
        PSDEViewBaseService psDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)sessionFactory);
        PSDEUAGroupService psDEUAGroupService = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)sessionFactory);
        PSDEViewCtrlService psDEViewCtrlService = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)sessionFactory);
        for (PSDataEntity psDataEntity : modelV2Map.values()) {
            if (psDataEntity == null) continue;
            PSDEViewBase psDEViewBase = new PSDEViewBase();
            psDEViewBase.setPSDEViewBaseId(KeyValueHelper.genUniqueId((String)psDataEntity.getPSDataEntityId(), (String)"MosQuickInfoView"));
            if (psDEViewBaseService.checkKey(psDEViewBase) != 1) continue;
            PSDEUAGroup psDEUAGroup = new PSDEUAGroup();
            psDEUAGroup.setPSDEUAGroupId(KeyValueHelper.genUniqueId((String)psDataEntity.getPSDataEntityId(), (String)"MosQuickInfo"));
            if (psDEUAGroupService.checkKey(psDEUAGroup) != 1) continue;
            PSDEViewCtrl psDEViewCtrl = new PSDEViewCtrl();
            psDEViewCtrl.setPSDEViewCtrlId(KeyValueHelper.genUniqueId((String)psDEViewBase.getPSDEViewBaseId(), (String)"TOOLBAR"));
            psDEViewCtrl.setPSDEViewCtrlName("TOOLBAR");
            psDEViewCtrl.setPSDEViewCtrlType("TOOLBAR");
            psDEViewCtrl.setPSDEViewBaseId(psDEViewBase.getPSDEViewBaseId());
            psDEViewCtrl.setPSDEId(psDataEntity.getPSDataEntityId());
            psDEViewCtrl.setPSDEName(psDataEntity.getPSDataEntityName());
            psDEViewCtrl.setValidFlag(Integer.valueOf(1));
            psDEViewCtrl.setPSDEToolbarId("C2CB6BEE-316A-45D9-A419-E72F358022A6");
            psDEViewCtrl.setPSDEToolbarName("\u5de5\u5177\u680f\u6a21\u677f\uff08\u7eaf\u754c\u9762\u884c\u4e3a\u7ec41-6\uff09");
            psDEViewCtrl.setPSDEUAGroupId(psDEUAGroup.getPSDEUAGroupId());
            psDEViewCtrl.setPSDEUAGroupName("mos-quick-info");
            psDEViewCtrlService.create(psDEViewCtrl, false);
        }
    }

    protected void onInitV6MosQuickInfoViews(PSSystem psSystem, Map<String, PSDataEntity> modelV2Map, SessionFactory sessionFactory) throws Exception {
        PSDEViewBaseService psDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)sessionFactory);
        for (PSDataEntity psDataEntity : modelV2Map.values()) {
            if (psDataEntity == null) continue;
            PSDEViewBase psDEViewBase = new PSDEViewBase();
            psDEViewBase.setPSDEViewBaseId(KeyValueHelper.genUniqueId((String)psDataEntity.getPSDataEntityId(), (String)"MosQuickInfoView"));
            if (psDEViewBaseService.checkKey(psDEViewBase) == 1) continue;
            psDEViewBase.setPSDEViewBaseName(StringHelper.Format((String)"%1$sMOS\u4fe1\u606f\u89c6\u56fe", (Object)psDataEntity.getLogicName()));
            psDEViewBase.setPSDEViewBaseType("DEEDITVIEW");
            psDEViewBase.setCodeName("MosQuickInfoView");
            psDEViewBase.setPSDEId(psDataEntity.getPSDataEntityId());
            psDEViewBase.setPSDEName(psDataEntity.getPSDataEntityName());
            psDEViewBase.setPSSystemId(psSystem.getPSSystemId());
            psDEViewBase.setPSSystemName(psSystem.getPSSystemName());
            psDEViewBase.setWidth(Integer.valueOf(350));
            psDEViewBase.setTitle(StringHelper.Format((String)"%1$s\u4fe1\u606f\u89c6\u56fe", (Object)psDataEntity.getLogicName()));
            psDEViewBase.setCaption(StringHelper.Format((String)"%1$s", (Object)psDataEntity.getLogicName()));
            psDEViewBase.setShowCaptionBar(Integer.valueOf(1));
            psDEViewBase.setViewParam5(Integer.valueOf(0));
            psDEViewBase.setReadOnlyMode(Integer.valueOf(1));
            psDEViewBaseService.create(psDEViewBase, false);
        }
    }

    protected void onFixV6MosQuickInfoViews(PSSystem psSystem, Map<String, PSDataEntity> modelV2Map, SessionFactory sessionFactory) throws Exception {
        PSDEViewBaseService psDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)sessionFactory);
        for (PSDataEntity psDataEntity : modelV2Map.values()) {
            if (psDataEntity == null) continue;
            PSDEViewBase psDEViewBase = new PSDEViewBase();
            psDEViewBase.setPSDEViewBaseId(KeyValueHelper.genUniqueId((String)psDataEntity.getPSDataEntityId(), (String)"MosQuickInfoView"));
            if (psDEViewBaseService.checkKey(psDEViewBase) != 1) continue;
            psDEViewBase.setCaption(StringHelper.Format((String)"%1$s", (Object)psDataEntity.getLogicName()));
            psDEViewBaseService.sysUpdate(psDEViewBase, false);
        }
    }

    protected void onInitV6DEUAGroups(PSSystem psSystem, Map<String, PSDataEntity> modelV2Map, SessionFactory sessionFactory) throws Exception {
        PSDEUAGroup psDEUAGroup;
        PSDEUAGroupService psDEUAGroupService = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)sessionFactory);
        for (PSDataEntity psDataEntity : modelV2Map.values()) {
            if (psDataEntity == null) continue;
            psDEUAGroup = new PSDEUAGroup();
            psDEUAGroup.setPSDEUAGroupId(KeyValueHelper.genUniqueId((String)psDataEntity.getPSDataEntityId(), (String)"MosExplorerQuick"));
            if (psDEUAGroupService.checkKey(psDEUAGroup) == 1) continue;
            psDEUAGroup.setPSDEUAGroupName("mos-explorer-quick");
            psDEUAGroup.setPSDEId(psDataEntity.getPSDataEntityId());
            psDEUAGroup.setPSDEName(psDataEntity.getPSDataEntityName());
            psDEUAGroup.setPSSystemId(psSystem.getPSSystemId());
            psDEUAGroup.setPSSystemName(psSystem.getPSSystemName());
            psDEUAGroup.setCodeName("MosExplorerQuick");
            psDEUAGroupService.create(psDEUAGroup, false);
        }
        for (PSDataEntity psDataEntity : modelV2Map.values()) {
            if (psDataEntity == null) continue;
            psDEUAGroup = new PSDEUAGroup();
            psDEUAGroup.setPSDEUAGroupId(KeyValueHelper.genUniqueId((String)psDataEntity.getPSDataEntityId(), (String)"MosExplorerMain"));
            if (psDEUAGroupService.checkKey(psDEUAGroup) == 1) continue;
            psDEUAGroup.setPSDEUAGroupName("mos-explorer-main");
            psDEUAGroup.setPSDEId(psDataEntity.getPSDataEntityId());
            psDEUAGroup.setPSDEName(psDataEntity.getPSDataEntityName());
            psDEUAGroup.setPSSystemId(psSystem.getPSSystemId());
            psDEUAGroup.setPSSystemName(psSystem.getPSSystemName());
            psDEUAGroup.setCodeName("MosExplorerMain");
            psDEUAGroupService.create(psDEUAGroup, false);
        }
    }

    protected void onInitV6MosQuickInfoViewUAGroups(PSSystem psSystem, Map<String, PSDataEntity> modelV2Map, SessionFactory sessionFactory) throws Exception {
        PSDEUAGroupService psDEUAGroupService = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)sessionFactory);
        for (PSDataEntity psDataEntity : modelV2Map.values()) {
            if (psDataEntity == null) continue;
            PSDEUAGroup psDEUAGroup = new PSDEUAGroup();
            psDEUAGroup.setPSDEUAGroupId(KeyValueHelper.genUniqueId((String)psDataEntity.getPSDataEntityId(), (String)"MosQuickInfo"));
            if (psDEUAGroupService.checkKey(psDEUAGroup) == 1) continue;
            psDEUAGroup.setPSDEUAGroupName("mos-quick-info");
            psDEUAGroup.setPSDEId(psDataEntity.getPSDataEntityId());
            psDEUAGroup.setPSDEName(psDataEntity.getPSDataEntityName());
            psDEUAGroup.setPSSystemId(psSystem.getPSSystemId());
            psDEUAGroup.setPSSystemName(psSystem.getPSSystemName());
            psDEUAGroup.setCodeName("MosQuickInfo");
            psDEUAGroupService.create(psDEUAGroup, false);
        }
    }

    protected void onInitV6MosQuickInfoViewForms(PSSystem psSystem, Map<String, PSDataEntity> modelV2Map, SessionFactory sessionFactory) throws Exception {
        PSDEFormService psDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)sessionFactory);
        PSDEFormDetailService psDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)sessionFactory);
        for (PSDataEntity psDataEntity : modelV2Map.values()) {
            if (psDataEntity == null) continue;
            PSDEForm psDEForm = new PSDEForm();
            psDEForm.setPSDEFormId(KeyValueHelper.genUniqueId((String)psDataEntity.getPSDataEntityId(), (String)"MosQuickInfo"));
            if (psDEFormService.checkKey(psDEForm) == 1) continue;
            psDEForm.setFormType("EDITFORM");
            psDEForm.setPSDEFormName("mos-quick-info");
            psDEForm.setPSDEId(psDataEntity.getPSDataEntityId());
            psDEForm.setPSDEName(psDataEntity.getPSDataEntityName());
            psDEForm.setCodeName("MosQuickInfo");
            psDEForm.setInfoFormFlag(Integer.valueOf(3));
            psDEForm.setLabelWidth(Integer.valueOf(100));
            psDEFormService.create(psDEForm, false);
            PSDEFormDetail formpage1 = new PSDEFormDetail();
            formpage1.setPSDEFormDetailId(KeyValueHelper.genUniqueId((String)psDEForm.getPSDEFormId(), (String)"formpage1"));
            formpage1.setPSDEFormId(psDEForm.getPSDEFormId());
            formpage1.setPSDEFormDetailName("formpage1");
            formpage1.setDetailType("FORMPAGE");
            formpage1.setOrderValue(Integer.valueOf(1));
            formpage1.setCaption("\u57fa\u672c\u4fe1\u606f");
            psDEFormDetailService.create(formpage1, false);
        }
    }

    protected void onInitV6MosQuickInfoViewForm(PSSystem psSystem, Map<String, PSDataEntity> modelV2Map, SessionFactory sessionFactory) throws Exception {
        PSDEViewBaseService psDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)sessionFactory);
        PSDEFormService psDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)sessionFactory);
        PSDEViewCtrlService psDEViewCtrlService = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)sessionFactory);
        for (PSDataEntity psDataEntity : modelV2Map.values()) {
            if (psDataEntity == null) continue;
            PSDEViewBase psDEViewBase = new PSDEViewBase();
            psDEViewBase.setPSDEViewBaseId(KeyValueHelper.genUniqueId((String)psDataEntity.getPSDataEntityId(), (String)"MosQuickInfoView"));
            if (psDEViewBaseService.checkKey(psDEViewBase) != 1) continue;
            PSDEForm psDEForm = new PSDEForm();
            psDEForm.setPSDEFormId(KeyValueHelper.genUniqueId((String)psDataEntity.getPSDataEntityId(), (String)"MosQuickInfo"));
            if (psDEFormService.checkKey(psDEForm) != 1) continue;
            PSDEViewCtrl psDEViewCtrl = new PSDEViewCtrl();
            psDEViewCtrl.setPSDEViewCtrlId(KeyValueHelper.genUniqueId((String)psDEViewBase.getPSDEViewBaseId(), (String)"FORM"));
            psDEViewCtrl.setPSDEViewCtrlName("FORM");
            psDEViewCtrl.setPSDEViewCtrlType("FORM");
            psDEViewCtrl.setPSDEViewBaseId(psDEViewBase.getPSDEViewBaseId());
            psDEViewCtrl.setPSDEId(psDataEntity.getPSDataEntityId());
            psDEViewCtrl.setPSDEName(psDataEntity.getPSDataEntityName());
            psDEViewCtrl.setValidFlag(Integer.valueOf(1));
            psDEViewCtrl.setPSDEFormId(psDEForm.getPSDEFormId());
            psDEViewCtrl.setPSDEFormName("mos-quick-info");
            psDEViewCtrl.setPSACHandlerId("aeb813ef39d45ec5fa5a55eb3ca4a21d");
            psDEViewCtrl.setPSACHandlerName("\u7f16\u8f91\u8868\u5355\u5904\u7406\u5668");
            psDEViewCtrlService.create(psDEViewCtrl, false);
        }
    }

    protected void onInitV6MosQuickInfoViewUIActions(PSSystem psSystem, Map<String, PSDataEntity> modelV2Map, SessionFactory sessionFactory) throws Exception {
        PSDEViewBaseService psDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)sessionFactory);
        ArrayList<PSDEViewBase> psDEViewList = psDEViewBaseService.select((ISelectCond)new SelectCond());
        HashMap<String, PSDEViewBase> psDEViewBaseMap = new HashMap<String, PSDEViewBase>();
        for (PSDEViewBase psDEViewBase : psDEViewList) {
            PSDataEntity psDataEntity = modelV2Map.get(psDEViewBase.getPSDEName());
            if (psDataEntity == null || DataObject.getIntegerValue((Object)psDEViewBase.getTempMode(), (Integer)0) != 0 || StringHelper.Compare((String)psDEViewBase.getOpenMode(), (String)"DRAWER_RIGHT", (boolean)true) != 0 || DataObject.getIntegerValue((Object)psDEViewBase.getWidth(), (Integer)750) < 750 || StringHelper.Compare((String)psDEViewBase.getCodeName(), (String)"EditView", (boolean)true) != 0 && StringHelper.Compare((String)psDEViewBase.getCodeName(), (String)"QuickCfgView", (boolean)true) != 0 && StringHelper.Compare((String)psDEViewBase.getCodeName(), (String)"MainEditView", (boolean)true) != 0) continue;
            psDEViewBaseMap.put(psDEViewBase.getPSDEViewBaseId(), psDEViewBase);
        }
        HashMap<String, PSDEViewBase> psDEViewBaseMap2 = new HashMap<String, PSDEViewBase>();
        PSDEUIActionService psDEUIActionService = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)sessionFactory);
        PSAppDEViewService psAppDEViewService = (PSAppDEViewService)ServiceGlobal.getService(PSAppDEViewService.class, (SessionFactory)sessionFactory);
        PSDEUAGroupService psDEUAGroupService = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)sessionFactory);
        PSDEUAGroupDetailService psDEUAGroupDetailService = (PSDEUAGroupDetailService)ServiceGlobal.getService(PSDEUAGroupDetailService.class, (SessionFactory)sessionFactory);
        SelectCond selectCond = new SelectCond();
        selectCond.set("PSSYSAPPID", (Object)"CBB07EF3-B451-42ED-B859-2A05224110AE");
        ArrayList<PSAppDEView> psAppDEViewList = psAppDEViewService.select((ISelectCond)selectCond);
        for (PSAppDEView psAppDEView : psAppDEViewList) {
            PSDEViewBase psDEViewBase = (PSDEViewBase)psDEViewBaseMap.get(psAppDEView.getPSDEViewBaseId());
            if (psDEViewBase == null) continue;
            PSDEViewBase lastPSDEViewBase = (PSDEViewBase)psDEViewBaseMap2.get(psDEViewBase.getPSDEName());
            if (lastPSDEViewBase == null) {
                psDEViewBaseMap2.put(psDEViewBase.getPSDEName(), psDEViewBase);
                continue;
            }
            if (StringHelper.Compare((String)psDEViewBase.getCodeName(), (String)"QuickCfgView", (boolean)true) != 0) continue;
            psDEViewBaseMap2.put(psDEViewBase.getPSDEName(), psDEViewBase);
        }
        int nSize = psDEViewBaseMap2.size();
        for (Map.Entry entry : psDEViewBaseMap2.entrySet()) {
            --nSize;
            PSDataEntity psDataEntity = modelV2Map.get(entry.getKey());
            if (psDataEntity == null) continue;
            PSDEUIAction psDEUIAction = new PSDEUIAction();
            psDEUIAction.setPSDEUIActionId(KeyValueHelper.genUniqueId((String)psDataEntity.getPSDataEntityId(), (String)"MsoOpenQuickCfgView"));
            if (psDEUIActionService.checkKey(psDEUIAction) == 1) continue;
            psDEUIAction.setPSDEUIActionName(StringHelper.Format((String)"\u6253\u5f00%1$sMSO\u914d\u7f6e\u89c6\u56fe", (Object)psDataEntity.getLogicName()));
            psDEUIAction.setCaption("\u5feb\u901f\u914d\u7f6e");
            psDEUIAction.setPSDEId(psDataEntity.getPSDataEntityId());
            psDEUIAction.setPSDEName(psDataEntity.getPSDataEntityName());
            psDEUIAction.setPSSystemId(psSystem.getPSSystemId());
            psDEUIAction.setPSSystemName(psSystem.getPSSystemName());
            psDEUIAction.setCodeName("MosOpenQuickCfgView");
            psDEUIAction.setUIActionType("FRONT");
            psDEUIAction.setActionTarget("SINGLEKEY");
            psDEUIAction.setFrontProType("WIZARD");
            psDEUIAction.setPSDEViewBaseId(((PSDEViewBase)entry.getValue()).getPSDEViewBaseId());
            psDEUIAction.setPSDEViewBaseName(((PSDEViewBase)entry.getValue()).getPSDEViewBaseName());
            psDEUIActionService.create(psDEUIAction, false);
            PSDEUAGroup psDEUAGroup = new PSDEUAGroup();
            psDEUAGroup.setPSDEUAGroupId(KeyValueHelper.genUniqueId((String)psDataEntity.getPSDataEntityId(), (String)"MosQuickInfo"));
            if (psDEUAGroupService.checkKey(psDEUAGroup) != 1) continue;
            PSDEUAGroupDetail psDEUAGroupDetail = new PSDEUAGroupDetail();
            psDEUAGroupDetail.setPSDEUAGRPDetailId(KeyValueHelper.genUniqueId((String)psDEUAGroup.getPSDEUAGroupId(), (String)"QuickCfg"));
            if (psDEUAGroupDetailService.checkKey(psDEUAGroupDetail) == 1) continue;
            psDEUAGroupDetail.setPSDEUAGRPDetailName("QuickCfg");
            psDEUAGroupDetail.setPSDEUAGroupId(psDEUAGroup.getPSDEUAGroupId());
            psDEUAGroupDetail.setPSDEUIActionId(psDEUIAction.getPSDEUIActionId());
            psDEUAGroupDetail.setOrderValue(Integer.valueOf(100));
            psDEUAGroupDetail.setCodeName("QuickCfg");
            psDEUAGroupDetailService.create(psDEUAGroupDetail, false);
            log.debug((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u5b9e\u4f53\u754c\u9762\u884c\u4e3a[%1$s]\uff0c\u5269\u4f59[%2$s]", (Object)psDEUIAction.getPSDEUIActionName(), (Object)nSize));
        }
    }

    protected void onGenV6MosQuickInfoViewForms(PSSystem psSystem, Map<String, PSDataEntity> modelV2Map, SessionFactory sessionFactory) throws Exception {
        PSDEUIActionService psDEUIActionService = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)sessionFactory);
        PSDEFormService psDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)sessionFactory);
        PSDEViewCtrlService psDEViewCtrlService = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)sessionFactory);
        for (PSDataEntity psDataEntity : modelV2Map.values()) {
            if (psDataEntity == null) continue;
            PSDEForm psDEForm = new PSDEForm();
            psDEForm.setPSDEFormId(KeyValueHelper.genUniqueId((String)psDataEntity.getPSDataEntityId(), (String)"MosQuickInfo"));
            if (!psDEFormService.get(psDEForm, true) || StringHelper.Compare((String)psDEForm.getUserTag(), (String)"MOSINIT", (boolean)true) == 0) continue;
            PSDEUIAction psDEUIAction = new PSDEUIAction();
            psDEUIAction.setPSDEUIActionId(KeyValueHelper.genUniqueId((String)psDataEntity.getPSDataEntityId(), (String)"MsoOpenQuickCfgView"));
            if (!psDEUIActionService.get(psDEUIAction, true)) continue;
            PSDEViewCtrl psDEViewCtrl = new PSDEViewCtrl();
            psDEViewCtrl.setPSDEViewBaseId(psDEUIAction.getPSDEViewBaseId());
            psDEViewCtrl.setPSDEViewCtrlName("FORM");
            if (!psDEViewCtrlService.select(psDEViewCtrl, true) || StringHelper.IsNullOrEmpty((String)psDEViewCtrl.getPSDEFormId())) continue;
            PSDEForm srcPSDEForm = new PSDEForm();
            srcPSDEForm.setPSDEFormId(psDEViewCtrl.getPSDEFormId());
            psDEFormService.initMOSForm(psDEForm, srcPSDEForm);
            psDEForm.reset();
            psDEForm.setPSDEFormId(KeyValueHelper.genUniqueId((String)psDataEntity.getPSDataEntityId(), (String)"MosQuickInfo"));
            psDEForm.setUserTag("MOSINIT");
            psDEFormService.sysUpdate(psDEForm, false);
        }
    }

    protected void onFixV6MosQuickInfoViewForms(PSSystem psSystem, Map<String, PSDataEntity> modelV2Map, SessionFactory sessionFactory) throws Exception {
        PSDEUIActionService psDEUIActionService = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)sessionFactory);
        PSDEFormService psDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)sessionFactory);
        PSDEViewCtrlService psDEViewCtrlService = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)sessionFactory);
        for (PSDataEntity psDataEntity : modelV2Map.values()) {
            if (psDataEntity == null) continue;
            PSDEForm psDEForm = new PSDEForm();
            psDEForm.setPSDEFormId(KeyValueHelper.genUniqueId((String)psDataEntity.getPSDataEntityId(), (String)"MosQuickInfo"));
            if (!psDEFormService.get(psDEForm, true)) continue;
            PSDEUIAction psDEUIAction = new PSDEUIAction();
            psDEUIAction.setPSDEUIActionId(KeyValueHelper.genUniqueId((String)psDataEntity.getPSDataEntityId(), (String)"MsoOpenQuickCfgView"));
            if (!psDEUIActionService.get(psDEUIAction, true)) continue;
            PSDEViewCtrl psDEViewCtrl = new PSDEViewCtrl();
            psDEViewCtrl.setPSDEViewBaseId(psDEUIAction.getPSDEViewBaseId());
            psDEViewCtrl.setPSDEViewCtrlName("FORM");
            if (!psDEViewCtrlService.select(psDEViewCtrl, true) || StringHelper.IsNullOrEmpty((String)psDEViewCtrl.getPSDEFormId())) continue;
            PSDEForm srcPSDEForm = new PSDEForm();
            srcPSDEForm.setPSDEFormId(psDEViewCtrl.getPSDEFormId());
            psDEFormService.fixMOSForm(psDEForm, srcPSDEForm);
        }
    }

    protected void onAddV6MosQuickInfoViews(PSSystem psSystem, Map<String, PSDataEntity> modelV2Map, SessionFactory sessionFactory) throws Exception {
        PSAppModuleService psAppModuleService = (PSAppModuleService)ServiceGlobal.getService(PSAppModuleService.class, (SessionFactory)sessionFactory);
        SelectCond selectCond = new SelectCond();
        selectCond.set("PSSYSAPPID", (Object)"CBB07EF3-B451-42ED-B859-2A05224110AE");
        ArrayList<PSAppModule> psAppModuleList = psAppModuleService.select((ISelectCond)selectCond);
        HashMap<String, PSAppModule> psAppModuleMap = new HashMap<String, PSAppModule>();
        for (PSAppModule psAppModule : psAppModuleList) {
            psAppModuleMap.put(psAppModule.getCodeName().toUpperCase(), psAppModule);
        }
        selectCond.reset();
        HashMap<String, PSAppModule> psModuleMap = new HashMap<String, PSAppModule>();
        PSModuleService psModuleService = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)sessionFactory);
        ArrayList<PSModule> psModuleList = psModuleService.select((ISelectCond)selectCond);
        for (PSModule psModule : psModuleList) {
            PSAppModule psAppModule = (PSAppModule)psAppModuleMap.get(psModule.getCodeName().toUpperCase());
            if (psAppModule == null) continue;
            psModuleMap.put(psModule.getPSModuleId(), psAppModule);
        }
        PSAppDEViewService psAppDEViewService = (PSAppDEViewService)ServiceGlobal.getService(PSAppDEViewService.class, (SessionFactory)sessionFactory);
        PSDEUIActionService psDEUIActionService = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)sessionFactory);
        PSDEViewBaseService psDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)sessionFactory);
        for (PSDataEntity psDataEntity : modelV2Map.values()) {
            PSAppModule psAppModule;
            if (psDataEntity == null) continue;
            PSDEUIAction psDEUIAction = new PSDEUIAction();
            psDEUIAction.setPSDEUIActionId(KeyValueHelper.genUniqueId((String)psDataEntity.getPSDataEntityId(), (String)"MsoOpenQuickCfgView"));
            if (psDEUIActionService.checkKey(psDEUIAction) != 1) continue;
            PSDEViewBase psDEViewBase = new PSDEViewBase();
            psDEViewBase.setPSDEViewBaseId(KeyValueHelper.genUniqueId((String)psDataEntity.getPSDataEntityId(), (String)"MosQuickInfoView"));
            if (!psDEViewBaseService.get(psDEViewBase, true)) continue;
            PSAppDEView psAppDEView = new PSAppDEView();
            psAppDEView.setPSAppDEViewId(KeyValueHelper.genUniqueId((String)"CBB07EF3-B451-42ED-B859-2A05224110AE", (String)psDEViewBase.getPSDEViewBaseId()));
            if (psAppDEViewService.checkKey(psAppDEView) == 1 || (psAppModule = (PSAppModule)psModuleMap.get(psDataEntity.getPSModuleId())) == null) continue;
            psAppDEView.setPSSysAppId("CBB07EF3-B451-42ED-B859-2A05224110AE");
            psAppDEView.setPSDEViewBaseId(psDEViewBase.getPSDEViewBaseId());
            psAppDEView.setPSDEViewBaseName(psDEViewBase.getPSDEViewBaseName());
            psAppDEView.setPSAppModuleId(psAppModule.getPSAppModuleId());
            psAppDEView.setPSAppModuleName(psAppModule.getPSAppModuleName());
            psAppDEView.setUserRefFlag(Integer.valueOf(1));
            psAppDEViewService.create(psAppDEView, false);
        }
    }

    protected void onInitV6MosQuickInfoViewUIActions_OpenMainView(PSSystem psSystem, Map<String, PSDataEntity> modelV2Map, SessionFactory sessionFactory) throws Exception {
        PSDEUIActionService psDEUIActionService = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)sessionFactory);
        SelectCond selectCond = new SelectCond();
        selectCond.set("CODENAME", (Object)"OpenMainView");
        ArrayList<PSDEUIAction> psDEUIActionList = psDEUIActionService.select((ISelectCond)selectCond);
        HashMap<String, PSDEUIAction> psDEUIActionMap = new HashMap<String, PSDEUIAction>();
        for (PSDEUIAction psDEUIAction : psDEUIActionList) {
            PSDataEntity psDataEntity = modelV2Map.get(psDEUIAction.getPSDEName());
            if (psDataEntity == null) continue;
            psDEUIActionMap.put(psDataEntity.getPSDataEntityName(), psDEUIAction);
        }
        PSDEUAGroupService psDEUAGroupService = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)sessionFactory);
        PSDEUAGroupDetailService psDEUAGroupDetailService = (PSDEUAGroupDetailService)ServiceGlobal.getService(PSDEUAGroupDetailService.class, (SessionFactory)sessionFactory);
        int nSize = psDEUIActionMap.size();
        for (Map.Entry entry : psDEUIActionMap.entrySet()) {
            PSDEUAGroupDetail psDEUAGroupDetail;
            --nSize;
            PSDataEntity psDataEntity = modelV2Map.get(entry.getKey());
            if (psDataEntity == null) continue;
            PSDEUIAction psDEUIAction = (PSDEUIAction)entry.getValue();
            PSDEUAGroup psDEUAGroup = new PSDEUAGroup();
            psDEUAGroup.setPSDEUAGroupId(KeyValueHelper.genUniqueId((String)psDataEntity.getPSDataEntityId(), (String)"MosQuickInfo"));
            if (psDEUAGroupService.checkKey(psDEUAGroup) == 1) {
                psDEUAGroupDetail = new PSDEUAGroupDetail();
                psDEUAGroupDetail.setPSDEUAGRPDetailId(KeyValueHelper.genUniqueId((String)psDEUAGroup.getPSDEUAGroupId(), (String)"OpenMainView"));
                if (psDEUAGroupDetailService.checkKey(psDEUAGroupDetail) != 1) {
                    psDEUAGroupDetail.setPSDEUAGRPDetailName("OpenMainView");
                    psDEUAGroupDetail.setPSDEUAGroupId(psDEUAGroup.getPSDEUAGroupId());
                    psDEUAGroupDetail.setPSDEUIActionId(psDEUIAction.getPSDEUIActionId());
                    psDEUAGroupDetail.setOrderValue(Integer.valueOf(50));
                    psDEUAGroupDetail.setCodeName("OpenMainView");
                    psDEUAGroupDetailService.create(psDEUAGroupDetail, false);
                }
            }
            psDEUAGroup.reset();
            psDEUAGroup.setPSDEUAGroupId(KeyValueHelper.genUniqueId((String)psDataEntity.getPSDataEntityId(), (String)"MosExplorerQuick"));
            if (psDEUAGroupService.checkKey(psDEUAGroup) == 1) {
                psDEUAGroupDetail = new PSDEUAGroupDetail();
                psDEUAGroupDetail.setPSDEUAGRPDetailId(KeyValueHelper.genUniqueId((String)psDEUAGroup.getPSDEUAGroupId(), (String)"OpenMainView"));
                if (psDEUAGroupDetailService.checkKey(psDEUAGroupDetail) != 1) {
                    psDEUAGroupDetail.setPSDEUAGRPDetailName("OpenMainView");
                    psDEUAGroupDetail.setPSDEUAGroupId(psDEUAGroup.getPSDEUAGroupId());
                    psDEUAGroupDetail.setPSDEUIActionId(psDEUIAction.getPSDEUIActionId());
                    psDEUAGroupDetail.setOrderValue(Integer.valueOf(50));
                    psDEUAGroupDetail.setCodeName("OpenMainView");
                    psDEUAGroupDetailService.create(psDEUAGroupDetail, false);
                }
            }
            log.debug((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u5b9e\u4f53\u754c\u9762\u884c\u4e3a[%1$s]\uff0c\u5269\u4f59[%2$s]", (Object)psDEUIAction.getPSDEUIActionName(), (Object)nSize));
        }
    }

    protected void onInitV6MosQuickInfoViewUIActions_OpenDesignTool(PSSystem psSystem, Map<String, PSDataEntity> modelV2Map, SessionFactory sessionFactory) throws Exception {
        PSDataEntity psDataEntity;
        PSDEUIActionService psDEUIActionService = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)sessionFactory);
        SelectCond selectCond = new SelectCond();
        selectCond.set("CODENAME", (Object)"OpenDesignTool");
        ArrayList<PSDEUIAction> psDEUIActionList = psDEUIActionService.select((ISelectCond)selectCond);
        HashMap<String, PSDEUIAction> psDEUIActionMap = new HashMap<String, PSDEUIAction>();
        for (PSDEUIAction psDEUIAction : psDEUIActionList) {
            psDataEntity = modelV2Map.get(psDEUIAction.getPSDEName());
            if (psDataEntity == null) continue;
            psDEUIActionMap.put(psDataEntity.getPSDataEntityName(), psDEUIAction);
        }
        selectCond.reset();
        selectCond.set("CODENAME", (Object)"OpenDesignView");
        psDEUIActionList = psDEUIActionService.select((ISelectCond)selectCond);
        for (PSDEUIAction psDEUIAction : psDEUIActionList) {
            psDataEntity = modelV2Map.get(psDEUIAction.getPSDEName());
            if (psDataEntity == null || psDEUIActionMap.containsKey(psDataEntity.getPSDataEntityName())) continue;
            psDEUIActionMap.put(psDataEntity.getPSDataEntityName(), psDEUIAction);
        }
        selectCond.reset();
        selectCond.set("CODENAME", (Object)"OpenDQDesignTool");
        psDEUIActionList = psDEUIActionService.select((ISelectCond)selectCond);
        for (PSDEUIAction psDEUIAction : psDEUIActionList) {
            psDataEntity = modelV2Map.get(psDEUIAction.getPSDEName());
            if (psDataEntity == null || psDEUIActionMap.containsKey(psDataEntity.getPSDataEntityName())) continue;
            psDEUIActionMap.put(psDataEntity.getPSDataEntityName(), psDEUIAction);
        }
        PSDEUAGroupService psDEUAGroupService = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)sessionFactory);
        PSDEUAGroupDetailService psDEUAGroupDetailService = (PSDEUAGroupDetailService)ServiceGlobal.getService(PSDEUAGroupDetailService.class, (SessionFactory)sessionFactory);
        int nSize = psDEUIActionMap.size();
        for (Map.Entry entry : psDEUIActionMap.entrySet()) {
            --nSize;
            PSDataEntity psDataEntity2 = modelV2Map.get(entry.getKey());
            if (psDataEntity2 == null) continue;
            PSDEUIAction psDEUIAction = (PSDEUIAction)entry.getValue();
            PSDEUAGroup psDEUAGroup = new PSDEUAGroup();
            psDEUAGroup.reset();
            psDEUAGroup.setPSDEUAGroupId(KeyValueHelper.genUniqueId((String)psDataEntity2.getPSDataEntityId(), (String)"MosExplorerQuick"));
            if (psDEUAGroupService.checkKey(psDEUAGroup) == 1) {
                PSDEUAGroupDetail psDEUAGroupDetail = new PSDEUAGroupDetail();
                psDEUAGroupDetail.setPSDEUAGRPDetailId(KeyValueHelper.genUniqueId((String)psDEUAGroup.getPSDEUAGroupId(), (String)"OpenDesignTool"));
                if (psDEUAGroupDetailService.checkKey(psDEUAGroupDetail) != 1) {
                    psDEUAGroupDetail.setPSDEUAGRPDetailName("OpenDesignTool");
                    psDEUAGroupDetail.setPSDEUAGroupId(psDEUAGroup.getPSDEUAGroupId());
                    psDEUAGroupDetail.setPSDEUIActionId(psDEUIAction.getPSDEUIActionId());
                    psDEUAGroupDetail.setOrderValue(Integer.valueOf(70));
                    psDEUAGroupDetail.setCodeName("OpenDesignTool");
                    psDEUAGroupDetailService.create(psDEUAGroupDetail, false);
                }
            }
            log.debug((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u5b9e\u4f53\u754c\u9762\u884c\u4e3a[%1$s]\uff0c\u5269\u4f59[%2$s]", (Object)psDEUIAction.getPSDEUIActionName(), (Object)nSize));
        }
    }

    protected void onInitV6MosExplorerQuick_QuickCreate(PSSystem psSystem, Map<String, PSDataEntity> modelV2Map, SessionFactory sessionFactory) throws Exception {
        PSDataEntity psDataEntity;
        PSDEUIActionService psDEUIActionService = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)sessionFactory);
        SelectCond selectCond = new SelectCond();
        selectCond.set("CODENAME", (Object)"OpenQuickCreateView");
        ArrayList<PSDEUIAction> psDEUIActionList = psDEUIActionService.select((ISelectCond)selectCond);
        HashMap<String, PSDEUIAction> psDEUIActionMap = new HashMap<String, PSDEUIAction>();
        for (PSDEUIAction psDEUIAction : psDEUIActionList) {
            psDataEntity = modelV2Map.get(psDEUIAction.getPSDEName());
            if (psDataEntity == null) continue;
            psDEUIActionMap.put(psDataEntity.getPSDataEntityName(), psDEUIAction);
        }
        selectCond.reset();
        selectCond.set("CODENAME", (Object)"OpenCreateView");
        psDEUIActionList = psDEUIActionService.select((ISelectCond)selectCond);
        for (PSDEUIAction psDEUIAction : psDEUIActionList) {
            psDataEntity = modelV2Map.get(psDEUIAction.getPSDEName());
            if (psDataEntity == null || psDEUIActionMap.containsKey(psDataEntity.getPSDataEntityName())) continue;
            psDEUIActionMap.put(psDataEntity.getPSDataEntityName(), psDEUIAction);
        }
        selectCond.reset();
        selectCond.set("CODENAME", (Object)"OpenCreateWizardView");
        psDEUIActionList = psDEUIActionService.select((ISelectCond)selectCond);
        for (PSDEUIAction psDEUIAction : psDEUIActionList) {
            psDataEntity = modelV2Map.get(psDEUIAction.getPSDEName());
            if (psDataEntity == null || psDEUIActionMap.containsKey(psDataEntity.getPSDataEntityName())) continue;
            psDEUIActionMap.put(psDataEntity.getPSDataEntityName(), psDEUIAction);
        }
        PSDEUAGroupService psDEUAGroupService = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)sessionFactory);
        PSDEUAGroupDetailService psDEUAGroupDetailService = (PSDEUAGroupDetailService)ServiceGlobal.getService(PSDEUAGroupDetailService.class, (SessionFactory)sessionFactory);
        int nSize = psDEUIActionMap.size();
        for (Map.Entry entry : psDEUIActionMap.entrySet()) {
            --nSize;
            PSDataEntity psDataEntity2 = modelV2Map.get(entry.getKey());
            if (psDataEntity2 == null) continue;
            PSDEUIAction psDEUIAction = (PSDEUIAction)entry.getValue();
            PSDEUAGroup psDEUAGroup = new PSDEUAGroup();
            psDEUAGroup.setPSDEUAGroupId(KeyValueHelper.genUniqueId((String)psDataEntity2.getPSDataEntityId(), (String)"MosExplorerQuick"));
            if (psDEUAGroupService.checkKey(psDEUAGroup) == 1) {
                PSDEUAGroupDetail psDEUAGroupDetail = new PSDEUAGroupDetail();
                psDEUAGroupDetail.setPSDEUAGRPDetailId(KeyValueHelper.genUniqueId((String)psDEUAGroup.getPSDEUAGroupId(), (String)"OpenQuickCreateView"));
                if (psDEUAGroupDetailService.checkKey(psDEUAGroupDetail) == 1) continue;
                psDEUAGroupDetail.setAddSeparator(Integer.valueOf(1));
                psDEUAGroupDetail.setPSDEUAGRPDetailName("OpenQuickCreateView");
                psDEUAGroupDetail.setPSDEUAGroupId(psDEUAGroup.getPSDEUAGroupId());
                psDEUAGroupDetail.setPSDEUIActionId(psDEUIAction.getPSDEUIActionId());
                psDEUAGroupDetail.setOrderValue(Integer.valueOf(100));
                psDEUAGroupDetail.setCodeName("OpenQuickCreateView");
                psDEUAGroupDetailService.create(psDEUAGroupDetail, false);
            }
            log.debug((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u5b9e\u4f53\u754c\u9762\u884c\u4e3a[%1$s]\uff0c\u5269\u4f59[%2$s]", (Object)psDEUIAction.getPSDEUIActionName(), (Object)nSize));
        }
    }

    protected void onListV6MosExplorerQuick_QuickCreate(PSSystem psSystem, Map<String, PSDataEntity> modelV2Map, SessionFactory sessionFactory) throws Exception {
        PSDEUIActionService psDEUIActionService = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)sessionFactory);
        SelectCond selectCond = new SelectCond();
        selectCond.set("CODENAME", (Object)"OpenQuickCreateView");
        ArrayList<PSDEUIAction> psDEUIActionList = psDEUIActionService.select((ISelectCond)selectCond);
        HashMap<String, PSDataEntity> modelV2Map2 = new HashMap<String, PSDataEntity>();
        modelV2Map2.putAll(modelV2Map);
        HashMap psDEUIActionMap = new HashMap();
        for (PSDEUIAction psDEUIAction : psDEUIActionList) {
            PSDataEntity pSDataEntity = (PSDataEntity)modelV2Map2.remove(psDEUIAction.getPSDEName());
        }
        selectCond.reset();
        selectCond.set("CODENAME", (Object)"OpenMainView");
        psDEUIActionList = psDEUIActionService.select((ISelectCond)selectCond);
        HashMap<String, PSDEUIAction> psDEUIActionMap2 = new HashMap<String, PSDEUIAction>();
        for (PSDEUIAction psDEUIAction : psDEUIActionList) {
            PSDataEntity psDataEntity = (PSDataEntity)modelV2Map2.get(psDEUIAction.getPSDEName());
            if (psDataEntity == null) continue;
            psDEUIActionMap2.put(psDataEntity.getPSDataEntityName(), psDEUIAction);
        }
        PSDEViewBaseService psDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)sessionFactory);
        selectCond.reset();
        selectCond.set("CODENAME", (Object)"QuickCreateView");
        ArrayList<PSDEViewBase> psDEViewList = psDEViewBaseService.select((ISelectCond)selectCond);
        selectCond.reset();
        selectCond.set("CODENAME", (Object)"QuickCreateOptionView");
        ArrayList<PSDEViewBase> psDEViewList2 = psDEViewBaseService.select((ISelectCond)selectCond);
        psDEViewList.addAll(psDEViewList2);
        HashMap<String, PSDEViewBase> psDEViewBaseMap = new HashMap<String, PSDEViewBase>();
        for (PSDEViewBase psDEViewBase : psDEViewList) {
            PSDataEntity psDataEntity = (PSDataEntity)modelV2Map2.get(psDEViewBase.getPSDEName());
            if (psDataEntity == null || DataObject.getIntegerValue((Object)psDEViewBase.getTempMode(), (Integer)0) != 0 || StringHelper.Compare((String)psDEViewBase.getOpenMode(), (String)"POPUPMODAL", (boolean)true) != 0) continue;
            psDEViewBaseMap.put(psDEViewBase.getPSDEViewBaseId(), psDEViewBase);
        }
        HashMap<String, PSDEViewBase> psDEViewBaseMap2 = new HashMap<String, PSDEViewBase>();
        PSAppDEViewService psAppDEViewService = (PSAppDEViewService)ServiceGlobal.getService(PSAppDEViewService.class, (SessionFactory)sessionFactory);
        PSDEUAGroupService psDEUAGroupService = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)sessionFactory);
        PSDEUAGroupDetailService psDEUAGroupDetailService = (PSDEUAGroupDetailService)ServiceGlobal.getService(PSDEUAGroupDetailService.class, (SessionFactory)sessionFactory);
        selectCond.reset();
        selectCond.set("PSSYSAPPID", (Object)"CBB07EF3-B451-42ED-B859-2A05224110AE");
        ArrayList<PSAppDEView> psAppDEViewList = psAppDEViewService.select((ISelectCond)selectCond);
        for (PSAppDEView psAppDEView : psAppDEViewList) {
            PSDEViewBase lastPSDEViewBase;
            PSDEViewBase psDEViewBase = (PSDEViewBase)psDEViewBaseMap.get(psAppDEView.getPSDEViewBaseId());
            if (psDEViewBase == null || (lastPSDEViewBase = (PSDEViewBase)psDEViewBaseMap2.get(psDEViewBase.getPSDEName())) != null) continue;
            psDEViewBaseMap2.put(psDEViewBase.getPSDEName(), psDEViewBase);
        }
        int nSize = psDEViewBaseMap2.size();
        for (Map.Entry entry : psDEViewBaseMap2.entrySet()) {
            --nSize;
            PSDataEntity psDataEntity = modelV2Map.get(entry.getKey());
            if (psDataEntity == null) continue;
            PSDEUIAction psDEUIAction = new PSDEUIAction();
            psDEUIAction.setPSDEUIActionId(KeyValueHelper.genUniqueId((String)psDataEntity.getPSDataEntityId(), (String)"OpenQuickCreateView"));
            if (psDEUIActionService.checkKey(psDEUIAction) == 1) continue;
            psDEUIAction.setPSDEUIActionName(StringHelper.Format((String)"\u6253\u5f00%1$s\u5feb\u901f\u65b0\u5efa\u89c6\u56fe", (Object)psDataEntity.getLogicName()));
            psDEUIAction.setCaption("\u65b0\u5efa");
            psDEUIAction.setPSDEId(psDataEntity.getPSDataEntityId());
            psDEUIAction.setPSDEName(psDataEntity.getPSDataEntityName());
            psDEUIAction.setPSSystemId(psSystem.getPSSystemId());
            psDEUIAction.setPSSystemName(psSystem.getPSSystemName());
            psDEUIAction.setCodeName("OpenQuickCreateView");
            psDEUIAction.setUIActionType("FRONT");
            psDEUIAction.setActionTarget("NONE");
            psDEUIAction.setFrontProType("WIZARD");
            psDEUIAction.setPSDEViewBaseId(((PSDEViewBase)entry.getValue()).getPSDEViewBaseId());
            psDEUIAction.setPSDEViewBaseName(((PSDEViewBase)entry.getValue()).getPSDEViewBaseName());
            psDEUIAction.setPSSysImageId("71f8a9fde6993a9e35257c17c3dd6ea7");
            psDEUIAction.setPSSysImageName("file-text-o");
            psDEUIAction.setReloadData(Integer.valueOf(1));
            psDEUIAction.setUserTag("MOS");
            PSDEUIAction nextPSDEUIAction = (PSDEUIAction)psDEUIActionMap2.get(psDataEntity.getPSDataEntityName());
            if (nextPSDEUIAction != null) {
                psDEUIAction.setNextPSDEUIActionId(nextPSDEUIAction.getPSDEUIActionId());
                psDEUIAction.setNextPSDEUIActionName(nextPSDEUIAction.getPSDEUIActionName());
            }
            psDEUIActionService.create(psDEUIAction, false);
            PSDEUAGroup psDEUAGroup = new PSDEUAGroup();
            psDEUAGroup.setPSDEUAGroupId(KeyValueHelper.genUniqueId((String)psDataEntity.getPSDataEntityId(), (String)"MosExplorerQuick"));
                if (psDEUAGroupService.checkKey(psDEUAGroup) == 1) {
                PSDEUAGroupDetail psDEUAGroupDetail = new PSDEUAGroupDetail();
                psDEUAGroupDetail.setPSDEUAGRPDetailId(KeyValueHelper.genUniqueId((String)psDEUAGroup.getPSDEUAGroupId(), (String)"OpenQuickCreateView"));
                if (psDEUAGroupDetailService.checkKey(psDEUAGroupDetail) == 1) continue;
                psDEUAGroupDetail.setAddSeparator(Integer.valueOf(1));
                psDEUAGroupDetail.setPSDEUAGRPDetailName("OpenQuickCreateView");
                psDEUAGroupDetail.setPSDEUAGroupId(psDEUAGroup.getPSDEUAGroupId());
                psDEUAGroupDetail.setPSDEUIActionId(psDEUIAction.getPSDEUIActionId());
                psDEUAGroupDetail.setOrderValue(Integer.valueOf(100));
                psDEUAGroupDetail.setCodeName("OpenQuickCreateView");
                psDEUAGroupDetailService.create(psDEUAGroupDetail, false);
            }
            modelV2Map2.remove(psDataEntity.getPSDataEntityName());
            log.debug((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u5b9e\u4f53\u754c\u9762\u884c\u4e3a[%1$s]\uff0c\u5269\u4f59[%2$s]", (Object)psDEUIAction.getPSDEUIActionName(), (Object)nSize));
        }
        for (Map.Entry entry : modelV2Map2.entrySet()) {
            log.warn((Object)StringHelper.Format((String)"[%1$s]\u6ca1\u6709\u5b9a\u4e49\u5feb\u901f\u65b0\u5efa", entry.getKey()));
        }
    }

    protected void onInitV6MosExplorerQuick_Remove(PSSystem psSystem, Map<String, PSDataEntity> modelV2Map, SessionFactory sessionFactory) throws Exception {
        PSDEActionService psDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)sessionFactory);
        SelectCond selectCond = new SelectCond();
        selectCond.set("CODENAME", (Object)"Remove");
        ArrayList<PSDEAction> psDEActionList = psDEActionService.select((ISelectCond)selectCond);
        HashMap<String, PSDEAction> psDEActionMap = new HashMap<String, PSDEAction>();
        for (PSDEAction psDEAction : psDEActionList) {
            PSDataEntity psDataEntity = modelV2Map.get(psDEAction.getPSDEName());
            if (psDataEntity == null) continue;
            psDEActionMap.put(psDataEntity.getPSDataEntityName(), psDEAction);
        }
        PSDEUIActionService psDEUIActionService = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)sessionFactory);
        PSDEUAGroupService psDEUAGroupService = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)sessionFactory);
        PSDEUAGroupDetailService psDEUAGroupDetailService = (PSDEUAGroupDetailService)ServiceGlobal.getService(PSDEUAGroupDetailService.class, (SessionFactory)sessionFactory);
        int nSize = psDEActionMap.size();
        for (Map.Entry entry : psDEActionMap.entrySet()) {
            --nSize;
            PSDataEntity psDataEntity = modelV2Map.get(entry.getKey());
            if (psDataEntity == null) continue;
            PSDEUIAction psDEUIAction = new PSDEUIAction();
            psDEUIAction.setPSDEUIActionId(KeyValueHelper.genUniqueId((String)psDataEntity.getPSDataEntityId(), (String)"MosRemove"));
            if (psDEUIActionService.checkKey(psDEUIAction) == 1) continue;
            psDEUIAction.setPSDEUIActionName(StringHelper.Format((String)"%1$sMSO\u5220\u9664\u6570\u636e", (Object)psDataEntity.getLogicName()));
            psDEUIAction.setCaption("\u5220\u9664");
            psDEUIAction.setPSDEId(psDataEntity.getPSDataEntityId());
            psDEUIAction.setPSDEName(psDataEntity.getPSDataEntityName());
            psDEUIAction.setPSSystemId(psSystem.getPSSystemId());
            psDEUIAction.setPSSystemName(psSystem.getPSSystemName());
            psDEUIAction.setCodeName("MosRemove");
            psDEUIAction.setUIActionType("BACKEND");
            psDEUIAction.setActionTarget("MULTIKEY");
            psDEUIAction.setPSDEOPPrivId("88b85d6e527457723df3f873aa09e84a");
            psDEUIAction.setPSDEOPPrivName("DELETE");
            psDEUIAction.setPSDEActionId(((PSDEAction)entry.getValue()).getPSDEActionId());
            psDEUIAction.setPSDEActionName(((PSDEAction)entry.getValue()).getPSDEActionName());
            psDEUIAction.setUserConfirm(Integer.valueOf(1));
            psDEUIAction.setPSSysImageId("f60c95b158d706b1a74242df94aad527");
            psDEUIAction.setPSSysImageName("remove (alias)");
            psDEUIAction.setConfirmInfo(StringHelper.Format((String)"\u786e\u5b9a\u8981\u5220\u9664\u9009\u4e2d\u6570\u636e\uff0c\u6570\u636e\u4e00\u65e6\u5220\u9664\u5c06\u65e0\u6cd5\u6062\u590d"));
            psDEUIActionService.create(psDEUIAction, false);
            PSDEUAGroup psDEUAGroup = new PSDEUAGroup();
            psDEUAGroup.setPSDEUAGroupId(KeyValueHelper.genUniqueId((String)psDataEntity.getPSDataEntityId(), (String)"MosExplorerQuick"));
                if (psDEUAGroupService.checkKey(psDEUAGroup) == 1) {
                PSDEUAGroupDetail psDEUAGroupDetail = new PSDEUAGroupDetail();
                psDEUAGroupDetail.setPSDEUAGRPDetailId(KeyValueHelper.genUniqueId((String)psDEUAGroup.getPSDEUAGroupId(), (String)"MosRemove"));
                if (psDEUAGroupDetailService.checkKey(psDEUAGroupDetail) == 1) continue;
                psDEUAGroupDetail.setAddSeparator(Integer.valueOf(1));
                psDEUAGroupDetail.setPSDEUAGRPDetailName("MosRemove");
                psDEUAGroupDetail.setPSDEUAGroupId(psDEUAGroup.getPSDEUAGroupId());
                psDEUAGroupDetail.setPSDEUIActionId(psDEUIAction.getPSDEUIActionId());
                psDEUAGroupDetail.setOrderValue(Integer.valueOf(300));
                psDEUAGroupDetail.setCodeName("MosRemove");
                psDEUAGroupDetailService.create(psDEUAGroupDetail, false);
            }
            log.debug((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u5b9e\u4f53\u754c\u9762\u884c\u4e3a[%1$s]\uff0c\u5269\u4f59[%2$s]", (Object)psDEUIAction.getPSDEUIActionName(), (Object)nSize));
        }
    }

    protected void onInitV6MosQuickInfoViewUAGroup_Major(PSSystem psSystem, Map<String, PSDataEntity> modelV2Map, SessionFactory sessionFactory) throws Exception {
        PSDEViewBaseService psDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)sessionFactory);
        ArrayList<PSDEViewBase> psDEViewList = psDEViewBaseService.select((ISelectCond)new SelectCond());
        HashMap<String, PSDEViewBase> psDEViewBaseMap = new HashMap<String, PSDEViewBase>();
        for (PSDEViewBase psDEViewBase : psDEViewList) {
            PSDataEntity psDataEntity = modelV2Map.get(psDEViewBase.getPSDEName());
            if (psDataEntity == null || StringHelper.Compare((String)psDEViewBase.getCodeName(), (String)"GridView", (boolean)true) != 0 && StringHelper.Compare((String)psDEViewBase.getCodeName(), (String)"CurSysGridView", (boolean)true) != 0 && StringHelper.Compare((String)psDEViewBase.getCodeName(), (String)"CurDEGridView", (boolean)true) != 0 && StringHelper.Compare((String)psDEViewBase.getCodeName(), (String)"CurAppGridView", (boolean)true) != 0 && StringHelper.Compare((String)psDEViewBase.getCodeName(), (String)"CurSysMainGridView", (boolean)true) != 0) continue;
            psDEViewBaseMap.put(psDEViewBase.getPSDEViewBaseId(), psDEViewBase);
        }
        PSDEViewCtrlService psDEViewCtrlService = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)sessionFactory);
        SelectCond selectCond = new SelectCond();
        selectCond.set("PSDEVIEWCTRLTYPE", (Object)"TOOLBAR");
        ArrayList<PSDEViewCtrl> psDEViewCtrlList = psDEViewCtrlService.select((ISelectCond)selectCond);
        HashMap<String, String> psDEUAGroupMap = new HashMap<String, String>();
        for (PSDEViewCtrl psDEViewCtrl : psDEViewCtrlList) {
            if (!psDEViewBaseMap.containsKey(psDEViewCtrl.getPSDEViewBaseId())) continue;
            if (!StringHelper.IsNullOrEmpty((String)psDEViewCtrl.getNO2PSDEUAGroupId())) {
                psDEUAGroupMap.put(psDEViewCtrl.getNO2PSDEUAGroupId(), "");
            }
            if (!StringHelper.IsNullOrEmpty((String)psDEViewCtrl.getNO3PSDEUAGroupId())) {
                psDEUAGroupMap.put(psDEViewCtrl.getNO3PSDEUAGroupId(), "");
            }
            if (!StringHelper.IsNullOrEmpty((String)psDEViewCtrl.getNO4PSDEUAGroupId())) {
                psDEUAGroupMap.put(psDEViewCtrl.getNO4PSDEUAGroupId(), "");
            }
            if (!StringHelper.IsNullOrEmpty((String)psDEViewCtrl.getNO5PSDEUAGroupId())) {
                psDEUAGroupMap.put(psDEViewCtrl.getNO5PSDEUAGroupId(), "");
            }
            if (StringHelper.IsNullOrEmpty((String)psDEViewCtrl.getNO6PSDEUAGroupId())) continue;
            psDEUAGroupMap.put(psDEViewCtrl.getNO6PSDEUAGroupId(), "");
        }
        PSDEUAGroupService psDEUAGroupService = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)sessionFactory);
        PSDEUIActionService psDEUIActionService = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)sessionFactory);
        ArrayList<PSDEUIAction> psDEUIActionList = psDEUIActionService.select((ISelectCond)new SelectCond());
        HashMap<String, PSDEUIAction> psDEUIActionMap = new HashMap<String, PSDEUIAction>();
        for (PSDEUIAction psDEUIAction : psDEUIActionList) {
            psDEUIActionMap.put(psDEUIAction.getPSDEUIActionId(), psDEUIAction);
        }
        PSDEUAGroupDetailService psDEUAGroupDetailService = (PSDEUAGroupDetailService)ServiceGlobal.getService(PSDEUAGroupDetailService.class, (SessionFactory)sessionFactory);
        selectCond.reset();
        selectCond.setOrderInfo("ORDER BY ORDERVALUE");
        ArrayList<PSDEUAGroupDetail> psDEUAGroupDetailList = psDEUAGroupDetailService.select((ISelectCond)selectCond);
        for (PSDEUAGroupDetail psDEUAGroupDetail2 : psDEUAGroupDetailList) {
            PSDataEntity psDataEntity;
            PSDEUIAction psDEUIAction;
            if (!psDEUAGroupMap.containsKey(psDEUAGroupDetail2.getPSDEUAGroupId()) || (psDEUIAction = (PSDEUIAction)psDEUIActionMap.get(psDEUAGroupDetail2.getPSDEUIActionId())) == null || StringHelper.IsNullOrEmpty((String)psDEUIAction.getPSDEName()) || (psDataEntity = modelV2Map.get(psDEUIAction.getPSDEName())) == null) continue;
            PSDEUAGroup psDEUAGroup = new PSDEUAGroup();
            psDEUAGroup.setPSDEUAGroupId(KeyValueHelper.genUniqueId((String)psDataEntity.getPSDataEntityId(), (String)"MosExplorerMain"));
            if (psDEUAGroupService.checkKey(psDEUAGroup) != 1) continue;
            PSDEUAGroupDetail psDEUAGroupDetail = new PSDEUAGroupDetail();
            psDEUAGroupDetail.setPSDEUAGRPDetailId(KeyValueHelper.genUniqueId((String)psDEUAGroup.getPSDEUAGroupId(), (String)psDEUIAction.getCodeName()));
            if (psDEUAGroupDetailService.checkKey(psDEUAGroupDetail) == 1) continue;
            psDEUAGroupDetail.setPSDEUAGRPDetailName(psDEUIAction.getCodeName());
            psDEUAGroupDetail.setPSDEUAGroupId(psDEUAGroup.getPSDEUAGroupId());
            psDEUAGroupDetail.setPSDEUIActionId(psDEUIAction.getPSDEUIActionId());
            psDEUAGroupDetail.setOrderValue(psDEUAGroupDetail2.getOrderValue());
            psDEUAGroupDetail.setCodeName(psDEUIAction.getCodeName());
            psDEUAGroupDetailService.create(psDEUAGroupDetail, false);
        }
    }
}
