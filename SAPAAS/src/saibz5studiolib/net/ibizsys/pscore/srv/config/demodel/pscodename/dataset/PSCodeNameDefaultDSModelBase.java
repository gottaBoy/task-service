/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pscodename.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="ecf2bb472db2a5b83cfffaa3a813a839", name="DEFAULT", queries={@DEDataSetQuery(queryid="BDB125C5-A972-4078-8241-D1D6B67914BF", queryname="DEFAULT")})
public abstract class PSCodeNameDefaultDSModelBase
extends DEDataSetModelBase {
    public PSCodeNameDefaultDSModelBase() {
        this.initAnnotation(PSCodeNameDefaultDSModelBase.class);
    }
}

