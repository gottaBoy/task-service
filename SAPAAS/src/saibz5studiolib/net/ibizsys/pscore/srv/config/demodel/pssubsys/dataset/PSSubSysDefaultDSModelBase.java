/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssubsys.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="c7bb0325f1509f5b5e0bf9c3dd13e994", name="DEFAULT", queries={@DEDataSetQuery(queryid="A3254AF2-772A-4E06-9809-D1382D500C81", queryname="DEFAULT")})
public abstract class PSSubSysDefaultDSModelBase
extends DEDataSetModelBase {
    public PSSubSysDefaultDSModelBase() {
        this.initAnnotation(PSSubSysDefaultDSModelBase.class);
    }
}

