/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pscountertype.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="9fed1fa4d86090aaa62e81ed4b51114f", name="DEFAULT", queries={@DEDataSetQuery(queryid="F8D179EF-9612-409F-BCA8-046198F963B2", queryname="DEFAULT")})
public abstract class PSCounterTypeDefaultDSModelBase
extends DEDataSetModelBase {
    public PSCounterTypeDefaultDSModelBase() {
        this.initAnnotation(PSCounterTypeDefaultDSModelBase.class);
    }
}

