/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssfconfig.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="2e5ab4d4f9082ca3a35eac2629656833", name="DEFAULT", queries={@DEDataSetQuery(queryid="4F313362-E3A0-4331-887B-94521E6CD14A", queryname="DEFAULT")})
public abstract class PSSFConfigDefaultDSModelBase
extends DEDataSetModelBase {
    public PSSFConfigDefaultDSModelBase() {
        this.initAnnotation(PSSFConfigDefaultDSModelBase.class);
    }
}

