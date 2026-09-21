/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psdeftype.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="d1c50fe12e6439c09e2b2c9aa8cf2ee9", name="DEFAULT", queries={@DEDataSetQuery(queryid="F01916C7-9963-4984-B361-95AC6184FD56", queryname="DEFAULT")})
public abstract class PSDEFTypeDefaultDSModelBase
extends DEDataSetModelBase {
    public PSDEFTypeDefaultDSModelBase() {
        this.initAnnotation(PSDEFTypeDefaultDSModelBase.class);
    }
}

