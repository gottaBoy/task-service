/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.Help.IPSHelpArticle;
import SA.SRFDA.PS.Core.Help.IPSHelpArticlePublisher;
import SA.SRFDA.PS.Core.Help.IPSHelpPrj;
import SA.SRFDA.PS.Core.Help.IPSHelpPrjPublisher;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.JIT.Web.PSJITWebContext;
import SA.SRFDA.PS.Core.PSSystemUtil;
import SA.SRFDA.PS.Core.Pub.IPSSFSysCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSPublishContextImpl;
import SA.SRFDA.PS.Core.Pub.PSSysSFPubImpl;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Core.SF.IPSSFCodeFolder;
import SA.SRFDA.PS.Core.SF.IPSSFCodeType;
import SA.SRFDA.PS.Core.SF.IPSSFStyle;
import SA.SRFDA.PS.Core.SF.IPSSFVerCode;
import SA.SRFDA.PS.Core.Util.SystemDumpHelper;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSSysSFPub;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysSFPubDataCtrl
extends PSDEDataCtrl {
    public static final String CUSTOMCALL_PUBLISHCODE = "PUBLISHCODE";
    public static final String CUSTOMCALL_GENERATECODE = "GENERATECODE";
    public static final String CUSTOMCALL_PUBLISHHELP = "PUBLISHHELP";
    public static final String CUSTOMCALL_DUMPMODEL = "DUMPMODEL";
    private static final Log log = LogFactory.getLog(PSSysSFPubDataCtrl.class);

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
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_PUBLISHCODE, (boolean)true) == 0) {
            return this.publishCode(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_PUBLISHHELP, (boolean)true) == 0) {
            return this.publishHelp(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_GENERATECODE, (boolean)true) == 0) {
            return this.generateCode(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_DUMPMODEL, (boolean)true) == 0) {
            return this.dumpModel(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult generateCode(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            PSSysSFPub psSysSFPub = new PSSysSFPub();
            psSysSFPub.proxy(dataEntity);
            this.onGenerateCode(psSysSFPub, null);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u53d1\u5e03\u7cfb\u7edf\u4ee3\u7801\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected IPSSystem preparePSSystem(PSSysSFPub psSysSFPub) throws Exception {
        String strPSSystemId = psSysSFPub.getPSSYSTEMID();
        IPSSystem iPSSystem = this.getPSModelStorage().getPSSystem(strPSSystemId);
        if (iPSSystem.getLoadedLevel() < IPSSystem.LOADLEVEL_CODE) {
            this.getPSModelStorage().resetPSSystem(strPSSystemId);
            this.getPSModelHelper().startLoadPSSystem(strPSSystemId, IPSSystem.LOADLEVEL_CODE);
            try {
                iPSSystem = this.getPSModelStorage().getPSSystem(strPSSystemId);
                iPSSystem.load(IPSSystem.LOADLEVEL_CODE);
                this.getPSModelHelper().stopLoadPSSystem();
            }
            catch (Exception ex) {
                this.getPSModelHelper().stopLoadPSSystem();
                throw ex;
            }
        }
        ArrayList<String> reloadAppIds = new ArrayList<String>();
        Iterator<IPSApplication> psApplications = iPSSystem.getAllPSApps();
        while (psApplications.hasNext()) {
            IPSApplication iPSApplication = psApplications.next();
            if (iPSApplication.getPSSysSFPub() != null && StringHelper.Compare((String)iPSApplication.getPSSysSFPub().getId(), (String)psSysSFPub.getPSSYSSFPUBID(), (boolean)false) != 0 || iPSApplication.getLoadedLevel() >= IPSSystem.LOADLEVEL_CODE) continue;
            reloadAppIds.add(iPSApplication.getId());
        }
        for (String strPSSysAppId : reloadAppIds) {
            PSSystemUtil.loadPSApplication(iPSSystem, strPSSysAppId, IPSSystem.LOADLEVEL_CODE);
        }
        return iPSSystem;
    }

    protected void onGenerateCode(PSSysSFPub psSysSFPub, Boolean bGlobalMode) throws Exception {
        IPSSystem iPSSystem = this.preparePSSystem(psSysSFPub);
        HashMap<String, IPSSFCodeType> psSFCodeTypeMap = new HashMap<String, IPSSFCodeType>();
        PSSysSFPubImpl psSysSFPubImpl = new PSSysSFPubImpl();
        psSysSFPubImpl.init(this.getGlobalHelper(), iPSSystem, psSysSFPub);
        IPSSFStyle iPSSFStyle = psSysSFPubImpl.getPSSFStyle();
        Iterator<IPSSFCodeFolder> psSFCodeFolders = iPSSFStyle.getPSSFCodeFolders();
        while (psSFCodeFolders.hasNext()) {
            IPSSFCodeFolder iPSSFCodeFolder = psSFCodeFolders.next();
            Iterator<IPSSFCodeType> psSFCodeTypes = iPSSFCodeFolder.getPSSFCodeTypes();
            while (psSFCodeTypes.hasNext()) {
                IPSSFCodeType iPSSFCodeType = psSFCodeTypes.next();
                if (bGlobalMode != null && iPSSFCodeType.isGlobalCodeType() != bGlobalMode.booleanValue()) continue;
                psSFCodeTypeMap.put(iPSSFCodeType.getTypeCode(), iPSSFCodeType);
            }
        }
        if (psSysSFPubImpl.getPSSFStyleVer() != null) {
            Iterator<IPSSFVerCode> psSFVerCodes = psSysSFPubImpl.getPSSFStyleVer().getPSSFVerCodes();
            while (psSFVerCodes.hasNext()) {
                IPSSFVerCode iPSSFVerCode = psSFVerCodes.next();
                if (!psSFCodeTypeMap.containsKey(iPSSFVerCode.getTypeCode())) continue;
                psSFCodeTypeMap.put(iPSSFVerCode.getTypeCode(), iPSSFVerCode);
            }
        }
        ArrayList<IPSSFCodeType> psSFCodeTypeList = new ArrayList<IPSSFCodeType>();
        psSFCodeTypeList.addAll(psSFCodeTypeMap.values());
        TaskManager taskManager = new TaskManager((IDEDataCtrl)this, psSysSFPubImpl, psSFCodeTypeList);
        long nBeginTime = System.currentTimeMillis();
        taskManager.start();
        if (taskManager.getErrorCount() > 0) {
            throw new Exception(StringHelper.Format((String)"\u53d1\u5e03\u670d\u52a1\u540e\u53f0\u4ee3\u7801\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)taskManager.getLastError()));
        }
        long nTime = System.currentTimeMillis() - nBeginTime;
        log.debug((Object)StringHelper.Format((String)"\u53d1\u5e03\u670d\u52a1\u540e\u53f0\u4ee3\u7801\uff0c\u8017\u65f6[%1$s]ms", (Object)nTime));
    }

    public CallResult publishCode(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            PSSysSFPub psSysSFPub = new PSSysSFPub();
            psSysSFPub.proxy(dataEntity);
            this.onGenerateCode(psSysSFPub, true);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u53d1\u5e03\u7cfb\u7edf\u4ee3\u7801\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    public CallResult publishHelp(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            PSSysSFPub psSysSFPub = new PSSysSFPub();
            psSysSFPub.proxy(dataEntity);
            this.onPublishHelp(psSysSFPub, true);
            log.error((Object)StringHelper.Format((String)"/****************************************\u53d1\u5e03\u7cfb\u7edf\u5e2e\u52a9\u5b8c\u6210****************************************/"));
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u53d1\u5e03\u7cfb\u7edf\u5e2e\u52a9\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onPublishHelp(PSSysSFPub psSysSFPub, Boolean bGlobalMode) throws Exception {
        PSPublishContextImpl psPublishContextImpl = new PSPublishContextImpl((IDEDataCtrl)this);
        IPSSystem iPSSystem = this.preparePSSystem(psSysSFPub);
        iPSSystem.getAllPSHelpResources();
        Iterator<IPSHelpArticle> psHelpArticles = iPSSystem.getAllPSHelpArticles();
        while (psHelpArticles.hasNext()) {
            IPSHelpArticle iPSHelpArticle = psHelpArticles.next();
            if (iPSHelpArticle.getPSHelpArticleTempl() == null) continue;
            IPSHelpArticlePublisher iPSHelpArticlePublisher = iPSHelpArticle.getPSHelpArticleTempl().getPSHelpArticlePublisher();
            iPSHelpArticlePublisher.saveFile(psPublishContextImpl, iPSHelpArticle);
            iPSHelpArticlePublisher.close();
        }
        Iterator<IPSHelpPrj> psHelpPrjs = iPSSystem.getAllPSHelpPrjs();
        while (psHelpPrjs.hasNext()) {
            IPSHelpPrj iPSHelpPrj = psHelpPrjs.next();
            if (iPSHelpPrj.getPSHelpPrjTempl() == null) continue;
            IPSHelpPrjPublisher iPSHelpPrjPublisher = iPSHelpPrj.getPSHelpPrjTempl().getPSHelpPrjPublisher();
            iPSHelpPrjPublisher.saveFile(psPublishContextImpl, iPSHelpPrj);
            iPSHelpPrjPublisher.close();
        }
        iPSSystem.resetAllPSHelpPrjs();
        iPSSystem.resetAllPSHelpArticles();
        iPSSystem.resetAllPSHelpResources();
    }

    protected void onDumpModel(PSSysSFPub psSysSFPub) throws Exception {
        IPSSystem iPSSystem = this.preparePSSystem(psSysSFPub);
        SystemDumpHelper.dump(iPSSystem, new File("D:\\systemmodel.xml"));
    }

    public CallResult dumpModel(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            PSSysSFPub psSysSFPub = new PSSysSFPub();
            psSysSFPub.proxy(dataEntity);
            this.onDumpModel(psSysSFPub);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5bfc\u51fa\u7cfb\u7edf\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    public class TaskManager {
        private ArrayList<IPSSFCodeType> psSFCodeTypeList = new ArrayList();
        private IDEDataCtrl psSysSFPubDataCtrl = null;
        private PSSysSFPubImpl psSysSFPubImpl = null;
        private int nTotalCount = 0;
        private int nFinishCount = 0;
        private int nErrorCount = 0;
        private String strLastError = null;

        public TaskManager(IDEDataCtrl psSysSFPubDataCtrl, PSSysSFPubImpl psSysSFPubImpl, ArrayList<IPSSFCodeType> psSFCodeTypeList) {
            this.psSFCodeTypeList.addAll(psSFCodeTypeList);
            this.psSysSFPubDataCtrl = psSysSFPubDataCtrl;
            this.psSysSFPubImpl = psSysSFPubImpl;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void start() throws Exception {
            this.nTotalCount = this.psSFCodeTypeList.size();
            if (this.nTotalCount == 0) {
                return;
            }
            ArrayList<TaskThread> threads = new ArrayList<TaskThread>();
            int i = 0;
            while (i < 5) {
                TaskThread taskThread = new TaskThread();
                threads.add(taskThread);
                taskThread.start();
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
            threads.clear();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public boolean runTask() {
            ArrayList<IPSSFCodeType> arrayList;
            block12: {
                IPSSFCodeType iPSSFCodeType = null;
                arrayList = this.psSFCodeTypeList;
                synchronized (arrayList) {
                    if (this.psSFCodeTypeList.size() <= 0) {
                        return false;
                    }
                    iPSSFCodeType = this.psSFCodeTypeList.remove(0);
                }
                try {
                    PSPublishContextImpl psPublishContextImpl = new PSPublishContextImpl(this.psSysSFPubDataCtrl);
                    IPSSFSysCodePublisher iPSSFSysCodePublisher = iPSSFCodeType.getPSSFSysCodePublisher();
                    iPSSFSysCodePublisher.generateCode(psPublishContextImpl, this.psSysSFPubImpl);
                    iPSSFSysCodePublisher.close();
                }
                catch (Exception ex) {
                    log.error((Object)ex);
                    if (!PSTemplHelper.isExceptionWhenError()) break block12;
                    ArrayList<IPSSFCodeType> arrayList2 = this.psSFCodeTypeList;
                    synchronized (arrayList2) {
                        ++this.nErrorCount;
                        this.strLastError = ex.getMessage();
                        return false;
                    }
                }
            }
            arrayList = this.psSFCodeTypeList;
            synchronized (arrayList) {
                ++this.nFinishCount;
                return true;
            }
        }

        public int getErrorCount() {
            return this.nErrorCount;
        }

        public String getLastError() {
            return this.strLastError;
        }

        public class TaskThread
        extends Thread {
            @Override
            public void run() {
                if (PSJITWebContext.getInstance() != null) {
                    PSJITWebContext.setCurrent(null);
                }
                while (TaskManager.this.runTask() && TaskManager.this.getErrorCount() <= 0) {
                    try {
                        Thread.sleep(10L);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

