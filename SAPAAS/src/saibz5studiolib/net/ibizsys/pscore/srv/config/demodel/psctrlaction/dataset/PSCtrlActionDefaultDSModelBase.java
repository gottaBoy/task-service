/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psctrlaction.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="c3d60b68be3a80ab1118c989b05fa16b", name="DEFAULT", queries={@DEDataSetQuery(queryid="06A4425F-638F-4AFB-BA00-73385A212F7B", queryname="DEFAULT")})
public abstract class PSCtrlActionDefaultDSModelBase
extends DEDataSetModelBase {
    public PSCtrlActionDefaultDSModelBase() {
        this.initAnnotation(PSCtrlActionDefaultDSModelBase.class);
    }
}

