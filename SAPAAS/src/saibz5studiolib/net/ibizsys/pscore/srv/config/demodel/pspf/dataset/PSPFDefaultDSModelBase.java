/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pspf.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="ffaf090276d78ad10a4d3bd584aeed56", name="DEFAULT", queries={@DEDataSetQuery(queryid="0EB42A3C-AEBD-4F4E-BFBD-6558D9FA96CA", queryname="DEFAULT")})
public abstract class PSPFDefaultDSModelBase
extends DEDataSetModelBase {
    public PSPFDefaultDSModelBase() {
        this.initAnnotation(PSPFDefaultDSModelBase.class);
    }
}

