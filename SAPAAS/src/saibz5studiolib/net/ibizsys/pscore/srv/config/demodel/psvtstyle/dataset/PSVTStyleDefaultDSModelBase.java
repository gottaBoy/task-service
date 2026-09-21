/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psvtstyle.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="790d92ec59b46bd6a0147dc2a53eddc2", name="DEFAULT", queries={@DEDataSetQuery(queryid="CCA82F30-DC89-42A3-8EA2-9690A8C4ADD1", queryname="DEFAULT")})
public abstract class PSVTStyleDefaultDSModelBase
extends DEDataSetModelBase {
    public PSVTStyleDefaultDSModelBase() {
        this.initAnnotation(PSVTStyleDefaultDSModelBase.class);
    }
}

