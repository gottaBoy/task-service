/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psuienginetype.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="1A8BC87D-BBD2-49C7-B1E5-A05C2DC97B7B", name="Valid", queries={@DEDataSetQuery(queryid="1A8BC87D-BBD2-49C7-B1E5-A05C2DC97B7B", queryname="Valid")})
public abstract class PSUIEngineTypeValidDSModelBase
extends DEDataSetModelBase {
    public PSUIEngineTypeValidDSModelBase() {
        this.initAnnotation(PSUIEngineTypeValidDSModelBase.class);
    }
}

