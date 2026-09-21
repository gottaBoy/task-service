/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.ctrlmodel.IAppMenuPortletModel
 */
package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.ctrlmodel.DynaPortletModelBase;
import net.ibizsys.paas.ctrlmodel.IAppMenuPortletModel;

public abstract class DynaAppMenuPortletModelBase
extends DynaPortletModelBase
implements IAppMenuPortletModel {
    public String getPortletType() {
        return "APPMENU";
    }
}

