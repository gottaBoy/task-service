/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.app.IPSAppModule
 *  net.ibizsys.model.app.IPSAppUtilPage
 *  net.ibizsys.model.app.IPSApplication
 *  net.ibizsys.model.app.IPSApplicationUI
 *  net.ibizsys.model.app.func.IPSAppFunc
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.model.dynasys.IPSDynaInst
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.dynasys;

import java.util.Iterator;
import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.PSSystemObjectImpl;
import net.ibizsys.model.app.IPSAppModule;
import net.ibizsys.model.app.IPSAppPDTView;
import net.ibizsys.model.app.IPSAppUtilPage;
import net.ibizsys.model.app.IPSApplication;
import net.ibizsys.model.app.IPSApplicationRuntime;
import net.ibizsys.model.app.IPSApplicationUI;
import net.ibizsys.model.app.PSApplicationException;
import net.ibizsys.model.app.func.IPSAppFunc;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.PSAppViewGlobalModel;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dynasys.IPSDynaAppInst;
import net.ibizsys.model.dynasys.IPSDynaInst;
import net.ibizsys.model.dynasys.IPSDynaInstRuntime;
import net.ibizsys.model.entity.PSDEViewBase;
import net.ibizsys.model.entity.PSSystemApplication;
import net.ibizsys.model.pf.IPSPF;
import net.ibizsys.model.pf.IPSPFStyle;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;

