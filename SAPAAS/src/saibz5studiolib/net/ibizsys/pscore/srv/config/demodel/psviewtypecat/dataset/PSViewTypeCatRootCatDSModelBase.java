/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psviewtypecat.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="BDFEC236-C39B-4E53-8892-C4337EDC9D86", name="RootCat", queries={@DEDataSetQuery(queryid="FFF89926-F0C1-4BF2-A3B2-EA503FA0CA0A", queryname="RootCat")})
public abstract class PSViewTypeCatRootCatDSModelBase
extends DEDataSetModelBase {
    public PSViewTypeCatRootCatDSModelBase() {
        this.initAnnotation(PSViewTypeCatRootCatDSModelBase.class);
    }
}

