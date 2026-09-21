/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.appdesign.entity.PSAppView
 *  net.ibizsys.pscore.srv.appdesign.service.PSAppViewServiceProxy
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysAppBase
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.App.CodeList.IPSAppCodeList;
import SA.SRFDA.PS.Core.App.Control.IPSAppCounter;
import SA.SRFDA.PS.Core.App.Control.IPSControlContainerView;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDELogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethodDTO;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSAppLan;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.Msg.IPSAppMsgTempl;
import SA.SRFDA.PS.Core.App.Res.IPSAppEditorStyleRef;
import SA.SRFDA.PS.Core.App.Res.IPSAppPFPluginRef;
import SA.SRFDA.PS.Core.App.Res.IPSAppSubViewTypeRef;
import SA.SRFDA.PS.Core.App.Util.IPSAppUtil;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewMsg;
import SA.SRFDA.PS.Core.App.View.IPSAppViewMsgGroup;
import SA.SRFDA.PS.Core.App.WF.IPSAppWF;
import SA.SRFDA.PS.Core.App.WF.IPSAppWFVer;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.Panel.IPSLayoutPanel;
import SA.SRFDA.PS.Core.Deploy.IPSSysRunSession;
import SA.SRFDA.PS.Core.DevStudio.PSSysDevBKTaskImplBase;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSModelObjectLogger;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemRuntime;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.JIT.Web.PSJITWebContext;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFAppDataEntityTempl;
import SA.SRFDA.PS.Core.PF.IPSPFAppObjectTempl;
import SA.SRFDA.PS.Core.PF.IPSPFAppTempl;
import SA.SRFDA.PS.Core.PF.IPSPFAppWFTempl;
import SA.SRFDA.PS.Core.PF.IPSPFAppWFVerTempl;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlTempl;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PF.IPSPFStyle2;
import SA.SRFDA.PS.Core.PF.IPSPFViewTempl;
import SA.SRFDA.PS.Core.PSModelObjectLoggerImpl;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.Pub.IPSPFAppCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPFAppDataEntityCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPFAppObjectCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPFAppWFCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPFAppWFVerCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlCodePublisher2;
import SA.SRFDA.PS.Core.Pub.IPSPFViewCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSSysPubRuntime;
import SA.SRFDA.PS.Core.Pub.PSPublishContextImpl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSysAppDataCtrl;
import SA.SRFDA.PS.Data.PSAppView;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewServiceProxy;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysAppBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class SysPFPubPSSysDevBKTaskImpl
extends PSSysDevBKTaskImplBase {
    private static final Log log = LogFactory.getLog(SysPFPubPSSysDevBKTaskImpl.class);

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected String onRun() throws Exception {
        PSSysAppService psSysAppService = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        PSSysApp psSysApp = new PSSysApp();
        psSysApp.setPSSysAppId(this.psSysDevBKTask.getTASKPARAM());
        psSysAppService.get((IEntity)psSysApp);
        return this.generateCode(psSysApp);
    }

    protected String generateCode(PSSysApp psSysApp) throws Exception {
        IPSModelObjectLogger lastPSModelObjectLogger = null;
        IPSSystemRuntime iPSSystemRuntime = null;
        try {
            IPSApplication iPSApplication = this.getPSApplication(psSysApp);
            IPSSystem iPSSystem = iPSApplication.getPSSystem();
            iPSSystemRuntime = (IPSSystemRuntime)((Object)iPSSystem);
            lastPSModelObjectLogger = iPSSystemRuntime.getPSModelObjectLogger();
            String strLoggerName = StringHelper.format((String)"%1$s[%2$s]", (Object)psSysApp.getPSPFStyleName(), (Object)psSysApp.getPSSysAppName());
            PSModelObjectLoggerImpl psModelObjectLoggerImpl = new PSModelObjectLoggerImpl(this.getRootPSSysDevBKTask(), iPSSystem.getPSDevCenterDomain(), strLoggerName, -1);
            iPSSystemRuntime.setPSModelObjectLogger(psModelObjectLoggerImpl);
            StringBuilderEx sBuilderEx = new StringBuilderEx();
            sBuilderEx.append(this.onGenerateCode(psSysApp));
            sBuilderEx.append(this.onGenerateCode2(psSysApp));
            sBuilderEx.append(this.onGenerateCode3(psSysApp));
            this.generateUserCode(psSysApp);
            if (this.getPSSysPubRuntime() != null) {
                this.getPSSysPubRuntime().endPFPubCode(iPSApplication);
            }
            iPSSystemRuntime.setPSModelObjectLogger(lastPSModelObjectLogger);
            return sBuilderEx.toString();
        }
        catch (Exception ex) {
            if (iPSSystemRuntime != null) {
                iPSSystemRuntime.setPSModelObjectLogger(lastPSModelObjectLogger);
            }
            throw ex;
        }
    }

    protected String onGenerateCode(PSSysApp psSysApp) throws Exception {
        IPSPFPubCode iPSPFPubCode;
        IPSApplication iPSApplication = this.getPSApplication(psSysApp);
        Iterator<IPSPFPubCode> psPFPubCodes = iPSApplication.getPSPFStyle().getPSPFPubCodes("VIEW", true);
        if (psPFPubCodes != null) {
            while (psPFPubCodes.hasNext()) {
                iPSPFPubCode = psPFPubCodes.next();
                if (this.getPSSysPubRuntime() == null || iPSPFPubCode.getPSPFCodeFolder() == null) continue;
                this.getPSSysPubRuntime().registerPFPubFolder(iPSApplication, iPSPFPubCode.getPSPFCodeFolder().getFolderName());
            }
        }
        if ((psPFPubCodes = iPSApplication.getPSPFStyle().getPSPFPubCodes("VIEWCTRL", true)) != null) {
            while (psPFPubCodes.hasNext()) {
                iPSPFPubCode = psPFPubCodes.next();
                if (this.getPSSysPubRuntime() == null || iPSPFPubCode.getPSPFCodeFolder() == null) continue;
                this.getPSSysPubRuntime().registerPFPubFolder(iPSApplication, iPSPFPubCode.getPSPFCodeFolder().getFolderName());
            }
        }
        String strPSDevSlnSysId = iPSApplication.getPSSystem().getPSDevSlnSysId();
        String strPSSysModelInstId = this.getPSSysModelInstId();
        StringBuilderEx sBuilderEx = new StringBuilderEx();
        SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId());
        PSAppViewServiceProxy psAppViewServiceProxy = (PSAppViewServiceProxy)ServiceGlobal.getService(PSAppViewServiceProxy.class, (SessionFactory)sessionFactory);
        ArrayList psAppViewList2 = psAppViewServiceProxy.selectByPSSysApp((PSSysAppBase)psSysApp);
        Vector<PSAppView> psAppViewList = new Vector<PSAppView>();
        for (net.ibizsys.pscore.srv.appdesign.entity.PSAppView psAppView : psAppViewList2) {
            if (DataObject.getIntegerValue((Object)psAppView.getDynaModelFlag(), (Integer)0) != 0) continue;
            PSAppView psAppView2 = new PSAppView();
            PSDEDataCtrl.convertEntity((IEntity)psAppView, psAppView2);
            psAppView2.setParamValue("PSDEVSLNSYSID", strPSDevSlnSysId);
            psAppView2.setParamValue("PSSYSMODELINSTID", strPSSysModelInstId);
            psAppViewList.add(psAppView2);
        }
        Vector<IPSControlContainerView> psControlContainerViewList = new Vector<IPSControlContainerView>();
        Iterator<IPSControlContainerView> psControlContainerViews = iPSApplication.getPSControlContainerViews();
        if (psControlContainerViews != null) {
            while (psControlContainerViews.hasNext()) {
                psControlContainerViewList.add(psControlContainerViews.next());
            }
        }
        try {
            TaskManager taskManager = new TaskManager(iPSApplication, psAppViewList, psControlContainerViewList);
            long nBeginTime = System.currentTimeMillis();
            taskManager.start();
            long nTime = System.currentTimeMillis() - nBeginTime;
            log.debug((Object)StringHelper.format((String)"\u53d1\u5e03\u89c6\u56fe\u4ee3\u7801\u6570\u91cf[%1$s]\uff0c\u8017\u65f6[%2$s]ms\uff0c\u9519\u8bef\u6570\u91cf[%3$s]", (Object)taskManager.getPubCount(), (Object)nTime, (Object)taskManager.getErrorCount()));
            sBuilderEx.append("[v%1$s]\u53d1\u5e03\u89c6\u56fe\u4ee3\u7801\u6570\u91cf[%2$s]\uff0c\u8017\u65f6[%3$s]ms\uff0c\u9519\u8bef\u6570\u91cf[%4$s]", (Object)iPSApplication.getPSSystem().getVersion(), (Object)taskManager.getPubCount(), (Object)nTime, (Object)taskManager.getErrorCount());
            if (taskManager.getErrorCount() > 0) {
                sBuilderEx.append("\r\n%1$s", (Object)taskManager.getErrorInfo());
                throw new Exception(StringHelper.format((String)"\u53d1\u5e03\u5e94\u7528\u89c6\u56fe\u4ee3\u7801\u53d1\u751f\u9519\u8bef\u3002\r\n%1$s", (Object)taskManager.getErrorInfo()));
            }
            SessionFactoryManager.releaseRef((boolean)true);
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u4ea7\u751f\u89c6\u56fe\u4ee3\u7801\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            SessionFactoryManager.releaseRef((boolean)false);
            throw ex;
        }
        return sBuilderEx.toString();
    }

    protected String onGenerateCode2(PSSysApp psSysApp) throws Exception {
        IPSSysPubRuntime iPSSysPubRuntime;
        StringBuilderEx sBuilderEx = new StringBuilderEx();
        IPSApplication iPSApplication = this.getPSApplication(psSysApp);
        Iterator<IPSPFPubCode> psPFPubCodes = iPSApplication.getPSPFStyle().getPSPFPubCodes("APP", true);
        if (psPFPubCodes != null) {
            while (psPFPubCodes.hasNext()) {
                IPSPFPubCode iPSPFPubCode = psPFPubCodes.next();
                if (this.getPSSysPubRuntime() == null || iPSPFPubCode.getPSPFCodeFolder() == null) continue;
                this.getPSSysPubRuntime().registerPFPubFolder(iPSApplication, iPSPFPubCode.getPSPFCodeFolder().getFolderName());
            }
        }
        IPSPFStyle iPSPFStyle = iPSApplication.getPSPFStyle();
        PSPublishContextImpl psPublishContextImpl = new PSPublishContextImpl(this.getDAGlobalHelper(), null);
        psPublishContextImpl.setPSSysModelInstId(this.getPSSysModelInstId());
        psPublishContextImpl.setPSLogItemList(this.getPSLogItemList());
        HashMap<String, Object> params = new HashMap<String, Object>();
        IPSSysRunSession iPSSysRunSession = this.getPSSysRunSession();
        if (iPSSysRunSession != null) {
            psPublishContextImpl.setEnableVC(iPSSysRunSession.isEnableVC());
            psPublishContextImpl.setRebuildMode(iPSSysRunSession.isRebuildMode());
            psPublishContextImpl.setRebuildModeEx(iPSSysRunSession.getRebuildModeEx());
            if (iPSSysRunSession.getPSSysSFPub() != null) {
                params.put("pub", iPSSysRunSession.getPSSysSFPub());
            }
            params.put("sysrun", iPSSysRunSession);
        }
        if ((iPSSysPubRuntime = this.getPSSysPubRuntime()) != null) {
            params.put("syspub", iPSSysPubRuntime);
        }
        if (params.size() > 0) {
            psPublishContextImpl.setPubParams(params);
        }
        Iterator<IPSPFAppTempl> psPFAppTempls = iPSPFStyle.getPSPFAppTempls(iPSApplication);
        while (psPFAppTempls.hasNext()) {
            IPSPFAppTempl iPSPFAppTempl = psPFAppTempls.next();
            IPSPFAppCodePublisher iPSPFAppCodePublisher = iPSPFAppTempl.getPSPFAppCodePublisher();
            iPSPFAppCodePublisher.generateCode(psPublishContextImpl, iPSApplication);
            iPSPFAppCodePublisher.close();
        }
        return sBuilderEx.toString();
    }

    protected String onGenerateCode3(PSSysApp psSysApp) throws Exception {
        Iterator<IPSAppSubViewTypeRef> psAppSubViewTypeRefs;
        Iterator<IPSAppEditorStyleRef> psAppEditorStyleRefs;
        Iterator<IPSAppPFPluginRef> psAppPFPluginRefs;
        Iterator<? extends IPSAppViewMsgGroup> psAppViewMsgGroups;
        Iterator<? extends IPSAppViewMsg> psAppViewMsgs;
        Iterator<IPSAppMsgTempl> psAppMsgTempls;
        Iterator<IPSAppLan> psAppLans;
        Iterator<IPSAppUtil> psAppUtils;
        Iterator<IPSAppCodeList> psAppCodeLists;
        Iterator<IPSAppCounter> psAppCounters;
        Iterator<IPSAppWFVer> psAppWFVers;
        Iterator<IPSAppWF> psAppWFs;
        Iterator<IPSAppDataEntity> psAppDataEntities;
        IPSSysPubRuntime iPSSysPubRuntime;
        StringBuilderEx sBuilderEx = new StringBuilderEx();
        IPSApplication iPSApplication = this.getPSApplication(psSysApp);
        if (iPSApplication.getPSPFStyle().getPFEngineVer() < 20) {
            return "";
        }
        IPSPFStyle2 iPSPFStyle = (IPSPFStyle2)iPSApplication.getPSPFStyle();
        Iterator<IPSPFPubCode> psPFPubCodes = iPSApplication.getPSPFStyle().getPSPFPubCodes("DATAENTITY", true);
        if (psPFPubCodes != null) {
            while (psPFPubCodes.hasNext()) {
                IPSPFPubCode iPSPFPubCode = psPFPubCodes.next();
                if (this.getPSSysPubRuntime() == null || iPSPFPubCode.getPSPFCodeFolder() == null) continue;
                this.getPSSysPubRuntime().registerPFPubFolder(iPSApplication, iPSPFPubCode.getPSPFCodeFolder().getFolderName());
            }
        }
        PSPublishContextImpl psPublishContextImpl = new PSPublishContextImpl(this.getDAGlobalHelper(), null);
        psPublishContextImpl.setPSSysModelInstId(this.getPSSysModelInstId());
        psPublishContextImpl.setPSLogItemList(this.getPSLogItemList());
        HashMap<String, Object> params = new HashMap<String, Object>();
        IPSSysRunSession iPSSysRunSession = this.getPSSysRunSession();
        if (iPSSysRunSession != null) {
            psPublishContextImpl.setEnableVC(iPSSysRunSession.isEnableVC());
            psPublishContextImpl.setRebuildMode(iPSSysRunSession.isRebuildMode());
            psPublishContextImpl.setRebuildModeEx(iPSSysRunSession.getRebuildModeEx());
            if (iPSSysRunSession.getPSSysSFPub() != null) {
                params.put("pub", iPSSysRunSession.getPSSysSFPub());
            }
            params.put("sysrun", iPSSysRunSession);
        }
        if ((iPSSysPubRuntime = this.getPSSysPubRuntime()) != null) {
            params.put("syspub", iPSSysPubRuntime);
        }
        if (params.size() > 0) {
            psPublishContextImpl.setPubParams(params);
        }
        if ((psAppDataEntities = iPSApplication.getAllPSAppDataEntities()) != null) {
            while (psAppDataEntities.hasNext()) {
                Iterator<IPSAppDEMethodDTO> psAppDEMethodDTOs;
                Iterator<IPSAppDEUILogic> psAppDEUILogics;
                Iterator<IPSAppDELogic> psAppDELogics;
                IPSAppDataEntity iPSAppDataEntity = psAppDataEntities.next();
                Iterator<IPSPFAppDataEntityTempl> psPFAppTempls = iPSPFStyle.getPSPFAppDataEntityTempls(iPSAppDataEntity);
                if (psPFAppTempls != null) {
                    while (psPFAppTempls.hasNext()) {
                        IPSPFAppDataEntityTempl iPSPFAppTempl = psPFAppTempls.next();
                        IPSPFAppDataEntityCodePublisher iPSPFAppCodePublisher = iPSPFAppTempl.getPSPFAppDataEntityCodePublisher();
                        iPSPFAppCodePublisher.generateCode(psPublishContextImpl, iPSAppDataEntity);
                        iPSPFAppCodePublisher.close();
                    }
                }
                if ((psAppDELogics = iPSAppDataEntity.getAllPSAppDELogics()) != null) {
                    while (psAppDELogics.hasNext()) {
                        IPSAppDELogic iPSAppDELogic = psAppDELogics.next();
                        Iterator<IPSPFAppObjectTempl> psPFAppObjectTempls = iPSPFStyle.getPSPFAppObjectTempls("PSAPPDELOGIC");
                        if (psPFAppObjectTempls == null) continue;
                        while (psPFAppObjectTempls.hasNext()) {
                            IPSPFAppObjectTempl iPSPFAppObjectTempl = psPFAppObjectTempls.next();
                            IPSPFAppObjectCodePublisher iPSPFAppObjectCodePublisher = iPSPFAppObjectTempl.getPSPFCodePublisher();
                            iPSPFAppObjectCodePublisher.generateCode(psPublishContextImpl, iPSAppDELogic);
                            iPSPFAppObjectCodePublisher.close();
                        }
                    }
                }
                if ((psAppDEUILogics = iPSAppDataEntity.getAllPSAppDEUILogics()) != null) {
                    while (psAppDEUILogics.hasNext()) {
                        IPSAppDEUILogic iPSAppDEUILogic = psAppDEUILogics.next();
                        Iterator<IPSPFAppObjectTempl> psPFAppObjectTempls = iPSPFStyle.getPSPFAppObjectTempls("PSAPPDEUILOGIC");
                        if (psPFAppObjectTempls == null) continue;
                        while (psPFAppObjectTempls.hasNext()) {
                            IPSPFAppObjectTempl iPSPFAppObjectTempl = psPFAppObjectTempls.next();
                            IPSPFAppObjectCodePublisher iPSPFAppObjectCodePublisher = iPSPFAppObjectTempl.getPSPFCodePublisher();
                            iPSPFAppObjectCodePublisher.generateCode(psPublishContextImpl, iPSAppDEUILogic);
                            iPSPFAppObjectCodePublisher.close();
                        }
                    }
                }
                if ((psAppDEMethodDTOs = iPSAppDataEntity.getAllPSAppDEMethodDTOs()) == null) continue;
                while (psAppDEMethodDTOs.hasNext()) {
                    IPSAppDEMethodDTO iPSAppDEMethodDTO = psAppDEMethodDTOs.next();
                    Iterator<IPSPFAppObjectTempl> psPFAppObjectTempls = iPSPFStyle.getPSPFAppObjectTempls("PSAPPDEMETHODDTO");
                    if (psPFAppObjectTempls == null) continue;
                    while (psPFAppObjectTempls.hasNext()) {
                        IPSPFAppObjectTempl iPSPFAppObjectTempl = psPFAppObjectTempls.next();
                        IPSPFAppObjectCodePublisher iPSPFAppObjectCodePublisher = iPSPFAppObjectTempl.getPSPFCodePublisher();
                        iPSPFAppObjectCodePublisher.generateCode(psPublishContextImpl, iPSAppDEMethodDTO);
                        iPSPFAppObjectCodePublisher.close();
                    }
                }
            }
        }
        if ((psAppWFs = iPSApplication.getAllPSAppWFs()) != null) {
            while (psAppWFs.hasNext()) {
                IPSAppWF iPSAppWF = psAppWFs.next();
                Iterator<IPSPFAppWFTempl> psPFAppTempls = iPSPFStyle.getPSPFAppWFTempls(iPSAppWF);
                if (psPFAppTempls == null) continue;
                while (psPFAppTempls.hasNext()) {
                    IPSPFAppWFTempl iPSPFAppTempl = psPFAppTempls.next();
                    IPSPFAppWFCodePublisher iPSPFAppCodePublisher = iPSPFAppTempl.getPSPFAppWFCodePublisher();
                    iPSPFAppCodePublisher.generateCode(psPublishContextImpl, iPSAppWF);
                    iPSPFAppCodePublisher.close();
                }
            }
        }
        if ((psAppWFVers = iPSApplication.getAllPSAppWFVers()) != null) {
            while (psAppWFVers.hasNext()) {
                IPSAppWFVer iPSAppWFVer = psAppWFVers.next();
                Iterator<IPSPFAppWFVerTempl> psPFAppTempls = iPSPFStyle.getPSPFAppWFVerTempls(iPSAppWFVer);
                if (psPFAppTempls == null) continue;
                while (psPFAppTempls.hasNext()) {
                    IPSPFAppWFVerTempl iPSPFAppTempl = psPFAppTempls.next();
                    IPSPFAppWFVerCodePublisher iPSPFAppCodePublisher = iPSPFAppTempl.getPSPFAppWFVerCodePublisher();
                    iPSPFAppCodePublisher.generateCode(psPublishContextImpl, iPSAppWFVer);
                    iPSPFAppCodePublisher.close();
                }
            }
        }
        if ((psAppCounters = iPSApplication.getAllPSAppCounters()) != null) {
            while (psAppCounters.hasNext()) {
                IPSAppCounter iPSAppCounter = psAppCounters.next();
                Iterator<IPSPFAppObjectTempl> psPFAppTempls = iPSPFStyle.getPSPFAppObjectTempls("PSAPPCOUNTER");
                if (psPFAppTempls == null) continue;
                while (psPFAppTempls.hasNext()) {
                    IPSPFAppObjectTempl iPSPFAppTempl = psPFAppTempls.next();
                    IPSPFAppObjectCodePublisher iPSPFAppCodePublisher = iPSPFAppTempl.getPSPFCodePublisher();
                    iPSPFAppCodePublisher.generateCode(psPublishContextImpl, iPSAppCounter);
                    iPSPFAppCodePublisher.close();
                }
            }
        }
        if ((psAppCodeLists = iPSApplication.getAllPSAppCodeLists()) != null) {
            while (psAppCodeLists.hasNext()) {
                IPSAppCodeList iPSAppCodeList = psAppCodeLists.next();
                Iterator<IPSPFAppObjectTempl> psPFAppTempls = iPSPFStyle.getPSPFAppObjectTempls("PSAPPCODELIST");
                if (psPFAppTempls == null) continue;
                while (psPFAppTempls.hasNext()) {
                    IPSPFAppObjectTempl iPSPFAppTempl = psPFAppTempls.next();
                    IPSPFAppObjectCodePublisher iPSPFAppCodePublisher = iPSPFAppTempl.getPSPFCodePublisher();
                    iPSPFAppCodePublisher.generateCode(psPublishContextImpl, iPSAppCodeList);
                    iPSPFAppCodePublisher.close();
                }
            }
        }
        if ((psAppUtils = iPSApplication.getAllPSAppUtils()) != null) {
            while (psAppUtils.hasNext()) {
                IPSAppUtil iPSAppUtil = psAppUtils.next();
                Iterator<IPSPFAppObjectTempl> psPFAppTempls = iPSPFStyle.getPSPFAppObjectTempls("PSAPPUTIL");
                if (psPFAppTempls == null) continue;
                while (psPFAppTempls.hasNext()) {
                    IPSPFAppObjectTempl iPSPFAppTempl = psPFAppTempls.next();
                    IPSPFAppObjectCodePublisher iPSPFAppCodePublisher = iPSPFAppTempl.getPSPFCodePublisher();
                    iPSPFAppCodePublisher.generateCode(psPublishContextImpl, iPSAppUtil);
                    iPSPFAppCodePublisher.close();
                }
            }
        }
        if ((psAppLans = iPSApplication.getAllPSAppLans()) != null) {
            while (psAppLans.hasNext()) {
                IPSAppLan iPSAppLan = psAppLans.next();
                Iterator<IPSPFAppObjectTempl> psPFAppTempls = iPSPFStyle.getPSPFAppObjectTempls("PSAPPLAN");
                if (psPFAppTempls == null) continue;
                while (psPFAppTempls.hasNext()) {
                    IPSPFAppObjectTempl iPSPFAppTempl = psPFAppTempls.next();
                    IPSPFAppObjectCodePublisher iPSPFAppCodePublisher = iPSPFAppTempl.getPSPFCodePublisher();
                    iPSPFAppCodePublisher.generateCode(psPublishContextImpl, iPSAppLan);
                    iPSPFAppCodePublisher.close();
                }
            }
        }
        if ((psAppMsgTempls = iPSApplication.getAllPSAppMsgTempls()) != null) {
            while (psAppMsgTempls.hasNext()) {
                IPSAppMsgTempl iPSAppMsgTempl = psAppMsgTempls.next();
                Iterator<IPSPFAppObjectTempl> psPFAppTempls = iPSPFStyle.getPSPFAppObjectTempls("PSAPPMSGTEMPL");
                if (psPFAppTempls == null) continue;
                while (psPFAppTempls.hasNext()) {
                    IPSPFAppObjectTempl iPSPFAppTempl = psPFAppTempls.next();
                    IPSPFAppObjectCodePublisher iPSPFAppCodePublisher = iPSPFAppTempl.getPSPFCodePublisher();
                    iPSPFAppCodePublisher.generateCode(psPublishContextImpl, iPSAppMsgTempl);
                    iPSPFAppCodePublisher.close();
                }
            }
        }
        if ((psAppViewMsgs = iPSApplication.getAllPSAppViewMsgs()) != null) {
            while (psAppViewMsgs.hasNext()) {
                IPSAppViewMsg iPSAppViewMsg = psAppViewMsgs.next();
                Iterator<IPSPFAppObjectTempl> psPFAppTempls = iPSPFStyle.getPSPFAppObjectTempls("PSAPPVIEWMSG");
                if (psPFAppTempls == null) continue;
                while (psPFAppTempls.hasNext()) {
                    IPSPFAppObjectTempl iPSPFAppTempl = psPFAppTempls.next();
                    IPSPFAppObjectCodePublisher iPSPFAppCodePublisher = iPSPFAppTempl.getPSPFCodePublisher();
                    iPSPFAppCodePublisher.generateCode(psPublishContextImpl, iPSAppViewMsg);
                    iPSPFAppCodePublisher.close();
                }
            }
        }
        if ((psAppViewMsgGroups = iPSApplication.getAllPSAppViewMsgGroups()) != null) {
            while (psAppViewMsgGroups.hasNext()) {
                IPSAppViewMsgGroup iPSAppViewMsgGroup = psAppViewMsgGroups.next();
                Iterator<IPSPFAppObjectTempl> psPFAppTempls = iPSPFStyle.getPSPFAppObjectTempls("PSAPPVIEWMSGGROUP");
                if (psPFAppTempls == null) continue;
                while (psPFAppTempls.hasNext()) {
                    IPSPFAppObjectTempl iPSPFAppTempl = psPFAppTempls.next();
                    IPSPFAppObjectCodePublisher iPSPFAppCodePublisher = iPSPFAppTempl.getPSPFCodePublisher();
                    iPSPFAppCodePublisher.generateCode(psPublishContextImpl, iPSAppViewMsgGroup);
                    iPSPFAppCodePublisher.close();
                }
            }
        }
        if ((psAppPFPluginRefs = iPSApplication.getAllPSAppPFPluginRefs()) != null) {
            while (psAppPFPluginRefs.hasNext()) {
                IPSAppPFPluginRef iPSAppPFPluginRef = psAppPFPluginRefs.next();
                Iterator<IPSPFAppObjectTempl> psPFAppTempls = iPSPFStyle.getPSPFAppObjectTempls("PSAPPPFPLUGINREF");
                if (psPFAppTempls == null) continue;
                while (psPFAppTempls.hasNext()) {
                    IPSPFAppObjectTempl iPSPFAppTempl = psPFAppTempls.next();
                    IPSPFAppObjectCodePublisher iPSPFAppCodePublisher = iPSPFAppTempl.getPSPFCodePublisher();
                    iPSPFAppCodePublisher.generateCode(psPublishContextImpl, iPSAppPFPluginRef);
                    iPSPFAppCodePublisher.close();
                }
            }
        }
        if ((psAppEditorStyleRefs = iPSApplication.getAllPSAppEditorStyleRefs()) != null) {
            while (psAppEditorStyleRefs.hasNext()) {
                IPSAppEditorStyleRef iPSAppEditorStyleRef = psAppEditorStyleRefs.next();
                Iterator<IPSPFAppObjectTempl> psPFAppTempls = iPSPFStyle.getPSPFAppObjectTempls("PSAPPEDITORSTYLEREF");
                if (psPFAppTempls == null) continue;
                while (psPFAppTempls.hasNext()) {
                    IPSPFAppObjectTempl iPSPFAppTempl = psPFAppTempls.next();
                    IPSPFAppObjectCodePublisher iPSPFAppCodePublisher = iPSPFAppTempl.getPSPFCodePublisher();
                    iPSPFAppCodePublisher.generateCode(psPublishContextImpl, iPSAppEditorStyleRef);
                    iPSPFAppCodePublisher.close();
                }
            }
        }
        if ((psAppSubViewTypeRefs = iPSApplication.getAllPSAppSubViewTypeRefs()) != null) {
            while (psAppSubViewTypeRefs.hasNext()) {
                IPSAppSubViewTypeRef iPSAppSubViewTypeRef = psAppSubViewTypeRefs.next();
                Iterator<IPSPFAppObjectTempl> psPFAppTempls = iPSPFStyle.getPSPFAppObjectTempls("PSAPPSUBVIEWTYPEREF");
                if (psPFAppTempls == null) continue;
                while (psPFAppTempls.hasNext()) {
                    IPSPFAppObjectTempl iPSPFAppTempl = psPFAppTempls.next();
                    IPSPFAppObjectCodePublisher iPSPFAppCodePublisher = iPSPFAppTempl.getPSPFCodePublisher();
                    iPSPFAppCodePublisher.generateCode(psPublishContextImpl, iPSAppSubViewTypeRef);
                    iPSPFAppCodePublisher.close();
                }
            }
        }
        return sBuilderEx.toString();
    }

    protected IPSApplication getPSApplication(PSSysApp psSysApp) throws Exception {
        IPSApplication iPSApplication;
        IPSDevSlnSys iPSDevSlnSys;
        IPSSystem iPSSystem;
        if (this.getPSSysRunSession() != null && this.getPSSysRunSession().isRebuildMode()) {
            this.getPSModelStorage().resetPSDevSlnSys(this.psSysDevBKTask.getPSDEVSLNSYSID());
        }
        if ((iPSSystem = (iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(this.psSysDevBKTask.getPSDEVSLNSYSID())).getPSSystem(false)).getLoadedLevel() < this.getModelLoadLevel()) {
            iPSSystem = iPSDevSlnSys.reloadPSSystem(this.getModelLoadLevel());
        }
        if ((iPSApplication = iPSSystem.getPSApplication(psSysApp.getPSSysAppId())).getLoadedLevel() < this.getModelLoadLevel()) {
            this.getPSModelHelper().startLoadPSSysApp(psSysApp.getPSSysAppId(), this.getModelLoadLevel());
            try {
                if (iPSApplication.getLoadedLevel() > IPSSystem.LOADLEVEL_NONE) {
                    iPSSystem.resetPSApplication(psSysApp.getPSSysAppId());
                    iPSApplication = iPSSystem.getPSApplication(psSysApp.getPSSysAppId());
                }
                iPSApplication.load(this.getModelLoadLevel());
                this.getPSModelHelper().stopLoadPSSysApp();
            }
            catch (Exception ex) {
                this.getPSModelHelper().stopLoadPSSysApp();
                throw ex;
            }
        }
        return iPSApplication;
    }

    /*
     * Unable to fully structure code
     */
    protected void generateUserCode(PSSysApp psSysApp) throws Exception {
        iPSApplication = this.getPSApplication(psSysApp);
        if (this.getPSSysPubRuntime() != null) {
            this.getPSSysPubRuntime().registerPFPubFolder(iPSApplication, "USERCODE");
        }
        if ((psAppViewCodes = iPSApplication.getAllPSAppViewCodes()) == null) {
            return;
        }
        strCodeFolder = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "CODEFOLDER", null);
        strToolFolder = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "TOOLFOLDER", null);
        if (!StringHelper.isNullOrEmpty((String)strCodeFolder)) ** GOTO lbl35
        throw new Exception("\u6ca1\u6709\u5b9a\u4e49\u4ee3\u7801\u53d1\u5e03\u76ee\u5f55");
