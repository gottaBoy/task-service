/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcbktask.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="21B01249-CEA0-4897-8B98-B7448D1B3B49", name="CurRun", queries={@DEDataSetQuery(queryid="21B01249-CEA0-4897-8B98-B7448D1B3B49", queryname="CurRun")})
public abstract class PSDCBKTaskCurRunDSModelBase
extends DEDataSetModelBase {
    public PSDCBKTaskCurRunDSModelBase() {
        this.initAnnotation(PSDCBKTaskCurRunDSModelBase.class);
    }
}

