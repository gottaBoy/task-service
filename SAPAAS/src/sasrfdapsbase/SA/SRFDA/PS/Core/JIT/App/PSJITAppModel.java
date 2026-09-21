/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  net.ibizsys.paas.appmodel.AppModelBase
 *  net.ibizsys.paas.controller.IViewController
 *  net.ibizsys.paas.core.ISystem
 *  net.ibizsys.paas.ctrlmodel.IAppMenuModel
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.Page
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.web.servlet.support.RequestContext
 */
package SA.SRFDA.PS.Core.JIT.App;

import SA.SRFDA.PS.Core.App.AppMenu.IPSAppMenuModel;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.UserMode.IPSAppUserMode;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.JIT.App.IPSJITAppModel;
import SA.SRFDA.PS.Core.JIT.App.PSJITAppMenuModel;
import SA.SRFDA.PS.Core.JIT.Controller.IPSJITViewController;
import SA.SRFDA.PS.Core.JIT.Controller.PSJITRedirectViewController;
import SA.SRFDA.PS.Core.JIT.Controller.PSJITViewController;
import SA.SRFDA.PS.Core.JIT.SysModel.IPSJITSystemModel;
import SA.SRFDA.PS.Core.JIT.WF.PSJITWFDEViewController;
import SA.SRFDA.PS.Core.JIT.Web.PSJITWebApplicationContext;
import SA.SRFDA.PS.Core.JIT.Web.PSJITWebContext;
import SA.SRFDA.PS.Core.PF.IPSPFAppTempl;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PF.IPSPFViewTempl;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.Pub.IPSPFAppCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPFViewCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSPublishContextImpl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.ibizsys.paas.appmodel.AppModelBase;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.ctrlmodel.IAppMenuModel;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.Page;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.support.RequestContext;

