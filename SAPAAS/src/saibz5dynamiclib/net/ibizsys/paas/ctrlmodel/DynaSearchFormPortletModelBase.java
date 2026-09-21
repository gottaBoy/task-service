/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.ctrlmodel.ISearchFormPortletModel
 */
package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.ctrlmodel.DynaPortletModelBase;
import net.ibizsys.paas.ctrlmodel.ISearchFormPortletModel;

public abstract class DynaSearchFormPortletModelBase
extends DynaPortletModelBase
implements ISearchFormPortletModel {
    public String getPortletType() {
        return "SEARCHFORM";
    }
}

