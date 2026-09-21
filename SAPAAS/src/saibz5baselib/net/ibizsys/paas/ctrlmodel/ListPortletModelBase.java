/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.ctrlmodel.IListPortletModel;
import net.ibizsys.paas.ctrlmodel.PortletModelBase;

public abstract class ListPortletModelBase
extends PortletModelBase
implements IListPortletModel {
    @Override
    public String getPortletType() {
        return "LIST";
    }
}