lbl-1000:
        // 1 sources

        {
            iPSAppViewCode = psAppViewCodes.next();
            if (iPSAppViewCode.getPSPFPubCode() != null) continue;
            strFolder = strCodeFolder;
            strFolder = String.valueOf(strFolder) + File.separator + iPSApplication.getPSSystem().getPSDevCenterDomain();
            strFolder = String.valueOf(strFolder) + File.separator + iPSApplication.getPSSystem().getPubSystemId();
            strFolder = String.valueOf(strFolder) + File.separator + iPSApplication.getPSSystem().getVCName();
            strFolder = String.valueOf(strFolder) + File.separator + "app_" + iPSApplication.getWorkshopName();
            strFolder = String.valueOf(strFolder) + File.separator + "USERCODE";
            strFolder = String.valueOf(strFolder) + File.separator + iPSAppViewCode.getProjectType();
            if (!StringHelper.isNullOrEmpty((String)iPSAppViewCode.getFilePath())) {
                strFolder = String.valueOf(strFolder) + File.separator + iPSAppViewCode.getFilePath();
            }
            if (!(folder = new File(strFolder = strFolder.replace("/", File.separator))).exists()) {
                folder.mkdirs();
            }
            if ((strFullPath = String.valueOf(strFolder) + File.separator + iPSAppViewCode.getName()).length() >= PSTaskServerEnvImpl.getCurrent().getMaxFileNameLength()) {
                strInfo = StringHelper.format((String)"\u53d1\u5e03\u4ee3\u7801[%1$s]\u8def\u5f84\u8fc7\u957f[%2$s]\uff0c\u53ef\u80fd\u65e0\u6cd5\u5199\u5165", (Object)strFullPath, (Object)strFullPath.length());
                ((IPSSystemUtil)iPSApplication.getPSSystem()).log(4, iPSApplication, strInfo);
                SysPFPubPSSysDevBKTaskImpl.log.warn((Object)strInfo);
                this.log(4, null, strInfo);
                if (PSTaskServerEnvImpl.getCurrent().isThrowExceptionWhenFileNameTooLong()) {
                    throw new Exception(StringHelper.format((String)"\u53d1\u5e03\u4ee3\u7801[%1$s]\u540d\u79f0\u957f\u5ea6\u8d85\u8fc7[%2$s]", (Object)strFullPath, (Object)PSTaskServerEnvImpl.getCurrent().getMaxFileNameLength()));
                }
            }
            if (this.getPSSysPubRuntime() != null) {
                ((IPSSystemUtil)iPSApplication.getPSSystem()).pubPFCode(this.getPSSysPubRuntime(), iPSApplication, "USERCODE", strFullPath, iPSAppViewCode.getUserCode(), null);
                continue;
            }
            ((IPSSystemUtil)iPSApplication.getPSSystem()).writeFile(strFullPath, iPSAppViewCode.getUserCode(), null);
lbl35:
            // 4 sources

            ** while (psAppViewCodes.hasNext())
        }
