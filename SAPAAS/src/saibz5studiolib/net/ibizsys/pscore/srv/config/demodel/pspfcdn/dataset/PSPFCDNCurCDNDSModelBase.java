/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pspfcdn.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="2FC3E387-881A-4038-9E3F-4E5A9BE52B9C", name="CurCDN", queries={@DEDataSetQuery(queryid="F4F0B897-B168-438D-B1D5-F7D93C759D2F", queryname="CurCDN"), @DEDataSetQuery(queryid="4DDEAD9D-04AD-41A8-BE37-A611966CCAF6", queryname="CurCDN2")})
public abstract class PSPFCDNCurCDNDSModelBase
extends DEDataSetModelBase {
    public PSPFCDNCurCDNDSModelBase() {
        this.initAnnotation(PSPFCDNCurCDNDSModelBase.class);
    }
}

