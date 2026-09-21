/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psmodelplugin.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="c154f701f55b1707d88c83776293dce8", name="DEFAULT", queries={@DEDataSetQuery(queryid="497221B6-0A09-45EA-BA43-AB97C4428B07", queryname="DEFAULT")})
public abstract class PSModelPluginDefaultDSModelBase
extends DEDataSetModelBase {
    public PSModelPluginDefaultDSModelBase() {
        this.initAnnotation(PSModelPluginDefaultDSModelBase.class);
    }
}

