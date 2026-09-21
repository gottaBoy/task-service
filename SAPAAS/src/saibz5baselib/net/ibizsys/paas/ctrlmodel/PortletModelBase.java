/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.ctrlmodel.ContainerModelBase;
import net.ibizsys.paas.ctrlmodel.IPortletModel;

public abstract class PortletModelBase
extends ContainerModelBase
implements IPortletModel {
    private String strTitle = null;

    @Override
    public String getTitle() {
        return this.strTitle;
    }

    protected void setTitle(String strTitle) {
        this.strTitle = strTitle;
    }

    @Override
    public String getControlType() {
        return "PORTLET";
    }
}

