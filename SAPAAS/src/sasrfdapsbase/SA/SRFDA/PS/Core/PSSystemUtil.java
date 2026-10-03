/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.GlobalHelperEx
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  com.google.common.base.CaseFormat
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.appdesign.entity.PSAppDEView
 *  net.ibizsys.pscore.srv.appdesign.entity.PSAppModule
 *  net.ibizsys.pscore.srv.appdesign.service.PSAppDEViewService
 *  net.ibizsys.pscore.srv.appdesign.service.PSAppModuleService
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSModule
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntityObject;
import SA.SRFDA.PS.Core.App.IPSAppPDTView;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.IPSApplicationObject;
import SA.SRFDA.PS.Core.App.PSApplicationException;
import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlObject;
import SA.SRFDA.PS.Core.Control.IPSEditor;
import SA.SRFDA.PS.Core.Control.IPSEditorContainer;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskWork;
import SA.SRFDA.PS.Core.DevStudio.PSBKTaskWorkHelper;
import SA.SRFDA.PS.Core.IPSJITSystem;
import SA.SRFDA.PS.Core.IPSModelHelper;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.IPSObjectRuntime;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.IPSSystemRuntime;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSObjectFactory;
import SA.SRFDA.PS.Core.Res.IPSSysPDTView;
import SA.SRFDA.Web.Utility.GlobalHelperEx;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import com.google.common.base.CaseFormat;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppDEView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppModule;
import net.ibizsys.pscore.srv.appdesign.service.PSAppDEViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppModuleService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSSystemUtil {
    private static final Log log = LogFactory.getLog(PSSystemUtil.class);

    public static IPSApplication loadPSApplication(IPSSystem iPSSystem, String strPSSysAppId, int nAppLoadLevel) throws Exception {
        return PSSystemUtil.loadPSApplication(iPSSystem, strPSSysAppId, nAppLoadLevel, false);
    }

    public static IPSApplication loadPSApplication(IPSSystem iPSSystem, String strPSSysAppId, int nAppLoadLevel, boolean bJITMode) throws Exception {
        IPSModelHelper iPSModelHelper = PSSystemUtil.getPSModelHelper(iPSSystem);
        boolean bContinue = true;
        while (bContinue) {
            bContinue = false;
            IPSApplication iPSApplication = null;
            if (bJITMode) {
                ((IPSJITSystem)iPSSystem).resetPSJITApplication(strPSSysAppId);
                iPSApplication = ((IPSJITSystem)iPSSystem).getPSJITApplication(strPSSysAppId);
            } else {
                iPSApplication = iPSSystem.getPSApplication(strPSSysAppId);
                if (iPSApplication.getLoadedLevel() >= nAppLoadLevel) {
                    log.debug((Object)StringHelper.Format((String)"\u524d\u7aef\u5e94\u7528[%1$s]\u5df2\u7ecf\u52a0\u8f7d\uff0c\u5ffd\u7565\u52a0\u8f7d", (Object)iPSApplication.getFullModelName()));
                    return iPSApplication;
                }
                if (iPSApplication.getLoadedLevel() > IPSSystem.LOADLEVEL_NONE) {
                    iPSSystem.resetPSApplication(strPSSysAppId);
                    iPSApplication = iPSSystem.getPSApplication(strPSSysAppId);
                }
            }
            iPSModelHelper.startLoadPSSysApp(strPSSysAppId, nAppLoadLevel);
            String strPSSysAppName = strPSSysAppId;
            boolean bAutoAddAppDEView = false;
            try {
                strPSSysAppName = iPSApplication.getName();
                IPSSystemRuntime iPSSystemRuntime = (IPSSystemRuntime)((Object)iPSSystem);
                if (iPSSystemRuntime.getDynaInstMode() == 0) {
                    bAutoAddAppDEView = iPSApplication.isAutoAddAppDEView();
                }
                iPSApplication.load(nAppLoadLevel);
                if (bAutoAddAppDEView) {
                    Iterator<IPSAppView> psAppViews = iPSApplication.getAllPSAppViews();
                    ArrayList<IPSAppView> refPSAppViewList = new ArrayList<IPSAppView>();
                    while (psAppViews.hasNext()) {
                        refPSAppViewList.clear();
                        IPSAppView iPSAppView = psAppViews.next();
                        iPSAppView.fillRelatedPSAppViews(refPSAppViewList);
                    }
                }
                iPSModelHelper.stopLoadPSSysApp();
                return iPSApplication;
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u524d\u7aef\u5e94\u7528[%1$s]\u52a0\u8f7d\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)strPSSysAppName, (Object)ex.getMessage()));
                iPSModelHelper.stopLoadPSSysApp();
                try {
                    iPSSystem.resetPSApplication(strPSSysAppId);
                }
                catch (Exception ex2) {
                    log.error((Object)ex2);
                }
                if (bAutoAddAppDEView) {
                    PSApplicationException psApplicationException2 = null;
                    Throwable nextException = ex;
                    while (true) {
                        if (!(nextException instanceof PSApplicationException)) {
                            if (nextException.getCause() == null) break;
                            nextException = nextException.getCause();
                            continue;
                        }
                        psApplicationException2 = (PSApplicationException)nextException;
                        if (psApplicationException2 == null) continue;
                        final PSApplicationException psApplicationException = psApplicationException2;
                        if (psApplicationException.getErrorCode() == 40012 && psApplicationException.getArg2() != null) {
                            String strLastPSSystemId = PSCoreSysServiceBase.getCurrentPSSystemId();
                            PSCoreSysServiceBase.setCurrentPSSystemId((String)iPSSystem.getId());
                            try {
                                PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

                                    @Override
                                    public void execute(Object obj) throws Exception {
                                        PSSystemUtil.onAddPSDEViewToApp(psApplicationException.getPSApplication(), (String)psApplicationException.getArg2());
                                    }
                                });
                                PSCoreSysServiceBase.setCurrentPSSystemId((String)strLastPSSystemId);
                                bContinue = true;
                                break;
                            }
                            catch (Exception ex2) {
                                PSCoreSysServiceBase.setCurrentPSSystemId((String)strLastPSSystemId);
                                log.error((Object)StringHelper.Format((String)"\u81ea\u52a8\u6dfb\u52a0\u5b9e\u4f53\u89c6\u56fe\u5230\u5e94\u7528\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)ex2.getMessage()));
                                throw ex;
                            }
                        }
                        if (nextException.getCause() == null) break;
                        nextException = nextException.getCause();
                    }
                }
                if (bContinue) continue;
                throw ex;
            }
        }
        return null;
    }

    protected static void onAddPSDEViewToApp(IPSApplication iPSApplication, String strPSDEViewId) throws Exception {
        SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory((String)iPSApplication.getPSSysModelInstId());
        PSDEViewBaseService psDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)sessionFactory);
        PSDEViewBase psDEViewBase = new PSDEViewBase();
        psDEViewBase.setPSDEViewBaseId(strPSDEViewId);
        psDEViewBaseService.get(psDEViewBase);
        PSModule psModule = psDEViewBase.getPSDE().getPSModule();
        PSAppModuleService psAppModuleService = (PSAppModuleService)ServiceGlobal.getService(PSAppModuleService.class, (SessionFactory)sessionFactory);
        PSAppModule psAppModule = new PSAppModule();
        psAppModule.setPSSysAppId(iPSApplication.getId());
        psAppModule.setPSModuleId(psModule.getPSModuleId());
        if (!psAppModuleService.select(psAppModule, true)) {
            psAppModule.reset();
            psAppModule.setPSSysAppId(iPSApplication.getId());
            psAppModule.setCodeName(psModule.getCodeName());
            if (!psAppModuleService.select(psAppModule, true)) {
                psAppModule.reset();
                psAppModule.setPSSysAppId(iPSApplication.getId());
                psAppModule.setDefaultFlag(Integer.valueOf(1));
                if (!psAppModuleService.select(psAppModule, true)) {
                    ((IPSSystemUtil)((Object)iPSApplication.getPSSystem())).getPSSysConsole().error(iPSApplication.getModelName(), StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u7cfb\u7edf\u6a21\u5757[%1$s]\u5bf9\u5e94\u7684\u5e94\u7528\u6a21\u5757\uff0c\u65e0\u6cd5\u81ea\u52a8\u6dfb\u52a0\u5b9e\u4f53\u89c6\u56fe", (Object)psModule.getPSModuleName(), (Object)iPSApplication.getName()));
                    throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u7cfb\u7edf\u6a21\u5757[%1$s]\u5bf9\u5e94\u7684\u5e94\u7528[%2$s]\u6a21\u5757\uff0c\u65e0\u6cd5\u81ea\u52a8\u6dfb\u52a0\u5b9e\u4f53\u89c6\u56fe", (Object)psModule.getPSModuleName(), (Object)iPSApplication.getName()));
                }
            }
        }
        PSAppDEViewService psAppDEViewService = (PSAppDEViewService)ServiceGlobal.getService(PSAppDEViewService.class, (SessionFactory)sessionFactory);
        PSAppDEView psAppDEView = new PSAppDEView();
        psAppDEView.setPSDEViewBaseId(psDEViewBase.getPSDEViewBaseId());
        psAppDEView.setPSDEViewBaseName(psDEViewBase.getPSDEViewBaseName());
        psAppDEView.setPSAppModuleId(psAppModule.getPSAppModuleId());
        psAppDEView.setPSAppModuleName(psAppModule.getPSAppModuleName());
        psAppDEView.setPSSysAppId(psAppModule.getPSSysAppId());
        psAppDEView.setPSSysAppName(psAppModule.getPSSysAppName());
        psAppDEView.setMemo("\u7cfb\u7edf\u81ea\u52a8\u6dfb\u52a0");
        psAppDEViewService.create(psAppDEView, false);
        ((IPSSystemUtil)((Object)iPSApplication.getPSSystem())).getPSSysConsole().warn(iPSApplication.getModelName(), StringHelper.Format((String)"\u81ea\u52a8\u6dfb\u52a0\u5b9e\u4f53\u89c6\u56fe[%1$s]\u5230\u5e94\u7528\u6a21\u5757[%2$s]", (Object)psDEViewBase.getPSDEViewBaseName(), (Object)psAppModule.getPSAppModuleName()));
    }

    protected static IPSModelHelper getPSModelHelper(IPSObject iPSObject) throws Exception {
        ISRFDAGlobalHelper iDAGlobalHelper = null;
        iDAGlobalHelper = iPSObject instanceof IPSObjectRuntime ? ((IPSObjectRuntime)((Object)iPSObject)).getDAGlobalHelper() : GlobalHelperEx.getInstance();
        return PSObjectFactory.getPSModelHelper(iDAGlobalHelper, iPSObject.getPSSysModelInstId());
    }

    public static Iterator<IPSAppView> getPSAppDEViews(IPSSystem iPSSystem, String strPSDEViewBaseId) throws Exception {
        ArrayList<IPSAppView> psAppViewList = new ArrayList<IPSAppView>();
        Iterator<IPSApplication> psApplications = iPSSystem.getAllPSApps();
        if (psApplications != null) {
            while (psApplications.hasNext()) {
                IPSApplication iPSApplication = psApplications.next();
                IPSAppView iPSAppView = iPSApplication.getPSAppView(KeyValueHelper.genUniqueId((String)iPSApplication.getId(), (String)strPSDEViewBaseId), true);
                if (iPSAppView == null) continue;
                psAppViewList.add(iPSAppView);
            }
        }
        if (psAppViewList.size() > 0) {
            return psAppViewList.iterator();
        }
        return null;
    }

    public static IPSApplication getRefPSApplication(Object objRef, boolean bTryMode) throws Exception {
        if (objRef == null) {
            throw new Exception("\u4f20\u5165\u5bf9\u8c61\u65e0\u6548");
        }
        if (objRef instanceof IPSApplication) {
            return (IPSApplication)objRef;
        }
        if (objRef instanceof IPSApplicationObject) {
            return ((IPSApplicationObject)objRef).getPSApplication();
        }
        if (objRef instanceof IPSAppDataEntityObject && ((IPSAppDataEntityObject)objRef).getPSAppDataEntity() != null) {
            return ((IPSAppDataEntityObject)objRef).getPSAppDataEntity().getPSApplication();
        }
        IPSAppView iPSAppView = PSSystemUtil.getRefPSAppView(objRef, true);
        if (iPSAppView != null) {
            return iPSAppView.getPSApplication();
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u4ece\u5bf9\u8c61[%1$s]\u83b7\u53d6\u5e94\u7528\u7a0b\u5e8f\u5bf9\u8c61", (Object)objRef));
    }

    public static IPSControlContainer getRefPSControlContainer(Object objRef, boolean bTryMode) throws Exception {
        if (objRef == null) {
            throw new Exception("\u4f20\u5165\u5bf9\u8c61\u65e0\u6548");
        }
        if (objRef instanceof IPSControlContainer) {
            return (IPSControlContainer)objRef;
        }
        if (objRef instanceof IPSEditor) {
            return ((IPSEditor)objRef).getPSEditorContainer().getPSControlContainer();
        }
        if (objRef instanceof IPSEditorContainer) {
            return ((IPSEditorContainer)objRef).getPSControlContainer();
        }
        IPSControl iPSControl = PSSystemUtil.getRefPSControl(objRef, true);
        if (iPSControl != null) {
            if (iPSControl instanceof IPSControlContainer) {
                return (IPSControlContainer)((Object)iPSControl);
            }
            return iPSControl.getPSControlContainer();
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u4ece\u5bf9\u8c61[%1$s]\u83b7\u53d6\u90e8\u4ef6\u5bb9\u5668\u5bf9\u8c61", (Object)objRef));
    }

    public static IPSAppView getRefPSAppView(Object objRef, boolean bTryMode) throws Exception {
        if (objRef == null) {
            throw new Exception("\u4f20\u5165\u5bf9\u8c61\u65e0\u6548");
        }
        if (objRef instanceof IPSAppView) {
            return (IPSAppView)objRef;
        }
        IPSControl iPSControl = PSSystemUtil.getRefPSControl(objRef, true);
        if (iPSControl != null) {
            return iPSControl.getPSAppView();
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u4ece\u5bf9\u8c61[%1$s]\u83b7\u53d6\u5e94\u7528\u89c6\u56fe\u5bf9\u8c61", (Object)objRef));
    }

    public static IPSControl getRefPSControl(Object objRef, boolean bTryMode) throws Exception {
        if (objRef == null) {
            throw new Exception("\u4f20\u5165\u5bf9\u8c61\u65e0\u6548");
        }
        if (objRef instanceof IPSControl) {
            return (IPSControl)objRef;
        }
        if (objRef instanceof IPSControlObject) {
            return ((IPSControlObject)objRef).getOwnedPSControl();
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u4ece\u5bf9\u8c61[%1$s]\u83b7\u53d6\u754c\u9762\u90e8\u4ef6\u5bf9\u8c61", (Object)objRef));
    }

    public static IPSAppView getPSAppView(IPSApplication iPSApplication, IPSSysPDTView iPSSysPDTView, boolean bTryMode) throws Exception {
        String strPSAppPDTViewId = Helper.GenUniqueId((String)iPSApplication.getId(), (String)iPSSysPDTView.getId());
        IPSAppPDTView iPSAppPDTView = iPSApplication.getPSAppPDTView(strPSAppPDTViewId, true);
        if (iPSAppPDTView != null && iPSAppPDTView.getPSAppView() != null) {
            return iPSAppPDTView.getPSAppView();
        }
        String strPSDEViewBaseId = iPSSysPDTView.getPSDEViewBaseId();
        if (!StringHelper.IsNullOrEmpty((String)strPSDEViewBaseId)) {
            return iPSApplication.getPSAppViewByDEViewId(strPSDEViewBaseId, bTryMode);
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u4ece\u5e94\u7528[%1$s]\u4e2d\u83b7\u53d6\u7cfb\u7edf\u9884\u7f6e\u89c6\u56fe[%2$s]\u76f8\u5173\u8054\u7684\u5e94\u7528\u89c6\u56fe", (Object)iPSApplication.getName(), (Object)iPSSysPDTView.getName()));
    }

    public static IPSSystem getRefPSSystem(Object objRef, boolean bTryMode) throws Exception {
        if (objRef == null) {
            throw new Exception("\u4f20\u5165\u5bf9\u8c61\u65e0\u6548");
        }
        if (objRef instanceof IPSSystem) {
            return (IPSSystem)objRef;
        }
        if (objRef instanceof IPSSystemObject) {
            return ((IPSSystemObject)objRef).getPSSystem();
        }
        if (objRef instanceof IPSDataEntityObject) {
            return ((IPSDataEntityObject)objRef).getPSDataEntity().getPSSystem();
        }
        IPSApplication iPSApplication = PSSystemUtil.getRefPSApplication(objRef, true);
        if (iPSApplication != null) {
            return iPSApplication.getPSSystem();
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u4ece\u5bf9\u8c61[%1$s]\u83b7\u53d6\u7cfb\u7edf\u5bf9\u8c61", (Object)objRef));
    }

    public static IPSDataEntity getRefPSDataEntity(Object objRef, boolean bTryMode) throws Exception {
        IPSControl iPSControl;
        if (objRef == null) {
            throw new Exception("\u4f20\u5165\u5bf9\u8c61\u65e0\u6548");
        }
        if (objRef instanceof IPSDataEntity) {
            return (IPSDataEntity)objRef;
        }
        if (objRef instanceof IPSDataEntityObject) {
            return ((IPSDataEntityObject)objRef).getPSDataEntity();
        }
        if (objRef instanceof IPSAppDataEntityObject) {
            return ((IPSAppDataEntityObject)objRef).getPSAppDataEntity().getPSDataEntity();
        }
        IPSAppView iPSAppView = PSSystemUtil.getRefPSAppView(objRef, true);
        if (iPSAppView != null) {
            if (iPSAppView.getPSAppDataEntity() != null) {
                return iPSAppView.getPSAppDataEntity().getPSDataEntity();
            }
            if (iPSAppView instanceof IPSAppDEView) {
                return ((IPSAppDEView)iPSAppView).getPSDataEntity();
            }
        }
        if ((iPSControl = PSSystemUtil.getRefPSControl(objRef, true)) != null) {
            if (iPSControl.getPSAppDataEntity() != null) {
                return iPSControl.getPSAppDataEntity().getPSDataEntity();
            }
            if (iPSControl.getPSDataEntity() != null) {
                return iPSControl.getPSDataEntity();
            }
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u4ece\u5bf9\u8c61[%1$s]\u83b7\u53d6\u5b9e\u4f53\u5bf9\u8c61", (Object)objRef));
    }

    public static String getPSModelCodeName(String strCodeNameMode, String strPrefix, String strCodeName, String strSuffix) {
        if (StringHelper.IsNullOrEmpty((String)strCodeNameMode)) {
            strCodeNameMode = "UPPER_CAMEL";
        }
        StringBuilderEx sb = new StringBuilderEx();
        if (!StringHelper.IsNullOrEmpty((String)strPrefix)) {
            if (strCodeNameMode.equals("LOWER_UNDERSCORE")) {
                sb.append(CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, strPrefix));
                sb.append("_");
            } else {
                sb.append(strPrefix);
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)strCodeName)) {
            if (strCodeNameMode.equals("LOWER_UNDERSCORE")) {
                strCodeName = strCodeName.toLowerCase();
                sb.append(strCodeName);
            } else {
                sb.append(strCodeName);
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)strSuffix)) {
            if (strCodeNameMode.equals("LOWER_UNDERSCORE")) {
                sb.append("_");
                sb.append(CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, strSuffix));
            } else {
                sb.append(strSuffix);
            }
        }
        return sb.toString();
    }
}
