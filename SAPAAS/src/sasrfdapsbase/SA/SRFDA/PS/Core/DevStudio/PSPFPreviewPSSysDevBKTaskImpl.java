/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.config.entity.PSPFPreviewNode
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSPFPreviewAction
 *  net.ibizsys.pscore.srv.sysdesign.service.PSPFPreviewActionService
 *  net.ibizsys.pscore.srv.util.PSModelV2Helper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.App.View.IPSAppIndexView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewPreview;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.App.View.PSAppDECtrlPreviewViewImpl;
import SA.SRFDA.PS.Core.App.View.PSAppDEFormPreviewViewImpl;
import SA.SRFDA.PS.Core.App.View.PSAppDEGridPreviewViewImpl;
import SA.SRFDA.PS.Core.App.View.PSAppViewImpl;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenuItem;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DevStudio.PSSysDevBKTaskImplBase;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSDevSlnSysDynaInst;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFAppTempl;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlTempl;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PF.IPSPFViewTempl;
import SA.SRFDA.PS.Core.PSSystemUtil;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.Pub.IPSPFAppCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlCodePublisher2;
import SA.SRFDA.PS.Core.Pub.IPSPFViewCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSPublishContextImpl;
import SA.SRFDA.PS.Core.ResMgr.PSPFPreviewNodeGlobal;
import SA.SRFDA.PS.Core.Util.FileWriterHelper;
import SA.SRFDA.PS.Core.View.IPSViewType;
import SA.SRFDA.PS.Data.PSAppView;
import SA.SRFDA.PS.Data.PSAppViewCode;
import SA.SRFDA.PS.Data.PSDEDataView;
import SA.SRFDA.PS.Data.PSDEForm;
import SA.SRFDA.PS.Data.PSDEGrid;
import SA.SRFDA.PS.Data.PSDEList;
import SA.SRFDA.PS.Data.PSDEToolbar;
import SA.SRFDA.PS.Data.PSDEViewBase;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import SA.SRFDA.PS.Data.PSSysPanel;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSPFPreviewNode;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPFPreviewAction;
import net.ibizsys.pscore.srv.sysdesign.service.PSPFPreviewActionService;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSPFPreviewPSSysDevBKTaskImpl
extends PSSysDevBKTaskImplBase {
    private static final Log log = LogFactory.getLog(PSPFPreviewPSSysDevBKTaskImpl.class);

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected String onRun() throws Exception {
        boolean bPFPriviewUseModel;
        String strPreviewPSPFId;
        String strViewCodeName;
        String strIndexFile;
        String strPubFolder;
        String strPSDSConsoleId;
        PSPFPreviewAction psPFPreviewAction2;
        PSPFPreviewAction psPFPreviewAction;
        PSPFPreviewActionService psPFPreviewActionService;
        block120: {
            psPFPreviewActionService = (PSPFPreviewActionService)ServiceGlobal.getService(PSPFPreviewActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            psPFPreviewAction = new PSPFPreviewAction();
            psPFPreviewAction2 = new PSPFPreviewAction();
            psPFPreviewAction.setPSPFPreviewActionId(this.getTaskParam());
            psPFPreviewActionService.get(psPFPreviewAction);
            String strPSDynaInstId = psPFPreviewAction.getPSDynaInstId();
            String strPSDevSlnSysId = psPFPreviewAction.getPSDevSlnSysId();
            String strPSSysAppId = psPFPreviewAction.getActionParam();
            strPSDSConsoleId = psPFPreviewAction.getPSDSConsoleId();
            if (StringHelper.IsNullOrEmpty((String)strPSDSConsoleId)) {
                strPSDSConsoleId = !StringHelper.IsNullOrEmpty((String)strPSDynaInstId) ? strPSDynaInstId : strPSDevSlnSysId;
            }
            if (StringHelper.IsNullOrEmpty((String)strPSDevSlnSysId) && StringHelper.IsNullOrEmpty((String)strPSDynaInstId)) {
                throw new Exception("\u4f20\u5165\u5f00\u53d1\u7cfb\u7edf\u6807\u8bc6\u65e0\u6548");
            }
            psPFPreviewAction2.reset();
            psPFPreviewAction2.setPSPFPreviewActionId(this.getTaskParam());
            psPFPreviewAction2.setActionState(Integer.valueOf(20));
            psPFPreviewAction2.setPreviewStep("\u51c6\u5907\u751f\u6210\u9884\u89c8\u6587\u4ef6\uff0c\u6b63\u5728\u52a0\u8f7d\u7cfb\u7edf\u6a21\u578b");
            psPFPreviewAction2.setPSDSConsoleId(strPSDSConsoleId);
            psPFPreviewActionService.update(psPFPreviewAction2, false);
            IPSSystem iPSSystem = null;
            IPSApplication iPSApplication = null;
            boolean bMobileApp = false;
            if (!this.isCancel()) {
                try {
                    iPSSystem = this.getPSSystem(strPSDevSlnSysId, strPSDynaInstId, null);
                    if (StringHelper.IsNullOrEmpty((String)strPSSysAppId)) {
                        Iterator<IPSApplication> psApplications;
                        boolean bTestAppType = false;
                        boolean bMobile = false;
                        boolean bAutoAddView = false;
                        if (StringHelper.Compare((String)psPFPreviewAction.getPSObjType(), (String)"PSDEVIEWBASE", (boolean)true) == 0) {
                            PSDEViewBase psDEViewBase = new PSDEViewBase();
                            CallResult callResult = this.getPSModelHelper(iPSSystem.getPSSysModelInstId()).getPSDEViewBase(psPFPreviewAction.getPSObjId(), psDEViewBase);
                            if (callResult.isError()) {
                                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u89c6\u56fe"));
                            }
                            bTestAppType = true;
                            bMobile = psDEViewBase.getPSDEVIEWBASETYPE().indexOf("DEMOB") == 0;
                            boolean bl = bAutoAddView = !StringHelper.IsNullOrEmpty((String)strPSDynaInstId);
                        }
                        if ((psApplications = iPSSystem.getAllPSApps()) != null) {
                            while (psApplications.hasNext()) {
                                IPSApplication iPSApplication2 = psApplications.next();
                                if (iPSApplication2.getDefaultFlag()) {
                                    if (bTestAppType) {
                                        if (bMobile) {
                                            if (!iPSApplication2.getPSPF().getPSAppType().isMobileApp()) continue;
                                            strPSSysAppId = iPSApplication2.getId();
                                            break;
                                        }
                                        if (iPSApplication2.getPSPF().getPSAppType().isMobileApp()) continue;
                                        strPSSysAppId = iPSApplication2.getId();
                                        break;
                                    }
                                    strPSSysAppId = iPSApplication2.getId();
                                    break;
                                }
                                if (bTestAppType) {
                                    if (bMobile) {
                                        if (!iPSApplication2.getPSPF().getPSAppType().isMobileApp() || bAutoAddView && !iPSApplication2.isAutoAddAppDEView()) continue;
                                        strPSSysAppId = iPSApplication2.getId();
                                        continue;
                                    }
                                    if (iPSApplication2.getPSPF().getPSAppType().isMobileApp() || bAutoAddView && !iPSApplication2.isAutoAddAppDEView()) continue;
                                    strPSSysAppId = iPSApplication2.getId();
                                    continue;
                                }
                                if (!StringHelper.IsNullOrEmpty((String)strPSSysAppId)) continue;
                                strPSSysAppId = iPSApplication2.getId();
                            }
                        }
                        if (StringHelper.IsNullOrEmpty((String)strPSSysAppId)) {
                            throw new Exception("\u5f53\u524d\u7cfb\u7edf\u4e0d\u5b58\u5728\u4efb\u4f55\u524d\u7aef\u5e94\u7528\uff0c\u5fc5\u987b\u5148\u5efa\u7acb\u524d\u7aef\u5e94\u7528\u624d\u80fd\u8fdb\u884c\u524d\u7aef\u9884\u89c8\u4f5c\u4e1a");
                        }
                    }
                    iPSApplication = this.getPSApplication(iPSSystem, strPSSysAppId);
                    bMobileApp = iPSApplication.getPSPF().getPSAppType().isMobileApp();
                }
                catch (Exception ex) {
                    psPFPreviewActionService = (PSPFPreviewActionService)ServiceGlobal.getService(PSPFPreviewActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                    psPFPreviewAction2.reset();
                    psPFPreviewAction2.setPSPFPreviewActionId(this.getTaskParam());
                    psPFPreviewAction2.setActionState(Integer.valueOf(40));
                    psPFPreviewAction2.setActionResult(StringHelper.Format((String)"\u52a0\u8f7d\u7cfb\u7edf\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
                    psPFPreviewAction2.setPSDSConsoleId(strPSDSConsoleId);
                    psPFPreviewActionService.update(psPFPreviewAction2, false);
                    throw ex;
                }
            } else {
                psPFPreviewActionService = (PSPFPreviewActionService)ServiceGlobal.getService(PSPFPreviewActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                psPFPreviewAction2.reset();
                psPFPreviewAction2.setPSPFPreviewActionId(this.getTaskParam());
                psPFPreviewAction2.setActionState(Integer.valueOf(40));
                psPFPreviewAction2.setActionResult("\u4f5c\u4e1a\u88ab\u53d6\u6d88");
                psPFPreviewAction2.setPSDSConsoleId(strPSDSConsoleId);
                psPFPreviewActionService.update(psPFPreviewAction2, false);
                return null;
            }
            strPubFolder = null;
            strIndexFile = null;
            strViewCodeName = StringHelper.Format((String)"v%1$s", (Object)KeyValueHelper.genUniqueId((String)KeyValueHelper.genGuidEx()));
            String strModelType = psPFPreviewAction.getPSObjType();
            String strRealModelId = "";
            IPSPFStyle iPSPFStyle = null;
            strPreviewPSPFId = null;
            bPFPriviewUseModel = PSTaskServerEnvImpl.getCurrent().isPFPreviewUseModel();
            if (iPSSystem.isDynaInstMode()) {
                bPFPriviewUseModel = true;
            }
            if (!bPFPriviewUseModel) {
                strPreviewPSPFId = "VUE_PREVIEW_PC";
                String strPreviewPSPFStyleId = "VUE_PREVIEW_PC_STYLE1";
                if (bMobileApp) {
                    strPreviewPSPFId = "VUE_PREVIEW_MOB";
                    strPreviewPSPFStyleId = "VUE_PREVIEW_MOB_STYLE1";
                }
                IPSPF iPSPF = this.getPSModelStorage().getPSPF(strPreviewPSPFId);
                iPSPFStyle = iPSPF.getPSPFStyle(strPreviewPSPFStyleId);
                psPFPreviewActionService = (PSPFPreviewActionService)ServiceGlobal.getService(PSPFPreviewActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                psPFPreviewAction2.reset();
                psPFPreviewAction2.setPSPFPreviewActionId(this.getTaskParam());
                psPFPreviewAction2.setPSDSConsoleId(strPSDSConsoleId);
                if (bMobileApp) {
                    psPFPreviewAction2.setPreviewInfo(StringHelper.Format((String)"iBiz\u79fb\u52a8\u7aef\u5e94\u7528\u52a8\u6001\u9884\u89c8\u57fa\u4e8e[%1$s/%2$s]", (Object)iPSPF.getName(), (Object)iPSPFStyle.getName()));
                } else {
                    psPFPreviewAction2.setPreviewInfo(StringHelper.Format((String)"iBiz\u684c\u9762\u7aef\u5e94\u7528\u52a8\u6001\u9884\u89c8\u57fa\u4e8e[%1$s/%2$s]", (Object)iPSPF.getName(), (Object)iPSPFStyle.getName()));
                }
                psPFPreviewActionService.update(psPFPreviewAction2, false);
            }
            if (!this.isCancel()) {
                IPSAppView iPSAppView;
                block119: {
                    iPSAppView = null;
                    try {
                        PSAppDEFormPreviewViewImpl psAppDEFormPreviewViewImpl;
                        PSDEViewCtrl psDEViewCtrl;
                        IPSDataEntity iPSDataEntity;
                        CallResult callResult;
                        CallResult callResult2;
                        PSAppView psAppView;
                        if (StringHelper.Compare((String)psPFPreviewAction.getPSObjType(), (String)"PSAPPINDEXVIEW", (boolean)true) == 0 || StringHelper.Compare((String)psPFPreviewAction.getPSObjType(), (String)"PSAPPPANELVIEW", (boolean)true) == 0 || StringHelper.Compare((String)psPFPreviewAction.getPSObjType(), (String)"PSAPPPORTALVIEW", (boolean)true) == 0 || StringHelper.Compare((String)psPFPreviewAction.getPSObjType(), (String)"PSAPPDEVIEW", (boolean)true) == 0 || StringHelper.Compare((String)psPFPreviewAction.getPSObjType(), (String)"PSAPPUTILVIEW", (boolean)true) == 0) {
                            if (iPSSystem.isDynaInstMode()) {
                                iPSAppView = iPSApplication.getPSAppView(psPFPreviewAction.getPSObjId(), false);
                            } else {
                                psAppView = new PSAppView();
                                callResult2 = this.getPSModelHelper(iPSSystem.getPSSysModelInstId()).getPSApplicationView(psPFPreviewAction.getPSObjId(), psAppView);
                                if (callResult2.isError()) {
                                    throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u89c6\u56fe[%1$s],%2$s", (Object)psPFPreviewAction.getPSObjId(), (Object)callResult2.getErrorInfo()));
                                }
                                strRealModelId = psAppView.getParamStringValue("SRFORIKEY", psPFPreviewAction.getPSObjId());
                                psAppView.setPSAPPVIEWID(psPFPreviewAction.getPSObjId());
                                psAppView.setPSAPPVIEWNAME(strViewCodeName);
                                IPSAppView iPSAppView2 = this.createPSAppView(psAppView);
                                if (iPSAppView2 instanceof IPSAppViewPreview) {
                                    IPSAppViewPreview iPSAppViewPreview = (IPSAppViewPreview)((Object)iPSAppView2);
                                    if (!bPFPriviewUseModel) {
                                        iPSAppViewPreview.setPSPFStyle(iPSPFStyle);
                                    }
                                    iPSAppViewPreview.initPreview(this.getDAGlobalHelper(), iPSApplication, psAppView, null, 2);
                                    iPSAppView = iPSAppView2;
                                }
                            }
                            break block119;
                        }
                        if (StringHelper.Compare((String)psPFPreviewAction.getPSObjType(), (String)"PSDEVIEWBASE", (boolean)true) == 0) {
                            if (!StringHelper.IsNullOrEmpty((String)strPSDynaInstId)) {
                                Iterator<IPSAppView> psAppViews = iPSApplication.getAllPSAppViews();
                                if (psAppViews == null) break block119;
                                while (psAppViews.hasNext()) {
                                    IPSAppDEView iPSAppDEView;
                                    IPSAppView iPSAppView2 = psAppViews.next();
                                    if (!(iPSAppView2 instanceof IPSAppDEView) || StringHelper.Compare((String)(iPSAppDEView = (IPSAppDEView)iPSAppView2).getPSDEViewId(), (String)psPFPreviewAction.getPSObjId(), (boolean)false) != 0) continue;
                                    iPSAppView = iPSAppView2;
                                    break block119;
                                }
                                break block119;
                            }
                            PSDEViewBase psDEViewBase = new PSDEViewBase();
                            callResult2 = this.getPSModelHelper(iPSSystem.getPSSysModelInstId()).getPSDEViewBase(psPFPreviewAction.getPSObjId(), psDEViewBase);
                            if (callResult2.isError()) {
                                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u89c6\u56fe"));
                            }
                            strRealModelId = psDEViewBase.getParamStringValue("SRFORIKEY", psPFPreviewAction.getPSObjId());
                            PSAppView psAppView2 = new PSAppView();
                            psAppView2.setPSAPPVIEWID(psPFPreviewAction.getPSObjId());
                            psAppView2.setPSAPPVIEWNAME(strViewCodeName);
                            psAppView2.setPSDEVIEWBASEID(psDEViewBase.getPSDEVIEWBASEID());
                            psAppView2.setPSDEVIEWBASENAME(psDEViewBase.getPSDEVIEWBASENAME());
                            IPSViewType iPSViewType = this.getPSModelStorage().getPSViewType(psDEViewBase.getPSDEVIEWBASETYPE());
                            IPSAppView iPSAppView2 = iPSViewType.createPSAppView(psAppView2);
                            if (iPSAppView2 instanceof IPSAppViewPreview) {
                                IPSAppViewPreview iPSAppViewPreview = (IPSAppViewPreview)((Object)iPSAppView2);
                                if (!bPFPriviewUseModel) {
                                    iPSAppViewPreview.setPSPFStyle(iPSPFStyle);
                                }
                                iPSAppViewPreview.initPreview(this.getDAGlobalHelper(), iPSApplication, psAppView2, null, 2);
                                iPSAppView = iPSAppView2;
                            }
                            break block119;
                        }
                        if (StringHelper.Compare((String)psPFPreviewAction.getPSObjType(), (String)"PSDEGRID", (boolean)true) == 0) {
                            psAppView = new PSAppView();
                            psAppView.setPSAPPVIEWID(strViewCodeName);
                            psAppView.setPSAPPVIEWNAME(strViewCodeName);
                            PSDEGrid psDEGrid = new PSDEGrid();
                            callResult = this.getPSModelHelper(iPSSystem.getPSSysModelInstId()).getPSDEGrid(psPFPreviewAction.getPSObjId(), psDEGrid);
                            if (callResult.isError()) {
                                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u8868\u683c"));
                            }
                            strRealModelId = psDEGrid.getParamStringValue("SRFORIKEY", psPFPreviewAction.getPSObjId());
                            iPSDataEntity = iPSSystem.getPSDataEntity(psDEGrid.getPSDEID(), false);
                            if (iPSDataEntity == null) {
                                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53[%1$s]", (Object)psDEGrid.getPSDEID()));
                            }
                            psDEViewCtrl = new PSDEViewCtrl();
                            psDEViewCtrl.setPSDEVIEWCTRLNAME("grid");
                            psDEViewCtrl.setPSDEVIEWCTRLTYPE("GRID");
                            psDEViewCtrl.setPSDEGRIDID(psDEGrid.getPSDEGRIDID());
                            psDEViewCtrl.setPSDEGRIDNAME(psDEGrid.getPSDEGRIDNAME());
                            psDEViewCtrl.setCTRLPARAM6(true);
                            PSAppDEGridPreviewViewImpl psAppDEGridPreviewViewImpl = new PSAppDEGridPreviewViewImpl();
                            if (!bPFPriviewUseModel) {
                                psAppDEGridPreviewViewImpl.setPSPFStyle(iPSPFStyle);
                            }
                            psAppDEGridPreviewViewImpl.setPSViewType(this.getPSModelStorage().getPSViewType("DEGRIDVIEW"));
                            psAppDEGridPreviewViewImpl.setV2Preview(true);
                            psAppDEGridPreviewViewImpl.init(this.getDAGlobalHelper(), iPSApplication, psAppView, iPSDataEntity, psDEViewCtrl);
                            iPSAppView = psAppDEGridPreviewViewImpl;
                        } else if (StringHelper.Compare((String)psPFPreviewAction.getPSObjType(), (String)"PSDEFORM", (boolean)true) == 0) {
                            psAppView = new PSAppView();
                            psAppView.setPSAPPVIEWID(strViewCodeName);
                            psAppView.setPSAPPVIEWNAME(strViewCodeName);
                            PSDEForm psDEForm = new PSDEForm();
                            callResult = this.getPSModelHelper(iPSSystem.getPSSysModelInstId()).getPSDEForm(psPFPreviewAction.getPSObjId(), psDEForm);
                            if (callResult.isError()) {
                                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u8868\u5355"));
                            }
                            strRealModelId = psDEForm.getParamStringValue("SRFORIKEY", psPFPreviewAction.getPSObjId());
                            iPSDataEntity = iPSSystem.getPSDataEntity(psDEForm.getPSDEID(), false);
                            if (iPSDataEntity == null) {
                                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53[%1$s]", (Object)psDEForm.getPSDEID()));
                            }
                            psDEViewCtrl = new PSDEViewCtrl();
                            psDEViewCtrl.setPSDEVIEWCTRLNAME("form");
                            psDEViewCtrl.setPSDEVIEWCTRLTYPE("FORM");
                            psDEViewCtrl.setPSDEFORMID(psDEForm.getPSDEFORMID());
                            psDEViewCtrl.setPSDEFORMNAME(psDEForm.getPSDEFORMNAME());
                            psAppDEFormPreviewViewImpl = new PSAppDEFormPreviewViewImpl();
                            if (!bPFPriviewUseModel) {
                                psAppDEFormPreviewViewImpl.setPSPFStyle(iPSPFStyle);
                            }
                            psAppDEFormPreviewViewImpl.setPSViewType(this.getPSModelStorage().getPSViewType(bMobileApp ? "DEMOBEDITVIEW" : "DEEDITVIEW"));
                            psAppDEFormPreviewViewImpl.setV2Preview(true);
                            psAppDEFormPreviewViewImpl.init(this.getDAGlobalHelper(), iPSApplication, psAppView, iPSDataEntity, psDEViewCtrl);
                            iPSAppView = psAppDEFormPreviewViewImpl;
                        } else if (StringHelper.Compare((String)psPFPreviewAction.getPSObjType(), (String)"PSDETOOLBAR", (boolean)true) == 0) {
                            psAppView = new PSAppView();
                            psAppView.setPSAPPVIEWID(strViewCodeName);
                            psAppView.setPSAPPVIEWNAME(strViewCodeName);
                            PSDEToolbar psDEToolbar = new PSDEToolbar();
                            callResult = this.getPSModelHelper(iPSSystem.getPSSysModelInstId()).getPSDEToolbar(psPFPreviewAction.getPSObjId(), psDEToolbar);
                            if (callResult.isError()) {
                                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5de5\u5177\u680f"));
                            }
                            strRealModelId = psDEToolbar.getParamStringValue("SRFORIKEY", psPFPreviewAction.getPSObjId());
                            iPSDataEntity = null;
                            if (StringHelper.IsNullOrEmpty((String)psDEToolbar.getPSDEID())) {
                                Iterator<IPSDataEntity> psDataEntities;
                                Iterator<IPSAppDataEntity> psAppDataEntities = iPSApplication.getAllPSAppDataEntities();
                                if (psAppDataEntities != null) {
                                    while (psAppDataEntities.hasNext()) {
                                        IPSAppDataEntity iPSAppDataEntity = psAppDataEntities.next();
                                        iPSDataEntity = iPSAppDataEntity.getPSDE();
                                        if (iPSDataEntity != null) break;
                                    }
                                }
                                if (iPSDataEntity != null && (psDataEntities = iPSSystem.getAllPSDataEntities()) != null) {
                                    while (psDataEntities.hasNext()) {
                                        iPSDataEntity = psDataEntities.next();
                                        if (iPSDataEntity == null) {
                                            continue;
                                        }
                                        break;
                                    }
                                }
                            } else {
                                iPSDataEntity = iPSSystem.getPSDataEntity(psDEToolbar.getPSDEID(), false);
                                if (iPSDataEntity == null) {
                                    throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53[%1$s]", (Object)psDEToolbar.getPSDEID()));
                                }
                            }
                            if (iPSDataEntity != null) {
                                psDEViewCtrl = new PSDEViewCtrl();
                                psDEViewCtrl.setPSDEVIEWCTRLNAME("toolbar");
                                psDEViewCtrl.setPSDEVIEWCTRLTYPE("TOOLBAR");
                                psDEViewCtrl.setPSDETOOLBARID(psDEToolbar.getPSDETOOLBARID());
                                psDEViewCtrl.setPSDETOOLBARNAME(psDEToolbar.getPSDETOOLBARNAME());
                                PSAppDECtrlPreviewViewImpl psAppDECtrlPreviewViewImpl = new PSAppDECtrlPreviewViewImpl();
                                if (!bPFPriviewUseModel) {
                                    psAppDECtrlPreviewViewImpl.setPSPFStyle(iPSPFStyle);
                                }
                                psAppDECtrlPreviewViewImpl.setPSViewType(this.getPSModelStorage().getPSViewType(bMobileApp ? "DEMOBCUSTOMVIEW" : "DECUSTOMVIEW"));
                                psAppDECtrlPreviewViewImpl.setV2Preview(true);
                                psAppDECtrlPreviewViewImpl.init(this.getDAGlobalHelper(), iPSApplication, psAppView, iPSDataEntity, psDEViewCtrl);
                                iPSAppView = psAppDECtrlPreviewViewImpl;
                            }
                        } else if (StringHelper.Compare((String)psPFPreviewAction.getPSObjType(), (String)"PSSYSVIEWPANEL", (boolean)true) == 0) {
                            psAppView = new PSAppView();
                            psAppView.setPSAPPVIEWID(strViewCodeName);
                            psAppView.setPSAPPVIEWNAME(strViewCodeName);
                            PSSysPanel psSysPanel = new PSSysPanel();
                            callResult = this.getPSModelHelper(iPSSystem.getPSSysModelInstId()).getPSSysPanel(psPFPreviewAction.getPSObjId(), psSysPanel);
                            if (callResult.isError()) {
                                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u9762\u677f\u90e8\u4ef6"));
                            }
                            strRealModelId = psSysPanel.getParamStringValue("SRFORIKEY", psPFPreviewAction.getPSObjId());
                            iPSDataEntity = iPSSystem.getPSDataEntity(psSysPanel.getPSDEID(), false);
                            if (iPSDataEntity == null) {
                                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53[%1$s]", (Object)psSysPanel.getPSDEID()));
                            }
                            psDEViewCtrl = new PSDEViewCtrl();
                            psDEViewCtrl.setPSDEVIEWCTRLNAME("panel");
                            psDEViewCtrl.setPSDEVIEWCTRLTYPE("PANEL");
                            psDEViewCtrl.setPSSYSVIEWPANELID(psSysPanel.getPSSYSVIEWPANELID());
                            psDEViewCtrl.setPSSYSVIEWPANELNAME(psSysPanel.getPSSYSVIEWPANELNAME());
                            psAppDEFormPreviewViewImpl = new PSAppDEFormPreviewViewImpl();
                            if (!bPFPriviewUseModel) {
                                psAppDEFormPreviewViewImpl.setPSPFStyle(iPSPFStyle);
                            }
                            psAppDEFormPreviewViewImpl.setPSViewType(this.getPSModelStorage().getPSViewType(bMobileApp ? "DEMOBPANELVIEW" : "DEPANELVIEW"));
                            psAppDEFormPreviewViewImpl.setV2Preview(true);
                            psAppDEFormPreviewViewImpl.init(this.getDAGlobalHelper(), iPSApplication, psAppView, iPSDataEntity, psDEViewCtrl);
                            iPSAppView = psAppDEFormPreviewViewImpl;
                        } else if (StringHelper.Compare((String)psPFPreviewAction.getPSObjType(), (String)"PSDELIST", (boolean)true) == 0) {
                            psAppView = new PSAppView();
                            psAppView.setPSAPPVIEWID(strViewCodeName);
                            psAppView.setPSAPPVIEWNAME(strViewCodeName);
                            PSDEList psDEList = new PSDEList();
                            callResult = this.getPSModelHelper(iPSSystem.getPSSysModelInstId()).getPSDEList(psPFPreviewAction.getPSObjId(), psDEList);
                            if (callResult.isError()) {
                                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5217\u8868"));
                            }
                            strRealModelId = psDEList.getParamStringValue("SRFORIKEY", psPFPreviewAction.getPSObjId());
                            iPSDataEntity = iPSSystem.getPSDataEntity(psDEList.getPSDEID(), false);
                            if (iPSDataEntity == null) {
                                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53[%1$s]", (Object)psDEList.getPSDEID()));
                            }
                            psDEViewCtrl = new PSDEViewCtrl();
                            if (bMobileApp) {
                                psDEViewCtrl.setPSDEVIEWCTRLNAME("mdctrl");
                                psDEViewCtrl.setPSDEVIEWCTRLTYPE("MOBMDCTRL");
                                psDEViewCtrl.setPSDELISTID(psDEList.getPSDELISTID());
                                psDEViewCtrl.setPSDELISTNAME(psDEList.getPSDELISTNAME());
                            } else {
                                psDEViewCtrl.setPSDEVIEWCTRLNAME("list");
                                psDEViewCtrl.setPSDEVIEWCTRLTYPE("LIST");
                                psDEViewCtrl.setPSDELISTID(psDEList.getPSDELISTID());
                                psDEViewCtrl.setPSDELISTNAME(psDEList.getPSDELISTNAME());
                            }
                            PSAppDEFormPreviewViewImpl psAppDEListPreviewViewImpl = new PSAppDEFormPreviewViewImpl();
                            if (!bPFPriviewUseModel) {
                                psAppDEListPreviewViewImpl.setPSPFStyle(iPSPFStyle);
                            }
                            psAppDEListPreviewViewImpl.setPSViewType(this.getPSModelStorage().getPSViewType(bMobileApp ? "DEMOBMDVIEW" : "DELISTVIEW"));
                            psAppDEListPreviewViewImpl.setV2Preview(true);
                            psAppDEListPreviewViewImpl.init(this.getDAGlobalHelper(), iPSApplication, psAppView, iPSDataEntity, psDEViewCtrl);
                            iPSAppView = psAppDEListPreviewViewImpl;
                        } else if (StringHelper.Compare((String)psPFPreviewAction.getPSObjType(), (String)"PSDEDATAVIEW", (boolean)true) == 0) {
                            psAppView = new PSAppView();
                            psAppView.setPSAPPVIEWID(strViewCodeName);
                            psAppView.setPSAPPVIEWNAME(strViewCodeName);
                            PSDEDataView psDEDataView = new PSDEDataView();
                            callResult = this.getPSModelHelper(iPSSystem.getPSSysModelInstId()).getPSDEDataView(psPFPreviewAction.getPSObjId(), psDEDataView);
                            if (callResult.isError()) {
                                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5361\u7247\u89c6\u56fe"));
                            }
                            strRealModelId = psDEDataView.getParamStringValue("SRFORIKEY", psPFPreviewAction.getPSObjId());
                            iPSDataEntity = iPSSystem.getPSDataEntity(psDEDataView.getPSDEID(), false);
                            if (iPSDataEntity == null) {
                                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53[%1$s]", (Object)psDEDataView.getPSDEID()));
                            }
                            psDEViewCtrl = new PSDEViewCtrl();
                            if (bMobileApp) {
                                psDEViewCtrl.setPSDEVIEWCTRLNAME("dataview");
                                psDEViewCtrl.setPSDEVIEWCTRLTYPE("DATAVIEW");
                                psDEViewCtrl.setPSDEDATAVIEWID(psDEDataView.getPSDEDATAVIEWID());
                                psDEViewCtrl.setPSDEDATAVIEWNAME(psDEDataView.getPSDEDATAVIEWNAME());
                            } else {
                                psDEViewCtrl.setPSDEVIEWCTRLNAME("dataview");
                                psDEViewCtrl.setPSDEVIEWCTRLTYPE("DATAVIEW");
                                psDEViewCtrl.setPSDEDATAVIEWID(psDEDataView.getPSDEDATAVIEWID());
                                psDEViewCtrl.setPSDEDATAVIEWNAME(psDEDataView.getPSDEDATAVIEWNAME());
                            }
                            PSAppDEFormPreviewViewImpl psAppDEDataViewPreviewViewImpl = new PSAppDEFormPreviewViewImpl();
                            if (!bPFPriviewUseModel) {
                                psAppDEDataViewPreviewViewImpl.setPSPFStyle(iPSPFStyle);
                            }
                            psAppDEDataViewPreviewViewImpl.setPSViewType(this.getPSModelStorage().getPSViewType(bMobileApp ? "DEMOBDATAVIEW" : "DEDATAVIEW"));
                            psAppDEDataViewPreviewViewImpl.setV2Preview(true);
                            psAppDEDataViewPreviewViewImpl.init(this.getDAGlobalHelper(), iPSApplication, psAppView, iPSDataEntity, psDEViewCtrl);
                            iPSAppView = psAppDEDataViewPreviewViewImpl;
                        }
                    }
                    catch (Exception ex) {
                        psPFPreviewActionService = (PSPFPreviewActionService)ServiceGlobal.getService(PSPFPreviewActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                        psPFPreviewAction2.reset();
                        psPFPreviewAction2.setPSPFPreviewActionId(this.getTaskParam());
                        psPFPreviewAction2.setActionState(Integer.valueOf(40));
                        psPFPreviewAction2.setActionResult(StringHelper.Format((String)"\u52a0\u8f7d\u89c6\u56fe\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
                        psPFPreviewAction2.setPSDSConsoleId(strPSDSConsoleId);
                        psPFPreviewActionService.update(psPFPreviewAction2, false);
                        throw ex;
                    }
                }
                try {
                    if (iPSAppView != null) {
                        if (!bPFPriviewUseModel) {
                            PSPublishContextImpl psPublishContextImpl;
                            ArrayList<PSAppViewCode> psAppViewCodeList2 = new ArrayList<PSAppViewCode>();
                            ArrayList<IPSAppView> relatedAppViewList2 = new ArrayList<IPSAppView>();
                            ArrayList<PSAppView> relatedAppViewList = new ArrayList<PSAppView>();
                            if (iPSAppView instanceof IPSAppIndexView) {
                                if (bMobileApp) {
                                    Iterator<IPSAppMenuItem> appMenuItems;
                                    HashMap<String, String> psAppViewMap = new HashMap<String, String>();
                                    IPSAppIndexView iPSAppIndexView = (IPSAppIndexView)iPSAppView;
                                    if (iPSAppIndexView.getPSAppMenu() != null && (appMenuItems = iPSAppIndexView.getPSAppMenu().getPSAppMenuItems()) != null) {
                                        while (appMenuItems.hasNext()) {
                                            IPSAppMenuItem iPSAppMenuItem = appMenuItems.next();
                                            if (iPSAppMenuItem.getPSAppFunc() == null || StringHelper.IsNullOrEmpty((String)iPSAppMenuItem.getPSAppFunc().getPSAppViewId()) || psAppViewMap.containsKey(iPSAppMenuItem.getPSAppFunc().getPSAppViewId())) continue;
                                            psAppViewMap.put(iPSAppMenuItem.getPSAppFunc().getPSAppViewId(), "");
                                            PSAppView psAppView = new PSAppView();
                                            psAppView.setPSAPPVIEWID(iPSAppMenuItem.getPSAppFunc().getPSAppViewId());
                                            relatedAppViewList.add(psAppView);
                                        }
                                    }
                                }
                            } else {
                                Iterator<IPSAppViewRef> psAppViewRefs = iPSAppView.getEmbeddedPSAppViewRefs("");
                                if (psAppViewRefs != null) {
                                    while (psAppViewRefs.hasNext()) {
                                        PSAppView psAppView;
                                        IPSAppViewRef iPSAppViewRef = psAppViewRefs.next();
                                        if (!StringHelper.IsNullOrEmpty((String)iPSAppViewRef.getRefPSAppViewId())) {
                                            psAppView = new PSAppView();
                                            psAppView.setPSAPPVIEWID(iPSAppViewRef.getRefPSAppViewId());
                                            relatedAppViewList.add(psAppView);
                                            continue;
                                        }
                                        if (iPSAppViewRef.getRefPSAppView() == null) continue;
                                        psAppView = new PSAppView();
                                        psAppView.setPSAPPVIEWID(iPSAppViewRef.getRefPSAppView().getId());
                                        relatedAppViewList.add(psAppView);
                                    }
                                }
                            }
                            if (relatedAppViewList.size() > 0) {
                                for (PSAppView psAppView : relatedAppViewList) {
                                    CallResult callResult = this.getPSModelHelper(iPSSystem.getPSSysModelInstId()).getPSApplicationView(psAppView.getPSAPPVIEWID(), psAppView);
                                    if (callResult.isError()) {
                                        log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u89c6\u56fe[%1$s]", (Object)psAppView.getPSAPPVIEWID()));
                                        continue;
                                    }
                                    psAppView.setPSAPPVIEWID(psAppView.getPSAPPVIEWID());
                                    IPSAppView iPSAppView2 = this.createPSAppView(psAppView);
                                    if (!(iPSAppView2 instanceof IPSAppViewPreview)) continue;
                                    try {
                                        IPSAppViewPreview iPSAppViewPreview = (IPSAppViewPreview)((Object)iPSAppView2);
                                        if (!bPFPriviewUseModel) {
                                            iPSAppViewPreview.setPSPFStyle(iPSPFStyle);
                                        }
                                        iPSAppViewPreview.initPreview(this.getDAGlobalHelper(), iPSApplication, psAppView, null, 2);
                                        relatedAppViewList2.add(iPSAppView2);
                                    }
                                    catch (Exception ex) {
                                        log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u9884\u89c8\u89c6\u56fe\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
                                    }
                                }
                                psPublishContextImpl = new PSPublishContextImpl(this.getDAGlobalHelper(), null);
                                psPublishContextImpl.setPSSysModelInstId(iPSSystem.getPSSysModelInstId());
                                for (IPSAppView iPSAppView2 : relatedAppViewList2) {
                                    Iterator<IPSPFViewTempl> psPFViewTempls = iPSPFStyle.getPSPFViewTempls(iPSAppView2);
                                    while (psPFViewTempls.hasNext()) {
                                        PSAppViewCode psAppViewCode = new PSAppViewCode();
                                        psPublishContextImpl.setUserTag("PSAPPVIEWCODE", (Object)psAppViewCode);
                                        IPSPFViewTempl iPSPFViewTempl = psPFViewTempls.next();
                                        IPSPFViewCodePublisher iPSPFViewCodePublisher = iPSPFViewTempl.getPSPFViewCodePublisher();
                                        iPSPFViewCodePublisher.generateCode2(psPublishContextImpl, iPSAppView2, null);
                                        iPSPFViewCodePublisher.close();
                                        psAppViewCodeList2.add(psAppViewCode);
                                    }
                                    boolean bPubViewCtrl = true;
                                    if (!bPubViewCtrl) continue;
                                    ArrayList<IPSControl> psControls = iPSAppView2.getAllPSControls();
                                    for (IPSControl iPSControl : psControls) {
                                        Iterator<IPSPFCtrlTempl> psPFCtrlTempls = iPSPFStyle.getPSPFCtrlTempls(iPSControl);
                                        while (psPFCtrlTempls.hasNext()) {
                                            PSAppViewCode psAppViewCode = new PSAppViewCode();
                                            psPublishContextImpl.setUserTag("PSAPPVIEWCODE", (Object)psAppViewCode);
                                            IPSPFCtrlTempl iPSPFCtrlTempl = psPFCtrlTempls.next();
                                            IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher = iPSPFCtrlTempl.getPSPFCtrlCodePublisher();
                                            if (iPSPFCtrlCodePublisher instanceof IPSPFCtrlCodePublisher2) {
                                                ((IPSPFCtrlCodePublisher2)((Object)iPSPFCtrlCodePublisher)).generateCode2(psPublishContextImpl, iPSControl);
                                            }
                                            iPSPFCtrlCodePublisher.close();
                                            psAppViewCodeList2.add(psAppViewCode);
                                        }
                                    }
                                }
                            }
                            relatedAppViewList2.add(0, iPSAppView);
                            HashMap<String, Object> params = new HashMap<String, Object>();
                            params.put("viewlist", relatedAppViewList2);
                            psPublishContextImpl = new PSPublishContextImpl(this.getDAGlobalHelper(), null);
                            psPublishContextImpl.setPSSysModelInstId(iPSSystem.getPSSysModelInstId());
                            psPublishContextImpl.setPubParams(params);
                            Iterator<IPSPFAppTempl> psPFAppTempls = iPSPFStyle.getPSPFAppTempls(null);
                            while (psPFAppTempls.hasNext()) {
                                PSAppViewCode psAppViewCode = new PSAppViewCode();
                                psPublishContextImpl.setUserTag("PSAPPVIEWCODE", (Object)psAppViewCode);
                                IPSPFAppTempl iPSPFAppTempl = psPFAppTempls.next();
                                IPSPFAppCodePublisher iPSPFAppCodePublisher = iPSPFAppTempl.getPSPFAppCodePublisher();
                                iPSPFAppCodePublisher.generateCode(psPublishContextImpl, iPSApplication);
                                iPSPFAppCodePublisher.close();
                                psAppViewCodeList2.add(psAppViewCode);
                            }
                            Iterator<IPSPFViewTempl> psPFViewTempls = iPSPFStyle.getPSPFViewTempls(iPSAppView);
                            while (psPFViewTempls.hasNext()) {
                                PSAppViewCode psAppViewCode = new PSAppViewCode();
                                psPublishContextImpl.setUserTag("PSAPPVIEWCODE", (Object)psAppViewCode);
                                IPSPFViewTempl iPSPFViewTempl = psPFViewTempls.next();
                                IPSPFViewCodePublisher iPSPFViewCodePublisher = iPSPFViewTempl.getPSPFViewCodePublisher();
                                iPSPFViewCodePublisher.generateCode2(psPublishContextImpl, iPSAppView, null);
                                iPSPFViewCodePublisher.close();
                                psAppViewCodeList2.add(psAppViewCode);
                            }
                            boolean bPubViewCtrl = true;
                            if (bPubViewCtrl) {
                                ArrayList<IPSControl> psControls = iPSAppView.getAllPSControls();
                                for (IPSControl iPSControl : psControls) {
                                    Iterator<IPSPFCtrlTempl> psPFCtrlTempls = iPSPFStyle.getPSPFCtrlTempls(iPSControl);
                                    while (psPFCtrlTempls.hasNext()) {
                                        PSAppViewCode psAppViewCode = new PSAppViewCode();
                                        psPublishContextImpl.setUserTag("PSAPPVIEWCODE", (Object)psAppViewCode);
                                        IPSPFCtrlTempl iPSPFCtrlTempl = psPFCtrlTempls.next();
                                        IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher = iPSPFCtrlTempl.getPSPFCtrlCodePublisher();
                                        if (iPSPFCtrlCodePublisher instanceof IPSPFCtrlCodePublisher2) {
                                            ((IPSPFCtrlCodePublisher2)((Object)iPSPFCtrlCodePublisher)).generateCode2(psPublishContextImpl, iPSControl, params);
                                        }
                                        iPSPFCtrlCodePublisher.close();
                                        psAppViewCodeList2.add(psAppViewCode);
                                    }
                                }
                            }
                            String strPreviewImageTag = StringHelper.Format((String)"%1$s/%2$s/%3$s/%4$s", (Object)iPSSystem.getPSDevCenterId(), (Object)iPSSystem.getPSDevSlnSysId(), (Object)strModelType, (Object)strRealModelId);
                            strPubFolder = PSTaskServerEnvImpl.getCurrent().createTempFolder();
                            for (PSAppViewCode psAppViewCode : psAppViewCodeList2) {
                                File folder;
                                String strCodeFolder = strPubFolder;
                                String strCodePath = psAppViewCode.getCODEPATH();
                                int nPos = strCodePath.lastIndexOf(File.separator);
                                if (nPos != -1) {
                                    strCodeFolder = String.valueOf(strCodeFolder) + strCodePath.substring(0, nPos);
                                }
                                if (!(folder = new File(strCodeFolder)).exists()) {
                                    folder.mkdirs();
                                }
                                String strFullPath = strPubFolder;
                                File fileFolder = new File(strFullPath = String.valueOf(strFullPath) + strCodePath);
                                if (!fileFolder.exists()) {
                                    fileFolder.mkdirs();
                                }
                                strFullPath = String.valueOf(strFullPath) + File.separator;
                                strFullPath = String.valueOf(strFullPath) + psAppViewCode.getPSAPPVIEWCODENAME();
                                String strCode = psAppViewCode.getUSERCODE();
                                if (StringHelper.IsNullOrEmpty((String)strCode)) {
                                    strCode = psAppViewCode.getPUBCODE();
                                }
                                strCode = strCode.replace("__SRFUPLOADPARAMS__", strPreviewImageTag);
                                FileWriterHelper.write(strFullPath, strCode);
                            }
                            break block120;
                        }
                        strPubFolder = PSTaskServerEnvImpl.getCurrent().createTempFolder();
                        String strFolderName = KeyValueHelper.genUniqueId((String)KeyValueHelper.genGuidEx());
                        String strPubFolder2 = String.format("%1$s%2$s%3$s", strPubFolder, strFolderName, File.separator);
                        File file = new File(strPubFolder2);
                        file.mkdir();
                        String strFullPath = StringHelper.Format((String)"%1$sappview.json", (Object)strPubFolder2);
                        strIndexFile = String.valueOf(strFolderName) + "/appview.json";
                        ObjectNode objNode = null;
                        if (iPSSystem.isDynaInstMode()) {
                            Boolean bLast = PSAppViewImpl.getCurrentDesignMode();
                            try {
                                PSAppViewImpl.setCurrentDesignMode(true);
                                objNode = iPSAppView.toModel(null);
                                PSAppViewImpl.setCurrentDesignMode(bLast);
                            }
                            catch (Exception ex) {
                                PSAppViewImpl.setCurrentDesignMode(bLast);
                                throw ex;
                            }
                        } else {
                            objNode = iPSAppView.toModel(null);
                        }
                        PSModelV2Helper.writeFile((String)strFullPath, (String)objNode.toString());
                        break block120;
                    }
                    throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u9884\u89c8\u89c6\u56fe\u5bf9\u8c61");
                }
                catch (Exception ex) {
                    psPFPreviewActionService = (PSPFPreviewActionService)ServiceGlobal.getService(PSPFPreviewActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                    psPFPreviewAction2.reset();
                    psPFPreviewAction2.setPSPFPreviewActionId(this.getTaskParam());
                    psPFPreviewAction2.setActionState(Integer.valueOf(40));
                    psPFPreviewAction2.setActionResult(StringHelper.Format((String)"\u751f\u6210\u9884\u89c8\u6587\u4ef6\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
                    psPFPreviewAction2.setPSDSConsoleId(strPSDSConsoleId);
                    psPFPreviewActionService.update(psPFPreviewAction2, false);
                    throw ex;
                }
            }
            psPFPreviewActionService = (PSPFPreviewActionService)ServiceGlobal.getService(PSPFPreviewActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            psPFPreviewAction2.reset();
            psPFPreviewAction2.setPSPFPreviewActionId(this.getTaskParam());
            psPFPreviewAction2.setActionState(Integer.valueOf(40));
            psPFPreviewAction2.setActionResult("\u4f5c\u4e1a\u88ab\u53d6\u6d88");
            psPFPreviewAction2.setPSDSConsoleId(strPSDSConsoleId);
            psPFPreviewActionService.update(psPFPreviewAction2, false);
            return null;
        }
        psPFPreviewActionService = (PSPFPreviewActionService)ServiceGlobal.getService(PSPFPreviewActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        psPFPreviewAction2.reset();
        psPFPreviewAction2.setPSPFPreviewActionId(this.getTaskParam());
        psPFPreviewAction2.setActionState(Integer.valueOf(20));
        psPFPreviewAction2.setPreviewStep("\u6b63\u5728\u90e8\u7f72\u9884\u89c8\u6587\u4ef6\uff0c\u7b49\u5f85\u9884\u89c8\u8282\u70b9");
        psPFPreviewAction2.setPSDSConsoleId(strPSDSConsoleId);
        psPFPreviewActionService.update(psPFPreviewAction2, false);
        while (!this.isCancel()) {
            if (!bPFPriviewUseModel) {
                psPFPreviewAction.setPSPFId(strPreviewPSPFId);
                PSPFPreviewNode psPFPreviewNode = PSPFPreviewNodeGlobal.getCurrent().getPSPFPreviewNode(psPFPreviewAction);
                if (psPFPreviewNode == null) {
                    Thread.sleep(1000L);
                    continue;
                }
                strPubFolder = strPubFolder.replace("\\\\", File.separator);
                strPubFolder = strPubFolder.replace("//", File.separator);
                strPubFolder = strPubFolder.substring(0, strPubFolder.length() - 1);
                String strCmd = "";
                strCmd = PSTaskServerEnvImpl.getCurrent().isLinux() ? StringHelper.Format((String)"python %1$s%2$spyutils%2$spfpreviewhelp.py %3$s %4$s %5$s %6$s", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)strPubFolder, (Object)psPFPreviewNode.getSSHIPAddr(), (Object)psPFPreviewNode.getSSHPort(), (Object)psPFPreviewNode.getHttpPort()) : StringHelper.Format((String)"cmd.exe /c python %1$s%2$spyutils%2$spfpreviewhelp.py %3$s %4$s %5$s %6$s", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)strPubFolder, (Object)psPFPreviewNode.getSSHIPAddr(), (Object)psPFPreviewNode.getSSHPort(), (Object)psPFPreviewNode.getHttpPort());
                String strResult = this.runBat(strCmd, true);
                psPFPreviewActionService = (PSPFPreviewActionService)ServiceGlobal.getService(PSPFPreviewActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                psPFPreviewAction2.reset();
                psPFPreviewAction2.setPSPFPreviewActionId(this.getTaskParam());
                psPFPreviewAction2.setActionState(Integer.valueOf(30));
                psPFPreviewAction2.setPreviewStep("");
                psPFPreviewAction2.setActionResult("");
                psPFPreviewAction2.setPreviewUrl(StringHelper.Format((String)"%1$s%2$s", (Object)psPFPreviewNode.getHttpAddress(), (Object)strViewCodeName));
                psPFPreviewAction2.setPSDSConsoleId(strPSDSConsoleId);
                psPFPreviewActionService.update(psPFPreviewAction2, false);
                return null;
            }
            String strServerRoot = PSTaskServerEnvImpl.getCurrent().getTempFileServerUrl();
            String strServerHost = PSTaskServerEnvImpl.getCurrent().getTempFileServerAddr();
            int nServerPort = PSTaskServerEnvImpl.getCurrent().getTempFileServerPort();
            strPubFolder = strPubFolder.replace("\\\\", File.separator);
            strPubFolder = strPubFolder.replace("//", File.separator);
            strPubFolder = strPubFolder.substring(0, strPubFolder.length() - 1);
            String strCmd = "";
            strCmd = PSTaskServerEnvImpl.getCurrent().isLinux() ? StringHelper.Format((String)"python %1$s%2$spyutils%2$stempfilehelp.py %3$s %4$s %5$s", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)strPubFolder, (Object)strServerHost, (Object)nServerPort) : StringHelper.Format((String)"cmd.exe /c python %1$s%2$spyutils%2$stempfilehelp.py %3$s %4$s %5$s", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)strPubFolder, (Object)strServerHost, (Object)nServerPort);
            String strResult = this.runBat(strCmd, true);
            Thread.sleep(2000L);
            psPFPreviewActionService = (PSPFPreviewActionService)ServiceGlobal.getService(PSPFPreviewActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            psPFPreviewAction2.reset();
            psPFPreviewAction2.setPSPFPreviewActionId(this.getTaskParam());
            psPFPreviewAction2.setActionState(Integer.valueOf(30));
            psPFPreviewAction2.setPreviewStep("");
            psPFPreviewAction2.setActionResult("");
            psPFPreviewAction2.setPreviewUrl(StringHelper.Format((String)"%1$s%2$s", (Object)strServerRoot, (Object)strIndexFile));
            psPFPreviewAction2.setPSDSConsoleId(strPSDSConsoleId);
            psPFPreviewActionService.update(psPFPreviewAction2, false);
            return null;
        }
        psPFPreviewActionService = (PSPFPreviewActionService)ServiceGlobal.getService(PSPFPreviewActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        psPFPreviewAction2.reset();
        psPFPreviewAction2.setPSPFPreviewActionId(this.getTaskParam());
        psPFPreviewAction2.setActionState(Integer.valueOf(40));
        psPFPreviewAction2.setActionResult("\u4f5c\u4e1a\u88ab\u53d6\u6d88");
        psPFPreviewAction2.setPSDSConsoleId(strPSDSConsoleId);
        psPFPreviewActionService.update(psPFPreviewAction2, false);
        return null;
    }

    protected IPSSystem getPSSystem(String strPSDevSlnSysId, String strPSDynaInstId, String strPSSystemId) throws Exception {
        return this.getPSSystem(strPSDevSlnSysId, strPSDynaInstId, strPSSystemId, IPSSystem.LOADLEVEL_CODE);
    }

    protected IPSSystem getPSSystem(String strPSDevSlnSysId, String strPSDynaInstId, String strPSSystemId, int nLoadLevel) throws Exception {
        IPSSystem iPSSystem = null;
        if (!StringHelper.IsNullOrEmpty((String)strPSDevSlnSysId) || !StringHelper.IsNullOrEmpty((String)strPSDynaInstId)) {
            IPSDevSlnSys iPSDevSlnSys = null;
            if (!StringHelper.IsNullOrEmpty((String)strPSDynaInstId)) {
                IPSDevSlnSysDynaInst iPSDevSlnSysDynaInst = this.getPSModelStorage().getPSDevSlnSysDynaInst(strPSDynaInstId);
                iPSDevSlnSys = iPSDevSlnSysDynaInst.getPSDevSlnSys();
            } else {
                iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(strPSDevSlnSysId);
            }
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

    protected IPSApplication getPSApplication(IPSSystem iPSSystem, String strPSSysAppId) throws Exception {
        return this.getPSApplication(iPSSystem, strPSSysAppId, IPSSystem.LOADLEVEL_CODE);
    }

    protected IPSApplication getPSApplication(IPSSystem iPSSystem, String strPSSysAppId, int nLoadLevel) throws Exception {
        IPSApplication iPSApplication = iPSSystem.getPSApplication(strPSSysAppId);
        if (iPSApplication.getLoadedLevel() >= nLoadLevel) {
            return iPSApplication;
        }
        return PSSystemUtil.loadPSApplication(iPSSystem, strPSSysAppId, nLoadLevel);
    }

    protected IPSAppView createPSAppView(PSAppView vt) throws Exception {
        if (StringHelper.IsNullOrEmpty((String)vt.getPSDEVIEWBASEID()) && StringHelper.IsNullOrEmpty((String)vt.getPSDYNADEVIEWTEMPLID()) && StringHelper.IsNullOrEmpty((String)vt.getPSAPPUTILVIEWTYPE())) {
            IPSViewType iPSAppViewType = this.getPSModelStorage().getPSViewType(vt.getPSAPPVIEWTYPE());
            IPSAppView iPSApplicationView = iPSAppViewType.createPSAppView(vt);
            return iPSApplicationView;
        }
        if (!StringHelper.IsNullOrEmpty((String)vt.getPSDEVIEWTYPE())) {
            IPSViewType iPSAppViewType = this.getPSModelStorage().getPSViewType(vt.getPSDEVIEWTYPE());
            IPSAppView iPSApplicationView = iPSAppViewType.createPSAppView(vt);
            return iPSApplicationView;
        }
        if (!StringHelper.IsNullOrEmpty((String)vt.getPSDYNADEVIEWTYPE())) {
            IPSViewType iPSAppViewType = this.getPSModelStorage().getPSViewType(vt.getPSDYNADEVIEWTYPE());
            IPSAppView iPSApplicationView = iPSAppViewType.createPSAppView(vt);
            return iPSApplicationView;
        }
        if (!StringHelper.IsNullOrEmpty((String)vt.getPSAPPUTILVIEWTYPE())) {
            IPSViewType iPSAppViewType = this.getPSModelStorage().getPSViewType(vt.getPSAPPUTILVIEWTYPE());
            IPSAppView iPSApplicationView = iPSAppViewType.createPSAppView(vt);
            return iPSApplicationView;
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u521b\u5efa\u6307\u5b9a\u5e94\u7528\u89c6\u56fe[%1$s]\u5bf9\u8c61\uff0c\u65e0\u6cd5\u8bc6\u522b", (Object)vt.getPSAPPVIEWID()));
    }
}
