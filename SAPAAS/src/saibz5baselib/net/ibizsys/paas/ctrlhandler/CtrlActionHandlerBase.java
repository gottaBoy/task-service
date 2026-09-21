/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlhandler.ICtrlActionHandler;
import net.ibizsys.paas.ctrlhandler.ICtrlHandler;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.web.IWebContext;
import org.hibernate.SessionFactory;

public abstract class CtrlActionHandlerBase
implements ICtrlActionHandler {
    private ICtrlHandler iCtrlHandler = null;

    @Override
    public void init(ICtrlHandler iCtrlHandler) throws Exception {
        this.iCtrlHandler = iCtrlHandler;
    }

    protected ICtrlHandler getCtrlHandler() {
        return this.iCtrlHandler;
    }

    protected ICtrlModel getCtrlModel() {
        return this.getCtrlHandler().getCtrlModel();
    }

    protected ISystemModel getSystemModel() {
        return this.getCtrlHandler().getViewController().getSystemModel();
    }

    protected IDataEntityModel getDEModel() {
        if (this.getCtrlModel() != null && this.getCtrlModel().getDEModel() != null) {
            return this.getCtrlModel().getDEModel();
        }
        return this.getCtrlHandler().getViewController().getDEModel();
    }

    protected IWebContext getWebContext() {
        return this.getCtrlHandler().getWebContext();
    }

    protected SessionFactory getSessionFactory() {
        return this.getCtrlHandler().getSessionFactory();
    }

    protected int getTempMode() {
        return this.getCtrlHandler().getTempMode();
    }
}

