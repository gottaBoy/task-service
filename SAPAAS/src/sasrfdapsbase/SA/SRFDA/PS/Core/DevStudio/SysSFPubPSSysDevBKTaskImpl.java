/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.Deploy.PSSysRunSessionImpl2;
import SA.SRFDA.PS.Core.DevStudio.PubDynaInstModelPSSysDevBKTaskImpl;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSModelObjectLogger;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemRuntime;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.JIT.Web.PSJITWebContext;
import SA.SRFDA.PS.Core.PSModelObjectLoggerImpl;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.Pub.IPSCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSSysPubRuntime;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Pub.IPSSysSFUserCode;
import SA.SRFDA.PS.Core.Pub.PSPublishContextImpl;
import SA.SRFDA.PS.Core.Pub.PSSysSFPubImpl;
import SA.SRFDA.PS.Core.SF.IPSSFCodeFolder;
import SA.SRFDA.PS.Core.SF.IPSSFCodeType;
import SA.SRFDA.PS.Core.SF.IPSSFStyle;
import SA.SRFDA.PS.Core.SF.IPSSFVerCode;
import SA.SRFDA.PS.Core.SF.PSSFStyleParamImpl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSSysRunSession;
import SA.SRFDA.PS.Data.PSSysSFPub;
import SA.SRFramework.DataEx.CallResult;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class SysSFPubPSSysDevBKTaskImpl
extends PubDynaInstModelPSSysDevBKTaskImpl {
    private static final Log log = LogFactory.getLog(SysSFPubPSSysDevBKTaskImpl.class);

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected String onRun() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psSysDevBKTask.getTASKPARAM())) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u8981\u53d1\u5e03\u7684\u540e\u53f0\u4f53\u7cfb");
        }
        PSSysSFPubService psSysSFPubService = (PSSysSFPubService)ServiceGlobal.getService(PSSysSFPubService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub psSysSFPub = new net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub();
        psSysSFPub.setPSSysSFPubId(this.psSysDevBKTask.getTASKPARAM());
        psSysSFPubService.get((IEntity)psSysSFPub);
        return this.generateCode(psSysSFPub);
    }

    protected String generateCode(net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub psSysSFPub) throws Exception {
        IPSModelObjectLogger lastPSModelObjectLogger = null;
        IPSSystemRuntime iPSSystemRuntime = null;
        try {
            String strTaskType;
            if (this.getPSSysRunSession() != null && this.getPSSysRunSession().isRebuildMode()) {
                this.getPSModelStorage().resetPSDevSlnSys(this.psSysDevBKTask.getPSDEVSLNSYSID());
            }
            boolean bV2 = false;
            IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(this.psSysDevBKTask.getPSDEVSLNSYSID());
            IPSSystem iPSSystem = iPSDevSlnSys.getPSSystem(false);
            if (iPSSystem.getLoadedLevel() < this.getModelLoadLevel()) {
                iPSSystem = iPSDevSlnSys.reloadPSSystem(this.getModelLoadLevel());
            }
            if (StringHelper.compare((String)((IPSSystemUtil)((Object)iPSSystem)).getTemplEngineVer(), (String)"V2", (boolean)true) == 0) {
                bV2 = true;
            }
            iPSSystemRuntime = (IPSSystemRuntime)((Object)iPSSystem);
            lastPSModelObjectLogger = iPSSystemRuntime.getPSModelObjectLogger();
            String strLoggerName = StringHelper.format((String)"%1$s[%2$s]", (Object)psSysSFPub.getPSSFStyleName(), (Object)psSysSFPub.getPSSysSFPubName());
            PSModelObjectLoggerImpl psModelObjectLoggerImpl = new PSModelObjectLoggerImpl(this.getRootPSSysDevBKTask(), iPSSystem.getPSDevCenterDomain(), strLoggerName, -1);
            iPSSystemRuntime.setPSModelObjectLogger(psModelObjectLoggerImpl);
            ArrayList<String> reloadAppIds = new ArrayList<String>();
            Iterator<IPSApplication> psApplications = iPSSystem.getAllPSApps();
            while (psApplications.hasNext()) {
                IPSApplication iPSApplication = psApplications.next();
                if (iPSApplication.getLoadedLevel() < this.getModelLoadLevel()) {
                    reloadAppIds.add(iPSApplication.getId());
                    log.debug((Object)StringHelper.format((String)"\u7cfb\u7edf\u5e94\u7528[%1$s]\u6a21\u578b\u52a0\u8f7d\u7ea7\u522b[%2$s < %3$s]\uff0c\u91cd\u65b0\u52a0\u8f7d", (Object)iPSApplication.getName(), (Object)iPSApplication.getLoadedLevel(), (Object)this.getModelLoadLevel()));
                    continue;
                }
                log.debug((Object)StringHelper.format((String)"\u7cfb\u7edf\u5e94\u7528[%1$s]\u6a21\u578b\u52a0\u8f7d\u7ea7\u522b[%2$s > %3$s]", (Object)iPSApplication.getName(), (Object)iPSApplication.getLoadedLevel(), (Object)this.getModelLoadLevel()));
            }
            for (String strPSSysAppId : reloadAppIds) {
                long nTime = System.currentTimeMillis();
                this.getPSModelHelper().startLoadPSSysApp(strPSSysAppId, this.getModelLoadLevel());
                try {
                    IPSApplication iPSApplication = iPSSystem.getPSApplication(strPSSysAppId);
                    if (iPSApplication.getLoadedLevel() > IPSSystem.LOADLEVEL_NONE) {
                        iPSSystem.resetPSApplication(strPSSysAppId);
                        iPSApplication = iPSSystem.getPSApplication(strPSSysAppId);
                    }
                    iPSApplication.load(this.getModelLoadLevel());
                    this.getPSModelHelper().stopLoadPSSysApp();
                    nTime = System.currentTimeMillis() - nTime;
                    log.debug((Object)StringHelper.format((String)"\u7cfb\u7edf\u5e94\u7528[%1$s]\u6a21\u578b\u52a0\u8f7d\u5b8c\u6bd5[%2$s]\uff0c\u8017\u65f6[%3$s]ms", (Object)iPSApplication.getName(), (Object)iPSApplication.getLoadedLevel(), (Object)nTime));
                }
                catch (Exception ex) {
                    this.getPSModelHelper().stopLoadPSSysApp();
                    throw ex;
                }
            }
            iPSSystem.quickCheck();
            boolean bPubModelMode = false;
            if (this.getPSSysRunSession() != null) {
                bPubModelMode = StringHelper.compare((String)"PUBMODEL", (String)this.getPSSysRunSession().getRunMode(), (boolean)true) == 0;
            }
            HashMap<String, IPSSFCodeType> psSFCodeTypeMap = new HashMap<String, IPSSFCodeType>();
            PSSysSFPub psSysSFPub2 = new PSSysSFPub();
            PSDEDataCtrl.convertEntity((IEntity)psSysSFPub, psSysSFPub2);
            PSSysSFPubImpl psSysSFPubImpl = new PSSysSFPubImpl();
            psSysSFPubImpl.init(this.getDAGlobalHelper(), iPSSystem, psSysSFPub2);
            if (!bPubModelMode) {
                IPSSFStyle iPSSFStyle = null;
                iPSSFStyle = !psSysSFPubImpl.isDocMode() ? ((IPSSystemUtil)((Object)iPSSystem)).getPSSFStyle(iPSSystem.getSFType(), psSysSFPubImpl.getSFStyle(), psSysSFPubImpl.getCodeName()) : ((IPSSystemUtil)((Object)iPSSystem)).getPSSFStyle("DOC", psSysSFPubImpl.getSFStyle(), psSysSFPubImpl.getCodeName());
                Iterator<IPSSFCodeFolder> psSFCodeFolders = iPSSFStyle.getPSSFCodeFolders();
                while (psSFCodeFolders.hasNext()) {
                    IPSSFCodeFolder iPSSFCodeFolder = psSFCodeFolders.next();
                    if (this.getPSSysPubRuntime() != null) {
                        this.getPSSysPubRuntime().registerSFPubFolder(psSysSFPubImpl, iPSSFCodeFolder.getFolderCode());
                    }
                    Iterator<IPSSFCodeType> psSFCodeTypes = iPSSFCodeFolder.getPSSFCodeTypes();
                    while (psSFCodeTypes.hasNext()) {
                        IPSSFCodeType iPSSFCodeType = psSFCodeTypes.next();
                        if (iPSSFCodeType.isRemoveMode()) {
                            psSFCodeTypeMap.remove(iPSSFCodeType.getTypeCode());
                            continue;
                        }
                        psSFCodeTypeMap.put(iPSSFCodeType.getTypeCode(), iPSSFCodeType);
                    }
                }
                if (psSysSFPubImpl.getPSSFStyleVer() != null) {
                    Iterator<IPSSFVerCode> psSFVerCodes = psSysSFPubImpl.getPSSFStyleVer().getPSSFVerCodes();
                    while (psSFVerCodes.hasNext()) {
                        IPSSFVerCode iPSSFVerCode = psSFVerCodes.next();
                        if (iPSSFVerCode.isRemoveMode()) {
                            psSFCodeTypeMap.remove(iPSSFVerCode.getTypeCode());
                            continue;
                        }
                        psSFCodeTypeMap.put(iPSSFVerCode.getTypeCode(), iPSSFVerCode);
                    }
                }
            }
            PSSystemObjectImpl iPSSysSFPub = psSysSFPubImpl;
            if (this.getParentPSBKTask() != null && (strTaskType = this.getParentPSBKTask().getTaskType()).indexOf("STARTUPEX") == 0) {
                PSSysRunSession psSysRunSession = new PSSysRunSession();
                CallResult callResult = this.getPSModelHelper().getPSSysRunSession(this.getParentPSBKTask().getTaskParam(), psSysRunSession);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u7cfb\u7edf\u8fd0\u884c\u4f1a\u8bdd\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                PSSysRunSessionImpl2 psSysRunSessionImpl2 = new PSSysRunSessionImpl2();
                psSysRunSessionImpl2.init(this.getDAGlobalHelper(), (IPSSysSFPub)((Object)iPSSysSFPub), psSysRunSession);
                iPSSysSFPub = psSysRunSessionImpl2;
            }
            long nBeginTime = System.currentTimeMillis();
            if (!bPubModelMode) {
                ArrayList<IPSSFCodeType> psSFCodeTypeList = new ArrayList<IPSSFCodeType>();
                psSFCodeTypeList.addAll(psSFCodeTypeMap.values());
                TaskManager taskManager = new TaskManager((IPSSysSFPub)((Object)iPSSysSFPub), psSFCodeTypeList);
                taskManager.start();
                if (taskManager.getErrorCount() > 0) {
                    throw new Exception(StringHelper.format((String)"\u53d1\u5e03\u670d\u52a1\u540e\u53f0\u4ee3\u7801\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)taskManager.getErrorInfo()));
                }
                this.generateUserCode((IPSSysSFPub)((Object)iPSSysSFPub));
            }
            if (bV2 && (iPSSysSFPub.isPubModel() || bPubModelMode)) {
                this.generateModel((IPSSysSFPub)((Object)iPSSysSFPub), bPubModelMode);
            }
            if (this.getPSSysPubRuntime() != null) {
                this.getPSSysPubRuntime().endSFPubCode((IPSSysSFPub)((Object)iPSSysSFPub));
            }
            iPSSystemRuntime.setPSModelObjectLogger(lastPSModelObjectLogger);
            long nTime = System.currentTimeMillis() - nBeginTime;
            return StringHelper.format((String)"[v%1$s]\u53d1\u5e03\u670d\u52a1\u540e\u53f0\u4ee3\u7801\uff0c\u8017\u65f6[%2$s]ms", (Object)iPSSystem.getVersion(), (Object)nTime);
        }
        catch (Exception ex) {
            if (iPSSystemRuntime != null) {
                iPSSystemRuntime.setPSModelObjectLogger(lastPSModelObjectLogger);
            }
            throw ex;
        }
    }

    protected void generateUserCode(IPSSysSFPub iPSSysSFPub) throws Exception {
        Iterator<IPSSysSFUserCode> psSysSFUserCodes;
        if (this.getPSSysPubRuntime() != null) {
            this.getPSSysPubRuntime().registerSFPubFolder(iPSSysSFPub, "USERCODE");
        }
        if ((psSysSFUserCodes = iPSSysSFPub.getPSSysSFUserCodes()) == null) {
            return;
        }
        String strCodeFolder = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "CODEFOLDER", null);
        String strToolFolder = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "TOOLFOLDER", null);
        if (StringHelper.isNullOrEmpty((String)strCodeFolder)) {
            throw new Exception("\u6ca1\u6709\u5b9a\u4e49\u4ee3\u7801\u53d1\u5e03\u76ee\u5f55");
        }
        IPSSystem iPSSystem = iPSSysSFPub.getPSSystem();
        while (psSysSFUserCodes.hasNext()) {
            String strFullPath;
            File folder;
            IPSSysSFUserCode iPSSysSFUserCode = psSysSFUserCodes.next();
            String strFolder = strCodeFolder;
            strFolder = String.valueOf(strFolder) + File.separator + iPSSystem.getPSDevCenterDomain();
            strFolder = String.valueOf(strFolder) + File.separator + iPSSystem.getPubSystemId();
            strFolder = String.valueOf(strFolder) + File.separator + iPSSystem.getVCName();
            strFolder = String.valueOf(strFolder) + File.separator + "srv_" + iPSSysSFPub.getCodeName();
            strFolder = String.valueOf(strFolder) + File.separator + "USERCODE";
            strFolder = String.valueOf(strFolder) + File.separator + iPSSysSFUserCode.getProjectType();
            if (!StringHelper.isNullOrEmpty((String)iPSSysSFUserCode.getFilePath())) {
                strFolder = String.valueOf(strFolder) + File.separator + iPSSysSFUserCode.getFilePath();
            }
            if (!(folder = new File(strFolder = strFolder.replace("/", File.separator))).exists()) {
                folder.mkdirs();
            }
            if ((strFullPath = String.valueOf(strFolder) + File.separator + iPSSysSFUserCode.getName()).length() >= PSTaskServerEnvImpl.getCurrent().getMaxFileNameLength()) {
                String strInfo = StringHelper.format((String)"\u53d1\u5e03\u4ee3\u7801[%1$s]\u8def\u5f84\u8fc7\u957f[%2$s]\uff0c\u53ef\u80fd\u65e0\u6cd5\u5199\u5165", (Object)strFullPath, (Object)strFullPath.length());
                ((IPSSystemUtil)((Object)iPSSystem)).log(4, iPSSysSFPub, strInfo);
                log.warn((Object)strInfo);
                this.log(4, null, strInfo);
                if (PSTaskServerEnvImpl.getCurrent().isThrowExceptionWhenFileNameTooLong()) {
                    throw new Exception(StringHelper.format((String)"\u53d1\u5e03\u4ee3\u7801[%1$s]\u540d\u79f0\u957f\u5ea6\u8d85\u8fc7[%2$s]", (Object)strFullPath, (Object)PSTaskServerEnvImpl.getCurrent().getMaxFileNameLength()));
                }
            }
            if (this.getPSSysPubRuntime() != null) {
                ((IPSSystemUtil)((Object)iPSSystem)).pubSFCode(this.getPSSysPubRuntime(), iPSSysSFPub, "USERCODE", strFullPath, iPSSysSFUserCode.getUserCode(), null);
                continue;
            }
            ((IPSSystemUtil)((Object)iPSSystem)).writeFile(strFullPath, iPSSysSFUserCode.getUserCode(), null);
        }
    }

    protected void generateModel(IPSSysSFPub iPSSysSFPub, boolean bPubModelMode) throws Exception {
        this.preparePSSFLogicTempls();
        String strCodeFolder = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "CODEFOLDER", null);
        IPSSystem iPSSystem = iPSSysSFPub.getPSSystem();
        String strFolder = strCodeFolder;
        strFolder = String.valueOf(strFolder) + File.separator + iPSSystem.getPSDevCenterDomain();
        strFolder = String.valueOf(strFolder) + File.separator + iPSSystem.getPubSystemId();
        if (bPubModelMode && iPSSystem.getRTPSSVNInstRepo() != null) {
            strFolder = String.valueOf(strFolder) + File.separator + "@RUNTIME";
        } else {
            strFolder = String.valueOf(strFolder) + File.separator + iPSSystem.getVCName();
            strFolder = String.valueOf(strFolder) + File.separator + iPSSystem.getCodeName();
            String strGroovySourceFolder = iPSSysSFPub.getGroovySourceFolder();
            if (!StringHelper.isNullOrEmpty((String)strGroovySourceFolder)) {
                this.setGroovySourcePath(String.valueOf(strFolder) + File.separator + strGroovySourceFolder);
            }
        }
        String strProject = strFolder;
        File modelFile = new File(String.format("%1$s%2$sibizmodel.yaml", strProject, File.separator));
        strFolder = String.valueOf(strFolder) + File.separator + iPSSysSFPub.getModelFolder();
        this.setCfgPath(strFolder);
        int nLastDynaModelPubMode = PSObjectImpl.getDynaModelPubMode();
        if (iPSSysSFPub.isPubGenCodeModel() || bPubModelMode) {
            PSObjectImpl.setDynaModelPubMode(12);
        } else if (iPSSysSFPub.isPubModelMemo()) {
            PSObjectImpl.setDynaModelPubMode(20);
        } else {
            PSObjectImpl.setDynaModelPubMode(4);
        }
        this.pubPSSystemModel(iPSSystem);
        this.pubIBizModelFile(modelFile, iPSSystem, iPSSysSFPub);
        PSObjectImpl.setDynaModelPubMode(nLastDynaModelPubMode);
    }

    @Override
    protected boolean isCoreModelMode() {
        return true;
    }

    @Override
    protected boolean isCodeGenModelMode() {
        return (PSObjectImpl.getDynaModelPubMode() & 8) != 0;
    }

    private class TaskManager {
        private ArrayList<IPSSFCodeType> psSFCodeTypeList = new ArrayList();
        private IPSSysSFPub iPSSysSFPub = null;
        private int nTotalCount = 0;
        private int nFinishCount = 0;
        private int nErrorCount = 0;
        private StringBuilderEx errorBuilder = new StringBuilderEx();

        public TaskManager(IPSSysSFPub iPSSysSFPub, ArrayList<IPSSFCodeType> psSFCodeTypeList) {
            this.psSFCodeTypeList.addAll(psSFCodeTypeList);
            this.iPSSysSFPub = iPSSysSFPub;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void start() throws Exception {
            this.nTotalCount = this.psSFCodeTypeList.size();
            if (this.nTotalCount == 0) {
                return;
            }
            int i = 0;
            while (i < SysSFPubPSSysDevBKTaskImpl.this.getTaskThreadCount()) {
                SysSFPubPSSysDevBKTaskImpl.this.executeTask(new Runnable(){

                    @Override
                    public void run() {
                        while (TaskManager.this.runTask() && TaskManager.this.getErrorCount() == 0) {
                        }
                    }
                });
                ++i;
            }
            while (true) {
                ArrayList<IPSSFCodeType> arrayList = this.psSFCodeTypeList;
                synchronized (arrayList) {
                    if (this.nTotalCount == this.nFinishCount || this.getErrorCount() > 0) {
                        break;
                    }
                }
                Thread.sleep(50L);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public boolean runTask() {
            if (PSJITWebContext.getInstance() != null) {
                PSJITWebContext.setCurrent(null);
            }
            IPSSFCodeType iPSSFCodeType = null;
            ArrayList<IPSSFCodeType> arrayList = this.psSFCodeTypeList;
            synchronized (arrayList) {
                if (this.psSFCodeTypeList.size() <= 0) {
                    return false;
                }
                iPSSFCodeType = this.psSFCodeTypeList.remove(0);
            }
            IPSCodePublisher iPSSFSysCodePublisher = null;
            try {
                PSSFStyleParamImpl.setCurrent(this.iPSSysSFPub.getPSSFStyleParam());
                PSPublishContextImpl psPublishContextImpl = new PSPublishContextImpl(SysSFPubPSSysDevBKTaskImpl.this.getDAGlobalHelper(), null);
                psPublishContextImpl.setPSSysModelInstId(SysSFPubPSSysDevBKTaskImpl.this.getPSSysModelInstId());
                psPublishContextImpl.setPSLogItemList(SysSFPubPSSysDevBKTaskImpl.this.getPSLogItemList());
                HashMap<String, Object> params = new HashMap<String, Object>();
                IPSSysPubRuntime iPSSysPubRuntime = SysSFPubPSSysDevBKTaskImpl.this.getPSSysPubRuntime();
                if (iPSSysPubRuntime != null) {
                    params.put("syspub", iPSSysPubRuntime);
                }
                if (params.size() > 0) {
                    psPublishContextImpl.setPubParams(params);
                }
                iPSSFSysCodePublisher = iPSSFCodeType.getPSSFSysCodePublisher();
                iPSSFSysCodePublisher.generateCode(psPublishContextImpl, this.iPSSysSFPub);
                iPSSFSysCodePublisher.close();
                PSSFStyleParamImpl.setCurrent(null);
            }
            catch (Exception ex) {
                PSSFStyleParamImpl.setCurrent(null);
                StringBuilderEx stringBuilderEx = this.errorBuilder;
                synchronized (stringBuilderEx) {
                    this.errorBuilder.append(ex.getMessage());
                    ++this.nErrorCount;
                }
                if (iPSSFSysCodePublisher != null) {
                    iPSSFSysCodePublisher.close();
                }
                if (iPSSFCodeType != null) {
                    log.error((Object)StringHelper.format((String)"[%1$s][%2$s]\u6a21\u677f\u6709\u8bef", (Object)iPSSFCodeType.getPSSFStyle().getName(), (Object)iPSSFCodeType.getTypeCode()));
                }
                log.error((Object)ex);
                return false;
            }
            ArrayList<IPSSFCodeType> arrayList2 = this.psSFCodeTypeList;
            synchronized (arrayList2) {
                ++this.nFinishCount;
                return true;
            }
        }

        public String getErrorInfo() {
            return this.errorBuilder.toString();
        }

        public int getErrorCount() {
            return this.nErrorCount;
        }
    }
}

