package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSModelObjectLogger;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemRuntime;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelObjectLoggerImpl;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.App.IPSAppLan;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.CodeList.IPSAppCodeList;
import SA.SRFDA.PS.Core.App.Control.IPSAppCounter;
import SA.SRFDA.PS.Core.App.Control.IPSControlContainerView;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDELogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethodDTO;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.Msg.IPSAppMsgTempl;
import SA.SRFDA.PS.Core.App.Pub.IPSAppViewCode;
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
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewServiceProxy;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class SysPFPubPSSysDevBKTaskImpl extends PSSysDevBKTaskImplBase {
   private static final Log log = LogFactory.getLog(SysPFPubPSSysDevBKTaskImpl.class);

   @Override
   protected void onInit() throws Exception {
      super.onInit();
   }

   @Override
   protected String onRun() throws Exception {
      PSSysAppService psSysAppService = (PSSysAppService)ServiceGlobal.getService(
         PSSysAppService.class, PSSysModelInstGlobal.getSessionFactory(this.getPSSysModelInstId())
      );
      PSSysApp psSysApp = new PSSysApp();
      psSysApp.setPSSysAppId(this.psSysDevBKTask.getTASKPARAM());
      psSysAppService.get(psSysApp);
      return this.generateCode(psSysApp);
   }

   protected String generateCode(PSSysApp psSysApp) throws Exception {
      IPSModelObjectLogger lastPSModelObjectLogger = null;
      IPSSystemRuntime iPSSystemRuntime = null;

      try {
         IPSApplication iPSApplication = this.getPSApplication(psSysApp);
         IPSSystem iPSSystem = iPSApplication.getPSSystem();
         iPSSystemRuntime = (IPSSystemRuntime)iPSSystem;
         lastPSModelObjectLogger = iPSSystemRuntime.getPSModelObjectLogger();
         String strLoggerName = StringHelper.format("%1$s[%2$s]", psSysApp.getPSPFStyleName(), psSysApp.getPSSysAppName());
         PSModelObjectLoggerImpl psModelObjectLoggerImpl = new PSModelObjectLoggerImpl(
            this.getRootPSSysDevBKTask(), iPSSystem.getPSDevCenterDomain(), strLoggerName, -1
         );
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
      } catch (Exception ex) {
         if (iPSSystemRuntime != null) {
            iPSSystemRuntime.setPSModelObjectLogger(lastPSModelObjectLogger);
         }

         throw ex;
      }
   }

   protected String onGenerateCode(PSSysApp psSysApp) throws Exception {
      IPSApplication iPSApplication = this.getPSApplication(psSysApp);
      Iterator<IPSPFPubCode> psPFPubCodes = iPSApplication.getPSPFStyle().getPSPFPubCodes("VIEW", true);
      if (psPFPubCodes != null) {
         while (psPFPubCodes.hasNext()) {
            IPSPFPubCode iPSPFPubCode = psPFPubCodes.next();
            if (this.getPSSysPubRuntime() != null && iPSPFPubCode.getPSPFCodeFolder() != null) {
               this.getPSSysPubRuntime().registerPFPubFolder(iPSApplication, iPSPFPubCode.getPSPFCodeFolder().getFolderName());
            }
         }
      }

      psPFPubCodes = iPSApplication.getPSPFStyle().getPSPFPubCodes("VIEWCTRL", true);
      if (psPFPubCodes != null) {
         while (psPFPubCodes.hasNext()) {
            IPSPFPubCode iPSPFPubCode = psPFPubCodes.next();
            if (this.getPSSysPubRuntime() != null && iPSPFPubCode.getPSPFCodeFolder() != null) {
               this.getPSSysPubRuntime().registerPFPubFolder(iPSApplication, iPSPFPubCode.getPSPFCodeFolder().getFolderName());
            }
         }
      }

      String strPSDevSlnSysId = iPSApplication.getPSSystem().getPSDevSlnSysId();
      String strPSSysModelInstId = this.getPSSysModelInstId();
      StringBuilderEx sBuilderEx = new StringBuilderEx();
      SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory(this.getPSSysModelInstId());
      PSAppViewServiceProxy psAppViewServiceProxy = (PSAppViewServiceProxy)ServiceGlobal.getService(PSAppViewServiceProxy.class, sessionFactory);
      ArrayList<PSAppView> psAppViewList2 = psAppViewServiceProxy.selectByPSSysApp(psSysApp);
      Vector<SA.SRFDA.PS.Data.PSAppView> psAppViewList = new Vector<>();

      for (PSAppView psAppView : psAppViewList2) {
         if (DataObject.getIntegerValue(psAppView.getDynaModelFlag(), 0) == 0) {
            SA.SRFDA.PS.Data.PSAppView psAppView2 = new SA.SRFDA.PS.Data.PSAppView();
            PSDEDataCtrl.convertEntity(psAppView, psAppView2);
            psAppView2.setParamValue("PSDEVSLNSYSID", strPSDevSlnSysId);
            psAppView2.setParamValue("PSSYSMODELINSTID", strPSSysModelInstId);
            psAppViewList.add(psAppView2);
         }
      }

      Vector<IPSControlContainerView> psControlContainerViewList = new Vector<>();
      Iterator<IPSControlContainerView> psControlContainerViews = iPSApplication.getPSControlContainerViews();
      if (psControlContainerViews != null) {
         while (psControlContainerViews.hasNext()) {
            psControlContainerViewList.add(psControlContainerViews.next());
         }
      }

      try {
         SysPFPubPSSysDevBKTaskImpl.TaskManager taskManager = new SysPFPubPSSysDevBKTaskImpl.TaskManager(
            iPSApplication, psAppViewList, psControlContainerViewList
         );
         long nBeginTime = System.currentTimeMillis();
         taskManager.start();
         long nTime = System.currentTimeMillis() - nBeginTime;
         log.debug(StringHelper.format("发布视图代码数量[%1$s]，耗时[%2$s]ms，错误数量[%3$s]", taskManager.getPubCount(), nTime, taskManager.getErrorCount()));
         sBuilderEx.append(
            "[v%1$s]发布视图代码数量[%2$s]，耗时[%3$s]ms，错误数量[%4$s]",
            iPSApplication.getPSSystem().getVersion(),
            taskManager.getPubCount(),
            nTime,
            taskManager.getErrorCount()
         );
         if (taskManager.getErrorCount() > 0) {
            sBuilderEx.append("\r\n%1$s", taskManager.getErrorInfo());
            throw new Exception(StringHelper.format("发布应用视图代码发生错误。\r\n%1$s", taskManager.getErrorInfo()));
         }

         SessionFactoryManager.releaseRef(true);
      } catch (Exception ex) {
         log.error(StringHelper.format("产生视图代码发生异常，%1$s", ex.getMessage()), ex);
         SessionFactoryManager.releaseRef(false);
         throw ex;
      }

      return sBuilderEx.toString();
   }

   protected String onGenerateCode2(PSSysApp psSysApp) throws Exception {
      StringBuilderEx sBuilderEx = new StringBuilderEx();
      IPSApplication iPSApplication = this.getPSApplication(psSysApp);
      Iterator<IPSPFPubCode> psPFPubCodes = iPSApplication.getPSPFStyle().getPSPFPubCodes("APP", true);
      if (psPFPubCodes != null) {
         while (psPFPubCodes.hasNext()) {
            IPSPFPubCode iPSPFPubCode = psPFPubCodes.next();
            if (this.getPSSysPubRuntime() != null && iPSPFPubCode.getPSPFCodeFolder() != null) {
               this.getPSSysPubRuntime().registerPFPubFolder(iPSApplication, iPSPFPubCode.getPSPFCodeFolder().getFolderName());
            }
         }
      }

      IPSPFStyle iPSPFStyle = iPSApplication.getPSPFStyle();
      PSPublishContextImpl psPublishContextImpl = new PSPublishContextImpl(this.getDAGlobalHelper(), null);
      psPublishContextImpl.setPSSysModelInstId(this.getPSSysModelInstId());
      psPublishContextImpl.setPSLogItemList(this.getPSLogItemList());
      HashMap<String, Object> params = new HashMap<>();
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

      IPSSysPubRuntime iPSSysPubRuntime = this.getPSSysPubRuntime();
      if (iPSSysPubRuntime != null) {
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
            if (this.getPSSysPubRuntime() != null && iPSPFPubCode.getPSPFCodeFolder() != null) {
               this.getPSSysPubRuntime().registerPFPubFolder(iPSApplication, iPSPFPubCode.getPSPFCodeFolder().getFolderName());
            }
         }
      }

      PSPublishContextImpl psPublishContextImpl = new PSPublishContextImpl(this.getDAGlobalHelper(), null);
      psPublishContextImpl.setPSSysModelInstId(this.getPSSysModelInstId());
      psPublishContextImpl.setPSLogItemList(this.getPSLogItemList());
      HashMap<String, Object> params = new HashMap<>();
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

      IPSSysPubRuntime iPSSysPubRuntime = this.getPSSysPubRuntime();
      if (iPSSysPubRuntime != null) {
         params.put("syspub", iPSSysPubRuntime);
      }

      if (params.size() > 0) {
         psPublishContextImpl.setPubParams(params);
      }

      Iterator<IPSAppDataEntity> psAppDataEntities = iPSApplication.getAllPSAppDataEntities();
      if (psAppDataEntities != null) {
         while (psAppDataEntities.hasNext()) {
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

            Iterator<IPSAppDELogic> psAppDELogics = iPSAppDataEntity.getAllPSAppDELogics();
            if (psAppDELogics != null) {
               while (psAppDELogics.hasNext()) {
                  IPSAppDELogic iPSAppDELogic = psAppDELogics.next();
                  Iterator<IPSPFAppObjectTempl> psPFAppObjectTempls = iPSPFStyle.getPSPFAppObjectTempls("PSAPPDELOGIC");
                  if (psPFAppObjectTempls != null) {
                     while (psPFAppObjectTempls.hasNext()) {
                        IPSPFAppObjectTempl iPSPFAppObjectTempl = psPFAppObjectTempls.next();
                        IPSPFAppObjectCodePublisher iPSPFAppObjectCodePublisher = iPSPFAppObjectTempl.getPSPFCodePublisher();
                        iPSPFAppObjectCodePublisher.generateCode(psPublishContextImpl, iPSAppDELogic);
                        iPSPFAppObjectCodePublisher.close();
                     }
                  }
               }
            }

            Iterator<IPSAppDEUILogic> psAppDEUILogics = iPSAppDataEntity.getAllPSAppDEUILogics();
            if (psAppDEUILogics != null) {
               while (psAppDEUILogics.hasNext()) {
                  IPSAppDEUILogic iPSAppDEUILogic = psAppDEUILogics.next();
                  Iterator<IPSPFAppObjectTempl> psPFAppObjectTempls = iPSPFStyle.getPSPFAppObjectTempls("PSAPPDEUILOGIC");
                  if (psPFAppObjectTempls != null) {
                     while (psPFAppObjectTempls.hasNext()) {
                        IPSPFAppObjectTempl iPSPFAppObjectTempl = psPFAppObjectTempls.next();
                        IPSPFAppObjectCodePublisher iPSPFAppObjectCodePublisher = iPSPFAppObjectTempl.getPSPFCodePublisher();
                        iPSPFAppObjectCodePublisher.generateCode(psPublishContextImpl, iPSAppDEUILogic);
                        iPSPFAppObjectCodePublisher.close();
                     }
                  }
               }
            }

            Iterator<IPSAppDEMethodDTO> psAppDEMethodDTOs = iPSAppDataEntity.getAllPSAppDEMethodDTOs();
            if (psAppDEMethodDTOs != null) {
               while (psAppDEMethodDTOs.hasNext()) {
                  IPSAppDEMethodDTO iPSAppDEMethodDTO = psAppDEMethodDTOs.next();
                  Iterator<IPSPFAppObjectTempl> psPFAppObjectTempls = iPSPFStyle.getPSPFAppObjectTempls("PSAPPDEMETHODDTO");
                  if (psPFAppObjectTempls != null) {
                     while (psPFAppObjectTempls.hasNext()) {
                        IPSPFAppObjectTempl iPSPFAppObjectTempl = psPFAppObjectTempls.next();
                        IPSPFAppObjectCodePublisher iPSPFAppObjectCodePublisher = iPSPFAppObjectTempl.getPSPFCodePublisher();
                        iPSPFAppObjectCodePublisher.generateCode(psPublishContextImpl, iPSAppDEMethodDTO);
                        iPSPFAppObjectCodePublisher.close();
                     }
                  }
               }
            }
         }
      }

      Iterator<IPSAppWF> psAppWFs = iPSApplication.getAllPSAppWFs();
      if (psAppWFs != null) {
         while (psAppWFs.hasNext()) {
            IPSAppWF iPSAppWF = psAppWFs.next();
            Iterator<IPSPFAppWFTempl> psPFAppTempls = iPSPFStyle.getPSPFAppWFTempls(iPSAppWF);
            if (psPFAppTempls != null) {
               while (psPFAppTempls.hasNext()) {
                  IPSPFAppWFTempl iPSPFAppTempl = psPFAppTempls.next();
                  IPSPFAppWFCodePublisher iPSPFAppCodePublisher = iPSPFAppTempl.getPSPFAppWFCodePublisher();
                  iPSPFAppCodePublisher.generateCode(psPublishContextImpl, iPSAppWF);
                  iPSPFAppCodePublisher.close();
               }
            }
         }
      }

      Iterator<IPSAppWFVer> psAppWFVers = iPSApplication.getAllPSAppWFVers();
      if (psAppWFVers != null) {
         while (psAppWFVers.hasNext()) {
            IPSAppWFVer iPSAppWFVer = psAppWFVers.next();
            Iterator<IPSPFAppWFVerTempl> psPFAppTempls = iPSPFStyle.getPSPFAppWFVerTempls(iPSAppWFVer);
            if (psPFAppTempls != null) {
               while (psPFAppTempls.hasNext()) {
                  IPSPFAppWFVerTempl iPSPFAppTempl = psPFAppTempls.next();
                  IPSPFAppWFVerCodePublisher iPSPFAppCodePublisher = iPSPFAppTempl.getPSPFAppWFVerCodePublisher();
                  iPSPFAppCodePublisher.generateCode(psPublishContextImpl, iPSAppWFVer);
                  iPSPFAppCodePublisher.close();
               }
            }
         }
      }

      Iterator<IPSAppCounter> psAppCounters = iPSApplication.getAllPSAppCounters();
      if (psAppCounters != null) {
         while (psAppCounters.hasNext()) {
            IPSAppCounter iPSAppCounter = psAppCounters.next();
            Iterator<IPSPFAppObjectTempl> psPFAppTempls = iPSPFStyle.getPSPFAppObjectTempls("PSAPPCOUNTER");
            if (psPFAppTempls != null) {
               while (psPFAppTempls.hasNext()) {
                  IPSPFAppObjectTempl iPSPFAppTempl = psPFAppTempls.next();
                  IPSPFAppObjectCodePublisher iPSPFAppCodePublisher = iPSPFAppTempl.getPSPFCodePublisher();
                  iPSPFAppCodePublisher.generateCode(psPublishContextImpl, iPSAppCounter);
                  iPSPFAppCodePublisher.close();
               }
            }
         }
      }

      Iterator<IPSAppCodeList> psAppCodeLists = iPSApplication.getAllPSAppCodeLists();
      if (psAppCodeLists != null) {
         while (psAppCodeLists.hasNext()) {
            IPSAppCodeList iPSAppCodeList = psAppCodeLists.next();
            Iterator<IPSPFAppObjectTempl> psPFAppTempls = iPSPFStyle.getPSPFAppObjectTempls("PSAPPCODELIST");
            if (psPFAppTempls != null) {
               while (psPFAppTempls.hasNext()) {
                  IPSPFAppObjectTempl iPSPFAppTempl = psPFAppTempls.next();
                  IPSPFAppObjectCodePublisher iPSPFAppCodePublisher = iPSPFAppTempl.getPSPFCodePublisher();
                  iPSPFAppCodePublisher.generateCode(psPublishContextImpl, iPSAppCodeList);
                  iPSPFAppCodePublisher.close();
               }
            }
         }
      }

      Iterator<IPSAppUtil> psAppUtils = iPSApplication.getAllPSAppUtils();
      if (psAppUtils != null) {
         while (psAppUtils.hasNext()) {
            IPSAppUtil iPSAppUtil = psAppUtils.next();
            Iterator<IPSPFAppObjectTempl> psPFAppTempls = iPSPFStyle.getPSPFAppObjectTempls("PSAPPUTIL");
            if (psPFAppTempls != null) {
               while (psPFAppTempls.hasNext()) {
                  IPSPFAppObjectTempl iPSPFAppTempl = psPFAppTempls.next();
                  IPSPFAppObjectCodePublisher iPSPFAppCodePublisher = iPSPFAppTempl.getPSPFCodePublisher();
                  iPSPFAppCodePublisher.generateCode(psPublishContextImpl, iPSAppUtil);
                  iPSPFAppCodePublisher.close();
               }
            }
         }
      }

      Iterator<IPSAppLan> psAppLans = iPSApplication.getAllPSAppLans();
      if (psAppLans != null) {
         while (psAppLans.hasNext()) {
            IPSAppLan iPSAppLan = psAppLans.next();
            Iterator<IPSPFAppObjectTempl> psPFAppTempls = iPSPFStyle.getPSPFAppObjectTempls("PSAPPLAN");
            if (psPFAppTempls != null) {
               while (psPFAppTempls.hasNext()) {
                  IPSPFAppObjectTempl iPSPFAppTempl = psPFAppTempls.next();
                  IPSPFAppObjectCodePublisher iPSPFAppCodePublisher = iPSPFAppTempl.getPSPFCodePublisher();
                  iPSPFAppCodePublisher.generateCode(psPublishContextImpl, iPSAppLan);
                  iPSPFAppCodePublisher.close();
               }
            }
         }
      }

      Iterator<IPSAppMsgTempl> psAppMsgTempls = iPSApplication.getAllPSAppMsgTempls();
      if (psAppMsgTempls != null) {
         while (psAppMsgTempls.hasNext()) {
            IPSAppMsgTempl iPSAppMsgTempl = psAppMsgTempls.next();
            Iterator<IPSPFAppObjectTempl> psPFAppTempls = iPSPFStyle.getPSPFAppObjectTempls("PSAPPMSGTEMPL");
            if (psPFAppTempls != null) {
               while (psPFAppTempls.hasNext()) {
                  IPSPFAppObjectTempl iPSPFAppTempl = psPFAppTempls.next();
                  IPSPFAppObjectCodePublisher iPSPFAppCodePublisher = iPSPFAppTempl.getPSPFCodePublisher();
                  iPSPFAppCodePublisher.generateCode(psPublishContextImpl, iPSAppMsgTempl);
                  iPSPFAppCodePublisher.close();
               }
            }
         }
      }

      Iterator<? extends IPSAppViewMsg> psAppViewMsgs = iPSApplication.getAllPSAppViewMsgs();
      if (psAppViewMsgs != null) {
         while (psAppViewMsgs.hasNext()) {
            IPSAppViewMsg iPSAppViewMsg = psAppViewMsgs.next();
            Iterator<IPSPFAppObjectTempl> psPFAppTempls = iPSPFStyle.getPSPFAppObjectTempls("PSAPPVIEWMSG");
            if (psPFAppTempls != null) {
               while (psPFAppTempls.hasNext()) {
                  IPSPFAppObjectTempl iPSPFAppTempl = psPFAppTempls.next();
                  IPSPFAppObjectCodePublisher iPSPFAppCodePublisher = iPSPFAppTempl.getPSPFCodePublisher();
                  iPSPFAppCodePublisher.generateCode(psPublishContextImpl, iPSAppViewMsg);
                  iPSPFAppCodePublisher.close();
               }
            }
         }
      }

      Iterator<? extends IPSAppViewMsgGroup> psAppViewMsgGroups = iPSApplication.getAllPSAppViewMsgGroups();
      if (psAppViewMsgGroups != null) {
         while (psAppViewMsgGroups.hasNext()) {
            IPSAppViewMsgGroup iPSAppViewMsgGroup = psAppViewMsgGroups.next();
            Iterator<IPSPFAppObjectTempl> psPFAppTempls = iPSPFStyle.getPSPFAppObjectTempls("PSAPPVIEWMSGGROUP");
            if (psPFAppTempls != null) {
               while (psPFAppTempls.hasNext()) {
                  IPSPFAppObjectTempl iPSPFAppTempl = psPFAppTempls.next();
                  IPSPFAppObjectCodePublisher iPSPFAppCodePublisher = iPSPFAppTempl.getPSPFCodePublisher();
                  iPSPFAppCodePublisher.generateCode(psPublishContextImpl, iPSAppViewMsgGroup);
                  iPSPFAppCodePublisher.close();
               }
            }
         }
      }

      Iterator<IPSAppPFPluginRef> psAppPFPluginRefs = iPSApplication.getAllPSAppPFPluginRefs();
      if (psAppPFPluginRefs != null) {
         while (psAppPFPluginRefs.hasNext()) {
            IPSAppPFPluginRef iPSAppPFPluginRef = psAppPFPluginRefs.next();
            Iterator<IPSPFAppObjectTempl> psPFAppTempls = iPSPFStyle.getPSPFAppObjectTempls("PSAPPPFPLUGINREF");
            if (psPFAppTempls != null) {
               while (psPFAppTempls.hasNext()) {
                  IPSPFAppObjectTempl iPSPFAppTempl = psPFAppTempls.next();
                  IPSPFAppObjectCodePublisher iPSPFAppCodePublisher = iPSPFAppTempl.getPSPFCodePublisher();
                  iPSPFAppCodePublisher.generateCode(psPublishContextImpl, iPSAppPFPluginRef);
                  iPSPFAppCodePublisher.close();
               }
            }
         }
      }

      Iterator<IPSAppEditorStyleRef> psAppEditorStyleRefs = iPSApplication.getAllPSAppEditorStyleRefs();
      if (psAppEditorStyleRefs != null) {
         while (psAppEditorStyleRefs.hasNext()) {
            IPSAppEditorStyleRef iPSAppEditorStyleRef = psAppEditorStyleRefs.next();
            Iterator<IPSPFAppObjectTempl> psPFAppTempls = iPSPFStyle.getPSPFAppObjectTempls("PSAPPEDITORSTYLEREF");
            if (psPFAppTempls != null) {
               while (psPFAppTempls.hasNext()) {
                  IPSPFAppObjectTempl iPSPFAppTempl = psPFAppTempls.next();
                  IPSPFAppObjectCodePublisher iPSPFAppCodePublisher = iPSPFAppTempl.getPSPFCodePublisher();
                  iPSPFAppCodePublisher.generateCode(psPublishContextImpl, iPSAppEditorStyleRef);
                  iPSPFAppCodePublisher.close();
               }
            }
         }
      }

      Iterator<IPSAppSubViewTypeRef> psAppSubViewTypeRefs = iPSApplication.getAllPSAppSubViewTypeRefs();
      if (psAppSubViewTypeRefs != null) {
         while (psAppSubViewTypeRefs.hasNext()) {
            IPSAppSubViewTypeRef iPSAppSubViewTypeRef = psAppSubViewTypeRefs.next();
            Iterator<IPSPFAppObjectTempl> psPFAppTempls = iPSPFStyle.getPSPFAppObjectTempls("PSAPPSUBVIEWTYPEREF");
            if (psPFAppTempls != null) {
               while (psPFAppTempls.hasNext()) {
                  IPSPFAppObjectTempl iPSPFAppTempl = psPFAppTempls.next();
                  IPSPFAppObjectCodePublisher iPSPFAppCodePublisher = iPSPFAppTempl.getPSPFCodePublisher();
                  iPSPFAppCodePublisher.generateCode(psPublishContextImpl, iPSAppSubViewTypeRef);
                  iPSPFAppCodePublisher.close();
               }
            }
         }
      }

      return sBuilderEx.toString();
   }

   protected IPSApplication getPSApplication(PSSysApp psSysApp) throws Exception {
      if (this.getPSSysRunSession() != null && this.getPSSysRunSession().isRebuildMode()) {
         this.getPSModelStorage().resetPSDevSlnSys(this.psSysDevBKTask.getPSDEVSLNSYSID());
      }

      IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(this.psSysDevBKTask.getPSDEVSLNSYSID());
      IPSSystem iPSSystem = iPSDevSlnSys.getPSSystem(false);
      if (iPSSystem.getLoadedLevel() < this.getModelLoadLevel()) {
         iPSSystem = iPSDevSlnSys.reloadPSSystem(this.getModelLoadLevel());
      }

      IPSApplication iPSApplication = iPSSystem.getPSApplication(psSysApp.getPSSysAppId());
      if (iPSApplication.getLoadedLevel() < this.getModelLoadLevel()) {
         this.getPSModelHelper().startLoadPSSysApp(psSysApp.getPSSysAppId(), this.getModelLoadLevel());

         try {
            if (iPSApplication.getLoadedLevel() > IPSSystem.LOADLEVEL_NONE) {
               iPSSystem.resetPSApplication(psSysApp.getPSSysAppId());
               iPSApplication = iPSSystem.getPSApplication(psSysApp.getPSSysAppId());
            }

            iPSApplication.load(this.getModelLoadLevel());
            this.getPSModelHelper().stopLoadPSSysApp();
         } catch (Exception ex) {
            this.getPSModelHelper().stopLoadPSSysApp();
            throw ex;
         }
      }

      return iPSApplication;
   }

   protected void generateUserCode(PSSysApp psSysApp) throws Exception {
      IPSApplication iPSApplication = this.getPSApplication(psSysApp);
      if (this.getPSSysPubRuntime() != null) {
         this.getPSSysPubRuntime().registerPFPubFolder(iPSApplication, "USERCODE");
      }

      Iterator<IPSAppViewCode> psAppViewCodes = iPSApplication.getAllPSAppViewCodes();
      if (psAppViewCodes != null) {
         String strCodeFolder = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "CODEFOLDER", null);
         String strToolFolder = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "TOOLFOLDER", null);
         if (StringHelper.isNullOrEmpty(strCodeFolder)) {
            throw new Exception("没有定义代码发布目录");
         }

         while (psAppViewCodes.hasNext()) {
            IPSAppViewCode iPSAppViewCode = psAppViewCodes.next();
            if (iPSAppViewCode.getPSPFPubCode() == null) {
               String strFolder = strCodeFolder;
               strFolder = strFolder + File.separator + iPSApplication.getPSSystem().getPSDevCenterDomain();
               strFolder = strFolder + File.separator + iPSApplication.getPSSystem().getPubSystemId();
               strFolder = strFolder + File.separator + iPSApplication.getPSSystem().getVCName();
               strFolder = strFolder + File.separator + "app_" + iPSApplication.getWorkshopName();
               strFolder = strFolder + File.separator + "USERCODE";
               strFolder = strFolder + File.separator + iPSAppViewCode.getProjectType();
               if (!StringHelper.isNullOrEmpty(iPSAppViewCode.getFilePath())) {
                  strFolder = strFolder + File.separator + iPSAppViewCode.getFilePath();
               }

               strFolder = strFolder.replace("/", File.separator);
               File folder = new File(strFolder);
               if (!folder.exists()) {
                  folder.mkdirs();
               }

               String strFullPath = strFolder + File.separator + iPSAppViewCode.getName();
               if (strFullPath.length() >= PSTaskServerEnvImpl.getCurrent().getMaxFileNameLength()) {
                  String strInfo = StringHelper.format("发布代码[%1$s]路径过长[%2$s]，可能无法写入", strFullPath, strFullPath.length());
                  ((IPSSystemUtil)iPSApplication.getPSSystem()).log(4, iPSApplication, strInfo);
                  log.warn(strInfo);
                  this.log(4, null, strInfo);
                  if (PSTaskServerEnvImpl.getCurrent().isThrowExceptionWhenFileNameTooLong()) {
                     throw new Exception(StringHelper.format("发布代码[%1$s]名称长度超过[%2$s]", strFullPath, PSTaskServerEnvImpl.getCurrent().getMaxFileNameLength()));
                  }
               }

               if (this.getPSSysPubRuntime() != null) {
                  ((IPSSystemUtil)iPSApplication.getPSSystem())
                     .pubPFCode(this.getPSSysPubRuntime(), iPSApplication, "USERCODE", strFullPath, iPSAppViewCode.getUserCode(), null);
               } else {
                  ((IPSSystemUtil)iPSApplication.getPSSystem()).writeFile(strFullPath, iPSAppViewCode.getUserCode(), null);
               }
            }
         }
      }
   }

   private class TaskManager {
      private Vector<SA.SRFDA.PS.Data.PSAppView> psAppViewList = new Vector<>();
      private int nTotalCount = 0;
      private int nFinishCount = 0;
      private int nErrorCount = 0;
      private int nPubCount = 0;
      private StringBuilderEx errorBuilder = new StringBuilderEx();
      private ArrayList<PSSysAppDataCtrl.TaskManager.TaskThread> threads = new ArrayList<>();
      private IPSApplication iPSApplication = null;
      private IPSSystem iPSSystem = null;
      private IPSPF iPSPF = null;
      private IPSPFStyle iPSPFStyle = null;
      private boolean bPubViewCtrl = false;
      private Vector<IPSControlContainerView> psControlContainerViewList = new Vector<>();

      public TaskManager(
         IPSApplication iPSApplication, Vector<SA.SRFDA.PS.Data.PSAppView> psAppViewList, Vector<IPSControlContainerView> psControlContainerViewList
      ) throws Exception {
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

      public void start() throws Exception {
         for (IPSControlContainerView iPSControlContainerView : this.psControlContainerViewList) {
            this.generateViewCode(iPSControlContainerView);
         }

         this.nTotalCount = this.psAppViewList.size();
         if (this.nTotalCount != 0) {
            int nLoopCount = this.nTotalCount;
            if (nLoopCount > SysPFPubPSSysDevBKTaskImpl.this.getTaskThreadCount()) {
               nLoopCount = SysPFPubPSSysDevBKTaskImpl.this.getTaskThreadCount();
            }

            for (int i = 0; i < nLoopCount; i++) {
               SysPFPubPSSysDevBKTaskImpl.this.executeTask(new Runnable() {
                  @Override
                  public void run() {
                     while (TaskManager.this.runTask()) {
                     }
                  }
               });
            }

            while (true) {
               synchronized (this.psAppViewList) {
                  if (this.nTotalCount == this.nFinishCount) {
                     break;
                  }
               }

               Thread.sleep(50L);
            }

            this.threads.clear();
         }
      }

      public boolean runTask() {
         if (PSJITWebContext.getInstance() != null) {
            PSJITWebContext.setCurrent(null);
         }

         SA.SRFDA.PS.Data.PSAppView psAppView = null;
         synchronized (this.psAppViewList) {
            if (this.psAppViewList.size() <= 0) {
               return false;
            }

            psAppView = this.psAppViewList.remove(0);
         }

         try {
            if (this.generateViewCode(psAppView)) {
               synchronized (this.psAppViewList) {
                  this.nPubCount++;
               }
            }
         } catch (Exception ex) {
            String strErrorInfo = StringHelper.format("生成视图[%1$s]代码发生异常，%2$s", psAppView.getPSAPPVIEWNAME(), ex.getMessage());
            SysPFPubPSSysDevBKTaskImpl.log.error(strErrorInfo, ex);
            synchronized (this.errorBuilder) {
               this.errorBuilder.append(strErrorInfo);
            }

            synchronized (this.psAppViewList) {
               this.nErrorCount++;
               this.nPubCount++;
            }
         }

         synchronized (this.psAppViewList) {
            this.nFinishCount++;
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

      protected boolean generateViewCode(SA.SRFDA.PS.Data.PSAppView psAppView) throws Exception {
         IPSAppView iPSAppView = this.iPSApplication.getPSAppView(psAppView.getPSAPPVIEWID(), null);
         if (!StringHelper.isNullOrEmpty(iPSAppView.getSubAppFolderName())) {
            return false;
         } else {
            return this.iPSApplication.isPubRefViewOnly() && !iPSAppView.getRefFlag() ? false : this.generateViewCode(iPSAppView);
         }
      }

      protected boolean generateViewCode(IPSAppView iPSAppView) throws Exception {
         boolean bPubViewCode = true;
         if (iPSAppView instanceof IPSControlContainerView) {
            bPubViewCode = false;
         }

         if (bPubViewCode) {
            PSPublishContextImpl psPublishContextImpl = new PSPublishContextImpl(SysPFPubPSSysDevBKTaskImpl.this.getDAGlobalHelper(), null);
            psPublishContextImpl.setPSSysModelInstId(this.iPSSystem.getPSSysModelInstId());
            psPublishContextImpl.setPSLogItemList(SysPFPubPSSysDevBKTaskImpl.this.getPSLogItemList());
            HashMap<String, Object> params = new HashMap<>();
            IPSSysPubRuntime iPSSysPubRuntime = SysPFPubPSSysDevBKTaskImpl.this.getPSSysPubRuntime();
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
            PSPublishContextImpl psPublishContextImpl = new PSPublishContextImpl(SysPFPubPSSysDevBKTaskImpl.this.getDAGlobalHelper(), null);
            psPublishContextImpl.setPSSysModelInstId(this.iPSSystem.getPSSysModelInstId());
            psPublishContextImpl.setPSLogItemList(SysPFPubPSSysDevBKTaskImpl.this.getPSLogItemList());
            HashMap<String, Object> params = new HashMap<>();
            IPSSysPubRuntime iPSSysPubRuntime = SysPFPubPSSysDevBKTaskImpl.this.getPSSysPubRuntime();
            if (iPSSysPubRuntime != null) {
               params.put("syspub", iPSSysPubRuntime);
            }

            if (params.size() > 0) {
               psPublishContextImpl.setPubParams(params);
            }

            ArrayList<IPSControl> psControls = iPSAppView.getAllPSControls();
            Map<String, IPSControl> psControlMap = new HashMap<>();

            for (IPSControl iPSControl : psControls) {
               this.fillAllPSControls(iPSControl, psControlMap);
            }

            for (IPSControl iPSControl : psControlMap.values()) {
               Iterator<IPSPFCtrlTempl> psPFCtrlTempls = iPSAppView.getPSPFStyle().getPSPFCtrlTempls(iPSControl);

               while (psPFCtrlTempls.hasNext()) {
                  IPSPFCtrlTempl iPSPFCtrlTempl = psPFCtrlTempls.next();
                  IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher = iPSPFCtrlTempl.getPSPFCtrlCodePublisher();
                  if (iPSPFCtrlCodePublisher instanceof IPSPFCtrlCodePublisher2) {
                     ((IPSPFCtrlCodePublisher2)iPSPFCtrlCodePublisher).generateCode2(psPublishContextImpl, iPSControl);
                  }

                  iPSPFCtrlCodePublisher.close();
               }
            }
         }

         return true;
      }

      protected void fillAllPSControls(IPSControl iPSControl, Map<String, IPSControl> psControlMap) throws Exception {
         String strPSControlId = iPSControl.getId();
         if (StringHelper.isNullOrEmpty(strPSControlId)) {
            strPSControlId = KeyValueHelper.genGuidEx();
         }

         strPSControlId = KeyValueHelper.genUniqueId(iPSControl.getControlType(), strPSControlId);
         if (!psControlMap.containsKey(strPSControlId)) {
            psControlMap.put(strPSControlId, iPSControl);
            if (iPSControl instanceof IPSControlContainer) {
               IPSControlContainer iPSControlContainer = (IPSControlContainer)iPSControl;
               Iterator<IPSLayoutPanel> psLayoutPanels = iPSControlContainer.getPSLayoutPanels();
               if (psLayoutPanels != null) {
                  while (psLayoutPanels.hasNext()) {
                     IPSLayoutPanel iPSLayoutPanel = psLayoutPanels.next();
                     strPSControlId = iPSLayoutPanel.getId();
                     if (StringHelper.isNullOrEmpty(strPSControlId)) {
                        strPSControlId = KeyValueHelper.genGuidEx();
                     }

                     strPSControlId = KeyValueHelper.genUniqueId(iPSLayoutPanel.getControlType(), strPSControlId);
                     if (!psControlMap.containsKey(strPSControlId)) {
                        psControlMap.put(strPSControlId, iPSLayoutPanel);
                        Iterator<IPSControl> childPSControls = iPSLayoutPanel.getPSControls();
                        if (childPSControls != null) {
                           while (childPSControls.hasNext()) {
                              this.fillAllPSControls(childPSControls.next(), psControlMap);
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }
}
