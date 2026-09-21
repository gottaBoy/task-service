/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeviewctrl.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="E00C492E-A8BC-41F6-AD05-19CDE47275A5", name="CurView", queries={@DEDataSetQuery(queryid="A1DE6205-4AED-4E98-896B-23105479C91B", queryname="CurView")})
public abstract class PSDEViewCtrlCurViewDSModelBase
extends DEDataSetModelBase {
    public PSDEViewCtrlCurViewDSModelBase() {
        this.initAnnotation(PSDEViewCtrlCurViewDSModelBase.class);
    }
}

