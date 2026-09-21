/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.IPSApplicationRuntime;
import SA.SRFDA.PS.Core.DevStudio.PSSysBTException;
import SA.SRFDA.PS.Core.DevStudio.PSSysDevBKTaskImplBase;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSModelObjectLogger;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemRuntime;
import SA.SRFDA.PS.Core.PSSystemUtil;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CheckSysModelPSSysDevBKTaskImpl
extends PSSysDevBKTaskImplBase {
    private static final Log log = LogFactory.getLog(CheckSysModelPSSysDevBKTaskImpl.class);

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Override
    protected String onRun() throws Exception {
        try {
            return this.checkSysModel();
        }
        catch (Exception ex) {
            ex2 /* !! */  = ex;
            strMessage = ex2 /* !! */ .getMessage();
            if (StringHelper.isNullOrEmpty((String)strMessage) || strMessage.indexOf("null") == -1) ** GOTO lbl15
            iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(this.psSysDevBKTask.getPSDEVSLNSYSID());
            this.getPSModelHelper(iPSDevSlnSys.getPSSysModelInstId()).resetCache();
            return this.checkSysModel();
        }
lbl-1000:
        // 1 sources

        {
            if (ex2 /* !! */  instanceof NullPointerException) {
                iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(this.psSysDevBKTask.getPSDEVSLNSYSID());
                this.getPSModelHelper(iPSDevSlnSys.getPSSysModelInstId()).resetCache();
                return this.checkSysModel();
            }
            ex2 /* !! */  = ex2 /* !! */ .getCause();
lbl15:
            // 2 sources

            ** while (ex2 /* !! */  != null)
        }
lbl16:
        // 1 sources

        throw ex;
    }

    protected String checkSysModel() throws Exception {
        IPSModelObjectLogger lastPSModelObjectLogger = null;
        IPSSystemRuntime iPSSystemRuntime = null;
        StringBuilderEx sBuilderEx = new StringBuilderEx();
        IPSDevSlnSys iPSDevSlnSys = null;
        Object iPSDevSlnSysDynaInst = null;
        if (!StringHelper.isNullOrEmpty((String)this.psSysDevBKTask.getPSDYNAINSTID())) {
            return null;
        }
        iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(this.psSysDevBKTask.getPSDEVSLNSYSID());
        try {
            IPSApplication iPSApplication;
            int nCount;
            IPSSystem iPSSystem = iPSDevSlnSys.getPSSystem(false);
            if (iPSSystem.getLoadedLevel() < this.getModelLoadLevel()) {
                iPSSystem = iPSDevSlnSys.reloadPSSystem(this.getModelLoadLevel());
            }
            if (iPSSystem instanceof IPSSystemRuntime) {
                iPSSystemRuntime = (IPSSystemRuntime)((Object)iPSSystem);
                lastPSModelObjectLogger = iPSSystemRuntime.getPSModelObjectLogger();
                iPSSystemRuntime.setPSModelObjectLogger(this.getPSModelObjectLogger());
                HashMap<String, Object> params = new HashMap<String, Object>();
                params.put("sys", iPSSystem);
                PSTemplHelper.setCurrentParams(params);
            }
            if ((nCount = iPSSystem.check(0)) > 0) {
                throw new PSSysBTException(5, StringHelper.format((String)"\u7cfb\u7edf\u6a21\u578b\u5b58\u5728\u9519\u8bef[%1$s]\uff0c\u5177\u4f53\u67e5\u770b\u3010\u7cfb\u7edf\u95ee\u9898\u3011", (Object)nCount));
            }
            ArrayList<String> reloadAppIds = new ArrayList<String>();
            Iterator<IPSApplication> psApplications = iPSSystem.getAllPSApps();
            while (psApplications.hasNext()) {
                iPSApplication = psApplications.next();
                if (iPSApplication.getLoadedLevel() >= this.getModelLoadLevel()) continue;
                reloadAppIds.add(iPSApplication.getId());
            }
            for (String strPSSysAppId : reloadAppIds) {
                PSSystemUtil.loadPSApplication(iPSSystem, strPSSysAppId, this.getModelLoadLevel());
            }
            psApplications = iPSSystem.getAllPSApps();
            while (psApplications.hasNext()) {
                iPSApplication = psApplications.next();
                ((IPSApplicationRuntime)((Object)iPSApplication)).calcPSAppViewSysRefFlag();
            }
            nCount = iPSSystem.check(1);
            if (nCount > 0) {
                throw new PSSysBTException(5, StringHelper.format((String)"\u7cfb\u7edf\u6a21\u578b\u5b58\u5728\u9519\u8bef[%1$s]\uff0c\u5177\u4f53\u67e5\u770b\u3010\u7cfb\u7edf\u95ee\u9898\u3011", (Object)nCount));
            }
            sBuilderEx.append("[v%1$s]\u7cfb\u7edf\u6a21\u578b\u68c0\u67e5\u5b8c\u6210", (Object)iPSSystem.getVersion());
            if (iPSSystemRuntime != null) {
                iPSSystemRuntime.setPSModelObjectLogger(lastPSModelObjectLogger);
                PSTemplHelper.setCurrentParams(null);
            }
        }
        catch (Exception ex) {
            if (iPSSystemRuntime != null) {
                iPSSystemRuntime.setPSModelObjectLogger(lastPSModelObjectLogger);
                PSTemplHelper.setCurrentParams(null);
            }
            throw ex;
        }
        return sBuilderEx.toString();
    }
}

