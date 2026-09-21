/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psvarsamplevalue.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="E19DBF5E-F630-43E1-A9E0-921FB2FB7990", name="FormVar", queries={@DEDataSetQuery(queryid="E19DBF5E-F630-43E1-A9E0-921FB2FB7990", queryname="FormVar")})
public abstract class PSVarSampleValueFormVarDSModelBase
extends DEDataSetModelBase {
    public PSVarSampleValueFormVarDSModelBase() {
        this.initAnnotation(PSVarSampleValueFormVarDSModelBase.class);
    }
}

