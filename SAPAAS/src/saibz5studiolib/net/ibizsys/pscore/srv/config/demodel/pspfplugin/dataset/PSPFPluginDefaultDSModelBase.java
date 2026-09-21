/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pspfplugin.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="ae0633e37620882d6a5e815773533d9c", name="DEFAULT", queries={@DEDataSetQuery(queryid="17BBA279-12A7-4CED-BFC0-E725DD5EA77A", queryname="DEFAULT")})
public abstract class PSPFPluginDefaultDSModelBase
extends DEDataSetModelBase {
    public PSPFPluginDefaultDSModelBase() {
        this.initAnnotation(PSPFPluginDefaultDSModelBase.class);
    }
}