public class PSDynaAppInstImpl
extends PSSystemObjectImpl
implements IPSDynaAppInst,
IPSApplicationRuntime {
    private IPSDynaInstRuntime iPSDynaInst = null;
    protected PSAppViewGlobalModel psApplicationViewGlobalModel = new PSAppViewGlobalModel();
    private IPSApplication realPSApplication = null;

    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDynaInst iPSDynaInst, IPSApplication iPSApplication) throws Exception {
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setPSSystem((IPSSystem)iPSDynaInst);
        this.setId(iPSApplication.getId());
        this.setName(iPSApplication.getName());
        this.iPSDynaInst = (IPSDynaInstRuntime)iPSDynaInst;
        this.realPSApplication = StringHelper.isNullOrEmpty((String)((IPSModelObjectRuntime)iPSApplication).getPSDynaInstId()) ? iPSApplication : this.iPSDynaInst.getPSSystem().getPSApplication(iPSApplication.getId());
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        this.psApplicationViewGlobalModel.init(this.getPSModelStorageContext(), this);
        super.onInit();
    }

    public IPSDynaInst getPSDynaInst() {
        return this.iPSDynaInst;
    }

    public IPSAppFunc getPSAppFunc(String strPSAppFuncId) throws Exception {
        return this.getRealPSApplication().getPSAppFunc(strPSAppFuncId);
    }

    public IPSApplicationUI getPSApplicationUI() {
        return this.getRealPSApplication().getPSApplicationUI();
    }

    public boolean isMobileApp() {
        return this.getRealPSApplication().isMobileApp();
    }

    public String getPFType() {
        return this.getRealPSApplication().getPFType();
    }

    public String getPFStyle() {
        return this.getRealPSApplication().getPFStyle();
    }

    public String getPKGCodeName() {
        return this.getRealPSApplication().getPKGCodeName();
    }

    public String getCodeFolder() {
        return this.getRealPSApplication().getCodeFolder();
    }

    public Iterator<IPSAppUtilPage> getAllPSAppUtilPages() throws Exception {
        return this.getRealPSApplication().getAllPSAppUtilPages();
    }

    public IPSAppUtilPage getPSAppUtilPage(String strPSAppUtilPageId) throws Exception {
        return this.getRealPSApplication().getPSAppUtilPage(strPSAppUtilPageId);
    }

    public boolean isEnableUACLogin() {
        return this.getRealPSApplication().isEnableUACLogin();
    }

    public boolean getDefaultFlag() {
        return this.getRealPSApplication().getDefaultFlag();
    }

    public IPSAppModule getPSAppModule(String strPSAppModuleId) throws Exception {
        return this.getRealPSApplication().getPSAppModule(strPSAppModuleId);
    }

    @Override
    public String getPSDynaInstId() {
        return ((IPSModelObjectRuntime)this.getPSDynaInst()).getPSDynaInstId();
    }

    @Override
    public int getDynaModelType() {
        return 2;
    }

    public IPSApplication getParentPSApplication() throws Exception {
        IPSDynaInst parentPSDynaInst = this.getPSDynaInstRuntime().getParentPSDynaInst();
        if (parentPSDynaInst == null) {
            return this.getRealPSApplication();
        }
        return parentPSDynaInst.getPSApplication(this.getId());
    }

    public IPSApplicationRuntime getParentPSApplicationRuntime() throws Exception {
        return (IPSApplicationRuntime)this.getParentPSApplication();
    }

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSSystem iPSSystem, PSSystemApplication psSystemApplication) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public IPSAppView getPSAppViewByDEViewId(String strPSDEViewId, boolean bTryMode) throws Exception {
        IPSAppView iPSAppView;
        String strPSApplicationViewId = KeyValueHelper.genUniqueId((String)this.getId(), (String)strPSDEViewId);
        if (!this.psApplicationViewGlobalModel.containsModel(strPSApplicationViewId) && (iPSAppView = this.getParentPSApplicationRuntime().getPSAppViewByDEViewId(strPSDEViewId, true)) != null) {
            return iPSAppView;
        }
        iPSAppView = this.psApplicationViewGlobalModel.findModelHelper(strPSApplicationViewId, true);
        if (iPSAppView == null && !bTryMode) {
            PSDEViewBase psDEViewBase = new PSDEViewBase();
            CallResult callResult = this.getPSModelQueryHelper().getPSDEViewBase(strPSDEViewId, psDEViewBase);
            if (callResult.isOk()) {
                String strInfo = StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u89c6\u56fe\uff0c\u6807\u8bc6\u4e3a[%1$s]\uff0c\u8bf7\u786e\u8ba4\u5b9e\u4f53\u89c6\u56fe[%2$s][%3$s]\u5df2\u7ecf\u6dfb\u52a0\u5230\u5e94\u7528[%4$s]\u4e2d", (Object)strPSApplicationViewId, (Object)psDEViewBase.getPSDENAME(), (Object)psDEViewBase.getPSDEVIEWBASENAME(), (Object)this.getName());
                throw new PSApplicationException(this, 40012, strInfo, strPSApplicationViewId, strPSDEViewId);
            }
        }
        return iPSAppView;
    }

    @Override
    public IPSAppView getPSAppView(String strPSApplicationViewId, String strOriginViewId) throws Exception {
        return this.getPSAppView(strPSApplicationViewId, strOriginViewId, false, null);
    }

    @Override
    public IPSAppView getPSAppView(String strPSApplicationViewId, String strOriginViewId, IPSAppView refPSAppView) throws Exception {
        return this.getPSAppView(strPSApplicationViewId, strOriginViewId, false, refPSAppView);
    }

    @Override
    public IPSAppView getPSAppView(String strPSApplicationViewId, String strOriginViewId, boolean bTryMode) throws Exception {
        return this.getPSAppView(strPSApplicationViewId, strOriginViewId, bTryMode, null);
    }

    @Override
    public IPSAppView getPSAppView(String strPSApplicationViewId, String strOriginViewId, boolean bTryMode, IPSAppView refPSAppView) throws Exception {
        IPSAppView iPSAppView;
        if (!this.psApplicationViewGlobalModel.containsModel(strPSApplicationViewId) && (iPSAppView = this.getParentPSApplicationRuntime().getPSAppView(strPSApplicationViewId, strOriginViewId, true, refPSAppView)) != null) {
            return iPSAppView;
        }
        iPSAppView = this.psApplicationViewGlobalModel.findModelHelper(strPSApplicationViewId, true);
        if (iPSAppView == null && !bTryMode) {
            if (!StringHelper.isNullOrEmpty((String)strOriginViewId)) {
                PSDEViewBase psDEViewBase = new PSDEViewBase();
                CallResult callResult = this.getPSModelQueryHelper().getPSDEViewBase(strOriginViewId, psDEViewBase);
                if (callResult.isOk()) {
                    throw PSApplicationException.create(this, 40012, strPSApplicationViewId, strOriginViewId);
                }
            }
            throw PSApplicationException.create(this, 40012, strPSApplicationViewId, strOriginViewId);
        }
        return iPSAppView;
    }

    @Override
    public IPSAppView getPSAppView(String strPSApplicationViewId, boolean bTryMode) throws Exception {
        IPSAppView iPSAppView;
        if (!this.psApplicationViewGlobalModel.containsModel(strPSApplicationViewId) && (iPSAppView = this.getParentPSApplicationRuntime().getPSAppView(strPSApplicationViewId, true)) != null) {
            return iPSAppView;
        }
        iPSAppView = this.psApplicationViewGlobalModel.findModelHelper(strPSApplicationViewId, bTryMode);
        return iPSAppView;
    }

    @Override
    public void markPSAppViewUsage(String strPSAppViewId, int nViewUsage, Object objRef) {
        this.getRealPSApplicationRuntime().markPSAppViewUsage(strPSAppViewId, nViewUsage, objRef);
    }

    @Override
    public int getPSAppViewUsage(String strPSAppViewId) {
        return this.getRealPSApplicationRuntime().getPSAppViewUsage(strPSAppViewId);
    }

    @Override
    public void log(int nLogLevel, IPSModelObject iPSModelObject, String strInfo) {
        this.getRealPSApplicationRuntime().log(nLogLevel, iPSModelObject, strInfo);
    }

    @Override
    public void log(int nLogLevel, IPSModelObject iPSModelObject, String strInfo, String strUserData) {
        this.getRealPSApplicationRuntime().log(nLogLevel, iPSModelObject, strInfo, strUserData);
    }

    @Override
    public void log(int nLogLevel, IPSModelObject iPSModelObject, String strInfo, String strUserData, String strUserData2) {
        this.getRealPSApplicationRuntime().log(nLogLevel, iPSModelObject, strInfo, strUserData, strUserData2);
    }

    @Override
    public IPSPF getPSPF() {
        return this.getRealPSApplicationRuntime().getPSPF();
    }

    @Override
    public IPSPFStyle getPSPFStyle() {
        return this.getRealPSApplicationRuntime().getPSPFStyle();
    }

    @Override
    public IPSPFStyle getPSPFStyle(String strPSPFStyleId) throws Exception {
        return this.getRealPSApplicationRuntime().getPSPFStyle(strPSPFStyleId);
    }

    @Override
    public IPSAppPDTView getPSAppPDTView(String strPSAppPDTViewId, boolean bTryMode) throws Exception {
        return this.getRealPSApplicationRuntime().getPSAppPDTView(strPSAppPDTViewId, bTryMode);
    }

    public String getAppFolder() {
        return this.getRealPSApplication().getAppFolder();
    }

    public IPSApplication getRealPSApplication() {
        return this.realPSApplication;
    }

    public IPSApplicationRuntime getRealPSApplicationRuntime() {
        return (IPSApplicationRuntime)this.getRealPSApplication();
    }

    public IPSDynaInstRuntime getPSDynaInstRuntime() {
        return this.iPSDynaInst;
    }
}

