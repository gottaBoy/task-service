/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pscounter.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="89c8a9e0cb4d586736fbc2530c12d3ef", name="DEFAULT", queries={@DEDataSetQuery(queryid="6554F863-DEF8-4085-AE5C-C6CFC8B0AC12", queryname="DEFAULT")})
public abstract class PSCounterDefaultDSModelBase
extends DEDataSetModelBase {
    public PSCounterDefaultDSModelBase() {
        this.initAnnotation(PSCounterDefaultDSModelBase.class);
    }
}

