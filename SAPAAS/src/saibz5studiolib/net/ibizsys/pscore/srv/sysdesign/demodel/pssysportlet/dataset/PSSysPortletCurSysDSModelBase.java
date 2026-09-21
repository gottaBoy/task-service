/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysportlet.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="5D8F45D2-0CA4-4E81-AADA-8C1B68C62E88", name="CurSys", queries={@DEDataSetQuery(queryid="052FCF4E-FB7B-4B0D-B8D7-4BDAE83B738C", queryname="CurSys")})
public abstract class PSSysPortletCurSysDSModelBase
extends DEDataSetModelBase {
    public PSSysPortletCurSysDSModelBase() {
        this.initAnnotation(PSSysPortletCurSysDSModelBase.class);
    }
}

