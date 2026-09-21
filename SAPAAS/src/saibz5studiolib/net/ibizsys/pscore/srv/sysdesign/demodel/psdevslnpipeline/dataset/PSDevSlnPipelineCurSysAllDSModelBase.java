/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevslnpipeline.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="E0BD9C07-E402-4AA3-A733-975331A8233C", name="CurSysAll", queries={@DEDataSetQuery(queryid="829B4832-C231-44A1-B5B9-CF35EF4C7A28", queryname="CurSlnNotSys"), @DEDataSetQuery(queryid="FC6D71BB-D19B-4A4C-AED5-211758887647", queryname="CurSys")})
public abstract class PSDevSlnPipelineCurSysAllDSModelBase
extends DEDataSetModelBase {
    public PSDevSlnPipelineCurSysAllDSModelBase() {
        this.initAnnotation(PSDevSlnPipelineCurSysAllDSModelBase.class);
    }
}

