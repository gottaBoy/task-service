/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.control.dashboard.IPortlet;
import net.ibizsys.paas.ctrlmodel.CtrlModelBase;
import net.ibizsys.paas.ctrlmodel.IDashboardModel;
import net.ibizsys.paas.ctrlmodel.IPortletModel;

public abstract class DashboardModelBase
extends CtrlModelBase
implements IDashboardModel {
    private double[] columnModels = null;
    private ArrayList<IPortlet> portletList = new ArrayList();

    @Override
    public double[] getColumnModels() {
        return this.columnModels;
    }

    protected void setColumnModels(double[] columnModels) {
        this.columnModels = columnModels;
    }

    @Override
    public Iterator<IPortlet> getPortlets() {
        return this.portletList.iterator();
    }

    protected void registerPortletModel(IPortletModel iPortlet) {
    }

    @Override
    public String getControlType() {
        return "DASHBOARD";
    }
}

