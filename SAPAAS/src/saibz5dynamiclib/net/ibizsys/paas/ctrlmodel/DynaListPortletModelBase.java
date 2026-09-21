/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.ctrlmodel.IListPortletModel
 */
package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.ctrlmodel.DynaPortletModelBase;
import net.ibizsys.paas.ctrlmodel.IListPortletModel;

public abstract class DynaListPortletModelBase
extends DynaPortletModelBase
implements IListPortletModel {
    public String getPortletType() {
        return "LIST";
    }
}