lbl36:
        // 1 sources

    }

    private class TaskManager {
        private Vector<PSAppView> psAppViewList = new Vector();
        private int nTotalCount = 0;
        private int nFinishCount = 0;
        private int nErrorCount = 0;
        private int nPubCount = 0;
        private StringBuilderEx errorBuilder = new StringBuilderEx();
        private ArrayList<PSSysAppDataCtrl.TaskManager.TaskThread> threads = new ArrayList();
        private IPSApplication iPSApplication = null;
        private IPSSystem iPSSystem = null;
        private IPSPF iPSPF = null;
        private IPSPFStyle iPSPFStyle = null;
        private boolean bPubViewCtrl = false;
        private Vector<IPSControlContainerView> psControlContainerViewList = new Vector();

        public TaskManager(IPSApplication iPSApplication, Vector<PSAppView> psAppViewList, Vector<IPSControlContainerView> psControlContainerViewList) throws Exception {
            this.psAppViewList.addAll(psAppViewList);
            if (psControlContainerViewList != null) {
                this.psControlContainerViewList.addAll(psControlContainerViewList);
            }
            this.iPSSystem = iPSApplication.getPSSystem();
            this.iPSApplication = iPSApplication;
            this.iPSPF = this.iPSApplication.getPSPF();
            this.iPSPFStyle = this.iPSApplication.getPSPFStyle();
            this.bPubViewCtrl = this.iPSPFStyle.getPSPFPubCodes("VIEWCTRL", true) != null;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void start() throws Exception {
            for (IPSControlContainerView iPSControlContainerView : this.psControlContainerViewList) {
                this.generateViewCode(iPSControlContainerView);
            }
            this.nTotalCount = this.psAppViewList.size();
            if (this.nTotalCount == 0) {
                return;
            }
            int nLoopCount = this.nTotalCount;
            if (nLoopCount > SysPFPubPSSysDevBKTaskImpl.this.getTaskThreadCount()) {
                nLoopCount = SysPFPubPSSysDevBKTaskImpl.this.getTaskThreadCount();
            }
            int i = 0;
            while (i < nLoopCount) {
                SysPFPubPSSysDevBKTaskImpl.this.executeTask(new Runnable(){

                    @Override
                    public void run() {
                        while (TaskManager.this.runTask()) {
                        }
                    }
                });
                ++i;
            }
            while (true) {
                Vector<PSAppView> vector = this.psAppViewList;
                synchronized (vector) {
                    if (this.nTotalCount == this.nFinishCount) {
                        break;
                    }
                }
                Thread.sleep(50L);
            }
            this.threads.clear();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public boolean runTask() {
            Vector<PSAppView> vector;
            block19: {
                if (PSJITWebContext.getInstance() != null) {
                    PSJITWebContext.setCurrent(null);
                }
                PSAppView psAppView = null;
                vector = this.psAppViewList;
                synchronized (vector) {
                    if (this.psAppViewList.size() <= 0) {
                        return false;
                    }
                    psAppView = this.psAppViewList.remove(0);
                }
                try {
                    if (!this.generateViewCode(psAppView)) break block19;
                    vector = this.psAppViewList;
                    synchronized (vector) {
                        ++this.nPubCount;
                    }
                }
                catch (Exception ex) {
                    String strErrorInfo = StringHelper.format((String)"\u751f\u6210\u89c6\u56fe[%1$s]\u4ee3\u7801\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)psAppView.getPSAPPVIEWNAME(), (Object)ex.getMessage());
                    log.error((Object)strErrorInfo, (Throwable)ex);
                    StringBuilderEx stringBuilderEx = this.errorBuilder;
                    synchronized (stringBuilderEx) {
                        this.errorBuilder.append(strErrorInfo);
                    }
                    Vector<PSAppView> vector2 = this.psAppViewList;
                    synchronized (vector2) {
                        ++this.nErrorCount;
                        ++this.nPubCount;
                    }
                }
            }
            vector = this.psAppViewList;
            synchronized (vector) {
                ++this.nFinishCount;
                return true;
            }
        }

        public int getErrorCount() {
            return this.nErrorCount;
        }

        public String getErrorInfo() {
            return this.errorBuilder.toString();
        }

        public int getPubCount() {
            return this.nPubCount;
        }

        protected boolean generateViewCode(PSAppView psAppView) throws Exception {
            IPSAppView iPSAppView = this.iPSApplication.getPSAppView(psAppView.getPSAPPVIEWID(), null);
            if (!StringHelper.isNullOrEmpty((String)iPSAppView.getSubAppFolderName())) {
                return false;
            }
            if (this.iPSApplication.isPubRefViewOnly() && !iPSAppView.getRefFlag()) {
                return false;
            }
            return this.generateViewCode(iPSAppView);
        }

        protected boolean generateViewCode(IPSAppView iPSAppView) throws Exception {
            IPSSysPubRuntime iPSSysPubRuntime;
            HashMap<String, Object> params;
            PSPublishContextImpl psPublishContextImpl;
            boolean bPubViewCode = true;
            if (iPSAppView instanceof IPSControlContainerView) {
                bPubViewCode = false;
            }
            if (bPubViewCode) {
                psPublishContextImpl = new PSPublishContextImpl(SysPFPubPSSysDevBKTaskImpl.this.getDAGlobalHelper(), null);
                psPublishContextImpl.setPSSysModelInstId(this.iPSSystem.getPSSysModelInstId());
                psPublishContextImpl.setPSLogItemList(SysPFPubPSSysDevBKTaskImpl.this.getPSLogItemList());
                params = new HashMap<String, Object>();
                iPSSysPubRuntime = SysPFPubPSSysDevBKTaskImpl.this.getPSSysPubRuntime();
                if (iPSSysPubRuntime != null) {
                    params.put("syspub", iPSSysPubRuntime);
                }
                if (SysPFPubPSSysDevBKTaskImpl.this.getPSSysRunSession() != null) {
                    params.put("sysrun", SysPFPubPSSysDevBKTaskImpl.this.getPSSysRunSession());
                }
                if (params.size() > 0) {
                    psPublishContextImpl.setPubParams(params);
                }
                Iterator<IPSPFViewTempl> psPFViewTempls = iPSAppView.getPSPFStyle().getPSPFViewTempls(iPSAppView);
                while (psPFViewTempls.hasNext()) {
                    IPSPFViewTempl iPSPFViewTempl = psPFViewTempls.next();
                    IPSPFViewCodePublisher iPSPFViewCodePublisher = iPSPFViewTempl.getPSPFViewCodePublisher();
                    iPSPFViewCodePublisher.generateCode(psPublishContextImpl, iPSAppView);
                    iPSPFViewCodePublisher.close();
                }
            }
            if (this.bPubViewCtrl) {
                psPublishContextImpl = new PSPublishContextImpl(SysPFPubPSSysDevBKTaskImpl.this.getDAGlobalHelper(), null);
                psPublishContextImpl.setPSSysModelInstId(this.iPSSystem.getPSSysModelInstId());
                psPublishContextImpl.setPSLogItemList(SysPFPubPSSysDevBKTaskImpl.this.getPSLogItemList());
                params = new HashMap();
                iPSSysPubRuntime = SysPFPubPSSysDevBKTaskImpl.this.getPSSysPubRuntime();
                if (iPSSysPubRuntime != null) {
                    params.put("syspub", iPSSysPubRuntime);
                }
                if (params.size() > 0) {
                    psPublishContextImpl.setPubParams(params);
                }
                ArrayList<IPSControl> psControls = iPSAppView.getAllPSControls();
                HashMap<String, IPSControl> psControlMap = new HashMap<String, IPSControl>();
                for (IPSControl iPSControl : psControls) {
                    this.fillAllPSControls(iPSControl, psControlMap);
                }
                for (IPSControl iPSControl : psControlMap.values()) {
                    Iterator<IPSPFCtrlTempl> psPFCtrlTempls = iPSAppView.getPSPFStyle().getPSPFCtrlTempls(iPSControl);
                    while (psPFCtrlTempls.hasNext()) {
                        IPSPFCtrlTempl iPSPFCtrlTempl = psPFCtrlTempls.next();
                        IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher = iPSPFCtrlTempl.getPSPFCtrlCodePublisher();
                        if (iPSPFCtrlCodePublisher instanceof IPSPFCtrlCodePublisher2) {
                            ((IPSPFCtrlCodePublisher2)((Object)iPSPFCtrlCodePublisher)).generateCode2(psPublishContextImpl, iPSControl);
                        }
                        iPSPFCtrlCodePublisher.close();
                    }
                }
            }
            return true;
        }

        protected void fillAllPSControls(IPSControl iPSControl, Map<String, IPSControl> psControlMap) throws Exception {
            IPSControlContainer iPSControlContainer;
            Iterator<IPSLayoutPanel> psLayoutPanels;
            String strPSControlId = iPSControl.getId();
            if (StringHelper.isNullOrEmpty((String)strPSControlId)) {
                strPSControlId = KeyValueHelper.genGuidEx();
            }
            if (psControlMap.containsKey(strPSControlId = KeyValueHelper.genUniqueId((String)iPSControl.getControlType(), (String)strPSControlId))) {
                return;
            }
            psControlMap.put(strPSControlId, iPSControl);
            if (iPSControl instanceof IPSControlContainer && (psLayoutPanels = (iPSControlContainer = (IPSControlContainer)((Object)iPSControl)).getPSLayoutPanels()) != null) {
                while (psLayoutPanels.hasNext()) {
                    IPSLayoutPanel iPSLayoutPanel = psLayoutPanels.next();
                    strPSControlId = iPSLayoutPanel.getId();
                    if (StringHelper.isNullOrEmpty((String)strPSControlId)) {
                        strPSControlId = KeyValueHelper.genGuidEx();
                    }
                    if (psControlMap.containsKey(strPSControlId = KeyValueHelper.genUniqueId((String)iPSLayoutPanel.getControlType(), (String)strPSControlId))) continue;
                    psControlMap.put(strPSControlId, iPSLayoutPanel);
                    Iterator childPSControls = iPSLayoutPanel.getPSControls();
                    if (childPSControls == null) continue;
                    while (childPSControls.hasNext()) {
                        this.fillAllPSControls((IPSControl)childPSControls.next(), psControlMap);
                    }
                }
            }
        }
    }
}

