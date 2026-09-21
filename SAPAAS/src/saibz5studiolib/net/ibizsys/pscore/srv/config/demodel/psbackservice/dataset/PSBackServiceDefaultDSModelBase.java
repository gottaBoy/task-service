/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psbackservice.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="6faf31bfd6dbf2346650ee7b3d97e3be", name="DEFAULT", queries={@DEDataSetQuery(queryid="F50EF4EB-C2E2-41F4-A300-F3FBD7E70C05", queryname="DEFAULT")})
public abstract class PSBackServiceDefaultDSModelBase
extends DEDataSetModelBase {
    public PSBackServiceDefaultDSModelBase() {
        this.initAnnotation(PSBackServiceDefaultDSModelBase.class);
    }
}

