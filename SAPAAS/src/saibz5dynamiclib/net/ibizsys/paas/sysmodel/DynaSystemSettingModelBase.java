/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.controller.IDynaViewController
 *  net.ibizsys.paas.controller.IDynaViewControllerInst
 *  net.ibizsys.paas.core.ModelBaseImpl
 *  net.ibizsys.paas.sysmodel.ISystemModel
 *  net.ibizsys.paas.util.StringHelper
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.sysmodel;

import java.util.HashMap;
import net.ibizsys.paas.controller.IDynaViewController;
import net.ibizsys.paas.controller.IDynaViewControllerInst;
import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.sysmodel.IDynaInst;
import net.ibizsys.paas.sysmodel.IDynaSystemSettingModel;
import net.ibizsys.paas.sysmodel.IDynaSystemStorage;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.IDynaViewSettingModel;
import org.hibernate.SessionFactory;

public abstract class DynaSystemSettingModelBase
extends ModelBaseImpl
implements IDynaSystemSettingModel {
    private String strDynaInstId = null;
    private SessionFactory sessionFactory = null;
    private ISystemModel iSystemModel = null;
    private HashMap<String, IDynaInst> dynaInstMap = new HashMap();

    @Override
    public void init(ISystemModel iSystemModel) throws Exception {
        this.iSystemModel = iSystemModel;
        this.onInit();
    }

    @Override
    public ISystemModel getSystemModel() {
        return this.iSystemModel;
    }

    public String getDynaInstId() {
        return this.strDynaInstId;
    }

    protected void setDynaInstId(String strDynaInstId) {
        this.strDynaInstId = strDynaInstId;
    }

    public IDynaViewControllerInst createDynaViewControllerInst(IDynaViewController iDynaViewController, String strDynaViewInstId) throws Exception {
        return this.getDynaViewSettingModel().createDynaViewControllerInst(iDynaViewController, strDynaViewInstId);
    }

    protected abstract IDynaSystemStorage getDynaSystemStorage() throws Exception;

    public void syncAll() throws Exception {
        this.getDynaSystemStorage().syncAll();
    }

    @Override
    public void syncAllViews() throws Exception {
        this.getDynaSystemStorage().syncAllViews();
    }

    @Override
    public void syncAllWorkflows() throws Exception {
        this.getDynaSystemStorage().syncAllWorkflows();
    }

    @Override
    public void syncView(String strViewId) throws Exception {
        this.getDynaSystemStorage().syncView(strViewId);
    }

    @Override
    public void syncWorkflow(String strWorkflowId) throws Exception {
        this.getDynaSystemStorage().syncWorkflow(strWorkflowId);
    }

    public IDynaViewSettingModel getDynaViewSettingModel() {
        return (IDynaViewSettingModel)this.getDynaViewSetting();
    }

    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    protected void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void installAll() throws Exception {
        this.getDynaSystemStorage().installAll();
    }

    @Override
    public IDynaInst getDynaInst(String strDynaSystemId, boolean bTryMode) throws Exception {
        IDynaInst iDynaInst = this.dynaInstMap.get(strDynaSystemId);
        if (iDynaInst == null && !bTryMode) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u52a8\u6001\u7cfb\u7edf\u5b9e\u4f8b\u5bf9\u8c61, \u6807\u8bc6\u4e3a[%1$s]", (Object)strDynaSystemId));
        }
        return iDynaInst;
    }

    protected void registerDynaInst(IDynaInst iDynaInst) {
        this.dynaInstMap.put(iDynaInst.getId(), iDynaInst);
    }
}