public class PSJITAppModel
extends AppModelBase
implements IPSJITAppModel {
    private static final Log log = LogFactory.getLog(PSJITAppModel.class);
    private ISRFDAGlobalHelper iDAGlobalHelper = null;
    private IPSApplication iPSApplication = null;
    private IPSJITSystemModel iPSJITSystemModel = null;
    private HashMap<String, IPSJITViewController> viewControllerMap = new HashMap();
    private HashMap<String, IViewController> viewControllerMap2 = new HashMap();
    private HashMap<String, IAppMenuModel> appMenuModelMap2 = new HashMap();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSJITSystemModel iPSJITSystemModel, IPSApplication iPSApplication) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iPSJITSystemModel = iPSJITSystemModel;
        this.iPSApplication = iPSApplication;
        this.setId(this.iPSApplication.getId());
        this.setName(this.iPSApplication.getName());
        this.setPFType(this.getPSApplication().getPSPF().getId());
        this.onInit();
    }

    protected void onInit() throws Exception {
        this.prepareAppUserModeMenus();
        super.onInit();
    }

    public ISystem getSystem() {
        return this.iPSJITSystemModel;
    }

    @Override
    public IPSJITSystemModel getPSJITSystemModel() {
        return this.iPSJITSystemModel;
    }

    @Override
    public IPSApplication getPSApplication() {
        return this.iPSApplication;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSJITViewController getViewController(IPSAppView iPSAppView) throws Exception {
        HashMap<String, IPSJITViewController> hashMap = this.viewControllerMap;
        synchronized (hashMap) {
            IPSJITViewController iPSJITViewController = this.viewControllerMap.get(iPSAppView.getId());
            if (iPSJITViewController != null) {
                return iPSJITViewController;
            }
            PSJITViewController psJITViewController = null;
            psJITViewController = iPSAppView.isRedirectView() ? new PSJITRedirectViewController() : (iPSAppView.isEnableWF() ? new PSJITWFDEViewController() : new PSJITViewController());
            psJITViewController.init(this, iPSAppView);
            this.viewControllerMap.put(iPSAppView.getId(), psJITViewController);
            return psJITViewController;
        }
    }

    public IWebContext createWebContext(IViewController iViewController, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return PSJITWebContext.getInstance();
    }

    protected void prepareAppUserModeMenus() throws Exception {
        HashMap<String, IPSAppMenuModel> psAppMenuModelMap = new HashMap<String, IPSAppMenuModel>();
        Iterator<IPSAppUserMode> psAppUserModes = this.getPSApplication().getAllPSAppUserModes();
        while (psAppUserModes.hasNext()) {
            IPSAppUserMode iPSAppUserMode = psAppUserModes.next();
            if (iPSAppUserMode.getPSSysUserMode() != null) {
                this.registerUserModeMenu(iPSAppUserMode.getPSSysUserMode().getName(), iPSAppUserMode.getPSAppMenuModel().getId());
            } else {
                this.registerUserModeMenu("", iPSAppUserMode.getPSAppMenuModel().getId());
            }
            psAppMenuModelMap.put(iPSAppUserMode.getPSAppMenuModel().getId(), iPSAppUserMode.getPSAppMenuModel());
        }
        for (IPSAppMenuModel iPSAppMenuModel : psAppMenuModelMap.values()) {
            PSJITAppMenuModel psJITAppMenuModel = new PSJITAppMenuModel();
            psJITAppMenuModel.init(this, iPSAppMenuModel);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void registerViewController2(String strViewControllerClsType, IViewController iViewController) {
        HashMap<String, IViewController> hashMap = this.viewControllerMap2;
        synchronized (hashMap) {
            this.viewControllerMap2.put(strViewControllerClsType, iViewController);
        }
    }

    @Override
    public IViewController getViewController2(Class cls) throws Exception {
        return this.getViewController2(cls.getCanonicalName());
    }

    @Override
    public IViewController getViewController2(String strViewControllerClsType) throws Exception {
        return this.internalGetViewController2(strViewControllerClsType);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private IViewController internalGetViewController2(String strViewControllerClsType) throws Exception {
        HashMap<String, IViewController> hashMap = this.viewControllerMap2;
        synchronized (hashMap) {
            IViewController iViewController = this.viewControllerMap2.get(strViewControllerClsType);
            return iViewController;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void registerAppMenuModel2(String strAppMenuModelClsType, IAppMenuModel iAppMenuModel) {
        HashMap<String, IAppMenuModel> hashMap = this.appMenuModelMap2;
        synchronized (hashMap) {
            this.appMenuModelMap2.put(strAppMenuModelClsType, iAppMenuModel);
        }
    }

    @Override
    public IAppMenuModel getAppMenuModel2(Class cls) throws Exception {
        return this.getAppMenuModel(cls.getCanonicalName());
    }

    @Override
    public IAppMenuModel getAppMenuModel2(String strAppMenuModelClsType) throws Exception {
        return this.internalGetAppMenuModel(strAppMenuModelClsType);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private IAppMenuModel internalGetAppMenuModel(String strAppMenuModelClsType) throws Exception {
        HashMap<String, IAppMenuModel> hashMap = this.appMenuModelMap2;
        synchronized (hashMap) {
            IAppMenuModel iAppMenuModel = this.appMenuModelMap2.get(strAppMenuModelClsType);
            return iAppMenuModel;
        }
    }

    public boolean doFilter(Page page, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (page != null) {
            request.setAttribute(RequestContext.WEB_APPLICATION_CONTEXT_ATTRIBUTE, (Object)new PSJITWebApplicationContext(request.getSession().getServletContext()));
        }
        return super.doFilter(page, request, response);
    }

    protected String generateCode() throws Exception {
        boolean bLastWriteCode = PSJITWebContext.getInstance().isRealWriteFile();
        try {
            PSJITWebContext.getInstance().setRealWriteFile(true);
            StringBuilderEx sBuilderEx = new StringBuilderEx();
            sBuilderEx.append(this.onGenerateCode());
            sBuilderEx.append(this.onGenerateCode2());
            this.generateUserCode();
            PSJITWebContext.getInstance().setRealWriteFile(bLastWriteCode);
            return sBuilderEx.toString();
        }
        catch (Exception ex) {
            PSJITWebContext.getInstance().setRealWriteFile(bLastWriteCode);
            throw ex;
        }
    }

    protected String onGenerateCode() throws Exception {
        String strPSDevSlnSysId = this.iPSApplication.getPSSystem().getPSDevSlnSysId();
        String strPSSysModelInstId = this.iPSApplication.getPSSysModelInstId();
        StringBuilderEx sBuilderEx = new StringBuilderEx();
        try {
            long nBeginTime = System.currentTimeMillis();
            Iterator<IPSAppView> psAppViews = this.iPSApplication.getAllPSAppViews();
            while (psAppViews.hasNext()) {
                IPSAppView iPSAppView = psAppViews.next();
                this.generateViewCode(iPSAppView);
            }
            long nTime = System.currentTimeMillis() - nBeginTime;
            log.debug((Object)StringHelper.format((String)"\u53d1\u5e03JIT\u89c6\u56fe\u4ee3\u7801\u8017\u65f6[%1$s]ms", (Object)nTime));
            sBuilderEx.append(StringHelper.format((String)"\u53d1\u5e03\u89c6\u56fe\u4ee3\u7801\u8017\u65f6[%1$s]ms", (Object)nTime));
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u4ea7\u751f\u89c6\u56fe\u4ee3\u7801\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            throw ex;
        }
        return sBuilderEx.toString();
    }

    protected String onGenerateCode2() throws Exception {
        StringBuilderEx sBuilderEx = new StringBuilderEx();
        IPSPFStyle iPSPFStyle = this.iPSApplication.getPSPFStyle();
        PSPublishContextImpl psPublishContextImpl = new PSPublishContextImpl(this.getDAGlobalHelper(), null);
        psPublishContextImpl.setPSSysModelInstId(this.iPSApplication.getPSSysModelInstId());
        Iterator<IPSPFAppTempl> psPFAppTempls = iPSPFStyle.getPSPFAppTempls(this.iPSApplication);
        while (psPFAppTempls.hasNext()) {
            IPSPFAppTempl iPSPFAppTempl = psPFAppTempls.next();
            IPSPFAppCodePublisher iPSPFAppCodePublisher = iPSPFAppTempl.getPSPFAppCodePublisher();
            iPSPFAppCodePublisher.generateCode(psPublishContextImpl, this.iPSApplication);
            iPSPFAppCodePublisher.close();
        }
        return sBuilderEx.toString();
    }

    /*
     * Unable to fully structure code
     */
    protected void generateUserCode() throws Exception {
        psAppViewCodes = this.iPSApplication.getAllPSAppViewCodes();
        if (psAppViewCodes == null) {
            return;
        }
        strCodeFolder = this.iPSJITSystemModel.getJITCodeFolder();
        if (!StringHelper.isNullOrEmpty((String)strCodeFolder)) ** GOTO lbl28
        throw new Exception("\u6ca1\u6709\u5b9a\u4e49\u4ee3\u7801\u53d1\u5e03\u76ee\u5f55");
lbl-1000:
        // 1 sources

        {
            iPSAppViewCode = psAppViewCodes.next();
            if (iPSAppViewCode.getPSPFPubCode() != null) continue;
            strFolder = strCodeFolder;
            strFolder = String.valueOf(strFolder) + File.separator + this.iPSApplication.getPSSystem().getPSDevCenterDomain();
            strFolder = String.valueOf(strFolder) + File.separator + this.iPSApplication.getPSSystem().getPubSystemId();
            strFolder = String.valueOf(strFolder) + File.separator + this.iPSApplication.getPSSystem().getVCName();
            strFolder = String.valueOf(strFolder) + File.separator + "app_" + this.iPSApplication.getWorkshopName();
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
                ((IPSSystemUtil)this.iPSApplication.getPSSystem()).log(4, this.iPSApplication, strInfo);
                PSJITAppModel.log.warn((Object)strInfo);
                if (PSTaskServerEnvImpl.getCurrent().isThrowExceptionWhenFileNameTooLong()) {
                    throw new Exception(StringHelper.format((String)"\u53d1\u5e03\u4ee3\u7801[%1$s]\u540d\u79f0\u957f\u5ea6\u8d85\u8fc7[%2$s]", (Object)strFullPath, (Object)PSTaskServerEnvImpl.getCurrent().getMaxFileNameLength()));
                }
            }
            ((IPSSystemUtil)this.iPSApplication.getPSSystem()).writeFile(strFullPath, iPSAppViewCode.getUserCode(), null);
lbl28:
            // 3 sources

            ** while (psAppViewCodes.hasNext())
        }
lbl29:
        // 1 sources

    }

    protected boolean generateViewCode(IPSAppView iPSAppView) throws Exception {
        if (!StringHelper.isNullOrEmpty((String)iPSAppView.getSubAppFolderName())) {
            return false;
        }
        if (this.iPSApplication.isPubRefViewOnly() && !iPSAppView.getRefFlag()) {
            return false;
        }
        PSPublishContextImpl psPublishContextImpl = new PSPublishContextImpl(this.getDAGlobalHelper(), null);
        psPublishContextImpl.setPSSysModelInstId(this.iPSApplication.getPSSysModelInstId());
        Iterator<IPSPFViewTempl> psPFViewTempls = iPSAppView.getPSPFStyle().getPSPFViewTempls(iPSAppView);
        while (psPFViewTempls.hasNext()) {
            IPSPFViewTempl iPSPFViewTempl = psPFViewTempls.next();
            IPSPFViewCodePublisher iPSPFViewCodePublisher = iPSPFViewTempl.getPSPFViewCodePublisher();
            iPSPFViewCodePublisher.generateCode(psPublishContextImpl, iPSAppView);
            iPSPFViewCodePublisher.close();
        }
        return true;
    }

    public ISRFDAGlobalHelper getDAGlobalHelper() {
        return this.iDAGlobalHelper;
    }

    public void setDAGlobalHelper(ISRFDAGlobalHelper iDAGlobalHelper) {
        this.iDAGlobalHelper = iDAGlobalHelper;
    }
}

