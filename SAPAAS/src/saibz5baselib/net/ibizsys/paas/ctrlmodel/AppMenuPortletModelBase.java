/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.ctrlmodel.IAppMenuPortletModel;
import net.ibizsys.paas.ctrlmodel.PortletModelBase;

public abstract class AppMenuPortletModelBase
extends PortletModelBase
implements IAppMenuPortletModel {
    @Override
    public String getPortletType() {
        return "APPMENU";
    }
}

