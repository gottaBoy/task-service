/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssyspolicy.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="a921b98826f4fc3609a8a56957797dc6", name="DEFAULT", queries={@DEDataSetQuery(queryid="8061A3C6-B7BF-4B18-8CA9-4F04A588DBD3", queryname="DEFAULT")})
public abstract class PSSysPolicyDefaultDSModelBase
extends DEDataSetModelBase {
    public PSSysPolicyDefaultDSModelBase() {
        this.initAnnotation(PSSysPolicyDefaultDSModelBase.class);
    }
}

