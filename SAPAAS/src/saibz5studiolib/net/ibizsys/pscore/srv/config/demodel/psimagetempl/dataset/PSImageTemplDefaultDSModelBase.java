/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psimagetempl.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="8a3309bbdc9a2fdf34d4c111493557f8", name="DEFAULT", queries={@DEDataSetQuery(queryid="DC529F84-370F-4279-B2AD-A4551BCA597B", queryname="DEFAULT")})
public abstract class PSImageTemplDefaultDSModelBase
extends DEDataSetModelBase {
    public PSImageTemplDefaultDSModelBase() {
        this.initAnnotation(PSImageTemplDefaultDSModelBase.class);
    }
}

