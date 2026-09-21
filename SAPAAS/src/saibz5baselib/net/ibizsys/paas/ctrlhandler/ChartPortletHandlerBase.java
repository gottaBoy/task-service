/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlhandler.IPortletHandler;
import net.ibizsys.paas.ctrlhandler.PortletHandlerBase;
import net.ibizsys.paas.ctrlmodel.IChartPortletModel;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.ctrlmodel.IPortletModel;

public abstract class ChartPortletHandlerBase
extends PortletHandlerBase
implements IPortletHandler {
    @Override
    protected abstract IPortletModel getPortletModel();

    @Override
    public ICtrlModel getCtrlModel() {
        return this.getPortletModel();
    }

    protected IChartPortletModel getChartPortletModel() {
        return (IChartPortletModel)this.getPortletModel();
    }
}

