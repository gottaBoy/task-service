/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.wfdesign.demodel.psworkflow.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="F1B33366-51F6-499D-AF6D-951EADC546BC", name="CurSys", queries={@DEDataSetQuery(queryid="CC60570A-3FAE-448C-871A-6F482241174E", queryname="CurSys")})
public abstract class PSWorkflowCurSysDSModelBase
extends DEDataSetModelBase {
    public PSWorkflowCurSysDSModelBase() {
        this.initAnnotation(PSWorkflowCurSysDSModelBase.class);
    }
}

