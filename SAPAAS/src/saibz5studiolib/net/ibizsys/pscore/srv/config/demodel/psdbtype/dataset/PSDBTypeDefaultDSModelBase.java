/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psdbtype.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="e4af9ae9f2662a5114f6072b273c178d", name="DEFAULT", queries={@DEDataSetQuery(queryid="B0C648D0-C628-4F0E-82AB-C620469BDA8F", queryname="DEFAULT")})
public abstract class PSDBTypeDefaultDSModelBase
extends DEDataSetModelBase {
    public PSDBTypeDefaultDSModelBase() {
        this.initAnnotation(PSDBTypeDefaultDSModelBase.class);
    }
}

