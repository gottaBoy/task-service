/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.ctrlmodel.ISearchFormPortletModel;
import net.ibizsys.paas.ctrlmodel.PortletModelBase;

public abstract class SearchFormPortletModelBase
extends PortletModelBase
implements ISearchFormPortletModel {
    @Override
    public String getPortletType() {
        return "SEARCHFORM";
    }
}

