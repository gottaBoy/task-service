/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.PageContext
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.web;

import javax.servlet.jsp.PageContext;
import net.ibizsys.paas.appmodel.IApplicationModel;
import net.ibizsys.paas.controller.IDynaViewController;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.controller.ViewControllerGlobal;
import net.ibizsys.paas.ctrlmodel.IAppMenuModel;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.Page;
import net.sf.json.JSONObject;

public class VCPage
extends Page {
    private static final JSONObject EMPTYJSON = new JSONObject();
    private IViewController iViewController = null;

    public final boolean init(PageContext context, String strViewControllerId) throws Exception {
        if (this.iViewController == null) {
            this.iViewController = ViewControllerGlobal.getViewController(strViewControllerId);
            this.iViewController.prepareViewController();
            this.setAccessUserMode(this.iViewController.getAccessUserMode());
            this.setAccessKey(this.iViewController.getAccessKey());
        }
        boolean bRet = this.init(context);
        if (this.iViewController instanceof IDynaViewController && ((IDynaViewController)this.iViewController).isEnableDynaView()) {
            ((IDynaViewController)this.iViewController).prepareDynaViewControllerInst();
        }
        return bRet;
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    public IViewController getViewController() {
        return this.iViewController;
    }

    public IAppMenuModel getAppMenuModel() throws Exception {
        return this.getApplicationModel().getAppMenuModel(this.getWebContext().getCurUserMode());
    }

    public ICtrlModel getCtrlModel(String strName) throws Exception {
        return this.getViewController().getCtrlModel(strName);
    }

    public JSONObject getParentData() {
        String strParentData = this.getWebContext().getParamValue("SRFPARENTDATA");
        if (!StringHelper.isNullOrEmpty(strParentData)) {
            return JSONObjectHelper.fromString(strParentData);
        }
        return EMPTYJSON;
    }

    public JSONObject getParentMode() {
        String strParentMode = this.getWebContext().getParamValue("SRFPARENTMODE");
        if (!StringHelper.isNullOrEmpty(strParentMode)) {
            return JSONObjectHelper.fromString(strParentMode);
        }
        return EMPTYJSON;
    }

    @Override
    protected IApplicationModel getApplicationModel() throws Exception {
        return this.getViewController().getAppModel();
    }

    @Override
    protected String mapRealPageUrl(String strPageUrl) throws Exception {
        if (strPageUrl.charAt(0) == '/') {
            return "../.." + strPageUrl;
        }
        return strPageUrl;
    }

    public boolean testDEDataAccessAction(String strAction) throws Exception {
        return this.getViewController().testDEDataAccessAction(null, null, strAction, true).getRetCode() == 0;
    }

    @Override
    public boolean isShowAction(String strActionPrivTag) throws Exception {
        String strDataTarget;
        if (!StringHelper.isNullOrEmpty(strActionPrivTag) && StringHelper.compare(strDataTarget = this.getViewController().getDEModel().getDEOPPrivTarget(strActionPrivTag), "NONE", false) == 0) {
            return this.testDEDataAccessAction(strActionPrivTag);
        }
        return super.isShowAction(strActionPrivTag);
    }

    public static VCPage getCurrentVCPage() {
        return (VCPage)Page.getCurrent();
    }
}

