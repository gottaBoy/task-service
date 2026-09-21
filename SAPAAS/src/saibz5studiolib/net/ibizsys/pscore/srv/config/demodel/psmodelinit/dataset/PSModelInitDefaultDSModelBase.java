/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psmodelinit.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="886984a72cf275c3fc04d6a78cbd628f", name="DEFAULT", queries={@DEDataSetQuery(queryid="F5568F34-FDB2-4773-A826-E42F0E39D4DE", queryname="DEFAULT")})
public abstract class PSModelInitDefaultDSModelBase
extends DEDataSetModelBase {
    public PSModelInitDefaultDSModelBase() {
        this.initAnnotation(PSModelInitDefaultDSModelBase.class);
    }
}

