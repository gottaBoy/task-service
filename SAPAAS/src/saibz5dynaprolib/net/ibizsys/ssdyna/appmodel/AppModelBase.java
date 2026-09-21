/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.IPSApplication
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.control.IPSAjaxControl
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.paas.appmodel.IAppDEViewModel
 *  net.ibizsys.paas.ctrlhandler.EditFormHandlerBase
 *  net.ibizsys.paas.ctrlhandler.EditFormHandlerBase2
 *  net.ibizsys.paas.ctrlhandler.EditFormHandlerBase3
 *  net.ibizsys.paas.ctrlhandler.GridHandlerBase
 *  net.ibizsys.paas.ctrlhandler.GridHandlerBase2
 *  net.ibizsys.paas.ctrlhandler.SearchFormHandlerBase
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.ObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.ctrlhandler.WFActionFormHandlerBase
 *  net.ibizsys.pswf.ctrlhandler.WFEditFormHandlerBase
 *  net.ibizsys.saas.appmodel.AppModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.ssdyna.appmodel;

import java.util.HashMap;
import net.ibizsys.model.app.IPSApplication;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.control.IPSAjaxControl;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.paas.appmodel.IAppDEViewModel;
import net.ibizsys.paas.ctrlhandler.EditFormHandlerBase;
import net.ibizsys.paas.ctrlhandler.EditFormHandlerBase2;
import net.ibizsys.paas.ctrlhandler.EditFormHandlerBase3;
import net.ibizsys.paas.ctrlhandler.GridHandlerBase;
import net.ibizsys.paas.ctrlhandler.GridHandlerBase2;
import net.ibizsys.paas.ctrlhandler.SearchFormHandlerBase;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.ObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.ctrlhandler.WFActionFormHandlerBase;
import net.ibizsys.pswf.ctrlhandler.WFEditFormHandlerBase;
import net.ibizsys.ssdyna.appmodel.DynaAppDEViewModel;
import net.ibizsys.ssdyna.appmodel.IDynaAppModel;
import net.ibizsys.ssdyna.ctrlhandler.DynaDRBarHandler;
import net.ibizsys.ssdyna.ctrlhandler.DynaDRTabHandler;
import net.ibizsys.ssdyna.ctrlhandler.DynaEditFormHandler;
import net.ibizsys.ssdyna.ctrlhandler.DynaEditFormHandler2;
import net.ibizsys.ssdyna.ctrlhandler.DynaEditFormHandler3;
import net.ibizsys.ssdyna.ctrlhandler.DynaGridHandler;
import net.ibizsys.ssdyna.ctrlhandler.DynaGridHandler2;
import net.ibizsys.ssdyna.ctrlhandler.DynaSearchFormHandler;
import net.ibizsys.ssdyna.ctrlhandler.IDynaCtrlHandler;
import net.ibizsys.ssdyna.ctrlmodel.DynaDRBarModel;
import net.ibizsys.ssdyna.ctrlmodel.DynaDRTabModel;
import net.ibizsys.ssdyna.ctrlmodel.DynaEditFormModel;
import net.ibizsys.ssdyna.ctrlmodel.DynaGridModel;
import net.ibizsys.ssdyna.ctrlmodel.DynaSearchFormModel;
import net.ibizsys.ssdyna.ctrlmodel.DynaToolbarModel;
import net.ibizsys.ssdyna.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.ssdyna.sysmodel.IDynaInstModel;
import net.ibizsys.ssdyna.sysmodel.IDynaSysModel;
import net.ibizsys.ssdyna.view.IDynaViewModel;
import net.ibizsys.ssdyna.web.WebContext;
import net.ibizsys.ssdynawf.ctrlhandler.DynaWFActionFormHandler;
import net.ibizsys.ssdynawf.ctrlhandler.DynaWFEditFormHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class AppModelBase
extends net.ibizsys.saas.appmodel.AppModelBase
implements IDynaAppModel {
    private static final Log log = LogFactory.getLog(AppModelBase.class);
    private static HashMap<String, String> dynaCtrlModelMap = new HashMap();
    private static HashMap<String, String> dynaCtrlHandlerMap = new HashMap();

    static {
        dynaCtrlModelMap.put("FORM", DynaEditFormModel.class.getCanonicalName());
        dynaCtrlModelMap.put("SEARCHFORM", DynaSearchFormModel.class.getCanonicalName());
        dynaCtrlModelMap.put("TOOLBAR", DynaToolbarModel.class.getCanonicalName());
        dynaCtrlModelMap.put("GRID", DynaGridModel.class.getCanonicalName());
        dynaCtrlModelMap.put("DRBAR", DynaDRBarModel.class.getCanonicalName());
        dynaCtrlModelMap.put("DRTAB", DynaDRTabModel.class.getCanonicalName());
        dynaCtrlHandlerMap.put(GridHandlerBase.class.getCanonicalName(), DynaGridHandler.class.getCanonicalName());
        dynaCtrlHandlerMap.put(GridHandlerBase2.class.getCanonicalName(), DynaGridHandler2.class.getCanonicalName());
        dynaCtrlHandlerMap.put(SearchFormHandlerBase.class.getCanonicalName(), DynaSearchFormHandler.class.getCanonicalName());
        dynaCtrlHandlerMap.put(EditFormHandlerBase.class.getCanonicalName(), DynaEditFormHandler.class.getCanonicalName());
        dynaCtrlHandlerMap.put(EditFormHandlerBase2.class.getCanonicalName(), DynaEditFormHandler2.class.getCanonicalName());
        dynaCtrlHandlerMap.put(EditFormHandlerBase3.class.getCanonicalName(), DynaEditFormHandler3.class.getCanonicalName());
        dynaCtrlHandlerMap.put(WFEditFormHandlerBase.class.getCanonicalName(), DynaWFEditFormHandler.class.getCanonicalName());
        dynaCtrlHandlerMap.put(WFActionFormHandlerBase.class.getCanonicalName(), DynaWFActionFormHandler.class.getCanonicalName());
        dynaCtrlHandlerMap.put("DRBAR", DynaDRBarHandler.class.getCanonicalName());
        dynaCtrlHandlerMap.put("DRTAB", DynaDRTabHandler.class.getCanonicalName());
    }

    @Override
    public IPSApplication getPSApplication() throws Exception {
        try {
            return this.getDynaSysModel().getPSSystem().getPSApplication(this.getId());
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u7cfb\u7edf\u5e94\u7528\u6a21\u578b\u5bf9\u8c61\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u52a8\u6001\u5e94\u7528\u53d1\u751f\u5f02\u5e38\uff0c%1$", (Object)ex.getMessage()), ex);
        }
    }

    @Override
    public IDynaCtrlModel createDynaCtrlModel(IDynaViewModel iDynaViewModel, IPSControl iPSControl) throws Exception {
        String strObject = dynaCtrlModelMap.get(iPSControl.getControlType());
        if (StringHelper.isNullOrEmpty((String)strObject)) {
            return null;
        }
        return (IDynaCtrlModel)ObjectHelper.create((String)strObject);
    }

    @Override
    public IDynaCtrlHandler createDynaCtrlHandler(IDynaViewModel iDynaViewModel, IPSControl iPSControl) throws Exception {
        String strObject;
        String strHandler = null;
        if (iPSControl instanceof IPSAjaxControl) {
            strHandler = ((IPSAjaxControl)iPSControl).getHandler();
        }
        if (StringHelper.isNullOrEmpty(strHandler)) {
            strHandler = iPSControl.getControlType();
        }
        if (StringHelper.isNullOrEmpty((String)(strObject = dynaCtrlHandlerMap.get(strHandler)))) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7c7b\u578b[%1$s]\u52a8\u6001\u90e8\u4ef6\u5904\u7406\u5bf9\u8c61", (Object)strHandler));
        }
        return (IDynaCtrlHandler)ObjectHelper.create((String)strObject);
    }

    @Override
    public IDynaViewModel getDynaViewModel(String strAppViewId, boolean bTryMode) throws Exception {
        return null;
    }

    @Override
    public IDynaSysModel getDynaSysModel() {
        return (IDynaSysModel)super.getSystemModel();
    }

    public IAppDEViewModel getAppViewByDEViewId(String strDEViewId, boolean bTryMode) throws Exception {
        String strDynaInstId = WebContext.getDynaSysInstId(true);
        if (!StringHelper.isNullOrEmpty((String)strDynaInstId)) {
            String strPSAppViewId;
            IAppDEViewModel iAppDEViewModel = super.getAppViewByDEViewId(strDEViewId, true);
            if (iAppDEViewModel != null) {
                return iAppDEViewModel;
            }
            IDynaInstModel iDynaInstModel = this.getDynaSysModel().getDynaInstModel(strDynaInstId);
            iAppDEViewModel = (IAppDEViewModel)iDynaInstModel.getDynaAppViewModel(strPSAppViewId = KeyValueHelper.genUniqueId((String)this.getId(), (String)strDEViewId), true);
            if (iAppDEViewModel != null) {
                return iAppDEViewModel;
            }
            IPSAppView iPSAppView = this.getPSApplication().getPSAppView(strPSAppViewId, true);
            if (iPSAppView == null && !bTryMode) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u5b9e\u4f53\u89c6\u56fe[%1$s]", (Object)strDEViewId));
            }
            DynaAppDEViewModel appDEViewModel = new DynaAppDEViewModel();
            appDEViewModel.setId(iPSAppView.getId());
            appDEViewModel.setName(iPSAppView.getName());
            appDEViewModel.setTitle(iPSAppView.getTitle());
            appDEViewModel.setModuleName(iPSAppView.getPSAppModule().getCodeName());
            appDEViewModel.setOpenMode(iPSAppView.getOpenMode());
            if (iPSAppView.getHeight() > 0) {
                appDEViewModel.setHeight(iPSAppView.getHeight());
            }
            if (iPSAppView.getWidth() > 0) {
                appDEViewModel.setWidth(iPSAppView.getWidth());
            }
            iDynaInstModel.registerDynaAppViewModel(appDEViewModel);
            return appDEViewModel;
        }
        return super.getAppViewByDEViewId(strDEViewId, bTryMode);
    }
}

