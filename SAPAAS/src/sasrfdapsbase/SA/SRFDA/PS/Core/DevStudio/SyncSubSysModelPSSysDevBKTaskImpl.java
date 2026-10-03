/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.pscore.srv.config.entity.PSSubApp
 *  net.ibizsys.pscore.srv.config.entity.PSSubAppView
 *  net.ibizsys.pscore.srv.config.entity.PSSubDE
 *  net.ibizsys.pscore.srv.config.entity.PSSubDEAction
 *  net.ibizsys.pscore.srv.config.entity.PSSubDEView
 *  net.ibizsys.pscore.srv.config.entity.PSSubSys
 *  net.ibizsys.pscore.srv.config.entity.PSSubSysSF
 *  net.ibizsys.pscore.srv.config.service.PSSubAppService
 *  net.ibizsys.pscore.srv.config.service.PSSubAppViewService
 *  net.ibizsys.pscore.srv.config.service.PSSubDEActionService
 *  net.ibizsys.pscore.srv.config.service.PSSubDEService
 *  net.ibizsys.pscore.srv.config.service.PSSubDEViewService
 *  net.ibizsys.pscore.srv.config.service.PSSubSysSFService
 *  net.ibizsys.pscore.srv.config.service.PSSubSysService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Core.DevStudio.PSSysDevBKTaskImplBase;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSSubAppView;
