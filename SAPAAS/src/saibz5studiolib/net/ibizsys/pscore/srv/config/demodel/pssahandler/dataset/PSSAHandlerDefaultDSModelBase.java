/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssahandler.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="7f5aa6e2804399b01d1c07fd19195709", name="DEFAULT", queries={@DEDataSetQuery(queryid="75C0E4BC-7D86-4C53-A6C1-1F181CA984B8", queryname="DEFAULT")})
public abstract class PSSAHandlerDefaultDSModelBase
extends DEDataSetModelBase {
    public PSSAHandlerDefaultDSModelBase() {
        this.initAnnotation(PSSAHandlerDefaultDSModelBase.class);
    }
}

