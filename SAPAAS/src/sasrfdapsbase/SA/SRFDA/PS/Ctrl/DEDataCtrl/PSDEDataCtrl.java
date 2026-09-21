/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSModelHelper;
import SA.SRFDA.PS.Core.IPSModelStorage;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSObjectFactory;
import SA.SRFDA.PS.Core.PSSystemUtil;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.IPSDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDEDataCtrl
extends BaseDEDataCtrl
implements IPSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSDEDataCtrl.class);
    public static final String CUSTOMCALL_RELOADMODEL = "RELOADMODEL";
    private static final String LONGORDERTAG = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
    private String strPSModelName = null;

    @Override
    public void setPSModelName(String strPSModelName) {
        this.strPSModelName = strPSModelName;
    }

    @Override
    public String getPSModelName() {
        return this.strPSModelName;
    }

    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        if (bInsert && dataEntity.IsParamNull(this.GetDEHelper().getKeyDEFHelper().getName())) {
            dataEntity.setParamValue(this.GetDEHelper().getKeyDEFHelper().getName(), (Object)Helper.GenGuidEx());
        }
        return callResult;
    }

    public CallResult reloadModel(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            this.onReloadModel(dataEntity);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5237\u65b0\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onReloadModel(BaseDataEntity dataEntity) throws Exception {
    }

    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_RELOADMODEL, (boolean)true) == 0) {
            return this.reloadModel(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    protected IPSModelHelper getPSModelHelper() throws Exception {
        return PSObjectFactory.getPSModelHelper(this.getGlobalHelper(), null);
    }

    protected IPSModelStorage getPSModelStorage() throws Exception {
        return PSObjectFactory.getPSModelStorage(this.getGlobalHelper());
    }

    protected static String getOrderString(int nOrderValue) {
        char[] ch = new char[]{(char)(65 + nOrderValue / 25), (char)(65 + nOrderValue % 25)};
        String strValue1 = new String(ch, 0, 2);
        return strValue1;
    }

    protected static String getFullOrderString(String strValue, int nLength) {
        return String.valueOf(strValue) + LONGORDERTAG.substring(0, nLength -= strValue.length());
    }

    public static void convertEntity(IEntity iEntity, BaseDataEntity dataEntity) throws Exception {
        HashMap objMap = new HashMap();
        iEntity.fillMap(objMap, true);
        for (String strKey : objMap.keySet()) {
            Object objValue = objMap.get(strKey);
            if (objValue == DataObject.EMPTY) {
                dataEntity.setParamValue(strKey, null);
                continue;
            }
            dataEntity.setParamValue(strKey, objValue);
        }
    }

    public static void convertEntity2(BaseDataEntity dataEntity, IEntity iEntity) throws Exception {
        HashMap objMap = new HashMap();
        dataEntity.FillMap(objMap);
        for (String strKey : objMap.keySet()) {
            Object objValue = objMap.get(strKey);
            iEntity.set(strKey, objValue);
        }
    }

    protected String runBat(String batName) throws Exception {
        StringBuilderEx sBuilderEx = new StringBuilderEx();
        Process ps = Runtime.getRuntime().exec(batName);
        WatchThread wt = new WatchThread(ps);
        wt.start();
        ps.waitFor();
        ArrayList<String> commandStream = wt.getStream();
        wt.setOver(true);
        for (String strInfo : commandStream) {
            sBuilderEx.append(strInfo);
            sBuilderEx.append("\r\n");
        }
        return sBuilderEx.toString();
    }

    protected IPSModelHelper getPSModelHelper(String strPSSysModelInstId) throws Exception {
        return PSObjectFactory.getPSModelHelper(this.getGlobalHelper(), strPSSysModelInstId);
    }

    protected IPSSystem getPSSystem(String strPSDevSlnSysId, String strPSSystemId, int nLoadLevel, boolean bLoadApp) throws Exception {
        IPSSystem iPSSystem = this.getPSSystem(strPSDevSlnSysId, strPSSystemId, nLoadLevel);
        if (bLoadApp) {
            ArrayList<String> reloadAppIds = new ArrayList<String>();
            Iterator<IPSApplication> psApplications = iPSSystem.getAllPSApps();
            while (psApplications.hasNext()) {
                IPSApplication iPSApplication = psApplications.next();
                if (iPSApplication.getLoadedLevel() >= nLoadLevel) continue;
                reloadAppIds.add(iPSApplication.getId());
            }
            for (String strPSSysAppId : reloadAppIds) {
                PSSystemUtil.loadPSApplication(iPSSystem, strPSSysAppId, nLoadLevel);
            }
        }
        return iPSSystem;
    }

    protected IPSSystem getPSSystem(String strPSDevSlnSysId, String strPSSystemId, int nLoadLevel) throws Exception {
        IPSSystem iPSSystem = null;
        if (!StringHelper.IsNullOrEmpty((String)strPSDevSlnSysId)) {
            IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(strPSDevSlnSysId);
            iPSSystem = iPSDevSlnSys.getPSSystem(false);
            if (iPSSystem.getLoadedLevel() < nLoadLevel) {
                iPSDevSlnSys.reloadPSSystem(nLoadLevel);
            }
            iPSSystem = iPSDevSlnSys.getPSSystem(true);
        } else {
            iPSSystem = this.getPSModelStorage().getPSSystem(strPSSystemId);
            if (iPSSystem.getLoadedLevel() < nLoadLevel) {
                this.getPSModelStorage().resetPSSystem(strPSSystemId);
                this.getPSModelHelper().startLoadPSSystem(strPSSystemId, nLoadLevel);
                try {
                    IPSSystem ipsSystem = this.getPSModelStorage().getPSSystem(strPSSystemId);
                    ipsSystem.load(nLoadLevel);
                    this.getPSModelHelper().stopLoadPSSystem();
                }
                catch (Exception ex) {
                    this.getPSModelHelper().stopLoadPSSystem();
                    throw ex;
                }
            }
            iPSSystem = this.getPSModelStorage().getPSSystem(strPSSystemId);
        }
        return iPSSystem;
    }

    protected IPSApplication getPSApplication(IPSSystem iPSSystem, String strPSSysAppId, int nLoadLevel) throws Exception {
        IPSApplication iPSApplication = iPSSystem.getPSApplication(strPSSysAppId);
        if (iPSApplication.getLoadedLevel() >= nLoadLevel) {
            return iPSApplication;
        }
        return PSSystemUtil.loadPSApplication(iPSSystem, strPSSysAppId, nLoadLevel);
    }

    public CallResult Get(BaseDataEntity dataEntity) {
        if (!StringHelper.IsNullOrEmpty((String)this.getPSModelName())) {
            CallResult callResult = new CallResult();
            try {
                IDataEntityModel iDEModel = DEModelGlobal.getDEModel((String)this.getPSModelName());
                IService iService = iDEModel.getService(PSCoreSysServiceBase.getCurMajorSessionFactory());
                IEntity iEntity = iDEModel.createEntity();
                iEntity.set(iDEModel.getKeyDEField().getName(), dataEntity.getParamValue(iDEModel.getKeyDEField().getName()));
                iService.get(iEntity);
                PSDEDataCtrl.convertEntity(iEntity, dataEntity);
                return callResult;
            }
            catch (Exception ex) {
                log.error((Object)String.format("\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u53d1\u751f\u5f02\u5e38\uff0c%2$s", this.getPSModelName(), ex.getMessage()), (Throwable)ex);
                callResult.setRetCode(1);
                callResult.setErrorInfo(ex.getMessage());
                return callResult;
            }
        }
        return super.Get(dataEntity);
    }

    class WatchThread
    extends Thread {
        Process p;
        boolean over;
        ArrayList<String> stream;
        boolean bError = false;
        WatchThread errorWatchThread = null;

        public WatchThread(Process p) {
            this.p = p;
            this.over = false;
            this.stream = new ArrayList();
            this.errorWatchThread = new WatchThread(p, true);
        }

        public WatchThread(Process p, boolean bError) {
            this.p = p;
            this.over = false;
            this.stream = new ArrayList();
            this.bError = bError;
        }

        @Override
        public synchronized void start() {
            if (this.errorWatchThread != null) {
                this.errorWatchThread.start();
            }
            super.start();
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void run() {
            Scanner br;
            block7: {
                String tempStream;
                br = null;
                try {
                    if (this.p == null) {
                        return;
                    }
                    br = new Scanner(this.bError ? this.p.getErrorStream() : this.p.getInputStream(), "GBK");
                    while (br.hasNextLine() && !this.over) {
                        tempStream = br.nextLine();
                        if (tempStream.trim() == null || tempStream.trim().equals("")) continue;
                        this.stream.add(tempStream);
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                    break block7;
                }
                while (this.p != null && !this.over) {
                    while (br.hasNextLine() && !this.over) {
                        tempStream = br.nextLine();
                        if (tempStream.trim() == null || tempStream.trim().equals("")) continue;
                        this.stream.add(tempStream);
                    }
                }
            }
            if (br != null) {
                br.close();
            }
        }

        public void setOver(boolean over) {
            this.over = over;
            if (this.errorWatchThread != null) {
                this.errorWatchThread.setOver(over);
            }
        }

        public ArrayList<String> getStream() {
            return this.stream;
        }
    }
}

