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

@DEDataSet(id="5D27CCFD-9C41-4BE5-AC7C-752681754668", name="SysVar", queries={@DEDataSetQuery(queryid="5D27CCFD-9C41-4BE5-AC7C-752681754668", queryname="SysVar")})
public abstract class PSVarSampleValueSysVarDSModelBase
extends DEDataSetModelBase {
    public PSVarSampleValueSysVarDSModelBase() {
        this.initAnnotation(PSVarSampleValueSysVarDSModelBase.class);
    }
}

