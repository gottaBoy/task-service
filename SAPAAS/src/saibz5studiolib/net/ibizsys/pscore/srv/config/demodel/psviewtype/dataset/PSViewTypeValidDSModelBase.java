/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psviewtype.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="BBB734D0-F094-4B47-A08C-417C19D93B05", name="Valid", queries={@DEDataSetQuery(queryid="2F73B935-46D1-4001-8A2D-4752F7E75332", queryname="Valid")})
public abstract class PSViewTypeValidDSModelBase
extends DEDataSetModelBase {
    public PSViewTypeValidDSModelBase() {
        this.initAnnotation(PSViewTypeValidDSModelBase.class);
    }
}

