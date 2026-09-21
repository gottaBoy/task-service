/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlhandler.IPortletHandler;
import net.ibizsys.paas.ctrlhandler.PortletHandlerBase;
import net.ibizsys.paas.ctrlmodel.IAppMenuPortletModel;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.ctrlmodel.IPortletModel;

public abstract class AppMenuPortletHandlerBase
extends PortletHandlerBase
implements IPortletHandler {
    @Override
    protected abstract IPortletModel getPortletModel();

    @Override
    public ICtrlModel getCtrlModel() {
        return this.getPortletModel();
    }

    protected IAppMenuPortletModel getAppMenuPortletModel() {
        return (IAppMenuPortletModel)this.getPortletModel();
    }
}

