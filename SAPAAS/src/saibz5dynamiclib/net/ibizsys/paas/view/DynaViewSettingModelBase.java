/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.controller.IDynaViewController
 *  net.ibizsys.paas.controller.IDynaViewControllerInst
 *  net.ibizsys.paas.core.ModelBase3Impl
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.ObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.view.IDynaViewSetting
 *  net.ibizsys.psrt.srv.dynasys.entity.DSDynaViewInst
 *  net.ibizsys.psrt.srv.dynasys.service.DSDynaViewInstService
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.view;

import net.ibizsys.paas.controller.IDynaViewController;
import net.ibizsys.paas.controller.IDynaViewControllerInst;
import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.IDynaSystemSettingModel;
import net.ibizsys.paas.util.ObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.IDynaViewSetting;
import net.ibizsys.paas.view.IDynaViewSettingModel;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaViewInst;
import net.ibizsys.psrt.srv.dynasys.service.DSDynaViewInstService;
import org.hibernate.SessionFactory;

public abstract class DynaViewSettingModelBase
extends ModelBase3Impl
implements IDynaViewSettingModel {
    private String strDynaViewDEName = null;
    private String strDynaViewInstDEName = null;
    private IDynaSystemSettingModel iDynaSystemSettingModel = null;

    @Override
    public void init(IDynaSystemSettingModel iDynaSystemSettingModel) throws Exception {
        this.iDynaSystemSettingModel = iDynaSystemSettingModel;
        this.onInit();
    }

    @Override
    public IDynaSystemSettingModel getDynaSystemSettingModel() {
        return this.iDynaSystemSettingModel;
    }

    @Override
    public IDynaViewControllerInst createDynaViewControllerInst(IDynaViewController iDynaViewController, String strDynaViewInstId) throws Exception {
        DSDynaViewInstService dsDynaViewInstService = (DSDynaViewInstService)ServiceGlobal.getService(DSDynaViewInstService.class, (SessionFactory)iDynaViewController.getSessionFactory());
        DSDynaViewInst dsDynaViewInst = new DSDynaViewInst();
        dsDynaViewInst.setDSDynaViewInstId(strDynaViewInstId);
        if (!dsDynaViewInstService.get((IEntity)dsDynaViewInst, true)) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u89c6\u56fe\u5b9e\u4f8b[%1$s]", (Object)strDynaViewInstId));
        }
        IDynaViewControllerInst iDynaViewControllerInst = null;
        iDynaViewControllerInst = !StringHelper.isNullOrEmpty((String)dsDynaViewInst.getViewInstObj()) ? (IDynaViewControllerInst)ObjectHelper.create((String)dsDynaViewInst.getViewInstObj()) : this.createDynaViewControllerInst(dsDynaViewInst);
        iDynaViewControllerInst.init(iDynaViewController, (IEntity)dsDynaViewInst, (IDynaViewSetting)this);
        return iDynaViewControllerInst;
    }

    protected IDynaViewControllerInst createDynaViewControllerInst(DSDynaViewInst dsDynaViewInst) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    public String getDynaViewDEName() {
        return this.strDynaViewDEName;
    }

    public void setDynaViewDEName(String strDynaViewDEName) {
        this.strDynaViewDEName = strDynaViewDEName;
    }

    public String getDynaViewInstDEName() {
        return this.strDynaViewInstDEName;
    }

    public void setDynaViewInstDEName(String strDynaViewInstDEName) {
        this.strDynaViewInstDEName = strDynaViewInstDEName;
    }
}