import SA.SRFDA.PS.Data.PSSubDE;
import SA.SRFDA.PS.Data.PSSubSys;
import SA.SRFDA.PS.Data.PSSubSysSF;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.pscore.srv.config.entity.PSSubApp;
import net.ibizsys.pscore.srv.config.entity.PSSubDEAction;
import net.ibizsys.pscore.srv.config.entity.PSSubDEView;
import net.ibizsys.pscore.srv.config.service.PSSubAppService;
import net.ibizsys.pscore.srv.config.service.PSSubAppViewService;
import net.ibizsys.pscore.srv.config.service.PSSubDEActionService;
import net.ibizsys.pscore.srv.config.service.PSSubDEService;
import net.ibizsys.pscore.srv.config.service.PSSubDEViewService;
import net.ibizsys.pscore.srv.config.service.PSSubSysSFService;
import net.ibizsys.pscore.srv.config.service.PSSubSysService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class SyncSubSysModelPSSysDevBKTaskImpl
extends PSSysDevBKTaskImplBase {
    private static final Log log = LogFactory.getLog(SyncSubSysModelPSSysDevBKTaskImpl.class);

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected String onRun() throws Exception {
        PSSubSysService psSubSysService = (PSSubSysService)ServiceGlobal.getService(PSSubSysService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        net.ibizsys.pscore.srv.config.entity.PSSubSys psSubSys2 = new net.ibizsys.pscore.srv.config.entity.PSSubSys();
        psSubSys2.setPSSubSysId(this.psSysDevBKTask.getTASKPARAM());
        psSubSysService.get(psSubSys2);
        try {
            SessionFactoryManager.addRef();
            String strResult = this.syncSubSysModel(psSubSys2);
            SessionFactoryManager.releaseRef((boolean)true);
            return strResult;
        }
        catch (Exception ex) {
            SessionFactoryManager.releaseRef((boolean)false);
            throw ex;
        }
    }

    protected String syncSubSysModel(net.ibizsys.pscore.srv.config.entity.PSSubSys psSubSys) throws Exception {
        StringBuilderEx sBuilderEx = new StringBuilderEx();
        sBuilderEx.append("\u5b50\u7cfb\u7edf\u5df2\u66f4\u65b0\u4e3a\u6700\u65b0\u3002");
        return sBuilderEx.toString();
    }

    protected String syncSubSysModel2(net.ibizsys.pscore.srv.config.entity.PSSubSys psSubSys) throws Exception {
        StringBuilderEx sBuilderEx = new StringBuilderEx();
        PSSubSys psSubSys2 = new PSSubSys();
        psSubSys2.setPSSUBSYSID(psSubSys.getPSSubSysId());
        IDEDataCtrl psSubSysDataCtrl = this.getDAModelStorage().FindDEDataCtrl("DE1950", "SYSTEM", null);
        CallResult callResult = psSubSysDataCtrl.Get((BaseDataEntity)psSubSys2);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b50\u7cfb\u7edf\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        Integer nVersion = psSubSys.getVersion();
        if (nVersion != null && nVersion.intValue() == psSubSys2.getVERSION()) {
            sBuilderEx.append("\u5b50\u7cfb\u7edf\u7248\u672c\u5df2\u4e3a\u6700\u65b0\uff0c\u65e0\u9700\u540c\u6b65\u3002");
            return sBuilderEx.toString();
        }
        IDEDataCtrl psSubDEActionDataCtrl = this.getDAModelStorage().FindDEDataCtrl("DE1952", "SYSTEM", null);
        BaseDataEntity cond = new BaseDataEntity();
        cond.setParamValue("PSSUBSYSID", (Object)psSubSys2.getPSSUBSYSID());
        IDEDataCtrl psSubDEDataCtrl = this.getDAModelStorage().FindDEDataCtrl("DE1951", "SYSTEM", null);
        Vector<PSSubDE> psSubDEList = new Vector<PSSubDE>();
        callResult = psSubDEDataCtrl.Select(cond, psSubDEList, PSSubDE.class.getName());
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b50\u7cfb\u7edf\u5b9e\u4f53\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        PSSubSysService psSubSysService = (PSSubSysService)ServiceGlobal.getService(PSSubSysService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        PSSubDEService psSubDEService = (PSSubDEService)ServiceGlobal.getService(PSSubDEService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        PSSubDEActionService psSubDEActionService = (PSSubDEActionService)ServiceGlobal.getService(PSSubDEActionService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        PSSubDEViewService psSubDEViewService = (PSSubDEViewService)ServiceGlobal.getService(PSSubDEViewService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        PSSubAppService psSubAppService = (PSSubAppService)ServiceGlobal.getService(PSSubAppService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        PSSubSysSFService psSubSysSFService = (PSSubSysSFService)ServiceGlobal.getService(PSSubSysSFService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        PSSubAppViewService psSubAppViewService = (PSSubAppViewService)ServiceGlobal.getService(PSSubAppViewService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        for (PSSubDE psSubDE2 : psSubDEList) {
            net.ibizsys.pscore.srv.config.entity.PSSubDE psSubDE = new net.ibizsys.pscore.srv.config.entity.PSSubDE();
            PSDEDataCtrl.convertEntity2(psSubDE2, (IEntity)psSubDE);
            psSubDEService.save(psSubDE);
            cond.Reset();
            cond.setParamValue("PSSUBDEID", (Object)psSubDE2.getPSSUBDEID());
            Vector psSubDEActionList = new Vector();
            callResult = psSubDEActionDataCtrl.Select(cond, psSubDEActionList, SA.SRFDA.PS.Data.PSSubDEAction.class.getName());
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b50\u7cfb\u7edf\u5b9e\u4f53\u64cd\u4f5c\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            Iterator iterator = psSubDEActionList.iterator();
            while (iterator.hasNext()) {
                SA.SRFDA.PS.Data.PSSubDEAction psSubDEAction2 = (SA.SRFDA.PS.Data.PSSubDEAction)((Object)iterator.next());
                PSSubDEAction psSubDEAction = new PSSubDEAction();
                PSDEDataCtrl.convertEntity2(psSubDEAction2, (IEntity)psSubDEAction);
                psSubDEActionService.save(psSubDEAction);
            }
        }
        cond.Reset();
        cond.setParamValue("PSSUBSYSID", (Object)psSubSys2.getPSSUBSYSID());
        IDEDataCtrl psSubDEViewDataCtrl = this.getDAModelStorage().FindDEDataCtrl("DE1955", "SYSTEM", null);
        Vector<SA.SRFDA.PS.Data.PSSubDEView> psSubDEViewList = new Vector<SA.SRFDA.PS.Data.PSSubDEView>();
        callResult = psSubDEViewDataCtrl.Select(cond, psSubDEViewList, SA.SRFDA.PS.Data.PSSubDEView.class.getName());
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b50\u7cfb\u7edf\u5b9e\u4f53\u89c6\u56fe\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (SA.SRFDA.PS.Data.PSSubDEView psSubDEView2 : psSubDEViewList) {
            PSSubDEView psSubDEView = new PSSubDEView();
            PSDEDataCtrl.convertEntity2(psSubDEView2, (IEntity)psSubDEView);
            psSubDEViewService.save(psSubDEView);
        }
        cond.Reset();
        cond.setParamValue("PSSUBSYSID", (Object)psSubSys2.getPSSUBSYSID());
        IDEDataCtrl psSubSysSFDataCtrl = this.getDAModelStorage().FindDEDataCtrl("DE1953", "SYSTEM", null);
        Vector<PSSubSysSF> psSubSysSFList = new Vector<PSSubSysSF>();
        callResult = psSubSysSFDataCtrl.Select(cond, psSubSysSFList, PSSubSysSF.class.getName());
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b50\u7cfb\u7edf\u670d\u52a1\u4f53\u7cfb\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSubSysSF psSubSysSF2 : psSubSysSFList) {
            net.ibizsys.pscore.srv.config.entity.PSSubSysSF psSubSysSF = new net.ibizsys.pscore.srv.config.entity.PSSubSysSF();
            PSDEDataCtrl.convertEntity2(psSubSysSF2, (IEntity)psSubSysSF);
            psSubSysSFService.save(psSubSysSF);
        }
        cond.Reset();
        cond.setParamValue("PSSUBSYSID", (Object)psSubSys2.getPSSUBSYSID());
        IDEDataCtrl psSubAppDataCtrl = this.getDAModelStorage().FindDEDataCtrl("DE1960", "SYSTEM", null);
        Vector<SA.SRFDA.PS.Data.PSSubApp> psSubAppList = new Vector<SA.SRFDA.PS.Data.PSSubApp>();
        callResult = psSubAppDataCtrl.Select(cond, psSubAppList, SA.SRFDA.PS.Data.PSSubApp.class.getName());
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b50\u7cfb\u7edf\u5e94\u7528\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        IDEDataCtrl psSubAppViewDataCtrl = this.getDAModelStorage().FindDEDataCtrl("DE1963", "SYSTEM", null);
        for (SA.SRFDA.PS.Data.PSSubApp psSubApp2 : psSubAppList) {
            PSSubApp psSubApp = new PSSubApp();
            PSDEDataCtrl.convertEntity2(psSubApp2, (IEntity)psSubApp);
            psSubAppService.save(psSubApp);
            cond.Reset();
            cond.setParamValue("PSSUBAPPID", (Object)psSubApp2.getPSSUBAPPID());
            Vector<PSSubAppView> psSubAppViewList = new Vector<PSSubAppView>();
            callResult = psSubAppViewDataCtrl.Select(cond, psSubAppViewList, PSSubAppView.class.getName());
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b50\u7cfb\u7edf\u5e94\u7528\u89c6\u56fe\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            for (PSSubAppView psSubAppView2 : psSubAppViewList) {
                net.ibizsys.pscore.srv.config.entity.PSSubAppView psSubAppView = new net.ibizsys.pscore.srv.config.entity.PSSubAppView();
                PSDEDataCtrl.convertEntity2(psSubAppView2, (IEntity)psSubAppView);
                psSubAppViewService.save(psSubAppView);
            }
        }
        psSubSys.setVersion(Integer.valueOf(psSubSys2.getVERSION()));
        psSubSysService.update(psSubSys);
        sBuilderEx.append("\u5b50\u7cfb\u7edf\u5df2\u66f4\u65b0\u4e3a\u6700\u65b0\u3002");
        return sBuilderEx.toString();
    }
}

