/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssyssearchbaritem.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="030F873F-362E-4D77-AF45-5B42164E6A48", name="QuickSearch", queries={@DEDataSetQuery(queryid="030F873F-362E-4D77-AF45-5B42164E6A48", queryname="QuickSearch")})
public abstract class PSSysSearchBarItemQuickSearchDSModelBase
extends DEDataSetModelBase {
    public PSSysSearchBarItemQuickSearchDSModelBase() {
        this.initAnnotation(PSSysSearchBarItemQuickSearchDSModelBase.class);
    }
}

