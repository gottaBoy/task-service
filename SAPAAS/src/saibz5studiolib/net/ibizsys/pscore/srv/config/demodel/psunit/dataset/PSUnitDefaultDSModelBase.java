/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psunit.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="71b6f441be3244db048e329610e230ba", name="DEFAULT", queries={@DEDataSetQuery(queryid="8AF74737-C39F-445E-9FFC-70D9746BE96F", queryname="DEFAULT")})
public abstract class PSUnitDefaultDSModelBase
extends DEDataSetModelBase {
    public PSUnitDefaultDSModelBase() {
        this.initAnnotation(PSUnitDefaultDSModelBase.class);
    }
}

