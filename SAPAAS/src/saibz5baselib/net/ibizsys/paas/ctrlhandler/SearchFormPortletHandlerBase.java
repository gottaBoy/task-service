/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlhandler.IPortletHandler;
import net.ibizsys.paas.ctrlhandler.PortletHandlerBase;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.ctrlmodel.IPortletModel;
import net.ibizsys.paas.ctrlmodel.ISearchFormPortletModel;

public abstract class SearchFormPortletHandlerBase
extends PortletHandlerBase
implements IPortletHandler {
    @Override
    protected abstract IPortletModel getPortletModel();

    @Override
    public ICtrlModel getCtrlModel() {
        return this.getPortletModel();
    }

    protected ISearchFormPortletModel getSearchFormPortletModel() {
        return (ISearchFormPortletModel)this.getPortletModel();
    }
}

